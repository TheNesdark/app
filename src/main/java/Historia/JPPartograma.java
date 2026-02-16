package Historia;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.JChomboBox;
import Utilidades.JChomboRenderer;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
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
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

/* JADX INFO: loaded from: GenomaP.jar:Historia/JPPartograma.class */
public class JPPartograma extends JPanel {
    private ImagenPartograma Grafica;
    private String[] xIdPosM;
    private String[] xIdPosMEf;
    private DefaultTableModel xmodelo;
    private DefaultTableModel xmodeloEF;
    private Object[] xdatos;
    private JChomboBox jchombobox;
    public JRadioButton INT_MULT;
    public JRadioButton INT_NULIP;
    public JRadioButton INT_VERT;
    private JComboBox JCBIntensidad;
    private JComboBox JCBIntensidadEF;
    private JComboBox JCBLocalizacion;
    private JComboBox JCBLocalizacionEF;
    private JComboBox JCBPlanoHodge;
    private JComboBox JCBPosMat;
    private JComboBox JCBPosMatEF;
    private JComboBox JCBRotura;
    private JLabel JLBPBSentado;
    private JLabel JLBPBSentado1;
    private JLabel JLBPSentado1;
    private JLabel JLBPSentado2;
    private JLabel JLValoresRef;
    private JPanel JPGrafico;
    private JPanel JPGraficoLineas;
    private JPanel JPIPresion;
    private JPanel JPIPresion1;
    private JPanel JPValores;
    private JTextArea JTAObservacion;
    private JTextArea JTAObservacionEF;
    private JTable JTBHistorico;
    private JTable JTBHistoricoEF;
    private JFormattedTextField JTFFBorrami;
    private JFormattedTextField JTFFBorramiEF;
    private JFormattedTextField JTFFDilatacion;
    private JFormattedTextField JTFFDilatacionEF;
    private JFormattedTextField JTFFDurContraccion;
    private JFormattedTextField JTFFDurContraccionEF;
    private JFormattedTextField JTFFFrecCardiacaFet;
    private JFormattedTextField JTFFFrecCardiacaFetEF;
    private JFormattedTextField JTFFFrecContraccion;
    private JFormattedTextField JTFFFrecContraccionEF;
    private JFormattedTextField JTFFHora;
    private JFormattedTextField JTFFHoraEF;
    private JFormattedTextField JTFFPSentadoD;
    private JFormattedTextField JTFFPSentadoDEF;
    private JFormattedTextField JTFFPSentadoS;
    private JFormattedTextField JTFFPSentadoSEF;
    private JFormattedTextField JTFFPulsoMaterno;
    private JFormattedTextField JTFFPulsoMaternoEF;
    private JLabel JlBorde1;
    private JLabel JlBorde2;
    private JLabel JlBorde3;
    private JLabel JlBorde4;
    private JLabel JlBorde5;
    public JRadioButton ROTA_MULT;
    public JRadioButton ROTA_NULIP;
    private JLabel a;
    private JLabel b;
    private ButtonGroup buttonGroup1;
    private JLabel c;
    private JLabel d;
    private JLabel e;
    private JLabel f;
    private JLabel g;
    private JLabel h;
    private JLabel i;
    private JLabel j;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JPanel jPanel5;
    private JPanel jPanel6;
    private JPanel jPanel7;
    private JPanel jPanel8;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JScrollPane jScrollPane3;
    private JScrollPane jScrollPane4;
    private JTabbedPane jTabbedPane1;
    private JTabbedPane jTabbedPane2;
    private JLabel k;
    private JLabel l;
    private JLabel m;
    private JLabel n;
    private JLabel o;
    public JDateChooser txtFecha;
    public JDateChooser txtFechaEF;
    private String xTipoFrafica = "";
    private String xTipoGrafica2 = "";
    private ConsultasMySQL xct = new ConsultasMySQL();
    private Metodos xmt = new Metodos();
    private String xPartograma = "";
    private String xHoraCero = "";
    private boolean xInterseccion = false;
    private double[] xCoorRecta = new double[4];
    private double[] xCoordIntercesion = new double[2];
    private String xHodge = "";
    private String xMembrana = "";
    private ImageIcon[] items = {new ImageIcon(""), new ImageIcon(getClass().getResource("/Imagenes/Hodge/1-AIIO.png")), new ImageIcon(getClass().getResource("/Imagenes/Hodge/2-OITI.png")), new ImageIcon(getClass().getResource("/Imagenes/Hodge/3-OIIP.png")), new ImageIcon(getClass().getResource("/Imagenes/Hodge/4-OS.png")), new ImageIcon(getClass().getResource("/Imagenes/Hodge/5-OIDA.png")), new ImageIcon(getClass().getResource("/Imagenes/Hodge/6-OITD.png")), new ImageIcon(getClass().getResource("/Imagenes/Hodge/7-OIDP.png")), new ImageIcon(getClass().getResource("/Imagenes/Hodge/8-OP.png"))};

