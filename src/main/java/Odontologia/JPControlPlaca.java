package Odontologia;

import Acceso.Principal;
import Historia.clasesHistoriaCE;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.genoma.plus.controller.sgc.JDConsentimientoInformado;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JToggleButton;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DateFormatter;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

/* JADX INFO: loaded from: GenomaP.jar:Odontologia/JPControlPlaca.class */
public class JPControlPlaca extends JPanel {
    private Object[] xdatos;
    private Object[] xdatosproc;
    private Object[] xdatoNotas;
    public DefaultTableModel xmodelo;
    public DefaultTableModel xmodelopro;
    public DefaultTableModel xmodeloH;
    public DefaultTableModel xmodeloproH;
    public DefaultTableModel xModeloHNotas;
    private String xsql;
    private JPPaletaConvenciones xjifpaletaconv;
    private String xndiente;
    private String xncara;
    private String[][] xprocedimiento;
    public String xlabelD;
    public String xpanelD;
    private KeyEvent xtecla;
    private clasesHistoriaCE xclaseHC;
    private String[] xidtiponota;
    private JButton JBFinalizaTratramiento;
    private ButtonGroup JBGConvencion;
    private JButton JBTAdicionar;
    private JComboBox JCBProcedimiento;
    private JComboBox JCBTipoNota;
    private JDateChooser JDCFecha;
    private JLabel JL1;
    private JLabel JL10;
    private JLabel JL100;
    private JLabel JL101;
    private JLabel JL102;
    private JLabel JL103;
    private JLabel JL104;
    private JLabel JL105;
    private JLabel JL106;
    private JLabel JL107;
    private JLabel JL108;
    private JLabel JL109;
    private JLabel JL11;
    private JLabel JL110;
    private JLabel JL111;
    private JLabel JL112;
    private JLabel JL113;
    private JLabel JL114;
    private JLabel JL115;
    private JLabel JL116;
    private JLabel JL117;
    private JLabel JL118;
    private JLabel JL119;
    private JLabel JL12;
    private JLabel JL120;
    private JLabel JL121;
    private JLabel JL122;
    private JLabel JL123;
    private JLabel JL124;
    private JLabel JL125;
    private JLabel JL126;
    private JLabel JL127;
    private JLabel JL128;
    private JLabel JL129;
    private JLabel JL13;
    private JLabel JL130;
    private JLabel JL131;
    private JLabel JL132;
    private JLabel JL133;
    private JLabel JL134;
    private JLabel JL135;
    private JLabel JL136;
    private JLabel JL137;
    private JLabel JL138;
    private JLabel JL139;
    private JLabel JL14;
    private JLabel JL140;
    private JLabel JL141;
    private JLabel JL142;
    private JLabel JL143;
    private JLabel JL144;
    private JLabel JL145;
    private JLabel JL146;
    private JLabel JL147;
    private JLabel JL148;
    private JLabel JL149;
    private JLabel JL15;
    private JLabel JL150;
    private JLabel JL151;
    private JLabel JL152;
    private JLabel JL153;
    private JLabel JL154;
    private JLabel JL155;
    private JLabel JL156;
    private JLabel JL157;
    private JLabel JL158;
    private JLabel JL159;
    private JLabel JL16;
    private JLabel JL160;
    private JLabel JL161;
    private JLabel JL162;
    private JLabel JL163;
    private JLabel JL164;
    private JLabel JL165;
    private JLabel JL166;
    private JLabel JL167;
    private JLabel JL168;
    private JLabel JL169;
    private JLabel JL17;
    private JLabel JL170;
    private JLabel JL171;
    private JLabel JL172;
    private JLabel JL173;
    private JLabel JL174;
    private JLabel JL175;
    private JLabel JL176;
    private JLabel JL177;
    private JLabel JL178;
    private JLabel JL179;
    private JLabel JL18;
    private JLabel JL180;
    private JLabel JL181;
    private JLabel JL182;
    private JLabel JL183;
    private JLabel JL184;
    private JLabel JL185;
    private JLabel JL186;
    private JLabel JL187;
    private JLabel JL188;
    private JLabel JL189;
    private JLabel JL19;
    private JLabel JL190;
    private JLabel JL191;
    private JLabel JL192;
    private JLabel JL193;
    private JLabel JL194;
    private JLabel JL195;
    private JLabel JL196;
    private JLabel JL197;
    private JLabel JL198;
    private JLabel JL199;
    private JLabel JL2;
    private JLabel JL20;
    private JLabel JL200;
    private JLabel JL201;
    private JLabel JL202;
    private JLabel JL203;
    private JLabel JL204;
    private JLabel JL205;
    private JLabel JL206;
    private JLabel JL207;
    private JLabel JL208;
    private JLabel JL209;
    private JLabel JL21;
    private JLabel JL210;
    private JLabel JL211;
    private JLabel JL212;
    private JLabel JL213;
    private JLabel JL214;
    private JLabel JL215;
    private JLabel JL216;
    private JLabel JL217;
    private JLabel JL218;
    private JLabel JL219;
    private JLabel JL22;
    private JLabel JL220;
    private JLabel JL221;
    private JLabel JL222;
    private JLabel JL223;
    private JLabel JL224;
    private JLabel JL225;
    private JLabel JL226;
    private JLabel JL227;
    private JLabel JL228;
    private JLabel JL229;
    private JLabel JL23;
    private JLabel JL230;
    private JLabel JL231;
    private JLabel JL232;
    private JLabel JL233;
    private JLabel JL234;
    private JLabel JL235;
    private JLabel JL236;
    private JLabel JL237;
    private JLabel JL238;
    private JLabel JL239;
    private JLabel JL24;
    private JLabel JL240;
    private JLabel JL241;
    private JLabel JL242;
    private JLabel JL243;
    private JLabel JL244;
    private JLabel JL245;
    private JLabel JL246;
    private JLabel JL247;
    private JLabel JL248;
    private JLabel JL249;
    private JLabel JL25;
    private JLabel JL250;
    private JLabel JL251;
    private JLabel JL252;
    private JLabel JL253;
    private JLabel JL254;
    private JLabel JL255;
    private JLabel JL256;
    private JLabel JL26;
    private JLabel JL27;
    private JLabel JL28;
    private JLabel JL29;
    private JLabel JL3;
    private JLabel JL30;
    private JLabel JL31;
    private JLabel JL32;
    private JLabel JL33;
    private JLabel JL34;
    private JLabel JL35;
    private JLabel JL36;
    private JLabel JL37;
    private JLabel JL38;
    private JLabel JL39;
    private JLabel JL4;
    private JLabel JL40;
    private JLabel JL41;
    private JLabel JL42;
    private JLabel JL43;
    private JLabel JL44;
    private JLabel JL45;
    private JLabel JL46;
    private JLabel JL47;
    private JLabel JL48;
    private JLabel JL49;
    private JLabel JL5;
    private JLabel JL50;
    private JLabel JL51;
    private JLabel JL52;
    private JLabel JL53;
    private JLabel JL54;
    private JLabel JL55;
    private JLabel JL56;
    private JLabel JL57;
    private JLabel JL58;
    private JLabel JL59;
    private JLabel JL6;
    private JLabel JL60;
    private JLabel JL61;
    private JLabel JL62;
    private JLabel JL63;
    private JLabel JL64;
    private JLabel JL65;
    private JLabel JL66;
    private JLabel JL67;
    private JLabel JL68;
    private JLabel JL69;
    private JLabel JL7;
    private JLabel JL70;
    private JLabel JL71;
    private JLabel JL72;
    private JLabel JL73;
    private JLabel JL74;
    private JLabel JL75;
    private JLabel JL76;
    private JLabel JL77;
    private JLabel JL78;
    private JLabel JL79;
    private JLabel JL8;
    private JLabel JL80;
    private JLabel JL81;
    private JLabel JL82;
    private JLabel JL83;
    private JLabel JL84;
    private JLabel JL85;
    private JLabel JL86;
    private JLabel JL87;
    private JLabel JL88;
    private JLabel JL89;
    private JLabel JL9;
    private JLabel JL90;
    private JLabel JL91;
    private JLabel JL92;
    private JLabel JL93;
    private JLabel JL94;
    private JLabel JL95;
    private JLabel JL96;
    private JLabel JL97;
    private JLabel JL98;
    private JLabel JL99;
    private JLabel JLCarasMarcadas;
    private JLabel JLCarasMarcadasH;
    private JLabel JLCarasPlaca;
    private JLabel JLCarasPlacaH;
    private JLabel JLDBlanco1;
    private JLabel JLDBlanco10;
    private JLabel JLDBlanco11;
    private JLabel JLDBlanco12;
    private JLabel JLDBlanco13;
    private JLabel JLDBlanco14;
    private JLabel JLDBlanco15;
    private JLabel JLDBlanco16;
    private JLabel JLDBlanco17;
    private JLabel JLDBlanco18;
    private JLabel JLDBlanco19;
    private JLabel JLDBlanco2;
    private JLabel JLDBlanco20;
    private JLabel JLDBlanco21;
    private JLabel JLDBlanco22;
    private JLabel JLDBlanco23;
    private JLabel JLDBlanco24;
    private JLabel JLDBlanco25;
    private JLabel JLDBlanco26;
    private JLabel JLDBlanco27;
    private JLabel JLDBlanco28;
    private JLabel JLDBlanco29;
    private JLabel JLDBlanco3;
    private JLabel JLDBlanco30;
    private JLabel JLDBlanco31;
    private JLabel JLDBlanco32;
    private JLabel JLDBlanco33;
    private JLabel JLDBlanco34;
    private JLabel JLDBlanco35;
    private JLabel JLDBlanco36;
    private JLabel JLDBlanco37;
    private JLabel JLDBlanco38;
    private JLabel JLDBlanco39;
    private JLabel JLDBlanco4;
    private JLabel JLDBlanco40;
    private JLabel JLDBlanco41;
    private JLabel JLDBlanco42;
    private JLabel JLDBlanco43;
    private JLabel JLDBlanco44;
    private JLabel JLDBlanco45;
    private JLabel JLDBlanco46;
    private JLabel JLDBlanco47;
    private JLabel JLDBlanco48;
    private JLabel JLDBlanco49;
    private JLabel JLDBlanco5;
    private JLabel JLDBlanco50;
    private JLabel JLDBlanco51;
    private JLabel JLDBlanco52;
    private JLabel JLDBlanco53;
    private JLabel JLDBlanco54;
    private JLabel JLDBlanco55;
    private JLabel JLDBlanco56;
    private JLabel JLDBlanco57;
    private JLabel JLDBlanco58;
    private JLabel JLDBlanco59;
    private JLabel JLDBlanco6;
    private JLabel JLDBlanco60;
    private JLabel JLDBlanco61;
    private JLabel JLDBlanco62;
    private JLabel JLDBlanco63;
    private JLabel JLDBlanco64;
    private JLabel JLDBlanco7;
    private JLabel JLDBlanco8;
    private JLabel JLDBlanco9;
    private JLabel JLEstadoT;
    private JLabel JLIndiceOleary;
    private JLabel JLIndiceOlearyH;
    private JLabel JLPresentes;
    private JLabel JLPresentesH;
    private JLabel JLabelMargen;
    private JPanel JP1;
    private JPanel JP10;
    private JPanel JP11;
    private JPanel JP12;
    private JPanel JP13;
    private JPanel JP14;
    private JPanel JP15;
    private JPanel JP16;
    private JPanel JP17;
    private JPanel JP18;
    private JPanel JP19;
    private JPanel JP2;
    private JPanel JP20;
    private JPanel JP21;
    private JPanel JP22;
    private JPanel JP23;
    private JPanel JP24;
    private JPanel JP25;
    private JPanel JP26;
    private JPanel JP27;
    private JPanel JP28;
    private JPanel JP29;
    private JPanel JP3;
    private JPanel JP30;
    private JPanel JP31;
    private JPanel JP32;
    private JPanel JP33;
    private JPanel JP34;
    private JPanel JP35;
    private JPanel JP36;
    private JPanel JP37;
    private JPanel JP38;
    private JPanel JP39;
    private JPanel JP4;
    private JPanel JP40;
    private JPanel JP41;
    private JPanel JP42;
    private JPanel JP43;
    private JPanel JP44;
    private JPanel JP45;
    private JPanel JP46;
    private JPanel JP47;
    private JPanel JP48;
    private JPanel JP49;
    private JPanel JP5;
    private JPanel JP50;
    private JPanel JP51;
    private JPanel JP52;
    private JPanel JP53;
    private JPanel JP54;
    private JPanel JP55;
    private JPanel JP56;
    private JPanel JP57;
    private JPanel JP58;
    private JPanel JP59;
    private JPanel JP6;
    private JPanel JP60;
    private JPanel JP61;
    private JPanel JP62;
    private JPanel JP63;
    private JPanel JP64;
    private JPanel JP7;
    private JPanel JP8;
    private JPanel JP9;
    private JPanel JPHistorico;
    private JPanel JPImOdontograma;
    private JPanel JPImOdontogramaHistorico;
    private JPanel JPInformacionNotas;
    private JPanel JPNotas;
    private JPanel JPOdontogramaI;
    private JScrollPane JSPDetalleO;
    private JScrollPane JSPHistorico;
    private JScrollPane JSPHistoricoNotas;
    private JScrollPane JSPNota;
    private JPanel JSPPaleta;
    private JScrollPane JSPProcedimiento;
    private JScrollPane JSPProcedimientoH;
    private JTextArea JTANota;
    private JTextArea JTAObservacionDx;
    public JToggleButton JTBBorrador;
    private JToggleButton JTBCorona;
    private JToggleButton JTBExtraccion;
    private JToggleButton JTBPlacaB;
    private JToggleButton JTBPuente;
    private JToggleButton JTBSinErupsionar;
    public JTable JTDetalleO;
    private JFormattedTextField JTFFCantidad;
    private JFormattedTextField JTFFHora;
    private JTable JTHistorico;
    private JTable JTHistoricoNotas;
    private JTabbedPane JTPDatos;
    private JTabbedPane JTPNotas;
    private JTable JTProcedimiento;
    private JTable JTProcedimientoH;
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
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JLabel jLabel9;
    private JScrollPane jScrollPane1;
    public int xtipo = 1;
    private ConsultasMySQL xct = new ConsultasMySQL();
    private Metodos xmt = new Metodos();
    private long xladoGeneral = 0;
    public long xcontrolFiguara = 0;
    private int xdientegeneral = 0;
    private int xnfilas = 0;
    private int xfilasproc = 0;
    private String xnombreproceso = "";
    private long xCGeneral = 0;
    private int xAcum = 0;
    private int xAcum2 = 0;
    private int xsenialados = 0;
    private String xparteacum = "";

