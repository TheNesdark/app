package Sgc;

import Acceso.Principal;
import Informes.JFGraficoBarra;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import Utilidades.TextAreaEditor;
import Utilidades.TextAreaRenderer;
import Utilidades.WorkerSQL;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;
import java.net.URI;
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
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

/* JADX INFO: loaded from: GenomaP.jar:Sgc/JIFFicha5w1H.class */
public class JIFFicha5w1H extends JInternalFrame {
    private String[] xidtipop;
    private String[] xidtipo;
    private String[] xidorigen;
    private String[] xidtipoinc;
    private String[] xiddetalleinc;
    private String[] xidtipoprocesoint;
    private String[] xidprocesoa;
    private String[] xidprocesor;
    public String[][] xidtiposolicitud;
    public String[][] xidproceso;
    public String[][] xidresponsable;
    public String[][] xidresponsable1;
    public String[][] xidtipoaccion;
    private String xsql;
    public DefaultTableModel xmodelo;
    public DefaultTableModel xmodelo1;
    public DefaultTableModel xmodeloevidencia;
    public DefaultTableModel xmodeloaprendizaje;
    public DefaultTableModel xmodeloaccion;
    public DefaultTableModel xmodeloorigen;
    public DefaultTableModel xmodeloproceso;
    public long xIdTipoDoc;
    private int xmodulo;
    private Object[] xdato;
    private File xfile;
    private WorkerSQL xWorkerSQL;
    private JButton JBCambiaUsuarioRP;
    private ButtonGroup JBEstado;
    private ButtonGroup JBGEficaz;
    private JButton JBTAdicionar;
    private JButton JBTAdicionarC;
    private JButton JBTAdicionarC1;
    private JButton JBTCorreo;
    private JButton JBTExportar;
    private JButton JBTExportarHistorico;
    private JButton JBTGrabarAO;
    private JButton JBTGrabarEvidencia;
    public JButton JBTGraficoAccion;
    public JButton JBTGraficoOrigen;
    public JButton JBTGraficoProceso;
    private JButton JBTNuevo;
    public JComboBox JCBProcesoI;
    private JComboBox JCBProcesoR;
    public JComboBox JCBResponsableI;
    private JComboBox JCBTOrigen;
    private JComboBox JCBTipoAccion;
    private JCheckBox JCHCerradas;
    private JCheckBox JCHFFiltro;
    private JCheckBox JCHFiltroAccion;
    private JCheckBox JCHPorCerrada;
    private JCheckBox JCHTodas;
    private JCheckBox JCHUltimoS;
    private JDateChooser JDFCuando;
    private JDateChooser JDFFPCierre;
    private JDateChooser JDFFechaCierre;
    private JDateChooser JDFFechaFin;
    private JDateChooser JDFFechaInicio;
    private JDateChooser JDFFechaS;
    private JDateChooser JDFechaAO;
    private JDateChooser JDFechaEvidencia;
    private JDateChooser JDFechaF;
    private JDateChooser JDFechaI;
    private JLabel JLBTipoE;
    private JLabel JLEficaz;
    private JLabel JLNEficaz;
    private JLabel JLTotal;
    private JPanel JPHistorico;
    private JPanel JPIAOrganizacional;
    private JPanel JPIAprendizaje;
    private JPanel JPIDBusqueda;
    private JPanel JPIDConvenciones;
    private JPanel JPIDInternos;
    private JPanel JPIDatos;
    private JPanel JPIDatosCierre;
    private JPanel JPIDatosSeguimientos;
    private JPanel JPIEficaz;
    private JPanel JPIEvidencia;
    private JPanel JPIQuien;
    private JPanel JPIRegistro;
    private JRadioButton JRBCerradas;
    private JRadioButton JRBNo;
    private JRadioButton JRBSi;
    private JRadioButton JRBTodas;
    private JScrollPane JSPAOrganizacional;
    private JScrollPane JSPComo;
    private JScrollPane JSPDescripcionEvidencia;
    private JScrollPane JSPDetalleAccion;
    private JScrollPane JSPDetalleAprendizaje;
    private JScrollPane JSPDetalleEvidencia;
    private JScrollPane JSPDetalleH;
    private JScrollPane JSPDetalleOrigen;
    private JScrollPane JSPDetalleProceso;
    private JScrollPane JSPDetalleS;
    private JSpinner JSPDiasSeg;
    private JScrollPane JSPDonde;
    private JScrollPane JSPObsCierre;
    private JScrollPane JSPObsSerguimiento;
    private JScrollPane JSPParaQue;
    private JScrollPane JSPQue;
    private JTextPane JTAAOrganizacional;
    private JTextPane JTAComo;
    private JTextPane JTADescripcionEvidencia;
    private JTextPane JTADonde;
    private JTextPane JTAObsCierre;
    private JTextPane JTAObsSerguimiento;
    private JTextPane JTAParaQue;
    private JTextPane JTAQue;
    private JTable JTBDetalleEvidencia;
    private JTabbedPane JTB_Seguimiento;
    public JTable JTDetalleAccion;
    private JTable JTDetalleAprendizaje;
    private JTable JTDetalleH;
    public JTable JTDetalleOrigen;
    public JTable JTDetalleProceso;
    private JTable JTDetalleS;
    private JTextField JTFRuta;
    private JTextField JTFRutaEvidencia;
    private JTextField JTFRutaHistorico;
    private JTabbedPane JTPDatosFicha;
    private JCheckBox jCheckBox1;
    private JCheckBox jCheckBox2;
    private JCheckBox jCheckBox3;
    private JCheckBox jCheckBox4;
    private JCheckBox jCheckBox5;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private ConsultasMySQL xct = new ConsultasMySQL();
    private Metodos xmt = new Metodos();
    private boolean xlleno = false;
    private boolean xcerrada = false;
    private boolean xcontrolseguimiento = false;
    private boolean xestadog = false;
    public long xidactividad = 1;
    public long xidseguimiento = 0;
    private int xnfila = -1;
    private int xnfila1 = -1;
    private int xnfila2 = -1;
    private int xeficaz = -1;
    private int xultimoseguimiento = 0;
    private int xfiltro = 1;
    private int xTipo = -1;
    private int xFormaBuscar = -1;

    public JIFFicha5w1H(int xmodulo, String xnombre) {
        this.xmodulo = 0;
        initComponents();
        setName(xnombre);
        this.xmodulo = xmodulo;
        System.out.println("modulo" + xmodulo);
        mNuevo();
        mBuscarHistorico();
        if (this.xmodulo == 0) {
            this.JBCambiaUsuarioRP.setEnabled(true);
        }
    }

