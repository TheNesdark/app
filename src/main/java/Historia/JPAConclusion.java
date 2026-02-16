package Historia;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Email;
import Utilidades.Metodos;
import Utilidades.corrector.jortho.FileUserDictionary;
import Utilidades.corrector.jortho.SpellChecker;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
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
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.border.SoftBevelBorder;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.text.DateFormatter;
import javax.swing.text.DefaultFormatterFactory;

/* JADX INFO: loaded from: GenomaP.jar:Historia/JPAConclusion.class */
public class JPAConclusion extends JPanel {
    private String[] idtipodx;
    private String[] idTipoServicio;
    private String[] idDestino;
    private clasesHistoriaCE xclase;
    private int xEstado;
    private ButtonGroup JBGDestino;
    private JButton JBTGuardar;
    private JButton JBT_AbrirHC;
    private JButton JBT_NotaP;
    private JComboBox JCBServicios;
    private JComboBox JCBTipoDestino;
    private JComboBox JCBTipoDx;
    private JDateChooser JDCFechaS;
    private JLabel JLBNEgreso;
    private JLabel JLBTDxRelacionados;
    private JPanel JPCie10Muerte;
    private JPanel JPIConclusion;
    private JPanel JPIConclusionAtencion;
    private JPanel JPIDestino;
    private JPanel JPIDiagnositicos;
    private JPanel JPIDxConclusion;
    private JPanel JPIDx_Complicacion;
    private JPanel JPIEstado;
    private JPanel JPIRecomendaciones;
    private JRadioButton JRBDAUrgencias;
    private JRadioButton JRBDHospitalizacion;
    private JRadioButton JRBDRemision;
    private JRadioButton JRBEMuerto;
    private JRadioButton JRBEVivo;
    private JScrollPane JSPEor;
    private JScrollPane JSPRecomendaciones;
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
    private JTextPane JTPConclusion;
    private JTabbedPane JTPDatosAdicionales;
    private JTextPane JTPRecomendaciones;
    private ButtonGroup jbgEstadoPaciente;
    private ConsultasMySQL xconsultasbd = new ConsultasMySQL();
    private Metodos xmetodo = new Metodos();
    private int xdestino = 1;
    private boolean xEncontrado = false;
    private int estadoPaciente = 1;

