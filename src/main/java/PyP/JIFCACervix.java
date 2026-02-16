package PyP;

import Acceso.Principal;
import Citas.clasesCita;
import General.Anular;
import General.BuscarPersona;
import General.Persona;
import Historia.JPAAntecedenteGineco;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.genoma.plus.controller.laboratorio.ImpresionReporteCitologiaBethesda;
import com.genoma.plus.dao.impl.pyp.TipoSeguimientoCDAOImpl;
import com.genoma.plus.dao.impl.pyp.TomaMuestraCitologiaDAOImpl;
import com.genoma.plus.dao.pyp.TipoSeguimientoCDAO;
import com.genoma.plus.dao.pyp.TomaMuestraCitologiaDAO;
import com.genoma.plus.dto.pyp.CitologiaSeguimientoDTO;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyVetoException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:PyP/JIFCACervix.class */
public class JIFCACervix extends JInternalFrame {
    private TomaMuestraCitologiaDAO xCitologiaDAO;
    private TipoSeguimientoCDAO xTipoSeguimiento;
    private Metodos xmt;
    private ConsultasMySQL xct;
    public DefaultTableModel xmodelo;
    public DefaultTableModel xmodelo1;
    public DefaultTableModel xmodelor;
    public DefaultTableModel xModeloSeguimiento;
    private JPAAntecedenteGineco xjpantecedentesG;
    private ResultSet rs;
    private int filaGrid;
    private int xfilacuello;
    private int pVez;
    private int embarazada;
    private int xlactancia;
    private int xrespuesta1;
    private int xrespuesta2;
    private int xrespuesta3;
    private int xrespuesta4;
    private String[] lisEsquema;
    private String sql;
    private String xsql;
    private Object[] xdato;
    public Persona frmPersona;
    private clasePyP clasepyp;
    public boolean xllenoantecedentes;
    public boolean xencontroresultado;
    private String[] xridcalidad;
    private String[] xridconcepto;
    private String[] xridempresa;
    private String[] xidfriesgo;
    private String[] xidapatologicos;
    private String[] xidvcacervix;
    private String[] xidvgardacil;
    private String[] xidconducta;
    private String[] xIdTipoSeguimiento;
    private int modulo;
    private String valorAspecto;
    private boolean lleno;
    private String idResultadoCitologiaActual;
    private ButtonGroup JBGP1;
    private ButtonGroup JBGP2;
    private ButtonGroup JBGP3;
    private ButtonGroup JBGP4;
    private ButtonGroup JBG_Cuello;
    private JButton JBTAsignacionC;
    private JComboBox JCBAPatologicos;
    private JComboBox JCBCalidadM;
    private JComboBox JCBConducta;
    private JComboBox JCBEsquema;
    private JComboBox JCBFRiesgo;
    private JComboBox JCBTercero;
    private JComboBox JCBVCaCervix;
    private JComboBox JCBVGardacil;
    private JComboBox JCB_STipoSeguimiento;
    private JCheckBox JCHCalidad;
    private JCheckBox JCHEmbarazada;
    private JCheckBox JCHLactancia;
    private JCheckBox JCHPrimerVez;
    private JCheckBox JCHPrimerVez5;
    private JCheckBox JCH_Artrogico;
    private JCheckBox JCH_Ausente;
    private JCheckBox JCH_Congestivo;
    private JCheckBox JCH_Sano;
    public JDateChooser JDF_Fecha_Toma;
    private JDateChooser JDFecha;
    private JDateChooser JDFechaER;
    private JDateChooser JDSFecha;
    private JLabel JLBPregunta1;
    private JLabel JLBPregunta2;
    private JLabel JLBPregunta3;
    private JLabel JLBPregunta4;
    private JPanel JPIAntecendesG;
    private JPanel JPICuestionamiento;
    private JPanel JPIDToma;
    private JPanel JPIResultado;
    private JPanel JPITomaMuestra;
    private JPanel JPI_Seguimiento;
    private JRadioButton JRBP1No;
    private JRadioButton JRBP1Si;
    private JRadioButton JRBP2No;
    private JRadioButton JRBP2Si;
    private JRadioButton JRBP3No;
    private JRadioButton JRBP3Si;
    private JRadioButton JRBP4No;
    private JRadioButton JRBP4Si;
    private JScrollPane JSPAspectoCuello;
    private JScrollPane JSPHistorico;
    private JScrollPane JSPObservacion;
    private JScrollPane JSPObservacion1;
    private JScrollPane JSPObservacionRechazo;
    private JScrollPane JSPObservacionV;
    private JScrollPane JSPTtoHormonales;
    private JScrollPane JSP_Resultado;
    private JScrollPane JSP_SObservacion;
    private JScrollPane JS_SPHistorico;
    private JTextPane JTAAspetoCuello;
    private JTextPane JTAObservacionV;
    private JTextPane JTATtoHormonales;
    private JTextArea JTA_SObservacion;
    private JTable JTBHistorico;
    private JTable JTB_Resultado;
    private JTable JTB_SHistorico;
    public JTabbedPane JTPDatosP;
    private JTabbedPane JTPIDatosTM;
    private JTextPane JTPObservacion;
    private JTextPane JTPObservacionRechazo;
    private JTextPane JTP_Observacion;
    private JTextField JTXTConsecutivoI;
    private JLabel jLabel2;
    private JScrollPane jScrollPane1;
    private JTextField jTCargoQuienTomaLaCitologia;
    private JTextField jTNombreQuienTomaLaCitologia;
    private JTextArea jTSintomas;
    private JPanel panelPersona;

    public JIFCACervix(clasePyP clase, int modulo) {
        this.xmt = new Metodos();
        this.xct = new ConsultasMySQL();
        this.pVez = 1;
        this.embarazada = 0;
        this.xlactancia = 0;
        this.xrespuesta1 = 0;
        this.xrespuesta2 = 0;
        this.xrespuesta3 = 0;
        this.xrespuesta4 = -1;
        this.xllenoantecedentes = false;
        this.xencontroresultado = false;
        this.modulo = 0;
        this.idResultadoCitologiaActual = null;
        initComponents();
        springStart();
        this.modulo = modulo;
        this.clasepyp = clase;
        mCargarPanelPersona();
        mCargarPanelAG();
        mNuevo();
        mConsultarR((int) this.clasepyp.getXidrecepcion());
        if (Principal.claselab != null) {
            this.xjpantecedentesG.JBTGrabarA.setVisible(false);
        }
        if (modulo == 38) {
            this.JBTAsignacionC.setVisible(false);
            this.JTPDatosP.setSelectedIndex(1);
        }
    }

    public JIFCACervix(clasePyP clase, String xnhc) {
        this.xmt = new Metodos();
        this.xct = new ConsultasMySQL();
        this.pVez = 1;
        this.embarazada = 0;
        this.xlactancia = 0;
        this.xrespuesta1 = 0;
        this.xrespuesta2 = 0;
        this.xrespuesta3 = 0;
        this.xrespuesta4 = -1;
        this.xllenoantecedentes = false;
        this.xencontroresultado = false;
        this.modulo = 0;
        this.idResultadoCitologiaActual = null;
        initComponents();
        this.clasepyp = clase;
        mCargarPanelPersona();
        mCargarPanelAG();
        mNuevo();
        this.frmPersona.txtHistoria.setText(xnhc);
        this.frmPersona.buscar(2);
    }

    private void asignarCita() {
        if (!this.frmPersona.txtHistoria.getText().equals("")) {
            this.clasepyp.frmPrincipal.mActivarBarraMenu(this.clasepyp.frmPrincipal.xMenus.barraMnuCita, 5);
            Principal.clasescita.cargarPantalla(Principal.clasescita.frmPrincipal, "Citas");
            Principal.clasescita.frmCita.frmPersona.txtHistoria.setText(this.frmPersona.txtHistoria.getText());
            Principal.clasescita.frmCita.frmPersona.txtHistoria.transferFocus();
            Principal.clasescita.frmCita.frmPersona.buscar(1);
            return;
        }
        this.xmt.mostrarMensaje("Por favor seleccione un Usuario para asignar la Cita");
    }

    public void buscar() {
        if (this.frmPersona.getHistoria().equals("") && this.frmPersona.getApellido1().equals("") && this.frmPersona.getApellido2().endsWith("") && this.frmPersona.getNombre1().equals("") && this.frmPersona.getNombre2().equals("")) {
            this.xmt.mostrarMensaje("Por Favor seleccione un Usuario");
        } else {
            Buscar frmB = new Buscar(null, true, this);
            frmB.setVisible(true);
        }
    }

    public void limpiarTodo() {
        mNuevo();
        mCrearTablaHistorico();
    }

