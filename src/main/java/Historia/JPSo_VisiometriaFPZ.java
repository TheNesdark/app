package Historia;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Historia/JPSo_VisiometriaFPZ.class */
public class JPSo_VisiometriaFPZ extends JPanel {
    private Object[] xdatos;
    private String xsql;
    private DefaultTableModel xmodelo;
    private String[] xidResultado;
    private ButtonGroup JBForiaLateral1;
    private ButtonGroup JBForiaLateral2;
    private ButtonGroup JBForiaVertical1;
    private ButtonGroup JBForiaVertical2;
    private ButtonGroup JBG10_VCOIzquierdo;
    private ButtonGroup JBG1_VLAOjos;
    private ButtonGroup JBG2_VLODerecho;
    private ButtonGroup JBG3_VLODerecho;
    private ButtonGroup JBG8_VCAOjos;
    private ButtonGroup JBG9_VCODerecho;
    private ButtonGroup JBGTCorreccion;
    private ButtonGroup JBGTGafas;
    private ButtonGroup JBGTLentes;
    private JButton JBGuardarInter;
    private JButton JBTActualizar;
    private JButton JBTGrabar;
    private JComboBox JCBResultado;
    private JCheckBox JCHA1;
    private JCheckBox JCHA10;
    private JCheckBox JCHA11;
    private JCheckBox JCHA12;
    private JCheckBox JCHA2;
    private JCheckBox JCHA3;
    private JCheckBox JCHA4;
    private JCheckBox JCHA5;
    private JCheckBox JCHA6;
    private JCheckBox JCHA7;
    private JCheckBox JCHA8;
    private JCheckBox JCHA9;
    private JCheckBox JCHBAOjos;
    private JCheckBox JCHBAOjos1;
    private JCheckBox JCHBAOjos10;
    private JCheckBox JCHBAOjos11;
    private JCheckBox JCHBAOjos12;
    private JCheckBox JCHBAOjos3;
    private JCheckBox JCHBAOjos4;
    private JCheckBox JCHBAOjos5;
    private JCheckBox JCHBAOjos6;
    private JCheckBox JCHBAOjos7;
    private JCheckBox JCHBAOjos8;
    private JCheckBox JCHBAOjos9;
    private JCheckBox JCHBC;
    private JCheckBox JCHBC1;
    private JCheckBox JCHBC5;
    private JCheckBox JCHBC6;
    private JCheckBox JCHBC7;
    private JCheckBox JCHBC8;
    private JCheckBox JCHBDerecho;
    private JCheckBox JCHBDerecho1;
    private JCheckBox JCHBDerecho10;
    private JCheckBox JCHBDerecho11;
    private JCheckBox JCHBDerecho2;
    private JCheckBox JCHBDerecho3;
    private JCheckBox JCHBDerecho4;
    private JCheckBox JCHBDerecho5;
    private JCheckBox JCHBDerecho6;
    private JCheckBox JCHBDerecho7;
    private JCheckBox JCHBDerecho8;
    private JCheckBox JCHBDerecho9;
    private JCheckBox JCHBEs;
    private JCheckBox JCHBEs1;
    private JCheckBox JCHBEs2;
    private JCheckBox JCHBEs3;
    private JCheckBox JCHBEs4;
    private JCheckBox JCHBEs5;
    private JCheckBox JCHBEs6;
    private JCheckBox JCHBEs7;
    private JCheckBox JCHBEs8;
    private JPanel JCHBFL;
    private JCheckBox JCHBFLa;
    private JCheckBox JCHBFLa1;
    private JCheckBox JCHBFLa10;
    private JCheckBox JCHBFLa11;
    private JCheckBox JCHBFLa12;
    private JCheckBox JCHBFLa13;
    private JCheckBox JCHBFLa14;
    private JCheckBox JCHBFLa2;
    private JCheckBox JCHBFLa3;
    private JCheckBox JCHBFLa4;
    private JCheckBox JCHBFLa5;
    private JCheckBox JCHBFLa6;
    private JCheckBox JCHBFLa7;
    private JCheckBox JCHBFLa8;
    private JCheckBox JCHBFLa9;
    private JCheckBox JCHBFV;
    private JCheckBox JCHBFV1;
    private JCheckBox JCHBFV2;
    private JCheckBox JCHBFV3;
    private JCheckBox JCHBFV4;
    private JCheckBox JCHBFV5;
    private JCheckBox JCHBFV6;
    private JCheckBox JCHBIzquierdo;
    private JCheckBox JCHBIzquierdo1;
    private JCheckBox JCHBIzquierdo10;
    private JCheckBox JCHBIzquierdo11;
    private JCheckBox JCHBIzquierdo2;
    private JCheckBox JCHBIzquierdo3;
    private JCheckBox JCHBIzquierdo4;
    private JCheckBox JCHBIzquierdo5;
    private JCheckBox JCHBIzquierdo6;
    private JCheckBox JCHBIzquierdo7;
    private JCheckBox JCHBIzquierdo8;
    private JCheckBox JCHBIzquierdo9;
    private JCheckBox JCHBVCLateral;
    private JCheckBox JCHBVCLateral10;
    private JCheckBox JCHBVCLateral11;
    private JCheckBox JCHBVCLateral12;
    private JCheckBox JCHBVCLateral13;
    private JCheckBox JCHBVCLateral14;
    private JCheckBox JCHBVCLateral15;
    private JCheckBox JCHBVCLateral2;
    private JCheckBox JCHBVCLateral3;
    private JCheckBox JCHBVCLateral4;
    private JCheckBox JCHBVCLateral5;
    private JCheckBox JCHBVCLateral6;
    private JCheckBox JCHBVCLateral7;
    private JCheckBox JCHBVCLateral8;
    private JCheckBox JCHBVCLateral9;
    private JCheckBox JCHD1;
    private JCheckBox JCHD10;
    private JCheckBox JCHD11;
    private JCheckBox JCHD12;
    private JCheckBox JCHD2;
    private JCheckBox JCHD3;
    private JCheckBox JCHD4;
    private JCheckBox JCHD5;
    private JCheckBox JCHD6;
    private JCheckBox JCHD7;
    private JCheckBox JCHD8;
    private JCheckBox JCHD9;
    private JCheckBox JCHDGLentesC;
    private JCheckBox JCHDGSLentesF;
    private JCheckBox JCHI1;
    private JCheckBox JCHI10;
    private JCheckBox JCHI11;
    private JCheckBox JCHI12;
    private JCheckBox JCHI2;
    private JCheckBox JCHI3;
    private JCheckBox JCHI4;
    private JCheckBox JCHI5;
    private JCheckBox JCHI6;
    private JCheckBox JCHI7;
    private JCheckBox JCHI8;
    private JCheckBox JCHI9;
    private JCheckBox JCHTCCerca;
    private JCheckBox JCHTCLejos;
    private JLabel JLB1;
    private JLabel JLB10;
    private JLabel JLB10_VCClasificacion;
    private JLabel JLB10_VCResultado;
    private JLabel JLB11;
    private JLabel JLB11_VCFLaClasificacion;
    private JLabel JLB12;
    private JPanel JLB12_VCFVClasificacion;
    private JLabel JLB13;
    private JLabel JLB14;
    private JLabel JLB15;
    private JLabel JLB16;
    private JLabel JLB17;
    private JLabel JLB18;
    private JLabel JLB19;
    private JLabel JLB1_VLRClasificacion;
    private JLabel JLB1_VLResultado;
    private JLabel JLB2;
    private JLabel JLB20;
    private JLabel JLB21;
    private JLabel JLB22;
    private JLabel JLB23;
    private JLabel JLB24;
    private JLabel JLB2_VLRClasificacion;
    private JLabel JLB2_VLResultado;
    private JLabel JLB3;
    private JLabel JLB3_VLRClasificacion;
    private JLabel JLB3_VLResultado;
    private JLabel JLB4;
    private JLabel JLB4_VLRClasificacion;
    private JLabel JLB5;
    private JLabel JLB5_VLRClasificacion;
    private JLabel JLB6;
    private JLabel JLB6_VLRClasificacion;
    private JLabel JLB7;
    private JLabel JLB7_VLRClasificacion;
    private JLabel JLB8;
    private JLabel JLB8_VCRClasificacion;
    private JLabel JLB8_VCResultado;
    private JLabel JLB9;
    private JLabel JLB9_VCDClasificacion;
    private JLabel JLB9_VCDResultado;
    private JLabel JLBA1;
    private JLabel JLBA10;
    private JLabel JLBA11;
    private JLabel JLBA12;
    private JLabel JLBA2;
    private JLabel JLBA3;
    private JLabel JLBA4;
    private JLabel JLBA5;
    private JLabel JLBA6;
    private JLabel JLBA7;
    private JLabel JLBA8;
    private JLabel JLBA9;
    private JLabel JLBD1;
    private JLabel JLBD10;
    private JLabel JLBD11;
    private JLabel JLBD12;
    private JLabel JLBD2;
    private JLabel JLBD3;
    private JLabel JLBD4;
    private JLabel JLBD5;
    private JLabel JLBD6;
    private JLabel JLBD7;
    private JLabel JLBD8;
    private JLabel JLBD9;
    private JLabel JLBI1;
    private JLabel JLBI10;
    private JLabel JLBI11;
    private JLabel JLBI12;
    private JLabel JLBI13;
    private JLabel JLBI14;
    private JLabel JLBI15;
    private JLabel JLBI16;
    private JLabel JLBI17;
    private JLabel JLBI18;
    private JLabel JLBI19;
    private JLabel JLBI2;
    private JLabel JLBI20;
    private JLabel JLBI21;
    private JLabel JLBI3;
    private JLabel JLBI4;
    private JLabel JLBI5;
    private JLabel JLBI6;
    private JLabel JLBI7;
    private JLabel JLBI8;
    private JLabel JLBI9;
    private JPanel JPI10_VCIzquierdo;
    private JPanel JPI11_VCFLateral;
    private JPanel JPI1_VLAOjos;
    private JPanel JPI2_ODerecho;
    private JPanel JPI3_OIzquierdo;
    private JPanel JPI4_Estereopsis;
    private JPanel JPI5_Color;
    private JPanel JPI6_FVertical;
    private JPanel JPI7_FLateral;
    private JPanel JPI8_VCAOjos;
    private JPanel JPI9_VCDerecho;
    private JPanel JPIDatosGenerales;
    private JPanel JPINumeros;
    private JPanel JPINumeros1;
    private JPanel JPITCorrecion;
    private JPanel JPITipoGafas;
    private JPanel JPITipoLentes;
    private JPanel JPIUsoCorrecion;
    private JPanel JPInterpretacion;
    private JRadioButton JRBDGTCEsporadico;
    private JRadioButton JRBDGTCNinguna;
    private JRadioButton JRBDGTCPermanente;
    private JRadioButton JRBDGTGNinguna;
    private JRadioButton JRBDGTGPersonal;
    private JRadioButton JRBDGTGSeguridad;
    private JRadioButton JRBDGTLBifocales;
    private JRadioButton JRBDGTLMonofocales;
    private JRadioButton JRBDGTLNinguno;
    private JRadioButton JRBDGTLProgresivo;
    private JScrollPane JSPHistorico;
    private JTextArea JTAInterpretacion;
    private JTextArea JTAObsVisiometria;
    public JTable JTDetalleHistorico;
    private JTabbedPane JTPDatosTest;
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
    private JLabel jLabel45;
    private JLabel jLabel46;
    private JLabel jLabel47;
    private JLabel jLabel5;
    private JLabel jLabel50;
    private JLabel jLabel51;
    private JLabel jLabel52;
    private JLabel jLabel55;
    private JLabel jLabel56;
    private JLabel jLabel57;
    private JLabel jLabel58;
    private JLabel jLabel59;
    private JLabel jLabel6;
    private JLabel jLabel60;
    private JLabel jLabel61;
    private JLabel jLabel62;
    private JLabel jLabel63;
    private JLabel jLabel64;
    private JLabel jLabel65;
    private JLabel jLabel66;
    private JLabel jLabel67;
    private JLabel jLabel68;
    private JLabel jLabel69;
    private JLabel jLabel7;
    private JLabel jLabel70;
    private JLabel jLabel71;
    private JLabel jLabel72;
    private JLabel jLabel73;
    private JLabel jLabel74;
    private JLabel jLabel75;
    private JLabel jLabel76;
    private JLabel jLabel77;
    private JLabel jLabel78;
    private JLabel jLabel79;
    private JLabel jLabel8;
    private JLabel jLabel80;
    private JLabel jLabel81;
    private JLabel jLabel9;
    private JPanel jPanel1;
    private JScrollPane jScrollPane3;
    private JScrollPane jScrollPane4;
    private ConsultasMySQL xct = new ConsultasMySQL();
    private Metodos xmt = new Metodos();
    private String xdglformulados = "No";
    private String xdgtipogafas = "Ninguna";
    private String xdgtipolentes = "Ninguno";
    private String xdgtipocorrecion = "Ninguna";
    private int x3e = 0;
    private int x5c = 0;
    private int x6fv = 0;
    private int x7fl = 0;
    private int x11fl = 0;
    private int x12fv = 0;
    private int xdglentesc = 0;
    private int xtcorrecion = 0;
    private int xcolor = 0;
    private int xsumaColor = 0;
    private int xColorA = 0;
    private int xColorB = 0;
    private int xColorC = 0;
    private int xColorD = 0;
    private int xColorE = 0;
    private int xColorF = 0;
    private int xEst1 = 0;
    private int xEst2 = 0;
    private int xEst3 = 0;
    private int xEst4 = 0;
    private int xEst5 = 0;
    private int xEst6 = 0;
    private int xEst7 = 0;
    private int xEst8 = 0;
    private int xEst9 = 0;
    private int xestereopsis = 0;
    private long xexistencia = 0;
    private long xidVisio = 0;

    public JPSo_VisiometriaFPZ() {
        initComponents();
        this.xidResultado = this.xct.llenarCombo("SELECT `Id`, `Nbre` FROM `h_so_resultado` WHERE (`Estado` =1 AND TipoExamen=6) ORDER BY `Nbre` ASC;", this.xidResultado, this.JCBResultado);
        this.JCBResultado.setSelectedIndex(-1);
        mBuscar();
        mCargarDatosTablaHistorico();
        if (Principal.informacionIps.getIdentificacion().equals("901420803")) {
            cambiarNumeracionTextoValleDelSol();
        }
    }

