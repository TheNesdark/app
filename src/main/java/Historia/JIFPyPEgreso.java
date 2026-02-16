package Historia;

import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JToolBar;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.SoftBevelBorder;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

/* JADX INFO: loaded from: GenomaP.jar:Historia/JIFPyPEgreso.class */
public class JIFPyPEgreso extends JInternalFrame {
    private int[] xidprograma;
    private int[] xidrh;
    private String[][] xidprograma1;
    private int[] xidestado;
    private int[] xidsalidaem;
    private int xllenac;
    private String xsqlr;
    private long xidpaciente;
    private long xcardinal;
    private Object jfp;
    private ButtonGroup JBGComplicacion;
    private ButtonGroup JBGEstado;
    private ButtonGroup JBGTipoUsuario;
    private ButtonGroup JBGTsh;
    private ButtonGroup JBGcarnet;
    private JComboBox JCBEstado;
    private JComboBox JCBHemoclasificacion;
    private JComboBox JCBProgramas;
    private JComboBox JCBResultado;
    private JDateChooser JDCFechaE;
    private JDateChooser JDCFechaR;
    private JLabel JLBAdgar;
    private JLabel JLBComplicacion;
    private JLabel JLBCualComplicacion;
    private JLabel JLBEstado;
    private JLabel JLBEstadoN;
    private JLabel JLBFechaE;
    private JLabel JLBFechaR;
    private JLabel JLBHemoclasificacion;
    private JLabel JLBNHC;
    private JLabel JLBNHijos;
    private JLabel JLBObservaciones;
    private JLabel JLBPeso;
    private JLabel JLBPrograma;
    private JLabel JLBResultado;
    private JLabel JLBTResultadoEmb;
    private JLabel JLBTalla;
    private JLabel JLBTsh;
    private JLabel JLBTsh1;
    private JLabel JLBUsuario;
    private JPanel JPIDatosEmba;
    private JPanel JPIReportes;
    private JRadioButton JRBCarnetVNo;
    private JRadioButton JRBCarnetVSi;
    private JRadioButton JRBCompNo;
    private JRadioButton JRBCompSi;
    private JRadioButton JRBMuerto;
    private JRadioButton JRBTshNo;
    private JRadioButton JRBTshSi;
    private JRadioButton JRBVivo;
    private JSpinner JSPAdgar;
    private JScrollPane JSPCualComplicacion;
    private JSpinner JSPNHijos;
    private JScrollPane JSPObservaciones;
    private JToolBar JTBTitulo;
    private JFormattedTextField JTFFPeso;
    private JFormattedTextField JTFFTalla;
    private JTextField JTFNHc;
    private JTextField JTFTitulo;
    private JTextField JTFUsuario;
    private JTextPane JTPCualComplicacion;
    private JTextPane JTPObservaciones;
    private GregorianCalendar hoy = new GregorianCalendar();
    private SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    private SimpleDateFormat formatoh = new SimpleDateFormat("HH:mm:ss");
    private SimpleDateFormat formatos = new SimpleDateFormat("yyyy/MM/dd");
    private int xestadorc = 1;
    private int xcomplicacion = 0;
    private int xtsh = 1;
    private int xcarnet = 1;

    public JIFPyPEgreso(Object jfp) {
        this.xllenac = 0;
        initComponents();
        this.jfp = jfp;
        this.JDCFechaR.setDate(this.hoy.getTime());
        this.JDCFechaE.setDate(this.hoy.getTime());
        this.xllenac = 1;
    }

