package ImagenesDx;

import Acceso.Principal;
import General.Persona;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
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
import javax.swing.JCheckBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:ImagenesDx/JIFLecturaPlacaOit.class */
public class JIFLecturaPlacaOit extends JInternalFrame {
    private String xsql;
    private String xvtipol = "";
    private String xvcalidad = "";
    private String xv2b_primaria = "";
    private String xv2b_secundaria = "";
    private String xv2bprofusion = "";
    private String xv2copacidades = "";
    private String xv3b_e_v1 = "";
    private String xv3b_e_r1 = "";
    private String xv3b_e_v2 = "";
    private String xv3b_e_r2 = "";
    private String xv3b_a_v1 = "";
    private String xv3b_a_r1 = "";
    private String xv3b_a_v2 = "";
    private String xv3b_a_r2 = "";
    private String xv3d_e_v1 = "";
    private String xv3d_e_r1 = "";
    private String xv3d_e_v2 = "";
    private String xv3d_e_r2 = "";
    private String xv3d_a_v1 = "";
    private String xv3d_a_r1 = "";
    private String xv3d_a_v2 = "";
    private String xv3d_a_r2 = "";
    private int xvta = 0;
    private int xvtb = 0;
    private int xvtf = 0;
    private int xvc_1 = 0;
    private int xvc_2 = 0;
    private int xvc_3 = 0;
    private int xvc_4 = 0;
    private int xv1_4 = 0;
    private int xv1_5 = 0;
    private int xv1_6 = 0;
    private int xv1_7 = 0;
    private int xv1_8 = 0;
    private int xv1_9 = 0;
    private int xv1_10 = 0;
    private int xv1_11 = 0;
    private int xv1_12 = 0;
    private int xv1_13 = 0;
    private int xv2a = 0;
    private int xv2b_superiorR = 0;
    private int xv2b_superiorL = 0;
    private int xv2b_mediaR = 0;
    private int xv2b_mediaL = 0;
    private int xv2b_inferiorR = 0;
    private int xv2b_inferiorL = 0;
    private int xv3a_respuesta = 0;
    private int xv2b_pp = 0;
    private int xv2b_pq = 0;
    private int xv2b_pr = 0;
    private int xv2b_ps = 0;
    private int xv2b_pt = 0;
    private int xv2b_pu = 0;
    private int xv2b_sp = 0;
    private int xv2b_sq = 0;
    private int xv2b_sr = 0;
    private int xv2b_ss = 0;
    private int xv2b_st = 0;
    private int xv2b_su = 0;
    private int xv2b_p0 = 0;
    private int xv2b_p00 = 0;
    private int xv2b_p01 = 0;
    private int xv2b_p10 = 0;
    private int xv2b_p11 = 0;
    private int xv2b_p12 = 0;
    private int xv2b_p21 = 0;
    private int xv2b_p22 = 0;
    private int xv2b_p23 = 0;
    private int xv2b_p32 = 0;
    private int xv2b_p33 = 0;
    private int xv2b_p34 = 0;
    private int xv2C_oo = 0;
    private int xv2C_oa = 0;
    private int xv2C_ob = 0;
    private int xv2C_oc = 0;
    private int xv3b_spo = 0;
    private int xv3b_spr = 0;
    private int xv3b_spl = 0;
    private int xv3b_sfo = 0;
    private int xv3b_sfr = 0;
    private int xv3b_sfl = 0;
    private int xv3b_sdo = 0;
    private int xv3b_sdr = 0;
    private int xv3b_sdl = 0;
    private int xv3b_soo = 0;
    private int xv3b_sor = 0;
    private int xv3b_sol = 0;
    private int xv3b_cpo = 0;
    private int xv3b_cpr = 0;
    private int xv3b_cpl = 0;
    private int xv3b_cfo = 0;
    private int xv3b_cfr = 0;
    private int xv3b_cfl = 0;
    private int xv3b_cdo = 0;
    private int xv3b_cdr = 0;
    private int xv3b_cdl = 0;
    private int xv3b_coo = 0;
    private int xv3b_cor = 0;
    private int xv3b_col = 0;
    private int xv3be_o = 0;
    private int xv3be_r = 0;
    private int xv3be_v1 = 0;
    private int xv3be_v2 = 0;
    private int xv3be_v3 = 0;
    private int xv3be_o_1 = 0;
    private int xv3be_l = 0;
    private int xv3be_v1_1 = 0;
    private int xv3be_v2_2 = 0;
    private int xv3be_v3_3 = 0;
    private int xv3ba_o = 0;
    private int xv3ba_r = 0;
    private int xv3ba_va = 0;
    private int xv3ba_vb = 0;
    private int xv3ba_vc = 0;
    private int xv3ba_o_1 = 0;
    private int xv3ba_l = 0;
    private int xv3ba_va_1 = 0;
    private int xv3be_vb_2 = 0;
    private int xv3be_vc_3 = 0;
    private int xv3de_o = 0;
    private int xv3de_r = 0;
    private int xv3de_v1 = 0;
    private int xv3de_v2 = 0;
    private int xv3de_v3 = 0;
    private int xv3de_o_1 = 0;
    private int xv3de_l = 0;
    private int xv3de_v1_1 = 0;
    private int xv3de_v2_2 = 0;
    private int xv3de_v3_3 = 0;
    private int xv3da_o = 0;
    private int xv3da_r = 0;
    private int xv3da_va = 0;
    private int xv3da_vb = 0;
    private int xv3da_vc = 0;
    private int xv3da_o_1 = 0;
    private int xv3da_l = 0;
    private int xv3da_va_1 = 0;
    private int xv3de_vb_2 = 0;
    private int xv3de_vc_3 = 0;
    private int xv3c_valor = 0;
    private int xv3d_spo = 0;
    private int xv3d_spr = 0;
    private int xv3d_spl = 0;
    private int xv3d_sfo = 0;
    private int xv3d_sfr = 0;
    private int xv3d_sfl = 0;
    private int xv3d_cpo = 0;
    private int xv3d_cpr = 0;
    private int xv3d_cpl = 0;
    private int xv3d_cfo = 0;
    private int xv3d_cfr = 0;
    private int xv3d_cfl = 0;
    private int xv4a_valor = 0;
    private int xv4e_valor = 0;
    private ConsultasMySQL xct = new ConsultasMySQL();
    private Metodos xmt = new Metodos();
    public Persona xjppersona;
    private long xidempresa;
    private long xidingreso;
    private DefaultTableModel xmodelo4B;
    private DefaultTableModel xmodelo4C;
    private DefaultTableModel xmodeloH;
    private Object[] xdatos;
    private String xidestudio;
    private ButtonGroup JBG0Tipo;
    private ButtonGroup JBG1Calidad;
    private ButtonGroup JBG2A;
    private ButtonGroup JBG2BP;
    private ButtonGroup JBG2BProfusion;
    private ButtonGroup JBG2BS;
    private ButtonGroup JBG2COpacidades;
    private ButtonGroup JBG3A;
    private ButtonGroup JBG3BAR1;
    private ButtonGroup JBG3BAR2;
    private ButtonGroup JBG3BAV1;
    private ButtonGroup JBG3BAV2;
    private ButtonGroup JBG3BER1;
    private ButtonGroup JBG3BER2;
    private ButtonGroup JBG3BEV1;
    private ButtonGroup JBG3BEV2;
    private ButtonGroup JBG3DAR3;
    private ButtonGroup JBG3DAR4;
    private ButtonGroup JBG3DAV3;
    private ButtonGroup JBG3DAV4;
    private ButtonGroup JBG3DER1;
    private ButtonGroup JBG3DER2;
    private ButtonGroup JBG3DEV1;
    private ButtonGroup JBG3DEV2;
    private ButtonGroup JBG4A;
    private ButtonGroup JBG4E;
    private JCheckBox JCH0A;
    private JCheckBox JCH0B;
    private JCheckBox JCH0C;
    private JCheckBox JCH1_1;
    private JCheckBox JCH1_10Espirada;
    private JCheckBox JCH1_11Moteada;
    private JCheckBox JCH1_12Otra;
    private JCheckBox JCH1_2;
    private JCheckBox JCH1_3;
    private JCheckBox JCH1_4SobreExposicion;
    private JCheckBox JCH1_5SubExposicion;
    private JCheckBox JCH1_6Artefactos;
    private JCheckBox JCH1_7PosicionIncorrecta;
    private JCheckBox JCH1_8PobreContraste;
    private JCheckBox JCH1_9PobreProcesamiento;
    private JCheckBox JCH1_UR;
    private JCheckBox JCH2A_No;
    private JCheckBox JCH2A_Si;
    private JCheckBox JCH2B_P_0;
    private JCheckBox JCH2B_P_00;
    private JCheckBox JCH2B_P_01;
    private JCheckBox JCH2B_P_10;
    private JCheckBox JCH2B_P_11;
    private JCheckBox JCH2B_P_12;
    private JCheckBox JCH2B_P_21;
    private JCheckBox JCH2B_P_22;
    private JCheckBox JCH2B_P_23;
    private JCheckBox JCH2B_P_32;
    private JCheckBox JCH2B_P_33;
    private JCheckBox JCH2B_P_34;
    private JCheckBox JCH2B_Pp;
    private JCheckBox JCH2B_Pq;
    private JCheckBox JCH2B_Pr;
    private JCheckBox JCH2B_Ps;
    private JCheckBox JCH2B_Pt;
    private JCheckBox JCH2B_Pu;
    private JCheckBox JCH2B_Sp;
    private JCheckBox JCH2B_Sq;
    private JCheckBox JCH2B_Sr;
    private JCheckBox JCH2B_Ss;
    private JCheckBox JCH2B_St;
    private JCheckBox JCH2B_Su;
    private JCheckBox JCH2B_ZIL;
    private JCheckBox JCH2B_ZIR;
    private JCheckBox JCH2B_ZML;
    private JCheckBox JCH2B_ZMR;
    private JCheckBox JCH2B_ZSL;
    private JCheckBox JCH2B_ZSR;
    private JCheckBox JCH2C_A;
    private JCheckBox JCH2C_B;
    private JCheckBox JCH2C_C;
    private JCheckBox JCH2C_O;
    private JCheckBox JCH3A_No;
    private JCheckBox JCH3A_Si;
    private JCheckBox JCH3B_Ancho_L2;
    private JCheckBox JCH3B_Ancho_O1;
    private JCheckBox JCH3B_Ancho_O2;
    private JCheckBox JCH3B_Ancho_R1;
    private JCheckBox JCH3B_CD_L;
    private JCheckBox JCH3B_CD_O;
    private JCheckBox JCH3B_CD_R;
    private JCheckBox JCH3B_CF_L;
    private JCheckBox JCH3B_CF_O;
    private JCheckBox JCH3B_CF_R;
    private JCheckBox JCH3B_CO_L;
    private JCheckBox JCH3B_CO_O;
    private JCheckBox JCH3B_CO_R;
    private JCheckBox JCH3B_CP_L;
    private JCheckBox JCH3B_CP_O;
    private JCheckBox JCH3B_CP_R;
    private JCheckBox JCH3B_Extension_L1;
    private JCheckBox JCH3B_Extension_O;
    private JCheckBox JCH3B_Extension_O1;
    private JCheckBox JCH3B_Extension_R;
    private JCheckBox JCH3B_SD_L;
    private JCheckBox JCH3B_SD_O;
    private JCheckBox JCH3B_SD_R;
    private JCheckBox JCH3B_SF_L;
    private JCheckBox JCH3B_SF_O;
    private JCheckBox JCH3B_SF_R;
    private JCheckBox JCH3B_SO_L;
    private JCheckBox JCH3B_SO_O;
    private JCheckBox JCH3B_SO_R;
    private JCheckBox JCH3B_SP_L;
    private JCheckBox JCH3B_SP_O;
    private JCheckBox JCH3B_SP_R;
    private JCheckBox JCH3B_V_A1;
    private JCheckBox JCH3B_V_A2;
    private JCheckBox JCH3B_V_A3;
    private JCheckBox JCH3B_V_A4;
    private JCheckBox JCH3B_V_A5;
    private JCheckBox JCH3B_V_A6;
    private JCheckBox JCH3B_V_E1;
    private JCheckBox JCH3B_V_E2;
    private JCheckBox JCH3B_V_E3;
    private JCheckBox JCH3B_V_E4;
    private JCheckBox JCH3B_V_E5;
    private JCheckBox JCH3B_V_E6;
    private JCheckBox JCH3C_L;
    private JCheckBox JCH3C_No;
    private JCheckBox JCH3C_R;
    private JCheckBox JCH3DC_SP_O;
    private JCheckBox JCH3DC_SP_R;
    private JCheckBox JCH3D_Ancho_L;
    private JCheckBox JCH3D_Ancho_O;
    private JCheckBox JCH3D_Ancho_O1;
    private JCheckBox JCH3D_Ancho_R;
    private JCheckBox JCH3D_CF_L;
    private JCheckBox JCH3D_CF_O;
    private JCheckBox JCH3D_CF_R;
    private JCheckBox JCH3D_CP_L;
    private JCheckBox JCH3D_CP_O;
    private JCheckBox JCH3D_CP_R;
    private JCheckBox JCH3D_Extension_L1;
    private JCheckBox JCH3D_Extension_O;
    private JCheckBox JCH3D_Extension_O1;
    private JCheckBox JCH3D_Extension_R;
    private JCheckBox JCH3D_SF_L;
    private JCheckBox JCH3D_SF_O;
    private JCheckBox JCH3D_SF_R;
    private JCheckBox JCH3D_SP_L;
    private JCheckBox JCH3D_V_E1;
    private JCheckBox JCH3D_V_E2;
    private JCheckBox JCH3D_V_E3;
    private JCheckBox JCH3D_V_E4;
    private JCheckBox JCH3D_V_E5;
    private JCheckBox JCH3D_V_E6;
    private JCheckBox JCH3D_V_a;
    private JCheckBox JCH3D_V_a1;
    private JCheckBox JCH3D_V_b;
    private JCheckBox JCH3D_V_b1;
    private JCheckBox JCH3D_V_c;
    private JCheckBox JCH3D_V_c1;
    private JCheckBox JCH4A_No;
    private JCheckBox JCH4A_Si;
    private JCheckBox JCH4E_No;
    private JCheckBox JCH4E_Si;
    public JDateChooser JDCFecha;
    private JLabel JLB2A_Pregunta;
    private JLabel JLB2BPrimaria;
    private JLabel JLB2BProfusion;
    private JLabel JLB2BSecundaria;

    /* JADX INFO: renamed from: JLB2BTamaño, reason: contains not printable characters */
    private JLabel f12JLB2BTamao;
    private JLabel JLB2BZona;
    private JLabel JLB2BZona_RL;

    /* JADX INFO: renamed from: JLB2CTamaño, reason: contains not printable characters */
    private JLabel f13JLB2CTamao;
    private JLabel JLB3A_Pregunta;
    private JLabel JLB3BCalcificacion;
    private JLabel JLB3BDiafragma;
    private JLabel JLB3BExtension;
    private JLabel JLB3BExtension1;
    private JLabel JLB3BExtension3;
    private JLabel JLB3BFrente;
    private JLabel JLB3BOtroSitio;
    private JLabel JLB3BParedToracica;
    private JLabel JLB3BPerfil;
    private JLabel JLB3C_Pregunta;
    private JLabel JLB3DCalcificacion;
    private JLabel JLB3DExtension;
    private JLabel JLB3DFrente;
    private JLabel JLB3DParedToracica;
    private JLabel JLB3DPerfil;
    private JLabel JLB4A_Pregunta;
    private JLabel JLB4E_Pregunta;
    private JPanel JPI1CalidadP;
    private JPanel JPI2A;
    private JPanel JPI2B;
    private JPanel JPI2COpacidadesG;
    private JPanel JPI3A;
    private JPanel JPI3BPlacas;
    private JPanel JPI3C;
    private JPanel JPI3DEngrosamientoPD;
    private JPanel JPI4A;
    private JPanel JPI4E;
    private JPanel JPIHistorico;
    private JPanel JPILectura;
    private JPanel JPISeccion2;
    private JPanel JPITipo;
    public JPanel JPNVentana;
    private JPanel JPPersona;
    private JScrollPane JSP1_13_Cual;
    private JScrollPane JSP4B;
    private JScrollPane JSP4C;
    private JScrollPane JSP4D;
    private JScrollPane JSPDHistorico;
    private JTable JT4B;
    private JTable JT4C;
    private JTextArea JTA1_13_Cual;
    private JTextArea JTA4D;
    private JTable JTDHistorico;
    private JTabbedPane JTPDetalle;
    private JTabbedPane JTPRegistro;
    private JSeparator jSeparator1;
    private JSeparator jSeparator2;
    private JSeparator jSeparator3;
    private JSeparator jSeparator4;
    private JSeparator jSeparator5;
    private JSeparator jSeparator6;

