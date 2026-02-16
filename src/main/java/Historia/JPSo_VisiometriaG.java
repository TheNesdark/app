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

/* JADX INFO: loaded from: GenomaP.jar:Historia/JPSo_VisiometriaG.class */
public class JPSo_VisiometriaG extends JPanel {
    private Object[] xdatos;
    private String xsql;
    private DefaultTableModel xmodelo;
    private String[] xidResultado;
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
    private JCheckBox JCHBEs1;
    private JCheckBox JCHBEs2;
    private JCheckBox JCHBEs3;
    private JCheckBox JCHBEs4;
    private JCheckBox JCHBEs5;
    private JCheckBox JCHBEs6;
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
    private JCheckBox JCHBFV7;
    private JCheckBox JCHBFV8;
    private JCheckBox JCHBFallido;
    private JCheckBox JCHBFallidoAmbOCercana;
    private JCheckBox JCHBFallidoAmbOLejana;
    private JCheckBox JCHBFallidoOjoDerechoCercana;
    private JCheckBox JCHBFallidoOjoDerechoLejana;
    private JCheckBox JCHBFallidoOjoIzqCercana;
    private JCheckBox JCHBFallidoOjoIzqLejana;
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
    private JCheckBox JCHBVCFVertical;
    private JCheckBox JCHBVCFVertical2;
    private JCheckBox JCHBVCFVertical3;
    private JCheckBox JCHBVCFVertical4;
    private JCheckBox JCHBVCFVertical5;
    private JCheckBox JCHBVCFVertical6;
    private JCheckBox JCHBVCFVertical7;
    private JCheckBox JCHBVCFVertical8;
    private JCheckBox JCHBVCFVertical9;
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
    private JLabel JLB12_VCFVeClasificacion;
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
    private JLabel JLBI2;
    private JLabel JLBI3;
    private JLabel JLBI4;
    private JLabel JLBI5;
    private JLabel JLBI6;
    private JLabel JLBI7;
    private JLabel JLBI8;
    private JLabel JLBI9;
    private JLabel JLPercepcion;
    private JPanel JPI10_VCIzquierdo;
    private JPanel JPI11_VCFLateral;
    private JPanel JPI12_VCFVertical;
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
    private JLabel jLabel8;
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
    private long xexistencia = 0;
    private String xidVisio = "";
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

    public JPSo_VisiometriaG() {
        initComponents();
        this.xidResultado = this.xct.llenarCombo("SELECT `Id`, `Nbre` FROM `h_so_resultado` WHERE (`Estado` =1 AND TipoExamen=6) ORDER BY `Nbre` ASC;", this.xidResultado, this.JCBResultado);
        this.JCBResultado.setSelectedIndex(-1);
        mBuscar();
        mCargarDatosTablaHistorico();
    }

