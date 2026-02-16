package com.genoma.plus.controller.sgc;

import Acceso.Principal;
import General.Anular;
import Utilidades.CustomPopupMenuListener;
import Utilidades.Metodos;
import com.genoma.plus.dao.impl.sgc.SC_EventoAdversoAnalisisDAOImpl;
import com.genoma.plus.dao.impl.sgc.SC_EventoAdversoGestionDAOImpl;
import com.genoma.plus.dao.impl.sgc.SGC_ActasDAOImpl;
import com.genoma.plus.dao.sgc.SC_EventoAdversoAnalisisDAO;
import com.genoma.plus.dao.sgc.SC_EventoAdversoGestionDAO;
import com.genoma.plus.dao.sgc.SGC_ActasDAO;
import com.genoma.plus.dto.gcuenta.GCGenericoDTO;
import com.genoma.plus.dto.sgc.SGC_AnalisisAccionDTO;
import com.genoma.plus.dto.sgc.SGC_AnalisisCausaDTO;
import com.genoma.plus.dto.sgc.SGC_AnalisisIntegranteDTO;
import com.genoma.plus.dto.sgc.SGC_AnalisisPCausaDTO;
import com.genoma.plus.dto.sgc.SGC_Analisis_EventoAdversoDTO;
import com.genoma.plus.dto.sgc.SGC_Ficha5w1hDTO;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DateFormatter;
import javax.swing.text.DefaultFormatterFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/sgc/SC_JDEventoAdversoGestion.class */
public class SC_JDEventoAdversoGestion extends JDialog {
    private int xEstadoCausa;
    private int xEstadoAccion;
    private int xEstadoProceso;
    private int xTipoPersona;
    private int xFilaCausa;
    private int xFilaPCausa;
    private int xFilaInteg;
    private int xFilaAccion;
    private Boolean xLleno;
    private Boolean xLleno1;
    private SC_EventoAdversoGestionDAO xSC_EventoAdversoGestionDAO;
    private Metodos xmt;
    private DefaultTableModel xModeloPCausa;
    private DefaultTableModel xModeloCausa;
    private DefaultTableModel xModeloIntegrante;
    private DefaultTableModel xModeloAccion;
    private Object[] xDatoIntegrante;
    private Object[] xDatoCausa;
    private Object[] xDatoAccion;
    private String[] xIdTipoProceso;
    private String[] xIdUsuario;
    private String[] xIdCausa;
    private String[] xIdTipoProcesoInte;
    private String[] xIdTipoProcesoAccion;
    private String[] xIdAccion;
    private String[] xidOrigen;
    private List<Object[]> listComboResponble;
    private List<Object[]> listComboUsuario;
    private JIFF_SC_EventoAdversoAnalisis xJIFF_SC_EventoAdversoAnalisis;
    private SC_EventoAdversoAnalisisDAO xSC_EventoAdversoAnalisisDAO;
    private SGC_ActasDAO xSGC_ActasDAO;
    private ButtonGroup BGTipoPersona;
    private JButton JBEliminar;
    private JButton JBGuardar;
    private JButton JBSalir;
    private JButton JBTAddAccion;
    private JButton JBTAddCausa;
    private JButton JBTAddIntegrante;
    private JButton JBTAddProceso;
    private JComboBox JCBAccion;
    private JComboBox JCBCausa;
    private JComboBox JCBOrigen;
    private JComboBox JCBPersonaIntegrante;
    private JComboBox JCBProcesoAccion;
    private JComboBox JCBProcesoIntegrantes;
    private JComboBox JCBUsuario;
    private JCheckBox JCHAplicaFicha;
    private JCheckBox JCHEstadoAccion;
    private JCheckBox JCHEstadoCausa;
    private JCheckBox JCHEstadoProceso;
    public JDateChooser JDCHFecha;
    public JDateChooser JDCHFechaAccion;
    public JDateChooser JDCHFechaEvento;
    public JDateChooser JDCHFechaIntegrantes;
    public JFormattedTextField JFTFHoraEvento;
    private JLabel JLBIdAnalisisEvent;
    private JPanel JPDatos;
    private JPanel JPIDetalle2;
    private JPanel JPIEncuesta;
    private JPanel JPIEvaluacion;
    private JPanel JPISeguimiento;
    private JPanel JPTipoPersona;
    private JRadioButton JRBPersonaExterna;
    private JRadioButton JRBPersonaInterna;
    private JSpinner JSOrdenCausa;
    private JSpinner JSOrdenProceso;
    private JScrollPane JSPObservacionG1;
    private JScrollPane JSPObservacionG2;
    private JTextPane JTADescripcionProceso;

    /* JADX INFO: renamed from: JTADescripción, reason: contains not printable characters */
    private JTextPane f26JTADescripcin;
    public JTable JTDetalleAccion;
    public JTable JTDetalleCausa;
    public JTable JTDetalleIntegrantes;
    public JTable JTDetalleProceso;
    private JTextField JTFCargo;
    private JTextField JTFCodEvento;
    private JTextField JTFDetalleAccion;
    private JTextField JTFIdentificacion1;
    private JTextField JTFNombre;
    private JTextField JTFNombre1;
    private JTextField JTFObservacionGeneral;
    private JTabbedPane JTPDetalle2;
    private JPanel jPanel3;
    private JScrollPane jScrollPane3;
    private JScrollPane jScrollPane4;
    private JScrollPane jScrollPane5;
    private JScrollPane jScrollPane6;

    public SC_JDEventoAdversoGestion(Frame parent, boolean modal, JIFF_SC_EventoAdversoAnalisis xJIFF_SC_EventoAdversoAnalisis) {
        super(parent, modal);
        this.xEstadoCausa = 1;
        this.xEstadoAccion = 1;
        this.xEstadoProceso = 1;
        this.xTipoPersona = 1;
        this.xFilaCausa = -1;
        this.xFilaPCausa = -1;
        this.xFilaInteg = -1;
        this.xFilaAccion = -1;
        this.xLleno = false;
        this.xLleno1 = false;
        this.xmt = new Metodos();
        initComponents();
        springStart();
        this.xJIFF_SC_EventoAdversoAnalisis = xJIFF_SC_EventoAdversoAnalisis;
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        setTitle("GESTIÓN EVENTO");
        mInciaComponentes();
        mCargarDatos();
    }

    private void mInciaComponentes() {
        System.out.println("Cod-->" + this.xJIFF_SC_EventoAdversoAnalisis.xmodelo.getValueAt(this.xJIFF_SC_EventoAdversoAnalisis.JTDetalle.getSelectedRow(), 0).toString());
        this.JTFCodEvento.setText(this.xJIFF_SC_EventoAdversoAnalisis.xmodelo.getValueAt(this.xJIFF_SC_EventoAdversoAnalisis.JTDetalle.getSelectedRow(), 0).toString());
        this.JDCHFechaEvento.setDate(Date.valueOf(this.xJIFF_SC_EventoAdversoAnalisis.xmodelo.getValueAt(this.xJIFF_SC_EventoAdversoAnalisis.JTDetalle.getSelectedRow(), 1).toString()));
        this.JFTFHoraEvento.setText(this.xJIFF_SC_EventoAdversoAnalisis.xmodelo.getValueAt(this.xJIFF_SC_EventoAdversoAnalisis.JTDetalle.getSelectedRow(), 2).toString());
        this.JTFIdentificacion1.setText(this.xJIFF_SC_EventoAdversoAnalisis.xmodelo.getValueAt(this.xJIFF_SC_EventoAdversoAnalisis.JTDetalle.getSelectedRow(), 3).toString());
        this.JTFNombre1.setText(this.xJIFF_SC_EventoAdversoAnalisis.xmodelo.getValueAt(this.xJIFF_SC_EventoAdversoAnalisis.JTDetalle.getSelectedRow(), 4).toString());
        JRBPersonaInternaActionPerformed(null);
        mLLenaCombo();
        mModeloDetalleCausa();
        mModeloDetallePCausa();
        mModeloDetalleIntegrante();
        mModeloDetalleAccion();
    }

    private void springStart() {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"});
        this.xSC_EventoAdversoGestionDAO = (SC_EventoAdversoGestionDAOImpl) classPathXmlApplicationContext.getBean("sCEventoAdversoGestion");
        this.xSC_EventoAdversoAnalisisDAO = (SC_EventoAdversoAnalisisDAOImpl) classPathXmlApplicationContext.getBean("sCEventoAdversoAnalisisDAOImpl");
        this.xSGC_ActasDAO = (SGC_ActasDAOImpl) classPathXmlApplicationContext.getBean("sGCActasDAO");
    }

