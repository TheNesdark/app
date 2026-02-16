package Historia;

import Acceso.Principal;
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

/* JADX INFO: loaded from: GenomaP.jar:Historia/JPI_Cirugias.class */
public class JPI_Cirugias extends JPanel {
    private String xsql;
    private String[] xId_Anestesia;
    private String[] xId_Servicio;
    private String[] xId_Procedimiento;
    private String[] xId_TipoNota;
    private String[] xId_Cirujano;
    private String[] xId_Ayudante;
    private String[] xId_Anestesiologo;
    private String[] xId_Instrumentador;
    private DefaultTableModel xModelo_Procedimientos;
    private DefaultTableModel xModelo_Historico;
    private DefaultTableModel xModelo_AyudasDx;
    private DefaultTableModel xModelo_Patologia;
    private DefaultTableModel xModelo_Suministro;
    private DefaultTableModel xModelo_Nota;
    private long xId_Atencion;
    private Object[] xDatos;
    private ButtonGroup JBG_DTipo;
    private ButtonGroup JBG_RViaAcceso;
    private JButton JBTAdicionar;
    private JButton JBTCierre;
    private JButton JBTRNacido;
    private JButton JBT_DAdicionar;
    private JButton JBT_IAdicionar;
    private JButton JBT_NAdicionar;
    private JButton JBT_SAdicionar;
    private JComboBox JCBTipo_Anestecia;
    private JComboBox JCB_IProcedimiento;
    private JComboBox JCB_IProfesional1;
    private JComboBox JCB_IProfesional2;
    private JComboBox JCB_IProfesional3;
    private JComboBox JCB_IProfesional4;
    private JComboBox JCB_IServicio;
    private JComboBox JCB_NTipoNota;
    private JCheckBox JCH_SCobrable;
    private JDateChooser JDC_FechaI;
    private JDateChooser JDC_NFecha;
    private JLabel JLBNumero;
    private JPanel JPIDAdicionales;
    private JPanel JPIDInicio;
    private JPanel JPIDatosN;
    private JPanel JPIDatos_Intervencion;
    private JPanel JPINotas;
    private JPanel JPIProcedimiento;
    private JPanel JPI_Ayudas_Dx;
    private JPanel JPI_DDiagnostico;
    private JPanel JPI_DTipoDx;
    private JPanel JPI_Diagnosticos;
    private JPanel JPI_RProcedimiento;
    private JPanel JPI_RProcedimiento1;
    private JPanel JPI_RViaAcceso;
    private JPanel JPI_SSuministro;
    private JPanel JPI_Sumimistro;
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
    private JSpinner JSP_INCantidad;
    private JScrollPane JSP_NDetalle;
    private JScrollPane JSP_NNota;
    private JScrollPane JSP_RDetalle;
    private JSpinner JSP_SCantidad;
    private JScrollPane JSP_SDetalle;
    private JScrollPane JSP_SObservacion;
    private JTextArea JTA_DObservacion;
    private JTextArea JTA_NNota;
    private JTextArea JTA_SObservacion;
    private JTable JTB_DDetalle_Diagnostico;
    private JTable JTB_Historico;
    private JTable JTB_IDetalle_AyudasDx;
    private JTable JTB_NDetalle_Nota;
    private JTable JTB_RDetalle_Procedimiento;
    private JTable JTB_SDetalle_Sumnistro;
    private JFormattedTextField JTFF_HoraF;
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
    private long xVia_Acceso = 0;
    private long xTipo_Diagnostico = 0;
    private long xSuministro_Procedimiento = -1;
    private boolean xLleno_Servicio = false;
    private boolean xCerrada = false;

