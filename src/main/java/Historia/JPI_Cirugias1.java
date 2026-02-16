package Historia;

import Acceso.Principal;
import Facturacion.BuscarProced;
import General.JIFBuscarPatologia;
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
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DateFormatter;
import javax.swing.text.DefaultFormatterFactory;

/* JADX INFO: loaded from: GenomaP.jar:Historia/JPI_Cirugias1.class */
public class JPI_Cirugias1 extends JPanel {
    private String xsql;
    private String[] xId_Anestesia;
    private String[] xId_Servicio;
    private String[] xId_Especialidad;
    private String[] xId_Profesional;
    private String[] xId_TipoNota;
    private String[] xId_Procedimiento;
    private DefaultTableModel xModelo_Procedimientos;
    private DefaultTableModel xModelo_Historico;
    private DefaultTableModel xModelo_Integrantes;
    private DefaultTableModel xModelo_Patologia;
    private DefaultTableModel xModelo_Suministro;
    private DefaultTableModel xModelo_AyudasDx;
    private DefaultTableModel xModelo_Nota;
    private long xId_Atencion;
    private Object[] xDatos;
    private ButtonGroup JBGEstadoS;
    private ButtonGroup JBG_Bilateral;
    private ButtonGroup JBG_Contaminado;
    private ButtonGroup JBG_DTipo;
    private ButtonGroup JBG_RViaAcceso;
    private JButton JBTAdicionar;
    private JButton JBTCierre;
    private JButton JBTRNacido;
    private JButton JBT_DAdicionar;
    private JButton JBT_IAdicionar;
    private JButton JBT_IAdicionar1;
    private JButton JBT_NAdicionar;
    private JButton JBT_NPredefinida;
    private JButton JBT_SAdicionar;
    private JComboBox JCBTipo_Anestecia;
    private JComboBox JCB_IEspecialidad;
    public JComboBox JCB_IProcedimiento;
    private JComboBox JCB_IProfesional;
    private JComboBox JCB_IServicio;
    private JComboBox JCB_NTipoNota;
    private JCheckBox JCH_SCobrable;
    private JDateChooser JDC_CFecha;
    private JDateChooser JDC_FechaI;
    private JDateChooser JDC_NFecha;
    private JLabel JLBNumero;
    private JLabel JLB_IdTipoNota;
    private JPanel JPIDAdicionales;
    private JPanel JPIDInicio;
    private JPanel JPIDatosN;
    private JPanel JPIDatos_Intervencion;
    private JPanel JPIEstado;
    private JPanel JPINotas;
    private JPanel JPIProcedimiento;
    private JPanel JPI_Ayudas_Dx;
    private JPanel JPI_DDiagnostico;
    private JPanel JPI_DTipoDx;
    private JPanel JPI_Diagnosticos;
    private JPanel JPI_Integrantes;
    private JPanel JPI_RBilateral;
    private JPanel JPI_RContaminado;
    private JPanel JPI_RProcedimiento;
    private JPanel JPI_RProcedimiento1;
    private JPanel JPI_RProcedimiento2;
    private JPanel JPI_RViaAcceso;
    private JPanel JPI_SSuministro;
    private JPanel JPI_Sumimistro;
    private JRadioButton JRBEMuerto;
    private JRadioButton JRBEVivo;
    private JRadioButton JRB_BNo;
    private JRadioButton JRB_BSi;
    private JRadioButton JRB_CNo;
    private JRadioButton JRB_CSi;
    private JRadioButton JRB_DComplicacion;
    private JRadioButton JRB_DPosOperatorio;
    private JRadioButton JRB_DPreOperatorio;
    private JRadioButton JRB_RVia_Diferente;
    private JRadioButton JRB_RVia_Igual;
    private JSpinner JSPNOrden;
    private JScrollPane JSP_DDetalle;
    private JSpinner JSP_DNOrden;
    private JScrollPane JSP_DObservacion;
    private JScrollPane JSP_Historico;
    private JScrollPane JSP_IDetalle;
    private JScrollPane JSP_IDetalle1;
    private JSpinner JSP_INCantidad;
    private JSpinner JSP_INOrden;
    private JScrollPane JSP_IObservacion;
    private JScrollPane JSP_NDetalle;
    private JScrollPane JSP_NNota;
    private JScrollPane JSP_RDetalle;
    private JSpinner JSP_SCantidad;
    private JScrollPane JSP_SDetalle;
    private JScrollPane JSP_SObservacion;
    private JTextArea JTA_DObservacion;
    private JTextArea JTA_IObservacion;
    private JTextArea JTA_NNota;
    private JTextArea JTA_SObservacion;
    private JTable JTB_DDetalle_Diagnostico;
    private JTable JTB_Historico;
    private JTable JTB_IDetalle_AyudasDx;
    private JTable JTB_IDetalle_Integrante;
    private JTable JTB_NDetalle_Nota;
    private JTable JTB_RDetalle_Procedimiento;
    private JTable JTB_SDetalle_Sumnistro;
    private JFormattedTextField JTFF_CHora;
    private JFormattedTextField JTFF_HoraI;
    private JFormattedTextField JTFF_NHora;
    private JTextField JTF_DCodigo;
    private JTextField JTF_DNombre;
    private JTextField JTF_RCodigo;
    private JTextField JTF_RNombre;
    private JTextField JTF_SCodigo;
    private JTextField JTF_SNombre;
    private JTabbedPane JTPDatosIntervencion;
    private JTabbedPane JTPDatos_Qx;
    private Metodos xmt = new Metodos();
    private ConsultasMySQL xct = new ConsultasMySQL();
    private long xVia_Acceso = -1;
    private long xTipo_Diagnostico = 0;
    private long xSuministro_Procedimiento = -1;
    private long xBilateral = -1;
    private long XContaminado = -1;
    private boolean xLleno_CIntegrante = false;
    private boolean xLleno_Servicio = false;
    private boolean xCerrada = false;

