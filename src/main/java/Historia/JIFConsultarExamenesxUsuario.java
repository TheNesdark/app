package Historia;

import Acceso.Principal;
import General.BuscarPersona;
import General.ClaseImpresionInformes;
import General.Persona;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.genoma.plus.controller.general.JDGenericoPanel;
import com.genoma.plus.controller.laboratorio.ImpresionReporteCitologiaBethesda;
import com.genoma.plus.controller.laboratorio.JDCarguePDFResultadosExternos;
import com.genoma.plus.controller.laboratorio.JDComentarioRecepcion;
import com.genoma.plus.dao.impl.laboratorio.ImpresionReportesDAOImpl;
import com.genoma.plus.dao.impl.laboratorio.LaboratorioDAOImpl;
import com.genoma.plus.dao.laboratorio.LaboratorioDAO;
import com.genoma.plus.jpa.projection.RecepcionProjection;
import com.genoma.plus.jpa.service.RecepcionService;
import com.toedter.calendar.JYearChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.AxisLocation;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:Historia/JIFConsultarExamenesxUsuario.class */
public class JIFConsultarExamenesxUsuario extends JInternalFrame {
    private ConsultasMySQL xct;
    private Metodos xmt;
    public Persona xjppersona;
    private DefaultTableModel xmodelo;
    private DefaultTableModel xmodelo1;
    private DefaultTableModel xmodeloOrden;
    private DefaultTableModel xmodeloRem;
    private DefaultTableModel xmodeloRx;
    private DefaultTableModel xmodelouadio;
    private DefaultTableModel xmodeloespiro;
    private DefaultTableModel xmodelovisio;
    private DefaultTableModel xmodelooma;
    private DefaultTableModel xmodelo_concepto;
    private Object[] dato;
    private String xnombre;
    public String xIdRadiologia;
    public String numeroOrden;
    public String nombreCompletoPDF;
    private String sql;
    private ConsultasMySQL consultas;
    private Metodos xmetodo;
    private String rutaResultadosExternos;
    private LaboratorioDAO xLaboratorioDAO;
    private final RecepcionService recepcionService;
    private List<RecepcionProjection> listaRecepciones;
    private ButtonGroup JBGOpciones;
    private JButton JBTEventoAdverso1;
    private JCheckBox JCHEspecializados;
    private JCheckBox JCH_CConSeguimiento;
    private JCheckBox JCH_CConSeguimiento1;
    private JCheckBox JCH_CConSeguimiento2;
    private JCheckBox JCH_CConSeguimiento3;
    private JCheckBox JCH_SSeguimiento;
    private JPanel JPAudiometria;
    private JPanel JPConceptoA;
    private JPanel JPEspirometria;
    private JPanel JPExamenesOcupacional;
    private JPanel JPIConvenciones;
    private JPanel JPIFDatosUsuario;
    private JPanel JPOma;
    private JPanel JPOrdenesG;
    private JPanel JPRadiologia;
    private JPanel JPRemision;
    private JPanel JPVisiometria;
    private JScrollPane JSPAdiometria;
    private JScrollPane JSPHistorico;
    private JScrollPane JSPHistorico1;
    private JScrollPane JSPHistorico2;
    private JScrollPane JSPHistoricoC;
    private JScrollPane JSPOrdenes;
    private JScrollPane JSPRadiologia;
    private JScrollPane JSPRemision;
    private JScrollPane JSPResultado;
    private JScrollPane JSPResultado1;
    public JTable JTAudiometria;
    public JTable JTBHConcepto;
    private JTable JTBOrdenes;
    private JTable JTBResultado;
    private JTable JTBResultado1;
    public JTable JTEspirometria;
    public JTable JTOMA;
    private JTabbedPane JTPDatos;
    private JTabbedPane JTPSocupacional;
    private JTable JTRadiologia;
    private JTable JTRemision;
    public JTable JTVisiometria;
    private JYearChooser JYAno;
    private JPanel jPanel1;
    private JPanel jPanel2;

    public JIFConsultarExamenesxUsuario(String xnombre) {
        this.xct = new ConsultasMySQL();
        this.xmt = new Metodos();
        this.xIdRadiologia = "0";
        this.numeroOrden = "0";
        this.nombreCompletoPDF = "";
        this.consultas = new ConsultasMySQL();
        this.xmetodo = new Metodos();
        this.recepcionService = (RecepcionService) Principal.contexto.getBean(RecepcionService.class);
        initComponents();
        springStart();
        setName(xnombre);
        mCargasPanelUsuario();
        mCrearTabla();
        this.xnombre = xnombre;
        mIniciarPanel();
    }

    public JIFConsultarExamenesxUsuario(String xnombre, String NHc) {
        this.xct = new ConsultasMySQL();
        this.xmt = new Metodos();
        this.xIdRadiologia = "0";
        this.numeroOrden = "0";
        this.nombreCompletoPDF = "";
        this.consultas = new ConsultasMySQL();
        this.xmetodo = new Metodos();
        this.recepcionService = (RecepcionService) Principal.contexto.getBean(RecepcionService.class);
        initComponents();
        springStart();
        setName(xnombre);
        mCargasPanelUsuario();
        mCrearTabla();
        this.xjppersona.txtHistoria.setText(NHc);
        this.xjppersona.buscar(2);
        this.xnombre = xnombre;
        if (xnombre.equals("jifconsultarexamenesusuario2")) {
            this.JTPDatos.remove(5);
            this.JTPDatos.remove(4);
            this.JTPDatos.remove(3);
            this.JTPDatos.remove(1);
            this.JTPDatos.remove(0);
            mCargarOrdenes();
            return;
        }
        mCargarDatos();
        mIniciarPanel();
    }

    public JIFConsultarExamenesxUsuario(String xnombre, String NHc, String numeroOrden) {
        this.xct = new ConsultasMySQL();
        this.xmt = new Metodos();
        this.xIdRadiologia = "0";
        this.numeroOrden = "0";
        this.nombreCompletoPDF = "";
        this.consultas = new ConsultasMySQL();
        this.xmetodo = new Metodos();
        this.recepcionService = (RecepcionService) Principal.contexto.getBean(RecepcionService.class);
        initComponents();
        springStart();
        setName(xnombre);
        mCargasPanelUsuario();
        mCrearTabla();
        this.xjppersona.txtHistoria.setText(NHc);
        this.xjppersona.buscar(2);
        this.xnombre = xnombre;
        this.numeroOrden = numeroOrden;
        if (xnombre.equals("jifconsultarexamenesusuario2")) {
            this.JTPDatos.remove(5);
            this.JTPDatos.remove(4);
            this.JTPDatos.remove(3);
            this.JTPDatos.remove(1);
            this.JTPDatos.remove(0);
            mCargarOrdenes();
            return;
        }
        mCargarDatos();
        mIniciarPanel();
    }

