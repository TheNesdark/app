package Historia;

import Acceso.Principal;
import General.ClaseImpresionInformes;
import General.JD_Impresin_Central_Dc;
import General.Persona;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.genoma.plus.controller.general.JDGenericoPanel;
import com.genoma.plus.dao.impl.laboratorio.ImpresionReportesDAOImpl;
import com.genoma.plus.jpa.entities.GPersona;
import com.genoma.plus.jpa.projection.IGLlamadasProjection;
import com.genoma.plus.jpa.service.IGLlamadasService;
import com.genoma.plus.jpa.service.IGPersonaService;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.FileChannel;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

/* JADX INFO: loaded from: GenomaP.jar:Historia/JPGestionHC.class */
public class JPGestionHC extends JPanel {
    private String[] xidespecialidad;
    private DefaultTableModel xmodeloatencionessistmatizadas;
    private DefaultTableModel xmodeloatencionesdigitalizadas;
    private DefaultTableModel xmodeloatencionesfisioterapia;
    private DefaultTableModel xmodeloTriage;
    private DefaultTableModel modeloSeguimiento;
    private DefaultTableModel xmodeloConsentimientoInformado;
    private DefaultTableModel modelo;
    private Object[] dato;
    public Object xjif;
    public Object xjpiiauditoria;
    private File xfile1;
    public Persona xjppersona;
    private JIFConsultarHistorial xjifch;
    private int xidentificados;
    private JPGraficasCyDImpresion xJPGraficasCyDImpresion;
    private JPGraficasPrenatalImpresion xJPGraficasPrenatalImpresion;
    private Object[] datos;
    public Persona frmPersona;
    private List<IGLlamadasProjection> listaRegistroLlamada;
    private ButtonGroup JBGSeleccion;
    private ButtonGroup JBROpciones;
    private JButton JBTConsultar;
    private JButton JBTEventoAdverso1;
    public JButton JBTRegresa;
    private JComboBox JCBEspecialidad;
    private JCheckBox JCHNinguna;
    private JCheckBox JCHTodas;
    public JDateChooser JDCFechaF;
    public JDateChooser JDCFechaI;
    private JPanel JPIDUsuario;
    private JPanel JPIDatosBusqueda;
    private JPanel JPIMSeleccion;
    private JPanel JPIOpciones;
    private JRadioButton JRBEspecFecha;
    private JRadioButton JRBEspecialidad;
    private JRadioButton JRBIFechas;
    private JScrollPane JSPAtencionesDigitalizada;
    private JScrollPane JSPAtencionesFisioterapia;
    private JScrollPane JSPConsentimientoInformado;
    private JScrollPane JSPDetalleConsulta;
    private JScrollPane JSPRegistroLamada;
    private JScrollPane JSPSeguimientoSO;
    private JScrollPane JSPTriage;
    private JTable JTBAtencionesDigitalizadaas;
    private JTable JTBAtencionesFisioterapia;
    private JTable JTBConsentimientoInformado;
    private JTable JTBDetalle;
    private JTable JTBRegistroLamada;
    private JTable JTBSeguimientoSO;
    private JRadioButton JTBTodas;
    private JTable JTBTriage;
    private JTextField JTFRuta;
    private JTabbedPane JTPHistoria;
    private JPanel jPanel1;
    private String xidusuario = "0";
    private int xvc = 0;
    private ConsultasMySQL xconsultasbd = new ConsultasMySQL();
    private Metodos xmt = new Metodos();
    private String frmllamador = null;
    private final IGLlamadasService llamadas = (IGLlamadasService) Principal.contexto.getBean(IGLlamadasService.class);
    private final IGPersonaService gPersonaService = (IGPersonaService) Principal.contexto.getBean(IGPersonaService.class);

    public JPGestionHC(JInternalFrame xnbre, int x) {
        this.xidentificados = -1;
        initComponents();
        this.xmt.cargarPanelOdontogramaDientes(this.JPIOpciones);
        this.xidentificados = x;
        realizarcasting(xnbre);
        mCargarDatosGenerales();
    }

    private void mRenderPanelGraficasCyD(long idUsuarioA, long idUsuarioPrograma) {
        this.xJPGraficasCyDImpresion = new JPGraficasCyDImpresion(idUsuarioA, idUsuarioPrograma);
        this.xJPGraficasCyDImpresion.setBorder(BorderFactory.createTitledBorder((Border) null, "GRÁFICAS CyD", 2, 0, new Font("Arial", 1, 14), Color.BLACK));
        this.xJPGraficasCyDImpresion.setVisible(true);
        this.xJPGraficasCyDImpresion.setBounds(-10, 0, 896, 570);
        JDialog x = new JDialog();
        x.add(this.xJPGraficasCyDImpresion);
        x.setSize(200, 100);
        x.setLocationRelativeTo((Component) null);
        x.setVisible(true);
        x.dispose();
    }

    private void mGeneraGraficaCyD() {
        this.xJPGraficasCyDImpresion.mGeneraGrafico_ScreenShot();
    }

    private void mRenderizarPanelGraficoPrenatal(long idUsuarioA, long idUsuarioPrograma) {
        JDialog prueba = new JDialog();
        this.xJPGraficasPrenatalImpresion = new JPGraficasPrenatalImpresion(idUsuarioA, idUsuarioPrograma);
        this.xJPGraficasPrenatalImpresion.setBorder(BorderFactory.createTitledBorder((Border) null, "GRÁFICAS PRENATAL", 2, 0, new Font("Arial", 1, 14), Color.BLACK));
        this.xJPGraficasPrenatalImpresion.setVisible(true);
        this.xJPGraficasPrenatalImpresion.setBounds(-50, 0, 896, 570);
        prueba.add(this.xJPGraficasPrenatalImpresion);
        prueba.setSize(600, 700);
        prueba.setVisible(true);
        prueba.dispose();
    }

    private void mGenerarGraficaPrenatal() {
        this.xJPGraficasPrenatalImpresion.GenerarScreeshot();
    }

