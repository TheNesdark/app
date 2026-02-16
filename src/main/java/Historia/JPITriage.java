package Historia;

import Acceso.Principal;
import General.ClaseImpresionInformes;
import Utilidades.ConsultasMySQL;
import Utilidades.JTextFieldValidator;
import Utilidades.Metodos;
import Utilidades.corrector.jortho.FileUserDictionary;
import Utilidades.corrector.jortho.SpellChecker;
import com.genoma.plus.controller.historia.JPTriageRespiratorio;
import com.genoma.plus.controller.historia.JPTriageRespiratorio_V2;
import com.genoma.plus.dao.facturacion.IngresoOrdenSalidaDAO;
import com.genoma.plus.dao.general.PatologiaCie10DAO;
import com.genoma.plus.dao.impl.facturacion.IngresoOrdenSalidaDAOImpl;
import com.genoma.plus.dao.impl.general.PatologiaCie10DAOImpl;
import com.genoma.plus.dto.facturacion.IngresoOrdenSalidaDTO;
import com.genoma.plus.dto.general.PatologiaCie10DTO;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
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
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DateFormatter;
import javax.swing.text.DefaultFormatterFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:Historia/JPITriage.class */
public class JPITriage extends JPanel {
    private String xsql;
    private DefaultTableModel xmodelo;
    private PatologiaCie10DAO xPatologiaCie10DAO;
    private Object[] xdatos;
    private JPTriageRespiratorio_V2 triageRespiratorio_V2;
    private JPTriageRespiratorio triageRespiratorio;
    private IngresoOrdenSalidaDAO ingresoOrdenSalidaDAO;
    public boolean nTriage;
    private int esCapitado;
    private String[][] xid_pabellon;
    private String[][] xid_cama;
    private JButton JBTGuardarTemp1;
    private JComboBox JCB_APabellon;
    private JCheckBox JCHAplicaTestRespiratorio;
    public JCheckBox JCH_SParto;
    private JCheckBox JCH_SinValidacionSignos;
    private JDateChooser JDCFecha;
    private JLabel JLBPBSentado;
    private JPanel JPDiagnostico1;
    private JPanel JPIClasificacion;
    private JPanel JPIPresion;
    private JPanel JPI_DatosTriage;
    private JPanel JPI_TriageRespiratorio;
    private JPanel JPSignosVitales;
    private JSpinner JSOrden;
    private JScrollPane JSPDiagnostico;
    private JScrollPane JSPMotivoC;
    private JTextArea JTAMotivoC;
    private JTable JTDetalle;
    public JTextField JTFCDxP;
    private JFormattedTextField JTFFHora;
    private JFormattedTextField JTFFPDiastolica;
    private JFormattedTextField JTFFPSistolica;
    public JTextFieldValidator JTFFPs2;
    public JTextFieldValidator JTFFSFc;
    public JTextFieldValidator JTFFSFr;
    public JTextFieldValidator JTFFSIMC;
    public JTextFieldValidator JTFFSPeso;
    public JTextFieldValidator JTFFSTalla;
    public JTextFieldValidator JTFFTemperatura;
    public JTextField JTFNCodigoDxP;
    public JTextField JTFNTriage;
    private JTabbedPane JTPMenu;
    private JTabbedPane JTP_DatosUrgencias;
    private JButton btnAmarillo;
    private JButton btnNaranja;
    private JButton btnNegro;
    private JButton btnRojo;
    private JButton btnVerde;
    private JPanel jPanel2;
    private JTabbedPane jTabbedPane1;
    private int clasificacion = -1;
    private ConsultasMySQL xct = new ConsultasMySQL();
    private Metodos xmt = new Metodos();
    public boolean triageFour = false;
    public boolean triageFive = false;
    public boolean esCapita = false;
    private boolean xlleno = false;

    public JPITriage() {
        initComponents();
        springStart();
        SpellChecker.setUserDictionaryProvider(new FileUserDictionary());
        SpellChecker.registerDictionaries(null, null);
        SpellChecker.register(this.JTAMotivoC);
        this.JDCFecha.setDate(this.xmt.getFechaActual());
        this.JTFFHora.setValue(this.xmt.getFechaActual());
        this.JTFNTriage.setText("0");
        cargarPanelTraigeRespiratorio();
        mCargarTriage();
        mCargarDatosTabla();
        mClasificar_SalaPArto();
        this.JTP_DatosUrgencias.setEnabledAt(1, false);
        if (Principal.informacionIps.getAplicaTestRespiratorio().intValue() == -1) {
            this.JCHAplicaTestRespiratorio.setVisible(false);
            this.JTP_DatosUrgencias.remove(1);
        }
        this.nTriage = (this.JTFNTriage.getText().isEmpty() || this.JTFNTriage.getText() == null || this.JTFNTriage.getText().equals("0")) ? false : true;
        this.esCapitado = 0;
        nuevo();
        verificarConvenioCapitado();
    }

    private void springStart() {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"});
        this.xPatologiaCie10DAO = (PatologiaCie10DAOImpl) classPathXmlApplicationContext.getBean("patologiaCie10DAOImpl");
        this.ingresoOrdenSalidaDAO = (IngresoOrdenSalidaDAOImpl) classPathXmlApplicationContext.getBean("ingresoOrdenSalidaDAO");
    }

    private void nuevo() {
        this.xlleno = false;
        this.JCB_APabellon.removeAllItems();
        this.xsql = "SELECT `f_unidadcama`.`Id`, `f_unidadcama`.`Nbre`, f_unidadcama.EsHosp, `f_unidadcama`.`idTipoAtencion` \nFROM `f_camas` INNER JOIN  `f_unidadcama`  ON (`f_camas`.`Id_UnidadCamas` = `f_unidadcama`.`Id`) \ninner join g_tipoatencion gt on (gt.Id=f_unidadcama.idTipoAtencion)\nWHERE (`f_unidadcama`.`Estado` =1 AND `f_camas`.`Estado` =1 and gt.Id_TipoAmbito=3) \nGROUP BY `f_unidadcama`.`Id` ORDER BY `f_unidadcama`.`Nbre` ASC";
        this.xid_pabellon = this.xct.llenarComboyLista(this.xsql, this.xid_pabellon, this.JCB_APabellon, 4);
        this.JCB_APabellon.setSelectedIndex(-1);
        this.xct.cerrarConexionBd();
        this.xlleno = true;
    }