    public JPI_Cirugias(long xid_atencion) {
        this.xId_Atencion = 0L;
        initComponents();
        this.xId_Atencion = xid_atencion;
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v141, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v190, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v256, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v296, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v340, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v99, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBG_RViaAcceso = new ButtonGroup();
        this.JBG_DTipo = new ButtonGroup();
        this.JTPDatosIntervencion = new JTabbedPane();
        this.JPIDatos_Intervencion = new JPanel();
        this.JPIDInicio = new JPanel();
        this.JDC_FechaI = new JDateChooser();
        this.JTFF_HoraI = new JFormattedTextField();
        this.JTFF_HoraF = new JFormattedTextField();
        this.JCBTipo_Anestecia = new JComboBox();
        this.JLBNumero = new JLabel();
        this.JCB_IProfesional1 = new JComboBox();
        this.JCB_IProfesional2 = new JComboBox();
        this.JCB_IProfesional3 = new JComboBox();
        this.JCB_IProfesional4 = new JComboBox();
        this.JTPDatos_Qx = new JTabbedPane();
        this.JPIProcedimiento = new JPanel();
        this.JPI_RProcedimiento = new JPanel();
        this.JTF_RCodigo = new JTextField();
        this.JTF_RNombre = new JTextField();
        this.JPI_RViaAcceso = new JPanel();
        this.JRB_RVia_Igual = new JRadioButton();
        this.JRB_RVia_Diferente = new JRadioButton();
        this.JSPNOrden = new JSpinner();
        this.JBTAdicionar = new JButton();
        this.JSP_RDetalle = new JScrollPane();
        this.JTB_RDetalle_Procedimiento = new JTable();
        this.JPI_Ayudas_Dx = new JPanel();
        this.JPI_RProcedimiento1 = new JPanel();
        this.JCB_IServicio = new JComboBox();
        this.JCB_IProcedimiento = new JComboBox();
        this.JSP_INCantidad = new JSpinner();
        this.JBT_IAdicionar = new JButton();
        this.JSP_IDetalle = new JScrollPane();
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
        this.JPINotas = new JPanel();
        this.JPIDatosN = new JPanel();
        this.JDC_NFecha = new JDateChooser();
        this.JTFF_NHora = new JFormattedTextField();
        this.JCB_NTipoNota = new JComboBox();
        this.JSP_NNota = new JScrollPane();
        this.JTA_NNota = new JTextArea();
        this.JBT_NAdicionar = new JButton();
        this.JSP_NDetalle = new JScrollPane();
        this.JTB_NDetalle_Nota = new JTable();
        this.JPIDAdicionales = new JPanel();
        this.JBTCierre = new JButton();
        this.JBTRNacido = new JButton();
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
        this.JTFF_HoraI.setBorder(BorderFactory.createTitledBorder((Border) null, "Hora Inicio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFF_HoraI.setFormatterFactory(new DefaultFormatterFactory(new DateFormatter(new SimpleDateFormat("hh:mm:ss a"))));
        this.JTFF_HoraI.setFont(new Font("Arial", 1, 12));
        this.JTFF_HoraI.addKeyListener(new KeyAdapter() { // from class: Historia.JPI_Cirugias.1
            public void keyPressed(KeyEvent evt) {
                JPI_Cirugias.this.JTFF_HoraIKeyPressed(evt);
            }
        });
        this.JTFF_HoraF.setBorder(BorderFactory.createTitledBorder((Border) null, "Hora Fin", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFF_HoraF.setFormatterFactory(new DefaultFormatterFactory(new DateFormatter(new SimpleDateFormat("hh:mm:ss a"))));
        this.JTFF_HoraF.setFont(new Font("Arial", 1, 12));
        this.JTFF_HoraF.addKeyListener(new KeyAdapter() { // from class: Historia.JPI_Cirugias.2
            public void keyPressed(KeyEvent evt) {
                JPI_Cirugias.this.JTFF_HoraFKeyPressed(evt);
            }
        });
        this.JCBTipo_Anestecia.setFont(new Font("Arial", 1, 12));
        this.JCBTipo_Anestecia.setBorder(BorderFactory.createTitledBorder((Border) null, "Anestesia", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JLBNumero.setFont(new Font("Arial", 1, 18));
        this.JLBNumero.setForeground(Color.red);
        this.JLBNumero.setHorizontalAlignment(0);
        this.JLBNumero.setBorder(BorderFactory.createTitledBorder((Border) null, "Número", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JLBNumero.setFocusable(false);
        this.JCB_IProfesional1.setFont(new Font("Arial", 1, 12));
        this.JCB_IProfesional1.setBorder(BorderFactory.createTitledBorder((Border) null, "Cirujano", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCB_IProfesional2.setFont(new Font("Arial", 1, 12));
        this.JCB_IProfesional2.setBorder(BorderFactory.createTitledBorder((Border) null, "Ayudante", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCB_IProfesional3.setFont(new Font("Arial", 1, 12));
        this.JCB_IProfesional3.setBorder(BorderFactory.createTitledBorder((Border) null, "Instrumentador", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCB_IProfesional4.setFont(new Font("Arial", 1, 12));
        this.JCB_IProfesional4.setBorder(BorderFactory.createTitledBorder((Border) null, "Anestesiólogo", 1, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPIDInicioLayout = new GroupLayout(this.JPIDInicio);
        this.JPIDInicio.setLayout(JPIDInicioLayout);
        JPIDInicioLayout.setHorizontalGroup(JPIDInicioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDInicioLayout.createSequentialGroup().addContainerGap().addGroup(JPIDInicioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDInicioLayout.createSequentialGroup().addComponent(this.JDC_FechaI, -2, 113, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFF_HoraI, -2, 99, -2).addGap(18, 18, 18).addComponent(this.JTFF_HoraF, -2, 99, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBTipo_Anestecia, -2, 257, -2).addGap(18, 18, 18).addComponent(this.JLBNumero, -1, -1, 32767)).addGroup(JPIDInicioLayout.createSequentialGroup().addComponent(this.JCB_IProfesional1, -2, 370, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCB_IProfesional2, 0, -1, 32767)).addGroup(JPIDInicioLayout.createSequentialGroup().addComponent(this.JCB_IProfesional3, -2, 370, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCB_IProfesional4, 0, -1, 32767))).addContainerGap()));
        JPIDInicioLayout.setVerticalGroup(JPIDInicioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDInicioLayout.createSequentialGroup().addContainerGap().addGroup(JPIDInicioLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JLBNumero, -1, -1, 32767).addComponent(this.JCBTipo_Anestecia).addGroup(JPIDInicioLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFF_HoraI, -2, 50, -2).addComponent(this.JTFF_HoraF, -2, 50, -2)).addComponent(this.JDC_FechaI, -1, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDInicioLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCB_IProfesional1, -2, 50, -2).addComponent(this.JCB_IProfesional2, -2, 50, -2)).addGap(18, 18, 18).addGroup(JPIDInicioLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCB_IProfesional3, -2, 50, -2).addComponent(this.JCB_IProfesional4, -2, 50, -2)).addContainerGap(-1, 32767)));
        this.JTPDatos_Qx.setForeground(new Color(0, 103, 0));
        this.JTPDatos_Qx.setFont(new Font("Arial", 1, 12));
        this.JPI_RProcedimiento.setBorder(BorderFactory.createEtchedBorder());
        this.JTF_RCodigo.setFont(new Font("Arial", 1, 12));
        this.JTF_RCodigo.setBorder(BorderFactory.createTitledBorder((Border) null, "Código Cups", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTF_RCodigo.addFocusListener(new FocusAdapter() { // from class: Historia.JPI_Cirugias.3
            public void focusLost(FocusEvent evt) {
                JPI_Cirugias.this.JTF_RCodigoFocusLost(evt);
            }
        });
        this.JTF_RCodigo.addActionListener(new ActionListener() { // from class: Historia.JPI_Cirugias.4
            public void actionPerformed(ActionEvent evt) {
                JPI_Cirugias.this.JTF_RCodigoActionPerformed(evt);
            }
        });
        this.JTF_RNombre.setFont(new Font("Arial", 1, 12));
        this.JTF_RNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTF_RNombre.addMouseListener(new MouseAdapter() { // from class: Historia.JPI_Cirugias.5
            public void mouseClicked(MouseEvent evt) {
                JPI_Cirugias.this.JTF_RNombreMouseClicked(evt);
            }
        });
        this.JPI_RViaAcceso.setBorder(BorderFactory.createTitledBorder((Border) null, "Vía de Acceso", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBG_RViaAcceso.add(this.JRB_RVia_Igual);
        this.JRB_RVia_Igual.setFont(new Font("Arial", 1, 12));
        this.JRB_RVia_Igual.setSelected(true);
        this.JRB_RVia_Igual.setText("Igual");
        this.JRB_RVia_Igual.addActionListener(new ActionListener() { // from class: Historia.JPI_Cirugias.6
            public void actionPerformed(ActionEvent evt) {
                JPI_Cirugias.this.JRB_RVia_IgualActionPerformed(evt);
            }
        });
        this.JBG_RViaAcceso.add(this.JRB_RVia_Diferente);
        this.JRB_RVia_Diferente.setFont(new Font("Arial", 1, 12));
        this.JRB_RVia_Diferente.setText("Diferente");
        this.JRB_RVia_Diferente.addActionListener(new ActionListener() { // from class: Historia.JPI_Cirugias.7
            public void actionPerformed(ActionEvent evt) {
                JPI_Cirugias.this.JRB_RVia_DiferenteActionPerformed(evt);
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
        this.JBTAdicionar.addActionListener(new ActionListener() { // from class: Historia.JPI_Cirugias.8
            public void actionPerformed(ActionEvent evt) {
                JPI_Cirugias.this.JBTAdicionarActionPerformed(evt);
            }
        });
        GroupLayout JPI_RProcedimientoLayout = new GroupLayout(this.JPI_RProcedimiento);
        this.JPI_RProcedimiento.setLayout(JPI_RProcedimientoLayout);
        JPI_RProcedimientoLayout.setHorizontalGroup(JPI_RProcedimientoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_RProcedimientoLayout.createSequentialGroup().addContainerGap().addGroup(JPI_RProcedimientoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_RProcedimientoLayout.createSequentialGroup().addComponent(this.JTF_RCodigo, -2, 100, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTF_RNombre).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPNOrden, -2, 51, -2)).addGroup(JPI_RProcedimientoLayout.createSequentialGroup().addComponent(this.JPI_RViaAcceso, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JBTAdicionar, -2, 188, -2))).addContainerGap()));
        JPI_RProcedimientoLayout.setVerticalGroup(JPI_RProcedimientoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_RProcedimientoLayout.createSequentialGroup().addContainerGap().addGroup(JPI_RProcedimientoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTF_RCodigo, -2, 50, -2).addComponent(this.JTF_RNombre, -2, 50, -2).addComponent(this.JSPNOrden, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPI_RProcedimientoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JPI_RViaAcceso, -2, -1, -2).addComponent(this.JBTAdicionar, -1, -1, 32767)).addContainerGap(14, 32767)));
        this.JSP_RDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 12), Color.red));
        this.JTB_RDetalle_Procedimiento.setFont(new Font("Arial", 1, 12));
        this.JTB_RDetalle_Procedimiento.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTB_RDetalle_Procedimiento.setRowHeight(25);
        this.JTB_RDetalle_Procedimiento.setSelectionBackground(new Color(255, 255, 255));
        this.JTB_RDetalle_Procedimiento.setSelectionForeground(Color.red);
        this.JSP_RDetalle.setViewportView(this.JTB_RDetalle_Procedimiento);
        GroupLayout JPIProcedimientoLayout = new GroupLayout(this.JPIProcedimiento);
        this.JPIProcedimiento.setLayout(JPIProcedimientoLayout);
        JPIProcedimientoLayout.setHorizontalGroup(JPIProcedimientoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIProcedimientoLayout.createSequentialGroup().addContainerGap().addGroup(JPIProcedimientoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPI_RProcedimiento, -1, -1, 32767).addComponent(this.JSP_RDetalle, -1, 777, 32767)).addContainerGap()));
        JPIProcedimientoLayout.setVerticalGroup(JPIProcedimientoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIProcedimientoLayout.createSequentialGroup().addContainerGap().addComponent(this.JPI_RProcedimiento, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSP_RDetalle, -1, 138, 32767).addContainerGap()));
        this.JTPDatos_Qx.addTab("PROCEDIMIENTOS", this.JPIProcedimiento);
        this.JPI_RProcedimiento1.setBorder(BorderFactory.createEtchedBorder());
        this.JCB_IServicio.setFont(new Font("Arial", 1, 12));
        this.JCB_IServicio.setBorder(BorderFactory.createTitledBorder((Border) null, "Servicio", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCB_IServicio.addItemListener(new ItemListener() { // from class: Historia.JPI_Cirugias.9
            public void itemStateChanged(ItemEvent evt) {
                JPI_Cirugias.this.JCB_IServicioItemStateChanged(evt);
            }
        });
        this.JCB_IProcedimiento.setFont(new Font("Arial", 1, 12));
        this.JCB_IProcedimiento.setToolTipText("Doble clic para habilitar la ayuda de búsqueda");
        this.JCB_IProcedimiento.setBorder(BorderFactory.createTitledBorder((Border) null, "Procedimiento", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCB_IProcedimiento.addMouseListener(new MouseAdapter() { // from class: Historia.JPI_Cirugias.10
            public void mouseClicked(MouseEvent evt) {
                JPI_Cirugias.this.JCB_IProcedimientoMouseClicked(evt);
            }
        });
        this.JSP_INCantidad.setFont(new Font("Arial", 1, 12));
        this.JSP_INCantidad.setModel(new SpinnerNumberModel(1, 0, (Comparable) null, 1));
        this.JSP_INCantidad.setToolTipText("Cantidad");
        this.JSP_INCantidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Cant.", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBT_IAdicionar.setFont(new Font("Arial", 1, 12));
        this.JBT_IAdicionar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBT_IAdicionar.setText("Adicionar");
        this.JBT_IAdicionar.addActionListener(new ActionListener() { // from class: Historia.JPI_Cirugias.11
            public void actionPerformed(ActionEvent evt) {
                JPI_Cirugias.this.JBT_IAdicionarActionPerformed(evt);
            }
        });
        GroupLayout JPI_RProcedimiento1Layout = new GroupLayout(this.JPI_RProcedimiento1);
        this.JPI_RProcedimiento1.setLayout(JPI_RProcedimiento1Layout);
        JPI_RProcedimiento1Layout.setHorizontalGroup(JPI_RProcedimiento1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPI_RProcedimiento1Layout.createSequentialGroup().addContainerGap().addGroup(JPI_RProcedimiento1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JBT_IAdicionar, -1, -1, 32767).addGroup(JPI_RProcedimiento1Layout.createSequentialGroup().addComponent(this.JCB_IServicio, 0, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCB_IProcedimiento, -2, 430, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSP_INCantidad, -2, 67, -2))).addContainerGap()));
        JPI_RProcedimiento1Layout.setVerticalGroup(JPI_RProcedimiento1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_RProcedimiento1Layout.createSequentialGroup().addContainerGap().addGroup(JPI_RProcedimiento1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSP_INCantidad, -2, 50, -2).addGroup(JPI_RProcedimiento1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCB_IServicio, -2, 50, -2).addComponent(this.JCB_IProcedimiento, -2, 50, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBT_IAdicionar, -2, 47, -2).addContainerGap(12, 32767)));
        this.JSP_IDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 12), Color.red));
        this.JTB_IDetalle_AyudasDx.setFont(new Font("Arial", 1, 12));
        this.JTB_IDetalle_AyudasDx.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTB_IDetalle_AyudasDx.setRowHeight(25);
        this.JTB_IDetalle_AyudasDx.setSelectionBackground(new Color(255, 255, 255));
        this.JTB_IDetalle_AyudasDx.setSelectionForeground(Color.red);
        this.JSP_IDetalle.setViewportView(this.JTB_IDetalle_AyudasDx);
        GroupLayout JPI_Ayudas_DxLayout = new GroupLayout(this.JPI_Ayudas_Dx);
        this.JPI_Ayudas_Dx.setLayout(JPI_Ayudas_DxLayout);
        JPI_Ayudas_DxLayout.setHorizontalGroup(JPI_Ayudas_DxLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_Ayudas_DxLayout.createSequentialGroup().addContainerGap().addGroup(JPI_Ayudas_DxLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPI_RProcedimiento1, -1, -1, 32767).addComponent(this.JSP_IDetalle, GroupLayout.Alignment.TRAILING, -1, 777, 32767)).addContainerGap()));
        JPI_Ayudas_DxLayout.setVerticalGroup(JPI_Ayudas_DxLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_Ayudas_DxLayout.createSequentialGroup().addContainerGap().addComponent(this.JPI_RProcedimiento1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSP_IDetalle, -1, 138, 32767).addContainerGap()));
        this.JTPDatos_Qx.addTab("AYUDAS DIAGNÓSTICAS", this.JPI_Ayudas_Dx);
        this.JPI_SSuministro.setBorder(BorderFactory.createEtchedBorder());
        this.JTF_SCodigo.setFont(new Font("Arial", 1, 12));
        this.JTF_SCodigo.setBorder(BorderFactory.createTitledBorder((Border) null, "Código", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTF_SCodigo.addActionListener(new ActionListener() { // from class: Historia.JPI_Cirugias.12
            public void actionPerformed(ActionEvent evt) {
                JPI_Cirugias.this.JTF_SCodigoActionPerformed(evt);
            }
        });
        this.JTF_SCodigo.addFocusListener(new FocusAdapter() { // from class: Historia.JPI_Cirugias.13
            public void focusLost(FocusEvent evt) {
                JPI_Cirugias.this.JTF_SCodigoFocusLost(evt);
            }
        });
        this.JTF_SNombre.setFont(new Font("Arial", 1, 12));
        this.JTF_SNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTF_SNombre.addMouseListener(new MouseAdapter() { // from class: Historia.JPI_Cirugias.14
            public void mouseClicked(MouseEvent evt) {
                JPI_Cirugias.this.JTF_SNombreMouseClicked(evt);
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
        this.JBT_SAdicionar.addActionListener(new ActionListener() { // from class: Historia.JPI_Cirugias.15
            public void actionPerformed(ActionEvent evt) {
                JPI_Cirugias.this.JBT_SAdicionarActionPerformed(evt);
            }
        });
        GroupLayout JPI_SSuministroLayout = new GroupLayout(this.JPI_SSuministro);
        this.JPI_SSuministro.setLayout(JPI_SSuministroLayout);
        JPI_SSuministroLayout.setHorizontalGroup(JPI_SSuministroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_SSuministroLayout.createSequentialGroup().addContainerGap().addGroup(JPI_SSuministroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_SSuministroLayout.createSequentialGroup().addComponent(this.JTF_SCodigo, -2, 96, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTF_SNombre)).addComponent(this.JSP_SObservacion)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPI_SSuministroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JBT_SAdicionar, GroupLayout.Alignment.TRAILING, -2, 188, -2).addGroup(GroupLayout.Alignment.TRAILING, JPI_SSuministroLayout.createSequentialGroup().addComponent(this.JSP_SCantidad, -2, 63, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCH_SCobrable).addGap(46, 46, 46))).addContainerGap()));
        JPI_SSuministroLayout.setVerticalGroup(JPI_SSuministroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPI_SSuministroLayout.createSequentialGroup().addContainerGap().addGroup(JPI_SSuministroLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTF_SNombre, -2, 50, -2).addComponent(this.JSP_SCantidad, -2, 50, -2).addComponent(this.JCH_SCobrable).addComponent(this.JTF_SCodigo, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPI_SSuministroLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JBT_SAdicionar, -2, 47, -2).addComponent(this.JSP_SObservacion, -2, -1, -2)).addContainerGap(11, 32767)));
        this.JSP_SDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 12), Color.red));
        this.JTB_SDetalle_Sumnistro.setFont(new Font("Arial", 1, 12));
        this.JTB_SDetalle_Sumnistro.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTB_SDetalle_Sumnistro.setRowHeight(25);
        this.JTB_SDetalle_Sumnistro.setSelectionBackground(new Color(255, 255, 255));
        this.JTB_SDetalle_Sumnistro.setSelectionForeground(Color.red);
        this.JSP_SDetalle.setViewportView(this.JTB_SDetalle_Sumnistro);
        GroupLayout JPI_SumimistroLayout = new GroupLayout(this.JPI_Sumimistro);
        this.JPI_Sumimistro.setLayout(JPI_SumimistroLayout);
        JPI_SumimistroLayout.setHorizontalGroup(JPI_SumimistroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_SumimistroLayout.createSequentialGroup().addContainerGap().addGroup(JPI_SumimistroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPI_SSuministro, -1, -1, 32767).addComponent(this.JSP_SDetalle, -1, 777, 32767)).addContainerGap()));
        JPI_SumimistroLayout.setVerticalGroup(JPI_SumimistroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_SumimistroLayout.createSequentialGroup().addContainerGap().addComponent(this.JPI_SSuministro, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSP_SDetalle, -1, 133, 32767).addContainerGap()));
        this.JTPDatos_Qx.addTab("SUMINISTRO O DISPOSITIVOS", this.JPI_Sumimistro);
        this.JPI_DDiagnostico.setBorder(BorderFactory.createEtchedBorder());
        this.JTF_DCodigo.setFont(new Font("Arial", 1, 12));
        this.JTF_DCodigo.setBorder(BorderFactory.createTitledBorder((Border) null, "Cie10", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTF_DCodigo.addActionListener(new ActionListener() { // from class: Historia.JPI_Cirugias.16
            public void actionPerformed(ActionEvent evt) {
                JPI_Cirugias.this.JTF_DCodigoActionPerformed(evt);
            }
        });
        this.JTF_DCodigo.addFocusListener(new FocusAdapter() { // from class: Historia.JPI_Cirugias.17
            public void focusLost(FocusEvent evt) {
                JPI_Cirugias.this.JTF_DCodigoFocusLost(evt);
            }
        });
        this.JTF_DNombre.setFont(new Font("Arial", 1, 12));
        this.JTF_DNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre Patología", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTF_DNombre.addMouseListener(new MouseAdapter() { // from class: Historia.JPI_Cirugias.18
            public void mouseClicked(MouseEvent evt) {
                JPI_Cirugias.this.JTF_DNombreMouseClicked(evt);
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
        this.JRB_DPreOperatorio.addActionListener(new ActionListener() { // from class: Historia.JPI_Cirugias.19
            public void actionPerformed(ActionEvent evt) {
                JPI_Cirugias.this.JRB_DPreOperatorioActionPerformed(evt);
            }
        });
        this.JBG_DTipo.add(this.JRB_DPosOperatorio);
        this.JRB_DPosOperatorio.setFont(new Font("Arial", 1, 12));
        this.JRB_DPosOperatorio.setText("Pos-Operatorio");
        this.JRB_DPosOperatorio.addActionListener(new ActionListener() { // from class: Historia.JPI_Cirugias.20
            public void actionPerformed(ActionEvent evt) {
                JPI_Cirugias.this.JRB_DPosOperatorioActionPerformed(evt);
            }
        });
        this.JBG_DTipo.add(this.JRB_DComplicacion);
        this.JRB_DComplicacion.setFont(new Font("Arial", 1, 12));
        this.JRB_DComplicacion.setText("Complicación");
        this.JRB_DComplicacion.addActionListener(new ActionListener() { // from class: Historia.JPI_Cirugias.21
            public void actionPerformed(ActionEvent evt) {
                JPI_Cirugias.this.JRB_DComplicacionActionPerformed(evt);
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
        this.JBT_DAdicionar.addActionListener(new ActionListener() { // from class: Historia.JPI_Cirugias.22
            public void actionPerformed(ActionEvent evt) {
                JPI_Cirugias.this.JBT_DAdicionarActionPerformed(evt);
            }
        });
        GroupLayout JPI_DDiagnosticoLayout = new GroupLayout(this.JPI_DDiagnostico);
        this.JPI_DDiagnostico.setLayout(JPI_DDiagnosticoLayout);
        JPI_DDiagnosticoLayout.setHorizontalGroup(JPI_DDiagnosticoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DDiagnosticoLayout.createSequentialGroup().addContainerGap().addGroup(JPI_DDiagnosticoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DDiagnosticoLayout.createSequentialGroup().addComponent(this.JPI_DTipoDx, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSP_DObservacion, -2, 0, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBT_DAdicionar, -2, 188, -2)).addGroup(JPI_DDiagnosticoLayout.createSequentialGroup().addComponent(this.JTF_DCodigo, -2, 82, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTF_DNombre).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSP_DNOrden, -2, 51, -2))).addContainerGap()));
        JPI_DDiagnosticoLayout.setVerticalGroup(JPI_DDiagnosticoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPI_DDiagnosticoLayout.createSequentialGroup().addContainerGap().addGroup(JPI_DDiagnosticoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTF_DCodigo, -2, 50, -2).addComponent(this.JTF_DNombre, -2, 50, -2).addComponent(this.JSP_DNOrden, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPI_DDiagnosticoLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JPI_DTipoDx, -2, -1, -2).addComponent(this.JBT_DAdicionar, -2, 47, -2).addComponent(this.JSP_DObservacion, -2, -1, -2)).addContainerGap(-1, 32767)));
        this.JSP_DDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 12), Color.red));
        this.JTB_DDetalle_Diagnostico.setFont(new Font("Arial", 1, 12));
        this.JTB_DDetalle_Diagnostico.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTB_DDetalle_Diagnostico.setRowHeight(25);
        this.JTB_DDetalle_Diagnostico.setSelectionBackground(new Color(255, 255, 255));
        this.JTB_DDetalle_Diagnostico.setSelectionForeground(Color.red);
        this.JSP_DDetalle.setViewportView(this.JTB_DDetalle_Diagnostico);
        GroupLayout JPI_DiagnosticosLayout = new GroupLayout(this.JPI_Diagnosticos);
        this.JPI_Diagnosticos.setLayout(JPI_DiagnosticosLayout);
        JPI_DiagnosticosLayout.setHorizontalGroup(JPI_DiagnosticosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DiagnosticosLayout.createSequentialGroup().addContainerGap().addGroup(JPI_DiagnosticosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPI_DDiagnostico, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addComponent(this.JSP_DDetalle, -1, 777, 32767)).addContainerGap()));
        JPI_DiagnosticosLayout.setVerticalGroup(JPI_DiagnosticosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DiagnosticosLayout.createSequentialGroup().addContainerGap().addComponent(this.JPI_DDiagnostico, -2, -1, -2).addGap(12, 12, 12).addComponent(this.JSP_DDetalle, -1, 127, 32767).addContainerGap()));
        this.JTPDatos_Qx.addTab("DIAGNÓSTICOS", this.JPI_Diagnosticos);
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
        this.JBT_NAdicionar.addActionListener(new ActionListener() { // from class: Historia.JPI_Cirugias.23
            public void actionPerformed(ActionEvent evt) {
                JPI_Cirugias.this.JBT_NAdicionarActionPerformed(evt);
            }
        });
        GroupLayout JPIDatosNLayout = new GroupLayout(this.JPIDatosN);
        this.JPIDatosN.setLayout(JPIDatosNLayout);
        JPIDatosNLayout.setHorizontalGroup(JPIDatosNLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosNLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosNLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosNLayout.createSequentialGroup().addComponent(this.JSP_NNota, -2, 623, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBT_NAdicionar)).addGroup(JPIDatosNLayout.createSequentialGroup().addComponent(this.JDC_NFecha, -2, 128, -2).addGap(18, 18, 18).addComponent(this.JTFF_NHora, -2, 96, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCB_NTipoNota, -2, 491, -2))).addContainerGap(-1, 32767)));
        JPIDatosNLayout.setVerticalGroup(JPIDatosNLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosNLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosNLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JCB_NTipoNota, GroupLayout.Alignment.LEADING, -2, 50, -2).addComponent(this.JDC_NFecha, GroupLayout.Alignment.LEADING, -1, 53, 32767).addComponent(this.JTFF_NHora, GroupLayout.Alignment.LEADING)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIDatosNLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JSP_NNota, -1, 104, 32767).addComponent(this.JBT_NAdicionar, -1, -1, 32767)).addContainerGap(11, 32767)));
        this.JSP_NDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 12), Color.red));
        this.JTB_NDetalle_Nota.setFont(new Font("Arial", 1, 12));
        this.JTB_NDetalle_Nota.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTB_NDetalle_Nota.setRowHeight(25);
        this.JTB_NDetalle_Nota.setSelectionBackground(new Color(255, 255, 255));
        this.JTB_NDetalle_Nota.setSelectionForeground(Color.red);
        this.JSP_NDetalle.setViewportView(this.JTB_NDetalle_Nota);
        GroupLayout JPINotasLayout = new GroupLayout(this.JPINotas);
        this.JPINotas.setLayout(JPINotasLayout);
        JPINotasLayout.setHorizontalGroup(JPINotasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPINotasLayout.createSequentialGroup().addContainerGap().addGroup(JPINotasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIDatosN, -1, -1, 32767).addGroup(JPINotasLayout.createSequentialGroup().addComponent(this.JSP_NDetalle, -2, 777, -2).addGap(0, 0, 32767))).addContainerGap()));
        JPINotasLayout.setVerticalGroup(JPINotasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPINotasLayout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatosN, -2, -1, -2).addGap(18, 18, 18).addComponent(this.JSP_NDetalle, -1, 61, 32767).addContainerGap()));
        this.JTPDatos_Qx.addTab("DESCRIPCIONES", this.JPINotas);
        this.JBTCierre.setFont(new Font("Arial", 1, 12));
        this.JBTCierre.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTCierre.setText("Cierre de Cirugía");
        this.JBTCierre.addActionListener(new ActionListener() { // from class: Historia.JPI_Cirugias.24
            public void actionPerformed(ActionEvent evt) {
                JPI_Cirugias.this.JBTCierreActionPerformed(evt);
            }
        });
        this.JBTRNacido.setFont(new Font("Arial", 1, 12));
        this.JBTRNacido.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Paciente.png")));
        this.JBTRNacido.setText("Recien Nacido");
        this.JBTRNacido.addActionListener(new ActionListener() { // from class: Historia.JPI_Cirugias.25
            public void actionPerformed(ActionEvent evt) {
                JPI_Cirugias.this.JBTRNacidoActionPerformed(evt);
            }
        });
        GroupLayout JPIDAdicionalesLayout = new GroupLayout(this.JPIDAdicionales);
        this.JPIDAdicionales.setLayout(JPIDAdicionalesLayout);
        JPIDAdicionalesLayout.setHorizontalGroup(JPIDAdicionalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDAdicionalesLayout.createSequentialGroup().addContainerGap().addComponent(this.JBTCierre, -2, 225, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBTRNacido, -2, 225, -2).addContainerGap(327, 32767)));
        JPIDAdicionalesLayout.setVerticalGroup(JPIDAdicionalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDAdicionalesLayout.createSequentialGroup().addContainerGap().addGroup(JPIDAdicionalesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBTCierre, -2, 49, -2).addComponent(this.JBTRNacido, -2, 49, -2)).addContainerGap(231, 32767)));
        this.JTPDatos_Qx.addTab("CIERRE", this.JPIDAdicionales);
        GroupLayout JPIDatos_IntervencionLayout = new GroupLayout(this.JPIDatos_Intervencion);
        this.JPIDatos_Intervencion.setLayout(JPIDatos_IntervencionLayout);
        JPIDatos_IntervencionLayout.setHorizontalGroup(JPIDatos_IntervencionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatos_IntervencionLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatos_IntervencionLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JPIDInicio, -1, -1, 32767).addComponent(this.JTPDatos_Qx, -2, 781, 32767)).addContainerGap(-1, 32767)));
        JPIDatos_IntervencionLayout.setVerticalGroup(JPIDatos_IntervencionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatos_IntervencionLayout.createSequentialGroup().addComponent(this.JPIDInicio, -1, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTPDatos_Qx, -2, 320, -2).addContainerGap()));
        this.JTPDatos_Qx.getAccessibleContext().setAccessibleName("AYUDAS DIAGNÓSTICAS");
        this.JTPDatosIntervencion.addTab("INTERVENCIÓN QUIRÚRGICA", this.JPIDatos_Intervencion);
        this.JTB_Historico.setFont(new Font("Arial", 1, 12));
        this.JTB_Historico.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTB_Historico.setRowHeight(25);
        this.JTB_Historico.setSelectionBackground(new Color(255, 255, 255));
        this.JTB_Historico.setSelectionForeground(Color.red);
        this.JTB_Historico.addMouseListener(new MouseAdapter() { // from class: Historia.JPI_Cirugias.26
            public void mouseClicked(MouseEvent evt) {
                JPI_Cirugias.this.JTB_HistoricoMouseClicked(evt);
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
    public void JTFF_HoraIKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JTFF_HoraI.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFF_HoraFKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JTFF_HoraF.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTB_HistoricoMouseClicked(MouseEvent evt) {
        if (this.JTB_Historico.getSelectedRow() != -1) {
            this.JLBNumero.setText(this.xModelo_Historico.getValueAt(this.JTB_Historico.getSelectedRow(), 0).toString());
            this.JDC_FechaI.setDate(this.xmt.getPasarTextoAFecha(this.xModelo_Historico.getValueAt(this.JTB_Historico.getSelectedRow(), 1).toString()));
            this.JTFF_HoraI.setValue(this.xmt.getPasarTextoAFechaHora(this.xModelo_Historico.getValueAt(this.JTB_Historico.getSelectedRow(), 1).toString() + " " + this.xModelo_Historico.getValueAt(this.JTB_Historico.getSelectedRow(), 2).toString()));
            this.JCBTipo_Anestecia.setSelectedItem(this.xModelo_Historico.getValueAt(this.JTB_Historico.getSelectedRow(), 5).toString());
            this.xCerrada = Boolean.valueOf(this.xModelo_Historico.getValueAt(this.JTB_Historico.getSelectedRow(), 6).toString()).booleanValue();
            mCargarDatosTabla_DProcedimiento();
            mCargarDatosTabla_DAyudasDx();
            mCargarDatosTabla_DDiagnostico();
            mCargarDatosTabla_SSuministro();
            mCargarDatosTabla_NNota();
            this.JTPDatosIntervencion.setSelectedIndex(0);
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
            if (!this.xCerrada) {
                if (!this.JTF_RNombre.getText().isEmpty()) {
                    if (!this.xmt.mVerificarDatosDoblesTabla(this.JTB_RDetalle_Procedimiento, 0, this.JTF_RCodigo.getText())) {
                        int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0);
                        if (x == 0) {
                            this.xsql = "insert into h_orden_qx_procedimientos(`Id_Orden_Qx` , `Id_Procedimiento` , `Id_Profesional` , `Id_Especialidad` , `Via` , `Orden`, `UsuaraioS` )values('" + this.JLBNumero.getText() + "','" + this.JTF_RCodigo.getText() + "','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "','" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "','" + this.xVia_Acceso + "','" + this.JSPNOrden.getValue() + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                            this.xct.ejecutarSQL(this.xsql);
                            this.xct.cerrarConexionBd();
                            mCargarDatosTabla_DProcedimiento();
                            this.JTF_RCodigo.setText("");
                            this.JTF_RNombre.setText("");
                            this.xVia_Acceso = 0L;
                            this.xSuministro_Procedimiento = -1L;
                            this.JRB_RVia_Igual.setSelected(true);
                            this.JTF_RCodigo.requestFocus();
                            return;
                        }
                        return;
                    }
                    JOptionPane.showInternalMessageDialog(this, "Código ya registrado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    this.JTF_RCodigo.requestFocus();
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un procedimiento", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JTF_RNombre.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "La intervención quirúrgica se encuentra cerrada", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_IAdicionarActionPerformed(ActionEvent evt) {
        if (!this.JLBNumero.getText().isEmpty()) {
            if (!this.xCerrada) {
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
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "La intervención quirúrgica se encuentra cerrada", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
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
    public void JBT_DAdicionarActionPerformed(ActionEvent evt) {
        if (!this.JLBNumero.getText().isEmpty()) {
            if (!this.xCerrada) {
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
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "La intervención quirúrgica se encuentra cerrada", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
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
            if (!this.xCerrada) {
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
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "La intervención quirúrgica se encuentra cerrada", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
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
            if (!this.xCerrada) {
                if (this.JCB_NTipoNota.getSelectedIndex() != -1) {
                    if (!this.JTA_NNota.getText().isEmpty()) {
                        int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0);
                        if (x == 0) {
                            this.xsql = "insert into h_orden_qx_notas(`Id_Orden_Qx` , `Id_TipoNota` , `FechaN` , `HoraN` , `Id_Especialidad` , `Id_Profesional` , `Descripcion` , `UsuarioS`)values('" + this.JLBNumero.getText() + "','" + this.xId_TipoNota[this.JCB_NTipoNota.getSelectedIndex()] + "','" + this.xmt.formatoAMD.format(this.JDC_NFecha.getDate()) + "','" + this.JTFF_NHora.getText() + "','" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "','" + this.JTA_NNota.getText() + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
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
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "La intervención quirúrgica se encuentra cerrada", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTCierreActionPerformed(ActionEvent evt) {
        if (!this.JLBNumero.getText().isEmpty()) {
            if (!this.xCerrada) {
                int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de cerrar la intervención quirúrgica??", "CONFIRMAR", 0);
                if (x == 0) {
                    this.xsql = "update h_orden_qx set `Fecha_Final`='" + this.xmt.formatoAMD.format(this.xmt.getFechaActual()) + "', `Hora_Final`='" + this.xmt.formatoH24.format(this.JTFF_HoraF.getValue()) + "' where Id='" + this.JLBNumero.getText() + "'";
                    this.xct.ejecutarSQL(this.xsql);
                    this.xct.cerrarConexionBd();
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "La intervención quirúrgica se encuentra cerrada", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTRNacidoActionPerformed(ActionEvent evt) {
        if (!this.JLBNumero.getText().isEmpty()) {
            JDOrdenNacidos xv = new JDOrdenNacidos(null, true, this.JLBNumero.getText());
            xv.setVisible(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCB_IProcedimientoMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JDBuscar_Informacion xjd_buscar = new JDBuscar_Informacion((Frame) null, true, this.JCB_IServicio, this.JCB_IProcedimiento, "Procedimiento", 1);
            xjd_buscar.setLocationRelativeTo(this);
            xjd_buscar.setVisible(true);
        }
    }

    private void mBuscarPatologiaN(JTextField codigo, JTextField nombrep) {
        JIFBuscarPatologia pac = new JIFBuscarPatologia(null, true, codigo, nombrep, "cirugia", 0);
        pac.setVisible(true);
        pac.setLocationRelativeTo(this);
    }

    private void mBuscar_Procedimiento() {
        if (!this.JTF_RCodigo.getText().isEmpty()) {
            try {
                this.xsql = "SELECT  `g_procedimiento`.`Id` , `g_procedimiento`.`Nbre`, IF(`g_procedimiento_suministro`.`Id_Sumistro` IS NULL, 0, 1) AS `Validacion` FROM `g_procedimiento` INNER JOIN  `f_tipoprocedimiento`  ON (`g_procedimiento`.`Id_tipoprocedimiento` = `f_tipoprocedimiento`.`Id`) INNER JOIN  `f_tipoclaseproc`  ON (`f_tipoprocedimiento`.`Id_tipoclaseproc` = `f_tipoclaseproc`.`Id`) RIGHT JOIN `g_procedimiento_suministro` ON (`g_procedimiento_suministro`.`Id_Procedimiento` = `g_procedimiento`.`Id`) WHERE (IFNULL(g_procedimiento.C_Homologado, `g_procedimiento`.`Id`) ='" + this.JTF_RCodigo.getText() + "' AND `f_tipoclaseproc`.`EsQco` =0 AND `g_procedimiento`.`Estado`=0) ORDER BY `g_procedimiento`.`Nbre` ASC ";
                ResultSet xrs = this.xct.traerRs(this.xsql);
                Throwable th = null;
                try {
                    if (xrs.next()) {
                        xrs.first();
                        this.JTF_RNombre.setText(xrs.getString(2));
                        this.xSuministro_Procedimiento = xrs.getLong(3);
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
                } finally {
                }
            } catch (SQLException ex) {
                Logger.getLogger(JPI_Cirugias.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
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
                Logger.getLogger(JPI_Cirugias.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
    }

    private void mBuscar_Suministro() {
        if (!this.JTF_SCodigo.getText().isEmpty()) {
            try {
                this.xsql = "SELECT `i_suministro`.`Id` , CONCAT(`i_suministro`.`Nbre`,' ', `i_presentacionfarmaceutica`.`Nbre`) AS `NSuministro` , `i_suministro`.`Escobrable` FROM  `i_suministro` INNER JOIN  `i_presentacionfarmaceutica`  ON (`i_suministro`.`IdPresentacionFarmaceutica` = `i_presentacionfarmaceutica`.`Id`) WHERE (`i_suministro`.`Id` ='" + this.JTF_SCodigo.getText() + "' AND `i_suministro`.`EstaActivo` =0) ORDER BY `NSuministro` ASC ";
                ResultSet xrs = this.xct.traerRs(this.xsql);
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
                xrs.close();
                this.xct.cerrarConexionBd();
            } catch (SQLException ex) {
                Logger.getLogger(JPI_Cirugias.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
    }

    public void mNuevo() {
        this.JDC_FechaI.setDate(this.xmt.getFechaActual());
        this.JTFF_HoraI.setValue(this.xmt.getFechaActual());
        this.JTFF_HoraF.setValue(this.xmt.getFechaActual());
        this.JCBTipo_Anestecia.removeAllItems();
        this.xId_Anestesia = this.xct.llenarCombo("SELECT  `Id` , `Nbre` FROM `f_tipoanestesia` WHERE (`Estado` =0) ORDER BY `Nbre` ASC", this.xId_Anestesia, this.JCBTipo_Anestecia);
        this.JCBTipo_Anestecia.setSelectedIndex(-1);
        this.JCB_IProfesional1.removeAllItems();
        this.xId_Cirujano = this.xct.llenarCombo("SELECT `Id_Persona`, `NProfesional`, `Especialidad`  FROM `profesional1` WHERE (`Es_Qx` =1 AND estado=0) ORDER BY `NProfesional`", this.xId_Cirujano, this.JCB_IProfesional1);
        this.JCB_IProfesional1.setSelectedIndex(-1);
        this.JCB_IProfesional2.removeAllItems();
        this.xId_Ayudante = this.xct.llenarCombo("SELECT `Id_Persona`, `NProfesional`, `Especialidad`  FROM `profesional1` WHERE (`Es_Qx` =1 AND estado=0 and (IdEspecialidad=3 OR IdEspecialidad=382)) ORDER BY `NProfesional`", this.xId_Ayudante, this.JCB_IProfesional2);
        this.JCB_IProfesional2.setSelectedIndex(-1);
        this.JCB_IProfesional3.removeAllItems();
        this.xId_Instrumentador = this.xct.llenarCombo("SELECT `Id_Persona`, `NProfesional`, `Especialidad`  FROM `profesional1` WHERE (`Es_Qx` =1 AND estado=0 and IdEspecialidad=52 ) ORDER BY `NProfesional`", this.xId_Instrumentador, this.JCB_IProfesional3);
        this.JCB_IProfesional3.setSelectedIndex(-1);
        this.JCB_IProfesional4.removeAllItems();
        this.xId_Anestesiologo = this.xct.llenarCombo("SELECT `Id_Persona`, `NProfesional`, `Especialidad`  FROM `profesional1` WHERE (`Es_Qx` =1 AND estado=0 and IdEspecialidad=21) ORDER BY `NProfesional`", this.xId_Anestesiologo, this.JCB_IProfesional4);
        this.JCB_IProfesional4.setSelectedIndex(-1);
        mNuevo_Integrante();
        mNuevo_Diagnostico();
        mNuevo_Suministro();
        mNueva_Nota();
        mCargarDatosTabla();
        mCrearModelo_Procedimiento();
        mCrearModelo_AyudasDx();
        mCrearModelo_Patologia();
        mCrearModelo_Suministro();
        mCrearModelo_Nota();
    }

    private void mNuevo_Integrante() {
        this.xLleno_Servicio = false;
        this.JCB_IServicio.removeAllItems();
        this.xsql = "SELECT  `f_tiposervicio`.`Id` , `f_tiposervicio`.`Nbre` FROM  `g_procedimiento` INNER JOIN `f_tipoprocedimiento`  ON (`g_procedimiento`.`Id_tipoprocedimiento` = `f_tipoprocedimiento`.`Id`) INNER JOIN `f_tiposervtipoproced`  ON (`f_tiposervtipoproced`.`Idtipoprocedimiento` = `f_tipoprocedimiento`.`Id`) INNER JOIN `f_tiposervicio`  ON (`f_tiposervtipoproced`.`Idtiposervicio` = `f_tiposervicio`.`Id`) WHERE (`f_tipoprocedimiento`.`Id` IN(6,8,9,12)) GROUP BY `f_tipoprocedimiento`.`Id` ORDER BY `f_tiposervicio`.`Nbre` ASC ";
        this.xId_Servicio = this.xct.llenarCombo(this.xsql, this.xId_Servicio, this.JCB_IServicio);
        this.xct.cerrarConexionBd();
        this.JCB_IServicio.setSelectedIndex(-1);
        this.JSP_INCantidad.setValue(new Integer(1));
        this.xLleno_Servicio = true;
    }

    private void mNuevo_Diagnostico() {
        this.JTF_DCodigo.setText("");
        this.JTF_DNombre.setText("");
        this.JSP_DNOrden.setValue(new Integer(0));
        this.JTA_DObservacion.setText("");
    }

    private void mNuevo_Suministro() {
        this.JTF_SCodigo.setText("");
        this.JTF_SNombre.setText("");
        this.JSP_SCantidad.setValue(new Integer(1));
        this.JTA_SObservacion.setText("");
    }

    private void mNueva_Nota() {
        this.JDC_NFecha.setDate(this.xmt.getFechaActual());
        this.JTFF_NHora.setText(this.xmt.formatoH24.format(this.xmt.getFechaActual()));
        this.JTA_NNota.setText("");
        this.JCB_NTipoNota.removeAllItems();
        this.xsql = "SELECT `h_tiponota`.`Id` , `h_tiponota`.`Nbre` FROM `h_tiponota_especialidad` INNER JOIN  `h_tiponota`  ON (`h_tiponota_especialidad`.`Id_TipoNota` = `h_tiponota`.`Id`) WHERE (`h_tiponota_especialidad`.`Id_Especialidad` ='" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "' AND `h_tiponota_especialidad`.`Estado` =1 AND  `h_tiponota`.`Id_Clasificacion`=9) ORDER BY `h_tiponota`.`Nbre` ASC ";
        this.xId_TipoNota = this.xct.llenarCombo(this.xsql, this.xId_TipoNota, this.JCB_NTipoNota);
        this.JCB_NTipoNota.setSelectedIndex(-1);
        this.xct.cerrarConexionBd();
    }

    public void mGrabar() {
        if (this.JCBTipo_Anestecia.getSelectedIndex() != -1) {
            if (this.JCB_IProfesional1.getSelectedIndex() != -1) {
                if (this.JCB_IProfesional2.getSelectedIndex() != -1) {
                    if (this.JCB_IProfesional3.getSelectedIndex() != -1) {
                        if (this.JCB_IProfesional4.getSelectedIndex() != -1) {
                            int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0);
                            if (x == 0) {
                                this.xsql = "insert into h_orden_qx   (`Id_Atencion` , `Fecha_Inicial` , `Hora_Inicla` , `Id_Tipo_Anestesia` , `Cirujano`, `Ayudante`, `Anestesiologo`, `Instrumentador`, `UsuarioS` )  values ('" + this.xId_Atencion + "','" + this.xmt.formatoAMD.format(this.JDC_FechaI.getDate()) + "','" + this.xmt.formatoH24.format(this.JTFF_HoraI.getValue()) + "','" + this.xId_Anestesia[this.JCBTipo_Anestecia.getSelectedIndex()] + "','" + this.JCB_IProfesional1.getSelectedItem() + "','" + this.JCB_IProfesional2.getSelectedItem() + "','" + this.JCB_IProfesional3.getSelectedItem() + "','" + this.JCB_IProfesional4.getSelectedItem() + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                                this.JLBNumero.setText(this.xct.ejecutarSQLId(this.xsql));
                                this.xct.cerrarConexionBd();
                                return;
                            }
                            return;
                        }
                        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un anestesiólogo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        this.JCB_IProfesional4.requestFocus();
                        return;
                    }
                    JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un instrumentador", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    this.JCB_IProfesional3.requestFocus();
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un ayudante", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JCB_IProfesional2.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un cirujano", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCB_IProfesional1.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un tipo de anestesia", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JCBTipo_Anestecia.requestFocus();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloHistorico() {
        this.xModelo_Historico = new DefaultTableModel(new Object[0], new String[]{"Id", "Fecha_Inicial", "Hora_Inicial", "Fecha_Final", "Hora Final", "Anestesia", "Estado"}) { // from class: Historia.JPI_Cirugias.27
            Class[] types = {Long.class, String.class, String.class, String.class, String.class, String.class, Boolean.class};
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
        this.xModelo_Procedimientos = new DefaultTableModel(new Object[0], new String[]{"Código", "Procedimiento", "Especialidad", "Profesional", "Vía Acceso", "Orden"}) { // from class: Historia.JPI_Cirugias.28
            Class[] types = {String.class, String.class, String.class, String.class, String.class, Long.class};
            boolean[] canEdit = {false, false, false, false, false, false};

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
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModelo_AyudasDx() {
        this.xModelo_AyudasDx = new DefaultTableModel(new Object[0], new String[]{"Id", "Fecha", "Servicio", "Procedimiento", "Cantidad"}) { // from class: Historia.JPI_Cirugias.29
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

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModelo_Patologia() {
        this.xModelo_Patologia = new DefaultTableModel(new Object[0], new String[]{"Cie10", "Patología", "Tipo", "Observación", "Orden"}) { // from class: Historia.JPI_Cirugias.30
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
        this.xModelo_Suministro = new DefaultTableModel(new Object[0], new String[]{"Código", "Tipo", "Nombre", "Cobrable", "Cantidad", "Observación"}) { // from class: Historia.JPI_Cirugias.31
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
        this.xModelo_Nota = new DefaultTableModel(new Object[0], new String[]{"Id", "Fecha Hora", "Tipo", "Especialidad", "Profesional", "Descripcion"}) { // from class: Historia.JPI_Cirugias.32
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

    private void mCargarDatosTabla() {
        try {
            mCrearModeloHistorico();
            this.xsql = "SELECT `h_orden_qx`.`Id` , date_format(`h_orden_qx`.`Fecha_Inicial`,'%d/%m/%Y') as FInicial , `h_orden_qx`.`Hora_Inicla`  , IF(`h_orden_qx`.`Fecha_Final` IS NULL, '', `h_orden_qx`.`Fecha_Final`) AS FFinal , IF(`h_orden_qx`.`Hora_Final` IS NULL, '', `h_orden_qx`.`Hora_Final`) AS HFinal , `f_tipoanestesia`.`Nbre`, IF(`h_orden_qx`.`Hora_Final` IS NULL, 0, 1) FROM `h_orden_qx` INNER JOIN  `f_tipoanestesia`   ON (`h_orden_qx`.`Id_Tipo_Anestesia` = `f_tipoanestesia`.`Id`) WHERE (`h_orden_qx`.`Estado` =1 AND `h_orden_qx`.`Id_Atencion` ='" + this.xId_Atencion + "')  ORDER BY `h_orden_qx`.`Fecha_Inicial` DESC ";
            ResultSet xrs = this.xct.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int x = 0;
                while (xrs.next()) {
                    this.xModelo_Historico.addRow(this.xDatos);
                    this.xModelo_Historico.setValueAt(Long.valueOf(xrs.getLong(1)), x, 0);
                    this.xModelo_Historico.setValueAt(xrs.getString(2), x, 1);
                    this.xModelo_Historico.setValueAt(xrs.getString(3), x, 2);
                    this.xModelo_Historico.setValueAt(xrs.getString(4), x, 3);
                    this.xModelo_Historico.setValueAt(xrs.getString(5), x, 4);
                    this.xModelo_Historico.setValueAt(xrs.getString(6), x, 5);
                    this.xModelo_Historico.setValueAt(Boolean.valueOf(xrs.getBoolean(7)), x, 6);
                    this.JTB_Historico.setDefaultRenderer(Object.class, new MiRender());
                    x++;
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
            this.xsql = "SELECT  `h_orden_qx_procedimientos`.`Id_Procedimiento`  , `g_procedimiento`.`Nbre` , `profesional1`.`Especialidad` , `profesional1`.`NProfesional` , IF(`h_orden_qx_procedimientos`.`Via`=0, 'Igual', 'Direfente') AS Via , `h_orden_qx_procedimientos`.`Orden` FROM `h_orden_qx_procedimientos` INNER JOIN  `g_procedimiento`  ON (`h_orden_qx_procedimientos`.`Id_Procedimiento` = `g_procedimiento`.`Id`) INNER JOIN  `profesional1`  ON (`profesional1`.`IdEspecialidad` = `h_orden_qx_procedimientos`.`Id_Especialidad`) AND (`profesional1`.`Id_Persona` = `h_orden_qx_procedimientos`.`Id_Profesional`) WHERE (`h_orden_qx_procedimientos`.`Estado` =1 AND h_orden_qx_procedimientos.`Id_Orden_Qx`='" + this.JLBNumero.getText() + "') ORDER BY `h_orden_qx_procedimientos`.`Orden` ASC ";
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
                    this.xModelo_Procedimientos.setValueAt(Integer.valueOf(xrs.getInt(6)), x, 5);
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

    /* JADX INFO: loaded from: GenomaP.jar:Historia/JPI_Cirugias$MiRender.class */
    public static class MiRender extends DefaultTableCellRenderer {
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (Boolean.valueOf(table.getValueAt(row, 6).toString()).booleanValue()) {
                cell.setBackground(new Color(177, 251, 177));
            } else {
                cell.setBackground(Color.WHITE);
            }
            return cell;
        }
    }

    public void mImprimir() {
        if (!this.JLBNumero.getText().isEmpty()) {
            String[][] mparametros = new String[3][2];
            mparametros[0][0] = "Id";
            mparametros[0][1] = this.JLBNumero.getText();
            mparametros[1][0] = "SUBREPORT_DIR";
            mparametros[1][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
            mparametros[2][0] = "SUBREPORTFIRMA_DIR";
            mparametros[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
            if (Principal.informacionIps.getEsFpz().intValue() == 1) {
                this.xmt.GenerarPDF(this.xmt.getRutaRep() + "H_Informe_Quirurgico", mparametros);
            } else {
                this.xmt.GenerarPDF(this.xmt.getRutaRep() + "H_Informe_Quirurgico", mparametros);
            }
        }
    }
}
