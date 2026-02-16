package PyP;

import General.Persona;
import Utilidades.ConsultasMySQL;
import Utilidades.CustomPopupMenuListener;
import Utilidades.JTextFieldValidator;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

/* JADX INFO: loaded from: GenomaP.jar:PyP/JIFRegistro4505.class */
public class JIFRegistro4505 extends JInternalFrame {
    public Persona xjppersona;
    private String[] xidV14;
    private String[] xidV15;
    private String[] xidV16;
    private String[] xidV17;
    private String[] xidV18;
    private String[] xidV19;
    private String[] xidV20;
    private String[] xidV21;
    private String[] xidV22;
    private String[] xidV23;
    private String[] xidV24;
    private String[] xidV25;
    private String[] xidV26;
    private String[] xidV27;
    private String[] xidV28;
    private String[] xidV35;
    private String[] xidV36;
    private String[] xidV37;
    private String[] xidV38;
    private String[] xidV39;
    private String[] xidV40;
    private String[] xidV41;
    private String[] xidV42;
    private String[] xidV43;
    private String[] xidV44;
    private String[] xidV45;
    private String[] xidV46;
    private String[] xidV47;
    private String[] xidV48;
    private String[] xidV54;
    private String[] xidV59;
    private String[] xidV60;
    private String[] xidV61;
    private String[] xidV70;
    private String[] xidV71;
    private String[] xidV77;
    private String[] xidV79;
    private String[] xidV81;
    private String[] xidV83;
    private String[] xidV85;
    private String[] xidV86;
    private String[] xidV88;
    private String[] xidV89;
    private String[] xidV94;
    private String[] xidV97;
    private String[] xidV101;
    private String[] xidV113;
    private String[] xidV114;
    private String[] xidV115;
    private String[] xidV116;
    private String[] xidV117;
    private boolean xlleno;
    private Vector xError;
    private DefaultTableModel xmodelo;
    private Object[] xdatos;
    private JPanel JPPersona;
    private JScrollPane JSPPanel1;
    private JScrollPane JSPPanel2;
    private JScrollPane JSPPanel3;
    private JTable JTLog;
    public JDateChooser V100;
    private JComboBox V101;
    private JFormattedTextField V102;
    public JDateChooser V103;
    private JFormattedTextField V104;
    public JDateChooser V105;
    public JDateChooser V106;
    private JFormattedTextField V107;
    public JDateChooser V108;
    private JFormattedTextField V109;
    public JDateChooser V110;
    public JDateChooser V111;
    public JDateChooser V112;
    private JComboBox V113;
    private JComboBox V114;
    private JComboBox V115;
    private JComboBox V116;
    private JComboBox V117;
    public JDateChooser V118;
    private JComboBox V14;
    private JComboBox V15;
    private JComboBox V16;
    private JComboBox V17;
    private JComboBox V18;
    private JComboBox V19;
    private JComboBox V20;
    private JComboBox V21;
    private JComboBox V22;
    private JComboBox V23;
    private JComboBox V24;
    private JComboBox V25;
    private JComboBox V26;
    private JComboBox V27;
    private JComboBox V28;
    public JDateChooser V29;
    public JTextFieldValidator V30;
    public JDateChooser V31;
    public JTextFieldValidator V32;
    public JDateChooser V33;
    private JFormattedTextField V34;
    private JComboBox V35;
    private JComboBox V36;
    private JComboBox V37;
    private JComboBox V38;
    private JComboBox V39;
    private JComboBox V40;
    private JComboBox V41;
    private JComboBox V42;
    private JComboBox V43;
    private JComboBox V44;
    private JComboBox V45;
    private JComboBox V46;
    private JComboBox V47;
    private JComboBox V48;
    public JDateChooser V49;
    public JDateChooser V50;
    public JDateChooser V51;
    public JDateChooser V52;
    public JDateChooser V53;
    private JComboBox V54;
    public JDateChooser V55;
    public JDateChooser V56;
    private JFormattedTextField V57;
    public JDateChooser V58;
    private JComboBox V59;
    private JComboBox V60;
    private JComboBox V61;
    public JDateChooser V62;
    public JDateChooser V63;
    public JDateChooser V64;
    public JDateChooser V65;
    public JDateChooser V66;
    public JDateChooser V67;
    public JDateChooser V68;
    public JDateChooser V69;
    private JComboBox V70;
    private JComboBox V71;
    public JDateChooser V72;
    public JDateChooser V73;
    private JFormattedTextField V74;
    public JDateChooser V75;
    public JDateChooser V76;
    private JComboBox V77;
    public JDateChooser V78;
    private JComboBox V79;
    public JDateChooser V80;
    private JComboBox V81;
    public JDateChooser V82;
    private JComboBox V83;
    public JDateChooser V84;
    private JComboBox V85;
    private JComboBox V86;
    public JDateChooser V87;
    private JComboBox V88;
    private JComboBox V89;
    private JFormattedTextField V90;
    public JDateChooser V91;
    private JFormattedTextField V92;
    public JDateChooser V93;
    private JComboBox V94;
    private JFormattedTextField V95;
    public JDateChooser V96;
    private JComboBox V97;
    private JFormattedTextField V98;
    public JDateChooser V99;
    private JButton jButton1;
    private JComboBox jComboBox8;
    private JLabel jLabel1;
    private JLabel jLabel10;
    private JLabel jLabel100;
    private JLabel jLabel101;
    private JLabel jLabel102;
    private JLabel jLabel103;
    private JLabel jLabel104;
    private JLabel jLabel105;
    private JLabel jLabel106;
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
    private JLabel jLabel77;
    private JLabel jLabel78;
    private JLabel jLabel79;
    private JLabel jLabel8;
    private JLabel jLabel80;
    private JLabel jLabel81;
    private JLabel jLabel82;
    private JLabel jLabel83;
    private JLabel jLabel84;
    private JLabel jLabel85;
    private JLabel jLabel86;
    private JLabel jLabel87;
    private JLabel jLabel88;
    private JLabel jLabel89;
    private JLabel jLabel9;
    private JLabel jLabel90;
    private JLabel jLabel91;
    private JLabel jLabel92;
    private JLabel jLabel93;
    private JLabel jLabel94;
    private JLabel jLabel95;
    private JLabel jLabel96;
    private JLabel jLabel97;
    private JLabel jLabel98;
    private JLabel jLabel99;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JScrollPane jScrollPane1;
    private ConsultasMySQL xct = new ConsultasMySQL();
    private Metodos xmt = new Metodos();

    public JIFRegistro4505() {
        this.xlleno = false;
        initComponents();
        mCargarPanelPersonas();
        this.xidV14 = mIniciarCombos(1, this.V14);
        this.xidV15 = mIniciarCombos(2, this.V15);
        this.xidV16 = mIniciarCombos(1, this.V16);
        this.xidV17 = mIniciarCombos(1, this.V17);
        this.xidV18 = mIniciarCombos(3, this.V18);
        this.xidV19 = mIniciarCombos(1, this.V19);
        this.xidV20 = mIniciarCombos(4, this.V20);
        this.xidV21 = mIniciarCombos(5, this.V21);
        this.xidV22 = mIniciarCombos(6, this.V22);
        this.xidV23 = mIniciarCombos(3, this.V23);
        this.xidV24 = mIniciarCombos(3, this.V24);
        this.xidV25 = mIniciarCombos(7, this.V25);
        this.xidV26 = mIniciarCombos(1, this.V26);
        this.xidV27 = mIniciarCombos(3, this.V27);
        this.xidV28 = mIniciarCombos(3, this.V28);
        this.V29.setDate(StringADate("01-01-1800"));
        this.V30.setText("999");
        this.V31.setDate(StringADate("01-01-1800"));
        this.V32.setText("999");
        this.V33.setDate(StringADate("01-01-1845"));
        this.V34.setText("0");
        this.xidV35 = mIniciarCombos(8, this.V35);
        this.xidV36 = mIniciarCombos(8, this.V36);
        this.xidV37 = mIniciarCombos(9, this.V37);
        this.xidV38 = mIniciarCombos(10, this.V38);
        this.xidV39 = mIniciarCombos(10, this.V39);
        this.xidV40 = mIniciarCombos(11, this.V40);
        this.xidV41 = mIniciarCombos(9, this.V41);
        this.xidV42 = mIniciarCombos(12, this.V42);
        this.xidV43 = mIniciarCombos(13, this.V43);
        this.xidV44 = mIniciarCombos(13, this.V44);
        this.xidV45 = mIniciarCombos(11, this.V45);
        this.xidV46 = mIniciarCombos(12, this.V46);
        this.xidV47 = mIniciarCombos(10, this.V47);
        this.xidV48 = mIniciarCombos(14, this.V48);
        this.V49.setDate(StringADate("01-01-1845"));
        this.V50.setDate(StringADate("01-01-1845"));
        this.V51.setDate(StringADate("01-01-1845"));
        this.V52.setDate(StringADate("01-01-1845"));
        this.V53.setDate(StringADate("01-01-1845"));
        this.xidV54 = mIniciarCombos(30, this.V54);
        this.V55.setDate(StringADate("01-01-1845"));
        this.V56.setDate(StringADate("01-01-1845"));
        this.V57.setText("0");
        this.V58.setDate(StringADate("01-01-1845"));
        this.xidV59 = mIniciarCombos(16, this.V59);
        this.xidV60 = mIniciarCombos(16, this.V60);
        this.xidV61 = mIniciarCombos(16, this.V61);
        this.V62.setDate(StringADate("01-01-1845"));
        this.V63.setDate(StringADate("01-01-1845"));
        this.V64.setDate(StringADate("01-01-1845"));
        this.V65.setDate(StringADate("01-01-1845"));
        this.V66.setDate(StringADate("01-01-1845"));
        this.V67.setDate(StringADate("01-01-1845"));
        this.V68.setDate(StringADate("01-01-1845"));
        this.V69.setDate(StringADate("01-01-1845"));
        this.xidV70 = mIniciarCombos(16, this.V70);
        this.xidV71 = mIniciarCombos(16, this.V71);
        this.V72.setDate(StringADate("01-01-1845"));
        this.V73.setDate(StringADate("01-01-1845"));
        this.V74.setText("0");
        this.V75.setDate(StringADate("01-01-1845"));
        this.V76.setDate(StringADate("01-01-1845"));
        this.xidV77 = mIniciarCombos(18, this.V77);
        this.V78.setDate(StringADate("01-01-1845"));
        this.xidV79 = mIniciarCombos(19, this.V79);
        this.V80.setDate(StringADate("01-01-1845"));
        this.xidV81 = mIniciarCombos(20, this.V81);
        this.V82.setDate(StringADate("01-01-1845"));
        this.xidV83 = mIniciarCombos(19, this.V83);
        this.V84.setDate(StringADate("01-01-1845"));
        this.xidV85 = mIniciarCombos(21, this.V85);
        this.xidV86 = mIniciarCombos(22, this.V86);
        this.V87.setDate(StringADate("01-01-1845"));
        this.xidV88 = mIniciarCombos(23, this.V88);
        this.xidV89 = mIniciarCombos(24, this.V89);
        this.V90.setText("0");
        this.V91.setDate(StringADate("01-01-1845"));
        this.V92.setText("0");
        this.V93.setDate(StringADate("01-01-1845"));
        this.xidV94 = mIniciarCombos(24, this.V94);
        this.V95.setText("0");
        this.V96.setDate(StringADate("01-01-1845"));
        this.xidV97 = mIniciarCombos(26, this.V97);
        this.V98.setText("0");
        this.V99.setDate(StringADate("01-01-1845"));
        this.V100.setDate(StringADate("01-01-1845"));
        this.xidV101 = mIniciarCombos(27, this.V101);
        this.V102.setText("0");
        this.V103.setDate(StringADate("01-01-1845"));
        this.V104.setText("0");
        this.V105.setDate(StringADate("01-01-1845"));
        this.V106.setDate(StringADate("01-01-1845"));
        this.V107.setText("0");
        this.V108.setDate(StringADate("01-01-1845"));
        this.V109.setText("0");
        this.V110.setDate(StringADate("01-01-1845"));
        this.V111.setDate(StringADate("01-01-1845"));
        this.V112.setDate(StringADate("01-01-1845"));
        this.xidV113 = mIniciarCombos(28, this.V113);
        this.xidV114 = mIniciarCombos(29, this.V114);
        this.xidV115 = mIniciarCombos(29, this.V115);
        this.xidV116 = mIniciarCombos(29, this.V116);
        this.xidV117 = mIniciarCombos(29, this.V117);
        this.V118.setDate(StringADate("01-01-1845"));
        this.xlleno = true;
    }

    private void mCargarPanelPersonas() {
        this.xjppersona = new Persona(this);
        this.xjppersona.setVisible(false);
        this.JPPersona.setVisible(false);
        this.xjppersona.setBounds(1, 1, 967, 160);
        this.JPPersona.add(this.xjppersona);
        this.JPPersona.setVisible(true);
        this.xjppersona.setVisible(true);
    }

    private Date StringADate(String fecha) {
        SimpleDateFormat formato_del_Texto = new SimpleDateFormat("dd-MM-yyyy");
        try {
            Date fechaE = formato_del_Texto.parse(fecha);
            return fechaE;
        } catch (ParseException e) {
            return null;
        }
    }

    private String[] mIniciarCombos(int xidTabla, JComboBox xcombo) {
        String sql = "SELECT   `Id`  , CONCAT(`Id`,' | ',`Nbre`) FROM `h_tablas_riesgo` WHERE (`TTabla` ='" + xidTabla + "' AND `Estado` =1) ORDER BY Id ASC;";
        xcombo.removeAllItems();
        String[] xidCombo = this.xct.llenarCombo(sql, null, xcombo);
        xcombo.setSelectedIndex(-1);
        this.xct.cerrarConexionBd();
        xcombo.addPopupMenuListener(new CustomPopupMenuListener(true, false));
        return xidCombo;
    }