    public JPControlPlaca() {
        initComponents();
        mNuevo();
        mCrearModeloTablaDx();
        mModeloProcedimiento();
        System.out.println("Este es el tratamiento-->>> " + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTratamiento());
        System.out.println("===================== Tipo de tratamiento -->>> " + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTratamiento());
        mCargarDx_Procedimientos();
        mVerificarTratamiento();
        setBorder(BorderFactory.createTitledBorder((Border) null, "CONTROL PLACA TRATAMIENTO No. " + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTratamiento() + " (" + clasesHistoriaCE.informacionAgendaMedicaDTO.getTipoCita() + ")", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        if (clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTratamiento().longValue() == 1) {
            this.JTANota.setText("");
        }
        mBuscarHistorico();
        mCargarTablaHistoricoNotas();
    }

    private void verificarConsentimientoInformado(String idProcedimiento) {
        JOptionPane.showInternalMessageDialog(this, "<html><P ALIGN=center> <font face='Arial' color='red' size=4>  <b>Se debe realizar el consentimiento informado al procedimiento seleccionado<b></p><html>", "CONSENTIMIENTO INFORMADO", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        JDConsentimientoInformado consentimientoInformado = new JDConsentimientoInformado(null, true, clasesHistoriaCE.informacionAgendaMedicaDTO.getIdIngreso().toString(), idProcedimiento, this, Principal.informacionGeneralPrincipalDTO.getIdEspecialidad().toString(), Principal.usuarioSistemaDTO.getIdUsuarioSistema().toString());
        consentimientoInformado.setLocationRelativeTo(this);
        consentimientoInformado.setVisible(true);
    }

    /* JADX WARN: Multi-variable search skipped. Vars limit reached: 5803 (expected less than 5000) */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v871, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v932, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v942, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v961, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGConvencion = new ButtonGroup();
        this.JTPDatos = new JTabbedPane();
        this.JPOdontogramaI = new JPanel();
        this.JSPDetalleO = new JScrollPane();
        this.JTDetalleO = new JTable();
        this.JPImOdontograma = new JPanel();
        this.JP1 = new JPanel();
        this.JL4 = new JLabel();
        this.JL3 = new JLabel();
        this.JL2 = new JLabel();
        this.JL1 = new JLabel();
        this.JLDBlanco1 = new JLabel();
        this.jLabel2 = new JLabel();
        this.JP2 = new JPanel();
        this.JL5 = new JLabel();
        this.JL6 = new JLabel();
        this.JL7 = new JLabel();
        this.JL8 = new JLabel();
        this.JLDBlanco2 = new JLabel();
        this.jLabel3 = new JLabel();
        this.JP3 = new JPanel();
        this.JL9 = new JLabel();
        this.JL10 = new JLabel();
        this.JL11 = new JLabel();
        this.JL12 = new JLabel();
        this.JLDBlanco3 = new JLabel();
        this.jLabel4 = new JLabel();
        this.JP4 = new JPanel();
        this.JL13 = new JLabel();
        this.JL14 = new JLabel();
        this.JL15 = new JLabel();
        this.JL16 = new JLabel();
        this.JLDBlanco4 = new JLabel();
        this.jLabel5 = new JLabel();
        this.JP5 = new JPanel();
        this.JL17 = new JLabel();
        this.JL18 = new JLabel();
        this.JL19 = new JLabel();
        this.JL20 = new JLabel();
        this.JLDBlanco5 = new JLabel();
        this.jLabel6 = new JLabel();
        this.JP6 = new JPanel();
        this.JL21 = new JLabel();
        this.JL22 = new JLabel();
        this.JL23 = new JLabel();
        this.JL24 = new JLabel();
        this.JLDBlanco6 = new JLabel();
        this.jLabel7 = new JLabel();
        this.JP7 = new JPanel();
        this.JL25 = new JLabel();
        this.JL26 = new JLabel();
        this.JL27 = new JLabel();
        this.JL28 = new JLabel();
        this.JLDBlanco7 = new JLabel();
        this.jLabel8 = new JLabel();
        this.JP8 = new JPanel();
        this.JL29 = new JLabel();
        this.JL30 = new JLabel();
        this.JL31 = new JLabel();
        this.JL32 = new JLabel();
        this.JLDBlanco8 = new JLabel();
        this.jLabel9 = new JLabel();
        this.JP9 = new JPanel();
        this.JL33 = new JLabel();
        this.JL34 = new JLabel();
        this.JL35 = new JLabel();
        this.JL36 = new JLabel();
        this.JLDBlanco9 = new JLabel();
        this.jLabel10 = new JLabel();
        this.JP10 = new JPanel();
        this.JL37 = new JLabel();
        this.JL38 = new JLabel();
        this.JL39 = new JLabel();
        this.JL40 = new JLabel();
        this.JLDBlanco10 = new JLabel();
        this.jLabel11 = new JLabel();
        this.JP11 = new JPanel();
        this.JL41 = new JLabel();
        this.JL42 = new JLabel();
        this.JL43 = new JLabel();
        this.JL44 = new JLabel();
        this.JLDBlanco11 = new JLabel();
        this.jLabel12 = new JLabel();
        this.JP12 = new JPanel();
        this.JL45 = new JLabel();
        this.JL46 = new JLabel();
        this.JL47 = new JLabel();
        this.JL48 = new JLabel();
        this.JLDBlanco12 = new JLabel();
        this.jLabel13 = new JLabel();
        this.JP13 = new JPanel();
        this.JL49 = new JLabel();
        this.JL50 = new JLabel();
        this.JL51 = new JLabel();
        this.JL52 = new JLabel();
        this.JLDBlanco13 = new JLabel();
        this.jLabel14 = new JLabel();
        this.JP14 = new JPanel();
        this.JL53 = new JLabel();
        this.JL54 = new JLabel();
        this.JL55 = new JLabel();
        this.JL56 = new JLabel();
        this.JLDBlanco14 = new JLabel();
        this.jLabel15 = new JLabel();
        this.JP15 = new JPanel();
        this.JL57 = new JLabel();
        this.JL58 = new JLabel();
        this.JL59 = new JLabel();
        this.JL60 = new JLabel();
        this.JLDBlanco15 = new JLabel();
        this.jLabel16 = new JLabel();
        this.JP16 = new JPanel();
        this.JL61 = new JLabel();
        this.JL62 = new JLabel();
        this.JL63 = new JLabel();
        this.JL64 = new JLabel();
        this.JLDBlanco16 = new JLabel();
        this.jLabel17 = new JLabel();
        this.jLabel18 = new JLabel();
        this.JP17 = new JPanel();
        this.JL65 = new JLabel();
        this.JL66 = new JLabel();
        this.JL67 = new JLabel();
        this.JL68 = new JLabel();
        this.JLDBlanco17 = new JLabel();
        this.jLabel19 = new JLabel();
        this.JP18 = new JPanel();
        this.JL69 = new JLabel();
        this.JL70 = new JLabel();
        this.JL71 = new JLabel();
        this.JL72 = new JLabel();
        this.JLDBlanco18 = new JLabel();
        this.jLabel20 = new JLabel();
        this.JP19 = new JPanel();
        this.JL73 = new JLabel();
        this.JL74 = new JLabel();
        this.JL75 = new JLabel();
        this.JL76 = new JLabel();
        this.JLDBlanco19 = new JLabel();
        this.jLabel21 = new JLabel();
        this.JP20 = new JPanel();
        this.JL77 = new JLabel();
        this.JL78 = new JLabel();
        this.JL79 = new JLabel();
        this.JL80 = new JLabel();
        this.JLDBlanco20 = new JLabel();
        this.jLabel22 = new JLabel();
        this.JP21 = new JPanel();
        this.JL81 = new JLabel();
        this.JL82 = new JLabel();
        this.JL83 = new JLabel();
        this.JL84 = new JLabel();
        this.JLDBlanco21 = new JLabel();
        this.jLabel23 = new JLabel();
        this.JP22 = new JPanel();
        this.JL85 = new JLabel();
        this.JL86 = new JLabel();
        this.JL87 = new JLabel();
        this.JL88 = new JLabel();
        this.JLDBlanco22 = new JLabel();
        this.jLabel24 = new JLabel();
        this.JP23 = new JPanel();
        this.JL89 = new JLabel();
        this.JL90 = new JLabel();
        this.JL91 = new JLabel();
        this.JL92 = new JLabel();
        this.JLDBlanco23 = new JLabel();
        this.jLabel25 = new JLabel();
        this.JP24 = new JPanel();
        this.JL93 = new JLabel();
        this.JL94 = new JLabel();
        this.JL95 = new JLabel();
        this.JL96 = new JLabel();
        this.JLDBlanco24 = new JLabel();
        this.jLabel26 = new JLabel();
        this.JP25 = new JPanel();
        this.JL97 = new JLabel();
        this.JL98 = new JLabel();
        this.JL99 = new JLabel();
        this.JL100 = new JLabel();
        this.JLDBlanco25 = new JLabel();
        this.jLabel27 = new JLabel();
        this.JP26 = new JPanel();
        this.JL101 = new JLabel();
        this.JL102 = new JLabel();
        this.JL103 = new JLabel();
        this.JL104 = new JLabel();
        this.JLDBlanco26 = new JLabel();
        this.jLabel28 = new JLabel();
        this.JP27 = new JPanel();
        this.JL105 = new JLabel();
        this.JL106 = new JLabel();
        this.JL107 = new JLabel();
        this.JL108 = new JLabel();
        this.JLDBlanco27 = new JLabel();
        this.jLabel29 = new JLabel();
        this.JP28 = new JPanel();
        this.JL109 = new JLabel();
        this.JL110 = new JLabel();
        this.JL111 = new JLabel();
        this.JL112 = new JLabel();
        this.JLDBlanco28 = new JLabel();
        this.jLabel30 = new JLabel();
        this.JP29 = new JPanel();
        this.JL113 = new JLabel();
        this.JL114 = new JLabel();
        this.JL115 = new JLabel();
        this.JL116 = new JLabel();
        this.JLDBlanco29 = new JLabel();
        this.jLabel31 = new JLabel();
        this.JP30 = new JPanel();
        this.JL117 = new JLabel();
        this.JL118 = new JLabel();
        this.JL119 = new JLabel();
        this.JL120 = new JLabel();
        this.JLDBlanco30 = new JLabel();
        this.jLabel32 = new JLabel();
        this.JP31 = new JPanel();
        this.JL121 = new JLabel();
        this.JL122 = new JLabel();
        this.JL123 = new JLabel();
        this.JL124 = new JLabel();
        this.JLDBlanco31 = new JLabel();
        this.jLabel33 = new JLabel();
        this.JP32 = new JPanel();
        this.JL125 = new JLabel();
        this.JL126 = new JLabel();
        this.JL127 = new JLabel();
        this.JL128 = new JLabel();
        this.JLDBlanco32 = new JLabel();
        this.JLabelMargen = new JLabel();
        this.JCBProcedimiento = new JComboBox();
        this.JBTAdicionar = new JButton();
        this.jScrollPane1 = new JScrollPane();
        this.JTAObservacionDx = new JTextArea();
        this.JLIndiceOleary = new JLabel();
        this.JLCarasPlaca = new JLabel();
        this.JLCarasMarcadas = new JLabel();
        this.JLPresentes = new JLabel();
        this.JSPProcedimiento = new JScrollPane();
        this.JTProcedimiento = new JTable();
        this.JTFFCantidad = new JFormattedTextField();
        this.JPNotas = new JPanel();
        this.JTPNotas = new JTabbedPane();
        this.JPInformacionNotas = new JPanel();
        this.JDCFecha = new JDateChooser();
        this.JTFFHora = new JFormattedTextField();
        this.JCBTipoNota = new JComboBox();
        this.JSPNota = new JScrollPane();
        this.JTANota = new JTextArea();
        this.JSPHistoricoNotas = new JScrollPane();
        this.JTHistoricoNotas = new JTable();
        this.JPHistorico = new JPanel();
        this.JSPHistorico = new JScrollPane();
        this.JTHistorico = new JTable();
        this.JLCarasPlacaH = new JLabel();
        this.JLCarasMarcadasH = new JLabel();
        this.JLPresentesH = new JLabel();
        this.JLIndiceOlearyH = new JLabel();
        this.JSPProcedimientoH = new JScrollPane();
        this.JTProcedimientoH = new JTable();
        this.JPImOdontogramaHistorico = new JPanel();
        this.JP33 = new JPanel();
        this.JL129 = new JLabel();
        this.JL130 = new JLabel();
        this.JL131 = new JLabel();
        this.JL132 = new JLabel();
        this.JLDBlanco33 = new JLabel();
        this.jLabel34 = new JLabel();
        this.JP34 = new JPanel();
        this.JL133 = new JLabel();
        this.JL134 = new JLabel();
        this.JL135 = new JLabel();
        this.JL136 = new JLabel();
        this.JLDBlanco34 = new JLabel();
        this.jLabel35 = new JLabel();
        this.JP35 = new JPanel();
        this.JL137 = new JLabel();
        this.JL138 = new JLabel();
        this.JL139 = new JLabel();
        this.JL140 = new JLabel();
        this.JLDBlanco35 = new JLabel();
        this.jLabel36 = new JLabel();
        this.JP36 = new JPanel();
        this.JL141 = new JLabel();
        this.JL142 = new JLabel();
        this.JL143 = new JLabel();
        this.JL144 = new JLabel();
        this.JLDBlanco36 = new JLabel();
        this.jLabel37 = new JLabel();
        this.JP37 = new JPanel();
        this.JL145 = new JLabel();
        this.JL146 = new JLabel();
        this.JL147 = new JLabel();
        this.JL148 = new JLabel();
        this.JLDBlanco37 = new JLabel();
        this.jLabel38 = new JLabel();
        this.JP38 = new JPanel();
        this.JL149 = new JLabel();
        this.JL150 = new JLabel();
        this.JL151 = new JLabel();
        this.JL152 = new JLabel();
        this.JLDBlanco38 = new JLabel();
        this.jLabel39 = new JLabel();
        this.JP39 = new JPanel();
        this.JL153 = new JLabel();
        this.JL154 = new JLabel();
        this.JL155 = new JLabel();
        this.JL156 = new JLabel();
        this.JLDBlanco39 = new JLabel();
        this.jLabel40 = new JLabel();
        this.JP40 = new JPanel();
        this.JL157 = new JLabel();
        this.JL158 = new JLabel();
        this.JL159 = new JLabel();
        this.JL160 = new JLabel();
        this.JLDBlanco40 = new JLabel();
        this.jLabel41 = new JLabel();
        this.JP41 = new JPanel();
        this.JL161 = new JLabel();
        this.JL162 = new JLabel();
        this.JL163 = new JLabel();
        this.JL164 = new JLabel();
        this.JLDBlanco41 = new JLabel();
        this.jLabel42 = new JLabel();
        this.JP42 = new JPanel();
        this.JL165 = new JLabel();
        this.JL166 = new JLabel();
        this.JL167 = new JLabel();
        this.JL168 = new JLabel();
        this.JLDBlanco42 = new JLabel();
        this.jLabel43 = new JLabel();
        this.JP43 = new JPanel();
        this.JL169 = new JLabel();
        this.JL170 = new JLabel();
        this.JL171 = new JLabel();
        this.JL172 = new JLabel();
        this.JLDBlanco43 = new JLabel();
        this.jLabel44 = new JLabel();
        this.JP44 = new JPanel();
        this.JL173 = new JLabel();
        this.JL174 = new JLabel();
        this.JL175 = new JLabel();
        this.JL176 = new JLabel();
        this.JLDBlanco44 = new JLabel();
        this.jLabel45 = new JLabel();
        this.JP45 = new JPanel();
        this.JL177 = new JLabel();
        this.JL178 = new JLabel();
        this.JL179 = new JLabel();
        this.JL180 = new JLabel();
        this.JLDBlanco45 = new JLabel();
        this.jLabel46 = new JLabel();
        this.JP46 = new JPanel();
        this.JL181 = new JLabel();
        this.JL182 = new JLabel();
        this.JL183 = new JLabel();
        this.JL184 = new JLabel();
        this.JLDBlanco46 = new JLabel();
        this.jLabel47 = new JLabel();
        this.JP47 = new JPanel();
        this.JL185 = new JLabel();
        this.JL186 = new JLabel();
        this.JL187 = new JLabel();
        this.JL188 = new JLabel();
        this.JLDBlanco47 = new JLabel();
        this.jLabel48 = new JLabel();
        this.JP48 = new JPanel();
        this.JL189 = new JLabel();
        this.JL190 = new JLabel();
        this.JL191 = new JLabel();
        this.JL192 = new JLabel();
        this.JLDBlanco48 = new JLabel();
        this.jLabel49 = new JLabel();
        this.jLabel50 = new JLabel();
        this.JP49 = new JPanel();
        this.JL193 = new JLabel();
        this.JL194 = new JLabel();
        this.JL195 = new JLabel();
        this.JL196 = new JLabel();
        this.JLDBlanco49 = new JLabel();
        this.jLabel51 = new JLabel();
        this.JP50 = new JPanel();
        this.JL197 = new JLabel();
        this.JL198 = new JLabel();
        this.JL199 = new JLabel();
        this.JL200 = new JLabel();
        this.JLDBlanco50 = new JLabel();
        this.jLabel52 = new JLabel();
        this.JP51 = new JPanel();
        this.JL201 = new JLabel();
        this.JL202 = new JLabel();
        this.JL203 = new JLabel();
        this.JL204 = new JLabel();
        this.JLDBlanco51 = new JLabel();
        this.jLabel53 = new JLabel();
        this.JP52 = new JPanel();
        this.JL205 = new JLabel();
        this.JL206 = new JLabel();
        this.JL207 = new JLabel();
        this.JL208 = new JLabel();
        this.JLDBlanco52 = new JLabel();
        this.jLabel54 = new JLabel();
        this.JP53 = new JPanel();
        this.JL209 = new JLabel();
        this.JL210 = new JLabel();
        this.JL211 = new JLabel();
        this.JL212 = new JLabel();
        this.JLDBlanco53 = new JLabel();
        this.jLabel55 = new JLabel();
        this.JP54 = new JPanel();
        this.JL213 = new JLabel();
        this.JL214 = new JLabel();
        this.JL215 = new JLabel();
        this.JL216 = new JLabel();
        this.JLDBlanco54 = new JLabel();
        this.jLabel56 = new JLabel();
        this.JP55 = new JPanel();
        this.JL217 = new JLabel();
        this.JL218 = new JLabel();
        this.JL219 = new JLabel();
        this.JL220 = new JLabel();
        this.JLDBlanco55 = new JLabel();
        this.jLabel57 = new JLabel();
        this.JP56 = new JPanel();
        this.JL221 = new JLabel();
        this.JL222 = new JLabel();
        this.JL223 = new JLabel();
        this.JL224 = new JLabel();
        this.JLDBlanco56 = new JLabel();
        this.jLabel58 = new JLabel();
        this.JP57 = new JPanel();
        this.JL225 = new JLabel();
        this.JL226 = new JLabel();
        this.JL227 = new JLabel();
        this.JL228 = new JLabel();
        this.JLDBlanco57 = new JLabel();
        this.jLabel59 = new JLabel();
        this.JP58 = new JPanel();
        this.JL229 = new JLabel();
        this.JL230 = new JLabel();
        this.JL231 = new JLabel();
        this.JL232 = new JLabel();
        this.JLDBlanco58 = new JLabel();
        this.jLabel60 = new JLabel();
        this.JP59 = new JPanel();
        this.JL233 = new JLabel();
        this.JL234 = new JLabel();
        this.JL235 = new JLabel();
        this.JL236 = new JLabel();
        this.JLDBlanco59 = new JLabel();
        this.jLabel61 = new JLabel();
        this.JP60 = new JPanel();
        this.JL237 = new JLabel();
        this.JL238 = new JLabel();
        this.JL239 = new JLabel();
        this.JL240 = new JLabel();
        this.JLDBlanco60 = new JLabel();
        this.jLabel62 = new JLabel();
        this.JP61 = new JPanel();
        this.JL241 = new JLabel();
        this.JL242 = new JLabel();
        this.JL243 = new JLabel();
        this.JL244 = new JLabel();
        this.JLDBlanco61 = new JLabel();
        this.jLabel63 = new JLabel();
        this.JP62 = new JPanel();
        this.JL245 = new JLabel();
        this.JL246 = new JLabel();
        this.JL247 = new JLabel();
        this.JL248 = new JLabel();
        this.JLDBlanco62 = new JLabel();
        this.jLabel64 = new JLabel();
        this.JP63 = new JPanel();
        this.JL249 = new JLabel();
        this.JL250 = new JLabel();
        this.JL251 = new JLabel();
        this.JL252 = new JLabel();
        this.JLDBlanco63 = new JLabel();
        this.jLabel65 = new JLabel();
        this.JP64 = new JPanel();
        this.JL253 = new JLabel();
        this.JL254 = new JLabel();
        this.JL255 = new JLabel();
        this.JL256 = new JLabel();
        this.JLDBlanco64 = new JLabel();
        this.JSPPaleta = new JPanel();
        this.JTBPlacaB = new JToggleButton();
        this.JTBExtraccion = new JToggleButton();
        this.JTBCorona = new JToggleButton();
        this.JTBSinErupsionar = new JToggleButton();
        this.JTBPuente = new JToggleButton();
        this.JTBBorrador = new JToggleButton();
        this.JLEstadoT = new JLabel();
        this.JBFinalizaTratramiento = new JButton();
        setBorder(BorderFactory.createTitledBorder((Border) null, "ODONTOGRAMA", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        setName("jifControlPlaca");
        this.JTPDatos.setForeground(Color.red);
        this.JTPDatos.setFont(new Font("Arial", 1, 14));
        this.JSPDetalleO.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE DIENTES MARCADOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 0, 255)));
        this.JTDetalleO.setFont(new Font("Arial", 1, 12));
        this.JTDetalleO.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalleO.setRowHeight(25);
        this.JTDetalleO.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalleO.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalleO.setSelectionMode(0);
        this.JTDetalleO.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPControlPlaca.1
            public void mouseClicked(MouseEvent evt) {
                JPControlPlaca.this.JTDetalleOMouseClicked(evt);
            }
        });
        this.JTDetalleO.addKeyListener(new KeyAdapter() { // from class: Odontologia.JPControlPlaca.2
            public void keyPressed(KeyEvent evt) {
                JPControlPlaca.this.JTDetalleOKeyPressed(evt);
            }
        });
        this.JSPDetalleO.setViewportView(this.JTDetalleO);
        this.JPImOdontograma.setBackground(new Color(255, 255, 255));
        this.JPImOdontograma.setLayout((LayoutManager) null);
        this.JP1.setMaximumSize(new Dimension(41, 45));
        this.JP1.setMinimumSize(new Dimension(41, 45));
        this.JP1.setName("1");
        this.JP1.setOpaque(false);
        this.JP1.setPreferredSize(new Dimension(41, 45));
        this.JP1.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPControlPlaca.3
            public void mouseClicked(MouseEvent evt) {
                JPControlPlaca.this.JP1MouseClicked(evt);
            }
        });
        this.JP1.setLayout((LayoutManager) null);
        this.JL4.setMaximumSize(new Dimension(41, 45));
        this.JL4.setMinimumSize(new Dimension(41, 45));
        this.JL4.setName("4");
        this.JL4.setPreferredSize(new Dimension(41, 45));
        this.JP1.add(this.JL4);
        this.JL4.setBounds(0, 0, 41, 45);
        this.JL3.setMaximumSize(new Dimension(41, 45));
        this.JL3.setMinimumSize(new Dimension(41, 45));
        this.JL3.setName("3");
        this.JL3.setPreferredSize(new Dimension(41, 45));
        this.JP1.add(this.JL3);
        this.JL3.setBounds(0, 0, 41, 45);
        this.JL2.setMaximumSize(new Dimension(41, 45));
        this.JL2.setMinimumSize(new Dimension(41, 45));
        this.JL2.setName("2");
        this.JL2.setPreferredSize(new Dimension(41, 45));
        this.JP1.add(this.JL2);
        this.JL2.setBounds(0, 0, 41, 45);
        this.JL1.setMaximumSize(new Dimension(41, 45));
        this.JL1.setMinimumSize(new Dimension(41, 45));
        this.JL1.setName("1");
        this.JL1.setPreferredSize(new Dimension(41, 45));
        this.JP1.add(this.JL1);
        this.JL1.setBounds(0, 0, 41, 45);
        this.JLDBlanco1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/diente_blancoCP.png")));
        this.JLDBlanco1.setName("0");
        this.JP1.add(this.JLDBlanco1);
        this.JLDBlanco1.setBounds(0, 0, 41, 45);
        this.JPImOdontograma.add(this.JP1);
        this.JP1.setBounds(10, 27, 41, 45);
        this.jLabel2.setFont(new Font("Arial", 1, 12));
        this.jLabel2.setHorizontalAlignment(0);
        this.jLabel2.setText("1");
        this.JPImOdontograma.add(this.jLabel2);
        this.jLabel2.setBounds(10, 11, 41, 14);
        this.JP2.setMaximumSize(new Dimension(41, 45));
        this.JP2.setMinimumSize(new Dimension(41, 45));
        this.JP2.setName("2");
        this.JP2.setOpaque(false);
        this.JP2.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPControlPlaca.4
            public void mouseClicked(MouseEvent evt) {
                JPControlPlaca.this.JP2MouseClicked(evt);
            }
        });
        this.JP2.setLayout((LayoutManager) null);
        this.JL5.setMaximumSize(new Dimension(41, 45));
        this.JL5.setMinimumSize(new Dimension(41, 45));
        this.JL5.setName("4");
        this.JL5.setPreferredSize(new Dimension(41, 45));
        this.JP2.add(this.JL5);
        this.JL5.setBounds(0, 0, 41, 45);
        this.JL6.setMaximumSize(new Dimension(41, 45));
        this.JL6.setMinimumSize(new Dimension(41, 45));
        this.JL6.setName("3");
        this.JL6.setPreferredSize(new Dimension(41, 45));
        this.JP2.add(this.JL6);
        this.JL6.setBounds(0, 0, 41, 45);
        this.JL7.setMaximumSize(new Dimension(41, 45));
        this.JL7.setMinimumSize(new Dimension(41, 45));
        this.JL7.setName("2");
        this.JL7.setPreferredSize(new Dimension(41, 45));
        this.JP2.add(this.JL7);
        this.JL7.setBounds(0, 0, 41, 45);
        this.JL8.setMaximumSize(new Dimension(41, 45));
        this.JL8.setMinimumSize(new Dimension(41, 45));
        this.JL8.setName("1");
        this.JL8.setPreferredSize(new Dimension(41, 45));
        this.JP2.add(this.JL8);
        this.JL8.setBounds(0, 0, 41, 45);
        this.JLDBlanco2.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/diente_blancoCP.png")));
        this.JLDBlanco2.setName("0");
        this.JP2.add(this.JLDBlanco2);
        this.JLDBlanco2.setBounds(0, 0, 41, 45);
        this.JPImOdontograma.add(this.JP2);
        this.JP2.setBounds(51, 27, 41, 45);
        this.jLabel3.setFont(new Font("Arial", 1, 12));
        this.jLabel3.setHorizontalAlignment(0);
        this.jLabel3.setText("2");
        this.JPImOdontograma.add(this.jLabel3);
        this.jLabel3.setBounds(51, 11, 41, 14);
        this.JP3.setMaximumSize(new Dimension(41, 45));
        this.JP3.setMinimumSize(new Dimension(41, 45));
        this.JP3.setName("3");
        this.JP3.setOpaque(false);
        this.JP3.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPControlPlaca.5
            public void mouseClicked(MouseEvent evt) {
                JPControlPlaca.this.JP3MouseClicked(evt);
            }
        });
        this.JP3.setLayout((LayoutManager) null);
        this.JL9.setMaximumSize(new Dimension(41, 45));
        this.JL9.setMinimumSize(new Dimension(41, 45));
        this.JL9.setName("4");
        this.JL9.setPreferredSize(new Dimension(41, 45));
        this.JP3.add(this.JL9);
        this.JL9.setBounds(0, 0, 41, 45);
        this.JL10.setMaximumSize(new Dimension(41, 45));
        this.JL10.setMinimumSize(new Dimension(41, 45));
        this.JL10.setName("3");
        this.JL10.setPreferredSize(new Dimension(41, 45));
        this.JP3.add(this.JL10);
        this.JL10.setBounds(0, 0, 41, 45);
        this.JL11.setMaximumSize(new Dimension(41, 45));
        this.JL11.setMinimumSize(new Dimension(41, 45));
        this.JL11.setName("2");
        this.JL11.setPreferredSize(new Dimension(41, 45));
        this.JP3.add(this.JL11);
        this.JL11.setBounds(0, 0, 41, 45);
        this.JL12.setMaximumSize(new Dimension(41, 45));
        this.JL12.setMinimumSize(new Dimension(41, 45));
        this.JL12.setName("1");
        this.JL12.setPreferredSize(new Dimension(41, 45));
        this.JP3.add(this.JL12);
        this.JL12.setBounds(0, 0, 41, 45);
        this.JLDBlanco3.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/diente_blancoCP.png")));
        this.JLDBlanco3.setName("0");
        this.JP3.add(this.JLDBlanco3);
        this.JLDBlanco3.setBounds(0, 0, 41, 45);
        this.JPImOdontograma.add(this.JP3);
        this.JP3.setBounds(92, 27, 41, 45);
        this.jLabel4.setFont(new Font("Arial", 1, 12));
        this.jLabel4.setHorizontalAlignment(0);
        this.jLabel4.setText("3");
        this.JPImOdontograma.add(this.jLabel4);
        this.jLabel4.setBounds(92, 11, 41, 14);
        this.JP4.setMaximumSize(new Dimension(41, 45));
        this.JP4.setMinimumSize(new Dimension(41, 45));
        this.JP4.setName("4");
        this.JP4.setOpaque(false);
        this.JP4.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPControlPlaca.6
            public void mouseClicked(MouseEvent evt) {
                JPControlPlaca.this.JP4MouseClicked(evt);
            }
        });
        this.JP4.setLayout((LayoutManager) null);
        this.JL13.setMaximumSize(new Dimension(41, 45));
        this.JL13.setMinimumSize(new Dimension(41, 45));
        this.JL13.setName("4");
        this.JL13.setPreferredSize(new Dimension(41, 45));
        this.JP4.add(this.JL13);
        this.JL13.setBounds(0, 0, 41, 45);
        this.JL14.setMaximumSize(new Dimension(41, 45));
        this.JL14.setMinimumSize(new Dimension(41, 45));
        this.JL14.setName("3");
        this.JL14.setPreferredSize(new Dimension(41, 45));
        this.JP4.add(this.JL14);
        this.JL14.setBounds(0, 0, 41, 45);
        this.JL15.setMaximumSize(new Dimension(41, 45));
        this.JL15.setMinimumSize(new Dimension(41, 45));
        this.JL15.setName("2");
        this.JL15.setPreferredSize(new Dimension(41, 45));
        this.JP4.add(this.JL15);
        this.JL15.setBounds(0, 0, 41, 45);
        this.JL16.setMaximumSize(new Dimension(41, 45));
        this.JL16.setMinimumSize(new Dimension(41, 45));
        this.JL16.setName("1");
        this.JL16.setPreferredSize(new Dimension(41, 45));
        this.JP4.add(this.JL16);
        this.JL16.setBounds(0, 0, 41, 45);
        this.JLDBlanco4.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/diente_blancoCP.png")));
        this.JLDBlanco4.setName("0");
        this.JP4.add(this.JLDBlanco4);
        this.JLDBlanco4.setBounds(0, 0, 41, 45);
        this.JPImOdontograma.add(this.JP4);
        this.JP4.setBounds(133, 27, 41, 45);
        this.jLabel5.setFont(new Font("Arial", 1, 12));
        this.jLabel5.setHorizontalAlignment(0);
        this.jLabel5.setText("4");
        this.JPImOdontograma.add(this.jLabel5);
        this.jLabel5.setBounds(133, 11, 41, 14);
        this.JP5.setMaximumSize(new Dimension(41, 45));
        this.JP5.setMinimumSize(new Dimension(41, 45));
        this.JP5.setName("5");
        this.JP5.setOpaque(false);
        this.JP5.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPControlPlaca.7
            public void mouseClicked(MouseEvent evt) {
                JPControlPlaca.this.JP5MouseClicked(evt);
            }
        });
        this.JP5.setLayout((LayoutManager) null);
        this.JL17.setMaximumSize(new Dimension(41, 45));
        this.JL17.setMinimumSize(new Dimension(41, 45));
        this.JL17.setName("4");
        this.JL17.setPreferredSize(new Dimension(41, 45));
        this.JP5.add(this.JL17);
        this.JL17.setBounds(0, 0, 41, 45);
        this.JL18.setMaximumSize(new Dimension(41, 45));
        this.JL18.setMinimumSize(new Dimension(41, 45));
        this.JL18.setName("3");
        this.JL18.setPreferredSize(new Dimension(41, 45));
        this.JP5.add(this.JL18);
        this.JL18.setBounds(0, 0, 41, 45);
        this.JL19.setMaximumSize(new Dimension(41, 45));
        this.JL19.setMinimumSize(new Dimension(41, 45));
        this.JL19.setName("2");
        this.JL19.setPreferredSize(new Dimension(41, 45));
        this.JP5.add(this.JL19);
        this.JL19.setBounds(0, 0, 41, 45);
        this.JL20.setMaximumSize(new Dimension(41, 45));
        this.JL20.setMinimumSize(new Dimension(41, 45));
        this.JL20.setName("1");
        this.JL20.setPreferredSize(new Dimension(41, 45));
        this.JP5.add(this.JL20);
        this.JL20.setBounds(0, 0, 41, 45);
        this.JLDBlanco5.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/diente_blancoCP.png")));
        this.JLDBlanco5.setName("0");
        this.JP5.add(this.JLDBlanco5);
        this.JLDBlanco5.setBounds(0, 0, 41, 45);
        this.JPImOdontograma.add(this.JP5);
        this.JP5.setBounds(174, 27, 41, 45);
        this.jLabel6.setFont(new Font("Arial", 1, 12));
        this.jLabel6.setHorizontalAlignment(0);
        this.jLabel6.setText("5");
        this.JPImOdontograma.add(this.jLabel6);
        this.jLabel6.setBounds(174, 11, 41, 14);
        this.JP6.setMaximumSize(new Dimension(41, 45));
        this.JP6.setMinimumSize(new Dimension(41, 45));
        this.JP6.setName("6");
        this.JP6.setOpaque(false);
        this.JP6.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPControlPlaca.8
            public void mouseClicked(MouseEvent evt) {
                JPControlPlaca.this.JP6MouseClicked(evt);
            }
        });
        this.JP6.setLayout((LayoutManager) null);
        this.JL21.setMaximumSize(new Dimension(41, 45));
        this.JL21.setMinimumSize(new Dimension(41, 45));
        this.JL21.setName("4");
        this.JL21.setPreferredSize(new Dimension(41, 45));
        this.JP6.add(this.JL21);
        this.JL21.setBounds(0, 0, 41, 45);
        this.JL22.setMaximumSize(new Dimension(41, 45));
        this.JL22.setMinimumSize(new Dimension(41, 45));
        this.JL22.setName("3");
        this.JL22.setPreferredSize(new Dimension(41, 45));
        this.JP6.add(this.JL22);
        this.JL22.setBounds(0, 0, 41, 45);
        this.JL23.setMaximumSize(new Dimension(41, 45));
        this.JL23.setMinimumSize(new Dimension(41, 45));
        this.JL23.setName("2");
        this.JL23.setPreferredSize(new Dimension(41, 45));
        this.JP6.add(this.JL23);
        this.JL23.setBounds(0, 0, 41, 45);
        this.JL24.setMaximumSize(new Dimension(41, 45));
        this.JL24.setMinimumSize(new Dimension(41, 45));
        this.JL24.setName("1");
        this.JL24.setPreferredSize(new Dimension(41, 45));
        this.JP6.add(this.JL24);
        this.JL24.setBounds(0, 0, 41, 45);
        this.JLDBlanco6.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/diente_blancoCP.png")));
        this.JLDBlanco6.setName("0");
        this.JP6.add(this.JLDBlanco6);
        this.JLDBlanco6.setBounds(0, 0, 41, 45);
        this.JPImOdontograma.add(this.JP6);
        this.JP6.setBounds(215, 27, 41, 45);
        this.jLabel7.setFont(new Font("Arial", 1, 12));
        this.jLabel7.setHorizontalAlignment(0);
        this.jLabel7.setText("6");
        this.JPImOdontograma.add(this.jLabel7);
        this.jLabel7.setBounds(215, 11, 41, 14);
        this.JP7.setMaximumSize(new Dimension(41, 45));
        this.JP7.setMinimumSize(new Dimension(41, 45));
        this.JP7.setName("7");
        this.JP7.setOpaque(false);
        this.JP7.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPControlPlaca.9
            public void mouseClicked(MouseEvent evt) {
                JPControlPlaca.this.JP7MouseClicked(evt);
            }
        });
        this.JP7.setLayout((LayoutManager) null);
        this.JL25.setMaximumSize(new Dimension(41, 45));
        this.JL25.setMinimumSize(new Dimension(41, 45));
        this.JL25.setName("4");
        this.JL25.setPreferredSize(new Dimension(41, 45));
        this.JP7.add(this.JL25);
        this.JL25.setBounds(0, 0, 41, 45);
        this.JL26.setMaximumSize(new Dimension(41, 45));
        this.JL26.setMinimumSize(new Dimension(41, 45));
        this.JL26.setName("3");
        this.JL26.setPreferredSize(new Dimension(41, 45));
        this.JP7.add(this.JL26);
        this.JL26.setBounds(0, 0, 41, 45);
        this.JL27.setMaximumSize(new Dimension(41, 45));
        this.JL27.setMinimumSize(new Dimension(41, 45));
        this.JL27.setName("2");
        this.JL27.setPreferredSize(new Dimension(41, 45));
        this.JP7.add(this.JL27);
        this.JL27.setBounds(0, 0, 41, 45);
        this.JL28.setMaximumSize(new Dimension(41, 45));
        this.JL28.setMinimumSize(new Dimension(41, 45));
        this.JL28.setName("1");
        this.JL28.setPreferredSize(new Dimension(41, 45));
        this.JP7.add(this.JL28);
        this.JL28.setBounds(0, 0, 41, 45);
        this.JLDBlanco7.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/diente_blancoCP.png")));
        this.JLDBlanco7.setName("0");
        this.JP7.add(this.JLDBlanco7);
        this.JLDBlanco7.setBounds(0, 0, 41, 45);
        this.JPImOdontograma.add(this.JP7);
        this.JP7.setBounds(256, 27, 41, 45);
        this.jLabel8.setFont(new Font("Arial", 1, 12));
        this.jLabel8.setHorizontalAlignment(0);
        this.jLabel8.setText("7");
        this.JPImOdontograma.add(this.jLabel8);
        this.jLabel8.setBounds(256, 11, 41, 14);
        this.JP8.setMaximumSize(new Dimension(41, 45));
        this.JP8.setMinimumSize(new Dimension(41, 45));
        this.JP8.setName("8");
        this.JP8.setOpaque(false);
        this.JP8.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPControlPlaca.10
            public void mouseClicked(MouseEvent evt) {
                JPControlPlaca.this.JP8MouseClicked(evt);
            }
        });
        this.JP8.setLayout((LayoutManager) null);
        this.JL29.setMaximumSize(new Dimension(41, 45));
        this.JL29.setMinimumSize(new Dimension(41, 45));
        this.JL29.setName("4");
        this.JL29.setPreferredSize(new Dimension(41, 45));
        this.JP8.add(this.JL29);
        this.JL29.setBounds(0, 0, 41, 45);
        this.JL30.setMaximumSize(new Dimension(41, 45));
        this.JL30.setMinimumSize(new Dimension(41, 45));
        this.JL30.setName("3");
        this.JL30.setPreferredSize(new Dimension(41, 45));
        this.JP8.add(this.JL30);
        this.JL30.setBounds(0, 0, 41, 45);
        this.JL31.setMaximumSize(new Dimension(41, 45));
        this.JL31.setMinimumSize(new Dimension(41, 45));
        this.JL31.setName("2");
        this.JL31.setPreferredSize(new Dimension(41, 45));
        this.JP8.add(this.JL31);
        this.JL31.setBounds(0, 0, 41, 45);
        this.JL32.setMaximumSize(new Dimension(41, 45));
        this.JL32.setMinimumSize(new Dimension(41, 45));
        this.JL32.setName("1");
        this.JL32.setPreferredSize(new Dimension(41, 45));
        this.JP8.add(this.JL32);
        this.JL32.setBounds(0, 0, 41, 45);
        this.JLDBlanco8.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/diente_blancoCP.png")));
        this.JLDBlanco8.setName("0");
        this.JP8.add(this.JLDBlanco8);
        this.JLDBlanco8.setBounds(0, 0, 41, 45);
        this.JPImOdontograma.add(this.JP8);
        this.JP8.setBounds(297, 27, 41, 45);
        this.jLabel9.setFont(new Font("Arial", 1, 12));
        this.jLabel9.setHorizontalAlignment(0);
        this.jLabel9.setText("8");
        this.JPImOdontograma.add(this.jLabel9);
        this.jLabel9.setBounds(297, 11, 41, 14);
        this.JP9.setMaximumSize(new Dimension(41, 45));
        this.JP9.setMinimumSize(new Dimension(41, 45));
        this.JP9.setName("9");
        this.JP9.setOpaque(false);
        this.JP9.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPControlPlaca.11
            public void mouseClicked(MouseEvent evt) {
                JPControlPlaca.this.JP9MouseClicked(evt);
            }
        });
        this.JP9.setLayout((LayoutManager) null);
        this.JL33.setMaximumSize(new Dimension(41, 45));
        this.JL33.setMinimumSize(new Dimension(41, 45));
        this.JL33.setName("4");
        this.JL33.setPreferredSize(new Dimension(41, 45));
        this.JP9.add(this.JL33);
        this.JL33.setBounds(0, 0, 41, 45);
        this.JL34.setMaximumSize(new Dimension(41, 45));
        this.JL34.setMinimumSize(new Dimension(41, 45));
        this.JL34.setName("3");
        this.JL34.setPreferredSize(new Dimension(41, 45));
        this.JP9.add(this.JL34);
        this.JL34.setBounds(0, 0, 41, 45);
        this.JL35.setMaximumSize(new Dimension(41, 45));
        this.JL35.setMinimumSize(new Dimension(41, 45));
        this.JL35.setName("2");
        this.JL35.setPreferredSize(new Dimension(41, 45));
        this.JP9.add(this.JL35);
        this.JL35.setBounds(0, 0, 41, 45);
        this.JL36.setMaximumSize(new Dimension(41, 45));
        this.JL36.setMinimumSize(new Dimension(41, 45));
        this.JL36.setName("1");
        this.JL36.setPreferredSize(new Dimension(41, 45));
        this.JP9.add(this.JL36);
        this.JL36.setBounds(0, 0, 41, 45);
        this.JLDBlanco9.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/diente_blancoCP.png")));
        this.JLDBlanco9.setName("0");
        this.JP9.add(this.JLDBlanco9);
        this.JLDBlanco9.setBounds(0, 0, 41, 45);
        this.JPImOdontograma.add(this.JP9);
        this.JP9.setBounds(338, 27, 41, 45);
        this.jLabel10.setFont(new Font("Arial", 1, 12));
        this.jLabel10.setHorizontalAlignment(0);
        this.jLabel10.setText("9");
        this.JPImOdontograma.add(this.jLabel10);
        this.jLabel10.setBounds(338, 11, 41, 14);
        this.JP10.setMaximumSize(new Dimension(41, 45));
        this.JP10.setMinimumSize(new Dimension(41, 45));
        this.JP10.setName("10");
        this.JP10.setOpaque(false);
        this.JP10.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPControlPlaca.12
            public void mouseClicked(MouseEvent evt) {
                JPControlPlaca.this.JP10MouseClicked(evt);
            }
        });
        this.JP10.setLayout((LayoutManager) null);
        this.JL37.setMaximumSize(new Dimension(41, 45));
        this.JL37.setMinimumSize(new Dimension(41, 45));
        this.JL37.setName("4");
        this.JL37.setPreferredSize(new Dimension(41, 45));
        this.JP10.add(this.JL37);
        this.JL37.setBounds(0, 0, 41, 45);
        this.JL38.setMaximumSize(new Dimension(41, 45));
        this.JL38.setMinimumSize(new Dimension(41, 45));
        this.JL38.setName("3");
        this.JL38.setPreferredSize(new Dimension(41, 45));
        this.JP10.add(this.JL38);
        this.JL38.setBounds(0, 0, 41, 45);
        this.JL39.setMaximumSize(new Dimension(41, 45));
        this.JL39.setMinimumSize(new Dimension(41, 45));
        this.JL39.setName("2");
        this.JL39.setPreferredSize(new Dimension(41, 45));
        this.JP10.add(this.JL39);
        this.JL39.setBounds(0, 0, 41, 45);
        this.JL40.setMaximumSize(new Dimension(41, 45));
        this.JL40.setMinimumSize(new Dimension(41, 45));
        this.JL40.setName("1");
        this.JL40.setPreferredSize(new Dimension(41, 45));
        this.JP10.add(this.JL40);
        this.JL40.setBounds(0, 0, 41, 45);
        this.JLDBlanco10.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/diente_blancoCP.png")));
        this.JLDBlanco10.setName("0");
        this.JP10.add(this.JLDBlanco10);
        this.JLDBlanco10.setBounds(0, 0, 41, 45);
        this.JPImOdontograma.add(this.JP10);
        this.JP10.setBounds(379, 27, 41, 45);
        this.jLabel11.setFont(new Font("Arial", 1, 12));
        this.jLabel11.setHorizontalAlignment(0);
        this.jLabel11.setText("10");
        this.JPImOdontograma.add(this.jLabel11);
        this.jLabel11.setBounds(379, 11, 41, 14);
        this.JP11.setMaximumSize(new Dimension(41, 45));
        this.JP11.setMinimumSize(new Dimension(41, 45));
        this.JP11.setName("11");
        this.JP11.setOpaque(false);
        this.JP11.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPControlPlaca.13
            public void mouseClicked(MouseEvent evt) {
                JPControlPlaca.this.JP11MouseClicked(evt);
            }
        });
        this.JP11.setLayout((LayoutManager) null);
        this.JL41.setMaximumSize(new Dimension(41, 45));
        this.JL41.setMinimumSize(new Dimension(41, 45));
        this.JL41.setName("4");
        this.JL41.setPreferredSize(new Dimension(41, 45));
        this.JP11.add(this.JL41);
        this.JL41.setBounds(0, 0, 41, 45);
        this.JL42.setMaximumSize(new Dimension(41, 45));
        this.JL42.setMinimumSize(new Dimension(41, 45));
        this.JL42.setName("3");
        this.JL42.setPreferredSize(new Dimension(41, 45));
        this.JP11.add(this.JL42);
        this.JL42.setBounds(0, 0, 41, 45);
        this.JL43.setMaximumSize(new Dimension(41, 45));
        this.JL43.setMinimumSize(new Dimension(41, 45));
        this.JL43.setName("2");
        this.JL43.setPreferredSize(new Dimension(41, 45));
        this.JP11.add(this.JL43);
        this.JL43.setBounds(0, 0, 41, 45);
        this.JL44.setMaximumSize(new Dimension(41, 45));
        this.JL44.setMinimumSize(new Dimension(41, 45));
        this.JL44.setName("1");
        this.JL44.setPreferredSize(new Dimension(41, 45));
        this.JP11.add(this.JL44);
        this.JL44.setBounds(0, 0, 41, 45);
        this.JLDBlanco11.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/diente_blancoCP.png")));
        this.JLDBlanco11.setName("0");
        this.JP11.add(this.JLDBlanco11);
        this.JLDBlanco11.setBounds(0, 0, 41, 45);
        this.JPImOdontograma.add(this.JP11);
        this.JP11.setBounds(420, 27, 41, 45);
        this.jLabel12.setFont(new Font("Arial", 1, 12));
        this.jLabel12.setHorizontalAlignment(0);
        this.jLabel12.setText("11");
        this.JPImOdontograma.add(this.jLabel12);
        this.jLabel12.setBounds(420, 11, 41, 14);
        this.JP12.setMaximumSize(new Dimension(41, 45));
        this.JP12.setMinimumSize(new Dimension(41, 45));
        this.JP12.setName("12");
        this.JP12.setOpaque(false);
        this.JP12.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPControlPlaca.14
            public void mouseClicked(MouseEvent evt) {
                JPControlPlaca.this.JP12MouseClicked(evt);
            }
        });
        this.JP12.setLayout((LayoutManager) null);
        this.JL45.setMaximumSize(new Dimension(41, 45));
        this.JL45.setMinimumSize(new Dimension(41, 45));
        this.JL45.setName("4");
        this.JL45.setPreferredSize(new Dimension(41, 45));
        this.JP12.add(this.JL45);
        this.JL45.setBounds(0, 0, 41, 45);
        this.JL46.setMaximumSize(new Dimension(41, 45));
        this.JL46.setMinimumSize(new Dimension(41, 45));
        this.JL46.setName("3");
        this.JL46.setPreferredSize(new Dimension(41, 45));
        this.JP12.add(this.JL46);
        this.JL46.setBounds(0, 0, 41, 45);
        this.JL47.setMaximumSize(new Dimension(41, 45));
        this.JL47.setMinimumSize(new Dimension(41, 45));
        this.JL47.setName("2");
        this.JL47.setPreferredSize(new Dimension(41, 45));
        this.JP12.add(this.JL47);
        this.JL47.setBounds(0, 0, 41, 45);
        this.JL48.setMaximumSize(new Dimension(41, 45));
        this.JL48.setMinimumSize(new Dimension(41, 45));
        this.JL48.setName("1");
        this.JL48.setPreferredSize(new Dimension(41, 45));
        this.JP12.add(this.JL48);
        this.JL48.setBounds(0, 0, 41, 45);
        this.JLDBlanco12.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/diente_blancoCP.png")));
        this.JLDBlanco12.setName("0");
        this.JP12.add(this.JLDBlanco12);
        this.JLDBlanco12.setBounds(0, 0, 41, 45);
        this.JPImOdontograma.add(this.JP12);
        this.JP12.setBounds(461, 27, 41, 45);
        this.jLabel13.setFont(new Font("Arial", 1, 12));
        this.jLabel13.setHorizontalAlignment(0);
        this.jLabel13.setText("12");
        this.JPImOdontograma.add(this.jLabel13);
        this.jLabel13.setBounds(461, 11, 41, 14);
        this.JP13.setMaximumSize(new Dimension(41, 45));
        this.JP13.setMinimumSize(new Dimension(41, 45));
        this.JP13.setName("13");
        this.JP13.setOpaque(false);
        this.JP13.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPControlPlaca.15
            public void mouseClicked(MouseEvent evt) {
                JPControlPlaca.this.JP13MouseClicked(evt);
            }
        });
        this.JP13.setLayout((LayoutManager) null);
        this.JL49.setMaximumSize(new Dimension(41, 45));
        this.JL49.setMinimumSize(new Dimension(41, 45));
        this.JL49.setName("4");
        this.JL49.setPreferredSize(new Dimension(41, 45));
        this.JP13.add(this.JL49);
        this.JL49.setBounds(0, 0, 41, 45);
        this.JL50.setMaximumSize(new Dimension(41, 45));
        this.JL50.setMinimumSize(new Dimension(41, 45));
        this.JL50.setName("3");
        this.JL50.setPreferredSize(new Dimension(41, 45));
        this.JP13.add(this.JL50);
        this.JL50.setBounds(0, 0, 41, 45);
        this.JL51.setMaximumSize(new Dimension(41, 45));
        this.JL51.setMinimumSize(new Dimension(41, 45));
        this.JL51.setName("2");
        this.JL51.setPreferredSize(new Dimension(41, 45));
        this.JP13.add(this.JL51);
        this.JL51.setBounds(0, 0, 41, 45);
        this.JL52.setMaximumSize(new Dimension(41, 45));
        this.JL52.setMinimumSize(new Dimension(41, 45));
        this.JL52.setName("1");
        this.JL52.setPreferredSize(new Dimension(41, 45));
        this.JP13.add(this.JL52);
        this.JL52.setBounds(0, 0, 41, 45);
        this.JLDBlanco13.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/diente_blancoCP.png")));
        this.JLDBlanco13.setName("0");
        this.JP13.add(this.JLDBlanco13);
        this.JLDBlanco13.setBounds(0, 0, 41, 45);
        this.JPImOdontograma.add(this.JP13);
        this.JP13.setBounds(502, 27, 41, 45);
        this.jLabel14.setFont(new Font("Arial", 1, 12));
        this.jLabel14.setHorizontalAlignment(0);
        this.jLabel14.setText("13");
        this.JPImOdontograma.add(this.jLabel14);
        this.jLabel14.setBounds(502, 11, 41, 14);
        this.JP14.setMaximumSize(new Dimension(41, 45));
        this.JP14.setMinimumSize(new Dimension(41, 45));
        this.JP14.setName("14");
        this.JP14.setOpaque(false);
        this.JP14.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPControlPlaca.16
            public void mouseClicked(MouseEvent evt) {
                JPControlPlaca.this.JP14MouseClicked(evt);
            }
        });
        this.JP14.setLayout((LayoutManager) null);
        this.JL53.setMaximumSize(new Dimension(41, 45));
        this.JL53.setMinimumSize(new Dimension(41, 45));
        this.JL53.setName("4");
        this.JL53.setPreferredSize(new Dimension(41, 45));
        this.JP14.add(this.JL53);
        this.JL53.setBounds(0, 0, 41, 45);
        this.JL54.setMaximumSize(new Dimension(41, 45));
        this.JL54.setMinimumSize(new Dimension(41, 45));
        this.JL54.setName("3");
        this.JL54.setPreferredSize(new Dimension(41, 45));
        this.JP14.add(this.JL54);
        this.JL54.setBounds(0, 0, 41, 45);
        this.JL55.setMaximumSize(new Dimension(41, 45));
        this.JL55.setMinimumSize(new Dimension(41, 45));
        this.JL55.setName("2");
        this.JL55.setPreferredSize(new Dimension(41, 45));
        this.JP14.add(this.JL55);
        this.JL55.setBounds(0, 0, 41, 45);
        this.JL56.setMaximumSize(new Dimension(41, 45));
        this.JL56.setMinimumSize(new Dimension(41, 45));
        this.JL56.setName("1");
        this.JL56.setPreferredSize(new Dimension(41, 45));
        this.JP14.add(this.JL56);
        this.JL56.setBounds(0, 0, 41, 45);
        this.JLDBlanco14.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/diente_blancoCP.png")));
        this.JLDBlanco14.setName("0");
        this.JP14.add(this.JLDBlanco14);
        this.JLDBlanco14.setBounds(0, 0, 41, 45);
        this.JPImOdontograma.add(this.JP14);
        this.JP14.setBounds(543, 27, 41, 45);
        this.jLabel15.setFont(new Font("Arial", 1, 12));
        this.jLabel15.setHorizontalAlignment(0);
        this.jLabel15.setText("14");
        this.JPImOdontograma.add(this.jLabel15);
        this.jLabel15.setBounds(543, 11, 41, 14);
        this.JP15.setMaximumSize(new Dimension(41, 45));
        this.JP15.setMinimumSize(new Dimension(41, 45));
        this.JP15.setName("15");
        this.JP15.setOpaque(false);
        this.JP15.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPControlPlaca.17
            public void mouseClicked(MouseEvent evt) {
                JPControlPlaca.this.JP15MouseClicked(evt);
            }
        });
        this.JP15.setLayout((LayoutManager) null);
        this.JL57.setMaximumSize(new Dimension(41, 45));
        this.JL57.setMinimumSize(new Dimension(41, 45));
        this.JL57.setName("4");
        this.JL57.setPreferredSize(new Dimension(41, 45));
        this.JP15.add(this.JL57);
        this.JL57.setBounds(0, 0, 41, 45);
        this.JL58.setMaximumSize(new Dimension(41, 45));
        this.JL58.setMinimumSize(new Dimension(41, 45));
        this.JL58.setName("3");
        this.JL58.setPreferredSize(new Dimension(41, 45));
        this.JP15.add(this.JL58);
        this.JL58.setBounds(0, 0, 41, 45);
        this.JL59.setMaximumSize(new Dimension(41, 45));
        this.JL59.setMinimumSize(new Dimension(41, 45));
        this.JL59.setName("2");
        this.JL59.setPreferredSize(new Dimension(41, 45));
        this.JP15.add(this.JL59);
        this.JL59.setBounds(0, 0, 41, 45);
        this.JL60.setMaximumSize(new Dimension(41, 45));
        this.JL60.setMinimumSize(new Dimension(41, 45));
        this.JL60.setName("1");
        this.JL60.setPreferredSize(new Dimension(41, 45));
        this.JP15.add(this.JL60);
        this.JL60.setBounds(0, 0, 41, 45);
        this.JLDBlanco15.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/diente_blancoCP.png")));
        this.JLDBlanco15.setName("0");
        this.JP15.add(this.JLDBlanco15);
        this.JLDBlanco15.setBounds(0, 0, 41, 45);
        this.JPImOdontograma.add(this.JP15);
        this.JP15.setBounds(584, 27, 41, 45);
        this.jLabel16.setFont(new Font("Arial", 1, 12));
        this.jLabel16.setHorizontalAlignment(0);
        this.jLabel16.setText("15");
        this.JPImOdontograma.add(this.jLabel16);
        this.jLabel16.setBounds(584, 11, 41, 14);
        this.JP16.setMaximumSize(new Dimension(41, 45));
        this.JP16.setMinimumSize(new Dimension(41, 45));
        this.JP16.setName("16");
        this.JP16.setOpaque(false);
        this.JP16.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPControlPlaca.18
            public void mouseClicked(MouseEvent evt) {
                JPControlPlaca.this.JP16MouseClicked(evt);
            }
        });
        this.JP16.setLayout((LayoutManager) null);
        this.JL61.setMaximumSize(new Dimension(41, 45));
        this.JL61.setMinimumSize(new Dimension(41, 45));
        this.JL61.setName("4");
        this.JL61.setPreferredSize(new Dimension(41, 45));
        this.JP16.add(this.JL61);
        this.JL61.setBounds(0, 0, 41, 45);
        this.JL62.setMaximumSize(new Dimension(41, 45));
        this.JL62.setMinimumSize(new Dimension(41, 45));
        this.JL62.setName("3");
        this.JL62.setPreferredSize(new Dimension(41, 45));
        this.JP16.add(this.JL62);
        this.JL62.setBounds(0, 0, 41, 45);
        this.JL63.setMaximumSize(new Dimension(41, 45));
        this.JL63.setMinimumSize(new Dimension(41, 45));
        this.JL63.setName("2");
        this.JL63.setPreferredSize(new Dimension(41, 45));
        this.JP16.add(this.JL63);
        this.JL63.setBounds(0, 0, 41, 45);
        this.JL64.setMaximumSize(new Dimension(41, 45));
        this.JL64.setMinimumSize(new Dimension(41, 45));
        this.JL64.setName("1");
        this.JL64.setPreferredSize(new Dimension(41, 45));
        this.JP16.add(this.JL64);
        this.JL64.setBounds(0, 0, 41, 45);
        this.JLDBlanco16.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/diente_blancoCP.png")));
        this.JLDBlanco16.setName("0");
        this.JP16.add(this.JLDBlanco16);
        this.JLDBlanco16.setBounds(0, 0, 41, 45);
        this.JPImOdontograma.add(this.JP16);
        this.JP16.setBounds(625, 27, 41, 45);
        this.jLabel17.setFont(new Font("Arial", 1, 12));
        this.jLabel17.setHorizontalAlignment(0);
        this.jLabel17.setText("16");
        this.JPImOdontograma.add(this.jLabel17);
        this.jLabel17.setBounds(625, 11, 41, 14);
        this.jLabel18.setFont(new Font("Arial", 1, 12));
        this.jLabel18.setHorizontalAlignment(0);
        this.jLabel18.setText("17");
        this.JPImOdontograma.add(this.jLabel18);
        this.jLabel18.setBounds(625, 83, 41, 14);
        this.JP17.setMaximumSize(new Dimension(41, 45));
        this.JP17.setMinimumSize(new Dimension(41, 45));
        this.JP17.setName("17");
        this.JP17.setOpaque(false);
        this.JP17.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPControlPlaca.19
            public void mouseClicked(MouseEvent evt) {
                JPControlPlaca.this.JP17MouseClicked(evt);
            }
        });
        this.JP17.setLayout((LayoutManager) null);
        this.JL65.setMaximumSize(new Dimension(41, 45));
        this.JL65.setMinimumSize(new Dimension(41, 45));
        this.JL65.setName("4");
        this.JL65.setPreferredSize(new Dimension(41, 45));
        this.JP17.add(this.JL65);
        this.JL65.setBounds(0, 0, 41, 45);
        this.JL66.setMaximumSize(new Dimension(41, 45));
        this.JL66.setMinimumSize(new Dimension(41, 45));
        this.JL66.setName("3");
        this.JL66.setPreferredSize(new Dimension(41, 45));
        this.JP17.add(this.JL66);
        this.JL66.setBounds(0, 0, 41, 45);
        this.JL67.setMaximumSize(new Dimension(41, 45));
        this.JL67.setMinimumSize(new Dimension(41, 45));
        this.JL67.setName("2");
        this.JL67.setPreferredSize(new Dimension(41, 45));
        this.JP17.add(this.JL67);
        this.JL67.setBounds(0, 0, 41, 45);
        this.JL68.setMaximumSize(new Dimension(41, 45));
        this.JL68.setMinimumSize(new Dimension(41, 45));
        this.JL68.setName("1");
        this.JL68.setPreferredSize(new Dimension(41, 45));
        this.JP17.add(this.JL68);
        this.JL68.setBounds(0, 0, 41, 45);
        this.JLDBlanco17.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/diente_blancoCP.png")));
        this.JLDBlanco17.setName("0");
        this.JP17.add(this.JLDBlanco17);
        this.JLDBlanco17.setBounds(0, 0, 41, 45);
        this.JPImOdontograma.add(this.JP17);
        this.JP17.setBounds(625, 99, 41, 45);
        this.jLabel19.setFont(new Font("Arial", 1, 12));
        this.jLabel19.setHorizontalAlignment(0);
        this.jLabel19.setText("18");
        this.JPImOdontograma.add(this.jLabel19);
        this.jLabel19.setBounds(584, 83, 41, 14);
        this.JP18.setMaximumSize(new Dimension(41, 45));
        this.JP18.setMinimumSize(new Dimension(41, 45));
        this.JP18.setName("18");
        this.JP18.setOpaque(false);
        this.JP18.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPControlPlaca.20
            public void mouseClicked(MouseEvent evt) {
                JPControlPlaca.this.JP18MouseClicked(evt);
            }
        });
        this.JP18.setLayout((LayoutManager) null);
        this.JL69.setMaximumSize(new Dimension(41, 45));
        this.JL69.setMinimumSize(new Dimension(41, 45));
        this.JL69.setName("4");
        this.JL69.setPreferredSize(new Dimension(41, 45));
        this.JP18.add(this.JL69);
        this.JL69.setBounds(0, 0, 41, 45);
        this.JL70.setMaximumSize(new Dimension(41, 45));
        this.JL70.setMinimumSize(new Dimension(41, 45));
        this.JL70.setName("3");
        this.JL70.setPreferredSize(new Dimension(41, 45));
        this.JP18.add(this.JL70);
        this.JL70.setBounds(0, 0, 41, 45);
        this.JL71.setMaximumSize(new Dimension(41, 45));
        this.JL71.setMinimumSize(new Dimension(41, 45));
        this.JL71.setName("2");
        this.JL71.setPreferredSize(new Dimension(41, 45));
        this.JP18.add(this.JL71);
        this.JL71.setBounds(0, 0, 41, 45);
        this.JL72.setMaximumSize(new Dimension(41, 45));
        this.JL72.setMinimumSize(new Dimension(41, 45));
        this.JL72.setName("1");
        this.JL72.setPreferredSize(new Dimension(41, 45));
        this.JP18.add(this.JL72);
        this.JL72.setBounds(0, 0, 41, 45);
        this.JLDBlanco18.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/diente_blancoCP.png")));
        this.JLDBlanco18.setName("0");
        this.JP18.add(this.JLDBlanco18);
        this.JLDBlanco18.setBounds(0, 0, 41, 45);
        this.JPImOdontograma.add(this.JP18);
        this.JP18.setBounds(584, 99, 41, 45);
        this.jLabel20.setFont(new Font("Arial", 1, 12));
        this.jLabel20.setHorizontalAlignment(0);
        this.jLabel20.setText("19");
        this.JPImOdontograma.add(this.jLabel20);
        this.jLabel20.setBounds(543, 83, 41, 14);
        this.JP19.setMaximumSize(new Dimension(41, 45));
        this.JP19.setMinimumSize(new Dimension(41, 45));
        this.JP19.setName("19");
        this.JP19.setOpaque(false);
        this.JP19.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPControlPlaca.21
            public void mouseClicked(MouseEvent evt) {
                JPControlPlaca.this.JP19MouseClicked(evt);
            }
        });
        this.JP19.setLayout((LayoutManager) null);
        this.JL73.setMaximumSize(new Dimension(41, 45));
        this.JL73.setMinimumSize(new Dimension(41, 45));
        this.JL73.setName("4");
        this.JL73.setPreferredSize(new Dimension(41, 45));
        this.JP19.add(this.JL73);
        this.JL73.setBounds(0, 0, 41, 45);
        this.JL74.setMaximumSize(new Dimension(41, 45));
        this.JL74.setMinimumSize(new Dimension(41, 45));
        this.JL74.setName("3");
        this.JL74.setPreferredSize(new Dimension(41, 45));
        this.JP19.add(this.JL74);
        this.JL74.setBounds(0, 0, 41, 45);
        this.JL75.setMaximumSize(new Dimension(41, 45));
        this.JL75.setMinimumSize(new Dimension(41, 45));
        this.JL75.setName("2");
        this.JL75.setPreferredSize(new Dimension(41, 45));
        this.JP19.add(this.JL75);
        this.JL75.setBounds(0, 0, 41, 45);
        this.JL76.setMaximumSize(new Dimension(41, 45));
        this.JL76.setMinimumSize(new Dimension(41, 45));
        this.JL76.setName("1");
        this.JL76.setPreferredSize(new Dimension(41, 45));
        this.JP19.add(this.JL76);
        this.JL76.setBounds(0, 0, 41, 45);
        this.JLDBlanco19.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/diente_blancoCP.png")));
        this.JLDBlanco19.setName("0");
        this.JP19.add(this.JLDBlanco19);
        this.JLDBlanco19.setBounds(0, 0, 41, 45);
        this.JPImOdontograma.add(this.JP19);
        this.JP19.setBounds(543, 99, 41, 45);
        this.jLabel21.setFont(new Font("Arial", 1, 12));
        this.jLabel21.setHorizontalAlignment(0);
        this.jLabel21.setText("20");
        this.JPImOdontograma.add(this.jLabel21);
        this.jLabel21.setBounds(502, 83, 41, 14);
        this.JP20.setMaximumSize(new Dimension(41, 45));
        this.JP20.setMinimumSize(new Dimension(41, 45));
        this.JP20.setName("20");
        this.JP20.setOpaque(false);
        this.JP20.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPControlPlaca.22
            public void mouseClicked(MouseEvent evt) {
                JPControlPlaca.this.JP20MouseClicked(evt);
            }
        });
        this.JP20.setLayout((LayoutManager) null);
        this.JL77.setMaximumSize(new Dimension(41, 45));
        this.JL77.setMinimumSize(new Dimension(41, 45));
        this.JL77.setName("4");
        this.JL77.setPreferredSize(new Dimension(41, 45));
        this.JP20.add(this.JL77);
        this.JL77.setBounds(0, 0, 41, 45);
        this.JL78.setMaximumSize(new Dimension(41, 45));
        this.JL78.setMinimumSize(new Dimension(41, 45));
        this.JL78.setName("3");
        this.JL78.setPreferredSize(new Dimension(41, 45));
        this.JP20.add(this.JL78);
        this.JL78.setBounds(0, 0, 41, 45);
        this.JL79.setMaximumSize(new Dimension(41, 45));
        this.JL79.setMinimumSize(new Dimension(41, 45));
        this.JL79.setName("2");
        this.JL79.setPreferredSize(new Dimension(41, 45));
        this.JP20.add(this.JL79);
        this.JL79.setBounds(0, 0, 41, 45);
        this.JL80.setMaximumSize(new Dimension(41, 45));
        this.JL80.setMinimumSize(new Dimension(41, 45));
        this.JL80.setName("1");
        this.JL80.setPreferredSize(new Dimension(41, 45));
        this.JP20.add(this.JL80);
        this.JL80.setBounds(0, 0, 41, 45);
        this.JLDBlanco20.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/diente_blancoCP.png")));
        this.JLDBlanco20.setName("0");
        this.JP20.add(this.JLDBlanco20);
        this.JLDBlanco20.setBounds(0, 0, 41, 45);
        this.JPImOdontograma.add(this.JP20);
        this.JP20.setBounds(502, 99, 41, 45);
        this.jLabel22.setFont(new Font("Arial", 1, 12));
        this.jLabel22.setHorizontalAlignment(0);
        this.jLabel22.setText("21");
        this.JPImOdontograma.add(this.jLabel22);
        this.jLabel22.setBounds(461, 83, 41, 14);
        this.JP21.setMaximumSize(new Dimension(41, 45));
        this.JP21.setMinimumSize(new Dimension(41, 45));
        this.JP21.setName("21");
        this.JP21.setOpaque(false);
        this.JP21.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPControlPlaca.23
            public void mouseClicked(MouseEvent evt) {
                JPControlPlaca.this.JP21MouseClicked(evt);
            }
        });
        this.JP21.setLayout((LayoutManager) null);
        this.JL81.setMaximumSize(new Dimension(41, 45));
        this.JL81.setMinimumSize(new Dimension(41, 45));
        this.JL81.setName("4");
        this.JL81.setPreferredSize(new Dimension(41, 45));
        this.JP21.add(this.JL81);
        this.JL81.setBounds(0, 0, 41, 45);
        this.JL82.setMaximumSize(new Dimension(41, 45));
        this.JL82.setMinimumSize(new Dimension(41, 45));
        this.JL82.setName("3");
        this.JL82.setPreferredSize(new Dimension(41, 45));
        this.JP21.add(this.JL82);
        this.JL82.setBounds(0, 0, 41, 45);
        this.JL83.setMaximumSize(new Dimension(41, 45));
        this.JL83.setMinimumSize(new Dimension(41, 45));
        this.JL83.setName("2");
        this.JL83.setPreferredSize(new Dimension(41, 45));
        this.JP21.add(this.JL83);
        this.JL83.setBounds(0, 0, 41, 45);
        this.JL84.setMaximumSize(new Dimension(41, 45));
        this.JL84.setMinimumSize(new Dimension(41, 45));
        this.JL84.setName("1");
        this.JL84.setPreferredSize(new Dimension(41, 45));
        this.JP21.add(this.JL84);
        this.JL84.setBounds(0, 0, 41, 45);
        this.JLDBlanco21.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/diente_blancoCP.png")));
        this.JLDBlanco21.setName("0");
        this.JP21.add(this.JLDBlanco21);
        this.JLDBlanco21.setBounds(0, 0, 41, 45);
        this.JPImOdontograma.add(this.JP21);
        this.JP21.setBounds(461, 99, 41, 45);
        this.jLabel23.setFont(new Font("Arial", 1, 12));
        this.jLabel23.setHorizontalAlignment(0);
        this.jLabel23.setText("22");
        this.JPImOdontograma.add(this.jLabel23);
        this.jLabel23.setBounds(420, 83, 41, 14);
        this.JP22.setMaximumSize(new Dimension(41, 45));
        this.JP22.setMinimumSize(new Dimension(41, 45));
        this.JP22.setName("22");
        this.JP22.setOpaque(false);
        this.JP22.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPControlPlaca.24
            public void mouseClicked(MouseEvent evt) {
                JPControlPlaca.this.JP22MouseClicked(evt);
            }
        });
        this.JP22.setLayout((LayoutManager) null);
        this.JL85.setMaximumSize(new Dimension(41, 45));
        this.JL85.setMinimumSize(new Dimension(41, 45));
        this.JL85.setName("4");
        this.JL85.setPreferredSize(new Dimension(41, 45));
        this.JP22.add(this.JL85);
        this.JL85.setBounds(0, 0, 41, 45);
        this.JL86.setMaximumSize(new Dimension(41, 45));
        this.JL86.setMinimumSize(new Dimension(41, 45));
        this.JL86.setName("3");
        this.JL86.setPreferredSize(new Dimension(41, 45));
        this.JP22.add(this.JL86);
        this.JL86.setBounds(0, 0, 41, 45);
        this.JL87.setMaximumSize(new Dimension(41, 45));
        this.JL87.setMinimumSize(new Dimension(41, 45));
        this.JL87.setName("2");
        this.JL87.setPreferredSize(new Dimension(41, 45));
        this.JP22.add(this.JL87);
        this.JL87.setBounds(0, 0, 41, 45);
        this.JL88.setMaximumSize(new Dimension(41, 45));
        this.JL88.setMinimumSize(new Dimension(41, 45));
        this.JL88.setName("1");
        this.JL88.setPreferredSize(new Dimension(41, 45));
        this.JP22.add(this.JL88);
        this.JL88.setBounds(0, 0, 41, 45);
        this.JLDBlanco22.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/diente_blancoCP.png")));
        this.JLDBlanco22.setName("0");
        this.JP22.add(this.JLDBlanco22);
        this.JLDBlanco22.setBounds(0, 0, 41, 45);
        this.JPImOdontograma.add(this.JP22);
        this.JP22.setBounds(420, 99, 41, 45);
        this.jLabel24.setFont(new Font("Arial", 1, 12));
        this.jLabel24.setHorizontalAlignment(0);
        this.jLabel24.setText("23");
        this.JPImOdontograma.add(this.jLabel24);
        this.jLabel24.setBounds(379, 83, 41, 14);
        this.JP23.setMaximumSize(new Dimension(41, 45));
        this.JP23.setMinimumSize(new Dimension(41, 45));
        this.JP23.setName("23");
        this.JP23.setOpaque(false);
        this.JP23.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPControlPlaca.25
            public void mouseClicked(MouseEvent evt) {
                JPControlPlaca.this.JP23MouseClicked(evt);
            }
        });
        this.JP23.setLayout((LayoutManager) null);
        this.JL89.setMaximumSize(new Dimension(41, 45));
        this.JL89.setMinimumSize(new Dimension(41, 45));
        this.JL89.setName("4");
        this.JL89.setPreferredSize(new Dimension(41, 45));
        this.JP23.add(this.JL89);
        this.JL89.setBounds(0, 0, 41, 45);
        this.JL90.setMaximumSize(new Dimension(41, 45));
        this.JL90.setMinimumSize(new Dimension(41, 45));
        this.JL90.setName("3");
        this.JL90.setPreferredSize(new Dimension(41, 45));
        this.JP23.add(this.JL90);
        this.JL90.setBounds(0, 0, 41, 45);
        this.JL91.setMaximumSize(new Dimension(41, 45));
        this.JL91.setMinimumSize(new Dimension(41, 45));
        this.JL91.setName("2");
        this.JL91.setPreferredSize(new Dimension(41, 45));
        this.JP23.add(this.JL91);
        this.JL91.setBounds(0, 0, 41, 45);
        this.JL92.setMaximumSize(new Dimension(41, 45));
        this.JL92.setMinimumSize(new Dimension(41, 45));
        this.JL92.setName("1");
        this.JL92.setPreferredSize(new Dimension(41, 45));
        this.JP23.add(this.JL92);
        this.JL92.setBounds(0, 0, 41, 45);
        this.JLDBlanco23.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/diente_blancoCP.png")));
        this.JLDBlanco23.setName("0");
        this.JP23.add(this.JLDBlanco23);
        this.JLDBlanco23.setBounds(0, 0, 41, 45);
        this.JPImOdontograma.add(this.JP23);
        this.JP23.setBounds(379, 99, 41, 45);
        this.jLabel25.setFont(new Font("Arial", 1, 12));
        this.jLabel25.setHorizontalAlignment(0);
        this.jLabel25.setText("24");
        this.JPImOdontograma.add(this.jLabel25);
        this.jLabel25.setBounds(338, 83, 41, 14);
        this.JP24.setMaximumSize(new Dimension(41, 45));
        this.JP24.setMinimumSize(new Dimension(41, 45));
        this.JP24.setName("24");
        this.JP24.setOpaque(false);
        this.JP24.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPControlPlaca.26
            public void mouseClicked(MouseEvent evt) {
                JPControlPlaca.this.JP24MouseClicked(evt);
            }
        });
        this.JP24.setLayout((LayoutManager) null);
        this.JL93.setMaximumSize(new Dimension(41, 45));
        this.JL93.setMinimumSize(new Dimension(41, 45));
        this.JL93.setName("4");
        this.JL93.setPreferredSize(new Dimension(41, 45));
        this.JP24.add(this.JL93);
        this.JL93.setBounds(0, 0, 41, 45);
        this.JL94.setMaximumSize(new Dimension(41, 45));
        this.JL94.setMinimumSize(new Dimension(41, 45));
        this.JL94.setName("3");
        this.JL94.setPreferredSize(new Dimension(41, 45));
        this.JP24.add(this.JL94);
        this.JL94.setBounds(0, 0, 41, 45);
        this.JL95.setMaximumSize(new Dimension(41, 45));
        this.JL95.setMinimumSize(new Dimension(41, 45));
        this.JL95.setName("2");
        this.JL95.setPreferredSize(new Dimension(41, 45));
        this.JP24.add(this.JL95);
        this.JL95.setBounds(0, 0, 41, 45);
        this.JL96.setMaximumSize(new Dimension(41, 45));
        this.JL96.setMinimumSize(new Dimension(41, 45));
        this.JL96.setName("1");
        this.JL96.setPreferredSize(new Dimension(41, 45));
        this.JP24.add(this.JL96);
        this.JL96.setBounds(0, 0, 41, 45);
        this.JLDBlanco24.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/diente_blancoCP.png")));
        this.JLDBlanco24.setName("0");
        this.JP24.add(this.JLDBlanco24);
        this.JLDBlanco24.setBounds(0, 0, 41, 45);
        this.JPImOdontograma.add(this.JP24);
        this.JP24.setBounds(338, 99, 41, 45);
        this.jLabel26.setFont(new Font("Arial", 1, 12));
        this.jLabel26.setHorizontalAlignment(0);
        this.jLabel26.setText("25");
        this.JPImOdontograma.add(this.jLabel26);
        this.jLabel26.setBounds(297, 83, 41, 14);
        this.JP25.setMaximumSize(new Dimension(41, 45));
        this.JP25.setMinimumSize(new Dimension(41, 45));
        this.JP25.setName("25");
        this.JP25.setOpaque(false);
        this.JP25.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPControlPlaca.27
            public void mouseClicked(MouseEvent evt) {
                JPControlPlaca.this.JP25MouseClicked(evt);
            }
        });
        this.JP25.setLayout((LayoutManager) null);
        this.JL97.setMaximumSize(new Dimension(41, 45));
        this.JL97.setMinimumSize(new Dimension(41, 45));
        this.JL97.setName("4");
        this.JL97.setPreferredSize(new Dimension(41, 45));
        this.JP25.add(this.JL97);
        this.JL97.setBounds(0, 0, 41, 45);
        this.JL98.setMaximumSize(new Dimension(41, 45));
        this.JL98.setMinimumSize(new Dimension(41, 45));
        this.JL98.setName("3");
        this.JL98.setPreferredSize(new Dimension(41, 45));
        this.JP25.add(this.JL98);
        this.JL98.setBounds(0, 0, 41, 45);
        this.JL99.setMaximumSize(new Dimension(41, 45));
        this.JL99.setMinimumSize(new Dimension(41, 45));
        this.JL99.setName("2");
        this.JL99.setPreferredSize(new Dimension(41, 45));
        this.JP25.add(this.JL99);
        this.JL99.setBounds(0, 0, 41, 45);
        this.JL100.setMaximumSize(new Dimension(41, 45));
        this.JL100.setMinimumSize(new Dimension(41, 45));
        this.JL100.setName("1");
        this.JL100.setPreferredSize(new Dimension(41, 45));
        this.JP25.add(this.JL100);
        this.JL100.setBounds(0, 0, 41, 45);
        this.JLDBlanco25.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/diente_blancoCP.png")));
        this.JLDBlanco25.setName("0");
        this.JP25.add(this.JLDBlanco25);
        this.JLDBlanco25.setBounds(0, 0, 41, 45);
        this.JPImOdontograma.add(this.JP25);
        this.JP25.setBounds(297, 99, 41, 45);
        this.jLabel27.setFont(new Font("Arial", 1, 12));
        this.jLabel27.setHorizontalAlignment(0);
        this.jLabel27.setText("26");
        this.JPImOdontograma.add(this.jLabel27);
        this.jLabel27.setBounds(256, 83, 41, 14);
        this.JP26.setMaximumSize(new Dimension(41, 45));
        this.JP26.setMinimumSize(new Dimension(41, 45));
        this.JP26.setName("26");
        this.JP26.setOpaque(false);
        this.JP26.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPControlPlaca.28
            public void mouseClicked(MouseEvent evt) {
                JPControlPlaca.this.JP26MouseClicked(evt);
            }
        });
        this.JP26.setLayout((LayoutManager) null);
        this.JL101.setMaximumSize(new Dimension(41, 45));
        this.JL101.setMinimumSize(new Dimension(41, 45));
        this.JL101.setName("4");
        this.JL101.setPreferredSize(new Dimension(41, 45));
        this.JP26.add(this.JL101);
        this.JL101.setBounds(0, 0, 41, 45);
        this.JL102.setMaximumSize(new Dimension(41, 45));
        this.JL102.setMinimumSize(new Dimension(41, 45));
        this.JL102.setName("3");
        this.JL102.setPreferredSize(new Dimension(41, 45));
        this.JP26.add(this.JL102);
        this.JL102.setBounds(0, 0, 41, 45);
        this.JL103.setMaximumSize(new Dimension(41, 45));
        this.JL103.setMinimumSize(new Dimension(41, 45));
        this.JL103.setName("2");
        this.JL103.setPreferredSize(new Dimension(41, 45));
        this.JP26.add(this.JL103);
        this.JL103.setBounds(0, 0, 41, 45);
        this.JL104.setMaximumSize(new Dimension(41, 45));
        this.JL104.setMinimumSize(new Dimension(41, 45));
        this.JL104.setName("1");
        this.JL104.setPreferredSize(new Dimension(41, 45));
        this.JP26.add(this.JL104);
        this.JL104.setBounds(0, 0, 41, 45);
        this.JLDBlanco26.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/diente_blancoCP.png")));
        this.JLDBlanco26.setName("0");
        this.JP26.add(this.JLDBlanco26);
        this.JLDBlanco26.setBounds(0, 0, 41, 45);
        this.JPImOdontograma.add(this.JP26);
        this.JP26.setBounds(256, 99, 41, 45);
        this.jLabel28.setFont(new Font("Arial", 1, 12));
        this.jLabel28.setHorizontalAlignment(0);
        this.jLabel28.setText("27");
        this.JPImOdontograma.add(this.jLabel28);
        this.jLabel28.setBounds(215, 83, 41, 14);
        this.JP27.setMaximumSize(new Dimension(41, 45));
        this.JP27.setMinimumSize(new Dimension(41, 45));
        this.JP27.setName("27");
        this.JP27.setOpaque(false);
        this.JP27.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPControlPlaca.29
            public void mouseClicked(MouseEvent evt) {
                JPControlPlaca.this.JP27MouseClicked(evt);
            }
        });
        this.JP27.setLayout((LayoutManager) null);
        this.JL105.setMaximumSize(new Dimension(41, 45));
        this.JL105.setMinimumSize(new Dimension(41, 45));
        this.JL105.setName("4");
        this.JL105.setPreferredSize(new Dimension(41, 45));
        this.JP27.add(this.JL105);
        this.JL105.setBounds(0, 0, 41, 45);
        this.JL106.setMaximumSize(new Dimension(41, 45));
        this.JL106.setMinimumSize(new Dimension(41, 45));
        this.JL106.setName("3");
        this.JL106.setPreferredSize(new Dimension(41, 45));
        this.JP27.add(this.JL106);
        this.JL106.setBounds(0, 0, 41, 45);
        this.JL107.setMaximumSize(new Dimension(41, 45));
        this.JL107.setMinimumSize(new Dimension(41, 45));
        this.JL107.setName("2");
        this.JL107.setPreferredSize(new Dimension(41, 45));
        this.JP27.add(this.JL107);
        this.JL107.setBounds(0, 0, 41, 45);
        this.JL108.setMaximumSize(new Dimension(41, 45));
        this.JL108.setMinimumSize(new Dimension(41, 45));
        this.JL108.setName("1");
        this.JL108.setPreferredSize(new Dimension(41, 45));
        this.JP27.add(this.JL108);
        this.JL108.setBounds(0, 0, 41, 45);
        this.JLDBlanco27.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/diente_blancoCP.png")));
        this.JLDBlanco27.setName("0");
        this.JP27.add(this.JLDBlanco27);
        this.JLDBlanco27.setBounds(0, 0, 41, 45);
        this.JPImOdontograma.add(this.JP27);
        this.JP27.setBounds(215, 99, 41, 45);
        this.jLabel29.setFont(new Font("Arial", 1, 12));
        this.jLabel29.setHorizontalAlignment(0);
        this.jLabel29.setText("28");
        this.JPImOdontograma.add(this.jLabel29);
        this.jLabel29.setBounds(174, 83, 41, 14);
        this.JP28.setMaximumSize(new Dimension(41, 45));
        this.JP28.setMinimumSize(new Dimension(41, 45));
        this.JP28.setName("28");
        this.JP28.setOpaque(false);
        this.JP28.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPControlPlaca.30
            public void mouseClicked(MouseEvent evt) {
                JPControlPlaca.this.JP28MouseClicked(evt);
            }
        });
        this.JP28.setLayout((LayoutManager) null);
        this.JL109.setMaximumSize(new Dimension(41, 45));
        this.JL109.setMinimumSize(new Dimension(41, 45));
        this.JL109.setName("4");
        this.JL109.setPreferredSize(new Dimension(41, 45));
        this.JP28.add(this.JL109);
        this.JL109.setBounds(0, 0, 41, 45);
        this.JL110.setMaximumSize(new Dimension(41, 45));
        this.JL110.setMinimumSize(new Dimension(41, 45));
        this.JL110.setName("3");
        this.JL110.setPreferredSize(new Dimension(41, 45));
        this.JP28.add(this.JL110);
        this.JL110.setBounds(0, 0, 41, 45);
        this.JL111.setMaximumSize(new Dimension(41, 45));
        this.JL111.setMinimumSize(new Dimension(41, 45));
        this.JL111.setName("2");
        this.JL111.setPreferredSize(new Dimension(41, 45));
        this.JP28.add(this.JL111);
        this.JL111.setBounds(0, 0, 41, 45);
        this.JL112.setMaximumSize(new Dimension(41, 45));
        this.JL112.setMinimumSize(new Dimension(41, 45));
        this.JL112.setName("1");
        this.JL112.setPreferredSize(new Dimension(41, 45));
        this.JP28.add(this.JL112);
        this.JL112.setBounds(0, 0, 41, 45);
        this.JLDBlanco28.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/diente_blancoCP.png")));
        this.JLDBlanco28.setName("0");
        this.JP28.add(this.JLDBlanco28);
        this.JLDBlanco28.setBounds(0, 0, 41, 45);
        this.JPImOdontograma.add(this.JP28);
        this.JP28.setBounds(174, 99, 41, 45);
        this.jLabel30.setFont(new Font("Arial", 1, 12));
        this.jLabel30.setHorizontalAlignment(0);
        this.jLabel30.setText("29");
        this.JPImOdontograma.add(this.jLabel30);
        this.jLabel30.setBounds(133, 83, 41, 14);
        this.JP29.setMaximumSize(new Dimension(41, 45));
        this.JP29.setMinimumSize(new Dimension(41, 45));
        this.JP29.setName("29");
        this.JP29.setOpaque(false);
        this.JP29.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPControlPlaca.31
            public void mouseClicked(MouseEvent evt) {
                JPControlPlaca.this.JP29MouseClicked(evt);
            }
        });
        this.JP29.setLayout((LayoutManager) null);
        this.JL113.setMaximumSize(new Dimension(41, 45));
        this.JL113.setMinimumSize(new Dimension(41, 45));
        this.JL113.setName("4");
        this.JL113.setPreferredSize(new Dimension(41, 45));
        this.JP29.add(this.JL113);
        this.JL113.setBounds(0, 0, 41, 45);
        this.JL114.setMaximumSize(new Dimension(41, 45));
        this.JL114.setMinimumSize(new Dimension(41, 45));
        this.JL114.setName("3");
        this.JL114.setPreferredSize(new Dimension(41, 45));
        this.JP29.add(this.JL114);
        this.JL114.setBounds(0, 0, 41, 45);
        this.JL115.setMaximumSize(new Dimension(41, 45));
        this.JL115.setMinimumSize(new Dimension(41, 45));
        this.JL115.setName("2");
        this.JL115.setPreferredSize(new Dimension(41, 45));
        this.JP29.add(this.JL115);
        this.JL115.setBounds(0, 0, 41, 45);
        this.JL116.setMaximumSize(new Dimension(41, 45));
        this.JL116.setMinimumSize(new Dimension(41, 45));
        this.JL116.setName("1");
        this.JL116.setPreferredSize(new Dimension(41, 45));
        this.JP29.add(this.JL116);
        this.JL116.setBounds(0, 0, 41, 45);
        this.JLDBlanco29.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/diente_blancoCP.png")));
        this.JLDBlanco29.setName("0");
        this.JP29.add(this.JLDBlanco29);
        this.JLDBlanco29.setBounds(0, 0, 41, 45);
        this.JPImOdontograma.add(this.JP29);
        this.JP29.setBounds(133, 99, 41, 45);
        this.jLabel31.setFont(new Font("Arial", 1, 12));
        this.jLabel31.setHorizontalAlignment(0);
        this.jLabel31.setText("30");
        this.JPImOdontograma.add(this.jLabel31);
        this.jLabel31.setBounds(92, 83, 41, 14);
        this.JP30.setMaximumSize(new Dimension(41, 45));
        this.JP30.setMinimumSize(new Dimension(41, 45));
        this.JP30.setName("30");
        this.JP30.setOpaque(false);
        this.JP30.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPControlPlaca.32
            public void mouseClicked(MouseEvent evt) {
                JPControlPlaca.this.JP30MouseClicked(evt);
            }
        });
        this.JP30.setLayout((LayoutManager) null);
        this.JL117.setMaximumSize(new Dimension(41, 45));
        this.JL117.setMinimumSize(new Dimension(41, 45));
        this.JL117.setName("4");
        this.JL117.setPreferredSize(new Dimension(41, 45));
        this.JP30.add(this.JL117);
        this.JL117.setBounds(0, 0, 41, 45);
        this.JL118.setMaximumSize(new Dimension(41, 45));
        this.JL118.setMinimumSize(new Dimension(41, 45));
        this.JL118.setName("3");
        this.JL118.setPreferredSize(new Dimension(41, 45));
        this.JP30.add(this.JL118);
        this.JL118.setBounds(0, 0, 41, 45);
        this.JL119.setMaximumSize(new Dimension(41, 45));
        this.JL119.setMinimumSize(new Dimension(41, 45));
        this.JL119.setName("2");
        this.JL119.setPreferredSize(new Dimension(41, 45));
        this.JP30.add(this.JL119);
        this.JL119.setBounds(0, 0, 41, 45);
        this.JL120.setMaximumSize(new Dimension(41, 45));
        this.JL120.setMinimumSize(new Dimension(41, 45));
        this.JL120.setName("1");
        this.JL120.setPreferredSize(new Dimension(41, 45));
        this.JP30.add(this.JL120);
        this.JL120.setBounds(0, 0, 41, 45);
        this.JLDBlanco30.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/diente_blancoCP.png")));
        this.JLDBlanco30.setName("0");
        this.JP30.add(this.JLDBlanco30);
        this.JLDBlanco30.setBounds(0, 0, 41, 45);
        this.JPImOdontograma.add(this.JP30);
        this.JP30.setBounds(92, 99, 41, 45);
        this.jLabel32.setFont(new Font("Arial", 1, 12));
        this.jLabel32.setHorizontalAlignment(0);
        this.jLabel32.setText("31");
        this.JPImOdontograma.add(this.jLabel32);
        this.jLabel32.setBounds(51, 83, 41, 14);
        this.JP31.setMaximumSize(new Dimension(41, 45));
        this.JP31.setMinimumSize(new Dimension(41, 45));
        this.JP31.setName("31");
        this.JP31.setOpaque(false);
        this.JP31.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPControlPlaca.33
            public void mouseClicked(MouseEvent evt) {
                JPControlPlaca.this.JP31MouseClicked(evt);
            }
        });
        this.JP31.setLayout((LayoutManager) null);
        this.JL121.setMaximumSize(new Dimension(41, 45));
        this.JL121.setMinimumSize(new Dimension(41, 45));
        this.JL121.setName("4");
        this.JL121.setPreferredSize(new Dimension(41, 45));
        this.JP31.add(this.JL121);
        this.JL121.setBounds(0, 0, 41, 45);
        this.JL122.setMaximumSize(new Dimension(41, 45));
        this.JL122.setMinimumSize(new Dimension(41, 45));
        this.JL122.setName("3");
        this.JL122.setPreferredSize(new Dimension(41, 45));
        this.JP31.add(this.JL122);
        this.JL122.setBounds(0, 0, 41, 45);
        this.JL123.setMaximumSize(new Dimension(41, 45));
        this.JL123.setMinimumSize(new Dimension(41, 45));
        this.JL123.setName("2");
        this.JL123.setPreferredSize(new Dimension(41, 45));
        this.JP31.add(this.JL123);
        this.JL123.setBounds(0, 0, 41, 45);
        this.JL124.setMaximumSize(new Dimension(41, 45));
        this.JL124.setMinimumSize(new Dimension(41, 45));
        this.JL124.setName("1");
        this.JL124.setPreferredSize(new Dimension(41, 45));
        this.JP31.add(this.JL124);
        this.JL124.setBounds(0, 0, 41, 45);
        this.JLDBlanco31.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/diente_blancoCP.png")));
        this.JLDBlanco31.setName("0");
        this.JP31.add(this.JLDBlanco31);
        this.JLDBlanco31.setBounds(0, 0, 41, 45);
        this.JPImOdontograma.add(this.JP31);
        this.JP31.setBounds(51, 99, 41, 45);
        this.jLabel33.setFont(new Font("Arial", 1, 12));
        this.jLabel33.setHorizontalAlignment(0);
        this.jLabel33.setText("32");
        this.JPImOdontograma.add(this.jLabel33);
        this.jLabel33.setBounds(10, 83, 41, 14);
        this.JP32.setMaximumSize(new Dimension(41, 45));
        this.JP32.setMinimumSize(new Dimension(41, 45));
        this.JP32.setName("32");
        this.JP32.setOpaque(false);
        this.JP32.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPControlPlaca.34
            public void mouseClicked(MouseEvent evt) {
                JPControlPlaca.this.JP32MouseClicked(evt);
            }
        });
        this.JP32.setLayout((LayoutManager) null);
        this.JL125.setMaximumSize(new Dimension(41, 45));
        this.JL125.setMinimumSize(new Dimension(41, 45));
        this.JL125.setName("4");
        this.JL125.setPreferredSize(new Dimension(41, 45));
        this.JP32.add(this.JL125);
        this.JL125.setBounds(0, 0, 41, 45);
        this.JL126.setMaximumSize(new Dimension(41, 45));
        this.JL126.setMinimumSize(new Dimension(41, 45));
        this.JL126.setName("3");
        this.JL126.setPreferredSize(new Dimension(41, 45));
        this.JP32.add(this.JL126);
        this.JL126.setBounds(0, 0, 41, 45);
        this.JL127.setMaximumSize(new Dimension(41, 45));
        this.JL127.setMinimumSize(new Dimension(41, 45));
        this.JL127.setName("2");
        this.JL127.setPreferredSize(new Dimension(41, 45));
        this.JP32.add(this.JL127);
        this.JL127.setBounds(0, 0, 41, 45);
        this.JL128.setMaximumSize(new Dimension(41, 45));
        this.JL128.setMinimumSize(new Dimension(41, 45));
        this.JL128.setName("1");
        this.JL128.setPreferredSize(new Dimension(41, 45));
        this.JP32.add(this.JL128);
        this.JL128.setBounds(0, 0, 41, 45);
        this.JLDBlanco32.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/diente_blancoCP.png")));
        this.JLDBlanco32.setName("0");
        this.JP32.add(this.JLDBlanco32);
        this.JLDBlanco32.setBounds(0, 0, 41, 45);
        this.JPImOdontograma.add(this.JP32);
        this.JP32.setBounds(10, 99, 41, 45);
        this.JLabelMargen.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/Arqueadas.png")));
        this.JPImOdontograma.add(this.JLabelMargen);
        this.JLabelMargen.setBounds(0, 0, 680, 174);
        this.JCBProcedimiento.setFont(new Font("Arial", 1, 12));
        this.JCBProcedimiento.setBorder(BorderFactory.createTitledBorder((Border) null, "Procedimientos", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JBTAdicionar.setFont(new Font("Arial", 1, 12));
        this.JBTAdicionar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTAdicionar.setText("Agregar");
        this.JBTAdicionar.addActionListener(new ActionListener() { // from class: Odontologia.JPControlPlaca.35
            public void actionPerformed(ActionEvent evt) {
                JPControlPlaca.this.JBTAdicionarActionPerformed(evt);
            }
        });
        this.JTAObservacionDx.setColumns(1);
        this.JTAObservacionDx.setLineWrap(true);
        this.JTAObservacionDx.setRows(1);
        this.JTAObservacionDx.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.jScrollPane1.setViewportView(this.JTAObservacionDx);
        this.JLIndiceOleary.setFont(new Font("Arial", 1, 18));
        this.JLIndiceOleary.setForeground(new Color(255, 0, 0));
        this.JLIndiceOleary.setHorizontalAlignment(0);
        this.JLIndiceOleary.setText("0");
        this.JLIndiceOleary.setBorder(BorderFactory.createTitledBorder((Border) null, "Índice Olear'y", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JLCarasPlaca.setFont(new Font("Arial", 1, 18));
        this.JLCarasPlaca.setForeground(new Color(255, 0, 0));
        this.JLCarasPlaca.setHorizontalAlignment(0);
        this.JLCarasPlaca.setText("0");
        this.JLCarasPlaca.setBorder(BorderFactory.createTitledBorder((Border) null, "Superficies Teñidas", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JLCarasMarcadas.setFont(new Font("Arial", 1, 18));
        this.JLCarasMarcadas.setForeground(new Color(255, 0, 0));
        this.JLCarasMarcadas.setHorizontalAlignment(0);
        this.JLCarasMarcadas.setText("0");
        this.JLCarasMarcadas.setBorder(BorderFactory.createTitledBorder((Border) null, "Superficies no aplican", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JLPresentes.setFont(new Font("Arial", 1, 18));
        this.JLPresentes.setForeground(new Color(255, 0, 0));
        this.JLPresentes.setHorizontalAlignment(0);
        this.JLPresentes.setText("128");
        this.JLPresentes.setBorder(BorderFactory.createTitledBorder((Border) null, "Superficies Presentes", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JSPProcedimiento.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE DE PROCEDIMIENTOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 0, 255)));
        this.JTProcedimiento.setFont(new Font("Arial", 1, 12));
        this.JTProcedimiento.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTProcedimiento.setSelectionBackground(new Color(255, 255, 255));
        this.JTProcedimiento.setSelectionForeground(new Color(255, 0, 0));
        this.JTProcedimiento.addKeyListener(new KeyAdapter() { // from class: Odontologia.JPControlPlaca.36
            public void keyPressed(KeyEvent evt) {
                JPControlPlaca.this.JTProcedimientoKeyPressed(evt);
            }
        });
        this.JSPProcedimiento.setViewportView(this.JTProcedimiento);
        this.JTFFCantidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Cant.", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFCantidad.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.JTFFCantidad.setHorizontalAlignment(4);
        this.JTFFCantidad.setFont(new Font("Arial", 1, 12));
        GroupLayout JPOdontogramaILayout = new GroupLayout(this.JPOdontogramaI);
        this.JPOdontogramaI.setLayout(JPOdontogramaILayout);
        JPOdontogramaILayout.setHorizontalGroup(JPOdontogramaILayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPOdontogramaILayout.createSequentialGroup().addContainerGap().addGroup(JPOdontogramaILayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPOdontogramaILayout.createSequentialGroup().addGroup(JPOdontogramaILayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPOdontogramaILayout.createSequentialGroup().addComponent(this.JLCarasPlaca, -2, 133, -2).addGap(10, 10, 10).addComponent(this.JLCarasMarcadas, -2, 162, -2).addGap(10, 10, 10).addComponent(this.JLPresentes, -2, 155, -2).addGap(10, 10, 10).addComponent(this.JLIndiceOleary, -2, 135, -2)).addComponent(this.JPImOdontograma, -2, 678, -2).addGroup(JPOdontogramaILayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.jScrollPane1, GroupLayout.Alignment.LEADING).addComponent(this.JSPProcedimiento, GroupLayout.Alignment.LEADING, -1, 654, 32767).addComponent(this.JBTAdicionar, GroupLayout.Alignment.LEADING, -1, -1, 32767))).addContainerGap(-1, 32767)).addGroup(JPOdontogramaILayout.createSequentialGroup().addGroup(JPOdontogramaILayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JSPDetalleO, GroupLayout.Alignment.LEADING).addGroup(JPOdontogramaILayout.createSequentialGroup().addComponent(this.JCBProcedimiento, -2, 548, -2).addGap(18, 18, 18).addComponent(this.JTFFCantidad, -2, 86, -2))).addGap(0, 0, 32767)))));
        JPOdontogramaILayout.setVerticalGroup(JPOdontogramaILayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPOdontogramaILayout.createSequentialGroup().addContainerGap().addComponent(this.JPImOdontograma, -2, 168, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalleO, -2, 104, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPOdontogramaILayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLCarasPlaca, -2, 52, -2).addGroup(JPOdontogramaILayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JLPresentes, -2, 52, -2).addComponent(this.JLCarasMarcadas, -2, 52, -2).addComponent(this.JLIndiceOleary, -2, 52, -2))).addGap(4, 4, 4).addGroup(JPOdontogramaILayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBProcedimiento, -2, 42, -2).addComponent(this.JTFFCantidad, -2, 42, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JBTAdicionar).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPProcedimiento, -2, 75, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane1, -2, -1, -2).addGap(85, 85, 85)));
        this.JTPDatos.addTab("CONTROL PLACA", this.JPOdontogramaI);
        this.JTPNotas.setForeground(new Color(0, 103, 0));
        this.JTPNotas.setFont(new Font("Arial", 1, 14));
        this.JDCFecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFecha.setDateFormatString("dd/MM/yyyy");
        this.JDCFecha.setFont(new Font("Arial", 1, 12));
        this.JTFFHora.setBorder(BorderFactory.createTitledBorder((Border) null, "Hora", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFHora.setFormatterFactory(new DefaultFormatterFactory(new DateFormatter(new SimpleDateFormat("HH:mm:ss"))));
        this.JTFFHora.setHorizontalAlignment(4);
        this.JTFFHora.setFont(new Font("Arial", 1, 12));
        this.JCBTipoNota.setFont(new Font("Arial", 1, 12));
        this.JCBTipoNota.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Nota", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPNota.setBorder(BorderFactory.createTitledBorder((Border) null, "NOTAS ODONTOLÓGICAS", 2, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.JTANota.setFont(new Font("Arial", 1, 12));
        this.JTANota.setLineWrap(true);
        this.JTANota.setRows(1);
        this.JTANota.setTabSize(1);
        this.JTANota.setBorder((Border) null);
        this.JSPNota.setViewportView(this.JTANota);
        GroupLayout JPInformacionNotasLayout = new GroupLayout(this.JPInformacionNotas);
        this.JPInformacionNotas.setLayout(JPInformacionNotasLayout);
        JPInformacionNotasLayout.setHorizontalGroup(JPInformacionNotasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPInformacionNotasLayout.createSequentialGroup().addContainerGap().addGroup(JPInformacionNotasLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSPNota).addGroup(JPInformacionNotasLayout.createSequentialGroup().addComponent(this.JDCFecha, -2, 143, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JTFFHora, -2, 119, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBTipoNota, -2, 347, -2))).addGap(41, 41, 41)));
        JPInformacionNotasLayout.setVerticalGroup(JPInformacionNotasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPInformacionNotasLayout.createSequentialGroup().addContainerGap().addGroup(JPInformacionNotasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPInformacionNotasLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFHora, -2, 50, -2).addComponent(this.JCBTipoNota, -2, 50, -2)).addComponent(this.JDCFecha, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPNota, -1, 445, 32767).addContainerGap()));
        this.JTPNotas.addTab("iNFORMACION", this.JPInformacionNotas);
        this.JTHistoricoNotas.setFont(new Font("Arial", 1, 12));
        this.JTHistoricoNotas.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTHistoricoNotas.setSelectionBackground(Color.white);
        this.JTHistoricoNotas.setSelectionForeground(Color.red);
        this.JTHistoricoNotas.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPControlPlaca.37
            public void mouseClicked(MouseEvent evt) {
                JPControlPlaca.this.JTHistoricoNotasMouseClicked(evt);
            }
        });
        this.JSPHistoricoNotas.setViewportView(this.JTHistoricoNotas);
        this.JTPNotas.addTab("HISTORICO DE NOTAS", this.JSPHistoricoNotas);
        GroupLayout JPNotasLayout = new GroupLayout(this.JPNotas);
        this.JPNotas.setLayout(JPNotasLayout);
        JPNotasLayout.setHorizontalGroup(JPNotasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPNotasLayout.createSequentialGroup().addContainerGap().addComponent(this.JTPNotas, -2, 660, -2).addContainerGap(-1, 32767)));
        JPNotasLayout.setVerticalGroup(JPNotasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPNotasLayout.createSequentialGroup().addContainerGap().addComponent(this.JTPNotas).addContainerGap()));
        this.JTPDatos.addTab("NOTAS", this.JPNotas);
        this.JSPHistorico.setBorder(BorderFactory.createTitledBorder((Border) null, "", 2, 0, new Font("Arial", 1, 14), new Color(0, 0, 255)));
        this.JTHistorico.setFont(new Font("Arial", 1, 12));
        this.JTHistorico.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTHistorico.setSelectionBackground(new Color(255, 255, 255));
        this.JTHistorico.setSelectionForeground(new Color(255, 0, 0));
        this.JTHistorico.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPControlPlaca.38
            public void mouseClicked(MouseEvent evt) {
                JPControlPlaca.this.JTHistoricoMouseClicked(evt);
            }
        });
        this.JSPHistorico.setViewportView(this.JTHistorico);
        this.JLCarasPlacaH.setFont(new Font("Arial", 1, 18));
        this.JLCarasPlacaH.setForeground(new Color(255, 0, 0));
        this.JLCarasPlacaH.setHorizontalAlignment(0);
        this.JLCarasPlacaH.setText("0");
        this.JLCarasPlacaH.setBorder(BorderFactory.createTitledBorder((Border) null, "Superficies Teñidas", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JLCarasMarcadasH.setFont(new Font("Arial", 1, 18));
        this.JLCarasMarcadasH.setForeground(new Color(255, 0, 0));
        this.JLCarasMarcadasH.setHorizontalAlignment(0);
        this.JLCarasMarcadasH.setText("0");
        this.JLCarasMarcadasH.setBorder(BorderFactory.createTitledBorder((Border) null, "Superficies no aplican", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JLPresentesH.setFont(new Font("Arial", 1, 18));
        this.JLPresentesH.setForeground(new Color(255, 0, 0));
        this.JLPresentesH.setHorizontalAlignment(0);
        this.JLPresentesH.setText("128");
        this.JLPresentesH.setBorder(BorderFactory.createTitledBorder((Border) null, "Superficies Presentes", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JLIndiceOlearyH.setFont(new Font("Arial", 1, 18));
        this.JLIndiceOlearyH.setForeground(new Color(255, 0, 0));
        this.JLIndiceOlearyH.setHorizontalAlignment(0);
        this.JLIndiceOlearyH.setText("0");
        this.JLIndiceOlearyH.setBorder(BorderFactory.createTitledBorder((Border) null, "Índice Olear'y", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JSPProcedimientoH.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE DE PROCEDIMIENTOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 0, 255)));
        this.JTProcedimientoH.setFont(new Font("Arial", 1, 12));
        this.JTProcedimientoH.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTProcedimientoH.setSelectionBackground(new Color(255, 255, 255));
        this.JTProcedimientoH.setSelectionForeground(new Color(255, 0, 0));
        this.JTProcedimientoH.addKeyListener(new KeyAdapter() { // from class: Odontologia.JPControlPlaca.39
            public void keyPressed(KeyEvent evt) {
                JPControlPlaca.this.JTProcedimientoHKeyPressed(evt);
            }
        });
        this.JSPProcedimientoH.setViewportView(this.JTProcedimientoH);
        this.JPImOdontogramaHistorico.setBackground(new Color(255, 255, 255));
        this.JP33.setMaximumSize(new Dimension(41, 45));
        this.JP33.setMinimumSize(new Dimension(41, 45));
        this.JP33.setName("1");
        this.JP33.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPControlPlaca.40
            public void mouseClicked(MouseEvent evt) {
                JPControlPlaca.this.JP33MouseClicked(evt);
            }
        });
        this.JP33.setLayout((LayoutManager) null);
        this.JL129.setMaximumSize(new Dimension(41, 45));
        this.JL129.setMinimumSize(new Dimension(41, 45));
        this.JL129.setName("4");
        this.JL129.setPreferredSize(new Dimension(41, 45));
        this.JP33.add(this.JL129);
        this.JL129.setBounds(0, 0, 41, 45);
        this.JL130.setMaximumSize(new Dimension(41, 45));
        this.JL130.setMinimumSize(new Dimension(41, 45));
        this.JL130.setName("3");
        this.JL130.setPreferredSize(new Dimension(41, 45));
        this.JP33.add(this.JL130);
        this.JL130.setBounds(0, 0, 41, 45);
        this.JL131.setMaximumSize(new Dimension(41, 45));
        this.JL131.setMinimumSize(new Dimension(41, 45));
        this.JL131.setName("2");
        this.JL131.setPreferredSize(new Dimension(41, 45));
        this.JP33.add(this.JL131);
        this.JL131.setBounds(0, 0, 41, 45);
        this.JL132.setMaximumSize(new Dimension(41, 45));
        this.JL132.setMinimumSize(new Dimension(41, 45));
        this.JL132.setName("1");
        this.JL132.setPreferredSize(new Dimension(41, 45));
        this.JP33.add(this.JL132);
        this.JL132.setBounds(0, 0, 41, 45);
        this.JLDBlanco33.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/diente_blancoCP.png")));
        this.JLDBlanco33.setName("0");
        this.JP33.add(this.JLDBlanco33);
        this.JLDBlanco33.setBounds(0, 0, 41, 45);
        this.jLabel34.setFont(new Font("Arial", 1, 12));
        this.jLabel34.setHorizontalAlignment(0);
        this.jLabel34.setText("1");
        this.JP34.setMaximumSize(new Dimension(41, 45));
        this.JP34.setMinimumSize(new Dimension(41, 45));
        this.JP34.setName("2");
        this.JP34.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPControlPlaca.41
            public void mouseClicked(MouseEvent evt) {
                JPControlPlaca.this.JP34MouseClicked(evt);
            }
        });
        this.JP34.setLayout((LayoutManager) null);
        this.JL133.setMaximumSize(new Dimension(41, 45));
        this.JL133.setMinimumSize(new Dimension(41, 45));
        this.JL133.setName("4");
        this.JL133.setPreferredSize(new Dimension(41, 45));
        this.JP34.add(this.JL133);
        this.JL133.setBounds(0, 0, 41, 45);
        this.JL134.setMaximumSize(new Dimension(41, 45));
        this.JL134.setMinimumSize(new Dimension(41, 45));
        this.JL134.setName("3");
        this.JL134.setPreferredSize(new Dimension(41, 45));
        this.JP34.add(this.JL134);
        this.JL134.setBounds(0, 0, 41, 45);
        this.JL135.setMaximumSize(new Dimension(41, 45));
        this.JL135.setMinimumSize(new Dimension(41, 45));
        this.JL135.setName("2");
        this.JL135.setPreferredSize(new Dimension(41, 45));
        this.JP34.add(this.JL135);
        this.JL135.setBounds(0, 0, 41, 45);
        this.JL136.setMaximumSize(new Dimension(41, 45));
        this.JL136.setMinimumSize(new Dimension(41, 45));
        this.JL136.setName("1");
        this.JL136.setPreferredSize(new Dimension(41, 45));
        this.JP34.add(this.JL136);
        this.JL136.setBounds(0, 0, 41, 45);
        this.JLDBlanco34.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/diente_blancoCP.png")));
        this.JLDBlanco34.setName("0");
        this.JP34.add(this.JLDBlanco34);
        this.JLDBlanco34.setBounds(0, 0, 41, 45);
        this.jLabel35.setFont(new Font("Arial", 1, 12));
        this.jLabel35.setHorizontalAlignment(0);
        this.jLabel35.setText("2");
        this.JP35.setMaximumSize(new Dimension(41, 45));
        this.JP35.setMinimumSize(new Dimension(41, 45));
        this.JP35.setName("3");
        this.JP35.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPControlPlaca.42
            public void mouseClicked(MouseEvent evt) {
                JPControlPlaca.this.JP35MouseClicked(evt);
            }
        });
        this.JP35.setLayout((LayoutManager) null);
        this.JL137.setMaximumSize(new Dimension(41, 45));
        this.JL137.setMinimumSize(new Dimension(41, 45));
        this.JL137.setName("4");
        this.JL137.setPreferredSize(new Dimension(41, 45));
        this.JP35.add(this.JL137);
        this.JL137.setBounds(0, 0, 41, 45);
        this.JL138.setMaximumSize(new Dimension(41, 45));
        this.JL138.setMinimumSize(new Dimension(41, 45));
        this.JL138.setName("3");
        this.JL138.setPreferredSize(new Dimension(41, 45));
        this.JP35.add(this.JL138);
        this.JL138.setBounds(0, 0, 41, 45);
        this.JL139.setMaximumSize(new Dimension(41, 45));
        this.JL139.setMinimumSize(new Dimension(41, 45));
        this.JL139.setName("2");
        this.JL139.setPreferredSize(new Dimension(41, 45));
        this.JP35.add(this.JL139);
        this.JL139.setBounds(0, 0, 41, 45);
        this.JL140.setMaximumSize(new Dimension(41, 45));
        this.JL140.setMinimumSize(new Dimension(41, 45));
        this.JL140.setName("1");
        this.JL140.setPreferredSize(new Dimension(41, 45));
        this.JP35.add(this.JL140);
        this.JL140.setBounds(0, 0, 41, 45);
        this.JLDBlanco35.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/diente_blancoCP.png")));
        this.JLDBlanco35.setName("0");
        this.JP35.add(this.JLDBlanco35);
        this.JLDBlanco35.setBounds(0, 0, 41, 45);
        this.jLabel36.setFont(new Font("Arial", 1, 12));
        this.jLabel36.setHorizontalAlignment(0);
        this.jLabel36.setText("3");
        this.JP36.setMaximumSize(new Dimension(41, 45));
        this.JP36.setMinimumSize(new Dimension(41, 45));
        this.JP36.setName("4");
        this.JP36.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPControlPlaca.43
            public void mouseClicked(MouseEvent evt) {
                JPControlPlaca.this.JP36MouseClicked(evt);
            }
        });
        this.JP36.setLayout((LayoutManager) null);
        this.JL141.setMaximumSize(new Dimension(41, 45));
        this.JL141.setMinimumSize(new Dimension(41, 45));
        this.JL141.setName("4");
        this.JL141.setPreferredSize(new Dimension(41, 45));
        this.JP36.add(this.JL141);
        this.JL141.setBounds(0, 0, 41, 45);
        this.JL142.setMaximumSize(new Dimension(41, 45));
        this.JL142.setMinimumSize(new Dimension(41, 45));
        this.JL142.setName("3");
        this.JL142.setPreferredSize(new Dimension(41, 45));
        this.JP36.add(this.JL142);
        this.JL142.setBounds(0, 0, 41, 45);
        this.JL143.setMaximumSize(new Dimension(41, 45));
        this.JL143.setMinimumSize(new Dimension(41, 45));
        this.JL143.setName("2");
        this.JL143.setPreferredSize(new Dimension(41, 45));
        this.JP36.add(this.JL143);
        this.JL143.setBounds(0, 0, 41, 45);
        this.JL144.setMaximumSize(new Dimension(41, 45));
        this.JL144.setMinimumSize(new Dimension(41, 45));
        this.JL144.setName("1");
        this.JL144.setPreferredSize(new Dimension(41, 45));
        this.JP36.add(this.JL144);
        this.JL144.setBounds(0, 0, 41, 45);
        this.JLDBlanco36.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/diente_blancoCP.png")));
        this.JLDBlanco36.setName("0");
        this.JP36.add(this.JLDBlanco36);
        this.JLDBlanco36.setBounds(0, 0, 41, 45);
        this.jLabel37.setFont(new Font("Arial", 1, 12));
        this.jLabel37.setHorizontalAlignment(0);
        this.jLabel37.setText("4");
        this.JP37.setMaximumSize(new Dimension(41, 45));
        this.JP37.setMinimumSize(new Dimension(41, 45));
        this.JP37.setName("5");
        this.JP37.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPControlPlaca.44
            public void mouseClicked(MouseEvent evt) {
                JPControlPlaca.this.JP37MouseClicked(evt);
            }
        });
        this.JP37.setLayout((LayoutManager) null);
        this.JL145.setMaximumSize(new Dimension(41, 45));
        this.JL145.setMinimumSize(new Dimension(41, 45));
        this.JL145.setName("4");
        this.JL145.setPreferredSize(new Dimension(41, 45));
        this.JP37.add(this.JL145);
        this.JL145.setBounds(0, 0, 41, 45);
        this.JL146.setMaximumSize(new Dimension(41, 45));
        this.JL146.setMinimumSize(new Dimension(41, 45));
        this.JL146.setName("3");
        this.JL146.setPreferredSize(new Dimension(41, 45));
        this.JP37.add(this.JL146);
        this.JL146.setBounds(0, 0, 41, 45);
        this.JL147.setMaximumSize(new Dimension(41, 45));
        this.JL147.setMinimumSize(new Dimension(41, 45));
        this.JL147.setName("2");
        this.JL147.setPreferredSize(new Dimension(41, 45));
        this.JP37.add(this.JL147);
        this.JL147.setBounds(0, 0, 41, 45);
        this.JL148.setMaximumSize(new Dimension(41, 45));
        this.JL148.setMinimumSize(new Dimension(41, 45));
        this.JL148.setName("1");
        this.JL148.setPreferredSize(new Dimension(41, 45));
        this.JP37.add(this.JL148);
        this.JL148.setBounds(0, 0, 41, 45);
        this.JLDBlanco37.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/diente_blancoCP.png")));
        this.JLDBlanco37.setName("0");
        this.JP37.add(this.JLDBlanco37);
        this.JLDBlanco37.setBounds(0, 0, 41, 45);
        this.jLabel38.setFont(new Font("Arial", 1, 12));
        this.jLabel38.setHorizontalAlignment(0);
        this.jLabel38.setText("5");
        this.JP38.setMaximumSize(new Dimension(41, 45));
        this.JP38.setMinimumSize(new Dimension(41, 45));
        this.JP38.setName("6");
        this.JP38.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPControlPlaca.45
            public void mouseClicked(MouseEvent evt) {
                JPControlPlaca.this.JP38MouseClicked(evt);
            }
        });
        this.JP38.setLayout((LayoutManager) null);
        this.JL149.setMaximumSize(new Dimension(41, 45));
        this.JL149.setMinimumSize(new Dimension(41, 45));
        this.JL149.setName("4");
        this.JL149.setPreferredSize(new Dimension(41, 45));
        this.JP38.add(this.JL149);
        this.JL149.setBounds(0, 0, 41, 45);
        this.JL150.setMaximumSize(new Dimension(41, 45));
        this.JL150.setMinimumSize(new Dimension(41, 45));
        this.JL150.setName("3");
        this.JL150.setPreferredSize(new Dimension(41, 45));
        this.JP38.add(this.JL150);
        this.JL150.setBounds(0, 0, 41, 45);
        this.JL151.setMaximumSize(new Dimension(41, 45));
        this.JL151.setMinimumSize(new Dimension(41, 45));
        this.JL151.setName("2");
        this.JL151.setPreferredSize(new Dimension(41, 45));
        this.JP38.add(this.JL151);
        this.JL151.setBounds(0, 0, 41, 45);
        this.JL152.setMaximumSize(new Dimension(41, 45));
        this.JL152.setMinimumSize(new Dimension(41, 45));
        this.JL152.setName("1");
        this.JL152.setPreferredSize(new Dimension(41, 45));
        this.JP38.add(this.JL152);
        this.JL152.setBounds(0, 0, 41, 45);
        this.JLDBlanco38.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/diente_blancoCP.png")));
        this.JLDBlanco38.setName("0");
        this.JP38.add(this.JLDBlanco38);
        this.JLDBlanco38.setBounds(0, 0, 41, 45);
        this.jLabel39.setFont(new Font("Arial", 1, 12));
        this.jLabel39.setHorizontalAlignment(0);
        this.jLabel39.setText("6");
        this.JP39.setMaximumSize(new Dimension(41, 45));
        this.JP39.setMinimumSize(new Dimension(41, 45));
        this.JP39.setName("7");
        this.JP39.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPControlPlaca.46
            public void mouseClicked(MouseEvent evt) {
                JPControlPlaca.this.JP39MouseClicked(evt);
            }
        });
        this.JP39.setLayout((LayoutManager) null);
        this.JL153.setMaximumSize(new Dimension(41, 45));
        this.JL153.setMinimumSize(new Dimension(41, 45));
        this.JL153.setName("4");
        this.JL153.setPreferredSize(new Dimension(41, 45));
        this.JP39.add(this.JL153);
        this.JL153.setBounds(0, 0, 41, 45);
        this.JL154.setMaximumSize(new Dimension(41, 45));
        this.JL154.setMinimumSize(new Dimension(41, 45));
        this.JL154.setName("3");
        this.JL154.setPreferredSize(new Dimension(41, 45));
        this.JP39.add(this.JL154);
        this.JL154.setBounds(0, 0, 41, 45);
        this.JL155.setMaximumSize(new Dimension(41, 45));
        this.JL155.setMinimumSize(new Dimension(41, 45));
        this.JL155.setName("2");
        this.JL155.setPreferredSize(new Dimension(41, 45));
        this.JP39.add(this.JL155);
        this.JL155.setBounds(0, 0, 41, 45);
        this.JL156.setMaximumSize(new Dimension(41, 45));
        this.JL156.setMinimumSize(new Dimension(41, 45));
        this.JL156.setName("1");
        this.JL156.setPreferredSize(new Dimension(41, 45));
        this.JP39.add(this.JL156);
        this.JL156.setBounds(0, 0, 41, 45);
        this.JLDBlanco39.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/diente_blancoCP.png")));
        this.JLDBlanco39.setName("0");
        this.JP39.add(this.JLDBlanco39);
        this.JLDBlanco39.setBounds(0, 0, 41, 45);
        this.jLabel40.setFont(new Font("Arial", 1, 12));
        this.jLabel40.setHorizontalAlignment(0);
        this.jLabel40.setText("7");
        this.JP40.setMaximumSize(new Dimension(41, 45));
        this.JP40.setMinimumSize(new Dimension(41, 45));
        this.JP40.setName("8");
        this.JP40.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPControlPlaca.47
            public void mouseClicked(MouseEvent evt) {
                JPControlPlaca.this.JP40MouseClicked(evt);
            }
        });
        this.JP40.setLayout((LayoutManager) null);
        this.JL157.setMaximumSize(new Dimension(41, 45));
        this.JL157.setMinimumSize(new Dimension(41, 45));
        this.JL157.setName("4");
        this.JL157.setPreferredSize(new Dimension(41, 45));
        this.JP40.add(this.JL157);
        this.JL157.setBounds(0, 0, 41, 45);
        this.JL158.setMaximumSize(new Dimension(41, 45));
        this.JL158.setMinimumSize(new Dimension(41, 45));
        this.JL158.setName("3");
        this.JL158.setPreferredSize(new Dimension(41, 45));
        this.JP40.add(this.JL158);
        this.JL158.setBounds(0, 0, 41, 45);
        this.JL159.setMaximumSize(new Dimension(41, 45));
        this.JL159.setMinimumSize(new Dimension(41, 45));
        this.JL159.setName("2");
        this.JL159.setPreferredSize(new Dimension(41, 45));
        this.JP40.add(this.JL159);
        this.JL159.setBounds(0, 0, 41, 45);
        this.JL160.setMaximumSize(new Dimension(41, 45));
        this.JL160.setMinimumSize(new Dimension(41, 45));
        this.JL160.setName("1");
        this.JL160.setPreferredSize(new Dimension(41, 45));
        this.JP40.add(this.JL160);
        this.JL160.setBounds(0, 0, 41, 45);
        this.JLDBlanco40.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/diente_blancoCP.png")));
        this.JLDBlanco40.setName("0");
        this.JP40.add(this.JLDBlanco40);
        this.JLDBlanco40.setBounds(0, 0, 41, 45);
        this.jLabel41.setFont(new Font("Arial", 1, 12));
        this.jLabel41.setHorizontalAlignment(0);
        this.jLabel41.setText("8");
        this.JP41.setMaximumSize(new Dimension(41, 45));
        this.JP41.setMinimumSize(new Dimension(41, 45));
        this.JP41.setName("9");
        this.JP41.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPControlPlaca.48
            public void mouseClicked(MouseEvent evt) {
                JPControlPlaca.this.JP41MouseClicked(evt);
            }
        });
        this.JP41.setLayout((LayoutManager) null);
        this.JL161.setMaximumSize(new Dimension(41, 45));
        this.JL161.setMinimumSize(new Dimension(41, 45));
        this.JL161.setName("4");
        this.JL161.setPreferredSize(new Dimension(41, 45));
        this.JP41.add(this.JL161);
        this.JL161.setBounds(0, 0, 41, 45);
        this.JL162.setMaximumSize(new Dimension(41, 45));
        this.JL162.setMinimumSize(new Dimension(41, 45));
        this.JL162.setName("3");
        this.JL162.setPreferredSize(new Dimension(41, 45));
        this.JP41.add(this.JL162);
        this.JL162.setBounds(0, 0, 41, 45);
        this.JL163.setMaximumSize(new Dimension(41, 45));
        this.JL163.setMinimumSize(new Dimension(41, 45));
        this.JL163.setName("2");
        this.JL163.setPreferredSize(new Dimension(41, 45));
        this.JP41.add(this.JL163);
        this.JL163.setBounds(0, 0, 41, 45);
        this.JL164.setMaximumSize(new Dimension(41, 45));
        this.JL164.setMinimumSize(new Dimension(41, 45));
        this.JL164.setName("1");
        this.JL164.setPreferredSize(new Dimension(41, 45));
        this.JP41.add(this.JL164);
        this.JL164.setBounds(0, 0, 41, 45);
        this.JLDBlanco41.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/diente_blancoCP.png")));
        this.JLDBlanco41.setName("0");
        this.JP41.add(this.JLDBlanco41);
        this.JLDBlanco41.setBounds(0, 0, 41, 45);
        this.jLabel42.setFont(new Font("Arial", 1, 12));
        this.jLabel42.setHorizontalAlignment(0);
        this.jLabel42.setText("9");
        this.JP42.setMaximumSize(new Dimension(41, 45));
        this.JP42.setMinimumSize(new Dimension(41, 45));
        this.JP42.setName("10");
        this.JP42.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPControlPlaca.49
            public void mouseClicked(MouseEvent evt) {
                JPControlPlaca.this.JP42MouseClicked(evt);
            }
        });
        this.JP42.setLayout((LayoutManager) null);
        this.JL165.setMaximumSize(new Dimension(41, 45));
        this.JL165.setMinimumSize(new Dimension(41, 45));
        this.JL165.setName("4");
        this.JL165.setPreferredSize(new Dimension(41, 45));
        this.JP42.add(this.JL165);
        this.JL165.setBounds(0, 0, 41, 45);
        this.JL166.setMaximumSize(new Dimension(41, 45));
        this.JL166.setMinimumSize(new Dimension(41, 45));
        this.JL166.setName("3");
        this.JL166.setPreferredSize(new Dimension(41, 45));
        this.JP42.add(this.JL166);
        this.JL166.setBounds(0, 0, 41, 45);
        this.JL167.setMaximumSize(new Dimension(41, 45));
        this.JL167.setMinimumSize(new Dimension(41, 45));
        this.JL167.setName("2");
        this.JL167.setPreferredSize(new Dimension(41, 45));
        this.JP42.add(this.JL167);
        this.JL167.setBounds(0, 0, 41, 45);
        this.JL168.setMaximumSize(new Dimension(41, 45));
        this.JL168.setMinimumSize(new Dimension(41, 45));
        this.JL168.setName("1");
        this.JL168.setPreferredSize(new Dimension(41, 45));
        this.JP42.add(this.JL168);
        this.JL168.setBounds(0, 0, 41, 45);
        this.JLDBlanco42.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/diente_blancoCP.png")));
        this.JLDBlanco42.setName("0");
        this.JP42.add(this.JLDBlanco42);
        this.JLDBlanco42.setBounds(0, 0, 41, 45);
        this.jLabel43.setFont(new Font("Arial", 1, 12));
        this.jLabel43.setHorizontalAlignment(0);
        this.jLabel43.setText("10");
        this.JP43.setMaximumSize(new Dimension(41, 45));
        this.JP43.setMinimumSize(new Dimension(41, 45));
        this.JP43.setName("11");
        this.JP43.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPControlPlaca.50
            public void mouseClicked(MouseEvent evt) {
                JPControlPlaca.this.JP43MouseClicked(evt);
            }
        });
        this.JP43.setLayout((LayoutManager) null);
        this.JL169.setMaximumSize(new Dimension(41, 45));
        this.JL169.setMinimumSize(new Dimension(41, 45));
        this.JL169.setName("4");
        this.JL169.setPreferredSize(new Dimension(41, 45));
        this.JP43.add(this.JL169);
        this.JL169.setBounds(0, 0, 41, 45);
        this.JL170.setMaximumSize(new Dimension(41, 45));
        this.JL170.setMinimumSize(new Dimension(41, 45));
        this.JL170.setName("3");
        this.JL170.setPreferredSize(new Dimension(41, 45));
        this.JP43.add(this.JL170);
        this.JL170.setBounds(0, 0, 41, 45);
        this.JL171.setMaximumSize(new Dimension(41, 45));
        this.JL171.setMinimumSize(new Dimension(41, 45));
        this.JL171.setName("2");
        this.JL171.setPreferredSize(new Dimension(41, 45));
        this.JP43.add(this.JL171);
        this.JL171.setBounds(0, 0, 41, 45);
        this.JL172.setMaximumSize(new Dimension(41, 45));
        this.JL172.setMinimumSize(new Dimension(41, 45));
        this.JL172.setName("1");
        this.JL172.setPreferredSize(new Dimension(41, 45));
        this.JP43.add(this.JL172);
        this.JL172.setBounds(0, 0, 41, 45);
        this.JLDBlanco43.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/diente_blancoCP.png")));
        this.JLDBlanco43.setName("0");
        this.JP43.add(this.JLDBlanco43);
        this.JLDBlanco43.setBounds(0, 0, 41, 45);
        this.jLabel44.setFont(new Font("Arial", 1, 12));
        this.jLabel44.setHorizontalAlignment(0);
        this.jLabel44.setText("11");
        this.JP44.setMaximumSize(new Dimension(41, 45));
        this.JP44.setMinimumSize(new Dimension(41, 45));
        this.JP44.setName("12");
        this.JP44.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPControlPlaca.51
            public void mouseClicked(MouseEvent evt) {
                JPControlPlaca.this.JP44MouseClicked(evt);
            }
        });
        this.JP44.setLayout((LayoutManager) null);
        this.JL173.setMaximumSize(new Dimension(41, 45));
        this.JL173.setMinimumSize(new Dimension(41, 45));
        this.JL173.setName("4");
        this.JL173.setPreferredSize(new Dimension(41, 45));
        this.JP44.add(this.JL173);
        this.JL173.setBounds(0, 0, 41, 45);
        this.JL174.setMaximumSize(new Dimension(41, 45));
        this.JL174.setMinimumSize(new Dimension(41, 45));
        this.JL174.setName("3");
        this.JL174.setPreferredSize(new Dimension(41, 45));
        this.JP44.add(this.JL174);
        this.JL174.setBounds(0, 0, 41, 45);
        this.JL175.setMaximumSize(new Dimension(41, 45));
        this.JL175.setMinimumSize(new Dimension(41, 45));
        this.JL175.setName("2");
        this.JL175.setPreferredSize(new Dimension(41, 45));
        this.JP44.add(this.JL175);
        this.JL175.setBounds(0, 0, 41, 45);
        this.JL176.setMaximumSize(new Dimension(41, 45));
        this.JL176.setMinimumSize(new Dimension(41, 45));
        this.JL176.setName("1");
        this.JL176.setPreferredSize(new Dimension(41, 45));
        this.JP44.add(this.JL176);
        this.JL176.setBounds(0, 0, 41, 45);
        this.JLDBlanco44.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/diente_blancoCP.png")));
        this.JLDBlanco44.setName("0");
        this.JP44.add(this.JLDBlanco44);
        this.JLDBlanco44.setBounds(0, 0, 41, 45);
        this.jLabel45.setFont(new Font("Arial", 1, 12));
        this.jLabel45.setHorizontalAlignment(0);
        this.jLabel45.setText("12");
        this.JP45.setMaximumSize(new Dimension(41, 45));
        this.JP45.setMinimumSize(new Dimension(41, 45));
        this.JP45.setName("13");
        this.JP45.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPControlPlaca.52
            public void mouseClicked(MouseEvent evt) {
                JPControlPlaca.this.JP45MouseClicked(evt);
            }
        });
        this.JP45.setLayout((LayoutManager) null);
        this.JL177.setMaximumSize(new Dimension(41, 45));
        this.JL177.setMinimumSize(new Dimension(41, 45));
        this.JL177.setName("4");
        this.JL177.setPreferredSize(new Dimension(41, 45));
        this.JP45.add(this.JL177);
        this.JL177.setBounds(0, 0, 41, 45);
        this.JL178.setMaximumSize(new Dimension(41, 45));
        this.JL178.setMinimumSize(new Dimension(41, 45));
        this.JL178.setName("3");
        this.JL178.setPreferredSize(new Dimension(41, 45));
        this.JP45.add(this.JL178);
        this.JL178.setBounds(0, 0, 41, 45);
        this.JL179.setMaximumSize(new Dimension(41, 45));
        this.JL179.setMinimumSize(new Dimension(41, 45));
        this.JL179.setName("2");
        this.JL179.setPreferredSize(new Dimension(41, 45));
        this.JP45.add(this.JL179);
        this.JL179.setBounds(0, 0, 41, 45);
        this.JL180.setMaximumSize(new Dimension(41, 45));
        this.JL180.setMinimumSize(new Dimension(41, 45));
        this.JL180.setName("1");
        this.JL180.setPreferredSize(new Dimension(41, 45));
        this.JP45.add(this.JL180);
        this.JL180.setBounds(0, 0, 41, 45);
        this.JLDBlanco45.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/diente_blancoCP.png")));
        this.JLDBlanco45.setName("0");
        this.JP45.add(this.JLDBlanco45);
        this.JLDBlanco45.setBounds(0, 0, 41, 45);
        this.jLabel46.setFont(new Font("Arial", 1, 12));
        this.jLabel46.setHorizontalAlignment(0);
        this.jLabel46.setText("13");
        this.JP46.setMaximumSize(new Dimension(41, 45));
        this.JP46.setMinimumSize(new Dimension(41, 45));
        this.JP46.setName("14");
        this.JP46.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPControlPlaca.53
            public void mouseClicked(MouseEvent evt) {
                JPControlPlaca.this.JP46MouseClicked(evt);
            }
        });
        this.JP46.setLayout((LayoutManager) null);
        this.JL181.setMaximumSize(new Dimension(41, 45));
        this.JL181.setMinimumSize(new Dimension(41, 45));
        this.JL181.setName("4");
        this.JL181.setPreferredSize(new Dimension(41, 45));
        this.JP46.add(this.JL181);
        this.JL181.setBounds(0, 0, 41, 45);
        this.JL182.setMaximumSize(new Dimension(41, 45));
        this.JL182.setMinimumSize(new Dimension(41, 45));
        this.JL182.setName("3");
        this.JL182.setPreferredSize(new Dimension(41, 45));
        this.JP46.add(this.JL182);
        this.JL182.setBounds(0, 0, 41, 45);
        this.JL183.setMaximumSize(new Dimension(41, 45));
        this.JL183.setMinimumSize(new Dimension(41, 45));
        this.JL183.setName("2");
        this.JL183.setPreferredSize(new Dimension(41, 45));
        this.JP46.add(this.JL183);
        this.JL183.setBounds(0, 0, 41, 45);
        this.JL184.setMaximumSize(new Dimension(41, 45));
        this.JL184.setMinimumSize(new Dimension(41, 45));
        this.JL184.setName("1");
        this.JL184.setPreferredSize(new Dimension(41, 45));
        this.JP46.add(this.JL184);
        this.JL184.setBounds(0, 0, 41, 45);
        this.JLDBlanco46.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/diente_blancoCP.png")));
        this.JLDBlanco46.setName("0");
        this.JP46.add(this.JLDBlanco46);
        this.JLDBlanco46.setBounds(0, 0, 41, 45);
        this.jLabel47.setFont(new Font("Arial", 1, 12));
        this.jLabel47.setHorizontalAlignment(0);
        this.jLabel47.setText("14");
        this.JP47.setMaximumSize(new Dimension(41, 45));
        this.JP47.setMinimumSize(new Dimension(41, 45));
        this.JP47.setName("15");
        this.JP47.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPControlPlaca.54
            public void mouseClicked(MouseEvent evt) {
                JPControlPlaca.this.JP47MouseClicked(evt);
            }
        });
        this.JP47.setLayout((LayoutManager) null);
        this.JL185.setMaximumSize(new Dimension(41, 45));
        this.JL185.setMinimumSize(new Dimension(41, 45));
        this.JL185.setName("4");
        this.JL185.setPreferredSize(new Dimension(41, 45));
        this.JP47.add(this.JL185);
        this.JL185.setBounds(0, 0, 41, 45);
        this.JL186.setMaximumSize(new Dimension(41, 45));
        this.JL186.setMinimumSize(new Dimension(41, 45));
        this.JL186.setName("3");
        this.JL186.setPreferredSize(new Dimension(41, 45));
        this.JP47.add(this.JL186);
        this.JL186.setBounds(0, 0, 41, 45);
        this.JL187.setMaximumSize(new Dimension(41, 45));
        this.JL187.setMinimumSize(new Dimension(41, 45));
        this.JL187.setName("2");
        this.JL187.setPreferredSize(new Dimension(41, 45));
        this.JP47.add(this.JL187);
        this.JL187.setBounds(0, 0, 41, 45);
        this.JL188.setMaximumSize(new Dimension(41, 45));
        this.JL188.setMinimumSize(new Dimension(41, 45));
        this.JL188.setName("1");
        this.JL188.setPreferredSize(new Dimension(41, 45));
        this.JP47.add(this.JL188);
        this.JL188.setBounds(0, 0, 41, 45);
        this.JLDBlanco47.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/diente_blancoCP.png")));
        this.JLDBlanco47.setName("0");
        this.JP47.add(this.JLDBlanco47);
        this.JLDBlanco47.setBounds(0, 0, 41, 45);
        this.jLabel48.setFont(new Font("Arial", 1, 12));
        this.jLabel48.setHorizontalAlignment(0);
        this.jLabel48.setText("15");
        this.JP48.setMaximumSize(new Dimension(41, 45));
        this.JP48.setMinimumSize(new Dimension(41, 45));
        this.JP48.setName("16");
        this.JP48.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPControlPlaca.55
            public void mouseClicked(MouseEvent evt) {
                JPControlPlaca.this.JP48MouseClicked(evt);
            }
        });
        this.JP48.setLayout((LayoutManager) null);
        this.JL189.setMaximumSize(new Dimension(41, 45));
        this.JL189.setMinimumSize(new Dimension(41, 45));
        this.JL189.setName("4");
        this.JL189.setPreferredSize(new Dimension(41, 45));
        this.JP48.add(this.JL189);
        this.JL189.setBounds(0, 0, 41, 45);
        this.JL190.setMaximumSize(new Dimension(41, 45));
        this.JL190.setMinimumSize(new Dimension(41, 45));
        this.JL190.setName("3");
        this.JL190.setPreferredSize(new Dimension(41, 45));
        this.JP48.add(this.JL190);
        this.JL190.setBounds(0, 0, 41, 45);
        this.JL191.setMaximumSize(new Dimension(41, 45));
        this.JL191.setMinimumSize(new Dimension(41, 45));
        this.JL191.setName("2");
        this.JL191.setPreferredSize(new Dimension(41, 45));
        this.JP48.add(this.JL191);
        this.JL191.setBounds(0, 0, 41, 45);
        this.JL192.setMaximumSize(new Dimension(41, 45));
        this.JL192.setMinimumSize(new Dimension(41, 45));
        this.JL192.setName("1");
        this.JL192.setPreferredSize(new Dimension(41, 45));
        this.JP48.add(this.JL192);
        this.JL192.setBounds(0, 0, 41, 45);
        this.JLDBlanco48.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/diente_blancoCP.png")));
        this.JLDBlanco48.setName("0");
        this.JP48.add(this.JLDBlanco48);
        this.JLDBlanco48.setBounds(0, 0, 41, 45);
        this.jLabel49.setFont(new Font("Arial", 1, 12));
        this.jLabel49.setHorizontalAlignment(0);
        this.jLabel49.setText("16");
        this.jLabel50.setFont(new Font("Arial", 1, 12));
        this.jLabel50.setHorizontalAlignment(0);
        this.jLabel50.setText("17");
        this.JP49.setMaximumSize(new Dimension(41, 45));
        this.JP49.setMinimumSize(new Dimension(41, 45));
        this.JP49.setName("17");
        this.JP49.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPControlPlaca.56
            public void mouseClicked(MouseEvent evt) {
                JPControlPlaca.this.JP49MouseClicked(evt);
            }
        });
        this.JP49.setLayout((LayoutManager) null);
        this.JL193.setMaximumSize(new Dimension(41, 45));
        this.JL193.setMinimumSize(new Dimension(41, 45));
        this.JL193.setName("4");
        this.JL193.setPreferredSize(new Dimension(41, 45));
        this.JP49.add(this.JL193);
        this.JL193.setBounds(0, 0, 41, 45);
        this.JL194.setMaximumSize(new Dimension(41, 45));
        this.JL194.setMinimumSize(new Dimension(41, 45));
        this.JL194.setName("3");
        this.JL194.setPreferredSize(new Dimension(41, 45));
        this.JP49.add(this.JL194);
        this.JL194.setBounds(0, 0, 41, 45);
        this.JL195.setMaximumSize(new Dimension(41, 45));
        this.JL195.setMinimumSize(new Dimension(41, 45));
        this.JL195.setName("2");
        this.JL195.setPreferredSize(new Dimension(41, 45));
        this.JP49.add(this.JL195);
        this.JL195.setBounds(0, 0, 41, 45);
        this.JL196.setMaximumSize(new Dimension(41, 45));
        this.JL196.setMinimumSize(new Dimension(41, 45));
        this.JL196.setName("1");
        this.JL196.setPreferredSize(new Dimension(41, 45));
        this.JP49.add(this.JL196);
        this.JL196.setBounds(0, 0, 41, 45);
        this.JLDBlanco49.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/diente_blancoCP.png")));
        this.JLDBlanco49.setName("0");
        this.JP49.add(this.JLDBlanco49);
        this.JLDBlanco49.setBounds(0, 0, 41, 45);
        this.jLabel51.setFont(new Font("Arial", 1, 12));
        this.jLabel51.setHorizontalAlignment(0);
        this.jLabel51.setText("18");
        this.JP50.setMaximumSize(new Dimension(41, 45));
        this.JP50.setMinimumSize(new Dimension(41, 45));
        this.JP50.setName("18");
        this.JP50.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPControlPlaca.57
            public void mouseClicked(MouseEvent evt) {
                JPControlPlaca.this.JP50MouseClicked(evt);
            }
        });
        this.JP50.setLayout((LayoutManager) null);
        this.JL197.setMaximumSize(new Dimension(41, 45));
        this.JL197.setMinimumSize(new Dimension(41, 45));
        this.JL197.setName("4");
        this.JL197.setPreferredSize(new Dimension(41, 45));
        this.JP50.add(this.JL197);
        this.JL197.setBounds(0, 0, 41, 45);
        this.JL198.setMaximumSize(new Dimension(41, 45));
        this.JL198.setMinimumSize(new Dimension(41, 45));
        this.JL198.setName("3");
        this.JL198.setPreferredSize(new Dimension(41, 45));
        this.JP50.add(this.JL198);
        this.JL198.setBounds(0, 0, 41, 45);
        this.JL199.setMaximumSize(new Dimension(41, 45));
        this.JL199.setMinimumSize(new Dimension(41, 45));
        this.JL199.setName("2");
        this.JL199.setPreferredSize(new Dimension(41, 45));
        this.JP50.add(this.JL199);
        this.JL199.setBounds(0, 0, 41, 45);
        this.JL200.setMaximumSize(new Dimension(41, 45));
        this.JL200.setMinimumSize(new Dimension(41, 45));
        this.JL200.setName("1");
        this.JL200.setPreferredSize(new Dimension(41, 45));
        this.JP50.add(this.JL200);
        this.JL200.setBounds(0, 0, 41, 45);
        this.JLDBlanco50.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/diente_blancoCP.png")));
        this.JLDBlanco50.setName("0");
        this.JP50.add(this.JLDBlanco50);
        this.JLDBlanco50.setBounds(0, 0, 41, 45);
        this.jLabel52.setFont(new Font("Arial", 1, 12));
        this.jLabel52.setHorizontalAlignment(0);
        this.jLabel52.setText("19");
        this.JP51.setMaximumSize(new Dimension(41, 45));
        this.JP51.setMinimumSize(new Dimension(41, 45));
        this.JP51.setName("19");
        this.JP51.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPControlPlaca.58
            public void mouseClicked(MouseEvent evt) {
                JPControlPlaca.this.JP51MouseClicked(evt);
            }
        });
        this.JP51.setLayout((LayoutManager) null);
        this.JL201.setMaximumSize(new Dimension(41, 45));
        this.JL201.setMinimumSize(new Dimension(41, 45));
        this.JL201.setName("4");
        this.JL201.setPreferredSize(new Dimension(41, 45));
        this.JP51.add(this.JL201);
        this.JL201.setBounds(0, 0, 41, 45);
        this.JL202.setMaximumSize(new Dimension(41, 45));
        this.JL202.setMinimumSize(new Dimension(41, 45));
        this.JL202.setName("3");
        this.JL202.setPreferredSize(new Dimension(41, 45));
        this.JP51.add(this.JL202);
        this.JL202.setBounds(0, 0, 41, 45);
        this.JL203.setMaximumSize(new Dimension(41, 45));
        this.JL203.setMinimumSize(new Dimension(41, 45));
        this.JL203.setName("2");
        this.JL203.setPreferredSize(new Dimension(41, 45));
        this.JP51.add(this.JL203);
        this.JL203.setBounds(0, 0, 41, 45);
        this.JL204.setMaximumSize(new Dimension(41, 45));
        this.JL204.setMinimumSize(new Dimension(41, 45));
        this.JL204.setName("1");
        this.JL204.setPreferredSize(new Dimension(41, 45));
        this.JP51.add(this.JL204);
        this.JL204.setBounds(0, 0, 41, 45);
        this.JLDBlanco51.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/diente_blancoCP.png")));
        this.JLDBlanco51.setName("0");
        this.JP51.add(this.JLDBlanco51);
        this.JLDBlanco51.setBounds(0, 0, 41, 45);
        this.jLabel53.setFont(new Font("Arial", 1, 12));
        this.jLabel53.setHorizontalAlignment(0);
        this.jLabel53.setText("20");
        this.JP52.setMaximumSize(new Dimension(41, 45));
        this.JP52.setMinimumSize(new Dimension(41, 45));
        this.JP52.setName("20");
        this.JP52.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPControlPlaca.59
            public void mouseClicked(MouseEvent evt) {
                JPControlPlaca.this.JP52MouseClicked(evt);
            }
        });
        this.JP52.setLayout((LayoutManager) null);
        this.JL205.setMaximumSize(new Dimension(41, 45));
        this.JL205.setMinimumSize(new Dimension(41, 45));
        this.JL205.setName("4");
        this.JL205.setPreferredSize(new Dimension(41, 45));
        this.JP52.add(this.JL205);
        this.JL205.setBounds(0, 0, 41, 45);
        this.JL206.setMaximumSize(new Dimension(41, 45));
        this.JL206.setMinimumSize(new Dimension(41, 45));
        this.JL206.setName("3");
        this.JL206.setPreferredSize(new Dimension(41, 45));
        this.JP52.add(this.JL206);
        this.JL206.setBounds(0, 0, 41, 45);
        this.JL207.setMaximumSize(new Dimension(41, 45));
        this.JL207.setMinimumSize(new Dimension(41, 45));
        this.JL207.setName("2");
        this.JL207.setPreferredSize(new Dimension(41, 45));
        this.JP52.add(this.JL207);
        this.JL207.setBounds(0, 0, 41, 45);
        this.JL208.setMaximumSize(new Dimension(41, 45));
        this.JL208.setMinimumSize(new Dimension(41, 45));
        this.JL208.setName("1");
        this.JL208.setPreferredSize(new Dimension(41, 45));
        this.JP52.add(this.JL208);
        this.JL208.setBounds(0, 0, 41, 45);
        this.JLDBlanco52.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/diente_blancoCP.png")));
        this.JLDBlanco52.setName("0");
        this.JP52.add(this.JLDBlanco52);
        this.JLDBlanco52.setBounds(0, 0, 41, 45);
        this.jLabel54.setFont(new Font("Arial", 1, 12));
        this.jLabel54.setHorizontalAlignment(0);
        this.jLabel54.setText("21");
        this.JP53.setMaximumSize(new Dimension(41, 45));
        this.JP53.setMinimumSize(new Dimension(41, 45));
        this.JP53.setName("21");
        this.JP53.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPControlPlaca.60
            public void mouseClicked(MouseEvent evt) {
                JPControlPlaca.this.JP53MouseClicked(evt);
            }
        });
        this.JP53.setLayout((LayoutManager) null);
        this.JL209.setMaximumSize(new Dimension(41, 45));
        this.JL209.setMinimumSize(new Dimension(41, 45));
        this.JL209.setName("4");
        this.JL209.setPreferredSize(new Dimension(41, 45));
        this.JP53.add(this.JL209);
        this.JL209.setBounds(0, 0, 41, 45);
        this.JL210.setMaximumSize(new Dimension(41, 45));
        this.JL210.setMinimumSize(new Dimension(41, 45));
        this.JL210.setName("3");
        this.JL210.setPreferredSize(new Dimension(41, 45));
        this.JP53.add(this.JL210);
        this.JL210.setBounds(0, 0, 41, 45);
        this.JL211.setMaximumSize(new Dimension(41, 45));
        this.JL211.setMinimumSize(new Dimension(41, 45));
        this.JL211.setName("2");
        this.JL211.setPreferredSize(new Dimension(41, 45));
        this.JP53.add(this.JL211);
        this.JL211.setBounds(0, 0, 41, 45);
        this.JL212.setMaximumSize(new Dimension(41, 45));
        this.JL212.setMinimumSize(new Dimension(41, 45));
        this.JL212.setName("1");
        this.JL212.setPreferredSize(new Dimension(41, 45));
        this.JP53.add(this.JL212);
        this.JL212.setBounds(0, 0, 41, 45);
        this.JLDBlanco53.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/diente_blancoCP.png")));
        this.JLDBlanco53.setName("0");
        this.JP53.add(this.JLDBlanco53);
        this.JLDBlanco53.setBounds(0, 0, 41, 45);
        this.jLabel55.setFont(new Font("Arial", 1, 12));
        this.jLabel55.setHorizontalAlignment(0);
        this.jLabel55.setText("22");
        this.JP54.setMaximumSize(new Dimension(41, 45));
        this.JP54.setMinimumSize(new Dimension(41, 45));
        this.JP54.setName("22");
        this.JP54.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPControlPlaca.61
            public void mouseClicked(MouseEvent evt) {
                JPControlPlaca.this.JP54MouseClicked(evt);
            }
        });
        this.JP54.setLayout((LayoutManager) null);
        this.JL213.setMaximumSize(new Dimension(41, 45));
        this.JL213.setMinimumSize(new Dimension(41, 45));
        this.JL213.setName("4");
        this.JL213.setPreferredSize(new Dimension(41, 45));
        this.JP54.add(this.JL213);
        this.JL213.setBounds(0, 0, 41, 45);
        this.JL214.setMaximumSize(new Dimension(41, 45));
        this.JL214.setMinimumSize(new Dimension(41, 45));
        this.JL214.setName("3");
        this.JL214.setPreferredSize(new Dimension(41, 45));
        this.JP54.add(this.JL214);
        this.JL214.setBounds(0, 0, 41, 45);
        this.JL215.setMaximumSize(new Dimension(41, 45));
        this.JL215.setMinimumSize(new Dimension(41, 45));
        this.JL215.setName("2");
        this.JL215.setPreferredSize(new Dimension(41, 45));
        this.JP54.add(this.JL215);
        this.JL215.setBounds(0, 0, 41, 45);
        this.JL216.setMaximumSize(new Dimension(41, 45));
        this.JL216.setMinimumSize(new Dimension(41, 45));
        this.JL216.setName("1");
        this.JL216.setPreferredSize(new Dimension(41, 45));
        this.JP54.add(this.JL216);
        this.JL216.setBounds(0, 0, 41, 45);
        this.JLDBlanco54.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/diente_blancoCP.png")));
        this.JLDBlanco54.setName("0");
        this.JP54.add(this.JLDBlanco54);
        this.JLDBlanco54.setBounds(0, 0, 41, 45);
        this.jLabel56.setFont(new Font("Arial", 1, 12));
        this.jLabel56.setHorizontalAlignment(0);
        this.jLabel56.setText("23");
        this.JP55.setMaximumSize(new Dimension(41, 45));
        this.JP55.setMinimumSize(new Dimension(41, 45));
        this.JP55.setName("23");
        this.JP55.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPControlPlaca.62
            public void mouseClicked(MouseEvent evt) {
                JPControlPlaca.this.JP55MouseClicked(evt);
            }
        });
        this.JP55.setLayout((LayoutManager) null);
        this.JL217.setMaximumSize(new Dimension(41, 45));
        this.JL217.setMinimumSize(new Dimension(41, 45));
        this.JL217.setName("4");
        this.JL217.setPreferredSize(new Dimension(41, 45));
        this.JP55.add(this.JL217);
        this.JL217.setBounds(0, 0, 41, 45);
        this.JL218.setMaximumSize(new Dimension(41, 45));
        this.JL218.setMinimumSize(new Dimension(41, 45));
        this.JL218.setName("3");
        this.JL218.setPreferredSize(new Dimension(41, 45));
        this.JP55.add(this.JL218);
        this.JL218.setBounds(0, 0, 41, 45);
        this.JL219.setMaximumSize(new Dimension(41, 45));
        this.JL219.setMinimumSize(new Dimension(41, 45));
        this.JL219.setName("2");
        this.JL219.setPreferredSize(new Dimension(41, 45));
        this.JP55.add(this.JL219);
        this.JL219.setBounds(0, 0, 41, 45);
        this.JL220.setMaximumSize(new Dimension(41, 45));
        this.JL220.setMinimumSize(new Dimension(41, 45));
        this.JL220.setName("1");
        this.JL220.setPreferredSize(new Dimension(41, 45));
        this.JP55.add(this.JL220);
        this.JL220.setBounds(0, 0, 41, 45);
        this.JLDBlanco55.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/diente_blancoCP.png")));
        this.JLDBlanco55.setName("0");
        this.JP55.add(this.JLDBlanco55);
        this.JLDBlanco55.setBounds(0, 0, 41, 45);
        this.jLabel57.setFont(new Font("Arial", 1, 12));
        this.jLabel57.setHorizontalAlignment(0);
        this.jLabel57.setText("24");
        this.JP56.setMaximumSize(new Dimension(41, 45));
        this.JP56.setMinimumSize(new Dimension(41, 45));
        this.JP56.setName("24");
        this.JP56.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPControlPlaca.63
            public void mouseClicked(MouseEvent evt) {
                JPControlPlaca.this.JP56MouseClicked(evt);
            }
        });
        this.JP56.setLayout((LayoutManager) null);
        this.JL221.setMaximumSize(new Dimension(41, 45));
        this.JL221.setMinimumSize(new Dimension(41, 45));
        this.JL221.setName("4");
        this.JL221.setPreferredSize(new Dimension(41, 45));
        this.JP56.add(this.JL221);
        this.JL221.setBounds(0, 0, 41, 45);
        this.JL222.setMaximumSize(new Dimension(41, 45));
        this.JL222.setMinimumSize(new Dimension(41, 45));
        this.JL222.setName("3");
        this.JL222.setPreferredSize(new Dimension(41, 45));
        this.JP56.add(this.JL222);
        this.JL222.setBounds(0, 0, 41, 45);
        this.JL223.setMaximumSize(new Dimension(41, 45));
        this.JL223.setMinimumSize(new Dimension(41, 45));
        this.JL223.setName("2");
        this.JL223.setPreferredSize(new Dimension(41, 45));
        this.JP56.add(this.JL223);
        this.JL223.setBounds(0, 0, 41, 45);
        this.JL224.setMaximumSize(new Dimension(41, 45));
        this.JL224.setMinimumSize(new Dimension(41, 45));
        this.JL224.setName("1");
        this.JL224.setPreferredSize(new Dimension(41, 45));
        this.JP56.add(this.JL224);
        this.JL224.setBounds(0, 0, 41, 45);
        this.JLDBlanco56.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/diente_blancoCP.png")));
        this.JLDBlanco56.setName("0");
        this.JP56.add(this.JLDBlanco56);
        this.JLDBlanco56.setBounds(0, 0, 41, 45);
        this.jLabel58.setFont(new Font("Arial", 1, 12));
        this.jLabel58.setHorizontalAlignment(0);
        this.jLabel58.setText("25");
        this.JP57.setMaximumSize(new Dimension(41, 45));
        this.JP57.setMinimumSize(new Dimension(41, 45));
        this.JP57.setName("25");
        this.JP57.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPControlPlaca.64
            public void mouseClicked(MouseEvent evt) {
                JPControlPlaca.this.JP57MouseClicked(evt);
            }
        });
        this.JP57.setLayout((LayoutManager) null);
        this.JL225.setMaximumSize(new Dimension(41, 45));
        this.JL225.setMinimumSize(new Dimension(41, 45));
        this.JL225.setName("4");
        this.JL225.setPreferredSize(new Dimension(41, 45));
        this.JP57.add(this.JL225);
        this.JL225.setBounds(0, 0, 41, 45);
        this.JL226.setMaximumSize(new Dimension(41, 45));
        this.JL226.setMinimumSize(new Dimension(41, 45));
        this.JL226.setName("3");
        this.JL226.setPreferredSize(new Dimension(41, 45));
        this.JP57.add(this.JL226);
        this.JL226.setBounds(0, 0, 41, 45);
        this.JL227.setMaximumSize(new Dimension(41, 45));
        this.JL227.setMinimumSize(new Dimension(41, 45));
        this.JL227.setName("2");
        this.JL227.setPreferredSize(new Dimension(41, 45));
        this.JP57.add(this.JL227);
        this.JL227.setBounds(0, 0, 41, 45);
        this.JL228.setMaximumSize(new Dimension(41, 45));
        this.JL228.setMinimumSize(new Dimension(41, 45));
        this.JL228.setName("1");
        this.JL228.setPreferredSize(new Dimension(41, 45));
        this.JP57.add(this.JL228);
        this.JL228.setBounds(0, 0, 41, 45);
        this.JLDBlanco57.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/diente_blancoCP.png")));
        this.JLDBlanco57.setName("0");
        this.JP57.add(this.JLDBlanco57);
        this.JLDBlanco57.setBounds(0, 0, 41, 45);
        this.jLabel59.setFont(new Font("Arial", 1, 12));
        this.jLabel59.setHorizontalAlignment(0);
        this.jLabel59.setText("26");
        this.JP58.setMaximumSize(new Dimension(41, 45));
        this.JP58.setMinimumSize(new Dimension(41, 45));
        this.JP58.setName("26");
        this.JP58.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPControlPlaca.65
            public void mouseClicked(MouseEvent evt) {
                JPControlPlaca.this.JP58MouseClicked(evt);
            }
        });
        this.JP58.setLayout((LayoutManager) null);
        this.JL229.setMaximumSize(new Dimension(41, 45));
        this.JL229.setMinimumSize(new Dimension(41, 45));
        this.JL229.setName("4");
        this.JL229.setPreferredSize(new Dimension(41, 45));
        this.JP58.add(this.JL229);
        this.JL229.setBounds(0, 0, 41, 45);
        this.JL230.setMaximumSize(new Dimension(41, 45));
        this.JL230.setMinimumSize(new Dimension(41, 45));
        this.JL230.setName("3");
        this.JL230.setPreferredSize(new Dimension(41, 45));
        this.JP58.add(this.JL230);
        this.JL230.setBounds(0, 0, 41, 45);
        this.JL231.setMaximumSize(new Dimension(41, 45));
        this.JL231.setMinimumSize(new Dimension(41, 45));
        this.JL231.setName("2");
        this.JL231.setPreferredSize(new Dimension(41, 45));
        this.JP58.add(this.JL231);
        this.JL231.setBounds(0, 0, 41, 45);
        this.JL232.setMaximumSize(new Dimension(41, 45));
        this.JL232.setMinimumSize(new Dimension(41, 45));
        this.JL232.setName("1");
        this.JL232.setPreferredSize(new Dimension(41, 45));
        this.JP58.add(this.JL232);
        this.JL232.setBounds(0, 0, 41, 45);
        this.JLDBlanco58.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/diente_blancoCP.png")));
        this.JLDBlanco58.setName("0");
        this.JP58.add(this.JLDBlanco58);
        this.JLDBlanco58.setBounds(0, 0, 41, 45);
        this.jLabel60.setFont(new Font("Arial", 1, 12));
        this.jLabel60.setHorizontalAlignment(0);
        this.jLabel60.setText("27");
        this.JP59.setMaximumSize(new Dimension(41, 45));
        this.JP59.setMinimumSize(new Dimension(41, 45));
        this.JP59.setName("27");
        this.JP59.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPControlPlaca.66
            public void mouseClicked(MouseEvent evt) {
                JPControlPlaca.this.JP59MouseClicked(evt);
            }
        });
        this.JP59.setLayout((LayoutManager) null);
        this.JL233.setMaximumSize(new Dimension(41, 45));
        this.JL233.setMinimumSize(new Dimension(41, 45));
        this.JL233.setName("4");
        this.JL233.setPreferredSize(new Dimension(41, 45));
        this.JP59.add(this.JL233);
        this.JL233.setBounds(0, 0, 41, 45);
        this.JL234.setMaximumSize(new Dimension(41, 45));
        this.JL234.setMinimumSize(new Dimension(41, 45));
        this.JL234.setName("3");
        this.JL234.setPreferredSize(new Dimension(41, 45));
        this.JP59.add(this.JL234);
        this.JL234.setBounds(0, 0, 41, 45);
        this.JL235.setMaximumSize(new Dimension(41, 45));
        this.JL235.setMinimumSize(new Dimension(41, 45));
        this.JL235.setName("2");
        this.JL235.setPreferredSize(new Dimension(41, 45));
        this.JP59.add(this.JL235);
        this.JL235.setBounds(0, 0, 41, 45);
        this.JL236.setMaximumSize(new Dimension(41, 45));
        this.JL236.setMinimumSize(new Dimension(41, 45));
        this.JL236.setName("1");
        this.JL236.setPreferredSize(new Dimension(41, 45));
        this.JP59.add(this.JL236);
        this.JL236.setBounds(0, 0, 41, 45);
        this.JLDBlanco59.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/diente_blancoCP.png")));
        this.JLDBlanco59.setName("0");
        this.JP59.add(this.JLDBlanco59);
        this.JLDBlanco59.setBounds(0, 0, 41, 45);
        this.jLabel61.setFont(new Font("Arial", 1, 12));
        this.jLabel61.setHorizontalAlignment(0);
        this.jLabel61.setText("28");
        this.JP60.setMaximumSize(new Dimension(41, 45));
        this.JP60.setMinimumSize(new Dimension(41, 45));
        this.JP60.setName("28");
        this.JP60.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPControlPlaca.67
            public void mouseClicked(MouseEvent evt) {
                JPControlPlaca.this.JP60MouseClicked(evt);
            }
        });
        this.JP60.setLayout((LayoutManager) null);
        this.JL237.setMaximumSize(new Dimension(41, 45));
        this.JL237.setMinimumSize(new Dimension(41, 45));
        this.JL237.setName("4");
        this.JL237.setPreferredSize(new Dimension(41, 45));
        this.JP60.add(this.JL237);
        this.JL237.setBounds(0, 0, 41, 45);
        this.JL238.setMaximumSize(new Dimension(41, 45));
        this.JL238.setMinimumSize(new Dimension(41, 45));
        this.JL238.setName("3");
        this.JL238.setPreferredSize(new Dimension(41, 45));
        this.JP60.add(this.JL238);
        this.JL238.setBounds(0, 0, 41, 45);
        this.JL239.setMaximumSize(new Dimension(41, 45));
        this.JL239.setMinimumSize(new Dimension(41, 45));
        this.JL239.setName("2");
        this.JL239.setPreferredSize(new Dimension(41, 45));
        this.JP60.add(this.JL239);
        this.JL239.setBounds(0, 0, 41, 45);
        this.JL240.setMaximumSize(new Dimension(41, 45));
        this.JL240.setMinimumSize(new Dimension(41, 45));
        this.JL240.setName("1");
        this.JL240.setPreferredSize(new Dimension(41, 45));
        this.JP60.add(this.JL240);
        this.JL240.setBounds(0, 0, 41, 45);
        this.JLDBlanco60.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/diente_blancoCP.png")));
        this.JLDBlanco60.setName("0");
        this.JP60.add(this.JLDBlanco60);
        this.JLDBlanco60.setBounds(0, 0, 41, 45);
        this.jLabel62.setFont(new Font("Arial", 1, 12));
        this.jLabel62.setHorizontalAlignment(0);
        this.jLabel62.setText("29");
        this.JP61.setMaximumSize(new Dimension(41, 45));
        this.JP61.setMinimumSize(new Dimension(41, 45));
        this.JP61.setName("29");
        this.JP61.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPControlPlaca.68
            public void mouseClicked(MouseEvent evt) {
                JPControlPlaca.this.JP61MouseClicked(evt);
            }
        });
        this.JP61.setLayout((LayoutManager) null);
        this.JL241.setMaximumSize(new Dimension(41, 45));
        this.JL241.setMinimumSize(new Dimension(41, 45));
        this.JL241.setName("4");
        this.JL241.setPreferredSize(new Dimension(41, 45));
        this.JP61.add(this.JL241);
        this.JL241.setBounds(0, 0, 41, 45);
        this.JL242.setMaximumSize(new Dimension(41, 45));
        this.JL242.setMinimumSize(new Dimension(41, 45));
        this.JL242.setName("3");
        this.JL242.setPreferredSize(new Dimension(41, 45));
        this.JP61.add(this.JL242);
        this.JL242.setBounds(0, 0, 41, 45);
        this.JL243.setMaximumSize(new Dimension(41, 45));
        this.JL243.setMinimumSize(new Dimension(41, 45));
        this.JL243.setName("2");
        this.JL243.setPreferredSize(new Dimension(41, 45));
        this.JP61.add(this.JL243);
        this.JL243.setBounds(0, 0, 41, 45);
        this.JL244.setMaximumSize(new Dimension(41, 45));
        this.JL244.setMinimumSize(new Dimension(41, 45));
        this.JL244.setName("1");
        this.JL244.setPreferredSize(new Dimension(41, 45));
        this.JP61.add(this.JL244);
        this.JL244.setBounds(0, 0, 41, 45);
        this.JLDBlanco61.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/diente_blancoCP.png")));
        this.JLDBlanco61.setName("0");
        this.JP61.add(this.JLDBlanco61);
        this.JLDBlanco61.setBounds(0, 0, 41, 45);
        this.jLabel63.setFont(new Font("Arial", 1, 12));
        this.jLabel63.setHorizontalAlignment(0);
        this.jLabel63.setText("30");
        this.JP62.setMaximumSize(new Dimension(41, 45));
        this.JP62.setMinimumSize(new Dimension(41, 45));
        this.JP62.setName("30");
        this.JP62.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPControlPlaca.69
            public void mouseClicked(MouseEvent evt) {
                JPControlPlaca.this.JP62MouseClicked(evt);
            }
        });
        this.JP62.setLayout((LayoutManager) null);
        this.JL245.setMaximumSize(new Dimension(41, 45));
        this.JL245.setMinimumSize(new Dimension(41, 45));
        this.JL245.setName("4");
        this.JL245.setPreferredSize(new Dimension(41, 45));
        this.JP62.add(this.JL245);
        this.JL245.setBounds(0, 0, 41, 45);
        this.JL246.setMaximumSize(new Dimension(41, 45));
        this.JL246.setMinimumSize(new Dimension(41, 45));
        this.JL246.setName("3");
        this.JL246.setPreferredSize(new Dimension(41, 45));
        this.JP62.add(this.JL246);
        this.JL246.setBounds(0, 0, 41, 45);
        this.JL247.setMaximumSize(new Dimension(41, 45));
        this.JL247.setMinimumSize(new Dimension(41, 45));
        this.JL247.setName("2");
        this.JL247.setPreferredSize(new Dimension(41, 45));
        this.JP62.add(this.JL247);
        this.JL247.setBounds(0, 0, 41, 45);
        this.JL248.setMaximumSize(new Dimension(41, 45));
        this.JL248.setMinimumSize(new Dimension(41, 45));
        this.JL248.setName("1");
        this.JL248.setPreferredSize(new Dimension(41, 45));
        this.JP62.add(this.JL248);
        this.JL248.setBounds(0, 0, 41, 45);
        this.JLDBlanco62.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/diente_blancoCP.png")));
        this.JLDBlanco62.setName("0");
        this.JP62.add(this.JLDBlanco62);
        this.JLDBlanco62.setBounds(0, 0, 41, 45);
        this.jLabel64.setFont(new Font("Arial", 1, 12));
        this.jLabel64.setHorizontalAlignment(0);
        this.jLabel64.setText("31");
        this.JP63.setMaximumSize(new Dimension(41, 45));
        this.JP63.setMinimumSize(new Dimension(41, 45));
        this.JP63.setName("31");
        this.JP63.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPControlPlaca.70
            public void mouseClicked(MouseEvent evt) {
                JPControlPlaca.this.JP63MouseClicked(evt);
            }
        });
        this.JP63.setLayout((LayoutManager) null);
        this.JL249.setMaximumSize(new Dimension(41, 45));
        this.JL249.setMinimumSize(new Dimension(41, 45));
        this.JL249.setName("4");
        this.JL249.setPreferredSize(new Dimension(41, 45));
        this.JP63.add(this.JL249);
        this.JL249.setBounds(0, 0, 41, 45);
        this.JL250.setMaximumSize(new Dimension(41, 45));
        this.JL250.setMinimumSize(new Dimension(41, 45));
        this.JL250.setName("3");
        this.JL250.setPreferredSize(new Dimension(41, 45));
        this.JP63.add(this.JL250);
        this.JL250.setBounds(0, 0, 41, 45);
        this.JL251.setMaximumSize(new Dimension(41, 45));
        this.JL251.setMinimumSize(new Dimension(41, 45));
        this.JL251.setName("2");
        this.JL251.setPreferredSize(new Dimension(41, 45));
        this.JP63.add(this.JL251);
        this.JL251.setBounds(0, 0, 41, 45);
        this.JL252.setMaximumSize(new Dimension(41, 45));
        this.JL252.setMinimumSize(new Dimension(41, 45));
        this.JL252.setName("1");
        this.JL252.setPreferredSize(new Dimension(41, 45));
        this.JP63.add(this.JL252);
        this.JL252.setBounds(0, 0, 41, 45);
        this.JLDBlanco63.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/diente_blancoCP.png")));
        this.JLDBlanco63.setName("0");
        this.JP63.add(this.JLDBlanco63);
        this.JLDBlanco63.setBounds(0, 0, 41, 45);
        this.jLabel65.setFont(new Font("Arial", 1, 12));
        this.jLabel65.setHorizontalAlignment(0);
        this.jLabel65.setText("32");
        this.JP64.setMaximumSize(new Dimension(41, 45));
        this.JP64.setMinimumSize(new Dimension(41, 45));
        this.JP64.setName("32");
        this.JP64.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPControlPlaca.71
            public void mouseClicked(MouseEvent evt) {
                JPControlPlaca.this.JP64MouseClicked(evt);
            }
        });
        this.JP64.setLayout((LayoutManager) null);
        this.JL253.setMaximumSize(new Dimension(41, 45));
        this.JL253.setMinimumSize(new Dimension(41, 45));
        this.JL253.setName("4");
        this.JL253.setPreferredSize(new Dimension(41, 45));
        this.JP64.add(this.JL253);
        this.JL253.setBounds(0, 0, 41, 45);
        this.JL254.setMaximumSize(new Dimension(41, 45));
        this.JL254.setMinimumSize(new Dimension(41, 45));
        this.JL254.setName("3");
        this.JL254.setPreferredSize(new Dimension(41, 45));
        this.JP64.add(this.JL254);
        this.JL254.setBounds(0, 0, 41, 45);
        this.JL255.setMaximumSize(new Dimension(41, 45));
        this.JL255.setMinimumSize(new Dimension(41, 45));
        this.JL255.setName("2");
        this.JL255.setPreferredSize(new Dimension(41, 45));
        this.JP64.add(this.JL255);
        this.JL255.setBounds(0, 0, 41, 45);
        this.JL256.setMaximumSize(new Dimension(41, 45));
        this.JL256.setMinimumSize(new Dimension(41, 45));
        this.JL256.setName("1");
        this.JL256.setPreferredSize(new Dimension(41, 45));
        this.JP64.add(this.JL256);
        this.JL256.setBounds(0, 0, 41, 45);
        this.JLDBlanco64.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/diente_blancoCP.png")));
        this.JLDBlanco64.setName("0");
        this.JP64.add(this.JLDBlanco64);
        this.JLDBlanco64.setBounds(0, 0, 41, 45);
        GroupLayout JPImOdontogramaHistoricoLayout = new GroupLayout(this.JPImOdontogramaHistorico);
        this.JPImOdontogramaHistorico.setLayout(JPImOdontogramaHistoricoLayout);
        JPImOdontogramaHistoricoLayout.setHorizontalGroup(JPImOdontogramaHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPImOdontogramaHistoricoLayout.createSequentialGroup().addContainerGap().addGroup(JPImOdontogramaHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPImOdontogramaHistoricoLayout.createSequentialGroup().addGroup(JPImOdontogramaHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JP33, -1, -1, 32767).addComponent(this.jLabel34, -1, 41, 32767)).addGap(0, 0, 0).addGroup(JPImOdontogramaHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JP34, -1, -1, 32767).addComponent(this.jLabel35, -2, 41, -2)).addGap(0, 0, 0).addGroup(JPImOdontogramaHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JP35, -1, -1, 32767).addComponent(this.jLabel36, -2, 41, -2)).addGap(0, 0, 0).addGroup(JPImOdontogramaHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JP36, -1, -1, 32767).addComponent(this.jLabel37, -2, 41, -2)).addGap(0, 0, 0).addGroup(JPImOdontogramaHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JP37, -1, -1, 32767).addComponent(this.jLabel38, -2, 41, -2)).addGap(0, 0, 0).addGroup(JPImOdontogramaHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JP38, -1, -1, 32767).addComponent(this.jLabel39, -2, 41, -2)).addGap(0, 0, 0).addGroup(JPImOdontogramaHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JP39, -1, -1, 32767).addComponent(this.jLabel40, -2, 41, -2)).addGap(0, 0, 0).addGroup(JPImOdontogramaHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JP40, -1, -1, 32767).addComponent(this.jLabel41, -2, 41, -2)).addGap(0, 0, 0).addGroup(JPImOdontogramaHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JP41, -1, -1, 32767).addComponent(this.jLabel42, -2, 41, -2)).addGap(0, 0, 0).addGroup(JPImOdontogramaHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JP42, -1, -1, 32767).addComponent(this.jLabel43, -2, 41, -2)).addGap(0, 0, 0).addGroup(JPImOdontogramaHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JP43, -1, -1, 32767).addComponent(this.jLabel44, -2, 41, -2)).addGap(0, 0, 0).addGroup(JPImOdontogramaHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JP44, -1, -1, 32767).addComponent(this.jLabel45, -2, 41, -2)).addGap(0, 0, 0).addGroup(JPImOdontogramaHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JP45, -1, -1, 32767).addComponent(this.jLabel46, -2, 41, -2)).addGap(0, 0, 0).addGroup(JPImOdontogramaHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JP46, -1, -1, 32767).addComponent(this.jLabel47, -2, 41, -2)).addGap(0, 0, 0).addGroup(JPImOdontogramaHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JP47, -1, -1, 32767).addComponent(this.jLabel48, -2, 41, -2)).addGap(0, 0, 0).addGroup(JPImOdontogramaHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JP48, -1, -1, 32767).addComponent(this.jLabel49, -2, 41, -2))).addGroup(JPImOdontogramaHistoricoLayout.createSequentialGroup().addGroup(JPImOdontogramaHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JP64, -1, -1, 32767).addComponent(this.jLabel65, -2, 41, -2)).addGap(0, 0, 0).addGroup(JPImOdontogramaHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JP63, -1, -1, 32767).addComponent(this.jLabel64, -2, 41, -2)).addGap(0, 0, 0).addGroup(JPImOdontogramaHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JP62, -1, -1, 32767).addComponent(this.jLabel63, -2, 41, -2)).addGap(0, 0, 0).addGroup(JPImOdontogramaHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JP61, -1, -1, 32767).addComponent(this.jLabel62, -2, 41, -2)).addGap(0, 0, 0).addGroup(JPImOdontogramaHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JP60, -1, -1, 32767).addComponent(this.jLabel61, -2, 41, -2)).addGap(0, 0, 0).addGroup(JPImOdontogramaHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JP59, -1, -1, 32767).addComponent(this.jLabel60, -2, 41, -2)).addGap(0, 0, 0).addGroup(JPImOdontogramaHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JP58, -1, -1, 32767).addComponent(this.jLabel59, -2, 41, -2)).addGap(0, 0, 0).addGroup(JPImOdontogramaHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JP57, -1, -1, 32767).addComponent(this.jLabel58, -2, 41, -2)).addGap(0, 0, 0).addGroup(JPImOdontogramaHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JP56, -1, -1, 32767).addComponent(this.jLabel57, -2, 41, -2)).addGap(0, 0, 0).addGroup(JPImOdontogramaHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JP55, -1, -1, 32767).addComponent(this.jLabel56, -2, 41, -2)).addGap(0, 0, 0).addGroup(JPImOdontogramaHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JP54, -1, -1, 32767).addComponent(this.jLabel55, -2, 41, -2)).addGap(0, 0, 0).addGroup(JPImOdontogramaHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JP53, -1, -1, 32767).addComponent(this.jLabel54, -2, 41, -2)).addGap(0, 0, 0).addGroup(JPImOdontogramaHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JP52, -1, -1, 32767).addComponent(this.jLabel53, -2, 41, -2)).addGap(0, 0, 0).addGroup(JPImOdontogramaHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JP51, -1, -1, 32767).addComponent(this.jLabel52, -2, 41, -2)).addGap(0, 0, 0).addGroup(JPImOdontogramaHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JP50, -1, -1, 32767).addComponent(this.jLabel51, -2, 41, -2)).addGap(0, 0, 0).addGroup(JPImOdontogramaHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JP49, -1, -1, 32767).addComponent(this.jLabel50, -2, 41, -2)))).addContainerGap(-1, 32767)));
        JPImOdontogramaHistoricoLayout.setVerticalGroup(JPImOdontogramaHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPImOdontogramaHistoricoLayout.createSequentialGroup().addContainerGap().addGroup(JPImOdontogramaHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPImOdontogramaHistoricoLayout.createSequentialGroup().addComponent(this.jLabel49).addGap(1, 1, 1).addComponent(this.JP48, -2, 45, -2)).addGroup(JPImOdontogramaHistoricoLayout.createSequentialGroup().addComponent(this.jLabel48).addGap(1, 1, 1).addComponent(this.JP47, -2, 45, -2)).addGroup(JPImOdontogramaHistoricoLayout.createSequentialGroup().addComponent(this.jLabel47).addGap(1, 1, 1).addComponent(this.JP46, -2, 45, -2)).addGroup(JPImOdontogramaHistoricoLayout.createSequentialGroup().addComponent(this.jLabel46).addGap(1, 1, 1).addComponent(this.JP45, -2, 45, -2)).addGroup(JPImOdontogramaHistoricoLayout.createSequentialGroup().addComponent(this.jLabel45).addGap(1, 1, 1).addComponent(this.JP44, -2, 45, -2)).addGroup(JPImOdontogramaHistoricoLayout.createSequentialGroup().addComponent(this.jLabel44).addGap(1, 1, 1).addComponent(this.JP43, -2, 45, -2)).addGroup(JPImOdontogramaHistoricoLayout.createSequentialGroup().addComponent(this.jLabel43).addGap(1, 1, 1).addComponent(this.JP42, -2, 45, -2)).addGroup(JPImOdontogramaHistoricoLayout.createSequentialGroup().addComponent(this.jLabel42).addGap(1, 1, 1).addComponent(this.JP41, -2, 45, -2)).addGroup(JPImOdontogramaHistoricoLayout.createSequentialGroup().addComponent(this.jLabel41).addGap(1, 1, 1).addComponent(this.JP40, -2, 45, -2)).addGroup(JPImOdontogramaHistoricoLayout.createSequentialGroup().addComponent(this.jLabel40).addGap(1, 1, 1).addComponent(this.JP39, -2, 45, -2)).addGroup(JPImOdontogramaHistoricoLayout.createSequentialGroup().addComponent(this.jLabel39).addGap(1, 1, 1).addComponent(this.JP38, -2, 45, -2)).addGroup(JPImOdontogramaHistoricoLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPImOdontogramaHistoricoLayout.createSequentialGroup().addComponent(this.jLabel38).addGap(1, 1, 1).addComponent(this.JP37, -2, 45, -2)).addGroup(JPImOdontogramaHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPImOdontogramaHistoricoLayout.createSequentialGroup().addComponent(this.jLabel37).addGap(1, 1, 1).addComponent(this.JP36, -2, 45, -2)).addGroup(JPImOdontogramaHistoricoLayout.createSequentialGroup().addComponent(this.jLabel36).addGap(1, 1, 1).addComponent(this.JP35, -2, 45, -2)).addGroup(JPImOdontogramaHistoricoLayout.createSequentialGroup().addComponent(this.jLabel35).addGap(1, 1, 1).addComponent(this.JP34, -2, 45, -2)).addGroup(JPImOdontogramaHistoricoLayout.createSequentialGroup().addComponent(this.jLabel34).addGap(1, 1, 1).addComponent(this.JP33, -2, 45, -2))))).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPImOdontogramaHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPImOdontogramaHistoricoLayout.createSequentialGroup().addComponent(this.jLabel50).addGap(1, 1, 1).addComponent(this.JP49, -2, 45, -2)).addGroup(JPImOdontogramaHistoricoLayout.createSequentialGroup().addComponent(this.jLabel51).addGap(1, 1, 1).addComponent(this.JP50, -2, 45, -2)).addGroup(JPImOdontogramaHistoricoLayout.createSequentialGroup().addComponent(this.jLabel52).addGap(1, 1, 1).addComponent(this.JP51, -2, 45, -2)).addGroup(JPImOdontogramaHistoricoLayout.createSequentialGroup().addComponent(this.jLabel53).addGap(1, 1, 1).addComponent(this.JP52, -2, 45, -2)).addGroup(JPImOdontogramaHistoricoLayout.createSequentialGroup().addComponent(this.jLabel54).addGap(1, 1, 1).addComponent(this.JP53, -2, 45, -2)).addGroup(JPImOdontogramaHistoricoLayout.createSequentialGroup().addComponent(this.jLabel55).addGap(1, 1, 1).addComponent(this.JP54, -2, 45, -2)).addGroup(JPImOdontogramaHistoricoLayout.createSequentialGroup().addComponent(this.jLabel56).addGap(1, 1, 1).addComponent(this.JP55, -2, 45, -2)).addGroup(JPImOdontogramaHistoricoLayout.createSequentialGroup().addComponent(this.jLabel57).addGap(1, 1, 1).addComponent(this.JP56, -2, 45, -2)).addGroup(JPImOdontogramaHistoricoLayout.createSequentialGroup().addComponent(this.jLabel58).addGap(1, 1, 1).addComponent(this.JP57, -2, 45, -2)).addGroup(JPImOdontogramaHistoricoLayout.createSequentialGroup().addComponent(this.jLabel59).addGap(1, 1, 1).addComponent(this.JP58, -2, 45, -2)).addGroup(JPImOdontogramaHistoricoLayout.createSequentialGroup().addComponent(this.jLabel60).addGap(1, 1, 1).addComponent(this.JP59, -2, 45, -2)).addGroup(JPImOdontogramaHistoricoLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPImOdontogramaHistoricoLayout.createSequentialGroup().addComponent(this.jLabel61).addGap(1, 1, 1).addComponent(this.JP60, -2, 45, -2)).addGroup(JPImOdontogramaHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPImOdontogramaHistoricoLayout.createSequentialGroup().addComponent(this.jLabel62).addGap(1, 1, 1).addComponent(this.JP61, -2, 45, -2)).addGroup(JPImOdontogramaHistoricoLayout.createSequentialGroup().addComponent(this.jLabel63).addGap(1, 1, 1).addComponent(this.JP62, -2, 45, -2)).addGroup(JPImOdontogramaHistoricoLayout.createSequentialGroup().addComponent(this.jLabel64).addGap(1, 1, 1).addComponent(this.JP63, -2, 45, -2)).addGroup(JPImOdontogramaHistoricoLayout.createSequentialGroup().addComponent(this.jLabel65).addGap(1, 1, 1).addComponent(this.JP64, -2, 45, -2))))).addContainerGap(30, 32767)));
        GroupLayout JPHistoricoLayout = new GroupLayout(this.JPHistorico);
        this.JPHistorico.setLayout(JPHistoricoLayout);
        JPHistoricoLayout.setHorizontalGroup(JPHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPHistoricoLayout.createSequentialGroup().addContainerGap().addGroup(JPHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPImOdontogramaHistorico, -2, -1, -2).addGroup(JPHistoricoLayout.createSequentialGroup().addComponent(this.JLCarasPlacaH, -2, 133, -2).addGap(10, 10, 10).addComponent(this.JLCarasMarcadasH, -2, 162, -2).addGap(10, 10, 10).addComponent(this.JLPresentesH, -2, 155, -2).addGap(10, 10, 10).addComponent(this.JLIndiceOlearyH, -2, 135, -2)).addComponent(this.JSPProcedimientoH, -2, 659, -2).addComponent(this.JSPHistorico, -2, 657, -2)).addContainerGap(-1, 32767)));
        JPHistoricoLayout.setVerticalGroup(JPHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPHistoricoLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPHistorico, -2, 187, -2).addGap(5, 5, 5).addComponent(this.JPImOdontogramaHistorico, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLCarasPlacaH, -2, 52, -2).addGroup(JPHistoricoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JLPresentesH, -2, 52, -2).addComponent(this.JLCarasMarcadasH, -2, 52, -2).addComponent(this.JLIndiceOlearyH, -2, 52, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPProcedimientoH, -1, 94, 32767).addGap(42, 42, 42)));
        this.JTPDatos.addTab("HISTÓRICO", this.JPHistorico);
        this.JSPPaleta.setMinimumSize(new Dimension(100, 600));
        this.JSPPaleta.setPreferredSize(new Dimension(165, 600));
        this.JBGConvencion.add(this.JTBPlacaB);
        this.JTBPlacaB.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/Placa Bacteriana/C_Placa.png")));
        this.JTBPlacaB.setToolTipText("Placa bacteriana");
        this.JTBPlacaB.setName("Placa bacteriana");
        this.JTBPlacaB.addActionListener(new ActionListener() { // from class: Odontologia.JPControlPlaca.72
            public void actionPerformed(ActionEvent evt) {
                JPControlPlaca.this.JTBPlacaBActionPerformed(evt);
            }
        });
        this.JBGConvencion.add(this.JTBExtraccion);
        this.JTBExtraccion.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/Extraccion/C_Extraido.png")));
        this.JTBExtraccion.setToolTipText("Extracción clinica");
        this.JTBExtraccion.setName("Extracción clinica");
        this.JTBExtraccion.addActionListener(new ActionListener() { // from class: Odontologia.JPControlPlaca.73
            public void actionPerformed(ActionEvent evt) {
                JPControlPlaca.this.JTBExtraccionActionPerformed(evt);
            }
        });
        this.JBGConvencion.add(this.JTBCorona);
        this.JTBCorona.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/Corona/C_Corona.png")));
        this.JTBCorona.setToolTipText("Corona");
        this.JTBCorona.setName("Corona");
        this.JTBCorona.addActionListener(new ActionListener() { // from class: Odontologia.JPControlPlaca.74
            public void actionPerformed(ActionEvent evt) {
                JPControlPlaca.this.JTBCoronaActionPerformed(evt);
            }
        });
        this.JBGConvencion.add(this.JTBSinErupsionar);
        this.JTBSinErupsionar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/Erupcion/C_Erupcion.png")));
        this.JTBSinErupsionar.setToolTipText("Sin erupcionar");
        this.JTBSinErupsionar.setName("Sin erupcionar");
        this.JTBSinErupsionar.addActionListener(new ActionListener() { // from class: Odontologia.JPControlPlaca.75
            public void actionPerformed(ActionEvent evt) {
                JPControlPlaca.this.JTBSinErupsionarActionPerformed(evt);
            }
        });
        this.JBGConvencion.add(this.JTBPuente);
        this.JTBPuente.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/Puente/C_Puente.png")));
        this.JTBPuente.setToolTipText("Puente");
        this.JTBPuente.setName("Puente");
        this.JTBPuente.addActionListener(new ActionListener() { // from class: Odontologia.JPControlPlaca.76
            public void actionPerformed(ActionEvent evt) {
                JPControlPlaca.this.JTBPuenteActionPerformed(evt);
            }
        });
        this.JTBBorrador.setBackground(new Color(255, 204, 204));
        this.JBGConvencion.add(this.JTBBorrador);
        this.JTBBorrador.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Odontograma/Convenciones/Borrador.png")));
        this.JTBBorrador.setToolTipText("Borrador (Quitar elemento)");
        this.JTBBorrador.setName("Borrador");
        this.JTBBorrador.addActionListener(new ActionListener() { // from class: Odontologia.JPControlPlaca.77
            public void actionPerformed(ActionEvent evt) {
                JPControlPlaca.this.JTBBorradorActionPerformed(evt);
            }
        });
        GroupLayout JSPPaletaLayout = new GroupLayout(this.JSPPaleta);
        this.JSPPaleta.setLayout(JSPPaletaLayout);
        JSPPaletaLayout.setHorizontalGroup(JSPPaletaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JSPPaletaLayout.createSequentialGroup().addContainerGap().addGroup(JSPPaletaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTBPlacaB, GroupLayout.Alignment.TRAILING, -2, 47, -2).addComponent(this.JTBCorona, GroupLayout.Alignment.TRAILING, -2, 47, -2).addComponent(this.JTBPuente, -2, 47, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JSPPaletaLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JSPPaletaLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JTBExtraccion, -2, 47, -2).addComponent(this.JTBSinErupsionar, -2, 47, -2)).addComponent(this.JTBBorrador, -1, -1, 32767)).addGap(0, 8, 32767)));
        JSPPaletaLayout.setVerticalGroup(JSPPaletaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JSPPaletaLayout.createSequentialGroup().addGap(19, 19, 19).addGroup(JSPPaletaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTBExtraccion, -2, 58, -2).addComponent(this.JTBPlacaB, -2, 58, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JSPPaletaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTBCorona, -2, 58, -2).addComponent(this.JTBSinErupsionar, -2, 58, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JSPPaletaLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTBPuente, -2, 0, 32767).addComponent(this.JTBBorrador, -1, 58, 32767)).addContainerGap(-1, 32767)));
        this.JLEstadoT.setFont(new Font("Arial", 1, 18));
        this.JLEstadoT.setForeground(new Color(255, 0, 0));
        this.JLEstadoT.setHorizontalAlignment(0);
        this.JLEstadoT.setBorder(BorderFactory.createTitledBorder((Border) null, "Tratamiento", 2, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JBFinalizaTratramiento.setFont(new Font("Arial", 1, 12));
        this.JBFinalizaTratramiento.setIcon(new ImageIcon(getClass().getResource("/Imagenes/meta.png")));
        this.JBFinalizaTratramiento.setText("Finalizar");
        this.JBFinalizaTratramiento.addActionListener(new ActionListener() { // from class: Odontologia.JPControlPlaca.78
            public void actionPerformed(ActionEvent evt) {
                JPControlPlaca.this.JBFinalizaTratramientoActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPPaleta, -2, 114, -2).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JBFinalizaTratramiento, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JLEstadoT, GroupLayout.Alignment.LEADING, -1, -1, 32767))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTPDatos, -2, 699, -2)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JSPPaleta, -2, 217, -2).addGap(271, 271, 271).addComponent(this.JLEstadoT, -2, 49, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBFinalizaTratramiento, -2, 50, -2).addContainerGap(-1, 32767)).addGroup(layout.createSequentialGroup().addComponent(this.JTPDatos, -2, 0, 32767).addContainerGap()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleOKeyPressed(KeyEvent evt) {
        if (this.JTDetalleO.getSelectedColumn() != 3 || evt.getKeyCode() == 10) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleOMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTAdicionarActionPerformed(ActionEvent evt) {
        if (this.JCBProcedimiento.getSelectedIndex() != -1) {
            this.xparteacum = this.JTANota.getText();
            System.out.println("Cantidad " + this.JTFFCantidad.getValue());
            if (!this.JTFFCantidad.getText().equals("0")) {
                if (Principal.informacionIps.getNombreIps().equals("FUNDACIÓN PANZENÚ")) {
                    System.out.println("Genera consentimiento?" + this.xprocedimiento[this.JCBProcedimiento.getSelectedIndex()][2].toString());
                    if (this.xprocedimiento[this.JCBProcedimiento.getSelectedIndex()][2].toString().equals("1")) {
                        verificarConsentimientoInformado(this.xprocedimiento[this.JCBProcedimiento.getSelectedIndex()][0]);
                    }
                }
                mAdicionarPTablaProc();
                String xparte1 = this.JCBProcedimiento.getSelectedItem() + ": ";
                String xparte2 = this.xprocedimiento[this.JCBProcedimiento.getSelectedIndex()][1] + "\n";
                this.JTANota.setText(xparte1 + xparte2 + "  -------------------------------------------------------------------------------------------------------------------------------------\n" + this.xparteacum);
                this.JTANota.setCaretPosition(0);
                this.xparteacum = this.JTANota.getText();
                mLimpiar();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "El valor de la cantidad no puede ser Cero o estar vacío", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFFCantidad.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un procedimiento", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JCBProcedimiento.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP1MouseClicked(MouseEvent evt) {
        mAsignarFigura(this.JP1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP2MouseClicked(MouseEvent evt) {
        mAsignarFigura(this.JP2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP3MouseClicked(MouseEvent evt) {
        mAsignarFigura(this.JP3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP4MouseClicked(MouseEvent evt) {
        mAsignarFigura(this.JP4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP5MouseClicked(MouseEvent evt) {
        mAsignarFigura(this.JP5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP6MouseClicked(MouseEvent evt) {
        mAsignarFigura(this.JP6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP7MouseClicked(MouseEvent evt) {
        mAsignarFigura(this.JP7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP8MouseClicked(MouseEvent evt) {
        mAsignarFigura(this.JP8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP9MouseClicked(MouseEvent evt) {
        mAsignarFigura(this.JP9);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP10MouseClicked(MouseEvent evt) {
        mAsignarFigura(this.JP10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP11MouseClicked(MouseEvent evt) {
        mAsignarFigura(this.JP11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP12MouseClicked(MouseEvent evt) {
        mAsignarFigura(this.JP12);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP13MouseClicked(MouseEvent evt) {
        mAsignarFigura(this.JP13);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP14MouseClicked(MouseEvent evt) {
        mAsignarFigura(this.JP14);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP15MouseClicked(MouseEvent evt) {
        mAsignarFigura(this.JP15);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP16MouseClicked(MouseEvent evt) {
        mAsignarFigura(this.JP16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP17MouseClicked(MouseEvent evt) {
        mAsignarFigura(this.JP17);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP18MouseClicked(MouseEvent evt) {
        mAsignarFigura(this.JP18);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP19MouseClicked(MouseEvent evt) {
        mAsignarFigura(this.JP19);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP20MouseClicked(MouseEvent evt) {
        mAsignarFigura(this.JP20);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP21MouseClicked(MouseEvent evt) {
        mAsignarFigura(this.JP21);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP22MouseClicked(MouseEvent evt) {
        mAsignarFigura(this.JP22);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP23MouseClicked(MouseEvent evt) {
        mAsignarFigura(this.JP23);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP24MouseClicked(MouseEvent evt) {
        mAsignarFigura(this.JP24);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP25MouseClicked(MouseEvent evt) {
        mAsignarFigura(this.JP25);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP26MouseClicked(MouseEvent evt) {
        mAsignarFigura(this.JP26);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP27MouseClicked(MouseEvent evt) {
        mAsignarFigura(this.JP27);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP28MouseClicked(MouseEvent evt) {
        mAsignarFigura(this.JP28);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP29MouseClicked(MouseEvent evt) {
        mAsignarFigura(this.JP29);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP30MouseClicked(MouseEvent evt) {
        mAsignarFigura(this.JP30);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP31MouseClicked(MouseEvent evt) {
        mAsignarFigura(this.JP31);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP32MouseClicked(MouseEvent evt) {
        mAsignarFigura(this.JP32);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBPlacaBActionPerformed(ActionEvent evt) {
        this.xnombreproceso = "Placa bacteriana";
        this.xCGeneral = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBExtraccionActionPerformed(ActionEvent evt) {
        this.xnombreproceso = "Extracción clinica";
        this.xCGeneral = 1L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBCoronaActionPerformed(ActionEvent evt) {
        this.xnombreproceso = "Corona";
        this.xCGeneral = 1L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBSinErupsionarActionPerformed(ActionEvent evt) {
        this.xnombreproceso = "Sin erupcionar";
        this.xCGeneral = 1L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBPuenteActionPerformed(ActionEvent evt) {
        this.xnombreproceso = "Puente";
        this.xCGeneral = 1L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBBorradorActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTProcedimientoKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 127) {
            mEliminarFilaGrid();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBFinalizaTratramientoActionPerformed(ActionEvent evt) {
        mFinalizaTratamiento();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTProcedimientoHKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP33MouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP34MouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP35MouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP36MouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP37MouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP38MouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP39MouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP40MouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP41MouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP42MouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP43MouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP44MouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP45MouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP46MouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP47MouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP48MouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP49MouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP50MouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP51MouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP52MouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP53MouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP54MouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP55MouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP56MouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP57MouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP58MouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP59MouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP60MouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP61MouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP62MouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP63MouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP64MouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTHistoricoMouseClicked(MouseEvent evt) {
        if (this.JTHistorico.getSelectedRow() != -1) {
            mTraerDatosDienteMarcadosHistorico();
            this.JLCarasPlacaH.setText(this.xmodeloH.getValueAt(this.JTHistorico.getSelectedRow(), 5).toString());
            this.JLCarasMarcadasH.setText(this.xmodeloH.getValueAt(this.JTHistorico.getSelectedRow(), 6).toString());
            this.JLPresentesH.setText(this.xmodeloH.getValueAt(this.JTHistorico.getSelectedRow(), 7).toString());
            this.JLIndiceOlearyH.setText(this.xmodeloH.getValueAt(this.JTHistorico.getSelectedRow(), 8).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTHistoricoNotasMouseClicked(MouseEvent evt) {
        if (this.JTHistoricoNotas.getSelectedRow() != -1) {
            this.JDCFecha.setDate(Date.valueOf(this.xModeloHNotas.getValueAt(this.JTHistoricoNotas.getSelectedRow(), 1).toString()));
            this.JTFFHora.setText(this.xModeloHNotas.getValueAt(this.JTHistoricoNotas.getSelectedRow(), 2).toString());
            this.JCBTipoNota.setSelectedItem(this.xModeloHNotas.getValueAt(this.JTHistoricoNotas.getSelectedRow(), 3).toString());
            this.JTANota.setText(this.xModeloHNotas.getValueAt(this.JTHistoricoNotas.getSelectedRow(), 4).toString());
            this.JTPNotas.setSelectedIndex(0);
        }
    }

    private void mCargarDx_Procedimientos() {
        mTraerDatosDienteMarcados();
    }

    private void mFinalizaTratamiento() {
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de Finalizar el tratamiento?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            String sql = "UPDATE `o_hc_tratamiento`SET `FPFin`='" + this.xmt.formatoAMD.format(this.xmt.getFechaActual()) + "' , `Estado`=0 WHERE  `Id`= '" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTratamiento() + "'";
            System.out.println("consulta de insercion " + sql);
            this.xct.ejecutarSQL(sql);
            this.xct.cerrarConexionBd();
            mVerificarTratamiento();
        }
    }

    public BufferedImage createImage(JPanel panel) {
        int w = panel.getWidth();
        int h = panel.getHeight();
        BufferedImage bi = new BufferedImage(w, h, 1);
        Graphics2D g = bi.createGraphics();
        panel.paint(g);
        return bi;
    }

    private void traerimagen() {
        File file = new File("C:\\Genoma\\OdontogramaInicial.png");
        try {
            ImageIO.write(createImage(this.JPImOdontograma), "png", file);
        } catch (IOException e) {
            System.out.println("Error al guardar archivo.");
        }
    }

    public void mNuevo() {
        mLlenaCombo();
        this.JTFFCantidad.setValue(0);
        this.JDCFecha.setDate(this.xmt.getFechaActual());
        this.JTFFHora.setValue(this.xmt.getFechaActual());
        this.JTANota.setText("");
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloTablaDx() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"IdDiente", "N°Diente", "Cara", "Proceso", "TCaracteristica"}) { // from class: Odontologia.JPControlPlaca.79
            Class[] types = {Integer.class, Long.class, String.class, String.class, Long.class};
            boolean[] canEdit = {false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalleO.setModel(this.xmodelo);
        this.JTDetalleO.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTDetalleO.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTDetalleO.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTDetalleO.getColumnModel().getColumn(1).setPreferredWidth(3);
        this.JTDetalleO.getColumnModel().getColumn(2).setPreferredWidth(25);
        this.JTDetalleO.getColumnModel().getColumn(3).setPreferredWidth(50);
        this.JTDetalleO.getColumnModel().getColumn(4).setPreferredWidth(3);
        this.JTDetalleO.getColumnModel().getColumn(4).setMinWidth(0);
        this.JTDetalleO.getColumnModel().getColumn(4).setMaxWidth(0);
        this.xnfilas = 0;
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloTablaHistorico() {
        this.xmodeloH = new DefaultTableModel(new Object[0], new String[]{"Cod. Tratamiento", "Fecha Inicio", "Fecha Fin", "Profesional", "Especialidad", "STenidas", "SNAplica", "SPresente", "Indice"}) { // from class: Odontologia.JPControlPlaca.80
            Class[] types = {Integer.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTHistorico.setModel(this.xmodeloH);
        this.JTHistorico.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTHistorico.getColumnModel().getColumn(1).setPreferredWidth(10);
        this.JTHistorico.getColumnModel().getColumn(2).setPreferredWidth(10);
        this.JTHistorico.getColumnModel().getColumn(3).setPreferredWidth(50);
        this.JTHistorico.getColumnModel().getColumn(4).setPreferredWidth(50);
        this.JTHistorico.getColumnModel().getColumn(5).setPreferredWidth(0);
        this.JTHistorico.getColumnModel().getColumn(5).setMinWidth(0);
        this.JTHistorico.getColumnModel().getColumn(5).setMaxWidth(0);
        this.JTHistorico.getColumnModel().getColumn(6).setPreferredWidth(0);
        this.JTHistorico.getColumnModel().getColumn(6).setMinWidth(0);
        this.JTHistorico.getColumnModel().getColumn(6).setMaxWidth(0);
        this.JTHistorico.getColumnModel().getColumn(7).setPreferredWidth(0);
        this.JTHistorico.getColumnModel().getColumn(7).setMinWidth(0);
        this.JTHistorico.getColumnModel().getColumn(7).setMaxWidth(0);
        this.JTHistorico.getColumnModel().getColumn(8).setPreferredWidth(0);
        this.JTHistorico.getColumnModel().getColumn(8).setMinWidth(0);
        this.JTHistorico.getColumnModel().getColumn(8).setMaxWidth(0);
    }

    private void mBuscarHistorico() {
        mCrearModeloTablaHistorico();
        String sql = "SELECT `o_hc_tratamiento`.`Id` , `o_hc_tratamiento`.`FInicio` , `o_hc_tratamiento`.`FPFin`  , `profesional1`.`NProfesional` , `profesional1`.`Especialidad` , `o_hc_tratamiento`.`SuperficiesT`  , `o_hc_tratamiento`.`SuperficiesNA`  , `o_hc_tratamiento`.`SuperficiesPre` , `o_hc_tratamiento`.`IndiceO`  FROM `o_controlp_tratamiento_detalle` INNER JOIN `baseserver`.`o_hc_tratamiento`  ON (`o_controlp_tratamiento_detalle`.`IdTratamiento` = `o_hc_tratamiento`.`Id`)  INNER JOIN `baseserver`.`h_atencion`   ON (`o_hc_tratamiento`.`Id_Atencion` = `h_atencion`.`Id`)  INNER JOIN `baseserver`.`profesional1`   ON (`o_hc_tratamiento`.`Id_Profesional` = `profesional1`.`Id_Persona`) AND (`o_hc_tratamiento`.`Id_Especialidad` = `profesional1`.`IdEspecialidad`)  INNER JOIN `baseserver`.`ingreso`   ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)   WHERE (`ingreso`.`Id_Usuario` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "') GROUP BY `o_hc_tratamiento`.`Id` ORDER BY `o_hc_tratamiento`.`Id` DESC";
        ConsultasMySQL xct = new ConsultasMySQL();
        ResultSet xrs = xct.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodeloH.addRow(this.xdatos);
                    this.xmodeloH.setValueAt(Integer.valueOf(xrs.getInt(1)), n, 0);
                    this.xmodeloH.setValueAt(xrs.getString(2), n, 1);
                    this.xmodeloH.setValueAt(xrs.getString(3), n, 2);
                    this.xmodeloH.setValueAt(xrs.getString(4), n, 3);
                    this.xmodeloH.setValueAt(xrs.getString(5), n, 4);
                    this.xmodeloH.setValueAt(xrs.getString(6), n, 5);
                    this.xmodeloH.setValueAt(xrs.getString(7), n, 6);
                    this.xmodeloH.setValueAt(xrs.getString(8), n, 7);
                    this.xmodeloH.setValueAt(xrs.getString(9), n, 8);
                    n++;
                }
            }
            xrs.close();
            xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPControlPlaca.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mAdicionarPTabla() {
        this.xmodelo.addRow(this.xdatos);
        this.xmodelo.setValueAt(Integer.valueOf(this.xdientegeneral), this.xnfilas, 0);
        this.xmodelo.setValueAt(this.xndiente, this.xnfilas, 1);
        this.xmodelo.setValueAt(this.xncara, this.xnfilas, 2);
        this.xmodelo.setValueAt(this.xnombreproceso, this.xnfilas, 3);
        this.xmodelo.setValueAt(Long.valueOf(this.xCGeneral), this.xnfilas, 4);
        this.xnfilas++;
        this.xcontrolFiguara = 0L;
    }

    public void mImprimir() {
        String[][] mparametros = new String[3][2];
        mparametros[0][0] = "idatencion1";
        mparametros[0][1] = Principal.clasehistoriace.xjifhistoriaclinica.JTFFNAtencion.getText();
        mparametros[1][0] = "SUBREPORT_DIR";
        mparametros[1][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
        mparametros[2][0] = "SUBREPORTFIRMA_DIR";
        mparametros[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
        if (Principal.informacionIps.getEsFpz().intValue() == 0) {
            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "H_HistoriaClinica_Evoluciones", mparametros);
        } else {
            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "H_HistoriaClinica_Evoluciones", mparametros);
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:Odontologia/JPControlPlaca$MiRender.class */
    public class MiRender extends DefaultTableCellRenderer {
        public MiRender() {
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (Long.valueOf(table.getValueAt(row, 5).toString()).longValue() == 0) {
                cell.setBackground(new Color(255, 102, 0));
            } else {
                cell.setBackground(new Color(133, 218, 160));
            }
            return cell;
        }
    }

    public void mAsignarFigura(JPanel xpanel) {
        if (Double.valueOf(xpanel.getMousePosition().distance(xpanel.getMousePosition().x, 0.0d)).doubleValue() >= 30.0d && Double.valueOf(xpanel.getMousePosition().distance(xpanel.getMousePosition().x, 0.0d)).doubleValue() <= 41.0d) {
            System.out.println("Cara Abajo");
            this.xladoGeneral = 3L;
            if (this.JTBBorrador.isSelected()) {
                mVerificaCGeneral(xpanel);
                mTraerDatosDiente(xpanel);
                mQuitarElementoOdontograma(xpanel);
                return;
            } else {
                if (!mVerificaProcedimientoenDiente(xpanel)) {
                    mRecorrePanel(xpanel, "3", this.xnombreproceso);
                    mCalculaFormula(xpanel);
                    mTraerDatosDiente(xpanel);
                    mAdicionarPTabla();
                    return;
                }
                return;
            }
        }
        if (Double.valueOf(xpanel.getMousePosition().distance(xpanel.getMousePosition().x, 0.0d)).doubleValue() >= 2.0d && Double.valueOf(xpanel.getMousePosition().distance(xpanel.getMousePosition().x, 0.0d)).doubleValue() <= 14.0d) {
            System.out.println("Cara Arriba");
            this.xladoGeneral = 1L;
            if (this.JTBBorrador.isSelected()) {
                mVerificaCGeneral(xpanel);
                mTraerDatosDiente(xpanel);
                mQuitarElementoOdontograma(xpanel);
                return;
            } else {
                if (!mVerificaProcedimientoenDiente(xpanel)) {
                    mRecorrePanel(xpanel, "1", this.xnombreproceso);
                    mCalculaFormula(xpanel);
                    mTraerDatosDiente(xpanel);
                    mAdicionarPTabla();
                    return;
                }
                return;
            }
        }
        if (Double.valueOf(xpanel.getMousePosition().distance(xpanel.getMousePosition().x, 0.0d)).doubleValue() >= 13.0d && Double.valueOf(xpanel.getMousePosition().distance(xpanel.getMousePosition().x, 0.0d)).doubleValue() <= 30.0d) {
            if (xpanel.getMousePosition().x >= 25 && xpanel.getMousePosition().x <= 40) {
                System.out.println("Cara Derecha");
                this.xladoGeneral = 2L;
                if (this.JTBBorrador.isSelected()) {
                    mVerificaCGeneral(xpanel);
                    mTraerDatosDiente(xpanel);
                    mQuitarElementoOdontograma(xpanel);
                    return;
                } else {
                    if (!mVerificaProcedimientoenDiente(xpanel)) {
                        mRecorrePanel(xpanel, "2", this.xnombreproceso);
                        mCalculaFormula(xpanel);
                        mTraerDatosDiente(xpanel);
                        mAdicionarPTabla();
                        return;
                    }
                    return;
                }
            }
            if (xpanel.getMousePosition().x >= 0 && xpanel.getMousePosition().x <= 14) {
                System.out.println("Cara Izquierda");
                this.xladoGeneral = 4L;
                if (this.JTBBorrador.isSelected()) {
                    mVerificaCGeneral(xpanel);
                    mTraerDatosDiente(xpanel);
                    mQuitarElementoOdontograma(xpanel);
                } else if (!mVerificaProcedimientoenDiente(xpanel)) {
                    mRecorrePanel(xpanel, "4", this.xnombreproceso);
                    mCalculaFormula(xpanel);
                    mTraerDatosDiente(xpanel);
                    mAdicionarPTabla();
                }
            }
        }
    }

    private void mRecorrePanel(JPanel xpanel, String xlado, String xprocedimiento) {
        String sql;
        try {
            if (this.xCGeneral == 0) {
                sql = " SELECT  `o_controlp_proceso`.`Id` , `o_controlp_proceso`.`Nbre` , `o_controlp_proceso`.`CGeneral`     , `o_controlp_figuras`.`Ruta`  , `o_controlp_figuras`.`Lado`  FROM `o_controlp_figuras` INNER JOIN `baseserver`.`o_controlp_proceso`  ON (`o_controlp_figuras`.`Id_cp_proceso` = `o_controlp_proceso`.`Id`) WHERE (`o_controlp_proceso`.`Nbre` ='" + xprocedimiento + "'   AND `o_controlp_figuras`.`Lado` ='" + xlado + "' and `o_controlp_proceso`.`CGeneral`=0)";
            } else {
                xlado = "1";
                sql = " SELECT  `o_controlp_proceso`.`Id` , `o_controlp_proceso`.`Nbre` , `o_controlp_proceso`.`CGeneral`     , `o_controlp_figuras`.`Ruta`  , `o_controlp_figuras`.`Lado`  FROM `o_controlp_figuras` INNER JOIN `baseserver`.`o_controlp_proceso`  ON (`o_controlp_figuras`.`Id_cp_proceso` = `o_controlp_proceso`.`Id`) WHERE (`o_controlp_proceso`.`Nbre` ='" + xprocedimiento + "'   AND `o_controlp_figuras`.`Lado` ='" + xlado + "' and `o_controlp_proceso`.`CGeneral`=1)";
                this.xsenialados = mCuentaSeniales(xpanel);
                for (int x = 0; x < xpanel.getComponentCount(); x++) {
                    if (xpanel.getComponent(x).getClass().getName().equals("javax.swing.JLabel")) {
                        JLabel xch = xpanel.getComponent(x);
                        if (!xch.getName().equals("0")) {
                            xch.setIcon((Icon) null);
                        }
                    }
                }
            }
            System.out.println("datos que entran " + xpanel + "-" + xlado + "-" + xprocedimiento + "sql: " + sql);
            ResultSet xrs = this.xct.traerRs(sql);
            if (xrs.next()) {
                xrs.first();
                String xruta = this.xmt.getDirectorioExportacion() + xrs.getString("Ruta").replace("\\", this.xmt.getBarra());
                int x2 = 0;
                while (true) {
                    if (x2 >= xpanel.getComponentCount()) {
                        break;
                    }
                    if (xpanel.getComponent(x2).getClass().getName().equals("javax.swing.JLabel")) {
                        JLabel xch2 = xpanel.getComponent(x2);
                        if (xch2.getName().equals(xlado)) {
                            xch2.setIcon(new ImageIcon(xruta));
                            break;
                        }
                    }
                    x2++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPControlPlaca.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private int mCuentaSeniales(JPanel xpanel) {
        int xresultado = 0;
        for (int x = 0; x < xpanel.getComponentCount(); x++) {
            if (xpanel.getComponent(x).getClass().getName().equals("javax.swing.JLabel")) {
                JLabel xch = xpanel.getComponent(x);
                if (!xch.getName().equals("0") && xch.getIcon() != null) {
                    xresultado++;
                }
            }
        }
        System.out.println("Señalados " + xresultado);
        return xresultado;
    }

    private void mTraerNotas() {
        String sql = "SELECT  `FechaNota` , `HoraNota` , `Descripcion` FROM `h_notasclinicas` WHERE (`Id_Atencion` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "')";
        ConsultasMySQL xct = new ConsultasMySQL();
        ResultSet xrs = xct.traerRs(sql);
        String xparte1 = "";
        try {
            if (xrs.next()) {
                xrs.beforeFirst();
                while (xrs.next()) {
                    xparte1 = xparte1 + xrs.getString("FechaNota") + " " + xrs.getString("HoraNota") + " " + xrs.getString("Descripcion") + "\n\n";
                }
            }
            this.JTANota.setText(xparte1);
            this.JTANota.setCaretPosition(0);
            xrs.close();
            xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPControlPlaca.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCalculaFormula(JPanel xpanel) {
        if (this.xCGeneral == 0) {
            this.xAcum++;
            this.JLCarasPlaca.setText("" + this.xAcum);
        } else {
            if (this.xsenialados != 0) {
                System.out.println("Entró a la condicion");
                this.xAcum -= this.xsenialados;
                this.JLCarasPlaca.setText("" + this.xAcum);
            } else {
                System.out.println("No Entró a la condicion");
            }
            this.xAcum2++;
            this.JLCarasMarcadas.setText("" + (this.xAcum2 * 4));
            this.JLPresentes.setText("" + (128 - (this.xAcum2 * 4)));
        }
        this.JLIndiceOleary.setText("" + Math.round((Double.parseDouble(this.JLCarasPlaca.getText().toString()) / Double.parseDouble(this.JLPresentes.getText().toString())) * 100.0d) + "%");
    }

    public void mQuitarElementoOdontograma(JPanel xpanel) {
        int x = 0;
        while (true) {
            if (x >= xpanel.getComponentCount()) {
                break;
            }
            if (xpanel.getComponent(x).getClass().getName().equals("javax.swing.JLabel")) {
                JLabel xch = xpanel.getComponent(x);
                if (xch.getName().equals(Long.valueOf(this.xladoGeneral).toString())) {
                    xch.setIcon((Icon) null);
                    System.out.println("Lado cuando quita elemento " + this.xladoGeneral);
                    break;
                }
            }
            x++;
        }
        if (this.JTDetalleO.getRowCount() > -1) {
            for (int i = 0; i < this.JTDetalleO.getRowCount(); i++) {
                System.out.println("---------valor de la posicion " + this.xmodelo.getValueAt(i, 0) + " diente general " + this.xdientegeneral);
                if (Integer.parseInt(this.xmodelo.getValueAt(i, 0).toString()) == this.xdientegeneral) {
                    if (Integer.parseInt(this.xmodelo.getValueAt(i, 4).toString()) == 0) {
                        this.xAcum--;
                        this.JLCarasPlaca.setText("" + this.xAcum);
                    } else {
                        this.xAcum2--;
                        this.JLCarasMarcadas.setText("" + (this.xAcum2 * 4));
                        this.JLPresentes.setText("" + (128 - (this.xAcum2 * 4)));
                    }
                    this.JLIndiceOleary.setText("" + Math.round((Double.parseDouble(this.JLCarasPlaca.getText().toString()) / Double.parseDouble(this.JLPresentes.getText().toString())) * 100.0d) + "%");
                    this.xmodelo.removeRow(i);
                    System.out.println("Diente cuando quita elemento " + this.xdientegeneral);
                    this.xnfilas--;
                }
            }
        }
    }

    private void mVerificaCGeneral(JPanel xpanel) {
        if (this.JTDetalleO.getRowCount() > -1 && 0 < this.JTDetalleO.getRowCount()) {
            System.out.println("Valor --- " + this.xmodelo.getValueAt(0, 1).toString() + " panel " + xpanel.getName());
            if (!this.xmodelo.getValueAt(0, 1).toString().equals(xpanel.getName()) || Integer.parseInt(this.xmodelo.getValueAt(0, 4).toString()) != 1) {
                if (this.xmodelo.getValueAt(0, 1).toString().equals(xpanel.getName()) && Integer.parseInt(this.xmodelo.getValueAt(0, 4).toString()) == 0) {
                    this.xCGeneral = 0L;
                    System.out.println("Si es 0");
                    return;
                }
                return;
            }
            this.xCGeneral = 1L;
            System.out.println("Si es 1");
        }
    }

    public void mLlenaCombo() {
        String sql;
        if (!Principal.informacionIps.getNombreIps().equals("FUNDACIÓN PANZENÚ")) {
            sql = "SELECT `g_procedimiento`.`Id` , `g_procedimiento`.`Nbre`, g_procedimiento.Preparacion  FROM `f_tarifaprocedimiento` INNER JOIN `baseserver`.`g_procedimiento`   ON (`f_tarifaprocedimiento`.`Id_Procedimiento` = `g_procedimiento`.`Id`)  WHERE (`g_procedimiento`.`EsOdontologico` =1  AND `g_procedimiento`.`Estado` =0 AND g_procedimiento.PyPodonto=1) GROUP BY `g_procedimiento`.`Id` ORDER BY `g_procedimiento`.`Nbre`";
            this.JCBProcedimiento.removeAllItems();
            this.xprocedimiento = this.xct.llenarComboyLista(sql, this.xprocedimiento, this.JCBProcedimiento, 3);
            this.JCBProcedimiento.setSelectedIndex(-1);
            this.xct.cerrarConexionBd();
        } else {
            sql = " SELECT `g_procedimiento`.`Id` , `g_procedimiento`.`Nbre`, g_procedimiento.Preparacion, IF(g_procedimientoxconsentimiento.`Id_TipoConsentimiento` IS NULL, FALSE, IF (`g_procedimientoxconsentimiento`.`Estado` = 1, TRUE , FALSE)) GeneraConsentimiento  FROM `f_tarifaprocedimiento` INNER JOIN `baseserver`.`g_procedimiento`   ON (`f_tarifaprocedimiento`.`Id_Procedimiento` = `g_procedimiento`.`Id`)  LEFT JOIN `g_procedimientoxconsentimiento` ON ( g_procedimientoxconsentimiento.`Id_Procedimiento` = g_procedimiento.`Id` ) WHERE (`g_procedimiento`.`EsOdontologico` =1  AND `g_procedimiento`.`Estado` =0 AND g_procedimiento.PyPodonto=1) GROUP BY `g_procedimiento`.`Id` ORDER BY `g_procedimiento`.`Nbre`";
            this.JCBProcedimiento.removeAllItems();
            this.xprocedimiento = this.xct.llenarComboyLista(sql, this.xprocedimiento, this.JCBProcedimiento, 4);
            this.JCBProcedimiento.setSelectedIndex(-1);
            this.xct.cerrarConexionBd();
        }
        System.out.println("Combo proc: " + sql);
        String sql2 = "SELECT `h_tiponota`.`Id` , `h_tiponota`.`Nbre` FROM `h_tiponota_especialidad` INNER JOIN  `h_tiponota`  ON (`h_tiponota_especialidad`.`Id_TipoNota` = `h_tiponota`.`Id`) WHERE (`h_tiponota_especialidad`.`Id_Especialidad` ='" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "' AND `h_tiponota_especialidad`.`Estado` =1) ORDER BY `h_tiponota`.`Nbre` ASC ";
        this.xidtiponota = this.xct.llenarCombo(sql2, this.xidtiponota, this.JCBTipoNota);
        this.JCBTipoNota.setSelectedIndex(-1);
        this.xct.cerrarConexionBd();
    }

    private void mTraerDatosDiente(JPanel xpanel) {
        String sql;
        try {
            if (this.xCGeneral == 0) {
                sql = "SELECT `o_controlp_diente_cara`.`Id` , `o_controlp_diente_cara`.`NDiente`  , `o_odontograma_caras`.`Nbre`  FROM `o_controlp_diente_cara` INNER JOIN `baseserver`.`o_odontograma_caras`  ON (`o_controlp_diente_cara`.`IdCara` = `o_odontograma_caras`.`Id`) WHERE (`o_controlp_diente_cara`.`NDiente` ='" + xpanel.getName() + "' AND `o_controlp_diente_cara`.`Lado` ='" + this.xladoGeneral + "' AND o_controlp_diente_cara.CGeneral=0 AND o_controlp_diente_cara.TipoOdon=0)";
            } else {
                this.xladoGeneral = 1L;
                sql = "SELECT `o_controlp_diente_cara`.`Id` , `o_controlp_diente_cara`.`NDiente`  , `o_odontograma_caras`.`Nbre`  FROM `o_controlp_diente_cara` INNER JOIN `baseserver`.`o_odontograma_caras`  ON (`o_controlp_diente_cara`.`IdCara` = `o_odontograma_caras`.`Id`) WHERE (`o_controlp_diente_cara`.`NDiente` ='" + xpanel.getName() + "' AND `o_controlp_diente_cara`.`Lado` ='" + this.xladoGeneral + "' AND o_controlp_diente_cara.CGeneral=1 AND o_controlp_diente_cara.TipoOdon=0)";
            }
            System.out.println("trae Dato dientes: " + sql);
            ResultSet xrs = this.xct.traerRs(sql);
            if (xrs.next()) {
                xrs.first();
                this.xdientegeneral = xrs.getInt(1);
                this.xndiente = xrs.getString(2);
                this.xncara = xrs.getString(3);
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPControlPlaca.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mTraerDatosDienteMarcados() {
        try {
            String sql = "SELECT  `o_controlp_diente_cara`.`NDiente` , `o_controlp_diente_cara`.`Lado`  , `o_controlp_tratamiento_detalle`.`Proceso` , `o_controlp_figuras`.`Ruta`  FROM `o_controlp_tratamiento_detalle` INNER JOIN `baseserver`.`o_controlp_diente_cara`  ON (`o_controlp_tratamiento_detalle`.`IdDienteCara` = `o_controlp_diente_cara`.`Id`)  INNER JOIN  `o_controlp_figuras`   ON (`o_controlp_diente_cara`.`Lado` = `o_controlp_figuras`.`Lado`) INNER JOIN  `o_controlp_proceso`  ON (`o_controlp_tratamiento_detalle`.`Proceso` = `o_controlp_proceso`.`Nbre`) AND (`o_controlp_figuras`.`Id_cp_proceso` = `o_controlp_proceso`.`Id`) WHERE (`o_controlp_tratamiento_detalle`.`IdTratamiento` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTratamiento() + "' AND o_controlp_diente_cara.TipoOdon=0)";
            ResultSet xrs = this.xct.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    for (int u = 0; u < this.JPImOdontograma.getComponentCount(); u++) {
                        if (this.JPImOdontograma.getComponent(u).getClass().getName().equals("javax.swing.JPanel")) {
                            JPanel xjp = this.JPImOdontograma.getComponent(u);
                            if (xjp.getName().equals(xrs.getString(1))) {
                                int x = 0;
                                while (true) {
                                    if (x >= xjp.getComponentCount()) {
                                        break;
                                    }
                                    if (xjp.getComponent(x).getClass().getName().equals("javax.swing.JLabel")) {
                                        JLabel xch = xjp.getComponent(x);
                                        if (xch.getName().equals(xrs.getString(2))) {
                                            xch.setIcon(new ImageIcon(this.xmt.getDirectorioExportacion() + xrs.getString("Ruta").replace("\\", this.xmt.getBarra())));
                                            break;
                                        }
                                    }
                                    x++;
                                }
                            }
                        }
                    }
                    n++;
                }
            }
            String sql2 = "SELECT  `SuperficiesT`  , `SuperficiesNA`  , `SuperficiesPre` , `IndiceO` , `Observacion` , `Estado` FROM `o_hc_tratamiento` WHERE (`Id` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTratamiento() + "')";
            ConsultasMySQL xct2 = new ConsultasMySQL();
            ResultSet xrs2 = xct2.traerRs(sql2);
            if (xrs2.next()) {
                xrs2.first();
                this.JLCarasPlaca.setText(xrs2.getString("SuperficiesT"));
                this.JLCarasMarcadas.setText(xrs2.getString("SuperficiesNA"));
                this.JLPresentes.setText(xrs2.getString("SuperficiesPre"));
                this.JLIndiceOleary.setText(xrs2.getString("IndiceO"));
                this.JTAObservacionDx.setText(xrs2.getString("Observacion"));
            }
            String sql3 = "SELECT `o_controlp_tratamiento_detalle`.`IdDienteCara` , `o_controlp_diente_cara`.`NDiente` , `o_odontograma_caras`.`Nbre` , `o_controlp_tratamiento_detalle`.`Proceso`, o_controlp_tratamiento_detalle.CGeneral  FROM `o_controlp_tratamiento_detalle` INNER JOIN `baseserver`.`o_controlp_diente_cara`   ON (`o_controlp_tratamiento_detalle`.`IdDienteCara` = `o_controlp_diente_cara`.`Id`)  INNER JOIN `baseserver`.`o_odontograma_caras`    ON (`o_controlp_diente_cara`.`IdCara` = `o_odontograma_caras`.`Id`)  WHERE (`o_controlp_tratamiento_detalle`.`IdTratamiento` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTratamiento() + "' AND o_controlp_diente_cara.TipoOdon=0) ORDER BY `o_controlp_diente_cara`.`NDiente`";
            ConsultasMySQL xct3 = new ConsultasMySQL();
            System.out.println("Prcedimientos aplicados en tratamiento ----> " + sql3);
            ResultSet xrs3 = xct3.traerRs(sql3);
            if (xrs3.next()) {
                this.xnfilas = 0;
                xrs3.beforeFirst();
                while (xrs3.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(Integer.valueOf(xrs3.getInt(1)), this.xnfilas, 0);
                    this.xmodelo.setValueAt(Long.valueOf(xrs3.getLong(2)), this.xnfilas, 1);
                    this.xmodelo.setValueAt(xrs3.getString(3), this.xnfilas, 2);
                    this.xmodelo.setValueAt(xrs3.getString(4), this.xnfilas, 3);
                    this.xmodelo.setValueAt(xrs3.getString(5), this.xnfilas, 4);
                    this.xnfilas++;
                }
            }
            String sql4 = "SELECT  `o_hc_tratamiento_procedimiento`.`IdProcedimiento` , `g_procedimiento`.`Nbre`  , `o_hc_tratamiento_procedimiento`.`Cantidad`  , `g_procedimiento`.`Preparacion`, o_hc_tratamiento_procedimiento.Estado  FROM `o_hc_tratamiento_procedimiento`   INNER JOIN `baseserver`.`g_procedimiento`    ON (`o_hc_tratamiento_procedimiento`.`IdProcedimiento` = `g_procedimiento`.`Id`)  WHERE (`o_hc_tratamiento_procedimiento`.`Id_Tratamiento` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTratamiento() + "' AND o_hc_tratamiento_procedimiento.Tipo=0) ORDER BY `g_procedimiento`.`Nbre`";
            ConsultasMySQL xct4 = new ConsultasMySQL();
            ResultSet xrs4 = xct4.traerRs(sql4);
            if (xrs4.next()) {
                this.xfilasproc = 0;
                xrs4.beforeFirst();
                while (xrs4.next()) {
                    this.xmodelopro.addRow(this.xdatos);
                    this.xmodelopro.setValueAt(Integer.valueOf(xrs4.getInt(1)), this.xfilasproc, 0);
                    this.xmodelopro.setValueAt(xrs4.getString(2), this.xfilasproc, 1);
                    this.xmodelopro.setValueAt(Long.valueOf(xrs4.getLong(3)), this.xfilasproc, 2);
                    this.xmodelopro.setValueAt(xrs4.getString(4), this.xfilasproc, 3);
                    this.xmodelopro.setValueAt(Boolean.valueOf(xrs4.getBoolean(5)), this.xfilasproc, 4);
                    this.xfilasproc++;
                }
            }
            xrs4.close();
            xrs3.close();
            xrs2.close();
            xrs.close();
            this.xct.cerrarConexionBd();
            xct2.cerrarConexionBd();
            xct3.cerrarConexionBd();
            xct4.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPControlPlaca.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mGrabar() {
        if (!mVerificarTratamiento()) {
            if (this.JCBTipoNota.getSelectedIndex() != -1) {
                int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n == 0) {
                    if (clasesHistoriaCE.informacionAgendaMedicaDTO.getTipoTratamiento().longValue() == 0) {
                        String sql2 = "UPDATE o_hc_tratamiento SET `SuperficiesT`='" + this.JLCarasPlaca.getText() + "'  , `SuperficiesNA`='" + this.JLCarasMarcadas.getText() + "'  , `SuperficiesPre`='" + this.JLPresentes.getText() + "' , `IndiceO`='" + this.JLIndiceOleary.getText() + "'  , `Observacion`='" + this.JTAObservacionDx.getText() + "'  WHERE o_hc_tratamiento.Id='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTratamiento() + "'";
                        System.out.println("consulta de actualizacion " + sql2);
                        this.xct.ejecutarSQL(sql2);
                        if (this.JTDetalleO.getRowCount() > -1) {
                            for (int y = 0; y < this.JTDetalleO.getRowCount(); y++) {
                                String sql = "insert into o_controlp_tratamiento_detalle(`IdTratamiento` , `IdDienteCara` , `Proceso`  ,CGeneral, `UsuarioS`) values ('" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTratamiento() + "','" + this.xmodelo.getValueAt(y, 0) + "','" + this.xmodelo.getValueAt(y, 3) + "','" + this.xmodelo.getValueAt(y, 4) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                                System.out.println("consulta de insercion " + sql);
                                this.xct.ejecutarSQL(sql);
                            }
                        }
                    }
                    if (this.JTProcedimiento.getRowCount() > -1) {
                        for (int y2 = 0; y2 < this.JTProcedimiento.getRowCount(); y2++) {
                            if (!Boolean.valueOf(this.xmodelopro.getValueAt(y2, 4).toString()).booleanValue()) {
                                String sql3 = "insert into o_hc_tratamiento_procedimiento(`Id_Tratamiento` , `IdProcedimiento` , `Cantidad` , `UsuarioS`) values ('" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTratamiento() + "','" + this.xmodelopro.getValueAt(y2, 0) + "','" + this.xmodelopro.getValueAt(y2, 2) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                                System.out.println("consulta de insercion " + sql3);
                                this.xct.ejecutarSQL(sql3);
                            }
                        }
                    }
                    String sql4 = "INSERT INTO h_notasclinicas (Id_Atencion,`Id_TipoNota`  , `FechaNota` , `HoraNota` , `Descripcion`  , `Id_Profesional` , `Id_Especialidad` , `Fecha`  , `UsuarioS`) VALUES ('" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "','" + this.xidtiponota[this.JCBTipoNota.getSelectedIndex()] + "','" + this.xmt.formatoAMD.format(this.JDCFecha.getDate()) + "','" + this.xmt.formatoH24.format(this.JTFFHora.getValue()) + "','" + this.JTANota.getText() + "','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "','" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "','" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                    System.out.println("consulta de insercion " + sql4);
                    this.xct.ejecutarSQL(sql4);
                    Principal.clasehistoriace.mCambiarEstadoHc(1);
                    Principal.clasehistoriace.mCambiarEstadoCita();
                    this.xct.cerrarConexionBd();
                    mCrearModeloTablaDx();
                    mModeloProcedimiento();
                    mCargarDx_Procedimientos();
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, " Seleccione un tipo de nota", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTPDatos.setSelectedIndex(1);
            this.JCBTipoNota.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, " No se puede Guardar la información \n Tratamiento Cerrado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    private void mLimpiar() {
        this.JCBProcedimiento.setSelectedIndex(-1);
        this.JTFFCantidad.setValue(0);
    }

    public void keyReleased(KeyEvent evt) {
        if (evt.getKeyCode() == 17) {
            System.out.println("Presionó Control");
        }
        System.out.println("Presionó " + evt.getKeyCode());
    }

    private boolean mVerificarTratamiento() {
        boolean xcerrado = false;
        String sql = "SELECT `Id` , `FPFin`  , `Estado` FROM `o_hc_tratamiento` WHERE (`Id` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTratamiento() + "')";
        try {
            ResultSet xrs = this.xct.traerRs(sql);
            if (xrs.next()) {
                xrs.first();
                if (xrs.getLong(3) == 0) {
                    xcerrado = true;
                }
            }
            if (!xcerrado) {
                this.JLEstadoT.setText("ACTIVO");
                this.JBFinalizaTratramiento.setEnabled(true);
            } else {
                this.JLEstadoT.setText("CERRADO");
                this.JBFinalizaTratramiento.setEnabled(false);
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPOdontograma.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return xcerrado;
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mModeloProcedimiento() {
        this.xmodelopro = new DefaultTableModel(new Object[0], new String[]{"Id", "Procedimiento", "Cantidad", "Observación", "Aplicado?"}) { // from class: Odontologia.JPControlPlaca.81
            Class[] types = {Integer.class, String.class, Long.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTProcedimiento.setModel(this.xmodelopro);
        this.JTProcedimiento.getColumnModel().getColumn(0).setPreferredWidth(50);
        this.JTProcedimiento.getColumnModel().getColumn(1).setPreferredWidth(200);
        this.JTProcedimiento.getColumnModel().getColumn(2).setPreferredWidth(10);
        this.JTProcedimiento.getColumnModel().getColumn(3).setPreferredWidth(200);
        this.JTProcedimiento.getColumnModel().getColumn(4).setPreferredWidth(15);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mModeloProcedimientoH() {
        this.xmodeloproH = new DefaultTableModel(new Object[0], new String[]{"Id", "Procedimiento", "Cantidad", "Observación", "Aplicado?"}) { // from class: Odontologia.JPControlPlaca.82
            Class[] types = {Integer.class, String.class, Long.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTProcedimientoH.setModel(this.xmodeloproH);
        this.JTProcedimientoH.getColumnModel().getColumn(0).setPreferredWidth(50);
        this.JTProcedimientoH.getColumnModel().getColumn(1).setPreferredWidth(200);
        this.JTProcedimientoH.getColumnModel().getColumn(2).setPreferredWidth(10);
        this.JTProcedimientoH.getColumnModel().getColumn(3).setPreferredWidth(200);
        this.JTProcedimientoH.getColumnModel().getColumn(4).setPreferredWidth(15);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mModeloHistoricoNotas() {
        this.xModeloHNotas = new DefaultTableModel(new Object[0], new String[]{"Id", "Fecha", "Hora", "Tipo de Nota", "Descripcion"}) { // from class: Odontologia.JPControlPlaca.83
            Class[] types = {Long.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTHistoricoNotas;
        JTable jTable2 = this.JTHistoricoNotas;
        jTable.setAutoResizeMode(0);
        this.JTHistoricoNotas.doLayout();
        this.JTHistoricoNotas.setModel(this.xModeloHNotas);
        this.JTHistoricoNotas.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.JTHistoricoNotas.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTHistoricoNotas.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTHistoricoNotas.getColumnModel().getColumn(3).setPreferredWidth(120);
        this.JTHistoricoNotas.getColumnModel().getColumn(4).setPreferredWidth(400);
    }

    private void mCargarTablaHistoricoNotas() {
        try {
            mModeloHistoricoNotas();
            String sql = "SELECT h_notasclinicas.Id, h_notasclinicas.`FechaNota` , h_notasclinicas.`HoraNota`, h_tiponota.`Nbre` AS TipoNota , h_notasclinicas.`Descripcion` \nFROM \nh_notasclinicas \nINNER JOIN `h_tiponota` ON (h_tiponota.`Id` = `h_notasclinicas`.`Id_TipoNota`)\nWHERE (`Id_Atencion` = '" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "')";
            ConsultasMySQL xct = new ConsultasMySQL();
            ResultSet xrs = xct.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xModeloHNotas.addRow(this.xdatoNotas);
                    this.xModeloHNotas.setValueAt(Long.valueOf(xrs.getLong("Id")), n, 0);
                    this.xModeloHNotas.setValueAt(xrs.getString("FechaNota"), n, 1);
                    this.xModeloHNotas.setValueAt(xrs.getString("HoraNota"), n, 2);
                    this.xModeloHNotas.setValueAt(xrs.getString("TipoNota"), n, 3);
                    this.xModeloHNotas.setValueAt(xrs.getString("Descripcion"), n, 4);
                    n++;
                }
            }
            xrs.close();
            xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPControlPlaca.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mAdicionarPTablaProc() {
        this.xmodelopro.addRow(this.xdatos);
        this.xmodelopro.setValueAt(this.xprocedimiento[this.JCBProcedimiento.getSelectedIndex()][0], this.xfilasproc, 0);
        this.xmodelopro.setValueAt(this.JCBProcedimiento.getSelectedItem(), this.xfilasproc, 1);
        this.xmodelopro.setValueAt(this.JTFFCantidad.getText(), this.xfilasproc, 2);
        this.xmodelopro.setValueAt(this.xprocedimiento[this.JCBProcedimiento.getSelectedIndex()][1], this.xfilasproc, 3);
        this.xmodelopro.setValueAt(false, this.xfilasproc, 4);
        this.xfilasproc++;
        this.xcontrolFiguara = 0L;
    }

    public void mEliminarFilaGrid() {
        if (this.xmt.getPregunta("Esta seguro de Eliminar el procedimiento?") == 0) {
            this.xmodelopro.removeRow(this.JTProcedimiento.getSelectedRow());
            this.xfilasproc--;
            this.xmt.mostrarMensaje("Procedimiento Eliminado");
        }
    }

    private boolean mVerificaProcedimientoenDiente(JPanel xpanel) {
        boolean xexiste = false;
        if (this.JTDetalleO.getRowCount() > -1) {
            System.out.println("Este es el diente General --> " + this.xdientegeneral);
            mTraerDatosDiente(xpanel);
            int i = 0;
            while (true) {
                if (i >= this.JTDetalleO.getRowCount()) {
                    break;
                }
                System.out.println("Id de la cara --- " + this.xmodelo.getValueAt(i, 0).toString());
                if (!this.xmodelo.getValueAt(i, 0).toString().equals(String.valueOf(this.xdientegeneral))) {
                    i++;
                } else {
                    xexiste = true;
                    System.out.println("existe un procedimiento igual");
                    break;
                }
            }
        }
        return xexiste;
    }

    private void mTraerDatosDienteMarcadosHistorico() {
        try {
            String sql = "SELECT  `o_controlp_diente_cara`.`NDiente` , `o_controlp_diente_cara`.`Lado`  , `o_controlp_tratamiento_detalle`.`Proceso` , `o_controlp_figuras`.`Ruta`  FROM `o_controlp_tratamiento_detalle` INNER JOIN `baseserver`.`o_controlp_diente_cara`  ON (`o_controlp_tratamiento_detalle`.`IdDienteCara` = `o_controlp_diente_cara`.`Id`)  INNER JOIN  `o_controlp_figuras`   ON (`o_controlp_diente_cara`.`Lado` = `o_controlp_figuras`.`Lado`) INNER JOIN  `o_controlp_proceso`  ON (`o_controlp_tratamiento_detalle`.`Proceso` = `o_controlp_proceso`.`Nbre`) AND (`o_controlp_figuras`.`Id_cp_proceso` = `o_controlp_proceso`.`Id`) WHERE (`o_controlp_tratamiento_detalle`.`IdTratamiento` ='" + this.xmodeloH.getValueAt(this.JTHistorico.getSelectedRow(), 0) + "' AND o_controlp_diente_cara.TipoOdon=0)";
            ResultSet xrs = this.xct.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    for (int u = 0; u < this.JPImOdontogramaHistorico.getComponentCount(); u++) {
                        if (this.JPImOdontogramaHistorico.getComponent(u).getClass().getName().equals("javax.swing.JPanel")) {
                            JPanel xjp = this.JPImOdontogramaHistorico.getComponent(u);
                            if (xjp.getName().equals(xrs.getString(1))) {
                                int x = 0;
                                while (true) {
                                    if (x >= xjp.getComponentCount()) {
                                        break;
                                    }
                                    if (xjp.getComponent(x).getClass().getName().equals("javax.swing.JLabel")) {
                                        JLabel xch = xjp.getComponent(x);
                                        if (xch.getName().equals(xrs.getString(2))) {
                                            xch.setIcon(new ImageIcon(this.xmt.getDirectorioExportacion() + xrs.getString("Ruta").replace("\\", this.xmt.getBarra())));
                                            break;
                                        }
                                    }
                                    x++;
                                }
                            }
                        }
                    }
                    n++;
                }
            }
            String sql4 = "SELECT  `o_hc_tratamiento_procedimiento`.`IdProcedimiento` , `g_procedimiento`.`Nbre`  , `o_hc_tratamiento_procedimiento`.`Cantidad`  , `g_procedimiento`.`Preparacion`, o_hc_tratamiento_procedimiento.Estado  FROM `o_hc_tratamiento_procedimiento`   INNER JOIN `baseserver`.`g_procedimiento`    ON (`o_hc_tratamiento_procedimiento`.`IdProcedimiento` = `g_procedimiento`.`Id`)  WHERE (`o_hc_tratamiento_procedimiento`.`Id_Tratamiento` ='" + this.xmodeloH.getValueAt(this.JTHistorico.getSelectedRow(), 0) + "' AND o_hc_tratamiento_procedimiento.Tipo=0) ORDER BY `g_procedimiento`.`Nbre`";
            ConsultasMySQL xct4 = new ConsultasMySQL();
            mModeloProcedimientoH();
            ResultSet xrs4 = xct4.traerRs(sql4);
            if (xrs4.next()) {
                int n2 = 0;
                xrs4.beforeFirst();
                while (xrs4.next()) {
                    this.xmodeloproH.addRow(this.xdatos);
                    this.xmodeloproH.setValueAt(Integer.valueOf(xrs4.getInt(1)), n2, 0);
                    this.xmodeloproH.setValueAt(xrs4.getString(2), n2, 1);
                    this.xmodeloproH.setValueAt(Long.valueOf(xrs4.getLong(3)), n2, 2);
                    this.xmodeloproH.setValueAt(xrs4.getString(4), n2, 3);
                    this.xmodeloproH.setValueAt(Boolean.valueOf(xrs4.getBoolean(5)), n2, 4);
                    n2++;
                }
            }
            xrs.close();
            xrs4.close();
            xct4.cerrarConexionBd();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPControlPlaca.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