    /* JADX WARN: Type inference failed for: r3v103, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v161, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v39, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v73, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.BGTipoPersona = new ButtonGroup();
        this.jPanel3 = new JPanel();
        this.JDCHFecha = new JDateChooser("dd/MM/yyyy", "##/##/####", '_');
        this.JTFObservacionGeneral = new JTextField();
        this.JLBIdAnalisisEvent = new JLabel();
        this.JTPDetalle2 = new JTabbedPane();
        this.JPIDetalle2 = new JPanel();
        this.JCBCausa = new JComboBox();
        this.JSPObservacionG1 = new JScrollPane();
        this.f26JTADescripcin = new JTextPane();
        this.JCHEstadoCausa = new JCheckBox();
        this.JSOrdenCausa = new JSpinner();
        this.jScrollPane3 = new JScrollPane();
        this.JTDetalleCausa = new JTable();
        this.JBTAddCausa = new JButton();
        this.JPIEvaluacion = new JPanel();
        this.JSPObservacionG2 = new JScrollPane();
        this.JTADescripcionProceso = new JTextPane();
        this.JSOrdenProceso = new JSpinner();
        this.JCHEstadoProceso = new JCheckBox();
        this.jScrollPane6 = new JScrollPane();
        this.JTDetalleProceso = new JTable();
        this.JBTAddProceso = new JButton();
        this.JPISeguimiento = new JPanel();
        this.JCBProcesoIntegrantes = new JComboBox();
        this.JTFNombre = new JTextField();
        this.JTFCargo = new JTextField();
        this.JDCHFechaIntegrantes = new JDateChooser("dd/MM/yyyy", "##/##/####", '_');
        this.jScrollPane4 = new JScrollPane();
        this.JTDetalleIntegrantes = new JTable();
        this.JBTAddIntegrante = new JButton();
        this.JPTipoPersona = new JPanel();
        this.JRBPersonaInterna = new JRadioButton();
        this.JRBPersonaExterna = new JRadioButton();
        this.JCBPersonaIntegrante = new JComboBox();
        this.JPIEncuesta = new JPanel();
        this.JCBAccion = new JComboBox();
        this.JCBProcesoAccion = new JComboBox();
        this.JCBUsuario = new JComboBox();
        this.JDCHFechaAccion = new JDateChooser("dd/MM/yyyy", "##/##/####", '_');
        this.JCHEstadoAccion = new JCheckBox();
        this.jScrollPane5 = new JScrollPane();
        this.JTDetalleAccion = new JTable();
        this.JBTAddAccion = new JButton();
        this.JTFDetalleAccion = new JTextField();
        this.JCBOrigen = new JComboBox();
        this.JCHAplicaFicha = new JCheckBox();
        this.JBSalir = new JButton();
        this.JPDatos = new JPanel();
        this.JDCHFechaEvento = new JDateChooser("dd/MM/yyyy", "##/##/####", '_');
        this.JTFIdentificacion1 = new JTextField();
        this.JTFNombre1 = new JTextField();
        this.JTFCodEvento = new JTextField();
        this.JFTFHoraEvento = new JFormattedTextField();
        this.JBGuardar = new JButton();
        this.JBEliminar = new JButton();
        setDefaultCloseOperation(2);
        this.jPanel3.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JDCHFecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCHFecha.setDateFormatString("dd/MM/yyyy");
        this.JDCHFecha.setFont(new Font("Arial", 1, 12));
        this.JTFObservacionGeneral.setFont(new Font("Arial", 1, 12));
        this.JTFObservacionGeneral.setToolTipText("");
        this.JTFObservacionGeneral.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JLBIdAnalisisEvent.setFont(new Font("Arial", 1, 12));
        this.JLBIdAnalisisEvent.setForeground(Color.red);
        this.JLBIdAnalisisEvent.setHorizontalAlignment(0);
        this.JLBIdAnalisisEvent.setBorder(BorderFactory.createTitledBorder((Border) null, "Id Análisis Evento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
        this.jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addComponent(this.JDCHFecha, -2, 134, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFObservacionGeneral, -2, 658, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLBIdAnalisisEvent, -1, -1, 32767).addContainerGap()));
        jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup().addGap(0, 12, 32767).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JDCHFecha, -1, 45, 32767).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFObservacionGeneral).addComponent(this.JLBIdAnalisisEvent, -1, -1, 32767))).addContainerGap()));
        this.JTPDetalle2.setForeground(new Color(0, 103, 0));
        this.JTPDetalle2.setFont(new Font("Arial", 1, 14));
        this.JCBCausa.setFont(new Font("Arial", 1, 12));
        this.JCBCausa.setBorder(BorderFactory.createTitledBorder((Border) null, "Causa", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPObservacionG1.setBorder(BorderFactory.createTitledBorder((Border) null, "Descripción", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.f26JTADescripcin.setFont(new Font("Arial", 1, 12));
        this.JSPObservacionG1.setViewportView(this.f26JTADescripcin);
        this.JCHEstadoCausa.setFont(new Font("Arial", 1, 12));
        this.JCHEstadoCausa.setSelected(true);
        this.JCHEstadoCausa.setText("Estado");
        this.JCHEstadoCausa.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sgc.SC_JDEventoAdversoGestion.1
            public void actionPerformed(ActionEvent evt) {
                SC_JDEventoAdversoGestion.this.JCHEstadoCausaActionPerformed(evt);
            }
        });
        this.JSOrdenCausa.setFont(new Font("Arial", 1, 12));
        this.JSOrdenCausa.setModel(new SpinnerNumberModel(0, 0, (Comparable) null, 1));
        this.JSOrdenCausa.setBorder(BorderFactory.createTitledBorder((Border) null, "Orden", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jScrollPane3.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalleCausa.setFont(new Font("Arial", 1, 12));
        this.JTDetalleCausa.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalleCausa.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalleCausa.setSelectionForeground(Color.red);
        this.JTDetalleCausa.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.sgc.SC_JDEventoAdversoGestion.2
            public void keyPressed(KeyEvent evt) {
                SC_JDEventoAdversoGestion.this.JTDetalleCausaKeyPressed(evt);
            }
        });
        this.jScrollPane3.setViewportView(this.JTDetalleCausa);
        this.JBTAddCausa.setFont(new Font("Arial", 1, 12));
        this.JBTAddCausa.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTAddCausa.setToolTipText("Buscar Evento Adverso");
        this.JBTAddCausa.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sgc.SC_JDEventoAdversoGestion.3
            public void actionPerformed(ActionEvent evt) {
                SC_JDEventoAdversoGestion.this.JBTAddCausaActionPerformed(evt);
            }
        });
        GroupLayout JPIDetalle2Layout = new GroupLayout(this.JPIDetalle2);
        this.JPIDetalle2.setLayout(JPIDetalle2Layout);
        JPIDetalle2Layout.setHorizontalGroup(JPIDetalle2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDetalle2Layout.createSequentialGroup().addGap(10, 10, 10).addGroup(JPIDetalle2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.jScrollPane3).addGroup(JPIDetalle2Layout.createSequentialGroup().addGroup(JPIDetalle2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPIDetalle2Layout.createSequentialGroup().addComponent(this.JCBCausa, -2, 601, -2).addGap(16, 16, 16).addComponent(this.JSOrdenCausa, -2, 106, -2).addGap(18, 18, 18).addComponent(this.JCHEstadoCausa)).addComponent(this.JSPObservacionG1, -2, 810, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTAddCausa, -2, 130, -2).addGap(2, 2, 2))).addContainerGap(-1, 32767)));
        JPIDetalle2Layout.setVerticalGroup(JPIDetalle2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDetalle2Layout.createSequentialGroup().addGap(22, 22, 22).addGroup(JPIDetalle2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDetalle2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBCausa, -2, 50, -2).addComponent(this.JSOrdenCausa, -2, 50, -2)).addGroup(JPIDetalle2Layout.createSequentialGroup().addGap(8, 8, 8).addComponent(this.JCHEstadoCausa))).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIDetalle2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSPObservacionG1, -2, 68, -2).addComponent(this.JBTAddCausa, -2, 60, -2)).addGap(12, 12, 12).addComponent(this.jScrollPane3, -2, 149, -2).addContainerGap()));
        this.JTPDetalle2.addTab("CAUSA", this.JPIDetalle2);
        this.JSPObservacionG2.setBorder(BorderFactory.createTitledBorder((Border) null, "Descripción", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTADescripcionProceso.setFont(new Font("Arial", 1, 12));
        this.JSPObservacionG2.setViewportView(this.JTADescripcionProceso);
        this.JSOrdenProceso.setFont(new Font("Arial", 1, 12));
        this.JSOrdenProceso.setModel(new SpinnerNumberModel(0, 0, (Comparable) null, 1));
        this.JSOrdenProceso.setBorder(BorderFactory.createTitledBorder((Border) null, "Orden", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHEstadoProceso.setFont(new Font("Arial", 1, 12));
        this.JCHEstadoProceso.setSelected(true);
        this.JCHEstadoProceso.setText("Estado");
        this.JCHEstadoProceso.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sgc.SC_JDEventoAdversoGestion.4
            public void actionPerformed(ActionEvent evt) {
                SC_JDEventoAdversoGestion.this.JCHEstadoProcesoActionPerformed(evt);
            }
        });
        this.jScrollPane6.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalleProceso.setFont(new Font("Arial", 1, 12));
        this.JTDetalleProceso.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalleProceso.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalleProceso.setSelectionForeground(Color.red);
        this.JTDetalleProceso.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.sgc.SC_JDEventoAdversoGestion.5
            public void keyPressed(KeyEvent evt) {
                SC_JDEventoAdversoGestion.this.JTDetalleProcesoKeyPressed(evt);
            }
        });
        this.jScrollPane6.setViewportView(this.JTDetalleProceso);
        this.JBTAddProceso.setFont(new Font("Arial", 1, 12));
        this.JBTAddProceso.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTAddProceso.setToolTipText("Buscar Evento Adverso");
        this.JBTAddProceso.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sgc.SC_JDEventoAdversoGestion.6
            public void actionPerformed(ActionEvent evt) {
                SC_JDEventoAdversoGestion.this.JBTAddProcesoActionPerformed(evt);
            }
        });
        GroupLayout JPIEvaluacionLayout = new GroupLayout(this.JPIEvaluacion);
        this.JPIEvaluacion.setLayout(JPIEvaluacionLayout);
        JPIEvaluacionLayout.setHorizontalGroup(JPIEvaluacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIEvaluacionLayout.createSequentialGroup().addContainerGap().addGroup(JPIEvaluacionLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPIEvaluacionLayout.createSequentialGroup().addComponent(this.jScrollPane6, -2, 956, -2).addContainerGap(-1, 32767)).addGroup(JPIEvaluacionLayout.createSequentialGroup().addGroup(JPIEvaluacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIEvaluacionLayout.createSequentialGroup().addComponent(this.JSOrdenProceso, -2, 97, -2).addGap(30, 30, 30).addComponent(this.JCHEstadoProceso).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JBTAddProceso, -2, 126, -2)).addComponent(this.JSPObservacionG2)).addGap(29, 29, 29)))));
        JPIEvaluacionLayout.setVerticalGroup(JPIEvaluacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIEvaluacionLayout.createSequentialGroup().addComponent(this.JSPObservacionG2, -2, 66, -2).addGroup(JPIEvaluacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIEvaluacionLayout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(JPIEvaluacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSOrdenProceso, -2, 50, -2).addComponent(this.JBTAddProceso, GroupLayout.Alignment.TRAILING, -2, 50, -2)).addGap(13, 13, 13)).addGroup(JPIEvaluacionLayout.createSequentialGroup().addGap(18, 18, 18).addComponent(this.JCHEstadoProceso).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767))).addComponent(this.jScrollPane6, -2, 161, -2).addContainerGap()));
        this.JTPDetalle2.addTab("RESUMEN O SINTESIS", this.JPIEvaluacion);
        this.JCBProcesoIntegrantes.setFont(new Font("Arial", 1, 12));
        this.JCBProcesoIntegrantes.setBorder(BorderFactory.createTitledBorder((Border) null, "Proceso", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBProcesoIntegrantes.addItemListener(new ItemListener() { // from class: com.genoma.plus.controller.sgc.SC_JDEventoAdversoGestion.7
            public void itemStateChanged(ItemEvent evt) {
                SC_JDEventoAdversoGestion.this.JCBProcesoIntegrantesItemStateChanged(evt);
            }
        });
        this.JTFNombre.setFont(new Font("Arial", 1, 12));
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFCargo.setFont(new Font("Arial", 1, 12));
        this.JTFCargo.setBorder(BorderFactory.createTitledBorder((Border) null, "Cargo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCHFechaIntegrantes.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Firma", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCHFechaIntegrantes.setDateFormatString("dd/MM/yyyy");
        this.JDCHFechaIntegrantes.setFont(new Font("Arial", 1, 12));
        this.jScrollPane4.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalleIntegrantes.setFont(new Font("Arial", 1, 12));
        this.JTDetalleIntegrantes.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalleIntegrantes.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalleIntegrantes.setSelectionForeground(Color.red);
        this.JTDetalleIntegrantes.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.sgc.SC_JDEventoAdversoGestion.8
            public void keyPressed(KeyEvent evt) {
                SC_JDEventoAdversoGestion.this.JTDetalleIntegrantesKeyPressed(evt);
            }
        });
        this.jScrollPane4.setViewportView(this.JTDetalleIntegrantes);
        this.JBTAddIntegrante.setFont(new Font("Arial", 1, 12));
        this.JBTAddIntegrante.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTAddIntegrante.setToolTipText("Buscar Evento Adverso");
        this.JBTAddIntegrante.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sgc.SC_JDEventoAdversoGestion.9
            public void actionPerformed(ActionEvent evt) {
                SC_JDEventoAdversoGestion.this.JBTAddIntegranteActionPerformed(evt);
            }
        });
        this.JPTipoPersona.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Persona", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.BGTipoPersona.add(this.JRBPersonaInterna);
        this.JRBPersonaInterna.setFont(new Font("Arial", 1, 12));
        this.JRBPersonaInterna.setSelected(true);
        this.JRBPersonaInterna.setText("Interna");
        this.JRBPersonaInterna.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sgc.SC_JDEventoAdversoGestion.10
            public void actionPerformed(ActionEvent evt) {
                SC_JDEventoAdversoGestion.this.JRBPersonaInternaActionPerformed(evt);
            }
        });
        this.BGTipoPersona.add(this.JRBPersonaExterna);
        this.JRBPersonaExterna.setFont(new Font("Arial", 1, 12));
        this.JRBPersonaExterna.setText("Externa");
        this.JRBPersonaExterna.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sgc.SC_JDEventoAdversoGestion.11
            public void actionPerformed(ActionEvent evt) {
                SC_JDEventoAdversoGestion.this.JRBPersonaExternaActionPerformed(evt);
            }
        });
        GroupLayout JPTipoPersonaLayout = new GroupLayout(this.JPTipoPersona);
        this.JPTipoPersona.setLayout(JPTipoPersonaLayout);
        JPTipoPersonaLayout.setHorizontalGroup(JPTipoPersonaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPTipoPersonaLayout.createSequentialGroup().addComponent(this.JRBPersonaInterna).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 28, 32767).addComponent(this.JRBPersonaExterna)));
        JPTipoPersonaLayout.setVerticalGroup(JPTipoPersonaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPTipoPersonaLayout.createSequentialGroup().addGroup(JPTipoPersonaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBPersonaInterna).addComponent(this.JRBPersonaExterna)).addContainerGap(-1, 32767)));
        this.JCBPersonaIntegrante.setFont(new Font("Arial", 1, 12));
        this.JCBPersonaIntegrante.setBorder(BorderFactory.createTitledBorder((Border) null, "Responsable", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBPersonaIntegrante.addItemListener(new ItemListener() { // from class: com.genoma.plus.controller.sgc.SC_JDEventoAdversoGestion.12
            public void itemStateChanged(ItemEvent evt) {
                SC_JDEventoAdversoGestion.this.JCBPersonaIntegranteItemStateChanged(evt);
            }
        });
        GroupLayout JPISeguimientoLayout = new GroupLayout(this.JPISeguimiento);
        this.JPISeguimiento.setLayout(JPISeguimientoLayout);
        JPISeguimientoLayout.setHorizontalGroup(JPISeguimientoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPISeguimientoLayout.createSequentialGroup().addGroup(JPISeguimientoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPISeguimientoLayout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.JPTipoPersona, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBProcesoIntegrantes, 0, 389, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBPersonaIntegrante, -2, 371, -2)).addComponent(this.jScrollPane4).addGroup(JPISeguimientoLayout.createSequentialGroup().addContainerGap().addGroup(JPISeguimientoLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JTFCargo, GroupLayout.Alignment.LEADING, -1, 791, 32767).addComponent(this.JTFNombre, GroupLayout.Alignment.LEADING)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPISeguimientoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JDCHFechaIntegrantes, -1, 145, 32767).addComponent(this.JBTAddIntegrante, -1, -1, 32767)).addGap(0, 0, 32767))).addContainerGap()));
        JPISeguimientoLayout.setVerticalGroup(JPISeguimientoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPISeguimientoLayout.createSequentialGroup().addContainerGap().addGroup(JPISeguimientoLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JPTipoPersona, -2, 50, -2).addGroup(JPISeguimientoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBProcesoIntegrantes, -2, 50, -2).addComponent(this.JCBPersonaIntegrante, -2, 50, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPISeguimientoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPISeguimientoLayout.createSequentialGroup().addComponent(this.JTFNombre, -2, 50, -2).addGap(2, 2, 2).addComponent(this.JTFCargo, -2, 50, -2)).addGroup(JPISeguimientoLayout.createSequentialGroup().addComponent(this.JDCHFechaIntegrantes, -2, 52, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTAddIntegrante, -2, 41, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.jScrollPane4, -2, 124, -2).addGap(69, 69, 69)));
        this.JTPDetalle2.addTab("INTEGRANTES", this.JPISeguimiento);
        this.JCBAccion.setFont(new Font("Arial", 1, 12));
        this.JCBAccion.setBorder(BorderFactory.createTitledBorder((Border) null, "Accion", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBProcesoAccion.setFont(new Font("Arial", 1, 12));
        this.JCBProcesoAccion.setBorder(BorderFactory.createTitledBorder((Border) null, "Proceso", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBProcesoAccion.addItemListener(new ItemListener() { // from class: com.genoma.plus.controller.sgc.SC_JDEventoAdversoGestion.13
            public void itemStateChanged(ItemEvent evt) {
                SC_JDEventoAdversoGestion.this.JCBProcesoAccionItemStateChanged(evt);
            }
        });
        this.JCBUsuario.setFont(new Font("Arial", 1, 12));
        this.JCBUsuario.setBorder(BorderFactory.createTitledBorder((Border) null, "Usuario", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCHFechaAccion.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCHFechaAccion.setDateFormatString("dd/MM/yyyy");
        this.JDCHFechaAccion.setFont(new Font("Arial", 1, 12));
        this.JCHEstadoAccion.setFont(new Font("Arial", 1, 12));
        this.JCHEstadoAccion.setSelected(true);
        this.JCHEstadoAccion.setText("Estado");
        this.JCHEstadoAccion.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sgc.SC_JDEventoAdversoGestion.14
            public void actionPerformed(ActionEvent evt) {
                SC_JDEventoAdversoGestion.this.JCHEstadoAccionActionPerformed(evt);
            }
        });
        this.jScrollPane5.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalleAccion.setFont(new Font("Arial", 1, 12));
        this.JTDetalleAccion.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalleAccion.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalleAccion.setSelectionForeground(Color.red);
        this.JTDetalleAccion.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.sgc.SC_JDEventoAdversoGestion.15
            public void keyPressed(KeyEvent evt) {
                SC_JDEventoAdversoGestion.this.JTDetalleAccionKeyPressed(evt);
            }
        });
        this.jScrollPane5.setViewportView(this.JTDetalleAccion);
        this.JBTAddAccion.setFont(new Font("Arial", 1, 12));
        this.JBTAddAccion.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTAddAccion.setToolTipText("Buscar Evento Adverso");
        this.JBTAddAccion.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sgc.SC_JDEventoAdversoGestion.16
            public void actionPerformed(ActionEvent evt) {
                SC_JDEventoAdversoGestion.this.JBTAddAccionActionPerformed(evt);
            }
        });
        this.JTFDetalleAccion.setFont(new Font("Arial", 1, 12));
        this.JTFDetalleAccion.setBorder(BorderFactory.createTitledBorder((Border) null, "Detalle", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBOrigen.setFont(new Font("Arial", 1, 12));
        this.JCBOrigen.setBorder(BorderFactory.createTitledBorder((Border) null, "Origen", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHAplicaFicha.setFont(new Font("Arial", 1, 12));
        this.JCHAplicaFicha.setSelected(true);
        this.JCHAplicaFicha.setText("Aplica Ficha 5W1H");
        GroupLayout JPIEncuestaLayout = new GroupLayout(this.JPIEncuesta);
        this.JPIEncuesta.setLayout(JPIEncuestaLayout);
        JPIEncuestaLayout.setHorizontalGroup(JPIEncuestaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIEncuestaLayout.createSequentialGroup().addContainerGap().addGroup(JPIEncuestaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIEncuestaLayout.createSequentialGroup().addGroup(JPIEncuestaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIEncuestaLayout.createSequentialGroup().addGroup(JPIEncuestaLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JCBProcesoAccion, 0, 382, 32767).addComponent(this.JCBOrigen, 0, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIEncuestaLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JCBUsuario, 0, -1, 32767).addComponent(this.JCBAccion, 0, 382, 32767))).addComponent(this.JTFDetalleAccion, -2, 451, -2)).addGroup(JPIEncuestaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIEncuestaLayout.createSequentialGroup().addGap(19, 19, 19).addComponent(this.JCHEstadoAccion)).addGroup(JPIEncuestaLayout.createSequentialGroup().addGap(19, 19, 19).addComponent(this.JBTAddAccion, -2, 158, -2)).addGroup(JPIEncuestaLayout.createSequentialGroup().addGap(18, 18, 18).addGroup(JPIEncuestaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JDCHFechaAccion, -2, 133, -2).addComponent(this.JCHAplicaFicha)))).addContainerGap(-1, 32767)).addGroup(JPIEncuestaLayout.createSequentialGroup().addComponent(this.jScrollPane5, -2, 944, -2).addGap(0, 13, 32767)))));
        JPIEncuestaLayout.setVerticalGroup(JPIEncuestaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIEncuestaLayout.createSequentialGroup().addGroup(JPIEncuestaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBAccion, -2, 50, -2).addComponent(this.JDCHFechaAccion, -2, 50, -2).addGroup(GroupLayout.Alignment.TRAILING, JPIEncuestaLayout.createSequentialGroup().addContainerGap().addComponent(this.JCBOrigen, -2, -1, -2))).addGroup(JPIEncuestaLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPIEncuestaLayout.createSequentialGroup().addGap(10, 10, 10).addGroup(JPIEncuestaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBUsuario, -2, 50, -2).addComponent(this.JCBProcesoAccion, -2, 50, -2))).addGroup(GroupLayout.Alignment.TRAILING, JPIEncuestaLayout.createSequentialGroup().addGap(2, 2, 2).addComponent(this.JCHAplicaFicha).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JCHEstadoAccion))).addGap(13, 13, 13).addGroup(JPIEncuestaLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JBTAddAccion, -1, -1, 32767).addComponent(this.JTFDetalleAccion, -1, 50, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane5, -2, 128, -2).addContainerGap(-1, 32767)));
        this.JTPDetalle2.addTab("ACCIONES", this.JPIEncuesta);
        this.JBSalir.setFont(new Font("Arial", 1, 14));
        this.JBSalir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.JBSalir.setText("Salir");
        this.JBSalir.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sgc.SC_JDEventoAdversoGestion.17
            public void actionPerformed(ActionEvent evt) {
                SC_JDEventoAdversoGestion.this.JBSalirActionPerformed(evt);
            }
        });
        this.JPDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JDCHFechaEvento.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Evento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCHFechaEvento.setDateFormatString("dd/MM/yyyy");
        this.JDCHFechaEvento.setFont(new Font("Arial", 1, 12));
        this.JTFIdentificacion1.setFont(new Font("Arial", 1, 12));
        this.JTFIdentificacion1.setBorder(BorderFactory.createTitledBorder((Border) null, "Identificación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNombre1.setFont(new Font("Arial", 1, 12));
        this.JTFNombre1.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFCodEvento.setFont(new Font("Arial", 1, 12));
        this.JTFCodEvento.setBorder(BorderFactory.createTitledBorder((Border) null, "Código Evento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JFTFHoraEvento.setBorder(BorderFactory.createTitledBorder((Border) null, "Hora", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JFTFHoraEvento.setFormatterFactory(new DefaultFormatterFactory(new DateFormatter(new SimpleDateFormat(""))));
        this.JFTFHoraEvento.setFont(new Font("Tahoma", 1, 12));
        this.JFTFHoraEvento.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.sgc.SC_JDEventoAdversoGestion.18
            public void keyPressed(KeyEvent evt) {
                SC_JDEventoAdversoGestion.this.JFTFHoraEventoKeyPressed(evt);
            }
        });
        GroupLayout JPDatosLayout = new GroupLayout(this.JPDatos);
        this.JPDatos.setLayout(JPDatosLayout);
        JPDatosLayout.setHorizontalGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosLayout.createSequentialGroup().addGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JTFIdentificacion1, -2, 231, -2).addComponent(this.JTFCodEvento, -2, 232, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFNombre1, -1, 709, 32767).addGroup(JPDatosLayout.createSequentialGroup().addComponent(this.JDCHFechaEvento, -2, 133, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JFTFHoraEvento, -2, 113, -2).addGap(0, 0, 32767))).addContainerGap()));
        JPDatosLayout.setVerticalGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosLayout.createSequentialGroup().addGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFNombre1, -2, 51, -2).addComponent(this.JTFIdentificacion1, -2, 51, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosLayout.createSequentialGroup().addGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JDCHFechaEvento, -2, 62, -2).addGroup(JPDatosLayout.createSequentialGroup().addComponent(this.JTFCodEvento, -2, 50, -2).addGap(4, 4, 4))).addGap(8, 8, 8)).addGroup(GroupLayout.Alignment.TRAILING, JPDatosLayout.createSequentialGroup().addComponent(this.JFTFHoraEvento, -2, 50, -2).addContainerGap()))));
        this.JBGuardar.setFont(new Font("Arial", 1, 14));
        this.JBGuardar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBGuardar.setText("Guardar");
        this.JBGuardar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sgc.SC_JDEventoAdversoGestion.19
            public void actionPerformed(ActionEvent evt) {
                SC_JDEventoAdversoGestion.this.JBGuardarActionPerformed(evt);
            }
        });
        this.JBEliminar.setFont(new Font("Arial", 1, 14));
        this.JBEliminar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Cancelar30x30.png")));
        this.JBEliminar.setText("Eliminar");
        this.JBEliminar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sgc.SC_JDEventoAdversoGestion.20
            public void actionPerformed(ActionEvent evt) {
                SC_JDEventoAdversoGestion.this.JBEliminarActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.jPanel3, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JPDatos, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addGap(0, 0, 32767)).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGap(0, 445, 32767).addComponent(this.JBGuardar, -2, 172, -2).addGap(4, 4, 4).addComponent(this.JBEliminar, -2, 172, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBSalir, -2, 172, -2)).addComponent(this.JTPDetalle2, -2, 0, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(18, 18, 18).addComponent(this.JPDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jPanel3, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTPDetalle2, -2, 334, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBSalir, -2, 63, -2).addComponent(this.JBGuardar, -2, 63, -2).addComponent(this.JBEliminar, -2, 63, -2)).addGap(10, 10, 10)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEstadoCausaActionPerformed(ActionEvent evt) {
        if (this.JCHEstadoCausa.isSelected()) {
            this.xEstadoCausa = 1;
        } else {
            this.xEstadoCausa = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEstadoProcesoActionPerformed(ActionEvent evt) {
        if (this.JCHEstadoProceso.isSelected()) {
            this.xEstadoProceso = 1;
        } else {
            this.xEstadoProceso = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEstadoAccionActionPerformed(ActionEvent evt) {
        if (this.JCHEstadoAccion.isSelected()) {
            this.xEstadoAccion = 1;
        } else {
            this.xEstadoAccion = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBSalirActionPerformed(ActionEvent evt) {
        if (JOptionPane.showConfirmDialog(this.rootPane, "¿Desea cerrar la ventana?", "Salir de Análisis Evento Adverso", 0) == 0) {
            Principal.xclasesgc.xJIFF_SC_EventoAdversoAnalisis.mCargarDatosTabla(0, null, null);
            dispose();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBPersonaInternaActionPerformed(ActionEvent evt) {
        this.xTipoPersona = 0;
        this.JTFNombre.setEnabled(false);
        this.JTFCargo.setEnabled(false);
        this.JCBPersonaIntegrante.setEnabled(true);
        this.JCBPersonaIntegrante.setSelectedIndex(-1);
        this.JCBProcesoIntegrantes.setSelectedIndex(-1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBPersonaExternaActionPerformed(ActionEvent evt) {
        this.xTipoPersona = 1;
        this.JTFNombre.setEnabled(true);
        this.JTFCargo.setEnabled(true);
        this.JCBProcesoIntegrantes.setSelectedIndex(-1);
        this.JCBPersonaIntegrante.setSelectedIndex(-1);
        this.JCBPersonaIntegrante.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBProcesoAccionItemStateChanged(ItemEvent evt) {
        if (this.xLleno.booleanValue() && this.JCBProcesoAccion.getSelectedIndex() != -1) {
            this.JCBUsuario.removeAllItems();
            mLLenaComboUsuario(this.JCBUsuario);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTAddCausaActionPerformed(ActionEvent evt) {
        if (this.JCBCausa.getSelectedIndex() != -1) {
            if (!this.f26JTADescripcin.getText().isEmpty()) {
                this.xFilaCausa++;
                this.xModeloCausa.addRow(this.xDatoCausa);
                this.xModeloCausa.setValueAt(this.xIdCausa[this.JCBCausa.getSelectedIndex()], this.xModeloCausa.getRowCount() - 1, 0);
                this.xModeloCausa.setValueAt(this.JCBCausa.getSelectedItem().toString(), this.xModeloCausa.getRowCount() - 1, 1);
                this.xModeloCausa.setValueAt(this.f26JTADescripcin.getText(), this.xModeloCausa.getRowCount() - 1, 2);
                this.xModeloCausa.setValueAt(this.JSOrdenCausa.getValue(), this.xModeloCausa.getRowCount() - 1, 3);
                if (this.xEstadoCausa == 1) {
                    this.xModeloCausa.setValueAt(true, this.xModeloCausa.getRowCount() - 1, 4);
                } else {
                    this.xModeloCausa.setValueAt(false, this.xModeloCausa.getRowCount() - 1, 4);
                }
                this.JCBCausa.setSelectedIndex(-1);
                this.f26JTADescripcin.setText("");
                this.JCBCausa.requestFocus();
                return;
            }
            JOptionPane.showMessageDialog(this, "Debe ingresar su descripción", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            this.f26JTADescripcin.requestFocus();
            return;
        }
        JOptionPane.showMessageDialog(this, "Debe seleccionar una causa", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        this.JCBCausa.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTAddProcesoActionPerformed(ActionEvent evt) {
        if (!this.JTADescripcionProceso.getText().isEmpty()) {
            this.xFilaPCausa++;
            this.xModeloPCausa.addRow(this.xDatoCausa);
            this.xModeloPCausa.setValueAt(this.JTADescripcionProceso.getText(), this.xModeloPCausa.getRowCount() - 1, 0);
            this.xModeloPCausa.setValueAt(this.JSOrdenProceso.getValue(), this.xModeloPCausa.getRowCount() - 1, 1);
            if (this.xEstadoProceso == 1) {
                this.xModeloPCausa.setValueAt(true, this.xModeloPCausa.getRowCount() - 1, 2);
            } else {
                this.xModeloPCausa.setValueAt(false, this.xModeloPCausa.getRowCount() - 1, 2);
            }
            this.JTADescripcionProceso.setText("");
            this.JTADescripcionProceso.requestFocus();
            return;
        }
        JOptionPane.showMessageDialog(this, "Debe ingresar su descripción", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        this.JTADescripcionProceso.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTAddIntegranteActionPerformed(ActionEvent evt) {
        if (this.JCBProcesoIntegrantes.getSelectedIndex() != -1) {
            if (this.JCBPersonaIntegrante.getSelectedIndex() != -1 || !this.JTFNombre.getText().isEmpty()) {
                if (!this.JTFCargo.getText().isEmpty()) {
                    this.xFilaInteg++;
                    this.xModeloIntegrante.addRow(this.xDatoIntegrante);
                    if (this.xTipoPersona == 0) {
                        this.xModeloIntegrante.setValueAt("Interna", this.xModeloIntegrante.getRowCount() - 1, 0);
                        this.xModeloIntegrante.setValueAt(this.listComboResponble.get(this.JCBPersonaIntegrante.getSelectedIndex())[3].toString(), this.xModeloIntegrante.getRowCount() - 1, 5);
                        this.xModeloIntegrante.setValueAt(this.listComboResponble.get(this.JCBPersonaIntegrante.getSelectedIndex())[0].toString(), this.xModeloIntegrante.getRowCount() - 1, 7);
                    } else {
                        this.xModeloIntegrante.setValueAt("Externa", this.xModeloIntegrante.getRowCount() - 1, 0);
                        this.xModeloIntegrante.setValueAt(this.JTFCargo.getText().toUpperCase(), this.xModeloIntegrante.getRowCount() - 1, 5);
                        this.xModeloIntegrante.setValueAt(0, this.xModeloIntegrante.getRowCount() - 1, 7);
                    }
                    this.xModeloIntegrante.setValueAt(this.JTFNombre.getText().toUpperCase(), this.xModeloIntegrante.getRowCount() - 1, 2);
                    this.xModeloIntegrante.setValueAt(this.xIdTipoProcesoInte[this.JCBProcesoIntegrantes.getSelectedIndex()], this.xModeloIntegrante.getRowCount() - 1, 3);
                    this.xModeloIntegrante.setValueAt(this.JCBProcesoIntegrantes.getSelectedItem().toString().toUpperCase(), this.xModeloIntegrante.getRowCount() - 1, 4);
                    this.xModeloIntegrante.setValueAt(this.xmt.formatoAMD1.format(this.JDCHFechaIntegrantes.getDate()), this.xModeloIntegrante.getRowCount() - 1, 6);
                    this.JCBPersonaIntegrante.removeAllItems();
                    this.JCBProcesoIntegrantes.setSelectedIndex(-1);
                    this.JTFNombre.setText("");
                    this.JTFCargo.setText("");
                    this.JDCHFechaIntegrantes.setDate(this.xmt.getFechaActual());
                    return;
                }
                JOptionPane.showMessageDialog(this, "Debe ingresar un cargo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                this.JTFCargo.requestFocus();
                return;
            }
            if (this.JRBPersonaInterna.isSelected()) {
                JOptionPane.showMessageDialog(this, "Debe seleccionar un integrante", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                this.JCBPersonaIntegrante.requestFocus();
                return;
            } else {
                JOptionPane.showMessageDialog(this, "Debe Ingresar un integrante", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                this.JTFNombre.requestFocus();
                return;
            }
        }
        JOptionPane.showMessageDialog(this, "Debe seleccionar una proceso", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        this.JCBProcesoIntegrantes.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBProcesoIntegrantesItemStateChanged(ItemEvent evt) {
        if (this.xLleno1.booleanValue() && this.JRBPersonaInterna.isSelected() && this.JCBProcesoIntegrantes.getSelectedIndex() != -1) {
            this.JCBPersonaIntegrante.removeAllItems();
            mLLenaComboResponsable(this.JCBPersonaIntegrante);
        }
    }

    private String[] mLLenaComboResponsable(JComboBox xCombo) {
        xCombo.removeAllItems();
        this.listComboResponble = this.xSC_EventoAdversoGestionDAO.listComboRespon(this.xIdTipoProcesoInte[this.JCBProcesoIntegrantes.getSelectedIndex()]);
        String[] xDatos = new String[this.listComboResponble.size()];
        for (int x = 0; x < this.listComboResponble.size(); x++) {
            xDatos[x] = String.valueOf(this.listComboResponble.get(x)[0]);
            xCombo.addItem(this.listComboResponble.get(x)[1]);
        }
        xCombo.addPopupMenuListener(new CustomPopupMenuListener(true, false));
        if (this.listComboResponble.size() > 1) {
            xCombo.setSelectedIndex(-1);
        }
        return xDatos;
    }

    private String[] mLLenaComboUsuario(JComboBox xCombo) {
        xCombo.removeAllItems();
        this.listComboUsuario = this.xSC_EventoAdversoGestionDAO.listComboUsuario(this.xIdTipoProcesoAccion[this.JCBProcesoAccion.getSelectedIndex()]);
        String[] xDatos = new String[this.listComboUsuario.size()];
        for (int x = 0; x < this.listComboUsuario.size(); x++) {
            xDatos[x] = String.valueOf(this.listComboUsuario.get(x)[0]);
            xCombo.addItem(this.listComboUsuario.get(x)[1]);
        }
        xCombo.addPopupMenuListener(new CustomPopupMenuListener(true, false));
        if (this.listComboUsuario.size() > 1) {
            xCombo.setSelectedIndex(-1);
        }
        return xDatos;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTAddAccionActionPerformed(ActionEvent evt) {
        if (this.JCBOrigen.getSelectedIndex() != -1) {
            if (this.JCBProcesoAccion.getSelectedIndex() != -1) {
                if (this.JCBAccion.getSelectedIndex() != -1) {
                    if (this.JCBUsuario.getSelectedIndex() != -1) {
                        this.xFilaAccion++;
                        this.xModeloAccion.addRow(this.xDatoAccion);
                        this.xModeloAccion.setValueAt(this.xIdAccion[this.JCBAccion.getSelectedIndex()], this.xModeloAccion.getRowCount() - 1, 0);
                        this.xModeloAccion.setValueAt(this.JCBAccion.getSelectedItem().toString().toUpperCase(), this.xModeloAccion.getRowCount() - 1, 1);
                        this.xModeloAccion.setValueAt(this.JTFDetalleAccion.getText().toUpperCase(), this.xModeloAccion.getRowCount() - 1, 2);
                        this.xModeloAccion.setValueAt(this.xIdTipoProcesoAccion[this.JCBProcesoAccion.getSelectedIndex()], this.xModeloAccion.getRowCount() - 1, 3);
                        this.xModeloAccion.setValueAt(this.JCBProcesoAccion.getSelectedItem().toString().toUpperCase(), this.xModeloAccion.getRowCount() - 1, 4);
                        this.xModeloAccion.setValueAt(this.listComboUsuario.get(this.JCBUsuario.getSelectedIndex())[0], this.xModeloAccion.getRowCount() - 1, 5);
                        this.xModeloAccion.setValueAt(this.JCBUsuario.getSelectedItem().toString().toUpperCase(), this.xModeloAccion.getRowCount() - 1, 6);
                        this.xModeloAccion.setValueAt(this.xmt.formatoAMD1.format(this.JDCHFechaAccion.getDate()), this.xModeloAccion.getRowCount() - 1, 7);
                        this.xModeloAccion.setValueAt(0, this.xModeloAccion.getRowCount() - 1, 8);
                        System.out.println("index usuario --->  " + this.JCBUsuario.getSelectedIndex());
                        System.out.println("index usuario2 --->  " + this.listComboUsuario.get(this.JCBUsuario.getSelectedIndex())[2]);
                        System.out.println("item usuario ---> " + this.JCBUsuario.getSelectedItem());
                        if (this.xEstadoAccion == 1) {
                            this.xModeloAccion.setValueAt(true, this.xModeloAccion.getRowCount() - 1, 9);
                        } else {
                            this.xModeloAccion.setValueAt(false, this.xModeloAccion.getRowCount() - 1, 9);
                        }
                        this.xModeloAccion.setValueAt(this.xidOrigen[this.JCBOrigen.getSelectedIndex()], this.xModeloAccion.getRowCount() - 1, 10);
                        this.xModeloAccion.setValueAt(Boolean.valueOf(this.JCHAplicaFicha.isSelected()), this.xModeloAccion.getRowCount() - 1, 11);
                        this.JCBProcesoAccion.setSelectedIndex(-1);
                        this.JCBUsuario.setSelectedIndex(-1);
                        this.JCBAccion.setSelectedIndex(-1);
                        this.JCBOrigen.setSelectedIndex(-1);
                        this.JTFDetalleAccion.setText("");
                        this.JDCHFechaAccion.setDate(this.xmt.getFechaActual());
                        return;
                    }
                    JOptionPane.showMessageDialog(this, "Debe seleccionar un usuario", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    this.JCBUsuario.requestFocus();
                    return;
                }
                JOptionPane.showMessageDialog(this, "Debe seleccionar una acción", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                this.JCBAccion.requestFocus();
                return;
            }
            JOptionPane.showMessageDialog(this, "Debe seleccionar una proceso", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            this.JCBProcesoAccion.requestFocus();
            return;
        }
        JOptionPane.showMessageDialog(this, "Debe seleccionar un origen", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        this.JCBOrigen.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JFTFHoraEventoKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JFTFHoraEvento.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBPersonaIntegranteItemStateChanged(ItemEvent evt) {
        if (this.xLleno1.booleanValue() && this.JCBPersonaIntegrante.getSelectedIndex() != -1) {
            this.JTFNombre.setText(this.listComboResponble.get(this.JCBPersonaIntegrante.getSelectedIndex())[1].toString());
            this.JTFCargo.setText(this.listComboResponble.get(this.JCBPersonaIntegrante.getSelectedIndex())[3].toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBGuardarActionPerformed(ActionEvent evt) {
        mGuardarProceso();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleCausaKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 127 && this.JTDetalleCausa.getSelectedRow() != -1) {
            this.xModeloCausa.removeRow(this.JTDetalleCausa.getSelectedRow());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleProcesoKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 127 && this.JTDetalleProceso.getSelectedRow() != -1) {
            this.xModeloPCausa.removeRow(this.JTDetalleProceso.getSelectedRow());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleIntegrantesKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 127 && this.JTDetalleIntegrantes.getSelectedRow() != -1) {
            this.xModeloIntegrante.removeRow(this.JTDetalleIntegrantes.getSelectedRow());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleAccionKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 127 && this.JTDetalleAccion.getSelectedRow() != -1) {
            this.xModeloAccion.removeRow(this.JTDetalleAccion.getSelectedRow());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBEliminarActionPerformed(ActionEvent evt) {
        mAnular();
        mCargarDatos();
    }

    private void mLLenaCombo() {
        this.JCBCausa.removeAllItems();
        List<GCGenericoDTO> list1 = this.xSC_EventoAdversoGestionDAO.listComboCausa();
        this.xIdCausa = new String[list1.size()];
        for (int x = 0; x < list1.size(); x++) {
            this.xIdCausa[x] = String.valueOf(list1.get(x).getId());
            this.JCBCausa.addItem(list1.get(x).getNombre());
        }
        this.JCBCausa.addPopupMenuListener(new CustomPopupMenuListener(true, false));
        this.JCBCausa.setSelectedIndex(-1);
        this.xLleno1 = false;
        this.JCBProcesoIntegrantes.removeAllItems();
        List<GCGenericoDTO> list2 = this.xSC_EventoAdversoGestionDAO.listaTProceso(Principal.usuarioSistemaDTO.getIdUsuarioSistema().toString());
        this.xIdTipoProcesoInte = new String[list2.size()];
        for (int x2 = 0; x2 < list2.size(); x2++) {
            this.xIdTipoProcesoInte[x2] = String.valueOf(list2.get(x2).getId());
            this.JCBProcesoIntegrantes.addItem(list2.get(x2).getNombre());
        }
        this.JCBProcesoIntegrantes.addPopupMenuListener(new CustomPopupMenuListener(true, false));
        this.JCBProcesoIntegrantes.setSelectedIndex(-1);
        this.xLleno1 = true;
        this.xLleno = false;
        this.JCBProcesoAccion.removeAllItems();
        List<GCGenericoDTO> list3 = this.xSC_EventoAdversoGestionDAO.listaTProceso(Principal.usuarioSistemaDTO.getIdUsuarioSistema().toString());
        this.xIdTipoProcesoAccion = new String[list3.size()];
        for (int x3 = 0; x3 < list3.size(); x3++) {
            this.xIdTipoProcesoAccion[x3] = String.valueOf(list3.get(x3).getId());
            this.JCBProcesoAccion.addItem(list3.get(x3).getNombre());
        }
        this.JCBProcesoAccion.addPopupMenuListener(new CustomPopupMenuListener(true, false));
        this.JCBProcesoAccion.setSelectedIndex(-1);
        this.xLleno = true;
        this.JCBAccion.removeAllItems();
        List<GCGenericoDTO> list4 = this.xSC_EventoAdversoGestionDAO.listComboAccion();
        this.xIdAccion = new String[list4.size()];
        for (int x4 = 0; x4 < list4.size(); x4++) {
            this.xIdAccion[x4] = String.valueOf(list4.get(x4).getId());
            this.JCBAccion.addItem(list4.get(x4).getNombre());
        }
        this.JCBAccion.addPopupMenuListener(new CustomPopupMenuListener(true, false));
        this.JCBAccion.setSelectedIndex(-1);
        this.JCBOrigen.removeAllItems();
        List<GCGenericoDTO> listOrigen = this.xSGC_ActasDAO.listOrigen(1);
        this.xidOrigen = new String[listOrigen.size()];
        for (int x5 = 0; x5 < listOrigen.size(); x5++) {
            this.xidOrigen[x5] = String.valueOf(listOrigen.get(x5).getId());
            this.JCBOrigen.addItem(listOrigen.get(x5).getNombre());
        }
        this.JCBOrigen.addPopupMenuListener(new CustomPopupMenuListener(true, false));
        this.JCBOrigen.setSelectedIndex(-1);
    }

    private void mModeloDetalleCausa() {
        this.xModeloCausa = new DefaultTableModel((Object[][]) null, new String[]{"IdCausa", "Causa", "Descripción", "Orden", "Estado"}) { // from class: com.genoma.plus.controller.sgc.SC_JDEventoAdversoGestion.21
            Class[] types = {Long.class, String.class, Integer.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalleCausa.setModel(this.xModeloCausa);
        this.JTDetalleCausa.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTDetalleCausa.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTDetalleCausa.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTDetalleCausa.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDetalleCausa.getColumnModel().getColumn(2).setPreferredWidth(300);
        this.JTDetalleCausa.getColumnModel().getColumn(3).setPreferredWidth(30);
        this.JTDetalleCausa.getColumnModel().getColumn(4).setPreferredWidth(30);
        this.xFilaCausa = -1;
    }

    private void mModeloDetallePCausa() {
        this.xModeloPCausa = new DefaultTableModel((Object[][]) null, new String[]{"Descripción", "Orden", "Estado"}) { // from class: com.genoma.plus.controller.sgc.SC_JDEventoAdversoGestion.22
            Class[] types = {String.class, Integer.class, Boolean.class};
            boolean[] canEdit = {false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalleProceso.setModel(this.xModeloPCausa);
        this.JTDetalleProceso.getColumnModel().getColumn(0).setPreferredWidth(300);
        this.JTDetalleProceso.getColumnModel().getColumn(1).setPreferredWidth(50);
        this.JTDetalleProceso.getColumnModel().getColumn(1).setMinWidth(50);
        this.JTDetalleProceso.getColumnModel().getColumn(2).setPreferredWidth(50);
        this.JTDetalleProceso.getColumnModel().getColumn(2).setMinWidth(50);
        this.xFilaPCausa = -1;
    }

    private void mModeloDetalleIntegrante() {
        this.xModeloIntegrante = new DefaultTableModel((Object[][]) null, new String[]{"Tipo Pesrona", "Identificación", "Nombre", "idProceso", "Proceso", "Cargo", "Fecha Firma", "idPCargo"}) { // from class: com.genoma.plus.controller.sgc.SC_JDEventoAdversoGestion.23
            Class[] types = {String.class, Long.class, String.class, Long.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalleIntegrantes.setModel(this.xModeloIntegrante);
        this.JTDetalleIntegrantes.getColumnModel().getColumn(0).setPreferredWidth(30);
        this.JTDetalleIntegrantes.getColumnModel().getColumn(1).setPreferredWidth(0);
        this.JTDetalleIntegrantes.getColumnModel().getColumn(1).setMinWidth(0);
        this.JTDetalleIntegrantes.getColumnModel().getColumn(1).setMaxWidth(0);
        this.JTDetalleIntegrantes.getColumnModel().getColumn(2).setPreferredWidth(80);
        this.JTDetalleIntegrantes.getColumnModel().getColumn(3).setPreferredWidth(0);
        this.JTDetalleIntegrantes.getColumnModel().getColumn(3).setMinWidth(0);
        this.JTDetalleIntegrantes.getColumnModel().getColumn(3).setMaxWidth(0);
        this.JTDetalleIntegrantes.getColumnModel().getColumn(4).setPreferredWidth(80);
        this.JTDetalleIntegrantes.getColumnModel().getColumn(5).setPreferredWidth(50);
        this.JTDetalleIntegrantes.getColumnModel().getColumn(6).setPreferredWidth(30);
        this.JTDetalleIntegrantes.getColumnModel().getColumn(7).setPreferredWidth(0);
        this.JTDetalleIntegrantes.getColumnModel().getColumn(7).setMinWidth(0);
        this.JTDetalleIntegrantes.getColumnModel().getColumn(7).setMaxWidth(0);
        this.xFilaInteg = -1;
    }

    private void mModeloDetalleAccion() {
        this.xModeloAccion = new DefaultTableModel((Object[][]) null, new String[]{"idAccion", "Accion", "Detalle", "idProceso", "Proceso", "idPersona", "Persona", "FechaE", "Id_Ficha", "Estado", "idOrigen", "AplicaF"}) { // from class: com.genoma.plus.controller.sgc.SC_JDEventoAdversoGestion.24
            Class[] types = {Long.class, String.class, String.class, Long.class, String.class, Long.class, String.class, String.class, Long.class, Boolean.class, Long.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTDetalleAccion;
        JTable jTable2 = this.JTDetalleAccion;
        jTable.setAutoResizeMode(0);
        this.JTDetalleAccion.doLayout();
        this.JTDetalleAccion.setModel(this.xModeloAccion);
        this.JTDetalleAccion.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTDetalleAccion.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTDetalleAccion.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTDetalleAccion.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDetalleAccion.getColumnModel().getColumn(2).setPreferredWidth(300);
        this.JTDetalleAccion.getColumnModel().getColumn(3).setPreferredWidth(0);
        this.JTDetalleAccion.getColumnModel().getColumn(3).setMinWidth(0);
        this.JTDetalleAccion.getColumnModel().getColumn(3).setMaxWidth(0);
        this.JTDetalleAccion.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTDetalleAccion.getColumnModel().getColumn(5).setPreferredWidth(0);
        this.JTDetalleAccion.getColumnModel().getColumn(5).setMinWidth(0);
        this.JTDetalleAccion.getColumnModel().getColumn(5).setMaxWidth(0);
        this.JTDetalleAccion.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTDetalleAccion.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.JTDetalleAccion.getColumnModel().getColumn(8).setPreferredWidth(100);
        this.JTDetalleAccion.getColumnModel().getColumn(9).setPreferredWidth(100);
        this.JTDetalleAccion.getColumnModel().getColumn(10).setPreferredWidth(0);
        this.JTDetalleAccion.getColumnModel().getColumn(10).setMinWidth(0);
        this.JTDetalleAccion.getColumnModel().getColumn(10).setMaxWidth(0);
        this.JTDetalleAccion.getColumnModel().getColumn(11).setPreferredWidth(80);
        this.xFilaAccion = -1;
    }

    public void mGuardarProceso() {
        if (!this.JTFObservacionGeneral.getText().isEmpty()) {
            if (this.JTDetalleCausa.getRowCount() != 0) {
                if (this.JTDetalleProceso.getRowCount() != 0) {
                    if (this.JTDetalleIntegrantes.getRowCount() != 0) {
                        SGC_Analisis_EventoAdversoDTO xObjEncabezado = new SGC_Analisis_EventoAdversoDTO();
                        int n = JOptionPane.showConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                        if (n == 0) {
                            xObjEncabezado.setXId_Evento(Integer.valueOf(this.JTFCodEvento.getText()).intValue());
                            xObjEncabezado.setXFechaA(this.xmt.formatoAMD.format(this.JDCHFecha.getDate()));
                            xObjEncabezado.setXObservacionG(this.JTFObservacionGeneral.getText());
                            xObjEncabezado.setXEstado(1);
                            xObjEncabezado.setXId_Anulado(1);
                            String xIdAnalisisEncabezado = this.xSC_EventoAdversoGestionDAO.create_return_id(xObjEncabezado);
                            this.JLBIdAnalisisEvent.setText(xIdAnalisisEncabezado);
                            SGC_AnalisisCausaDTO xObjCausa = new SGC_AnalisisCausaDTO();
                            for (int x = 0; x < this.JTDetalleCausa.getRowCount(); x++) {
                                xObjCausa.setXId_EventoA(Integer.parseInt(xIdAnalisisEncabezado));
                                xObjCausa.setXId_CausaA(this.xModeloCausa.getValueAt(x, 0).toString());
                                xObjCausa.setXDescripcion(this.xModeloCausa.getValueAt(x, 2).toString());
                                xObjCausa.setXNOrden(Integer.valueOf(this.xModeloCausa.getValueAt(x, 3).toString()).intValue());
                                if (((Boolean) this.xModeloCausa.getValueAt(x, 4)).booleanValue()) {
                                    xObjCausa.setXEstado(1);
                                } else {
                                    xObjCausa.setXEstado(0);
                                }
                                this.xSC_EventoAdversoGestionDAO.create_causa(xObjCausa);
                            }
                            SGC_AnalisisPCausaDTO xObjPCausa = new SGC_AnalisisPCausaDTO();
                            for (int x2 = 0; x2 < this.JTDetalleProceso.getRowCount(); x2++) {
                                xObjPCausa.setXIdEvenACausaP(Integer.parseInt(xIdAnalisisEncabezado));
                                xObjPCausa.setXDescripACausaP(this.xModeloPCausa.getValueAt(x2, 0).toString());
                                xObjPCausa.setXNOrdenACausaP(Integer.valueOf(this.xModeloPCausa.getValueAt(x2, 1).toString()).intValue());
                                if (((Boolean) this.xModeloPCausa.getValueAt(x2, 2)).booleanValue()) {
                                    xObjPCausa.setXEstadoACausaP(1);
                                } else {
                                    xObjPCausa.setXEstadoACausaP(0);
                                }
                                this.xSC_EventoAdversoGestionDAO.mCreatePCausa(xObjPCausa);
                            }
                            SGC_AnalisisIntegranteDTO xObjIntegrante = new SGC_AnalisisIntegranteDTO();
                            for (int x3 = 0; x3 < this.JTDetalleIntegrantes.getRowCount(); x3++) {
                                xObjIntegrante.setXId_Analisis(Integer.parseInt(xIdAnalisisEncabezado));
                                if ("Interna".equals(this.xModeloIntegrante.getValueAt(x3, 0).toString())) {
                                    xObjIntegrante.setXId_PersonaC(Integer.valueOf(this.xModeloIntegrante.getValueAt(x3, 7).toString()).intValue());
                                    xObjIntegrante.setXTipo(0);
                                } else {
                                    xObjIntegrante.setXId_PersonaC(0);
                                    xObjIntegrante.setXTipo(1);
                                }
                                xObjIntegrante.setXId_TipoProceso(this.xModeloIntegrante.getValueAt(x3, 3).toString());
                                xObjIntegrante.setXPE_Nombre(this.xModeloIntegrante.getValueAt(x3, 2).toString());
                                xObjIntegrante.setXPE_Cargo(this.xModeloIntegrante.getValueAt(x3, 5).toString());
                                xObjIntegrante.setXFechaFirma(this.xModeloIntegrante.getValueAt(x3, 6).toString());
                                this.xSC_EventoAdversoGestionDAO.mCreateIntegrante(xObjIntegrante);
                            }
                            if (this.JCHAplicaFicha.isSelected()) {
                                SGC_Ficha5w1hDTO xficha = new SGC_Ficha5w1hDTO();
                                for (int x4 = 0; x4 < this.JTDetalleAccion.getRowCount(); x4++) {
                                    xficha.setFechaRF(this.xmt.formatoAMD.format(this.xmt.getFechaActual()));
                                    xficha.setIdTipoAccion(this.xModeloAccion.getValueAt(x4, 0).toString());
                                    xficha.setIdOrigen(this.xModeloAccion.getValueAt(x4, 10).toString());
                                    xficha.setIdTipoProceso(this.xModeloAccion.getValueAt(x4, 3).toString());
                                    xficha.setIdRhPersonaR(this.xModeloAccion.getValueAt(x4, 5).toString());
                                    xficha.setIdRhPersonaRP(String.valueOf(Principal.usuarioSistemaDTO.getIdPersonaCargo()));
                                    xficha.setQue(this.xModeloAccion.getValueAt(x4, 2).toString());
                                    xficha.setCuando(this.xModeloAccion.getValueAt(x4, 7).toString());
                                    String xidFicha = this.xSGC_ActasDAO.create_return_idFicha(xficha);
                                    this.xModeloAccion.setValueAt(xidFicha, x4, 8);
                                }
                            }
                            SGC_AnalisisAccionDTO xObjAccion = new SGC_AnalisisAccionDTO();
                            for (int x5 = 0; x5 < this.JTDetalleAccion.getRowCount(); x5++) {
                                xObjAccion.setXId_EventoA(Integer.parseInt(xIdAnalisisEncabezado));
                                xObjAccion.setXId_TipoAccion(this.xModeloAccion.getValueAt(x5, 0).toString());
                                xObjAccion.setXDetalle(this.xModeloAccion.getValueAt(x5, 2).toString());
                                xObjAccion.setXId_TipoProceso(this.xModeloAccion.getValueAt(x5, 3).toString());
                                xObjAccion.setXId_RhPersonaC(this.xModeloAccion.getValueAt(x5, 5).toString());
                                xObjAccion.setXFechaE(this.xModeloAccion.getValueAt(x5, 7).toString());
                                xObjAccion.setXId_Ficha(Integer.valueOf(this.xModeloAccion.getValueAt(x5, 8).toString()).intValue());
                                if (((Boolean) this.xModeloAccion.getValueAt(x5, 9)).booleanValue()) {
                                    xObjAccion.setXEstado(1);
                                } else {
                                    xObjAccion.setXEstado(0);
                                }
                                this.xSC_EventoAdversoGestionDAO.mCreateAccion(xObjAccion);
                            }
                            return;
                        }
                        return;
                    }
                    JOptionPane.showMessageDialog(this, "Debe agregar un registro en la tabla integrantes", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    this.JTPDetalle2.setSelectedIndex(2);
                    return;
                }
                JOptionPane.showMessageDialog(this, "Debe agregar un registro en la tabla proceso causa", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                this.JTPDetalle2.setSelectedIndex(1);
                return;
            }
            JOptionPane.showMessageDialog(this, "Debe agregar un registro en la tabla causa", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            this.JTPDetalle2.setSelectedIndex(0);
            return;
        }
        JOptionPane.showMessageDialog(this, "Debe digitar una observación", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        this.JTFObservacionGeneral.requestFocus();
    }

    private void mCargarDatos() {
        List<SGC_Analisis_EventoAdversoDTO> list = this.xSC_EventoAdversoGestionDAO.listAnalisis(this.JTFCodEvento.getText());
        if (list.size() != 0) {
            this.JLBIdAnalisisEvent.setText(String.valueOf(list.get(0).getXId()));
            this.JDCHFecha.setDate(Date.valueOf(list.get(0).getXFechaA()));
            this.JTFObservacionGeneral.setText(list.get(0).getXObservacionG());
            mModeloDetalleCausa();
            List<SGC_AnalisisCausaDTO> listCausa = this.xSC_EventoAdversoGestionDAO.listCausa(this.JLBIdAnalisisEvent.getText());
            for (int x = 0; x < listCausa.size(); x++) {
                this.xModeloCausa.addRow(this.xDatoCausa);
                this.xModeloCausa.setValueAt(listCausa.get(x).getXId_CausaA(), x, 1);
                this.xModeloCausa.setValueAt(listCausa.get(x).getXDescripcion(), x, 2);
                this.xModeloCausa.setValueAt(Integer.valueOf(listCausa.get(x).getXNOrden()), x, 3);
                if (listCausa.get(x).getXEstado() == 1) {
                    this.xModeloCausa.setValueAt(true, x, 4);
                } else {
                    this.xModeloCausa.setValueAt(false, x, 5);
                }
            }
            mModeloDetallePCausa();
            List<SGC_AnalisisPCausaDTO> listPCausa = this.xSC_EventoAdversoGestionDAO.listPCausa(this.JLBIdAnalisisEvent.getText());
            for (int x2 = 0; x2 < listPCausa.size(); x2++) {
                this.xModeloPCausa.addRow(this.xDatoCausa);
                this.xModeloPCausa.setValueAt(listPCausa.get(x2).getXDescripACausaP(), x2, 0);
                this.xModeloPCausa.setValueAt(Integer.valueOf(listPCausa.get(x2).getXNOrdenACausaP()), x2, 1);
                if (listPCausa.get(x2).getXEstadoACausaP() == 1) {
                    this.xModeloPCausa.setValueAt(true, x2, 2);
                } else {
                    this.xModeloPCausa.setValueAt(false, x2, 2);
                }
            }
            mModeloDetalleIntegrante();
            List<SGC_AnalisisIntegranteDTO> listIntegrante = this.xSC_EventoAdversoGestionDAO.listIntegrante(this.JLBIdAnalisisEvent.getText());
            for (int x3 = 0; x3 < listIntegrante.size(); x3++) {
                this.xModeloIntegrante.addRow(this.xDatoIntegrante);
                if (listIntegrante.get(x3).getXTipo() == 0) {
                    this.xModeloIntegrante.setValueAt("Interna", x3, 0);
                } else {
                    this.xModeloIntegrante.setValueAt("Externa", x3, 0);
                }
                this.xModeloIntegrante.setValueAt(listIntegrante.get(x3).getXPE_Nombre(), x3, 2);
                this.xModeloIntegrante.setValueAt(listIntegrante.get(x3).getXId_TipoProceso(), x3, 4);
                this.xModeloIntegrante.setValueAt(listIntegrante.get(x3).getXPE_Cargo(), x3, 5);
                this.xModeloIntegrante.setValueAt(listIntegrante.get(x3).getXFechaFirma(), x3, 6);
            }
            mModeloDetalleAccion();
            List<SGC_AnalisisAccionDTO> listAccion = this.xSC_EventoAdversoGestionDAO.listAccion(this.JLBIdAnalisisEvent.getText());
            for (int x4 = 0; x4 < listAccion.size(); x4++) {
                this.xModeloAccion.addRow(this.xDatoAccion);
                this.xModeloAccion.setValueAt(listAccion.get(x4).getXId_TipoAccion(), x4, 1);
                this.xModeloAccion.setValueAt(listAccion.get(x4).getXDetalle(), x4, 2);
                this.xModeloAccion.setValueAt(listAccion.get(x4).getXId_TipoProceso(), x4, 4);
                this.xModeloAccion.setValueAt(listAccion.get(x4).getXId_RhPersonaC(), x4, 6);
                this.xModeloAccion.setValueAt(listAccion.get(x4).getXFechaE(), x4, 7);
                this.xModeloAccion.setValueAt(Integer.valueOf(listAccion.get(x4).getXId_Ficha()), x4, 8);
                if (listAccion.get(x4).getXEstado() == 1) {
                    this.xModeloAccion.setValueAt(true, x4, 9);
                } else {
                    this.xModeloAccion.setValueAt(false, x4, 9);
                }
            }
            this.JBTAddCausa.setEnabled(false);
            this.JBTAddProceso.setEnabled(false);
            this.JBTAddIntegrante.setEnabled(false);
            this.JBTAddAccion.setEnabled(false);
            this.JBGuardar.setEnabled(false);
        } else {
            this.JBTAddCausa.setEnabled(true);
            this.JBTAddProceso.setEnabled(true);
            this.JBTAddIntegrante.setEnabled(true);
            this.JBTAddAccion.setEnabled(true);
            this.JBGuardar.setEnabled(true);
            this.JTFObservacionGeneral.setText((String) null);
            this.JLBIdAnalisisEvent.setText((String) null);
            mInciaComponentes();
        }
        this.JDCHFechaAccion.setDate(this.xmt.getFechaActual());
        this.JDCHFechaIntegrantes.setDate(this.xmt.getFechaActual());
        this.JDCHFecha.setDate(this.xmt.getFechaActual());
    }

    public void mAnular() {
        if (!this.JLBIdAnalisisEvent.getText().isEmpty()) {
            int x = JOptionPane.showConfirmDialog(this, "Esta seguro de anular?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                Anular frm = new Anular(null, true, "GESTIÓN EVENTO", 100);
                frm.setVisible(true);
                return;
            }
            return;
        }
        JOptionPane.showMessageDialog(this, "No hay analisis activo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
    }

    public void mAnular(String xid, String xdetalle) {
        SGC_Analisis_EventoAdversoDTO xObjEncabezado = new SGC_Analisis_EventoAdversoDTO();
        xObjEncabezado.setXId_Anulado(Integer.valueOf(xid).intValue());
        xObjEncabezado.setXMotivoAnulacion(xdetalle);
        xObjEncabezado.setXFechaAnulacion(this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()));
        xObjEncabezado.setXEstado(0);
        xObjEncabezado.setXId(Integer.valueOf(this.JLBIdAnalisisEvent.getText()).intValue());
        xObjEncabezado.setXId_Evento(Integer.valueOf(this.JTFCodEvento.getText()).intValue());
        this.xSC_EventoAdversoGestionDAO.mDeleteGeneral(xObjEncabezado);
    }
}
