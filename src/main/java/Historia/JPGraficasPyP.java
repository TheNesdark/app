package Historia;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.JTextFieldValidator;
import Utilidades.Metodos;
import com.genoma.plus.controller.historia.JP_IngresoProgramaCyD;
import com.toedter.calendar.JDateChooser;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Iterator;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import javax.swing.BorderFactory;
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
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

/* JADX INFO: loaded from: GenomaP.jar:Historia/JPGraficasPyP.class */
public class JPGraficasPyP extends JPanel {
    private DefaultTableModel xmodelo;
    private DefaultTableModel xmodeloSeg;
    private Object[] xdato;
    private Imagen Grafica;
    String xedad;
    private int xEdadActual;
    private File Directorio;
    private JPGraficasCyDImpresion xJPGraficasCyDImpresion;
    private String xSexo;
    private String G1;
    private String G2;
    private String G3;
    private String G4;
    private String G5;
    private String G6;
    private String G7;
    private String G8;
    private String G9;
    private String G10;
    private String G11;
    private JButton JBGuardar;
    private JButton JBTGuardar;
    private JButton JBTGuardarObs;
    private JComboBox JCBALenguaje;
    private JComboBox JCBCCentinela;
    private JComboBox JCBEdadMeses;
    private JComboBox JCBEsqVacunacion;
    private JComboBox JCBEventoSPublica;
    private JComboBox JCBIMCEdad;
    private JComboBox JCBLacMaterna;
    private JComboBox JCBMFina;
    private JComboBox JCBMGruesa;
    private JComboBox JCBPCefalico;
    private JComboBox JCBPSocial;
    private JComboBox JCBPesoEdad;
    private JComboBox JCBPesoTalla;
    private JComboBox JCBTallaEdad;
    private JCheckBox JCHAplicaHemoglobina;
    private JCheckBox JCHAplicaSulfatoDeZinc;
    private JCheckBox JCHAplicaVih;
    private JDateChooser JDC_FechaAntParasitario;
    private JDateChooser JDC_FechaAtnOdont;
    private JDateChooser JDC_FechaEvento;
    private JDateChooser JDC_FechaHemoglobina;
    private JDateChooser JDC_FechaHierro;
    private JDateChooser JDC_FechaI;
    private JDateChooser JDC_FechaPCita;
    private JDateChooser JDC_FechaSulfatoDeZinc;
    private JDateChooser JDC_FechaVih;
    private JDateChooser JDC_FechaVitA;
    private JLabel JLBPBSentado;
    private JLabel JLBPSentado;
    private JLabel JLEdadMeses;
    private JPanel JPDatos;
    private JPanel JPGrafica;
    private JScrollPane JSPGraficas1;
    private JScrollPane JSPGraficas10;
    private JScrollPane JSPGraficas11;
    private JScrollPane JSPGraficas2;
    private JScrollPane JSPGraficas3;
    private JScrollPane JSPGraficas4;
    private JScrollPane JSPGraficas5;
    private JScrollPane JSPGraficas6;
    private JScrollPane JSPGraficas7;
    private JScrollPane JSPGraficas8;
    private JScrollPane JSPGraficas9;
    private JScrollPane JSPHistorico;
    private JScrollPane JSPHistoricoSeg;
    private JTextArea JTAObservacion;
    public JTable JTBHistorico;
    public JTextFieldValidator JTFFPS2;
    private JFormattedTextField JTFFPSentadoD;
    private JFormattedTextField JTFFPSentadoS;
    public JTextFieldValidator JTFFSFc;
    public JTextFieldValidator JTFFSFr;
    public JTextFieldValidator JTFFSIMC;
    public JTextFieldValidator JTFFSPBrazo;
    public JTextFieldValidator JTFFSPCefalico;
    public JTextFieldValidator JTFFSPeso;
    public JTextFieldValidator JTFFSTalla;
    public JTextFieldValidator JTFFTemperatura;
    private JTable JTHistorico;
    private JTabbedPane JTPCDDatos;
    private JTabbedPane JTPGraficasCyD;
    private JCheckBox jCheckBox1;
    private JCheckBox jCheckBox2;
    private JCheckBox jCheckBox3;
    private JCheckBox jCheckBox4;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JPanel jPanel5;
    private JPanel jPanel6;
    private JScrollPane jScrollPane1;
    private ConsultasMySQL xct = new ConsultasMySQL();
    private Metodos xmt = new Metodos();
    private double imc = 0.0d;
    public long xCantPanel = 11;
    public Vector xPanelesActivos = new Vector();
    private String xJDC_FechaEvento = "";
    private String xJDC_FechaVitA = "";
    private String xJDC_FechaHierro = "";
    private String xJDC_FechaAntParasitario = "";
    private String xJDC_FechaAtnOdont = "";
    private String xJDC_FechaPCita = "";
    private String xJDC_FechaSulfatoDeZinc = "";
    private String xJDC_FechaVih = "";
    private String xJDC_FechaHemoglobina = "";
    private JP_IngresoProgramaCyD ingresoProgramaCyD = new JP_IngresoProgramaCyD();

