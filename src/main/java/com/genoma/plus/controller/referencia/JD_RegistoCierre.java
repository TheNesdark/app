package com.genoma.plus.controller.referencia;

import Acceso.Principal;
import Historia.JDEmpresaQueRecibe;
import Utilidades.Metodos;
import com.genoma.plus.jpa.entities.GAmbulancia;
import com.genoma.plus.jpa.entities.MunicipioDTO;
import com.genoma.plus.jpa.entities.RemisionesCierreDTO;
import com.genoma.plus.jpa.entities.RemisionesDTO;
import com.genoma.plus.jpa.projection.IRemisionCierre;
import com.genoma.plus.jpa.service.IAmbulanciaService;
import com.genoma.plus.jpa.service.IMunicipioService;
import com.genoma.plus.jpa.service.IRemisionesCierreService;
import com.genoma.plus.jpa.service.IRemisionesService;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
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
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.text.DateFormatter;
import javax.swing.text.DefaultFormatterFactory;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/referencia/JD_RegistoCierre.class */
public class JD_RegistoCierre extends JDialog {
    private Long idRemision;
    private Metodos metodos;
    private final IRemisionesCierreService remisionesCierreService;
    private final IRemisionesService remisionesService;
    private final IMunicipioService municipioService;
    private final IAmbulanciaService ambulanciaService;
    private RemisionesDTO remisionesDTO;
    private Optional<RemisionesCierreDTO> remisionesCierreDTO;
    private List<MunicipioDTO> municipioDTOs;
    private List<GAmbulancia> ambulancia;
    private String idMunicipio;
    private String nombreAmbulancia;
    public Boolean lleno;
    private Integer idAmbulancia;
    private ButtonGroup JBG_TipoVehiculo;
    private JButton JBGuardar;
    private JButton JBGuardar1;
    private JButton JBNuevo;
    private JButton JBT_Salir;
    public JComboBox JCBAmbulancia;
    public JComboBox JCBMunicipio;
    private JCheckBox JCH_Aceptado;
    private JDateChooser JDC_AFecha;
    private JDateChooser JDC_LFecha;
    private JDateChooser JDC_SFecha;
    private JDateChooser JDFechaC;
    private JLabel JLB_IdCierre;
    private JLabel JLB_ResponsableCierre;
    private JPanel JPI_DatosRegistro;
    private JPanel JPI_FechaAceptacion;
    private JPanel JPI_FechaLlegada;
    private JPanel JPI_FechaSalida;
    private JPanel JPI_InformacionAmbulacia;
    private JPanel JPI_InformacionReferencia;
    private JPanel JPI_TipoVehiculo;
    private JRadioButton JRB_TAmbulancia;
    private JRadioButton JRB_TAmbulanciaMedicalizada;
    private JRadioButton JRB_TParticular;
    private JScrollPane JSPDRObservaciones;
    private JScrollPane JSPObservacion;
    private JTextPane JTADRObservaciones;
    private JTextArea JTAObservacion;
    private JTabbedPane JTB_DatosReferencia;

    /* JADX INFO: renamed from: JTFAcompañante, reason: contains not printable characters */
    private JTextField f24JTFAcompaante;

    /* JADX INFO: renamed from: JTFAcompañanteTelefono, reason: contains not printable characters */
    private JTextField f25JTFAcompaanteTelefono;
    public JTextField JTFCHabitacion;
    public JTextField JTFConductor;
    public JTextField JTFConductorCedula;
    public JTextField JTFEnfermeraAmbulancia;
    public JTextField JTFEnfermeraAmbulanciaCedula;
    private JFormattedTextField JTFF_AHora;
    private JFormattedTextField JTFF_LHora;
    private JFormattedTextField JTFF_SHora;
    private JFormattedTextField JTFHora;
    public JTextField JTFInstirucionRecibe;
    public JTextField JTFMedicoAmbulancia;
    public JTextField JTFMedicoAmbulanciaCedula;
    private JTextField JTFProfesion;
    private JTextField JTFProfesionalRecibe;

    public JD_RegistoCierre(Frame parent, boolean modal, Long idRemision) {
        super(parent, modal);
        this.metodos = new Metodos();
        this.remisionesCierreService = (IRemisionesCierreService) Principal.contexto.getBean(IRemisionesCierreService.class);
        this.remisionesService = (IRemisionesService) Principal.contexto.getBean(IRemisionesService.class);
        this.municipioService = (IMunicipioService) Principal.contexto.getBean(IMunicipioService.class);
        this.ambulanciaService = (IAmbulanciaService) Principal.contexto.getBean(IAmbulanciaService.class);
        this.idMunicipio = "-1";
        this.nombreAmbulancia = "";
        this.lleno = false;
        initComponents();
        this.idRemision = idRemision;
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        nuevo();
    }

