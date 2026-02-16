package Historia;

import Acceso.Principal;
import General.Anular;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.genoma.plus.dao.general.PatologiaCie10DAO;
import com.genoma.plus.dao.impl.general.PatologiaCie10DAOImpl;
import com.genoma.plus.dto.general.PatologiaCie10DTO;
import com.genoma.plus.jpa.projection.ITriage;
import com.genoma.plus.jpa.service.NotaEgresoService;
import com.genoma.plus.jpa.service.impl.NotasDeEgresoServiceImpl;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.text.DateFormatter;
import javax.swing.text.DefaultFormatterFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:Historia/JPEgresoUrgencias.class */
public class JPEgresoUrgencias extends JPanel {
    private ConsultasMySQL xct;
    private Metodos xmt;
    private int xestado;
    private int xId_Tipo;
    private int xEstado;
    private int xIdPrograma;
    private String[] idDestino;
    private String[] idTipoDX;
    private long xidatencion;
    private long xidingreso;
    private String xsql;
    private Boolean xverificar;
    private Boolean xlleno;
    private clasesHistoriaCE historiaCE;
    private Integer triage;
    public JD_Gestion_Hospitalizacion xgestion_h;
    private PatologiaCie10DAO patologiaCie10DAO;
    private final NotaEgresoService notasEgresoService;
    private JButton JBAbrir_Hc;
    private ButtonGroup JBGDestino;
    private ButtonGroup JBGEstado;
    private JButton JBTGHospitalizacion;
    private JButton JBTGrabar;
    private JButton JBTGrabar1;
    private JButton JBTVisualizar;
    private JComboBox JCBDestino;
    private JComboBox JCBTipoDx;
    private JDateChooser JDCFechaS;
    private JLabel JLBNEgreso;
    private JPanel JPICausaMuerte;
    private JPanel JPIDatosS;
    private JPanel JPIDiagnositicos;
    private JPanel JPIDxConclusion;
    private JPanel JPIDxRelacionados;
    private JPanel JPIDx_Complicacion;
    private JPanel JPIEstado;
    private JRadioButton JRBEMuerto;
    private JRadioButton JRBEVivo;
    private JScrollPane JSPObservacion;
    private JScrollPane JSPObservacion1;
    private JTextArea JTAObservacion;
    private JTextArea JTAObservacion1;
    private JTextField JTFCDxC;
    public JTextField JTFCDxP;
    private JTextField JTFCDxR1;
    private JTextField JTFCDxR2;
    private JTextField JTFCDxR3;
    private JTextField JTFCDxR4;
    public JFormattedTextField JTFFHora;
    public JTextField JTFNCodigoDxP;
    private JTextField JTFNDxC;
    private JTextField JTFNDxR1;
    private JTextField JTFNDxR2;
    private JTextField JTFNDxR3;
    private JTextField JTFNDxR4;
    private JTabbedPane JTPDatosAdicionales;