    /* JADX WARN: Type inference failed for: r3v105, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JTP_DatosUrgencias = new JTabbedPane();
        this.JPI_DatosTriage = new JPanel();
        this.JDCFecha = new JDateChooser();
        this.JTFFHora = new JFormattedTextField();
        this.JPIPresion = new JPanel();
        this.JTFFPSistolica = new JFormattedTextField();
        this.JLBPBSentado = new JLabel();
        this.JTFFPDiastolica = new JFormattedTextField();
        this.JCH_SParto = new JCheckBox();
        this.JPSignosVitales = new JPanel();
        this.JTFFSFc = new JTextFieldValidator();
        this.JTFFSFr = new JTextFieldValidator();
        this.JTFFTemperatura = new JTextFieldValidator();
        this.JTFFPs2 = new JTextFieldValidator();
        this.JTFFSTalla = new JTextFieldValidator();
        this.JTFFSPeso = new JTextFieldValidator();
        this.JTFFSIMC = new JTextFieldValidator();
        this.JTPMenu = new JTabbedPane();
        this.JSPMotivoC = new JScrollPane();
        this.JTAMotivoC = new JTextArea();
        this.JPDiagnostico1 = new JPanel();
        this.JTFCDxP = new JTextField();
        this.JTFNCodigoDxP = new JTextField();
        this.JSPDiagnostico = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JBTGuardarTemp1 = new JButton();
        this.JSOrden = new JSpinner();
        this.JCHAplicaTestRespiratorio = new JCheckBox();
        this.jTabbedPane1 = new JTabbedPane();
        this.JPIClasificacion = new JPanel();
        this.btnNegro = new JButton();
        this.btnVerde = new JButton();
        this.btnAmarillo = new JButton();
        this.btnNaranja = new JButton();
        this.btnRojo = new JButton();
        this.JTFNTriage = new JTextField();
        this.jPanel2 = new JPanel();
        this.JCB_APabellon = new JComboBox();
        this.JCH_SinValidacionSignos = new JCheckBox();
        this.JPI_TriageRespiratorio = new JPanel();
        setBorder(BorderFactory.createTitledBorder((Border) null, "CLASIFICACIÓN TRIAGE", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        setName("xjptriage");
        this.JTP_DatosUrgencias.setForeground(Color.red);
        this.JTP_DatosUrgencias.setFont(new Font("Arial", 1, 14));
        this.JDCFecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFecha.setDateFormatString("dd/MM/yyyy");
        this.JDCFecha.setFont(new Font("Arial", 1, 12));
        this.JTFFHora.setBorder(BorderFactory.createTitledBorder((Border) null, "Hora", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFHora.setFormatterFactory(new DefaultFormatterFactory(new DateFormatter(new SimpleDateFormat("HH:mm:ss"))));
        this.JTFFHora.setHorizontalAlignment(4);
        this.JTFFHora.setFont(new Font("Arial", 1, 12));
        this.JPIPresion.setBorder(BorderFactory.createTitledBorder((Border) null, "Presión Sistólica / Diastólica", 0, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.JTFFPSistolica.setHorizontalAlignment(4);
        this.JTFFPSistolica.setFont(new Font("Arial", 1, 12));
        this.JTFFPSistolica.setName("fechanaciemiento");
        this.JTFFPSistolica.setValue(new Integer(0));
        this.JTFFPSistolica.addActionListener(new ActionListener() { // from class: Historia.JPITriage.1
            public void actionPerformed(ActionEvent evt) {
                JPITriage.this.JTFFPSistolicaActionPerformed(evt);
            }
        });
        this.JTFFPSistolica.addFocusListener(new FocusAdapter() { // from class: Historia.JPITriage.2
            public void focusGained(FocusEvent evt) {
                JPITriage.this.JTFFPSistolicaFocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                JPITriage.this.JTFFPSistolicaFocusLost(evt);
            }
        });
        this.JLBPBSentado.setFont(new Font("Arial", 1, 18));
        this.JLBPBSentado.setForeground(Color.blue);
        this.JLBPBSentado.setHorizontalAlignment(0);
        this.JLBPBSentado.setText("/");
        this.JTFFPDiastolica.setHorizontalAlignment(4);
        this.JTFFPDiastolica.setFont(new Font("Arial", 1, 12));
        this.JTFFPDiastolica.setName("fechanaciemiento");
        this.JTFFPDiastolica.setValue(new Integer(0));
        this.JTFFPDiastolica.addFocusListener(new FocusAdapter() { // from class: Historia.JPITriage.3
            public void focusGained(FocusEvent evt) {
                JPITriage.this.JTFFPDiastolicaFocusGained(evt);
            }
        });
        GroupLayout JPIPresionLayout = new GroupLayout(this.JPIPresion);
        this.JPIPresion.setLayout(JPIPresionLayout);
        JPIPresionLayout.setHorizontalGroup(JPIPresionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIPresionLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFFPSistolica, -2, 60, -2).addGap(7, 7, 7).addComponent(this.JLBPBSentado).addGap(5, 5, 5).addComponent(this.JTFFPDiastolica, -2, 60, -2).addContainerGap(27, 32767)));
        JPIPresionLayout.setVerticalGroup(JPIPresionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIPresionLayout.createSequentialGroup().addGroup(JPIPresionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFFPSistolica, -2, 25, -2).addComponent(this.JLBPBSentado, -2, 23, -2).addComponent(this.JTFFPDiastolica, -2, 25, -2)).addGap(0, 3, 32767)));
        this.JCH_SParto.setFont(new Font("Arial", 1, 12));
        this.JCH_SParto.setForeground(Color.red);
        this.JCH_SParto.setText("S. Parto");
        this.JCH_SParto.setToolTipText("Poner o Quitar clasificación para sala de partos solo si es materna");
        this.JCH_SParto.addActionListener(new ActionListener() { // from class: Historia.JPITriage.4
            public void actionPerformed(ActionEvent evt) {
                JPITriage.this.JCH_SPartoActionPerformed(evt);
            }
        });
        this.JPSignosVitales.setBorder(BorderFactory.createTitledBorder((Border) null, "SIGNOS VITALES", 1, 0, new Font("Arial", 1, 12), new Color(0, 103, 0)));
        this.JTFFSFc.setBorder(BorderFactory.createTitledBorder((Border) null, "Fc (p/m)", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFSFc.setHorizontalAlignment(0);
        this.JTFFSFc.setText("0");
        this.JTFFSFc.setToolTipText("Frecuencia Cardiáca");
        this.JTFFSFc.setExprecionRegular("^[0-9]*$");
        this.JTFFSFc.setFocusAccelerator('C');
        this.JTFFSFc.setFont(new Font("Arial", 1, 12));
        this.JTFFSFc.addFocusListener(new FocusAdapter() { // from class: Historia.JPITriage.5
            public void focusGained(FocusEvent evt) {
                JPITriage.this.JTFFSFcFocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                JPITriage.this.JTFFSFcFocusLost(evt);
            }
        });
        this.JTFFSFc.addActionListener(new ActionListener() { // from class: Historia.JPITriage.6
            public void actionPerformed(ActionEvent evt) {
                JPITriage.this.JTFFSFcActionPerformed(evt);
            }
        });
        this.JTFFSFr.setBorder(BorderFactory.createTitledBorder((Border) null, "Fr (r/m)", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFSFr.setHorizontalAlignment(0);
        this.JTFFSFr.setText("0");
        this.JTFFSFr.setToolTipText("Frecuencia Respiratoria");
        this.JTFFSFr.setExprecionRegular("^[0-9]*$");
        this.JTFFSFr.setFocusAccelerator('C');
        this.JTFFSFr.setFont(new Font("Arial", 1, 12));
        this.JTFFSFr.addActionListener(new ActionListener() { // from class: Historia.JPITriage.7
            public void actionPerformed(ActionEvent evt) {
                JPITriage.this.JTFFSFrActionPerformed(evt);
            }
        });
        this.JTFFSFr.addFocusListener(new FocusAdapter() { // from class: Historia.JPITriage.8
            public void focusGained(FocusEvent evt) {
                JPITriage.this.JTFFSFrFocusGained(evt);
            }
        });
        this.JTFFTemperatura.setBorder(BorderFactory.createTitledBorder((Border) null, "T (ªC)", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFTemperatura.setHorizontalAlignment(0);
        this.JTFFTemperatura.setText("0");
        this.JTFFTemperatura.setToolTipText("Temperatura");
        this.JTFFTemperatura.setExprecionRegular("^[0-9.]*$");
        this.JTFFTemperatura.setFocusAccelerator('C');
        this.JTFFTemperatura.setFont(new Font("Arial", 1, 12));
        this.JTFFTemperatura.addFocusListener(new FocusAdapter() { // from class: Historia.JPITriage.9
            public void focusGained(FocusEvent evt) {
                JPITriage.this.JTFFTemperaturaFocusGained(evt);
            }
        });
        this.JTFFTemperatura.addActionListener(new ActionListener() { // from class: Historia.JPITriage.10
            public void actionPerformed(ActionEvent evt) {
                JPITriage.this.JTFFTemperaturaActionPerformed(evt);
            }
        });
        this.JTFFPs2.setBorder(BorderFactory.createTitledBorder((Border) null, "Ps2", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFPs2.setHorizontalAlignment(0);
        this.JTFFPs2.setText("0");
        this.JTFFPs2.setToolTipText("Ps2");
        this.JTFFPs2.setExprecionRegular("^[0-9]*$");
        this.JTFFPs2.setFocusAccelerator('C');
        this.JTFFPs2.setFont(new Font("Arial", 1, 12));
        this.JTFFPs2.addActionListener(new ActionListener() { // from class: Historia.JPITriage.11
            public void actionPerformed(ActionEvent evt) {
                JPITriage.this.JTFFPs2ActionPerformed(evt);
            }
        });
        this.JTFFPs2.addFocusListener(new FocusAdapter() { // from class: Historia.JPITriage.12
            public void focusGained(FocusEvent evt) {
                JPITriage.this.JTFFPs2FocusGained(evt);
            }
        });
        this.JTFFSTalla.setBorder(BorderFactory.createTitledBorder((Border) null, "Talla (cm)", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFSTalla.setHorizontalAlignment(0);
        this.JTFFSTalla.setText("0");
        this.JTFFSTalla.setToolTipText("Talla en Centimetros");
        this.JTFFSTalla.setExprecionRegular("^[0.0-9]*$");
        this.JTFFSTalla.setFocusAccelerator('C');
        this.JTFFSTalla.setFont(new Font("Arial", 1, 12));
        this.JTFFSTalla.addActionListener(new ActionListener() { // from class: Historia.JPITriage.13
            public void actionPerformed(ActionEvent evt) {
                JPITriage.this.JTFFSTallaActionPerformed(evt);
            }
        });
        this.JTFFSTalla.addFocusListener(new FocusAdapter() { // from class: Historia.JPITriage.14
            public void focusGained(FocusEvent evt) {
                JPITriage.this.JTFFSTallaFocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                JPITriage.this.JTFFSTallaFocusLost(evt);
            }
        });
        this.JTFFSPeso.setBorder(BorderFactory.createTitledBorder((Border) null, "Peso (Kg)", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFSPeso.setHorizontalAlignment(0);
        this.JTFFSPeso.setText("0");
        this.JTFFSPeso.setToolTipText("Peso en Kilogramos");
        this.JTFFSPeso.setExprecionRegular("^[0.0-9]*$");
        this.JTFFSPeso.setFocusAccelerator('C');
        this.JTFFSPeso.setFont(new Font("Arial", 1, 12));
        this.JTFFSPeso.addActionListener(new ActionListener() { // from class: Historia.JPITriage.15
            public void actionPerformed(ActionEvent evt) {
                JPITriage.this.JTFFSPesoActionPerformed(evt);
            }
        });
        this.JTFFSPeso.addFocusListener(new FocusAdapter() { // from class: Historia.JPITriage.16
            public void focusGained(FocusEvent evt) {
                JPITriage.this.JTFFSPesoFocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                JPITriage.this.JTFFSPesoFocusLost(evt);
            }
        });
        this.JTFFSIMC.setBorder(BorderFactory.createTitledBorder((Border) null, "IMC", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFSIMC.setHorizontalAlignment(0);
        this.JTFFSIMC.setText("0");
        this.JTFFSIMC.setToolTipText("Indice de Masa Corporal");
        this.JTFFSIMC.setDisabledTextColor(new Color(255, 255, 255));
        this.JTFFSIMC.setExprecionRegular("^[0.0-9]*$");
        this.JTFFSIMC.setFocusable(false);
        this.JTFFSIMC.setFont(new Font("Arial", 1, 24));
        GroupLayout JPSignosVitalesLayout = new GroupLayout(this.JPSignosVitales);
        this.JPSignosVitales.setLayout(JPSignosVitalesLayout);
        JPSignosVitalesLayout.setHorizontalGroup(JPSignosVitalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPSignosVitalesLayout.createSequentialGroup().addGap(4, 4, 4).addComponent(this.JTFFSFc, -2, 80, -2).addGap(3, 3, 3).addComponent(this.JTFFSFr, -2, 80, -2).addGap(3, 3, 3).addComponent(this.JTFFTemperatura, -2, 80, -2).addGap(3, 3, 3).addComponent(this.JTFFPs2, -2, 80, -2).addGap(3, 3, 3).addComponent(this.JTFFSTalla, -2, 90, -2).addGap(3, 3, 3).addComponent(this.JTFFSPeso, -2, 90, -2).addGap(18, 18, 18).addComponent(this.JTFFSIMC, -2, 100, -2).addContainerGap()));
        JPSignosVitalesLayout.setVerticalGroup(JPSignosVitalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPSignosVitalesLayout.createSequentialGroup().addGap(3, 3, 3).addGroup(JPSignosVitalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFFSFc, -2, 50, -2).addComponent(this.JTFFSFr, -2, 50, -2).addComponent(this.JTFFTemperatura, -2, 50, -2).addComponent(this.JTFFPs2, -2, 50, -2).addGroup(JPSignosVitalesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFSTalla, -2, 50, -2).addComponent(this.JTFFSPeso, -2, 50, -2)).addComponent(this.JTFFSIMC, -2, 50, -2))));
        this.JTPMenu.setForeground(Color.red);
        this.JTPMenu.setFont(new Font("Arial", 1, 14));
        this.JTAMotivoC.setColumns(20);
        this.JTAMotivoC.setFont(new Font("Arial", 1, 12));
        this.JTAMotivoC.setLineWrap(true);
        this.JTAMotivoC.setRows(1);
        this.JTAMotivoC.setTabSize(1);
        this.JTAMotivoC.setBorder((Border) null);
        this.JTAMotivoC.addKeyListener(new KeyAdapter() { // from class: Historia.JPITriage.17
            public void keyPressed(KeyEvent evt) {
                JPITriage.this.JTAMotivoCKeyPressed(evt);
            }
        });
        this.JSPMotivoC.setViewportView(this.JTAMotivoC);
        this.JTPMenu.addTab("MOTIVO DE CONSULTA", this.JSPMotivoC);
        this.JTFCDxP.setFont(new Font("Arial", 1, 12));
        this.JTFCDxP.setBorder(BorderFactory.createTitledBorder((Border) null, "Cie10", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFCDxP.addFocusListener(new FocusAdapter() { // from class: Historia.JPITriage.18
            public void focusLost(FocusEvent evt) {
                JPITriage.this.JTFCDxPFocusLost(evt);
            }
        });
        this.JTFCDxP.addKeyListener(new KeyAdapter() { // from class: Historia.JPITriage.19
            public void keyPressed(KeyEvent evt) {
                JPITriage.this.JTFCDxPKeyPressed(evt);
            }
        });
        this.JTFNCodigoDxP.setFont(new Font("Arial", 1, 12));
        this.JTFNCodigoDxP.setBorder(BorderFactory.createTitledBorder((Border) null, "Dx Principal", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFNCodigoDxP.addMouseListener(new MouseAdapter() { // from class: Historia.JPITriage.20
            public void mouseClicked(MouseEvent evt) {
                JPITriage.this.JTFNCodigoDxPMouseClicked(evt);
            }
        });
        this.JTFNCodigoDxP.addActionListener(new ActionListener() { // from class: Historia.JPITriage.21
            public void actionPerformed(ActionEvent evt) {
                JPITriage.this.JTFNCodigoDxPActionPerformed(evt);
            }
        });
        this.JTFNCodigoDxP.addKeyListener(new KeyAdapter() { // from class: Historia.JPITriage.22
            public void keyPressed(KeyEvent evt) {
                JPITriage.this.JTFNCodigoDxPKeyPressed(evt);
            }
        });
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: Historia.JPITriage.23
            public void mouseClicked(MouseEvent evt) {
                JPITriage.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JTDetalle.addKeyListener(new KeyAdapter() { // from class: Historia.JPITriage.24
            public void keyPressed(KeyEvent evt) {
                JPITriage.this.JTDetalleKeyPressed(evt);
            }
        });
        this.JSPDiagnostico.setViewportView(this.JTDetalle);
        this.JBTGuardarTemp1.setFont(new Font("Arial", 1, 12));
        this.JBTGuardarTemp1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTGuardarTemp1.addActionListener(new ActionListener() { // from class: Historia.JPITriage.25
            public void actionPerformed(ActionEvent evt) {
                JPITriage.this.JBTGuardarTemp1ActionPerformed(evt);
            }
        });
        this.JSOrden.setFont(new Font("Arial", 1, 12));
        this.JSOrden.setModel(new SpinnerNumberModel(1, 1, (Comparable) null, 1));
        this.JSOrden.setBorder(BorderFactory.createTitledBorder((Border) null, "Nº Orden", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPDiagnostico1Layout = new GroupLayout(this.JPDiagnostico1);
        this.JPDiagnostico1.setLayout(JPDiagnostico1Layout);
        JPDiagnostico1Layout.setHorizontalGroup(JPDiagnostico1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDiagnostico1Layout.createSequentialGroup().addContainerGap().addGroup(JPDiagnostico1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDiagnostico, -1, 765, 32767).addGroup(JPDiagnostico1Layout.createSequentialGroup().addComponent(this.JTFCDxP, -2, 63, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFNCodigoDxP).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSOrden, -2, 78, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTGuardarTemp1, -2, 52, -2))).addContainerGap()));
        JPDiagnostico1Layout.setVerticalGroup(JPDiagnostico1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDiagnostico1Layout.createSequentialGroup().addGap(18, 18, 18).addGroup(JPDiagnostico1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JBTGuardarTemp1, -1, 43, 32767).addComponent(this.JTFCDxP, -2, -1, -2).addComponent(this.JTFNCodigoDxP, -2, -1, -2).addComponent(this.JSOrden, -2, 0, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDiagnostico, -1, 82, 32767)));
        this.JTPMenu.addTab("DIAGNÓSTICOS", this.JPDiagnostico1);
        this.JCHAplicaTestRespiratorio.setFont(new Font("Arial", 1, 12));
        this.JCHAplicaTestRespiratorio.setForeground(Color.red);
        this.JCHAplicaTestRespiratorio.setText("Aplica Test Respiratorio?");
        this.JCHAplicaTestRespiratorio.setToolTipText("Aplica triage respiratorio (SARS-Cov-2)");
        this.JCHAplicaTestRespiratorio.addActionListener(new ActionListener() { // from class: Historia.JPITriage.26
            public void actionPerformed(ActionEvent evt) {
                JPITriage.this.JCHAplicaTestRespiratorioActionPerformed(evt);
            }
        });
        this.jTabbedPane1.setForeground(new Color(0, 103, 0));
        this.jTabbedPane1.setFont(new Font("Arial", 1, 12));
        this.btnNegro.setFont(new Font("Arial", 1, 14));
        this.btnNegro.setText("5");
        this.btnNegro.addActionListener(new ActionListener() { // from class: Historia.JPITriage.27
            public void actionPerformed(ActionEvent evt) {
                JPITriage.this.btnNegroActionPerformed(evt);
            }
        });
        this.btnVerde.setBackground(Color.green);
        this.btnVerde.setFont(new Font("Arial", 1, 14));
        this.btnVerde.setForeground(new Color(0, 0, 204));
        this.btnVerde.setText("4");
        this.btnVerde.addActionListener(new ActionListener() { // from class: Historia.JPITriage.28
            public void actionPerformed(ActionEvent evt) {
                JPITriage.this.btnVerdeActionPerformed(evt);
            }
        });
        this.btnAmarillo.setBackground(new Color(255, 255, 0));
        this.btnAmarillo.setFont(new Font("Arial", 1, 14));
        this.btnAmarillo.setForeground(new Color(0, 0, 204));
        this.btnAmarillo.setText("3");
        this.btnAmarillo.addActionListener(new ActionListener() { // from class: Historia.JPITriage.29
            public void actionPerformed(ActionEvent evt) {
                JPITriage.this.btnAmarilloActionPerformed(evt);
            }
        });
        this.btnNaranja.setBackground(Color.orange);
        this.btnNaranja.setFont(new Font("Arial", 1, 14));
        this.btnNaranja.setForeground(new Color(0, 0, 204));
        this.btnNaranja.setText("2");
        this.btnNaranja.addActionListener(new ActionListener() { // from class: Historia.JPITriage.30
            public void actionPerformed(ActionEvent evt) {
                JPITriage.this.btnNaranjaActionPerformed(evt);
            }
        });
        this.btnRojo.setBackground(Color.red);
        this.btnRojo.setFont(new Font("Arial", 1, 14));
        this.btnRojo.setForeground(new Color(0, 0, 204));
        this.btnRojo.setText("1");
        this.btnRojo.addActionListener(new ActionListener() { // from class: Historia.JPITriage.31
            public void actionPerformed(ActionEvent evt) {
                JPITriage.this.btnRojoActionPerformed(evt);
            }
        });
        this.JTFNTriage.setEditable(false);
        this.JTFNTriage.setFont(new Font("Arial", 1, 24));
        this.JTFNTriage.setHorizontalAlignment(0);
        this.JTFNTriage.setBorder(BorderFactory.createTitledBorder((Border) null, "N°", 1, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPIClasificacionLayout = new GroupLayout(this.JPIClasificacion);
        this.JPIClasificacion.setLayout(JPIClasificacionLayout);
        JPIClasificacionLayout.setHorizontalGroup(JPIClasificacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIClasificacionLayout.createSequentialGroup().addGap(16, 16, 16).addComponent(this.btnRojo, -2, 100, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.btnNaranja, -2, 100, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.btnAmarillo, -2, 100, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.btnVerde, -2, 100, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.btnNegro, -2, 122, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 47, 32767).addComponent(this.JTFNTriage, -2, 158, -2).addGap(16, 16, 16)));
        JPIClasificacionLayout.setVerticalGroup(JPIClasificacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIClasificacionLayout.createSequentialGroup().addContainerGap().addGroup(JPIClasificacionLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JTFNTriage, -2, 64, -2).addGroup(JPIClasificacionLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.btnVerde, -1, -1, 32767).addComponent(this.btnNegro, -1, -1, 32767).addComponent(this.btnNaranja, -1, -1, 32767).addComponent(this.btnRojo, -1, -1, 32767).addComponent(this.btnAmarillo, -2, 70, -2))).addContainerGap(-1, 32767)));
        this.jTabbedPane1.addTab("CLASIFICACIÓN", this.JPIClasificacion);
        this.JCB_APabellon.setFont(new Font("Arial", 1, 12));
        this.JCB_APabellon.setBorder(BorderFactory.createTitledBorder((Border) null, "Pabellón", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.JCB_APabellon, -2, 348, -2).addContainerGap(435, 32767)));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup().addContainerGap(28, 32767).addComponent(this.JCB_APabellon, -2, 50, -2).addGap(15, 15, 15)));
        this.jTabbedPane1.addTab("ASIGNACIÓN SERVICIO", this.jPanel2);
        this.JCH_SinValidacionSignos.setFont(new Font("Arial", 1, 12));
        this.JCH_SinValidacionSignos.setForeground(Color.red);
        this.JCH_SinValidacionSignos.setText("Sin Signos Vitales");
        this.JCH_SinValidacionSignos.addActionListener(new ActionListener() { // from class: Historia.JPITriage.32
            public void actionPerformed(ActionEvent evt) {
                JPITriage.this.JCH_SinValidacionSignosActionPerformed(evt);
            }
        });
        GroupLayout JPI_DatosTriageLayout = new GroupLayout(this.JPI_DatosTriage);
        this.JPI_DatosTriage.setLayout(JPI_DatosTriageLayout);
        JPI_DatosTriageLayout.setHorizontalGroup(JPI_DatosTriageLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DatosTriageLayout.createSequentialGroup().addContainerGap().addGroup(JPI_DatosTriageLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTPMenu).addGroup(JPI_DatosTriageLayout.createSequentialGroup().addGroup(JPI_DatosTriageLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DatosTriageLayout.createSequentialGroup().addComponent(this.JDCFecha, -2, 119, -2).addGap(18, 18, 18).addComponent(this.JTFFHora, -2, 119, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JPIPresion, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPI_DatosTriageLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHAplicaTestRespiratorio, -2, 176, -2).addGroup(JPI_DatosTriageLayout.createSequentialGroup().addComponent(this.JCH_SParto).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JCH_SinValidacionSignos)))).addComponent(this.JPSignosVitales, -2, -1, -2)).addGap(39, 39, 39))).addContainerGap()).addComponent(this.jTabbedPane1, GroupLayout.Alignment.TRAILING));
        JPI_DatosTriageLayout.setVerticalGroup(JPI_DatosTriageLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DatosTriageLayout.createSequentialGroup().addContainerGap().addGroup(JPI_DatosTriageLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DatosTriageLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JTFFHora, -2, 50, -2).addComponent(this.JDCFecha, -2, 50, -2)).addComponent(this.JPIPresion, -2, -1, -2).addGroup(JPI_DatosTriageLayout.createSequentialGroup().addGroup(JPI_DatosTriageLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCH_SParto, -2, 20, -2).addComponent(this.JCH_SinValidacionSignos)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHAplicaTestRespiratorio))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPSignosVitales, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTPMenu, -1, 180, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jTabbedPane1, -2, 124, -2)));
        this.JTP_DatosUrgencias.addTab("DATOS", this.JPI_DatosTriage);
        GroupLayout JPI_TriageRespiratorioLayout = new GroupLayout(this.JPI_TriageRespiratorio);
        this.JPI_TriageRespiratorio.setLayout(JPI_TriageRespiratorioLayout);
        JPI_TriageRespiratorioLayout.setHorizontalGroup(JPI_TriageRespiratorioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 789, 32767));
        JPI_TriageRespiratorioLayout.setVerticalGroup(JPI_TriageRespiratorioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 452, 32767));
        this.JTP_DatosUrgencias.addTab("TEST RESPIRATORIO (SARS-CoV-2)", this.JPI_TriageRespiratorio);
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(this.JTP_DatosUrgencias).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTP_DatosUrgencias, -2, -1, -2).addContainerGap(-1, 32767)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFPSistolicaActionPerformed(ActionEvent evt) {
        this.JTFFPDiastolica.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFPSistolicaFocusGained(FocusEvent evt) {
        this.JTFFPSistolica.selectAll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFPSistolicaFocusLost(FocusEvent evt) {
        if (!this.JTFFPSistolica.getText().isEmpty() && !this.JTFFPSistolica.getText().equals("0")) {
            mValidarPresion(Integer.valueOf(this.JTFFPSistolica.getText()).intValue(), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFPDiastolicaFocusGained(FocusEvent evt) {
        this.JTFFPDiastolica.selectAll();
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
    public void JTFFSFrActionPerformed(ActionEvent evt) {
        this.JTFFTemperatura.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFSFrFocusGained(FocusEvent evt) {
        this.JTFFSFr.selectAll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFTemperaturaActionPerformed(ActionEvent evt) {
        this.JTFFPs2.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFTemperaturaFocusGained(FocusEvent evt) {
        this.JTFFTemperatura.selectAll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFPs2ActionPerformed(ActionEvent evt) {
        this.JTFFSTalla.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFPs2FocusGained(FocusEvent evt) {
        this.JTFFPs2.selectAll();
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
        this.btnRojo.requestFocus();
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
    public void JCH_SPartoActionPerformed(ActionEvent evt) {
        if (this.JCH_SParto.isSelected()) {
            this.xsql = "update `ingreso` set `CS_Parto`=1 where Id='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdIngreso() + "'";
        } else {
            this.xsql = "update `ingreso` set `CS_Parto`=0 where Id='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdIngreso() + "'";
        }
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCDxPFocusLost(FocusEvent evt) {
        if (!this.JTFCDxP.getText().isEmpty()) {
            mBuscarPatologiaCodigo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCDxPKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JTFCDxP.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNCodigoDxPMouseClicked(MouseEvent evt) {
        Principal.clasehistoriace.buscarPatologiaNombre(this.JTFCDxP, this.JTFNCodigoDxP, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNCodigoDxPKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JTFNCodigoDxP.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            this.JTFCDxP.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
            this.JTFNCodigoDxP.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
            this.JSOrden.setValue(Integer.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 127 && this.JTDetalle.getRowCount() != 0 && this.JTDetalle.getSelectedRow() != -1) {
            if (clasesHistoriaCE.informacionAgendaMedicaDTO.getTipoGuardado().intValue() != 1) {
                this.xmodelo.removeRow(this.JTDetalle.getSelectedRow());
            } else {
                JOptionPane.showInternalMessageDialog(this, "Historia clinica se encuentra cerrada", "VALIDACIÓN", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGuardarTemp1ActionPerformed(ActionEvent evt) {
        if (clasesHistoriaCE.informacionAgendaMedicaDTO.getTipoGuardado().intValue() != 1) {
            if (!this.JTFCDxP.getText().isEmpty() && !this.JTFNCodigoDxP.getText().isEmpty()) {
                Object[] fila = {this.JTFCDxP.getText(), this.JTFNCodigoDxP.getText(), this.JSOrden.getValue()};
                this.xmodelo.addRow(fila);
                this.JTDetalle.setModel(this.xmodelo);
                this.JTFCDxP.setText("");
                this.JTFNCodigoDxP.setText("");
                this.JSOrden.setValue(new Integer(1));
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Los campos no pueden estar vacios", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFCDxP.setFocusable(true);
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Historia clinica se encuentra cerrada", "VALIDACIÓN", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHAplicaTestRespiratorioActionPerformed(ActionEvent evt) {
        this.JTP_DatosUrgencias.setEnabledAt(1, true);
        this.JTP_DatosUrgencias.setSelectedIndex(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTAMotivoCKeyPressed(KeyEvent evt) {
        this.xmt.valiacionCaracterComillaSimpleTextArea(evt, this.JTAMotivoC);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNCodigoDxPActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnNegroActionPerformed(ActionEvent evt) {
        this.clasificacion = 5;
        mBotonesTriage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnVerdeActionPerformed(ActionEvent evt) {
        this.clasificacion = 4;
        mBotonesTriage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnAmarilloActionPerformed(ActionEvent evt) {
        this.clasificacion = 3;
        mBotonesTriage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnNaranjaActionPerformed(ActionEvent evt) {
        this.clasificacion = 2;
        mBotonesTriage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnRojoActionPerformed(ActionEvent evt) {
        this.clasificacion = 1;
        mBotonesTriage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_SinValidacionSignosActionPerformed(ActionEvent evt) {
    }

    private void grabarOrdenMedicaAsignacion() {
        if (this.JCB_APabellon.getSelectedIndex() != -1) {
            grabarAsignacionBase();
        }
    }

    public void grabarAsignacionBase() {
        this.xsql = "update ingreso set `Id_TipoAtencion`='" + this.xid_pabellon[this.JCB_APabellon.getSelectedIndex()][2] + "' where Id='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdIngreso() + "'";
        System.out.println(this.xsql);
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
    }

    private void cargarPanelTraigeRespiratorio() {
        if (Principal.informacionIps.getAplicaTestRespiratorio().intValue() == 0) {
            this.triageRespiratorio = new JPTriageRespiratorio(Long.valueOf(this.JTFNTriage.getText()), clasesHistoriaCE.informacionAgendaMedicaDTO.getIdIngreso(), "");
            this.triageRespiratorio.setBounds(1, 1, 700, 300);
            this.JPI_TriageRespiratorio.add(this.triageRespiratorio);
            this.JPI_TriageRespiratorio.repaint();
            return;
        }
        if (Principal.informacionIps.getAplicaTestRespiratorio().intValue() == 1) {
            this.triageRespiratorio_V2 = new JPTriageRespiratorio_V2(Long.valueOf(this.JTFNTriage.getText()), clasesHistoriaCE.informacionAgendaMedicaDTO.getIdIngreso(), "");
            this.triageRespiratorio_V2.setBounds(1, 1, 700, 300);
            this.JPI_TriageRespiratorio.add(this.triageRespiratorio_V2);
            this.JPI_TriageRespiratorio.repaint();
        }
    }

    private void mBotonesTriage() {
        this.btnRojo.setIcon(new ImageIcon(getClass().getResource("")));
        this.btnNaranja.setIcon(new ImageIcon(getClass().getResource("")));
        this.btnAmarillo.setIcon(new ImageIcon(getClass().getResource("")));
        this.btnVerde.setIcon(new ImageIcon(getClass().getResource("")));
        this.btnNegro.setIcon(new ImageIcon(getClass().getResource("")));
        switch (this.clasificacion) {
            case 1:
                this.btnRojo.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
                break;
            case 2:
                this.btnNaranja.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
                break;
            case 3:
                this.btnAmarillo.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
                break;
            case 4:
                this.btnVerde.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
                break;
            case 5:
                this.btnNegro.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
                break;
        }
    }

    private void mValidarPresion(int valor, int xt) {
        if (xt == 0) {
            if (valor > 0 && valor < 100) {
                this.xmt.mostrarMensaje("La Presión Sistólica esta Baja");
                return;
            } else {
                if (valor > 0 && valor > 140) {
                    this.xmt.mostrarMensaje("La Presión Sistólica esta Alta");
                    return;
                }
                return;
            }
        }
        if (valor > 0 && valor < 60) {
            this.xmt.mostrarMensaje("La Presion Diastólica esta Baja");
        } else if (valor > 0 && valor > 90) {
            this.xmt.mostrarMensaje("La Presión Diastólica esta Alta");
        }
    }

    private void mCalcularImc() {
        if (this.JTFFSTalla.getText() != null && this.JTFFSPeso.getText() != null && !this.JTFFSPeso.getText().equals("0") && !this.JTFFSTalla.getText().equals("0") && !this.JTFFSTalla.getText().equals("0.0")) {
            DecimalFormat formato = new DecimalFormat("00");
            double imc = (getPeso() / Math.pow(getTalla(), 2.0d)) * 10000.0d;
            if (imc > 0.0d) {
                this.JTFFSIMC.setText(String.valueOf(formato.format(imc)));
                return;
            } else {
                this.JTFFSIMC.setText("0.0");
                return;
            }
        }
        this.JTFFSIMC.setText("0.0");
    }

    private double getTalla() {
        double valor = 0.0d;
        if (this.JTFFSTalla.getText() != null && !this.JTFFSTalla.getText().equals("") && Double.valueOf(this.JTFFSTalla.getText()).doubleValue() > 0.0d) {
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

    public void mGrabar() {
        Object[] botones;
        if (this.JTFNTriage.getText().isEmpty() || this.JTFNTriage.getText().equals("0")) {
            if (!this.JTAMotivoC.getText().isEmpty()) {
                if (this.JCH_SinValidacionSignos.isSelected()) {
                    grabarTriage();
                    return;
                }
                if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL SAN JOSE DE TIERRALTA") || Integer.parseInt(this.JTFFPSistolica.getText()) > 0) {
                    if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL SAN JOSE DE TIERRALTA") || (Integer.parseInt(this.JTFFPDiastolica.getText()) > 0 && Integer.parseInt(this.JTFFPDiastolica.getText()) < 180)) {
                        if (Integer.parseInt(this.JTFFSFc.getText()) > 0) {
                            if (Integer.parseInt(this.JTFFSFr.getText()) <= 0) {
                                JOptionPane.showMessageDialog(this, "Por favor ingrese un valor para la frecuencia respiratoria", "VALIDACIÓN", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                this.JTFFSFr.requestFocus();
                                return;
                            }
                            if (Double.valueOf(this.JTFFTemperatura.getText()).doubleValue() > 0.0d) {
                                if (Principal.informacionIps.getIdentificacion().equals("812005644")) {
                                    grabarTriage();
                                    return;
                                }
                                if (Integer.parseInt(this.JTFFPs2.getText()) <= 0) {
                                    JOptionPane.showMessageDialog(this, "Por favor ingrese un valor para la saturación de oxígeno", "VALIDACIÓN", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                    this.JTFFPs2.requestFocus();
                                    return;
                                }
                                if (Double.valueOf(this.JTFFSTalla.getText()).doubleValue() <= 0.0d) {
                                    JOptionPane.showMessageDialog(this, "Por favor ingrese un valor para la talla", "VALIDACIÓN", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                    this.JTFFSTalla.requestFocus();
                                    return;
                                } else if (Double.valueOf(this.JTFFSPeso.getText()).doubleValue() <= 0.0d) {
                                    JOptionPane.showMessageDialog(this, "Por favor ingrese un valor para el peso", "VALIDACIÓN", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                    this.JTFFSPeso.requestFocus();
                                    return;
                                } else if (Double.valueOf(this.JTFFSIMC.getText()).doubleValue() > 0.0d) {
                                    grabarTriage();
                                    return;
                                } else {
                                    JOptionPane.showMessageDialog(this, "IMC no tiene valor", "VALIDACIÓN", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                    this.JTFFSIMC.requestFocus();
                                    return;
                                }
                            }
                            JOptionPane.showMessageDialog(this, "Por favor ingrese un valor para la temperatura", "VALIDACIÓN", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                            this.JTFFTemperatura.requestFocus();
                            return;
                        }
                        JOptionPane.showMessageDialog(this, "Por favor ingrese un valor para la frecuencia cardíaca", "VALIDACIÓN", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        this.JTFFSFc.requestFocus();
                        return;
                    }
                    JOptionPane.showMessageDialog(this, "Por favor ingrese un valor para la presión diastólica", "VALIDACIÓN", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    this.JTFFPDiastolica.requestFocus();
                    return;
                }
                JOptionPane.showMessageDialog(this, "Por favor ingrese un valor para la presión sistólica", "VALIDACIÓN", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JTFFPSistolica.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Motivo de consulta no puede estar en blanco", "VALIDACIÓN", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTAMotivoC.requestFocus();
            return;
        }
        if (clasesHistoriaCE.informacionAgendaMedicaDTO.getTipoGuardado().intValue() != 1) {
            if (this.clasificacion <= 2) {
                mUpdateTriage();
                return;
            }
            verificarConvenioCapitado();
            if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL SAN JOSE DE TIERRALTA") && ((this.clasificacion == 5 || this.clasificacion == 4 || this.clasificacion == 3) && this.esCapitado == 2)) {
                System.out.println("es tierralta y evento");
                botones = new Object[]{"Grabar", "Cerrar"};
            } else {
                botones = new Object[]{"Grabar", "Grabar y Cerrar HC", "Cerrar"};
            }
            int y = JOptionPane.showInternalOptionDialog(this, "Que desea hacer?", "SELECCIONAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones, "Cerrar");
            if (y == 0) {
                mUpdateTriage();
                return;
            }
            if (y == 1) {
                mUpdateTriage();
                this.xsql = "update `ingreso` set `Egreso`=1 , `FEgreso`='" + this.xmt.formatoAMD.format(this.JDCFecha.getDate()) + "' where Id='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdIngreso() + "'";
                this.xct.ejecutarSQL(this.xsql);
                this.xct.cerrarConexionBd();
                this.xsql = "update `h_atencion` set `InicioAtencion`=1, `TipoGuardado`=1  where Id='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "'";
                this.xct.ejecutarSQL(this.xsql);
                this.xct.cerrarConexionBd();
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Historia clinica se encuentra cerrada", "VALIDACIÓN", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    private void grabarTriage() {
        Object[] botones;
        if (this.clasificacion >= 1) {
            if (this.clasificacion <= 2) {
                mGrabarTriage();
                grabarOrdenMedicaAsignacion();
                Principal.clasehistoriace.mCambiarEstadoHc(2);
                return;
            }
            verificarConvenioCapitado();
            if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL SAN JOSE DE TIERRALTA") && ((this.clasificacion == 5 || this.clasificacion == 4 || this.clasificacion == 3) && this.esCapitado == 2)) {
                System.out.println("es tierralta y evento");
                botones = new Object[]{"Grabar", "Cerrar"};
            } else {
                botones = new Object[]{"Grabar", "Grabar y Cerrar HC", "Cerrar"};
            }
            int y = JOptionPane.showOptionDialog(this, "Que desea hacer?", "SELECCIONAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones, "Cerrar");
            if (y == 0) {
                mGrabarTriage();
                grabarOrdenMedicaAsignacion();
                Principal.clasehistoriace.mCambiarEstadoHc(2);
                return;
            } else {
                if (y == 1) {
                    mGrabarTriage();
                    grabarSalidaAdminstrativa();
                    this.xsql = "update `ingreso` set `Egreso`=1 , `FEgreso`='" + this.xmt.formatoAMD.format(this.JDCFecha.getDate()) + "' where Id='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdIngreso() + "'";
                    this.xct.ejecutarSQL(this.xsql);
                    this.xct.cerrarConexionBd();
                    this.xsql = "update `h_atencion` set `InicioAtencion`=1, `TipoGuardado`=1  where Id='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "'";
                    this.xct.ejecutarSQL(this.xsql);
                    this.xct.cerrarConexionBd();
                    return;
                }
                return;
            }
        }
        JOptionPane.showInternalMessageDialog(this, "Falta clasificación triage", "VALIDACIÓN", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    private void grabarSalidaAdminstrativa() {
        IngresoOrdenSalidaDTO e = new IngresoOrdenSalidaDTO();
        e.setIdIngreso(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdIngreso());
        e.setFechaS(this.xmt.formatoAMD1.format(this.JDCFecha.getDate()));
        e.setHoraS(this.xmt.formatoH24.format(this.xmt.getFechaActual()));
        e.setObservacion("Orden de Salida por triage No. " + this.clasificacion);
        e.setIdUsuarioRH(Principal.usuarioSistemaDTO.getIdPersonaCargo());
        e.setEstado(1);
        this.ingresoOrdenSalidaDAO.create_return_id(e);
    }

    private void mGrabarTriage() {
        this.xsql = "INSERT INTO h_triage (IdIngreso, TArtSentadoD, TArtSentadoS, Clasificacion, FechaTriage, HoraTriage, MotivoConsulta,  FCardiaca, FRespiratoria, Talla, Peso, IMC, Temperatura, Ps2, Id_Profesional, Id_Especialidad, Estado, Fecha, UsuarioS) VALUES('" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdIngreso() + "','" + this.JTFFPDiastolica.getText() + "','" + this.JTFFPSistolica.getText() + "','" + this.clasificacion + "','" + this.xmt.formatoAMD.format(this.JDCFecha.getDate()) + "','" + this.xmt.formatoH24.format(this.JTFFHora.getValue()) + "','" + this.JTAMotivoC.getText() + "','" + this.JTFFSFc.getText() + "','" + this.JTFFSFr.getText() + "','" + this.JTFFSTalla.getText() + "','" + this.JTFFSPeso.getText() + "','" + this.JTFFSIMC.getText() + "','" + this.JTFFTemperatura.getText() + "','" + this.JTFFPs2.getText() + "','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "','" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "','0','" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
        this.JTFNTriage.setText(this.xct.ejecutarSQLId(this.xsql));
        if (!this.JTFNTriage.getText().isEmpty() || !this.JTFNTriage.getText().equals("0")) {
            for (int i = 0; i < this.JTDetalle.getRowCount(); i++) {
                this.xsql = "INSERT INTO `h_triage_diagnostico` (`Id_Triage`,`Id_Patologia`,`NOrden`,`Id_UsuarioS`)\nVALUES  ('" + this.JTFNTriage.getText() + "','" + this.JTDetalle.getValueAt(i, 0).toString() + "','" + Integer.valueOf(this.JTDetalle.getValueAt(i, 2).toString()) + "','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "')";
                this.xct.ejecutaSQLUpdate(this.xsql);
            }
            if (this.JCHAplicaTestRespiratorio.isSelected()) {
                this.triageRespiratorio.setIdTriage(Long.valueOf(this.JTFNTriage.getText()));
                this.triageRespiratorio.setIdIngreso(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdIngreso());
                this.triageRespiratorio.grabar();
            }
        }
        this.xct.cerrarConexionBd();
        if (this.JTFNTriage.getText().isEmpty() || this.JTFNTriage.getText() == null) {
            this.nTriage = false;
        } else {
            this.nTriage = true;
        }
        System.out.println("triage en grabar-> " + this.nTriage);
    }

    private void mUpdateTriage() {
        this.xsql = "update h_triage  set  TArtSentadoD='" + this.JTFFPDiastolica.getText() + "', TArtSentadoS='" + this.JTFFPSistolica.getText() + "' , Clasificacion='" + this.clasificacion + "', FechaTriage='" + this.xmt.formatoAMD.format(this.JDCFecha.getDate()) + "', HoraTriage='" + this.xmt.formatoH24.format(this.JTFFHora.getValue()) + "', MotivoConsulta='" + this.JTAMotivoC.getText() + "', FCardiaca='" + this.JTFFSFc.getText() + "', FRespiratoria='" + this.JTFFSFr.getText() + "', Talla='" + this.JTFFSTalla.getText() + "', Peso='" + this.JTFFSPeso.getText() + "', IMC='" + this.JTFFSIMC.getText() + "', Temperatura='" + this.JTFFTemperatura.getText() + "', Id_Profesional='" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "', Id_Especialidad='" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad().longValue() + "', Ps2='" + this.JTFFPs2.getText() + "' WHERE Id='" + this.JTFNTriage.getText() + "'";
        this.xct.ejecutaSQLUpdate(this.xsql);
        this.xct.cerrarConexionBd();
    }

    private void mCargarTriage() {
        try {
            if (Principal.informacionIps.getIdentificacion().equals("900520293")) {
                this.xsql = "SELECT\n\th_triage.`Id`,\n\th_triage.`TArtSentadoD`,\n\th_triage.`TArtSentadoS`,\n\th_triage.`Clasificacion`,\n\th_triage.`FechaTriage`,\n\th_triage.`HoraTriage`,\n\tCONCAT('MOTIVO CONSULTA:','\\n', h_triage.`MotivoConsulta`,'\\n','------------------------------------','\\nENFERMEDAD ACTUAL:','\\n',h_triage.Observacion ) ,\n\th_triage.`FCardiaca`,\n\th_triage.`FRespiratoria`,\n\th_triage.`Talla`,\n\th_triage.`Peso`,\n\th_triage.`IMC`,\n\th_triage.`Temperatura`,\n\th_triage.`Ps2` ,\n\tifnull(h_triage_respiratorio.id, 0) as idTriageRespiratorio,\n\th_triage.Id as idTriage\nFROM\n\t`h_triage`\nleft join h_triage_respiratorio on\n\t(h_triage.Id = h_triage_respiratorio.idTriage)\n\tand (h_triage_respiratorio.estado = 1)WHERE (h_triage.`Estado` =0 AND h_triage.`IdIngreso` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdIngreso() + "') ";
            } else {
                this.xsql = "SELECT h_triage.`Id`, h_triage.`TArtSentadoD`, h_triage.`TArtSentadoS`, h_triage.`Clasificacion`, h_triage.`FechaTriage`, h_triage.`HoraTriage`, h_triage.`MotivoConsulta`, h_triage.`FCardiaca`, h_triage.`FRespiratoria`, h_triage.`Talla`, h_triage.`Peso`, h_triage.`IMC`, h_triage.`Temperatura`, h_triage.`Ps2` , ifnull(h_triage_respiratorio.id,0) as idTriageRespiratorio, h_triage.Id  as  idTriage  FROM  `h_triage`  left join h_triage_respiratorio on (h_triage.Id=h_triage_respiratorio.idTriage) and (h_triage_respiratorio.estado=1) WHERE (h_triage.`Estado` =0 AND h_triage.`IdIngreso` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdIngreso() + "') ";
            }
            ResultSet xrs = this.xct.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.first();
                this.JTFNTriage.setText(xrs.getString(1));
                this.JTFFPDiastolica.setValue(Integer.valueOf(xrs.getInt(2)));
                this.JTFFPSistolica.setValue(Integer.valueOf(xrs.getInt(3)));
                if (xrs.getInt(4) == 1) {
                    this.clasificacion = 1;
                    mBotonesTriage();
                } else if (xrs.getInt(4) == 2) {
                    this.clasificacion = 2;
                    mBotonesTriage();
                } else if (xrs.getInt(4) == 3) {
                    this.clasificacion = 3;
                    mBotonesTriage();
                } else if (xrs.getInt(4) == 4) {
                    this.clasificacion = 4;
                    mBotonesTriage();
                } else if (xrs.getInt(4) == 5) {
                    this.clasificacion = 5;
                    mBotonesTriage();
                }
                this.JDCFecha.setDate(xrs.getDate(5));
                this.JTFFHora.setValue(xrs.getTime(6));
                this.JTAMotivoC.setText(xrs.getString(7));
                this.JTFFSFc.setText("" + xrs.getInt(8));
                this.JTFFSFr.setText("" + xrs.getInt(9));
                this.JTFFSTalla.setText("" + xrs.getDouble(10));
                this.JTFFSPeso.setText("" + xrs.getDouble(11));
                this.JTFFSIMC.setText("" + xrs.getDouble(12));
                this.JTFFTemperatura.setText("" + xrs.getDouble(13));
                this.JTFFPs2.setText("" + xrs.getInt(14));
                if (xrs.getLong("idTriageRespiratorio") != 0) {
                    this.triageRespiratorio.setIdTriage(Long.valueOf(xrs.getLong("idTriage")));
                    this.triageRespiratorio.nuevo();
                    this.JCHAplicaTestRespiratorio.setSelected(true);
                    this.JTP_DatosUrgencias.setEnabledAt(1, true);
                }
                clasesHistoriaCE.informacionAgendaMedicaDTO.setEsTriage(Integer.valueOf(xrs.getInt(4)));
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPITriage.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mImprimir() {
        if (!this.JTFNTriage.getText().isEmpty()) {
            ClaseImpresionInformes claseImpresionInformes = new ClaseImpresionInformes();
            claseImpresionInformes.mImprimirTriage(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion(), clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion());
        }
    }

    private void mClasificar_SalaPArto() {
        try {
            this.xsql = "SELECT`ingreso`.`CS_Parto` , `g_persona`.`Id_Sexo` FROM `g_persona` INNER JOIN  `ingreso`  ON (`g_persona`.`Id` = `ingreso`.`Id_Usuario`) WHERE (`ingreso`.`Id` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdIngreso() + "') ";
            ResultSet xrs = this.xct.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.first();
                this.JCH_SParto.setSelected(xrs.getBoolean(1));
                if (xrs.getString(2).equals("F")) {
                    this.JCH_SParto.setVisible(true);
                } else {
                    this.JCH_SParto.setVisible(false);
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPITriage.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatosTabla() {
        mCrearModeloDatos();
        try {
            this.xsql = "SELECT\n    `g_patologia`.`Id` AS CIE10\n    , `g_patologia`.`Nbre`\n    , `h_triage_diagnostico`.`NOrden`\nFROM\n    `g_patologia`\n    INNER JOIN `h_triage_diagnostico` \n        ON (`g_patologia`.`Id` = `h_triage_diagnostico`.`Id_Patologia`)\nWHERE (`h_triage_diagnostico`.`Id_Triage` ='" + this.JTFNTriage.getText() + "'\n    AND `h_triage_diagnostico`.`Estado` =1);";
            ResultSet xrs = this.xct.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(xrs.getString("CIE10"), n, 0);
                    this.xmodelo.setValueAt(xrs.getString("Nbre"), n, 1);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong("NOrden")), n, 2);
                    n++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPITriage.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Cie10", "Diagnóstico", "Nº Orden"}) { // from class: Historia.JPITriage.33
            Class[] types = {String.class, String.class, Long.class};
            boolean[] canEdit = {false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(600);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(50);
    }

    private void mBuscarPatologiaCodigo() {
        List<PatologiaCie10DTO> listPatologia = this.xPatologiaCie10DAO.listPatologiaFiltrada(this.JTFCDxP.getText(), "0");
        if (!listPatologia.isEmpty()) {
            for (int i = 0; i < listPatologia.size(); i++) {
                this.JTFCDxP.setText("" + listPatologia.get(i).getId());
                this.JTFNCodigoDxP.setText("" + listPatologia.get(i).getNombre());
            }
            return;
        }
        this.JTFCDxP.setText("");
        this.JTFNCodigoDxP.setText("");
    }

    public void verificarConvenioCapitado() {
        try {
            this.xsql = "SELECT c.`EsCapitado` EsCapitado FROM `f_empresacontxconvenio` c\nINNER JOIN ingreso i ON (i.`Id_EmpresaContxConv`=c.`Id`)\nWHERE i.`Id` =  '" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdIngreso() + "'";
            ResultSet xrs = this.xct.traerRs(this.xsql);
            System.out.println("consulta ingreso - " + this.xsql);
            if (xrs.next()) {
                this.esCapitado = xrs.getInt("EsCapitado");
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPITriage.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        if (this.esCapitado == 1) {
            this.esCapita = true;
        }
        if (this.clasificacion == 4) {
            this.triageFour = true;
        } else if (this.clasificacion == 5) {
            this.triageFive = true;
        }
    }
}
