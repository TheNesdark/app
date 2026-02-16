package Historia;

import Acceso.Principal;
import General.BuscarPersona;
import General.Persona;
import Utilidades.Autocomplete;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.genoma.plus.dao.historia.HistoriaDAO;
import com.genoma.plus.dao.impl.historia.HistoriaDAOImpl;
import com.genoma.plus.dao.impl.laboratorio.ImpresionReportesDAOImpl;
import com.genoma.plus.dao.impl.laboratorio.LaboratorioDAOImpl;
import com.genoma.plus.dao.laboratorio.LaboratorioDAO;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.JTextComponent;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:Historia/JIFConsultarHAyudasDx.class */
public class JIFConsultarHAyudasDx extends JInternalFrame {
    public String xusuario;
    private DefaultTableModel xmodelo;
    private DefaultTableModel xmodelo1;
    private DefaultTableModel xmodeloEsp;
    private Object[] dato;
    private String[] xidtipodx;
    public Persona xjppersona;
    private LaboratorioDAO xImplLabotaorio;
    private HistoriaDAO xImplHistoria;
    private ButtonGroup JBROpciones;
    private JButton JBTConsultar;
    private JComboBox JCBAyudaDx;
    public JDateChooser JDCFechaF;
    public JDateChooser JDCFechaI;
    private JPanel JPIDUsuario;
    private JPanel JPIDatosBusqueda;
    private JPanel JPIOpciones;
    private JRadioButton JRBEspecFecha;
    private JRadioButton JRBEspecialidad;
    private JRadioButton JRBIFechas;
    private JScrollPane JSPDetalleConsulta;
    private JScrollPane JSPDetalleExaEspe;
    private JPanel JSPExamenEspecializado;
    private JScrollPane JSPResultado;
    private JTable JTBDetalle;
    private JTable JTBDetalleExaEsp;
    private JTable JTBResultado;
    private JRadioButton JTBTodas;
    private JTabbedPane JTPDatos;
    public String xidusuario = "0";
    private int xvc = 0;
    private ConsultasMySQL xconsultasbd = new ConsultasMySQL();
    private Metodos xmetodos = new Metodos();

    public JIFConsultarHAyudasDx() {
        initComponents();
        this.JDCFechaI.setDate(this.xmetodos.getFechaActual());
        this.JDCFechaF.setDate(this.xmetodos.getFechaActual());
        this.xidtipodx = this.xconsultasbd.llenarCombo("SELECT Id, Nbre FROM baseserver.h_tipoayudadx WHERE (Estado =0) ORDER BY Nbre ASC", this.xidtipodx, this.JCBAyudaDx);
        this.JCBAyudaDx.setEditable(true);
        JTextComponent editor = this.JCBAyudaDx.getEditor().getEditorComponent();
        editor.setDocument(new Autocomplete(this.JCBAyudaDx));
        this.JCBAyudaDx.setSelectedIndex(-1);
        this.JDCFechaI.setEnabled(false);
        this.JDCFechaF.setEnabled(false);
        this.JCBAyudaDx.setEnabled(false);
        this.xconsultasbd.cerrarConexionBd();
        mCargasPanelUsuario();
        mCrearTabla();
        mCrearTabla1();
    }

    private void springStart() {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"});
        this.xImplLabotaorio = (LaboratorioDAOImpl) classPathXmlApplicationContext.getBean("laboratorioDAOImpl");
        this.xImplHistoria = (HistoriaDAOImpl) classPathXmlApplicationContext.getBean("historiaDAOImpl");
    }