    public JPEgresoUrgencias(long xidingreso, long xidatencion, int xId_Tipo, String xNombre, int xIdPrograma) {
        this.xct = new ConsultasMySQL();
        this.xmt = new Metodos();
        this.xestado = 1;
        this.xEstado = 0;
        this.xIdPrograma = 0;
        this.xidatencion = 0L;
        this.xidingreso = 0L;
        this.xverificar = false;
        this.xlleno = false;
        this.notasEgresoService = (NotaEgresoService) Principal.contexto.getBean(NotasDeEgresoServiceImpl.class);
        initComponents();
        springStart();
        setName(xNombre);
        mNuevo();
        if (Principal.clasehistoriace == null) {
            this.historiaCE = new clasesHistoriaCE();
        } else {
            this.historiaCE = Principal.clasehistoriace;
        }
        this.xId_Tipo = xId_Tipo;
        this.xidingreso = xidingreso;
        this.xidatencion = xidatencion;
        this.xIdPrograma = xIdPrograma;
        mBuscarEgreso();
        if (Principal.informacionIps.getNombreIps().equals("CLINICA LAURELES PSIQUIATRAS ASOCIADOS I.P.S. S.A.S.") || Principal.informacionIps.getNombreIps().equals("CLINICA OFTALMOLOGICA DAJUD SAS") || Principal.informacionIps.getNombreIps().equals("COD-OPTICA UT") || Principal.informacionIps.getNombreIps().equals("JAIME CESAR DAJUD FERNANDEZ") || Principal.informacionIps.getNombreIps().equals("UNION TEMPORAL CLINICA LAURELES")) {
            this.JBTVisualizar.setVisible(false);
        } else if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL LOCAL DE MONTELIBANO") || Principal.informacionIps.getIdentificacion().equals("812005644") || Principal.informacionIps.getNombreIps().equals("CLINICA PAJONAL S.A.S") || Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JUAN DE DIOS") || Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JORGE DE AYAPEL") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO CAMU CHIMA") || Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JUAN DE DIOS - Segovia")) {
            this.JBAbrir_Hc.setVisible(false);
            this.JBTVisualizar.setVisible(false);
            this.JTPDatosAdicionales.remove(2);
        } else if (Principal.informacionIps.getNombreIps().equals("E.S.E HOSPITAL SAN JUAN DE SAHAGUN")) {
            this.JBTVisualizar.setVisible(false);
            this.JBTGHospitalizacion.setVisible(false);
            this.JTPDatosAdicionales.remove(2);
        }
        if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL LOCAL DE MONTELIBANO")) {
            this.JTPDatosAdicionales.addTab("OBSERVACIONES", this.JSPObservacion);
        }
        mCambio_EstadoBoton();
    }

    public JPEgresoUrgencias(long xidingreso, long xidatencion, int xId_Tipo, String xNombre, int xIdPrograma, String fechaNacimiento) {
        this(xidingreso, xidatencion, xId_Tipo, xNombre, xIdPrograma);
        System.err.println("fecha" + fechaNacimiento);
        springStart();
        if (Principal.clasehistoriace == null) {
            this.historiaCE = new clasesHistoriaCE();
        } else {
            this.historiaCE = Principal.clasehistoriace;
        }
        clasesHistoriaCE.informacionAgendaMedicaDTO.setFechaNacimiento(fechaNacimiento);
    }

    private void initComponents() {
        this.JBGDestino = new ButtonGroup();
        this.JBGEstado = new ButtonGroup();
        this.JPIDxConclusion = new JPanel();
        this.JTFCDxP = new JTextField();
        this.JTFNCodigoDxP = new JTextField();
        this.JPIDxRelacionados = new JPanel();
        this.JTFCDxR1 = new JTextField();
        this.JTFCDxR2 = new JTextField();
        this.JTFCDxR3 = new JTextField();
        this.JTFNDxR1 = new JTextField();
        this.JTFNDxR2 = new JTextField();
        this.JTFNDxR3 = new JTextField();
        this.JCBTipoDx = new JComboBox();
        this.JPIDatosS = new JPanel();
        this.JDCFechaS = new JDateChooser();
        this.JTFFHora = new JFormattedTextField();
        this.JCBDestino = new JComboBox();
        this.JBTGrabar1 = new JButton();
        this.JBTGrabar = new JButton();
        this.JLBNEgreso = new JLabel();
        this.JBTVisualizar = new JButton();
        this.JBTGHospitalizacion = new JButton();
        this.JBAbrir_Hc = new JButton();
        this.JTPDatosAdicionales = new JTabbedPane();
        this.JPIDiagnositicos = new JPanel();
        this.JPIDx_Complicacion = new JPanel();
        this.JTFCDxC = new JTextField();
        this.JTFNDxC = new JTextField();
        this.JPIEstado = new JPanel();
        this.JRBEVivo = new JRadioButton();
        this.JRBEMuerto = new JRadioButton();
        this.JPICausaMuerte = new JPanel();
        this.JTFCDxR4 = new JTextField();
        this.JTFNDxR4 = new JTextField();
        this.JSPObservacion1 = new JScrollPane();
        this.JTAObservacion1 = new JTextArea();
        this.JSPObservacion = new JScrollPane();
        this.JTAObservacion = new JTextArea();
        setBorder(BorderFactory.createEtchedBorder());
        setName("xjp_egreso_uh");
        this.JPIDxConclusion.setBorder(BorderFactory.createTitledBorder((Border) null, "DIAGNÓSTICO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JPIDxConclusion.setMinimumSize(new Dimension(804, 188));
        this.JTFCDxP.setFont(new Font("Arial", 1, 12));
        this.JTFCDxP.setBorder(BorderFactory.createTitledBorder((Border) null, "Cie10", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFCDxP.addFocusListener(new FocusAdapter() { // from class: Historia.JPEgresoUrgencias.1
            public void focusLost(FocusEvent evt) {
                JPEgresoUrgencias.this.JTFCDxPFocusLost(evt);
            }
        });
        this.JTFCDxP.addKeyListener(new KeyAdapter() { // from class: Historia.JPEgresoUrgencias.2
            public void keyPressed(KeyEvent evt) {
                JPEgresoUrgencias.this.JTFCDxPKeyPressed(evt);
            }
        });
        this.JTFNCodigoDxP.setFont(new Font("Arial", 1, 12));
        this.JTFNCodigoDxP.setBorder(BorderFactory.createTitledBorder((Border) null, "Dx Principal", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFNCodigoDxP.addFocusListener(new FocusAdapter() { // from class: Historia.JPEgresoUrgencias.3
            public void focusLost(FocusEvent evt) {
                JPEgresoUrgencias.this.JTFNCodigoDxPFocusLost(evt);
            }
        });
        this.JTFNCodigoDxP.addMouseListener(new MouseAdapter() { // from class: Historia.JPEgresoUrgencias.4
            public void mouseClicked(MouseEvent evt) {
                JPEgresoUrgencias.this.JTFNCodigoDxPMouseClicked(evt);
            }
        });
        this.JTFNCodigoDxP.addKeyListener(new KeyAdapter() { // from class: Historia.JPEgresoUrgencias.5
            public void keyPressed(KeyEvent evt) {
                JPEgresoUrgencias.this.JTFNCodigoDxPKeyPressed(evt);
            }
        });
        this.JPIDxRelacionados.setBorder(BorderFactory.createTitledBorder((Border) null, "DIAGNÓSTICOS RELACIONADOS", 2, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.JTFCDxR1.setFont(new Font("Arial", 1, 12));
        this.JTFCDxR1.addFocusListener(new FocusAdapter() { // from class: Historia.JPEgresoUrgencias.6
            public void focusLost(FocusEvent evt) {
                JPEgresoUrgencias.this.JTFCDxR1FocusLost(evt);
            }
        });
        this.JTFCDxR1.addKeyListener(new KeyAdapter() { // from class: Historia.JPEgresoUrgencias.7
            public void keyPressed(KeyEvent evt) {
                JPEgresoUrgencias.this.JTFCDxR1KeyPressed(evt);
            }
        });
        this.JTFCDxR2.setFont(new Font("Arial", 1, 12));
        this.JTFCDxR2.addFocusListener(new FocusAdapter() { // from class: Historia.JPEgresoUrgencias.8
            public void focusLost(FocusEvent evt) {
                JPEgresoUrgencias.this.JTFCDxR2FocusLost(evt);
            }
        });
        this.JTFCDxR2.addKeyListener(new KeyAdapter() { // from class: Historia.JPEgresoUrgencias.9
            public void keyPressed(KeyEvent evt) {
                JPEgresoUrgencias.this.JTFCDxR2KeyPressed(evt);
            }
        });
        this.JTFCDxR3.setFont(new Font("Arial", 1, 12));
        this.JTFCDxR3.addFocusListener(new FocusAdapter() { // from class: Historia.JPEgresoUrgencias.10
            public void focusLost(FocusEvent evt) {
                JPEgresoUrgencias.this.JTFCDxR3FocusLost(evt);
            }
        });
        this.JTFCDxR3.addKeyListener(new KeyAdapter() { // from class: Historia.JPEgresoUrgencias.11
            public void keyPressed(KeyEvent evt) {
                JPEgresoUrgencias.this.JTFCDxR3KeyPressed(evt);
            }
        });
        this.JTFNDxR1.setFont(new Font("Arial", 1, 12));
        this.JTFNDxR1.addFocusListener(new FocusAdapter() { // from class: Historia.JPEgresoUrgencias.12
            public void focusLost(FocusEvent evt) {
                JPEgresoUrgencias.this.JTFNDxR1FocusLost(evt);
            }
        });
        this.JTFNDxR1.addMouseListener(new MouseAdapter() { // from class: Historia.JPEgresoUrgencias.13
            public void mouseClicked(MouseEvent evt) {
                JPEgresoUrgencias.this.JTFNDxR1MouseClicked(evt);
            }
        });
        this.JTFNDxR1.addKeyListener(new KeyAdapter() { // from class: Historia.JPEgresoUrgencias.14
            public void keyPressed(KeyEvent evt) {
                JPEgresoUrgencias.this.JTFNDxR1KeyPressed(evt);
            }
        });
        this.JTFNDxR2.setFont(new Font("Arial", 1, 12));
        this.JTFNDxR2.addFocusListener(new FocusAdapter() { // from class: Historia.JPEgresoUrgencias.15
            public void focusLost(FocusEvent evt) {
                JPEgresoUrgencias.this.JTFNDxR2FocusLost(evt);
            }
        });
        this.JTFNDxR2.addMouseListener(new MouseAdapter() { // from class: Historia.JPEgresoUrgencias.16
            public void mouseClicked(MouseEvent evt) {
                JPEgresoUrgencias.this.JTFNDxR2MouseClicked(evt);
            }
        });
        this.JTFNDxR2.addKeyListener(new KeyAdapter() { // from class: Historia.JPEgresoUrgencias.17
            public void keyPressed(KeyEvent evt) {
                JPEgresoUrgencias.this.JTFNDxR2KeyPressed(evt);
            }
        });
        this.JTFNDxR3.setFont(new Font("Arial", 1, 12));
        this.JTFNDxR3.addFocusListener(new FocusAdapter() { // from class: Historia.JPEgresoUrgencias.18
            public void focusLost(FocusEvent evt) {
                JPEgresoUrgencias.this.JTFNDxR3FocusLost(evt);
            }
        });
        this.JTFNDxR3.addMouseListener(new MouseAdapter() { // from class: Historia.JPEgresoUrgencias.19
            public void mouseClicked(MouseEvent evt) {
                JPEgresoUrgencias.this.JTFNDxR3MouseClicked(evt);
            }
        });
        this.JTFNDxR3.addKeyListener(new KeyAdapter() { // from class: Historia.JPEgresoUrgencias.20
            public void keyPressed(KeyEvent evt) {
                JPEgresoUrgencias.this.JTFNDxR3KeyPressed(evt);
            }
        });
        GroupLayout JPIDxRelacionadosLayout = new GroupLayout(this.JPIDxRelacionados);
        this.JPIDxRelacionados.setLayout(JPIDxRelacionadosLayout);
        JPIDxRelacionadosLayout.setHorizontalGroup(JPIDxRelacionadosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDxRelacionadosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDxRelacionadosLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFCDxR3).addComponent(this.JTFCDxR2).addComponent(this.JTFCDxR1, -2, 55, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(JPIDxRelacionadosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JTFNDxR2, GroupLayout.Alignment.LEADING, -1, 678, 32767).addComponent(this.JTFNDxR1, GroupLayout.Alignment.LEADING).addComponent(this.JTFNDxR3)).addGap(29, 29, 29)));
        JPIDxRelacionadosLayout.setVerticalGroup(JPIDxRelacionadosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDxRelacionadosLayout.createSequentialGroup().addGroup(JPIDxRelacionadosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFNDxR1, -2, 25, -2).addComponent(this.JTFCDxR1, -2, 25, -2)).addGap(3, 3, 3).addGroup(JPIDxRelacionadosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFCDxR2, -2, 25, -2).addComponent(this.JTFNDxR2, -2, 22, -2)).addGap(3, 3, 3).addGroup(JPIDxRelacionadosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFNDxR3, -2, 25, -2).addComponent(this.JTFCDxR3, -2, 25, -2)).addGap(3, 3, 3)));
        this.JCBTipoDx.setFont(new Font("Arial", 1, 12));
        this.JCBTipoDx.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Dx", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        GroupLayout JPIDxConclusionLayout = new GroupLayout(this.JPIDxConclusion);
        this.JPIDxConclusion.setLayout(JPIDxConclusionLayout);
        JPIDxConclusionLayout.setHorizontalGroup(JPIDxConclusionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDxConclusionLayout.createSequentialGroup().addContainerGap().addGroup(JPIDxConclusionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIDxRelacionados, -2, 772, -2).addGroup(JPIDxConclusionLayout.createSequentialGroup().addComponent(this.JTFCDxP, -2, 86, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFNCodigoDxP, -2, 449, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBTipoDx, -2, 217, -2))).addContainerGap(-1, 32767)));
        JPIDxConclusionLayout.setVerticalGroup(JPIDxConclusionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDxConclusionLayout.createSequentialGroup().addGap(3, 3, 3).addGroup(JPIDxConclusionLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFCDxP, -2, -1, -2).addComponent(this.JTFNCodigoDxP, -2, -1, -2).addComponent(this.JCBTipoDx)).addGap(3, 3, 3).addComponent(this.JPIDxRelacionados, -2, -1, -2).addGap(3, 3, 3)));
        this.JPIDatosS.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS SALIDA", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JPIDatosS.setMinimumSize(new Dimension(800, 87));
        this.JDCFechaS.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaS.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaS.setFont(new Font("Arial", 1, 12));
        this.JDCFechaS.addPropertyChangeListener(new PropertyChangeListener() { // from class: Historia.JPEgresoUrgencias.21
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JPEgresoUrgencias.this.JDCFechaSPropertyChange(evt);
            }
        });
        this.JTFFHora.setBorder(BorderFactory.createTitledBorder((Border) null, "Hora", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFHora.setFormatterFactory(new DefaultFormatterFactory(new DateFormatter(new SimpleDateFormat("HH:mm:ss"))));
        this.JTFFHora.setFont(new Font("Tahoma", 1, 12));
        this.JTFFHora.addKeyListener(new KeyAdapter() { // from class: Historia.JPEgresoUrgencias.22
            public void keyPressed(KeyEvent evt) {
                JPEgresoUrgencias.this.JTFFHoraKeyPressed(evt);
            }
        });
        this.JCBDestino.setFont(new Font("Arial", 1, 12));
        this.JCBDestino.setBorder(BorderFactory.createTitledBorder((Border) null, "Destino", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JCBDestino.addItemListener(new ItemListener() { // from class: Historia.JPEgresoUrgencias.23
            public void itemStateChanged(ItemEvent evt) {
                JPEgresoUrgencias.this.JCBDestinoItemStateChanged(evt);
            }
        });
        this.JBTGrabar1.setFont(new Font("Arial", 1, 12));
        this.JBTGrabar1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/actualizar.png")));
        this.JBTGrabar1.setText("Traer DxIngreso?");
        this.JBTGrabar1.addActionListener(new ActionListener() { // from class: Historia.JPEgresoUrgencias.24
            public void actionPerformed(ActionEvent evt) {
                JPEgresoUrgencias.this.JBTGrabar1ActionPerformed(evt);
            }
        });
        GroupLayout JPIDatosSLayout = new GroupLayout(this.JPIDatosS);
        this.JPIDatosS.setLayout(JPIDatosSLayout);
        JPIDatosSLayout.setHorizontalGroup(JPIDatosSLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosSLayout.createSequentialGroup().addContainerGap().addComponent(this.JDCFechaS, -2, 116, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFFHora, -2, 88, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBDestino, -2, 270, -2).addGap(72, 72, 72).addComponent(this.JBTGrabar1, -2, 183, -2).addContainerGap(-1, 32767)));
        JPIDatosSLayout.setVerticalGroup(JPIDatosSLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosSLayout.createSequentialGroup().addGroup(JPIDatosSLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosSLayout.createSequentialGroup().addGap(3, 3, 3).addGroup(JPIDatosSLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JDCFechaS, -2, 50, -2).addGroup(JPIDatosSLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFHora, -2, 50, -2).addComponent(this.JCBDestino, -2, 50, -2)))).addComponent(this.JBTGrabar1, -2, 50, -2)).addContainerGap()));
        this.JBTGrabar.setFont(new Font("Arial", 1, 12));
        this.JBTGrabar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTGrabar.setText("Grabar");
        this.JBTGrabar.addActionListener(new ActionListener() { // from class: Historia.JPEgresoUrgencias.25
            public void actionPerformed(ActionEvent evt) {
                JPEgresoUrgencias.this.JBTGrabarActionPerformed(evt);
            }
        });
        this.JLBNEgreso.setFont(new Font("Arial", 1, 18));
        this.JLBNEgreso.setForeground(new Color(255, 0, 0));
        this.JLBNEgreso.setHorizontalAlignment(0);
        this.JLBNEgreso.setBorder(BorderFactory.createTitledBorder((Border) null, "Egreso N°", 2, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JBTVisualizar.setFont(new Font("Arial", 1, 12));
        this.JBTVisualizar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Imprimir.png")));
        this.JBTVisualizar.setText("<html><P ALIGN=center>Visualizar Epicrisis");
        this.JBTVisualizar.addActionListener(new ActionListener() { // from class: Historia.JPEgresoUrgencias.26
            public void actionPerformed(ActionEvent evt) {
                JPEgresoUrgencias.this.JBTVisualizarActionPerformed(evt);
            }
        });
        this.JBTGHospitalizacion.setFont(new Font("Arial", 1, 12));
        this.JBTGHospitalizacion.setIcon(new ImageIcon(getClass().getResource("/Imagenes/servicio.png")));
        this.JBTGHospitalizacion.setLabel("<html><P ALIGN=center>Solicitar Hospitalización");
        this.JBTGHospitalizacion.addActionListener(new ActionListener() { // from class: Historia.JPEgresoUrgencias.27
            public void actionPerformed(ActionEvent evt) {
                JPEgresoUrgencias.this.JBTGHospitalizacionActionPerformed(evt);
            }
        });
        this.JBAbrir_Hc.setFont(new Font("Arial", 1, 12));
        this.JBAbrir_Hc.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Configuracion29x27.png")));
        this.JBAbrir_Hc.setText("Abrir Hc");
        this.JBAbrir_Hc.addActionListener(new ActionListener() { // from class: Historia.JPEgresoUrgencias.28
            public void actionPerformed(ActionEvent evt) {
                JPEgresoUrgencias.this.JBAbrir_HcActionPerformed(evt);
            }
        });
        this.JTPDatosAdicionales.setForeground(new Color(0, 103, 0));
        this.JTPDatosAdicionales.setFont(new Font("Arial", 1, 14));
        this.JPIDx_Complicacion.setBorder(BorderFactory.createTitledBorder((Border) null, "DIAGNÓSTICO DE COMPLICACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTFCDxC.setFont(new Font("Arial", 1, 12));
        this.JTFCDxC.addFocusListener(new FocusAdapter() { // from class: Historia.JPEgresoUrgencias.29
            public void focusLost(FocusEvent evt) {
                JPEgresoUrgencias.this.JTFCDxCFocusLost(evt);
            }
        });
        this.JTFCDxC.addKeyListener(new KeyAdapter() { // from class: Historia.JPEgresoUrgencias.30
            public void keyPressed(KeyEvent evt) {
                JPEgresoUrgencias.this.JTFCDxCKeyPressed(evt);
            }
        });
        this.JTFNDxC.setFont(new Font("Arial", 1, 12));
        this.JTFNDxC.addMouseListener(new MouseAdapter() { // from class: Historia.JPEgresoUrgencias.31
            public void mouseClicked(MouseEvent evt) {
                JPEgresoUrgencias.this.JTFNDxCMouseClicked(evt);
            }
        });
        GroupLayout JPIDx_ComplicacionLayout = new GroupLayout(this.JPIDx_Complicacion);
        this.JPIDx_Complicacion.setLayout(JPIDx_ComplicacionLayout);
        JPIDx_ComplicacionLayout.setHorizontalGroup(JPIDx_ComplicacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDx_ComplicacionLayout.createSequentialGroup().addGap(4, 4, 4).addComponent(this.JTFCDxC, -2, 55, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFNDxC).addGap(22, 22, 22)));
        JPIDx_ComplicacionLayout.setVerticalGroup(JPIDx_ComplicacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDx_ComplicacionLayout.createSequentialGroup().addGap(3, 3, 3).addGroup(JPIDx_ComplicacionLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFNDxC, -2, 25, -2).addComponent(this.JTFCDxC, -2, 25, -2)).addGap(3, 3, 3)));
        this.JPIEstado.setBorder(BorderFactory.createTitledBorder((Border) null, "Estado", 0, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.JBGEstado.add(this.JRBEVivo);
        this.JRBEVivo.setFont(new Font("Arial", 1, 12));
        this.JRBEVivo.setSelected(true);
        this.JRBEVivo.setText("Vivo");
        this.JRBEVivo.addActionListener(new ActionListener() { // from class: Historia.JPEgresoUrgencias.32
            public void actionPerformed(ActionEvent evt) {
                JPEgresoUrgencias.this.JRBEVivoActionPerformed(evt);
            }
        });
        this.JBGEstado.add(this.JRBEMuerto);
        this.JRBEMuerto.setFont(new Font("Arial", 1, 12));
        this.JRBEMuerto.setText("Muerto");
        this.JRBEMuerto.addActionListener(new ActionListener() { // from class: Historia.JPEgresoUrgencias.33
            public void actionPerformed(ActionEvent evt) {
                JPEgresoUrgencias.this.JRBEMuertoActionPerformed(evt);
            }
        });
        GroupLayout JPIEstadoLayout = new GroupLayout(this.JPIEstado);
        this.JPIEstado.setLayout(JPIEstadoLayout);
        JPIEstadoLayout.setHorizontalGroup(JPIEstadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIEstadoLayout.createSequentialGroup().addContainerGap().addComponent(this.JRBEVivo).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JRBEMuerto).addContainerGap()));
        JPIEstadoLayout.setVerticalGroup(JPIEstadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIEstadoLayout.createSequentialGroup().addGroup(JPIEstadoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBEVivo).addComponent(this.JRBEMuerto)).addGap(10, 10, 10)));
        this.JPICausaMuerte.setBorder(BorderFactory.createTitledBorder((Border) null, "CAUSA BASICA DE LA MUERTE (CIE10)", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTFCDxR4.setFont(new Font("Arial", 1, 12));
        this.JTFCDxR4.setEnabled(false);
        this.JTFCDxR4.addFocusListener(new FocusAdapter() { // from class: Historia.JPEgresoUrgencias.34
            public void focusLost(FocusEvent evt) {
                JPEgresoUrgencias.this.JTFCDxR4FocusLost(evt);
            }
        });
        this.JTFCDxR4.addKeyListener(new KeyAdapter() { // from class: Historia.JPEgresoUrgencias.35
            public void keyPressed(KeyEvent evt) {
                JPEgresoUrgencias.this.JTFCDxR4KeyPressed(evt);
            }
        });
        this.JTFNDxR4.setFont(new Font("Arial", 1, 12));
        this.JTFNDxR4.setEnabled(false);
        this.JTFNDxR4.addMouseListener(new MouseAdapter() { // from class: Historia.JPEgresoUrgencias.36
            public void mouseClicked(MouseEvent evt) {
                JPEgresoUrgencias.this.JTFNDxR4MouseClicked(evt);
            }
        });
        GroupLayout JPICausaMuerteLayout = new GroupLayout(this.JPICausaMuerte);
        this.JPICausaMuerte.setLayout(JPICausaMuerteLayout);
        JPICausaMuerteLayout.setHorizontalGroup(JPICausaMuerteLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPICausaMuerteLayout.createSequentialGroup().addGap(4, 4, 4).addComponent(this.JTFCDxR4, -2, 55, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFNDxR4, -1, 526, 32767).addGap(22, 22, 22)));
        JPICausaMuerteLayout.setVerticalGroup(JPICausaMuerteLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPICausaMuerteLayout.createSequentialGroup().addGap(3, 3, 3).addGroup(JPICausaMuerteLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFNDxR4, -2, 25, -2).addComponent(this.JTFCDxR4, -2, 25, -2)).addGap(3, 3, 3)));
        GroupLayout JPIDiagnositicosLayout = new GroupLayout(this.JPIDiagnositicos);
        this.JPIDiagnositicos.setLayout(JPIDiagnositicosLayout);
        JPIDiagnositicosLayout.setHorizontalGroup(JPIDiagnositicosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDiagnositicosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDiagnositicosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIDx_Complicacion, -1, -1, 32767).addGroup(JPIDiagnositicosLayout.createSequentialGroup().addComponent(this.JPIEstado, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JPICausaMuerte, -1, -1, 32767))).addContainerGap()));
        JPIDiagnositicosLayout.setVerticalGroup(JPIDiagnositicosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDiagnositicosLayout.createSequentialGroup().addContainerGap().addComponent(this.JPIDx_Complicacion, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDiagnositicosLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JPICausaMuerte, -1, -1, 32767).addComponent(this.JPIEstado, -1, -1, 32767)).addContainerGap(-1, 32767)));
        this.JTPDatosAdicionales.addTab("DATOS ADICIONALES", this.JPIDiagnositicos);
        this.JSPObservacion1.setBorder((Border) null);
        this.JTAObservacion1.setColumns(20);
        this.JTAObservacion1.setFont(new Font("Arial", 1, 12));
        this.JTAObservacion1.setLineWrap(true);
        this.JTAObservacion1.setRows(1);
        this.JTAObservacion1.setTabSize(1);
        this.JTAObservacion1.setBorder((Border) null);
        this.JSPObservacion1.setViewportView(this.JTAObservacion1);
        this.JTPDatosAdicionales.addTab("RECOMENDACIONES GENERALES", this.JSPObservacion1);
        this.JSPObservacion.setBorder((Border) null);
        this.JTAObservacion.setColumns(20);
        this.JTAObservacion.setFont(new Font("Arial", 1, 12));
        this.JTAObservacion.setLineWrap(true);
        this.JTAObservacion.setRows(1);
        this.JTAObservacion.setTabSize(1);
        this.JTAObservacion.setBorder((Border) null);
        this.JSPObservacion.setViewportView(this.JTAObservacion);
        this.JTPDatosAdicionales.addTab("ESTADO DEL USUARIO", this.JSPObservacion);
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JBTGrabar, -2, 150, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTGHospitalizacion, -2, 150, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBTVisualizar, -2, 150, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBAbrir_Hc, -1, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JLBNEgreso, -2, 144, -2)).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JPIDatosS, -1, -1, 32767).addComponent(this.JPIDxConclusion, -1, -1, 32767).addComponent(this.JTPDatosAdicionales, -1, 804, 32767)).addGap(0, 0, 32767))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.JPIDatosS, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPIDxConclusion, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTPDatosAdicionales, -2, 170, -2).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(14, 14, 14).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JBTGHospitalizacion, -2, 50, -2).addComponent(this.JBTGrabar, -2, 50, -2).addComponent(this.JBTVisualizar, -2, 50, -2).addComponent(this.JBAbrir_Hc, -2, 50, -2))).addGroup(layout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLBNEgreso, -2, 52, -2))).addContainerGap(-1, 32767)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCDxR1FocusLost(FocusEvent evt) {
        if (this.historiaCE.xjifhistoriaclinica != null) {
            this.historiaCE.buscarPatologias(this.JTFCDxR1, this.JTFNDxR1, 0, clasesHistoriaCE.informacionAgendaMedicaDTO.getFechaNacimiento(), clasesHistoriaCE.informacionAgendaMedicaDTO.getIdSexo(), this.historiaCE.xjifhistoriaclinica);
        } else if (this.historiaCE.historia_Clinica_v4 != null) {
            this.historiaCE.buscarPatologias(this.JTFCDxR1, this.JTFNDxR1, 0, clasesHistoriaCE.informacionAgendaMedicaDTO.getFechaNacimiento(), clasesHistoriaCE.informacionAgendaMedicaDTO.getIdSexo(), this.historiaCE.historia_Clinica_v4);
        } else if (this.historiaCE.historia_Clinica_v2 != null) {
            this.historiaCE.buscarPatologias(this.JTFCDxR1, this.JTFNDxR1, 0, clasesHistoriaCE.informacionAgendaMedicaDTO.getFechaNacimiento(), clasesHistoriaCE.informacionAgendaMedicaDTO.getIdSexo(), this.historiaCE.historia_Clinica_v2);
        } else if (Principal.clasefacturacion != null) {
            buscarPatologias(this.JTFCDxR1, this.JTFNDxR1);
        }
        validacionDiagnosticos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCDxR1KeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JTFCDxR1.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNDxR1MouseClicked(MouseEvent evt) {
        this.historiaCE.buscarPatologiaNombre(this.JTFCDxR1, this.JTFNDxR1, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNDxR1KeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JTFNDxR1.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCDxR2FocusLost(FocusEvent evt) {
        if (this.historiaCE.xjifhistoriaclinica != null) {
            this.historiaCE.buscarPatologias(this.JTFCDxR2, this.JTFNDxR2, 0, clasesHistoriaCE.informacionAgendaMedicaDTO.getFechaNacimiento(), clasesHistoriaCE.informacionAgendaMedicaDTO.getIdSexo(), this.historiaCE.xjifhistoriaclinica);
        } else if (this.historiaCE.historia_Clinica_v4 != null) {
            this.historiaCE.buscarPatologias(this.JTFCDxR2, this.JTFNDxR2, 0, clasesHistoriaCE.informacionAgendaMedicaDTO.getFechaNacimiento(), clasesHistoriaCE.informacionAgendaMedicaDTO.getIdSexo(), this.historiaCE.historia_Clinica_v4);
        } else if (this.historiaCE.historia_Clinica_v2 != null) {
            this.historiaCE.buscarPatologias(this.JTFCDxR2, this.JTFNDxR2, 0, clasesHistoriaCE.informacionAgendaMedicaDTO.getFechaNacimiento(), clasesHistoriaCE.informacionAgendaMedicaDTO.getIdSexo(), this.historiaCE.historia_Clinica_v2);
        } else if (Principal.clasefacturacion != null) {
            buscarPatologias(this.JTFCDxR2, this.JTFNDxR2);
        }
        validacionDiagnosticos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCDxR2KeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JTFCDxR2.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNDxR2MouseClicked(MouseEvent evt) {
        if (this.historiaCE.xjifhistoriaclinica != null) {
            this.historiaCE.buscarPatologias(this.JTFCDxR2, this.JTFNDxR2, 0, clasesHistoriaCE.informacionAgendaMedicaDTO.getFechaNacimiento(), clasesHistoriaCE.informacionAgendaMedicaDTO.getIdSexo(), this.historiaCE.xjifhistoriaclinica);
        } else if (this.historiaCE.historia_Clinica_v4 != null) {
            this.historiaCE.buscarPatologias(this.JTFCDxR2, this.JTFNDxR2, 0, clasesHistoriaCE.informacionAgendaMedicaDTO.getFechaNacimiento(), clasesHistoriaCE.informacionAgendaMedicaDTO.getIdSexo(), this.historiaCE.historia_Clinica_v4);
        } else if (this.historiaCE.historia_Clinica_v2 != null) {
            this.historiaCE.buscarPatologias(this.JTFCDxR2, this.JTFNDxR2, 0, clasesHistoriaCE.informacionAgendaMedicaDTO.getFechaNacimiento(), clasesHistoriaCE.informacionAgendaMedicaDTO.getIdSexo(), this.historiaCE.historia_Clinica_v2);
        }
        validacionDiagnosticos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNDxR2KeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JTFNDxR2.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCDxR3FocusLost(FocusEvent evt) {
        if (this.historiaCE.xjifhistoriaclinica != null) {
            this.historiaCE.buscarPatologias(this.JTFCDxR3, this.JTFNDxR3, 0, clasesHistoriaCE.informacionAgendaMedicaDTO.getFechaNacimiento(), clasesHistoriaCE.informacionAgendaMedicaDTO.getIdSexo(), this.historiaCE.xjifhistoriaclinica);
        } else if (this.historiaCE.historia_Clinica_v4 != null) {
            this.historiaCE.buscarPatologias(this.JTFCDxR3, this.JTFNDxR3, 0, clasesHistoriaCE.informacionAgendaMedicaDTO.getFechaNacimiento(), clasesHistoriaCE.informacionAgendaMedicaDTO.getIdSexo(), this.historiaCE.historia_Clinica_v4);
        } else if (this.historiaCE.historia_Clinica_v2 != null) {
            this.historiaCE.buscarPatologias(this.JTFCDxR3, this.JTFNDxR3, 0, clasesHistoriaCE.informacionAgendaMedicaDTO.getFechaNacimiento(), clasesHistoriaCE.informacionAgendaMedicaDTO.getIdSexo(), this.historiaCE.historia_Clinica_v2);
        } else if (Principal.clasefacturacion != null) {
            buscarPatologias(this.JTFCDxR3, this.JTFNDxR3);
        }
        validacionDiagnosticos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCDxR3KeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JTFCDxR3.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNDxR3MouseClicked(MouseEvent evt) {
        this.historiaCE.buscarPatologiaNombre(this.JTFCDxR3, this.JTFNDxR3, 1);
        validacionDiagnosticos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNDxR3KeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JTFNDxR3.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCDxPFocusLost(FocusEvent evt) {
        if (this.historiaCE.xjifhistoriaclinica != null) {
            this.historiaCE.buscarPatologias(this.JTFCDxP, this.JTFNCodigoDxP, 0, clasesHistoriaCE.informacionAgendaMedicaDTO.getFechaNacimiento(), clasesHistoriaCE.informacionAgendaMedicaDTO.getIdSexo(), this.historiaCE.xjifhistoriaclinica);
        } else if (this.historiaCE.historia_Clinica_v4 != null) {
            this.historiaCE.buscarPatologias(this.JTFCDxP, this.JTFNCodigoDxP, 0, clasesHistoriaCE.informacionAgendaMedicaDTO.getFechaNacimiento(), clasesHistoriaCE.informacionAgendaMedicaDTO.getIdSexo(), this.historiaCE.historia_Clinica_v4);
        } else if (this.historiaCE.historia_Clinica_v2 != null) {
            this.historiaCE.buscarPatologias(this.JTFCDxP, this.JTFNCodigoDxP, 0, clasesHistoriaCE.informacionAgendaMedicaDTO.getFechaNacimiento(), clasesHistoriaCE.informacionAgendaMedicaDTO.getIdSexo(), this.historiaCE.historia_Clinica_v2);
        } else if (Principal.clasefacturacion != null) {
            buscarPatologias(this.JTFCDxP, this.JTFNCodigoDxP);
        }
        validacionDiagnosticos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCDxPKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JTFCDxP.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNCodigoDxPMouseClicked(MouseEvent evt) {
        this.historiaCE.buscarPatologiaNombre(this.JTFCDxP, this.JTFNCodigoDxP, 1);
        validacionDiagnosticos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNCodigoDxPKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JTFNCodigoDxP.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDCFechaSPropertyChange(PropertyChangeEvent evt) {
        try {
            JIFAgendaMedico.xfechaatencion = this.xmt.formatoDMA.format(this.JDCFechaS.getDate());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFHoraKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JTFFHora.transferFocus();
        }
    }

    private void springStart() {
        this.patologiaCie10DAO = (PatologiaCie10DAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("patologiaCie10DAOImpl");
    }

    private void buscarPatologias(JTextField codigo, JTextField nombrep) {
        PatologiaCie10DTO patologia = this.patologiaCie10DAO.patologiaFiltrada(codigo.getText(), -1);
        codigo.setText(patologia.getId());
        nombrep.setText(patologia.getNombre());
    }

    public Boolean verificarNotaDeEgreso() {
        if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL SAN JOSE DE TIERRALTA")) {
            List<ITriage> listaTriage = this.notasEgresoService.listaTriage(this.xidingreso);
            if (listaTriage.size() > 0) {
                this.triage = listaTriage.get(0).getClasificacion();
                if (listaTriage.get(0).getClasificacion().intValue() > 3) {
                    return true;
                }
                return Boolean.valueOf(this.notasEgresoService.listaNotaEgresoPorHistoria(Long.valueOf(this.xidatencion)).size() > 0);
            }
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCDxR4FocusLost(FocusEvent evt) {
        if (this.JRBEMuerto.isSelected()) {
            clasesHistoriaCE claseshistoriace = this.historiaCE;
            JTextField jTextField = this.JTFCDxR4;
            JTextField jTextField2 = this.JTFNDxR4;
            clasesHistoriaCE claseshistoriace2 = this.historiaCE;
            String fechaNacimiento = clasesHistoriaCE.informacionAgendaMedicaDTO.getFechaNacimiento();
            clasesHistoriaCE claseshistoriace3 = this.historiaCE;
            claseshistoriace.buscarPatologias(jTextField, jTextField2, 1, fechaNacimiento, clasesHistoriaCE.informacionAgendaMedicaDTO.getNombreSexo(), this.historiaCE.xjifhistoriaclinica);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCDxR4KeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10 && this.JRBEMuerto.isSelected()) {
            clasesHistoriaCE claseshistoriace = this.historiaCE;
            JTextField jTextField = this.JTFCDxR4;
            JTextField jTextField2 = this.JTFNDxR4;
            clasesHistoriaCE claseshistoriace2 = this.historiaCE;
            String fechaNacimiento = clasesHistoriaCE.informacionAgendaMedicaDTO.getFechaNacimiento();
            clasesHistoriaCE claseshistoriace3 = this.historiaCE;
            claseshistoriace.buscarPatologias(jTextField, jTextField2, 1, fechaNacimiento, clasesHistoriaCE.informacionAgendaMedicaDTO.getNombreSexo(), this.historiaCE.xjifhistoriaclinica);
            this.JTFCDxR4.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNDxR4MouseClicked(MouseEvent evt) {
        if (this.JRBEMuerto.isSelected()) {
            this.historiaCE.buscarPatologiaNombre(this.JTFCDxR4, this.JTFNDxR4, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBEVivoActionPerformed(ActionEvent evt) {
        this.xestado = 1;
        this.JTFCDxR4.setEnabled(false);
        this.JTFNDxR4.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBEMuertoActionPerformed(ActionEvent evt) {
        this.xestado = 2;
        this.JTFCDxR4.setEnabled(true);
        this.JTFNDxR4.setEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGrabarActionPerformed(ActionEvent evt) {
        mGrabar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTVisualizarActionPerformed(ActionEvent evt) {
        if (!this.JLBNEgreso.getText().isEmpty()) {
            String[][] mparametros = new String[3][2];
            mparametros[0][0] = "idatencion1";
            mparametros[0][1] = String.valueOf(this.xidatencion);
            mparametros[1][0] = "SUBREPORT_DIR";
            mparametros[1][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
            mparametros[2][0] = "SUBREPORTFIRMA_DIR";
            mparametros[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "H_HistoriaClinica_Epicrisis", mparametros);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGHospitalizacionActionPerformed(ActionEvent evt) {
        if (!this.JLBNEgreso.getText().isEmpty()) {
            if (this.JCBDestino.getSelectedIndex() != -1 && this.idDestino[this.JCBDestino.getSelectedIndex()].equals("3")) {
                this.xgestion_h = new JD_Gestion_Hospitalizacion(null, true, Long.valueOf(this.xidatencion), this.JTFCDxP.getText(), this.JTFNCodigoDxP.getText(), String.valueOf(this.xidingreso));
                this.xgestion_h.setLocationRelativeTo(this);
                this.xgestion_h.setVisible(true);
                return;
            }
            return;
        }
        JOptionPane.showMessageDialog(this, "Debe grabar el egreso", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCDxCFocusLost(FocusEvent evt) {
        clasesHistoriaCE claseshistoriace = this.historiaCE;
        JTextField jTextField = this.JTFCDxC;
        JTextField jTextField2 = this.JTFNDxC;
        clasesHistoriaCE claseshistoriace2 = this.historiaCE;
        String fechaNacimiento = clasesHistoriaCE.informacionAgendaMedicaDTO.getFechaNacimiento();
        clasesHistoriaCE claseshistoriace3 = this.historiaCE;
        claseshistoriace.buscarPatologias(jTextField, jTextField2, 1, fechaNacimiento, clasesHistoriaCE.informacionAgendaMedicaDTO.getNombreSexo(), this.historiaCE.xjifhistoriaclinica);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCDxCKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            clasesHistoriaCE claseshistoriace = this.historiaCE;
            JTextField jTextField = this.JTFCDxC;
            JTextField jTextField2 = this.JTFNDxC;
            clasesHistoriaCE claseshistoriace2 = this.historiaCE;
            String fechaNacimiento = clasesHistoriaCE.informacionAgendaMedicaDTO.getFechaNacimiento();
            clasesHistoriaCE claseshistoriace3 = this.historiaCE;
            claseshistoriace.buscarPatologias(jTextField, jTextField2, 2, fechaNacimiento, clasesHistoriaCE.informacionAgendaMedicaDTO.getNombreSexo(), this.historiaCE.xjifhistoriaclinica);
            this.JTFCDxR2.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNDxCMouseClicked(MouseEvent evt) {
        this.historiaCE.buscarPatologiaNombre(this.JTFCDxC, this.JTFNDxC, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBAbrir_HcActionPerformed(ActionEvent evt) {
        if (this.JBAbrir_Hc.getText().equals("Abrir Hc")) {
            String xsql = "update h_atencion set TipoGuardado=0 where Id='" + this.xidatencion + "'";
            this.xct.ejecutarSQL(xsql);
            this.xct.cerrarConexionBd();
            this.JBTGrabar.setEnabled(true);
        } else {
            String xsql2 = "update h_atencion set TipoGuardado=1 where Id='" + this.xidatencion + "'";
            this.xct.ejecutarSQL(xsql2);
            this.xct.cerrarConexionBd();
            this.JBTGrabar.setEnabled(false);
        }
        mBuscarEgreso();
        mCambio_EstadoBoton();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBDestinoItemStateChanged(ItemEvent evt) {
        if (this.JCBDestino.getSelectedIndex() != -1 && this.xlleno.booleanValue()) {
            switch (this.idDestino[this.JCBDestino.getSelectedIndex()]) {
                case "1":
                case "2":
                    this.JBTGHospitalizacion.setEnabled(false);
                    this.JTPDatosAdicionales.setSelectedIndex(0);
                    break;
                case "3":
                case "7":
                    this.JBTGHospitalizacion.setEnabled(true);
                    this.JTPDatosAdicionales.setSelectedIndex(0);
                    break;
                case "4":
                    this.JBTGHospitalizacion.setEnabled(false);
                    this.JTPDatosAdicionales.setSelectedIndex(2);
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGrabar1ActionPerformed(ActionEvent evt) {
        mIniciarDx_Ingreso();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNCodigoDxPFocusLost(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNDxR1FocusLost(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNDxR2FocusLost(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNDxR3FocusLost(FocusEvent evt) {
    }

    private void cargarDxIngreso() {
        try {
            this.xsql = "SELECT\n    `g_patologia`.`Id`\n    , `g_patologia`.`Nbre`\n    , `h_atenciondx`.`Orden`\nFROM\n    `h_atenciondx`\n    INNER JOIN `g_patologia` \n        ON (`h_atenciondx`.`Id_Dx` = `g_patologia`.`Id`)\nWHERE (`h_atenciondx`.`Id_Atencion` =" + this.xidatencion + ")\nORDER BY `h_atenciondx`.`Orden` ASC;";
            ResultSet rs = this.xct.traerRs(this.xsql);
            if (rs.next()) {
                int x = JOptionPane.showConfirmDialog((Component) null, "Desea cargar diagnóstico de ingreso?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (x == 0) {
                    while (rs.next()) {
                        switch (rs.getInt("Orden")) {
                            case 1:
                                this.JTFCDxP.setText(rs.getString("Id"));
                                this.JTFNCodigoDxP.setText(rs.getString("Nbre"));
                                break;
                            case 2:
                                this.JTFCDxR1.setText(rs.getString("Id"));
                                this.JTFNDxR1.setText(rs.getString("Nbre"));
                                break;
                            case 3:
                                this.JTFCDxR2.setText(rs.getString("Id"));
                                this.JTFNDxR2.setText(rs.getString("Nbre"));
                                break;
                            default:
                                this.JTFCDxR3.setText(rs.getString("Id"));
                                this.JTFNDxR3.setText(rs.getString("Nbre"));
                                break;
                        }
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(JPEgresoUrgencias.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mGrabar() {
        System.out.println("entra a grabar");
        if (this.JLBNEgreso.getText().isEmpty()) {
            if (!this.JTFCDxP.getText().isEmpty()) {
                if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL SAN JOSE DE TIERRALTA") && !this.JTFCDxP.getText().startsWith("Z") && !this.JTFCDxP.getText().startsWith("R")) {
                    System.out.println("entra a donde es");
                    if (this.JCBTipoDx.getSelectedIndex() != -1) {
                        if (this.JCBDestino.getSelectedIndex() != -1) {
                            if (this.JRBEVivo.isSelected()) {
                                mGrabarD();
                                return;
                            }
                            if (this.JRBEMuerto.isSelected()) {
                                if (!this.JTFCDxR4.getText().isEmpty() && !this.JTFNDxR4.getText().isEmpty()) {
                                    mGrabarD();
                                    return;
                                } else {
                                    JOptionPane.showMessageDialog(this, "Debe digitar dx de muerte", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                    return;
                                }
                            }
                            return;
                        }
                        JOptionPane.showMessageDialog(this, "Debe seleccionar el motivo de salida", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        this.JCBDestino.requestFocus();
                        return;
                    }
                    JOptionPane.showMessageDialog(this, "Debe seleccionar un tipo de diagnostico", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    this.JCBTipoDx.requestFocus();
                    return;
                }
                if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL SAN JOSE DE TIERRALTA") && (this.JTFCDxP.getText().startsWith("Z") || this.JTFCDxP.getText().startsWith("R"))) {
                    JOptionPane.showMessageDialog(this, "El diagnostico principal debe ser diferente a (Z) o (R)", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    return;
                }
                if (this.JCBTipoDx.getSelectedIndex() != -1) {
                    if (this.JCBDestino.getSelectedIndex() != -1) {
                        if (this.JRBEVivo.isSelected()) {
                            mGrabarD();
                            return;
                        }
                        if (this.JRBEMuerto.isSelected()) {
                            if (!this.JTFCDxR4.getText().isEmpty() && !this.JTFNDxR4.getText().isEmpty()) {
                                mGrabarD();
                                return;
                            } else {
                                JOptionPane.showMessageDialog(this, "Debe digitar dx de muerte", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                return;
                            }
                        }
                        return;
                    }
                    JOptionPane.showMessageDialog(this, "Debe seleccionar el motivo de salida", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    this.JCBDestino.requestFocus();
                    return;
                }
                JOptionPane.showMessageDialog(this, "Debe seleccionar un tipo de diagnostico", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JCBTipoDx.requestFocus();
                return;
            }
            JOptionPane.showMessageDialog(this, "Falta digitar Dx principal", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFCDxP.requestFocus();
            return;
        }
        this.xsql = "update  h_egreso_atencion set `Id_TipoDx`='" + this.idTipoDX[this.JCBTipoDx.getSelectedIndex()] + "', `DxP`='" + this.JTFCDxP.getText() + "' , `NDxP`='" + this.JTFNCodigoDxP.getText() + "' , `DxR1`='" + this.JTFCDxR1.getText() + "' , `NDxR1`='" + this.JTFNDxR1.getText() + "' , `DxR2`='" + this.JTFCDxR2.getText() + "' , `NDxR2`='" + this.JTFNDxR2.getText() + "' , `DxR3`='" + this.JTFCDxR3.getText() + "' , `NDxR3`='" + this.JTFNDxR3.getText() + "' , `DxC`='" + this.JTFCDxC.getText() + "', `NDxC`='" + this.JTFNDxC.getText() + "' , `Id_Destino`='" + this.idDestino[this.JCBDestino.getSelectedIndex()] + "' , `EstodoS`='" + this.xestado + "' , `DxMuerte`='" + this.JTFCDxR4.getText() + "' , `NDxM`='" + this.JTFNDxR4.getText() + "', `FechaSO`='" + this.xmt.formatoAMD.format(this.JDCFechaS.getDate()) + "', `HoraSO`='" + this.xmt.formatoH24.format(this.JTFFHora.getValue()) + "',ObservacionG='" + this.JTAObservacion.getText() + "',ObservacionG1='" + this.JTAObservacion1.getText() + "' Where Id='" + this.JLBNEgreso.getText() + "' AND Id_Profesional='" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "' AND Id_Especialidad='" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "'";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        mBuscarEgreso();
    }

    private boolean validarFechaEgreso() {
        Boolean estado = false;
        try {
            String sql = "SELECT \ni.FechaIngreso,\nif(i.FechaIngreso>'" + this.xmt.formatoAMD1.format(this.JDCFechaS.getDate()) + "', 1,0) estado\nfrom ingreso i \nwhere i.Id=" + this.xidingreso + "";
            ResultSet rs = this.xct.traerRs(sql);
            if (rs.next()) {
                rs.first();
                estado = Boolean.valueOf(rs.getBoolean("estado"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(JPEgresoUrgencias.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return estado.booleanValue();
    }

    private void mGrabarD() {
        if (!validarFechaEgreso()) {
            int x = JOptionPane.showConfirmDialog((Component) null, "Esta seguro de grabar y cerrar la historia?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                if (getName().equals("xEgresoHC")) {
                    if (verificarNotaDeEgreso().booleanValue()) {
                        if (mVerificarValidaciones()[0]) {
                            if (mVerificarValidaciones()[1]) {
                                if (!clasesHistoriaCE.informacionAgendaMedicaDTO.getMotivoConsulta().equals("null")) {
                                    this.xsql = "insert into h_egreso_atencion(`Id_Ingreso`, `Id_Atencion`, `Id_Tipo`,`Id_TipoDx`, `DxP` , `NDxP` , `DxR1` , `NDxR1` , `DxR2` , `NDxR2` , `DxR3` , `NDxR3` , `DxC`, `NDxC`,  `Id_Destino` , `EstodoS` , `DxMuerte` , `NDxM`, `FechaSO`, `HoraSO`,ObservacionG,ObservacionG1, `Id_Profesional` , `Id_Especialidad`, `UsuarioS`) values('" + this.xidingreso + "','" + this.xidatencion + "','" + this.xId_Tipo + "','" + this.idTipoDX[this.JCBTipoDx.getSelectedIndex()] + "','" + this.JTFCDxP.getText() + "','" + this.JTFNCodigoDxP.getText() + "','" + this.JTFCDxR1.getText() + "','" + this.JTFNDxR1.getText() + "','" + this.JTFCDxR2.getText() + "','" + this.JTFNDxR2.getText() + "','" + this.JTFCDxR3.getText() + "','" + this.JTFNDxR3.getText() + "','" + this.JTFCDxC.getText() + "','" + this.JTFNDxC.getText() + "','" + this.idDestino[this.JCBDestino.getSelectedIndex()] + "','" + this.xestado + "','" + this.JTFCDxR4.getText() + "','" + this.JTFNDxR4.getText() + "','" + this.xmt.formatoAMD.format(this.JDCFechaS.getDate()) + "','" + this.xmt.formatoH24.format(this.JTFFHora.getValue()) + "','" + this.JTAObservacion.getText() + "','" + this.JTAObservacion1.getText() + "','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "','" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                                    this.JLBNEgreso.setText(this.xct.ejecutarSQLId(this.xsql));
                                    this.xct.cerrarConexionBd();
                                    System.out.println("IdTipoAntecion: " + this.xId_Tipo);
                                    switch (this.xId_Tipo) {
                                        case 1:
                                            this.xsql = "update `h_atencion` set `InicioAtencion`=1, h_atencion.TipoGuardado=1 where Id='" + this.xidatencion + "'";
                                            this.xct.ejecutarSQL(this.xsql);
                                            this.xct.cerrarConexionBd();
                                            Principal.clasehistoriace.mCambiarEstadoCita();
                                            mCambiaTiipoAtencion();
                                            mBuscarEgreso();
                                            this.JBTGrabar.setEnabled(false);
                                            break;
                                        case 3:
                                            this.xsql = "update `h_atencion` set `InicioAtencion`=1, h_atencion.TipoGuardado=1  where Id='" + this.xidatencion + "'";
                                            this.xct.ejecutarSQL(this.xsql);
                                            this.xct.cerrarConexionBd();
                                            Principal.clasehistoriace.mCambiarEstadoCita();
                                            this.JBTGrabar.setEnabled(false);
                                            if (Principal.informacionIps.getNombreIps().equals("FUNDACIÓN PANZENÚ")) {
                                                this.xsql = "update `ingreso` set `Egreso`=1 , `FEgreso`='" + this.xmt.formatoAMD.format(this.JDCFechaS.getDate()) + "' where Id='" + this.xidingreso + "'";
                                                this.xct.ejecutarSQL(this.xsql);
                                                this.xct.cerrarConexionBd();
                                            }
                                            break;
                                    }
                                    String sql = "UPDATE h_orden_hospitalizacion_traslado, (\nSELECT\n    `h_orden_hospitalizacion_traslado`.`Id`\n    , `h_orden_hospitalizacion_traslado`.`Id_CamaOrigen`\n    , h_orden_hospitalizacion_traslado.`Fecha_Ingreso`\n    , `h_orden_hospitalizacion_traslado`.`Fecha_Egreso`\n    , IFNULL(`h_orden_hospitalizacion_traslado`.`Id_CamaDestino`,0) Id_CamaDestino \nFROM\n   `h_orden_hospitalizacion_traslado`\n    INNER JOIN`h_orden_hospitalizacion` \n        ON (`h_orden_hospitalizacion_traslado`.`IdOrdenHosp` = `h_orden_hospitalizacion`.`Id`)\n    INNER JOIN`h_atencion` \n        ON (`h_orden_hospitalizacion`.`Id_Atencion` = `h_atencion`.`Id`)\n    INNER JOIN`ingreso` \n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\nWHERE (`h_atencion`.`Id` =" + this.xidatencion + " AND  `h_orden_hospitalizacion_traslado`.`Id_CamaDestino` IS NULL )\n\n) d\nSET h_orden_hospitalizacion_traslado.`Id_CamaDestino`=d.Id_CamaDestino,\nh_orden_hospitalizacion_traslado.`Fecha_Egreso`=NOW(),\nh_orden_hospitalizacion_traslado.`NDias`= DATEDIFF(NOW(), h_orden_hospitalizacion_traslado.`Fecha_Ingreso`) ,\nh_orden_hospitalizacion_traslado.`Id_Especialidad`='" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "' , \nh_orden_hospitalizacion_traslado.`Id_Profesional`='" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "'\nWHERE h_orden_hospitalizacion_traslado.`Id`=d.Id";
                                    System.out.println("Actualizo h_orden_hospitalizacion_traslado-->" + sql);
                                    this.xct.ejecutarSQL(sql);
                                    this.xct.cerrarConexionBd();
                                    this.xsql = "UPDATE `f_camas`, ingreso SET f_camas.`Disponible`=0 WHERE f_camas.`Id`=ingreso.`Cama` AND ingreso.`Id`='" + this.xidingreso + "' ";
                                    this.xct.ejecutarSQL(this.xsql);
                                    this.xct.cerrarConexionBd();
                                    return;
                                }
                                JOptionPane.showMessageDialog(this, "Motivo de consulta no puede ser nulo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                return;
                            }
                            JOptionPane.showMessageDialog(this, "Debe llenar el Diagnostico para proseguir", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                            return;
                        }
                        JOptionPane.showMessageDialog(this, "Debe llenar el Motivo Consulta y EA para proseguir", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        return;
                    }
                    JOptionPane.showMessageDialog(this, "Debe tener una nota de egreso", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    return;
                }
                try {
                    this.xsql = "SELECT  `Id_Especialidad` , `Id_Profesional` FROM  `ingreso` WHERE (`Id` ='" + this.xidingreso + "' AND `Estado` =0) ";
                    ConsultasMySQL xct1 = new ConsultasMySQL();
                    ResultSet xrs = xct1.traerRs(this.xsql);
                    String xid_espe = null;
                    String xid_prof = null;
                    if (xrs.next()) {
                        xid_espe = xrs.getString(1);
                        xid_prof = xrs.getString(2);
                    }
                    this.xsql = "insert into h_egreso_atencion(`Id_Ingreso`, `Id_Atencion`, `Id_Tipo`,`Id_TipoDx`, `DxP` , `NDxP` , `DxR1` , `NDxR1` , `DxR2` , `NDxR2` , `DxR3` , `NDxR3` , `DxC`, `NDxC` , `Id_Destino` , `EstodoS` , `DxMuerte` , `NDxM`, `FechaSO`, `HoraSO`,ObservacionG, ObservacionG1,`Id_Especialidad`,`Id_Profesional` ,  `UsuarioS`) values('" + this.xidingreso + "','" + this.xidatencion + "','" + this.xId_Tipo + "','" + this.idTipoDX[this.JCBTipoDx.getSelectedIndex()] + "','" + this.JTFCDxP.getText() + "','" + this.JTFNCodigoDxP.getText() + "','" + this.JTFCDxR1.getText() + "','" + this.JTFNDxR1.getText() + "','" + this.JTFCDxR2.getText() + "','" + this.JTFNDxR2.getText() + "','" + this.JTFCDxR3.getText() + "','" + this.JTFNDxR3.getText() + "','" + this.JTFCDxC.getText() + "','" + this.JTFNDxC.getText() + "','" + this.idDestino[this.JCBDestino.getSelectedIndex()] + "','" + this.xestado + "','" + this.JTFCDxR4.getText() + "','" + this.JTFNDxR4.getText() + "','" + this.xmt.formatoAMD.format(this.JDCFechaS.getDate()) + "','" + this.xmt.formatoH24.format(this.JTFFHora.getValue()) + "','" + this.JTAObservacion.getText() + "','" + this.JTAObservacion1.getText() + "','" + xid_espe + "','" + xid_prof + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                    this.JLBNEgreso.setText(this.xct.ejecutarSQLId(this.xsql));
                    mCambiaTiipoAtencion();
                    mActualizarDIngresos(1, this.xmt.formatoAMD.format(this.JDCFechaS.getDate()), 1);
                    mBuscarEgreso();
                    if (Principal.informacionIps.getNombreIps().equals("MEDICAL HOMECARE S.A.S.")) {
                        mInsartarDxConsultaRips();
                    }
                    return;
                } catch (SQLException ex) {
                    Logger.getLogger(JPEgresoUrgencias.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                    return;
                }
            }
            return;
        }
        JOptionPane.showMessageDialog(this, "Fecha de egreso no puede ser menor a la fecha de ingreso", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JDCFechaS.setDate(this.xmt.getFechaActual());
    }

    private void mInsartarDxConsultaRips() {
        this.xsql = "INSERT INTO f_itemripsconsulta (\n  Id_Ordenes,\n  Id_Procedimiento,\n  Id_TipoDx,\n  Id_DxPrincipal\n  \n)    \n    SELECT\n     f_ordenes . Id  AS  idorden \n    ,  g_procedimiento . Id  AS  idprocedieminto \n    , h_egreso_atencion.Id_TipoDx    \n    ,  h_egreso_atencion.DxP\n    \n    FROM\n    f_ordenes \n    INNER JOIN  ingreso ON ( f_ordenes . Id_Ingreso  =  ingreso . Id )\n    INNER JOIN  f_itemordenesproced ON ( f_itemordenesproced . Id_Ordenes  =  f_ordenes . Id )\n    INNER JOIN  g_procedimiento    ON ( f_itemordenesproced . Id_Procedimiento  =  g_procedimiento . Id )\n    INNER JOIN  f_tipoprocrips     ON ( g_procedimiento . Id_TipoProcRIPS  =  f_tipoprocrips . Id )\n    LEFT JOIN   h_egreso_atencion  ON ( h_egreso_atencion . Id_Ingreso  =  ingreso . Id )\n    WHERE  f_tipoprocrips . Id  =5  AND  ingreso . Id  ='" + this.xidingreso + "' ";
        System.err.println("sql" + this.xsql);
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
    }

    private void mCambiaTiipoAtencion() {
        if (this.idDestino[this.JCBDestino.getSelectedIndex()].equals("3")) {
            this.xsql = "update ingreso set Id_TipoAtencion=2, Egreso_H=0, FEgreso_H=null, HEgreso_H=null where Id='" + this.xidingreso + "'";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
        }
    }

    private void mNuevo() {
        this.xlleno = false;
        this.JLBNEgreso.setText("");
        this.JDCFechaS.setDate(this.xmt.getFechaActual());
        this.JTFFHora.setValue(this.xmt.getFechaActual());
        this.JCBDestino.removeAllItems();
        this.idDestino = this.xct.llenarCombo("SELECT `Id`, `Nbre` FROM `g_tipodestino` WHERE (`Estado` =1) ORDER BY `Nbre` ASC;", this.idDestino, this.JCBDestino);
        this.JCBDestino.setSelectedIndex(-1);
        this.JCBTipoDx.removeAllItems();
        this.idTipoDX = this.xct.llenarCombo("SELECT Id, Nbre FROM h_tipodiagnostico ORDER BY Nbre ASC", this.idTipoDX, this.JCBTipoDx);
        this.JCBTipoDx.setSelectedIndex(-1);
        this.JBTGHospitalizacion.setEnabled(false);
        this.xct.cerrarConexionBd();
        this.xlleno = true;
    }

    private void mBuscarEgreso() {
        try {
            if (getName().equals("xEgresoHC")) {
                this.xsql = "SELECT\n  `h_egreso_atencion`.`Id`,\n  `h_egreso_atencion`.`FechaSO`,\n  `h_egreso_atencion`.`HoraSO`,\n  `h_tipodiagnostico`.`Nbre` AS TipoDx,\n  `h_egreso_atencion`.`DxP`,\n  `h_egreso_atencion`.`NDxP`,\n  `h_egreso_atencion`.`DxR1`,\n  `h_egreso_atencion`.`NDxR1`,\n  `h_egreso_atencion`.`DxR2`,\n  `h_egreso_atencion`.`NDxR2`,\n  `h_egreso_atencion`.`DxR3`,\n  `h_egreso_atencion`.`NDxR3`,\n  `g_tipodestino`.`Nbre` AS Destino,\n  `h_egreso_atencion`.`EstodoS`,\n  `h_egreso_atencion`.`DxMuerte`,\n  `h_egreso_atencion`.`NDxM`,\n  `h_egreso_atencion`.`ObservacionG`,\n  `h_egreso_atencion`.`Estado`,\n  `h_egreso_atencion`.`DxC`,\n  `h_egreso_atencion`.`NDxC`,\n   h_atencion.TipoGuardado,\n  `h_egreso_atencion`.`ObservacionG1`\nFROM\n  `h_egreso_atencion`\n  INNER JOIN `h_atencion`\n    ON (`h_egreso_atencion`.`Id_Atencion` = `h_atencion`.`Id`)\n  INNER JOIN `g_tipodestino` \n    ON (`g_tipodestino`.`Id`=h_egreso_atencion.`Id_Destino`)\n  INNER JOIN `h_tipodiagnostico`\n    ON (h_tipodiagnostico.`Id`=h_egreso_atencion.`Id_TipoDx`)\nWHERE (\n    `h_egreso_atencion`.`Id_Atencion` = '" + this.xidatencion + "'\n    AND `h_egreso_atencion`.`Estado` = 1\n    AND `h_egreso_atencion`.Id_Tipo = '" + this.xId_Tipo + "'\n  )";
            } else {
                this.xsql = "SELECT\n  `h_egreso_atencion`.`Id`,\n  `h_egreso_atencion`.`FechaSO`,\n  `h_egreso_atencion`.`HoraSO`,\n  `h_tipodiagnostico`.`Nbre` AS TipoDx,\n  `h_egreso_atencion`.`DxP`,\n  `h_egreso_atencion`.`NDxP`,\n  `h_egreso_atencion`.`DxR1`,\n  `h_egreso_atencion`.`NDxR1`,\n  `h_egreso_atencion`.`DxR2`,\n  `h_egreso_atencion`.`NDxR2`,\n  `h_egreso_atencion`.`DxR3`,\n  `h_egreso_atencion`.`NDxR3`,\n  `h_egreso_atencion`.`Id_Destino`,\n  `h_egreso_atencion`.`EstodoS`,\n  `h_egreso_atencion`.`DxMuerte`,\n  `h_egreso_atencion`.`NDxM`,\n  `h_egreso_atencion`.`ObservacionG`,\n  `h_egreso_atencion`.`Estado`,\n  `h_egreso_atencion`.`DxC`,\n  `h_egreso_atencion`.`NDxC`,\n   h_atencion.TipoGuardado,\n  `h_egreso_atencion`.`ObservacionG1`\nFROM\n  `h_egreso_atencion`\n  LEFT JOIN `h_atencion`\n    ON (`h_egreso_atencion`.`Id_Atencion` = `h_atencion`.`Id`)\n  INNER JOIN `g_tipodestino` \n    ON (`g_tipodestino`.`Id`=h_egreso_atencion.`Id_Destino`)\n  INNER JOIN `h_tipodiagnostico`\n    ON (h_tipodiagnostico.`Id`=h_egreso_atencion.`Id_TipoDx`)\nWHERE (\n    `h_egreso_atencion`.`Id_Ingreso` = '" + this.xidingreso + "'\n    AND `h_egreso_atencion`.`Estado` = 1\n    AND `h_egreso_atencion`.Id_Tipo = '" + this.xId_Tipo + "'\n  )";
            }
            System.out.println(this.xsql);
            ResultSet xrs = this.xct.traerRs(this.xsql);
            Throwable th = null;
            try {
                if (xrs.next()) {
                    xrs.first();
                    this.JLBNEgreso.setText(xrs.getString(1));
                    this.JDCFechaS.setDate(xrs.getDate(2));
                    this.JTFFHora.setValue(xrs.getTime(3));
                    this.JCBTipoDx.setSelectedItem(xrs.getString(4));
                    this.JTFCDxP.setText(xrs.getString(5));
                    this.JTFNCodigoDxP.setText(xrs.getString(6));
                    this.JTFCDxR1.setText(xrs.getString(7));
                    this.JTFNDxR1.setText(xrs.getString(8));
                    this.JTFCDxR2.setText(xrs.getString(9));
                    this.JTFNDxR2.setText(xrs.getString(10));
                    this.JTFCDxR3.setText(xrs.getString(11));
                    this.JTFNDxR3.setText(xrs.getString(12));
                    this.JTFCDxC.setText(xrs.getString("DxC"));
                    this.JTFNDxC.setText(xrs.getString("NDxC"));
                    this.JCBDestino.setSelectedIndex(Integer.parseInt(xrs.getString(13)));
                    if (xrs.getInt(14) == 1) {
                        this.JRBEVivo.setSelected(true);
                    } else {
                        this.JRBEMuerto.setSelected(true);
                    }
                    this.JTFCDxR4.setText(xrs.getString(15));
                    this.JTFNDxR4.setText(xrs.getString(16));
                    this.JTAObservacion.setText(xrs.getString(16));
                    this.JTAObservacion1.setText(xrs.getString("ObservacionG1"));
                    if (xrs.getInt("TipoGuardado") == 0) {
                        this.JBTGrabar.setEnabled(true);
                        this.xEstado = 0;
                    } else {
                        this.JBTGrabar.setEnabled(false);
                        this.xEstado = 1;
                    }
                    mCambio_EstadoBoton();
                } else {
                    mIniciarDx_Ingreso();
                }
                if (xrs != null) {
                    if (0 != 0) {
                        try {
                            xrs.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    } else {
                        xrs.close();
                    }
                }
                this.xct.cerrarConexionBd();
            } finally {
            }
        } catch (SQLException ex) {
            Logger.getLogger(JPEgresoUrgencias.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mActualizarDIngresos(int xestado, String xFecha, int xforma) {
        if (this.xId_Tipo == 3) {
            if (xforma == 0) {
                this.xsql = "update `ingreso` set `Egreso`='" + xestado + "' , `FEgreso`=NULL where Id='" + this.xidingreso + "'";
            } else {
                this.xsql = "update `ingreso` set `Egreso`='" + xestado + "' , `FEgreso`='" + xFecha + "' where Id='" + this.xidingreso + "'";
            }
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            return;
        }
        if (this.xId_Tipo == 2) {
            if (xforma == 0) {
                this.xsql = "update `ingreso` set `Egreso_H`='" + xestado + "' , `FEgreso_H`=NULL where Id='" + this.xidingreso + "'";
            } else {
                this.xsql = "update `ingreso` set `Egreso_H`='" + xestado + "' , `FEgreso_H`='" + xFecha + "' where Id='" + this.xidingreso + "'";
            }
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
        }
    }

    public void mAnular() {
        if (getName().equals("xEgresoFact")) {
            if (Principal.clasefacturacion.xjiliqServicio.getxId_Liqidacion() == 0) {
                if (!this.JLBNEgreso.getText().isEmpty()) {
                    int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de anular?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    if (x == 0) {
                        Anular frm = new Anular(null, true, "FacturacionUH_Egreso", 5);
                        frm.setVisible(true);
                        return;
                    }
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Ingreso con liquidación activa;\nNo se puede anular el registro", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
    }

    public void mAnular(String xid, String xdetalle) {
        this.xsql = "update h_egreso_atencion set `Estado`=0, `Id_MotivoAnulacion`='" + xid + "', `Detalle_Anulacion`='" + xdetalle + "', `Usuario_Anulacion`='" + Principal.usuarioSistemaDTO.getNombreUsuario() + "', `Fecha_Anulacion`='" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "' where Id='" + this.JLBNEgreso.getText() + "'";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        mActualizarDIngresos(0, "NULL", 0);
        mBuscarEgreso();
    }

    private boolean[] mVerificarValidaciones() {
        boolean[] xestado = new boolean[3];
        if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL SAN JOSE DE TIERRALTA")) {
            if (this.triage.intValue() < 5) {
                try {
                    ConsultasMySQL xct = new ConsultasMySQL();
                    String xsql1 = "SELECT  Motivo_Atencion ,  EActual ,  Id FROM h_atencion WHERE (Id ='" + this.xidatencion + "' AND (Motivo_Atencion  <>'' AND  EActual  <>''))";
                    ResultSet xrs1 = xct.traerRs(xsql1);
                    if (xrs1.next()) {
                        xestado[0] = true;
                    } else {
                        xestado[0] = false;
                    }
                    xrs1.close();
                    xct.cerrarConexionBd();
                    String xsql2 = "SELECT `Codigo_Dxp` , `Id` FROM `h_atencion` WHERE (`Codigo_Dxp` <>'' AND `Id` ='" + this.xidatencion + "') ";
                    ResultSet xrs2 = xct.traerRs(xsql2);
                    if (xrs2.next()) {
                        xestado[1] = true;
                    } else {
                        xestado[1] = false;
                    }
                    xrs2.close();
                    xct.cerrarConexionBd();
                } catch (SQLException ex) {
                    Logger.getLogger(JIFHistoriaClinica.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                }
                return xestado;
            }
            xestado[0] = true;
            xestado[1] = true;
            return xestado;
        }
        try {
            ConsultasMySQL xct2 = new ConsultasMySQL();
            String xsql12 = "SELECT  Motivo_Atencion ,  EActual ,  Id FROM h_atencion WHERE (Id ='" + this.xidatencion + "' AND (Motivo_Atencion  <>'' AND  EActual  <>''))";
            ResultSet xrs12 = xct2.traerRs(xsql12);
            if (xrs12.next()) {
                xestado[0] = true;
            } else {
                xestado[0] = false;
            }
            xrs12.close();
            xct2.cerrarConexionBd();
            String xsql22 = "SELECT `Codigo_Dxp` , `Id` FROM `h_atencion` WHERE (`Codigo_Dxp` <>'' AND `Id` ='" + this.xidatencion + "') ";
            ResultSet xrs22 = xct2.traerRs(xsql22);
            if (xrs22.next()) {
                xestado[1] = true;
            } else {
                xestado[1] = false;
            }
            xrs22.close();
            xct2.cerrarConexionBd();
        } catch (SQLException ex2) {
            Logger.getLogger(JIFHistoriaClinica.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex2);
        }
        return xestado;
    }

    private void mCambio_EstadoBoton() {
        if (this.xEstado == 1) {
            this.JBAbrir_Hc.setText("Abrir Hc");
        } else {
            this.JBAbrir_Hc.setText("Cerrar Hc");
        }
    }

    private void mIniciarDx_Ingreso() {
        if (this.JLBNEgreso.getText().isEmpty()) {
            int x = JOptionPane.showConfirmDialog((Component) null, "Desea cargar diagnóstico de ingreso?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                try {
                    this.xsql = "SELECT IF(`g_patologia`.`Id` IS NULL , '',`g_patologia`.`Id`)  AS `CDxP` , IF(`g_patologia`.`Id` IS NULL , '',`g_patologia`.`Nbre`) AS `NDxP` ,  IF(`g_patologia_1`.`Id` IS NULL , '',`g_patologia_1`.`Id`) AS `CDxR1` ,  IF(`g_patologia_1`.`Id` IS NULL , '',`g_patologia_1`.`Nbre`) AS `NDxR1` ,  IF(`g_patologia_2`.`Id` IS NULL , '',`g_patologia_2`.`Id`) AS `CDxR2` , IF(`g_patologia_2`.`Id` IS NULL , '',`g_patologia_2`.`Nbre`) AS `NDxR2` , IF(`g_patologia_3`.`Id` IS NULL , '',`g_patologia_3`.`Id`) AS `CDxR3` , IF(`g_patologia_3`.`Id` IS NULL , '',`g_patologia_3`.`Nbre`) AS `NDxR3` FROM `g_patologia` INNER JOIN  `h_atencion`   ON (`g_patologia`.`Id` = `h_atencion`.`Codigo_Dxp`) LEFT JOIN  `g_patologia` AS `g_patologia_1`   ON (`g_patologia_1`.`Id` = `h_atencion`.`Codigo_DxR1`) LEFT JOIN  `g_patologia` AS `g_patologia_2`   ON (`g_patologia_2`.`Id` = `h_atencion`.`Codigo_DxR2`)  LEFT JOIN  `g_patologia` AS `g_patologia_3`  ON (`g_patologia_3`.`Id` = `h_atencion`.`Codigo_DxR3`) WHERE (`h_atencion`.`Id` ='" + this.xidatencion + "') ";
                    ResultSet xrs = this.xct.traerRs(this.xsql);
                    if (xrs.next()) {
                        xrs.first();
                        this.JTFCDxP.setText(xrs.getString(1));
                        this.JTFNCodigoDxP.setText(xrs.getString(2));
                        this.JTFCDxR1.setText(xrs.getString(3));
                        this.JTFNDxR1.setText(xrs.getString(4));
                        this.JTFCDxR2.setText(xrs.getString(5));
                        this.JTFNDxR2.setText(xrs.getString(6));
                        this.JTFCDxR3.setText(xrs.getString(7));
                        this.JTFNDxR3.setText(xrs.getString(8));
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(JPEgresoUrgencias.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                }
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [javax.swing.JTextField[], javax.swing.JTextField[][]] */
    private boolean validacionDiagnosticos() {
        boolean resultado = Metodos.validacionTextfieldXArray(new JTextField[]{new JTextField[]{this.JTFCDxP, this.JTFNCodigoDxP}, new JTextField[]{this.JTFCDxR1, this.JTFNDxR1}, new JTextField[]{this.JTFCDxR2, this.JTFNDxR2}, new JTextField[]{this.JTFCDxR3, this.JTFNDxR3}, new JTextField[]{this.JTFCDxR4, this.JTFNDxR4}});
        if (!resultado) {
            JOptionPane.showMessageDialog(this, "Diagnósticos Repetidos, Por favor Cambiar Diagnóstico", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
        return resultado;
    }
}