    public JPAConclusion(clasesHistoriaCE xclase) {
        this.xEstado = 0;
        initComponents();
        this.JCBServicios.setVisible(false);
        this.JCBTipoDestino.setVisible(false);
        this.JLBNEgreso.setVisible(false);
        this.JDCFechaS.setVisible(false);
        this.JTFFHora.setVisible(false);
        this.JTPDatosAdicionales.setVisible(false);
        this.xconsultasbd.cerrarConexionBd();
        this.xclase = xclase;
        SpellChecker.setUserDictionaryProvider(new FileUserDictionary());
        SpellChecker.registerDictionaries(null, null);
        SpellChecker.register(this.JTPConclusion);
        SpellChecker.register(this.JTPRecomendaciones);
        this.idtipodx = this.xconsultasbd.llenarCombo("SELECT Id, Nbre FROM h_tipodiagnostico ORDER BY Nbre ASC", this.idtipodx, this.JCBTipoDx);
        this.xconsultasbd.cerrarConexionBd();
        if (Principal.informacionIps.getNombreIps().equals("CLINICA OFTALMOLOGICA DAJUD SAS")) {
            this.JPIRecomendaciones.setBorder(BorderFactory.createTitledBorder((Border) null, "RECOMENDACIONES Y/O DECLARATORÍA DE RIESGO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        } else {
            this.JPIRecomendaciones.setBorder(BorderFactory.createTitledBorder((Border) null, "RECOMENDACIONES", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        }
        if (Principal.informacionIps.getEsFpz().intValue() == 0 || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL LOCAL DE MONTELIBANO") || Principal.informacionIps.getIdentificacion().equals("812005644") || Principal.informacionIps.getIdentificacion().equals("900304530") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO CAMU DIVINO NIÑO")) {
            this.JBT_AbrirHC.setVisible(false);
        }
        if (Principal.informacionIps.getNombreIps().equals("CLINICA LAURELES PSIQUIATRAS ASOCIADOS I.P.S. S.A.S.") || Principal.informacionIps.getNombreIps().equals("UNION TEMPORAL CLINICA LAURELES")) {
            this.JDCFechaS.setDate(this.xmetodo.getFechaActual());
            this.JTFFHora.setValue(this.xmetodo.getFechaActual());
            this.JCBServicios.setVisible(true);
            this.JCBTipoDestino.setVisible(true);
            this.JLBNEgreso.setVisible(true);
            this.JRBDRemision.setVisible(false);
            this.JDCFechaS.setVisible(true);
            this.JTFFHora.setVisible(true);
            this.JTPDatosAdicionales.setVisible(true);
            this.JBGDestino.clearSelection();
            this.JRBDHospitalizacion.setText("Ingresar a otro Servicio");
            this.idTipoServicio = this.xconsultasbd.llenarCombo("SELECT id,nbre FROM g_tipoatencion WHERE estado=0 AND id>1 and id <>'" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTipoAtencion() + "' ORDER BY nbre ASC", this.idTipoServicio, this.JCBServicios);
            this.JCBServicios.setSelectedIndex(-1);
            this.xconsultasbd.cerrarConexionBd();
            this.idDestino = this.xconsultasbd.llenarCombo("SELECT id,nbre FROM`g_tipodestino` WHERE estado=1  ORDER BY nbre ASC", this.idDestino, this.JCBTipoDestino);
            this.JCBTipoDestino.setSelectedIndex(-1);
            this.xconsultasbd.cerrarConexionBd();
            if (clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTipoAtencion().intValue() > 1) {
                this.JPIRecomendaciones.setBorder(BorderFactory.createTitledBorder((Border) null, "ESTADO DEL USUARIO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
                this.JPIConclusionAtencion.setBorder(BorderFactory.createTitledBorder((Border) null, "RECOMENDACIONES GENERALES", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
                this.JCBTipoDestino.setEnabled(true);
                buscarEgreso();
            } else {
                mBuscarDatosBd();
            }
        }
        if (!Principal.informacionIps.getNombreIps().equals("CLINICA LAURELES PSIQUIATRAS ASOCIADOS I.P.S. S.A.S.") && !Principal.informacionIps.getNombreIps().equals("UNION TEMPORAL CLINICA LAURELES")) {
            mBuscarDatosBd();
        }
        if (getTipoGuardado() != 1) {
            this.JBTGuardar.setEnabled(true);
            clasesHistoriaCE.informacionAgendaMedicaDTO.setTipoGuardado(0);
            this.xEstado = 0;
        } else {
            this.JBTGuardar.setEnabled(false);
            clasesHistoriaCE.informacionAgendaMedicaDTO.setTipoGuardado(1);
            this.xEstado = 1;
        }
        mCambio_EstadoBoton();
    }

    private void initComponents() {
        this.JBGDestino = new ButtonGroup();
        this.jbgEstadoPaciente = new ButtonGroup();
        this.JPIConclusion = new JPanel();
        this.JPIDxConclusion = new JPanel();
        this.JCBTipoDx = new JComboBox();
        this.JTFCDxR1 = new JTextField();
        this.JTFNDxR1 = new JTextField();
        this.JLBTDxRelacionados = new JLabel();
        this.JTFCDxR2 = new JTextField();
        this.JTFNDxR2 = new JTextField();
        this.JTFCDxR3 = new JTextField();
        this.JTFNDxR3 = new JTextField();
        this.JTFCDxP = new JTextField();
        this.JTFNCodigoDxP = new JTextField();
        this.JPIConclusionAtencion = new JPanel();
        this.JSPEor = new JScrollPane();
        this.JTPConclusion = new JTextPane();
        this.JPIRecomendaciones = new JPanel();
        this.JSPRecomendaciones = new JScrollPane();
        this.JTPRecomendaciones = new JTextPane();
        this.JCBServicios = new JComboBox();
        this.JCBTipoDestino = new JComboBox();
        this.JLBNEgreso = new JLabel();
        this.JTPDatosAdicionales = new JTabbedPane();
        this.JPIDiagnositicos = new JPanel();
        this.JPIDx_Complicacion = new JPanel();
        this.JTFCDxC = new JTextField();
        this.JTFNDxC = new JTextField();
        this.JPIEstado = new JPanel();
        this.JRBEVivo = new JRadioButton();
        this.JRBEMuerto = new JRadioButton();
        this.JPCie10Muerte = new JPanel();
        this.JTFCDxR4 = new JTextField();
        this.JTFNDxR4 = new JTextField();
        this.JTFFHora = new JFormattedTextField();
        this.JDCFechaS = new JDateChooser();
        this.JBTGuardar = new JButton();
        this.JBT_NotaP = new JButton();
        this.JBT_AbrirHC = new JButton();
        this.JPIDestino = new JPanel();
        this.JRBDAUrgencias = new JRadioButton();
        this.JRBDRemision = new JRadioButton();
        this.JRBDHospitalizacion = new JRadioButton();
        setName("jpconclusiones1");
        addAncestorListener(new AncestorListener() { // from class: Historia.JPAConclusion.1
            public void ancestorMoved(AncestorEvent evt) {
            }

            public void ancestorAdded(AncestorEvent evt) {
            }

            public void ancestorRemoved(AncestorEvent evt) {
                JPAConclusion.this.formAncestorRemoved(evt);
            }
        });
        this.JPIDxConclusion.setBorder(BorderFactory.createTitledBorder((Border) null, "DIAGNÓSTICO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JCBTipoDx.setFont(new Font("Arial", 1, 12));
        this.JCBTipoDx.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Dx", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JCBTipoDx.addKeyListener(new KeyAdapter() { // from class: Historia.JPAConclusion.2
            public void keyPressed(KeyEvent evt) {
                JPAConclusion.this.JCBTipoDxKeyPressed(evt);
            }
        });
        this.JTFCDxR1.setFont(new Font("Arial", 1, 12));
        this.JTFCDxR1.addFocusListener(new FocusAdapter() { // from class: Historia.JPAConclusion.3
            public void focusLost(FocusEvent evt) {
                JPAConclusion.this.JTFCDxR1FocusLost(evt);
            }
        });
        this.JTFCDxR1.addKeyListener(new KeyAdapter() { // from class: Historia.JPAConclusion.4
            public void keyPressed(KeyEvent evt) {
                JPAConclusion.this.JTFCDxR1KeyPressed(evt);
            }
        });
        this.JTFNDxR1.setFont(new Font("Arial", 1, 12));
        this.JTFNDxR1.addMouseListener(new MouseAdapter() { // from class: Historia.JPAConclusion.5
            public void mouseClicked(MouseEvent evt) {
                JPAConclusion.this.JTFNDxR1MouseClicked(evt);
            }
        });
        this.JTFNDxR1.addKeyListener(new KeyAdapter() { // from class: Historia.JPAConclusion.6
            public void keyPressed(KeyEvent evt) {
                JPAConclusion.this.JTFNDxR1KeyPressed(evt);
            }
        });
        this.JLBTDxRelacionados.setBackground(new Color(0, 0, 153));
        this.JLBTDxRelacionados.setFont(new Font("Bell MT", 1, 14));
        this.JLBTDxRelacionados.setForeground(new Color(204, 255, 255));
        this.JLBTDxRelacionados.setHorizontalAlignment(0);
        this.JLBTDxRelacionados.setText("Diagnosticos Relacionados");
        this.JLBTDxRelacionados.setBorder(new SoftBevelBorder(0));
        this.JLBTDxRelacionados.setOpaque(true);
        this.JTFCDxR2.setFont(new Font("Arial", 1, 12));
        this.JTFCDxR2.addFocusListener(new FocusAdapter() { // from class: Historia.JPAConclusion.7
            public void focusLost(FocusEvent evt) {
                JPAConclusion.this.JTFCDxR2FocusLost(evt);
            }
        });
        this.JTFCDxR2.addKeyListener(new KeyAdapter() { // from class: Historia.JPAConclusion.8
            public void keyPressed(KeyEvent evt) {
                JPAConclusion.this.JTFCDxR2KeyPressed(evt);
            }
        });
        this.JTFNDxR2.setFont(new Font("Arial", 1, 12));
        this.JTFNDxR2.addMouseListener(new MouseAdapter() { // from class: Historia.JPAConclusion.9
            public void mouseClicked(MouseEvent evt) {
                JPAConclusion.this.JTFNDxR2MouseClicked(evt);
            }
        });
        this.JTFNDxR2.addKeyListener(new KeyAdapter() { // from class: Historia.JPAConclusion.10
            public void keyPressed(KeyEvent evt) {
                JPAConclusion.this.JTFNDxR2KeyPressed(evt);
            }
        });
        this.JTFCDxR3.setFont(new Font("Arial", 1, 12));
        this.JTFCDxR3.addFocusListener(new FocusAdapter() { // from class: Historia.JPAConclusion.11
            public void focusLost(FocusEvent evt) {
                JPAConclusion.this.JTFCDxR3FocusLost(evt);
            }
        });
        this.JTFCDxR3.addKeyListener(new KeyAdapter() { // from class: Historia.JPAConclusion.12
            public void keyPressed(KeyEvent evt) {
                JPAConclusion.this.JTFCDxR3KeyPressed(evt);
            }
        });
        this.JTFNDxR3.setFont(new Font("Arial", 1, 12));
        this.JTFNDxR3.addMouseListener(new MouseAdapter() { // from class: Historia.JPAConclusion.13
            public void mouseClicked(MouseEvent evt) {
                JPAConclusion.this.JTFNDxR3MouseClicked(evt);
            }
        });
        this.JTFNDxR3.addKeyListener(new KeyAdapter() { // from class: Historia.JPAConclusion.14
            public void keyPressed(KeyEvent evt) {
                JPAConclusion.this.JTFNDxR3KeyPressed(evt);
            }
        });
        this.JTFCDxP.setFont(new Font("Arial", 1, 12));
        this.JTFCDxP.setBorder(BorderFactory.createTitledBorder((Border) null, "Cie10", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFCDxP.addFocusListener(new FocusAdapter() { // from class: Historia.JPAConclusion.15
            public void focusLost(FocusEvent evt) {
                JPAConclusion.this.JTFCDxPFocusLost(evt);
            }
        });
        this.JTFCDxP.addActionListener(new ActionListener() { // from class: Historia.JPAConclusion.16
            public void actionPerformed(ActionEvent evt) {
                JPAConclusion.this.JTFCDxPActionPerformed(evt);
            }
        });
        this.JTFCDxP.addKeyListener(new KeyAdapter() { // from class: Historia.JPAConclusion.17
            public void keyPressed(KeyEvent evt) {
                JPAConclusion.this.JTFCDxPKeyPressed(evt);
            }
        });
        this.JTFNCodigoDxP.setFont(new Font("Arial", 1, 12));
        this.JTFNCodigoDxP.setBorder(BorderFactory.createTitledBorder((Border) null, "Dx Principal", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFNCodigoDxP.addMouseListener(new MouseAdapter() { // from class: Historia.JPAConclusion.18
            public void mouseClicked(MouseEvent evt) {
                JPAConclusion.this.JTFNCodigoDxPMouseClicked(evt);
            }
        });
        this.JTFNCodigoDxP.addKeyListener(new KeyAdapter() { // from class: Historia.JPAConclusion.19
            public void keyPressed(KeyEvent evt) {
                JPAConclusion.this.JTFNCodigoDxPKeyPressed(evt);
            }
        });
        GroupLayout JPIDxConclusionLayout = new GroupLayout(this.JPIDxConclusion);
        this.JPIDxConclusion.setLayout(JPIDxConclusionLayout);
        JPIDxConclusionLayout.setHorizontalGroup(JPIDxConclusionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDxConclusionLayout.createSequentialGroup().addGap(1, 1, 1).addGroup(JPIDxConclusionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDxConclusionLayout.createSequentialGroup().addGroup(JPIDxConclusionLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFCDxR3, -2, 55, -2).addComponent(this.JTFCDxR2, -2, 55, -2).addComponent(this.JTFCDxR1, -2, 55, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDxConclusionLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JTFNDxR2, GroupLayout.Alignment.LEADING, -2, 725, -2).addComponent(this.JTFNDxR3, -2, 725, -2).addComponent(this.JTFNDxR1, GroupLayout.Alignment.LEADING, -2, 725, -2))).addGroup(JPIDxConclusionLayout.createSequentialGroup().addComponent(this.JTFCDxP, -2, 119, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFNCodigoDxP, -2, 393, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBTipoDx, -2, 256, -2)).addComponent(this.JLBTDxRelacionados, -2, 786, -2)).addGap(0, 0, 0)));
        JPIDxConclusionLayout.setVerticalGroup(JPIDxConclusionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDxConclusionLayout.createSequentialGroup().addGap(3, 3, 3).addGroup(JPIDxConclusionLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFCDxP, -2, -1, -2).addComponent(this.JTFNCodigoDxP, -2, -1, -2).addComponent(this.JCBTipoDx, -1, -1, -2)).addGap(1, 1, 1).addComponent(this.JLBTDxRelacionados, -2, 15, -2).addGap(2, 2, 2).addGroup(JPIDxConclusionLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFNDxR1, -2, 25, -2).addComponent(this.JTFCDxR1, -2, 25, -2)).addGap(2, 2, 2).addGroup(JPIDxConclusionLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFNDxR2, -2, 25, -2).addComponent(this.JTFCDxR2, -2, 25, -2)).addGap(2, 2, 2).addGroup(JPIDxConclusionLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFNDxR3, -2, 25, -2).addComponent(this.JTFCDxR3, -2, 25, -2)).addGap(2, 2, 2)));
        this.JPIConclusionAtencion.setBorder(BorderFactory.createTitledBorder((Border) null, "ANÁLISIS DE LA ATENCIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTPConclusion.setFont(new Font("Arial", 1, 12));
        this.JTPConclusion.addKeyListener(new KeyAdapter() { // from class: Historia.JPAConclusion.20
            public void keyPressed(KeyEvent evt) {
                JPAConclusion.this.JTPConclusionKeyPressed(evt);
            }
        });
        this.JSPEor.setViewportView(this.JTPConclusion);
        GroupLayout JPIConclusionAtencionLayout = new GroupLayout(this.JPIConclusionAtencion);
        this.JPIConclusionAtencion.setLayout(JPIConclusionAtencionLayout);
        JPIConclusionAtencionLayout.setHorizontalGroup(JPIConclusionAtencionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPEor, GroupLayout.Alignment.TRAILING, -1, 785, 32767));
        JPIConclusionAtencionLayout.setVerticalGroup(JPIConclusionAtencionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIConclusionAtencionLayout.createSequentialGroup().addGap(2, 2, 2).addComponent(this.JSPEor, -1, 121, 32767).addGap(1, 1, 1)));
        this.JPIRecomendaciones.setBorder(BorderFactory.createTitledBorder((Border) null, "PLAN Y RECOMENDACIONES", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTPRecomendaciones.setFont(new Font("Arial", 1, 12));
        this.JTPRecomendaciones.addKeyListener(new KeyAdapter() { // from class: Historia.JPAConclusion.21
            public void keyPressed(KeyEvent evt) {
                JPAConclusion.this.JTPRecomendacionesKeyPressed(evt);
            }
        });
        this.JSPRecomendaciones.setViewportView(this.JTPRecomendaciones);
        GroupLayout JPIRecomendacionesLayout = new GroupLayout(this.JPIRecomendaciones);
        this.JPIRecomendaciones.setLayout(JPIRecomendacionesLayout);
        JPIRecomendacionesLayout.setHorizontalGroup(JPIRecomendacionesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPRecomendaciones, GroupLayout.Alignment.TRAILING, -1, 785, 32767));
        JPIRecomendacionesLayout.setVerticalGroup(JPIRecomendacionesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIRecomendacionesLayout.createSequentialGroup().addComponent(this.JSPRecomendaciones, -1, 80, 32767).addGap(1, 1, 1)));
        this.JCBServicios.setFont(new Font("Arial", 1, 12));
        this.JCBServicios.setBorder(BorderFactory.createTitledBorder((Border) null, "Servicios", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JCBServicios.setEnabled(false);
        this.JCBTipoDestino.setFont(new Font("Arial", 1, 12));
        this.JCBTipoDestino.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Destino", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JCBTipoDestino.setEnabled(false);
        this.JLBNEgreso.setFont(new Font("Arial", 1, 18));
        this.JLBNEgreso.setForeground(new Color(255, 0, 0));
        this.JLBNEgreso.setHorizontalAlignment(0);
        this.JLBNEgreso.setBorder(BorderFactory.createTitledBorder((Border) null, "Egreso N°", 2, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTPDatosAdicionales.setForeground(new Color(0, 103, 0));
        this.JTPDatosAdicionales.setFont(new Font("Arial", 1, 14));
        this.JPIDx_Complicacion.setBorder(BorderFactory.createTitledBorder((Border) null, "DIAGNÓSTICO DE COMPLICACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTFCDxC.setFont(new Font("Arial", 1, 12));
        this.JTFCDxC.addFocusListener(new FocusAdapter() { // from class: Historia.JPAConclusion.22
            public void focusLost(FocusEvent evt) {
                JPAConclusion.this.JTFCDxCFocusLost(evt);
            }
        });
        this.JTFCDxC.addKeyListener(new KeyAdapter() { // from class: Historia.JPAConclusion.23
            public void keyPressed(KeyEvent evt) {
                JPAConclusion.this.JTFCDxCKeyPressed(evt);
            }
        });
        this.JTFNDxC.setFont(new Font("Arial", 1, 12));
        this.JTFNDxC.addMouseListener(new MouseAdapter() { // from class: Historia.JPAConclusion.24
            public void mouseClicked(MouseEvent evt) {
                JPAConclusion.this.JTFNDxCMouseClicked(evt);
            }
        });
        GroupLayout JPIDx_ComplicacionLayout = new GroupLayout(this.JPIDx_Complicacion);
        this.JPIDx_Complicacion.setLayout(JPIDx_ComplicacionLayout);
        JPIDx_ComplicacionLayout.setHorizontalGroup(JPIDx_ComplicacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDx_ComplicacionLayout.createSequentialGroup().addGap(4, 4, 4).addComponent(this.JTFCDxC, -2, 55, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFNDxC, -2, 541, -2)));
        JPIDx_ComplicacionLayout.setVerticalGroup(JPIDx_ComplicacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDx_ComplicacionLayout.createSequentialGroup().addGap(3, 3, 3).addGroup(JPIDx_ComplicacionLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFNDxC, -2, 25, -2).addComponent(this.JTFCDxC, -2, 25, -2)).addGap(3, 3, 3)));
        this.JPIEstado.setBorder(BorderFactory.createTitledBorder((Border) null, "Estado", 0, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.jbgEstadoPaciente.add(this.JRBEVivo);
        this.JRBEVivo.setFont(new Font("Arial", 1, 12));
        this.JRBEVivo.setSelected(true);
        this.JRBEVivo.setText("Vivo");
        this.JRBEVivo.addActionListener(new ActionListener() { // from class: Historia.JPAConclusion.25
            public void actionPerformed(ActionEvent evt) {
                JPAConclusion.this.JRBEVivoActionPerformed(evt);
            }
        });
        this.jbgEstadoPaciente.add(this.JRBEMuerto);
        this.JRBEMuerto.setFont(new Font("Arial", 1, 12));
        this.JRBEMuerto.setText("Muerto");
        this.JRBEMuerto.addActionListener(new ActionListener() { // from class: Historia.JPAConclusion.26
            public void actionPerformed(ActionEvent evt) {
                JPAConclusion.this.JRBEMuertoActionPerformed(evt);
            }
        });
        GroupLayout JPIEstadoLayout = new GroupLayout(this.JPIEstado);
        this.JPIEstado.setLayout(JPIEstadoLayout);
        JPIEstadoLayout.setHorizontalGroup(JPIEstadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIEstadoLayout.createSequentialGroup().addContainerGap().addComponent(this.JRBEVivo).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JRBEMuerto).addContainerGap()));
        JPIEstadoLayout.setVerticalGroup(JPIEstadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIEstadoLayout.createSequentialGroup().addGroup(JPIEstadoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBEVivo).addComponent(this.JRBEMuerto)).addGap(10, 10, 10)));
        GroupLayout JPIDiagnositicosLayout = new GroupLayout(this.JPIDiagnositicos);
        this.JPIDiagnositicos.setLayout(JPIDiagnositicosLayout);
        JPIDiagnositicosLayout.setHorizontalGroup(JPIDiagnositicosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDiagnositicosLayout.createSequentialGroup().addContainerGap().addComponent(this.JPIDx_Complicacion, -1, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPIEstado, -2, -1, -2).addContainerGap()));
        JPIDiagnositicosLayout.setVerticalGroup(JPIDiagnositicosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDiagnositicosLayout.createSequentialGroup().addGap(2, 2, 2).addGroup(JPIDiagnositicosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIEstado, -2, -1, -2).addComponent(this.JPIDx_Complicacion, -2, -1, -2)).addGap(5, 5, 5)));
        this.JTPDatosAdicionales.addTab("DATOS ADICIONALES", this.JPIDiagnositicos);
        this.JTFCDxR4.setFont(new Font("Arial", 1, 12));
        this.JTFCDxR4.setEnabled(false);
        this.JTFCDxR4.addFocusListener(new FocusAdapter() { // from class: Historia.JPAConclusion.27
            public void focusLost(FocusEvent evt) {
                JPAConclusion.this.JTFCDxR4FocusLost(evt);
            }
        });
        this.JTFCDxR4.addKeyListener(new KeyAdapter() { // from class: Historia.JPAConclusion.28
            public void keyPressed(KeyEvent evt) {
                JPAConclusion.this.JTFCDxR4KeyPressed(evt);
            }
        });
        this.JTFNDxR4.setFont(new Font("Arial", 1, 12));
        this.JTFNDxR4.setEnabled(false);
        this.JTFNDxR4.addMouseListener(new MouseAdapter() { // from class: Historia.JPAConclusion.29
            public void mouseClicked(MouseEvent evt) {
                JPAConclusion.this.JTFNDxR4MouseClicked(evt);
            }
        });
        GroupLayout JPCie10MuerteLayout = new GroupLayout(this.JPCie10Muerte);
        this.JPCie10Muerte.setLayout(JPCie10MuerteLayout);
        JPCie10MuerteLayout.setHorizontalGroup(JPCie10MuerteLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPCie10MuerteLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFCDxR4, -2, 55, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFNDxR4, -2, 699, -2).addGap(14, 14, 14)));
        JPCie10MuerteLayout.setVerticalGroup(JPCie10MuerteLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPCie10MuerteLayout.createSequentialGroup().addContainerGap().addGroup(JPCie10MuerteLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFNDxR4, -2, 25, -2).addComponent(this.JTFCDxR4, -2, 25, -2)).addContainerGap(25, 32767)));
        this.JTPDatosAdicionales.addTab("CIE 10 MUERTE", this.JPCie10Muerte);
        this.JTFFHora.setBorder(BorderFactory.createTitledBorder((Border) null, "Hora", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFHora.setFormatterFactory(new DefaultFormatterFactory(new DateFormatter(new SimpleDateFormat("HH:mm:ss"))));
        this.JTFFHora.setFont(new Font("Tahoma", 1, 12));
        this.JTFFHora.addKeyListener(new KeyAdapter() { // from class: Historia.JPAConclusion.30
            public void keyPressed(KeyEvent evt) {
                JPAConclusion.this.JTFFHoraKeyPressed(evt);
            }
        });
        this.JDCFechaS.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaS.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaS.setFont(new Font("Arial", 1, 12));
        GroupLayout JPIConclusionLayout = new GroupLayout(this.JPIConclusion);
        this.JPIConclusion.setLayout(JPIConclusionLayout);
        JPIConclusionLayout.setHorizontalGroup(JPIConclusionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIConclusionLayout.createSequentialGroup().addComponent(this.JCBServicios, -2, 203, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBTipoDestino, -2, 193, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JDCFechaS, -2, 116, -2).addGap(2, 2, 2).addComponent(this.JTFFHora, -2, 88, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLBNEgreso, -2, 160, -2).addGap(12, 12, 12)).addGroup(GroupLayout.Alignment.TRAILING, JPIConclusionLayout.createSequentialGroup().addGroup(JPIConclusionLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JPIConclusionAtencion, -2, -1, -2).addComponent(this.JPIDxConclusion, GroupLayout.Alignment.LEADING, -1, -1, 32767).addGroup(GroupLayout.Alignment.LEADING, JPIConclusionLayout.createSequentialGroup().addGroup(JPIConclusionLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JTPDatosAdicionales, GroupLayout.Alignment.LEADING, -1, -1, -2).addComponent(this.JPIRecomendaciones, GroupLayout.Alignment.LEADING, -2, -1, -2)).addGap(0, 0, 32767))).addGap(1, 1, 1)));
        JPIConclusionLayout.setVerticalGroup(JPIConclusionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIConclusionLayout.createSequentialGroup().addGap(2, 2, 2).addComponent(this.JPIDxConclusion, -2, -1, -2).addGap(1, 1, 1).addComponent(this.JPIConclusionAtencion, -2, -1, -2).addGap(1, 1, 1).addComponent(this.JPIRecomendaciones, -2, -1, -2).addGap(1, 1, 1).addGroup(JPIConclusionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIConclusionLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBServicios, -2, 45, -2).addComponent(this.JCBTipoDestino, -2, 45, -2)).addGroup(JPIConclusionLayout.createSequentialGroup().addGap(5, 5, 5).addGroup(JPIConclusionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JDCFechaS, -2, 45, -2).addComponent(this.JTFFHora, -2, 45, -2).addComponent(this.JLBNEgreso, -2, 45, -2)))).addGap(5, 5, 5).addComponent(this.JTPDatosAdicionales, -2, 94, -2).addGap(1, 1, 1)));
        this.JBTGuardar.setFont(new Font("Arial", 1, 12));
        this.JBTGuardar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Grabar29x27.png")));
        this.JBTGuardar.setText("Guardar");
        this.JBTGuardar.setName("");
        this.JBTGuardar.addActionListener(new ActionListener() { // from class: Historia.JPAConclusion.31
            public void actionPerformed(ActionEvent evt) {
                JPAConclusion.this.JBTGuardarActionPerformed(evt);
            }
        });
        this.JBTGuardar.addKeyListener(new KeyAdapter() { // from class: Historia.JPAConclusion.32
            public void keyPressed(KeyEvent evt) {
                JPAConclusion.this.JBTGuardarKeyPressed(evt);
            }
        });
        this.JBT_NotaP.setFont(new Font("Arial", 1, 12));
        this.JBT_NotaP.setIcon(new ImageIcon(getClass().getResource("/Imagenes/HojaLapiz29x27.png")));
        this.JBT_NotaP.setText("Notas Predefinidas");
        this.JBT_NotaP.addActionListener(new ActionListener() { // from class: Historia.JPAConclusion.33
            public void actionPerformed(ActionEvent evt) {
                JPAConclusion.this.JBT_NotaPActionPerformed(evt);
            }
        });
        this.JBT_NotaP.addKeyListener(new KeyAdapter() { // from class: Historia.JPAConclusion.34
            public void keyPressed(KeyEvent evt) {
                JPAConclusion.this.JBT_NotaPKeyPressed(evt);
            }
        });
        this.JBT_AbrirHC.setFont(new Font("Arial", 1, 12));
        this.JBT_AbrirHC.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Configuracion29x27.png")));
        this.JBT_AbrirHC.setText("Abrir Hc");
        this.JBT_AbrirHC.addActionListener(new ActionListener() { // from class: Historia.JPAConclusion.35
            public void actionPerformed(ActionEvent evt) {
                JPAConclusion.this.JBT_AbrirHCActionPerformed(evt);
            }
        });
        this.JPIDestino.setBorder(BorderFactory.createTitledBorder((Border) null, "Destino", 0, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.JBGDestino.add(this.JRBDAUrgencias);
        this.JRBDAUrgencias.setFont(new Font("Arial", 1, 12));
        this.JRBDAUrgencias.setSelected(true);
        this.JRBDAUrgencias.setText("Fin Atenciòn");
        this.JRBDAUrgencias.addActionListener(new ActionListener() { // from class: Historia.JPAConclusion.36
            public void actionPerformed(ActionEvent evt) {
                JPAConclusion.this.JRBDAUrgenciasActionPerformed(evt);
            }
        });
        this.JBGDestino.add(this.JRBDRemision);
        this.JRBDRemision.setFont(new Font("Arial", 1, 12));
        this.JRBDRemision.setText("Remisión a otro nivel de complejidad");
        this.JRBDRemision.addActionListener(new ActionListener() { // from class: Historia.JPAConclusion.37
            public void actionPerformed(ActionEvent evt) {
                JPAConclusion.this.JRBDRemisionActionPerformed(evt);
            }
        });
        this.JBGDestino.add(this.JRBDHospitalizacion);
        this.JRBDHospitalizacion.setFont(new Font("Arial", 1, 12));
        this.JRBDHospitalizacion.setText("Hospitalización");
        this.JRBDHospitalizacion.addActionListener(new ActionListener() { // from class: Historia.JPAConclusion.38
            public void actionPerformed(ActionEvent evt) {
                JPAConclusion.this.JRBDHospitalizacionActionPerformed(evt);
            }
        });
        GroupLayout JPIDestinoLayout = new GroupLayout(this.JPIDestino);
        this.JPIDestino.setLayout(JPIDestinoLayout);
        JPIDestinoLayout.setHorizontalGroup(JPIDestinoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDestinoLayout.createSequentialGroup().addContainerGap().addComponent(this.JRBDAUrgencias).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 56, 32767).addComponent(this.JRBDRemision).addGap(53, 53, 53).addComponent(this.JRBDHospitalizacion, -2, 280, -2).addGap(39, 39, 39)));
        JPIDestinoLayout.setVerticalGroup(JPIDestinoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDestinoLayout.createSequentialGroup().addGap(1, 1, 1).addGroup(JPIDestinoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBDAUrgencias).addComponent(this.JRBDRemision).addComponent(this.JRBDHospitalizacion)).addGap(1, 1, 1)));
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGap(5, 5, 5).addComponent(this.JPIConclusion, -2, -1, -2).addGap(5, 5, 5)).addGroup(layout.createSequentialGroup().addGap(2, 2, 2).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JPIDestino, -2, -1, -2).addGroup(layout.createSequentialGroup().addComponent(this.JBTGuardar, -2, 250, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JBT_NotaP, -2, 250, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBT_AbrirHC, -2, 250, -2))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(3, 3, 3).addComponent(this.JPIConclusion, -2, -1, -2).addGap(1, 1, 1).addComponent(this.JPIDestino, -2, -1, -2).addGap(2, 2, 2).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBTGuardar, -2, 42, -2).addComponent(this.JBT_NotaP, -2, 42, -2).addComponent(this.JBT_AbrirHC, -2, 42, -2)).addContainerGap(-1, 32767)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCDxPFocusLost(FocusEvent evt) {
        if (this.xclase.xjifhistoriaclinica != null) {
            this.xclase.buscarPatologias(this.JTFCDxP, this.JTFNCodigoDxP, 1, clasesHistoriaCE.informacionAgendaMedicaDTO.getFechaNacimiento(), clasesHistoriaCE.informacionAgendaMedicaDTO.getIdSexo(), this.xclase.xjifhistoriaclinica);
        } else if (this.xclase.historia_Clinica_v4 != null) {
            this.xclase.buscarPatologias(this.JTFCDxP, this.JTFNCodigoDxP, 1, clasesHistoriaCE.informacionAgendaMedicaDTO.getFechaNacimiento(), clasesHistoriaCE.informacionAgendaMedicaDTO.getIdSexo(), this.xclase.historia_Clinica_v4);
        } else if (this.xclase.historia_Clinica_v2 != null) {
            this.xclase.buscarPatologias(this.JTFCDxP, this.JTFNCodigoDxP, 1, clasesHistoriaCE.informacionAgendaMedicaDTO.getFechaNacimiento(), clasesHistoriaCE.informacionAgendaMedicaDTO.getIdSexo(), this.xclase.historia_Clinica_v2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNCodigoDxPMouseClicked(MouseEvent evt) {
        this.xclase.buscarPatologiaNombre(this.JTFCDxP, this.JTFNCodigoDxP, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCDxR1FocusLost(FocusEvent evt) {
        if (this.xclase.xjifhistoriaclinica != null) {
            this.xclase.buscarPatologias(this.JTFCDxR1, this.JTFNDxR1, 0, clasesHistoriaCE.informacionAgendaMedicaDTO.getFechaNacimiento(), clasesHistoriaCE.informacionAgendaMedicaDTO.getIdSexo(), this.xclase.xjifhistoriaclinica);
        } else if (this.xclase.historia_Clinica_v4 != null) {
            this.xclase.buscarPatologias(this.JTFCDxR1, this.JTFNDxR1, 0, clasesHistoriaCE.informacionAgendaMedicaDTO.getFechaNacimiento(), clasesHistoriaCE.informacionAgendaMedicaDTO.getIdSexo(), this.xclase.historia_Clinica_v4);
        } else if (this.xclase.historia_Clinica_v2 != null) {
            this.xclase.buscarPatologias(this.JTFCDxR1, this.JTFNDxR1, 0, clasesHistoriaCE.informacionAgendaMedicaDTO.getFechaNacimiento(), clasesHistoriaCE.informacionAgendaMedicaDTO.getIdSexo(), this.xclase.historia_Clinica_v2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCDxR2FocusLost(FocusEvent evt) {
        if (this.xclase.xjifhistoriaclinica != null) {
            this.xclase.buscarPatologias(this.JTFCDxR2, this.JTFNDxR2, 0, clasesHistoriaCE.informacionAgendaMedicaDTO.getFechaNacimiento(), clasesHistoriaCE.informacionAgendaMedicaDTO.getIdSexo(), this.xclase.xjifhistoriaclinica);
        } else if (this.xclase.historia_Clinica_v4 != null) {
            this.xclase.buscarPatologias(this.JTFCDxR2, this.JTFNDxR2, 0, clasesHistoriaCE.informacionAgendaMedicaDTO.getFechaNacimiento(), clasesHistoriaCE.informacionAgendaMedicaDTO.getIdSexo(), this.xclase.historia_Clinica_v4);
        } else if (this.xclase.historia_Clinica_v2 != null) {
            this.xclase.buscarPatologias(this.JTFCDxR2, this.JTFNDxR2, 0, clasesHistoriaCE.informacionAgendaMedicaDTO.getFechaNacimiento(), clasesHistoriaCE.informacionAgendaMedicaDTO.getIdSexo(), this.xclase.historia_Clinica_v2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCDxR3FocusLost(FocusEvent evt) {
        if (this.xclase.xjifhistoriaclinica != null) {
            this.xclase.buscarPatologias(this.JTFCDxR3, this.JTFNDxR3, 0, clasesHistoriaCE.informacionAgendaMedicaDTO.getFechaNacimiento(), clasesHistoriaCE.informacionAgendaMedicaDTO.getIdSexo(), this.xclase.xjifhistoriaclinica);
        } else if (this.xclase.historia_Clinica_v4 != null) {
            this.xclase.buscarPatologias(this.JTFCDxR3, this.JTFNDxR3, 0, clasesHistoriaCE.informacionAgendaMedicaDTO.getFechaNacimiento(), clasesHistoriaCE.informacionAgendaMedicaDTO.getIdSexo(), this.xclase.historia_Clinica_v4);
        } else if (this.xclase.historia_Clinica_v2 != null) {
            this.xclase.buscarPatologias(this.JTFCDxR3, this.JTFNDxR3, 0, clasesHistoriaCE.informacionAgendaMedicaDTO.getFechaNacimiento(), clasesHistoriaCE.informacionAgendaMedicaDTO.getIdSexo(), this.xclase.historia_Clinica_v2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNDxR1MouseClicked(MouseEvent evt) {
        if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL SAN JOSE DE TIERRALTA")) {
            this.xclase.buscarPatologiaNombre(this.JTFCDxR1, this.JTFNDxR1, 1);
        } else {
            this.xclase.buscarPatologiaNombre(this.JTFCDxR1, this.JTFNDxR1, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNDxR2MouseClicked(MouseEvent evt) {
        if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL SAN JOSE DE TIERRALTA")) {
            this.xclase.buscarPatologiaNombre(this.JTFCDxR2, this.JTFNDxR2, 1);
        } else {
            this.xclase.buscarPatologiaNombre(this.JTFCDxR2, this.JTFNDxR2, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNDxR3MouseClicked(MouseEvent evt) {
        if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL SAN JOSE DE TIERRALTA")) {
            this.xclase.buscarPatologiaNombre(this.JTFCDxR3, this.JTFNDxR3, 1);
        } else {
            this.xclase.buscarPatologiaNombre(this.JTFCDxR3, this.JTFNDxR3, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGuardarActionPerformed(ActionEvent evt) {
        mGrabarBd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNCodigoDxPKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JTFNCodigoDxP.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTipoDxKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JCBTipoDx.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNDxR1KeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JTFNDxR1.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNDxR2KeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JTFNDxR2.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNDxR3KeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JTFNDxR3.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTPConclusionKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 9) {
            this.JTPConclusion.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGuardarKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            mGrabarBd();
            this.JBTGuardar.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTPRecomendacionesKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formAncestorRemoved(AncestorEvent evt) {
        if (!this.JBTGuardar.isEnabled() || this.JTFCDxP.getText().isEmpty() || this.JTFNCodigoDxP.getText().isEmpty() || this.JCBTipoDx.getSelectedIndex() == -1) {
            return;
        }
        mAlmacenarBDTmp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_NotaPActionPerformed(ActionEvent evt) {
        mCargar_NotasP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_NotaPKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            mCargar_NotasP();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_AbrirHCActionPerformed(ActionEvent evt) {
        if (this.JBT_AbrirHC.getText().equals("Abrir Hc")) {
            String xsql = "update h_atencion set TipoGuardado=0 where Id='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "'";
            this.xconsultasbd.ejecutarSQL(xsql);
            this.xconsultasbd.cerrarConexionBd();
            this.JBTGuardar.setEnabled(true);
        } else {
            String xsql2 = "update h_atencion set TipoGuardado=1 where Id='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "'";
            this.xconsultasbd.ejecutarSQL(xsql2);
            this.xconsultasbd.cerrarConexionBd();
            this.JBTGuardar.setEnabled(false);
        }
        if ((Principal.informacionIps.getNombreIps().equals("CLINICA LAURELES PSIQUIATRAS ASOCIADOS I.P.S. S.A.S.") || Principal.informacionIps.getNombreIps().equals("UNION TEMPORAL CLINICA LAURELES")) && clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTipoAtencion().intValue() > 1) {
            this.JCBTipoDestino.setEnabled(true);
            buscarEgreso();
        } else {
            mBuscarDatosBd();
        }
        if (getTipoGuardado() != 1) {
            this.JBTGuardar.setEnabled(true);
            clasesHistoriaCE.informacionAgendaMedicaDTO.setTipoGuardado(0);
            this.xEstado = 0;
        } else {
            this.JBTGuardar.setEnabled(false);
            clasesHistoriaCE.informacionAgendaMedicaDTO.setTipoGuardado(1);
            this.xEstado = 1;
        }
        mCambio_EstadoBoton();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBDAUrgenciasActionPerformed(ActionEvent evt) {
        if (Principal.informacionIps.getNombreIps().equals("CLINICA LAURELES PSIQUIATRAS ASOCIADOS I.P.S. S.A.S.") || Principal.informacionIps.getNombreIps().equals("UNION TEMPORAL CLINICA LAURELES")) {
            this.JCBServicios.setEnabled(false);
            if (clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTipoAtencion().intValue() > 1) {
                this.JCBTipoDestino.setEnabled(true);
            } else {
                this.JCBTipoDestino.setEnabled(false);
            }
            this.xdestino = 0;
            return;
        }
        this.xdestino = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBDRemisionActionPerformed(ActionEvent evt) {
        if (Principal.informacionIps.getNombreIps().equals("CLINICA LAURELES PSIQUIATRAS ASOCIADOS I.P.S. S.A.S.") || Principal.informacionIps.getNombreIps().equals("UNION TEMPORAL CLINICA LAURELES")) {
            this.JCBServicios.setEnabled(false);
            this.xdestino = 4;
        } else {
            this.xdestino = 4;
        }
    }

    private int getTipoGuardado() {
        int idGuardado = 0;
        try {
            String sql = "SELECT id,`TipoGuardado` FROM `h_atencion` WHERE id='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "'";
            ResultSet rs = this.xconsultasbd.traerRs(sql);
            if (rs.next()) {
                rs.first();
                idGuardado = Integer.valueOf(rs.getString(2)).intValue();
            }
            rs.close();
            this.xconsultasbd.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPAConclusion.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return idGuardado;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBDHospitalizacionActionPerformed(ActionEvent evt) {
        if (Principal.informacionIps.getNombreIps().equals("CLINICA LAURELES PSIQUIATRAS ASOCIADOS I.P.S. S.A.S.") || Principal.informacionIps.getNombreIps().equals("UNION TEMPORAL CLINICA LAURELES")) {
            if (getTipoGuardado() != 1) {
                this.JCBServicios.setEnabled(true);
                if (clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTipoAtencion().intValue() > 1) {
                    this.JCBTipoDestino.setEnabled(true);
                } else {
                    this.JCBTipoDestino.setEnabled(false);
                }
            } else {
                this.JCBServicios.setEnabled(false);
                this.JCBTipoDestino.setEnabled(false);
            }
            this.xdestino = 2;
            return;
        }
        this.xdestino = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCDxPKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JTFCDxP.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCDxR1KeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.xEncontrado = false;
            this.JTFCDxR1.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCDxR2KeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.xEncontrado = false;
            this.JTFCDxR2.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCDxR3KeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.xEncontrado = false;
            this.JTFCDxR3.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCDxPActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCDxCFocusLost(FocusEvent evt) {
        clasesHistoriaCE claseshistoriace = this.xclase;
        JTextField jTextField = this.JTFCDxC;
        JTextField jTextField2 = this.JTFNDxC;
        clasesHistoriaCE claseshistoriace2 = this.xclase;
        String fechaNacimiento = clasesHistoriaCE.informacionAgendaMedicaDTO.getFechaNacimiento();
        clasesHistoriaCE claseshistoriace3 = this.xclase;
        claseshistoriace.buscarPatologias(jTextField, jTextField2, 1, fechaNacimiento, clasesHistoriaCE.informacionAgendaMedicaDTO.getNombreSexo(), this.xclase.xjifhistoriaclinica);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCDxCKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            clasesHistoriaCE claseshistoriace = this.xclase;
            JTextField jTextField = this.JTFCDxC;
            JTextField jTextField2 = this.JTFNDxC;
            clasesHistoriaCE claseshistoriace2 = this.xclase;
            String fechaNacimiento = clasesHistoriaCE.informacionAgendaMedicaDTO.getFechaNacimiento();
            clasesHistoriaCE claseshistoriace3 = this.xclase;
            claseshistoriace.buscarPatologias(jTextField, jTextField2, 2, fechaNacimiento, clasesHistoriaCE.informacionAgendaMedicaDTO.getNombreSexo(), this.xclase.xjifhistoriaclinica);
            this.JTFCDxR2.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNDxCMouseClicked(MouseEvent evt) {
        this.xclase.buscarPatologiaNombre(this.JTFCDxC, this.JTFNDxC, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBEVivoActionPerformed(ActionEvent evt) {
        this.estadoPaciente = 1;
        this.JTFCDxR4.setEnabled(false);
        this.JTFNDxR4.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBEMuertoActionPerformed(ActionEvent evt) {
        this.estadoPaciente = 2;
        this.JTFCDxR4.setEnabled(true);
        this.JTFNDxR4.setEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCDxR4FocusLost(FocusEvent evt) {
        if (this.JRBEMuerto.isSelected()) {
            clasesHistoriaCE claseshistoriace = this.xclase;
            JTextField jTextField = this.JTFCDxR4;
            JTextField jTextField2 = this.JTFNDxR4;
            clasesHistoriaCE claseshistoriace2 = this.xclase;
            String fechaNacimiento = clasesHistoriaCE.informacionAgendaMedicaDTO.getFechaNacimiento();
            clasesHistoriaCE claseshistoriace3 = this.xclase;
            claseshistoriace.buscarPatologias(jTextField, jTextField2, 1, fechaNacimiento, clasesHistoriaCE.informacionAgendaMedicaDTO.getNombreSexo(), this.xclase.xjifhistoriaclinica);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCDxR4KeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10 && this.JRBEMuerto.isSelected()) {
            clasesHistoriaCE claseshistoriace = this.xclase;
            JTextField jTextField = this.JTFCDxR4;
            JTextField jTextField2 = this.JTFNDxR4;
            clasesHistoriaCE claseshistoriace2 = this.xclase;
            String fechaNacimiento = clasesHistoriaCE.informacionAgendaMedicaDTO.getFechaNacimiento();
            clasesHistoriaCE claseshistoriace3 = this.xclase;
            claseshistoriace.buscarPatologias(jTextField, jTextField2, 1, fechaNacimiento, clasesHistoriaCE.informacionAgendaMedicaDTO.getNombreSexo(), this.xclase.xjifhistoriaclinica);
            this.JTFCDxR4.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNDxR4MouseClicked(MouseEvent evt) {
        if (this.JRBEMuerto.isSelected()) {
            this.xclase.buscarPatologiaNombre(this.JTFCDxR4, this.JTFNDxR4, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFHoraKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JTFFHora.transferFocus();
        }
    }

    private void grabarFinal() {
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de guardar HC", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            if (Principal.informacionIps.getEsFpz().intValue() == 0) {
                mGenerarCorreo();
                Component jIFPCierreHC = new JIFPCierreHC(this, this.xclase);
                Principal.PanelPpal.add(jIFPCierreHC, JLayeredPane.DEFAULT_LAYER);
                jIFPCierreHC.setVisible(true);
                try {
                    jIFPCierreHC.setSelected(true);
                    return;
                } catch (PropertyVetoException e) {
                    Logger.getLogger(JIFHistoriaClinica.class.getName()).log(Level.SEVERE, (String) null, e);
                    return;
                }
            }
            mAlmacenarBD(0, 0, 0, 0, 0, 0, 0, 0);
            return;
        }
        mAlmacenarBDTmp();
        int y = JOptionPane.showInternalConfirmDialog(this, "Desea visualizar la HC", "VISUALIZACIÓN ", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (y == 0) {
            this.xclase.mImpirmirHC();
        }
    }

    public void mGrabarBd() {
        if (this.JBTGuardar.isEnabled()) {
            if (!this.JTFCDxP.getText().isEmpty()) {
                if (!this.JTFNCodigoDxP.getText().isEmpty()) {
                    if (this.JCBTipoDx.getSelectedIndex() != -1) {
                        if (!Principal.informacionIps.getNombreIps().equals("CLINICA LAURELES PSIQUIATRAS ASOCIADOS I.P.S. S.A.S.") && !Principal.informacionIps.getNombreIps().equals("UNION TEMPORAL CLINICA LAURELES")) {
                            mGrabarH(String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdIngreso()));
                            grabarFinal();
                            return;
                        }
                        if (this.xdestino == 2) {
                            if (clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTipoAtencion().intValue() > 1) {
                                if (this.JCBServicios.getSelectedIndex() != -1 && this.JCBTipoDestino.getSelectedIndex() != -1) {
                                    grabarFinal();
                                    return;
                                } else {
                                    JOptionPane.showInternalMessageDialog(this, "Falta seleccionar el servicio o destino paciente", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                                    this.JCBServicios.requestFocus();
                                    return;
                                }
                            }
                            if (this.JCBServicios.getSelectedIndex() != -1) {
                                grabarFinal();
                                return;
                            } else {
                                JOptionPane.showInternalMessageDialog(this, "Falta seleccionar el servicio", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                                this.JCBServicios.requestFocus();
                                return;
                            }
                        }
                        if (this.JRBDAUrgencias.isSelected()) {
                            if (clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTipoAtencion().intValue() > 1) {
                                if (this.JCBTipoDestino.getSelectedIndex() != -1) {
                                    grabarFinal();
                                    return;
                                } else {
                                    JOptionPane.showInternalMessageDialog(this, "Falta seleccionar el destino paciente", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                                    this.JCBTipoDestino.requestFocus();
                                    return;
                                }
                            }
                            grabarFinal();
                            return;
                        }
                        grabarFinal();
                        return;
                    }
                    JOptionPane.showInternalMessageDialog(this, "Debe seleccionar \n un tipo de Dx", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    this.JCBTipoDx.requestFocus();
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "El nombre Dx principal no \n puede estar en blanco", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JTFNCodigoDxP.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "El codigo Dx principal no \n puede estar en blanco", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFCDxP.requestFocus();
        }
    }

    public void mAlmacenarBD(int x1, int x2, int x3, int x4, int x5, int x6, int x7, int x10) {
        if (this.JBTGuardar.isEnabled()) {
            if ((!Principal.informacionIps.getNombreIps().equals("CLINICA LAURELES PSIQUIATRAS ASOCIADOS I.P.S. S.A.S.") && !Principal.informacionIps.getNombreIps().equals("UNION TEMPORAL CLINICA LAURELES")) || clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTipoAtencion().intValue() == 1) {
                String sql = "update h_atencion set  Codigo_Dxp='" + this.JTFCDxP.getText() + "', Id_TipoDx='" + this.idtipodx[this.JCBTipoDx.getSelectedIndex()] + "', Codigo_DxR1='" + this.JTFCDxR1.getText() + "', Codigo_DxR2='" + this.JTFCDxR2.getText() + "', Codigo_DxR3='" + this.JTFCDxR3.getText() + "', Conclusion='" + this.JTPConclusion.getText() + "', Estado='0', Fecha='" + this.xmetodo.formatoAMDH24.format(this.xmetodo.getFechaActual()) + "', Recomendaciones='" + this.JTPRecomendaciones.getText() + "', Ip1='" + x1 + "', Ip2='" + x2 + "', Ip3='" + x3 + "', Ip4='" + x4 + "', Ip5='" + x5 + "', Ip6='" + x10 + "', Controlado='" + x6 + "', Adherido='" + x7 + "', DestinoP='" + this.xdestino + "', InicioAtencion=1, UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' where id='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "'";
                this.xconsultasbd.ejecutarSQL(sql);
                this.xconsultasbd.cerrarConexionBd();
                this.xclase.mActualizarDx_Ingreso(this.JTFCDxP.getText());
                if (!this.JTFCDxP.getText().isEmpty()) {
                    String sql2 = "insert ignore into h_atenciondx (Id_Atencion, Id_Dx, Orden ) values('" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "','" + this.JTFCDxP.getText() + "','1')";
                    this.xconsultasbd.ejecutarSQL(sql2);
                    this.xconsultasbd.cerrarConexionBd();
                }
                if (!this.JTFCDxR1.getText().isEmpty()) {
                    String sql3 = "insert ignore into h_atenciondx (Id_Atencion, Id_Dx, Orden ) values('" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "','" + this.JTFCDxR1.getText() + "','2')";
                    this.xconsultasbd.ejecutarSQL(sql3);
                    this.xconsultasbd.cerrarConexionBd();
                }
                if (!this.JTFCDxR2.getText().isEmpty()) {
                    String sql4 = "insert ignore into h_atenciondx (Id_Atencion, Id_Dx, Orden ) values('" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "','" + this.JTFCDxR2.getText() + "','3')";
                    this.xconsultasbd.ejecutarSQL(sql4);
                    this.xconsultasbd.cerrarConexionBd();
                }
                if (!this.JTFCDxR3.getText().isEmpty()) {
                    String sql5 = "insert ignore into h_atenciondx (Id_Atencion, Id_Dx, Orden ) values('" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "','" + this.JTFCDxR3.getText() + "','4')";
                    this.xconsultasbd.ejecutarSQL(sql5);
                    this.xconsultasbd.cerrarConexionBd();
                }
                this.xclase.mCambiarEstadoCita();
                if ((!Principal.informacionIps.getNombreIps().equals("IPS TERAPIAS Y ESTETICA INTEGRAL SAS") && !Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JUAN DE DIOS - Segovia") && !Principal.informacionIps.getIdentificacion().equals("812003851") && !Principal.informacionIps.getIdentificacion().equals("900017536")) || clasesHistoriaCE.informacionAgendaMedicaDTO.getEsPeriodico().intValue() == 0) {
                    this.xclase.mCambiarEstadoHc(1);
                } else {
                    this.xclase.mCambiarEstadoHc(2);
                }
                this.xmetodo.cambiarEstadoValidadoItemHC(getName(), 1, true);
                this.JBTGuardar.setEnabled(false);
                String sql6 = "update g_usuarioxprograma set Controlado='" + x6 + "', Adherido='" + x7 + "', FechaUltimaC='" + this.xmetodo.formatoAMD.format(this.xmetodo.getFechaActual()) + "', Id_Atencion='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "' where Id_Usuario='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "' and Id_Programa='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdPrograma() + "'";
                this.xconsultasbd.ejecutarSQL(sql6);
                this.xconsultasbd.cerrarConexionBd();
                if (getTipoGuardado() != 1) {
                    this.JBTGuardar.setEnabled(true);
                    this.xEstado = 0;
                } else {
                    this.JBTGuardar.setEnabled(false);
                    this.xEstado = 1;
                }
                mCambio_EstadoBoton();
            }
            if (this.xdestino == 2) {
                try {
                    ConsultasMySQL xct = new ConsultasMySQL();
                    ResultSet xrs = xct.traerRs("SELECT  `Id` FROM `h_orden_hospitalizacion` WHERE (`Id_Atencion`  ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "' AND `Estado` =1)");
                    if (!xrs.next()) {
                        if (Principal.informacionIps.getNombreIps().equals("CAMBIA TU VIDA IPS SAS")) {
                            String sqlUpdateIngreso = "update ingreso set Id_TipoAtencion=2, UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' , HoraIngreso='" + this.xmetodo.formatoH24.format(this.xmetodo.getFechaActual()) + "' where Id ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdIngreso() + "'";
                            this.xconsultasbd.ejecutarSQL(sqlUpdateIngreso);
                            this.xconsultasbd.cerrarConexionBd();
                        } else if (Principal.informacionIps.getNombreIps().equals("CLINICA LAURELES PSIQUIATRAS ASOCIADOS I.P.S. S.A.S.") || Principal.informacionIps.getNombreIps().equals("UNION TEMPORAL CLINICA LAURELES")) {
                            this.xclase.mDuplicar_Ingreso_Hospitalizacion(String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdIngreso()));
                            this.xclase.insertarCitaNoProgramada(this.xclase.getIdIngresoNuevo());
                            this.xclase.insertarFOrdenes(this.xclase.getIdCitaNP());
                            String sql7 = "update ingreso SET Id_TipoAtencion='" + this.idTipoServicio[this.JCBServicios.getSelectedIndex()] + "' WHERE id='" + this.xclase.getIdIngresoNuevo() + "';";
                            this.xconsultasbd.ejecutarSQL(sql7);
                            this.xconsultasbd.cerrarConexionBd();
                            if (clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTipoAtencion().intValue() > 1) {
                                grabarEgresoServicios();
                            }
                        } else {
                            this.xclase.mDuplicar_Ingreso_Hospitalizacion(String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdIngreso()));
                        }
                        String sql8 = "insert into h_orden_hospitalizacion(`Id_Atencion`, `FechaH`, `Id_Profesional_O`, `Id_Especialidad_O`, `Dx_Cie10`, `Observacion`, `UsuarioS`) values('" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "','" + this.xmetodo.formatoAMDH24.format(this.xmetodo.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "','" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "','" + this.JTFCDxP.getText() + "','" + this.JTPConclusion.getText() + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                        this.xconsultasbd.ejecutarSQL(sql8);
                        this.xconsultasbd.cerrarConexionBd();
                    }
                    xrs.close();
                    xct.cerrarConexionBd();
                } catch (SQLException ex) {
                    Logger.getLogger(JPAConclusion.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                }
            } else if (this.xdestino == 1) {
                if (Principal.informacionIps.getIdentificacion().equals("812005644")) {
                    mGrabarEgreso();
                }
                if (Principal.informacionIps.getNombreIps().equals("CLINICA LAURELES PSIQUIATRAS ASOCIADOS I.P.S. S.A.S.") || Principal.informacionIps.getNombreIps().equals("UNION TEMPORAL CLINICA LAURELES")) {
                    if (getTipoGuardado() != 1) {
                        this.JBTGuardar.setEnabled(true);
                        this.xEstado = 0;
                    } else {
                        this.JBTGuardar.setEnabled(false);
                        this.xEstado = 1;
                    }
                    mCambio_EstadoBoton();
                }
            } else if (this.JRBDAUrgencias.isSelected() && ((Principal.informacionIps.getNombreIps().equals("CLINICA LAURELES PSIQUIATRAS ASOCIADOS I.P.S. S.A.S.") || Principal.informacionIps.getNombreIps().equals("UNION TEMPORAL CLINICA LAURELES")) && clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTipoAtencion().intValue() > 1)) {
                grabarEgresoServicios();
            }
            this.xmetodo.cambiarEstadoValidadoItemHC(getName(), 1, true);
        }
    }

    public void grabarEgresoServicios() {
        if (this.JLBNEgreso.getText().isEmpty()) {
            if (!clasesHistoriaCE.informacionAgendaMedicaDTO.getMotivoConsulta().equals("null")) {
                String sql = "insert into h_egreso_atencion(`Id_Ingreso`, `Id_Atencion`, `Id_Tipo`,`Id_TipoDx`, `DxP` , `NDxP` , `DxR1` , `NDxR1` , `DxR2` , `NDxR2` , `DxR3` , `NDxR3` ,`DxC`, `NDxC`, `Id_Destino` , `EstodoS` ,  `DxMuerte` , `NDxM`,`FechaSO`, `HoraSO`,ObservacionG,ObservacionG1,`Id_Profesional` , `Id_Especialidad`, `UsuarioS`) values('" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdIngreso() + "','" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "','" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTipoAtencion() + "','" + this.idtipodx[this.JCBTipoDx.getSelectedIndex()] + "','" + this.JTFCDxP.getText() + "','" + this.JTFNCodigoDxP.getText() + "','" + this.JTFCDxR1.getText() + "','" + this.JTFNDxR1.getText() + "','" + this.JTFCDxR2.getText() + "','" + this.JTFNDxR2.getText() + "','" + this.JTFCDxR3.getText() + "','" + this.JTFNDxR3.getText() + "','" + this.JTFCDxC.getText() + "','" + this.JTFNDxC.getText() + "','" + this.idDestino[this.JCBTipoDestino.getSelectedIndex()] + "','" + this.estadoPaciente + "','" + this.JTFCDxR4.getText() + "','" + this.JTFNDxR4.getText() + "','" + this.xmetodo.formatoAMD.format(this.JDCFechaS.getDate()) + "','" + this.xmetodo.formatoH24.format(this.JTFFHora.getValue()) + "','" + this.JTPConclusion.getText() + "','" + this.JTPRecomendaciones.getText() + "','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "','" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                this.JLBNEgreso.setText(this.xconsultasbd.ejecutarSQLId(sql));
                this.xconsultasbd.cerrarConexionBd();
                this.xclase.mCambiarEstadoHc(1);
                String sql2 = "update `ingreso` set `Egreso_H`=1 , `FEgreso_H`='" + this.xmetodo.formatoAMD.format(this.xmetodo.getFechaActual()) + "', `HEgreso_H`='" + this.xmetodo.formatoH24.format(this.xmetodo.getFechaActual()) + "' where Id='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdIngreso() + "'";
                this.xconsultasbd.ejecutarSQL(sql2);
                this.xconsultasbd.cerrarConexionBd();
                String sql3 = "UPDATE `f_camas`, ingreso SET f_camas.`Disponible`=0 WHERE f_camas.`Id`=ingreso.`Cama` AND ingreso.`Id`='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdIngreso() + "' ";
                this.xconsultasbd.ejecutarSQL(sql3);
                this.xconsultasbd.cerrarConexionBd();
                String sql4 = "UPDATE `h_egreso_atencion` INNER JOIN ingreso ON(ingreso.`Id`=`h_egreso_atencion`.`Id_Ingreso`)\nSET `h_egreso_atencion`.`Id_CausaExterna`=ingreso.`Id_CausaExterna` WHERE ingreso.`Id`='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdIngreso() + "'";
                this.xconsultasbd.ejecutarSQL(sql4);
                this.xconsultasbd.cerrarConexionBd();
                buscarEgreso();
                return;
            }
            JOptionPane.showMessageDialog(this, "Motivo de consulta no puede ser nulo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        String sql5 = "update  h_egreso_atencion set `Id_TipoDx`='" + this.idtipodx[this.JCBTipoDx.getSelectedIndex()] + "', `DxP`='" + this.JTFCDxP.getText() + "' , `NDxP`='" + this.JTFNCodigoDxP.getText() + "' , `DxR1`='" + this.JTFCDxR1.getText() + "' , `NDxR1`='" + this.JTFNDxR1.getText() + "' , `DxR2`='" + this.JTFCDxR2.getText() + "' , `NDxR2`='" + this.JTFNDxR2.getText() + "' , `DxR3`='" + this.JTFCDxR3.getText() + "' , `NDxR3`='" + this.JTFNDxR3.getText() + "' , `DxC`='" + this.JTFCDxC.getText() + "' , `NDxC`='" + this.JTFNDxC.getText() + "' , `Id_Destino`='" + this.idDestino[this.JCBTipoDestino.getSelectedIndex()] + "' , `EstodoS`='" + this.estadoPaciente + "' , `DxMuerte`='" + this.JTFCDxR4.getText() + "' , `NDxM`='" + this.JTFNDxR4.getText() + "', `FechaSO`='" + this.xmetodo.formatoAMD.format(this.JDCFechaS.getDate()) + "', `HoraSO`='" + this.xmetodo.formatoH24.format(this.JTFFHora.getValue()) + "',ObservacionG='" + this.JTPConclusion.getText() + "',ObservacionG1='" + this.JTPRecomendaciones.getText() + "' Where Id='" + this.JLBNEgreso.getText() + "' AND Id_Profesional='" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "' AND Id_Especialidad='" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "'";
        this.xclase.mCambiarEstadoHc(1);
        this.xconsultasbd.ejecutarSQL(sql5);
        this.xconsultasbd.cerrarConexionBd();
        String sql6 = "UPDATE `h_egreso_atencion` INNER JOIN ingreso ON(ingreso.`Id`=`h_egreso_atencion`.`Id_Ingreso`)\nSET `h_egreso_atencion`.`Id_CausaExterna`=ingreso.`Id_CausaExterna` WHERE ingreso.`Id`='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdIngreso() + "'";
        this.xconsultasbd.ejecutarSQL(sql6);
        this.xconsultasbd.cerrarConexionBd();
        buscarEgreso();
    }

    /* JADX WARN: Finally extract failed */
    private void buscarEgreso() {
        try {
            String sql = "SELECT\n`h_egreso_atencion`.`Id`,\n`h_egreso_atencion`.`FechaSO`,\n`h_egreso_atencion`.`HoraSO`,\n`h_tipodiagnostico`.`Nbre` AS TipoDx,\n`h_egreso_atencion`.`DxP`,\n`h_egreso_atencion`.`NDxP`,\n`h_egreso_atencion`.`DxR1`,\n`h_egreso_atencion`.`NDxR1`,\n`h_egreso_atencion`.`DxR2`,\n`h_egreso_atencion`.`NDxR2`,\n`h_egreso_atencion`.`DxR3`,\n`h_egreso_atencion`.`NDxR3`,\n`g_tipodestino`.`Nbre` AS Destino,\n`h_egreso_atencion`.`EstodoS`,\n`h_egreso_atencion`.`DxMuerte`,\n`h_egreso_atencion`.`NDxM`,\n`h_egreso_atencion`.`ObservacionG`,\n`h_egreso_atencion`.`Estado`,\n`h_egreso_atencion`.`DxC`,\n`h_egreso_atencion`.`NDxC`,\n h_atencion.TipoGuardado,\n`h_egreso_atencion`.`ObservacionG1`,\n`g_tipodestino`.`Id` AS idDestino, \n`g_tipoatencion`.`Id` AS idTipoAtencion,\n`g_tipoatencion`.`Nbre` AS tipoAtencion\n FROM `h_egreso_atencion`\nINNER JOIN `g_tipodestino`   ON (`g_tipodestino`.`Id`=h_egreso_atencion.`Id_Destino`)\nINNER JOIN `h_atencion`  ON (`h_egreso_atencion`.`Id_Atencion` = `h_atencion`.`Id`)\nINNER JOIN `h_tipodiagnostico`  ON (h_tipodiagnostico.`Id`=h_egreso_atencion.`Id_TipoDx`)\nINNER JOIN `g_tipoatencion` ON (`g_tipoatencion`.`Id`=`h_egreso_atencion`.`Id_Tipo`)\n WHERE (  `h_egreso_atencion`.`Id_Atencion` = '" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "'  AND `h_egreso_atencion`.`Estado` = 1\n  AND `h_egreso_atencion`.Id_Tipo = '" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTipoAtencion() + "')";
            ResultSet xrs = this.xconsultasbd.traerRs(sql);
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
                    this.JCBTipoDestino.setSelectedItem(xrs.getString(13));
                    if (xrs.getInt(14) == 1) {
                        this.JRBEVivo.setSelected(true);
                    } else {
                        this.JRBEMuerto.setSelected(true);
                    }
                    this.JTFCDxR4.setText(xrs.getString(15));
                    this.JTFNDxR4.setText(xrs.getString(16));
                    this.JTPConclusion.setText(xrs.getString(17));
                    this.JTPRecomendaciones.setText(xrs.getString("ObservacionG1"));
                    if (xrs.getInt(23) > 1) {
                        this.JRBDHospitalizacion.setSelected(true);
                    } else {
                        this.JRBDAUrgencias.setSelected(true);
                    }
                    this.JCBServicios.setSelectedItem(xrs.getString(25));
                    if (xrs.getInt("TipoGuardado") != 1) {
                        this.JBTGuardar.setEnabled(true);
                        this.xEstado = 0;
                    } else {
                        this.JBTGuardar.setEnabled(false);
                        this.xEstado = 1;
                    }
                    mCambio_EstadoBoton();
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
                this.xconsultasbd.cerrarConexionBd();
            } catch (Throwable th3) {
                if (xrs != null) {
                    if (0 != 0) {
                        try {
                            xrs.close();
                        } catch (Throwable th4) {
                            th.addSuppressed(th4);
                        }
                    } else {
                        xrs.close();
                    }
                }
                throw th3;
            }
        } catch (SQLException ex) {
            Logger.getLogger(JPAConclusion.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mGrabarEgreso() {
        String xsql = "insert into h_egreso_atencion(`Id_Ingreso`, `Id_Atencion`, `Id_Tipo`,`Id_CausaExterna`, `DxP` , `NDxP` , `DxR1` , `NDxR1` , `DxR2` , `NDxR2` , `DxR3` , `NDxR3` ,  `Id_Destino` , `EstodoS` ,  `FechaSO`, `HoraSO`, `Id_Profesional` , `Id_Especialidad`, `UsuarioS`) values('" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdIngreso() + "','" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "','1','13','" + this.JTFCDxP.getText() + "','" + this.JTFNCodigoDxP.getText() + "','" + this.JTFCDxR1.getText() + "','" + this.JTFNDxR1.getText() + "','" + this.JTFCDxR2.getText() + "','" + this.JTFNDxR2.getText() + "','" + this.JTFCDxR3.getText() + "','" + this.JTFNDxR3.getText() + "','" + this.xdestino + "','1','" + this.xmetodo.formatoAMD.format(this.xmetodo.getFechaActual()) + "','" + this.xmetodo.formatoH24.format(this.xmetodo.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "','" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
        this.xconsultasbd.ejecutarSQL(xsql);
        this.xconsultasbd.cerrarConexionBd();
    }

    private void mActualizarDatosPyP() {
    }

    public void mAlmacenarBDTmp() {
        if (this.JBTGuardar.isEnabled()) {
            String sql = "update h_atencion set  Codigo_Dxp='" + this.JTFCDxP.getText() + "', Id_TipoDx='" + this.idtipodx[this.JCBTipoDx.getSelectedIndex()] + "', Codigo_DxR1='" + this.JTFCDxR1.getText() + "', Codigo_DxR2='" + this.JTFCDxR2.getText() + "', Codigo_DxR3='" + this.JTFCDxR3.getText() + "', DestinoP='" + this.xdestino + "', Conclusion='" + this.JTPConclusion.getText() + "', Estado='0', Fecha='" + this.xmetodo.formatoAMDH24.format(this.xmetodo.getFechaActual()) + "', Recomendaciones='" + this.JTPRecomendaciones.getText() + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' where id='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "'";
            this.xconsultasbd.ejecutarSQL(sql);
            this.xconsultasbd.cerrarConexionBd();
            this.xclase.mActualizarDx_Ingreso(this.JTFCDxP.getText());
            String sql2 = "delete from h_atenciondx where Id_Atencion='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "'";
            this.xconsultasbd.ejecutarSQL(sql2);
            this.xconsultasbd.cerrarConexionBd();
            if (!this.JTFCDxP.getText().isEmpty()) {
                String sql3 = "insert ignore into h_atenciondx (Id_Atencion, Id_Dx, Orden ) values('" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "','" + this.JTFCDxP.getText() + "','1')";
                this.xconsultasbd.ejecutarSQL(sql3);
                this.xconsultasbd.cerrarConexionBd();
            }
            if (!this.JTFCDxR1.getText().isEmpty()) {
                String sql4 = "insert ignore into h_atenciondx (Id_Atencion, Id_Dx, Orden ) values('" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "','" + this.JTFCDxR1.getText() + "','2')";
                this.xconsultasbd.ejecutarSQL(sql4);
                this.xconsultasbd.cerrarConexionBd();
            }
            if (!this.JTFCDxR2.getText().isEmpty()) {
                String sql5 = "insert ignore into h_atenciondx (Id_Atencion, Id_Dx, Orden ) values('" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "','" + this.JTFCDxR2.getText() + "','3')";
                this.xconsultasbd.ejecutarSQL(sql5);
                this.xconsultasbd.cerrarConexionBd();
            }
            if (!this.JTFCDxR3.getText().isEmpty()) {
                String sql6 = "insert ignore into h_atenciondx (Id_Atencion, Id_Dx, Orden ) values('" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "','" + this.JTFCDxR3.getText() + "','4')";
                this.xconsultasbd.ejecutarSQL(sql6);
                this.xconsultasbd.cerrarConexionBd();
            }
            String sql7 = "update ingreso set  DxIngreso='" + this.JTFCDxP.getText() + "' where Id='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdIngreso().longValue() + "'";
            this.xconsultasbd.ejecutarSQL(sql7);
            this.xconsultasbd.cerrarConexionBd();
        }
    }

    private void mBuscarDatosBd() {
        try {
            String sql = "SELECT h_atencion.Codigo_Dxp, g_patologia.Nbre, h_tipodiagnostico.Nbre, h_atencion.Codigo_DxR1, h_atencion.Codigo_DxR2, h_atencion.Codigo_DxR3, h_atencion.Conclusion, h_atencion.Recomendaciones, h_atencion.TipoGuardado FROM h_atencion INNER JOIN h_tipodiagnostico  ON (h_atencion.Id_TipoDx = h_tipodiagnostico.Id) INNER JOIN g_patologia ON (g_patologia.Id = h_atencion.Codigo_Dxp)  WHERE h_atencion.Id='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "'";
            ResultSet xrs = this.xconsultasbd.traerRs(sql);
            if (xrs.next()) {
                xrs.first();
                this.JTFCDxP.setText(xrs.getString(1));
                this.JTFNCodigoDxP.setText(xrs.getString(2));
                this.JCBTipoDx.setSelectedItem(xrs.getString(3));
                this.JTFCDxR1.setText(xrs.getString(4));
                this.JTFNDxR1.setText(mBuscarPatologias(xrs.getString(4)));
                this.JTFCDxR2.setText(xrs.getString(5));
                this.JTFNDxR2.setText(mBuscarPatologias(xrs.getString(5)));
                this.JTFCDxR3.setText(xrs.getString(6));
                this.JTFNDxR3.setText(mBuscarPatologias(xrs.getString(6)));
                this.JTPConclusion.setText(xrs.getString(7));
                this.JTPRecomendaciones.setText(xrs.getString(8));
                if (xrs.getInt(9) == 1) {
                    this.JBTGuardar.setEnabled(false);
                    this.xEstado = 0;
                    if (Principal.informacionIps.getNombreIps().equals("MINEROS S.A") || Principal.informacionIps.getNombreIps().equals("NEGOCIOS AGROFORESTALES S.A.S") || Principal.informacionIps.getNombreIps().equals("NEGOCIOS AGROFORESTALES S.A.S") || Principal.informacionIps.getNombreIps().equals("FUNDACION MINERO S.A") || Principal.informacionIps.getNombreIps().equals("MINEROS ALUVIAL S.A.S")) {
                        this.JBT_AbrirHC.setVisible(true);
                    }
                } else {
                    this.JBTGuardar.setEnabled(true);
                    this.xEstado = 1;
                }
                if (!xrs.getString(1).equals("")) {
                    this.xmetodo.cambiarEstadoValidadoItemHC(getName(), 1, true);
                }
            }
            xrs.close();
            this.xconsultasbd.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPAAtencion.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private String mBuscarPatologias(String xcodigo) {
        String xnombre = null;
        try {
            ConsultasMySQL xmt = new ConsultasMySQL();
            String sql = "SELECT Id, Nbre FROM g_patologia where Id='" + xcodigo + "'";
            ResultSet res = xmt.traerRs(sql);
            if (res.next()) {
                xnombre = res.getString(2);
            }
            res.close();
            xmt.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPAConclusion.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return xnombre;
    }

    private void mGenerarCorreo() {
        if (Principal.informacionIps.getEsFpz().intValue() == 0 && Principal.informacionIps.getNombreIps().equals("FUNDACIÓN PANZENÚ") && !this.JTFCDxP.getText().isEmpty()) {
            try {
                String sql = "SELECT r_patologiasreporte.Id_Programa FROM r_patologiasreporte INNER JOIN g_tipoentidad  ON (r_patologiasreporte.Id_TipoEntidadR = g_tipoentidad.Id)  WHERE (r_patologiasreporte.Id_Patologia ='" + this.JTFCDxP.getText() + "' AND g_tipoentidad.Es_institucion =3 AND r_patologiasreporte.Estado=1) ";
                ResultSet rs = this.xconsultasbd.traerRs(sql);
                if (rs.next()) {
                    String xsql = "SELECT Id_Programa, Id_Usuario, Estado FROM g_usuarioxprograma WHERE (Id_Programa ='" + rs.getString(1) + "' AND Id_Usuario ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "' AND Estado =0)";
                    ConsultasMySQL xct = new ConsultasMySQL();
                    ResultSet xrs = xct.traerRs(xsql);
                    if (!xrs.next()) {
                        String xfrom = System.getProperty("user.name") + "@fundacionpanzenu.org.co";
                        String mensaje = "La atención N° " + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + " con N° HC " + clasesHistoriaCE.informacionAgendaMedicaDTO.getNumeroHistoria() + " del paciente: " + clasesHistoriaCE.informacionAgendaMedicaDTO.getNombreUsuario() + "\ncon codigo de Dx Principal:" + this.JTFCDxP.getText() + " patologia sujeta a revisión por el programa de PYP. \n\nUsuario no registrado en los programas.\n\n\n\n" + Principal.usuarioSistemaDTO.getNombreUsuario() + "\n" + Principal.informacionGeneralPrincipalDTO.getNombreEspecialidad();
                        Email em = new Email();
                        em.Send(xfrom, mensaje, "pyp@fundacionpanzenu.org.co", "PATOLOGIAS PYP");
                    }
                    xrs.close();
                    xct.cerrarConexionBd();
                }
                rs.close();
                this.xconsultasbd.cerrarConexionBd();
                String sql2 = "SELECT r_patologiasreporte.Id_Programa FROM r_patologiasreporte INNER JOIN g_tipoentidad  ON (r_patologiasreporte.Id_TipoEntidadR = g_tipoentidad.Id)  WHERE (r_patologiasreporte.Id_Patologia ='" + this.JTFCDxP.getText() + "' AND g_tipoentidad.Es_institucion =1 AND g_tipoentidad.Id=4 AND r_patologiasreporte.Estado=1) ";
                ResultSet rs2 = this.xconsultasbd.traerRs(sql2);
                if (rs2.next()) {
                    rs2.first();
                    String xfrom2 = System.getProperty("user.name") + "@fundacionpanzenu.org.co";
                    String mensaje2 = "La atención N° " + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + " con N° HC " + clasesHistoriaCE.informacionAgendaMedicaDTO.getNombreUsuario() + " del paciente: " + clasesHistoriaCE.informacionAgendaMedicaDTO.getNombreUsuario() + "\ncon codigo de Dx Principal:" + this.JTFCDxP.getText() + " Es patología de Urticaria; posible evento adverso de tipo farmacológico.\n\n\n\n" + Principal.usuarioSistemaDTO.getNombreUsuario() + "\n" + Principal.informacionGeneralPrincipalDTO.getNombreEspecialidad();
                    Email em2 = new Email();
                    em2.Send(xfrom2, mensaje2, "eventosadversos@fundacionpanzenu.org.co", "PATOLOGIAS DE POSIBLE EVENTO ADVERSO");
                }
                rs2.close();
                this.xconsultasbd.cerrarConexionBd();
                String sql3 = "SELECT r_patologiasreporte.Id_Programa FROM r_patologiasreporte INNER JOIN g_tipoentidad  ON (r_patologiasreporte.Id_TipoEntidadR = g_tipoentidad.Id)  WHERE (r_patologiasreporte.Id_Patologia ='" + this.JTFCDxP.getText() + "' AND g_tipoentidad.Id=2 AND r_patologiasreporte.Estado=1) ";
                ResultSet rs3 = this.xconsultasbd.traerRs(sql3);
                if (rs3.next()) {
                    rs3.first();
                    String xfrom3 = System.getProperty("user.name") + "@fundacionpanzenu.org.co";
                    String mensaje3 = "La atención N° " + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + " con N° HC " + clasesHistoriaCE.informacionAgendaMedicaDTO.getNombreUsuario() + " del paciente: " + clasesHistoriaCE.informacionAgendaMedicaDTO.getNombreUsuario() + "\ncon codigo de Dx Principal:" + this.JTFCDxP.getText() + " Es patología de notificación obligatoria por el COVE.\n\n\n\n" + Principal.usuarioSistemaDTO.getNombreUsuario() + "\n" + Principal.informacionGeneralPrincipalDTO.getNombreEspecialidad();
                    Email em3 = new Email();
                    em3.Send(xfrom3, mensaje3, "cove@fundacionpanzenu.org.co", "PATOLOGIAS NOTIFICACIÓN COVE");
                }
                rs3.close();
                this.xconsultasbd.cerrarConexionBd();
            } catch (SQLException ex) {
                Logger.getLogger(JPAConclusion.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
    }

    public void mGrabarH(String idIngreso) {
        if (Principal.informacionIps.getNombreIps().equals("BIEN ESTAR SALUD BS S.A.S.")) {
            String[][] mparametros = new String[6][2];
            mparametros[0][0] = "idatencion1";
            mparametros[0][1] = clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion();
            mparametros[1][0] = "idpaciente1";
            mparametros[1][1] = clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido().toString();
            mparametros[2][0] = "tipoAtencion";
            mparametros[2][1] = clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTipoAtencion().toString();
            mparametros[3][0] = "SUBREPORT_DIR";
            mparametros[3][1] = this.xmetodo.getSO() + this.xmetodo.getBarra() + "Reportes" + this.xmetodo.getBarra();
            mparametros[4][0] = "SUBREPORTFIRMA_DIR";
            mparametros[4][1] = this.xmetodo.getSO() + this.xmetodo.getBarra() + "Firmas" + this.xmetodo.getBarra();
            this.xmetodo.GenerarPDFHistoriaSOBienestar(this.xmetodo.getRutaRep() + "Bienestar_H_HistoriaClinica_ConsultaExterna", mparametros, String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdIngreso()), false);
        }
    }

    public boolean mVerificar() {
        boolean estado = false;
        if (!this.JTFCDxP.getText().isEmpty()) {
            if (this.JCBTipoDx.getSelectedIndex() != -1) {
                estado = true;
            } else {
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un tipo de diagnostico", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                this.JCBTipoDx.requestFocus();
            }
        } else {
            JOptionPane.showInternalMessageDialog(this, "El Dx Principal no puede ser nulo", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
            this.JTFCDxP.requestFocus();
        }
        return estado;
    }

    private void mCargar_NotasP() {
        JD_NotasPredefinidas dialog = new JD_NotasPredefinidas((Frame) null, true, this.JTPConclusion, this.JTPRecomendaciones, 0);
        dialog.setLocationRelativeTo(this.xclase.xjifhistoriaclinica);
        dialog.setVisible(true);
    }

    private void mCambio_EstadoBoton() {
        if (this.xEstado == 1) {
            this.JBT_AbrirHC.setText("Abrir Hc");
        } else {
            this.JBT_AbrirHC.setText("Cerrar Hc");
        }
    }
}