    public JPGraficasPyP() {
        this.xedad = "";
        this.xEdadActual = 0;
        this.G1 = null;
        this.G2 = null;
        this.G3 = null;
        this.G4 = null;
        this.G5 = null;
        this.G6 = null;
        this.G7 = null;
        this.G8 = null;
        this.G9 = null;
        this.G10 = null;
        this.G11 = null;
        initComponents();
        double peso = Double.parseDouble(this.ingresoProgramaCyD.JTFPeso.getText());
        this.JTFFSPeso.setText(conver_GRaKG(peso));
        this.JTFFSTalla.setText(this.ingresoProgramaCyD.JTFTalla.getText());
        this.xSexo = clasesHistoriaCE.informacionAgendaMedicaDTO.getIdSexo();
        if (this.xSexo.equals("M")) {
            this.G1 = "29";
            this.G2 = "30";
            this.G3 = "31";
            this.G4 = "32";
            this.G5 = "33";
            this.G6 = "34";
            this.G7 = "35";
            this.G8 = "36";
            this.G9 = "37";
            this.G10 = "38";
            this.G11 = "39";
        } else {
            this.G1 = "40";
            this.G2 = "41";
            this.G3 = "42";
            this.G4 = "43";
            this.G5 = "44";
            this.G6 = "45";
            this.G7 = "46";
            this.G8 = "47";
            this.G9 = "48";
            this.G10 = "49";
            this.G11 = "50";
        }
        String sql = "SELECT DATE_FORMAT(`FechaNac`,'%Y%m')AS FechaNac, FechaNac AS AnioNac FROM `persona` WHERE (`Id_persona` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "');";
        ResultSet xrs = this.xct.traerRs(sql);
        try {
            if (xrs.next()) {
                this.xedad = xrs.getString(1);
                this.xEdadActual = Integer.valueOf(this.xmt.entregarEdadEnMeses(xrs.getString(2))).intValue();
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPGraficasPyP.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        if (clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioPrograma().longValue() != 0) {
            mBuscaHistorico();
            mBuscaHistoricoSeguimiento();
        } else {
            String sql2 = "insert into `g_usuarioxprograma` (`Id_Usuario`,`Id_Programa`,`FechaIngreso`,`Id_Atencion_Ingreso`,UsuarioS)  values ('" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "','4','" + this.xmt.formatoAMD.format(this.xmt.getFechaActual()) + "','" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
            clasesHistoriaCE.informacionAgendaMedicaDTO.setIdUsuarioPrograma(Long.valueOf(this.xct.ejecutarSQLId(sql2)));
            this.xct.cerrarConexionBd();
            mCrearModeloDatosSeguimiento();
        }
        this.JLEdadMeses.setText("" + this.xEdadActual);
        mLlenarVectorGraficas();
        mIniciarPanel();
        mVerificaExistencia();
        mActivaGraficas();
        this.JDC_FechaI.setDate(this.xmt.getFechaActual());
        xVerifica();
    }

    private boolean xVerifica() {
        boolean xExiste = false;
        String sql = "SELECT Id FROM `p_seguimiento_cyd` WHERE IdAtencion='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "'";
        ResultSet xrs = this.xct.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.first();
                xExiste = true;
                this.JBGuardar.setEnabled(false);
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPGraficasPyP.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return xExiste;
    }

    private void mActivaGraficas() {
        if (this.xEdadActual >= 0 && this.xEdadActual < 24) {
            int x = 0;
            while (x < this.JTPGraficasCyD.getComponentCount()) {
                if (this.JTPGraficasCyD.getComponent(x).getClass().getName().equals("javax.swing.JScrollPane")) {
                    JScrollPane xp = this.JTPGraficasCyD.getComponent(x);
                    if (xp.getName().equals(this.G2) || xp.getName().equals(this.G4) || xp.getName().equals(this.G7) || xp.getName().equals(this.G9) || xp.getName().equals(this.G10) || xp.getName().equals(this.G11)) {
                        this.JTPGraficasCyD.remove(x);
                        x--;
                    }
                }
                x++;
            }
            return;
        }
        if (this.xEdadActual >= 24 && this.xEdadActual < 36) {
            int x2 = 0;
            while (x2 < this.JTPGraficasCyD.getComponentCount()) {
                if (this.JTPGraficasCyD.getComponent(x2).getClass().getName().equals("javax.swing.JScrollPane")) {
                    JScrollPane xp2 = this.JTPGraficasCyD.getComponent(x2);
                    if (xp2.getName().equals(this.G10) || xp2.getName().equals(this.G11)) {
                        this.JTPGraficasCyD.remove(x2);
                        x2--;
                    }
                }
                x2++;
            }
            return;
        }
        if (this.xEdadActual >= 36 && this.xEdadActual < 60) {
            int x3 = 0;
            while (x3 < this.JTPGraficasCyD.getComponentCount()) {
                if (this.JTPGraficasCyD.getComponent(x3).getClass().getName().equals("javax.swing.JScrollPane")) {
                    JScrollPane xp3 = this.JTPGraficasCyD.getComponent(x3);
                    if (xp3.getName().equals(this.G1) || xp3.getName().equals(this.G3) || xp3.getName().equals(this.G6) || xp3.getName().equals(this.G8) || xp3.getName().equals(this.G10) || xp3.getName().equals(this.G11)) {
                        this.JTPGraficasCyD.remove(x3);
                        x3--;
                    }
                }
                x3++;
            }
            return;
        }
        if (this.xEdadActual >= 60 && this.xEdadActual < 72) {
            int x4 = 0;
            while (x4 < this.JTPGraficasCyD.getComponentCount()) {
                if (this.JTPGraficasCyD.getComponent(x4).getClass().getName().equals("javax.swing.JScrollPane")) {
                    JScrollPane xp4 = this.JTPGraficasCyD.getComponent(x4);
                    if (xp4.getName().equals(this.G1) || xp4.getName().equals(this.G3) || xp4.getName().equals(this.G6) || xp4.getName().equals(this.G8)) {
                        this.JTPGraficasCyD.remove(x4);
                        x4--;
                    }
                }
                x4++;
            }
            return;
        }
        if (this.xEdadActual >= 72 && this.xEdadActual <= 204) {
            int x5 = 0;
            while (x5 < this.JTPGraficasCyD.getComponentCount()) {
                if (this.JTPGraficasCyD.getComponent(x5).getClass().getName().equals("javax.swing.JScrollPane")) {
                    JScrollPane xp5 = this.JTPGraficasCyD.getComponent(x5);
                    if (xp5.getName().equals(this.G1) || xp5.getName().equals(this.G2) || xp5.getName().equals(this.G3) || xp5.getName().equals(this.G4) || xp5.getName().equals(this.G5) || xp5.getName().equals(this.G6) || xp5.getName().equals(this.G7) || xp5.getName().equals(this.G8) || xp5.getName().equals(this.G9)) {
                        this.JTPGraficasCyD.remove(x5);
                        x5--;
                    }
                }
                x5++;
            }
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Fecha", "FC(r/m)", "T(°C)", "Presión", "Edad(Mes)", "Talla(cm)", "Peso(Kg)", "IMC", "Per.Cefálico", "Observación", "FR(r/m)", "Per.Brazo", "PS2"}) { // from class: Historia.JPGraficasPyP.1
            Class[] types = {String.class, Double.class, Double.class, String.class, Integer.class, Double.class, Double.class, Double.class, Double.class, String.class, Double.class, String.class, Double.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBHistorico.setModel(this.xmodelo);
        this.JTBHistorico.getColumnModel().getColumn(0).setPreferredWidth(50);
        this.JTBHistorico.getColumnModel().getColumn(1).setPreferredWidth(20);
        this.JTBHistorico.getColumnModel().getColumn(2).setPreferredWidth(20);
        this.JTBHistorico.getColumnModel().getColumn(3).setPreferredWidth(20);
        this.JTBHistorico.getColumnModel().getColumn(4).setPreferredWidth(20);
        this.JTBHistorico.getColumnModel().getColumn(5).setPreferredWidth(20);
        this.JTBHistorico.getColumnModel().getColumn(6).setPreferredWidth(20);
        this.JTBHistorico.getColumnModel().getColumn(7).setPreferredWidth(20);
        this.JTBHistorico.getColumnModel().getColumn(8).setPreferredWidth(20);
        this.JTBHistorico.getColumnModel().getColumn(9).setPreferredWidth(50);
        this.JTBHistorico.getColumnModel().getColumn(10).setPreferredWidth(50);
        this.JTBHistorico.getColumnModel().getColumn(11).setPreferredWidth(50);
        this.JTBHistorico.getColumnModel().getColumn(12).setPreferredWidth(20);
    }

    private String conver_GRaKG(double num) {
        double convertir = num / 1000.0d;
        return String.valueOf(convertir);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatosSeguimiento() {
        this.xmodeloSeg = new DefaultTableModel(new Object[0], new String[]{"Id", "Fecha", "Edad Meses", "Lactancia Materna", "Casos Centinela", "Evento Vigilancia", "Fecha Evento", "Edad 2 Peso/Edad", "Edad 5 Talla/Edad", "Edad 5 Peso/Talla", "Edad 5 IMC/Edad", "Perimetro Cefalico", "Motricidad Fina", "Motricidad Gruesa", "Personal Social", "Audicion y Lenguaje", "Fecha Vitamina A", "Fecha Hierro", "Fecha Antiparasitario", "Fecha Odontologia", "Esquema Vacunacion", "Fecha Prox. Cita", "Fecha Sulfato de zinc", "Fecha Vhi", "Fecha Hemoglobina"}) { // from class: Historia.JPGraficasPyP.2
            Class[] types = {Long.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTHistorico;
        JTable jTable2 = this.JTHistorico;
        jTable.setAutoResizeMode(0);
        this.JTHistorico.setModel(this.xmodeloSeg);
        this.JTHistorico.getColumnModel().getColumn(0).setPreferredWidth(120);
        this.JTHistorico.getColumnModel().getColumn(1).setPreferredWidth(120);
        this.JTHistorico.getColumnModel().getColumn(2).setPreferredWidth(120);
        this.JTHistorico.getColumnModel().getColumn(3).setPreferredWidth(120);
        this.JTHistorico.getColumnModel().getColumn(4).setPreferredWidth(120);
        this.JTHistorico.getColumnModel().getColumn(5).setPreferredWidth(120);
        this.JTHistorico.getColumnModel().getColumn(6).setPreferredWidth(120);
        this.JTHistorico.getColumnModel().getColumn(7).setPreferredWidth(120);
        this.JTHistorico.getColumnModel().getColumn(8).setPreferredWidth(120);
        this.JTHistorico.getColumnModel().getColumn(9).setPreferredWidth(120);
        this.JTHistorico.getColumnModel().getColumn(10).setPreferredWidth(120);
        this.JTHistorico.getColumnModel().getColumn(11).setPreferredWidth(120);
        this.JTHistorico.getColumnModel().getColumn(12).setPreferredWidth(120);
        this.JTHistorico.getColumnModel().getColumn(13).setPreferredWidth(120);
        this.JTHistorico.getColumnModel().getColumn(14).setPreferredWidth(120);
        this.JTHistorico.getColumnModel().getColumn(15).setPreferredWidth(120);
        this.JTHistorico.getColumnModel().getColumn(16).setPreferredWidth(120);
        this.JTHistorico.getColumnModel().getColumn(17).setPreferredWidth(120);
        this.JTHistorico.getColumnModel().getColumn(18).setPreferredWidth(120);
        this.JTHistorico.getColumnModel().getColumn(19).setPreferredWidth(120);
        this.JTHistorico.getColumnModel().getColumn(20).setPreferredWidth(120);
        this.JTHistorico.getColumnModel().getColumn(21).setPreferredWidth(120);
        this.JTHistorico.getColumnModel().getColumn(22).setPreferredWidth(120);
        this.JTHistorico.getColumnModel().getColumn(23).setPreferredWidth(120);
        this.JTHistorico.getColumnModel().getColumn(24).setPreferredWidth(120);
    }

    private void mBuscaHistoricoSeguimiento() {
        String sql = "SELECT `Id`, `FechaR`, `EdadAlimentacion`, `LacMaternaExcl`, `CasoCentinela`, `EventoVigilacia`, IFNULL(DATE(CONCAT(MID(FechaEventoVig, 1,4),'-', MID(FechaEventoVig, 6,2),'-', MID(FechaEventoVig, 9,2))),'')`FechaEventoVig`, `PesoEdad2`, `TallaEdad5`, `PesoTalla5`, `IMCEdad`\n, `PCefalico`, `MotFina`, `MotGruesa`, `PerSocial`, `AudiLenguaje`, IFNULL(DATE(CONCAT(MID(FechaVitA, 1,4),'-', MID(FechaVitA, 6,2),'-', MID(FechaVitA, 9,2))),'')`FechaVitA`, IFNULL(DATE(CONCAT(MID(FechaHierro, 1,4),'-', MID(FechaHierro, 6,2),'-', MID(FechaHierro, 9,2))),'')`FechaHierro`, IFNULL(DATE(CONCAT(MID(FechaAntiPar, 1,4),'-', MID(FechaAntiPar, 6,2),'-', MID(FechaAntiPar, 9,2))),'')`FechaAntiPar`, \nIFNULL(DATE(CONCAT(MID(FechaOdont, 1,4),'-', MID(FechaOdont, 6,2),'-', MID(FechaOdont, 9,2))),'')`FechaOdont`, `EsqVacunacion`, IFNULL(DATE(CONCAT(MID(FechaPCita, 1,4),'-', MID(FechaPCita, 6,2),'-', MID(FechaPCita, 9,2))),'')`FechaPCita`,\nIFNULL(DATE(CONCAT(MID(FechaZinc, 1,4),'-', MID(FechaZinc, 6,2),'-', MID(FechaZinc, 9,2))),'') fechaZinc,IFNULL(DATE(CONCAT(MID(FechaVih, 1,4),'-', MID(FechaVih, 6,2),'-', MID(FechaVih, 9,2))),'') FechaVih, IFNULL(DATE(CONCAT(MID(FechaHemoglobina, 1,4),'-', MID(FechaHemoglobina, 6,2),'-', MID(FechaHemoglobina, 9,2))),'') fechaHemoglobina FROM `p_seguimiento_cyd` WHERE (`Id_Usuario_Programa` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioPrograma() + "')ORDER BY `FechaR` DESC;";
        try {
            System.out.println(sql);
            mCrearModeloDatosSeguimiento();
            ResultSet xrs = this.xct.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodeloSeg.addRow(this.xdato);
                    this.xmodeloSeg.setValueAt(Long.valueOf(xrs.getLong(1)), n, 0);
                    this.xmodeloSeg.setValueAt(xrs.getString(2), n, 1);
                    this.xmodeloSeg.setValueAt(xrs.getString(3), n, 2);
                    this.xmodeloSeg.setValueAt(xrs.getString(4), n, 3);
                    this.xmodeloSeg.setValueAt(xrs.getString(5), n, 4);
                    this.xmodeloSeg.setValueAt(xrs.getString(6), n, 5);
                    this.xmodeloSeg.setValueAt(xrs.getString(7), n, 6);
                    this.xmodeloSeg.setValueAt(xrs.getString(8), n, 7);
                    this.xmodeloSeg.setValueAt(xrs.getString(9), n, 8);
                    this.xmodeloSeg.setValueAt(xrs.getString(10), n, 9);
                    this.xmodeloSeg.setValueAt(xrs.getString(11), n, 10);
                    this.xmodeloSeg.setValueAt(xrs.getString(12), n, 11);
                    this.xmodeloSeg.setValueAt(xrs.getString(13), n, 12);
                    this.xmodeloSeg.setValueAt(xrs.getString(14), n, 13);
                    this.xmodeloSeg.setValueAt(xrs.getString(15), n, 14);
                    this.xmodeloSeg.setValueAt(xrs.getString(16), n, 15);
                    this.xmodeloSeg.setValueAt(xrs.getString(17), n, 16);
                    this.xmodeloSeg.setValueAt(xrs.getString(18), n, 17);
                    this.xmodeloSeg.setValueAt(xrs.getString(19), n, 18);
                    this.xmodeloSeg.setValueAt(xrs.getString(20), n, 19);
                    this.xmodeloSeg.setValueAt(xrs.getString(21), n, 20);
                    this.xmodeloSeg.setValueAt(xrs.getString(22), n, 21);
                    this.xmodeloSeg.setValueAt(xrs.getString(23), n, 22);
                    this.xmodeloSeg.setValueAt(xrs.getString(24), n, 23);
                    this.xmodeloSeg.setValueAt(xrs.getString(25), n, 24);
                    n++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPGraficasPyP.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCrear_ExamenFisico() {
        try {
            Metodos xmt = new Metodos();
            ConsultasMySQL xmtc = new ConsultasMySQL();
            String sqlz = "SELECT Id FROM h_examenfisico WHERE (Id_Atencion ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "')";
            ResultSet xrsm = xmtc.traerRs(sqlz);
            if (!xrsm.next()) {
                String sql = "INSERT INTO h_examenfisico(Id_Atencion, Id_Usuario_Programa, FCardiaca, FRespiratoria, Temperatura, TArtSentadoD, TArtSentadoS, Talla, Peso, IMC, PerimetroCefalico, PerimetroBrazo, Fecha, UsuarioS,`Ps2`) VALUES ( '" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "','" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioPrograma() + "','" + this.JTFFSFc.getText() + "','" + this.JTFFSFr.getText() + "','" + this.JTFFTemperatura.getText() + "','" + this.JTFFPSentadoD.getValue() + "','" + this.JTFFPSentadoS.getValue() + "','" + this.JTFFSTalla.getText() + "','" + this.JTFFSPeso.getText() + "'," + this.JTFFSIMC.getText().replace(",", ".") + ",'" + this.JTFFSPCefalico.getText() + "','" + this.JTFFSPBrazo.getText() + "','" + xmt.formatoAMDH24.format(xmt.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "','" + this.JTFFPS2.getText() + "')";
                System.out.println(sql);
                this.xct.ejecutarSQL(sql);
                this.xct.cerrarConexionBd();
                mBuscaHistorico();
                this.JBTGuardar.setEnabled(false);
                for (int x = 0; x < this.JTPGraficasCyD.getComponentCount(); x++) {
                    if (this.JTPGraficasCyD.getComponent(x).getClass().getName().equals("javax.swing.JScrollPane")) {
                        JScrollPane xp = this.JTPGraficasCyD.getComponent(x);
                        if (!mVerificaGraficasGuardar(xp.getName())) {
                            mGuardarGrafica(Long.valueOf(xp.getName()).longValue());
                        }
                    }
                }
            } else {
                String sql2 = " UPDATE  `h_examenfisico` SET  `Id_Usuario_Programa`=" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioPrograma() + ", `FCardiaca`=" + this.JTFFSFc.getText() + ", `FRespiratoria`=" + this.JTFFSFr.getText() + ", `Temperatura`=" + this.JTFFTemperatura.getText() + ", TArtSentadoD='" + this.JTFFPSentadoD.getValue() + "', TArtSentadoS='" + this.JTFFPSentadoS.getValue() + "', `Talla`=" + this.JTFFSTalla.getText() + ", `Peso`=" + this.JTFFSPeso.getText() + ", `IMC`=" + this.JTFFSIMC.getText().replace(",", ".") + ", `PerimetroCefalico`=" + this.JTFFSPCefalico.getText() + ", PerimetroBrazo=" + this.JTFFSPBrazo.getText() + ",  `Fecha`='" + this.xmt.formatoAMD.format(this.xmt.getFechaActual()) + "' , `UsuarioS`='" + Principal.usuarioSistemaDTO.getLogin() + "', `Ps2` = " + this.JTFFPS2.getText() + " WHERE Id_Atencion='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "'";
                System.out.println("ejecuta... " + sql2);
                this.xct.ejecutarSQL(sql2);
                this.xct.cerrarConexionBd();
                mBuscaHistorico();
                this.JBTGuardar.setEnabled(false);
                for (int x2 = 0; x2 < this.JTPGraficasCyD.getComponentCount(); x2++) {
                    if (this.JTPGraficasCyD.getComponent(x2).getClass().getName().equals("javax.swing.JScrollPane")) {
                        JScrollPane xp2 = this.JTPGraficasCyD.getComponent(x2);
                        if (!mVerificaGraficasGuardar(xp2.getName())) {
                            mGuardarGrafica(Long.valueOf(xp2.getName()).longValue());
                        }
                    }
                }
            }
            xrsm.close();
            xmtc.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPGraficasPyP.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private boolean mVerificaGraficasGuardar(String idGrafica) {
        boolean xExiste = false;
        for (int i = 0; i < this.xPanelesActivos.size(); i++) {
            if (this.xPanelesActivos.elementAt(i).equals(idGrafica)) {
                xExiste = true;
            }
        }
        return xExiste;
    }

    private void mBuscaHistorico() {
        String sql = "SELECT `h_atencion`.`Fecha_Atencion` , `h_examenfisico`.`FCardiaca` , `h_examenfisico`.`Temperatura`  , IF(h_examenfisico.`TArtSentadoD` =0,'', CONCAT(h_examenfisico.`TArtSentadoS` ,'/', h_examenfisico.`TArtSentadoD`)) TArterial  , `h_examenfisico`.`Talla` , `h_examenfisico`.`Peso` , `h_examenfisico`.`IMC`,DATE_FORMAT(`h_atencion`.`Fecha_Atencion`,'%Y%m') as FecAtencion ,PerimetroCefalico,IF(Observacion IS NULL, '',Observacion) AS Observacion, h_examenfisico.`FRespiratoria`, h_examenfisico.PerimetroBrazo,`h_examenfisico`.`Ps2`  FROM `h_examenfisico` INNER JOIN  `h_atencion`   ON (`h_examenfisico`.`Id_Atencion` = `h_atencion`.`Id`)  WHERE (`h_examenfisico`.`Id_Usuario_Programa` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioPrograma() + "') group by `h_atencion`.`Id` ORDER BY `h_atencion`.`Fecha_Atencion` DESC ";
        try {
            System.out.println(sql);
            mCrearModeloDatos();
            ResultSet xrs = this.xct.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(xrs.getString(1), n, 0);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(2)), n, 1);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(3)), n, 2);
                    this.xmodelo.setValueAt(xrs.getString(4), n, 3);
                    String sql2 = "SELECT PERIOD_DIFF('" + xrs.getString("FecAtencion") + "','" + this.xedad + "') AS edad_actual";
                    ConsultasMySQL ct = new ConsultasMySQL();
                    ResultSet rs = ct.traerRs(sql2);
                    if (rs.next()) {
                        rs.first();
                        this.xmodelo.setValueAt(Integer.valueOf(rs.getInt(1)), n, 4);
                    }
                    rs.close();
                    ct.cerrarConexionBd();
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(5)), n, 5);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(6)), n, 6);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(7)), n, 7);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(9)), n, 8);
                    this.xmodelo.setValueAt(xrs.getString(10), n, 9);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble("FRespiratoria")), n, 10);
                    this.xmodelo.setValueAt(xrs.getString("PerimetroBrazo"), n, 11);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble("Ps2")), n, 12);
                    n++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPGraficasPyP.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:Historia/JPGraficasPyP$Imagen.class */
    public class Imagen extends JPanel {
        private int[][] xCoordenada;
        private ConsultasMySQL xct = new ConsultasMySQL();
        private JPGraficasPyP xJPGraficasPyP;
        private String xImagen;
        private String xtitulo;
        private int x;
        private int y;
        private int xTipoGrafica;
        private long xRangoX;
        private long xRangoY;
        private String folder;
        private JPanel xpanel;

        public Imagen(JPGraficasPyP xJPGraficasPyP, String xTitulo, String xImagen, int x, int y, int xTipoGrafica, JPanel xPanel, long xRangoX, long xRangoY, String sexo) {
            this.x = 0;
            this.y = 0;
            this.xTipoGrafica = 0;
            this.xRangoX = 0L;
            this.xRangoY = 0L;
            setBounds(-22, -20, 896, 570);
            this.xJPGraficasPyP = xJPGraficasPyP;
            this.xImagen = xImagen;
            if (sexo.equals("M")) {
                this.folder = "Niños";
            } else {
                this.folder = "Niñas";
            }
            this.x = x;
            this.y = y;
            this.xTipoGrafica = xTipoGrafica;
            this.xtitulo = xTitulo;
            this.xRangoX = xRangoX;
            this.xRangoY = xRangoY;
            this.xpanel = xPanel;
        }

        public void paint(Graphics grafico) {
            Graphics2D g2 = (Graphics2D) grafico;
            Dimension height = getSize();
            ImageIcon Img = new ImageIcon(getClass().getResource("/Imagenes/GraficasCyD/" + this.folder + "/" + this.xImagen + ".PNG"));
            grafico.drawImage(Img.getImage(), 0, 0, height.width, height.height, (ImageObserver) null);
            if (this.xJPGraficasPyP.JTBHistorico.getRowCount() > -1) {
                int xData = 0;
                int x = 0;
                int y = 0;
                this.xCoordenada = new int[this.xJPGraficasPyP.JTBHistorico.getRowCount()][2];
                for (int j = 0; j < this.xJPGraficasPyP.JTBHistorico.getRowCount(); j++) {
                    String sql = " SELECT `RangoInf` , `RangoSUp`  , `ValorPXinf` , `ValorPXSup`  ,(RangoSUp-RangoInf) AS CantidadNo  ,(ValorPXSup-ValorPXinf) AS CantPX  ,ROUND(((ValorPXSup-ValorPXinf)/(RangoSUp-RangoInf))) AS CM_en_PX  , ('" + Double.valueOf(this.xJPGraficasPyP.JTBHistorico.getValueAt(j, this.x).toString()) + "'-RangoInf) AS Diferencia  , (('" + Double.valueOf(this.xJPGraficasPyP.JTBHistorico.getValueAt(j, this.x).toString()) + "'-RangoInf)*(ROUND(((ValorPXSup-ValorPXinf)/(RangoSUp-RangoInf))))) AS CM_en_Px_Graf  , ((('" + Double.valueOf(this.xJPGraficasPyP.JTBHistorico.getValueAt(j, this.x).toString()) + "'-RangoInf)*(ROUND(((ValorPXSup-ValorPXinf)/(RangoSUp-RangoInf)))))+ValorPXinf) AS Coordenada_X  FROM `p_tabla_referencia` WHERE (`Eje` ='x'  AND `IdTipoGrafica` ='" + this.xTipoGrafica + "'  AND '" + Double.valueOf(this.xJPGraficasPyP.JTBHistorico.getValueAt(j, this.x).toString()) + "'>=`RangoInf`  AND '" + Double.valueOf(this.xJPGraficasPyP.JTBHistorico.getValueAt(j, this.x).toString()) + "'<`RangoSUp` );";
                    System.out.println("X---------------------------------------------------------------------- " + sql);
                    ResultSet xrs = this.xct.traerRs(sql);
                    try {
                        if (xrs.next()) {
                            xrs.last();
                            xrs.beforeFirst();
                            while (xrs.next()) {
                                this.xCoordenada[x][0] = xrs.getInt("Coordenada_X");
                                x++;
                                xData = 1;
                            }
                        }
                        xrs.close();
                        this.xct.cerrarConexionBd();
                    } catch (SQLException ex) {
                        Logger.getLogger(JPGraficasPyP.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                    }
                    if (xData == 1) {
                        String sql2 = "SELECT `RangoInf` , `RangoSUp`  , `ValorPXinf` , `ValorPXSup`  ,(RangoSUp-RangoInf) AS CantidadNo  ,(ValorPXSup-ValorPXinf)*(-1) AS CantPX  ,ROUND(((ValorPXSup-ValorPXinf)/(RangoSUp-RangoInf)))*(-1) AS CM_en_PX  , ('" + Double.valueOf(this.xJPGraficasPyP.JTBHistorico.getValueAt(j, this.y).toString()) + "'-RangoInf) AS Diferencia  , (('" + Double.valueOf(this.xJPGraficasPyP.JTBHistorico.getValueAt(j, this.y).toString()) + "'-RangoInf)*(ROUND(((ValorPXSup-ValorPXinf)/(RangoSUp-RangoInf)))))*(-1) AS CM_en_Px_Graf  , (ValorPXinf+(('" + Double.valueOf(this.xJPGraficasPyP.JTBHistorico.getValueAt(j, this.y).toString()) + "'-RangoInf)*(ROUND(((ValorPXSup-ValorPXinf)/(RangoSUp-RangoInf)))))) AS Coordenada_Y  FROM `p_tabla_referencia` WHERE (`Eje` ='y'  AND `IdTipoGrafica` ='" + this.xTipoGrafica + "'  AND '" + Double.valueOf(this.xJPGraficasPyP.JTBHistorico.getValueAt(j, this.y).toString()) + "'>=`RangoInf`  AND '" + Double.valueOf(this.xJPGraficasPyP.JTBHistorico.getValueAt(j, this.y).toString()) + "'<`RangoSUp`);";
                        System.out.println("Y-------------------------------------------------------------------- " + sql2);
                        ResultSet xrs2 = this.xct.traerRs(sql2);
                        try {
                            if (xrs2.next()) {
                                xrs2.beforeFirst();
                                while (xrs2.next()) {
                                    this.xCoordenada[y][1] = xrs2.getInt("Coordenada_Y");
                                    y++;
                                    xData = 0;
                                }
                            }
                            xrs2.close();
                            this.xct.cerrarConexionBd();
                        } catch (SQLException ex2) {
                            Logger.getLogger(JPGraficasPyP.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex2);
                        }
                    }
                }
            }
            for (int i = 0; i < this.xCoordenada.length; i++) {
                try {
                    if (i != 0) {
                        grafico.setColor(Color.red);
                        if (this.xCoordenada[i][0] > 0 && this.xCoordenada[i][1] > 0) {
                            g2.setStroke(new BasicStroke(4.0f));
                            g2.draw(new Line2D.Double(this.xCoordenada[i - 1][0], this.xCoordenada[i - 1][1], this.xCoordenada[i][0], this.xCoordenada[i][1]));
                        }
                    }
                    System.out.println(" Aqui miro que hay en la coordenadas X--> " + this.xCoordenada[i][0] + " Y--> " + this.xCoordenada[i][1]);
                    if (this.xCoordenada[i][0] != 0 && this.xCoordenada[i][1] != 0) {
                        dibuja_coordenada(g2, this.xCoordenada[i][0], this.xCoordenada[i][1]);
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                }
            }
            setOpaque(false);
            super.paintComponent(grafico);
        }

        private void dibuja_coordenada(Graphics2D g2, double x, double y) {
            NumberFormat mf = NumberFormat.getInstance();
            mf.setMaximumFractionDigits(2);
            g2.setColor(new Color(0, 0, 255));
            g2.setStroke(new BasicStroke(9.5f));
            g2.fill(new Ellipse2D.Double(x, y, 3.0d, 3.0d));
        }
    }

    /* JADX WARN: Type inference failed for: r3v289, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JTPCDDatos = new JTabbedPane();
        this.JPDatos = new JPanel();
        this.JSPHistorico = new JScrollPane();
        this.JTBHistorico = new JTable();
        this.JTFFSFc = new JTextFieldValidator();
        this.JTFFSFr = new JTextFieldValidator();
        this.JTFFTemperatura = new JTextFieldValidator();
        this.JTFFSTalla = new JTextFieldValidator();
        this.JTFFSPeso = new JTextFieldValidator();
        this.JTFFSIMC = new JTextFieldValidator();
        this.JBTGuardar = new JButton();
        this.JTFFSPCefalico = new JTextFieldValidator();
        this.JLBPSentado = new JLabel();
        this.JTFFPSentadoS = new JFormattedTextField();
        this.JLBPBSentado = new JLabel();
        this.JTFFPSentadoD = new JFormattedTextField();
        this.JTFFSPBrazo = new JTextFieldValidator();
        this.JLEdadMeses = new JLabel();
        this.JTFFPS2 = new JTextFieldValidator();
        this.JPGrafica = new JPanel();
        this.JTPGraficasCyD = new JTabbedPane();
        this.JSPGraficas1 = new JScrollPane();
        this.JSPGraficas2 = new JScrollPane();
        this.JSPGraficas3 = new JScrollPane();
        this.JSPGraficas4 = new JScrollPane();
        this.JSPGraficas5 = new JScrollPane();
        this.JSPGraficas6 = new JScrollPane();
        this.JSPGraficas7 = new JScrollPane();
        this.JSPGraficas8 = new JScrollPane();
        this.JSPGraficas9 = new JScrollPane();
        this.JSPGraficas10 = new JScrollPane();
        this.JSPGraficas11 = new JScrollPane();
        this.jPanel1 = new JPanel();
        this.jScrollPane1 = new JScrollPane();
        this.JTAObservacion = new JTextArea();
        this.JBTGuardarObs = new JButton();
        this.jPanel2 = new JPanel();
        this.jPanel3 = new JPanel();
        this.JDC_FechaI = new JDateChooser();
        this.JCBEdadMeses = new JComboBox();
        this.JCBLacMaterna = new JComboBox();
        this.JCBCCentinela = new JComboBox();
        this.JCBEventoSPublica = new JComboBox();
        this.JDC_FechaEvento = new JDateChooser();
        this.jPanel4 = new JPanel();
        this.JCBPesoEdad = new JComboBox();
        this.JCBTallaEdad = new JComboBox();
        this.JCBPesoTalla = new JComboBox();
        this.JCBIMCEdad = new JComboBox();
        this.JCBPCefalico = new JComboBox();
        this.jPanel5 = new JPanel();
        this.JCBMFina = new JComboBox();
        this.JCBMGruesa = new JComboBox();
        this.JCBPSocial = new JComboBox();
        this.JCBALenguaje = new JComboBox();
        this.jPanel6 = new JPanel();
        this.JDC_FechaVitA = new JDateChooser();
        this.JDC_FechaHierro = new JDateChooser();
        this.JDC_FechaAntParasitario = new JDateChooser();
        this.JDC_FechaAtnOdont = new JDateChooser();
        this.JCBEsqVacunacion = new JComboBox();
        this.JDC_FechaPCita = new JDateChooser();
        this.jCheckBox1 = new JCheckBox();
        this.jCheckBox2 = new JCheckBox();
        this.jCheckBox3 = new JCheckBox();
        this.jCheckBox4 = new JCheckBox();
        this.JDC_FechaSulfatoDeZinc = new JDateChooser();
        this.JCHAplicaSulfatoDeZinc = new JCheckBox();
        this.JDC_FechaVih = new JDateChooser();
        this.JCHAplicaVih = new JCheckBox();
        this.JDC_FechaHemoglobina = new JDateChooser();
        this.JCHAplicaHemoglobina = new JCheckBox();
        this.JSPHistoricoSeg = new JScrollPane();
        this.JTHistorico = new JTable();
        this.JBGuardar = new JButton();
        setName("JPGraficasPyP");
        this.JTPCDDatos.setForeground(new Color(0, 107, 0));
        this.JTPCDDatos.setFont(new Font("Arial", 1, 14));
        this.JTPCDDatos.addChangeListener(new ChangeListener() { // from class: Historia.JPGraficasPyP.3
            public void stateChanged(ChangeEvent evt) {
                JPGraficasPyP.this.JTPCDDatosStateChanged(evt);
            }
        });
        this.JPDatos.setName("JPGraficasPyP");
        this.JSPHistorico.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.JTBHistorico.setFont(new Font("Arial", 1, 12));
        this.JTBHistorico.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTBHistorico.setSelectionBackground(new Color(255, 255, 255));
        this.JTBHistorico.setSelectionForeground(new Color(255, 0, 0));
        this.JTBHistorico.setSelectionMode(0);
        this.JSPHistorico.setViewportView(this.JTBHistorico);
        this.JTFFSFc.setBorder(BorderFactory.createTitledBorder((Border) null, "Fc (p/m)", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFSFc.setHorizontalAlignment(0);
        this.JTFFSFc.setText("0");
        this.JTFFSFc.setToolTipText("Frecuencia Cardiáca");
        this.JTFFSFc.setExprecionRegular("^[0-9]*$");
        this.JTFFSFc.setFocusAccelerator('C');
        this.JTFFSFc.setFont(new Font("Arial", 1, 12));
        this.JTFFSFc.addActionListener(new ActionListener() { // from class: Historia.JPGraficasPyP.4
            public void actionPerformed(ActionEvent evt) {
                JPGraficasPyP.this.JTFFSFcActionPerformed(evt);
            }
        });
        this.JTFFSFc.addFocusListener(new FocusAdapter() { // from class: Historia.JPGraficasPyP.5
            public void focusGained(FocusEvent evt) {
                JPGraficasPyP.this.JTFFSFcFocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                JPGraficasPyP.this.JTFFSFcFocusLost(evt);
            }
        });
        this.JTFFSFr.setBorder(BorderFactory.createTitledBorder((Border) null, "Fr (r/m)", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFSFr.setHorizontalAlignment(0);
        this.JTFFSFr.setText("0");
        this.JTFFSFr.setToolTipText("Frecuencia Respiratoria");
        this.JTFFSFr.setExprecionRegular("^[0-9]*$");
        this.JTFFSFr.setFocusAccelerator('C');
        this.JTFFSFr.setFont(new Font("Arial", 1, 12));
        this.JTFFSFr.addFocusListener(new FocusAdapter() { // from class: Historia.JPGraficasPyP.6
            public void focusGained(FocusEvent evt) {
                JPGraficasPyP.this.JTFFSFrFocusGained(evt);
            }
        });
        this.JTFFTemperatura.setBorder(BorderFactory.createTitledBorder((Border) null, "T (ªC)", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFTemperatura.setHorizontalAlignment(0);
        this.JTFFTemperatura.setText("0");
        this.JTFFTemperatura.setToolTipText("Temperatura");
        this.JTFFTemperatura.setExprecionRegular("^[0-9.]*$");
        this.JTFFTemperatura.setFocusAccelerator('C');
        this.JTFFTemperatura.setFont(new Font("Arial", 1, 12));
        this.JTFFTemperatura.addFocusListener(new FocusAdapter() { // from class: Historia.JPGraficasPyP.7
            public void focusGained(FocusEvent evt) {
                JPGraficasPyP.this.JTFFTemperaturaFocusGained(evt);
            }
        });
        this.JTFFTemperatura.addActionListener(new ActionListener() { // from class: Historia.JPGraficasPyP.8
            public void actionPerformed(ActionEvent evt) {
                JPGraficasPyP.this.JTFFTemperaturaActionPerformed(evt);
            }
        });
        this.JTFFSTalla.setBorder(BorderFactory.createTitledBorder((Border) null, "Talla (cm)", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFSTalla.setHorizontalAlignment(0);
        this.JTFFSTalla.setText("0");
        this.JTFFSTalla.setToolTipText("Talla en Centimetros");
        this.JTFFSTalla.setExprecionRegular("^[0.0-9]*$");
        this.JTFFSTalla.setFocusAccelerator('C');
        this.JTFFSTalla.setFont(new Font("Arial", 1, 12));
        this.JTFFSTalla.addFocusListener(new FocusAdapter() { // from class: Historia.JPGraficasPyP.9
            public void focusGained(FocusEvent evt) {
                JPGraficasPyP.this.JTFFSTallaFocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                JPGraficasPyP.this.JTFFSTallaFocusLost(evt);
            }
        });
        this.JTFFSTalla.addActionListener(new ActionListener() { // from class: Historia.JPGraficasPyP.10
            public void actionPerformed(ActionEvent evt) {
                JPGraficasPyP.this.JTFFSTallaActionPerformed(evt);
            }
        });
        this.JTFFSPeso.setBorder(BorderFactory.createTitledBorder((Border) null, "Peso (Kg)", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFSPeso.setHorizontalAlignment(0);
        this.JTFFSPeso.setText("0");
        this.JTFFSPeso.setToolTipText("Peso en Kilogramos");
        this.JTFFSPeso.setExprecionRegular("^[0.0-9]*$");
        this.JTFFSPeso.setFocusAccelerator('C');
        this.JTFFSPeso.setFont(new Font("Arial", 1, 12));
        this.JTFFSPeso.addFocusListener(new FocusAdapter() { // from class: Historia.JPGraficasPyP.11
            public void focusGained(FocusEvent evt) {
                JPGraficasPyP.this.JTFFSPesoFocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                JPGraficasPyP.this.JTFFSPesoFocusLost(evt);
            }
        });
        this.JTFFSPeso.addActionListener(new ActionListener() { // from class: Historia.JPGraficasPyP.12
            public void actionPerformed(ActionEvent evt) {
                JPGraficasPyP.this.JTFFSPesoActionPerformed(evt);
            }
        });
        this.JTFFSIMC.setBorder(BorderFactory.createTitledBorder((Border) null, "IMC", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFSIMC.setHorizontalAlignment(0);
        this.JTFFSIMC.setText("0");
        this.JTFFSIMC.setToolTipText("Indice de Masa Corporal");
        this.JTFFSIMC.setDisabledTextColor(new Color(255, 255, 255));
        this.JTFFSIMC.setExprecionRegular("^[0-9]{1,5}(\\,[0-9]{0,2})?$");
        this.JTFFSIMC.setFocusable(false);
        this.JTFFSIMC.setFont(new Font("Arial", 1, 24));
        this.JBTGuardar.setFont(new Font("Arial", 1, 14));
        this.JBTGuardar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTGuardar.setText("Guardar");
        this.JBTGuardar.addActionListener(new ActionListener() { // from class: Historia.JPGraficasPyP.13
            public void actionPerformed(ActionEvent evt) {
                JPGraficasPyP.this.JBTGuardarActionPerformed(evt);
            }
        });
        this.JTFFSPCefalico.setBorder(BorderFactory.createTitledBorder((Border) null, "Per. Cefálico", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFSPCefalico.setHorizontalAlignment(0);
        this.JTFFSPCefalico.setText("0");
        this.JTFFSPCefalico.setToolTipText("Perímetro Cefálico");
        this.JTFFSPCefalico.setExprecionRegular("^[0.0-9]*$");
        this.JTFFSPCefalico.setFocusAccelerator('C');
        this.JTFFSPCefalico.setFont(new Font("Arial", 1, 12));
        this.JTFFSPCefalico.addFocusListener(new FocusAdapter() { // from class: Historia.JPGraficasPyP.14
            public void focusGained(FocusEvent evt) {
                JPGraficasPyP.this.JTFFSPCefalicoFocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                JPGraficasPyP.this.JTFFSPCefalicoFocusLost(evt);
            }
        });
        this.JTFFSPCefalico.addActionListener(new ActionListener() { // from class: Historia.JPGraficasPyP.15
            public void actionPerformed(ActionEvent evt) {
                JPGraficasPyP.this.JTFFSPCefalicoActionPerformed(evt);
            }
        });
        this.JLBPSentado.setFont(new Font("Arial", 1, 12));
        this.JLBPSentado.setForeground(Color.blue);
        this.JLBPSentado.setHorizontalAlignment(0);
        this.JLBPSentado.setText("Presión");
        this.JTFFPSentadoS.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.JTFFPSentadoS.setHorizontalAlignment(4);
        this.JTFFPSentadoS.setFont(new Font("Arial", 1, 12));
        this.JTFFPSentadoS.setName("fechanaciemiento");
        this.JTFFPSentadoS.setValue(new Integer(0));
        this.JTFFPSentadoS.addActionListener(new ActionListener() { // from class: Historia.JPGraficasPyP.16
            public void actionPerformed(ActionEvent evt) {
                JPGraficasPyP.this.JTFFPSentadoSActionPerformed(evt);
            }
        });
        this.JTFFPSentadoS.addFocusListener(new FocusAdapter() { // from class: Historia.JPGraficasPyP.17
            public void focusLost(FocusEvent evt) {
                JPGraficasPyP.this.JTFFPSentadoSFocusLost(evt);
            }
        });
        this.JLBPBSentado.setFont(new Font("Arial", 1, 18));
        this.JLBPBSentado.setForeground(Color.blue);
        this.JLBPBSentado.setHorizontalAlignment(0);
        this.JLBPBSentado.setText("/");
        this.JTFFPSentadoD.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.JTFFPSentadoD.setHorizontalAlignment(4);
        this.JTFFPSentadoD.setFont(new Font("Arial", 1, 12));
        this.JTFFPSentadoD.setName("fechanaciemiento");
        this.JTFFPSentadoD.setValue(new Integer(0));
        this.JTFFPSentadoD.addActionListener(new ActionListener() { // from class: Historia.JPGraficasPyP.18
            public void actionPerformed(ActionEvent evt) {
                JPGraficasPyP.this.JTFFPSentadoDActionPerformed(evt);
            }
        });
        this.JTFFPSentadoD.addFocusListener(new FocusAdapter() { // from class: Historia.JPGraficasPyP.19
            public void focusLost(FocusEvent evt) {
                JPGraficasPyP.this.JTFFPSentadoDFocusLost(evt);
            }
        });
        this.JTFFSPBrazo.setBorder(BorderFactory.createTitledBorder((Border) null, "Per. Brazo", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFSPBrazo.setHorizontalAlignment(0);
        this.JTFFSPBrazo.setText("0");
        this.JTFFSPBrazo.setToolTipText("Perímetro brazo");
        this.JTFFSPBrazo.setExprecionRegular("^[0-9]*$");
        this.JTFFSPBrazo.setFocusAccelerator('C');
        this.JTFFSPBrazo.setFont(new Font("Arial", 1, 12));
        this.JTFFSPBrazo.addActionListener(new ActionListener() { // from class: Historia.JPGraficasPyP.20
            public void actionPerformed(ActionEvent evt) {
                JPGraficasPyP.this.JTFFSPBrazoActionPerformed(evt);
            }
        });
        this.JTFFSPBrazo.addFocusListener(new FocusAdapter() { // from class: Historia.JPGraficasPyP.21
            public void focusGained(FocusEvent evt) {
                JPGraficasPyP.this.JTFFSPBrazoFocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                JPGraficasPyP.this.JTFFSPBrazoFocusLost(evt);
            }
        });
        this.JLEdadMeses.setFont(new Font("Arial", 1, 14));
        this.JLEdadMeses.setForeground(new Color(0, 102, 0));
        this.JLEdadMeses.setHorizontalAlignment(0);
        this.JLEdadMeses.setText("0");
        this.JLEdadMeses.setBorder(BorderFactory.createTitledBorder((Border) null, "Edad en meses", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFPS2.setBorder(BorderFactory.createTitledBorder((Border) null, "Ps2", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFPS2.setHorizontalAlignment(0);
        this.JTFFPS2.setText("0");
        this.JTFFPS2.setToolTipText("Temperatura");
        this.JTFFPS2.setExprecionRegular("^[0-9.]*$");
        this.JTFFPS2.setFocusAccelerator('C');
        this.JTFFPS2.setFont(new Font("Arial", 1, 12));
        this.JTFFPS2.addFocusListener(new FocusAdapter() { // from class: Historia.JPGraficasPyP.22
            public void focusGained(FocusEvent evt) {
                JPGraficasPyP.this.JTFFPS2FocusGained(evt);
            }
        });
        this.JTFFPS2.addActionListener(new ActionListener() { // from class: Historia.JPGraficasPyP.23
            public void actionPerformed(ActionEvent evt) {
                JPGraficasPyP.this.JTFFPS2ActionPerformed(evt);
            }
        });
        GroupLayout JPDatosLayout = new GroupLayout(this.JPDatos);
        this.JPDatos.setLayout(JPDatosLayout);
        JPDatosLayout.setHorizontalGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JSPHistorico, GroupLayout.Alignment.TRAILING).addComponent(this.JBTGuardar, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addGroup(GroupLayout.Alignment.TRAILING, JPDatosLayout.createSequentialGroup().addGap(0, 0, 32767).addGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosLayout.createSequentialGroup().addGap(2, 2, 2).addComponent(this.JLBPSentado, -2, 103, -2)).addGroup(JPDatosLayout.createSequentialGroup().addComponent(this.JTFFPSentadoS, -2, 45, -2).addGap(4, 4, 4).addComponent(this.JLBPBSentado).addGap(4, 4, 4).addComponent(this.JTFFPSentadoD, -2, 45, -2))).addGap(548, 548, 548).addComponent(this.JLEdadMeses, -2, 120, -2).addGap(47, 47, 47)).addGroup(JPDatosLayout.createSequentialGroup().addComponent(this.JTFFSFc, -2, 80, -2).addGap(5, 5, 5).addComponent(this.JTFFSFr, -2, 76, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFTemperatura, -2, 67, -2).addGap(4, 4, 4).addComponent(this.JTFFSTalla, -2, 90, -2).addGap(5, 5, 5).addComponent(this.JTFFSPeso, -2, 90, -2).addGap(5, 5, 5).addComponent(this.JTFFSIMC, -1, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFSPCefalico, -2, 105, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFSPBrazo, -2, 91, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFPS2, -2, 69, -2))).addContainerGap(30, 32767)));
        JPDatosLayout.setVerticalGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPDatosLayout.createSequentialGroup().addGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPDatosLayout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.JLBPSentado).addGap(5, 5, 5).addGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFFPSentadoS, -2, 25, -2).addComponent(this.JLBPBSentado, -2, 23, -2).addComponent(this.JTFFPSentadoD, -2, 25, -2)).addGap(2, 2, 2)).addGroup(GroupLayout.Alignment.LEADING, JPDatosLayout.createSequentialGroup().addContainerGap().addComponent(this.JLEdadMeses, -2, 48, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED))).addGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFFSIMC, -2, 0, 32767).addComponent(this.JTFFSPeso, -1, -1, 32767).addGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFSPBrazo, -2, 50, -2).addComponent(this.JTFFPS2, -2, 50, -2).addComponent(this.JTFFSPCefalico, -1, -1, 32767)).addGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFSFr, -2, 50, -2).addComponent(this.JTFFSFc, -2, 50, -2).addComponent(this.JTFFSTalla, -2, 50, -2).addComponent(this.JTFFTemperatura, -2, 50, -2))).addGap(10, 10, 10).addComponent(this.JBTGuardar).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPHistorico, -2, 362, -2).addGap(208, 208, 208)));
        this.JTPCDDatos.addTab("DATOS", this.JPDatos);
        this.JPGrafica.setMaximumSize(new Dimension(856, 611));
        this.JPGrafica.setMinimumSize(new Dimension(856, 611));
        this.JSPGraficas1.setName("1");
        this.JTPGraficasCyD.addTab("1.Peso/Talla 0-2", this.JSPGraficas1);
        this.JSPGraficas2.setName("2");
        this.JTPGraficasCyD.addTab("2.Peso/Talla 2-5", this.JSPGraficas2);
        this.JSPGraficas3.setName("3");
        this.JTPGraficasCyD.addTab("3.Talla/Edad 0-2", this.JSPGraficas3);
        this.JSPGraficas4.setName("4");
        this.JTPGraficasCyD.addTab("4.Talla/Edad 2-5", this.JSPGraficas4);
        this.JSPGraficas5.setName("5");
        this.JTPGraficasCyD.addTab("5.PerCefálico 0-5", this.JSPGraficas5);
        this.JSPGraficas6.setName("6");
        this.JTPGraficasCyD.addTab("6.IMC/Edad 0-2", this.JSPGraficas6);
        this.JSPGraficas7.setName("7");
        this.JTPGraficasCyD.addTab("7.IMC/Edad 2-5", this.JSPGraficas7);
        this.JSPGraficas8.setName("8");
        this.JTPGraficasCyD.addTab("8.Peso/Edad 0-2", this.JSPGraficas8);
        this.JSPGraficas9.setName("9");
        this.JTPGraficasCyD.addTab("9.Peso/Edad 2-5", this.JSPGraficas9);
        this.JSPGraficas10.setName("10");
        this.JTPGraficasCyD.addTab("10.IMC/Edad 5-17", this.JSPGraficas10);
        this.JSPGraficas11.setName("11");
        this.JTPGraficasCyD.addTab("11.Talla/Edad 5-17", this.JSPGraficas11);
        GroupLayout JPGraficaLayout = new GroupLayout(this.JPGrafica);
        this.JPGrafica.setLayout(JPGraficaLayout);
        JPGraficaLayout.setHorizontalGroup(JPGraficaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTPGraficasCyD));
        JPGraficaLayout.setVerticalGroup(JPGraficaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPGraficaLayout.createSequentialGroup().addComponent(this.JTPGraficasCyD, -2, 637, -2).addGap(0, 90, 32767)));
        this.JTPCDDatos.addTab("GRÁFICAS", this.JPGrafica);
        this.JTAObservacion.setColumns(1);
        this.JTAObservacion.setFont(new Font("Arial", 0, 12));
        this.JTAObservacion.setLineWrap(true);
        this.JTAObservacion.setRows(1);
        this.JTAObservacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.jScrollPane1.setViewportView(this.JTAObservacion);
        this.JBTGuardarObs.setFont(new Font("Arial", 1, 14));
        this.JBTGuardarObs.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTGuardarObs.setText("Guardar");
        this.JBTGuardarObs.addActionListener(new ActionListener() { // from class: Historia.JPGraficasPyP.24
            public void actionPerformed(ActionEvent evt) {
                JPGraficasPyP.this.JBTGuardarObsActionPerformed(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jScrollPane1, -2, 801, -2).addGap(0, 0, 32767)).addComponent(this.JBTGuardarObs, -1, 844, 32767)).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane1, -2, 196, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBTGuardarObs).addContainerGap(473, 32767)));
        this.JTPCDDatos.addTab("OBSERVACIÓN", this.jPanel1);
        this.jPanel3.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 12), new Color(0, 102, 0)));
        this.JDC_FechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDC_FechaI.setDateFormatString("dd/MM/yyyy");
        this.JDC_FechaI.setFont(new Font("Arial", 1, 12));
        this.JCBEdadMeses.setFont(new Font("Arial", 1, 12));
        this.JCBEdadMeses.setModel(new DefaultComboBoxModel(new String[]{"No Aplica", "1", "2", "3", "4", "5", "6", "7", "8", "9"}));
        this.JCBEdadMeses.setBorder(BorderFactory.createTitledBorder((Border) null, "Edad Meses", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBLacMaterna.setFont(new Font("Arial", 1, 12));
        this.JCBLacMaterna.setModel(new DefaultComboBoxModel(new String[]{"No Aplica", "1 Mes", "2 Meses", "3 Meses", "4 Meses", "5 Meses", "6 Meses", "Sin Lactancia Materna", "No se realiza por una Tradición", "No se realiza por una Condición de Salud", "No se realiza por Negación del usuario", "No se realiza por tener datos de contacto del usuario no actualizados", "No se realiza por otras razones"}));
        this.JCBLacMaterna.setBorder(BorderFactory.createTitledBorder((Border) null, "Lactancia Materna Exclusiva", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBCCentinela.setFont(new Font("Arial", 1, 12));
        this.JCBCCentinela.setModel(new DefaultComboBoxModel(new String[]{"No Aplica", "Otitis Media Supurativa", "Hospitalizacion por Neumonia 3-5 años", "Hospitalizacion por EDA 3-5 años", "Bajo Peso Al Nacer", "Mortalidad en Menores de 1 Año", "Mortalidad en menores de 1a 5 Años"}));
        this.JCBCCentinela.setBorder(BorderFactory.createTitledBorder((Border) null, "Casos Centinela", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBEventoSPublica.setFont(new Font("Arial", 1, 12));
        this.JCBEventoSPublica.setModel(new DefaultComboBoxModel(new String[]{"No Aplica", "Maltrato Infantil", "Sarampion ", "Rubeola", "Varicela", "Tetano neonatal", "Paralisis flacida aguda (A-80)", "Tosferina", "Hepatitis B", "Tuberculosis", "Influenza", "Sifilis Congenita", "Lepra", "Malaria", "Leishmaniasis", "Meningitis Meningococcica", "Fiebre Amarilla", "Morbilidad y mortalidad por ESAVI", "Síndrome de rubéola congénita ", "Morbilidad por Diarrea", "Morbilidad por Otitis Media Supurativa", "Morbilidad por Neumonia", "Mortalidad por malaria", "Mortalidad por dengue", "Mortalidad Infantil menor 1 año", "Mortalidad Infantil menor 5 años", "VIH", "Otra"}));
        this.JCBEventoSPublica.setBorder(BorderFactory.createTitledBorder((Border) null, "Evento de Vigilancia en Salud Publica", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDC_FechaEvento.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Evento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDC_FechaEvento.setDateFormatString("yyyy-MM-dd");
        this.JDC_FechaEvento.setFont(new Font("Arial", 1, 12));
        this.JDC_FechaEvento.addPropertyChangeListener(new PropertyChangeListener() { // from class: Historia.JPGraficasPyP.25
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JPGraficasPyP.this.JDC_FechaEventoPropertyChange(evt);
            }
        });
        GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
        this.jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addComponent(this.JCBEventoSPublica, -2, 238, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JDC_FechaEvento, -2, 113, -2)).addGroup(jPanel3Layout.createSequentialGroup().addComponent(this.JDC_FechaI, -2, 113, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBEdadMeses, -2, 105, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBLacMaterna, -2, 188, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBCCentinela, -2, 184, -2)))));
        jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBEdadMeses, -2, 50, -2).addComponent(this.JCBLacMaterna, -2, 50, -2).addComponent(this.JCBCCentinela, -2, 50, -2)).addComponent(this.JDC_FechaI, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBEventoSPublica, -2, 50, -2).addComponent(this.JDC_FechaEvento, -2, 50, -2)).addContainerGap()));
        this.jPanel4.setBorder(BorderFactory.createTitledBorder((Border) null, "ESTADO NUTRICIONAL", 2, 0, new Font("Arial", 1, 12), new Color(0, 102, 0)));
        this.JCBPesoEdad.setFont(new Font("Arial", 1, 12));
        this.JCBPesoEdad.setModel(new DefaultComboBoxModel(new String[]{"No Aplica", "Peso muy bajo para la edad o DNT Global Severa ", "Peso bajo para la Edad o DNT Global ", "Riesgo Peso bajo para la Edad ", "Peso adecuado para la Edad"}));
        this.JCBPesoEdad.setBorder(BorderFactory.createTitledBorder((Border) null, "Nacimiento hasta los 2 años PESO/EDAD", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTallaEdad.setFont(new Font("Arial", 1, 12));
        this.JCBTallaEdad.setModel(new DefaultComboBoxModel(new String[]{"No Aplica", "Talla baja para la Edad o retraso en talla ", "Riesgo de Talla Baja ", "Talla Adecuada para la Edad"}));
        this.JCBTallaEdad.setBorder(BorderFactory.createTitledBorder((Border) null, "Nacimiento hasta los 5 años TALLA/EDAD", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBPesoTalla.setFont(new Font("Arial", 1, 12));
        this.JCBPesoTalla.setModel(new DefaultComboBoxModel(new String[]{"No Aplica", "Peso muy bajo para la Talla o DNT Aguda severa ", "Peso bajo para la Talla o DNT Aguda", "Riesgo Peso Bajo para la Talla", "Peso Adecuado para la Talla", "Sobrepeso", "Obesidad"}));
        this.JCBPesoTalla.setBorder(BorderFactory.createTitledBorder((Border) null, "Nacimiento hasta los 5 años PESO/TALLA", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBIMCEdad.setFont(new Font("Arial", 1, 12));
        this.JCBIMCEdad.setModel(new DefaultComboBoxModel(new String[]{"No Aplica", "Sobrepeso", "Obesidad ", "Adecuado", "Riesgo desnutricion", "Desnutricion", "Desnutricion severa"}));
        this.JCBIMCEdad.setBorder(BorderFactory.createTitledBorder((Border) null, "Nacimiento hasta los 5 años IMC/EDAD", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBPCefalico.setFont(new Font("Arial", 1, 12));
        this.JCBPCefalico.setModel(new DefaultComboBoxModel(new String[]{"No Aplica", "Sospecha de Retraso del Desarrollo", "Perímetro Cefálico Adecuado"}));
        this.JCBPCefalico.setBorder(BorderFactory.createTitledBorder((Border) null, "Perimetro Cefalico", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
        this.jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JCBIMCEdad, 0, -1, 32767).addComponent(this.JCBPesoEdad, -2, 252, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JCBTallaEdad, -2, 252, -2).addComponent(this.JCBPCefalico, 0, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBPesoTalla, -2, 261, -2).addContainerGap(-1, 32767)));
        jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addContainerGap().addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBPesoEdad, -2, 50, -2).addComponent(this.JCBTallaEdad, -2, 50, -2).addComponent(this.JCBPesoTalla, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBIMCEdad, -2, 50, -2).addComponent(this.JCBPCefalico, -2, 50, -2)).addContainerGap(8, 32767)));
        this.jPanel5.setBorder(BorderFactory.createTitledBorder((Border) null, "EVALUACIÓN DEL DESARROLLO", 2, 0, new Font("Arial", 1, 12), new Color(0, 102, 0)));
        this.JCBMFina.setFont(new Font("Arial", 1, 12));
        this.JCBMFina.setModel(new DefaultComboBoxModel(new String[]{"No Aplica", "Alto", "Medio Alto", "Medio", "Alerta"}));
        this.JCBMFina.setBorder(BorderFactory.createTitledBorder((Border) null, "Motricidad Fina", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBMGruesa.setFont(new Font("Arial", 1, 12));
        this.JCBMGruesa.setModel(new DefaultComboBoxModel(new String[]{"No Aplica", "Alto", "Medio Alto", "Medio", "Alerta"}));
        this.JCBMGruesa.setBorder(BorderFactory.createTitledBorder((Border) null, "Motricidad Gruesa", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBPSocial.setFont(new Font("Arial", 1, 12));
        this.JCBPSocial.setModel(new DefaultComboBoxModel(new String[]{"No Aplica", "Alto", "Medio Alto", "Medio", "Alerta"}));
        this.JCBPSocial.setBorder(BorderFactory.createTitledBorder((Border) null, "Personal Social", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBALenguaje.setFont(new Font("Arial", 1, 12));
        this.JCBALenguaje.setModel(new DefaultComboBoxModel(new String[]{"No Aplica", "Alto", "Medio Alto", "Medio", "Alerta"}));
        this.JCBALenguaje.setBorder(BorderFactory.createTitledBorder((Border) null, " Audicion y Lenguaje", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
        this.jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addComponent(this.JCBMFina, -2, 143, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBMGruesa, -2, 136, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBPSocial, -2, 134, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBALenguaje, -2, 147, -2).addContainerGap(-1, 32767)));
        jPanel5Layout.setVerticalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBMFina, -2, 50, -2).addComponent(this.JCBMGruesa, -2, 50, -2).addComponent(this.JCBPSocial, -2, 50, -2).addComponent(this.JCBALenguaje, -2, 50, -2)).addGap(3, 3, 3)));
        this.jPanel6.setBorder(BorderFactory.createTitledBorder((Border) null, "MEDIDAS PREVENTIVAS", 2, 0, new Font("Arial", 1, 12), new Color(0, 102, 0)));
        this.JDC_FechaVitA.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Vitamina A", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDC_FechaVitA.setDateFormatString("yyyy-MM-dd");
        this.JDC_FechaVitA.setEnabled(false);
        this.JDC_FechaVitA.setFont(new Font("Arial", 1, 12));
        this.JDC_FechaVitA.addPropertyChangeListener(new PropertyChangeListener() { // from class: Historia.JPGraficasPyP.26
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JPGraficasPyP.this.JDC_FechaVitAPropertyChange(evt);
            }
        });
        this.JDC_FechaHierro.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Hierro", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDC_FechaHierro.setDateFormatString("yyyy-MM-dd");
        this.JDC_FechaHierro.setEnabled(false);
        this.JDC_FechaHierro.setFont(new Font("Arial", 1, 12));
        this.JDC_FechaHierro.addPropertyChangeListener(new PropertyChangeListener() { // from class: Historia.JPGraficasPyP.27
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JPGraficasPyP.this.JDC_FechaHierroPropertyChange(evt);
            }
        });
        this.JDC_FechaAntParasitario.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Antiparasitario", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDC_FechaAntParasitario.setDateFormatString("yyyy-MM-dd");
        this.JDC_FechaAntParasitario.setEnabled(false);
        this.JDC_FechaAntParasitario.setFont(new Font("Arial", 1, 12));
        this.JDC_FechaAntParasitario.addPropertyChangeListener(new PropertyChangeListener() { // from class: Historia.JPGraficasPyP.28
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JPGraficasPyP.this.JDC_FechaAntParasitarioPropertyChange(evt);
            }
        });
        this.JDC_FechaAtnOdont.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Atencion Odontologica", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDC_FechaAtnOdont.setDateFormatString("yyyy-MM-dd");
        this.JDC_FechaAtnOdont.setEnabled(false);
        this.JDC_FechaAtnOdont.setFont(new Font("Arial", 1, 12));
        this.JDC_FechaAtnOdont.addPropertyChangeListener(new PropertyChangeListener() { // from class: Historia.JPGraficasPyP.29
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JPGraficasPyP.this.JDC_FechaAtnOdontPropertyChange(evt);
            }
        });
        this.JCBEsqVacunacion.setFont(new Font("Arial", 1, 12));
        this.JCBEsqVacunacion.setModel(new DefaultComboBoxModel(new String[]{"No Aplica", "Completo", "Incompleto"}));
        this.JCBEsqVacunacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Esquema de Vacunacion para la edad", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDC_FechaPCita.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Próxima Cita", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDC_FechaPCita.setDateFormatString("yyyy-MM-dd");
        this.JDC_FechaPCita.setFont(new Font("Arial", 1, 12));
        this.JDC_FechaPCita.addPropertyChangeListener(new PropertyChangeListener() { // from class: Historia.JPGraficasPyP.30
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JPGraficasPyP.this.JDC_FechaPCitaPropertyChange(evt);
            }
        });
        this.jCheckBox1.setFont(new Font("Arial", 1, 12));
        this.jCheckBox1.setText("Aplica?");
        this.jCheckBox1.addActionListener(new ActionListener() { // from class: Historia.JPGraficasPyP.31
            public void actionPerformed(ActionEvent evt) {
                JPGraficasPyP.this.jCheckBox1ActionPerformed(evt);
            }
        });
        this.jCheckBox2.setFont(new Font("Arial", 1, 12));
        this.jCheckBox2.setText("Aplica?");
        this.jCheckBox2.addActionListener(new ActionListener() { // from class: Historia.JPGraficasPyP.32
            public void actionPerformed(ActionEvent evt) {
                JPGraficasPyP.this.jCheckBox2ActionPerformed(evt);
            }
        });
        this.jCheckBox3.setFont(new Font("Arial", 1, 12));
        this.jCheckBox3.setText("Aplica?");
        this.jCheckBox3.addActionListener(new ActionListener() { // from class: Historia.JPGraficasPyP.33
            public void actionPerformed(ActionEvent evt) {
                JPGraficasPyP.this.jCheckBox3ActionPerformed(evt);
            }
        });
        this.jCheckBox4.setFont(new Font("Arial", 1, 12));
        this.jCheckBox4.setText("Aplica?");
        this.jCheckBox4.addActionListener(new ActionListener() { // from class: Historia.JPGraficasPyP.34
            public void actionPerformed(ActionEvent evt) {
                JPGraficasPyP.this.jCheckBox4ActionPerformed(evt);
            }
        });
        this.JDC_FechaSulfatoDeZinc.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Sulfato de zinc", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDC_FechaSulfatoDeZinc.setDateFormatString("yyyy-MM-dd");
        this.JDC_FechaSulfatoDeZinc.setEnabled(false);
        this.JDC_FechaSulfatoDeZinc.setFont(new Font("Arial", 1, 12));
        this.JDC_FechaSulfatoDeZinc.addPropertyChangeListener(new PropertyChangeListener() { // from class: Historia.JPGraficasPyP.35
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JPGraficasPyP.this.JDC_FechaSulfatoDeZincPropertyChange(evt);
            }
        });
        this.JCHAplicaSulfatoDeZinc.setFont(new Font("Arial", 1, 12));
        this.JCHAplicaSulfatoDeZinc.setText("Aplica?");
        this.JCHAplicaSulfatoDeZinc.addActionListener(new ActionListener() { // from class: Historia.JPGraficasPyP.36
            public void actionPerformed(ActionEvent evt) {
                JPGraficasPyP.this.JCHAplicaSulfatoDeZincActionPerformed(evt);
            }
        });
        this.JDC_FechaVih.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Vih", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDC_FechaVih.setDateFormatString("yyyy-MM-dd");
        this.JDC_FechaVih.setEnabled(false);
        this.JDC_FechaVih.setFont(new Font("Arial", 1, 12));
        this.JDC_FechaVih.addPropertyChangeListener(new PropertyChangeListener() { // from class: Historia.JPGraficasPyP.37
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JPGraficasPyP.this.JDC_FechaVihPropertyChange(evt);
            }
        });
        this.JCHAplicaVih.setFont(new Font("Arial", 1, 12));
        this.JCHAplicaVih.setText("Aplica?");
        this.JCHAplicaVih.addActionListener(new ActionListener() { // from class: Historia.JPGraficasPyP.38
            public void actionPerformed(ActionEvent evt) {
                JPGraficasPyP.this.JCHAplicaVihActionPerformed(evt);
            }
        });
        this.JDC_FechaHemoglobina.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha hemoglobina", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDC_FechaHemoglobina.setDateFormatString("yyyy-MM-dd");
        this.JDC_FechaHemoglobina.setEnabled(false);
        this.JDC_FechaHemoglobina.setFont(new Font("Arial", 1, 12));
        this.JDC_FechaHemoglobina.addPropertyChangeListener(new PropertyChangeListener() { // from class: Historia.JPGraficasPyP.39
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JPGraficasPyP.this.JDC_FechaHemoglobinaPropertyChange(evt);
            }
        });
        this.JCHAplicaHemoglobina.setFont(new Font("Arial", 1, 12));
        this.JCHAplicaHemoglobina.setText("Aplica?");
        this.JCHAplicaHemoglobina.addActionListener(new ActionListener() { // from class: Historia.JPGraficasPyP.40
            public void actionPerformed(ActionEvent evt) {
                JPGraficasPyP.this.JCHAplicaHemoglobinaActionPerformed(evt);
            }
        });
        GroupLayout jPanel6Layout = new GroupLayout(this.jPanel6);
        this.jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel6Layout.createSequentialGroup().addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel6Layout.createSequentialGroup().addContainerGap().addComponent(this.jCheckBox1).addGap(82, 82, 82).addComponent(this.jCheckBox2).addGap(82, 82, 82).addComponent(this.jCheckBox3).addGap(101, 101, 101).addComponent(this.jCheckBox4)).addGroup(jPanel6Layout.createSequentialGroup().addComponent(this.JDC_FechaVitA, -2, 130, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JDC_FechaHierro, -2, 130, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JDC_FechaAntParasitario, -2, 144, -2).addGap(18, 18, 18).addComponent(this.JDC_FechaAtnOdont, -2, 192, -2))).addGap(0, 0, 32767)).addGroup(jPanel6Layout.createSequentialGroup().addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel6Layout.createSequentialGroup().addComponent(this.JCBEsqVacunacion, -2, 233, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JDC_FechaPCita, -2, 130, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JDC_FechaSulfatoDeZinc, -2, 144, -2)).addGroup(jPanel6Layout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.JCHAplicaSulfatoDeZinc).addGap(48, 48, 48))).addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JDC_FechaVih, -2, 113, -2).addGroup(jPanel6Layout.createSequentialGroup().addGap(13, 13, 13).addComponent(this.JCHAplicaVih))).addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel6Layout.createSequentialGroup().addGap(25, 25, 25).addComponent(this.JCHAplicaHemoglobina)).addGroup(jPanel6Layout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JDC_FechaHemoglobina, -2, 169, -2))).addGap(144, 144, 144)));
        jPanel6Layout.setVerticalGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup().addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jCheckBox1).addComponent(this.jCheckBox2).addComponent(this.jCheckBox3).addComponent(this.jCheckBox4)).addGap(8, 8, 8).addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDC_FechaVitA, -2, 50, -2).addComponent(this.JDC_FechaHierro, -2, 50, -2).addComponent(this.JDC_FechaAntParasitario, -2, 50, -2).addComponent(this.JDC_FechaAtnOdont, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBEsqVacunacion, GroupLayout.Alignment.TRAILING, -2, 50, -2).addGroup(GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup().addComponent(this.JCHAplicaSulfatoDeZinc).addGap(3, 3, 3).addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDC_FechaSulfatoDeZinc, -2, 50, -2).addComponent(this.JDC_FechaPCita, -2, 50, -2))).addGroup(GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup().addComponent(this.JCHAplicaVih).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JDC_FechaVih, -2, 50, -2)).addGroup(GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup().addComponent(this.JCHAplicaHemoglobina).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JDC_FechaHemoglobina, -2, 50, -2)))));
        this.JSPHistoricoSeg.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 12), new Color(0, 102, 0)));
        this.JTHistorico.setFont(new Font("Arial", 1, 12));
        this.JTHistorico.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTHistorico.addMouseListener(new MouseAdapter() { // from class: Historia.JPGraficasPyP.41
            public void mouseClicked(MouseEvent evt) {
                JPGraficasPyP.this.JTHistoricoMouseClicked(evt);
            }
        });
        this.JSPHistoricoSeg.setViewportView(this.JTHistorico);
        this.JBGuardar.setFont(new Font("Arial", 1, 12));
        this.JBGuardar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBGuardar.setText("Guardar");
        this.JBGuardar.addActionListener(new ActionListener() { // from class: Historia.JPGraficasPyP.42
            public void actionPerformed(ActionEvent evt) {
                JPGraficasPyP.this.JBGuardarActionPerformed(evt);
            }
        });
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.jPanel3, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBGuardar, -1, -1, 32767).addGap(1, 1, 1)).addComponent(this.jPanel4, -1, -1, 32767).addComponent(this.jPanel5, -1, -1, 32767).addComponent(this.jPanel6, GroupLayout.Alignment.TRAILING, -2, 825, -2).addComponent(this.JSPHistoricoSeg)).addContainerGap()));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGap(3, 3, 3).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JBGuardar, -2, 144, -2).addComponent(this.jPanel3, -2, 136, -2)).addGap(1, 1, 1).addComponent(this.jPanel4, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel5, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel6, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPHistoricoSeg, -2, 88, -2).addContainerGap(79, 32767)));
        this.JTPCDDatos.addTab("SEGUIMIENTO", this.jPanel2);
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTPCDDatos, -2, 854, -2).addContainerGap(-1, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTPCDDatos)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTPCDDatosStateChanged(ChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFSFcActionPerformed(ActionEvent evt) {
        this.JTFFSFr.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFSFcFocusGained(FocusEvent evt) {
        this.JTFFSFc.selectAll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFSFcFocusLost(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFSFrFocusGained(FocusEvent evt) {
        this.JTFFSFr.selectAll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFTemperaturaActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFTemperaturaFocusGained(FocusEvent evt) {
        this.JTFFTemperatura.selectAll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFSTallaActionPerformed(ActionEvent evt) {
        this.JTFFSPeso.requestFocus();
        mCalcularImc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFSTallaFocusGained(FocusEvent evt) {
        this.JTFFSTalla.selectAll();
        mCalcularImc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFSTallaFocusLost(FocusEvent evt) {
        mCalcularImc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFSPesoActionPerformed(ActionEvent evt) {
        mCalcularImc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFSPesoFocusGained(FocusEvent evt) {
        this.JTFFSPeso.selectAll();
        mCalcularImc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFSPesoFocusLost(FocusEvent evt) {
        mCalcularImc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGuardarActionPerformed(ActionEvent evt) {
        mGrabarBd();
    }

    private void mGrabarBd() {
        System.out.println("el usuarioPrograma" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioPrograma());
        if (clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioPrograma().longValue() != 0) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                mCrear_ExamenFisico();
                this.xmt.cambiarEstadoValidadoItemHC(getName(), 1, true);
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "El paciente no se encuentra Matriculado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    private void mVerificaExistencia() {
        String sql = "SELECT `Id`,`Id_Atencion` FROM `h_examenfisico` WHERE (Id_Atencion= '" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "' AND `Id_Usuario_Programa`= '" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioPrograma() + "')";
        ResultSet xrs = this.xct.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.first();
                this.xmt.cambiarEstadoValidadoItemHC(getName(), 1, true);
                this.JBTGuardar.setEnabled(false);
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPGraficasPyP.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mIniciarPanel() {
        JPGraficasPyP_Res2465 xJPGraficasPyP_Res2465_P1 = new JPGraficasPyP_Res2465();
        JPGraficasPyP_Res2465 xJPGraficasPyP_Res2465_P2 = new JPGraficasPyP_Res2465();
        JPGraficasPyP_Res2465 xJPGraficasPyP_Res2465_P3 = new JPGraficasPyP_Res2465();
        JPGraficasPyP_Res2465 xJPGraficasPyP_Res2465_P4 = new JPGraficasPyP_Res2465();
        JPGraficasPyP_Res2465 xJPGraficasPyP_Res2465_P5 = new JPGraficasPyP_Res2465();
        JPGraficasPyP_Res2465 xJPGraficasPyP_Res2465_P6 = new JPGraficasPyP_Res2465();
        JPGraficasPyP_Res2465 xJPGraficasPyP_Res2465_P7 = new JPGraficasPyP_Res2465();
        JPGraficasPyP_Res2465 xJPGraficasPyP_Res2465_P8 = new JPGraficasPyP_Res2465();
        JPGraficasPyP_Res2465 xJPGraficasPyP_Res2465_P9 = new JPGraficasPyP_Res2465();
        JPGraficasPyP_Res2465 xJPGraficasPyP_Res2465_P10 = new JPGraficasPyP_Res2465();
        JPGraficasPyP_Res2465 xJPGraficasPyP_Res2465_P11 = new JPGraficasPyP_Res2465();
        this.JSPGraficas1.setViewportView(xJPGraficasPyP_Res2465_P1);
        this.Grafica = null;
        if (this.xSexo.equals("M")) {
            this.Grafica = new Imagen(this, "Peso para la Talla Niños 0 a 2 años", "1. M_Peso_para_la_Talla_Niños_0_a_2_años", 5, 6, 29, xJPGraficasPyP_Res2465_P1.JPGraficaImage1, 0L, 24L, "M");
            xJPGraficasPyP_Res2465_P1.JLTitulo.setText("Peso para la Talla Niños 0 a 2 años");
            this.JSPGraficas1.setName("29");
        } else {
            xJPGraficasPyP_Res2465_P1.JLTitulo.setText("Peso para la Talla Niñas 0 a 2 años");
            this.Grafica = new Imagen(this, "Peso para la Talla Niñas 0 a 2 años", "1. F_Peso_para_la_Talla_Niñas_0_a_2_años", 5, 6, 40, xJPGraficasPyP_Res2465_P1.JPGraficaImage1, 0L, 24L, "F");
            this.JSPGraficas1.setName("40");
        }
        xJPGraficasPyP_Res2465_P1.JPGraficaImage1.add(this.Grafica);
        xJPGraficasPyP_Res2465_P1.JPGraficaImage1.repaint();
        this.JSPGraficas2.setViewportView(xJPGraficasPyP_Res2465_P2);
        this.Grafica = null;
        if (this.xSexo.equals("M")) {
            xJPGraficasPyP_Res2465_P2.JLTitulo.setText("Peso para la Talla Niños 2 a 5 años");
            this.Grafica = new Imagen(this, "Peso para la Talla Niños 2 a 5 años", "2. M_Peso_para_la_Talla_Niños_2_a_5_años", 5, 6, 30, xJPGraficasPyP_Res2465_P2.JPGraficaImage1, 0L, 24L, "M");
            this.JSPGraficas2.setName("30");
        } else {
            xJPGraficasPyP_Res2465_P2.JLTitulo.setText("Peso para la Talla Niñas 2 a 5 años");
            this.Grafica = new Imagen(this, "Peso para la Talla Niñas 2 a 5 años", "2. F_Peso_para_la_Talla_Niñas_2_a_5_años", 5, 6, 41, xJPGraficasPyP_Res2465_P2.JPGraficaImage1, 0L, 24L, "F");
            this.JSPGraficas2.setName("41");
        }
        xJPGraficasPyP_Res2465_P2.JPGraficaImage1.add(this.Grafica);
        xJPGraficasPyP_Res2465_P2.JPGraficaImage1.repaint();
        this.JSPGraficas3.setViewportView(xJPGraficasPyP_Res2465_P3);
        this.Grafica = null;
        if (this.xSexo.equals("M")) {
            xJPGraficasPyP_Res2465_P3.JLTitulo.setText("Talla para la Edad Niños 0 a 2 años");
            this.Grafica = new Imagen(this, "Talla para la Edad Niños 0 a 2 años", "3. M_Talla_para_la_Edad_Niños_0_a_2_años", 4, 5, 31, xJPGraficasPyP_Res2465_P3.JPGraficaImage1, 0L, 24L, "M");
            this.JSPGraficas3.setName("31");
        } else {
            xJPGraficasPyP_Res2465_P3.JLTitulo.setText("Talla para la Edad Niñas 0 a 2 años");
            this.Grafica = new Imagen(this, "Talla para la Edad Niñas 0 a 2 años", "3. F_Talla_para_la_Edad_Niñas_0_a_2_años", 4, 5, 42, xJPGraficasPyP_Res2465_P3.JPGraficaImage1, 0L, 24L, "F");
            this.JSPGraficas3.setName("42");
        }
        xJPGraficasPyP_Res2465_P3.JPGraficaImage1.add(this.Grafica);
        xJPGraficasPyP_Res2465_P3.JPGraficaImage1.repaint();
        this.JSPGraficas4.setViewportView(xJPGraficasPyP_Res2465_P4);
        this.Grafica = null;
        if (this.xSexo.equals("M")) {
            xJPGraficasPyP_Res2465_P4.JLTitulo.setText("Talla para la Edad Niños 2 a 5 años");
            this.Grafica = new Imagen(this, "Talla para la Edad Niños 2 a 5 años", "4. M_Talla_para_la_Edad_Niños_2_a_5_años", 4, 5, 32, xJPGraficasPyP_Res2465_P4.JPGraficaImage1, 0L, 24L, "M");
            this.JSPGraficas4.setName("32");
        } else {
            xJPGraficasPyP_Res2465_P4.JLTitulo.setText("Talla para la Edad Niñas 2 a 5 años");
            this.Grafica = new Imagen(this, "Talla para la Edad Niñas 2 a 5 años", "4. F_Talla_para_la_Edad_Niñas_2_a_5_años", 4, 5, 43, xJPGraficasPyP_Res2465_P4.JPGraficaImage1, 0L, 24L, "F");
            this.JSPGraficas4.setName("43");
        }
        xJPGraficasPyP_Res2465_P4.JPGraficaImage1.add(this.Grafica);
        xJPGraficasPyP_Res2465_P4.JPGraficaImage1.repaint();
        this.JSPGraficas5.setViewportView(xJPGraficasPyP_Res2465_P5);
        this.Grafica = null;
        if (this.xSexo.equals("M")) {
            xJPGraficasPyP_Res2465_P5.JLTitulo.setText("Perímetro Cefálico Niños 0 a 5 años");
            this.Grafica = new Imagen(this, "Perímetro Cefálico Niños 0 a 5 años", "5. M_Perímetro_Cefálico_Niños_0_a_5_años", 4, 8, 33, xJPGraficasPyP_Res2465_P5.JPGraficaImage1, 0L, 60L, "M");
            this.JSPGraficas5.setName("33");
        } else {
            xJPGraficasPyP_Res2465_P5.JLTitulo.setText("Perímetro Cefálico Niñas 0 a 5 años");
            this.Grafica = new Imagen(this, "Perímetro Cefálico Niñas 0 a 5 años", "5. F_Perímetro_Cefálico_Niñas_0_a_5_años", 4, 8, 44, xJPGraficasPyP_Res2465_P5.JPGraficaImage1, 0L, 60L, "F");
            this.JSPGraficas5.setName("44");
        }
        xJPGraficasPyP_Res2465_P5.JPGraficaImage1.add(this.Grafica);
        xJPGraficasPyP_Res2465_P5.JPGraficaImage1.repaint();
        this.JSPGraficas6.setViewportView(xJPGraficasPyP_Res2465_P6);
        this.Grafica = null;
        if (this.xSexo.equals("M")) {
            xJPGraficasPyP_Res2465_P6.JLTitulo.setText("IMC para la Edad Niños 0 a 2 años");
            this.Grafica = new Imagen(this, "IMC para la Edad Niños 0 a 2 años", "6. M_IMC_para_la_Edad_Niños_0_a_2_años", 4, 7, 34, xJPGraficasPyP_Res2465_P6.JPGraficaImage1, 24L, 60L, "M");
            this.JSPGraficas6.setName("34");
        } else {
            xJPGraficasPyP_Res2465_P6.JLTitulo.setText("IMC para la Edad Niñas 0 a 2 años");
            this.Grafica = new Imagen(this, "IMC para la Edad Niñas 0 a 2 años", "6. F_IMC_para_la_Edad_Niñas_0_a_2_años", 4, 7, 45, xJPGraficasPyP_Res2465_P6.JPGraficaImage1, 24L, 60L, "F");
            this.JSPGraficas6.setName("45");
        }
        xJPGraficasPyP_Res2465_P6.JPGraficaImage1.add(this.Grafica);
        xJPGraficasPyP_Res2465_P6.JPGraficaImage1.repaint();
        this.JSPGraficas7.setViewportView(xJPGraficasPyP_Res2465_P7);
        this.Grafica = null;
        if (this.xSexo.equals("M")) {
            xJPGraficasPyP_Res2465_P7.JLTitulo.setText("IMC para la Edad Niños 2 a 5 años");
            this.Grafica = new Imagen(this, "IMC para la Edad Niños 2 a 5 años", "7. M_IMC_para_la_Edad_Niños_2_a_5_años", 4, 7, 35, xJPGraficasPyP_Res2465_P7.JPGraficaImage1, 24L, 60L, "M");
            this.JSPGraficas7.setName("35");
        } else {
            xJPGraficasPyP_Res2465_P7.JLTitulo.setText("IMC para la Edad Niñas 2 a 5 años");
            this.Grafica = new Imagen(this, "IMC para la Edad Niñas 2 a 5 años", "7. F_IMC_para_la_Edad_Niñas_2_a_5_años", 4, 7, 46, xJPGraficasPyP_Res2465_P7.JPGraficaImage1, 24L, 60L, "F");
            this.JSPGraficas7.setName("46");
        }
        xJPGraficasPyP_Res2465_P7.JPGraficaImage1.add(this.Grafica);
        xJPGraficasPyP_Res2465_P7.JPGraficaImage1.repaint();
        this.JSPGraficas8.setViewportView(xJPGraficasPyP_Res2465_P8);
        this.Grafica = null;
        if (this.xSexo.equals("M")) {
            xJPGraficasPyP_Res2465_P8.JLTitulo.setText("Peso para la Edad Niños 0 a 2 años");
            this.Grafica = new Imagen(this, "Peso para la Edad Niños 0 a 2 años", "8. M_Peso_para_la_Edad_Niños_0_a_2_años", 4, 6, 36, xJPGraficasPyP_Res2465_P8.JPGraficaImage1, 24L, 60L, "M");
            this.JSPGraficas8.setName("36");
        } else {
            xJPGraficasPyP_Res2465_P8.JLTitulo.setText("Peso para la Edad Niñas 0 a 2 años");
            this.Grafica = new Imagen(this, "Peso para la Edad Niñas 0 a 2 años", "8. F_Peso_para_la_Edad_Niñas_0_a_2_años", 4, 6, 47, xJPGraficasPyP_Res2465_P8.JPGraficaImage1, 24L, 60L, "F");
            this.JSPGraficas8.setName("47");
        }
        xJPGraficasPyP_Res2465_P8.JPGraficaImage1.add(this.Grafica);
        xJPGraficasPyP_Res2465_P8.JPGraficaImage1.repaint();
        this.JSPGraficas9.setViewportView(xJPGraficasPyP_Res2465_P9);
        this.Grafica = null;
        if (this.xSexo.equals("M")) {
            xJPGraficasPyP_Res2465_P9.JLTitulo.setText("Peso para la Edad Niños 2 a 5 años");
            this.Grafica = new Imagen(this, "Peso para la Edad Niños 2 a 5 años", "9. M_Peso_para_la_Edad_Niños_2_a_5_años", 4, 6, 37, xJPGraficasPyP_Res2465_P9.JPGraficaImage1, 24L, 60L, "M");
            this.JSPGraficas9.setName("37");
        } else {
            xJPGraficasPyP_Res2465_P9.JLTitulo.setText("Peso para la Edad Niñas 2 a 5 años");
            this.Grafica = new Imagen(this, "Peso para la Edad Niñas 2 a 5 años", "9. F_Peso_para_la_Edad_Niñas_2_a_5_años", 4, 6, 48, xJPGraficasPyP_Res2465_P9.JPGraficaImage1, 24L, 60L, "F");
            this.JSPGraficas9.setName("48");
        }
        xJPGraficasPyP_Res2465_P9.JPGraficaImage1.add(this.Grafica);
        xJPGraficasPyP_Res2465_P9.JPGraficaImage1.repaint();
        this.JSPGraficas10.setViewportView(xJPGraficasPyP_Res2465_P10);
        this.Grafica = null;
        if (this.xSexo.equals("M")) {
            xJPGraficasPyP_Res2465_P10.JLTitulo.setText("IMC para la Edad Niños 5 a 17 años");
            this.Grafica = new Imagen(this, "IMC para la Edad Niños 5 a 17 años", "10. M_IMC_para_la_Edad_Niños_5_a_17_años", 4, 7, 38, xJPGraficasPyP_Res2465_P10.JPGraficaImage1, 60L, 216L, "M");
            this.JSPGraficas10.setName("38");
        } else {
            xJPGraficasPyP_Res2465_P10.JLTitulo.setText("IMC para la Edad Niñas 5 a 17 años");
            this.Grafica = new Imagen(this, "IMC para la Edad Niñas 5 a 17 años", "10. F_IMC_para_la_Edad_Niñas_5_a_17_años", 4, 7, 49, xJPGraficasPyP_Res2465_P10.JPGraficaImage1, 60L, 216L, "F");
            this.JSPGraficas10.setName("49");
        }
        xJPGraficasPyP_Res2465_P10.JPGraficaImage1.add(this.Grafica);
        xJPGraficasPyP_Res2465_P10.JPGraficaImage1.repaint();
        this.JSPGraficas11.setViewportView(xJPGraficasPyP_Res2465_P11);
        this.Grafica = null;
        if (this.xSexo.equals("M")) {
            xJPGraficasPyP_Res2465_P11.JLTitulo.setText("Talla para la Edad Niños 5 a 17 años");
            this.Grafica = new Imagen(this, "Talla para la Edad Niños 5 a 17 años", "11. M_Talla_para_la_Edad_Niños_5_a_17_años", 4, 5, 39, xJPGraficasPyP_Res2465_P11.JPGraficaImage1, 60L, 216L, "M");
            this.JSPGraficas11.setName("39");
        } else {
            xJPGraficasPyP_Res2465_P11.JLTitulo.setText("Talla para la Edad Niñas 5 a 17 años");
            this.Grafica = new Imagen(this, "Talla para la Edad Niñas 5 a 17 años", "11. F_Talla_para_la_Edad_Niñas_5_a_17_años", 4, 5, 50, xJPGraficasPyP_Res2465_P11.JPGraficaImage1, 60L, 216L, "F");
            this.JSPGraficas11.setName("50");
        }
        xJPGraficasPyP_Res2465_P11.JPGraficaImage1.add(this.Grafica);
        xJPGraficasPyP_Res2465_P11.JPGraficaImage1.repaint();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFSPCefalicoActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFSPCefalicoFocusGained(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFSPCefalicoFocusLost(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGuardarObsActionPerformed(ActionEvent evt) {
        if (!this.JTAObservacion.getText().isEmpty()) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                String sql = "UPDATE h_examenfisico SET Observacion = '" + this.JTAObservacion.getText() + "' WHERE (Id_Atencion='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "' AND Id_Usuario_Programa='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioPrograma() + "')";
                this.xct.ejecutarSQL(sql);
                this.xct.cerrarConexionBd();
                mBuscaHistorico();
                this.JTAObservacion.setText("");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDC_FechaEventoPropertyChange(PropertyChangeEvent evt) {
        if (this.JDC_FechaEvento.getDate() != null) {
            this.xJDC_FechaEvento = this.xmt.formatoAMD.format(this.JDC_FechaEvento.getDate());
        } else {
            this.xJDC_FechaEvento = "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBGuardarActionPerformed(ActionEvent evt) {
        mGuardarSeg();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFPSentadoSActionPerformed(ActionEvent evt) {
        this.JTFFPSentadoS.transferFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFPSentadoSFocusLost(FocusEvent evt) {
        if (!this.JTFFPSentadoS.getText().isEmpty()) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFPSentadoDActionPerformed(ActionEvent evt) {
        this.JTFFPSentadoD.transferFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFPSentadoDFocusLost(FocusEvent evt) {
        if (!this.JTFFPSentadoD.getText().isEmpty()) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTHistoricoMouseClicked(MouseEvent evt) {
        if (this.JTHistorico.getSelectedRow() != -1) {
            this.JDC_FechaI.setDate(Date.valueOf(this.xmodeloSeg.getValueAt(this.JTHistorico.getSelectedRow(), 1).toString()));
            this.JCBEdadMeses.setSelectedItem(this.xmodeloSeg.getValueAt(this.JTHistorico.getSelectedRow(), 2).toString());
            this.JCBLacMaterna.setSelectedItem(this.xmodeloSeg.getValueAt(this.JTHistorico.getSelectedRow(), 3).toString());
            this.JCBCCentinela.setSelectedItem(this.xmodeloSeg.getValueAt(this.JTHistorico.getSelectedRow(), 4).toString());
            this.JCBEventoSPublica.setSelectedItem(this.xmodeloSeg.getValueAt(this.JTHistorico.getSelectedRow(), 5).toString());
            if (this.xmodeloSeg.getValueAt(this.JTHistorico.getSelectedRow(), 6).toString().isEmpty()) {
                this.JDC_FechaEvento.setDate((java.util.Date) null);
            } else {
                this.JDC_FechaEvento.setDate(Date.valueOf(this.xmodeloSeg.getValueAt(this.JTHistorico.getSelectedRow(), 6).toString()));
            }
            this.JCBPesoEdad.setSelectedItem(this.xmodeloSeg.getValueAt(this.JTHistorico.getSelectedRow(), 7).toString());
            this.JCBTallaEdad.setSelectedItem(this.xmodeloSeg.getValueAt(this.JTHistorico.getSelectedRow(), 8).toString());
            this.JCBPesoTalla.setSelectedItem(this.xmodeloSeg.getValueAt(this.JTHistorico.getSelectedRow(), 9).toString());
            this.JCBIMCEdad.setSelectedItem(this.xmodeloSeg.getValueAt(this.JTHistorico.getSelectedRow(), 10).toString());
            this.JCBPCefalico.setSelectedItem(this.xmodeloSeg.getValueAt(this.JTHistorico.getSelectedRow(), 11).toString());
            this.JCBMFina.setSelectedItem(this.xmodeloSeg.getValueAt(this.JTHistorico.getSelectedRow(), 12).toString());
            this.JCBMGruesa.setSelectedItem(this.xmodeloSeg.getValueAt(this.JTHistorico.getSelectedRow(), 13).toString());
            this.JCBPSocial.setSelectedItem(this.xmodeloSeg.getValueAt(this.JTHistorico.getSelectedRow(), 14).toString());
            this.JCBALenguaje.setSelectedItem(this.xmodeloSeg.getValueAt(this.JTHistorico.getSelectedRow(), 15).toString());
            if (this.xmodeloSeg.getValueAt(this.JTHistorico.getSelectedRow(), 16).toString().isEmpty()) {
                this.jCheckBox1.setSelected(false);
                jCheckBox1ActionPerformed(null);
            } else {
                this.jCheckBox1.setSelected(true);
                jCheckBox1ActionPerformed(null);
                this.JDC_FechaVitA.setDate(Date.valueOf(this.xmodeloSeg.getValueAt(this.JTHistorico.getSelectedRow(), 16).toString()));
            }
            if (this.xmodeloSeg.getValueAt(this.JTHistorico.getSelectedRow(), 17).toString().isEmpty()) {
                this.jCheckBox2.setSelected(false);
                jCheckBox2ActionPerformed(null);
            } else {
                this.jCheckBox2.setSelected(true);
                jCheckBox2ActionPerformed(null);
                this.JDC_FechaHierro.setDate(Date.valueOf(this.xmodeloSeg.getValueAt(this.JTHistorico.getSelectedRow(), 17).toString()));
            }
            if (this.xmodeloSeg.getValueAt(this.JTHistorico.getSelectedRow(), 18).toString().isEmpty()) {
                this.jCheckBox3.setSelected(false);
                jCheckBox3ActionPerformed(null);
            } else {
                this.jCheckBox3.setSelected(true);
                jCheckBox3ActionPerformed(null);
                this.JDC_FechaAntParasitario.setDate(Date.valueOf(this.xmodeloSeg.getValueAt(this.JTHistorico.getSelectedRow(), 18).toString()));
            }
            if (this.xmodeloSeg.getValueAt(this.JTHistorico.getSelectedRow(), 18).toString().isEmpty()) {
                this.jCheckBox3.setSelected(false);
                jCheckBox3ActionPerformed(null);
            } else {
                this.jCheckBox3.setSelected(true);
                jCheckBox3ActionPerformed(null);
                this.JDC_FechaAntParasitario.setDate(Date.valueOf(this.xmodeloSeg.getValueAt(this.JTHistorico.getSelectedRow(), 18).toString()));
            }
            if (this.xmodeloSeg.getValueAt(this.JTHistorico.getSelectedRow(), 22).toString().isEmpty()) {
                this.JCHAplicaSulfatoDeZinc.setSelected(false);
                JCHAplicaSulfatoDeZincActionPerformed(null);
            } else {
                this.JCHAplicaSulfatoDeZinc.setSelected(true);
                JCHAplicaSulfatoDeZincActionPerformed(null);
                this.JDC_FechaSulfatoDeZinc.setDate(Date.valueOf(this.xmodeloSeg.getValueAt(this.JTHistorico.getSelectedRow(), 22).toString()));
            }
            if (this.xmodeloSeg.getValueAt(this.JTHistorico.getSelectedRow(), 23).toString().isEmpty()) {
                this.JCHAplicaVih.setSelected(false);
                JCHAplicaVihActionPerformed(null);
            } else {
                this.JCHAplicaVih.setSelected(true);
                JCHAplicaVihActionPerformed(null);
                this.JDC_FechaVih.setDate(Date.valueOf(this.xmodeloSeg.getValueAt(this.JTHistorico.getSelectedRow(), 23).toString()));
            }
            if (this.xmodeloSeg.getValueAt(this.JTHistorico.getSelectedRow(), 24).toString().isEmpty()) {
                this.JCHAplicaHemoglobina.setSelected(false);
                JCHAplicaHemoglobinaActionPerformed(null);
            } else {
                this.JCHAplicaHemoglobina.setSelected(true);
                JCHAplicaHemoglobinaActionPerformed(null);
                this.JDC_FechaHemoglobina.setDate(Date.valueOf(this.xmodeloSeg.getValueAt(this.JTHistorico.getSelectedRow(), 24).toString()));
            }
            this.JCBEsqVacunacion.setSelectedItem(this.xmodeloSeg.getValueAt(this.JTHistorico.getSelectedRow(), 20).toString());
            if (this.xmodeloSeg.getValueAt(this.JTHistorico.getSelectedRow(), 21).toString().isEmpty()) {
                this.JDC_FechaPCita.setDate((java.util.Date) null);
            } else {
                this.JDC_FechaPCita.setDate(Date.valueOf(this.xmodeloSeg.getValueAt(this.JTHistorico.getSelectedRow(), 21).toString()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFSPBrazoActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFSPBrazoFocusGained(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFSPBrazoFocusLost(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFPS2ActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFPS2FocusGained(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHAplicaSulfatoDeZincActionPerformed(ActionEvent evt) {
        if (this.JCHAplicaSulfatoDeZinc.isSelected()) {
            this.JDC_FechaSulfatoDeZinc.setDate(this.xmt.getFechaActual());
            this.JDC_FechaSulfatoDeZinc.setEnabled(true);
        } else {
            this.JDC_FechaSulfatoDeZinc.setDate((java.util.Date) null);
            this.xJDC_FechaSulfatoDeZinc = "";
            this.JDC_FechaSulfatoDeZinc.setEnabled(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox4ActionPerformed(ActionEvent evt) {
        if (this.jCheckBox4.isSelected()) {
            this.JDC_FechaAtnOdont.setDate(this.xmt.getFechaActual());
            this.JDC_FechaAtnOdont.setEnabled(true);
        } else {
            this.JDC_FechaAtnOdont.setDate((java.util.Date) null);
            this.xJDC_FechaAtnOdont = "";
            this.JDC_FechaAtnOdont.setEnabled(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox3ActionPerformed(ActionEvent evt) {
        if (this.jCheckBox3.isSelected()) {
            this.JDC_FechaAntParasitario.setDate(this.xmt.getFechaActual());
            this.JDC_FechaAntParasitario.setEnabled(true);
        } else {
            this.JDC_FechaAntParasitario.setDate((java.util.Date) null);
            this.xJDC_FechaAntParasitario = "";
            this.JDC_FechaAntParasitario.setEnabled(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox2ActionPerformed(ActionEvent evt) {
        if (this.jCheckBox2.isSelected()) {
            this.JDC_FechaHierro.setDate(this.xmt.getFechaActual());
            this.JDC_FechaHierro.setEnabled(true);
        } else {
            this.JDC_FechaHierro.setDate((java.util.Date) null);
            this.xJDC_FechaHierro = "";
            this.JDC_FechaHierro.setEnabled(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox1ActionPerformed(ActionEvent evt) {
        if (this.jCheckBox1.isSelected()) {
            this.JDC_FechaVitA.setDate(this.xmt.getFechaActual());
            this.JDC_FechaVitA.setEnabled(true);
        } else {
            this.JDC_FechaVitA.setDate((java.util.Date) null);
            this.xJDC_FechaVitA = "";
            this.JDC_FechaVitA.setEnabled(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDC_FechaPCitaPropertyChange(PropertyChangeEvent evt) {
        if (this.JDC_FechaPCita.getDate() != null) {
            this.xJDC_FechaPCita = this.xmt.formatoAMD.format(this.JDC_FechaPCita.getDate());
        } else {
            this.xJDC_FechaPCita = "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDC_FechaAtnOdontPropertyChange(PropertyChangeEvent evt) {
        if (this.JDC_FechaAtnOdont.getDate() != null) {
            this.xJDC_FechaAtnOdont = this.xmt.formatoAMD.format(this.JDC_FechaAtnOdont.getDate());
        } else {
            this.xJDC_FechaAtnOdont = "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDC_FechaAntParasitarioPropertyChange(PropertyChangeEvent evt) {
        if (this.JDC_FechaAntParasitario.getDate() != null) {
            this.xJDC_FechaAntParasitario = this.xmt.formatoAMD.format(this.JDC_FechaAntParasitario.getDate());
        } else {
            this.xJDC_FechaAntParasitario = "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDC_FechaHierroPropertyChange(PropertyChangeEvent evt) {
        if (this.JDC_FechaHierro.getDate() != null) {
            this.xJDC_FechaHierro = this.xmt.formatoAMD.format(this.JDC_FechaHierro.getDate());
        } else {
            this.xJDC_FechaHierro = "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDC_FechaVitAPropertyChange(PropertyChangeEvent evt) {
        if (this.JDC_FechaVitA.getDate() != null) {
            this.xJDC_FechaVitA = this.xmt.formatoAMD.format(this.JDC_FechaVitA.getDate());
        } else {
            this.xJDC_FechaVitA = "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDC_FechaVihPropertyChange(PropertyChangeEvent evt) {
        if (this.JDC_FechaVih.getDate() != null) {
            this.xJDC_FechaVih = this.xmt.formatoAMD.format(this.JDC_FechaVih.getDate());
        } else {
            this.xJDC_FechaVih = "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHAplicaVihActionPerformed(ActionEvent evt) {
        if (this.JCHAplicaVih.isSelected()) {
            this.JDC_FechaVih.setDate(this.xmt.getFechaActual());
            this.JDC_FechaVih.setEnabled(true);
        } else {
            this.JDC_FechaVih.setDate((java.util.Date) null);
            this.JDC_FechaVih.setEnabled(false);
            this.xJDC_FechaVih = "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDC_FechaHemoglobinaPropertyChange(PropertyChangeEvent evt) {
        if (this.JDC_FechaHemoglobina.getDate() != null) {
            this.xJDC_FechaHemoglobina = this.xmt.formatoAMD.format(this.JDC_FechaHemoglobina.getDate());
        } else {
            this.xJDC_FechaHemoglobina = "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHAplicaHemoglobinaActionPerformed(ActionEvent evt) {
        if (this.JCHAplicaHemoglobina.isSelected()) {
            this.JDC_FechaHemoglobina.setDate(this.xmt.getFechaActual());
            this.JDC_FechaHemoglobina.setEnabled(true);
        } else {
            this.JDC_FechaHemoglobina.setDate((java.util.Date) null);
            this.JDC_FechaHemoglobina.setEnabled(false);
            this.xJDC_FechaHemoglobina = "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDC_FechaSulfatoDeZincPropertyChange(PropertyChangeEvent evt) {
        if (this.JDC_FechaSulfatoDeZinc.getDate() != null) {
            this.xJDC_FechaSulfatoDeZinc = this.xmt.formatoAMD.format(this.JDC_FechaSulfatoDeZinc.getDate());
        } else {
            this.xJDC_FechaSulfatoDeZinc = "";
        }
    }

    public void recuperaImagenBBDD() {
        try {
            ResultSet xrs = this.xct.traerRs("SELECT IdUsuario,IdUsuarioPrograma, IdGrafica, ImagenGrafica FROM p_usuario_grafica  WHERE Ruta='' LIMIT 3000");
            if (xrs.next()) {
                xrs.beforeFirst();
                while (xrs.next()) {
                    byte[] bytes = xrs.getBytes("ImagenGrafica");
                    this.Directorio = new File(this.xmt.mRutaSoporte("Graficas"));
                    ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
                    Iterator<?> readers = ImageIO.getImageReadersByFormatName("jpg");
                    ImageReader reader = (ImageReader) readers.next();
                    ImageInputStream iis = ImageIO.createImageInputStream(bis);
                    reader.setInput(iis, true);
                    ImageReadParam param = reader.getDefaultReadParam();
                    BufferedImage bufferedImage = reader.read(0, param);
                    BufferedImage bufferedImage2 = new BufferedImage(bufferedImage.getWidth((ImageObserver) null), bufferedImage.getHeight((ImageObserver) null), 1);
                    Graphics2D g2 = bufferedImage2.createGraphics();
                    g2.drawImage(bufferedImage, (AffineTransform) null, (ImageObserver) null);
                    File imageFile = new File(this.Directorio + xrs.getString("IdUsuario") + "_" + xrs.getString("IdUsuarioPrograma") + this.xmt.getBarra() + xrs.getString("IdGrafica") + ".jpg");
                    String sqlI = "UPDATE p_usuario_grafica SET Ruta='" + xrs.getString("IdGrafica") + ".jpg' WHERE IdUsuario='" + xrs.getString("IdUsuario") + "' AND IdUsuarioPrograma='" + xrs.getString("IdUsuarioPrograma") + "' AND  IdGrafica='" + xrs.getString("IdGrafica") + "'";
                    ConsultasMySQL xctI = new ConsultasMySQL();
                    xctI.ejecutarSQL(sqlI);
                    xctI.cerrarConexionBd();
                    if (imageFile.isDirectory()) {
                        ImageIO.write(bufferedImage2, "jpg", imageFile);
                    } else {
                        imageFile.mkdirs();
                        ImageIO.write(bufferedImage2, "jpg", imageFile);
                    }
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (IOException ex) {
            Logger.getLogger(JPGraficasPyP.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        } catch (SQLException ex2) {
            Logger.getLogger(JPGraficasPyP.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex2);
        }
    }

    private void mGuardarGrafica(long xidGrafica) {
        String sqlIs = "INSERT INTO  `p_usuario_grafica` (`IdUsuario`, `IdUsuarioPrograma`, `IdGrafica`, `UsuarioS`) VALUES('" + String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido()) + "','" + String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioPrograma()) + "','" + xidGrafica + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
        ConsultasMySQL xctI = new ConsultasMySQL();
        xctI.ejecutarSQL(sqlIs);
        xctI.cerrarConexionBd();
    }

    private void mCalcularImc() {
        if (this.JTFFSTalla.getText() != null && this.JTFFSPeso.getText() != null && !this.JTFFSPeso.getText().equals("0") && !this.JTFFSTalla.getText().equals("0") && !this.JTFFSTalla.getText().equals("0.0")) {
            DecimalFormat formato = new DecimalFormat("0.00");
            this.imc = (getPeso() / Math.pow(getTalla(), 2.0d)) * 10000.0d;
            this.JTFFSIMC.setText(String.valueOf(formato.format(this.imc)));
            return;
        }
        this.JTFFSIMC.setText("0");
    }

    private double getTalla() {
        double valor = 0.0d;
        if (this.JTFFSTalla.getText() != null && !this.JTFFSTalla.getText().equals("") && !this.JTFFSTalla.getText().equals("0") && Double.valueOf(this.JTFFSTalla.getText()).doubleValue() > 0.0d) {
            valor = Double.valueOf(this.JTFFSTalla.getText()).doubleValue();
        }
        return valor;
    }

    private double getPeso() {
        double valor = 0.0d;
        if (this.JTFFSPeso.getText() != null && !this.JTFFSPeso.getText().equals("") && Double.parseDouble(this.JTFFSPeso.getText()) > 0.0d) {
            valor = Double.parseDouble(this.JTFFSPeso.getText());
        }
        return valor;
    }

    private void mLlenarVectorGraficas() {
        String sql = "SELECT p_tipo_grafica.`imagen`, p_usuario_grafica.`IdGrafica` FROM `p_usuario_grafica` \nINNER JOIN `p_tipo_grafica` ON p_usuario_grafica.`IdGrafica`=p_tipo_grafica.`Id`\nWHERE p_usuario_grafica.`IdUsuarioPrograma`='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioPrograma() + "' ORDER BY p_usuario_grafica.`IdGrafica`";
        try {
            ResultSet xrs = this.xct.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                while (xrs.next()) {
                    mVerificarExistenciaElementoVector(xrs.getString("IdGrafica"));
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPGraficasPyP.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mVerificarExistenciaElementoVector(String xElemento) {
        boolean xexiste = false;
        int i = 0;
        while (true) {
            if (i >= this.xPanelesActivos.size()) {
                break;
            }
            if (!xElemento.equals(this.xPanelesActivos.elementAt(i))) {
                i++;
            } else {
                xexiste = true;
                break;
            }
        }
        if (!xexiste) {
            this.xPanelesActivos.addElement(xElemento);
        }
    }

    private void mGuardarSeg() {
        if (clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioPrograma().longValue() != 0) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                String sql = "INSERT INTO `p_seguimiento_cyd` (`Id_Usuario_Programa`, `IdAtencion`,FechaR, `LacMaternaExcl`, `EdadAlimentacion`,\n             `CasoCentinela`, `EventoVigilacia`, `FechaEventoVig`, `PesoEdad2`, `TallaEdad5`, `PesoTalla5`,\n             `IMCEdad`, `PCefalico`, `MotFina`, `MotGruesa`, `PerSocial`, `AudiLenguaje`, `FechaVitA`,\n             `FechaHierro`, `FechaAntiPar`, `FechaOdont`,  `EsqVacunacion`, `FechaPCita`,`FechaZinc`,`FechaVih`,`FechaHemoglobina`, `UsuarioS`)\nVALUES ( '" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioPrograma() + "',  '" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "', '" + this.xmt.formatoAMD.format(this.JDC_FechaI.getDate()) + "','" + this.JCBLacMaterna.getSelectedItem() + "', '" + this.JCBEdadMeses.getSelectedItem() + "', '" + this.JCBCCentinela.getSelectedItem() + "', '" + this.JCBEventoSPublica.getSelectedItem() + "',\n        '" + this.xJDC_FechaEvento + "', '" + this.JCBPesoEdad.getSelectedItem() + "', '" + this.JCBTallaEdad.getSelectedItem() + "', '" + this.JCBPesoTalla.getSelectedItem() + "', '" + this.JCBIMCEdad.getSelectedItem() + "',  '" + this.JCBPCefalico.getSelectedItem() + "', '" + this.JCBMFina.getSelectedItem() + "', '" + this.JCBMGruesa.getSelectedItem() + "',\n        '" + this.JCBPSocial.getSelectedItem() + "',  '" + this.JCBALenguaje.getSelectedItem() + "', '" + this.xJDC_FechaVitA + "', '" + this.xJDC_FechaHierro + "', '" + this.xJDC_FechaAntParasitario + "',  '" + this.xJDC_FechaAtnOdont + "', \n        '" + this.JCBEsqVacunacion.getSelectedItem() + "', '" + this.xJDC_FechaPCita + "','" + this.xJDC_FechaSulfatoDeZinc + " ','" + this.xJDC_FechaVih + "','" + this.xJDC_FechaHemoglobina + "' ,'" + Principal.usuarioSistemaDTO.getLogin() + "')";
                this.xct.ejecutarSQL(sql);
                this.xct.cerrarConexionBd();
                this.JBGuardar.setEnabled(false);
                mBuscaHistoricoSeguimiento();
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "El paciente no se encuentra Matriculado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }
}
