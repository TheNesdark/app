package Sgc;

import Acceso.Principal;
import Informes.JFGraficoBarra;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
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
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

/* JADX INFO: loaded from: GenomaP.jar:Sgc/JIFRNoConfomidad.class */
public class JIFRNoConfomidad extends JInternalFrame {
    private String[] xidtipop;
    private String[] xidtipo;
    private String[] xidorigen;
    private String[] xidtipoinc;
    private String[] xiddetalleinc;
    private String[] xidtipoprocesoint;
    private String[] xidprocesoa;
    private String[] xidtipoaccion;
    public String[][] xidtiposolicitud;
    public String[][] xidproceso;
    public String[][] xidprocesor;
    public String[][] xidresponsable;
    public String[][] xidresponsable1;
    private String xsql;
    public DefaultTableModel xmodelo;
    public DefaultTableModel xmodelo1;
    public DefaultTableModel xmodelo2;
    public DefaultTableModel xmodeloevidencia;
    public DefaultTableModel xmodeloproceso;
    public DefaultTableModel xmodeloorigen;
    public DefaultTableModel xmodeloNC;
    private int xmodulo;
    private Object[] xdato;
    private File xfile;
    private ButtonGroup JBGTipoAj;
    private JButton JBTAdicionarAcc;
    private JButton JBTAdicionarAcc1;
    private JButton JBTAdicionarI;
    private JButton JBTExportar;
    private JButton JBTGrabarEvidencia;
    private JButton JBTGrabarI;
    public JButton JBTGraficoNC;
    public JButton JBTGraficoOrigen;
    public JButton JBTGraficoProceso;
    private JComboBox JCBDetalleInc;
    private JComboBox JCBProceso;
    private JComboBox JCBProcesoA;
    private JComboBox JCBProcesoI;
    private JComboBox JCBProcesoR;
    private JComboBox JCBResponsable;
    private JComboBox JCBResponsableI;
    private JComboBox JCBTOrigen;
    private JComboBox JCBTProceso;
    private JComboBox JCBTipo;
    private JComboBox JCBTipoAc;
    private JComboBox JCBTipoI;
    private JCheckBox JCHAjustar;
    private JCheckBox JCHCompletado;
    private JCheckBox JCHEsNC;
    private JCheckBox JCHNc;
    private JDateChooser JDFFechaFin;
    private JDateChooser JDFFechaInicio;
    private JDateChooser JDFecha;
    private JDateChooser JDFechaEjec;
    private JDateChooser JDFechaEvidencia;
    private JLabel JLBFechaAnalisis;
    private JLabel JLBNAnalisis;
    private JLabel JLEstado;
    private JLabel JLEstadoRSgc;
    private JLabel JLTotal;
    private JLabel JLTotalA;
    private JLabel JLTotalNA;
    private JPanel JPIAcciones;
    private JPanel JPIAnalisis;
    private JPanel JPIDatos;
    private JPanel JPIDatosC;
    private JPanel JPIDatosNC;
    private JPanel JPIDatosRSgc;
    private JPanel JPIDiagrama;
    private JPanel JPIIncumplimiento;
    private JPanel JPIIntegrantes;
    private JPanel JPIParteDos;
    private JPanel JPIReporte;
    private JPanel JPI_Evidencia;
    private JPanel JPInformes;
    private JScrollPane JSPAccionImediata;
    private JScrollPane JSPActividad;
    private JScrollPane JSPCorreoR;
    private JScrollPane JSPCorreoRSgc;
    private JScrollPane JSPDescripcion;
    private JScrollPane JSPDescripcionEvidencia;
    private JScrollPane JSPDescripcionP;
    private JScrollPane JSPDetalle;
    private JScrollPane JSPDetalle2;
    private JScrollPane JSPDetalleAcc;
    private JScrollPane JSPDetalleEvidencia;
    private JScrollPane JSPDetalleNC;
    private JScrollPane JSPDetalleOrigen;
    private JScrollPane JSPDetalleProcesoR;
    private JScrollPane JSPManoObra;
    private JScrollPane JSPMaquina;
    private JScrollPane JSPMaterial;
    private JScrollPane JSPMedioAmb;
    private JScrollPane JSPMetodo;
    private JScrollPane JSPObservacionC;
    private JScrollPane JSPObservacionInc;
    private JScrollPane JSPObservacionRSgc;
    private JTextPane JTAAccionImediata;
    private JTextPane JTAActividad;
    private JTextPane JTACorreoR;
    private JTextPane JTACorreoR1;
    private JTextPane JTADescripcion;
    private JTextPane JTADescripcionEvidencia;
    private JTextPane JTADescripcionP;
    private JTextPane JTAManoObra;
    private JTextPane JTAMaquina;
    private JTextPane JTAMaterial;
    private JTextPane JTAMedioAmb;
    private JTextPane JTAMetodo;
    private JTextPane JTAObservacionC;
    private JTextPane JTAObservacionInc;
    private JTextPane JTAObservacionRSgc;
    private JTable JTBDetalleEvidencia;
    private JTable JTDetalle;
    private JTable JTDetalle1;
    private JTable JTDetalle2;
    public JTable JTDetalleNC;
    public JTable JTDetalleOrigen;
    public JTable JTDetallePR;
    private JTextField JTFRuta;
    private JTextField JTFRutaEvidencia;
    private JTabbedPane JTPAnalisis;
    private JTabbedPane JTPDatos;
    private JTabbedPane JTPRegistro;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private ConsultasMySQL xct = new ConsultasMySQL();
    private Metodos xmt = new Metodos();
    private boolean xlleno = false;
    private boolean xlleno1 = false;
    public long xidactividad = 1;
    public long xidnc1 = 0;
    public long xidnc = 0;
    private int xnfila = -1;
    private int xnfila1 = -1;
    private int xnfila2 = -1;
    private int xesnc = 0;
    private int xaplicaencuesta = 1;

    public JIFRNoConfomidad(int xmodulo, String xnombre) {
        this.xmodulo = 0;
        initComponents();
        setName(xnombre);
        this.xmodulo = xmodulo;
        mNuevo();
        if (this.xmodulo == 2) {
            mBuscarNC(String.valueOf(Principal.xclasesgc.xjifficha5w1h.xIdTipoDoc));
        }
    }