    /* JADX WARN: Type inference failed for: r3v1377, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBG1_VLAOjos = new ButtonGroup();
        this.JBG2_VLODerecho = new ButtonGroup();
        this.JBG3_VLODerecho = new ButtonGroup();
        this.JBG8_VCAOjos = new ButtonGroup();
        this.JBG9_VCODerecho = new ButtonGroup();
        this.JBG10_VCOIzquierdo = new ButtonGroup();
        this.JBGTGafas = new ButtonGroup();
        this.JBGTLentes = new ButtonGroup();
        this.JBGTCorreccion = new ButtonGroup();
        this.JBForiaVertical1 = new ButtonGroup();
        this.JBForiaLateral1 = new ButtonGroup();
        this.JBForiaLateral2 = new ButtonGroup();
        this.JBForiaVertical2 = new ButtonGroup();
        this.JTPDatosTest = new JTabbedPane();
        this.JCHBFL = new JPanel();
        this.JPI1_VLAOjos = new JPanel();
        this.jLabel2 = new JLabel();
        this.JCHA1 = new JCheckBox();
        this.JLBA1 = new JLabel();
        this.JCHA2 = new JCheckBox();
        this.JLBA2 = new JLabel();
        this.JCHA3 = new JCheckBox();
        this.JLBA3 = new JLabel();
        this.JLBA4 = new JLabel();
        this.JCHA4 = new JCheckBox();
        this.JLBA5 = new JLabel();
        this.JCHA5 = new JCheckBox();
        this.JLBA6 = new JLabel();
        this.JCHA6 = new JCheckBox();
        this.JLBA7 = new JLabel();
        this.JCHA7 = new JCheckBox();
        this.JLBA8 = new JLabel();
        this.JCHA8 = new JCheckBox();
        this.JLBA9 = new JLabel();
        this.JCHA9 = new JCheckBox();
        this.JLBA10 = new JLabel();
        this.JCHA10 = new JCheckBox();
        this.JLBA11 = new JLabel();
        this.JCHA11 = new JCheckBox();
        this.JLBA12 = new JLabel();
        this.JCHA12 = new JCheckBox();
        this.JLB1_VLResultado = new JLabel();
        this.JLB1_VLRClasificacion = new JLabel();
        this.JPINumeros = new JPanel();
        this.JLB1 = new JLabel();
        this.JLB2 = new JLabel();
        this.JLB3 = new JLabel();
        this.JLB4 = new JLabel();
        this.JLB5 = new JLabel();
        this.JLB6 = new JLabel();
        this.JLB7 = new JLabel();
        this.JLB8 = new JLabel();
        this.JLB9 = new JLabel();
        this.JLB10 = new JLabel();
        this.JLB11 = new JLabel();
        this.JLB12 = new JLabel();
        this.JPI2_ODerecho = new JPanel();
        this.jLabel3 = new JLabel();
        this.JCHD1 = new JCheckBox();
        this.JLBD1 = new JLabel();
        this.JCHD2 = new JCheckBox();
        this.JCHD3 = new JCheckBox();
        this.JLBD3 = new JLabel();
        this.JLBD4 = new JLabel();
        this.JCHD4 = new JCheckBox();
        this.JCHD5 = new JCheckBox();
        this.JLBD5 = new JLabel();
        this.JCHD6 = new JCheckBox();
        this.JLBD6 = new JLabel();
        this.JLBD2 = new JLabel();
        this.JLBD7 = new JLabel();
        this.JCHD7 = new JCheckBox();
        this.JCHD8 = new JCheckBox();
        this.JLBD8 = new JLabel();
        this.JCHD9 = new JCheckBox();
        this.JLBD9 = new JLabel();
        this.JLBD10 = new JLabel();
        this.JCHD10 = new JCheckBox();
        this.JCHD11 = new JCheckBox();
        this.JLBD11 = new JLabel();
        this.JCHD12 = new JCheckBox();
        this.JLBD12 = new JLabel();
        this.JLB2_VLResultado = new JLabel();
        this.JLB2_VLRClasificacion = new JLabel();
        this.JPI3_OIzquierdo = new JPanel();
        this.jLabel4 = new JLabel();
        this.JCHI1 = new JCheckBox();
        this.JLBI1 = new JLabel();
        this.JLBI2 = new JLabel();
        this.JCHI2 = new JCheckBox();
        this.JLBI3 = new JLabel();
        this.JCHI3 = new JCheckBox();
        this.JLBI4 = new JLabel();
        this.JCHI4 = new JCheckBox();
        this.JLBI5 = new JLabel();
        this.JCHI5 = new JCheckBox();
        this.JLBI6 = new JLabel();
        this.JCHI6 = new JCheckBox();
        this.JLBI7 = new JLabel();
        this.JCHI7 = new JCheckBox();
        this.JLBI8 = new JLabel();
        this.JCHI8 = new JCheckBox();
        this.JLBI9 = new JLabel();
        this.JCHI9 = new JCheckBox();
        this.JLBI10 = new JLabel();
        this.JCHI10 = new JCheckBox();
        this.JLBI11 = new JLabel();
        this.JCHI11 = new JCheckBox();
        this.JLBI12 = new JLabel();
        this.JCHI12 = new JCheckBox();
        this.JLB3_VLResultado = new JLabel();
        this.JLB3_VLRClasificacion = new JLabel();
        this.JPI4_Estereopsis = new JPanel();
        this.JCHBEs1 = new JCheckBox();
        this.JCHBEs2 = new JCheckBox();
        this.JCHBEs3 = new JCheckBox();
        this.JCHBEs4 = new JCheckBox();
        this.JCHBEs5 = new JCheckBox();
        this.JCHBEs6 = new JCheckBox();
        this.JCHBEs7 = new JCheckBox();
        this.JCHBEs8 = new JCheckBox();
        this.JCHBEs = new JCheckBox();
        this.jLabel5 = new JLabel();
        this.JLB4_VLRClasificacion = new JLabel();
        this.jLabel62 = new JLabel();
        this.JLBI13 = new JLabel();
        this.jLabel63 = new JLabel();
        this.JLBI14 = new JLabel();
        this.jLabel64 = new JLabel();
        this.JLBI15 = new JLabel();
        this.jLabel65 = new JLabel();
        this.JLBI16 = new JLabel();
        this.jLabel66 = new JLabel();
        this.JLBI17 = new JLabel();
        this.jLabel67 = new JLabel();
        this.JLBI18 = new JLabel();
        this.jLabel68 = new JLabel();
        this.JLBI19 = new JLabel();
        this.jLabel69 = new JLabel();
        this.JLBI20 = new JLabel();
        this.jLabel70 = new JLabel();
        this.JLBI21 = new JLabel();
        this.JPI5_Color = new JPanel();
        this.jLabel23 = new JLabel();
        this.JCHBC = new JCheckBox();
        this.jLabel42 = new JLabel();
        this.JCHBC1 = new JCheckBox();
        this.JCHBC5 = new JCheckBox();
        this.JCHBC6 = new JCheckBox();
        this.JLB5_VLRClasificacion = new JLabel();
        this.jLabel71 = new JLabel();
        this.jLabel72 = new JLabel();
        this.jLabel73 = new JLabel();
        this.jLabel74 = new JLabel();
        this.jLabel75 = new JLabel();
        this.jLabel76 = new JLabel();
        this.jLabel77 = new JLabel();
        this.JCHBC7 = new JCheckBox();
        this.jLabel78 = new JLabel();
        this.jLabel79 = new JLabel();
        this.JCHBC8 = new JCheckBox();
        this.jLabel80 = new JLabel();
        this.jLabel81 = new JLabel();
        this.JPI6_FVertical = new JPanel();
        this.jLabel24 = new JLabel();
        this.JCHBFV = new JCheckBox();
        this.jLabel50 = new JLabel();
        this.JCHBFV1 = new JCheckBox();
        this.JCHBFV2 = new JCheckBox();
        this.JCHBFV3 = new JCheckBox();
        this.JCHBFV4 = new JCheckBox();
        this.JCHBFV5 = new JCheckBox();
        this.JCHBFV6 = new JCheckBox();
        this.jLabel51 = new JLabel();
        this.JLB6_VLRClasificacion = new JLabel();
        this.JPI7_FLateral = new JPanel();
        this.jLabel25 = new JLabel();
        this.JCHBFLa = new JCheckBox();
        this.JCHBFLa1 = new JCheckBox();
        this.JCHBFLa2 = new JCheckBox();
        this.JCHBFLa3 = new JCheckBox();
        this.JCHBFLa4 = new JCheckBox();
        this.JCHBFLa5 = new JCheckBox();
        this.JCHBFLa6 = new JCheckBox();
        this.JCHBFLa7 = new JCheckBox();
        this.JCHBFLa8 = new JCheckBox();
        this.JCHBFLa9 = new JCheckBox();
        this.JCHBFLa10 = new JCheckBox();
        this.JCHBFLa11 = new JCheckBox();
        this.JCHBFLa12 = new JCheckBox();
        this.JCHBFLa13 = new JCheckBox();
        this.JCHBFLa14 = new JCheckBox();
        this.jLabel52 = new JLabel();
        this.JLB7_VLRClasificacion = new JLabel();
        this.JLB12_VCFVClasificacion = new JPanel();
        this.JPI8_VCAOjos = new JPanel();
        this.jLabel6 = new JLabel();
        this.JCHBAOjos = new JCheckBox();
        this.JCHBAOjos1 = new JCheckBox();
        this.JCHBAOjos3 = new JCheckBox();
        this.JCHBAOjos4 = new JCheckBox();
        this.JCHBAOjos5 = new JCheckBox();
        this.JCHBAOjos6 = new JCheckBox();
        this.JCHBAOjos7 = new JCheckBox();
        this.JCHBAOjos8 = new JCheckBox();
        this.JCHBAOjos9 = new JCheckBox();
        this.JCHBAOjos10 = new JCheckBox();
        this.JCHBAOjos11 = new JCheckBox();
        this.JCHBAOjos12 = new JCheckBox();
        this.jLabel9 = new JLabel();
        this.jLabel10 = new JLabel();
        this.jLabel11 = new JLabel();
        this.jLabel12 = new JLabel();
        this.jLabel13 = new JLabel();
        this.jLabel14 = new JLabel();
        this.jLabel15 = new JLabel();
        this.jLabel16 = new JLabel();
        this.jLabel17 = new JLabel();
        this.jLabel18 = new JLabel();
        this.jLabel19 = new JLabel();
        this.jLabel20 = new JLabel();
        this.JLB8_VCResultado = new JLabel();
        this.JLB8_VCRClasificacion = new JLabel();
        this.JPI9_VCDerecho = new JPanel();
        this.jLabel7 = new JLabel();
        this.JCHBDerecho = new JCheckBox();
        this.JCHBDerecho1 = new JCheckBox();
        this.JCHBDerecho2 = new JCheckBox();
        this.JCHBDerecho3 = new JCheckBox();
        this.JCHBDerecho4 = new JCheckBox();
        this.JCHBDerecho5 = new JCheckBox();
        this.JCHBDerecho6 = new JCheckBox();
        this.JCHBDerecho7 = new JCheckBox();
        this.JCHBDerecho8 = new JCheckBox();
        this.JCHBDerecho9 = new JCheckBox();
        this.JCHBDerecho10 = new JCheckBox();
        this.JCHBDerecho11 = new JCheckBox();
        this.jLabel21 = new JLabel();
        this.jLabel22 = new JLabel();
        this.jLabel29 = new JLabel();
        this.jLabel30 = new JLabel();
        this.jLabel31 = new JLabel();
        this.jLabel32 = new JLabel();
        this.jLabel33 = new JLabel();
        this.jLabel34 = new JLabel();
        this.jLabel35 = new JLabel();
        this.jLabel36 = new JLabel();
        this.jLabel37 = new JLabel();
        this.jLabel38 = new JLabel();
        this.JLB9_VCDResultado = new JLabel();
        this.JLB9_VCDClasificacion = new JLabel();
        this.JPI10_VCIzquierdo = new JPanel();
        this.jLabel8 = new JLabel();
        this.JCHBIzquierdo = new JCheckBox();
        this.JCHBIzquierdo1 = new JCheckBox();
        this.JCHBIzquierdo2 = new JCheckBox();
        this.JCHBIzquierdo3 = new JCheckBox();
        this.JCHBIzquierdo4 = new JCheckBox();
        this.JCHBIzquierdo5 = new JCheckBox();
        this.JCHBIzquierdo6 = new JCheckBox();
        this.JCHBIzquierdo7 = new JCheckBox();
        this.JCHBIzquierdo8 = new JCheckBox();
        this.JCHBIzquierdo9 = new JCheckBox();
        this.JCHBIzquierdo10 = new JCheckBox();
        this.JCHBIzquierdo11 = new JCheckBox();
        this.jLabel39 = new JLabel();
        this.jLabel40 = new JLabel();
        this.jLabel41 = new JLabel();
        this.jLabel45 = new JLabel();
        this.jLabel46 = new JLabel();
        this.jLabel47 = new JLabel();
        this.jLabel56 = new JLabel();
        this.jLabel58 = new JLabel();
        this.jLabel59 = new JLabel();
        this.jLabel60 = new JLabel();
        this.jLabel61 = new JLabel();
        this.jLabel57 = new JLabel();
        this.JLB10_VCResultado = new JLabel();
        this.JLB10_VCClasificacion = new JLabel();
        this.JPI11_VCFLateral = new JPanel();
        this.jLabel28 = new JLabel();
        this.JCHBVCLateral = new JCheckBox();
        this.JCHBVCLateral2 = new JCheckBox();
        this.JCHBVCLateral3 = new JCheckBox();
        this.JCHBVCLateral4 = new JCheckBox();
        this.JCHBVCLateral5 = new JCheckBox();
        this.JCHBVCLateral6 = new JCheckBox();
        this.JCHBVCLateral7 = new JCheckBox();
        this.JCHBVCLateral8 = new JCheckBox();
        this.JCHBVCLateral9 = new JCheckBox();
        this.JCHBVCLateral10 = new JCheckBox();
        this.JCHBVCLateral11 = new JCheckBox();
        this.JCHBVCLateral12 = new JCheckBox();
        this.JCHBVCLateral13 = new JCheckBox();
        this.JCHBVCLateral14 = new JCheckBox();
        this.JCHBVCLateral15 = new JCheckBox();
        this.jLabel55 = new JLabel();
        this.JLB11_VCFLaClasificacion = new JLabel();
        this.JPINumeros1 = new JPanel();
        this.JLB13 = new JLabel();
        this.JLB14 = new JLabel();
        this.JLB15 = new JLabel();
        this.JLB16 = new JLabel();
        this.JLB17 = new JLabel();
        this.JLB18 = new JLabel();
        this.JLB19 = new JLabel();
        this.JLB20 = new JLabel();
        this.JLB21 = new JLabel();
        this.JLB22 = new JLabel();
        this.JLB23 = new JLabel();
        this.JLB24 = new JLabel();
        this.JPIDatosGenerales = new JPanel();
        this.JCHDGLentesC = new JCheckBox();
        this.JCHDGSLentesF = new JCheckBox();
        this.JPITipoGafas = new JPanel();
        this.JRBDGTGNinguna = new JRadioButton();
        this.JRBDGTGPersonal = new JRadioButton();
        this.JRBDGTGSeguridad = new JRadioButton();
        this.JPITipoLentes = new JPanel();
        this.JRBDGTLNinguno = new JRadioButton();
        this.JRBDGTLProgresivo = new JRadioButton();
        this.JRBDGTLBifocales = new JRadioButton();
        this.JRBDGTLMonofocales = new JRadioButton();
        this.JPIUsoCorrecion = new JPanel();
        this.JRBDGTCNinguna = new JRadioButton();
        this.JRBDGTCPermanente = new JRadioButton();
        this.JRBDGTCEsporadico = new JRadioButton();
        this.JPITCorrecion = new JPanel();
        this.JCHTCLejos = new JCheckBox();
        this.JCHTCCerca = new JCheckBox();
        this.jPanel1 = new JPanel();
        this.JSPHistorico = new JScrollPane();
        this.JTDetalleHistorico = new JTable();
        this.JPInterpretacion = new JPanel();
        this.jScrollPane3 = new JScrollPane();
        this.JTAInterpretacion = new JTextArea();
        this.JCBResultado = new JComboBox();
        this.JBGuardarInter = new JButton();
        this.JBTGrabar = new JButton();
        this.jScrollPane4 = new JScrollPane();
        this.JTAObsVisiometria = new JTextArea();
        this.JBTActualizar = new JButton();
        setBorder(BorderFactory.createTitledBorder((Border) null, "VISIOMETRÍA", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        setName("jpvisiometria");
        this.JTPDatosTest.setForeground(Color.red);
        this.JTPDatosTest.setFont(new Font("Arial", 1, 14));
        this.JPI1_VLAOjos.setBorder(BorderFactory.createEtchedBorder());
        this.JPI1_VLAOjos.setPreferredSize(new Dimension(753, 56));
        this.JPI1_VLAOjos.setRequestFocusEnabled(false);
        this.jLabel2.setFont(new Font("Arial", 1, 12));
        this.jLabel2.setForeground(Color.blue);
        this.jLabel2.setText("1. Ambos Ojos");
        this.JBG1_VLAOjos.add(this.JCHA1);
        this.JCHA1.setName("1");
        this.JCHA1.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaFPZ.1
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaFPZ.this.JCHA1ActionPerformed(evt);
            }
        });
        this.JLBA1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Arriba.png")));
        this.JBG1_VLAOjos.add(this.JCHA2);
        this.JCHA2.setName("2");
        this.JCHA2.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaFPZ.2
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaFPZ.this.JCHA2ActionPerformed(evt);
            }
        });
        this.JLBA2.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Derecha.png")));
        this.JBG1_VLAOjos.add(this.JCHA3);
        this.JCHA3.setName("3");
        this.JCHA3.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaFPZ.3
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaFPZ.this.JCHA3ActionPerformed(evt);
            }
        });
        this.JLBA3.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Derecha.png")));
        this.JLBA4.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Izquierda.png")));
        this.JBG1_VLAOjos.add(this.JCHA4);
        this.JCHA4.setName("4");
        this.JCHA4.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaFPZ.4
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaFPZ.this.JCHA4ActionPerformed(evt);
            }
        });
        this.JLBA5.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Arriba.png")));
        this.JBG1_VLAOjos.add(this.JCHA5);
        this.JCHA5.setName("5");
        this.JCHA5.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaFPZ.5
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaFPZ.this.JCHA5ActionPerformed(evt);
            }
        });
        this.JLBA6.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Abajo.png")));
        this.JBG1_VLAOjos.add(this.JCHA6);
        this.JCHA6.setName("6");
        this.JCHA6.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaFPZ.6
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaFPZ.this.JCHA6ActionPerformed(evt);
            }
        });
        this.JLBA7.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Izquierda.png")));
        this.JBG1_VLAOjos.add(this.JCHA7);
        this.JCHA7.setName("7");
        this.JCHA7.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaFPZ.7
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaFPZ.this.JCHA7ActionPerformed(evt);
            }
        });
        this.JLBA8.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Derecha.png")));
        this.JBG1_VLAOjos.add(this.JCHA8);
        this.JCHA8.setName("8");
        this.JCHA8.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaFPZ.8
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaFPZ.this.JCHA8ActionPerformed(evt);
            }
        });
        this.JLBA9.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Izquierda.png")));
        this.JBG1_VLAOjos.add(this.JCHA9);
        this.JCHA9.setName("9");
        this.JCHA9.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaFPZ.9
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaFPZ.this.JCHA9ActionPerformed(evt);
            }
        });
        this.JLBA10.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Abajo.png")));
        this.JBG1_VLAOjos.add(this.JCHA10);
        this.JCHA10.setName("10");
        this.JCHA10.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaFPZ.10
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaFPZ.this.JCHA10ActionPerformed(evt);
            }
        });
        this.JLBA11.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Derecha.png")));
        this.JBG1_VLAOjos.add(this.JCHA11);
        this.JCHA11.setName("11");
        this.JCHA11.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaFPZ.11
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaFPZ.this.JCHA11ActionPerformed(evt);
            }
        });
        this.JLBA12.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Abajo.png")));
        this.JBG1_VLAOjos.add(this.JCHA12);
        this.JCHA12.setName("12");
        this.JCHA12.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaFPZ.12
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaFPZ.this.JCHA12ActionPerformed(evt);
            }
        });
        this.JLB1_VLResultado.setFont(new Font("Arial", 1, 12));
        this.JLB1_VLResultado.setForeground(new Color(255, 0, 0));
        this.JLB1_VLRClasificacion.setFont(new Font("Arial", 1, 12));
        this.JLB1_VLRClasificacion.setForeground(new Color(255, 0, 0));
        GroupLayout JPI1_VLAOjosLayout = new GroupLayout(this.JPI1_VLAOjos);
        this.JPI1_VLAOjos.setLayout(JPI1_VLAOjosLayout);
        JPI1_VLAOjosLayout.setHorizontalGroup(JPI1_VLAOjosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI1_VLAOjosLayout.createSequentialGroup().addContainerGap().addComponent(this.jLabel2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPI1_VLAOjosLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JCHA1, -1, -1, 32767).addComponent(this.JLBA1, -2, 21, -2)).addGap(20, 20, 20).addGroup(JPI1_VLAOjosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JLBA2).addComponent(this.JCHA2)).addGap(20, 20, 20).addGroup(JPI1_VLAOjosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JLBA3).addComponent(this.JCHA3, -2, 21, -2)).addGap(20, 20, 20).addGroup(JPI1_VLAOjosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JCHA4).addComponent(this.JLBA4)).addGap(20, 20, 20).addGroup(JPI1_VLAOjosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLBA5, -2, 21, -2).addComponent(this.JCHA5, GroupLayout.Alignment.TRAILING)).addGap(20, 20, 20).addGroup(JPI1_VLAOjosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLBA6).addComponent(this.JCHA6)).addGap(20, 20, 20).addGroup(JPI1_VLAOjosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLBA7).addComponent(this.JCHA7)).addGap(20, 20, 20).addGroup(JPI1_VLAOjosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLBA8).addComponent(this.JCHA8)).addGap(20, 20, 20).addGroup(JPI1_VLAOjosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLBA9, GroupLayout.Alignment.TRAILING).addComponent(this.JCHA9, GroupLayout.Alignment.TRAILING)).addGap(20, 20, 20).addGroup(JPI1_VLAOjosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLBA10).addComponent(this.JCHA10)).addGap(20, 20, 20).addGroup(JPI1_VLAOjosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLBA11, GroupLayout.Alignment.TRAILING).addComponent(this.JCHA11)).addGap(33, 33, 33).addGroup(JPI1_VLAOjosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLBA12).addComponent(this.JCHA12)).addGap(18, 18, 18).addComponent(this.JLB1_VLResultado, -2, 55, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLB1_VLRClasificacion, -1, -1, 32767).addContainerGap()));
        JPI1_VLAOjosLayout.setVerticalGroup(JPI1_VLAOjosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI1_VLAOjosLayout.createSequentialGroup().addGroup(JPI1_VLAOjosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLBA7).addComponent(this.JLBA8).addComponent(this.JLBA9).addComponent(this.JLBA3).addComponent(this.JLBA6)).addGroup(JPI1_VLAOjosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPI1_VLAOjosLayout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JCHA7).addContainerGap()).addGroup(JPI1_VLAOjosLayout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPI1_VLAOjosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHA8).addComponent(this.JCHA9).addComponent(this.JCHA6).addComponent(this.JCHA5).addGroup(JPI1_VLAOjosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JCHA2).addComponent(this.JCHA3).addComponent(this.JCHA1)))))).addGroup(JPI1_VLAOjosLayout.createSequentialGroup().addGroup(JPI1_VLAOjosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI1_VLAOjosLayout.createSequentialGroup().addContainerGap().addComponent(this.jLabel2)).addGroup(JPI1_VLAOjosLayout.createSequentialGroup().addGroup(JPI1_VLAOjosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLBA4, -2, 18, -2).addComponent(this.JLBA5)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHA4)).addComponent(this.JLB1_VLResultado, -2, 41, -2).addComponent(this.JLB1_VLRClasificacion, -2, 41, -2).addGroup(JPI1_VLAOjosLayout.createSequentialGroup().addGroup(JPI1_VLAOjosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLBA11).addComponent(this.JLBA12).addGroup(JPI1_VLAOjosLayout.createSequentialGroup().addGap(1, 1, 1).addGroup(JPI1_VLAOjosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLBA2, -2, 12, -2).addComponent(this.JLBA1).addComponent(this.JLBA10)))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPI1_VLAOjosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHA10).addComponent(this.JCHA12).addComponent(this.JCHA11)))).addGap(0, 0, 32767)));
        this.JLB1.setFont(new Font("Arial", 1, 12));
        this.JLB1.setForeground(new Color(255, 0, 0));
        this.JLB1.setText("1");
        this.JLB2.setFont(new Font("Arial", 1, 12));
        this.JLB2.setForeground(new Color(255, 0, 0));
        this.JLB2.setText("2");
        this.JLB3.setFont(new Font("Arial", 1, 12));
        this.JLB3.setForeground(new Color(255, 0, 51));
        this.JLB3.setText("3");
        this.JLB4.setFont(new Font("Arial", 1, 12));
        this.JLB4.setForeground(new Color(255, 0, 51));
        this.JLB4.setText("4");
        this.JLB5.setFont(new Font("Arial", 1, 12));
        this.JLB5.setForeground(new Color(255, 0, 51));
        this.JLB5.setText("5");
        this.JLB6.setFont(new Font("Arial", 1, 12));
        this.JLB6.setForeground(new Color(255, 0, 51));
        this.JLB6.setText("6");
        this.JLB7.setFont(new Font("Arial", 1, 12));
        this.JLB7.setForeground(new Color(255, 0, 51));
        this.JLB7.setText("7");
        this.JLB8.setFont(new Font("Arial", 1, 12));
        this.JLB8.setForeground(new Color(255, 0, 51));
        this.JLB8.setText("8");
        this.JLB9.setFont(new Font("Arial", 1, 12));
        this.JLB9.setForeground(new Color(255, 0, 51));
        this.JLB9.setText("9");
        this.JLB10.setFont(new Font("Arial", 1, 12));
        this.JLB10.setForeground(new Color(255, 0, 51));
        this.JLB10.setText("10");
        this.JLB11.setFont(new Font("Arial", 1, 12));
        this.JLB11.setForeground(new Color(255, 0, 51));
        this.JLB11.setText("11");
        this.JLB12.setFont(new Font("Arial", 1, 12));
        this.JLB12.setForeground(new Color(255, 0, 51));
        this.JLB12.setText("12");
        GroupLayout JPINumerosLayout = new GroupLayout(this.JPINumeros);
        this.JPINumeros.setLayout(JPINumerosLayout);
        JPINumerosLayout.setHorizontalGroup(JPINumerosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPINumerosLayout.createSequentialGroup().addGap(31, 31, 31).addComponent(this.JLB1).addGap(33, 33, 33).addComponent(this.JLB2).addGap(33, 33, 33).addComponent(this.JLB3).addGap(33, 33, 33).addComponent(this.JLB4).addGap(33, 33, 33).addComponent(this.JLB5).addGap(33, 33, 33).addComponent(this.JLB6).addGap(33, 33, 33).addComponent(this.JLB7).addGap(33, 33, 33).addComponent(this.JLB8).addGap(33, 33, 33).addComponent(this.JLB9).addGap(33, 33, 33).addComponent(this.JLB10).addGap(33, 33, 33).addComponent(this.JLB11).addGap(33, 33, 33).addComponent(this.JLB12).addContainerGap(-1, 32767)));
        JPINumerosLayout.setVerticalGroup(JPINumerosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPINumerosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JLB1).addComponent(this.JLB2).addComponent(this.JLB3).addComponent(this.JLB4).addComponent(this.JLB5).addComponent(this.JLB6).addComponent(this.JLB7).addComponent(this.JLB8).addComponent(this.JLB9).addComponent(this.JLB10).addComponent(this.JLB11).addComponent(this.JLB12)));
        this.JPI2_ODerecho.setBorder(BorderFactory.createEtchedBorder());
        this.jLabel3.setFont(new Font("Arial", 1, 12));
        this.jLabel3.setForeground(Color.blue);
        this.jLabel3.setText("2. Derecho ");
        this.JBG2_VLODerecho.add(this.JCHD1);
        this.JCHD1.setName("1");
        this.JCHD1.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaFPZ.13
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaFPZ.this.JCHD1ActionPerformed(evt);
            }
        });
        this.JLBD1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Arriba.png")));
        this.JBG2_VLODerecho.add(this.JCHD2);
        this.JCHD2.setName("2");
        this.JCHD2.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaFPZ.14
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaFPZ.this.JCHD2ActionPerformed(evt);
            }
        });
        this.JBG2_VLODerecho.add(this.JCHD3);
        this.JCHD3.setName("3");
        this.JCHD3.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaFPZ.15
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaFPZ.this.JCHD3ActionPerformed(evt);
            }
        });
        this.JLBD3.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Arriba.png")));
        this.JLBD4.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Arriba.png")));
        this.JBG2_VLODerecho.add(this.JCHD4);
        this.JCHD4.setName("4");
        this.JCHD4.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaFPZ.16
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaFPZ.this.JCHD4ActionPerformed(evt);
            }
        });
        this.JBG2_VLODerecho.add(this.JCHD5);
        this.JCHD5.setName("5");
        this.JCHD5.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaFPZ.17
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaFPZ.this.JCHD5ActionPerformed(evt);
            }
        });
        this.JLBD5.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Abajo.png")));
        this.JBG2_VLODerecho.add(this.JCHD6);
        this.JCHD6.setName("6");
        this.JCHD6.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaFPZ.18
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaFPZ.this.JCHD6ActionPerformed(evt);
            }
        });
        this.JLBD6.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Abajo.png")));
        this.JLBD2.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Izquierda.png")));
        this.JLBD7.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Izquierda.png")));
        this.JBG2_VLODerecho.add(this.JCHD7);
        this.JCHD7.setName("7");
        this.JCHD7.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaFPZ.19
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaFPZ.this.JCHD7ActionPerformed(evt);
            }
        });
        this.JBG2_VLODerecho.add(this.JCHD8);
        this.JCHD8.setName("8");
        this.JCHD8.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaFPZ.20
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaFPZ.this.JCHD8ActionPerformed(evt);
            }
        });
        this.JLBD8.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Abajo.png")));
        this.JBG2_VLODerecho.add(this.JCHD9);
        this.JCHD9.setName("9");
        this.JCHD9.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaFPZ.21
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaFPZ.this.JCHD9ActionPerformed(evt);
            }
        });
        this.JLBD9.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Derecha.png")));
        this.JLBD10.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Arriba.png")));
        this.JBG2_VLODerecho.add(this.JCHD10);
        this.JCHD10.setName("10");
        this.JCHD10.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaFPZ.22
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaFPZ.this.JCHD10ActionPerformed(evt);
            }
        });
        this.JBG2_VLODerecho.add(this.JCHD11);
        this.JCHD11.setName("11");
        this.JCHD11.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaFPZ.23
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaFPZ.this.JCHD11ActionPerformed(evt);
            }
        });
        this.JLBD11.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Derecha.png")));
        this.JBG2_VLODerecho.add(this.JCHD12);
        this.JCHD12.setName("12");
        this.JCHD12.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaFPZ.24
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaFPZ.this.JCHD12ActionPerformed(evt);
            }
        });
        this.JLBD12.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Izquierda.png")));
        this.JLB2_VLResultado.setFont(new Font("Arial", 1, 12));
        this.JLB2_VLResultado.setForeground(new Color(255, 0, 0));
        this.JLB2_VLRClasificacion.setFont(new Font("Arial", 1, 12));
        this.JLB2_VLRClasificacion.setForeground(new Color(255, 0, 0));
        GroupLayout JPI2_ODerechoLayout = new GroupLayout(this.JPI2_ODerecho);
        this.JPI2_ODerecho.setLayout(JPI2_ODerechoLayout);
        JPI2_ODerechoLayout.setHorizontalGroup(JPI2_ODerechoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI2_ODerechoLayout.createSequentialGroup().addContainerGap().addComponent(this.jLabel3).addGroup(JPI2_ODerechoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI2_ODerechoLayout.createSequentialGroup().addGap(26, 26, 26).addComponent(this.JLBD1)).addGroup(JPI2_ODerechoLayout.createSequentialGroup().addGap(22, 22, 22).addComponent(this.JCHD1))).addGap(18, 18, 18).addGroup(JPI2_ODerechoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLBD2, -2, 21, -2).addComponent(this.JCHD2)).addGap(20, 20, 20).addGroup(JPI2_ODerechoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLBD3, -2, 21, -2).addComponent(this.JCHD3)).addGroup(JPI2_ODerechoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI2_ODerechoLayout.createSequentialGroup().addGap(20, 20, 20).addComponent(this.JLBD4, -2, 21, -2)).addGroup(JPI2_ODerechoLayout.createSequentialGroup().addGap(17, 17, 17).addComponent(this.JCHD4))).addGroup(JPI2_ODerechoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI2_ODerechoLayout.createSequentialGroup().addGap(22, 22, 22).addComponent(this.JCHD5)).addGroup(JPI2_ODerechoLayout.createSequentialGroup().addGap(21, 21, 21).addComponent(this.JLBD5))).addGap(18, 18, 18).addGroup(JPI2_ODerechoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLBD6).addComponent(this.JCHD6)).addGroup(JPI2_ODerechoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI2_ODerechoLayout.createSequentialGroup().addGap(20, 20, 20).addComponent(this.JLBD7)).addGroup(JPI2_ODerechoLayout.createSequentialGroup().addGap(18, 18, 18).addComponent(this.JCHD7))).addGap(23, 23, 23).addGroup(JPI2_ODerechoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLBD8).addComponent(this.JCHD8)).addGap(18, 18, 18).addGroup(JPI2_ODerechoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI2_ODerechoLayout.createSequentialGroup().addComponent(this.JLBD9).addGap(25, 25, 25).addComponent(this.JLBD10)).addGroup(JPI2_ODerechoLayout.createSequentialGroup().addComponent(this.JCHD9).addGap(18, 18, 18).addComponent(this.JCHD10, -2, 21, -2))).addGap(25, 25, 25).addGroup(JPI2_ODerechoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPI2_ODerechoLayout.createSequentialGroup().addComponent(this.JCHD11).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JCHD12)).addGroup(JPI2_ODerechoLayout.createSequentialGroup().addComponent(this.JLBD11).addGap(33, 33, 33).addComponent(this.JLBD12, -2, 19, -2))).addGap(18, 18, 18).addComponent(this.JLB2_VLResultado, -2, 55, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLB2_VLRClasificacion, -1, -1, 32767).addContainerGap()));
        JPI2_ODerechoLayout.setVerticalGroup(JPI2_ODerechoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI2_ODerechoLayout.createSequentialGroup().addGroup(JPI2_ODerechoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI2_ODerechoLayout.createSequentialGroup().addGroup(JPI2_ODerechoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI2_ODerechoLayout.createSequentialGroup().addGroup(JPI2_ODerechoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLBD11).addComponent(this.JLBD12)).addGap(7, 7, 7).addComponent(this.JCHD11)).addGroup(JPI2_ODerechoLayout.createSequentialGroup().addContainerGap().addComponent(this.jLabel3)).addGroup(JPI2_ODerechoLayout.createSequentialGroup().addComponent(this.JLBD8).addGap(1, 1, 1).addComponent(this.JCHD8)).addGroup(JPI2_ODerechoLayout.createSequentialGroup().addGroup(JPI2_ODerechoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLBD9).addComponent(this.JLBD10)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPI2_ODerechoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHD9).addComponent(this.JCHD10))).addGroup(JPI2_ODerechoLayout.createSequentialGroup().addGap(19, 19, 19).addGroup(JPI2_ODerechoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHD6).addComponent(this.JCHD5).addComponent(this.JCHD7)))).addGap(0, 0, 32767)).addGroup(GroupLayout.Alignment.TRAILING, JPI2_ODerechoLayout.createSequentialGroup().addGap(0, 0, 32767).addGroup(JPI2_ODerechoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPI2_ODerechoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLB2_VLResultado, -2, 41, -2).addComponent(this.JLB2_VLRClasificacion, -2, 41, -2)).addComponent(this.JCHD12, GroupLayout.Alignment.TRAILING)))).addContainerGap()).addGroup(JPI2_ODerechoLayout.createSequentialGroup().addGroup(JPI2_ODerechoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI2_ODerechoLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(GroupLayout.Alignment.LEADING, JPI2_ODerechoLayout.createSequentialGroup().addGap(1, 1, 1).addGroup(JPI2_ODerechoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLBD5).addGroup(JPI2_ODerechoLayout.createSequentialGroup().addComponent(this.JLBD4).addGap(1, 1, 1).addComponent(this.JCHD4)))).addGroup(JPI2_ODerechoLayout.createSequentialGroup().addGroup(JPI2_ODerechoLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JLBD6).addComponent(this.JLBD7).addComponent(this.JLBD2).addComponent(this.JLBD3)).addGap(28, 28, 28))).addGroup(JPI2_ODerechoLayout.createSequentialGroup().addComponent(this.JLBD1).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPI2_ODerechoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHD2).addComponent(this.JCHD3).addComponent(this.JCHD1, GroupLayout.Alignment.TRAILING)))).addGap(0, 0, 32767)));
        this.JPI3_OIzquierdo.setBorder(BorderFactory.createEtchedBorder());
        this.jLabel4.setFont(new Font("Arial", 1, 12));
        this.jLabel4.setForeground(Color.blue);
        this.jLabel4.setText("3. Izquierdo");
        this.JBG3_VLODerecho.add(this.JCHI1);
        this.JCHI1.setName("1");
        this.JCHI1.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaFPZ.25
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaFPZ.this.JCHI1ActionPerformed(evt);
            }
        });
        this.JLBI1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Izquierda.png")));
        this.JLBI2.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Derecha.png")));
        this.JBG3_VLODerecho.add(this.JCHI2);
        this.JCHI2.setName("2");
        this.JCHI2.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaFPZ.26
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaFPZ.this.JCHI2ActionPerformed(evt);
            }
        });
        this.JLBI3.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Izquierda.png")));
        this.JBG3_VLODerecho.add(this.JCHI3);
        this.JCHI3.setName("3");
        this.JCHI3.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaFPZ.27
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaFPZ.this.JCHI3ActionPerformed(evt);
            }
        });
        this.JLBI4.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Abajo.png")));
        this.JBG3_VLODerecho.add(this.JCHI4);
        this.JCHI4.setName("4");
        this.JCHI4.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaFPZ.28
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaFPZ.this.JCHI4ActionPerformed(evt);
            }
        });
        this.JLBI5.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Derecha.png")));
        this.JBG3_VLODerecho.add(this.JCHI5);
        this.JCHI5.setName("5");
        this.JCHI5.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaFPZ.29
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaFPZ.this.JCHI5ActionPerformed(evt);
            }
        });
        this.JLBI6.setHorizontalAlignment(0);
        this.JLBI6.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Arriba.png")));
        this.JBG3_VLODerecho.add(this.JCHI6);
        this.JCHI6.setName("6");
        this.JCHI6.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaFPZ.30
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaFPZ.this.JCHI6ActionPerformed(evt);
            }
        });
        this.JLBI7.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Arriba.png")));
        this.JBG3_VLODerecho.add(this.JCHI7);
        this.JCHI7.setName("7");
        this.JCHI7.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaFPZ.31
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaFPZ.this.JCHI7ActionPerformed(evt);
            }
        });
        this.JLBI8.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Abajo.png")));
        this.JBG3_VLODerecho.add(this.JCHI8);
        this.JCHI8.setName("8");
        this.JCHI8.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaFPZ.32
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaFPZ.this.JCHI8ActionPerformed(evt);
            }
        });
        this.JLBI9.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Derecha.png")));
        this.JBG3_VLODerecho.add(this.JCHI9);
        this.JCHI9.setName("9");
        this.JCHI9.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaFPZ.33
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaFPZ.this.JCHI9ActionPerformed(evt);
            }
        });
        this.JLBI10.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Arriba.png")));
        this.JBG3_VLODerecho.add(this.JCHI10);
        this.JCHI10.setName("10");
        this.JCHI10.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaFPZ.34
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaFPZ.this.JCHI10ActionPerformed(evt);
            }
        });
        this.JLBI11.setHorizontalAlignment(0);
        this.JLBI11.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Abajo.png")));
        this.JBG3_VLODerecho.add(this.JCHI11);
        this.JCHI11.setName("11");
        this.JCHI11.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaFPZ.35
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaFPZ.this.JCHI11ActionPerformed(evt);
            }
        });
        this.JLBI12.setHorizontalAlignment(0);
        this.JLBI12.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Derecha.png")));
        this.JBG3_VLODerecho.add(this.JCHI12);
        this.JCHI12.setName("12");
        this.JCHI12.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaFPZ.36
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaFPZ.this.JCHI12ActionPerformed(evt);
            }
        });
        this.JLB3_VLResultado.setFont(new Font("Arial", 1, 12));
        this.JLB3_VLResultado.setForeground(new Color(255, 0, 0));
        this.JLB3_VLRClasificacion.setFont(new Font("Arial", 1, 12));
        this.JLB3_VLRClasificacion.setForeground(new Color(255, 0, 0));
        GroupLayout JPI3_OIzquierdoLayout = new GroupLayout(this.JPI3_OIzquierdo);
        this.JPI3_OIzquierdo.setLayout(JPI3_OIzquierdoLayout);
        JPI3_OIzquierdoLayout.setHorizontalGroup(JPI3_OIzquierdoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI3_OIzquierdoLayout.createSequentialGroup().addContainerGap().addComponent(this.jLabel4).addGap(23, 23, 23).addGroup(JPI3_OIzquierdoLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JLBI1).addComponent(this.JCHI1)).addGroup(JPI3_OIzquierdoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI3_OIzquierdoLayout.createSequentialGroup().addGap(18, 18, 18).addComponent(this.JCHI2)).addGroup(JPI3_OIzquierdoLayout.createSequentialGroup().addGap(21, 21, 21).addComponent(this.JLBI2, -2, 21, -2))).addGap(18, 18, 18).addGroup(JPI3_OIzquierdoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI3_OIzquierdoLayout.createSequentialGroup().addComponent(this.JCHI3).addGap(15, 15, 15).addComponent(this.JCHI4)).addGroup(JPI3_OIzquierdoLayout.createSequentialGroup().addComponent(this.JLBI3).addGap(20, 20, 20).addComponent(this.JLBI4))).addGap(18, 18, 18).addGroup(JPI3_OIzquierdoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPI3_OIzquierdoLayout.createSequentialGroup().addComponent(this.JLBI5, -1, -1, 32767).addGap(3, 3, 3)).addComponent(this.JCHI5)).addGap(12, 12, 12).addGroup(JPI3_OIzquierdoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JCHI6, -1, -1, 32767).addComponent(this.JLBI6, -1, -1, 32767)).addGap(18, 18, 18).addGroup(JPI3_OIzquierdoLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JLBI7).addComponent(this.JCHI7)).addGap(21, 21, 21).addGroup(JPI3_OIzquierdoLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JLBI8).addComponent(this.JCHI8)).addGap(18, 18, 18).addGroup(JPI3_OIzquierdoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLBI9).addComponent(this.JCHI9)).addGap(22, 22, 22).addGroup(JPI3_OIzquierdoLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JLBI10).addComponent(this.JCHI10)).addGap(22, 22, 22).addGroup(JPI3_OIzquierdoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JCHI11, -1, -1, 32767).addComponent(this.JLBI11, -1, -1, 32767)).addGap(28, 28, 28).addGroup(JPI3_OIzquierdoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JCHI12, -1, -1, 32767).addComponent(this.JLBI12, -1, -1, 32767)).addGap(18, 18, 18).addComponent(this.JLB3_VLResultado, -2, 55, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLB3_VLRClasificacion, -1, -1, 32767).addContainerGap()));
        JPI3_OIzquierdoLayout.setVerticalGroup(JPI3_OIzquierdoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI3_OIzquierdoLayout.createSequentialGroup().addContainerGap().addComponent(this.jLabel4).addGap(0, 0, 32767)).addGroup(JPI3_OIzquierdoLayout.createSequentialGroup().addGroup(JPI3_OIzquierdoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLB3_VLResultado, -2, 41, -2).addComponent(this.JLB3_VLRClasificacion, -2, 41, -2)).addContainerGap(-1, 32767)).addGroup(GroupLayout.Alignment.TRAILING, JPI3_OIzquierdoLayout.createSequentialGroup().addGap(0, 0, 32767).addGroup(JPI3_OIzquierdoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI3_OIzquierdoLayout.createSequentialGroup().addGap(20, 20, 20).addComponent(this.JCHI5)).addComponent(this.JLBI5).addGroup(JPI3_OIzquierdoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPI3_OIzquierdoLayout.createSequentialGroup().addGroup(JPI3_OIzquierdoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLBI1).addComponent(this.JLBI4).addComponent(this.JLBI2).addComponent(this.JLBI3)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPI3_OIzquierdoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHI2).addComponent(this.JCHI1).addComponent(this.JCHI3).addComponent(this.JCHI4))).addGroup(JPI3_OIzquierdoLayout.createSequentialGroup().addGroup(JPI3_OIzquierdoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLBI6).addComponent(this.JLBI7).addComponent(this.JLBI8).addComponent(this.JLBI9).addComponent(this.JLBI10).addComponent(this.JLBI11)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPI3_OIzquierdoLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JCHI6).addComponent(this.JCHI7).addComponent(this.JCHI8).addComponent(this.JCHI9).addComponent(this.JCHI10).addComponent(this.JCHI11))).addGroup(GroupLayout.Alignment.TRAILING, JPI3_OIzquierdoLayout.createSequentialGroup().addComponent(this.JLBI12).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JCHI12)))).addGap(12, 12, 12)));
        this.JPI4_Estereopsis.setBorder(BorderFactory.createEtchedBorder());
        this.JCHBEs1.setName("1");
        this.JCHBEs1.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaFPZ.37
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaFPZ.this.JCHBEs1ActionPerformed(evt);
            }
        });
        this.JCHBEs2.setName("2");
        this.JCHBEs2.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaFPZ.38
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaFPZ.this.JCHBEs2ActionPerformed(evt);
            }
        });
        this.JCHBEs3.setName("3");
        this.JCHBEs3.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaFPZ.39
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaFPZ.this.JCHBEs3ActionPerformed(evt);
            }
        });
        this.JCHBEs4.setName("4");
        this.JCHBEs4.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaFPZ.40
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaFPZ.this.JCHBEs4ActionPerformed(evt);
            }
        });
        this.JCHBEs5.setName("5");
        this.JCHBEs5.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaFPZ.41
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaFPZ.this.JCHBEs5ActionPerformed(evt);
            }
        });
        this.JCHBEs6.setName("6");
        this.JCHBEs6.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaFPZ.42
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaFPZ.this.JCHBEs6ActionPerformed(evt);
            }
        });
        this.JCHBEs7.setIconTextGap(7);
        this.JCHBEs7.setName("7");
        this.JCHBEs7.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaFPZ.43
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaFPZ.this.JCHBEs7ActionPerformed(evt);
            }
        });
        this.JCHBEs8.setName("8");
        this.JCHBEs8.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaFPZ.44
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaFPZ.this.JCHBEs8ActionPerformed(evt);
            }
        });
        this.JCHBEs.setName("9");
        this.JCHBEs.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaFPZ.45
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaFPZ.this.JCHBEsActionPerformed(evt);
            }
        });
        this.jLabel5.setFont(new Font("Arial", 1, 12));
        this.jLabel5.setForeground(Color.blue);
        this.jLabel5.setText("4. Estereopsis");
        this.JLB4_VLRClasificacion.setFont(new Font("Arial", 1, 12));
        this.JLB4_VLRClasificacion.setForeground(new Color(255, 0, 0));
        this.jLabel62.setFont(new Font("Arial", 1, 12));
        this.jLabel62.setForeground(new Color(0, 102, 0));
        this.jLabel62.setText("1");
        this.JLBI13.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Abajo.png")));
        this.jLabel63.setFont(new Font("Arial", 1, 12));
        this.jLabel63.setForeground(new Color(0, 102, 0));
        this.jLabel63.setText("2");
        this.JLBI14.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Izquierda.png")));
        this.jLabel64.setFont(new Font("Arial", 1, 12));
        this.jLabel64.setForeground(new Color(0, 102, 0));
        this.jLabel64.setText("3");
        this.JLBI15.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Abajo.png")));
        this.jLabel65.setFont(new Font("Arial", 1, 12));
        this.jLabel65.setForeground(new Color(0, 102, 0));
        this.jLabel65.setText("4");
        this.JLBI16.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Arriba.png")));
        this.jLabel66.setFont(new Font("Arial", 1, 12));
        this.jLabel66.setForeground(new Color(0, 102, 0));
        this.jLabel66.setText("5");
        this.JLBI17.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Arriba.png")));
        this.jLabel67.setFont(new Font("Arial", 1, 12));
        this.jLabel67.setForeground(new Color(0, 102, 0));
        this.jLabel67.setText("6");
        this.JLBI18.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Izquierda.png")));
        this.jLabel68.setFont(new Font("Arial", 1, 12));
        this.jLabel68.setForeground(new Color(0, 102, 0));
        this.jLabel68.setText("7");
        this.JLBI19.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Derecha.png")));
        this.jLabel69.setFont(new Font("Arial", 1, 12));
        this.jLabel69.setForeground(new Color(0, 102, 0));
        this.jLabel69.setText("8");
        this.JLBI20.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Izquierda.png")));
        this.jLabel70.setFont(new Font("Arial", 1, 12));
        this.jLabel70.setForeground(new Color(0, 102, 0));
        this.jLabel70.setText("9");
        this.JLBI21.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Derecha.png")));
        GroupLayout JPI4_EstereopsisLayout = new GroupLayout(this.JPI4_Estereopsis);
        this.JPI4_Estereopsis.setLayout(JPI4_EstereopsisLayout);
        JPI4_EstereopsisLayout.setHorizontalGroup(JPI4_EstereopsisLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI4_EstereopsisLayout.createSequentialGroup().addContainerGap().addComponent(this.jLabel5).addGap(50, 50, 50).addGroup(JPI4_EstereopsisLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPI4_EstereopsisLayout.createSequentialGroup().addComponent(this.JCHBEs1).addGap(32, 32, 32).addComponent(this.JCHBEs2)).addGroup(JPI4_EstereopsisLayout.createSequentialGroup().addGroup(JPI4_EstereopsisLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLBI13).addComponent(this.jLabel62, -2, 21, -2)).addGap(32, 32, 32).addGroup(JPI4_EstereopsisLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLBI14).addComponent(this.jLabel63, -2, 21, -2)))).addGap(32, 32, 32).addGroup(JPI4_EstereopsisLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JCHBEs3).addGroup(JPI4_EstereopsisLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLBI15).addComponent(this.jLabel64, -2, 21, -2))).addGap(32, 32, 32).addGroup(JPI4_EstereopsisLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JCHBEs4).addGroup(JPI4_EstereopsisLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLBI16).addComponent(this.jLabel65, -2, 21, -2))).addGap(32, 32, 32).addGroup(JPI4_EstereopsisLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JCHBEs5).addGroup(JPI4_EstereopsisLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLBI17).addComponent(this.jLabel66, -2, 21, -2))).addGap(32, 32, 32).addGroup(JPI4_EstereopsisLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JCHBEs6).addGroup(JPI4_EstereopsisLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLBI18).addComponent(this.jLabel67, -2, 21, -2))).addGap(32, 32, 32).addGroup(JPI4_EstereopsisLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JCHBEs7).addComponent(this.jLabel68, GroupLayout.Alignment.LEADING, -2, 21, -2).addComponent(this.JLBI19, GroupLayout.Alignment.LEADING)).addGap(33, 33, 33).addGroup(JPI4_EstereopsisLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JCHBEs8).addGroup(JPI4_EstereopsisLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jLabel69, GroupLayout.Alignment.LEADING, -2, 21, -2).addComponent(this.JLBI20, GroupLayout.Alignment.LEADING))).addGap(31, 31, 31).addGroup(JPI4_EstereopsisLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHBEs).addComponent(this.jLabel70, -2, 21, -2).addComponent(this.JLBI21)).addGap(52, 52, 52).addComponent(this.JLB4_VLRClasificacion, -2, 150, -2).addContainerGap(-1, 32767)));
        JPI4_EstereopsisLayout.setVerticalGroup(JPI4_EstereopsisLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI4_EstereopsisLayout.createSequentialGroup().addGroup(JPI4_EstereopsisLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI4_EstereopsisLayout.createSequentialGroup().addContainerGap().addComponent(this.JLB4_VLRClasificacion, -2, 41, -2)).addGroup(JPI4_EstereopsisLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPI4_EstereopsisLayout.createSequentialGroup().addGroup(JPI4_EstereopsisLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JLBI21).addGroup(JPI4_EstereopsisLayout.createSequentialGroup().addComponent(this.jLabel70).addGap(18, 18, 18))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHBEs)).addGroup(JPI4_EstereopsisLayout.createSequentialGroup().addGroup(JPI4_EstereopsisLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JLBI19).addGroup(JPI4_EstereopsisLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI4_EstereopsisLayout.createSequentialGroup().addGap(16, 16, 16).addComponent(this.jLabel5)).addGroup(JPI4_EstereopsisLayout.createSequentialGroup().addComponent(this.jLabel62).addGap(0, 0, 0).addComponent(this.JLBI13)).addGroup(JPI4_EstereopsisLayout.createSequentialGroup().addComponent(this.jLabel63).addGap(0, 0, 0).addComponent(this.JLBI14)).addGroup(JPI4_EstereopsisLayout.createSequentialGroup().addComponent(this.jLabel64).addGap(0, 0, 0).addComponent(this.JLBI15)).addGroup(JPI4_EstereopsisLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPI4_EstereopsisLayout.createSequentialGroup().addComponent(this.jLabel65).addGap(0, 0, 0).addComponent(this.JLBI16)).addGroup(JPI4_EstereopsisLayout.createSequentialGroup().addComponent(this.jLabel66).addGap(0, 0, 0).addComponent(this.JLBI17))).addGroup(GroupLayout.Alignment.TRAILING, JPI4_EstereopsisLayout.createSequentialGroup().addGroup(JPI4_EstereopsisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel67).addComponent(this.jLabel68)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLBI18)).addGroup(JPI4_EstereopsisLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JLBI20).addGroup(JPI4_EstereopsisLayout.createSequentialGroup().addComponent(this.jLabel69).addGap(18, 18, 18))))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPI4_EstereopsisLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHBEs1, GroupLayout.Alignment.TRAILING).addComponent(this.JCHBEs2, GroupLayout.Alignment.TRAILING).addComponent(this.JCHBEs3, GroupLayout.Alignment.TRAILING).addComponent(this.JCHBEs4, GroupLayout.Alignment.TRAILING).addComponent(this.JCHBEs5, GroupLayout.Alignment.TRAILING).addComponent(this.JCHBEs6, GroupLayout.Alignment.TRAILING).addComponent(this.JCHBEs7, GroupLayout.Alignment.TRAILING).addComponent(this.JCHBEs8, GroupLayout.Alignment.TRAILING))))).addContainerGap(-1, 32767)));
        this.JPI5_Color.setBorder(BorderFactory.createEtchedBorder());
        this.jLabel23.setFont(new Font("Arial", 1, 12));
        this.jLabel23.setForeground(Color.blue);
        this.jLabel23.setText("5. Color");
        this.JCHBC.setName("1");
        this.JCHBC.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaFPZ.46
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaFPZ.this.JCHBCActionPerformed(evt);
            }
        });
        this.jLabel42.setFont(new Font("Arial", 1, 12));
        this.jLabel42.setForeground(new Color(0, 102, 0));
        this.jLabel42.setText("A");
        this.JCHBC1.setName("2");
        this.JCHBC1.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaFPZ.47
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaFPZ.this.JCHBC1ActionPerformed(evt);
            }
        });
        this.JCHBC5.setName("3");
        this.JCHBC5.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaFPZ.48
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaFPZ.this.JCHBC5ActionPerformed(evt);
            }
        });
        this.JCHBC6.setName("4");
        this.JCHBC6.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaFPZ.49
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaFPZ.this.JCHBC6ActionPerformed(evt);
            }
        });
        this.JLB5_VLRClasificacion.setFont(new Font("Arial", 1, 12));
        this.JLB5_VLRClasificacion.setForeground(new Color(255, 0, 0));
        this.jLabel71.setFont(new Font("Arial", 1, 12));
        this.jLabel71.setForeground(new Color(255, 0, 0));
        this.jLabel71.setText("12");
        this.jLabel72.setFont(new Font("Arial", 1, 12));
        this.jLabel72.setForeground(new Color(0, 102, 0));
        this.jLabel72.setText("B");
        this.jLabel73.setFont(new Font("Arial", 1, 12));
        this.jLabel73.setForeground(new Color(255, 0, 0));
        this.jLabel73.setHorizontalAlignment(0);
        this.jLabel73.setText("5");
        this.jLabel74.setFont(new Font("Arial", 1, 12));
        this.jLabel74.setForeground(new Color(0, 102, 0));
        this.jLabel74.setText("C");
        this.jLabel75.setFont(new Font("Arial", 1, 12));
        this.jLabel75.setForeground(new Color(255, 0, 0));
        this.jLabel75.setHorizontalAlignment(0);
        this.jLabel75.setText("26");
        this.jLabel76.setFont(new Font("Arial", 1, 12));
        this.jLabel76.setForeground(new Color(0, 102, 0));
        this.jLabel76.setText("D");
        this.jLabel77.setFont(new Font("Arial", 1, 12));
        this.jLabel77.setForeground(new Color(255, 0, 0));
        this.jLabel77.setHorizontalAlignment(0);
        this.jLabel77.setText("6");
        this.JCHBC7.setName("5");
        this.JCHBC7.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaFPZ.50
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaFPZ.this.JCHBC7ActionPerformed(evt);
            }
        });
        this.jLabel78.setFont(new Font("Arial", 1, 12));
        this.jLabel78.setForeground(new Color(255, 0, 0));
        this.jLabel78.setHorizontalAlignment(0);
        this.jLabel78.setText("16");
        this.jLabel79.setFont(new Font("Arial", 1, 12));
        this.jLabel79.setForeground(new Color(0, 102, 0));
        this.jLabel79.setText("E");
        this.JCHBC8.setName("6");
        this.JCHBC8.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaFPZ.51
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaFPZ.this.JCHBC8ActionPerformed(evt);
            }
        });
        this.jLabel80.setFont(new Font("Arial", 1, 12));
        this.jLabel80.setForeground(new Color(0, 102, 0));
        this.jLabel80.setText("F");
        this.jLabel81.setFont(new Font("Arial", 1, 12));
        this.jLabel81.setForeground(new Color(255, 0, 0));
        this.jLabel81.setHorizontalAlignment(0);
        this.jLabel81.setText("0");
        GroupLayout JPI5_ColorLayout = new GroupLayout(this.JPI5_Color);
        this.JPI5_Color.setLayout(JPI5_ColorLayout);
        JPI5_ColorLayout.setHorizontalGroup(JPI5_ColorLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI5_ColorLayout.createSequentialGroup().addContainerGap().addComponent(this.jLabel23).addGroup(JPI5_ColorLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI5_ColorLayout.createSequentialGroup().addGap(77, 77, 77).addGroup(JPI5_ColorLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JCHBC).addComponent(this.jLabel71, -2, 17, -2))).addGroup(JPI5_ColorLayout.createSequentialGroup().addGap(85, 85, 85).addComponent(this.jLabel42, -2, 21, -2))).addGap(50, 50, 50).addGroup(JPI5_ColorLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHBC1).addGroup(JPI5_ColorLayout.createSequentialGroup().addGap(4, 4, 4).addComponent(this.jLabel72, -2, 21, -2)).addComponent(this.jLabel73, -2, 17, -2)).addGap(50, 50, 50).addGroup(JPI5_ColorLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHBC5).addGroup(JPI5_ColorLayout.createSequentialGroup().addGroup(JPI5_ColorLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI5_ColorLayout.createSequentialGroup().addGap(4, 4, 4).addComponent(this.jLabel74, -2, 21, -2)).addComponent(this.jLabel75, -2, 17, -2)).addGap(50, 50, 50).addGroup(JPI5_ColorLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI5_ColorLayout.createSequentialGroup().addGap(4, 4, 4).addComponent(this.jLabel76, -2, 21, -2)).addComponent(this.jLabel77, -2, 17, -2))).addGroup(GroupLayout.Alignment.TRAILING, JPI5_ColorLayout.createSequentialGroup().addComponent(this.JCHBC6).addGap(8, 8, 8))).addGap(50, 50, 50).addGroup(JPI5_ColorLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI5_ColorLayout.createSequentialGroup().addGap(4, 4, 4).addGroup(JPI5_ColorLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI5_ColorLayout.createSequentialGroup().addGap(4, 4, 4).addComponent(this.jLabel79, -2, 21, -2)).addComponent(this.jLabel78, -2, 17, -2))).addGroup(GroupLayout.Alignment.TRAILING, JPI5_ColorLayout.createSequentialGroup().addComponent(this.JCHBC7).addGap(8, 8, 8))).addGap(50, 50, 50).addGroup(JPI5_ColorLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI5_ColorLayout.createSequentialGroup().addGap(4, 4, 4).addGroup(JPI5_ColorLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI5_ColorLayout.createSequentialGroup().addGap(4, 4, 4).addComponent(this.jLabel80, -2, 21, -2)).addComponent(this.jLabel81, -2, 17, -2))).addGroup(GroupLayout.Alignment.TRAILING, JPI5_ColorLayout.createSequentialGroup().addComponent(this.JCHBC8).addGap(8, 8, 8))).addGap(131, 131, 131).addComponent(this.JLB5_VLRClasificacion, -1, -1, 32767).addContainerGap()));
        JPI5_ColorLayout.setVerticalGroup(JPI5_ColorLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI5_ColorLayout.createSequentialGroup().addGroup(JPI5_ColorLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI5_ColorLayout.createSequentialGroup().addContainerGap().addComponent(this.jLabel23)).addComponent(this.JLB5_VLRClasificacion, -2, 41, -2).addGroup(JPI5_ColorLayout.createSequentialGroup().addComponent(this.jLabel42).addGap(1, 1, 1).addComponent(this.jLabel71)).addGroup(JPI5_ColorLayout.createSequentialGroup().addGroup(JPI5_ColorLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI5_ColorLayout.createSequentialGroup().addComponent(this.jLabel72).addGap(1, 1, 1).addComponent(this.jLabel73)).addGroup(JPI5_ColorLayout.createSequentialGroup().addComponent(this.jLabel74).addGap(1, 1, 1).addComponent(this.jLabel75)).addGroup(GroupLayout.Alignment.TRAILING, JPI5_ColorLayout.createSequentialGroup().addComponent(this.jLabel76).addGap(1, 1, 1).addComponent(this.jLabel77))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPI5_ColorLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHBC1).addComponent(this.JCHBC).addComponent(this.JCHBC5).addComponent(this.JCHBC6))).addGroup(JPI5_ColorLayout.createSequentialGroup().addComponent(this.jLabel79).addGap(1, 1, 1).addComponent(this.jLabel78).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHBC7)).addGroup(JPI5_ColorLayout.createSequentialGroup().addComponent(this.jLabel80).addGap(1, 1, 1).addComponent(this.jLabel81).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHBC8))).addGap(32, 32, 32)));
        this.JPI6_FVertical.setBorder(BorderFactory.createEtchedBorder());
        this.JPI6_FVertical.setName("xpanelfv1");
        this.jLabel24.setFont(new Font("Arial", 1, 12));
        this.jLabel24.setForeground(Color.blue);
        this.jLabel24.setText("6. Foria Vertical");
        this.JBForiaVertical1.add(this.JCHBFV);
        this.JCHBFV.setName("1");
        this.JCHBFV.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaFPZ.52
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaFPZ.this.JCHBFVActionPerformed(evt);
            }
        });
        this.jLabel50.setFont(new Font("Arial", 1, 12));
        this.jLabel50.setForeground(new Color(0, 102, 0));
        this.jLabel50.setText("1");
        this.JBForiaVertical1.add(this.JCHBFV1);
        this.JCHBFV1.setName("2");
        this.JCHBFV1.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaFPZ.53
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaFPZ.this.JCHBFV1ActionPerformed(evt);
            }
        });
        this.JBForiaVertical1.add(this.JCHBFV2);
        this.JCHBFV2.setName("3");
        this.JCHBFV2.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaFPZ.54
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaFPZ.this.JCHBFV2ActionPerformed(evt);
            }
        });
        this.JBForiaVertical1.add(this.JCHBFV3);
        this.JCHBFV3.setName("4");
        this.JCHBFV3.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaFPZ.55
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaFPZ.this.JCHBFV3ActionPerformed(evt);
            }
        });
        this.JBForiaVertical1.add(this.JCHBFV4);
        this.JCHBFV4.setName("5");
        this.JCHBFV4.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaFPZ.56
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaFPZ.this.JCHBFV4ActionPerformed(evt);
            }
        });
        this.JBForiaVertical1.add(this.JCHBFV5);
        this.JCHBFV5.setName("6");
        this.JCHBFV5.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaFPZ.57
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaFPZ.this.JCHBFV5ActionPerformed(evt);
            }
        });
        this.JBForiaVertical1.add(this.JCHBFV6);
        this.JCHBFV6.setName("7");
        this.JCHBFV6.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaFPZ.58
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaFPZ.this.JCHBFV6ActionPerformed(evt);
            }
        });
        this.jLabel51.setFont(new Font("Arial", 1, 12));
        this.jLabel51.setForeground(new Color(0, 102, 0));
        this.jLabel51.setText("2           3          4           5            6           7");
        this.JLB6_VLRClasificacion.setFont(new Font("Arial", 1, 12));
        this.JLB6_VLRClasificacion.setForeground(new Color(255, 0, 0));
        GroupLayout JPI6_FVerticalLayout = new GroupLayout(this.JPI6_FVertical);
        this.JPI6_FVertical.setLayout(JPI6_FVerticalLayout);
        JPI6_FVerticalLayout.setHorizontalGroup(JPI6_FVerticalLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI6_FVerticalLayout.createSequentialGroup().addContainerGap().addComponent(this.jLabel24).addGroup(JPI6_FVerticalLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPI6_FVerticalLayout.createSequentialGroup().addGap(32, 32, 32).addComponent(this.jLabel50, -2, 21, -2).addGap(12, 12, 12)).addGroup(JPI6_FVerticalLayout.createSequentialGroup().addGap(26, 26, 26).addComponent(this.JCHBFV))).addGroup(JPI6_FVerticalLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addGroup(JPI6_FVerticalLayout.createSequentialGroup().addComponent(this.jLabel51).addGap(7, 7, 7)).addGroup(JPI6_FVerticalLayout.createSequentialGroup().addComponent(this.JCHBFV1).addGap(18, 18, 18).addComponent(this.JCHBFV2).addGap(18, 18, 18).addComponent(this.JCHBFV3).addGap(18, 18, 18).addComponent(this.JCHBFV4).addGap(21, 21, 21).addComponent(this.JCHBFV5).addGap(20, 20, 20).addComponent(this.JCHBFV6))).addGap(260, 260, 260).addComponent(this.JLB6_VLRClasificacion, -1, -1, 32767).addGap(125, 125, 125)));
        JPI6_FVerticalLayout.setVerticalGroup(JPI6_FVerticalLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI6_FVerticalLayout.createSequentialGroup().addGroup(JPI6_FVerticalLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI6_FVerticalLayout.createSequentialGroup().addContainerGap().addComponent(this.jLabel24)).addGroup(JPI6_FVerticalLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(GroupLayout.Alignment.LEADING, JPI6_FVerticalLayout.createSequentialGroup().addGroup(JPI6_FVerticalLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jLabel51).addComponent(this.jLabel50)).addGap(10, 10, 10).addGroup(JPI6_FVerticalLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHBFV1, GroupLayout.Alignment.TRAILING).addComponent(this.JCHBFV2, GroupLayout.Alignment.TRAILING).addComponent(this.JCHBFV, GroupLayout.Alignment.TRAILING).addComponent(this.JCHBFV3, GroupLayout.Alignment.TRAILING).addComponent(this.JCHBFV4, GroupLayout.Alignment.TRAILING).addComponent(this.JCHBFV5, GroupLayout.Alignment.TRAILING).addComponent(this.JCHBFV6, GroupLayout.Alignment.TRAILING))).addComponent(this.JLB6_VLRClasificacion, -2, 41, -2))).addContainerGap(-1, 32767)));
        this.JPI7_FLateral.setBorder(BorderFactory.createEtchedBorder());
        this.JPI7_FLateral.setName("xpanellateral1");
        this.jLabel25.setFont(new Font("Arial", 1, 12));
        this.jLabel25.setForeground(Color.blue);
        this.jLabel25.setText("7. Foria Lateral");
        this.JBForiaLateral1.add(this.JCHBFLa);
        this.JCHBFLa.setName("1");
        this.JCHBFLa.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaFPZ.59
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaFPZ.this.JCHBFLaActionPerformed(evt);
            }
        });
        this.JBForiaLateral1.add(this.JCHBFLa1);
        this.JCHBFLa1.setName("2");
        this.JCHBFLa1.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaFPZ.60
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaFPZ.this.JCHBFLa1ActionPerformed(evt);
            }
        });
        this.JBForiaLateral1.add(this.JCHBFLa2);
        this.JCHBFLa2.setName("3");
        this.JCHBFLa2.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaFPZ.61
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaFPZ.this.JCHBFLa2ActionPerformed(evt);
            }
        });
        this.JBForiaLateral1.add(this.JCHBFLa3);
        this.JCHBFLa3.setName("4");
        this.JCHBFLa3.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaFPZ.62
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaFPZ.this.JCHBFLa3ActionPerformed(evt);
            }
        });
        this.JBForiaLateral1.add(this.JCHBFLa4);
        this.JCHBFLa4.setName("5");
        this.JCHBFLa4.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaFPZ.63
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaFPZ.this.JCHBFLa4ActionPerformed(evt);
            }
        });
        this.JBForiaLateral1.add(this.JCHBFLa5);
        this.JCHBFLa5.setName("6");
        this.JCHBFLa5.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaFPZ.64
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaFPZ.this.JCHBFLa5ActionPerformed(evt);
            }
        });
        this.JBForiaLateral1.add(this.JCHBFLa6);
        this.JCHBFLa6.setName("7");
        this.JCHBFLa6.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaFPZ.65
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaFPZ.this.JCHBFLa6ActionPerformed(evt);
            }
        });
        this.JBForiaLateral1.add(this.JCHBFLa7);
        this.JCHBFLa7.setName("8");
        this.JCHBFLa7.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaFPZ.66
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaFPZ.this.JCHBFLa7ActionPerformed(evt);
            }
        });
        this.JBForiaLateral1.add(this.JCHBFLa8);
        this.JCHBFLa8.setName("9");
        this.JCHBFLa8.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaFPZ.67
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaFPZ.this.JCHBFLa8ActionPerformed(evt);
            }
        });
        this.JBForiaLateral1.add(this.JCHBFLa9);
        this.JCHBFLa9.setName("10");
        this.JCHBFLa9.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaFPZ.68
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaFPZ.this.JCHBFLa9ActionPerformed(evt);
            }
        });
        this.JBForiaLateral1.add(this.JCHBFLa10);
        this.JCHBFLa10.setName("11");
        this.JCHBFLa10.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaFPZ.69
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaFPZ.this.JCHBFLa10ActionPerformed(evt);
            }
        });
        this.JBForiaLateral1.add(this.JCHBFLa11);
        this.JCHBFLa11.setName("12");
        this.JCHBFLa11.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaFPZ.70
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaFPZ.this.JCHBFLa11ActionPerformed(evt);
            }
        });
        this.JBForiaLateral1.add(this.JCHBFLa12);
        this.JCHBFLa12.setName("13");
        this.JCHBFLa12.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaFPZ.71
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaFPZ.this.JCHBFLa12ActionPerformed(evt);
            }
        });
        this.JBForiaLateral1.add(this.JCHBFLa13);
        this.JCHBFLa13.setName("14");
        this.JCHBFLa13.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaFPZ.72
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaFPZ.this.JCHBFLa13ActionPerformed(evt);
            }
        });
        this.JBForiaLateral1.add(this.JCHBFLa14);
        this.JCHBFLa14.setName("15");
        this.JCHBFLa14.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaFPZ.73
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaFPZ.this.JCHBFLa14ActionPerformed(evt);
            }
        });
        this.jLabel52.setFont(new Font("Arial", 1, 12));
        this.jLabel52.setForeground(new Color(0, 102, 0));
        this.jLabel52.setText("1         2           3          4          5           6          7           8           9         10         11        12        13      14        15");
        this.JLB7_VLRClasificacion.setFont(new Font("Arial", 1, 12));
        this.JLB7_VLRClasificacion.setForeground(new Color(255, 0, 0));
        GroupLayout JPI7_FLateralLayout = new GroupLayout(this.JPI7_FLateral);
        this.JPI7_FLateral.setLayout(JPI7_FLateralLayout);
        JPI7_FLateralLayout.setHorizontalGroup(JPI7_FLateralLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI7_FLateralLayout.createSequentialGroup().addContainerGap().addComponent(this.jLabel25).addGroup(JPI7_FLateralLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI7_FLateralLayout.createSequentialGroup().addGap(18, 18, 18).addComponent(this.jLabel52)).addGroup(JPI7_FLateralLayout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.JCHBFLa).addGap(14, 14, 14).addComponent(this.JCHBFLa1).addGap(18, 18, 18).addComponent(this.JCHBFLa2).addGap(18, 18, 18).addComponent(this.JCHBFLa3).addGap(15, 15, 15).addComponent(this.JCHBFLa4).addGap(18, 18, 18).addComponent(this.JCHBFLa5).addGap(18, 18, 18).addComponent(this.JCHBFLa6).addGap(18, 18, 18).addComponent(this.JCHBFLa7).addGap(18, 18, 18).addComponent(this.JCHBFLa8).addGap(18, 18, 18).addComponent(this.JCHBFLa9).addGap(21, 21, 21).addComponent(this.JCHBFLa10).addGap(18, 18, 18).addComponent(this.JCHBFLa11).addGap(15, 15, 15).addComponent(this.JCHBFLa12).addGap(12, 12, 12).addComponent(this.JCHBFLa13).addGap(18, 18, 18).addComponent(this.JCHBFLa14))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLB7_VLRClasificacion, -1, -1, 32767).addGap(5, 5, 5)));
        JPI7_FLateralLayout.setVerticalGroup(JPI7_FLateralLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI7_FLateralLayout.createSequentialGroup().addContainerGap().addComponent(this.jLabel25).addContainerGap(-1, 32767)).addGroup(JPI7_FLateralLayout.createSequentialGroup().addGroup(JPI7_FLateralLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPI7_FLateralLayout.createSequentialGroup().addComponent(this.jLabel52).addGap(7, 7, 7).addGroup(JPI7_FLateralLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JCHBFLa).addComponent(this.JCHBFLa1).addComponent(this.JCHBFLa2).addComponent(this.JCHBFLa3).addComponent(this.JCHBFLa4).addComponent(this.JCHBFLa5).addComponent(this.JCHBFLa6).addComponent(this.JCHBFLa7).addComponent(this.JCHBFLa8).addComponent(this.JCHBFLa9).addComponent(this.JCHBFLa10).addComponent(this.JCHBFLa11).addComponent(this.JCHBFLa12).addComponent(this.JCHBFLa13).addComponent(this.JCHBFLa14))).addComponent(this.JLB7_VLRClasificacion, -2, 41, -2)).addGap(0, 0, 32767)));
        GroupLayout JCHBFLLayout = new GroupLayout(this.JCHBFL);
        this.JCHBFL.setLayout(JCHBFLLayout);
        JCHBFLLayout.setHorizontalGroup(JCHBFLLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JCHBFLLayout.createSequentialGroup().addContainerGap().addGroup(JCHBFLLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPI1_VLAOjos, -1, 806, 32767).addGroup(JCHBFLLayout.createSequentialGroup().addGap(79, 79, 79).addComponent(this.JPINumeros, -2, -1, -2).addGap(0, 0, 32767)).addComponent(this.JPI2_ODerecho, -1, -1, 32767).addComponent(this.JPI3_OIzquierdo, -1, -1, 32767).addComponent(this.JPI4_Estereopsis, GroupLayout.Alignment.TRAILING, -2, 806, 32767).addComponent(this.JPI5_Color, -1, -1, 32767).addComponent(this.JPI6_FVertical, -1, -1, 32767).addComponent(this.JPI7_FLateral, -1, -1, 32767)).addContainerGap()));
        JCHBFLLayout.setVerticalGroup(JCHBFLLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JCHBFLLayout.createSequentialGroup().addContainerGap().addComponent(this.JPINumeros, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPI1_VLAOjos, -2, 46, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JPI2_ODerecho, -2, 45, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JPI3_OIzquierdo, -2, 45, -2).addGap(11, 11, 11).addComponent(this.JPI4_Estereopsis, -2, 63, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPI5_Color, -2, 66, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPI6_FVertical, -2, 52, -2).addGap(7, 7, 7).addComponent(this.JPI7_FLateral, -2, -1, -2).addContainerGap(-1, 32767)));
        this.JTPDatosTest.addTab("VISIÓN LEJANA", this.JCHBFL);
        this.JPI8_VCAOjos.setBorder(BorderFactory.createEtchedBorder());
        this.JPI8_VCAOjos.setPreferredSize(new Dimension(753, 56));
        this.JPI8_VCAOjos.setRequestFocusEnabled(false);
        this.jLabel6.setFont(new Font("Arial", 1, 12));
        this.jLabel6.setForeground(Color.blue);
        this.jLabel6.setText("8. Ambos Ojos");
        this.JBG8_VCAOjos.add(this.JCHBAOjos);
        this.JCHBAOjos.setName("1");
        this.JCHBAOjos.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaFPZ.74
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaFPZ.this.JCHBAOjosActionPerformed(evt);
            }
        });
        this.JBG8_VCAOjos.add(this.JCHBAOjos1);
        this.JCHBAOjos1.setName("2");
        this.JCHBAOjos1.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaFPZ.75
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaFPZ.this.JCHBAOjos1ActionPerformed(evt);
            }
        });
        this.JBG8_VCAOjos.add(this.JCHBAOjos3);
        this.JCHBAOjos3.setName("3");
        this.JCHBAOjos3.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaFPZ.76
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaFPZ.this.JCHBAOjos3ActionPerformed(evt);
            }
        });
        this.JBG8_VCAOjos.add(this.JCHBAOjos4);
        this.JCHBAOjos4.setName("4");
        this.JCHBAOjos4.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaFPZ.77
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaFPZ.this.JCHBAOjos4ActionPerformed(evt);
            }
        });
        this.JBG8_VCAOjos.add(this.JCHBAOjos5);
        this.JCHBAOjos5.setName("5");
        this.JCHBAOjos5.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaFPZ.78
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaFPZ.this.JCHBAOjos5ActionPerformed(evt);
            }
        });
        this.JBG8_VCAOjos.add(this.JCHBAOjos6);
        this.JCHBAOjos6.setName("6");
        this.JCHBAOjos6.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaFPZ.79
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaFPZ.this.JCHBAOjos6ActionPerformed(evt);
            }
        });
        this.JBG8_VCAOjos.add(this.JCHBAOjos7);
        this.JCHBAOjos7.setName("7");
        this.JCHBAOjos7.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaFPZ.80
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaFPZ.this.JCHBAOjos7ActionPerformed(evt);
            }
        });
        this.JBG8_VCAOjos.add(this.JCHBAOjos8);
        this.JCHBAOjos8.setName("8");
        this.JCHBAOjos8.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaFPZ.81
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaFPZ.this.JCHBAOjos8ActionPerformed(evt);
            }
        });
        this.JBG8_VCAOjos.add(this.JCHBAOjos9);
        this.JCHBAOjos9.setName("9");
        this.JCHBAOjos9.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaFPZ.82
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaFPZ.this.JCHBAOjos9ActionPerformed(evt);
            }
        });
        this.JBG8_VCAOjos.add(this.JCHBAOjos10);
        this.JCHBAOjos10.setName("10");
        this.JCHBAOjos10.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaFPZ.83
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaFPZ.this.JCHBAOjos10ActionPerformed(evt);
            }
        });
        this.JBG8_VCAOjos.add(this.JCHBAOjos11);
        this.JCHBAOjos11.setName("11");
        this.JCHBAOjos11.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaFPZ.84
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaFPZ.this.JCHBAOjos11ActionPerformed(evt);
            }
        });
        this.JBG8_VCAOjos.add(this.JCHBAOjos12);
        this.JCHBAOjos12.setName("12");
        this.JCHBAOjos12.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaFPZ.85
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaFPZ.this.JCHBAOjos12ActionPerformed(evt);
            }
        });
        this.jLabel9.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Derecha.png")));
        this.jLabel10.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Izquierda.png")));
        this.jLabel11.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Arriba.png")));
        this.jLabel12.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Derecha.png")));
        this.jLabel13.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Abajo.png")));
        this.jLabel14.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Derecha.png")));
        this.jLabel15.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Arriba.png")));
        this.jLabel16.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Izquierda.png")));
        this.jLabel17.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Arriba.png")));
        this.jLabel18.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Izquierda.png")));
        this.jLabel19.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Abajo.png")));
        this.jLabel20.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Derecha.png")));
        this.JLB8_VCResultado.setFont(new Font("Arial", 1, 12));
        this.JLB8_VCResultado.setForeground(new Color(255, 0, 0));
        this.JLB8_VCRClasificacion.setFont(new Font("Arial", 1, 12));
        this.JLB8_VCRClasificacion.setForeground(new Color(255, 0, 0));
        GroupLayout JPI8_VCAOjosLayout = new GroupLayout(this.JPI8_VCAOjos);
        this.JPI8_VCAOjos.setLayout(JPI8_VCAOjosLayout);
        JPI8_VCAOjosLayout.setHorizontalGroup(JPI8_VCAOjosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI8_VCAOjosLayout.createSequentialGroup().addContainerGap().addComponent(this.jLabel6).addGroup(JPI8_VCAOjosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI8_VCAOjosLayout.createSequentialGroup().addGap(21, 21, 21).addComponent(this.jLabel9).addGap(18, 18, 18).addComponent(this.jLabel10)).addGroup(JPI8_VCAOjosLayout.createSequentialGroup().addGap(18, 18, 18).addComponent(this.JCHBAOjos).addGap(12, 12, 12).addComponent(this.JCHBAOjos1))).addGap(18, 18, 18).addGroup(JPI8_VCAOjosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI8_VCAOjosLayout.createSequentialGroup().addComponent(this.JCHBAOjos3).addGap(18, 18, 18).addComponent(this.JCHBAOjos4)).addGroup(JPI8_VCAOjosLayout.createSequentialGroup().addComponent(this.jLabel11).addGap(26, 26, 26).addComponent(this.jLabel12))).addGap(21, 21, 21).addGroup(JPI8_VCAOjosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI8_VCAOjosLayout.createSequentialGroup().addComponent(this.jLabel13).addGap(22, 22, 22).addComponent(this.jLabel14)).addGroup(JPI8_VCAOjosLayout.createSequentialGroup().addComponent(this.JCHBAOjos5).addGap(15, 15, 15).addComponent(this.JCHBAOjos6))).addGap(23, 23, 23).addGroup(JPI8_VCAOjosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHBAOjos7).addComponent(this.jLabel15)).addGroup(JPI8_VCAOjosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI8_VCAOjosLayout.createSequentialGroup().addGap(24, 24, 24).addComponent(this.jLabel16)).addGroup(JPI8_VCAOjosLayout.createSequentialGroup().addGap(21, 21, 21).addComponent(this.JCHBAOjos8))).addGap(21, 21, 21).addGroup(JPI8_VCAOjosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHBAOjos9).addComponent(this.jLabel17)).addGap(23, 23, 23).addGroup(JPI8_VCAOjosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHBAOjos10).addComponent(this.jLabel18)).addGap(24, 24, 24).addGroup(JPI8_VCAOjosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHBAOjos11).addComponent(this.jLabel19)).addGroup(JPI8_VCAOjosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI8_VCAOjosLayout.createSequentialGroup().addGap(24, 24, 24).addComponent(this.JCHBAOjos12)).addGroup(JPI8_VCAOjosLayout.createSequentialGroup().addGap(26, 26, 26).addComponent(this.jLabel20))).addGap(18, 18, 18).addComponent(this.JLB8_VCResultado, -2, 55, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLB8_VCRClasificacion, -1, -1, 32767).addContainerGap()));
        JPI8_VCAOjosLayout.setVerticalGroup(JPI8_VCAOjosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI8_VCAOjosLayout.createSequentialGroup().addContainerGap().addComponent(this.jLabel6)).addGroup(JPI8_VCAOjosLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPI8_VCAOjosLayout.createSequentialGroup().addComponent(this.jLabel19).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JCHBAOjos11)).addGroup(GroupLayout.Alignment.TRAILING, JPI8_VCAOjosLayout.createSequentialGroup().addComponent(this.jLabel13).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JCHBAOjos5)).addGroup(JPI8_VCAOjosLayout.createSequentialGroup().addComponent(this.jLabel12).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JCHBAOjos4)).addGroup(JPI8_VCAOjosLayout.createSequentialGroup().addComponent(this.jLabel11).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JCHBAOjos3)).addGroup(JPI8_VCAOjosLayout.createSequentialGroup().addGroup(JPI8_VCAOjosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI8_VCAOjosLayout.createSequentialGroup().addComponent(this.jLabel9).addGap(3, 3, 3)).addGroup(GroupLayout.Alignment.TRAILING, JPI8_VCAOjosLayout.createSequentialGroup().addComponent(this.jLabel10).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED))).addGroup(JPI8_VCAOjosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHBAOjos).addComponent(this.JCHBAOjos1))).addGroup(JPI8_VCAOjosLayout.createSequentialGroup().addGroup(JPI8_VCAOjosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel14).addComponent(this.jLabel15).addComponent(this.jLabel16).addComponent(this.jLabel17).addComponent(this.jLabel18)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(JPI8_VCAOjosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHBAOjos10, GroupLayout.Alignment.TRAILING).addComponent(this.JCHBAOjos9, GroupLayout.Alignment.TRAILING).addComponent(this.JCHBAOjos8, GroupLayout.Alignment.TRAILING).addComponent(this.JCHBAOjos7, GroupLayout.Alignment.TRAILING).addComponent(this.JCHBAOjos6, GroupLayout.Alignment.TRAILING)))).addGroup(JPI8_VCAOjosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPI8_VCAOjosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLB8_VCResultado, -2, 41, -2).addComponent(this.JLB8_VCRClasificacion, -2, 41, -2)).addGroup(JPI8_VCAOjosLayout.createSequentialGroup().addComponent(this.jLabel20).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHBAOjos12))));
        this.JPI9_VCDerecho.setBorder(BorderFactory.createEtchedBorder());
        this.jLabel7.setFont(new Font("Arial", 1, 12));
        this.jLabel7.setForeground(Color.blue);
        this.jLabel7.setText("9. Derecho ");
        this.JBG9_VCODerecho.add(this.JCHBDerecho);
        this.JCHBDerecho.setName("1");
        this.JCHBDerecho.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaFPZ.86
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaFPZ.this.JCHBDerechoActionPerformed(evt);
            }
        });
        this.JBG9_VCODerecho.add(this.JCHBDerecho1);
        this.JCHBDerecho1.setName("2");
        this.JCHBDerecho1.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaFPZ.87
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaFPZ.this.JCHBDerecho1ActionPerformed(evt);
            }
        });
        this.JBG9_VCODerecho.add(this.JCHBDerecho2);
        this.JCHBDerecho2.setName("4");
        this.JCHBDerecho2.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaFPZ.88
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaFPZ.this.JCHBDerecho2ActionPerformed(evt);
            }
        });
        this.JBG9_VCODerecho.add(this.JCHBDerecho3);
        this.JCHBDerecho3.setName("3");
        this.JCHBDerecho3.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaFPZ.89
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaFPZ.this.JCHBDerecho3ActionPerformed(evt);
            }
        });
        this.JBG9_VCODerecho.add(this.JCHBDerecho4);
        this.JCHBDerecho4.setName("5");
        this.JCHBDerecho4.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaFPZ.90
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaFPZ.this.JCHBDerecho4ActionPerformed(evt);
            }
        });
        this.JBG9_VCODerecho.add(this.JCHBDerecho5);
        this.JCHBDerecho5.setName("6");
        this.JCHBDerecho5.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaFPZ.91
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaFPZ.this.JCHBDerecho5ActionPerformed(evt);
            }
        });
        this.JBG9_VCODerecho.add(this.JCHBDerecho6);
        this.JCHBDerecho6.setName("7");
        this.JCHBDerecho6.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaFPZ.92
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaFPZ.this.JCHBDerecho6ActionPerformed(evt);
            }
        });
        this.JBG9_VCODerecho.add(this.JCHBDerecho7);
        this.JCHBDerecho7.setName("8");
        this.JCHBDerecho7.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaFPZ.93
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaFPZ.this.JCHBDerecho7ActionPerformed(evt);
            }
        });
        this.JBG9_VCODerecho.add(this.JCHBDerecho8);
        this.JCHBDerecho8.setName("9");
        this.JCHBDerecho8.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaFPZ.94
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaFPZ.this.JCHBDerecho8ActionPerformed(evt);
            }
        });
        this.JBG9_VCODerecho.add(this.JCHBDerecho9);
        this.JCHBDerecho9.setName("10");
        this.JCHBDerecho9.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaFPZ.95
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaFPZ.this.JCHBDerecho9ActionPerformed(evt);
            }
        });
        this.JBG9_VCODerecho.add(this.JCHBDerecho10);
        this.JCHBDerecho10.setName("11");
        this.JCHBDerecho10.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaFPZ.96
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaFPZ.this.JCHBDerecho10ActionPerformed(evt);
            }
        });
        this.JBG9_VCODerecho.add(this.JCHBDerecho11);
        this.JCHBDerecho11.setName("12");
        this.JCHBDerecho11.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaFPZ.97
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaFPZ.this.JCHBDerecho11ActionPerformed(evt);
            }
        });
        this.jLabel21.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Arriba.png")));
        this.jLabel22.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Abajo.png")));
        this.jLabel29.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Arriba.png")));
        this.jLabel30.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Abajo.png")));
        this.jLabel31.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Derecha.png")));
        this.jLabel32.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Arriba.png")));
        this.jLabel33.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Derecha.png")));
        this.jLabel34.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Izquierda.png")));
        this.jLabel35.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Abajo.png")));
        this.jLabel36.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Izquierda.png")));
        this.jLabel37.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Derecha.png")));
        this.jLabel38.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Derecha.png")));
        this.JLB9_VCDResultado.setFont(new Font("Arial", 1, 12));
        this.JLB9_VCDResultado.setForeground(new Color(255, 0, 0));
        this.JLB9_VCDClasificacion.setFont(new Font("Arial", 1, 12));
        this.JLB9_VCDClasificacion.setForeground(new Color(255, 0, 0));
        GroupLayout JPI9_VCDerechoLayout = new GroupLayout(this.JPI9_VCDerecho);
        this.JPI9_VCDerecho.setLayout(JPI9_VCDerechoLayout);
        JPI9_VCDerechoLayout.setHorizontalGroup(JPI9_VCDerechoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI9_VCDerechoLayout.createSequentialGroup().addContainerGap().addComponent(this.jLabel7).addGroup(JPI9_VCDerechoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI9_VCDerechoLayout.createSequentialGroup().addGap(35, 35, 35).addComponent(this.JCHBDerecho).addGap(12, 12, 12).addComponent(this.JCHBDerecho1)).addGroup(JPI9_VCDerechoLayout.createSequentialGroup().addGap(36, 36, 36).addComponent(this.jLabel21).addGap(22, 22, 22).addComponent(this.jLabel22))).addGap(18, 18, 18).addGroup(JPI9_VCDerechoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPI9_VCDerechoLayout.createSequentialGroup().addComponent(this.JCHBDerecho3).addGap(23, 23, 23).addComponent(this.JCHBDerecho2).addGap(18, 18, 18).addComponent(this.JCHBDerecho4)).addGroup(JPI9_VCDerechoLayout.createSequentialGroup().addComponent(this.jLabel29).addGap(35, 35, 35).addComponent(this.jLabel30).addGap(24, 24, 24).addComponent(this.jLabel31))).addGap(18, 18, 18).addGroup(JPI9_VCDerechoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHBDerecho5).addComponent(this.jLabel32)).addGap(18, 18, 18).addGroup(JPI9_VCDerechoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jLabel33).addComponent(this.JCHBDerecho6)).addGap(24, 24, 24).addGroup(JPI9_VCDerechoLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JCHBDerecho7).addComponent(this.jLabel34)).addGroup(JPI9_VCDerechoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI9_VCDerechoLayout.createSequentialGroup().addGap(21, 21, 21).addComponent(this.JCHBDerecho8)).addGroup(JPI9_VCDerechoLayout.createSequentialGroup().addGap(25, 25, 25).addComponent(this.jLabel35))).addGroup(JPI9_VCDerechoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI9_VCDerechoLayout.createSequentialGroup().addGap(24, 24, 24).addComponent(this.JCHBDerecho9)).addGroup(JPI9_VCDerechoLayout.createSequentialGroup().addGap(26, 26, 26).addComponent(this.jLabel36))).addGap(23, 23, 23).addGroup(JPI9_VCDerechoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPI9_VCDerechoLayout.createSequentialGroup().addComponent(this.JCHBDerecho10).addGap(24, 24, 24).addComponent(this.JCHBDerecho11)).addGroup(JPI9_VCDerechoLayout.createSequentialGroup().addComponent(this.jLabel37).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.jLabel38))).addGap(18, 18, 18).addComponent(this.JLB9_VCDResultado, -2, 55, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLB9_VCDClasificacion, -1, -1, 32767).addContainerGap()));
        JPI9_VCDerechoLayout.setVerticalGroup(JPI9_VCDerechoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI9_VCDerechoLayout.createSequentialGroup().addGroup(JPI9_VCDerechoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI9_VCDerechoLayout.createSequentialGroup().addContainerGap().addComponent(this.jLabel7)).addGroup(JPI9_VCDerechoLayout.createSequentialGroup().addGroup(JPI9_VCDerechoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel32).addComponent(this.jLabel35).addComponent(this.jLabel36).addComponent(this.jLabel37).addComponent(this.jLabel38).addGroup(JPI9_VCDerechoLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jLabel33).addComponent(this.jLabel34))).addGroup(JPI9_VCDerechoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI9_VCDerechoLayout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPI9_VCDerechoLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JCHBDerecho6).addComponent(this.JCHBDerecho7).addComponent(this.JCHBDerecho8).addComponent(this.JCHBDerecho9).addComponent(this.JCHBDerecho10).addComponent(this.JCHBDerecho11))).addGroup(JPI9_VCDerechoLayout.createSequentialGroup().addGap(2, 2, 2).addComponent(this.JCHBDerecho5)))).addGroup(JPI9_VCDerechoLayout.createSequentialGroup().addGroup(JPI9_VCDerechoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel22).addComponent(this.jLabel21).addComponent(this.jLabel29).addComponent(this.jLabel30).addComponent(this.jLabel31)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPI9_VCDerechoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHBDerecho).addComponent(this.JCHBDerecho1).addComponent(this.JCHBDerecho3).addComponent(this.JCHBDerecho2).addComponent(this.JCHBDerecho4))).addComponent(this.JLB9_VCDResultado, -2, 41, -2).addComponent(this.JLB9_VCDClasificacion, -2, 41, -2)).addContainerGap(-1, 32767)));
        this.JPI10_VCIzquierdo.setBorder(BorderFactory.createEtchedBorder());
        this.jLabel8.setFont(new Font("Arial", 1, 12));
        this.jLabel8.setForeground(Color.blue);
        this.jLabel8.setText("10. Izquierdo");
        this.JBG10_VCOIzquierdo.add(this.JCHBIzquierdo);
        this.JCHBIzquierdo.setName("1");
        this.JCHBIzquierdo.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaFPZ.98
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaFPZ.this.JCHBIzquierdoActionPerformed(evt);
            }
        });
        this.JBG10_VCOIzquierdo.add(this.JCHBIzquierdo1);
        this.JCHBIzquierdo1.setName("2");
        this.JCHBIzquierdo1.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaFPZ.99
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaFPZ.this.JCHBIzquierdo1ActionPerformed(evt);
            }
        });
        this.JBG10_VCOIzquierdo.add(this.JCHBIzquierdo2);
        this.JCHBIzquierdo2.setName("3");
        this.JCHBIzquierdo2.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaFPZ.100
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaFPZ.this.JCHBIzquierdo2ActionPerformed(evt);
            }
        });
        this.JBG10_VCOIzquierdo.add(this.JCHBIzquierdo3);
        this.JCHBIzquierdo3.setName("4");
        this.JCHBIzquierdo3.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaFPZ.101
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaFPZ.this.JCHBIzquierdo3ActionPerformed(evt);
            }
        });
        this.JBG10_VCOIzquierdo.add(this.JCHBIzquierdo4);
        this.JCHBIzquierdo4.setName("5");
        this.JCHBIzquierdo4.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaFPZ.102
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaFPZ.this.JCHBIzquierdo4ActionPerformed(evt);
            }
        });
        this.JBG10_VCOIzquierdo.add(this.JCHBIzquierdo5);
        this.JCHBIzquierdo5.setName("6");
        this.JCHBIzquierdo5.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaFPZ.103
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaFPZ.this.JCHBIzquierdo5ActionPerformed(evt);
            }
        });
        this.JBG10_VCOIzquierdo.add(this.JCHBIzquierdo6);
        this.JCHBIzquierdo6.setName("7");
        this.JCHBIzquierdo6.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaFPZ.104
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaFPZ.this.JCHBIzquierdo6ActionPerformed(evt);
            }
        });
        this.JBG10_VCOIzquierdo.add(this.JCHBIzquierdo7);
        this.JCHBIzquierdo7.setName("8");
        this.JCHBIzquierdo7.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaFPZ.105
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaFPZ.this.JCHBIzquierdo7ActionPerformed(evt);
            }
        });
        this.JBG10_VCOIzquierdo.add(this.JCHBIzquierdo8);
        this.JCHBIzquierdo8.setName("9");
        this.JCHBIzquierdo8.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaFPZ.106
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaFPZ.this.JCHBIzquierdo8ActionPerformed(evt);
            }
        });
        this.JBG10_VCOIzquierdo.add(this.JCHBIzquierdo9);
        this.JCHBIzquierdo9.setName("10");
        this.JCHBIzquierdo9.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaFPZ.107
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaFPZ.this.JCHBIzquierdo9ActionPerformed(evt);
            }
        });
        this.JBG10_VCOIzquierdo.add(this.JCHBIzquierdo10);
        this.JCHBIzquierdo10.setName("11");
        this.JCHBIzquierdo10.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaFPZ.108
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaFPZ.this.JCHBIzquierdo10ActionPerformed(evt);
            }
        });
        this.JBG10_VCOIzquierdo.add(this.JCHBIzquierdo11);
        this.JCHBIzquierdo11.setName("12");
        this.JCHBIzquierdo11.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaFPZ.109
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaFPZ.this.JCHBIzquierdo11ActionPerformed(evt);
            }
        });
        this.jLabel39.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Abajo.png")));
        this.jLabel40.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Izquierda.png")));
        this.jLabel41.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Abajo.png")));
        this.jLabel45.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Derecha.png")));
        this.jLabel46.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Arriba.png")));
        this.jLabel47.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Izquierda.png")));
        this.jLabel56.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Arriba.png")));
        this.jLabel58.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Derecha.png")));
        this.jLabel59.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Derecha.png")));
        this.jLabel60.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Izquierda.png")));
        this.jLabel61.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Derecha.png")));
        this.jLabel57.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Abajo.png")));
        this.JLB10_VCResultado.setFont(new Font("Arial", 1, 12));
        this.JLB10_VCResultado.setForeground(new Color(255, 0, 0));
        this.JLB10_VCClasificacion.setFont(new Font("Arial", 1, 12));
        this.JLB10_VCClasificacion.setForeground(new Color(255, 0, 0));
        GroupLayout JPI10_VCIzquierdoLayout = new GroupLayout(this.JPI10_VCIzquierdo);
        this.JPI10_VCIzquierdo.setLayout(JPI10_VCIzquierdoLayout);
        JPI10_VCIzquierdoLayout.setHorizontalGroup(JPI10_VCIzquierdoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI10_VCIzquierdoLayout.createSequentialGroup().addContainerGap().addComponent(this.jLabel8).addGroup(JPI10_VCIzquierdoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI10_VCIzquierdoLayout.createSequentialGroup().addGap(26, 26, 26).addComponent(this.JCHBIzquierdo)).addGroup(JPI10_VCIzquierdoLayout.createSequentialGroup().addGap(30, 30, 30).addComponent(this.jLabel39))).addGroup(JPI10_VCIzquierdoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI10_VCIzquierdoLayout.createSequentialGroup().addGap(15, 15, 15).addComponent(this.jLabel40)).addGroup(JPI10_VCIzquierdoLayout.createSequentialGroup().addGap(12, 12, 12).addComponent(this.JCHBIzquierdo1))).addGroup(JPI10_VCIzquierdoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI10_VCIzquierdoLayout.createSequentialGroup().addGap(18, 18, 18).addComponent(this.JCHBIzquierdo2).addGap(24, 24, 24).addComponent(this.JCHBIzquierdo3)).addGroup(JPI10_VCIzquierdoLayout.createSequentialGroup().addGap(21, 21, 21).addComponent(this.jLabel41).addGap(27, 27, 27).addComponent(this.jLabel45))).addGap(21, 21, 21).addGroup(JPI10_VCIzquierdoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHBIzquierdo4).addComponent(this.jLabel46)).addGap(18, 18, 18).addGroup(JPI10_VCIzquierdoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPI10_VCIzquierdoLayout.createSequentialGroup().addComponent(this.JCHBIzquierdo5).addGap(21, 21, 21).addComponent(this.JCHBIzquierdo6)).addGroup(JPI10_VCIzquierdoLayout.createSequentialGroup().addComponent(this.jLabel47).addGap(27, 27, 27).addComponent(this.jLabel56))).addGap(24, 24, 24).addGroup(JPI10_VCIzquierdoLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPI10_VCIzquierdoLayout.createSequentialGroup().addComponent(this.JCHBIzquierdo7).addGap(20, 20, 20).addComponent(this.JCHBIzquierdo8)).addGroup(JPI10_VCIzquierdoLayout.createSequentialGroup().addComponent(this.jLabel57).addGap(25, 25, 25).addComponent(this.jLabel58))).addGroup(JPI10_VCIzquierdoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI10_VCIzquierdoLayout.createSequentialGroup().addGap(29, 29, 29).addComponent(this.jLabel59)).addGroup(JPI10_VCIzquierdoLayout.createSequentialGroup().addGap(24, 24, 24).addComponent(this.JCHBIzquierdo9))).addGap(24, 24, 24).addGroup(JPI10_VCIzquierdoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel60).addComponent(this.JCHBIzquierdo10)).addGap(22, 22, 22).addGroup(JPI10_VCIzquierdoLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JCHBIzquierdo11).addComponent(this.jLabel61)).addGap(18, 18, 18).addComponent(this.JLB10_VCResultado, -2, 55, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLB10_VCClasificacion, -1, -1, 32767).addGap(3, 3, 3)));
        JPI10_VCIzquierdoLayout.setVerticalGroup(JPI10_VCIzquierdoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI10_VCIzquierdoLayout.createSequentialGroup().addContainerGap().addComponent(this.jLabel8).addGap(0, 0, 32767)).addGroup(GroupLayout.Alignment.TRAILING, JPI10_VCIzquierdoLayout.createSequentialGroup().addGroup(JPI10_VCIzquierdoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI10_VCIzquierdoLayout.createSequentialGroup().addComponent(this.jLabel40).addGap(0, 0, 32767)).addGroup(GroupLayout.Alignment.TRAILING, JPI10_VCIzquierdoLayout.createSequentialGroup().addGap(0, 0, 32767).addGroup(JPI10_VCIzquierdoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel46).addGroup(JPI10_VCIzquierdoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel39, GroupLayout.Alignment.TRAILING).addComponent(this.jLabel45, GroupLayout.Alignment.TRAILING)).addComponent(this.jLabel47).addComponent(this.jLabel56).addComponent(this.jLabel58).addComponent(this.jLabel59).addComponent(this.jLabel60).addComponent(this.jLabel61).addComponent(this.jLabel41).addComponent(this.jLabel57)))).addGroup(JPI10_VCIzquierdoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHBIzquierdo1, GroupLayout.Alignment.TRAILING).addComponent(this.JCHBIzquierdo, GroupLayout.Alignment.TRAILING).addGroup(GroupLayout.Alignment.TRAILING, JPI10_VCIzquierdoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHBIzquierdo9).addComponent(this.JCHBIzquierdo10).addComponent(this.JCHBIzquierdo11).addComponent(this.JCHBIzquierdo8).addComponent(this.JCHBIzquierdo7).addComponent(this.JCHBIzquierdo6).addComponent(this.JCHBIzquierdo5).addComponent(this.JCHBIzquierdo4).addComponent(this.JCHBIzquierdo3).addComponent(this.JCHBIzquierdo2)))).addGroup(GroupLayout.Alignment.TRAILING, JPI10_VCIzquierdoLayout.createSequentialGroup().addGap(0, 0, 32767).addGroup(JPI10_VCIzquierdoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLB10_VCResultado, -2, 41, -2).addComponent(this.JLB10_VCClasificacion, -2, 41, -2))));
        this.JPI11_VCFLateral.setBorder(BorderFactory.createEtchedBorder());
        this.JPI11_VCFLateral.setName("xpanelforialateral2");
        this.jLabel28.setFont(new Font("Arial", 1, 12));
        this.jLabel28.setForeground(Color.blue);
        this.jLabel28.setText("11. Foria Lateral");
        this.JBForiaLateral2.add(this.JCHBVCLateral);
        this.JCHBVCLateral.setName("1");
        this.JCHBVCLateral.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaFPZ.110
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaFPZ.this.JCHBVCLateralActionPerformed(evt);
            }
        });
        this.JBForiaLateral2.add(this.JCHBVCLateral2);
        this.JCHBVCLateral2.setName("2");
        this.JCHBVCLateral2.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaFPZ.111
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaFPZ.this.JCHBVCLateral2ActionPerformed(evt);
            }
        });
        this.JBForiaLateral2.add(this.JCHBVCLateral3);
        this.JCHBVCLateral3.setName("3");
        this.JCHBVCLateral3.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaFPZ.112
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaFPZ.this.JCHBVCLateral3ActionPerformed(evt);
            }
        });
        this.JBForiaLateral2.add(this.JCHBVCLateral4);
        this.JCHBVCLateral4.setName("4");
        this.JCHBVCLateral4.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaFPZ.113
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaFPZ.this.JCHBVCLateral4ActionPerformed(evt);
            }
        });
        this.JBForiaLateral2.add(this.JCHBVCLateral5);
        this.JCHBVCLateral5.setName("5");
        this.JCHBVCLateral5.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaFPZ.114
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaFPZ.this.JCHBVCLateral5ActionPerformed(evt);
            }
        });
        this.JBForiaLateral2.add(this.JCHBVCLateral6);
        this.JCHBVCLateral6.setName("6");
        this.JCHBVCLateral6.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaFPZ.115
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaFPZ.this.JCHBVCLateral6ActionPerformed(evt);
            }
        });
        this.JBForiaLateral2.add(this.JCHBVCLateral7);
        this.JCHBVCLateral7.setName("7");
        this.JCHBVCLateral7.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaFPZ.116
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaFPZ.this.JCHBVCLateral7ActionPerformed(evt);
            }
        });
        this.JBForiaLateral2.add(this.JCHBVCLateral8);
        this.JCHBVCLateral8.setName("8");
        this.JCHBVCLateral8.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaFPZ.117
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaFPZ.this.JCHBVCLateral8ActionPerformed(evt);
            }
        });
        this.JBForiaLateral2.add(this.JCHBVCLateral9);
        this.JCHBVCLateral9.setName("9");
        this.JCHBVCLateral9.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaFPZ.118
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaFPZ.this.JCHBVCLateral9ActionPerformed(evt);
            }
        });
        this.JBForiaLateral2.add(this.JCHBVCLateral10);
        this.JCHBVCLateral10.setName("10");
        this.JCHBVCLateral10.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaFPZ.119
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaFPZ.this.JCHBVCLateral10ActionPerformed(evt);
            }
        });
        this.JBForiaLateral2.add(this.JCHBVCLateral11);
        this.JCHBVCLateral11.setName("11");
        this.JCHBVCLateral11.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaFPZ.120
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaFPZ.this.JCHBVCLateral11ActionPerformed(evt);
            }
        });
        this.JBForiaLateral2.add(this.JCHBVCLateral12);
        this.JCHBVCLateral12.setName("12");
        this.JCHBVCLateral12.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaFPZ.121
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaFPZ.this.JCHBVCLateral12ActionPerformed(evt);
            }
        });
        this.JBForiaLateral2.add(this.JCHBVCLateral13);
        this.JCHBVCLateral13.setName("13");
        this.JCHBVCLateral13.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaFPZ.122
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaFPZ.this.JCHBVCLateral13ActionPerformed(evt);
            }
        });
        this.JBForiaLateral2.add(this.JCHBVCLateral14);
        this.JCHBVCLateral14.setName("14");
        this.JCHBVCLateral14.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaFPZ.123
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaFPZ.this.JCHBVCLateral14ActionPerformed(evt);
            }
        });
        this.JBForiaLateral2.add(this.JCHBVCLateral15);
        this.JCHBVCLateral15.setName("15");
        this.JCHBVCLateral15.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaFPZ.124
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaFPZ.this.JCHBVCLateral15ActionPerformed(evt);
            }
        });
        this.jLabel55.setFont(new Font("Arial", 1, 12));
        this.jLabel55.setForeground(new Color(0, 102, 0));
        this.jLabel55.setText("  1        2         3         4         5         6         7         8         9        10        11       12       13       14       15");
        this.JLB11_VCFLaClasificacion.setFont(new Font("Arial", 1, 12));
        this.JLB11_VCFLaClasificacion.setForeground(new Color(255, 0, 0));
        GroupLayout JPI11_VCFLateralLayout = new GroupLayout(this.JPI11_VCFLateral);
        this.JPI11_VCFLateral.setLayout(JPI11_VCFLateralLayout);
        JPI11_VCFLateralLayout.setHorizontalGroup(JPI11_VCFLateralLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI11_VCFLateralLayout.createSequentialGroup().addContainerGap().addComponent(this.jLabel28).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPI11_VCFLateralLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel55).addGroup(JPI11_VCFLateralLayout.createSequentialGroup().addComponent(this.JCHBVCLateral).addGap(10, 10, 10).addComponent(this.JCHBVCLateral2).addGap(13, 13, 13).addComponent(this.JCHBVCLateral3).addGap(13, 13, 13).addComponent(this.JCHBVCLateral4).addGap(15, 15, 15).addComponent(this.JCHBVCLateral5).addGap(13, 13, 13).addComponent(this.JCHBVCLateral6).addGap(15, 15, 15).addComponent(this.JCHBVCLateral7).addGap(15, 15, 15).addComponent(this.JCHBVCLateral8).addGap(10, 10, 10).addComponent(this.JCHBVCLateral9).addGap(10, 10, 10).addComponent(this.JCHBVCLateral10).addGap(18, 18, 18).addComponent(this.JCHBVCLateral11).addGap(15, 15, 15).addComponent(this.JCHBVCLateral12).addGap(10, 10, 10).addComponent(this.JCHBVCLateral13).addGap(18, 18, 18).addComponent(this.JCHBVCLateral14).addGap(13, 13, 13).addComponent(this.JCHBVCLateral15))).addGap(40, 40, 40).addComponent(this.JLB11_VCFLaClasificacion, -1, -1, 32767).addGap(19, 19, 19)));
        JPI11_VCFLateralLayout.setVerticalGroup(JPI11_VCFLateralLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI11_VCFLateralLayout.createSequentialGroup().addContainerGap().addComponent(this.jLabel28).addContainerGap(-1, 32767)).addGroup(JPI11_VCFLateralLayout.createSequentialGroup().addGroup(JPI11_VCFLateralLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JLB11_VCFLaClasificacion, -2, 41, -2).addGroup(JPI11_VCFLateralLayout.createSequentialGroup().addComponent(this.jLabel55).addGap(7, 7, 7).addGroup(JPI11_VCFLateralLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JCHBVCLateral).addComponent(this.JCHBVCLateral2).addComponent(this.JCHBVCLateral3).addComponent(this.JCHBVCLateral4).addComponent(this.JCHBVCLateral5).addComponent(this.JCHBVCLateral6).addComponent(this.JCHBVCLateral7).addComponent(this.JCHBVCLateral8).addComponent(this.JCHBVCLateral9).addComponent(this.JCHBVCLateral10).addComponent(this.JCHBVCLateral11).addComponent(this.JCHBVCLateral12).addComponent(this.JCHBVCLateral13).addComponent(this.JCHBVCLateral14).addComponent(this.JCHBVCLateral15)))).addGap(0, 0, 32767)));
        this.JLB13.setFont(new Font("Arial", 1, 12));
        this.JLB13.setForeground(new Color(255, 0, 0));
        this.JLB13.setText("1");
        this.JLB14.setFont(new Font("Arial", 1, 12));
        this.JLB14.setForeground(new Color(255, 0, 0));
        this.JLB14.setText("2");
        this.JLB15.setFont(new Font("Arial", 1, 12));
        this.JLB15.setForeground(new Color(255, 0, 51));
        this.JLB15.setText("3");
        this.JLB16.setFont(new Font("Arial", 1, 12));
        this.JLB16.setForeground(new Color(255, 0, 51));
        this.JLB16.setText("4");
        this.JLB17.setFont(new Font("Arial", 1, 12));
        this.JLB17.setForeground(new Color(255, 0, 51));
        this.JLB17.setText("5");
        this.JLB18.setFont(new Font("Arial", 1, 12));
        this.JLB18.setForeground(new Color(255, 0, 51));
        this.JLB18.setText("6");
        this.JLB19.setFont(new Font("Arial", 1, 12));
        this.JLB19.setForeground(new Color(255, 0, 51));
        this.JLB19.setText("7");
        this.JLB20.setFont(new Font("Arial", 1, 12));
        this.JLB20.setForeground(new Color(255, 0, 51));
        this.JLB20.setText("8");
        this.JLB21.setFont(new Font("Arial", 1, 12));
        this.JLB21.setForeground(new Color(255, 0, 51));
        this.JLB21.setText("9");
        this.JLB22.setFont(new Font("Arial", 1, 12));
        this.JLB22.setForeground(new Color(255, 0, 51));
        this.JLB22.setText("10");
        this.JLB23.setFont(new Font("Arial", 1, 12));
        this.JLB23.setForeground(new Color(255, 0, 51));
        this.JLB23.setText("11");
        this.JLB24.setFont(new Font("Arial", 1, 12));
        this.JLB24.setForeground(new Color(255, 0, 51));
        this.JLB24.setText("12");
        GroupLayout JPINumeros1Layout = new GroupLayout(this.JPINumeros1);
        this.JPINumeros1.setLayout(JPINumeros1Layout);
        JPINumeros1Layout.setHorizontalGroup(JPINumeros1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPINumeros1Layout.createSequentialGroup().addGap(31, 31, 31).addComponent(this.JLB13).addGap(27, 27, 27).addComponent(this.JLB14).addGap(33, 33, 33).addComponent(this.JLB15).addGap(33, 33, 33).addComponent(this.JLB16).addGap(33, 33, 33).addComponent(this.JLB17).addGap(34, 34, 34).addComponent(this.JLB18).addGap(33, 33, 33).addComponent(this.JLB19).addGap(34, 34, 34).addComponent(this.JLB20).addGap(33, 33, 33).addComponent(this.JLB21).addGap(33, 33, 33).addComponent(this.JLB22).addGap(33, 33, 33).addComponent(this.JLB23).addGap(32, 32, 32).addComponent(this.JLB24).addContainerGap(-1, 32767)));
        JPINumeros1Layout.setVerticalGroup(JPINumeros1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPINumeros1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JLB13).addComponent(this.JLB14).addComponent(this.JLB15).addComponent(this.JLB16).addComponent(this.JLB17).addComponent(this.JLB18).addComponent(this.JLB19).addComponent(this.JLB20).addComponent(this.JLB21).addComponent(this.JLB22).addComponent(this.JLB23).addComponent(this.JLB24)));
        this.JPIDatosGenerales.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN GENERAL", 0, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JCHDGLentesC.setFont(new Font("Arial", 1, 12));
        this.JCHDGLentesC.setText("Lentes de Contacto?");
        this.JCHDGLentesC.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaFPZ.125
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaFPZ.this.JCHDGLentesCActionPerformed(evt);
            }
        });
        this.JCHDGSLentesF.setFont(new Font("Arial", 1, 12));
        this.JCHDGSLentesF.setText("Se realiza con lentes formulados?");
        this.JCHDGSLentesF.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaFPZ.126
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaFPZ.this.JCHDGSLentesFActionPerformed(evt);
            }
        });
        this.JPITipoGafas.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de gafas", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JBGTGafas.add(this.JRBDGTGNinguna);
        this.JRBDGTGNinguna.setFont(new Font("Arial", 1, 12));
        this.JRBDGTGNinguna.setSelected(true);
        this.JRBDGTGNinguna.setText("Ninguna");
        this.JRBDGTGNinguna.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaFPZ.127
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaFPZ.this.JRBDGTGNingunaActionPerformed(evt);
            }
        });
        this.JBGTGafas.add(this.JRBDGTGPersonal);
        this.JRBDGTGPersonal.setFont(new Font("Arial", 1, 12));
        this.JRBDGTGPersonal.setText("Personal");
        this.JRBDGTGPersonal.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaFPZ.128
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaFPZ.this.JRBDGTGPersonalActionPerformed(evt);
            }
        });
        this.JBGTGafas.add(this.JRBDGTGSeguridad);
        this.JRBDGTGSeguridad.setFont(new Font("Arial", 1, 12));
        this.JRBDGTGSeguridad.setText("Seguridad");
        this.JRBDGTGSeguridad.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaFPZ.129
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaFPZ.this.JRBDGTGSeguridadActionPerformed(evt);
            }
        });
        GroupLayout JPITipoGafasLayout = new GroupLayout(this.JPITipoGafas);
        this.JPITipoGafas.setLayout(JPITipoGafasLayout);
        JPITipoGafasLayout.setHorizontalGroup(JPITipoGafasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPITipoGafasLayout.createSequentialGroup().addContainerGap().addComponent(this.JRBDGTGNinguna).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBDGTGPersonal).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBDGTGSeguridad, -2, 99, -2).addContainerGap(-1, 32767)));
        JPITipoGafasLayout.setVerticalGroup(JPITipoGafasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPITipoGafasLayout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(JPITipoGafasLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBDGTGPersonal).addComponent(this.JRBDGTGSeguridad).addComponent(this.JRBDGTGNinguna)).addContainerGap()));
        this.JPITipoLentes.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de Lente", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JBGTLentes.add(this.JRBDGTLNinguno);
        this.JRBDGTLNinguno.setFont(new Font("Arial", 1, 12));
        this.JRBDGTLNinguno.setSelected(true);
        this.JRBDGTLNinguno.setText("Ninguno");
        this.JRBDGTLNinguno.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaFPZ.130
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaFPZ.this.JRBDGTLNingunoActionPerformed(evt);
            }
        });
        this.JBGTLentes.add(this.JRBDGTLProgresivo);
        this.JRBDGTLProgresivo.setFont(new Font("Arial", 1, 12));
        this.JRBDGTLProgresivo.setText("Progresivo");
        this.JRBDGTLProgresivo.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaFPZ.131
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaFPZ.this.JRBDGTLProgresivoActionPerformed(evt);
            }
        });
        this.JBGTLentes.add(this.JRBDGTLBifocales);
        this.JRBDGTLBifocales.setFont(new Font("Arial", 1, 12));
        this.JRBDGTLBifocales.setText("Bifocales");
        this.JRBDGTLBifocales.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaFPZ.132
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaFPZ.this.JRBDGTLBifocalesActionPerformed(evt);
            }
        });
        this.JBGTLentes.add(this.JRBDGTLMonofocales);
        this.JRBDGTLMonofocales.setFont(new Font("Arial", 1, 12));
        this.JRBDGTLMonofocales.setText("Monofocales");
        this.JRBDGTLMonofocales.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaFPZ.133
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaFPZ.this.JRBDGTLMonofocalesActionPerformed(evt);
            }
        });
        GroupLayout JPITipoLentesLayout = new GroupLayout(this.JPITipoLentes);
        this.JPITipoLentes.setLayout(JPITipoLentesLayout);
        JPITipoLentesLayout.setHorizontalGroup(JPITipoLentesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPITipoLentesLayout.createSequentialGroup().addContainerGap().addComponent(this.JRBDGTLNinguno).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBDGTLProgresivo).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBDGTLBifocales, -2, 99, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBDGTLMonofocales, -2, 99, -2).addContainerGap(-1, 32767)));
        JPITipoLentesLayout.setVerticalGroup(JPITipoLentesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPITipoLentesLayout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(JPITipoLentesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBDGTLProgresivo).addComponent(this.JRBDGTLBifocales).addComponent(this.JRBDGTLNinguno).addComponent(this.JRBDGTLMonofocales)).addContainerGap()));
        this.JPIUsoCorrecion.setBorder(BorderFactory.createTitledBorder((Border) null, "Uso de corrección", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JBGTCorreccion.add(this.JRBDGTCNinguna);
        this.JRBDGTCNinguna.setFont(new Font("Arial", 1, 12));
        this.JRBDGTCNinguna.setSelected(true);
        this.JRBDGTCNinguna.setText("Ninguna");
        this.JRBDGTCNinguna.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaFPZ.134
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaFPZ.this.JRBDGTCNingunaActionPerformed(evt);
            }
        });
        this.JBGTCorreccion.add(this.JRBDGTCPermanente);
        this.JRBDGTCPermanente.setFont(new Font("Arial", 1, 12));
        this.JRBDGTCPermanente.setText("Permanente");
        this.JRBDGTCPermanente.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaFPZ.135
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaFPZ.this.JRBDGTCPermanenteActionPerformed(evt);
            }
        });
        this.JBGTCorreccion.add(this.JRBDGTCEsporadico);
        this.JRBDGTCEsporadico.setFont(new Font("Arial", 1, 12));
        this.JRBDGTCEsporadico.setText("Esporádica");
        this.JRBDGTCEsporadico.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaFPZ.136
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaFPZ.this.JRBDGTCEsporadicoActionPerformed(evt);
            }
        });
        GroupLayout JPIUsoCorrecionLayout = new GroupLayout(this.JPIUsoCorrecion);
        this.JPIUsoCorrecion.setLayout(JPIUsoCorrecionLayout);
        JPIUsoCorrecionLayout.setHorizontalGroup(JPIUsoCorrecionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIUsoCorrecionLayout.createSequentialGroup().addContainerGap().addComponent(this.JRBDGTCNinguna).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBDGTCPermanente).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBDGTCEsporadico, -2, 99, -2).addContainerGap(-1, 32767)));
        JPIUsoCorrecionLayout.setVerticalGroup(JPIUsoCorrecionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIUsoCorrecionLayout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(JPIUsoCorrecionLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBDGTCPermanente).addComponent(this.JRBDGTCEsporadico).addComponent(this.JRBDGTCNinguna)).addContainerGap()));
        this.JPITCorrecion.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Corrección", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JCHTCLejos.setFont(new Font("Arial", 1, 12));
        this.JCHTCLejos.setText("Lejos");
        this.JCHTCLejos.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaFPZ.137
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaFPZ.this.JCHTCLejosActionPerformed(evt);
            }
        });
        this.JCHTCCerca.setFont(new Font("Arial", 1, 12));
        this.JCHTCCerca.setText("Cerca");
        this.JCHTCCerca.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaFPZ.138
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaFPZ.this.JCHTCCercaActionPerformed(evt);
            }
        });
        GroupLayout JPITCorrecionLayout = new GroupLayout(this.JPITCorrecion);
        this.JPITCorrecion.setLayout(JPITCorrecionLayout);
        JPITCorrecionLayout.setHorizontalGroup(JPITCorrecionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPITCorrecionLayout.createSequentialGroup().addContainerGap().addComponent(this.JCHTCLejos).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHTCCerca).addContainerGap(-1, 32767)));
        JPITCorrecionLayout.setVerticalGroup(JPITCorrecionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPITCorrecionLayout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(JPITCorrecionLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCHTCLejos).addComponent(this.JCHTCCerca)).addContainerGap()));
        GroupLayout JPIDatosGeneralesLayout = new GroupLayout(this.JPIDatosGenerales);
        this.JPIDatosGenerales.setLayout(JPIDatosGeneralesLayout);
        JPIDatosGeneralesLayout.setHorizontalGroup(JPIDatosGeneralesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosGeneralesLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosGeneralesLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPIDatosGeneralesLayout.createSequentialGroup().addGroup(JPIDatosGeneralesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHDGLentesC).addComponent(this.JCHDGSLentesF, -2, 294, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JPITipoLentes, -2, -1, -2)).addGroup(JPIDatosGeneralesLayout.createSequentialGroup().addComponent(this.JPITipoGafas, -2, -1, -2).addGap(18, 18, 18).addComponent(this.JPIUsoCorrecion, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JPITCorrecion, -2, -1, -2))).addContainerGap(-1, 32767)));
        JPIDatosGeneralesLayout.setVerticalGroup(JPIDatosGeneralesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosGeneralesLayout.createSequentialGroup().addGroup(JPIDatosGeneralesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPITipoLentes, -2, -1, -2).addGroup(JPIDatosGeneralesLayout.createSequentialGroup().addContainerGap().addComponent(this.JCHDGLentesC).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHDGSLentesF))).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIDatosGeneralesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPITipoGafas, -2, -1, -2).addComponent(this.JPIUsoCorrecion, -2, -1, -2).addComponent(this.JPITCorrecion, -2, -1, -2)).addContainerGap()));
        GroupLayout JLB12_VCFVClasificacionLayout = new GroupLayout(this.JLB12_VCFVClasificacion);
        this.JLB12_VCFVClasificacion.setLayout(JLB12_VCFVClasificacionLayout);
        JLB12_VCFVClasificacionLayout.setHorizontalGroup(JLB12_VCFVClasificacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JLB12_VCFVClasificacionLayout.createSequentialGroup().addGroup(JLB12_VCFVClasificacionLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JPI10_VCIzquierdo, -1, -1, 32767).addComponent(this.JPI8_VCAOjos, -1, 840, 32767).addComponent(this.JPI9_VCDerecho, -1, -1, 32767).addComponent(this.JPI11_VCFLateral, -1, -1, 32767).addGroup(GroupLayout.Alignment.LEADING, JLB12_VCFVClasificacionLayout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatosGenerales, -1, -1, 32767)).addGroup(GroupLayout.Alignment.LEADING, JLB12_VCFVClasificacionLayout.createSequentialGroup().addGap(84, 84, 84).addComponent(this.JPINumeros1, -2, -1, -2).addGap(0, 0, 32767))).addContainerGap()));
        JLB12_VCFVClasificacionLayout.setVerticalGroup(JLB12_VCFVClasificacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JLB12_VCFVClasificacionLayout.createSequentialGroup().addGap(7, 7, 7).addComponent(this.JPINumeros1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPI8_VCAOjos, -2, 46, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JPI9_VCDerecho, -2, 45, -2).addGap(11, 11, 11).addComponent(this.JPI10_VCIzquierdo, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JPI11_VCFLateral, -2, -1, -2).addGap(57, 57, 57).addComponent(this.JPIDatosGenerales, -2, 153, -2).addContainerGap(-1, 32767)));
        this.JTPDatosTest.addTab("VISIÓN CERCANA", this.JLB12_VCFVClasificacion);
        this.JSPHistorico.setBorder(BorderFactory.createTitledBorder((Border) null, "", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTDetalleHistorico.setFont(new Font("Arial", 1, 12));
        this.JTDetalleHistorico.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalleHistorico.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalleHistorico.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalleHistorico.addMouseListener(new MouseAdapter() { // from class: Historia.JPSo_VisiometriaFPZ.139
            public void mouseClicked(MouseEvent evt) {
                JPSo_VisiometriaFPZ.this.JTDetalleHistoricoMouseClicked(evt);
            }
        });
        this.JSPHistorico.setViewportView(this.JTDetalleHistorico);
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.JSPHistorico, -1, 793, 32767).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.JSPHistorico, -2, 289, -2).addContainerGap(157, 32767)));
        this.JTPDatosTest.addTab("HISTÓRICO", this.jPanel1);
        this.JPInterpretacion.setBorder(BorderFactory.createTitledBorder((Border) null, "INTERPRETACIÓN MÉDICA", 0, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.JTAInterpretacion.setColumns(1);
        this.JTAInterpretacion.setLineWrap(true);
        this.JTAInterpretacion.setRows(1);
        this.JTAInterpretacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.jScrollPane3.setViewportView(this.JTAInterpretacion);
        this.JCBResultado.setFont(new Font("Arial", 1, 12));
        this.JCBResultado.setBorder(BorderFactory.createTitledBorder((Border) null, "Resultado", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JBGuardarInter.setFont(new Font("Arial", 1, 12));
        this.JBGuardarInter.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBGuardarInter.setText("Guardar");
        this.JBGuardarInter.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaFPZ.140
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaFPZ.this.JBGuardarInterActionPerformed(evt);
            }
        });
        GroupLayout JPInterpretacionLayout = new GroupLayout(this.JPInterpretacion);
        this.JPInterpretacion.setLayout(JPInterpretacionLayout);
        JPInterpretacionLayout.setHorizontalGroup(JPInterpretacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPInterpretacionLayout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(JPInterpretacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JCBResultado, 0, 176, 32767).addComponent(this.JBGuardarInter, -1, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane3, -2, 254, -2).addGap(21, 21, 21)));
        JPInterpretacionLayout.setVerticalGroup(JPInterpretacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPInterpretacionLayout.createSequentialGroup().addGroup(JPInterpretacionLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.jScrollPane3, GroupLayout.Alignment.LEADING).addGroup(JPInterpretacionLayout.createSequentialGroup().addComponent(this.JCBResultado, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBGuardarInter, -2, 67, -2))).addGap(0, 0, 32767)));
        this.JBTGrabar.setFont(new Font("Arial", 1, 12));
        this.JBTGrabar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTGrabar.setText("Grabar");
        this.JBTGrabar.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaFPZ.141
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaFPZ.this.JBTGrabarActionPerformed(evt);
            }
        });
        this.JTAObsVisiometria.setColumns(1);
        this.JTAObsVisiometria.setLineWrap(true);
        this.JTAObsVisiometria.setRows(1);
        this.JTAObsVisiometria.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.jScrollPane4.setViewportView(this.JTAObsVisiometria);
        this.JBTActualizar.setFont(new Font("Arial", 1, 12));
        this.JBTActualizar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTActualizar.setText("Actualizar");
        this.JBTActualizar.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaFPZ.142
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaFPZ.this.JBTActualizarActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(23, 23, 23).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JBTGrabar, -1, -1, 32767).addComponent(this.jScrollPane4).addComponent(this.JBTActualizar, GroupLayout.Alignment.TRAILING, -1, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPInterpretacion, -2, 460, -2)).addComponent(this.JTPDatosTest, -2, 818, -2)).addGap(19, 19, 19)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JTPDatosTest, -2, 488, -2).addGap(8, 8, 8).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPInterpretacion, -1, -1, 32767).addGroup(layout.createSequentialGroup().addComponent(this.jScrollPane4, -2, 104, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTGrabar, -2, 45, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTActualizar, -2, 45, -2).addGap(0, 16, 32767))).addContainerGap()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHA1ActionPerformed(ActionEvent evt) {
        mEstablecerResultado(this.JCHA1.getName(), this.JLB1_VLResultado, this.JLB1_VLRClasificacion);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHA2ActionPerformed(ActionEvent evt) {
        mEstablecerResultado(this.JCHA2.getName(), this.JLB1_VLResultado, this.JLB1_VLRClasificacion);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHA3ActionPerformed(ActionEvent evt) {
        mEstablecerResultado(this.JCHA3.getName(), this.JLB1_VLResultado, this.JLB1_VLRClasificacion);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHA4ActionPerformed(ActionEvent evt) {
        mEstablecerResultado(this.JCHA4.getName(), this.JLB1_VLResultado, this.JLB1_VLRClasificacion);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHA5ActionPerformed(ActionEvent evt) {
        mEstablecerResultado(this.JCHA5.getName(), this.JLB1_VLResultado, this.JLB1_VLRClasificacion);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHA6ActionPerformed(ActionEvent evt) {
        mEstablecerResultado(this.JCHA6.getName(), this.JLB1_VLResultado, this.JLB1_VLRClasificacion);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHA7ActionPerformed(ActionEvent evt) {
        mEstablecerResultado(this.JCHA7.getName(), this.JLB1_VLResultado, this.JLB1_VLRClasificacion);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHA8ActionPerformed(ActionEvent evt) {
        mEstablecerResultado(this.JCHA8.getName(), this.JLB1_VLResultado, this.JLB1_VLRClasificacion);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHA9ActionPerformed(ActionEvent evt) {
        mEstablecerResultado(this.JCHA9.getName(), this.JLB1_VLResultado, this.JLB1_VLRClasificacion);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHA10ActionPerformed(ActionEvent evt) {
        mEstablecerResultado(this.JCHA10.getName(), this.JLB1_VLResultado, this.JLB1_VLRClasificacion);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHA11ActionPerformed(ActionEvent evt) {
        mEstablecerResultado(this.JCHA11.getName(), this.JLB1_VLResultado, this.JLB1_VLRClasificacion);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHA12ActionPerformed(ActionEvent evt) {
        mEstablecerResultado(this.JCHA12.getName(), this.JLB1_VLResultado, this.JLB1_VLRClasificacion);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHD1ActionPerformed(ActionEvent evt) {
        mEstablecerResultado(this.JCHD1.getName(), this.JLB2_VLResultado, this.JLB2_VLRClasificacion);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHD2ActionPerformed(ActionEvent evt) {
        mEstablecerResultado(this.JCHD2.getName(), this.JLB2_VLResultado, this.JLB2_VLRClasificacion);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHD3ActionPerformed(ActionEvent evt) {
        mEstablecerResultado(this.JCHD3.getName(), this.JLB2_VLResultado, this.JLB2_VLRClasificacion);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHD4ActionPerformed(ActionEvent evt) {
        mEstablecerResultado(this.JCHD4.getName(), this.JLB2_VLResultado, this.JLB2_VLRClasificacion);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHD5ActionPerformed(ActionEvent evt) {
        mEstablecerResultado(this.JCHD5.getName(), this.JLB2_VLResultado, this.JLB2_VLRClasificacion);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHD6ActionPerformed(ActionEvent evt) {
        mEstablecerResultado(this.JCHD6.getName(), this.JLB2_VLResultado, this.JLB2_VLRClasificacion);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHD7ActionPerformed(ActionEvent evt) {
        mEstablecerResultado(this.JCHD7.getName(), this.JLB2_VLResultado, this.JLB2_VLRClasificacion);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHD8ActionPerformed(ActionEvent evt) {
        mEstablecerResultado(this.JCHD8.getName(), this.JLB2_VLResultado, this.JLB2_VLRClasificacion);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHD9ActionPerformed(ActionEvent evt) {
        mEstablecerResultado(this.JCHD9.getName(), this.JLB2_VLResultado, this.JLB2_VLRClasificacion);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHD10ActionPerformed(ActionEvent evt) {
        mEstablecerResultado(this.JCHD10.getName(), this.JLB2_VLResultado, this.JLB2_VLRClasificacion);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHD11ActionPerformed(ActionEvent evt) {
        mEstablecerResultado(this.JCHD11.getName(), this.JLB2_VLResultado, this.JLB2_VLRClasificacion);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHD12ActionPerformed(ActionEvent evt) {
        mEstablecerResultado(this.JCHD12.getName(), this.JLB2_VLResultado, this.JLB2_VLRClasificacion);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHI1ActionPerformed(ActionEvent evt) {
        mEstablecerResultado(this.JCHI1.getName(), this.JLB3_VLResultado, this.JLB3_VLRClasificacion);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHI2ActionPerformed(ActionEvent evt) {
        mEstablecerResultado(this.JCHI2.getName(), this.JLB3_VLResultado, this.JLB3_VLRClasificacion);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHI3ActionPerformed(ActionEvent evt) {
        mEstablecerResultado(this.JCHI3.getName(), this.JLB3_VLResultado, this.JLB3_VLRClasificacion);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHI4ActionPerformed(ActionEvent evt) {
        mEstablecerResultado(this.JCHI4.getName(), this.JLB3_VLResultado, this.JLB3_VLRClasificacion);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHI5ActionPerformed(ActionEvent evt) {
        mEstablecerResultado(this.JCHI5.getName(), this.JLB3_VLResultado, this.JLB3_VLRClasificacion);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHI6ActionPerformed(ActionEvent evt) {
        mEstablecerResultado(this.JCHI6.getName(), this.JLB3_VLResultado, this.JLB3_VLRClasificacion);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHI7ActionPerformed(ActionEvent evt) {
        mEstablecerResultado(this.JCHI7.getName(), this.JLB3_VLResultado, this.JLB3_VLRClasificacion);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHI8ActionPerformed(ActionEvent evt) {
        mEstablecerResultado(this.JCHI8.getName(), this.JLB3_VLResultado, this.JLB3_VLRClasificacion);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHI9ActionPerformed(ActionEvent evt) {
        mEstablecerResultado(this.JCHI9.getName(), this.JLB3_VLResultado, this.JLB3_VLRClasificacion);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHI10ActionPerformed(ActionEvent evt) {
        mEstablecerResultado(this.JCHI10.getName(), this.JLB3_VLResultado, this.JLB3_VLRClasificacion);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHI11ActionPerformed(ActionEvent evt) {
        mEstablecerResultado(this.JCHI11.getName(), this.JLB3_VLResultado, this.JLB3_VLRClasificacion);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHI12ActionPerformed(ActionEvent evt) {
        mEstablecerResultado(this.JCHI12.getName(), this.JLB3_VLResultado, this.JLB3_VLRClasificacion);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBEsActionPerformed(ActionEvent evt) {
        this.x3e = 9;
        this.JCHBEs.setEnabled(false);
        this.JCHBEs1.setEnabled(false);
        this.JCHBEs2.setEnabled(false);
        this.JCHBEs3.setEnabled(false);
        this.JCHBEs4.setEnabled(false);
        this.JCHBEs5.setEnabled(false);
        this.JCHBEs6.setEnabled(false);
        this.JCHBEs7.setEnabled(false);
        this.JCHBEs8.setEnabled(false);
        this.JLB4_VLRClasificacion.setText("NORMAL");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBEs1ActionPerformed(ActionEvent evt) {
        if (this.JCHBEs1.isSelected()) {
            this.xEst1 = 1;
            this.xestereopsis = 1;
        } else {
            this.xEst1 = 0;
            this.xestereopsis = -1;
        }
        mSumarVLN4(this.JCHBEs1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBEs2ActionPerformed(ActionEvent evt) {
        if (this.JCHBEs2.isSelected()) {
            this.xEst2 = 1;
            this.xestereopsis = 1;
        } else {
            this.xEst2 = 0;
            this.xestereopsis = -1;
        }
        mSumarVLN4(this.JCHBEs2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBEs3ActionPerformed(ActionEvent evt) {
        if (this.JCHBEs3.isSelected()) {
            this.xEst3 = 1;
            this.xestereopsis = 1;
        } else {
            this.xEst3 = 0;
            this.xestereopsis = -1;
        }
        mSumarVLN4(this.JCHBEs3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBEs4ActionPerformed(ActionEvent evt) {
        if (this.JCHBEs4.isSelected()) {
            this.xEst4 = 1;
            this.xestereopsis = 1;
        } else {
            this.xEst4 = 0;
            this.xestereopsis = -1;
        }
        mSumarVLN4(this.JCHBEs4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBEs5ActionPerformed(ActionEvent evt) {
        if (this.JCHBEs5.isSelected()) {
            this.xEst5 = 1;
            this.xestereopsis = 1;
        } else {
            this.xEst5 = 0;
            this.xestereopsis = -1;
        }
        mSumarVLN4(this.JCHBEs5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBEs6ActionPerformed(ActionEvent evt) {
        if (this.JCHBEs6.isSelected()) {
            this.xEst6 = 1;
            this.xestereopsis = 1;
        } else {
            this.xEst6 = 0;
            this.xestereopsis = -1;
        }
        mSumarVLN4(this.JCHBEs6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBEs7ActionPerformed(ActionEvent evt) {
        if (this.JCHBEs7.isSelected()) {
            this.xEst7 = 1;
            this.xestereopsis = 1;
        } else {
            this.xEst7 = 0;
            this.xestereopsis = -1;
        }
        mSumarVLN4(this.JCHBEs7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBEs8ActionPerformed(ActionEvent evt) {
        if (this.JCHBEs8.isSelected()) {
            this.xEst8 = 1;
            this.xestereopsis = 1;
        } else {
            this.xEst8 = 0;
            this.xestereopsis = -1;
        }
        mSumarVLN4(this.JCHBEs8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBCActionPerformed(ActionEvent evt) {
        this.x5c = Integer.parseInt(this.JCHBC.getName().toString());
        if (this.JCHBC.isSelected()) {
            this.xcolor = 2;
            this.xColorA = 1;
        } else {
            this.xcolor = -2;
            this.xColorA = 0;
        }
        mSumarVLN5(this.JCHBC);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBC1ActionPerformed(ActionEvent evt) {
        this.x5c = Integer.parseInt(this.JCHBC1.getName().toString());
        if (this.JCHBC1.isSelected()) {
            this.xcolor = 1;
            this.xColorB = 1;
        } else {
            this.xcolor = -1;
            this.xColorB = 0;
        }
        mSumarVLN5(this.JCHBC1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBC5ActionPerformed(ActionEvent evt) {
        this.x5c = Integer.parseInt(this.JCHBC5.getName().toString());
        if (this.JCHBC5.isSelected()) {
            this.xcolor = 2;
            this.xColorC = 1;
        } else {
            this.xcolor = -2;
            this.xColorC = 0;
        }
        mSumarVLN5(this.JCHBC5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBC6ActionPerformed(ActionEvent evt) {
        this.x5c = Integer.parseInt(this.JCHBC6.getName().toString());
        if (this.JCHBC6.isSelected()) {
            this.xcolor = 1;
            this.xColorD = 1;
        } else {
            this.xcolor = -1;
            this.xColorD = 0;
        }
        mSumarVLN5(this.JCHBC6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBAOjosActionPerformed(ActionEvent evt) {
        mEstablecerResultado(this.JCHBAOjos.getName(), this.JLB8_VCResultado, this.JLB8_VCRClasificacion);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBFVActionPerformed(ActionEvent evt) {
        this.x6fv = Integer.parseInt(this.JCHBFV.getName().toString());
        mForiaVertical(this.JCHBFV, this.JPI6_FVertical);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBFV1ActionPerformed(ActionEvent evt) {
        this.x6fv = Integer.parseInt(this.JCHBFV1.getName().toString());
        mForiaVertical(this.JCHBFV1, this.JPI6_FVertical);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBFV2ActionPerformed(ActionEvent evt) {
        this.x6fv = Integer.parseInt(this.JCHBFV2.getName().toString());
        mForiaVertical(this.JCHBFV2, this.JPI6_FVertical);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBFV3ActionPerformed(ActionEvent evt) {
        this.x6fv = Integer.parseInt(this.JCHBFV3.getName().toString());
        mForiaVertical(this.JCHBFV3, this.JPI6_FVertical);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBFV4ActionPerformed(ActionEvent evt) {
        this.x6fv = Integer.parseInt(this.JCHBFV4.getName().toString());
        mForiaVertical(this.JCHBFV4, this.JPI6_FVertical);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBFV5ActionPerformed(ActionEvent evt) {
        this.x6fv = Integer.parseInt(this.JCHBFV5.getName().toString());
        mForiaVertical(this.JCHBFV5, this.JPI6_FVertical);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBFV6ActionPerformed(ActionEvent evt) {
        this.x6fv = Integer.parseInt(this.JCHBFV6.getName().toString());
        mForiaVertical(this.JCHBFV6, this.JPI6_FVertical);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBFLaActionPerformed(ActionEvent evt) {
        this.x7fl = Integer.parseInt(this.JCHBFLa.getName().toString());
        mForiaLateral(this.JCHBFLa, this.JPI7_FLateral);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBFLa1ActionPerformed(ActionEvent evt) {
        this.x7fl = Integer.parseInt(this.JCHBFLa1.getName().toString());
        mForiaLateral(this.JCHBFLa1, this.JPI7_FLateral);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBFLa2ActionPerformed(ActionEvent evt) {
        this.x7fl = Integer.parseInt(this.JCHBFLa2.getName().toString());
        mForiaLateral(this.JCHBFLa2, this.JPI7_FLateral);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBFLa3ActionPerformed(ActionEvent evt) {
        this.x7fl = Integer.parseInt(this.JCHBFLa3.getName().toString());
        mForiaLateral(this.JCHBFLa3, this.JPI7_FLateral);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBFLa4ActionPerformed(ActionEvent evt) {
        this.x7fl = Integer.parseInt(this.JCHBFLa4.getName().toString());
        mForiaLateral(this.JCHBFLa4, this.JPI7_FLateral);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBFLa5ActionPerformed(ActionEvent evt) {
        this.x7fl = Integer.parseInt(this.JCHBFLa5.getName().toString());
        mForiaLateral(this.JCHBFLa5, this.JPI7_FLateral);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBFLa6ActionPerformed(ActionEvent evt) {
        this.x7fl = Integer.parseInt(this.JCHBFLa6.getName().toString());
        mForiaLateral(this.JCHBFLa6, this.JPI7_FLateral);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBFLa7ActionPerformed(ActionEvent evt) {
        this.x7fl = Integer.parseInt(this.JCHBFLa7.getName().toString());
        mForiaLateral(this.JCHBFLa7, this.JPI7_FLateral);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBFLa8ActionPerformed(ActionEvent evt) {
        this.x7fl = Integer.parseInt(this.JCHBFLa8.getName().toString());
        mForiaLateral(this.JCHBFLa8, this.JPI7_FLateral);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBFLa9ActionPerformed(ActionEvent evt) {
        this.x7fl = Integer.parseInt(this.JCHBFLa9.getName().toString());
        mForiaLateral(this.JCHBFLa9, this.JPI7_FLateral);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBFLa10ActionPerformed(ActionEvent evt) {
        this.x7fl = Integer.parseInt(this.JCHBFLa10.getName().toString());
        mForiaLateral(this.JCHBFLa10, this.JPI7_FLateral);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBFLa11ActionPerformed(ActionEvent evt) {
        this.x7fl = Integer.parseInt(this.JCHBFLa11.getName().toString());
        mForiaLateral(this.JCHBFLa11, this.JPI7_FLateral);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBFLa12ActionPerformed(ActionEvent evt) {
        this.x7fl = Integer.parseInt(this.JCHBFLa12.getName().toString());
        mForiaLateral(this.JCHBFLa12, this.JPI7_FLateral);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBFLa13ActionPerformed(ActionEvent evt) {
        this.x7fl = Integer.parseInt(this.JCHBFLa13.getName().toString());
        mForiaLateral(this.JCHBFLa13, this.JPI7_FLateral);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBFLa14ActionPerformed(ActionEvent evt) {
        this.x7fl = Integer.parseInt(this.JCHBFLa14.getName().toString());
        mForiaLateral(this.JCHBFLa14, this.JPI7_FLateral);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBAOjos1ActionPerformed(ActionEvent evt) {
        mEstablecerResultado(this.JCHBAOjos1.getName(), this.JLB8_VCResultado, this.JLB8_VCRClasificacion);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBAOjos3ActionPerformed(ActionEvent evt) {
        mEstablecerResultado(this.JCHBAOjos3.getName(), this.JLB8_VCResultado, this.JLB8_VCRClasificacion);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBAOjos4ActionPerformed(ActionEvent evt) {
        mEstablecerResultado(this.JCHBAOjos4.getName(), this.JLB8_VCResultado, this.JLB8_VCRClasificacion);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBAOjos5ActionPerformed(ActionEvent evt) {
        mEstablecerResultado(this.JCHBAOjos5.getName(), this.JLB8_VCResultado, this.JLB8_VCRClasificacion);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBAOjos6ActionPerformed(ActionEvent evt) {
        mEstablecerResultado(this.JCHBAOjos6.getName(), this.JLB8_VCResultado, this.JLB8_VCRClasificacion);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBAOjos7ActionPerformed(ActionEvent evt) {
        mEstablecerResultado(this.JCHBAOjos7.getName(), this.JLB8_VCResultado, this.JLB8_VCRClasificacion);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBAOjos8ActionPerformed(ActionEvent evt) {
        mEstablecerResultado(this.JCHBAOjos8.getName(), this.JLB8_VCResultado, this.JLB8_VCRClasificacion);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBAOjos9ActionPerformed(ActionEvent evt) {
        mEstablecerResultado(this.JCHBAOjos9.getName(), this.JLB8_VCResultado, this.JLB8_VCRClasificacion);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBAOjos10ActionPerformed(ActionEvent evt) {
        mEstablecerResultado(this.JCHBAOjos10.getName(), this.JLB8_VCResultado, this.JLB8_VCRClasificacion);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBAOjos11ActionPerformed(ActionEvent evt) {
        mEstablecerResultado(this.JCHBAOjos11.getName(), this.JLB8_VCResultado, this.JLB8_VCRClasificacion);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBAOjos12ActionPerformed(ActionEvent evt) {
        mEstablecerResultado(this.JCHBAOjos12.getName(), this.JLB8_VCResultado, this.JLB8_VCRClasificacion);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBDerechoActionPerformed(ActionEvent evt) {
        mEstablecerResultado(this.JCHBDerecho.getName(), this.JLB9_VCDResultado, this.JLB9_VCDClasificacion);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBDerecho1ActionPerformed(ActionEvent evt) {
        mEstablecerResultado(this.JCHBDerecho1.getName(), this.JLB9_VCDResultado, this.JLB9_VCDClasificacion);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBDerecho3ActionPerformed(ActionEvent evt) {
        mEstablecerResultado(this.JCHBDerecho3.getName(), this.JLB9_VCDResultado, this.JLB9_VCDClasificacion);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBDerecho2ActionPerformed(ActionEvent evt) {
        mEstablecerResultado(this.JCHBDerecho2.getName(), this.JLB9_VCDResultado, this.JLB9_VCDClasificacion);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBDerecho4ActionPerformed(ActionEvent evt) {
        mEstablecerResultado(this.JCHBDerecho4.getName(), this.JLB9_VCDResultado, this.JLB9_VCDClasificacion);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBDerecho5ActionPerformed(ActionEvent evt) {
        mEstablecerResultado(this.JCHBDerecho5.getName(), this.JLB9_VCDResultado, this.JLB9_VCDClasificacion);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBDerecho6ActionPerformed(ActionEvent evt) {
        mEstablecerResultado(this.JCHBDerecho6.getName(), this.JLB9_VCDResultado, this.JLB9_VCDClasificacion);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBDerecho7ActionPerformed(ActionEvent evt) {
        mEstablecerResultado(this.JCHBDerecho7.getName(), this.JLB9_VCDResultado, this.JLB9_VCDClasificacion);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBDerecho8ActionPerformed(ActionEvent evt) {
        mEstablecerResultado(this.JCHBDerecho8.getName(), this.JLB9_VCDResultado, this.JLB9_VCDClasificacion);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBDerecho9ActionPerformed(ActionEvent evt) {
        mEstablecerResultado(this.JCHBDerecho9.getName(), this.JLB9_VCDResultado, this.JLB9_VCDClasificacion);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBDerecho10ActionPerformed(ActionEvent evt) {
        mEstablecerResultado(this.JCHBDerecho10.getName(), this.JLB9_VCDResultado, this.JLB9_VCDClasificacion);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBDerecho11ActionPerformed(ActionEvent evt) {
        mEstablecerResultado(this.JCHBDerecho11.getName(), this.JLB9_VCDResultado, this.JLB9_VCDClasificacion);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBIzquierdoActionPerformed(ActionEvent evt) {
        mEstablecerResultado(this.JCHBIzquierdo.getName(), this.JLB10_VCResultado, this.JLB10_VCClasificacion);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBIzquierdo1ActionPerformed(ActionEvent evt) {
        mEstablecerResultado(this.JCHBIzquierdo1.getName(), this.JLB10_VCResultado, this.JLB10_VCClasificacion);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBIzquierdo2ActionPerformed(ActionEvent evt) {
        mEstablecerResultado(this.JCHBIzquierdo2.getName(), this.JLB10_VCResultado, this.JLB10_VCClasificacion);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBIzquierdo3ActionPerformed(ActionEvent evt) {
        mEstablecerResultado(this.JCHBIzquierdo3.getName(), this.JLB10_VCResultado, this.JLB10_VCClasificacion);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBIzquierdo4ActionPerformed(ActionEvent evt) {
        mEstablecerResultado(this.JCHBIzquierdo4.getName(), this.JLB10_VCResultado, this.JLB10_VCClasificacion);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBIzquierdo5ActionPerformed(ActionEvent evt) {
        mEstablecerResultado(this.JCHBIzquierdo5.getName(), this.JLB10_VCResultado, this.JLB10_VCClasificacion);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBIzquierdo6ActionPerformed(ActionEvent evt) {
        mEstablecerResultado(this.JCHBIzquierdo6.getName(), this.JLB10_VCResultado, this.JLB10_VCClasificacion);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBIzquierdo7ActionPerformed(ActionEvent evt) {
        mEstablecerResultado(this.JCHBIzquierdo7.getName(), this.JLB10_VCResultado, this.JLB10_VCClasificacion);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBIzquierdo8ActionPerformed(ActionEvent evt) {
        mEstablecerResultado(this.JCHBIzquierdo8.getName(), this.JLB10_VCResultado, this.JLB10_VCClasificacion);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBIzquierdo9ActionPerformed(ActionEvent evt) {
        mEstablecerResultado(this.JCHBIzquierdo9.getName(), this.JLB10_VCResultado, this.JLB10_VCClasificacion);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBIzquierdo10ActionPerformed(ActionEvent evt) {
        mEstablecerResultado(this.JCHBIzquierdo10.getName(), this.JLB10_VCResultado, this.JLB10_VCClasificacion);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBIzquierdo11ActionPerformed(ActionEvent evt) {
        mEstablecerResultado(this.JCHBIzquierdo11.getName(), this.JLB10_VCResultado, this.JLB10_VCClasificacion);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBVCLateralActionPerformed(ActionEvent evt) {
        this.x11fl = Integer.parseInt(this.JCHBVCLateral.getName().toString());
        mForiaLateral(this.JCHBVCLateral, this.JPI11_VCFLateral);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBVCLateral2ActionPerformed(ActionEvent evt) {
        this.x11fl = Integer.parseInt(this.JCHBVCLateral2.getName().toString());
        mForiaLateral(this.JCHBVCLateral2, this.JPI11_VCFLateral);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBVCLateral3ActionPerformed(ActionEvent evt) {
        this.x11fl = Integer.parseInt(this.JCHBVCLateral3.getName().toString());
        mForiaLateral(this.JCHBVCLateral3, this.JPI11_VCFLateral);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBVCLateral4ActionPerformed(ActionEvent evt) {
        this.x11fl = Integer.parseInt(this.JCHBVCLateral4.getName().toString());
        mForiaLateral(this.JCHBVCLateral4, this.JPI11_VCFLateral);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBVCLateral5ActionPerformed(ActionEvent evt) {
        this.x11fl = Integer.parseInt(this.JCHBVCLateral5.getName().toString());
        mForiaLateral(this.JCHBVCLateral5, this.JPI11_VCFLateral);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBVCLateral6ActionPerformed(ActionEvent evt) {
        this.x11fl = Integer.parseInt(this.JCHBVCLateral6.getName().toString());
        mForiaLateral(this.JCHBVCLateral6, this.JPI11_VCFLateral);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBVCLateral7ActionPerformed(ActionEvent evt) {
        this.x11fl = Integer.parseInt(this.JCHBVCLateral7.getName().toString());
        mForiaLateral(this.JCHBVCLateral7, this.JPI11_VCFLateral);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBVCLateral8ActionPerformed(ActionEvent evt) {
        this.x11fl = Integer.parseInt(this.JCHBVCLateral8.getName().toString());
        mForiaLateral(this.JCHBVCLateral8, this.JPI11_VCFLateral);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBVCLateral9ActionPerformed(ActionEvent evt) {
        this.x11fl = Integer.parseInt(this.JCHBVCLateral9.getName().toString());
        mForiaLateral(this.JCHBVCLateral9, this.JPI11_VCFLateral);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBVCLateral10ActionPerformed(ActionEvent evt) {
        this.x11fl = Integer.parseInt(this.JCHBVCLateral10.getName().toString());
        mForiaLateral(this.JCHBVCLateral10, this.JPI11_VCFLateral);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBVCLateral11ActionPerformed(ActionEvent evt) {
        this.x11fl = Integer.parseInt(this.JCHBVCLateral11.getName().toString());
        mForiaLateral(this.JCHBVCLateral11, this.JPI11_VCFLateral);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBVCLateral12ActionPerformed(ActionEvent evt) {
        this.x11fl = Integer.parseInt(this.JCHBVCLateral12.getName().toString());
        mForiaLateral(this.JCHBVCLateral12, this.JPI11_VCFLateral);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBVCLateral13ActionPerformed(ActionEvent evt) {
        this.x11fl = Integer.parseInt(this.JCHBVCLateral13.getName().toString());
        mForiaLateral(this.JCHBVCLateral13, this.JPI11_VCFLateral);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBVCLateral14ActionPerformed(ActionEvent evt) {
        this.x11fl = Integer.parseInt(this.JCHBVCLateral14.getName().toString());
        mForiaLateral(this.JCHBVCLateral14, this.JPI11_VCFLateral);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBVCLateral15ActionPerformed(ActionEvent evt) {
        this.x11fl = Integer.parseInt(this.JCHBVCLateral15.getName().toString());
        mForiaLateral(this.JCHBVCLateral15, this.JPI11_VCFLateral);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHDGLentesCActionPerformed(ActionEvent evt) {
        if (this.JCHDGLentesC.isSelected()) {
            this.xdglentesc = 1;
        } else {
            this.xdglentesc = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHDGSLentesFActionPerformed(ActionEvent evt) {
        if (this.JCHDGSLentesF.isSelected()) {
            this.xdglformulados = "Si";
        } else {
            this.xdglformulados = "No";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBDGTGNingunaActionPerformed(ActionEvent evt) {
        this.xdgtipogafas = "Ninguna";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBDGTGPersonalActionPerformed(ActionEvent evt) {
        this.xdgtipogafas = "Personal";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBDGTGSeguridadActionPerformed(ActionEvent evt) {
        this.xdgtipogafas = "Seguridad";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBDGTLNingunoActionPerformed(ActionEvent evt) {
        this.xdgtipolentes = "Ninguno";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBDGTLProgresivoActionPerformed(ActionEvent evt) {
        this.xdgtipolentes = "Progresivo";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBDGTLBifocalesActionPerformed(ActionEvent evt) {
        this.xdgtipolentes = "Bifocales";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBDGTLMonofocalesActionPerformed(ActionEvent evt) {
        this.xdgtipolentes = "Monofocales";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBDGTCNingunaActionPerformed(ActionEvent evt) {
        this.xdgtipocorrecion = "Ninguna";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBDGTCPermanenteActionPerformed(ActionEvent evt) {
        this.xdgtipocorrecion = "Permanente";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBDGTCEsporadicoActionPerformed(ActionEvent evt) {
        this.xdgtipocorrecion = "Esporádica";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHTCLejosActionPerformed(ActionEvent evt) {
        mCTipoCorrecion();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHTCCercaActionPerformed(ActionEvent evt) {
        mCTipoCorrecion();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGrabarActionPerformed(ActionEvent evt) {
        int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (x == 0) {
            this.xsql = "insert into h_so_visiometria (`Id_Atencion` , `Id_Usuario` , `Id_Profesional` , `Id_Especialidad`, `Id_Sede`, `FechaR`, `LContacto`, `TLenteC`, `RLFormulado`, `Tipo_Gafas`, `UCorreccion` , `Tipo_Correcion`, `R_VLAmbosO`, `R_VLAmbosO_V`, `R_VLAmbosO_T`, `R_VLODerecho`, `R_VLODerecho_V`, `R_VLODerecho_T`, `R_VLOIzquierdo`, `R_VLOIzquierdo_V`, `R_VLOIzquierdo_T` , `R_VLEstereopsi`, `R_VLEstereopsi_T`, `R_VLColor`, `R_VLColor_T`, `R_VLFVertical`, `R_VLFVertical_T`, `R_VLFLateral`, `R_VLFLateral_T`, `R_VCAmbosO`, `R_VCAmbosO_V`, `R_VCAmbosO_T` , `R_VCODerecho`, `R_VCODerecho_V`, `R_VCODerecho_T`, `R_VCOIzquierdo`, `R_VCOIzquierdo_V`, `R_VCOIzquierdo_T`, `R_VCFLateral`, `R_VCFLateral_T`, `ColorA` , `ColorB` , `ColorC` , `ColorD` , `ColorE` , `ColorF`, `Est1`  , `Est2` , `Est3` , `Est4`  , `Est5` , `Est6`  , `Est7` , `Est8` , `Est9`,Guardado,ObservacionVisio,`UsuarioS` )  values('" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "','" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "','" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "','" + Principal.sedeUsuarioSeleccionadaDTO.getId() + "','" + this.xmt.formatoAMD.format(this.xmt.getFechaActual()) + "','" + this.xdglentesc + "','" + this.xdgtipolentes + "','" + this.xdglformulados + "','" + this.xdgtipogafas + "','" + this.xdgtipocorrecion + "','" + this.xtcorrecion + "','" + mTraerNombreControlSeleccionado(this.JPI1_VLAOjos) + "','" + this.JLB1_VLResultado.getText() + "','" + this.JLB1_VLRClasificacion.getText() + "','" + mTraerNombreControlSeleccionado(this.JPI2_ODerecho) + "','" + this.JLB2_VLResultado.getText() + "','" + this.JLB2_VLRClasificacion.getText() + "','" + mTraerNombreControlSeleccionado(this.JPI3_OIzquierdo) + "','" + this.JLB3_VLResultado.getText() + "','" + this.JLB3_VLRClasificacion.getText() + "','" + this.x3e + "','" + this.JLB4_VLRClasificacion.getText() + "','" + this.xsumaColor + "','" + this.JLB5_VLRClasificacion.getText() + "','" + this.x6fv + "','" + this.JLB6_VLRClasificacion.getText() + "','" + this.x7fl + "','" + this.JLB7_VLRClasificacion.getText() + "','" + mTraerNombreControlSeleccionado(this.JPI8_VCAOjos) + "','" + this.JLB8_VCResultado.getText() + "','" + this.JLB8_VCRClasificacion.getText() + "','" + mTraerNombreControlSeleccionado(this.JPI9_VCDerecho) + "','" + this.JLB9_VCDResultado.getText() + "','" + this.JLB9_VCDClasificacion.getText() + "','" + mTraerNombreControlSeleccionado(this.JPI10_VCIzquierdo) + "','" + this.JLB10_VCResultado.getText() + "','" + this.JLB10_VCClasificacion.getText() + "','" + this.x11fl + "','" + this.JLB11_VCFLaClasificacion.getText() + "','" + this.xColorA + "','" + this.xColorB + "','" + this.xColorC + "','" + this.xColorD + "','" + this.xColorE + "','" + this.xColorF + "','" + this.xEst1 + "','" + this.xEst2 + "','" + this.xEst3 + "','" + this.xEst4 + "','" + this.xEst5 + "','" + this.xEst6 + "','" + this.xEst7 + "','" + this.xEst8 + "','" + this.xEst9 + "','1','" + this.JTAObsVisiometria.getText() + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            this.JBTGrabar.setEnabled(false);
            Principal.clasehistoriace.mCambiarEstadoOrdenProcedimiento();
            mCargarDatosTablaHistorico();
            mImprimir();
            this.xmt.cambiarEstadoValidadoItemHC(getName(), 1, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBGuardarInterActionPerformed(ActionEvent evt) {
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            String sql = "update `h_so_visiometria` set Interpretacion='" + this.JTAInterpretacion.getText() + "', IdUsuarioInter='" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "', Resultado='" + this.JCBResultado.getSelectedItem() + "' ,Guardado=2 , `Id_Atencion`='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "'  where Id='" + this.xidVisio + "'";
            this.xct.ejecutarSQL(sql);
            this.xct.cerrarConexionBd();
            if (clasesHistoriaCE.informacionAgendaMedicaDTO.getEsPeriodico().intValue() == 1) {
                Principal.clasehistoriace.mActualizarVariable_ManPower("RVisiometria", this.JCBResultado.getSelectedItem().toString(), "Observacion_Vis", this.JTAInterpretacion.getText());
                if (!this.JCBResultado.getSelectedItem().equals("NORMAL")) {
                    Principal.clasehistoriace.mActualizarAlterado_ManPower();
                }
            }
            this.JBGuardarInter.setEnabled(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleHistoricoMouseClicked(MouseEvent evt) {
        if (this.JTDetalleHistorico.getSelectedRow() != -1 && evt.getClickCount() == 2) {
            this.xidVisio = Long.valueOf(this.xmodelo.getValueAt(this.JTDetalleHistorico.getSelectedRow(), 3).toString()).longValue();
            mImprimir();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBC7ActionPerformed(ActionEvent evt) {
        this.x5c = Integer.parseInt(this.JCHBC7.getName().toString());
        if (this.JCHBC7.isSelected()) {
            this.xcolor = 2;
            this.xColorE = 1;
        } else {
            this.xcolor = -2;
            this.xColorE = 0;
        }
        mSumarVLN5(this.JCHBC7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBC8ActionPerformed(ActionEvent evt) {
        if (this.JCHBC8.isSelected()) {
            this.xcolor = 0;
            this.xColorF = 1;
        } else {
            this.xcolor = 0;
            this.xColorF = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTActualizarActionPerformed(ActionEvent evt) {
        actualizar();
    }

    private void actualizar() {
        int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de Actualizar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (x == 0) {
            this.xsql = "UPDATE h_so_visiometria SET   Id_Usuario = '" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "',  Id_Profesional = '" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "',  Id_Especialidad = '" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "',  Id_Sede = '" + Principal.sedeUsuarioSeleccionadaDTO.getId() + "',  FechaR = '" + this.xmt.formatoAMD.format(this.xmt.getFechaActual()) + "',  LContacto = '" + this.xdglentesc + "',  TLenteC = '" + this.xdgtipolentes + "',  RLFormulado = '" + this.xdglformulados + "',  Tipo_Gafas = '" + this.xdgtipogafas + "',  UCorreccion = '" + this.xdgtipocorrecion + "',  Tipo_Correcion = '" + this.xtcorrecion + "',  R_VLAmbosO = '" + mTraerNombreControlSeleccionado(this.JPI1_VLAOjos) + "',  R_VLAmbosO_V = '" + this.JLB1_VLResultado.getText() + "',  R_VLAmbosO_T = '" + this.JLB1_VLRClasificacion.getText() + "',  R_VLODerecho = '" + mTraerNombreControlSeleccionado(this.JPI2_ODerecho) + "',  R_VLODerecho_V = '" + this.JLB2_VLResultado.getText() + "',  R_VLODerecho_T = '" + this.JLB2_VLRClasificacion.getText() + "',  R_VLOIzquierdo = '" + mTraerNombreControlSeleccionado(this.JPI3_OIzquierdo) + "',  R_VLOIzquierdo_V = '" + this.JLB3_VLResultado.getText() + "',  R_VLOIzquierdo_T = '" + this.JLB3_VLRClasificacion.getText() + "',  R_VLEstereopsi = '" + this.x3e + "',  R_VLEstereopsi_T = '" + this.JLB4_VLRClasificacion.getText() + "',  R_VLColor = '" + this.x5c + "',  R_VLColor_T = '" + this.JLB5_VLRClasificacion.getText() + "',  R_VLFVertical = '" + this.x6fv + "',  R_VLFVertical_T = '" + this.JLB6_VLRClasificacion.getText() + "',  R_VLFLateral = '" + this.x7fl + "',  R_VLFLateral_T = '" + this.JLB7_VLRClasificacion.getText() + "',  R_VCAmbosO = '" + mTraerNombreControlSeleccionado(this.JPI8_VCAOjos) + "',  R_VCAmbosO_V = '" + this.JLB8_VCResultado.getText() + "',  R_VCAmbosO_T = '" + this.JLB8_VCRClasificacion.getText() + "',  R_VCODerecho = '" + mTraerNombreControlSeleccionado(this.JPI9_VCDerecho) + "',  R_VCODerecho_V = '" + this.JLB9_VCDResultado.getText() + "',  R_VCODerecho_T = '" + this.JLB9_VCDClasificacion.getText() + "',  R_VCOIzquierdo = '" + mTraerNombreControlSeleccionado(this.JPI10_VCIzquierdo) + "',  R_VCOIzquierdo_V = '" + this.JLB10_VCResultado.getText() + "',  R_VCOIzquierdo_T = '" + this.JLB10_VCClasificacion.getText() + "',  R_VCFLateral = '" + this.x11fl + "',  R_VCFLateral_T = '" + this.JLB11_VCFLaClasificacion.getText() + "',  R_VCFVertical = '" + this.x12fv + "',  Guardado = '1',  ObservacionVisio = '" + this.JTAObsVisiometria.getText() + "',  UsuarioS = '" + Principal.usuarioSistemaDTO.getLogin() + "' ,ColorA= '" + this.xColorA + "', ColorB='" + this.xColorB + "' , ColorC='" + this.xColorC + "' , ColorD='" + this.xColorD + "' , ColorE='" + this.xColorE + "' , ColorF='" + this.xColorF + "', Est1='" + this.xEst1 + "'  , Est2='" + this.xEst2 + "' , Est3='" + this.xEst3 + "' , Est4='" + this.xEst4 + "'  , Est5='" + this.xEst5 + "' , Est6='" + this.xEst6 + "'  , Est7='" + this.xEst7 + "' , Est8='" + this.xEst8 + "' , Est9 ='" + this.xEst9 + "' WHERE  Id_Atencion = '" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "'";
            System.out.println("actualizar visiometria" + this.xsql);
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            Principal.clasehistoriace.mCambiarEstadoOrdenProcedimiento();
            mImprimir();
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloHistorico() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id Atencion", "Fecha", "Profesional", "IdVisio"}) { // from class: Historia.JPSo_VisiometriaFPZ.143
            Class[] types = {String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalleHistorico.setModel(this.xmodelo);
        this.JTDetalleHistorico.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTDetalleHistorico.getColumnModel().getColumn(1).setPreferredWidth(10);
        this.JTDetalleHistorico.getColumnModel().getColumn(2).setPreferredWidth(200);
        this.JTDetalleHistorico.getColumnModel().getColumn(3).setPreferredWidth(0);
        this.JTDetalleHistorico.getColumnModel().getColumn(3).setMinWidth(0);
        this.JTDetalleHistorico.getColumnModel().getColumn(3).setMaxWidth(0);
    }

    private void mCargarDatosTablaHistorico() {
        try {
            mCrearModeloHistorico();
            String sql = "SELECT  `h_so_visiometria`.`Id_Atencion` , `h_so_visiometria`.`FechaR`  , `profesional`.`NProfesional`, h_so_visiometria.Id FROM `h_so_visiometria` INNER JOIN `profesional`  ON (`h_so_visiometria`.`Id_Profesional` = `profesional`.`Id_Persona`) WHERE (`h_so_visiometria`.`Id_Usuario` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "' and `h_so_visiometria`.Estado =1)";
            ResultSet xrs = this.xct.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(xrs.getString(1), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelo.setValueAt(xrs.getString(4), n, 3);
                    n++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPASaludOcupacional.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private String mTraerNombreControlSeleccionado(JPanel xpanel) {
        String xnombre = "0";
        int x = 0;
        while (true) {
            if (x >= xpanel.getComponentCount()) {
                break;
            }
            if (xpanel.getComponent(x).getClass().getName().equals("javax.swing.JCheckBox")) {
                JCheckBox xch = xpanel.getComponent(x);
                if (xch.isSelected()) {
                    xnombre = xch.getName();
                    break;
                }
            }
            x++;
        }
        return xnombre;
    }

    private void mEstablecerValor(JPanel xpanel, String xvalor) {
        if (xpanel.getComponentCount() > 0) {
            for (int x = 0; x < xpanel.getComponentCount(); x++) {
                if (xpanel.getComponent(x).getClass().getName().equals("javax.swing.JCheckBox")) {
                    JCheckBox xch = xpanel.getComponent(x);
                    if (xch.getName().equals(xvalor)) {
                        xch.setEnabled(true);
                        xch.setSelected(true);
                        xch.setEnabled(false);
                        return;
                    }
                }
            }
        }
    }

    private void mEstablecerValor2(JPanel xpanel, int xvalor) {
        if (xpanel.getComponentCount() >= 0) {
            for (int x = 0; x < xpanel.getComponentCount(); x++) {
                if (xpanel.getComponent(x).getClass().getName().equals("javax.swing.JCheckBox")) {
                    JCheckBox xch = xpanel.getComponent(x);
                    if (Integer.parseInt(xch.getName()) <= xvalor) {
                        xch.setEnabled(true);
                        xch.setSelected(true);
                        xch.setEnabled(false);
                    }
                }
            }
        }
    }

    private void mEstablecerValor(JPanel xpanel, int xvalor) {
        if (xpanel.getComponentCount() >= 0) {
            for (int x = 0; x <= xvalor; x++) {
                if (xpanel.getComponent(x).getClass().getName().equals("javax.swing.JCheckBox")) {
                    JCheckBox xch = xpanel.getComponent(x);
                    xch.setEnabled(true);
                    xch.setSelected(true);
                    xch.setEnabled(false);
                }
            }
        }
    }

    private void mCTipoCorrecion() {
        if (this.JCHTCLejos.isSelected() && this.JCHTCCerca.isSelected()) {
            this.xtcorrecion = 3;
            return;
        }
        if (this.JCHTCLejos.isSelected() && !this.JCHTCCerca.isSelected()) {
            this.xtcorrecion = 1;
            return;
        }
        if (!this.JCHTCLejos.isSelected() && this.JCHTCCerca.isSelected()) {
            this.xtcorrecion = 2;
        } else if (!this.JCHTCLejos.isSelected() && !this.JCHTCCerca.isSelected()) {
            this.xtcorrecion = 0;
        }
    }

    private void mSumarVLN4(JCheckBox xcontrol) {
        this.x3e += this.xestereopsis;
        if (this.x3e >= 5) {
            this.JLB4_VLRClasificacion.setText("NORMAL");
        } else {
            this.JLB4_VLRClasificacion.setText("CON HALLAZGOS");
        }
    }

    private void mSumarVLN5(JCheckBox xcontrol) {
        this.xsumaColor = this.xcolor + this.xsumaColor;
        if (this.xsumaColor >= 5 && this.xsumaColor <= 8) {
            this.JLB5_VLRClasificacion.setText("NORMAL");
        } else {
            this.JLB5_VLRClasificacion.setText("CON HALLAZGOS");
        }
    }

    private void mSumarVLN6(JCheckBox xcontrol, int xvalor) {
        xcontrol.setEnabled(false);
        if (this.x6fv >= 6) {
            this.JLB6_VLRClasificacion.setText("NORMAL");
        } else {
            this.JLB6_VLRClasificacion.setText("CON HALLAZGOS");
        }
    }

    private void mForiaVertical(JCheckBox xcontrol, JPanel xpanel) {
        if (xpanel.getName().equals("xpanelfv1")) {
            if (Long.parseLong(xcontrol.getName().toString()) >= 3 && Long.parseLong(xcontrol.getName().toString()) <= 4) {
                this.JLB6_VLRClasificacion.setText("NORMAL");
            } else {
                this.JLB6_VLRClasificacion.setText("CON HALLAZGOS");
            }
        }
    }

    private void mForiaLateral(JCheckBox xcontrol, JPanel xpanel) {
        if (xpanel.getName().equals("xpanellateral1")) {
            if (Long.parseLong(xcontrol.getName().toString()) >= 3 && Long.parseLong(xcontrol.getName().toString()) <= 12) {
                this.JLB7_VLRClasificacion.setText("NORMAL");
                return;
            } else {
                this.JLB7_VLRClasificacion.setText("CON HALLAZGOS");
                return;
            }
        }
        if (Long.parseLong(xcontrol.getName().toString()) >= 3 && Long.parseLong(xcontrol.getName().toString()) <= 12) {
            this.JLB11_VCFLaClasificacion.setText("NORMAL");
        } else {
            this.JLB11_VCFLaClasificacion.setText("CON HALLAZGOS");
        }
    }

    private void mSumarVLN7(JCheckBox xcontrol) {
        xcontrol.setEnabled(false);
        if (this.x7fl >= 9) {
            this.JLB7_VLRClasificacion.setText("NORMAL");
        } else {
            this.JLB7_VLRClasificacion.setText("CON HALLAZGOS");
        }
    }

    private void mSumarVCN11(JCheckBox xcontrol) {
        xcontrol.setEnabled(false);
        if (this.x11fl >= 9) {
            this.JLB11_VCFLaClasificacion.setText("NORMAL");
        } else {
            this.JLB11_VCFLaClasificacion.setText("CON HALLAZGOS");
        }
    }

    private void mSumarVLN12(JCheckBox xcontrol, int xvalor) {
    }

    private void mEstablecerResultado(String xid, JLabel xetiqueta, JLabel xclasificacion) {
        try {
            this.xsql = "SELECT `Nbre`, Resultado FROM `so_tipo_resultado_visiometria` WHERE (`Id` ='" + xid + "')";
            ResultSet xrs = this.xct.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.first();
                xetiqueta.setText(xrs.getString(1));
                xclasificacion.setText(xrs.getString(2));
            } else {
                xetiqueta.setText("");
                xclasificacion.setText("");
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPSo_VisiometriaFPZ.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mBuscar() {
        try {
            this.xsql = "SELECT `LContacto`, `TLenteC`, `RLFormulado`, `Tipo_Gafas`, `UCorreccion`, `Tipo_Correcion`, `R_VLAmbosO`, `R_VLAmbosO_V`, `R_VLAmbosO_T`, `R_VLODerecho` , `R_VLODerecho_V`, `R_VLODerecho_T`, `R_VLOIzquierdo`, `R_VLOIzquierdo_V`, `R_VLOIzquierdo_T`, `R_VLEstereopsi`, `R_VLEstereopsi_T`, `R_VLColor`, `R_VLColor_T` , `R_VLFVertical`, `R_VLFVertical_T`, `R_VLFLateral`, `R_VLFLateral_T`, `R_VCAmbosO`, `R_VCAmbosO_V`, `R_VCAmbosO_T`, `R_VCODerecho` , `R_VCODerecho_V`, `R_VCODerecho_T` , `R_VCOIzquierdo`, `R_VCOIzquierdo_V`, `R_VCOIzquierdo_T`, `R_VCFVertical`, `R_VCFVertical_T`, `R_VCFLateral`, `R_VCFLateral_T`, Interpretacion, Resultado, Guardado, Id, ObservacionVisio,`ColorA` , `ColorB` , `ColorC` , `ColorD` , `ColorE` , `ColorF`, `Est1`  , `Est2` , `Est3` , `Est4`  , `Est5` , `Est6`  , `Est7` , `Est8` , `Est9`  FROM  `h_so_visiometria` WHERE (`Id_Atencion` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "' and Estado =1) ";
            ResultSet xrs = this.xct.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.first();
                this.JCHDGLentesC.setSelected(xrs.getBoolean(1));
                if (xrs.getString("TLenteC").equals("Ninguno")) {
                    this.JRBDGTLNinguno.setSelected(true);
                } else if (xrs.getString("TLenteC").equals("Progresivo")) {
                    this.JRBDGTLProgresivo.setSelected(true);
                } else if (xrs.getString("TLenteC").equals("Bifocales")) {
                    this.JRBDGTLBifocales.setSelected(true);
                } else {
                    this.JRBDGTLMonofocales.setSelected(true);
                }
                if (xrs.getString("RLFormulado").equals("Si")) {
                    this.JCHDGSLentesF.setSelected(true);
                } else {
                    this.JCHDGSLentesF.setSelected(false);
                }
                if (xrs.getString("Tipo_Gafas").equals("Ninguna")) {
                    this.JRBDGTGNinguna.setSelected(true);
                } else if (xrs.getString("Tipo_Gafas").equals("Personal")) {
                    this.JRBDGTGPersonal.setSelected(true);
                } else {
                    this.JRBDGTGSeguridad.setSelected(true);
                }
                if (xrs.getString("UCorreccion").equals("Ninguna")) {
                    this.JRBDGTCNinguna.setSelected(true);
                } else if (xrs.getString("UCorreccion").equals("Permanente")) {
                    this.JRBDGTCPermanente.setSelected(true);
                } else {
                    this.JRBDGTCEsporadico.setSelected(true);
                }
                if (xrs.getInt("Tipo_Correcion") == 0) {
                    this.JCHTCCerca.setSelected(false);
                    this.JCHTCLejos.setSelected(false);
                } else if (xrs.getInt("Tipo_Correcion") == 1) {
                    this.JCHTCCerca.setSelected(true);
                    this.JCHTCLejos.setSelected(false);
                } else if (xrs.getInt("Tipo_Correcion") == 2) {
                    this.JCHTCCerca.setSelected(false);
                    this.JCHTCLejos.setSelected(true);
                } else {
                    this.JCHTCCerca.setSelected(true);
                    this.JCHTCLejos.setSelected(true);
                }
                mEstablecerValor(this.JPI1_VLAOjos, xrs.getString("R_VLAmbosO"));
                this.JLB1_VLResultado.setText(xrs.getString("R_VLAmbosO_V"));
                this.JLB1_VLRClasificacion.setText(xrs.getString("R_VLAmbosO_T"));
                mEstablecerValor(this.JPI2_ODerecho, xrs.getString("R_VLODerecho"));
                this.JLB2_VLResultado.setText(xrs.getString("R_VLODerecho_V"));
                this.JLB2_VLRClasificacion.setText(xrs.getString("R_VLODerecho_T"));
                mEstablecerValor(this.JPI3_OIzquierdo, xrs.getString("R_VLOIzquierdo"));
                this.JLB3_VLResultado.setText(xrs.getString("R_VLOIzquierdo_V"));
                this.JLB3_VLRClasificacion.setText(xrs.getString("R_VLOIzquierdo_T"));
                this.JLB4_VLRClasificacion.setText(xrs.getString("R_VLEstereopsi_T"));
                if (xrs.getInt("R_VLColor") >= 5 && xrs.getInt("R_VLColor") <= 8) {
                    this.JLB5_VLRClasificacion.setText("NORMAL");
                } else {
                    this.JLB5_VLRClasificacion.setText("CON HALLAZGOS");
                }
                this.JLB5_VLRClasificacion.setText(xrs.getString("R_VLColor_T"));
                mEstablecerValor2(this.JPI6_FVertical, xrs.getInt("R_VLFVertical"));
                this.JLB6_VLRClasificacion.setText(xrs.getString("R_VLFVertical_T"));
                mEstablecerValor2(this.JPI7_FLateral, xrs.getInt("R_VLFLateral"));
                this.JLB7_VLRClasificacion.setText(xrs.getString("R_VLFLateral_T"));
                mEstablecerValor(this.JPI8_VCAOjos, xrs.getString("R_VCAmbosO"));
                this.JLB8_VCResultado.setText(xrs.getString("R_VCAmbosO_V"));
                this.JLB8_VCRClasificacion.setText(xrs.getString("R_VCAmbosO_T"));
                mEstablecerValor(this.JPI9_VCDerecho, xrs.getString("R_VCODerecho"));
                this.JLB9_VCDResultado.setText(xrs.getString("R_VCODerecho_V"));
                this.JLB9_VCDClasificacion.setText(xrs.getString("R_VCODerecho_T"));
                mEstablecerValor(this.JPI10_VCIzquierdo, xrs.getString("R_VCOIzquierdo"));
                this.JLB10_VCResultado.setText(xrs.getString("R_VCOIzquierdo_V"));
                this.JLB10_VCClasificacion.setText(xrs.getString("R_VCOIzquierdo_T"));
                mEstablecerValor2(this.JPI11_VCFLateral, xrs.getInt("R_VCFLateral"));
                this.JLB11_VCFLaClasificacion.setText(xrs.getString("R_VCFLateral_T"));
                this.JTAInterpretacion.setText(xrs.getString("Interpretacion"));
                this.JCBResultado.setSelectedItem(xrs.getString("Resultado"));
                this.xexistencia = xrs.getLong("Guardado");
                this.xidVisio = xrs.getLong("Id");
                this.JTAObsVisiometria.setText(xrs.getString("ObservacionVisio"));
                if (xrs.getLong("ColorA") == 1) {
                    this.JCHBC.setSelected(true);
                } else {
                    this.JCHBC.setSelected(false);
                }
                if (xrs.getLong("ColorB") == 1) {
                    this.JCHBC1.setSelected(true);
                } else {
                    this.JCHBC1.setSelected(false);
                }
                if (xrs.getLong("ColorC") == 1) {
                    this.JCHBC5.setSelected(true);
                } else {
                    this.JCHBC5.setSelected(false);
                }
                if (xrs.getLong("ColorD") == 1) {
                    this.JCHBC6.setSelected(true);
                } else {
                    this.JCHBC6.setSelected(false);
                }
                if (xrs.getLong("ColorE") == 1) {
                    this.JCHBC7.setSelected(true);
                } else {
                    this.JCHBC7.setSelected(false);
                }
                if (xrs.getLong("ColorF") == 1) {
                    this.JCHBC8.setSelected(true);
                } else {
                    this.JCHBC8.setSelected(false);
                }
                if (xrs.getLong("Est1") == 1) {
                    this.JCHBEs1.setSelected(true);
                } else {
                    this.JCHBEs1.setSelected(false);
                }
                if (xrs.getLong("Est2") == 1) {
                    this.JCHBEs2.setSelected(true);
                } else {
                    this.JCHBEs2.setSelected(false);
                }
                if (xrs.getLong("Est3") == 1) {
                    this.JCHBEs3.setSelected(true);
                } else {
                    this.JCHBEs3.setSelected(false);
                }
                if (xrs.getLong("Est4") == 1) {
                    this.JCHBEs4.setSelected(true);
                } else {
                    this.JCHBEs4.setSelected(false);
                }
                if (xrs.getLong("Est5") == 1) {
                    this.JCHBEs5.setSelected(true);
                } else {
                    this.JCHBEs5.setSelected(false);
                }
                if (xrs.getLong("Est6") == 1) {
                    this.JCHBEs6.setSelected(true);
                } else {
                    this.JCHBEs6.setSelected(false);
                }
                if (xrs.getLong("Est7") == 1) {
                    this.JCHBEs7.setSelected(true);
                } else {
                    this.JCHBEs7.setSelected(false);
                }
                if (xrs.getLong("Est8") == 1) {
                    this.JCHBEs8.setSelected(true);
                } else {
                    this.JCHBEs8.setSelected(false);
                }
                if (xrs.getLong("Est9") == 1) {
                    this.JCHBEs.setSelected(true);
                } else {
                    this.JCHBEs.setSelected(false);
                }
                this.xmt.cambiarEstadoValidadoItemHC(getName(), 1, true);
            }
            if (this.xexistencia == 1) {
                this.JBTGrabar.setEnabled(false);
            } else if (this.xexistencia == 2) {
                this.JBTGrabar.setEnabled(false);
                this.JBGuardarInter.setEnabled(false);
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPSo_VisiometriaFPZ.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mImprimir() {
        String[][] mparametros = new String[3][2];
        mparametros[0][0] = "IdVisiometria";
        mparametros[0][1] = String.valueOf(this.xidVisio);
        mparametros[1][0] = "SUBREPORT_DIR";
        mparametros[1][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
        mparametros[2][0] = "SUBREPORTFIRMA_DIR";
        mparametros[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
        if (Principal.informacionIps.getEsFpz().intValue() == 0) {
            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "H_So_Visiometria", mparametros);
        } else {
            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "H_So_Visiometria_1", mparametros);
        }
    }

    private void cambiarNumeracionTextoValleDelSol() {
        this.jLabel2.setText("2. Ambos ojos");
        this.jLabel3.setText("3. Derecho");
        this.jLabel4.setText("4. Izquierdo");
        this.jLabel5.setText("5. Estereopsis");
        this.jLabel23.setText("6. Color");
        this.jLabel24.setText("7. Foria Vertical");
        this.jLabel25.setText("8. Foria Lateral");
        this.jLabel6.setText("9. Ambos ojos");
        this.jLabel7.setText("10. Derecho");
        this.jLabel8.setText("11. Izquierdo");
        this.jLabel28.setText("12. Foria Lateral");
    }
}