    /* JADX WARN: Type inference failed for: r3v152, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v219, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v302, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v346, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v376, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v416, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v423, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGEficaz = new ButtonGroup();
        this.JBEstado = new ButtonGroup();
        this.JTPDatosFicha = new JTabbedPane();
        this.JPIRegistro = new JPanel();
        this.JPIDInternos = new JPanel();
        this.JCBTipoAccion = new JComboBox();
        this.JCBTOrigen = new JComboBox();
        this.JSPQue = new JScrollPane();
        this.JTAQue = new JTextPane();
        this.JSPParaQue = new JScrollPane();
        this.JTAParaQue = new JTextPane();
        this.JPIQuien = new JPanel();
        this.JCBProcesoI = new JComboBox();
        this.JCBResponsableI = new JComboBox();
        this.JBCambiaUsuarioRP = new JButton();
        this.JSPComo = new JScrollPane();
        this.JTAComo = new JTextPane();
        this.JDFCuando = new JDateChooser();
        this.JSPDonde = new JScrollPane();
        this.JTADonde = new JTextPane();
        this.JDFFPCierre = new JDateChooser();
        this.JSPDiasSeg = new JSpinner();
        this.JLBTipoE = new JLabel();
        this.JPIDatosCierre = new JPanel();
        this.JDFFechaCierre = new JDateChooser();
        this.JPIEficaz = new JPanel();
        this.JRBNo = new JRadioButton();
        this.JRBSi = new JRadioButton();
        this.JSPObsCierre = new JScrollPane();
        this.JTAObsCierre = new JTextPane();
        this.JBTAdicionarC = new JButton();
        this.JBTAdicionarC1 = new JButton();
        this.JTB_Seguimiento = new JTabbedPane();
        this.JPIDatosSeguimientos = new JPanel();
        this.JDFFechaS = new JDateChooser();
        this.JSPObsSerguimiento = new JScrollPane();
        this.JTAObsSerguimiento = new JTextPane();
        this.JBTAdicionar = new JButton();
        this.JCHUltimoS = new JCheckBox();
        this.JBTNuevo = new JButton();
        this.JSPDetalleS = new JScrollPane();
        this.JTDetalleS = new JTable();
        this.JPHistorico = new JPanel();
        this.JPIDBusqueda = new JPanel();
        this.JDFechaI = new JDateChooser();
        this.JDFechaF = new JDateChooser();
        this.JCBProcesoR = new JComboBox();
        this.JCHCerradas = new JCheckBox();
        this.JCHPorCerrada = new JCheckBox();
        this.JCHTodas = new JCheckBox();
        this.JCHFFiltro = new JCheckBox();
        this.JCHFiltroAccion = new JCheckBox();
        this.JSPDetalleH = new JScrollPane();
        this.JTDetalleH = new JTable();
        this.JPIDConvenciones = new JPanel();
        this.jCheckBox1 = new JCheckBox();
        this.jCheckBox2 = new JCheckBox();
        this.jCheckBox3 = new JCheckBox();
        this.jCheckBox4 = new JCheckBox();
        this.jCheckBox5 = new JCheckBox();
        this.JBTExportarHistorico = new JButton();
        this.JTFRutaHistorico = new JTextField();
        this.JPIEvidencia = new JPanel();
        this.JPIDatos = new JPanel();
        this.JDFechaEvidencia = new JDateChooser();
        this.JSPDescripcionEvidencia = new JScrollPane();
        this.JTADescripcionEvidencia = new JTextPane();
        this.JTFRutaEvidencia = new JTextField();
        this.JBTGrabarEvidencia = new JButton();
        this.JSPDetalleEvidencia = new JScrollPane();
        this.JTBDetalleEvidencia = new JTable();
        this.JPIAprendizaje = new JPanel();
        this.JPIAOrganizacional = new JPanel();
        this.JDFechaAO = new JDateChooser();
        this.JSPAOrganizacional = new JScrollPane();
        this.JTAAOrganizacional = new JTextPane();
        this.JBTGrabarAO = new JButton();
        this.JSPDetalleAprendizaje = new JScrollPane();
        this.JTDetalleAprendizaje = new JTable();
        this.JBTCorreo = new JButton();
        this.jPanel1 = new JPanel();
        this.JSPDetalleAccion = new JScrollPane();
        this.JTDetalleAccion = new JTable();
        this.jPanel2 = new JPanel();
        this.JRBTodas = new JRadioButton();
        this.JRBCerradas = new JRadioButton();
        this.jPanel4 = new JPanel();
        this.JDFFechaInicio = new JDateChooser();
        this.JDFFechaFin = new JDateChooser();
        this.JSPDetalleOrigen = new JScrollPane();
        this.JTDetalleOrigen = new JTable();
        this.JSPDetalleProceso = new JScrollPane();
        this.JTDetalleProceso = new JTable();
        this.JBTGraficoAccion = new JButton();
        this.JBTGraficoOrigen = new JButton();
        this.JBTGraficoProceso = new JButton();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        this.jPanel3 = new JPanel();
        this.JLTotal = new JLabel();
        this.JLEficaz = new JLabel();
        this.JLNEficaz = new JLabel();
        setClosable(true);
        setIconifiable(true);
        setTitle("FICHA 5W1H");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjifficha5w1h");
        addInternalFrameListener(new InternalFrameListener() { // from class: Sgc.JIFFicha5w1H.1
            public void internalFrameOpened(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIFFicha5w1H.this.formInternalFrameClosing(evt);
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameIconified(InternalFrameEvent evt) {
            }

            public void internalFrameDeiconified(InternalFrameEvent evt) {
            }

            public void internalFrameActivated(InternalFrameEvent evt) {
                JIFFicha5w1H.this.formInternalFrameActivated(evt);
            }

            public void internalFrameDeactivated(InternalFrameEvent evt) {
            }
        });
        this.JTPDatosFicha.setForeground(new Color(0, 103, 0));
        this.JTPDatosFicha.setFont(new Font("Arial", 1, 14));
        this.JPIDInternos.setBorder(BorderFactory.createTitledBorder((Border) null, "PLAN DE ACCIÓN", 0, 0, new Font("Arial", 1, 14), Color.red));
        this.JCBTipoAccion.setFont(new Font("Arial", 1, 12));
        this.JCBTipoAccion.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Acción", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipoAccion.addItemListener(new ItemListener() { // from class: Sgc.JIFFicha5w1H.2
            public void itemStateChanged(ItemEvent evt) {
                JIFFicha5w1H.this.JCBTipoAccionItemStateChanged(evt);
            }
        });
        this.JCBTOrigen.setFont(new Font("Arial", 1, 12));
        this.JCBTOrigen.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre del Plan de Acción", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPQue.setBorder(BorderFactory.createTitledBorder((Border) null, "Que", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTAQue.setFont(new Font("Arial", 1, 12));
        this.JTAQue.addMouseListener(new MouseAdapter() { // from class: Sgc.JIFFicha5w1H.3
            public void mouseClicked(MouseEvent evt) {
                JIFFicha5w1H.this.JTAQueMouseClicked(evt);
            }
        });
        this.JSPQue.setViewportView(this.JTAQue);
        this.JSPParaQue.setBorder(BorderFactory.createTitledBorder((Border) null, "Por Que", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTAParaQue.setFont(new Font("Arial", 1, 12));
        this.JSPParaQue.setViewportView(this.JTAParaQue);
        this.JPIQuien.setBorder(BorderFactory.createTitledBorder((Border) null, "Quien", 0, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JCBProcesoI.setFont(new Font("Arial", 1, 12));
        this.JCBProcesoI.setBorder(BorderFactory.createTitledBorder((Border) null, "Proceso", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBProcesoI.addItemListener(new ItemListener() { // from class: Sgc.JIFFicha5w1H.4
            public void itemStateChanged(ItemEvent evt) {
                JIFFicha5w1H.this.JCBProcesoIItemStateChanged(evt);
            }
        });
        this.JCBResponsableI.setFont(new Font("Arial", 1, 12));
        this.JCBResponsableI.setBorder(BorderFactory.createTitledBorder((Border) null, "Responsable", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBCambiaUsuarioRP.setIcon(new ImageIcon(getClass().getResource("/Imagenes/CitaNP.png")));
        this.JBCambiaUsuarioRP.setToolTipText("Cambiar Responsable");
        this.JBCambiaUsuarioRP.setEnabled(false);
        this.JBCambiaUsuarioRP.addActionListener(new ActionListener() { // from class: Sgc.JIFFicha5w1H.5
            public void actionPerformed(ActionEvent evt) {
                JIFFicha5w1H.this.JBCambiaUsuarioRPActionPerformed(evt);
            }
        });
        GroupLayout JPIQuienLayout = new GroupLayout(this.JPIQuien);
        this.JPIQuien.setLayout(JPIQuienLayout);
        JPIQuienLayout.setHorizontalGroup(JPIQuienLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIQuienLayout.createSequentialGroup().addContainerGap().addGroup(JPIQuienLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBProcesoI, -2, 243, -2).addGroup(JPIQuienLayout.createSequentialGroup().addComponent(this.JCBResponsableI, -2, 378, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBCambiaUsuarioRP, -2, 37, -2))).addContainerGap(-1, 32767)));
        JPIQuienLayout.setVerticalGroup(JPIQuienLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIQuienLayout.createSequentialGroup().addComponent(this.JCBProcesoI, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 8, 32767).addGroup(JPIQuienLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBResponsableI, -2, 50, -2).addComponent(this.JBCambiaUsuarioRP, -1, -1, 32767)).addContainerGap()));
        this.JSPComo.setBorder(BorderFactory.createTitledBorder((Border) null, "Como", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTAComo.setFont(new Font("Arial", 1, 12));
        this.JSPComo.setViewportView(this.JTAComo);
        this.JDFCuando.setBorder(BorderFactory.createTitledBorder((Border) null, "Cuando", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFCuando.setDateFormatString("dd/MM/yyyy");
        this.JDFCuando.setFont(new Font("Arial", 1, 13));
        this.JSPDonde.setBorder(BorderFactory.createTitledBorder((Border) null, "Donde", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTADonde.setFont(new Font("Arial", 1, 12));
        this.JSPDonde.setViewportView(this.JTADonde);
        this.JDFFPCierre.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha P.Cierre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFPCierre.setDateFormatString("dd/MM/yyyy");
        this.JDFFPCierre.setFont(new Font("Arial", 1, 12));
        this.JSPDiasSeg.setFont(new Font("Arial", 1, 12));
        this.JSPDiasSeg.setModel(new SpinnerNumberModel(1, 1, (Comparable) null, 1));
        this.JSPDiasSeg.setBorder(BorderFactory.createTitledBorder((Border) null, "Días Seg", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JLBTipoE.setFont(new Font("Arial", 1, 14));
        this.JLBTipoE.setForeground(Color.red);
        this.JLBTipoE.setHorizontalAlignment(0);
        this.JLBTipoE.setToolTipText("Dar doble clic para visualizar reporte");
        this.JLBTipoE.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JLBTipoE.addMouseListener(new MouseAdapter() { // from class: Sgc.JIFFicha5w1H.6
            public void mouseClicked(MouseEvent evt) {
                JIFFicha5w1H.this.JLBTipoEMouseClicked(evt);
            }
        });
        GroupLayout JPIDInternosLayout = new GroupLayout(this.JPIDInternos);
        this.JPIDInternos.setLayout(JPIDInternosLayout);
        JPIDInternosLayout.setHorizontalGroup(JPIDInternosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDInternosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDInternosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDInternosLayout.createSequentialGroup().addGroup(JPIDInternosLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JCBTipoAccion, 0, -1, 32767).addComponent(this.JCBTOrigen, 0, 289, 32767)).addGap(18, 18, 18).addComponent(this.JSPQue, -2, 202, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPParaQue, -2, 192, -2).addGap(11, 11, 11).addComponent(this.JSPComo)).addGroup(JPIDInternosLayout.createSequentialGroup().addComponent(this.JPIQuien, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDInternosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDInternosLayout.createSequentialGroup().addComponent(this.JDFCuando, -2, 120, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JDFFPCierre, -2, 120, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPDiasSeg, -2, 91, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JLBTipoE, -1, -1, 32767)).addComponent(this.JSPDonde)))).addContainerGap()));
        JPIDInternosLayout.setVerticalGroup(JPIDInternosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDInternosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDInternosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSPParaQue, GroupLayout.Alignment.LEADING, -1, 106, 32767).addComponent(this.JSPQue, GroupLayout.Alignment.LEADING, -1, 106, 32767).addGroup(GroupLayout.Alignment.LEADING, JPIDInternosLayout.createSequentialGroup().addComponent(this.JCBTipoAccion, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBTOrigen, -2, -1, -2)).addComponent(this.JSPComo, -1, 106, 32767)).addGap(18, 18, 18).addGroup(JPIDInternosLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JPIQuien, -2, -1, -2).addGroup(GroupLayout.Alignment.TRAILING, JPIDInternosLayout.createSequentialGroup().addComponent(this.JSPDonde).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDInternosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDInternosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDFCuando, -2, -1, -2).addComponent(this.JDFFPCierre, -2, -1, -2)).addGroup(JPIDInternosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JLBTipoE, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JSPDiasSeg, GroupLayout.Alignment.LEADING))))).addContainerGap()));
        this.JPIDatosCierre.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS DE CIERRE", 0, 0, new Font("Arial", 1, 14), Color.red));
        this.JDFFechaCierre.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaCierre.setDateFormatString("dd/MM/yyyy");
        this.JDFFechaCierre.setFont(new Font("Arial", 1, 12));
        this.JPIEficaz.setBorder(BorderFactory.createTitledBorder((Border) null, "Eficaz?", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBGEficaz.add(this.JRBNo);
        this.JRBNo.setFont(new Font("Arial", 1, 12));
        this.JRBNo.setText("No");
        this.JRBNo.addActionListener(new ActionListener() { // from class: Sgc.JIFFicha5w1H.7
            public void actionPerformed(ActionEvent evt) {
                JIFFicha5w1H.this.JRBNoActionPerformed(evt);
            }
        });
        this.JBGEficaz.add(this.JRBSi);
        this.JRBSi.setFont(new Font("Arial", 1, 12));
        this.JRBSi.setText("Si");
        this.JRBSi.addActionListener(new ActionListener() { // from class: Sgc.JIFFicha5w1H.8
            public void actionPerformed(ActionEvent evt) {
                JIFFicha5w1H.this.JRBSiActionPerformed(evt);
            }
        });
        GroupLayout JPIEficazLayout = new GroupLayout(this.JPIEficaz);
        this.JPIEficaz.setLayout(JPIEficazLayout);
        JPIEficazLayout.setHorizontalGroup(JPIEficazLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIEficazLayout.createSequentialGroup().addContainerGap().addComponent(this.JRBSi).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 14, 32767).addComponent(this.JRBNo)));
        JPIEficazLayout.setVerticalGroup(JPIEficazLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIEficazLayout.createSequentialGroup().addContainerGap().addGroup(JPIEficazLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBNo).addComponent(this.JRBSi)).addContainerGap(-1, 32767)));
        this.JSPObsCierre.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTAObsCierre.setFont(new Font("Arial", 1, 12));
        this.JSPObsCierre.setViewportView(this.JTAObsCierre);
        this.JBTAdicionarC.setFont(new Font("Arial", 1, 12));
        this.JBTAdicionarC.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTAdicionarC.setText("Grabar Cierre");
        this.JBTAdicionarC.addActionListener(new ActionListener() { // from class: Sgc.JIFFicha5w1H.9
            public void actionPerformed(ActionEvent evt) {
                JIFFicha5w1H.this.JBTAdicionarCActionPerformed(evt);
            }
        });
        this.JBTAdicionarC1.setFont(new Font("Arial", 1, 12));
        this.JBTAdicionarC1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/enviar.png")));
        this.JBTAdicionarC1.setText("Enviar Email Para Aprendizaje Organizacional");
        this.JBTAdicionarC1.addActionListener(new ActionListener() { // from class: Sgc.JIFFicha5w1H.10
            public void actionPerformed(ActionEvent evt) {
                JIFFicha5w1H.this.JBTAdicionarC1ActionPerformed(evt);
            }
        });
        GroupLayout JPIDatosCierreLayout = new GroupLayout(this.JPIDatosCierre);
        this.JPIDatosCierre.setLayout(JPIDatosCierreLayout);
        JPIDatosCierreLayout.setHorizontalGroup(JPIDatosCierreLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosCierreLayout.createSequentialGroup().addGroup(JPIDatosCierreLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosCierreLayout.createSequentialGroup().addComponent(this.JDFFechaCierre, -2, 120, -2).addGap(18, 18, 18).addComponent(this.JPIEficaz, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPObsCierre)).addGroup(JPIDatosCierreLayout.createSequentialGroup().addComponent(this.JBTAdicionarC, -2, 438, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JBTAdicionarC1, -2, 438, -2))).addContainerGap()));
        JPIDatosCierreLayout.setVerticalGroup(JPIDatosCierreLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosCierreLayout.createSequentialGroup().addGroup(JPIDatosCierreLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPObsCierre).addGroup(JPIDatosCierreLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JDFFechaCierre, GroupLayout.Alignment.LEADING, -2, -1, -2).addComponent(this.JPIEficaz, -1, -1, 32767))).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIDatosCierreLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBTAdicionarC, -1, -1, 32767).addComponent(this.JBTAdicionarC1, -2, 45, 32767)).addContainerGap()));
        this.JTB_Seguimiento.setForeground(Color.red);
        this.JTB_Seguimiento.setFont(new Font("Arial", 1, 14));
        this.JDFFechaS.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaS.setDateFormatString("dd/MM/yyyy");
        this.JDFFechaS.setFont(new Font("Arial", 1, 12));
        this.JSPObsSerguimiento.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación Seguimiento", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPObsSerguimiento.setFont(new Font("Arial", 1, 12));
        this.JTAObsSerguimiento.setFont(new Font("Arial", 1, 12));
        this.JSPObsSerguimiento.setViewportView(this.JTAObsSerguimiento);
        this.JBTAdicionar.setFont(new Font("Arial", 1, 12));
        this.JBTAdicionar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTAdicionar.setText("Grabar");
        this.JBTAdicionar.addActionListener(new ActionListener() { // from class: Sgc.JIFFicha5w1H.11
            public void actionPerformed(ActionEvent evt) {
                JIFFicha5w1H.this.JBTAdicionarActionPerformed(evt);
            }
        });
        this.JCHUltimoS.setFont(new Font("Arial", 1, 12));
        this.JCHUltimoS.setForeground(Color.blue);
        this.JCHUltimoS.setText("Ultimo?");
        this.JCHUltimoS.addActionListener(new ActionListener() { // from class: Sgc.JIFFicha5w1H.12
            public void actionPerformed(ActionEvent evt) {
                JIFFicha5w1H.this.JCHUltimoSActionPerformed(evt);
            }
        });
        this.JBTNuevo.setFont(new Font("Arial", 1, 12));
        this.JBTNuevo.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Nuevo29x25.png")));
        this.JBTNuevo.setText("Nuevo");
        this.JBTNuevo.addActionListener(new ActionListener() { // from class: Sgc.JIFFicha5w1H.13
            public void actionPerformed(ActionEvent evt) {
                JIFFicha5w1H.this.JBTNuevoActionPerformed(evt);
            }
        });
        GroupLayout JPIDatosSeguimientosLayout = new GroupLayout(this.JPIDatosSeguimientos);
        this.JPIDatosSeguimientos.setLayout(JPIDatosSeguimientosLayout);
        JPIDatosSeguimientosLayout.setHorizontalGroup(JPIDatosSeguimientosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosSeguimientosLayout.createSequentialGroup().addComponent(this.JDFFechaS, -2, 120, -2).addGap(621, 621, 621).addComponent(this.JCHUltimoS).addGap(18, 18, 18).addGroup(JPIDatosSeguimientosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JBTNuevo, -1, -1, 32767).addComponent(this.JBTAdicionar, GroupLayout.Alignment.LEADING, -1, -1, 32767))).addGroup(JPIDatosSeguimientosLayout.createSequentialGroup().addGap(138, 138, 138).addComponent(this.JSPObsSerguimiento, -2, 601, -2).addGap(243, 243, 243)));
        JPIDatosSeguimientosLayout.setVerticalGroup(JPIDatosSeguimientosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosSeguimientosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosSeguimientosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JCHUltimoS).addComponent(this.JDFFechaS, -2, -1, -2).addGroup(JPIDatosSeguimientosLayout.createSequentialGroup().addComponent(this.JBTNuevo).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTAdicionar)).addComponent(this.JSPObsSerguimiento, GroupLayout.Alignment.LEADING, -2, 97, -2)).addContainerGap(21, 32767)));
        this.JTB_Seguimiento.addTab("SEGUIMIENTO", this.JPIDatosSeguimientos);
        this.JSPDetalleS.setBorder((Border) null);
        this.JSPDetalleS.setFont(new Font("Arial", 1, 12));
        this.JTDetalleS.setFont(new Font("Arial", 1, 12));
        this.JTDetalleS.setForeground(new Color(0, 0, 204));
        this.JTDetalleS.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalleS.setEditingColumn(2);
        this.JTDetalleS.setEditingRow(1);
        this.JTDetalleS.setGridColor(new Color(0, 0, 0));
        this.JTDetalleS.setRowHeight(25);
        this.JTDetalleS.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalleS.setSelectionForeground(Color.blue);
        this.JTDetalleS.setSelectionMode(0);
        this.JTDetalleS.addMouseListener(new MouseAdapter() { // from class: Sgc.JIFFicha5w1H.14
            public void mouseClicked(MouseEvent evt) {
                JIFFicha5w1H.this.JTDetalleSMouseClicked(evt);
            }
        });
        this.JTDetalleS.addKeyListener(new KeyAdapter() { // from class: Sgc.JIFFicha5w1H.15
            public void keyPressed(KeyEvent evt) {
                JIFFicha5w1H.this.JTDetalleSKeyPressed(evt);
            }
        });
        this.JSPDetalleS.setViewportView(this.JTDetalleS);
        this.JTB_Seguimiento.addTab("HISTÓRICO", this.JSPDetalleS);
        GroupLayout JPIRegistroLayout = new GroupLayout(this.JPIRegistro);
        this.JPIRegistro.setLayout(JPIRegistroLayout);
        JPIRegistroLayout.setHorizontalGroup(JPIRegistroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIRegistroLayout.createSequentialGroup().addContainerGap().addGroup(JPIRegistroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIDInternos, -1, -1, 32767).addComponent(this.JTB_Seguimiento).addComponent(this.JPIDatosCierre, GroupLayout.Alignment.TRAILING, -1, -1, 32767)).addContainerGap()));
        JPIRegistroLayout.setVerticalGroup(JPIRegistroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIRegistroLayout.createSequentialGroup().addContainerGap().addComponent(this.JPIDInternos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTB_Seguimiento, -2, 160, -2).addGap(18, 18, 18).addComponent(this.JPIDatosCierre, -2, -1, -2).addContainerGap(-1, 32767)));
        this.JTPDatosFicha.addTab("REGISTRO", this.JPIRegistro);
        this.JPIDBusqueda.setBorder(BorderFactory.createTitledBorder((Border) null, "BÚSQUEDA", 0, 0, new Font("Arial", 1, 14), Color.red));
        this.JDFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicial", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFechaI.addPropertyChangeListener(new PropertyChangeListener() { // from class: Sgc.JIFFicha5w1H.16
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFFicha5w1H.this.JDFechaIPropertyChange(evt);
            }
        });
        this.JDFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Final", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFechaF.setFont(new Font("Arial", 1, 12));
        this.JDFechaF.addPropertyChangeListener(new PropertyChangeListener() { // from class: Sgc.JIFFicha5w1H.17
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFFicha5w1H.this.JDFechaFPropertyChange(evt);
            }
        });
        this.JCBProcesoR.setFont(new Font("Arial", 1, 12));
        this.JCBProcesoR.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de Proceso", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBProcesoR.addItemListener(new ItemListener() { // from class: Sgc.JIFFicha5w1H.18
            public void itemStateChanged(ItemEvent evt) {
                JIFFicha5w1H.this.JCBProcesoRItemStateChanged(evt);
            }
        });
        this.JCHCerradas.setFont(new Font("Arial", 1, 12));
        this.JCHCerradas.setForeground(Color.blue);
        this.JCHCerradas.setText("Cerradas");
        this.JCHCerradas.addActionListener(new ActionListener() { // from class: Sgc.JIFFicha5w1H.19
            public void actionPerformed(ActionEvent evt) {
                JIFFicha5w1H.this.JCHCerradasActionPerformed(evt);
            }
        });
        this.JCHPorCerrada.setFont(new Font("Arial", 1, 12));
        this.JCHPorCerrada.setForeground(Color.blue);
        this.JCHPorCerrada.setText("Por Cerrar");
        this.JCHPorCerrada.addActionListener(new ActionListener() { // from class: Sgc.JIFFicha5w1H.20
            public void actionPerformed(ActionEvent evt) {
                JIFFicha5w1H.this.JCHPorCerradaActionPerformed(evt);
            }
        });
        this.JCHTodas.setFont(new Font("Arial", 1, 12));
        this.JCHTodas.setForeground(Color.blue);
        this.JCHTodas.setSelected(true);
        this.JCHTodas.setText("Todas");
        this.JCHTodas.addActionListener(new ActionListener() { // from class: Sgc.JIFFicha5w1H.21
            public void actionPerformed(ActionEvent evt) {
                JIFFicha5w1H.this.JCHTodasActionPerformed(evt);
            }
        });
        this.JCHFFiltro.setFont(new Font("Arial", 1, 12));
        this.JCHFFiltro.setForeground(Color.blue);
        this.JCHFFiltro.setSelected(true);
        this.JCHFFiltro.setText("Filtro?");
        this.JCHFFiltro.addActionListener(new ActionListener() { // from class: Sgc.JIFFicha5w1H.22
            public void actionPerformed(ActionEvent evt) {
                JIFFicha5w1H.this.JCHFFiltroActionPerformed(evt);
            }
        });
        this.JCHFiltroAccion.setFont(new Font("Arial", 1, 12));
        this.JCHFiltroAccion.setForeground(Color.blue);
        this.JCHFiltroAccion.setText("Filtro x Acción");
        this.JCHFiltroAccion.addActionListener(new ActionListener() { // from class: Sgc.JIFFicha5w1H.23
            public void actionPerformed(ActionEvent evt) {
                JIFFicha5w1H.this.JCHFiltroAccionActionPerformed(evt);
            }
        });
        GroupLayout JPIDBusquedaLayout = new GroupLayout(this.JPIDBusqueda);
        this.JPIDBusqueda.setLayout(JPIDBusquedaLayout);
        JPIDBusquedaLayout.setHorizontalGroup(JPIDBusquedaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDBusquedaLayout.createSequentialGroup().addContainerGap().addComponent(this.JDFechaI, -2, 120, -2).addGap(13, 13, 13).addComponent(this.JDFechaF, -2, 120, -2).addGap(28, 28, 28).addComponent(this.JCBProcesoR, -2, 375, -2).addGap(18, 18, 18).addGroup(JPIDBusquedaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHCerradas).addComponent(this.JCHPorCerrada)).addGap(18, 18, 18).addGroup(JPIDBusquedaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDBusquedaLayout.createSequentialGroup().addComponent(this.JCHTodas).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 71, 32767).addComponent(this.JCHFFiltro)).addGroup(JPIDBusquedaLayout.createSequentialGroup().addComponent(this.JCHFiltroAccion).addGap(0, 0, 32767))).addContainerGap()));
        JPIDBusquedaLayout.setVerticalGroup(JPIDBusquedaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDBusquedaLayout.createSequentialGroup().addContainerGap().addGroup(JPIDBusquedaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBProcesoR, -2, -1, -2).addGroup(JPIDBusquedaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDFechaF, -2, 50, -2).addComponent(this.JDFechaI, -2, 50, -2)).addGroup(JPIDBusquedaLayout.createSequentialGroup().addGroup(JPIDBusquedaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCHPorCerrada).addComponent(this.JCHFiltroAccion)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDBusquedaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCHCerradas).addComponent(this.JCHFFiltro).addComponent(this.JCHTodas)))).addContainerGap(-1, 32767)));
        this.JSPDetalleH.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JSPDetalleH.setFont(new Font("Arial", 1, 12));
        this.JTDetalleH.setFont(new Font("Arial", 1, 12));
        this.JTDetalleH.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalleH.setEditingColumn(2);
        this.JTDetalleH.setEditingRow(1);
        this.JTDetalleH.setGridColor(new Color(0, 0, 0));
        this.JTDetalleH.setRowHeight(25);
        this.JTDetalleH.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalleH.setSelectionForeground(Color.red);
        this.JTDetalleH.setSelectionMode(0);
        this.JTDetalleH.addMouseListener(new MouseAdapter() { // from class: Sgc.JIFFicha5w1H.24
            public void mouseClicked(MouseEvent evt) {
                JIFFicha5w1H.this.JTDetalleHMouseClicked(evt);
            }
        });
        this.JSPDetalleH.setViewportView(this.JTDetalleH);
        this.JPIDConvenciones.setBorder(BorderFactory.createTitledBorder((Border) null, "Semaforización de Cumplimiento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jCheckBox1.setBackground(new Color(251, 54, 54));
        this.jCheckBox1.setFont(new Font("Arial", 1, 12));
        this.jCheckBox1.setSelected(true);
        this.jCheckBox1.setText("Sin seguimiento");
        this.jCheckBox2.setBackground(Color.yellow);
        this.jCheckBox2.setFont(new Font("Arial", 1, 12));
        this.jCheckBox2.setSelected(true);
        this.jCheckBox2.setText("Con Seguimiento");
        this.jCheckBox3.setBackground(new Color(133, 218, 160));
        this.jCheckBox3.setFont(new Font("Arial", 1, 12));
        this.jCheckBox3.setSelected(true);
        this.jCheckBox3.setText("Cerrada");
        this.jCheckBox4.setBackground(new Color(26, 124, 244));
        this.jCheckBox4.setFont(new Font("Arial", 1, 12));
        this.jCheckBox4.setSelected(true);
        this.jCheckBox4.setText("Aprendizaje F");
        this.jCheckBox5.setBackground(new Color(255, 102, 0));
        this.jCheckBox5.setFont(new Font("Arial", 1, 12));
        this.jCheckBox5.setSelected(true);
        this.jCheckBox5.setText("Aprendizaje A");
        GroupLayout JPIDConvencionesLayout = new GroupLayout(this.JPIDConvenciones);
        this.JPIDConvenciones.setLayout(JPIDConvencionesLayout);
        JPIDConvencionesLayout.setHorizontalGroup(JPIDConvencionesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDConvencionesLayout.createSequentialGroup().addContainerGap().addGroup(JPIDConvencionesLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.jCheckBox4, -1, -1, 32767).addComponent(this.jCheckBox1, -1, -1, 32767)).addGap(18, 18, 18).addGroup(JPIDConvencionesLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jCheckBox2, -1, -1, 32767).addComponent(this.jCheckBox5, -1, -1, 32767)).addGap(18, 18, 18).addComponent(this.jCheckBox3, -2, 121, -2).addContainerGap(16, 32767)));
        JPIDConvencionesLayout.setVerticalGroup(JPIDConvencionesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDConvencionesLayout.createSequentialGroup().addGroup(JPIDConvencionesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jCheckBox1).addComponent(this.jCheckBox2).addComponent(this.jCheckBox3)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 12, 32767).addGroup(JPIDConvencionesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jCheckBox4).addComponent(this.jCheckBox5)).addContainerGap()));
        this.JBTExportarHistorico.setFont(new Font("Arial", 1, 12));
        this.JBTExportarHistorico.setForeground(Color.red);
        this.JBTExportarHistorico.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportarHistorico.setText("Exportar");
        this.JBTExportarHistorico.addActionListener(new ActionListener() { // from class: Sgc.JIFFicha5w1H.25
            public void actionPerformed(ActionEvent evt) {
                JIFFicha5w1H.this.JBTExportarHistoricoActionPerformed(evt);
            }
        });
        this.JTFRutaHistorico.setFont(new Font("Arial", 1, 12));
        this.JTFRutaHistorico.setText("C:\\Genoma\\plantilla");
        this.JTFRutaHistorico.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRutaHistorico.addMouseListener(new MouseAdapter() { // from class: Sgc.JIFFicha5w1H.26
            public void mouseClicked(MouseEvent evt) {
                JIFFicha5w1H.this.JTFRutaHistoricoMouseClicked(evt);
            }
        });
        GroupLayout JPHistoricoLayout = new GroupLayout(this.JPHistorico);
        this.JPHistorico.setLayout(JPHistoricoLayout);
        JPHistoricoLayout.setHorizontalGroup(JPHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPHistoricoLayout.createSequentialGroup().addContainerGap().addGroup(JPHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPHistoricoLayout.createSequentialGroup().addComponent(this.JPIDConvenciones, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JTFRutaHistorico, -2, 367, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBTExportarHistorico, -2, 128, -2).addGap(230, 230, 230)).addGroup(JPHistoricoLayout.createSequentialGroup().addGroup(JPHistoricoLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JSPDetalleH, GroupLayout.Alignment.LEADING).addComponent(this.JPIDBusqueda, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addContainerGap(-1, 32767)))));
        JPHistoricoLayout.setVerticalGroup(JPHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPHistoricoLayout.createSequentialGroup().addContainerGap().addGroup(JPHistoricoLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPHistoricoLayout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.JTFRutaHistorico, -2, 50, -2)).addGroup(JPHistoricoLayout.createSequentialGroup().addComponent(this.JPIDBusqueda, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPDetalleH, -1, 468, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIDConvenciones, -2, -1, -2).addComponent(this.JBTExportarHistorico, GroupLayout.Alignment.TRAILING, -2, 50, -2)))).addContainerGap()));
        this.JTPDatosFicha.addTab("HISTÓRICO", this.JPHistorico);
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JDFechaEvidencia.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaEvidencia.setDateFormatString("dd/MM/yyyy");
        this.JDFechaEvidencia.setFont(new Font("Arial", 1, 12));
        this.JSPDescripcionEvidencia.setBorder(BorderFactory.createTitledBorder((Border) null, "Descripción", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTADescripcionEvidencia.setFont(new Font("Arial", 1, 12));
        this.JSPDescripcionEvidencia.setViewportView(this.JTADescripcionEvidencia);
        this.JTFRutaEvidencia.setFont(new Font("Arial", 1, 12));
        this.JTFRutaEvidencia.setBorder(BorderFactory.createTitledBorder((Border) null, "Ruta", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRutaEvidencia.addMouseListener(new MouseAdapter() { // from class: Sgc.JIFFicha5w1H.27
            public void mouseClicked(MouseEvent evt) {
                JIFFicha5w1H.this.JTFRutaEvidenciaMouseClicked(evt);
            }
        });
        this.JBTGrabarEvidencia.setFont(new Font("Arial", 1, 12));
        this.JBTGrabarEvidencia.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTGrabarEvidencia.setText("Grabar");
        this.JBTGrabarEvidencia.addActionListener(new ActionListener() { // from class: Sgc.JIFFicha5w1H.28
            public void actionPerformed(ActionEvent evt) {
                JIFFicha5w1H.this.JBTGrabarEvidenciaActionPerformed(evt);
            }
        });
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addGap(2, 2, 2).addComponent(this.JDFechaEvidencia, -2, 116, -2).addGap(18, 18, 18).addComponent(this.JSPDescripcionEvidencia, -2, 454, -2).addGap(18, 18, 18).addComponent(this.JTFRutaEvidencia)).addComponent(this.JBTGrabarEvidencia, -1, -1, 32767)).addContainerGap()));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JTFRutaEvidencia, -2, -1, -2).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JDFechaEvidencia, -2, -1, -2).addComponent(this.JSPDescripcionEvidencia, -2, -1, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBTGrabarEvidencia, -2, 46, -2).addContainerGap(23, 32767)));
        this.JSPDetalleEvidencia.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JSPDetalleEvidencia.setFont(new Font("Arial", 1, 12));
        this.JTBDetalleEvidencia.setFont(new Font("Arial", 1, 12));
        this.JTBDetalleEvidencia.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTBDetalleEvidencia.setRowHeight(25);
        this.JTBDetalleEvidencia.setRowMargin(2);
        this.JTBDetalleEvidencia.setSelectionBackground(new Color(255, 255, 255));
        this.JTBDetalleEvidencia.setSelectionForeground(Color.red);
        this.JTBDetalleEvidencia.setSelectionMode(0);
        this.JTBDetalleEvidencia.addMouseListener(new MouseAdapter() { // from class: Sgc.JIFFicha5w1H.29
            public void mouseClicked(MouseEvent evt) {
                JIFFicha5w1H.this.JTBDetalleEvidenciaMouseClicked(evt);
            }
        });
        this.JSPDetalleEvidencia.setViewportView(this.JTBDetalleEvidencia);
        GroupLayout JPIEvidenciaLayout = new GroupLayout(this.JPIEvidencia);
        this.JPIEvidencia.setLayout(JPIEvidenciaLayout);
        JPIEvidenciaLayout.setHorizontalGroup(JPIEvidenciaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIEvidenciaLayout.createSequentialGroup().addContainerGap().addGroup(JPIEvidenciaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDetalleEvidencia, -1, 975, 32767).addComponent(this.JPIDatos, -1, -1, 32767)).addGap(42, 42, 42)));
        JPIEvidenciaLayout.setVerticalGroup(JPIEvidenciaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIEvidenciaLayout.createSequentialGroup().addGap(44, 44, 44).addComponent(this.JPIDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPDetalleEvidencia, -1, 458, 32767).addContainerGap()));
        this.JTPDatosFicha.addTab("EVIDENCIA", this.JPIEvidencia);
        this.JPIAOrganizacional.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JDFechaAO.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaAO.setDateFormatString("dd/MM/yyyy");
        this.JDFechaAO.setFont(new Font("Arial", 1, 12));
        this.JDFechaAO.addPropertyChangeListener(new PropertyChangeListener() { // from class: Sgc.JIFFicha5w1H.30
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFFicha5w1H.this.JDFechaAOPropertyChange(evt);
            }
        });
        this.JSPAOrganizacional.setBorder(BorderFactory.createTitledBorder((Border) null, "Descripción", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTAAOrganizacional.setFont(new Font("Arial", 1, 12));
        this.JTAAOrganizacional.addMouseListener(new MouseAdapter() { // from class: Sgc.JIFFicha5w1H.31
            public void mouseClicked(MouseEvent evt) {
                JIFFicha5w1H.this.JTAAOrganizacionalMouseClicked(evt);
            }
        });
        this.JSPAOrganizacional.setViewportView(this.JTAAOrganizacional);
        this.JBTGrabarAO.setFont(new Font("Arial", 1, 12));
        this.JBTGrabarAO.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTGrabarAO.setText("Grabar");
        this.JBTGrabarAO.addActionListener(new ActionListener() { // from class: Sgc.JIFFicha5w1H.32
            public void actionPerformed(ActionEvent evt) {
                JIFFicha5w1H.this.JBTGrabarAOActionPerformed(evt);
            }
        });
        GroupLayout JPIAOrganizacionalLayout = new GroupLayout(this.JPIAOrganizacional);
        this.JPIAOrganizacional.setLayout(JPIAOrganizacionalLayout);
        JPIAOrganizacionalLayout.setHorizontalGroup(JPIAOrganizacionalLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIAOrganizacionalLayout.createSequentialGroup().addComponent(this.JDFechaAO, -2, 120, -2).addGap(18, 18, 18).addComponent(this.JSPAOrganizacional, -2, 678, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBTGrabarAO, -1, 147, 32767).addGap(22, 22, 22)));
        JPIAOrganizacionalLayout.setVerticalGroup(JPIAOrganizacionalLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIAOrganizacionalLayout.createSequentialGroup().addContainerGap().addGroup(JPIAOrganizacionalLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPAOrganizacional, GroupLayout.Alignment.TRAILING).addGroup(GroupLayout.Alignment.TRAILING, JPIAOrganizacionalLayout.createSequentialGroup().addGap(0, 83, 32767).addComponent(this.JDFechaAO, -2, 50, -2)).addComponent(this.JBTGrabarAO, -1, -1, 32767)).addContainerGap()));
        this.JSPDetalleAprendizaje.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTDetalleAprendizaje.setFont(new Font("Arial", 1, 12));
        this.JTDetalleAprendizaje.setForeground(new Color(0, 0, 204));
        this.JTDetalleAprendizaje.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalleAprendizaje.setEditingColumn(2);
        this.JTDetalleAprendizaje.setEditingRow(1);
        this.JTDetalleAprendizaje.setGridColor(new Color(0, 0, 0));
        this.JTDetalleAprendizaje.setRowHeight(25);
        this.JTDetalleAprendizaje.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalleAprendizaje.setSelectionForeground(Color.blue);
        this.JTDetalleAprendizaje.setSelectionMode(0);
        this.JTDetalleAprendizaje.addMouseListener(new MouseAdapter() { // from class: Sgc.JIFFicha5w1H.33
            public void mouseClicked(MouseEvent evt) {
                JIFFicha5w1H.this.JTDetalleAprendizajeMouseClicked(evt);
            }
        });
        this.JSPDetalleAprendizaje.setViewportView(this.JTDetalleAprendizaje);
        this.JBTCorreo.setFont(new Font("Arial", 1, 12));
        this.JBTCorreo.setIcon(new ImageIcon(getClass().getResource("/Imagenes/correo_2.png")));
        this.JBTCorreo.setText("Correo");
        this.JBTCorreo.addActionListener(new ActionListener() { // from class: Sgc.JIFFicha5w1H.34
            public void actionPerformed(ActionEvent evt) {
                JIFFicha5w1H.this.JBTCorreoActionPerformed(evt);
            }
        });
        GroupLayout JPIAprendizajeLayout = new GroupLayout(this.JPIAprendizaje);
        this.JPIAprendizaje.setLayout(JPIAprendizajeLayout);
        JPIAprendizajeLayout.setHorizontalGroup(JPIAprendizajeLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIAprendizajeLayout.createSequentialGroup().addContainerGap().addGroup(JPIAprendizajeLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIAOrganizacional, -1, -1, 32767).addComponent(this.JBTCorreo, -1, -1, 32767)).addContainerGap()).addGroup(JPIAprendizajeLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIAprendizajeLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPDetalleAprendizaje, -1, 1007, 32767).addContainerGap())));
        JPIAprendizajeLayout.setVerticalGroup(JPIAprendizajeLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIAprendizajeLayout.createSequentialGroup().addContainerGap().addComponent(this.JPIAOrganizacional, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 433, 32767).addComponent(this.JBTCorreo).addContainerGap()).addGroup(JPIAprendizajeLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIAprendizajeLayout.createSequentialGroup().addContainerGap(149, 32767).addComponent(this.JSPDetalleAprendizaje, -2, 472, -2).addGap(54, 54, 54))));
        this.JTPDatosFicha.addTab("APRENDIZAJE", this.JPIAprendizaje);
        this.JSPDetalleAccion.setBorder(BorderFactory.createTitledBorder((Border) null, "TIPO DE ACCIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JSPDetalleAccion.setFont(new Font("Arial", 1, 12));
        this.JTDetalleAccion.setFont(new Font("Arial", 1, 12));
        this.JTDetalleAccion.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalleAccion.setRowHeight(25);
        this.JTDetalleAccion.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalleAccion.setSelectionForeground(Color.red);
        this.JTDetalleAccion.setSelectionMode(0);
        this.JSPDetalleAccion.setViewportView(this.JTDetalleAccion);
        this.jPanel2.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JBEstado.add(this.JRBTodas);
        this.JRBTodas.setFont(new Font("Arial", 1, 12));
        this.JRBTodas.setSelected(true);
        this.JRBTodas.setText("Todas");
        this.JRBTodas.addActionListener(new ActionListener() { // from class: Sgc.JIFFicha5w1H.35
            public void actionPerformed(ActionEvent evt) {
                JIFFicha5w1H.this.JRBTodasActionPerformed(evt);
            }
        });
        this.JBEstado.add(this.JRBCerradas);
        this.JRBCerradas.setFont(new Font("Arial", 1, 12));
        this.JRBCerradas.setText("Cerradas");
        this.JRBCerradas.addActionListener(new ActionListener() { // from class: Sgc.JIFFicha5w1H.36
            public void actionPerformed(ActionEvent evt) {
                JIFFicha5w1H.this.JRBCerradasActionPerformed(evt);
            }
        });
        this.jPanel4.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha de Reporte", 2, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JDFFechaInicio.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaInicio.setDateFormatString("dd/MM/yyyy");
        this.JDFFechaInicio.setFont(new Font("Arial", 1, 12));
        this.JDFFechaFin.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Fin", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaFin.setDateFormatString("dd/MM/yyyy");
        this.JDFFechaFin.setFont(new Font("Arial", 1, 12));
        GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
        this.jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addContainerGap().addComponent(this.JDFFechaInicio, -2, 120, -2).addGap(28, 28, 28).addComponent(this.JDFFechaFin, -2, 120, -2).addContainerGap(-1, 32767)));
        jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDFFechaInicio, -2, -1, -2).addComponent(this.JDFFechaFin, -2, -1, -2)).addGap(0, 13, 32767)));
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JRBTodas).addComponent(this.JRBCerradas)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.jPanel4, -2, -1, -2).addGap(39, 39, 39)));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.JRBTodas).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBCerradas)).addComponent(this.jPanel4, -2, -1, -2));
        this.JSPDetalleOrigen.setBorder(BorderFactory.createTitledBorder((Border) null, "TIPO DE ORIGEN", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JSPDetalleOrigen.setFont(new Font("Arial", 1, 12));
        this.JTDetalleOrigen.setFont(new Font("Arial", 1, 12));
        this.JTDetalleOrigen.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalleOrigen.setRowHeight(25);
        this.JTDetalleOrigen.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalleOrigen.setSelectionForeground(Color.red);
        this.JTDetalleOrigen.setSelectionMode(0);
        this.JTDetalleOrigen.addMouseListener(new MouseAdapter() { // from class: Sgc.JIFFicha5w1H.37
            public void mouseClicked(MouseEvent evt) {
                JIFFicha5w1H.this.JTDetalleOrigenMouseClicked(evt);
            }
        });
        this.JSPDetalleOrigen.setViewportView(this.JTDetalleOrigen);
        this.JSPDetalleProceso.setBorder(BorderFactory.createTitledBorder((Border) null, "TIPO DE PROCESO", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JSPDetalleProceso.setFont(new Font("Arial", 1, 12));
        this.JTDetalleProceso.setFont(new Font("Arial", 1, 12));
        this.JTDetalleProceso.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalleProceso.setRowHeight(25);
        this.JTDetalleProceso.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalleProceso.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalleProceso.setSelectionMode(0);
        this.JSPDetalleProceso.setViewportView(this.JTDetalleProceso);
        this.JBTGraficoAccion.setFont(new Font("Arial", 1, 12));
        this.JBTGraficoAccion.setForeground(Color.red);
        this.JBTGraficoAccion.setIcon(new ImageIcon(getClass().getResource("/Imagenes/contabilidad.png")));
        this.JBTGraficoAccion.setText("Gráfico");
        this.JBTGraficoAccion.setName("BotonAccion");
        this.JBTGraficoAccion.addActionListener(new ActionListener() { // from class: Sgc.JIFFicha5w1H.38
            public void actionPerformed(ActionEvent evt) {
                JIFFicha5w1H.this.JBTGraficoAccionActionPerformed(evt);
            }
        });
        this.JBTGraficoOrigen.setFont(new Font("Arial", 1, 12));
        this.JBTGraficoOrigen.setForeground(Color.red);
        this.JBTGraficoOrigen.setIcon(new ImageIcon(getClass().getResource("/Imagenes/contabilidad.png")));
        this.JBTGraficoOrigen.setText("Gráfico");
        this.JBTGraficoOrigen.setName("BotonOrigen");
        this.JBTGraficoOrigen.addActionListener(new ActionListener() { // from class: Sgc.JIFFicha5w1H.39
            public void actionPerformed(ActionEvent evt) {
                JIFFicha5w1H.this.JBTGraficoOrigenActionPerformed(evt);
            }
        });
        this.JBTGraficoProceso.setFont(new Font("Arial", 1, 12));
        this.JBTGraficoProceso.setForeground(Color.red);
        this.JBTGraficoProceso.setIcon(new ImageIcon(getClass().getResource("/Imagenes/contabilidad.png")));
        this.JBTGraficoProceso.setText("Gráfico");
        this.JBTGraficoProceso.setName("BotonProceso");
        this.JBTGraficoProceso.addActionListener(new ActionListener() { // from class: Sgc.JIFFicha5w1H.40
            public void actionPerformed(ActionEvent evt) {
                JIFFicha5w1H.this.JBTGraficoProcesoActionPerformed(evt);
            }
        });
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: Sgc.JIFFicha5w1H.41
            public void mouseClicked(MouseEvent evt) {
                JIFFicha5w1H.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setForeground(Color.red);
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/actualizar.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: Sgc.JIFFicha5w1H.42
            public void actionPerformed(ActionEvent evt) {
                JIFFicha5w1H.this.JBTExportarActionPerformed(evt);
            }
        });
        this.jPanel3.setBorder(BorderFactory.createTitledBorder((Border) null, "RESULTADO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JLTotal.setFont(new Font("Arial", 1, 18));
        this.JLTotal.setForeground(new Color(255, 0, 0));
        this.JLTotal.setHorizontalAlignment(0);
        this.JLTotal.setBorder(BorderFactory.createTitledBorder((Border) null, "Total Registros", 2, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JLEficaz.setFont(new Font("Arial", 1, 18));
        this.JLEficaz.setHorizontalAlignment(0);
        this.JLEficaz.setBorder(BorderFactory.createTitledBorder((Border) null, "Eficaz", 2, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JLEficaz.setHorizontalTextPosition(10);
        this.JLNEficaz.setFont(new Font("Arial", 1, 18));
        this.JLNEficaz.setHorizontalAlignment(0);
        this.JLNEficaz.setBorder(BorderFactory.createTitledBorder((Border) null, "No Eficaz", 2, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
        this.jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addGap(20, 20, 20).addComponent(this.JLTotal, -2, 120, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 111, 32767).addComponent(this.JLEficaz, -2, 103, -2).addGap(18, 18, 18).addComponent(this.JLNEficaz, -2, 103, -2).addGap(68, 68, 68)));
        jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLTotal, -2, 57, -2).addComponent(this.JLNEficaz, -2, 57, -2).addComponent(this.JLEficaz, -2, 57, -2)).addGap(0, 0, 32767)));
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDetalleProceso).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDetalleAccion, -2, 382, -2).addGroup(jPanel1Layout.createSequentialGroup().addGap(89, 89, 89).addComponent(this.JBTGraficoAccion, -2, 189, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDetalleOrigen, GroupLayout.Alignment.TRAILING, -2, 519, -2).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addComponent(this.JBTGraficoOrigen, -2, 189, -2).addGap(174, 174, 174)))).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jPanel2, -1, -1, 32767).addGap(18, 18, 18).addComponent(this.jPanel3, -2, -1, -2)).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JTFRuta, -2, 367, -2).addGap(32, 32, 32).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JBTGraficoProceso, -2, 189, -2).addComponent(this.JBTExportar, -2, 128, -2)).addGap(0, 0, 32767))).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jPanel2, -1, -1, 32767).addComponent(this.jPanel3, -1, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDetalleAccion, -2, 176, -2).addComponent(this.JSPDetalleOrigen, -2, 176, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JBTGraficoAccion).addComponent(this.JBTGraficoOrigen)).addGap(18, 18, 18).addComponent(this.JSPDetalleProceso, -1, 102, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTGraficoProceso).addGap(32, 32, 32).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JBTExportar, -2, 50, -2).addComponent(this.JTFRuta, -2, 50, -2)).addGap(73, 73, 73)));
        this.JTPDatosFicha.addTab("INFORMES", this.jPanel1);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTPDatosFicha, -2, 1032, -2).addContainerGap(-1, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTPDatosFicha).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBProcesoIItemStateChanged(ItemEvent evt) {
        if (this.xlleno && this.JCBProcesoI.getSelectedIndex() != -1) {
            ConsultasMySQL xct1 = new ConsultasMySQL();
            this.JCBResponsableI.removeAllItems();
            this.xsql = "SELECT rh_tipo_persona_cargon.Id, persona.NUsuario, persona.Corre FROM persona INNER JOIN rh_tipo_persona_cargon  ON (persona.Id_persona = rh_tipo_persona_cargon.Id_Persona) INNER JOIN s_sgc_usuario_tipoproceso  ON (s_sgc_usuario_tipoproceso.Id_Usuario = persona.Id_persona) WHERE (s_sgc_usuario_tipoproceso.Id_TipoProceso ='" + this.xidprocesoa[this.JCBProcesoI.getSelectedIndex()] + "' AND rh_tipo_persona_cargon.`Estado`=1 ) ORDER BY persona.NUsuario ASC ";
            System.out.println("" + this.xsql);
            this.xidresponsable1 = xct1.llenarComboyLista(this.xsql, this.xidresponsable1, this.JCBResponsableI, 3);
            xct1.cerrarConexionBd();
            this.JCBResponsableI.setSelectedIndex(-1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTAdicionarActionPerformed(ActionEvent evt) {
        if (this.xidseguimiento == 0) {
            if (!Principal.txtNo.getText().isEmpty()) {
                if (!this.xcontrolseguimiento) {
                    if (!this.JTAObsSerguimiento.getText().isEmpty()) {
                        int y = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                        if (y == 0) {
                            this.xsql = "insert into s_sgc_ficha5w1h_seguimiento (Id_Ficha5w1h, FechaS , ObservacionS , Id_RhPersona, Id_TProceso, UsuarioS) values ('" + Principal.txtNo.getText() + "','" + this.xmt.formatoAMD.format(this.JDFFechaS.getDate()) + "','" + this.JTAObsSerguimiento.getText() + "','" + Principal.usuarioSistemaDTO.getIdPersonaCargo() + "','" + Principal.informacionGeneralPrincipalDTO.getIdTipoProceso() + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                            this.xct.ejecutarSQL(this.xsql);
                            this.xct.cerrarConexionBd();
                            if (this.JCHUltimoS.isSelected()) {
                                this.xsql = "update s_sgc_ficha5w1h set nseguimiento=nseguimiento+1, controlseguimiento=1, FechaUltimoSeg='" + this.xmt.formatoAMD.format(this.JDFFechaS.getDate()) + "' where Id=' " + Principal.txtNo.getText() + "'";
                            } else {
                                this.xsql = "update s_sgc_ficha5w1h set nseguimiento=nseguimiento+1, controlseguimiento=0, FechaUltimoSeg='" + this.xmt.formatoAMD.format(this.JDFFechaS.getDate()) + "' where Id=' " + Principal.txtNo.getText() + "'";
                            }
                            this.xct.ejecutarSQL(this.xsql);
                            this.xct.cerrarConexionBd();
                            if (this.JCHUltimoS.isSelected()) {
                                this.xcontrolseguimiento = true;
                                this.xmt.mEnvioCorreoElectronico("Se ha realizado el último seguimiento a la acción N° : " + Principal.txtNo.getText() + " de la ficha 5W1H.\nProceso :" + this.JCBProcesoI.getSelectedItem().toString() + ".\n\nFavor entrar a Genoma Plus y revisar.\n\n\n" + Principal.usuarioSistemaDTO.getNombreUsuario() + "\n" + Principal.usuarioSistemaDTO.getNombreCargoUsuario(), Principal.informacionIps.getEmailSistemaCalidad(), "REGISTRO DE ULTIMO SEGUIMIENTO EN FICHA 5W1H", Principal.usuarioSistemaDTO.getLogin());
                            } else {
                                this.xcontrolseguimiento = false;
                            }
                            mBucarSeguimientos();
                            mBuscarHistorico();
                            this.JDFFechaS.setDate(this.xmt.getFechaActual());
                            this.JTAObsSerguimiento.setText("");
                            this.JTAObsSerguimiento.requestFocus();
                            return;
                        }
                        return;
                    }
                    JOptionPane.showInternalMessageDialog(this, "La observación del seguimiento no puede ser nulo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    this.JTAObsSerguimiento.requestFocus();
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "La acción con ultimo seguimiento registrado;\nno se puede registrar seguimiento", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe tener un registro activo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            return;
        }
        if (!this.xcontrolseguimiento) {
            this.xsql = "update  s_sgc_ficha5w1h_seguimiento set FechaS='" + this.xmt.formatoAMD.format(this.JDFFechaS.getDate()) + "',ObservacionS='" + this.JTAObsSerguimiento.getText() + "' Where Id='" + this.xidseguimiento + "'";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            if (this.JCHUltimoS.isSelected()) {
                this.xsql = "update s_sgc_ficha5w1h set nseguimiento=nseguimiento+1, controlseguimiento=1, FechaUltimoSeg='" + this.xmt.formatoAMD.format(this.JDFFechaS.getDate()) + "' where Id=' " + Principal.txtNo.getText() + "'";
            } else {
                this.xsql = "update s_sgc_ficha5w1h set nseguimiento=nseguimiento+1, controlseguimiento=0, FechaUltimoSeg='" + this.xmt.formatoAMD.format(this.JDFFechaS.getDate()) + "' where Id=' " + Principal.txtNo.getText() + "'";
            }
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            if (this.JCHUltimoS.isSelected()) {
                this.xcontrolseguimiento = true;
                this.xmt.mEnvioCorreoElectronico("Se ha realizado el último seguimiento a la acción N° : " + Principal.txtNo.getText() + " de la ficha 5W1H.\nProceso :" + this.JCBProcesoI.getSelectedItem().toString() + ".\n\nFavor entrar a Genoma Plus y revisar.\n\n\n" + Principal.usuarioSistemaDTO.getNombreUsuario() + "\n" + Principal.usuarioSistemaDTO.getNombreCargoUsuario(), Principal.informacionIps.getEmailSistemaCalidad(), "REGISTRO DE ULTIMO SEGUIMIENTO EN FICHA 5W1H", Principal.usuarioSistemaDTO.getLogin());
            } else {
                this.xcontrolseguimiento = false;
            }
            mBucarSeguimientos();
            mBuscarHistorico();
            this.JDFFechaS.setDate(this.xmt.getFechaActual());
            this.JTAObsSerguimiento.setText("");
            this.JTAObsSerguimiento.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "La acción  con ultimo seguimiento registrado;\nno se puede registrar seguimiento", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleHMouseClicked(MouseEvent evt) {
        if (this.JTDetalleH.getSelectedRow() != -1 && evt.getClickCount() == 2) {
            Principal.txtNo.setText(this.xmodelo1.getValueAt(this.JTDetalleH.getSelectedRow(), 0).toString());
            Principal.txtFecha.setText(this.xmodelo1.getValueAt(this.JTDetalleH.getSelectedRow(), 1).toString());
            Principal.txtEstado.setText(this.xmodelo1.getValueAt(this.JTDetalleH.getSelectedRow(), 14).toString());
            this.JCBTipoAccion.setSelectedItem(this.xmodelo1.getValueAt(this.JTDetalleH.getSelectedRow(), 2).toString());
            this.JCBTOrigen.setSelectedItem(this.xmodelo1.getValueAt(this.JTDetalleH.getSelectedRow(), 3).toString());
            this.JCBProcesoI.setSelectedItem(this.xmodelo1.getValueAt(this.JTDetalleH.getSelectedRow(), 4).toString());
            this.JCBResponsableI.setSelectedItem(this.xmodelo1.getValueAt(this.JTDetalleH.getSelectedRow(), 5).toString());
            this.JTAQue.setText(this.xmodelo1.getValueAt(this.JTDetalleH.getSelectedRow(), 6).toString());
            this.JTAParaQue.setText(this.xmodelo1.getValueAt(this.JTDetalleH.getSelectedRow(), 7).toString());
            this.JTAComo.setText(this.xmodelo1.getValueAt(this.JTDetalleH.getSelectedRow(), 8).toString());
            this.JDFCuando.setDate(this.xmt.getPasarTextoAFecha(this.xmodelo1.getValueAt(this.JTDetalleH.getSelectedRow(), 9).toString()));
            this.JTADonde.setText(this.xmodelo1.getValueAt(this.JTDetalleH.getSelectedRow(), 10).toString());
            if (!this.xmodelo1.getValueAt(this.JTDetalleH.getSelectedRow(), 11).toString().equals("")) {
                this.JDFFPCierre.setDate(this.xmt.getPasarTextoAFecha(this.xmodelo1.getValueAt(this.JTDetalleH.getSelectedRow(), 11).toString()));
            }
            this.JSPDiasSeg.setValue(Integer.valueOf(this.xmodelo1.getValueAt(this.JTDetalleH.getSelectedRow(), 12).toString()));
            this.xcerrada = Boolean.valueOf(this.xmodelo1.getValueAt(this.JTDetalleH.getSelectedRow(), 13).toString()).booleanValue();
            this.xcontrolseguimiento = Boolean.valueOf(this.xmodelo1.getValueAt(this.JTDetalleH.getSelectedRow(), 19).toString()).booleanValue();
            this.xestadog = Boolean.valueOf(this.xmodelo1.getValueAt(this.JTDetalleH.getSelectedRow(), 20).toString()).booleanValue();
            System.out.println(this.xmodelo1.getValueAt(this.JTDetalleH.getSelectedRow(), 20).toString());
            if (Boolean.valueOf(this.xmodelo1.getValueAt(this.JTDetalleH.getSelectedRow(), 15).toString()).booleanValue()) {
                this.JRBSi.setSelected(true);
                this.xeficaz = 1;
            } else {
                this.JRBNo.setSelected(true);
                this.xeficaz = 0;
            }
            this.JDFFechaCierre.setDate(this.xmt.getPasarTextoAFecha(this.xmodelo1.getValueAt(this.JTDetalleH.getSelectedRow(), 16).toString()));
            this.JTAObsCierre.setText(this.xmodelo1.getValueAt(this.JTDetalleH.getSelectedRow(), 17).toString());
            Principal.informacionGeneralPrincipalDTO.setIdTipoProceso(Long.valueOf(this.xidprocesoa[this.JCBProcesoI.getSelectedIndex()]));
            if (!this.xmodelo1.getValueAt(this.JTDetalleH.getSelectedRow(), 30).toString().equals("")) {
                if (Long.valueOf(this.xmodelo1.getValueAt(this.JTDetalleH.getSelectedRow(), 27).toString()).longValue() != 0) {
                    this.xTipo = 0;
                    this.xIdTipoDoc = Long.valueOf(this.xmodelo1.getValueAt(this.JTDetalleH.getSelectedRow(), 27).toString()).longValue();
                } else if (Long.valueOf(this.xmodelo1.getValueAt(this.JTDetalleH.getSelectedRow(), 28).toString()).longValue() != 0) {
                    this.xTipo = 1;
                    this.xIdTipoDoc = Long.valueOf(this.xmodelo1.getValueAt(this.JTDetalleH.getSelectedRow(), 28).toString()).longValue();
                }
                this.JLBTipoE.setBorder(BorderFactory.createTitledBorder((Border) null, this.xmodelo1.getValueAt(this.JTDetalleH.getSelectedRow(), 30).toString(), 0, 0, new Font("Arial", 1, 12), Color.blue));
                this.JLBTipoE.setText(this.xmodelo1.getValueAt(this.JTDetalleH.getSelectedRow(), 29).toString());
                this.JLBTipoE.setVisible(true);
            } else {
                this.JLBTipoE.setVisible(false);
            }
            mLimpiarSeguimiento();
            mBucarSeguimientos();
            mBucarEvidencias();
            mBucarAprendizaje();
            this.JTPDatosFicha.setSelectedIndex(0);
            this.JTAAOrganizacional.setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTAdicionarCActionPerformed(ActionEvent evt) {
        if (this.xmodulo == 1) {
            if (!Principal.txtNo.getText().isEmpty()) {
                if (!this.xcerrada) {
                    if (!this.JTAObsCierre.getText().isEmpty()) {
                        if (this.JTDetalleS.getRowCount() > -1) {
                            int y = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de cerrar la acción?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                            if (y == 0) {
                                this.xsql = "update s_sgc_ficha5w1h set Eficaz='" + this.xeficaz + "', FechaCierre='" + this.xmt.formatoAMD.format(this.JDFFechaCierre.getDate()) + "', ObservacionCierre='" + this.JTAObsCierre.getText() + "', Id_RhPersonaCierre='" + Principal.usuarioSistemaDTO.getIdPersonaCargo() + "' where Id='" + Principal.txtNo.getText() + "'";
                                this.xct.ejecutarSQL(this.xsql);
                                this.xct.cerrarConexionBd();
                                mBuscarHistorico();
                                return;
                            }
                            return;
                        }
                        JOptionPane.showInternalMessageDialog(this, "No se ha registrado ningun seguimiento a la ficha.", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                        return;
                    }
                    JOptionPane.showInternalMessageDialog(this, "La observación del cierre no puede ser nulo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    this.JTAObsCierre.requestFocus();
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "La acción se ecuentra cerrada;", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe tener un registro activo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSiActionPerformed(ActionEvent evt) {
        this.xeficaz = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNoActionPerformed(ActionEvent evt) {
        this.xeficaz = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHUltimoSActionPerformed(ActionEvent evt) {
        if (this.JCHUltimoS.isSelected()) {
            this.xultimoseguimiento = 1;
        } else {
            this.xultimoseguimiento = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        if (this.xmodulo == 0) {
            Principal.mLimpiarDatosP();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleSMouseClicked(MouseEvent evt) {
        if (this.JTDetalleS.getSelectedRow() != -1) {
            this.xidseguimiento = Long.valueOf(this.xmodelo.getValueAt(this.JTDetalleS.getSelectedRow(), 0).toString()).longValue();
            this.JDFFechaS.setDate(this.xmt.getPasarTextoAFecha(this.xmodelo.getValueAt(this.JTDetalleS.getSelectedRow(), 1).toString()));
            this.JTAObsSerguimiento.setText(this.xmodelo.getValueAt(this.JTDetalleS.getSelectedRow(), 2).toString());
            this.JTB_Seguimiento.setSelectedIndex(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTNuevoActionPerformed(ActionEvent evt) {
        this.JDFFechaS.setDate(this.xmt.getFechaActual());
        this.JTAObsSerguimiento.setText("");
        this.JCHUltimoS.setSelected(false);
        this.xidseguimiento = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHFFiltroActionPerformed(ActionEvent evt) {
        if (this.JCHFFiltro.isSelected()) {
            this.xfiltro = 1;
        } else {
            this.xfiltro = 0;
        }
        mBuscarHistorico();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTAQueMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2 && !this.xmodelo1.getValueAt(this.JTDetalleH.getSelectedRow(), 21).equals("0")) {
            this.xIdTipoDoc = Long.valueOf(this.xmodelo1.getValueAt(this.JTDetalleH.getSelectedRow(), 21).toString()).longValue();
            int x = JOptionPane.showInternalConfirmDialog(this, "Desea visualizar la NC?", "VISUALIZAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                Principal.xclasesgc.cargarPantalla("Consultar Reporte NC");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBProcesoRItemStateChanged(ItemEvent evt) {
        if (this.xlleno && this.JCBProcesoR.getSelectedIndex() != -1 && this.JCHFFiltro.isSelected()) {
            mBuscarHistorico();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaIPropertyChange(PropertyChangeEvent evt) {
        if (this.xlleno) {
            mLlenarComboProceso();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaFPropertyChange(PropertyChangeEvent evt) {
        if (this.xlleno) {
            mLlenarComboProceso();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHPorCerradaActionPerformed(ActionEvent evt) {
        mBuscarHistorico();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHCerradasActionPerformed(ActionEvent evt) {
        mBuscarHistorico();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHTodasActionPerformed(ActionEvent evt) {
        mBuscarHistorico();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameActivated(InternalFrameEvent evt) {
        mBuscarHistorico();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaEvidenciaMouseClicked(MouseEvent evt) {
        JFileChooser xfilec;
        if (evt.getClickCount() == 2) {
            if (!Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL LOCAL DE MONTELIBANO") && Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO CAMU DEL PRADO")) {
                xfilec = new JFileChooser("S:\\Gestion_Documental\\EVIDENCIAS 5W1H\\");
            } else {
                xfilec = new JFileChooser(Principal.informacionIps.getUrlDocumentoCalidad());
            }
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
                    this.xsql = "Insert into s_sgc_ficha5w1h_evidencia (Id_Ficha5w1h, FechaE, DescripcionE, Url, UsuarioS) values('" + Principal.txtNo.getText() + "','" + this.xmt.formatoAMD.format(this.JDFechaEvidencia.getDate()) + "','" + this.JTADescripcionEvidencia.getText() + "','" + this.JTFRutaEvidencia.getText() + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                    this.xct.ejecutarSQL(this.xsql);
                    this.xct.cerrarConexionBd();
                    mBucarEvidencias();
                    this.JDFechaEvidencia.setDate(this.xmt.getFechaActual());
                    this.JTADescripcionEvidencia.setText("");
                    this.JTFRutaEvidencia.setText("");
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar la ruta del archivo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                this.JTFRutaEvidencia.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe registrar la descripción", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            this.JTADescripcionEvidencia.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una acción", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBDetalleEvidenciaMouseClicked(MouseEvent evt) {
        if (this.JTBDetalleEvidencia.getSelectedRow() != -1) {
            this.xmt.mostrarPdf(this.xmodeloevidencia.getValueAt(this.JTBDetalleEvidencia.getSelectedRow(), 3).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTAAOrganizacionalMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGrabarAOActionPerformed(ActionEvent evt) {
        if (!Principal.txtNo.getText().isEmpty()) {
            if (this.xcerrada) {
                if (!this.JTAAOrganizacional.getText().isEmpty()) {
                    int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    if (x == 0) {
                        this.xsql = "insert into s_sgc_ficha5w1h_aprendizajeo (`Id_Ficha5w1h`, `FechaAO`, `Descripcion`, `Id_RhPersona`, `UsuarioS`)  values('" + Principal.txtNo.getText() + "','" + this.xmt.formatoAMD.format(this.JDFechaAO.getDate()) + "','" + this.JTAAOrganizacional.getText() + "','" + Principal.usuarioSistemaDTO.getIdPersonaCargo() + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                        this.xct.ejecutarSQL(this.xsql);
                        this.xct.cerrarConexionBd();
                        mNuevoAprendizaje();
                        mBucarAprendizaje();
                        mAprendizaje(1);
                        return;
                    }
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "La descripción no puede ser nula", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                this.JTAAOrganizacional.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "La acción no se encuentra cerrada", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una acción", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaAOPropertyChange(PropertyChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleAprendizajeMouseClicked(MouseEvent evt) {
        if (this.JTDetalleAprendizaje.getSelectedRow() != -1) {
            this.JTAAOrganizacional.setText(this.xmodeloaprendizaje.getValueAt(this.JTDetalleAprendizaje.getSelectedRow(), 2).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTAdicionarC1ActionPerformed(ActionEvent evt) {
        if (!Principal.txtNo.getText().isEmpty()) {
            if (this.xcerrada) {
                System.out.println(this.xidresponsable1[this.JCBResponsableI.getSelectedIndex()][1]);
                this.xmt.mEnvioCorreoElectronico("Favor entrar a Genoma Plus y registrar aprendizaje organizacional a la acción N°: " + Principal.txtNo.getText() + "\n" + this.JCBTipoAccion.getSelectedItem().toString() + " : " + this.JTAQue.getText() + "\n\n\n" + Principal.usuarioSistemaDTO.getNombreUsuario() + "\n" + Principal.usuarioSistemaDTO.getNombreCargoUsuario(), this.xidresponsable1[this.JCBResponsableI.getSelectedIndex()][1], "REALIZAR APRENDIZAJE ORGANIZACIONAL", Principal.usuarioSistemaDTO.getLogin());
                mAprendizaje(0);
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "La acción no se encuentra cerrada", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una acción", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
    }

    private void mAprendizaje(int valor) {
        String sql = "UPDATE `s_sgc_ficha5w1h` SET Aprendizaje='" + valor + "' WHERE Id='" + Principal.txtNo.getText() + "'";
        this.xct.ejecutarSQL(sql);
        this.xct.cerrarConexionBd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGraficoAccionActionPerformed(ActionEvent evt) {
        JFGraficoBarra demo = new JFGraficoBarra("Gráfica de tipo de Acción", "TIPO DE ACCIÓN ENTRE " + this.xmt.formatoDMA.format(this.JDFFechaInicio.getDate()) + " y " + this.xmt.formatoDMA.format(this.JDFFechaFin.getDate()) + "", "BotonAccion", this, "Tipo de Acción", "Cantidad");
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
            if (this.JTDetalleAccion.getRowCount() > -1) {
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
    public void JBTGraficoOrigenActionPerformed(ActionEvent evt) {
        JFGraficoBarra demo = new JFGraficoBarra("Gráfica tipo de Origen", "TIPO DE ORIGEN ENTRE " + this.xmt.formatoDMA.format(this.JDFFechaInicio.getDate()) + " y " + this.xmt.formatoDMA.format(this.JDFFechaFin.getDate()) + "", "BotonOrigen", this, "Tipo de Origen", "Cantidad");
        demo.pack();
        demo.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGraficoProcesoActionPerformed(ActionEvent evt) {
        JFGraficoBarra demo = new JFGraficoBarra("Gráfica tipo de Proceso", "TIPO DE PROCESO ENTRE " + this.xmt.formatoAMD.format(this.JDFFechaInicio.getDate()) + " y " + this.xmt.formatoAMD.format(this.JDFFechaFin.getDate()) + "", "BotonProceso", this, "Tipo de Proceso", "Cantidad");
        demo.pack();
        demo.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBCerradasActionPerformed(ActionEvent evt) {
        this.jPanel4.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha de Cierre", 2, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBTodasActionPerformed(ActionEvent evt) {
        this.jPanel4.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha de Reporte", 2, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleOrigenMouseClicked(MouseEvent evt) {
        if (this.JTDetalleOrigen.getSelectedRow() != -1 && evt.getClickCount() == 2) {
            mBuscarOrigenHistorico();
            this.JTPDatosFicha.setSelectedIndex(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTExportarHistoricoActionPerformed(ActionEvent evt) {
        if (!this.JTFRutaHistorico.getText().isEmpty()) {
            if (this.JTDetalleH.getRowCount() > -1) {
                this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalleH, this.xmt.mTraerUrlBD(this.JTFRutaHistorico.getText()), getTitle());
                return;
            } else {
                JOptionPane.showInternalMessageDialog(this, "No existe información para exportar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                return;
            }
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un ruta valida", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        this.JTFRutaHistorico.requestFocus();
    }

    private void mExportarH() {
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            try {
                WritableWorkbook workbook = Workbook.createWorkbook(new File(this.JTFRutaHistorico.getText() + ".xls"));
                WritableSheet sheet = workbook.createSheet("Accion x Tipo de Origen", 0);
                for (int x = 0; x < this.JTDetalleH.getColumnCount(); x++) {
                    sheet.addCell(new Label(x, 0, this.JTDetalleH.getColumnName(x)));
                }
                for (int x2 = 0; x2 < this.JTDetalleH.getRowCount(); x2++) {
                    sheet.addCell(new Number(0, x2 + 1, Integer.valueOf(this.xmodelo1.getValueAt(x2, 0).toString()).intValue()));
                    sheet.addCell(new Label(1, x2 + 1, this.xmodelo1.getValueAt(x2, 1).toString()));
                    sheet.addCell(new Label(2, x2 + 1, this.xmodelo1.getValueAt(x2, 2).toString()));
                    sheet.addCell(new Label(3, x2 + 1, this.xmodelo1.getValueAt(x2, 3).toString()));
                    sheet.addCell(new Label(4, x2 + 1, this.xmodelo1.getValueAt(x2, 4).toString()));
                    sheet.addCell(new Label(5, x2 + 1, this.xmodelo1.getValueAt(x2, 5).toString()));
                    sheet.addCell(new Label(6, x2 + 1, this.xmodelo1.getValueAt(x2, 6).toString()));
                    sheet.addCell(new Label(7, x2 + 1, this.xmodelo1.getValueAt(x2, 7).toString()));
                    sheet.addCell(new Label(8, x2 + 1, this.xmodelo1.getValueAt(x2, 8).toString()));
                    sheet.addCell(new Label(9, x2 + 1, this.xmodelo1.getValueAt(x2, 9).toString()));
                    sheet.addCell(new Label(10, x2 + 1, this.xmodelo1.getValueAt(x2, 10).toString()));
                    sheet.addCell(new Label(11, x2 + 1, this.xmodelo1.getValueAt(x2, 11).toString()));
                    sheet.addCell(new Number(12, x2 + 1, Integer.valueOf(this.xmodelo1.getValueAt(x2, 12).toString()).intValue()));
                    sheet.addCell(new Label(13, x2 + 1, this.xmodelo1.getValueAt(x2, 13).toString()));
                    sheet.addCell(new Label(14, x2 + 1, this.xmodelo1.getValueAt(x2, 14).toString()));
                    sheet.addCell(new Label(15, x2 + 1, this.xmodelo1.getValueAt(x2, 15).toString()));
                    sheet.addCell(new Label(16, x2 + 1, this.xmodelo1.getValueAt(x2, 16).toString()));
                    sheet.addCell(new Label(17, x2 + 1, this.xmodelo1.getValueAt(x2, 17).toString()));
                    sheet.addCell(new Number(18, x2 + 1, Integer.valueOf(this.xmodelo1.getValueAt(x2, 18).toString()).intValue()));
                    sheet.addCell(new Label(19, x2 + 1, this.xmodelo1.getValueAt(x2, 19).toString()));
                    sheet.addCell(new Label(20, x2 + 1, this.xmodelo1.getValueAt(x2, 20).toString()));
                    sheet.addCell(new Number(21, x2 + 1, Integer.valueOf(this.xmodelo1.getValueAt(x2, 21).toString()).intValue()));
                    sheet.addCell(new Number(22, x2 + 1, Integer.valueOf(this.xmodelo1.getValueAt(x2, 22).toString()).intValue()));
                    sheet.addCell(new Label(23, x2 + 1, this.xmodelo1.getValueAt(x2, 23).toString()));
                    sheet.addCell(new Label(24, x2 + 1, this.xmodelo1.getValueAt(x2, 24).toString()));
                    sheet.addCell(new Label(25, x2 + 1, this.xmodelo1.getValueAt(x2, 25).toString()));
                }
                workbook.write();
                workbook.close();
            } catch (WriteException e) {
                Logger.getLogger(JIFFicha5w1H.class.getName()).log(Level.SEVERE, (String) null, e);
            } catch (IOException ex) {
                Logger.getLogger(JIFFicha5w1H.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaHistoricoMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JFileChooser xfilec = new JFileChooser("C:\\");
            xfilec.setFileSelectionMode(1);
            int xv = xfilec.showOpenDialog(this);
            if (xv == 0) {
                File xfile = xfilec.getSelectedFile();
                this.JTFRutaHistorico.setText(xfile.getAbsolutePath() + "\\");
                this.JTFRutaHistorico.requestFocus();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTCorreoActionPerformed(ActionEvent evt) {
        Desktop d = Desktop.getDesktop();
        try {
            if (this.JTDetalleAprendizaje.getSelectedRow() != -1) {
                URI uri = new URI("mailto", "?SUBJECT=Aprendizaje de la Acción No. " + Principal.txtNo.getText() + " Finalizado&BODY=" + this.xmodeloaprendizaje.getValueAt(this.JTDetalleAprendizaje.getSelectedRow(), 2).toString() + "", null);
                d.mail(uri);
            } else {
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una fila", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            }
        } catch (Exception ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTipoAccionItemStateChanged(ItemEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHFiltroAccionActionPerformed(ActionEvent evt) {
        if (this.JCHFiltroAccion.isSelected() && this.JCBTipoAccion.getSelectedIndex() != -1) {
            mBuscarHistorico();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleSKeyPressed(KeyEvent evt) {
        if (!Principal.txtNo.getText().isEmpty() && this.xestadog && this.JTDetalleS.getSelectedRow() != -1 && evt.getKeyCode() == 127) {
            int y = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de anular?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (y == 0) {
                this.xsql = "update  s_sgc_ficha5w1h_seguimiento set Estado=0 where Id='" + this.xmodelo.getValueAt(this.JTDetalleS.getSelectedRow(), 0) + "'";
                this.xct.ejecutarSQL(this.xsql);
                this.xct.cerrarConexionBd();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBCambiaUsuarioRPActionPerformed(ActionEvent evt) {
        if (!Principal.txtNo.getText().isEmpty()) {
            JDCambiaRP x = new JDCambiaRP(null, true, this);
            x.setVisible(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JLBTipoEMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2 && this.xTipo != -1) {
            this.xFormaBuscar = 0;
            this.xWorkerSQL = null;
            this.xWorkerSQL = new WorkerSQL("Cargando la Informacion...", this);
            this.xWorkerSQL.execute();
        }
    }

    public void mVisualizarDoc() {
        if (this.xFormaBuscar == 0) {
            if (this.xTipo == 0) {
                Principal.xclasesgc.cargarPantalla("Consultar Reporte NC");
                return;
            }
            if (this.xTipo == 1) {
                String[][] parametros = new String[3][2];
                parametros[0][0] = "id";
                parametros[0][1] = String.valueOf(this.xIdTipoDoc);
                parametros[1][0] = "SUBREPORT_DIR";
                parametros[1][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
                parametros[2][0] = "SUBREPORTFIRMA_DIR";
                parametros[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
                this.xmt.GenerarPDF(this.xmt.getRutaRep() + "EventoAdverso", parametros);
                return;
            }
            return;
        }
        if (this.xFormaBuscar == 1) {
            mBuscarM();
        }
    }

    private void mExportar() {
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            try {
                WritableWorkbook workbook = Workbook.createWorkbook(new File(this.JTFRuta.getText() + ".xls"));
                WritableSheet sheet = workbook.createSheet("Tipo de Accion", 0);
                for (int x = 0; x < this.JTDetalleAccion.getColumnCount(); x++) {
                    sheet.addCell(new Label(x, 0, this.JTDetalleAccion.getColumnName(x)));
                }
                for (int x2 = 0; x2 < this.JTDetalleAccion.getRowCount(); x2++) {
                    sheet.addCell(new Label(0, x2 + 1, this.xmodeloaccion.getValueAt(x2, 0).toString()));
                    sheet.addCell(new Number(1, x2 + 1, Integer.valueOf(this.xmodeloaccion.getValueAt(x2, 1).toString()).intValue()));
                }
                WritableSheet sheet2 = workbook.createSheet("Tipo de Origen", 1);
                for (int x3 = 0; x3 < this.JTDetalleOrigen.getColumnCount(); x3++) {
                    sheet2.addCell(new Label(x3, 0, this.JTDetalleOrigen.getColumnName(x3)));
                }
                for (int x4 = 0; x4 < this.JTDetalleOrigen.getRowCount(); x4++) {
                    sheet2.addCell(new Label(0, x4 + 1, this.xmodeloorigen.getValueAt(x4, 0).toString()));
                    sheet2.addCell(new Number(1, x4 + 1, Integer.valueOf(this.xmodeloorigen.getValueAt(x4, 1).toString()).intValue()));
                }
                WritableSheet sheet3 = workbook.createSheet("Tipo Proceso", 2);
                for (int x5 = 0; x5 < this.JTDetalleProceso.getColumnCount(); x5++) {
                    sheet3.addCell(new Label(x5, 0, this.JTDetalleProceso.getColumnName(x5)));
                }
                for (int x6 = 0; x6 < this.JTDetalleProceso.getRowCount(); x6++) {
                    System.out.println(" nFilas " + x6);
                    sheet3.addCell(new Label(0, x6 + 1, this.xmodeloproceso.getValueAt(x6, 0).toString()));
                    sheet3.addCell(new Label(1, x6 + 1, this.xmodeloproceso.getValueAt(x6, 1).toString()));
                    sheet3.addCell(new Number(2, x6 + 1, Integer.valueOf(this.xmodeloproceso.getValueAt(x6, 2).toString()).intValue()));
                }
                workbook.write();
                workbook.close();
            } catch (WriteException e) {
                Logger.getLogger(JIFFicha5w1H.class.getName()).log(Level.SEVERE, (String) null, e);
            } catch (IOException ex) {
                Logger.getLogger(JIFFicha5w1H.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
    }

    public void mGrabar() {
        if (this.JCBTipoAccion.getSelectedIndex() != -1) {
            if (this.JCBTOrigen.getSelectedIndex() != -1) {
                if (this.JCBResponsableI.getSelectedIndex() != -1) {
                    if (!this.JTAQue.getText().isEmpty()) {
                        if (!this.JTAParaQue.getText().isEmpty()) {
                            if (!this.JTAComo.getText().isEmpty()) {
                                if (!this.JTADonde.getText().isEmpty()) {
                                    if (Principal.txtNo.getText().isEmpty()) {
                                        if (this.xidtipoaccion[this.JCBTipoAccion.getSelectedIndex()][1].equals("0")) {
                                            int y = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                                            if (y == 0) {
                                                this.xsql = "insert into s_sgc_ficha5w1h (FechaRF, Id_TipoAccion, Id_Origen, Id_TipoProceso, Id_RhPersonaR, Id_RhPersonaRP, Que, ParaQue, Como, Cuando, Donde, FechaPCierre, NDiasSeguimiento, UsuarioS) values('" + this.xmt.formatoAMD.format(this.xmt.getFechaActual()) + "','" + this.xidtipoaccion[this.JCBTipoAccion.getSelectedIndex()][0] + "','" + this.xidorigen[this.JCBTOrigen.getSelectedIndex()] + "','" + Principal.informacionGeneralPrincipalDTO.getIdTipoProceso() + "','" + this.xidresponsable1[this.JCBResponsableI.getSelectedIndex()][0] + "','" + Principal.usuarioSistemaDTO.getIdPersonaCargo() + "','" + this.JTAQue.getText() + "','" + this.JTAParaQue.getText() + "','" + this.JTAComo.getText() + "','" + this.xmt.formatoAMD.format(this.JDFCuando.getDate()) + "','" + this.JTADonde.getText() + "','" + this.xmt.formatoAMD.format(this.JDFFPCierre.getDate()) + "','" + this.JSPDiasSeg.getValue() + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                                                Principal.txtNo.setText(this.xct.ejecutarSQLId(this.xsql));
                                                this.xct.cerrarConexionBd();
                                                System.out.println("correo: " + this.xidresponsable1[this.JCBResponsableI.getSelectedIndex()][1]);
                                                System.out.println("correo1: " + Principal.usuarioSistemaDTO.getLogin());
                                                if (!this.xidresponsable1[this.JCBResponsableI.getSelectedIndex()][1].isEmpty()) {
                                                    this.xmt.mEnvioCorreoElectronico("Se le ha asignado la responsabilidad de hacer seguimiento en la Ficha 5W1H al tipo de: " + this.JCBTipoAccion.getSelectedItem().toString() + ".\n\nQue:  " + this.JTAQue.getText() + ".\nSe debe hacer seguimiento cada: " + this.JSPDiasSeg.getValue() + " días.\n Fecha probable de cierre: " + this.xmt.formatoDMA.format(this.JDFFPCierre.getDate()) + ".\n\n\n" + Principal.usuarioSistemaDTO.getNombreUsuario() + "\n" + Principal.usuarioSistemaDTO.getNombreCargoUsuario(), this.xidresponsable1[this.JCBResponsableI.getSelectedIndex()][1], "SEGUIMIENTOS EN FICHA 5W1H  - REGISTRO DE ACCION N°" + Principal.txtNo.getText(), Principal.usuarioSistemaDTO.getLogin());
                                                }
                                            }
                                        } else {
                                            JOptionPane.showInternalMessageDialog(this, "Este tipo de acción requiere un analísis previo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                                            this.JCBTipoAccion.requestFocus();
                                        }
                                    } else if (this.xestadog) {
                                        int y2 = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de actualizar?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                                        if (y2 == 0) {
                                            this.xsql = "update s_sgc_ficha5w1h set ParaQue='" + this.JTAParaQue.getText() + "', Como='" + this.JTAComo.getText() + "', Cuando='" + this.xmt.formatoAMD.format(this.JDFCuando.getDate()) + "', Donde='" + this.JTADonde.getText() + "', FechaPCierre='" + this.xmt.formatoAMD.format(this.JDFFPCierre.getDate()) + "', NDiasSeguimiento='" + this.JSPDiasSeg.getValue() + "' where Id='" + Principal.txtNo.getText() + "'";
                                            this.xct.ejecutarSQL(this.xsql);
                                            this.xct.cerrarConexionBd();
                                        }
                                    }
                                    mBuscarHistorico();
                                    return;
                                }
                                JOptionPane.showInternalMessageDialog(this, "El campo donde no puede ser nulo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                                this.JTADonde.requestFocus();
                                return;
                            }
                            JOptionPane.showInternalMessageDialog(this, "El campo como no puede ser nulo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                            this.JTAComo.requestFocus();
                            return;
                        }
                        JOptionPane.showInternalMessageDialog(this, "El campo por que no puede ser nulo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                        this.JTAParaQue.requestFocus();
                        return;
                    }
                    JOptionPane.showInternalMessageDialog(this, "El campo que no puede ser nulo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    this.JTAQue.requestFocus();
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un responsable", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                this.JCBResponsableI.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un origen", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            this.JCBTOrigen.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un tipo de acción", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        this.JCBTipoAccion.requestFocus();
    }

    public void mNuevo() {
        Principal.mLimpiarDatosP();
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        this.JLBTipoE.setVisible(false);
        this.xlleno = false;
        this.xfiltro = 1;
        this.xultimoseguimiento = 0;
        this.JCHUltimoS.setSelected(false);
        this.JCBTipoAccion.removeAllItems();
        this.JDFCuando.setDate(this.xmt.getFechaActual());
        this.JDFechaI.setDate(this.xmt.getFechaActual());
        this.JDFechaF.setDate(this.xmt.getFechaActual());
        this.JDFFechaInicio.setDate(this.xmt.getFechaActual());
        this.JDFFechaFin.setDate(this.xmt.getFechaActual());
        this.xidtipoaccion = this.xct.llenarComboyLista("SELECT Id, Nbre, RAnalisis FROM s_sgc_tipo_accion WHERE (Estado =1) ORDER BY Nbre ASC", this.xidtipoaccion, this.JCBTipoAccion, 3);
        this.JCBTipoAccion.setSelectedIndex(-1);
        this.xct.cerrarConexionBd();
        this.JCBTOrigen.removeAllItems();
        this.JCBResponsableI.removeAllItems();
        this.xidorigen = this.xct.llenarCombo("SELECT Id, Nbre FROM s_sgc_ncorigen WHERE (Estado =1) ORDER BY Nbre ASC", this.xidorigen, this.JCBTOrigen);
        this.JCBTOrigen.setSelectedIndex(-1);
        this.xct.cerrarConexionBd();
        this.JCBProcesoI.removeAllItems();
        this.xsql = "SELECT s_sgc_tipoproceso.`Id`, s_sgc_tipoproceso.`Nbre`   FROM persona  INNER JOIN rh_tipo_persona_cargon   ON (persona.Id_persona = rh_tipo_persona_cargon.Id_Persona)   INNER JOIN s_sgc_usuario_tipoproceso  ON (s_sgc_usuario_tipoproceso.Id_Usuario = persona.Id_persona)  INNER JOIN `s_sgc_tipoproceso`  ON (s_sgc_tipoproceso.id = s_sgc_usuario_tipoproceso.`Id_TipoProceso`)  WHERE (s_sgc_tipoproceso.`Estado`=1) GROUP BY s_sgc_tipoproceso.`Id` ORDER BY s_sgc_tipoproceso.`Nbre` ASC ";
        this.xidprocesoa = this.xct.llenarCombo(this.xsql, this.xidprocesoa, this.JCBProcesoI);
        this.JCBProcesoI.setSelectedIndex(-1);
        this.xct.cerrarConexionBd();
        this.JTAQue.setText("");
        this.JTAParaQue.setText("");
        this.JTADonde.setText("");
        this.JTAComo.setText("");
        this.JSPDiasSeg.setValue(new Integer(1));
        mLimpiarSeguimiento();
        mLimpiarDatosCierre();
        mLlenarComboProceso();
        this.xlleno = true;
        mNuevoEvidencia();
        mNuevoAprendizaje();
        this.JCBTipoAccion.requestFocus();
    }

    private void mNuevoEvidencia() {
        this.JDFechaEvidencia.setDate(this.xmt.getFechaActual());
        this.JTADescripcionEvidencia.setText("");
        this.JTFRutaEvidencia.setText("");
        mCrearTablaEvidencia();
    }

    private void mNuevoAprendizaje() {
        this.JDFechaAO.setDate(this.xmt.getFechaActual());
        this.JTAAOrganizacional.setText("");
        mCrearTablaAprendizaje();
    }

    private void mLlenarComboProceso() {
        this.xlleno = false;
        this.JCBProcesoR.removeAllItems();
        ConsultasMySQL xct1 = new ConsultasMySQL();
        this.xsql = "SELECT s_sgc_tipoproceso.Id, s_sgc_tipoproceso.Nbre FROM s_sgc_ficha5w1h INNER JOIN s_sgc_tipoproceso  ON (s_sgc_ficha5w1h.Id_TipoProceso = s_sgc_tipoproceso.Id) WHERE (s_sgc_ficha5w1h.FechaRF >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND s_sgc_ficha5w1h.Estado =1 AND s_sgc_ficha5w1h.FechaRF <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "') GROUP BY s_sgc_tipoproceso.Id ORDER BY s_sgc_tipoproceso.Nbre ASC ";
        this.xidprocesor = xct1.llenarCombo(this.xsql, this.xidprocesor, this.JCBProcesoR);
        xct1.cerrarConexionBd();
        if (this.xmodulo == 0) {
            this.JCBProcesoR.setSelectedItem(Principal.informacionGeneralPrincipalDTO.getNombreProceso());
        } else {
            this.JCBProcesoR.setSelectedIndex(-1);
        }
        this.xlleno = true;
    }

    private void mLimpiarSeguimiento() {
        this.JDFFechaS.setDate(this.xmt.getFechaActual());
        this.JTAObsSerguimiento.setText("");
        mCrearTablaDetalleSeguimiento();
    }

    private void mLimpiarDatosCierre() {
        this.JDFFechaCierre.setDate(this.xmt.getFechaActual());
        this.xeficaz = 0;
        this.JTAObsCierre.setText("");
    }

    private void mCrearTablaDetalleSeguimiento() {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Fecha", "Observación", "Persona", "Cargo", "Proceso"}) { // from class: Sgc.JIFFicha5w1H.43
            Class[] types = {Long.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.JTDetalleS.setModel(this.xmodelo);
        this.JTDetalleS.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTDetalleS.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTDetalleS.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTDetalleS.getColumnModel().getColumn(1).setPreferredWidth(20);
        this.JTDetalleS.getColumnModel().getColumn(2).setPreferredWidth(400);
        this.JTDetalleS.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTDetalleS.getColumnModel().getColumn(4).setPreferredWidth(50);
        this.JTDetalleS.getColumnModel().getColumn(5).setPreferredWidth(50);
        this.xnfila = -1;
    }

    private void mCrearTablaHistoricoRegistro() {
        this.xmodelo1 = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Fecha", "Tipo Accion", "Origen", "QuienP", "Responsable", "Que", "ParaQue", "Como", "Cuando", "Donde", "FechaPC", "NDíasS", "Cerrada", "EstadoL", "Eficaz", "FechaCierre", "Observación Cierre", "NS", "CS", "EstadoAccion", "Id_Nc", "EStado", "FechaPS", "FechaAO", "DescripcionAO", "Aprendizaje", "NC", "EA", "Etiqueta", "EtiquetaT"}) { // from class: Sgc.JIFFicha5w1H.44
            Class[] types = {Long.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Long.class, Boolean.class, String.class, Boolean.class, String.class, String.class, Long.class, Boolean.class, Boolean.class, Long.class, Long.class, String.class, String.class, String.class, Integer.class, Long.class, Long.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        JTable jTable = this.JTDetalleH;
        JTable jTable2 = this.JTDetalleH;
        jTable.setAutoResizeMode(0);
        this.JTDetalleH.doLayout();
        this.JTDetalleH.setModel(this.xmodelo1);
        this.JTDetalleH.getColumnModel().getColumn(0).setPreferredWidth(50);
        this.JTDetalleH.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDetalleH.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalleH.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTDetalleH.getColumnModel().getColumn(4).setPreferredWidth(0);
        this.JTDetalleH.getColumnModel().getColumn(4).setMinWidth(0);
        this.JTDetalleH.getColumnModel().getColumn(4).setMaxWidth(0);
        this.JTDetalleH.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTDetalleH.getColumnModel().getColumn(6).setPreferredWidth(400);
        this.JTDetalleH.getColumnModel().getColumn(7).setPreferredWidth(0);
        this.JTDetalleH.getColumnModel().getColumn(7).setMinWidth(0);
        this.JTDetalleH.getColumnModel().getColumn(7).setMaxWidth(0);
        this.JTDetalleH.getColumnModel().getColumn(8).setPreferredWidth(0);
        this.JTDetalleH.getColumnModel().getColumn(8).setMinWidth(0);
        this.JTDetalleH.getColumnModel().getColumn(8).setMaxWidth(0);
        this.JTDetalleH.getColumnModel().getColumn(9).setPreferredWidth(0);
        this.JTDetalleH.getColumnModel().getColumn(9).setMinWidth(0);
        this.JTDetalleH.getColumnModel().getColumn(9).setMaxWidth(0);
        this.JTDetalleH.getColumnModel().getColumn(10).setPreferredWidth(0);
        this.JTDetalleH.getColumnModel().getColumn(10).setMinWidth(0);
        this.JTDetalleH.getColumnModel().getColumn(10).setMaxWidth(0);
        this.JTDetalleH.getColumnModel().getColumn(11).setPreferredWidth(0);
        this.JTDetalleH.getColumnModel().getColumn(11).setMinWidth(0);
        this.JTDetalleH.getColumnModel().getColumn(11).setMaxWidth(0);
        this.JTDetalleH.getColumnModel().getColumn(12).setPreferredWidth(100);
        this.JTDetalleH.getColumnModel().getColumn(13).setPreferredWidth(100);
        this.JTDetalleH.getColumnModel().getColumn(14).setPreferredWidth(0);
        this.JTDetalleH.getColumnModel().getColumn(14).setMinWidth(0);
        this.JTDetalleH.getColumnModel().getColumn(14).setMaxWidth(0);
        this.JTDetalleH.getColumnModel().getColumn(15).setPreferredWidth(0);
        this.JTDetalleH.getColumnModel().getColumn(15).setMinWidth(0);
        this.JTDetalleH.getColumnModel().getColumn(15).setMaxWidth(0);
        this.JTDetalleH.getColumnModel().getColumn(16).setPreferredWidth(0);
        this.JTDetalleH.getColumnModel().getColumn(16).setMinWidth(0);
        this.JTDetalleH.getColumnModel().getColumn(16).setMaxWidth(0);
        this.JTDetalleH.getColumnModel().getColumn(17).setPreferredWidth(0);
        this.JTDetalleH.getColumnModel().getColumn(17).setMinWidth(0);
        this.JTDetalleH.getColumnModel().getColumn(17).setMaxWidth(0);
        this.JTDetalleH.getColumnModel().getColumn(18).setPreferredWidth(0);
        this.JTDetalleH.getColumnModel().getColumn(18).setMinWidth(0);
        this.JTDetalleH.getColumnModel().getColumn(18).setMaxWidth(0);
        this.JTDetalleH.getColumnModel().getColumn(19).setPreferredWidth(0);
        this.JTDetalleH.getColumnModel().getColumn(19).setMinWidth(0);
        this.JTDetalleH.getColumnModel().getColumn(19).setMaxWidth(0);
        this.JTDetalleH.getColumnModel().getColumn(20).setPreferredWidth(0);
        this.JTDetalleH.getColumnModel().getColumn(20).setMinWidth(0);
        this.JTDetalleH.getColumnModel().getColumn(20).setMaxWidth(0);
        this.JTDetalleH.getColumnModel().getColumn(21).setPreferredWidth(0);
        this.JTDetalleH.getColumnModel().getColumn(21).setMinWidth(0);
        this.JTDetalleH.getColumnModel().getColumn(21).setMaxWidth(0);
        this.JTDetalleH.getColumnModel().getColumn(22).setPreferredWidth(0);
        this.JTDetalleH.getColumnModel().getColumn(22).setMinWidth(0);
        this.JTDetalleH.getColumnModel().getColumn(22).setMaxWidth(0);
        this.JTDetalleH.getColumnModel().getColumn(23).setPreferredWidth(100);
        this.JTDetalleH.getColumnModel().getColumn(24).setPreferredWidth(0);
        this.JTDetalleH.getColumnModel().getColumn(24).setMinWidth(0);
        this.JTDetalleH.getColumnModel().getColumn(24).setMaxWidth(0);
        this.JTDetalleH.getColumnModel().getColumn(25).setPreferredWidth(0);
        this.JTDetalleH.getColumnModel().getColumn(25).setMinWidth(0);
        this.JTDetalleH.getColumnModel().getColumn(25).setMaxWidth(0);
        this.JTDetalleH.getColumnModel().getColumn(26).setPreferredWidth(0);
        this.JTDetalleH.getColumnModel().getColumn(26).setMinWidth(0);
        this.JTDetalleH.getColumnModel().getColumn(26).setMaxWidth(0);
        this.JTDetalleH.getColumnModel().getColumn(27).setPreferredWidth(0);
        this.JTDetalleH.getColumnModel().getColumn(27).setMinWidth(0);
        this.JTDetalleH.getColumnModel().getColumn(27).setMaxWidth(0);
        this.JTDetalleH.getColumnModel().getColumn(28).setPreferredWidth(0);
        this.JTDetalleH.getColumnModel().getColumn(28).setMinWidth(0);
        this.JTDetalleH.getColumnModel().getColumn(28).setMaxWidth(0);
        this.JTDetalleH.getColumnModel().getColumn(29).setPreferredWidth(0);
        this.JTDetalleH.getColumnModel().getColumn(29).setMinWidth(0);
        this.JTDetalleH.getColumnModel().getColumn(29).setMaxWidth(0);
        this.JTDetalleH.getColumnModel().getColumn(30).setPreferredWidth(0);
        this.JTDetalleH.getColumnModel().getColumn(30).setMinWidth(0);
        this.JTDetalleH.getColumnModel().getColumn(30).setMaxWidth(0);
        this.xnfila1 = -1;
    }

    private void mCrearTablaEvidencia() {
        this.xmodeloevidencia = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Fecha", "Descripción", "Url"}) { // from class: Sgc.JIFFicha5w1H.45
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

    private void mCrearTablaAprendizaje() {
        this.xmodeloaprendizaje = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Fecha", "Descripción", "Responsble", "Cargo"}) { // from class: Sgc.JIFFicha5w1H.46
            Class[] types = {Long.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalleAprendizaje.setModel(this.xmodeloaprendizaje);
        this.JTDetalleAprendizaje.getColumnModel().getColumn(0).setPreferredWidth(5);
        this.JTDetalleAprendizaje.getColumnModel().getColumn(1).setPreferredWidth(10);
        this.JTDetalleAprendizaje.getColumnModel().getColumn(2).setPreferredWidth(400);
        this.JTDetalleAprendizaje.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTDetalleAprendizaje.getColumnModel().getColumn(4).setPreferredWidth(50);
    }

    private void mCrearTablaAccion() {
        this.xmodeloaccion = new DefaultTableModel((Object[][]) null, new String[]{"Nombre", "Cantidad"}) { // from class: Sgc.JIFFicha5w1H.47
            Class[] types = {String.class, Integer.class};
            boolean[] canEdit = {false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalleAccion.setModel(this.xmodeloaccion);
        this.JTDetalleAccion.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTDetalleAccion.getColumnModel().getColumn(1).setPreferredWidth(15);
    }

    private void mCrearTablaOrigen() {
        this.xmodeloorigen = new DefaultTableModel((Object[][]) null, new String[]{"Nombre", "Cantidad", "id"}) { // from class: Sgc.JIFFicha5w1H.48
            Class[] types = {String.class, Integer.class, Integer.class};
            boolean[] canEdit = {false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalleOrigen.setModel(this.xmodeloorigen);
        this.JTDetalleOrigen.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTDetalleOrigen.getColumnModel().getColumn(1).setPreferredWidth(15);
        this.JTDetalleOrigen.getColumnModel().getColumn(2).setPreferredWidth(2);
        this.JTDetalleOrigen.getColumnModel().getColumn(2).setMinWidth(0);
        this.JTDetalleOrigen.getColumnModel().getColumn(2).setMaxWidth(0);
    }

    private void mCrearTablaProceso() {
        this.xmodeloproceso = new DefaultTableModel((Object[][]) null, new String[]{"SubProceso", "Proceso", "Cantidad"}) { // from class: Sgc.JIFFicha5w1H.49
            Class[] types = {String.class, String.class, Integer.class};
            boolean[] canEdit = {false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalleProceso.setModel(this.xmodeloproceso);
        this.JTDetalleProceso.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTDetalleProceso.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDetalleProceso.getColumnModel().getColumn(2).setPreferredWidth(10);
    }

    private void mBuscarAccion() {
        String sql;
        try {
            mCrearTablaAccion();
            if (this.JRBTodas.isSelected()) {
                sql = "SELECT `s_sgc_tipo_accion`.`Nbre` ,COUNT(`s_sgc_ficha5w1h`.`Id`) AS cantidad FROM `s_sgc_ficha5w1h` INNER JOIN `s_sgc_tipo_accion` ON (`s_sgc_ficha5w1h`.`Id_TipoAccion` = `s_sgc_tipo_accion`.`Id`)WHERE (`s_sgc_ficha5w1h`.`FechaRF` >='" + this.xmt.formatoAMD.format(this.JDFFechaInicio.getDate()) + "' AND `s_sgc_ficha5w1h`.`FechaRF`<='" + this.xmt.formatoAMD.format(this.JDFFechaFin.getDate()) + "' AND `s_sgc_ficha5w1h`.`Estado` =1)GROUP BY `s_sgc_tipo_accion`.`Nbre` ORDER BY COUNT(`s_sgc_ficha5w1h`.`Id`) DESC";
            } else {
                sql = "SELECT `s_sgc_tipo_accion`.`Nbre` ,COUNT(`s_sgc_ficha5w1h`.`Id`) AS cantidad FROM `s_sgc_ficha5w1h` INNER JOIN `s_sgc_tipo_accion` ON (`s_sgc_ficha5w1h`.`Id_TipoAccion` = `s_sgc_tipo_accion`.`Id`)WHERE (`s_sgc_ficha5w1h`.`FechaCierre` >='" + this.xmt.formatoAMD.format(this.JDFFechaInicio.getDate()) + "' AND `s_sgc_ficha5w1h`.`FechaCierre`<='" + this.xmt.formatoAMD.format(this.JDFFechaFin.getDate()) + "' AND `s_sgc_ficha5w1h`.`Estado` =1  AND s_sgc_ficha5w1h.`FechaCierre` IS NOT NULL)GROUP BY `s_sgc_tipo_accion`.`Nbre` ORDER BY COUNT(`s_sgc_ficha5w1h`.`Id`) DESC";
            }
            ResultSet xrs = this.xct.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodeloaccion.addRow(this.xdato);
                    this.xmodeloaccion.setValueAt(xrs.getString(1), n, 0);
                    this.xmodeloaccion.setValueAt(Integer.valueOf(xrs.getInt(2)), n, 1);
                    n++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFicha5w1H.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mBuscarOrigen() {
        String sql;
        try {
            mCrearTablaOrigen();
            if (this.JRBTodas.isSelected()) {
                sql = "SELECT `s_sgc_ncorigen`.`Nbre` ,COUNT(`s_sgc_ficha5w1h`.`Id`) AS cantidad, s_sgc_ficha5w1h.Id_Origen  FROM `s_sgc_ficha5w1h`  INNER JOIN  `s_sgc_ncorigen` ON (`s_sgc_ficha5w1h`.`Id_Origen` = `s_sgc_ncorigen`.`Id`)WHERE (`s_sgc_ficha5w1h`.`FechaRF` >='" + this.xmt.formatoAMD.format(this.JDFFechaInicio.getDate()) + "' AND `s_sgc_ficha5w1h`.`FechaRF`<='" + this.xmt.formatoAMD.format(this.JDFFechaFin.getDate()) + "' AND `s_sgc_ficha5w1h`.`Estado` =1)GROUP BY `s_sgc_ncorigen`.`Nbre` ORDER BY COUNT(`s_sgc_ficha5w1h`.`Id`) DESC";
            } else {
                sql = "SELECT `s_sgc_ncorigen`.`Nbre` ,COUNT(`s_sgc_ficha5w1h`.`Id`) AS cantidad, s_sgc_ficha5w1h.Id_Origen  FROM `s_sgc_ficha5w1h`  INNER JOIN  `s_sgc_ncorigen` ON (`s_sgc_ficha5w1h`.`Id_Origen` = `s_sgc_ncorigen`.`Id`)WHERE (`s_sgc_ficha5w1h`.`FechaCierre` >='" + this.xmt.formatoAMD.format(this.JDFFechaInicio.getDate()) + "' AND `s_sgc_ficha5w1h`.`FechaCierre`<='" + this.xmt.formatoAMD.format(this.JDFFechaFin.getDate()) + "' AND `s_sgc_ficha5w1h`.`Estado` =1 AND s_sgc_ficha5w1h.`FechaCierre` IS NOT NULL)GROUP BY `s_sgc_ncorigen`.`Nbre` ORDER BY COUNT(`s_sgc_ficha5w1h`.`Id`) DESC";
            }
            ResultSet xrs = this.xct.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodeloorigen.addRow(this.xdato);
                    this.xmodeloorigen.setValueAt(xrs.getString(1), n, 0);
                    this.xmodeloorigen.setValueAt(Integer.valueOf(xrs.getInt(2)), n, 1);
                    this.xmodeloorigen.setValueAt(Integer.valueOf(xrs.getInt(3)), n, 2);
                    n++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFicha5w1H.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mBuscarOrigenHistorico() {
        String sql;
        mCrearTablaHistoricoRegistro();
        if (this.JRBTodas.isSelected()) {
            sql = "SELECT s_sgc_ficha5w1h.Id, DATE_FORMAT(s_sgc_ficha5w1h.FechaRF,'%d-%m-%Y') AS FechaR , s_sgc_tipo_accion.Nbre, s_sgc_ncorigen.Nbre, s_sgc_tipoproceso.Nbre, persona.NUsuario, IF(s_sgc_ficha5w1h.Que IS NULL, '',s_sgc_ficha5w1h.Que) AS Que , IF(s_sgc_ficha5w1h.ParaQue IS NULL, '',s_sgc_ficha5w1h.ParaQue) AS ParaQue , IF(s_sgc_ficha5w1h.Como IS NULL, '',s_sgc_ficha5w1h.Como) AS Como , DATE_FORMAT(s_sgc_ficha5w1h.Cuando,'%d/%m/%Y') AS Cuando, IF(s_sgc_ficha5w1h.Donde IS NULL, '',s_sgc_ficha5w1h.Donde) AS Como ,  IF( s_sgc_ficha5w1h.FechaPCierre IS NULL, '', DATE_FORMAT(s_sgc_ficha5w1h.FechaPCierre,'%d/%m/%Y') )AS FPCierre , s_sgc_ficha5w1h.NDiasSeguimiento, IF(FechaCierre IS NULL, FALSE, TRUE) AS estadoa , IF(FechaCierre IS NULL, 'ACTIVA', 'CERRADA') AS estadoL,  Eficaz, IF(FechaCierre IS NULL, DATE_FORMAT(NOW(),'%d-%m-%Y'), DATE_FORMAT(FechaCierre,'%d-%m-%Y')) AS FCierre, IF(ObservacionCierre IS NULL, '',ObservacionCierre) AS ObservacionCierre , s_sgc_ficha5w1h.nseguimiento, s_sgc_ficha5w1h.ControlSeguimiento, IF(s_sgc_ficha5w1h.ParaQue IS NULL, TRUE, FALSE) AS VCompletar, s_sgc_ficha5w1h.Id_NC , IF(s_sgc_ficha5w1h.FechaUltimoSeg IS NULL,IF(ADDDATE(s_sgc_ficha5w1h.Cuando,INTERVAL s_sgc_ficha5w1h.NDiasSeguimiento DAY) <=NOW() or (s_sgc_ficha5w1h.Cuando<=now()),1,2),IF(ADDDATE(s_sgc_ficha5w1h.FechaUltimoSeg,INTERVAL s_sgc_ficha5w1h.NDiasSeguimiento DAY) <=NOW(),1,0 ) ) AS ver  , IF(s_sgc_ficha5w1h.FechaUltimoSeg IS NULL,DATE_FORMAT(ADDDATE(s_sgc_ficha5w1h.Cuando,INTERVAL s_sgc_ficha5w1h.NDiasSeguimiento DAY),'%d-%m-%Y'),DATE_FORMAT(ADDDATE(s_sgc_ficha5w1h.FechaUltimoSeg,INTERVAL s_sgc_ficha5w1h.NDiasSeguimiento DAY),'%d-%m-%Y')) AS FPS, IF(s_sgc_ficha5w1h.FechaAprendizaje IS NULL,'',s_sgc_ficha5w1h.FechaAprendizaje) AS FechaAO, IF(s_sgc_ficha5w1h.DescripcionAO IS NULL,'',s_sgc_ficha5w1h.DescripcionAO) AS DescripcionAO,s_sgc_ficha5w1h.Aprendizaje   , IFNULL(s_sgc_analisis.`Id_NC`, 0) NC  , IFNULL(s_sgc_sc_evento_adverso_analisis_acciones.`Id_EventoA`, 0) EA  , IF((IFNULL(s_sgc_analisis.`Id_NC`, 0)<>0 AND IFNULL(s_sgc_sc_evento_adverso_analisis_acciones.`Id_EventoA`, 0)=0), s_sgc_analisis.`Id_NC`, IF((IFNULL(s_sgc_analisis.`Id_NC`, 0)=0 AND IFNULL(s_sgc_sc_evento_adverso_analisis_acciones.`Id_EventoA`, 0)<>0), s_sgc_sc_evento_adverso_analisis_acciones.`Id_EventoA` , '')) Etiqueta ,IF((IFNULL(s_sgc_analisis.`Id_NC`, 0)<>0 AND IFNULL(s_sgc_sc_evento_adverso_analisis_acciones.`Id_EventoA`, 0)=0), 'No conformidad N°', IF((IFNULL(s_sgc_analisis.`Id_NC`, 0)=0 AND IFNULL(s_sgc_sc_evento_adverso_analisis_acciones.`Id_EventoA`, 0)<>0),'Evento adverso N°' , '')) EtiquetaT   FROM s_sgc_ficha5w1h INNER JOIN s_sgc_tipo_accion  ON (s_sgc_ficha5w1h.Id_TipoAccion = s_sgc_tipo_accion.Id) INNER JOIN s_sgc_ncorigen  ON (s_sgc_ficha5w1h.Id_Origen = s_sgc_ncorigen.Id) INNER JOIN s_sgc_tipoproceso  ON (s_sgc_ficha5w1h.Id_TipoProceso = s_sgc_tipoproceso.Id) INNER JOIN rh_tipo_persona_cargon  ON (s_sgc_ficha5w1h.Id_RhPersonaR = rh_tipo_persona_cargon.Id) INNER JOIN persona  ON (persona.Id_persona = rh_tipo_persona_cargon.Id_Persona)  LEFT JOIN `s_sgc_analisis_accion_actividad` ON (s_sgc_analisis_accion_actividad.`Id_Ficha`=s_sgc_ficha5w1h.`Id`)  LEFT JOIN `s_sgc_analisis` ON (s_sgc_analisis.`Id`=s_sgc_analisis_accion_actividad.`Id_Analisis`) LEFT JOIN `s_sgc_sc_evento_adverso_analisis_acciones` ON (s_sgc_sc_evento_adverso_analisis_acciones.`Id_Ficha`=s_sgc_ficha5w1h.`Id`)   WHERE (s_sgc_ficha5w1h.Id_Origen='" + this.xmodeloorigen.getValueAt(this.JTDetalleOrigen.getSelectedRow(), 2) + "' AND s_sgc_ficha5w1h.Estado=1 AND s_sgc_ficha5w1h.FechaRF>='" + this.xmt.formatoAMD.format(this.JDFFechaInicio.getDate()) + "' AND  s_sgc_ficha5w1h.FechaRF<='" + this.xmt.formatoAMD.format(this.JDFFechaFin.getDate()) + "' AND `s_sgc_ficha5w1h`.`Estado` =1) ORDER BY s_sgc_ficha5w1h.FechaRF DESC";
        } else {
            sql = "SELECT s_sgc_ficha5w1h.Id, DATE_FORMAT(s_sgc_ficha5w1h.`FechaCierre`,'%d-%m-%Y') AS FechaR , s_sgc_tipo_accion.Nbre, s_sgc_ncorigen.Nbre, s_sgc_tipoproceso.Nbre, persona.NUsuario, IF(s_sgc_ficha5w1h.Que IS NULL, '',s_sgc_ficha5w1h.Que) AS Que , IF(s_sgc_ficha5w1h.ParaQue IS NULL, '',s_sgc_ficha5w1h.ParaQue) AS ParaQue , IF(s_sgc_ficha5w1h.Como IS NULL, '',s_sgc_ficha5w1h.Como) AS Como , DATE_FORMAT(s_sgc_ficha5w1h.Cuando,'%d/%m/%Y') AS Cuando, IF(s_sgc_ficha5w1h.Donde IS NULL, '',s_sgc_ficha5w1h.Donde) AS Como ,  IF( s_sgc_ficha5w1h.FechaPCierre IS NULL, '', DATE_FORMAT(s_sgc_ficha5w1h.FechaPCierre,'%d/%m/%Y') )AS FPCierre , s_sgc_ficha5w1h.NDiasSeguimiento, IF(FechaCierre IS NULL, FALSE, TRUE) AS estadoa , IF(FechaCierre IS NULL, 'ACTIVA', 'CERRADA') AS estadoL,  Eficaz, IF(FechaCierre IS NULL, DATE_FORMAT(NOW(),'%d-%m-%Y'), DATE_FORMAT(FechaCierre,'%d-%m-%Y')) AS FCierre, IF(ObservacionCierre IS NULL, '',ObservacionCierre) AS ObservacionCierre , s_sgc_ficha5w1h.nseguimiento, s_sgc_ficha5w1h.ControlSeguimiento, IF(s_sgc_ficha5w1h.ParaQue IS NULL, TRUE, FALSE) AS VCompletar, s_sgc_ficha5w1h.Id_NC , IF(s_sgc_ficha5w1h.FechaUltimoSeg IS NULL,IF(ADDDATE(s_sgc_ficha5w1h.Cuando,INTERVAL s_sgc_ficha5w1h.NDiasSeguimiento DAY) <=NOW() or (s_sgc_ficha5w1h.Cuando<=now()),1,2),IF(ADDDATE(s_sgc_ficha5w1h.FechaUltimoSeg,INTERVAL s_sgc_ficha5w1h.NDiasSeguimiento DAY) <=NOW(),1,0 ) ) AS ver  , IF(s_sgc_ficha5w1h.FechaUltimoSeg IS NULL,DATE_FORMAT(ADDDATE(s_sgc_ficha5w1h.Cuando,INTERVAL s_sgc_ficha5w1h.NDiasSeguimiento DAY),'%d-%m-%Y'),DATE_FORMAT(ADDDATE(s_sgc_ficha5w1h.FechaUltimoSeg,INTERVAL s_sgc_ficha5w1h.NDiasSeguimiento DAY),'%d-%m-%Y')) AS FPS, IF(s_sgc_ficha5w1h.FechaAprendizaje IS NULL,'',s_sgc_ficha5w1h.FechaAprendizaje) AS FechaAO, IF(s_sgc_ficha5w1h.DescripcionAO IS NULL,'',s_sgc_ficha5w1h.DescripcionAO) AS DescripcionAO,s_sgc_ficha5w1h.Aprendizaje   , IFNULL(s_sgc_analisis.`Id_NC`, 0) NC  , IFNULL(s_sgc_sc_evento_adverso_analisis_acciones.`Id_EventoA`, 0) EA  , IF((IFNULL(s_sgc_analisis.`Id_NC`, 0)<>0 AND IFNULL(s_sgc_sc_evento_adverso_analisis_acciones.`Id_EventoA`, 0)=0), s_sgc_analisis.`Id_NC`, IF((IFNULL(s_sgc_analisis.`Id_NC`, 0)=0 AND IFNULL(s_sgc_sc_evento_adverso_analisis_acciones.`Id_EventoA`, 0)<>0), s_sgc_sc_evento_adverso_analisis_acciones.`Id_EventoA` , '')) Etiqueta ,IF((IFNULL(s_sgc_analisis.`Id_NC`, 0)<>0 AND IFNULL(s_sgc_sc_evento_adverso_analisis_acciones.`Id_EventoA`, 0)=0), 'No conformidad N°', IF((IFNULL(s_sgc_analisis.`Id_NC`, 0)=0 AND IFNULL(s_sgc_sc_evento_adverso_analisis_acciones.`Id_EventoA`, 0)<>0),'Evento adverso N°' , '')) EtiquetaT   FROM s_sgc_ficha5w1h INNER JOIN s_sgc_tipo_accion  ON (s_sgc_ficha5w1h.Id_TipoAccion = s_sgc_tipo_accion.Id) INNER JOIN s_sgc_ncorigen  ON (s_sgc_ficha5w1h.Id_Origen = s_sgc_ncorigen.Id) INNER JOIN s_sgc_tipoproceso  ON (s_sgc_ficha5w1h.Id_TipoProceso = s_sgc_tipoproceso.Id) INNER JOIN rh_tipo_persona_cargon  ON (s_sgc_ficha5w1h.Id_RhPersonaR = rh_tipo_persona_cargon.Id) INNER JOIN persona  ON (persona.Id_persona = rh_tipo_persona_cargon.Id_Persona)  LEFT JOIN `s_sgc_analisis_accion_actividad` ON (s_sgc_analisis_accion_actividad.`Id_Ficha`=s_sgc_ficha5w1h.`Id`)  LEFT JOIN `s_sgc_analisis` ON (s_sgc_analisis.`Id`=s_sgc_analisis_accion_actividad.`Id_Analisis`) LEFT JOIN `s_sgc_sc_evento_adverso_analisis_acciones` ON (s_sgc_sc_evento_adverso_analisis_acciones.`Id_Ficha`=s_sgc_ficha5w1h.`Id`)   WHERE (s_sgc_ficha5w1h.Id_Origen='" + this.xmodeloorigen.getValueAt(this.JTDetalleOrigen.getSelectedRow(), 2) + "' AND s_sgc_ficha5w1h.Estado=1 AND s_sgc_ficha5w1h.`FechaCierre`>='" + this.xmt.formatoAMD.format(this.JDFFechaInicio.getDate()) + "' AND  s_sgc_ficha5w1h.`FechaCierre`<='" + this.xmt.formatoAMD.format(this.JDFFechaFin.getDate()) + "' AND `s_sgc_ficha5w1h`.`Estado` =1  AND s_sgc_ficha5w1h.`FechaCierre` IS NOT NULL) ORDER BY s_sgc_ficha5w1h.FechaRF DESC";
        }
        System.out.println("Consulta Origen-- " + sql);
        ConsultasMySQL xct2 = new ConsultasMySQL();
        ResultSet xrs = xct2.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.beforeFirst();
                while (xrs.next()) {
                    System.out.println(xrs.getString(1));
                    this.xnfila1++;
                    this.xmodelo1.addRow(this.xdato);
                    this.xmodelo1.setValueAt(Long.valueOf(xrs.getLong(1)), this.xnfila1, 0);
                    this.xmodelo1.setValueAt(xrs.getString(2), this.xnfila1, 1);
                    this.xmodelo1.setValueAt(xrs.getString(3), this.xnfila1, 2);
                    this.xmodelo1.setValueAt(xrs.getString(4), this.xnfila1, 3);
                    this.xmodelo1.setValueAt(xrs.getString(5), this.xnfila1, 4);
                    this.xmodelo1.setValueAt(xrs.getString(6), this.xnfila1, 5);
                    this.xmodelo1.setValueAt(xrs.getString(7), this.xnfila1, 6);
                    this.xmodelo1.setValueAt(xrs.getString(8), this.xnfila1, 7);
                    this.xmodelo1.setValueAt(xrs.getString(9), this.xnfila1, 8);
                    this.xmodelo1.setValueAt(xrs.getString(10), this.xnfila1, 9);
                    this.xmodelo1.setValueAt(xrs.getString(11), this.xnfila1, 10);
                    this.xmodelo1.setValueAt(xrs.getString(12), this.xnfila1, 11);
                    this.xmodelo1.setValueAt(Long.valueOf(xrs.getLong(13)), this.xnfila1, 12);
                    this.xmodelo1.setValueAt(Boolean.valueOf(xrs.getBoolean(14)), this.xnfila1, 13);
                    this.xmodelo1.setValueAt(xrs.getString(15), this.xnfila1, 14);
                    this.xmodelo1.setValueAt(Boolean.valueOf(xrs.getBoolean(16)), this.xnfila1, 15);
                    this.xmodelo1.setValueAt(xrs.getString(17), this.xnfila1, 16);
                    this.xmodelo1.setValueAt(xrs.getString(18), this.xnfila1, 17);
                    this.xmodelo1.setValueAt(Long.valueOf(xrs.getLong(19)), this.xnfila1, 18);
                    this.JTDetalleH.setDefaultRenderer(Object.class, new MiRender());
                    this.xmodelo1.setValueAt(Boolean.valueOf(xrs.getBoolean(20)), this.xnfila1, 19);
                    this.xmodelo1.setValueAt(Boolean.valueOf(xrs.getBoolean(21)), this.xnfila1, 20);
                    this.xmodelo1.setValueAt(Long.valueOf(xrs.getLong(22)), this.xnfila1, 21);
                    this.xmodelo1.setValueAt(Long.valueOf(xrs.getLong(23)), this.xnfila1, 22);
                    this.xmodelo1.setValueAt(xrs.getString(24), this.xnfila1, 23);
                    this.xmodelo1.setValueAt(xrs.getString(25), this.xnfila1, 24);
                    this.xmodelo1.setValueAt(xrs.getString(26), this.xnfila1, 25);
                    this.xmodelo1.setValueAt(Integer.valueOf(xrs.getInt(27)), this.xnfila1, 26);
                    this.xmodelo1.setValueAt(xrs.getString("NC"), this.xnfila1, 27);
                    this.xmodelo1.setValueAt(xrs.getString("EA"), this.xnfila1, 28);
                    this.xmodelo1.setValueAt(xrs.getString("Etiqueta"), this.xnfila1, 29);
                    this.xmodelo1.setValueAt(xrs.getString("EtiquetaT"), this.xnfila1, 30);
                }
            }
            xrs.close();
            xct2.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFicha5w1H.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mBuscarProceso() {
        String sql;
        try {
            mCrearTablaProceso();
            if (this.JRBTodas.isSelected()) {
                sql = "SELECT `s_sgc_tipoproceso`.`Nbre`, `s_sgc_procesos`.`Nbre`,COUNT(`s_sgc_ficha5w1h`.`Id`) AS cantidad  FROM `s_sgc_ficha5w1h` INNER JOIN `s_sgc_tipoproceso`  ON (`s_sgc_ficha5w1h`.`Id_TipoProceso` = `s_sgc_tipoproceso`.`Id`) INNER JOIN `s_sgc_procesos`  ON (`s_sgc_tipoproceso`.`Id_Proceso` = `s_sgc_procesos`.`Id`)WHERE (`s_sgc_ficha5w1h`.`FechaRF` >='" + this.xmt.formatoAMD.format(this.JDFFechaInicio.getDate()) + "' AND `s_sgc_ficha5w1h`.`FechaRF`<='" + this.xmt.formatoAMD.format(this.JDFFechaFin.getDate()) + "' AND `s_sgc_ficha5w1h`.`Estado` =1)GROUP BY `s_sgc_tipoproceso`.`Nbre` ORDER BY COUNT(`s_sgc_ficha5w1h`.`Id`) DESC";
            } else {
                sql = "SELECT `s_sgc_tipoproceso`.`Nbre`, `s_sgc_procesos`.`Nbre`,COUNT(`s_sgc_ficha5w1h`.`Id`) AS cantidad  FROM `s_sgc_ficha5w1h` INNER JOIN `s_sgc_tipoproceso`  ON (`s_sgc_ficha5w1h`.`Id_TipoProceso` = `s_sgc_tipoproceso`.`Id`) INNER JOIN `s_sgc_procesos`  ON (`s_sgc_tipoproceso`.`Id_Proceso` = `s_sgc_procesos`.`Id`)WHERE (`s_sgc_ficha5w1h`.`FechaCierre` >='" + this.xmt.formatoAMD.format(this.JDFFechaInicio.getDate()) + "' AND `s_sgc_ficha5w1h`.`FechaCierre`<='" + this.xmt.formatoAMD.format(this.JDFFechaFin.getDate()) + "' AND `s_sgc_ficha5w1h`.`Estado` =1  AND s_sgc_ficha5w1h.`FechaCierre` IS NOT NULL)GROUP BY `s_sgc_tipoproceso`.`Nbre` ORDER BY COUNT(`s_sgc_ficha5w1h`.`Id`) DESC";
            }
            ResultSet xrs = this.xct.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodeloproceso.addRow(this.xdato);
                    this.xmodeloproceso.setValueAt(xrs.getString(1), n, 0);
                    this.xmodeloproceso.setValueAt(xrs.getString(2), n, 1);
                    this.xmodeloproceso.setValueAt(Integer.valueOf(xrs.getInt(3)), n, 2);
                    n++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFicha5w1H.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mBuscarRegistros() {
        String sql;
        try {
            int e = 0;
            int ne = 0;
            if (this.JRBTodas.isSelected()) {
                sql = "SELECT  COUNT(`Id`) AS cantidad  , IF(`Eficaz`=1,'Eficaz','No Eficaz') AS eficaz  FROM `s_sgc_ficha5w1h` WHERE (`FechaRF` >='" + this.xmt.formatoAMD.format(this.JDFFechaInicio.getDate()) + "' AND `FechaRF`<='" + this.xmt.formatoAMD.format(this.JDFFechaFin.getDate()) + "' AND `Estado` =1) GROUP BY Eficaz";
            } else {
                sql = "SELECT  COUNT(`Id`) AS cantidad  , IF(`Eficaz`=1,'Eficaz','No Eficaz') AS eficaz  FROM `s_sgc_ficha5w1h` WHERE (`FechaCierre` >='" + this.xmt.formatoAMD.format(this.JDFFechaInicio.getDate()) + "' AND `FechaCierre`<='" + this.xmt.formatoAMD.format(this.JDFFechaFin.getDate()) + "' AND `Estado` =1  AND `FechaCierre` IS NOT NULL) GROUP BY Eficaz";
            }
            ResultSet xrs = this.xct.traerRs(sql);
            if (xrs.next()) {
                xrs.first();
                ne = xrs.getInt(1);
                xrs.next();
                e = xrs.getInt(1);
            }
            this.JLEficaz.setText("" + e);
            this.JLNEficaz.setText("" + ne);
            int sum = e + ne;
            this.JLTotal.setText("" + sum);
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFicha5w1H.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mBuscar() {
        this.xFormaBuscar = 1;
        this.xWorkerSQL = null;
        this.xWorkerSQL = new WorkerSQL("Cargando la Informacion...", this);
        this.xWorkerSQL.execute();
    }

    private void mBuscarM() {
        mBuscarAccion();
        mBuscarRegistros();
        mBuscarOrigen();
        mBuscarProceso();
    }

    public void mBuscarHistorico() {
        mCrearTablaHistoricoRegistro();
        this.xsql = "";
        if (this.xmodulo == 0) {
            if (this.xfiltro == 0) {
                if (this.JCHTodas.isSelected()) {
                    this.xsql = "SELECT s_sgc_ficha5w1h.Id, date_format(s_sgc_ficha5w1h.FechaRF,'%d-%m-%Y') as FechaR , s_sgc_tipo_accion.Nbre, s_sgc_ncorigen.Nbre, s_sgc_tipoproceso.Nbre, persona.NUsuario, if(s_sgc_ficha5w1h.Que IS NULL, '',s_sgc_ficha5w1h.Que) as Que , if(s_sgc_ficha5w1h.ParaQue IS NULL, '',s_sgc_ficha5w1h.ParaQue) as ParaQue , if(s_sgc_ficha5w1h.Como IS NULL, '',s_sgc_ficha5w1h.Como) as Como , DATE_FORMAT(s_sgc_ficha5w1h.Cuando,'%d/%m/%Y') AS Cuando, if(s_sgc_ficha5w1h.Donde IS NULL, '',s_sgc_ficha5w1h.Donde) as Como ,  IF( s_sgc_ficha5w1h.FechaPCierre IS NULL, '', DATE_FORMAT(s_sgc_ficha5w1h.FechaPCierre,'%d/%m/%Y') )AS FPCierre , s_sgc_ficha5w1h.NDiasSeguimiento, IF(FechaCierre IS NULL, FALSE, TRUE) AS estadoa, IF(FechaCierre IS NULL, 'ACTIVA', 'CERRADA') AS estadoL,  Eficaz, IF(FechaCierre IS NULL, DATE_FORMAT(NOW(),'%d-%m-%Y'), DATE_FORMAT(FechaCierre,'%d-%m-%Y')) AS FCierre, if(ObservacionCierre IS NULL, '',ObservacionCierre) AS ObservacionCierre, s_sgc_ficha5w1h.nseguimiento, s_sgc_ficha5w1h.ControlSeguimiento, IF(s_sgc_ficha5w1h.ParaQue IS NULL, TRUE, FALSE) AS VCompletar, s_sgc_ficha5w1h.Id_NC , if(s_sgc_ficha5w1h.FechaUltimoSeg is null,if(ADDDATE(s_sgc_ficha5w1h.Cuando,INTERVAL s_sgc_ficha5w1h.NDiasSeguimiento DAY) <=now() or (s_sgc_ficha5w1h.Cuando<=now()),1,2),if(ADDDATE(s_sgc_ficha5w1h.FechaUltimoSeg,INTERVAL s_sgc_ficha5w1h.NDiasSeguimiento DAY) <=NOW(),1,0 ) ) as ver  , IF(s_sgc_ficha5w1h.FechaUltimoSeg IS NULL,DATE_FORMAT(ADDDATE(s_sgc_ficha5w1h.Cuando,INTERVAL s_sgc_ficha5w1h.NDiasSeguimiento DAY),'%d-%m-%Y'),DATE_FORMAT(ADDDATE(s_sgc_ficha5w1h.FechaUltimoSeg,INTERVAL s_sgc_ficha5w1h.NDiasSeguimiento DAY),'%d-%m-%Y')) AS FPS, if(s_sgc_ficha5w1h.FechaAprendizaje is null,'',s_sgc_ficha5w1h.FechaAprendizaje) as FechaAO, IF(s_sgc_ficha5w1h.DescripcionAO IS NULL,'',s_sgc_ficha5w1h.DescripcionAO) AS DescripcionAO,s_sgc_ficha5w1h.Aprendizaje  , IFNULL(s_sgc_analisis.`Id_NC`, 0) NC  , IFNULL(s_sgc_sc_evento_adverso_analisis_acciones.`Id_EventoA`, 0) EA  , IF((IFNULL(s_sgc_analisis.`Id_NC`, 0)<>0 AND IFNULL(s_sgc_sc_evento_adverso_analisis_acciones.`Id_EventoA`, 0)=0), s_sgc_analisis.`Id_NC`, IF((IFNULL(s_sgc_analisis.`Id_NC`, 0)=0 AND IFNULL(s_sgc_sc_evento_adverso_analisis_acciones.`Id_EventoA`, 0)<>0), s_sgc_sc_evento_adverso_analisis_acciones.`Id_EventoA` , '')) Etiqueta ,IF((IFNULL(s_sgc_analisis.`Id_NC`, 0)<>0 AND IFNULL(s_sgc_sc_evento_adverso_analisis_acciones.`Id_EventoA`, 0)=0), 'No conformidad N°', IF((IFNULL(s_sgc_analisis.`Id_NC`, 0)=0 AND IFNULL(s_sgc_sc_evento_adverso_analisis_acciones.`Id_EventoA`, 0)<>0),'Evento adverso N°' , '')) EtiquetaT  FROM s_sgc_ficha5w1h INNER JOIN s_sgc_tipo_accion  ON (s_sgc_ficha5w1h.Id_TipoAccion = s_sgc_tipo_accion.Id) INNER JOIN s_sgc_ncorigen  ON (s_sgc_ficha5w1h.Id_Origen = s_sgc_ncorigen.Id) INNER JOIN s_sgc_tipoproceso  ON (s_sgc_ficha5w1h.Id_TipoProceso = s_sgc_tipoproceso.Id) INNER JOIN rh_tipo_persona_cargon  ON (s_sgc_ficha5w1h.Id_RhPersonaR = rh_tipo_persona_cargon.Id) INNER JOIN persona  ON (persona.Id_persona = rh_tipo_persona_cargon.Id_Persona) LEFT JOIN `s_sgc_analisis_accion_actividad` ON (s_sgc_analisis_accion_actividad.`Id_Ficha`=s_sgc_ficha5w1h.`Id`)  LEFT JOIN `s_sgc_analisis` ON (s_sgc_analisis.`Id`=s_sgc_analisis_accion_actividad.`Id_Analisis`) LEFT JOIN `s_sgc_sc_evento_adverso_analisis_acciones` ON (s_sgc_sc_evento_adverso_analisis_acciones.`Id_Ficha`=s_sgc_ficha5w1h.`Id`)    where (s_sgc_ficha5w1h.Estado=1 AND s_sgc_ficha5w1h.Id_RhPersonaR='" + Principal.usuarioSistemaDTO.getIdPersonaCargo() + "' ) order by s_sgc_ficha5w1h.FechaRF desc ";
                } else if (this.JCHPorCerrada.isSelected()) {
                    this.xsql = "SELECT s_sgc_fcha5w1h.Id, date_format(s_sgc_ficha5w1h.FechaRF,'%d-%m-%Y') as FechaR , s_sgc_tipo_accion.Nbre, s_sgc_ncorigen.Nbre, s_sgc_tipoproceso.Nbre, persona.NUsuario, if(s_sgc_ficha5w1h.Que IS NULL, '',s_sgc_ficha5w1h.Que) as Que , if(s_sgc_ficha5w1h.ParaQue IS NULL, '',s_sgc_ficha5w1h.ParaQue) as ParaQue , if(s_sgc_ficha5w1h.Como IS NULL, '',s_sgc_ficha5w1h.Como) as Como , DATE_FORMAT(s_sgc_ficha5w1h.Cuando,'%d/%m/%Y') AS Cuando, if(s_sgc_ficha5w1h.Donde IS NULL, '',s_sgc_ficha5w1h.Donde) as Como ,  IF( s_sgc_ficha5w1h.FechaPCierre IS NULL, '', DATE_FORMAT(s_sgc_ficha5w1h.FechaPCierre,'%d/%m/%Y') )AS FPCierre , s_sgc_ficha5w1h.NDiasSeguimiento, IF(FechaCierre IS NULL, FALSE, TRUE) AS estadoa, IF(FechaCierre IS NULL, 'ACTIVA', 'CERRADA') AS estadoL,  Eficaz, IF(FechaCierre IS NULL, DATE_FORMAT(NOW(),'%d-%m-%Y'), DATE_FORMAT(FechaCierre,'%d-%m-%Y')) AS FCierre, if(ObservacionCierre IS NULL, '',ObservacionCierre) AS ObservacionCierre, s_sgc_ficha5w1h.nseguimiento, s_sgc_ficha5w1h.ControlSeguimiento, IF(s_sgc_ficha5w1h.ParaQue IS NULL, TRUE, FALSE) AS VCompletar, s_sgc_ficha5w1h.Id_NC , if(s_sgc_ficha5w1h.FechaUltimoSeg is null,if(ADDDATE(s_sgc_ficha5w1h.Cuando,INTERVAL s_sgc_ficha5w1h.NDiasSeguimiento DAY) <=now() or (s_sgc_ficha5w1h.Cuando<=now()),1,2),if(ADDDATE(s_sgc_ficha5w1h.FechaUltimoSeg,INTERVAL s_sgc_ficha5w1h.NDiasSeguimiento DAY) <=NOW(),1,0 ) ) as ver  , IF(s_sgc_ficha5w1h.FechaUltimoSeg IS NULL,DATE_FORMAT(ADDDATE(s_sgc_ficha5w1h.Cuando,INTERVAL s_sgc_ficha5w1h.NDiasSeguimiento DAY),'%d-%m-%Y'),DATE_FORMAT(ADDDATE(s_sgc_ficha5w1h.FechaUltimoSeg,INTERVAL s_sgc_ficha5w1h.NDiasSeguimiento DAY),'%d-%m-%Y')) AS FPS, if(s_sgc_ficha5w1h.FechaAprendizaje is null,'',s_sgc_ficha5w1h.FechaAprendizaje) as FechaAO, IF(s_sgc_ficha5w1h.DescripcionAO IS NULL,'',s_sgc_ficha5w1h.DescripcionAO) AS DescripcionAO,s_sgc_ficha5w1h.Aprendizaje  , IFNULL(s_sgc_analisis.`Id_NC`, 0) NC  , IFNULL(s_sgc_sc_evento_adverso_analisis_acciones.`Id_EventoA`, 0) EA  , IF((IFNULL(s_sgc_analisis.`Id_NC`, 0)<>0 AND IFNULL(s_sgc_sc_evento_adverso_analisis_acciones.`Id_EventoA`, 0)=0), s_sgc_analisis.`Id_NC`, IF((IFNULL(s_sgc_analisis.`Id_NC`, 0)=0 AND IFNULL(s_sgc_sc_evento_adverso_analisis_acciones.`Id_EventoA`, 0)<>0), s_sgc_sc_evento_adverso_analisis_acciones.`Id_EventoA` , '')) Etiqueta ,IF((IFNULL(s_sgc_analisis.`Id_NC`, 0)<>0 AND IFNULL(s_sgc_sc_evento_adverso_analisis_acciones.`Id_EventoA`, 0)=0), 'No conformidad N°', IF((IFNULL(s_sgc_analisis.`Id_NC`, 0)=0 AND IFNULL(s_sgc_sc_evento_adverso_analisis_acciones.`Id_EventoA`, 0)<>0),'Evento adverso N°' , '')) EtiquetaT  FROM s_sgc_ficha5w1h INNER JOIN s_sgc_tipo_accion  ON (s_sgc_ficha5w1h.Id_TipoAccion = s_sgc_tipo_accion.Id) INNER JOIN s_sgc_ncorigen  ON (s_sgc_ficha5w1h.Id_Origen = s_sgc_ncorigen.Id) INNER JOIN s_sgc_tipoproceso  ON (s_sgc_ficha5w1h.Id_TipoProceso = s_sgc_tipoproceso.Id) INNER JOIN rh_tipo_persona_cargon  ON (s_sgc_ficha5w1h.Id_RhPersonaR = rh_tipo_persona_cargon.Id) INNER JOIN persona  ON (persona.Id_persona = rh_tipo_persona_cargon.Id_Persona)  LEFT JOIN `s_sgc_analisis_accion_actividad` ON (s_sgc_analisis_accion_actividad.`Id_Ficha`=s_sgc_ficha5w1h.`Id`)  LEFT JOIN `s_sgc_analisis` ON (s_sgc_analisis.`Id`=s_sgc_analisis_accion_actividad.`Id_Analisis`) LEFT JOIN `s_sgc_sc_evento_adverso_analisis_acciones` ON (s_sgc_sc_evento_adverso_analisis_acciones.`Id_Ficha`=s_sgc_ficha5w1h.`Id`)   where (s_sgc_ficha5w1h.Estado=1 AND s_sgc_ficha5w1h.ControlSeguimiento=1 AND s_sgc_ficha5w1h.Id_RhPersonaR='" + Principal.usuarioSistemaDTO.getIdPersonaCargo() + "' AND IF(FechaCierre IS NULL, FALSE, TRUE)=0) order by s_sgc_ficha5w1h.FechaRF desc ";
                } else if (this.JCHCerradas.isSelected()) {
                    this.xsql = "SELECT s_sgc_ficha5w1h.Id, date_format(s_sgc_ficha5w1h.FechaRF,'%d-%m-%Y') as FechaR , s_sgc_tipo_accion.Nbre, s_sgc_ncorigen.Nbre, s_sgc_tipoproceso.Nbre, persona.NUsuario, if(s_sgc_ficha5w1h.Que IS NULL, '',s_sgc_ficha5w1h.Que) as Que , if(s_sgc_ficha5w1h.ParaQue IS NULL, '',s_sgc_ficha5w1h.ParaQue) as ParaQue , if(s_sgc_ficha5w1h.Como IS NULL, '',s_sgc_ficha5w1h.Como) as Como , DATE_FORMAT(s_sgc_ficha5w1h.Cuando,'%d/%m/%Y') AS Cuando, if(s_sgc_ficha5w1h.Donde IS NULL, '',s_sgc_ficha5w1h.Donde) as Como ,  IF( s_sgc_ficha5w1h.FechaPCierre IS NULL, '', DATE_FORMAT(s_sgc_ficha5w1h.FechaPCierre,'%d/%m/%Y') )AS FPCierre , s_sgc_ficha5w1h.NDiasSeguimiento, IF(FechaCierre IS NULL, FALSE, TRUE) AS estadoa, IF(FechaCierre IS NULL, 'ACTIVA', 'CERRADA') AS estadoL,  Eficaz, IF(FechaCierre IS NULL, DATE_FORMAT(NOW(),'%d-%m-%Y'), DATE_FORMAT(FechaCierre,'%d-%m-%Y')) AS FCierre, if(ObservacionCierre IS NULL, '',ObservacionCierre) AS ObservacionCierre, s_sgc_ficha5w1h.nseguimiento, s_sgc_ficha5w1h.ControlSeguimiento, IF(s_sgc_ficha5w1h.ParaQue IS NULL, TRUE, FALSE) AS VCompletar, s_sgc_ficha5w1h.Id_NC , if(s_sgc_ficha5w1h.FechaUltimoSeg is null,if(ADDDATE(s_sgc_ficha5w1h.Cuando,INTERVAL s_sgc_ficha5w1h.NDiasSeguimiento DAY) <=now() or (s_sgc_ficha5w1h.Cuando<=now()),1,2),if(ADDDATE(s_sgc_ficha5w1h.FechaUltimoSeg,INTERVAL s_sgc_ficha5w1h.NDiasSeguimiento DAY) <=NOW(),1,0 ) ) as ver  , IF(s_sgc_ficha5w1h.FechaUltimoSeg IS NULL,DATE_FORMAT(ADDDATE(s_sgc_ficha5w1h.Cuando,INTERVAL s_sgc_ficha5w1h.NDiasSeguimiento DAY),'%d-%m-%Y'),DATE_FORMAT(ADDDATE(s_sgc_ficha5w1h.FechaUltimoSeg,INTERVAL s_sgc_ficha5w1h.NDiasSeguimiento DAY),'%d-%m-%Y')) AS FPS, if(s_sgc_ficha5w1h.FechaAprendizaje is null,'',s_sgc_ficha5w1h.FechaAprendizaje) as FechaAO, IF(s_sgc_ficha5w1h.DescripcionAO IS NULL,'',s_sgc_ficha5w1h.DescripcionAO) AS DescripcionAO,s_sgc_ficha5w1h.Aprendizaje  , IFNULL(s_sgc_analisis.`Id_NC`, 0) NC  , IFNULL(s_sgc_sc_evento_adverso_analisis_acciones.`Id_EventoA`, 0) EA  , IF((IFNULL(s_sgc_analisis.`Id_NC`, 0)<>0 AND IFNULL(s_sgc_sc_evento_adverso_analisis_acciones.`Id_EventoA`, 0)=0), s_sgc_analisis.`Id_NC`, IF((IFNULL(s_sgc_analisis.`Id_NC`, 0)=0 AND IFNULL(s_sgc_sc_evento_adverso_analisis_acciones.`Id_EventoA`, 0)<>0), s_sgc_sc_evento_adverso_analisis_acciones.`Id_EventoA` , '')) Etiqueta ,IF((IFNULL(s_sgc_analisis.`Id_NC`, 0)<>0 AND IFNULL(s_sgc_sc_evento_adverso_analisis_acciones.`Id_EventoA`, 0)=0), 'No conformidad N°', IF((IFNULL(s_sgc_analisis.`Id_NC`, 0)=0 AND IFNULL(s_sgc_sc_evento_adverso_analisis_acciones.`Id_EventoA`, 0)<>0),'Evento adverso N°' , '')) EtiquetaT  FROM s_sgc_ficha5w1h INNER JOIN s_sgc_tipo_accion  ON (s_sgc_ficha5w1h.Id_TipoAccion = s_sgc_tipo_accion.Id) INNER JOIN s_sgc_ncorigen  ON (s_sgc_ficha5w1h.Id_Origen = s_sgc_ncorigen.Id) INNER JOIN s_sgc_tipoproceso  ON (s_sgc_ficha5w1h.Id_TipoProceso = s_sgc_tipoproceso.Id) INNER JOIN rh_tipo_persona_cargon  ON (s_sgc_ficha5w1h.Id_RhPersonaR = rh_tipo_persona_cargon.Id) INNER JOIN persona  ON (persona.Id_persona = rh_tipo_persona_cargon.Id_Persona)  LEFT JOIN `s_sgc_analisis_accion_actividad` ON (s_sgc_analisis_accion_actividad.`Id_Ficha`=s_sgc_ficha5w1h.`Id`)  LEFT JOIN `s_sgc_analisis` ON (s_sgc_analisis.`Id`=s_sgc_analisis_accion_actividad.`Id_Analisis`) LEFT JOIN `s_sgc_sc_evento_adverso_analisis_acciones` ON (s_sgc_sc_evento_adverso_analisis_acciones.`Id_Ficha`=s_sgc_ficha5w1h.`Id`)   where (s_sgc_ficha5w1h.Estado=1 AND s_sgc_ficha5w1h.Id_RhPersonaR='" + Principal.usuarioSistemaDTO.getIdPersonaCargo() + "' AND s_sgc_ficha5w1h.ControlSeguimiento=1 AND IF(FechaCierre IS NULL, FALSE, TRUE)=1) order by s_sgc_ficha5w1h.FechaRF desc ";
                }
            } else if (this.JCBProcesoR.getSelectedIndex() != -1) {
                if (this.JCHFiltroAccion.isSelected()) {
                    this.xsql = "SELECT s_sgc_ficha5w1h.Id, date_format(s_sgc_ficha5w1h.FechaRF,'%d-%m-%Y') as FechaR , s_sgc_tipo_accion.Nbre, s_sgc_ncorigen.Nbre, s_sgc_tipoproceso.Nbre, persona.NUsuario, if(s_sgc_ficha5w1h.Que IS NULL, '',s_sgc_ficha5w1h.Que) as Que , if(s_sgc_ficha5w1h.ParaQue IS NULL, '',s_sgc_ficha5w1h.ParaQue) as ParaQue , if(s_sgc_ficha5w1h.Como IS NULL, '',s_sgc_ficha5w1h.Como) as Como , DATE_FORMAT(s_sgc_ficha5w1h.Cuando,'%d/%m/%Y') AS Cuando, if(s_sgc_ficha5w1h.Donde IS NULL, '',s_sgc_ficha5w1h.Donde) as Como ,  IF( s_sgc_ficha5w1h.FechaPCierre IS NULL, '', DATE_FORMAT(s_sgc_ficha5w1h.FechaPCierre,'%d/%m/%Y') )AS FPCierre , s_sgc_ficha5w1h.NDiasSeguimiento, IF(FechaCierre IS NULL, FALSE, TRUE) AS estadoa, IF(FechaCierre IS NULL, 'ACTIVA', 'CERRADA') AS estadoL,  Eficaz, IF(FechaCierre IS NULL, DATE_FORMAT(NOW(),'%d-%m-%Y'), DATE_FORMAT(FechaCierre,'%d-%m-%Y')) AS FCierre, if(ObservacionCierre IS NULL, '',ObservacionCierre) AS ObservacionCierre, s_sgc_ficha5w1h.nseguimiento, s_sgc_ficha5w1h.ControlSeguimiento, IF(s_sgc_ficha5w1h.ParaQue IS NULL, TRUE, FALSE) AS VCompletar, s_sgc_ficha5w1h.Id_NC , if(s_sgc_ficha5w1h.FechaUltimoSeg is null,if(ADDDATE(s_sgc_ficha5w1h.Cuando,INTERVAL s_sgc_ficha5w1h.NDiasSeguimiento DAY) <=now() or (s_sgc_ficha5w1h.Cuando<=now()),1,2),if(ADDDATE(s_sgc_ficha5w1h.FechaUltimoSeg,INTERVAL s_sgc_ficha5w1h.NDiasSeguimiento DAY) <=NOW(),1,0 ) ) as ver  , IF(s_sgc_ficha5w1h.FechaUltimoSeg IS NULL,DATE_FORMAT(ADDDATE(s_sgc_ficha5w1h.Cuando,INTERVAL s_sgc_ficha5w1h.NDiasSeguimiento DAY),'%d-%m-%Y'),DATE_FORMAT(ADDDATE(s_sgc_ficha5w1h.FechaUltimoSeg,INTERVAL s_sgc_ficha5w1h.NDiasSeguimiento DAY),'%d-%m-%Y')) AS FPS, if(s_sgc_ficha5w1h.FechaAprendizaje is null,'',s_sgc_ficha5w1h.FechaAprendizaje) as FechaAO, IF(s_sgc_ficha5w1h.DescripcionAO IS NULL,'',s_sgc_ficha5w1h.DescripcionAO) AS DescripcionAO,s_sgc_ficha5w1h.Aprendizaje  , IFNULL(s_sgc_analisis.`Id_NC`, 0) NC  , IFNULL(s_sgc_sc_evento_adverso_analisis_acciones.`Id_EventoA`, 0) EA  , IF((IFNULL(s_sgc_analisis.`Id_NC`, 0)<>0 AND IFNULL(s_sgc_sc_evento_adverso_analisis_acciones.`Id_EventoA`, 0)=0), s_sgc_analisis.`Id_NC`, IF((IFNULL(s_sgc_analisis.`Id_NC`, 0)=0 AND IFNULL(s_sgc_sc_evento_adverso_analisis_acciones.`Id_EventoA`, 0)<>0), s_sgc_sc_evento_adverso_analisis_acciones.`Id_EventoA` , '')) Etiqueta ,IF((IFNULL(s_sgc_analisis.`Id_NC`, 0)<>0 AND IFNULL(s_sgc_sc_evento_adverso_analisis_acciones.`Id_EventoA`, 0)=0), 'No conformidad N°', IF((IFNULL(s_sgc_analisis.`Id_NC`, 0)=0 AND IFNULL(s_sgc_sc_evento_adverso_analisis_acciones.`Id_EventoA`, 0)<>0),'Evento adverso N°' , '')) EtiquetaT  FROM s_sgc_ficha5w1h INNER JOIN s_sgc_tipo_accion  ON (s_sgc_ficha5w1h.Id_TipoAccion = s_sgc_tipo_accion.Id) INNER JOIN s_sgc_ncorigen  ON (s_sgc_ficha5w1h.Id_Origen = s_sgc_ncorigen.Id) INNER JOIN s_sgc_tipoproceso  ON (s_sgc_ficha5w1h.Id_TipoProceso = s_sgc_tipoproceso.Id) INNER JOIN rh_tipo_persona_cargon  ON (s_sgc_ficha5w1h.Id_RhPersonaR = rh_tipo_persona_cargon.Id) INNER JOIN persona  ON (persona.Id_persona = rh_tipo_persona_cargon.Id_Persona)  LEFT JOIN `s_sgc_analisis_accion_actividad` ON (s_sgc_analisis_accion_actividad.`Id_Ficha`=s_sgc_ficha5w1h.`Id`)  LEFT JOIN `s_sgc_analisis` ON (s_sgc_analisis.`Id`=s_sgc_analisis_accion_actividad.`Id_Analisis`) LEFT JOIN `s_sgc_sc_evento_adverso_analisis_acciones` ON (s_sgc_sc_evento_adverso_analisis_acciones.`Id_Ficha`=s_sgc_ficha5w1h.`Id`)   where (s_sgc_ficha5w1h.Id_TipoProceso='" + this.xidprocesor[this.JCBProcesoR.getSelectedIndex()] + "' and s_sgc_ficha5w1h.Estado=1 and s_sgc_ficha5w1h.Id_TipoAccion='" + this.xidtipoaccion[this.JCBTipoAccion.getSelectedIndex()][0] + "') order by s_sgc_ficha5w1h.FechaRF desc ";
                } else {
                    this.xsql = "SELECT s_sgc_ficha5w1h.Id, date_format(s_sgc_ficha5w1h.FechaRF,'%d-%m-%Y') as FechaR , s_sgc_tipo_accion.Nbre, s_sgc_ncorigen.Nbre, s_sgc_tipoproceso.Nbre, persona.NUsuario, if(s_sgc_ficha5w1h.Que IS NULL, '',s_sgc_ficha5w1h.Que) as Que , if(s_sgc_ficha5w1h.ParaQue IS NULL, '',s_sgc_ficha5w1h.ParaQue) as ParaQue , if(s_sgc_ficha5w1h.Como IS NULL, '',s_sgc_ficha5w1h.Como) as Como , DATE_FORMAT(s_sgc_ficha5w1h.Cuando,'%d/%m/%Y') AS Cuando, if(s_sgc_ficha5w1h.Donde IS NULL, '',s_sgc_ficha5w1h.Donde) as Como ,  IF( s_sgc_ficha5w1h.FechaPCierre IS NULL, '', DATE_FORMAT(s_sgc_ficha5w1h.FechaPCierre,'%d/%m/%Y') )AS FPCierre , s_sgc_ficha5w1h.NDiasSeguimiento, IF(FechaCierre IS NULL, FALSE, TRUE) AS estadoa, IF(FechaCierre IS NULL, 'ACTIVA', 'CERRADA') AS estadoL,  Eficaz, IF(FechaCierre IS NULL, DATE_FORMAT(NOW(),'%d-%m-%Y'), DATE_FORMAT(FechaCierre,'%d-%m-%Y')) AS FCierre, if(ObservacionCierre IS NULL, '',ObservacionCierre) AS ObservacionCierre, s_sgc_ficha5w1h.nseguimiento, s_sgc_ficha5w1h.ControlSeguimiento, IF(s_sgc_ficha5w1h.ParaQue IS NULL, TRUE, FALSE) AS VCompletar, s_sgc_ficha5w1h.Id_NC , if(s_sgc_ficha5w1h.FechaUltimoSeg is null,if(ADDDATE(s_sgc_ficha5w1h.Cuando,INTERVAL s_sgc_ficha5w1h.NDiasSeguimiento DAY) <=now() or (s_sgc_ficha5w1h.Cuando<=now()),1,2),if(ADDDATE(s_sgc_ficha5w1h.FechaUltimoSeg,INTERVAL s_sgc_ficha5w1h.NDiasSeguimiento DAY) <=NOW(),1,0 ) ) as ver  , IF(s_sgc_ficha5w1h.FechaUltimoSeg IS NULL,DATE_FORMAT(ADDDATE(s_sgc_ficha5w1h.Cuando,INTERVAL s_sgc_ficha5w1h.NDiasSeguimiento DAY),'%d-%m-%Y'),DATE_FORMAT(ADDDATE(s_sgc_ficha5w1h.FechaUltimoSeg,INTERVAL s_sgc_ficha5w1h.NDiasSeguimiento DAY),'%d-%m-%Y')) AS FPS, if(s_sgc_ficha5w1h.FechaAprendizaje is null,'',s_sgc_ficha5w1h.FechaAprendizaje) as FechaAO, IF(s_sgc_ficha5w1h.DescripcionAO IS NULL,'',s_sgc_ficha5w1h.DescripcionAO) AS DescripcionAO,s_sgc_ficha5w1h.Aprendizaje  , IFNULL(s_sgc_analisis.`Id_NC`, 0) NC  , IFNULL(s_sgc_sc_evento_adverso_analisis_acciones.`Id_EventoA`, 0) EA  , IF((IFNULL(s_sgc_analisis.`Id_NC`, 0)<>0 AND IFNULL(s_sgc_sc_evento_adverso_analisis_acciones.`Id_EventoA`, 0)=0), s_sgc_analisis.`Id_NC`, IF((IFNULL(s_sgc_analisis.`Id_NC`, 0)=0 AND IFNULL(s_sgc_sc_evento_adverso_analisis_acciones.`Id_EventoA`, 0)<>0), s_sgc_sc_evento_adverso_analisis_acciones.`Id_EventoA` , '')) Etiqueta ,IF((IFNULL(s_sgc_analisis.`Id_NC`, 0)<>0 AND IFNULL(s_sgc_sc_evento_adverso_analisis_acciones.`Id_EventoA`, 0)=0), 'No conformidad N°', IF((IFNULL(s_sgc_analisis.`Id_NC`, 0)=0 AND IFNULL(s_sgc_sc_evento_adverso_analisis_acciones.`Id_EventoA`, 0)<>0),'Evento adverso N°' , '')) EtiquetaT  FROM s_sgc_ficha5w1h INNER JOIN s_sgc_tipo_accion  ON (s_sgc_ficha5w1h.Id_TipoAccion = s_sgc_tipo_accion.Id) INNER JOIN s_sgc_ncorigen  ON (s_sgc_ficha5w1h.Id_Origen = s_sgc_ncorigen.Id) INNER JOIN s_sgc_tipoproceso  ON (s_sgc_ficha5w1h.Id_TipoProceso = s_sgc_tipoproceso.Id) INNER JOIN rh_tipo_persona_cargon  ON (s_sgc_ficha5w1h.Id_RhPersonaR = rh_tipo_persona_cargon.Id) INNER JOIN persona  ON (persona.Id_persona = rh_tipo_persona_cargon.Id_Persona)  LEFT JOIN `s_sgc_analisis_accion_actividad` ON (s_sgc_analisis_accion_actividad.`Id_Ficha`=s_sgc_ficha5w1h.`Id`)  LEFT JOIN `s_sgc_analisis` ON (s_sgc_analisis.`Id`=s_sgc_analisis_accion_actividad.`Id_Analisis`) LEFT JOIN `s_sgc_sc_evento_adverso_analisis_acciones` ON (s_sgc_sc_evento_adverso_analisis_acciones.`Id_Ficha`=s_sgc_ficha5w1h.`Id`)   where (s_sgc_ficha5w1h.Id_TipoProceso='" + this.xidprocesor[this.JCBProcesoR.getSelectedIndex()] + "' and s_sgc_ficha5w1h.Estado=1 ) order by s_sgc_ficha5w1h.FechaRF desc ";
                }
            } else {
                mCrearTablaHistoricoRegistro();
            }
        } else if (this.xmodulo == 1) {
            if (this.xfiltro == 1) {
                if (this.JCBProcesoR.getSelectedIndex() != -1) {
                    if (this.JCHTodas.isSelected()) {
                        this.xsql = "SELECT s_sgc_ficha5w1h.Id, date_format(s_sgc_ficha5w1h.FechaRF,'%d-%m-%Y') as FechaR , s_sgc_tipo_accion.Nbre, s_sgc_ncorigen.Nbre, s_sgc_tipoproceso.Nbre, persona.NUsuario, if(s_sgc_ficha5w1h.Que IS NULL, '',s_sgc_ficha5w1h.Que) as Que , if(s_sgc_ficha5w1h.ParaQue IS NULL, '',s_sgc_ficha5w1h.ParaQue) as ParaQue , if(s_sgc_ficha5w1h.Como IS NULL, '',s_sgc_ficha5w1h.Como) as Como , DATE_FORMAT(s_sgc_ficha5w1h.Cuando,'%d/%m/%Y') AS Cuando, if(s_sgc_ficha5w1h.Donde IS NULL, '',s_sgc_ficha5w1h.Donde) as Como ,  IF( s_sgc_ficha5w1h.FechaPCierre IS NULL, '', DATE_FORMAT(s_sgc_ficha5w1h.FechaPCierre,'%d/%m/%Y') )AS FPCierre , s_sgc_ficha5w1h.NDiasSeguimiento, IF(FechaCierre IS NULL, FALSE, TRUE) AS estadoa, IF(FechaCierre IS NULL, 'ACTIVA', 'CERRADA') AS estadoL,  Eficaz, IF(FechaCierre IS NULL, DATE_FORMAT(NOW(),'%d-%m-%Y'), DATE_FORMAT(FechaCierre,'%d-%m-%Y')) AS FCierre, if(ObservacionCierre IS NULL, '',ObservacionCierre) AS ObservacionCierre, s_sgc_ficha5w1h.nseguimiento, s_sgc_ficha5w1h.ControlSeguimiento, IF(s_sgc_ficha5w1h.ParaQue IS NULL, TRUE, FALSE) AS VCompletar, s_sgc_ficha5w1h.Id_NC , if(s_sgc_ficha5w1h.FechaUltimoSeg is null,if(ADDDATE(s_sgc_ficha5w1h.Cuando,INTERVAL s_sgc_ficha5w1h.NDiasSeguimiento DAY) <=now() or (s_sgc_ficha5w1h.Cuando<=now()),1,2),if(ADDDATE(s_sgc_ficha5w1h.FechaUltimoSeg,INTERVAL s_sgc_ficha5w1h.NDiasSeguimiento DAY) <=NOW(),1,0 ) ) as ver  , IF(s_sgc_ficha5w1h.FechaUltimoSeg IS NULL,DATE_FORMAT(ADDDATE(s_sgc_ficha5w1h.Cuando,INTERVAL s_sgc_ficha5w1h.NDiasSeguimiento DAY),'%d-%m-%Y'),DATE_FORMAT(ADDDATE(s_sgc_ficha5w1h.FechaUltimoSeg,INTERVAL s_sgc_ficha5w1h.NDiasSeguimiento DAY),'%d-%m-%Y')) AS FPS, if(s_sgc_ficha5w1h.FechaAprendizaje is null,'',s_sgc_ficha5w1h.FechaAprendizaje) as FechaAO, IF(s_sgc_ficha5w1h.DescripcionAO IS NULL,'',s_sgc_ficha5w1h.DescripcionAO) AS DescripcionAO, s_sgc_ficha5w1h.Aprendizaje  , IFNULL(s_sgc_analisis.`Id_NC`, 0) NC  , IFNULL(s_sgc_sc_evento_adverso_analisis_acciones.`Id_EventoA`, 0) EA  , IF((IFNULL(s_sgc_analisis.`Id_NC`, 0)<>0 AND IFNULL(s_sgc_sc_evento_adverso_analisis_acciones.`Id_EventoA`, 0)=0), s_sgc_analisis.`Id_NC`, IF((IFNULL(s_sgc_analisis.`Id_NC`, 0)=0 AND IFNULL(s_sgc_sc_evento_adverso_analisis_acciones.`Id_EventoA`, 0)<>0), s_sgc_sc_evento_adverso_analisis_acciones.`Id_EventoA` , '')) Etiqueta ,IF((IFNULL(s_sgc_analisis.`Id_NC`, 0)<>0 AND IFNULL(s_sgc_sc_evento_adverso_analisis_acciones.`Id_EventoA`, 0)=0), 'No conformidad N°', IF((IFNULL(s_sgc_analisis.`Id_NC`, 0)=0 AND IFNULL(s_sgc_sc_evento_adverso_analisis_acciones.`Id_EventoA`, 0)<>0),'Evento adverso N°' , '')) EtiquetaT  FROM s_sgc_ficha5w1h INNER JOIN s_sgc_tipo_accion  ON (s_sgc_ficha5w1h.Id_TipoAccion = s_sgc_tipo_accion.Id) INNER JOIN s_sgc_ncorigen  ON (s_sgc_ficha5w1h.Id_Origen = s_sgc_ncorigen.Id) INNER JOIN s_sgc_tipoproceso  ON (s_sgc_ficha5w1h.Id_TipoProceso = s_sgc_tipoproceso.Id) INNER JOIN rh_tipo_persona_cargon  ON (s_sgc_ficha5w1h.Id_RhPersonaR = rh_tipo_persona_cargon.Id) INNER JOIN persona  ON (persona.Id_persona = rh_tipo_persona_cargon.Id_Persona)  LEFT JOIN `s_sgc_analisis_accion_actividad` ON (s_sgc_analisis_accion_actividad.`Id_Ficha`=s_sgc_ficha5w1h.`Id`)  LEFT JOIN `s_sgc_analisis` ON (s_sgc_analisis.`Id`=s_sgc_analisis_accion_actividad.`Id_Analisis`) LEFT JOIN `s_sgc_sc_evento_adverso_analisis_acciones` ON (s_sgc_sc_evento_adverso_analisis_acciones.`Id_Ficha`=s_sgc_ficha5w1h.`Id`)   where (s_sgc_ficha5w1h.Id_TipoProceso='" + this.xidprocesor[this.JCBProcesoR.getSelectedIndex()] + "' and s_sgc_ficha5w1h.Estado=1 AND s_sgc_ficha5w1h.FechaRF>='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND  s_sgc_ficha5w1h.FechaRF<='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' ) order by s_sgc_ficha5w1h.FechaRF desc ";
                    } else if (this.JCHPorCerrada.isSelected()) {
                        this.xsql = "SELECT s_sgc_ficha5w1h.Id, date_format(s_sgc_ficha5w1h.FechaRF,'%d-%m-%Y') as FechaR , s_sgc_tipo_accion.Nbre, s_sgc_ncorigen.Nbre, s_sgc_tipoproceso.Nbre, persona.NUsuario, if(s_sgc_ficha5w1h.Que IS NULL, '',s_sgc_ficha5w1h.Que) as Que , if(s_sgc_ficha5w1h.ParaQue IS NULL, '',s_sgc_ficha5w1h.ParaQue) as ParaQue , if(s_sgc_ficha5w1h.Como IS NULL, '',s_sgc_ficha5w1h.Como) as Como , DATE_FORMAT(s_sgc_ficha5w1h.Cuando,'%d/%m/%Y') AS Cuando, if(s_sgc_ficha5w1h.Donde IS NULL, '',s_sgc_ficha5w1h.Donde) as Como ,  IF( s_sgc_ficha5w1h.FechaPCierre IS NULL, '', DATE_FORMAT(s_sgc_ficha5w1h.FechaPCierre,'%d/%m/%Y') )AS FPCierre , s_sgc_ficha5w1h.NDiasSeguimiento, IF(FechaCierre IS NULL, FALSE, TRUE) AS estadoa, IF(FechaCierre IS NULL, 'ACTIVA', 'CERRADA') AS estadoL,  Eficaz, IF(FechaCierre IS NULL, DATE_FORMAT(NOW(),'%d-%m-%Y'), DATE_FORMAT(FechaCierre,'%d-%m-%Y')) AS FCierre, if(ObservacionCierre IS NULL, '',ObservacionCierre) AS ObservacionCierre, s_sgc_ficha5w1h.nseguimiento, s_sgc_ficha5w1h.ControlSeguimiento, IF(s_sgc_ficha5w1h.ParaQue IS NULL, TRUE, FALSE) AS VCompletar, s_sgc_ficha5w1h.Id_NC , if(s_sgc_ficha5w1h.FechaUltimoSeg is null,if(ADDDATE(s_sgc_ficha5w1h.Cuando,INTERVAL s_sgc_ficha5w1h.NDiasSeguimiento DAY) <=now() or (s_sgc_ficha5w1h.Cuando<=now()),1,2),if(ADDDATE(s_sgc_ficha5w1h.FechaUltimoSeg,INTERVAL s_sgc_ficha5w1h.NDiasSeguimiento DAY) <=NOW(),1,0 ) ) as ver  , IF(s_sgc_ficha5w1h.FechaUltimoSeg IS NULL,DATE_FORMAT(ADDDATE(s_sgc_ficha5w1h.Cuando,INTERVAL s_sgc_ficha5w1h.NDiasSeguimiento DAY),'%d-%m-%Y'),DATE_FORMAT(ADDDATE(s_sgc_ficha5w1h.FechaUltimoSeg,INTERVAL s_sgc_ficha5w1h.NDiasSeguimiento DAY),'%d-%m-%Y')) AS FPS, if(s_sgc_ficha5w1h.FechaAprendizaje is null,'',s_sgc_ficha5w1h.FechaAprendizaje) as FechaAO, IF(s_sgc_ficha5w1h.DescripcionAO IS NULL,'',s_sgc_ficha5w1h.DescripcionAO) AS DescripcionAO,s_sgc_ficha5w1h.Aprendizaje  , IFNULL(s_sgc_analisis.`Id_NC`, 0) NC  , IFNULL(s_sgc_sc_evento_adverso_analisis_acciones.`Id_EventoA`, 0) EA  , IF((IFNULL(s_sgc_analisis.`Id_NC`, 0)<>0 AND IFNULL(s_sgc_sc_evento_adverso_analisis_acciones.`Id_EventoA`, 0)=0), s_sgc_analisis.`Id_NC`, IF((IFNULL(s_sgc_analisis.`Id_NC`, 0)=0 AND IFNULL(s_sgc_sc_evento_adverso_analisis_acciones.`Id_EventoA`, 0)<>0), s_sgc_sc_evento_adverso_analisis_acciones.`Id_EventoA` , '')) Etiqueta ,IF((IFNULL(s_sgc_analisis.`Id_NC`, 0)<>0 AND IFNULL(s_sgc_sc_evento_adverso_analisis_acciones.`Id_EventoA`, 0)=0), 'No conformidad N°', IF((IFNULL(s_sgc_analisis.`Id_NC`, 0)=0 AND IFNULL(s_sgc_sc_evento_adverso_analisis_acciones.`Id_EventoA`, 0)<>0),'Evento adverso N°' , '')) EtiquetaT  FROM s_sgc_ficha5w1h INNER JOIN s_sgc_tipo_accion  ON (s_sgc_ficha5w1h.Id_TipoAccion = s_sgc_tipo_accion.Id) INNER JOIN s_sgc_ncorigen  ON (s_sgc_ficha5w1h.Id_Origen = s_sgc_ncorigen.Id) INNER JOIN s_sgc_tipoproceso  ON (s_sgc_ficha5w1h.Id_TipoProceso = s_sgc_tipoproceso.Id) INNER JOIN rh_tipo_persona_cargon  ON (s_sgc_ficha5w1h.Id_RhPersonaR = rh_tipo_persona_cargon.Id) INNER JOIN persona  ON (persona.Id_persona = rh_tipo_persona_cargon.Id_Persona)  LEFT JOIN `s_sgc_analisis_accion_actividad` ON (s_sgc_analisis_accion_actividad.`Id_Ficha`=s_sgc_ficha5w1h.`Id`)  LEFT JOIN `s_sgc_analisis` ON (s_sgc_analisis.`Id`=s_sgc_analisis_accion_actividad.`Id_Analisis`) LEFT JOIN `s_sgc_sc_evento_adverso_analisis_acciones` ON (s_sgc_sc_evento_adverso_analisis_acciones.`Id_Ficha`=s_sgc_ficha5w1h.`Id`)   where (s_sgc_ficha5w1h.Id_TipoProceso='" + this.xidprocesor[this.JCBProcesoR.getSelectedIndex()] + "' and s_sgc_ficha5w1h.Estado=1 AND s_sgc_ficha5w1h.FechaRF>='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND  s_sgc_ficha5w1h.FechaRF<='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND s_sgc_ficha5w1h.ControlSeguimiento=1 AND IF(FechaCierre IS NULL, FALSE, TRUE)=0 ) order by s_sgc_ficha5w1h.FechaRF desc ";
                    } else if (this.JCHCerradas.isSelected()) {
                        this.xsql = "SELECT s_sgc_ficha5w1h.Id, date_format(s_sgc_ficha5w1h.FechaRF,'%d-%m-%Y') as FechaR , s_sgc_tipo_accion.Nbre, s_sgc_ncorigen.Nbre, s_sgc_tipoproceso.Nbre, persona.NUsuario, if(s_sgc_ficha5w1h.Que IS NULL, '',s_sgc_ficha5w1h.Que) as Que , if(s_sgc_ficha5w1h.ParaQue IS NULL, '',s_sgc_ficha5w1h.ParaQue) as ParaQue , if(s_sgc_ficha5w1h.Como IS NULL, '',s_sgc_ficha5w1h.Como) as Como , DATE_FORMAT(s_sgc_ficha5w1h.Cuando,'%d/%m/%Y') AS Cuando, if(s_sgc_ficha5w1h.Donde IS NULL, '',s_sgc_ficha5w1h.Donde) as Como ,  IF( s_sgc_ficha5w1h.FechaPCierre IS NULL, '', DATE_FORMAT(s_sgc_ficha5w1h.FechaPCierre,'%d/%m/%Y') )AS FPCierre , s_sgc_ficha5w1h.NDiasSeguimiento, IF(FechaCierre IS NULL, FALSE, TRUE) AS estadoa, IF(FechaCierre IS NULL, 'ACTIVA', 'CERRADA') AS estadoL,  Eficaz, IF(FechaCierre IS NULL, DATE_FORMAT(NOW(),'%d-%m-%Y'), DATE_FORMAT(FechaCierre,'%d-%m-%Y')) AS FCierre, if(ObservacionCierre IS NULL, '',ObservacionCierre) AS ObservacionCierre, s_sgc_ficha5w1h.nseguimiento, s_sgc_ficha5w1h.ControlSeguimiento, IF(s_sgc_ficha5w1h.ParaQue IS NULL, TRUE, FALSE) AS VCompletar, s_sgc_ficha5w1h.Id_NC , if(s_sgc_ficha5w1h.FechaUltimoSeg is null,if(ADDDATE(s_sgc_ficha5w1h.Cuando,INTERVAL s_sgc_ficha5w1h.NDiasSeguimiento DAY) <=now() or (s_sgc_ficha5w1h.Cuando<=now()),1,2),if(ADDDATE(s_sgc_ficha5w1h.FechaUltimoSeg,INTERVAL s_sgc_ficha5w1h.NDiasSeguimiento DAY) <=NOW(),1,0 ) ) as ver  , IF(s_sgc_ficha5w1h.FechaUltimoSeg IS NULL,DATE_FORMAT(ADDDATE(s_sgc_ficha5w1h.Cuando,INTERVAL s_sgc_ficha5w1h.NDiasSeguimiento DAY),'%d-%m-%Y'),DATE_FORMAT(ADDDATE(s_sgc_ficha5w1h.FechaUltimoSeg,INTERVAL s_sgc_ficha5w1h.NDiasSeguimiento DAY),'%d-%m-%Y')) AS FPS, if(s_sgc_ficha5w1h.FechaAprendizaje is null,'',s_sgc_ficha5w1h.FechaAprendizaje) as FechaAO, IF(s_sgc_ficha5w1h.DescripcionAO IS NULL,'',s_sgc_ficha5w1h.DescripcionAO) AS DescripcionAO,s_sgc_ficha5w1h.Aprendizaje  , IFNULL(s_sgc_analisis.`Id_NC`, 0) NC  , IFNULL(s_sgc_sc_evento_adverso_analisis_acciones.`Id_EventoA`, 0) EA  , IF((IFNULL(s_sgc_analisis.`Id_NC`, 0)<>0 AND IFNULL(s_sgc_sc_evento_adverso_analisis_acciones.`Id_EventoA`, 0)=0), s_sgc_analisis.`Id_NC`, IF((IFNULL(s_sgc_analisis.`Id_NC`, 0)=0 AND IFNULL(s_sgc_sc_evento_adverso_analisis_acciones.`Id_EventoA`, 0)<>0), s_sgc_sc_evento_adverso_analisis_acciones.`Id_EventoA` , '')) Etiqueta ,IF((IFNULL(s_sgc_analisis.`Id_NC`, 0)<>0 AND IFNULL(s_sgc_sc_evento_adverso_analisis_acciones.`Id_EventoA`, 0)=0), 'No conformidad N°', IF((IFNULL(s_sgc_analisis.`Id_NC`, 0)=0 AND IFNULL(s_sgc_sc_evento_adverso_analisis_acciones.`Id_EventoA`, 0)<>0),'Evento adverso N°' , '')) EtiquetaT  FROM s_sgc_ficha5w1h INNER JOIN s_sgc_tipo_accion  ON (s_sgc_ficha5w1h.Id_TipoAccion = s_sgc_tipo_accion.Id) INNER JOIN s_sgc_ncorigen  ON (s_sgc_ficha5w1h.Id_Origen = s_sgc_ncorigen.Id) INNER JOIN s_sgc_tipoproceso  ON (s_sgc_ficha5w1h.Id_TipoProceso = s_sgc_tipoproceso.Id) INNER JOIN rh_tipo_persona_cargon  ON (s_sgc_ficha5w1h.Id_RhPersonaR = rh_tipo_persona_cargon.Id) INNER JOIN persona  ON (persona.Id_persona = rh_tipo_persona_cargon.Id_Persona)  LEFT JOIN `s_sgc_analisis_accion_actividad` ON (s_sgc_analisis_accion_actividad.`Id_Ficha`=s_sgc_ficha5w1h.`Id`)  LEFT JOIN `s_sgc_analisis` ON (s_sgc_analisis.`Id`=s_sgc_analisis_accion_actividad.`Id_Analisis`) LEFT JOIN `s_sgc_sc_evento_adverso_analisis_acciones` ON (s_sgc_sc_evento_adverso_analisis_acciones.`Id_Ficha`=s_sgc_ficha5w1h.`Id`)   where ( s_sgc_ficha5w1h.Id_TipoProceso='" + this.xidprocesor[this.JCBProcesoR.getSelectedIndex()] + "' and s_sgc_ficha5w1h.Estado=1 AND s_sgc_ficha5w1h.FechaRF>='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND  s_sgc_ficha5w1h.FechaRF<='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND s_sgc_ficha5w1h.ControlSeguimiento=1 AND IF(FechaCierre IS NULL, FALSE, TRUE)=1 ) order by s_sgc_ficha5w1h.FechaRF desc ";
                    } else if (this.JCHFiltroAccion.isSelected()) {
                        this.xsql = "SELECT s_sgc_ficha5w1h.Id, date_format(s_sgc_ficha5w1h.FechaRF,'%d-%m-%Y') as FechaR , s_sgc_tipo_accion.Nbre, s_sgc_ncorigen.Nbre, s_sgc_tipoproceso.Nbre, persona.NUsuario, if(s_sgc_ficha5w1h.Que IS NULL, '',s_sgc_ficha5w1h.Que) as Que , if(s_sgc_ficha5w1h.ParaQue IS NULL, '',s_sgc_ficha5w1h.ParaQue) as ParaQue , if(s_sgc_ficha5w1h.Como IS NULL, '',s_sgc_ficha5w1h.Como) as Como , DATE_FORMAT(s_sgc_ficha5w1h.Cuando,'%d/%m/%Y') AS Cuando, if(s_sgc_ficha5w1h.Donde IS NULL, '',s_sgc_ficha5w1h.Donde) as Como ,  IF( s_sgc_ficha5w1h.FechaPCierre IS NULL, '', DATE_FORMAT(s_sgc_ficha5w1h.FechaPCierre,'%d/%m/%Y') )AS FPCierre , s_sgc_ficha5w1h.NDiasSeguimiento, IF(FechaCierre IS NULL, FALSE, TRUE) AS estadoa, IF(FechaCierre IS NULL, 'ACTIVA', 'CERRADA') AS estadoL,  Eficaz, IF(FechaCierre IS NULL, DATE_FORMAT(NOW(),'%d-%m-%Y'), DATE_FORMAT(FechaCierre,'%d-%m-%Y')) AS FCierre, if(ObservacionCierre IS NULL, '',ObservacionCierre) AS ObservacionCierre, s_sgc_ficha5w1h.nseguimiento, s_sgc_ficha5w1h.ControlSeguimiento, IF(s_sgc_ficha5w1h.ParaQue IS NULL, TRUE, FALSE) AS VCompletar, s_sgc_ficha5w1h.Id_NC , if(s_sgc_ficha5w1h.FechaUltimoSeg is null,if(ADDDATE(s_sgc_ficha5w1h.Cuando,INTERVAL s_sgc_ficha5w1h.NDiasSeguimiento DAY) <=now() or (s_sgc_ficha5w1h.Cuando<=now()),1,2),if(ADDDATE(s_sgc_ficha5w1h.FechaUltimoSeg,INTERVAL s_sgc_ficha5w1h.NDiasSeguimiento DAY) <=NOW(),1,0 ) ) as ver  , IF(s_sgc_ficha5w1h.FechaUltimoSeg IS NULL,DATE_FORMAT(ADDDATE(s_sgc_ficha5w1h.Cuando,INTERVAL s_sgc_ficha5w1h.NDiasSeguimiento DAY),'%d-%m-%Y'),DATE_FORMAT(ADDDATE(s_sgc_ficha5w1h.FechaUltimoSeg,INTERVAL s_sgc_ficha5w1h.NDiasSeguimiento DAY),'%d-%m-%Y')) AS FPS, if(s_sgc_ficha5w1h.FechaAprendizaje is null,'',s_sgc_ficha5w1h.FechaAprendizaje) as FechaAO, IF(s_sgc_ficha5w1h.DescripcionAO IS NULL,'',s_sgc_ficha5w1h.DescripcionAO) AS DescripcionAO,s_sgc_ficha5w1h.Aprendizaje  , IFNULL(s_sgc_analisis.`Id_NC`, 0) NC  , IFNULL(s_sgc_sc_evento_adverso_analisis_acciones.`Id_EventoA`, 0) EA  , IF((IFNULL(s_sgc_analisis.`Id_NC`, 0)<>0 AND IFNULL(s_sgc_sc_evento_adverso_analisis_acciones.`Id_EventoA`, 0)=0), s_sgc_analisis.`Id_NC`, IF((IFNULL(s_sgc_analisis.`Id_NC`, 0)=0 AND IFNULL(s_sgc_sc_evento_adverso_analisis_acciones.`Id_EventoA`, 0)<>0), s_sgc_sc_evento_adverso_analisis_acciones.`Id_EventoA` , '')) Etiqueta ,IF((IFNULL(s_sgc_analisis.`Id_NC`, 0)<>0 AND IFNULL(s_sgc_sc_evento_adverso_analisis_acciones.`Id_EventoA`, 0)=0), 'No conformidad N°', IF((IFNULL(s_sgc_analisis.`Id_NC`, 0)=0 AND IFNULL(s_sgc_sc_evento_adverso_analisis_acciones.`Id_EventoA`, 0)<>0),'Evento adverso N°' , '')) EtiquetaT  FROM s_sgc_ficha5w1h INNER JOIN s_sgc_tipo_accion  ON (s_sgc_ficha5w1h.Id_TipoAccion = s_sgc_tipo_accion.Id) INNER JOIN s_sgc_ncorigen  ON (s_sgc_ficha5w1h.Id_Origen = s_sgc_ncorigen.Id) INNER JOIN s_sgc_tipoproceso  ON (s_sgc_ficha5w1h.Id_TipoProceso = s_sgc_tipoproceso.Id) INNER JOIN rh_tipo_persona_cargon  ON (s_sgc_ficha5w1h.Id_RhPersonaR = rh_tipo_persona_cargon.Id) INNER JOIN persona  ON (persona.Id_persona = rh_tipo_persona_cargon.Id_Persona)  LEFT JOIN `s_sgc_analisis_accion_actividad` ON (s_sgc_analisis_accion_actividad.`Id_Ficha`=s_sgc_ficha5w1h.`Id`)  LEFT JOIN `s_sgc_analisis` ON (s_sgc_analisis.`Id`=s_sgc_analisis_accion_actividad.`Id_Analisis`) LEFT JOIN `s_sgc_sc_evento_adverso_analisis_acciones` ON (s_sgc_sc_evento_adverso_analisis_acciones.`Id_Ficha`=s_sgc_ficha5w1h.`Id`)   where ( s_sgc_ficha5w1h.Id_TipoProceso='" + this.xidprocesor[this.JCBProcesoR.getSelectedIndex()] + "' and s_sgc_ficha5w1h.Estado=1 AND s_sgc_ficha5w1h.FechaRF>='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND  s_sgc_ficha5w1h.FechaRF<='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND s_sgc_ficha5w1h.ControlSeguimiento=1 AND IF(FechaCierre IS NULL, FALSE, TRUE)=1 and s_sgc_ficha5w1h.Id_TipoAccion='" + this.xidtipoaccion[this.JCBTipoAccion.getSelectedIndex()][0] + "') order by s_sgc_ficha5w1h.FechaRF desc ";
                    }
                } else if (this.JCHTodas.isSelected()) {
                    this.xsql = "SELECT s_sgc_ficha5w1h.Id, date_format(s_sgc_ficha5w1h.FechaRF,'%d-%m-%Y') as FechaR , s_sgc_tipo_accion.Nbre, s_sgc_ncorigen.Nbre, s_sgc_tipoproceso.Nbre, persona.NUsuario, if(s_sgc_ficha5w1h.Que IS NULL, '',s_sgc_ficha5w1h.Que) as Que , if(s_sgc_ficha5w1h.ParaQue IS NULL, '',s_sgc_ficha5w1h.ParaQue) as ParaQue , if(s_sgc_ficha5w1h.Como IS NULL, '',s_sgc_ficha5w1h.Como) as Como , DATE_FORMAT(s_sgc_ficha5w1h.Cuando,'%d/%m/%Y') AS Cuando, if(s_sgc_ficha5w1h.Donde IS NULL, '',s_sgc_ficha5w1h.Donde) as Como ,  IF( s_sgc_ficha5w1h.FechaPCierre IS NULL, '', DATE_FORMAT(s_sgc_ficha5w1h.FechaPCierre,'%d/%m/%Y') )AS FPCierre , s_sgc_ficha5w1h.NDiasSeguimiento, IF(FechaCierre IS NULL, FALSE, TRUE) AS estadoa, IF(FechaCierre IS NULL, 'ACTIVA', 'CERRADA') AS estadoL,  Eficaz, IF(FechaCierre IS NULL, DATE_FORMAT(NOW(),'%d-%m-%Y'), DATE_FORMAT(FechaCierre,'%d-%m-%Y')) AS FCierre, if(ObservacionCierre IS NULL, '',ObservacionCierre) AS ObservacionCierre, s_sgc_ficha5w1h.nseguimiento, s_sgc_ficha5w1h.ControlSeguimiento, IF(s_sgc_ficha5w1h.ParaQue IS NULL, TRUE, FALSE) AS VCompletar, s_sgc_ficha5w1h.Id_NC , if(s_sgc_ficha5w1h.FechaUltimoSeg is null,if(ADDDATE(s_sgc_ficha5w1h.Cuando,INTERVAL s_sgc_ficha5w1h.NDiasSeguimiento DAY) <=now() or (s_sgc_ficha5w1h.Cuando<=now()),1,2),if(ADDDATE(s_sgc_ficha5w1h.FechaUltimoSeg,INTERVAL s_sgc_ficha5w1h.NDiasSeguimiento DAY) <=NOW(),1,0 ) ) as ver  , IF(s_sgc_ficha5w1h.FechaUltimoSeg IS NULL,DATE_FORMAT(ADDDATE(s_sgc_ficha5w1h.Cuando,INTERVAL s_sgc_ficha5w1h.NDiasSeguimiento DAY),'%d-%m-%Y'),DATE_FORMAT(ADDDATE(s_sgc_ficha5w1h.FechaUltimoSeg,INTERVAL s_sgc_ficha5w1h.NDiasSeguimiento DAY),'%d-%m-%Y')) AS FPS, if(s_sgc_ficha5w1h.FechaAprendizaje is null,'',s_sgc_ficha5w1h.FechaAprendizaje) as FechaAO, IF(s_sgc_ficha5w1h.DescripcionAO IS NULL,'',s_sgc_ficha5w1h.DescripcionAO) AS DescripcionAO,s_sgc_ficha5w1h.Aprendizaje  , IFNULL(s_sgc_analisis.`Id_NC`, 0) NC  , IFNULL(s_sgc_sc_evento_adverso_analisis_acciones.`Id_EventoA`, 0) EA  , IF((IFNULL(s_sgc_analisis.`Id_NC`, 0)<>0 AND IFNULL(s_sgc_sc_evento_adverso_analisis_acciones.`Id_EventoA`, 0)=0), s_sgc_analisis.`Id_NC`, IF((IFNULL(s_sgc_analisis.`Id_NC`, 0)=0 AND IFNULL(s_sgc_sc_evento_adverso_analisis_acciones.`Id_EventoA`, 0)<>0), s_sgc_sc_evento_adverso_analisis_acciones.`Id_EventoA` , '')) Etiqueta ,IF((IFNULL(s_sgc_analisis.`Id_NC`, 0)<>0 AND IFNULL(s_sgc_sc_evento_adverso_analisis_acciones.`Id_EventoA`, 0)=0), 'No conformidad N°', IF((IFNULL(s_sgc_analisis.`Id_NC`, 0)=0 AND IFNULL(s_sgc_sc_evento_adverso_analisis_acciones.`Id_EventoA`, 0)<>0),'Evento adverso N°' , '')) EtiquetaT  FROM s_sgc_ficha5w1h INNER JOIN s_sgc_tipo_accion  ON (s_sgc_ficha5w1h.Id_TipoAccion = s_sgc_tipo_accion.Id) INNER JOIN s_sgc_ncorigen  ON (s_sgc_ficha5w1h.Id_Origen = s_sgc_ncorigen.Id) INNER JOIN s_sgc_tipoproceso  ON (s_sgc_ficha5w1h.Id_TipoProceso = s_sgc_tipoproceso.Id) INNER JOIN rh_tipo_persona_cargon  ON (s_sgc_ficha5w1h.Id_RhPersonaR = rh_tipo_persona_cargon.Id) INNER JOIN persona  ON (persona.Id_persona = rh_tipo_persona_cargon.Id_Persona)  LEFT JOIN `s_sgc_analisis_accion_actividad` ON (s_sgc_analisis_accion_actividad.`Id_Ficha`=s_sgc_ficha5w1h.`Id`)  LEFT JOIN `s_sgc_analisis` ON (s_sgc_analisis.`Id`=s_sgc_analisis_accion_actividad.`Id_Analisis`) LEFT JOIN `s_sgc_sc_evento_adverso_analisis_acciones` ON (s_sgc_sc_evento_adverso_analisis_acciones.`Id_Ficha`=s_sgc_ficha5w1h.`Id`)   where (s_sgc_ficha5w1h.Estado=1 AND s_sgc_ficha5w1h.FechaRF>='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND  s_sgc_ficha5w1h.FechaRF<='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "') order by s_sgc_ficha5w1h.FechaRF desc ";
                } else if (this.JCHPorCerrada.isSelected()) {
                    this.xsql = "SELECT s_sgc_ficha5w1h.Id, date_format(s_sgc_ficha5w1h.FechaRF,'%d-%m-%Y') as FechaR , s_sgc_tipo_accion.Nbre, s_sgc_ncorigen.Nbre, s_sgc_tipoproceso.Nbre, persona.NUsuario, if(s_sgc_ficha5w1h.Que IS NULL, '',s_sgc_ficha5w1h.Que) as Que , if(s_sgc_ficha5w1h.ParaQue IS NULL, '',s_sgc_ficha5w1h.ParaQue) as ParaQue , if(s_sgc_ficha5w1h.Como IS NULL, '',s_sgc_ficha5w1h.Como) as Como , DATE_FORMAT(s_sgc_ficha5w1h.Cuando,'%d/%m/%Y') AS Cuando, if(s_sgc_ficha5w1h.Donde IS NULL, '',s_sgc_ficha5w1h.Donde) as Como ,  IF( s_sgc_ficha5w1h.FechaPCierre IS NULL, '', DATE_FORMAT(s_sgc_ficha5w1h.FechaPCierre,'%d/%m/%Y') )AS FPCierre , s_sgc_ficha5w1h.NDiasSeguimiento, IF(FechaCierre IS NULL, FALSE, TRUE) AS estadoa, IF(FechaCierre IS NULL, 'ACTIVA', 'CERRADA') AS estadoL,  Eficaz, IF(FechaCierre IS NULL, DATE_FORMAT(NOW(),'%d-%m-%Y'), DATE_FORMAT(FechaCierre,'%d-%m-%Y')) AS FCierre, if(ObservacionCierre IS NULL, '',ObservacionCierre) AS ObservacionCierre, s_sgc_ficha5w1h.nseguimiento, s_sgc_ficha5w1h.ControlSeguimiento, IF(s_sgc_ficha5w1h.ParaQue IS NULL, TRUE, FALSE) AS VCompletar, s_sgc_ficha5w1h.Id_NC , if(s_sgc_ficha5w1h.FechaUltimoSeg is null,if(ADDDATE(s_sgc_ficha5w1h.Cuando,INTERVAL s_sgc_ficha5w1h.NDiasSeguimiento DAY) <=now() or (s_sgc_ficha5w1h.Cuando<=now()),1,2),if(ADDDATE(s_sgc_ficha5w1h.FechaUltimoSeg,INTERVAL s_sgc_ficha5w1h.NDiasSeguimiento DAY) <=NOW(),1,0 ) ) as ver  , IF(s_sgc_ficha5w1h.FechaUltimoSeg IS NULL,DATE_FORMAT(ADDDATE(s_sgc_ficha5w1h.Cuando,INTERVAL s_sgc_ficha5w1h.NDiasSeguimiento DAY),'%d-%m-%Y'),DATE_FORMAT(ADDDATE(s_sgc_ficha5w1h.FechaUltimoSeg,INTERVAL s_sgc_ficha5w1h.NDiasSeguimiento DAY),'%d-%m-%Y')) AS FPS, if(s_sgc_ficha5w1h.FechaAprendizaje is null,'',s_sgc_ficha5w1h.FechaAprendizaje) as FechaAO, IF(s_sgc_ficha5w1h.DescripcionAO IS NULL,'',s_sgc_ficha5w1h.DescripcionAO) AS DescripcionAO,s_sgc_ficha5w1h.Aprendizaje  , IFNULL(s_sgc_analisis.`Id_NC`, 0) NC  , IFNULL(s_sgc_sc_evento_adverso_analisis_acciones.`Id_EventoA`, 0) EA  , IF((IFNULL(s_sgc_analisis.`Id_NC`, 0)<>0 AND IFNULL(s_sgc_sc_evento_adverso_analisis_acciones.`Id_EventoA`, 0)=0), s_sgc_analisis.`Id_NC`, IF((IFNULL(s_sgc_analisis.`Id_NC`, 0)=0 AND IFNULL(s_sgc_sc_evento_adverso_analisis_acciones.`Id_EventoA`, 0)<>0), s_sgc_sc_evento_adverso_analisis_acciones.`Id_EventoA` , '')) Etiqueta ,IF((IFNULL(s_sgc_analisis.`Id_NC`, 0)<>0 AND IFNULL(s_sgc_sc_evento_adverso_analisis_acciones.`Id_EventoA`, 0)=0), 'No conformidad N°', IF((IFNULL(s_sgc_analisis.`Id_NC`, 0)=0 AND IFNULL(s_sgc_sc_evento_adverso_analisis_acciones.`Id_EventoA`, 0)<>0),'Evento adverso N°' , '')) EtiquetaT  FROM s_sgc_ficha5w1h INNER JOIN s_sgc_tipo_accion  ON (s_sgc_ficha5w1h.Id_TipoAccion = s_sgc_tipo_accion.Id) INNER JOIN s_sgc_ncorigen  ON (s_sgc_ficha5w1h.Id_Origen = s_sgc_ncorigen.Id) INNER JOIN s_sgc_tipoproceso  ON (s_sgc_ficha5w1h.Id_TipoProceso = s_sgc_tipoproceso.Id) INNER JOIN rh_tipo_persona_cargon  ON (s_sgc_ficha5w1h.Id_RhPersonaR = rh_tipo_persona_cargon.Id) INNER JOIN persona  ON (persona.Id_persona = rh_tipo_persona_cargon.Id_Persona)  LEFT JOIN `s_sgc_analisis_accion_actividad` ON (s_sgc_analisis_accion_actividad.`Id_Ficha`=s_sgc_ficha5w1h.`Id`)  LEFT JOIN `s_sgc_analisis` ON (s_sgc_analisis.`Id`=s_sgc_analisis_accion_actividad.`Id_Analisis`) LEFT JOIN `s_sgc_sc_evento_adverso_analisis_acciones` ON (s_sgc_sc_evento_adverso_analisis_acciones.`Id_Ficha`=s_sgc_ficha5w1h.`Id`)   where (s_sgc_ficha5w1h.Estado=1 and s_sgc_ficha5w1h.ControlSeguimiento=1 AND IF(FechaCierre IS NULL, FALSE, TRUE)=0 AND s_sgc_ficha5w1h.FechaRF>='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND  s_sgc_ficha5w1h.FechaRF<='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "') order by s_sgc_ficha5w1h.FechaRF desc ";
                } else if (this.JCHCerradas.isSelected()) {
                    this.xsql = "SELECT s_sgc_ficha5w1h.Id, date_format(s_sgc_ficha5w1h.FechaRF,'%d-%m-%Y') as FechaR , s_sgc_tipo_accion.Nbre, s_sgc_ncorigen.Nbre, s_sgc_tipoproceso.Nbre, persona.NUsuario, if(s_sgc_ficha5w1h.Que IS NULL, '',s_sgc_ficha5w1h.Que) as Que , if(s_sgc_ficha5w1h.ParaQue IS NULL, '',s_sgc_ficha5w1h.ParaQue) as ParaQue , if(s_sgc_ficha5w1h.Como IS NULL, '',s_sgc_ficha5w1h.Como) as Como , DATE_FORMAT(s_sgc_ficha5w1h.Cuando,'%d/%m/%Y') AS Cuando, if(s_sgc_ficha5w1h.Donde IS NULL, '',s_sgc_ficha5w1h.Donde) as Como ,  IF( s_sgc_ficha5w1h.FechaPCierre IS NULL, '', DATE_FORMAT(s_sgc_ficha5w1h.FechaPCierre,'%d/%m/%Y') )AS FPCierre , s_sgc_ficha5w1h.NDiasSeguimiento, IF(FechaCierre IS NULL, FALSE, TRUE) AS estadoa, IF(FechaCierre IS NULL, 'ACTIVA', 'CERRADA') AS estadoL,  Eficaz, IF(FechaCierre IS NULL, DATE_FORMAT(NOW(),'%d-%m-%Y'), DATE_FORMAT(FechaCierre,'%d-%m-%Y')) AS FCierre, if(ObservacionCierre IS NULL, '',ObservacionCierre) AS ObservacionCierre, s_sgc_ficha5w1h.nseguimiento, s_sgc_ficha5w1h.ControlSeguimiento, IF(s_sgc_ficha5w1h.ParaQue IS NULL, TRUE, FALSE) AS VCompletar, s_sgc_ficha5w1h.Id_NC , if(s_sgc_ficha5w1h.FechaUltimoSeg is null,if(ADDDATE(s_sgc_ficha5w1h.Cuando,INTERVAL s_sgc_ficha5w1h.NDiasSeguimiento DAY) <=now() or (s_sgc_ficha5w1h.Cuando<=now()),1,2),if(ADDDATE(s_sgc_ficha5w1h.FechaUltimoSeg,INTERVAL s_sgc_ficha5w1h.NDiasSeguimiento DAY) <=NOW(),1,0 ) ) as ver  , IF(s_sgc_ficha5w1h.FechaUltimoSeg IS NULL,DATE_FORMAT(ADDDATE(s_sgc_ficha5w1h.Cuando,INTERVAL s_sgc_ficha5w1h.NDiasSeguimiento DAY),'%d-%m-%Y'),DATE_FORMAT(ADDDATE(s_sgc_ficha5w1h.FechaUltimoSeg,INTERVAL s_sgc_ficha5w1h.NDiasSeguimiento DAY),'%d-%m-%Y')) AS FPS, if(s_sgc_ficha5w1h.FechaAprendizaje is null,'',s_sgc_ficha5w1h.FechaAprendizaje) as FechaAO, IF(s_sgc_ficha5w1h.DescripcionAO IS NULL,'',s_sgc_ficha5w1h.DescripcionAO) AS DescripcionAO,s_sgc_ficha5w1h.Aprendizaje  , IFNULL(s_sgc_analisis.`Id_NC`, 0) NC  , IFNULL(s_sgc_sc_evento_adverso_analisis_acciones.`Id_EventoA`, 0) EA  , IF((IFNULL(s_sgc_analisis.`Id_NC`, 0)<>0 AND IFNULL(s_sgc_sc_evento_adverso_analisis_acciones.`Id_EventoA`, 0)=0), s_sgc_analisis.`Id_NC`, IF((IFNULL(s_sgc_analisis.`Id_NC`, 0)=0 AND IFNULL(s_sgc_sc_evento_adverso_analisis_acciones.`Id_EventoA`, 0)<>0), s_sgc_sc_evento_adverso_analisis_acciones.`Id_EventoA` , '')) Etiqueta ,IF((IFNULL(s_sgc_analisis.`Id_NC`, 0)<>0 AND IFNULL(s_sgc_sc_evento_adverso_analisis_acciones.`Id_EventoA`, 0)=0), 'No conformidad N°', IF((IFNULL(s_sgc_analisis.`Id_NC`, 0)=0 AND IFNULL(s_sgc_sc_evento_adverso_analisis_acciones.`Id_EventoA`, 0)<>0),'Evento adverso N°' , '')) EtiquetaT  FROM s_sgc_ficha5w1h INNER JOIN s_sgc_tipo_accion  ON (s_sgc_ficha5w1h.Id_TipoAccion = s_sgc_tipo_accion.Id) INNER JOIN s_sgc_ncorigen  ON (s_sgc_ficha5w1h.Id_Origen = s_sgc_ncorigen.Id) INNER JOIN s_sgc_tipoproceso  ON (s_sgc_ficha5w1h.Id_TipoProceso = s_sgc_tipoproceso.Id) INNER JOIN rh_tipo_persona_cargon  ON (s_sgc_ficha5w1h.Id_RhPersonaR = rh_tipo_persona_cargon.Id) INNER JOIN persona  ON (persona.Id_persona = rh_tipo_persona_cargon.Id_Persona)  LEFT JOIN `s_sgc_analisis_accion_actividad` ON (s_sgc_analisis_accion_actividad.`Id_Ficha`=s_sgc_ficha5w1h.`Id`)  LEFT JOIN `s_sgc_analisis` ON (s_sgc_analisis.`Id`=s_sgc_analisis_accion_actividad.`Id_Analisis`) LEFT JOIN `s_sgc_sc_evento_adverso_analisis_acciones` ON (s_sgc_sc_evento_adverso_analisis_acciones.`Id_Ficha`=s_sgc_ficha5w1h.`Id`)   where (s_sgc_ficha5w1h.Estado=1 AND s_sgc_ficha5w1h.ControlSeguimiento=1 AND IF(FechaCierre IS NULL, FALSE, TRUE)=1 AND s_sgc_ficha5w1h.FechaRF>='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND  s_sgc_ficha5w1h.FechaRF<='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "') order by s_sgc_ficha5w1h.FechaRF desc ";
                } else if (this.JCHFiltroAccion.isSelected()) {
                    this.xsql = "SELECT s_sgc_ficha5w1h.Id, date_format(s_sgc_ficha5w1h.FechaRF,'%d-%m-%Y') as FechaR , s_sgc_tipo_accion.Nbre, s_sgc_ncorigen.Nbre, s_sgc_tipoproceso.Nbre, persona.NUsuario, if(s_sgc_ficha5w1h.Que IS NULL, '',s_sgc_ficha5w1h.Que) as Que , if(s_sgc_ficha5w1h.ParaQue IS NULL, '',s_sgc_ficha5w1h.ParaQue) as ParaQue , if(s_sgc_ficha5w1h.Como IS NULL, '',s_sgc_ficha5w1h.Como) as Como , DATE_FORMAT(s_sgc_ficha5w1h.Cuando,'%d/%m/%Y') AS Cuando, if(s_sgc_ficha5w1h.Donde IS NULL, '',s_sgc_ficha5w1h.Donde) as Como ,  IF( s_sgc_ficha5w1h.FechaPCierre IS NULL, '', DATE_FORMAT(s_sgc_ficha5w1h.FechaPCierre,'%d/%m/%Y') )AS FPCierre , s_sgc_ficha5w1h.NDiasSeguimiento, IF(FechaCierre IS NULL, FALSE, TRUE) AS estadoa, IF(FechaCierre IS NULL, 'ACTIVA', 'CERRADA') AS estadoL,  Eficaz, IF(FechaCierre IS NULL, DATE_FORMAT(NOW(),'%d-%m-%Y'), DATE_FORMAT(FechaCierre,'%d-%m-%Y')) AS FCierre, if(ObservacionCierre IS NULL, '',ObservacionCierre) AS ObservacionCierre, s_sgc_ficha5w1h.nseguimiento, s_sgc_ficha5w1h.ControlSeguimiento, IF(s_sgc_ficha5w1h.ParaQue IS NULL, TRUE, FALSE) AS VCompletar, s_sgc_ficha5w1h.Id_NC , if(s_sgc_ficha5w1h.FechaUltimoSeg is null,if(ADDDATE(s_sgc_ficha5w1h.Cuando,INTERVAL s_sgc_ficha5w1h.NDiasSeguimiento DAY) <=now() or (s_sgc_ficha5w1h.Cuando<=now()),1,2),if(ADDDATE(s_sgc_ficha5w1h.FechaUltimoSeg,INTERVAL s_sgc_ficha5w1h.NDiasSeguimiento DAY) <=NOW(),1,0 ) ) as ver  , IF(s_sgc_ficha5w1h.FechaUltimoSeg IS NULL,DATE_FORMAT(ADDDATE(s_sgc_ficha5w1h.Cuando,INTERVAL s_sgc_ficha5w1h.NDiasSeguimiento DAY),'%d-%m-%Y'),DATE_FORMAT(ADDDATE(s_sgc_ficha5w1h.FechaUltimoSeg,INTERVAL s_sgc_ficha5w1h.NDiasSeguimiento DAY),'%d-%m-%Y')) AS FPS, if(s_sgc_ficha5w1h.FechaAprendizaje is null,'',s_sgc_ficha5w1h.FechaAprendizaje) as FechaAO, IF(s_sgc_ficha5w1h.DescripcionAO IS NULL,'',s_sgc_ficha5w1h.DescripcionAO) AS DescripcionAO,s_sgc_ficha5w1h.Aprendizaje  , IFNULL(s_sgc_analisis.`Id_NC`, 0) NC  , IFNULL(s_sgc_sc_evento_adverso_analisis_acciones.`Id_EventoA`, 0) EA  , IF((IFNULL(s_sgc_analisis.`Id_NC`, 0)<>0 AND IFNULL(s_sgc_sc_evento_adverso_analisis_acciones.`Id_EventoA`, 0)=0), s_sgc_analisis.`Id_NC`, IF((IFNULL(s_sgc_analisis.`Id_NC`, 0)=0 AND IFNULL(s_sgc_sc_evento_adverso_analisis_acciones.`Id_EventoA`, 0)<>0), s_sgc_sc_evento_adverso_analisis_acciones.`Id_EventoA` , '')) Etiqueta ,IF((IFNULL(s_sgc_analisis.`Id_NC`, 0)<>0 AND IFNULL(s_sgc_sc_evento_adverso_analisis_acciones.`Id_EventoA`, 0)=0), 'No conformidad N°', IF((IFNULL(s_sgc_analisis.`Id_NC`, 0)=0 AND IFNULL(s_sgc_sc_evento_adverso_analisis_acciones.`Id_EventoA`, 0)<>0),'Evento adverso N°' , '')) EtiquetaT  FROM s_sgc_ficha5w1h INNER JOIN s_sgc_tipo_accion  ON (s_sgc_ficha5w1h.Id_TipoAccion = s_sgc_tipo_accion.Id) INNER JOIN s_sgc_ncorigen  ON (s_sgc_ficha5w1h.Id_Origen = s_sgc_ncorigen.Id) INNER JOIN s_sgc_tipoproceso  ON (s_sgc_ficha5w1h.Id_TipoProceso = s_sgc_tipoproceso.Id) INNER JOIN rh_tipo_persona_cargon  ON (s_sgc_ficha5w1h.Id_RhPersonaR = rh_tipo_persona_cargon.Id) INNER JOIN persona  ON (persona.Id_persona = rh_tipo_persona_cargon.Id_Persona)  LEFT JOIN `s_sgc_analisis_accion_actividad` ON (s_sgc_analisis_accion_actividad.`Id_Ficha`=s_sgc_ficha5w1h.`Id`)  LEFT JOIN `s_sgc_analisis` ON (s_sgc_analisis.`Id`=s_sgc_analisis_accion_actividad.`Id_Analisis`) LEFT JOIN `s_sgc_sc_evento_adverso_analisis_acciones` ON (s_sgc_sc_evento_adverso_analisis_acciones.`Id_Ficha`=s_sgc_ficha5w1h.`Id`)   where (s_sgc_ficha5w1h.Estado=1 AND s_sgc_ficha5w1h.ControlSeguimiento=1 AND IF(FechaCierre IS NULL, FALSE, TRUE)=1 AND s_sgc_ficha5w1h.FechaRF>='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND  s_sgc_ficha5w1h.FechaRF<='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' and s_sgc_ficha5w1h.Id_TipoAccion='" + this.xidtipoaccion[this.JCBTipoAccion.getSelectedIndex()][0] + "') order by s_sgc_ficha5w1h.FechaRF desc ";
                }
            } else if (this.JCHTodas.isSelected()) {
                this.xsql = "SELECT s_sgc_ficha5w1h.Id, date_format(s_sgc_ficha5w1h.FechaRF,'%d-%m-%Y') as FechaR , s_sgc_tipo_accion.Nbre, s_sgc_ncorigen.Nbre, s_sgc_tipoproceso.Nbre, persona.NUsuario, if(s_sgc_ficha5w1h.Que IS NULL, '',s_sgc_ficha5w1h.Que) as Que , if(s_sgc_ficha5w1h.ParaQue IS NULL, '',s_sgc_ficha5w1h.ParaQue) as ParaQue , if(s_sgc_ficha5w1h.Como IS NULL, '',s_sgc_ficha5w1h.Como) as Como , DATE_FORMAT(s_sgc_ficha5w1h.Cuando,'%d/%m/%Y') AS Cuando, if(s_sgc_ficha5w1h.Donde IS NULL, '',s_sgc_ficha5w1h.Donde) as Como ,  IF( s_sgc_ficha5w1h.FechaPCierre IS NULL, '', DATE_FORMAT(s_sgc_ficha5w1h.FechaPCierre,'%d/%m/%Y') )AS FPCierre , s_sgc_ficha5w1h.NDiasSeguimiento, IF(FechaCierre IS NULL, FALSE, TRUE) AS estadoa, IF(FechaCierre IS NULL, 'ACTIVA', 'CERRADA') AS estadoL,  Eficaz, IF(FechaCierre IS NULL, DATE_FORMAT(NOW(),'%d-%m-%Y'), DATE_FORMAT(FechaCierre,'%d-%m-%Y')) AS FCierre, if(ObservacionCierre IS NULL, '',ObservacionCierre) AS ObservacionCierre, s_sgc_ficha5w1h.nseguimiento, s_sgc_ficha5w1h.ControlSeguimiento, IF(s_sgc_ficha5w1h.ParaQue IS NULL, TRUE, FALSE) AS VCompletar, s_sgc_ficha5w1h.Id_NC , if(s_sgc_ficha5w1h.FechaUltimoSeg is null,if(ADDDATE(s_sgc_ficha5w1h.Cuando,INTERVAL s_sgc_ficha5w1h.NDiasSeguimiento DAY) <=now() or (s_sgc_ficha5w1h.Cuando<=now()),1,2),if(ADDDATE(s_sgc_ficha5w1h.FechaUltimoSeg,INTERVAL s_sgc_ficha5w1h.NDiasSeguimiento DAY) <=NOW(),1,0 ) ) as ver  , IF(s_sgc_ficha5w1h.FechaUltimoSeg IS NULL,DATE_FORMAT(ADDDATE(s_sgc_ficha5w1h.Cuando,INTERVAL s_sgc_ficha5w1h.NDiasSeguimiento DAY),'%d-%m-%Y'),DATE_FORMAT(ADDDATE(s_sgc_ficha5w1h.FechaUltimoSeg,INTERVAL s_sgc_ficha5w1h.NDiasSeguimiento DAY),'%d-%m-%Y')) AS FPS, if(s_sgc_ficha5w1h.FechaAprendizaje is null,'',s_sgc_ficha5w1h.FechaAprendizaje) as FechaAO, IF(s_sgc_ficha5w1h.DescripcionAO IS NULL,'',s_sgc_ficha5w1h.DescripcionAO) AS DescripcionAO,s_sgc_ficha5w1h.Aprendizaje  , IFNULL(s_sgc_analisis.`Id_NC`, 0) NC  , IFNULL(s_sgc_sc_evento_adverso_analisis_acciones.`Id_EventoA`, 0) EA  , IF((IFNULL(s_sgc_analisis.`Id_NC`, 0)<>0 AND IFNULL(s_sgc_sc_evento_adverso_analisis_acciones.`Id_EventoA`, 0)=0), s_sgc_analisis.`Id_NC`, IF((IFNULL(s_sgc_analisis.`Id_NC`, 0)=0 AND IFNULL(s_sgc_sc_evento_adverso_analisis_acciones.`Id_EventoA`, 0)<>0), s_sgc_sc_evento_adverso_analisis_acciones.`Id_EventoA` , '')) Etiqueta ,IF((IFNULL(s_sgc_analisis.`Id_NC`, 0)<>0 AND IFNULL(s_sgc_sc_evento_adverso_analisis_acciones.`Id_EventoA`, 0)=0), 'No conformidad N°', IF((IFNULL(s_sgc_analisis.`Id_NC`, 0)=0 AND IFNULL(s_sgc_sc_evento_adverso_analisis_acciones.`Id_EventoA`, 0)<>0),'Evento adverso N°' , '')) EtiquetaT  FROM s_sgc_ficha5w1h INNER JOIN s_sgc_tipo_accion  ON (s_sgc_ficha5w1h.Id_TipoAccion = s_sgc_tipo_accion.Id) INNER JOIN s_sgc_ncorigen  ON (s_sgc_ficha5w1h.Id_Origen = s_sgc_ncorigen.Id) INNER JOIN s_sgc_tipoproceso  ON (s_sgc_ficha5w1h.Id_TipoProceso = s_sgc_tipoproceso.Id) INNER JOIN rh_tipo_persona_cargon  ON (s_sgc_ficha5w1h.Id_RhPersonaR = rh_tipo_persona_cargon.Id) INNER JOIN persona  ON (persona.Id_persona = rh_tipo_persona_cargon.Id_Persona)  LEFT JOIN `s_sgc_analisis_accion_actividad` ON (s_sgc_analisis_accion_actividad.`Id_Ficha`=s_sgc_ficha5w1h.`Id`)  LEFT JOIN `s_sgc_analisis` ON (s_sgc_analisis.`Id`=s_sgc_analisis_accion_actividad.`Id_Analisis`) LEFT JOIN `s_sgc_sc_evento_adverso_analisis_acciones` ON (s_sgc_sc_evento_adverso_analisis_acciones.`Id_Ficha`=s_sgc_ficha5w1h.`Id`)   where (s_sgc_ficha5w1h.Estado=1) order by s_sgc_ficha5w1h.FechaRF desc ";
            } else if (this.JCHPorCerrada.isSelected()) {
                this.xsql = "SELECT s_sgc_fcha5w1h.Id, date_format(s_sgc_ficha5w1h.FechaRF,'%d-%m-%Y') as FechaR , s_sgc_tipo_accion.Nbre, s_sgc_ncorigen.Nbre, s_sgc_tipoproceso.Nbre, persona.NUsuario, if(s_sgc_ficha5w1h.Que IS NULL, '',s_sgc_ficha5w1h.Que) as Que , if(s_sgc_ficha5w1h.ParaQue IS NULL, '',s_sgc_ficha5w1h.ParaQue) as ParaQue , if(s_sgc_ficha5w1h.Como IS NULL, '',s_sgc_ficha5w1h.Como) as Como , DATE_FORMAT(s_sgc_ficha5w1h.Cuando,'%d/%m/%Y') AS Cuando, if(s_sgc_ficha5w1h.Donde IS NULL, '',s_sgc_ficha5w1h.Donde) as Como ,  IF( s_sgc_ficha5w1h.FechaPCierre IS NULL, '', DATE_FORMAT(s_sgc_ficha5w1h.FechaPCierre,'%d/%m/%Y') )AS FPCierre , s_sgc_ficha5w1h.NDiasSeguimiento, IF(FechaCierre IS NULL, FALSE, TRUE) AS estadoa, IF(FechaCierre IS NULL, 'ACTIVA', 'CERRADA') AS estadoL,  Eficaz, IF(FechaCierre IS NULL, DATE_FORMAT(NOW(),'%d-%m-%Y'), DATE_FORMAT(FechaCierre,'%d-%m-%Y')) AS FCierre, if(ObservacionCierre IS NULL, '',ObservacionCierre) AS ObservacionCierre, s_sgc_ficha5w1h.nseguimiento, s_sgc_ficha5w1h.ControlSeguimiento, IF(s_sgc_ficha5w1h.ParaQue IS NULL, TRUE, FALSE) AS VCompletar, s_sgc_ficha5w1h.Id_NC , if(s_sgc_ficha5w1h.FechaUltimoSeg is null,if(ADDDATE(s_sgc_ficha5w1h.Cuando,INTERVAL s_sgc_ficha5w1h.NDiasSeguimiento DAY) <=now() or (s_sgc_ficha5w1h.Cuando<=now()),1,2),if(ADDDATE(s_sgc_ficha5w1h.FechaUltimoSeg,INTERVAL s_sgc_ficha5w1h.NDiasSeguimiento DAY) <=NOW(),1,0 ) ) as ver  , IF(s_sgc_ficha5w1h.FechaUltimoSeg IS NULL,DATE_FORMAT(ADDDATE(s_sgc_ficha5w1h.Cuando,INTERVAL s_sgc_ficha5w1h.NDiasSeguimiento DAY),'%d-%m-%Y'),DATE_FORMAT(ADDDATE(s_sgc_ficha5w1h.FechaUltimoSeg,INTERVAL s_sgc_ficha5w1h.NDiasSeguimiento DAY),'%d-%m-%Y')) AS FPS, if(s_sgc_ficha5w1h.FechaAprendizaje is null,'',s_sgc_ficha5w1h.FechaAprendizaje) as FechaAO, IF(s_sgc_ficha5w1h.DescripcionAO IS NULL,'',s_sgc_ficha5w1h.DescripcionAO) AS DescripcionAO,s_sgc_ficha5w1h.Aprendizaje  , IFNULL(s_sgc_analisis.`Id_NC`, 0) NC  , IFNULL(s_sgc_sc_evento_adverso_analisis_acciones.`Id_EventoA`, 0) EA  , IF((IFNULL(s_sgc_analisis.`Id_NC`, 0)<>0 AND IFNULL(s_sgc_sc_evento_adverso_analisis_acciones.`Id_EventoA`, 0)=0), s_sgc_analisis.`Id_NC`, IF((IFNULL(s_sgc_analisis.`Id_NC`, 0)=0 AND IFNULL(s_sgc_sc_evento_adverso_analisis_acciones.`Id_EventoA`, 0)<>0), s_sgc_sc_evento_adverso_analisis_acciones.`Id_EventoA` , '')) Etiqueta ,IF((IFNULL(s_sgc_analisis.`Id_NC`, 0)<>0 AND IFNULL(s_sgc_sc_evento_adverso_analisis_acciones.`Id_EventoA`, 0)=0), 'No conformidad N°', IF((IFNULL(s_sgc_analisis.`Id_NC`, 0)=0 AND IFNULL(s_sgc_sc_evento_adverso_analisis_acciones.`Id_EventoA`, 0)<>0),'Evento adverso N°' , '')) EtiquetaT  FROM s_sgc_ficha5w1h INNER JOIN s_sgc_tipo_accion  ON (s_sgc_ficha5w1h.Id_TipoAccion = s_sgc_tipo_accion.Id) INNER JOIN s_sgc_ncorigen  ON (s_sgc_ficha5w1h.Id_Origen = s_sgc_ncorigen.Id) INNER JOIN s_sgc_tipoproceso  ON (s_sgc_ficha5w1h.Id_TipoProceso = s_sgc_tipoproceso.Id) INNER JOIN rh_tipo_persona_cargon  ON (s_sgc_ficha5w1h.Id_RhPersonaR = rh_tipo_persona_cargon.Id) INNER JOIN persona  ON (persona.Id_persona = rh_tipo_persona_cargon.Id_Persona)  LEFT JOIN `s_sgc_analisis_accion_actividad` ON (s_sgc_analisis_accion_actividad.`Id_Ficha`=s_sgc_ficha5w1h.`Id`)  LEFT JOIN `s_sgc_analisis` ON (s_sgc_analisis.`Id`=s_sgc_analisis_accion_actividad.`Id_Analisis`) LEFT JOIN `s_sgc_sc_evento_adverso_analisis_acciones` ON (s_sgc_sc_evento_adverso_analisis_acciones.`Id_Ficha`=s_sgc_ficha5w1h.`Id`)   where (s_sgc_ficha5w1h.Estado=1 AND s_sgc_ficha5w1h.ControlSeguimiento=1 AND IF(FechaCierre IS NULL, FALSE, TRUE)=0) order by s_sgc_ficha5w1h.FechaRF desc ";
            } else if (this.JCHCerradas.isSelected()) {
                this.xsql = "SELECT s_sgc_ficha5w1h.Id, date_format(s_sgc_ficha5w1h.FechaRF,'%d-%m-%Y') as FechaR , s_sgc_tipo_accion.Nbre, s_sgc_ncorigen.Nbre, s_sgc_tipoproceso.Nbre, persona.NUsuario, if(s_sgc_ficha5w1h.Que IS NULL, '',s_sgc_ficha5w1h.Que) as Que , if(s_sgc_ficha5w1h.ParaQue IS NULL, '',s_sgc_ficha5w1h.ParaQue) as ParaQue , if(s_sgc_ficha5w1h.Como IS NULL, '',s_sgc_ficha5w1h.Como) as Como , DATE_FORMAT(s_sgc_ficha5w1h.Cuando,'%d/%m/%Y') AS Cuando, if(s_sgc_ficha5w1h.Donde IS NULL, '',s_sgc_ficha5w1h.Donde) as Como ,  IF( s_sgc_ficha5w1h.FechaPCierre IS NULL, '', DATE_FORMAT(s_sgc_ficha5w1h.FechaPCierre,'%d/%m/%Y') )AS FPCierre , s_sgc_ficha5w1h.NDiasSeguimiento, IF(FechaCierre IS NULL, FALSE, TRUE) AS estadoa, IF(FechaCierre IS NULL, 'ACTIVA', 'CERRADA') AS estadoL,  Eficaz, IF(FechaCierre IS NULL, DATE_FORMAT(NOW(),'%d-%m-%Y'), DATE_FORMAT(FechaCierre,'%d-%m-%Y')) AS FCierre, if(ObservacionCierre IS NULL, '',ObservacionCierre) AS ObservacionCierre, s_sgc_ficha5w1h.nseguimiento, s_sgc_ficha5w1h.ControlSeguimiento, IF(s_sgc_ficha5w1h.ParaQue IS NULL, TRUE, FALSE) AS VCompletar, s_sgc_ficha5w1h.Id_NC , if(s_sgc_ficha5w1h.FechaUltimoSeg is null,if(ADDDATE(s_sgc_ficha5w1h.Cuando,INTERVAL s_sgc_ficha5w1h.NDiasSeguimiento DAY) <=now() or (s_sgc_ficha5w1h.Cuando<=now()),1,2),if(ADDDATE(s_sgc_ficha5w1h.FechaUltimoSeg,INTERVAL s_sgc_ficha5w1h.NDiasSeguimiento DAY) <=NOW(),1,0 ) ) as ver  , IF(s_sgc_ficha5w1h.FechaUltimoSeg IS NULL,DATE_FORMAT(ADDDATE(s_sgc_ficha5w1h.Cuando,INTERVAL s_sgc_ficha5w1h.NDiasSeguimiento DAY),'%d-%m-%Y'),DATE_FORMAT(ADDDATE(s_sgc_ficha5w1h.FechaUltimoSeg,INTERVAL s_sgc_ficha5w1h.NDiasSeguimiento DAY),'%d-%m-%Y')) AS FPS, if(s_sgc_ficha5w1h.FechaAprendizaje is null,'',s_sgc_ficha5w1h.FechaAprendizaje) as FechaAO, IF(s_sgc_ficha5w1h.DescripcionAO IS NULL,'',s_sgc_ficha5w1h.DescripcionAO) AS DescripcionAO,s_sgc_ficha5w1h.Aprendizaje  , IFNULL(s_sgc_analisis.`Id_NC`, 0) NC  , IFNULL(s_sgc_sc_evento_adverso_analisis_acciones.`Id_EventoA`, 0) EA  , IF((IFNULL(s_sgc_analisis.`Id_NC`, 0)<>0 AND IFNULL(s_sgc_sc_evento_adverso_analisis_acciones.`Id_EventoA`, 0)=0), s_sgc_analisis.`Id_NC`, IF((IFNULL(s_sgc_analisis.`Id_NC`, 0)=0 AND IFNULL(s_sgc_sc_evento_adverso_analisis_acciones.`Id_EventoA`, 0)<>0), s_sgc_sc_evento_adverso_analisis_acciones.`Id_EventoA` , '')) Etiqueta ,IF((IFNULL(s_sgc_analisis.`Id_NC`, 0)<>0 AND IFNULL(s_sgc_sc_evento_adverso_analisis_acciones.`Id_EventoA`, 0)=0), 'No conformidad N°', IF((IFNULL(s_sgc_analisis.`Id_NC`, 0)=0 AND IFNULL(s_sgc_sc_evento_adverso_analisis_acciones.`Id_EventoA`, 0)<>0),'Evento adverso N°' , '')) EtiquetaT  FROM s_sgc_ficha5w1h INNER JOIN s_sgc_tipo_accion  ON (s_sgc_ficha5w1h.Id_TipoAccion = s_sgc_tipo_accion.Id) INNER JOIN s_sgc_ncorigen  ON (s_sgc_ficha5w1h.Id_Origen = s_sgc_ncorigen.Id) INNER JOIN s_sgc_tipoproceso  ON (s_sgc_ficha5w1h.Id_TipoProceso = s_sgc_tipoproceso.Id) INNER JOIN rh_tipo_persona_cargon  ON (s_sgc_ficha5w1h.Id_RhPersonaR = rh_tipo_persona_cargon.Id) INNER JOIN persona  ON (persona.Id_persona = rh_tipo_persona_cargon.Id_Persona)  LEFT JOIN `s_sgc_analisis_accion_actividad` ON (s_sgc_analisis_accion_actividad.`Id_Ficha`=s_sgc_ficha5w1h.`Id`)  LEFT JOIN `s_sgc_analisis` ON (s_sgc_analisis.`Id`=s_sgc_analisis_accion_actividad.`Id_Analisis`) LEFT JOIN `s_sgc_sc_evento_adverso_analisis_acciones` ON (s_sgc_sc_evento_adverso_analisis_acciones.`Id_Ficha`=s_sgc_ficha5w1h.`Id`)   where (s_sgc_ficha5w1h.Estado=1 AND s_sgc_ficha5w1h.ControlSeguimiento=1 AND IF(FechaCierre IS NULL, FALSE, TRUE)=1) order by s_sgc_ficha5w1h.FechaRF desc ";
            } else if (this.JCHFiltroAccion.isSelected()) {
                this.xsql = "SELECT s_sgc_ficha5w1h.Id, date_format(s_sgc_ficha5w1h.FechaRF,'%d-%m-%Y') as FechaR , s_sgc_tipo_accion.Nbre, s_sgc_ncorigen.Nbre, s_sgc_tipoproceso.Nbre, persona.NUsuario, if(s_sgc_ficha5w1h.Que IS NULL, '',s_sgc_ficha5w1h.Que) as Que , if(s_sgc_ficha5w1h.ParaQue IS NULL, '',s_sgc_ficha5w1h.ParaQue) as ParaQue , if(s_sgc_ficha5w1h.Como IS NULL, '',s_sgc_ficha5w1h.Como) as Como , DATE_FORMAT(s_sgc_ficha5w1h.Cuando,'%d/%m/%Y') AS Cuando, if(s_sgc_ficha5w1h.Donde IS NULL, '',s_sgc_ficha5w1h.Donde) as Como ,  IF( s_sgc_ficha5w1h.FechaPCierre IS NULL, '', DATE_FORMAT(s_sgc_ficha5w1h.FechaPCierre,'%d/%m/%Y') )AS FPCierre , s_sgc_ficha5w1h.NDiasSeguimiento, IF(FechaCierre IS NULL, FALSE, TRUE) AS estadoa, IF(FechaCierre IS NULL, 'ACTIVA', 'CERRADA') AS estadoL,  Eficaz, IF(FechaCierre IS NULL, DATE_FORMAT(NOW(),'%d-%m-%Y'), DATE_FORMAT(FechaCierre,'%d-%m-%Y')) AS FCierre, if(ObservacionCierre IS NULL, '',ObservacionCierre) AS ObservacionCierre, s_sgc_ficha5w1h.nseguimiento, s_sgc_ficha5w1h.ControlSeguimiento, IF(s_sgc_ficha5w1h.ParaQue IS NULL, TRUE, FALSE) AS VCompletar, s_sgc_ficha5w1h.Id_NC , if(s_sgc_ficha5w1h.FechaUltimoSeg is null,if(ADDDATE(s_sgc_ficha5w1h.Cuando,INTERVAL s_sgc_ficha5w1h.NDiasSeguimiento DAY) <=now() or (s_sgc_ficha5w1h.Cuando<=now()),1,2),if(ADDDATE(s_sgc_ficha5w1h.FechaUltimoSeg,INTERVAL s_sgc_ficha5w1h.NDiasSeguimiento DAY) <=NOW(),1,0 ) ) as ver  , IF(s_sgc_ficha5w1h.FechaUltimoSeg IS NULL,DATE_FORMAT(ADDDATE(s_sgc_ficha5w1h.Cuando,INTERVAL s_sgc_ficha5w1h.NDiasSeguimiento DAY),'%d-%m-%Y'),DATE_FORMAT(ADDDATE(s_sgc_ficha5w1h.FechaUltimoSeg,INTERVAL s_sgc_ficha5w1h.NDiasSeguimiento DAY),'%d-%m-%Y')) AS FPS, if(s_sgc_ficha5w1h.FechaAprendizaje is null,'',s_sgc_ficha5w1h.FechaAprendizaje) as FechaAO, IF(s_sgc_ficha5w1h.DescripcionAO IS NULL,'',s_sgc_ficha5w1h.DescripcionAO) AS DescripcionAO,s_sgc_ficha5w1h.Aprendizaje  , IFNULL(s_sgc_analisis.`Id_NC`, 0) NC  , IFNULL(s_sgc_sc_evento_adverso_analisis_acciones.`Id_EventoA`, 0) EA  , IF((IFNULL(s_sgc_analisis.`Id_NC`, 0)<>0 AND IFNULL(s_sgc_sc_evento_adverso_analisis_acciones.`Id_EventoA`, 0)=0), s_sgc_analisis.`Id_NC`, IF((IFNULL(s_sgc_analisis.`Id_NC`, 0)=0 AND IFNULL(s_sgc_sc_evento_adverso_analisis_acciones.`Id_EventoA`, 0)<>0), s_sgc_sc_evento_adverso_analisis_acciones.`Id_EventoA` , '')) Etiqueta ,IF((IFNULL(s_sgc_analisis.`Id_NC`, 0)<>0 AND IFNULL(s_sgc_sc_evento_adverso_analisis_acciones.`Id_EventoA`, 0)=0), 'No conformidad N°', IF((IFNULL(s_sgc_analisis.`Id_NC`, 0)=0 AND IFNULL(s_sgc_sc_evento_adverso_analisis_acciones.`Id_EventoA`, 0)<>0),'Evento adverso N°' , '')) EtiquetaT  FROM s_sgc_ficha5w1h INNER JOIN s_sgc_tipo_accion  ON (s_sgc_ficha5w1h.Id_TipoAccion = s_sgc_tipo_accion.Id) INNER JOIN s_sgc_ncorigen  ON (s_sgc_ficha5w1h.Id_Origen = s_sgc_ncorigen.Id) INNER JOIN s_sgc_tipoproceso  ON (s_sgc_ficha5w1h.Id_TipoProceso = s_sgc_tipoproceso.Id) INNER JOIN rh_tipo_persona_cargon  ON (s_sgc_ficha5w1h.Id_RhPersonaR = rh_tipo_persona_cargon.Id) INNER JOIN persona  ON (persona.Id_persona = rh_tipo_persona_cargon.Id_Persona)  LEFT JOIN `s_sgc_analisis_accion_actividad` ON (s_sgc_analisis_accion_actividad.`Id_Ficha`=s_sgc_ficha5w1h.`Id`)  LEFT JOIN `s_sgc_analisis` ON (s_sgc_analisis.`Id`=s_sgc_analisis_accion_actividad.`Id_Analisis`) LEFT JOIN `s_sgc_sc_evento_adverso_analisis_acciones` ON (s_sgc_sc_evento_adverso_analisis_acciones.`Id_Ficha`=s_sgc_ficha5w1h.`Id`)   where (s_sgc_ficha5w1h.Estado=1 AND s_sgc_ficha5w1h.ControlSeguimiento=1 AND IF(FechaCierre IS NULL, FALSE, TRUE)=1 and s_sgc_ficha5w1h.Id_TipoAccion='" + this.xidtipoaccion[this.JCBTipoAccion.getSelectedIndex()][0] + "') order by s_sgc_ficha5w1h.FechaRF desc ";
            }
        } else if (this.xmodulo == 2) {
            if (this.JCHFiltroAccion.isSelected()) {
                this.xsql = "SELECT s_sgc_ficha5w1h.Id, date_format(s_sgc_ficha5w1h.FechaRF,'%d-%m-%Y') as FechaR , s_sgc_tipo_accion.Nbre, s_sgc_ncorigen.Nbre, s_sgc_tipoproceso.Nbre, persona.NUsuario, if(s_sgc_ficha5w1h.Que IS NULL, '',s_sgc_ficha5w1h.Que) as Que , if(s_sgc_ficha5w1h.ParaQue IS NULL, '',s_sgc_ficha5w1h.ParaQue) as ParaQue , if(s_sgc_ficha5w1h.Como IS NULL, '',s_sgc_ficha5w1h.Como) as Como , DATE_FORMAT(s_sgc_ficha5w1h.Cuando,'%d/%m/%Y') AS Cuando, if(s_sgc_ficha5w1h.Donde IS NULL, '',s_sgc_ficha5w1h.Donde) as Como ,  IF( s_sgc_ficha5w1h.FechaPCierre IS NULL, '', DATE_FORMAT(s_sgc_ficha5w1h.FechaPCierre,'%d/%m/%Y') )AS FPCierre , s_sgc_ficha5w1h.NDiasSeguimiento, IF(FechaCierre IS NULL, FALSE, TRUE) AS estadoa, IF(FechaCierre IS NULL, 'ACTIVA', 'CERRADA') AS estadoL,  Eficaz, IF(FechaCierre IS NULL, DATE_FORMAT(NOW(),'%d-%m-%Y'), DATE_FORMAT(FechaCierre,'%d-%m-%Y')) AS FCierre, if(ObservacionCierre IS NULL, '',ObservacionCierre) AS ObservacionCierre, s_sgc_ficha5w1h.nseguimiento, s_sgc_ficha5w1h.ControlSeguimiento, IF(s_sgc_ficha5w1h.ParaQue IS NULL, TRUE, FALSE) AS VCompletar, s_sgc_ficha5w1h.Id_NC , if(s_sgc_ficha5w1h.FechaUltimoSeg is null,if(ADDDATE(s_sgc_ficha5w1h.Cuando,INTERVAL s_sgc_ficha5w1h.NDiasSeguimiento DAY) <=now() or (s_sgc_ficha5w1h.Cuando<=now()),1,2),if(ADDDATE(s_sgc_ficha5w1h.FechaUltimoSeg,INTERVAL s_sgc_ficha5w1h.NDiasSeguimiento DAY) <=NOW(),1,0 ) ) as ver  , IF(s_sgc_ficha5w1h.FechaUltimoSeg IS NULL,DATE_FORMAT(ADDDATE(s_sgc_ficha5w1h.Cuando,INTERVAL s_sgc_ficha5w1h.NDiasSeguimiento DAY),'%d-%m-%Y'),DATE_FORMAT(ADDDATE(s_sgc_ficha5w1h.FechaUltimoSeg,INTERVAL s_sgc_ficha5w1h.NDiasSeguimiento DAY),'%d-%m-%Y')) AS FPS, if(s_sgc_ficha5w1h.FechaAprendizaje is null,'',s_sgc_ficha5w1h.FechaAprendizaje) as FechaAO, IF(s_sgc_ficha5w1h.DescripcionAO IS NULL,'',s_sgc_ficha5w1h.DescripcionAO) AS DescripcionAO,s_sgc_ficha5w1h.Aprendizaje  , IFNULL(s_sgc_analisis.`Id_NC`, 0) NC  , IFNULL(s_sgc_sc_evento_adverso_analisis_acciones.`Id_EventoA`, 0) EA  , IF((IFNULL(s_sgc_analisis.`Id_NC`, 0)<>0 AND IFNULL(s_sgc_sc_evento_adverso_analisis_acciones.`Id_EventoA`, 0)=0), s_sgc_analisis.`Id_NC`, IF((IFNULL(s_sgc_analisis.`Id_NC`, 0)=0 AND IFNULL(s_sgc_sc_evento_adverso_analisis_acciones.`Id_EventoA`, 0)<>0), s_sgc_sc_evento_adverso_analisis_acciones.`Id_EventoA` , '')) Etiqueta ,IF((IFNULL(s_sgc_analisis.`Id_NC`, 0)<>0 AND IFNULL(s_sgc_sc_evento_adverso_analisis_acciones.`Id_EventoA`, 0)=0), 'No conformidad N°', IF((IFNULL(s_sgc_analisis.`Id_NC`, 0)=0 AND IFNULL(s_sgc_sc_evento_adverso_analisis_acciones.`Id_EventoA`, 0)<>0),'Evento adverso N°' , '')) EtiquetaT  FROM s_sgc_ficha5w1h INNER JOIN s_sgc_tipo_accion  ON (s_sgc_ficha5w1h.Id_TipoAccion = s_sgc_tipo_accion.Id) INNER JOIN s_sgc_ncorigen  ON (s_sgc_ficha5w1h.Id_Origen = s_sgc_ncorigen.Id) INNER JOIN s_sgc_tipoproceso  ON (s_sgc_ficha5w1h.Id_TipoProceso = s_sgc_tipoproceso.Id) INNER JOIN rh_tipo_persona_cargon  ON (s_sgc_ficha5w1h.Id_RhPersonaR = rh_tipo_persona_cargon.Id) INNER JOIN persona  ON (persona.Id_persona = rh_tipo_persona_cargon.Id_Persona)  LEFT JOIN `s_sgc_analisis_accion_actividad` ON (s_sgc_analisis_accion_actividad.`Id_Ficha`=s_sgc_ficha5w1h.`Id`)  LEFT JOIN `s_sgc_analisis` ON (s_sgc_analisis.`Id`=s_sgc_analisis_accion_actividad.`Id_Analisis`) LEFT JOIN `s_sgc_sc_evento_adverso_analisis_acciones` ON (s_sgc_sc_evento_adverso_analisis_acciones.`Id_Ficha`=s_sgc_ficha5w1h.`Id`)   where (FechaCierre IS NULL AND s_sgc_ficha5w1h.Id_RhPersonaR='" + Principal.usuarioSistemaDTO.getIdPersonaCargo() + "' AND s_sgc_ficha5w1h.Estado=1 AND IF(s_sgc_ficha5w1h.FechaUltimoSeg IS NULL,IF(ADDDATE(s_sgc_ficha5w1h.Cuando,INTERVAL s_sgc_ficha5w1h.NDiasSeguimiento DAY) <=NOW(),1,2),IF(ADDDATE(s_sgc_ficha5w1h.FechaUltimoSeg,INTERVAL s_sgc_ficha5w1h.NDiasSeguimiento DAY) <=NOW(),1,0 ) )=1 and s_sgc_ficha5w1h.Id_TipoAccion='" + this.xidtipoaccion[this.JCBTipoAccion.getSelectedIndex()][0] + "')  order by s_sgc_ficha5w1h.FechaRF desc ";
            } else {
                this.xsql = "SELECT s_sgc_ficha5w1h.Id, date_format(s_sgc_ficha5w1h.FechaRF,'%d-%m-%Y') as FechaR , s_sgc_tipo_accion.Nbre, s_sgc_ncorigen.Nbre, s_sgc_tipoproceso.Nbre, persona.NUsuario, if(s_sgc_ficha5w1h.Que IS NULL, '',s_sgc_ficha5w1h.Que) as Que , if(s_sgc_ficha5w1h.ParaQue IS NULL, '',s_sgc_ficha5w1h.ParaQue) as ParaQue , if(s_sgc_ficha5w1h.Como IS NULL, '',s_sgc_ficha5w1h.Como) as Como , DATE_FORMAT(s_sgc_ficha5w1h.Cuando,'%d/%m/%Y') AS Cuando, if(s_sgc_ficha5w1h.Donde IS NULL, '',s_sgc_ficha5w1h.Donde) as Como ,  IF( s_sgc_ficha5w1h.FechaPCierre IS NULL, '', DATE_FORMAT(s_sgc_ficha5w1h.FechaPCierre,'%d/%m/%Y') )AS FPCierre , s_sgc_ficha5w1h.NDiasSeguimiento, IF(FechaCierre IS NULL, FALSE, TRUE) AS estadoa, IF(FechaCierre IS NULL, 'ACTIVA', 'CERRADA') AS estadoL,  Eficaz, IF(FechaCierre IS NULL, DATE_FORMAT(NOW(),'%d-%m-%Y'), DATE_FORMAT(FechaCierre,'%d-%m-%Y')) AS FCierre, if(ObservacionCierre IS NULL, '',ObservacionCierre) AS ObservacionCierre, s_sgc_ficha5w1h.nseguimiento, s_sgc_ficha5w1h.ControlSeguimiento, IF(s_sgc_ficha5w1h.ParaQue IS NULL, TRUE, FALSE) AS VCompletar, s_sgc_ficha5w1h.Id_NC , if(s_sgc_ficha5w1h.FechaUltimoSeg is null,if(ADDDATE(s_sgc_ficha5w1h.Cuando,INTERVAL s_sgc_ficha5w1h.NDiasSeguimiento DAY) <=now() or (s_sgc_ficha5w1h.Cuando<=now()),1,2),if(ADDDATE(s_sgc_ficha5w1h.FechaUltimoSeg,INTERVAL s_sgc_ficha5w1h.NDiasSeguimiento DAY) <=NOW(),1,0 ) ) as ver  , IF(s_sgc_ficha5w1h.FechaUltimoSeg IS NULL,DATE_FORMAT(ADDDATE(s_sgc_ficha5w1h.Cuando,INTERVAL s_sgc_ficha5w1h.NDiasSeguimiento DAY),'%d-%m-%Y'),DATE_FORMAT(ADDDATE(s_sgc_ficha5w1h.FechaUltimoSeg,INTERVAL s_sgc_ficha5w1h.NDiasSeguimiento DAY),'%d-%m-%Y')) AS FPS, if(s_sgc_ficha5w1h.FechaAprendizaje is null,'',s_sgc_ficha5w1h.FechaAprendizaje) as FechaAO, IF(s_sgc_ficha5w1h.DescripcionAO IS NULL,'',s_sgc_ficha5w1h.DescripcionAO) AS DescripcionAO,s_sgc_ficha5w1h.Aprendizaje  , IFNULL(s_sgc_analisis.`Id_NC`, 0) NC  , IFNULL(s_sgc_sc_evento_adverso_analisis_acciones.`Id_EventoA`, 0) EA  , IF((IFNULL(s_sgc_analisis.`Id_NC`, 0)<>0 AND IFNULL(s_sgc_sc_evento_adverso_analisis_acciones.`Id_EventoA`, 0)=0), s_sgc_analisis.`Id_NC`, IF((IFNULL(s_sgc_analisis.`Id_NC`, 0)=0 AND IFNULL(s_sgc_sc_evento_adverso_analisis_acciones.`Id_EventoA`, 0)<>0), s_sgc_sc_evento_adverso_analisis_acciones.`Id_EventoA` , '')) Etiqueta ,IF((IFNULL(s_sgc_analisis.`Id_NC`, 0)<>0 AND IFNULL(s_sgc_sc_evento_adverso_analisis_acciones.`Id_EventoA`, 0)=0), 'No conformidad N°', IF((IFNULL(s_sgc_analisis.`Id_NC`, 0)=0 AND IFNULL(s_sgc_sc_evento_adverso_analisis_acciones.`Id_EventoA`, 0)<>0),'Evento adverso N°' , '')) EtiquetaT  FROM s_sgc_ficha5w1h INNER JOIN s_sgc_tipo_accion  ON (s_sgc_ficha5w1h.Id_TipoAccion = s_sgc_tipo_accion.Id) INNER JOIN s_sgc_ncorigen  ON (s_sgc_ficha5w1h.Id_Origen = s_sgc_ncorigen.Id) INNER JOIN s_sgc_tipoproceso  ON (s_sgc_ficha5w1h.Id_TipoProceso = s_sgc_tipoproceso.Id) INNER JOIN rh_tipo_persona_cargon  ON (s_sgc_ficha5w1h.Id_RhPersonaR = rh_tipo_persona_cargon.Id) INNER JOIN persona  ON (persona.Id_persona = rh_tipo_persona_cargon.Id_Persona)  LEFT JOIN `s_sgc_analisis_accion_actividad` ON (s_sgc_analisis_accion_actividad.`Id_Ficha`=s_sgc_ficha5w1h.`Id`)  LEFT JOIN `s_sgc_analisis` ON (s_sgc_analisis.`Id`=s_sgc_analisis_accion_actividad.`Id_Analisis`) LEFT JOIN `s_sgc_sc_evento_adverso_analisis_acciones` ON (s_sgc_sc_evento_adverso_analisis_acciones.`Id_Ficha`=s_sgc_ficha5w1h.`Id`)   where (FechaCierre IS NULL AND s_sgc_ficha5w1h.Id_RhPersonaR='" + Principal.usuarioSistemaDTO.getIdPersonaCargo() + "' AND s_sgc_ficha5w1h.Estado=1 AND IF(s_sgc_ficha5w1h.FechaUltimoSeg IS NULL,IF(ADDDATE(s_sgc_ficha5w1h.Cuando,INTERVAL s_sgc_ficha5w1h.NDiasSeguimiento DAY) <=NOW(),1,2),IF(ADDDATE(s_sgc_ficha5w1h.FechaUltimoSeg,INTERVAL s_sgc_ficha5w1h.NDiasSeguimiento DAY) <=NOW(),1,0 ) )=1 )  order by s_sgc_ficha5w1h.FechaRF desc ";
            }
        }
        if (!this.xsql.isEmpty()) {
            System.out.println(" Historico " + this.xsql);
            ConsultasMySQL xct2 = new ConsultasMySQL();
            ResultSet xrs = xct2.traerRs(this.xsql);
            TableColumnModel cmodel = this.JTDetalleH.getColumnModel();
            TextAreaRenderer textAreaRenderer = new TextAreaRenderer();
            cmodel.getColumn(6).setCellRenderer(textAreaRenderer);
            TextAreaEditor textEditor = new TextAreaEditor();
            cmodel.getColumn(6).setCellEditor(textEditor);
            try {
                if (xrs.next()) {
                    xrs.beforeFirst();
                    while (xrs.next()) {
                        System.out.println(xrs.getString(1));
                        this.xnfila1++;
                        this.xmodelo1.addRow(this.xdato);
                        this.xmodelo1.setValueAt(Long.valueOf(xrs.getLong(1)), this.xnfila1, 0);
                        this.xmodelo1.setValueAt(xrs.getString(2), this.xnfila1, 1);
                        this.xmodelo1.setValueAt(xrs.getString(3), this.xnfila1, 2);
                        this.xmodelo1.setValueAt(xrs.getString(4), this.xnfila1, 3);
                        this.xmodelo1.setValueAt(xrs.getString(5), this.xnfila1, 4);
                        this.xmodelo1.setValueAt(xrs.getString(6), this.xnfila1, 5);
                        this.xmodelo1.setValueAt(xrs.getString(7), this.xnfila1, 6);
                        this.xmodelo1.setValueAt(xrs.getString(8), this.xnfila1, 7);
                        this.xmodelo1.setValueAt(xrs.getString(9), this.xnfila1, 8);
                        this.xmodelo1.setValueAt(xrs.getString(10), this.xnfila1, 9);
                        this.xmodelo1.setValueAt(xrs.getString(11), this.xnfila1, 10);
                        this.xmodelo1.setValueAt(xrs.getString(12), this.xnfila1, 11);
                        this.xmodelo1.setValueAt(Long.valueOf(xrs.getLong(13)), this.xnfila1, 12);
                        this.xmodelo1.setValueAt(Boolean.valueOf(xrs.getBoolean(14)), this.xnfila1, 13);
                        this.xmodelo1.setValueAt(xrs.getString(15), this.xnfila1, 14);
                        this.xmodelo1.setValueAt(Boolean.valueOf(xrs.getBoolean(16)), this.xnfila1, 15);
                        this.xmodelo1.setValueAt(xrs.getString(17), this.xnfila1, 16);
                        this.xmodelo1.setValueAt(xrs.getString(18), this.xnfila1, 17);
                        this.xmodelo1.setValueAt(Long.valueOf(xrs.getLong(19)), this.xnfila1, 18);
                        this.JTDetalleH.setDefaultRenderer(Object.class, new MiRender());
                        this.xmodelo1.setValueAt(Boolean.valueOf(xrs.getBoolean(20)), this.xnfila1, 19);
                        this.xmodelo1.setValueAt(Boolean.valueOf(xrs.getBoolean(21)), this.xnfila1, 20);
                        this.xmodelo1.setValueAt(Long.valueOf(xrs.getLong(22)), this.xnfila1, 21);
                        this.xmodelo1.setValueAt(Long.valueOf(xrs.getLong(23)), this.xnfila1, 22);
                        this.xmodelo1.setValueAt(xrs.getString(24), this.xnfila1, 23);
                        this.xmodelo1.setValueAt(xrs.getString(25), this.xnfila1, 24);
                        this.xmodelo1.setValueAt(xrs.getString(26), this.xnfila1, 25);
                        this.xmodelo1.setValueAt(Integer.valueOf(xrs.getInt(27)), this.xnfila1, 26);
                        this.xmodelo1.setValueAt(xrs.getString("NC"), this.xnfila1, 27);
                        this.xmodelo1.setValueAt(xrs.getString("EA"), this.xnfila1, 28);
                        this.xmodelo1.setValueAt(xrs.getString("Etiqueta"), this.xnfila1, 29);
                        this.xmodelo1.setValueAt(xrs.getString("EtiquetaT"), this.xnfila1, 30);
                    }
                }
                xrs.close();
                xct2.cerrarConexionBd();
            } catch (SQLException ex) {
                Logger.getLogger(JIFFicha5w1H.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
    }

    private void mBucarSeguimientos() {
        mCrearTablaDetalleSeguimiento();
        this.xsql = "SELECT s_sgc_ficha5w1h_seguimiento.Id, DATE_FORMAT(FechaS,'%d-%m-%Y') AS FechaS, s_sgc_ficha5w1h_seguimiento.ObservacionS, persona.NUsuario, rh_tipo_cargo.Nbre, s_sgc_tipoproceso.Nbre FROM s_sgc_ficha5w1h_seguimiento INNER JOIN rh_tipo_persona_cargon  ON (s_sgc_ficha5w1h_seguimiento.Id_RhPersona = rh_tipo_persona_cargon.Id) INNER JOIN s_sgc_tipoproceso  ON (s_sgc_ficha5w1h_seguimiento.Id_TProceso = s_sgc_tipoproceso.Id) INNER JOIN persona  ON (persona.Id_persona = rh_tipo_persona_cargon.Id_Persona) INNER JOIN rh_unidadf_cargo  ON (rh_tipo_persona_cargon.Id_unidadf_cargo = rh_unidadf_cargo.Id) INNER JOIN rh_tipo_cargo ON (rh_unidadf_cargo.Id_Cargo = rh_tipo_cargo.Id) WHERE (s_sgc_ficha5w1h_seguimiento.Estado =1 AND s_sgc_ficha5w1h_seguimiento.Id_Ficha5w1h ='" + Principal.txtNo.getText() + "') ORDER BY s_sgc_ficha5w1h_seguimiento.FechaS DESC ";
        ResultSet xrs = this.xct.traerRs(this.xsql);
        TableColumnModel cmodel = this.JTDetalleS.getColumnModel();
        TextAreaRenderer textAreaRenderer = new TextAreaRenderer();
        cmodel.getColumn(2).setCellRenderer(textAreaRenderer);
        TextAreaEditor textEditor = new TextAreaEditor();
        cmodel.getColumn(2).setCellEditor(textEditor);
        try {
            if (xrs.next()) {
                xrs.beforeFirst();
                while (xrs.next()) {
                    this.xnfila++;
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(1)), this.xnfila, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), this.xnfila, 1);
                    this.xmodelo.setValueAt(xrs.getString(3), this.xnfila, 2);
                    this.xmodelo.setValueAt(xrs.getString(4), this.xnfila, 3);
                    this.xmodelo.setValueAt(xrs.getString(5), this.xnfila, 4);
                    this.xmodelo.setValueAt(xrs.getString(6), this.xnfila, 5);
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFicha5w1H.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mBucarEvidencias() {
        mCrearTablaEvidencia();
        this.xsql = "SELECT Id, FechaE, DescripcionE, Url FROM s_sgc_ficha5w1h_evidencia WHERE (Id_Ficha5w1h ='" + Principal.txtNo.getText() + "' AND Estado =1) ORDER BY FechaE DESC ";
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

    private void mBucarAprendizaje() {
        mCrearTablaAprendizaje();
        this.xsql = "SELECT `s_sgc_ficha5w1h_aprendizajeo`.`Id` , DATE_FORMAT(`s_sgc_ficha5w1h_aprendizajeo`.`FechaAO`,'%d-%m-%Y') AS Fecha , `s_sgc_ficha5w1h_aprendizajeo`.`Descripcion`, `persona`.`NUsuario`, `rh_tipo_cargo`.`Nbre` FROM  `s_sgc_ficha5w1h_aprendizajeo` INNER JOIN  `rh_tipo_persona_cargon`  ON (`s_sgc_ficha5w1h_aprendizajeo`.`Id_RhPersona` = `rh_tipo_persona_cargon`.`Id`) INNER JOIN  `rh_unidadf_cargo`  ON (`rh_tipo_persona_cargon`.`Id_unidadf_cargo` = `rh_unidadf_cargo`.`Id`) INNER JOIN `persona`  ON (`rh_tipo_persona_cargon`.`Id_Persona` = `persona`.`Id_persona`) INNER JOIN `rh_tipo_cargo`  ON (`rh_unidadf_cargo`.`Id_Cargo` = `rh_tipo_cargo`.`Id`) WHERE (`s_sgc_ficha5w1h_aprendizajeo`.`Estado` =1  AND `s_sgc_ficha5w1h_aprendizajeo`.`Id_Ficha5w1h` ='" + Principal.txtNo.getText() + "') ";
        ResultSet xrs = this.xct.traerRs(this.xsql);
        try {
            if (xrs.next()) {
                xrs.beforeFirst();
                int xfila = 0;
                while (xrs.next()) {
                    this.xmodeloaprendizaje.addRow(this.xdato);
                    this.xmodeloaprendizaje.setValueAt(Long.valueOf(xrs.getLong(1)), xfila, 0);
                    this.xmodeloaprendizaje.setValueAt(xrs.getString(2), xfila, 1);
                    this.xmodeloaprendizaje.setValueAt(xrs.getString(3), xfila, 2);
                    this.xmodeloaprendizaje.setValueAt(xrs.getString(4), xfila, 3);
                    this.xmodeloaprendizaje.setValueAt(xrs.getString(5), xfila, 4);
                    xfila++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFicha5w1H.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:Sgc/JIFFicha5w1H$MiRender.class */
    public class MiRender extends DefaultTableCellRenderer {
        public MiRender() {
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            boolean atendido = Boolean.valueOf(table.getValueAt(row, 13).toString()).booleanValue();
            System.out.println(table.getValueAt(row, 22).toString());
            long xestado = Long.valueOf(table.getValueAt(row, 22).toString()).longValue();
            int xaprendizaje = Integer.valueOf(table.getValueAt(row, 26).toString()).intValue();
            if (atendido) {
                if (xaprendizaje == 0) {
                    cell.setBackground(new Color(255, 102, 0));
                } else if (xaprendizaje == 1) {
                    cell.setBackground(new Color(26, 124, 244));
                } else {
                    cell.setBackground(new Color(133, 218, 160));
                }
            } else if (xestado == 1) {
                cell.setBackground(new Color(251, 54, 54));
            } else if (xestado == 0) {
                cell.setBackground(Color.YELLOW);
            } else if (xestado == 2) {
                cell.setBackground(Color.WHITE);
            }
            return cell;
        }
    }
}