    /* JADX WARN: Type inference failed for: r3v179, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v218, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v332, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v360, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v367, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v446, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v65, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGTipoAj = new ButtonGroup();
        this.JTPRegistro = new JTabbedPane();
        this.JPIReporte = new JPanel();
        this.JPIDatosNC = new JPanel();
        this.JDFecha = new JDateChooser();
        this.JCBTipo = new JComboBox();
        this.JCBTOrigen = new JComboBox();
        this.JCBTProceso = new JComboBox();
        this.JCBProceso = new JComboBox();
        this.JSPDescripcion = new JScrollPane();
        this.JTADescripcion = new JTextPane();
        this.JSPAccionImediata = new JScrollPane();
        this.JTAAccionImediata = new JTextPane();
        this.jLabel2 = new JLabel();
        this.JCBProcesoR = new JComboBox();
        this.JTPDatos = new JTabbedPane();
        this.JPIIncumplimiento = new JPanel();
        this.JCBTipoI = new JComboBox();
        this.JCBDetalleInc = new JComboBox();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JBTAdicionarI = new JButton();
        this.JSPObservacionInc = new JScrollPane();
        this.JTAObservacionInc = new JTextPane();
        this.JBTGrabarI = new JButton();
        this.JPIDatosC = new JPanel();
        this.JCHEsNC = new JCheckBox();
        this.JSPCorreoR = new JScrollPane();
        this.JTACorreoR = new JTextPane();
        this.JLEstado = new JLabel();
        this.JSPObservacionC = new JScrollPane();
        this.JTAObservacionC = new JTextPane();
        this.JPIAnalisis = new JPanel();
        this.JTPAnalisis = new JTabbedPane();
        this.JPIDiagrama = new JPanel();
        this.JSPDescripcionP = new JScrollPane();
        this.JTADescripcionP = new JTextPane();
        this.JSPMaquina = new JScrollPane();
        this.JTAMaquina = new JTextPane();
        this.JSPManoObra = new JScrollPane();
        this.JTAManoObra = new JTextPane();
        this.JSPMaterial = new JScrollPane();
        this.JTAMaterial = new JTextPane();
        this.JSPMedioAmb = new JScrollPane();
        this.JTAMedioAmb = new JTextPane();
        this.JSPMetodo = new JScrollPane();
        this.JTAMetodo = new JTextPane();
        this.jLabel1 = new JLabel();
        this.JPIParteDos = new JPanel();
        this.JPIAcciones = new JPanel();
        this.JCBTipoAc = new JComboBox();
        this.JSPActividad = new JScrollPane();
        this.JTAActividad = new JTextPane();
        this.JCBProcesoA = new JComboBox();
        this.JCBResponsable = new JComboBox();
        this.JDFechaEjec = new JDateChooser();
        this.JBTAdicionarAcc = new JButton();
        this.JSPDetalleAcc = new JScrollPane();
        this.JTDetalle1 = new JTable();
        this.JPIIntegrantes = new JPanel();
        this.JCBProcesoI = new JComboBox();
        this.JCBResponsableI = new JComboBox();
        this.JBTAdicionarAcc1 = new JButton();
        this.JSPDetalle2 = new JScrollPane();
        this.JTDetalle2 = new JTable();
        this.JLBNAnalisis = new JLabel();
        this.JLBFechaAnalisis = new JLabel();
        this.JPIDatosRSgc = new JPanel();
        this.JSPCorreoRSgc = new JScrollPane();
        this.JTACorreoR1 = new JTextPane();
        this.JLEstadoRSgc = new JLabel();
        this.JSPObservacionRSgc = new JScrollPane();
        this.JTAObservacionRSgc = new JTextPane();
        this.JCHAjustar = new JCheckBox();
        this.JCHCompletado = new JCheckBox();
        this.JPInformes = new JPanel();
        this.jPanel2 = new JPanel();
        this.JDFFechaInicio = new JDateChooser();
        this.JDFFechaFin = new JDateChooser();
        this.JCHNc = new JCheckBox();
        this.JSPDetalleProcesoR = new JScrollPane();
        this.JTDetallePR = new JTable();
        this.jPanel1 = new JPanel();
        this.JLTotalA = new JLabel();
        this.JLTotalNA = new JLabel();
        this.JLTotal = new JLabel();
        this.JSPDetalleOrigen = new JScrollPane();
        this.JTDetalleOrigen = new JTable();
        this.JSPDetalleNC = new JScrollPane();
        this.JTDetalleNC = new JTable();
        this.JBTGraficoOrigen = new JButton();
        this.JBTGraficoProceso = new JButton();
        this.JBTGraficoNC = new JButton();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        this.JPI_Evidencia = new JPanel();
        this.JPIDatos = new JPanel();
        this.JDFechaEvidencia = new JDateChooser();
        this.JSPDescripcionEvidencia = new JScrollPane();
        this.JTADescripcionEvidencia = new JTextPane();
        this.JTFRutaEvidencia = new JTextField();
        this.JBTGrabarEvidencia = new JButton();
        this.JSPDetalleEvidencia = new JScrollPane();
        this.JTBDetalleEvidencia = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("NO CONFORMIDADES");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMinimumSize(null);
        setName("xjifreportenc");
        setPreferredSize(new Dimension(912, 828));
        addInternalFrameListener(new InternalFrameListener() { // from class: Sgc.JIFRNoConfomidad.1
            public void internalFrameActivated(InternalFrameEvent evt) {
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIFRNoConfomidad.this.formInternalFrameClosing(evt);
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
        this.JTPRegistro.setForeground(new Color(0, 103, 0));
        this.JTPRegistro.setFont(new Font("Arial", 1, 14));
        this.JPIDatosNC.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 0, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JDFecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFecha.setDateFormatString("dd/MM/yyyy");
        this.JDFecha.setFont(new Font("Arial", 1, 12));
        this.JCBTipo.setFont(new Font("Arial", 1, 12));
        this.JCBTipo.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo NC", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTOrigen.setFont(new Font("Arial", 1, 12));
        this.JCBTOrigen.setBorder(BorderFactory.createTitledBorder((Border) null, "Origen", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTProceso.setFont(new Font("Arial", 1, 12));
        this.JCBTProceso.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Proceso", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTProceso.addItemListener(new ItemListener() { // from class: Sgc.JIFRNoConfomidad.2
            public void itemStateChanged(ItemEvent evt) {
                JIFRNoConfomidad.this.JCBTProcesoItemStateChanged(evt);
            }
        });
        this.JCBProceso.setFont(new Font("Arial", 1, 12));
        this.JCBProceso.setBorder(BorderFactory.createTitledBorder((Border) null, "Proceso", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPDescripcion.setBorder(BorderFactory.createTitledBorder((Border) null, "Descripción del problema", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTADescripcion.setFont(new Font("Arial", 1, 12));
        this.JSPDescripcion.setViewportView(this.JTADescripcion);
        this.JSPAccionImediata.setBorder(BorderFactory.createTitledBorder((Border) null, "Correción", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTAAccionImediata.setFont(new Font("Arial", 1, 12));
        this.JSPAccionImediata.setViewportView(this.JTAAccionImediata);
        this.jLabel2.setFont(new Font("Arial", 1, 14));
        this.jLabel2.setForeground(Color.red);
        this.jLabel2.setHorizontalAlignment(0);
        this.jLabel2.setText("PROCESO AL QUE SE REPORTA");
        this.JCBProcesoR.setFont(new Font("Arial", 1, 12));
        this.JCBProcesoR.setBorder(BorderFactory.createTitledBorder((Border) null, "Proceso que reporta", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBProcesoR.addItemListener(new ItemListener() { // from class: Sgc.JIFRNoConfomidad.3
            public void itemStateChanged(ItemEvent evt) {
                JIFRNoConfomidad.this.JCBProcesoRItemStateChanged(evt);
            }
        });
        GroupLayout JPIDatosNCLayout = new GroupLayout(this.JPIDatosNC);
        this.JPIDatosNC.setLayout(JPIDatosNCLayout);
        JPIDatosNCLayout.setHorizontalGroup(JPIDatosNCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosNCLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosNCLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSPAccionImediata).addComponent(this.JSPDescripcion, GroupLayout.Alignment.LEADING).addComponent(this.jLabel2, GroupLayout.Alignment.LEADING, -1, -1, 32767).addGroup(GroupLayout.Alignment.LEADING, JPIDatosNCLayout.createSequentialGroup().addComponent(this.JDFecha, -2, 120, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBTipo, -2, 264, -2).addGap(18, 18, 18).addComponent(this.JCBTOrigen, 0, -1, 32767)).addGroup(JPIDatosNCLayout.createSequentialGroup().addComponent(this.JCBTProceso, -2, 271, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBProceso, 0, -1, 32767)).addComponent(this.JCBProcesoR, GroupLayout.Alignment.LEADING, -2, 232, -2)).addContainerGap()));
        JPIDatosNCLayout.setVerticalGroup(JPIDatosNCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosNCLayout.createSequentialGroup().addGroup(JPIDatosNCLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JDFecha, -2, -1, -2).addComponent(this.JCBTipo, -2, -1, -2).addComponent(this.JCBTOrigen, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel2).addGap(18, 18, 18).addGroup(JPIDatosNCLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBTProceso, -2, -1, -2).addComponent(this.JCBProceso, -2, -1, -2)).addGap(18, 18, 18).addComponent(this.JSPDescripcion, -2, 86, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPAccionImediata, -2, 77, -2).addGap(18, 18, 18).addComponent(this.JCBProcesoR, -2, -1, -2).addContainerGap()));
        this.JTPDatos.setForeground(new Color(255, 0, 0));
        this.JTPDatos.setFont(new Font("Arial", 1, 14));
        this.JCBTipoI.setFont(new Font("Arial", 1, 12));
        this.JCBTipoI.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipoI.addItemListener(new ItemListener() { // from class: Sgc.JIFRNoConfomidad.4
            public void itemStateChanged(ItemEvent evt) {
                JIFRNoConfomidad.this.JCBTipoIItemStateChanged(evt);
            }
        });
        this.JCBDetalleInc.setFont(new Font("Arial", 1, 12));
        this.JCBDetalleInc.setBorder(BorderFactory.createTitledBorder((Border) null, "Detalle", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JSPDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalle.setEditingColumn(2);
        this.JTDetalle.setEditingRow(1);
        this.JTDetalle.setGridColor(new Color(0, 0, 0));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(Color.blue);
        this.JTDetalle.setSelectionMode(0);
        this.JTDetalle.addKeyListener(new KeyAdapter() { // from class: Sgc.JIFRNoConfomidad.5
            public void keyPressed(KeyEvent evt) {
                JIFRNoConfomidad.this.JTDetalleKeyPressed(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JBTAdicionarI.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTAdicionarI.setEnabled(false);
        this.JBTAdicionarI.addActionListener(new ActionListener() { // from class: Sgc.JIFRNoConfomidad.6
            public void actionPerformed(ActionEvent evt) {
                JIFRNoConfomidad.this.JBTAdicionarIActionPerformed(evt);
            }
        });
        this.JSPObservacionInc.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTAObservacionInc.setFont(new Font("Arial", 1, 12));
        this.JSPObservacionInc.setViewportView(this.JTAObservacionInc);
        this.JBTGrabarI.setFont(new Font("Arial", 1, 12));
        this.JBTGrabarI.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Grabar29x27.png")));
        this.JBTGrabarI.setText("Guardar");
        this.JBTGrabarI.setEnabled(false);
        this.JBTGrabarI.addActionListener(new ActionListener() { // from class: Sgc.JIFRNoConfomidad.7
            public void actionPerformed(ActionEvent evt) {
                JIFRNoConfomidad.this.JBTGrabarIActionPerformed(evt);
            }
        });
        GroupLayout JPIIncumplimientoLayout = new GroupLayout(this.JPIIncumplimiento);
        this.JPIIncumplimiento.setLayout(JPIIncumplimientoLayout);
        JPIIncumplimientoLayout.setHorizontalGroup(JPIIncumplimientoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIIncumplimientoLayout.createSequentialGroup().addGroup(JPIIncumplimientoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIIncumplimientoLayout.createSequentialGroup().addGap(14, 14, 14).addComponent(this.JCBTipoI, -2, 172, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBDetalleInc, -2, 248, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPObservacionInc, -1, 329, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBTAdicionarI, -2, 63, -2)).addGroup(GroupLayout.Alignment.TRAILING, JPIIncumplimientoLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPDetalle, -1, 842, 32767)).addGroup(JPIIncumplimientoLayout.createSequentialGroup().addContainerGap().addComponent(this.JBTGrabarI, -1, 842, 32767))).addContainerGap()));
        JPIIncumplimientoLayout.setVerticalGroup(JPIIncumplimientoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIIncumplimientoLayout.createSequentialGroup().addContainerGap().addGroup(JPIIncumplimientoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JCBTipoI).addComponent(this.JCBDetalleInc, -2, -1, -2).addComponent(this.JSPObservacionInc).addComponent(this.JBTAdicionarI, -1, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPDetalle, -2, 91, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTGrabarI, -1, 61, 32767).addContainerGap()));
        this.JTPDatos.addTab("INCUMPLIMIENTO (Campos a diligenciar por Coordinación de Calidad)", this.JPIIncumplimiento);
        this.JCHEsNC.setFont(new Font("Arial", 1, 12));
        this.JCHEsNC.setSelected(true);
        this.JCHEsNC.setText("Requiere Análisis");
        this.JCHEsNC.addActionListener(new ActionListener() { // from class: Sgc.JIFRNoConfomidad.8
            public void actionPerformed(ActionEvent evt) {
                JIFRNoConfomidad.this.JCHEsNCActionPerformed(evt);
            }
        });
        this.JSPCorreoR.setBorder(BorderFactory.createTitledBorder((Border) null, "Correo", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPCorreoR.setFont(new Font("Arial", 1, 12));
        this.JTACorreoR.setFont(new Font("Arial", 1, 12));
        this.JSPCorreoR.setViewportView(this.JTACorreoR);
        this.JLEstado.setBackground(new Color(255, 255, 255));
        this.JLEstado.setFont(new Font("Arial", 1, 14));
        this.JLEstado.setForeground(Color.red);
        this.JLEstado.setHorizontalAlignment(0);
        this.JLEstado.setBorder(BorderFactory.createEtchedBorder());
        this.JSPObservacionC.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTAObservacionC.setFont(new Font("Arial", 1, 12));
        this.JSPObservacionC.setViewportView(this.JTAObservacionC);
        GroupLayout JPIDatosCLayout = new GroupLayout(this.JPIDatosC);
        this.JPIDatosC.setLayout(JPIDatosCLayout);
        JPIDatosCLayout.setHorizontalGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosCLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSPCorreoR, -1, 607, 32767).addComponent(this.JSPObservacionC)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JLEstado, -2, 98, -2).addGap(6, 6, 6).addComponent(this.JCHEsNC).addContainerGap()));
        JPIDatosCLayout.setVerticalGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosCLayout.createSequentialGroup().addGap(23, 23, 23).addGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JCHEsNC).addGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JLEstado, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JSPObservacionC, GroupLayout.Alignment.LEADING, -2, 76, -2))).addGap(21, 21, 21).addComponent(this.JSPCorreoR, -2, 60, -2).addContainerGap(56, 32767)));
        this.JTPDatos.addTab("DATOS DE CALIDAD", this.JPIDatosC);
        GroupLayout JPIReporteLayout = new GroupLayout(this.JPIReporte);
        this.JPIReporte.setLayout(JPIReporteLayout);
        JPIReporteLayout.setHorizontalGroup(JPIReporteLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIReporteLayout.createSequentialGroup().addContainerGap().addGroup(JPIReporteLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIDatosNC, -1, -1, 32767).addComponent(this.JTPDatos)).addContainerGap()));
        JPIReporteLayout.setVerticalGroup(JPIReporteLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIReporteLayout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatosNC, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTPDatos, -2, -1, -2).addContainerGap(18, 32767)));
        this.JTPRegistro.addTab("REPORTE", this.JPIReporte);
        this.JTPAnalisis.setBorder(BorderFactory.createTitledBorder((Border) null, "ANALISIS DE CAUSAS (Diagrama Causa Efecto o Espina de Pescado)", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTPAnalisis.setForeground(new Color(0, 103, 0));
        this.JTPAnalisis.setFont(new Font("Arial", 1, 14));
        this.JPIDiagrama.setLayout((LayoutManager) null);
        this.JSPDescripcionP.setBorder(BorderFactory.createTitledBorder((Border) null, "D.SITUACIÓN  O PROBLEMA", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTADescripcionP.setFont(new Font("Arial", 1, 12));
        this.JSPDescripcionP.setViewportView(this.JTADescripcionP);
        this.JPIDiagrama.add(this.JSPDescripcionP);
        this.JSPDescripcionP.setBounds(611, 189, 190, 134);
        this.JSPMaquina.setBorder(BorderFactory.createTitledBorder((Border) null, "MAQUINA", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTAMaquina.setFont(new Font("Arial", 1, 12));
        this.JTAMaquina.setText("N/A");
        this.JSPMaquina.setViewportView(this.JTAMaquina);
        this.JPIDiagrama.add(this.JSPMaquina);
        this.JSPMaquina.setBounds(50, 20, 200, 200);
        this.JSPManoObra.setBorder(BorderFactory.createTitledBorder((Border) null, "MANO DE OBRA", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTAManoObra.setFont(new Font("Arial", 1, 12));
        this.JTAManoObra.setText("N/A");
        this.JSPManoObra.setViewportView(this.JTAManoObra);
        this.JPIDiagrama.add(this.JSPManoObra);
        this.JSPManoObra.setBounds(350, 20, 200, 200);
        this.JSPMaterial.setBorder(BorderFactory.createTitledBorder((Border) null, "MATERIAL", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTAMaterial.setFont(new Font("Arial", 1, 12));
        this.JTAMaterial.setText("N/A");
        this.JSPMaterial.setViewportView(this.JTAMaterial);
        this.JPIDiagrama.add(this.JSPMaterial);
        this.JSPMaterial.setBounds(10, 340, 200, 170);
        this.JSPMedioAmb.setBorder(BorderFactory.createTitledBorder((Border) null, "MEDIO AMBIENTE", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTAMedioAmb.setFont(new Font("Arial", 1, 12));
        this.JTAMedioAmb.setText("N/A");
        this.JSPMedioAmb.setViewportView(this.JTAMedioAmb);
        this.JPIDiagrama.add(this.JSPMedioAmb);
        this.JSPMedioAmb.setBounds(230, 340, 200, 170);
        this.JSPMetodo.setBorder(BorderFactory.createTitledBorder((Border) null, "MÉTODO", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTAMetodo.setFont(new Font("Arial", 1, 12));
        this.JTAMetodo.setText("N/A");
        this.JSPMetodo.setViewportView(this.JTAMetodo);
        this.JPIDiagrama.add(this.JSPMetodo);
        this.JSPMetodo.setBounds(440, 340, 200, 170);
        this.jLabel1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/diagrama.PNG")));
        this.jLabel1.setOpaque(true);
        this.JPIDiagrama.add(this.jLabel1);
        this.jLabel1.setBounds(0, 220, 600, 120);
        this.JTPAnalisis.addTab("ANÁLISIS CAUSAL", this.JPIDiagrama);
        this.JPIAcciones.setBorder(BorderFactory.createTitledBorder((Border) null, "ACCIONES PROPUESTAS", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JCBTipoAc.setFont(new Font("Arial", 1, 12));
        this.JCBTipoAc.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPActividad.setBorder(BorderFactory.createTitledBorder((Border) null, "Actividad", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTAActividad.setFont(new Font("Arial", 1, 12));
        this.JSPActividad.setViewportView(this.JTAActividad);
        this.JCBProcesoA.setFont(new Font("Arial", 1, 12));
        this.JCBProcesoA.setBorder(BorderFactory.createTitledBorder((Border) null, "Proceso", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBProcesoA.addItemListener(new ItemListener() { // from class: Sgc.JIFRNoConfomidad.9
            public void itemStateChanged(ItemEvent evt) {
                JIFRNoConfomidad.this.JCBProcesoAItemStateChanged(evt);
            }
        });
        this.JCBResponsable.setFont(new Font("Arial", 1, 12));
        this.JCBResponsable.setBorder(BorderFactory.createTitledBorder((Border) null, "Responsable", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaEjec.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Ejecución", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaEjec.setDateFormatString("dd/MM/yyyy");
        this.JDFechaEjec.setFont(new Font("Arial", 1, 12));
        this.JBTAdicionarAcc.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTAdicionarAcc.addActionListener(new ActionListener() { // from class: Sgc.JIFRNoConfomidad.10
            public void actionPerformed(ActionEvent evt) {
                JIFRNoConfomidad.this.JBTAdicionarAccActionPerformed(evt);
            }
        });
        this.JSPDetalleAcc.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle1.setFont(new Font("Arial", 1, 12));
        this.JTDetalle1.setForeground(new Color(0, 0, 204));
        this.JTDetalle1.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalle1.setEditingColumn(2);
        this.JTDetalle1.setEditingRow(1);
        this.JTDetalle1.setGridColor(new Color(0, 0, 0));
        this.JTDetalle1.setRowHeight(25);
        this.JTDetalle1.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle1.setSelectionForeground(Color.blue);
        this.JTDetalle1.setSelectionMode(0);
        this.JTDetalle1.addMouseListener(new MouseAdapter() { // from class: Sgc.JIFRNoConfomidad.11
            public void mouseClicked(MouseEvent evt) {
                JIFRNoConfomidad.this.JTDetalle1MouseClicked(evt);
            }
        });
        this.JTDetalle1.addKeyListener(new KeyAdapter() { // from class: Sgc.JIFRNoConfomidad.12
            public void keyPressed(KeyEvent evt) {
                JIFRNoConfomidad.this.JTDetalle1KeyPressed(evt);
            }
        });
        this.JSPDetalleAcc.setViewportView(this.JTDetalle1);
        GroupLayout JPIAccionesLayout = new GroupLayout(this.JPIAcciones);
        this.JPIAcciones.setLayout(JPIAccionesLayout);
        JPIAccionesLayout.setHorizontalGroup(JPIAccionesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIAccionesLayout.createSequentialGroup().addContainerGap().addGroup(JPIAccionesLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSPDetalleAcc, GroupLayout.Alignment.LEADING, -1, 798, 32767).addComponent(this.JBTAdicionarAcc, GroupLayout.Alignment.LEADING, -1, 798, 32767).addGroup(GroupLayout.Alignment.LEADING, JPIAccionesLayout.createSequentialGroup().addComponent(this.JCBProcesoA, -2, 243, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBResponsable, 0, 415, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JDFechaEjec, -2, 120, -2)).addGroup(GroupLayout.Alignment.LEADING, JPIAccionesLayout.createSequentialGroup().addComponent(this.JCBTipoAc, -2, 176, -2).addGap(27, 27, 27).addComponent(this.JSPActividad, -1, 595, 32767))).addContainerGap()));
        JPIAccionesLayout.setVerticalGroup(JPIAccionesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIAccionesLayout.createSequentialGroup().addGroup(JPIAccionesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBTipoAc, -2, -1, -2).addComponent(this.JSPActividad, -2, 64, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIAccionesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIAccionesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBProcesoA, -2, -1, -2).addComponent(this.JCBResponsable, -2, -1, -2)).addComponent(this.JDFechaEjec, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTAdicionarAcc).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalleAcc, -1, 109, 32767)));
        this.JPIIntegrantes.setBorder(BorderFactory.createTitledBorder((Border) null, "INTEGRANTES", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JCBProcesoI.setFont(new Font("Arial", 1, 12));
        this.JCBProcesoI.setBorder(BorderFactory.createTitledBorder((Border) null, "Proceso", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBProcesoI.addItemListener(new ItemListener() { // from class: Sgc.JIFRNoConfomidad.13
            public void itemStateChanged(ItemEvent evt) {
                JIFRNoConfomidad.this.JCBProcesoIItemStateChanged(evt);
            }
        });
        this.JCBResponsableI.setFont(new Font("Arial", 1, 12));
        this.JCBResponsableI.setBorder(BorderFactory.createTitledBorder((Border) null, "Responsable", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBTAdicionarAcc1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTAdicionarAcc1.addActionListener(new ActionListener() { // from class: Sgc.JIFRNoConfomidad.14
            public void actionPerformed(ActionEvent evt) {
                JIFRNoConfomidad.this.JBTAdicionarAcc1ActionPerformed(evt);
            }
        });
        this.JSPDetalle2.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle2.setFont(new Font("Arial", 1, 12));
        this.JTDetalle2.setForeground(new Color(0, 0, 204));
        this.JTDetalle2.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalle2.setEditingColumn(2);
        this.JTDetalle2.setEditingRow(1);
        this.JTDetalle2.setGridColor(new Color(0, 0, 0));
        this.JTDetalle2.setRowHeight(25);
        this.JTDetalle2.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle2.setSelectionForeground(Color.blue);
        this.JTDetalle2.setSelectionMode(0);
        this.JTDetalle2.addKeyListener(new KeyAdapter() { // from class: Sgc.JIFRNoConfomidad.15
            public void keyPressed(KeyEvent evt) {
                JIFRNoConfomidad.this.JTDetalle2KeyPressed(evt);
            }
        });
        this.JSPDetalle2.setViewportView(this.JTDetalle2);
        GroupLayout JPIIntegrantesLayout = new GroupLayout(this.JPIIntegrantes);
        this.JPIIntegrantes.setLayout(JPIIntegrantesLayout);
        JPIIntegrantesLayout.setHorizontalGroup(JPIIntegrantesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIIntegrantesLayout.createSequentialGroup().addContainerGap(719, 32767).addComponent(this.JBTAdicionarAcc1, -2, 89, -2).addContainerGap()).addGroup(JPIIntegrantesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIIntegrantesLayout.createSequentialGroup().addContainerGap().addGroup(JPIIntegrantesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDetalle2, -1, 776, 32767).addGroup(JPIIntegrantesLayout.createSequentialGroup().addComponent(this.JCBProcesoI, -2, 243, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBResponsableI, -2, 420, -2))).addContainerGap())));
        JPIIntegrantesLayout.setVerticalGroup(JPIIntegrantesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIIntegrantesLayout.createSequentialGroup().addContainerGap().addComponent(this.JBTAdicionarAcc1, -2, 48, -2).addContainerGap(120, 32767)).addGroup(JPIIntegrantesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIIntegrantesLayout.createSequentialGroup().addContainerGap().addGroup(JPIIntegrantesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBProcesoI, -2, -1, -2).addComponent(this.JCBResponsableI, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalle2, -1, 101, 32767).addContainerGap())));
        GroupLayout JPIParteDosLayout = new GroupLayout(this.JPIParteDos);
        this.JPIParteDos.setLayout(JPIParteDosLayout);
        JPIParteDosLayout.setHorizontalGroup(JPIParteDosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIParteDosLayout.createSequentialGroup().addContainerGap().addGroup(JPIParteDosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JPIAcciones, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JPIIntegrantes, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addContainerGap()));
        JPIParteDosLayout.setVerticalGroup(JPIParteDosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIParteDosLayout.createSequentialGroup().addContainerGap().addComponent(this.JPIAcciones, -1, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPIIntegrantes, -2, -1, -2).addContainerGap()));
        this.JTPAnalisis.addTab("PLAN DE ACCIONES", this.JPIParteDos);
        this.JLBNAnalisis.setBackground(new Color(255, 255, 255));
        this.JLBNAnalisis.setFont(new Font("Arial", 1, 18));
        this.JLBNAnalisis.setForeground(Color.red);
        this.JLBNAnalisis.setHorizontalAlignment(0);
        this.JLBNAnalisis.setBorder(BorderFactory.createTitledBorder((Border) null, "N°", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JLBFechaAnalisis.setBackground(new Color(255, 255, 255));
        this.JLBFechaAnalisis.setFont(new Font("Arial", 1, 18));
        this.JLBFechaAnalisis.setForeground(Color.red);
        this.JLBFechaAnalisis.setHorizontalAlignment(0);
        this.JLBFechaAnalisis.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Análisis", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JPIDatosRSgc.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS CALIDAD", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JSPCorreoRSgc.setBorder(BorderFactory.createTitledBorder((Border) null, "Correo", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTACorreoR1.setFont(new Font("Arial", 1, 12));
        this.JSPCorreoRSgc.setViewportView(this.JTACorreoR1);
        this.JLEstadoRSgc.setBackground(new Color(255, 255, 255));
        this.JLEstadoRSgc.setFont(new Font("Arial", 1, 14));
        this.JLEstadoRSgc.setForeground(Color.red);
        this.JLEstadoRSgc.setHorizontalAlignment(0);
        this.JLEstadoRSgc.setBorder(BorderFactory.createEtchedBorder());
        this.JSPObservacionRSgc.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTAObservacionRSgc.setFont(new Font("Arial", 1, 12));
        this.JSPObservacionRSgc.setViewportView(this.JTAObservacionRSgc);
        this.JBGTipoAj.add(this.JCHAjustar);
        this.JCHAjustar.setFont(new Font("Arial", 1, 12));
        this.JCHAjustar.setText("Ajustar");
        this.JCHAjustar.addActionListener(new ActionListener() { // from class: Sgc.JIFRNoConfomidad.16
            public void actionPerformed(ActionEvent evt) {
                JIFRNoConfomidad.this.JCHAjustarActionPerformed(evt);
            }
        });
        this.JBGTipoAj.add(this.JCHCompletado);
        this.JCHCompletado.setFont(new Font("Arial", 1, 12));
        this.JCHCompletado.setSelected(true);
        this.JCHCompletado.setText("Conforme");
        this.JCHCompletado.addActionListener(new ActionListener() { // from class: Sgc.JIFRNoConfomidad.17
            public void actionPerformed(ActionEvent evt) {
                JIFRNoConfomidad.this.JCHCompletadoActionPerformed(evt);
            }
        });
        GroupLayout JPIDatosRSgcLayout = new GroupLayout(this.JPIDatosRSgc);
        this.JPIDatosRSgc.setLayout(JPIDatosRSgcLayout);
        JPIDatosRSgcLayout.setHorizontalGroup(JPIDatosRSgcLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosRSgcLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPCorreoRSgc, -2, 206, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPObservacionRSgc).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JLEstadoRSgc, -2, 98, -2).addGap(6, 6, 6).addGroup(JPIDatosRSgcLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHCompletado).addComponent(this.JCHAjustar)).addContainerGap()));
        JPIDatosRSgcLayout.setVerticalGroup(JPIDatosRSgcLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosRSgcLayout.createSequentialGroup().addGroup(JPIDatosRSgcLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPObservacionRSgc, GroupLayout.Alignment.TRAILING).addComponent(this.JSPCorreoRSgc, GroupLayout.Alignment.TRAILING).addComponent(this.JLEstadoRSgc, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosRSgcLayout.createSequentialGroup().addComponent(this.JCHAjustar).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JCHCompletado))).addContainerGap()));
        GroupLayout JPIAnalisisLayout = new GroupLayout(this.JPIAnalisis);
        this.JPIAnalisis.setLayout(JPIAnalisisLayout);
        JPIAnalisisLayout.setHorizontalGroup(JPIAnalisisLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIAnalisisLayout.createSequentialGroup().addContainerGap().addGroup(JPIAnalisisLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(GroupLayout.Alignment.LEADING, JPIAnalisisLayout.createSequentialGroup().addGroup(JPIAnalisisLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLBFechaAnalisis, -2, 112, -2).addComponent(this.JLBNAnalisis, -2, 112, -2)).addGap(18, 18, 18).addComponent(this.JPIDatosRSgc, -1, -1, 32767)).addComponent(this.JTPAnalisis, -2, 0, 32767)).addContainerGap()));
        JPIAnalisisLayout.setVerticalGroup(JPIAnalisisLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIAnalisisLayout.createSequentialGroup().addContainerGap().addComponent(this.JTPAnalisis, -2, 584, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIAnalisisLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPIAnalisisLayout.createSequentialGroup().addComponent(this.JLBFechaAnalisis, -2, 53, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLBNAnalisis, -2, 53, -2)).addComponent(this.JPIDatosRSgc, -1, -1, 32767)).addContainerGap(-1, 32767)));
        this.JTPRegistro.addTab("ANÁLISIS", this.JPIAnalisis);
        this.jPanel2.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JDFFechaInicio.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaInicio.setDateFormatString("dd/MM/yyyy");
        this.JDFFechaInicio.setFont(new Font("Arial", 1, 12));
        this.JDFFechaFin.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Fin", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaFin.setDateFormatString("dd/MM/yyyy");
        this.JDFFechaFin.setFont(new Font("Arial", 1, 12));
        this.JCHNc.setFont(new Font("Arial", 1, 12));
        this.JCHNc.setForeground(Color.blue);
        this.JCHNc.setText("No Conformidad");
        this.JCHNc.addActionListener(new ActionListener() { // from class: Sgc.JIFRNoConfomidad.18
            public void actionPerformed(ActionEvent evt) {
                JIFRNoConfomidad.this.JCHNcActionPerformed(evt);
            }
        });
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.JDFFechaInicio, -2, 120, -2).addGap(26, 26, 26).addComponent(this.JDFFechaFin, -2, 120, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 31, 32767).addComponent(this.JCHNc).addContainerGap()));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDFFechaInicio, -2, -1, -2).addComponent(this.JDFFechaFin, -2, -1, -2)).addGap(0, 0, 32767)).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.JCHNc).addContainerGap(-1, 32767)));
        this.JSPDetalleProcesoR.setBorder(BorderFactory.createTitledBorder((Border) null, "PROCESO QUE REPORTA", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JSPDetalleProcesoR.setFont(new Font("Arial", 1, 12));
        this.JTDetallePR.setFont(new Font("Arial", 1, 12));
        this.JTDetallePR.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetallePR.setRowHeight(25);
        this.JTDetallePR.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetallePR.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetallePR.setSelectionMode(0);
        this.JSPDetalleProcesoR.setViewportView(this.JTDetallePR);
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "RESUMEM", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JLTotalA.setFont(new Font("Arial", 1, 18));
        this.JLTotalA.setHorizontalAlignment(0);
        this.JLTotalA.setBorder(BorderFactory.createTitledBorder((Border) null, "Total Analizadas", 2, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JLTotalNA.setFont(new Font("Arial", 1, 18));
        this.JLTotalNA.setHorizontalAlignment(0);
        this.JLTotalNA.setBorder(BorderFactory.createTitledBorder((Border) null, "Total No Analizadas", 2, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JLTotal.setFont(new Font("Arial", 1, 18));
        this.JLTotal.setHorizontalAlignment(0);
        this.JLTotal.setBorder(BorderFactory.createTitledBorder((Border) null, "TOTAL", 2, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.JLTotalA, -2, 113, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLTotalNA, -1, 139, 32767).addGap(18, 18, 18).addComponent(this.JLTotal, -2, 93, -2)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLTotalA, -2, 49, -2).addComponent(this.JLTotalNA, -2, 49, -2).addComponent(this.JLTotal, -2, 49, -2)).addContainerGap(-1, 32767)));
        this.JSPDetalleOrigen.setBorder(BorderFactory.createTitledBorder((Border) null, "ORIGEN QUE REPORTA", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JSPDetalleOrigen.setFont(new Font("Arial", 1, 12));
        this.JTDetalleOrigen.setFont(new Font("Arial", 1, 12));
        this.JTDetalleOrigen.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalleOrigen.setRowHeight(25);
        this.JTDetalleOrigen.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalleOrigen.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalleOrigen.setSelectionMode(0);
        this.JSPDetalleOrigen.setViewportView(this.JTDetalleOrigen);
        this.JSPDetalleNC.setBorder(BorderFactory.createTitledBorder((Border) null, "TIPO DE NC", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JSPDetalleNC.setFont(new Font("Arial", 1, 12));
        this.JTDetalleNC.setFont(new Font("Arial", 1, 12));
        this.JTDetalleNC.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalleNC.setRowHeight(25);
        this.JTDetalleNC.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalleNC.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalleNC.setSelectionMode(0);
        this.JSPDetalleNC.setViewportView(this.JTDetalleNC);
        this.JBTGraficoOrigen.setFont(new Font("Arial", 1, 12));
        this.JBTGraficoOrigen.setForeground(Color.red);
        this.JBTGraficoOrigen.setIcon(new ImageIcon(getClass().getResource("/Imagenes/contabilidad.png")));
        this.JBTGraficoOrigen.setText("Gráfico");
        this.JBTGraficoOrigen.setName("BotonOrigenNC");
        this.JBTGraficoOrigen.addActionListener(new ActionListener() { // from class: Sgc.JIFRNoConfomidad.19
            public void actionPerformed(ActionEvent evt) {
                JIFRNoConfomidad.this.JBTGraficoOrigenActionPerformed(evt);
            }
        });
        this.JBTGraficoProceso.setFont(new Font("Arial", 1, 12));
        this.JBTGraficoProceso.setForeground(Color.red);
        this.JBTGraficoProceso.setIcon(new ImageIcon(getClass().getResource("/Imagenes/contabilidad.png")));
        this.JBTGraficoProceso.setText("Gráfico");
        this.JBTGraficoProceso.setName("BotonProcesoNC");
        this.JBTGraficoProceso.addActionListener(new ActionListener() { // from class: Sgc.JIFRNoConfomidad.20
            public void actionPerformed(ActionEvent evt) {
                JIFRNoConfomidad.this.JBTGraficoProcesoActionPerformed(evt);
            }
        });
        this.JBTGraficoNC.setFont(new Font("Arial", 1, 12));
        this.JBTGraficoNC.setForeground(Color.red);
        this.JBTGraficoNC.setIcon(new ImageIcon(getClass().getResource("/Imagenes/contabilidad.png")));
        this.JBTGraficoNC.setText("Gráfico");
        this.JBTGraficoNC.setName("BotonTipoNC");
        this.JBTGraficoNC.addActionListener(new ActionListener() { // from class: Sgc.JIFRNoConfomidad.21
            public void actionPerformed(ActionEvent evt) {
                JIFRNoConfomidad.this.JBTGraficoNCActionPerformed(evt);
            }
        });
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: Sgc.JIFRNoConfomidad.22
            public void mouseClicked(MouseEvent evt) {
                JIFRNoConfomidad.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setForeground(Color.red);
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/actualizar.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: Sgc.JIFRNoConfomidad.23
            public void actionPerformed(ActionEvent evt) {
                JIFRNoConfomidad.this.JBTExportarActionPerformed(evt);
            }
        });
        GroupLayout JPInformesLayout = new GroupLayout(this.JPInformes);
        this.JPInformes.setLayout(JPInformesLayout);
        JPInformesLayout.setHorizontalGroup(JPInformesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPInformesLayout.createSequentialGroup().addGroup(JPInformesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPInformesLayout.createSequentialGroup().addContainerGap().addComponent(this.jPanel2, -2, -1, -2).addGap(18, 18, 18).addComponent(this.jPanel1, -2, -1, -2)).addGroup(JPInformesLayout.createSequentialGroup().addGap(22, 22, 22).addGroup(JPInformesLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JSPDetalleNC, -1, 562, 32767).addComponent(this.JSPDetalleProcesoR, -1, 562, 32767).addComponent(this.JSPDetalleOrigen)).addGroup(JPInformesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPInformesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPInformesLayout.createSequentialGroup().addGap(18, 18, 18).addComponent(this.JBTGraficoOrigen, -2, 189, -2)).addGroup(GroupLayout.Alignment.TRAILING, JPInformesLayout.createSequentialGroup().addGap(18, 18, 18).addComponent(this.JBTGraficoProceso, -2, 189, -2))).addGroup(JPInformesLayout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPInformesLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JBTGraficoNC, -2, 189, -2).addComponent(this.JTFRuta).addComponent(this.JBTExportar, -1, 257, 32767)))))).addContainerGap(-1, 32767)));
        JPInformesLayout.setVerticalGroup(JPInformesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPInformesLayout.createSequentialGroup().addContainerGap().addGroup(JPInformesLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jPanel2, -1, -1, 32767).addComponent(this.jPanel1, -1, -1, 32767)).addGroup(JPInformesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPInformesLayout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalleOrigen, -1, 165, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)).addGroup(JPInformesLayout.createSequentialGroup().addGap(74, 74, 74).addComponent(this.JBTGraficoOrigen).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 69, 32767))).addGroup(JPInformesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPInformesLayout.createSequentialGroup().addComponent(this.JSPDetalleProcesoR, -1, 151, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)).addGroup(GroupLayout.Alignment.TRAILING, JPInformesLayout.createSequentialGroup().addComponent(this.JBTGraficoProceso).addGap(61, 61, 61))).addGroup(JPInformesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPInformesLayout.createSequentialGroup().addGap(8, 8, 8).addComponent(this.JBTGraficoNC).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFRuta, -2, 50, -2).addGap(18, 18, 18).addComponent(this.JBTExportar, -2, 50, -2)).addComponent(this.JSPDetalleNC, -2, 191, -2)).addContainerGap(88, 32767)));
        this.JTPRegistro.addTab("INFORMES", this.JPInformes);
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JDFechaEvidencia.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaEvidencia.setDateFormatString("dd/MM/yyyy");
        this.JDFechaEvidencia.setFont(new Font("Arial", 1, 12));
        this.JSPDescripcionEvidencia.setBorder(BorderFactory.createTitledBorder((Border) null, "Descripción", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTADescripcionEvidencia.setFont(new Font("Arial", 1, 12));
        this.JSPDescripcionEvidencia.setViewportView(this.JTADescripcionEvidencia);
        this.JTFRutaEvidencia.setFont(new Font("Arial", 1, 12));
        this.JTFRutaEvidencia.setBorder(BorderFactory.createTitledBorder((Border) null, "Ruta", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRutaEvidencia.addMouseListener(new MouseAdapter() { // from class: Sgc.JIFRNoConfomidad.24
            public void mouseClicked(MouseEvent evt) {
                JIFRNoConfomidad.this.JTFRutaEvidenciaMouseClicked(evt);
            }
        });
        this.JBTGrabarEvidencia.setFont(new Font("Arial", 1, 12));
        this.JBTGrabarEvidencia.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTGrabarEvidencia.setText("Grabar");
        this.JBTGrabarEvidencia.addActionListener(new ActionListener() { // from class: Sgc.JIFRNoConfomidad.25
            public void actionPerformed(ActionEvent evt) {
                JIFRNoConfomidad.this.JBTGrabarEvidenciaActionPerformed(evt);
            }
        });
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JBTGrabarEvidencia, -2, 832, -2).addGroup(GroupLayout.Alignment.LEADING, JPIDatosLayout.createSequentialGroup().addGap(2, 2, 2).addComponent(this.JDFechaEvidencia, -2, 116, -2).addGap(18, 18, 18).addComponent(this.JSPDescripcionEvidencia, -2, 314, -2).addGap(18, 18, 18).addComponent(this.JTFRutaEvidencia, -2, 364, -2))).addContainerGap(22, 32767)));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JDFechaEvidencia, -2, -1, -2).addComponent(this.JSPDescripcionEvidencia, -2, -1, -2).addComponent(this.JTFRutaEvidencia, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBTGrabarEvidencia, -2, 46, -2).addContainerGap(23, 32767)));
        this.JSPDetalleEvidencia.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JSPDetalleEvidencia.setFont(new Font("Arial", 1, 12));
        this.JTBDetalleEvidencia.setFont(new Font("Arial", 1, 12));
        this.JTBDetalleEvidencia.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTBDetalleEvidencia.setRowHeight(25);
        this.JTBDetalleEvidencia.setRowMargin(2);
        this.JTBDetalleEvidencia.setSelectionBackground(new Color(255, 255, 255));
        this.JTBDetalleEvidencia.setSelectionForeground(Color.red);
        this.JTBDetalleEvidencia.addMouseListener(new MouseAdapter() { // from class: Sgc.JIFRNoConfomidad.26
            public void mouseClicked(MouseEvent evt) {
                JIFRNoConfomidad.this.JTBDetalleEvidenciaMouseClicked(evt);
            }
        });
        this.JSPDetalleEvidencia.setViewportView(this.JTBDetalleEvidencia);
        GroupLayout JPI_EvidenciaLayout = new GroupLayout(this.JPI_Evidencia);
        this.JPI_Evidencia.setLayout(JPI_EvidenciaLayout);
        JPI_EvidenciaLayout.setHorizontalGroup(JPI_EvidenciaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_EvidenciaLayout.createSequentialGroup().addContainerGap().addGroup(JPI_EvidenciaLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JSPDetalleEvidencia).addComponent(this.JPIDatos, -1, -1, 32767)).addContainerGap(11, 32767)));
        JPI_EvidenciaLayout.setVerticalGroup(JPI_EvidenciaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_EvidenciaLayout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPDetalleEvidencia, -1, 498, 32767).addGap(44, 44, 44)));
        this.JTPRegistro.addTab("EVIDENCIA", this.JPI_Evidencia);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTPRegistro, -2, 892, -2).addContainerGap(-1, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTPRegistro, -2, 746, -2).addContainerGap(-1, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTProcesoItemStateChanged(ItemEvent evt) {
        if (this.xlleno && this.JCBTProceso.getSelectedIndex() != -1) {
            ConsultasMySQL xct1 = new ConsultasMySQL();
            this.JCBProceso.removeAllItems();
            this.xidproceso = xct1.llenarComboyLista("SELECT Id, Nbre, correo FROM s_sgc_tipoproceso WHERE (Id_Proceso ='" + this.xidtipop[this.JCBTProceso.getSelectedIndex()] + "' AND Estado =1) ORDER BY Nbre ASC", this.xidproceso, this.JCBProceso, 3);
            if (this.JCBProceso.getItemCount() > 1) {
                this.JCBProceso.setSelectedIndex(-1);
            } else {
                this.JCBProceso.setSelectedIndex(0);
            }
            xct1.cerrarConexionBd();
            this.xlleno1 = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTipoIItemStateChanged(ItemEvent evt) {
        if (this.xlleno && this.JCBTipoI.getSelectedIndex() != -1) {
            ConsultasMySQL xct1 = new ConsultasMySQL();
            this.JCBDetalleInc.removeAllItems();
            this.xsql = "SELECT s_sgc_tincumplimiento_detalle.Id, s_sgc_tipoincumplimiento_detalle.Nbre FROM s_sgc_tincumplimiento_detalle INNER JOIN s_sgc_tipoincumplimiento_detalle  ON (s_sgc_tincumplimiento_detalle.Id_TipoIncumpDetalle = s_sgc_tipoincumplimiento_detalle.Id) WHERE (s_sgc_tincumplimiento_detalle.Estado =1 AND s_sgc_tincumplimiento_detalle.Id_TipoIncumplimiento ='" + this.xidtipoinc[this.JCBTipoI.getSelectedIndex()] + "') ORDER BY s_sgc_tipoincumplimiento_detalle.Nbre ASC ";
            this.xiddetalleinc = xct1.llenarCombo(this.xsql, this.xiddetalleinc, this.JCBDetalleInc);
            if (this.JCBDetalleInc.getItemCount() > 1) {
                this.JCBDetalleInc.setSelectedIndex(-1);
            } else {
                this.JCBDetalleInc.setSelectedIndex(0);
            }
            xct1.cerrarConexionBd();
            this.xlleno1 = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTAdicionarIActionPerformed(ActionEvent evt) {
        if (this.JCBTipoI.getSelectedIndex() != -1) {
            if (this.JCBDetalleInc.getSelectedIndex() != -1) {
                this.xnfila++;
                this.xmodelo.addRow(this.xdato);
                this.xmodelo.setValueAt(Long.valueOf(this.xiddetalleinc[this.JCBDetalleInc.getSelectedIndex()]), this.xnfila, 0);
                this.xmodelo.setValueAt(this.JCBTipoI.getSelectedItem().toString(), this.xnfila, 1);
                this.xmodelo.setValueAt(this.JCBDetalleInc.getSelectedItem().toString(), this.xnfila, 2);
                this.xmodelo.setValueAt(this.JTAObservacionInc.getText(), this.xnfila, 3);
                this.JCBDetalleInc.setSelectedIndex(-1);
                this.JCBTipoI.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un detalle de incumplimiento", "VERIFICAR", 1);
            this.JCBDetalleInc.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un tipo de incumplimiento", "VERIFICAR", 1);
        this.JCBTipoI.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleKeyPressed(KeyEvent evt) {
        if (Principal.txtNo.getText().isEmpty() && evt.getKeyCode() == 127 && this.JTDetalle.getSelectedRow() != -1) {
            int x = JOptionPane.showInternalConfirmDialog(this, "Desea eliminar la fila seleccionada?", "ELIMINAR", 0, 3);
            if (x == 0) {
                this.xmodelo.removeRow(this.JTDetalle.getSelectedRow());
                this.xnfila--;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        if (!getName().equals("xjifreportenc3")) {
            Principal.mLimpiarDatosP();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEsNCActionPerformed(ActionEvent evt) {
        if (this.JCHEsNC.isSelected()) {
            this.xesnc = 1;
        } else {
            this.xesnc = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBProcesoRItemStateChanged(ItemEvent evt) {
        if (this.xlleno && this.JCBProcesoR.getSelectedIndex() != -1) {
            this.JTACorreoR.setText(this.xidprocesor[this.JCBProcesoR.getSelectedIndex()][1]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBProcesoAItemStateChanged(ItemEvent evt) {
        if (this.xlleno && this.JCBProcesoA.getSelectedIndex() != -1) {
            ConsultasMySQL xct1 = new ConsultasMySQL();
            this.JCBResponsable.removeAllItems();
            this.xsql = "SELECT rh_tipo_persona_cargon.Id, persona.NUsuario, persona.Corre FROM persona INNER JOIN rh_tipo_persona_cargon  ON (persona.Id_persona = rh_tipo_persona_cargon.Id_Persona) INNER JOIN s_sgc_usuario_tipoproceso  ON (s_sgc_usuario_tipoproceso.Id_Usuario = persona.Id_persona) WHERE (s_sgc_usuario_tipoproceso.Id_TipoProceso ='" + this.xidprocesoa[this.JCBProcesoA.getSelectedIndex()] + "') ORDER BY persona.NUsuario ASC ";
            this.xidresponsable = xct1.llenarComboyLista(this.xsql, this.xidresponsable, this.JCBResponsable, 3);
            xct1.cerrarConexionBd();
            this.JCBResponsable.setSelectedIndex(-1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBProcesoIItemStateChanged(ItemEvent evt) {
        if (this.xlleno && this.JCBProcesoI.getSelectedIndex() != -1) {
            ConsultasMySQL xct1 = new ConsultasMySQL();
            this.JCBResponsableI.removeAllItems();
            this.xsql = "SELECT rh_tipo_persona_cargon.Id, persona.NUsuario, persona.Corre FROM persona INNER JOIN rh_tipo_persona_cargon  ON (persona.Id_persona = rh_tipo_persona_cargon.Id_Persona) INNER JOIN s_sgc_usuario_tipoproceso  ON (s_sgc_usuario_tipoproceso.Id_Usuario = persona.Id_persona) WHERE (s_sgc_usuario_tipoproceso.Id_TipoProceso ='" + this.xidprocesoa[this.JCBProcesoI.getSelectedIndex()] + "') ORDER BY persona.NUsuario ASC ";
            this.xidresponsable1 = xct1.llenarComboyLista(this.xsql, this.xidresponsable1, this.JCBResponsableI, 3);
            xct1.cerrarConexionBd();
            this.JCBResponsableI.setSelectedIndex(-1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTAdicionarAccActionPerformed(ActionEvent evt) {
        if (this.JLBNAnalisis.getText().isEmpty()) {
            if (this.JCBTipoAc.getSelectedIndex() != -1) {
                if (!this.JTAActividad.getText().isEmpty()) {
                    if (this.JCBResponsable.getSelectedIndex() != -1) {
                        this.xnfila1++;
                        this.xmodelo1.addRow(this.xdato);
                        this.xmodelo1.setValueAt(Long.valueOf(this.xidtipoaccion[this.JCBTipoAc.getSelectedIndex()]), this.xnfila1, 0);
                        this.xmodelo1.setValueAt(this.JCBTipoAc.getSelectedItem().toString(), this.xnfila1, 1);
                        this.xmodelo1.setValueAt(this.JTAActividad.getText(), this.xnfila1, 2);
                        this.xmodelo1.setValueAt(this.xidprocesoa[this.JCBProcesoA.getSelectedIndex()], this.xnfila1, 3);
                        this.xmodelo1.setValueAt(this.xidresponsable[this.JCBResponsable.getSelectedIndex()][0], this.xnfila1, 4);
                        this.xmodelo1.setValueAt(this.JCBResponsable.getSelectedItem(), this.xnfila1, 5);
                        this.xmodelo1.setValueAt(this.xmt.formatoDMA.format(this.JDFechaEjec.getDate()), this.xnfila1, 6);
                        this.xmodelo1.setValueAt(this.xidresponsable[this.JCBResponsable.getSelectedIndex()][1], this.xnfila1, 7);
                        this.JCBTipoAc.setSelectedIndex(-1);
                        this.JTAActividad.setText("");
                        this.JCBResponsable.removeAllItems();
                        this.JCBProcesoA.setSelectedIndex(-1);
                        this.JDFechaEjec.setDate(this.xmt.getFechaActual());
                        this.JCBTipoAc.requestFocus();
                        return;
                    }
                    JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un responsable", "VERIFICAR", 1);
                    this.JCBResponsable.requestFocus();
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Debe digitar la actividad", "VERIFICAR", 1);
                this.JTAActividad.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un tipo de acción", "VERIFICAR", 1);
            this.JCBTipoAc.requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTAdicionarAcc1ActionPerformed(ActionEvent evt) {
        if (this.JCBProcesoI.getSelectedIndex() != -1) {
            if (this.JCBResponsableI.getSelectedIndex() != -1) {
                this.xnfila2++;
                this.xmodelo2.addRow(this.xdato);
                this.xmodelo2.setValueAt(Long.valueOf(this.xidtipoprocesoint[this.JCBProcesoI.getSelectedIndex()]), this.xnfila2, 0);
                this.xmodelo2.setValueAt(this.JCBProcesoI.getSelectedItem().toString(), this.xnfila2, 1);
                this.xmodelo2.setValueAt(Long.valueOf(this.xidresponsable1[this.JCBResponsableI.getSelectedIndex()][0]), this.xnfila2, 2);
                this.xmodelo2.setValueAt(this.JCBResponsableI.getSelectedItem(), this.xnfila2, 3);
                this.JCBResponsableI.removeAllItems();
                this.JCBProcesoI.setSelectedIndex(-1);
                this.JCBProcesoI.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe selecionar el integrante", "VERIFICAR", 1);
            this.JCBResponsableI.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un tipo proceso", "VERIFICAR", 1);
        this.JCBProcesoI.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalle1KeyPressed(KeyEvent evt) {
        if (this.JLBNAnalisis.getText().isEmpty() && evt.getKeyCode() == 127 && this.JTDetalle1.getSelectedRow() != -1) {
            int x = JOptionPane.showInternalConfirmDialog(this, "Desea eliminar la fila seleccionada?", "ELIMINAR", 0, 3);
            if (x == 0) {
                this.xmodelo1.removeRow(this.JTDetalle1.getSelectedRow());
                this.xnfila1--;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalle2KeyPressed(KeyEvent evt) {
        if (this.JLBNAnalisis.getText().isEmpty() && evt.getKeyCode() == 127 && this.JTDetalle2.getSelectedRow() != -1) {
            int x = JOptionPane.showInternalConfirmDialog(this, "Desea eliminar la fila seleccionada?", "ELIMINAR", 0, 3);
            if (x == 0) {
                this.xmodelo2.removeRow(this.JTDetalle2.getSelectedRow());
                this.xnfila2--;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHAjustarActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHCompletadoActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalle1MouseClicked(MouseEvent evt) {
        if (this.JTDetalle1.getSelectedRow() != -1 && !this.JLBNAnalisis.getText().isEmpty()) {
            this.JTAActividad.setText(this.xmodelo1.getValueAt(this.JTDetalle1.getSelectedRow(), 2).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGrabarIActionPerformed(ActionEvent evt) {
        if (!Principal.txtNo.getText().isEmpty()) {
            int y = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 3);
            if (y == 0) {
                for (int x = 0; x < this.JTDetalle.getRowCount(); x++) {
                    this.xsql = "insert into s_sgc_ncregistro_incumplimiento (Id_ncregistro, Id_tincumplimientodet, Observacion ) values('" + Principal.txtNo.getText() + "','" + this.xmodelo.getValueAt(x, 0) + "','" + this.xmodelo.getValueAt(x, 3) + "')";
                    this.xct.ejecutarSQL(this.xsql);
                    this.xct.cerrarConexionBd();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHNcActionPerformed(ActionEvent evt) {
        if (this.JCHNc.isSelected()) {
            this.xidnc = 1L;
        } else {
            this.xidnc = 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGraficoOrigenActionPerformed(ActionEvent evt) {
        JFGraficoBarra demo = new JFGraficoBarra("Gráfica de tipo de Origen", "TIPO DE ORIGEN ENTRE " + this.xmt.formatoDMA.format(this.JDFFechaInicio.getDate()) + " y " + this.xmt.formatoDMA.format(this.JDFFechaFin.getDate()) + "", "BotonOrigenNC", this, "Tipo de Origen", "Cantidad");
        demo.pack();
        demo.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGraficoProcesoActionPerformed(ActionEvent evt) {
        JFGraficoBarra demo = new JFGraficoBarra("Gráfica de tipo de Proceso", "TIPO DE PROCESO ENTRE " + this.xmt.formatoDMA.format(this.JDFFechaInicio.getDate()) + " y " + this.xmt.formatoDMA.format(this.JDFFechaFin.getDate()) + "", "BotonProcesoNC", this, "Tipo de Proceso", "Cantidad");
        demo.pack();
        demo.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGraficoNCActionPerformed(ActionEvent evt) {
        JFGraficoBarra demo = new JFGraficoBarra("Gráfica de tipo de No Conformidad", "TIPO DE NO CONFORMIDAD ENTRE " + this.xmt.formatoDMA.format(this.JDFFechaInicio.getDate()) + " y " + this.xmt.formatoDMA.format(this.JDFFechaFin.getDate()) + "", "BotonTipoNC", this, "Tipo de No Conformidad", "Cantidad");
        demo.pack();
        demo.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JFileChooser xfilec = new JFileChooser(this.JTFRuta.getText());
            xfilec.setFileSelectionMode(1);
            int xv = xfilec.showOpenDialog(this);
            if (xv == 0) {
                File xfile = xfilec.getSelectedFile();
                this.JTFRuta.setText(xfile.getAbsolutePath() + this.xmt.getBarra());
                this.JTFRuta.requestFocus();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTExportarActionPerformed(ActionEvent evt) {
        if (!this.JTFRuta.getText().isEmpty()) {
            if (this.JTDetalleOrigen.getRowCount() > -1) {
                mExportar();
                return;
            } else {
                JOptionPane.showInternalMessageDialog(this, "No existe información para exportar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                return;
            }
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un ruta valida", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        this.JTFRuta.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaEvidenciaMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JFileChooser xfilec = new JFileChooser("S:\\Soportes acciones 5W1H\\");
            int xv = xfilec.showOpenDialog(this);
            if (xv == 0) {
                this.xfile = xfilec.getSelectedFile();
                System.out.println(this.xfile.getAbsolutePath());
                this.JTFRutaEvidencia.setText(this.xfile.getAbsolutePath());
                this.JTFRutaEvidencia.setText(this.xmt.mTraerUrlBD(this.xfile.getAbsolutePath()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGrabarEvidenciaActionPerformed(ActionEvent evt) {
        if (!Principal.txtNo.getText().isEmpty()) {
            if (!this.JTADescripcionEvidencia.getText().isEmpty()) {
                if (!this.JTFRutaEvidencia.getText().isEmpty()) {
                    this.xsql = "Insert into s_sgc_nregistro_evidencia (`Id_ncregistro` , `FechaE` , `Nbre` , `Url` , `UsuarioS` , `Id_UsuarioS` ) values('" + Principal.txtNo.getText() + "','" + this.xmt.formatoAMD.format(this.JDFechaEvidencia.getDate()) + "','" + this.JTADescripcionEvidencia.getText() + "','" + this.JTFRutaEvidencia.getText() + "','" + Principal.usuarioSistemaDTO.getLogin() + "','" + Principal.usuarioSistemaDTO.getIdPersonaCargo() + "')";
                    this.xct.ejecutarSQL(this.xsql);
                    this.xct.cerrarConexionBd();
                    mBucarEvidencias();
                    this.JDFechaEvidencia.setDate(this.xmt.getFechaActual());
                    this.JTADescripcionEvidencia.setText("");
                    this.JTFRutaEvidencia.setText("");
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar la ruta del archivo", "VERIFICAR", 1);
                this.JTFRutaEvidencia.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe registrar la descripción", "VERIFICAR", 1);
            this.JTADescripcionEvidencia.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una acción", "VERIFICAR", 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBDetalleEvidenciaMouseClicked(MouseEvent evt) {
        if (this.JTBDetalleEvidencia.getSelectedRow() != -1) {
            this.xmt.mostrarPdf(this.xmodeloevidencia.getValueAt(this.JTBDetalleEvidencia.getSelectedRow(), 3).toString());
        }
    }

    private void mExportar() {
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            try {
                WritableWorkbook workbook = Workbook.createWorkbook(new File(this.JTFRuta.getText() + ".xls"));
                WritableSheet sheet = workbook.createSheet("Tipo de Origen", 0);
                for (int x = 0; x < this.JTDetalleOrigen.getColumnCount(); x++) {
                    sheet.addCell(new Label(x, 0, this.JTDetalleOrigen.getColumnName(x)));
                }
                for (int x2 = 0; x2 < this.JTDetalleOrigen.getRowCount(); x2++) {
                    sheet.addCell(new Label(1, x2 + 1, this.xmodeloorigen.getValueAt(x2, 1).toString()));
                    sheet.addCell(new Number(2, x2 + 1, Integer.valueOf(this.xmodeloorigen.getValueAt(x2, 2).toString()).intValue()));
                    sheet.addCell(new Number(3, x2 + 1, Integer.valueOf(this.xmodeloorigen.getValueAt(x2, 3).toString()).intValue()));
                    sheet.addCell(new Number(4, x2 + 1, Integer.valueOf(this.xmodeloorigen.getValueAt(x2, 4).toString()).intValue()));
                }
                WritableSheet sheet2 = workbook.createSheet("Tipo de Proceso", 1);
                for (int x3 = 0; x3 < this.JTDetallePR.getColumnCount(); x3++) {
                    sheet2.addCell(new Label(x3, 0, this.JTDetallePR.getColumnName(x3)));
                }
                for (int x4 = 0; x4 < this.JTDetallePR.getRowCount(); x4++) {
                    sheet2.addCell(new Label(1, x4 + 1, this.xmodeloproceso.getValueAt(x4, 1).toString()));
                    sheet2.addCell(new Label(2, x4 + 1, this.xmodeloproceso.getValueAt(x4, 2).toString()));
                    sheet2.addCell(new Number(3, x4 + 1, Integer.valueOf(this.xmodeloproceso.getValueAt(x4, 3).toString()).intValue()));
                    sheet2.addCell(new Number(4, x4 + 1, Integer.valueOf(this.xmodeloproceso.getValueAt(x4, 4).toString()).intValue()));
                    sheet2.addCell(new Number(5, x4 + 1, Integer.valueOf(this.xmodeloproceso.getValueAt(x4, 5).toString()).intValue()));
                }
                WritableSheet sheet3 = workbook.createSheet("Tipo No Conformidad", 2);
                for (int x5 = 0; x5 < this.JTDetalleNC.getColumnCount(); x5++) {
                    sheet3.addCell(new Label(x5, 0, this.JTDetalleNC.getColumnName(x5)));
                }
                for (int x6 = 0; x6 < this.JTDetalleNC.getRowCount(); x6++) {
                    System.out.println(" nFilas " + x6);
                    sheet3.addCell(new Label(1, x6 + 1, this.xmodeloNC.getValueAt(x6, 1).toString()));
                    sheet3.addCell(new Number(2, x6 + 1, Integer.valueOf(this.xmodeloNC.getValueAt(x6, 2).toString()).intValue()));
                    sheet3.addCell(new Number(3, x6 + 1, Integer.valueOf(this.xmodeloNC.getValueAt(x6, 3).toString()).intValue()));
                    sheet3.addCell(new Number(4, x6 + 1, Integer.valueOf(this.xmodeloNC.getValueAt(x6, 4).toString()).intValue()));
                }
                workbook.write();
                workbook.close();
            } catch (IOException ex) {
                Logger.getLogger(JIFRNoConfomidad.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            } catch (WriteException e) {
                Logger.getLogger(JIFRNoConfomidad.class.getName()).log(Level.SEVERE, (String) null, e);
            }
        }
    }

    public void mNuevo() {
        if (this.xmodulo != 2) {
            Principal.mLimpiarDatosP();
        }
        this.xlleno = false;
        this.xesnc = 0;
        this.xlleno1 = false;
        this.xidactividad = 1L;
        this.xnfila = -1;
        this.JDFecha.setDate(this.xmt.getFechaActual());
        this.JDFecha.setEnabled(false);
        this.JCBProceso.removeAllItems();
        this.JCBTProceso.removeAllItems();
        this.JCBDetalleInc.removeAllItems();
        this.xidtipop = this.xct.llenarCombo("SELECT Id , Nbre FROM s_sgc_procesos WHERE (Estado =1) ORDER BY Nbre ASC", this.xidtipop, this.JCBTProceso);
        this.JCBTProceso.setSelectedIndex(-1);
        this.xct.cerrarConexionBd();
        this.JCBTipo.removeAllItems();
        this.xidtipo = this.xct.llenarCombo("SELECT Id, Nbre FROM s_sgc_nctipo WHERE (Estado =1) ORDER BY Nbre ASC", this.xidtipo, this.JCBTipo);
        this.JCBTipo.setSelectedIndex(-1);
        this.xct.cerrarConexionBd();
        this.JCBTOrigen.removeAllItems();
        this.xidorigen = this.xct.llenarCombo("SELECT Id, Nbre FROM s_sgc_ncorigen WHERE (Estado =1) ORDER BY Nbre ASC", this.xidorigen, this.JCBTOrigen);
        this.JCBTOrigen.setSelectedIndex(-1);
        this.xct.cerrarConexionBd();
        this.JCBTipoI.removeAllItems();
        this.xidtipoinc = this.xct.llenarCombo("SELECT Id, Nbre FROM s_sgc_tipoincumplimiento WHERE (Estado =1) ORDER BY Nbre ASC", this.xidtipoinc, this.JCBTipoI);
        this.JCBTipoI.setSelectedIndex(-1);
        this.xct.cerrarConexionBd();
        this.JCBProcesoR.removeAllItems();
        if (this.xmodulo == 0) {
            this.xsql = "SELECT s_sgc_tipoproceso.Id, s_sgc_tipoproceso.Nbre, s_sgc_tipoproceso.Correo FROM s_sgc_usuario_tipoproceso INNER JOIN s_sgc_tipoproceso ON (s_sgc_usuario_tipoproceso.Id_TipoProceso = s_sgc_tipoproceso.Id) WHERE (s_sgc_usuario_tipoproceso.Estado =1 AND s_sgc_usuario_tipoproceso.Id_Usuario ='" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "') ORDER BY s_sgc_tipoproceso.Nbre ASC ";
        } else {
            this.xsql = "SELECT s_sgc_tipoproceso.Id, s_sgc_tipoproceso.Nbre, s_sgc_tipoproceso.Correo FROM s_sgc_usuario_tipoproceso INNER JOIN s_sgc_tipoproceso ON (s_sgc_usuario_tipoproceso.Id_TipoProceso = s_sgc_tipoproceso.Id) WHERE (s_sgc_usuario_tipoproceso.Estado =1 ) ORDER BY s_sgc_tipoproceso.Nbre ASC ";
        }
        this.xidprocesor = this.xct.llenarComboyLista(this.xsql, this.xidprocesor, this.JCBProcesoR, 3);
        this.xct.cerrarConexionBd();
        if (this.JCBProcesoR.getItemCount() > 1) {
            this.JCBProcesoR.setSelectedIndex(-1);
        } else {
            this.JCBProcesoR.setSelectedIndex(0);
            this.JTACorreoR.setText(this.xidprocesor[this.JCBProcesoR.getSelectedIndex()][1]);
        }
        this.JCHEsNC.setSelected(false);
        if (this.xmodulo == 0) {
            this.JPIDatosC.setVisible(false);
            this.JTPRegistro.setEnabledAt(1, true);
            this.JPIDatosRSgc.setVisible(false);
        } else {
            this.JPIDatosC.setVisible(true);
            this.JTPRegistro.setEnabledAt(1, true);
            this.JPIDatosRSgc.setVisible(true);
        }
        mLimpiarDatosAnalisis();
        this.xlleno = true;
        this.xct.cerrarConexionBd();
        this.JTADescripcion.setText("");
        this.JTAAccionImediata.setText("");
        this.JTAObservacionInc.setText("");
        this.JCHCompletado.setSelected(true);
        this.JLEstadoRSgc.setText("");
        this.JTAObservacionRSgc.setText("");
        mCrearTablaDetalle();
        mNuevoEvidencia();
        this.JDFecha.requestFocus();
        this.JDFFechaInicio.setDate(this.xmt.getFechaActual());
        this.JDFFechaFin.setDate(this.xmt.getFechaActual());
    }

    private void mLimpiarDatosAnalisis() {
        this.JTAManoObra.setText("N/A");
        this.JTAMaquina.setText("N/A");
        this.JTAMaterial.setText("N/A");
        this.JTAMedioAmb.setText("N/A");
        this.JTAMetodo.setText("N/A");
        this.JTAActividad.setText("");
        this.JDFechaEjec.setDate(this.xmt.getFechaActual());
        this.JCBResponsable.removeAllItems();
        this.JCBProcesoA.removeAllItems();
        this.xidprocesoa = this.xct.llenarCombo("SELECT Id, Nbre FROM s_sgc_tipoproceso WHERE (Estado =1) ORDER BY Nbre ASC", this.xidprocesoa, this.JCBProcesoA);
        this.JCBProcesoA.setSelectedIndex(-1);
        this.JCBTipoAc.removeAllItems();
        this.xidtipoaccion = this.xct.llenarCombo("SELECT Id, Nbre FROM s_sgc_tipo_accion WHERE (Estado =1) ORDER BY Nbre ASC", this.xidtipoaccion, this.JCBTipoAc);
        this.JCBTipoAc.setSelectedIndex(-1);
        this.JCBProcesoI.removeAllItems();
        this.xidtipoprocesoint = this.xct.llenarCombo("SELECT Id, Nbre FROM s_sgc_tipoproceso WHERE (Estado =1) ORDER BY Nbre ASC", this.xidtipoprocesoint, this.JCBProcesoI);
        this.JCBProcesoI.setSelectedIndex(-1);
        mCrearTablaDetalle1();
        mCrearTablaDetalle2();
        this.JLBNAnalisis.setText("");
        this.xnfila1 = -1;
        this.xnfila2 = -1;
        this.xct.cerrarConexionBd();
    }

    private void mCrearTablaEvidencia() {
        this.xmodeloevidencia = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Fecha", "Descripción", "Url"}) { // from class: Sgc.JIFRNoConfomidad.27
            Class[] types = {Long.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBDetalleEvidencia.setModel(this.xmodeloevidencia);
        this.JTBDetalleEvidencia.getColumnModel().getColumn(0).setPreferredWidth(5);
        this.JTBDetalleEvidencia.getColumnModel().getColumn(1).setPreferredWidth(10);
        this.JTBDetalleEvidencia.getColumnModel().getColumn(2).setPreferredWidth(400);
        this.JTBDetalleEvidencia.getColumnModel().getColumn(3).setPreferredWidth(0);
        this.JTBDetalleEvidencia.getColumnModel().getColumn(3).setMinWidth(0);
        this.JTBDetalleEvidencia.getColumnModel().getColumn(3).setMaxWidth(0);
    }

    private void mCrearTablaDetalle() {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Incumplimiento", "Detalle", "Observación"}) { // from class: Sgc.JIFRNoConfomidad.28
            Class[] types = {Long.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(120);
    }

    private void mCrearTablaDetalle1() {
        this.xmodelo1 = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Tipo", "Actividad", "IdTipoProceso", "IdResponsable", "Responsable", "Fecha", "Correo", "F5w1h", "N° Ficha"}) { // from class: Sgc.JIFRNoConfomidad.29
            Class[] types = {Long.class, String.class, String.class, Long.class, Long.class, String.class, String.class, String.class, Boolean.class, Long.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, true, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return this.canEdit[colIndex];
            }
        };
        this.JTDetalle1.setModel(this.xmodelo1);
        this.JTDetalle1.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTDetalle1.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTDetalle1.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTDetalle1.getColumnModel().getColumn(1).setPreferredWidth(50);
        this.JTDetalle1.getColumnModel().getColumn(2).setPreferredWidth(200);
        this.JTDetalle1.getColumnModel().getColumn(3).setPreferredWidth(0);
        this.JTDetalle1.getColumnModel().getColumn(3).setMinWidth(0);
        this.JTDetalle1.getColumnModel().getColumn(3).setMaxWidth(0);
        this.JTDetalle1.getColumnModel().getColumn(4).setPreferredWidth(0);
        this.JTDetalle1.getColumnModel().getColumn(4).setMinWidth(0);
        this.JTDetalle1.getColumnModel().getColumn(4).setMaxWidth(0);
        this.JTDetalle1.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTDetalle1.getColumnModel().getColumn(6).setPreferredWidth(30);
        this.JTDetalle1.getColumnModel().getColumn(7).setPreferredWidth(0);
        this.JTDetalle1.getColumnModel().getColumn(7).setMinWidth(0);
        this.JTDetalle1.getColumnModel().getColumn(7).setMaxWidth(0);
        if (this.xmodulo == 0) {
            this.JTDetalle1.getColumnModel().getColumn(8).setPreferredWidth(0);
            this.JTDetalle1.getColumnModel().getColumn(8).setMinWidth(0);
            this.JTDetalle1.getColumnModel().getColumn(8).setMaxWidth(0);
        } else {
            this.JTDetalle1.getColumnModel().getColumn(8).setPreferredWidth(10);
        }
        this.JTDetalle1.getColumnModel().getColumn(9).setPreferredWidth(5);
        this.xnfila1 = -1;
    }

    private void mCrearTablaDetalle2() {
        this.xmodelo2 = new DefaultTableModel((Object[][]) null, new String[]{"IdTipoProceso", "Proceso", "IdAsistente", "Asistente"}) { // from class: Sgc.JIFRNoConfomidad.30
            Class[] types = {Long.class, String.class, Long.class, String.class};
            boolean[] canEdit = {false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.JTDetalle2.setModel(this.xmodelo2);
        this.JTDetalle2.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTDetalle2.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTDetalle2.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTDetalle2.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDetalle2.getColumnModel().getColumn(2).setPreferredWidth(0);
        this.JTDetalle2.getColumnModel().getColumn(2).setMinWidth(0);
        this.JTDetalle2.getColumnModel().getColumn(2).setMaxWidth(0);
        this.JTDetalle2.getColumnModel().getColumn(3).setPreferredWidth(200);
        this.xnfila2 = -1;
    }

    private void mCrearTablaProceso() {
        this.xmodeloproceso = new DefaultTableModel((Object[][]) null, new String[]{"IdTipoProceso", "SubProceso", "Proceso", "Analizados", "No Analizados", "Total"}) { // from class: Sgc.JIFRNoConfomidad.31
            Class[] types = {Integer.class, String.class, String.class, Integer.class, Integer.class, Double.class};
            boolean[] canEdit = {false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.JTDetallePR.setModel(this.xmodeloproceso);
        this.JTDetallePR.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTDetallePR.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTDetallePR.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTDetallePR.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDetallePR.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetallePR.getColumnModel().getColumn(3).setPreferredWidth(10);
        this.JTDetallePR.getColumnModel().getColumn(4).setPreferredWidth(10);
        this.JTDetallePR.getColumnModel().getColumn(5).setPreferredWidth(10);
    }

    private void mCrearTablaOrigen() {
        this.xmodeloorigen = new DefaultTableModel((Object[][]) null, new String[]{"Idorigen", "Origen", "Analizados", "No Analizados", "Total"}) { // from class: Sgc.JIFRNoConfomidad.32
            Class[] types = {Integer.class, String.class, Integer.class, Integer.class, Double.class};
            boolean[] canEdit = {false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.JTDetalleOrigen.setModel(this.xmodeloorigen);
        this.JTDetalleOrigen.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTDetalleOrigen.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTDetalleOrigen.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTDetalleOrigen.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDetalleOrigen.getColumnModel().getColumn(2).setPreferredWidth(10);
        this.JTDetalleOrigen.getColumnModel().getColumn(3).setPreferredWidth(10);
        this.JTDetalleOrigen.getColumnModel().getColumn(4).setPreferredWidth(10);
    }

    private void mCrearTablaTipoNC() {
        this.xmodeloNC = new DefaultTableModel((Object[][]) null, new String[]{"IdNC", "Tipo NC", "Analizados", "No Analizados", "Total"}) { // from class: Sgc.JIFRNoConfomidad.33
            Class[] types = {Integer.class, String.class, Integer.class, Integer.class, Double.class};
            boolean[] canEdit = {false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.JTDetalleNC.setModel(this.xmodeloNC);
        this.JTDetalleNC.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTDetalleNC.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTDetalleNC.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTDetalleNC.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDetalleNC.getColumnModel().getColumn(2).setPreferredWidth(10);
        this.JTDetalleNC.getColumnModel().getColumn(3).setPreferredWidth(10);
        this.JTDetalleNC.getColumnModel().getColumn(4).setPreferredWidth(10);
    }

    private void mBuscarProceso() {
        try {
            mCrearTablaProceso();
            int totalA = 0;
            int totalNA = 0;
            int total = 0;
            String sql = "SELECT `s_sgc_tipoproceso`.`Id`, `s_sgc_tipoproceso`.`Nbre` AS tipoP , `s_sgc_procesos`.`Nbre` AS proc,COUNT(`s_sgc_ncregistro`.`Id`) AS cantidad, `s_sgc_ncregistro`.`FechaNC` FROM `s_sgc_ncregistro` INNER JOIN `baseserver`.`s_sgc_tipoproceso` ON (`s_sgc_ncregistro`.`Id_ProcesoR` = `s_sgc_tipoproceso`.`Id`)INNER JOIN `baseserver`.`s_sgc_procesos` ON (`s_sgc_tipoproceso`.`Id_Proceso` = `s_sgc_procesos`.`Id`)WHERE (`s_sgc_ncregistro`.`FechaNC` >='" + this.xmt.formatoAMD.format(this.JDFFechaInicio.getDate()) + "' AND `s_sgc_ncregistro`.`FechaNC` <='" + this.xmt.formatoAMD.format(this.JDFFechaFin.getDate()) + "'AND `s_sgc_ncregistro`.`Estado` =1 AND s_sgc_ncregistro.`EsNc`='" + this.xidnc + "') GROUP BY `s_sgc_tipoproceso`.`Nbre`";
            ResultSet xrs = this.xct.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodeloproceso.addRow(this.xdato);
                    this.xmodeloproceso.setValueAt(Integer.valueOf(xrs.getInt(1)), n, 0);
                    this.xmodeloproceso.setValueAt(xrs.getString(2), n, 1);
                    this.xmodeloproceso.setValueAt(xrs.getString(3), n, 2);
                    this.xmodeloproceso.setValueAt(Integer.valueOf(mCalculaAnalizados(1, xrs.getInt(1))), n, 3);
                    this.xmodeloproceso.setValueAt(Integer.valueOf(mCalculaAnalizados(0, xrs.getInt(1))), n, 4);
                    this.xmodeloproceso.setValueAt(Integer.valueOf(Integer.valueOf(this.xmodeloproceso.getValueAt(n, 3).toString()).intValue() + Integer.valueOf(this.xmodeloproceso.getValueAt(n, 4).toString()).intValue()), n, 5);
                    totalA += Integer.valueOf(this.xmodeloproceso.getValueAt(n, 3).toString()).intValue();
                    totalNA += Integer.valueOf(this.xmodeloproceso.getValueAt(n, 4).toString()).intValue();
                    total += Integer.valueOf(this.xmodeloproceso.getValueAt(n, 5).toString()).intValue();
                    n++;
                }
            }
            xrs.close();
            this.JLTotalA.setText(Integer.valueOf(totalA).toString());
            this.JLTotalNA.setText(Integer.valueOf(totalNA).toString());
            this.JLTotal.setText(Integer.valueOf(total).toString());
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFRNoConfomidad.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mBuscarOrigen() {
        try {
            mCrearTablaOrigen();
            String sql = "SELECT `s_sgc_ncregistro`.`Id_OrigenNC` ,`s_sgc_ncorigen`.`Nbre`  ,COUNT(`s_sgc_ncregistro`.`Id_OrigenNC`) AS cantidad FROM `s_sgc_ncregistro` INNER JOIN `baseserver`.`s_sgc_ncorigen` ON (`s_sgc_ncregistro`.`Id_OrigenNC` = `s_sgc_ncorigen`.`Id`) WHERE (`s_sgc_ncregistro`.`FechaNC` >='" + this.xmt.formatoAMD.format(this.JDFFechaInicio.getDate()) + "' AND `s_sgc_ncregistro`.`FechaNC` <='" + this.xmt.formatoAMD.format(this.JDFFechaFin.getDate()) + "' AND `s_sgc_ncregistro`.`Estado` =1 AND `s_sgc_ncregistro`.`EsNc` ='" + this.xidnc + "') GROUP BY `s_sgc_ncorigen`.`Nbre`";
            ResultSet xrs = this.xct.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodeloorigen.addRow(this.xdato);
                    this.xmodeloorigen.setValueAt(Integer.valueOf(xrs.getInt(1)), n, 0);
                    this.xmodeloorigen.setValueAt(xrs.getString(2), n, 1);
                    this.xmodeloorigen.setValueAt(Integer.valueOf(mCalculaAnalizados2(1, xrs.getInt(1))), n, 2);
                    this.xmodeloorigen.setValueAt(Integer.valueOf(mCalculaAnalizados2(0, xrs.getInt(1))), n, 3);
                    this.xmodeloorigen.setValueAt(Integer.valueOf(Integer.valueOf(this.xmodeloorigen.getValueAt(n, 2).toString()).intValue() + Integer.valueOf(this.xmodeloorigen.getValueAt(n, 3).toString()).intValue()), n, 4);
                    n++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFRNoConfomidad.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mBuscarTipoNC() {
        try {
            mCrearTablaTipoNC();
            String sql = "SELECT `s_sgc_ncregistro`.`Id_TipoNC` ,`s_sgc_nctipo`.`Nbre` ,COUNT(`s_sgc_ncregistro`.`Id_OrigenNC`) AS cantidad FROM `s_sgc_ncregistro` INNER JOIN `s_sgc_nctipo`   ON (`s_sgc_ncregistro`.`Id_TipoNC` = `s_sgc_nctipo`.`Id`) WHERE (`s_sgc_ncregistro`.`FechaNC` >='" + this.xmt.formatoAMD.format(this.JDFFechaInicio.getDate()) + "' AND `s_sgc_ncregistro`.`FechaNC` <='" + this.xmt.formatoAMD.format(this.JDFFechaFin.getDate()) + "'  AND `s_sgc_ncregistro`.`Estado` =1 AND `s_sgc_ncregistro`.`EsNc` ='" + this.xidnc + "') GROUP BY  `s_sgc_nctipo`.`Nbre`";
            ResultSet xrs = this.xct.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodeloNC.addRow(this.xdato);
                    this.xmodeloNC.setValueAt(Integer.valueOf(xrs.getInt(1)), n, 0);
                    this.xmodeloNC.setValueAt(xrs.getString(2), n, 1);
                    this.xmodeloNC.setValueAt(Integer.valueOf(mCalculaAnalizados3(1, xrs.getInt(1))), n, 2);
                    this.xmodeloNC.setValueAt(Integer.valueOf(mCalculaAnalizados3(0, xrs.getInt(1))), n, 3);
                    this.xmodeloNC.setValueAt(Integer.valueOf(Integer.valueOf(this.xmodeloNC.getValueAt(n, 2).toString()).intValue() + Integer.valueOf(this.xmodeloNC.getValueAt(n, 3).toString()).intValue()), n, 4);
                    n++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFRNoConfomidad.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mBucarEvidencias() {
        mCrearTablaEvidencia();
        this.xsql = "SELECT Id, `FechaE` , `Nbre` , `Url`  FROM s_sgc_nregistro_evidencia WHERE (Id_ncregistro ='" + Principal.txtNo.getText() + "' AND Estado =1) ORDER BY FechaE DESC ";
        ResultSet xrs = this.xct.traerRs(this.xsql);
        try {
            if (xrs.next()) {
                xrs.beforeFirst();
                int xfila = 0;
                while (xrs.next()) {
                    this.xmodeloevidencia.addRow(this.xdato);
                    this.xmodeloevidencia.setValueAt(Long.valueOf(xrs.getLong(1)), xfila, 0);
                    this.xmodeloevidencia.setValueAt(xrs.getString(2), xfila, 1);
                    this.xmodeloevidencia.setValueAt(xrs.getString(3), xfila, 2);
                    this.xmodeloevidencia.setValueAt(this.xmt.mTraerUrlBD(xrs.getString(4)), xfila, 3);
                    xfila++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFicha5w1H.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private int mCalculaAnalizados(int xidAnalizasa, int xidProceso) {
        int xdato = 0;
        String sql = "SELECT  `s_sgc_tipoproceso`.`Id`   ,COUNT(`s_sgc_ncregistro`.`Id`) AS cantidad FROM `s_sgc_ncregistro` INNER JOIN `baseserver`.`s_sgc_tipoproceso` ON (`s_sgc_ncregistro`.`Id_ProcesoR` = `s_sgc_tipoproceso`.`Id`)INNER JOIN `baseserver`.`s_sgc_procesos` ON (`s_sgc_tipoproceso`.`Id_Proceso` = `s_sgc_procesos`.`Id`)WHERE (`s_sgc_ncregistro`.`FechaNC` >='" + this.xmt.formatoAMD.format(this.JDFFechaInicio.getDate()) + "' AND `s_sgc_ncregistro`.`FechaNC` <='" + this.xmt.formatoAMD.format(this.JDFFechaFin.getDate()) + "'AND `s_sgc_ncregistro`.`Estado` =1 AND s_sgc_ncregistro.`Analizada`='" + xidAnalizasa + "' AND s_sgc_ncregistro.`Id_ProcesoR` ='" + xidProceso + "' AND s_sgc_ncregistro.`EsNc`='" + this.xidnc + "') GROUP BY `s_sgc_tipoproceso`.`Nbre`";
        ConsultasMySQL xct2 = new ConsultasMySQL();
        ResultSet xrs = xct2.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.first();
                xdato = xrs.getInt(2);
            }
            xrs.close();
            xct2.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFRNoConfomidad.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return xdato;
    }

    private int mCalculaAnalizados2(int xidAnalizasa, int xidProceso) {
        int xdato = 0;
        String sql = "SELECT `Id_OrigenNC`, COUNT(`Analizada`) AS cantidad FROM `s_sgc_ncregistro` WHERE (`FechaNC` >='" + this.xmt.formatoAMD.format(this.JDFFechaInicio.getDate()) + "' AND `FechaNC` <='" + this.xmt.formatoAMD.format(this.JDFFechaFin.getDate()) + "' AND `Estado` =1 AND `EsNc` ='" + this.xidnc + "' AND `Id_OrigenNC`='" + xidProceso + "' AND Analizada='" + xidAnalizasa + "')";
        ConsultasMySQL xct2 = new ConsultasMySQL();
        ResultSet xrs = xct2.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.first();
                xdato = xrs.getInt(2);
            }
            xrs.close();
            xct2.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFRNoConfomidad.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return xdato;
    }

    private int mCalculaAnalizados3(int xidAnalizasa, int xidProceso) {
        int xdato = 0;
        String sql = "SELECT `Id_TipoNC`, COUNT(`Analizada`) AS cantidad FROM `s_sgc_ncregistro` WHERE (`FechaNC` >='" + this.xmt.formatoAMD.format(this.JDFFechaInicio.getDate()) + "' AND `FechaNC` <='" + this.xmt.formatoAMD.format(this.JDFFechaFin.getDate()) + "' AND `Estado` =1 AND `EsNc` ='" + this.xidnc + "' AND `Id_TipoNC`='" + xidProceso + "' AND Analizada='" + xidAnalizasa + "')";
        ConsultasMySQL xct2 = new ConsultasMySQL();
        ResultSet xrs = xct2.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.first();
                xdato = xrs.getInt(2);
            }
            xrs.close();
            xct2.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFRNoConfomidad.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return xdato;
    }

    public void mGrabar() {
        if (this.xmodulo == 0) {
            mGrabarRegistroNc();
        } else if (this.xmodulo == 1) {
            mGrabarRegistroNc();
        }
    }

    private void mGrabarRegistroNc() {
        if (Principal.txtNo.getText().isEmpty()) {
            if (this.JCBTipo.getSelectedIndex() != -1) {
                if (this.JCBTOrigen.getSelectedIndex() != -1) {
                    if (this.JCBTProceso.getSelectedIndex() != -1) {
                        if (this.JCBProceso.getSelectedIndex() != -1) {
                            if (!this.JTADescripcion.getText().isEmpty()) {
                                if (!this.JTAAccionImediata.getText().isEmpty()) {
                                    if (this.JCBProcesoR.getSelectedIndex() != -1) {
                                        int y = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 3);
                                        if (y == 0) {
                                            this.xsql = "insert into s_sgc_ncregistro (FechaNC, Id_UsuarioR, Id_ProcesoR, Id_ProcesoA, Id_TipoNC, Id_OrigenNC, DescripcionNC, AccionInmediata, UsuarioS ) values ('" + this.xmt.formatoAMD.format(this.JDFecha.getDate()) + "','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "','" + this.xidprocesor[this.JCBProcesoR.getSelectedIndex()][0] + "','" + this.xidproceso[this.JCBProceso.getSelectedIndex()][0] + "','" + this.xidtipo[this.JCBTipo.getSelectedIndex()] + "','" + this.xidorigen[this.JCBTOrigen.getSelectedIndex()] + "','" + this.JTADescripcion.getText().toUpperCase() + "','" + this.JTAAccionImediata.getText().toUpperCase() + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                                            Principal.txtNo.setText(this.xct.ejecutarSQLId(this.xsql));
                                            this.xct.cerrarConexionBd();
                                            this.xmt.mEnvioCorreoElectronico("Se ha generado el reporte de NC N° " + Principal.txtNo.getText() + "; favor entrar a Genoma Plus y revisar.\n\n\n" + Principal.usuarioSistemaDTO.getNombreUsuario() + "\n" + Principal.usuarioSistemaDTO.getNombreCargoUsuario(), Principal.informacionIps.getEmailSistemaCalidad(), "REPORTE DE NO CONFORMIDAD", Principal.usuarioSistemaDTO.getLogin());
                                            return;
                                        }
                                        return;
                                    }
                                    JOptionPane.showInternalMessageDialog(this, "Debe seleccionar el proceso que reporta", "VERIFICAR", 1);
                                    this.JCBProcesoR.requestFocus();
                                    return;
                                }
                                JOptionPane.showInternalMessageDialog(this, "Debe registrar la acción inmediata", "VERIFICAR", 1);
                                this.JTAAccionImediata.requestFocus();
                                return;
                            }
                            JOptionPane.showInternalMessageDialog(this, "Debe registrar la descripción", "VERIFICAR", 1);
                            this.JTADescripcion.requestFocus();
                            return;
                        }
                        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar el proceso", "VERIFICAR", 1);
                        this.JCBProceso.requestFocus();
                        return;
                    }
                    JOptionPane.showInternalMessageDialog(this, "Debe seleccionar el tipo de proceso", "VERIFICAR", 1);
                    this.JCBTProceso.requestFocus();
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un origen", "VERIFICAR", 1);
                this.JCBTipo.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un tipo", "VERIFICAR", 1);
            this.JCBTipo.requestFocus();
            return;
        }
        if (this.JLEstado.getText().isEmpty()) {
            int y2 = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 3);
            if (y2 == 0) {
                this.xsql = "update s_sgc_ncregistro set DescripcionNC='" + this.JTADescripcion.getText() + "',AccionInmediata='" + this.JTAAccionImediata.getText() + "',EsNc='" + this.xesnc + "',ObservacionRev='" + this.JTAObservacionC.getText() + "',FechaRev='" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "' where Id='" + Principal.txtNo.getText() + "'";
                this.xct.ejecutarSQL(this.xsql);
                this.xct.cerrarConexionBd();
                if (this.JCHEsNC.isSelected()) {
                    this.xmt.mEnvioCorreoElectronico("El reporte N° " + Principal.txtNo.getText() + ";" + this.JTAObservacionC.getText() + "',\n Favor entrar a genoma y continuar con el proceso de análisis.\n\n\n" + Principal.usuarioSistemaDTO.getNombreUsuario() + "\n" + Principal.usuarioSistemaDTO.getNombreCargoUsuario(), this.JTACorreoR.getText(), "REVISIÓN DE REPORTE", Principal.usuarioSistemaDTO.getLogin());
                }
                mBuscarNC(Principal.txtNo.getText());
                return;
            }
            return;
        }
        if (this.JLBNAnalisis.getText().isEmpty()) {
            mGrabarAnalisis();
            return;
        }
        if (this.JCHCompletado.isSelected() && this.JLEstadoRSgc.getText().isEmpty()) {
            int y3 = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar y subir acciones a la ficha 5W1H?", "CONFIRMAR", 0, 3);
            if (y3 == 0) {
                this.xsql = "update s_sgc_analisis set FechaRSgc='" + this.xmt.formatoAMD.format(this.xmt.getFechaActual()) + "', ObservacionReSgc='" + this.JTAObservacionRSgc.getText() + "' where Id='" + this.JLBNAnalisis.getText() + "'";
                this.xct.ejecutarSQL(this.xsql);
                this.xct.cerrarConexionBd();
                for (int x = 0; x < this.JTDetalle1.getRowCount(); x++) {
                    this.xsql = "insert into s_sgc_ficha5w1h(FechaRF, Id_NC, Id_TipoAccion, Id_Origen, Id_TipoProceso, Id_RhPersonaR, Id_RhPersonaRP, Que, Cuando)  values('" + this.xmt.formatoAMD.format(this.xmt.getFechaActual()) + "','" + Principal.txtNo.getText() + "','" + this.xmodelo1.getValueAt(x, 0) + "','" + this.xidorigen[this.JCBTOrigen.getSelectedIndex()] + "','" + this.xmodelo1.getValueAt(x, 3) + "','" + this.xmodelo1.getValueAt(x, 4) + "','" + Principal.usuarioSistemaDTO.getIdPersonaCargo() + "','" + this.xmodelo1.getValueAt(x, 2) + "','" + this.xmt.formatoAMD.format(this.xmt.getPasarTextoAFecha(this.xmodelo1.getValueAt(x, 6).toString())) + "')";
                    System.out.println(" Ficha  " + this.xsql);
                    String xid = this.xct.ejecutarSQLId(this.xsql);
                    this.xct.cerrarConexionBd();
                    System.out.println(" update  " + this.xsql);
                    this.xsql = "update s_sgc_analisis_accion_actividad set Id_Ficha='" + xid + "' where Id='" + this.xmodelo1.getValueAt(x, 0) + "'";
                    this.xct.ejecutarSQL(this.xsql);
                    this.xct.cerrarConexionBd();
                    System.out.println(" Correo  " + this.xmodelo1.getValueAt(x, 7).toString());
                    if (!this.xmodelo1.getValueAt(x, 7).toString().equals("")) {
                        this.xmt.mEnvioCorreoElectronico("Se le ha asignado un(a) " + this.xmodelo1.getValueAt(x, 1).toString() + " : " + this.xmodelo1.getValueAt(x, 2).toString() + " en la ficha 5W1H  del proceso de " + this.JCBProceso.getSelectedItem().toString() + "\n Favor entrar a Genoma Plus y completar. \nRegistro N° " + xid + "\n\n\n" + Principal.usuarioSistemaDTO.getNombreUsuario() + "\n" + Principal.usuarioSistemaDTO.getNombreCargoUsuario(), this.xmodelo1.getValueAt(x, 7).toString(), "ASIGNACIÓN DE ACCIÓN A FICHA 5W1H", Principal.usuarioSistemaDTO.getLogin());
                    }
                }
                mBuscarAnalisisNc(Principal.txtNo.getText());
            }
        }
    }

    private void mGrabarAnalisis() {
        if (!Principal.txtNo.getText().isEmpty()) {
            if (this.JLBNAnalisis.getText().isEmpty()) {
                if (!this.JTAMaquina.getText().isEmpty()) {
                    if (!this.JTAManoObra.getText().isEmpty()) {
                        if (!this.JTAMaterial.getText().isEmpty()) {
                            if (!this.JTAMedioAmb.getText().isEmpty()) {
                                if (!this.JTAMetodo.getText().isEmpty()) {
                                    if (this.xnfila1 > -1) {
                                        if (this.xnfila2 > -1) {
                                            int y = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 3);
                                            if (y == 0) {
                                                this.xsql = "insert into s_sgc_analisis (FechaA , Id_NC, Problema, M1, M2, M3, M4, M5, Fecha, UsuarioS)  values('" + this.xmt.formatoAMD.format(this.xmt.getFechaActual()) + "','" + Principal.txtNo.getText() + "','" + this.JTADescripcionP.getText() + "','" + this.JTAMaquina.getText() + "','" + this.JTAManoObra.getText() + "','" + this.JTAMaterial.getText() + "','" + this.JTAMedioAmb.getText() + "','" + this.JTAMetodo.getText() + "','" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                                                this.JLBNAnalisis.setText(this.xct.ejecutarSQLId(this.xsql));
                                                this.JLBFechaAnalisis.setText(this.xmt.formatoDMA.format(this.xmt.getFechaActual()));
                                                this.xct.cerrarConexionBd();
                                                for (int x = 0; x < this.JTDetalle1.getRowCount(); x++) {
                                                    this.xsql = "insert into s_sgc_analisis_accion_actividad (Id_Analisis, Id_tipoaccion, Detalle, Id_TipoProceso, Id_RhPersonaC, FechaEjecucion) values('" + this.JLBNAnalisis.getText() + "','" + this.xmodelo1.getValueAt(x, 0) + "','" + this.xmodelo1.getValueAt(x, 2) + "','" + this.xmodelo1.getValueAt(x, 3) + "','" + this.xmodelo1.getValueAt(x, 4) + "','" + this.xmt.invertirFecha(this.xmodelo1.getValueAt(x, 6).toString()) + "')";
                                                    this.xct.ejecutarSQL(this.xsql);
                                                    this.xct.cerrarConexionBd();
                                                }
                                                for (int x2 = 0; x2 < this.JTDetalle2.getRowCount(); x2++) {
                                                    this.xsql = "insert into s_sgc_analisis_integrantes (Id_Analisis, Id_RhPersonaCargo, Id_TipoProceso) values('" + this.JLBNAnalisis.getText() + "','" + this.xmodelo2.getValueAt(x2, 2) + "','" + this.xmodelo2.getValueAt(x2, 0) + "')";
                                                    this.xct.ejecutarSQL(this.xsql);
                                                    this.xct.cerrarConexionBd();
                                                }
                                                mActualizarEstadoAnalasisNC();
                                                this.xmt.mEnvioCorreoElectronico("Se ha realizado el análisis de la NC N° " + Principal.txtNo.getText() + "; favor entrar a Genoma Plus y revisar.\n\n\n" + Principal.usuarioSistemaDTO.getNombreUsuario() + "\n" + Principal.usuarioSistemaDTO.getNombreCargoUsuario(), Principal.informacionIps.getEmailSistemaCalidad(), "ANÁLISIS DE NO CONFORMIDAD", Principal.usuarioSistemaDTO.getLogin());
                                                return;
                                            }
                                            return;
                                        }
                                        JOptionPane.showInternalMessageDialog(this, "Falta integrantes por agregar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                                        this.JTPAnalisis.setSelectedIndex(1);
                                        return;
                                    }
                                    JOptionPane.showInternalMessageDialog(this, "Falta acciones por agregar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                                    this.JTPAnalisis.setSelectedIndex(1);
                                    return;
                                }
                                JOptionPane.showInternalMessageDialog(this, "El campo método no puede ser nulo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                                this.JTAMetodo.requestFocus();
                                return;
                            }
                            JOptionPane.showInternalMessageDialog(this, "El campo medio ambiente no puede ser nulo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                            this.JTAMedioAmb.requestFocus();
                            return;
                        }
                        JOptionPane.showInternalMessageDialog(this, "El campo material no puede ser nulo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                        this.JTAMaterial.requestFocus();
                        return;
                    }
                    JOptionPane.showInternalMessageDialog(this, "El campo mano de obra no puede ser nulo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    this.JTAManoObra.requestFocus();
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "El campo maquina no puede ser nulo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                this.JTAMaquina.requestFocus();
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe tener una NC activa", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
    }

    public void mBuscar() {
        if (this.JPInformes.isVisible()) {
            mBuscarProceso();
            mBuscarOrigen();
            mBuscarTipoNC();
        } else {
            JDBuscarDatos xjif = new JDBuscarDatos(null, true, this);
            xjif.setLocationRelativeTo(this);
            xjif.setVisible(true);
        }
    }

    public void mBuscarNC(String xidnc) {
        mNuevo();
        ConsultasMySQL xct1 = new ConsultasMySQL();
        this.xsql = "SELECT s_sgc_ncregistro.Id, s_sgc_ncregistro.FechaNC, sgc_proceso.NProceso, sgc_proceso.NTipoProceso, s_sgc_tipoproceso.Nbre, s_sgc_nctipo.Nbre, s_sgc_ncorigen.Nbre, s_sgc_ncregistro.DescripcionNC , s_sgc_ncregistro.AccionInmediata, s_sgc_ncregistro.Cerrada, s_sgc_ncregistro.EsNc, s_sgc_ncregistro.Estado,  s_sgc_ncregistro.Analizada, IF(s_sgc_ncregistro.FechaRev IS NULL, '',date_format(s_sgc_ncregistro.FechaRev,'%d-%m-%Y')) AS FechaRev, s_sgc_ncregistro.ObservacionRev FROM s_sgc_usuario_tipoproceso INNER JOIN s_sgc_ncregistro  ON (s_sgc_usuario_tipoproceso.Id_Usuario = s_sgc_ncregistro.Id_UsuarioR) INNER JOIN s_sgc_tipoproceso  ON (s_sgc_ncregistro.Id_ProcesoR = s_sgc_tipoproceso.Id) AND (s_sgc_usuario_tipoproceso.Id_TipoProceso = s_sgc_tipoproceso.Id) INNER JOIN s_sgc_procesos  ON (s_sgc_tipoproceso.Id_Proceso = s_sgc_procesos.Id) INNER JOIN persona  ON (persona.Id_persona = s_sgc_usuario_tipoproceso.Id_Usuario) INNER JOIN sgc_proceso  ON (sgc_proceso.IdTipoProceso = s_sgc_ncregistro.Id_ProcesoA) INNER JOIN s_sgc_nctipo  ON (s_sgc_ncregistro.Id_TipoNC = s_sgc_nctipo.Id) INNER JOIN s_sgc_ncorigen  ON (s_sgc_ncregistro.Id_OrigenNC = s_sgc_ncorigen.Id)  WHERE (s_sgc_ncregistro.Id ='" + xidnc + "') ";
        this.xidnc1 = Long.valueOf(xidnc).longValue();
        ResultSet rs = xct1.traerRs(this.xsql);
        System.out.println(" NC " + this.xsql);
        try {
            if (rs.next()) {
                rs.first();
                if (this.xmodulo != 2) {
                    Principal.txtNo.setText(rs.getString(1));
                }
                String xidnc2 = rs.getString(1);
                this.JDFecha.setDate(rs.getDate(2));
                this.JCBTipo.setSelectedItem(rs.getString(6));
                this.JCBTOrigen.setSelectedItem(rs.getString(7));
                this.JCBTProceso.setSelectedItem(rs.getString(3));
                this.JCBProceso.setSelectedItem(rs.getString(4));
                this.JCBProcesoR.setSelectedItem(rs.getString(5));
                this.JTADescripcion.setText(rs.getString(8));
                this.JTAAccionImediata.setText(rs.getString(9));
                this.JCHEsNC.setSelected(rs.getBoolean(11));
                this.JLEstado.setText(rs.getString(14));
                if (rs.getBoolean(11)) {
                    this.JTPRegistro.setEnabledAt(1, true);
                } else {
                    this.JTPRegistro.setEnabledAt(1, false);
                }
                this.JTADescripcionP.setText(rs.getString(8));
                ConsultasMySQL xct2 = new ConsultasMySQL();
                this.xsql = "SELECT  `s_sgc_ncregistro_incumplimiento`.`Id_tincumplimientodet` , `s_sgc_tipoincumplimiento`.`Nbre` , `s_sgc_tipoincumplimiento_detalle`.`Nbre`, `s_sgc_ncregistro_incumplimiento`.`Observacion` FROM `s_sgc_ncregistro_incumplimiento` INNER JOIN `s_sgc_tincumplimiento_detalle`  ON (`s_sgc_ncregistro_incumplimiento`.`Id_tincumplimientodet` = `s_sgc_tincumplimiento_detalle`.`Id`) INNER JOIN `s_sgc_tipoincumplimiento`  ON (`s_sgc_tincumplimiento_detalle`.`Id_TipoIncumplimiento` = `s_sgc_tipoincumplimiento`.`Id`) INNER JOIN `s_sgc_tipoincumplimiento_detalle`  ON (`s_sgc_tincumplimiento_detalle`.`Id_TipoIncumpDetalle` = `s_sgc_tipoincumplimiento_detalle`.`Id`) WHERE (`s_sgc_ncregistro_incumplimiento`.`Id_ncregistro` ='" + rs.getString(1) + "') ";
                ResultSet xrs = xct2.traerRs(this.xsql);
                xrs.beforeFirst();
                while (xrs.next()) {
                    this.xnfila++;
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(1)), this.xnfila, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), this.xnfila, 1);
                    this.xmodelo.setValueAt(xrs.getString(3), this.xnfila, 2);
                    this.xmodelo.setValueAt(xrs.getString(4), this.xnfila, 3);
                }
                xrs.close();
                xct2.cerrarConexionBd();
                mBuscarAnalisisNc(xidnc2);
                mBucarEvidencias();
                this.JBTAdicionarI.setEnabled(true);
                this.JBTGrabarI.setEnabled(true);
            }
            rs.close();
            xct1.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFRNoConfomidad.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mBuscarNCAnalizadas(String xidnc) {
        mNuevo();
        ConsultasMySQL xct1 = new ConsultasMySQL();
        this.xsql = "SELECT s_sgc_ncregistro.Id, s_sgc_ncregistro.FechaNC, sgc_proceso.NProceso, sgc_proceso.NTipoProceso, s_sgc_tipoproceso.Nbre, s_sgc_nctipo.Nbre, s_sgc_ncorigen.Nbre, s_sgc_ncregistro.DescripcionNC , s_sgc_ncregistro.AccionInmediata, s_sgc_ncregistro.Cerrada, s_sgc_ncregistro.EsNc, s_sgc_ncregistro.Estado,  s_sgc_ncregistro.Analizada, s_sgc_tincumplimiento_detalle.Id , s_sgc_tipoincumplimiento_detalle.Nbre, s_sgc_tipoincumplimiento.Nbre, s_sgc_ncregistro_incumplimiento.Observacion, IF(s_sgc_ncregistro.FechaRev IS NULL, '',date_format(s_sgc_ncregistro.FechaRev,'%d-%m-%Y')) AS FechaRev, s_sgc_ncregistro.ObservacionRev FROM s_sgc_usuario_tipoproceso INNER JOIN s_sgc_ncregistro  ON (s_sgc_usuario_tipoproceso.Id_Usuario = s_sgc_ncregistro.Id_UsuarioR) INNER JOIN s_sgc_tipoproceso  ON (s_sgc_ncregistro.Id_ProcesoR = s_sgc_tipoproceso.Id) AND (s_sgc_usuario_tipoproceso.Id_TipoProceso = s_sgc_tipoproceso.Id) INNER JOIN s_sgc_procesos  ON (s_sgc_tipoproceso.Id_Proceso = s_sgc_procesos.Id) INNER JOIN persona  ON (persona.Id_persona = s_sgc_usuario_tipoproceso.Id_Usuario) INNER JOIN sgc_proceso  ON (sgc_proceso.IdTipoProceso = s_sgc_ncregistro.Id_ProcesoA) INNER JOIN s_sgc_nctipo  ON (s_sgc_ncregistro.Id_TipoNC = s_sgc_nctipo.Id) INNER JOIN s_sgc_ncorigen  ON (s_sgc_ncregistro.Id_OrigenNC = s_sgc_ncorigen.Id) INNER JOIN s_sgc_ncregistro_incumplimiento  ON (s_sgc_ncregistro_incumplimiento.Id_ncregistro = s_sgc_ncregistro.Id) INNER JOIN s_sgc_tincumplimiento_detalle  ON (s_sgc_ncregistro_incumplimiento.Id_tincumplimientodet = s_sgc_tincumplimiento_detalle.Id) INNER JOIN s_sgc_tipoincumplimiento  ON (s_sgc_tincumplimiento_detalle.Id_TipoIncumplimiento = s_sgc_tipoincumplimiento.Id) INNER JOIN s_sgc_tipoincumplimiento_detalle  ON (s_sgc_tincumplimiento_detalle.Id_TipoIncumpDetalle = s_sgc_tipoincumplimiento_detalle.Id) WHERE (s_sgc_ncregistro.Id ='" + xidnc + "') ";
        this.xidnc1 = Long.valueOf(xidnc).longValue();
        ResultSet rs = xct1.traerRs(this.xsql);
        try {
            if (rs.next()) {
                rs.first();
                if (this.xmodulo != 2) {
                    Principal.txtNo.setText(rs.getString(1));
                }
                String xidnc2 = rs.getString(1);
                this.JDFecha.setDate(rs.getDate(2));
                this.JCBTipo.setSelectedItem(rs.getString(6));
                this.JCBTOrigen.setSelectedItem(rs.getString(7));
                this.JCBTProceso.setSelectedItem(rs.getString(3));
                this.JCBProceso.setSelectedItem(rs.getString(4));
                this.JCBProcesoR.setSelectedItem(rs.getString(5));
                this.JTADescripcion.setText(rs.getString(8));
                this.JTAAccionImediata.setText(rs.getString(9));
                this.JCHEsNC.setSelected(rs.getBoolean(11));
                this.JLEstado.setText(rs.getString(18));
                if (rs.getBoolean(11)) {
                    this.JTPRegistro.setEnabledAt(1, true);
                } else {
                    this.JTPRegistro.setEnabledAt(1, false);
                }
                this.JTAObservacionC.setText(rs.getString(19));
                this.JTADescripcionP.setText(rs.getString(8));
                rs.beforeFirst();
                while (rs.next()) {
                    this.xnfila++;
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong(14)), this.xnfila, 0);
                    this.xmodelo.setValueAt(rs.getString(15), this.xnfila, 1);
                    this.xmodelo.setValueAt(rs.getString(16), this.xnfila, 2);
                    this.xmodelo.setValueAt(rs.getString(17), this.xnfila, 3);
                }
                mBuscarAnalisisNc(xidnc2);
                this.JBTAdicionarI.setEnabled(true);
                this.JBTGrabarI.setEnabled(true);
            }
            rs.close();
            xct1.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFRNoConfomidad.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mActualizarEstadoAnalasisNC() {
        this.xsql = "update s_sgc_ncregistro set Analizada=1 where Id='" + Principal.txtNo.getText() + "'";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
    }

    private void mBuscarAnalisisNc(String xid) {
        ConsultasMySQL xct2 = new ConsultasMySQL();
        this.xsql = "SELECT s_sgc_analisis.Id, date_format(s_sgc_analisis.FechaA,'%d-%m-%Y') as Fecha, s_sgc_analisis.Problema, s_sgc_analisis.M1, s_sgc_analisis.M2, s_sgc_analisis.M3, s_sgc_analisis.M4, s_sgc_analisis.M5, s_sgc_analisis_integrantes.Id_TipoProceso, s_sgc_tipoproceso.Nbre, s_sgc_analisis_integrantes.Id_RhPersonaCargo, persona.NUsuario, IF(s_sgc_analisis.FechaRSgc IS NULL, FALSE,TRUE) AS EsRevisadoSgc, IF(s_sgc_analisis.FechaRSgc IS NULL, '',DATE_FORMAT(s_sgc_analisis.FechaRSgc,'%d-%m-%Y')) AS FechaRevSgc, s_sgc_analisis.ObservacionReSgc FROM s_sgc_analisis_integrantes INNER JOIN s_sgc_analisis  ON (s_sgc_analisis_integrantes.Id_Analisis = s_sgc_analisis.Id) INNER JOIN rh_tipo_persona_cargon ON (s_sgc_analisis_integrantes.Id_RhPersonaCargo = rh_tipo_persona_cargon.Id) INNER JOIN s_sgc_tipoproceso  ON (s_sgc_analisis_integrantes.Id_TipoProceso = s_sgc_tipoproceso.Id) INNER JOIN persona  ON (persona.Id_persona = rh_tipo_persona_cargon.Id_Persona) WHERE (s_sgc_analisis.Id_NC ='" + xid + "' AND s_sgc_analisis.Estado =1) ";
        System.out.println(" Analisis " + this.xsql);
        ResultSet xrs = xct2.traerRs(this.xsql);
        try {
            if (xrs.next()) {
                xrs.first();
                this.JLBNAnalisis.setText(xrs.getString(1));
                this.JLBFechaAnalisis.setText(xrs.getString(2));
                this.JTADescripcionP.setText(xrs.getString(3));
                this.JTAMaquina.setText(xrs.getString(4));
                this.JTAManoObra.setText(xrs.getString(5));
                this.JTAMaterial.setText(xrs.getString(6));
                this.JTAMedioAmb.setText(xrs.getString(7));
                this.JTAMetodo.setText(xrs.getString(8));
                this.JCHCompletado.setSelected(xrs.getBoolean(13));
                this.JLEstadoRSgc.setText(xrs.getString(14));
                this.JTAObservacionRSgc.setText(xrs.getString(15));
                xrs.beforeFirst();
                mCrearTablaDetalle2();
                while (xrs.next()) {
                    this.xnfila2++;
                    this.xmodelo2.addRow(this.xdato);
                    this.xmodelo2.setValueAt(Long.valueOf(xrs.getLong(9)), this.xnfila2, 0);
                    this.xmodelo2.setValueAt(xrs.getString(10), this.xnfila2, 1);
                    this.xmodelo2.setValueAt(Long.valueOf(xrs.getLong(11)), this.xnfila2, 2);
                    this.xmodelo2.setValueAt(xrs.getString(12), this.xnfila2, 3);
                }
                this.xsql = "SELECT s_sgc_tipo_accion.Id, s_sgc_tipo_accion.Nbre, s_sgc_analisis_accion_actividad.Detalle, s_sgc_analisis_accion_actividad.Id_TipoProceso, s_sgc_analisis_accion_actividad.Id_RhPersonaC, persona.NUsuario, date_format(s_sgc_analisis_accion_actividad.FechaEjecucion,'%d/%m/%Y') as FechaE, persona.Corre,IF(s_sgc_analisis_accion_actividad.Id_Ficha=0,FALSE, TRUE) AS EstaFicha, s_sgc_analisis_accion_actividad.Id_Ficha   FROM s_sgc_analisis_accion_actividad INNER JOIN s_sgc_tipo_accion  ON (s_sgc_analisis_accion_actividad.Id_tipoaccion = s_sgc_tipo_accion.Id) INNER JOIN s_sgc_tipoproceso  ON (s_sgc_analisis_accion_actividad.Id_TipoProceso = s_sgc_tipoproceso.Id) INNER JOIN rh_tipo_persona_cargon  ON (s_sgc_analisis_accion_actividad.Id_RhPersonaC = rh_tipo_persona_cargon.Id) INNER JOIN persona  ON (persona.Id_persona = rh_tipo_persona_cargon.Id_Persona) WHERE (s_sgc_analisis_accion_actividad.Id_Analisis ='" + this.JLBNAnalisis.getText() + "')";
                ConsultasMySQL xct1 = new ConsultasMySQL();
                mCrearTablaDetalle1();
                System.out.println(" acciones " + this.xsql);
                ResultSet rs = xct1.traerRs(this.xsql);
                if (rs.next()) {
                    rs.beforeFirst();
                    while (rs.next()) {
                        this.xnfila1++;
                        this.xmodelo1.addRow(this.xdato);
                        this.xmodelo1.setValueAt(Long.valueOf(rs.getLong(1)), this.xnfila1, 0);
                        this.xmodelo1.setValueAt(rs.getString(2), this.xnfila1, 1);
                        this.xmodelo1.setValueAt(rs.getString(3), this.xnfila1, 2);
                        this.xmodelo1.setValueAt(Long.valueOf(rs.getLong(4)), this.xnfila1, 3);
                        this.xmodelo1.setValueAt(Long.valueOf(rs.getLong(5)), this.xnfila1, 4);
                        this.xmodelo1.setValueAt(rs.getString(6), this.xnfila1, 5);
                        this.xmodelo1.setValueAt(rs.getString(7), this.xnfila1, 6);
                        this.xmodelo1.setValueAt(rs.getString(8), this.xnfila1, 7);
                        this.xmodelo1.setValueAt(Boolean.valueOf(rs.getBoolean(9)), this.xnfila1, 8);
                        this.xmodelo1.setValueAt(Long.valueOf(rs.getLong(10)), this.xnfila1, 9);
                    }
                }
                rs.close();
                xct1.cerrarConexionBd();
            }
            xrs.close();
            xct2.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFRNoConfomidad.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mNuevoEvidencia() {
        this.JDFechaEvidencia.setDate(this.xmt.getFechaActual());
        this.JTADescripcionEvidencia.setText("");
        this.JTFRutaEvidencia.setText("");
        mCrearTablaEvidencia();
    }
}