    /* JADX WARN: Type inference failed for: r3v60, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBROpciones = new ButtonGroup();
        this.JPIDUsuario = new JPanel();
        this.JPIDatosBusqueda = new JPanel();
        this.JPIOpciones = new JPanel();
        this.JTBTodas = new JRadioButton();
        this.JRBIFechas = new JRadioButton();
        this.JRBEspecialidad = new JRadioButton();
        this.JRBEspecFecha = new JRadioButton();
        this.JDCFechaI = new JDateChooser();
        this.JDCFechaF = new JDateChooser();
        this.JCBAyudaDx = new JComboBox();
        this.JBTConsultar = new JButton();
        this.JTPDatos = new JTabbedPane();
        this.JSPDetalleConsulta = new JScrollPane();
        this.JTBDetalle = new JTable();
        this.JSPResultado = new JScrollPane();
        this.JTBResultado = new JTable();
        this.JSPExamenEspecializado = new JPanel();
        this.JSPDetalleExaEspe = new JScrollPane();
        this.JTBDetalleExaEsp = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("CONSULTAR AYUDAS DIAGNÓSTICAS");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifconsultarhistorialadx");
        setPreferredSize(new Dimension(1100, 800));
        this.JPIDUsuario.setBorder(BorderFactory.createEtchedBorder());
        GroupLayout JPIDUsuarioLayout = new GroupLayout(this.JPIDUsuario);
        this.JPIDUsuario.setLayout(JPIDUsuarioLayout);
        JPIDUsuarioLayout.setHorizontalGroup(JPIDUsuarioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 0, 32767));
        JPIDUsuarioLayout.setVerticalGroup(JPIDUsuarioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 218, 32767));
        this.JPIDatosBusqueda.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS PARA BÚSQUEDA", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JPIOpciones.setBorder(BorderFactory.createTitledBorder((Border) null, "OPCIONES", 0, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.JBROpciones.add(this.JTBTodas);
        this.JTBTodas.setFont(new Font("Arial", 1, 12));
        this.JTBTodas.setForeground(Color.blue);
        this.JTBTodas.setSelected(true);
        this.JTBTodas.setText("Todas");
        this.JTBTodas.addActionListener(new ActionListener() { // from class: Historia.JIFConsultarHAyudasDx.1
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarHAyudasDx.this.JTBTodasActionPerformed(evt);
            }
        });
        this.JBROpciones.add(this.JRBIFechas);
        this.JRBIFechas.setFont(new Font("Arial", 1, 12));
        this.JRBIFechas.setForeground(Color.blue);
        this.JRBIFechas.setText("Intervalos de Fecha");
        this.JRBIFechas.addActionListener(new ActionListener() { // from class: Historia.JIFConsultarHAyudasDx.2
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarHAyudasDx.this.JRBIFechasActionPerformed(evt);
            }
        });
        this.JBROpciones.add(this.JRBEspecialidad);
        this.JRBEspecialidad.setFont(new Font("Arial", 1, 12));
        this.JRBEspecialidad.setForeground(Color.blue);
        this.JRBEspecialidad.setText("Tipo de Ayuda");
        this.JRBEspecialidad.addActionListener(new ActionListener() { // from class: Historia.JIFConsultarHAyudasDx.3
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarHAyudasDx.this.JRBEspecialidadActionPerformed(evt);
            }
        });
        this.JBROpciones.add(this.JRBEspecFecha);
        this.JRBEspecFecha.setFont(new Font("Arial", 1, 12));
        this.JRBEspecFecha.setForeground(Color.blue);
        this.JRBEspecFecha.setText("Tipo de Ayuda y Fecha");
        this.JRBEspecFecha.addActionListener(new ActionListener() { // from class: Historia.JIFConsultarHAyudasDx.4
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarHAyudasDx.this.JRBEspecFechaActionPerformed(evt);
            }
        });
        GroupLayout JPIOpcionesLayout = new GroupLayout(this.JPIOpciones);
        this.JPIOpciones.setLayout(JPIOpcionesLayout);
        JPIOpcionesLayout.setHorizontalGroup(JPIOpcionesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIOpcionesLayout.createSequentialGroup().addContainerGap().addGroup(JPIOpcionesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIOpcionesLayout.createSequentialGroup().addComponent(this.JTBTodas).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 114, 32767).addComponent(this.JRBEspecialidad).addGap(80, 80, 80)).addGroup(JPIOpcionesLayout.createSequentialGroup().addComponent(this.JRBIFechas).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 38, 32767).addComponent(this.JRBEspecFecha).addGap(36, 36, 36)))));
        JPIOpcionesLayout.setVerticalGroup(JPIOpcionesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIOpcionesLayout.createSequentialGroup().addContainerGap().addGroup(JPIOpcionesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTBTodas).addComponent(this.JRBEspecialidad)).addGap(18, 18, 18).addGroup(JPIOpcionesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JRBIFechas).addComponent(this.JRBEspecFecha)).addContainerGap(12, 32767)));
        this.JDCFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicio", 0, 0, new Font("Arial", 1, 11), Color.blue));
        this.JDCFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaI.setFont(new Font("Arial", 1, 12));
        this.JDCFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicio", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JDCFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaF.setFont(new Font("Arial", 1, 12));
        this.JCBAyudaDx.setFont(new Font("Arial", 1, 12));
        this.JCBAyudaDx.setBorder(BorderFactory.createTitledBorder((Border) null, "Ayuda Dx", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JBTConsultar.setFont(new Font("Arial", 1, 12));
        this.JBTConsultar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTConsultar.setText("Consultar");
        this.JBTConsultar.addActionListener(new ActionListener() { // from class: Historia.JIFConsultarHAyudasDx.5
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarHAyudasDx.this.JBTConsultarActionPerformed(evt);
            }
        });
        GroupLayout JPIDatosBusquedaLayout = new GroupLayout(this.JPIDatosBusqueda);
        this.JPIDatosBusqueda.setLayout(JPIDatosBusquedaLayout);
        JPIDatosBusquedaLayout.setHorizontalGroup(JPIDatosBusquedaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosBusquedaLayout.createSequentialGroup().addContainerGap().addComponent(this.JPIOpciones, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIDatosBusquedaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosBusquedaLayout.createSequentialGroup().addComponent(this.JDCFechaI, -2, 159, -2).addGap(26, 26, 26).addComponent(this.JDCFechaF, -2, 159, -2).addGap(46, 46, 46).addComponent(this.JBTConsultar, -1, -1, 32767)).addComponent(this.JCBAyudaDx, 0, -1, 32767)).addContainerGap()));
        JPIDatosBusquedaLayout.setVerticalGroup(JPIDatosBusquedaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosBusquedaLayout.createSequentialGroup().addGroup(JPIDatosBusquedaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosBusquedaLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosBusquedaLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JDCFechaF, -2, 0, 32767).addComponent(this.JDCFechaI, -1, -1, 32767).addComponent(this.JBTConsultar, -1, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBAyudaDx, -1, 45, 32767)).addComponent(this.JPIOpciones, -1, -1, 32767)).addContainerGap()));
        this.JTPDatos.setForeground(new Color(0, 103, 0));
        this.JTPDatos.setFont(new Font("Arial", 1, 14));
        this.JSPDetalleConsulta.setAutoscrolls(true);
        this.JTBDetalle.setFont(new Font("Arial", 1, 12));
        this.JTBDetalle.setRowHeight(25);
        this.JTBDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTBDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTBDetalle.setSelectionMode(0);
        this.JTBDetalle.addMouseListener(new MouseAdapter() { // from class: Historia.JIFConsultarHAyudasDx.6
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarHAyudasDx.this.JTBDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalleConsulta.setViewportView(this.JTBDetalle);
        this.JTPDatos.addTab("AYUDAS DX DIGITALIZADAS", this.JSPDetalleConsulta);
        this.JSPResultado.setAutoscrolls(true);
        this.JSPResultado.setEnabled(false);
        this.JTBResultado.setFont(new Font("Arial", 1, 12));
        this.JTBResultado.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTBResultado.setAutoResizeMode(4);
        this.JTBResultado.setRowHeight(25);
        this.JTBResultado.setSelectionBackground(new Color(255, 255, 255));
        this.JTBResultado.setSelectionForeground(new Color(255, 0, 0));
        this.JTBResultado.setSelectionMode(0);
        this.JTBResultado.addMouseListener(new MouseAdapter() { // from class: Historia.JIFConsultarHAyudasDx.7
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarHAyudasDx.this.JTBResultadoMouseClicked(evt);
            }
        });
        this.JSPResultado.setViewportView(this.JTBResultado);
        this.JTPDatos.addTab("EXÁMENES SISTEMATIZADOS", this.JSPResultado);
        this.JSPDetalleExaEspe.setAutoscrolls(true);
        this.JTBDetalleExaEsp.setFont(new Font("Arial", 1, 12));
        this.JTBDetalleExaEsp.setRowHeight(25);
        this.JTBDetalleExaEsp.setSelectionBackground(new Color(255, 255, 255));
        this.JTBDetalleExaEsp.setSelectionForeground(new Color(255, 0, 0));
        this.JTBDetalleExaEsp.addMouseListener(new MouseAdapter() { // from class: Historia.JIFConsultarHAyudasDx.8
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarHAyudasDx.this.JTBDetalleExaEspMouseClicked(evt);
            }
        });
        this.JSPDetalleExaEspe.setViewportView(this.JTBDetalleExaEsp);
        GroupLayout JSPExamenEspecializadoLayout = new GroupLayout(this.JSPExamenEspecializado);
        this.JSPExamenEspecializado.setLayout(JSPExamenEspecializadoLayout);
        JSPExamenEspecializadoLayout.setHorizontalGroup(JSPExamenEspecializadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 1061, 32767).addGroup(JSPExamenEspecializadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JSPExamenEspecializadoLayout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.JSPDetalleExaEspe, -2, 1061, -2).addGap(0, 0, 32767))));
        JSPExamenEspecializadoLayout.setVerticalGroup(JSPExamenEspecializadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 328, 32767).addGroup(JSPExamenEspecializadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JSPExamenEspecializadoLayout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.JSPDetalleExaEspe, -2, 328, -2).addGap(0, 0, 32767))));
        this.JTPDatos.addTab("EXÁMENES ESPECIALIZADOS", this.JSPExamenEspecializado);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JTPDatos, GroupLayout.Alignment.LEADING).addComponent(this.JPIDatosBusqueda, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JPIDUsuario, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addContainerGap(-1, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDUsuario, -1, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPIDatosBusqueda, -2, -1, -2).addGap(18, 18, 18).addComponent(this.JTPDatos, -2, 359, -2).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBDetalleMouseClicked(MouseEvent evt) {
        if (this.JTBDetalle.getSelectedRow() != -1 && this.JTBDetalle.getValueAt(this.JTBDetalle.getSelectedRow(), 0) != null) {
            if (Principal.informacionIps.getEsFpz().intValue() == 0) {
                this.xmetodos.mostrarPdf(this.xmodelo1.getValueAt(this.JTBDetalle.getSelectedRow(), 5).toString());
            } else {
                this.xmetodos.mostrarPdf(this.xmetodos.mRutaSoporte("JPEscaneoDocumentosEnf") + "\\" + this.xmodelo1.getValueAt(this.JTBDetalle.getSelectedRow(), 5).toString());
            }
            Principal.mGrabarLogAtenciones(this.JTBDetalle.getValueAt(this.JTBDetalle.getSelectedRow(), 2).toString().toUpperCase() + " DIGITALIZADO", this.JTBDetalle.getValueAt(this.JTBDetalle.getSelectedRow(), 0).toString(), this.xjppersona.getIdPersona());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBTodasActionPerformed(ActionEvent evt) {
        this.xvc = 0;
        this.JDCFechaI.setEnabled(false);
        this.JDCFechaF.setEnabled(false);
        this.JCBAyudaDx.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBIFechasActionPerformed(ActionEvent evt) {
        this.xvc = 1;
        this.JDCFechaI.setEnabled(true);
        this.JDCFechaF.setEnabled(true);
        this.JCBAyudaDx.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBEspecialidadActionPerformed(ActionEvent evt) {
        this.xvc = 2;
        this.JDCFechaI.setEnabled(false);
        this.JDCFechaF.setEnabled(false);
        this.JCBAyudaDx.setEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBEspecFechaActionPerformed(ActionEvent evt) {
        this.xvc = 3;
        this.JDCFechaI.setEnabled(true);
        this.JDCFechaF.setEnabled(true);
        this.JCBAyudaDx.setEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTConsultarActionPerformed(ActionEvent evt) {
        if (this.xvc == 2 || this.xvc == 3) {
            if (this.JCBAyudaDx.getSelectedIndex() != -1) {
                mCargarDatos();
                mCargarDatos1();
                mCargarDatosEspecializados();
                return;
            } else {
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una tipo de ayuda dx", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                this.JCBAyudaDx.requestFocus();
                mCrearTabla();
                return;
            }
        }
        mCargarDatos1();
        mCargarDatos();
        mCargarDatosEspecializados();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloExaEsp() {
        this.xmodeloEsp = new DefaultTableModel(new Object[0], new String[]{"FechaRec", "FechaRes", "Especialidad", "Profesional", "Exámen", "Alterado?", "Revisado?", "", "IdRecep", "", "", "Idprocedimiento", "Remitido", "Imprimir?", "No. Orden", "Ingreso"}) { // from class: Historia.JIFConsultarHAyudasDx.9
            Class[] types = {String.class, String.class, String.class, String.class, String.class, Boolean.class, Boolean.class, Long.class, Long.class, Integer.class, String.class, Long.class, Boolean.class, Boolean.class, Integer.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBDetalleExaEsp.setModel(this.xmodeloEsp);
        this.JTBDetalleExaEsp.getColumnModel().getColumn(0).setPreferredWidth(40);
        this.JTBDetalleExaEsp.getColumnModel().getColumn(1).setPreferredWidth(40);
        this.JTBDetalleExaEsp.getColumnModel().getColumn(2).setPreferredWidth(60);
        this.JTBDetalleExaEsp.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTBDetalleExaEsp.getColumnModel().getColumn(4).setPreferredWidth(200);
        this.JTBDetalleExaEsp.getColumnModel().getColumn(5).setPreferredWidth(20);
        this.JTBDetalleExaEsp.getColumnModel().getColumn(6).setPreferredWidth(20);
        this.JTBDetalleExaEsp.getColumnModel().getColumn(7).setPreferredWidth(0);
        this.JTBDetalleExaEsp.getColumnModel().getColumn(7).setMinWidth(0);
        this.JTBDetalleExaEsp.getColumnModel().getColumn(7).setMaxWidth(0);
        this.JTBDetalleExaEsp.getColumnModel().getColumn(8).setPreferredWidth(0);
        this.JTBDetalleExaEsp.getColumnModel().getColumn(8).setMinWidth(0);
        this.JTBDetalleExaEsp.getColumnModel().getColumn(8).setMaxWidth(0);
        this.JTBDetalleExaEsp.getColumnModel().getColumn(9).setPreferredWidth(0);
        this.JTBDetalleExaEsp.getColumnModel().getColumn(9).setMinWidth(0);
        this.JTBDetalleExaEsp.getColumnModel().getColumn(9).setMaxWidth(0);
        this.JTBDetalleExaEsp.getColumnModel().getColumn(10).setPreferredWidth(0);
        this.JTBDetalleExaEsp.getColumnModel().getColumn(10).setMinWidth(0);
        this.JTBDetalleExaEsp.getColumnModel().getColumn(10).setMaxWidth(0);
        this.JTBDetalleExaEsp.getColumnModel().getColumn(11).setPreferredWidth(0);
        this.JTBDetalleExaEsp.getColumnModel().getColumn(11).setMinWidth(0);
        this.JTBDetalleExaEsp.getColumnModel().getColumn(11).setMaxWidth(0);
        this.JTBDetalleExaEsp.getColumnModel().getColumn(12).setPreferredWidth(0);
        this.JTBDetalleExaEsp.getColumnModel().getColumn(12).setMinWidth(0);
        this.JTBDetalleExaEsp.getColumnModel().getColumn(12).setMaxWidth(0);
        this.JTBDetalleExaEsp.getColumnModel().getColumn(13).setPreferredWidth(0);
        this.JTBDetalleExaEsp.getColumnModel().getColumn(13).setMinWidth(0);
        this.JTBDetalleExaEsp.getColumnModel().getColumn(13).setMaxWidth(0);
        this.JTBDetalleExaEsp.getColumnModel().getColumn(14).setPreferredWidth(10);
        this.JTBDetalleExaEsp.getColumnModel().getColumn(15).setPreferredWidth(0);
        this.JTBDetalleExaEsp.getColumnModel().getColumn(15).setMinWidth(0);
        this.JTBDetalleExaEsp.getColumnModel().getColumn(15).setMaxWidth(0);
    }

    public void mCargarDatosEspecializados() {
        try {
            String sql = "SELECT DATE_FORMAT(FechaRecep,'%d-%m-%Y') AS FechaRP, DATE_FORMAT(l_detallerecepcion.FechaResultado,'%d-%m-%Y') AS FechaRs, profesional1.Especialidad, profesional1.NProfesional , g_procedimiento.Nbre, l_detallerecepcion.`Alterado` as Alterado,  IF(l_detallerecepcion.Id_Atencion<>0,1,0)AS Revisado, 0, l_recepcion.Id, 1,  l_detallerecepcion.NArchivo, l_detallerecepcion.Id_Procedim, g_procedimiento.EsRemitido,l_recepcion.`Id`, `f_ordenes`.`Id_Ingreso` FROM l_detallerecepcion  INNER JOIN l_recepcion  ON (l_detallerecepcion.Id_Recepcion = l_recepcion.Id)  INNER JOIN profesional1  ON (profesional1.IdEspecialidad = l_recepcion.Id_Especialidad)  AND (profesional1.Id_Persona = l_recepcion.Id_Profesional)   INNER JOIN g_procedimiento  ON (l_detallerecepcion.Id_Procedim = g_procedimiento.Id) INNER JOIN `f_ordenes` ON (`l_recepcion`.`Id_OrdenFacturac` = f_ordenes.Id) WHERE (l_recepcion.Id_Paciente ='" + this.xjppersona.getIdPersona() + "' AND l_detallerecepcion.validadolab=1 AND l_detallerecepcion.NArchivo<>'')   GROUP BY l_recepcion.Id, g_procedimiento.Nbre ORDER BY FechaRP DESC, FechaRs DESC, l_recepcion.Id ASC         ";
            ResultSet rs = this.xconsultasbd.traerRs(sql);
            if (rs.next()) {
                rs.beforeFirst();
                int filaGrid = 0;
                mCrearModeloExaEsp();
                while (rs.next()) {
                    this.xmodeloEsp.addRow(this.dato);
                    this.xmodeloEsp.setValueAt(rs.getString(1), filaGrid, 0);
                    this.xmodeloEsp.setValueAt(rs.getString(2), filaGrid, 1);
                    this.xmodeloEsp.setValueAt(rs.getString(3), filaGrid, 2);
                    this.xmodeloEsp.setValueAt(rs.getString(4), filaGrid, 3);
                    this.xmodeloEsp.setValueAt(rs.getString(5), filaGrid, 4);
                    this.xmodeloEsp.setValueAt(Boolean.valueOf(rs.getBoolean(6)), filaGrid, 5);
                    this.xmodeloEsp.setValueAt(Boolean.valueOf(rs.getBoolean(7)), filaGrid, 6);
                    this.xmodeloEsp.setValueAt(Long.valueOf(rs.getLong(8)), filaGrid, 7);
                    this.xmodeloEsp.setValueAt(Long.valueOf(rs.getLong(9)), filaGrid, 8);
                    this.JTBResultado.setDefaultRenderer(Object.class, new MiRender());
                    this.xmodeloEsp.setValueAt(Integer.valueOf(rs.getInt(10)), filaGrid, 9);
                    this.xmodeloEsp.setValueAt(rs.getString(11), filaGrid, 10);
                    this.xmodeloEsp.setValueAt(Long.valueOf(rs.getLong(12)), filaGrid, 11);
                    this.xmodeloEsp.setValueAt(Boolean.valueOf(rs.getBoolean(13)), filaGrid, 12);
                    this.xmodeloEsp.setValueAt(false, filaGrid, 13);
                    this.xmodeloEsp.setValueAt(Integer.valueOf(rs.getInt(14)), filaGrid, 14);
                    this.xmodeloEsp.setValueAt(rs.getString(15), filaGrid, 15);
                    filaGrid++;
                }
            }
            rs.close();
            this.xconsultasbd.cerrarConexionBd();
        } catch (Exception ex) {
            Logger.getLogger(JIFConsultarHAyudasDx.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBResultadoMouseClicked(MouseEvent evt) {
        if (this.JTBResultado.getSelectedRow() != -1) {
            Object[] botones = {"Por orden de recepción", "Por tipo resultado", "Cerrar"};
            int n = JOptionPane.showInternalOptionDialog(this, "Que desea hacer", "IMPRIMIR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones, "Cerrar");
            String[][] strArr = new String[4][2];
            ImpresionReportesDAOImpl impresion = new ImpresionReportesDAOImpl();
            if (n == 0) {
                impresion.mImprimirResultado(this.xmodelo.getValueAt(this.JTBResultado.getSelectedRow(), 8).toString(), "", this.xmetodos.getSO() + this.xmetodos.getBarra() + "Reportes" + this.xmetodos.getBarra(), this.xmetodos.getSO() + this.xmetodos.getBarra() + "Firmas" + this.xmetodos.getBarra(), true, this.xjppersona.getIdPersona(), true);
                Principal.mGrabarLogAtenciones("RESULTADO DE LABORATORIO CLINICO SISTEMATIZA", this.xmodelo.getValueAt(this.JTBResultado.getSelectedRow(), 8).toString(), this.xjppersona.getIdPersona());
                this.xconsultasbd.cerrarConexionBd();
                if (this.xmodelo.getValueAt(this.JTBResultado.getSelectedRow(), 9).toString().equals("1")) {
                    int x = JOptionPane.showInternalConfirmDialog(this, "Examen con soporte externo;\n Desea visualizarlo?", "VISUALIZACIÓN ADICIONAL", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    if (x == 0) {
                        this.xmetodos.mostrarPdf(this.xmodelo.getValueAt(this.JTBResultado.getSelectedRow(), 10).toString());
                        return;
                    }
                    return;
                }
                return;
            }
            if (n == 1) {
                impresion.mImprimirResultado(this.xmodelo.getValueAt(this.JTBResultado.getSelectedRow(), 8).toString(), this.xmodelo.getValueAt(this.JTBResultado.getSelectedRow(), 7).toString(), this.xmetodos.getSO() + this.xmetodos.getBarra() + "Reportes" + this.xmetodos.getBarra(), this.xmetodos.getSO() + this.xmetodos.getBarra() + "Firmas" + this.xmetodos.getBarra(), true, this.xjppersona.getIdPersona(), true);
                Principal.mGrabarLogAtenciones("RESULTADO DE LABORATORIO CLINICO SISTEMATIZA", this.xmodelo.getValueAt(this.JTBResultado.getSelectedRow(), 8).toString(), this.xjppersona.getIdPersona());
                if (this.xmodelo.getValueAt(this.JTBResultado.getSelectedRow(), 9).toString().equals("1")) {
                    int x2 = JOptionPane.showInternalConfirmDialog(this, "Examen con soporte externo;\n Desea visualizarlo?", "VISUALIZACIÓN ADICIONAL", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    if (x2 == 0) {
                        this.xmetodos.mostrarPdf(this.xmodelo.getValueAt(this.JTBResultado.getSelectedRow(), 10).toString());
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBDetalleExaEspMouseClicked(MouseEvent evt) {
        if (this.JTBDetalleExaEsp.getSelectedRow() != -1 && Principal.informacionIps.getEsFpz().intValue() == 0) {
            Object[] botones = {"Por orden de recepción", "Por tipo resultado", "Cerrar"};
            int n = JOptionPane.showInternalOptionDialog(this, "Que desea hacer", "IMPRIMIR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones, "Cerrar");
            if (n == 0) {
                String[][] parametros = new String[4][2];
                parametros[0][0] = "id";
                parametros[0][1] = this.xmodeloEsp.getValueAt(this.JTBDetalleExaEsp.getSelectedRow(), 8).toString();
                parametros[1][0] = "profesional";
                parametros[1][1] = "";
                parametros[2][0] = "SUBREPORT_DIR";
                parametros[2][1] = this.xmetodos.getSO() + this.xmetodos.getBarra() + "Reportes" + this.xmetodos.getBarra();
                parametros[3][0] = "SUBREPORTFIRMA_DIR";
                parametros[3][1] = this.xmetodos.getSO() + this.xmetodos.getBarra() + "Firmas" + this.xmetodos.getBarra();
                if (this.xmodeloEsp.getValueAt(this.JTBDetalleExaEsp.getSelectedRow(), 9).toString().equals("1")) {
                    this.xmetodos.mostrarPdf(this.xmodeloEsp.getValueAt(this.JTBDetalleExaEsp.getSelectedRow(), 10).toString());
                    return;
                }
                this.xmetodos.GenerarPDF(this.xmetodos.getRutaRep() + "L_Resultados", parametros);
                this.xconsultasbd.cerrarConexionBd();
                Principal.mGrabarLogAtenciones("RESULTADO DE LABORATORIO CLINICO SISTEMATIZA", this.xmodeloEsp.getValueAt(this.JTBDetalleExaEsp.getSelectedRow(), 8).toString(), this.xjppersona.getIdPersona());
                return;
            }
            if (n == 1) {
                String[][] parametros2 = new String[5][2];
                parametros2[0][0] = "id";
                parametros2[0][1] = this.xmodeloEsp.getValueAt(this.JTBDetalleExaEsp.getSelectedRow(), 8).toString();
                parametros2[1][0] = "profesional";
                parametros2[1][1] = "";
                parametros2[2][0] = "idprocedimiento";
                parametros2[2][1] = this.xmodeloEsp.getValueAt(this.JTBDetalleExaEsp.getSelectedRow(), 11).toString();
                parametros2[3][0] = "SUBREPORT_DIR";
                parametros2[3][1] = this.xmetodos.getSO() + this.xmetodos.getBarra() + "Reportes" + this.xmetodos.getBarra();
                parametros2[4][0] = "SUBREPORTFIRMA_DIR";
                parametros2[4][1] = this.xmetodos.getSO() + this.xmetodos.getBarra() + "Firmas" + this.xmetodos.getBarra();
                if (this.xmodeloEsp.getValueAt(this.JTBDetalleExaEsp.getSelectedRow(), 9).toString().equals("1")) {
                    this.xmetodos.mostrarPdf(this.xmodeloEsp.getValueAt(this.JTBDetalleExaEsp.getSelectedRow(), 10).toString());
                    return;
                }
                if (Boolean.valueOf(this.xmodeloEsp.getValueAt(this.JTBDetalleExaEsp.getSelectedRow(), 12).toString()).booleanValue()) {
                    this.xmetodos.GenerarPDF(this.xmetodos.getRutaRep() + "L_Resultados_Id_Proced_Especializado", parametros2);
                    Principal.mGrabarLogAtenciones("RESULTADO DE LABORATORIO CLINICO SISTEMATIZA", this.xmodeloEsp.getValueAt(this.JTBDetalleExaEsp.getSelectedRow(), 8).toString(), this.xjppersona.getIdPersona());
                } else {
                    this.xmetodos.GenerarPDF(this.xmetodos.getRutaRep() + "L_Resultados_Id_Proced3", parametros2);
                    Principal.mGrabarLogAtenciones("RESULTADO DE LABORATORIO CLINICO SISTEMATIZA", this.xmodeloEsp.getValueAt(this.JTBDetalleExaEsp.getSelectedRow(), 8).toString(), this.xjppersona.getIdPersona());
                }
                this.xconsultasbd.cerrarConexionBd();
            }
        }
    }

    public void buscar() {
        BuscarPersona frmBuscar = new BuscarPersona(null, true, this.xjppersona);
        frmBuscar.setVisible(true);
    }

    public void nuevo() {
        this.xjppersona.nuevo();
        this.JDCFechaI.setDate(this.xmetodos.getFechaActual());
        this.JDCFechaF.setDate(this.xmetodos.getFechaActual());
        mCrearTabla();
        this.xjppersona.txtHistoria.requestFocus();
    }

    private void mCargasPanelUsuario() {
        this.xjppersona = new Persona(this);
        this.xjppersona.setVisible(true);
        this.JPIDUsuario.setVisible(false);
        this.xjppersona.setBounds(1, 1, 1000, 160);
        this.JPIDUsuario.add(this.xjppersona);
        this.JPIDUsuario.setVisible(true);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTabla1() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"FechaRec", "FechaRes", "Especialidad", "Profesional", "Exámen", "Alterado?", "Revisado?", "", "", "", ""}) { // from class: Historia.JIFConsultarHAyudasDx.10
            Class[] types = {String.class, String.class, String.class, String.class, String.class, Boolean.class, Boolean.class, Long.class, Long.class, Integer.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
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
        this.JTBResultado.getColumnModel().getColumn(8).setMinWidth(0);
        this.JTBResultado.getColumnModel().getColumn(8).setMaxWidth(0);
        this.JTBResultado.getColumnModel().getColumn(9).setPreferredWidth(0);
        this.JTBResultado.getColumnModel().getColumn(9).setMinWidth(0);
        this.JTBResultado.getColumnModel().getColumn(9).setMaxWidth(0);
        this.JTBResultado.getColumnModel().getColumn(10).setPreferredWidth(0);
        this.JTBResultado.getColumnModel().getColumn(10).setMinWidth(0);
        this.JTBResultado.getColumnModel().getColumn(10).setMaxWidth(0);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTabla() {
        this.xmodelo1 = new DefaultTableModel(new Object[0], new String[]{"Id", "Fecha", "Tipo", "Profesional", "Revisado?", "Url"}) { // from class: Historia.JIFConsultarHAyudasDx.11
            Class[] types = {Long.class, String.class, String.class, String.class, Boolean.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBDetalle.setModel(this.xmodelo1);
        this.JTBDetalle.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTBDetalle.getColumnModel().getColumn(1).setPreferredWidth(40);
        this.JTBDetalle.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTBDetalle.getColumnModel().getColumn(3).setPreferredWidth(300);
        this.JTBDetalle.getColumnModel().getColumn(4).setPreferredWidth(20);
        this.JTBDetalle.getColumnModel().getColumn(5).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(5).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(5).setMaxWidth(0);
    }

    private void mCargarDatos() {
        try {
            String sql = null;
            if (this.xvc == 0) {
                sql = "SELECT h_resultadoayudasdx.Id , DATE_FORMAT(h_resultadoayudasdx.Fecha_Examen, '%d-%m-%Y') as fecha, h_tipoayudadx.Nbre , profesional.NProfesional, h_tipoayudadx.Estado, h_resultadoayudasdx.Url FROM baseserver.h_resultadoayudasdx INNER JOIN baseserver.h_tipoayudadx  ON (h_resultadoayudasdx.Id_TipoAyudaDX = h_tipoayudadx.Id) INNER JOIN baseserver.profesional  ON (profesional.Id_Persona = h_resultadoayudasdx.Id_Profesional) WHERE (h_resultadoayudasdx.Id_Usuario ='" + this.xjppersona.getIdPersona() + "' and h_resultadoayudasdx.Anulado=0 ) order by h_tipoayudadx.Nbre, h_resultadoayudasdx.Fecha_Examen desc";
            } else if (this.xvc == 1) {
                sql = "SELECT h_resultadoayudasdx.Id , DATE_FORMAT(h_resultadoayudasdx.Fecha_Examen, '%d-%m-%Y') as fecha, h_tipoayudadx.Nbre , profesional.NProfesional, h_tipoayudadx.Estado, h_resultadoayudasdx.Url FROM baseserver.h_resultadoayudasdx INNER JOIN baseserver.h_tipoayudadx  ON (h_resultadoayudasdx.Id_TipoAyudaDX = h_tipoayudadx.Id) INNER JOIN baseserver.profesional  ON (profesional.Id_Persona = h_resultadoayudasdx.Id_Profesional) WHERE (h_resultadoayudasdx.Id_Usuario ='" + this.xjppersona.getIdPersona() + "' and DATE_FORMAT(h_resultadoayudasdx.Fecha_Examen, '%d/%m/%Y')>='" + this.xmetodos.formatoDMA.format(this.JDCFechaI.getDate()) + "' and h_resultadoayudasdx.Anulado=0 and DATE_FORMAT(h_resultadoayudasdx.Fecha_Examen, '%d/%m/%Y')<='" + this.xmetodos.formatoDMA.format(this.JDCFechaI.getDate()) + "') order by h_tipoayudadx.Nbre, h_resultadoayudasdx.Fecha_Examen desc";
            } else if (this.xvc == 2) {
                sql = "SELECT h_resultadoayudasdx.Id , DATE_FORMAT(h_resultadoayudasdx.Fecha_Examen, '%d-%m-%Y') as fecha, h_tipoayudadx.Nbre , profesional.NProfesional, h_tipoayudadx.Estado, h_resultadoayudasdx.Url FROM baseserver.h_resultadoayudasdx INNER JOIN baseserver.h_tipoayudadx  ON (h_resultadoayudasdx.Id_TipoAyudaDX = h_tipoayudadx.Id) INNER JOIN baseserver.profesional  ON (profesional.Id_Persona = h_resultadoayudasdx.Id_Profesional) WHERE (h_resultadoayudasdx.Id_Usuario ='" + this.xjppersona.getIdPersona() + "' and h_resultadoayudasdx.Anulado=0 and h_resultadoayudasdx.Id_TipoAyudaDX='" + this.xidtipodx[this.JCBAyudaDx.getSelectedIndex()] + "') order by h_tipoayudadx.Nbre, h_resultadoayudasdx.Fecha_Examen desc ";
            } else if (this.xvc == 3) {
                sql = "SELECT h_resultadoayudasdx.Id , DATE_FORMAT(h_resultadoayudasdx.Fecha_Examen, '%d-%m-%Y') as fecha, h_tipoayudadx.Nbre , profesional.NProfesional, h_tipoayudadx.Estado, h_resultadoayudasdx.Url FROM baseserver.h_resultadoayudasdx INNER JOIN baseserver.h_tipoayudadx  ON (h_resultadoayudasdx.Id_TipoAyudaDX = h_tipoayudadx.Id) INNER JOIN baseserver.profesional  ON (profesional.Id_Persona = h_resultadoayudasdx.Id_Profesional) WHERE (h_resultadoayudasdx.Id_Usuario ='" + this.xjppersona.getIdPersona() + "' and DATE_FORMAT(h_resultadoayudasdx.Fecha_Examen, '%d/%m/%Y')>='" + this.xmetodos.formatoDMA.format(this.JDCFechaI.getDate()) + "' and DATE_FORMAT(h_resultadoayudasdx.Fecha_Examen, '%d/%m/%Y')<='" + this.xmetodos.formatoDMA.format(this.JDCFechaI.getDate()) + "' and h_resultadoayudasdx.Anulado=0 and h_resultadoayudasdx.Id_TipoAyudaDX='" + this.xidtipodx[this.JCBAyudaDx.getSelectedIndex()] + "') order by h_tipoayudadx.Nbre, h_resultadoayudasdx.Fecha_Examen desc ";
            }
            ResultSet rs = this.xconsultasbd.traerRs(sql);
            if (rs.next()) {
                rs.beforeFirst();
                int filaGrid = 0;
                mCrearTabla();
                while (rs.next()) {
                    this.xmodelo1.addRow(this.dato);
                    this.xmodelo1.setValueAt(Long.valueOf(rs.getLong(1)), filaGrid, 0);
                    this.xmodelo1.setValueAt(rs.getString(2), filaGrid, 1);
                    this.xmodelo1.setValueAt(rs.getString(3), filaGrid, 2);
                    this.xmodelo1.setValueAt(rs.getString(4), filaGrid, 3);
                    this.xmodelo1.setValueAt(Boolean.valueOf(rs.getBoolean(5)), filaGrid, 4);
                    this.xmodelo1.setValueAt(rs.getString(6), filaGrid, 5);
                    filaGrid++;
                }
            }
            rs.close();
            this.xconsultasbd.cerrarConexionBd();
        } catch (Exception ex) {
            Logger.getLogger(JIFConsultarHAyudasDx.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatos1() {
        try {
            mCrearTabla1();
            String sql = "SELECT DATE_FORMAT(FechaRecep,'%d-%m-%Y') AS FechaRP, DATE_FORMAT(FechaResult,'%d-%m-%Y') AS FechaRs, profesional1.Especialidad, profesional1.NProfesional , g_procedimiento.Nbre, l_detallerecepcion.Alterado, IF(l_detallerecepcion.Id_Atencion<>0,1,0)AS Revisado, l_resultados.Id, l_recepcion.Id, l_resultados.Soporte, l_resultados.Url FROM baseserver.l_detallerecepcion INNER JOIN baseserver.l_recepcion  ON (l_detallerecepcion.Id_Recepcion = l_recepcion.Id) INNER JOIN baseserver.profesional1  ON (profesional1.IdEspecialidad = l_recepcion.Id_Especialidad) AND (profesional1.Id_Persona = l_recepcion.Id_Profesional)  INNER JOIN baseserver.l_resultados  ON (l_resultados.Id_Recepcion = l_recepcion.Id) INNER JOIN baseserver.l_detalleresultado  ON (l_detalleresultado.Id_Resultado = l_resultados.Id) INNER JOIN baseserver.g_procedimiento  ON (l_detallerecepcion.Id_Procedim = g_procedimiento.Id) INNER JOIN baseserver.l_protocoloxprocedimiento  ON (l_protocoloxprocedimiento.Id_Procedim = g_procedimiento.Id) AND (l_detalleresultado.Id_ProtocolProcedim = l_protocoloxprocedimiento.Id) WHERE (l_recepcion.Id_Paciente ='" + this.xjppersona.getIdPersona() + "' and l_detallerecepcion.validadolab=1)  GROUP BY l_recepcion.Id, g_procedimiento.Nbre ORDER BY FechaRecep DESC, FechaRs DESC, l_recepcion.Id ASC ";
            ResultSet rs = this.xconsultasbd.traerRs(sql);
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
                    filaGrid++;
                }
            }
            rs.close();
            this.xconsultasbd.cerrarConexionBd();
        } catch (Exception ex) {
            Logger.getLogger(JIFConsultarHAyudasDx.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:Historia/JIFConsultarHAyudasDx$MiRender.class */
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
}