    private void initComponents() {
        this.JBGTipoUsuario = new ButtonGroup();
        this.JBGComplicacion = new ButtonGroup();
        this.JBGTsh = new ButtonGroup();
        this.JBGEstado = new ButtonGroup();
        this.JBGcarnet = new ButtonGroup();
        this.JPIReportes = new JPanel();
        this.JLBPrograma = new JLabel();
        this.JTBTitulo = new JToolBar();
        this.JTFTitulo = new JTextField();
        this.JCBProgramas = new JComboBox();
        this.JLBNHC = new JLabel();
        this.JTFNHc = new JTextField();
        this.JLBUsuario = new JLabel();
        this.JTFUsuario = new JTextField();
        this.JLBEstado = new JLabel();
        this.JCBEstado = new JComboBox();
        this.JPIDatosEmba = new JPanel();
        this.JLBTResultadoEmb = new JLabel();
        this.JLBFechaR = new JLabel();
        this.JDCFechaR = new JDateChooser();
        this.JCBResultado = new JComboBox();
        this.JLBResultado = new JLabel();
        this.JSPNHijos = new JSpinner();
        this.JLBEstadoN = new JLabel();
        this.JRBVivo = new JRadioButton();
        this.JRBMuerto = new JRadioButton();
        this.JLBObservaciones = new JLabel();
        this.JSPObservaciones = new JScrollPane();
        this.JTPObservaciones = new JTextPane();
        this.JLBComplicacion = new JLabel();
        this.JRBCompSi = new JRadioButton();
        this.JRBCompNo = new JRadioButton();
        this.JLBPeso = new JLabel();
        this.JTFFPeso = new JFormattedTextField();
        this.JLBTalla = new JLabel();
        this.JTFFTalla = new JFormattedTextField();
        this.JLBAdgar = new JLabel();
        this.JSPAdgar = new JSpinner();
        this.JLBTsh = new JLabel();
        this.JRBTshSi = new JRadioButton();
        this.JRBTshNo = new JRadioButton();
        this.JSPCualComplicacion = new JScrollPane();
        this.JTPCualComplicacion = new JTextPane();
        this.JLBCualComplicacion = new JLabel();
        this.JLBNHijos = new JLabel();
        this.JLBTsh1 = new JLabel();
        this.JRBCarnetVSi = new JRadioButton();
        this.JRBCarnetVNo = new JRadioButton();
        this.JLBHemoclasificacion = new JLabel();
        this.JCBHemoclasificacion = new JComboBox();
        this.JLBFechaE = new JLabel();
        this.JDCFechaE = new JDateChooser();
        setClosable(true);
        setTitle("MODULO EGRESO PyP");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifpypegresos");
        this.JPIReportes.setBorder(BorderFactory.createEtchedBorder(0));
        this.JLBPrograma.setFont(new Font("Arial", 1, 12));
        this.JLBPrograma.setForeground(new Color(0, 0, 153));
        this.JLBPrograma.setText("Programa");
        this.JTBTitulo.setBorder(new SoftBevelBorder(0));
        this.JTBTitulo.setRollover(true);
        this.JTFTitulo.setBackground(new Color(0, 0, 153));
        this.JTFTitulo.setFont(new Font("Arial", 1, 14));
        this.JTFTitulo.setForeground(new Color(204, 255, 255));
        this.JTFTitulo.setHorizontalAlignment(0);
        this.JTFTitulo.setText("EGRESO");
        this.JTFTitulo.setDisabledTextColor(new Color(204, 255, 255));
        this.JTFTitulo.setEnabled(false);
        this.JTBTitulo.add(this.JTFTitulo);
        this.JCBProgramas.setFont(new Font("Arial", 1, 12));
        this.JLBNHC.setFont(new Font("Arial", 1, 12));
        this.JLBNHC.setForeground(new Color(0, 0, 153));
        this.JLBNHC.setText("N° Historia");
        this.JTFNHc.setFont(new Font("Arial", 1, 12));
        this.JTFNHc.setHorizontalAlignment(4);
        this.JTFNHc.addActionListener(new ActionListener() { // from class: Historia.JIFPyPEgreso.1
            public void actionPerformed(ActionEvent evt) {
                JIFPyPEgreso.this.JTFNHcActionPerformed(evt);
            }
        });
        this.JLBUsuario.setFont(new Font("Arial", 1, 12));
        this.JLBUsuario.setForeground(new Color(0, 0, 153));
        this.JLBUsuario.setText("Usuario");
        this.JTFUsuario.setEditable(false);
        this.JTFUsuario.setBackground(new Color(0, 0, 153));
        this.JTFUsuario.setFont(new Font("Arial", 1, 12));
        this.JTFUsuario.setHorizontalAlignment(0);
        this.JTFUsuario.setBorder(BorderFactory.createEtchedBorder());
        this.JTFUsuario.setDisabledTextColor(new Color(255, 255, 255));
        this.JTFUsuario.setEnabled(false);
        this.JLBEstado.setFont(new Font("Arial", 1, 12));
        this.JLBEstado.setForeground(new Color(0, 0, 153));
        this.JLBEstado.setText("Estado");
        this.JCBEstado.setFont(new Font("Arial", 1, 12));
        this.JPIDatosEmba.setBorder(BorderFactory.createEtchedBorder());
        this.JLBTResultadoEmb.setBackground(new Color(0, 0, 153));
        this.JLBTResultadoEmb.setFont(new Font("Arial", 1, 14));
        this.JLBTResultadoEmb.setForeground(new Color(204, 255, 255));
        this.JLBTResultadoEmb.setHorizontalAlignment(0);
        this.JLBTResultadoEmb.setText("RESULTADO EMBARAZO");
        this.JLBTResultadoEmb.setOpaque(true);
        this.JLBFechaR.setFont(new Font("Arial", 1, 12));
        this.JLBFechaR.setForeground(new Color(0, 0, 153));
        this.JLBFechaR.setText("Fecha");
        this.JDCFechaR.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaR.setFont(new Font("Arial", 1, 12));
        this.JCBResultado.setFont(new Font("Arial", 1, 12));
        this.JLBResultado.setFont(new Font("Arial", 1, 12));
        this.JLBResultado.setForeground(new Color(0, 0, 153));
        this.JLBResultado.setText("Resultado");
        this.JSPNHijos.setFont(new Font("Arial", 1, 12));
        this.JSPNHijos.setModel(new SpinnerNumberModel(1, 1, 10, 1));
        this.JLBEstadoN.setFont(new Font("Arial", 1, 12));
        this.JLBEstadoN.setForeground(new Color(0, 0, 153));
        this.JLBEstadoN.setHorizontalAlignment(0);
        this.JLBEstadoN.setText("Estado");
        this.JBGEstado.add(this.JRBVivo);
        this.JRBVivo.setFont(new Font("Arial", 1, 12));
        this.JRBVivo.setForeground(new Color(0, 0, 153));
        this.JRBVivo.setSelected(true);
        this.JRBVivo.setText("Vivo");
        this.JRBVivo.addActionListener(new ActionListener() { // from class: Historia.JIFPyPEgreso.2
            public void actionPerformed(ActionEvent evt) {
                JIFPyPEgreso.this.JRBVivoActionPerformed(evt);
            }
        });
        this.JBGEstado.add(this.JRBMuerto);
        this.JRBMuerto.setFont(new Font("Arial", 1, 12));
        this.JRBMuerto.setForeground(new Color(0, 0, 153));
        this.JRBMuerto.setText("Muerto");
        this.JRBMuerto.addActionListener(new ActionListener() { // from class: Historia.JIFPyPEgreso.3
            public void actionPerformed(ActionEvent evt) {
                JIFPyPEgreso.this.JRBMuertoActionPerformed(evt);
            }
        });
        this.JLBObservaciones.setFont(new Font("Arial", 1, 12));
        this.JLBObservaciones.setForeground(new Color(0, 0, 153));
        this.JLBObservaciones.setHorizontalAlignment(0);
        this.JLBObservaciones.setText("Observaciones");
        this.JTPObservaciones.setFont(new Font("Arial", 1, 12));
        this.JSPObservaciones.setViewportView(this.JTPObservaciones);
        this.JLBComplicacion.setFont(new Font("Arial", 1, 12));
        this.JLBComplicacion.setForeground(new Color(0, 0, 153));
        this.JLBComplicacion.setHorizontalAlignment(0);
        this.JLBComplicacion.setText("Complicación");
        this.JBGComplicacion.add(this.JRBCompSi);
        this.JRBCompSi.setFont(new Font("Arial", 1, 12));
        this.JRBCompSi.setForeground(new Color(0, 0, 153));
        this.JRBCompSi.setText("Si");
        this.JRBCompSi.addActionListener(new ActionListener() { // from class: Historia.JIFPyPEgreso.4
            public void actionPerformed(ActionEvent evt) {
                JIFPyPEgreso.this.JRBCompSiActionPerformed(evt);
            }
        });
        this.JBGComplicacion.add(this.JRBCompNo);
        this.JRBCompNo.setFont(new Font("Arial", 1, 12));
        this.JRBCompNo.setForeground(new Color(0, 0, 153));
        this.JRBCompNo.setSelected(true);
        this.JRBCompNo.setText("No");
        this.JRBCompNo.addActionListener(new ActionListener() { // from class: Historia.JIFPyPEgreso.5
            public void actionPerformed(ActionEvent evt) {
                JIFPyPEgreso.this.JRBCompNoActionPerformed(evt);
            }
        });
        this.JLBPeso.setFont(new Font("Arial", 1, 12));
        this.JLBPeso.setForeground(new Color(0, 0, 153));
        this.JLBPeso.setHorizontalAlignment(0);
        this.JLBPeso.setText("Peso");
        this.JTFFPeso.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.00"))));
        this.JTFFPeso.setFont(new Font("Arial", 1, 12));
        this.JTFFPeso.addActionListener(new ActionListener() { // from class: Historia.JIFPyPEgreso.6
            public void actionPerformed(ActionEvent evt) {
                JIFPyPEgreso.this.JTFFPesoActionPerformed(evt);
            }
        });
        this.JLBTalla.setFont(new Font("Arial", 1, 12));
        this.JLBTalla.setForeground(new Color(0, 0, 153));
        this.JLBTalla.setHorizontalAlignment(0);
        this.JLBTalla.setText("Talla");
        this.JTFFTalla.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.00"))));
        this.JTFFTalla.setFont(new Font("Arial", 1, 12));
        this.JLBAdgar.setFont(new Font("Arial", 1, 12));
        this.JLBAdgar.setForeground(new Color(0, 0, 153));
        this.JLBAdgar.setHorizontalAlignment(0);
        this.JLBAdgar.setText("Apgar");
        this.JSPAdgar.setFont(new Font("Arial", 1, 12));
        this.JSPAdgar.setModel(new SpinnerNumberModel(1, 1, 10, 1));
        this.JLBTsh.setFont(new Font("Arial", 1, 12));
        this.JLBTsh.setForeground(new Color(0, 0, 153));
        this.JLBTsh.setHorizontalAlignment(0);
        this.JLBTsh.setText("TSH");
        this.JBGTsh.add(this.JRBTshSi);
        this.JRBTshSi.setFont(new Font("Arial", 1, 12));
        this.JRBTshSi.setForeground(new Color(0, 0, 153));
        this.JRBTshSi.setSelected(true);
        this.JRBTshSi.setText("Si");
        this.JRBTshSi.addActionListener(new ActionListener() { // from class: Historia.JIFPyPEgreso.7
            public void actionPerformed(ActionEvent evt) {
                JIFPyPEgreso.this.JRBTshSiActionPerformed(evt);
            }
        });
        this.JBGTsh.add(this.JRBTshNo);
        this.JRBTshNo.setFont(new Font("Arial", 1, 12));
        this.JRBTshNo.setForeground(new Color(0, 0, 153));
        this.JRBTshNo.setText("No");
        this.JRBTshNo.addActionListener(new ActionListener() { // from class: Historia.JIFPyPEgreso.8
            public void actionPerformed(ActionEvent evt) {
                JIFPyPEgreso.this.JRBTshNoActionPerformed(evt);
            }
        });
        this.JTPCualComplicacion.setFont(new Font("Arial", 1, 12));
        this.JSPCualComplicacion.setViewportView(this.JTPCualComplicacion);
        this.JLBCualComplicacion.setFont(new Font("Arial", 1, 12));
        this.JLBCualComplicacion.setForeground(new Color(0, 0, 153));
        this.JLBCualComplicacion.setHorizontalAlignment(2);
        this.JLBCualComplicacion.setText("Cual");
        this.JLBNHijos.setFont(new Font("Arial", 1, 12));
        this.JLBNHijos.setForeground(new Color(0, 0, 153));
        this.JLBNHijos.setText("N° Hijos");
        this.JLBTsh1.setFont(new Font("Arial", 1, 12));
        this.JLBTsh1.setForeground(new Color(0, 0, 153));
        this.JLBTsh1.setHorizontalAlignment(0);
        this.JLBTsh1.setText("Carnet Vac");
        this.JBGcarnet.add(this.JRBCarnetVSi);
        this.JRBCarnetVSi.setFont(new Font("Arial", 1, 12));
        this.JRBCarnetVSi.setForeground(new Color(0, 0, 153));
        this.JRBCarnetVSi.setSelected(true);
        this.JRBCarnetVSi.setText("Si");
        this.JRBCarnetVSi.addActionListener(new ActionListener() { // from class: Historia.JIFPyPEgreso.9
            public void actionPerformed(ActionEvent evt) {
                JIFPyPEgreso.this.JRBCarnetVSiActionPerformed(evt);
            }
        });
        this.JBGcarnet.add(this.JRBCarnetVNo);
        this.JRBCarnetVNo.setFont(new Font("Arial", 1, 12));
        this.JRBCarnetVNo.setForeground(new Color(0, 0, 153));
        this.JRBCarnetVNo.setText("No");
        this.JRBCarnetVNo.addActionListener(new ActionListener() { // from class: Historia.JIFPyPEgreso.10
            public void actionPerformed(ActionEvent evt) {
                JIFPyPEgreso.this.JRBCarnetVNoActionPerformed(evt);
            }
        });
        this.JLBHemoclasificacion.setFont(new Font("Arial", 1, 12));
        this.JLBHemoclasificacion.setForeground(new Color(0, 0, 153));
        this.JLBHemoclasificacion.setHorizontalAlignment(0);
        this.JLBHemoclasificacion.setText("Hemoclasificación");
        this.JCBHemoclasificacion.setFont(new Font("Arial", 1, 12));
        GroupLayout JPIDatosEmbaLayout = new GroupLayout(this.JPIDatosEmba);
        this.JPIDatosEmba.setLayout(JPIDatosEmbaLayout);
        JPIDatosEmbaLayout.setHorizontalGroup(JPIDatosEmbaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosEmbaLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosEmbaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosEmbaLayout.createSequentialGroup().addGroup(JPIDatosEmbaLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPIDatosEmbaLayout.createSequentialGroup().addGroup(JPIDatosEmbaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosEmbaLayout.createSequentialGroup().addGroup(JPIDatosEmbaLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPIDatosEmbaLayout.createSequentialGroup().addComponent(this.JRBVivo).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBMuerto)).addComponent(this.JLBEstadoN, -1, -1, 32767)).addGap(6, 6, 6).addGroup(JPIDatosEmbaLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPIDatosEmbaLayout.createSequentialGroup().addComponent(this.JTFFPeso, -2, 47, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFTalla, -2, 46, -2)).addGroup(JPIDatosEmbaLayout.createSequentialGroup().addComponent(this.JLBPeso, -2, 47, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLBTalla, -1, -1, 32767))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDatosEmbaLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JLBAdgar, -1, -1, 32767).addComponent(this.JSPAdgar, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDatosEmbaLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPIDatosEmbaLayout.createSequentialGroup().addComponent(this.JRBTshSi).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBTshNo)).addComponent(this.JLBTsh, -1, -1, 32767))).addGroup(JPIDatosEmbaLayout.createSequentialGroup().addGroup(JPIDatosEmbaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLBFechaR).addComponent(this.JDCFechaR, -2, 100, -2)).addGroup(JPIDatosEmbaLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addGroup(JPIDatosEmbaLayout.createSequentialGroup().addGap(14, 14, 14).addComponent(this.JLBResultado, -2, 246, -2)).addGroup(JPIDatosEmbaLayout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBResultado, 0, -1, 32767))))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDatosEmbaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLBTsh1, -2, 60, -2).addGroup(JPIDatosEmbaLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JLBNHijos, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JSPNHijos, GroupLayout.Alignment.LEADING, -1, 51, 32767)).addGroup(JPIDatosEmbaLayout.createSequentialGroup().addComponent(this.JRBCarnetVSi).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBCarnetVNo)))).addComponent(this.JLBObservaciones, -1, -1, 32767)).addGap(30, 30, 30)).addGroup(JPIDatosEmbaLayout.createSequentialGroup().addGroup(JPIDatosEmbaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLBTResultadoEmb, -1, -1, 32767).addComponent(this.JSPObservaciones).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosEmbaLayout.createSequentialGroup().addGroup(JPIDatosEmbaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosEmbaLayout.createSequentialGroup().addComponent(this.JRBCompSi).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBCompNo).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPCualComplicacion, -2, 249, -2)).addGroup(JPIDatosEmbaLayout.createSequentialGroup().addComponent(this.JLBComplicacion, -2, 83, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLBCualComplicacion, -2, 83, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(JPIDatosEmbaLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JLBHemoclasificacion, -2, 105, -2).addComponent(this.JCBHemoclasificacion, -2, 126, -2)))).addContainerGap()))));
        JPIDatosEmbaLayout.setVerticalGroup(JPIDatosEmbaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosEmbaLayout.createSequentialGroup().addContainerGap().addComponent(this.JLBTResultadoEmb, -2, 22, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDatosEmbaLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPIDatosEmbaLayout.createSequentialGroup().addGroup(JPIDatosEmbaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JLBFechaR).addComponent(this.JLBResultado)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JDCFechaR, -2, 25, -2)).addGroup(JPIDatosEmbaLayout.createSequentialGroup().addComponent(this.JLBNHijos).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDatosEmbaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JSPNHijos, -2, 25, -2).addComponent(this.JCBResultado, -2, 25, -2)))).addGroup(JPIDatosEmbaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosEmbaLayout.createSequentialGroup().addGap(29, 29, 29).addGroup(JPIDatosEmbaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JLBEstadoN).addComponent(this.JLBPeso).addComponent(this.JLBTalla)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDatosEmbaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosEmbaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBVivo).addComponent(this.JRBMuerto).addComponent(this.JTFFPeso, -2, 30, -2)).addComponent(this.JTFFTalla, -2, 30, -2))).addGroup(JPIDatosEmbaLayout.createSequentialGroup().addGap(28, 28, 28).addGroup(JPIDatosEmbaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JLBAdgar).addComponent(this.JLBTsh).addComponent(this.JLBTsh1)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDatosEmbaLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSPAdgar, -2, 30, -2).addGroup(JPIDatosEmbaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBTshSi).addComponent(this.JRBTshNo).addComponent(this.JRBCarnetVSi).addComponent(this.JRBCarnetVNo))))).addGap(18, 18, 18).addGroup(JPIDatosEmbaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosEmbaLayout.createSequentialGroup().addGroup(JPIDatosEmbaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JLBComplicacion).addComponent(this.JLBCualComplicacion)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDatosEmbaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosEmbaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBCompSi).addComponent(this.JRBCompNo)).addGroup(JPIDatosEmbaLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JCBHemoclasificacion, -2, 25, -2).addComponent(this.JSPCualComplicacion, -2, -1, -2)))).addComponent(this.JLBHemoclasificacion)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 21, 32767).addComponent(this.JLBObservaciones).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPObservaciones, -2, 49, -2).addContainerGap()));
        this.JLBFechaE.setFont(new Font("Arial", 1, 12));
        this.JLBFechaE.setForeground(new Color(0, 0, 153));
        this.JLBFechaE.setText("Fecha Egreso");
        this.JDCFechaE.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaE.setFont(new Font("Arial", 1, 12));
        GroupLayout JPIReportesLayout = new GroupLayout(this.JPIReportes);
        this.JPIReportes.setLayout(JPIReportesLayout);
        JPIReportesLayout.setHorizontalGroup(JPIReportesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIReportesLayout.createSequentialGroup().addContainerGap().addGroup(JPIReportesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIReportesLayout.createSequentialGroup().addComponent(this.JLBEstado, -1, 64, 32767).addGap(437, 437, 437)).addGroup(GroupLayout.Alignment.TRAILING, JPIReportesLayout.createSequentialGroup().addComponent(this.JLBPrograma, -1, 82, 32767).addGap(419, 419, 419)).addGroup(JPIReportesLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JPIDatosEmba, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JCBEstado, GroupLayout.Alignment.LEADING, 0, -1, 32767).addComponent(this.JTBTitulo, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JCBProgramas, GroupLayout.Alignment.LEADING, 0, -1, 32767).addGroup(GroupLayout.Alignment.LEADING, JPIReportesLayout.createSequentialGroup().addGroup(JPIReportesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLBNHC).addComponent(this.JTFNHc, -2, 79, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIReportesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFUsuario, -2, 290, -2).addComponent(this.JLBUsuario)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIReportesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JDCFechaE, -2, 100, -2).addComponent(this.JLBFechaE))))).addContainerGap()));
        JPIReportesLayout.setVerticalGroup(JPIReportesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIReportesLayout.createSequentialGroup().addContainerGap().addComponent(this.JTBTitulo, -2, 25, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIReportesLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPIReportesLayout.createSequentialGroup().addComponent(this.JLBNHC).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFNHc, -2, 30, -2)).addGroup(JPIReportesLayout.createSequentialGroup().addComponent(this.JLBUsuario).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFUsuario, -2, 30, -2)).addGroup(JPIReportesLayout.createSequentialGroup().addComponent(this.JLBFechaE).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JDCFechaE, -2, 31, -2))).addGap(13, 13, 13).addComponent(this.JLBPrograma).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBProgramas, -2, 30, -2).addGap(18, 18, 18).addComponent(this.JLBEstado).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBEstado, -2, 30, -2).addGap(18, 18, 18).addComponent(this.JPIDatosEmba, -2, -1, -2).addContainerGap(-1, 32767)));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIReportes, -2, -1, -2).addContainerGap(-1, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIReportes, -2, -1, -2).addContainerGap(17, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNHcActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBVivoActionPerformed(ActionEvent evt) {
        this.xestadorc = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBMuertoActionPerformed(ActionEvent evt) {
        this.xestadorc = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBCompSiActionPerformed(ActionEvent evt) {
        this.xcomplicacion = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBCompNoActionPerformed(ActionEvent evt) {
        this.xcomplicacion = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBTshSiActionPerformed(ActionEvent evt) {
        this.xtsh = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBTshNoActionPerformed(ActionEvent evt) {
        this.xtsh = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFPesoActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBCarnetVSiActionPerformed(ActionEvent evt) {
        this.xcarnet = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBCarnetVNoActionPerformed(ActionEvent evt) {
        this.xcarnet = 0;
    }

    public void mNuevo() {
        this.JTFNHc.setText((String) null);
        this.JTFUsuario.setText((String) null);
        this.JDCFechaR.setDate(this.hoy.getTime());
        this.JDCFechaE.setDate(this.hoy.getTime());
        this.JCBProgramas.setSelectedIndex(-1);
        this.JCBEstado.setSelectedIndex(-1);
        this.JCBResultado.setSelectedIndex(-1);
        this.JSPNHijos.setValue(new Integer(1));
        this.JRBVivo.setSelected(true);
        this.JTFFPeso.setText((String) null);
        this.JTFFTalla.setText((String) null);
        this.JSPAdgar.setValue(new Integer(1));
        this.JRBTshSi.setSelected(true);
        this.JRBCarnetVSi.setSelected(true);
        this.JRBCompNo.setSelected(true);
        this.JTPCualComplicacion.setText((String) null);
        this.JTPObservaciones.setText((String) null);
        this.JCBHemoclasificacion.setSelectedIndex(6);
    }
}