    private void initComponents() {
        this.JBROpciones = new ButtonGroup();
        this.JBGSeleccion = new ButtonGroup();
        this.JPIDatosBusqueda = new JPanel();
        this.JPIOpciones = new JPanel();
        this.JTBTodas = new JRadioButton();
        this.JRBIFechas = new JRadioButton();
        this.JRBEspecialidad = new JRadioButton();
        this.JRBEspecFecha = new JRadioButton();
        this.JDCFechaI = new JDateChooser();
        this.JDCFechaF = new JDateChooser();
        this.JCBEspecialidad = new JComboBox();
        this.JBTConsultar = new JButton();
        this.JPIDUsuario = new JPanel();
        this.JTPHistoria = new JTabbedPane();
        this.JSPDetalleConsulta = new JScrollPane();
        this.JTBDetalle = new JTable();
        this.JSPAtencionesDigitalizada = new JScrollPane();
        this.JTBAtencionesDigitalizadaas = new JTable();
        this.JSPAtencionesFisioterapia = new JScrollPane();
        this.JTBAtencionesFisioterapia = new JTable();
        this.JSPTriage = new JScrollPane();
        this.JTBTriage = new JTable();
        this.JSPSeguimientoSO = new JScrollPane();
        this.JTBSeguimientoSO = new JTable();
        this.JSPConsentimientoInformado = new JScrollPane();
        this.JTBConsentimientoInformado = new JTable();
        this.JSPRegistroLamada = new JScrollPane();
        this.JTBRegistroLamada = new JTable();
        this.jPanel1 = new JPanel();
        this.JBTRegresa = new JButton();
        this.JTFRuta = new JTextField();
        this.JPIMSeleccion = new JPanel();
        this.JCHTodas = new JCheckBox();
        this.JCHNinguna = new JCheckBox();
        this.JBTEventoAdverso1 = new JButton();
        setBorder(BorderFactory.createTitledBorder((Border) null, "CONSULTAR ATENCIONES", 2, 0, new Font("Arial", 1, 14), Color.blue));
        setName("jpconsultahc");
        this.JPIDatosBusqueda.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS PARA BUSQUEDA", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JPIOpciones.setBorder(BorderFactory.createTitledBorder((Border) null, "OPCIONES", 0, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.JBROpciones.add(this.JTBTodas);
        this.JTBTodas.setFont(new Font("Arial", 1, 12));
        this.JTBTodas.setForeground(new Color(0, 0, 255));
        this.JTBTodas.setSelected(true);
        this.JTBTodas.setText("Todas");
        this.JTBTodas.addActionListener(new ActionListener() { // from class: Historia.JPGestionHC.1
            public void actionPerformed(ActionEvent evt) {
                JPGestionHC.this.JTBTodasActionPerformed(evt);
            }
        });
        this.JBROpciones.add(this.JRBIFechas);
        this.JRBIFechas.setFont(new Font("Arial", 1, 12));
        this.JRBIFechas.setForeground(new Color(0, 0, 255));
        this.JRBIFechas.setText("Intervalos de Fecha");
        this.JRBIFechas.addActionListener(new ActionListener() { // from class: Historia.JPGestionHC.2
            public void actionPerformed(ActionEvent evt) {
                JPGestionHC.this.JRBIFechasActionPerformed(evt);
            }
        });
        this.JBROpciones.add(this.JRBEspecialidad);
        this.JRBEspecialidad.setFont(new Font("Arial", 1, 12));
        this.JRBEspecialidad.setForeground(new Color(0, 0, 255));
        this.JRBEspecialidad.setText("Especialidad");
        this.JRBEspecialidad.addActionListener(new ActionListener() { // from class: Historia.JPGestionHC.3
            public void actionPerformed(ActionEvent evt) {
                JPGestionHC.this.JRBEspecialidadActionPerformed(evt);
            }
        });
        this.JBROpciones.add(this.JRBEspecFecha);
        this.JRBEspecFecha.setFont(new Font("Arial", 1, 12));
        this.JRBEspecFecha.setForeground(new Color(0, 0, 255));
        this.JRBEspecFecha.setText("Especialidad y Fecha");
        this.JRBEspecFecha.addActionListener(new ActionListener() { // from class: Historia.JPGestionHC.4
            public void actionPerformed(ActionEvent evt) {
                JPGestionHC.this.JRBEspecFechaActionPerformed(evt);
            }
        });
        GroupLayout JPIOpcionesLayout = new GroupLayout(this.JPIOpciones);
        this.JPIOpciones.setLayout(JPIOpcionesLayout);
        JPIOpcionesLayout.setHorizontalGroup(JPIOpcionesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIOpcionesLayout.createSequentialGroup().addContainerGap().addGroup(JPIOpcionesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIOpcionesLayout.createSequentialGroup().addComponent(this.JTBTodas).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 114, 32767).addComponent(this.JRBEspecialidad).addGap(70, 70, 70)).addGroup(JPIOpcionesLayout.createSequentialGroup().addComponent(this.JRBIFechas).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 38, 32767).addComponent(this.JRBEspecFecha).addGap(26, 26, 26)))));
        JPIOpcionesLayout.setVerticalGroup(JPIOpcionesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIOpcionesLayout.createSequentialGroup().addContainerGap().addGroup(JPIOpcionesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTBTodas).addComponent(this.JRBEspecialidad)).addGap(18, 18, 18).addGroup(JPIOpcionesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JRBIFechas).addComponent(this.JRBEspecFecha)).addContainerGap(-1, 32767)));
        this.JDCFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicio", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JDCFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaI.setFont(new Font("Tahoma", 1, 12));
        this.JDCFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaF.setFont(new Font("Tahoma", 1, 12));
        this.JCBEspecialidad.setFont(new Font("Arial", 1, 12));
        this.JCBEspecialidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Especialidad", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBTConsultar.setFont(new Font("Arial", 1, 12));
        this.JBTConsultar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTConsultar.setText("Consultar");
        this.JBTConsultar.addActionListener(new ActionListener() { // from class: Historia.JPGestionHC.5
            public void actionPerformed(ActionEvent evt) {
                JPGestionHC.this.JBTConsultarActionPerformed(evt);
            }
        });
        GroupLayout JPIDatosBusquedaLayout = new GroupLayout(this.JPIDatosBusqueda);
        this.JPIDatosBusqueda.setLayout(JPIDatosBusquedaLayout);
        JPIDatosBusquedaLayout.setHorizontalGroup(JPIDatosBusquedaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosBusquedaLayout.createSequentialGroup().addContainerGap().addComponent(this.JPIOpciones, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIDatosBusquedaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosBusquedaLayout.createSequentialGroup().addComponent(this.JDCFechaI, -2, 159, -2).addGap(26, 26, 26).addComponent(this.JDCFechaF, -2, 159, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTConsultar, -1, 297, 32767)).addComponent(this.JCBEspecialidad, 0, -1, 32767)).addContainerGap()));
        JPIDatosBusquedaLayout.setVerticalGroup(JPIDatosBusquedaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosBusquedaLayout.createSequentialGroup().addGroup(JPIDatosBusquedaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosBusquedaLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosBusquedaLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JDCFechaF, -1, -1, 32767).addComponent(this.JDCFechaI, -1, -1, 32767).addComponent(this.JBTConsultar, -1, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBEspecialidad)).addComponent(this.JPIOpciones, -1, -1, 32767)).addContainerGap()));
        GroupLayout JPIDUsuarioLayout = new GroupLayout(this.JPIDUsuario);
        this.JPIDUsuario.setLayout(JPIDUsuarioLayout);
        JPIDUsuarioLayout.setHorizontalGroup(JPIDUsuarioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 0, 32767));
        JPIDUsuarioLayout.setVerticalGroup(JPIDUsuarioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 174, 32767));
        this.JTPHistoria.setForeground(Color.red);
        this.JTPHistoria.setFont(new Font("Arial", 1, 14));
        this.JSPDetalleConsulta.setBorder(BorderFactory.createTitledBorder((Border) null, "", 2, 0, new Font("Arial", 1, 14), Color.blue));
        this.JSPDetalleConsulta.addMouseListener(new MouseAdapter() { // from class: Historia.JPGestionHC.6
            public void mouseClicked(MouseEvent evt) {
                JPGestionHC.this.JSPDetalleConsultaMouseClicked(evt);
            }
        });
        this.JTBDetalle.setFont(new Font("Arial", 1, 12));
        this.JTBDetalle.setRowHeight(25);
        this.JTBDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTBDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTBDetalle.setSelectionMode(0);
        this.JTBDetalle.addMouseListener(new MouseAdapter() { // from class: Historia.JPGestionHC.7
            public void mouseClicked(MouseEvent evt) {
                JPGestionHC.this.JTBDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalleConsulta.setViewportView(this.JTBDetalle);
        this.JTPHistoria.addTab("ATENCIONES SISTEMATIZADAS", this.JSPDetalleConsulta);
        this.JSPAtencionesDigitalizada.setBorder(BorderFactory.createTitledBorder((Border) null, "", 2, 0, new Font("Arial", 1, 14), Color.blue));
        this.JTBAtencionesDigitalizadaas.setFont(new Font("Arial", 1, 12));
        this.JTBAtencionesDigitalizadaas.setRowHeight(25);
        this.JTBAtencionesDigitalizadaas.setSelectionBackground(new Color(255, 255, 255));
        this.JTBAtencionesDigitalizadaas.setSelectionForeground(new Color(255, 0, 0));
        this.JTBAtencionesDigitalizadaas.setSelectionMode(0);
        this.JTBAtencionesDigitalizadaas.addMouseListener(new MouseAdapter() { // from class: Historia.JPGestionHC.8
            public void mouseClicked(MouseEvent evt) {
                JPGestionHC.this.JTBAtencionesDigitalizadaasMouseClicked(evt);
            }
        });
        this.JSPAtencionesDigitalizada.setViewportView(this.JTBAtencionesDigitalizadaas);
        this.JTPHistoria.addTab("ATENCIONES DIGITALIZADAS", this.JSPAtencionesDigitalizada);
        this.JSPAtencionesFisioterapia.setBorder(BorderFactory.createTitledBorder((Border) null, "", 2, 0, new Font("Arial", 1, 14), Color.blue));
        this.JTBAtencionesFisioterapia.setFont(new Font("Arial", 1, 12));
        this.JTBAtencionesFisioterapia.setRowHeight(25);
        this.JTBAtencionesFisioterapia.setSelectionBackground(new Color(255, 255, 255));
        this.JTBAtencionesFisioterapia.setSelectionForeground(new Color(255, 0, 0));
        this.JTBAtencionesFisioterapia.setSelectionMode(0);
        this.JTBAtencionesFisioterapia.addMouseListener(new MouseAdapter() { // from class: Historia.JPGestionHC.9
            public void mouseClicked(MouseEvent evt) {
                JPGestionHC.this.JTBAtencionesFisioterapiaMouseClicked(evt);
            }
        });
        this.JSPAtencionesFisioterapia.setViewportView(this.JTBAtencionesFisioterapia);
        this.JTPHistoria.addTab("ATENCIONES FISIOTERAPIA", this.JSPAtencionesFisioterapia);
        this.JSPTriage.setBorder(BorderFactory.createTitledBorder((Border) null, "", 2, 0, new Font("Arial", 1, 14), Color.blue));
        this.JTBTriage.setFont(new Font("Arial", 1, 12));
        this.JTBTriage.setRowHeight(25);
        this.JTBTriage.setSelectionBackground(new Color(255, 255, 255));
        this.JTBTriage.setSelectionForeground(new Color(255, 0, 0));
        this.JTBTriage.setSelectionMode(0);
        this.JTBTriage.addMouseListener(new MouseAdapter() { // from class: Historia.JPGestionHC.10
            public void mouseClicked(MouseEvent evt) {
                JPGestionHC.this.JTBTriageMouseClicked(evt);
            }
        });
        this.JSPTriage.setViewportView(this.JTBTriage);
        this.JTPHistoria.addTab("TRIAGE", this.JSPTriage);
        this.JSPSeguimientoSO.setBorder(BorderFactory.createTitledBorder((Border) null, "", 2, 0, new Font("Arial", 1, 14), Color.blue));
        this.JTBSeguimientoSO.setFont(new Font("Arial", 1, 12));
        this.JTBSeguimientoSO.setRowHeight(25);
        this.JTBSeguimientoSO.setSelectionBackground(new Color(255, 255, 255));
        this.JTBSeguimientoSO.setSelectionForeground(new Color(255, 0, 0));
        this.JTBSeguimientoSO.setSelectionMode(0);
        this.JTBSeguimientoSO.addMouseListener(new MouseAdapter() { // from class: Historia.JPGestionHC.11
            public void mouseClicked(MouseEvent evt) {
                JPGestionHC.this.JTBSeguimientoSOMouseClicked(evt);
            }
        });
        this.JSPSeguimientoSO.setViewportView(this.JTBSeguimientoSO);
        this.JTPHistoria.addTab("SEGUIMIENTO SALUD OCUPACIONAL", this.JSPSeguimientoSO);
        this.JSPConsentimientoInformado.setBorder(BorderFactory.createTitledBorder((Border) null, "", 2, 0, new Font("Arial", 1, 14), Color.blue));
        this.JSPConsentimientoInformado.addMouseListener(new MouseAdapter() { // from class: Historia.JPGestionHC.12
            public void mouseClicked(MouseEvent evt) {
                JPGestionHC.this.JSPConsentimientoInformadoMouseClicked(evt);
            }
        });
        this.JTBConsentimientoInformado.setFont(new Font("Arial", 1, 12));
        this.JTBConsentimientoInformado.setToolTipText("");
        this.JTBConsentimientoInformado.setRowHeight(25);
        this.JTBConsentimientoInformado.setSelectionBackground(new Color(255, 255, 255));
        this.JTBConsentimientoInformado.setSelectionForeground(new Color(255, 0, 0));
        this.JTBConsentimientoInformado.setSelectionMode(0);
        this.JTBConsentimientoInformado.setSelectionMode(0);
        this.JTBConsentimientoInformado.addMouseListener(new MouseAdapter() { // from class: Historia.JPGestionHC.13
            public void mouseClicked(MouseEvent evt) {
                JPGestionHC.this.JTBConsentimientoInformadoMouseClicked(evt);
            }
        });
        this.JSPConsentimientoInformado.setViewportView(this.JTBConsentimientoInformado);
        this.JTPHistoria.addTab("CONSENTIMIENTO INFORMADO", this.JSPConsentimientoInformado);
        this.JSPRegistroLamada.setBorder(BorderFactory.createTitledBorder((Border) null, "", 2, 0, new Font("Arial", 1, 14), Color.blue));
        this.JSPRegistroLamada.addMouseListener(new MouseAdapter() { // from class: Historia.JPGestionHC.14
            public void mouseClicked(MouseEvent evt) {
                JPGestionHC.this.JSPRegistroLamadaMouseClicked(evt);
            }
        });
        this.JTBRegistroLamada.setFont(new Font("Arial", 1, 12));
        this.JTBRegistroLamada.setToolTipText("");
        this.JTBRegistroLamada.setRowHeight(25);
        this.JTBRegistroLamada.setSelectionBackground(new Color(255, 255, 255));
        this.JTBRegistroLamada.setSelectionForeground(new Color(255, 0, 0));
        this.JTBRegistroLamada.setSelectionMode(0);
        this.JTBRegistroLamada.setSelectionMode(0);
        this.JTBRegistroLamada.addMouseListener(new MouseAdapter() { // from class: Historia.JPGestionHC.15
            public void mouseClicked(MouseEvent evt) {
                JPGestionHC.this.JTBRegistroLamadaMouseClicked(evt);
            }
        });
        this.JSPRegistroLamada.setViewportView(this.JTBRegistroLamada);
        this.JTPHistoria.addTab("REGISTRO DE LLAMADAS ", this.JSPRegistroLamada);
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS PARA EXPORTAR", 0, 0, new Font("Arial", 1, 14), Color.red));
        this.JBTRegresa.setFont(new Font("Arial", 1, 12));
        this.JBTRegresa.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Deshacer.png")));
        this.JBTRegresa.setText("Regresa");
        this.JBTRegresa.addActionListener(new ActionListener() { // from class: Historia.JPGestionHC.16
            public void actionPerformed(ActionEvent evt) {
                JPGestionHC.this.JBTRegresaActionPerformed(evt);
            }
        });
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ruta (Directorio Destino)", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: Historia.JPGestionHC.17
            public void mouseClicked(MouseEvent evt) {
                JPGestionHC.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JTFRuta.addActionListener(new ActionListener() { // from class: Historia.JPGestionHC.18
            public void actionPerformed(ActionEvent evt) {
                JPGestionHC.this.JTFRutaActionPerformed(evt);
            }
        });
        this.JPIMSeleccion.setBorder(BorderFactory.createTitledBorder((Border) null, "Seleccionar", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JBGSeleccion.add(this.JCHTodas);
        this.JCHTodas.setFont(new Font("Arial", 1, 12));
        this.JCHTodas.setSelected(true);
        this.JCHTodas.setText("Todas");
        this.JCHTodas.addActionListener(new ActionListener() { // from class: Historia.JPGestionHC.19
            public void actionPerformed(ActionEvent evt) {
                JPGestionHC.this.JCHTodasActionPerformed(evt);
            }
        });
        this.JBGSeleccion.add(this.JCHNinguna);
        this.JCHNinguna.setFont(new Font("Arial", 1, 12));
        this.JCHNinguna.setText("Ninguna");
        this.JCHNinguna.addActionListener(new ActionListener() { // from class: Historia.JPGestionHC.20
            public void actionPerformed(ActionEvent evt) {
                JPGestionHC.this.JCHNingunaActionPerformed(evt);
            }
        });
        GroupLayout JPIMSeleccionLayout = new GroupLayout(this.JPIMSeleccion);
        this.JPIMSeleccion.setLayout(JPIMSeleccionLayout);
        JPIMSeleccionLayout.setHorizontalGroup(JPIMSeleccionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIMSeleccionLayout.createSequentialGroup().addComponent(this.JCHTodas).addGap(18, 18, 18).addComponent(this.JCHNinguna).addGap(0, 0, 32767)));
        JPIMSeleccionLayout.setVerticalGroup(JPIMSeleccionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIMSeleccionLayout.createSequentialGroup().addGroup(JPIMSeleccionLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCHTodas).addComponent(this.JCHNinguna)).addGap(0, 0, 32767)));
        this.JBTEventoAdverso1.setFont(new Font("Arial", 1, 12));
        this.JBTEventoAdverso1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Evento Adverso.png")));
        this.JBTEventoAdverso1.setText("<html><P ALIGN=center>Caso de Seguridad del Paciente\n");
        this.JBTEventoAdverso1.setToolTipText("");
        this.JBTEventoAdverso1.addActionListener(new ActionListener() { // from class: Historia.JPGestionHC.21
            public void actionPerformed(ActionEvent evt) {
                JPGestionHC.this.JBTEventoAdverso1ActionPerformed(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addComponent(this.JTFRuta, -2, 368, -2).addGap(18, 18, 18).addComponent(this.JBTRegresa).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTEventoAdverso1, -2, 0, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPIMSeleccion, -2, -1, -2).addGap(70, 70, 70)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(13, 13, 13).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JBTRegresa, -1, -1, 32767).addComponent(this.JBTEventoAdverso1, GroupLayout.Alignment.TRAILING).addGroup(jPanel1Layout.createSequentialGroup().addGap(5, 5, 5).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JPIMSeleccion, -2, -1, -2).addComponent(this.JTFRuta, -2, 50, -2)).addGap(0, 0, 32767))).addContainerGap()));
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIDUsuario, -1, -1, 32767).addComponent(this.JPIDatosBusqueda, -1, -1, 32767).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTPHistoria).addComponent(this.jPanel1, -1, -1, 32767)).addGap(10, 10, 10)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.JPIDUsuario, -2, -1, -2).addGap(10, 10, 10).addComponent(this.JPIDatosBusqueda, -2, -1, -2).addGap(10, 10, 10).addComponent(this.JTPHistoria, -2, 329, -2).addGap(10, 10, 10).addComponent(this.jPanel1, -2, -1, -2).addGap(10, 10, 10)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBDetalleMouseClicked(MouseEvent evt) {
        int columna = this.JTBDetalle.columnAtPoint(evt.getPoint());
        int fila = this.JTBDetalle.rowAtPoint(evt.getPoint());
        if (this.JTBDetalle.getSelectedRow() != -1 && this.JTBDetalle.getModel().getColumnClass(columna).equals(JButton.class) && this.JTBDetalle.getSelectedRow() == fila) {
            JD_Impresin_Central_Dc xjd = new JD_Impresin_Central_Dc(null, true, this.xmodeloatencionessistmatizadas.getValueAt(this.JTBDetalle.getSelectedRow(), 0).toString(), this.xmodeloatencionessistmatizadas.getValueAt(this.JTBDetalle.getSelectedRow(), 11).toString(), this.xmodeloatencionessistmatizadas.getValueAt(this.JTBDetalle.getSelectedRow(), 10).toString(), this.xmodeloatencionessistmatizadas.getValueAt(this.JTBDetalle.getSelectedRow(), 12).toString(), Integer.valueOf(this.xmodeloatencionessistmatizadas.getValueAt(this.JTBDetalle.getSelectedRow(), 16).toString()), this.xjppersona.txtCorreo.getText());
            xjd.setLocationRelativeTo(this);
            xjd.setVisible(true);
        }
    }

    private String mConsultaIdUsuarioPrograma(String IdPrograma) {
        String idUsuarioPrograma = "";
        String sql = "SELECT Id FROM `g_usuarioxprograma` \nWHERE g_usuarioxprograma.`Id_Usuario`='" + this.xjppersona.getIdPersona() + "' AND Id_Programa=" + IdPrograma;
        ConsultasMySQL xct = new ConsultasMySQL();
        ResultSet xrs = xct.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.first();
                idUsuarioPrograma = xrs.getString("Id");
            }
            xrs.close();
            xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPGestionHC.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return idUsuarioPrograma;
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearModeloLamdas() {
        this.modelo = new DefaultTableModel(new Object[0], new String[]{"S", "Fecha y Hora", "Contesto La Llamada", "Detalle", "Número", "Usuario"}) { // from class: Historia.JPGestionHC.22
            Class[] types = {Boolean.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {true, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTBRegistroLamada;
        JTable jTable2 = this.JTBRegistroLamada;
        jTable.setAutoResizeMode(0);
        this.JTBRegistroLamada.doLayout();
        this.JTBRegistroLamada.setModel(this.modelo);
        this.JTBRegistroLamada.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTBRegistroLamada.getColumnModel().getColumn(1).setPreferredWidth(200);
        this.JTBRegistroLamada.getColumnModel().getColumn(2).setPreferredWidth(200);
        this.JTBRegistroLamada.getColumnModel().getColumn(3).setPreferredWidth(300);
        this.JTBRegistroLamada.getColumnModel().getColumn(4).setPreferredWidth(150);
        this.JTBRegistroLamada.getColumnModel().getColumn(5).setPreferredWidth(150);
    }

    public void cargarREgistroLlamadas() {
        crearModeloLamdas();
        this.listaRegistroLlamada = new ArrayList();
        this.listaRegistroLlamada = this.llamadas.ListaREgistroLamadas(Integer.valueOf(Integer.parseInt(this.xjppersona.getIdPersona())));
        System.out.println("entra al metodo" + this.listaRegistroLlamada.size());
        if (this.listaRegistroLlamada != null && !this.listaRegistroLlamada.isEmpty()) {
            this.xmt.mEstablecerTextEditor(this.JTBRegistroLamada, 2);
            this.listaRegistroLlamada.forEach(detalle -> {
                this.modelo.addRow(this.datos);
                this.JTBRegistroLamada.setValueAt(true, this.JTBRegistroLamada.getRowCount() - 1, 0);
                this.JTBRegistroLamada.setValueAt(detalle.getFechaLlamada(), this.JTBRegistroLamada.getRowCount() - 1, 1);
                this.JTBRegistroLamada.setValueAt(detalle.getNbrePersonaContesta(), this.JTBRegistroLamada.getRowCount() - 1, 2);
                this.JTBRegistroLamada.setValueAt(detalle.getDetalle(), this.JTBRegistroLamada.getRowCount() - 1, 3);
                this.JTBRegistroLamada.setValueAt(detalle.getNumero(), this.JTBRegistroLamada.getRowCount() - 1, 4);
                this.JTBRegistroLamada.setValueAt(detalle.getUsuarioS(), this.JTBRegistroLamada.getRowCount() - 1, 5);
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBIFechasActionPerformed(ActionEvent evt) {
        this.xvc = 1;
        this.JDCFechaI.setEnabled(true);
        this.JDCFechaF.setEnabled(true);
        this.JCBEspecialidad.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBEspecialidadActionPerformed(ActionEvent evt) {
        this.xvc = 2;
        this.JDCFechaI.setEnabled(false);
        this.JDCFechaF.setEnabled(false);
        this.JCBEspecialidad.setEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBEspecFechaActionPerformed(ActionEvent evt) {
        this.xvc = 3;
        this.JDCFechaI.setEnabled(true);
        this.JDCFechaF.setEnabled(true);
        this.JCBEspecialidad.setEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBTodasActionPerformed(ActionEvent evt) {
        this.xvc = 0;
        this.JDCFechaI.setEnabled(false);
        this.JDCFechaF.setEnabled(false);
        this.JCBEspecialidad.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTConsultarActionPerformed(ActionEvent evt) {
        mBuscar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTRegresaActionPerformed(ActionEvent evt) {
        if (this.xidentificados != 2 && this.xidentificados == 1) {
            try {
                File directorio2 = new File(this.JTFRuta.getText() + "HC_" + this.xjppersona.txtHistoria.getText());
                if (directorio2.mkdirs()) {
                    directorio2.getPath();
                }
                File directorio3 = new File(this.JTFRuta.getText() + "HC_" + this.xjppersona.txtHistoria.getText() + this.xmt.getBarra() + "Atenciones_Sistematizadas" + this.xmt.getBarra());
                if (!directorio3.exists()) {
                    directorio3.mkdirs();
                    for (int x = 0; x < this.JTBDetalle.getRowCount(); x++) {
                        if (Boolean.valueOf(this.xmodeloatencionessistmatizadas.getValueAt(x, 7).toString()).booleanValue()) {
                            if (this.JTBDetalle.getValueAt(x, 14).equals("1")) {
                                String idUserP = mConsultaIdUsuarioPrograma("3");
                                if (!idUserP.equals("")) {
                                    mRenderizarPanelGraficoPrenatal(Long.parseLong(this.xjppersona.getIdPersona()), Long.parseLong(idUserP));
                                    mGenerarGraficaPrenatal();
                                }
                            } else if (this.JTBDetalle.getValueAt(x, 14).equals("2")) {
                                String idUserP2 = mConsultaIdUsuarioPrograma("4");
                                if (!idUserP2.equals("")) {
                                    mRenderPanelGraficasCyD(Long.parseLong(this.xjppersona.getIdPersona()), Long.parseLong(idUserP2));
                                    mGeneraGraficaCyD();
                                    this.xmt.imprimirEscalaAbreviadaDeDesarrollo(this.JTBDetalle.getValueAt(x, 0).toString(), Long.valueOf(this.xjppersona.getIdPersona()).longValue());
                                }
                            }
                            File directorio4 = new File(this.JTFRuta.getText() + "HC_" + this.xjppersona.txtHistoria.getText() + this.xmt.getBarra() + "Atenciones_Sistematizadas" + this.xmt.getBarra() + this.xmodeloatencionessistmatizadas.getValueAt(x, 2).toString());
                            if (!directorio4.exists()) {
                                directorio4.mkdirs();
                            }
                            String[][] mparametros = new String[5][2];
                            mparametros[0][0] = "idatencion1";
                            mparametros[0][1] = this.JTBDetalle.getValueAt(x, 0).toString();
                            mparametros[1][0] = "idpaciente1";
                            mparametros[1][1] = this.xjppersona.getIdPersona();
                            mparametros[2][0] = "SUBREPORT_DIR";
                            mparametros[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
                            mparametros[3][0] = "SUBREPORTFIRMA_DIR";
                            mparametros[3][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
                            mparametros[4][0] = "OS";
                            mparametros[4][1] = System.getProperty("os.name").substring(0, 3);
                            String nbre = "" + this.JTBDetalle.getValueAt(x, 0).toString() + "_" + this.JTBDetalle.getValueAt(x, 1).toString().substring(0, 10).replace("/", "-") + "_" + this.JTBDetalle.getValueAt(x, 2).toString() + "_" + this.JTBDetalle.getValueAt(x, 3).toString();
                            if (Principal.informacionIps.getEsFpz().intValue() == 0) {
                                if (this.JTBDetalle.getValueAt(x, 5).equals("690")) {
                                    this.xmt.mGenerarGrafico(this.JTBDetalle.getValueAt(x, 0).toString());
                                    mGenerarPDF("H_HistoriaClinicaSO_FPZ", mparametros, nbre, directorio4.getPath());
                                    new File(this.xmt.getRutaRep() + "H_HistoriaClinicaSO_FPZ.pdf");
                                } else {
                                    mGenerarPDF("H_HistoriaClinica", mparametros, nbre, directorio4.getPath());
                                    new File(this.xmt.getRutaRep() + "H_HistoriaClinica.pdf");
                                }
                            } else {
                                if (this.JTBDetalle.getValueAt(x, 5).equals("690")) {
                                    this.xmt.mGenerarGrafico(this.JTBDetalle.getValueAt(x, 0).toString());
                                }
                                if (this.JTBDetalle.getValueAt(x, 5).equals("1023") || this.JTBDetalle.getValueAt(x, 5).equals("1024") || this.JTBDetalle.getValueAt(x, 5).equals("461") || this.JTBDetalle.getValueAt(x, 5).equals("1032") || this.JTBDetalle.getValueAt(x, 5).equals("250")) {
                                    try {
                                        String xTratamiento = null;
                                        String sql = "SELECT `Id` FROM  `o_hc_tratamiento` WHERE (`Id_Atencion` ='" + this.JTBDetalle.getValueAt(x, 0).toString() + "')";
                                        ConsultasMySQL xct = new ConsultasMySQL();
                                        ResultSet xrs = xct.traerRs(sql);
                                        if (xrs.next()) {
                                            xrs.first();
                                            xTratamiento = xrs.getString(1);
                                        }
                                        xrs.close();
                                        xct.cerrarConexionBd();
                                        this.xmt.mTraerDatosDienteDxOdontInicial(this.xjppersona.getIdPersona());
                                        this.xmt.mTraerDatosDienteProcOdontInicial(this.xjppersona.getIdPersona());
                                        this.xmt.traerImagenOdontograma();
                                        this.xmt.mTraerDatosDienteDxTratamiento(xTratamiento);
                                        this.xmt.traerImagenOdontogramaDx();
                                        this.xmt.mTraerDatosDienteProcTratamiento(xTratamiento);
                                        this.xmt.traerImagenOdontogramaProc();
                                        this.xmt.mTraerDatosDienteMarcadosControlPlaca(xTratamiento);
                                        this.xmt.traerImagenOdontogramaControlPlaca();
                                    } catch (SQLException ex) {
                                        Logger.getLogger(JPGestionHC.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                                    }
                                }
                                mGenerarPDF(this.JTBDetalle.getValueAt(x, 8).toString(), mparametros, nbre, directorio4.getPath().trim());
                                new File(this.xmt.getRutaRep() + this.JTBDetalle.getValueAt(x, 8).toString() + ".pdf");
                            }
                        }
                    }
                }
                if (this.JTBAtencionesDigitalizadaas.getRowCount() != 0) {
                    File directorio32 = new File(this.JTFRuta.getText() + "HC_" + this.xjppersona.txtHistoria.getText() + this.xmt.getBarra() + "Atenciones_Digitalizadas" + this.xmt.getBarra());
                    if (!directorio32.exists()) {
                        directorio32.mkdirs();
                        for (int x2 = 0; x2 < this.JTBAtencionesDigitalizadaas.getRowCount(); x2++) {
                            if (Boolean.valueOf(this.xmodeloatencionesdigitalizadas.getValueAt(x2, 6).toString()).booleanValue()) {
                                copyFile(new File(this.xmodeloatencionesdigitalizadas.getValueAt(x2, 5).toString()), new File(this.JTFRuta.getText() + "HC_" + this.xjppersona.txtHistoria.getText() + this.xmt.getBarra() + "Atenciones_Digitalizadas" + this.xmt.getBarra() + this.xmodeloatencionesdigitalizadas.getValueAt(x2, 0).toString() + "_" + this.xmodeloatencionesdigitalizadas.getValueAt(x2, 1).toString().replace("/", "-") + "_" + this.xmodeloatencionesdigitalizadas.getValueAt(x2, 3).toString() + "_" + this.xmodeloatencionesdigitalizadas.getValueAt(x2, 4).toString() + ".pdf"));
                            }
                        }
                    }
                }
                String xsql = "SELECT h_resultadoayudasdx.`Url`, CONCAT(h_resultadoayudasdx.Id,'_', h_resultadoayudasdx.Fecha_Examen,'_', h_tipoayudadx.Nbre) FROM h_resultadoayudasdx INNER JOIN h_tipoayudadx ON (h_resultadoayudasdx.Id_TipoAyudaDX = h_tipoayudadx.Id)INNER JOIN profesional1  ON (profesional1.Id_Persona = h_resultadoayudasdx.Id_Profesional) INNER JOIN persona ON (persona.Id_persona = h_resultadoayudasdx.Id_Usuario) WHERE (h_resultadoayudasdx.Estado =0 AND h_resultadoayudasdx.Id_Usuario ='" + this.xjppersona.getIdPersona() + "')";
                ResultSet rs1 = this.xconsultasbd.traerRs(xsql);
                if (rs1.next()) {
                    File directorio33 = new File(this.JTFRuta.getText() + "HC_" + this.xjppersona.txtHistoria.getText() + this.xmt.getBarra() + "Ayudas_Dx_Digitalizadas" + this.xmt.getBarra());
                    if (!directorio33.exists()) {
                        directorio33.mkdirs();
                        rs1.beforeFirst();
                        while (rs1.next()) {
                            copyFile(new File(rs1.getString(1)), new File(this.JTFRuta.getText() + "HC_" + this.xjppersona.txtHistoria.getText() + this.xmt.getBarra() + "Ayudas_Dx_Digitalizadas" + this.xmt.getBarra() + rs1.getString(2) + ".pdf"));
                        }
                    }
                }
                rs1.close();
                this.xconsultasbd.cerrarConexionBd();
                String xsql2 = "SELECT l_resultados.Id_Recepcion, DATE_FORMAT(l_recepcion.FechaRecep, '%d-%m-%Y') AS FechaR, profesional1.NProfesional, profesional1.Especialidad, l_recepcion.Id_Profesional  FROM l_resultados INNER JOIN l_recepcion  ON (l_resultados.Id_Recepcion = l_recepcion.Id) INNER JOIN profesional1  ON (profesional1.Id_Persona = l_recepcion.Id_Profesional) AND (profesional1.IdEspecialidad = l_recepcion.Id_Especialidad) INNER JOIN persona  ON (persona.Id_persona = l_recepcion.Id_Paciente) WHERE (l_resultados.Estado =0 AND persona.Id_persona='" + this.xjppersona.getIdPersona() + "') GROUP BY l_resultados.Id_Recepcion ORDER BY l_resultados.Id_Recepcion";
                ConsultasMySQL xct2 = new ConsultasMySQL();
                ImpresionReportesDAOImpl impresion = new ImpresionReportesDAOImpl();
                ResultSet rs12 = xct2.traerRs(xsql2);
                if (rs12.next()) {
                    File directorio34 = new File(this.JTFRuta.getText() + "HC_" + this.xjppersona.txtHistoria.getText() + this.xmt.getBarra() + "Laboratorios_Sistematizados" + this.xmt.getBarra());
                    if (!directorio34.exists()) {
                        String[][] strArr = new String[2][2];
                        directorio34.mkdirs();
                        rs12.beforeFirst();
                        while (rs12.next()) {
                            impresion.mImprimirResultado(rs12.getString(1), "", this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra(), this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra(), true, String.valueOf(this.xjppersona.getIdPersona()), false);
                            copyFile(new File(this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra() + Principal.informacionIps.getPrefijoReportes() + "L_Reporte_Resultado_Con_Encabezado.pdf"), new File(directorio34 + this.xmt.getBarra() + rs12.getString(1) + "_" + rs12.getString(2) + "_" + rs12.getString(3) + "_" + rs12.getString(4) + ".pdf"));
                        }
                    }
                }
                rs12.close();
                xct2.cerrarConexionBd();
                String xsql3 = "SELECT\n    CONCAT(`h_ecog_obstetrica`.`Id`,'_',`h_atencion`.`Fecha_Atencion`,'_',`profesional1`.`NProfesional`) NArchivo\n    , `h_tipohistoria`.`Reporte`, `h_ecog_obstetrica`.`Id`\nFROM\n     `h_ecog_obstetrica`\n    INNER JOIN  `h_atencion` \n        ON (`h_ecog_obstetrica`.`Id_Atencion` = `h_atencion`.`Id`)\n    INNER JOIN  `ingreso` \n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN  `profesional1` \n        ON (`profesional1`.`IdEspecialidad` = `h_atencion`.`Id_Especialidad`) AND (`profesional1`.`Id_Persona` = `h_atencion`.`Id_Profesional`)\n    INNER JOIN  `c_clasecita` \n        ON (`c_clasecita`.`Id` = `h_atencion`.`Id_ClaseCita`)\n    INNER JOIN  `h_tipohistoria` \n        ON (`c_clasecita`.`Id_Historia` = `h_tipohistoria`.`Id`)\nWHERE (`h_ecog_obstetrica`.`Estado` =1\n    AND `ingreso`.`Id_Usuario` ='" + this.xjppersona.getIdPersona() + "')\nORDER BY `h_atencion`.`Fecha_Atencion` ASC";
                ConsultasMySQL xct5 = new ConsultasMySQL();
                ResultSet rs13 = xct5.traerRs(xsql3);
                if (rs13.next()) {
                    File directorio35 = new File(this.JTFRuta.getText() + "HC_" + this.xjppersona.txtHistoria.getText() + this.xmt.getBarra() + "Ecografias" + this.xmt.getBarra());
                    if (!directorio35.exists()) {
                        String[][] parametros = new String[2][2];
                        directorio35.mkdirs();
                        rs13.beforeFirst();
                        while (rs13.next()) {
                            parametros[0][0] = "Id";
                            parametros[0][1] = rs13.getString(3);
                            parametros[1][0] = "profesional";
                            parametros[1][1] = "";
                            mGenerarPDF(rs13.getString(2), parametros, rs13.getString(1), directorio35.getPath());
                        }
                    }
                }
                rs13.close();
                xct5.cerrarConexionBd();
                String xsql4 = "SELECT `h_incapacidad`.`Id`  ,  CONCAT(`h_incapacidad`.`Id`, '_', DATE_FORMAT(`h_incapacidad`.`Fecha`,'%d-%m-%Y') , '_', `profesional1`.`Especialidad`, '_', `profesional1`.`NProfesional`) AS NArchivo  FROM `persona`  INNER JOIN  `h_incapacidad`   ON (`persona`.`Id_persona` = `h_incapacidad`.`Id_Usuario`)  INNER JOIN  `profesional1`   ON (`profesional1`.`Id_Persona` = `h_incapacidad`.`Id_Profesional`)  AND (`profesional1`.`IdEspecialidad` = `h_incapacidad`.`Id_Especialidad`)  WHERE (`h_incapacidad`.`Id_Usuario`='" + this.xjppersona.getIdPersona() + "' AND `h_incapacidad`.`Estado` =0 )  ORDER BY `h_incapacidad`.`Id` ASC  ";
                ConsultasMySQL xct3 = new ConsultasMySQL();
                ResultSet rs14 = xct3.traerRs(xsql4);
                if (rs14.next()) {
                    File directorio36 = new File(this.JTFRuta.getText() + "HC_" + this.xjppersona.txtHistoria.getText() + this.xmt.getBarra() + "Incapacidades" + this.xmt.getBarra());
                    if (!directorio36.exists()) {
                        String[][] parametros2 = new String[3][2];
                        directorio36.mkdirs();
                        rs14.beforeFirst();
                        while (rs14.next()) {
                            parametros2[0][0] = "norden";
                            parametros2[0][1] = rs14.getString(1);
                            parametros2[1][0] = "SUBREPORT_DIR";
                            parametros2[1][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
                            parametros2[2][0] = "SUBREPORTFIRMA_DIR";
                            parametros2[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
                            mGenerarPDF("RIncapacidad", parametros2, rs14.getString(2), directorio36.getPath());
                        }
                    }
                }
                rs14.close();
                xct3.cerrarConexionBd();
                String xsql5 = "SELECT CONCAT(`h_so_concepto_laboral`.`Id`,'_', `h_atencion`.`Fecha_Atencion`,'_', `c_clasecita`.`Nbre`) AS `NCocepto` , `h_so_concepto_laboral`.`Url_Soporte`, `h_so_concepto_laboral`.`Id` FROM  `h_so_concepto_laboral` INNER JOIN `h_atencion`  ON (`h_so_concepto_laboral`.`Id_Atencion` = `h_atencion`.`Id`) INNER JOIN  `c_clasecita`  ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`) WHERE (`h_so_concepto_laboral`.`Id_UsuarioA` ='" + this.xjppersona.getIdPersona() + "' AND `h_so_concepto_laboral`.`Estado` =1) ";
                ResultSet rs15 = this.xconsultasbd.traerRs(xsql5);
                if (rs15.next()) {
                    File directorio37 = new File(this.JTFRuta.getText() + "HC_" + this.xjppersona.txtHistoria.getText() + this.xmt.getBarra() + "Concepto_SO");
                    if (!directorio37.exists()) {
                        directorio37.mkdirs();
                        rs15.beforeFirst();
                        while (rs15.next()) {
                            if (rs15.getString(2).isEmpty()) {
                                String[][] mparametros2 = new String[3][2];
                                mparametros2[0][0] = "Id";
                                mparametros2[0][1] = rs15.getString(3);
                                mparametros2[1][0] = "SUBREPORT_DIR";
                                mparametros2[1][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
                                mparametros2[2][0] = "SUBREPORTFIRMA_DIR";
                                mparametros2[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
                                if (Principal.informacionIps.getEsFpz().intValue() == 1) {
                                    if (Principal.informacionIps.getNombreIps().equals("IPS SU SALUD INTEGRAL S.A.S") || Principal.informacionIps.getNombreIps().equals("BIEN ESTAR SALUD BS S.A.S.") || Principal.informacionIps.getNombreIps().equals("BIENESTAR ACTIVA IPS")) {
                                        mGenerarPDF("H_So_Concepto_Aptitud_SaludIntegral", mparametros2, rs15.getString(1), directorio37.getPath());
                                    } else {
                                        mGenerarPDF("H_So_Concepto_Aptitud_1.jasper", mparametros2, rs15.getString(1), directorio37.getPath());
                                    }
                                } else if (Principal.informacionIps.getNombreIps().equals("IPS SU SALUD INTEGRAL S.A.S") || Principal.informacionIps.getNombreIps().equals("BIEN ESTAR SALUD BS S.A.S.") || Principal.informacionIps.getNombreIps().equals("BIENESTAR ACTIVA IPS")) {
                                    this.xmt.GenerarPDF(this.xmt.getRutaRep() + "H_So_Concepto_Aptitud_SaludIntegral", mparametros2);
                                } else if (Principal.informacionIps.getNombreIps().equals("MINEROS S.A") || Principal.informacionIps.getNombreIps().equals("EXPLORADORA MINERA S.A.S") || Principal.informacionIps.getNombreIps().equals("OPERADORA MINERA S.A.S") || Principal.informacionIps.getNombreIps().equals("FUNDACION MINERO S.A") || Principal.informacionIps.getNombreIps().equals("MINEROS ALUVIAL S.A.S")) {
                                    mGenerarPDF("H_So_Concepto_Aptitud_Mineros", mparametros2, rs15.getString(1), directorio37.getPath());
                                } else {
                                    mGenerarPDF("H_So_Concepto_Aptitud_Firmado_1", mparametros2, rs15.getString(1), directorio37.getPath());
                                }
                            } else {
                                copyFile(new File(rs15.getString(2)), new File(this.JTFRuta.getText() + "HC_" + this.xjppersona.txtHistoria.getText() + this.xmt.getBarra() + "Concepto_SO" + this.xmt.getBarra() + rs15.getString(1) + ".pdf"));
                            }
                        }
                    }
                }
                rs15.close();
                this.xconsultasbd.cerrarConexionBd();
                String xsql6 = "SELECT\n   CONCAT( `h_so_test_auditivo`.`Id`,'_', `ingreso`.`FechaIngreso`,'_','TestAuditivo') NTest\n    , `h_so_test_auditivo`.`UrlSoporte`\nFROM\n     `h_so_test_auditivo`\n    INNER JOIN  `ingreso` \n        ON (`h_so_test_auditivo`.`Id_Ingreso` = `ingreso`.`Id`)\nWHERE (`ingreso`.`Id_Usuario` ='" + this.xjppersona.getIdPersona() + "'\n    AND `h_so_test_auditivo`.`UrlSoporte` <>''\n    AND `h_so_test_auditivo`.`Estado` =1)";
                ResultSet rs16 = this.xconsultasbd.traerRs(xsql6);
                if (rs16.next()) {
                    File directorio38 = new File(this.JTFRuta.getText() + "HC_" + this.xjppersona.txtHistoria.getText() + this.xmt.getBarra() + "Test_Auditivo");
                    if (!directorio38.exists()) {
                        directorio38.mkdirs();
                        rs16.beforeFirst();
                        while (rs16.next()) {
                            copyFile(new File(rs16.getString(2)), new File(this.JTFRuta.getText() + "HC_" + this.xjppersona.txtHistoria.getText() + this.xmt.getBarra() + "Test_Auditivo" + this.xmt.getBarra() + rs16.getString(1) + ".pdf"));
                        }
                    }
                }
                rs16.close();
                this.xconsultasbd.cerrarConexionBd();
                String xsql7 = "SELECT\n    concat(`h_so_test_prespiratorio`.`Id`,'_', `ingreso`.`FechaIngreso`,'_','TestRespiratorio') NTest\n    , `h_so_test_prespiratorio`.`UrlSoporte`\nFROM\n     `h_so_test_prespiratorio`\n    INNER JOIN  `ingreso` \n        ON (`h_so_test_prespiratorio`.`Id_Ingreso` = `ingreso`.`Id`)\nWHERE (`h_so_test_prespiratorio`.`UrlSoporte` <>''\n    AND `h_so_test_prespiratorio`.`Estado` =1\n    AND `ingreso`.`Id_Usuario` ='" + this.xjppersona.getIdPersona() + "')";
                ResultSet rs17 = this.xconsultasbd.traerRs(xsql7);
                if (rs17.next()) {
                    File directorio39 = new File(this.JTFRuta.getText() + "HC_" + this.xjppersona.txtHistoria.getText() + this.xmt.getBarra() + "Test_Respiratorio");
                    if (!directorio39.exists()) {
                        directorio39.mkdirs();
                        rs17.beforeFirst();
                        while (rs17.next()) {
                            copyFile(new File(rs17.getString(2)), new File(this.JTFRuta.getText() + "HC_" + this.xjppersona.txtHistoria.getText() + this.xmt.getBarra() + "Test_Respiratorio" + this.xmt.getBarra() + rs17.getString(1) + ".pdf"));
                        }
                    }
                }
                rs17.close();
                this.xconsultasbd.cerrarConexionBd();
                String xsql8 = "SELECT CONCAT(`l_detallerecepcion`.`Id_Recepcion` ,'_', date_format(`l_recepcion`.`FechaRecep`,'%d-%m%Y'),'_', `profesional1`.`Especialidad`,'_',`profesional1`.`NProfesional`) NArchivo , `l_detallerecepcion`.`NArchivo`\nFROM\n     `l_detallerecepcion`\n    INNER JOIN `l_recepcion` \n        ON (`l_detallerecepcion`.`Id_Recepcion` = `l_recepcion`.`Id`)\n    INNER JOIN  `profesional1` \n        ON (`profesional1`.`IdEspecialidad` = `l_recepcion`.`Id_Especialidad`) AND (`profesional1`.`Id_Persona` = `l_recepcion`.`Id_Profesional`)\nWHERE (`l_detallerecepcion`.`NArchivo` <>'' AND `l_recepcion`.`Id_Paciente`='" + this.xjppersona.getIdPersona() + "' )";
                ResultSet rs18 = this.xconsultasbd.traerRs(xsql8);
                if (rs18.next()) {
                    File directorio310 = new File(this.JTFRuta.getText() + "HC_" + this.xjppersona.txtHistoria.getText() + this.xmt.getBarra() + "Examenes_Externos" + this.xmt.getBarra());
                    if (!directorio310.exists()) {
                        directorio310.mkdirs();
                        rs18.beforeFirst();
                        while (rs18.next()) {
                            copyFile(new File(rs18.getString(2)), new File(this.JTFRuta.getText() + "HC_" + this.xjppersona.txtHistoria.getText() + this.xmt.getBarra() + "Examenes_Externos" + this.xmt.getBarra() + rs18.getString(1) + ".pdf"));
                        }
                    }
                }
                rs18.close();
                this.xconsultasbd.cerrarConexionBd();
                String xsql9 = "SELECT `h_radiologia`.`Fecha_Rec` , `g_procedimiento`.`Nbre`, `profesional1`.`Especialidad`, `profesional1`.`NProfesional`, `h_radiologia_detalle`.`Id`\nFROM `h_radiologia_detalle` INNER JOIN `h_radiologia` ON (`h_radiologia_detalle`.`Id_radiologia` = `h_radiologia`.`Id`) INNER JOIN `f_ordenes` \nON (`h_radiologia`.`Id_OrdenFac` = `f_ordenes`.`Id`) INNER JOIN `h_radiologia_lectura_encabezado` ON (`h_radiologia_lectura_encabezado`.`Id_Radiologia` = `h_radiologia_detalle`.`Id`)\nINNER JOIN `g_procedimiento` ON (`h_radiologia_detalle`.`Id_Procedimiento` = `g_procedimiento`.`Id`) INNER JOIN `ingreso` ON (`f_ordenes`.`Id_Ingreso` = `ingreso`.`Id`)\nINNER JOIN `profesional1` ON (`profesional1`.`Id_Persona` = `h_radiologia_lectura_encabezado`.`Id_Profesional`) AND (`profesional1`.`IdEspecialidad` = `h_radiologia_lectura_encabezado`.`Id_Especialidad`)\nWHERE (`ingreso`.`Id_Usuario` ='" + this.xjppersona.getIdPersona() + "') ORDER BY `h_radiologia`.`Fecha_Rec` DESC, `g_procedimiento`.`Nbre` ASC;";
                ConsultasMySQL xct4 = new ConsultasMySQL();
                ResultSet rs19 = xct4.traerRs(xsql9);
                if (rs19.next()) {
                    File directorio311 = new File(this.JTFRuta.getText() + "HC_" + this.xjppersona.txtHistoria.getText() + this.xmt.getBarra() + "Lecturas RX" + this.xmt.getBarra());
                    if (!directorio311.exists()) {
                        String[][] mparametros3 = new String[4][2];
                        directorio311.mkdirs();
                        rs19.beforeFirst();
                        while (rs19.next()) {
                            mparametros3[0][0] = "Id";
                            mparametros3[0][1] = rs19.getString(5);
                            mparametros3[1][0] = "UsuarioS";
                            mparametros3[1][1] = Principal.usuarioSistemaDTO.getNombreUsuario();
                            mparametros3[2][0] = "SUBREPORT_DIR";
                            mparametros3[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
                            mparametros3[3][0] = "SUBREPORTFIRMA_DIR";
                            mparametros3[3][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
                            if (Principal.informacionIps.getNombreIps().equals("RADIOLOGOS ASOCIADOS DE CORDOBA S.A.S.")) {
                                mGenerarPDF("H_Radiologia_Informe_Lectura_RadiologosAs", mparametros3, rs19.getString(5), directorio311.getPath());
                            } else {
                                mGenerarPDF("H_Radiologia_Informe_Lectura", mparametros3, rs19.getString(5), directorio311.getPath());
                            }
                        }
                    }
                }
                rs19.close();
                xct4.cerrarConexionBd();
                String xsql10 = "SELECT\n    `h_remisiones`.`Id`\n    ,`h_remisiones`.`Id_Atencion`\nFROM\n    `h_remisiones`\n    INNER JOIN `h_atencion` \n        ON (`h_remisiones`.`Id_Atencion` = `h_atencion`.`Id`)\n    INNER JOIN `ingreso` \n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\nWHERE (`ingreso`.`Id_Usuario` ='" + this.xjppersona.getIdPersona() + "'\n    AND `h_remisiones`.`Estado` =0)";
                ResultSet rs110 = this.xconsultasbd.traerRs(xsql10);
                if (rs110.next()) {
                    File directorio312 = new File(this.JTFRuta.getText() + "HC_" + this.xjppersona.txtHistoria.getText() + this.xmt.getBarra() + "Remisiones" + this.xmt.getBarra());
                    if (!directorio312.exists()) {
                        directorio312.mkdirs();
                        rs110.beforeFirst();
                        while (rs110.next()) {
                            ReporteRemision xReporteRemision = new ReporteRemision(rs110.getString(2), rs110.getString(1));
                            xReporteRemision.build();
                            copyFile(new File(this.xmt.getRutaRep() + "FReferencia_" + rs110.getString(1) + ".pdf"), new File(this.JTFRuta.getText() + "HC_" + this.xjppersona.txtHistoria.getText() + this.xmt.getBarra() + "Remisiones" + this.xmt.getBarra() + rs110.getString(2) + "_" + rs110.getString(1) + ".pdf"));
                        }
                    }
                }
                rs110.close();
                this.xconsultasbd.cerrarConexionBd();
                exportaAPDFLasFormulas();
                exportaAPDFLasOrdenes();
            } catch (SQLException ex2) {
                Logger.getLogger(JPGestionHC.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBAtencionesDigitalizadaasMouseClicked(MouseEvent evt) {
        if (this.JTBAtencionesDigitalizadaas.getSelectedRow() != -1 && this.JTBAtencionesDigitalizadaas.getValueAt(this.JTBAtencionesDigitalizadaas.getSelectedRow(), 5) != null && this.JTBAtencionesDigitalizadaas.getSelectedColumn() != 6) {
            if (Principal.informacionIps.getEsFpz().intValue() == 0 || this.xmt.mRutaSoporte("JIFCargarDocumentosHC").isEmpty()) {
                this.xmt.mostrarPdf(this.xmodeloatencionesdigitalizadas.getValueAt(this.JTBAtencionesDigitalizadaas.getSelectedRow(), 5).toString());
            } else {
                this.xmt.mostrarPdf(this.xmt.mRutaSoporte("JIFCargarDocumentosHC") + this.xmt.getBarra() + this.xmodeloatencionesdigitalizadas.getValueAt(this.JTBAtencionesDigitalizadaas.getSelectedRow(), 5).toString());
            }
            Principal.mGrabarLogAtenciones("HISTORIA CLINICA DIGITALIZADA", this.JTBAtencionesDigitalizadaas.getValueAt(this.JTBAtencionesDigitalizadaas.getSelectedRow(), 0).toString(), this.xjppersona.getIdPersona());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBAtencionesFisioterapiaMouseClicked(MouseEvent evt) {
        if (this.JTBAtencionesFisioterapia.getSelectedRow() != -1) {
            String[][] parametros = new String[3][2];
            parametros[0][0] = "idatencion1";
            parametros[0][1] = this.xmodeloatencionesfisioterapia.getValueAt(this.JTBAtencionesFisioterapia.getSelectedRow(), 0).toString();
            parametros[1][0] = "SUBREPORT_DIR";
            parametros[1][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
            parametros[2][0] = "SUBREPORTFIRMA_DIR";
            parametros[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
            String sql = "SELECT `c_clasecita`.`clasificacionTipoTerapia` FROM `c_clasecita` \n  INNER JOIN `h_atencionf` ON (`c_clasecita`.`Id`=`h_atencionf`.`Id_ClaseCita`)\n  WHERE `h_atencionf`.`Id_Usuario` ='" + this.xjppersona.getIdPersona() + "'";
            System.out.println("consulta fisioterapia -> " + sql);
            ResultSet xrs = this.xconsultasbd.traerRs(sql);
            if (Principal.informacionIps.getNombreIps().equals("I.P.S CENTRO DE TERAPIAS INTEGRALES PATRICIA MEJIA CACERES S.A.S.")) {
                while (xrs.next()) {
                    try {
                        System.out.println("valor-> 0: no aplica; 1: fisica; 2: respiratoria -> " + xrs.getInt(1));
                        if (xrs.getInt(1) == 1) {
                            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "H_HistoriaClinicaFT", parametros);
                        } else if (xrs.getInt(1) == 2) {
                            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "H_HistoriaClinicaFTR", parametros);
                        }
                    } catch (Exception e) {
                        System.out.println("error exc");
                    }
                }
            } else {
                this.xmt.GenerarPDF(this.xmt.getRutaRep() + "H_HistoriaClinicaFT", parametros);
                this.xmt.GenerarPDF(this.xmt.getRutaRep() + "H_HistoriaClinicaFTR", parametros);
            }
            Principal.mGrabarLogAtenciones("HISTORIA CLINICA SISTEMATIZADA FISIOTERAPIA", this.JTBAtencionesFisioterapia.getValueAt(this.JTBAtencionesFisioterapia.getSelectedRow(), 0).toString(), this.xjppersona.getIdPersona());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JFileChooser xfilec = new JFileChooser(this.JTFRuta.getText());
            xfilec.setFileSelectionMode(1);
            int xv = xfilec.showOpenDialog(this);
            if (xv == 0) {
                this.xfile1 = xfilec.getSelectedFile();
                this.JTFRuta.setText(this.xfile1.getAbsolutePath() + this.xmt.getBarra());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHTodasActionPerformed(ActionEvent evt) {
        mSelecionar(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHNingunaActionPerformed(ActionEvent evt) {
        mSelecionar(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBTriageMouseClicked(MouseEvent evt) {
        if (this.JTBTriage.getSelectedRow() > -1) {
            String[][] mparametros = new String[3][2];
            mparametros[0][0] = "id";
            mparametros[0][1] = this.JTBTriage.getValueAt(this.JTBTriage.getSelectedRow(), 1).toString();
            mparametros[1][0] = "SUBREPORT_DIR";
            mparametros[1][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
            mparametros[2][0] = "SUBREPORTFIRMA_DIR";
            mparametros[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "H_Clasificacion_Triage", mparametros);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JSPDetalleConsultaMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTEventoAdverso1ActionPerformed(ActionEvent evt) {
        if (this.JTBDetalle.getSelectedRow() != -1) {
            JDGenericoPanel detalle = new JDGenericoPanel(null, true, "Evento Adverso", this.JTBDetalle.getValueAt(this.JTBDetalle.getSelectedRow(), 10).toString(), 14);
            detalle.setLocationRelativeTo(this);
            detalle.setVisible(true);
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un registro de atenciones sistematizadas", "Verificar", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBSeguimientoSOMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBConsentimientoInformadoMouseClicked(MouseEvent evt) {
        if (this.JTBConsentimientoInformado.getSelectedRow() != -1 && this.JTBConsentimientoInformado.getRowCount() > 0) {
            ImpresionDocumentosHC impresion = new ImpresionDocumentosHC();
            impresion.imprimirConsentimientoInformado(this.JTBConsentimientoInformado.getValueAt(this.JTBConsentimientoInformado.getSelectedRow(), 0).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JSPConsentimientoInformadoMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBRegistroLamadaMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JSPRegistroLamadaMouseClicked(MouseEvent evt) {
    }

    public void copyFile(File s, File t) {
        try {
            FileChannel in = new FileInputStream(s).getChannel();
            FileChannel out = new FileOutputStream(t).getChannel();
            in.transferTo(0L, s.length(), out);
            in.close();
            out.close();
        } catch (Exception e) {
        }
    }

    public void Inprimir() {
        if (this.JTPHistoria.getSelectedIndex() == 6) {
            imprimirLllamda();
        }
    }

    private void imprimirLllamda() {
        System.out.println(this.xidusuario);
        new GPersona();
        List<IGLlamadasProjection> listaRegistroLlamadaPersonalizada = new ArrayList<>();
        GPersona persona = this.gPersonaService.datosPersona(Long.valueOf(this.xjppersona.getIdPersona()));
        if (this.JTBRegistroLamada.getRowCount() > 0) {
            ClaseImpresionInformes informes = new ClaseImpresionInformes();
            for (int i = 0; i < this.JTBRegistroLamada.getRowCount(); i++) {
                if (Boolean.valueOf(this.JTBRegistroLamada.getValueAt(i, 0).toString()).booleanValue()) {
                    listaRegistroLlamadaPersonalizada.add(this.listaRegistroLlamada.get(i));
                }
            }
            System.out.println(listaRegistroLlamadaPersonalizada.size());
            informes.imprimirRegistroLlamadas(listaRegistroLlamadaPersonalizada, persona);
        }
    }

    public void mCopiarArchivos(String origen, String destino) {
        try {
            Path FROM = Paths.get(origen, new String[0]);
            Path TO = Paths.get(destino, new String[0]);
            CopyOption[] options = {StandardCopyOption.REPLACE_EXISTING, StandardCopyOption.COPY_ATTRIBUTES};
            Files.copy(FROM, TO, options);
        } catch (IOException ex) {
            Logger.getLogger(JPGestionHC.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mSelecionar(boolean xestado) {
        for (int x = 0; x < this.JTBDetalle.getRowCount(); x++) {
            this.xmodeloatencionessistmatizadas.setValueAt(Boolean.valueOf(xestado), x, 7);
        }
        for (int x2 = 0; x2 < this.JTBAtencionesDigitalizadaas.getRowCount(); x2++) {
            this.xmodeloatencionesdigitalizadas.setValueAt(Boolean.valueOf(xestado), x2, 6);
        }
    }

    public void mBuscar() {
        if (this.xvc == 2 || this.xvc == 3) {
            if (this.JCBEspecialidad.getSelectedIndex() != -1) {
                mCrearTabla();
                mCrearTablaDig();
                mCrearModeloDatosFisioterapia();
                mCrearModeloDatosConsentimientoInformado();
                mCargarDatosTabla();
                mCargarDatosTablaDig();
                mCargarDatosTablaFisioterapia();
                mCargarDatosTriage();
                cargarDatoSeguimientoSaludOcupacional();
                mCargarDatosConsentimientoInformado();
                cargarREgistroLlamadas();
                return;
            }
            JOptionPane.showMessageDialog(this, "Debe seleccionar una especialidad", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
            this.JCBEspecialidad.requestFocus();
            mCrearTablaDig();
            mCrearTabla();
            mCrearModeloDatosFisioterapia();
            mCargarDatosTriage();
            cargarDatoSeguimientoSaludOcupacional();
            mCrearModeloDatosConsentimientoInformado();
            cargarREgistroLlamadas();
            return;
        }
        mCrearTabla();
        mCargarDatosTabla();
        mCrearTablaDig();
        mCargarDatosTablaDig();
        mCrearModeloDatosFisioterapia();
        mCrearModeloDatosConsentimientoInformado();
        mCargarDatosTablaFisioterapia();
        mCargarDatosTriage();
        cargarDatoSeguimientoSaludOcupacional();
        cargarREgistroLlamadas();
    }

    private void mCargarDatosGenerales() {
        this.JDCFechaI.setDate(this.xmt.getFechaActual());
        this.JDCFechaF.setDate(this.xmt.getFechaActual());
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion());
        this.xidespecialidad = this.xconsultasbd.llenarCombo("SELECT Id, Nbre FROM g_especialidad WHERE (Estado =0) ORDER BY Nbre ASC", this.xidespecialidad, this.JCBEspecialidad);
        this.JCBEspecialidad.setSelectedIndex(-1);
        this.JDCFechaI.setEnabled(false);
        this.JDCFechaF.setEnabled(false);
        this.JCBEspecialidad.setEnabled(false);
        if (this.xidentificados == 0) {
            this.JBTRegresa.setVisible(false);
        } else if (this.xidentificados == 1) {
            this.JBTRegresa.setText("Generar");
            this.JBTRegresa.setVisible(true);
        }
        this.xconsultasbd.cerrarConexionBd();
    }

    public void mBuscarDatosHC() {
        mCrearTabla();
        mCargarDatosTabla();
        mCrearTablaDig();
        mCargarDatosTablaDig();
        mCrearModeloDatosFisioterapia();
        mCargarDatosTablaFisioterapia();
        mCrearTablaTriage();
        mCrearModeloDatosConsentimientoInformado();
        mCargarDatosConsentimientoInformado();
        cargarDatoSeguimientoSaludOcupacional();
        cargarREgistroLlamadas();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTabla() {
        this.xmodeloatencionessistmatizadas = new DefaultTableModel(new Object[0], new String[]{"IdA", "Fecha y Hora", "Tipo Consulta", "Profesional", "", "Id_Especialidad", "TipoC", "Descargar", "Tipo_HC", "Especialidad", "Id_Ingreso", "Id_Usuario", "Id_TipoAtencion", "Accion", "EsPrenatal", "IdEcografia", "idTipoHistoria"}) { // from class: Historia.JPGestionHC.23
            Class[] types = {Long.class, String.class, String.class, String.class, String.class, String.class, String.class, Boolean.class, String.class, String.class, String.class, String.class, String.class, JButton.class, String.class, String.class, Integer.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, true, false, false, false, false, false, true, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBDetalle.setDefaultRenderer(JButton.class, new TableCellRenderer() { // from class: Historia.JPGestionHC.24
            public Component getTableCellRendererComponent(JTable jtable, Object objeto, boolean estaSeleccionado, boolean tieneElFoco, int fila, int columna) {
                return (Component) objeto;
            }
        });
        this.JTBDetalle.setModel(this.xmodeloatencionessistmatizadas);
        this.JTBDetalle.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTBDetalle.getColumnModel().getColumn(1).setPreferredWidth(60);
        this.JTBDetalle.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTBDetalle.getColumnModel().getColumn(3).setPreferredWidth(350);
        this.JTBDetalle.getColumnModel().getColumn(4).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(4).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(4).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(5).setPreferredWidth(20);
        this.JTBDetalle.getColumnModel().getColumn(6).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(6).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(6).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(7).setPreferredWidth(10);
        this.JTBDetalle.getColumnModel().getColumn(8).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(8).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(8).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(9).setPreferredWidth(10);
        this.JTBDetalle.getColumnModel().getColumn(10).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(10).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(10).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(11).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(11).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(11).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(12).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(12).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(12).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(13).setPreferredWidth(50);
        this.JTBDetalle.getColumnModel().getColumn(14).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(14).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(14).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(15).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(15).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(15).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(16).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(16).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(16).setMaxWidth(0);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTablaDig() {
        this.xmodeloatencionesdigitalizadas = new DefaultTableModel(new Object[0], new String[]{"IdA", "¨Fecha", "Especialidad", "Profesional", "Tipo Doc", "", "Descargar"}) { // from class: Historia.JPGestionHC.25
            Class[] types = {Long.class, String.class, String.class, String.class, String.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, false, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBAtencionesDigitalizadaas.setModel(this.xmodeloatencionesdigitalizadas);
        this.JTBAtencionesDigitalizadaas.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTBAtencionesDigitalizadaas.getColumnModel().getColumn(1).setPreferredWidth(10);
        this.JTBAtencionesDigitalizadaas.getColumnModel().getColumn(2).setPreferredWidth(50);
        this.JTBAtencionesDigitalizadaas.getColumnModel().getColumn(3).setPreferredWidth(80);
        this.JTBAtencionesDigitalizadaas.getColumnModel().getColumn(4).setPreferredWidth(10);
        this.JTBAtencionesDigitalizadaas.getColumnModel().getColumn(5).setPreferredWidth(200);
        this.JTBAtencionesDigitalizadaas.getColumnModel().getColumn(6).setPreferredWidth(20);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTablaTriage() {
        this.xmodeloTriage = new DefaultTableModel(new Object[0], new String[]{"IdA", "¨IdTriage", "Clasificación", "Fecha", "Hora", "Profesional", "Especialidad"}) { // from class: Historia.JPGestionHC.26
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBTriage.setModel(this.xmodeloTriage);
        this.JTBTriage.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTBTriage.getColumnModel().getColumn(1).setPreferredWidth(10);
        this.JTBTriage.getColumnModel().getColumn(2).setPreferredWidth(20);
        this.JTBTriage.getColumnModel().getColumn(3).setPreferredWidth(20);
        this.JTBTriage.getColumnModel().getColumn(4).setPreferredWidth(20);
        this.JTBTriage.getColumnModel().getColumn(5).setPreferredWidth(150);
        this.JTBTriage.getColumnModel().getColumn(6).setPreferredWidth(150);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearTablaSeguimientoSaludOcupacional() {
        this.modeloSeguimiento = new DefaultTableModel(new Object[0], new String[]{"Id", "¨Fecha", "Nombre Seguimiento", "Observación", "Especialidad", "Profesional"}) { // from class: Historia.JPGestionHC.27
            Class[] types = {Long.class, Date.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTBSeguimientoSO;
        JTable jTable2 = this.JTBSeguimientoSO;
        jTable.setAutoResizeMode(0);
        this.JTBSeguimientoSO.doLayout();
        this.JTBSeguimientoSO.setModel(this.modeloSeguimiento);
        this.JTBSeguimientoSO.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTBSeguimientoSO.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTBSeguimientoSO.getColumnModel().getColumn(2).setPreferredWidth(200);
        this.JTBSeguimientoSO.getColumnModel().getColumn(3).setPreferredWidth(300);
        this.JTBSeguimientoSO.getColumnModel().getColumn(4).setPreferredWidth(150);
        this.JTBSeguimientoSO.getColumnModel().getColumn(5).setPreferredWidth(250);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatosConsentimientoInformado() {
        this.xmodeloConsentimientoInformado = new DefaultTableModel(new Object[0], new String[]{"idConsentimiento", "¨fecha", "tipoConsentimiento", "nombreConsentimiento", "nombreProcedimiento", "Id_Usuario"}) { // from class: Historia.JPGestionHC.28
            Class[] types = {Integer.class, String.class, String.class, String.class, String.class, Integer.class};
            boolean[] canEdit = {false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBConsentimientoInformado.setModel(this.xmodeloConsentimientoInformado);
        this.JTBConsentimientoInformado.getColumnModel().getColumn(0).setPreferredWidth(18);
        this.JTBConsentimientoInformado.getColumnModel().getColumn(1).setPreferredWidth(50);
        this.JTBConsentimientoInformado.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTBConsentimientoInformado.getColumnModel().getColumn(3).setPreferredWidth(200);
        this.JTBConsentimientoInformado.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTBConsentimientoInformado.getColumnModel().getColumn(5).setPreferredWidth(50);
    }

    private void mCargarDatosConsentimientoInformado() {
        try {
            mCrearModeloDatosConsentimientoInformado();
            String sql = "SELECT ici.Id  idConsentimiento, i.FechaIngreso  fecha, ht.Nbre  tipoConsentimiento\n, ici.Encabezado nombreConsentimiento\n, gp.Nbre nombreProcedimiento\n, i.Id_Usuario \nfrom ingreso_consentimiento_informado ici \ninner join ingreso i on (i.Id=ici.Id_Ingreso)\ninner join g_procedimiento gp on (gp.Id=ici.idProcedimiento)\ninner join h_tipoconsentimiento ht on (ht.Id=ici.Id_TipoConsentimiento)\ninner join g_persona gp2 on (gp2.Id=i.Id_Usuario)\nwhere (i.Id_Usuario=" + this.xjppersona.getIdPersona() + " and ici.Estado=1)\norder by fecha desc";
            ResultSet xrs = this.xconsultasbd.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodeloConsentimientoInformado.addRow(this.dato);
                    this.xmodeloConsentimientoInformado.setValueAt(Integer.valueOf(xrs.getInt(1)), n, 0);
                    this.xmodeloConsentimientoInformado.setValueAt(xrs.getDate(2), n, 1);
                    this.xmodeloConsentimientoInformado.setValueAt(xrs.getString(3), n, 2);
                    this.xmodeloConsentimientoInformado.setValueAt(xrs.getString(4), n, 3);
                    this.xmodeloConsentimientoInformado.setValueAt(xrs.getString(5), n, 4);
                    this.xmodeloConsentimientoInformado.setValueAt(Integer.valueOf(xrs.getInt(6)), n, 5);
                    n++;
                }
            }
            xrs.close();
            this.xconsultasbd.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPGestionHC.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatosFisioterapia() {
        this.xmodeloatencionesfisioterapia = new DefaultTableModel(new Object[0], new String[]{"Id", "¨Fecha", "Especialidad", "Profesional", "Estado", "Descargar"}) { // from class: Historia.JPGestionHC.29
            Class[] types = {Integer.class, String.class, String.class, String.class, Boolean.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBAtencionesFisioterapia.setModel(this.xmodeloatencionesfisioterapia);
        this.JTBAtencionesFisioterapia.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTBAtencionesFisioterapia.getColumnModel().getColumn(1).setPreferredWidth(50);
        this.JTBAtencionesFisioterapia.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTBAtencionesFisioterapia.getColumnModel().getColumn(3).setPreferredWidth(200);
        this.JTBAtencionesFisioterapia.getColumnModel().getColumn(4).setPreferredWidth(50);
        this.JTBAtencionesFisioterapia.getColumnModel().getColumn(5).setPreferredWidth(10);
    }

    private void mCargarDatosTriage() {
        try {
            mCrearTablaTriage();
            String sql = "SELECT `h_atencion`.`Id` AS IdAt, `h_triage`.`Id` AS IdTriage  , `h_triage`.`Clasificacion`  , `h_triage`.`FechaTriage`  , `h_triage`.`HoraTriage` , `profesional1`.`NProfesional` , `profesional1`.`Especialidad`  FROM `h_triage` INNER JOIN `baseserver`.`ingreso`   ON (`h_triage`.`IdIngreso` = `ingreso`.`Id`)  INNER JOIN `baseserver`.`h_atencion`   ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)  INNER JOIN `baseserver`.`profesional1`   ON (`profesional1`.`Id_Persona` = `h_triage`.`Id_Profesional`) AND (`profesional1`.`IdEspecialidad` = `h_triage`.`Id_Especialidad`) WHERE (`ingreso`.`Id_Usuario` ='" + this.xjppersona.getIdPersona() + "') ORDER BY `h_triage`.`FechaTriage` DESC";
            ResultSet xrs = this.xconsultasbd.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodeloTriage.addRow(this.dato);
                    this.xmodeloTriage.setValueAt(Integer.valueOf(xrs.getInt(1)), n, 0);
                    this.xmodeloTriage.setValueAt(xrs.getString(2), n, 1);
                    this.xmodeloTriage.setValueAt(xrs.getString(3), n, 2);
                    this.xmodeloTriage.setValueAt(xrs.getString(4), n, 3);
                    this.xmodeloTriage.setValueAt(xrs.getString(5), n, 4);
                    this.xmodeloTriage.setValueAt(xrs.getString(6), n, 5);
                    this.xmodeloTriage.setValueAt(xrs.getString(7), n, 6);
                    n++;
                }
            }
            xrs.close();
            this.xconsultasbd.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPGestionHC.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void cargarDatoSeguimientoSaludOcupacional() {
        try {
            crearTablaSeguimientoSaludOcupacional();
            String sql = "select so_manpower_seguimiento_detalle_s.Id ,\n `so_manpower_seguimiento_detalle_s`.`Fecha_S` fechaSeguimiento\n    , `so_tipo_vigilancia_seguimiento`.`Nbre` nombreSeguimiento\n    , `so_manpower_seguimiento_detalle_s`.`Descrpcion` observacion\n    , `g_especialidad`.`Nbre` especialidad\n    , CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2`,' ',`g_persona`.`Nombre1`,' ', `g_persona`.`Nombre2`) profesional\n    , so_manporwer_detalle.Id_Persona \nFROM\n    `so_manpower_seguimiento`\n    INNER JOIN `so_manporwer_detalle` \n        ON (`so_manpower_seguimiento`.`Id_Manpower_Detalle` = `so_manporwer_detalle`.`Id`)\n    INNER JOIN `so_manpower_seguimiento_detalle` \n        ON (`so_manpower_seguimiento_detalle`.`Id_Mp_Seguimiento` = `so_manpower_seguimiento`.`Id`)\n    INNER JOIN `so_tipo_vigilancia` \n        ON (`so_manpower_seguimiento_detalle`.`Id_Tipo_Vigilancia` = `so_tipo_vigilancia`.`Id`)\n    INNER JOIN `so_manpower_seguimiento_detalle_s` \n        ON (`so_manpower_seguimiento_detalle_s`.`Id_Mp_SDetalle` = `so_manpower_seguimiento_detalle`.`Id`)\n    INNER JOIN `so_vigilancia_seguimiento` \n        ON (`so_manpower_seguimiento_detalle_s`.`Id_Vigilancia_S` = `so_vigilancia_seguimiento`.`Id`)\n    INNER JOIN `g_especialidad` \n        ON (`so_manpower_seguimiento_detalle_s`.`Id_Especialidad` = `g_especialidad`.`Id`)\n    INNER JOIN `so_tipo_vigilancia_seguimiento` \n        ON (`so_vigilancia_seguimiento`.`Id_TV_Seguimiento` = `so_tipo_vigilancia_seguimiento`.`Id`)\n    INNER JOIN `g_persona` \n        ON (`g_persona`.`Id` = `so_manpower_seguimiento_detalle_s`.`Id_Profesional`)\n    WHERE  so_manpower_seguimiento_detalle_s.`Estado`=1 and so_manporwer_detalle.Id_Persona ='" + this.xjppersona.getIdPersona() + "'\n    order by `so_manpower_seguimiento_detalle_s`.`Fecha_S`  desc";
            System.out.println("salud " + sql);
            ResultSet xrs = this.xconsultasbd.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                this.xmt.mEstablecerTextEditor(this.JTBSeguimientoSO, 2);
                this.xmt.mEstablecerTextEditor(this.JTBSeguimientoSO, 3);
                while (xrs.next()) {
                    this.modeloSeguimiento.addRow(this.dato);
                    this.modeloSeguimiento.setValueAt(Long.valueOf(xrs.getLong("Id")), n, 0);
                    this.modeloSeguimiento.setValueAt(xrs.getDate("fechaSeguimiento"), n, 1);
                    this.modeloSeguimiento.setValueAt(xrs.getString("nombreSeguimiento"), n, 2);
                    this.modeloSeguimiento.setValueAt(xrs.getString("observacion"), n, 3);
                    this.modeloSeguimiento.setValueAt(xrs.getString("especialidad"), n, 4);
                    this.modeloSeguimiento.setValueAt(xrs.getString("profesional"), n, 5);
                    n++;
                }
            }
            xrs.close();
            this.xconsultasbd.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPGestionHC.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatosTablaFisioterapia() {
        try {
            mCrearModeloDatosFisioterapia();
            String sql = "SELECT h_atencionf.Id, Date_Format(h_atencionf.FechaHc,'%d-%m-%Y') as Fecha, profesional1.Especialidad, profesional1.NProfesional, h_atencionf.Estado  FROM profesional1 INNER JOIN h_atencionf  ON (profesional1.Id_Persona = h_atencionf.Id_Profesional) AND (profesional1.IdEspecialidad = h_atencionf.Id_Especialidad)  WHERE (h_atencionf.Id_Usuario ='" + this.xjppersona.getIdPersona() + "'  AND `h_atencionf`.`Estado`<>-1)";
            System.out.println("tabla fisioterapia " + sql);
            ResultSet xrs = this.xconsultasbd.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodeloatencionesfisioterapia.addRow(this.dato);
                    this.xmodeloatencionesfisioterapia.setValueAt(Integer.valueOf(xrs.getInt(1)), n, 0);
                    this.xmodeloatencionesfisioterapia.setValueAt(xrs.getString(2), n, 1);
                    this.xmodeloatencionesfisioterapia.setValueAt(xrs.getString(3), n, 2);
                    this.xmodeloatencionesfisioterapia.setValueAt(xrs.getString(4), n, 3);
                    this.xmodeloatencionesfisioterapia.setValueAt(Boolean.valueOf(!xrs.getBoolean(5)), n, 4);
                    this.xmodeloatencionesfisioterapia.setValueAt(true, n, 5);
                    n++;
                }
            }
            xrs.close();
            this.xconsultasbd.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPGestionHC.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatosTabla() {
        try {
            String sql = null;
            switch (this.xvc) {
                case 0:
                    sql = "SELECT h_atencion.Id, DATE_FORMAT(h_atencion.Fecha_Atencion, '%d/%m/%Y') as fecha, DATE_FORMAT(h_atencion.Hora_Atencion, '%h:%i:%s %p') hora, c_clasecita.Nbre, `profesional1`.`NProfesional` , c_clasecita.Id_Historia,  `profesional1`.`IdEspecialidad`, c_clasecita.EsUrgencias, h_tipohistoria.`Reporte`, `profesional1`.`Especialidad` ,ingreso.Id, ingreso.Id_Usuario, ingreso.Id_TipoAtencion, `g_tipoprograma`.`EsPrenatal`, IFNULL(h_ecog_obstetrica.`Id`, 0) IdEcografia, h_tipohistoria.Id idTipoHistoria FROM h_atencion INNER JOIN c_clasecita  ON (h_atencion.Id_ClaseCita = c_clasecita.Id) INNER JOIN `profesional1`  ON (`h_atencion`.`Id_Profesional` = `profesional1`.`Id_Persona`) AND (`h_atencion`.`Id_Especialidad` = `profesional1`.`IdEspecialidad`) INNER JOIN ingreso  ON (h_atencion.Id_Ingreso = ingreso.Id) INNER JOIN `h_tipohistoria`   ON (`c_clasecita`.`Id_Historia` = `h_tipohistoria`.`Id`) INNER JOIN `g_tipoprograma` ON (`g_tipoprograma`.`Id_TipoPrograma`=`c_clasecita`.`Id_Programa`)   LEFT JOIN `h_ecog_obstetrica` ON (`h_ecog_obstetrica`.`Id_Atencion`=`h_atencion`.`Id`) AND (h_ecog_obstetrica.`Estado`=1) WHERE (h_atencion.TipoGuardado in(1,2) and ingreso.Id_Usuario ='" + this.xjppersona.getIdPersona() + "' AND h_atencion.Estado =0 ) ORDER BY h_atencion.Fecha_Atencion DESC ";
                    break;
                case 1:
                    sql = "SELECT h_atencion.Id, DATE_FORMAT(h_atencion.Fecha_Atencion, '%d/%m/%Y') as fecha, DATE_FORMAT(h_atencion.Hora_Atencion, '%h:%i:%s %p') hora, c_clasecita.Nbre, `profesional1`.`NProfesional` , c_clasecita.Id_Historia,  `profesional1`.`IdEspecialidad`, c_clasecita.EsUrgencias , h_tipohistoria.`Reporte`, `profesional1`.`Especialidad` ,ingreso.Id, ingreso.Id_Usuario, ingreso.Id_TipoAtencion, `g_tipoprograma`.`EsPrenatal`, IFNULL(h_ecog_obstetrica.`Id`, 0) IdEcografia, h_tipohistoria.Id idTipoHistoria FROM h_atencion INNER JOIN c_clasecita  ON (h_atencion.Id_ClaseCita = c_clasecita.Id) INNER JOIN `profesional1`  ON (`h_atencion`.`Id_Profesional` = `profesional1`.`Id_Persona`) AND (`h_atencion`.`Id_Especialidad` = `profesional1`.`IdEspecialidad`) INNER JOIN ingreso  ON (h_atencion.Id_Ingreso = ingreso.Id) INNER JOIN `h_tipohistoria`   ON (`c_clasecita`.`Id_Historia` = `h_tipohistoria`.`Id`) INNER JOIN `g_tipoprograma` ON (`g_tipoprograma`.`Id_TipoPrograma`=`c_clasecita`.`Id_Programa`)  LEFT JOIN `h_ecog_obstetrica` ON (`h_ecog_obstetrica`.`Id_Atencion`=`h_atencion`.`Id`) AND (h_ecog_obstetrica.`Estado`=1) WHERE (h_atencion.TipoGuardado in(1,2) and ingreso.Id_Usuario ='" + this.xjppersona.getIdPersona() + "' AND DATE_FORMAT(h_atencion.Fecha_Atencion, '%d/%m/%Y')>='" + this.xmt.formatoDMA.format(this.JDCFechaI.getDate()) + "' AND DATE_FORMAT(h_atencion.Fecha_Atencion, '%d/%m/%Y')<='" + this.xmt.formatoDMA.format(this.JDCFechaF.getDate()) + "' AND h_atencion.Estado =0 ) ORDER BY h_atencion.Fecha_Atencion DESC ";
                    break;
                case 2:
                    sql = "SELECT h_atencion.Id, DATE_FORMAT(h_atencion.Fecha_Atencion, '%d/%m/%Y') as fecha, DATE_FORMAT(h_atencion.Hora_Atencion, '%h:%i:%s %p') hora, c_clasecita.Nbre,`profesional1`.`NProfesional` , c_clasecita.Id_Historia,  `profesional1`.`IdEspecialidad`, c_clasecita.EsUrgencias, h_tipohistoria.`Reporte`, `profesional1`.`Especialidad` ,ingreso.Id, ingreso.Id_Usuario, ingreso.Id_TipoAtencion, `g_tipoprograma`.`EsPrenatal`, IFNULL(h_ecog_obstetrica.`Id`, 0) IdEcografia, h_tipohistoria.Id idTipoHistoria FROM h_atencion INNER JOIN c_clasecita  ON (h_atencion.Id_ClaseCita = c_clasecita.Id) INNER JOIN `profesional1`  ON (`h_atencion`.`Id_Profesional` = `profesional1`.`Id_Persona`) AND (`h_atencion`.`Id_Especialidad` = `profesional1`.`IdEspecialidad`) INNER JOIN ingreso  ON (h_atencion.Id_Ingreso = ingreso.Id) INNER JOIN `h_tipohistoria`   ON (`c_clasecita`.`Id_Historia` = `h_tipohistoria`.`Id`)  INNER JOIN `g_tipoprograma` ON (`g_tipoprograma`.`Id_TipoPrograma`=`c_clasecita`.`Id_Programa`)  LEFT JOIN `h_ecog_obstetrica` ON (`h_ecog_obstetrica`.`Id_Atencion`=`h_atencion`.`Id`) AND (h_ecog_obstetrica.`Estado`=1) WHERE (h_atencion.TipoGuardado in(1,2) and ingreso.Id_Usuario ='" + this.xjppersona.getIdPersona() + "' AND ingreso.Id_Especialidad='" + this.xidespecialidad[this.JCBEspecialidad.getSelectedIndex()] + "' AND h_atencion.Estado =0 ) ORDER BY h_atencion.Fecha_Atencion DESC ";
                    break;
                case 3:
                    sql = "SELECT h_atencion.Id, DATE_FORMAT(h_atencion.Fecha_Atencion, '%d/%m/%Y') as fecha, DATE_FORMAT(h_atencion.Hora_Atencion, '%h:%i:%s %p') hora, c_clasecita.Nbre, `profesional1`.`NProfesional` , c_clasecita.Id_Historia,  `profesional1`.`IdEspecialidad`, c_clasecita.EsUrgencias , h_tipohistoria.`Reporte`, `profesional1`.`Especialidad`,ingreso.Id, ingreso.Id_Usuario, ingreso.Id_TipoAtencion, `g_tipoprograma`.`EsPrenatal`, IFNULL(h_ecog_obstetrica.`Id`, 0) IdEcografia, h_tipohistoria.Id idTipoHistoria FROM h_atencion INNER JOIN c_clasecita  ON (h_atencion.Id_ClaseCita = c_clasecita.Id) INNER JOIN `profesional1`  ON (`h_atencion`.`Id_Profesional` = `profesional1`.`Id_Persona`) AND (`h_atencion`.`Id_Especialidad` = `profesional1`.`IdEspecialidad`) INNER JOIN ingreso  ON (h_atencion.Id_Ingreso = ingreso.Id) INNER JOIN `h_tipohistoria`   ON (`c_clasecita`.`Id_Historia` = `h_tipohistoria`.`Id`) INNER JOIN `g_tipoprograma` ON (`g_tipoprograma`.`Id_TipoPrograma`=`c_clasecita`.`Id_Programa`)  LEFT JOIN `h_ecog_obstetrica` ON (`h_ecog_obstetrica`.`Id_Atencion`=`h_atencion`.`Id`) AND (h_ecog_obstetrica.`Estado`=1) WHERE (h_atencion.TipoGuardado in(1,2) and ingreso.Id_Usuario ='" + this.xjppersona.getIdPersona() + "' AND ingreso.Id_Especialidad='" + this.xidespecialidad[this.JCBEspecialidad.getSelectedIndex()] + "' AND DATE_FORMAT(h_atencion.Fecha_Atencion, '%d/%m/%Y')>='" + this.xmt.formatoDMA.format(this.JDCFechaI.getDate()) + "' AND DATE_FORMAT(h_atencion.Fecha_Atencion, '%d/%m/%Y')<='" + this.xmt.formatoDMA.format(this.JDCFechaF.getDate()) + "' AND h_atencion.Estado =0 ) ORDER BY h_atencion.Fecha_Atencion DESC ";
                    break;
            }
            mCrearTabla();
            ResultSet rs = this.xconsultasbd.traerRs(sql);
            Throwable th = null;
            try {
                try {
                    rs.next();
                    if (rs.getRow() != 0) {
                        rs.beforeFirst();
                        int i = 0;
                        while (rs.next()) {
                            this.xmodeloatencionessistmatizadas.addRow(this.dato);
                            this.xmodeloatencionessistmatizadas.setValueAt(Long.valueOf(rs.getLong(1)), i, 0);
                            this.xmodeloatencionessistmatizadas.setValueAt(rs.getString(2) + " " + rs.getString(3), i, 1);
                            this.xmodeloatencionessistmatizadas.setValueAt(rs.getString(4), i, 2);
                            this.xmodeloatencionessistmatizadas.setValueAt(rs.getString(5), i, 3);
                            this.xmodeloatencionessistmatizadas.setValueAt(rs.getString(6), i, 4);
                            this.xmodeloatencionessistmatizadas.setValueAt(rs.getString(7), i, 5);
                            this.xmodeloatencionessistmatizadas.setValueAt(Long.valueOf(rs.getLong(8)), i, 6);
                            this.xmodeloatencionessistmatizadas.setValueAt(true, i, 7);
                            this.xmodeloatencionessistmatizadas.setValueAt(rs.getString(9), i, 8);
                            this.xmodeloatencionessistmatizadas.setValueAt(rs.getString(10), i, 9);
                            this.xmodeloatencionessistmatizadas.setValueAt(rs.getString(11), i, 10);
                            this.xmodeloatencionessistmatizadas.setValueAt(rs.getString(12), i, 11);
                            this.xmodeloatencionessistmatizadas.setValueAt(rs.getString("Id_TipoAtencion"), i, 12);
                            this.xmodeloatencionessistmatizadas.setValueAt(new JButton("Imprimir"), i, 13);
                            this.xmodeloatencionessistmatizadas.setValueAt(rs.getString("EsPrenatal"), i, 14);
                            this.xmodeloatencionessistmatizadas.setValueAt(rs.getString("IdEcografia"), i, 15);
                            this.xmodeloatencionessistmatizadas.setValueAt(Integer.valueOf(rs.getInt("idTipoHistoria")), i, 16);
                            i++;
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
                    this.xconsultasbd.cerrarConexionBd();
                } finally {
                }
            } catch (Throwable th3) {
                th = th3;
                throw th3;
            }
        } catch (SQLException ex) {
            Logger.getLogger(JPGestionHC.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatosTablaDig() {
        try {
            String sql = null;
            if (this.xvc == 0) {
                sql = "SELECT h_atencionesmanuales.Id, DATE_FORMAT(h_atencionesmanuales.Fecha_Atencion, '%d/%m/%Y') as fecha, g_especialidad.Nbre, profesional.NProfesional, h_tipodocumentoshc.Nbre, h_atencionesmanuales.Url  FROM profesional INNER JOIN h_atencionesmanuales  ON (profesional.Id_Persona = h_atencionesmanuales.Id_Profesional)INNER JOIN g_especialidad  ON (h_atencionesmanuales.Id_Especialidad = g_especialidad.Id) INNER JOIN h_tipodocumentoshc  ON (h_atencionesmanuales.Id_TipoDoc = h_tipodocumentoshc.Id)  WHERE (h_atencionesmanuales.Id_Usuario ='" + this.xjppersona.getIdPersona() + "' and h_atencionesmanuales.Estado=0) ORDER BY h_atencionesmanuales.Fecha_Atencion ASC";
            } else if (this.xvc == 1) {
                sql = "SELECT h_atencionesmanuales.Id, h_atencionesmanuales.Fecha_Atencion, g_especialidad.Nbre, profesional.NProfesional, h_tipodocumentoshc.Nbre, h_atencionesmanuales.Url FROM profesional INNER JOIN h_atencionesmanuales  ON (profesional.Id_Persona = h_atencionesmanuales.Id_Profesional) INNER JOIN g_especialidad  ON (h_atencionesmanuales.Id_Especialidad = g_especialidad.Id) INNER JOIN h_tipodocumentoshc  ON (h_atencionesmanuales.Id_TipoDoc = h_tipodocumentoshc.Id) WHERE (h_atencionesmanuales.Id_Usuario ='" + this.xjppersona.getIdPersona() + "' and h_atencionesmanuales.Estado=0 AND h_atencionesmanuales.Fecha_Atencion >='" + this.xmt.formatoAMD.format(this.JDCFechaI.getDate()) + "' AND h_atencionesmanuales.Fecha_Atencion <='" + this.xmt.formatoAMD.format(this.JDCFechaF.getDate()) + "') ORDER BY h_atencionesmanuales.Fecha_Atencion ASC ";
            } else if (this.xvc == 2) {
                sql = "SELECT h_atencionesmanuales.Id, h_atencionesmanuales.Fecha_Atencion, g_especialidad.Nbre, profesional.NProfesional, h_tipodocumentoshc.Nbre, h_atencionesmanuales.Url FROM profesional INNER JOIN h_atencionesmanuales  ON (profesional.Id_Persona = h_atencionesmanuales.Id_Profesional) INNER JOIN g_especialidad  ON (h_atencionesmanuales.Id_Especialidad = g_especialidad.Id) INNER JOIN h_tipodocumentoshc  ON (h_atencionesmanuales.Id_TipoDoc = h_tipodocumentoshc.Id) WHERE (h_atencionesmanuales.Id_Usuario ='" + this.xjppersona.getIdPersona() + "' and h_atencionesmanuales.Estado=0 and h_atencionesmanuales.Id_Especialidad='" + this.xidespecialidad[this.JCBEspecialidad.getSelectedIndex()] + "') ORDER BY h_atencionesmanuales.Fecha_Atencion ASC ";
            } else if (this.xvc == 3) {
                sql = "SELECT h_atencionesmanuales.Id, h_atencionesmanuales.Fecha_Atencion, g_especialidad.Nbre, profesional.NProfesional, h_tipodocumentoshc.Nbre, h_atencionesmanuales.Url FROM profesional INNER JOIN h_atencionesmanuales  ON (profesional.Id_Persona = h_atencionesmanuales.Id_Profesional) INNER JOIN g_especialidad  ON (h_atencionesmanuales.Id_Especialidad = g_especialidad.Id) INNER JOIN h_tipodocumentoshc  ON (h_atencionesmanuales.Id_TipoDoc = h_tipodocumentoshc.Id) WHERE (h_atencionesmanuales.Id_Usuario ='" + this.xjppersona.getIdPersona() + "' and h_atencionesmanuales.Estado=0 AND h_atencionesmanuales.Fecha_Atencion >='" + this.xmt.formatoAMD.format(this.JDCFechaI.getDate()) + "' AND h_atencionesmanuales.Fecha_Atencion <='" + this.xmt.formatoAMD.format(this.JDCFechaF.getDate()) + "' and h_atencionesmanuales.Id_Especialidad='" + this.xidespecialidad[this.JCBEspecialidad.getSelectedIndex()] + "') ORDER BY h_atencionesmanuales.Fecha_Atencion ASC ";
            }
            ResultSet rs = this.xconsultasbd.traerRs(sql);
            mCrearTablaDig();
            rs.next();
            if (rs.getRow() != 0) {
                rs.beforeFirst();
                int i = 0;
                while (rs.next()) {
                    this.xmodeloatencionesdigitalizadas.addRow(this.dato);
                    this.xmodeloatencionesdigitalizadas.setValueAt(Long.valueOf(rs.getLong(1)), i, 0);
                    this.xmodeloatencionesdigitalizadas.setValueAt(rs.getString(2), i, 1);
                    this.xmodeloatencionesdigitalizadas.setValueAt(rs.getString(3), i, 2);
                    this.xmodeloatencionesdigitalizadas.setValueAt(rs.getString(4), i, 3);
                    this.xmodeloatencionesdigitalizadas.setValueAt(rs.getString(5), i, 4);
                    this.xmodeloatencionesdigitalizadas.setValueAt(rs.getString(6), i, 5);
                    this.xmodeloatencionesdigitalizadas.setValueAt(true, i, 6);
                    i++;
                }
            }
            rs.close();
            this.xconsultasbd.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPGestionHC.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void nuevo() {
        this.JTBTodas.setSelected(true);
        this.xjppersona.nuevo();
        this.JDCFechaI.setDate(this.xmt.getFechaActual());
        this.JDCFechaF.setDate(this.xmt.getFechaActual());
        this.JCBEspecialidad.setSelectedIndex(-1);
        this.xidusuario = "0";
        mCrearTabla();
        mCrearTablaDig();
        mCrearModeloDatosFisioterapia();
        this.xjppersona.txtHistoria.requestFocus();
        mCrearTablaTriage();
        mCrearModeloDatosConsentimientoInformado();
    }

    public void mGenerarPDF(String nbreArchivo, String[][] parametros, String narch, String ruta) {
        Connection con = this.xconsultasbd.establecerConexionBd();
        Map parametro = new HashMap();
        for (int i = 0; i < parametros.length; i++) {
            try {
                parametro.put(parametros[i][0], parametros[i][1]);
            } catch (Exception e) {
            }
        }
        String archivoreporte = this.xmt.getRutaRep() + nbreArchivo + ".jrxml";
        JasperReport report = JasperCompileManager.compileReport(archivoreporte);
        JasperPrint print = JasperFillManager.fillReport(report, parametro, con);
        String narchivop = ruta + this.xmt.getBarra() + narch + ".pdf";
        JasperExportManager.exportReportToPdfFile(print, narchivop);
        this.xconsultasbd.cerrarConexionBd();
    }

    public void mRecuperarBlob(String sql, String xrutal, String xarchivo) throws SQLException, IOException {
        FileOutputStream fos = null;
        ResultSet rs = null;
        try {
            try {
                rs = this.xconsultasbd.traerRs(sql);
                if (rs.next()) {
                    String pathname = xrutal + "\\" + xarchivo + ".pdf";
                    File file = new File(pathname);
                    fos = new FileOutputStream(file);
                    Blob bin = rs.getBlob(1);
                    InputStream inStream = bin.getBinaryStream();
                    int size = (int) bin.length();
                    byte[] buffer = new byte[size];
                    while (true) {
                        int length = inStream.read(buffer);
                        if (length == -1) {
                            break;
                        } else {
                            fos.write(buffer, 0, length);
                        }
                    }
                }
                if (fos != null) {
                    fos.close();
                }
                if (rs != null) {
                    rs.close();
                }
                this.xconsultasbd.cerrarConexionBd();
            } catch (IOException ioe) {
                throw new IOException(ioe.getMessage());
            }
        } catch (Throwable th) {
            if (fos != null) {
                fos.close();
            }
            if (rs != null) {
                rs.close();
            }
            throw th;
        }
    }

    private void realizarcasting(JInternalFrame frm) {
        if (frm.getName().equals("jifconsultarhistorial") || frm.getName().equals("jifconsultarhistorial1")) {
            this.xjifch = (JIFConsultarHistorial) frm;
            this.frmllamador = "Consultar Historial";
            mCargasPanelUsuario(this.xjifch);
        }
    }

    private void mCargasPanelUsuario(JInternalFrame frm) {
        this.xjppersona = new Persona(frm);
        this.xjppersona.setVisible(true);
        this.JPIDUsuario.setVisible(false);
        this.xjppersona.setBounds(1, 1, 1000, 160);
        this.JPIDUsuario.add(this.xjppersona);
        this.JPIDUsuario.setVisible(true);
    }

    private void exportaAPDFLasFormulas() {
        try {
            ConsultasMySQL xct = new ConsultasMySQL();
            String xsql = "SELECT `h_ordenes`.`Id`,  h_atencion.`Id` AS IdAtencion \nFROM `h_itemordenessum` \nINNER JOIN `h_ordenes` ON (`h_itemordenessum`.`Id_HOrdenes` = `h_ordenes`.`Id`) \nINNER JOIN `h_atencion` ON (`h_atencion`.`Id` = `h_ordenes`.`Id_Atencion`) \nINNER JOIN `ingreso` ON (`ingreso`.`Id` =`h_atencion`.`Id_Ingreso`)\n WHERE (`h_ordenes`.`Estado` =0  AND `ingreso`.`Id_Usuario` ='" + this.xjppersona.getIdPersona() + "') \nGROUP BY `h_ordenes`.`Id` \nORDER BY `h_ordenes`.`Id` ASC ";
            ResultSet xrs = xct.traerRs(xsql);
            if (xrs.next()) {
                File directorio3 = new File(this.JTFRuta.getText() + "HC_" + this.xjppersona.txtHistoria.getText() + this.xmt.getBarra() + "Ordenes" + this.xmt.getBarra() + "FARMACIA" + this.xmt.getBarra());
                if (!directorio3.exists()) {
                    directorio3.mkdirs();
                    xrs.beforeFirst();
                    while (xrs.next()) {
                        SimpleDateFormat xfechar = new SimpleDateFormat("dd/MM/yyyy");
                        String xnotasad = null;
                        String sql = "SELECT Id_Atencion, Id, FechaOrden FROM h_ordenes where Id='" + xrs.getString(1) + "'";
                        ConsultasMySQL xct1 = new ConsultasMySQL();
                        ResultSet rsm = xct1.traerRs(sql);
                        rsm.first();
                        long xida = rsm.getLong(1);
                        if (rsm.getRow() != 0) {
                            ConsultasMySQL xct2 = new ConsultasMySQL();
                            String sql2 = "SELECT Id_Atencion, Id, FechaOrden FROM  h_ordenes where  Id_Atencion='" + xida + "' and Id>'" + xrs.getString(1) + "' order by Id";
                            rsm = xct2.traerRs(sql2);
                            if (rsm.next()) {
                                xnotasad = "Orden N° : " + rsm.getInt(2) + "  - - - Fecha Proxima Entrega : " + xfechar.format((Date) rsm.getDate(3));
                            }
                            xct2.cerrarConexionBd();
                        }
                        rsm.close();
                        xct1.cerrarConexionBd();
                        String[][] mparametros = new String[6][2];
                        mparametros[0][0] = "norden";
                        mparametros[0][1] = xrs.getString(1);
                        mparametros[1][0] = "xp2";
                        mparametros[1][1] = "Farmacia";
                        mparametros[2][0] = "ip";
                        mparametros[2][1] = xnotasad;
                        mparametros[3][0] = "nusuarios";
                        mparametros[3][1] = Principal.usuarioSistemaDTO.getLogin();
                        mparametros[4][0] = "SUBREPORT_DIR";
                        mparametros[4][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
                        mparametros[5][0] = "SUBREPORTFIRMA_DIR";
                        mparametros[5][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
                        if (Principal.informacionIps.getEsFpz().intValue() == 0) {
                            ConsultasMySQL xct3 = new ConsultasMySQL();
                            String xsql2 = "SELECT  `g_relacionlaboral`.`Id` FROM  `h_ordenes` INNER JOIN`h_atencion`  ON (`h_ordenes`.`Id_Atencion` = `h_atencion`.`Id`) INNER JOIN`ingreso`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN`g_usuario`  ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`) INNER JOIN`g_usuario_fpz`  ON (`g_usuario_fpz`.`Id_Persona` = `g_usuario`.`Id_persona`) INNER JOIN`g_relacionlaboral`  ON (`g_usuario_fpz`.`Id_RelacionLaboral` = `g_relacionlaboral`.`Id`) WHERE (`h_ordenes`.`Id` ='" + xrs.getString(1) + "') ";
                            ResultSet xrs1 = xct3.traerRs(xsql2);
                            if (xrs1.next()) {
                                xrs1.first();
                                if (xrs.getInt(1) == 1) {
                                    mGenerarPDF("RFormulaGeneralMP", mparametros, xrs.getString(2) + "_" + xrs.getString(1), directorio3.getPath());
                                } else {
                                    mGenerarPDF("RFormulaGeneralMP_Directivos", mparametros, xrs.getString(2) + "_" + xrs.getString(1), directorio3.getPath());
                                }
                            }
                            xrs1.close();
                            xct3.cerrarConexionBd();
                        } else if (Principal.informacionIps.getTipoReporteImprimir().intValue() == 1) {
                            mGenerarPDF("RFormulaGeneralMP1", mparametros, xrs.getString(2) + "_" + xrs.getString(1), directorio3.getPath());
                        } else if (Principal.informacionIps.getTipoReporteImprimir().intValue() == 2) {
                            if (Principal.informacionIps.getNombreIps().equals("CLINICA OFTALMOLOGICA DAJUD SAS") || Principal.informacionIps.getNombreIps().equals("COD-OPTICA UT") || Principal.informacionIps.getNombreIps().equals("JAIME CESAR DAJUD FERNANDEZ")) {
                                mGenerarPDF("RFormulaGeneralMP2_CDajud", mparametros, xrs.getString(2) + "_" + xrs.getString(1), directorio3.getPath());
                            } else if (Principal.informacionIps.getNombreIps().equals("CLINICA LAURELES PSIQUIATRAS ASOCIADOS I.P.S. S.A.S.") || Principal.informacionIps.getNombreIps().equals("UNION TEMPORAL CLINICA LAURELES")) {
                                mGenerarPDF("RFormulaGeneralMP2_CPsiquiatras", mparametros, xrs.getString(2) + "_" + xrs.getString(1), directorio3.getPath());
                            } else if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL LOCAL DE MONTELIBANO")) {
                                mGenerarPDF("RFormulaGeneralMP_Hospital", mparametros, xrs.getString(2) + "_" + xrs.getString(1), directorio3.getPath());
                            } else if (Principal.informacionIps.getIdentificacion().equals("812005644")) {
                                mGenerarPDF("RFormulaGeneralMP2_San_Jorge", mparametros, xrs.getString(2) + "_" + xrs.getString(1), directorio3.getPath());
                            } else {
                                mGenerarPDF("RFormulaGeneralMP2", mparametros, xrs.getString(2) + "_" + xrs.getString(1), directorio3.getPath());
                            }
                        }
                    }
                }
            }
            xrs.close();
            xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPI_Control_Impresion.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void exportaAPDFLasOrdenes() {
        try {
            ConsultasMySQL xct = new ConsultasMySQL();
            String xsql = "SELECT  `h_ordenes`.`Id` AS `Id_Orden` , `h_ordenes`.`Id_TipoServicio` ,  h_atencion.`Id` AS IdAtencion, f_tiposervicio.`Nbre` AS TipoServicio\nFROM `h_itemordenesproced` \nINNER JOIN  `h_ordenes`  ON (`h_itemordenesproced`.`Id_HOrdenes` = `h_ordenes`.`Id`) \nINNER JOIN `f_tiposervicio` ON (h_ordenes.`Id_TipoServicio` = f_tiposervicio.`Id`)\nINNER JOIN `h_atencion` ON (`h_atencion`.`Id` = `h_ordenes`.`Id_Atencion`) \nINNER JOIN `ingreso` ON (`ingreso`.`Id` =`h_atencion`.`Id_Ingreso`)\nWHERE (`h_ordenes`.`Estado` =0  AND `ingreso`.`Id_Usuario` ='" + this.xjppersona.getIdPersona() + "') \nGROUP BY `Id_Orden` ORDER BY `Id_Orden` ASC ";
            ResultSet xrs = xct.traerRs(xsql);
            if (xrs.next()) {
                File directorio = new File(this.JTFRuta.getText() + "HC_" + this.xjppersona.txtHistoria.getText() + this.xmt.getBarra() + "Ordenes" + this.xmt.getBarra());
                if (!directorio.exists()) {
                    directorio.mkdirs();
                }
                xrs.beforeFirst();
                ConsultasMySQL xct1 = new ConsultasMySQL();
                while (xrs.next()) {
                    File directorio2 = new File(this.JTFRuta.getText() + "HC_" + this.xjppersona.txtHistoria.getText() + this.xmt.getBarra() + "Ordenes" + this.xmt.getBarra() + xrs.getString("TipoServicio") + this.xmt.getBarra());
                    if (!directorio2.exists()) {
                        directorio2.mkdirs();
                    }
                    if (xrs.getInt(2) == 2) {
                        String xpeso = "";
                        String xtalla = "";
                        String xnstiker = "1";
                        String xsql1 = "SELECT h_examenfisico.Talla , h_examenfisico.Peso  FROM h_examenfisico INNER JOIN h_atencion  ON (h_examenfisico.Id_Atencion = h_atencion.Id) INNER JOIN h_ordenes  ON (h_ordenes.Id_Atencion = h_atencion.Id) INNER JOIN h_itemordenesproced  ON (h_itemordenesproced.Id_HOrdenes = h_ordenes.Id) INNER JOIN g_procedimiento  ON (h_itemordenesproced.Id_Procedimiento = g_procedimiento.Id) WHERE (h_examenfisico.Talla <>0 AND h_examenfisico.Peso <>0 AND h_ordenes.Id ='" + xrs.getString(1) + "' AND h_ordenes.Id_TipoServicio =2 AND g_procedimiento.RPrevios IS NOT NULL) ";
                        ResultSet xrs1 = xct1.traerRs(xsql1);
                        if (xrs1.next()) {
                            xrs1.first();
                            xtalla = xrs1.getString(1);
                            xpeso = xrs1.getString(2);
                        }
                        xrs1.close();
                        xct1.cerrarConexionBd();
                        String xsql12 = "SELECT l_tipomuestra.Id FROM h_ordenes INNER JOIN h_atencion  ON (h_ordenes.Id_Atencion = h_atencion.Id) INNER JOIN h_itemordenesproced  ON (h_itemordenesproced.Id_HOrdenes = h_ordenes.Id) INNER JOIN g_procedimiento  ON (h_itemordenesproced.Id_Procedimiento = g_procedimiento.Id) INNER JOIN l_tipomuestra  ON (g_procedimiento.Id_TipoMuestra = l_tipomuestra.Id) WHERE (h_ordenes.Id ='" + xrs.getString(1) + "') GROUP BY l_tipomuestra.Id ORDER BY h_ordenes.Id ASC ";
                        ResultSet rs = xct1.traerRs(xsql12);
                        if (rs.next()) {
                            rs.last();
                            xnstiker = String.valueOf(rs.getRow());
                        }
                        rs.close();
                        xct1.cerrarConexionBd();
                        String[][] mparametros = new String[6][2];
                        mparametros[0][0] = "idorden";
                        mparametros[0][1] = xrs.getString(1);
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
                            mGenerarPDF(this.xmt.getRutaRep() + "RProcedimientosL", mparametros, xrs.getString("IdAtencion") + "_" + xrs.getString("Id_Orden"), directorio2.getPath());
                        } else if (Principal.informacionIps.getTipoReporteImprimir().intValue() == 1) {
                            if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL LOCAL DE MONTELIBANO")) {
                                mGenerarPDF("RProcedimientosL_1_Hospital", mparametros, xrs.getString("IdAtencion") + "_" + xrs.getString("Id_Orden"), directorio2.getPath());
                            } else {
                                mGenerarPDF("RProcedimientosL1", mparametros, xrs.getString("IdAtencion") + "_" + xrs.getString("Id_Orden"), directorio2.getPath());
                            }
                        } else if (Principal.informacionIps.getTipoReporteImprimir().intValue() == 2) {
                            if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL LOCAL DE MONTELIBANO")) {
                                mGenerarPDF("RProcedimientosL_1_Hospital", mparametros, xrs.getString("IdAtencion") + "_" + xrs.getString("Id_Orden"), directorio2.getPath());
                            } else {
                                mGenerarPDF("RProcedimientosL2", mparametros, xrs.getString("IdAtencion") + "_" + xrs.getString("Id_Orden"), directorio2.getPath());
                            }
                        }
                    } else {
                        String sql = "SELECT h_atencion.Motivo_Atencion, h_ordenes.Id FROM h_ordenes INNER JOIN h_atencion ON (h_ordenes.Id_Atencion = h_atencion.Id) where h_ordenes.Id='" + xrs.getString(1) + "'";
                        String nota = xct1.traerDato(sql);
                        xct1.cerrarConexionBd();
                        String horario = "";
                        if (xrs.getInt(2) == 3) {
                            horario = "Horario de Atencion:\nLunes a Jueves:  6:30 A.M - 4:30 P.M\nViernes:  6:30 A.M - 1:00 P.M";
                        }
                        String[][] mparametros2 = new String[6][2];
                        mparametros2[0][0] = "idorden";
                        mparametros2[0][1] = xrs.getString(1);
                        mparametros2[1][0] = "idservicio";
                        mparametros2[1][1] = xrs.getString(2);
                        mparametros2[2][0] = "nota";
                        mparametros2[2][1] = nota;
                        mparametros2[3][0] = "horario";
                        mparametros2[3][1] = horario;
                        mparametros2[4][0] = "SUBREPORT_DIR";
                        mparametros2[4][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
                        mparametros2[5][0] = "SUBREPORTFIRMA_DIR";
                        mparametros2[5][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
                        if (Principal.informacionIps.getEsFpz().intValue() == 0) {
                            mGenerarPDF("RProcedimientosO", mparametros2, xrs.getString("IdAtencion") + "_" + xrs.getString("Id_Orden"), directorio2.getPath());
                        } else if (Principal.informacionIps.getTipoReporteImprimir().intValue() == 1) {
                            if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL LOCAL DE MONTELIBANO")) {
                                mGenerarPDF("RProcedimientosO_Hospital", mparametros2, xrs.getString("IdAtencion") + "_" + xrs.getString("Id_Orden"), directorio2.getPath());
                            } else {
                                mGenerarPDF("RProcedimientosO1", mparametros2, xrs.getString("IdAtencion") + "_" + xrs.getString("Id_Orden"), directorio2.getPath());
                            }
                        } else if (Principal.informacionIps.getTipoReporteImprimir().intValue() == 2) {
                            if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL LOCAL DE MONTELIBANO")) {
                                mGenerarPDF("RProcedimientosO_Hospital", mparametros2, xrs.getString("IdAtencion") + "_" + xrs.getString("Id_Orden"), directorio2.getPath());
                            } else {
                                mGenerarPDF("RProcedimientosO2", mparametros2, xrs.getString("IdAtencion") + "_" + xrs.getString("Id_Orden"), directorio2.getPath());
                            }
                        }
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(JPI_Control_Impresion.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
