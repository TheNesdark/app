package Sgc;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Sgc/JIFGestionSolicitudes.class */
public class JIFGestionSolicitudes extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private DefaultTableModel xmodelod;
    private DefaultTableModel xmodeloc;
    private DefaultTableModel xmodelosg;
    private DefaultTableModel xmodeloe;
    private Object[] xdatos;
    private String[][] xidpersonar;
    private String xsql;
    private int xtipoforma;
    private boolean xfllenar;
    private ButtonGroup JBGSeleccion;
    private JButton JBTAdicionar;
    private JButton JBTGrabarS;
    private JComboBox JCBPersonaAsignada;
    private JCheckBox JCHAprobado;
    private JCheckBox JCHAutorizada;
    private JCheckBox JCHCerrada;
    private JCheckBox JCHCerrar;
    private JCheckBox JCHCorreo;
    private JCheckBox JCHTareas;
    private JDateChooser JDFFechaEnc;
    private JDateChooser JDFFechaPE;
    private JDateChooser JDFFechaSg;
    private JDateChooser JDFechaF;
    private JDateChooser JDFechaI;
    private JPanel JPIAprobacion;
    private JPanel JPIAutorizacion;
    private JPanel JPIDConvenciones;
    private JPanel JPIDatos;
    private JPanel JPIDatosEncu;
    private JPanel JPIDatosSegu;
    private JPanel JPIDetalle;
    private JPanel JPIEncuesta;
    private JPanel JPIEvaluacion;
    private JPanel JPISeguimiento;
    private JPanel JPITipoAutor;
    private JRadioButton JRBNo;
    private JRadioButton JRBSi;
    private JScrollPane JSPDescripcionS;
    private JScrollPane JSPDetalle;
    private JScrollPane JSPDetalleC;
    private JScrollPane JSPDetalleEnc;
    private JScrollPane JSPDetalleS;
    private JScrollPane JSPDetalleSg;
    private JScrollPane JSPObservacion;
    private JScrollPane JSPObservacionAP;
    private JScrollPane JSPObservacionG;
    private JTextPane JTADescripcionS;
    private JTextPane JTAObservacion;
    private JTextPane JTAObservacionAP;
    private JTextPane JTAObservacionGEnc;
    private JTable JTDetalle;
    private JTable JTDetalleC;
    private JTable JTDetalleEnc;
    private JTable JTDetalleS;
    private JTable JTDetalleSg;
    private JTabbedPane JTPDetalle;
    private JCheckBox jCheckBox1;
    private JCheckBox jCheckBox2;
    private JCheckBox jCheckBox3;
    private JCheckBox jCheckBox4;
    private ConsultasMySQL xct = new ConsultasMySQL();
    private Metodos xmt = new Metodos();
    private int xautorizado = 1;
    private int xaprobada = 0;
    private int xtipoconsulta = 0;
    private int xcerrarda = 0;
    private int xidpersona = 0;
    private boolean xestadoeva = false;
    private boolean xlleno = false;

    public JIFGestionSolicitudes(int xtipoforma, String xnombre, boolean xllenar) {
        this.xfllenar = false;
        initComponents();
        setName(xnombre);
        this.xtipoforma = xtipoforma;
        this.xfllenar = xllenar;
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v176, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v209, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v40, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v88, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v95, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGSeleccion = new ButtonGroup();
        this.JPIDatos = new JPanel();
        this.JDFechaI = new JDateChooser();
        this.JDFechaF = new JDateChooser();
        this.JCHAutorizada = new JCheckBox();
        this.JCHCerrada = new JCheckBox();
        this.JCHTareas = new JCheckBox();
        this.JTPDetalle = new JTabbedPane();
        this.JPIDetalle = new JPanel();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JPIAutorizacion = new JPanel();
        this.JPITipoAutor = new JPanel();
        this.JRBSi = new JRadioButton();
        this.JRBNo = new JRadioButton();
        this.JSPObservacion = new JScrollPane();
        this.JTAObservacion = new JTextPane();
        this.JPIEvaluacion = new JPanel();
        this.JSPDetalleS = new JScrollPane();
        this.JTDetalleS = new JTable();
        this.JSPDetalleC = new JScrollPane();
        this.JTDetalleC = new JTable();
        this.JBTAdicionar = new JButton();
        this.JPIAprobacion = new JPanel();
        this.JCHAprobado = new JCheckBox();
        this.JDFFechaPE = new JDateChooser();
        this.JSPObservacionAP = new JScrollPane();
        this.JTAObservacionAP = new JTextPane();
        this.JCBPersonaAsignada = new JComboBox();
        this.JPISeguimiento = new JPanel();
        this.JPIDatosSegu = new JPanel();
        this.JDFFechaSg = new JDateChooser();
        this.JSPDescripcionS = new JScrollPane();
        this.JTADescripcionS = new JTextPane();
        this.JCHCorreo = new JCheckBox();
        this.JCHCerrar = new JCheckBox();
        this.JBTGrabarS = new JButton();
        this.JSPDetalleSg = new JScrollPane();
        this.JTDetalleSg = new JTable();
        this.JPIEncuesta = new JPanel();
        this.JPIDatosEncu = new JPanel();
        this.JDFFechaEnc = new JDateChooser();
        this.JSPObservacionG = new JScrollPane();
        this.JTAObservacionGEnc = new JTextPane();
        this.JSPDetalleEnc = new JScrollPane();
        this.JTDetalleEnc = new JTable();
        this.JPIDConvenciones = new JPanel();
        this.jCheckBox1 = new JCheckBox();
        this.jCheckBox2 = new JCheckBox();
        this.jCheckBox3 = new JCheckBox();
        this.jCheckBox4 = new JCheckBox();
        setClosable(true);
        setIconifiable(true);
        setTitle("GESTIÓN DE SOLICITUDES");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMaximumSize(null);
        setName("jifgestionsolicitudes");
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        addInternalFrameListener(new InternalFrameListener() { // from class: Sgc.JIFGestionSolicitudes.1
            public void internalFrameActivated(InternalFrameEvent evt) {
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIFGestionSolicitudes.this.formInternalFrameClosing(evt);
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
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN PARA CONSULTA", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JDFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicial", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Final", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFechaF.setFont(new Font("Arial", 1, 12));
        this.JCHAutorizada.setFont(new Font("Arial", 1, 12));
        this.JCHAutorizada.setForeground(Color.blue);
        this.JCHAutorizada.setText("Autorizadas");
        this.JCHAutorizada.addActionListener(new ActionListener() { // from class: Sgc.JIFGestionSolicitudes.2
            public void actionPerformed(ActionEvent evt) {
                JIFGestionSolicitudes.this.JCHAutorizadaActionPerformed(evt);
            }
        });
        this.JCHCerrada.setFont(new Font("Arial", 1, 12));
        this.JCHCerrada.setForeground(Color.blue);
        this.JCHCerrada.setText("Cerradas?");
        this.JCHCerrada.addActionListener(new ActionListener() { // from class: Sgc.JIFGestionSolicitudes.3
            public void actionPerformed(ActionEvent evt) {
                JIFGestionSolicitudes.this.JCHCerradaActionPerformed(evt);
            }
        });
        this.JCHTareas.setFont(new Font("Arial", 1, 12));
        this.JCHTareas.setForeground(Color.blue);
        this.JCHTareas.setText("Tareas?");
        this.JCHTareas.addActionListener(new ActionListener() { // from class: Sgc.JIFGestionSolicitudes.4
            public void actionPerformed(ActionEvent evt) {
                JIFGestionSolicitudes.this.JCHTareasActionPerformed(evt);
            }
        });
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addComponent(this.JDFechaI, -2, 120, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JDFechaF, -2, 120, -2).addGap(32, 32, 32).addComponent(this.JCHAutorizada).addGap(18, 18, 18).addComponent(this.JCHCerrada).addGap(18, 18, 18).addComponent(this.JCHTareas).addContainerGap(-1, 32767)));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JDFechaI, -1, -1, 32767).addComponent(this.JDFechaF, -2, 45, -2)).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCHAutorizada).addComponent(this.JCHCerrada).addComponent(this.JCHTareas))).addContainerGap(-1, 32767)));
        this.JTPDetalle.setForeground(new Color(0, 103, 0));
        this.JTPDetalle.setFont(new Font("Arial", 1, 14));
        this.JSPDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalle.setSelectionMode(0);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: Sgc.JIFGestionSolicitudes.5
            public void mouseClicked(MouseEvent evt) {
                JIFGestionSolicitudes.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JPIAutorizacion.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN DE AUTORIZACIÓN", 0, 0, new Font("Arial", 1, 14), Color.red));
        this.JPITipoAutor.setBorder(BorderFactory.createTitledBorder((Border) null, "Autorizado", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBGSeleccion.add(this.JRBSi);
        this.JRBSi.setFont(new Font("Arial", 1, 12));
        this.JRBSi.setSelected(true);
        this.JRBSi.setText("Si");
        this.JRBSi.addActionListener(new ActionListener() { // from class: Sgc.JIFGestionSolicitudes.6
            public void actionPerformed(ActionEvent evt) {
                JIFGestionSolicitudes.this.JRBSiActionPerformed(evt);
            }
        });
        this.JBGSeleccion.add(this.JRBNo);
        this.JRBNo.setFont(new Font("Arial", 1, 12));
        this.JRBNo.setText("No");
        this.JRBNo.addActionListener(new ActionListener() { // from class: Sgc.JIFGestionSolicitudes.7
            public void actionPerformed(ActionEvent evt) {
                JIFGestionSolicitudes.this.JRBNoActionPerformed(evt);
            }
        });
        GroupLayout JPITipoAutorLayout = new GroupLayout(this.JPITipoAutor);
        this.JPITipoAutor.setLayout(JPITipoAutorLayout);
        JPITipoAutorLayout.setHorizontalGroup(JPITipoAutorLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPITipoAutorLayout.createSequentialGroup().addContainerGap().addComponent(this.JRBSi).addGap(18, 18, 18).addComponent(this.JRBNo).addContainerGap(-1, 32767)));
        JPITipoAutorLayout.setVerticalGroup(JPITipoAutorLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPITipoAutorLayout.createSequentialGroup().addContainerGap(11, 32767).addGroup(JPITipoAutorLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBSi).addComponent(this.JRBNo)).addContainerGap()));
        this.JSPObservacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTAObservacion.setFont(new Font("Arial", 1, 12));
        this.JSPObservacion.setViewportView(this.JTAObservacion);
        GroupLayout JPIAutorizacionLayout = new GroupLayout(this.JPIAutorizacion);
        this.JPIAutorizacion.setLayout(JPIAutorizacionLayout);
        JPIAutorizacionLayout.setHorizontalGroup(JPIAutorizacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIAutorizacionLayout.createSequentialGroup().addContainerGap().addComponent(this.JPITipoAutor, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPObservacion, -1, 729, 32767).addContainerGap()));
        JPIAutorizacionLayout.setVerticalGroup(JPIAutorizacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIAutorizacionLayout.createSequentialGroup().addGroup(JPIAutorizacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIAutorizacionLayout.createSequentialGroup().addGap(11, 11, 11).addComponent(this.JSPObservacion, -1, 61, 32767)).addComponent(this.JPITipoAutor, -1, -1, 32767)).addContainerGap()));
        GroupLayout JPIDetalleLayout = new GroupLayout(this.JPIDetalle);
        this.JPIDetalle.setLayout(JPIDetalleLayout);
        JPIDetalleLayout.setHorizontalGroup(JPIDetalleLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDetalleLayout.createSequentialGroup().addContainerGap().addGroup(JPIDetalleLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSPDetalle, GroupLayout.Alignment.LEADING, -1, 891, 32767).addComponent(this.JPIAutorizacion, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addContainerGap()));
        JPIDetalleLayout.setVerticalGroup(JPIDetalleLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDetalleLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPDetalle, -1, 269, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPIAutorizacion, -2, -1, -2).addContainerGap()));
        this.JTPDetalle.addTab("HISTÓRICO", this.JPIDetalle);
        this.JSPDetalleS.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE DE SOLICITUD", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JSPDetalleS.setFont(new Font("Arial", 1, 12));
        this.JTDetalleS.setFont(new Font("Arial", 1, 12));
        this.JTDetalleS.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalleS.setRowHeight(25);
        this.JTDetalleS.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalleS.setSelectionForeground(Color.red);
        this.JTDetalleS.setSelectionMode(0);
        this.JTDetalleS.addMouseListener(new MouseAdapter() { // from class: Sgc.JIFGestionSolicitudes.8
            public void mouseClicked(MouseEvent evt) {
                JIFGestionSolicitudes.this.JTDetalleSMouseClicked(evt);
            }
        });
        this.JSPDetalleS.setViewportView(this.JTDetalleS);
        this.JSPDetalleC.setBorder(BorderFactory.createTitledBorder((Border) null, "CRITERIOS DE EVALUACIÓN", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPDetalleC.setFont(new Font("Arial", 1, 12));
        this.JTDetalleC.setFont(new Font("Arial", 1, 11));
        this.JTDetalleC.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalleC.setRowHeight(25);
        this.JTDetalleC.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalleC.setSelectionForeground(Color.red);
        this.JTDetalleC.setSelectionMode(0);
        this.JTDetalleC.addMouseListener(new MouseAdapter() { // from class: Sgc.JIFGestionSolicitudes.9
            public void mouseClicked(MouseEvent evt) {
                JIFGestionSolicitudes.this.JTDetalleCMouseClicked(evt);
            }
        });
        this.JSPDetalleC.setViewportView(this.JTDetalleC);
        this.JBTAdicionar.setFont(new Font("Arial", 1, 12));
        this.JBTAdicionar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTAdicionar.setText("<html><P ALIGN=center>Grabar Evaluación");
        this.JBTAdicionar.addActionListener(new ActionListener() { // from class: Sgc.JIFGestionSolicitudes.10
            public void actionPerformed(ActionEvent evt) {
                JIFGestionSolicitudes.this.JBTAdicionarActionPerformed(evt);
            }
        });
        this.JPIAprobacion.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS DE APROBACIÓN", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JCHAprobado.setFont(new Font("Arial", 1, 12));
        this.JCHAprobado.setForeground(Color.blue);
        this.JCHAprobado.setSelected(true);
        this.JCHAprobado.setText("Aprobado?");
        this.JCHAprobado.addActionListener(new ActionListener() { // from class: Sgc.JIFGestionSolicitudes.11
            public void actionPerformed(ActionEvent evt) {
                JIFGestionSolicitudes.this.JCHAprobadoActionPerformed(evt);
            }
        });
        this.JDFFechaPE.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha P/Ejecución", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaPE.setDateFormatString("dd/MM/yyyy");
        this.JDFFechaPE.setFont(new Font("Arial", 1, 12));
        this.JSPObservacionAP.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTAObservacionAP.setFont(new Font("Arial", 1, 12));
        this.JSPObservacionAP.setViewportView(this.JTAObservacionAP);
        this.JCBPersonaAsignada.setFont(new Font("Arial", 1, 12));
        this.JCBPersonaAsignada.setBorder(BorderFactory.createTitledBorder((Border) null, "Persona Asignada", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBPersonaAsignada.addItemListener(new ItemListener() { // from class: Sgc.JIFGestionSolicitudes.12
            public void itemStateChanged(ItemEvent evt) {
                JIFGestionSolicitudes.this.JCBPersonaAsignadaItemStateChanged(evt);
            }
        });
        GroupLayout JPIAprobacionLayout = new GroupLayout(this.JPIAprobacion);
        this.JPIAprobacion.setLayout(JPIAprobacionLayout);
        JPIAprobacionLayout.setHorizontalGroup(JPIAprobacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIAprobacionLayout.createSequentialGroup().addContainerGap().addComponent(this.JCHAprobado).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JDFFechaPE, -2, 121, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPObservacionAP, -2, 264, -2).addGap(10, 10, 10).addComponent(this.JCBPersonaAsignada, 0, 245, 32767).addContainerGap()));
        JPIAprobacionLayout.setVerticalGroup(JPIAprobacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIAprobacionLayout.createSequentialGroup().addGroup(JPIAprobacionLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPIAprobacionLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPObservacionAP, -1, 52, 32767)).addGroup(GroupLayout.Alignment.LEADING, JPIAprobacionLayout.createSequentialGroup().addGap(11, 11, 11).addGroup(JPIAprobacionLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JCHAprobado).addComponent(this.JCBPersonaAsignada, -2, -1, -2).addComponent(this.JDFFechaPE, -2, -1, -2)))).addContainerGap()));
        GroupLayout JPIEvaluacionLayout = new GroupLayout(this.JPIEvaluacion);
        this.JPIEvaluacion.setLayout(JPIEvaluacionLayout);
        JPIEvaluacionLayout.setHorizontalGroup(JPIEvaluacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIEvaluacionLayout.createSequentialGroup().addContainerGap().addGroup(JPIEvaluacionLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSPDetalleC, GroupLayout.Alignment.LEADING, -1, 891, 32767).addComponent(this.JSPDetalleS, GroupLayout.Alignment.LEADING, -1, 891, 32767).addGroup(GroupLayout.Alignment.LEADING, JPIEvaluacionLayout.createSequentialGroup().addComponent(this.JPIAprobacion, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTAdicionar, -2, 110, 32767))).addContainerGap()));
        JPIEvaluacionLayout.setVerticalGroup(JPIEvaluacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIEvaluacionLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPDetalleS, -1, 101, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalleC, -2, 168, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIEvaluacionLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JPIAprobacion, -2, -1, -2).addComponent(this.JBTAdicionar, -2, 94, -2)).addContainerGap()));
        this.JTPDetalle.addTab("EVALUACIÓN", this.JPIEvaluacion);
        this.JPIDatosSegu.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JDFFechaSg.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaSg.setDateFormatString("dd/MM/yyyy");
        this.JDFFechaSg.setFont(new Font("Arial", 1, 12));
        this.JSPDescripcionS.setBorder(BorderFactory.createTitledBorder((Border) null, "Descripción", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTADescripcionS.setFont(new Font("Arial", 1, 12));
        this.JSPDescripcionS.setViewportView(this.JTADescripcionS);
        this.JCHCorreo.setFont(new Font("Arial", 1, 12));
        this.JCHCorreo.setForeground(Color.blue);
        this.JCHCorreo.setSelected(true);
        this.JCHCorreo.setText("Correo?");
        this.JCHCerrar.setFont(new Font("Arial", 1, 12));
        this.JCHCerrar.setForeground(Color.blue);
        this.JCHCerrar.setText("Cerrar?");
        this.JCHCerrar.addActionListener(new ActionListener() { // from class: Sgc.JIFGestionSolicitudes.13
            public void actionPerformed(ActionEvent evt) {
                JIFGestionSolicitudes.this.JCHCerrarActionPerformed(evt);
            }
        });
        this.JBTGrabarS.setFont(new Font("Arial", 1, 12));
        this.JBTGrabarS.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTGrabarS.setText("Grabar");
        this.JBTGrabarS.setEnabled(false);
        this.JBTGrabarS.addActionListener(new ActionListener() { // from class: Sgc.JIFGestionSolicitudes.14
            public void actionPerformed(ActionEvent evt) {
                JIFGestionSolicitudes.this.JBTGrabarSActionPerformed(evt);
            }
        });
        GroupLayout JPIDatosSeguLayout = new GroupLayout(this.JPIDatosSegu);
        this.JPIDatosSegu.setLayout(JPIDatosSeguLayout);
        JPIDatosSeguLayout.setHorizontalGroup(JPIDatosSeguLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosSeguLayout.createSequentialGroup().addContainerGap().addComponent(this.JDFFechaSg, -2, 121, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPDescripcionS, -2, 554, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIDatosSeguLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPIDatosSeguLayout.createSequentialGroup().addComponent(this.JCHCerrar).addGap(6, 6, 6)).addGroup(JPIDatosSeguLayout.createSequentialGroup().addComponent(this.JCHCorreo, -2, 73, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED))).addComponent(this.JBTGrabarS)));
        JPIDatosSeguLayout.setVerticalGroup(JPIDatosSeguLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosSeguLayout.createSequentialGroup().addGroup(JPIDatosSeguLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JDFFechaSg, -2, -1, -2).addComponent(this.JSPDescripcionS, -1, 54, 32767).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosSeguLayout.createSequentialGroup().addContainerGap().addComponent(this.JCHCorreo).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 1, 32767).addComponent(this.JCHCerrar)).addComponent(this.JBTGrabarS, -1, 54, 32767)).addContainerGap()));
        this.JSPDetalleSg.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), Color.blue));
        this.JTDetalleSg.setFont(new Font("Arial", 1, 12));
        this.JTDetalleSg.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalleSg.setRowHeight(25);
        this.JTDetalleSg.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalleSg.setSelectionForeground(Color.red);
        this.JTDetalleSg.setSelectionMode(0);
        this.JSPDetalleSg.setViewportView(this.JTDetalleSg);
        GroupLayout JPISeguimientoLayout = new GroupLayout(this.JPISeguimiento);
        this.JPISeguimiento.setLayout(JPISeguimientoLayout);
        JPISeguimientoLayout.setHorizontalGroup(JPISeguimientoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPISeguimientoLayout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatosSegu, -1, -1, 32767).addContainerGap()).addGroup(JPISeguimientoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPISeguimientoLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPDetalleSg, -1, 891, 32767).addContainerGap())));
        JPISeguimientoLayout.setVerticalGroup(JPISeguimientoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPISeguimientoLayout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatosSegu, -2, -1, -2).addContainerGap(306, 32767)).addGroup(JPISeguimientoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPISeguimientoLayout.createSequentialGroup().addContainerGap(106, 32767).addComponent(this.JSPDetalleSg, -2, 289, -2).addContainerGap())));
        this.JTPDetalle.addTab("SEGUIMIENTO", this.JPISeguimiento);
        this.JPIDatosEncu.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JDFFechaEnc.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaEnc.setDateFormatString("dd/MM/yyyy");
        this.JDFFechaEnc.setFont(new Font("Arial", 1, 12));
        this.JSPObservacionG.setBorder(BorderFactory.createTitledBorder((Border) null, "Descripción", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTAObservacionGEnc.setFont(new Font("Arial", 1, 12));
        this.JSPObservacionG.setViewportView(this.JTAObservacionGEnc);
        GroupLayout JPIDatosEncuLayout = new GroupLayout(this.JPIDatosEncu);
        this.JPIDatosEncu.setLayout(JPIDatosEncuLayout);
        JPIDatosEncuLayout.setHorizontalGroup(JPIDatosEncuLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosEncuLayout.createSequentialGroup().addContainerGap().addComponent(this.JDFFechaEnc, -2, 121, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPObservacionG, -1, 728, 32767).addContainerGap()));
        JPIDatosEncuLayout.setVerticalGroup(JPIDatosEncuLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosEncuLayout.createSequentialGroup().addGroup(JPIDatosEncuLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JDFFechaEnc, -2, -1, -2).addComponent(this.JSPObservacionG, -1, 54, 32767)).addContainerGap()));
        this.JSPDetalleEnc.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.blue));
        this.JSPDetalleEnc.setFont(new Font("Arial", 1, 12));
        this.JTDetalleEnc.setFont(new Font("Arial", 1, 12));
        this.JTDetalleEnc.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalleEnc.setRowHeight(25);
        this.JTDetalleEnc.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalleEnc.setSelectionForeground(Color.red);
        this.JTDetalleEnc.setSelectionMode(0);
        this.JSPDetalleEnc.setViewportView(this.JTDetalleEnc);
        GroupLayout JPIEncuestaLayout = new GroupLayout(this.JPIEncuesta);
        this.JPIEncuesta.setLayout(JPIEncuestaLayout);
        JPIEncuestaLayout.setHorizontalGroup(JPIEncuestaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIEncuestaLayout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatosEncu, -1, -1, 32767).addContainerGap()).addGroup(JPIEncuestaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIEncuestaLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPDetalleEnc, -1, 891, 32767).addContainerGap())));
        JPIEncuestaLayout.setVerticalGroup(JPIEncuestaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIEncuestaLayout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatosEncu, -2, -1, -2).addContainerGap(306, 32767)).addGroup(JPIEncuestaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIEncuestaLayout.createSequentialGroup().addContainerGap(106, 32767).addComponent(this.JSPDetalleEnc, -2, 289, -2).addContainerGap())));
        this.JTPDetalle.addTab("ENCUESTA", this.JPIEncuesta);
        this.JPIDConvenciones.setBorder(BorderFactory.createTitledBorder((Border) null, "Convenciones", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jCheckBox1.setBackground(new Color(251, 54, 54));
        this.jCheckBox1.setFont(new Font("Arial", 1, 12));
        this.jCheckBox1.setSelected(true);
        this.jCheckBox1.setText("Por Evaluar");
        this.jCheckBox2.setBackground(Color.yellow);
        this.jCheckBox2.setFont(new Font("Arial", 1, 12));
        this.jCheckBox2.setSelected(true);
        this.jCheckBox2.setText("Seguimiento");
        this.jCheckBox3.setBackground(new Color(133, 218, 160));
        this.jCheckBox3.setFont(new Font("Arial", 1, 12));
        this.jCheckBox3.setSelected(true);
        this.jCheckBox3.setText("Cerrada");
        this.jCheckBox4.setBackground(new Color(255, 175, 175));
        this.jCheckBox4.setFont(new Font("Arial", 1, 12));
        this.jCheckBox4.setSelected(true);
        this.jCheckBox4.setText("No Autorizada");
        GroupLayout JPIDConvencionesLayout = new GroupLayout(this.JPIDConvenciones);
        this.JPIDConvenciones.setLayout(JPIDConvencionesLayout);
        JPIDConvencionesLayout.setHorizontalGroup(JPIDConvencionesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDConvencionesLayout.createSequentialGroup().addContainerGap().addComponent(this.jCheckBox1).addGap(18, 18, 18).addComponent(this.jCheckBox2).addGap(18, 18, 18).addComponent(this.jCheckBox3, -2, 121, -2).addGap(18, 18, 18).addComponent(this.jCheckBox4, -2, 121, -2).addContainerGap(20, 32767)));
        JPIDConvencionesLayout.setVerticalGroup(JPIDConvencionesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDConvencionesLayout.createSequentialGroup().addGroup(JPIDConvencionesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jCheckBox1).addComponent(this.jCheckBox2).addComponent(this.jCheckBox3).addComponent(this.jCheckBox4)).addContainerGap(17, 32767)));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTPDetalle).addGroup(layout.createSequentialGroup().addComponent(this.JPIDConvenciones, -2, -1, -2).addGap(0, 0, 32767)).addComponent(this.JPIDatos, GroupLayout.Alignment.TRAILING, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTPDetalle, -2, 437, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JPIDConvenciones, -2, -1, -2).addContainerGap(47, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNoActionPerformed(ActionEvent evt) {
        this.xautorizado = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSiActionPerformed(ActionEvent evt) {
        this.xautorizado = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            Principal.txtNo.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
            if (this.xtipoforma == 0) {
                mCargarDatosTablaDet();
                Object[] botones = {"Visualizar", "Autorizar", "Cerrar"};
                int n = JOptionPane.showInternalOptionDialog(this, "Que desea hacer", "SOLICITUDES", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones, "Cerrar");
                if (n == 0) {
                    mImprimir();
                    return;
                }
                if (n == 1) {
                    this.JTAObservacion.setEnabled(true);
                    this.JRBSi.requestFocus();
                    this.JTAObservacion.setText("");
                    this.JTAObservacionAP.setText("");
                    this.JTAObservacion.requestFocus();
                    return;
                }
                return;
            }
            mCargarDatosTablaDet();
            mCargarDatosTablaEncuesta();
            if (JOptionPane.showInternalConfirmDialog(this, "Desea visualizar el informe", "VIZUALIZAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png")))) == 0) {
                mImprimir();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        Principal.mLimpiarDatosP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHAutorizadaActionPerformed(ActionEvent evt) {
        if (this.JCHAutorizada.isSelected()) {
            this.xtipoconsulta = 1;
        } else {
            this.xtipoconsulta = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleSMouseClicked(MouseEvent evt) {
        if (this.JTDetalleS.getSelectedRow() != -1) {
            mCargarDatosTablaCEvaluacion();
            mCargarDatosTablaSeguimiento();
            if (Integer.valueOf(this.xmodelod.getValueAt(this.JTDetalleS.getSelectedRow(), 4).toString()).intValue() == 0 || Integer.valueOf(this.xmodelod.getValueAt(this.JTDetalleS.getSelectedRow(), 4).toString()).intValue() == 3) {
                this.JBTGrabarS.setEnabled(true);
            } else {
                this.JBTGrabarS.setEnabled(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleCMouseClicked(MouseEvent evt) {
        if (this.JTDetalleS.getSelectedRow() != -1) {
            if (this.JTDetalleC.getSelectedRow() != -1 && this.JTDetalleC.getSelectedColumn() == 2) {
                if (Boolean.valueOf(this.xmodeloc.getValueAt(this.JTDetalleC.getSelectedRow(), 2).toString()).booleanValue()) {
                    this.xmodeloc.setValueAt(Double.valueOf(this.xmodeloc.getValueAt(this.JTDetalleC.getSelectedRow(), 4).toString()), this.JTDetalleC.getSelectedRow(), 3);
                } else {
                    this.xmodeloc.setValueAt(new Double(0.0d), this.JTDetalleC.getSelectedRow(), 3);
                }
                mCalcularE();
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un registro", "VALIDACIÓN", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHAprobadoActionPerformed(ActionEvent evt) {
        if (this.JCHAprobado.isSelected()) {
            this.xaprobada = 1;
            this.JCBPersonaAsignada.setEnabled(true);
        } else {
            this.xaprobada = -1;
            this.JCBPersonaAsignada.setEnabled(false);
            this.JCBPersonaAsignada.setSelectedIndex(-1);
            this.xidpersona = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTAdicionarActionPerformed(ActionEvent evt) {
        String xcuerpomensaje;
        if (!this.JCHTareas.isSelected()) {
            if (!Principal.txtNo.getText().isEmpty()) {
                if (this.JTDetalleS.getSelectedRow() != -1) {
                    if (!this.xestadoeva) {
                        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                        if (n == 0) {
                            for (int x = 0; x < this.JTDetalleC.getRowCount(); x++) {
                                this.xsql = "insert into s_solicitud_evaluacion(Id_Detalle_Solic, Id_TipoCriterioEv, Valor, Observacion, Fecha, UsuarioS)  values('" + this.xmodelod.getValueAt(this.JTDetalleS.getSelectedRow(), 0) + "','" + this.xmodeloc.getValueAt(x, 0) + "','" + this.xmodeloc.getValueAt(x, 3) + "','" + this.xmodeloc.getValueAt(x, 5) + "','" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                                this.xct.ejecutarSQL(this.xsql);
                                this.xct.cerrarConexionBd();
                            }
                            this.xsql = "update s_solicitud_detalle set Aprobada='" + this.xaprobada + "', FechaP='" + this.xmt.formatoAMD.format(this.JDFFechaPE.getDate()) + "', Id_PersonaResp='" + this.xidpersona + "', ObservacionEv='" + this.JTAObservacionAP.getText() + "' where Id='" + this.xmodelod.getValueAt(this.JTDetalleS.getSelectedRow(), 0) + "'";
                            System.out.println("Actualiza sol " + this.xsql);
                            this.xct.ejecutarSQL(this.xsql);
                            this.xct.cerrarConexionBd();
                            mActualizarEstadoSolicitud(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
                            if (this.JCHAprobado.isSelected()) {
                                xcuerpomensaje = "ESTADO : APROBADA\nFECHA PROBABLE DE EJECUCIÓN : " + this.xmt.formatoAMD.format(this.JDFFechaPE.getDate()) + "\nRESPONSABLE : " + this.JCBPersonaAsignada.getSelectedItem().toString() + "\nOBSERVACIÓN : " + this.JTAObservacionAP.getText();
                            } else {
                                xcuerpomensaje = "ESTADO : RECHAZADA\nOBSERVACIÓN : " + this.JTAObservacionAP.getText();
                                this.xsql = "update s_solicitud set EstadoCierre='" + this.xaprobada + "' where Id='" + Principal.txtNo.getText() + "'";
                                this.xct.ejecutarSQL(this.xsql);
                                this.xct.cerrarConexionBd();
                            }
                            this.xsql = "Se ha evaluado el items :" + this.xmodelod.getValueAt(this.JTDetalleS.getSelectedRow(), 2).toString() + "; de la la solicitud N° " + Principal.txtNo.getText() + "\ncon un resultado del : " + this.xmodelod.getValueAt(this.JTDetalleS.getSelectedRow(), 3).toString() + "% \n" + xcuerpomensaje + "\n\n\n" + Principal.usuarioSistemaDTO.getNombreUsuario() + "\n" + Principal.usuarioSistemaDTO.getNombreCargoUsuario();
                            mEnvioCorreoSeguimiento(this.xsql, "EVALUACIÓN DE SOLICITUD");
                            return;
                        }
                        return;
                    }
                    JOptionPane.showInternalMessageDialog(this, "Items ya evaluado", "VERIFICAR", 1);
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un items", "VERIFICAR", 1);
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "A las tareas no se realiza proceso de evaluación", "VERIFICAR", 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGrabarSActionPerformed(ActionEvent evt) {
        if (this.JTDetalleS.getSelectedRow() != -1) {
            if (!this.JTADescripcionS.getText().isEmpty()) {
                int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (x == 0) {
                    this.xsql = "insert into s_solicitud_seguimiento(Id_Detalle_Sol, Id_Persona, FechaS, Observacion, UsuarioS ) values('" + this.xmodelod.getValueAt(this.JTDetalleS.getSelectedRow(), 0) + "','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "','" + this.xmt.formatoAMD.format(this.JDFFechaSg.getDate()) + "','" + this.JTADescripcionS.getText() + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                    this.xct.ejecutarSQL(this.xsql);
                    this.xct.cerrarConexionBd();
                    mCargarDatosTablaSeguimiento();
                    if (this.JCHCerrar.isSelected()) {
                        this.xsql = "update s_solicitud_detalle set Cerrada=1, FechaCierre='" + this.xmt.formatoAMD.format(this.JDFFechaSg.getDate()) + "', Fecha='" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' where Id='" + this.xmodelod.getValueAt(this.JTDetalleS.getSelectedRow(), 0) + "'";
                        this.xct.ejecutarSQL(this.xsql);
                        this.xct.cerrarConexionBd();
                        this.xsql = "Se ha realizado el cierre del items :" + this.xmodelod.getValueAt(this.JTDetalleS.getSelectedRow(), 2).toString() + "; de la la solicitud N° " + Principal.txtNo.getText() + "\nDatos de Cierre:\n\t\tFecha : " + this.xmt.formatoAMD.format(this.JDFFechaSg.getDate()) + "\n\t\tDescripción : " + this.JTADescripcionS.getText() + "\n\nUsuario " + Principal.usuarioSistemaDTO.getNombreUsuario();
                        mEnvioCorreoSeguimiento(this.xsql, "CIERRE DE ITEMS DE SOLICITUD");
                        this.xmodelod.setValueAt(true, this.JTDetalleS.getSelectedRow(), 4);
                        mCerrarSolicitudC();
                        mActualizarEstadoTarea();
                    } else {
                        if (this.JCHCorreo.isSelected()) {
                            this.xsql = "Se ha realizado seguimiento del items :" + this.xmodelod.getValueAt(this.JTDetalleS.getSelectedRow(), 2).toString() + "; de la la solicitud N° " + Principal.txtNo.getText() + "\nDatos del Seguimiento:\n\t\tFecha : " + this.xmt.formatoAMD.format(this.JDFFechaSg.getDate()) + "\n\t\tDescripción : " + this.JTADescripcionS.getText() + "\n\nUsuario " + Principal.usuarioSistemaDTO.getNombreUsuario();
                            mEnvioCorreoSeguimiento(this.xsql, "SEGUIMIENTO ITEMS DE SOLICITUD");
                        }
                        this.xsql = "update s_solicitud_detalle set Cerrada=3, Fecha='" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' where Id='" + this.xmodelod.getValueAt(this.JTDetalleS.getSelectedRow(), 0) + "'";
                        this.xct.ejecutarSQL(this.xsql);
                        this.xct.cerrarConexionBd();
                        mActualizarEstadoSolicitud(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
                    }
                    this.JDFFechaSg.setDate(this.xmt.getFechaActual());
                    this.JTADescripcionS.setText("");
                    this.JCHCorreo.setSelected(true);
                    this.JCHCerrar.setSelected(false);
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe registrar la descripción", "VERIFICAR", 1);
            this.JTADescripcionS.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar el items para el seguimiento", "VERIFICAR", 1);
        this.JTPDetalle.setSelectedIndex(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBPersonaAsignadaItemStateChanged(ItemEvent evt) {
        if (this.xlleno && this.JCBPersonaAsignada.getSelectedIndex() != -1) {
            this.xidpersona = Integer.valueOf(this.xidpersonar[this.JCBPersonaAsignada.getSelectedIndex()][0]).intValue();
        } else {
            this.xidpersona = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHCerradaActionPerformed(ActionEvent evt) {
        if (this.JCHCerrada.isSelected()) {
            this.xcerrarda = 1;
        } else {
            this.xcerrarda = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHTareasActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHCerrarActionPerformed(ActionEvent evt) {
    }

    private void mCerrarSolicitudC() {
        try {
            this.xsql = "SELECT Id_Solicitud, Cerrada FROM s_solicitud_detalle WHERE (Id_Solicitud ='" + Principal.txtNo.getText() + "' AND (Cerrada =0 || Cerrada=3 )) GROUP BY Id_Solicitud ";
            ConsultasMySQL xct1 = new ConsultasMySQL();
            ResultSet rs = xct1.traerRs(this.xsql);
            if (!rs.next()) {
                this.xsql = "update s_solicitud set EstadoCierre=1, FechaCierre='" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "' where Id='" + Principal.txtNo.getText() + "'";
                this.xct.ejecutarSQL(this.xsql);
                this.xct.cerrarConexionBd();
                if (Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 8).toString()).booleanValue()) {
                    JDGenericoCb dialog = new JDGenericoCb((Frame) Principal.clasegeneral.frmPrincipal, true, (JInternalFrame) this);
                    dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
                    dialog.setVisible(true);
                }
            }
            rs.close();
            xct1.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFGestionSolicitudes.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mEnvioCorreoSeguimiento(String xmensaje, String xtitulo) {
        this.xmt.mEnvioCorreoElectronico(xmensaje, this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 7).toString(), xtitulo, Principal.usuarioSistemaDTO.getLogin());
    }

    public void mImprimir() {
        if (!Principal.txtNo.getText().isEmpty()) {
            String[][] mparametros = new String[4][2];
            mparametros[0][0] = "IdC";
            mparametros[0][1] = Principal.txtNo.getText();
            mparametros[1][0] = "UsuarioS";
            mparametros[1][1] = Principal.usuarioSistemaDTO.getLogin();
            mparametros[2][0] = "SUBREPORT_DIR";
            mparametros[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
            mparametros[3][0] = "SUBREPORTFIRMA_DIR";
            mparametros[3][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "S_Solicitud_SI", mparametros);
        }
    }

    public void mNuevo() {
        Principal.mLimpiarDatosP();
        this.JDFechaI.setDate(this.xmt.getFechaActual());
        this.JDFechaF.setDate(this.xmt.getFechaActual());
        this.JRBSi.setSelected(true);
        this.JTAObservacion.setText("");
        if (this.xtipoforma == 1) {
            this.JCHAutorizada.setSelected(true);
            this.JCHAutorizada.setEnabled(false);
            this.xtipoconsulta = 1;
        } else {
            this.JCHAutorizada.setSelected(false);
            this.JCHAutorizada.setEnabled(true);
            this.xtipoconsulta = 0;
        }
        mCrearModeloDatos();
        mCrearModeloDatosDet();
        mCrearModeloDatosCEvaluacion();
        this.JDFFechaPE.setDate(this.xmt.getFechaActual());
        this.JCBPersonaAsignada.removeAllItems();
        this.xsql = "SELECT persona.Id_persona , persona.NUsuario, persona.Corre FROM persona INNER JOIN s_sgc_usuario_tipoproceso  ON (persona.Id_persona = s_sgc_usuario_tipoproceso.Id_Usuario) WHERE (s_sgc_usuario_tipoproceso.Estado =1 AND s_sgc_usuario_tipoproceso.Id_TipoProceso ='" + Principal.informacionGeneralPrincipalDTO.getIdTipoProceso() + "') ORDER BY persona.NUsuario ASC ";
        this.xidpersonar = this.xct.llenarComboyLista(this.xsql, this.xidpersonar, this.JCBPersonaAsignada, 3);
        this.JCBPersonaAsignada.setSelectedIndex(-1);
        this.xct.cerrarConexionBd();
        this.JCHAprobado.setSelected(true);
        this.xaprobada = 1;
        this.JTAObservacionAP.setText("");
        this.JDFFechaSg.setDate(this.xmt.getFechaActual());
        this.JTADescripcionS.setText("");
        this.JCHCerrar.setSelected(false);
        mCrearModeloDatosSeguimiento();
        this.xcerrarda = 0;
        this.JCHCorreo.setSelected(true);
        this.JBTGrabarS.setEnabled(false);
        this.xlleno = true;
        this.JDFFechaEnc.setDate(this.xmt.getFechaActual());
        this.JTAObservacionGEnc.setText("");
        mCrearModeloDatosEncuesta();
        if (this.xfllenar) {
            mBuscar();
        }
    }

    public void mBuscar() {
        mCargarDatosTabla();
    }

    public void mGrabar() {
        if (!Principal.txtNo.getText().isEmpty() && this.xtipoforma == 0) {
            int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                this.xsql = "update s_solicitud_autorizacion set FechaA='" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "', Autorizo='" + this.xautorizado + "', Observacion='" + this.JTAObservacion.getText() + "' where Id_Solicitud='" + Principal.txtNo.getText() + "' and Id_Persona='" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "'";
                this.xct.ejecutarSQL(this.xsql);
                this.xct.cerrarConexionBd();
                this.xsql = "Se ha autorizado la solicitud N° " + Principal.txtNo.getText() + "\nal proceso : " + this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 5).toString() + "\nObservación : " + this.JTAObservacion.getText() + "\n\nFavor entrar a Genoma Plus y continuar con el proceso.\n\n\n" + Principal.usuarioSistemaDTO.getNombreUsuario() + "\n" + Principal.usuarioSistemaDTO.getNombreCargoUsuario();
                this.xmt.mEnvioCorreoElectronico(this.xsql, this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 6).toString(), "CONFIRMACIÓN DE AUTORIZACIÓN DE SOLICITUD", Principal.usuarioSistemaDTO.getLogin());
                mCargarDatosTabla();
            }
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"N°", "Fecha", "Observación", "Solicitante", "Cargo", "Proceso", "Email", "EmailU", "AplicaE", "IdUsuarioS", "Estado"}) { // from class: Sgc.JIFGestionSolicitudes.15
            Class[] types = {Long.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Boolean.class, Long.class, Long.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(6).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(6).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(7).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(7).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(8).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(8).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(9).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(9).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(10).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(10).setMaxWidth(0);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatosDet() {
        this.xmodelod = new DefaultTableModel(new Object[0], new String[]{"Id", "Tipo", "Actividad", "V/Evaluación", "Cerrara?", "Ev"}) { // from class: Sgc.JIFGestionSolicitudes.16
            Class[] types = {Long.class, String.class, String.class, Double.class, Integer.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalleS.setModel(this.xmodelod);
        this.JTDetalleS.getColumnModel().getColumn(0).setPreferredWidth(5);
        this.JTDetalleS.getColumnModel().getColumn(1).setPreferredWidth(200);
        this.JTDetalleS.getColumnModel().getColumn(2).setPreferredWidth(350);
        this.JTDetalleS.getColumnModel().getColumn(3).setPreferredWidth(20);
        this.JTDetalleS.getColumnModel().getColumn(4).setPreferredWidth(20);
        this.JTDetalleS.getColumnModel().getColumn(5).setPreferredWidth(0);
        this.JTDetalleS.getColumnModel().getColumn(5).setMinWidth(0);
        this.JTDetalleS.getColumnModel().getColumn(5).setMaxWidth(0);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatosCEvaluacion() {
        this.xmodeloc = new DefaultTableModel(new Object[0], new String[]{"Id", "Criterio", "Aplica", "Valor", "V/p", "Observación"}) { // from class: Sgc.JIFGestionSolicitudes.17
            Class[] types = {Long.class, String.class, Boolean.class, Double.class, Double.class, String.class};
            boolean[] canEdit = {false, false, true, false, false, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalleC.setModel(this.xmodeloc);
        this.JTDetalleC.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTDetalleC.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTDetalleC.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTDetalleC.getColumnModel().getColumn(1).setPreferredWidth(300);
        this.JTDetalleC.getColumnModel().getColumn(2).setPreferredWidth(5);
        this.JTDetalleC.getColumnModel().getColumn(3).setPreferredWidth(5);
        this.JTDetalleC.getColumnModel().getColumn(4).setPreferredWidth(0);
        this.JTDetalleC.getColumnModel().getColumn(4).setMinWidth(0);
        this.JTDetalleC.getColumnModel().getColumn(4).setMaxWidth(0);
        this.JTDetalleC.getColumnModel().getColumn(5).setPreferredWidth(150);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatosSeguimiento() {
        this.xmodelosg = new DefaultTableModel(new Object[0], new String[]{"Id", "Fecha", "Descripción", "Usuario"}) { // from class: Sgc.JIFGestionSolicitudes.18
            Class[] types = {Long.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalleSg.setModel(this.xmodelosg);
        this.JTDetalleSg.getColumnModel().getColumn(0).setPreferredWidth(5);
        this.JTDetalleSg.getColumnModel().getColumn(1).setPreferredWidth(50);
        this.JTDetalleSg.getColumnModel().getColumn(2).setPreferredWidth(350);
        this.JTDetalleSg.getColumnModel().getColumn(3).setPreferredWidth(200);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatosEncuesta() {
        this.xmodeloe = new DefaultTableModel(new Object[0], new String[]{"Pregunta", "Respuesta", "Observación"}) { // from class: Sgc.JIFGestionSolicitudes.19
            Class[] types = {String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalleEnc.setModel(this.xmodeloe);
        this.JTDetalleEnc.getColumnModel().getColumn(0).setPreferredWidth(500);
        this.JTDetalleEnc.getColumnModel().getColumn(1).setPreferredWidth(30);
        this.JTDetalleEnc.getColumnModel().getColumn(2).setPreferredWidth(100);
    }

    private void mCargarDatosTabla() {
        try {
            mCrearModeloDatos();
            if (this.xtipoforma == 0) {
                this.xsql = "SELECT s_solicitud.Id, date_format(s_solicitud.FechaS,'%d-%m-%Y') as Fecha, s_solicitud.ObservacionG, persona.NUsuario , rh_tipo_cargo.Nbre , s_sgc_tipoproceso.Nbre , s_sgc_tipoproceso.Correo, persona.Corre, s_solicitud.AplicaE, persona.Id_Persona, s_solicitud.EstadoCierre FROM s_solicitud_autorizacion INNER JOIN s_solicitud  ON (s_solicitud_autorizacion.Id_Solicitud = s_solicitud.Id) INNER JOIN rh_tipo_persona_cargon  ON (s_solicitud.Id_Persona_Cargo = rh_tipo_persona_cargon.Id) INNER JOIN rh_unidadf_cargo  ON (rh_tipo_persona_cargon.Id_unidadf_cargo = rh_unidadf_cargo.Id) INNER JOIN rh_tipo_cargo  ON (rh_unidadf_cargo.Id_Cargo = rh_tipo_cargo.Id) INNER JOIN persona  ON (persona.Id_persona = rh_tipo_persona_cargon.Id_Persona) INNER JOIN s_solicitud_detalle  ON (s_solicitud_detalle.Id_Solicitud = s_solicitud.Id) INNER JOIN s_solicitud_tipo_tipoproceso  ON (s_solicitud_detalle.Id_Tipo_S = s_solicitud_tipo_tipoproceso.Id) INNER JOIN s_sgc_tipoproceso  ON (s_solicitud_tipo_tipoproceso.Id_TipoProceso = s_sgc_tipoproceso.Id) WHERE (s_solicitud_autorizacion.Autorizo ='" + this.xtipoconsulta + "'  AND s_solicitud.Estado =1 AND s_solicitud_autorizacion.Id_Persona ='" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "' and s_solicitud.EstadoCierre='" + this.xcerrarda + "') GROUP BY s_solicitud.Id ORDER BY s_solicitud.FechaS DESC ";
            } else if (this.JCHTareas.isSelected()) {
                if (this.JCHCerrada.isSelected()) {
                    this.xsql = "SELECT s_solicitud.Id, date_format(s_solicitud.FechaS,'%d-%m-%Y') as Fecha, s_solicitud.ObservacionG, persona.NUsuario , rh_tipo_cargo.Nbre , s_sgc_tipoproceso.Nbre , s_sgc_tipoproceso.Correo, persona.Corre, s_solicitud.AplicaE, persona.Id_Persona, s_solicitud.EstadoCierre FROM s_solicitud  INNER JOIN rh_tipo_persona_cargon  ON (s_solicitud.Id_Persona_Cargo = rh_tipo_persona_cargon.Id) INNER JOIN rh_unidadf_cargo  ON (rh_tipo_persona_cargon.Id_unidadf_cargo = rh_unidadf_cargo.Id) INNER JOIN rh_tipo_cargo  ON (rh_unidadf_cargo.Id_Cargo = rh_tipo_cargo.Id) INNER JOIN persona  ON (persona.Id_persona = rh_tipo_persona_cargon.Id_Persona) INNER JOIN s_solicitud_detalle  ON (s_solicitud_detalle.Id_Solicitud = s_solicitud.Id) INNER JOIN s_solicitud_tipo_tipoproceso  ON (s_solicitud_detalle.Id_Tipo_S = s_solicitud_tipo_tipoproceso.Id) INNER JOIN s_sgc_tipoproceso  ON (s_solicitud_tipo_tipoproceso.Id_TipoProceso = s_sgc_tipoproceso.Id) WHERE ( s_solicitud.Estado =1 AND  s_sgc_tipoproceso.Id='" + Principal.informacionGeneralPrincipalDTO.getIdTipoProceso() + "' and s_solicitud.EstadoCierre='" + this.xcerrarda + "' AND s_solicitud.AplicaE=0) GROUP BY s_solicitud.Id ORDER BY s_solicitud.FechaS DESC ";
                } else {
                    this.xsql = "SELECT s_solicitud.Id, date_format(s_solicitud.FechaS,'%d-%m-%Y') as Fecha, s_solicitud.ObservacionG, persona.NUsuario , rh_tipo_cargo.Nbre , s_sgc_tipoproceso.Nbre , s_sgc_tipoproceso.Correo, persona.Corre, s_solicitud.AplicaE, persona.Id_Persona, s_solicitud.EstadoCierre FROM s_solicitud  INNER JOIN rh_tipo_persona_cargon  ON (s_solicitud.Id_Persona_Cargo = rh_tipo_persona_cargon.Id) INNER JOIN rh_unidadf_cargo  ON (rh_tipo_persona_cargon.Id_unidadf_cargo = rh_unidadf_cargo.Id) INNER JOIN rh_tipo_cargo  ON (rh_unidadf_cargo.Id_Cargo = rh_tipo_cargo.Id) INNER JOIN persona  ON (persona.Id_persona = rh_tipo_persona_cargon.Id_Persona) INNER JOIN s_solicitud_detalle  ON (s_solicitud_detalle.Id_Solicitud = s_solicitud.Id) INNER JOIN s_solicitud_tipo_tipoproceso  ON (s_solicitud_detalle.Id_Tipo_S = s_solicitud_tipo_tipoproceso.Id) INNER JOIN s_sgc_tipoproceso  ON (s_solicitud_tipo_tipoproceso.Id_TipoProceso = s_sgc_tipoproceso.Id) WHERE ( s_solicitud.Estado =1 AND  s_sgc_tipoproceso.Id='" + Principal.informacionGeneralPrincipalDTO.getIdTipoProceso() + "' and  (s_solicitud.EstadoCierre=0 || s_solicitud.EstadoCierre=3  ) AND s_solicitud.AplicaE=0) GROUP BY s_solicitud.Id ORDER BY s_solicitud.FechaS DESC ";
                }
            } else if (this.JCHCerrada.isSelected()) {
                this.xsql = "SELECT s_solicitud.Id, date_format(s_solicitud.FechaS,'%d-%m-%Y') as Fecha, s_solicitud.ObservacionG, persona.NUsuario , rh_tipo_cargo.Nbre , s_sgc_tipoproceso.Nbre , s_sgc_tipoproceso.Correo, persona.Corre, s_solicitud.AplicaE, persona.Id_Persona, s_solicitud.EstadoCierre FROM s_solicitud_autorizacion INNER JOIN s_solicitud  ON (s_solicitud_autorizacion.Id_Solicitud = s_solicitud.Id) INNER JOIN rh_tipo_persona_cargon  ON (s_solicitud.Id_Persona_Cargo = rh_tipo_persona_cargon.Id) INNER JOIN rh_unidadf_cargo  ON (rh_tipo_persona_cargon.Id_unidadf_cargo = rh_unidadf_cargo.Id) INNER JOIN rh_tipo_cargo  ON (rh_unidadf_cargo.Id_Cargo = rh_tipo_cargo.Id) INNER JOIN persona  ON (persona.Id_persona = rh_tipo_persona_cargon.Id_Persona) INNER JOIN s_solicitud_detalle  ON (s_solicitud_detalle.Id_Solicitud = s_solicitud.Id) INNER JOIN s_solicitud_tipo_tipoproceso  ON (s_solicitud_detalle.Id_Tipo_S = s_solicitud_tipo_tipoproceso.Id) INNER JOIN s_sgc_tipoproceso  ON (s_solicitud_tipo_tipoproceso.Id_TipoProceso = s_sgc_tipoproceso.Id) WHERE (s_solicitud_autorizacion.Autorizo ='" + this.xtipoconsulta + "'  AND s_solicitud.Estado =1 AND  s_sgc_tipoproceso.Id='" + Principal.informacionGeneralPrincipalDTO.getIdTipoProceso() + "' and s_solicitud.EstadoCierre='" + this.xcerrarda + "') GROUP BY s_solicitud.Id ORDER BY s_solicitud.FechaS DESC ";
            } else {
                this.xsql = "SELECT s_solicitud.Id, date_format(s_solicitud.FechaS,'%d-%m-%Y') as Fecha, s_solicitud.ObservacionG, persona.NUsuario , rh_tipo_cargo.Nbre , s_sgc_tipoproceso.Nbre , s_sgc_tipoproceso.Correo, persona.Corre, s_solicitud.AplicaE, persona.Id_Persona, s_solicitud.EstadoCierre FROM s_solicitud_autorizacion INNER JOIN s_solicitud  ON (s_solicitud_autorizacion.Id_Solicitud = s_solicitud.Id) INNER JOIN rh_tipo_persona_cargon  ON (s_solicitud.Id_Persona_Cargo = rh_tipo_persona_cargon.Id) INNER JOIN rh_unidadf_cargo  ON (rh_tipo_persona_cargon.Id_unidadf_cargo = rh_unidadf_cargo.Id) INNER JOIN rh_tipo_cargo  ON (rh_unidadf_cargo.Id_Cargo = rh_tipo_cargo.Id) INNER JOIN persona  ON (persona.Id_persona = rh_tipo_persona_cargon.Id_Persona) INNER JOIN s_solicitud_detalle  ON (s_solicitud_detalle.Id_Solicitud = s_solicitud.Id) INNER JOIN s_solicitud_tipo_tipoproceso  ON (s_solicitud_detalle.Id_Tipo_S = s_solicitud_tipo_tipoproceso.Id) INNER JOIN s_sgc_tipoproceso  ON (s_solicitud_tipo_tipoproceso.Id_TipoProceso = s_sgc_tipoproceso.Id) WHERE (s_solicitud_autorizacion.Autorizo ='" + this.xtipoconsulta + "'  AND s_solicitud.Estado =1 AND  s_sgc_tipoproceso.Id='" + Principal.informacionGeneralPrincipalDTO.getIdTipoProceso() + "' and (s_solicitud.EstadoCierre=0 || s_solicitud.EstadoCierre=3  ) ) GROUP BY s_solicitud.Id ORDER BY s_solicitud.FechaS DESC ";
            }
            ResultSet xrs = this.xct.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(1)), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelo.setValueAt(xrs.getString(4), n, 3);
                    this.xmodelo.setValueAt(xrs.getString(5), n, 4);
                    this.xmodelo.setValueAt(xrs.getString(6), n, 5);
                    this.xmodelo.setValueAt(xrs.getString(7), n, 6);
                    this.xmodelo.setValueAt(xrs.getString(8), n, 7);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(9)), n, 8);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(10)), n, 9);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(11)), n, 10);
                    this.JTDetalle.setDefaultRenderer(Object.class, new MiRender());
                    n++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFGestionSolicitudes.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:Sgc/JIFGestionSolicitudes$MiRender.class */
    public class MiRender extends DefaultTableCellRenderer {
        public MiRender() {
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            long xestado = Long.valueOf(table.getValueAt(row, 10).toString()).longValue();
            if (xestado == 0) {
                cell.setBackground(new Color(251, 54, 54));
                cell.setForeground(Color.WHITE);
            } else if (xestado == 1) {
                cell.setBackground(new Color(133, 218, 160));
                cell.setForeground(Color.BLACK);
            } else if (xestado == 2) {
                cell.setBackground(Color.PINK);
                cell.setForeground(Color.BLACK);
            } else {
                cell.setBackground(Color.YELLOW);
                cell.setForeground(Color.BLACK);
            }
            return cell;
        }
    }

    private void mCargarDatosTablaDet() {
        try {
            mCrearModeloDatosDet();
            this.xsql = "SELECT s_solicitud_detalle.Id, s_solicitud_tipo.Nbre as TipoActividad, IF(s_solicitud_tipo_actividad.Id=1,s_solicitud_detalle.Descripcion, s_solicitud_tipo_actividad.Nbre) AS NActividad, s_solicitud_detalle.Cerrada FROM s_solicitud_detalle INNER JOIN s_solicitud_tipo_tipoproceso ON (s_solicitud_detalle.Id_Tipo_S = s_solicitud_tipo_tipoproceso.Id) INNER JOIN s_solicitud_tipo  ON (s_solicitud_tipo_tipoproceso.Id_TipoSolicitud = s_solicitud_tipo.Id) INNER JOIN baseserver.s_solicitud_tipo_actividad  ON (s_solicitud_detalle.Id_Actividad = s_solicitud_tipo_actividad.Id) WHERE (s_solicitud_detalle.Id_Solicitud ='" + Principal.txtNo.getText() + "') ";
            ResultSet xrs = this.xct.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelod.addRow(this.xdatos);
                    this.xmodelod.setValueAt(Long.valueOf(xrs.getLong(1)), n, 0);
                    this.xmodelod.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelod.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelod.setValueAt(Integer.valueOf(xrs.getInt(4)), n, 4);
                    mTraerValorEvaluacion(xrs.getLong(1), n);
                    n++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFGestionSolicitudes.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatosTablaSeguimiento() {
        try {
            mCrearModeloDatosSeguimiento();
            this.xsql = "SELECT s_solicitud_seguimiento.Id, DATE_FORMAT(s_solicitud_seguimiento.FechaS,'%d-%m-%Y') AS  Fecha, s_solicitud_seguimiento.Observacion, persona.NUsuario FROM persona INNER JOIN s_solicitud_seguimiento  ON (persona.Id_persona = s_solicitud_seguimiento.Id_Persona) WHERE (s_solicitud_seguimiento.Id_Detalle_Sol ='" + this.xmodelod.getValueAt(this.JTDetalleS.getSelectedRow(), 0) + "' AND s_solicitud_seguimiento.Estado=1) ORDER BY s_solicitud_seguimiento.FechaS DESC ";
            ResultSet xrs = this.xct.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelosg.addRow(this.xdatos);
                    this.xmodelosg.setValueAt(Long.valueOf(xrs.getLong(1)), n, 0);
                    this.xmodelosg.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelosg.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelosg.setValueAt(xrs.getString(4), n, 3);
                    n++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFGestionSolicitudes.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatosTablaEncuesta() {
        try {
            mCrearModeloDatosEncuesta();
            this.xsql = "SELECT t_encuestas_registro.FechaEncuestas, t_encuestas_registro.ObservacionG, t_epregunta.Nbre, t_etipo_respuesta.Nbre, t_detalle_encuesta_registro.ObservacionG FROM t_detalle_encuesta_registro INNER JOIN t_encuestas_registro  ON (t_detalle_encuesta_registro.Id_Encuestas = t_encuestas_registro.Id) INNER JOIN t_epregunta  ON (t_detalle_encuesta_registro.Id_Pregunta = t_epregunta.Id) INNER JOIN t_etipo_respuesta  ON (t_detalle_encuesta_registro.Id_Respuesta = t_etipo_respuesta.Id) INNER JOIN s_solicitud  ON (s_solicitud.Id_Encuesta = t_encuestas_registro.Id) INNER JOIN t_tipoencuestaxpregunta  ON (t_tipoencuestaxpregunta.Id_Pregunta = t_epregunta.Id) WHERE (s_solicitud.Id ='" + Principal.txtNo.getText() + "') ORDER BY t_tipoencuestaxpregunta.Orden ASC ";
            ResultSet xrs = this.xct.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.first();
                this.JDFFechaEnc.setDate(xrs.getDate(1));
                this.JTAObservacionGEnc.setText(xrs.getString(2));
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodeloe.addRow(this.xdatos);
                    this.xmodeloe.setValueAt(xrs.getString(3), n, 0);
                    this.xmodeloe.setValueAt(xrs.getString(4), n, 1);
                    this.xmodeloe.setValueAt(xrs.getString(5), n, 2);
                    n++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFGestionSolicitudes.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatosTablaCEvaluacion() {
        try {
            mCrearModeloDatosCEvaluacion();
            this.xsql = "SELECT s_solicitud_tipo_criterio_evaluacion.Id, s_solicitud_tipo_criterio_evaluacion.Nbre, s_solicitud_tipo_criterio_evaluacion.Valor, s_solicitud_evaluacion.Valor , s_solicitud_evaluacion.Observacion FROM s_solicitud_evaluacion INNER JOIN s_solicitud_tipo_criterio_evaluacion  ON (s_solicitud_evaluacion.Id_TipoCriterioEv = s_solicitud_tipo_criterio_evaluacion.Id) WHERE (s_solicitud_evaluacion.Id_Detalle_Solic ='" + this.xmodelod.getValueAt(this.JTDetalleS.getSelectedRow(), 0) + "') ORDER BY s_solicitud_tipo_criterio_evaluacion.Valor DESC ";
            ConsultasMySQL xct1 = new ConsultasMySQL();
            ResultSet rs = xct1.traerRs(this.xsql);
            if (rs.next()) {
                rs.beforeFirst();
                int n = 0;
                double xvalor = 0.0d;
                while (rs.next()) {
                    this.xmodeloc.addRow(this.xdatos);
                    this.xmodeloc.setValueAt(Long.valueOf(rs.getLong(1)), n, 0);
                    this.xmodeloc.setValueAt(rs.getString(2), n, 1);
                    this.xmodeloc.setValueAt(true, n, 2);
                    this.xmodeloc.setValueAt(Double.valueOf(rs.getDouble(4)), n, 3);
                    this.xmodeloc.setValueAt(Double.valueOf(rs.getDouble(3)), n, 4);
                    this.xmodeloc.setValueAt(rs.getString(5), n, 5);
                    n++;
                    xvalor += rs.getDouble(4);
                }
                this.xmodelod.setValueAt(Double.valueOf(xvalor), this.JTDetalleS.getSelectedRow(), 3);
                this.xestadoeva = true;
                this.xsql = "SELECT s_solicitud_detalle.Aprobada, s_solicitud_detalle.FechaP, persona.NUsuario, s_solicitud_detalle.ObservacionEv, s_solicitud_detalle.Id FROM persona INNER JOIN s_solicitud_detalle  ON (persona.Id_persona = s_solicitud_detalle.Id_PersonaResp) WHERE (s_solicitud_detalle.Id ='" + this.xmodelod.getValueAt(this.JTDetalleS.getSelectedRow(), 0) + "') ";
                ConsultasMySQL xct2 = new ConsultasMySQL();
                ResultSet rs1 = xct2.traerRs(this.xsql);
                if (rs1.next()) {
                    rs1.first();
                    this.JCHAprobado.setSelected(rs1.getBoolean(1));
                    this.JDFFechaPE.setDate(rs1.getDate(2));
                    this.JCBPersonaAsignada.setSelectedItem(rs1.getString(3));
                    this.JTAObservacionAP.setText(rs1.getString(4));
                }
                rs1.close();
                xct2.cerrarConexionBd();
            } else {
                this.xsql = "SELECT Id, Nbre, Valor FROM s_solicitud_tipo_criterio_evaluacion WHERE (Estado =1) ORDER BY Valor DESC";
                ResultSet xrs = this.xct.traerRs(this.xsql);
                if (xrs.next()) {
                    xrs.beforeFirst();
                    int n2 = 0;
                    while (xrs.next()) {
                        this.xmodeloc.addRow(this.xdatos);
                        this.xmodeloc.setValueAt(Long.valueOf(xrs.getLong(1)), n2, 0);
                        this.xmodeloc.setValueAt(xrs.getString(2), n2, 1);
                        this.xmodeloc.setValueAt(false, n2, 2);
                        this.xmodeloc.setValueAt(new Double(0.0d), n2, 3);
                        this.xmodeloc.setValueAt(Double.valueOf(xrs.getDouble(3)), n2, 4);
                        this.xmodeloc.setValueAt("", n2, 5);
                        n2++;
                    }
                }
                xrs.close();
                this.xct.cerrarConexionBd();
                this.xestadoeva = false;
                this.JCHAprobado.setSelected(true);
                this.JDFFechaPE.setDate(this.xmt.getFechaActual());
                this.JTAObservacionAP.setText("");
                this.JCBPersonaAsignada.setSelectedIndex(-1);
            }
            rs.close();
            xct1.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFGestionSolicitudes.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCalcularE() {
        double xvalor = 0.0d;
        for (int x = 0; x < this.JTDetalleC.getRowCount(); x++) {
            if (Boolean.valueOf(this.xmodeloc.getValueAt(this.JTDetalleC.getSelectedRow(), 2).toString()).booleanValue()) {
                xvalor += Double.valueOf(this.xmodeloc.getValueAt(x, 3).toString()).doubleValue();
            }
        }
        this.xmodelod.setValueAt(Double.valueOf(xvalor), this.JTDetalleS.getSelectedRow(), 3);
    }

    private void mTraerValorEvaluacion(long xid, int pos) {
        try {
            this.xsql = "SELECT SUM(Valor) FROM s_solicitud_evaluacion WHERE (Id_Detalle_Solic ='" + xid + "') GROUP BY Id_Detalle_Solic";
            ConsultasMySQL xct1 = new ConsultasMySQL();
            ResultSet rs = xct1.traerRs(this.xsql);
            if (rs.next()) {
                rs.first();
                this.xmodelod.setValueAt(Double.valueOf(rs.getDouble(1)), pos, 3);
                this.xmodelod.setValueAt(true, pos, 5);
            } else {
                this.xmodelod.setValueAt(new Double(0.0d), pos, 3);
                this.xmodelod.setValueAt(false, pos, 5);
            }
            rs.close();
            xct1.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFGestionSolicitudes.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mCrearEncuestaSatisfaccion(String xidencuesta, String xnombreencuesta) {
        this.xsql = "insert ignore into  t_e_tipo_encuesta_detalle(Id_Tipo_Encuesta, Id_UsuarioG, Id_TipoProceso, Id_Solicitud, Fecha, UsuarioS)  values('" + xidencuesta + "','" + this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 9) + "','" + Principal.informacionGeneralPrincipalDTO.getIdTipoProceso() + "','" + Principal.txtNo.getText() + "','" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
        System.out.println("Encuesta : " + this.xsql);
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xmt.mEnvioCorreoElectronico("Se le ha asignado la encuesta de : " + xnombreencuesta + ";\npara la solicitud N°" + Principal.txtNo.getText() + ", realizada por usted. \n\n Favor entrar a Genoma Plus y diligenciarla. \n\n\n" + Principal.usuarioSistemaDTO.getNombreUsuario(), this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 7).toString(), "NOTIFICACIÓN DE ENCUESTA ASIGNADA", Principal.usuarioSistemaDTO.getLogin());
    }

    private void mActualizarEstadoTarea() {
        if (this.JCHTareas.isSelected()) {
            this.xsql = "update s_solicitud_detalle set Aprobada=1 where id_solicitud='" + Principal.txtNo.getText() + "'";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
        }
    }

    private void mActualizarEstadoSolicitud(String xid) {
        this.xsql = "update s_solicitud set s_solicitud.EstadoCierre=3 where Id='" + xid + "'";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
    }
}