    public JPI_Cirugias1(long xid_atencion, String xTitulo) {
        this.xId_Atencion = 0L;
        initComponents();
        this.xId_Atencion = xid_atencion;
        mNuevo();
        mIniciarComponentes();
        setBorder(BorderFactory.createTitledBorder((Border) null, xTitulo, 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
    }

    /* JADX WARN: Type inference failed for: r3v132, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v227, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v280, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v325, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v375, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v443, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v65, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBG_RViaAcceso = new ButtonGroup();
        this.JBG_DTipo = new ButtonGroup();
        this.JBG_Bilateral = new ButtonGroup();
        this.JBG_Contaminado = new ButtonGroup();
        this.JBGEstadoS = new ButtonGroup();
        this.JTPDatosIntervencion = new JTabbedPane();
        this.JPIDatos_Intervencion = new JPanel();
        this.JPIDInicio = new JPanel();
        this.JDC_FechaI = new JDateChooser();
        this.JCBTipo_Anestecia = new JComboBox();
        this.JLBNumero = new JLabel();
        this.JTFF_HoraI = new JFormattedTextField();
        this.JTPDatos_Qx = new JTabbedPane();
        this.JPI_Integrantes = new JPanel();
        this.JPI_RProcedimiento1 = new JPanel();
        this.JSP_INOrden = new JSpinner();
        this.JBT_IAdicionar = new JButton();
        this.JCB_IEspecialidad = new JComboBox();
        this.JCB_IProfesional = new JComboBox();
        this.JSP_IObservacion = new JScrollPane();
        this.JTA_IObservacion = new JTextArea();
        this.JSP_IDetalle = new JScrollPane();
        this.JTB_IDetalle_Integrante = new JTable();
        this.JPI_Diagnosticos = new JPanel();
        this.JPI_DDiagnostico = new JPanel();
        this.JTF_DCodigo = new JTextField();
        this.JTF_DNombre = new JTextField();
        this.JSP_DNOrden = new JSpinner();
        this.JPI_DTipoDx = new JPanel();
        this.JRB_DPreOperatorio = new JRadioButton();
        this.JRB_DPosOperatorio = new JRadioButton();
        this.JRB_DComplicacion = new JRadioButton();
        this.JSP_DObservacion = new JScrollPane();
        this.JTA_DObservacion = new JTextArea();
        this.JBT_DAdicionar = new JButton();
        this.JSP_DDetalle = new JScrollPane();
        this.JTB_DDetalle_Diagnostico = new JTable();
        this.JPIProcedimiento = new JPanel();
        this.JPI_RProcedimiento = new JPanel();
        this.JTF_RCodigo = new JTextField();
        this.JTF_RNombre = new JTextField();
        this.JPI_RViaAcceso = new JPanel();
        this.JRB_RVia_Igual = new JRadioButton();
        this.JRB_RVia_Diferente = new JRadioButton();
        this.JSPNOrden = new JSpinner();
        this.JBTAdicionar = new JButton();
        this.JPI_RBilateral = new JPanel();
        this.JRB_BSi = new JRadioButton();
        this.JRB_BNo = new JRadioButton();
        this.JPI_RContaminado = new JPanel();
        this.JRB_CSi = new JRadioButton();
        this.JRB_CNo = new JRadioButton();
        this.JSP_RDetalle = new JScrollPane();
        this.JTB_RDetalle_Procedimiento = new JTable();
        this.JPINotas = new JPanel();
        this.JPIDatosN = new JPanel();
        this.JDC_NFecha = new JDateChooser();
        this.JTFF_NHora = new JFormattedTextField();
        this.JCB_NTipoNota = new JComboBox();
        this.JSP_NNota = new JScrollPane();
        this.JTA_NNota = new JTextArea();
        this.JBT_NAdicionar = new JButton();
        this.JBT_NPredefinida = new JButton();
        this.JLB_IdTipoNota = new JLabel();
        this.JSP_NDetalle = new JScrollPane();
        this.JTB_NDetalle_Nota = new JTable();
        this.JPI_Ayudas_Dx = new JPanel();
        this.JPI_RProcedimiento2 = new JPanel();
        this.JCB_IServicio = new JComboBox();
        this.JCB_IProcedimiento = new JComboBox();
        this.JSP_INCantidad = new JSpinner();
        this.JBT_IAdicionar1 = new JButton();
        this.JSP_IDetalle1 = new JScrollPane();
        this.JTB_IDetalle_AyudasDx = new JTable();
        this.JPI_Sumimistro = new JPanel();
        this.JPI_SSuministro = new JPanel();
        this.JTF_SCodigo = new JTextField();
        this.JTF_SNombre = new JTextField();
        this.JSP_SCantidad = new JSpinner();
        this.JCH_SCobrable = new JCheckBox();
        this.JSP_SObservacion = new JScrollPane();
        this.JTA_SObservacion = new JTextArea();
        this.JBT_SAdicionar = new JButton();
        this.JSP_SDetalle = new JScrollPane();
        this.JTB_SDetalle_Sumnistro = new JTable();
        this.JPIDAdicionales = new JPanel();
        this.JBTCierre = new JButton();
        this.JBTRNacido = new JButton();
        this.JDC_CFecha = new JDateChooser();
        this.JTFF_CHora = new JFormattedTextField();
        this.JPIEstado = new JPanel();
        this.JRBEVivo = new JRadioButton();
        this.JRBEMuerto = new JRadioButton();
        this.JSP_Historico = new JScrollPane();
        this.JTB_Historico = new JTable();
        setBorder(BorderFactory.createTitledBorder((Border) null, "INTERVENCIÓN QUIRÚRGICA", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        setName("xjp_intervencion_qx");
        this.JTPDatosIntervencion.setForeground(Color.red);
        this.JTPDatosIntervencion.setFont(new Font("Arial", 1, 14));
        this.JPIDInicio.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS DE INICIO", 0, 0, new Font("Arial", 1, 12), new Color(0, 103, 0)));
        this.JDC_FechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDC_FechaI.setDateFormatString("dd/MM/yyyy");
        this.JDC_FechaI.setFont(new Font("Arial", 1, 12));
        this.JCBTipo_Anestecia.setFont(new Font("Arial", 1, 12));
        this.JCBTipo_Anestecia.setBorder(BorderFactory.createTitledBorder((Border) null, "Anestesia", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JLBNumero.setFont(new Font("Arial", 1, 18));
        this.JLBNumero.setForeground(Color.red);
        this.JLBNumero.setHorizontalAlignment(0);
        this.JLBNumero.setBorder(BorderFactory.createTitledBorder((Border) null, "Número", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JLBNumero.setFocusable(false);
        this.JTFF_HoraI.setBorder(BorderFactory.createTitledBorder((Border) null, "Hora Inicio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFF_HoraI.setFormatterFactory(new DefaultFormatterFactory(new DateFormatter(new SimpleDateFormat("HH:mm:ss"))));
        this.JTFF_HoraI.setFont(new Font("Arial", 1, 12));
        this.JTFF_HoraI.addActionListener(new ActionListener() { // from class: Historia.JPI_Cirugias1.1
            public void actionPerformed(ActionEvent evt) {
                JPI_Cirugias1.this.JTFF_HoraIActionPerformed(evt);
            }
        });
        this.JTFF_HoraI.addKeyListener(new KeyAdapter() { // from class: Historia.JPI_Cirugias1.2
            public void keyPressed(KeyEvent evt) {
                JPI_Cirugias1.this.JTFF_HoraIKeyPressed(evt);
            }
        });
        GroupLayout JPIDInicioLayout = new GroupLayout(this.JPIDInicio);
        this.JPIDInicio.setLayout(JPIDInicioLayout);
        JPIDInicioLayout.setHorizontalGroup(JPIDInicioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDInicioLayout.createSequentialGroup().addContainerGap().addComponent(this.JDC_FechaI, -2, 113, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFF_HoraI, -2, 99, -2).addGap(18, 18, 18).addComponent(this.JCBTipo_Anestecia, -2, 374, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JLBNumero, -1, 130, 32767).addContainerGap()));
        JPIDInicioLayout.setVerticalGroup(JPIDInicioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDInicioLayout.createSequentialGroup().addContainerGap().addGroup(JPIDInicioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLBNumero, -1, -1, 32767).addGroup(JPIDInicioLayout.createSequentialGroup().addGroup(JPIDInicioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDInicioLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBTipo_Anestecia, -2, 50, -2).addComponent(this.JTFF_HoraI, -2, 50, -2)).addComponent(this.JDC_FechaI, -2, 50, -2)).addGap(0, 2, 32767))).addContainerGap()));
        this.JTPDatos_Qx.setForeground(new Color(0, 103, 0));
        this.JTPDatos_Qx.setTabLayoutPolicy(1);
        this.JTPDatos_Qx.setFont(new Font("Arial", 1, 12));
        this.JTPDatos_Qx.addMouseListener(new MouseAdapter() { // from class: Historia.JPI_Cirugias1.3
            public void mouseClicked(MouseEvent evt) {
                JPI_Cirugias1.this.JTPDatos_QxMouseClicked(evt);
            }
        });
        this.JPI_RProcedimiento1.setBorder(BorderFactory.createEtchedBorder());
        this.JSP_INOrden.setFont(new Font("Arial", 1, 12));
        this.JSP_INOrden.setModel(new SpinnerNumberModel(0, 0, (Comparable) null, 1));
        this.JSP_INOrden.setToolTipText("Orden de los asistentes");
        this.JSP_INOrden.setBorder(BorderFactory.createTitledBorder((Border) null, "Nº", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBT_IAdicionar.setFont(new Font("Arial", 1, 12));
        this.JBT_IAdicionar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBT_IAdicionar.setText("Adicionar");
        this.JBT_IAdicionar.addActionListener(new ActionListener() { // from class: Historia.JPI_Cirugias1.4
            public void actionPerformed(ActionEvent evt) {
                JPI_Cirugias1.this.JBT_IAdicionarActionPerformed(evt);
            }
        });
        this.JCB_IEspecialidad.setFont(new Font("Arial", 1, 12));
        this.JCB_IEspecialidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Especialidad", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCB_IEspecialidad.addItemListener(new ItemListener() { // from class: Historia.JPI_Cirugias1.5
            public void itemStateChanged(ItemEvent evt) {
                JPI_Cirugias1.this.JCB_IEspecialidadItemStateChanged(evt);
            }
        });
        this.JCB_IProfesional.setFont(new Font("Arial", 1, 12));
        this.JCB_IProfesional.setBorder(BorderFactory.createTitledBorder((Border) null, "Profesional", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSP_IObservacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSP_IObservacion.setAutoscrolls(true);
        this.JTA_IObservacion.setColumns(20);
        this.JTA_IObservacion.setFont(new Font("Arial", 1, 12));
        this.JTA_IObservacion.setLineWrap(true);
        this.JTA_IObservacion.setRows(1);
        this.JTA_IObservacion.setTabSize(1);
        this.JSP_IObservacion.setViewportView(this.JTA_IObservacion);
        GroupLayout JPI_RProcedimiento1Layout = new GroupLayout(this.JPI_RProcedimiento1);
        this.JPI_RProcedimiento1.setLayout(JPI_RProcedimiento1Layout);
        JPI_RProcedimiento1Layout.setHorizontalGroup(JPI_RProcedimiento1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_RProcedimiento1Layout.createSequentialGroup().addContainerGap().addGroup(JPI_RProcedimiento1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_RProcedimiento1Layout.createSequentialGroup().addComponent(this.JCB_IEspecialidad, -2, 273, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCB_IProfesional, 0, 412, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSP_INOrden, -2, 51, -2)).addGroup(JPI_RProcedimiento1Layout.createSequentialGroup().addComponent(this.JSP_IObservacion).addGap(18, 18, 18).addComponent(this.JBT_IAdicionar, -2, 188, -2))).addContainerGap()));
        JPI_RProcedimiento1Layout.setVerticalGroup(JPI_RProcedimiento1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_RProcedimiento1Layout.createSequentialGroup().addContainerGap().addGroup(JPI_RProcedimiento1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSP_INOrden, -2, 50, -2).addGroup(JPI_RProcedimiento1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCB_IEspecialidad, -2, 50, -2).addComponent(this.JCB_IProfesional, -2, 50, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPI_RProcedimiento1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JBT_IAdicionar, -2, 47, -2).addComponent(this.JSP_IObservacion, -2, -1, -2)).addContainerGap(-1, 32767)));
        this.JSP_IDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 12), Color.red));
        this.JTB_IDetalle_Integrante.setFont(new Font("Arial", 1, 12));
        this.JTB_IDetalle_Integrante.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTB_IDetalle_Integrante.setSelectionBackground(new Color(255, 255, 255));
        this.JTB_IDetalle_Integrante.setSelectionForeground(Color.red);
        this.JTB_IDetalle_Integrante.addKeyListener(new KeyAdapter() { // from class: Historia.JPI_Cirugias1.6
            public void keyPressed(KeyEvent evt) {
                JPI_Cirugias1.this.JTB_IDetalle_IntegranteKeyPressed(evt);
            }
        });
        this.JSP_IDetalle.setViewportView(this.JTB_IDetalle_Integrante);
        GroupLayout JPI_IntegrantesLayout = new GroupLayout(this.JPI_Integrantes);
        this.JPI_Integrantes.setLayout(JPI_IntegrantesLayout);
        JPI_IntegrantesLayout.setHorizontalGroup(JPI_IntegrantesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_IntegrantesLayout.createSequentialGroup().addContainerGap().addGroup(JPI_IntegrantesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPI_RProcedimiento1, -1, -1, 32767).addComponent(this.JSP_IDetalle, GroupLayout.Alignment.TRAILING, -1, 780, 32767)).addContainerGap()));
        JPI_IntegrantesLayout.setVerticalGroup(JPI_IntegrantesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_IntegrantesLayout.createSequentialGroup().addContainerGap().addComponent(this.JPI_RProcedimiento1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSP_IDetalle, -1, 259, 32767).addContainerGap()));
        this.JTPDatos_Qx.addTab("INTEGRANTES", this.JPI_Integrantes);
        this.JPI_DDiagnostico.setBorder(BorderFactory.createEtchedBorder());
        this.JTF_DCodigo.setFont(new Font("Arial", 1, 12));
        this.JTF_DCodigo.setBorder(BorderFactory.createTitledBorder((Border) null, "Cie10", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTF_DCodigo.addActionListener(new ActionListener() { // from class: Historia.JPI_Cirugias1.7
            public void actionPerformed(ActionEvent evt) {
                JPI_Cirugias1.this.JTF_DCodigoActionPerformed(evt);
            }
        });
        this.JTF_DCodigo.addFocusListener(new FocusAdapter() { // from class: Historia.JPI_Cirugias1.8
            public void focusLost(FocusEvent evt) {
                JPI_Cirugias1.this.JTF_DCodigoFocusLost(evt);
            }
        });
        this.JTF_DNombre.setFont(new Font("Arial", 1, 12));
        this.JTF_DNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre Patología", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTF_DNombre.addMouseListener(new MouseAdapter() { // from class: Historia.JPI_Cirugias1.9
            public void mouseClicked(MouseEvent evt) {
                JPI_Cirugias1.this.JTF_DNombreMouseClicked(evt);
            }
        });
        this.JSP_DNOrden.setFont(new Font("Arial", 1, 12));
        this.JSP_DNOrden.setModel(new SpinnerNumberModel(0, 0, (Comparable) null, 1));
        this.JSP_DNOrden.setToolTipText("Orden del Diagnóstico");
        this.JSP_DNOrden.setBorder(BorderFactory.createTitledBorder((Border) null, "Nº", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JPI_DTipoDx.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de Dx", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBG_DTipo.add(this.JRB_DPreOperatorio);
        this.JRB_DPreOperatorio.setFont(new Font("Arial", 1, 12));
        this.JRB_DPreOperatorio.setSelected(true);
        this.JRB_DPreOperatorio.setText("Pre-Operatorio");
        this.JRB_DPreOperatorio.addActionListener(new ActionListener() { // from class: Historia.JPI_Cirugias1.10
            public void actionPerformed(ActionEvent evt) {
                JPI_Cirugias1.this.JRB_DPreOperatorioActionPerformed(evt);
            }
        });
        this.JBG_DTipo.add(this.JRB_DPosOperatorio);
        this.JRB_DPosOperatorio.setFont(new Font("Arial", 1, 12));
        this.JRB_DPosOperatorio.setText("Pos-Operatorio");
        this.JRB_DPosOperatorio.addActionListener(new ActionListener() { // from class: Historia.JPI_Cirugias1.11
            public void actionPerformed(ActionEvent evt) {
                JPI_Cirugias1.this.JRB_DPosOperatorioActionPerformed(evt);
            }
        });
        this.JBG_DTipo.add(this.JRB_DComplicacion);
        this.JRB_DComplicacion.setFont(new Font("Arial", 1, 12));
        this.JRB_DComplicacion.setText("Complicación");
        this.JRB_DComplicacion.addActionListener(new ActionListener() { // from class: Historia.JPI_Cirugias1.12
            public void actionPerformed(ActionEvent evt) {
                JPI_Cirugias1.this.JRB_DComplicacionActionPerformed(evt);
            }
        });
        GroupLayout JPI_DTipoDxLayout = new GroupLayout(this.JPI_DTipoDx);
        this.JPI_DTipoDx.setLayout(JPI_DTipoDxLayout);
        JPI_DTipoDxLayout.setHorizontalGroup(JPI_DTipoDxLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DTipoDxLayout.createSequentialGroup().addContainerGap().addComponent(this.JRB_DPreOperatorio).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB_DPosOperatorio).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB_DComplicacion).addContainerGap(-1, 32767)));
        JPI_DTipoDxLayout.setVerticalGroup(JPI_DTipoDxLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DTipoDxLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRB_DPreOperatorio).addComponent(this.JRB_DPosOperatorio).addComponent(this.JRB_DComplicacion)));
        this.JSP_DObservacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSP_DObservacion.setAutoscrolls(true);
        this.JTA_DObservacion.setColumns(20);
        this.JTA_DObservacion.setFont(new Font("Arial", 1, 12));
        this.JTA_DObservacion.setLineWrap(true);
        this.JTA_DObservacion.setRows(1);
        this.JTA_DObservacion.setTabSize(1);
        this.JSP_DObservacion.setViewportView(this.JTA_DObservacion);
        this.JBT_DAdicionar.setFont(new Font("Arial", 1, 12));
        this.JBT_DAdicionar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBT_DAdicionar.setText("Adicionar");
        this.JBT_DAdicionar.addActionListener(new ActionListener() { // from class: Historia.JPI_Cirugias1.13
            public void actionPerformed(ActionEvent evt) {
                JPI_Cirugias1.this.JBT_DAdicionarActionPerformed(evt);
            }
        });
        GroupLayout JPI_DDiagnosticoLayout = new GroupLayout(this.JPI_DDiagnostico);
        this.JPI_DDiagnostico.setLayout(JPI_DDiagnosticoLayout);
        JPI_DDiagnosticoLayout.setHorizontalGroup(JPI_DDiagnosticoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DDiagnosticoLayout.createSequentialGroup().addContainerGap().addGroup(JPI_DDiagnosticoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DDiagnosticoLayout.createSequentialGroup().addComponent(this.JPI_DTipoDx, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSP_DObservacion, -2, 0, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBT_DAdicionar, -2, 188, -2)).addGroup(JPI_DDiagnosticoLayout.createSequentialGroup().addComponent(this.JTF_DCodigo, -2, 82, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTF_DNombre).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSP_DNOrden, -2, 51, -2))).addContainerGap()));
        JPI_DDiagnosticoLayout.setVerticalGroup(JPI_DDiagnosticoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPI_DDiagnosticoLayout.createSequentialGroup().addContainerGap().addGroup(JPI_DDiagnosticoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTF_DCodigo, -2, 50, -2).addComponent(this.JTF_DNombre, -2, 50, -2).addComponent(this.JSP_DNOrden, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPI_DDiagnosticoLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JPI_DTipoDx, -2, -1, -2).addComponent(this.JBT_DAdicionar, -2, 47, -2).addComponent(this.JSP_DObservacion, -2, -1, -2)).addContainerGap(-1, 32767)));
        this.JSP_DDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 12), Color.red));
        this.JTB_DDetalle_Diagnostico.setFont(new Font("Arial", 1, 12));
        this.JTB_DDetalle_Diagnostico.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTB_DDetalle_Diagnostico.setSelectionBackground(new Color(255, 255, 255));
        this.JTB_DDetalle_Diagnostico.setSelectionForeground(Color.red);
        this.JTB_DDetalle_Diagnostico.addKeyListener(new KeyAdapter() { // from class: Historia.JPI_Cirugias1.14
            public void keyPressed(KeyEvent evt) {
                JPI_Cirugias1.this.JTB_DDetalle_DiagnosticoKeyPressed(evt);
            }
        });
        this.JSP_DDetalle.setViewportView(this.JTB_DDetalle_Diagnostico);
        GroupLayout JPI_DiagnosticosLayout = new GroupLayout(this.JPI_Diagnosticos);
        this.JPI_Diagnosticos.setLayout(JPI_DiagnosticosLayout);
        JPI_DiagnosticosLayout.setHorizontalGroup(JPI_DiagnosticosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DiagnosticosLayout.createSequentialGroup().addContainerGap().addGroup(JPI_DiagnosticosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPI_DDiagnostico, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addComponent(this.JSP_DDetalle, -1, 780, 32767)).addContainerGap()));
        JPI_DiagnosticosLayout.setVerticalGroup(JPI_DiagnosticosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DiagnosticosLayout.createSequentialGroup().addContainerGap().addComponent(this.JPI_DDiagnostico, -2, -1, -2).addGap(12, 12, 12).addComponent(this.JSP_DDetalle, -1, 248, 32767).addContainerGap()));
        this.JTPDatos_Qx.addTab("DIAGNÓSTICOS", this.JPI_Diagnosticos);
        this.JPI_RProcedimiento.setBorder(BorderFactory.createEtchedBorder());
        this.JTF_RCodigo.setFont(new Font("Arial", 1, 12));
        this.JTF_RCodigo.setBorder(BorderFactory.createTitledBorder((Border) null, "Código Cups", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTF_RCodigo.addFocusListener(new FocusAdapter() { // from class: Historia.JPI_Cirugias1.15
            public void focusLost(FocusEvent evt) {
                JPI_Cirugias1.this.JTF_RCodigoFocusLost(evt);
            }
        });
        this.JTF_RCodigo.addActionListener(new ActionListener() { // from class: Historia.JPI_Cirugias1.16
            public void actionPerformed(ActionEvent evt) {
                JPI_Cirugias1.this.JTF_RCodigoActionPerformed(evt);
            }
        });
        this.JTF_RNombre.setFont(new Font("Arial", 1, 12));
        this.JTF_RNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTF_RNombre.addMouseListener(new MouseAdapter() { // from class: Historia.JPI_Cirugias1.17
            public void mouseClicked(MouseEvent evt) {
                JPI_Cirugias1.this.JTF_RNombreMouseClicked(evt);
            }
        });
        this.JPI_RViaAcceso.setBorder(BorderFactory.createTitledBorder((Border) null, "Vía de Acceso", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBG_RViaAcceso.add(this.JRB_RVia_Igual);
        this.JRB_RVia_Igual.setFont(new Font("Arial", 1, 12));
        this.JRB_RVia_Igual.setText("Igual");
        this.JRB_RVia_Igual.addActionListener(new ActionListener() { // from class: Historia.JPI_Cirugias1.18
            public void actionPerformed(ActionEvent evt) {
                JPI_Cirugias1.this.JRB_RVia_IgualActionPerformed(evt);
            }
        });
        this.JBG_RViaAcceso.add(this.JRB_RVia_Diferente);
        this.JRB_RVia_Diferente.setFont(new Font("Arial", 1, 12));
        this.JRB_RVia_Diferente.setText("Diferente");
        this.JRB_RVia_Diferente.addActionListener(new ActionListener() { // from class: Historia.JPI_Cirugias1.19
            public void actionPerformed(ActionEvent evt) {
                JPI_Cirugias1.this.JRB_RVia_DiferenteActionPerformed(evt);
            }
        });
        GroupLayout JPI_RViaAccesoLayout = new GroupLayout(this.JPI_RViaAcceso);
        this.JPI_RViaAcceso.setLayout(JPI_RViaAccesoLayout);
        JPI_RViaAccesoLayout.setHorizontalGroup(JPI_RViaAccesoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_RViaAccesoLayout.createSequentialGroup().addContainerGap().addComponent(this.JRB_RVia_Igual).addGap(18, 18, 18).addComponent(this.JRB_RVia_Diferente).addContainerGap(-1, 32767)));
        JPI_RViaAccesoLayout.setVerticalGroup(JPI_RViaAccesoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_RViaAccesoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRB_RVia_Igual).addComponent(this.JRB_RVia_Diferente)));
        this.JSPNOrden.setFont(new Font("Arial", 1, 12));
        this.JSPNOrden.setModel(new SpinnerNumberModel(0, 0, (Comparable) null, 1));
        this.JSPNOrden.setToolTipText("Orden de la Cirugía");
        this.JSPNOrden.setBorder(BorderFactory.createTitledBorder((Border) null, "Nº", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBTAdicionar.setFont(new Font("Arial", 1, 12));
        this.JBTAdicionar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTAdicionar.setText("Adicionar");
        this.JBTAdicionar.addActionListener(new ActionListener() { // from class: Historia.JPI_Cirugias1.20
            public void actionPerformed(ActionEvent evt) {
                JPI_Cirugias1.this.JBTAdicionarActionPerformed(evt);
            }
        });
        this.JPI_RBilateral.setBorder(BorderFactory.createTitledBorder((Border) null, "Bilateral", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBG_Bilateral.add(this.JRB_BSi);
        this.JRB_BSi.setFont(new Font("Arial", 1, 12));
        this.JRB_BSi.setText("Si");
        this.JRB_BSi.addActionListener(new ActionListener() { // from class: Historia.JPI_Cirugias1.21
            public void actionPerformed(ActionEvent evt) {
                JPI_Cirugias1.this.JRB_BSiActionPerformed(evt);
            }
        });
        this.JBG_Bilateral.add(this.JRB_BNo);
        this.JRB_BNo.setFont(new Font("Arial", 1, 12));
        this.JRB_BNo.setText("No");
        this.JRB_BNo.addActionListener(new ActionListener() { // from class: Historia.JPI_Cirugias1.22
            public void actionPerformed(ActionEvent evt) {
                JPI_Cirugias1.this.JRB_BNoActionPerformed(evt);
            }
        });
        GroupLayout JPI_RBilateralLayout = new GroupLayout(this.JPI_RBilateral);
        this.JPI_RBilateral.setLayout(JPI_RBilateralLayout);
        JPI_RBilateralLayout.setHorizontalGroup(JPI_RBilateralLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_RBilateralLayout.createSequentialGroup().addContainerGap().addComponent(this.JRB_BSi).addGap(18, 18, 18).addComponent(this.JRB_BNo).addContainerGap(-1, 32767)));
        JPI_RBilateralLayout.setVerticalGroup(JPI_RBilateralLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_RBilateralLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRB_BSi).addComponent(this.JRB_BNo)));
        this.JPI_RContaminado.setBorder(BorderFactory.createTitledBorder((Border) null, "Contaminado", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBG_Contaminado.add(this.JRB_CSi);
        this.JRB_CSi.setFont(new Font("Arial", 1, 12));
        this.JRB_CSi.setText("Si");
        this.JRB_CSi.addActionListener(new ActionListener() { // from class: Historia.JPI_Cirugias1.23
            public void actionPerformed(ActionEvent evt) {
                JPI_Cirugias1.this.JRB_CSiActionPerformed(evt);
            }
        });
        this.JBG_Contaminado.add(this.JRB_CNo);
        this.JRB_CNo.setFont(new Font("Arial", 1, 12));
        this.JRB_CNo.setText("No");
        this.JRB_CNo.addActionListener(new ActionListener() { // from class: Historia.JPI_Cirugias1.24
            public void actionPerformed(ActionEvent evt) {
                JPI_Cirugias1.this.JRB_CNoActionPerformed(evt);
            }
        });
        GroupLayout JPI_RContaminadoLayout = new GroupLayout(this.JPI_RContaminado);
        this.JPI_RContaminado.setLayout(JPI_RContaminadoLayout);
        JPI_RContaminadoLayout.setHorizontalGroup(JPI_RContaminadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_RContaminadoLayout.createSequentialGroup().addContainerGap().addComponent(this.JRB_CSi).addGap(18, 18, 18).addComponent(this.JRB_CNo).addContainerGap(-1, 32767)));
        JPI_RContaminadoLayout.setVerticalGroup(JPI_RContaminadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_RContaminadoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRB_CSi).addComponent(this.JRB_CNo)));
        GroupLayout JPI_RProcedimientoLayout = new GroupLayout(this.JPI_RProcedimiento);
        this.JPI_RProcedimiento.setLayout(JPI_RProcedimientoLayout);
        JPI_RProcedimientoLayout.setHorizontalGroup(JPI_RProcedimientoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_RProcedimientoLayout.createSequentialGroup().addContainerGap().addGroup(JPI_RProcedimientoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_RProcedimientoLayout.createSequentialGroup().addComponent(this.JTF_RCodigo, -2, 100, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTF_RNombre).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPNOrden, -2, 51, -2)).addGroup(JPI_RProcedimientoLayout.createSequentialGroup().addComponent(this.JPI_RViaAcceso, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JPI_RBilateral, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JPI_RContaminado, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JBTAdicionar, -2, 188, -2))).addContainerGap()));
        JPI_RProcedimientoLayout.setVerticalGroup(JPI_RProcedimientoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_RProcedimientoLayout.createSequentialGroup().addContainerGap().addGroup(JPI_RProcedimientoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTF_RCodigo, -2, 50, -2).addComponent(this.JTF_RNombre, -2, 50, -2).addComponent(this.JSPNOrden, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPI_RProcedimientoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_RProcedimientoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JPI_RViaAcceso, -2, -1, -2).addComponent(this.JBTAdicionar, -1, -1, 32767)).addComponent(this.JPI_RBilateral, -2, -1, -2).addComponent(this.JPI_RContaminado, -2, -1, -2)).addContainerGap(14, 32767)));
        this.JSP_RDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 12), Color.red));
        this.JTB_RDetalle_Procedimiento.setFont(new Font("Arial", 1, 12));
        this.JTB_RDetalle_Procedimiento.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTB_RDetalle_Procedimiento.setSelectionBackground(new Color(255, 255, 255));
        this.JTB_RDetalle_Procedimiento.setSelectionForeground(Color.red);
        this.JTB_RDetalle_Procedimiento.addKeyListener(new KeyAdapter() { // from class: Historia.JPI_Cirugias1.25
            public void keyPressed(KeyEvent evt) {
                JPI_Cirugias1.this.JTB_RDetalle_ProcedimientoKeyPressed(evt);
            }
        });
        this.JSP_RDetalle.setViewportView(this.JTB_RDetalle_Procedimiento);
        GroupLayout JPIProcedimientoLayout = new GroupLayout(this.JPIProcedimiento);
        this.JPIProcedimiento.setLayout(JPIProcedimientoLayout);
        JPIProcedimientoLayout.setHorizontalGroup(JPIProcedimientoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIProcedimientoLayout.createSequentialGroup().addContainerGap().addGroup(JPIProcedimientoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPI_RProcedimiento, -1, -1, 32767).addComponent(this.JSP_RDetalle, -1, 780, 32767)).addContainerGap()));
        JPIProcedimientoLayout.setVerticalGroup(JPIProcedimientoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIProcedimientoLayout.createSequentialGroup().addContainerGap().addComponent(this.JPI_RProcedimiento, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSP_RDetalle, -1, 259, 32767).addContainerGap()));
        this.JTPDatos_Qx.addTab("PROCEDIMIENTOS", this.JPIProcedimiento);
        this.JPIDatosN.setBorder(BorderFactory.createEtchedBorder());
        this.JDC_NFecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDC_NFecha.setDateFormatString("dd/MM/yyyy");
        this.JDC_NFecha.setFont(new Font("Arial", 1, 12));
        this.JTFF_NHora.setBorder(BorderFactory.createTitledBorder((Border) null, "Hora", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFF_NHora.setFormatterFactory(new DefaultFormatterFactory(new DateFormatter(new SimpleDateFormat("HH:mm:ss"))));
        this.JTFF_NHora.setHorizontalAlignment(4);
        this.JTFF_NHora.setFont(new Font("Arial", 1, 12));
        this.JCB_NTipoNota.setFont(new Font("Arial", 1, 12));
        this.JCB_NTipoNota.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Nota", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSP_NNota.setBorder(BorderFactory.createTitledBorder((Border) null, "NOTA CLÍNICA", 2, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.JTA_NNota.setColumns(20);
        this.JTA_NNota.setFont(new Font("Arial", 1, 12));
        this.JTA_NNota.setLineWrap(true);
        this.JTA_NNota.setRows(1);
        this.JTA_NNota.setTabSize(1);
        this.JTA_NNota.setBorder((Border) null);
        this.JSP_NNota.setViewportView(this.JTA_NNota);
        this.JBT_NAdicionar.setFont(new Font("Arial", 1, 12));
        this.JBT_NAdicionar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBT_NAdicionar.setText("Adicionar");
        this.JBT_NAdicionar.addActionListener(new ActionListener() { // from class: Historia.JPI_Cirugias1.26
            public void actionPerformed(ActionEvent evt) {
                JPI_Cirugias1.this.JBT_NAdicionarActionPerformed(evt);
            }
        });
        this.JBT_NPredefinida.setFont(new Font("Arial", 1, 12));
        this.JBT_NPredefinida.setIcon(new ImageIcon(getClass().getResource("/Imagenes/HojaLapiz29x27.png")));
        this.JBT_NPredefinida.setText("Notas");
        this.JBT_NPredefinida.setToolTipText("Consultar notas predefinidas");
        this.JBT_NPredefinida.addActionListener(new ActionListener() { // from class: Historia.JPI_Cirugias1.27
            public void actionPerformed(ActionEvent evt) {
                JPI_Cirugias1.this.JBT_NPredefinidaActionPerformed(evt);
            }
        });
        this.JLB_IdTipoNota.setFont(new Font("Arial", 1, 12));
        this.JLB_IdTipoNota.setHorizontalAlignment(0);
        this.JLB_IdTipoNota.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Nota", 0, 0, new Font("Arial", 1, 12), Color.red));
        GroupLayout JPIDatosNLayout = new GroupLayout(this.JPIDatosN);
        this.JPIDatosN.setLayout(JPIDatosNLayout);
        JPIDatosNLayout.setHorizontalGroup(JPIDatosNLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosNLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosNLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPIDatosNLayout.createSequentialGroup().addComponent(this.JDC_NFecha, -2, 128, -2).addGap(18, 18, 18).addComponent(this.JTFF_NHora, -2, 96, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCB_NTipoNota, 0, -1, 32767)).addComponent(this.JSP_NNota, -2, 623, -2)).addGroup(JPIDatosNLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPIDatosNLayout.createSequentialGroup().addGap(20, 20, 20).addComponent(this.JLB_IdTipoNota, -2, 101, -2)).addGroup(JPIDatosNLayout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBT_NAdicionar, -1, -1, 32767)).addGroup(JPIDatosNLayout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBT_NPredefinida, -1, -1, 32767))).addContainerGap(-1, 32767)));
        JPIDatosNLayout.setVerticalGroup(JPIDatosNLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosNLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosNLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JDC_NFecha, GroupLayout.Alignment.LEADING, -1, 53, 32767).addComponent(this.JTFF_NHora, GroupLayout.Alignment.LEADING).addComponent(this.JCB_NTipoNota, -1, 53, 32767).addComponent(this.JLB_IdTipoNota, -1, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIDatosNLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JSP_NNota, -2, 104, -2).addGroup(JPIDatosNLayout.createSequentialGroup().addComponent(this.JBT_NAdicionar, -2, 50, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JBT_NPredefinida, -2, 50, -2))).addContainerGap(-1, 32767)));
        this.JSP_NDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 12), Color.red));
        this.JTB_NDetalle_Nota.setFont(new Font("Arial", 1, 12));
        this.JTB_NDetalle_Nota.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTB_NDetalle_Nota.setSelectionBackground(new Color(255, 255, 255));
        this.JTB_NDetalle_Nota.setSelectionForeground(Color.red);
        this.JTB_NDetalle_Nota.addMouseListener(new MouseAdapter() { // from class: Historia.JPI_Cirugias1.28
            public void mouseClicked(MouseEvent evt) {
                JPI_Cirugias1.this.JTB_NDetalle_NotaMouseClicked(evt);
            }
        });
        this.JTB_NDetalle_Nota.addKeyListener(new KeyAdapter() { // from class: Historia.JPI_Cirugias1.29
            public void keyPressed(KeyEvent evt) {
                JPI_Cirugias1.this.JTB_NDetalle_NotaKeyPressed(evt);
            }
        });
        this.JSP_NDetalle.setViewportView(this.JTB_NDetalle_Nota);
        GroupLayout JPINotasLayout = new GroupLayout(this.JPINotas);
        this.JPINotas.setLayout(JPINotasLayout);
        JPINotasLayout.setHorizontalGroup(JPINotasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPINotasLayout.createSequentialGroup().addContainerGap().addGroup(JPINotasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIDatosN, -1, -1, 32767).addGroup(JPINotasLayout.createSequentialGroup().addComponent(this.JSP_NDetalle, -2, 777, -2).addGap(0, 0, 32767))).addContainerGap()));
        JPINotasLayout.setVerticalGroup(JPINotasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPINotasLayout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatosN, -2, -1, -2).addGap(18, 18, 18).addComponent(this.JSP_NDetalle, -1, 214, 32767).addContainerGap()));
        this.JTPDatos_Qx.addTab("DESCRIPCIONES", this.JPINotas);
        this.JPI_RProcedimiento2.setBorder(BorderFactory.createEtchedBorder());
        this.JCB_IServicio.setFont(new Font("Arial", 1, 12));
        this.JCB_IServicio.setBorder(BorderFactory.createTitledBorder((Border) null, "Servicio", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCB_IServicio.addItemListener(new ItemListener() { // from class: Historia.JPI_Cirugias1.30
            public void itemStateChanged(ItemEvent evt) {
                JPI_Cirugias1.this.JCB_IServicioItemStateChanged(evt);
            }
        });
        this.JCB_IProcedimiento.setFont(new Font("Arial", 1, 12));
        this.JCB_IProcedimiento.setToolTipText("Doble clic para habilitar la ayuda de búsqueda");
        this.JCB_IProcedimiento.setBorder(BorderFactory.createTitledBorder((Border) null, "Procedimiento", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCB_IProcedimiento.addMouseListener(new MouseAdapter() { // from class: Historia.JPI_Cirugias1.31
            public void mouseClicked(MouseEvent evt) {
                JPI_Cirugias1.this.JCB_IProcedimientoMouseClicked(evt);
            }
        });
        this.JCB_IProcedimiento.addActionListener(new ActionListener() { // from class: Historia.JPI_Cirugias1.32
            public void actionPerformed(ActionEvent evt) {
                JPI_Cirugias1.this.JCB_IProcedimientoActionPerformed(evt);
            }
        });
        this.JSP_INCantidad.setFont(new Font("Arial", 1, 12));
        this.JSP_INCantidad.setModel(new SpinnerNumberModel(1, 0, (Comparable) null, 1));
        this.JSP_INCantidad.setToolTipText("Cantidad");
        this.JSP_INCantidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Cant.", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBT_IAdicionar1.setFont(new Font("Arial", 1, 12));
        this.JBT_IAdicionar1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBT_IAdicionar1.setText("Adicionar");
        this.JBT_IAdicionar1.addActionListener(new ActionListener() { // from class: Historia.JPI_Cirugias1.33
            public void actionPerformed(ActionEvent evt) {
                JPI_Cirugias1.this.JBT_IAdicionar1ActionPerformed(evt);
            }
        });
        GroupLayout JPI_RProcedimiento2Layout = new GroupLayout(this.JPI_RProcedimiento2);
        this.JPI_RProcedimiento2.setLayout(JPI_RProcedimiento2Layout);
        JPI_RProcedimiento2Layout.setHorizontalGroup(JPI_RProcedimiento2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPI_RProcedimiento2Layout.createSequentialGroup().addContainerGap().addGroup(JPI_RProcedimiento2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JBT_IAdicionar1, -1, -1, 32767).addGroup(JPI_RProcedimiento2Layout.createSequentialGroup().addComponent(this.JCB_IServicio, -2, 166, -2).addGap(18, 18, 18).addComponent(this.JCB_IProcedimiento, 0, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSP_INCantidad, -2, 67, -2))).addContainerGap()));
        JPI_RProcedimiento2Layout.setVerticalGroup(JPI_RProcedimiento2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_RProcedimiento2Layout.createSequentialGroup().addContainerGap().addGroup(JPI_RProcedimiento2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSP_INCantidad, -2, 50, -2).addGroup(JPI_RProcedimiento2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCB_IServicio, -2, 50, -2).addComponent(this.JCB_IProcedimiento, -2, 50, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBT_IAdicionar1, -2, 47, -2).addContainerGap(-1, 32767)));
        this.JSP_IDetalle1.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 12), Color.red));
        this.JTB_IDetalle_AyudasDx.setFont(new Font("Arial", 1, 12));
        this.JTB_IDetalle_AyudasDx.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTB_IDetalle_AyudasDx.setSelectionBackground(new Color(255, 255, 255));
        this.JTB_IDetalle_AyudasDx.setSelectionForeground(Color.red);
        this.JTB_IDetalle_AyudasDx.addKeyListener(new KeyAdapter() { // from class: Historia.JPI_Cirugias1.34
            public void keyPressed(KeyEvent evt) {
                JPI_Cirugias1.this.JTB_IDetalle_AyudasDxKeyPressed(evt);
            }
        });
        this.JSP_IDetalle1.setViewportView(this.JTB_IDetalle_AyudasDx);
        GroupLayout JPI_Ayudas_DxLayout = new GroupLayout(this.JPI_Ayudas_Dx);
        this.JPI_Ayudas_Dx.setLayout(JPI_Ayudas_DxLayout);
        JPI_Ayudas_DxLayout.setHorizontalGroup(JPI_Ayudas_DxLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_Ayudas_DxLayout.createSequentialGroup().addContainerGap().addGroup(JPI_Ayudas_DxLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPI_RProcedimiento2, -1, -1, 32767).addComponent(this.JSP_IDetalle1, GroupLayout.Alignment.TRAILING, -1, 793, 32767)).addContainerGap()));
        JPI_Ayudas_DxLayout.setVerticalGroup(JPI_Ayudas_DxLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_Ayudas_DxLayout.createSequentialGroup().addContainerGap().addComponent(this.JPI_RProcedimiento2, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSP_IDetalle1, -1, 259, 32767).addContainerGap()));
        this.JTPDatos_Qx.addTab("AYUDAS DIAGNÓSTICAS", this.JPI_Ayudas_Dx);
        this.JPI_SSuministro.setBorder(BorderFactory.createEtchedBorder());
        this.JTF_SCodigo.setFont(new Font("Arial", 1, 12));
        this.JTF_SCodigo.setBorder(BorderFactory.createTitledBorder((Border) null, "Código", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTF_SCodigo.addActionListener(new ActionListener() { // from class: Historia.JPI_Cirugias1.35
            public void actionPerformed(ActionEvent evt) {
                JPI_Cirugias1.this.JTF_SCodigoActionPerformed(evt);
            }
        });
        this.JTF_SCodigo.addFocusListener(new FocusAdapter() { // from class: Historia.JPI_Cirugias1.36
            public void focusLost(FocusEvent evt) {
                JPI_Cirugias1.this.JTF_SCodigoFocusLost(evt);
            }
        });
        this.JTF_SNombre.setFont(new Font("Arial", 1, 12));
        this.JTF_SNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTF_SNombre.addMouseListener(new MouseAdapter() { // from class: Historia.JPI_Cirugias1.37
            public void mouseClicked(MouseEvent evt) {
                JPI_Cirugias1.this.JTF_SNombreMouseClicked(evt);
            }
        });
        this.JSP_SCantidad.setFont(new Font("Arial", 1, 12));
        this.JSP_SCantidad.setModel(new SpinnerNumberModel(1, 1, (Comparable) null, 1));
        this.JSP_SCantidad.setToolTipText("Cantidad");
        this.JSP_SCantidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Cant.", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCH_SCobrable.setFont(new Font("Arial", 1, 12));
        this.JCH_SCobrable.setText("Cobrable?");
        this.JSP_SObservacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSP_SObservacion.setAutoscrolls(true);
        this.JTA_SObservacion.setColumns(20);
        this.JTA_SObservacion.setFont(new Font("Arial", 1, 12));
        this.JTA_SObservacion.setLineWrap(true);
        this.JTA_SObservacion.setRows(1);
        this.JTA_SObservacion.setTabSize(1);
        this.JSP_SObservacion.setViewportView(this.JTA_SObservacion);
        this.JBT_SAdicionar.setFont(new Font("Arial", 1, 12));
        this.JBT_SAdicionar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBT_SAdicionar.setText("Adicionar");
        this.JBT_SAdicionar.addActionListener(new ActionListener() { // from class: Historia.JPI_Cirugias1.38
            public void actionPerformed(ActionEvent evt) {
                JPI_Cirugias1.this.JBT_SAdicionarActionPerformed(evt);
            }
        });
        GroupLayout JPI_SSuministroLayout = new GroupLayout(this.JPI_SSuministro);
        this.JPI_SSuministro.setLayout(JPI_SSuministroLayout);
        JPI_SSuministroLayout.setHorizontalGroup(JPI_SSuministroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_SSuministroLayout.createSequentialGroup().addContainerGap().addGroup(JPI_SSuministroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_SSuministroLayout.createSequentialGroup().addComponent(this.JTF_SCodigo, -2, 96, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTF_SNombre)).addComponent(this.JSP_SObservacion)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPI_SSuministroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JBT_SAdicionar, GroupLayout.Alignment.TRAILING, -2, 188, -2).addGroup(GroupLayout.Alignment.TRAILING, JPI_SSuministroLayout.createSequentialGroup().addComponent(this.JSP_SCantidad, -2, 63, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCH_SCobrable).addGap(46, 46, 46))).addContainerGap()));
        JPI_SSuministroLayout.setVerticalGroup(JPI_SSuministroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPI_SSuministroLayout.createSequentialGroup().addContainerGap().addGroup(JPI_SSuministroLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTF_SNombre, -2, 50, -2).addComponent(this.JSP_SCantidad, -2, 50, -2).addComponent(this.JCH_SCobrable).addComponent(this.JTF_SCodigo, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPI_SSuministroLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JBT_SAdicionar, -2, 47, -2).addComponent(this.JSP_SObservacion, -2, -1, -2)).addContainerGap(-1, 32767)));
        this.JSP_SDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 12), Color.red));
        this.JTB_SDetalle_Sumnistro.setFont(new Font("Arial", 1, 12));
        this.JTB_SDetalle_Sumnistro.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTB_SDetalle_Sumnistro.setSelectionBackground(new Color(255, 255, 255));
        this.JTB_SDetalle_Sumnistro.setSelectionForeground(Color.red);
        this.JTB_SDetalle_Sumnistro.addKeyListener(new KeyAdapter() { // from class: Historia.JPI_Cirugias1.39
            public void keyPressed(KeyEvent evt) {
                JPI_Cirugias1.this.JTB_SDetalle_SumnistroKeyPressed(evt);
            }
        });
        this.JSP_SDetalle.setViewportView(this.JTB_SDetalle_Sumnistro);
        GroupLayout JPI_SumimistroLayout = new GroupLayout(this.JPI_Sumimistro);
        this.JPI_Sumimistro.setLayout(JPI_SumimistroLayout);
        JPI_SumimistroLayout.setHorizontalGroup(JPI_SumimistroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_SumimistroLayout.createSequentialGroup().addContainerGap().addGroup(JPI_SumimistroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPI_SSuministro, -1, -1, 32767).addComponent(this.JSP_SDetalle, -1, 780, 32767)).addContainerGap()));
        JPI_SumimistroLayout.setVerticalGroup(JPI_SumimistroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_SumimistroLayout.createSequentialGroup().addContainerGap().addComponent(this.JPI_SSuministro, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSP_SDetalle, -1, 254, 32767).addContainerGap()));
        this.JTPDatos_Qx.addTab("SUMINISTRO O DISPOSITIVOS MEDICOS", this.JPI_Sumimistro);
        this.JBTCierre.setFont(new Font("Arial", 1, 12));
        this.JBTCierre.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTCierre.setText("Cierre de Cirugía");
        this.JBTCierre.addActionListener(new ActionListener() { // from class: Historia.JPI_Cirugias1.40
            public void actionPerformed(ActionEvent evt) {
                JPI_Cirugias1.this.JBTCierreActionPerformed(evt);
            }
        });
        this.JBTRNacido.setFont(new Font("Arial", 1, 12));
        this.JBTRNacido.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Paciente.png")));
        this.JBTRNacido.setText("Recien Nacido");
        this.JBTRNacido.addActionListener(new ActionListener() { // from class: Historia.JPI_Cirugias1.41
            public void actionPerformed(ActionEvent evt) {
                JPI_Cirugias1.this.JBTRNacidoActionPerformed(evt);
            }
        });
        this.JDC_CFecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDC_CFecha.setDateFormatString("dd/MM/yyyy");
        this.JDC_CFecha.setFont(new Font("Arial", 1, 12));
        this.JTFF_CHora.setBorder(BorderFactory.createTitledBorder((Border) null, "Hora", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFF_CHora.setFormatterFactory(new DefaultFormatterFactory(new DateFormatter(new SimpleDateFormat("HH:mm:ss"))));
        this.JTFF_CHora.setFont(new Font("Arial", 1, 12));
        this.JTFF_CHora.addKeyListener(new KeyAdapter() { // from class: Historia.JPI_Cirugias1.42
            public void keyPressed(KeyEvent evt) {
                JPI_Cirugias1.this.JTFF_CHoraKeyPressed(evt);
            }
        });
        this.JPIEstado.setBorder(BorderFactory.createTitledBorder((Border) null, "Estado", 0, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.JBGEstadoS.add(this.JRBEVivo);
        this.JRBEVivo.setFont(new Font("Arial", 1, 12));
        this.JRBEVivo.setSelected(true);
        this.JRBEVivo.setText("Vivo");
        this.JBGEstadoS.add(this.JRBEMuerto);
        this.JRBEMuerto.setFont(new Font("Arial", 1, 12));
        this.JRBEMuerto.setText("Muerto");
        GroupLayout JPIEstadoLayout = new GroupLayout(this.JPIEstado);
        this.JPIEstado.setLayout(JPIEstadoLayout);
        JPIEstadoLayout.setHorizontalGroup(JPIEstadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIEstadoLayout.createSequentialGroup().addContainerGap().addComponent(this.JRBEVivo).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JRBEMuerto).addContainerGap()));
        JPIEstadoLayout.setVerticalGroup(JPIEstadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIEstadoLayout.createSequentialGroup().addGroup(JPIEstadoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBEVivo).addComponent(this.JRBEMuerto)).addGap(10, 10, 10)));
        GroupLayout JPIDAdicionalesLayout = new GroupLayout(this.JPIDAdicionales);
        this.JPIDAdicionales.setLayout(JPIDAdicionalesLayout);
        JPIDAdicionalesLayout.setHorizontalGroup(JPIDAdicionalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDAdicionalesLayout.createSequentialGroup().addContainerGap().addGroup(JPIDAdicionalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDAdicionalesLayout.createSequentialGroup().addComponent(this.JBTCierre, -2, 225, -2).addGap(27, 27, 27).addComponent(this.JBTRNacido, -2, 225, -2)).addGroup(JPIDAdicionalesLayout.createSequentialGroup().addComponent(this.JDC_CFecha, -2, 113, -2).addGap(18, 18, 18).addComponent(this.JTFF_CHora, -2, 99, -2).addGap(18, 18, 18).addComponent(this.JPIEstado, -2, -1, -2))).addContainerGap(322, 32767)));
        JPIDAdicionalesLayout.setVerticalGroup(JPIDAdicionalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDAdicionalesLayout.createSequentialGroup().addGroup(JPIDAdicionalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDAdicionalesLayout.createSequentialGroup().addGap(8, 8, 8).addGroup(JPIDAdicionalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFF_CHora, -2, 50, -2).addComponent(this.JDC_CFecha, -2, 50, -2))).addGroup(JPIDAdicionalesLayout.createSequentialGroup().addContainerGap().addComponent(this.JPIEstado, -1, -1, 32767))).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIDAdicionalesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBTCierre, -2, 49, -2).addComponent(this.JBTRNacido, -2, 49, -2)).addContainerGap(336, 32767)));
        this.JTPDatos_Qx.addTab("CIERRE", this.JPIDAdicionales);
        GroupLayout JPIDatos_IntervencionLayout = new GroupLayout(this.JPIDatos_Intervencion);
        this.JPIDatos_Intervencion.setLayout(JPIDatos_IntervencionLayout);
        JPIDatos_IntervencionLayout.setHorizontalGroup(JPIDatos_IntervencionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatos_IntervencionLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatos_IntervencionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTPDatos_Qx, -2, 805, -2).addComponent(this.JPIDInicio, -2, -1, -2)).addContainerGap(-1, 32767)));
        JPIDatos_IntervencionLayout.setVerticalGroup(JPIDatos_IntervencionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatos_IntervencionLayout.createSequentialGroup().addComponent(this.JPIDInicio, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTPDatos_Qx).addContainerGap()));
        this.JTPDatosIntervencion.addTab("INTERVENCIÓN QUIRÚRGICA", this.JPIDatos_Intervencion);
        this.JTB_Historico.setFont(new Font("Arial", 1, 12));
        this.JTB_Historico.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTB_Historico.setSelectionBackground(new Color(255, 255, 255));
        this.JTB_Historico.setSelectionForeground(Color.red);
        this.JTB_Historico.addMouseListener(new MouseAdapter() { // from class: Historia.JPI_Cirugias1.43
            public void mouseClicked(MouseEvent evt) {
                JPI_Cirugias1.this.JTB_HistoricoMouseClicked(evt);
            }
        });
        this.JSP_Historico.setViewportView(this.JTB_Historico);
        this.JTPDatosIntervencion.addTab("HISTÓRICO", this.JSP_Historico);
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTPDatosIntervencion)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTPDatosIntervencion));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTB_HistoricoMouseClicked(MouseEvent evt) {
        if (this.JTB_Historico.getSelectedRow() != -1) {
            mCargarCx_Activa(this.JTB_Historico.getSelectedRow());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_RVia_IgualActionPerformed(ActionEvent evt) {
        this.xVia_Acceso = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_RVia_DiferenteActionPerformed(ActionEvent evt) {
        this.xVia_Acceso = 1L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTF_RCodigoFocusLost(FocusEvent evt) {
        mBuscar_Procedimiento();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTF_RCodigoActionPerformed(ActionEvent evt) {
        this.JTF_RCodigo.transferFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTAdicionarActionPerformed(ActionEvent evt) {
        if (!this.JLBNumero.getText().isEmpty()) {
            if (this.JTF_RNombre.getText().isEmpty()) {
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un procedimiento", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JTF_RNombre.requestFocus();
                return;
            }
            if (this.xVia_Acceso == -1) {
                JOptionPane.showInternalMessageDialog(this, "Seleccione via de acceso", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JTF_RCodigo.requestFocus();
                return;
            }
            if (this.xBilateral == -1) {
                JOptionPane.showInternalMessageDialog(this, "Seleccione bilateral", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JTF_RCodigo.requestFocus();
                return;
            }
            if (this.XContaminado != -1) {
                int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0);
                if (x == 0) {
                    this.xsql = "insert into h_orden_qx_procedimientos(`Id_Orden_Qx` , `Id_Procedimiento` , `Id_Profesional` , `Id_Especialidad` , `Via` , `Bilateral` , `Contaminado`,`Orden`, `UsuaraioS` )values('" + this.JLBNumero.getText() + "','" + this.JTF_RCodigo.getText() + "','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "','" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "','" + this.xVia_Acceso + "','" + this.xBilateral + "','" + this.XContaminado + "','" + this.JSPNOrden.getValue() + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                    this.xct.ejecutarSQL(this.xsql);
                    this.xct.cerrarConexionBd();
                    mCargarDatosTabla_DProcedimiento();
                    this.JTF_RCodigo.setText("");
                    this.JTF_RNombre.setText("");
                    this.xSuministro_Procedimiento = -1L;
                    this.JTF_RCodigo.requestFocus();
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Seleccione contaminado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTF_RCodigo.requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_IAdicionarActionPerformed(ActionEvent evt) {
        if (!this.JLBNumero.getText().isEmpty()) {
            if (this.JCB_IEspecialidad.getSelectedIndex() != -1) {
                if (this.JCB_IProfesional.getSelectedIndex() != -1) {
                    int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0);
                    if (x == 0) {
                        this.xsql = "insert into h_orden_qx_integrantes(`Id_OrdenQx` , `Id_Persona` , `Id_Especialidad` , `Observacion` , `Orden` , `UsuarioS`)values('" + this.JLBNumero.getText() + "','" + this.xId_Profesional[this.JCB_IProfesional.getSelectedIndex()] + "','" + this.xId_Especialidad[this.JCB_IEspecialidad.getSelectedIndex()] + "','" + this.JTA_IObservacion.getText() + "','" + this.JSP_INOrden.getValue() + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                        this.xct.ejecutarSQL(this.xsql);
                        this.xct.cerrarConexionBd();
                        mCargarDatosTabla_DIntegrante();
                        this.JTA_IObservacion.setText("");
                        this.JCB_IProfesional.removeAllItems();
                        this.JSP_INOrden.setValue(new Integer(0));
                        this.JCB_IEspecialidad.setSelectedIndex(-1);
                        this.JCB_IEspecialidad.requestFocus();
                        return;
                    }
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un profesional", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JCB_IProfesional.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una especialidad", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCB_IEspecialidad.requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCB_IEspecialidadItemStateChanged(ItemEvent evt) {
        if (this.xLleno_CIntegrante && this.JCB_IEspecialidad.getSelectedIndex() != -1) {
            this.JCB_IProfesional.removeAllItems();
            ConsultasMySQL xct1 = new ConsultasMySQL();
            this.xsql = "SELECT  `profesional1`.`Id_Persona` , `profesional1`.`NProfesional` , `g_especialidad`.`Id` FROM `g_profesionalespecial` INNER JOIN  `g_especialidad`  ON (`g_profesionalespecial`.`Id_Especialidad` = `g_especialidad`.`Id`) INNER JOIN  `profesional1`  ON (`profesional1`.`Id_Persona` = `g_profesionalespecial`.`Id_Profesional`) AND (`profesional1`.`IdEspecialidad` = `g_profesionalespecial`.`Id_Especialidad`) WHERE (`g_especialidad`.`Id` ='" + this.xId_Especialidad[this.JCB_IEspecialidad.getSelectedIndex()] + "' AND `g_especialidad`.`Es_Qx` =1) ORDER BY `profesional1`.`NProfesional` ASC ";
            this.xId_Profesional = xct1.llenarCombo(this.xsql, this.xId_Profesional, this.JCB_IProfesional);
            this.JCB_IProfesional.setSelectedIndex(-1);
            xct1.cerrarConexionBd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_DAdicionarActionPerformed(ActionEvent evt) {
        if (!this.JLBNumero.getText().isEmpty()) {
            if (!this.JTF_DCodigo.getText().isEmpty()) {
                if (!this.JTF_DNombre.getText().isEmpty()) {
                    int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0);
                    if (x == 0) {
                        this.xsql = "insert into h_orden_qx_diagnostico(`Id_Orden_Qx` , `Id_Patologia` , `Tipo` , `Observacion` , `Orden` , `UsuarioS`)values('" + this.JLBNumero.getText() + "','" + this.JTF_DCodigo.getText() + "','" + this.xTipo_Diagnostico + "','" + this.JTA_DObservacion.getText() + "','" + this.JSP_DNOrden.getValue() + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                        this.xct.ejecutarSQL(this.xsql);
                        this.xct.cerrarConexionBd();
                        mCargarDatosTabla_DDiagnostico();
                        mNuevo_Diagnostico();
                        this.JTF_DCodigo.requestFocus();
                        return;
                    }
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Nombre de patologia no puede ser nulo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JTF_DNombre.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Código no puede ser nulo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTF_DCodigo.requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTF_DCodigoActionPerformed(ActionEvent evt) {
        this.JTF_DCodigo.transferFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTF_DCodigoFocusLost(FocusEvent evt) {
        mBuscar_Patologia();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_DPreOperatorioActionPerformed(ActionEvent evt) {
        this.xTipo_Diagnostico = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_DPosOperatorioActionPerformed(ActionEvent evt) {
        this.xTipo_Diagnostico = 1L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_DComplicacionActionPerformed(ActionEvent evt) {
        this.xTipo_Diagnostico = 2L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTF_DNombreMouseClicked(MouseEvent evt) {
        mBuscarPatologiaN(this.JTF_DCodigo, this.JTF_DNombre);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTF_RNombreMouseClicked(MouseEvent evt) {
        if (!this.JLBNumero.getText().isEmpty()) {
            JDBuscar_Informacion xjd_buscar = new JDBuscar_Informacion((Frame) null, true, this.JTF_RCodigo, this.JTF_RNombre, "Procedimiento", 0);
            xjd_buscar.setLocationRelativeTo(this);
            xjd_buscar.setVisible(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTF_SNombreMouseClicked(MouseEvent evt) {
        if (!this.JLBNumero.getText().isEmpty()) {
            JDBuscar_Informacion xjd_buscar = new JDBuscar_Informacion((Frame) null, true, this.JTF_SCodigo, this.JTF_SNombre, this.JCH_SCobrable, "Suministro");
            xjd_buscar.setLocationRelativeTo(this);
            xjd_buscar.setVisible(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_SAdicionarActionPerformed(ActionEvent evt) {
        if (!this.JLBNumero.getText().isEmpty()) {
            if (!this.JTF_SCodigo.getText().isEmpty()) {
                if (!this.JTF_SNombre.getText().isEmpty()) {
                    int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0);
                    if (x == 0) {
                        int xtipo = 0;
                        if (this.JCH_SCobrable.isSelected()) {
                            xtipo = 1;
                        }
                        this.xsql = "insert into h_orden_qx_suministro(`Id_Orden_Qx`, `Id_Suministro`, `Cobrable`, `Cantidad`, `Observacion`, `UsuarioS`)values('" + this.JLBNumero.getText() + "','" + this.JTF_SCodigo.getText() + "','" + xtipo + "','" + this.JSP_SCantidad.getValue() + "','" + this.JTA_SObservacion.getText() + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                        this.xct.ejecutarSQL(this.xsql);
                        this.xct.cerrarConexionBd();
                        mCargarDatosTabla_SSuministro();
                        mNuevo_Suministro();
                        this.JTF_SCodigo.requestFocus();
                        return;
                    }
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Nombre de patologia no puede ser nulo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JTF_DNombre.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Código no puede ser nulo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTF_DCodigo.requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTF_SCodigoActionPerformed(ActionEvent evt) {
        this.JTF_SCodigo.transferFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTF_SCodigoFocusLost(FocusEvent evt) {
        if (!this.JTF_SCodigo.getText().isEmpty()) {
            mBuscar_Suministro();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_NAdicionarActionPerformed(ActionEvent evt) {
        if (!this.JLBNumero.getText().isEmpty()) {
            if (this.JCB_NTipoNota.getSelectedIndex() != -1) {
                if (!this.JTA_NNota.getText().isEmpty()) {
                    int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0);
                    if (x == 0) {
                        if (this.JLB_IdTipoNota.getText().isEmpty()) {
                            this.xsql = "insert into h_orden_qx_notas(`Id_Orden_Qx` , `Id_TipoNota` , `FechaN` , `HoraN` , `Id_Especialidad` , `Id_Profesional` , `Descripcion` , `UsuarioS`)values('" + this.JLBNumero.getText() + "','" + this.xId_TipoNota[this.JCB_NTipoNota.getSelectedIndex()] + "','" + this.xmt.formatoAMD.format(this.JDC_NFecha.getDate()) + "','" + this.JTFF_NHora.getText() + "','" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "','" + this.JTA_NNota.getText() + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                        } else {
                            this.xsql = "update   h_orden_qx_notas set  `Id_TipoNota`='" + this.xId_TipoNota[this.JCB_NTipoNota.getSelectedIndex()] + "' , `FechaN`='" + this.xmt.formatoAMD.format(this.JDC_NFecha.getDate()) + "' , `HoraN`='" + this.JTFF_NHora.getText() + "' , `Descripcion`='" + this.JTA_NNota.getText() + "' Where Id='" + this.JLB_IdTipoNota.getText() + "'";
                        }
                        this.xct.ejecutarSQL(this.xsql);
                        this.xct.cerrarConexionBd();
                        mCargarDatosTabla_NNota();
                        mNueva_Nota();
                        this.JCB_NTipoNota.requestFocus();
                        return;
                    }
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Descripción no puede ser nula", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JTF_DNombre.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un tipo de nota", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTF_DCodigo.requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCB_IServicioItemStateChanged(ItemEvent evt) {
        if (this.xLleno_Servicio && this.JCB_IServicio.getSelectedIndex() != -1) {
            this.JCB_IProcedimiento.removeAllItems();
            ConsultasMySQL xct1 = new ConsultasMySQL();
            this.xsql = "SELECT  `g_procedimiento`.`Id` , `g_procedimiento`.`Nbre` FROM `g_procedimiento` INNER JOIN  `f_tipoprocedimiento`  ON (`g_procedimiento`.`Id_tipoprocedimiento` = `f_tipoprocedimiento`.`Id`) INNER JOIN  `f_tiposervtipoproced`  ON (`f_tiposervtipoproced`.`Idtipoprocedimiento` = `f_tipoprocedimiento`.`Id`) INNER JOIN  `f_tiposervicio`  ON (`f_tiposervtipoproced`.`Idtiposervicio` = `f_tiposervicio`.`Id`) WHERE (`f_tiposervicio`.`Id` ='" + this.xId_Servicio[this.JCB_IServicio.getSelectedIndex()] + "' AND `g_procedimiento`.`Estado` =0) ORDER BY `g_procedimiento`.`Nbre` ASC ";
            this.xId_Procedimiento = xct1.llenarCombo(this.xsql, this.xId_Procedimiento, this.JCB_IProcedimiento);
            this.JCB_IProcedimiento.setSelectedIndex(-1);
            xct1.cerrarConexionBd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_IAdicionar1ActionPerformed(ActionEvent evt) {
        if (!this.JLBNumero.getText().isEmpty()) {
            if (this.JCB_IServicio.getSelectedIndex() != -1) {
                if (this.JCB_IProcedimiento.getSelectedIndex() != -1) {
                    int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0);
                    if (x == 0) {
                        this.xsql = "insert into h_orden_qx_ayudas_dx(`Id_Orden_Qx`, `Id_TipoServicio`, `I_Procedimiento`, `Cantidad`, `Id_Profesional`, `Id_Especialidad`, `UsuarioS`)values('" + this.JLBNumero.getText() + "','" + this.xId_Servicio[this.JCB_IServicio.getSelectedIndex()] + "','" + this.xId_Procedimiento[this.JCB_IProcedimiento.getSelectedIndex()] + "','" + this.JSP_INCantidad.getValue() + "','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "','" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                        this.xct.ejecutarSQL(this.xsql);
                        this.xct.cerrarConexionBd();
                        mCargarDatosTabla_DAyudasDx();
                        this.JCB_IProcedimiento.removeAllItems();
                        this.JSP_INCantidad.setValue(new Integer(1));
                        this.JCB_IServicio.setSelectedIndex(-1);
                        this.JCB_IServicio.requestFocus();
                        return;
                    }
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un profesional", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JCB_IProcedimiento.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una especialidad", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCB_IServicio.requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTCierreActionPerformed(ActionEvent evt) {
        if (!this.JLBNumero.getText().isEmpty()) {
            if (!this.xCerrada) {
                if (this.JTB_RDetalle_Procedimiento.getRowCount() != 0) {
                    if (this.JTB_DDetalle_Diagnostico.getRowCount() != 0) {
                        if (this.JTB_IDetalle_Integrante.getRowCount() != 0) {
                            if (this.JTB_NDetalle_Nota.getRowCount() != 0) {
                                if (!this.xmt.getValidarFechaHoraNoMayor(String.valueOf(this.xmt.formatoDMA.format(this.JDC_FechaI.getDate()).concat(" ").concat(this.JTFF_HoraI.getText())), String.valueOf(this.xmt.formatoDMA.format(this.JDC_CFecha.getDate()).concat(" ").concat(this.JTFF_CHora.getText()))).booleanValue()) {
                                    int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de cerrar la intervención quirúrgica??", "CONFIRMAR", 0);
                                    if (x == 0) {
                                        int estado = 1;
                                        if (this.JRBEMuerto.isSelected()) {
                                            estado = 0;
                                        }
                                        this.xsql = "update h_orden_qx set `Fecha_Final`='" + this.xmt.formatoAMD.format(this.JDC_CFecha.getDate()) + "', `Hora_Final`='" + this.xmt.formatoH24.format(this.JTFF_CHora.getValue()) + "', `estadoSalida`='" + estado + "' where Id='" + this.JLBNumero.getText() + "'";
                                        this.xct.ejecutarSQL(this.xsql);
                                        this.xct.cerrarConexionBd();
                                        mCargarDatosTabla();
                                        JOptionPane.showInternalMessageDialog(this, "La intervención quirúrgica se a cerrado satisfactoriamente", "REALIZADO", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                        return;
                                    }
                                    return;
                                }
                                JOptionPane.showInternalMessageDialog(this, "Fecha de cierre no puede menor a la fecha de incio", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                this.JDC_FechaI.requestFocus();
                                return;
                            }
                            JOptionPane.showInternalMessageDialog(this, "Debe haber al menos un registro en la tabla de descripcion", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                            this.JTPDatos_Qx.setSelectedIndex(3);
                            return;
                        }
                        JOptionPane.showInternalMessageDialog(this, "Debe haber al menos un registro en la tabla de integrantes", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        this.JTPDatos_Qx.setSelectedIndex(0);
                        return;
                    }
                    JOptionPane.showInternalMessageDialog(this, "Debe haber al menos un registro en la tabla de diagnosticos", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    this.JTPDatos_Qx.setSelectedIndex(1);
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Debe haber al menos un registro en la tabla de procedimiento", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JTPDatos_Qx.setSelectedIndex(2);
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "La intervención quirúrgica se encuentra cerrada", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTRNacidoActionPerformed(ActionEvent evt) {
        if (!this.JLBNumero.getText().isEmpty()) {
            if (!this.xCerrada) {
                JDOrdenNacidos xv = new JDOrdenNacidos(null, true, this.JLBNumero.getText());
                xv.setVisible(true);
                return;
            } else {
                JOptionPane.showInternalMessageDialog(this, "La intervención quirúrgica se encuentra cerrada", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                return;
            }
        }
        JOptionPane.showInternalMessageDialog(this, "No tiene una Intervención Quirúrgica cargada", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFF_CHoraKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTB_RDetalle_ProcedimientoKeyPressed(KeyEvent evt) {
        if (!this.xCerrada) {
            if (evt.getKeyCode() == 127 && this.JTB_RDetalle_Procedimiento.getSelectedRow() != -1) {
                int x = JOptionPane.showConfirmDialog((Component) null, "Desea eliminar el procedimiento seleccionado?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (x == 0) {
                    this.xsql = "delete from h_orden_qx_procedimientos WHERE (`Id_Orden_Qx` ='" + this.JLBNumero.getText() + "' AND `Id_Procedimiento` ='" + this.xModelo_Procedimientos.getValueAt(this.JTB_RDetalle_Procedimiento.getSelectedRow(), 0) + "')";
                    this.xct.ejecutarSQL(this.xsql);
                    this.xct.cerrarConexionBd();
                    mCargarDatosTabla_DProcedimiento();
                    return;
                }
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Cirugía cerrada; no es posible eliminar el registro", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTB_DDetalle_DiagnosticoKeyPressed(KeyEvent evt) {
        if (!this.xCerrada) {
            if (evt.getKeyCode() == 127 && this.JTB_DDetalle_Diagnostico.getSelectedRow() != -1) {
                int x = JOptionPane.showConfirmDialog((Component) null, "Desea eliminar el diagnóstico seleccionado?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (x == 0) {
                    this.xsql = "delete from h_orden_qx_diagnostico WHERE (`Id_Orden_Qx` ='" + this.JLBNumero.getText() + "' AND `Id_Patologia` ='" + this.xModelo_Patologia.getValueAt(this.JTB_DDetalle_Diagnostico.getSelectedRow(), 0) + "')";
                    this.xct.ejecutarSQL(this.xsql);
                    this.xct.cerrarConexionBd();
                    mCargarDatosTabla_DDiagnostico();
                    return;
                }
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Cirugía cerrada; no es posible eliminar el registro", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTB_IDetalle_IntegranteKeyPressed(KeyEvent evt) {
        if (!this.xCerrada) {
            if (evt.getKeyCode() == 127 && this.JTB_IDetalle_Integrante.getSelectedRow() != -1) {
                int x = JOptionPane.showConfirmDialog((Component) null, "Desea eliminar el integrante seleccionado?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (x == 0) {
                    this.xsql = "delete from h_orden_qx_integrantes WHERE (`Id_OrdenQx` ='" + this.JLBNumero.getText() + "' AND `Id_Persona` ='" + this.xModelo_Integrantes.getValueAt(this.JTB_IDetalle_Integrante.getSelectedRow(), 4) + "')";
                    this.xct.ejecutarSQL(this.xsql);
                    this.xct.cerrarConexionBd();
                    mCargarDatosTabla_DIntegrante();
                    return;
                }
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Cirugía cerrada; no es posible eliminar el registro", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTB_IDetalle_AyudasDxKeyPressed(KeyEvent evt) {
        if (!this.xCerrada) {
            if (evt.getKeyCode() == 127 && this.JTB_IDetalle_AyudasDx.getSelectedRow() != -1) {
                int x = JOptionPane.showConfirmDialog((Component) null, "Desea eliminar la ayuda diagnóstica seleccionada?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (x == 0) {
                    this.xsql = "update h_orden_qx_ayudas_dx  set Estado = 0 WHERE (`Id_Orden_Qx` ='" + this.JLBNumero.getText() + "' AND `Id` ='" + this.xModelo_AyudasDx.getValueAt(this.JTB_IDetalle_AyudasDx.getSelectedRow(), 4) + "')";
                    this.xct.ejecutarSQL(this.xsql);
                    this.xct.cerrarConexionBd();
                    mCargarDatosTabla_DAyudasDx();
                    return;
                }
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Cirugía cerrada; no es posible eliminar el registro", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTB_SDetalle_SumnistroKeyPressed(KeyEvent evt) {
        if (!this.xCerrada) {
            if (evt.getKeyCode() == 127 && this.JTB_SDetalle_Sumnistro.getSelectedRow() != -1) {
                int x = JOptionPane.showConfirmDialog((Component) null, "Desea eliminar el suministro seleccionado?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (x == 0) {
                    this.xsql = "delete from h_orden_qx_suministro WHERE (`Id_Orden_Qx` ='" + this.JLBNumero.getText() + "' AND `Id_Suministro` ='" + this.xModelo_Suministro.getValueAt(this.JTB_SDetalle_Sumnistro.getSelectedRow(), 0) + "')";
                    this.xct.ejecutarSQL(this.xsql);
                    this.xct.cerrarConexionBd();
                    mCargarDatosTabla_SSuministro();
                    return;
                }
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Cirugía cerrada; no es posible eliminar el registro", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_BSiActionPerformed(ActionEvent evt) {
        this.xBilateral = 1L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_BNoActionPerformed(ActionEvent evt) {
        this.xBilateral = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_CSiActionPerformed(ActionEvent evt) {
        this.XContaminado = 1L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_CNoActionPerformed(ActionEvent evt) {
        this.XContaminado = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_NPredefinidaActionPerformed(ActionEvent evt) {
        mCargar_NotasP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTPDatos_QxMouseClicked(MouseEvent evt) {
        if (this.JTPDatos_Qx.getSelectedIndex() == 6 && !this.JLBNumero.getText().isEmpty() && !this.xCerrada) {
            try {
                this.xsql = "SELECT  TIME(DATE_ADD(CONCAT(`h_orden_qx`.`Fecha_Inicial`, ' ',`h_orden_qx`.`Hora_Inicla`), INTERVAL g_procedimiento.`NDiasR` MINUTE)) AS Hora FROM  `h_orden_qx_procedimientos` INNER JOIN `h_orden_qx`  ON (`h_orden_qx_procedimientos`.`Id_Orden_Qx` = `h_orden_qx`.`Id`) INNER JOIN `g_procedimiento`  ON (`h_orden_qx_procedimientos`.`Id_Procedimiento` = `g_procedimiento`.`Id`) WHERE (`h_orden_qx`.`Id` ='" + this.JLBNumero.getText() + "' AND `h_orden_qx`.`Estado` =1) ORDER BY `h_orden_qx`.`Hora_Inicla` DESC ";
                ResultSet xrs = this.xct.traerRs(this.xsql);
                if (xrs.next()) {
                    xrs.first();
                    this.JTFF_CHora.setText("" + xrs.getTime(1));
                }
                xrs.close();
                this.xct.cerrarConexionBd();
            } catch (SQLException ex) {
                Logger.getLogger(JPI_Cirugias1.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTB_NDetalle_NotaKeyPressed(KeyEvent evt) {
        if (!this.xCerrada) {
            if (evt.getKeyCode() == 127 && this.JTB_NDetalle_Nota.getSelectedRow() != -1) {
                int x = JOptionPane.showConfirmDialog((Component) null, "Desea eliminar la nota?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (x == 0) {
                    this.xsql = "update h_orden_qx_notas set Estado=0 WHERE (`Id` ='" + this.JTB_NDetalle_Nota.getValueAt(this.JTB_NDetalle_Nota.getSelectedRow(), 0) + "')";
                    this.xct.ejecutarSQL(this.xsql);
                    this.xct.cerrarConexionBd();
                    mCargarDatosTabla_NNota();
                    return;
                }
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Cirugía cerrada; no es posible eliminar el registro", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTB_NDetalle_NotaMouseClicked(MouseEvent evt) {
        if (this.JTB_NDetalle_Nota.getSelectedRow() != -1) {
            this.JLB_IdTipoNota.setText(this.JTB_NDetalle_Nota.getValueAt(this.JTB_NDetalle_Nota.getSelectedRow(), 0).toString());
            this.JCB_NTipoNota.setSelectedItem(this.JTB_NDetalle_Nota.getValueAt(this.JTB_NDetalle_Nota.getSelectedRow(), 2).toString());
            this.JDC_CFecha.setDate(this.xmt.getPasarTextoAFecha(this.JTB_NDetalle_Nota.getValueAt(this.JTB_NDetalle_Nota.getSelectedRow(), 1).toString().substring(0, 10)));
            this.JTFF_NHora.setText(this.JTB_NDetalle_Nota.getValueAt(this.JTB_NDetalle_Nota.getSelectedRow(), 1).toString().substring(11, 19));
            this.JTA_NNota.setText(this.JTB_NDetalle_Nota.getValueAt(this.JTB_NDetalle_Nota.getSelectedRow(), 5).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFF_HoraIKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFF_HoraIActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCB_IProcedimientoMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            if (this.JCB_IServicio.getSelectedIndex() != -1) {
                BuscarProced frmBuscarProced = new BuscarProced((Frame) null, true, (JPanel) this, "xjp_intervencion_qx", this.xId_Servicio[this.JCB_IServicio.getSelectedIndex()]);
                frmBuscarProced.setVisible(true);
            } else {
                JOptionPane.showInternalMessageDialog(this, "Seleccione un servicio", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCB_IProcedimientoActionPerformed(ActionEvent evt) {
    }

    private void mIniciarComponentes() {
        if (Principal.informacionIps.getNombreIps().equals("CLINICA OFTALMOLOGICA DAJUD SAS") || Principal.informacionIps.getNombreIps().equals("JAIME CESAR DAJUD FERNANDEZ") || Principal.informacionIps.getNombreIps().equals("COD-OPTICA UT")) {
            this.JRB_BNo.setSelected(true);
            this.XContaminado = 0L;
            this.JPI_RContaminado.setVisible(false);
        }
    }

    private void mCargar_NotasP() {
        JD_NotasPredefinidas dialog = new JD_NotasPredefinidas((Frame) null, true, this.JTA_NNota, this.JTA_NNota, 1);
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }

    private void mBuscarPatologiaN(JTextField codigo, JTextField nombrep) {
        JIFBuscarPatologia pac = new JIFBuscarPatologia(null, true, codigo, nombrep, "cirugia", 0);
        pac.setVisible(true);
        pac.setLocationRelativeTo(this);
    }

    /* JADX WARN: Finally extract failed */
    private void mBuscar_Procedimiento() {
        if (!this.JTF_RCodigo.getText().isEmpty()) {
            try {
                this.xsql = "SELECT  `g_procedimiento`.`Id` , `g_procedimiento`.`Nbre` FROM `g_procedimiento` INNER JOIN  `f_tipoprocedimiento`  ON (`g_procedimiento`.`Id_tipoprocedimiento` = `f_tipoprocedimiento`.`Id`) INNER JOIN  `f_tipoclaseproc`  ON (`f_tipoprocedimiento`.`Id_tipoclaseproc` = `f_tipoclaseproc`.`Id`)  WHERE (IFNULL(g_procedimiento.C_Homologado, `g_procedimiento`.`Id`) ='" + this.JTF_RCodigo.getText() + "' AND `f_tipoclaseproc`.`EsQco` =0 AND `g_procedimiento`.`Estado`=0) ORDER BY `g_procedimiento`.`Nbre` ASC ";
                ResultSet xrs = this.xct.traerRs(this.xsql);
                Throwable th = null;
                try {
                    if (xrs.next()) {
                        xrs.first();
                        this.JTF_RNombre.setText(xrs.getString(2));
                    } else {
                        JOptionPane.showInternalMessageDialog(this, "Código de procedimiento no existe", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        this.JTF_RCodigo.setText("");
                        this.xSuministro_Procedimiento = -1L;
                        this.JTF_RCodigo.requestFocus();
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
                Logger.getLogger(JPI_Cirugias1.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
    }

    private void mBuscar_Patologia() {
        if (!this.JTF_DCodigo.getText().isEmpty()) {
            try {
                this.xsql = "SELECT  `Nbre`, `Id` FROM  `g_patologia` WHERE (`Id` ='" + this.JTF_DCodigo.getText() + "' and Estado=1) ";
                ResultSet xrs = this.xct.traerRs(this.xsql);
                if (xrs.next()) {
                    xrs.first();
                    this.JTF_DCodigo.setText(xrs.getString(2));
                    this.JTF_DNombre.setText(xrs.getString(1));
                } else {
                    JOptionPane.showInternalMessageDialog(this, "Código de diagnóstico no existe", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    this.JTF_DCodigo.setText("");
                    this.JTF_DNombre.requestFocus();
                }
                xrs.close();
                this.xct.cerrarConexionBd();
            } catch (SQLException ex) {
                Logger.getLogger(JPI_Cirugias1.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
    }

    private void mBuscar_Suministro() {
        if (!this.JTF_SCodigo.getText().isEmpty()) {
            try {
                this.xsql = "SELECT `i_suministro`.`Id` , CONCAT(`i_suministro`.`Nbre`,' ', `i_presentacionfarmaceutica`.`Nbre`) AS `NSuministro` , `i_suministro`.`Escobrable` FROM  `i_suministro` INNER JOIN  `i_presentacionfarmaceutica`  ON (`i_suministro`.`IdPresentacionFarmaceutica` = `i_presentacionfarmaceutica`.`Id`) WHERE (`i_suministro`.`Id` ='" + this.JTF_SCodigo.getText() + "' AND `i_suministro`.`EstaActivo` =0) ORDER BY `NSuministro` ASC ";
                ResultSet xrs = this.xct.traerRs(this.xsql);
                Throwable th = null;
                try {
                    if (xrs.next()) {
                        xrs.first();
                        this.JTF_SCodigo.setText(xrs.getString(1));
                        this.JTF_SNombre.setText(xrs.getString(2));
                        this.JCH_SCobrable.setSelected(xrs.getBoolean(3));
                    } else {
                        JOptionPane.showInternalMessageDialog(this, "Código de suministro no existe", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        this.JTF_SCodigo.setText("");
                        this.JTF_SNombre.requestFocus();
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
                Logger.getLogger(JPI_Cirugias1.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
    }

    public void mNuevo() {
        this.JDC_FechaI.setDate(this.xmt.getFechaActual());
        this.JDC_CFecha.setDate(this.xmt.getFechaActual());
        this.JTFF_HoraI.setValue(this.xmt.getFechaActual());
        this.JTFF_CHora.setValue(this.xmt.getFechaActual());
        this.JCBTipo_Anestecia.removeAllItems();
        this.xId_Anestesia = this.xct.llenarCombo("SELECT  `Id` , `Nbre` FROM `f_tipoanestesia` WHERE (`Estado` =0) ORDER BY `Nbre` ASC", this.xId_Anestesia, this.JCBTipo_Anestecia);
        this.JCBTipo_Anestecia.setSelectedIndex(-1);
        mNuevo_Integrante();
        mNuevo_Diagnostico();
        mNuevo_Suministro();
        mNueva_AyudasDx();
        mNueva_Nota();
        mCrearModelo_Procedimiento();
        mCrearModelo_Integrantes();
        mCrearModelo_Patologia();
        mCrearModelo_Suministro();
        mCrearModelo_AyudasDx();
        mCrearModelo_Nota();
        mCargarDatosTabla();
    }

    private void mNuevo_Integrante() {
        this.xLleno_CIntegrante = false;
        this.JCB_IEspecialidad.removeAllItems();
        this.xsql = "SELECT  `g_especialidad`.`Id` , `g_especialidad`.`Nbre` FROM  `g_profesionalespecial` INNER JOIN  `g_especialidad`  ON (`g_profesionalespecial`.`Id_Especialidad` = `g_especialidad`.`Id`) INNER JOIN `profesional1`  ON (`profesional1`.`Id_Persona` = `g_profesionalespecial`.`Id_Profesional`) AND (`profesional1`.`IdEspecialidad` = `g_profesionalespecial`.`Id_Especialidad`) WHERE (`g_especialidad`.`Es_Qx` =1) GROUP BY `g_especialidad`.`Id` ORDER BY `g_especialidad`.`Nbre` ASC ";
        this.xId_Especialidad = this.xct.llenarCombo(this.xsql, this.xId_Especialidad, this.JCB_IEspecialidad);
        this.xct.cerrarConexionBd();
        this.JCB_IEspecialidad.setSelectedIndex(-1);
        this.JSP_INOrden.setValue(new Integer(0));
        this.JTA_IObservacion.setText("");
        this.xLleno_CIntegrante = true;
    }

    private void mNuevo_Diagnostico() {
        this.JTF_DCodigo.setText("");
        this.JTF_DNombre.setText("");
        this.JSP_DNOrden.setValue(new Integer(0));
        this.JTA_DObservacion.setText("");
    }

    private void mNueva_AyudasDx() {
        this.xLleno_Servicio = false;
        this.JCB_IServicio.removeAllItems();
        this.xsql = "SELECT  `f_tiposervicio`.`Id` , `f_tiposervicio`.`Nbre` FROM  `g_procedimiento` INNER JOIN `f_tipoprocedimiento`  ON (`g_procedimiento`.`Id_tipoprocedimiento` = `f_tipoprocedimiento`.`Id`) INNER JOIN `f_tiposervtipoproced`  ON (`f_tiposervtipoproced`.`Idtipoprocedimiento` = `f_tipoprocedimiento`.`Id`) INNER JOIN `f_tiposervicio`  ON (`f_tiposervtipoproced`.`Idtiposervicio` = `f_tiposervicio`.`Id`) WHERE (`f_tipoprocedimiento`.`Id` IN(6,8,9,12)) GROUP BY `f_tipoprocedimiento`.`Id` ORDER BY `f_tiposervicio`.`Nbre` ASC ";
        this.xId_Servicio = this.xct.llenarCombo(this.xsql, this.xId_Servicio, this.JCB_IServicio);
        this.xct.cerrarConexionBd();
        this.JCB_IServicio.setSelectedIndex(-1);
        this.JSP_INCantidad.setValue(new Integer(1));
        this.xLleno_Servicio = true;
    }

    private void mNuevo_Suministro() {
        this.JTF_SCodigo.setText("");
        this.JTF_SNombre.setText("");
        this.JSP_SCantidad.setValue(new Integer(0));
        this.JTA_SObservacion.setText("");
    }

    private void mNueva_Nota() {
        this.JDC_NFecha.setDate(this.xmt.getFechaActual());
        this.JTFF_NHora.setText(this.xmt.formatoH24.format(this.xmt.getFechaActual()));
        this.JTA_NNota.setText("");
        this.JLB_IdTipoNota.setText("");
        this.JCB_NTipoNota.removeAllItems();
        this.xsql = "SELECT `h_tiponota`.`Id` , `h_tiponota`.`Nbre` FROM `h_tiponota_especialidad` INNER JOIN  `h_tiponota`  ON (`h_tiponota_especialidad`.`Id_TipoNota` = `h_tiponota`.`Id`) WHERE (`h_tiponota_especialidad`.`Id_Especialidad` ='" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "' AND `h_tiponota_especialidad`.`Estado` =1 AND `h_tiponota`.`Id_Clasificacion`=9) ORDER BY `h_tiponota`.`Nbre` ASC ";
        this.xId_TipoNota = this.xct.llenarCombo(this.xsql, this.xId_TipoNota, this.JCB_NTipoNota);
        this.JCB_NTipoNota.setSelectedIndex(-1);
        this.xct.cerrarConexionBd();
    }

    public void mGrabar() {
        if (this.JLBNumero.getText().isEmpty()) {
            if (this.JCBTipo_Anestecia.getSelectedIndex() != -1) {
                int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0);
                if (x == 0) {
                    this.xsql = "insert into h_orden_qx   (`Id_Atencion` , `Fecha_Inicial` , `Hora_Inicla` , `Id_Tipo_Anestesia` , `UsuarioS` )  values ('" + this.xId_Atencion + "','" + this.xmt.formatoAMD.format(this.JDC_FechaI.getDate()) + "','" + this.xmt.formatoH24.format(this.JTFF_HoraI.getValue()) + "','" + this.xId_Anestesia[this.JCBTipo_Anestecia.getSelectedIndex()] + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                    System.out.println(this.xsql);
                    this.JLBNumero.setText(this.xct.ejecutarSQLId(this.xsql));
                    this.xct.cerrarConexionBd();
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un tipo de anestesia", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBTipo_Anestecia.requestFocus();
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloHistorico() {
        this.xModelo_Historico = new DefaultTableModel(new Object[0], new String[]{"Id", "Fecha_Inicial", "Hora_Inicial", "Fecha_Final", "Hora Final", "Anestesia", "Estado"}) { // from class: Historia.JPI_Cirugias1.44
            Class[] types = {Long.class, String.class, String.class, String.class, String.class, String.class, Integer.class};
            boolean[] canEdit = {false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTB_Historico.setModel(this.xModelo_Historico);
        this.JTB_Historico.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTB_Historico.getColumnModel().getColumn(1).setPreferredWidth(20);
        this.JTB_Historico.getColumnModel().getColumn(2).setPreferredWidth(20);
        this.JTB_Historico.getColumnModel().getColumn(3).setPreferredWidth(20);
        this.JTB_Historico.getColumnModel().getColumn(4).setPreferredWidth(20);
        this.JTB_Historico.getColumnModel().getColumn(5).setPreferredWidth(50);
        this.JTB_Historico.getColumnModel().getColumn(6).setPreferredWidth(10);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModelo_Procedimiento() {
        this.xModelo_Procedimientos = new DefaultTableModel(new Object[0], new String[]{"Código", "Procedimiento", "Especialidad", "Profesional", "Vía Acceso", "Bilateral", "Contaminado", "Orden"}) { // from class: Historia.JPI_Cirugias1.45
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, Long.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTB_RDetalle_Procedimiento.setModel(this.xModelo_Procedimientos);
        this.JTB_RDetalle_Procedimiento.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTB_RDetalle_Procedimiento.getColumnModel().getColumn(1).setPreferredWidth(200);
        this.JTB_RDetalle_Procedimiento.getColumnModel().getColumn(2).setPreferredWidth(30);
        this.JTB_RDetalle_Procedimiento.getColumnModel().getColumn(3).setPreferredWidth(80);
        this.JTB_RDetalle_Procedimiento.getColumnModel().getColumn(4).setPreferredWidth(10);
        this.JTB_RDetalle_Procedimiento.getColumnModel().getColumn(5).setPreferredWidth(10);
        this.JTB_RDetalle_Procedimiento.getColumnModel().getColumn(6).setPreferredWidth(10);
        this.JTB_RDetalle_Procedimiento.getColumnModel().getColumn(7).setPreferredWidth(10);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModelo_Integrantes() {
        this.xModelo_Integrantes = new DefaultTableModel(new Object[0], new String[]{"Especialidad", "Profesional", "Observacion", "Orden", "Id_Persona"}) { // from class: Historia.JPI_Cirugias1.46
            Class[] types = {String.class, String.class, String.class, Long.class, Long.class};
            boolean[] canEdit = {false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTB_IDetalle_Integrante.setModel(this.xModelo_Integrantes);
        this.JTB_IDetalle_Integrante.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTB_IDetalle_Integrante.getColumnModel().getColumn(1).setPreferredWidth(200);
        this.JTB_IDetalle_Integrante.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTB_IDetalle_Integrante.getColumnModel().getColumn(3).setPreferredWidth(10);
        this.JTB_IDetalle_Integrante.getColumnModel().getColumn(4).setPreferredWidth(0);
        this.JTB_IDetalle_Integrante.getColumnModel().getColumn(4).setMinWidth(0);
        this.JTB_IDetalle_Integrante.getColumnModel().getColumn(4).setMaxWidth(0);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModelo_Patologia() {
        this.xModelo_Patologia = new DefaultTableModel(new Object[0], new String[]{"Cie10", "Patología", "Tipo", "Observación", "Orden"}) { // from class: Historia.JPI_Cirugias1.47
            Class[] types = {String.class, String.class, String.class, String.class, Long.class};
            boolean[] canEdit = {false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTB_DDetalle_Diagnostico.setModel(this.xModelo_Patologia);
        this.JTB_DDetalle_Diagnostico.getColumnModel().getColumn(0).setPreferredWidth(20);
        this.JTB_DDetalle_Diagnostico.getColumnModel().getColumn(1).setPreferredWidth(300);
        this.JTB_DDetalle_Diagnostico.getColumnModel().getColumn(2).setPreferredWidth(30);
        this.JTB_DDetalle_Diagnostico.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTB_DDetalle_Diagnostico.getColumnModel().getColumn(4).setPreferredWidth(10);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModelo_Suministro() {
        this.xModelo_Suministro = new DefaultTableModel(new Object[0], new String[]{"Código", "Tipo", "Nombre", "Cobrable", "Cantidad", "Observación"}) { // from class: Historia.JPI_Cirugias1.48
            Class[] types = {Long.class, String.class, String.class, Boolean.class, Long.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTB_SDetalle_Sumnistro.setModel(this.xModelo_Suministro);
        this.JTB_SDetalle_Sumnistro.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTB_SDetalle_Sumnistro.getColumnModel().getColumn(1).setPreferredWidth(50);
        this.JTB_SDetalle_Sumnistro.getColumnModel().getColumn(2).setPreferredWidth(200);
        this.JTB_SDetalle_Sumnistro.getColumnModel().getColumn(3).setPreferredWidth(10);
        this.JTB_SDetalle_Sumnistro.getColumnModel().getColumn(4).setPreferredWidth(10);
        this.JTB_SDetalle_Sumnistro.getColumnModel().getColumn(5).setPreferredWidth(80);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModelo_Nota() {
        this.xModelo_Nota = new DefaultTableModel(new Object[0], new String[]{"Id", "Fecha Hora", "Tipo", "Especialidad", "Profesional", "Descripcion"}) { // from class: Historia.JPI_Cirugias1.49
            Class[] types = {Long.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTB_NDetalle_Nota.setModel(this.xModelo_Nota);
        this.JTB_NDetalle_Nota.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTB_NDetalle_Nota.getColumnModel().getColumn(1).setPreferredWidth(30);
        this.JTB_NDetalle_Nota.getColumnModel().getColumn(2).setPreferredWidth(50);
        this.JTB_NDetalle_Nota.getColumnModel().getColumn(3).setPreferredWidth(30);
        this.JTB_NDetalle_Nota.getColumnModel().getColumn(4).setPreferredWidth(80);
        this.JTB_NDetalle_Nota.getColumnModel().getColumn(5).setPreferredWidth(200);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModelo_AyudasDx() {
        this.xModelo_AyudasDx = new DefaultTableModel(new Object[0], new String[]{"Id", "Fecha", "Servicio", "Procedimiento", "Cantidad"}) { // from class: Historia.JPI_Cirugias1.50
            Class[] types = {Long.class, String.class, String.class, String.class, Long.class};
            boolean[] canEdit = {false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTB_IDetalle_AyudasDx.setModel(this.xModelo_AyudasDx);
        this.JTB_IDetalle_AyudasDx.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTB_IDetalle_AyudasDx.getColumnModel().getColumn(1).setPreferredWidth(20);
        this.JTB_IDetalle_AyudasDx.getColumnModel().getColumn(2).setPreferredWidth(50);
        this.JTB_IDetalle_AyudasDx.getColumnModel().getColumn(3).setPreferredWidth(200);
        this.JTB_IDetalle_AyudasDx.getColumnModel().getColumn(3).setPreferredWidth(10);
    }

    private void mCargarCx_Activa(int xfila) {
        this.JLBNumero.setText(this.xModelo_Historico.getValueAt(xfila, 0).toString());
        this.JDC_FechaI.setDate(this.xmt.getPasarTextoAFecha(this.xModelo_Historico.getValueAt(xfila, 1).toString()));
        this.JTFF_HoraI.setValue(this.xmt.getPasarTextoAFechaHora(this.xModelo_Historico.getValueAt(xfila, 1).toString() + " " + this.xModelo_Historico.getValueAt(xfila, 2).toString()));
        this.JCBTipo_Anestecia.setSelectedItem(this.xModelo_Historico.getValueAt(xfila, 5).toString());
        this.xCerrada = Boolean.valueOf(this.xModelo_Historico.getValueAt(xfila, 6).toString()).booleanValue();
        mCargarDatosTabla_DProcedimiento();
        mCargarDatosTabla_DIntegrante();
        mCargarDatosTabla_DDiagnostico();
        mCargarDatosTabla_SSuministro();
        mCargarDatosTabla_DAyudasDx();
        mCargarDatosTabla_NNota();
        this.JTPDatosIntervencion.setSelectedIndex(0);
    }

    private void mCargarDatosTabla() {
        try {
            mCrearModeloHistorico();
            this.xsql = "SELECT `h_orden_qx`.`Id` , date_format(`h_orden_qx`.`Fecha_Inicial`,'%d/%m/%Y') as FInicial , `h_orden_qx`.`Hora_Inicla`  , IF(`h_orden_qx`.`Fecha_Final` IS NULL, '', `h_orden_qx`.`Fecha_Final`) AS FFinal , IF(`h_orden_qx`.`Hora_Final` IS NULL, '', `h_orden_qx`.`Hora_Final`) AS HFinal , `f_tipoanestesia`.`Nbre`, IF(`h_orden_qx`.`Hora_Final` IS NULL, 0, 1) FROM `h_orden_qx` INNER JOIN  `f_tipoanestesia`   ON (`h_orden_qx`.`Id_Tipo_Anestesia` = `f_tipoanestesia`.`Id`) WHERE (`h_orden_qx`.`Estado` =1 AND `h_orden_qx`.`Id_Atencion` ='" + this.xId_Atencion + "')  ORDER BY `h_orden_qx`.`Fecha_Inicial` DESC ";
            ResultSet xrs = this.xct.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int x = 0;
                int xnfila = 0;
                int xentro = 0;
                while (xrs.next()) {
                    this.xModelo_Historico.addRow(this.xDatos);
                    this.xModelo_Historico.setValueAt(Long.valueOf(xrs.getLong(1)), x, 0);
                    this.xModelo_Historico.setValueAt(xrs.getString(2), x, 1);
                    this.xModelo_Historico.setValueAt(xrs.getString(3), x, 2);
                    this.xModelo_Historico.setValueAt(xrs.getString(4), x, 3);
                    this.xModelo_Historico.setValueAt(xrs.getString(5), x, 4);
                    this.xModelo_Historico.setValueAt(xrs.getString(6), x, 5);
                    this.xModelo_Historico.setValueAt(Integer.valueOf(xrs.getInt(7)), x, 6);
                    if (xentro == 0 && xrs.getInt(7) == 0) {
                        xentro = 1;
                        xnfila = x;
                    }
                    this.JTB_Historico.setDefaultRenderer(Object.class, new MiRender());
                    x++;
                }
                if (xentro == 1) {
                    mCargarCx_Activa(xnfila);
                }
            } else {
                mCrearModeloHistorico();
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPSo_Espirometria.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatosTabla_DProcedimiento() {
        try {
            mCrearModelo_Procedimiento();
            if (Principal.informacionIps.getNombreIps().equals("CLINICA REGIONAL DEL SAN JORGE I.P.S S.A.S")) {
                this.xsql = "SELECT  IFNULL(g_procedimiento.C_Homologado, `h_orden_qx_procedimientos`.`Id_Procedimiento`) as Id_Procedimiento, `g_procedimiento`.`Nbre` , `profesional1`.`Especialidad` , `profesional1`.`NProfesional` , IF(`h_orden_qx_procedimientos`.`Via`=0, 'Igual', 'Direfente') AS Via , IF(`h_orden_qx_procedimientos`.`Bilateral`=0, 'No', 'Si') AS Bilateral, IF(`h_orden_qx_procedimientos`.`Contaminado`=0, 'No', 'Si') AS Contaminado,  `h_orden_qx_procedimientos`.`Orden`  FROM `h_orden_qx_procedimientos` INNER JOIN  `g_procedimiento`  ON (`h_orden_qx_procedimientos`.`Id_Procedimiento` = `g_procedimiento`.`Id`) INNER JOIN  `profesional1`  ON (`profesional1`.`IdEspecialidad` = `h_orden_qx_procedimientos`.`Id_Especialidad`) AND (`profesional1`.`Id_Persona` = `h_orden_qx_procedimientos`.`Id_Profesional`) WHERE (`h_orden_qx_procedimientos`.`Estado` =1 AND h_orden_qx_procedimientos.`Id_Orden_Qx`='" + this.JLBNumero.getText() + "') ORDER BY `h_orden_qx_procedimientos`.`Orden` ASC ";
            } else {
                this.xsql = "SELECT  `h_orden_qx_procedimientos`.`Id_Procedimiento`  , `g_procedimiento`.`Nbre` , `profesional1`.`Especialidad` , `profesional1`.`NProfesional` , IF(`h_orden_qx_procedimientos`.`Via`=0, 'Igual', 'Direfente') AS Via , IF(`h_orden_qx_procedimientos`.`Bilateral`=0, 'No', 'Si') AS Bilateral, IF(`h_orden_qx_procedimientos`.`Contaminado`=0, 'No', 'Si') AS Contaminado,  `h_orden_qx_procedimientos`.`Orden`  FROM `h_orden_qx_procedimientos` INNER JOIN  `g_procedimiento`  ON (`h_orden_qx_procedimientos`.`Id_Procedimiento` = `g_procedimiento`.`Id`) INNER JOIN  `profesional1`  ON (`profesional1`.`IdEspecialidad` = `h_orden_qx_procedimientos`.`Id_Especialidad`) AND (`profesional1`.`Id_Persona` = `h_orden_qx_procedimientos`.`Id_Profesional`) WHERE (`h_orden_qx_procedimientos`.`Estado` =1 AND h_orden_qx_procedimientos.`Id_Orden_Qx`='" + this.JLBNumero.getText() + "') ORDER BY `h_orden_qx_procedimientos`.`Orden` ASC ";
            }
            ResultSet xrs = this.xct.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int x = 0;
                this.xmt.mEstablecerTextEditor(this.JTB_RDetalle_Procedimiento, 1);
                this.xmt.mEstablecerTextEditor(this.JTB_RDetalle_Procedimiento, 2);
                this.xmt.mEstablecerTextEditor(this.JTB_RDetalle_Procedimiento, 3);
                while (xrs.next()) {
                    this.xModelo_Procedimientos.addRow(this.xDatos);
                    this.xModelo_Procedimientos.setValueAt(xrs.getString(1), x, 0);
                    this.xModelo_Procedimientos.setValueAt(xrs.getString(2), x, 1);
                    this.xModelo_Procedimientos.setValueAt(xrs.getString(3), x, 2);
                    this.xModelo_Procedimientos.setValueAt(xrs.getString(4), x, 3);
                    this.xModelo_Procedimientos.setValueAt(xrs.getString(5), x, 4);
                    this.xModelo_Procedimientos.setValueAt(xrs.getString(6), x, 5);
                    this.xModelo_Procedimientos.setValueAt(xrs.getString(7), x, 6);
                    this.xModelo_Procedimientos.setValueAt(Integer.valueOf(xrs.getInt(8)), x, 7);
                    x++;
                }
            } else {
                mCrearModelo_Procedimiento();
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPSo_Espirometria.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatosTabla_DIntegrante() {
        try {
            mCrearModelo_Integrantes();
            this.xsql = "SELECT  `profesional1`.`Especialidad` , `profesional1`.`NProfesional` , `h_orden_qx_integrantes`.`Observacion` , `h_orden_qx_integrantes`.`Orden`, `profesional1`.`Id_Persona` FROM  `profesional1` INNER JOIN `h_orden_qx_integrantes`  ON (`profesional1`.`IdEspecialidad` = `h_orden_qx_integrantes`.`Id_Especialidad`) AND (`profesional1`.`Id_Persona` = `h_orden_qx_integrantes`.`Id_Persona`) WHERE (`h_orden_qx_integrantes`.`Estado` =1 AND `h_orden_qx_integrantes`.`Id_OrdenQx` ='" + this.JLBNumero.getText() + "') ORDER BY `h_orden_qx_integrantes`.`Orden` ASC ";
            ResultSet xrs = this.xct.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int x = 0;
                this.xmt.mEstablecerTextEditor(this.JTB_IDetalle_Integrante, 3);
                while (xrs.next()) {
                    this.xModelo_Integrantes.addRow(this.xDatos);
                    this.xModelo_Integrantes.setValueAt(xrs.getString(1), x, 0);
                    this.xModelo_Integrantes.setValueAt(xrs.getString(2), x, 1);
                    this.xModelo_Integrantes.setValueAt(xrs.getString(3), x, 2);
                    this.xModelo_Integrantes.setValueAt(Integer.valueOf(xrs.getInt(4)), x, 3);
                    this.xModelo_Integrantes.setValueAt(Long.valueOf(xrs.getLong(5)), x, 4);
                    x++;
                }
            } else {
                mCrearModelo_Integrantes();
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPSo_Espirometria.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatosTabla_DDiagnostico() {
        try {
            mCrearModelo_Patologia();
            this.xsql = "SELECT `g_patologia`.`Id`, `g_patologia`.`Nbre`, IF(`h_orden_qx_diagnostico`.`Tipo`=0,'Pre-Operatorio', IF(`h_orden_qx_diagnostico`.`Tipo`=1,'Pos-Operatorio', 'Complicación')) AS Tipo , `h_orden_qx_diagnostico`.`Observacion` , `h_orden_qx_diagnostico`.`Orden` FROM  `h_orden_qx_diagnostico` INNER JOIN `g_patologia`  ON (`h_orden_qx_diagnostico`.`Id_Patologia` = `g_patologia`.`Id`) WHERE (`h_orden_qx_diagnostico`.`Estado` =1 AND `h_orden_qx_diagnostico`.`Id_Orden_Qx` ='" + this.JLBNumero.getText() + "') ORDER BY `h_orden_qx_diagnostico`.`Tipo` ASC, `h_orden_qx_diagnostico`.`Orden` ASC ";
            ResultSet xrs = this.xct.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int x = 0;
                this.xmt.mEstablecerTextEditor(this.JTB_DDetalle_Diagnostico, 2);
                this.xmt.mEstablecerTextEditor(this.JTB_DDetalle_Diagnostico, 4);
                while (xrs.next()) {
                    this.xModelo_Patologia.addRow(this.xDatos);
                    this.xModelo_Patologia.setValueAt(xrs.getString(1), x, 0);
                    this.xModelo_Patologia.setValueAt(xrs.getString(2), x, 1);
                    this.xModelo_Patologia.setValueAt(xrs.getString(3), x, 2);
                    this.xModelo_Patologia.setValueAt(xrs.getString(4), x, 3);
                    this.xModelo_Patologia.setValueAt(Integer.valueOf(xrs.getInt(5)), x, 4);
                    x++;
                }
            } else {
                mCrearModelo_Patologia();
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPSo_Espirometria.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatosTabla_SSuministro() {
        try {
            mCrearModelo_Suministro();
            this.xsql = "SELECT `h_orden_qx_suministro`.`Id_Suministro`, `i_tipoproducto`.`Nbre`,  CONCAT(`i_suministro`.`Nbre`,' ', `i_presentacionfarmaceutica`.`Nbre`) AS `NSuministro`, `h_orden_qx_suministro`.`Cobrable`, `h_orden_qx_suministro`.`Cantidad` , `h_orden_qx_suministro`.`Observacion` FROM  `h_orden_qx_suministro` INNER JOIN  `i_suministro`  ON (`h_orden_qx_suministro`.`Id_Suministro` = `i_suministro`.`Id`) INNER JOIN `i_tipoproducto`  ON (`i_suministro`.`IdTipoProducto` = `i_tipoproducto`.`Id`) INNER JOIN `i_presentacionfarmaceutica`  ON (`i_suministro`.`IdPresentacionFarmaceutica` = `i_presentacionfarmaceutica`.`Id`) WHERE (`h_orden_qx_suministro`.`Id_Orden_Qx` ='" + this.JLBNumero.getText() + "' AND `h_orden_qx_suministro`.`Estado` =1) ORDER BY `i_tipoproducto`.`Nbre` ASC, `NSuministro` ASC ";
            ResultSet xrs = this.xct.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int x = 0;
                this.xmt.mEstablecerTextEditor(this.JTB_SDetalle_Sumnistro, 2);
                this.xmt.mEstablecerTextEditor(this.JTB_SDetalle_Sumnistro, 5);
                while (xrs.next()) {
                    this.xModelo_Suministro.addRow(this.xDatos);
                    this.xModelo_Suministro.setValueAt(Long.valueOf(xrs.getLong(1)), x, 0);
                    this.xModelo_Suministro.setValueAt(xrs.getString(2), x, 1);
                    this.xModelo_Suministro.setValueAt(xrs.getString(3), x, 2);
                    this.xModelo_Suministro.setValueAt(Boolean.valueOf(xrs.getBoolean(4)), x, 3);
                    this.xModelo_Suministro.setValueAt(Integer.valueOf(xrs.getInt(5)), x, 4);
                    this.xModelo_Suministro.setValueAt(xrs.getString(6), x, 5);
                    x++;
                }
            } else {
                mCrearModelo_Suministro();
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPSo_Espirometria.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatosTabla_NNota() {
        try {
            mCrearModelo_Nota();
            this.xsql = "SELECT  `h_orden_qx_notas`.`Id` ,CONCAT(DATE_FORMAT(`h_orden_qx_notas`.`FechaN`,'%d-%m-%Y'), ' ',`h_orden_qx_notas`.`HoraN`) AS FH , `h_tiponota`.`Nbre` , `profesional1`.`Especialidad` , `profesional1`.`NProfesional` , `h_orden_qx_notas`.`Descripcion` FROM `h_orden_qx_notas` INNER JOIN  `h_tiponota`   ON (`h_orden_qx_notas`.`Id_TipoNota` = `h_tiponota`.`Id`)  INNER JOIN  `profesional1`   ON (`profesional1`.`Id_Persona` = `h_orden_qx_notas`.`Id_Profesional`) AND (`profesional1`.`IdEspecialidad` = `h_orden_qx_notas`.`Id_Especialidad`) WHERE (`h_orden_qx_notas`.`Id_Orden_Qx` ='" + this.JLBNumero.getText() + "' AND `h_orden_qx_notas`.`Estado` =1)  ORDER BY `h_tiponota`.`Nbre` ASC, `h_orden_qx_notas`.`FechaN` DESC, `h_orden_qx_notas`.`HoraN` DESC  ";
            ResultSet xrs = this.xct.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int x = 0;
                this.xmt.mEstablecerTextEditor(this.JTB_NDetalle_Nota, 1);
                this.xmt.mEstablecerTextEditor(this.JTB_NDetalle_Nota, 2);
                this.xmt.mEstablecerTextEditor(this.JTB_NDetalle_Nota, 3);
                this.xmt.mEstablecerTextEditor(this.JTB_NDetalle_Nota, 4);
                this.xmt.mEstablecerTextEditor(this.JTB_NDetalle_Nota, 5);
                while (xrs.next()) {
                    this.xModelo_Nota.addRow(this.xDatos);
                    this.xModelo_Nota.setValueAt(Long.valueOf(xrs.getLong(1)), x, 0);
                    this.xModelo_Nota.setValueAt(xrs.getString(2), x, 1);
                    this.xModelo_Nota.setValueAt(xrs.getString(3), x, 2);
                    this.xModelo_Nota.setValueAt(xrs.getString(4), x, 3);
                    this.xModelo_Nota.setValueAt(xrs.getString(5), x, 4);
                    this.xModelo_Nota.setValueAt(xrs.getString(6), x, 5);
                    x++;
                }
            } else {
                mCrearModelo_Nota();
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPSo_Espirometria.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatosTabla_DAyudasDx() {
        try {
            mCrearModelo_AyudasDx();
            this.xsql = "SELECT `h_orden_qx_ayudas_dx`.`Id`, `h_orden_qx_ayudas_dx`.`Fecha`, `f_tiposervicio`.`Nbre`, `g_procedimiento`.`Nbre`, `h_orden_qx_ayudas_dx`.`Cantidad` FROM  `h_orden_qx_ayudas_dx` INNER JOIN `f_tiposervicio`  ON (`h_orden_qx_ayudas_dx`.`Id_TipoServicio` = `f_tiposervicio`.`Id`) INNER JOIN `g_procedimiento`  ON (`h_orden_qx_ayudas_dx`.`I_Procedimiento` = `g_procedimiento`.`Id`) WHERE (`h_orden_qx_ayudas_dx`.`Id_Orden_Qx` ='" + this.JLBNumero.getText() + "' AND `h_orden_qx_ayudas_dx`.`Estado` =1) ORDER BY `f_tiposervicio`.`Nbre` ASC, `g_procedimiento`.`Nbre` ASC ";
            ResultSet xrs = this.xct.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int x = 0;
                this.xmt.mEstablecerTextEditor(this.JTB_IDetalle_AyudasDx, 3);
                while (xrs.next()) {
                    this.xModelo_AyudasDx.addRow(this.xDatos);
                    this.xModelo_AyudasDx.setValueAt(Long.valueOf(xrs.getLong(1)), x, 0);
                    this.xModelo_AyudasDx.setValueAt(xrs.getString(2), x, 1);
                    this.xModelo_AyudasDx.setValueAt(xrs.getString(3), x, 2);
                    this.xModelo_AyudasDx.setValueAt(xrs.getString(4), x, 3);
                    this.xModelo_AyudasDx.setValueAt(Long.valueOf(xrs.getLong(5)), x, 4);
                    x++;
                }
            } else {
                mCrearModelo_AyudasDx();
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPSo_Espirometria.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:Historia/JPI_Cirugias1$MiRender.class */
    public static class MiRender extends DefaultTableCellRenderer {
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (Integer.valueOf(table.getValueAt(row, 6).toString()).intValue() == 1) {
                cell.setBackground(new Color(177, 251, 177));
            } else {
                cell.setBackground(Color.WHITE);
            }
            return cell;
        }
    }

    public void mImprimir() {
        if (!this.JLBNumero.getText().isEmpty()) {
            String[][] mparametros = new String[4][2];
            mparametros[0][0] = "Id";
            mparametros[0][1] = this.JLBNumero.getText();
            mparametros[1][0] = "SUBREPORT_DIR";
            mparametros[1][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
            mparametros[2][0] = "SUBREPORTFIRMA_DIR";
            mparametros[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
            mparametros[3][0] = "tituloReporte";
            mparametros[3][1] = "Informe Quirurgico";
            if (Principal.informacionIps.getEsFpz().intValue() == 1) {
                if (Principal.informacionIps.getIdentificacion().equals("812005644")) {
                    this.xmt.GenerarPDF(this.xmt.getRutaRep() + "H_Informe_Quirurgico_2", mparametros);
                    return;
                } else {
                    this.xmt.GenerarPDF(this.xmt.getRutaRep() + "H_Informe_Quirurgico_1", mparametros);
                    return;
                }
            }
            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "H_Informe_Quirurgico_1", mparametros);
        }
    }
}