    private void initComponents() {
        this.JBG_TipoVehiculo = new ButtonGroup();
        this.JPI_DatosRegistro = new JPanel();
        this.JDFechaC = new JDateChooser();
        this.JSPObservacion = new JScrollPane();
        this.JTAObservacion = new JTextArea();
        this.JTFHora = new JFormattedTextField();
        this.JLB_IdCierre = new JLabel();
        this.JLB_ResponsableCierre = new JLabel();
        this.JBNuevo = new JButton();
        this.JBGuardar = new JButton();
        this.JBT_Salir = new JButton();
        this.JTB_DatosReferencia = new JTabbedPane();
        this.JPI_InformacionReferencia = new JPanel();
        this.JCBMunicipio = new JComboBox();
        this.JTFInstirucionRecibe = new JTextField();
        this.JTFProfesionalRecibe = new JTextField();
        this.JTFProfesion = new JTextField();
        this.JSPDRObservaciones = new JScrollPane();
        this.JTADRObservaciones = new JTextPane();
        this.JTFCHabitacion = new JTextField();
        this.JCH_Aceptado = new JCheckBox();
        this.f24JTFAcompaante = new JTextField();
        this.f25JTFAcompaanteTelefono = new JTextField();
        this.JPI_InformacionAmbulacia = new JPanel();
        this.JTFConductor = new JTextField();
        this.JPI_FechaAceptacion = new JPanel();
        this.JDC_AFecha = new JDateChooser("dd/MM/yyyy", "##/##/####", '_');
        this.JTFF_AHora = new JFormattedTextField();
        this.JPI_FechaSalida = new JPanel();
        this.JDC_SFecha = new JDateChooser("dd/MM/yyyy", "##/##/####", '_');
        this.JTFF_SHora = new JFormattedTextField();
        this.JPI_FechaLlegada = new JPanel();
        this.JDC_LFecha = new JDateChooser("dd/MM/yyyy", "##/##/####", '_');
        this.JTFF_LHora = new JFormattedTextField();
        this.JTFMedicoAmbulanciaCedula = new JTextField();
        this.JTFEnfermeraAmbulancia = new JTextField();
        this.JPI_TipoVehiculo = new JPanel();
        this.JRB_TAmbulancia = new JRadioButton();
        this.JRB_TParticular = new JRadioButton();
        this.JRB_TAmbulanciaMedicalizada = new JRadioButton();
        this.JCBAmbulancia = new JComboBox();
        this.JTFMedicoAmbulancia = new JTextField();
        this.JTFEnfermeraAmbulanciaCedula = new JTextField();
        this.JTFConductorCedula = new JTextField();
        this.JBGuardar1 = new JButton();
        setDefaultCloseOperation(2);
        setTitle("REGISTRO DE CIERRE");
        setFont(new Font("Arial", 1, 14));
        this.JPI_DatosRegistro.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS CIERRE", 0, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JPI_DatosRegistro.setFont(new Font("Arial", 1, 14));
        this.JDFechaC.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaC.setDateFormatString("dd/MM/yyyy");
        this.JDFechaC.setFont(new Font("Arial", 1, 12));
        this.JSPObservacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Observacion", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTAObservacion.setColumns(20);
        this.JTAObservacion.setFont(new Font("Arial", 1, 12));
        this.JTAObservacion.setRows(5);
        this.JSPObservacion.setViewportView(this.JTAObservacion);
        this.JTFHora.setBorder(BorderFactory.createTitledBorder((Border) null, "Hora", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFHora.setFormatterFactory(new DefaultFormatterFactory(new DateFormatter(new SimpleDateFormat("HH:mm:ss"))));
        this.JTFHora.setFont(new Font("Arial", 1, 12));
        this.JLB_IdCierre.setFont(new Font("Arial", 1, 16));
        this.JLB_IdCierre.setHorizontalAlignment(0);
        this.JLB_IdCierre.setBorder(BorderFactory.createTitledBorder((Border) null, "Id", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JLB_ResponsableCierre.setFont(new Font("Arial", 1, 12));
        this.JLB_ResponsableCierre.setBorder(BorderFactory.createTitledBorder((Border) null, "Responsable", 0, 0, new Font("Arial", 1, 12), Color.red));
        GroupLayout JPI_DatosRegistroLayout = new GroupLayout(this.JPI_DatosRegistro);
        this.JPI_DatosRegistro.setLayout(JPI_DatosRegistroLayout);
        JPI_DatosRegistroLayout.setHorizontalGroup(JPI_DatosRegistroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DatosRegistroLayout.createSequentialGroup().addContainerGap().addGroup(JPI_DatosRegistroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DatosRegistroLayout.createSequentialGroup().addComponent(this.JDFechaC, -2, 136, -2).addGap(32, 32, 32).addComponent(this.JTFHora, -2, 110, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JLB_IdCierre, -2, 111, -2).addGap(14, 14, 14)).addGroup(GroupLayout.Alignment.TRAILING, JPI_DatosRegistroLayout.createSequentialGroup().addGroup(JPI_DatosRegistroLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JLB_ResponsableCierre, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JSPObservacion)).addContainerGap()))));
        JPI_DatosRegistroLayout.setVerticalGroup(JPI_DatosRegistroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DatosRegistroLayout.createSequentialGroup().addContainerGap().addGroup(JPI_DatosRegistroLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JDFechaC, GroupLayout.Alignment.TRAILING, -1, 50, 32767).addComponent(this.JLB_IdCierre, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addComponent(this.JTFHora, GroupLayout.Alignment.TRAILING)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPObservacion, -2, -1, -2).addGap(18, 18, 18).addComponent(this.JLB_ResponsableCierre, -1, 50, 32767).addContainerGap()));
        this.JBNuevo.setFont(new Font("Arial", 1, 12));
        this.JBNuevo.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Nuevo.png")));
        this.JBNuevo.setText("Nuevo");
        this.JBNuevo.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.referencia.JD_RegistoCierre.1
            public void actionPerformed(ActionEvent evt) {
                JD_RegistoCierre.this.JBNuevoActionPerformed(evt);
            }
        });
        this.JBGuardar.setFont(new Font("Arial", 1, 12));
        this.JBGuardar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Grabar29x27.png")));
        this.JBGuardar.setText("Guardar");
        this.JBGuardar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.referencia.JD_RegistoCierre.2
            public void actionPerformed(ActionEvent evt) {
                JD_RegistoCierre.this.JBGuardarActionPerformed(evt);
            }
        });
        this.JBT_Salir.setFont(new Font("Arial", 1, 12));
        this.JBT_Salir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.JBT_Salir.setText("Salir");
        this.JBT_Salir.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.referencia.JD_RegistoCierre.3
            public void actionPerformed(ActionEvent evt) {
                JD_RegistoCierre.this.JBT_SalirActionPerformed(evt);
            }
        });
        this.JTB_DatosReferencia.setBorder(BorderFactory.createCompoundBorder());
        this.JTB_DatosReferencia.setForeground(Color.red);
        this.JTB_DatosReferencia.setFont(new Font("Arial", 1, 14));
        this.JCBMunicipio.setFont(new Font("Arial", 1, 12));
        this.JCBMunicipio.setBorder(BorderFactory.createTitledBorder((Border) null, "Municipio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBMunicipio.addItemListener(new ItemListener() { // from class: com.genoma.plus.controller.referencia.JD_RegistoCierre.4
            public void itemStateChanged(ItemEvent evt) {
                JD_RegistoCierre.this.JCBMunicipioItemStateChanged(evt);
            }
        });
        this.JTFInstirucionRecibe.setFont(new Font("Arial", 1, 12));
        this.JTFInstirucionRecibe.setBorder(BorderFactory.createTitledBorder((Border) null, "Institución que Recibe", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFInstirucionRecibe.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.referencia.JD_RegistoCierre.5
            public void mouseClicked(MouseEvent evt) {
                JD_RegistoCierre.this.JTFInstirucionRecibeMouseClicked(evt);
            }
        });
        this.JTFProfesionalRecibe.setFont(new Font("Arial", 1, 12));
        this.JTFProfesionalRecibe.setBorder(BorderFactory.createTitledBorder((Border) null, "Profesional que Recibe", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFProfesion.setFont(new Font("Arial", 1, 12));
        this.JTFProfesion.setBorder(BorderFactory.createTitledBorder((Border) null, "Profesión", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPDRObservaciones.setBorder(BorderFactory.createTitledBorder((Border) null, "Observaciones", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTADRObservaciones.setFont(new Font("Arial", 1, 12));
        this.JSPDRObservaciones.setViewportView(this.JTADRObservaciones);
        this.JTFCHabitacion.setFont(new Font("Arial", 1, 12));
        this.JTFCHabitacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Código habilitación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFCHabitacion.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.referencia.JD_RegistoCierre.6
            public void actionPerformed(ActionEvent evt) {
                JD_RegistoCierre.this.JTFCHabitacionActionPerformed(evt);
            }
        });
        this.JCH_Aceptado.setFont(new Font("Arial", 1, 12));
        this.JCH_Aceptado.setForeground(Color.red);
        this.JCH_Aceptado.setText("Aceptado?");
        this.f24JTFAcompaante.setFont(new Font("Arial", 1, 12));
        this.f24JTFAcompaante.setBorder(BorderFactory.createTitledBorder((Border) null, "Acompañante", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.f25JTFAcompaanteTelefono.setFont(new Font("Arial", 1, 12));
        this.f25JTFAcompaanteTelefono.setBorder(BorderFactory.createTitledBorder((Border) null, "Telefono Acompañante", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPI_InformacionReferenciaLayout = new GroupLayout(this.JPI_InformacionReferencia);
        this.JPI_InformacionReferencia.setLayout(JPI_InformacionReferenciaLayout);
        JPI_InformacionReferenciaLayout.setHorizontalGroup(JPI_InformacionReferenciaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_InformacionReferenciaLayout.createSequentialGroup().addContainerGap().addGroup(JPI_InformacionReferenciaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_InformacionReferenciaLayout.createSequentialGroup().addComponent(this.JSPDRObservaciones).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCH_Aceptado).addGap(12, 12, 12)).addGroup(GroupLayout.Alignment.TRAILING, JPI_InformacionReferenciaLayout.createSequentialGroup().addComponent(this.JTFProfesionalRecibe, -2, 309, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFProfesion, -2, 242, -2).addGap(18, 18, 18).addComponent(this.f24JTFAcompaante, -1, 269, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.f25JTFAcompaanteTelefono, -2, 189, -2).addContainerGap()).addGroup(JPI_InformacionReferenciaLayout.createSequentialGroup().addComponent(this.JCBMunicipio, -2, 205, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFInstirucionRecibe, -2, 486, -2).addGap(18, 18, 18).addComponent(this.JTFCHabitacion).addContainerGap()))));
        JPI_InformacionReferenciaLayout.setVerticalGroup(JPI_InformacionReferenciaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_InformacionReferenciaLayout.createSequentialGroup().addGroup(JPI_InformacionReferenciaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBMunicipio, -2, 50, -2).addComponent(this.JTFInstirucionRecibe, -2, 50, -2).addComponent(this.JTFCHabitacion, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPI_InformacionReferenciaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFProfesionalRecibe, -2, 50, -2).addComponent(this.JTFProfesion, -2, 50, -2).addComponent(this.f24JTFAcompaante, -2, 50, -2).addComponent(this.f25JTFAcompaanteTelefono, -2, 50, -2)).addGroup(JPI_InformacionReferenciaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_InformacionReferenciaLayout.createSequentialGroup().addGap(5, 5, 5).addComponent(this.JSPDRObservaciones, -1, 92, 32767).addContainerGap()).addGroup(GroupLayout.Alignment.TRAILING, JPI_InformacionReferenciaLayout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 42, 32767).addComponent(this.JCH_Aceptado).addGap(36, 36, 36)))));
        this.JTB_DatosReferencia.addTab("INFORMACIÓN DE REFERENCIA", this.JPI_InformacionReferencia);
        this.JTFConductor.setFont(new Font("Arial", 1, 12));
        this.JTFConductor.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre Conductor", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFConductor.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.referencia.JD_RegistoCierre.7
            public void mouseClicked(MouseEvent evt) {
                JD_RegistoCierre.this.JTFConductorMouseClicked(evt);
            }
        });
        this.JTFConductor.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.referencia.JD_RegistoCierre.8
            public void actionPerformed(ActionEvent evt) {
                JD_RegistoCierre.this.JTFConductorActionPerformed(evt);
            }
        });
        this.JPI_FechaAceptacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha y Hora(Aceptación)", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JDC_AFecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDC_AFecha.setDateFormatString("dd/MM/yyyy");
        this.JDC_AFecha.setFont(new Font("Arial", 1, 12));
        this.JTFF_AHora.setBorder(BorderFactory.createTitledBorder((Border) null, "Hora", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFF_AHora.setFormatterFactory(new DefaultFormatterFactory(new DateFormatter(new SimpleDateFormat("HH:mm:ss"))));
        this.JTFF_AHora.setFont(new Font("Arial", 1, 12));
        this.JTFF_AHora.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.referencia.JD_RegistoCierre.9
            public void actionPerformed(ActionEvent evt) {
                JD_RegistoCierre.this.JTFF_AHoraActionPerformed(evt);
            }
        });
        GroupLayout JPI_FechaAceptacionLayout = new GroupLayout(this.JPI_FechaAceptacion);
        this.JPI_FechaAceptacion.setLayout(JPI_FechaAceptacionLayout);
        JPI_FechaAceptacionLayout.setHorizontalGroup(JPI_FechaAceptacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_FechaAceptacionLayout.createSequentialGroup().addContainerGap().addComponent(this.JDC_AFecha, -2, 130, -2).addGap(10, 10, 10).addComponent(this.JTFF_AHora, -2, 88, -2).addGap(5, 5, 5)));
        JPI_FechaAceptacionLayout.setVerticalGroup(JPI_FechaAceptacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_FechaAceptacionLayout.createSequentialGroup().addGroup(JPI_FechaAceptacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFF_AHora, -2, 50, -2).addComponent(this.JDC_AFecha, GroupLayout.Alignment.TRAILING, -2, -1, -2)).addGap(5, 5, 5)));
        this.JPI_FechaSalida.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha y Hora(Salida)", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JDC_SFecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDC_SFecha.setDateFormatString("dd/MM/yyyy");
        this.JDC_SFecha.setFont(new Font("Arial", 1, 12));
        this.JTFF_SHora.setBorder(BorderFactory.createTitledBorder((Border) null, "Hora", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFF_SHora.setFormatterFactory(new DefaultFormatterFactory(new DateFormatter(new SimpleDateFormat("HH:mm:ss"))));
        this.JTFF_SHora.setFont(new Font("Arial", 1, 12));
        GroupLayout JPI_FechaSalidaLayout = new GroupLayout(this.JPI_FechaSalida);
        this.JPI_FechaSalida.setLayout(JPI_FechaSalidaLayout);
        JPI_FechaSalidaLayout.setHorizontalGroup(JPI_FechaSalidaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_FechaSalidaLayout.createSequentialGroup().addContainerGap().addComponent(this.JDC_SFecha, -2, 130, -2).addGap(10, 10, 10).addComponent(this.JTFF_SHora, -2, 90, -2).addGap(5, 5, 5)));
        JPI_FechaSalidaLayout.setVerticalGroup(JPI_FechaSalidaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_FechaSalidaLayout.createSequentialGroup().addGroup(JPI_FechaSalidaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFF_SHora, -2, 50, -2).addComponent(this.JDC_SFecha, GroupLayout.Alignment.TRAILING, -2, -1, -2)).addContainerGap(-1, 32767)));
        this.JPI_FechaLlegada.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha y Hora(Llegada al destino)", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JDC_LFecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDC_LFecha.setDateFormatString("dd/MM/yyyy");
        this.JDC_LFecha.setFont(new Font("Arial", 1, 12));
        this.JTFF_LHora.setBorder(BorderFactory.createTitledBorder((Border) null, "Hora", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFF_LHora.setFormatterFactory(new DefaultFormatterFactory(new DateFormatter(new SimpleDateFormat("HH:mm:ss"))));
        this.JTFF_LHora.setFont(new Font("Arial", 1, 12));
        GroupLayout JPI_FechaLlegadaLayout = new GroupLayout(this.JPI_FechaLlegada);
        this.JPI_FechaLlegada.setLayout(JPI_FechaLlegadaLayout);
        JPI_FechaLlegadaLayout.setHorizontalGroup(JPI_FechaLlegadaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_FechaLlegadaLayout.createSequentialGroup().addContainerGap().addComponent(this.JDC_LFecha, -2, 130, -2).addGap(10, 10, 10).addComponent(this.JTFF_LHora, -2, 95, -2).addGap(5, 5, 5)));
        JPI_FechaLlegadaLayout.setVerticalGroup(JPI_FechaLlegadaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFF_LHora, -2, 50, -2).addComponent(this.JDC_LFecha, GroupLayout.Alignment.TRAILING, -2, -1, -2));
        this.JTFMedicoAmbulanciaCedula.setFont(new Font("Arial", 1, 12));
        this.JTFMedicoAmbulanciaCedula.setBorder(BorderFactory.createTitledBorder((Border) null, "Identificación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFEnfermeraAmbulancia.setFont(new Font("Arial", 1, 12));
        this.JTFEnfermeraAmbulancia.setBorder(BorderFactory.createTitledBorder((Border) null, "Auxiliar Enfermería", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFEnfermeraAmbulancia.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.referencia.JD_RegistoCierre.10
            public void mouseClicked(MouseEvent evt) {
                JD_RegistoCierre.this.JTFEnfermeraAmbulanciaMouseClicked(evt);
            }
        });
        this.JPI_TipoVehiculo.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Vehiculo", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JBG_TipoVehiculo.add(this.JRB_TAmbulancia);
        this.JRB_TAmbulancia.setFont(new Font("Arial", 1, 12));
        this.JRB_TAmbulancia.setSelected(true);
        this.JRB_TAmbulancia.setText("Ambulancia básica ");
        this.JRB_TAmbulancia.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.referencia.JD_RegistoCierre.11
            public void actionPerformed(ActionEvent evt) {
                JD_RegistoCierre.this.JRB_TAmbulanciaActionPerformed(evt);
            }
        });
        this.JBG_TipoVehiculo.add(this.JRB_TParticular);
        this.JRB_TParticular.setFont(new Font("Arial", 1, 12));
        this.JRB_TParticular.setText("Particular");
        this.JBG_TipoVehiculo.add(this.JRB_TAmbulanciaMedicalizada);
        this.JRB_TAmbulanciaMedicalizada.setFont(new Font("Arial", 1, 12));
        this.JRB_TAmbulanciaMedicalizada.setText("Ambulancia medicalizada");
        this.JRB_TAmbulanciaMedicalizada.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.referencia.JD_RegistoCierre.12
            public void actionPerformed(ActionEvent evt) {
                JD_RegistoCierre.this.JRB_TAmbulanciaMedicalizadaActionPerformed(evt);
            }
        });
        GroupLayout JPI_TipoVehiculoLayout = new GroupLayout(this.JPI_TipoVehiculo);
        this.JPI_TipoVehiculo.setLayout(JPI_TipoVehiculoLayout);
        JPI_TipoVehiculoLayout.setHorizontalGroup(JPI_TipoVehiculoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_TipoVehiculoLayout.createSequentialGroup().addComponent(this.JRB_TAmbulancia).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRB_TAmbulanciaMedicalizada).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRB_TParticular).addGap(0, 62, 32767)));
        JPI_TipoVehiculoLayout.setVerticalGroup(JPI_TipoVehiculoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_TipoVehiculoLayout.createSequentialGroup().addGroup(JPI_TipoVehiculoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRB_TAmbulancia).addComponent(this.JRB_TParticular).addComponent(this.JRB_TAmbulanciaMedicalizada)).addGap(0, 12, 32767)));
        this.JCBAmbulancia.setFont(new Font("Arial", 1, 12));
        this.JCBAmbulancia.setBorder(BorderFactory.createTitledBorder((Border) null, "Ambulancia", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBAmbulancia.addItemListener(new ItemListener() { // from class: com.genoma.plus.controller.referencia.JD_RegistoCierre.13
            public void itemStateChanged(ItemEvent evt) {
                JD_RegistoCierre.this.JCBAmbulanciaItemStateChanged(evt);
            }
        });
        this.JTFMedicoAmbulancia.setFont(new Font("Arial", 1, 12));
        this.JTFMedicoAmbulancia.setBorder(BorderFactory.createTitledBorder((Border) null, "Médico", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFMedicoAmbulancia.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.referencia.JD_RegistoCierre.14
            public void mouseClicked(MouseEvent evt) {
                JD_RegistoCierre.this.JTFMedicoAmbulanciaMouseClicked(evt);
            }
        });
        this.JTFEnfermeraAmbulanciaCedula.setFont(new Font("Arial", 1, 12));
        this.JTFEnfermeraAmbulanciaCedula.setBorder(BorderFactory.createTitledBorder((Border) null, "Identificación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFConductorCedula.setFont(new Font("Arial", 1, 12));
        this.JTFConductorCedula.setBorder(BorderFactory.createTitledBorder((Border) null, "Identificación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPI_InformacionAmbulaciaLayout = new GroupLayout(this.JPI_InformacionAmbulacia);
        this.JPI_InformacionAmbulacia.setLayout(JPI_InformacionAmbulaciaLayout);
        JPI_InformacionAmbulaciaLayout.setHorizontalGroup(JPI_InformacionAmbulaciaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPI_InformacionAmbulaciaLayout.createSequentialGroup().addGroup(JPI_InformacionAmbulaciaLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPI_InformacionAmbulaciaLayout.createSequentialGroup().addComponent(this.JPI_FechaAceptacion, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPI_FechaSalida, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPI_FechaLlegada, -2, -1, -2).addGap(18, 18, 18).addComponent(this.JCBAmbulancia, 0, 267, 32767)).addGroup(GroupLayout.Alignment.LEADING, JPI_InformacionAmbulaciaLayout.createSequentialGroup().addContainerGap().addGroup(JPI_InformacionAmbulaciaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFMedicoAmbulanciaCedula, -2, 149, -2).addComponent(this.JTFConductorCedula, -2, 149, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPI_InformacionAmbulaciaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFMedicoAmbulancia).addComponent(this.JTFConductor)).addGroup(JPI_InformacionAmbulaciaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_InformacionAmbulaciaLayout.createSequentialGroup().addGap(5, 5, 5).addComponent(this.JTFEnfermeraAmbulanciaCedula, -2, 149, -2).addGap(5, 5, 5).addComponent(this.JTFEnfermeraAmbulancia, -2, 409, -2)).addGroup(JPI_InformacionAmbulaciaLayout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JPI_TipoVehiculo, -2, -1, -2))))).addGap(10, 10, 10)));
        JPI_InformacionAmbulaciaLayout.setVerticalGroup(JPI_InformacionAmbulaciaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_InformacionAmbulaciaLayout.createSequentialGroup().addGroup(JPI_InformacionAmbulaciaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_InformacionAmbulaciaLayout.createSequentialGroup().addGroup(JPI_InformacionAmbulaciaLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPI_InformacionAmbulaciaLayout.createSequentialGroup().addContainerGap().addGroup(JPI_InformacionAmbulaciaLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JPI_FechaAceptacion, -2, -1, -2).addComponent(this.JPI_FechaLlegada, -2, -1, -2))).addGroup(JPI_InformacionAmbulaciaLayout.createSequentialGroup().addGap(8, 8, 8).addComponent(this.JPI_FechaSalida, -2, 0, 32767))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)).addGroup(GroupLayout.Alignment.TRAILING, JPI_InformacionAmbulaciaLayout.createSequentialGroup().addComponent(this.JCBAmbulancia, -2, 50, -2).addGap(16, 16, 16))).addGroup(JPI_InformacionAmbulaciaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_InformacionAmbulaciaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFEnfermeraAmbulancia, -2, 50, -2).addComponent(this.JTFEnfermeraAmbulanciaCedula, -2, 50, -2)).addGroup(JPI_InformacionAmbulaciaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFMedicoAmbulanciaCedula, -2, 50, -2).addComponent(this.JTFMedicoAmbulancia, -2, 50, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPI_InformacionAmbulaciaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_InformacionAmbulaciaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFConductor, -2, 50, -2).addComponent(this.JTFConductorCedula, -2, 50, -2)).addComponent(this.JPI_TipoVehiculo, -2, -1, -2)).addGap(28, 28, 28)));
        this.JTB_DatosReferencia.addTab("INFORMACIÓN AMBULANCIA", this.JPI_InformacionAmbulacia);
        this.JBGuardar1.setFont(new Font("Arial", 1, 12));
        this.JBGuardar1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Imprimir.png")));
        this.JBGuardar1.setText("Imprimir");
        this.JBGuardar1.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.referencia.JD_RegistoCierre.15
            public void actionPerformed(ActionEvent evt) {
                JD_RegistoCierre.this.JBGuardar1ActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(5, 5, 5).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(layout.createSequentialGroup().addComponent(this.JTB_DatosReferencia, -2, 1063, -2).addGap(5, 5, 5)).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPI_DatosRegistro, -1, -1, 32767).addGroup(layout.createSequentialGroup().addComponent(this.JBNuevo, -2, 240, -2).addGap(27, 27, 27).addComponent(this.JBGuardar, -2, 240, -2).addGap(30, 30, 30).addComponent(this.JBGuardar1, -2, 240, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JBT_Salir, -2, 240, -2))).addContainerGap()))));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(16, 16, 16).addComponent(this.JPI_DatosRegistro, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTB_DatosReferencia, -2, 255, -2).addGap(5, 5, 5).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBT_Salir, -2, 50, -2).addComponent(this.JBNuevo, -2, 50, -2).addComponent(this.JBGuardar, -2, 50, -2).addComponent(this.JBGuardar1, -2, 50, -2)).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBNuevoActionPerformed(ActionEvent evt) {
        nuevo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_SalirActionPerformed(ActionEvent evt) {
        dispose();
    }

    private void nuevo() {
        this.lleno = false;
        this.idAmbulancia = 0;
        this.JLB_IdCierre.setText("");
        this.JDFechaC.setDate(this.metodos.getFechaActualPC());
        this.JTFHora.setValue(this.metodos.getFechaActual());
        this.JTAObservacion.setText("");
        this.JRB_TAmbulancia.setSelected(true);
        this.remisionesDTO = new RemisionesDTO();
        this.f25JTFAcompaanteTelefono.setText("");
        this.JTFEnfermeraAmbulanciaCedula.setText("");
        this.JTFMedicoAmbulanciaCedula.setText("");
        this.f24JTFAcompaante.setText("");
        this.JTFConductorCedula.setText("");
        this.municipioDTOs = this.municipioService.listaMunicipioPorEstado(false);
        this.JCBMunicipio.removeAllItems();
        this.municipioDTOs.forEach(municipioDTO -> {
            this.JCBMunicipio.addItem(municipioDTO.getNombre());
        });
        this.JCBMunicipio.setSelectedIndex(-1);
        this.ambulancia = this.ambulanciaService.listaAmbualanciaEstado(true);
        this.JCBAmbulancia.removeAllItems();
        this.ambulancia.forEach(GAmbulancia -> {
            this.JCBAmbulancia.addItem(GAmbulancia.getPlaca());
        });
        this.remisionesCierreDTO = this.remisionesCierreService.cierrePorIdRemision(this.idRemision);
        this.remisionesDTO = this.remisionesService.remisionPorId(this.idRemision);
        System.err.println("remisionesDTO.getIdMunicipio()" + this.remisionesDTO.getIdMunicipio());
        Optional<IRemisionCierre> remisionCierre = this.remisionesCierreService.datosCierreRemisionPorIdRemision(this.idRemision);
        this.JCBAmbulancia.setSelectedIndex(-1);
        if (remisionCierre.isPresent()) {
            this.JDFechaC.setDate(this.metodos.getPasarTextoAFecha(remisionCierre.get().getFecha()));
            this.JTFHora.setText(remisionCierre.get().getHora());
            if (this.JTAObservacion != null) {
                this.JTAObservacion.setText(remisionCierre.get().getDescripcion());
                System.out.println("area" + remisionCierre.get().getDescripcion());
            }
            this.JLB_ResponsableCierre.setText(remisionCierre.get().getProfesionalEspecialidad());
            this.JLB_IdCierre.setText("" + remisionCierre.get().getId());
        } else {
            this.JDC_AFecha.setDate(this.metodos.getFechaActualPC());
            this.JTFF_AHora.setValue(this.metodos.getFechaActual());
            this.JTFF_SHora.setValue(this.metodos.getFechaActual());
            this.JTFF_LHora.setValue(this.metodos.getFechaActual());
        }
        if (this.remisionesDTO != null) {
            this.JTFInstirucionRecibe.setText(this.remisionesDTO.getInstitucionRecibe());
            this.JTFCHabitacion.setText(this.remisionesDTO.getCodigoHabilitacion());
            this.JTFProfesionalRecibe.setText(this.remisionesDTO.getMedicosRecibe());
            this.JTFProfesion.setText(this.remisionesDTO.getProfesionProfesional());
            this.JTADRObservaciones.setText(this.remisionesDTO.getObservacionesRemision());
            this.JCH_Aceptado.setSelected(this.remisionesDTO.getAceptado().booleanValue());
            this.f25JTFAcompaanteTelefono.setText(this.remisionesDTO.getTelefonoAcompanante());
            this.JTFEnfermeraAmbulanciaCedula.setText(this.remisionesDTO.getIdentificacionEnfermera());
            this.JTFMedicoAmbulanciaCedula.setText(this.remisionesDTO.getIdentificacionMedico());
            this.f24JTFAcompaante.setText(this.remisionesDTO.getNombreAcompanante());
            this.JTFConductorCedula.setText(this.remisionesDTO.getIdentificacionConductor());
            System.out.println("" + this.remisionesDTO.getAceptado());
            if (this.remisionesDTO.getFechaUbicacion() != null) {
                System.out.println("Hora de Ubicacion " + this.remisionesDTO.getFechaUbicacion());
                this.JDC_AFecha.setDate(this.metodos.getPasarTextoaFecha(this.remisionesDTO.getFechaUbicacion().substring(0, 10)));
                this.JTFF_AHora.setText(this.remisionesDTO.getFechaUbicacion().substring(11, 19));
            }
            if (this.remisionesDTO.getFechaLlegada() != null) {
                System.out.println("Hora de llegada " + this.remisionesDTO.getFechaLlegada());
                this.JDC_LFecha.setDate(this.metodos.getPasarTextoaFecha(this.remisionesDTO.getFechaLlegada().substring(0, 10)));
                this.JTFF_LHora.setText(this.remisionesDTO.getFechaLlegada().substring(11, 19));
            }
            if (this.remisionesDTO.getFechaSalida() != null) {
                System.out.println("Hora de Salida " + this.remisionesDTO.getFechaSalida());
                this.JDC_SFecha.setDate(this.metodos.getPasarTextoaFecha(this.remisionesDTO.getFechaSalida().substring(0, 10)));
                this.JTFF_SHora.setText(this.remisionesDTO.getFechaSalida().substring(11, 19));
            }
            this.JTFMedicoAmbulancia.setText(this.remisionesDTO.getMedicoAcompania());
            this.JTFEnfermeraAmbulancia.setText(this.remisionesDTO.getNombreAuxEnfermeria());
            this.JTFConductor.setText(this.remisionesDTO.getConductor());
            if (null == this.remisionesDTO.getAmbulancia()) {
                this.JRB_TParticular.setSelected(true);
            } else {
                switch (this.remisionesDTO.getAmbulancia().intValue()) {
                    case 1:
                        this.JRB_TAmbulancia.setSelected(true);
                        break;
                    case 2:
                        this.JRB_TAmbulanciaMedicalizada.setSelected(true);
                        break;
                    default:
                        this.JRB_TParticular.setSelected(true);
                        break;
                }
            }
            Iterator<MunicipioDTO> it = this.municipioDTOs.iterator();
            while (true) {
                if (it.hasNext()) {
                    MunicipioDTO next = it.next();
                    System.err.println("remisionesDTO.getIdMunicipio()" + this.remisionesDTO.getIdMunicipio());
                    if (next.getId().equals(this.remisionesDTO.getIdMunicipio())) {
                        this.JCBMunicipio.setSelectedItem(next.getNombre());
                        this.idMunicipio = next.getId();
                    }
                }
            }
            Iterator<GAmbulancia> it2 = this.ambulancia.iterator();
            while (true) {
                if (it2.hasNext()) {
                    GAmbulancia nextA = it2.next();
                    System.err.println("remisionesDTO.getIdAmbulancia antes" + this.remisionesDTO.getIdAmbulancia());
                    if (nextA.getId().equals(this.remisionesDTO.getIdAmbulancia())) {
                        System.err.println("remisionesDTO.getIdAmbulancia()" + this.remisionesDTO.getIdAmbulancia());
                        this.idAmbulancia = nextA.getId();
                        this.JCBAmbulancia.setSelectedItem(nextA.getPlaca());
                    }
                }
            }
        }
        this.JDFechaC.requestFocus();
        this.lleno = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBGuardarActionPerformed(ActionEvent evt) {
        if (!this.JTAObservacion.getText().isEmpty()) {
            int x = JOptionPane.showConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                RemisionesCierreDTO remisionesCierreDTO = new RemisionesCierreDTO();
                if (!this.JLB_IdCierre.getText().isEmpty()) {
                    remisionesCierreDTO.setId(Long.valueOf(Long.parseLong(this.JLB_IdCierre.getText())));
                }
                remisionesCierreDTO.setIdRemision(this.idRemision);
                remisionesCierreDTO.setFechaHora(this.metodos.formatoAMD.format(this.JDFechaC.getDate()) + " " + this.metodos.formatoH24.format(this.JTFHora.getValue()));
                remisionesCierreDTO.setDescripcion(this.JTAObservacion.getText());
                remisionesCierreDTO.setEstado(true);
                remisionesCierreDTO.setIdEspecialidad(Principal.informacionGeneralPrincipalDTO.getIdEspecialidad());
                remisionesCierreDTO.setIdProfesional(Principal.usuarioSistemaDTO.getIdUsuarioSistema());
                remisionesCierreDTO.setIdUsuarioRh(Principal.usuarioSistemaDTO.getIdPersonaCargo());
                remisionesCierreDTO.setFecha(this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()));
                this.remisionesCierreService.save(remisionesCierreDTO);
                this.remisionesDTO.setAceptado(Boolean.valueOf(this.JCH_Aceptado.isSelected()));
                this.remisionesDTO.setCodigoHabilitacion(this.JTFCHabitacion.getText());
                this.remisionesDTO.setConductor(this.JTFConductor.getText());
                if (this.JDC_AFecha.getDate() != null && !this.JTFF_AHora.getText().isEmpty()) {
                    this.remisionesDTO.setFechaAceptado(this.metodos.formatoAMD.format(this.JDC_AFecha.getDate()));
                    this.remisionesDTO.setHoraAceptado(this.JTFF_AHora.getText());
                    this.remisionesDTO.setFechaUbicacion(this.metodos.formatoAMD.format(this.JDC_AFecha.getDate()) + " " + this.JTFF_AHora.getText());
                }
                if (this.JDC_LFecha.getDate() != null && !this.JTFF_LHora.getText().isEmpty()) {
                    this.remisionesDTO.setFechaLlegada(this.metodos.formatoAMD.format(this.JDC_LFecha.getDate()) + " " + this.JTFF_LHora.getText());
                }
                if (this.JDC_SFecha.getDate() != null && !this.JTFF_SHora.getText().isEmpty()) {
                    this.remisionesDTO.setFechaSalida(this.metodos.formatoAMD.format(this.JDC_SFecha.getDate()) + " " + this.JTFF_SHora.getText());
                }
                System.err.println("idMunicipioxxxx " + this.idMunicipio);
                this.remisionesDTO.setIdMunicipio(this.idMunicipio);
                this.remisionesDTO.setInstitucionRecibe(this.JTFInstirucionRecibe.getText());
                this.remisionesDTO.setProfesionProfesional(this.JTFProfesion.getText());
                this.remisionesDTO.setMedicoAcompania(this.JTFMedicoAmbulancia.getText());
                this.remisionesDTO.setMedicosRecibe(this.JTFProfesionalRecibe.getText());
                this.remisionesDTO.setNombreAuxEnfermeria(this.JTFEnfermeraAmbulancia.getText());
                this.remisionesDTO.setObservacionesRemision(this.JTADRObservaciones.getText());
                this.remisionesDTO.setTelefonoAcompanante(this.f25JTFAcompaanteTelefono.getText());
                this.remisionesDTO.setIdentificacionConductor(this.JTFConductorCedula.getText());
                this.remisionesDTO.setIdentificacionEnfermera(this.JTFEnfermeraAmbulanciaCedula.getText());
                this.remisionesDTO.setIdentificacionMedico(this.JTFMedicoAmbulanciaCedula.getText());
                this.remisionesDTO.setNombreAcompanante(this.f24JTFAcompaante.getText());
                this.remisionesDTO.setIdAmbulancia(this.idAmbulancia);
                this.remisionesDTO.setPlacaAmbulancia(this.nombreAmbulancia);
                if (this.JRB_TAmbulancia.isSelected()) {
                    this.remisionesDTO.setAmbulancia(1);
                } else if (this.JRB_TAmbulanciaMedicalizada.isSelected()) {
                    this.remisionesDTO.setAmbulancia(2);
                } else {
                    this.remisionesDTO.setAmbulancia(0);
                }
                this.remisionesService.save(this.remisionesDTO);
                nuevo();
                return;
            }
            return;
        }
        JOptionPane.showMessageDialog(this, "La observación no puede ser nula", " VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTAObservacion.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBMunicipioItemStateChanged(ItemEvent evt) {
        if (this.lleno.booleanValue()) {
            this.idMunicipio = this.municipioDTOs.get(this.JCBMunicipio.getSelectedIndex()).getId();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFInstirucionRecibeMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JDEmpresaQueRecibe xJDEmpresaQueResibe = new JDEmpresaQueRecibe((Frame) null, true, this, "buscarEmpresaCierre");
            xJDEmpresaQueResibe.setVisible(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCHabitacionActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBAmbulanciaItemStateChanged(ItemEvent evt) {
        if (this.lleno.booleanValue()) {
            this.idAmbulancia = this.ambulancia.get(this.JCBAmbulancia.getSelectedIndex()).getId();
            this.nombreAmbulancia = this.ambulancia.get(this.JCBAmbulancia.getSelectedIndex()).getPlaca();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFF_AHoraActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_TAmbulanciaMedicalizadaActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBGuardar1ActionPerformed(ActionEvent evt) {
        imprimirHojaTraslado();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_TAmbulanciaActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFConductorActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFConductorMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2 && this.JLB_IdCierre.getText().isEmpty()) {
            JDEmpresaQueRecibe xJDEmpresaQueResibe = new JDEmpresaQueRecibe((Frame) null, true, this, "JTFConductor");
            xJDEmpresaQueResibe.setVisible(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFEnfermeraAmbulanciaMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2 && this.JLB_IdCierre.getText().isEmpty()) {
            JDEmpresaQueRecibe xJDEmpresaQueResibe = new JDEmpresaQueRecibe((Frame) null, true, this, "JTFEnfermeria");
            xJDEmpresaQueResibe.setVisible(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFMedicoAmbulanciaMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2 && this.JLB_IdCierre.getText().isEmpty()) {
            JDEmpresaQueRecibe xJDEmpresaQueResibe = new JDEmpresaQueRecibe((Frame) null, true, this, "JTFProfesional");
            xJDEmpresaQueResibe.setVisible(true);
        }
    }

    public void imprimirHojaTraslado() {
        String[][] mparametros = new String[3][2];
        mparametros[0][0] = "idremision";
        mparametros[0][1] = String.valueOf(this.idRemision);
        mparametros[1][0] = "SUBREPORT_DIR";
        mparametros[1][1] = this.metodos.getSO() + this.metodos.getBarra() + "Reportes" + this.metodos.getBarra();
        mparametros[2][0] = "SUBREPORTFIRMA_DIR";
        mparametros[2][1] = this.metodos.getSO() + this.metodos.getBarra() + "Firmas" + this.metodos.getBarra();
        this.metodos.GenerarPDF(this.metodos.getRutaRep() + "Pajonal_HojaTrasladoAsistencial", mparametros, "Pajonal_HojaTrasladoAsistencial");
        this.metodos.GenerarPDF(this.metodos.getRutaRep() + "Pajonal_HojaTrasladoAsistencial_Detalle", mparametros, "Pajonal_HojaTrasladoAsistencial_Detalle");
    }
}