    /* JADX WARN: Type inference failed for: r3v825, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jComboBox8 = new JComboBox();
        this.JPPersona = new JPanel();
        this.JSPPanel1 = new JScrollPane();
        this.jPanel1 = new JPanel();
        this.jLabel1 = new JLabel();
        this.V14 = new JComboBox();
        this.jLabel2 = new JLabel();
        this.V15 = new JComboBox();
        this.jLabel3 = new JLabel();
        this.V16 = new JComboBox();
        this.jLabel4 = new JLabel();
        this.V17 = new JComboBox();
        this.jLabel5 = new JLabel();
        this.V18 = new JComboBox();
        this.jLabel6 = new JLabel();
        this.V19 = new JComboBox();
        this.jLabel7 = new JLabel();
        this.V20 = new JComboBox();
        this.jLabel8 = new JLabel();
        this.V21 = new JComboBox();
        this.jLabel9 = new JLabel();
        this.V22 = new JComboBox();
        this.V23 = new JComboBox();
        this.jLabel10 = new JLabel();
        this.jLabel11 = new JLabel();
        this.V24 = new JComboBox();
        this.jLabel12 = new JLabel();
        this.V25 = new JComboBox();
        this.jLabel13 = new JLabel();
        this.V26 = new JComboBox();
        this.jLabel14 = new JLabel();
        this.V27 = new JComboBox();
        this.jLabel15 = new JLabel();
        this.V28 = new JComboBox();
        this.jLabel16 = new JLabel();
        this.V29 = new JDateChooser();
        this.V30 = new JTextFieldValidator();
        this.jLabel17 = new JLabel();
        this.jLabel18 = new JLabel();
        this.V31 = new JDateChooser();
        this.jLabel19 = new JLabel();
        this.V32 = new JTextFieldValidator();
        this.jLabel20 = new JLabel();
        this.V33 = new JDateChooser();
        this.V34 = new JFormattedTextField();
        this.jLabel21 = new JLabel();
        this.jLabel22 = new JLabel();
        this.V35 = new JComboBox();
        this.jLabel23 = new JLabel();
        this.V36 = new JComboBox();
        this.jLabel24 = new JLabel();
        this.V37 = new JComboBox();
        this.jLabel25 = new JLabel();
        this.V38 = new JComboBox();
        this.jLabel26 = new JLabel();
        this.V39 = new JComboBox();
        this.jLabel27 = new JLabel();
        this.V40 = new JComboBox();
        this.jLabel28 = new JLabel();
        this.V41 = new JComboBox();
        this.jLabel29 = new JLabel();
        this.V42 = new JComboBox();
        this.jLabel30 = new JLabel();
        this.V43 = new JComboBox();
        this.jLabel31 = new JLabel();
        this.V44 = new JComboBox();
        this.jLabel32 = new JLabel();
        this.V45 = new JComboBox();
        this.jLabel33 = new JLabel();
        this.V46 = new JComboBox();
        this.jLabel34 = new JLabel();
        this.V47 = new JComboBox();
        this.jLabel35 = new JLabel();
        this.V48 = new JComboBox();
        this.JSPPanel2 = new JScrollPane();
        this.jPanel2 = new JPanel();
        this.jLabel37 = new JLabel();
        this.V49 = new JDateChooser();
        this.jLabel38 = new JLabel();
        this.V50 = new JDateChooser();
        this.jLabel39 = new JLabel();
        this.V51 = new JDateChooser();
        this.jLabel40 = new JLabel();
        this.V52 = new JDateChooser();
        this.jLabel41 = new JLabel();
        this.V53 = new JDateChooser();
        this.jLabel42 = new JLabel();
        this.V54 = new JComboBox();
        this.jLabel43 = new JLabel();
        this.V55 = new JDateChooser();
        this.jLabel44 = new JLabel();
        this.V56 = new JDateChooser();
        this.V57 = new JFormattedTextField();
        this.jLabel45 = new JLabel();
        this.jLabel46 = new JLabel();
        this.V58 = new JDateChooser();
        this.jLabel47 = new JLabel();
        this.V59 = new JComboBox();
        this.jLabel48 = new JLabel();
        this.V60 = new JComboBox();
        this.jLabel49 = new JLabel();
        this.V61 = new JComboBox();
        this.jLabel50 = new JLabel();
        this.V62 = new JDateChooser();
        this.jLabel51 = new JLabel();
        this.V63 = new JDateChooser();
        this.V64 = new JDateChooser();
        this.jLabel52 = new JLabel();
        this.jLabel53 = new JLabel();
        this.V65 = new JDateChooser();
        this.jLabel54 = new JLabel();
        this.V66 = new JDateChooser();
        this.jLabel55 = new JLabel();
        this.V67 = new JDateChooser();
        this.V68 = new JDateChooser();
        this.jLabel56 = new JLabel();
        this.jLabel57 = new JLabel();
        this.V69 = new JDateChooser();
        this.jLabel58 = new JLabel();
        this.V70 = new JComboBox();
        this.jLabel59 = new JLabel();
        this.V71 = new JComboBox();
        this.jLabel60 = new JLabel();
        this.V72 = new JDateChooser();
        this.jLabel61 = new JLabel();
        this.V73 = new JDateChooser();
        this.jLabel62 = new JLabel();
        this.jLabel63 = new JLabel();
        this.V75 = new JDateChooser();
        this.V76 = new JDateChooser();
        this.jLabel64 = new JLabel();
        this.jLabel65 = new JLabel();
        this.V77 = new JComboBox();
        this.jLabel66 = new JLabel();
        this.V78 = new JDateChooser();
        this.jLabel67 = new JLabel();
        this.V79 = new JComboBox();
        this.jLabel68 = new JLabel();
        this.V80 = new JDateChooser();
        this.jLabel69 = new JLabel();
        this.V81 = new JComboBox();
        this.jLabel70 = new JLabel();
        this.V82 = new JDateChooser();
        this.jLabel71 = new JLabel();
        this.V83 = new JComboBox();
        this.V74 = new JFormattedTextField();
        this.JSPPanel3 = new JScrollPane();
        this.jPanel3 = new JPanel();
        this.jPanel4 = new JPanel();
        this.jLabel95 = new JLabel();
        this.V106 = new JDateChooser();
        this.jLabel96 = new JLabel();
        this.jLabel77 = new JLabel();
        this.V107 = new JFormattedTextField();
        this.jLabel76 = new JLabel();
        this.jLabel93 = new JLabel();
        this.V88 = new JComboBox();
        this.V104 = new JFormattedTextField();
        this.V87 = new JDateChooser();
        this.jLabel94 = new JLabel();
        this.jLabel75 = new JLabel();
        this.V105 = new JDateChooser();
        this.V86 = new JComboBox();
        this.V85 = new JComboBox();
        this.jLabel74 = new JLabel();
        this.V84 = new JDateChooser();
        this.jLabel73 = new JLabel();
        this.V108 = new JDateChooser();
        this.jLabel97 = new JLabel();
        this.V110 = new JDateChooser();
        this.jLabel99 = new JLabel();
        this.V111 = new JDateChooser();
        this.jLabel100 = new JLabel();
        this.V109 = new JFormattedTextField();
        this.jLabel98 = new JLabel();
        this.jLabel82 = new JLabel();
        this.V112 = new JDateChooser();
        this.V92 = new JFormattedTextField();
        this.jLabel81 = new JLabel();
        this.V93 = new JDateChooser();
        this.jLabel80 = new JLabel();
        this.jLabel78 = new JLabel();
        this.V90 = new JFormattedTextField();
        this.jLabel79 = new JLabel();
        this.V91 = new JDateChooser();
        this.V89 = new JComboBox();
        this.jLabel88 = new JLabel();
        this.V98 = new JFormattedTextField();
        this.jLabel86 = new JLabel();
        this.V97 = new JComboBox();
        this.V94 = new JComboBox();
        this.jLabel83 = new JLabel();
        this.V96 = new JDateChooser();
        this.jLabel85 = new JLabel();
        this.V95 = new JFormattedTextField();
        this.jLabel84 = new JLabel();
        this.jLabel72 = new JLabel();
        this.V103 = new JDateChooser();
        this.jLabel91 = new JLabel();
        this.jLabel92 = new JLabel();
        this.V99 = new JDateChooser();
        this.jLabel89 = new JLabel();
        this.V100 = new JDateChooser();
        this.jLabel87 = new JLabel();
        this.jLabel90 = new JLabel();
        this.V102 = new JFormattedTextField();
        this.V101 = new JComboBox();
        this.jLabel101 = new JLabel();
        this.V113 = new JComboBox();
        this.jLabel102 = new JLabel();
        this.V114 = new JComboBox();
        this.jLabel103 = new JLabel();
        this.V115 = new JComboBox();
        this.jLabel104 = new JLabel();
        this.V116 = new JComboBox();
        this.jLabel105 = new JLabel();
        this.V117 = new JComboBox();
        this.jLabel106 = new JLabel();
        this.V118 = new JDateChooser();
        this.jScrollPane1 = new JScrollPane();
        this.JTLog = new JTable();
        this.jButton1 = new JButton();
        this.jComboBox8.setFont(new Font("Arial", 1, 11));
        this.jComboBox8.setName("V19");
        this.jComboBox8.addActionListener(new ActionListener() { // from class: PyP.JIFRegistro4505.1
            public void actionPerformed(ActionEvent evt) {
                JIFRegistro4505.this.jComboBox8ActionPerformed(evt);
            }
        });
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("REGISTRO INDIVIDUAL DE 4505");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjifR4505");
        this.JPPersona.setMaximumSize(new Dimension(1000, 160));
        this.JPPersona.setMinimumSize(new Dimension(1000, 160));
        GroupLayout JPPersonaLayout = new GroupLayout(this.JPPersona);
        this.JPPersona.setLayout(JPPersonaLayout);
        JPPersonaLayout.setHorizontalGroup(JPPersonaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 0, 32767));
        JPPersonaLayout.setVerticalGroup(JPPersonaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 160, 32767));
        this.jLabel1.setFont(new Font("Arial", 1, 11));
        this.jLabel1.setText("14-Gestación");
        this.V14.setFont(new Font("Arial", 1, 11));
        this.V14.setName("V14");
        this.jLabel2.setFont(new Font("Arial", 1, 11));
        this.jLabel2.setText("15-Sífilis Gestacional o congénita");
        this.V15.setFont(new Font("Arial", 1, 11));
        this.V15.setName("V15");
        this.jLabel3.setFont(new Font("Arial", 1, 11));
        this.jLabel3.setText("16-HTA Inducida por la Gestación");
        this.V16.setFont(new Font("Arial", 1, 11));
        this.V16.setName("V16");
        this.V16.addActionListener(new ActionListener() { // from class: PyP.JIFRegistro4505.2
            public void actionPerformed(ActionEvent evt) {
                JIFRegistro4505.this.V16ActionPerformed(evt);
            }
        });
        this.jLabel4.setFont(new Font("Arial", 1, 11));
        this.jLabel4.setText("17-Hipotiroidismo Congénito");
        this.V17.setFont(new Font("Arial", 1, 11));
        this.V17.setName("V17");
        this.V17.addActionListener(new ActionListener() { // from class: PyP.JIFRegistro4505.3
            public void actionPerformed(ActionEvent evt) {
                JIFRegistro4505.this.V17ActionPerformed(evt);
            }
        });
        this.jLabel5.setFont(new Font("Arial", 1, 11));
        this.jLabel5.setText("18-Sintomático Respiratorio");
        this.V18.setFont(new Font("Arial", 1, 11));
        this.V18.setName("V18");
        this.V18.addActionListener(new ActionListener() { // from class: PyP.JIFRegistro4505.4
            public void actionPerformed(ActionEvent evt) {
                JIFRegistro4505.this.V18ActionPerformed(evt);
            }
        });
        this.jLabel6.setFont(new Font("Arial", 1, 11));
        this.jLabel6.setText("19-Tuberculosis Multidrogoresistente");
        this.V19.setFont(new Font("Arial", 1, 11));
        this.V19.setName("V19");
        this.V19.addActionListener(new ActionListener() { // from class: PyP.JIFRegistro4505.5
            public void actionPerformed(ActionEvent evt) {
                JIFRegistro4505.this.V19ActionPerformed(evt);
            }
        });
        this.jLabel7.setFont(new Font("Arial", 1, 11));
        this.jLabel7.setText("20-Lepra");
        this.V20.setFont(new Font("Arial", 1, 11));
        this.V20.setName("V20");
        this.V20.addActionListener(new ActionListener() { // from class: PyP.JIFRegistro4505.6
            public void actionPerformed(ActionEvent evt) {
                JIFRegistro4505.this.V20ActionPerformed(evt);
            }
        });
        this.jLabel8.setFont(new Font("Arial", 1, 11));
        this.jLabel8.setText("<html><p align=\"justify\">21-Obesidad o Desnutrición Proteico Calórica</p></html>");
        this.V21.setFont(new Font("Arial", 1, 11));
        this.V21.setName("V21");
        this.V21.addActionListener(new ActionListener() { // from class: PyP.JIFRegistro4505.7
            public void actionPerformed(ActionEvent evt) {
                JIFRegistro4505.this.V21ActionPerformed(evt);
            }
        });
        this.jLabel9.setFont(new Font("Arial", 1, 11));
        this.jLabel9.setText("22-Victima de maltrato");
        this.V22.setFont(new Font("Arial", 1, 11));
        this.V22.setName("V22");
        this.V22.addActionListener(new ActionListener() { // from class: PyP.JIFRegistro4505.8
            public void actionPerformed(ActionEvent evt) {
                JIFRegistro4505.this.V22ActionPerformed(evt);
            }
        });
        this.V23.setFont(new Font("Arial", 1, 11));
        this.V23.setName("V23");
        this.V23.addActionListener(new ActionListener() { // from class: PyP.JIFRegistro4505.9
            public void actionPerformed(ActionEvent evt) {
                JIFRegistro4505.this.V23ActionPerformed(evt);
            }
        });
        this.jLabel10.setFont(new Font("Arial", 1, 11));
        this.jLabel10.setText("23-Víctima de Violencia Sexual");
        this.jLabel11.setFont(new Font("Arial", 1, 11));
        this.jLabel11.setText("24-Infecciones de Trasmisión Sexual");
        this.V24.setFont(new Font("Arial", 1, 11));
        this.V24.setName("V24");
        this.V24.addActionListener(new ActionListener() { // from class: PyP.JIFRegistro4505.10
            public void actionPerformed(ActionEvent evt) {
                JIFRegistro4505.this.V24ActionPerformed(evt);
            }
        });
        this.jLabel12.setFont(new Font("Arial", 1, 11));
        this.jLabel12.setText("25-Enfermedad Mental");
        this.V25.setFont(new Font("Arial", 1, 11));
        this.V25.setName("V25");
        this.V25.addActionListener(new ActionListener() { // from class: PyP.JIFRegistro4505.11
            public void actionPerformed(ActionEvent evt) {
                JIFRegistro4505.this.V25ActionPerformed(evt);
            }
        });
        this.jLabel13.setFont(new Font("Arial", 1, 11));
        this.jLabel13.setText("26-Cáncer de Cérvix");
        this.V26.setFont(new Font("Arial", 1, 11));
        this.V26.setName("V26");
        this.V26.addActionListener(new ActionListener() { // from class: PyP.JIFRegistro4505.12
            public void actionPerformed(ActionEvent evt) {
                JIFRegistro4505.this.V26ActionPerformed(evt);
            }
        });
        this.jLabel14.setFont(new Font("Arial", 1, 11));
        this.jLabel14.setText("27-Cáncer de Seno");
        this.V27.setFont(new Font("Arial", 1, 11));
        this.V27.setName("V27");
        this.V27.addActionListener(new ActionListener() { // from class: PyP.JIFRegistro4505.13
            public void actionPerformed(ActionEvent evt) {
                JIFRegistro4505.this.V27ActionPerformed(evt);
            }
        });
        this.jLabel15.setFont(new Font("Arial", 1, 11));
        this.jLabel15.setText("28-Fluorosis Dental");
        this.V28.setFont(new Font("Arial", 1, 11));
        this.V28.setName("V28");
        this.V28.addActionListener(new ActionListener() { // from class: PyP.JIFRegistro4505.14
            public void actionPerformed(ActionEvent evt) {
                JIFRegistro4505.this.V28ActionPerformed(evt);
            }
        });
        this.jLabel16.setFont(new Font("Arial", 1, 11));
        this.jLabel16.setText("29-Fecha del Peso");
        this.V29.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.V29.setDateFormatString("dd/MM/yyyy");
        this.V29.setFont(new Font("Tahoma", 1, 12));
        this.V29.setName("V29");
        this.V29.addKeyListener(new KeyAdapter() { // from class: PyP.JIFRegistro4505.15
            public void keyPressed(KeyEvent evt) {
                JIFRegistro4505.this.V29KeyPressed(evt);
            }
        });
        this.V30.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.V30.setHorizontalAlignment(0);
        this.V30.setText("0");
        this.V30.setToolTipText("Peso en Kilogramos");
        this.V30.setExprecionRegular("^[0.0-9]*$");
        this.V30.setFocusAccelerator('C');
        this.V30.setFont(new Font("Arial", 1, 12));
        this.V30.setName("V30");
        this.jLabel17.setFont(new Font("Arial", 1, 11));
        this.jLabel17.setText("30-Peso en Kilogramos");
        this.jLabel18.setFont(new Font("Arial", 1, 11));
        this.jLabel18.setText("31-Fecha de la Talla");
        this.V31.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.V31.setDateFormatString("dd/MM/yyyy");
        this.V31.setFont(new Font("Tahoma", 1, 12));
        this.V31.setName("V31");
        this.V31.addKeyListener(new KeyAdapter() { // from class: PyP.JIFRegistro4505.16
            public void keyPressed(KeyEvent evt) {
                JIFRegistro4505.this.V31KeyPressed(evt);
            }
        });
        this.jLabel19.setFont(new Font("Arial", 1, 11));
        this.jLabel19.setText("32-Talla en Centímetros");
        this.V32.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.V32.setHorizontalAlignment(0);
        this.V32.setText("0");
        this.V32.setToolTipText("Talla Centimetros");
        this.V32.setExprecionRegular("^[0.0-9]*$");
        this.V32.setFocusAccelerator('C');
        this.V32.setFont(new Font("Arial", 1, 12));
        this.V32.setName("V32");
        this.jLabel20.setFont(new Font("Arial", 1, 11));
        this.jLabel20.setText("33-Fecha Probable de Parto");
        this.V33.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.V33.setDateFormatString("dd/MM/yyyy");
        this.V33.setFont(new Font("Tahoma", 1, 12));
        this.V33.setName("V33");
        this.V33.addKeyListener(new KeyAdapter() { // from class: PyP.JIFRegistro4505.17
            public void keyPressed(KeyEvent evt) {
                JIFRegistro4505.this.V33KeyPressed(evt);
            }
        });
        this.V34.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("##0"))));
        this.V34.setHorizontalAlignment(4);
        this.V34.setFont(new Font("Arial", 1, 11));
        this.jLabel21.setFont(new Font("Arial", 1, 11));
        this.jLabel21.setText("34-Edad Gestacional al Nacer");
        this.jLabel22.setFont(new Font("Arial", 1, 11));
        this.jLabel22.setText("35-BCG");
        this.V35.setFont(new Font("Arial", 1, 11));
        this.V35.setName("V35");
        this.jLabel23.setFont(new Font("Arial", 1, 11));
        this.jLabel23.setText("36-Hepatitis B menores de 1 año");
        this.V36.setFont(new Font("Arial", 1, 11));
        this.V36.setName("V36");
        this.jLabel24.setFont(new Font("Arial", 1, 11));
        this.jLabel24.setText("37-Pentavalente");
        this.V37.setFont(new Font("Arial", 1, 11));
        this.V37.setName("V37");
        this.jLabel25.setFont(new Font("Arial", 1, 11));
        this.jLabel25.setText("38-Polio");
        this.V38.setFont(new Font("Arial", 1, 11));
        this.V38.setName("V38");
        this.jLabel26.setFont(new Font("Arial", 1, 11));
        this.jLabel26.setText("39-DPT menores de 5 años");
        this.V39.setFont(new Font("Arial", 1, 11));
        this.V39.setName("V39");
        this.jLabel27.setFont(new Font("Arial", 1, 11));
        this.jLabel27.setText("40-Rotavirus");
        this.V40.setFont(new Font("Arial", 1, 11));
        this.V40.setName("V40");
        this.jLabel28.setFont(new Font("Arial", 1, 11));
        this.jLabel28.setText("41-Neumococo");
        this.V41.setFont(new Font("Arial", 1, 11));
        this.V41.setName("V41");
        this.jLabel29.setFont(new Font("Arial", 1, 11));
        this.jLabel29.setText("42-Influenza Niños");
        this.V42.setFont(new Font("Arial", 1, 11));
        this.V42.setName("V42");
        this.jLabel30.setFont(new Font("Arial", 1, 11));
        this.jLabel30.setText("43-Fiebre Amarilla niños de 1 año");
        this.V43.setFont(new Font("Arial", 1, 11));
        this.V43.setName("V43");
        this.jLabel31.setFont(new Font("Arial", 1, 11));
        this.jLabel31.setText("44-Hepatitis A");
        this.V44.setFont(new Font("Arial", 1, 11));
        this.V44.setName("V44");
        this.jLabel32.setFont(new Font("Arial", 1, 11));
        this.jLabel32.setText("45-Triple Viral Niños");
        this.V45.setFont(new Font("Arial", 1, 11));
        this.V45.setName("V45");
        this.jLabel33.setFont(new Font("Arial", 1, 11));
        this.jLabel33.setText("46-Virus del Papiloma Humano");
        this.V46.setFont(new Font("Arial", 1, 11));
        this.V46.setName("V46");
        this.jLabel34.setFont(new Font("Arial", 1, 11));
        this.jLabel34.setText("<html><p align=\"justify\">47-TD o TT Mujeres en Edad Fértil 15 a 49 años</p></html>");
        this.V47.setFont(new Font("Arial", 1, 11));
        this.V47.setName("V47");
        this.jLabel35.setFont(new Font("Arial", 1, 11));
        this.jLabel35.setText("48-Control de Placa Bacteriana");
        this.V48.setFont(new Font("Arial", 1, 11));
        this.V48.setName("V48");
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.jLabel8, GroupLayout.Alignment.LEADING, -2, 0, 32767).addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup().addGap(1, 1, 1).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel1).addComponent(this.jLabel2).addComponent(this.jLabel3).addComponent(this.jLabel4).addComponent(this.jLabel5))).addComponent(this.jLabel6, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.jLabel7, GroupLayout.Alignment.LEADING)).addComponent(this.jLabel9).addComponent(this.jLabel10).addComponent(this.jLabel12).addComponent(this.jLabel13).addComponent(this.jLabel14).addComponent(this.jLabel15).addComponent(this.jLabel16).addComponent(this.jLabel17).addComponent(this.jLabel18).addComponent(this.jLabel19).addComponent(this.jLabel20).addComponent(this.jLabel21).addComponent(this.jLabel22).addComponent(this.jLabel23).addComponent(this.jLabel24).addComponent(this.jLabel25).addComponent(this.jLabel26).addComponent(this.jLabel27).addComponent(this.jLabel28).addComponent(this.jLabel29).addComponent(this.jLabel31).addComponent(this.jLabel32).addComponent(this.jLabel33).addComponent(this.jLabel11).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.jLabel34, GroupLayout.Alignment.LEADING, -2, 0, 32767).addComponent(this.jLabel30, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addComponent(this.jLabel35)).addGap(3, 3, 3).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.V47, GroupLayout.Alignment.LEADING, 0, 111, 32767).addComponent(this.V46, GroupLayout.Alignment.LEADING, 0, 111, 32767).addComponent(this.V45, GroupLayout.Alignment.LEADING, 0, 111, 32767).addComponent(this.V44, GroupLayout.Alignment.LEADING, 0, 111, 32767).addComponent(this.V43, GroupLayout.Alignment.LEADING, 0, 111, 32767).addComponent(this.V42, GroupLayout.Alignment.LEADING, 0, 111, 32767).addComponent(this.V41, GroupLayout.Alignment.LEADING, 0, 111, 32767).addComponent(this.V40, GroupLayout.Alignment.LEADING, 0, 111, 32767).addComponent(this.V39, GroupLayout.Alignment.LEADING, 0, 111, 32767).addComponent(this.V38, GroupLayout.Alignment.LEADING, 0, 111, 32767).addComponent(this.V37, GroupLayout.Alignment.LEADING, 0, 111, 32767).addComponent(this.V36, GroupLayout.Alignment.LEADING, 0, 111, 32767).addComponent(this.V35, GroupLayout.Alignment.LEADING, 0, 111, 32767).addComponent(this.V34, GroupLayout.Alignment.LEADING, -1, 111, 32767).addComponent(this.V33, GroupLayout.Alignment.LEADING, -1, 111, 32767).addComponent(this.V32, -1, 111, 32767).addComponent(this.V31, -1, 111, 32767).addComponent(this.V30, GroupLayout.Alignment.LEADING, -1, 111, 32767).addComponent(this.V29, -1, 111, 32767).addComponent(this.V28, GroupLayout.Alignment.LEADING, 0, 111, 32767).addComponent(this.V27, GroupLayout.Alignment.LEADING, 0, 111, 32767).addComponent(this.V26, GroupLayout.Alignment.LEADING, 0, 111, 32767).addComponent(this.V25, GroupLayout.Alignment.LEADING, 0, 111, 32767).addComponent(this.V24, GroupLayout.Alignment.LEADING, 0, 111, 32767).addComponent(this.V23, GroupLayout.Alignment.LEADING, 0, 111, 32767).addComponent(this.V20, GroupLayout.Alignment.LEADING, 0, 111, 32767).addComponent(this.V19, GroupLayout.Alignment.LEADING, 0, 111, 32767).addComponent(this.V16, GroupLayout.Alignment.LEADING, 0, 111, 32767).addComponent(this.V17, GroupLayout.Alignment.LEADING, 0, 111, 32767).addComponent(this.V18, GroupLayout.Alignment.LEADING, 0, 111, 32767).addComponent(this.V21, GroupLayout.Alignment.LEADING, 0, 111, 32767).addComponent(this.V22, GroupLayout.Alignment.LEADING, 0, 111, 32767).addComponent(this.V48, 0, 111, 32767).addComponent(this.V14, GroupLayout.Alignment.LEADING, 0, 111, 32767).addComponent(this.V15, GroupLayout.Alignment.LEADING, 0, 111, 32767)).addGap(3, 3, 3)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(3, 3, 3).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel1).addComponent(this.V14, -2, -1, -2)).addGap(3, 3, 3).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel2).addComponent(this.V15, -2, -1, -2)).addGap(3, 3, 3).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel3).addComponent(this.V16, -2, -1, -2)).addGap(3, 3, 3).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel4).addComponent(this.V17, -2, -1, -2)).addGap(3, 3, 3).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel5).addComponent(this.V18, -2, -1, -2)).addGap(3, 3, 3).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel6).addComponent(this.V19, -2, -1, -2)).addGap(3, 3, 3).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel7).addComponent(this.V20, -2, -1, -2)).addGap(3, 3, 3).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jLabel8, -2, -1, -2).addGap(3, 3, 3).addComponent(this.jLabel9)).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.V21, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.V22, -2, -1, -2))).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(3, 3, 3).addComponent(this.V23, -2, -1, -2)).addGroup(jPanel1Layout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel10))).addGap(3, 3, 3).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel11).addComponent(this.V24, -2, -1, -2)).addGap(3, 3, 3).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel12).addComponent(this.V25, -2, -1, -2)).addGap(3, 3, 3).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel13).addComponent(this.V26, -2, -1, -2)).addGap(3, 3, 3).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel14).addComponent(this.V27, -2, -1, -2)).addGap(3, 3, 3).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel15).addComponent(this.V28, -2, -1, -2)).addGap(3, 3, 3).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel16).addComponent(this.V29, -2, 22, -2)).addGap(3, 3, 3).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.V30, -2, -1, -2).addComponent(this.jLabel17)).addGap(3, 3, 3).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel18).addComponent(this.V31, -2, 22, -2)).addGap(3, 3, 3).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.V32, -2, -1, -2).addComponent(this.jLabel19)).addGap(3, 3, 3).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel20).addComponent(this.V33, -2, 22, -2)).addGap(3, 3, 3).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.V34, -2, -1, -2).addComponent(this.jLabel21)).addGap(3, 3, 3).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel22).addComponent(this.V35, -2, -1, -2)).addGap(3, 3, 3).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel23).addComponent(this.V36, -2, -1, -2)).addGap(3, 3, 3).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel24).addComponent(this.V37, -2, -1, -2)).addGap(3, 3, 3).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel25).addComponent(this.V38, -2, -1, -2)).addGap(3, 3, 3).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel26).addComponent(this.V39, -2, -1, -2)).addGap(3, 3, 3).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel27).addComponent(this.V40, -2, -1, -2)).addGap(3, 3, 3).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel28).addComponent(this.V41, -2, -1, -2)).addGap(3, 3, 3).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel29).addComponent(this.V42, -2, -1, -2)).addGap(3, 3, 3).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel30).addComponent(this.V43, -2, -1, -2)).addGap(3, 3, 3).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel31).addComponent(this.V44, -2, -1, -2)).addGap(3, 3, 3).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel32).addComponent(this.V45, -2, -1, -2)).addGap(3, 3, 3).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel33).addComponent(this.V46, -2, -1, -2)).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(3, 3, 3).addComponent(this.jLabel34, -2, 34, -2)).addGroup(jPanel1Layout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.V47, -2, -1, -2))).addGap(3, 3, 3).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel35).addComponent(this.V48, -2, -1, -2)).addGap(0, 0, 0)));
        this.JSPPanel1.setViewportView(this.jPanel1);
        this.jLabel37.setFont(new Font("Arial", 1, 11));
        this.jLabel37.setText("49-Fecha atención parto o cesárea");
        this.V49.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.V49.setDateFormatString("dd/MM/yyyy");
        this.V49.setFont(new Font("Tahoma", 1, 12));
        this.V49.setName("V49");
        this.V49.addKeyListener(new KeyAdapter() { // from class: PyP.JIFRegistro4505.18
            public void keyPressed(KeyEvent evt) {
                JIFRegistro4505.this.V49KeyPressed(evt);
            }
        });
        this.jLabel38.setFont(new Font("Arial", 1, 11));
        this.jLabel38.setText("<html><p align=\"justify\">50-Fecha salida de la atención del parto o cesárea</p></html>");
        this.V50.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.V50.setDateFormatString("dd/MM/yyyy");
        this.V50.setFont(new Font("Tahoma", 1, 12));
        this.V50.setName("V50");
        this.V50.addKeyListener(new KeyAdapter() { // from class: PyP.JIFRegistro4505.19
            public void keyPressed(KeyEvent evt) {
                JIFRegistro4505.this.V50KeyPressed(evt);
            }
        });
        this.jLabel39.setFont(new Font("Arial", 1, 11));
        this.jLabel39.setText("<html><p align=\"justify\">51-Fecha de consejería en Lactancia Materna</p></html>");
        this.V51.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.V51.setDateFormatString("dd/MM/yyyy");
        this.V51.setFont(new Font("Tahoma", 1, 12));
        this.V51.setName("V51");
        this.V51.addKeyListener(new KeyAdapter() { // from class: PyP.JIFRegistro4505.20
            public void keyPressed(KeyEvent evt) {
                JIFRegistro4505.this.V51KeyPressed(evt);
            }
        });
        this.jLabel40.setFont(new Font("Arial", 1, 11));
        this.jLabel40.setText("52-Control Recién Nacido");
        this.V52.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.V52.setDateFormatString("dd/MM/yyyy");
        this.V52.setFont(new Font("Tahoma", 1, 12));
        this.V52.setName("V52");
        this.V52.addKeyListener(new KeyAdapter() { // from class: PyP.JIFRegistro4505.21
            public void keyPressed(KeyEvent evt) {
                JIFRegistro4505.this.V52KeyPressed(evt);
            }
        });
        this.jLabel41.setFont(new Font("Arial", 1, 11));
        this.jLabel41.setText("53-Planificación Familiar Primera vez");
        this.V53.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.V53.setDateFormatString("dd/MM/yyyy");
        this.V53.setFont(new Font("Tahoma", 1, 12));
        this.V53.setName("V29");
        this.V53.addKeyListener(new KeyAdapter() { // from class: PyP.JIFRegistro4505.22
            public void keyPressed(KeyEvent evt) {
                JIFRegistro4505.this.V53KeyPressed(evt);
            }
        });
        this.jLabel42.setFont(new Font("Arial", 1, 11));
        this.jLabel42.setText("54-Suministro de Mét. Anticonceptivo");
        this.V54.setFont(new Font("Arial", 1, 11));
        this.V54.setName("V14");
        this.V54.addItemListener(new ItemListener() { // from class: PyP.JIFRegistro4505.23
            public void itemStateChanged(ItemEvent evt) {
                JIFRegistro4505.this.V54ItemStateChanged(evt);
            }
        });
        this.jLabel43.setFont(new Font("Arial", 1, 11));
        this.jLabel43.setText("<html><p align=\"justify\">55-Fecha de consejería en Lactancia Materna</p></html>");
        this.V55.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.V55.setDateFormatString("dd/MM/yyyy");
        this.V55.setFont(new Font("Tahoma", 1, 12));
        this.V55.setName("V29");
        this.V55.addKeyListener(new KeyAdapter() { // from class: PyP.JIFRegistro4505.24
            public void keyPressed(KeyEvent evt) {
                JIFRegistro4505.this.V55KeyPressed(evt);
            }
        });
        this.jLabel44.setFont(new Font("Arial", 1, 11));
        this.jLabel44.setText("<html><p align=\"justify\">56-Control Prenatal de Primera vez</p></html>");
        this.V56.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.V56.setDateFormatString("dd/MM/yyyy");
        this.V56.setFont(new Font("Tahoma", 1, 12));
        this.V56.setName("V29");
        this.V56.addKeyListener(new KeyAdapter() { // from class: PyP.JIFRegistro4505.25
            public void keyPressed(KeyEvent evt) {
                JIFRegistro4505.this.V56KeyPressed(evt);
            }
        });
        this.V57.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("##0"))));
        this.V57.setHorizontalAlignment(4);
        this.V57.setFont(new Font("Arial", 1, 11));
        this.jLabel45.setFont(new Font("Arial", 1, 11));
        this.jLabel45.setText("<html><p align=\"justify\">57-Control Prenatal</p></html>");
        this.jLabel46.setFont(new Font("Arial", 1, 11));
        this.jLabel46.setText("<html><p align=\"justify\">58-Último Control Prenatal</p></html>");
        this.V58.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.V58.setDateFormatString("dd/MM/yyyy");
        this.V58.setFont(new Font("Tahoma", 1, 12));
        this.V58.setName("V29");
        this.V58.addKeyListener(new KeyAdapter() { // from class: PyP.JIFRegistro4505.26
            public void keyPressed(KeyEvent evt) {
                JIFRegistro4505.this.V58KeyPressed(evt);
            }
        });
        this.jLabel47.setFont(new Font("Arial", 1, 11));
        this.jLabel47.setText("<html><p align=\"justify\">59-Suministro de Ácido Fólico en el Último Control Prenatal</p></html>");
        this.V59.setFont(new Font("Arial", 1, 11));
        this.V59.setName("V14");
        this.V59.addItemListener(new ItemListener() { // from class: PyP.JIFRegistro4505.27
            public void itemStateChanged(ItemEvent evt) {
                JIFRegistro4505.this.V59ItemStateChanged(evt);
            }
        });
        this.jLabel48.setFont(new Font("Arial", 1, 11));
        this.jLabel48.setText("<html><p align=\"justify\">60-Suministro de Sulfato Ferroso en el Último Control Prenatal</p></html>");
        this.V60.setFont(new Font("Arial", 1, 11));
        this.V60.setName("V14");
        this.V60.addItemListener(new ItemListener() { // from class: PyP.JIFRegistro4505.28
            public void itemStateChanged(ItemEvent evt) {
                JIFRegistro4505.this.V60ItemStateChanged(evt);
            }
        });
        this.jLabel49.setFont(new Font("Arial", 1, 11));
        this.jLabel49.setText("<html><p align=\"justify\">61-Suministro de Carbonato de Calcio en el Último Control Prenatal</p></html>");
        this.V61.setFont(new Font("Arial", 1, 11));
        this.V61.setName("V14");
        this.V61.addItemListener(new ItemListener() { // from class: PyP.JIFRegistro4505.29
            public void itemStateChanged(ItemEvent evt) {
                JIFRegistro4505.this.V61ItemStateChanged(evt);
            }
        });
        this.jLabel50.setFont(new Font("Arial", 1, 11));
        this.jLabel50.setText("<html><p align=\"justify\">62-Valoración de la Agudeza Visual</p></html>");
        this.V62.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.V62.setDateFormatString("dd/MM/yyyy");
        this.V62.setFont(new Font("Tahoma", 1, 12));
        this.V62.setName("V29");
        this.V62.addKeyListener(new KeyAdapter() { // from class: PyP.JIFRegistro4505.30
            public void keyPressed(KeyEvent evt) {
                JIFRegistro4505.this.V62KeyPressed(evt);
            }
        });
        this.jLabel51.setFont(new Font("Arial", 1, 11));
        this.jLabel51.setText("<html><p align=\"justify\">63-Consulta por Oftalmología</p></html>");
        this.V63.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.V63.setDateFormatString("dd/MM/yyyy");
        this.V63.setFont(new Font("Tahoma", 1, 12));
        this.V63.setName("V29");
        this.V63.addKeyListener(new KeyAdapter() { // from class: PyP.JIFRegistro4505.31
            public void keyPressed(KeyEvent evt) {
                JIFRegistro4505.this.V63KeyPressed(evt);
            }
        });
        this.V64.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.V64.setDateFormatString("dd/MM/yyyy");
        this.V64.setFont(new Font("Tahoma", 1, 12));
        this.V64.setName("V29");
        this.V64.addKeyListener(new KeyAdapter() { // from class: PyP.JIFRegistro4505.32
            public void keyPressed(KeyEvent evt) {
                JIFRegistro4505.this.V64KeyPressed(evt);
            }
        });
        this.jLabel52.setFont(new Font("Arial", 1, 11));
        this.jLabel52.setText("<html><p align=\"justify\">64-Fecha Diagnóstico Desnutrición Proteico Calórica</p></html>");
        this.jLabel53.setFont(new Font("Arial", 1, 11));
        this.jLabel53.setText("<html><p align=\"justify\">65-Consulta Mujer o Menor Víctima del Maltrato</p></html>");
        this.V65.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.V65.setDateFormatString("dd/MM/yyyy");
        this.V65.setFont(new Font("Tahoma", 1, 12));
        this.V65.setName("V29");
        this.V65.addKeyListener(new KeyAdapter() { // from class: PyP.JIFRegistro4505.33
            public void keyPressed(KeyEvent evt) {
                JIFRegistro4505.this.V65KeyPressed(evt);
            }
        });
        this.jLabel54.setFont(new Font("Arial", 1, 11));
        this.jLabel54.setText("<html><p align=\"justify\">66-Consulta Víctimas de Violencia Sexual</p></html>");
        this.V66.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.V66.setDateFormatString("dd/MM/yyyy");
        this.V66.setFont(new Font("Tahoma", 1, 12));
        this.V66.setName("V29");
        this.V66.addKeyListener(new KeyAdapter() { // from class: PyP.JIFRegistro4505.34
            public void keyPressed(KeyEvent evt) {
                JIFRegistro4505.this.V66KeyPressed(evt);
            }
        });
        this.jLabel55.setFont(new Font("Arial", 1, 11));
        this.jLabel55.setText("<html><p align=\"justify\">67-Consulta Nutrición</p></html>");
        this.V67.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.V67.setDateFormatString("dd/MM/yyyy");
        this.V67.setFont(new Font("Tahoma", 1, 12));
        this.V67.setName("V29");
        this.V67.addKeyListener(new KeyAdapter() { // from class: PyP.JIFRegistro4505.35
            public void keyPressed(KeyEvent evt) {
                JIFRegistro4505.this.V67KeyPressed(evt);
            }
        });
        this.V68.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.V68.setDateFormatString("dd/MM/yyyy");
        this.V68.setFont(new Font("Tahoma", 1, 12));
        this.V68.setName("V29");
        this.V68.addKeyListener(new KeyAdapter() { // from class: PyP.JIFRegistro4505.36
            public void keyPressed(KeyEvent evt) {
                JIFRegistro4505.this.V68KeyPressed(evt);
            }
        });
        this.jLabel56.setFont(new Font("Arial", 1, 11));
        this.jLabel56.setText("<html><p align=\"justify\">68-Consulta de Psicología</p></html>");
        this.jLabel57.setFont(new Font("Arial", 1, 11));
        this.jLabel57.setText("<html><p align=\"justify\">69-Consulta de Crecimiento y Desarrollo Primera vez</p></html>");
        this.V69.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.V69.setDateFormatString("dd/MM/yyyy");
        this.V69.setFont(new Font("Tahoma", 1, 12));
        this.V69.setName("V29");
        this.V69.addKeyListener(new KeyAdapter() { // from class: PyP.JIFRegistro4505.37
            public void keyPressed(KeyEvent evt) {
                JIFRegistro4505.this.V69KeyPressed(evt);
            }
        });
        this.jLabel58.setFont(new Font("Arial", 1, 11));
        this.jLabel58.setText("<html><p align=\"justify\">70-Suministro de Sulfato Ferroso en la Última Consulta del Menor de 10 años</p></html>");
        this.V70.setFont(new Font("Arial", 1, 11));
        this.V70.setName("V14");
        this.V70.addItemListener(new ItemListener() { // from class: PyP.JIFRegistro4505.38
            public void itemStateChanged(ItemEvent evt) {
                JIFRegistro4505.this.V70ItemStateChanged(evt);
            }
        });
        this.jLabel59.setFont(new Font("Arial", 1, 11));
        this.jLabel59.setText("<html><p align=\"justify\">71-Suministro de Vitamina A en la Última Consulta del Menor de 10 años</p></html>");
        this.V71.setFont(new Font("Arial", 1, 11));
        this.V71.setName("V14");
        this.V71.addItemListener(new ItemListener() { // from class: PyP.JIFRegistro4505.39
            public void itemStateChanged(ItemEvent evt) {
                JIFRegistro4505.this.V71ItemStateChanged(evt);
            }
        });
        this.jLabel60.setFont(new Font("Arial", 1, 11));
        this.jLabel60.setText("<html><p align=\"justify\">72-Consulta de Joven Primera vez</p></html>");
        this.V72.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.V72.setDateFormatString("dd/MM/yyyy");
        this.V72.setFont(new Font("Tahoma", 1, 12));
        this.V72.setName("V29");
        this.V72.addKeyListener(new KeyAdapter() { // from class: PyP.JIFRegistro4505.40
            public void keyPressed(KeyEvent evt) {
                JIFRegistro4505.this.V72KeyPressed(evt);
            }
        });
        this.jLabel61.setFont(new Font("Arial", 1, 11));
        this.jLabel61.setText("<html><p align=\"justify\">73-Consulta de Adulto Primera vez</p></html>");
        this.V73.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.V73.setDateFormatString("dd/MM/yyyy");
        this.V73.setFont(new Font("Tahoma", 1, 12));
        this.V73.setName("V29");
        this.V73.addKeyListener(new KeyAdapter() { // from class: PyP.JIFRegistro4505.41
            public void keyPressed(KeyEvent evt) {
                JIFRegistro4505.this.V73KeyPressed(evt);
            }
        });
        this.jLabel62.setFont(new Font("Arial", 1, 11));
        this.jLabel62.setText("<html><p align=\"justify\">74-Preservativos entregados a pacientes con ITS</p></html>");
        this.jLabel63.setFont(new Font("Arial", 1, 11));
        this.jLabel63.setText("<html><p align=\"justify\">75-Asesoría Pre test Elisa para VIH</p></html>");
        this.V75.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.V75.setDateFormatString("dd/MM/yyyy");
        this.V75.setFont(new Font("Tahoma", 1, 12));
        this.V75.setName("V29");
        this.V75.addKeyListener(new KeyAdapter() { // from class: PyP.JIFRegistro4505.42
            public void keyPressed(KeyEvent evt) {
                JIFRegistro4505.this.V75KeyPressed(evt);
            }
        });
        this.V76.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.V76.setDateFormatString("dd/MM/yyyy");
        this.V76.setFont(new Font("Tahoma", 1, 12));
        this.V76.setName("V29");
        this.V76.addKeyListener(new KeyAdapter() { // from class: PyP.JIFRegistro4505.43
            public void keyPressed(KeyEvent evt) {
                JIFRegistro4505.this.V76KeyPressed(evt);
            }
        });
        this.jLabel64.setFont(new Font("Arial", 1, 11));
        this.jLabel64.setText("<html><p align=\"justify\">76-Asesoría Pos test Elisa para VIH</p></html>");
        this.jLabel65.setFont(new Font("Arial", 1, 11));
        this.jLabel65.setText("<html><p align=\"justify\">77-Paciente con Diagnóstico de: Ansiedad</p></html>");
        this.V77.setFont(new Font("Arial", 1, 11));
        this.V77.setName("V14");
        this.V77.addItemListener(new ItemListener() { // from class: PyP.JIFRegistro4505.44
            public void itemStateChanged(ItemEvent evt) {
                JIFRegistro4505.this.V77ItemStateChanged(evt);
            }
        });
        this.jLabel66.setFont(new Font("Arial", 1, 11));
        this.jLabel66.setText("<html><p align=\"justify\">78-Fecha Antígeno de Superficie Hepatitis B en Gestantes</p></html>");
        this.V78.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.V78.setDateFormatString("dd/MM/yyyy");
        this.V78.setFont(new Font("Tahoma", 1, 12));
        this.V78.setName("V29");
        this.V78.addKeyListener(new KeyAdapter() { // from class: PyP.JIFRegistro4505.45
            public void keyPressed(KeyEvent evt) {
                JIFRegistro4505.this.V78KeyPressed(evt);
            }
        });
        this.jLabel67.setFont(new Font("Arial", 1, 11));
        this.jLabel67.setText("<html><p align=\"justify\">79-Resultado Antígeno de Superficie Hepatitis B en Gestantes</p></html>");
        this.V79.setFont(new Font("Arial", 1, 11));
        this.V79.setName("V14");
        this.V79.addItemListener(new ItemListener() { // from class: PyP.JIFRegistro4505.46
            public void itemStateChanged(ItemEvent evt) {
                JIFRegistro4505.this.V79ItemStateChanged(evt);
            }
        });
        this.jLabel68.setFont(new Font("Arial", 1, 11));
        this.jLabel68.setText("<html><p align=\"justify\">80-Fecha Serología para Sífilis</p></html>");
        this.V80.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.V80.setDateFormatString("dd/MM/yyyy");
        this.V80.setFont(new Font("Tahoma", 1, 12));
        this.V80.setName("V29");
        this.V80.addKeyListener(new KeyAdapter() { // from class: PyP.JIFRegistro4505.47
            public void keyPressed(KeyEvent evt) {
                JIFRegistro4505.this.V80KeyPressed(evt);
            }
        });
        this.jLabel69.setFont(new Font("Arial", 1, 11));
        this.jLabel69.setText("<html><p align=\"justify\">81-Resultado Serología para Sífilis</p></html>");
        this.V81.setFont(new Font("Arial", 1, 11));
        this.V81.setName("V14");
        this.V81.addItemListener(new ItemListener() { // from class: PyP.JIFRegistro4505.48
            public void itemStateChanged(ItemEvent evt) {
                JIFRegistro4505.this.V81ItemStateChanged(evt);
            }
        });
        this.jLabel70.setFont(new Font("Arial", 1, 11));
        this.jLabel70.setText("<html><p align=\"justify\">82-Fecha de Toma de Elisa para VIH</p></html>");
        this.V82.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.V82.setDateFormatString("dd/MM/yyyy");
        this.V82.setFont(new Font("Tahoma", 1, 12));
        this.V82.setName("V29");
        this.V82.addKeyListener(new KeyAdapter() { // from class: PyP.JIFRegistro4505.49
            public void keyPressed(KeyEvent evt) {
                JIFRegistro4505.this.V82KeyPressed(evt);
            }
        });
        this.jLabel71.setFont(new Font("Arial", 1, 11));
        this.jLabel71.setText("<html><p align=\"justify\">83-Resultado Elisa para VIH</p></html>");
        this.V83.setFont(new Font("Arial", 1, 11));
        this.V83.setName("V14");
        this.V83.addItemListener(new ItemListener() { // from class: PyP.JIFRegistro4505.50
            public void itemStateChanged(ItemEvent evt) {
                JIFRegistro4505.this.V83ItemStateChanged(evt);
            }
        });
        this.V74.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("##0"))));
        this.V74.setHorizontalAlignment(4);
        this.V74.setFont(new Font("Arial", 1, 11));
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jLabel37).addComponent(this.jLabel38, -2, 0, 32767).addComponent(this.jLabel39, -1, 223, 32767)).addComponent(this.jLabel41).addComponent(this.jLabel40).addComponent(this.jLabel46, -2, 212, -2).addComponent(this.jLabel45, -2, 212, -2).addComponent(this.jLabel44, -2, 212, -2).addComponent(this.jLabel47, -2, 224, -2).addComponent(this.jLabel48, -2, 224, -2).addComponent(this.jLabel49, -2, 224, -2).addComponent(this.jLabel55, -2, 212, -2).addComponent(this.jLabel52, -2, 212, -2).addComponent(this.jLabel51, -2, 212, -2).addComponent(this.jLabel50, -2, 212, -2).addComponent(this.jLabel71, -2, 186, -2).addComponent(this.jLabel70, -2, 186, -2).addComponent(this.jLabel69, -2, 186, -2).addComponent(this.jLabel68, -2, 186, -2).addComponent(this.jLabel67, -2, 186, -2).addComponent(this.jLabel66, -2, 186, -2).addComponent(this.jLabel65, -2, 186, -2).addComponent(this.jLabel64, -2, 186, -2).addComponent(this.jLabel63, -2, 186, -2).addComponent(this.jLabel62, -2, 186, -2).addComponent(this.jLabel61, -2, 186, -2).addComponent(this.jLabel60, -2, 186, -2).addComponent(this.jLabel59, -2, 186, -2).addComponent(this.jLabel58, -2, 186, -2).addComponent(this.jLabel56, -2, 186, -2).addComponent(this.jLabel57, -2, 186, -2).addComponent(this.jLabel54, -2, 212, -2).addComponent(this.jLabel53, -2, 212, -2)).addGap(1, 1, 1).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.V67, -2, 111, -2).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.V68, -1, 111, 32767).addComponent(this.V76, -1, 111, 32767).addComponent(this.V77, 0, 111, 32767).addComponent(this.V78, -1, 111, 32767).addComponent(this.V79, 0, 111, 32767).addComponent(this.V80, -1, 111, 32767).addComponent(this.V81, 0, 111, 32767).addComponent(this.V82, -1, 111, 32767).addComponent(this.V83, 0, 111, 32767).addComponent(this.V49, -1, 111, 32767).addComponent(this.V50, -1, 111, 32767).addComponent(this.V51, -1, 111, 32767).addComponent(this.V57, -1, 111, 32767).addComponent(this.V58, -1, 111, 32767).addComponent(this.V59, 0, 111, 32767).addComponent(this.V60, 0, 111, 32767).addComponent(this.V61, 0, 111, 32767).addComponent(this.V62, -1, 111, 32767).addComponent(this.V63, -1, 111, 32767).addComponent(this.V64, -1, 111, 32767).addComponent(this.V65, -1, 111, 32767).addComponent(this.V70, 0, 111, 32767).addComponent(this.V69, -1, 111, 32767).addComponent(this.V71, 0, 111, 32767).addComponent(this.V73, -1, 111, 32767).addComponent(this.V72, -1, 111, 32767).addComponent(this.V74, -1, 111, 32767).addComponent(this.V75, -1, 111, 32767).addComponent(this.V66, -1, 111, 32767).addComponent(this.V56, -1, 111, 32767))).addGroup(jPanel2Layout.createSequentialGroup().addGap(1, 1, 1).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.V53, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.V52, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.V55, GroupLayout.Alignment.LEADING, -2, 110, -2)))).addGap(3, 3, 3)).addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.jLabel42, GroupLayout.Alignment.LEADING, -1, 212, 32767).addComponent(this.jLabel43, GroupLayout.Alignment.LEADING, -2, 0, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.V54, -2, 110, -2).addGap(0, 0, 32767)));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGap(3, 3, 3).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGap(128, 128, 128).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel42).addComponent(this.V54, -2, -1, -2))).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.V53, -2, 22, -2).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.jLabel37).addGap(11, 11, 11).addComponent(this.jLabel38, -2, -1, -2).addGap(3, 3, 3).addComponent(this.jLabel39, -2, -1, -2).addGap(3, 3, 3).addComponent(this.jLabel40).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel41)))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel43, -2, -1, -2).addGap(3, 3, 3).addComponent(this.jLabel44, -2, -1, -2).addGap(34, 34, 34).addComponent(this.jLabel46, -2, -1, -2).addGap(42, 42, 42).addComponent(this.jLabel48, -2, -1, -2)).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.V49, -2, 22, -2).addGap(3, 3, 3).addComponent(this.V50, -2, 22, -2).addGap(3, 3, 3).addComponent(this.V51, -2, 22, -2).addGap(3, 3, 3).addComponent(this.V52, -2, 22, -2).addGap(57, 57, 57).addComponent(this.V55, -2, 22, -2).addGap(3, 3, 3).addComponent(this.V56, -2, 22, -2).addGap(3, 3, 3).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.V57, -2, -1, -2).addComponent(this.jLabel45, -2, -1, -2)).addGap(3, 3, 3).addComponent(this.V58, -2, 22, -2).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGap(6, 6, 6).addComponent(this.jLabel47, -2, -1, -2)).addGroup(jPanel2Layout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.V59, -2, -1, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.V60, -2, -1, -2))).addGap(3, 3, 3).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel49, -2, -1, -2).addComponent(this.V61, -2, -1, -2)).addGap(3, 3, 3).addComponent(this.jLabel50, -2, -1, -2).addGap(14, 14, 14).addComponent(this.jLabel51, -2, -1, -2).addGap(14, 14, 14).addComponent(this.jLabel52, -2, -1, -2).addGap(3, 3, 3).addComponent(this.jLabel53, -2, -1, -2).addGap(3, 3, 3).addComponent(this.jLabel54, -2, -1, -2).addGap(3, 3, 3).addComponent(this.jLabel55, -2, -1, -2)).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.V62, -2, 22, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.V63, -2, 22, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.V64, -2, 22, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.V65, -2, 22, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.V66, -2, 22, -2).addGap(8, 8, 8).addComponent(this.V67, -2, 22, -2))).addGap(6, 6, 6).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.V68, -2, 22, -2).addComponent(this.jLabel56, -2, -1, -2)).addGap(3, 3, 3).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.V69, -2, 22, -2).addComponent(this.jLabel57, -2, -1, -2)).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel58, -2, 51, -2)).addGroup(jPanel2Layout.createSequentialGroup().addGap(15, 15, 15).addComponent(this.V70, -2, -1, -2))).addGap(3, 3, 3).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel59, -2, 51, -2).addGroup(jPanel2Layout.createSequentialGroup().addGap(9, 9, 9).addComponent(this.V71, -2, -1, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.V72, -2, 22, -2).addComponent(this.jLabel60, -2, -1, -2)).addGap(6, 6, 6).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.V73, -2, 22, -2).addComponent(this.jLabel61, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jLabel62, -2, -1, -2).addComponent(this.V74, -2, -1, -2)).addGap(6, 6, 6).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.V75, -2, 22, -2).addComponent(this.jLabel63, -2, -1, -2)).addGap(6, 6, 6).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.V76, -2, 22, -2).addComponent(this.jLabel64, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel65, -2, 51, -2).addGroup(jPanel2Layout.createSequentialGroup().addGap(9, 9, 9).addComponent(this.V77, -2, -1, -2))).addGap(6, 6, 6).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.V78, -2, 22, -2).addComponent(this.jLabel66, -2, -1, -2)).addGap(6, 6, 6).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel67, -2, 51, -2).addGroup(jPanel2Layout.createSequentialGroup().addGap(9, 9, 9).addComponent(this.V79, -2, -1, -2))).addGap(6, 6, 6).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.V80, -2, 22, -2).addComponent(this.jLabel68, -2, -1, -2)).addGap(6, 6, 6).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel69, -2, -1, -2).addComponent(this.V81, -2, -1, -2)).addGap(6, 6, 6).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.V82, -2, 22, -2).addComponent(this.jLabel70, -2, -1, -2)).addGap(6, 6, 6).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel71, -2, -1, -2).addComponent(this.V83, -2, -1, -2)).addContainerGap(-1, 32767)));
        this.JSPPanel2.setViewportView(this.jPanel2);
        this.jLabel95.setFont(new Font("Arial", 1, 11));
        this.jLabel95.setText("<html><p align=\"justify\">107-Creatinina</p></html>");
        this.V106.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.V106.setDateFormatString("dd/MM/yyyy");
        this.V106.setFont(new Font("Tahoma", 1, 12));
        this.V106.setName("V29");
        this.V106.addKeyListener(new KeyAdapter() { // from class: PyP.JIFRegistro4505.51
            public void keyPressed(KeyEvent evt) {
                JIFRegistro4505.this.V106KeyPressed(evt);
            }
        });
        this.jLabel96.setFont(new Font("Arial", 1, 11));
        this.jLabel96.setText("<html><p align=\"justify\">108-Fecha Hemoglobina Glicosilada</p></html>");
        this.jLabel77.setFont(new Font("Arial", 1, 11));
        this.jLabel77.setText("<html><p align=\"justify\">89-Calidad en la Muestra de Citología Cervicouterina</p></html>");
        this.V107.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("##0"))));
        this.V107.setHorizontalAlignment(4);
        this.V107.setFont(new Font("Arial", 1, 11));
        this.jLabel76.setFont(new Font("Arial", 1, 11));
        this.jLabel76.setText("<html><p align=\"justify\">88-Citología Cervico uterina Resultados según Bethesdal</p></html>");
        this.jLabel93.setFont(new Font("Arial", 1, 11));
        this.jLabel93.setText("<html><p align=\"justify\">105-Fecha de la Toma de Glicemia Basal</p></html>");
        this.V88.setFont(new Font("Arial", 1, 11));
        this.V88.setName("V14");
        this.V88.addItemListener(new ItemListener() { // from class: PyP.JIFRegistro4505.52
            public void itemStateChanged(ItemEvent evt) {
                JIFRegistro4505.this.V88ItemStateChanged(evt);
            }
        });
        this.V104.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("##0"))));
        this.V104.setHorizontalAlignment(4);
        this.V104.setFont(new Font("Arial", 1, 11));
        this.V87.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.V87.setDateFormatString("dd/MM/yyyy");
        this.V87.setFont(new Font("Tahoma", 1, 12));
        this.V87.setName("V29");
        this.V87.addKeyListener(new KeyAdapter() { // from class: PyP.JIFRegistro4505.53
            public void keyPressed(KeyEvent evt) {
                JIFRegistro4505.this.V87KeyPressed(evt);
            }
        });
        this.jLabel94.setFont(new Font("Arial", 1, 11));
        this.jLabel94.setText("<html><p align=\"justify\">106-Fecha Creatinina</p></html>");
        this.jLabel75.setFont(new Font("Arial", 1, 11));
        this.jLabel75.setText("87-Citología Cervico uterina");
        this.V105.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.V105.setDateFormatString("dd/MM/yyyy");
        this.V105.setFont(new Font("Tahoma", 1, 12));
        this.V105.setName("V29");
        this.V105.addKeyListener(new KeyAdapter() { // from class: PyP.JIFRegistro4505.54
            public void keyPressed(KeyEvent evt) {
                JIFRegistro4505.this.V105KeyPressed(evt);
            }
        });
        this.V86.setFont(new Font("Arial", 1, 11));
        this.V86.setName("V14");
        this.V86.addItemListener(new ItemListener() { // from class: PyP.JIFRegistro4505.55
            public void itemStateChanged(ItemEvent evt) {
                JIFRegistro4505.this.V86ItemStateChanged(evt);
            }
        });
        this.V85.setFont(new Font("Arial", 1, 11));
        this.V85.setName("V14");
        this.V85.addItemListener(new ItemListener() { // from class: PyP.JIFRegistro4505.56
            public void itemStateChanged(ItemEvent evt) {
                JIFRegistro4505.this.V85ItemStateChanged(evt);
            }
        });
        this.jLabel74.setFont(new Font("Arial", 1, 11));
        this.jLabel74.setText("86-Tamizaje CA de Cuello Uterino");
        this.V84.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.V84.setDateFormatString("dd/MM/yyyy");
        this.V84.setFont(new Font("Tahoma", 1, 12));
        this.V84.setName("V29");
        this.V84.addKeyListener(new KeyAdapter() { // from class: PyP.JIFRegistro4505.57
            public void keyPressed(KeyEvent evt) {
                JIFRegistro4505.this.V84KeyPressed(evt);
            }
        });
        this.jLabel73.setFont(new Font("Arial", 1, 11));
        this.jLabel73.setText("85-Resultado de TSH Neonatal");
        this.V108.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.V108.setDateFormatString("dd/MM/yyyy");
        this.V108.setFont(new Font("Tahoma", 1, 12));
        this.V108.setName("V29");
        this.V108.addKeyListener(new KeyAdapter() { // from class: PyP.JIFRegistro4505.58
            public void keyPressed(KeyEvent evt) {
                JIFRegistro4505.this.V108KeyPressed(evt);
            }
        });
        this.jLabel97.setFont(new Font("Arial", 1, 11));
        this.jLabel97.setText("<html><p align=\"justify\">109-Hemoglobina Glicosilada</p></html>");
        this.V110.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.V110.setDateFormatString("dd/MM/yyyy");
        this.V110.setFont(new Font("Tahoma", 1, 12));
        this.V110.setName("V29");
        this.V110.addKeyListener(new KeyAdapter() { // from class: PyP.JIFRegistro4505.59
            public void keyPressed(KeyEvent evt) {
                JIFRegistro4505.this.V110KeyPressed(evt);
            }
        });
        this.jLabel99.setFont(new Font("Arial", 1, 11));
        this.jLabel99.setText("<html><p align=\"justify\">111-Fecha Toma de HDL</p></html>");
        this.V111.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.V111.setDateFormatString("dd/MM/yyyy");
        this.V111.setFont(new Font("Tahoma", 1, 12));
        this.V111.setName("V29");
        this.V111.addKeyListener(new KeyAdapter() { // from class: PyP.JIFRegistro4505.60
            public void keyPressed(KeyEvent evt) {
                JIFRegistro4505.this.V111KeyPressed(evt);
            }
        });
        this.jLabel100.setFont(new Font("Arial", 1, 11));
        this.jLabel100.setText("<html><p align=\"justify\">112-Fecha Toma de Baciloscopia de Diagnóstico</p></html>");
        this.V109.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("##0"))));
        this.V109.setHorizontalAlignment(4);
        this.V109.setFont(new Font("Arial", 1, 11));
        this.jLabel98.setFont(new Font("Arial", 1, 11));
        this.jLabel98.setText("<html><p align=\"justify\">110-Fecha Toma de Microalbuminuria</p></html>");
        this.jLabel82.setFont(new Font("Arial", 1, 11));
        this.jLabel82.setText("94-Resultado de Biopsia Cervical");
        this.V112.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.V112.setDateFormatString("dd/MM/yyyy");
        this.V112.setFont(new Font("Tahoma", 1, 12));
        this.V112.setName("V29");
        this.V112.addKeyListener(new KeyAdapter() { // from class: PyP.JIFRegistro4505.61
            public void keyPressed(KeyEvent evt) {
                JIFRegistro4505.this.V112KeyPressed(evt);
            }
        });
        this.V92.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("##0"))));
        this.V92.setHorizontalAlignment(4);
        this.V92.setFont(new Font("Arial", 1, 11));
        this.jLabel81.setFont(new Font("Arial", 1, 11));
        this.jLabel81.setText("<html><p align=\"justify\">92-Código de habilitación IPS donde se toma Colposcopia</p></html>");
        this.V93.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.V93.setDateFormatString("dd/MM/yyyy");
        this.V93.setFont(new Font("Tahoma", 1, 12));
        this.V93.setName("V29");
        this.V93.addKeyListener(new KeyAdapter() { // from class: PyP.JIFRegistro4505.62
            public void keyPressed(KeyEvent evt) {
                JIFRegistro4505.this.V93KeyPressed(evt);
            }
        });
        this.jLabel80.setFont(new Font("Arial", 1, 11));
        this.jLabel80.setText("93-Fecha Biopsia Cervical");
        this.jLabel78.setFont(new Font("Arial", 1, 11));
        this.jLabel78.setText("<html><p align=\"justify\">90-Código de habilitación IPS donde se toma Citología Cervicouterina</p></html>");
        this.V90.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("##0"))));
        this.V90.setHorizontalAlignment(4);
        this.V90.setFont(new Font("Arial", 1, 11));
        this.jLabel79.setFont(new Font("Arial", 1, 11));
        this.jLabel79.setText("91-Fecha Colposcopia");
        this.V91.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.V91.setDateFormatString("dd/MM/yyyy");
        this.V91.setFont(new Font("Tahoma", 1, 12));
        this.V91.setName("V29");
        this.V91.addKeyListener(new KeyAdapter() { // from class: PyP.JIFRegistro4505.63
            public void keyPressed(KeyEvent evt) {
                JIFRegistro4505.this.V91KeyPressed(evt);
            }
        });
        this.V89.setFont(new Font("Arial", 1, 11));
        this.V89.setName("V14");
        this.V89.addItemListener(new ItemListener() { // from class: PyP.JIFRegistro4505.64
            public void itemStateChanged(ItemEvent evt) {
                JIFRegistro4505.this.V89ItemStateChanged(evt);
            }
        });
        this.jLabel88.setFont(new Font("Arial", 1, 11));
        this.jLabel88.setText("<html><p align=\"justify\">99-Fecha Toma Biopsia Seno por BACAF</p></html>");
        this.V98.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("##0"))));
        this.V98.setHorizontalAlignment(4);
        this.V98.setFont(new Font("Arial", 1, 11));
        this.jLabel86.setFont(new Font("Arial", 1, 11));
        this.jLabel86.setText("<html><p align=\"justify\">98-Código de habilitación IPS donde se toma Mamografía</p></html>");
        this.V97.setFont(new Font("Arial", 1, 11));
        this.V97.setName("V14");
        this.V97.addItemListener(new ItemListener() { // from class: PyP.JIFRegistro4505.65
            public void itemStateChanged(ItemEvent evt) {
                JIFRegistro4505.this.V97ItemStateChanged(evt);
            }
        });
        this.V94.setFont(new Font("Arial", 1, 11));
        this.V94.setName("V14");
        this.V94.addItemListener(new ItemListener() { // from class: PyP.JIFRegistro4505.66
            public void itemStateChanged(ItemEvent evt) {
                JIFRegistro4505.this.V94ItemStateChanged(evt);
            }
        });
        this.jLabel83.setFont(new Font("Arial", 1, 11));
        this.jLabel83.setText("<html><p align=\"justify\">95-Código de habilitación IPS donde se toma Biopsia Cervical</p></html>");
        this.V96.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.V96.setDateFormatString("dd/MM/yyyy");
        this.V96.setFont(new Font("Tahoma", 1, 12));
        this.V96.setName("V29");
        this.V96.addKeyListener(new KeyAdapter() { // from class: PyP.JIFRegistro4505.67
            public void keyPressed(KeyEvent evt) {
                JIFRegistro4505.this.V96KeyPressed(evt);
            }
        });
        this.jLabel85.setFont(new Font("Arial", 1, 11));
        this.jLabel85.setText("97-Resultado Mamografía");
        this.V95.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("##0"))));
        this.V95.setHorizontalAlignment(4);
        this.V95.setFont(new Font("Arial", 1, 11));
        this.jLabel84.setFont(new Font("Arial", 1, 11));
        this.jLabel84.setText("96-Fecha Mamografía");
        this.jLabel72.setFont(new Font("Arial", 1, 11));
        this.jLabel72.setText("84-Fecha TSH Neonatal");
        this.V103.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.V103.setDateFormatString("dd/MM/yyyy");
        this.V103.setFont(new Font("Tahoma", 1, 12));
        this.V103.setName("V29");
        this.V103.addKeyListener(new KeyAdapter() { // from class: PyP.JIFRegistro4505.68
            public void keyPressed(KeyEvent evt) {
                JIFRegistro4505.this.V103KeyPressed(evt);
            }
        });
        this.jLabel91.setFont(new Font("Arial", 1, 11));
        this.jLabel91.setText("<html><p align=\"justify\">103-Fecha Toma de Hemoglobina</p></html>");
        this.jLabel92.setFont(new Font("Arial", 1, 11));
        this.jLabel92.setText("<html><p align=\"justify\">104-Hemoglobina</p></html>");
        this.V99.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.V99.setDateFormatString("dd/MM/yyyy");
        this.V99.setFont(new Font("Tahoma", 1, 12));
        this.V99.setName("V29");
        this.V99.addKeyListener(new KeyAdapter() { // from class: PyP.JIFRegistro4505.69
            public void keyPressed(KeyEvent evt) {
                JIFRegistro4505.this.V99KeyPressed(evt);
            }
        });
        this.jLabel89.setFont(new Font("Arial", 1, 11));
        this.jLabel89.setText("<html><p align=\"justify\">100-Fecha Resultado Biopsia Seno</p></html>");
        this.V100.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.V100.setDateFormatString("dd/MM/yyyy");
        this.V100.setFont(new Font("Tahoma", 1, 12));
        this.V100.setName("V29");
        this.V100.addKeyListener(new KeyAdapter() { // from class: PyP.JIFRegistro4505.70
            public void keyPressed(KeyEvent evt) {
                JIFRegistro4505.this.V100KeyPressed(evt);
            }
        });
        this.jLabel87.setFont(new Font("Arial", 1, 11));
        this.jLabel87.setText("101-Resultado Biopsia Seno");
        this.jLabel90.setFont(new Font("Arial", 1, 11));
        this.jLabel90.setText("<html><p align=\"justify\">102-Código de habilitación IPS donde se toma Biopsia Seno</p></html>");
        this.V102.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("##0"))));
        this.V102.setHorizontalAlignment(4);
        this.V102.setFont(new Font("Arial", 1, 11));
        this.V101.setFont(new Font("Arial", 1, 11));
        this.V101.setName("V14");
        this.V101.addItemListener(new ItemListener() { // from class: PyP.JIFRegistro4505.71
            public void itemStateChanged(ItemEvent evt) {
                JIFRegistro4505.this.V101ItemStateChanged(evt);
            }
        });
        this.jLabel101.setFont(new Font("Arial", 1, 11));
        this.jLabel101.setText("113-Baciloscopia de Diagnóstico");
        this.V113.setFont(new Font("Arial", 1, 11));
        this.V113.setName("V14");
        this.V113.addItemListener(new ItemListener() { // from class: PyP.JIFRegistro4505.72
            public void itemStateChanged(ItemEvent evt) {
                JIFRegistro4505.this.V113ItemStateChanged(evt);
            }
        });
        this.jLabel102.setFont(new Font("Arial", 1, 11));
        this.jLabel102.setText("<html><p align=\"justify\">114-Tratamiento para Hipotiroidismo Congénito</p></html>");
        this.V114.setFont(new Font("Arial", 1, 11));
        this.V114.setName("V14");
        this.V114.addItemListener(new ItemListener() { // from class: PyP.JIFRegistro4505.73
            public void itemStateChanged(ItemEvent evt) {
                JIFRegistro4505.this.V114ItemStateChanged(evt);
            }
        });
        this.jLabel103.setFont(new Font("Arial", 1, 11));
        this.jLabel103.setText("<html><p align=\"justify\">115-Tratamiento para Sífilis gestacional</p></html>");
        this.V115.setFont(new Font("Arial", 1, 11));
        this.V115.setName("V14");
        this.V115.addItemListener(new ItemListener() { // from class: PyP.JIFRegistro4505.74
            public void itemStateChanged(ItemEvent evt) {
                JIFRegistro4505.this.V115ItemStateChanged(evt);
            }
        });
        this.jLabel104.setFont(new Font("Arial", 1, 11));
        this.jLabel104.setText("<html><p align=\"justify\">116-Tratamiento para Sífilis Congénita</p></html>");
        this.V116.setFont(new Font("Arial", 1, 11));
        this.V116.setName("V14");
        this.V116.addItemListener(new ItemListener() { // from class: PyP.JIFRegistro4505.75
            public void itemStateChanged(ItemEvent evt) {
                JIFRegistro4505.this.V116ItemStateChanged(evt);
            }
        });
        this.jLabel105.setFont(new Font("Arial", 1, 11));
        this.jLabel105.setText("<html><p align=\"justify\">117-Tratamiento para Lepra</p></html>");
        this.V117.setFont(new Font("Arial", 1, 11));
        this.V117.setName("V14");
        this.V117.addItemListener(new ItemListener() { // from class: PyP.JIFRegistro4505.76
            public void itemStateChanged(ItemEvent evt) {
                JIFRegistro4505.this.V117ItemStateChanged(evt);
            }
        });
        this.jLabel106.setFont(new Font("Arial", 1, 11));
        this.jLabel106.setText("<html><p align=\"justify\">118-Fecha de Terminación Tratamiento para Leishmaniasis</p></html>");
        this.V118.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.V118.setDateFormatString("dd/MM/yyyy");
        this.V118.setFont(new Font("Tahoma", 1, 12));
        this.V118.setName("V29");
        this.V118.addKeyListener(new KeyAdapter() { // from class: PyP.JIFRegistro4505.77
            public void keyPressed(KeyEvent evt) {
                JIFRegistro4505.this.V118KeyPressed(evt);
            }
        });
        GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
        this.jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addGap(2, 2, 2).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addComponent(this.jLabel85, -2, 173, -2).addGap(18, 18, 18).addComponent(this.V97, -2, 111, -2)).addComponent(this.jLabel90, -2, 162, -2).addComponent(this.jLabel87, -2, 174, -2).addGroup(jPanel4Layout.createSequentialGroup().addComponent(this.jLabel91, -2, 180, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.V103, -2, 114, -2)).addGroup(jPanel4Layout.createSequentialGroup().addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jLabel100, -2, 174, -2).addComponent(this.jLabel92, -2, 155, -2).addComponent(this.jLabel105).addComponent(this.jLabel104, -2, 0, 32767).addComponent(this.jLabel103, -2, 162, -2).addComponent(this.jLabel106, -2, 0, 32767).addComponent(this.jLabel102, -2, 0, 32767).addComponent(this.jLabel99, -2, 160, -2).addComponent(this.jLabel101, -1, 175, 32767)).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jLabel93, -2, 180, -2).addComponent(this.jLabel89, -2, 0, 32767).addComponent(this.jLabel88, -2, 183, -2)).addComponent(this.jLabel94, -2, 163, -2).addComponent(this.jLabel95, -2, 163, -2).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.jLabel96, GroupLayout.Alignment.LEADING, -2, 0, 32767).addComponent(this.jLabel97, GroupLayout.Alignment.LEADING, -2, 167, -2)).addComponent(this.jLabel98, -2, 176, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.V101, 0, -1, 32767).addComponent(this.V102, -1, 111, 32767).addComponent(this.V99, -2, 109, -2).addComponent(this.V100, -2, 109, -2).addComponent(this.V111, -1, -1, 32767).addComponent(this.V110, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addComponent(this.V109).addComponent(this.V108, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addComponent(this.V107, GroupLayout.Alignment.TRAILING).addComponent(this.V105, -1, -1, 32767).addComponent(this.V106, -1, -1, 32767).addComponent(this.V104, -1, 111, 32767).addComponent(this.V113, GroupLayout.Alignment.TRAILING, 0, -1, 32767).addComponent(this.V112, -1, -1, 32767).addComponent(this.V114, GroupLayout.Alignment.TRAILING, 0, -1, 32767).addComponent(this.V115, 0, -1, 32767).addComponent(this.V117, 0, -1, 32767).addComponent(this.V118, -1, -1, 32767)).addComponent(this.V116, GroupLayout.Alignment.TRAILING, -2, 111, -2))))).addGroup(jPanel4Layout.createSequentialGroup().addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel79).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jLabel78, -2, 185, -2).addComponent(this.jLabel77, -2, 185, -2).addComponent(this.jLabel81, -2, 185, -2).addComponent(this.jLabel82, -2, 185, -2).addComponent(this.jLabel83, -2, 185, -2)).addComponent(this.jLabel80).addComponent(this.jLabel84).addComponent(this.jLabel86, -2, 173, -2).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addGroup(jPanel4Layout.createSequentialGroup().addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel75, -2, 159, -2).addComponent(this.jLabel76, -2, 168, -2)).addGap(17, 17, 17)).addComponent(this.jLabel74, -2, 185, -2)).addComponent(this.jLabel73).addComponent(this.jLabel72)).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.V89, -2, 111, -2).addComponent(this.V90, -2, 111, -2).addComponent(this.V91, -2, 111, -2).addComponent(this.V92, -2, 111, -2).addComponent(this.V93, -2, 111, -2).addComponent(this.V94, -2, 111, -2).addComponent(this.V95, -2, 111, -2).addComponent(this.V96, -2, 111, -2).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.V86, 0, -1, 32767).addComponent(this.V87, -1, 109, 32767).addComponent(this.V88, 0, -1, 32767)))).addGroup(jPanel4Layout.createSequentialGroup().addGap(6, 6, 6).addComponent(this.V98, -2, 111, -2)).addGroup(jPanel4Layout.createSequentialGroup().addGap(2, 2, 2).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.V85, 0, -1, 32767).addComponent(this.V84, -1, 111, 32767)))))).addContainerGap()));
        jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addGap(3, 3, 3).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.V84, -2, 22, -2).addComponent(this.jLabel72)).addGap(3, 3, 3).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.V85, -2, -1, -2).addComponent(this.jLabel73)).addGap(3, 3, 3).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.V86, -2, -1, -2).addComponent(this.jLabel74)).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addGap(3, 3, 3).addComponent(this.jLabel75).addGap(8, 8, 8)).addGroup(GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.V87, -2, 22, -2))).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addGap(3, 3, 3).addComponent(this.jLabel76, -2, -1, -2)).addGroup(jPanel4Layout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.V88, -2, -1, -2))).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addGap(3, 3, 3).addComponent(this.jLabel77, -2, -1, -2).addGap(6, 6, 6).addComponent(this.jLabel78, -2, -1, -2).addGap(3, 3, 3).addComponent(this.jLabel79).addGap(8, 8, 8).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel81, -2, -1, -2).addComponent(this.V92, -2, -1, -2))).addGroup(jPanel4Layout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.V89, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.V90, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.V91, -2, 22, -2).addGap(41, 41, 41))).addGap(11, 11, 11).addComponent(this.jLabel80)).addGroup(jPanel4Layout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.V93, -2, 22, -2))).addGap(3, 3, 3).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel82).addComponent(this.V94, -2, -1, -2)).addGap(6, 6, 6).addComponent(this.jLabel83, -2, -1, -2).addGap(11, 11, 11).addComponent(this.jLabel84)).addGroup(GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup().addGap(34, 34, 34).addComponent(this.V95, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.V96, -2, 22, -2))).addGap(3, 3, 3).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel85).addComponent(this.V97, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel86, -2, -1, -2).addComponent(this.V98, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel88, -2, -1, -2).addComponent(this.V99, -2, 22, -2)).addGap(3, 3, 3).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.V100, -2, 22, -2).addComponent(this.jLabel89, -2, -1, -2)).addGap(3, 3, 3).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel87).addComponent(this.V101, -2, -1, -2)).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addGap(3, 3, 3).addComponent(this.jLabel90, -2, -1, -2)).addGroup(jPanel4Layout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.V102, -2, -1, -2))).addGap(3, 3, 3).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel91, -2, -1, -2).addComponent(this.V103, -2, 22, -2)).addGap(6, 6, 6).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addComponent(this.jLabel92, -2, -1, -2).addGap(3, 3, 3).addComponent(this.jLabel93, -2, -1, -2).addGap(9, 9, 9).addComponent(this.jLabel94, -2, -1, -2).addGap(14, 14, 14).addComponent(this.jLabel95, -2, -1, -2).addGap(6, 6, 6).addComponent(this.jLabel96, -2, -1, -2).addGap(3, 3, 3).addComponent(this.jLabel97, -2, -1, -2).addGap(9, 9, 9).addComponent(this.jLabel98, -2, -1, -2).addGap(3, 3, 3).addComponent(this.jLabel99, -2, -1, -2)).addGroup(jPanel4Layout.createSequentialGroup().addComponent(this.V104, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.V105, -2, 22, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.V106, -2, 22, -2).addGap(3, 3, 3).addComponent(this.V107, -2, -1, -2).addGap(3, 3, 3).addComponent(this.V108, -2, 22, -2).addGap(3, 3, 3).addComponent(this.V109, -2, -1, -2).addGap(3, 3, 3).addComponent(this.V110, -2, 22, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.V111, -2, 22, -2))).addGap(11, 11, 11).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addComponent(this.jLabel100, -2, -1, -2).addGap(3, 3, 3).addComponent(this.jLabel101).addGap(15, 15, 15).addComponent(this.jLabel102, -2, -1, -2).addGap(3, 3, 3).addComponent(this.jLabel103, -2, -1, -2)).addGroup(jPanel4Layout.createSequentialGroup().addComponent(this.V112, -2, 22, -2).addGap(3, 3, 3).addComponent(this.V113, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.V114, -2, -1, -2).addGap(18, 18, 18).addComponent(this.V115, -2, -1, -2))).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addGap(6, 6, 6).addComponent(this.jLabel104, -2, -1, -2).addGap(3, 3, 3)).addGroup(GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.V116, -2, -1, -2).addGap(18, 18, 18))).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel105, -2, -1, -2).addComponent(this.V117, -2, -1, -2)).addGap(9, 9, 9).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.V118, -2, 22, -2).addComponent(this.jLabel106, -2, -1, -2)).addContainerGap(-1, 32767)));
        GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
        this.jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addComponent(this.jPanel4, -2, -1, -2).addGap(0, 0, 0)));
        jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addComponent(this.jPanel4, -2, 1016, -2).addGap(0, 0, 32767)));
        this.JSPPanel3.setViewportView(this.jPanel3);
        this.JTLog.setFont(new Font("Arial", 1, 12));
        this.JTLog.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.jScrollPane1.setViewportView(this.JTLog);
        this.jButton1.setText("Valida");
        this.jButton1.addActionListener(new ActionListener() { // from class: PyP.JIFRegistro4505.78
            public void actionPerformed(ActionEvent evt) {
                JIFRegistro4505.this.jButton1ActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JPPersona, -2, 988, -2).addGroup(layout.createSequentialGroup().addComponent(this.JSPPanel1, -2, 354, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPPanel2, -2, 354, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPPanel3, -2, 321, -2)).addComponent(this.jScrollPane1))).addGroup(layout.createSequentialGroup().addGap(492, 492, 492).addComponent(this.jButton1))).addContainerGap(43, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JPPersona, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JSPPanel1, -1, 458, 32767).addComponent(this.JSPPanel2, -1, 458, 32767).addComponent(this.JSPPanel3, -2, 0, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jScrollPane1, -2, 126, -2).addGap(18, 18, 18).addComponent(this.jButton1).addContainerGap(14, 32767)));
        pack();
    }

    private boolean mValidar() {
        this.xError = new Vector();
        if (this.xidV14[this.V14.getSelectedIndex()].equals("1") && !this.xjppersona.getIdSexo().equals("F")) {
            this.xError.addElement("Campo 10 debe ser F si el campo 14 es igual a 1");
        }
        if (this.xidV14[this.V14.getSelectedIndex()].equals("1") && this.xjppersona.getEdad() < 9) {
            this.xError.addElement("La edad debe ser mayor a 9 si el campo 14 es igual a 1");
        }
        if (this.xidV15[this.V15.getSelectedIndex()].equals("1") && !this.xjppersona.getIdSexo().equals("F")) {
            this.xError.addElement("Campo 10 debe ser F si el campo 15 es igual a 1");
        }
        if (this.xidV15[this.V15.getSelectedIndex()].equals("1") && !this.xidV14[this.V14.getSelectedIndex()].equals("1")) {
            this.xError.addElement("Campo 14 debe ser 1 si el campo 15 es igual a 1");
        }
        if (this.xidV15[this.V15.getSelectedIndex()].equals("2") && Integer.parseInt(this.xmt.entregarEdadEnMeses(this.xmt.formatoAMD.format(this.xjppersona.cboFechaNacimiento.getDate()))) > 9) {
            System.out.println("Edad Meses-->" + this.xmt.entregarEdadEnMeses(this.xmt.formatoAMD.format(this.xjppersona.cboFechaNacimiento.getDate())));
            this.xError.addElement("La edad debe ser menor a 9 meses si el campo 15 es igual a 2");
        }
        if (this.xidV16[this.V16.getSelectedIndex()].equals("1") && !this.xjppersona.getIdSexo().equals("F")) {
            this.xError.addElement("Campo 10 debe ser F si el campo 16 es igual a 1");
        }
        if (this.xidV16[this.V16.getSelectedIndex()].equals("1") && !this.xidV14[this.V14.getSelectedIndex()].equals("1")) {
            this.xError.addElement("Campo 14 debe ser 1 si el campo 16 es igual a 1");
        }
        if (this.xidV17[this.V17.getSelectedIndex()].equals("1") && Integer.parseInt(this.xmt.entregarEdadEnMeses(this.xmt.formatoAMD.format(this.xjppersona.cboFechaNacimiento.getDate()))) > 36) {
            this.xError.addElement("La edad debe ser menor a 36 meses si el campo 17 es igual a 1");
        }
        if (this.xidV21[this.V21.getSelectedIndex()].equals("1") && this.xjppersona.getEdad() > 18 && mCalculaIMC() < 30.0d) {
            this.xError.addElement("IMC debe ser mayor o igual a 30 si campo 21 es igual 1 y edad mayor a 18 años");
        }
        if (this.xidV22[this.V22.getSelectedIndex()].equals("1") && !this.xjppersona.getIdSexo().equals("F")) {
            this.xError.addElement("Campo 10 debe ser F si el campo 22 es igual a 1");
        }
        if (this.xidV22[this.V22.getSelectedIndex()].equals("2") && this.xjppersona.getEdad() > 19 && Integer.parseInt(this.xmt.entregarEdadEnMeses(this.xmt.formatoAMD.format(this.xjppersona.cboFechaNacimiento.getDate()))) > 3) {
            this.xError.addElement("La edad debe ser menor a 19 años y 3 meses si el campo 22 es igual a 2");
        }
        if (this.xidV26[this.V26.getSelectedIndex()].equals("1") && !this.xjppersona.getIdSexo().equals("F")) {
            this.xError.addElement("Campo 10 debe ser F si el campo 26 es igual a 1");
        }
        if (this.V30.getText().equals("999")) {
            if (!this.xmt.formatoAMD1.format(this.V29.getDate()).equals("1800-01-01")) {
                this.xError.addElement("Campo 29 debe ser igual a 1800-01-01 si el campo 30 es igual 999");
            }
        } else if (Double.parseDouble(this.V30.getText()) < 0.2d || Double.parseDouble(this.V30.getText()) > 250.0d) {
            this.xError.addElement("Campo 30 debe ser mayor 0.2 y menor a 250");
        }
        if (!this.xmt.formatoAMD1.format(this.V29.getDate()).equals("1800-01-01") && mDiferenciaDias(this.xmt.formatoAMD1.format(this.V29.getDate())) < 0) {
            this.xError.addElement("Campo 29 no debe ser mayor a la fecha de corte");
        }
        if (this.V32.getText().equals("999")) {
            if (!this.xmt.formatoAMD1.format(this.V31.getDate()).equals("1800-01-01")) {
                this.xError.addElement("Campo 31 debe ser igual a 1800-01-01 si el campo 32 es igual 999");
            }
        } else if (Double.parseDouble(this.V32.getText()) < 20.0d || Double.parseDouble(this.V32.getText()) > 225.0d) {
            this.xError.addElement("Campo 32 debe ser estar en el rango de 20 a 225");
        }
        if (!this.xmt.formatoAMD1.format(this.V31.getDate()).equals("1800-01-01") && mDiferenciaDias(this.xmt.formatoAMD1.format(this.V31.getDate())) < 0) {
            this.xError.addElement("Campo 31 no debe ser mayor a la fecha de corte");
        }
        if (!this.xmt.formatoAMD1.format(this.V33.getDate()).equals("1845-01-01") && !this.xjppersona.getIdSexo().equals("F")) {
            this.xError.addElement("Campo 10 debe ser igual a F si campo 33 es diferente a 1845-01-01");
        }
        if (!this.xmt.formatoAMD1.format(this.V33.getDate()).equals("1845-01-01") && !this.xidV14[this.V14.getSelectedIndex()].equals("1")) {
            this.xError.addElement("Campo 14 debe ser igual a 1 si campo 33 es diferente a 1845-01-01");
        }
        if (!this.V34.getText().equals("0") && this.xjppersona.getEdad() > 6) {
            this.xError.addElement("La edad debe ser menor 6 años si el campo 34 es diferente de 0");
        }
        if (!this.xidV46[this.V46.getSelectedIndex()].equals("0") && !this.xjppersona.getIdSexo().equals("F")) {
            this.xError.addElement("Campo 10 debe ser F si el campo 46 es diferente de 0");
        }
        if (!this.xidV47[this.V47.getSelectedIndex()].equals("0") && !this.xjppersona.getIdSexo().equals("F")) {
            this.xError.addElement("Campo 10 debe ser F si el campo 47 es diferente de 0");
        }
        if (!this.xidV48[this.V48.getSelectedIndex()].equals("0") && this.xjppersona.getEdad() < 2) {
            this.xError.addElement("La edad debe ser mayor o igual a 2 años si el campo 48 es diferente a 0");
        }
        if (!this.xmt.formatoAMD1.format(this.V49.getDate()).equals("1845-01-01") && !this.xjppersona.getIdSexo().equals("F")) {
            this.xError.addElement("Campo 10 debe ser F si el campo 49 es diferente de 1845-01-01");
        }
        if (!this.xmt.formatoAMD1.format(this.V49.getDate()).equals("1845-01-01") && !this.xidV14[this.V14.getSelectedIndex()].equals("2")) {
            this.xError.addElement("Campo 14 debe ser igual a 2 si campo 49 es diferente a 1845-01-01");
        }
        if (!this.xmt.formatoAMD1.format(this.V49.getDate()).equals("1845-01-01") && mDiferenciaDias(this.xmt.formatoAMD1.format(this.V49.getDate())) < 0) {
            this.xError.addElement("Campo 49 no debe ser mayor a la fecha de corte.");
        }
        if (!this.xmt.formatoAMD1.format(this.V50.getDate()).equals("1845-01-01") && !this.xjppersona.getIdSexo().equals("F")) {
            this.xError.addElement("Campo 10 debe ser F si el campo 50 es diferente de 1845-01-01");
        }
        if (!this.xmt.formatoAMD1.format(this.V50.getDate()).equals("1845-01-01") && !this.xidV14[this.V14.getSelectedIndex()].equals("1")) {
            this.xError.addElement("Campo 14 debe ser igual a 1 si campo 50 es diferente a 1845-01-01");
        }
        if (!this.xmt.formatoAMD1.format(this.V50.getDate()).equals("1845-01-01") && mDiferenciaDias(this.xmt.formatoAMD1.format(this.V50.getDate())) < 0) {
            this.xError.addElement("Campo 50 no debe ser mayor a la fecha de corte.");
        }
        if (!this.xmt.formatoAMD1.format(this.V51.getDate()).equals("1845-01-01") && !this.xjppersona.getIdSexo().equals("F")) {
            this.xError.addElement("Campo 10 debe ser F si el campo 51 es diferente de 1845-01-01");
        }
        if (!this.xmt.formatoAMD1.format(this.V51.getDate()).equals("1845-01-01") && mDiferenciaDias(this.xmt.formatoAMD1.format(this.V51.getDate())) < 0) {
            this.xError.addElement("Campo 51 no debe ser mayor a la fecha de corte.");
        }
        if (!this.xmt.formatoAMD1.format(this.V52.getDate()).equals("1845-01-01") && !this.xmt.formatoAMD1.format(this.V52.getDate()).equals("1800-01-01") && !this.xmt.formatoAMD1.format(this.V52.getDate()).equals("1805-01-01") && !this.xmt.formatoAMD1.format(this.V52.getDate()).equals("1810-01-01") && !this.xmt.formatoAMD1.format(this.V52.getDate()).equals("1825-01-01") && !this.xmt.formatoAMD1.format(this.V52.getDate()).equals("1830-01-01")) {
            if (mDiferenciaDias(this.xmt.formatoAMD1.format(this.V52.getDate())) < 0) {
                this.xError.addElement("Campo 52 no debe ser mayor a la fecha de corte.");
            }
            if (mDiferenciaDiasEdad(this.xmt.formatoAMD1.format(this.V52.getDate()), this.xmt.formatoAMD.format(this.xjppersona.cboFechaNacimiento.getDate())) > 365) {
                this.xError.addElement("La edad debe ser menor a 30 días si el campo 52 es diferente de 1845-01-01");
            }
            if (mDiferenciaDiasEdad(this.xmt.formatoAMD1.format(this.V52.getDate()), this.xmt.formatoAMD.format(this.xjppersona.cboFechaNacimiento.getDate())) > 30) {
                this.xError.addElement("La edad debe ser menor a 30 días si el campo 52 es diferente de 1845-01-01");
            }
        }
        if (mDiferenciaDias(this.xmt.formatoAMD1.format(this.V53.getDate())) < 0) {
            this.xError.addElement("Campo 53 no debe ser mayor a la fecha de corte.");
        }
        if (mDiferenciaDias(this.xmt.formatoAMD1.format(this.V55.getDate())) < 0) {
            this.xError.addElement("Campo 55 no debe ser mayor a la fecha de corte.");
        }
        if (!this.xmt.formatoAMD1.format(this.V56.getDate()).equals("1845-01-01") && !this.xjppersona.getIdSexo().equals("F")) {
            this.xError.addElement("Campo 10 debe ser F si el campo 56 es diferente de 1845-01-01");
        }
        if (!this.xmt.formatoAMD1.format(this.V56.getDate()).equals("1845-01-01") && !this.xidV14[this.V14.getSelectedIndex()].equals("1")) {
            this.xError.addElement("Campo 14 debe ser igual a 1 si campo 56 es diferente a 1845-01-01");
        }
        if (!this.xmt.formatoAMD1.format(this.V56.getDate()).equals("1845-01-01") && mDiferenciaDias(this.xmt.formatoAMD1.format(this.V56.getDate())) < 0) {
            this.xError.addElement("Campo 56 no debe ser mayor a la fecha de corte.");
        }
        if (!this.V57.getText().equals("0") && !this.xjppersona.getIdSexo().equals("F")) {
            this.xError.addElement("Campo 10 debe ser F si el campo 50 es diferente de 0");
        }
        if (!this.V57.getText().equals("0") && !this.xidV14[this.V14.getSelectedIndex()].equals("1")) {
            this.xError.addElement("Campo 14 debe ser igual a 1 si campo 57 es diferente a 0");
        }
        if (!this.xmt.formatoAMD1.format(this.V58.getDate()).equals("1845-01-01") && !this.xjppersona.getIdSexo().equals("F")) {
            this.xError.addElement("Campo 10 debe ser F si el campo 58 es diferente de 1845-01-01");
        }
        if (!this.xmt.formatoAMD1.format(this.V58.getDate()).equals("1845-01-01") && !this.xidV14[this.V14.getSelectedIndex()].equals("1")) {
            this.xError.addElement("Campo 14 debe ser igual a 1 si campo 58 es diferente a 1845-01-01");
        }
        if (!this.xmt.formatoAMD1.format(this.V58.getDate()).equals("1845-01-01") && mDiferenciaDias(this.xmt.formatoAMD1.format(this.V58.getDate())) < 0) {
            this.xError.addElement("Campo 58 no debe ser mayor a la fecha de corte.");
        }
        if (!this.xidV59[this.V59.getSelectedIndex()].equals("0") && !this.xjppersona.getIdSexo().equals("F")) {
            this.xError.addElement("Campo 10 debe ser F si el campo 59 es diferente de 0");
        }
        if (!this.xidV59[this.V59.getSelectedIndex()].equals("0") && !this.xidV14[this.V14.getSelectedIndex()].equals("1")) {
            this.xError.addElement("Campo 14 debe ser igual a 1 si campo 59 es diferente a 0");
        }
        if (!this.xidV60[this.V60.getSelectedIndex()].equals("0") && !this.xjppersona.getIdSexo().equals("F")) {
            this.xError.addElement("Campo 10 debe ser F si el campo 60 es diferente de 0");
        }
        if (!this.xidV60[this.V60.getSelectedIndex()].equals("0") && !this.xidV14[this.V14.getSelectedIndex()].equals("1")) {
            this.xError.addElement("Campo 14 debe ser igual a 1 si campo 60 es diferente a 0");
        }
        if (!this.xidV61[this.V61.getSelectedIndex()].equals("0") && !this.xjppersona.getIdSexo().equals("F")) {
            this.xError.addElement("Campo 10 debe ser F si el campo 61 es diferente de 0");
        }
        if (!this.xidV61[this.V61.getSelectedIndex()].equals("0") && !this.xidV14[this.V14.getSelectedIndex()].equals("1")) {
            this.xError.addElement("Campo 14 debe ser igual a 1 si campo 61 es diferente a 0");
        }
        if (mDiferenciaDias(this.xmt.formatoAMD1.format(this.V62.getDate())) < 0) {
            this.xError.addElement("Campo 62 no debe ser mayor a la fecha de corte.");
        }
        if (mDiferenciaDias(this.xmt.formatoAMD1.format(this.V63.getDate())) < 0) {
            this.xError.addElement("Campo 63 no debe ser mayor a la fecha de corte.");
        }
        if (!this.xmt.formatoAMD1.format(this.V64.getDate()).equals("1845-01-01") && !this.xidV21[this.V21.getSelectedIndex()].equals("2")) {
            this.xError.addElement("Campo 21 debe ser igual a 2 si campo 64 es diferente a 1845-01-01");
        }
        if (!this.xmt.formatoAMD1.format(this.V64.getDate()).equals("1845-01-01") && mDiferenciaDias(this.xmt.formatoAMD1.format(this.V64.getDate())) < 0) {
            this.xError.addElement("Campo 64 no debe ser mayor a la fecha de corte.");
        }
        if (!this.xmt.formatoAMD1.format(this.V65.getDate()).equals("1845-01-01") && !Between(Integer.parseInt(this.xidV22[this.V22.getSelectedIndex()]), 1L, 2L)) {
            this.xError.addElement("Campo 22 debe ser igual a 1 o 2 si campo 65 es diferente a 1845-01-01");
        }
        if (!this.xmt.formatoAMD1.format(this.V65.getDate()).equals("1845-01-01") && mDiferenciaDias(this.xmt.formatoAMD1.format(this.V65.getDate())) < 0) {
            this.xError.addElement("Campo 65 no debe ser mayor a la fecha de corte.");
        }
        if (!this.xmt.formatoAMD1.format(this.V66.getDate()).equals("1845-01-01") && !this.xidV23[this.V23.getSelectedIndex()].equals("1")) {
            this.xError.addElement("Campo 23 debe ser igual a 1 si campo 66 es diferente a 1845-01-01");
        }
        if (!this.xmt.formatoAMD1.format(this.V66.getDate()).equals("1845-01-01") && mDiferenciaDias(this.xmt.formatoAMD1.format(this.V66.getDate())) < 0) {
            this.xError.addElement("Campo 66 no debe ser mayor a la fecha de corte.");
        }
        if (mDiferenciaDias(this.xmt.formatoAMD1.format(this.V67.getDate())) < 0) {
            this.xError.addElement("Campo 67 no debe ser mayor a la fecha de corte.");
        }
        if (mDiferenciaDias(this.xmt.formatoAMD1.format(this.V68.getDate())) < 0) {
            this.xError.addElement("Campo 68 no debe ser mayor a la fecha de corte.");
        }
        if (!this.xmt.formatoAMD1.format(this.V69.getDate()).equals("1845-01-01") && !this.xmt.formatoAMD1.format(this.V69.getDate()).equals("1800-01-01") && !this.xmt.formatoAMD1.format(this.V69.getDate()).equals("1805-01-01") && !this.xmt.formatoAMD1.format(this.V69.getDate()).equals("1810-01-01") && !this.xmt.formatoAMD1.format(this.V69.getDate()).equals("1825-01-01") && !this.xmt.formatoAMD1.format(this.V69.getDate()).equals("1830-01-01") && !this.xmt.formatoAMD1.format(this.V69.getDate()).equals("1835-01-01")) {
            if (mDiferenciaDias(this.xmt.formatoAMD1.format(this.V69.getDate())) < 0) {
                this.xError.addElement("Campo 69 no debe ser mayor a la fecha de corte.");
            }
            if (mDiferenciaDiasEdad(this.xmt.formatoAMD1.format(this.V69.getDate()), this.xmt.formatoAMD1.format(this.xjppersona.cboFechaNacimiento.getDate())) >= 3650) {
                this.xError.addElement("La edad debe ser menor a 10 años si el campo 69 es diferente de 1845-01-01");
            }
        }
        if (!this.xidV70[this.V70.getSelectedIndex()].equals("0") && this.xjppersona.getEdad() > 10) {
            this.xError.addElement("La edad debe ser menor a 10 años si el campo 70 es diferente de 0");
        }
        if (!this.xidV71[this.V71.getSelectedIndex()].equals("0") && this.xjppersona.getEdad() > 10) {
            this.xError.addElement("La edad debe ser menor a 10 años si el campo 71 es diferente de 0");
        }
        if (mDiferenciaDias(this.xmt.formatoAMD1.format(this.V72.getDate())) < 0) {
            this.xError.addElement("Campo 72 no debe ser mayor a la fecha de corte.");
        }
        if (mDiferenciaDias(this.xmt.formatoAMD1.format(this.V73.getDate())) < 0) {
            this.xError.addElement("Campo 73 no debe ser mayor a la fecha de corte.");
        }
        if (mDiferenciaDias(this.xmt.formatoAMD1.format(this.V75.getDate())) < 0) {
            this.xError.addElement("Campo 75 no debe ser mayor a la fecha de corte.");
        }
        if (mDiferenciaDias(this.xmt.formatoAMD1.format(this.V76.getDate())) < 0) {
            this.xError.addElement("Campo 76 no debe ser mayor a la fecha de corte.");
        }
        if (!this.xidV77[this.V77.getSelectedIndex()].equals("0") && !Between(Integer.parseInt(this.xidV25[this.V25.getSelectedIndex()]), 1L, 6L)) {
            this.xError.addElement("Campo 25 debe ser 1,2,3,4,5 o 6 si campo 77 es diferente a 0");
        }
        if (!this.xmt.formatoAMD1.format(this.V78.getDate()).equals("1845-01-01") && !this.xjppersona.getIdSexo().equals("F")) {
            this.xError.addElement("Campo 10 debe ser F si el campo 78 es diferente de 1845-01-01");
        }
        if (!this.xmt.formatoAMD1.format(this.V78.getDate()).equals("1845-01-01") && !this.xidV14[this.V14.getSelectedIndex()].equals("1")) {
            this.xError.addElement("Campo 14 debe ser igual a 1 si campo 78 es diferente a 1845-01-01");
        }
        if (!this.xmt.formatoAMD1.format(this.V78.getDate()).equals("1845-01-01") && mDiferenciaDias(this.xmt.formatoAMD1.format(this.V78.getDate())) < 0) {
            this.xError.addElement("Campo 78 no debe ser mayor a la fecha de corte.");
        }
        if (mDiferenciaDias(this.xmt.formatoAMD1.format(this.V80.getDate())) < 0) {
            this.xError.addElement("Campo 80 no debe ser mayor a la fecha de corte.");
        }
        if (mDiferenciaDias(this.xmt.formatoAMD1.format(this.V82.getDate())) < 0) {
            this.xError.addElement("Campo 82 no debe ser mayor a la fecha de corte.");
        }
        if (!this.xmt.formatoAMD1.format(this.V84.getDate()).equals("1845-01-01") && !this.xmt.formatoAMD1.format(this.V84.getDate()).equals("1800-01-01") && !this.xmt.formatoAMD1.format(this.V84.getDate()).equals("1805-01-01") && !this.xmt.formatoAMD1.format(this.V84.getDate()).equals("1810-01-01") && !this.xmt.formatoAMD1.format(this.V84.getDate()).equals("1825-01-01") && !this.xmt.formatoAMD1.format(this.V84.getDate()).equals("1830-01-01") && !this.xmt.formatoAMD1.format(this.V84.getDate()).equals("1835-01-01")) {
            if (mDiferenciaDias(this.xmt.formatoAMD1.format(this.V78.getDate())) < 0) {
                this.xError.addElement("Campo 78 no debe ser mayor a la fecha de corte.");
            }
            if (mDiferenciaDiasEdad(this.xmt.formatoAMD1.format(this.V84.getDate()), this.xmt.formatoAMD.format(this.xjppersona.cboFechaNacimiento.getDate())) > 365 || mDiferenciaDiasEdad(this.xmt.formatoAMD1.format(this.V84.getDate()), this.xmt.formatoAMD.format(this.xjppersona.cboFechaNacimiento.getDate())) > 30 || mDiferenciaDiasEdad(this.xmt.formatoAMD1.format(this.V84.getDate()), this.xmt.formatoAMD.format(this.xjppersona.cboFechaNacimiento.getDate())) > 2) {
                this.xError.addElement("La edad debe ser menor a 2 días si el campo 84 es diferente de 1845-01-01");
            }
        }
        if (!this.xidV86[this.V86.getSelectedIndex()].equals("0") && !this.xjppersona.getIdSexo().equals("F")) {
            this.xError.addElement("Campo 10 debe ser F si el campo 86 es diferente de 0");
        }
        if (!this.xidV86[this.V86.getSelectedIndex()].equals("0") && this.xjppersona.getEdad() <= 10) {
            this.xError.addElement("La edad debe ser mayor a 10 años si el campo 86 es diferente de 0");
        }
        if (!this.xmt.formatoAMD1.format(this.V87.getDate()).equals("1845-01-01") && !this.xjppersona.getIdSexo().equals("F")) {
            this.xError.addElement("Campo 10 debe ser F si el campo 87 es diferente de 1845-01-01");
        }
        if (!this.xmt.formatoAMD1.format(this.V87.getDate()).equals("1845-01-01") && !this.xmt.formatoAMD1.format(this.V87.getDate()).equals("1800-01-01") && !this.xmt.formatoAMD1.format(this.V87.getDate()).equals("1805-01-01") && !this.xmt.formatoAMD1.format(this.V87.getDate()).equals("1810-01-01") && !this.xmt.formatoAMD1.format(this.V87.getDate()).equals("1825-01-01") && !this.xmt.formatoAMD1.format(this.V87.getDate()).equals("1830-01-01") && !this.xmt.formatoAMD1.format(this.V87.getDate()).equals("1835-01-01")) {
            if (mDiferenciaDias(this.xmt.formatoAMD1.format(this.V87.getDate())) < 0) {
                this.xError.addElement("Campo 87 no debe ser mayor a la fecha de corte.");
            }
            if (mDiferenciaDiasEdad(this.xmt.formatoAMD1.format(this.V87.getDate()), this.xmt.formatoAMD.format(this.xjppersona.cboFechaNacimiento.getDate())) < 3650) {
                this.xError.addElement("La edad debe ser mayor a 10 años si el campo 87 es diferente de 1845-01-01");
            }
        }
        if (!this.xidV88[this.V88.getSelectedIndex()].equals("0") && !this.xjppersona.getIdSexo().equals("F")) {
            this.xError.addElement("Campo 10 debe ser F si el campo 88 es diferente de 0");
        }
        if (!this.xidV88[this.V88.getSelectedIndex()].equals("0") && this.xjppersona.getEdad() <= 10) {
            this.xError.addElement("La edad debe ser mayor a 10 años si el campo 88 es diferente de 0.");
        }
        if (!this.xidV89[this.V89.getSelectedIndex()].equals("0") && !this.xjppersona.getIdSexo().equals("F")) {
            this.xError.addElement("Campo 10 debe ser F si el campo 89 es diferente de 0");
        }
        if (!this.xidV89[this.V89.getSelectedIndex()].equals("0") && this.xjppersona.getEdad() <= 10) {
            this.xError.addElement("La edad debe ser mayor a 10 años si el campo 89 es diferente de 0.");
        }
        if (!this.V90.getText().equals("0") && !this.xjppersona.getIdSexo().equals("F")) {
            this.xError.addElement("Campo 10 debe ser F si el campo 90 es diferente de 0");
        }
        if (!this.V90.getText().equals("0") && this.xjppersona.getEdad() <= 10) {
            this.xError.addElement("La edad debe ser mayor a 10 años si el campo 90 es diferente de 0.");
        }
        if (!this.xmt.formatoAMD1.format(this.V91.getDate()).equals("1845-01-01") && !this.xjppersona.getIdSexo().equals("F")) {
            this.xError.addElement("Campo 10 debe ser F si el campo 91 es diferente de 1845-01-01");
        }
        if (!this.xmt.formatoAMD1.format(this.V91.getDate()).equals("1845-01-01") && !this.xmt.formatoAMD1.format(this.V91.getDate()).equals("1800-01-01") && !this.xmt.formatoAMD1.format(this.V91.getDate()).equals("1805-01-01") && !this.xmt.formatoAMD1.format(this.V91.getDate()).equals("1810-01-01") && !this.xmt.formatoAMD1.format(this.V91.getDate()).equals("1825-01-01") && !this.xmt.formatoAMD1.format(this.V91.getDate()).equals("1830-01-01") && !this.xmt.formatoAMD1.format(this.V91.getDate()).equals("1835-01-01")) {
            if (mDiferenciaDias(this.xmt.formatoAMD1.format(this.V91.getDate())) < 0) {
                this.xError.addElement("Campo 91 no debe ser mayor a la fecha de corte.");
            }
            if (mDiferenciaDiasEdad(this.xmt.formatoAMD1.format(this.V91.getDate()), this.xmt.formatoAMD.format(this.xjppersona.cboFechaNacimiento.getDate())) < 3650) {
                this.xError.addElement("La edad debe ser mayor a 10 años si el campo 91 es diferente de 1845-01-01");
            }
        }
        if (!this.V92.getText().equals("0") && !this.xjppersona.getIdSexo().equals("F")) {
            this.xError.addElement("Campo 10 debe ser F si el campo 92 es diferente de 0");
        }
        if (!this.V92.getText().equals("0") && this.xjppersona.getEdad() <= 10) {
            this.xError.addElement("La edad debe ser mayor a 10 años si el campo 92 es diferente de 0");
        }
        if (!this.xmt.formatoAMD1.format(this.V93.getDate()).equals("1845-01-01") && !this.xjppersona.getIdSexo().equals("F")) {
            this.xError.addElement("Campo 10 debe ser F si el campo 93 es diferente de 1845-01-01");
        }
        if (!this.xmt.formatoAMD1.format(this.V93.getDate()).equals("1845-01-01") && !this.xmt.formatoAMD1.format(this.V93.getDate()).equals("1800-01-01") && !this.xmt.formatoAMD1.format(this.V93.getDate()).equals("1805-01-01") && !this.xmt.formatoAMD1.format(this.V93.getDate()).equals("1810-01-01") && !this.xmt.formatoAMD1.format(this.V93.getDate()).equals("1825-01-01") && !this.xmt.formatoAMD1.format(this.V93.getDate()).equals("1830-01-01") && !this.xmt.formatoAMD1.format(this.V93.getDate()).equals("1835-01-01")) {
            if (mDiferenciaDias(this.xmt.formatoAMD1.format(this.V93.getDate())) < 0) {
                this.xError.addElement("Campo 93 no debe ser mayor a la fecha de corte.");
            }
            if (mDiferenciaDiasEdad(this.xmt.formatoAMD1.format(this.V93.getDate()), this.xmt.formatoAMD.format(this.xjppersona.cboFechaNacimiento.getDate())) < 3650) {
                this.xError.addElement("La edad debe ser mayor a 10 años si el campo 93 es diferente de 1845-01-01");
            }
        }
        if (!this.xidV94[this.V94.getSelectedIndex()].equals("0") && !this.xjppersona.getIdSexo().equals("F")) {
            this.xError.addElement("Campo 10 debe ser F si el campo 94 es diferente de 0");
        }
        if (!this.xidV94[this.V94.getSelectedIndex()].equals("0") && this.xjppersona.getEdad() <= 10) {
            this.xError.addElement("La edad debe ser mayor a 10 años si el campo 94 es diferente de 0");
        }
        if (!this.V95.getText().equals("0") && !this.xjppersona.getIdSexo().equals("F")) {
            this.xError.addElement("Campo 10 debe ser F si el campo 95 es diferente de 0");
        }
        if (!this.V95.getText().equals("0") && this.xjppersona.getEdad() <= 10) {
            this.xError.addElement("La edad debe ser mayor a 10 años si el campo 95 es diferente de 0");
        }
        if (!this.xmt.formatoAMD1.format(this.V96.getDate()).equals("1845-01-01") && !this.xjppersona.getIdSexo().equals("F")) {
            this.xError.addElement("Campo 10 debe ser F si el campo 96 es diferente de 1845-01-01");
        }
        if (!this.xmt.formatoAMD1.format(this.V96.getDate()).equals("1845-01-01") && !this.xmt.formatoAMD1.format(this.V96.getDate()).equals("1800-01-01") && !this.xmt.formatoAMD1.format(this.V96.getDate()).equals("1805-01-01") && !this.xmt.formatoAMD1.format(this.V96.getDate()).equals("1810-01-01") && !this.xmt.formatoAMD1.format(this.V96.getDate()).equals("1825-01-01") && !this.xmt.formatoAMD1.format(this.V96.getDate()).equals("1830-01-01") && !this.xmt.formatoAMD1.format(this.V96.getDate()).equals("1835-01-01")) {
            if (mDiferenciaDias(this.xmt.formatoAMD1.format(this.V96.getDate())) < 0) {
                this.xError.addElement("Campo 96 no debe ser mayor a la fecha de corte.");
            }
            if (mDiferenciaDiasEdad(this.xmt.formatoAMD1.format(this.V96.getDate()), this.xmt.formatoAMD.format(this.xjppersona.cboFechaNacimiento.getDate())) < 12775) {
                this.xError.addElement("La edad debe ser mayor a 35 años si el campo 96 es diferente de 1845-01-01");
            }
        }
        if (!this.xidV97[this.V97.getSelectedIndex()].equals("0") && !this.xjppersona.getIdSexo().equals("F")) {
            this.xError.addElement("Campo 10 debe ser F si el campo 97 es diferente de 0");
        }
        if (!this.xidV97[this.V97.getSelectedIndex()].equals("0") && this.xjppersona.getEdad() < 35) {
            this.xError.addElement("La edad debe ser mayor a 35 años si el campo 97 es diferente de 0");
        }
        if (!this.V98.getText().equals("0") && !this.xjppersona.getIdSexo().equals("F")) {
            this.xError.addElement("Campo 10 debe ser F si el campo 98 es diferente de 0");
        }
        if (!this.V98.getText().equals("0") && this.xjppersona.getEdad() < 35) {
            this.xError.addElement("La edad debe ser mayor a 35 años si el campo 98 es diferente de 0");
        }
        if (!this.xmt.formatoAMD1.format(this.V99.getDate()).equals("1845-01-01") && !this.xjppersona.getIdSexo().equals("F")) {
            this.xError.addElement("Campo 10 debe ser F si el campo 99 es diferente de 1845-01-01");
        }
        if (!this.xmt.formatoAMD1.format(this.V99.getDate()).equals("1845-01-01") && mDiferenciaDias(this.xmt.formatoAMD1.format(this.V99.getDate())) < 0) {
            this.xError.addElement("Campo 99 no debe ser mayor a la fecha de corte.");
        }
        if (!this.xmt.formatoAMD1.format(this.V100.getDate()).equals("1845-01-01") && !this.xjppersona.getIdSexo().equals("F")) {
            this.xError.addElement("Campo 10 debe ser F si el campo 100 es diferente de 1845-01-01.");
        }
        if (!this.xmt.formatoAMD1.format(this.V100.getDate()).equals("1845-01-01") && mDiferenciaDias(this.xmt.formatoAMD1.format(this.V100.getDate())) < 0) {
            this.xError.addElement("Campo 100 no debe ser mayor a la fecha de corte.");
        }
        if (!this.xidV101[this.V101.getSelectedIndex()].equals("0") && !this.xjppersona.getIdSexo().equals("F")) {
            this.xError.addElement("Campo 10 debe ser F si el campo 101 es diferente de 0");
        }
        if (!this.V102.getText().equals("0") && !this.xjppersona.getIdSexo().equals("F")) {
            this.xError.addElement("Campo 10 debe ser F si el campo 102 es diferente de 0");
        }
        if (mDiferenciaDias(this.xmt.formatoAMD1.format(this.V103.getDate())) < 0) {
            this.xError.addElement("Campo 103 no debe ser mayor a la fecha de corte");
        }
        if (!this.V104.getText().equals("0") && (Double.parseDouble(this.V104.getText()) < 1.5d || Double.parseDouble(this.V104.getText()) < 20.0d)) {
            this.xError.addElement("Campo 104 debe estar entre 1.5 y 20 si es diferente de 0");
        }
        if (mDiferenciaDias(this.xmt.formatoAMD1.format(this.V105.getDate())) < 0) {
            this.xError.addElement("Campo 105 no debe ser mayor a la fecha de corte");
        }
        if (mDiferenciaDias(this.xmt.formatoAMD1.format(this.V106.getDate())) < 0) {
            this.xError.addElement("Campo 106 no debe ser mayor a la fecha de corte");
        }
        if (!this.V107.getText().equals("0") && !this.V107.getText().equals("999") && (Double.parseDouble(this.V107.getText()) < 0.2d || Double.parseDouble(this.V107.getText()) < 25.0d)) {
            this.xError.addElement("Campo 107 debe estar entre 0.2 y 25 si es diferente de 0 o 999");
        }
        if (mDiferenciaDias(this.xmt.formatoAMD1.format(this.V108.getDate())) < 0) {
            this.xError.addElement("Campo 108 no debe ser mayor a la fecha de corte");
        }
        if ((!this.V109.getText().equals("0") || !this.V109.getText().equals("999")) && (Double.parseDouble(this.V109.getText()) < 5.0d || Double.parseDouble(this.V109.getText()) > 20.0d)) {
            this.xError.addElement("Campo 109 debe estar en el rango 5 y 20");
        }
        if (mDiferenciaDias(this.xmt.formatoAMD1.format(this.V110.getDate())) < 0) {
            this.xError.addElement("Campo 110 no debe ser mayor a la fecha de corte");
        }
        if (mDiferenciaDias(this.xmt.formatoAMD1.format(this.V111.getDate())) < 0) {
            this.xError.addElement("Campo 111 no debe ser mayor a la fecha de corte");
        }
        if (mDiferenciaDias(this.xmt.formatoAMD1.format(this.V112.getDate())) < 0) {
            this.xError.addElement("Campo 112 no debe ser mayor a la fecha de corte");
        }
        if (!this.V102.getText().equals("0") && !this.xjppersona.getIdSexo().equals("F")) {
            this.xError.addElement("Campo 10 debe ser F si el campo 102 es diferente de 0");
        }
        if (!this.xidV115[this.V115.getSelectedIndex()].equals("0") && !this.xjppersona.getIdSexo().equals("F")) {
            this.xError.addElement("Campo 10 debe ser F si el campo 115 es diferente de 0");
        }
        if (!this.xidV115[this.V115.getSelectedIndex()].equals("0") && !this.xidV14[this.V14.getSelectedIndex()].equals("1")) {
            this.xError.addElement("Campo 14 debe ser 1 si el campo 115 es diferente de 0");
        }
        if (!this.xidV115[this.V115.getSelectedIndex()].equals("0") && !this.xidV15[this.V15.getSelectedIndex()].equals("1")) {
            this.xError.addElement("Campo 15 debe ser 1 si el campo 115 es diferente de 0");
        }
        if (!this.xidV116[this.V116.getSelectedIndex()].equals("0") && !this.xidV15[this.V15.getSelectedIndex()].equals("2")) {
            this.xError.addElement("Campo 15 debe ser 2 si el campo 116 es diferente de 0");
        }
        if (!this.xidV117[this.V117.getSelectedIndex()].equals("0") && !this.xidV20[this.V20.getSelectedIndex()].equals("1") && !this.xidV20[this.V20.getSelectedIndex()].equals("2")) {
            this.xError.addElement("Campo 20 debe ser 1 o 2 si el campo 117 es diferente de 0");
        }
        if (mDiferenciaDias(this.xmt.formatoAMD1.format(this.V118.getDate())) < 0) {
            this.xError.addElement("Campo 118 no debe ser mayor a la fecha de corte");
        }
        mGeneraLog();
        return false;
    }

    private double mCalculaIMC() {
        double xIMC = 0.0d;
        if (this.V30.getText() != null && this.V32.getText() != null && !this.V30.getText().equals("0") && !this.V32.getText().equals("0")) {
            xIMC = (Double.parseDouble(this.V30.getText()) / Math.pow(Double.parseDouble(this.V32.getText()), 2.0d)) * 10000.0d;
            System.out.println("IMC-->" + xIMC);
        }
        return xIMC;
    }

    private int mDiferenciaDias(String xfecha) {
        int xdias = 0;
        String sql = "SELECT DATEDIFF(NOW(),'" + xfecha + "')";
        ResultSet xrs = this.xct.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.first();
                xdias = xrs.getInt(1);
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFRegistro4505.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return xdias;
    }

    private int mDiferenciaDiasEdad(String xfechaR, String xFechaNac) {
        int xdias = 0;
        String sql = "SELECT DATEDIFF('" + xfechaR + "','" + xFechaNac + "')";
        ResultSet xrs = this.xct.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.first();
                xdias = xrs.getInt(1);
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFRegistro4505.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return xdias;
    }

    private boolean Between(long valor, long rango_inicial, long rango_final) {
        return valor >= rango_inicial && valor <= rango_final;
    }

    public void mBuscaInfoPaciente() {
        String sql = "SELECT   `V14`, `V15`, `V16`,  `V17`, `V18`, `V19`, `V20`, `V21`, `V22`, `V23`, `V24`, `V25`, `V26`, `V27`,\n  `V28`, `V29`, `V30`, `V31`, `V32`, `V33`, `V34`, `V35`, `V36`, `V37`, `V38`, `V39`, `V40`, `V41`, `V42`,\n  `V43`, `V44`, `V45`, `V46`, `V47`, `V48`, `V49`, `V50`, `V51`, `V52`, `V53`, `V54`, `V55`, `V56`, `V57`,\n  `V58`, `V59`, `V60`, `V61`, `V62`, `V63`, `V64`, `V65`, `V66`, `V67`, `V68`, `V69`, `V70`, `V71`, `V72`,\n  `V73`, `V74`, `V75`, `V76`, `V77`,  `V78`, `V79`, `V80`, `V81`,  `V82`, `V83`, `V84`, `V85`, `V86`,\n  `V87`, `V88`, `V89`, `V90`, `V91`, `V92`, `V93`, `V94`, `V95`, `V96`, `V97`, `V98`, `V99`, `V100`,\n  `V101`, `V102`, `V103`, `V104`, `V105`, `V106`, `V107`, `V108`, `V109`, `V110`, `V111`, `V112`, `V113`,\n  `V114`, `V115`, `V116`, `V117`,  `V118`  FROM `p_res_4505_r`  WHERE(`Id_Persona`= '" + this.xjppersona.IdPersona + "')";
        ResultSet xrs = this.xct.traerRs(sql);
        System.out.println("SQL-->" + sql);
        try {
            if (xrs.next()) {
                xrs.first();
                this.V14.setSelectedIndex(Combo(this.xidV14, xrs.getInt("V14")));
                this.V15.setSelectedIndex(Combo(this.xidV15, xrs.getInt("V15")));
                this.V16.setSelectedIndex(Combo(this.xidV16, xrs.getInt("V16")));
                this.V17.setSelectedIndex(Combo(this.xidV17, xrs.getInt("V17")));
                this.V18.setSelectedIndex(Combo(this.xidV18, xrs.getInt("V18")));
                this.V19.setSelectedIndex(Combo(this.xidV19, xrs.getInt("V19")));
                this.V20.setSelectedIndex(Combo(this.xidV20, xrs.getInt("V20")));
                this.V21.setSelectedIndex(Combo(this.xidV21, xrs.getInt("V21")));
                this.V22.setSelectedIndex(Combo(this.xidV22, xrs.getInt("V22")));
                this.V23.setSelectedIndex(Combo(this.xidV23, xrs.getInt("V23")));
                this.V24.setSelectedIndex(Combo(this.xidV24, xrs.getInt("V24")));
                this.V25.setSelectedIndex(Combo(this.xidV25, xrs.getInt("V25")));
                this.V26.setSelectedIndex(Combo(this.xidV26, xrs.getInt("V26")));
                this.V27.setSelectedIndex(Combo(this.xidV27, xrs.getInt("V27")));
                this.V28.setSelectedIndex(Combo(this.xidV28, xrs.getInt("V28")));
                this.V29.setDate(xrs.getDate("V29"));
                this.V30.setText(xrs.getString("V30"));
                this.V31.setDate(xrs.getDate("V31"));
                this.V32.setText(xrs.getString("V32"));
                this.V33.setDate(xrs.getDate("V33"));
                this.V34.setText(xrs.getString("V35"));
                this.V35.setSelectedIndex(Combo(this.xidV35, xrs.getInt("V35")));
                this.V36.setSelectedIndex(Combo(this.xidV36, xrs.getInt("V36")));
                this.V37.setSelectedIndex(Combo(this.xidV37, xrs.getInt("V37")));
                this.V38.setSelectedIndex(Combo(this.xidV38, xrs.getInt("V38")));
                this.V39.setSelectedIndex(Combo(this.xidV39, xrs.getInt("V39")));
                this.V40.setSelectedIndex(Combo(this.xidV40, xrs.getInt("V40")));
                this.V41.setSelectedIndex(Combo(this.xidV41, xrs.getInt("V41")));
                this.V42.setSelectedIndex(Combo(this.xidV42, xrs.getInt("V42")));
                this.V43.setSelectedIndex(Combo(this.xidV43, xrs.getInt("V43")));
                this.V44.setSelectedIndex(Combo(this.xidV44, xrs.getInt("V44")));
                this.V45.setSelectedIndex(Combo(this.xidV45, xrs.getInt("V45")));
                this.V46.setSelectedIndex(Combo(this.xidV46, xrs.getInt("V46")));
                this.V47.setSelectedIndex(Combo(this.xidV47, xrs.getInt("V47")));
                this.V48.setSelectedIndex(Combo(this.xidV48, xrs.getInt("V48")));
                this.V49.setDate(xrs.getDate("V49"));
                this.V50.setDate(xrs.getDate("V50"));
                this.V51.setDate(xrs.getDate("V51"));
                this.V52.setDate(xrs.getDate("V52"));
                this.V53.setDate(xrs.getDate("V53"));
                this.V54.setSelectedIndex(Combo(this.xidV54, xrs.getInt("V54")));
                this.V55.setDate(xrs.getDate("V55"));
                this.V56.setDate(xrs.getDate("V56"));
                this.V57.setText(xrs.getString("V57"));
                this.V58.setDate(xrs.getDate("V58"));
                this.V59.setSelectedIndex(Combo(this.xidV59, xrs.getInt("V59")));
                this.V60.setSelectedIndex(Combo(this.xidV60, xrs.getInt("V60")));
                this.V61.setSelectedIndex(Combo(this.xidV61, xrs.getInt("V61")));
                this.V62.setDate(xrs.getDate("V62"));
                this.V63.setDate(xrs.getDate("V63"));
                this.V64.setDate(xrs.getDate("V64"));
                this.V65.setDate(xrs.getDate("V65"));
                this.V66.setDate(xrs.getDate("V66"));
                this.V67.setDate(xrs.getDate("V67"));
                this.V68.setDate(xrs.getDate("V68"));
                this.V69.setDate(xrs.getDate("V69"));
                this.V70.setSelectedIndex(Combo(this.xidV70, xrs.getInt("V70")));
                this.V71.setSelectedIndex(Combo(this.xidV71, xrs.getInt("V71")));
                this.V72.setDate(xrs.getDate("V72"));
                this.V73.setDate(xrs.getDate("V73"));
                this.V74.setText(xrs.getString("V74"));
                this.V75.setDate(xrs.getDate("V75"));
                this.V76.setDate(xrs.getDate("V76"));
                this.V77.setSelectedIndex(Combo(this.xidV77, xrs.getInt("V77")));
                this.V78.setDate(xrs.getDate("V78"));
                this.V79.setSelectedIndex(Combo(this.xidV79, xrs.getInt("V79")));
                this.V80.setDate(xrs.getDate("V80"));
                this.V81.setSelectedIndex(Combo(this.xidV81, xrs.getInt("V81")));
                this.V82.setDate(xrs.getDate("V82"));
                this.V83.setSelectedIndex(Combo(this.xidV83, xrs.getInt("V83")));
                this.V84.setDate(xrs.getDate("V84"));
                this.V85.setSelectedIndex(Combo(this.xidV85, xrs.getInt("V85")));
                this.V86.setSelectedIndex(Combo(this.xidV86, xrs.getInt("V86")));
                this.V87.setDate(xrs.getDate("V87"));
                this.V88.setSelectedIndex(Combo(this.xidV88, xrs.getInt("V88")));
                this.V89.setSelectedIndex(Combo(this.xidV89, xrs.getInt("V89")));
                this.V90.setText(xrs.getString("V90"));
                this.V91.setDate(xrs.getDate("V91"));
                this.V92.setText(xrs.getString("V92"));
                this.V93.setDate(xrs.getDate("V93"));
                this.V94.setSelectedIndex(Combo(this.xidV94, xrs.getInt("V94")));
                this.V95.setText(xrs.getString("V95"));
                this.V96.setDate(xrs.getDate("V96"));
                this.V97.setSelectedIndex(Combo(this.xidV97, xrs.getInt("V97")));
                this.V98.setText(xrs.getString("V98"));
                this.V99.setDate(xrs.getDate("V99"));
                this.V100.setDate(xrs.getDate("V100"));
                this.V101.setSelectedIndex(Combo(this.xidV101, xrs.getInt("V101")));
                this.V102.setText(xrs.getString("V102"));
                this.V103.setDate(xrs.getDate("V103"));
                this.V104.setText(xrs.getString("V104"));
                this.V105.setDate(xrs.getDate("V105"));
                this.V106.setDate(xrs.getDate("V106"));
                this.V107.setText(xrs.getString("V107"));
                this.V108.setDate(xrs.getDate("V108"));
                this.V109.setText(xrs.getString("V109"));
                this.V110.setDate(xrs.getDate("V110"));
                this.V111.setDate(xrs.getDate("V111"));
                this.V112.setDate(xrs.getDate("V112"));
                this.V113.setSelectedIndex(Combo(this.xidV113, xrs.getInt("V113")));
                this.V114.setSelectedIndex(Combo(this.xidV114, xrs.getInt("V114")));
                this.V115.setSelectedIndex(Combo(this.xidV115, xrs.getInt("V115")));
                this.V116.setSelectedIndex(Combo(this.xidV116, xrs.getInt("V116")));
                this.V117.setSelectedIndex(Combo(this.xidV117, xrs.getInt("V117")));
                this.V118.setDate(xrs.getDate("V118"));
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFRegistro4505.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private int Combo(String[] xcombo, int xValor) {
        int x = -1;
        System.out.println("Valor-->" + xValor);
        int i = 0;
        while (true) {
            if (i >= xcombo.length) {
                break;
            }
            if (xValor != Integer.parseInt(xcombo[i])) {
                i++;
            } else {
                x = i;
                break;
            }
        }
        return x;
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mModeloLOG() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"No.", "Error"}) { // from class: PyP.JIFRegistro4505.79
            Class[] types = {Long.class, String.class};
            boolean[] canEdit = {false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTLog.setModel(this.xmodelo);
        this.JTLog.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTLog.getColumnModel().getColumn(1).setPreferredWidth(250);
    }

    private void mGeneraLog() {
        mModeloLOG();
        for (int i = 0; i < this.xError.size(); i++) {
            this.xmodelo.addRow(this.xdatos);
            this.xmodelo.setValueAt(Integer.valueOf(i), i, 0);
            this.xmodelo.setValueAt(this.xError.elementAt(i), i, 1);
        }
    }

    public void mNuevo() {
        this.xjppersona.nuevo();
    }

    private void mGuardar() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V16ActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V17ActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V18ActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V19ActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V20ActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jComboBox8ActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V21ActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V22ActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V23ActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V24ActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V25ActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V26ActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V27ActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V28ActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V29KeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V31KeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V33KeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V49KeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V50KeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V51KeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V52KeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V53KeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V54ItemStateChanged(ItemEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V55KeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V56KeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V58KeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V59ItemStateChanged(ItemEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V60ItemStateChanged(ItemEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V61ItemStateChanged(ItemEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V62KeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V63KeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V64KeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V65KeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V66KeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V67KeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V68KeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V69KeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V70ItemStateChanged(ItemEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V71ItemStateChanged(ItemEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V72KeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V73KeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V75KeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V76KeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V77ItemStateChanged(ItemEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V78KeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V79ItemStateChanged(ItemEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V80KeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V81ItemStateChanged(ItemEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V82KeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V83ItemStateChanged(ItemEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V84KeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V85ItemStateChanged(ItemEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V86ItemStateChanged(ItemEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V87KeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V88ItemStateChanged(ItemEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V89ItemStateChanged(ItemEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V91KeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V93KeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V94ItemStateChanged(ItemEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V96KeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V97ItemStateChanged(ItemEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V99KeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V100KeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V101ItemStateChanged(ItemEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V103KeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V105KeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V106KeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V108KeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V110KeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V111KeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V112KeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V113ItemStateChanged(ItemEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V114ItemStateChanged(ItemEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V115ItemStateChanged(ItemEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V116ItemStateChanged(ItemEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V117ItemStateChanged(ItemEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V118KeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jButton1ActionPerformed(ActionEvent evt) {
        mValidar();
    }
}