    /* JADX WARN: Type inference failed for: r3v154, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v180, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v202, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGP1 = new ButtonGroup();
        this.JBGP2 = new ButtonGroup();
        this.JBGP3 = new ButtonGroup();
        this.JBGP4 = new ButtonGroup();
        this.JBG_Cuello = new ButtonGroup();
        this.panelPersona = new JPanel();
        this.JTPDatosP = new JTabbedPane();
        this.JPITomaMuestra = new JPanel();
        this.JTPIDatosTM = new JTabbedPane();
        this.JPICuestionamiento = new JPanel();
        this.JLBPregunta1 = new JLabel();
        this.JLBPregunta2 = new JLabel();
        this.JLBPregunta3 = new JLabel();
        this.JRBP1Si = new JRadioButton();
        this.JRBP1No = new JRadioButton();
        this.JRBP2Si = new JRadioButton();
        this.JRBP2No = new JRadioButton();
        this.JRBP3Si = new JRadioButton();
        this.JRBP3No = new JRadioButton();
        this.JLBPregunta4 = new JLabel();
        this.JRBP4Si = new JRadioButton();
        this.JRBP4No = new JRadioButton();
        this.JSPObservacionV = new JScrollPane();
        this.JTAObservacionV = new JTextPane();
        this.JTXTConsecutivoI = new JTextField();
        this.JPIAntecendesG = new JPanel();
        this.JPIDToma = new JPanel();
        this.JCBEsquema = new JComboBox();
        this.JCHPrimerVez = new JCheckBox();
        this.JCHLactancia = new JCheckBox();
        this.JCHEmbarazada = new JCheckBox();
        this.JSPTtoHormonales = new JScrollPane();
        this.JTATtoHormonales = new JTextPane();
        this.JSPObservacion = new JScrollPane();
        this.JTP_Observacion = new JTextPane();
        this.JSPAspectoCuello = new JScrollPane();
        this.JTAAspetoCuello = new JTextPane();
        this.JCBFRiesgo = new JComboBox();
        this.JCBAPatologicos = new JComboBox();
        this.JCBVCaCervix = new JComboBox();
        this.JCBVGardacil = new JComboBox();
        this.JCH_Sano = new JCheckBox();
        this.JCH_Ausente = new JCheckBox();
        this.JCH_Congestivo = new JCheckBox();
        this.JCH_Artrogico = new JCheckBox();
        this.JCHPrimerVez5 = new JCheckBox();
        this.jTCargoQuienTomaLaCitologia = new JTextField();
        this.jTNombreQuienTomaLaCitologia = new JTextField();
        this.jScrollPane1 = new JScrollPane();
        this.jTSintomas = new JTextArea();
        this.JDF_Fecha_Toma = new JDateChooser();
        this.JPIResultado = new JPanel();
        this.JDFecha = new JDateChooser();
        this.JCBCalidadM = new JComboBox();
        this.JSPObservacionRechazo = new JScrollPane();
        this.JTPObservacionRechazo = new JTextPane();
        this.JSPObservacion1 = new JScrollPane();
        this.JTPObservacion = new JTextPane();
        this.JCBTercero = new JComboBox();
        this.JBTAsignacionC = new JButton();
        this.JDFechaER = new JDateChooser();
        this.JCBConducta = new JComboBox();
        this.JSP_Resultado = new JScrollPane();
        this.JTB_Resultado = new JTable();
        this.JCHCalidad = new JCheckBox();
        this.JPI_Seguimiento = new JPanel();
        this.JDSFecha = new JDateChooser();
        this.JCB_STipoSeguimiento = new JComboBox();
        this.JSP_SObservacion = new JScrollPane();
        this.JTA_SObservacion = new JTextArea();
        this.JS_SPHistorico = new JScrollPane();
        this.JTB_SHistorico = new JTable();
        this.JSPHistorico = new JScrollPane();
        this.JTBHistorico = new JTable();
        this.jLabel2 = new JLabel();
        setClosable(true);
        setIconifiable(true);
        setTitle("TOMA DE MUESTRA PARA CITOLOGÍA");
        setDoubleBuffered(true);
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMaximumSize(null);
        setMinimumSize(null);
        setName("CACervixToma");
        addInternalFrameListener(new InternalFrameListener() { // from class: PyP.JIFCACervix.1
            public void internalFrameActivated(InternalFrameEvent evt) {
                JIFCACervix.this.formInternalFrameActivated(evt);
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIFCACervix.this.formInternalFrameClosing(evt);
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
        this.panelPersona.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS DE USUARIO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        GroupLayout panelPersonaLayout = new GroupLayout(this.panelPersona);
        this.panelPersona.setLayout(panelPersonaLayout);
        panelPersonaLayout.setHorizontalGroup(panelPersonaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 961, 32767));
        panelPersonaLayout.setVerticalGroup(panelPersonaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 170, 32767));
        this.JTPDatosP.setForeground(new Color(0, 103, 0));
        this.JTPDatosP.setFont(new Font("Arial", 1, 14));
        this.JTPIDatosTM.setForeground(Color.red);
        this.JTPIDatosTM.setFont(new Font("Arial", 1, 14));
        this.JLBPregunta1.setFont(new Font("Arial", 1, 12));
        this.JLBPregunta1.setText("1. HA TENIDO ABSTINENCIA SEXUAL 24 HORAS ANTES DEL ESTUDIO, EXCEPTO SI HA USADO PRESERVATIVO.");
        this.JLBPregunta2.setFont(new Font("Arial", 1, 12));
        this.JLBPregunta2.setText("2. SE HA APLICADO MEDICAMENTOS O DISPOSITIVOS VAGINALES EN LOS ÚLTIMOS 8 DÍAS.");
        this.JLBPregunta3.setFont(new Font("Arial", 1, 12));
        this.JLBPregunta3.setText("3. SE REALIZÓ DUCHAS VAGINALES EL DÍA ANTERIOR.");
        this.JBGP1.add(this.JRBP1Si);
        this.JRBP1Si.setFont(new Font("Arial", 1, 12));
        this.JRBP1Si.setText("SI");
        this.JRBP1Si.addActionListener(new ActionListener() { // from class: PyP.JIFCACervix.2
            public void actionPerformed(ActionEvent evt) {
                JIFCACervix.this.JRBP1SiActionPerformed(evt);
            }
        });
        this.JBGP1.add(this.JRBP1No);
        this.JRBP1No.setFont(new Font("Arial", 1, 12));
        this.JRBP1No.setSelected(true);
        this.JRBP1No.setText("No");
        this.JRBP1No.addActionListener(new ActionListener() { // from class: PyP.JIFCACervix.3
            public void actionPerformed(ActionEvent evt) {
                JIFCACervix.this.JRBP1NoActionPerformed(evt);
            }
        });
        this.JBGP2.add(this.JRBP2Si);
        this.JRBP2Si.setFont(new Font("Arial", 1, 12));
        this.JRBP2Si.setText("SI");
        this.JRBP2Si.addActionListener(new ActionListener() { // from class: PyP.JIFCACervix.4
            public void actionPerformed(ActionEvent evt) {
                JIFCACervix.this.JRBP2SiActionPerformed(evt);
            }
        });
        this.JBGP2.add(this.JRBP2No);
        this.JRBP2No.setFont(new Font("Arial", 1, 12));
        this.JRBP2No.setSelected(true);
        this.JRBP2No.setText("No");
        this.JRBP2No.addActionListener(new ActionListener() { // from class: PyP.JIFCACervix.5
            public void actionPerformed(ActionEvent evt) {
                JIFCACervix.this.JRBP2NoActionPerformed(evt);
            }
        });
        this.JBGP3.add(this.JRBP3Si);
        this.JRBP3Si.setFont(new Font("Arial", 1, 12));
        this.JRBP3Si.setText("SI");
        this.JRBP3Si.addActionListener(new ActionListener() { // from class: PyP.JIFCACervix.6
            public void actionPerformed(ActionEvent evt) {
                JIFCACervix.this.JRBP3SiActionPerformed(evt);
            }
        });
        this.JBGP3.add(this.JRBP3No);
        this.JRBP3No.setFont(new Font("Arial", 1, 12));
        this.JRBP3No.setSelected(true);
        this.JRBP3No.setText("No");
        this.JRBP3No.addActionListener(new ActionListener() { // from class: PyP.JIFCACervix.7
            public void actionPerformed(ActionEvent evt) {
                JIFCACervix.this.JRBP3NoActionPerformed(evt);
            }
        });
        this.JLBPregunta4.setFont(new Font("Arial", 1, 12));
        this.JLBPregunta4.setForeground(new Color(0, 0, 255));
        this.JLBPregunta4.setText("PROCEDER CON LA TOMA DE LA CITOLOGÍA?");
        this.JBGP4.add(this.JRBP4Si);
        this.JRBP4Si.setFont(new Font("Arial", 1, 12));
        this.JRBP4Si.setText("SI");
        this.JRBP4Si.addActionListener(new ActionListener() { // from class: PyP.JIFCACervix.8
            public void actionPerformed(ActionEvent evt) {
                JIFCACervix.this.JRBP4SiActionPerformed(evt);
            }
        });
        this.JBGP4.add(this.JRBP4No);
        this.JRBP4No.setFont(new Font("Arial", 1, 12));
        this.JRBP4No.setText("No");
        this.JRBP4No.addActionListener(new ActionListener() { // from class: PyP.JIFCACervix.9
            public void actionPerformed(ActionEvent evt) {
                JIFCACervix.this.JRBP4NoActionPerformed(evt);
            }
        });
        this.JSPObservacionV.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTAObservacionV.setFont(new Font("Arial", 1, 12));
        this.JSPObservacionV.setViewportView(this.JTAObservacionV);
        this.JTXTConsecutivoI.setBorder(BorderFactory.createTitledBorder((Border) null, "Consecutivo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTXTConsecutivoI.setEnabled(false);
        GroupLayout JPICuestionamientoLayout = new GroupLayout(this.JPICuestionamiento);
        this.JPICuestionamiento.setLayout(JPICuestionamientoLayout);
        JPICuestionamientoLayout.setHorizontalGroup(JPICuestionamientoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPICuestionamientoLayout.createSequentialGroup().addGroup(JPICuestionamientoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPICuestionamientoLayout.createSequentialGroup().addGap(36, 36, 36).addGroup(JPICuestionamientoLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JLBPregunta3, -2, 662, -2).addComponent(this.JLBPregunta2, -2, 662, -2).addComponent(this.JLBPregunta1, -2, 662, -2)).addGap(40, 40, 40)).addGroup(GroupLayout.Alignment.TRAILING, JPICuestionamientoLayout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(JPICuestionamientoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(GroupLayout.Alignment.TRAILING, JPICuestionamientoLayout.createSequentialGroup().addComponent(this.JSPObservacionV).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)).addGroup(GroupLayout.Alignment.TRAILING, JPICuestionamientoLayout.createSequentialGroup().addComponent(this.JLBPregunta4, -2, 277, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBP4Si).addGap(18, 18, 18).addComponent(this.JRBP4No).addGap(18, 18, 18).addComponent(this.JTXTConsecutivoI, -2, 189, -2).addGap(145, 145, 145))))).addGroup(JPICuestionamientoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPICuestionamientoLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPICuestionamientoLayout.createSequentialGroup().addComponent(this.JRBP1Si).addGap(18, 18, 18).addComponent(this.JRBP1No)).addGroup(JPICuestionamientoLayout.createSequentialGroup().addComponent(this.JRBP2Si).addGap(18, 18, 18).addComponent(this.JRBP2No))).addGroup(JPICuestionamientoLayout.createSequentialGroup().addComponent(this.JRBP3Si).addGap(18, 18, 18).addComponent(this.JRBP3No))).addContainerGap(239, 32767)));
        JPICuestionamientoLayout.setVerticalGroup(JPICuestionamientoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPICuestionamientoLayout.createSequentialGroup().addGap(35, 35, 35).addGroup(JPICuestionamientoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JLBPregunta1, -2, 28, -2).addComponent(this.JRBP1Si).addComponent(this.JRBP1No)).addGap(18, 18, 18).addGroup(JPICuestionamientoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JLBPregunta2, -2, 28, -2).addComponent(this.JRBP2Si).addComponent(this.JRBP2No)).addGap(18, 18, 18).addGroup(JPICuestionamientoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JLBPregunta3, -2, 28, -2).addComponent(this.JRBP3Si).addComponent(this.JRBP3No)).addGap(47, 47, 47).addGroup(JPICuestionamientoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JLBPregunta4, -2, 28, -2).addComponent(this.JRBP4Si).addComponent(this.JRBP4No).addComponent(this.JTXTConsecutivoI, -2, -1, -2)).addGap(18, 18, 18).addComponent(this.JSPObservacionV, -2, 165, -2).addContainerGap(-1, 32767)));
        this.JTPIDatosTM.addTab("VERIFICACIÓN", this.JPICuestionamiento);
        this.JPIAntecendesG.setPreferredSize(new Dimension(1067, 437));
        GroupLayout JPIAntecendesGLayout = new GroupLayout(this.JPIAntecendesG);
        this.JPIAntecendesG.setLayout(JPIAntecendesGLayout);
        JPIAntecendesGLayout.setHorizontalGroup(JPIAntecendesGLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 1067, 32767));
        JPIAntecendesGLayout.setVerticalGroup(JPIAntecendesGLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 437, 32767));
        this.JTPIDatosTM.addTab("ANTECEDENTES GINECO-OBSTETRICOS", this.JPIAntecendesG);
        this.JCBEsquema.setFont(new Font("Arial", 1, 12));
        this.JCBEsquema.setBorder(BorderFactory.createTitledBorder((Border) null, "Esquema", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHPrimerVez.setFont(new Font("Arial", 1, 12));
        this.JCHPrimerVez.setForeground(Color.blue);
        this.JCHPrimerVez.setText("Primer Vez");
        this.JCHPrimerVez.addActionListener(new ActionListener() { // from class: PyP.JIFCACervix.10
            public void actionPerformed(ActionEvent evt) {
                JIFCACervix.this.JCHPrimerVezActionPerformed(evt);
            }
        });
        this.JCHLactancia.setFont(new Font("Arial", 1, 12));
        this.JCHLactancia.setForeground(Color.blue);
        this.JCHLactancia.setText("Lactancia");
        this.JCHLactancia.addActionListener(new ActionListener() { // from class: PyP.JIFCACervix.11
            public void actionPerformed(ActionEvent evt) {
                JIFCACervix.this.JCHLactanciaActionPerformed(evt);
            }
        });
        this.JCHEmbarazada.setFont(new Font("Arial", 1, 12));
        this.JCHEmbarazada.setForeground(Color.blue);
        this.JCHEmbarazada.setText("Embarazada");
        this.JCHEmbarazada.addActionListener(new ActionListener() { // from class: PyP.JIFCACervix.12
            public void actionPerformed(ActionEvent evt) {
                JIFCACervix.this.JCHEmbarazadaActionPerformed(evt);
            }
        });
        this.JSPTtoHormonales.setBorder(BorderFactory.createTitledBorder((Border) null, "Tratamiento Hormonal", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPTtoHormonales.setFont(new Font("Arial", 1, 12));
        this.JSPTtoHormonales.setViewportView(this.JTATtoHormonales);
        this.JSPObservacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTP_Observacion.setFont(new Font("Arial", 1, 12));
        this.JSPObservacion.setViewportView(this.JTP_Observacion);
        this.JSPAspectoCuello.setBorder(BorderFactory.createTitledBorder((Border) null, "Aspecto del Cuello", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTAAspetoCuello.setFont(new Font("Arial", 1, 12));
        this.JSPAspectoCuello.setViewportView(this.JTAAspetoCuello);
        this.JCBFRiesgo.setFont(new Font("Arial", 1, 12));
        this.JCBFRiesgo.setBorder(BorderFactory.createTitledBorder((Border) null, "Factor Riesgo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBAPatologicos.setFont(new Font("Arial", 1, 12));
        this.JCBAPatologicos.setBorder(BorderFactory.createTitledBorder((Border) null, "Antecedentes Patológicos", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBVCaCervix.setFont(new Font("Arial", 1, 12));
        this.JCBVCaCervix.setBorder(BorderFactory.createTitledBorder((Border) null, "Vacuna Ca Cervix (Dosis)", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBVGardacil.setFont(new Font("Arial", 1, 12));
        this.JCBVGardacil.setBorder(BorderFactory.createTitledBorder((Border) null, "Vacuna Gardacil (Dosis)", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBG_Cuello.add(this.JCH_Sano);
        this.JCH_Sano.setFont(new Font("Arial", 1, 12));
        this.JCH_Sano.setForeground(Color.blue);
        this.JCH_Sano.setSelected(true);
        this.JCH_Sano.setText("Sano");
        this.JCH_Sano.addActionListener(new ActionListener() { // from class: PyP.JIFCACervix.13
            public void actionPerformed(ActionEvent evt) {
                JIFCACervix.this.JCH_SanoActionPerformed(evt);
            }
        });
        this.JBG_Cuello.add(this.JCH_Ausente);
        this.JCH_Ausente.setFont(new Font("Arial", 1, 12));
        this.JCH_Ausente.setForeground(Color.blue);
        this.JCH_Ausente.setText("Ausente");
        this.JCH_Ausente.addActionListener(new ActionListener() { // from class: PyP.JIFCACervix.14
            public void actionPerformed(ActionEvent evt) {
                JIFCACervix.this.JCH_AusenteActionPerformed(evt);
            }
        });
        this.JBG_Cuello.add(this.JCH_Congestivo);
        this.JCH_Congestivo.setFont(new Font("Arial", 1, 12));
        this.JCH_Congestivo.setForeground(Color.blue);
        this.JCH_Congestivo.setText("Congestivo");
        this.JCH_Congestivo.addActionListener(new ActionListener() { // from class: PyP.JIFCACervix.15
            public void actionPerformed(ActionEvent evt) {
                JIFCACervix.this.JCH_CongestivoActionPerformed(evt);
            }
        });
        this.JBG_Cuello.add(this.JCH_Artrogico);
        this.JCH_Artrogico.setFont(new Font("Arial", 1, 12));
        this.JCH_Artrogico.setForeground(Color.blue);
        this.JCH_Artrogico.setText("Artrófico");
        this.JCH_Artrogico.addActionListener(new ActionListener() { // from class: PyP.JIFCACervix.16
            public void actionPerformed(ActionEvent evt) {
                JIFCACervix.this.JCH_ArtrogicoActionPerformed(evt);
            }
        });
        this.JBG_Cuello.add(this.JCHPrimerVez5);
        this.JCHPrimerVez5.setFont(new Font("Arial", 1, 12));
        this.JCHPrimerVez5.setForeground(Color.blue);
        this.JCHPrimerVez5.setText("Anomal");
        this.JCHPrimerVez5.addActionListener(new ActionListener() { // from class: PyP.JIFCACervix.17
            public void actionPerformed(ActionEvent evt) {
                JIFCACervix.this.JCHPrimerVez5ActionPerformed(evt);
            }
        });
        this.jTCargoQuienTomaLaCitologia.setBorder(BorderFactory.createTitledBorder((Border) null, "Cargo", 0, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.jTNombreQuienTomaLaCitologia.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre de quien toma la citologia", 0, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.jTSintomas.setColumns(20);
        this.jTSintomas.setRows(5);
        this.jTSintomas.setBorder(BorderFactory.createTitledBorder((Border) null, "Sintomas", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jScrollPane1.setViewportView(this.jTSintomas);
        this.JDF_Fecha_Toma.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Toma", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDF_Fecha_Toma.setDateFormatString("dd/MM/yyyy");
        this.JDF_Fecha_Toma.setFont(new Font("Arial", 1, 12));
        this.JDF_Fecha_Toma.addPropertyChangeListener(new PropertyChangeListener() { // from class: PyP.JIFCACervix.18
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFCACervix.this.JDF_Fecha_TomaPropertyChange(evt);
            }
        });
        GroupLayout JPIDTomaLayout = new GroupLayout(this.JPIDToma);
        this.JPIDToma.setLayout(JPIDTomaLayout);
        JPIDTomaLayout.setHorizontalGroup(JPIDTomaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDTomaLayout.createSequentialGroup().addContainerGap().addGroup(JPIDTomaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDTomaLayout.createSequentialGroup().addComponent(this.JDF_Fecha_Toma, -2, 117, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 10, 32767).addComponent(this.JCBFRiesgo, -2, 184, -2).addGap(18, 18, 18).addComponent(this.JCBAPatologicos, -2, 265, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBEsquema, -2, 183, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDTomaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHPrimerVez).addGroup(JPIDTomaLayout.createSequentialGroup().addComponent(this.JCHLactancia).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHEmbarazada))).addGap(87, 87, 87)).addGroup(JPIDTomaLayout.createSequentialGroup().addGroup(JPIDTomaLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JSPObservacion).addComponent(this.JCBVCaCervix, 0, -1, 32767).addComponent(this.JSPAspectoCuello, -1, 442, 32767).addGroup(JPIDTomaLayout.createSequentialGroup().addComponent(this.JCH_Sano).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCH_Ausente).addGap(18, 18, 18).addComponent(this.JCH_Congestivo).addGap(18, 18, 18).addComponent(this.JCH_Artrogico).addGap(18, 18, 18).addComponent(this.JCHPrimerVez5))).addGap(18, 18, 18).addGroup(JPIDTomaLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.jTNombreQuienTomaLaCitologia, GroupLayout.Alignment.LEADING).addComponent(this.JSPTtoHormonales, GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.LEADING, JPIDTomaLayout.createSequentialGroup().addGap(3, 3, 3).addGroup(JPIDTomaLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JCBVGardacil, 0, 474, 32767).addComponent(this.jScrollPane1))).addComponent(this.jTCargoQuienTomaLaCitologia)).addContainerGap(124, 32767)))));
        JPIDTomaLayout.setVerticalGroup(JPIDTomaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDTomaLayout.createSequentialGroup().addGroup(JPIDTomaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDTomaLayout.createSequentialGroup().addGap(20, 20, 20).addGroup(JPIDTomaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDTomaLayout.createSequentialGroup().addComponent(this.JCHPrimerVez).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDTomaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCHLactancia).addComponent(this.JCHEmbarazada))).addGroup(JPIDTomaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBEsquema).addComponent(this.JCBAPatologicos).addComponent(this.JCBFRiesgo, -2, -1, -2)))).addGroup(GroupLayout.Alignment.TRAILING, JPIDTomaLayout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JDF_Fecha_Toma, -2, 50, -2))).addGap(18, 18, 18).addGroup(JPIDTomaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBVCaCervix, -1, 83, 32767).addComponent(this.JCBVGardacil)).addGroup(JPIDTomaLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPIDTomaLayout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(JPIDTomaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCH_Sano).addComponent(this.JCH_Ausente).addComponent(this.JCH_Congestivo).addComponent(this.JCH_Artrogico).addComponent(this.JCHPrimerVez5)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JSPAspectoCuello, -2, 68, -2)).addGroup(JPIDTomaLayout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.jScrollPane1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPTtoHormonales, -2, -1, -2))).addGap(18, 18, 18).addGroup(JPIDTomaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPObservacion, -2, 102, -2).addGroup(JPIDTomaLayout.createSequentialGroup().addComponent(this.jTNombreQuienTomaLaCitologia, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jTCargoQuienTomaLaCitologia, -2, -1, -2))).addContainerGap()));
        this.JTPIDatosTM.addTab("TOMA", this.JPIDToma);
        GroupLayout JPITomaMuestraLayout = new GroupLayout(this.JPITomaMuestra);
        this.JPITomaMuestra.setLayout(JPITomaMuestraLayout);
        JPITomaMuestraLayout.setHorizontalGroup(JPITomaMuestraLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPITomaMuestraLayout.createSequentialGroup().addGap(5, 5, 5).addComponent(this.JTPIDatosTM, -2, -1, -2).addGap(5, 5, 5)));
        JPITomaMuestraLayout.setVerticalGroup(JPITomaMuestraLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTPIDatosTM, GroupLayout.Alignment.TRAILING));
        this.JTPDatosP.addTab("DATOS DE LA TOMA DE LA CITOLOGÍA", this.JPITomaMuestra);
        this.JDFecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JDFecha.setDateFormatString("dd/MM/yyyy");
        this.JDFecha.setFont(new Font("Arial", 1, 12));
        this.JCBCalidadM.setFont(new Font("Arial", 1, 12));
        this.JCBCalidadM.setBorder(BorderFactory.createTitledBorder((Border) null, "Calidad Muestra", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBCalidadM.addItemListener(new ItemListener() { // from class: PyP.JIFCACervix.19
            public void itemStateChanged(ItemEvent evt) {
                JIFCACervix.this.JCBCalidadMItemStateChanged(evt);
            }
        });
        this.JSPObservacionRechazo.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación(Insatisfacción o rechazo)", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTPObservacionRechazo.setFont(new Font("Arial", 1, 12));
        this.JSPObservacionRechazo.setViewportView(this.JTPObservacionRechazo);
        this.JSPObservacion1.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTPObservacion.setFont(new Font("Arial", 1, 12));
        this.JSPObservacion1.setViewportView(this.JTPObservacion);
        this.JCBTercero.setFont(new Font("Arial", 1, 12));
        this.JCBTercero.setBorder(BorderFactory.createTitledBorder((Border) null, "Empresa donde se toma la citología", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBTAsignacionC.setFont(new Font("Arial", 1, 12));
        this.JBTAsignacionC.setIcon(new ImageIcon(getClass().getResource("/Imagenes/AgendaMedica.png")));
        this.JBTAsignacionC.setText("Asignación Citas");
        this.JBTAsignacionC.addActionListener(new ActionListener() { // from class: PyP.JIFCACervix.20
            public void actionPerformed(ActionEvent evt) {
                JIFCACervix.this.JBTAsignacionCActionPerformed(evt);
            }
        });
        this.JDFechaER.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Entrega Resultado", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JDFechaER.setDateFormatString("dd/MM/yyyy");
        this.JDFechaER.setFont(new Font("Arial", 1, 12));
        this.JCBConducta.setFont(new Font("Arial", 1, 12));
        this.JCBConducta.setBorder(BorderFactory.createTitledBorder((Border) null, "Conducta", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSP_Resultado.setBorder(BorderFactory.createTitledBorder((Border) null, "CONCEPTO DE ESTUDIO (BETHESDA)", 2, 0, new Font("Arial", 1, 12), Color.red));
        this.JTB_Resultado.setFont(new Font("Arial", 1, 12));
        this.JTB_Resultado.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTB_Resultado.setRowHeight(25);
        this.JTB_Resultado.setSelectionBackground(new Color(255, 255, 255));
        this.JTB_Resultado.setSelectionForeground(new Color(255, 0, 0));
        this.JTB_Resultado.addMouseListener(new MouseAdapter() { // from class: PyP.JIFCACervix.21
            public void mouseClicked(MouseEvent evt) {
                JIFCACervix.this.JTB_ResultadoMouseClicked(evt);
            }
        });
        this.JSP_Resultado.setViewportView(this.JTB_Resultado);
        this.JCHCalidad.setFont(new Font("Arial", 1, 13));
        this.JCHCalidad.setForeground(new Color(255, 0, 0));
        this.JCHCalidad.setText("Control de calidad?");
        GroupLayout JPIResultadoLayout = new GroupLayout(this.JPIResultado);
        this.JPIResultado.setLayout(JPIResultadoLayout);
        JPIResultadoLayout.setHorizontalGroup(JPIResultadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIResultadoLayout.createSequentialGroup().addGroup(JPIResultadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIResultadoLayout.createSequentialGroup().addGap(10, 10, 10).addGroup(JPIResultadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIResultadoLayout.createSequentialGroup().addComponent(this.JDFecha, -2, 120, -2).addGap(18, 18, 18).addComponent(this.JCBCalidadM, -2, 290, -2)).addComponent(this.JSPObservacion1, -2, 430, -2).addComponent(this.JCBTercero, -2, 430, -2).addGroup(JPIResultadoLayout.createSequentialGroup().addGroup(JPIResultadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JDFechaER, -2, 169, -2).addComponent(this.JCHCalidad)).addGap(18, 18, 18).addComponent(this.JCBConducta, -2, 240, -2)))).addGroup(JPIResultadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIResultadoLayout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.JSPObservacionRechazo, -2, 430, -2)).addGroup(JPIResultadoLayout.createSequentialGroup().addContainerGap().addComponent(this.JBTAsignacionC, -2, 434, -2)))).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSP_Resultado, -1, 668, 32767).addContainerGap()));
        JPIResultadoLayout.setVerticalGroup(JPIResultadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIResultadoLayout.createSequentialGroup().addContainerGap().addGroup(JPIResultadoLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPIResultadoLayout.createSequentialGroup().addGroup(JPIResultadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JDFecha, -2, -1, -2).addComponent(this.JCBCalidadM, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPObservacionRechazo, -2, 71, -2).addGap(5, 5, 5).addComponent(this.JSPObservacion1, -2, 71, -2).addGap(11, 11, 11).addComponent(this.JCBTercero, -2, 50, -2).addGap(11, 11, 11).addGroup(JPIResultadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JCBConducta, -1, 50, 32767).addComponent(this.JDFechaER, -1, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHCalidad).addGap(5, 5, 5).addComponent(this.JBTAsignacionC, -2, 43, -2)).addComponent(this.JSP_Resultado, -2, 420, -2)).addContainerGap(58, 32767)));
        this.JTPDatosP.addTab("RESULTADO", this.JPIResultado);
        this.JDSFecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JDSFecha.setDateFormatString("dd/MM/yyyy");
        this.JDSFecha.setFont(new Font("Arial", 1, 12));
        this.JCB_STipoSeguimiento.setFont(new Font("Arial", 1, 12));
        this.JCB_STipoSeguimiento.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSP_SObservacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Observacion", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTA_SObservacion.setColumns(20);
        this.JTA_SObservacion.setRows(5);
        this.JSP_SObservacion.setViewportView(this.JTA_SObservacion);
        this.JS_SPHistorico.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTB_SHistorico.setFont(new Font("Arial", 1, 12));
        this.JTB_SHistorico.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTB_SHistorico.setRowHeight(25);
        this.JTB_SHistorico.setSelectionBackground(new Color(255, 255, 255));
        this.JTB_SHistorico.setSelectionForeground(new Color(255, 0, 0));
        this.JTB_SHistorico.setSelectionMode(0);
        this.JTB_SHistorico.addMouseListener(new MouseAdapter() { // from class: PyP.JIFCACervix.22
            public void mouseClicked(MouseEvent evt) {
                JIFCACervix.this.JTB_SHistoricoMouseClicked(evt);
            }
        });
        this.JS_SPHistorico.setViewportView(this.JTB_SHistorico);
        GroupLayout JPI_SeguimientoLayout = new GroupLayout(this.JPI_Seguimiento);
        this.JPI_Seguimiento.setLayout(JPI_SeguimientoLayout);
        JPI_SeguimientoLayout.setHorizontalGroup(JPI_SeguimientoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_SeguimientoLayout.createSequentialGroup().addContainerGap().addGroup(JPI_SeguimientoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSP_SObservacion).addGroup(JPI_SeguimientoLayout.createSequentialGroup().addComponent(this.JDSFecha, -2, 120, -2).addGap(18, 18, 18).addComponent(this.JCB_STipoSeguimiento, -2, 290, -2).addGap(0, 0, 32767)).addComponent(this.JS_SPHistorico, -1, 1114, 32767)).addContainerGap()));
        JPI_SeguimientoLayout.setVerticalGroup(JPI_SeguimientoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_SeguimientoLayout.createSequentialGroup().addGap(29, 29, 29).addGroup(JPI_SeguimientoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JDSFecha, -2, -1, -2).addComponent(this.JCB_STipoSeguimiento, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSP_SObservacion, -2, 115, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JS_SPHistorico, -1, 243, 32767).addContainerGap()));
        this.JTPDatosP.addTab("SEGUIMIENTO", this.JPI_Seguimiento);
        this.JTBHistorico.setFont(new Font("Arial", 1, 12));
        this.JTBHistorico.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTBHistorico.setRowHeight(25);
        this.JTBHistorico.setSelectionBackground(new Color(255, 255, 255));
        this.JTBHistorico.setSelectionForeground(new Color(255, 0, 0));
        this.JTBHistorico.setSelectionMode(0);
        this.JTBHistorico.addMouseListener(new MouseAdapter() { // from class: PyP.JIFCACervix.23
            public void mouseClicked(MouseEvent evt) {
                JIFCACervix.this.JTBHistoricoMouseClicked(evt);
            }
        });
        this.JSPHistorico.setViewportView(this.JTBHistorico);
        this.JTPDatosP.addTab("HISTÓRICO", this.JSPHistorico);
        this.jLabel2.setFont(new Font("Arial", 1, 12));
        this.jLabel2.setForeground(Color.red);
        this.jLabel2.setHorizontalAlignment(0);
        this.jLabel2.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Placa", 2, 0, new Font("Arial", 1, 14), Color.blue));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(5, 5, 5).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.panelPersona, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel2, -1, -1, 32767)).addComponent(this.JTPDatosP)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(5, 5, 5).addComponent(this.panelPersona, -2, -1, -2)).addGroup(layout.createSequentialGroup().addGap(16, 16, 16).addComponent(this.jLabel2, -2, 57, -2))).addGap(5, 5, 5).addComponent(this.JTPDatosP).addGap(5, 5, 5)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEmbarazadaActionPerformed(ActionEvent evt) {
        if (this.JCHEmbarazada.isSelected()) {
            this.embarazada = 1;
        } else {
            this.embarazada = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHPrimerVezActionPerformed(ActionEvent evt) {
        if (this.JCHPrimerVez.isSelected()) {
            this.pVez = 1;
        } else {
            this.pVez = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameActivated(InternalFrameEvent evt) {
        try {
            setSelected(true);
        } catch (PropertyVetoException e) {
            Logger.getLogger(JIFCACervix.class.getName()).log(Level.SEVERE, (String) null, e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHLactanciaActionPerformed(ActionEvent evt) {
        if (this.JCHLactancia.isSelected()) {
            this.xlactancia = 1;
        } else {
            this.xlactancia = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBHistoricoMouseClicked(MouseEvent evt) {
        if (this.JTBHistorico.getSelectedRow() != -1 && evt.getClickCount() == 2) {
            if (Principal.informacionIps.getIdentificacion().equals("900895500")) {
                Object[] options = {"Imprimir Resultados", "Modificar Resultados", "Anular Resultado", "Cancelar"};
                int opcion = JOptionPane.showOptionDialog(this, "Seleccione una opción:", "CONFIRMACIÓN", -1, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), options, options[3]);
                switch (opcion) {
                    case 0:
                        imprimirResultado(this.xmodelo.getValueAt(this.JTBHistorico.getSelectedRow(), 1).toString());
                        break;
                    case 1:
                        Principal.txtNo.setText(this.xmodelo.getValueAt(this.JTBHistorico.getSelectedRow(), 1).toString());
                        Principal.txtFecha.setText(this.xmodelo.getValueAt(this.JTBHistorico.getSelectedRow(), 2).toString());
                        mCargarDatosToma();
                        mCargarDatos_Seguimiento();
                        this.JCBEsquema.setSelectedItem(this.xmodelo.getValueAt(this.JTBHistorico.getSelectedRow(), 5));
                        this.JTP_Observacion.setText(this.xmodelo.getValueAt(this.JTBHistorico.getSelectedRow(), 6).toString());
                        this.jTSintomas.setText(this.xmodelo.getValueAt(this.JTBHistorico.getSelectedRow(), 10).toString());
                        this.JTATtoHormonales.setText(this.xmodelo.getValueAt(this.JTBHistorico.getSelectedRow(), 6).toString());
                        mBuscarResultadoCitologia(Principal.txtNo.getText());
                        this.JTPDatosP.setSelectedIndex(1);
                        break;
                    case 2:
                        if (!Boolean.parseBoolean(this.JTBHistorico.getValueAt(this.JTBHistorico.getSelectedRow(), 17).toString())) {
                            int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de anular?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                            if (x == 0) {
                                Anular frm = new Anular(null, true, "citologiaPyP", 15);
                                frm.setLocationRelativeTo(this);
                                frm.setVisible(true);
                            }
                        } else {
                            JOptionPane.showInternalMessageDialog(this, "Registro con entrega registarda;No se puede anular", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        }
                        break;
                }
            }
            Principal.txtNo.setText(this.xmodelo.getValueAt(this.JTBHistorico.getSelectedRow(), 1).toString());
            Principal.txtFecha.setText(this.xmodelo.getValueAt(this.JTBHistorico.getSelectedRow(), 2).toString());
            mCargarDatosToma();
            mCargarDatos_Seguimiento();
            this.JCBEsquema.setSelectedItem(this.xmodelo.getValueAt(this.JTBHistorico.getSelectedRow(), 5));
            this.JTP_Observacion.setText(this.xmodelo.getValueAt(this.JTBHistorico.getSelectedRow(), 6).toString());
            this.JTATtoHormonales.setText(this.xmodelo.getValueAt(this.JTBHistorico.getSelectedRow(), 7).toString());
            if (Boolean.valueOf(this.xmodelo.getValueAt(this.JTBHistorico.getSelectedRow(), 8).toString()).booleanValue()) {
                int x2 = JOptionPane.showInternalConfirmDialog(this, "Desea visualizar el resultado?", "CONFIRMACIÓN", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (x2 == 0) {
                    String[][] parametros = new String[4][2];
                    parametros[0][0] = "Id";
                    parametros[0][1] = this.xmodelo.getValueAt(this.JTBHistorico.getSelectedRow(), 1).toString();
                    parametros[1][0] = "SUBREPORT_DIR";
                    parametros[1][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
                    parametros[2][0] = "SUBREPORTFIRMA_DIR";
                    parametros[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
                    parametros[3][0] = "usuarioSistema";
                    parametros[3][1] = Principal.usuarioSistemaDTO.getNombreUsuario();
                    this.xmt.GenerarPDF(this.xmt.getRutaRep() + "P_EnvioCitologiaN_1_1_02", parametros);
                    return;
                }
                mBuscarResultadoCitologia(Principal.txtNo.getText());
                this.JTPDatosP.setSelectedIndex(1);
                return;
            }
            mBuscarResultadoCitologia(Principal.txtNo.getText());
            this.JTPDatosP.setSelectedIndex(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        if (this.modulo == 38) {
            if (Principal.claselab.resultadoCitologia != null) {
                Principal.claselab.resultadoCitologia.setVisible(true);
            }
        } else if (Principal.claselab != null && Principal.claselab.xjifagenda == null) {
            Principal.mLimpiarDatosP();
            Principal.claselab.cargarPantalla("Agenda");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTAsignacionCActionPerformed(ActionEvent evt) {
        if (this.frmPersona.getHistoria().equals("") && this.frmPersona.getApellido1().equals("") && this.frmPersona.getApellido2().endsWith("") && this.frmPersona.getNombre1().equals("") && this.frmPersona.getNombre2().equals("")) {
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un usuario", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        Principal.clasescita = new clasesCita(this.clasepyp.frmPrincipal);
        Principal.clasescita.cargarPantalla(Principal.clasescita.frmPrincipal, "Citas");
        Principal.clasescita.frmCita.frmPersona.txtHistoria.setText(this.frmPersona.txtHistoria.getText());
        Principal.clasescita.frmCita.frmPersona.txtHistoria.transferFocus();
        Principal.clasescita.frmCita.frmPersona.buscar(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBP1SiActionPerformed(ActionEvent evt) {
        this.xrespuesta1 = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBP1NoActionPerformed(ActionEvent evt) {
        this.xrespuesta1 = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBP2SiActionPerformed(ActionEvent evt) {
        this.xrespuesta2 = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBP2NoActionPerformed(ActionEvent evt) {
        this.xrespuesta2 = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBP3SiActionPerformed(ActionEvent evt) {
        this.xrespuesta3 = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBP3NoActionPerformed(ActionEvent evt) {
        this.xrespuesta3 = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBP4SiActionPerformed(ActionEvent evt) {
        this.xrespuesta4 = 1;
        this.JTXTConsecutivoI.setVisible(true);
        this.JTPIDatosTM.setEnabledAt(1, true);
        this.JTPIDatosTM.setEnabledAt(2, true);
        this.JTXTConsecutivoI.setEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Finally extract failed */
    public void JRBP4NoActionPerformed(ActionEvent evt) {
        this.xrespuesta4 = 0;
        this.JTPIDatosTM.setEnabledAt(1, false);
        this.JTPIDatosTM.setEnabledAt(2, false);
        if (this.xrespuesta4 == 0) {
            int x = JOptionPane.showInternalConfirmDialog(this, "Ha seleccionado no realizar la toma de la muestra;\nDesea anular la factura?", "ANULACIÓN DE FACTURA/ORDEN", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                try {
                    mGrabar();
                    long nfactura = 0;
                    long nliquidacion = 0;
                    if (this.clasepyp.getXid_tipof() != 2) {
                        this.xsql = "SELECT `f_factura_capita`.`No_FacturaCapita` , `f_liquidacion`.`Id`  FROM  `f_factura_capita` INNER JOIN `f_liquidacion`  ON (`f_factura_capita`.`Id_Liquidacion` = `f_liquidacion`.`Id`) WHERE (`f_liquidacion`.`Id_Ingreso` ='" + this.clasepyp.getXid_ingreso() + "') ";
                    } else {
                        this.xsql = "SELECT `f_factura_evento`.`No_FacturaEvento`, `f_liquidacion`.`Id`       FROM `f_factura_evento` INNER JOIN `f_liquidacion`  ON (`f_factura_evento`.`Id_Liquidacion` = `f_liquidacion`.`Id`) WHERE (`f_liquidacion`.`Id_Ingreso` ='" + this.clasepyp.getXid_ingreso() + "') ";
                    }
                    ResultSet xrs = this.xct.traerRs(this.xsql);
                    Throwable th = null;
                    try {
                        if (xrs.next()) {
                            xrs.first();
                            nfactura = xrs.getLong(1);
                            nliquidacion = xrs.getLong(2);
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
                        if (this.clasepyp.getXid_tipof() != 2) {
                            this.xsql = "update f_factura_capita set  Estado=1 where No_FacturaCapita='" + nfactura + "'";
                            this.xct.ejecutarSQL(this.xsql);
                            this.xct.cerrarConexionBd();
                        } else {
                            this.xsql = "update f_factura_evento set  Estado=1 where No_FacturaEvento='" + nfactura + "'";
                            this.xct.ejecutarSQL(this.xsql);
                            this.xct.cerrarConexionBd();
                        }
                        this.xsql = "update f_liquidacion set  Estado=1 where Id='" + nliquidacion + "'";
                        this.xct.ejecutarSQL(this.xsql);
                        this.xct.cerrarConexionBd();
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
                    Logger.getLogger(JIFCACervix.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTB_ResultadoMouseClicked(MouseEvent evt) {
        int row = this.JTB_Resultado.rowAtPoint(evt.getPoint());
        int col = this.JTB_Resultado.columnAtPoint(evt.getPoint());
        if (col == 2 && row != -1) {
            Boolean valorActual = (Boolean) this.JTB_Resultado.getValueAt(row, col);
            Long id = (Long) this.JTB_Resultado.getValueAt(row, 0);
            if (!valorActual.booleanValue()) {
                int opcion = JOptionPane.showConfirmDialog(this.JTB_Resultado, "¿Seguro que deseas eliminar este registro?", "Confirmación", 2, 2);
                if (opcion == 0) {
                    this.JTB_Resultado.setValueAt(false, row, col);
                    if (this.idResultadoCitologiaActual != null) {
                        this.xsql = "DELETE FROM p_citologia_resultado_cestudio WHERE Id_RCitologia= '" + this.idResultadoCitologiaActual + "' and Id_ConceptoEstudio ='" + id + "'";
                        this.xct.ejecutarSQLIdNotError(this.xsql);
                        this.xct.cerrarConexionBd();
                    }
                }
                if (opcion == 2) {
                    this.JTB_Resultado.setValueAt(true, row, col);
                    return;
                } else {
                    if (this.JTB_Resultado.getSelectedRow() == 2) {
                        this.JCHCalidad.setSelected(false);
                        return;
                    }
                    return;
                }
            }
            if (this.JTB_Resultado.getSelectedRow() == 2) {
                this.JCHCalidad.setSelected(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTB_SHistoricoMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_SanoActionPerformed(ActionEvent evt) {
        this.valorAspecto = this.JCH_Sano.getText();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_AusenteActionPerformed(ActionEvent evt) {
        this.valorAspecto = this.JCH_Ausente.getText();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_CongestivoActionPerformed(ActionEvent evt) {
        this.valorAspecto = this.JCH_Congestivo.getText();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_ArtrogicoActionPerformed(ActionEvent evt) {
        this.valorAspecto = this.JCH_Artrogico.getText();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHPrimerVez5ActionPerformed(ActionEvent evt) {
        this.valorAspecto = this.JCHPrimerVez5.getText();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBCalidadMItemStateChanged(ItemEvent evt) {
        if (this.lleno && this.JCBCalidadM.getSelectedIndex() != -1) {
            if (this.JCBCalidadM.getSelectedItem().equals("Insatisfactoria") || this.JCBCalidadM.getSelectedItem().equals("Insatisfactoria para Evaluacion") || this.JCBCalidadM.getSelectedItem().equals("Rechazada")) {
                this.JSPObservacionRechazo.setEnabled(true);
            } else {
                this.JSPObservacionRechazo.setEnabled(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDF_Fecha_TomaPropertyChange(PropertyChangeEvent evt) {
    }

    private void imprimirResultado(String idCitologia) {
        ImpresionReporteCitologiaBethesda bethesda = new ImpresionReporteCitologiaBethesda();
        bethesda.generarReporte(Long.valueOf(idCitologia), 1);
    }

    public void mCargarDatosAspectoCuello(String id, String nbre) {
        this.xmodelo1.addRow(this.xdato);
        this.xmodelo1.setValueAt(id, this.xmodelo1.getRowCount() - 1, 0);
        this.xmodelo1.setValueAt(nbre, this.xmodelo1.getRowCount() - 1, 1);
        this.xfilacuello++;
    }

    private void mCargarPanelAG() {
        this.xjpantecedentesG = new JPAAntecedenteGineco(Principal.clasepyp, 0, false);
        this.xjpantecedentesG.setBounds(2, 2, 900, 600);
        this.JPIAntecendesG.add(this.xjpantecedentesG);
        this.xjpantecedentesG.setVisible(true);
    }

    public void anularResultado(String concepto, String observacion) {
        String sql1 = "update p_citologia_resultados pcr \nset pcr.Estado=0,\npcr.fechaAnulacion=now(),\npcr.usuarioAnulacion='" + Principal.usuarioSistemaDTO.getNombreUsuario() + "',\npcr.conceptoAnulacion='" + concepto + "',\npcr.observacionAnulacion='" + observacion + "' \nwhere pcr.Id =" + this.JTBHistorico.getValueAt(this.JTBHistorico.getSelectedRow(), 17) + "";
        this.xct.ejecutaSQLUpdate(sql1);
    }

    public final void mNuevo() {
        Principal.mLimpiarDatosP();
        this.frmPersona.nuevo();
        this.idResultadoCitologiaActual = null;
        mCrearTablaHistorico();
        this.valorAspecto = "Sano";
        this.JCH_Sano.setSelected(true);
        this.JCBEsquema.removeAllItems();
        this.JDF_Fecha_Toma.setDate(this.xmt.getFechaActual());
        this.sql = "SELECT Id, Nbre FROM p_citologiaesquema WHERE (Estado =0) ORDER BY Nbre ASC";
        this.lisEsquema = this.xct.llenarCombo(this.sql, this.lisEsquema, this.JCBEsquema);
        this.JCBEsquema.setSelectedItem("Ninguno");
        this.JCBFRiesgo.removeAllItems();
        this.xidfriesgo = this.xct.llenarCombo("SELECT`Id` , `Nbre`    FROM  `p_tipo_respuestas_c` WHERE (`Tipo` =1 OR `Tipo`=0 ) ORDER BY `Nbre` ASC", this.xidfriesgo, this.JCBFRiesgo);
        this.JCBFRiesgo.setSelectedItem("NINGUNO");
        this.JCBAPatologicos.removeAllItems();
        this.xidapatologicos = this.xct.llenarCombo("SELECT`Id` , `Nbre`    FROM  `p_tipo_respuestas_c` WHERE (`Tipo` =2 OR `Tipo`=0 ) ORDER BY `Nbre` ASC", this.xidapatologicos, this.JCBAPatologicos);
        this.JCBAPatologicos.setSelectedItem("NINGUNO");
        this.JCBVCaCervix.removeAllItems();
        this.xidvcacervix = this.xct.llenarCombo("SELECT`Id` , `Nbre`    FROM  `p_tipo_respuestas_c` WHERE (`Tipo` =3 ) ORDER BY `Nbre` ASC", this.xidvcacervix, this.JCBVCaCervix);
        this.JCBVCaCervix.setSelectedItem("Sin Dato");
        this.JCBVGardacil.removeAllItems();
        this.xidvgardacil = this.xct.llenarCombo("SELECT`Id` , `Nbre`    FROM  `p_tipo_respuestas_c` WHERE (`Tipo` =3 ) ORDER BY `Nbre` ASC", this.xidvgardacil, this.JCBVGardacil);
        this.JCBVGardacil.setSelectedItem("Sin Dato");
        this.xct.cerrarConexionBd();
        this.JCHPrimerVez.setSelected(false);
        this.JCHEmbarazada.setSelected(false);
        this.embarazada = 0;
        this.pVez = 1;
        this.JTP_Observacion.setText("");
        this.JTXTConsecutivoI.setText("0");
        this.JTPIDatosTM.setEnabledAt(1, false);
        this.JTPIDatosTM.setEnabledAt(2, false);
        this.JSPObservacionRechazo.setEnabled(false);
        mLLenarDatosResultados();
        mNuevoSeguimiento();
        if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL LOCAL DE MONTELIBANO")) {
            this.JTPDatosP.removeTabAt(1);
            this.JTPDatosP.removeTabAt(1);
        }
        mBuscarHCitologia();
    }

    private void springStart() {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"});
        this.xCitologiaDAO = (TomaMuestraCitologiaDAOImpl) classPathXmlApplicationContext.getBean("tomaMuestraCitologiaDAO");
        this.xTipoSeguimiento = (TipoSeguimientoCDAOImpl) classPathXmlApplicationContext.getBean("tipoSeguimientoCDAO");
    }

    public void mCargarDatosToma() {
        List<Object[]> list = this.xCitologiaDAO.listaTomaMuestra(Long.valueOf(Principal.txtNo.getText()));
        if (!list.isEmpty()) {
            mRespuestaRB(Boolean.valueOf(list.get(0)[1].toString()).booleanValue(), this.JRBP1Si, this.JRBP1No);
            mRespuestaRB(Boolean.valueOf(list.get(0)[2].toString()).booleanValue(), this.JRBP2Si, this.JRBP2No);
            mRespuestaRB(Boolean.valueOf(list.get(0)[3].toString()).booleanValue(), this.JRBP3Si, this.JRBP3No);
            mRespuestaRB(Boolean.valueOf(list.get(0)[4].toString()).booleanValue(), this.JRBP4Si, this.JRBP4No);
            this.JTAObservacionV.setText(list.get(0)[5].toString());
            this.JCBFRiesgo.setSelectedItem(list.get(0)[6].toString());
            this.JCBAPatologicos.setSelectedItem(list.get(0)[7].toString());
            this.JCBVCaCervix.setSelectedItem(list.get(0)[8].toString());
            this.JCBVGardacil.setSelectedItem(list.get(0)[9].toString());
            this.JCBEsquema.setSelectedItem(list.get(0)[10].toString());
            this.JTAAspetoCuello.setText(list.get(0)[11].toString());
            this.JTATtoHormonales.setText(list.get(0)[12].toString());
            this.JTP_Observacion.setText(list.get(0)[13].toString());
            this.JCHPrimerVez.setSelected(Boolean.valueOf(list.get(0)[14].toString()).booleanValue());
            this.JCHLactancia.setSelected(Boolean.valueOf(list.get(0)[15].toString()).booleanValue());
            this.JCHEmbarazada.setSelected(Boolean.valueOf(list.get(0)[16].toString()).booleanValue());
            this.jTNombreQuienTomaLaCitologia.setText(list.get(0)[17].toString());
            this.jTCargoQuienTomaLaCitologia.setText(list.get(0)[18].toString());
            this.xjpantecedentesG.setXformacarga(true);
            this.xjpantecedentesG.mBuscarAntecedenteUsuario();
            this.JTPIDatosTM.setEnabledAt(1, true);
            this.JTPIDatosTM.setEnabledAt(2, true);
            try {
                this.JDF_Fecha_Toma.setDate(this.xmt.formatoAMDG.parse(list.get(0)[19].toString()));
            } catch (Exception e) {
                System.out.println("Error formateando la fecha>>>>> " + e.getMessage());
            }
        }
    }

    private void mRespuestaRB(boolean xrespuesta, JRadioButton xjr1, JRadioButton xjr2) {
        if (xrespuesta) {
            xjr1.setSelected(true);
        } else {
            xjr2.setSelected(true);
        }
    }

    private void mLLenarDatosResultados() {
        this.lleno = false;
        this.JDFecha.setDate(this.xmt.getFechaActual());
        this.JDFechaER.setDate(this.xmt.getFechaActual());
        this.JCBCalidadM.removeAllItems();
        this.xridcalidad = this.xct.llenarCombo("SELECT `Id`, `Nbre`, `Estado` FROM `p_citologia_cmuestra` WHERE (`Estado` =1)", this.xridcalidad, this.JCBCalidadM);
        this.JCBCalidadM.setSelectedIndex(-1);
        this.JCBTercero.removeAllItems();
        this.xridempresa = this.xct.llenarCombo("SELECT `Id`, `RazonSocialCompleta` FROM `cc_terceros` WHERE (`Laboratorio` =1) ORDER BY `RazonSocialCompleta` ASC", this.xridempresa, this.JCBTercero);
        this.JCBTercero.setSelectedItem(Principal.informacionIps.getNombreIps());
        this.JCBConducta.removeAllItems();
        this.xidconducta = this.xct.llenarCombo("SELECT`Id` , `Nbre`    FROM  `p_tipo_respuestas_c` WHERE (`Tipo` =4 OR `Tipo`=0 ) ORDER BY `Nbre` ASC", this.xidconducta, this.JCBConducta);
        this.JCBConducta.setSelectedItem("NINGUNO");
        this.xct.cerrarConexionBd();
        this.JTPObservacion.setText("");
        mCargar_ResultadosC();
        this.lleno = true;
    }

    private void mCargarPanelPersona() {
        this.frmPersona = new Persona(this);
        this.frmPersona.setBounds(10, 15, 980, 160);
        this.panelPersona.add(this.frmPersona);
        this.frmPersona.setVisible(true);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTablaHistorico() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Consecutivo", "Id", "Fecha Toma", "Especialidad", "Profesional", "Esquema", "Observación", "Procedimiento", "Fecha Resultado", "Profesional Graba", "Especialidad Graba", "Fecha Validación", "Profesional Validación", "Especialidad Validación", "Resultado?", "Id_recepcion", "Sintomas?", "idResultado", "comentario", "estado", "fechaAnulacion", "usuarioAnulacion", "conceptoAnulacion", "observacionAnulacion"}) { // from class: PyP.JIFCACervix.24
            Class[] types = {String.class, Long.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Boolean.class, Long.class, String.class, Long.class, Boolean.class, Boolean.class, String.class, String.class, String.class, String.class};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.JTBHistorico.setAutoResizeMode(0);
        this.JTBHistorico.doLayout();
        this.JTBHistorico.setModel(this.xmodelo);
        this.JTBHistorico.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTBHistorico.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTBHistorico.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTBHistorico.getColumnModel().getColumn(3).setPreferredWidth(200);
        this.JTBHistorico.getColumnModel().getColumn(4).setPreferredWidth(300);
        this.JTBHistorico.getColumnModel().getColumn(5).setPreferredWidth(200);
        this.JTBHistorico.getColumnModel().getColumn(6).setPreferredWidth(300);
        this.JTBHistorico.getColumnModel().getColumn(7).setPreferredWidth(400);
        this.JTBHistorico.getColumnModel().getColumn(8).setPreferredWidth(100);
        this.JTBHistorico.getColumnModel().getColumn(9).setPreferredWidth(300);
        this.JTBHistorico.getColumnModel().getColumn(10).setPreferredWidth(200);
        this.JTBHistorico.getColumnModel().getColumn(11).setPreferredWidth(200);
        this.JTBHistorico.getColumnModel().getColumn(12).setPreferredWidth(200);
        this.JTBHistorico.getColumnModel().getColumn(13).setPreferredWidth(200);
        this.JTBHistorico.getColumnModel().getColumn(14).setPreferredWidth(200);
        this.JTBHistorico.getColumnModel().getColumn(15).setPreferredWidth(200);
        this.JTBHistorico.getColumnModel().getColumn(16).setPreferredWidth(200);
        this.JTBHistorico.getColumnModel().getColumn(17).setPreferredWidth(200);
        this.JTBHistorico.getColumnModel().getColumn(18).setPreferredWidth(200);
        this.JTBHistorico.getColumnModel().getColumn(19).setPreferredWidth(100);
        this.JTBHistorico.getColumnModel().getColumn(20).setPreferredWidth(100);
        this.JTBHistorico.getColumnModel().getColumn(21).setPreferredWidth(200);
        this.JTBHistorico.getColumnModel().getColumn(22).setPreferredWidth(200);
        this.JTBHistorico.getColumnModel().getColumn(23).setPreferredWidth(200);
        this.filaGrid = 0;
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTablaR() {
        this.xmodelor = new DefaultTableModel(new Object[0], new String[]{"Id", "Nombre", "Aplica", "Encabezado"}) { // from class: PyP.JIFCACervix.25
            Class[] types = {Long.class, String.class, Boolean.class, Boolean.class};
            boolean[] canEdit = {false, false, true, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return this.canEdit[colIndex];
            }
        };
        this.JTB_Resultado.setModel(this.xmodelor);
        this.JTB_Resultado.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTB_Resultado.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTB_Resultado.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTB_Resultado.getColumnModel().getColumn(1).setPreferredWidth(300);
        this.JTB_Resultado.getColumnModel().getColumn(2).setPreferredWidth(10);
        this.JTB_Resultado.getColumnModel().getColumn(3).setPreferredWidth(0);
        this.JTB_Resultado.getColumnModel().getColumn(3).setMinWidth(0);
        this.JTB_Resultado.getColumnModel().getColumn(3).setMaxWidth(0);
    }

    public void mBuscarPersona() {
        BuscarPersona frmP = new BuscarPersona(null, true, this.frmPersona);
        frmP.setVisible(true);
    }

    /* JADX WARN: Not initialized variable reg: 7, insn: 0x0161: MOVE (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r7 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('xrs' java.sql.ResultSet)]) A[TRY_LEAVE], block:B:32:0x0161 */
    /* JADX WARN: Not initialized variable reg: 8, insn: 0x0165: MOVE (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r8 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:34:0x0165 */
    public void mBuscarResultadoCitologia(String idResultado) {
        try {
            try {
                this.xsql = "SELECT\n\tp_citologia_resultados.Id ,\n\tp_citologia_resultados.Id_Citologia ,\n\tp_citologia_resultados.FechaR ,\n\tcc_terceros.RazonSocialCompleta ,\n\tp_citologia_cmuestra.Nbre AS NCalidadMuestra ,\n\tp_tipo_respuestas_c.Nbre AS NCConducta,\n\tp_citologia_tipoestudio.Nbre AS NTIpoEstudio\n                    ,\n\tp_citologia_conceptoestudio.Nbre AS NConcetpEstudio ,\n\tp_citologia_resultados.Observacion,\n\tp_citologia_conceptoestudio.Id AS Id_Concepto,\n\tp_citologia_resultados.DisponibleCalidad  AS DisponibleCalidad,  pc.Id_Recepcion idRecepcion \nFROM\n\tp_citologia_resultado_cestudio\nINNER JOIN p_citologia_resultados ON\n\t(p_citologia_resultado_cestudio.Id_RCitologia = p_citologia_resultados.Id)\nINNER JOIN p_citologia_cmuestra ON\n\t(p_citologia_resultados.Id_Calitad = p_citologia_cmuestra.Id)\nINNER JOIN p_citologia_conceptoestudio ON\n\t(p_citologia_resultado_cestudio.Id_ConceptoEstudio = p_citologia_conceptoestudio.Id)\nINNER JOIN p_citologia_tipoestudio ON\n\t(p_citologia_conceptoestudio.Id_TipoEstudio = p_citologia_tipoestudio.Id)\nINNER JOIN cc_terceros ON\n\t(cc_terceros.Id = p_citologia_resultados.Id_Tercero) \ninner join p_citologia pc on (pc.Id = p_citologia_resultados.Id_Citologia ) \nLEFT JOIN p_tipo_respuestas_c on\n\t(p_tipo_respuestas_c.Id = p_citologia_resultados.Id_Conducta )\n                    WHERE ( p_citologia_resultados. Id_Citologia ='" + idResultado + "')\n                    ORDER BY  p_citologia_tipoestudio. Orden ASC,  p_citologia_conceptoestudio. Orden ASC";
                System.out.println("resultado " + this.xsql);
                ResultSet xrs = this.xct.traerRs(this.xsql);
                Throwable th = null;
                if (xrs.next()) {
                    xrs.first();
                    this.idResultadoCitologiaActual = xrs.getString("Id");
                    this.JDFecha.setDate(xrs.getDate("FechaR"));
                    this.JCBTercero.setSelectedItem(xrs.getString("RazonSocialCompleta"));
                    this.JCBCalidadM.setSelectedItem(xrs.getString("NCalidadMuestra"));
                    this.JCBConducta.setSelectedItem(xrs.getString("NCConducta"));
                    this.JTPObservacion.setText(xrs.getString("Observacion"));
                    this.JCHCalidad.setSelected(xrs.getBoolean("DisponibleCalidad"));
                    xrs.beforeFirst();
                    while (xrs.next()) {
                        long idConcepto = xrs.getLong("Id_Concepto");
                        for (int i = 0; i < this.JTB_Resultado.getRowCount(); i++) {
                            Long value = (Long) this.JTB_Resultado.getValueAt(i, 0);
                            if (value != null && value.longValue() == idConcepto) {
                                this.JTB_Resultado.setValueAt(true, i, 2);
                            }
                        }
                    }
                    this.xencontroresultado = true;
                } else {
                    this.xencontroresultado = false;
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
            Logger.getLogger(JIFCACervix.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Finally extract failed */
    public void mBuscarHCitologia() {
        mCrearTablaHistorico();
        String sqlCitologia = "SELECT\n\tconcat(lrc.Ano, lrc.Id_Consecutivo) consecutivo,\n\tp_citologia.Id,\n\tDATE_FORMAT(p_citologia.FechaToma, '%d-%m-%Y') AS Fechat,\n\tge2.Nbre as Especialidad,\n\tconcat(gp4.Apellido1,' ', gp4.Apellido2,' ', gp4.Nombre1 ,' ', gp4.Nombre2) as NProfesional,\n\tp_citologiaesquema.Nbre AS esquema,\n\tp_citologia.Detalle,\n\tp_citologia.TtoHormanales,\n\tIF(l_detallerecepcion.FechaResultado IS NOT NULL,\n\t1,\n\t0) AS Resultado,\n\tl_recepcion.Id AS idRecepcion,\n\tp_citologia.Sintomas,\n\tCONCAT(gp.C_Homologado, '_', gp.Nbre) AS procedimiento,\n\tIFNULL(DATE_FORMAT(pcr.FechaR, '%d-%m-%Y'), '') AS fechaResultado,\n\tIFNULL(CONCAT(gp2.Apellido1, ' ', gp2.Apellido2, ' ', gp2.Nombre1, ' ', gp2.Nombre1), '') AS profesionalGraba,\n\tIFNULL(ge.Nbre, '') AS especialidadGraba,\n\tIFNULL(DATE_FORMAT(pcr.fechaValidacionEspecialista, '%d-%m-%Y'), '') AS fechaValidacion,\n\tIFNULL(CONCAT(gp3.Apellido1, ' ', gp3.Apellido2, ' ', gp3.Nombre1, ' ', gp3.Nombre1), '') AS profesionalValida,\n\tIFNULL(ge1.Nbre, '') AS especialidadValida,\n\tpcr.Id  idResultadoCitologia,\n\tif(GROUP_CONCAT(ldc.Id separator '') is null , 0, 1) comentario\n,      pcr.Estado estado,\n\tifnull(pcr.fechaAnulacion, '') fechaAnulacion,\n\tifnull(pcr.usuarioAnulacion, '') usuarioAnulacion,\n\tifnull(pcr.conceptoAnulacion, '') conceptoAnulacion,\n\tifnull(pcr.observacionAnulacion, '')observacionAnulacion\nFROM\np_citologia\ninner join l_recepcion_citologia lrc on\n\t(lrc.Id_Recepcion = p_citologia.Id_Recepcion )\t\nINNER JOIN g_persona gp4  ON (gp4.Id =p_citologia.Id_Profesional )\ninner join g_especialidad ge2 on (ge2.Id =p_citologia.Id_Especialidad )\nINNER JOIN p_citologiaesquema ON\n\tp_citologia.Id_Esquema = p_citologiaesquema.Id\nINNER JOIN l_recepcion ON\n\tl_recepcion.Id = p_citologia.Id_Recepcion\nINNER JOIN l_detallerecepcion ON\n\tl_recepcion.Id = l_detallerecepcion.Id_Recepcion\nINNER JOIN g_procedimiento gp ON\n\tgp.Id = l_detallerecepcion.Id_Procedim\nINNER JOIN p_citologia_resultados pcr ON\n\tpcr.Id_Citologia = p_citologia.Id\nLEFT JOIN g_persona gp2 ON\n\tgp2.Id = pcr.idProfesional\nLEFT JOIN g_especialidad ge ON\n\tge.Id = pcr.idEspecialidad\nLEFT JOIN g_persona gp3 ON\n\tgp3.Id = pcr.idProfesionalEspecialista\nLEFT JOIN g_especialidad ge1 ON\n\tge1.Id = pcr.idEspecialidadProfesionalEspe\nleft join l_detallerecepcion_comentario ldc on (ldc.Id_Recepcion=p_citologia.Id_Recepcion)\t and (ldc.Estado =1)\nWHERE p_citologia.Id_Persona = " + this.frmPersona.getIdPersona() + "  AND p_citologia.Estado = 0 \n group by pcr.Id\n ORDER BY p_citologia.FechaToma DESC";
        System.out.println("" + sqlCitologia);
        this.xmt.mEstablecerTextEditor(this.JTBHistorico, 7);
        try {
            try {
                ResultSet rs1 = this.xct.traerRs(sqlCitologia);
                Throwable th = null;
                try {
                    if (!rs1.isBeforeFirst()) {
                        System.out.println("No se encontraron resultados.");
                        if (rs1 != null) {
                            if (0 != 0) {
                                try {
                                    rs1.close();
                                } catch (Throwable th2) {
                                    th.addSuppressed(th2);
                                }
                            } else {
                                rs1.close();
                            }
                        }
                        this.xct.cerrarConexionBd();
                        this.xjpantecedentesG.xidpersona = this.frmPersona.getIdPersona();
                        this.xjpantecedentesG.mBuscarAntecedenteUsuario();
                        return;
                    }
                    while (rs1.next()) {
                        this.xmodelo.addRow(new Object[]{rs1.getString("consecutivo"), Long.valueOf(rs1.getLong("Id")), rs1.getString("Fechat"), rs1.getString("Especialidad"), rs1.getString("NProfesional"), rs1.getString("esquema"), rs1.getString("Detalle"), rs1.getString("procedimiento"), rs1.getString("fechaResultado"), rs1.getString("profesionalGraba"), rs1.getString("especialidadGraba"), rs1.getString("fechaValidacion"), rs1.getString("profesionalValida"), rs1.getString("especialidadValida"), Boolean.valueOf(rs1.getBoolean("Resultado")), Long.valueOf(rs1.getLong("idRecepcion")), rs1.getString("Sintomas"), Long.valueOf(rs1.getLong("idResultadoCitologia")), Boolean.valueOf(rs1.getBoolean("comentario")), Boolean.valueOf(rs1.getBoolean("estado")), rs1.getString("fechaAnulacion"), rs1.getString("usuarioAnulacion"), rs1.getString("conceptoAnulacion"), rs1.getString("observacionAnulacion")});
                    }
                    if (rs1 != null) {
                        if (0 != 0) {
                            try {
                                rs1.close();
                            } catch (Throwable th3) {
                                th.addSuppressed(th3);
                            }
                        } else {
                            rs1.close();
                        }
                    }
                    this.xct.cerrarConexionBd();
                    this.xjpantecedentesG.xidpersona = this.frmPersona.getIdPersona();
                    this.xjpantecedentesG.mBuscarAntecedenteUsuario();
                } catch (Throwable th4) {
                    if (rs1 != null) {
                        if (0 != 0) {
                            try {
                                rs1.close();
                            } catch (Throwable th5) {
                                th.addSuppressed(th5);
                            }
                        } else {
                            rs1.close();
                        }
                    }
                    throw th4;
                }
            } catch (SQLException ex) {
                this.xct.mostrarErrorSQL(ex);
                this.xct.cerrarConexionBd();
                this.xjpantecedentesG.xidpersona = this.frmPersona.getIdPersona();
                this.xjpantecedentesG.mBuscarAntecedenteUsuario();
            }
        } catch (Throwable th6) {
            this.xct.cerrarConexionBd();
            this.xjpantecedentesG.xidpersona = this.frmPersona.getIdPersona();
            this.xjpantecedentesG.mBuscarAntecedenteUsuario();
            throw th6;
        }
    }

    public void mGrabar() {
        String xid;
        switch (this.JTPDatosP.getSelectedIndex()) {
            case 0:
                if (this.JCBEsquema.getSelectedIndex() != -1) {
                    if (!this.frmPersona.cboSexo.getSelectedItem().equals("MASCULINO")) {
                        if (Principal.txtNo.getText().isEmpty()) {
                            int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                            if (x == 0) {
                                this.sql = "insert into p_citologia (Id_Persona, Id_Recepcion, Id_Profesional, Id_Especialidad, FechaToma,  PrimerVez, Lactancia, Embarazada, Id_Esquema, Detalle,Sintomas, TtoHormanales, AspectoCuello, NombreQuienTomaCitologia ,CargoQuienTomaCitologia,  aspecCuello , `R_Pregunta1`, `R_Pregunta2`, `R_Pregunta3`, `Observacion`, `Tomada`, `Id_FRiesgo`, `Id_APatologicos`, `Id_VCaCervix`, `Id_VGardasil` , NoConsecutivo, Fecha, UsuarioS) values('" + this.frmPersona.getIdPersona() + "','" + this.clasepyp.getXidrecepcion() + "','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "','" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "','" + this.xmt.formatoAMD1.format(this.JDF_Fecha_Toma.getDate()) + "','" + this.pVez + "','" + this.xlactancia + "','" + this.embarazada + "','" + this.lisEsquema[this.JCBEsquema.getSelectedIndex()] + "','" + this.JTP_Observacion.getText() + "','" + this.jTSintomas.getText() + "','" + this.JTATtoHormonales.getText() + "','" + this.JTAAspetoCuello.getText() + "','" + this.jTNombreQuienTomaLaCitologia.getText() + "','" + this.jTCargoQuienTomaLaCitologia.getText() + "','" + this.valorAspecto + "','" + this.xrespuesta1 + "','" + this.xrespuesta2 + "','" + this.xrespuesta3 + "','" + this.JTAObservacionV.getText() + "','" + this.xrespuesta4 + "','" + this.xidfriesgo[this.JCBFRiesgo.getSelectedIndex()] + "','" + this.xidapatologicos[this.JCBAPatologicos.getSelectedIndex()] + "','" + this.xidvcacervix[this.JCBVCaCervix.getSelectedIndex()] + "','" + this.xidvgardacil[this.JCBVGardacil.getSelectedIndex()] + "','" + this.JTXTConsecutivoI.getText() + "','" + this.xmt.formatoAMD.format(this.xmt.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                                Principal.txtNo.setText(this.xct.ejecutarSQLId(this.sql));
                                Principal.txtFecha.setText(this.xmt.formatoDMA.format(this.xmt.getFechaActual()));
                                Principal.txtEstado.setText("ACTIVA");
                                this.xct.cerrarConexionBd();
                                this.xjpantecedentesG.xidcitologia = Principal.txtNo.getText();
                                this.xjpantecedentesG.mGrabar();
                                mBuscarHCitologia();
                                if (this.JRBP4Si.isSelected()) {
                                    mImprimirR();
                                }
                            }
                        } else {
                            this.xmt.mostrarMensaje("Registo Ya Grabado");
                        }
                    } else {
                        this.xmt.mostrarMensaje("Por favor cambie el SEXO del usuario o verifique sus datos");
                        this.frmPersona.cboSexo.requestFocus();
                    }
                } else {
                    this.xmt.mostrarMensaje("Por favor seleccione un Esquema");
                    this.JCBEsquema.requestFocus();
                }
                break;
            case 1:
                if (!Principal.txtNo.getText().isEmpty()) {
                    if (this.JCBCalidadM.getSelectedIndex() != -1) {
                        if (this.JCBTercero.getSelectedIndex() != -1) {
                            int x2 = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                            if (x2 == 0) {
                                System.out.println(" " + this.idResultadoCitologiaActual);
                                if (this.idResultadoCitologiaActual != null) {
                                    this.xsql = "UPDATE p_citologia_resultados SET Id_Citologia = '" + Principal.txtNo.getText() + "', FechaR = '" + this.xmt.formatoAMD.format(this.JDFecha.getDate()) + "', Id_Tercero = '" + this.xridempresa[this.JCBTercero.getSelectedIndex()] + "', Id_Calitad = '" + this.xridcalidad[this.JCBCalidadM.getSelectedIndex()] + "', observacionCalidad = '" + this.JTPObservacionRechazo.getText() + "', Observacion = '" + this.JTPObservacion.getText() + "', FechaER = '" + this.xmt.formatoAMD.format(this.JDFechaER.getDate()) + "', Id_Conducta = '" + this.xidconducta[this.JCBConducta.getSelectedIndex()] + "', DisponibleCalidad = " + (this.JCHCalidad.isSelected() ? 1 : 0) + ", UsuarioS = '" + Principal.usuarioSistemaDTO.getLogin() + "' WHERE Id = '" + this.idResultadoCitologiaActual + "'";
                                    this.xct.ejecutarSQLIdNotError(this.xsql);
                                    xid = this.idResultadoCitologiaActual;
                                    if (Principal.informacionGeneralPrincipalDTO.getIdEspecialidad().longValue() == 531) {
                                        this.xsql = "update p_citologia_resultados set idProfesionalEspecialista ='" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "' , idEspecialidadProfesionalEspe ='" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "' , fechaValidacionEspecialista =now()  where Id = '" + this.idResultadoCitologiaActual + "'";
                                        this.xct.ejecutarSQLIdNotError(this.xsql);
                                        for (int y = 0; y < this.JTB_Resultado.getRowCount(); y++) {
                                            try {
                                                if (Boolean.parseBoolean(this.xmodelor.getValueAt(y, 2).toString()) && !Boolean.valueOf(this.xmodelor.getValueAt(y, 3).toString()).booleanValue()) {
                                                    this.xsql = "insert into p_citologia_resultado_cestudio(`Id_RCitologia` , `Id_ConceptoEstudio` , `Id_UsuarioS`)  values('" + xid + "','" + this.xmodelor.getValueAt(y, 0) + "','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "')";
                                                    this.xct.ejecutarSQLNotError(this.xsql);
                                                    this.xct.cerrarConexionBd();
                                                }
                                            } catch (Exception e) {
                                            }
                                        }
                                        xid = this.idResultadoCitologiaActual;
                                    }
                                    this.xct.cerrarConexionBd();
                                } else {
                                    this.xsql = "insert  into p_citologia_resultados (`Id_Citologia`, `FechaR`, `Id_Tercero`, `Id_Calitad`, observacionCalidad, `Observacion`,`FechaER`, `Id_Conducta`,`DisponibleCalidad`, idProfesional, idEspecialidad, `UsuarioS` ) values('" + Principal.txtNo.getText() + "','" + this.xmt.formatoAMD.format(this.JDFecha.getDate()) + "','" + this.xridempresa[this.JCBTercero.getSelectedIndex()] + "','" + this.xridcalidad[this.JCBCalidadM.getSelectedIndex()] + "','" + this.JTPObservacionRechazo.getText() + "','" + this.JTPObservacion.getText() + "','" + this.xmt.formatoAMD.format(this.JDFechaER.getDate()) + "','" + this.xidconducta[this.JCBConducta.getSelectedIndex()] + "','" + (this.JCHCalidad.isSelected() ? 1 : 0) + "','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "'," + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + ",'" + Principal.usuarioSistemaDTO.getLogin() + "')";
                                    System.out.println(this.xsql);
                                    xid = this.xct.ejecutarSQLIdNotError(this.xsql);
                                    this.xct.cerrarConexionBd();
                                }
                                for (int y2 = 0; y2 < this.JTB_Resultado.getRowCount(); y2++) {
                                    try {
                                        if (Boolean.parseBoolean(this.xmodelor.getValueAt(y2, 2).toString()) && !Boolean.valueOf(this.xmodelor.getValueAt(y2, 3).toString()).booleanValue()) {
                                            this.xsql = "insert into p_citologia_resultado_cestudio(`Id_RCitologia` , `Id_ConceptoEstudio` , `Id_UsuarioS`)  values('" + xid + "','" + this.xmodelor.getValueAt(y2, 0) + "','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "')";
                                            this.xct.ejecutarSQLNotError(this.xsql);
                                            this.xct.cerrarConexionBd();
                                        }
                                    } catch (Exception e2) {
                                    }
                                }
                            }
                        } else {
                            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una empresa", "VERIFICAR", 1, new ImageIcon("src/Imagenes/Information.png"));
                            this.JCBTercero.requestFocus();
                        }
                    } else {
                        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar la calidad de la muestra", "VERIFICAR", 1, new ImageIcon("src/Imagenes/Information.png"));
                        this.JCBCalidadM.requestFocus();
                    }
                } else {
                    JOptionPane.showInternalMessageDialog(this, "Debe selecionar una citologia", "VERIFICAR", 1, new ImageIcon("src/Imagenes/Information.png"));
                    this.JTPDatosP.setSelectedIndex(3);
                }
                break;
            case 2:
                if (!Principal.txtNo.getText().isEmpty()) {
                    if (this.JCB_STipoSeguimiento.getSelectedIndex() != -1) {
                        if (!this.JTA_SObservacion.getText().isEmpty()) {
                            CitologiaSeguimientoDTO e3 = new CitologiaSeguimientoDTO();
                            e3.setIdCitologia(Long.valueOf(Principal.txtNo.getText()).longValue());
                            e3.setFecha(this.xmt.formatoAMD1.format(this.JDSFecha.getDate()));
                            e3.setIdTipoSeguimiento(Long.valueOf(this.xIdTipoSeguimiento[this.JCB_STipoSeguimiento.getSelectedIndex()]).longValue());
                            e3.setObservacion(this.JTA_SObservacion.getText());
                            e3.setIdUsuarioRh(Principal.usuarioSistemaDTO.getIdPersonaCargo().longValue());
                            this.xCitologiaDAO.createSeguimiento(e3);
                            mCargarDatos_Seguimiento();
                            mNuevoSeguimiento();
                        } else {
                            JOptionPane.showInternalMessageDialog(this, "Observacion no puede ser nula", "VERIFICAR", 1, new ImageIcon("src/Imagenes/Information.png"));
                            this.JTPDatosP.setSelectedIndex(2);
                            this.JTA_SObservacion.requestFocus();
                        }
                    } else {
                        JOptionPane.showInternalMessageDialog(this, "Debe selecionar un tipo de seguimiento", "VERIFICAR", 1, new ImageIcon("src/Imagenes/Information.png"));
                        this.JTPDatosP.setSelectedIndex(2);
                        this.JCB_STipoSeguimiento.requestFocus();
                    }
                } else {
                    JOptionPane.showInternalMessageDialog(this, "Debe selecionar una citologia", "VERIFICAR", 1, new ImageIcon("src/Imagenes/Information.png"));
                    this.JTPDatosP.setSelectedIndex(2);
                }
                break;
        }
    }

    private void mImprimirR() {
        String nbreArchivo;
        String[][] parametros = new String[4][2];
        parametros[0][0] = "Id";
        parametros[0][1] = Principal.txtNo.getText();
        parametros[1][0] = "SUBREPORT_DIR";
        parametros[1][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
        parametros[2][0] = "SUBREPORTFIRMA_DIR";
        parametros[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
        parametros[3][0] = "usuarioSistema";
        parametros[3][1] = Principal.usuarioSistemaDTO.getNombreUsuario();
        if (Principal.informacionIps.getEsFpz().intValue() == 0) {
            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "P_EnvioCitologiaN", parametros);
            return;
        }
        if (Principal.informacionIps.getPrefijoReportes().equals("")) {
            nbreArchivo = "P_EnvioCitologiaN_1";
        } else {
            nbreArchivo = Principal.informacionIps.getPrefijoReportes() + "P_EnvioCitologiaN";
        }
        this.xmt.GenerarPDF(this.xmt.getRutaRep() + nbreArchivo, parametros);
    }

    public void mImprimir() {
        String nbreArchivo;
        String nbreArchivo2;
        if (Principal.informacionIps.getIdentificacion().equals("900895500")) {
            imprimirResultado(Principal.txtNo.getText());
            return;
        }
        Object[] botones = {"Imprimir", "Visualizar", "Cerrar"};
        if (!Principal.txtNo.getText().isEmpty()) {
            String[][] parametros = new String[4][2];
            parametros[0][0] = "Id";
            parametros[0][1] = Principal.txtNo.getText();
            parametros[1][0] = "SUBREPORT_DIR";
            parametros[1][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
            parametros[2][0] = "SUBREPORTFIRMA_DIR";
            parametros[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
            parametros[3][0] = "usuarioSistema";
            parametros[3][1] = Principal.usuarioSistemaDTO.getNombreUsuario();
            int n = JOptionPane.showInternalOptionDialog(this, "¿Que desea realizar?", "TAREA", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones, "Cerrar");
            if (n == 0) {
                if (Principal.informacionIps.getEsFpz().intValue() == 0) {
                    this.xmt.PresentacionImpresora(this.xmt.getRutaRep() + "P_EnvioCitologiaN.jasper", parametros);
                } else {
                    if (Principal.informacionIps.getPrefijoReportes().equals("")) {
                        nbreArchivo2 = "P_EnvioCitologiaN_1";
                    } else {
                        nbreArchivo2 = Principal.informacionIps.getPrefijoReportes() + "P_EnvioCitologiaN";
                    }
                    this.xmt.GenerarPDF(this.xmt.getRutaRep() + nbreArchivo2, parametros);
                }
            } else if (n == 1) {
                if (Principal.informacionIps.getEsFpz().intValue() == 0) {
                    this.xmt.GenerarPDF(this.xmt.getRutaRep() + "P_EnvioCitologiaN", parametros);
                } else {
                    if (Principal.informacionIps.getPrefijoReportes().equals("")) {
                        nbreArchivo = "P_EnvioCitologiaN_1";
                    } else {
                        nbreArchivo = Principal.informacionIps.getPrefijoReportes() + "P_EnvioCitologiaN";
                    }
                    this.xmt.GenerarPDF(this.xmt.getRutaRep() + nbreArchivo, parametros);
                }
            }
            this.xct.cerrarConexionBd();
        }
    }

    /* JADX WARN: Finally extract failed */
    private void mCargar_ResultadosC() {
        try {
            mCrearTablaR();
            this.xsql = "SELECT `p_citologia_conceptoestudio`.`Id` , concat('     ',`p_citologia_conceptoestudio`.`Nbre`) AS `NConcepto` , TRUE AS `NSelecion` , `p_citologia_tipoestudio`.`Nbre` AS `NEncabezado`  FROM `p_citologia_conceptoestudio` INNER JOIN  `p_citologia_tipoestudio`  ON (`p_citologia_conceptoestudio`.`Id_TipoEstudio` = `p_citologia_tipoestudio`.`Id`) ORDER BY `p_citologia_tipoestudio`.`Orden` ASC, `p_citologia_conceptoestudio`.`Orden` ASC ";
            ResultSet xrs = this.xct.traerRs(this.xsql);
            Throwable th = null;
            try {
                if (xrs.next()) {
                    int x = 0;
                    int xt = 1;
                    String xnombrep = "";
                    xrs.beforeFirst();
                    this.xmt.mEstablecerTextEditor(this.JTB_Resultado, 1);
                    while (xrs.next()) {
                        if (!xnombrep.equals(xrs.getString("NEncabezado"))) {
                            this.xmodelor.addRow(this.xdato);
                            this.xmodelor.setValueAt(xt + ". " + xrs.getString("NEncabezado").toUpperCase(), x, 1);
                            this.xmodelor.setValueAt(false, x, 2);
                            this.xmodelor.setValueAt(true, x, 3);
                            xnombrep = xrs.getString("NEncabezado");
                            xt++;
                            x++;
                        }
                        this.xmodelor.addRow(this.xdato);
                        this.xmodelor.setValueAt(Long.valueOf(xrs.getLong(1)), x, 0);
                        this.xmodelor.setValueAt(xrs.getString("NConcepto"), x, 1);
                        this.xmodelor.setValueAt(false, x, 2);
                        this.xmodelor.setValueAt(false, x, 3);
                        x++;
                    }
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
            Logger.getLogger(JIFCACervix.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mNuevoSeguimiento() {
        this.JDSFecha.setDate(this.xmt.getFechaActual());
        this.JTA_SObservacion.setText("");
        List<Object[]> list = this.xTipoSeguimiento.listTipoSeguimiento();
        this.JCB_STipoSeguimiento.removeAllItems();
        if (!list.isEmpty()) {
            this.xIdTipoSeguimiento = new String[list.size()];
            for (int x = 0; x < list.size(); x++) {
                this.xIdTipoSeguimiento[x] = list.get(x)[0].toString();
                this.JCB_STipoSeguimiento.addItem(list.get(x)[1].toString());
            }
            this.JCB_STipoSeguimiento.setSelectedIndex(-1);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTablaSeguimiento() {
        this.xModeloSeguimiento = new DefaultTableModel(new Object[0], new String[]{"Id", "Fecha", "Tipo", "Observacion", "Cargo", "Responsable"}) { // from class: PyP.JIFCACervix.26
            Class[] types = {Long.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTB_SHistorico;
        JTable jTable2 = this.JTB_SHistorico;
        jTable.setAutoResizeMode(0);
        this.JTB_SHistorico.doLayout();
        this.JTB_SHistorico.setModel(this.xModeloSeguimiento);
        this.JTB_SHistorico.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.JTB_SHistorico.getColumnModel().getColumn(1).setPreferredWidth(80);
        this.JTB_SHistorico.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTB_SHistorico.getColumnModel().getColumn(3).setPreferredWidth(300);
        this.JTB_SHistorico.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTB_SHistorico.getColumnModel().getColumn(5).setPreferredWidth(200);
    }

    public void mCargarDatos_Seguimiento() {
        mCrearTablaSeguimiento();
        List<Object[]> list1 = this.xCitologiaDAO.listaSeguimiento(Long.valueOf(Principal.txtNo.getText()));
        long xnfila = 0;
        if (!list1.isEmpty()) {
            this.xmt.mEstablecerTextEditor(this.JTB_SHistorico, 3);
            this.xmt.mEstablecerTextEditor(this.JTB_SHistorico, 5);
            for (int x = 0; x < list1.size(); x++) {
                this.xModeloSeguimiento.addRow(this.xdato);
                this.xModeloSeguimiento.setValueAt(list1.get(x)[0], x, 0);
                this.xModeloSeguimiento.setValueAt(list1.get(x)[1], x, 1);
                this.xModeloSeguimiento.setValueAt(list1.get(x)[2], x, 2);
                this.xModeloSeguimiento.setValueAt(list1.get(x)[3], x, 3);
                this.xModeloSeguimiento.setValueAt(list1.get(x)[4], x, 4);
                this.xModeloSeguimiento.setValueAt(list1.get(x)[5], x, 5);
                xnfila++;
            }
        }
    }

    private void mConsultarR(int Id_recepcion) {
        if (Id_recepcion != 0) {
            int xRegistro = 0;
            int xIdcitologia = 0;
            String sql1 = "SELECT p_citologia.`Id_Recepcion`, p_citologia.`Id` idCitologia\n, ifnull(pcr.Id,0) idResultado, concat(lrc.Ano,lrc.Id_Consecutivo) consecutivo\nFROM `p_citologia` \nleft join l_recepcion_citologia lrc on (lrc.Id_Recepcion =p_citologia.`Id_Recepcion`)\nleft join p_citologia_resultados pcr on (pcr.Id_Citologia =p_citologia.`Id`) \nWHERE (p_citologia.`Id_Recepcion` =" + Id_recepcion + ")";
            ConsultasMySQL xct1 = new ConsultasMySQL();
            ResultSet xrs1 = xct1.traerRs(sql1);
            try {
                if (xrs1.next()) {
                    xrs1.first();
                    this.jLabel2.setText(xrs1.getString("consecutivo"));
                    xRegistro = xrs1.getInt("Id_Recepcion");
                    xIdcitologia = xrs1.getInt("Id");
                    if (xrs1.getLong("idResultado") != 0) {
                        this.idResultadoCitologiaActual = xrs1.getString("idResultado");
                    }
                    this.JTXTConsecutivoI.setText(xrs1.getString("consecutivo"));
                }
                xrs1.close();
                xct1.cerrarConexionBd();
                if (xRegistro == Id_recepcion) {
                    Principal.txtNo.setText(String.valueOf(xIdcitologia));
                }
            } catch (SQLException e) {
            }
        }
    }
}