    private void springStart() {
        this.xLaboratorioDAO = (LaboratorioDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("laboratorioDAOImpl");
    }

    /* JADX WARN: Type inference failed for: r3v100, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v110, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v123, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v135, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v146, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v158, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v170, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v34, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v82, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v88, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGOpciones = new ButtonGroup();
        this.JPIFDatosUsuario = new JPanel();
        this.jPanel1 = new JPanel();
        this.JCHEspecializados = new JCheckBox();
        this.JYAno = new JYearChooser();
        this.JBTEventoAdverso1 = new JButton();
        this.JTPDatos = new JTabbedPane();
        this.jPanel2 = new JPanel();
        this.JSPResultado = new JScrollPane();
        this.JTBResultado = new JTable();
        this.JPIConvenciones = new JPanel();
        this.JCH_SSeguimiento = new JCheckBox();
        this.JCH_CConSeguimiento = new JCheckBox();
        this.JCH_CConSeguimiento1 = new JCheckBox();
        this.JCH_CConSeguimiento2 = new JCheckBox();
        this.JCH_CConSeguimiento3 = new JCheckBox();
        this.JSPResultado1 = new JScrollPane();
        this.JTBResultado1 = new JTable();
        this.JPOrdenesG = new JPanel();
        this.JSPOrdenes = new JScrollPane();
        this.JTBOrdenes = new JTable();
        this.JPRemision = new JPanel();
        this.JSPRemision = new JScrollPane();
        this.JTRemision = new JTable();
        this.JPRadiologia = new JPanel();
        this.JSPRadiologia = new JScrollPane();
        this.JTRadiologia = new JTable();
        this.JPExamenesOcupacional = new JPanel();
        this.JTPSocupacional = new JTabbedPane();
        this.JPAudiometria = new JPanel();
        this.JSPAdiometria = new JScrollPane();
        this.JTAudiometria = new JTable();
        this.JPEspirometria = new JPanel();
        this.JSPHistorico = new JScrollPane();
        this.JTEspirometria = new JTable();
        this.JPVisiometria = new JPanel();
        this.JSPHistorico1 = new JScrollPane();
        this.JTVisiometria = new JTable();
        this.JPOma = new JPanel();
        this.JSPHistorico2 = new JScrollPane();
        this.JTOMA = new JTable();
        this.JPConceptoA = new JPanel();
        this.JSPHistoricoC = new JScrollPane();
        this.JTBHConcepto = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("EXÁMENES DE LABORATORIO POR USUARIO");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMaximumSize(null);
        setMinimumSize(null);
        setName("jifconsultarexamenesusuario");
        setNormalBounds(null);
        addInternalFrameListener(new InternalFrameListener() { // from class: Historia.JIFConsultarExamenesxUsuario.1
            public void internalFrameActivated(InternalFrameEvent evt) {
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIFConsultarExamenesxUsuario.this.formInternalFrameClosing(evt);
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
        this.JPIFDatosUsuario.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN DE USUARIO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        GroupLayout JPIFDatosUsuarioLayout = new GroupLayout(this.JPIFDatosUsuario);
        this.JPIFDatosUsuario.setLayout(JPIFDatosUsuarioLayout);
        JPIFDatosUsuarioLayout.setHorizontalGroup(JPIFDatosUsuarioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 0, 32767));
        JPIFDatosUsuarioLayout.setVerticalGroup(JPIFDatosUsuarioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 168, 32767));
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "FILTRO PARA BÚSQUEDA", 0, 0, new Font("Arial", 1, 14), Color.red));
        this.JCHEspecializados.setFont(new Font("Arial", 1, 12));
        this.JCHEspecializados.setText("Especializados?");
        this.JCHEspecializados.addActionListener(new ActionListener() { // from class: Historia.JIFConsultarExamenesxUsuario.2
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarExamenesxUsuario.this.JCHEspecializadosActionPerformed(evt);
            }
        });
        this.JYAno.setBorder(BorderFactory.createTitledBorder((Border) null, "Año", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JYAno.addPropertyChangeListener(new PropertyChangeListener() { // from class: Historia.JIFConsultarExamenesxUsuario.3
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFConsultarExamenesxUsuario.this.JYAnoPropertyChange(evt);
            }
        });
        this.JBTEventoAdverso1.setFont(new Font("Arial", 1, 12));
        this.JBTEventoAdverso1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Evento Adverso.png")));
        this.JBTEventoAdverso1.setText("<html><P ALIGN=center>Caso de Seguridad del Paciente\n");
        this.JBTEventoAdverso1.setToolTipText("");
        this.JBTEventoAdverso1.addActionListener(new ActionListener() { // from class: Historia.JIFConsultarExamenesxUsuario.4
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarExamenesxUsuario.this.JBTEventoAdverso1ActionPerformed(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.JYAno, -2, 82, -2).addGap(18, 18, 18).addComponent(this.JCHEspecializados).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JBTEventoAdverso1, -2, 265, -2).addGap(46, 46, 46)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JYAno, -1, 57, 32767).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addGap(0, 0, 32767).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHEspecializados, GroupLayout.Alignment.TRAILING).addComponent(this.JBTEventoAdverso1, GroupLayout.Alignment.TRAILING, -2, -1, -2)))).addContainerGap()));
        this.JTPDatos.setForeground(new Color(0, 103, 0));
        this.JTPDatos.setFont(new Font("Arial", 1, 14));
        this.JTBResultado.setFont(new Font("Arial", 1, 12));
        this.JTBResultado.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTBResultado.setAutoResizeMode(4);
        this.JTBResultado.setSelectionBackground(new Color(255, 255, 255));
        this.JTBResultado.setSelectionForeground(new Color(255, 0, 0));
        this.JTBResultado.setSelectionMode(0);
        this.JTBResultado.addMouseListener(new MouseAdapter() { // from class: Historia.JIFConsultarExamenesxUsuario.5
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarExamenesxUsuario.this.JTBResultadoMouseClicked(evt);
            }
        });
        this.JSPResultado.setViewportView(this.JTBResultado);
        this.JPIConvenciones.setBorder(BorderFactory.createTitledBorder((Border) null, "Convenciones", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JCH_SSeguimiento.setBackground(new Color(255, 255, 255));
        this.JCH_SSeguimiento.setFont(new Font("Arial", 1, 12));
        this.JCH_SSeguimiento.setText("Sin recepcionar");
        this.JCH_SSeguimiento.setOpaque(true);
        this.JCH_CConSeguimiento.setBackground(Color.red);
        this.JCH_CConSeguimiento.setFont(new Font("Arial", 1, 12));
        this.JCH_CConSeguimiento.setForeground(new Color(255, 255, 255));
        this.JCH_CConSeguimiento.setText("Recepcionado");
        this.JCH_CConSeguimiento1.setBackground(new Color(255, 255, 0));
        this.JCH_CConSeguimiento1.setFont(new Font("Arial", 1, 12));
        this.JCH_CConSeguimiento1.setText("Con resultado");
        this.JCH_CConSeguimiento1.setOpaque(true);
        this.JCH_CConSeguimiento2.setBackground(new Color(153, 255, 153));
        this.JCH_CConSeguimiento2.setFont(new Font("Arial", 1, 12));
        this.JCH_CConSeguimiento2.setText("Validado");
        this.JCH_CConSeguimiento2.setOpaque(true);
        this.JCH_CConSeguimiento3.setBackground(new Color(255, 204, 204));
        this.JCH_CConSeguimiento3.setFont(new Font("Arial", 1, 12));
        this.JCH_CConSeguimiento3.setText("Entregado");
        this.JCH_CConSeguimiento3.setOpaque(true);
        GroupLayout JPIConvencionesLayout = new GroupLayout(this.JPIConvenciones);
        this.JPIConvenciones.setLayout(JPIConvencionesLayout);
        JPIConvencionesLayout.setHorizontalGroup(JPIConvencionesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIConvencionesLayout.createSequentialGroup().addContainerGap().addComponent(this.JCH_SSeguimiento).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCH_CConSeguimiento).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCH_CConSeguimiento1).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCH_CConSeguimiento2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCH_CConSeguimiento3).addContainerGap(43, 32767)));
        JPIConvencionesLayout.setVerticalGroup(JPIConvencionesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIConvencionesLayout.createSequentialGroup().addGap(0, 0, 32767).addGroup(JPIConvencionesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCH_SSeguimiento).addComponent(this.JCH_CConSeguimiento).addComponent(this.JCH_CConSeguimiento1).addComponent(this.JCH_CConSeguimiento2).addComponent(this.JCH_CConSeguimiento3))));
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.JPIConvenciones, -2, -1, -2).addContainerGap(525, 32767)).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JSPResultado, -2, 1089, -2).addContainerGap(-1, 32767))));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup().addContainerGap(363, 32767).addComponent(this.JPIConvenciones, -2, -1, -2).addContainerGap()).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JSPResultado, -2, 347, -2).addContainerGap(56, 32767))));
        this.JTPDatos.addTab("RESULTADOS", this.jPanel2);
        this.JTBResultado1.setFont(new Font("Arial", 1, 12));
        this.JTBResultado1.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTBResultado1.setAutoResizeMode(4);
        this.JTBResultado1.setSelectionBackground(new Color(255, 255, 255));
        this.JTBResultado1.setSelectionForeground(new Color(255, 0, 0));
        this.JTBResultado1.setSelectionMode(0);
        this.JTBResultado1.addMouseListener(new MouseAdapter() { // from class: Historia.JIFConsultarExamenesxUsuario.6
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarExamenesxUsuario.this.JTBResultado1MouseClicked(evt);
            }
        });
        this.JSPResultado1.setViewportView(this.JTBResultado1);
        this.JTPDatos.addTab("ORDENADO/FACTURADO", this.JSPResultado1);
        this.JTBOrdenes.setFont(new Font("Arial", 1, 12));
        this.JTBOrdenes.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTBOrdenes.setAutoResizeMode(4);
        this.JTBOrdenes.setSelectionBackground(new Color(255, 255, 255));
        this.JTBOrdenes.setSelectionForeground(Color.red);
        this.JTBOrdenes.addMouseListener(new MouseAdapter() { // from class: Historia.JIFConsultarExamenesxUsuario.7
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarExamenesxUsuario.this.JTBOrdenesMouseClicked(evt);
            }
        });
        this.JTBOrdenes.addKeyListener(new KeyAdapter() { // from class: Historia.JIFConsultarExamenesxUsuario.8
            public void keyPressed(KeyEvent evt) {
                JIFConsultarExamenesxUsuario.this.JTBOrdenesKeyPressed(evt);
            }

            public void keyReleased(KeyEvent evt) {
                JIFConsultarExamenesxUsuario.this.JTBOrdenesKeyReleased(evt);
            }
        });
        this.JSPOrdenes.setViewportView(this.JTBOrdenes);
        GroupLayout JPOrdenesGLayout = new GroupLayout(this.JPOrdenesG);
        this.JPOrdenesG.setLayout(JPOrdenesGLayout);
        JPOrdenesGLayout.setHorizontalGroup(JPOrdenesGLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPOrdenesGLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPOrdenes, -2, 1069, -2).addContainerGap(-1, 32767)));
        JPOrdenesGLayout.setVerticalGroup(JPOrdenesGLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPOrdenesGLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPOrdenes, -2, 389, -2).addContainerGap(-1, 32767)));
        this.JTPDatos.addTab("ORDENES GENERADAS", this.JPOrdenesG);
        this.JTRemision.setFont(new Font("Arial", 1, 12));
        this.JTRemision.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTRemision.setSelectionBackground(new Color(255, 255, 255));
        this.JTRemision.setSelectionForeground(new Color(255, 0, 0));
        this.JTRemision.addMouseListener(new MouseAdapter() { // from class: Historia.JIFConsultarExamenesxUsuario.9
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarExamenesxUsuario.this.JTRemisionMouseClicked(evt);
            }
        });
        this.JSPRemision.setViewportView(this.JTRemision);
        GroupLayout JPRemisionLayout = new GroupLayout(this.JPRemision);
        this.JPRemision.setLayout(JPRemisionLayout);
        JPRemisionLayout.setHorizontalGroup(JPRemisionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPRemision, -1, 1101, 32767));
        JPRemisionLayout.setVerticalGroup(JPRemisionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPRemisionLayout.createSequentialGroup().addComponent(this.JSPRemision, -2, -1, -2).addGap(0, 0, 32767)));
        this.JTPDatos.addTab("REMISIÓN", this.JPRemision);
        this.JTRadiologia.setFont(new Font("Arial", 1, 12));
        this.JTRadiologia.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTRadiologia.setAutoResizeMode(4);
        this.JTRadiologia.setSelectionBackground(new Color(255, 255, 255));
        this.JTRadiologia.setSelectionForeground(new Color(255, 0, 0));
        this.JTRadiologia.addMouseListener(new MouseAdapter() { // from class: Historia.JIFConsultarExamenesxUsuario.10
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarExamenesxUsuario.this.JTRadiologiaMouseClicked(evt);
            }
        });
        this.JSPRadiologia.setViewportView(this.JTRadiologia);
        GroupLayout JPRadiologiaLayout = new GroupLayout(this.JPRadiologia);
        this.JPRadiologia.setLayout(JPRadiologiaLayout);
        JPRadiologiaLayout.setHorizontalGroup(JPRadiologiaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPRadiologia, -1, 1101, 32767));
        JPRadiologiaLayout.setVerticalGroup(JPRadiologiaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPRadiologiaLayout.createSequentialGroup().addComponent(this.JSPRadiologia, -2, 391, -2).addGap(0, 20, 32767)));
        this.JTPDatos.addTab("RADIOLOGÍA", this.JPRadiologia);
        this.JTPSocupacional.setForeground(new Color(0, 107, 0));
        this.JTPSocupacional.setFont(new Font("Arial", 1, 12));
        this.JSPAdiometria.setBorder(BorderFactory.createTitledBorder((Border) null, "", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTAudiometria.setFont(new Font("Arial", 1, 12));
        this.JTAudiometria.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTAudiometria.setSelectionBackground(new Color(255, 255, 255));
        this.JTAudiometria.setSelectionForeground(new Color(255, 0, 0));
        this.JTAudiometria.addMouseListener(new MouseAdapter() { // from class: Historia.JIFConsultarExamenesxUsuario.11
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarExamenesxUsuario.this.JTAudiometriaMouseClicked(evt);
            }
        });
        this.JSPAdiometria.setViewportView(this.JTAudiometria);
        GroupLayout JPAudiometriaLayout = new GroupLayout(this.JPAudiometria);
        this.JPAudiometria.setLayout(JPAudiometriaLayout);
        JPAudiometriaLayout.setHorizontalGroup(JPAudiometriaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPAudiometriaLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPAdiometria, -1, 1077, 32767).addContainerGap()));
        JPAudiometriaLayout.setVerticalGroup(JPAudiometriaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPAudiometriaLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPAdiometria, -2, 289, -2).addContainerGap(58, 32767)));
        this.JTPSocupacional.addTab("Audiometría", this.JPAudiometria);
        this.JSPHistorico.setBorder(BorderFactory.createTitledBorder((Border) null, "", 2, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.JTEspirometria.setFont(new Font("Arial", 1, 12));
        this.JTEspirometria.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTEspirometria.setSelectionBackground(new Color(255, 255, 255));
        this.JTEspirometria.setSelectionForeground(new Color(255, 0, 0));
        this.JTEspirometria.setSelectionMode(0);
        this.JTEspirometria.addMouseListener(new MouseAdapter() { // from class: Historia.JIFConsultarExamenesxUsuario.12
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarExamenesxUsuario.this.JTEspirometriaMouseClicked(evt);
            }
        });
        this.JSPHistorico.setViewportView(this.JTEspirometria);
        GroupLayout JPEspirometriaLayout = new GroupLayout(this.JPEspirometria);
        this.JPEspirometria.setLayout(JPEspirometriaLayout);
        JPEspirometriaLayout.setHorizontalGroup(JPEspirometriaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPEspirometriaLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPHistorico, -1, 1077, 32767).addContainerGap()));
        JPEspirometriaLayout.setVerticalGroup(JPEspirometriaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPEspirometriaLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPHistorico, -1, 336, 32767).addContainerGap()));
        this.JTPSocupacional.addTab("Espirometría", this.JPEspirometria);
        this.JSPHistorico1.setBorder(BorderFactory.createTitledBorder((Border) null, "", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTVisiometria.setFont(new Font("Arial", 1, 12));
        this.JTVisiometria.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTVisiometria.setSelectionBackground(new Color(255, 255, 255));
        this.JTVisiometria.setSelectionForeground(new Color(255, 0, 0));
        this.JTVisiometria.addMouseListener(new MouseAdapter() { // from class: Historia.JIFConsultarExamenesxUsuario.13
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarExamenesxUsuario.this.JTVisiometriaMouseClicked(evt);
            }
        });
        this.JSPHistorico1.setViewportView(this.JTVisiometria);
        GroupLayout JPVisiometriaLayout = new GroupLayout(this.JPVisiometria);
        this.JPVisiometria.setLayout(JPVisiometriaLayout);
        JPVisiometriaLayout.setHorizontalGroup(JPVisiometriaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPVisiometriaLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPHistorico1, -1, 1077, 32767).addContainerGap()));
        JPVisiometriaLayout.setVerticalGroup(JPVisiometriaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPVisiometriaLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPHistorico1, -2, 289, -2).addContainerGap(58, 32767)));
        this.JTPSocupacional.addTab("Visiometría", this.JPVisiometria);
        this.JSPHistorico2.setBorder(BorderFactory.createTitledBorder((Border) null, "", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTOMA.setFont(new Font("Arial", 1, 12));
        this.JTOMA.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTOMA.setSelectionBackground(new Color(255, 255, 255));
        this.JTOMA.setSelectionForeground(new Color(255, 0, 0));
        this.JTOMA.addMouseListener(new MouseAdapter() { // from class: Historia.JIFConsultarExamenesxUsuario.14
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarExamenesxUsuario.this.JTOMAMouseClicked(evt);
            }
        });
        this.JSPHistorico2.setViewportView(this.JTOMA);
        GroupLayout JPOmaLayout = new GroupLayout(this.JPOma);
        this.JPOma.setLayout(JPOmaLayout);
        JPOmaLayout.setHorizontalGroup(JPOmaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPOmaLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPHistorico2, -1, 1077, 32767).addContainerGap()));
        JPOmaLayout.setVerticalGroup(JPOmaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPOmaLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPHistorico2, -2, 289, -2).addContainerGap(58, 32767)));
        this.JTPSocupacional.addTab("OMA", this.JPOma);
        this.JSPHistoricoC.setBorder(BorderFactory.createTitledBorder((Border) null, "", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTBHConcepto.setFont(new Font("Arial", 1, 12));
        this.JTBHConcepto.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTBHConcepto.setSelectionBackground(new Color(255, 255, 255));
        this.JTBHConcepto.setSelectionForeground(new Color(255, 0, 0));
        this.JTBHConcepto.addMouseListener(new MouseAdapter() { // from class: Historia.JIFConsultarExamenesxUsuario.15
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarExamenesxUsuario.this.JTBHConceptoMouseClicked(evt);
            }
        });
        this.JSPHistoricoC.setViewportView(this.JTBHConcepto);
        GroupLayout JPConceptoALayout = new GroupLayout(this.JPConceptoA);
        this.JPConceptoA.setLayout(JPConceptoALayout);
        JPConceptoALayout.setHorizontalGroup(JPConceptoALayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPConceptoALayout.createSequentialGroup().addContainerGap().addComponent(this.JSPHistoricoC, -1, 1077, 32767).addContainerGap()));
        JPConceptoALayout.setVerticalGroup(JPConceptoALayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPConceptoALayout.createSequentialGroup().addContainerGap().addComponent(this.JSPHistoricoC, -2, 289, -2).addContainerGap(58, 32767)));
        this.JTPSocupacional.addTab("Concepto", this.JPConceptoA);
        GroupLayout JPExamenesOcupacionalLayout = new GroupLayout(this.JPExamenesOcupacional);
        this.JPExamenesOcupacional.setLayout(JPExamenesOcupacionalLayout);
        JPExamenesOcupacionalLayout.setHorizontalGroup(JPExamenesOcupacionalLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPExamenesOcupacionalLayout.createSequentialGroup().addContainerGap().addComponent(this.JTPSocupacional).addContainerGap()));
        JPExamenesOcupacionalLayout.setVerticalGroup(JPExamenesOcupacionalLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPExamenesOcupacionalLayout.createSequentialGroup().addContainerGap().addComponent(this.JTPSocupacional, -2, 387, -2).addContainerGap(-1, 32767)));
        this.JTPDatos.addTab("EXÁMENES OCUPACIONALES", this.JPExamenesOcupacional);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JPIFDatosUsuario, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.jPanel1, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JTPDatos)).addContainerGap(-1, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIFDatosUsuario, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel1, -2, -1, -2).addGap(18, 18, 18).addComponent(this.JTPDatos, -2, 440, -2).addContainerGap(17, 32767)));
        pack();
    }

    private void txtFechaNacimientoFocusLost(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBResultadoMouseClicked(MouseEvent evt) {
        if (this.JTBResultado.getSelectedRow() != -1 && evt.getClickCount() == 2) {
            int columna = this.JTBResultado.columnAtPoint(evt.getPoint());
            int fila = this.JTBResultado.rowAtPoint(evt.getPoint());
            if (!this.listaRecepciones.isEmpty()) {
                Principal.claselab.mAlertaResultadoPendientes(this.listaRecepciones.get(this.JTBResultado.getSelectedRow()).getIdRecepcion().toString());
            } else {
                Principal.claselab.mAlertaResultadoPendientes(this.xmodelo.getValueAt(this.JTBResultado.getSelectedRow(), 8).toString());
            }
            if (this.JTBResultado.getModel().getColumnClass(columna).equals(JButton.class) && this.JTBResultado.getSelectedRow() == fila) {
                JDCarguePDFResultadosExternos xjd = new JDCarguePDFResultadosExternos(null, true, this.xmodelo.getValueAt(this.JTBResultado.getSelectedRow(), 8).toString());
                xjd.setLocationRelativeTo(this);
                xjd.setVisible(true);
                return;
            }
            if (Principal.informacionIps.getEsFpz().intValue() == 0) {
                if (this.xmodelo.getValueAt(this.JTBResultado.getSelectedRow(), 16) != null && this.xmodelo.getValueAt(this.JTBResultado.getSelectedRow(), 9).toString().equals("1")) {
                    this.xmt.AbrirArchivosblob(this.xmodelo.getValueAt(this.JTBResultado.getSelectedRow(), 16), "soporte", "pdf", true);
                    return;
                }
                Object[] botones = {"Por orden de recepción", "Por tipo resultado", "Nota", "Cerrar"};
                ImpresionReportesDAOImpl impresion = new ImpresionReportesDAOImpl();
                int n = JOptionPane.showInternalOptionDialog(this, "Que desea hacer", "IMPRIMIR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones, "Cerrar");
                switch (n) {
                    case 0:
                        if (this.xmodelo.getValueAt(this.JTBResultado.getSelectedRow(), 9).toString().equals("1")) {
                            this.xmt.mostrarPdf(this.xmodelo.getValueAt(this.JTBResultado.getSelectedRow(), 10).toString());
                        } else if (this.xmodelo.getValueAt(this.JTBResultado.getSelectedRow(), 12).toString() == "true") {
                            String[][] mparametros = new String[4][2];
                            mparametros[0][0] = "id";
                            mparametros[0][1] = this.xmodelo.getValueAt(this.JTBResultado.getSelectedRow(), 8).toString();
                            mparametros[1][0] = "idprocedimiento";
                            mparametros[1][1] = this.xmodelo.getValueAt(this.JTBResultado.getSelectedRow(), 11).toString();
                            mparametros[2][0] = "SUBREPORT_DIR";
                            mparametros[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
                            mparametros[3][0] = "SUBREPORTFIRMA_DIR";
                            mparametros[3][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
                            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "L_Resultados_Id_Proced_Especializado", mparametros);
                        } else {
                            impresion.mImprimirResultado(this.xmodelo.getValueAt(this.JTBResultado.getSelectedRow(), 8).toString(), "", this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra(), this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra(), true, this.xjppersona.IdPersona, true);
                        }
                        break;
                    case 1:
                        if (this.xmodelo.getValueAt(this.JTBResultado.getSelectedRow(), 9).toString().equals("1")) {
                            this.xmt.mostrarPdf(this.xmodelo.getValueAt(this.JTBResultado.getSelectedRow(), 10).toString());
                        } else if (this.xmodelo.getValueAt(this.JTBResultado.getSelectedRow(), 12).toString() == "true") {
                            String[][] mparametros2 = new String[4][2];
                            mparametros2[0][0] = "id";
                            mparametros2[0][1] = this.xmodelo.getValueAt(this.JTBResultado.getSelectedRow(), 8).toString();
                            mparametros2[1][0] = "idprocedimiento";
                            mparametros2[1][1] = this.xmodelo.getValueAt(this.JTBResultado.getSelectedRow(), 11).toString();
                            mparametros2[2][0] = "SUBREPORT_DIR";
                            mparametros2[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
                            mparametros2[3][0] = "SUBREPORTFIRMA_DIR";
                            mparametros2[3][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
                            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "L_Resultados_Id_Proced_Especializado1", mparametros2);
                        } else {
                            impresion.mImprimirResultado(this.xmodelo.getValueAt(this.JTBResultado.getSelectedRow(), 8).toString(), this.xmodelo.getValueAt(this.JTBResultado.getSelectedRow(), 11).toString(), this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra(), this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra(), false, this.xjppersona.IdPersona, true);
                        }
                        break;
                    case 2:
                        JDComentarioRecepcion jdComentario = new JDComentarioRecepcion((Frame) null, true, Long.valueOf(this.xmodelo.getValueAt(this.JTBResultado.getSelectedRow(), 8).toString()), Long.valueOf(this.xmodelo.getValueAt(this.JTBResultado.getSelectedRow(), 11).toString()));
                        jdComentario.setLocationRelativeTo(this);
                        jdComentario.setVisible(true);
                        break;
                }
            }
            mImprimir();
        }
    }

    public void mImprimir() {
        imprimirNuevaForma();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEspecializadosActionPerformed(ActionEvent evt) {
        mCargarDatos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBResultado1MouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBOrdenesKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBOrdenesMouseClicked(MouseEvent evt) {
        if (this.JTBOrdenes.getSelectedRow() != -1 && evt.getClickCount() == 2) {
            imprimirOrden();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTRemisionMouseClicked(MouseEvent evt) {
        if (this.JTRemision.getSelectedRow() != -1 && evt.getClickCount() == 2) {
            imprimirRemision();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTRadiologiaMouseClicked(MouseEvent evt) {
        if (this.JTRadiologia.getSelectedRow() != -1) {
            this.xIdRadiologia = this.xmodeloRx.getValueAt(this.JTRadiologia.getSelectedRow(), 9).toString();
            Object[] botones = {"Imagen", "Lectura", "Cerrar"};
            int n = JOptionPane.showInternalOptionDialog(this, "Que desea visualizar", "IMPRIMIR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones, "Cerrar");
            if (n == 0) {
                mAbrirArchivo();
                return;
            }
            if (n == 1) {
                if (!this.xIdRadiologia.equals("0")) {
                    ClaseImpresionInformes xImpresion = new ClaseImpresionInformes();
                    xImpresion.mImprimirLecturaRadiologia(this.xIdRadiologia);
                } else {
                    this.xmt.mostrarPdf(this.xmodelo.getValueAt(this.JTRadiologia.getSelectedRow(), 7).toString());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JYAnoPropertyChange(PropertyChangeEvent evt) {
        if (!this.xjppersona.getIdPersona().equals("0")) {
            mCargarRx();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTAudiometriaMouseClicked(MouseEvent evt) {
        if (this.JTAudiometria.getSelectedRow() != -1 && evt.getClickCount() == 2) {
            mGenerarGrafico();
            mImprimirAudiometria(this.xmodelouadio.getValueAt(this.JTAudiometria.getSelectedRow(), 0).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTEspirometriaMouseClicked(MouseEvent evt) {
        if (this.JTEspirometria.getSelectedRow() != -1) {
            mImprimirEspiro();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTVisiometriaMouseClicked(MouseEvent evt) {
        if (this.JTVisiometria.getSelectedRow() != -1 && evt.getClickCount() == 2) {
            mImprimirVisio();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTOMAMouseClicked(MouseEvent evt) {
        if (this.JTOMA.getSelectedRow() != -1 && evt.getClickCount() == 2) {
            mImprimirOMA();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBHConceptoMouseClicked(MouseEvent evt) {
        if (this.JTBHConcepto.getSelectedRow() != -1 && evt.getClickCount() == 2) {
            if (this.xmodelo_concepto.getValueAt(this.JTBHConcepto.getSelectedRow(), 4).toString().equals("")) {
                ImpresionDocumentosHC xImprimir = new ImpresionDocumentosHC();
                if (this.xmodelo_concepto.getValueAt(this.JTBHConcepto.getSelectedRow(), 2).toString().equals("EXAMEN DE EGRESO")) {
                    xImprimir.mImprimirConceptoSoEgreso(this.xmodelo_concepto.getValueAt(this.JTBHConcepto.getSelectedRow(), 0).toString());
                    return;
                } else {
                    xImprimir.mImpirmirConceptoSoIngreso(this.xmodelo_concepto.getValueAt(this.JTBHConcepto.getSelectedRow(), 0).toString());
                    return;
                }
            }
            this.xmt.mostrarPdf(this.xmodelo_concepto.getValueAt(this.JTBHConcepto.getSelectedRow(), 4).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTEventoAdverso1ActionPerformed(ActionEvent evt) {
        if (this.JTBResultado.getSelectedRow() != -1) {
            JDGenericoPanel detalle = new JDGenericoPanel(null, true, "Evento Adverso", this.JTBResultado.getValueAt(this.JTBResultado.getSelectedRow(), 15).toString(), 14);
            detalle.setLocationRelativeTo(this);
            detalle.setVisible(true);
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un resultado", "Verificar", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBOrdenesKeyReleased(KeyEvent evt) {
        System.out.println("" + evt.getKeyCode());
        if (evt.getKeyCode() == 10 && this.JTBOrdenes.getSelectedColumn() == 2) {
            String fecha = this.JTBOrdenes.getValueAt(this.JTBOrdenes.getSelectedRow(), 2).toString();
            String idOrden = this.JTBOrdenes.getValueAt(this.JTBOrdenes.getSelectedRow(), 0).toString();
            this.sql = "update h_ordenes set FechaOrden='" + fecha + "' where Id='" + Integer.valueOf(idOrden) + "'";
            this.consultas.ejecutarSQL(this.sql);
            JOptionPane.showMessageDialog((Component) null, "Fecha De Orden Actualizada");
            mCargarOrdenes();
            this.consultas.cerrarConexionBd();
        }
    }

    private String obtenerCodigosSeleccionados(JTable tabla, List<RecepcionProjection> listaRecepciones) {
        StringJoiner xcodigopro = new StringJoiner(",");
        for (int i = 0; i < tabla.getRowCount(); i++) {
            Object value = tabla.getValueAt(i, 0);
            if ((value instanceof Boolean) && ((Boolean) value).booleanValue()) {
                xcodigopro.add(listaRecepciones.get(i).getIdProcedimiento().toString());
            }
        }
        return xcodigopro.toString();
    }

    private void imprimirNuevaForma() {
        if (this.listaRecepciones.get(this.JTBResultado.getSelectedRow()).getArchivoExterno().intValue() == 1) {
            System.out.println("Entroo aca");
            Object[] botones = {"Visualizar", "Nota", "Cerrar"};
            int n = JOptionPane.showInternalOptionDialog(this, "Que desea hacer", "IMPRIMIR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones, "Cerrar");
            switch (n) {
                case 0:
                    this.xmt.mostrarPdf(this.rutaResultadosExternos + this.listaRecepciones.get(this.JTBResultado.getSelectedRow()).getUrlArchivo());
                    break;
                case 1:
                    if (this.xmt.mVerificarDatosTablaTrue(this.JTBResultado, 0)) {
                        List<Long> listaCodigos = (List) Arrays.stream(obtenerCodigosSeleccionados(this.JTBResultado, this.listaRecepciones).split(",")).map(Long::parseLong).collect(Collectors.toList());
                        JDComentarioRecepcion jdComentario = new JDComentarioRecepcion((Frame) null, true, this.listaRecepciones.get(this.JTBResultado.getSelectedRow()).getIdRecepcion(), listaCodigos);
                        jdComentario.setLocationRelativeTo(this);
                        jdComentario.setVisible(true);
                    }
                    break;
            }
        }
        Object[] botones2 = {"Normal", "Por Procedimiento", "Nota", "Cerrar"};
        int n2 = JOptionPane.showInternalOptionDialog(this, "Que desea hacer", "IMPRIMIR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones2, "Cerrar");
        ImpresionReportesDAOImpl impresion = new ImpresionReportesDAOImpl();
        switch (n2) {
            case 0:
                if (this.listaRecepciones.get(this.JTBResultado.getSelectedRow()).getEsCitologia()) {
                    ImpresionReporteCitologiaBethesda bethesda = new ImpresionReporteCitologiaBethesda();
                    bethesda.generarReporte(this.listaRecepciones.get(this.JTBResultado.getSelectedRow()).getIdRecepcionCitologia(), 1);
                } else {
                    impresion.mImprimirResultado(this.listaRecepciones.get(this.JTBResultado.getSelectedRow()).getIdRecepcion().toString(), "", this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra(), this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra(), true, this.xjppersona.IdPersona, true);
                }
                break;
            case 1:
                if (this.listaRecepciones.get(this.JTBResultado.getSelectedRow()).getEsCitologia()) {
                    ImpresionReporteCitologiaBethesda bethesda2 = new ImpresionReporteCitologiaBethesda();
                    bethesda2.generarReporte(this.listaRecepciones.get(this.JTBResultado.getSelectedRow()).getIdRecepcionCitologia(), 1);
                } else if (this.xmt.mVerificarDatosTablaTrue(this.JTBResultado, 0)) {
                    String xcodigopro = obtenerCodigosSeleccionados(this.JTBResultado, this.listaRecepciones);
                    System.out.println(" codigo" + xcodigopro);
                    int selectedRow = this.JTBResultado.getSelectedRow();
                    if (selectedRow >= 0) {
                        impresion.mImprimirResultado(this.listaRecepciones.get(selectedRow).getIdRecepcion().toString(), xcodigopro.toString(), this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra(), this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra(), true, this.xjppersona.IdPersona, true);
                    }
                }
                break;
            case 2:
                if (this.xmt.mVerificarDatosTablaTrue(this.JTBResultado, 0)) {
                    List<Long> listaCodigos2 = (List) Arrays.stream(obtenerCodigosSeleccionados(this.JTBResultado, this.listaRecepciones).split(",")).map(Long::parseLong).collect(Collectors.toList());
                    JDComentarioRecepcion jdComentario2 = new JDComentarioRecepcion((Frame) null, true, this.listaRecepciones.get(this.JTBResultado.getSelectedRow()).getIdRecepcion(), listaCodigos2);
                    jdComentario2.setLocationRelativeTo(this);
                    jdComentario2.setVisible(true);
                }
                break;
        }
    }

    public void mGenerarGrafico() {
        try {
            XYDataset xydataset = xyDataset();
            XYDataset xydataseti = xyDatasetI();
            JFreeChart jfreechart = ChartFactory.createXYLineChart("Oido Derecho", "", "Resultado", xydataset, PlotOrientation.VERTICAL, true, true, false);
            JFreeChart jfreecharti = ChartFactory.createXYLineChart("Oido Izquierdo", "", "Resultado", xydataseti, PlotOrientation.VERTICAL, true, true, false);
            XYPlot xyplot = jfreechart.getPlot();
            xyplot.setBackgroundPaint(Color.lightGray);
            xyplot.setDomainGridlinePaint(Color.BLACK);
            xyplot.setRangeGridlinePaint(Color.BLACK);
            xyplot.getRenderer().setSeriesPaint(0, Color.RED);
            xyplot.getDomainAxisLocation();
            xyplot.setDomainAxisLocation(AxisLocation.TOP_OR_LEFT);
            NumberAxis rangeAxis = xyplot.getRangeAxis();
            rangeAxis.setInverted(true);
            xyplot.getRangeAxis().setRange(0.0d, 125.0d);
            XYLineAndShapeRenderer xylineandshaperenderer = xyplot.getRenderer();
            xylineandshaperenderer.setBaseShapesVisible(true);
            ChartUtilities.saveChartAsJPEG(new File(this.xmt.getRutaRep() + "OidoDer.jpg"), jfreechart, 450, 260);
            XYPlot xyploti = jfreecharti.getPlot();
            xyploti.setBackgroundPaint(Color.lightGray);
            xyploti.setDomainGridlinePaint(Color.BLACK);
            xyploti.setRangeGridlinePaint(Color.BLACK);
            xyploti.getRenderer().setSeriesPaint(0, Color.BLUE);
            xyploti.setDomainAxisLocation(AxisLocation.TOP_OR_LEFT);
            NumberAxis rangeAxisY = xyploti.getRangeAxis();
            rangeAxisY.setInverted(true);
            xyploti.getRangeAxis().setRange(0.0d, 125.0d);
            XYLineAndShapeRenderer xylineandshaperendereri = xyploti.getRenderer();
            xylineandshaperendereri.setBaseShapesVisible(true);
            ChartUtilities.saveChartAsJPEG(new File(this.xmt.getRutaRep() + "OidoIzq.jpg"), jfreecharti, 450, 260);
        } catch (IOException ex) {
            Logger.getLogger(JPSo_Audiometria.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private XYDataset xyDataset() {
        XYSeriesCollection xyseriescollection = new XYSeriesCollection();
        XYSeries series1 = new XYSeries("Oido Derecho");
        series1.add(500.0d, Integer.parseInt(this.xmodelouadio.getValueAt(this.JTAudiometria.getSelectedRow(), 2).toString()));
        series1.add(1000.0d, Integer.parseInt(this.xmodelouadio.getValueAt(this.JTAudiometria.getSelectedRow(), 3).toString()));
        series1.add(2000.0d, Integer.parseInt(this.xmodelouadio.getValueAt(this.JTAudiometria.getSelectedRow(), 4).toString()));
        series1.add(3000.0d, Integer.parseInt(this.xmodelouadio.getValueAt(this.JTAudiometria.getSelectedRow(), 5).toString()));
        series1.add(4000.0d, Integer.parseInt(this.xmodelouadio.getValueAt(this.JTAudiometria.getSelectedRow(), 6).toString()));
        series1.add(6000.0d, Integer.parseInt(this.xmodelouadio.getValueAt(this.JTAudiometria.getSelectedRow(), 7).toString()));
        series1.add(8000.0d, Integer.parseInt(this.xmodelouadio.getValueAt(this.JTAudiometria.getSelectedRow(), 8).toString()));
        xyseriescollection.addSeries(series1);
        return xyseriescollection;
    }

    private XYDataset xyDatasetI() {
        XYSeriesCollection xyseriescollection = new XYSeriesCollection();
        XYSeries series1 = new XYSeries("Oido Izquierdo");
        series1.add(500.0d, Integer.parseInt(this.xmodelouadio.getValueAt(this.JTAudiometria.getSelectedRow(), 9).toString()));
        series1.add(1000.0d, Integer.parseInt(this.xmodelouadio.getValueAt(this.JTAudiometria.getSelectedRow(), 10).toString()));
        series1.add(2000.0d, Integer.parseInt(this.xmodelouadio.getValueAt(this.JTAudiometria.getSelectedRow(), 11).toString()));
        series1.add(3000.0d, Integer.parseInt(this.xmodelouadio.getValueAt(this.JTAudiometria.getSelectedRow(), 12).toString()));
        series1.add(4000.0d, Integer.parseInt(this.xmodelouadio.getValueAt(this.JTAudiometria.getSelectedRow(), 13).toString()));
        series1.add(6000.0d, Integer.parseInt(this.xmodelouadio.getValueAt(this.JTAudiometria.getSelectedRow(), 14).toString()));
        series1.add(8000.0d, Integer.parseInt(this.xmodelouadio.getValueAt(this.JTAudiometria.getSelectedRow(), 15).toString()));
        xyseriescollection.addSeries(series1);
        return xyseriescollection;
    }

    public void mImprimirAudiometria(String idAtencion) {
        String[][] mparametros = new String[3][2];
        if (idAtencion.equals("0")) {
            mparametros[0][0] = "ID_AUDIOMETRIA";
            mparametros[0][1] = this.xmodelouadio.getValueAt(this.JTAudiometria.getSelectedRow(), 16).toString();
            mparametros[1][0] = "SUBREPORT_DIR";
            mparametros[1][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
            mparametros[2][0] = "SUBREPORTFIRMA_DIR";
            mparametros[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
            if (Principal.informacionIps.getEsFpz().intValue() == 0) {
                this.xmt.GenerarPDF(this.xmt.getRutaRep() + "SO2_HistoriaClinica_Audiometria", mparametros);
                return;
            } else {
                this.xmt.GenerarPDF(this.xmt.getRutaRep() + "SO2_HistoriaClinica_Audiometria1", mparametros);
                return;
            }
        }
        mparametros[0][0] = "idatencion1";
        mparametros[0][1] = idAtencion;
        mparametros[1][0] = "SUBREPORT_DIR";
        mparametros[1][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
        mparametros[2][0] = "SUBREPORTFIRMA_DIR";
        mparametros[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
        if (Principal.informacionIps.getEsFpz().intValue() == 0) {
            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "SO_HistoriaClinica_Audiometria", mparametros);
        } else {
            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "SO_HistoriaClinica_Audiometria1", mparametros);
        }
    }

    private void mAbrirArchivo() {
        try {
            Runtime.getRuntime().exec("C:\\Genoma\\Visor\\mDicom.exe  " + this.xmt.mTraerUrlBD(this.xmodeloRx.getValueAt(this.JTRadiologia.getSelectedRow(), 6).toString()));
        } catch (IOException ex) {
            Logger.getLogger(JIFConsultarExamenesxUsuario.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargasPanelUsuario() {
        this.rutaResultadosExternos = this.xmt.mRutaSoporte("JDCarguePDFResultadosExternos");
        this.xjppersona = new Persona(this);
        this.xjppersona.setVisible(true);
        this.JPIFDatosUsuario.setVisible(false);
        this.xjppersona.setBounds(5, 15, 950, 160);
        this.JPIFDatosUsuario.add(this.xjppersona);
        this.JPIFDatosUsuario.setVisible(true);
    }

    public void mNuevo() {
        this.xjppersona.nuevo();
        mCrearTabla();
        mCrearTabla1();
        mCrearModeloOrdenes();
        mCrearModeloRemision();
        mCrearTablaRx();
        mCrearModeloAudiometria();
        mCrearModeloEspiro();
        this.xjppersona.txtHistoria.requestFocus();
        this.nombreCompletoPDF = "";
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTabla() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"FechaRec", "FechaRes", "Especialidad", "Profesional", "Exámen", "Alterado?", "Revisado?", "", "IdRecep", "", "", "Idprocedimiento", "Remitido", "Imprimir?", "No. Orden", "Ingreso", "Archivo Externo", "Cargar PDF", "ValidacionAdmin"}) { // from class: Historia.JIFConsultarExamenesxUsuario.16
            Class[] types = {String.class, String.class, String.class, String.class, String.class, Boolean.class, Boolean.class, Long.class, Long.class, Integer.class, String.class, Long.class, Boolean.class, Boolean.class, Integer.class, String.class, String.class, JButton.class, Integer.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBResultado.setDefaultRenderer(JButton.class, new TableCellRenderer() { // from class: Historia.JIFConsultarExamenesxUsuario.17
            public Component getTableCellRendererComponent(JTable jtable, Object objeto, boolean estaSeleccionado, boolean tieneElFoco, int fila, int columna) {
                return (Component) objeto;
            }
        });
        this.JTBResultado.setModel(this.xmodelo);
        this.JTBResultado.getColumnModel().getColumn(0).setPreferredWidth(40);
        this.JTBResultado.getColumnModel().getColumn(1).setPreferredWidth(40);
        this.JTBResultado.getColumnModel().getColumn(2).setPreferredWidth(60);
        this.JTBResultado.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTBResultado.getColumnModel().getColumn(4).setPreferredWidth(200);
        this.JTBResultado.getColumnModel().getColumn(5).setPreferredWidth(20);
        this.JTBResultado.getColumnModel().getColumn(6).setPreferredWidth(20);
        this.JTBResultado.getColumnModel().getColumn(7).setPreferredWidth(0);
        this.JTBResultado.getColumnModel().getColumn(7).setMinWidth(0);
        this.JTBResultado.getColumnModel().getColumn(7).setMaxWidth(0);
        this.JTBResultado.getColumnModel().getColumn(8).setPreferredWidth(0);
        this.JTBResultado.getColumnModel().getColumn(9).setPreferredWidth(0);
        this.JTBResultado.getColumnModel().getColumn(9).setMinWidth(0);
        this.JTBResultado.getColumnModel().getColumn(9).setMaxWidth(0);
        this.JTBResultado.getColumnModel().getColumn(10).setPreferredWidth(0);
        this.JTBResultado.getColumnModel().getColumn(10).setMinWidth(0);
        this.JTBResultado.getColumnModel().getColumn(10).setMaxWidth(0);
        this.JTBResultado.getColumnModel().getColumn(11).setPreferredWidth(0);
        this.JTBResultado.getColumnModel().getColumn(12).setPreferredWidth(0);
        this.JTBResultado.getColumnModel().getColumn(12).setMinWidth(0);
        this.JTBResultado.getColumnModel().getColumn(12).setMaxWidth(0);
        this.JTBResultado.getColumnModel().getColumn(13).setPreferredWidth(10);
        this.JTBResultado.getColumnModel().getColumn(14).setPreferredWidth(10);
        this.JTBResultado.getColumnModel().getColumn(15).setPreferredWidth(0);
        this.JTBResultado.getColumnModel().getColumn(15).setMinWidth(0);
        this.JTBResultado.getColumnModel().getColumn(15).setMaxWidth(0);
        this.JTBResultado.getColumnModel().getColumn(16).setPreferredWidth(0);
        this.JTBResultado.getColumnModel().getColumn(16).setMinWidth(0);
        this.JTBResultado.getColumnModel().getColumn(16).setMaxWidth(0);
        this.JTBResultado.getColumnModel().getColumn(17).setPreferredWidth(50);
        this.JTBResultado.getColumnModel().getColumn(17).setMinWidth(0);
        this.JTBResultado.getColumnModel().getColumn(17).setMaxWidth(0);
        this.JTBResultado.getColumnModel().getColumn(18).setPreferredWidth(20);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTabla1() {
        this.xmodelo1 = new DefaultTableModel(new Object[0], new String[]{"Fecha", "Especialidad", "Profesional", "Exámen", "Remitido?", "Oportunidad?", "Realizado"}) { // from class: Historia.JIFConsultarExamenesxUsuario.18
            Class[] types = {String.class, String.class, String.class, String.class, Boolean.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBResultado1.setModel(this.xmodelo1);
        this.JTBResultado1.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTBResultado1.getColumnModel().getColumn(1).setPreferredWidth(30);
        this.JTBResultado1.getColumnModel().getColumn(2).setPreferredWidth(50);
        this.JTBResultado1.getColumnModel().getColumn(3).setPreferredWidth(300);
        this.JTBResultado1.getColumnModel().getColumn(4).setPreferredWidth(10);
        this.JTBResultado1.getColumnModel().getColumn(5).setPreferredWidth(20);
        this.JTBResultado1.getColumnModel().getColumn(6).setPreferredWidth(10);
    }

    public void mBuscar() {
        String[][] strArr = new String[2][2];
        Object[] botones = {"Usuario", "Resultado de Exámenes", "Cerrar"};
        int n = JOptionPane.showInternalOptionDialog(this, "Que desea hacer", "BUSCAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones, "Cerrar");
        if (n == 0) {
            BuscarPersona frmBuscar = new BuscarPersona(null, true, this.xjppersona);
            frmBuscar.setVisible(true);
            return;
        }
        if (n == 1 && !this.xjppersona.getIdPersona().equals("")) {
            mCargarDatos();
            mCargarDatos1();
            mCargarOrdenes();
            mCargarRemisiones();
            mCargarRx();
            mCargarDatosTablaAudiometria();
            mCargarDatoEspirometria();
            mCargarDatosVisio();
            mCargarDatosOMA();
            mCargarDatos_Concepto();
        }
    }

    public void mCargarDatos() {
        if (Principal.informacionIps.getEsFpz().intValue() == 1) {
            llenarTablaRecepcion();
        } else {
            mCargarDatosFpz();
        }
    }

    private void llenarTablaRecepcion() {
        this.listaRecepciones = new ArrayList();
        this.listaRecepciones = this.recepcionService.getLisInfoRecepcionUsuario(Long.valueOf(this.xjppersona.getIdPersona()));
        this.xmodelo.setRowCount(0);
        mCrearTablaNUeva();
        for (RecepcionProjection recepcion : this.listaRecepciones) {
            System.out.println("resultado" + recepcion.getArchivoExterno());
            DefaultTableModel defaultTableModel = this.xmodelo;
            Object[] objArr = new Object[11];
            objArr[0] = false;
            objArr[1] = recepcion.getNumeroRecepcion();
            objArr[2] = recepcion.getFechaRecepcion();
            objArr[3] = recepcion.getProcedimiento();
            objArr[4] = recepcion.getConvenio();
            objArr[5] = recepcion.getNombreSede();
            objArr[6] = recepcion.getFechaResultado();
            objArr[7] = recepcion.getFechaValidado();
            objArr[8] = recepcion.getSubEmpresa();
            objArr[9] = recepcion.getIsEntregado();
            objArr[10] = Boolean.valueOf(recepcion.getArchivoExterno() != null && recepcion.getArchivoExterno().intValue() == 1);
            defaultTableModel.addRow(objArr);
            this.JTBResultado.setDefaultRenderer(Object.class, new MiRender3());
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    public void mCrearTablaNUeva() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Seleccionar", "Número Recepción", "Número Recepción", "Fecha Recepción", "Procedimiento", "Convenio", "Nombre Sede", "Fecha Resultado", "Fecha Validado", "Sub Empresa", "Entregado", "ResultadoExterno?"}) { // from class: Historia.JIFConsultarExamenesxUsuario.19
            Class[] types = {Boolean.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Integer.class, Boolean.class};
            boolean[] canEdit = {true, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBResultado.setDefaultRenderer(JButton.class, new TableCellRenderer() { // from class: Historia.JIFConsultarExamenesxUsuario.20
            public Component getTableCellRendererComponent(JTable jtable, Object objeto, boolean estaSeleccionado, boolean tieneElFoco, int fila, int columna) {
                return (Component) objeto;
            }
        });
        this.JTBResultado.setModel(this.xmodelo);
        this.JTBResultado.setAutoResizeMode(0);
        this.JTBResultado.doLayout();
        configurarColumnas();
    }

    private void configurarColumnas() {
        int[] anchos = {100, 100, 100, 600, 400, 300, 100, 100, 200, 0, 100};
        for (int i = 0; i < anchos.length; i++) {
            this.JTBResultado.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
            if (anchos[i] == 0) {
                this.JTBResultado.getColumnModel().getColumn(i).setMinWidth(0);
                this.JTBResultado.getColumnModel().getColumn(i).setMaxWidth(0);
            }
        }
    }

    public void mCargarDatosFpz() {
        String sql;
        try {
            if (this.JCHEspecializados.isSelected()) {
                sql = "SELECT DATE_FORMAT(FechaRecep,'%d-%m-%Y') AS FechaRP, DATE_FORMAT(l_detallerecepcion.FechaResultado,'%d-%m-%Y') AS FechaRs, profesional1.Especialidad, profesional1.NProfesional , g_procedimiento.Nbre, l_detallerecepcion.`Alterado` as Alterado,  IF(l_detallerecepcion.Id_Atencion<>0,1,0)AS Revisado, 0, l_recepcion.Id, 1,  l_detallerecepcion.NArchivo, l_detallerecepcion.Id_Procedim, g_procedimiento.EsRemitido,l_recepcion.`Id`, `f_ordenes`.`Id_Ingreso`, l_detallerecepcion.ArchivoResultadoExterno FROM l_detallerecepcion  INNER JOIN l_recepcion  ON (l_detallerecepcion.Id_Recepcion = l_recepcion.Id)  INNER JOIN profesional1  ON (profesional1.IdEspecialidad = l_recepcion.Id_Especialidad)  AND (profesional1.Id_Persona = l_recepcion.Id_Profesional)   INNER JOIN g_procedimiento  ON (l_detallerecepcion.Id_Procedim = g_procedimiento.Id) INNER JOIN `f_ordenes` ON (`l_recepcion`.`Id_OrdenFacturac` = f_ordenes.Id) WHERE (l_recepcion.Id_Paciente ='" + this.xjppersona.getIdPersona() + "' AND l_detallerecepcion.validadolab=1 AND (l_detallerecepcion.NArchivo <> '' OR l_detallerecepcion.ArchivoResultadoExterno IS NOT NULL))   GROUP BY l_recepcion.Id, g_procedimiento.Nbre ORDER BY FechaRecep DESC, l_detallerecepcion.FechaResultado DESC, l_recepcion.Id ASC ";
                System.out.println("primeria consulta<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<" + sql);
            } else {
                sql = "SELECT\n  DATE_FORMAT(FechaRecep, '%d-%m-%Y') AS FechaRP,\n  DATE_FORMAT(FechaResult, '%d-%m-%Y') AS FechaRs,\n  profesional1.Especialidad,\n  profesional1.NProfesional,\n  g_procedimiento.Nbre,\n  MAX(l_detalleresultado.`Alterado`) AS Alterado,\n  IF(l_detallerecepcion.Id_Atencion <> 0, 1, 0) AS Revisado,\n  l_resultados.Id,\n  l_recepcion.Id,\n  IF(l_detallerecepcion.NArchivo <> '', 1, 0) AS Sp,\n  l_detallerecepcion.NArchivo,\n  l_detallerecepcion.Id_Procedim,\n  g_procedimiento.EsRemitido,\n  l_recepcion.`Id`,\n  `f_ordenes`.`Id_Ingreso`,\n  NULL AS ArchivoResultadoExterno,\n  `l_detallerecepcion`.`validacionAdmin`\nFROM\n  l_detallerecepcion\nINNER JOIN baseserver.l_recepcion\n  ON l_detallerecepcion.Id_Recepcion = l_recepcion.Id\nINNER JOIN baseserver.profesional1\n  ON profesional1.IdEspecialidad = l_recepcion.Id_Especialidad\n  AND profesional1.Id_Persona = l_recepcion.Id_Profesional\nINNER JOIN l_resultados\n  ON l_resultados.Id_Recepcion = l_recepcion.Id\nINNER JOIN baseserver.l_detalleresultado\n  ON l_detalleresultado.Id_Resultado = l_resultados.Id\nINNER JOIN baseserver.g_procedimiento\n  ON l_detallerecepcion.Id_Procedim = g_procedimiento.Id\nINNER JOIN l_protocoloxprocedimiento\n  ON l_protocoloxprocedimiento.Id_Procedim = g_procedimiento.Id\n  AND l_detalleresultado.Id_ProtocolProcedim = l_protocoloxprocedimiento.Id\nINNER JOIN `f_ordenes`\n  ON `l_recepcion`.`Id_OrdenFacturac` = f_ordenes.Id\nWHERE\n  l_recepcion.Id_Paciente = '" + this.xjppersona.getIdPersona() + "'\n  AND l_detallerecepcion.validadolab = 1\nGROUP BY\n  l_recepcion.Id,\n  g_procedimiento.Nbre\nORDER BY\n  FechaResult DESC,\n  l_recepcion.Id ASC;";
                System.out.println("segunda consulta sin seleccionar  ----------------------------" + sql);
            }
            ResultSet rs = this.xct.traerRs(sql);
            Throwable th = null;
            try {
                if (rs.next()) {
                    rs.beforeFirst();
                    int filaGrid = 0;
                    mCrearTabla();
                    while (rs.next()) {
                        this.xmodelo.addRow(this.dato);
                        this.xmodelo.setValueAt(rs.getString(1), filaGrid, 0);
                        this.xmodelo.setValueAt(rs.getString(2), filaGrid, 1);
                        this.xmodelo.setValueAt(rs.getString(3), filaGrid, 2);
                        this.xmodelo.setValueAt(rs.getString(4), filaGrid, 3);
                        this.xmodelo.setValueAt(rs.getString(5), filaGrid, 4);
                        this.xmodelo.setValueAt(Boolean.valueOf(rs.getBoolean(6)), filaGrid, 5);
                        this.xmodelo.setValueAt(Boolean.valueOf(rs.getBoolean(7)), filaGrid, 6);
                        this.xmodelo.setValueAt(Long.valueOf(rs.getLong(8)), filaGrid, 7);
                        this.xmodelo.setValueAt(Long.valueOf(rs.getLong(9)), filaGrid, 8);
                        this.JTBResultado.setDefaultRenderer(Object.class, new MiRender());
                        this.xmodelo.setValueAt(Integer.valueOf(rs.getInt(10)), filaGrid, 9);
                        this.xmodelo.setValueAt(rs.getString(11), filaGrid, 10);
                        this.xmodelo.setValueAt(Long.valueOf(rs.getLong(12)), filaGrid, 11);
                        this.xmodelo.setValueAt(Boolean.valueOf(rs.getBoolean(13)), filaGrid, 12);
                        this.xmodelo.setValueAt(false, filaGrid, 13);
                        this.xmodelo.setValueAt(Integer.valueOf(rs.getInt(14)), filaGrid, 14);
                        this.xmodelo.setValueAt(rs.getString(15), filaGrid, 15);
                        this.xmodelo.setValueAt(rs.getString("ArchivoResultadoExterno"), filaGrid, 16);
                        this.xmodelo.setValueAt(new JButton("Cargar"), filaGrid, 17);
                        filaGrid++;
                    }
                }
                if (rs != null) {
                    if (0 != 0) {
                        try {
                            rs.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    } else {
                        rs.close();
                    }
                }
                this.xct.cerrarConexionBd();
            } finally {
            }
        } catch (Exception ex) {
            Logger.getLogger(JIFConsultarResultadoExamenes.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mCargarDatos1() {
        try {
            String sql = "SELECT DATE_FORMAT(`f_ordenes`.`FechaOrden`,'%d-%m-%Y') AS Fecha , `profesional1`.`Especialidad` , `profesional1`.`NProfesional`, `g_procedimiento`.`Nbre`, `g_procedimiento`.`EsRemitido`, `g_procedimiento`.`Oportunidad`, `f_ordenes`.EstadoRecep FROM  `f_ordenes` INNER JOIN  `ingreso`  ON (`f_ordenes`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN  `f_itemordenesproced`  ON (`f_itemordenesproced`.`Id_Ordenes` = `f_ordenes`.`Id`) INNER JOIN  `g_procedimiento`  ON (`f_itemordenesproced`.`Id_Procedimiento` = `g_procedimiento`.`Id`) INNER JOIN  `profesional1`  ON (`profesional1`.`Id_Persona` = `f_ordenes`.`Id_Profesional`) AND (`profesional1`.`IdEspecialidad` = `f_ordenes`.`Id_Especialidad`) WHERE (`f_ordenes`.`Id_TipoServicio` =2 AND `ingreso`.`Id_Usuario` ='" + this.xjppersona.getIdPersona() + "' AND `f_ordenes`.`Estado` =0) ORDER BY `f_ordenes`.`FechaOrden` DESC, `g_procedimiento`.`Nbre` ASC ";
            ResultSet rs = this.xct.traerRs(sql);
            if (rs.next()) {
                rs.beforeFirst();
                int filaGrid = 0;
                mCrearTabla1();
                while (rs.next()) {
                    this.xmodelo1.addRow(this.dato);
                    this.xmodelo1.setValueAt(rs.getString(1), filaGrid, 0);
                    this.xmodelo1.setValueAt(rs.getString(2), filaGrid, 1);
                    this.xmodelo1.setValueAt(rs.getString(3), filaGrid, 2);
                    this.xmodelo1.setValueAt(rs.getString(4), filaGrid, 3);
                    this.xmodelo1.setValueAt(Boolean.valueOf(rs.getBoolean(5)), filaGrid, 4);
                    this.xmodelo1.setValueAt(rs.getString(6), filaGrid, 5);
                    this.xmodelo1.setValueAt(rs.getString(7), filaGrid, 6);
                    this.JTBResultado1.setDefaultRenderer(Object.class, new MiRender1());
                    filaGrid++;
                }
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (Exception ex) {
            Logger.getLogger(JIFConsultarResultadoExamenes.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloOrdenes() {
        this.xmodeloOrden = new DefaultTableModel(new Object[0], new String[]{"Id Orden", "Id Atencion", "Fecha", "Servicio", "Profesional", "Especialidad", "idServicio", "Realizada?", "IdOrdenFacturacion"}) { // from class: Historia.JIFConsultarExamenesxUsuario.21
            Class[] types = {Integer.class, Integer.class, String.class, String.class, String.class, String.class, Long.class, Boolean.class, String.class};
            boolean[] canEdit = {false, false, true, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTBOrdenes;
        JTable jTable2 = this.JTBOrdenes;
        jTable.setAutoResizeMode(0);
        this.JTBOrdenes.doLayout();
        this.JTBOrdenes.setModel(this.xmodeloOrden);
        this.JTBOrdenes.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.JTBOrdenes.getColumnModel().getColumn(1).setPreferredWidth(80);
        this.JTBOrdenes.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTBOrdenes.getColumnModel().getColumn(3).setPreferredWidth(200);
        this.JTBOrdenes.getColumnModel().getColumn(4).setPreferredWidth(300);
        this.JTBOrdenes.getColumnModel().getColumn(5).setPreferredWidth(200);
        this.JTBOrdenes.getColumnModel().getColumn(6).setPreferredWidth(0);
        this.JTBOrdenes.getColumnModel().getColumn(6).setMinWidth(0);
        this.JTBOrdenes.getColumnModel().getColumn(6).setMaxWidth(0);
        this.JTBOrdenes.getColumnModel().getColumn(7).setPreferredWidth(80);
        this.JTBOrdenes.getColumnModel().getColumn(8).setPreferredWidth(100);
    }

    public void mCargarOrdenes() {
        try {
            String sql = "SELECT  `h_ordenes`.`Id` , `h_ordenes`.`Id_Atencion` , `h_ordenes`.`FechaOrden`  , `f_tiposervicio`.`Nbre`AS servicio ,\nconcat(gp.Apellido1,' ', gp.Apellido2,' ', gp.Nombre1,' ', gp.Nombre2) as `NProfesional`, ge.Nbre as `Especialidad`,`h_ordenes`.`Id_TipoServicio`, IF(h_ordenes.`EstaEntregada`=0,FALSE,TRUE) AS EstaEntregada\n, `h_itemordenesproced`.Id_Orden_Fac\n FROM `h_ordenes` \n INNER JOIN `h_itemordenesproced`  ON (`h_itemordenesproced`.`Id_HOrdenes` = `h_ordenes`.`Id`) \n INNER JOIN `f_tiposervicio` ON (`h_ordenes`.`Id_TipoServicio` = `f_tiposervicio`.`Id`)\nINNER JOIN `h_atencion` ON (`h_ordenes`.`Id_Atencion` = `h_atencion`.`Id`) \nINNER JOIN `ingreso`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\nINNER JOIN g_persona gp  ON (gp.Id = `h_ordenes`.`Id_Profesional`) \ninner join g_especialidad ge  on (ge.Id=h_ordenes.Id_Especialidad)\n WHERE ( `ingreso`.`Id_Usuario` ='" + this.xjppersona.getIdPersona() + "')\ngroup by `h_ordenes`.`Id` \norder by `f_tiposervicio`.`Nbre` ASC,`h_ordenes`.`FechaOrden` DESC";
            ResultSet rs = this.xct.traerRs(sql);
            if (rs.next()) {
                rs.beforeFirst();
                int filaGrid = 0;
                mCrearModeloOrdenes();
                while (rs.next()) {
                    this.xmodeloOrden.addRow(this.dato);
                    this.xmodeloOrden.setValueAt(Integer.valueOf(rs.getInt(1)), filaGrid, 0);
                    this.xmodeloOrden.setValueAt(Integer.valueOf(rs.getInt(2)), filaGrid, 1);
                    this.xmodeloOrden.setValueAt(rs.getString(3), filaGrid, 2);
                    this.xmodeloOrden.setValueAt(rs.getString(4), filaGrid, 3);
                    this.xmodeloOrden.setValueAt(rs.getString(5), filaGrid, 4);
                    this.xmodeloOrden.setValueAt(rs.getString(6), filaGrid, 5);
                    this.xmodeloOrden.setValueAt(Long.valueOf(rs.getLong(7)), filaGrid, 6);
                    this.xmodeloOrden.setValueAt(Boolean.valueOf(rs.getBoolean(8)), filaGrid, 7);
                    this.xmodeloOrden.setValueAt(rs.getString("Id_Orden_Fac"), filaGrid, 8);
                    this.JTBOrdenes.setDefaultRenderer(Object.class, new MiRender2(this.numeroOrden));
                    filaGrid++;
                }
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (Exception ex) {
            Logger.getLogger(JIFConsultarResultadoExamenes.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:Historia/JIFConsultarExamenesxUsuario$MiRender2.class */
    public static class MiRender2 extends DefaultTableCellRenderer {
        String numero;

        public MiRender2(String numero) {
            this.numero = "0";
            this.numero = numero;
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (table.getValueAt(row, 8).toString().equals(this.numero)) {
                cell.setBackground(new Color(177, 251, 177));
                cell.setForeground(Color.black);
            } else {
                cell.setBackground(Color.WHITE);
                cell.setForeground(Color.black);
            }
            return cell;
        }
    }

    public void imprimirOrden() {
        if (Integer.valueOf(this.xmodeloOrden.getValueAt(this.JTBOrdenes.getSelectedRow(), 6).toString()).intValue() == 2) {
            try {
                String xpeso = "";
                String xtalla = "";
                String xnstiker = "1";
                String xsql = "SELECT h_examenfisico.Talla , h_examenfisico.Peso FROM h_examenfisico INNER JOIN h_atencion  ON (h_examenfisico.Id_Atencion = h_atencion.Id) INNER JOIN h_ordenes  ON (h_ordenes.Id_Atencion = h_atencion.Id) INNER JOIN h_itemordenesproced  ON (h_itemordenesproced.Id_HOrdenes = h_ordenes.Id) INNER JOIN g_procedimiento  ON (h_itemordenesproced.Id_Procedimiento = g_procedimiento.Id) WHERE (h_examenfisico.Talla <>0 AND h_examenfisico.Peso <>0 AND h_ordenes.Id ='" + this.xmodeloOrden.getValueAt(this.JTBOrdenes.getSelectedRow(), 0).toString() + "' AND h_ordenes.Id_TipoServicio =2 AND g_procedimiento.RPrevios IS NOT NULL) ";
                ResultSet xrs = this.xct.traerRs(xsql);
                Throwable th = null;
                try {
                    try {
                        if (xrs.next()) {
                            xrs.first();
                            xtalla = xrs.getString(1);
                            xpeso = xrs.getString(2);
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
                        String xsql2 = "SELECT l_tipomuestra.Id FROM h_ordenes INNER JOIN h_atencion  ON (h_ordenes.Id_Atencion = h_atencion.Id) INNER JOIN h_itemordenesproced  ON (h_itemordenesproced.Id_HOrdenes = h_ordenes.Id) INNER JOIN g_procedimiento  ON (h_itemordenesproced.Id_Procedimiento = g_procedimiento.Id) INNER JOIN l_tipomuestra  ON (g_procedimiento.Id_TipoMuestra = l_tipomuestra.Id) WHERE (h_ordenes.Id ='" + this.xmodeloOrden.getValueAt(this.JTBOrdenes.getSelectedRow(), 0).toString() + "') GROUP BY l_tipomuestra.Id ORDER BY h_ordenes.Id ASC ";
                        ResultSet rs = this.xct.traerRs(xsql2);
                        if (rs.next()) {
                            rs.last();
                            xnstiker = String.valueOf(rs.getRow());
                        }
                        rs.close();
                        this.xct.cerrarConexionBd();
                        String[][] mparametros = new String[6][2];
                        mparametros[0][0] = "idorden";
                        mparametros[0][1] = this.xmodeloOrden.getValueAt(this.JTBOrdenes.getSelectedRow(), 0).toString();
                        mparametros[1][0] = "talla";
                        mparametros[1][1] = "TALLA : " + xtalla;
                        mparametros[2][0] = "peso";
                        mparametros[2][1] = "PESO : " + xpeso;
                        mparametros[3][0] = "ns";
                        mparametros[3][1] = "N° Stiker : " + xnstiker;
                        mparametros[4][0] = "SUBREPORT_DIR";
                        mparametros[4][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
                        mparametros[5][0] = "SUBREPORTFIRMA_DIR";
                        mparametros[5][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
                        if (Principal.informacionIps.getEsFpz().intValue() == 0) {
                            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "RProcedimientosL", mparametros);
                        } else {
                            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "RProcedimientosL1", mparametros);
                        }
                        return;
                    } finally {
                    }
                } catch (Throwable th3) {
                    th = th3;
                    throw th3;
                }
            } catch (SQLException ex) {
                Logger.getLogger(JIFConsultarExamenesxUsuario.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                return;
            }
        }
        String sql = "SELECT h_atencion.Motivo_Atencion, h_ordenes.Id FROM h_ordenes INNER JOIN h_atencion ON (h_ordenes.Id_Atencion = h_atencion.Id) where h_ordenes.Id='" + this.xmodeloOrden.getValueAt(this.JTBOrdenes.getSelectedRow(), 0).toString() + "'";
        String nota = this.xct.traerDato(sql);
        this.xct.cerrarConexionBd();
        String horario = "";
        if (Principal.informacionIps.getEsFpz().intValue() == 0 && Integer.valueOf(this.xmodeloOrden.getValueAt(this.JTBOrdenes.getSelectedRow(), 6).toString()).intValue() == 3) {
            horario = "Horario de Atencion:\nLunes a Jueves:  6:30 A.M - 4:30 P.M\nViernes:  6:30 A.M - 1:00 P.M";
        }
        String[][] mparametros2 = new String[6][2];
        mparametros2[0][0] = "idorden";
        mparametros2[0][1] = this.xmodeloOrden.getValueAt(this.JTBOrdenes.getSelectedRow(), 0).toString();
        mparametros2[1][0] = "idservicio";
        mparametros2[1][1] = this.xmodeloOrden.getValueAt(this.JTBOrdenes.getSelectedRow(), 6).toString();
        mparametros2[2][0] = "nota";
        mparametros2[2][1] = nota;
        mparametros2[3][0] = "horario";
        mparametros2[3][1] = horario;
        mparametros2[4][0] = "SUBREPORT_DIR";
        mparametros2[4][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
        mparametros2[5][0] = "SUBREPORTFIRMA_DIR";
        mparametros2[5][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
        if (Principal.informacionIps.getEsFpz().intValue() == 0) {
            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "RProcedimientosO", mparametros2);
        } else if (Principal.informacionIps.getFormaImpresionReporte().intValue() == 1) {
            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "RProcedimientosO1", mparametros2);
        } else if (Principal.informacionIps.getFormaImpresionReporte().intValue() == 2) {
            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "RProcedimientosO2", mparametros2);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloRemision() {
        this.xmodeloRem = new DefaultTableModel(new Object[0], new String[]{"Id Remisión", "Fecha", "Id Atencion", "Esp. Remitida", "Prof. que remite", "Esp. que remite", "Hosp"}) { // from class: Historia.JIFConsultarExamenesxUsuario.22
            Class[] types = {Integer.class, String.class, Integer.class, String.class, String.class, String.class, Long.class};
            boolean[] canEdit = {false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTRemision.setModel(this.xmodeloRem);
        this.JTRemision.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTRemision.getColumnModel().getColumn(1).setPreferredWidth(10);
        this.JTRemision.getColumnModel().getColumn(2).setPreferredWidth(10);
        this.JTRemision.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTRemision.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTRemision.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTRemision.getColumnModel().getColumn(6).setPreferredWidth(1);
        this.JTRemision.getColumnModel().getColumn(6).setMinWidth(0);
        this.JTRemision.getColumnModel().getColumn(6).setMaxWidth(0);
    }

    public void mCargarRemisiones() {
        try {
            String sql = "SELECT `h_remisiones`.`Id` , `h_remisiones`.`Fecha` , `h_remisiones`.`Id_Atencion` , `g_especialidad`.`Nbre` AS EspRemitida, `profesional1`.`NProfesional` AS ProRemite, `profesional1`.`Especialidad` AS EspRemite, h_remisiones.`Hospitalizado` FROM `h_remisiones`  INNER JOIN `profesional1`   ON (`h_remisiones`.`Id_Profesional` = `profesional1`.`Id_Persona`) AND (`h_remisiones`.`Id_EspecialidadR` = `profesional1`.`IdEspecialidad`)INNER JOIN `h_atencion` ON (`h_remisiones`.`Id_Atencion` = `h_atencion`.`Id`)INNER JOIN `g_especialidad` ON (`h_remisiones`.`I_Especialidad` = `g_especialidad`.`Id`)INNER JOIN `ingreso`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) WHERE (`ingreso`.`Id_Usuario` ='" + this.xjppersona.getIdPersona() + "' AND h_remisiones.`Estado`=0) ORDER BY `h_remisiones`.`Fecha` DESC";
            ResultSet rs = this.xct.traerRs(sql);
            if (rs.next()) {
                rs.beforeFirst();
                int filaGrid = 0;
                mCrearModeloRemision();
                while (rs.next()) {
                    this.xmodeloRem.addRow(this.dato);
                    this.xmodeloRem.setValueAt(Integer.valueOf(rs.getInt(1)), filaGrid, 0);
                    this.xmodeloRem.setValueAt(rs.getString(2), filaGrid, 1);
                    this.xmodeloRem.setValueAt(Integer.valueOf(rs.getInt(3)), filaGrid, 2);
                    this.xmodeloRem.setValueAt(rs.getString(4), filaGrid, 3);
                    this.xmodeloRem.setValueAt(rs.getString(5), filaGrid, 4);
                    this.xmodeloRem.setValueAt(rs.getString(6), filaGrid, 5);
                    this.xmodeloRem.setValueAt(Long.valueOf(rs.getLong(7)), filaGrid, 6);
                    filaGrid++;
                }
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (Exception ex) {
            Logger.getLogger(JIFConsultarResultadoExamenes.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void imprimirRemision() {
        Metodos xmetodos = new Metodos();
        String[][] mparametros = new String[5][2];
        mparametros[0][0] = "idremision";
        mparametros[0][1] = this.xmodeloRem.getValueAt(this.JTRemision.getSelectedRow(), 0).toString();
        mparametros[1][0] = "idatencion1";
        mparametros[1][1] = this.xmodeloRem.getValueAt(this.JTRemision.getSelectedRow(), 2).toString();
        mparametros[2][0] = "marca";
        mparametros[2][1] = "HISTORIA CLINICA";
        mparametros[3][0] = "SUBREPORT_DIR";
        mparametros[3][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
        mparametros[4][0] = "SUBREPORTFIRMA_DIR";
        mparametros[4][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
        if (this.xmodeloRem.getValueAt(this.JTRemision.getSelectedRow(), 6).equals(0)) {
            if (Principal.informacionIps.getEsFpz().intValue() == 0) {
                xmetodos.GenerarPDF(this.xmt.getRutaRep() + "RRemisionTO", mparametros);
                return;
            } else {
                xmetodos.GenerarPDF(this.xmt.getRutaRep() + "RRemision1", mparametros);
                return;
            }
        }
        if (Principal.informacionIps.getEsFpz().intValue() == 0) {
            xmetodos.GenerarPDF(this.xmt.getRutaRep() + "RRemisionOTO", mparametros);
        } else {
            xmetodos.GenerarPDF(this.xmt.getRutaRep() + "RRemisionO1", mparametros);
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:Historia/JIFConsultarExamenesxUsuario$MiRender.class */
    public class MiRender extends DefaultTableCellRenderer {
        public MiRender() {
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (table.getValueAt(row, 5).toString().equals("false")) {
                cell.setBackground(new Color(0, 0, 102));
            } else if (table.getValueAt(row, 5).toString().equals("true")) {
                cell.setBackground(new Color(103, 0, 103));
            }
            cell.setForeground(Color.WHITE);
            return cell;
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:Historia/JIFConsultarExamenesxUsuario$MiRender1.class */
    public class MiRender1 extends DefaultTableCellRenderer {
        public MiRender1() {
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (table.getValueAt(row, 6).toString().equals("2")) {
                cell.setBackground(new Color(177, 251, 177));
            } else {
                cell.setBackground(Color.WHITE);
            }
            return cell;
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:Historia/JIFConsultarExamenesxUsuario$MiRender3.class */
    public class MiRender3 extends DefaultTableCellRenderer {
        public MiRender3() {
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (Integer.parseInt(table.getValueAt(row, 9).toString()) == 1) {
                cell.setBackground(new Color(255, 204, 204));
                cell.setForeground(Color.BLACK);
            } else if (table.getValueAt(row, 2).toString().isEmpty() && table.getValueAt(row, 6).toString().isEmpty() && table.getValueAt(row, 7).toString().isEmpty()) {
                cell.setBackground(new Color(255, 255, 255));
            } else if (!table.getValueAt(row, 2).toString().isEmpty() && table.getValueAt(row, 6).toString().isEmpty() && table.getValueAt(row, 7).toString().isEmpty()) {
                cell.setBackground(Color.red);
                cell.setForeground(new Color(255, 255, 255));
            } else if (!table.getValueAt(row, 2).toString().isEmpty() && !table.getValueAt(row, 6).toString().isEmpty() && table.getValueAt(row, 7).toString().isEmpty()) {
                cell.setBackground(new Color(255, 255, 0));
            } else if (!table.getValueAt(row, 2).toString().isEmpty() && !table.getValueAt(row, 6).toString().isEmpty() && !table.getValueAt(row, 7).toString().isEmpty()) {
                cell.setBackground(new Color(153, 255, 153));
                cell.setForeground(Color.BLACK);
            }
            return cell;
        }
    }

    private void mIniciarPanel() {
        if (this.xnombre.equals("jifconsultarRemOrd") || this.xnombre.equals("jifconsultarRemOrdEnfer") || this.xnombre.equals("jifconsultarRemOrdHist") || this.xnombre.equals("jiconsultarRemOrdFacturacion")) {
            this.JTPDatos.setEnabledAt(0, false);
            this.JTPDatos.setEnabledAt(1, false);
            this.JTPDatos.setSelectedIndex(2);
        } else {
            this.JTPDatos.setEnabledAt(2, false);
            this.JTPDatos.setEnabledAt(3, false);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTablaRx() {
        this.xmodeloRx = new DefaultTableModel(new Object[0], new String[]{"Id", "Fecha", "Procedimiento", "Especialidad", "Profesional", "Interpretación", "Url_Estudio", "Url_Lectura", "IdProcedimiento", "IdLectura"}) { // from class: Historia.JIFConsultarExamenesxUsuario.23
            Class[] types = {Long.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Long.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTRadiologia.setModel(this.xmodeloRx);
        this.JTRadiologia.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTRadiologia.getColumnModel().getColumn(1).setPreferredWidth(30);
        this.JTRadiologia.getColumnModel().getColumn(2).setPreferredWidth(200);
        this.JTRadiologia.getColumnModel().getColumn(3).setPreferredWidth(30);
        this.JTRadiologia.getColumnModel().getColumn(4).setPreferredWidth(80);
        this.JTRadiologia.getColumnModel().getColumn(5).setPreferredWidth(0);
        this.JTRadiologia.getColumnModel().getColumn(5).setMinWidth(0);
        this.JTRadiologia.getColumnModel().getColumn(5).setMaxWidth(0);
        this.JTRadiologia.getColumnModel().getColumn(6).setPreferredWidth(50);
        this.JTRadiologia.getColumnModel().getColumn(7).setPreferredWidth(0);
        this.JTRadiologia.getColumnModel().getColumn(7).setMinWidth(0);
        this.JTRadiologia.getColumnModel().getColumn(7).setMaxWidth(0);
        this.JTRadiologia.getColumnModel().getColumn(8).setPreferredWidth(0);
        this.JTRadiologia.getColumnModel().getColumn(8).setMinWidth(0);
        this.JTRadiologia.getColumnModel().getColumn(8).setMaxWidth(0);
        this.JTRadiologia.getColumnModel().getColumn(9).setPreferredWidth(20);
    }

    public void mCargarRx() {
        mCrearTablaRx();
        int m = 0;
        this.xIdRadiologia = "0";
        String sql = "SELECT `h_radiologia`.`Id`, DATE_FORMAT(`h_radiologia`.`Fecha_Rec`,'%d-%m-%Y') AS `Fecha`, `g_procedimiento`.`Nbre`, `profesional1`.`Especialidad`, `profesional1`.`NProfesional` , IF(`h_radiologia_detalle`.`Observacion` IS NULL,'',`h_radiologia_detalle`.`Observacion`)  AS `Interpretacion`, IF(`h_radiologia`.`Url_Estudio` ='',`h_radiologia`.`Url_Estudio`,LEFT(`h_radiologia`.`Url_Estudio`,(LENGTH(`h_radiologia`.`Url_Estudio`)-8) )) As Estudio, `h_radiologia`.`Url_Lectura`, `h_radiologia_detalle`.Id_Procedimiento, IF(h_radiologia_lectura_encabezado.`Id` IS NULL,0, h_radiologia_detalle.Id) IdLecturaS FROM  `h_radiologia`  INNER JOIN  `h_radiologia_detalle` ON (`h_radiologia_detalle`.`Id_radiologia` = `h_radiologia`.`Id`) LEFT JOIN `h_radiologia_lectura_encabezado` ON (`h_radiologia_detalle`.`Id` = `h_radiologia_lectura_encabezado`.`Id_Radiologia`) AND (h_radiologia_lectura_encabezado.`Estado`=1) INNER JOIN  `g_procedimiento`  ON (`h_radiologia_detalle`.`Id_Procedimiento` = `g_procedimiento`.`Id`) INNER JOIN  `f_ordenes`  ON (`f_ordenes`.`Id` = `h_radiologia`.`Id_OrdenFac`) INNER JOIN  `ingreso`  ON (`f_ordenes`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN  `profesional1`  ON (`profesional1`.`Id_Persona` = `f_ordenes`.`Id_Profesional`) AND (`profesional1`.`IdEspecialidad` = `f_ordenes`.`Id_Especialidad`) WHERE ( `ingreso`.`Id_Usuario` ='" + this.xjppersona.getIdPersona() + "' AND DATE_FORMAT(`h_radiologia`.`Fecha_Rec`,'%Y') ='" + this.JYAno.getValue() + "' and `h_radiologia`.Estado=1) ORDER BY `Fecha` DESC, `g_procedimiento`.`Nbre` ASC ";
        ResultSet rs = this.xct.traerRs(sql);
        try {
            if (rs.next()) {
                rs.beforeFirst();
                while (rs.next()) {
                    this.xmodeloRx.addRow(this.dato);
                    this.xmodeloRx.setValueAt(Long.valueOf(rs.getLong(1)), m, 0);
                    this.xmodeloRx.setValueAt(rs.getString(2), m, 1);
                    this.xmodeloRx.setValueAt(rs.getString(3), m, 2);
                    this.xmodeloRx.setValueAt(rs.getString(4), m, 3);
                    this.xmodeloRx.setValueAt(rs.getString(5), m, 4);
                    this.xmodeloRx.setValueAt(rs.getString(6), m, 5);
                    this.xmodeloRx.setValueAt(rs.getString(7), m, 6);
                    this.xmodeloRx.setValueAt(rs.getString(8), m, 7);
                    this.xmodeloRx.setValueAt(rs.getString(9), m, 8);
                    this.xmodeloRx.setValueAt(Long.valueOf(rs.getLong("IdLecturaS")), m, 9);
                    m++;
                }
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException e) {
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloAudiometria() {
        this.xmodelouadio = new DefaultTableModel(new Object[0], new String[]{"IdAtencion", "Fecha", "OD500", "OD1000", "OD2000", "OD3000", "OD4000", "OD6000", "OD8000", "OI500", "OI1000", "OI2000", "OI3000", "OI4000", "OI6000", "OI8000", "IdAudio"}) { // from class: Historia.JIFConsultarExamenesxUsuario.24
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTAudiometria.setModel(this.xmodelouadio);
        this.JTAudiometria.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTAudiometria.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTAudiometria.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTAudiometria.getColumnModel().getColumn(1).setPreferredWidth(16);
        this.JTAudiometria.getColumnModel().getColumn(2).setPreferredWidth(4);
        this.JTAudiometria.getColumnModel().getColumn(3).setPreferredWidth(6);
        this.JTAudiometria.getColumnModel().getColumn(4).setPreferredWidth(6);
        this.JTAudiometria.getColumnModel().getColumn(5).setPreferredWidth(6);
        this.JTAudiometria.getColumnModel().getColumn(6).setPreferredWidth(6);
        this.JTAudiometria.getColumnModel().getColumn(7).setPreferredWidth(6);
        this.JTAudiometria.getColumnModel().getColumn(8).setPreferredWidth(6);
        this.JTAudiometria.getColumnModel().getColumn(9).setPreferredWidth(4);
        this.JTAudiometria.getColumnModel().getColumn(10).setPreferredWidth(6);
        this.JTAudiometria.getColumnModel().getColumn(11).setPreferredWidth(6);
        this.JTAudiometria.getColumnModel().getColumn(12).setPreferredWidth(6);
        this.JTAudiometria.getColumnModel().getColumn(13).setPreferredWidth(6);
        this.JTAudiometria.getColumnModel().getColumn(14).setPreferredWidth(6);
        this.JTAudiometria.getColumnModel().getColumn(15).setPreferredWidth(6);
        this.JTAudiometria.getColumnModel().getColumn(16).setPreferredWidth(0);
        this.JTAudiometria.getColumnModel().getColumn(16).setMinWidth(0);
        this.JTAudiometria.getColumnModel().getColumn(16).setMaxWidth(0);
    }

    public void mCargarDatosTablaAudiometria() {
        try {
            mCrearModeloAudiometria();
            String sql = "SELECT h_so_audiometria.`Id_Atencion`, h_so_audiometria.`Fecha_R`, h_so_audiometria.`I500`  , h_so_audiometria.`I1000`  , h_so_audiometria.`I2000`  , h_so_audiometria.`I3000` , h_so_audiometria.`I4000` , h_so_audiometria.`I6000`  , h_so_audiometria.`I8000` , h_so_audiometria.`D500` , h_so_audiometria.`D1000` , h_so_audiometria.`D2000`  , h_so_audiometria.`D3000`, h_so_audiometria.`D4000` , h_so_audiometria.`D6000`  , h_so_audiometria.`D8000`, h_so_audiometria.Id  FROM `h_so_audiometria` WHERE (Id_Usuario='" + this.xjppersona.getIdPersona() + "' and Estado =1)";
            ResultSet xrs = this.xct.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelouadio.addRow(this.dato);
                    this.xmodelouadio.setValueAt(xrs.getString(1), n, 0);
                    this.xmodelouadio.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelouadio.setValueAt(xrs.getString(10), n, 2);
                    this.xmodelouadio.setValueAt(xrs.getString(11), n, 3);
                    this.xmodelouadio.setValueAt(xrs.getString(12), n, 4);
                    this.xmodelouadio.setValueAt(xrs.getString(13), n, 5);
                    this.xmodelouadio.setValueAt(xrs.getString(14), n, 6);
                    this.xmodelouadio.setValueAt(xrs.getString(15), n, 7);
                    this.xmodelouadio.setValueAt(xrs.getString(16), n, 8);
                    this.xmodelouadio.setValueAt(xrs.getString(3), n, 9);
                    this.xmodelouadio.setValueAt(xrs.getString(4), n, 10);
                    this.xmodelouadio.setValueAt(xrs.getString(5), n, 11);
                    this.xmodelouadio.setValueAt(xrs.getString(6), n, 12);
                    this.xmodelouadio.setValueAt(xrs.getString(7), n, 13);
                    this.xmodelouadio.setValueAt(xrs.getString(8), n, 14);
                    this.xmodelouadio.setValueAt(xrs.getString(9), n, 15);
                    this.xmodelouadio.setValueAt(xrs.getString(17), n, 16);
                    n++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPSo_Audiometria.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloEspiro() {
        this.xmodeloespiro = new DefaultTableModel(new Object[0], new String[]{"Id", "IdAtencion", "Fecha", "FVCP", "FVCM", "VEF1P", "VEF1M", "IndiceT", "DVEF1", "DFVC", "Resultado", "Mes"}) { // from class: Historia.JIFConsultarExamenesxUsuario.25
            Class[] types = {String.class, Long.class, String.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTEspirometria.setModel(this.xmodeloespiro);
        this.JTEspirometria.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTEspirometria.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTEspirometria.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTEspirometria.getColumnModel().getColumn(1).setPreferredWidth(0);
        this.JTEspirometria.getColumnModel().getColumn(1).setMinWidth(0);
        this.JTEspirometria.getColumnModel().getColumn(1).setMaxWidth(0);
        this.JTEspirometria.getColumnModel().getColumn(2).setPreferredWidth(10);
        this.JTEspirometria.getColumnModel().getColumn(3).setPreferredWidth(15);
        this.JTEspirometria.getColumnModel().getColumn(4).setPreferredWidth(15);
        this.JTEspirometria.getColumnModel().getColumn(5).setPreferredWidth(15);
        this.JTEspirometria.getColumnModel().getColumn(6).setPreferredWidth(15);
        this.JTEspirometria.getColumnModel().getColumn(7).setPreferredWidth(15);
        this.JTEspirometria.getColumnModel().getColumn(8).setPreferredWidth(15);
        this.JTEspirometria.getColumnModel().getColumn(9).setPreferredWidth(15);
        this.JTEspirometria.getColumnModel().getColumn(10).setPreferredWidth(20);
        this.JTEspirometria.getColumnModel().getColumn(11).setPreferredWidth(20);
    }

    public void mCargarDatoEspirometria() {
        try {
            mCrearModeloEspiro();
            String sql = "SELECT `Id`, `Id_Atencion`, DATE_FORMAT(`Fecha_R`,'%d-%m-%Y') AS Fecha, `FVCP`, `FVCM`, `VEF1P`, `VEF1M`, `IndicT`, `DVEF1`, `DFVC`, `Resultado`, DATE_FORMAT(`Fecha_R`,'%Y'), CONCAT(MID(DevuelveMes(`Fecha_R`),1, 1),'',LOWER(MID(DevuelveMes(`Fecha_R`),2, LENGTH(DevuelveMes(`Fecha_R`))))) AS Mes  FROM  `h_so_espirometria` WHERE (`Id_Usuario` ='" + this.xjppersona.getIdPersona() + "' and Estado=1 ) ORDER BY `Fecha_R` DESC ";
            ResultSet xrs = this.xct.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int x = 0;
                while (xrs.next()) {
                    this.xmodeloespiro.addRow(this.dato);
                    this.xmodeloespiro.setValueAt(xrs.getString(1), x, 0);
                    this.xmodeloespiro.setValueAt(Long.valueOf(xrs.getLong(2)), x, 1);
                    this.xmodeloespiro.setValueAt(xrs.getString(3), x, 2);
                    this.xmodeloespiro.setValueAt(Double.valueOf(xrs.getDouble(4)), x, 3);
                    this.xmodeloespiro.setValueAt(Double.valueOf(xrs.getDouble(5)), x, 4);
                    this.xmodeloespiro.setValueAt(Double.valueOf(xrs.getDouble(6)), x, 5);
                    this.xmodeloespiro.setValueAt(Double.valueOf(xrs.getDouble(7)), x, 6);
                    this.xmodeloespiro.setValueAt(Double.valueOf(xrs.getDouble(8)), x, 7);
                    this.xmodeloespiro.setValueAt(Double.valueOf(xrs.getDouble(9)), x, 8);
                    this.xmodeloespiro.setValueAt(Double.valueOf(xrs.getDouble(10)), x, 9);
                    this.xmodeloespiro.setValueAt(xrs.getString(11), x, 10);
                    this.xmodeloespiro.setValueAt(xrs.getString(12) + "\\" + xrs.getString(13), x, 11);
                    x++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPSo_Espirometria.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mImprimirEspiro() {
        String[][] mparametros = new String[3][2];
        mparametros[0][0] = "IdEspirometria";
        mparametros[0][1] = this.xmodeloespiro.getValueAt(this.JTEspirometria.getSelectedRow(), 0).toString();
        mparametros[1][0] = "SUBREPORT_DIR";
        mparametros[1][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
        mparametros[2][0] = "SUBREPORTFIRMA_DIR";
        mparametros[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
        if (Principal.informacionIps.getEsFpz().intValue() == 0) {
            this.xmt.mostrarPdf("S:\\Salud Ocupacional\\Espirometrias\\" + this.xmodeloespiro.getValueAt(this.JTEspirometria.getSelectedRow(), 11).toString() + "\\" + this.xmodeloespiro.getValueAt(this.JTEspirometria.getSelectedRow(), 1).toString() + ".pdf");
        } else {
            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "H_So_Espirometria_1", mparametros);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloVisio() {
        this.xmodelovisio = new DefaultTableModel(new Object[0], new String[]{"Id Atencion", "Fecha", "Profesional", "IdVisio"}) { // from class: Historia.JIFConsultarExamenesxUsuario.26
            Class[] types = {String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTVisiometria.setModel(this.xmodelovisio);
        this.JTVisiometria.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTVisiometria.getColumnModel().getColumn(1).setPreferredWidth(10);
        this.JTVisiometria.getColumnModel().getColumn(2).setPreferredWidth(200);
        this.JTVisiometria.getColumnModel().getColumn(3).setPreferredWidth(0);
        this.JTVisiometria.getColumnModel().getColumn(3).setMinWidth(0);
        this.JTVisiometria.getColumnModel().getColumn(3).setMaxWidth(0);
    }

    public void mCargarDatosVisio() {
        try {
            mCrearModeloVisio();
            String sql = "SELECT  `h_so_visiometria`.`Id_Atencion` , `h_so_visiometria`.`FechaR`  , `profesional`.`NProfesional`, h_so_visiometria.Id FROM `h_so_visiometria` INNER JOIN `profesional`  ON (`h_so_visiometria`.`Id_Profesional` = `profesional`.`Id_Persona`) WHERE (`h_so_visiometria`.`Id_Usuario` ='" + this.xjppersona.getIdPersona() + "' and `h_so_visiometria`.Estado =1)";
            ResultSet xrs = this.xct.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelovisio.addRow(this.dato);
                    this.xmodelovisio.setValueAt(xrs.getString(1), n, 0);
                    this.xmodelovisio.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelovisio.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelovisio.setValueAt(xrs.getString(4), n, 3);
                    n++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPASaludOcupacional.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mImprimirVisio() {
        String[][] mparametros = new String[3][2];
        mparametros[0][0] = "IdVisiometria";
        mparametros[0][1] = this.xmodelovisio.getValueAt(this.JTVisiometria.getSelectedRow(), 3).toString();
        mparametros[1][0] = "SUBREPORT_DIR";
        mparametros[1][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
        mparametros[2][0] = "SUBREPORTFIRMA_DIR";
        mparametros[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
        if (Principal.informacionIps.getEsFpz().intValue() == 0) {
            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "H_So_Visiometria", mparametros);
        } else {
            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "H_So_Visiometria_1", mparametros);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloOMA() {
        this.xmodelooma = new DefaultTableModel(new Object[0], new String[]{"Id Atencion", "Fecha", "Profesional"}) { // from class: Historia.JIFConsultarExamenesxUsuario.27
            Class[] types = {String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTOMA.setModel(this.xmodelooma);
        this.JTOMA.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTOMA.getColumnModel().getColumn(1).setPreferredWidth(10);
        this.JTOMA.getColumnModel().getColumn(2).setPreferredWidth(200);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloConceptoA() {
        this.xmodelo_concepto = new DefaultTableModel(new Object[0], new String[]{"Id", "Fecha", "Tipo", "Profesional", "Url"}) { // from class: Historia.JIFConsultarExamenesxUsuario.28
            Class[] types = {Long.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBHConcepto.setModel(this.xmodelo_concepto);
        this.JTBHConcepto.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTBHConcepto.getColumnModel().getColumn(1).setPreferredWidth(10);
        this.JTBHConcepto.getColumnModel().getColumn(2).setPreferredWidth(10);
        this.JTBHConcepto.getColumnModel().getColumn(3).setPreferredWidth(200);
        this.JTBHConcepto.getColumnModel().getColumn(4).setPreferredWidth(0);
        this.JTBHConcepto.getColumnModel().getColumn(4).setMinWidth(0);
        this.JTBHConcepto.getColumnModel().getColumn(4).setMaxWidth(0);
    }

    public void mCargarDatosOMA() {
        try {
            mCrearModeloOMA();
            String sql = "SELECT `h_so_examen_osteomuscular`.`Id_Atencion`  , `h_so_examen_osteomuscular`.`FechaE`   , `profesional1`.`NProfesional`  FROM `h_so_examen_osteomuscular` INNER JOIN `profesional1` ON (`h_so_examen_osteomuscular`.`IdUsuarioOMA` = `profesional1`.`Id_Persona`) AND (`h_so_examen_osteomuscular`.`IdEspecialidad` = `profesional1`.`IdEspecialidad`) WHERE (`h_so_examen_osteomuscular`.`Id_Usuario` ='" + this.xjppersona.getIdPersona() + "')";
            ResultSet xrs = this.xct.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelooma.addRow(this.dato);
                    this.xmodelooma.setValueAt(xrs.getString(1), n, 0);
                    this.xmodelooma.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelooma.setValueAt(xrs.getString(3), n, 2);
                    n++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPASaludOcupacional.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mCargarDatos_Concepto() {
        try {
            mCrearModeloConceptoA();
            String sql = "SELECT `h_so_concepto_laboral`.`Id`, `h_atencion`.`Fecha_Atencion`, `c_clasecita`.`Nbre`, `profesional1`.`NProfesional`, `h_so_concepto_laboral`.`Url_Soporte` FROM     `h_so_concepto_laboral` INNER JOIN `h_atencion`  ON (`h_so_concepto_laboral`.`Id_Atencion` = `h_atencion`.`Id`) INNER JOIN `so_tipo_concepto`  ON (`h_so_concepto_laboral`.`Id_TipoC` = `so_tipo_concepto`.`Id`) INNER JOIN `profesional1`  ON (`profesional1`.`Id_Persona` = `h_atencion`.`Id_Profesional`) AND (`profesional1`.`IdEspecialidad` = `h_atencion`.`Id_Especialidad`) INNER JOIN `ingreso`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN `c_clasecita`  ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`) WHERE (`h_so_concepto_laboral`.`Estado` =1 AND `ingreso`.`Id_Usuario` ='" + this.xjppersona.getIdPersona() + "') ORDER BY `h_atencion`.`Fecha_Atencion` DESC ";
            ResultSet xrs = this.xct.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo_concepto.addRow(this.dato);
                    this.xmodelo_concepto.setValueAt(Long.valueOf(xrs.getLong(1)), n, 0);
                    this.xmodelo_concepto.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo_concepto.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelo_concepto.setValueAt(xrs.getString(4), n, 3);
                    this.xmodelo_concepto.setValueAt(xrs.getString(5), n, 4);
                    n++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPASaludOcupacional.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mImprimirOMA() {
        String[][] mparametros = new String[3][2];
        mparametros[0][0] = "idatencion1";
        mparametros[0][1] = this.xmodelooma.getValueAt(this.JTOMA.getSelectedRow(), 0).toString();
        mparametros[1][0] = "SUBREPORT_DIR";
        mparametros[1][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
        mparametros[2][0] = "SUBREPORTFIRMA_DIR";
        mparametros[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
        if (Principal.informacionIps.getEsFpz().intValue() == 0) {
            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "SO_HistoriaClinica_OMA", mparametros);
        } else {
            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "SO_HistoriaClinica_OMA1", mparametros);
        }
    }

    public void imprimirPdfFusionado2(String ruta, String archivoPrincipal) {
        String rutaCarpeta2 = this.xmt.mRutaSoporte("JDCarguePDFResultadosExternos");
        System.err.println("rutacarpeta" + rutaCarpeta2);
        String outputFileName = "Recepcion unificada_" + this.nombreCompletoPDF;
        List<InputStream> inputStreams = new ArrayList<>();
        try {
            try {
                inputStreams.add(new FileInputStream(archivoPrincipal));
                File folder = new File(rutaCarpeta2);
                File[] listOfFiles = folder.listFiles();
                for (File file : listOfFiles) {
                    System.err.println("nombrefile" + file.getName());
                    if (file.isFile() && file.getName().equals(this.nombreCompletoPDF)) {
                        inputStreams.add(new FileInputStream(rutaCarpeta2 + "\\" + file.getName()));
                    }
                }
                System.out.println("ruta: " + ruta);
                System.out.println("inputStreams: " + inputStreams);
                this.xmt.unirPdf_Generico_Colcan(ruta + "\\Recepcion unificada", outputFileName, inputStreams);
                Desktop.getDesktop().open(new File(ruta + "\\Recepcion unificada\\" + outputFileName));
                for (InputStream inputStream : inputStreams) {
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } catch (IOException e2) {
                e2.printStackTrace();
                for (InputStream inputStream2 : inputStreams) {
                    try {
                        inputStream2.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                }
            }
        } catch (Throwable th) {
            for (InputStream inputStream3 : inputStreams) {
                try {
                    inputStream3.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            }
            throw th;
        }
    }
}