    /* JADX WARN: Type inference failed for: r3v1371, types: [java.lang.Object[], java.lang.Object[][]] */
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
        this.jLabel48 = new JLabel();
        this.JCHBFallidoAmbOLejana = new JCheckBox();
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
        this.JCHBFallidoOjoDerechoLejana = new JCheckBox();
        this.jLabel49 = new JLabel();
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
        this.JCHBFallidoOjoIzqLejana = new JCheckBox();
        this.jLabel73 = new JLabel();
        this.JPI4_Estereopsis = new JPanel();
        this.jLabel5 = new JLabel();
        this.jLabel1 = new JLabel();
        this.jLabel26 = new JLabel();
        this.JCHBEs1 = new JCheckBox();
        this.JCHBEs2 = new JCheckBox();
        this.JCHBEs3 = new JCheckBox();
        this.JCHBEs4 = new JCheckBox();
        this.JCHBEs5 = new JCheckBox();
        this.JCHBEs6 = new JCheckBox();
        this.jLabel43 = new JLabel();
        this.JLPercepcion = new JLabel();
        this.JLB4_VLRClasificacion = new JLabel();
        this.JCHBFallido = new JCheckBox();
        this.jLabel44 = new JLabel();
        this.JPI5_Color = new JPanel();
        this.jLabel23 = new JLabel();
        this.JCHBC = new JCheckBox();
        this.jLabel42 = new JLabel();
        this.JCHBC1 = new JCheckBox();
        this.JCHBC5 = new JCheckBox();
        this.JCHBC6 = new JCheckBox();
        this.JLB5_VLRClasificacion = new JLabel();
        this.jLabel62 = new JLabel();
        this.jLabel63 = new JLabel();
        this.jLabel64 = new JLabel();
        this.jLabel65 = new JLabel();
        this.jLabel66 = new JLabel();
        this.jLabel67 = new JLabel();
        this.jLabel68 = new JLabel();
        this.JCHBC7 = new JCheckBox();
        this.jLabel69 = new JLabel();
        this.jLabel70 = new JLabel();
        this.jLabel71 = new JLabel();
        this.jLabel72 = new JLabel();
        this.JCHBC8 = new JCheckBox();
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
        this.JCHBFV7 = new JCheckBox();
        this.JCHBFV8 = new JCheckBox();
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
        this.jLabel74 = new JLabel();
        this.JCHBFallidoAmbOCercana = new JCheckBox();
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
        this.jLabel75 = new JLabel();
        this.JCHBFallidoOjoDerechoCercana = new JCheckBox();
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
        this.jLabel76 = new JLabel();
        this.JCHBFallidoOjoIzqCercana = new JCheckBox();
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
        this.JPI12_VCFVertical = new JPanel();
        this.jLabel27 = new JLabel();
        this.JCHBVCFVertical = new JCheckBox();
        this.jLabel53 = new JLabel();
        this.JCHBVCFVertical2 = new JCheckBox();
        this.JCHBVCFVertical3 = new JCheckBox();
        this.JCHBVCFVertical4 = new JCheckBox();
        this.JCHBVCFVertical5 = new JCheckBox();
        this.JCHBVCFVertical6 = new JCheckBox();
        this.JCHBVCFVertical7 = new JCheckBox();
        this.JCHBVCFVertical8 = new JCheckBox();
        this.JCHBVCFVertical9 = new JCheckBox();
        this.jLabel54 = new JLabel();
        this.JLB12_VCFVeClasificacion = new JLabel();
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
        this.JCHA1.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.1
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JCHA1ActionPerformed(evt);
            }
        });
        this.JLBA1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Derecha.png")));
        this.JBG1_VLAOjos.add(this.JCHA2);
        this.JCHA2.setName("2");
        this.JCHA2.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.2
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JCHA2ActionPerformed(evt);
            }
        });
        this.JLBA2.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Izquierda.png")));
        this.JBG1_VLAOjos.add(this.JCHA3);
        this.JCHA3.setName("3");
        this.JCHA3.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.3
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JCHA3ActionPerformed(evt);
            }
        });
        this.JLBA3.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Arriba.png")));
        this.JLBA4.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Izquierda.png")));
        this.JBG1_VLAOjos.add(this.JCHA4);
        this.JCHA4.setName("4");
        this.JCHA4.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.4
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JCHA4ActionPerformed(evt);
            }
        });
        this.JLBA5.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Abajo.png")));
        this.JBG1_VLAOjos.add(this.JCHA5);
        this.JCHA5.setName("5");
        this.JCHA5.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.5
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JCHA5ActionPerformed(evt);
            }
        });
        this.JLBA6.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Izquierda.png")));
        this.JBG1_VLAOjos.add(this.JCHA6);
        this.JCHA6.setName("6");
        this.JCHA6.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.6
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JCHA6ActionPerformed(evt);
            }
        });
        this.JLBA7.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Arriba.png")));
        this.JBG1_VLAOjos.add(this.JCHA7);
        this.JCHA7.setName("7");
        this.JCHA7.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.7
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JCHA7ActionPerformed(evt);
            }
        });
        this.JLBA8.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Abajo.png")));
        this.JBG1_VLAOjos.add(this.JCHA8);
        this.JCHA8.setName("8");
        this.JCHA8.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.8
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JCHA8ActionPerformed(evt);
            }
        });
        this.JLBA9.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Arriba.png")));
        this.JBG1_VLAOjos.add(this.JCHA9);
        this.JCHA9.setName("9");
        this.JCHA9.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.9
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JCHA9ActionPerformed(evt);
            }
        });
        this.JLBA10.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Derecha.png")));
        this.JBG1_VLAOjos.add(this.JCHA10);
        this.JCHA10.setName("10");
        this.JCHA10.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.10
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JCHA10ActionPerformed(evt);
            }
        });
        this.JLBA11.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Abajo.png")));
        this.JBG1_VLAOjos.add(this.JCHA11);
        this.JCHA11.setName("11");
        this.JCHA11.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.11
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JCHA11ActionPerformed(evt);
            }
        });
        this.JLBA12.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Derecha.png")));
        this.JBG1_VLAOjos.add(this.JCHA12);
        this.JCHA12.setName("12");
        this.JCHA12.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.12
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JCHA12ActionPerformed(evt);
            }
        });
        this.JLB1_VLResultado.setFont(new Font("Arial", 1, 12));
        this.JLB1_VLResultado.setForeground(new Color(255, 0, 0));
        this.JLB1_VLResultado.setHorizontalAlignment(0);
        this.JLB1_VLRClasificacion.setFont(new Font("Arial", 1, 12));
        this.JLB1_VLRClasificacion.setForeground(new Color(255, 0, 0));
        this.JLB1_VLRClasificacion.setHorizontalAlignment(0);
        this.jLabel48.setFont(new Font("Arial", 1, 12));
        this.jLabel48.setForeground(Color.blue);
        this.jLabel48.setText("X");
        this.JCHBFallidoAmbOLejana.setName("13");
        this.JCHBFallidoAmbOLejana.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.13
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JCHBFallidoAmbOLejanaActionPerformed(evt);
            }
        });
        GroupLayout JPI1_VLAOjosLayout = new GroupLayout(this.JPI1_VLAOjos);
        this.JPI1_VLAOjos.setLayout(JPI1_VLAOjosLayout);
        JPI1_VLAOjosLayout.setHorizontalGroup(JPI1_VLAOjosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI1_VLAOjosLayout.createSequentialGroup().addContainerGap().addComponent(this.jLabel2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPI1_VLAOjosLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JCHA1, -1, -1, 32767).addComponent(this.JLBA1, -2, 21, -2)).addGap(18, 18, 18).addGroup(JPI1_VLAOjosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JLBA2).addComponent(this.JCHA2)).addGap(18, 18, 18).addGroup(JPI1_VLAOjosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JLBA3).addComponent(this.JCHA3, -2, 21, -2)).addGap(18, 18, 18).addGroup(JPI1_VLAOjosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JCHA4).addComponent(this.JLBA4)).addGap(24, 24, 24).addGroup(JPI1_VLAOjosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLBA5, -2, 21, -2).addComponent(this.JCHA5, GroupLayout.Alignment.TRAILING)).addGap(18, 18, 18).addGroup(JPI1_VLAOjosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLBA6).addComponent(this.JCHA6)).addGap(21, 21, 21).addGroup(JPI1_VLAOjosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLBA7).addComponent(this.JCHA7)).addGroup(JPI1_VLAOjosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI1_VLAOjosLayout.createSequentialGroup().addGap(19, 19, 19).addComponent(this.JLBA8)).addGroup(JPI1_VLAOjosLayout.createSequentialGroup().addGap(18, 18, 18).addComponent(this.JCHA8))).addGap(18, 18, 18).addGroup(JPI1_VLAOjosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLBA9, GroupLayout.Alignment.TRAILING).addComponent(this.JCHA9, GroupLayout.Alignment.TRAILING)).addGap(25, 25, 25).addGroup(JPI1_VLAOjosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLBA10).addComponent(this.JCHA10)).addGap(25, 25, 25).addGroup(JPI1_VLAOjosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPI1_VLAOjosLayout.createSequentialGroup().addComponent(this.JLBA11).addGap(31, 31, 31)).addGroup(JPI1_VLAOjosLayout.createSequentialGroup().addComponent(this.JCHA11).addGap(23, 23, 23))).addGroup(JPI1_VLAOjosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLBA12).addComponent(this.JCHA12)).addGroup(JPI1_VLAOjosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI1_VLAOjosLayout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.JCHBFallidoAmbOLejana)).addGroup(JPI1_VLAOjosLayout.createSequentialGroup().addGap(18, 18, 18).addComponent(this.jLabel48))).addGap(8, 8, 8).addComponent(this.JLB1_VLResultado, -2, 55, -2).addGap(2, 2, 2).addComponent(this.JLB1_VLRClasificacion, -2, 111, -2)));
        JPI1_VLAOjosLayout.setVerticalGroup(JPI1_VLAOjosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI1_VLAOjosLayout.createSequentialGroup().addGroup(JPI1_VLAOjosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLBA7).addComponent(this.JLBA8).addComponent(this.JLBA9).addComponent(this.JLBA3).addComponent(this.JLBA6)).addGroup(JPI1_VLAOjosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI1_VLAOjosLayout.createSequentialGroup().addGap(2, 2, 2).addComponent(this.JCHA3)).addGroup(JPI1_VLAOjosLayout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPI1_VLAOjosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHA8).addComponent(this.JCHA9).addComponent(this.JCHA6).addComponent(this.JCHA5))).addGroup(GroupLayout.Alignment.TRAILING, JPI1_VLAOjosLayout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JCHA7).addContainerGap()))).addGroup(JPI1_VLAOjosLayout.createSequentialGroup().addGroup(JPI1_VLAOjosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI1_VLAOjosLayout.createSequentialGroup().addContainerGap().addComponent(this.jLabel2)).addGroup(JPI1_VLAOjosLayout.createSequentialGroup().addGap(1, 1, 1).addGroup(JPI1_VLAOjosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI1_VLAOjosLayout.createSequentialGroup().addGroup(JPI1_VLAOjosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLBA2, -2, 12, -2).addComponent(this.JLBA1)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPI1_VLAOjosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHA2).addComponent(this.JCHA1))).addGroup(JPI1_VLAOjosLayout.createSequentialGroup().addComponent(this.JLBA10).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHA10)))).addGroup(JPI1_VLAOjosLayout.createSequentialGroup().addGroup(JPI1_VLAOjosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLBA4, -2, 18, -2).addComponent(this.JLBA5)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHA4)).addGroup(JPI1_VLAOjosLayout.createSequentialGroup().addGroup(JPI1_VLAOjosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLBA11).addComponent(this.JLBA12)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPI1_VLAOjosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHA12).addComponent(this.JCHA11))).addComponent(this.JLB1_VLRClasificacion, -2, 41, -2).addGroup(JPI1_VLAOjosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addGroup(GroupLayout.Alignment.LEADING, JPI1_VLAOjosLayout.createSequentialGroup().addComponent(this.jLabel48).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JCHBFallidoAmbOLejana)).addComponent(this.JLB1_VLResultado, GroupLayout.Alignment.LEADING, -2, 41, -2))).addGap(0, 0, 32767)));
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
        JPINumerosLayout.setHorizontalGroup(JPINumerosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPINumerosLayout.createSequentialGroup().addGap(31, 31, 31).addComponent(this.JLB1).addGap(27, 27, 27).addComponent(this.JLB2).addGap(33, 33, 33).addComponent(this.JLB3).addGap(33, 33, 33).addComponent(this.JLB4).addGap(33, 33, 33).addComponent(this.JLB5).addGap(34, 34, 34).addComponent(this.JLB6).addGap(33, 33, 33).addComponent(this.JLB7).addGap(34, 34, 34).addComponent(this.JLB8).addGap(33, 33, 33).addComponent(this.JLB9).addGap(33, 33, 33).addComponent(this.JLB10).addGap(33, 33, 33).addComponent(this.JLB11).addGap(29, 29, 29).addComponent(this.JLB12).addContainerGap(-1, 32767)));
        JPINumerosLayout.setVerticalGroup(JPINumerosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPINumerosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JLB1).addComponent(this.JLB2).addComponent(this.JLB3).addComponent(this.JLB4).addComponent(this.JLB5).addComponent(this.JLB6).addComponent(this.JLB7).addComponent(this.JLB8).addComponent(this.JLB9).addComponent(this.JLB10).addComponent(this.JLB11).addComponent(this.JLB12)));
        this.JPI2_ODerecho.setBorder(BorderFactory.createEtchedBorder());
        this.jLabel3.setFont(new Font("Arial", 1, 12));
        this.jLabel3.setForeground(Color.blue);
        this.jLabel3.setText("2. Derecho ");
        this.JBG2_VLODerecho.add(this.JCHD1);
        this.JCHD1.setName("1");
        this.JCHD1.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.14
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JCHD1ActionPerformed(evt);
            }
        });
        this.JLBD1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Abajo.png")));
        this.JBG2_VLODerecho.add(this.JCHD2);
        this.JCHD2.setName("2");
        this.JCHD2.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.15
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JCHD2ActionPerformed(evt);
            }
        });
        this.JBG2_VLODerecho.add(this.JCHD3);
        this.JCHD3.setName("3");
        this.JCHD3.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.16
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JCHD3ActionPerformed(evt);
            }
        });
        this.JLBD3.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Izquierda.png")));
        this.JLBD4.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Abajo.png")));
        this.JBG2_VLODerecho.add(this.JCHD4);
        this.JCHD4.setName("4");
        this.JCHD4.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.17
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JCHD4ActionPerformed(evt);
            }
        });
        this.JBG2_VLODerecho.add(this.JCHD5);
        this.JCHD5.setName("5");
        this.JCHD5.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.18
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JCHD5ActionPerformed(evt);
            }
        });
        this.JLBD5.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Izquierda.png")));
        this.JBG2_VLODerecho.add(this.JCHD6);
        this.JCHD6.setName("6");
        this.JCHD6.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.19
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JCHD6ActionPerformed(evt);
            }
        });
        this.JLBD6.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Derecha.png")));
        this.JLBD2.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Derecha.png")));
        this.JLBD7.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Izquierda.png")));
        this.JBG2_VLODerecho.add(this.JCHD7);
        this.JCHD7.setName("7");
        this.JCHD7.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.20
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JCHD7ActionPerformed(evt);
            }
        });
        this.JBG2_VLODerecho.add(this.JCHD8);
        this.JCHD8.setName("8");
        this.JCHD8.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.21
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JCHD8ActionPerformed(evt);
            }
        });
        this.JLBD8.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Izquierda.png")));
        this.JBG2_VLODerecho.add(this.JCHD9);
        this.JCHD9.setName("9");
        this.JCHD9.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.22
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JCHD9ActionPerformed(evt);
            }
        });
        this.JLBD9.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Derecha.png")));
        this.JLBD10.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Arriba.png")));
        this.JBG2_VLODerecho.add(this.JCHD10);
        this.JCHD10.setName("10");
        this.JCHD10.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.23
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JCHD10ActionPerformed(evt);
            }
        });
        this.JBG2_VLODerecho.add(this.JCHD11);
        this.JCHD11.setName("11");
        this.JCHD11.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.24
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JCHD11ActionPerformed(evt);
            }
        });
        this.JLBD11.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Derecha.png")));
        this.JBG2_VLODerecho.add(this.JCHD12);
        this.JCHD12.setName("12");
        this.JCHD12.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.25
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JCHD12ActionPerformed(evt);
            }
        });
        this.JLBD12.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Arriba.png")));
        this.JLB2_VLResultado.setFont(new Font("Arial", 1, 12));
        this.JLB2_VLResultado.setForeground(new Color(255, 0, 0));
        this.JLB2_VLResultado.setHorizontalAlignment(0);
        this.JLB2_VLRClasificacion.setFont(new Font("Arial", 1, 12));
        this.JLB2_VLRClasificacion.setForeground(new Color(255, 0, 0));
        this.JLB2_VLRClasificacion.setHorizontalAlignment(0);
        this.JCHBFallidoOjoDerechoLejana.setName("13");
        this.JCHBFallidoOjoDerechoLejana.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.26
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JCHBFallidoOjoDerechoLejanaActionPerformed(evt);
            }
        });
        this.jLabel49.setFont(new Font("Arial", 1, 12));
        this.jLabel49.setForeground(Color.blue);
        this.jLabel49.setText("X");
        GroupLayout JPI2_ODerechoLayout = new GroupLayout(this.JPI2_ODerecho);
        this.JPI2_ODerecho.setLayout(JPI2_ODerechoLayout);
        JPI2_ODerechoLayout.setHorizontalGroup(JPI2_ODerechoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI2_ODerechoLayout.createSequentialGroup().addContainerGap().addComponent(this.jLabel3).addGroup(JPI2_ODerechoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI2_ODerechoLayout.createSequentialGroup().addGap(26, 26, 26).addComponent(this.JLBD1)).addGroup(JPI2_ODerechoLayout.createSequentialGroup().addGap(22, 22, 22).addComponent(this.JCHD1))).addGap(18, 18, 18).addGroup(JPI2_ODerechoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLBD2, -2, 21, -2).addComponent(this.JCHD2)).addGap(20, 20, 20).addGroup(JPI2_ODerechoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLBD3, -2, 21, -2).addComponent(this.JCHD3)).addGroup(JPI2_ODerechoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI2_ODerechoLayout.createSequentialGroup().addGap(20, 20, 20).addComponent(this.JLBD4, -2, 21, -2)).addGroup(JPI2_ODerechoLayout.createSequentialGroup().addGap(17, 17, 17).addComponent(this.JCHD4))).addGroup(JPI2_ODerechoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI2_ODerechoLayout.createSequentialGroup().addGap(22, 22, 22).addComponent(this.JCHD5)).addGroup(JPI2_ODerechoLayout.createSequentialGroup().addGap(21, 21, 21).addComponent(this.JLBD5))).addGap(18, 18, 18).addGroup(JPI2_ODerechoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLBD6).addComponent(this.JCHD6)).addGap(20, 20, 20).addGroup(JPI2_ODerechoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLBD7).addComponent(this.JCHD7)).addGap(21, 21, 21).addGroup(JPI2_ODerechoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLBD8).addComponent(this.JCHD8)).addGap(18, 18, 18).addGroup(JPI2_ODerechoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI2_ODerechoLayout.createSequentialGroup().addComponent(this.JLBD9).addGap(25, 25, 25).addComponent(this.JLBD10)).addGroup(JPI2_ODerechoLayout.createSequentialGroup().addComponent(this.JCHD9).addGap(18, 18, 18).addComponent(this.JCHD10, -2, 21, -2))).addGap(25, 25, 25).addGroup(JPI2_ODerechoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPI2_ODerechoLayout.createSequentialGroup().addComponent(this.JLBD11).addGap(33, 33, 33).addComponent(this.JLBD12)).addGroup(JPI2_ODerechoLayout.createSequentialGroup().addComponent(this.JCHD11).addGap(25, 25, 25).addComponent(this.JCHD12))).addGap(13, 13, 13).addGroup(JPI2_ODerechoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHBFallidoOjoDerechoLejana).addGroup(JPI2_ODerechoLayout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 8, -2).addComponent(this.jLabel49))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLB2_VLResultado, -2, 55, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLB2_VLRClasificacion, -2, 116, -2).addGap(6, 6, 6)));
        JPI2_ODerechoLayout.setVerticalGroup(JPI2_ODerechoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI2_ODerechoLayout.createSequentialGroup().addGroup(JPI2_ODerechoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI2_ODerechoLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPI2_ODerechoLayout.createSequentialGroup().addComponent(this.JLBD6).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHD6)).addGroup(JPI2_ODerechoLayout.createSequentialGroup().addComponent(this.JLBD7).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHD7)).addGroup(JPI2_ODerechoLayout.createSequentialGroup().addGroup(JPI2_ODerechoLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JLBD2).addComponent(this.JLBD3)).addGap(28, 28, 28)).addGroup(GroupLayout.Alignment.LEADING, JPI2_ODerechoLayout.createSequentialGroup().addGap(1, 1, 1).addGroup(JPI2_ODerechoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLBD5).addGroup(JPI2_ODerechoLayout.createSequentialGroup().addComponent(this.JLBD4).addGap(1, 1, 1).addComponent(this.JCHD4))))).addGroup(JPI2_ODerechoLayout.createSequentialGroup().addComponent(this.JLBD1).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPI2_ODerechoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHD2).addComponent(this.JCHD3).addComponent(this.JCHD1, GroupLayout.Alignment.TRAILING)))).addGap(0, 0, 32767)).addGroup(JPI2_ODerechoLayout.createSequentialGroup().addGroup(JPI2_ODerechoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI2_ODerechoLayout.createSequentialGroup().addGroup(JPI2_ODerechoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI2_ODerechoLayout.createSequentialGroup().addGroup(JPI2_ODerechoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLBD11).addComponent(this.JLBD12)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPI2_ODerechoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHD12).addComponent(this.JCHD11))).addGroup(JPI2_ODerechoLayout.createSequentialGroup().addContainerGap().addComponent(this.jLabel3)).addGroup(JPI2_ODerechoLayout.createSequentialGroup().addComponent(this.JLBD8).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHD8)).addGroup(JPI2_ODerechoLayout.createSequentialGroup().addGroup(JPI2_ODerechoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLBD9).addComponent(this.JLBD10)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPI2_ODerechoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHD9).addComponent(this.JCHD10))).addGroup(JPI2_ODerechoLayout.createSequentialGroup().addGap(19, 19, 19).addComponent(this.JCHD5)).addComponent(this.JLB2_VLRClasificacion, -2, 41, -2).addComponent(this.JLB2_VLResultado, -2, 41, -2)).addGap(0, 0, 32767)).addGroup(JPI2_ODerechoLayout.createSequentialGroup().addComponent(this.jLabel49).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JCHBFallidoOjoDerechoLejana))).addContainerGap()));
        this.JPI3_OIzquierdo.setBorder(BorderFactory.createEtchedBorder());
        this.jLabel4.setFont(new Font("Arial", 1, 12));
        this.jLabel4.setForeground(Color.blue);
        this.jLabel4.setText("3. Izquierdo");
        this.JBG3_VLODerecho.add(this.JCHI1);
        this.JCHI1.setName("1");
        this.JCHI1.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.27
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JCHI1ActionPerformed(evt);
            }
        });
        this.JLBI1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Derecha.png")));
        this.JLBI2.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Abajo.png")));
        this.JBG3_VLODerecho.add(this.JCHI2);
        this.JCHI2.setName("2");
        this.JCHI2.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.28
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JCHI2ActionPerformed(evt);
            }
        });
        this.JLBI3.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Derecha.png")));
        this.JBG3_VLODerecho.add(this.JCHI3);
        this.JCHI3.setName("3");
        this.JCHI3.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.29
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JCHI3ActionPerformed(evt);
            }
        });
        this.JLBI4.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Abajo.png")));
        this.JBG3_VLODerecho.add(this.JCHI4);
        this.JCHI4.setName("4");
        this.JCHI4.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.30
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JCHI4ActionPerformed(evt);
            }
        });
        this.JLBI5.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Arriba.png")));
        this.JBG3_VLODerecho.add(this.JCHI5);
        this.JCHI5.setName("5");
        this.JCHI5.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.31
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JCHI5ActionPerformed(evt);
            }
        });
        this.JLBI6.setHorizontalAlignment(0);
        this.JLBI6.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Abajo.png")));
        this.JBG3_VLODerecho.add(this.JCHI6);
        this.JCHI6.setName("6");
        this.JCHI6.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.32
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JCHI6ActionPerformed(evt);
            }
        });
        this.JLBI7.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Izquierda.png")));
        this.JBG3_VLODerecho.add(this.JCHI7);
        this.JCHI7.setName("7");
        this.JCHI7.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.33
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JCHI7ActionPerformed(evt);
            }
        });
        this.JLBI8.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Izquierda.png")));
        this.JBG3_VLODerecho.add(this.JCHI8);
        this.JCHI8.setName("8");
        this.JCHI8.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.34
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JCHI8ActionPerformed(evt);
            }
        });
        this.JLBI9.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Derecha.png")));
        this.JBG3_VLODerecho.add(this.JCHI9);
        this.JCHI9.setName("9");
        this.JCHI9.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.35
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JCHI9ActionPerformed(evt);
            }
        });
        this.JLBI10.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Izquierda.png")));
        this.JBG3_VLODerecho.add(this.JCHI10);
        this.JCHI10.setName("10");
        this.JCHI10.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.36
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JCHI10ActionPerformed(evt);
            }
        });
        this.JLBI11.setHorizontalAlignment(0);
        this.JLBI11.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Arriba.png")));
        this.JBG3_VLODerecho.add(this.JCHI11);
        this.JCHI11.setName("11");
        this.JCHI11.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.37
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JCHI11ActionPerformed(evt);
            }
        });
        this.JLBI12.setHorizontalAlignment(0);
        this.JLBI12.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Arriba.png")));
        this.JBG3_VLODerecho.add(this.JCHI12);
        this.JCHI12.setName("12");
        this.JCHI12.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.38
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JCHI12ActionPerformed(evt);
            }
        });
        this.JLB3_VLResultado.setFont(new Font("Arial", 1, 12));
        this.JLB3_VLResultado.setForeground(new Color(255, 0, 0));
        this.JLB3_VLResultado.setHorizontalAlignment(0);
        this.JLB3_VLRClasificacion.setFont(new Font("Arial", 1, 12));
        this.JLB3_VLRClasificacion.setForeground(new Color(255, 0, 0));
        this.JLB3_VLRClasificacion.setHorizontalAlignment(0);
        this.JCHBFallidoOjoIzqLejana.setName("13");
        this.JCHBFallidoOjoIzqLejana.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.39
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JCHBFallidoOjoIzqLejanaActionPerformed(evt);
            }
        });
        this.jLabel73.setFont(new Font("Arial", 1, 12));
        this.jLabel73.setForeground(Color.blue);
        this.jLabel73.setText("X");
        GroupLayout JPI3_OIzquierdoLayout = new GroupLayout(this.JPI3_OIzquierdo);
        this.JPI3_OIzquierdo.setLayout(JPI3_OIzquierdoLayout);
        JPI3_OIzquierdoLayout.setHorizontalGroup(JPI3_OIzquierdoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI3_OIzquierdoLayout.createSequentialGroup().addContainerGap().addComponent(this.jLabel4).addGap(23, 23, 23).addGroup(JPI3_OIzquierdoLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JLBI1).addComponent(this.JCHI1)).addGroup(JPI3_OIzquierdoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI3_OIzquierdoLayout.createSequentialGroup().addGap(21, 21, 21).addComponent(this.JLBI2)).addGroup(JPI3_OIzquierdoLayout.createSequentialGroup().addGap(18, 18, 18).addComponent(this.JCHI2))).addGap(21, 21, 21).addGroup(JPI3_OIzquierdoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI3_OIzquierdoLayout.createSequentialGroup().addComponent(this.JLBI3).addGap(20, 20, 20).addComponent(this.JLBI4).addGap(35, 35, 35).addComponent(this.JLBI5, -2, 13, -2)).addGroup(JPI3_OIzquierdoLayout.createSequentialGroup().addComponent(this.JCHI3).addGap(15, 15, 15).addComponent(this.JCHI4).addGap(24, 24, 24).addComponent(this.JCHI5))).addGap(18, 18, 18).addGroup(JPI3_OIzquierdoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JCHI6, -1, -1, 32767).addComponent(this.JLBI6, -1, -1, 32767)).addGap(18, 18, 18).addGroup(JPI3_OIzquierdoLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JLBI7).addComponent(this.JCHI7)).addGap(21, 21, 21).addGroup(JPI3_OIzquierdoLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JLBI8).addComponent(this.JCHI8)).addGap(18, 18, 18).addGroup(JPI3_OIzquierdoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLBI9).addComponent(this.JCHI9)).addGap(22, 22, 22).addGroup(JPI3_OIzquierdoLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JLBI10).addComponent(this.JCHI10)).addGap(22, 22, 22).addGroup(JPI3_OIzquierdoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JCHI11, -1, -1, 32767).addComponent(this.JLBI11, -1, -1, 32767)).addGap(28, 28, 28).addGroup(JPI3_OIzquierdoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JCHI12, -1, -1, 32767).addComponent(this.JLBI12, -1, -1, 32767)).addGap(13, 13, 13).addGroup(JPI3_OIzquierdoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHBFallidoOjoIzqLejana).addGroup(JPI3_OIzquierdoLayout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 8, -2).addComponent(this.jLabel73))).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JLB3_VLResultado, -2, 46, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLB3_VLRClasificacion, -2, 119, -2).addGap(6, 6, 6)));
        JPI3_OIzquierdoLayout.setVerticalGroup(JPI3_OIzquierdoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI3_OIzquierdoLayout.createSequentialGroup().addContainerGap().addComponent(this.jLabel4).addGap(0, 0, 32767)).addGroup(GroupLayout.Alignment.TRAILING, JPI3_OIzquierdoLayout.createSequentialGroup().addGap(0, 0, 32767).addGroup(JPI3_OIzquierdoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPI3_OIzquierdoLayout.createSequentialGroup().addGroup(JPI3_OIzquierdoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLBI1).addComponent(this.JLBI4).addComponent(this.JLBI2).addComponent(this.JLBI3)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPI3_OIzquierdoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHI2).addComponent(this.JCHI1).addComponent(this.JCHI3).addComponent(this.JCHI4).addComponent(this.JCHI5))).addComponent(this.JLBI5).addGroup(JPI3_OIzquierdoLayout.createSequentialGroup().addGroup(JPI3_OIzquierdoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLBI6).addComponent(this.JLBI7).addComponent(this.JLBI8).addComponent(this.JLBI9).addComponent(this.JLBI10).addComponent(this.JLBI11)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPI3_OIzquierdoLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JCHI6).addComponent(this.JCHI7).addComponent(this.JCHI8).addComponent(this.JCHI9).addComponent(this.JCHI10).addComponent(this.JCHI11))).addGroup(GroupLayout.Alignment.TRAILING, JPI3_OIzquierdoLayout.createSequentialGroup().addComponent(this.JLBI12).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JCHI12))).addGap(12, 12, 12)).addGroup(JPI3_OIzquierdoLayout.createSequentialGroup().addGroup(JPI3_OIzquierdoLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPI3_OIzquierdoLayout.createSequentialGroup().addComponent(this.jLabel73).addGap(5, 5, 5).addComponent(this.JCHBFallidoOjoIzqLejana)).addGroup(JPI3_OIzquierdoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLB3_VLResultado, -2, 41, -2).addComponent(this.JLB3_VLRClasificacion, -2, 41, -2))).addContainerGap(-1, 32767)));
        this.JPI4_Estereopsis.setBorder(BorderFactory.createEtchedBorder());
        this.jLabel5.setFont(new Font("Arial", 1, 12));
        this.jLabel5.setForeground(Color.blue);
        this.jLabel5.setText("4. Estereopsis");
        this.jLabel1.setFont(new Font("Arial", 1, 12));
        this.jLabel1.setForeground(new Color(255, 0, 0));
        this.jLabel1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/convencionvisio.png")));
        this.jLabel26.setFont(new Font("Arial", 1, 12));
        this.jLabel26.setForeground(new Color(0, 0, 255));
        this.jLabel26.setText("        1             2                  3             4                 5                  6");
        this.JCHBEs1.setName("1");
        this.JCHBEs1.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.40
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JCHBEs1ActionPerformed(evt);
            }
        });
        this.JCHBEs2.setName("2");
        this.JCHBEs2.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.41
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JCHBEs2ActionPerformed(evt);
            }
        });
        this.JCHBEs3.setName("3");
        this.JCHBEs3.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.42
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JCHBEs3ActionPerformed(evt);
            }
        });
        this.JCHBEs4.setName("4");
        this.JCHBEs4.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.43
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JCHBEs4ActionPerformed(evt);
            }
        });
        this.JCHBEs5.setName("5");
        this.JCHBEs5.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.44
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JCHBEs5ActionPerformed(evt);
            }
        });
        this.JCHBEs6.setName("6");
        this.JCHBEs6.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.45
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JCHBEs6ActionPerformed(evt);
            }
        });
        this.jLabel43.setFont(new Font("Arial", 1, 12));
        this.jLabel43.setText("Percepción:");
        this.JLPercepcion.setFont(new Font("Arial", 1, 12));
        this.JLB4_VLRClasificacion.setFont(new Font("Arial", 1, 12));
        this.JLB4_VLRClasificacion.setForeground(Color.red);
        this.JCHBFallido.setName("0");
        this.JCHBFallido.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.46
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JCHBFallidoActionPerformed(evt);
            }
        });
        this.jLabel44.setFont(new Font("Arial", 1, 12));
        this.jLabel44.setForeground(Color.blue);
        this.jLabel44.setText("Fallido");
        GroupLayout JPI4_EstereopsisLayout = new GroupLayout(this.JPI4_Estereopsis);
        this.JPI4_Estereopsis.setLayout(JPI4_EstereopsisLayout);
        JPI4_EstereopsisLayout.setHorizontalGroup(JPI4_EstereopsisLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI4_EstereopsisLayout.createSequentialGroup().addContainerGap().addComponent(this.jLabel5).addGap(50, 50, 50).addGroup(JPI4_EstereopsisLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI4_EstereopsisLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JCHBEs6).addComponent(this.jLabel1)).addGroup(JPI4_EstereopsisLayout.createSequentialGroup().addGap(18, 18, 18).addComponent(this.JCHBEs1).addGap(26, 26, 26).addComponent(this.JCHBEs2).addGap(38, 38, 38).addComponent(this.JCHBEs3).addGap(29, 29, 29).addComponent(this.JCHBEs4).addGap(34, 34, 34).addComponent(this.JCHBEs5)).addComponent(this.jLabel26)).addGroup(JPI4_EstereopsisLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI4_EstereopsisLayout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel43).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLPercepcion, -2, 53, -2).addGap(18, 18, 18).addComponent(this.JCHBFallido).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jLabel44).addContainerGap(-1, 32767)).addGroup(GroupLayout.Alignment.TRAILING, JPI4_EstereopsisLayout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JLB4_VLRClasificacion, -2, 199, -2).addContainerGap()))));
        JPI4_EstereopsisLayout.setVerticalGroup(JPI4_EstereopsisLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI4_EstereopsisLayout.createSequentialGroup().addGap(1, 1, 1).addGroup(JPI4_EstereopsisLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPI4_EstereopsisLayout.createSequentialGroup().addComponent(this.jLabel26).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPI4_EstereopsisLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JCHBEs1).addComponent(this.JCHBEs2).addComponent(this.JCHBEs3).addComponent(this.JCHBEs4).addComponent(this.JCHBEs5).addComponent(this.JCHBEs6))).addComponent(this.jLabel5)).addGap(6, 6, 6).addComponent(this.jLabel1).addGap(3, 3, 3)).addGroup(GroupLayout.Alignment.TRAILING, JPI4_EstereopsisLayout.createSequentialGroup().addContainerGap().addComponent(this.JLB4_VLRClasificacion, -2, 28, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(JPI4_EstereopsisLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI4_EstereopsisLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPI4_EstereopsisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel43).addComponent(this.JLPercepcion, -2, 14, -2)).addComponent(this.JCHBFallido, GroupLayout.Alignment.TRAILING)).addComponent(this.jLabel44)).addContainerGap()));
        this.JPI5_Color.setBorder(BorderFactory.createEtchedBorder());
        this.jLabel23.setFont(new Font("Arial", 1, 12));
        this.jLabel23.setForeground(Color.blue);
        this.jLabel23.setText("5. Color");
        this.JCHBC.setName("1");
        this.JCHBC.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.47
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JCHBCActionPerformed(evt);
            }
        });
        this.jLabel42.setFont(new Font("Arial", 1, 12));
        this.jLabel42.setForeground(new Color(51, 51, 255));
        this.jLabel42.setText("8");
        this.JCHBC1.setName("2");
        this.JCHBC1.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.48
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JCHBC1ActionPerformed(evt);
            }
        });
        this.JCHBC5.setName("3");
        this.JCHBC5.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.49
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JCHBC5ActionPerformed(evt);
            }
        });
        this.JCHBC6.setName("4");
        this.JCHBC6.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.50
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JCHBC6ActionPerformed(evt);
            }
        });
        this.JLB5_VLRClasificacion.setFont(new Font("Arial", 1, 12));
        this.JLB5_VLRClasificacion.setForeground(new Color(255, 0, 0));
        this.jLabel62.setFont(new Font("Arial", 1, 12));
        this.jLabel62.setForeground(new Color(0, 102, 0));
        this.jLabel62.setText("1");
        this.jLabel63.setFont(new Font("Arial", 1, 12));
        this.jLabel63.setForeground(new Color(51, 51, 255));
        this.jLabel63.setText("5");
        this.jLabel64.setFont(new Font("Arial", 1, 12));
        this.jLabel64.setForeground(new Color(255, 0, 0));
        this.jLabel64.setText("4");
        this.jLabel65.setFont(new Font("Arial", 1, 12));
        this.jLabel65.setForeground(new Color(0, 102, 0));
        this.jLabel65.setText("6");
        this.jLabel66.setFont(new Font("Arial", 1, 12));
        this.jLabel66.setForeground(new Color(255, 0, 0));
        this.jLabel66.setText("3");
        this.jLabel67.setFont(new Font("Arial", 1, 12));
        this.jLabel67.setForeground(new Color(51, 51, 255));
        this.jLabel67.setText("2");
        this.jLabel68.setFont(new Font("Arial", 1, 12));
        this.jLabel68.setForeground(new Color(0, 102, 0));
        this.jLabel68.setText("7");
        this.JCHBC7.setName("5");
        this.JCHBC7.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.51
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JCHBC7ActionPerformed(evt);
            }
        });
        this.jLabel69.setFont(new Font("Arial", 1, 12));
        this.jLabel69.setForeground(new Color(255, 0, 0));
        this.jLabel69.setText("9");
        this.jLabel70.setFont(new Font("Arial", 1, 12));
        this.jLabel70.setForeground(new Color(51, 51, 255));
        this.jLabel70.setText("0");
        this.jLabel71.setFont(new Font("Arial", 1, 12));
        this.jLabel71.setForeground(new Color(0, 102, 0));
        this.jLabel71.setText("1");
        this.jLabel72.setFont(new Font("Arial", 1, 12));
        this.jLabel72.setForeground(new Color(255, 0, 0));
        this.jLabel72.setText("8");
        this.JCHBC8.setName("6");
        this.JCHBC8.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.52
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JCHBC8ActionPerformed(evt);
            }
        });
        GroupLayout JPI5_ColorLayout = new GroupLayout(this.JPI5_Color);
        this.JPI5_Color.setLayout(JPI5_ColorLayout);
        JPI5_ColorLayout.setHorizontalGroup(JPI5_ColorLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI5_ColorLayout.createSequentialGroup().addContainerGap().addComponent(this.jLabel23).addGap(64, 64, 64).addGroup(JPI5_ColorLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI5_ColorLayout.createSequentialGroup().addComponent(this.JCHBC).addGap(33, 33, 33).addComponent(this.JCHBC1).addGap(33, 33, 33).addComponent(this.JCHBC5)).addGroup(JPI5_ColorLayout.createSequentialGroup().addComponent(this.jLabel42, -2, 15, -2).addGap(0, 0, 0).addComponent(this.jLabel62, -2, 17, -2).addGap(18, 18, 18).addComponent(this.jLabel64, -2, 17, -2).addGap(0, 0, 0).addComponent(this.jLabel63, -2, 15, -2).addGap(18, 18, 18).addComponent(this.jLabel65, -2, 17, -2).addGap(0, 0, 0).addComponent(this.jLabel66, -2, 15, -2))).addGap(33, 33, 33).addGroup(JPI5_ColorLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI5_ColorLayout.createSequentialGroup().addComponent(this.jLabel67, -2, 17, -2).addGap(0, 0, 0).addComponent(this.jLabel68, -2, 15, -2)).addComponent(this.JCHBC6)).addGap(33, 33, 33).addGroup(JPI5_ColorLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHBC7).addGroup(JPI5_ColorLayout.createSequentialGroup().addComponent(this.jLabel69, -2, 17, -2).addGap(0, 0, 0).addComponent(this.jLabel70, -2, 15, -2))).addGap(33, 33, 33).addGroup(JPI5_ColorLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHBC8).addGroup(JPI5_ColorLayout.createSequentialGroup().addComponent(this.jLabel71, -2, 17, -2).addGap(0, 0, 0).addComponent(this.jLabel72, -2, 15, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JLB5_VLRClasificacion, -2, 145, -2).addContainerGap()));
        JPI5_ColorLayout.setVerticalGroup(JPI5_ColorLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI5_ColorLayout.createSequentialGroup().addGroup(JPI5_ColorLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI5_ColorLayout.createSequentialGroup().addContainerGap().addComponent(this.jLabel23)).addComponent(this.JLB5_VLRClasificacion, -2, 41, -2).addGroup(JPI5_ColorLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JCHBC7).addComponent(this.JCHBC1).addGroup(JPI5_ColorLayout.createSequentialGroup().addGroup(JPI5_ColorLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel42).addComponent(this.jLabel62).addComponent(this.jLabel63).addComponent(this.jLabel64).addComponent(this.jLabel66).addComponent(this.jLabel65)).addGap(3, 3, 3).addComponent(this.JCHBC)).addComponent(this.JCHBC5).addGroup(JPI5_ColorLayout.createSequentialGroup().addGroup(JPI5_ColorLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel68).addComponent(this.jLabel67).addComponent(this.jLabel70).addComponent(this.jLabel69)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHBC6))).addGroup(JPI5_ColorLayout.createSequentialGroup().addGap(1, 1, 1).addGroup(JPI5_ColorLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPI5_ColorLayout.createSequentialGroup().addGroup(JPI5_ColorLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel72).addComponent(this.jLabel71)).addGap(24, 24, 24)).addComponent(this.JCHBC8)))).addGap(2, 2, 2)));
        this.JPI6_FVertical.setBorder(BorderFactory.createEtchedBorder());
        this.jLabel24.setFont(new Font("Arial", 1, 12));
        this.jLabel24.setForeground(Color.blue);
        this.jLabel24.setText("6. Foria Vertical");
        this.JCHBFV.setName("1");
        this.JCHBFV.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.53
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JCHBFVActionPerformed(evt);
            }
        });
        this.jLabel50.setFont(new Font("Arial", 1, 12));
        this.jLabel50.setForeground(new Color(0, 102, 0));
        this.jLabel50.setText("1");
        this.JCHBFV1.setName("2");
        this.JCHBFV1.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.54
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JCHBFV1ActionPerformed(evt);
            }
        });
        this.JCHBFV2.setName("3");
        this.JCHBFV2.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.55
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JCHBFV2ActionPerformed(evt);
            }
        });
        this.JCHBFV3.setName("4");
        this.JCHBFV3.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.56
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JCHBFV3ActionPerformed(evt);
            }
        });
        this.JCHBFV4.setName("5");
        this.JCHBFV4.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.57
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JCHBFV4ActionPerformed(evt);
            }
        });
        this.JCHBFV5.setName("6");
        this.JCHBFV5.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.58
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JCHBFV5ActionPerformed(evt);
            }
        });
        this.JCHBFV6.setName("7");
        this.JCHBFV6.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.59
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JCHBFV6ActionPerformed(evt);
            }
        });
        this.JCHBFV7.setName("8");
        this.JCHBFV7.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.60
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JCHBFV7ActionPerformed(evt);
            }
        });
        this.JCHBFV8.setName("9");
        this.JCHBFV8.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.61
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JCHBFV8ActionPerformed(evt);
            }
        });
        this.jLabel51.setFont(new Font("Arial", 1, 12));
        this.jLabel51.setForeground(new Color(0, 102, 0));
        this.jLabel51.setText("2           3          4           5            6           7                           8                        9");
        this.JLB6_VLRClasificacion.setFont(new Font("Arial", 1, 12));
        this.JLB6_VLRClasificacion.setForeground(new Color(255, 0, 0));
        GroupLayout JPI6_FVerticalLayout = new GroupLayout(this.JPI6_FVertical);
        this.JPI6_FVertical.setLayout(JPI6_FVerticalLayout);
        JPI6_FVerticalLayout.setHorizontalGroup(JPI6_FVerticalLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI6_FVerticalLayout.createSequentialGroup().addContainerGap().addComponent(this.jLabel24).addGroup(JPI6_FVerticalLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addGroup(JPI6_FVerticalLayout.createSequentialGroup().addGap(32, 32, 32).addComponent(this.jLabel50, -2, 21, -2).addGap(81, 81, 81).addComponent(this.jLabel51, -2, 385, -2)).addGroup(JPI6_FVerticalLayout.createSequentialGroup().addGap(26, 26, 26).addComponent(this.JCHBFV).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JCHBFV1).addGap(18, 18, 18).addComponent(this.JCHBFV2).addGap(18, 18, 18).addComponent(this.JCHBFV3).addGap(18, 18, 18).addComponent(this.JCHBFV4).addGap(21, 21, 21).addComponent(this.JCHBFV5).addGap(20, 20, 20).addComponent(this.JCHBFV6).addGap(68, 68, 68).addComponent(this.JCHBFV7).addGap(61, 61, 61).addComponent(this.JCHBFV8))).addGap(27, 27, 27).addComponent(this.JLB6_VLRClasificacion, -1, -1, 32767).addGap(125, 125, 125)));
        JPI6_FVerticalLayout.setVerticalGroup(JPI6_FVerticalLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI6_FVerticalLayout.createSequentialGroup().addGroup(JPI6_FVerticalLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI6_FVerticalLayout.createSequentialGroup().addContainerGap().addComponent(this.jLabel24)).addGroup(JPI6_FVerticalLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPI6_FVerticalLayout.createSequentialGroup().addGroup(JPI6_FVerticalLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jLabel51).addComponent(this.jLabel50)).addGap(10, 10, 10).addGroup(JPI6_FVerticalLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHBFV1, GroupLayout.Alignment.TRAILING).addComponent(this.JCHBFV2, GroupLayout.Alignment.TRAILING).addComponent(this.JCHBFV, GroupLayout.Alignment.TRAILING).addComponent(this.JCHBFV3, GroupLayout.Alignment.TRAILING).addComponent(this.JCHBFV4, GroupLayout.Alignment.TRAILING).addComponent(this.JCHBFV5, GroupLayout.Alignment.TRAILING).addComponent(this.JCHBFV6, GroupLayout.Alignment.TRAILING).addComponent(this.JCHBFV7, GroupLayout.Alignment.TRAILING).addComponent(this.JCHBFV8, GroupLayout.Alignment.TRAILING))).addComponent(this.JLB6_VLRClasificacion, -2, 41, -2))).addContainerGap(-1, 32767)));
        this.JPI7_FLateral.setBorder(BorderFactory.createEtchedBorder());
        this.jLabel25.setFont(new Font("Arial", 1, 12));
        this.jLabel25.setForeground(Color.blue);
        this.jLabel25.setText("7. Foria Lateral");
        this.JCHBFLa.setName("1");
        this.JCHBFLa.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.62
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JCHBFLaActionPerformed(evt);
            }
        });
        this.JCHBFLa1.setName("2");
        this.JCHBFLa1.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.63
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JCHBFLa1ActionPerformed(evt);
            }
        });
        this.JCHBFLa2.setName("3");
        this.JCHBFLa2.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.64
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JCHBFLa2ActionPerformed(evt);
            }
        });
        this.JCHBFLa3.setName("4");
        this.JCHBFLa3.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.65
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JCHBFLa3ActionPerformed(evt);
            }
        });
        this.JCHBFLa4.setName("5");
        this.JCHBFLa4.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.66
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JCHBFLa4ActionPerformed(evt);
            }
        });
        this.JCHBFLa5.setName("6");
        this.JCHBFLa5.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.67
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JCHBFLa5ActionPerformed(evt);
            }
        });
        this.JCHBFLa6.setName("7");
        this.JCHBFLa6.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.68
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JCHBFLa6ActionPerformed(evt);
            }
        });
        this.JCHBFLa7.setName("8");
        this.JCHBFLa7.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.69
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JCHBFLa7ActionPerformed(evt);
            }
        });
        this.JCHBFLa8.setName("9");
        this.JCHBFLa8.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.70
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JCHBFLa8ActionPerformed(evt);
            }
        });
        this.JCHBFLa9.setName("10");
        this.JCHBFLa9.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.71
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JCHBFLa9ActionPerformed(evt);
            }
        });
        this.JCHBFLa10.setName("11");
        this.JCHBFLa10.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.72
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JCHBFLa10ActionPerformed(evt);
            }
        });
        this.JCHBFLa11.setName("12");
        this.JCHBFLa11.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.73
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JCHBFLa11ActionPerformed(evt);
            }
        });
        this.JCHBFLa12.setName("13");
        this.JCHBFLa12.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.74
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JCHBFLa12ActionPerformed(evt);
            }
        });
        this.JCHBFLa13.setName("14");
        this.JCHBFLa13.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.75
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JCHBFLa13ActionPerformed(evt);
            }
        });
        this.JCHBFLa14.setName("15");
        this.JCHBFLa14.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.76
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JCHBFLa14ActionPerformed(evt);
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
        JCHBFLLayout.setHorizontalGroup(JCHBFLLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JCHBFLLayout.createSequentialGroup().addContainerGap().addGroup(JCHBFLLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPI1_VLAOjos, -1, 837, 32767).addGroup(JCHBFLLayout.createSequentialGroup().addGap(79, 79, 79).addComponent(this.JPINumeros, -2, -1, -2).addGap(0, 0, 32767)).addComponent(this.JPI2_ODerecho, -1, -1, 32767).addComponent(this.JPI3_OIzquierdo, -1, -1, 32767).addComponent(this.JPI4_Estereopsis, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addComponent(this.JPI5_Color, -1, -1, 32767).addComponent(this.JPI6_FVertical, -1, -1, 32767).addComponent(this.JPI7_FLateral, -1, -1, 32767)).addContainerGap()));
        JCHBFLLayout.setVerticalGroup(JCHBFLLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JCHBFLLayout.createSequentialGroup().addGap(2, 2, 2).addComponent(this.JPINumeros, -2, -1, -2).addGap(1, 1, 1).addComponent(this.JPI1_VLAOjos, -2, 46, -2).addGap(5, 5, 5).addComponent(this.JPI2_ODerecho, -2, 45, -2).addGap(5, 5, 5).addComponent(this.JPI3_OIzquierdo, -2, 45, -2).addGap(8, 8, 8).addComponent(this.JPI4_Estereopsis, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPI5_Color, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JPI6_FVertical, -2, 52, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JPI7_FLateral, -2, -1, -2).addContainerGap(-1, 32767)));
        this.JTPDatosTest.addTab("VISIÓN LEJANA", this.JCHBFL);
        this.JPI8_VCAOjos.setBorder(BorderFactory.createEtchedBorder());
        this.JPI8_VCAOjos.setPreferredSize(new Dimension(753, 56));
        this.JPI8_VCAOjos.setRequestFocusEnabled(false);
        this.jLabel6.setFont(new Font("Arial", 1, 12));
        this.jLabel6.setForeground(Color.blue);
        this.jLabel6.setText("8. Ambos Ojos");
        this.JBG8_VCAOjos.add(this.JCHBAOjos);
        this.JCHBAOjos.setName("1");
        this.JCHBAOjos.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.77
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JCHBAOjosActionPerformed(evt);
            }
        });
        this.JBG8_VCAOjos.add(this.JCHBAOjos1);
        this.JCHBAOjos1.setName("2");
        this.JCHBAOjos1.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.78
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JCHBAOjos1ActionPerformed(evt);
            }
        });
        this.JBG8_VCAOjos.add(this.JCHBAOjos3);
        this.JCHBAOjos3.setName("3");
        this.JCHBAOjos3.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.79
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JCHBAOjos3ActionPerformed(evt);
            }
        });
        this.JBG8_VCAOjos.add(this.JCHBAOjos4);
        this.JCHBAOjos4.setName("4");
        this.JCHBAOjos4.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.80
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JCHBAOjos4ActionPerformed(evt);
            }
        });
        this.JBG8_VCAOjos.add(this.JCHBAOjos5);
        this.JCHBAOjos5.setName("5");
        this.JCHBAOjos5.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.81
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JCHBAOjos5ActionPerformed(evt);
            }
        });
        this.JBG8_VCAOjos.add(this.JCHBAOjos6);
        this.JCHBAOjos6.setName("6");
        this.JCHBAOjos6.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.82
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JCHBAOjos6ActionPerformed(evt);
            }
        });
        this.JBG8_VCAOjos.add(this.JCHBAOjos7);
        this.JCHBAOjos7.setName("7");
        this.JCHBAOjos7.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.83
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JCHBAOjos7ActionPerformed(evt);
            }
        });
        this.JBG8_VCAOjos.add(this.JCHBAOjos8);
        this.JCHBAOjos8.setName("8");
        this.JCHBAOjos8.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.84
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JCHBAOjos8ActionPerformed(evt);
            }
        });
        this.JBG8_VCAOjos.add(this.JCHBAOjos9);
        this.JCHBAOjos9.setName("9");
        this.JCHBAOjos9.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.85
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JCHBAOjos9ActionPerformed(evt);
            }
        });
        this.JBG8_VCAOjos.add(this.JCHBAOjos10);
        this.JCHBAOjos10.setName("10");
        this.JCHBAOjos10.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.86
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JCHBAOjos10ActionPerformed(evt);
            }
        });
        this.JBG8_VCAOjos.add(this.JCHBAOjos11);
        this.JCHBAOjos11.setName("11");
        this.JCHBAOjos11.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.87
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JCHBAOjos11ActionPerformed(evt);
            }
        });
        this.JBG8_VCAOjos.add(this.JCHBAOjos12);
        this.JCHBAOjos12.setName("12");
        this.JCHBAOjos12.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.88
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JCHBAOjos12ActionPerformed(evt);
            }
        });
        this.jLabel9.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Arriba.png")));
        this.jLabel10.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Arriba.png")));
        this.jLabel11.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Derecha.png")));
        this.jLabel12.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Arriba.png")));
        this.jLabel13.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Derecha.png")));
        this.jLabel14.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Arriba.png")));
        this.jLabel15.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Izquierda.png")));
        this.jLabel16.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Arriba.png")));
        this.jLabel17.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Derecha.png")));
        this.jLabel18.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Izquierda.png")));
        this.jLabel19.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Derecha.png")));
        this.jLabel20.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Abajo.png")));
        this.JLB8_VCResultado.setFont(new Font("Arial", 1, 12));
        this.JLB8_VCResultado.setForeground(new Color(255, 0, 0));
        this.JLB8_VCResultado.setHorizontalAlignment(0);
        this.JLB8_VCRClasificacion.setFont(new Font("Arial", 1, 12));
        this.JLB8_VCRClasificacion.setForeground(new Color(255, 0, 0));
        this.JLB8_VCRClasificacion.setHorizontalAlignment(0);
        this.jLabel74.setFont(new Font("Arial", 1, 12));
        this.jLabel74.setForeground(Color.blue);
        this.jLabel74.setText("X");
        this.JCHBFallidoAmbOCercana.setName("13");
        this.JCHBFallidoAmbOCercana.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.89
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JCHBFallidoAmbOCercanaActionPerformed(evt);
            }
        });
        GroupLayout JPI8_VCAOjosLayout = new GroupLayout(this.JPI8_VCAOjos);
        this.JPI8_VCAOjos.setLayout(JPI8_VCAOjosLayout);
        JPI8_VCAOjosLayout.setHorizontalGroup(JPI8_VCAOjosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI8_VCAOjosLayout.createSequentialGroup().addContainerGap().addComponent(this.jLabel6).addGroup(JPI8_VCAOjosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI8_VCAOjosLayout.createSequentialGroup().addGap(21, 21, 21).addComponent(this.jLabel9).addGap(18, 18, 18).addComponent(this.jLabel10)).addGroup(JPI8_VCAOjosLayout.createSequentialGroup().addGap(18, 18, 18).addComponent(this.JCHBAOjos).addGap(12, 12, 12).addComponent(this.JCHBAOjos1))).addGap(18, 18, 18).addGroup(JPI8_VCAOjosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI8_VCAOjosLayout.createSequentialGroup().addComponent(this.JCHBAOjos3).addGap(18, 18, 18).addComponent(this.JCHBAOjos4)).addGroup(JPI8_VCAOjosLayout.createSequentialGroup().addComponent(this.jLabel11).addGap(26, 26, 26).addComponent(this.jLabel12))).addGap(21, 21, 21).addGroup(JPI8_VCAOjosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI8_VCAOjosLayout.createSequentialGroup().addComponent(this.jLabel13).addGap(22, 22, 22).addComponent(this.jLabel14)).addGroup(JPI8_VCAOjosLayout.createSequentialGroup().addComponent(this.JCHBAOjos5).addGap(15, 15, 15).addComponent(this.JCHBAOjos6))).addGap(23, 23, 23).addGroup(JPI8_VCAOjosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHBAOjos7).addComponent(this.jLabel15)).addGroup(JPI8_VCAOjosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI8_VCAOjosLayout.createSequentialGroup().addGap(24, 24, 24).addComponent(this.jLabel16)).addGroup(JPI8_VCAOjosLayout.createSequentialGroup().addGap(21, 21, 21).addComponent(this.JCHBAOjos8))).addGap(21, 21, 21).addGroup(JPI8_VCAOjosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHBAOjos9).addComponent(this.jLabel17)).addGap(23, 23, 23).addGroup(JPI8_VCAOjosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHBAOjos10).addComponent(this.jLabel18)).addGap(24, 24, 24).addGroup(JPI8_VCAOjosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHBAOjos11).addComponent(this.jLabel19)).addGroup(JPI8_VCAOjosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI8_VCAOjosLayout.createSequentialGroup().addGap(20, 20, 20).addComponent(this.JCHBAOjos12)).addGroup(JPI8_VCAOjosLayout.createSequentialGroup().addGap(22, 22, 22).addComponent(this.jLabel20))).addGap(20, 20, 20).addGroup(JPI8_VCAOjosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHBFallidoAmbOCercana).addGroup(JPI8_VCAOjosLayout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 8, -2).addComponent(this.jLabel74))).addGap(7, 7, 7).addComponent(this.JLB8_VCResultado, -2, 55, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLB8_VCRClasificacion, -2, 116, -2).addGap(6, 6, 6)));
        JPI8_VCAOjosLayout.setVerticalGroup(JPI8_VCAOjosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI8_VCAOjosLayout.createSequentialGroup().addContainerGap().addComponent(this.jLabel6)).addGroup(JPI8_VCAOjosLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPI8_VCAOjosLayout.createSequentialGroup().addComponent(this.jLabel19).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JCHBAOjos11)).addGroup(GroupLayout.Alignment.TRAILING, JPI8_VCAOjosLayout.createSequentialGroup().addComponent(this.jLabel13).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JCHBAOjos5)).addGroup(JPI8_VCAOjosLayout.createSequentialGroup().addComponent(this.jLabel12).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JCHBAOjos4)).addGroup(JPI8_VCAOjosLayout.createSequentialGroup().addComponent(this.jLabel11).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JCHBAOjos3)).addGroup(JPI8_VCAOjosLayout.createSequentialGroup().addGroup(JPI8_VCAOjosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI8_VCAOjosLayout.createSequentialGroup().addComponent(this.jLabel9).addGap(3, 3, 3)).addGroup(GroupLayout.Alignment.TRAILING, JPI8_VCAOjosLayout.createSequentialGroup().addComponent(this.jLabel10).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED))).addGroup(JPI8_VCAOjosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHBAOjos).addComponent(this.JCHBAOjos1))).addGroup(JPI8_VCAOjosLayout.createSequentialGroup().addGroup(JPI8_VCAOjosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel14).addComponent(this.jLabel15).addComponent(this.jLabel16).addComponent(this.jLabel17).addComponent(this.jLabel18)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(JPI8_VCAOjosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHBAOjos10, GroupLayout.Alignment.TRAILING).addComponent(this.JCHBAOjos9, GroupLayout.Alignment.TRAILING).addComponent(this.JCHBAOjos8, GroupLayout.Alignment.TRAILING).addComponent(this.JCHBAOjos7, GroupLayout.Alignment.TRAILING).addComponent(this.JCHBAOjos6, GroupLayout.Alignment.TRAILING)))).addGroup(JPI8_VCAOjosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPI8_VCAOjosLayout.createSequentialGroup().addComponent(this.jLabel74).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JCHBFallidoAmbOCercana)).addGroup(GroupLayout.Alignment.LEADING, JPI8_VCAOjosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPI8_VCAOjosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLB8_VCResultado, -2, 41, -2).addComponent(this.JLB8_VCRClasificacion, -2, 41, -2)).addGroup(JPI8_VCAOjosLayout.createSequentialGroup().addComponent(this.jLabel20).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHBAOjos12)))));
        this.JPI9_VCDerecho.setBorder(BorderFactory.createEtchedBorder());
        this.jLabel7.setFont(new Font("Arial", 1, 12));
        this.jLabel7.setForeground(Color.blue);
        this.jLabel7.setText("9. Derecho ");
        this.JBG9_VCODerecho.add(this.JCHBDerecho);
        this.JCHBDerecho.setName("1");
        this.JCHBDerecho.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.90
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JCHBDerechoActionPerformed(evt);
            }
        });
        this.JBG9_VCODerecho.add(this.JCHBDerecho1);
        this.JCHBDerecho1.setName("2");
        this.JCHBDerecho1.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.91
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JCHBDerecho1ActionPerformed(evt);
            }
        });
        this.JBG9_VCODerecho.add(this.JCHBDerecho2);
        this.JCHBDerecho2.setName("4");
        this.JCHBDerecho2.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.92
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JCHBDerecho2ActionPerformed(evt);
            }
        });
        this.JBG9_VCODerecho.add(this.JCHBDerecho3);
        this.JCHBDerecho3.setName("3");
        this.JCHBDerecho3.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.93
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JCHBDerecho3ActionPerformed(evt);
            }
        });
        this.JBG9_VCODerecho.add(this.JCHBDerecho4);
        this.JCHBDerecho4.setName("5");
        this.JCHBDerecho4.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.94
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JCHBDerecho4ActionPerformed(evt);
            }
        });
        this.JBG9_VCODerecho.add(this.JCHBDerecho5);
        this.JCHBDerecho5.setName("6");
        this.JCHBDerecho5.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.95
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JCHBDerecho5ActionPerformed(evt);
            }
        });
        this.JBG9_VCODerecho.add(this.JCHBDerecho6);
        this.JCHBDerecho6.setName("7");
        this.JCHBDerecho6.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.96
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JCHBDerecho6ActionPerformed(evt);
            }
        });
        this.JBG9_VCODerecho.add(this.JCHBDerecho7);
        this.JCHBDerecho7.setName("8");
        this.JCHBDerecho7.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.97
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JCHBDerecho7ActionPerformed(evt);
            }
        });
        this.JBG9_VCODerecho.add(this.JCHBDerecho8);
        this.JCHBDerecho8.setName("9");
        this.JCHBDerecho8.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.98
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JCHBDerecho8ActionPerformed(evt);
            }
        });
        this.JBG9_VCODerecho.add(this.JCHBDerecho9);
        this.JCHBDerecho9.setName("10");
        this.JCHBDerecho9.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.99
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JCHBDerecho9ActionPerformed(evt);
            }
        });
        this.JBG9_VCODerecho.add(this.JCHBDerecho10);
        this.JCHBDerecho10.setName("11");
        this.JCHBDerecho10.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.100
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JCHBDerecho10ActionPerformed(evt);
            }
        });
        this.JBG9_VCODerecho.add(this.JCHBDerecho11);
        this.JCHBDerecho11.setName("12");
        this.JCHBDerecho11.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.101
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JCHBDerecho11ActionPerformed(evt);
            }
        });
        this.jLabel21.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Izquierda.png")));
        this.jLabel22.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Abajo.png")));
        this.jLabel29.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Izquierda.png")));
        this.jLabel30.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Derecha.png")));
        this.jLabel31.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Izquierda.png")));
        this.jLabel32.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Derecha.png")));
        this.jLabel33.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Abajo.png")));
        this.jLabel34.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Abajo.png")));
        this.jLabel35.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Arriba.png")));
        this.jLabel36.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Abajo.png")));
        this.jLabel37.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Derecha.png")));
        this.jLabel38.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Izquierda.png")));
        this.JLB9_VCDResultado.setFont(new Font("Arial", 1, 12));
        this.JLB9_VCDResultado.setForeground(new Color(255, 0, 0));
        this.JLB9_VCDResultado.setHorizontalAlignment(0);
        this.JLB9_VCDClasificacion.setFont(new Font("Arial", 1, 12));
        this.JLB9_VCDClasificacion.setForeground(new Color(255, 0, 0));
        this.JLB9_VCDClasificacion.setHorizontalAlignment(0);
        this.jLabel75.setFont(new Font("Arial", 1, 12));
        this.jLabel75.setForeground(Color.blue);
        this.jLabel75.setText("X");
        this.JCHBFallidoOjoDerechoCercana.setName("13");
        this.JCHBFallidoOjoDerechoCercana.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.102
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JCHBFallidoOjoDerechoCercanaActionPerformed(evt);
            }
        });
        GroupLayout JPI9_VCDerechoLayout = new GroupLayout(this.JPI9_VCDerecho);
        this.JPI9_VCDerecho.setLayout(JPI9_VCDerechoLayout);
        JPI9_VCDerechoLayout.setHorizontalGroup(JPI9_VCDerechoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI9_VCDerechoLayout.createSequentialGroup().addContainerGap().addComponent(this.jLabel7).addGroup(JPI9_VCDerechoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPI9_VCDerechoLayout.createSequentialGroup().addGap(35, 35, 35).addComponent(this.JCHBDerecho).addGap(12, 12, 12).addComponent(this.JCHBDerecho1)).addGroup(JPI9_VCDerechoLayout.createSequentialGroup().addGap(36, 36, 36).addComponent(this.jLabel21).addGap(15, 15, 15).addComponent(this.jLabel22))).addGap(18, 18, 18).addGroup(JPI9_VCDerechoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPI9_VCDerechoLayout.createSequentialGroup().addComponent(this.JCHBDerecho3).addGap(18, 18, 18).addComponent(this.JCHBDerecho2).addGap(20, 20, 20).addComponent(this.JCHBDerecho4)).addGroup(JPI9_VCDerechoLayout.createSequentialGroup().addComponent(this.jLabel29).addGap(23, 23, 23).addComponent(this.jLabel30).addGap(24, 24, 24).addComponent(this.jLabel31))).addGap(18, 18, 18).addGroup(JPI9_VCDerechoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPI9_VCDerechoLayout.createSequentialGroup().addComponent(this.jLabel32).addGap(27, 27, 27).addComponent(this.jLabel33)).addGroup(JPI9_VCDerechoLayout.createSequentialGroup().addComponent(this.JCHBDerecho5).addGap(21, 21, 21).addComponent(this.JCHBDerecho6))).addGroup(JPI9_VCDerechoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI9_VCDerechoLayout.createSequentialGroup().addGap(24, 24, 24).addComponent(this.JCHBDerecho7).addGap(21, 21, 21).addComponent(this.JCHBDerecho8)).addGroup(JPI9_VCDerechoLayout.createSequentialGroup().addGap(28, 28, 28).addComponent(this.jLabel34).addGap(30, 30, 30).addComponent(this.jLabel35))).addGroup(JPI9_VCDerechoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI9_VCDerechoLayout.createSequentialGroup().addGap(24, 24, 24).addComponent(this.JCHBDerecho9)).addGroup(JPI9_VCDerechoLayout.createSequentialGroup().addGap(26, 26, 26).addComponent(this.jLabel36))).addGap(23, 23, 23).addGroup(JPI9_VCDerechoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPI9_VCDerechoLayout.createSequentialGroup().addComponent(this.JCHBDerecho10).addGap(22, 22, 22).addComponent(this.JCHBDerecho11)).addGroup(JPI9_VCDerechoLayout.createSequentialGroup().addComponent(this.jLabel37).addGap(24, 24, 24).addComponent(this.jLabel38))).addGroup(JPI9_VCDerechoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI9_VCDerechoLayout.createSequentialGroup().addGap(20, 20, 20).addComponent(this.jLabel75)).addGroup(JPI9_VCDerechoLayout.createSequentialGroup().addGap(18, 18, 18).addComponent(this.JCHBFallidoOjoDerechoCercana))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLB9_VCDResultado, -2, 55, -2).addGap(5, 5, 5).addComponent(this.JLB9_VCDClasificacion, -2, 114, -2).addContainerGap(-1, 32767)));
        JPI9_VCDerechoLayout.setVerticalGroup(JPI9_VCDerechoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI9_VCDerechoLayout.createSequentialGroup().addGroup(JPI9_VCDerechoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI9_VCDerechoLayout.createSequentialGroup().addGroup(JPI9_VCDerechoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI9_VCDerechoLayout.createSequentialGroup().addContainerGap().addComponent(this.jLabel7)).addGroup(JPI9_VCDerechoLayout.createSequentialGroup().addGroup(JPI9_VCDerechoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel32).addComponent(this.jLabel33, GroupLayout.Alignment.TRAILING).addComponent(this.jLabel34).addComponent(this.jLabel35).addComponent(this.jLabel36).addComponent(this.jLabel37).addComponent(this.jLabel38)).addGroup(JPI9_VCDerechoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI9_VCDerechoLayout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPI9_VCDerechoLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JCHBDerecho6).addComponent(this.JCHBDerecho7).addComponent(this.JCHBDerecho8).addComponent(this.JCHBDerecho9).addComponent(this.JCHBDerecho10).addComponent(this.JCHBDerecho11))).addGroup(JPI9_VCDerechoLayout.createSequentialGroup().addGap(2, 2, 2).addComponent(this.JCHBDerecho5)))).addGroup(JPI9_VCDerechoLayout.createSequentialGroup().addGroup(JPI9_VCDerechoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel22).addComponent(this.jLabel21).addComponent(this.jLabel29).addComponent(this.jLabel30).addComponent(this.jLabel31)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPI9_VCDerechoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHBDerecho).addComponent(this.JCHBDerecho1).addComponent(this.JCHBDerecho3).addComponent(this.JCHBDerecho2).addComponent(this.JCHBDerecho4))).addComponent(this.JLB9_VCDResultado, -2, 41, -2).addComponent(this.JLB9_VCDClasificacion, -2, 41, -2)).addGap(0, 0, 32767)).addGroup(JPI9_VCDerechoLayout.createSequentialGroup().addComponent(this.jLabel75).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JCHBFallidoOjoDerechoCercana))).addContainerGap()));
        this.JPI10_VCIzquierdo.setBorder(BorderFactory.createEtchedBorder());
        this.jLabel8.setFont(new Font("Arial", 1, 12));
        this.jLabel8.setForeground(Color.blue);
        this.jLabel8.setText("10. Izquierdo");
        this.JBG10_VCOIzquierdo.add(this.JCHBIzquierdo);
        this.JCHBIzquierdo.setName("1");
        this.JCHBIzquierdo.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.103
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JCHBIzquierdoActionPerformed(evt);
            }
        });
        this.JBG10_VCOIzquierdo.add(this.JCHBIzquierdo1);
        this.JCHBIzquierdo1.setName("2");
        this.JCHBIzquierdo1.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.104
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JCHBIzquierdo1ActionPerformed(evt);
            }
        });
        this.JBG10_VCOIzquierdo.add(this.JCHBIzquierdo2);
        this.JCHBIzquierdo2.setName("3");
        this.JCHBIzquierdo2.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.105
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JCHBIzquierdo2ActionPerformed(evt);
            }
        });
        this.JBG10_VCOIzquierdo.add(this.JCHBIzquierdo3);
        this.JCHBIzquierdo3.setName("4");
        this.JCHBIzquierdo3.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.106
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JCHBIzquierdo3ActionPerformed(evt);
            }
        });
        this.JBG10_VCOIzquierdo.add(this.JCHBIzquierdo4);
        this.JCHBIzquierdo4.setName("5");
        this.JCHBIzquierdo4.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.107
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JCHBIzquierdo4ActionPerformed(evt);
            }
        });
        this.JBG10_VCOIzquierdo.add(this.JCHBIzquierdo5);
        this.JCHBIzquierdo5.setName("6");
        this.JCHBIzquierdo5.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.108
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JCHBIzquierdo5ActionPerformed(evt);
            }
        });
        this.JBG10_VCOIzquierdo.add(this.JCHBIzquierdo6);
        this.JCHBIzquierdo6.setName("7");
        this.JCHBIzquierdo6.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.109
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JCHBIzquierdo6ActionPerformed(evt);
            }
        });
        this.JBG10_VCOIzquierdo.add(this.JCHBIzquierdo7);
        this.JCHBIzquierdo7.setName("8");
        this.JCHBIzquierdo7.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.110
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JCHBIzquierdo7ActionPerformed(evt);
            }
        });
        this.JBG10_VCOIzquierdo.add(this.JCHBIzquierdo8);
        this.JCHBIzquierdo8.setName("9");
        this.JCHBIzquierdo8.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.111
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JCHBIzquierdo8ActionPerformed(evt);
            }
        });
        this.JBG10_VCOIzquierdo.add(this.JCHBIzquierdo9);
        this.JCHBIzquierdo9.setName("10");
        this.JCHBIzquierdo9.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.112
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JCHBIzquierdo9ActionPerformed(evt);
            }
        });
        this.JBG10_VCOIzquierdo.add(this.JCHBIzquierdo10);
        this.JCHBIzquierdo10.setName("11");
        this.JCHBIzquierdo10.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.113
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JCHBIzquierdo10ActionPerformed(evt);
            }
        });
        this.JBG10_VCOIzquierdo.add(this.JCHBIzquierdo11);
        this.JCHBIzquierdo11.setName("12");
        this.JCHBIzquierdo11.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.114
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JCHBIzquierdo11ActionPerformed(evt);
            }
        });
        this.jLabel39.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Abajo.png")));
        this.jLabel40.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Izquierda.png")));
        this.jLabel41.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Abajo.png")));
        this.jLabel45.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Abajo.png")));
        this.jLabel46.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Izquierda.png")));
        this.jLabel47.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Derecha.png")));
        this.jLabel56.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Derecha.png")));
        this.jLabel58.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Derecha.png")));
        this.jLabel59.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Arriba.png")));
        this.jLabel60.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Abajo.png")));
        this.jLabel61.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Izquierda.png")));
        this.jLabel57.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Arriba.png")));
        this.JLB10_VCResultado.setFont(new Font("Arial", 1, 12));
        this.JLB10_VCResultado.setForeground(new Color(255, 0, 0));
        this.JLB10_VCResultado.setHorizontalAlignment(0);
        this.JLB10_VCClasificacion.setFont(new Font("Arial", 1, 12));
        this.JLB10_VCClasificacion.setForeground(new Color(255, 0, 0));
        this.JLB10_VCClasificacion.setHorizontalAlignment(0);
        this.jLabel76.setFont(new Font("Arial", 1, 12));
        this.jLabel76.setForeground(Color.blue);
        this.jLabel76.setText("X");
        this.JCHBFallidoOjoIzqCercana.setName("13");
        this.JCHBFallidoOjoIzqCercana.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.115
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JCHBFallidoOjoIzqCercanaActionPerformed(evt);
            }
        });
        GroupLayout JPI10_VCIzquierdoLayout = new GroupLayout(this.JPI10_VCIzquierdo);
        this.JPI10_VCIzquierdo.setLayout(JPI10_VCIzquierdoLayout);
        JPI10_VCIzquierdoLayout.setHorizontalGroup(JPI10_VCIzquierdoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI10_VCIzquierdoLayout.createSequentialGroup().addContainerGap().addComponent(this.jLabel8).addGroup(JPI10_VCIzquierdoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI10_VCIzquierdoLayout.createSequentialGroup().addGap(26, 26, 26).addComponent(this.JCHBIzquierdo)).addGroup(JPI10_VCIzquierdoLayout.createSequentialGroup().addGap(30, 30, 30).addComponent(this.jLabel39))).addGroup(JPI10_VCIzquierdoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI10_VCIzquierdoLayout.createSequentialGroup().addGap(15, 15, 15).addComponent(this.jLabel40)).addGroup(JPI10_VCIzquierdoLayout.createSequentialGroup().addGap(12, 12, 12).addComponent(this.JCHBIzquierdo1))).addGroup(JPI10_VCIzquierdoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI10_VCIzquierdoLayout.createSequentialGroup().addGap(18, 18, 18).addComponent(this.JCHBIzquierdo2).addGap(18, 18, 18).addComponent(this.JCHBIzquierdo3)).addGroup(JPI10_VCIzquierdoLayout.createSequentialGroup().addGap(21, 21, 21).addComponent(this.jLabel41).addGap(27, 27, 27).addComponent(this.jLabel45))).addGap(21, 21, 21).addGroup(JPI10_VCIzquierdoLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JCHBIzquierdo4).addComponent(this.jLabel46)).addGap(18, 18, 18).addGroup(JPI10_VCIzquierdoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPI10_VCIzquierdoLayout.createSequentialGroup().addComponent(this.JCHBIzquierdo5).addGap(21, 21, 21).addComponent(this.JCHBIzquierdo6)).addGroup(JPI10_VCIzquierdoLayout.createSequentialGroup().addComponent(this.jLabel47).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.jLabel56))).addGap(24, 24, 24).addGroup(JPI10_VCIzquierdoLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPI10_VCIzquierdoLayout.createSequentialGroup().addComponent(this.JCHBIzquierdo7).addGap(20, 20, 20).addComponent(this.JCHBIzquierdo8)).addGroup(JPI10_VCIzquierdoLayout.createSequentialGroup().addComponent(this.jLabel57).addGap(25, 25, 25).addComponent(this.jLabel58))).addGroup(JPI10_VCIzquierdoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI10_VCIzquierdoLayout.createSequentialGroup().addGap(29, 29, 29).addComponent(this.jLabel59)).addGroup(JPI10_VCIzquierdoLayout.createSequentialGroup().addGap(24, 24, 24).addComponent(this.JCHBIzquierdo9))).addGroup(JPI10_VCIzquierdoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI10_VCIzquierdoLayout.createSequentialGroup().addGap(27, 27, 27).addComponent(this.jLabel60)).addGroup(JPI10_VCIzquierdoLayout.createSequentialGroup().addGap(24, 24, 24).addComponent(this.JCHBIzquierdo10))).addGap(22, 22, 22).addGroup(JPI10_VCIzquierdoLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JCHBIzquierdo11).addComponent(this.jLabel61)).addGap(20, 20, 20).addGroup(JPI10_VCIzquierdoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHBFallidoOjoIzqCercana).addComponent(this.jLabel76)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JLB10_VCResultado, -2, 55, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLB10_VCClasificacion, -2, 111, -2).addContainerGap()));
        JPI10_VCIzquierdoLayout.setVerticalGroup(JPI10_VCIzquierdoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPI10_VCIzquierdoLayout.createSequentialGroup().addGroup(JPI10_VCIzquierdoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel40).addGroup(GroupLayout.Alignment.TRAILING, JPI10_VCIzquierdoLayout.createSequentialGroup().addGap(3, 3, 3).addGroup(JPI10_VCIzquierdoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel46).addGroup(JPI10_VCIzquierdoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel39, GroupLayout.Alignment.TRAILING).addComponent(this.jLabel45, GroupLayout.Alignment.TRAILING)).addComponent(this.jLabel47).addComponent(this.jLabel56).addComponent(this.jLabel58).addComponent(this.jLabel59).addComponent(this.jLabel60).addComponent(this.jLabel61).addComponent(this.jLabel41).addComponent(this.jLabel57).addComponent(this.jLabel76)))).addGroup(JPI10_VCIzquierdoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHBFallidoOjoIzqCercana).addGroup(JPI10_VCIzquierdoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHBIzquierdo1, GroupLayout.Alignment.TRAILING).addComponent(this.JCHBIzquierdo, GroupLayout.Alignment.TRAILING).addGroup(GroupLayout.Alignment.TRAILING, JPI10_VCIzquierdoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHBIzquierdo9).addComponent(this.JCHBIzquierdo10).addComponent(this.JCHBIzquierdo11).addComponent(this.JCHBIzquierdo8).addComponent(this.JCHBIzquierdo7).addComponent(this.JCHBIzquierdo6).addComponent(this.JCHBIzquierdo5).addComponent(this.JCHBIzquierdo4).addComponent(this.JCHBIzquierdo3).addComponent(this.JCHBIzquierdo2)))).addContainerGap()).addGroup(JPI10_VCIzquierdoLayout.createSequentialGroup().addGroup(JPI10_VCIzquierdoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI10_VCIzquierdoLayout.createSequentialGroup().addContainerGap().addComponent(this.jLabel8)).addComponent(this.JLB10_VCResultado, -2, 41, -2).addComponent(this.JLB10_VCClasificacion, -2, 41, -2)).addGap(0, 0, 32767)));
        this.JPI11_VCFLateral.setBorder(BorderFactory.createEtchedBorder());
        this.jLabel28.setFont(new Font("Arial", 1, 12));
        this.jLabel28.setForeground(Color.blue);
        this.jLabel28.setText("11. Foria Lateral");
        this.JCHBVCLateral.setName("1");
        this.JCHBVCLateral.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.116
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JCHBVCLateralActionPerformed(evt);
            }
        });
        this.JCHBVCLateral2.setName("2");
        this.JCHBVCLateral2.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.117
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JCHBVCLateral2ActionPerformed(evt);
            }
        });
        this.JCHBVCLateral3.setName("3");
        this.JCHBVCLateral3.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.118
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JCHBVCLateral3ActionPerformed(evt);
            }
        });
        this.JCHBVCLateral4.setName("4");
        this.JCHBVCLateral4.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.119
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JCHBVCLateral4ActionPerformed(evt);
            }
        });
        this.JCHBVCLateral5.setName("5");
        this.JCHBVCLateral5.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.120
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JCHBVCLateral5ActionPerformed(evt);
            }
        });
        this.JCHBVCLateral6.setName("6");
        this.JCHBVCLateral6.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.121
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JCHBVCLateral6ActionPerformed(evt);
            }
        });
        this.JCHBVCLateral7.setName("7");
        this.JCHBVCLateral7.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.122
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JCHBVCLateral7ActionPerformed(evt);
            }
        });
        this.JCHBVCLateral8.setName("8");
        this.JCHBVCLateral8.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.123
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JCHBVCLateral8ActionPerformed(evt);
            }
        });
        this.JCHBVCLateral9.setName("9");
        this.JCHBVCLateral9.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.124
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JCHBVCLateral9ActionPerformed(evt);
            }
        });
        this.JCHBVCLateral10.setName("10");
        this.JCHBVCLateral10.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.125
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JCHBVCLateral10ActionPerformed(evt);
            }
        });
        this.JCHBVCLateral11.setName("11");
        this.JCHBVCLateral11.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.126
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JCHBVCLateral11ActionPerformed(evt);
            }
        });
        this.JCHBVCLateral12.setName("12");
        this.JCHBVCLateral12.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.127
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JCHBVCLateral12ActionPerformed(evt);
            }
        });
        this.JCHBVCLateral13.setName("13");
        this.JCHBVCLateral13.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.128
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JCHBVCLateral13ActionPerformed(evt);
            }
        });
        this.JCHBVCLateral14.setName("14");
        this.JCHBVCLateral14.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.129
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JCHBVCLateral14ActionPerformed(evt);
            }
        });
        this.JCHBVCLateral15.setName("15");
        this.JCHBVCLateral15.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.130
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JCHBVCLateral15ActionPerformed(evt);
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
        this.JPI12_VCFVertical.setBorder(BorderFactory.createEtchedBorder());
        this.jLabel27.setFont(new Font("Arial", 1, 12));
        this.jLabel27.setForeground(Color.blue);
        this.jLabel27.setText("12. Foria Vertical");
        this.JCHBVCFVertical.setName("1");
        this.JCHBVCFVertical.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.131
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JCHBVCFVerticalActionPerformed(evt);
            }
        });
        this.jLabel53.setFont(new Font("Arial", 1, 12));
        this.jLabel53.setForeground(new Color(0, 102, 0));
        this.jLabel53.setText("1");
        this.JCHBVCFVertical2.setName("2");
        this.JCHBVCFVertical2.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.132
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JCHBVCFVertical2ActionPerformed(evt);
            }
        });
        this.JCHBVCFVertical3.setName("3");
        this.JCHBVCFVertical3.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.133
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JCHBVCFVertical3ActionPerformed(evt);
            }
        });
        this.JCHBVCFVertical4.setName("4");
        this.JCHBVCFVertical4.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.134
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JCHBVCFVertical4ActionPerformed(evt);
            }
        });
        this.JCHBVCFVertical5.setName("5");
        this.JCHBVCFVertical5.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.135
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JCHBVCFVertical5ActionPerformed(evt);
            }
        });
        this.JCHBVCFVertical6.setName("6");
        this.JCHBVCFVertical6.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.136
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JCHBVCFVertical6ActionPerformed(evt);
            }
        });
        this.JCHBVCFVertical7.setName("7");
        this.JCHBVCFVertical7.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.137
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JCHBVCFVertical7ActionPerformed(evt);
            }
        });
        this.JCHBVCFVertical8.setName("8");
        this.JCHBVCFVertical8.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.138
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JCHBVCFVertical8ActionPerformed(evt);
            }
        });
        this.JCHBVCFVertical9.setName("9");
        this.JCHBVCFVertical9.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.139
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JCHBVCFVertical9ActionPerformed(evt);
            }
        });
        this.jLabel54.setFont(new Font("Arial", 1, 12));
        this.jLabel54.setForeground(new Color(0, 102, 0));
        this.jLabel54.setText("2           3          4           5            6           7                           8                        9");
        this.JLB12_VCFVeClasificacion.setFont(new Font("Arial", 1, 12));
        this.JLB12_VCFVeClasificacion.setForeground(new Color(255, 0, 0));
        GroupLayout JPI12_VCFVerticalLayout = new GroupLayout(this.JPI12_VCFVertical);
        this.JPI12_VCFVertical.setLayout(JPI12_VCFVerticalLayout);
        JPI12_VCFVerticalLayout.setHorizontalGroup(JPI12_VCFVerticalLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI12_VCFVerticalLayout.createSequentialGroup().addContainerGap().addComponent(this.jLabel27).addGap(39, 39, 39).addGroup(JPI12_VCFVerticalLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jLabel53, -2, 13, -2).addComponent(this.JCHBVCFVertical)).addGap(59, 59, 59).addGroup(JPI12_VCFVerticalLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPI12_VCFVerticalLayout.createSequentialGroup().addComponent(this.JCHBVCFVertical2).addGap(18, 18, 18).addComponent(this.JCHBVCFVertical3).addGap(18, 18, 18).addComponent(this.JCHBVCFVertical4).addGap(21, 21, 21).addComponent(this.JCHBVCFVertical5).addGap(24, 24, 24).addComponent(this.JCHBVCFVertical6).addGap(18, 18, 18).addComponent(this.JCHBVCFVertical7).addGap(66, 66, 66).addComponent(this.JCHBVCFVertical8).addGap(58, 58, 58).addComponent(this.JCHBVCFVertical9)).addComponent(this.jLabel54, GroupLayout.Alignment.TRAILING, -2, 382, -2)).addGap(48, 48, 48).addComponent(this.JLB12_VCFVeClasificacion, -1, -1, 32767).addContainerGap()));
        JPI12_VCFVerticalLayout.setVerticalGroup(JPI12_VCFVerticalLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI12_VCFVerticalLayout.createSequentialGroup().addContainerGap().addComponent(this.jLabel27).addContainerGap(-1, 32767)).addGroup(JPI12_VCFVerticalLayout.createSequentialGroup().addGroup(JPI12_VCFVerticalLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI12_VCFVerticalLayout.createSequentialGroup().addGroup(JPI12_VCFVerticalLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel53).addComponent(this.jLabel54, GroupLayout.Alignment.TRAILING)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPI12_VCFVerticalLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHBVCFVertical3, GroupLayout.Alignment.TRAILING).addComponent(this.JCHBVCFVertical4, GroupLayout.Alignment.TRAILING).addComponent(this.JCHBVCFVertical5, GroupLayout.Alignment.TRAILING).addComponent(this.JCHBVCFVertical6, GroupLayout.Alignment.TRAILING).addComponent(this.JCHBVCFVertical7, GroupLayout.Alignment.TRAILING).addComponent(this.JCHBVCFVertical8, GroupLayout.Alignment.TRAILING).addComponent(this.JCHBVCFVertical9, GroupLayout.Alignment.TRAILING).addComponent(this.JCHBVCFVertical).addComponent(this.JCHBVCFVertical2))).addComponent(this.JLB12_VCFVeClasificacion, -2, 41, -2)).addGap(0, 0, 32767)));
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
        JPINumeros1Layout.setHorizontalGroup(JPINumeros1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPINumeros1Layout.createSequentialGroup().addGap(31, 31, 31).addComponent(this.JLB13).addGap(27, 27, 27).addComponent(this.JLB14).addGap(33, 33, 33).addComponent(this.JLB15).addGap(33, 33, 33).addComponent(this.JLB16).addGap(33, 33, 33).addComponent(this.JLB17).addGap(34, 34, 34).addComponent(this.JLB18).addGap(33, 33, 33).addComponent(this.JLB19).addGap(34, 34, 34).addComponent(this.JLB20).addGap(33, 33, 33).addComponent(this.JLB21).addGap(33, 33, 33).addComponent(this.JLB22).addGap(33, 33, 33).addComponent(this.JLB23).addGap(32, 32, 32).addComponent(this.JLB24, -1, -1, 32767).addContainerGap()));
        JPINumeros1Layout.setVerticalGroup(JPINumeros1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPINumeros1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JLB13).addComponent(this.JLB14).addComponent(this.JLB15).addComponent(this.JLB16).addComponent(this.JLB17).addComponent(this.JLB18).addComponent(this.JLB19).addComponent(this.JLB20).addComponent(this.JLB21).addComponent(this.JLB22).addComponent(this.JLB23).addComponent(this.JLB24)));
        this.JPIDatosGenerales.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN GENERAL", 0, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JCHDGLentesC.setFont(new Font("Arial", 1, 12));
        this.JCHDGLentesC.setText("Lentes de Contacto?");
        this.JCHDGLentesC.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.140
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JCHDGLentesCActionPerformed(evt);
            }
        });
        this.JCHDGSLentesF.setFont(new Font("Arial", 1, 12));
        this.JCHDGSLentesF.setText("Se realiza con lentes formulados?");
        this.JCHDGSLentesF.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.141
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JCHDGSLentesFActionPerformed(evt);
            }
        });
        this.JPITipoGafas.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de gafas", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JBGTGafas.add(this.JRBDGTGNinguna);
        this.JRBDGTGNinguna.setFont(new Font("Arial", 1, 12));
        this.JRBDGTGNinguna.setSelected(true);
        this.JRBDGTGNinguna.setText("Ninguna");
        this.JRBDGTGNinguna.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.142
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JRBDGTGNingunaActionPerformed(evt);
            }
        });
        this.JBGTGafas.add(this.JRBDGTGPersonal);
        this.JRBDGTGPersonal.setFont(new Font("Arial", 1, 12));
        this.JRBDGTGPersonal.setText("Personal");
        this.JRBDGTGPersonal.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.143
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JRBDGTGPersonalActionPerformed(evt);
            }
        });
        this.JBGTGafas.add(this.JRBDGTGSeguridad);
        this.JRBDGTGSeguridad.setFont(new Font("Arial", 1, 12));
        this.JRBDGTGSeguridad.setText("Seguridad");
        this.JRBDGTGSeguridad.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.144
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JRBDGTGSeguridadActionPerformed(evt);
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
        this.JRBDGTLNinguno.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.145
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JRBDGTLNingunoActionPerformed(evt);
            }
        });
        this.JBGTLentes.add(this.JRBDGTLProgresivo);
        this.JRBDGTLProgresivo.setFont(new Font("Arial", 1, 12));
        this.JRBDGTLProgresivo.setText("Progresivo");
        this.JRBDGTLProgresivo.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.146
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JRBDGTLProgresivoActionPerformed(evt);
            }
        });
        this.JBGTLentes.add(this.JRBDGTLBifocales);
        this.JRBDGTLBifocales.setFont(new Font("Arial", 1, 12));
        this.JRBDGTLBifocales.setText("Bifocales");
        this.JRBDGTLBifocales.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.147
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JRBDGTLBifocalesActionPerformed(evt);
            }
        });
        this.JBGTLentes.add(this.JRBDGTLMonofocales);
        this.JRBDGTLMonofocales.setFont(new Font("Arial", 1, 12));
        this.JRBDGTLMonofocales.setText("Monofocales");
        this.JRBDGTLMonofocales.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.148
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JRBDGTLMonofocalesActionPerformed(evt);
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
        this.JRBDGTCNinguna.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.149
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JRBDGTCNingunaActionPerformed(evt);
            }
        });
        this.JBGTCorreccion.add(this.JRBDGTCPermanente);
        this.JRBDGTCPermanente.setFont(new Font("Arial", 1, 12));
        this.JRBDGTCPermanente.setText("Permanente");
        this.JRBDGTCPermanente.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.150
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JRBDGTCPermanenteActionPerformed(evt);
            }
        });
        this.JBGTCorreccion.add(this.JRBDGTCEsporadico);
        this.JRBDGTCEsporadico.setFont(new Font("Arial", 1, 12));
        this.JRBDGTCEsporadico.setText("Esporádica");
        this.JRBDGTCEsporadico.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.151
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JRBDGTCEsporadicoActionPerformed(evt);
            }
        });
        GroupLayout JPIUsoCorrecionLayout = new GroupLayout(this.JPIUsoCorrecion);
        this.JPIUsoCorrecion.setLayout(JPIUsoCorrecionLayout);
        JPIUsoCorrecionLayout.setHorizontalGroup(JPIUsoCorrecionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIUsoCorrecionLayout.createSequentialGroup().addContainerGap().addComponent(this.JRBDGTCNinguna).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBDGTCPermanente).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBDGTCEsporadico, -2, 99, -2).addContainerGap(-1, 32767)));
        JPIUsoCorrecionLayout.setVerticalGroup(JPIUsoCorrecionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIUsoCorrecionLayout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(JPIUsoCorrecionLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBDGTCPermanente).addComponent(this.JRBDGTCEsporadico).addComponent(this.JRBDGTCNinguna)).addContainerGap()));
        this.JPITCorrecion.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Corrección", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JCHTCLejos.setFont(new Font("Arial", 1, 12));
        this.JCHTCLejos.setText("Lejos");
        this.JCHTCLejos.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.152
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JCHTCLejosActionPerformed(evt);
            }
        });
        this.JCHTCCerca.setFont(new Font("Arial", 1, 12));
        this.JCHTCCerca.setText("Cerca");
        this.JCHTCCerca.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.153
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JCHTCCercaActionPerformed(evt);
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
        JLB12_VCFVClasificacionLayout.setHorizontalGroup(JLB12_VCFVClasificacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JLB12_VCFVClasificacionLayout.createSequentialGroup().addGroup(JLB12_VCFVClasificacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPI11_VCFLateral, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addComponent(this.JPI12_VCFVertical, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addGroup(JLB12_VCFVClasificacionLayout.createSequentialGroup().addGroup(JLB12_VCFVClasificacionLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JPI10_VCIzquierdo, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JPI9_VCDerecho, GroupLayout.Alignment.LEADING, -1, -1, 32767).addGroup(GroupLayout.Alignment.LEADING, JLB12_VCFVClasificacionLayout.createSequentialGroup().addGap(84, 84, 84).addComponent(this.JPINumeros1, -2, -1, -2)).addComponent(this.JPI8_VCAOjos, GroupLayout.Alignment.LEADING, -1, 899, 32767)).addGap(0, 0, 32767))).addContainerGap()).addGroup(JLB12_VCFVClasificacionLayout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatosGenerales, -2, -1, -2).addContainerGap(-1, 32767)));
        JLB12_VCFVClasificacionLayout.setVerticalGroup(JLB12_VCFVClasificacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JLB12_VCFVClasificacionLayout.createSequentialGroup().addGap(7, 7, 7).addComponent(this.JPINumeros1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPI8_VCAOjos, -2, 46, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JPI9_VCDerecho, -2, 45, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPI10_VCIzquierdo, -2, 52, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPI11_VCFLateral, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPI12_VCFVertical, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JPIDatosGenerales, -2, 160, -2).addContainerGap(-1, 32767)));
        this.JTPDatosTest.addTab("VISIÓN CERCANA", this.JLB12_VCFVClasificacion);
        this.JSPHistorico.setBorder(BorderFactory.createTitledBorder((Border) null, "", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTDetalleHistorico.setFont(new Font("Arial", 1, 12));
        this.JTDetalleHistorico.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalleHistorico.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalleHistorico.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalleHistorico.addMouseListener(new MouseAdapter() { // from class: Historia.JPSo_VisiometriaG.154
            public void mouseClicked(MouseEvent evt) {
                JPSo_VisiometriaG.this.JTDetalleHistoricoMouseClicked(evt);
            }
        });
        this.JSPHistorico.setViewportView(this.JTDetalleHistorico);
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.JSPHistorico, -1, 831, 32767).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.JSPHistorico, -2, 289, -2).addContainerGap(182, 32767)));
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
        this.JBGuardarInter.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.155
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JBGuardarInterActionPerformed(evt);
            }
        });
        GroupLayout JPInterpretacionLayout = new GroupLayout(this.JPInterpretacion);
        this.JPInterpretacion.setLayout(JPInterpretacionLayout);
        JPInterpretacionLayout.setHorizontalGroup(JPInterpretacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPInterpretacionLayout.createSequentialGroup().addContainerGap().addGroup(JPInterpretacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPInterpretacionLayout.createSequentialGroup().addComponent(this.JCBResultado, -2, 434, -2).addContainerGap(10, 32767)).addGroup(JPInterpretacionLayout.createSequentialGroup().addGroup(JPInterpretacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane3, -2, 434, -2).addComponent(this.JBGuardarInter, -2, 434, -2)).addGap(0, 0, 32767)))));
        JPInterpretacionLayout.setVerticalGroup(JPInterpretacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPInterpretacionLayout.createSequentialGroup().addComponent(this.JCBResultado, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane3, -2, 71, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBGuardarInter).addGap(24, 24, 24)));
        this.JBTGrabar.setFont(new Font("Arial", 1, 12));
        this.JBTGrabar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTGrabar.setText("Grabar");
        this.JBTGrabar.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.156
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JBTGrabarActionPerformed(evt);
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
        this.JBTActualizar.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaG.157
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaG.this.JBTActualizarActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(23, 23, 23).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JTPDatosTest, -2, 845, -2).addContainerGap(-1, 32767)).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JBTGrabar, -1, -1, 32767).addComponent(this.jScrollPane4).addComponent(this.JBTActualizar, GroupLayout.Alignment.TRAILING, -1, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPInterpretacion, -2, -1, -2).addGap(19, 19, 19)))));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JTPDatosTest, -2, 504, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPInterpretacion, -1, -1, 32767).addGroup(layout.createSequentialGroup().addComponent(this.jScrollPane4, -2, 84, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTGrabar, -2, 45, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTActualizar, -2, 45, -2).addGap(0, 0, 32767)))));
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
    public void JCHBEs1ActionPerformed(ActionEvent evt) {
        this.x3e = Integer.parseInt(this.JCHBEs1.getName().toString());
        if (this.JCHBEs1.isSelected()) {
            this.xEst1 = 1;
            this.xestereopsis = 1;
        } else {
            this.xEst1 = 0;
            this.xestereopsis = -1;
        }
        mSumarVLN4(this.JCHBEs1);
        if (!Principal.informacionIps.getNombreIps().equals("IPS SU SALUD INTEGRAL S.A.S")) {
            this.JCHBEs1.setEnabled(false);
            this.JCHBEs2.setEnabled(true);
        }
        this.JLPercepcion.setText("30%");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBEs2ActionPerformed(ActionEvent evt) {
        this.x3e = Integer.parseInt(this.JCHBEs2.getName().toString());
        if (this.JCHBEs1.isSelected()) {
            this.xEst2 = 1;
            this.xestereopsis = 1;
        } else {
            this.xEst2 = 0;
            this.xestereopsis = -1;
        }
        mSumarVLN4(this.JCHBEs2);
        if (!Principal.informacionIps.getNombreIps().equals("IPS SU SALUD INTEGRAL S.A.S")) {
            this.JCHBEs2.setEnabled(false);
            this.JCHBEs3.setEnabled(true);
        }
        this.JLPercepcion.setText("50%");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBEs3ActionPerformed(ActionEvent evt) {
        this.x3e = Integer.parseInt(this.JCHBEs3.getName().toString());
        if (this.JCHBEs3.isSelected()) {
            this.xEst3 = 1;
            this.xestereopsis = 1;
        } else {
            this.xEst3 = 0;
            this.xestereopsis = -1;
        }
        mSumarVLN4(this.JCHBEs3);
        if (!Principal.informacionIps.getNombreIps().equals("IPS SU SALUD INTEGRAL S.A.S")) {
            this.JCHBEs3.setEnabled(false);
            this.JCHBEs4.setEnabled(true);
        }
        this.JLPercepcion.setText("60%");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBEs4ActionPerformed(ActionEvent evt) {
        this.x3e = Integer.parseInt(this.JCHBEs4.getName().toString());
        if (this.JCHBEs4.isSelected()) {
            this.xEst4 = 1;
            this.xestereopsis = 1;
        } else {
            this.xEst4 = 0;
            this.xestereopsis = -1;
        }
        mSumarVLN4(this.JCHBEs4);
        if (!Principal.informacionIps.getNombreIps().equals("IPS SU SALUD INTEGRAL S.A.S")) {
            this.JCHBEs4.setEnabled(false);
            this.JCHBEs5.setEnabled(true);
        }
        this.JLPercepcion.setText("70%");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBEs5ActionPerformed(ActionEvent evt) {
        this.x3e = Integer.parseInt(this.JCHBEs5.getName().toString());
        if (this.JCHBEs5.isSelected()) {
            this.xEst5 = 1;
            this.xestereopsis = 1;
        } else {
            this.xEst5 = 0;
            this.xestereopsis = -1;
        }
        mSumarVLN4(this.JCHBEs5);
        if (!Principal.informacionIps.getNombreIps().equals("IPS SU SALUD INTEGRAL S.A.S")) {
            this.JCHBEs5.setEnabled(false);
            this.JCHBEs6.setEnabled(true);
        }
        this.JLPercepcion.setText("80%");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBEs6ActionPerformed(ActionEvent evt) {
        this.x3e = Integer.parseInt(this.JCHBEs6.getName().toString());
        if (this.JCHBEs6.isSelected()) {
            this.xEst6 = 1;
            this.xestereopsis = 1;
        } else {
            this.xEst6 = 0;
            this.xestereopsis = -1;
        }
        mSumarVLN4(this.JCHBEs6);
        if (!Principal.informacionIps.getNombreIps().equals("IPS SU SALUD INTEGRAL S.A.S")) {
            this.JCHBEs6.setEnabled(false);
        }
        this.JLPercepcion.setText("90%");
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
        if (!Principal.informacionIps.getNombreIps().equals("IPS SU SALUD INTEGRAL S.A.S")) {
            this.JCHBC.setEnabled(false);
            this.JCHBC1.setEnabled(true);
        }
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
        if (!Principal.informacionIps.getNombreIps().equals("IPS SU SALUD INTEGRAL S.A.S")) {
            this.JCHBC1.setEnabled(false);
            this.JCHBC5.setEnabled(true);
        }
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
        if (!Principal.informacionIps.getNombreIps().equals("IPS SU SALUD INTEGRAL S.A.S")) {
            this.JCHBC5.setEnabled(false);
            this.JCHBC6.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBC6ActionPerformed(ActionEvent evt) {
        this.x5c = Integer.parseInt(this.JCHBC6.getName().toString());
        if (this.JCHBC5.isSelected()) {
            this.xcolor = 2;
            this.xColorD = 1;
        } else {
            this.xcolor = -2;
            this.xColorD = 0;
        }
        mSumarVLN5(this.JCHBC6);
        if (!Principal.informacionIps.getNombreIps().equals("IPS SU SALUD INTEGRAL S.A.S")) {
            this.JCHBC6.setEnabled(false);
            this.JCHBC7.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBAOjosActionPerformed(ActionEvent evt) {
        mEstablecerResultado(this.JCHBAOjos.getName(), this.JLB8_VCResultado, this.JLB8_VCRClasificacion);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBFVActionPerformed(ActionEvent evt) {
        this.x6fv = Integer.parseInt(this.JCHBFV.getName().toString());
        mSumarVLN6(this.JCHBFV, 1);
        if (!Principal.informacionIps.getNombreIps().equals("IPS SU SALUD INTEGRAL S.A.S")) {
            this.JCHBFV.setEnabled(false);
            this.JCHBFV1.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBFV1ActionPerformed(ActionEvent evt) {
        this.x6fv = Integer.parseInt(this.JCHBFV1.getName().toString());
        mSumarVLN6(this.JCHBFV1, 1);
        if (!Principal.informacionIps.getNombreIps().equals("IPS SU SALUD INTEGRAL S.A.S")) {
            this.JCHBFV1.setEnabled(false);
            this.JCHBFV2.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBFV2ActionPerformed(ActionEvent evt) {
        this.x6fv = Integer.parseInt(this.JCHBFV2.getName().toString());
        mSumarVLN6(this.JCHBFV2, 1);
        if (!Principal.informacionIps.getNombreIps().equals("IPS SU SALUD INTEGRAL S.A.S")) {
            this.JCHBFV2.setEnabled(false);
            this.JCHBFV3.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBFV3ActionPerformed(ActionEvent evt) {
        this.x6fv = Integer.parseInt(this.JCHBFV3.getName().toString());
        mSumarVLN6(this.JCHBFV3, 1);
        if (!Principal.informacionIps.getNombreIps().equals("IPS SU SALUD INTEGRAL S.A.S")) {
            this.JCHBFV3.setEnabled(false);
            this.JCHBFV4.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBFV4ActionPerformed(ActionEvent evt) {
        this.x6fv = Integer.parseInt(this.JCHBFV4.getName().toString());
        mSumarVLN6(this.JCHBFV4, 1);
        if (!Principal.informacionIps.getNombreIps().equals("IPS SU SALUD INTEGRAL S.A.S")) {
            this.JCHBFV4.setEnabled(false);
            this.JCHBFV5.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBFV5ActionPerformed(ActionEvent evt) {
        this.x6fv = Integer.parseInt(this.JCHBFV5.getName().toString());
        mSumarVLN6(this.JCHBFV5, 1);
        if (!Principal.informacionIps.getNombreIps().equals("IPS SU SALUD INTEGRAL S.A.S")) {
            this.JCHBFV5.setEnabled(false);
            this.JCHBFV6.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBFV6ActionPerformed(ActionEvent evt) {
        this.x6fv = Integer.parseInt(this.JCHBFV6.getName().toString());
        mSumarVLN6(this.JCHBFV6, 1);
        if (!Principal.informacionIps.getNombreIps().equals("IPS SU SALUD INTEGRAL S.A.S")) {
            this.JCHBFV6.setEnabled(false);
            this.JCHBFV7.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBFV7ActionPerformed(ActionEvent evt) {
        this.x6fv = Integer.parseInt(this.JCHBFV7.getName().toString());
        mSumarVLN6(this.JCHBFV7, 1);
        if (!Principal.informacionIps.getNombreIps().equals("IPS SU SALUD INTEGRAL S.A.S")) {
            this.JCHBFV7.setEnabled(false);
            this.JCHBFV8.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBFV8ActionPerformed(ActionEvent evt) {
        this.x6fv = Integer.parseInt(this.JCHBFV8.getName().toString());
        mSumarVLN6(this.JCHBFV8, 1);
        if (!Principal.informacionIps.getNombreIps().equals("IPS SU SALUD INTEGRAL S.A.S")) {
            this.JCHBFV8.setEnabled(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBFLaActionPerformed(ActionEvent evt) {
        this.x7fl = Integer.parseInt(this.JCHBFLa.getName().toString());
        mSumarVLN7(this.JCHBFLa);
        if (!Principal.informacionIps.getNombreIps().equals("IPS SU SALUD INTEGRAL S.A.S")) {
            this.JCHBFLa.setEnabled(false);
            this.JCHBFLa1.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBFLa1ActionPerformed(ActionEvent evt) {
        this.x7fl = Integer.parseInt(this.JCHBFLa1.getName().toString());
        mSumarVLN7(this.JCHBFLa1);
        if (!Principal.informacionIps.getNombreIps().equals("IPS SU SALUD INTEGRAL S.A.S")) {
            this.JCHBFLa1.setEnabled(false);
            this.JCHBFLa2.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBFLa2ActionPerformed(ActionEvent evt) {
        this.x7fl = Integer.parseInt(this.JCHBFLa2.getName().toString());
        mSumarVLN7(this.JCHBFLa2);
        if (!Principal.informacionIps.getNombreIps().equals("IPS SU SALUD INTEGRAL S.A.S")) {
            this.JCHBFLa2.setEnabled(false);
            this.JCHBFLa3.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBFLa3ActionPerformed(ActionEvent evt) {
        this.x7fl = Integer.parseInt(this.JCHBFLa3.getName().toString());
        mSumarVLN7(this.JCHBFLa3);
        if (!Principal.informacionIps.getNombreIps().equals("IPS SU SALUD INTEGRAL S.A.S")) {
            this.JCHBFLa3.setEnabled(false);
            this.JCHBFLa4.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBFLa4ActionPerformed(ActionEvent evt) {
        this.x7fl = Integer.parseInt(this.JCHBFLa4.getName().toString());
        mSumarVLN7(this.JCHBFLa4);
        if (!Principal.informacionIps.getNombreIps().equals("IPS SU SALUD INTEGRAL S.A.S")) {
            this.JCHBFLa4.setEnabled(false);
            this.JCHBFLa5.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBFLa5ActionPerformed(ActionEvent evt) {
        this.x7fl = Integer.parseInt(this.JCHBFLa5.getName().toString());
        mSumarVLN7(this.JCHBFLa5);
        if (!Principal.informacionIps.getNombreIps().equals("IPS SU SALUD INTEGRAL S.A.S")) {
            this.JCHBFLa5.setEnabled(false);
            this.JCHBFLa6.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBFLa6ActionPerformed(ActionEvent evt) {
        this.x7fl = Integer.parseInt(this.JCHBFLa6.getName().toString());
        mSumarVLN7(this.JCHBFLa6);
        if (!Principal.informacionIps.getNombreIps().equals("IPS SU SALUD INTEGRAL S.A.S")) {
            this.JCHBFLa6.setEnabled(false);
            this.JCHBFLa7.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBFLa7ActionPerformed(ActionEvent evt) {
        this.x7fl = Integer.parseInt(this.JCHBFLa7.getName().toString());
        mSumarVLN7(this.JCHBFLa7);
        if (!Principal.informacionIps.getNombreIps().equals("IPS SU SALUD INTEGRAL S.A.S")) {
            this.JCHBFLa7.setEnabled(false);
            this.JCHBFLa8.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBFLa8ActionPerformed(ActionEvent evt) {
        this.x7fl = Integer.parseInt(this.JCHBFLa8.getName().toString());
        mSumarVLN7(this.JCHBFLa8);
        if (!Principal.informacionIps.getNombreIps().equals("IPS SU SALUD INTEGRAL S.A.S")) {
            this.JCHBFLa8.setEnabled(false);
            this.JCHBFLa9.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBFLa9ActionPerformed(ActionEvent evt) {
        this.x7fl = Integer.parseInt(this.JCHBFLa9.getName().toString());
        mSumarVLN7(this.JCHBFLa9);
        if (!Principal.informacionIps.getNombreIps().equals("IPS SU SALUD INTEGRAL S.A.S")) {
            this.JCHBFLa9.setEnabled(false);
            this.JCHBFLa10.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBFLa10ActionPerformed(ActionEvent evt) {
        this.x7fl = Integer.parseInt(this.JCHBFLa10.getName().toString());
        mSumarVLN7(this.JCHBFLa10);
        if (!Principal.informacionIps.getNombreIps().equals("IPS SU SALUD INTEGRAL S.A.S")) {
            this.JCHBFLa10.setEnabled(false);
            this.JCHBFLa11.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBFLa11ActionPerformed(ActionEvent evt) {
        this.x7fl = Integer.parseInt(this.JCHBFLa11.getName().toString());
        mSumarVLN7(this.JCHBFLa11);
        if (!Principal.informacionIps.getNombreIps().equals("IPS SU SALUD INTEGRAL S.A.S")) {
            this.JCHBFLa11.setEnabled(false);
            this.JCHBFLa12.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBFLa12ActionPerformed(ActionEvent evt) {
        this.x7fl = Integer.parseInt(this.JCHBFLa12.getName().toString());
        mSumarVLN7(this.JCHBFLa12);
        if (!Principal.informacionIps.getNombreIps().equals("IPS SU SALUD INTEGRAL S.A.S")) {
            this.JCHBFLa12.setEnabled(false);
            this.JCHBFLa13.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBFLa13ActionPerformed(ActionEvent evt) {
        this.x7fl = Integer.parseInt(this.JCHBFLa13.getName().toString());
        mSumarVLN7(this.JCHBFLa13);
        if (!Principal.informacionIps.getNombreIps().equals("IPS SU SALUD INTEGRAL S.A.S")) {
            this.JCHBFLa13.setEnabled(false);
            this.JCHBFLa14.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBFLa14ActionPerformed(ActionEvent evt) {
        this.x7fl = Integer.parseInt(this.JCHBFLa14.getName().toString());
        mSumarVLN7(this.JCHBFLa14);
        if (!Principal.informacionIps.getNombreIps().equals("IPS SU SALUD INTEGRAL S.A.S")) {
            this.JCHBFLa14.setEnabled(false);
        }
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
        mSumarVCN11(this.JCHBVCLateral);
        if (!Principal.informacionIps.getNombreIps().equals("IPS SU SALUD INTEGRAL S.A.S")) {
            this.JCHBVCLateral.setEnabled(false);
            this.JCHBVCLateral2.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBVCLateral2ActionPerformed(ActionEvent evt) {
        this.x11fl = Integer.parseInt(this.JCHBVCLateral2.getName().toString());
        mSumarVCN11(this.JCHBVCLateral2);
        if (!Principal.informacionIps.getNombreIps().equals("IPS SU SALUD INTEGRAL S.A.S")) {
            this.JCHBVCLateral2.setEnabled(false);
            this.JCHBVCLateral3.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBVCLateral3ActionPerformed(ActionEvent evt) {
        this.x11fl = Integer.parseInt(this.JCHBVCLateral3.getName().toString());
        mSumarVCN11(this.JCHBVCLateral3);
        if (!Principal.informacionIps.getNombreIps().equals("IPS SU SALUD INTEGRAL S.A.S")) {
            this.JCHBVCLateral3.setEnabled(false);
            this.JCHBVCLateral4.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBVCLateral4ActionPerformed(ActionEvent evt) {
        this.x11fl = Integer.parseInt(this.JCHBVCLateral4.getName().toString());
        mSumarVCN11(this.JCHBVCLateral4);
        if (!Principal.informacionIps.getNombreIps().equals("IPS SU SALUD INTEGRAL S.A.S")) {
            this.JCHBVCLateral4.setEnabled(false);
            this.JCHBVCLateral5.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBVCLateral5ActionPerformed(ActionEvent evt) {
        this.x11fl = Integer.parseInt(this.JCHBVCLateral5.getName().toString());
        mSumarVCN11(this.JCHBVCLateral5);
        if (!Principal.informacionIps.getNombreIps().equals("IPS SU SALUD INTEGRAL S.A.S")) {
            this.JCHBVCLateral5.setEnabled(false);
            this.JCHBVCLateral6.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBVCLateral6ActionPerformed(ActionEvent evt) {
        this.x11fl = Integer.parseInt(this.JCHBVCLateral6.getName().toString());
        mSumarVCN11(this.JCHBVCLateral6);
        if (!Principal.informacionIps.getNombreIps().equals("IPS SU SALUD INTEGRAL S.A.S")) {
            this.JCHBVCLateral6.setEnabled(false);
            this.JCHBVCLateral7.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBVCLateral7ActionPerformed(ActionEvent evt) {
        this.x11fl = Integer.parseInt(this.JCHBVCLateral7.getName().toString());
        mSumarVCN11(this.JCHBVCLateral7);
        if (!Principal.informacionIps.getNombreIps().equals("IPS SU SALUD INTEGRAL S.A.S")) {
            this.JCHBVCLateral7.setEnabled(false);
            this.JCHBVCLateral8.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBVCLateral8ActionPerformed(ActionEvent evt) {
        this.x11fl = Integer.parseInt(this.JCHBVCLateral8.getName().toString());
        mSumarVCN11(this.JCHBVCLateral8);
        if (!Principal.informacionIps.getNombreIps().equals("IPS SU SALUD INTEGRAL S.A.S")) {
            this.JCHBVCLateral8.setEnabled(false);
            this.JCHBVCLateral9.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBVCLateral9ActionPerformed(ActionEvent evt) {
        this.x11fl = Integer.parseInt(this.JCHBVCLateral9.getName().toString());
        mSumarVCN11(this.JCHBVCLateral9);
        if (!Principal.informacionIps.getNombreIps().equals("IPS SU SALUD INTEGRAL S.A.S")) {
            this.JCHBVCLateral9.setEnabled(false);
            this.JCHBVCLateral10.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBVCLateral10ActionPerformed(ActionEvent evt) {
        this.x11fl = Integer.parseInt(this.JCHBVCLateral10.getName().toString());
        mSumarVCN11(this.JCHBVCLateral10);
        if (!Principal.informacionIps.getNombreIps().equals("IPS SU SALUD INTEGRAL S.A.S")) {
            this.JCHBVCLateral10.setEnabled(false);
            this.JCHBVCLateral11.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBVCLateral11ActionPerformed(ActionEvent evt) {
        this.x11fl = Integer.parseInt(this.JCHBVCLateral11.getName().toString());
        mSumarVCN11(this.JCHBVCLateral11);
        if (!Principal.informacionIps.getNombreIps().equals("IPS SU SALUD INTEGRAL S.A.S")) {
            this.JCHBVCLateral11.setEnabled(false);
            this.JCHBVCLateral12.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBVCLateral12ActionPerformed(ActionEvent evt) {
        this.x11fl = Integer.parseInt(this.JCHBVCLateral12.getName().toString());
        mSumarVCN11(this.JCHBVCLateral12);
        if (!Principal.informacionIps.getNombreIps().equals("IPS SU SALUD INTEGRAL S.A.S")) {
            this.JCHBVCLateral12.setEnabled(false);
            this.JCHBVCLateral13.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBVCLateral13ActionPerformed(ActionEvent evt) {
        this.x11fl = Integer.parseInt(this.JCHBVCLateral13.getName().toString());
        mSumarVCN11(this.JCHBVCLateral13);
        if (!Principal.informacionIps.getNombreIps().equals("IPS SU SALUD INTEGRAL S.A.S")) {
            this.JCHBVCLateral3.setEnabled(false);
            this.JCHBVCLateral14.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBVCLateral14ActionPerformed(ActionEvent evt) {
        this.x11fl = Integer.parseInt(this.JCHBVCLateral14.getName().toString());
        mSumarVCN11(this.JCHBVCLateral14);
        if (!Principal.informacionIps.getNombreIps().equals("IPS SU SALUD INTEGRAL S.A.S")) {
            this.JCHBVCLateral14.setEnabled(false);
            this.JCHBVCLateral15.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBVCLateral15ActionPerformed(ActionEvent evt) {
        this.x11fl = Integer.parseInt(this.JCHBVCLateral15.getName().toString());
        mSumarVCN11(this.JCHBVCLateral15);
        if (!Principal.informacionIps.getNombreIps().equals("IPS SU SALUD INTEGRAL S.A.S")) {
            this.JCHBVCLateral15.setEnabled(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBVCFVerticalActionPerformed(ActionEvent evt) {
        this.x12fv = Integer.parseInt(this.JCHBVCFVertical.getName().toString());
        mSumarVLN12(this.JCHBVCFVertical, 1);
        if (!Principal.informacionIps.getNombreIps().equals("IPS SU SALUD INTEGRAL S.A.S")) {
            this.JCHBVCFVertical.setEnabled(false);
            this.JCHBVCFVertical2.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBVCFVertical2ActionPerformed(ActionEvent evt) {
        this.x12fv = Integer.parseInt(this.JCHBVCFVertical2.getName().toString());
        mSumarVLN12(this.JCHBVCFVertical2, 1);
        if (!Principal.informacionIps.getNombreIps().equals("IPS SU SALUD INTEGRAL S.A.S")) {
            this.JCHBVCFVertical2.setEnabled(false);
            this.JCHBVCFVertical3.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBVCFVertical3ActionPerformed(ActionEvent evt) {
        this.x12fv = Integer.parseInt(this.JCHBVCFVertical3.getName().toString());
        mSumarVLN12(this.JCHBVCFVertical3, 1);
        if (!Principal.informacionIps.getNombreIps().equals("IPS SU SALUD INTEGRAL S.A.S")) {
            this.JCHBVCFVertical3.setEnabled(false);
            this.JCHBVCFVertical4.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBVCFVertical4ActionPerformed(ActionEvent evt) {
        this.x12fv = Integer.parseInt(this.JCHBVCFVertical4.getName().toString());
        mSumarVLN12(this.JCHBVCFVertical4, 1);
        if (!Principal.informacionIps.getNombreIps().equals("IPS SU SALUD INTEGRAL S.A.S")) {
            this.JCHBVCFVertical4.setEnabled(false);
            this.JCHBVCFVertical5.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBVCFVertical5ActionPerformed(ActionEvent evt) {
        this.x12fv = Integer.parseInt(this.JCHBVCFVertical5.getName().toString());
        mSumarVLN12(this.JCHBVCFVertical5, 1);
        if (!Principal.informacionIps.getNombreIps().equals("IPS SU SALUD INTEGRAL S.A.S")) {
            this.JCHBVCFVertical5.setEnabled(false);
            this.JCHBVCFVertical6.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBVCFVertical6ActionPerformed(ActionEvent evt) {
        this.x12fv = Integer.parseInt(this.JCHBVCFVertical6.getName().toString());
        mSumarVLN12(this.JCHBVCFVertical6, 1);
        if (!Principal.informacionIps.getNombreIps().equals("IPS SU SALUD INTEGRAL S.A.S")) {
            this.JCHBVCFVertical6.setEnabled(false);
            this.JCHBVCFVertical7.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBVCFVertical7ActionPerformed(ActionEvent evt) {
        this.x12fv = Integer.parseInt(this.JCHBVCFVertical7.getName().toString());
        mSumarVLN12(this.JCHBVCFVertical7, 1);
        if (!Principal.informacionIps.getNombreIps().equals("IPS SU SALUD INTEGRAL S.A.S")) {
            this.JCHBVCFVertical7.setEnabled(false);
            this.JCHBVCFVertical8.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBVCFVertical8ActionPerformed(ActionEvent evt) {
        this.x12fv = Integer.parseInt(this.JCHBVCFVertical8.getName().toString());
        mSumarVLN12(this.JCHBVCFVertical8, 1);
        if (!Principal.informacionIps.getNombreIps().equals("IPS SU SALUD INTEGRAL S.A.S")) {
            this.JCHBVCFVertical8.setEnabled(false);
            this.JCHBVCFVertical9.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBVCFVertical9ActionPerformed(ActionEvent evt) {
        this.x12fv = Integer.parseInt(this.JCHBVCFVertical9.getName().toString());
        mSumarVLN12(this.JCHBVCFVertical9, 1);
        if (!Principal.informacionIps.getNombreIps().equals("IPS SU SALUD INTEGRAL S.A.S")) {
            this.JCHBVCFVertical9.setEnabled(false);
        }
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
            this.xsql = "insert into h_so_visiometria (`Id_Atencion` , `Id_Usuario` , `Id_Profesional` , `Id_Especialidad`, `Id_Sede`, `FechaR`, `LContacto`, `TLenteC`, `RLFormulado`, `Tipo_Gafas`, `UCorreccion` , `Tipo_Correcion`, `R_VLAmbosO`, `R_VLAmbosO_V`, `R_VLAmbosO_T`, `R_VLODerecho`, `R_VLODerecho_V`, `R_VLODerecho_T`, `R_VLOIzquierdo`, `R_VLOIzquierdo_V`, `R_VLOIzquierdo_T` , `R_VLEstereopsi`, `R_VLEstereopsi_T`, `R_VLColor`, `R_VLColor_T`, `R_VLFVertical`, `R_VLFVertical_T`, `R_VLFLateral`, `R_VLFLateral_T`, `R_VCAmbosO`, `R_VCAmbosO_V`, `R_VCAmbosO_T` , `R_VCODerecho`, `R_VCODerecho_V`, `R_VCODerecho_T`, `R_VCOIzquierdo`, `R_VCOIzquierdo_V`, `R_VCOIzquierdo_T`, `R_VCFLateral`, `R_VCFLateral_T`,`R_VCFVertical`, `R_VCFVertical_T`,  `ColorA` , `ColorB` , `ColorC` , `ColorD` , `ColorE` , `ColorF`, `Est1`  , `Est2` , `Est3` , `Est4`  , `Est5` , `Est6`  , `Est7` , `Est8` , `Est9`,Guardado,ObservacionVisio,R_VLPercepcion,`UsuarioS` )  values('" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "','" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "','" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "','" + Principal.sedeUsuarioSeleccionadaDTO.getId() + "','" + this.xmt.formatoAMD.format(this.xmt.getFechaActual()) + "','" + this.xdglentesc + "','" + this.xdgtipolentes + "','" + this.xdglformulados + "','" + this.xdgtipogafas + "','" + this.xdgtipocorrecion + "','" + this.xtcorrecion + "','" + mTraerNombreControlSeleccionado(this.JPI1_VLAOjos) + "','" + this.JLB1_VLResultado.getText() + "','" + this.JLB1_VLRClasificacion.getText() + "','" + mTraerNombreControlSeleccionado(this.JPI2_ODerecho) + "','" + this.JLB2_VLResultado.getText() + "','" + this.JLB2_VLRClasificacion.getText() + "','" + mTraerNombreControlSeleccionado(this.JPI3_OIzquierdo) + "','" + this.JLB3_VLResultado.getText() + "','" + this.JLB3_VLRClasificacion.getText() + "','" + this.x3e + "','" + this.JLB4_VLRClasificacion.getText() + "','" + this.x5c + "','" + this.JLB5_VLRClasificacion.getText() + "','" + this.x6fv + "','" + this.JLB6_VLRClasificacion.getText() + "','" + this.x7fl + "','" + this.JLB7_VLRClasificacion.getText() + "','" + mTraerNombreControlSeleccionado(this.JPI8_VCAOjos) + "','" + this.JLB8_VCResultado.getText() + "','" + this.JLB8_VCRClasificacion.getText() + "','" + mTraerNombreControlSeleccionado(this.JPI9_VCDerecho) + "','" + this.JLB9_VCDResultado.getText() + "','" + this.JLB9_VCDClasificacion.getText() + "','" + mTraerNombreControlSeleccionado(this.JPI10_VCIzquierdo) + "','" + this.JLB10_VCResultado.getText() + "','" + this.JLB10_VCClasificacion.getText() + "','" + this.x11fl + "','" + this.JLB11_VCFLaClasificacion.getText() + "','" + this.x12fv + "','" + this.JLB12_VCFVeClasificacion.getText() + "','" + this.xColorA + "','" + this.xColorB + "','" + this.xColorC + "','" + this.xColorD + "','" + this.xColorE + "','" + this.xColorF + "','" + this.xEst1 + "','" + this.xEst2 + "','" + this.xEst3 + "','" + this.xEst4 + "','" + this.xEst5 + "','" + this.xEst6 + "','" + this.xEst7 + "','" + this.xEst8 + "','" + this.xEst9 + "','1','" + this.JTAObsVisiometria.getText() + "','" + this.JLPercepcion.getText() + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
            this.xidVisio = this.xct.ejecutarSQLId(this.xsql);
            this.xct.cerrarConexionBd();
            this.JBTGrabar.setEnabled(false);
            Principal.clasehistoriace.mCambiarEstadoOrdenProcedimiento();
            mImprimir();
            mBuscar();
            this.xmt.cambiarEstadoValidadoItemHC(getName(), 1, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBGuardarInterActionPerformed(ActionEvent evt) {
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "VERIFICAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            String sql = "update `h_so_visiometria` set Interpretacion='" + this.JTAInterpretacion.getText() + "', IdUsuarioInter='" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "', Resultado='" + this.JCBResultado.getSelectedItem() + "' ,Guardado=2  where Id_Atencion='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "'";
            System.out.println("update interpretacion -> " + sql);
            this.xct.ejecutarSQL(sql);
            this.xct.cerrarConexionBd();
            if (!Principal.informacionIps.getNombreIps().equals("IPS SU SALUD INTEGRAL S.A.S")) {
                this.JBGuardarInter.setEnabled(false);
            }
            this.xmt.cambiarEstadoValidadoItemHC(getName(), 1, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleHistoricoMouseClicked(MouseEvent evt) {
        if (this.JTDetalleHistorico.getSelectedRow() != -1 && evt.getClickCount() == 2) {
            this.xidVisio = this.xmodelo.getValueAt(this.JTDetalleHistorico.getSelectedRow(), 3).toString();
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
        if (!Principal.informacionIps.getNombreIps().equals("IPS SU SALUD INTEGRAL S.A.S")) {
            this.JCHBC7.setEnabled(false);
        }
        this.JCHBC8.setEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBC8ActionPerformed(ActionEvent evt) {
        this.x5c = Integer.parseInt(this.JCHBC8.getName().toString());
        if (!Principal.informacionIps.getNombreIps().equals("IPS SU SALUD INTEGRAL S.A.S")) {
            if (this.JCHBC8.isSelected()) {
                this.xcolor = 2;
                this.xColorE = 1;
            } else {
                this.xcolor = -2;
                this.xColorE = 0;
            }
        } else if (this.JCHBC8.isSelected()) {
            this.xcolor = 0;
            this.xColorF = 1;
        } else {
            this.xcolor = 0;
            this.xColorF = 0;
        }
        mSumarVLN5(this.JCHBC8);
        if (!Principal.informacionIps.getNombreIps().equals("IPS SU SALUD INTEGRAL S.A.S")) {
            this.JCHBC8.setEnabled(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBFallidoActionPerformed(ActionEvent evt) {
        this.JCHBEs1.setSelected(false);
        this.JCHBEs2.setSelected(false);
        this.JCHBEs3.setSelected(false);
        this.JCHBEs4.setSelected(false);
        this.JCHBEs5.setSelected(false);
        this.JCHBEs6.setSelected(false);
        this.JLPercepcion.setText("0%");
        this.x3e = Integer.parseInt(this.JCHBFallido.getName().toString());
        mSumarVLN4(this.JCHBFallido);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBFallidoAmbOLejanaActionPerformed(ActionEvent evt) {
        mEstablecerResultado(this.JCHBFallidoAmbOLejana.getName(), this.JLB1_VLResultado, this.JLB1_VLRClasificacion);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBFallidoOjoDerechoLejanaActionPerformed(ActionEvent evt) {
        mEstablecerResultado(this.JCHBFallidoOjoDerechoLejana.getName(), this.JLB2_VLResultado, this.JLB2_VLRClasificacion);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBFallidoOjoIzqLejanaActionPerformed(ActionEvent evt) {
        mEstablecerResultado(this.JCHBFallidoOjoIzqLejana.getName(), this.JLB3_VLResultado, this.JLB3_VLRClasificacion);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBFallidoAmbOCercanaActionPerformed(ActionEvent evt) {
        mEstablecerResultado(this.JCHBFallidoAmbOCercana.getName(), this.JLB8_VCResultado, this.JLB8_VCRClasificacion);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBFallidoOjoDerechoCercanaActionPerformed(ActionEvent evt) {
        mEstablecerResultado(this.JCHBFallidoOjoDerechoCercana.getName(), this.JLB9_VCDResultado, this.JLB9_VCDClasificacion);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBFallidoOjoIzqCercanaActionPerformed(ActionEvent evt) {
        mEstablecerResultado(this.JCHBFallidoOjoIzqCercana.getName(), this.JLB10_VCResultado, this.JLB10_VCClasificacion);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTActualizarActionPerformed(ActionEvent evt) {
        actualizar();
    }

    private void actualizar() {
        int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de Actualizar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (x == 0) {
            if (Principal.informacionIps.getNombreIps().equals("IPS SU SALUD INTEGRAL S.A.S")) {
                verificarVariables();
            }
            this.xsql = "UPDATE h_so_visiometria SET   Id_Usuario = '" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "',  Id_Especialidad = '" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "',  Id_Sede = '" + Principal.sedeUsuarioSeleccionadaDTO.getId() + "',  FechaR = '" + this.xmt.formatoAMD.format(this.xmt.getFechaActual()) + "',  LContacto = '" + this.xdglentesc + "',  TLenteC = '" + this.xdgtipolentes + "',  RLFormulado = '" + this.xdglformulados + "',  Tipo_Gafas = '" + this.xdgtipogafas + "',  UCorreccion = '" + this.xdgtipocorrecion + "',  Tipo_Correcion = '" + this.xtcorrecion + "',  R_VLAmbosO = '" + mTraerNombreControlSeleccionado(this.JPI1_VLAOjos) + "',  R_VLAmbosO_V = '" + this.JLB1_VLResultado.getText() + "',  R_VLAmbosO_T = '" + this.JLB1_VLRClasificacion.getText() + "',  R_VLODerecho = '" + mTraerNombreControlSeleccionado(this.JPI2_ODerecho) + "',  R_VLODerecho_V = '" + this.JLB2_VLResultado.getText() + "',  R_VLODerecho_T = '" + this.JLB2_VLRClasificacion.getText() + "',  R_VLOIzquierdo = '" + mTraerNombreControlSeleccionado(this.JPI3_OIzquierdo) + "',  R_VLOIzquierdo_V = '" + this.JLB3_VLResultado.getText() + "',  R_VLOIzquierdo_T = '" + this.JLB3_VLRClasificacion.getText() + "',  R_VLEstereopsi = '" + this.x3e + "',  R_VLEstereopsi_T = '" + this.JLB4_VLRClasificacion.getText() + "',  R_VLColor = '" + this.x5c + "',  R_VLColor_T = '" + this.JLB5_VLRClasificacion.getText() + "',  R_VLFVertical = '" + this.x6fv + "',  R_VLFVertical_T = '" + this.JLB6_VLRClasificacion.getText() + "',  R_VLFLateral = '" + this.x7fl + "',  R_VLFLateral_T = '" + this.JLB7_VLRClasificacion.getText() + "',  R_VCAmbosO = '" + mTraerNombreControlSeleccionado(this.JPI8_VCAOjos) + "',  R_VCAmbosO_V = '" + this.JLB8_VCResultado.getText() + "',  R_VCAmbosO_T = '" + this.JLB8_VCRClasificacion.getText() + "',  R_VCODerecho = '" + mTraerNombreControlSeleccionado(this.JPI9_VCDerecho) + "',  R_VCODerecho_V = '" + this.JLB9_VCDResultado.getText() + "',  R_VCODerecho_T = '" + this.JLB9_VCDClasificacion.getText() + "',  R_VCOIzquierdo = '" + mTraerNombreControlSeleccionado(this.JPI10_VCIzquierdo) + "',  R_VCOIzquierdo_V = '" + this.JLB10_VCResultado.getText() + "',  R_VCOIzquierdo_T = '" + this.JLB10_VCClasificacion.getText() + "',  R_VCFLateral = '" + this.x11fl + "',  R_VCFLateral_T = '" + this.JLB11_VCFLaClasificacion.getText() + "',  R_VCFVertical = '" + this.x12fv + "',  Guardado = '1',  ObservacionVisio = '" + this.JTAObsVisiometria.getText() + "',  UsuarioS = '" + Principal.usuarioSistemaDTO.getLogin() + "' ,ColorA= '" + this.xColorA + "', ColorB='" + this.xColorB + "' , ColorC='" + this.xColorC + "' , ColorD='" + this.xColorD + "' , ColorE='" + this.xColorE + "' , ColorF='" + this.xColorF + "', Est1='" + this.xEst1 + "'  , Est2='" + this.xEst2 + "' , Est3='" + this.xEst3 + "' , Est4='" + this.xEst4 + "'  , Est5='" + this.xEst5 + "' , Est6='" + this.xEst6 + "'  , Est7='" + this.xEst7 + "' , Est8='" + this.xEst8 + "' , Est9 ='" + this.xEst9 + "' WHERE  Id_Atencion = '" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "'";
            System.out.println("actualizar visiometria -> " + this.xsql);
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            Principal.clasehistoriace.mCambiarEstadoOrdenProcedimiento();
            mBuscar();
            mImprimir();
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloHistorico() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id Atencion", "Fecha", "Profesional", "IdVisio"}) { // from class: Historia.JPSo_VisiometriaG.158
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
            String sql = "SELECT  `h_so_visiometria`.`Id_Atencion` , `h_so_visiometria`.`FechaR`  , `profesional`.`NProfesional`, h_so_visiometria.Id FROM `h_so_visiometria` INNER JOIN `profesional`  ON (`h_so_visiometria`.`Id_Profesional` = `profesional`.`Id_Persona`) WHERE (`h_so_visiometria`.`Id_Usuario` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "')";
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
                        if (!Principal.informacionIps.getNombreIps().equals("IPS SU SALUD INTEGRAL S.A.S")) {
                            xch.setEnabled(false);
                            return;
                        }
                        return;
                    }
                }
            }
        }
    }

    private void mEstablecerValor(JPanel xpanel, int xvalor) {
        if (xpanel.getComponentCount() >= 0) {
            for (int x = 0; x < xpanel.getComponentCount(); x++) {
                if (xpanel.getComponent(x).getClass().getName().equals("javax.swing.JCheckBox")) {
                    JCheckBox xch = xpanel.getComponent(x);
                    if (xvalor > 0 && Integer.parseInt(xch.getName()) <= xvalor) {
                        if (xch.getName().equals("0")) {
                            xch.setSelected(false);
                        } else {
                            xch.setEnabled(true);
                            xch.setSelected(true);
                            if (!Principal.informacionIps.getNombreIps().equals("IPS SU SALUD INTEGRAL S.A.S")) {
                                xch.setEnabled(false);
                            }
                        }
                    } else if (xvalor == 0 && Integer.parseInt(xch.getName()) == 0) {
                        xch.setSelected(true);
                    }
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
        if (!Principal.informacionIps.getNombreIps().equals("IPS SU SALUD INTEGRAL S.A.S")) {
            xcontrol.setEnabled(false);
        }
        if (this.x3e >= 5) {
            this.JLB4_VLRClasificacion.setText("NORMAL");
        } else {
            this.JLB4_VLRClasificacion.setText("CON HALLAZGOS");
        }
    }

    private void mSumarVLN5(JCheckBox xcontrol) {
        if (!Principal.informacionIps.getNombreIps().equals("IPS SU SALUD INTEGRAL S.A.S")) {
            xcontrol.setEnabled(false);
        }
        if (this.x5c >= 4) {
            this.JLB5_VLRClasificacion.setText("NORMAL");
        } else {
            this.JLB5_VLRClasificacion.setText("CON HALLAZGOS");
        }
    }

    private void mSumarVLN6(JCheckBox xcontrol, int xvalor) {
        if (!Principal.informacionIps.getNombreIps().equals("IPS SU SALUD INTEGRAL S.A.S")) {
            xcontrol.setEnabled(false);
        }
        if (this.x6fv == 5) {
            this.JLB6_VLRClasificacion.setText("NORMAL");
        } else {
            this.JLB6_VLRClasificacion.setText("CON HALLAZGOS");
        }
    }

    private void mSumarVLN7(JCheckBox xcontrol) {
        if (!Principal.informacionIps.getNombreIps().equals("IPS SU SALUD INTEGRAL S.A.S")) {
            xcontrol.setEnabled(false);
        }
        if (this.x7fl == 8) {
            this.JLB7_VLRClasificacion.setText("NORMAL");
        } else {
            this.JLB7_VLRClasificacion.setText("CON HALLAZGOS");
        }
    }

    private void mSumarVCN11(JCheckBox xcontrol) {
        if (!Principal.informacionIps.getNombreIps().equals("IPS SU SALUD INTEGRAL S.A.S")) {
            xcontrol.setEnabled(false);
        }
        if (this.x11fl >= 9) {
            this.JLB11_VCFLaClasificacion.setText("NORMAL");
        } else {
            this.JLB11_VCFLaClasificacion.setText("CON HALLAZGOS");
        }
    }

    private void mSumarVLN12(JCheckBox xcontrol, int xvalor) {
        if (!Principal.informacionIps.getNombreIps().equals("IPS SU SALUD INTEGRAL S.A.S")) {
            xcontrol.setEnabled(false);
        }
        if (this.x12fv >= 6) {
            this.JLB12_VCFVeClasificacion.setText("NORMAL");
        } else {
            this.JLB12_VCFVeClasificacion.setText("CON HALLAZGOS");
        }
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
            Logger.getLogger(JPSo_VisiometriaG.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mBuscar() {
        try {
            this.xsql = "SELECT `LContacto`, `TLenteC`, `RLFormulado`, `Tipo_Gafas`, `UCorreccion`, `Tipo_Correcion`, `R_VLAmbosO`, `R_VLAmbosO_V`, `R_VLAmbosO_T`, `R_VLODerecho` , `R_VLODerecho_V`, `R_VLODerecho_T`, `R_VLOIzquierdo`, `R_VLOIzquierdo_V`, `R_VLOIzquierdo_T`, `R_VLEstereopsi`, `R_VLEstereopsi_T`, `R_VLColor`, `R_VLColor_T` , `R_VLFVertical`, `R_VLFVertical_T`, `R_VLFLateral`, `R_VLFLateral_T`, `R_VCAmbosO`, `R_VCAmbosO_V`, `R_VCAmbosO_T`, `R_VCODerecho` , `R_VCODerecho_V`, `R_VCODerecho_T` , `R_VCOIzquierdo`, `R_VCOIzquierdo_V`, `R_VCOIzquierdo_T`, `R_VCFVertical`, `R_VCFVertical_T`, `R_VCFLateral`, `R_VCFLateral_T`, Interpretacion, Resultado, Guardado, Id, ObservacionVisio,R_VLPercepcion ,`ColorA` , `ColorB` , `ColorC` , `ColorD` , `ColorE` , `ColorF`, `Est1`  , `Est2` , `Est3` , `Est4`  , `Est5` , `Est6`  , `Est7` , `Est8` , `Est9`  FROM  `h_so_visiometria` WHERE (`Id_Atencion` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "') ";
            System.out.println("buscar -> " + this.xsql);
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
                mEstablecerValor(this.JPI4_Estereopsis, xrs.getInt("R_VLEstereopsi"));
                this.JLB4_VLRClasificacion.setText(xrs.getString("R_VLEstereopsi_T"));
                mEstablecerValor(this.JPI5_Color, xrs.getInt("R_VLColor"));
                this.JLB5_VLRClasificacion.setText(xrs.getString("R_VLColor_T"));
                mEstablecerValor(this.JPI6_FVertical, xrs.getInt("R_VLFVertical"));
                this.JLB6_VLRClasificacion.setText(xrs.getString("R_VLFVertical_T"));
                mEstablecerValor(this.JPI7_FLateral, xrs.getInt("R_VLFLateral"));
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
                mEstablecerValor(this.JPI11_VCFLateral, xrs.getInt("R_VCFLateral"));
                this.JLB11_VCFLaClasificacion.setText(xrs.getString("R_VCFLateral_T"));
                mEstablecerValor(this.JPI12_VCFVertical, xrs.getInt("R_VCFVertical"));
                this.JLB12_VCFVeClasificacion.setText(xrs.getString("R_VCFVertical_T"));
                this.JTAInterpretacion.setText(xrs.getString("Interpretacion"));
                this.JCBResultado.setSelectedItem(xrs.getString("Resultado"));
                this.xexistencia = xrs.getLong("Guardado");
                this.xidVisio = xrs.getString("Id");
                this.JTAObsVisiometria.setText(xrs.getString("ObservacionVisio"));
                this.JLPercepcion.setText(xrs.getString("R_VLPercepcion"));
                if (Principal.informacionIps.getNombreIps().equals("IPS SU SALUD INTEGRAL S.A.S")) {
                    if (xrs.getLong("ColorA") == 1) {
                        this.JCHBC.setSelected(true);
                        this.JCHBC.setEnabled(true);
                        this.xColorA = 1;
                    } else {
                        this.JCHBC.setSelected(false);
                    }
                    if (xrs.getLong("ColorB") == 1) {
                        this.JCHBC1.setSelected(true);
                        this.JCHBC1.setEnabled(true);
                        this.xColorB = 1;
                    } else {
                        this.JCHBC1.setSelected(false);
                    }
                    if (xrs.getLong("ColorC") == 1) {
                        this.JCHBC5.setSelected(true);
                        this.JCHBC5.setEnabled(true);
                        this.xColorC = 1;
                    } else {
                        this.JCHBC5.setSelected(false);
                    }
                    if (xrs.getLong("ColorD") == 1) {
                        this.JCHBC6.setSelected(true);
                        this.JCHBC6.setEnabled(true);
                        this.xColorD = 1;
                    } else {
                        this.JCHBC6.setSelected(false);
                    }
                    if (xrs.getLong("ColorE") == 1) {
                        this.JCHBC7.setSelected(true);
                        this.JCHBC7.setEnabled(true);
                        this.xColorE = 1;
                    } else {
                        this.JCHBC7.setSelected(false);
                    }
                    if (xrs.getLong("ColorF") == 1) {
                        this.JCHBC8.setSelected(true);
                        this.JCHBC8.setEnabled(true);
                        this.xColorF = 1;
                    } else {
                        this.JCHBC8.setSelected(false);
                    }
                    if (xrs.getLong("Est1") == 1) {
                        this.JCHBEs1.setSelected(true);
                        this.JCHBEs1.setEnabled(true);
                        this.xEst1 = 1;
                    } else {
                        this.JCHBEs1.setSelected(false);
                    }
                    if (xrs.getLong("Est2") == 1) {
                        this.JCHBEs2.setSelected(true);
                        this.JCHBEs2.setEnabled(true);
                        this.xEst2 = 1;
                    } else {
                        this.JCHBEs2.setSelected(false);
                    }
                    if (xrs.getLong("Est3") == 1) {
                        this.JCHBEs3.setSelected(true);
                        this.JCHBEs3.setEnabled(true);
                        this.xEst3 = 1;
                    } else {
                        this.JCHBEs3.setSelected(false);
                    }
                    if (xrs.getLong("Est4") == 1) {
                        this.JCHBEs4.setSelected(true);
                        this.JCHBEs4.setEnabled(true);
                        this.xEst4 = 1;
                    } else {
                        this.JCHBEs4.setSelected(false);
                    }
                    if (xrs.getLong("Est5") == 1) {
                        this.JCHBEs5.setSelected(true);
                        this.JCHBEs5.setEnabled(true);
                        this.xEst1 = 5;
                    } else {
                        this.JCHBEs5.setSelected(false);
                    }
                    if (xrs.getLong("Est6") == 1) {
                        this.JCHBEs6.setSelected(true);
                        this.JCHBEs6.setEnabled(true);
                        this.xEst6 = 1;
                    } else {
                        this.JCHBEs6.setSelected(false);
                    }
                }
                this.xmt.cambiarEstadoValidadoItemHC(getName(), 1, true);
            }
            if (this.xexistencia == 1) {
                this.JBTGrabar.setEnabled(false);
            } else if (this.xexistencia == 2) {
                this.JBTGrabar.setEnabled(false);
                if (Principal.informacionIps.getNombreIps().equals("IPS SU SALUD INTEGRAL S.A.S")) {
                    this.JBGuardarInter.setEnabled(true);
                } else {
                    this.JBGuardarInter.setEnabled(false);
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPSo_VisiometriaG.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mImprimir() {
        String[][] mparametros = new String[3][2];
        mparametros[0][0] = "IdVisiometria";
        mparametros[0][1] = this.xidVisio;
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

    private void verificarVariables() {
        boolean anySelectedVer = false;
        JCheckBox[] fvCheckBoxes = {this.JCHBFV, this.JCHBFV1, this.JCHBFV2, this.JCHBFV3, this.JCHBFV4, this.JCHBFV5, this.JCHBFV6, this.JCHBFV7, this.JCHBFV8};
        for (int i = 0; i < fvCheckBoxes.length; i++) {
            if (fvCheckBoxes[i].isSelected()) {
                this.x6fv = Integer.parseInt(fvCheckBoxes[i].getName());
                anySelectedVer = true;
            }
        }
        if (!anySelectedVer) {
            this.x6fv = 0;
        }
        JCheckBox[] eCheckBoxes = {this.JCHBEs1, this.JCHBEs2, this.JCHBEs3, this.JCHBEs4, this.JCHBEs5, this.JCHBEs6};
        for (int i2 = 0; i2 < eCheckBoxes.length; i2++) {
            if (eCheckBoxes[i2].isSelected()) {
                this.x3e = Integer.parseInt(eCheckBoxes[i2].getName());
            }
        }
        this.xEst1 = this.JCHBEs1.isSelected() ? 1 : 0;
        this.xEst2 = this.JCHBEs2.isSelected() ? 1 : 0;
        this.xEst3 = this.JCHBEs3.isSelected() ? 1 : 0;
        this.xEst4 = this.JCHBEs4.isSelected() ? 1 : 0;
        this.xEst5 = this.JCHBEs5.isSelected() ? 1 : 0;
        this.xEst6 = this.JCHBEs6.isSelected() ? 1 : 0;
        boolean anySelectedLat = false;
        JCheckBox[] flCheckBoxes = {this.JCHBFLa, this.JCHBFLa1, this.JCHBFLa2, this.JCHBFLa3, this.JCHBFLa4, this.JCHBFLa5, this.JCHBFLa6, this.JCHBFLa7, this.JCHBFLa8, this.JCHBFLa9, this.JCHBFLa10, this.JCHBFLa11, this.JCHBFLa12, this.JCHBFLa13, this.JCHBFLa14};
        for (int i3 = 0; i3 < flCheckBoxes.length; i3++) {
            if (flCheckBoxes[i3].isSelected()) {
                this.x7fl = Integer.parseInt(flCheckBoxes[i3].getName());
                anySelectedLat = true;
            }
        }
        if (!anySelectedLat) {
            this.x7fl = 0;
        }
        JCheckBox[] fl11CheckBoxes = {this.JCHBVCLateral, this.JCHBVCLateral2, this.JCHBVCLateral3, this.JCHBVCLateral4, this.JCHBVCLateral5, this.JCHBVCLateral6, this.JCHBVCLateral7, this.JCHBVCLateral8, this.JCHBVCLateral9, this.JCHBVCLateral10, this.JCHBVCLateral11, this.JCHBVCLateral12, this.JCHBVCLateral13, this.JCHBVCLateral14, this.JCHBVCLateral15};
        boolean anySelected11 = false;
        for (int i4 = 0; i4 < fl11CheckBoxes.length; i4++) {
            if (fl11CheckBoxes[i4].isSelected()) {
                int value = Integer.parseInt(fl11CheckBoxes[i4].getName());
                this.x11fl = value;
                anySelected11 = true;
            }
        }
        if (!anySelected11) {
            this.x11fl = 0;
        }
        JCheckBox[] fl12CheckBoxes = {this.JCHBVCFVertical, this.JCHBVCFVertical2, this.JCHBVCFVertical3, this.JCHBVCFVertical4, this.JCHBVCFVertical5, this.JCHBVCFVertical6, this.JCHBVCFVertical7, this.JCHBVCFVertical8, this.JCHBVCFVertical9};
        boolean anySelected12 = false;
        for (int i5 = 0; i5 < fl12CheckBoxes.length; i5++) {
            if (fl12CheckBoxes[i5].isSelected()) {
                int value2 = Integer.parseInt(fl12CheckBoxes[i5].getName());
                this.x12fv = value2;
                anySelected12 = true;
            }
        }
        if (!anySelected12) {
            this.x12fv = 0;
        }
        this.xdglentesc = this.JCHDGLentesC.isSelected() ? 1 : 0;
        this.xdglformulados = this.JCHDGSLentesF.isSelected() ? "Si" : "No";
        if (this.JRBDGTLNinguno.isSelected()) {
            this.xdgtipolentes = "Ninguno";
        } else if (this.JRBDGTLProgresivo.isSelected()) {
            this.xdgtipolentes = "Progresivo";
        } else if (this.JRBDGTLBifocales.isSelected()) {
            this.xdgtipolentes = "Bifocales";
        } else if (this.JRBDGTLMonofocales.isSelected()) {
            this.xdgtipolentes = "Monofocales";
        }
        if (this.JRBDGTGNinguna.isSelected()) {
            this.xdgtipogafas = "Ninguna";
        } else if (this.JRBDGTGPersonal.isSelected()) {
            this.xdgtipogafas = "Personal";
        } else if (this.JRBDGTGSeguridad.isSelected()) {
            this.xdgtipogafas = "Seguridad";
        }
        if (this.JRBDGTCNinguna.isSelected()) {
            this.xdgtipocorrecion = "Ninguna";
        } else if (this.JRBDGTCPermanente.isSelected()) {
            this.xdgtipocorrecion = "Permanente";
        } else if (this.JRBDGTCEsporadico.isSelected()) {
            this.xdgtipocorrecion = "Esporádica";
        }
        if (this.JCHTCLejos.isSelected() || this.JCHTCCerca.isSelected()) {
            mCTipoCorrecion();
        }
    }
}