    public JIFLecturaPlacaOit(String xnhc, String xidestudio) {
        this.xidestudio = "0";
        initComponents();
        mCargarPanelPersonas();
        this.xidestudio = xidestudio;
        this.xjppersona.txtHistoria.setText(xnhc);
        this.xjppersona.buscar(2);
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v614, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v620, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v676, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBG0Tipo = new ButtonGroup();
        this.JBG1Calidad = new ButtonGroup();
        this.JBG2A = new ButtonGroup();
        this.JBG2BP = new ButtonGroup();
        this.JBG2BS = new ButtonGroup();
        this.JBG2BProfusion = new ButtonGroup();
        this.JBG2COpacidades = new ButtonGroup();
        this.JBG3A = new ButtonGroup();
        this.JBG3BEV1 = new ButtonGroup();
        this.JBG3BER1 = new ButtonGroup();
        this.JBG3BEV2 = new ButtonGroup();
        this.JBG3BER2 = new ButtonGroup();
        this.JBG3BAV1 = new ButtonGroup();
        this.JBG3BAR1 = new ButtonGroup();
        this.JBG3BAV2 = new ButtonGroup();
        this.JBG3BAR2 = new ButtonGroup();
        this.JBG3DEV1 = new ButtonGroup();
        this.JBG3DER1 = new ButtonGroup();
        this.JBG3DEV2 = new ButtonGroup();
        this.JBG3DER2 = new ButtonGroup();
        this.JBG3DAV3 = new ButtonGroup();
        this.JBG3DAR3 = new ButtonGroup();
        this.JBG3DAV4 = new ButtonGroup();
        this.JBG3DAR4 = new ButtonGroup();
        this.JBG4A = new ButtonGroup();
        this.JBG4E = new ButtonGroup();
        this.JPPersona = new JPanel();
        this.JTPRegistro = new JTabbedPane();
        this.JPILectura = new JPanel();
        this.JTPDetalle = new JTabbedPane();
        this.JPNVentana = new JPanel();
        this.JPITipo = new JPanel();
        this.JCH0A = new JCheckBox();
        this.JCH0B = new JCheckBox();
        this.JCH0C = new JCheckBox();
        this.JPI1CalidadP = new JPanel();
        this.JCH1_1 = new JCheckBox();
        this.JCH1_2 = new JCheckBox();
        this.JCH1_3 = new JCheckBox();
        this.JCH1_UR = new JCheckBox();
        this.JCH1_4SobreExposicion = new JCheckBox();
        this.JCH1_5SubExposicion = new JCheckBox();
        this.JCH1_6Artefactos = new JCheckBox();
        this.JCH1_7PosicionIncorrecta = new JCheckBox();
        this.JCH1_8PobreContraste = new JCheckBox();
        this.JCH1_9PobreProcesamiento = new JCheckBox();
        this.JCH1_10Espirada = new JCheckBox();
        this.JCH1_11Moteada = new JCheckBox();
        this.JCH1_12Otra = new JCheckBox();
        this.JSP1_13_Cual = new JScrollPane();
        this.JTA1_13_Cual = new JTextArea();
        this.JDCFecha = new JDateChooser();
        this.JPI2A = new JPanel();
        this.JLB2A_Pregunta = new JLabel();
        this.JCH2A_Si = new JCheckBox();
        this.JCH2A_No = new JCheckBox();
        this.JPI2B = new JPanel();
        this.f12JLB2BTamao = new JLabel();
        this.JLB2BPrimaria = new JLabel();
        this.JCH2B_Pp = new JCheckBox();
        this.JCH2B_Pq = new JCheckBox();
        this.JCH2B_Pr = new JCheckBox();
        this.JCH2B_Ps = new JCheckBox();
        this.JCH2B_Pt = new JCheckBox();
        this.JCH2B_Pu = new JCheckBox();
        this.JLB2BSecundaria = new JLabel();
        this.JCH2B_Sp = new JCheckBox();
        this.JCH2B_Ss = new JCheckBox();
        this.JCH2B_Sq = new JCheckBox();
        this.JCH2B_St = new JCheckBox();
        this.JCH2B_Sr = new JCheckBox();
        this.JCH2B_Su = new JCheckBox();
        this.JCH2B_ZSR = new JCheckBox();
        this.JCH2B_ZMR = new JCheckBox();
        this.JCH2B_ZIR = new JCheckBox();
        this.JLB2BZona_RL = new JLabel();
        this.JLB2BZona = new JLabel();
        this.JCH2B_ZSL = new JCheckBox();
        this.JCH2B_ZML = new JCheckBox();
        this.JCH2B_ZIL = new JCheckBox();
        this.JLB2BProfusion = new JLabel();
        this.JCH2B_P_0 = new JCheckBox();
        this.JCH2B_P_00 = new JCheckBox();
        this.JCH2B_P_01 = new JCheckBox();
        this.JCH2B_P_10 = new JCheckBox();
        this.JCH2B_P_11 = new JCheckBox();
        this.JCH2B_P_12 = new JCheckBox();
        this.JCH2B_P_21 = new JCheckBox();
        this.JCH2B_P_22 = new JCheckBox();
        this.JCH2B_P_23 = new JCheckBox();
        this.JCH2B_P_32 = new JCheckBox();
        this.JCH2B_P_33 = new JCheckBox();
        this.JCH2B_P_34 = new JCheckBox();
        this.JPI2COpacidadesG = new JPanel();
        this.f13JLB2CTamao = new JLabel();
        this.JCH2C_O = new JCheckBox();
        this.JCH2C_A = new JCheckBox();
        this.JCH2C_B = new JCheckBox();
        this.JCH2C_C = new JCheckBox();
        this.JPI3A = new JPanel();
        this.JLB3A_Pregunta = new JLabel();
        this.JCH3A_Si = new JCheckBox();
        this.JCH3A_No = new JCheckBox();
        this.JPI3BPlacas = new JPanel();
        this.JLB3BParedToracica = new JLabel();
        this.JCH3B_SP_O = new JCheckBox();
        this.JCH3B_SP_R = new JCheckBox();
        this.JCH3B_SP_L = new JCheckBox();
        this.JCH3B_SF_O = new JCheckBox();
        this.JCH3B_SF_R = new JCheckBox();
        this.JCH3B_SF_L = new JCheckBox();
        this.JCH3B_SD_O = new JCheckBox();
        this.JCH3B_SD_R = new JCheckBox();
        this.JCH3B_SD_L = new JCheckBox();
        this.JCH3B_SO_O = new JCheckBox();
        this.JCH3B_SO_L = new JCheckBox();
        this.JCH3B_SO_R = new JCheckBox();
        this.JLB3BPerfil = new JLabel();
        this.JLB3BFrente = new JLabel();
        this.JLB3BDiafragma = new JLabel();
        this.JLB3BOtroSitio = new JLabel();
        this.jSeparator1 = new JSeparator();
        this.JLB3BCalcificacion = new JLabel();
        this.JCH3B_CP_O = new JCheckBox();
        this.JCH3B_CF_O = new JCheckBox();
        this.JCH3B_CD_O = new JCheckBox();
        this.JCH3B_CO_O = new JCheckBox();
        this.JCH3B_CP_R = new JCheckBox();
        this.JCH3B_CF_R = new JCheckBox();
        this.JCH3B_CD_R = new JCheckBox();
        this.JCH3B_CO_R = new JCheckBox();
        this.JCH3B_CP_L = new JCheckBox();
        this.JCH3B_CF_L = new JCheckBox();
        this.JCH3B_CD_L = new JCheckBox();
        this.JCH3B_CO_L = new JCheckBox();
        this.jSeparator2 = new JSeparator();
        this.JLB3BExtension = new JLabel();
        this.JCH3B_Extension_O = new JCheckBox();
        this.JCH3B_Extension_R = new JCheckBox();
        this.JCH3B_V_E1 = new JCheckBox();
        this.JCH3B_V_E2 = new JCheckBox();
        this.JCH3B_V_E3 = new JCheckBox();
        this.JCH3B_Extension_O1 = new JCheckBox();
        this.JCH3B_Extension_L1 = new JCheckBox();
        this.JCH3B_V_E4 = new JCheckBox();
        this.JCH3B_V_E5 = new JCheckBox();
        this.JCH3B_V_E6 = new JCheckBox();
        this.jSeparator3 = new JSeparator();
        this.JLB3BExtension1 = new JLabel();
        this.JCH3B_Ancho_O1 = new JCheckBox();
        this.JCH3B_Ancho_R1 = new JCheckBox();
        this.JCH3B_V_A1 = new JCheckBox();
        this.JCH3B_V_A2 = new JCheckBox();
        this.JCH3B_V_A3 = new JCheckBox();
        this.JCH3B_Ancho_O2 = new JCheckBox();
        this.JCH3B_Ancho_L2 = new JCheckBox();
        this.JCH3B_V_A4 = new JCheckBox();
        this.JCH3B_V_A5 = new JCheckBox();
        this.JCH3B_V_A6 = new JCheckBox();
        this.JPISeccion2 = new JPanel();
        this.JPI3C = new JPanel();
        this.JLB3C_Pregunta = new JLabel();
        this.JCH3C_R = new JCheckBox();
        this.JCH3C_L = new JCheckBox();
        this.JCH3C_No = new JCheckBox();
        this.JPI3DEngrosamientoPD = new JPanel();
        this.JLB3DParedToracica = new JLabel();
        this.JCH3DC_SP_O = new JCheckBox();
        this.JCH3DC_SP_R = new JCheckBox();
        this.JCH3D_SP_L = new JCheckBox();
        this.JCH3D_SF_O = new JCheckBox();
        this.JCH3D_SF_R = new JCheckBox();
        this.JCH3D_SF_L = new JCheckBox();
        this.JLB3DPerfil = new JLabel();
        this.JLB3DFrente = new JLabel();
        this.jSeparator4 = new JSeparator();
        this.JLB3DCalcificacion = new JLabel();
        this.JCH3D_CP_O = new JCheckBox();
        this.JCH3D_CF_O = new JCheckBox();
        this.JCH3D_CP_R = new JCheckBox();
        this.JCH3D_CF_R = new JCheckBox();
        this.JCH3D_CP_L = new JCheckBox();
        this.JCH3D_CF_L = new JCheckBox();
        this.jSeparator5 = new JSeparator();
        this.JLB3DExtension = new JLabel();
        this.JCH3D_Extension_O = new JCheckBox();
        this.JCH3D_Extension_R = new JCheckBox();
        this.JCH3D_V_E1 = new JCheckBox();
        this.JCH3D_V_E2 = new JCheckBox();
        this.JCH3D_V_E3 = new JCheckBox();
        this.JCH3D_Extension_O1 = new JCheckBox();
        this.JCH3D_Extension_L1 = new JCheckBox();
        this.JCH3D_V_E4 = new JCheckBox();
        this.JCH3D_V_E5 = new JCheckBox();
        this.JCH3D_V_E6 = new JCheckBox();
        this.jSeparator6 = new JSeparator();
        this.JLB3BExtension3 = new JLabel();
        this.JCH3D_Ancho_O = new JCheckBox();
        this.JCH3D_Ancho_R = new JCheckBox();
        this.JCH3D_V_a = new JCheckBox();
        this.JCH3D_V_b = new JCheckBox();
        this.JCH3D_V_c = new JCheckBox();
        this.JCH3D_Ancho_O1 = new JCheckBox();
        this.JCH3D_Ancho_L = new JCheckBox();
        this.JCH3D_V_a1 = new JCheckBox();
        this.JCH3D_V_b1 = new JCheckBox();
        this.JCH3D_V_c1 = new JCheckBox();
        this.JPI4A = new JPanel();
        this.JLB4A_Pregunta = new JLabel();
        this.JCH4A_Si = new JCheckBox();
        this.JCH4A_No = new JCheckBox();
        this.JSP4B = new JScrollPane();
        this.JT4B = new JTable();
        this.JSP4C = new JScrollPane();
        this.JT4C = new JTable();
        this.JSP4D = new JScrollPane();
        this.JTA4D = new JTextArea();
        this.JPI4E = new JPanel();
        this.JLB4E_Pregunta = new JLabel();
        this.JCH4E_Si = new JCheckBox();
        this.JCH4E_No = new JCheckBox();
        this.JPIHistorico = new JPanel();
        this.JSPDHistorico = new JScrollPane();
        this.JTDHistorico = new JTable();
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("LECTURA DE PLACA - FORMATO OIT");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjiflecturaoit");
        setPreferredSize(new Dimension(1038, 837));
        addInternalFrameListener(new InternalFrameListener() { // from class: ImagenesDx.JIFLecturaPlacaOit.1
            public void internalFrameActivated(InternalFrameEvent evt) {
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIFLecturaPlacaOit.this.formInternalFrameClosing(evt);
            }

            public void internalFrameDeactivated(InternalFrameEvent evt) {
            }

            public void internalFrameDeiconified(InternalFrameEvent evt) {
            }

            public void internalFrameIconified(InternalFrameEvent evt) {
            }

            public void internalFrameOpened(InternalFrameEvent evt) {
            }
        });
        this.JPPersona.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS DE USUARIO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JPPersona.setMaximumSize(new Dimension(1000, 160));
        this.JPPersona.setMinimumSize(new Dimension(1000, 160));
        this.JPPersona.setPreferredSize(new Dimension(1000, 160));
        GroupLayout JPPersonaLayout = new GroupLayout(this.JPPersona);
        this.JPPersona.setLayout(JPPersonaLayout);
        JPPersonaLayout.setHorizontalGroup(JPPersonaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 0, 32767));
        JPPersonaLayout.setVerticalGroup(JPPersonaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 164, 32767));
        this.JTPRegistro.setForeground(new Color(0, 103, 0));
        this.JTPRegistro.setFont(new Font("Arial", 1, 14));
        this.JTPDetalle.setForeground(new Color(255, 0, 0));
        this.JTPDetalle.setFont(new Font("Arial", 1, 14));
        this.JPNVentana.setBorder(BorderFactory.createTitledBorder(""));
        this.JPITipo.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo", 1, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JBG0Tipo.add(this.JCH0A);
        this.JCH0A.setFont(new Font("Arial", 1, 12));
        this.JCH0A.setText("A");
        this.JCH0A.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFLecturaPlacaOit.2
            public void actionPerformed(ActionEvent evt) {
                JIFLecturaPlacaOit.this.JCH0AActionPerformed(evt);
            }
        });
        this.JBG0Tipo.add(this.JCH0B);
        this.JCH0B.setFont(new Font("Arial", 1, 12));
        this.JCH0B.setText("B");
        this.JCH0B.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFLecturaPlacaOit.3
            public void actionPerformed(ActionEvent evt) {
                JIFLecturaPlacaOit.this.JCH0BActionPerformed(evt);
            }
        });
        this.JBG0Tipo.add(this.JCH0C);
        this.JCH0C.setFont(new Font("Arial", 1, 12));
        this.JCH0C.setText("C");
        this.JCH0C.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFLecturaPlacaOit.4
            public void actionPerformed(ActionEvent evt) {
                JIFLecturaPlacaOit.this.JCH0CActionPerformed(evt);
            }
        });
        GroupLayout JPITipoLayout = new GroupLayout(this.JPITipo);
        this.JPITipo.setLayout(JPITipoLayout);
        JPITipoLayout.setHorizontalGroup(JPITipoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPITipoLayout.createSequentialGroup().addContainerGap().addComponent(this.JCH0A).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCH0B).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCH0C).addContainerGap(-1, 32767)));
        JPITipoLayout.setVerticalGroup(JPITipoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPITipoLayout.createSequentialGroup().addGroup(JPITipoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCH0B).addComponent(this.JCH0A).addComponent(this.JCH0C)).addGap(0, 5, 32767)));
        this.JPI1CalidadP.setBorder(BorderFactory.createTitledBorder((Border) null, "1. CALIDAD DE LA PLACA", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JBG1Calidad.add(this.JCH1_1);
        this.JCH1_1.setFont(new Font("Arial", 1, 12));
        this.JCH1_1.setText("1");
        this.JCH1_1.setHorizontalTextPosition(0);
        this.JCH1_1.setVerticalTextPosition(1);
        this.JCH1_1.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFLecturaPlacaOit.5
            public void actionPerformed(ActionEvent evt) {
                JIFLecturaPlacaOit.this.JCH1_1ActionPerformed(evt);
            }
        });
        this.JBG1Calidad.add(this.JCH1_2);
        this.JCH1_2.setFont(new Font("Arial", 1, 12));
        this.JCH1_2.setText("2");
        this.JCH1_2.setHorizontalTextPosition(0);
        this.JCH1_2.setVerticalTextPosition(1);
        this.JCH1_2.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFLecturaPlacaOit.6
            public void actionPerformed(ActionEvent evt) {
                JIFLecturaPlacaOit.this.JCH1_2ActionPerformed(evt);
            }
        });
        this.JBG1Calidad.add(this.JCH1_3);
        this.JCH1_3.setFont(new Font("Arial", 1, 12));
        this.JCH1_3.setText("3");
        this.JCH1_3.setHorizontalTextPosition(0);
        this.JCH1_3.setVerticalTextPosition(1);
        this.JCH1_3.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFLecturaPlacaOit.7
            public void actionPerformed(ActionEvent evt) {
                JIFLecturaPlacaOit.this.JCH1_3ActionPerformed(evt);
            }
        });
        this.JBG1Calidad.add(this.JCH1_UR);
        this.JCH1_UR.setFont(new Font("Arial", 1, 12));
        this.JCH1_UR.setText("U/R");
        this.JCH1_UR.setHorizontalTextPosition(0);
        this.JCH1_UR.setVerticalTextPosition(1);
        this.JCH1_UR.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFLecturaPlacaOit.8
            public void actionPerformed(ActionEvent evt) {
                JIFLecturaPlacaOit.this.JCH1_URActionPerformed(evt);
            }
        });
        this.JCH1_4SobreExposicion.setFont(new Font("Arial", 1, 12));
        this.JCH1_4SobreExposicion.setText("Sobreexposición (oscura)");
        this.JCH1_4SobreExposicion.setHorizontalAlignment(0);
        this.JCH1_4SobreExposicion.setHorizontalTextPosition(4);
        this.JCH1_4SobreExposicion.setVerticalTextPosition(1);
        this.JCH1_4SobreExposicion.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFLecturaPlacaOit.9
            public void actionPerformed(ActionEvent evt) {
                JIFLecturaPlacaOit.this.JCH1_4SobreExposicionActionPerformed(evt);
            }
        });
        this.JCH1_5SubExposicion.setFont(new Font("Arial", 1, 12));
        this.JCH1_5SubExposicion.setText("Subexposición (clara)");
        this.JCH1_5SubExposicion.setHorizontalAlignment(0);
        this.JCH1_5SubExposicion.setHorizontalTextPosition(4);
        this.JCH1_5SubExposicion.setVerticalTextPosition(1);
        this.JCH1_5SubExposicion.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFLecturaPlacaOit.10
            public void actionPerformed(ActionEvent evt) {
                JIFLecturaPlacaOit.this.JCH1_5SubExposicionActionPerformed(evt);
            }
        });
        this.JCH1_6Artefactos.setFont(new Font("Arial", 1, 12));
        this.JCH1_6Artefactos.setText("Artefactos");
        this.JCH1_6Artefactos.setHorizontalAlignment(0);
        this.JCH1_6Artefactos.setHorizontalTextPosition(4);
        this.JCH1_6Artefactos.setVerticalTextPosition(1);
        this.JCH1_6Artefactos.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFLecturaPlacaOit.11
            public void actionPerformed(ActionEvent evt) {
                JIFLecturaPlacaOit.this.JCH1_6ArtefactosActionPerformed(evt);
            }
        });
        this.JCH1_7PosicionIncorrecta.setFont(new Font("Arial", 1, 12));
        this.JCH1_7PosicionIncorrecta.setText("Posición Incorrecta");
        this.JCH1_7PosicionIncorrecta.setHorizontalAlignment(0);
        this.JCH1_7PosicionIncorrecta.setHorizontalTextPosition(4);
        this.JCH1_7PosicionIncorrecta.setVerticalTextPosition(1);
        this.JCH1_7PosicionIncorrecta.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFLecturaPlacaOit.12
            public void actionPerformed(ActionEvent evt) {
                JIFLecturaPlacaOit.this.JCH1_7PosicionIncorrectaActionPerformed(evt);
            }
        });
        this.JCH1_8PobreContraste.setFont(new Font("Arial", 1, 12));
        this.JCH1_8PobreContraste.setText("Pobre Contraste");
        this.JCH1_8PobreContraste.setHorizontalAlignment(0);
        this.JCH1_8PobreContraste.setHorizontalTextPosition(4);
        this.JCH1_8PobreContraste.setVerticalTextPosition(1);
        this.JCH1_8PobreContraste.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFLecturaPlacaOit.13
            public void actionPerformed(ActionEvent evt) {
                JIFLecturaPlacaOit.this.JCH1_8PobreContrasteActionPerformed(evt);
            }
        });
        this.JCH1_9PobreProcesamiento.setFont(new Font("Arial", 1, 12));
        this.JCH1_9PobreProcesamiento.setText("Pobre Procesamiento");
        this.JCH1_9PobreProcesamiento.setHorizontalAlignment(0);
        this.JCH1_9PobreProcesamiento.setHorizontalTextPosition(4);
        this.JCH1_9PobreProcesamiento.setVerticalTextPosition(1);
        this.JCH1_9PobreProcesamiento.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFLecturaPlacaOit.14
            public void actionPerformed(ActionEvent evt) {
                JIFLecturaPlacaOit.this.JCH1_9PobreProcesamientoActionPerformed(evt);
            }
        });
        this.JCH1_10Espirada.setFont(new Font("Arial", 1, 12));
        this.JCH1_10Espirada.setText("Espirada");
        this.JCH1_10Espirada.setHorizontalAlignment(0);
        this.JCH1_10Espirada.setHorizontalTextPosition(4);
        this.JCH1_10Espirada.setVerticalTextPosition(1);
        this.JCH1_10Espirada.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFLecturaPlacaOit.15
            public void actionPerformed(ActionEvent evt) {
                JIFLecturaPlacaOit.this.JCH1_10EspiradaActionPerformed(evt);
            }
        });
        this.JCH1_11Moteada.setFont(new Font("Arial", 1, 12));
        this.JCH1_11Moteada.setText("Moteada");
        this.JCH1_11Moteada.setHorizontalAlignment(0);
        this.JCH1_11Moteada.setHorizontalTextPosition(4);
        this.JCH1_11Moteada.setVerticalTextPosition(1);
        this.JCH1_11Moteada.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFLecturaPlacaOit.16
            public void actionPerformed(ActionEvent evt) {
                JIFLecturaPlacaOit.this.JCH1_11MoteadaActionPerformed(evt);
            }
        });
        this.JCH1_12Otra.setFont(new Font("Arial", 1, 12));
        this.JCH1_12Otra.setText("Otra (especifique)");
        this.JCH1_12Otra.setHorizontalAlignment(0);
        this.JCH1_12Otra.setHorizontalTextPosition(4);
        this.JCH1_12Otra.setVerticalTextPosition(1);
        this.JCH1_12Otra.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFLecturaPlacaOit.17
            public void actionPerformed(ActionEvent evt) {
                JIFLecturaPlacaOit.this.JCH1_12OtraActionPerformed(evt);
            }
        });
        this.JSP1_13_Cual.setBorder(BorderFactory.createTitledBorder((Border) null, "Cual", 1, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTA1_13_Cual.setColumns(20);
        this.JTA1_13_Cual.setFont(new Font("Arial", 1, 14));
        this.JTA1_13_Cual.setLineWrap(true);
        this.JTA1_13_Cual.setRows(1);
        this.JTA1_13_Cual.setTabSize(1);
        this.JTA1_13_Cual.setBorder((Border) null);
        this.JSP1_13_Cual.setViewportView(this.JTA1_13_Cual);
        GroupLayout JPI1CalidadPLayout = new GroupLayout(this.JPI1CalidadP);
        this.JPI1CalidadP.setLayout(JPI1CalidadPLayout);
        JPI1CalidadPLayout.setHorizontalGroup(JPI1CalidadPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI1CalidadPLayout.createSequentialGroup().addContainerGap().addComponent(this.JCH1_1).addGap(10, 10, 10).addComponent(this.JCH1_2).addGap(10, 10, 10).addComponent(this.JCH1_3).addGap(10, 10, 10).addComponent(this.JCH1_UR, -2, 38, -2).addGap(26, 26, 26).addGroup(JPI1CalidadPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCH1_4SobreExposicion, -2, 184, -2).addComponent(this.JCH1_5SubExposicion, -2, 161, -2).addComponent(this.JCH1_6Artefactos, -2, 100, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPI1CalidadPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCH1_9PobreProcesamiento).addComponent(this.JCH1_8PobreContraste).addComponent(this.JCH1_7PosicionIncorrecta)).addGap(18, 18, 18).addGroup(JPI1CalidadPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCH1_12Otra).addComponent(this.JCH1_11Moteada).addComponent(this.JCH1_10Espirada)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JSP1_13_Cual, -2, 126, -2).addContainerGap()));
        JPI1CalidadPLayout.setVerticalGroup(JPI1CalidadPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI1CalidadPLayout.createSequentialGroup().addGroup(JPI1CalidadPLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSP1_13_Cual, -2, 71, -2).addGroup(JPI1CalidadPLayout.createSequentialGroup().addComponent(this.JCH1_10Espirada).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCH1_11Moteada).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCH1_12Otra)).addGroup(JPI1CalidadPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI1CalidadPLayout.createSequentialGroup().addContainerGap().addGroup(JPI1CalidadPLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCH1_1).addComponent(this.JCH1_2).addComponent(this.JCH1_3).addComponent(this.JCH1_UR))).addGroup(JPI1CalidadPLayout.createSequentialGroup().addComponent(this.JCH1_4SobreExposicion).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCH1_5SubExposicion).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCH1_6Artefactos)).addGroup(JPI1CalidadPLayout.createSequentialGroup().addComponent(this.JCH1_7PosicionIncorrecta).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCH1_8PobreContraste).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCH1_9PobreProcesamiento)))).addContainerGap(17, 32767)));
        this.JDCFecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFecha.setDateFormatString("dd/MM/yyyy");
        this.JDCFecha.setFont(new Font("Arial", 1, 12));
        this.JPI2A.setBorder(BorderFactory.createTitledBorder((Border) null, "2A.", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JLB2A_Pregunta.setFont(new Font("Arial", 1, 12));
        this.JLB2A_Pregunta.setForeground(Color.red);
        this.JLB2A_Pregunta.setText("Existen anormalidad parenquimatosas compatibles con neumoconiosis?");
        this.JBG2A.add(this.JCH2A_Si);
        this.JCH2A_Si.setFont(new Font("Arial", 1, 12));
        this.JCH2A_Si.setText("SI (complete secciones 2B y 2C)");
        this.JCH2A_Si.setHorizontalAlignment(0);
        this.JCH2A_Si.setHorizontalTextPosition(4);
        this.JCH2A_Si.setVerticalTextPosition(1);
        this.JCH2A_Si.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFLecturaPlacaOit.18
            public void actionPerformed(ActionEvent evt) {
                JIFLecturaPlacaOit.this.JCH2A_SiActionPerformed(evt);
            }
        });
        this.JBG2A.add(this.JCH2A_No);
        this.JCH2A_No.setFont(new Font("Arial", 1, 12));
        this.JCH2A_No.setText("NO (pase a sección 3A)");
        this.JCH2A_No.setHorizontalAlignment(0);
        this.JCH2A_No.setHorizontalTextPosition(4);
        this.JCH2A_No.setVerticalTextPosition(1);
        this.JCH2A_No.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFLecturaPlacaOit.19
            public void actionPerformed(ActionEvent evt) {
                JIFLecturaPlacaOit.this.JCH2A_NoActionPerformed(evt);
            }
        });
        GroupLayout JPI2ALayout = new GroupLayout(this.JPI2A);
        this.JPI2A.setLayout(JPI2ALayout);
        JPI2ALayout.setHorizontalGroup(JPI2ALayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI2ALayout.createSequentialGroup().addContainerGap().addComponent(this.JLB2A_Pregunta, -2, 453, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCH2A_Si).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JCH2A_No).addGap(28, 28, 28)));
        JPI2ALayout.setVerticalGroup(JPI2ALayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCH2A_Si, -2, 0, 32767).addComponent(this.JLB2A_Pregunta, -1, -1, 32767).addComponent(this.JCH2A_No, GroupLayout.Alignment.TRAILING, -2, 15, -2));
        this.JPI2B.setBorder(BorderFactory.createTitledBorder((Border) null, "2B. OPACIDADES PEQUEÑAS", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.f12JLB2BTamao.setFont(new Font("Arial", 1, 12));
        this.f12JLB2BTamao.setForeground(Color.blue);
        this.f12JLB2BTamao.setHorizontalAlignment(0);
        this.f12JLB2BTamao.setText("Tamaño y Forma");
        this.JLB2BPrimaria.setFont(new Font("Arial", 1, 12));
        this.JLB2BPrimaria.setForeground(Color.blue);
        this.JLB2BPrimaria.setHorizontalAlignment(0);
        this.JLB2BPrimaria.setText("Primaria");
        this.JBG2BP.add(this.JCH2B_Pp);
        this.JCH2B_Pp.setFont(new Font("Arial", 1, 12));
        this.JCH2B_Pp.setHorizontalAlignment(0);
        this.JCH2B_Pp.setHorizontalTextPosition(2);
        this.JCH2B_Pp.setIconTextGap(1);
        this.JCH2B_Pp.setLabel("p");
        this.JCH2B_Pp.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFLecturaPlacaOit.20
            public void actionPerformed(ActionEvent evt) {
                JIFLecturaPlacaOit.this.JCH2B_PpActionPerformed(evt);
            }
        });
        this.JBG2BP.add(this.JCH2B_Pq);
        this.JCH2B_Pq.setFont(new Font("Arial", 1, 12));
        this.JCH2B_Pq.setHorizontalAlignment(0);
        this.JCH2B_Pq.setHorizontalTextPosition(2);
        this.JCH2B_Pq.setIconTextGap(1);
        this.JCH2B_Pq.setLabel("q");
        this.JCH2B_Pq.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFLecturaPlacaOit.21
            public void actionPerformed(ActionEvent evt) {
                JIFLecturaPlacaOit.this.JCH2B_PqActionPerformed(evt);
            }
        });
        this.JBG2BP.add(this.JCH2B_Pr);
        this.JCH2B_Pr.setFont(new Font("Arial", 1, 12));
        this.JCH2B_Pr.setHorizontalAlignment(0);
        this.JCH2B_Pr.setHorizontalTextPosition(2);
        this.JCH2B_Pr.setIconTextGap(1);
        this.JCH2B_Pr.setLabel("r");
        this.JCH2B_Pr.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFLecturaPlacaOit.22
            public void actionPerformed(ActionEvent evt) {
                JIFLecturaPlacaOit.this.JCH2B_PrActionPerformed(evt);
            }
        });
        this.JBG2BP.add(this.JCH2B_Ps);
        this.JCH2B_Ps.setFont(new Font("Arial", 1, 12));
        this.JCH2B_Ps.setText("s");
        this.JCH2B_Ps.setHorizontalAlignment(0);
        this.JCH2B_Ps.setHorizontalTextPosition(2);
        this.JCH2B_Ps.setIconTextGap(1);
        this.JCH2B_Ps.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFLecturaPlacaOit.23
            public void actionPerformed(ActionEvent evt) {
                JIFLecturaPlacaOit.this.JCH2B_PsActionPerformed(evt);
            }
        });
        this.JBG2BP.add(this.JCH2B_Pt);
        this.JCH2B_Pt.setFont(new Font("Arial", 1, 12));
        this.JCH2B_Pt.setText("t");
        this.JCH2B_Pt.setHorizontalAlignment(0);
        this.JCH2B_Pt.setHorizontalTextPosition(2);
        this.JCH2B_Pt.setIconTextGap(1);
        this.JCH2B_Pt.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFLecturaPlacaOit.24
            public void actionPerformed(ActionEvent evt) {
                JIFLecturaPlacaOit.this.JCH2B_PtActionPerformed(evt);
            }
        });
        this.JBG2BP.add(this.JCH2B_Pu);
        this.JCH2B_Pu.setFont(new Font("Arial", 1, 12));
        this.JCH2B_Pu.setText("u");
        this.JCH2B_Pu.setHorizontalAlignment(0);
        this.JCH2B_Pu.setHorizontalTextPosition(2);
        this.JCH2B_Pu.setIconTextGap(1);
        this.JCH2B_Pu.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFLecturaPlacaOit.25
            public void actionPerformed(ActionEvent evt) {
                JIFLecturaPlacaOit.this.JCH2B_PuActionPerformed(evt);
            }
        });
        this.JLB2BSecundaria.setFont(new Font("Arial", 1, 12));
        this.JLB2BSecundaria.setForeground(Color.blue);
        this.JLB2BSecundaria.setHorizontalAlignment(0);
        this.JLB2BSecundaria.setText("Secundaria");
        this.JBG2BS.add(this.JCH2B_Sp);
        this.JCH2B_Sp.setFont(new Font("Arial", 1, 12));
        this.JCH2B_Sp.setHorizontalAlignment(0);
        this.JCH2B_Sp.setHorizontalTextPosition(2);
        this.JCH2B_Sp.setIconTextGap(1);
        this.JCH2B_Sp.setLabel("p");
        this.JCH2B_Sp.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFLecturaPlacaOit.26
            public void actionPerformed(ActionEvent evt) {
                JIFLecturaPlacaOit.this.JCH2B_SpActionPerformed(evt);
            }
        });
        this.JBG2BS.add(this.JCH2B_Ss);
        this.JCH2B_Ss.setFont(new Font("Arial", 1, 12));
        this.JCH2B_Ss.setText("s");
        this.JCH2B_Ss.setHorizontalAlignment(0);
        this.JCH2B_Ss.setHorizontalTextPosition(2);
        this.JCH2B_Ss.setIconTextGap(1);
        this.JCH2B_Ss.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFLecturaPlacaOit.27
            public void actionPerformed(ActionEvent evt) {
                JIFLecturaPlacaOit.this.JCH2B_SsActionPerformed(evt);
            }
        });
        this.JBG2BS.add(this.JCH2B_Sq);
        this.JCH2B_Sq.setFont(new Font("Arial", 1, 12));
        this.JCH2B_Sq.setHorizontalAlignment(0);
        this.JCH2B_Sq.setHorizontalTextPosition(2);
        this.JCH2B_Sq.setIconTextGap(1);
        this.JCH2B_Sq.setLabel("q");
        this.JCH2B_Sq.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFLecturaPlacaOit.28
            public void actionPerformed(ActionEvent evt) {
                JIFLecturaPlacaOit.this.JCH2B_SqActionPerformed(evt);
            }
        });
        this.JBG2BS.add(this.JCH2B_St);
        this.JCH2B_St.setFont(new Font("Arial", 1, 12));
        this.JCH2B_St.setText("t");
        this.JCH2B_St.setHorizontalAlignment(0);
        this.JCH2B_St.setHorizontalTextPosition(2);
        this.JCH2B_St.setIconTextGap(1);
        this.JCH2B_St.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFLecturaPlacaOit.29
            public void actionPerformed(ActionEvent evt) {
                JIFLecturaPlacaOit.this.JCH2B_StActionPerformed(evt);
            }
        });
        this.JBG2BS.add(this.JCH2B_Sr);
        this.JCH2B_Sr.setFont(new Font("Arial", 1, 12));
        this.JCH2B_Sr.setHorizontalAlignment(0);
        this.JCH2B_Sr.setHorizontalTextPosition(2);
        this.JCH2B_Sr.setIconTextGap(1);
        this.JCH2B_Sr.setLabel("r");
        this.JCH2B_Sr.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFLecturaPlacaOit.30
            public void actionPerformed(ActionEvent evt) {
                JIFLecturaPlacaOit.this.JCH2B_SrActionPerformed(evt);
            }
        });
        this.JBG2BS.add(this.JCH2B_Su);
        this.JCH2B_Su.setFont(new Font("Arial", 1, 12));
        this.JCH2B_Su.setText("u");
        this.JCH2B_Su.setHorizontalAlignment(0);
        this.JCH2B_Su.setHorizontalTextPosition(2);
        this.JCH2B_Su.setIconTextGap(1);
        this.JCH2B_Su.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFLecturaPlacaOit.31
            public void actionPerformed(ActionEvent evt) {
                JIFLecturaPlacaOit.this.JCH2B_SuActionPerformed(evt);
            }
        });
        this.JCH2B_ZSR.setFont(new Font("Arial", 1, 12));
        this.JCH2B_ZSR.setText("Superior");
        this.JCH2B_ZSR.setHorizontalAlignment(2);
        this.JCH2B_ZSR.setHorizontalTextPosition(2);
        this.JCH2B_ZSR.setVerticalTextPosition(1);
        this.JCH2B_ZSR.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFLecturaPlacaOit.32
            public void actionPerformed(ActionEvent evt) {
                JIFLecturaPlacaOit.this.JCH2B_ZSRActionPerformed(evt);
            }
        });
        this.JCH2B_ZMR.setFont(new Font("Arial", 1, 12));
        this.JCH2B_ZMR.setText("Media");
        this.JCH2B_ZMR.setHorizontalAlignment(2);
        this.JCH2B_ZMR.setHorizontalTextPosition(2);
        this.JCH2B_ZMR.setVerticalTextPosition(1);
        this.JCH2B_ZMR.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFLecturaPlacaOit.33
            public void actionPerformed(ActionEvent evt) {
                JIFLecturaPlacaOit.this.JCH2B_ZMRActionPerformed(evt);
            }
        });
        this.JCH2B_ZIR.setFont(new Font("Arial", 1, 12));
        this.JCH2B_ZIR.setText("Inferior");
        this.JCH2B_ZIR.setHorizontalAlignment(2);
        this.JCH2B_ZIR.setHorizontalTextPosition(2);
        this.JCH2B_ZIR.setVerticalTextPosition(1);
        this.JCH2B_ZIR.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFLecturaPlacaOit.34
            public void actionPerformed(ActionEvent evt) {
                JIFLecturaPlacaOit.this.JCH2B_ZIRActionPerformed(evt);
            }
        });
        this.JLB2BZona_RL.setFont(new Font("Arial", 1, 12));
        this.JLB2BZona_RL.setForeground(Color.blue);
        this.JLB2BZona_RL.setHorizontalAlignment(2);
        this.JLB2BZona_RL.setText("R           L");
        this.JLB2BZona.setFont(new Font("Arial", 1, 12));
        this.JLB2BZona.setForeground(Color.blue);
        this.JLB2BZona.setHorizontalAlignment(0);
        this.JLB2BZona.setText("Zona");
        this.JCH2B_ZSL.setFont(new Font("Arial", 1, 12));
        this.JCH2B_ZSL.setHorizontalAlignment(2);
        this.JCH2B_ZSL.setHorizontalTextPosition(2);
        this.JCH2B_ZSL.setVerticalTextPosition(1);
        this.JCH2B_ZSL.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFLecturaPlacaOit.35
            public void actionPerformed(ActionEvent evt) {
                JIFLecturaPlacaOit.this.JCH2B_ZSLActionPerformed(evt);
            }
        });
        this.JCH2B_ZML.setFont(new Font("Arial", 1, 12));
        this.JCH2B_ZML.setHorizontalAlignment(2);
        this.JCH2B_ZML.setHorizontalTextPosition(2);
        this.JCH2B_ZML.setVerticalTextPosition(1);
        this.JCH2B_ZML.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFLecturaPlacaOit.36
            public void actionPerformed(ActionEvent evt) {
                JIFLecturaPlacaOit.this.JCH2B_ZMLActionPerformed(evt);
            }
        });
        this.JCH2B_ZIL.setFont(new Font("Arial", 1, 12));
        this.JCH2B_ZIL.setHorizontalAlignment(2);
        this.JCH2B_ZIL.setHorizontalTextPosition(2);
        this.JCH2B_ZIL.setVerticalTextPosition(1);
        this.JCH2B_ZIL.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFLecturaPlacaOit.37
            public void actionPerformed(ActionEvent evt) {
                JIFLecturaPlacaOit.this.JCH2B_ZILActionPerformed(evt);
            }
        });
        this.JLB2BProfusion.setFont(new Font("Arial", 1, 12));
        this.JLB2BProfusion.setForeground(Color.blue);
        this.JLB2BProfusion.setHorizontalAlignment(0);
        this.JLB2BProfusion.setText("Profusión");
        this.JBG2BProfusion.add(this.JCH2B_P_0);
        this.JCH2B_P_0.setFont(new Font("Arial", 1, 12));
        this.JCH2B_P_0.setText("0/-");
        this.JCH2B_P_0.setHorizontalAlignment(0);
        this.JCH2B_P_0.setHorizontalTextPosition(2);
        this.JCH2B_P_0.setIconTextGap(1);
        this.JCH2B_P_0.setVerticalAlignment(1);
        this.JCH2B_P_0.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFLecturaPlacaOit.38
            public void actionPerformed(ActionEvent evt) {
                JIFLecturaPlacaOit.this.JCH2B_P_0ActionPerformed(evt);
            }
        });
        this.JBG2BProfusion.add(this.JCH2B_P_00);
        this.JCH2B_P_00.setFont(new Font("Arial", 1, 12));
        this.JCH2B_P_00.setText("0/0");
        this.JCH2B_P_00.setHorizontalAlignment(0);
        this.JCH2B_P_00.setHorizontalTextPosition(2);
        this.JCH2B_P_00.setIconTextGap(1);
        this.JCH2B_P_00.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFLecturaPlacaOit.39
            public void actionPerformed(ActionEvent evt) {
                JIFLecturaPlacaOit.this.JCH2B_P_00ActionPerformed(evt);
            }
        });
        this.JBG2BProfusion.add(this.JCH2B_P_01);
        this.JCH2B_P_01.setFont(new Font("Arial", 1, 12));
        this.JCH2B_P_01.setText("0/1");
        this.JCH2B_P_01.setHorizontalAlignment(0);
        this.JCH2B_P_01.setHorizontalTextPosition(2);
        this.JCH2B_P_01.setIconTextGap(1);
        this.JCH2B_P_01.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFLecturaPlacaOit.40
            public void actionPerformed(ActionEvent evt) {
                JIFLecturaPlacaOit.this.JCH2B_P_01ActionPerformed(evt);
            }
        });
        this.JBG2BProfusion.add(this.JCH2B_P_10);
        this.JCH2B_P_10.setFont(new Font("Arial", 1, 12));
        this.JCH2B_P_10.setText("1/0");
        this.JCH2B_P_10.setHorizontalAlignment(0);
        this.JCH2B_P_10.setHorizontalTextPosition(2);
        this.JCH2B_P_10.setIconTextGap(1);
        this.JCH2B_P_10.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFLecturaPlacaOit.41
            public void actionPerformed(ActionEvent evt) {
                JIFLecturaPlacaOit.this.JCH2B_P_10ActionPerformed(evt);
            }
        });
        this.JBG2BProfusion.add(this.JCH2B_P_11);
        this.JCH2B_P_11.setFont(new Font("Arial", 1, 12));
        this.JCH2B_P_11.setText("1/1");
        this.JCH2B_P_11.setHorizontalAlignment(0);
        this.JCH2B_P_11.setHorizontalTextPosition(2);
        this.JCH2B_P_11.setIconTextGap(1);
        this.JCH2B_P_11.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFLecturaPlacaOit.42
            public void actionPerformed(ActionEvent evt) {
                JIFLecturaPlacaOit.this.JCH2B_P_11ActionPerformed(evt);
            }
        });
        this.JBG2BProfusion.add(this.JCH2B_P_12);
        this.JCH2B_P_12.setFont(new Font("Arial", 1, 12));
        this.JCH2B_P_12.setText("1/2");
        this.JCH2B_P_12.setHorizontalAlignment(0);
        this.JCH2B_P_12.setHorizontalTextPosition(2);
        this.JCH2B_P_12.setIconTextGap(1);
        this.JCH2B_P_12.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFLecturaPlacaOit.43
            public void actionPerformed(ActionEvent evt) {
                JIFLecturaPlacaOit.this.JCH2B_P_12ActionPerformed(evt);
            }
        });
        this.JBG2BProfusion.add(this.JCH2B_P_21);
        this.JCH2B_P_21.setFont(new Font("Arial", 1, 12));
        this.JCH2B_P_21.setText("2/1");
        this.JCH2B_P_21.setHorizontalAlignment(0);
        this.JCH2B_P_21.setHorizontalTextPosition(2);
        this.JCH2B_P_21.setIconTextGap(1);
        this.JCH2B_P_21.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFLecturaPlacaOit.44
            public void actionPerformed(ActionEvent evt) {
                JIFLecturaPlacaOit.this.JCH2B_P_21ActionPerformed(evt);
            }
        });
        this.JBG2BProfusion.add(this.JCH2B_P_22);
        this.JCH2B_P_22.setFont(new Font("Arial", 1, 12));
        this.JCH2B_P_22.setText("2/2");
        this.JCH2B_P_22.setHorizontalAlignment(0);
        this.JCH2B_P_22.setHorizontalTextPosition(2);
        this.JCH2B_P_22.setIconTextGap(1);
        this.JCH2B_P_22.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFLecturaPlacaOit.45
            public void actionPerformed(ActionEvent evt) {
                JIFLecturaPlacaOit.this.JCH2B_P_22ActionPerformed(evt);
            }
        });
        this.JBG2BProfusion.add(this.JCH2B_P_23);
        this.JCH2B_P_23.setFont(new Font("Arial", 1, 12));
        this.JCH2B_P_23.setText("2/3");
        this.JCH2B_P_23.setHorizontalAlignment(0);
        this.JCH2B_P_23.setHorizontalTextPosition(2);
        this.JCH2B_P_23.setIconTextGap(1);
        this.JCH2B_P_23.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFLecturaPlacaOit.46
            public void actionPerformed(ActionEvent evt) {
                JIFLecturaPlacaOit.this.JCH2B_P_23ActionPerformed(evt);
            }
        });
        this.JBG2BProfusion.add(this.JCH2B_P_32);
        this.JCH2B_P_32.setFont(new Font("Arial", 1, 12));
        this.JCH2B_P_32.setText("3/2");
        this.JCH2B_P_32.setHorizontalAlignment(0);
        this.JCH2B_P_32.setHorizontalTextPosition(2);
        this.JCH2B_P_32.setIconTextGap(1);
        this.JCH2B_P_32.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFLecturaPlacaOit.47
            public void actionPerformed(ActionEvent evt) {
                JIFLecturaPlacaOit.this.JCH2B_P_32ActionPerformed(evt);
            }
        });
        this.JBG2BProfusion.add(this.JCH2B_P_33);
        this.JCH2B_P_33.setFont(new Font("Arial", 1, 12));
        this.JCH2B_P_33.setText("3/+");
        this.JCH2B_P_33.setHorizontalAlignment(0);
        this.JCH2B_P_33.setHorizontalTextPosition(2);
        this.JCH2B_P_33.setIconTextGap(1);
        this.JCH2B_P_33.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFLecturaPlacaOit.48
            public void actionPerformed(ActionEvent evt) {
                JIFLecturaPlacaOit.this.JCH2B_P_33ActionPerformed(evt);
            }
        });
        this.JBG2BProfusion.add(this.JCH2B_P_34);
        this.JCH2B_P_34.setFont(new Font("Arial", 1, 12));
        this.JCH2B_P_34.setText("3/3");
        this.JCH2B_P_34.setHorizontalAlignment(0);
        this.JCH2B_P_34.setHorizontalTextPosition(2);
        this.JCH2B_P_34.setIconTextGap(1);
        this.JCH2B_P_34.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFLecturaPlacaOit.49
            public void actionPerformed(ActionEvent evt) {
                JIFLecturaPlacaOit.this.JCH2B_P_34ActionPerformed(evt);
            }
        });
        GroupLayout JPI2BLayout = new GroupLayout(this.JPI2B);
        this.JPI2B.setLayout(JPI2BLayout);
        JPI2BLayout.setHorizontalGroup(JPI2BLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI2BLayout.createSequentialGroup().addContainerGap().addGroup(JPI2BLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.f12JLB2BTamao, -2, 138, -2).addGroup(JPI2BLayout.createSequentialGroup().addGroup(JPI2BLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLB2BPrimaria, -2, 63, -2).addGroup(JPI2BLayout.createSequentialGroup().addGroup(JPI2BLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCH2B_Pr).addComponent(this.JCH2B_Pq).addComponent(this.JCH2B_Pp)).addGap(18, 18, 18).addGroup(JPI2BLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JCH2B_Pu, -1, -1, 32767).addComponent(this.JCH2B_Ps, -1, -1, 32767).addComponent(this.JCH2B_Pt, GroupLayout.Alignment.TRAILING)))).addGap(18, 18, 18).addGroup(JPI2BLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLB2BSecundaria).addGroup(JPI2BLayout.createSequentialGroup().addGroup(JPI2BLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCH2B_Sr).addComponent(this.JCH2B_Sq).addComponent(this.JCH2B_Sp)).addGap(18, 18, 18).addGroup(JPI2BLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JCH2B_Su, -1, -1, 32767).addComponent(this.JCH2B_Ss, -1, -1, 32767).addComponent(this.JCH2B_St, GroupLayout.Alignment.TRAILING)))))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 51, 32767).addGroup(JPI2BLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI2BLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JLB2BZona_RL, -2, 56, -2).addGroup(GroupLayout.Alignment.LEADING, JPI2BLayout.createSequentialGroup().addGroup(JPI2BLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JCH2B_ZSR).addComponent(this.JCH2B_ZMR).addComponent(this.JCH2B_ZIR)).addGap(18, 18, 18).addGroup(JPI2BLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCH2B_ZSL).addComponent(this.JCH2B_ZML).addComponent(this.JCH2B_ZIL)))).addComponent(this.JLB2BZona, -2, 138, -2)).addGap(37, 37, 37).addGroup(JPI2BLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLB2BProfusion, -2, 132, -2).addGroup(JPI2BLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPI2BLayout.createSequentialGroup().addComponent(this.JCH2B_P_0).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCH2B_P_00).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCH2B_P_01, -1, -1, 32767)).addGroup(JPI2BLayout.createSequentialGroup().addComponent(this.JCH2B_P_10).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCH2B_P_11).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCH2B_P_12)).addGroup(JPI2BLayout.createSequentialGroup().addComponent(this.JCH2B_P_21).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCH2B_P_22).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCH2B_P_23)).addGroup(JPI2BLayout.createSequentialGroup().addComponent(this.JCH2B_P_32).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCH2B_P_34).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCH2B_P_33)))).addGap(33, 33, 33)));
        JPI2BLayout.setVerticalGroup(JPI2BLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI2BLayout.createSequentialGroup().addComponent(this.f12JLB2BTamao).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPI2BLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI2BLayout.createSequentialGroup().addComponent(this.JLB2BPrimaria).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPI2BLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI2BLayout.createSequentialGroup().addComponent(this.JCH2B_Pp).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCH2B_Pq).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JCH2B_Pr)).addGroup(JPI2BLayout.createSequentialGroup().addComponent(this.JCH2B_Ps).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCH2B_Pt).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JCH2B_Pu)))).addGroup(JPI2BLayout.createSequentialGroup().addComponent(this.JLB2BSecundaria).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPI2BLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI2BLayout.createSequentialGroup().addComponent(this.JCH2B_Sp).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCH2B_Sq).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JCH2B_Sr)).addGroup(JPI2BLayout.createSequentialGroup().addComponent(this.JCH2B_Ss).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCH2B_St).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JCH2B_Su)))))).addGroup(JPI2BLayout.createSequentialGroup().addComponent(this.JLB2BProfusion).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPI2BLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCH2B_P_0).addComponent(this.JCH2B_P_00).addComponent(this.JCH2B_P_01)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPI2BLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCH2B_P_10).addComponent(this.JCH2B_P_11).addComponent(this.JCH2B_P_12)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPI2BLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCH2B_P_21).addComponent(this.JCH2B_P_22).addComponent(this.JCH2B_P_23)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(JPI2BLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCH2B_P_32).addComponent(this.JCH2B_P_34).addComponent(this.JCH2B_P_33))).addGroup(JPI2BLayout.createSequentialGroup().addGroup(JPI2BLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPI2BLayout.createSequentialGroup().addComponent(this.JLB2BZona).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLB2BZona_RL).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPI2BLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JCH2B_ZSR).addComponent(this.JCH2B_ZSL)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCH2B_ZMR)).addComponent(this.JCH2B_ZML)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(JPI2BLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCH2B_ZIR, GroupLayout.Alignment.TRAILING).addComponent(this.JCH2B_ZIL, GroupLayout.Alignment.TRAILING))));
        this.JPI2COpacidadesG.setBorder(BorderFactory.createTitledBorder((Border) null, "2C. OPACIDADES GRANDES", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.f13JLB2CTamao.setFont(new Font("Arial", 1, 12));
        this.f13JLB2CTamao.setForeground(Color.blue);
        this.f13JLB2CTamao.setHorizontalAlignment(0);
        this.f13JLB2CTamao.setText("Tamaño");
        this.JBG2COpacidades.add(this.JCH2C_O);
        this.JCH2C_O.setFont(new Font("Arial", 1, 12));
        this.JCH2C_O.setText("O");
        this.JCH2C_O.setHorizontalAlignment(0);
        this.JCH2C_O.setHorizontalTextPosition(2);
        this.JCH2C_O.setIconTextGap(1);
        this.JCH2C_O.setVerticalAlignment(1);
        this.JCH2C_O.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFLecturaPlacaOit.50
            public void actionPerformed(ActionEvent evt) {
                JIFLecturaPlacaOit.this.JCH2C_OActionPerformed(evt);
            }
        });
        this.JBG2COpacidades.add(this.JCH2C_A);
        this.JCH2C_A.setFont(new Font("Arial", 1, 12));
        this.JCH2C_A.setText("A");
        this.JCH2C_A.setHorizontalAlignment(0);
        this.JCH2C_A.setHorizontalTextPosition(2);
        this.JCH2C_A.setIconTextGap(1);
        this.JCH2C_A.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFLecturaPlacaOit.51
            public void actionPerformed(ActionEvent evt) {
                JIFLecturaPlacaOit.this.JCH2C_AActionPerformed(evt);
            }
        });
        this.JBG2COpacidades.add(this.JCH2C_B);
        this.JCH2C_B.setFont(new Font("Arial", 1, 12));
        this.JCH2C_B.setText("B");
        this.JCH2C_B.setHorizontalAlignment(0);
        this.JCH2C_B.setHorizontalTextPosition(2);
        this.JCH2C_B.setIconTextGap(1);
        this.JCH2C_B.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFLecturaPlacaOit.52
            public void actionPerformed(ActionEvent evt) {
                JIFLecturaPlacaOit.this.JCH2C_BActionPerformed(evt);
            }
        });
        this.JBG2COpacidades.add(this.JCH2C_C);
        this.JCH2C_C.setFont(new Font("Arial", 1, 12));
        this.JCH2C_C.setText("C");
        this.JCH2C_C.setHorizontalAlignment(0);
        this.JCH2C_C.setHorizontalTextPosition(2);
        this.JCH2C_C.setIconTextGap(1);
        this.JCH2C_C.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFLecturaPlacaOit.53
            public void actionPerformed(ActionEvent evt) {
                JIFLecturaPlacaOit.this.JCH2C_CActionPerformed(evt);
            }
        });
        GroupLayout JPI2COpacidadesGLayout = new GroupLayout(this.JPI2COpacidadesG);
        this.JPI2COpacidadesG.setLayout(JPI2COpacidadesGLayout);
        JPI2COpacidadesGLayout.setHorizontalGroup(JPI2COpacidadesGLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI2COpacidadesGLayout.createSequentialGroup().addContainerGap().addComponent(this.f13JLB2CTamao, -2, 98, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCH2C_O).addGap(10, 10, 10).addComponent(this.JCH2C_A).addGap(12, 12, 12).addComponent(this.JCH2C_B).addGap(18, 18, 18).addComponent(this.JCH2C_C).addContainerGap(-1, 32767)));
        JPI2COpacidadesGLayout.setVerticalGroup(JPI2COpacidadesGLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI2COpacidadesGLayout.createSequentialGroup().addGroup(JPI2COpacidadesGLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI2COpacidadesGLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCH2C_O).addComponent(this.JCH2C_A).addComponent(this.JCH2C_B).addComponent(this.JCH2C_C)).addComponent(this.f13JLB2CTamao)).addContainerGap(-1, 32767)));
        this.JPI3A.setBorder(BorderFactory.createTitledBorder((Border) null, "3A.", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JLB3A_Pregunta.setFont(new Font("Arial", 1, 12));
        this.JLB3A_Pregunta.setForeground(Color.red);
        this.JLB3A_Pregunta.setText("Hay anormalidades pleurales compatibles con neumoconiosis?");
        this.JBG3A.add(this.JCH3A_Si);
        this.JCH3A_Si.setFont(new Font("Arial", 1, 12));
        this.JCH3A_Si.setText("SI (complete secciones 3B y 3C)");
        this.JCH3A_Si.setHorizontalAlignment(0);
        this.JCH3A_Si.setHorizontalTextPosition(4);
        this.JCH3A_Si.setVerticalTextPosition(1);
        this.JCH3A_Si.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFLecturaPlacaOit.54
            public void actionPerformed(ActionEvent evt) {
                JIFLecturaPlacaOit.this.JCH3A_SiActionPerformed(evt);
            }
        });
        this.JBG3A.add(this.JCH3A_No);
        this.JCH3A_No.setFont(new Font("Arial", 1, 12));
        this.JCH3A_No.setSelected(true);
        this.JCH3A_No.setText("NO (pase a sección 4A)");
        this.JCH3A_No.setHorizontalAlignment(0);
        this.JCH3A_No.setHorizontalTextPosition(4);
        this.JCH3A_No.setVerticalTextPosition(1);
        this.JCH3A_No.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFLecturaPlacaOit.55
            public void actionPerformed(ActionEvent evt) {
                JIFLecturaPlacaOit.this.JCH3A_NoActionPerformed(evt);
            }
        });
        GroupLayout JPI3ALayout = new GroupLayout(this.JPI3A);
        this.JPI3A.setLayout(JPI3ALayout);
        JPI3ALayout.setHorizontalGroup(JPI3ALayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI3ALayout.createSequentialGroup().addContainerGap().addComponent(this.JLB3A_Pregunta, -2, 453, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCH3A_Si).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JCH3A_No).addGap(28, 28, 28)));
        JPI3ALayout.setVerticalGroup(JPI3ALayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCH3A_Si, -2, 0, 32767).addComponent(this.JLB3A_Pregunta, -1, -1, 32767).addComponent(this.JCH3A_No, GroupLayout.Alignment.TRAILING, -2, 15, -2));
        this.JPI3BPlacas.setBorder(BorderFactory.createTitledBorder((Border) null, "3B. PLACAS PLEURALES", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JLB3BParedToracica.setFont(new Font("Arial", 1, 12));
        this.JLB3BParedToracica.setForeground(Color.blue);
        this.JLB3BParedToracica.setHorizontalAlignment(0);
        this.JLB3BParedToracica.setText("Pared Torácica");
        this.JCH3B_SP_O.setFont(new Font("Arial", 1, 12));
        this.JCH3B_SP_O.setText("O");
        this.JCH3B_SP_O.setHorizontalAlignment(0);
        this.JCH3B_SP_O.setHorizontalTextPosition(2);
        this.JCH3B_SP_O.setIconTextGap(1);
        this.JCH3B_SP_O.setVerticalAlignment(1);
        this.JCH3B_SP_O.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFLecturaPlacaOit.56
            public void actionPerformed(ActionEvent evt) {
                JIFLecturaPlacaOit.this.JCH3B_SP_OActionPerformed(evt);
            }
        });
        this.JCH3B_SP_R.setFont(new Font("Arial", 1, 12));
        this.JCH3B_SP_R.setText("R");
        this.JCH3B_SP_R.setHorizontalAlignment(0);
        this.JCH3B_SP_R.setHorizontalTextPosition(2);
        this.JCH3B_SP_R.setIconTextGap(1);
        this.JCH3B_SP_R.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFLecturaPlacaOit.57
            public void actionPerformed(ActionEvent evt) {
                JIFLecturaPlacaOit.this.JCH3B_SP_RActionPerformed(evt);
            }
        });
        this.JCH3B_SP_L.setFont(new Font("Arial", 1, 12));
        this.JCH3B_SP_L.setText("L");
        this.JCH3B_SP_L.setHorizontalAlignment(0);
        this.JCH3B_SP_L.setHorizontalTextPosition(2);
        this.JCH3B_SP_L.setIconTextGap(1);
        this.JCH3B_SP_L.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFLecturaPlacaOit.58
            public void actionPerformed(ActionEvent evt) {
                JIFLecturaPlacaOit.this.JCH3B_SP_LActionPerformed(evt);
            }
        });
        this.JCH3B_SF_O.setFont(new Font("Arial", 1, 12));
        this.JCH3B_SF_O.setText("O");
        this.JCH3B_SF_O.setHorizontalAlignment(0);
        this.JCH3B_SF_O.setHorizontalTextPosition(2);
        this.JCH3B_SF_O.setIconTextGap(1);
        this.JCH3B_SF_O.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFLecturaPlacaOit.59
            public void actionPerformed(ActionEvent evt) {
                JIFLecturaPlacaOit.this.JCH3B_SF_OActionPerformed(evt);
            }
        });
        this.JCH3B_SF_R.setFont(new Font("Arial", 1, 12));
        this.JCH3B_SF_R.setText("R");
        this.JCH3B_SF_R.setHorizontalAlignment(0);
        this.JCH3B_SF_R.setHorizontalTextPosition(2);
        this.JCH3B_SF_R.setIconTextGap(1);
        this.JCH3B_SF_R.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFLecturaPlacaOit.60
            public void actionPerformed(ActionEvent evt) {
                JIFLecturaPlacaOit.this.JCH3B_SF_RActionPerformed(evt);
            }
        });
        this.JCH3B_SF_L.setFont(new Font("Arial", 1, 12));
        this.JCH3B_SF_L.setText("L");
        this.JCH3B_SF_L.setHorizontalAlignment(0);
        this.JCH3B_SF_L.setHorizontalTextPosition(2);
        this.JCH3B_SF_L.setIconTextGap(1);
        this.JCH3B_SF_L.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFLecturaPlacaOit.61
            public void actionPerformed(ActionEvent evt) {
                JIFLecturaPlacaOit.this.JCH3B_SF_LActionPerformed(evt);
            }
        });
        this.JCH3B_SD_O.setFont(new Font("Arial", 1, 12));
        this.JCH3B_SD_O.setText("O");
        this.JCH3B_SD_O.setHorizontalAlignment(0);
        this.JCH3B_SD_O.setHorizontalTextPosition(2);
        this.JCH3B_SD_O.setIconTextGap(1);
        this.JCH3B_SD_O.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFLecturaPlacaOit.62
            public void actionPerformed(ActionEvent evt) {
                JIFLecturaPlacaOit.this.JCH3B_SD_OActionPerformed(evt);
            }
        });
        this.JCH3B_SD_R.setFont(new Font("Arial", 1, 12));
        this.JCH3B_SD_R.setText("R");
        this.JCH3B_SD_R.setHorizontalAlignment(0);
        this.JCH3B_SD_R.setHorizontalTextPosition(2);
        this.JCH3B_SD_R.setIconTextGap(1);
        this.JCH3B_SD_R.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFLecturaPlacaOit.63
            public void actionPerformed(ActionEvent evt) {
                JIFLecturaPlacaOit.this.JCH3B_SD_RActionPerformed(evt);
            }
        });
        this.JCH3B_SD_L.setFont(new Font("Arial", 1, 12));
        this.JCH3B_SD_L.setText("L");
        this.JCH3B_SD_L.setHorizontalAlignment(0);
        this.JCH3B_SD_L.setHorizontalTextPosition(2);
        this.JCH3B_SD_L.setIconTextGap(1);
        this.JCH3B_SD_L.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFLecturaPlacaOit.64
            public void actionPerformed(ActionEvent evt) {
                JIFLecturaPlacaOit.this.JCH3B_SD_LActionPerformed(evt);
            }
        });
        this.JCH3B_SO_O.setFont(new Font("Arial", 1, 12));
        this.JCH3B_SO_O.setText("O");
        this.JCH3B_SO_O.setHorizontalAlignment(0);
        this.JCH3B_SO_O.setHorizontalTextPosition(2);
        this.JCH3B_SO_O.setIconTextGap(1);
        this.JCH3B_SO_O.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFLecturaPlacaOit.65
            public void actionPerformed(ActionEvent evt) {
                JIFLecturaPlacaOit.this.JCH3B_SO_OActionPerformed(evt);
            }
        });
        this.JCH3B_SO_L.setFont(new Font("Arial", 1, 12));
        this.JCH3B_SO_L.setText("L");
        this.JCH3B_SO_L.setHorizontalAlignment(0);
        this.JCH3B_SO_L.setHorizontalTextPosition(2);
        this.JCH3B_SO_L.setIconTextGap(1);
        this.JCH3B_SO_L.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFLecturaPlacaOit.66
            public void actionPerformed(ActionEvent evt) {
                JIFLecturaPlacaOit.this.JCH3B_SO_LActionPerformed(evt);
            }
        });
        this.JCH3B_SO_R.setFont(new Font("Arial", 1, 12));
        this.JCH3B_SO_R.setText("R");
        this.JCH3B_SO_R.setHorizontalAlignment(0);
        this.JCH3B_SO_R.setHorizontalTextPosition(2);
        this.JCH3B_SO_R.setIconTextGap(1);
        this.JCH3B_SO_R.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFLecturaPlacaOit.67
            public void actionPerformed(ActionEvent evt) {
                JIFLecturaPlacaOit.this.JCH3B_SO_RActionPerformed(evt);
            }
        });
        this.JLB3BPerfil.setFont(new Font("Arial", 1, 12));
        this.JLB3BPerfil.setForeground(Color.blue);
        this.JLB3BPerfil.setHorizontalAlignment(4);
        this.JLB3BPerfil.setText("En el perfil");
        this.JLB3BFrente.setFont(new Font("Arial", 1, 12));
        this.JLB3BFrente.setForeground(Color.blue);
        this.JLB3BFrente.setHorizontalAlignment(4);
        this.JLB3BFrente.setText("De  frente");
        this.JLB3BDiafragma.setFont(new Font("Arial", 1, 12));
        this.JLB3BDiafragma.setForeground(Color.blue);
        this.JLB3BDiafragma.setHorizontalAlignment(4);
        this.JLB3BDiafragma.setText("Diafragma");
        this.JLB3BOtroSitio.setFont(new Font("Arial", 1, 12));
        this.JLB3BOtroSitio.setForeground(Color.blue);
        this.JLB3BOtroSitio.setHorizontalAlignment(4);
        this.JLB3BOtroSitio.setText("Otro sitio");
        this.jSeparator1.setOrientation(1);
        this.JLB3BCalcificacion.setFont(new Font("Arial", 1, 12));
        this.JLB3BCalcificacion.setForeground(Color.blue);
        this.JLB3BCalcificacion.setHorizontalAlignment(0);
        this.JLB3BCalcificacion.setText("Calcificación");
        this.JCH3B_CP_O.setFont(new Font("Arial", 1, 12));
        this.JCH3B_CP_O.setText("O");
        this.JCH3B_CP_O.setHorizontalAlignment(0);
        this.JCH3B_CP_O.setHorizontalTextPosition(2);
        this.JCH3B_CP_O.setIconTextGap(1);
        this.JCH3B_CP_O.setVerticalAlignment(1);
        this.JCH3B_CP_O.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFLecturaPlacaOit.68
            public void actionPerformed(ActionEvent evt) {
                JIFLecturaPlacaOit.this.JCH3B_CP_OActionPerformed(evt);
            }
        });
        this.JCH3B_CF_O.setFont(new Font("Arial", 1, 12));
        this.JCH3B_CF_O.setText("O");
        this.JCH3B_CF_O.setHorizontalAlignment(0);
        this.JCH3B_CF_O.setHorizontalTextPosition(2);
        this.JCH3B_CF_O.setIconTextGap(1);
        this.JCH3B_CF_O.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFLecturaPlacaOit.69
            public void actionPerformed(ActionEvent evt) {
                JIFLecturaPlacaOit.this.JCH3B_CF_OActionPerformed(evt);
            }
        });
        this.JCH3B_CD_O.setFont(new Font("Arial", 1, 12));
        this.JCH3B_CD_O.setText("O");
        this.JCH3B_CD_O.setHorizontalAlignment(0);
        this.JCH3B_CD_O.setHorizontalTextPosition(2);
        this.JCH3B_CD_O.setIconTextGap(1);
        this.JCH3B_CD_O.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFLecturaPlacaOit.70
            public void actionPerformed(ActionEvent evt) {
                JIFLecturaPlacaOit.this.JCH3B_CD_OActionPerformed(evt);
            }
        });
        this.JCH3B_CO_O.setFont(new Font("Arial", 1, 12));
        this.JCH3B_CO_O.setText("O");
        this.JCH3B_CO_O.setHorizontalAlignment(0);
        this.JCH3B_CO_O.setHorizontalTextPosition(2);
        this.JCH3B_CO_O.setIconTextGap(1);
        this.JCH3B_CO_O.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFLecturaPlacaOit.71
            public void actionPerformed(ActionEvent evt) {
                JIFLecturaPlacaOit.this.JCH3B_CO_OActionPerformed(evt);
            }
        });
        this.JCH3B_CP_R.setFont(new Font("Arial", 1, 12));
        this.JCH3B_CP_R.setText("R");
        this.JCH3B_CP_R.setHorizontalAlignment(0);
        this.JCH3B_CP_R.setHorizontalTextPosition(2);
        this.JCH3B_CP_R.setIconTextGap(1);
        this.JCH3B_CP_R.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFLecturaPlacaOit.72
            public void actionPerformed(ActionEvent evt) {
                JIFLecturaPlacaOit.this.JCH3B_CP_RActionPerformed(evt);
            }
        });
        this.JCH3B_CF_R.setFont(new Font("Arial", 1, 12));
        this.JCH3B_CF_R.setText("R");
        this.JCH3B_CF_R.setHorizontalAlignment(0);
        this.JCH3B_CF_R.setHorizontalTextPosition(2);
        this.JCH3B_CF_R.setIconTextGap(1);
        this.JCH3B_CF_R.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFLecturaPlacaOit.73
            public void actionPerformed(ActionEvent evt) {
                JIFLecturaPlacaOit.this.JCH3B_CF_RActionPerformed(evt);
            }
        });
        this.JCH3B_CD_R.setFont(new Font("Arial", 1, 12));
        this.JCH3B_CD_R.setText("R");
        this.JCH3B_CD_R.setHorizontalAlignment(0);
        this.JCH3B_CD_R.setHorizontalTextPosition(2);
        this.JCH3B_CD_R.setIconTextGap(1);
        this.JCH3B_CD_R.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFLecturaPlacaOit.74
            public void actionPerformed(ActionEvent evt) {
                JIFLecturaPlacaOit.this.JCH3B_CD_RActionPerformed(evt);
            }
        });
        this.JCH3B_CO_R.setFont(new Font("Arial", 1, 12));
        this.JCH3B_CO_R.setText("R");
        this.JCH3B_CO_R.setHorizontalAlignment(0);
        this.JCH3B_CO_R.setHorizontalTextPosition(2);
        this.JCH3B_CO_R.setIconTextGap(1);
        this.JCH3B_CO_R.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFLecturaPlacaOit.75
            public void actionPerformed(ActionEvent evt) {
                JIFLecturaPlacaOit.this.JCH3B_CO_RActionPerformed(evt);
            }
        });
        this.JCH3B_CP_L.setFont(new Font("Arial", 1, 12));
        this.JCH3B_CP_L.setText("L");
        this.JCH3B_CP_L.setHorizontalAlignment(0);
        this.JCH3B_CP_L.setHorizontalTextPosition(2);
        this.JCH3B_CP_L.setIconTextGap(1);
        this.JCH3B_CP_L.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFLecturaPlacaOit.76
            public void actionPerformed(ActionEvent evt) {
                JIFLecturaPlacaOit.this.JCH3B_CP_LActionPerformed(evt);
            }
        });
        this.JCH3B_CF_L.setFont(new Font("Arial", 1, 12));
        this.JCH3B_CF_L.setText("L");
        this.JCH3B_CF_L.setHorizontalAlignment(0);
        this.JCH3B_CF_L.setHorizontalTextPosition(2);
        this.JCH3B_CF_L.setIconTextGap(1);
        this.JCH3B_CF_L.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFLecturaPlacaOit.77
            public void actionPerformed(ActionEvent evt) {
                JIFLecturaPlacaOit.this.JCH3B_CF_LActionPerformed(evt);
            }
        });
        this.JCH3B_CD_L.setFont(new Font("Arial", 1, 12));
        this.JCH3B_CD_L.setText("L");
        this.JCH3B_CD_L.setHorizontalAlignment(0);
        this.JCH3B_CD_L.setHorizontalTextPosition(2);
        this.JCH3B_CD_L.setIconTextGap(1);
        this.JCH3B_CD_L.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFLecturaPlacaOit.78
            public void actionPerformed(ActionEvent evt) {
                JIFLecturaPlacaOit.this.JCH3B_CD_LActionPerformed(evt);
            }
        });
        this.JCH3B_CO_L.setFont(new Font("Arial", 1, 12));
        this.JCH3B_CO_L.setText("L");
        this.JCH3B_CO_L.setHorizontalAlignment(0);
        this.JCH3B_CO_L.setHorizontalTextPosition(2);
        this.JCH3B_CO_L.setIconTextGap(1);
        this.JCH3B_CO_L.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFLecturaPlacaOit.79
            public void actionPerformed(ActionEvent evt) {
                JIFLecturaPlacaOit.this.JCH3B_CO_LActionPerformed(evt);
            }
        });
        this.jSeparator2.setOrientation(1);
        this.JLB3BExtension.setFont(new Font("Arial", 1, 12));
        this.JLB3BExtension.setForeground(Color.blue);
        this.JLB3BExtension.setHorizontalAlignment(0);
        this.JLB3BExtension.setText("<html><P ALIGN=center>Extensión (pared torácica; combinada en perfil y de frente)");
        this.JLB3BExtension.setAutoscrolls(true);
        this.JLB3BExtension.setHorizontalTextPosition(4);
        this.JBG3BEV1.add(this.JCH3B_Extension_O);
        this.JCH3B_Extension_O.setFont(new Font("Arial", 1, 12));
        this.JCH3B_Extension_O.setText("O");
        this.JCH3B_Extension_O.setHorizontalAlignment(0);
        this.JCH3B_Extension_O.setHorizontalTextPosition(2);
        this.JCH3B_Extension_O.setIconTextGap(1);
        this.JCH3B_Extension_O.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFLecturaPlacaOit.80
            public void actionPerformed(ActionEvent evt) {
                JIFLecturaPlacaOit.this.JCH3B_Extension_OActionPerformed(evt);
            }
        });
        this.JBG3BEV1.add(this.JCH3B_Extension_R);
        this.JCH3B_Extension_R.setFont(new Font("Arial", 1, 12));
        this.JCH3B_Extension_R.setText("R");
        this.JCH3B_Extension_R.setHorizontalAlignment(0);
        this.JCH3B_Extension_R.setHorizontalTextPosition(2);
        this.JCH3B_Extension_R.setIconTextGap(1);
        this.JCH3B_Extension_R.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFLecturaPlacaOit.81
            public void actionPerformed(ActionEvent evt) {
                JIFLecturaPlacaOit.this.JCH3B_Extension_RActionPerformed(evt);
            }
        });
        this.JBG3BER1.add(this.JCH3B_V_E1);
        this.JCH3B_V_E1.setFont(new Font("Arial", 1, 12));
        this.JCH3B_V_E1.setText("1");
        this.JCH3B_V_E1.setHorizontalAlignment(0);
        this.JCH3B_V_E1.setHorizontalTextPosition(2);
        this.JCH3B_V_E1.setIconTextGap(1);
        this.JCH3B_V_E1.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFLecturaPlacaOit.82
            public void actionPerformed(ActionEvent evt) {
                JIFLecturaPlacaOit.this.JCH3B_V_E1ActionPerformed(evt);
            }
        });
        this.JBG3BER1.add(this.JCH3B_V_E2);
        this.JCH3B_V_E2.setFont(new Font("Arial", 1, 12));
        this.JCH3B_V_E2.setText("2");
        this.JCH3B_V_E2.setHorizontalAlignment(0);
        this.JCH3B_V_E2.setHorizontalTextPosition(2);
        this.JCH3B_V_E2.setIconTextGap(1);
        this.JCH3B_V_E2.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFLecturaPlacaOit.83
            public void actionPerformed(ActionEvent evt) {
                JIFLecturaPlacaOit.this.JCH3B_V_E2ActionPerformed(evt);
            }
        });
        this.JBG3BER1.add(this.JCH3B_V_E3);
        this.JCH3B_V_E3.setFont(new Font("Arial", 1, 12));
        this.JCH3B_V_E3.setText("3");
        this.JCH3B_V_E3.setHorizontalAlignment(0);
        this.JCH3B_V_E3.setHorizontalTextPosition(2);
        this.JCH3B_V_E3.setIconTextGap(1);
        this.JCH3B_V_E3.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFLecturaPlacaOit.84
            public void actionPerformed(ActionEvent evt) {
                JIFLecturaPlacaOit.this.JCH3B_V_E3ActionPerformed(evt);
            }
        });
        this.JBG3BEV2.add(this.JCH3B_Extension_O1);
        this.JCH3B_Extension_O1.setFont(new Font("Arial", 1, 12));
        this.JCH3B_Extension_O1.setText("O");
        this.JCH3B_Extension_O1.setHorizontalAlignment(0);
        this.JCH3B_Extension_O1.setHorizontalTextPosition(2);
        this.JCH3B_Extension_O1.setIconTextGap(1);
        this.JCH3B_Extension_O1.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFLecturaPlacaOit.85
            public void actionPerformed(ActionEvent evt) {
                JIFLecturaPlacaOit.this.JCH3B_Extension_O1ActionPerformed(evt);
            }
        });
        this.JBG3BEV2.add(this.JCH3B_Extension_L1);
        this.JCH3B_Extension_L1.setFont(new Font("Arial", 1, 12));
        this.JCH3B_Extension_L1.setText("L");
        this.JCH3B_Extension_L1.setHorizontalAlignment(0);
        this.JCH3B_Extension_L1.setHorizontalTextPosition(2);
        this.JCH3B_Extension_L1.setIconTextGap(1);
        this.JCH3B_Extension_L1.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFLecturaPlacaOit.86
            public void actionPerformed(ActionEvent evt) {
                JIFLecturaPlacaOit.this.JCH3B_Extension_L1ActionPerformed(evt);
            }
        });
        this.JBG3BER2.add(this.JCH3B_V_E4);
        this.JCH3B_V_E4.setFont(new Font("Arial", 1, 12));
        this.JCH3B_V_E4.setText("1");
        this.JCH3B_V_E4.setHorizontalAlignment(0);
        this.JCH3B_V_E4.setHorizontalTextPosition(2);
        this.JCH3B_V_E4.setIconTextGap(1);
        this.JCH3B_V_E4.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFLecturaPlacaOit.87
            public void actionPerformed(ActionEvent evt) {
                JIFLecturaPlacaOit.this.JCH3B_V_E4ActionPerformed(evt);
            }
        });
        this.JBG3BER2.add(this.JCH3B_V_E5);
        this.JCH3B_V_E5.setFont(new Font("Arial", 1, 12));
        this.JCH3B_V_E5.setText("2");
        this.JCH3B_V_E5.setHorizontalAlignment(0);
        this.JCH3B_V_E5.setHorizontalTextPosition(2);
        this.JCH3B_V_E5.setIconTextGap(1);
        this.JCH3B_V_E5.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFLecturaPlacaOit.88
            public void actionPerformed(ActionEvent evt) {
                JIFLecturaPlacaOit.this.JCH3B_V_E5ActionPerformed(evt);
            }
        });
        this.JBG3BER2.add(this.JCH3B_V_E6);
        this.JCH3B_V_E6.setFont(new Font("Arial", 1, 12));
        this.JCH3B_V_E6.setText("3");
        this.JCH3B_V_E6.setHorizontalAlignment(0);
        this.JCH3B_V_E6.setHorizontalTextPosition(2);
        this.JCH3B_V_E6.setIconTextGap(1);
        this.JCH3B_V_E6.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFLecturaPlacaOit.89
            public void actionPerformed(ActionEvent evt) {
                JIFLecturaPlacaOit.this.JCH3B_V_E6ActionPerformed(evt);
            }
        });
        this.jSeparator3.setOrientation(1);
        this.JLB3BExtension1.setFont(new Font("Arial", 1, 12));
        this.JLB3BExtension1.setForeground(Color.blue);
        this.JLB3BExtension1.setHorizontalAlignment(0);
        this.JLB3BExtension1.setText("<html><P ALIGN=center>Ancho en perfil solamente");
        this.JLB3BExtension1.setAutoscrolls(true);
        this.JLB3BExtension1.setHorizontalTextPosition(4);
        this.JBG3BAV1.add(this.JCH3B_Ancho_O1);
        this.JCH3B_Ancho_O1.setFont(new Font("Arial", 1, 12));
        this.JCH3B_Ancho_O1.setText("O");
        this.JCH3B_Ancho_O1.setHorizontalAlignment(0);
        this.JCH3B_Ancho_O1.setHorizontalTextPosition(2);
        this.JCH3B_Ancho_O1.setIconTextGap(1);
        this.JCH3B_Ancho_O1.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFLecturaPlacaOit.90
            public void actionPerformed(ActionEvent evt) {
                JIFLecturaPlacaOit.this.JCH3B_Ancho_O1ActionPerformed(evt);
            }
        });
        this.JBG3BAV1.add(this.JCH3B_Ancho_R1);
        this.JCH3B_Ancho_R1.setFont(new Font("Arial", 1, 12));
        this.JCH3B_Ancho_R1.setText("R");
        this.JCH3B_Ancho_R1.setHorizontalAlignment(0);
        this.JCH3B_Ancho_R1.setHorizontalTextPosition(2);
        this.JCH3B_Ancho_R1.setIconTextGap(1);
        this.JCH3B_Ancho_R1.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFLecturaPlacaOit.91
            public void actionPerformed(ActionEvent evt) {
                JIFLecturaPlacaOit.this.JCH3B_Ancho_R1ActionPerformed(evt);
            }
        });
        this.JBG3BAR1.add(this.JCH3B_V_A1);
        this.JCH3B_V_A1.setFont(new Font("Arial", 1, 12));
        this.JCH3B_V_A1.setText("a");
        this.JCH3B_V_A1.setHorizontalAlignment(0);
        this.JCH3B_V_A1.setHorizontalTextPosition(2);
        this.JCH3B_V_A1.setIconTextGap(1);
        this.JCH3B_V_A1.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFLecturaPlacaOit.92
            public void actionPerformed(ActionEvent evt) {
                JIFLecturaPlacaOit.this.JCH3B_V_A1ActionPerformed(evt);
            }
        });
        this.JBG3BAR1.add(this.JCH3B_V_A2);
        this.JCH3B_V_A2.setFont(new Font("Arial", 1, 12));
        this.JCH3B_V_A2.setText("b");
        this.JCH3B_V_A2.setHorizontalAlignment(0);
        this.JCH3B_V_A2.setHorizontalTextPosition(2);
        this.JCH3B_V_A2.setIconTextGap(1);
        this.JCH3B_V_A2.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFLecturaPlacaOit.93
            public void actionPerformed(ActionEvent evt) {
                JIFLecturaPlacaOit.this.JCH3B_V_A2ActionPerformed(evt);
            }
        });
        this.JBG3BAR1.add(this.JCH3B_V_A3);
        this.JCH3B_V_A3.setFont(new Font("Arial", 1, 12));
        this.JCH3B_V_A3.setText("c");
        this.JCH3B_V_A3.setHorizontalAlignment(0);
        this.JCH3B_V_A3.setHorizontalTextPosition(2);
        this.JCH3B_V_A3.setIconTextGap(1);
        this.JCH3B_V_A3.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFLecturaPlacaOit.94
            public void actionPerformed(ActionEvent evt) {
                JIFLecturaPlacaOit.this.JCH3B_V_A3ActionPerformed(evt);
            }
        });
        this.JBG3BAV2.add(this.JCH3B_Ancho_O2);
        this.JCH3B_Ancho_O2.setFont(new Font("Arial", 1, 12));
        this.JCH3B_Ancho_O2.setText("O");
        this.JCH3B_Ancho_O2.setHorizontalAlignment(0);
        this.JCH3B_Ancho_O2.setHorizontalTextPosition(2);
        this.JCH3B_Ancho_O2.setIconTextGap(1);
        this.JCH3B_Ancho_O2.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFLecturaPlacaOit.95
            public void actionPerformed(ActionEvent evt) {
                JIFLecturaPlacaOit.this.JCH3B_Ancho_O2ActionPerformed(evt);
            }
        });
        this.JBG3BAV2.add(this.JCH3B_Ancho_L2);
        this.JCH3B_Ancho_L2.setFont(new Font("Arial", 1, 12));
        this.JCH3B_Ancho_L2.setText("L");
        this.JCH3B_Ancho_L2.setHorizontalAlignment(0);
        this.JCH3B_Ancho_L2.setHorizontalTextPosition(2);
        this.JCH3B_Ancho_L2.setIconTextGap(1);
        this.JCH3B_Ancho_L2.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFLecturaPlacaOit.96
            public void actionPerformed(ActionEvent evt) {
                JIFLecturaPlacaOit.this.JCH3B_Ancho_L2ActionPerformed(evt);
            }
        });
        this.JBG3BAR2.add(this.JCH3B_V_A4);
        this.JCH3B_V_A4.setFont(new Font("Arial", 1, 12));
        this.JCH3B_V_A4.setText("a");
        this.JCH3B_V_A4.setHorizontalAlignment(0);
        this.JCH3B_V_A4.setHorizontalTextPosition(2);
        this.JCH3B_V_A4.setIconTextGap(1);
        this.JCH3B_V_A4.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFLecturaPlacaOit.97
            public void actionPerformed(ActionEvent evt) {
                JIFLecturaPlacaOit.this.JCH3B_V_A4ActionPerformed(evt);
            }
        });
        this.JBG3BAR2.add(this.JCH3B_V_A5);
        this.JCH3B_V_A5.setFont(new Font("Arial", 1, 12));
        this.JCH3B_V_A5.setText("b");
        this.JCH3B_V_A5.setHorizontalAlignment(0);
        this.JCH3B_V_A5.setHorizontalTextPosition(2);
        this.JCH3B_V_A5.setIconTextGap(1);
        this.JCH3B_V_A5.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFLecturaPlacaOit.98
            public void actionPerformed(ActionEvent evt) {
                JIFLecturaPlacaOit.this.JCH3B_V_A5ActionPerformed(evt);
            }
        });
        this.JBG3BAR2.add(this.JCH3B_V_A6);
        this.JCH3B_V_A6.setFont(new Font("Arial", 1, 12));
        this.JCH3B_V_A6.setText("c");
        this.JCH3B_V_A6.setHorizontalAlignment(0);
        this.JCH3B_V_A6.setHorizontalTextPosition(2);
        this.JCH3B_V_A6.setIconTextGap(1);
        this.JCH3B_V_A6.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFLecturaPlacaOit.99
            public void actionPerformed(ActionEvent evt) {
                JIFLecturaPlacaOit.this.JCH3B_V_A6ActionPerformed(evt);
            }
        });
        GroupLayout JPI3BPlacasLayout = new GroupLayout(this.JPI3BPlacas);
        this.JPI3BPlacas.setLayout(JPI3BPlacasLayout);
        JPI3BPlacasLayout.setHorizontalGroup(JPI3BPlacasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI3BPlacasLayout.createSequentialGroup().addContainerGap().addGroup(JPI3BPlacasLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JLB3BPerfil, -1, -1, 32767).addComponent(this.JLB3BDiafragma, -1, -1, 32767).addComponent(this.JLB3BFrente, -1, -1, 32767).addComponent(this.JLB3BOtroSitio, -1, -1, 32767)).addGap(18, 18, 18).addGroup(JPI3BPlacasLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPI3BPlacasLayout.createSequentialGroup().addComponent(this.JCH3B_SO_O).addGap(8, 8, 8).addComponent(this.JCH3B_SO_R)).addGroup(JPI3BPlacasLayout.createSequentialGroup().addGroup(JPI3BPlacasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCH3B_SD_O, -2, 31, -2).addComponent(this.JCH3B_SF_O)).addGap(8, 8, 8).addGroup(JPI3BPlacasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCH3B_SD_R).addComponent(this.JCH3B_SF_R))).addGroup(JPI3BPlacasLayout.createSequentialGroup().addComponent(this.JCH3B_SP_O).addGap(8, 8, 8).addComponent(this.JCH3B_SP_R).addGroup(JPI3BPlacasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPI3BPlacasLayout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.JCH3B_SP_L, -2, 31, -2)).addGroup(JPI3BPlacasLayout.createSequentialGroup().addGap(12, 12, 12).addGroup(JPI3BPlacasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCH3B_SO_L).addComponent(this.JCH3B_SD_L).addComponent(this.JCH3B_SF_L))))).addComponent(this.JLB3BParedToracica, -2, 111, -2)).addGap(10, 10, 10).addComponent(this.jSeparator1, -2, -1, -2).addGroup(JPI3BPlacasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI3BPlacasLayout.createSequentialGroup().addGap(18, 18, 18).addGroup(JPI3BPlacasLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPI3BPlacasLayout.createSequentialGroup().addComponent(this.JCH3B_CO_O).addGap(8, 8, 8).addComponent(this.JCH3B_CO_R)).addGroup(JPI3BPlacasLayout.createSequentialGroup().addGroup(JPI3BPlacasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCH3B_CD_O, -2, 31, -2).addComponent(this.JCH3B_CF_O)).addGap(8, 8, 8).addGroup(JPI3BPlacasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCH3B_CD_R).addComponent(this.JCH3B_CF_R))).addGroup(JPI3BPlacasLayout.createSequentialGroup().addComponent(this.JCH3B_CP_O).addGap(8, 8, 8).addComponent(this.JCH3B_CP_R).addGroup(JPI3BPlacasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPI3BPlacasLayout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.JCH3B_CP_L, -2, 31, -2)).addGroup(JPI3BPlacasLayout.createSequentialGroup().addGap(12, 12, 12).addGroup(JPI3BPlacasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCH3B_CO_L).addComponent(this.JCH3B_CD_L).addComponent(this.JCH3B_CF_L))))))).addGroup(GroupLayout.Alignment.TRAILING, JPI3BPlacasLayout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.JLB3BCalcificacion, -2, 119, -2))).addGap(18, 18, 18).addComponent(this.jSeparator2, -2, 2, -2).addGap(18, 18, 18).addGroup(JPI3BPlacasLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JLB3BExtension, -2, 226, -2).addGroup(JPI3BPlacasLayout.createSequentialGroup().addGroup(JPI3BPlacasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI3BPlacasLayout.createSequentialGroup().addComponent(this.JCH3B_Extension_O).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCH3B_Extension_R)).addGroup(JPI3BPlacasLayout.createSequentialGroup().addComponent(this.JCH3B_V_E1).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCH3B_V_E2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCH3B_V_E3))).addGap(44, 44, 44).addGroup(JPI3BPlacasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI3BPlacasLayout.createSequentialGroup().addComponent(this.JCH3B_Extension_O1).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCH3B_Extension_L1)).addGroup(JPI3BPlacasLayout.createSequentialGroup().addComponent(this.JCH3B_V_E4).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCH3B_V_E5).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCH3B_V_E6))))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.jSeparator3, -2, -1, -2).addGap(51, 51, 51).addGroup(JPI3BPlacasLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JLB3BExtension1, -2, 226, -2).addGroup(JPI3BPlacasLayout.createSequentialGroup().addGroup(JPI3BPlacasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI3BPlacasLayout.createSequentialGroup().addComponent(this.JCH3B_Ancho_O1).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCH3B_Ancho_R1)).addGroup(JPI3BPlacasLayout.createSequentialGroup().addComponent(this.JCH3B_V_A1).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCH3B_V_A2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCH3B_V_A3))).addGap(44, 44, 44).addGroup(JPI3BPlacasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI3BPlacasLayout.createSequentialGroup().addComponent(this.JCH3B_Ancho_O2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCH3B_Ancho_L2)).addGroup(JPI3BPlacasLayout.createSequentialGroup().addComponent(this.JCH3B_V_A4).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCH3B_V_A5).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCH3B_V_A6))))).addGap(32, 32, 32)));
        JPI3BPlacasLayout.setVerticalGroup(JPI3BPlacasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI3BPlacasLayout.createSequentialGroup().addGroup(JPI3BPlacasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI3BPlacasLayout.createSequentialGroup().addGroup(JPI3BPlacasLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jSeparator1, GroupLayout.Alignment.TRAILING).addComponent(this.jSeparator2, GroupLayout.Alignment.TRAILING).addGroup(JPI3BPlacasLayout.createSequentialGroup().addGroup(JPI3BPlacasLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JLB3BParedToracica).addComponent(this.JLB3BCalcificacion)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPI3BPlacasLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPI3BPlacasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI3BPlacasLayout.createSequentialGroup().addGroup(JPI3BPlacasLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCH3B_SP_O).addComponent(this.JCH3B_SP_R).addComponent(this.JLB3BPerfil)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPI3BPlacasLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPI3BPlacasLayout.createSequentialGroup().addGroup(JPI3BPlacasLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCH3B_SF_O).addComponent(this.JLB3BFrente)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPI3BPlacasLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCH3B_SD_O).addComponent(this.JLB3BDiafragma))).addGroup(JPI3BPlacasLayout.createSequentialGroup().addComponent(this.JCH3B_SF_R).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCH3B_SD_R))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPI3BPlacasLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCH3B_SO_O).addComponent(this.JCH3B_SO_R).addComponent(this.JLB3BOtroSitio))).addGroup(JPI3BPlacasLayout.createSequentialGroup().addComponent(this.JCH3B_SP_L).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCH3B_SF_L).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCH3B_SD_L).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCH3B_SO_L))).addGroup(JPI3BPlacasLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPI3BPlacasLayout.createSequentialGroup().addGroup(JPI3BPlacasLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCH3B_CP_O).addComponent(this.JCH3B_CP_R)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPI3BPlacasLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPI3BPlacasLayout.createSequentialGroup().addComponent(this.JCH3B_CF_O).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCH3B_CD_O)).addGroup(JPI3BPlacasLayout.createSequentialGroup().addComponent(this.JCH3B_CF_R).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCH3B_CD_R))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPI3BPlacasLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCH3B_CO_O).addComponent(this.JCH3B_CO_R))).addGroup(JPI3BPlacasLayout.createSequentialGroup().addComponent(this.JCH3B_CP_L).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCH3B_CF_L).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCH3B_CD_L).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCH3B_CO_L))))).addGroup(JPI3BPlacasLayout.createSequentialGroup().addComponent(this.JLB3BExtension, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(JPI3BPlacasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPI3BPlacasLayout.createSequentialGroup().addGroup(JPI3BPlacasLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCH3B_Extension_O).addComponent(this.JCH3B_Extension_R)).addGap(3, 3, 3).addGroup(JPI3BPlacasLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCH3B_V_E1).addComponent(this.JCH3B_V_E2).addComponent(this.JCH3B_V_E3))).addGroup(GroupLayout.Alignment.TRAILING, JPI3BPlacasLayout.createSequentialGroup().addGroup(JPI3BPlacasLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCH3B_Extension_O1).addComponent(this.JCH3B_Extension_L1)).addGap(3, 3, 3).addGroup(JPI3BPlacasLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCH3B_V_E4).addComponent(this.JCH3B_V_E5).addComponent(this.JCH3B_V_E6))))).addComponent(this.jSeparator3, GroupLayout.Alignment.TRAILING, -2, 109, -2)).addGap(0, 0, 32767)).addGroup(JPI3BPlacasLayout.createSequentialGroup().addComponent(this.JLB3BExtension1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(JPI3BPlacasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPI3BPlacasLayout.createSequentialGroup().addGroup(JPI3BPlacasLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCH3B_Ancho_O1).addComponent(this.JCH3B_Ancho_R1)).addGap(3, 3, 3).addGroup(JPI3BPlacasLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCH3B_V_A1).addComponent(this.JCH3B_V_A2).addComponent(this.JCH3B_V_A3))).addGroup(GroupLayout.Alignment.TRAILING, JPI3BPlacasLayout.createSequentialGroup().addGroup(JPI3BPlacasLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCH3B_Ancho_O2).addComponent(this.JCH3B_Ancho_L2)).addGap(3, 3, 3).addGroup(JPI3BPlacasLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCH3B_V_A4).addComponent(this.JCH3B_V_A5).addComponent(this.JCH3B_V_A6)))))).addContainerGap()));
        GroupLayout JPNVentanaLayout = new GroupLayout(this.JPNVentana);
        this.JPNVentana.setLayout(JPNVentanaLayout);
        JPNVentanaLayout.setHorizontalGroup(JPNVentanaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPNVentanaLayout.createSequentialGroup().addContainerGap().addGroup(JPNVentanaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPNVentanaLayout.createSequentialGroup().addGroup(JPNVentanaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JDCFecha, -2, 127, -2).addComponent(this.JPITipo, -2, -1, -2)).addGap(18, 18, 18).addComponent(this.JPI1CalidadP, -1, -1, 32767).addGap(20, 20, 20)).addGroup(JPNVentanaLayout.createSequentialGroup().addComponent(this.JPI2A, -1, -1, 32767).addContainerGap()).addGroup(JPNVentanaLayout.createSequentialGroup().addComponent(this.JPI2B, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPI2COpacidadesG, -1, -1, 32767).addContainerGap()).addGroup(GroupLayout.Alignment.TRAILING, JPNVentanaLayout.createSequentialGroup().addComponent(this.JPI3A, -1, -1, 32767).addContainerGap()).addComponent(this.JPI3BPlacas, -1, -1, 32767))));
        JPNVentanaLayout.setVerticalGroup(JPNVentanaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPNVentanaLayout.createSequentialGroup().addContainerGap().addGroup(JPNVentanaLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JPI1CalidadP, -2, -1, -2).addGroup(JPNVentanaLayout.createSequentialGroup().addComponent(this.JDCFecha, -2, 59, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPITipo, -2, -1, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPI2A, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPNVentanaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPI2B, -2, -1, -2).addComponent(this.JPI2COpacidadesG, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JPI3A, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPI3BPlacas, -2, 139, -2).addContainerGap(-1, 32767)));
        this.JTPDetalle.addTab("SECCION (1, 2A, 2B, 2C, 3A, 3B)", this.JPNVentana);
        this.JPI3C.setBorder(BorderFactory.createTitledBorder((Border) null, "3C.", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JLB3C_Pregunta.setFont(new Font("Arial", 1, 12));
        this.JLB3C_Pregunta.setForeground(Color.red);
        this.JLB3C_Pregunta.setText("Obliteración del ángulo costo frénetico");
        this.JCH3C_R.setFont(new Font("Arial", 1, 12));
        this.JCH3C_R.setText("R");
        this.JCH3C_R.setHorizontalAlignment(0);
        this.JCH3C_R.setHorizontalTextPosition(4);
        this.JCH3C_R.setVerticalTextPosition(1);
        this.JCH3C_R.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFLecturaPlacaOit.100
            public void actionPerformed(ActionEvent evt) {
                JIFLecturaPlacaOit.this.JCH3C_RActionPerformed(evt);
            }
        });
        this.JCH3C_L.setFont(new Font("Arial", 1, 12));
        this.JCH3C_L.setText("L (procede a sección 3D)");
        this.JCH3C_L.setHorizontalAlignment(0);
        this.JCH3C_L.setHorizontalTextPosition(4);
        this.JCH3C_L.setVerticalTextPosition(1);
        this.JCH3C_L.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFLecturaPlacaOit.101
            public void actionPerformed(ActionEvent evt) {
                JIFLecturaPlacaOit.this.JCH3C_LActionPerformed(evt);
            }
        });
        this.JCH3C_No.setFont(new Font("Arial", 1, 12));
        this.JCH3C_No.setSelected(true);
        this.JCH3C_No.setText("NO (pase a sección 4A)");
        this.JCH3C_No.setHorizontalAlignment(0);
        this.JCH3C_No.setHorizontalTextPosition(4);
        this.JCH3C_No.setVerticalTextPosition(1);
        this.JCH3C_No.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFLecturaPlacaOit.102
            public void actionPerformed(ActionEvent evt) {
                JIFLecturaPlacaOit.this.JCH3C_NoActionPerformed(evt);
            }
        });
        GroupLayout JPI3CLayout = new GroupLayout(this.JPI3C);
        this.JPI3C.setLayout(JPI3CLayout);
        JPI3CLayout.setHorizontalGroup(JPI3CLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI3CLayout.createSequentialGroup().addContainerGap().addComponent(this.JLB3C_Pregunta, -2, 346, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCH3C_R).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCH3C_L).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JCH3C_No).addGap(106, 106, 106)));
        JPI3CLayout.setVerticalGroup(JPI3CLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLB3C_Pregunta, -1, -1, 32767).addGroup(JPI3CLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JCH3C_L, -2, 15, -2).addComponent(this.JCH3C_R, GroupLayout.Alignment.LEADING, -2, 15, -2)).addComponent(this.JCH3C_No, -2, 15, -2));
        this.JPI3DEngrosamientoPD.setBorder(BorderFactory.createTitledBorder((Border) null, "3D. ENGROSAMIENTO PLEURAL DIFUSO", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JLB3DParedToracica.setFont(new Font("Arial", 1, 12));
        this.JLB3DParedToracica.setForeground(Color.blue);
        this.JLB3DParedToracica.setHorizontalAlignment(0);
        this.JLB3DParedToracica.setText("Pared Torácica");
        this.JCH3DC_SP_O.setFont(new Font("Arial", 1, 12));
        this.JCH3DC_SP_O.setText("O");
        this.JCH3DC_SP_O.setHorizontalAlignment(0);
        this.JCH3DC_SP_O.setHorizontalTextPosition(2);
        this.JCH3DC_SP_O.setIconTextGap(1);
        this.JCH3DC_SP_O.setVerticalAlignment(1);
        this.JCH3DC_SP_O.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFLecturaPlacaOit.103
            public void actionPerformed(ActionEvent evt) {
                JIFLecturaPlacaOit.this.JCH3DC_SP_OActionPerformed(evt);
            }
        });
        this.JCH3DC_SP_R.setFont(new Font("Arial", 1, 12));
        this.JCH3DC_SP_R.setText("R");
        this.JCH3DC_SP_R.setHorizontalAlignment(0);
        this.JCH3DC_SP_R.setHorizontalTextPosition(2);
        this.JCH3DC_SP_R.setIconTextGap(1);
        this.JCH3DC_SP_R.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFLecturaPlacaOit.104
            public void actionPerformed(ActionEvent evt) {
                JIFLecturaPlacaOit.this.JCH3DC_SP_RActionPerformed(evt);
            }
        });
        this.JCH3D_SP_L.setFont(new Font("Arial", 1, 12));
        this.JCH3D_SP_L.setText("L");
        this.JCH3D_SP_L.setHorizontalAlignment(0);
        this.JCH3D_SP_L.setHorizontalTextPosition(2);
        this.JCH3D_SP_L.setIconTextGap(1);
        this.JCH3D_SP_L.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFLecturaPlacaOit.105
            public void actionPerformed(ActionEvent evt) {
                JIFLecturaPlacaOit.this.JCH3D_SP_LActionPerformed(evt);
            }
        });
        this.JCH3D_SF_O.setFont(new Font("Arial", 1, 12));
        this.JCH3D_SF_O.setText("O");
        this.JCH3D_SF_O.setHorizontalAlignment(0);
        this.JCH3D_SF_O.setHorizontalTextPosition(2);
        this.JCH3D_SF_O.setIconTextGap(1);
        this.JCH3D_SF_O.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFLecturaPlacaOit.106
            public void actionPerformed(ActionEvent evt) {
                JIFLecturaPlacaOit.this.JCH3D_SF_OActionPerformed(evt);
            }
        });
        this.JCH3D_SF_R.setFont(new Font("Arial", 1, 12));
        this.JCH3D_SF_R.setText("R");
        this.JCH3D_SF_R.setHorizontalAlignment(0);
        this.JCH3D_SF_R.setHorizontalTextPosition(2);
        this.JCH3D_SF_R.setIconTextGap(1);
        this.JCH3D_SF_R.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFLecturaPlacaOit.107
            public void actionPerformed(ActionEvent evt) {
                JIFLecturaPlacaOit.this.JCH3D_SF_RActionPerformed(evt);
            }
        });
        this.JCH3D_SF_L.setFont(new Font("Arial", 1, 12));
        this.JCH3D_SF_L.setText("L");
        this.JCH3D_SF_L.setHorizontalAlignment(0);
        this.JCH3D_SF_L.setHorizontalTextPosition(2);
        this.JCH3D_SF_L.setIconTextGap(1);
        this.JCH3D_SF_L.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFLecturaPlacaOit.108
            public void actionPerformed(ActionEvent evt) {
                JIFLecturaPlacaOit.this.JCH3D_SF_LActionPerformed(evt);
            }
        });
        this.JLB3DPerfil.setFont(new Font("Arial", 1, 12));
        this.JLB3DPerfil.setForeground(Color.blue);
        this.JLB3DPerfil.setHorizontalAlignment(4);
        this.JLB3DPerfil.setText("En el perfil");
        this.JLB3DFrente.setFont(new Font("Arial", 1, 12));
        this.JLB3DFrente.setForeground(Color.blue);
        this.JLB3DFrente.setHorizontalAlignment(4);
        this.JLB3DFrente.setText("De  frente");
        this.jSeparator4.setOrientation(1);
        this.JLB3DCalcificacion.setFont(new Font("Arial", 1, 12));
        this.JLB3DCalcificacion.setForeground(Color.blue);
        this.JLB3DCalcificacion.setHorizontalAlignment(0);
        this.JLB3DCalcificacion.setText("Calcificación");
        this.JCH3D_CP_O.setFont(new Font("Arial", 1, 12));
        this.JCH3D_CP_O.setText("O");
        this.JCH3D_CP_O.setHorizontalAlignment(0);
        this.JCH3D_CP_O.setHorizontalTextPosition(2);
        this.JCH3D_CP_O.setIconTextGap(1);
        this.JCH3D_CP_O.setVerticalAlignment(1);
        this.JCH3D_CP_O.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFLecturaPlacaOit.109
            public void actionPerformed(ActionEvent evt) {
                JIFLecturaPlacaOit.this.JCH3D_CP_OActionPerformed(evt);
            }
        });
        this.JCH3D_CF_O.setFont(new Font("Arial", 1, 12));
        this.JCH3D_CF_O.setText("O");
        this.JCH3D_CF_O.setHorizontalAlignment(0);
        this.JCH3D_CF_O.setHorizontalTextPosition(2);
        this.JCH3D_CF_O.setIconTextGap(1);
        this.JCH3D_CF_O.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFLecturaPlacaOit.110
            public void actionPerformed(ActionEvent evt) {
                JIFLecturaPlacaOit.this.JCH3D_CF_OActionPerformed(evt);
            }
        });
        this.JCH3D_CP_R.setFont(new Font("Arial", 1, 12));
        this.JCH3D_CP_R.setText("R");
        this.JCH3D_CP_R.setHorizontalAlignment(0);
        this.JCH3D_CP_R.setHorizontalTextPosition(2);
        this.JCH3D_CP_R.setIconTextGap(1);
        this.JCH3D_CP_R.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFLecturaPlacaOit.111
            public void actionPerformed(ActionEvent evt) {
                JIFLecturaPlacaOit.this.JCH3D_CP_RActionPerformed(evt);
            }
        });
        this.JCH3D_CF_R.setFont(new Font("Arial", 1, 12));
        this.JCH3D_CF_R.setText("R");
        this.JCH3D_CF_R.setHorizontalAlignment(0);
        this.JCH3D_CF_R.setHorizontalTextPosition(2);
        this.JCH3D_CF_R.setIconTextGap(1);
        this.JCH3D_CF_R.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFLecturaPlacaOit.112
            public void actionPerformed(ActionEvent evt) {
                JIFLecturaPlacaOit.this.JCH3D_CF_RActionPerformed(evt);
            }
        });
        this.JCH3D_CP_L.setFont(new Font("Arial", 1, 12));
        this.JCH3D_CP_L.setText("L");
        this.JCH3D_CP_L.setHorizontalAlignment(0);
        this.JCH3D_CP_L.setHorizontalTextPosition(2);
        this.JCH3D_CP_L.setIconTextGap(1);
        this.JCH3D_CP_L.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFLecturaPlacaOit.113
            public void actionPerformed(ActionEvent evt) {
                JIFLecturaPlacaOit.this.JCH3D_CP_LActionPerformed(evt);
            }
        });
        this.JCH3D_CF_L.setFont(new Font("Arial", 1, 12));
        this.JCH3D_CF_L.setText("L");
        this.JCH3D_CF_L.setHorizontalAlignment(0);
        this.JCH3D_CF_L.setHorizontalTextPosition(2);
        this.JCH3D_CF_L.setIconTextGap(1);
        this.JCH3D_CF_L.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFLecturaPlacaOit.114
            public void actionPerformed(ActionEvent evt) {
                JIFLecturaPlacaOit.this.JCH3D_CF_LActionPerformed(evt);
            }
        });
        this.jSeparator5.setOrientation(1);
        this.JLB3DExtension.setFont(new Font("Arial", 1, 12));
        this.JLB3DExtension.setForeground(Color.blue);
        this.JLB3DExtension.setHorizontalAlignment(0);
        this.JLB3DExtension.setText("<html><P ALIGN=center>Extensión (pared torácica; combinada en perfil y de frente)");
        this.JLB3DExtension.setAutoscrolls(true);
        this.JLB3DExtension.setHorizontalTextPosition(4);
        this.JBG3DEV1.add(this.JCH3D_Extension_O);
        this.JCH3D_Extension_O.setFont(new Font("Arial", 1, 12));
        this.JCH3D_Extension_O.setText("O");
        this.JCH3D_Extension_O.setHorizontalAlignment(0);
        this.JCH3D_Extension_O.setHorizontalTextPosition(2);
        this.JCH3D_Extension_O.setIconTextGap(1);
        this.JCH3D_Extension_O.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFLecturaPlacaOit.115
            public void actionPerformed(ActionEvent evt) {
                JIFLecturaPlacaOit.this.JCH3D_Extension_OActionPerformed(evt);
            }
        });
        this.JBG3DEV1.add(this.JCH3D_Extension_R);
        this.JCH3D_Extension_R.setFont(new Font("Arial", 1, 12));
        this.JCH3D_Extension_R.setText("R");
        this.JCH3D_Extension_R.setHorizontalAlignment(0);
        this.JCH3D_Extension_R.setHorizontalTextPosition(2);
        this.JCH3D_Extension_R.setIconTextGap(1);
        this.JCH3D_Extension_R.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFLecturaPlacaOit.116
            public void actionPerformed(ActionEvent evt) {
                JIFLecturaPlacaOit.this.JCH3D_Extension_RActionPerformed(evt);
            }
        });
        this.JBG3DER1.add(this.JCH3D_V_E1);
        this.JCH3D_V_E1.setFont(new Font("Arial", 1, 12));
        this.JCH3D_V_E1.setText("1");
        this.JCH3D_V_E1.setHorizontalAlignment(0);
        this.JCH3D_V_E1.setHorizontalTextPosition(2);
        this.JCH3D_V_E1.setIconTextGap(1);
        this.JCH3D_V_E1.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFLecturaPlacaOit.117
            public void actionPerformed(ActionEvent evt) {
                JIFLecturaPlacaOit.this.JCH3D_V_E1ActionPerformed(evt);
            }
        });
        this.JBG3DER1.add(this.JCH3D_V_E2);
        this.JCH3D_V_E2.setFont(new Font("Arial", 1, 12));
        this.JCH3D_V_E2.setText("2");
        this.JCH3D_V_E2.setHorizontalAlignment(0);
        this.JCH3D_V_E2.setHorizontalTextPosition(2);
        this.JCH3D_V_E2.setIconTextGap(1);
        this.JCH3D_V_E2.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFLecturaPlacaOit.118
            public void actionPerformed(ActionEvent evt) {
                JIFLecturaPlacaOit.this.JCH3D_V_E2ActionPerformed(evt);
            }
        });
        this.JBG3DER1.add(this.JCH3D_V_E3);
        this.JCH3D_V_E3.setFont(new Font("Arial", 1, 12));
        this.JCH3D_V_E3.setText("3");
        this.JCH3D_V_E3.setHorizontalAlignment(0);
        this.JCH3D_V_E3.setHorizontalTextPosition(2);
        this.JCH3D_V_E3.setIconTextGap(1);
        this.JCH3D_V_E3.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFLecturaPlacaOit.119
            public void actionPerformed(ActionEvent evt) {
                JIFLecturaPlacaOit.this.JCH3D_V_E3ActionPerformed(evt);
            }
        });
        this.JBG3DEV2.add(this.JCH3D_Extension_O1);
        this.JCH3D_Extension_O1.setFont(new Font("Arial", 1, 12));
        this.JCH3D_Extension_O1.setText("O");
        this.JCH3D_Extension_O1.setHorizontalAlignment(0);
        this.JCH3D_Extension_O1.setHorizontalTextPosition(2);
        this.JCH3D_Extension_O1.setIconTextGap(1);
        this.JCH3D_Extension_O1.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFLecturaPlacaOit.120
            public void actionPerformed(ActionEvent evt) {
                JIFLecturaPlacaOit.this.JCH3D_Extension_O1ActionPerformed(evt);
            }
        });
        this.JBG3DEV2.add(this.JCH3D_Extension_L1);
        this.JCH3D_Extension_L1.setFont(new Font("Arial", 1, 12));
        this.JCH3D_Extension_L1.setText("L");
        this.JCH3D_Extension_L1.setHorizontalAlignment(0);
        this.JCH3D_Extension_L1.setHorizontalTextPosition(2);
        this.JCH3D_Extension_L1.setIconTextGap(1);
        this.JCH3D_Extension_L1.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFLecturaPlacaOit.121
            public void actionPerformed(ActionEvent evt) {
                JIFLecturaPlacaOit.this.JCH3D_Extension_L1ActionPerformed(evt);
            }
        });
        this.JBG3DER2.add(this.JCH3D_V_E4);
        this.JCH3D_V_E4.setFont(new Font("Arial", 1, 12));
        this.JCH3D_V_E4.setText("1");
        this.JCH3D_V_E4.setHorizontalAlignment(0);
        this.JCH3D_V_E4.setHorizontalTextPosition(2);
        this.JCH3D_V_E4.setIconTextGap(1);
        this.JCH3D_V_E4.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFLecturaPlacaOit.122
            public void actionPerformed(ActionEvent evt) {
                JIFLecturaPlacaOit.this.JCH3D_V_E4ActionPerformed(evt);
            }
        });
        this.JBG3DER2.add(this.JCH3D_V_E5);
        this.JCH3D_V_E5.setFont(new Font("Arial", 1, 12));
        this.JCH3D_V_E5.setText("2");
        this.JCH3D_V_E5.setHorizontalAlignment(0);
        this.JCH3D_V_E5.setHorizontalTextPosition(2);
        this.JCH3D_V_E5.setIconTextGap(1);
        this.JCH3D_V_E5.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFLecturaPlacaOit.123
            public void actionPerformed(ActionEvent evt) {
                JIFLecturaPlacaOit.this.JCH3D_V_E5ActionPerformed(evt);
            }
        });
        this.JBG3DER2.add(this.JCH3D_V_E6);
        this.JCH3D_V_E6.setFont(new Font("Arial", 1, 12));
        this.JCH3D_V_E6.setText("3");
        this.JCH3D_V_E6.setHorizontalAlignment(0);
        this.JCH3D_V_E6.setHorizontalTextPosition(2);
        this.JCH3D_V_E6.setIconTextGap(1);
        this.JCH3D_V_E6.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFLecturaPlacaOit.124
            public void actionPerformed(ActionEvent evt) {
                JIFLecturaPlacaOit.this.JCH3D_V_E6ActionPerformed(evt);
            }
        });
        this.jSeparator6.setOrientation(1);
        this.JLB3BExtension3.setFont(new Font("Arial", 1, 12));
        this.JLB3BExtension3.setForeground(Color.blue);
        this.JLB3BExtension3.setHorizontalAlignment(0);
        this.JLB3BExtension3.setText("<html><P ALIGN=center>Ancho en perfil solamente");
        this.JLB3BExtension3.setAutoscrolls(true);
        this.JLB3BExtension3.setHorizontalTextPosition(4);
        this.JBG3DAV3.add(this.JCH3D_Ancho_O);
        this.JCH3D_Ancho_O.setFont(new Font("Arial", 1, 12));
        this.JCH3D_Ancho_O.setText("O");
        this.JCH3D_Ancho_O.setHorizontalAlignment(0);
        this.JCH3D_Ancho_O.setHorizontalTextPosition(2);
        this.JCH3D_Ancho_O.setIconTextGap(1);
        this.JCH3D_Ancho_O.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFLecturaPlacaOit.125
            public void actionPerformed(ActionEvent evt) {
                JIFLecturaPlacaOit.this.JCH3D_Ancho_OActionPerformed(evt);
            }
        });
        this.JBG3DAV3.add(this.JCH3D_Ancho_R);
        this.JCH3D_Ancho_R.setFont(new Font("Arial", 1, 12));
        this.JCH3D_Ancho_R.setText("R");
        this.JCH3D_Ancho_R.setHorizontalAlignment(0);
        this.JCH3D_Ancho_R.setHorizontalTextPosition(2);
        this.JCH3D_Ancho_R.setIconTextGap(1);
        this.JCH3D_Ancho_R.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFLecturaPlacaOit.126
            public void actionPerformed(ActionEvent evt) {
                JIFLecturaPlacaOit.this.JCH3D_Ancho_RActionPerformed(evt);
            }
        });
        this.JBG3DAR3.add(this.JCH3D_V_a);
        this.JCH3D_V_a.setFont(new Font("Arial", 1, 12));
        this.JCH3D_V_a.setText("a");
        this.JCH3D_V_a.setHorizontalAlignment(0);
        this.JCH3D_V_a.setHorizontalTextPosition(2);
        this.JCH3D_V_a.setIconTextGap(1);
        this.JCH3D_V_a.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFLecturaPlacaOit.127
            public void actionPerformed(ActionEvent evt) {
                JIFLecturaPlacaOit.this.JCH3D_V_aActionPerformed(evt);
            }
        });
        this.JBG3DAR3.add(this.JCH3D_V_b);
        this.JCH3D_V_b.setFont(new Font("Arial", 1, 12));
        this.JCH3D_V_b.setText("b");
        this.JCH3D_V_b.setHorizontalAlignment(0);
        this.JCH3D_V_b.setHorizontalTextPosition(2);
        this.JCH3D_V_b.setIconTextGap(1);
        this.JCH3D_V_b.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFLecturaPlacaOit.128
            public void actionPerformed(ActionEvent evt) {
                JIFLecturaPlacaOit.this.JCH3D_V_bActionPerformed(evt);
            }
        });
        this.JBG3DAR3.add(this.JCH3D_V_c);
        this.JCH3D_V_c.setFont(new Font("Arial", 1, 12));
        this.JCH3D_V_c.setText("c");
        this.JCH3D_V_c.setHorizontalAlignment(0);
        this.JCH3D_V_c.setHorizontalTextPosition(2);
        this.JCH3D_V_c.setIconTextGap(1);
        this.JCH3D_V_c.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFLecturaPlacaOit.129
            public void actionPerformed(ActionEvent evt) {
                JIFLecturaPlacaOit.this.JCH3D_V_cActionPerformed(evt);
            }
        });
        this.JBG3DAV4.add(this.JCH3D_Ancho_O1);
        this.JCH3D_Ancho_O1.setFont(new Font("Arial", 1, 12));
        this.JCH3D_Ancho_O1.setText("O");
        this.JCH3D_Ancho_O1.setHorizontalAlignment(0);
        this.JCH3D_Ancho_O1.setHorizontalTextPosition(2);
        this.JCH3D_Ancho_O1.setIconTextGap(1);
        this.JCH3D_Ancho_O1.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFLecturaPlacaOit.130
            public void actionPerformed(ActionEvent evt) {
                JIFLecturaPlacaOit.this.JCH3D_Ancho_O1ActionPerformed(evt);
            }
        });
        this.JBG3DAV4.add(this.JCH3D_Ancho_L);
        this.JCH3D_Ancho_L.setFont(new Font("Arial", 1, 12));
        this.JCH3D_Ancho_L.setText("L");
        this.JCH3D_Ancho_L.setHorizontalAlignment(0);
        this.JCH3D_Ancho_L.setHorizontalTextPosition(2);
        this.JCH3D_Ancho_L.setIconTextGap(1);
        this.JCH3D_Ancho_L.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFLecturaPlacaOit.131
            public void actionPerformed(ActionEvent evt) {
                JIFLecturaPlacaOit.this.JCH3D_Ancho_LActionPerformed(evt);
            }
        });
        this.JBG3DAR4.add(this.JCH3D_V_a1);
        this.JCH3D_V_a1.setFont(new Font("Arial", 1, 12));
        this.JCH3D_V_a1.setText("a");
        this.JCH3D_V_a1.setHorizontalAlignment(0);
        this.JCH3D_V_a1.setHorizontalTextPosition(2);
        this.JCH3D_V_a1.setIconTextGap(1);
        this.JCH3D_V_a1.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFLecturaPlacaOit.132
            public void actionPerformed(ActionEvent evt) {
                JIFLecturaPlacaOit.this.JCH3D_V_a1ActionPerformed(evt);
            }
        });
        this.JBG3DAR4.add(this.JCH3D_V_b1);
        this.JCH3D_V_b1.setFont(new Font("Arial", 1, 12));
        this.JCH3D_V_b1.setText("b");
        this.JCH3D_V_b1.setHorizontalAlignment(0);
        this.JCH3D_V_b1.setHorizontalTextPosition(2);
        this.JCH3D_V_b1.setIconTextGap(1);
        this.JCH3D_V_b1.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFLecturaPlacaOit.133
            public void actionPerformed(ActionEvent evt) {
                JIFLecturaPlacaOit.this.JCH3D_V_b1ActionPerformed(evt);
            }
        });
        this.JBG3DAR4.add(this.JCH3D_V_c1);
        this.JCH3D_V_c1.setFont(new Font("Arial", 1, 12));
        this.JCH3D_V_c1.setText("c");
        this.JCH3D_V_c1.setHorizontalAlignment(0);
        this.JCH3D_V_c1.setHorizontalTextPosition(2);
        this.JCH3D_V_c1.setIconTextGap(1);
        this.JCH3D_V_c1.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFLecturaPlacaOit.134
            public void actionPerformed(ActionEvent evt) {
                JIFLecturaPlacaOit.this.JCH3D_V_c1ActionPerformed(evt);
            }
        });
        GroupLayout JPI3DEngrosamientoPDLayout = new GroupLayout(this.JPI3DEngrosamientoPD);
        this.JPI3DEngrosamientoPD.setLayout(JPI3DEngrosamientoPDLayout);
        JPI3DEngrosamientoPDLayout.setHorizontalGroup(JPI3DEngrosamientoPDLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI3DEngrosamientoPDLayout.createSequentialGroup().addContainerGap().addGroup(JPI3DEngrosamientoPDLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JLB3DParedToracica, -2, 111, -2).addGroup(JPI3DEngrosamientoPDLayout.createSequentialGroup().addGroup(JPI3DEngrosamientoPDLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JLB3DPerfil, -1, -1, 32767).addComponent(this.JLB3DFrente, -2, 59, -2)).addGap(18, 18, 18).addGroup(JPI3DEngrosamientoPDLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPI3DEngrosamientoPDLayout.createSequentialGroup().addComponent(this.JCH3D_SF_O).addGap(8, 8, 8).addComponent(this.JCH3D_SF_R)).addGroup(JPI3DEngrosamientoPDLayout.createSequentialGroup().addComponent(this.JCH3DC_SP_O).addGap(8, 8, 8).addComponent(this.JCH3DC_SP_R).addGroup(JPI3DEngrosamientoPDLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPI3DEngrosamientoPDLayout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.JCH3D_SP_L, -2, 31, -2)).addGroup(JPI3DEngrosamientoPDLayout.createSequentialGroup().addGap(12, 12, 12).addComponent(this.JCH3D_SF_L))))))).addGroup(JPI3DEngrosamientoPDLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI3DEngrosamientoPDLayout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.jSeparator4, -2, -1, -2).addGap(18, 18, 18).addGroup(JPI3DEngrosamientoPDLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPI3DEngrosamientoPDLayout.createSequentialGroup().addComponent(this.JCH3D_CF_O).addGap(8, 8, 8).addComponent(this.JCH3D_CF_R)).addGroup(JPI3DEngrosamientoPDLayout.createSequentialGroup().addComponent(this.JCH3D_CP_O).addGap(8, 8, 8).addComponent(this.JCH3D_CP_R).addGroup(JPI3DEngrosamientoPDLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPI3DEngrosamientoPDLayout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.JCH3D_CP_L, -2, 31, -2)).addGroup(JPI3DEngrosamientoPDLayout.createSequentialGroup().addGap(12, 12, 12).addComponent(this.JCH3D_CF_L)))))).addGroup(GroupLayout.Alignment.TRAILING, JPI3DEngrosamientoPDLayout.createSequentialGroup().addGap(22, 22, 22).addComponent(this.JLB3DCalcificacion, -2, 119, -2))).addGap(18, 18, 18).addComponent(this.jSeparator5, -2, 2, -2).addGap(18, 18, 18).addGroup(JPI3DEngrosamientoPDLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JLB3DExtension, -2, 226, -2).addGroup(JPI3DEngrosamientoPDLayout.createSequentialGroup().addGroup(JPI3DEngrosamientoPDLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI3DEngrosamientoPDLayout.createSequentialGroup().addComponent(this.JCH3D_Extension_O).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCH3D_Extension_R)).addGroup(JPI3DEngrosamientoPDLayout.createSequentialGroup().addComponent(this.JCH3D_V_E1).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCH3D_V_E2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCH3D_V_E3))).addGap(44, 44, 44).addGroup(JPI3DEngrosamientoPDLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI3DEngrosamientoPDLayout.createSequentialGroup().addComponent(this.JCH3D_Extension_O1).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCH3D_Extension_L1)).addGroup(JPI3DEngrosamientoPDLayout.createSequentialGroup().addComponent(this.JCH3D_V_E4).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCH3D_V_E5).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCH3D_V_E6))))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 26, 32767).addComponent(this.jSeparator6, -2, -1, -2).addGap(51, 51, 51).addGroup(JPI3DEngrosamientoPDLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JLB3BExtension3, -2, 226, -2).addGroup(JPI3DEngrosamientoPDLayout.createSequentialGroup().addGroup(JPI3DEngrosamientoPDLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI3DEngrosamientoPDLayout.createSequentialGroup().addComponent(this.JCH3D_Ancho_O).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCH3D_Ancho_R)).addGroup(JPI3DEngrosamientoPDLayout.createSequentialGroup().addComponent(this.JCH3D_V_a).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCH3D_V_b).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCH3D_V_c))).addGap(44, 44, 44).addGroup(JPI3DEngrosamientoPDLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI3DEngrosamientoPDLayout.createSequentialGroup().addComponent(this.JCH3D_Ancho_O1).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCH3D_Ancho_L)).addGroup(JPI3DEngrosamientoPDLayout.createSequentialGroup().addComponent(this.JCH3D_V_a1).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCH3D_V_b1).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCH3D_V_c1))))).addGap(32, 32, 32)));
        JPI3DEngrosamientoPDLayout.setVerticalGroup(JPI3DEngrosamientoPDLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jSeparator4, -2, 61, -2).addGroup(JPI3DEngrosamientoPDLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI3DEngrosamientoPDLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jSeparator6, -2, 82, -2).addGroup(GroupLayout.Alignment.LEADING, JPI3DEngrosamientoPDLayout.createSequentialGroup().addComponent(this.JLB3BExtension3, -2, -1, -2).addGap(18, 18, 18).addGroup(JPI3DEngrosamientoPDLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPI3DEngrosamientoPDLayout.createSequentialGroup().addGroup(JPI3DEngrosamientoPDLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCH3D_Ancho_O).addComponent(this.JCH3D_Ancho_R)).addGap(3, 3, 3).addGroup(JPI3DEngrosamientoPDLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCH3D_V_a).addComponent(this.JCH3D_V_b).addComponent(this.JCH3D_V_c))).addGroup(GroupLayout.Alignment.TRAILING, JPI3DEngrosamientoPDLayout.createSequentialGroup().addGroup(JPI3DEngrosamientoPDLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCH3D_Ancho_O1).addComponent(this.JCH3D_Ancho_L)).addGap(3, 3, 3).addGroup(JPI3DEngrosamientoPDLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCH3D_V_a1).addComponent(this.JCH3D_V_b1).addComponent(this.JCH3D_V_c1)))))).addGroup(JPI3DEngrosamientoPDLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(GroupLayout.Alignment.LEADING, JPI3DEngrosamientoPDLayout.createSequentialGroup().addGap(21, 21, 21).addGroup(JPI3DEngrosamientoPDLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI3DEngrosamientoPDLayout.createSequentialGroup().addComponent(this.JLB3DCalcificacion).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(JPI3DEngrosamientoPDLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(GroupLayout.Alignment.LEADING, JPI3DEngrosamientoPDLayout.createSequentialGroup().addGroup(JPI3DEngrosamientoPDLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCH3D_CP_O).addComponent(this.JCH3D_CP_R)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPI3DEngrosamientoPDLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JCH3D_CF_O).addComponent(this.JCH3D_CF_R))).addGroup(GroupLayout.Alignment.LEADING, JPI3DEngrosamientoPDLayout.createSequentialGroup().addComponent(this.JCH3D_CP_L).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCH3D_CF_L)))).addGroup(JPI3DEngrosamientoPDLayout.createSequentialGroup().addComponent(this.JLB3DParedToracica).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(JPI3DEngrosamientoPDLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI3DEngrosamientoPDLayout.createSequentialGroup().addGroup(JPI3DEngrosamientoPDLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCH3DC_SP_O).addComponent(this.JCH3DC_SP_R).addComponent(this.JLB3DPerfil)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPI3DEngrosamientoPDLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(GroupLayout.Alignment.LEADING, JPI3DEngrosamientoPDLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCH3D_SF_O).addComponent(this.JLB3DFrente)).addComponent(this.JCH3D_SF_R, GroupLayout.Alignment.LEADING))).addGroup(JPI3DEngrosamientoPDLayout.createSequentialGroup().addComponent(this.JCH3D_SP_L).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCH3D_SF_L)))))).addGroup(GroupLayout.Alignment.LEADING, JPI3DEngrosamientoPDLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.jSeparator5, GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.LEADING, JPI3DEngrosamientoPDLayout.createSequentialGroup().addComponent(this.JLB3DExtension, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPI3DEngrosamientoPDLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPI3DEngrosamientoPDLayout.createSequentialGroup().addGroup(JPI3DEngrosamientoPDLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCH3D_Extension_O).addComponent(this.JCH3D_Extension_R)).addGap(3, 3, 3).addGroup(JPI3DEngrosamientoPDLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCH3D_V_E1).addComponent(this.JCH3D_V_E2).addComponent(this.JCH3D_V_E3))).addGroup(GroupLayout.Alignment.TRAILING, JPI3DEngrosamientoPDLayout.createSequentialGroup().addGroup(JPI3DEngrosamientoPDLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCH3D_Extension_O1).addComponent(this.JCH3D_Extension_L1)).addGap(3, 3, 3).addGroup(JPI3DEngrosamientoPDLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCH3D_V_E4).addComponent(this.JCH3D_V_E5).addComponent(this.JCH3D_V_E6)))))))));
        this.JPI4A.setBorder(BorderFactory.createTitledBorder((Border) null, "4A.", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JLB4A_Pregunta.setFont(new Font("Arial", 1, 12));
        this.JLB4A_Pregunta.setForeground(Color.red);
        this.JLB4A_Pregunta.setText("Existen otras anormalidad?");
        this.JBG4A.add(this.JCH4A_Si);
        this.JCH4A_Si.setFont(new Font("Arial", 1, 12));
        this.JCH4A_Si.setText("SI (complete secciones 4B, 4C y 4D)");
        this.JCH4A_Si.setHorizontalAlignment(0);
        this.JCH4A_Si.setHorizontalTextPosition(4);
        this.JCH4A_Si.setVerticalTextPosition(1);
        this.JCH4A_Si.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFLecturaPlacaOit.135
            public void actionPerformed(ActionEvent evt) {
                JIFLecturaPlacaOit.this.JCH4A_SiActionPerformed(evt);
            }
        });
        this.JBG4A.add(this.JCH4A_No);
        this.JCH4A_No.setFont(new Font("Arial", 1, 12));
        this.JCH4A_No.setText("NO (pase a sección 5)");
        this.JCH4A_No.setHorizontalAlignment(0);
        this.JCH4A_No.setHorizontalTextPosition(4);
        this.JCH4A_No.setVerticalTextPosition(1);
        this.JCH4A_No.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFLecturaPlacaOit.136
            public void actionPerformed(ActionEvent evt) {
                JIFLecturaPlacaOit.this.JCH4A_NoActionPerformed(evt);
            }
        });
        GroupLayout JPI4ALayout = new GroupLayout(this.JPI4A);
        this.JPI4A.setLayout(JPI4ALayout);
        JPI4ALayout.setHorizontalGroup(JPI4ALayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI4ALayout.createSequentialGroup().addContainerGap().addComponent(this.JLB4A_Pregunta, -2, 238, -2).addGap(100, 100, 100).addComponent(this.JCH4A_Si, -2, 322, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JCH4A_No).addGap(28, 28, 28)));
        JPI4ALayout.setVerticalGroup(JPI4ALayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCH4A_Si, -2, 0, 32767).addComponent(this.JLB4A_Pregunta, -1, -1, 32767).addComponent(this.JCH4A_No, GroupLayout.Alignment.TRAILING, -2, 15, -2));
        this.JSP4B.setBorder(BorderFactory.createTitledBorder((Border) null, "4B. Otros símbolos (Obligatorios)", 1, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.JT4B.setFont(new Font("Arial", 1, 12));
        this.JT4B.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JT4B.setSelectionBackground(new Color(255, 255, 255));
        this.JT4B.setSelectionForeground(new Color(255, 0, 0));
        this.JT4B.setSelectionMode(0);
        this.JSP4B.setViewportView(this.JT4B);
        this.JSP4C.setBorder(BorderFactory.createTitledBorder((Border) null, "4C. Marque todas las opciones que correspondan", 1, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.JT4C.setFont(new Font("Arial", 1, 12));
        this.JT4C.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JT4C.setSelectionBackground(new Color(255, 255, 255));
        this.JT4C.setSelectionForeground(new Color(255, 0, 0));
        this.JT4C.setSelectionMode(0);
        this.JSP4C.setViewportView(this.JT4C);
        this.JSP4D.setBorder(BorderFactory.createTitledBorder((Border) null, "4D. Otros comentarios", 1, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.JTA4D.setColumns(20);
        this.JTA4D.setFont(new Font("Arial", 1, 14));
        this.JTA4D.setLineWrap(true);
        this.JTA4D.setRows(1);
        this.JTA4D.setTabSize(1);
        this.JTA4D.setBorder((Border) null);
        this.JSP4D.setViewportView(this.JTA4D);
        this.JPI4E.setBorder(BorderFactory.createTitledBorder((Border) null, "4E.", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JLB4E_Pregunta.setFont(new Font("Arial", 1, 12));
        this.JLB4E_Pregunta.setForeground(Color.red);
        this.JLB4E_Pregunta.setText("<html><P ALIGN=center>Debería este trabajador acudir a un especialista debido a los hallazgos de la sección 4?");
        this.JBG4E.add(this.JCH4E_Si);
        this.JCH4E_Si.setFont(new Font("Arial", 1, 12));
        this.JCH4E_Si.setText("Si");
        this.JCH4E_Si.setHorizontalAlignment(0);
        this.JCH4E_Si.setHorizontalTextPosition(4);
        this.JCH4E_Si.setVerticalTextPosition(1);
        this.JCH4E_Si.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFLecturaPlacaOit.137
            public void actionPerformed(ActionEvent evt) {
                JIFLecturaPlacaOit.this.JCH4E_SiActionPerformed(evt);
            }
        });
        this.JBG4E.add(this.JCH4E_No);
        this.JCH4E_No.setFont(new Font("Arial", 1, 12));
        this.JCH4E_No.setSelected(true);
        this.JCH4E_No.setText("No");
        this.JCH4E_No.setHorizontalAlignment(0);
        this.JCH4E_No.setHorizontalTextPosition(4);
        this.JCH4E_No.setVerticalTextPosition(1);
        this.JCH4E_No.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFLecturaPlacaOit.138
            public void actionPerformed(ActionEvent evt) {
                JIFLecturaPlacaOit.this.JCH4E_NoActionPerformed(evt);
            }
        });
        GroupLayout JPI4ELayout = new GroupLayout(this.JPI4E);
        this.JPI4E.setLayout(JPI4ELayout);
        JPI4ELayout.setHorizontalGroup(JPI4ELayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI4ELayout.createSequentialGroup().addContainerGap().addComponent(this.JLB4E_Pregunta, -2, 334, -2).addGap(18, 18, 18).addComponent(this.JCH4E_Si, -2, 45, -2).addGap(18, 18, 18).addComponent(this.JCH4E_No, -2, 45, -2).addContainerGap(-1, 32767)));
        JPI4ELayout.setVerticalGroup(JPI4ELayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLB4E_Pregunta).addGroup(GroupLayout.Alignment.TRAILING, JPI4ELayout.createSequentialGroup().addContainerGap(12, 32767).addGroup(JPI4ELayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JCH4E_No).addComponent(this.JCH4E_Si)).addContainerGap()));
        GroupLayout JPISeccion2Layout = new GroupLayout(this.JPISeccion2);
        this.JPISeccion2.setLayout(JPISeccion2Layout);
        JPISeccion2Layout.setHorizontalGroup(JPISeccion2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPISeccion2Layout.createSequentialGroup().addContainerGap().addGroup(JPISeccion2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPISeccion2Layout.createSequentialGroup().addComponent(this.JPI3C, -1, -1, 32767).addGap(14, 14, 14)).addGroup(GroupLayout.Alignment.TRAILING, JPISeccion2Layout.createSequentialGroup().addGroup(JPISeccion2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JPI4A, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JPI3DEngrosamientoPD, -1, -1, 32767)).addContainerGap()).addGroup(JPISeccion2Layout.createSequentialGroup().addGroup(JPISeccion2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JSP4B, -1, 453, 32767).addComponent(this.JSP4D)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPISeccion2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSP4C).addComponent(this.JPI4E, -1, -1, 32767)).addContainerGap()))));
        JPISeccion2Layout.setVerticalGroup(JPISeccion2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPISeccion2Layout.createSequentialGroup().addContainerGap().addComponent(this.JPI3C, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JPI3DEngrosamientoPD, -2, 108, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPI4A, -2, -1, -2).addGap(18, 18, 18).addGroup(JPISeccion2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSP4B, -2, 197, -2).addComponent(this.JSP4C, -2, 197, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPISeccion2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSP4D).addComponent(this.JPI4E, -1, -1, 32767)).addContainerGap()));
        this.JTPDetalle.addTab("SECCION (3C, 3D, 4A, 4B, 4C, 4D, 4E)", this.JPISeccion2);
        GroupLayout JPILecturaLayout = new GroupLayout(this.JPILectura);
        this.JPILectura.setLayout(JPILecturaLayout);
        JPILecturaLayout.setHorizontalGroup(JPILecturaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPILecturaLayout.createSequentialGroup().addContainerGap().addComponent(this.JTPDetalle).addContainerGap()));
        JPILecturaLayout.setVerticalGroup(JPILecturaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPILecturaLayout.createSequentialGroup().addContainerGap().addComponent(this.JTPDetalle, -2, 543, -2).addContainerGap(-1, 32767)));
        this.JTPRegistro.addTab("LECTURA", this.JPILectura);
        this.JSPDHistorico.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.JTDHistorico.setFont(new Font("Arial", 1, 12));
        this.JTDHistorico.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDHistorico.setSelectionBackground(new Color(255, 255, 255));
        this.JTDHistorico.setSelectionForeground(new Color(255, 0, 0));
        this.JTDHistorico.addMouseListener(new MouseAdapter() { // from class: ImagenesDx.JIFLecturaPlacaOit.139
            public void mouseClicked(MouseEvent evt) {
                JIFLecturaPlacaOit.this.JTDHistoricoMouseClicked(evt);
            }
        });
        this.JSPDHistorico.setViewportView(this.JTDHistorico);
        GroupLayout JPIHistoricoLayout = new GroupLayout(this.JPIHistorico);
        this.JPIHistorico.setLayout(JPIHistoricoLayout);
        JPIHistoricoLayout.setHorizontalGroup(JPIHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIHistoricoLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPDHistorico, -1, 977, 32767).addContainerGap()));
        JPIHistoricoLayout.setVerticalGroup(JPIHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIHistoricoLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPDHistorico, -1, 537, 32767).addContainerGap()));
        this.JTPRegistro.addTab("HISTÓRICO", this.JPIHistorico);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPPersona, -2, 988, -2).addComponent(this.JTPRegistro, -2, -1, -2)).addContainerGap(-1, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPPersona, -2, 190, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTPRegistro, -2, 590, -2).addContainerGap(-1, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH0AActionPerformed(ActionEvent evt) {
        if (this.JCH0A.isSelected()) {
            this.xvta = 1;
        } else {
            this.xvta = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH0BActionPerformed(ActionEvent evt) {
        if (this.JCH0B.isSelected()) {
            this.xvtb = 1;
        } else {
            this.xvtb = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH0CActionPerformed(ActionEvent evt) {
        if (this.JCH0C.isSelected()) {
            this.xvtf = 1;
        } else {
            this.xvtf = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH1_1ActionPerformed(ActionEvent evt) {
        if (this.JCH1_1.isSelected()) {
            this.xvc_1 = 1;
        } else {
            this.xvc_1 = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH1_2ActionPerformed(ActionEvent evt) {
        if (this.JCH1_2.isSelected()) {
            this.xvc_2 = 1;
        } else {
            this.xvc_2 = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH1_3ActionPerformed(ActionEvent evt) {
        if (this.JCH1_3.isSelected()) {
            this.xvc_3 = 1;
        } else {
            this.xvc_3 = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH1_URActionPerformed(ActionEvent evt) {
        if (this.JCH1_UR.isSelected()) {
            this.xvc_4 = 1;
        } else {
            this.xvc_4 = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH1_4SobreExposicionActionPerformed(ActionEvent evt) {
        if (this.JCH1_4SobreExposicion.isSelected()) {
            this.xv1_4 = 1;
        } else {
            this.xv1_4 = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH1_5SubExposicionActionPerformed(ActionEvent evt) {
        if (this.JCH1_5SubExposicion.isSelected()) {
            this.xv1_5 = 1;
        } else {
            this.xv1_5 = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH1_6ArtefactosActionPerformed(ActionEvent evt) {
        if (this.JCH1_6Artefactos.isSelected()) {
            this.xv1_6 = 1;
        } else {
            this.xv1_6 = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH1_7PosicionIncorrectaActionPerformed(ActionEvent evt) {
        if (this.JCH1_7PosicionIncorrecta.isSelected()) {
            this.xv1_7 = 1;
        } else {
            this.xv1_7 = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH1_8PobreContrasteActionPerformed(ActionEvent evt) {
        if (this.JCH1_8PobreContraste.isSelected()) {
            this.xv1_8 = 1;
        } else {
            this.xv1_8 = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH1_9PobreProcesamientoActionPerformed(ActionEvent evt) {
        if (this.JCH1_9PobreProcesamiento.isSelected()) {
            this.xv1_9 = 1;
        } else {
            this.xv1_9 = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH1_10EspiradaActionPerformed(ActionEvent evt) {
        if (this.JCH1_10Espirada.isSelected()) {
            this.xv1_10 = 1;
        } else {
            this.xv1_10 = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH1_11MoteadaActionPerformed(ActionEvent evt) {
        if (this.JCH1_11Moteada.isSelected()) {
            this.xv1_11 = 1;
        } else {
            this.xv1_11 = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH1_12OtraActionPerformed(ActionEvent evt) {
        if (this.JCH1_12Otra.isSelected()) {
            this.xv1_12 = 1;
        } else {
            this.xv1_12 = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH2A_SiActionPerformed(ActionEvent evt) {
        this.xv2a = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH2A_NoActionPerformed(ActionEvent evt) {
        this.xv2a = 0;
        this.xv2b_primaria = "";
        this.xv2b_secundaria = "";
        this.xv2bprofusion = "";
        this.xv2copacidades = "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH2B_PpActionPerformed(ActionEvent evt) {
        if (this.JCH2B_Pp.isSelected()) {
            this.xv2b_pp = 1;
        } else {
            this.xv2b_pp = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH2B_PrActionPerformed(ActionEvent evt) {
        if (this.JCH2B_Pr.isSelected()) {
            this.xv2b_pr = 1;
        } else {
            this.xv2b_pr = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH2B_PqActionPerformed(ActionEvent evt) {
        if (this.JCH2B_Pq.isSelected()) {
            this.xv2b_pq = 1;
        } else {
            this.xv2b_pq = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH2B_PsActionPerformed(ActionEvent evt) {
        if (this.JCH2B_Ps.isSelected()) {
            this.xv2b_ps = 1;
        } else {
            this.xv2b_ps = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH2B_PtActionPerformed(ActionEvent evt) {
        if (this.JCH2B_Pt.isSelected()) {
            this.xv2b_pt = 1;
        } else {
            this.xv2b_pt = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH2B_PuActionPerformed(ActionEvent evt) {
        if (this.JCH2B_Pu.isSelected()) {
            this.xv2b_pu = 1;
        } else {
            this.xv2b_pu = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH2B_SpActionPerformed(ActionEvent evt) {
        if (this.JCH2B_Sp.isSelected()) {
            this.xv2b_sp = 1;
        } else {
            this.xv2b_sp = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH2B_SsActionPerformed(ActionEvent evt) {
        this.xv2b_secundaria = this.JCH2B_Ss.getText();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH2B_SqActionPerformed(ActionEvent evt) {
        if (this.JCH2B_Sq.isSelected()) {
            this.xv2b_sq = 1;
        } else {
            this.xv2b_sq = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH2B_StActionPerformed(ActionEvent evt) {
        if (this.JCH2B_St.isSelected()) {
            this.xv2b_st = 1;
        } else {
            this.xv2b_st = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH2B_SrActionPerformed(ActionEvent evt) {
        if (this.JCH2B_Sr.isSelected()) {
            this.xv2b_sr = 1;
        } else {
            this.xv2b_sr = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH2B_SuActionPerformed(ActionEvent evt) {
        if (this.JCH2B_Su.isSelected()) {
            this.xv2b_su = 1;
        } else {
            this.xv2b_su = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH2B_ZSRActionPerformed(ActionEvent evt) {
        if (this.JCH2B_ZSR.isSelected()) {
            this.xv2b_superiorR = 1;
        } else {
            this.xv2b_superiorR = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH2B_ZMRActionPerformed(ActionEvent evt) {
        if (this.JCH2B_ZMR.isSelected()) {
            this.xv2b_mediaR = 1;
        } else {
            this.xv2b_mediaR = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH2B_ZIRActionPerformed(ActionEvent evt) {
        if (this.JCH2B_ZIR.isSelected()) {
            this.xv2b_inferiorR = 1;
        } else {
            this.xv2b_inferiorR = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH2B_ZSLActionPerformed(ActionEvent evt) {
        if (this.JCH2B_ZSL.isSelected()) {
            this.xv2b_superiorL = 1;
        } else {
            this.xv2b_superiorL = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH2B_ZMLActionPerformed(ActionEvent evt) {
        if (this.JCH2B_ZML.isSelected()) {
            this.xv2b_mediaL = 1;
        } else {
            this.xv2b_mediaL = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH2B_ZILActionPerformed(ActionEvent evt) {
        if (this.JCH2B_ZIL.isSelected()) {
            this.xv2b_inferiorL = 1;
        } else {
            this.xv2b_inferiorL = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH2B_P_0ActionPerformed(ActionEvent evt) {
        if (this.JCH2B_P_0.isSelected()) {
            this.xv2b_p0 = 1;
        } else {
            this.xv2b_p0 = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH2B_P_00ActionPerformed(ActionEvent evt) {
        if (this.JCH2B_P_00.isSelected()) {
            this.xv2b_p00 = 1;
        } else {
            this.xv2b_p00 = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH2B_P_01ActionPerformed(ActionEvent evt) {
        if (this.JCH2B_P_01.isSelected()) {
            this.xv2b_p01 = 1;
        } else {
            this.xv2b_p01 = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH2B_P_10ActionPerformed(ActionEvent evt) {
        if (this.JCH2B_P_10.isSelected()) {
            this.xv2b_p10 = 1;
        } else {
            this.xv2b_p10 = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH2B_P_11ActionPerformed(ActionEvent evt) {
        if (this.JCH2B_P_11.isSelected()) {
            this.xv2b_p11 = 1;
        } else {
            this.xv2b_p11 = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH2B_P_12ActionPerformed(ActionEvent evt) {
        if (this.JCH2B_P_12.isSelected()) {
            this.xv2b_p12 = 1;
        } else {
            this.xv2b_p12 = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH2B_P_21ActionPerformed(ActionEvent evt) {
        if (this.JCH2B_P_21.isSelected()) {
            this.xv2b_p21 = 1;
        } else {
            this.xv2b_p21 = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH2B_P_22ActionPerformed(ActionEvent evt) {
        if (this.JCH2B_P_22.isSelected()) {
            this.xv2b_p22 = 1;
        } else {
            this.xv2b_p22 = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH2B_P_23ActionPerformed(ActionEvent evt) {
        if (this.JCH2B_P_23.isSelected()) {
            this.xv2b_p23 = 1;
        } else {
            this.xv2b_p23 = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH2B_P_32ActionPerformed(ActionEvent evt) {
        if (this.JCH2B_P_32.isSelected()) {
            this.xv2b_p32 = 1;
        } else {
            this.xv2b_p32 = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH2B_P_33ActionPerformed(ActionEvent evt) {
        if (this.JCH2B_P_33.isSelected()) {
            this.xv2b_p34 = 1;
        } else {
            this.xv2b_p34 = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH2B_P_34ActionPerformed(ActionEvent evt) {
        if (this.JCH2B_P_33.isSelected()) {
            this.xv2b_p33 = 1;
        } else {
            this.xv2b_p33 = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH2C_CActionPerformed(ActionEvent evt) {
        if (this.JCH2C_C.isSelected()) {
            this.xv2C_oc = 1;
        } else {
            this.xv2C_oc = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH2C_BActionPerformed(ActionEvent evt) {
        if (this.JCH2C_B.isSelected()) {
            this.xv2C_ob = 1;
        } else {
            this.xv2C_ob = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH2C_AActionPerformed(ActionEvent evt) {
        if (this.JCH2C_A.isSelected()) {
            this.xv2C_oa = 1;
        } else {
            this.xv2C_oa = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH2C_OActionPerformed(ActionEvent evt) {
        if (this.JCH2C_O.isSelected()) {
            this.xv2C_oo = 1;
        } else {
            this.xv2C_oo = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH3A_SiActionPerformed(ActionEvent evt) {
        this.xv3a_respuesta = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH3A_NoActionPerformed(ActionEvent evt) {
        this.xv3a_respuesta = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH3B_SP_OActionPerformed(ActionEvent evt) {
        if (this.JCH3B_SP_O.isSelected()) {
            this.xv3b_spo = 1;
        } else {
            this.xv3b_spo = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH3B_SP_RActionPerformed(ActionEvent evt) {
        if (this.JCH3B_SP_R.isSelected()) {
            this.xv3b_spr = 1;
        } else {
            this.xv3b_spr = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH3B_SP_LActionPerformed(ActionEvent evt) {
        if (this.JCH3B_SP_L.isSelected()) {
            this.xv3b_spl = 1;
        } else {
            this.xv3b_spl = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH3B_SF_OActionPerformed(ActionEvent evt) {
        if (this.JCH3B_SF_O.isSelected()) {
            this.xv3b_sfo = 1;
        } else {
            this.xv3b_sfo = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH3B_SF_RActionPerformed(ActionEvent evt) {
        if (this.JCH3B_SF_R.isSelected()) {
            this.xv3b_sfr = 1;
        } else {
            this.xv3b_sfr = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH3B_SF_LActionPerformed(ActionEvent evt) {
        if (this.JCH3B_SF_L.isSelected()) {
            this.xv3b_sfl = 1;
        } else {
            this.xv3b_sfl = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH3B_SD_OActionPerformed(ActionEvent evt) {
        if (this.JCH3B_SD_O.isSelected()) {
            this.xv3b_sdo = 1;
        } else {
            this.xv3b_sdo = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH3B_SD_RActionPerformed(ActionEvent evt) {
        if (this.JCH3B_SD_R.isSelected()) {
            this.xv3b_sdr = 1;
        } else {
            this.xv3b_sdr = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH3B_SD_LActionPerformed(ActionEvent evt) {
        if (this.JCH3B_SD_L.isSelected()) {
            this.xv3b_sdl = 1;
        } else {
            this.xv3b_sdl = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH3B_SO_OActionPerformed(ActionEvent evt) {
        if (this.JCH3B_SO_O.isSelected()) {
            this.xv3b_soo = 1;
        } else {
            this.xv3b_soo = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH3B_SO_LActionPerformed(ActionEvent evt) {
        if (this.JCH3B_SO_L.isSelected()) {
            this.xv3b_sol = 1;
        } else {
            this.xv3b_sol = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH3B_SO_RActionPerformed(ActionEvent evt) {
        if (this.JCH3B_SO_R.isSelected()) {
            this.xv3b_sor = 1;
        } else {
            this.xv3b_sor = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH3B_CP_OActionPerformed(ActionEvent evt) {
        if (this.JCH3B_CP_O.isSelected()) {
            this.xv3b_cpo = 1;
        } else {
            this.xv3b_cpo = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH3B_CF_OActionPerformed(ActionEvent evt) {
        if (this.JCH3B_CF_O.isSelected()) {
            this.xv3b_cfo = 1;
        } else {
            this.xv3b_cfo = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH3B_CD_OActionPerformed(ActionEvent evt) {
        if (this.JCH3B_CD_O.isSelected()) {
            this.xv3b_cdo = 1;
        } else {
            this.xv3b_cdo = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH3B_CO_OActionPerformed(ActionEvent evt) {
        if (this.JCH3B_CO_O.isSelected()) {
            this.xv3b_coo = 1;
        } else {
            this.xv3b_coo = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH3B_CP_RActionPerformed(ActionEvent evt) {
        if (this.JCH3B_CP_R.isSelected()) {
            this.xv3b_cpr = 1;
        } else {
            this.xv3b_cpr = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH3B_CF_RActionPerformed(ActionEvent evt) {
        if (this.JCH3B_CF_R.isSelected()) {
            this.xv3b_cfr = 1;
        } else {
            this.xv3b_cfr = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH3B_CD_RActionPerformed(ActionEvent evt) {
        if (this.JCH3B_CD_R.isSelected()) {
            this.xv3b_cdr = 1;
        } else {
            this.xv3b_cdr = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH3B_CO_RActionPerformed(ActionEvent evt) {
        if (this.JCH3B_CO_R.isSelected()) {
            this.xv3b_cor = 1;
        } else {
            this.xv3b_cor = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH3B_CP_LActionPerformed(ActionEvent evt) {
        if (this.JCH3B_CP_L.isSelected()) {
            this.xv3b_cpl = 1;
        } else {
            this.xv3b_cpl = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH3B_CF_LActionPerformed(ActionEvent evt) {
        if (this.JCH3B_CF_L.isSelected()) {
            this.xv3b_cfl = 1;
        } else {
            this.xv3b_cfl = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH3B_CD_LActionPerformed(ActionEvent evt) {
        if (this.JCH3B_CD_L.isSelected()) {
            this.xv3b_cdl = 1;
        } else {
            this.xv3b_cdl = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH3B_CO_LActionPerformed(ActionEvent evt) {
        if (this.JCH3B_CO_L.isSelected()) {
            this.xv3b_col = 1;
        } else {
            this.xv3b_col = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH3B_Extension_OActionPerformed(ActionEvent evt) {
        if (this.JCH3B_Extension_O.isSelected()) {
            this.xv3be_o = 1;
        } else {
            this.xv3be_o = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH3B_Extension_RActionPerformed(ActionEvent evt) {
        if (this.JCH3B_Extension_R.isSelected()) {
            this.xv3be_r = 1;
        } else {
            this.xv3be_r = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH3B_V_E1ActionPerformed(ActionEvent evt) {
        if (this.JCH3B_V_E1.isSelected()) {
            this.xv3be_v1 = 1;
        } else {
            this.xv3be_v1 = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH3B_V_E2ActionPerformed(ActionEvent evt) {
        if (this.JCH3B_V_E2.isSelected()) {
            this.xv3be_v2 = 1;
        } else {
            this.xv3be_v2 = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH3B_V_E3ActionPerformed(ActionEvent evt) {
        if (this.JCH3B_V_E3.isSelected()) {
            this.xv3be_v3 = 1;
        } else {
            this.xv3be_v3 = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH3B_Extension_O1ActionPerformed(ActionEvent evt) {
        if (this.JCH3B_Extension_O1.isSelected()) {
            this.xv3be_o_1 = 1;
        } else {
            this.xv3be_o_1 = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH3B_Extension_L1ActionPerformed(ActionEvent evt) {
        if (this.JCH3B_Extension_L1.isSelected()) {
            this.xv3be_l = 1;
        } else {
            this.xv3be_l = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH3B_V_E4ActionPerformed(ActionEvent evt) {
        if (this.JCH3B_V_E4.isSelected()) {
            this.xv3be_v1_1 = 1;
        } else {
            this.xv3be_v1_1 = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH3B_V_E5ActionPerformed(ActionEvent evt) {
        if (this.JCH3B_V_E4.isSelected()) {
            this.xv3be_v2_2 = 1;
        } else {
            this.xv3be_v2_2 = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH3B_V_E6ActionPerformed(ActionEvent evt) {
        if (this.JCH3B_V_E6.isSelected()) {
            this.xv3be_v3_3 = 1;
        } else {
            this.xv3be_v3_3 = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH3B_Ancho_O1ActionPerformed(ActionEvent evt) {
        if (this.JCH3B_Ancho_O1.isSelected()) {
            this.xv3ba_o = 1;
        } else {
            this.xv3ba_o = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH3B_Ancho_R1ActionPerformed(ActionEvent evt) {
        if (this.JCH3B_Ancho_R1.isSelected()) {
            this.xv3ba_r = 1;
        } else {
            this.xv3ba_r = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH3B_V_A1ActionPerformed(ActionEvent evt) {
        if (this.JCH3B_V_A1.isSelected()) {
            this.xv3ba_va = 1;
        } else {
            this.xv3ba_va = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH3B_V_A2ActionPerformed(ActionEvent evt) {
        if (this.JCH3B_V_A2.isSelected()) {
            this.xv3ba_vb = 1;
        } else {
            this.xv3ba_vb = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH3B_V_A3ActionPerformed(ActionEvent evt) {
        if (this.JCH3B_V_A3.isSelected()) {
            this.xv3ba_vc = 1;
        } else {
            this.xv3ba_vc = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH3B_Ancho_O2ActionPerformed(ActionEvent evt) {
        if (this.JCH3B_Ancho_O2.isSelected()) {
            this.xv3ba_o_1 = 1;
        } else {
            this.xv3ba_o_1 = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH3B_Ancho_L2ActionPerformed(ActionEvent evt) {
        if (this.JCH3B_Ancho_L2.isSelected()) {
            this.xv3ba_l = 1;
        } else {
            this.xv3ba_l = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH3B_V_A4ActionPerformed(ActionEvent evt) {
        if (this.JCH3B_V_A4.isSelected()) {
            this.xv3ba_va_1 = 1;
        } else {
            this.xv3ba_va_1 = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH3B_V_A5ActionPerformed(ActionEvent evt) {
        if (this.JCH3B_V_A5.isSelected()) {
            this.xv3de_vb_2 = 1;
        } else {
            this.xv3de_vb_2 = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH3B_V_A6ActionPerformed(ActionEvent evt) {
        if (this.JCH3B_V_A6.isSelected()) {
            this.xv3de_vc_3 = 1;
        } else {
            this.xv3de_vc_3 = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH3C_LActionPerformed(ActionEvent evt) {
        if (this.JCH3C_R.isSelected() && this.JCH3C_L.isSelected()) {
            this.xv3c_valor = 3;
            return;
        }
        if (this.JCH3C_R.isSelected() && !this.JCH3C_L.isSelected()) {
            this.xv3c_valor = 1;
        } else if (!this.JCH3C_R.isSelected() && this.JCH3C_L.isSelected()) {
            this.xv3c_valor = 2;
        } else {
            this.xv3c_valor = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH3C_NoActionPerformed(ActionEvent evt) {
        if (this.JCH3C_No.isSelected()) {
            this.xv3c_valor = 0;
            this.JCH3C_L.setSelected(false);
            this.JCH3C_R.setSelected(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH3C_RActionPerformed(ActionEvent evt) {
        if (this.JCH3C_R.isSelected() && this.JCH3C_L.isSelected()) {
            this.xv3c_valor = 3;
            return;
        }
        if (this.JCH3C_R.isSelected() && !this.JCH3C_L.isSelected()) {
            this.xv3c_valor = 1;
        } else if (!this.JCH3C_R.isSelected() && this.JCH3C_L.isSelected()) {
            this.xv3c_valor = 2;
        } else {
            this.xv3c_valor = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH3DC_SP_OActionPerformed(ActionEvent evt) {
        if (this.JCH3DC_SP_O.isSelected()) {
            this.xv3d_spo = 1;
        } else {
            this.xv3b_spo = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH3DC_SP_RActionPerformed(ActionEvent evt) {
        if (this.JCH3DC_SP_R.isSelected()) {
            this.xv3d_spr = 1;
        } else {
            this.xv3b_spr = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH3D_SP_LActionPerformed(ActionEvent evt) {
        if (this.JCH3D_SP_L.isSelected()) {
            this.xv3d_spl = 1;
        } else {
            this.xv3b_spl = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH3D_SF_OActionPerformed(ActionEvent evt) {
        if (this.JCH3D_SF_O.isSelected()) {
            this.xv3d_sfo = 1;
        } else {
            this.xv3d_sfo = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH3D_SF_RActionPerformed(ActionEvent evt) {
        if (this.JCH3D_SF_R.isSelected()) {
            this.xv3d_sfr = 1;
        } else {
            this.xv3d_sfr = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH3D_SF_LActionPerformed(ActionEvent evt) {
        if (this.JCH3D_SF_L.isSelected()) {
            this.xv3d_sfl = 1;
        } else {
            this.xv3d_sfl = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH3D_CP_OActionPerformed(ActionEvent evt) {
        if (this.JCH3D_CP_O.isSelected()) {
            this.xv3d_cpo = 1;
        } else {
            this.xv3d_cpo = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH3D_CF_OActionPerformed(ActionEvent evt) {
        if (this.JCH3D_CF_O.isSelected()) {
            this.xv3d_cfo = 1;
        } else {
            this.xv3d_cfo = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH3D_CP_RActionPerformed(ActionEvent evt) {
        if (this.JCH3D_CP_R.isSelected()) {
            this.xv3d_cpr = 1;
        } else {
            this.xv3d_cpr = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH3D_CF_RActionPerformed(ActionEvent evt) {
        if (this.JCH3D_CF_R.isSelected()) {
            this.xv3d_cfr = 1;
        } else {
            this.xv3d_cfr = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH3D_CP_LActionPerformed(ActionEvent evt) {
        if (this.JCH3D_CP_L.isSelected()) {
            this.xv3d_cpl = 1;
        } else {
            this.xv3d_cpl = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH3D_CF_LActionPerformed(ActionEvent evt) {
        if (this.JCH3D_CF_L.isSelected()) {
            this.xv3d_cfl = 1;
        } else {
            this.xv3d_cfl = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH3D_Extension_OActionPerformed(ActionEvent evt) {
        if (this.JCH3D_Extension_O.isSelected()) {
            this.xv3de_o = 1;
        } else {
            this.xv3de_o = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH3D_Extension_RActionPerformed(ActionEvent evt) {
        if (this.JCH3D_Extension_R.isSelected()) {
            this.xv3de_r = 1;
        } else {
            this.xv3de_r = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH3D_V_E1ActionPerformed(ActionEvent evt) {
        if (this.JCH3D_V_E1.isSelected()) {
            this.xv3de_v1 = 1;
        } else {
            this.xv3de_v1 = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH3D_V_E2ActionPerformed(ActionEvent evt) {
        if (this.JCH3D_V_E2.isSelected()) {
            this.xv3de_v2 = 1;
        } else {
            this.xv3de_v2 = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH3D_V_E3ActionPerformed(ActionEvent evt) {
        if (this.JCH3D_V_E3.isSelected()) {
            this.xv3de_v3 = 1;
        } else {
            this.xv3de_v3 = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH3D_Extension_O1ActionPerformed(ActionEvent evt) {
        if (this.JCH3D_Extension_O1.isSelected()) {
            this.xv3de_o_1 = 1;
        } else {
            this.xv3be_o_1 = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH3D_Extension_L1ActionPerformed(ActionEvent evt) {
        if (this.JCH3D_Extension_L1.isSelected()) {
            this.xv3de_l = 1;
        } else {
            this.xv3de_l = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH3D_V_E4ActionPerformed(ActionEvent evt) {
        if (this.JCH3D_V_E4.isSelected()) {
            this.xv3de_v1_1 = 1;
        } else {
            this.xv3de_v1_1 = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH3D_V_E5ActionPerformed(ActionEvent evt) {
        if (this.JCH3D_V_E5.isSelected()) {
            this.xv3de_v2_2 = 1;
        } else {
            this.xv3de_v2_2 = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH3D_V_E6ActionPerformed(ActionEvent evt) {
        if (this.JCH3D_V_E6.isSelected()) {
            this.xv3de_v3_3 = 1;
        } else {
            this.xv3de_v3_3 = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH3D_Ancho_OActionPerformed(ActionEvent evt) {
        if (this.JCH3D_Ancho_O.isSelected()) {
            this.xv3da_o = 1;
        } else {
            this.xv3da_o = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH3D_Ancho_RActionPerformed(ActionEvent evt) {
        if (this.JCH3D_Ancho_R.isSelected()) {
            this.xv3da_r = 1;
        } else {
            this.xv3da_r = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH3D_V_aActionPerformed(ActionEvent evt) {
        if (this.JCH3D_V_a.isSelected()) {
            this.xv3da_va = 1;
        } else {
            this.xv3da_va = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH3D_V_bActionPerformed(ActionEvent evt) {
        if (this.JCH3D_V_b.isSelected()) {
            this.xv3da_vb = 1;
        } else {
            this.xv3da_vb = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH3D_V_cActionPerformed(ActionEvent evt) {
        if (this.JCH3D_V_c.isSelected()) {
            this.xv3da_vc = 1;
        } else {
            this.xv3da_vc = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH3D_Ancho_O1ActionPerformed(ActionEvent evt) {
        if (this.JCH3D_Ancho_O1.isSelected()) {
            this.xv3da_o_1 = 1;
        } else {
            this.xv3da_o_1 = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH3D_Ancho_LActionPerformed(ActionEvent evt) {
        if (this.JCH3D_Ancho_L.isSelected()) {
            this.xv3da_l = 1;
        } else {
            this.xv3da_l = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH3D_V_a1ActionPerformed(ActionEvent evt) {
        if (this.JCH3D_V_a1.isSelected()) {
            this.xv3da_va_1 = 1;
        } else {
            this.xv3da_va_1 = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH3D_V_b1ActionPerformed(ActionEvent evt) {
        if (this.JCH3D_V_b1.isSelected()) {
            this.xv3de_vb_2 = 1;
        } else {
            this.xv3de_vb_2 = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH3D_V_c1ActionPerformed(ActionEvent evt) {
        if (this.JCH3D_V_c1.isSelected()) {
            this.xv3de_vc_3 = 1;
        } else {
            this.xv3de_vc_3 = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH4A_SiActionPerformed(ActionEvent evt) {
        this.xv4a_valor = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH4A_NoActionPerformed(ActionEvent evt) {
        this.xv4a_valor = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH4E_SiActionPerformed(ActionEvent evt) {
        this.xv4e_valor = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH4E_NoActionPerformed(ActionEvent evt) {
        this.xv4e_valor = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDHistoricoMouseClicked(MouseEvent evt) {
        if (this.JTDHistorico.getSelectedRow() != -1) {
            mImprimirH(this.xmodeloH.getValueAt(this.JTDHistorico.getSelectedRow(), 0).toString());
        }
    }

    public void mNuevo() {
        Principal.mLimpiarDatosP();
        this.JDCFecha.setDate(this.xmt.getFechaActual());
        this.xvtipol = "";
        this.JTA1_13_Cual.setText("");
        this.xvcalidad = "";
        this.xv1_4 = 0;
        this.xv1_5 = 0;
        this.xv1_6 = 0;
        this.xv1_7 = 0;
        this.xv1_8 = 0;
        this.xv1_9 = 0;
        this.xv1_10 = 0;
        this.xv1_11 = 0;
        this.xv1_12 = 0;
        this.xv1_13 = 0;
        this.xv2b_superiorR = 0;
        this.xv2b_superiorL = 0;
        this.xv2b_mediaR = 0;
        this.xv2b_mediaL = 0;
        this.xv2b_inferiorR = 0;
        this.xv2b_inferiorL = 0;
        this.xv2b_primaria = "";
        this.xv2b_secundaria = "";
        this.xv2copacidades = "";
        mCargarDatosTabla4B();
        mCargarDatosTabla4C();
    }

    private void mCargarPanelPersonas() {
        this.xjppersona = new Persona(this);
        this.xjppersona.setVisible(false);
        this.JPPersona.setVisible(false);
        this.xjppersona.setBounds(10, 17, 967, 160);
        this.JPPersona.add(this.xjppersona);
        this.JPPersona.setVisible(true);
        this.xjppersona.setVisible(true);
    }

    public void mGrabar() {
        int y = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (y == 0) {
            this.xsql = "insert into `h_radiologia_lectura_encabezado`(`Id_Radiologia`, `FechaL`, `Id_Profesional`, `Id_Especialidad`, `TA`, `TB`, `TF`, `UsuarioS`) values ('" + this.xidestudio + "','" + this.xmt.formatoAMD.format(this.JDCFecha.getDate()) + "','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "','" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "','" + this.xvta + "','" + this.xvtb + "','" + this.xvtf + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
            Principal.txtNo.setText(this.xct.ejecutarSQLId(this.xsql));
            this.xct.cerrarConexionBd();
            this.xsql = "insert into `h_radiologia_lectura_detalle_oit`(`Id_RLectura` , `C1`, `C2`, `C3`, `CUR` , `1_SOscura` , `1_SClara` , `1_Artefactos` , `1_PIncorrecta` , `1_PContraste`, `1_PProcesamiento`, `1_Espirada`, `1_Moteada`, `1_Otra`, `1_Especifique`,  `2A_Respuesta`, `2B_Pp`, `2B_Pq`, `2B_Pr`, `2B_Ps`, `2B_Pt`, `2B_Pu`, `2B_Sp`, `2B_Sq`, `2B_Sr`, `2B_Ss`, `2B_St`, `2B_Su`, `2B_Superior_R`, `2B_Superior_L`, `2B_Media_R` , `2B_Media_L`, `2B_Inferior_R`, `2B_Inferior_L`, `2B_P_0`, `2B_P_00`, `2B_P_01`, `2B_P_10`, `2B_P_11`, `2B_P_12`, `2B_P_21`, `2B_P_22`, `2B_P_23`, `2B_P_32`, `2B_P_33`, `2B_P_34`     , `2C_O`, `2C_A`, `2C_B`, `2C_C` , `3A_Respuesta`, `3B_SP_O`, `3B_SP_R`, `3B_SP_L`, `3B_SF_O`, `3B_SF_R`, `3B_SF_L`, `3B_SD_O`, `3B_SD_R`, `3B_SD_L`,  `3B_SO_O`, `3B_SO_R`, `3B_SO_L`, `3B_CP_O`, `3B_CP_R`, `3B_CP_L`, `3B_CF_O`, `3B_CF_R` , `3B_CF_L`,  `3B_CD_O`, `3B_CD_R`, `3B_CD_L`, `3B_CO_O`, `3B_CO_R`, `3B_CO_L`,  `3B_EO`, `3B_ER`, `3B_EV1`, `3B_EV2`, `3B_EV3`, `3B_EO1`, `3B_EL`, `3B_EV1_1`, `3B_EV1_2`, `3B_EV1_3`, `3B_AO`, `3B_AR`, `3B_AVa`, `3B_AVb`, `3B_AVc`, `3B_AO1`, `3B_AL`, `3B_AVa_1`, `3B_AVb_1`, `3B_AVc_1`, `3C_Respuesta`, `3D_SP_O`, `3D_SP_R`, `3D_SP_L`, `3D_SF_O`, `3D_SF_R`, `3D_SF_L`, `3D_CP_O`, `3D_CP_R`, `3D_CP_L`, `3D_CF_O`, `3D_CF_R`, `3D_CF_L`, `3D_EO`, `3D_ER`, `3D_EV1`, `3D_EV2`, `3D_EV3`, `3D_EO_1`, `3D_EL`, `3D_EV1_1`, `3D_EV2_2`, `3D_EV3_3`, `3D_AO`, `3D_AR` , `3D_AV_a`, `3D_AV_b`, `3D_AV_c`, `3D_AO_1`, `3D_AL`, `3D_AV_a1`, `3D_AV_b1`, `3D_AV_c1`, `4A_Respuesta`, `4D_Respuesta`, `4E_Respuesta`) values ('" + Principal.txtNo.getText() + "','" + this.xvc_1 + "','" + this.xvc_2 + "','" + this.xvc_3 + "','" + this.xvc_4 + "','" + this.xv1_4 + "','" + this.xv1_5 + "','" + this.xv1_6 + "','" + this.xv1_7 + "','" + this.xv1_8 + "','" + this.xv1_9 + "','" + this.xv1_10 + "','" + this.xv1_11 + "','" + this.xv1_12 + "','" + this.JTA1_13_Cual.getText() + "','" + this.xv2a + "','" + this.xv2b_pp + "','" + this.xv2b_pq + "','" + this.xv2b_pr + "','" + this.xv2b_ps + "','" + this.xv2b_pt + "','" + this.xv2b_pu + "','" + this.xv2b_sp + "','" + this.xv2b_sq + "','" + this.xv2b_sr + "','" + this.xv2b_ss + "','" + this.xv2b_st + "','" + this.xv2b_su + "','" + this.xv2b_superiorR + "','" + this.xv2b_superiorL + "','" + this.xv2b_mediaR + "','" + this.xv2b_mediaL + "','" + this.xv2b_inferiorR + "','" + this.xv2b_inferiorL + "','" + this.xv2b_p0 + "','" + this.xv2b_p00 + "','" + this.xv2b_p01 + "','" + this.xv2b_p10 + "','" + this.xv2b_p11 + "','" + this.xv2b_p12 + "','" + this.xv2b_p21 + "','" + this.xv2b_p22 + "','" + this.xv2b_p23 + "','" + this.xv2b_p32 + "','" + this.xv2b_p33 + "','" + this.xv2b_p34 + "','" + this.xv2C_oo + "','" + this.xv2C_oa + "','" + this.xv2C_ob + "','" + this.xv2C_oc + "','" + this.xv3a_respuesta + "','" + this.xv3b_spo + "','" + this.xv3b_spr + "','" + this.xv3b_spl + "','" + this.xv3b_sfo + "','" + this.xv3b_sfr + "','" + this.xv3b_sfl + "','" + this.xv3b_sdo + "','" + this.xv3b_sdr + "','" + this.xv3b_sdl + "','" + this.xv3b_soo + "','" + this.xv3b_sor + "','" + this.xv3b_sol + "','" + this.xv3b_cpo + "','" + this.xv3b_cpr + "','" + this.xv3b_cpl + "','" + this.xv3b_cfo + "','" + this.xv3b_cfr + "','" + this.xv3b_cfl + "','" + this.xv3b_cdo + "','" + this.xv3b_cdr + "','" + this.xv3b_cdl + "','" + this.xv3b_coo + "','" + this.xv3b_cor + "','" + this.xv3b_col + "','" + this.xv3be_o + "','" + this.xv3be_r + "','" + this.xv3be_v1 + "','" + this.xv3be_v2 + "','" + this.xv3be_v3 + "','" + this.xv3be_o_1 + "','" + this.xv3be_l + "','" + this.xv3be_v1_1 + "','" + this.xv3be_v2_2 + "','" + this.xv3be_v3_3 + "','" + this.xv3ba_o + "','" + this.xv3ba_r + "','" + this.xv3ba_va + "','" + this.xv3ba_vb + "','" + this.xv3ba_vc + "','" + this.xv3ba_o_1 + "','" + this.xv3ba_l + "','" + this.xv3ba_va_1 + "','" + this.xv3be_vb_2 + "','" + this.xv3be_vc_3 + "','" + this.xv3c_valor + "','" + this.xv3d_spo + "','" + this.xv3d_spr + "','" + this.xv3d_spl + "','" + this.xv3d_sfo + "','" + this.xv3d_sfr + "','" + this.xv3d_sfl + "','" + this.xv3d_cpo + "','" + this.xv3d_cpr + "','" + this.xv3d_cpl + "','" + this.xv3d_cfo + "','" + this.xv3d_cfr + "','" + this.xv3d_cfl + "','" + this.xv3de_o + "','" + this.xv3de_r + "','" + this.xv3de_v1 + "','" + this.xv3de_v2 + "','" + this.xv3de_v3 + "','" + this.xv3de_o_1 + "','" + this.xv3de_l + "','" + this.xv3de_v1_1 + "','" + this.xv3de_v2_2 + "','" + this.xv3de_v3_3 + "','" + this.xv3da_o + "','" + this.xv3da_r + "','" + this.xv3da_va + "','" + this.xv3da_vb + "','" + this.xv3da_vc + "','" + this.xv3da_o_1 + "','" + this.xv3da_l + "','" + this.xv3da_va_1 + "','" + this.xv3de_vb_2 + "','" + this.xv3de_vc_3 + "','" + this.xv4a_valor + "','" + this.JTA4D.getText() + "','" + this.xv4e_valor + "')";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            if (this.xmt.mVerificarDatosTablaTrue(this.JT4B, 3)) {
                for (int x = 0; x < this.JT4B.getRowCount(); x++) {
                    if (Boolean.valueOf(this.xmodelo4B.getValueAt(x, 3).toString()).booleanValue()) {
                        this.xsql = "insert into h_radiologia_lectura_detalle_patologia (`Id_RLectura`  , `Id_SoPatologia`) values ('" + Principal.txtNo.getText() + "','" + this.xmodelo4B.getValueAt(x, 0) + "')";
                        this.xct.ejecutarSQL(this.xsql);
                        this.xct.cerrarConexionBd();
                    }
                }
            }
            if (this.xmt.mVerificarDatosTablaTrue(this.JT4C, 3)) {
                for (int x2 = 0; x2 < this.JT4C.getRowCount(); x2++) {
                    if (Boolean.valueOf(this.xmodelo4C.getValueAt(x2, 3).toString()).booleanValue()) {
                        this.xsql = "insert into h_radiologia_lectura_detalle_patologia (`Id_RLectura`  , `Id_SoPatologia`) values ('" + Principal.txtNo.getText() + "','" + this.xmodelo4C.getValueAt(x2, 0) + "')";
                        this.xct.ejecutarSQL(this.xsql);
                        this.xct.cerrarConexionBd();
                    }
                }
            }
            mActualizarDatosEstudio();
            mImprimir();
        }
    }

    public void mImprimir() {
        if (!Principal.txtNo.getText().isEmpty()) {
            String[][] mparametros = new String[3][2];
            mparametros[0][0] = "Id";
            mparametros[0][1] = Principal.txtNo.getText();
            mparametros[1][0] = "SUBREPORT_DIR";
            mparametros[1][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
            mparametros[2][0] = "SUBREPORTFIRMA_DIR";
            mparametros[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "H_So_Lectura_Radiologia_OIT", mparametros);
        }
    }

    public void mImprimirH(String xid) {
        String[][] mparametros = new String[3][2];
        mparametros[0][0] = "Id";
        mparametros[0][1] = xid;
        mparametros[1][0] = "SUBREPORT_DIR";
        mparametros[1][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
        mparametros[2][0] = "SUBREPORTFIRMA_DIR";
        mparametros[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
        this.xmt.GenerarPDF(this.xmt.getRutaRep() + "H_So_Lectura_Radiologia_OIT", mparametros);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModelo4B() {
        this.xmodelo4B = new DefaultTableModel(new Object[0], new String[]{"Id", "C", "Nombre", "Aplica"}) { // from class: ImagenesDx.JIFLecturaPlacaOit.140
            Class[] types = {Long.class, String.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JT4B.setModel(this.xmodelo4B);
        this.JT4B.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JT4B.getColumnModel().getColumn(0).setMinWidth(0);
        this.JT4B.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JT4B.getColumnModel().getColumn(1).setPreferredWidth(5);
        this.JT4B.getColumnModel().getColumn(2).setPreferredWidth(250);
        this.JT4B.getColumnModel().getColumn(3).setPreferredWidth(10);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloH() {
        this.xmodeloH = new DefaultTableModel(new Object[0], new String[]{"Id", "Fecha", "Especialidad", "Profesional"}) { // from class: ImagenesDx.JIFLecturaPlacaOit.141
            Class[] types = {Long.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDHistorico.setModel(this.xmodeloH);
        this.JTDHistorico.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTDHistorico.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTDHistorico.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTDHistorico.getColumnModel().getColumn(1).setPreferredWidth(10);
        this.JTDHistorico.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDHistorico.getColumnModel().getColumn(3).setPreferredWidth(150);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModelo4C() {
        this.xmodelo4C = new DefaultTableModel(new Object[0], new String[]{"Id", "Encabezado", "Nombre", "Aplica"}) { // from class: ImagenesDx.JIFLecturaPlacaOit.142
            Class[] types = {Long.class, String.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JT4C.setModel(this.xmodelo4C);
        this.JT4C.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JT4C.getColumnModel().getColumn(0).setMinWidth(0);
        this.JT4C.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JT4C.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JT4C.getColumnModel().getColumn(2).setPreferredWidth(150);
        this.JT4C.getColumnModel().getColumn(3).setPreferredWidth(10);
    }

    public void mCargarDatosTabla4B() {
        try {
            mCrearModelo4B();
            this.xsql = "SELECT `Id`, `CV`, `Nbre` FROM `so_patologias_oit` WHERE (`Estado` =1 AND `NPregunta` =0)";
            ResultSet xrs = this.xct.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.first();
                this.xmt.mEstablecerTextEditor(this.JT4B, 2);
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo4B.addRow(this.xdatos);
                    this.xmodelo4B.setValueAt(Long.valueOf(xrs.getLong(1)), n, 0);
                    this.xmodelo4B.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo4B.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelo4B.setValueAt(false, n, 3);
                    n++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFLecturaPlacaOit.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mCargarDatosTablaH(String xidusaurio) {
        try {
            mCrearModeloH();
            this.xsql = "SELECT `h_radiologia_lectura_encabezado`.`Id`, date_format(`h_radiologia_lectura_encabezado`.`FechaL`,'%d-%m-%Y') as Fecha, `profesional1`.`Especialidad`, `profesional1`.`NProfesional` FROM `h_radiologia_lectura_encabezado` INNER JOIN `h_radiologia_detalle`  ON (`h_radiologia_lectura_encabezado`.`Id_Radiologia` = `h_radiologia_detalle`.`Id`) INNER JOIN `h_radiologia`  ON (`h_radiologia_detalle`.`Id_radiologia` = `h_radiologia`.`Id`) INNER JOIN `f_ordenes`  ON (`h_radiologia`.`Id_OrdenFac` = `f_ordenes`.`Id`) INNER JOIN `ingreso`  ON (`f_ordenes`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN `profesional1`  ON (`profesional1`.`IdEspecialidad` = `h_radiologia_lectura_encabezado`.`Id_Especialidad`) AND (`profesional1`.`Id_Persona` = `h_radiologia_lectura_encabezado`.`Id_Profesional`) INNER JOIN `h_radiologia_lectura_detalle_oit`  ON (`h_radiologia_lectura_detalle_oit`.`Id_RLectura` = `h_radiologia_lectura_encabezado`.`Id`) WHERE (`ingreso`.`Id_Usuario` ='" + xidusaurio + "' AND `h_radiologia_lectura_encabezado`.`Estado` =1) GROUP BY `h_radiologia_lectura_encabezado`.`Id` ORDER BY `h_radiologia_lectura_encabezado`.`FechaL` DESC ";
            ResultSet xrs = this.xct.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodeloH.addRow(this.xdatos);
                    this.xmodeloH.setValueAt(Long.valueOf(xrs.getLong(1)), n, 0);
                    this.xmodeloH.setValueAt(xrs.getString(2), n, 1);
                    this.xmodeloH.setValueAt(xrs.getString(3), n, 2);
                    this.xmodeloH.setValueAt(xrs.getString(4), n, 3);
                    n++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFLecturaPlacaOit.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mCargarDatosTabla4C() {
        try {
            mCrearModelo4C();
            this.xsql = "SELECT`Id`, `Categoria`, `Nbre` FROM `so_patologias_oit` WHERE (`Estado` =1 AND `NPregunta` =1)";
            ResultSet xrs = this.xct.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.first();
                this.xmt.mEstablecerTextEditor(this.JT4C, 1);
                this.xmt.mEstablecerTextEditor(this.JT4C, 2);
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo4C.addRow(this.xdatos);
                    this.xmodelo4C.setValueAt(Long.valueOf(xrs.getLong(1)), n, 0);
                    this.xmodelo4C.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo4C.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelo4C.setValueAt(false, n, 3);
                    n++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFLecturaPlacaOit.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mActualizarDatosEstudio() {
        try {
            this.xsql = "update h_radiologia_detalle set Id_RLectura='" + Principal.txtNo.getText() + "' where Id='" + Principal.claseimagendx.xjifagendal.xmodelo1.getValueAt(Principal.claseimagendx.xjifagendal.JTDEstudios.getSelectedRow(), 0) + "'";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            this.xsql = "SELECT`h_radiologia_detalle`.`Id` FROM  `h_radiologia_detalle` INNER JOIN `g_procedimiento`  ON (`h_radiologia_detalle`.`Id_Procedimiento` = `g_procedimiento`.`Id`) WHERE (`h_radiologia_detalle`.`Id_radiologia` ='" + Principal.claseimagendx.xjifagendal.xmodelo.getValueAt(Principal.claseimagendx.xjifagendal.JTDUsuarios.getSelectedRow(), 0) + "' AND `h_radiologia_detalle`.`Id_RLectura` =0) GROUP BY `h_radiologia_detalle`.`Id_radiologia` ";
            ResultSet xrs = this.xct.traerRs(this.xsql);
            if (!xrs.next()) {
                ConsultasMySQL xct1 = new ConsultasMySQL();
                this.xsql = "update h_radiologia set CLectura=1 where Id='" + Principal.claseimagendx.xjifagendal.xmodelo.getValueAt(Principal.claseimagendx.xjifagendal.JTDUsuarios.getSelectedRow(), 0) + "'";
                xct1.ejecutarSQL(this.xsql);
                xct1.cerrarConexionBd();
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFLecturaPlacaOit.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