    public JPPartograma(String titulo) {
        initComponents();
        setBorder(BorderFactory.createTitledBorder((Border) null, titulo, 2, 0, new Font("Arial", 1, 14), Color.red));
        mIniciaComponentes();
        this.jchombobox = new JChomboBox(this.items.length);
        this.jchombobox.setBorder(BorderFactory.createTitledBorder((Border) null, "Variedad Posición", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        JChomboRenderer render = new JChomboRenderer(this.items);
        this.jchombobox.setRenderer(render);
        this.jPanel5.add(this.jchombobox);
        this.jchombobox.addActionListener(new ActionListener() { // from class: Historia.JPPartograma.1
            public void actionPerformed(ActionEvent e) {
                switch (Integer.valueOf(JPPartograma.this.jchombobox.getSelectedItem().toString()).intValue()) {
                    case 1:
                        JPPartograma.this.xHodge = "AIIO";
                        break;
                    case 2:
                        JPPartograma.this.xHodge = "OITI";
                        break;
                    case 3:
                        JPPartograma.this.xHodge = "OIIP";
                        break;
                    case 4:
                        JPPartograma.this.xHodge = "OS";
                        break;
                    case 5:
                        JPPartograma.this.xHodge = "OIDA";
                        break;
                    case 6:
                        JPPartograma.this.xHodge = "OITD";
                        break;
                    case 7:
                        JPPartograma.this.xHodge = "OIDP";
                        break;
                    case 8:
                        JPPartograma.this.xHodge = "OP";
                        break;
                    default:
                        JPPartograma.this.xHodge = "";
                        break;
                }
            }
        });
        mBuscar();
        mHoraCero();
        mIniciaPaneles();
        mBuscarEF();
    }

    /* JADX WARN: Type inference failed for: r3v150, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v302, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.buttonGroup1 = new ButtonGroup();
        this.jTabbedPane1 = new JTabbedPane();
        this.jPanel2 = new JPanel();
        this.JPValores = new JPanel();
        this.INT_VERT = new JRadioButton();
        this.INT_MULT = new JRadioButton();
        this.ROTA_MULT = new JRadioButton();
        this.INT_NULIP = new JRadioButton();
        this.ROTA_NULIP = new JRadioButton();
        this.JlBorde1 = new JLabel();
        this.JlBorde2 = new JLabel();
        this.JlBorde3 = new JLabel();
        this.JlBorde4 = new JLabel();
        this.JlBorde5 = new JLabel();
        this.JLValoresRef = new JLabel();
        this.jLabel1 = new JLabel();
        this.jTabbedPane2 = new JTabbedPane();
        this.jPanel3 = new JPanel();
        this.txtFecha = new JDateChooser("dd/MM/yyyy", "##/##/####", '_');
        this.JTFFDilatacion = new JFormattedTextField();
        this.JCBPosMat = new JComboBox();
        this.JPIPresion = new JPanel();
        this.JTFFPSentadoS = new JFormattedTextField();
        this.JTFFPSentadoD = new JFormattedTextField();
        this.JLBPBSentado = new JLabel();
        this.JLBPSentado1 = new JLabel();
        this.JTFFPulsoMaterno = new JFormattedTextField();
        this.JTFFFrecCardiacaFet = new JFormattedTextField();
        this.JTFFDurContraccion = new JFormattedTextField();
        this.JTFFFrecContraccion = new JFormattedTextField();
        this.jPanel4 = new JPanel();
        this.JCBIntensidad = new JComboBox();
        this.JCBLocalizacion = new JComboBox();
        this.JTFFBorrami = new JFormattedTextField();
        this.jScrollPane2 = new JScrollPane();
        this.JTAObservacion = new JTextArea();
        this.JTFFHora = new JFormattedTextField();
        this.JCBRotura = new JComboBox();
        this.jPanel5 = new JPanel();
        this.JCBPlanoHodge = new JComboBox();
        this.jScrollPane1 = new JScrollPane();
        this.JTBHistorico = new JTable();
        this.jPanel1 = new JPanel();
        this.JPGrafico = new JPanel();
        this.JPGraficoLineas = new JPanel();
        this.jLabel2 = new JLabel();
        this.a = new JLabel();
        this.b = new JLabel();
        this.c = new JLabel();
        this.d = new JLabel();
        this.e = new JLabel();
        this.f = new JLabel();
        this.g = new JLabel();
        this.h = new JLabel();
        this.i = new JLabel();
        this.j = new JLabel();
        this.k = new JLabel();
        this.l = new JLabel();
        this.m = new JLabel();
        this.n = new JLabel();
        this.o = new JLabel();
        this.jPanel6 = new JPanel();
        this.jPanel7 = new JPanel();
        this.txtFechaEF = new JDateChooser("dd/MM/yyyy", "##/##/####", '_');
        this.JTFFDilatacionEF = new JFormattedTextField();
        this.JCBPosMatEF = new JComboBox();
        this.JPIPresion1 = new JPanel();
        this.JTFFPSentadoSEF = new JFormattedTextField();
        this.JTFFPSentadoDEF = new JFormattedTextField();
        this.JLBPBSentado1 = new JLabel();
        this.JLBPSentado2 = new JLabel();
        this.JTFFPulsoMaternoEF = new JFormattedTextField();
        this.JTFFFrecCardiacaFetEF = new JFormattedTextField();
        this.JTFFDurContraccionEF = new JFormattedTextField();
        this.JTFFFrecContraccionEF = new JFormattedTextField();
        this.jPanel8 = new JPanel();
        this.JCBIntensidadEF = new JComboBox();
        this.JCBLocalizacionEF = new JComboBox();
        this.JTFFBorramiEF = new JFormattedTextField();
        this.jScrollPane3 = new JScrollPane();
        this.JTAObservacionEF = new JTextArea();
        this.JTFFHoraEF = new JFormattedTextField();
        this.jScrollPane4 = new JScrollPane();
        this.JTBHistoricoEF = new JTable();
        setBorder(BorderFactory.createTitledBorder((Border) null, "TITULO", 2, 0, new Font("Arial", 1, 14), Color.red));
        setName("xjPartograma");
        this.jTabbedPane1.setForeground(new Color(0, 102, 0));
        this.jTabbedPane1.setFont(new Font("Arial", 1, 14));
        this.jTabbedPane1.setName("");
        this.JPValores.setMaximumSize(new Dimension(473, 169));
        this.JPValores.setMinimumSize(new Dimension(473, 169));
        this.JPValores.setPreferredSize(new Dimension(473, 169));
        this.JPValores.setLayout((LayoutManager) null);
        this.INT_VERT.setBackground(new Color(197, 217, 241));
        this.INT_VERT.setName("INT_VERT");
        this.INT_VERT.addActionListener(new ActionListener() { // from class: Historia.JPPartograma.2
            public void actionPerformed(ActionEvent evt) {
                JPPartograma.this.INT_VERTActionPerformed(evt);
            }
        });
        this.JPValores.add(this.INT_VERT);
        this.INT_VERT.setBounds(148, 43, 21, 15);
        this.INT_MULT.setBackground(new Color(197, 217, 241));
        this.INT_MULT.setName("INT_MULT");
        this.INT_MULT.addActionListener(new ActionListener() { // from class: Historia.JPPartograma.3
            public void actionPerformed(ActionEvent evt) {
                JPPartograma.this.INT_MULTActionPerformed(evt);
            }
        });
        this.JPValores.add(this.INT_MULT);
        this.INT_MULT.setBounds(230, 43, 21, 15);
        this.ROTA_MULT.setBackground(new Color(197, 217, 241));
        this.ROTA_MULT.setName("ROTA_MULT");
        this.ROTA_MULT.addActionListener(new ActionListener() { // from class: Historia.JPPartograma.4
            public void actionPerformed(ActionEvent evt) {
                JPPartograma.this.ROTA_MULTActionPerformed(evt);
            }
        });
        this.JPValores.add(this.ROTA_MULT);
        this.ROTA_MULT.setBounds(298, 43, 21, 15);
        this.INT_NULIP.setBackground(new Color(197, 217, 241));
        this.INT_NULIP.setName("INT_NULIP");
        this.INT_NULIP.addActionListener(new ActionListener() { // from class: Historia.JPPartograma.5
            public void actionPerformed(ActionEvent evt) {
                JPPartograma.this.INT_NULIPActionPerformed(evt);
            }
        });
        this.JPValores.add(this.INT_NULIP);
        this.INT_NULIP.setBounds(378, 43, 21, 15);
        this.ROTA_NULIP.setBackground(new Color(197, 217, 241));
        this.ROTA_NULIP.setName("ROTA_NULIP");
        this.ROTA_NULIP.addActionListener(new ActionListener() { // from class: Historia.JPPartograma.6
            public void actionPerformed(ActionEvent evt) {
                JPPartograma.this.ROTA_NULIPActionPerformed(evt);
            }
        });
        this.JPValores.add(this.ROTA_NULIP);
        this.ROTA_NULIP.setBounds(443, 43, 21, 15);
        this.JlBorde1.setMaximumSize(new Dimension(53, 110));
        this.JlBorde1.setMinimumSize(new Dimension(53, 110));
        this.JlBorde1.setPreferredSize(new Dimension(53, 110));
        this.JPValores.add(this.JlBorde1);
        this.JlBorde1.setBounds(103, 60, 53, 110);
        this.JlBorde2.setMaximumSize(new Dimension(53, 110));
        this.JlBorde2.setMinimumSize(new Dimension(53, 110));
        this.JlBorde2.setPreferredSize(new Dimension(53, 110));
        this.JPValores.add(this.JlBorde2);
        this.JlBorde2.setBounds(186, 60, 53, 110);
        this.JlBorde3.setMaximumSize(new Dimension(53, 110));
        this.JlBorde3.setMinimumSize(new Dimension(53, 110));
        this.JlBorde3.setPreferredSize(new Dimension(53, 110));
        this.JPValores.add(this.JlBorde3);
        this.JlBorde3.setBounds(260, 60, 53, 110);
        this.JlBorde4.setMaximumSize(new Dimension(53, 110));
        this.JlBorde4.setMinimumSize(new Dimension(53, 110));
        this.JlBorde4.setPreferredSize(new Dimension(53, 110));
        this.JPValores.add(this.JlBorde4);
        this.JlBorde4.setBounds(335, 60, 53, 110);
        this.JlBorde5.setMaximumSize(new Dimension(53, 110));
        this.JlBorde5.setMinimumSize(new Dimension(53, 110));
        this.JlBorde5.setPreferredSize(new Dimension(53, 110));
        this.JPValores.add(this.JlBorde5);
        this.JlBorde5.setBounds(410, 60, 53, 110);
        this.JLValoresRef.setIcon(new ImageIcon(getClass().getResource("/Imagenes/curva_alerta.png")));
        this.JPValores.add(this.JLValoresRef);
        this.JLValoresRef.setBounds(10, 0, 473, 169);
        this.jLabel1.setFont(new Font("Arial", 1, 12));
        this.jLabel1.setHorizontalAlignment(0);
        this.jLabel1.setText("VALORES PARA LA CONSTRUCCIÓN DE LAS CURVAS DE ALERTA");
        this.jTabbedPane2.setForeground(Color.red);
        this.jTabbedPane2.setFont(new Font("Arial", 1, 14));
        this.txtFecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtFecha.setDateFormatString("dd/MM/yyyy");
        this.txtFecha.setFont(new Font("Tahoma", 1, 12));
        this.txtFecha.addKeyListener(new KeyAdapter() { // from class: Historia.JPPartograma.7
            public void keyPressed(KeyEvent evt) {
                JPPartograma.this.txtFechaKeyPressed(evt);
            }
        });
        this.JTFFDilatacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Dilatación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFDilatacion.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#"))));
        this.JTFFDilatacion.setHorizontalAlignment(0);
        this.JTFFDilatacion.setFont(new Font("Arial", 1, 12));
        this.JCBPosMat.setFont(new Font("Arial", 1, 12));
        this.JCBPosMat.setBorder(BorderFactory.createTitledBorder((Border) null, "Posición Materna", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JPIPresion.setBorder(BorderFactory.createTitledBorder((Border) null, "Tensión Arterial", 2, 0, new Font("Arial", 1, 12), Color.red));
        this.JPIPresion.setLayout(new AbsoluteLayout());
        this.JTFFPSentadoS.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.JTFFPSentadoS.setHorizontalAlignment(4);
        this.JTFFPSentadoS.setFont(new Font("Arial", 1, 12));
        this.JTFFPSentadoS.setName("fechanaciemiento");
        this.JTFFPSentadoS.setValue(new Integer(0));
        this.JTFFPSentadoS.addActionListener(new ActionListener() { // from class: Historia.JPPartograma.8
            public void actionPerformed(ActionEvent evt) {
                JPPartograma.this.JTFFPSentadoSActionPerformed(evt);
            }
        });
        this.JTFFPSentadoS.addFocusListener(new FocusAdapter() { // from class: Historia.JPPartograma.9
            public void focusLost(FocusEvent evt) {
                JPPartograma.this.JTFFPSentadoSFocusLost(evt);
            }
        });
        this.JPIPresion.add(this.JTFFPSentadoS, new AbsoluteConstraints(10, 20, 45, 25));
        this.JTFFPSentadoD.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.JTFFPSentadoD.setHorizontalAlignment(4);
        this.JTFFPSentadoD.setFont(new Font("Arial", 1, 12));
        this.JTFFPSentadoD.setName("fechanaciemiento");
        this.JTFFPSentadoD.setValue(new Integer(0));
        this.JTFFPSentadoD.addActionListener(new ActionListener() { // from class: Historia.JPPartograma.10
            public void actionPerformed(ActionEvent evt) {
                JPPartograma.this.JTFFPSentadoDActionPerformed(evt);
            }
        });
        this.JTFFPSentadoD.addFocusListener(new FocusAdapter() { // from class: Historia.JPPartograma.11
            public void focusLost(FocusEvent evt) {
                JPPartograma.this.JTFFPSentadoDFocusLost(evt);
            }
        });
        this.JPIPresion.add(this.JTFFPSentadoD, new AbsoluteConstraints(70, 20, 45, 25));
        this.JLBPBSentado.setFont(new Font("Arial", 1, 18));
        this.JLBPBSentado.setForeground(Color.blue);
        this.JLBPBSentado.setHorizontalAlignment(0);
        this.JLBPBSentado.setText("/");
        this.JPIPresion.add(this.JLBPBSentado, new AbsoluteConstraints(60, 20, -1, 23));
        this.JLBPSentado1.setFont(new Font("Arial", 1, 12));
        this.JLBPSentado1.setForeground(Color.blue);
        this.JLBPSentado1.setHorizontalAlignment(0);
        this.JLBPSentado1.setText("Sistólica  /  Diastólica");
        this.JPIPresion.add(this.JLBPSentado1, new AbsoluteConstraints(10, 50, 130, -1));
        this.JTFFPulsoMaterno.setBorder(BorderFactory.createTitledBorder((Border) null, "Pulso Materno", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFPulsoMaterno.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.JTFFPulsoMaterno.setHorizontalAlignment(0);
        this.JTFFPulsoMaterno.setFont(new Font("Arial", 1, 12));
        this.JTFFFrecCardiacaFet.setBorder(BorderFactory.createTitledBorder((Border) null, "Frec. Cardiaca Fetal", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFFrecCardiacaFet.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.JTFFFrecCardiacaFet.setHorizontalAlignment(0);
        this.JTFFFrecCardiacaFet.setFont(new Font("Arial", 1, 12));
        this.JTFFDurContraccion.setBorder(BorderFactory.createTitledBorder((Border) null, "Duración Contracciones", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFDurContraccion.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.JTFFDurContraccion.setHorizontalAlignment(0);
        this.JTFFDurContraccion.setFont(new Font("Arial", 1, 12));
        this.JTFFFrecContraccion.setBorder(BorderFactory.createTitledBorder((Border) null, "Frec. Contracciones", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFFrecContraccion.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.JTFFFrecContraccion.setHorizontalAlignment(0);
        this.JTFFFrecContraccion.setFont(new Font("Arial", 1, 12));
        this.jPanel4.setBorder(BorderFactory.createTitledBorder((Border) null, "Dolor", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JCBIntensidad.setFont(new Font("Arial", 1, 12));
        this.JCBIntensidad.setModel(new DefaultComboBoxModel(new String[]{" ", "+", "++", "+++"}));
        this.JCBIntensidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Intensidad", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JCBLocalizacion.setFont(new Font("Arial", 1, 12));
        this.JCBLocalizacion.setModel(new DefaultComboBoxModel(new String[]{" ", "Suprapúbico", "Sacro"}));
        this.JCBLocalizacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Localización", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
        this.jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addGap(5, 5, 5).addComponent(this.JCBIntensidad, -2, 81, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBLocalizacion, -2, -1, -2).addGap(5, 5, 5)));
        jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addGap(5, 5, 5).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBIntensidad, -2, 48, -2).addComponent(this.JCBLocalizacion, -2, 48, -2)).addGap(5, 5, 5)));
        this.JTFFBorrami.setBorder(BorderFactory.createTitledBorder((Border) null, "Borramiento (%)", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFBorrami.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#"))));
        this.JTFFBorrami.setHorizontalAlignment(0);
        this.JTFFBorrami.setFont(new Font("Arial", 1, 12));
        this.JTAObservacion.setColumns(1);
        this.JTAObservacion.setFont(new Font("Arial", 1, 12));
        this.JTAObservacion.setLineWrap(true);
        this.JTAObservacion.setRows(1);
        this.JTAObservacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jScrollPane2.setViewportView(this.JTAObservacion);
        this.JTFFHora.setBorder(BorderFactory.createTitledBorder((Border) null, "Hora", 0, 0, new Font("Arial", 1, 12), Color.blue));
        try {
            this.JTFFHora.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("##:##:##")));
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        this.JTFFHora.setHorizontalAlignment(4);
        this.JTFFHora.setToolTipText("Formato 24 horas (HH:mm:ss)");
        this.JTFFHora.setFont(new Font("Arial", 1, 12));
        this.JCBRotura.setFont(new Font("Arial", 1, 12));
        this.JCBRotura.setModel(new DefaultComboBoxModel(new String[]{" ", "REM", "RAM"}));
        this.JCBRotura.setBorder(BorderFactory.createTitledBorder((Border) null, "Rotura", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JCBRotura.setEnabled(false);
        this.jPanel5.setMaximumSize(new Dimension(180, 64));
        this.jPanel5.setMinimumSize(new Dimension(180, 64));
        this.jPanel5.setPreferredSize(new Dimension(180, 64));
        GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
        this.jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 180, 32767));
        jPanel5Layout.setVerticalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 67, 32767));
        this.JCBPlanoHodge.setFont(new Font("Arial", 1, 12));
        this.JCBPlanoHodge.setModel(new DefaultComboBoxModel(new String[]{" ", "I", "II", "III", "IV"}));
        this.JCBPlanoHodge.setBorder(BorderFactory.createTitledBorder((Border) null, "Hodge", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
        this.jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane2, -2, 765, -2).addGroup(jPanel3Layout.createSequentialGroup().addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addComponent(this.jPanel4, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFFBorrami, -2, 118, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBRotura, -2, 81, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel5, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBPlanoHodge, -2, 65, -2)).addGroup(jPanel3Layout.createSequentialGroup().addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addComponent(this.txtFecha, -2, 130, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFHora, -2, 110, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFFDilatacion, -2, 80, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBPosMat, -2, 237, -2)).addGroup(jPanel3Layout.createSequentialGroup().addGap(14, 14, 14).addComponent(this.JTFFPulsoMaterno, -2, 110, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFFrecCardiacaFet, -2, 138, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFDurContraccion, -2, 161, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFFrecContraccion, -2, 152, -2))).addGap(18, 18, 18).addComponent(this.JPIPresion, -2, 154, -2))).addGap(0, 0, 32767))).addContainerGap()));
        jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addGap(5, 5, 5).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.txtFecha, -2, 50, -2).addComponent(this.JCBPosMat, -2, 50, -2).addComponent(this.JTFFDilatacion, -2, 50, -2).addComponent(this.JTFFHora, -2, 50, -2)).addGap(5, 5, 5).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFFPulsoMaterno, -2, 48, -2).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFFrecCardiacaFet, -2, 48, -2).addComponent(this.JTFFDurContraccion, -2, 48, -2).addComponent(this.JTFFFrecContraccion, -2, 48, -2)))).addComponent(this.JPIPresion, -2, 75, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel4, -2, -1, -2).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFBorrami, -2, 48, -2).addComponent(this.JCBRotura, -2, 48, -2)).addComponent(this.jPanel5, -2, 67, -2).addComponent(this.JCBPlanoHodge, -2, 48, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane2, -2, 71, -2).addGap(23, 23, 23)));
        this.jTabbedPane2.addTab("INFORMACIÓN", this.jPanel3);
        this.jScrollPane1.setBorder((Border) null);
        this.JTBHistorico.setFont(new Font("Arial", 1, 12));
        this.JTBHistorico.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTBHistorico.setSelectionBackground(new Color(255, 255, 255));
        this.JTBHistorico.setSelectionForeground(Color.red);
        this.jScrollPane1.setViewportView(this.JTBHistorico);
        this.jTabbedPane2.addTab("DETALLE", this.jScrollPane1);
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGap(10, 10, 10).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JPValores, -2, -1, -2).addComponent(this.jLabel1, -2, 460, -2)).addComponent(this.jTabbedPane2, -2, 800, -2)).addContainerGap(-1, 32767)));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.jLabel1, -2, 19, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPValores, -2, -1, -2).addGap(29, 29, 29).addComponent(this.jTabbedPane2, -1, 340, 32767).addContainerGap()));
        this.jTabbedPane1.addTab("DATOS A GRAFICAR", this.jPanel2);
        this.JPGrafico.setMaximumSize(new Dimension(750, 524));
        this.JPGrafico.setMinimumSize(new Dimension(750, 524));
        this.JPGrafico.setPreferredSize(new Dimension(750, 524));
        this.JPGrafico.setLayout((LayoutManager) null);
        this.JPGraficoLineas.setMaximumSize(new Dimension(750, 524));
        this.JPGraficoLineas.setMinimumSize(new Dimension(750, 524));
        this.JPGraficoLineas.setOpaque(false);
        GroupLayout JPGraficoLineasLayout = new GroupLayout(this.JPGraficoLineas);
        this.JPGraficoLineas.setLayout(JPGraficoLineasLayout);
        JPGraficoLineasLayout.setHorizontalGroup(JPGraficoLineasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 750, 32767));
        JPGraficoLineasLayout.setVerticalGroup(JPGraficoLineasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 524, 32767));
        this.JPGrafico.add(this.JPGraficoLineas);
        this.JPGraficoLineas.setBounds(0, 0, 750, 524);
        this.jLabel2.setIcon(new ImageIcon(getClass().getResource("/Imagenes/partograma-1.png")));
        this.jLabel2.setOpaque(true);
        this.JPGrafico.add(this.jLabel2);
        this.jLabel2.setBounds(0, 0, 750, 524);
        this.a.setFont(new Font("Arial", 1, 12));
        this.a.setHorizontalAlignment(0);
        this.a.setBorder(BorderFactory.createEtchedBorder());
        this.JPGrafico.add(this.a);
        this.a.setBounds(10, 530, 47, 18);
        this.b.setFont(new Font("Arial", 1, 12));
        this.b.setHorizontalAlignment(0);
        this.b.setBorder(BorderFactory.createEtchedBorder());
        this.JPGrafico.add(this.b);
        this.b.setBounds(56, 530, 44, 18);
        this.c.setFont(new Font("Arial", 1, 12));
        this.c.setHorizontalAlignment(0);
        this.c.setBorder(BorderFactory.createEtchedBorder());
        this.JPGrafico.add(this.c);
        this.c.setBounds(98, 530, 44, 18);
        this.d.setFont(new Font("Arial", 1, 12));
        this.d.setHorizontalAlignment(0);
        this.d.setBorder(BorderFactory.createEtchedBorder());
        this.JPGrafico.add(this.d);
        this.d.setBounds(140, 530, 48, 18);
        this.e.setFont(new Font("Arial", 1, 12));
        this.e.setHorizontalAlignment(0);
        this.e.setBorder(BorderFactory.createEtchedBorder());
        this.JPGrafico.add(this.e);
        this.e.setBounds(187, 530, 48, 18);
        this.f.setFont(new Font("Arial", 1, 12));
        this.f.setHorizontalAlignment(0);
        this.f.setBorder(BorderFactory.createEtchedBorder());
        this.JPGrafico.add(this.f);
        this.f.setBounds(233, 530, 48, 18);
        this.g.setFont(new Font("Arial", 1, 12));
        this.g.setHorizontalAlignment(0);
        this.g.setBorder(BorderFactory.createEtchedBorder());
        this.JPGrafico.add(this.g);
        this.g.setBounds(280, 530, 47, 18);
        this.h.setFont(new Font("Arial", 1, 12));
        this.h.setHorizontalAlignment(0);
        this.h.setBorder(BorderFactory.createEtchedBorder());
        this.JPGrafico.add(this.h);
        this.h.setBounds(326, 530, 44, 18);
        this.i.setFont(new Font("Arial", 1, 12));
        this.i.setHorizontalAlignment(0);
        this.i.setBorder(BorderFactory.createEtchedBorder());
        this.JPGrafico.add(this.i);
        this.i.setBounds(368, 530, 44, 18);
        this.j.setFont(new Font("Arial", 1, 12));
        this.j.setHorizontalAlignment(0);
        this.j.setBorder(BorderFactory.createEtchedBorder());
        this.JPGrafico.add(this.j);
        this.j.setBounds(410, 530, 48, 18);
        this.k.setFont(new Font("Arial", 1, 12));
        this.k.setHorizontalAlignment(0);
        this.k.setBorder(BorderFactory.createEtchedBorder());
        this.JPGrafico.add(this.k);
        this.k.setBounds(456, 530, 46, 18);
        this.l.setFont(new Font("Arial", 1, 12));
        this.l.setHorizontalAlignment(0);
        this.l.setBorder(BorderFactory.createEtchedBorder());
        this.JPGrafico.add(this.l);
        this.l.setBounds(500, 530, 47, 18);
        this.m.setFont(new Font("Arial", 1, 12));
        this.m.setHorizontalAlignment(0);
        this.m.setBorder(BorderFactory.createEtchedBorder());
        this.JPGrafico.add(this.m);
        this.m.setBounds(546, 530, 47, 18);
        this.n.setFont(new Font("Arial", 1, 12));
        this.n.setHorizontalAlignment(0);
        this.n.setBorder(BorderFactory.createEtchedBorder());
        this.JPGrafico.add(this.n);
        this.n.setBounds(592, 530, 47, 18);
        this.o.setFont(new Font("Arial", 1, 12));
        this.o.setHorizontalAlignment(0);
        this.o.setBorder(BorderFactory.createEtchedBorder());
        this.JPGrafico.add(this.o);
        this.o.setBounds(638, 530, 48, 18);
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.JPGrafico, -2, 750, -2).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.JPGrafico, -2, 557, -2).addContainerGap(-1, 32767)));
        this.jTabbedPane1.addTab("GRÁFICO", this.jPanel1);
        this.jPanel7.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.txtFechaEF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtFechaEF.setDateFormatString("dd/MM/yyyy");
        this.txtFechaEF.setFont(new Font("Tahoma", 1, 12));
        this.txtFechaEF.addKeyListener(new KeyAdapter() { // from class: Historia.JPPartograma.12
            public void keyPressed(KeyEvent evt) {
                JPPartograma.this.txtFechaEFKeyPressed(evt);
            }
        });
        this.JTFFDilatacionEF.setBorder(BorderFactory.createTitledBorder((Border) null, "Dilatación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFDilatacionEF.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#"))));
        this.JTFFDilatacionEF.setHorizontalAlignment(0);
        this.JTFFDilatacionEF.setFont(new Font("Arial", 1, 12));
        this.JCBPosMatEF.setFont(new Font("Arial", 1, 12));
        this.JCBPosMatEF.setBorder(BorderFactory.createTitledBorder((Border) null, "Posición Materna", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JPIPresion1.setBorder(BorderFactory.createTitledBorder((Border) null, "Tensión Arterial", 2, 0, new Font("Arial", 1, 12), Color.red));
        this.JPIPresion1.setLayout(new AbsoluteLayout());
        this.JTFFPSentadoSEF.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.JTFFPSentadoSEF.setHorizontalAlignment(4);
        this.JTFFPSentadoSEF.setFont(new Font("Arial", 1, 12));
        this.JTFFPSentadoSEF.setName("fechanaciemiento");
        this.JTFFPSentadoSEF.setValue(new Integer(0));
        this.JTFFPSentadoSEF.addActionListener(new ActionListener() { // from class: Historia.JPPartograma.13
            public void actionPerformed(ActionEvent evt) {
                JPPartograma.this.JTFFPSentadoSEFActionPerformed(evt);
            }
        });
        this.JTFFPSentadoSEF.addFocusListener(new FocusAdapter() { // from class: Historia.JPPartograma.14
            public void focusLost(FocusEvent evt) {
                JPPartograma.this.JTFFPSentadoSEFFocusLost(evt);
            }
        });
        this.JPIPresion1.add(this.JTFFPSentadoSEF, new AbsoluteConstraints(10, 20, 45, 25));
        this.JTFFPSentadoDEF.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.JTFFPSentadoDEF.setHorizontalAlignment(4);
        this.JTFFPSentadoDEF.setFont(new Font("Arial", 1, 12));
        this.JTFFPSentadoDEF.setName("fechanaciemiento");
        this.JTFFPSentadoDEF.setValue(new Integer(0));
        this.JTFFPSentadoDEF.addActionListener(new ActionListener() { // from class: Historia.JPPartograma.15
            public void actionPerformed(ActionEvent evt) {
                JPPartograma.this.JTFFPSentadoDEFActionPerformed(evt);
            }
        });
        this.JTFFPSentadoDEF.addFocusListener(new FocusAdapter() { // from class: Historia.JPPartograma.16
            public void focusLost(FocusEvent evt) {
                JPPartograma.this.JTFFPSentadoDEFFocusLost(evt);
            }
        });
        this.JPIPresion1.add(this.JTFFPSentadoDEF, new AbsoluteConstraints(70, 20, 45, 25));
        this.JLBPBSentado1.setFont(new Font("Arial", 1, 18));
        this.JLBPBSentado1.setForeground(Color.blue);
        this.JLBPBSentado1.setHorizontalAlignment(0);
        this.JLBPBSentado1.setText("/");
        this.JPIPresion1.add(this.JLBPBSentado1, new AbsoluteConstraints(60, 20, -1, 23));
        this.JLBPSentado2.setFont(new Font("Arial", 1, 12));
        this.JLBPSentado2.setForeground(Color.blue);
        this.JLBPSentado2.setHorizontalAlignment(0);
        this.JLBPSentado2.setText("Sistólica  /  Diastólica");
        this.JPIPresion1.add(this.JLBPSentado2, new AbsoluteConstraints(10, 50, 130, -1));
        this.JTFFPulsoMaternoEF.setBorder(BorderFactory.createTitledBorder((Border) null, "Pulso Materno", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFPulsoMaternoEF.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.JTFFPulsoMaternoEF.setHorizontalAlignment(0);
        this.JTFFPulsoMaternoEF.setFont(new Font("Arial", 1, 12));
        this.JTFFFrecCardiacaFetEF.setBorder(BorderFactory.createTitledBorder((Border) null, "Frec. Cardiaca Fetal", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFFrecCardiacaFetEF.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.JTFFFrecCardiacaFetEF.setHorizontalAlignment(0);
        this.JTFFFrecCardiacaFetEF.setFont(new Font("Arial", 1, 12));
        this.JTFFDurContraccionEF.setBorder(BorderFactory.createTitledBorder((Border) null, "Duración Contracciones", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFDurContraccionEF.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.JTFFDurContraccionEF.setHorizontalAlignment(0);
        this.JTFFDurContraccionEF.setFont(new Font("Arial", 1, 12));
        this.JTFFFrecContraccionEF.setBorder(BorderFactory.createTitledBorder((Border) null, "Frec. Contracciones", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFFrecContraccionEF.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.JTFFFrecContraccionEF.setHorizontalAlignment(0);
        this.JTFFFrecContraccionEF.setFont(new Font("Arial", 1, 12));
        this.jPanel8.setBorder(BorderFactory.createTitledBorder((Border) null, "Dolor", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JCBIntensidadEF.setFont(new Font("Arial", 1, 12));
        this.JCBIntensidadEF.setModel(new DefaultComboBoxModel(new String[]{" ", "+", "++", "+++"}));
        this.JCBIntensidadEF.setBorder(BorderFactory.createTitledBorder((Border) null, "Intensidad", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JCBLocalizacionEF.setFont(new Font("Arial", 1, 12));
        this.JCBLocalizacionEF.setModel(new DefaultComboBoxModel(new String[]{" ", "Suprapúbico", "Sacro"}));
        this.JCBLocalizacionEF.setBorder(BorderFactory.createTitledBorder((Border) null, "Localización", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        GroupLayout jPanel8Layout = new GroupLayout(this.jPanel8);
        this.jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel8Layout.createSequentialGroup().addGap(5, 5, 5).addComponent(this.JCBIntensidadEF, -2, 81, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBLocalizacionEF, -2, -1, -2).addGap(5, 5, 5)));
        jPanel8Layout.setVerticalGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel8Layout.createSequentialGroup().addGap(5, 5, 5).addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBIntensidadEF, -2, 48, -2).addComponent(this.JCBLocalizacionEF, -2, 48, -2)).addGap(5, 5, 5)));
        this.JTFFBorramiEF.setBorder(BorderFactory.createTitledBorder((Border) null, "Borramiento (%)", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFBorramiEF.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#"))));
        this.JTFFBorramiEF.setHorizontalAlignment(0);
        this.JTFFBorramiEF.setFont(new Font("Arial", 1, 12));
        this.JTAObservacionEF.setColumns(1);
        this.JTAObservacionEF.setFont(new Font("Arial", 1, 12));
        this.JTAObservacionEF.setLineWrap(true);
        this.JTAObservacionEF.setRows(1);
        this.JTAObservacionEF.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jScrollPane3.setViewportView(this.JTAObservacionEF);
        this.JTFFHoraEF.setBorder(BorderFactory.createTitledBorder((Border) null, "Hora", 0, 0, new Font("Arial", 1, 12), Color.blue));
        try {
            this.JTFFHoraEF.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("##:##:##")));
        } catch (ParseException ex2) {
            ex2.printStackTrace();
        }
        this.JTFFHoraEF.setHorizontalAlignment(4);
        this.JTFFHoraEF.setToolTipText("Formato 24 horas (HH:mm:ss)");
        this.JTFFHoraEF.setFont(new Font("Arial", 1, 12));
        GroupLayout jPanel7Layout = new GroupLayout(this.jPanel7);
        this.jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel7Layout.createSequentialGroup().addContainerGap().addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel7Layout.createSequentialGroup().addComponent(this.jScrollPane3, -2, 753, -2).addGap(13, 13, 13)).addGroup(jPanel7Layout.createSequentialGroup().addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel7Layout.createSequentialGroup().addComponent(this.txtFechaEF, -2, 130, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFHoraEF, -2, 110, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFFDilatacionEF, -2, 80, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBPosMatEF, -2, 237, -2)).addGroup(jPanel7Layout.createSequentialGroup().addGap(14, 14, 14).addComponent(this.JTFFPulsoMaternoEF, -2, 110, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFFrecCardiacaFetEF, -2, 138, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFDurContraccionEF, -2, 161, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFFrecContraccionEF, -2, 152, -2)).addGroup(jPanel7Layout.createSequentialGroup().addComponent(this.jPanel8, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFFBorramiEF, -2, 118, -2))).addGap(18, 18, 18).addComponent(this.JPIPresion1, -1, -1, -2))).addContainerGap()));
        jPanel7Layout.setVerticalGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel7Layout.createSequentialGroup().addGap(5, 5, 5).addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel7Layout.createSequentialGroup().addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.txtFechaEF, -2, 50, -2).addComponent(this.JCBPosMatEF, -2, 48, -2).addComponent(this.JTFFDilatacionEF, -2, 50, -2).addComponent(this.JTFFHoraEF, -2, 50, -2)).addGap(5, 5, 5).addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFFPulsoMaternoEF, -2, 48, -2).addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFFrecCardiacaFetEF, -2, 48, -2).addComponent(this.JTFFDurContraccionEF, -2, 48, -2).addComponent(this.JTFFFrecContraccionEF, -2, 48, -2)))).addComponent(this.JPIPresion1, -2, 75, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel8, -2, -1, -2).addComponent(this.JTFFBorramiEF, -2, 48, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane3, -2, 50, -2).addGap(10, 10, 10)));
        this.jScrollPane4.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JTBHistoricoEF.setFont(new Font("Arial", 1, 12));
        this.JTBHistoricoEF.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTBHistoricoEF.setSelectionBackground(new Color(255, 255, 255));
        this.JTBHistoricoEF.setSelectionForeground(Color.red);
        this.jScrollPane4.setViewportView(this.JTBHistoricoEF);
        GroupLayout jPanel6Layout = new GroupLayout(this.jPanel6);
        this.jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel6Layout.createSequentialGroup().addContainerGap().addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jPanel7, -1, -1, 32767).addComponent(this.jScrollPane4)).addGap(10, 10, 10)));
        jPanel6Layout.setVerticalGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel6Layout.createSequentialGroup().addGap(5, 5, 5).addComponent(this.jPanel7, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane4, -2, 171, -2).addGap(103, 103, 103)));
        this.jTabbedPane1.addTab("EXÁMEN FÍSICO", this.jPanel6);
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.jTabbedPane1, -2, 828, -2).addGap(10, 10, 10)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.jTabbedPane1, -2, -1, -2).addGap(10, 10, 10)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void INT_VERTActionPerformed(ActionEvent evt) {
        if (this.INT_VERT.isSelected()) {
            if (this.xPartograma.equals("")) {
                this.xTipoFrafica = this.INT_VERT.getName();
            }
            this.JlBorde1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/borde_rojo.png")));
            this.INT_NULIP.setEnabled(false);
            this.ROTA_NULIP.setEnabled(false);
            this.INT_MULT.setEnabled(false);
            this.ROTA_MULT.setEnabled(false);
            return;
        }
        if (this.xPartograma.equals("")) {
            this.JlBorde1.setIcon((Icon) null);
            this.INT_NULIP.setEnabled(true);
            this.ROTA_NULIP.setEnabled(true);
            this.INT_MULT.setEnabled(true);
            this.ROTA_MULT.setEnabled(true);
            this.xTipoFrafica = "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void INT_MULTActionPerformed(ActionEvent evt) {
        if (this.INT_MULT.isSelected()) {
            if (this.xPartograma.equals("")) {
                this.xTipoFrafica = this.INT_MULT.getName();
            } else {
                this.xTipoGrafica2 = this.INT_MULT.getName();
            }
            this.JlBorde2.setIcon(new ImageIcon(getClass().getResource("/Imagenes/borde_rojo.png")));
            this.INT_NULIP.setEnabled(false);
            this.ROTA_NULIP.setEnabled(false);
            return;
        }
        if (this.xPartograma.equals("")) {
            this.JlBorde2.setIcon((Icon) null);
            this.INT_NULIP.setEnabled(true);
            this.ROTA_NULIP.setEnabled(true);
            this.xTipoFrafica = "";
            return;
        }
        this.xTipoGrafica2 = "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ROTA_MULTActionPerformed(ActionEvent evt) {
        if (this.ROTA_MULT.isSelected()) {
            if (this.xPartograma.equals("")) {
                this.xTipoFrafica = this.ROTA_MULT.getName();
            } else {
                this.xTipoGrafica2 = this.ROTA_MULT.getName();
            }
            this.JlBorde3.setIcon(new ImageIcon(getClass().getResource("/Imagenes/borde_purpura.png")));
            this.INT_NULIP.setEnabled(false);
            this.ROTA_NULIP.setEnabled(false);
            this.JCBRotura.setEnabled(true);
            return;
        }
        if (this.xPartograma.equals("")) {
            this.JlBorde3.setIcon((Icon) null);
            this.INT_NULIP.setEnabled(true);
            this.ROTA_NULIP.setEnabled(true);
            this.xTipoFrafica = "";
        } else {
            this.xTipoGrafica2 = "";
        }
        this.JCBRotura.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void INT_NULIPActionPerformed(ActionEvent evt) {
        if (this.INT_NULIP.isSelected()) {
            if (this.xPartograma.equals("")) {
                this.xTipoFrafica = this.INT_NULIP.getName();
            } else {
                this.xTipoGrafica2 = this.INT_NULIP.getName();
            }
            this.xTipoFrafica = this.INT_NULIP.getName();
            this.JlBorde4.setIcon(new ImageIcon(getClass().getResource("/Imagenes/borde_rojo.png")));
            this.INT_MULT.setEnabled(false);
            this.ROTA_MULT.setEnabled(false);
            return;
        }
        if (this.xPartograma.equals("")) {
            this.JlBorde4.setIcon((Icon) null);
            this.INT_MULT.setEnabled(true);
            this.ROTA_MULT.setEnabled(true);
            this.xTipoFrafica = "";
            return;
        }
        this.xTipoGrafica2 = "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ROTA_NULIPActionPerformed(ActionEvent evt) {
        if (this.ROTA_NULIP.isSelected()) {
            if (this.xPartograma.equals("")) {
                this.xTipoFrafica = this.ROTA_NULIP.getName();
            } else {
                this.xTipoGrafica2 = this.ROTA_NULIP.getName();
            }
            this.xTipoFrafica = this.ROTA_NULIP.getName();
            this.JlBorde5.setIcon(new ImageIcon(getClass().getResource("/Imagenes/borde_purpura.png")));
            this.INT_MULT.setEnabled(false);
            this.ROTA_MULT.setEnabled(false);
            this.JCBRotura.setEnabled(true);
            return;
        }
        if (this.xPartograma.equals("")) {
            this.JlBorde5.setIcon((Icon) null);
            this.INT_MULT.setEnabled(true);
            this.ROTA_MULT.setEnabled(true);
        } else {
            this.xTipoGrafica2 = "";
        }
        this.JCBRotura.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtFechaKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFPSentadoSActionPerformed(ActionEvent evt) {
        this.JTFFPSentadoS.transferFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFPSentadoSFocusLost(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFPSentadoDActionPerformed(ActionEvent evt) {
        this.JTFFPSentadoD.transferFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFPSentadoDFocusLost(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtFechaEFKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFPSentadoSEFActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFPSentadoSEFFocusLost(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFPSentadoDEFActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFPSentadoDEFFocusLost(FocusEvent evt) {
    }

    private void mIniciaPaneles() {
        this.Grafica = null;
        this.Grafica = new ImagenPartograma(this, this.xTipoFrafica, 1, false);
        this.JPGraficoLineas.add(this.Grafica);
        this.JPGraficoLineas.repaint();
        this.Grafica = null;
        this.Grafica = new ImagenPartograma(this, this.xTipoFrafica, 0, false);
        this.JPGraficoLineas.add(this.Grafica);
        this.JPGraficoLineas.repaint();
        if (!this.xTipoGrafica2.equals("")) {
            this.Grafica = null;
            this.Grafica = new ImagenPartograma(this, this.xTipoGrafica2, 0, true);
            this.JPGraficoLineas.add(this.Grafica);
            this.JPGraficoLineas.repaint();
        }
    }

    private void mHoraCero() {
        if (this.JTBHistorico.getRowCount() > 0) {
            if (0 < this.JTBHistorico.getRowCount()) {
                this.xHoraCero = this.xmodelo.getValueAt(0, 1).toString() + " " + this.xmodelo.getValueAt(0, 2).toString();
            }
            String sql = "SELECT DATE_FORMAT('" + this.xHoraCero + "','%H:%i') AS a, DATE_FORMAT(ADDTIME('" + this.xHoraCero + "','01:00:00'),'%H:%i') AS b, DATE_FORMAT(ADDTIME('" + this.xHoraCero + "', '02:00:00'),'%H:%i') AS c, DATE_FORMAT(ADDTIME('" + this.xHoraCero + "', '03:00:00'),'%H:%i') AS d, DATE_FORMAT(ADDTIME('" + this.xHoraCero + "', '04:00:00'),'%H:%i') AS e, DATE_FORMAT(ADDTIME('" + this.xHoraCero + "', '05:00:00'),'%H:%i') AS f, DATE_FORMAT(ADDTIME('" + this.xHoraCero + "', '06:00:00'),'%H:%i') AS g, DATE_FORMAT(ADDTIME('" + this.xHoraCero + "', '07:00:00'),'%H:%i') AS h, DATE_FORMAT(ADDTIME('" + this.xHoraCero + "', '08:00:00'),'%H:%i') AS i, DATE_FORMAT(ADDTIME('" + this.xHoraCero + "', '09:00:00'),'%H:%i') AS j, DATE_FORMAT(ADDTIME('" + this.xHoraCero + "', '10:00:00'),'%H:%i') AS k, DATE_FORMAT(ADDTIME('" + this.xHoraCero + "', '11:00:00'),'%H:%i') AS l, DATE_FORMAT(ADDTIME('" + this.xHoraCero + "', '12:00:00'),'%H:%i') AS m, DATE_FORMAT(ADDTIME('" + this.xHoraCero + "', '13:00:00'),'%H:%i') AS n, DATE_FORMAT(ADDTIME('" + this.xHoraCero + "', '14:00:00'),'%H:%i') AS o ;";
            ResultSet xrs = this.xct.traerRs(sql);
            try {
                if (xrs.next()) {
                    xrs.first();
                    this.a.setText(xrs.getString("a"));
                    this.b.setText(xrs.getString("b"));
                    this.c.setText(xrs.getString("c"));
                    this.d.setText(xrs.getString("d"));
                    this.e.setText(xrs.getString("e"));
                    this.f.setText(xrs.getString("f"));
                    this.g.setText(xrs.getString("g"));
                    this.h.setText(xrs.getString("h"));
                    this.i.setText(xrs.getString("i"));
                    this.j.setText(xrs.getString("j"));
                    this.k.setText(xrs.getString("k"));
                    this.l.setText(xrs.getString("l"));
                    this.m.setText(xrs.getString("m"));
                    this.n.setText(xrs.getString("n"));
                    this.o.setText(xrs.getString("o"));
                }
                xrs.close();
                this.xct.cerrarConexionBd();
            } catch (SQLException ex) {
                Logger.getLogger(JPPartograma.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
    }

    private void mIniciaComponentes() {
        this.JTFFDilatacion.setValue(0);
        this.JTFFPulsoMaterno.setValue(0);
        this.JTFFFrecCardiacaFet.setValue(0);
        this.JTFFDurContraccion.setValue(0);
        this.JTFFFrecContraccion.setValue(0);
        this.JTFFBorrami.setValue(0);
        this.xIdPosM = this.xct.llenarCombo("SELECT Id, Nombre FROM g_pos_materna WHERE(Estado=1)", this.xIdPosM, this.JCBPosMat);
        this.JCBPosMat.setSelectedIndex(-1);
        this.xct.cerrarConexionBd();
        this.txtFecha.setDate(this.xmt.getFechaActual());
        this.JTFFHora.setText(this.xmt.formatoH24.format(this.xmt.getFechaActual()));
        this.xIdPosMEf = this.xct.llenarCombo("SELECT Id, Nombre FROM g_pos_materna WHERE(Estado=1)", this.xIdPosMEf, this.JCBPosMatEF);
        this.JCBPosMatEF.setSelectedIndex(-1);
        this.xct.cerrarConexionBd();
        this.txtFechaEF.setDate(this.xmt.getFechaActual());
        this.JTFFHoraEF.setText(this.xmt.formatoH24.format(this.xmt.getFechaActual()));
        this.JTFFDilatacionEF.setValue(0);
        this.JTFFPulsoMaternoEF.setValue(0);
        this.JTFFFrecCardiacaFetEF.setValue(0);
        this.JTFFDurContraccionEF.setValue(0);
        this.JTFFFrecContraccionEF.setValue(0);
        this.JTFFBorramiEF.setValue(0);
    }

    public void mGrabar() {
        if (this.jTabbedPane1.getSelectedIndex() == 0) {
            if (this.INT_VERT.isSelected() || this.INT_MULT.isSelected() || this.ROTA_MULT.isSelected() || this.INT_NULIP.isSelected() || this.ROTA_NULIP.isSelected()) {
                if (!mVerifcaFecha(this.xmt.formatoAMD.format(this.txtFecha.getDate()) + " " + this.JTFFHora.getText())) {
                    if (Integer.parseInt(this.JTFFDilatacion.getText()) > 3 && Integer.parseInt(this.JTFFDilatacion.getText()) <= 10) {
                        if (!mVerificaDilatacion(Integer.valueOf(this.JTFFDilatacion.getText()).intValue())) {
                            if (this.JCBPosMat.getSelectedIndex() > -1) {
                                if (!mVerificaRotura()) {
                                    if (!mVerificaPosicionCraneo()) {
                                        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                                        if (n == 0) {
                                            if (this.xPartograma.equals("")) {
                                                String sql = "INSERT INTO  `h_partograma` ( `IdAtencion`,`IdUsuario`,`IdProfesional`,`IdEspecialidad`,`FechaR`,`GRef1`,`UsuarioS`) VALUES ( '" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "','" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "','" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "','" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "','" + this.xTipoFrafica + "','" + Principal.usuarioSistemaDTO.getLogin() + "');";
                                                this.xPartograma = this.xct.ejecutarSQLId(sql);
                                                this.xct.cerrarConexionBd();
                                                mGuardarDetalle();
                                            } else {
                                                if (!this.xTipoGrafica2.equals("")) {
                                                    String sql2 = "UPDATE `h_partograma` SET `GRef2`='" + this.xTipoGrafica2 + "' WHERE (`Id`='" + this.xPartograma + "' AND `Estado` =1)";
                                                    this.xct.ejecutarSQL(sql2);
                                                    this.xct.cerrarConexionBd();
                                                }
                                                mGuardarDetalle();
                                            }
                                            this.xmt.cambiarEstadoValidadoItemHC(getName(), 1, true);
                                            mBuscar();
                                            mHoraCero();
                                            mNuevo();
                                            mIniciaPaneles();
                                            mGuardarGrafica(this.JPValores, 26L, "ImgTabla");
                                            mGuardarGrafica(this.JPGrafico, 26L, "ImgGrafica");
                                            return;
                                        }
                                        return;
                                    }
                                    JOptionPane.showInternalMessageDialog(this, "Debe seleccionar el Plano de Hodge", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                    this.JCBPlanoHodge.requestFocus();
                                    return;
                                }
                                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar el tipo de rotura ", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                this.JCBRotura.requestFocus();
                                return;
                            }
                            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar la posicion Materna ", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                            this.JCBPosMat.requestFocus();
                            return;
                        }
                        JOptionPane.showInternalMessageDialog(this, "La dilatacion debe ser mayor o igual a la última registrada", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        this.JTFFDilatacion.requestFocus();
                        return;
                    }
                    JOptionPane.showInternalMessageDialog(this, "La dilatacion debe estar entre 4 y 10 CM", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    this.JTFFDilatacion.requestFocus();
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "la Fecha u Hora debe ser mayor a la ultima registrada", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JTFFHora.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una condición (Membrana) ", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        if (this.jTabbedPane1.getSelectedIndex() == 2) {
            if (this.JCBPosMatEF.getSelectedIndex() > -1) {
                int n2 = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n2 == 0) {
                    mGuardarDetalleExFis();
                    mBuscarEF();
                    mNuevo();
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar la posicion Materna ", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBPosMatEF.requestFocus();
        }
    }

    private void mGuardarDetalle() {
        String sql2 = "INSERT INTO  `h_partograma_detalle`\n            ( `IdPartograma`,`FechaR`,`Hora`,`Dilatacion`,`PosMaterna`,`TArterial`,`PulsoMat`,`FreCardFetal`,`DurContraccion`,\n             `FreContraccion`,`Intensidad`,`Localizacion`,`Borramiento`,`Observacion`,`IdProfesional`,`IdEspecialidad`,`Rotura`,\n             `PlanoHod`,Hodge,`UsuarioS`)\n VALUES ('" + this.xPartograma + "','" + this.xmt.formatoAMD.format(this.txtFecha.getDate()) + "','" + this.JTFFHora.getText() + "','" + Integer.valueOf(this.JTFFDilatacion.getText()) + "','" + this.xIdPosM[this.JCBPosMat.getSelectedIndex()] + "','" + this.JTFFPSentadoS.getText() + "/" + this.JTFFPSentadoD.getText() + "','" + this.JTFFPulsoMaterno.getText() + "','" + this.JTFFFrecCardiacaFet.getText() + "','" + this.JTFFDurContraccion.getText() + "',\n        '" + this.JTFFFrecContraccion.getText() + "','" + this.JCBIntensidad.getSelectedItem() + "','" + this.JCBLocalizacion.getSelectedItem() + "','" + this.JTFFBorrami.getText() + "','" + this.JTAObservacion.getText() + "','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "','" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "','" + this.JCBRotura.getSelectedItem() + "',\n        '" + this.xHodge + "','" + this.JCBPlanoHodge.getSelectedItem() + "','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "')";
        this.xct.ejecutarSQL(sql2);
        this.xct.cerrarConexionBd();
    }

    private void mGuardarDetalleExFis() {
        String sql2 = "INSERT INTO  `h_partograma_detalle_exf`             ( `IdAtencion`,`FechaR`,`Hora`,`Dilatacion`,`PosMaterna`,`TArterial`,`PulsoMat`,`FreCardFetal`,`DurContraccion`,              `FreContraccion`,`Intensidad`,`Localizacion`,`Borramiento`,`Observacion`,`IdProfesional`,`IdEspecialidad`, `UsuarioS`)  VALUES ('" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "','" + this.xmt.formatoAMD.format(this.txtFechaEF.getDate()) + "','" + this.JTFFHoraEF.getText() + "','" + Integer.valueOf(this.JTFFDilatacionEF.getText()) + "','" + this.xIdPosMEf[this.JCBPosMatEF.getSelectedIndex()] + "','" + this.JTFFPSentadoSEF.getText() + "/" + this.JTFFPSentadoDEF.getText() + "','" + this.JTFFPulsoMaternoEF.getText() + "','" + this.JTFFFrecCardiacaFetEF.getText() + "','" + this.JTFFDurContraccionEF.getText() + "',         '" + this.JTFFFrecContraccionEF.getText() + "','" + this.JCBIntensidadEF.getSelectedItem() + "','" + this.JCBLocalizacionEF.getSelectedItem() + "','" + this.JTFFBorramiEF.getText() + "','" + this.JTAObservacionEF.getText() + "','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "','" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "')";
        this.xct.ejecutarSQL(sql2);
        this.xct.cerrarConexionBd();
    }

    private boolean mVerifcaFecha(String xFechaF) {
        boolean x = false;
        if (this.JTBHistorico.getRowCount() > 0) {
            int i = 0;
            while (true) {
                if (i >= this.JTBHistorico.getRowCount()) {
                    break;
                }
                String sql = "SELECT IF(DATE_FORMAT('" + this.xmodelo.getValueAt(i, 1).toString() + " " + this.xmodelo.getValueAt(i, 2).toString() + "','%Y/%m/%d %H:%i:%s') > '" + xFechaF + "',1,0) AS maxFecha";
                ConsultasMySQL xct = new ConsultasMySQL();
                ResultSet xrs = xct.traerRs(sql);
                try {
                    if (xrs.next()) {
                        xrs.first();
                        if (xrs.getInt(1) == 1) {
                            x = true;
                            break;
                        }
                        x = false;
                    }
                    xrs.close();
                    xct.cerrarConexionBd();
                } catch (SQLException ex) {
                    Logger.getLogger(JPPartograma.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                }
                i++;
            }
        }
        return x;
    }

    private boolean mVerificaRotura() {
        boolean x = false;
        if ((this.ROTA_MULT.isSelected() || this.ROTA_NULIP.isSelected()) && !this.xMembrana.equals("REM") && !this.xMembrana.equals("RAM") && this.JCBRotura.getSelectedIndex() == 0) {
            x = true;
        }
        return x;
    }

    private boolean mVerificaDilatacion(int xDil) {
        boolean x = false;
        if (this.JTBHistorico.getRowCount() > 0) {
            int i = 0;
            while (true) {
                if (i >= this.JTBHistorico.getRowCount()) {
                    break;
                }
                if (Integer.valueOf(this.xmodelo.getValueAt(i, 3).toString()).intValue() <= xDil) {
                    i++;
                } else {
                    x = true;
                    break;
                }
            }
        }
        return x;
    }

    private boolean mVerificaPosicionCraneo() {
        boolean x = false;
        if (this.jchombobox.getSelectedIndex() > 0) {
            if (this.JCBPlanoHodge.getSelectedIndex() == 0) {
                x = true;
            } else {
                x = false;
            }
        }
        return x;
    }

    private void mGuardarGrafica(JPanel xpanel, long xidGrafica, String xCampo) {
        this.xmt.traerImagenGraficaPartograma(xpanel, xidGrafica);
        try {
            this.xmt.guardarGraficaBlobPartograma(xidGrafica, xCampo);
        } catch (SQLException ex) {
            Logger.getLogger(JPGraficasPyP.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mNuevo() {
        if (this.jTabbedPane1.getSelectedIndex() == 0) {
            this.JTFFDilatacion.setValue(0);
            this.JTFFPulsoMaterno.setValue(0);
            this.JTFFFrecCardiacaFet.setValue(0);
            this.JTFFDurContraccion.setValue(0);
            this.JTFFFrecContraccion.setValue(0);
            this.JTFFBorrami.setValue(0);
            this.JCBPosMat.setSelectedIndex(-1);
            this.txtFecha.setDate(this.xmt.getFechaActual());
            this.JTFFHora.setText(this.xmt.formatoH24.format(this.xmt.getFechaActual()));
            this.JCBIntensidad.setSelectedIndex(0);
            this.JCBLocalizacion.setSelectedIndex(0);
            this.JTAObservacion.setText("");
            this.JTFFPSentadoS.setValue(0);
            this.JTFFPSentadoD.setValue(0);
            this.jchombobox.setSelectedIndex(0);
            this.JCBPlanoHodge.setSelectedIndex(0);
            this.JCBRotura.setSelectedIndex(0);
            return;
        }
        if (this.jTabbedPane1.getSelectedIndex() == 2) {
            this.JTFFDilatacionEF.setValue(0);
            this.JTFFPulsoMaternoEF.setValue(0);
            this.JTFFFrecCardiacaFetEF.setValue(0);
            this.JTFFDurContraccionEF.setValue(0);
            this.JTFFFrecContraccionEF.setValue(0);
            this.JTFFBorramiEF.setValue(0);
            this.JCBPosMatEF.setSelectedIndex(-1);
            this.txtFechaEF.setDate(this.xmt.getFechaActual());
            this.JTFFHoraEF.setText(this.xmt.formatoH24.format(this.xmt.getFechaActual()));
            this.JCBIntensidadEF.setSelectedIndex(0);
            this.JCBLocalizacionEF.setSelectedIndex(0);
            this.JTAObservacionEF.setText("");
            this.JTFFPSentadoSEF.setValue(0);
            this.JTFFPSentadoDEF.setValue(0);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCreaModelo() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Fecha", "Hora", "Dilatación", "Pos. Materna", "T. Arterial", "Pulso Materno", "Frec.Card. Fetal", "Duración Contracción", "Frec. Contracción", "Dolor", "Borramiento", "Rotura", "Pos. Craneo", "Hodge", "Observación"}) { // from class: Historia.JPPartograma.17
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBHistorico.setModel(this.xmodelo);
        this.JTBHistorico.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTBHistorico.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTBHistorico.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTBHistorico.getColumnModel().getColumn(1).setPreferredWidth(75);
        this.JTBHistorico.getColumnModel().getColumn(2).setPreferredWidth(50);
        this.JTBHistorico.getColumnModel().getColumn(3).setPreferredWidth(50);
        this.JTBHistorico.getColumnModel().getColumn(4).setPreferredWidth(50);
        this.JTBHistorico.getColumnModel().getColumn(5).setPreferredWidth(50);
        this.JTBHistorico.getColumnModel().getColumn(6).setPreferredWidth(50);
        this.JTBHistorico.getColumnModel().getColumn(7).setPreferredWidth(50);
        this.JTBHistorico.getColumnModel().getColumn(8).setPreferredWidth(50);
        this.JTBHistorico.getColumnModel().getColumn(9).setPreferredWidth(50);
        this.JTBHistorico.getColumnModel().getColumn(10).setPreferredWidth(50);
        this.JTBHistorico.getColumnModel().getColumn(11).setPreferredWidth(50);
        this.JTBHistorico.getColumnModel().getColumn(12).setPreferredWidth(50);
        this.JTBHistorico.getColumnModel().getColumn(13).setPreferredWidth(50);
        this.JTBHistorico.getColumnModel().getColumn(14).setPreferredWidth(50);
        this.JTBHistorico.getColumnModel().getColumn(15).setPreferredWidth(50);
    }

    private void mBuscarEF() {
        String sql = "SELECT  `h_partograma_detalle_exf`.`Id`,  `h_partograma_detalle_exf`.`FechaR`,  `h_partograma_detalle_exf`.`Hora`,  `h_partograma_detalle_exf`.`Dilatacion`  , `g_pos_materna`.`Nombre` AS PosMaterna ,  `h_partograma_detalle_exf`.`TArterial`,  `h_partograma_detalle_exf`.`PulsoMat`,  `h_partograma_detalle_exf`.`FreCardFetal`  ,  `h_partograma_detalle_exf`.`DurContraccion` ,  `h_partograma_detalle_exf`.`FreContraccion`, CONCAT('Intensidad: ', `h_partograma_detalle_exf`.`Intensidad`,' Localización: ', `h_partograma_detalle_exf`.`Localizacion`) AS Dolor   ,  `h_partograma_detalle_exf`.`Borramiento`,`h_partograma_detalle_exf`.`Observacion`  FROM  `h_partograma_detalle_exf` INNER JOIN  `g_pos_materna`   ON ( `h_partograma_detalle_exf`.`PosMaterna` = `g_pos_materna`.`Id`)  WHERE (`h_partograma_detalle_exf`.`IdAtencion` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "' AND h_partograma_detalle_exf.`Estado`=1)  ORDER BY  `h_partograma_detalle_exf`.`Id` ASC ";
        mCreaModeloEF();
        ResultSet xrs = this.xct.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodeloEF.addRow(this.xdatos);
                    this.xmodeloEF.setValueAt(xrs.getString(1), n, 0);
                    this.xmodeloEF.setValueAt(xrs.getString(2), n, 1);
                    this.xmodeloEF.setValueAt(xrs.getString(3), n, 2);
                    this.xmodeloEF.setValueAt(xrs.getString(4), n, 3);
                    this.xmodeloEF.setValueAt(xrs.getString(5), n, 4);
                    this.xmodeloEF.setValueAt(xrs.getString(6), n, 5);
                    this.xmodeloEF.setValueAt(xrs.getString(7), n, 6);
                    this.xmodeloEF.setValueAt(xrs.getString(8), n, 7);
                    this.xmodeloEF.setValueAt(xrs.getString(9), n, 8);
                    this.xmodeloEF.setValueAt(xrs.getString(10), n, 9);
                    this.xmodeloEF.setValueAt(xrs.getString(11), n, 10);
                    this.xmodeloEF.setValueAt(xrs.getString(12), n, 11);
                    this.xmodeloEF.setValueAt(xrs.getString(13), n, 12);
                    n++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPPartograma.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCreaModeloEF() {
        this.xmodeloEF = new DefaultTableModel(new Object[0], new String[]{"Id", "Fecha", "Hora", "Dilatación", "Pos. Materna", "T. Arterial", "Pulso Materno", "Frec.Card. Fetal", "Duración Contracción", "Frec. Contracción", "Dolor", "Borramiento", "Observación"}) { // from class: Historia.JPPartograma.18
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBHistoricoEF.setModel(this.xmodeloEF);
        this.JTBHistoricoEF.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTBHistoricoEF.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTBHistoricoEF.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTBHistoricoEF.getColumnModel().getColumn(1).setPreferredWidth(75);
        this.JTBHistoricoEF.getColumnModel().getColumn(2).setPreferredWidth(50);
        this.JTBHistoricoEF.getColumnModel().getColumn(3).setPreferredWidth(50);
        this.JTBHistoricoEF.getColumnModel().getColumn(4).setPreferredWidth(50);
        this.JTBHistoricoEF.getColumnModel().getColumn(5).setPreferredWidth(50);
        this.JTBHistoricoEF.getColumnModel().getColumn(6).setPreferredWidth(50);
        this.JTBHistoricoEF.getColumnModel().getColumn(7).setPreferredWidth(50);
        this.JTBHistoricoEF.getColumnModel().getColumn(8).setPreferredWidth(50);
        this.JTBHistoricoEF.getColumnModel().getColumn(9).setPreferredWidth(50);
        this.JTBHistoricoEF.getColumnModel().getColumn(10).setPreferredWidth(50);
        this.JTBHistoricoEF.getColumnModel().getColumn(11).setPreferredWidth(50);
        this.JTBHistoricoEF.getColumnModel().getColumn(12).setPreferredWidth(50);
    }

    public void mImprimir() {
        String[][] mparametros = new String[3][2];
        mparametros[0][0] = "idatencion1";
        mparametros[0][1] = clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion();
        mparametros[1][0] = "SUBREPORT_DIR";
        mparametros[1][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
        mparametros[2][0] = "SUBREPORTFIRMA_DIR";
        mparametros[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
        if (Principal.informacionIps.getEsFpz().intValue() == 1) {
            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "H_PartogramaEncabezado", mparametros);
        } else {
            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "H_PartogramaEncabezado", mparametros);
        }
    }

    private void mBuscar() {
        String sql = "SELECT h_partograma.Id AS IdPartograma , h_partograma.GRef1 , h_partograma.GRef2,     `h_partograma_detalle`.`Id`, `h_partograma_detalle`.`FechaR`, `h_partograma_detalle`.`Hora`, `h_partograma_detalle`.`Dilatacion`\n    , `g_pos_materna`.`Nombre` AS PosMaterna , `h_partograma_detalle`.`TArterial`, `h_partograma_detalle`.`PulsoMat`, `h_partograma_detalle`.`FreCardFetal`\n    , `h_partograma_detalle`.`DurContraccion` , `h_partograma_detalle`.`FreContraccion`, CONCAT('Intensidad: ',`h_partograma_detalle`.`Intensidad`,' Localización: ',`h_partograma_detalle`.`Localizacion`) AS Dolor\n    , `h_partograma_detalle`.`Borramiento`,`h_partograma_detalle`.`Rotura`,`h_partograma_detalle`.`PlanoHod`, h_partograma_detalle.Hodge, `h_partograma_detalle`.`Observacion`\n FROM `h_partograma_detalle` INNER JOIN  `g_pos_materna`   ON (`h_partograma_detalle`.`PosMaterna` = `g_pos_materna`.`Id`)\n INNER JOIN  h_partograma  ON  (h_partograma_detalle.`IdPartograma`= h_partograma.`Id`)\n WHERE (`h_partograma`.`IdAtencion` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "' AND h_partograma.`Estado`=1)\n ORDER BY `h_partograma_detalle`.`Id` ASC ";
        mCreaModelo();
        ResultSet xrs = this.xct.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.first();
                this.xPartograma = xrs.getString("IdPartograma");
                if (xrs.getString("GRef1").equals("INT_VERT")) {
                    this.INT_VERT.setSelected(true);
                    this.INT_VERT.setEnabled(false);
                    this.INT_MULT.setEnabled(false);
                    this.ROTA_MULT.setEnabled(false);
                    this.INT_NULIP.setEnabled(false);
                    this.ROTA_NULIP.setEnabled(false);
                    this.xTipoFrafica = "INT_VERT";
                    this.JlBorde1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/borde_rojo.png")));
                } else if (xrs.getString("GRef1").equals("INT_MULT")) {
                    this.INT_MULT.setSelected(true);
                    this.INT_MULT.setEnabled(false);
                    this.xTipoFrafica = "INT_MULT";
                    this.INT_NULIP.setEnabled(false);
                    this.ROTA_NULIP.setEnabled(false);
                    this.JlBorde2.setIcon(new ImageIcon(getClass().getResource("/Imagenes/borde_rojo.png")));
                } else if (xrs.getString("GRef1").equals("ROTA_MULT")) {
                    this.ROTA_MULT.setSelected(true);
                    this.ROTA_MULT.setEnabled(false);
                    this.INT_MULT.setEnabled(false);
                    this.xTipoFrafica = "ROTA_MULT";
                    this.INT_NULIP.setEnabled(false);
                    this.ROTA_NULIP.setEnabled(false);
                    this.JlBorde3.setIcon(new ImageIcon(getClass().getResource("/Imagenes/borde_purpura.png")));
                } else if (xrs.getString("GRef1").equals("INT_NULIP")) {
                    this.INT_NULIP.setSelected(true);
                    this.INT_NULIP.setEnabled(false);
                    this.xTipoFrafica = "INT_NULIP";
                    this.JlBorde4.setIcon(new ImageIcon(getClass().getResource("/Imagenes/borde_rojo.png")));
                    this.INT_MULT.setEnabled(false);
                    this.ROTA_MULT.setEnabled(false);
                } else if (xrs.getString("GRef1").equals("ROTA_NULIP")) {
                    this.ROTA_NULIP.setSelected(true);
                    this.ROTA_NULIP.setEnabled(false);
                    this.INT_NULIP.setEnabled(false);
                    this.xTipoFrafica = "ROTA_NULIP";
                    this.INT_MULT.setEnabled(false);
                    this.ROTA_MULT.setEnabled(false);
                    this.JlBorde5.setIcon(new ImageIcon(getClass().getResource("/Imagenes/borde_purpura.png")));
                }
                if (xrs.getString("GRef2").equals("INT_VERT")) {
                    this.INT_VERT.setSelected(true);
                } else if (xrs.getString("GRef2").equals("ROTA_MULT")) {
                    this.ROTA_MULT.setSelected(true);
                    this.ROTA_MULT.setEnabled(false);
                    this.xTipoGrafica2 = "ROTA_MULT";
                    this.JlBorde3.setIcon(new ImageIcon(getClass().getResource("/Imagenes/borde_purpura.png")));
                    this.INT_MULT.setEnabled(false);
                } else if (xrs.getString("GRef2").equals("ROTA_NULIP")) {
                    this.ROTA_NULIP.setSelected(true);
                    this.ROTA_NULIP.setEnabled(false);
                    this.xTipoGrafica2 = "ROTA_NULIP";
                    this.JlBorde5.setIcon(new ImageIcon(getClass().getResource("/Imagenes/borde_purpura.png")));
                    this.INT_NULIP.setEnabled(false);
                }
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(xrs.getString(4), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(5), n, 1);
                    this.xmodelo.setValueAt(xrs.getString(6), n, 2);
                    this.xmodelo.setValueAt(xrs.getString(7), n, 3);
                    this.xmodelo.setValueAt(xrs.getString(8), n, 4);
                    this.xmodelo.setValueAt(xrs.getString(9), n, 5);
                    this.xmodelo.setValueAt(xrs.getString(10), n, 6);
                    this.xmodelo.setValueAt(xrs.getString(11), n, 7);
                    this.xmodelo.setValueAt(xrs.getString(12), n, 8);
                    this.xmodelo.setValueAt(xrs.getString(13), n, 9);
                    this.xmodelo.setValueAt(xrs.getString(14), n, 10);
                    this.xmodelo.setValueAt(xrs.getString(15), n, 11);
                    this.xmodelo.setValueAt(xrs.getString(16), n, 12);
                    if (xrs.getString(16).equals("REM") || xrs.getString(16).equals("RAM")) {
                        this.xMembrana = xrs.getString(16);
                    }
                    this.xmodelo.setValueAt(xrs.getString(17), n, 13);
                    this.xmodelo.setValueAt(xrs.getString(18), n, 14);
                    this.xmodelo.setValueAt(xrs.getString(19), n, 15);
                    n++;
                }
                this.xmt.cambiarEstadoValidadoItemHC(getName(), 1, true);
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPPartograma.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:Historia/JPPartograma$ImagenPartograma.class */
    public class ImagenPartograma extends JPanel {
        private int[][] xCoordenada;
        private JPPartograma xJPPartograma;
        private String xTipoGrafica;
        private int tipo;
        private boolean xRotura;
        private ConsultasMySQL xct = new ConsultasMySQL();
        private Vector xValorRefX = new Vector();
        private Vector xValorRefY = new Vector();
        double xValor = 0.0d;

        public ImagenPartograma(JPPartograma xJPPartograma, String xTipoGrafica, int tipo, boolean xRotura) {
            setSize(750, 524);
            this.xJPPartograma = xJPPartograma;
            this.xTipoGrafica = xTipoGrafica;
            this.xRotura = xRotura;
            if (tipo == 0) {
                if (!xTipoGrafica.equals("")) {
                    mValoresRef(xTipoGrafica);
                }
            } else {
                mGraficaDilatacion();
            }
            this.tipo = tipo;
        }

        private void mValoresRef(String xTipoGrafica) {
            double VectY = 0.0d;
            int i = 0;
            while (true) {
                if (i >= this.xJPPartograma.JTBHistorico.getRowCount()) {
                    break;
                }
                if (this.xRotura) {
                    if (this.xJPPartograma.JTBHistorico.getValueAt(i, 12).equals("REM") || this.xJPPartograma.JTBHistorico.getValueAt(i, 12).equals("RAM")) {
                        break;
                    } else {
                        i++;
                    }
                } else {
                    VectY = Integer.valueOf(this.xJPPartograma.JTBHistorico.getValueAt(i, 3).toString()).intValue() >= 5 ? Double.valueOf(this.xJPPartograma.JTBHistorico.getValueAt(i, 3).toString()).doubleValue() : this.xJPPartograma.xCoordIntercesion[1];
                }
            }
            VectY = Double.valueOf(this.xJPPartograma.JTBHistorico.getValueAt(i, 3).toString()).doubleValue();
            this.xValorRefX.addElement(Double.valueOf(mPuntoRotura(this.xJPPartograma.xmodelo.getValueAt(i, 1).toString() + " " + this.xJPPartograma.xmodelo.getValueAt(i, 2).toString())));
            if (VectY >= 4.5d) {
                try {
                    String sql = "SELECT Coordenada, Minutos AS Cant_Minutos FROM  `p_tabla_partograma` WHERE (Tipo ='" + xTipoGrafica + "' AND Limite>='" + VectY + "' )  ORDER BY Coordenada ASC";
                    ConsultasMySQL xct = new ConsultasMySQL();
                    ResultSet xrs = xct.traerRs(sql);
                    if (xrs.next()) {
                        if (this.xJPPartograma.xInterseccion) {
                            if (!this.xRotura) {
                                this.xValorRefX.addElement(Double.valueOf(this.xJPPartograma.xCoordIntercesion[0]));
                                this.xValorRefY.addElement(Double.valueOf(this.xJPPartograma.xCoordIntercesion[1]));
                            }
                        } else if (!this.xRotura) {
                            this.xValorRefX.addElement(0);
                        }
                        xrs.beforeFirst();
                        int xtipo = 1;
                        while (xrs.next()) {
                            this.xValorRefX.addElement(Double.valueOf(mCoordenadaX(xrs.getDouble("Cant_Minutos"), xtipo)));
                            xtipo = 0;
                        }
                        if (this.xValorRefX != null) {
                            int x = 0;
                            int y = 0;
                            this.xCoordenada = new int[this.xValorRefX.size()][2];
                            for (int j = 0; j < this.xValorRefX.size(); j++) {
                                String sql2 = "SELECT ROUND(((((ValorPXSup-ValorPXinf)/60)*('" + Double.valueOf(this.xValorRefX.elementAt(j).toString()) + "'-RangoInf))+ValorPXinf)) AS Coordenada_X FROM p_tabla_referencia WHERE (`Eje` ='x'  AND `IdTipoGrafica` ='26'  AND '" + Double.valueOf(this.xValorRefX.elementAt(j).toString()) + "'>=`RangoInf`  AND '" + Double.valueOf(this.xValorRefX.elementAt(j).toString()) + "'<`RangoSUp` );";
                                ResultSet xrs2 = this.xct.traerRs(sql2);
                                try {
                                    if (xrs2.next()) {
                                        xrs2.last();
                                        xrs2.beforeFirst();
                                        while (xrs2.next()) {
                                            this.xCoordenada[x][0] = xrs2.getInt("Coordenada_X");
                                            x++;
                                        }
                                    }
                                    xrs2.close();
                                    this.xct.cerrarConexionBd();
                                } catch (SQLException ex) {
                                    Logger.getLogger(JPAExamenFisicoPrenatal.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                                }
                                double xLimiteY = Math.round(VectY);
                                if (this.xJPPartograma.xInterseccion && !this.xRotura) {
                                    xLimiteY = Math.round(VectY) + 1;
                                }
                                for (double i2 = xLimiteY; i2 <= 11.0d; i2 += 1.0d) {
                                    this.xValorRefY.addElement(Double.valueOf(i2));
                                }
                                String sql22 = "SELECT `RangoInf` , `RangoSUp`  , `ValorPXinf` , `ValorPXSup`  ,(RangoSUp-RangoInf) AS CantidadNo  ,(ValorPXSup-ValorPXinf)*(-1) AS CantPX  ,ROUND(((ValorPXSup-ValorPXinf)/(RangoSUp-RangoInf)))*(-1) AS CM_en_PX  , ('" + Double.valueOf(this.xValorRefY.elementAt(j).toString()) + "'-RangoInf) AS Diferencia  , (('" + Double.valueOf(this.xValorRefY.elementAt(j).toString()) + "'-RangoInf)*(ROUND(((ValorPXSup-ValorPXinf)/(RangoSUp-RangoInf)))))*(-1) AS CM_en_Px_Graf  , (ValorPXinf+(('" + Double.valueOf(this.xValorRefY.elementAt(j).toString()) + "'-RangoInf)*(ROUND(((ValorPXSup-ValorPXinf)/(RangoSUp-RangoInf)))))) AS Coordenada_Y  FROM `p_tabla_referencia` WHERE (`Eje` ='y'  AND `IdTipoGrafica` =26  AND '" + Double.valueOf(this.xValorRefY.elementAt(j).toString()) + "'>=`RangoInf`  AND '" + Double.valueOf(this.xValorRefY.elementAt(j).toString()) + "'<`RangoSUp`);";
                                ResultSet xrs3 = this.xct.traerRs(sql22);
                                try {
                                    if (xrs3.next()) {
                                        xrs3.beforeFirst();
                                        while (xrs3.next()) {
                                            this.xCoordenada[y][1] = xrs3.getInt("Coordenada_Y");
                                            y++;
                                        }
                                    }
                                    xrs3.close();
                                    this.xct.cerrarConexionBd();
                                } catch (SQLException ex2) {
                                    Logger.getLogger(JPAExamenFisicoPrenatal.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex2);
                                }
                            }
                        }
                    }
                    xrs.close();
                    xct.cerrarConexionBd();
                } catch (SQLException ex3) {
                    Logger.getLogger(JPPartograma.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex3);
                }
            }
        }

        private void mGraficaDilatacion() {
            if (this.xJPPartograma.JTBHistorico.getRowCount() > 0) {
                for (int i = 0; i < this.xJPPartograma.JTBHistorico.getRowCount(); i++) {
                    String sql = "SELECT TIMESTAMPDIFF(MINUTE,'" + this.xJPPartograma.xHoraCero + "','" + this.xJPPartograma.xmodelo.getValueAt(i, 1).toString() + " " + this.xJPPartograma.xmodelo.getValueAt(i, 2).toString() + "') AS Minutos;";
                    ResultSet xrmin = this.xct.traerRs(sql);
                    try {
                        if (xrmin.next()) {
                            xrmin.first();
                            this.xValorRefX.addElement(xrmin.getString("Minutos"));
                        }
                        xrmin.close();
                        this.xct.cerrarConexionBd();
                    } catch (SQLException ex) {
                        Logger.getLogger(JPPartograma.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                    }
                    this.xValorRefY.addElement(this.xJPPartograma.xmodelo.getValueAt(i, 3).toString());
                    if (!this.xJPPartograma.xmodelo.getValueAt(i, 13).toString().equals("")) {
                        mViewHodge(Double.valueOf(this.xValorRefX.elementAt(i).toString()).doubleValue(), this.xJPPartograma.xmodelo.getValueAt(i, 13).toString(), this.xJPPartograma.xmodelo.getValueAt(i, 14).toString());
                    }
                    if (Integer.valueOf(this.xJPPartograma.xmodelo.getValueAt(i, 3).toString()).intValue() == 4 && this.xJPPartograma.JTBHistorico.getRowCount() > 1 && Integer.valueOf(this.xJPPartograma.xmodelo.getValueAt(this.xJPPartograma.JTBHistorico.getRowCount() - 1, 3).toString()).intValue() >= 5) {
                        this.xJPPartograma.xInterseccion = true;
                        this.xJPPartograma.xCoorRecta[0] = Double.parseDouble(this.xValorRefX.elementAt(i).toString());
                        this.xJPPartograma.xCoorRecta[1] = Double.parseDouble(this.xJPPartograma.xmodelo.getValueAt(i, 3).toString());
                        this.xJPPartograma.xCoorRecta[2] = getMinutos(i + 1);
                        this.xJPPartograma.xCoorRecta[3] = Double.parseDouble(this.xJPPartograma.xmodelo.getValueAt(i + 1, 3).toString());
                        Line2D.Double linea1 = new Line2D.Double(this.xJPPartograma.xCoorRecta[0], this.xJPPartograma.xCoorRecta[1], this.xJPPartograma.xCoorRecta[2], this.xJPPartograma.xCoorRecta[3]);
                        Line2D.Double linea2 = new Line2D.Double(0.0d, 4.5d, 900.0d, 4.5d);
                        getIntersection(linea1, linea2);
                    }
                }
            }
            if (this.xValorRefX != null) {
                int x = 0;
                int y = 0;
                this.xCoordenada = new int[this.xValorRefX.size()][2];
                for (int j = 0; j < this.xValorRefX.size(); j++) {
                    String sql2 = "SELECT ROUND(((((ValorPXSup-ValorPXinf)/60)*('" + Double.valueOf(this.xValorRefX.elementAt(j).toString()) + "'-RangoInf))+ValorPXinf)) AS Coordenada_X FROM p_tabla_referencia WHERE (`Eje` ='x'  AND `IdTipoGrafica` ='26'  AND '" + Double.valueOf(this.xValorRefX.elementAt(j).toString()) + "'>=`RangoInf`  AND '" + Double.valueOf(this.xValorRefX.elementAt(j).toString()) + "'<`RangoSUp` );";
                    ResultSet xrs2 = this.xct.traerRs(sql2);
                    try {
                        if (xrs2.next()) {
                            xrs2.last();
                            xrs2.beforeFirst();
                            while (xrs2.next()) {
                                this.xCoordenada[x][0] = xrs2.getInt("Coordenada_X");
                                x++;
                            }
                        }
                        xrs2.close();
                        this.xct.cerrarConexionBd();
                    } catch (SQLException ex2) {
                        Logger.getLogger(JPAExamenFisicoPrenatal.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex2);
                    }
                    String sql22 = "SELECT `RangoInf` , `RangoSUp`  , `ValorPXinf` , `ValorPXSup`  ,(RangoSUp-RangoInf) AS CantidadNo  ,(ValorPXSup-ValorPXinf)*(-1) AS CantPX  ,ROUND(((ValorPXSup-ValorPXinf)/(RangoSUp-RangoInf)))*(-1) AS CM_en_PX  , ('" + Double.valueOf(this.xValorRefY.elementAt(j).toString()) + "'-RangoInf) AS Diferencia  , (('" + Double.valueOf(this.xValorRefY.elementAt(j).toString()) + "'-RangoInf)*(ROUND(((ValorPXSup-ValorPXinf)/(RangoSUp-RangoInf)))))*(-1) AS CM_en_Px_Graf  , (ValorPXinf+(('" + Double.valueOf(this.xValorRefY.elementAt(j).toString()) + "'-RangoInf)*(ROUND(((ValorPXSup-ValorPXinf)/(RangoSUp-RangoInf)))))) AS Coordenada_Y  FROM `p_tabla_referencia` WHERE (`Eje` ='y'  AND `IdTipoGrafica` =26  AND '" + Double.valueOf(this.xValorRefY.elementAt(j).toString()) + "'>=`RangoInf`  AND '" + Double.valueOf(this.xValorRefY.elementAt(j).toString()) + "'<`RangoSUp`);";
                    ResultSet xrs3 = this.xct.traerRs(sql22);
                    try {
                        if (xrs3.next()) {
                            xrs3.beforeFirst();
                            while (xrs3.next()) {
                                this.xCoordenada[y][1] = xrs3.getInt("Coordenada_Y");
                                y++;
                            }
                        }
                        xrs3.close();
                        this.xct.cerrarConexionBd();
                    } catch (SQLException ex3) {
                        Logger.getLogger(JPAExamenFisicoPrenatal.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex3);
                    }
                }
            }
        }

        public void paint(Graphics grafico) {
            Graphics2D g2 = (Graphics2D) grafico;
            getSize();
            float[] guiones = {6.0f};
            if (this.xCoordenada != null) {
                for (int i = 0; i < this.xCoordenada.length; i++) {
                    try {
                        if (i != 0) {
                            if (this.tipo == 0) {
                                if (this.xTipoGrafica.equals("INT_VERT") || this.xTipoGrafica.equals("INT_MULT") || this.xTipoGrafica.equals("INT_NULIP")) {
                                    grafico.setColor(Color.red);
                                } else {
                                    grafico.setColor(new Color(102, 15, 130));
                                }
                                g2.setStroke(new BasicStroke(2.0f, 1, 1, 6.0f, guiones, 0.0f));
                            } else {
                                grafico.setColor(new Color(0, 168, 107));
                                g2.setStroke(new BasicStroke(3.0f));
                            }
                            g2.draw(new Line2D.Double(this.xCoordenada[i - 1][0], this.xCoordenada[i - 1][1], this.xCoordenada[i][0], this.xCoordenada[i][1]));
                        }
                        dibuja_coordenada(g2, this.xCoordenada[i][0], this.xCoordenada[i][1]);
                    } catch (ArrayIndexOutOfBoundsException e) {
                    }
                }
                setOpaque(false);
                super.paintComponent(grafico);
            }
        }

        private void dibuja_coordenada(Graphics2D g2, double x, double y) {
            NumberFormat mf = NumberFormat.getInstance();
            mf.setMaximumFractionDigits(2);
            g2.setColor(new Color(0, 0, 255));
            g2.setStroke(new BasicStroke(7.5f));
            g2.draw(new Line2D.Double(x, y, x, y));
        }

        private double mCoordenadaX(double x, int tipo) {
            if (tipo == 1) {
                if (this.xRotura) {
                    x += Double.valueOf(this.xValorRefX.elementAt(0).toString()).doubleValue();
                } else {
                    x += this.xJPPartograma.xCoordIntercesion[0];
                }
            }
            double d = this.xValor + x;
            this.xValor = d;
            return d;
        }

        private double getMinutos(int xFila) {
            double valor = 0.0d;
            String sql = "SELECT TIMESTAMPDIFF(MINUTE,'" + this.xJPPartograma.xHoraCero + "','" + this.xJPPartograma.xmodelo.getValueAt(xFila, 1).toString() + " " + this.xJPPartograma.xmodelo.getValueAt(xFila, 2).toString() + "') AS Minutos;";
            ConsultasMySQL xctl = new ConsultasMySQL();
            ResultSet xrmin = xctl.traerRs(sql);
            try {
                if (xrmin.next()) {
                    xrmin.first();
                    valor = xrmin.getDouble("Minutos");
                }
                xrmin.close();
                xctl.cerrarConexionBd();
            } catch (SQLException ex) {
                Logger.getLogger(JPPartograma.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
            return valor;
        }

        public Point2D getIntersection(Line2D.Double line1, Line2D.Double line2) {
            double x1 = line1.x1;
            double y1 = line1.y1;
            double x2 = line1.x2;
            double y2 = line1.y2;
            double x3 = line2.x1;
            double y3 = line2.y1;
            double x4 = line2.x2;
            double y4 = line2.y2;
            double x = (((x2 - x1) * ((x3 * y4) - (x4 * y3))) - ((x4 - x3) * ((x1 * y2) - (x2 * y1)))) / (((x1 - x2) * (y3 - y4)) - ((y1 - y2) * (x3 - x4)));
            double y = (((y3 - y4) * ((x1 * y2) - (x2 * y1))) - ((y1 - y2) * ((x3 * y4) - (x4 * y3)))) / (((x1 - x2) * (y3 - y4)) - ((y1 - y2) * (x3 - x4)));
            this.xJPPartograma.xCoordIntercesion[0] = x;
            this.xJPPartograma.xCoordIntercesion[1] = y;
            return new Point2D.Double(x, y);
        }

        private void mViewHodge(double x, String xImagen, String xTipo) {
            String sql2 = "SELECT ROUND(((((ValorPXSup-ValorPXinf)/60)*('" + x + "'-RangoInf))+ValorPXinf)) AS Coordenada_X FROM p_tabla_referencia WHERE (`Eje` ='x'  AND `IdTipoGrafica` ='26'  AND '" + x + "'>=`RangoInf`  AND '" + x + "'<`RangoSUp` );";
            int xEjey = 0;
            if (xTipo.equals("I")) {
                xEjey = 45;
            } else if (xTipo.equals("II")) {
                xEjey = 183;
            } else if (xTipo.equals("III")) {
                xEjey = 326;
            } else if (xTipo.equals("IV")) {
                xEjey = 464;
            }
            ConsultasMySQL xct = new ConsultasMySQL();
            ResultSet xrs2 = xct.traerRs(sql2);
            try {
                if (xrs2.next()) {
                    xrs2.first();
                    JLabel h = new JLabel();
                    h.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Hodge/" + xImagen + "-X.png")));
                    h.setSize(25, 25);
                    h.setLocation(xrs2.getInt("Coordenada_X") - 5, xEjey - 12);
                    JPPartograma.this.JPGraficoLineas.add(h);
                    JPPartograma.this.JPGraficoLineas.repaint();
                }
                xrs2.close();
                xct.cerrarConexionBd();
            } catch (SQLException ex) {
                Logger.getLogger(JPAExamenFisicoPrenatal.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }

        private double mPuntoRotura(String x) {
            double xPunto = 0.0d;
            String sql = "SELECT TIMESTAMPDIFF(MINUTE,'" + this.xJPPartograma.xHoraCero + "','" + x + "') AS Minutos;";
            ConsultasMySQL xctr = new ConsultasMySQL();
            ResultSet xrmin = xctr.traerRs(sql);
            try {
                if (xrmin.next()) {
                    xrmin.first();
                    xPunto = xrmin.getDouble("Minutos");
                }
                xrmin.close();
                xctr.cerrarConexionBd();
            } catch (SQLException ex) {
                Logger.getLogger(JPPartograma.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
            return xPunto;
        }
    }
}
