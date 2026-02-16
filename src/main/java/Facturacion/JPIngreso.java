package Facturacion;

import Acceso.Principal;
import General.JIFBuscarPatologia;
import Utilidades.ConsultasMySQL;
import Utilidades.LlenarCombosGenericos;
import Utilidades.Metodos;
import com.genoma.plus.dao.facturacion.LiquidacionOrdenesServicioDAO;
import com.genoma.plus.dao.impl.facturacion.LiquidacionOrdenesServiciosDAOImpl;
import com.genoma.plus.jpa.entities.GEntornoAtencion;
import com.genoma.plus.jpa.entities.GModalidadatencion;
import com.genoma.plus.jpa.projection.IConsultarNumeroAutorizacionIngreso;
import com.genoma.plus.jpa.service.IngresoService;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.LayoutManager;
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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.text.DateFormatter;
import javax.swing.text.DefaultFormatterFactory;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:Facturacion/JPIngreso.class */
public class JPIngreso extends JPanel {
    public int prueba;
    public String[] xidTipoAtencion;
    public String[] xIdSede;
    public String[] xidescolaridad;
    public String[] xidocupaciones;
    public String[] xidEspecialidad;
    public String[] xidProfesional;
    public String[] xidContrato;
    public String[] xidOIngreso;
    public String[] xidParentezco;
    public String[][] xidestrato;
    public String[][] xidEmpresaFact;
    public String[][] xidTipoAfiliado;
    public String[][] xidTipoContratacion;
    public String[][] xidTipoCobertura;
    public String[][] xidCausaExt;
    private ConsultasMySQL xconsulta;
    private int cboLleno;
    public int xcopago;
    private boolean xlleno;
    private Metodos xmetodo;
    private JIFLiqServicios xliq;
    private boolean xlleno2;
    private int xCondiVict;
    public String[] xidCondVict;
    public String[] xidtAcomp;
    public String[] xidtRespo;
    private JPEventoECat xJPEventoECat;
    private final IngresoService ingresoService;
    private LiquidacionOrdenesServicioDAO liquidacionOrdenesServiciosDAO;
    public List<GModalidadatencion> listGModalidadatencions;
    private List<GEntornoAtencion> listGEntornoAtencions;
    private JButton JBFurip;
    private ButtonGroup JBGTipoEstrato;
    public JComboBox JCBCausaExterna;
    public JComboBox JCBCondVict;
    public JComboBox JCBContrato;
    public JComboBox JCBEmpresaFact;
    public JComboBox JCBEntornoAtencion;
    public JComboBox JCBEscolaridad;
    public JComboBox JCBEspecialidad;
    public JComboBox JCBEstrato;
    public JComboBox JCBModalidadAtencion;
    private JComboBox JCBOcupaciones;
    public JComboBox JCBOrigenIngreso;
    public JComboBox JCBParentezco;
    public JComboBox JCBProfesional;
    public JComboBox JCBSede;
    public JComboBox JCBTipoAfiliado;
    public JComboBox JCBTipoAtencion;
    public JComboBox JCBTipoDocAco;
    public JComboBox JCBTipoDocResp;
    private JComboBox JCB_TipoCoberturaPlan;
    private JComboBox JCB_TipoContratacion;
    public JDateChooser JDFecha;
    private JPanel JPDatosAdicionales;
    private JPanel JPDatosBasicos;
    private JPanel JPTipoCobro;
    public JTextField JTFCie10;
    public JTextField JTFNoDocuAco;
    public JTextField JTFNoDocuResp;
    public JTextField JTFNombreAcomp;
    public JTextField JTFNombreResp;
    public JTextField JTFTelAcomp;
    public JTextField JTFTelResp;
    private JTabbedPane JTPAdicional;
    public JRadioButton btnCModeradora;
    public JRadioButton btnCopago;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    public JFormattedTextField txtHora;
    public JFormattedTextField txtNoAutorizacion;
    public JFormattedTextField txtNoPoliza;
    public JFormattedTextField txtNoSiras;

    public JPIngreso(JIFLiqServicios xliq) {
        this.xconsulta = new ConsultasMySQL();
        this.cboLleno = 0;
        this.xcopago = 0;
        this.xlleno = false;
        this.xmetodo = new Metodos();
        this.xliq = null;
        this.xlleno2 = false;
        this.xCondiVict = 0;
        this.ingresoService = (IngresoService) Principal.contexto.getBean(IngresoService.class);
        initComponents();
        this.xliq = xliq;
        mNuevo();
        if (xliq.xjif_cx != null) {
            this.JCBEmpresaFact.setSelectedItem(xliq.xjif_cx.JCB_Empresa.getSelectedItem());
            this.JCBEspecialidad.setSelectedItem(xliq.xjif_cx.nodos[2].toString());
            this.JCBProfesional.setSelectedItem(xliq.xjif_cx.nodos[3].toString());
            this.txtNoAutorizacion.setText(xliq.xjif_cx.JTF_NAutorizacion.getText());
            if (Principal.informacionIps.getIdentificacion().equals("812003851")) {
                this.JCBTipoAtencion.setSelectedIndex(2);
            } else {
                this.JCBTipoAtencion.setSelectedIndex(1);
            }
            this.JTFCie10.setText(xliq.xjif_cx.JTFFCodigoPat.getText());
            this.JCBCausaExterna.setSelectedIndex(4);
            this.JCBOrigenIngreso.setSelectedIndex(0);
        }
    }

    public JPIngreso() {
        this.xconsulta = new ConsultasMySQL();
        this.cboLleno = 0;
        this.xcopago = 0;
        this.xlleno = false;
        this.xmetodo = new Metodos();
        this.xliq = null;
        this.xlleno2 = false;
        this.xCondiVict = 0;
        this.ingresoService = (IngresoService) Principal.contexto.getBean(IngresoService.class);
        initComponents();
        mNuevo();
        this.JDFecha.setDate(this.xmetodo.getFechaActual());
        this.txtHora.setValue(this.xmetodo.getFechaActual());
        mCargarDatosIngreso();
    }

    private void springStart() {
        this.liquidacionOrdenesServiciosDAO = (LiquidacionOrdenesServiciosDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("liquidacionOrdenesServiciosDAOImpl");
    }

    private void initComponents() {
        this.JBGTipoEstrato = new ButtonGroup();
        this.JPDatosBasicos = new JPanel();
        this.JDFecha = new JDateChooser();
        this.txtHora = new JFormattedTextField();
        this.JCBEmpresaFact = new JComboBox();
        this.JCBTipoAtencion = new JComboBox();
        this.JCBEscolaridad = new JComboBox();
        this.JPTipoCobro = new JPanel();
        this.btnCModeradora = new JRadioButton();
        this.btnCopago = new JRadioButton();
        this.JCBEstrato = new JComboBox();
        this.JCBContrato = new JComboBox();
        this.JCBEspecialidad = new JComboBox();
        this.JCBProfesional = new JComboBox();
        this.JCBOrigenIngreso = new JComboBox();
        this.JCBCausaExterna = new JComboBox();
        this.JCBCondVict = new JComboBox();
        this.JBFurip = new JButton();
        this.JTPAdicional = new JTabbedPane();
        this.JPDatosAdicionales = new JPanel();
        this.txtNoPoliza = new JFormattedTextField();
        this.JCBOcupaciones = new JComboBox();
        this.txtNoAutorizacion = new JFormattedTextField();
        this.JTFCie10 = new JTextField();
        this.jPanel1 = new JPanel();
        this.JTFNombreAcomp = new JTextField();
        this.JTFTelAcomp = new JTextField();
        this.JCBParentezco = new JComboBox();
        this.JCBTipoDocAco = new JComboBox();
        this.JTFNoDocuAco = new JTextField();
        this.jPanel3 = new JPanel();
        this.JTFNombreResp = new JTextField();
        this.JTFTelResp = new JTextField();
        this.JCBTipoDocResp = new JComboBox();
        this.JTFNoDocuResp = new JTextField();
        this.JCBSede = new JComboBox();
        this.txtNoSiras = new JFormattedTextField();
        this.jPanel2 = new JPanel();
        this.JCBTipoAfiliado = new JComboBox();
        this.JCB_TipoContratacion = new JComboBox();
        this.JCB_TipoCoberturaPlan = new JComboBox();
        this.JCBModalidadAtencion = new JComboBox();
        this.JCBEntornoAtencion = new JComboBox();
        setName("jpingresoN");
        this.JPDatosBasicos.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS BÁSICOS", 2, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.JPDatosBasicos.setMaximumSize(new Dimension(813, 233));
        this.JPDatosBasicos.setMinimumSize(new Dimension(813, 233));
        this.JPDatosBasicos.setPreferredSize(new Dimension(813, 233));
        this.JPDatosBasicos.setLayout(new AbsoluteLayout());
        this.JDFecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFecha.setDateFormatString("dd/MM/yyyy");
        this.JDFecha.setFont(new Font("Tahoma", 1, 12));
        this.JDFecha.addKeyListener(new KeyAdapter() { // from class: Facturacion.JPIngreso.1
            public void keyPressed(KeyEvent evt) {
                JPIngreso.this.JDFechaKeyPressed(evt);
            }
        });
        this.JPDatosBasicos.add(this.JDFecha, new AbsoluteConstraints(5, 21, 122, 50));
        this.txtHora.setBorder(BorderFactory.createTitledBorder((Border) null, "Hora", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtHora.setFormatterFactory(new DefaultFormatterFactory(new DateFormatter(new SimpleDateFormat("HH:mm:ss"))));
        this.txtHora.setFont(new Font("Tahoma", 1, 12));
        this.txtHora.addKeyListener(new KeyAdapter() { // from class: Facturacion.JPIngreso.2
            public void keyPressed(KeyEvent evt) {
                JPIngreso.this.txtHoraKeyPressed(evt);
            }
        });
        this.JPDatosBasicos.add(this.txtHora, new AbsoluteConstraints(133, 31, 90, 40));
        this.JCBEmpresaFact.setFont(new Font("Arial", 1, 12));
        this.JCBEmpresaFact.setBorder(BorderFactory.createTitledBorder((Border) null, "Empresa a Facturar", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JCBEmpresaFact.addItemListener(new ItemListener() { // from class: Facturacion.JPIngreso.3
            public void itemStateChanged(ItemEvent evt) {
                JPIngreso.this.JCBEmpresaFactItemStateChanged(evt);
            }
        });
        this.JCBEmpresaFact.addActionListener(new ActionListener() { // from class: Facturacion.JPIngreso.4
            public void actionPerformed(ActionEvent evt) {
                JPIngreso.this.JCBEmpresaFactActionPerformed(evt);
            }
        });
        this.JPDatosBasicos.add(this.JCBEmpresaFact, new AbsoluteConstraints(229, 32, 349, -1));
        this.JCBTipoAtencion.setFont(new Font("Arial", 1, 12));
        this.JCBTipoAtencion.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de Atención", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JCBTipoAtencion.addItemListener(new ItemListener() { // from class: Facturacion.JPIngreso.5
            public void itemStateChanged(ItemEvent evt) {
                JPIngreso.this.JCBTipoAtencionItemStateChanged(evt);
            }
        });
        this.JPDatosBasicos.add(this.JCBTipoAtencion, new AbsoluteConstraints(584, 32, 240, -1));
        this.JCBEscolaridad.setFont(new Font("Arial", 1, 12));
        this.JCBEscolaridad.setBorder(BorderFactory.createTitledBorder((Border) null, "Escolaridad", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JPDatosBasicos.add(this.JCBEscolaridad, new AbsoluteConstraints(8, 85, 268, -1));
        this.JPTipoCobro.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de Cobro", 0, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.JPTipoCobro.setLayout((LayoutManager) null);
        this.JBGTipoEstrato.add(this.btnCModeradora);
        this.btnCModeradora.setFont(new Font("Arial", 1, 12));
        this.btnCModeradora.setForeground(new Color(0, 0, 255));
        this.btnCModeradora.setSelected(true);
        this.btnCModeradora.setText("C. Moderadora");
        this.btnCModeradora.addActionListener(new ActionListener() { // from class: Facturacion.JPIngreso.6
            public void actionPerformed(ActionEvent evt) {
                JPIngreso.this.btnCModeradoraActionPerformed(evt);
            }
        });
        this.JPTipoCobro.add(this.btnCModeradora);
        this.btnCModeradora.setBounds(10, 20, 110, 19);
        this.JBGTipoEstrato.add(this.btnCopago);
        this.btnCopago.setFont(new Font("Arial", 1, 12));
        this.btnCopago.setForeground(new Color(0, 0, 255));
        this.btnCopago.setText("Copago");
        this.btnCopago.addActionListener(new ActionListener() { // from class: Facturacion.JPIngreso.7
            public void actionPerformed(ActionEvent evt) {
                JPIngreso.this.btnCopagoActionPerformed(evt);
            }
        });
        this.JPTipoCobro.add(this.btnCopago);
        this.btnCopago.setBounds(130, 20, 70, 19);
        this.JPDatosBasicos.add(this.JPTipoCobro, new AbsoluteConstraints(282, 76, 204, 48));
        this.JCBEstrato.setFont(new Font("Arial", 1, 12));
        this.JCBEstrato.setBorder(BorderFactory.createTitledBorder((Border) null, "Estrato", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JPDatosBasicos.add(this.JCBEstrato, new AbsoluteConstraints(492, 85, 145, -1));
        this.JCBContrato.setFont(new Font("Arial", 1, 12));
        this.JCBContrato.setBorder(BorderFactory.createTitledBorder((Border) null, "Contrato", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JPDatosBasicos.add(this.JCBContrato, new AbsoluteConstraints(643, 85, 176, -1));
        this.JCBEspecialidad.setFont(new Font("Arial", 1, 12));
        this.JCBEspecialidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Especialidad", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JCBEspecialidad.addItemListener(new ItemListener() { // from class: Facturacion.JPIngreso.8
            public void itemStateChanged(ItemEvent evt) {
                JPIngreso.this.JCBEspecialidadItemStateChanged(evt);
            }
        });
        this.JPDatosBasicos.add(this.JCBEspecialidad, new AbsoluteConstraints(8, 129, 268, -1));
        this.JCBProfesional.setFont(new Font("Arial", 1, 12));
        this.JCBProfesional.setBorder(BorderFactory.createTitledBorder((Border) null, "Profesional", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JPDatosBasicos.add(this.JCBProfesional, new AbsoluteConstraints(282, 129, 537, -1));
        this.JCBOrigenIngreso.setFont(new Font("Arial", 1, 12));
        this.JCBOrigenIngreso.setBorder(BorderFactory.createTitledBorder((Border) null, "Origen de Ingreso", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JPDatosBasicos.add(this.JCBOrigenIngreso, new AbsoluteConstraints(8, 173, 268, -1));
        this.JCBCausaExterna.setFont(new Font("Arial", 1, 12));
        this.JCBCausaExterna.setBorder(BorderFactory.createTitledBorder((Border) null, "Causa Externa", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JCBCausaExterna.addItemListener(new ItemListener() { // from class: Facturacion.JPIngreso.9
            public void itemStateChanged(ItemEvent evt) {
                JPIngreso.this.JCBCausaExternaItemStateChanged(evt);
            }
        });
        this.JCBCausaExterna.addActionListener(new ActionListener() { // from class: Facturacion.JPIngreso.10
            public void actionPerformed(ActionEvent evt) {
                JPIngreso.this.JCBCausaExternaActionPerformed(evt);
            }
        });
        this.JPDatosBasicos.add(this.JCBCausaExterna, new AbsoluteConstraints(282, 173, 318, -1));
        this.JCBCondVict.setFont(new Font("Arial", 1, 12));
        this.JCBCondVict.setBorder(BorderFactory.createTitledBorder((Border) null, "Condición Victima", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBCondVict.setEnabled(false);
        this.JCBCondVict.addItemListener(new ItemListener() { // from class: Facturacion.JPIngreso.11
            public void itemStateChanged(ItemEvent evt) {
                JPIngreso.this.JCBCondVictItemStateChanged(evt);
            }
        });
        this.JPDatosBasicos.add(this.JCBCondVict, new AbsoluteConstraints(674, 173, 145, -1));
        this.JBFurip.setIcon(new ImageIcon(getClass().getResource("/Imagenes/HojaLapiz29x27.png")));
        this.JBFurip.setToolTipText("FURIPS");
        this.JBFurip.addActionListener(new ActionListener() { // from class: Facturacion.JPIngreso.12
            public void actionPerformed(ActionEvent evt) {
                JPIngreso.this.JBFuripActionPerformed(evt);
            }
        });
        this.JPDatosBasicos.add(this.JBFurip, new AbsoluteConstraints(614, 173, 48, 43));
        this.JTPAdicional.setForeground(new Color(0, 103, 0));
        this.JTPAdicional.setFont(new Font("Arial", 1, 14));
        this.JPDatosAdicionales.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS ADICIONALES", 2, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.JPDatosAdicionales.setMaximumSize(new Dimension(813, 227));
        this.JPDatosAdicionales.setMinimumSize(new Dimension(813, 227));
        this.txtNoPoliza.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Poliza", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtNoPoliza.setFont(new Font("Arial", 1, 12));
        this.JCBOcupaciones.setFont(new Font("Arial", 1, 12));
        this.JCBOcupaciones.setBorder(BorderFactory.createTitledBorder((Border) null, "Ocupaciones (CIUO)", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtNoAutorizacion.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Autorización", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtNoAutorizacion.setFont(new Font("Arial", 1, 12));
        this.txtNoAutorizacion.addFocusListener(new FocusAdapter() { // from class: Facturacion.JPIngreso.13
            public void focusLost(FocusEvent evt) {
                JPIngreso.this.txtNoAutorizacionFocusLost(evt);
            }
        });
        this.txtNoAutorizacion.addActionListener(new ActionListener() { // from class: Facturacion.JPIngreso.14
            public void actionPerformed(ActionEvent evt) {
                JPIngreso.this.txtNoAutorizacionActionPerformed(evt);
            }
        });
        this.txtNoAutorizacion.addKeyListener(new KeyAdapter() { // from class: Facturacion.JPIngreso.15
            public void keyPressed(KeyEvent evt) {
                JPIngreso.this.txtNoAutorizacionKeyPressed(evt);
            }
        });
        this.JTFCie10.setFont(new Font("Arial", 1, 12));
        this.JTFCie10.setHorizontalAlignment(4);
        this.JTFCie10.setText("0000");
        this.JTFCie10.setBorder(BorderFactory.createTitledBorder((Border) null, "Cie 10", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFCie10.addMouseListener(new MouseAdapter() { // from class: Facturacion.JPIngreso.16
            public void mouseClicked(MouseEvent evt) {
                JPIngreso.this.JTFCie10MouseClicked(evt);
            }
        });
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS DEL ACOMPAÑANTE", 2, 0, new Font("Arial", 1, 12), new Color(0, 102, 0)));
        this.JTFNombreAcomp.setFont(new Font("Arial", 1, 12));
        this.JTFNombreAcomp.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFTelAcomp.setFont(new Font("Arial", 1, 12));
        this.JTFTelAcomp.setBorder(BorderFactory.createTitledBorder((Border) null, "Teléfono", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBParentezco.setFont(new Font("Arial", 1, 12));
        this.JCBParentezco.setBorder(BorderFactory.createTitledBorder((Border) null, "Parentesco", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JCBTipoDocAco.setFont(new Font("Arial", 1, 12));
        this.JCBTipoDocAco.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Documento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNoDocuAco.setFont(new Font("Arial", 1, 12));
        this.JTFNoDocuAco.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Documento", 1, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(3, 3, 3).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFNombreAcomp).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBTipoDocAco, -2, 172, -2).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JCBParentezco, -2, 221, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFTelAcomp, -2, 122, -2))).addGap(0, 7, 32767))).addContainerGap()).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(188, 188, 188).addComponent(this.JTFNoDocuAco, -2, 170, -2).addContainerGap(-1, 32767))));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(5, 5, 5).addComponent(this.JTFNombreAcomp, -2, 47, -2).addGap(3, 3, 3).addComponent(this.JCBTipoDocAco, -2, -1, -2).addGap(3, 3, 3).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBParentezco, -2, -1, -2).addComponent(this.JTFTelAcomp, -2, 47, -2))).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(58, 58, 58).addComponent(this.JTFNoDocuAco, -2, -1, -2).addContainerGap(57, 32767))));
        this.jPanel3.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS DEL RESPONSABLE", 2, 0, new Font("Arial", 1, 12), new Color(0, 102, 0)));
        this.JTFNombreResp.setFont(new Font("Arial", 1, 12));
        this.JTFNombreResp.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFTelResp.setFont(new Font("Arial", 1, 12));
        this.JTFTelResp.setBorder(BorderFactory.createTitledBorder((Border) null, "Teléfono", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipoDocResp.setFont(new Font("Arial", 1, 12));
        this.JCBTipoDocResp.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Documento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNoDocuResp.setFont(new Font("Arial", 1, 12));
        this.JTFNoDocuResp.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Documento", 1, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
        this.jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addGap(5, 5, 5).addComponent(this.JTFNombreResp, -2, 265, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFTelResp).addGap(5, 5, 5)).addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup().addContainerGap().addComponent(this.JCBTipoDocResp, -2, 172, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 32, 32767).addComponent(this.JTFNoDocuResp, -2, 170, -2).addContainerGap()));
        jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addGap(5, 5, 5).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFTelResp, -2, 47, -2).addComponent(this.JTFNombreResp, -2, 47, -2)).addGap(3, 3, 3).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFNoDocuResp, -2, -1, -2).addComponent(this.JCBTipoDocResp, -2, -1, -2)).addGap(3, 3, 3)));
        this.JCBSede.setFont(new Font("Arial", 1, 12));
        this.JCBSede.setBorder(BorderFactory.createTitledBorder((Border) null, "Sede", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtNoSiras.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Siras", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtNoSiras.setFont(new Font("Arial", 1, 12));
        this.txtNoSiras.addFocusListener(new FocusAdapter() { // from class: Facturacion.JPIngreso.17
            public void focusLost(FocusEvent evt) {
                JPIngreso.this.txtNoSirasFocusLost(evt);
            }
        });
        this.txtNoSiras.addActionListener(new ActionListener() { // from class: Facturacion.JPIngreso.18
            public void actionPerformed(ActionEvent evt) {
                JPIngreso.this.txtNoSirasActionPerformed(evt);
            }
        });
        this.txtNoSiras.addKeyListener(new KeyAdapter() { // from class: Facturacion.JPIngreso.19
            public void keyPressed(KeyEvent evt) {
                JPIngreso.this.txtNoSirasKeyPressed(evt);
            }
        });
        GroupLayout JPDatosAdicionalesLayout = new GroupLayout(this.JPDatosAdicionales);
        this.JPDatosAdicionales.setLayout(JPDatosAdicionalesLayout);
        JPDatosAdicionalesLayout.setHorizontalGroup(JPDatosAdicionalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosAdicionalesLayout.createSequentialGroup().addGap(10, 10, 10).addGroup(JPDatosAdicionalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPDatosAdicionalesLayout.createSequentialGroup().addComponent(this.txtNoPoliza, -2, 108, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBOcupaciones, -2, 483, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBSede, -2, 198, -2)).addGroup(JPDatosAdicionalesLayout.createSequentialGroup().addComponent(this.jPanel1, -2, -1, -2).addGap(18, 18, 18).addGroup(JPDatosAdicionalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPDatosAdicionalesLayout.createSequentialGroup().addComponent(this.txtNoSiras, -2, 135, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.txtNoAutorizacion, -2, 135, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFCie10, -2, 108, -2).addContainerGap()).addComponent(this.jPanel3, -2, -1, -2))))));
        JPDatosAdicionalesLayout.setVerticalGroup(JPDatosAdicionalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosAdicionalesLayout.createSequentialGroup().addGroup(JPDatosAdicionalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPDatosAdicionalesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBOcupaciones, -1, -1, -2).addComponent(this.JCBSede, -2, -1, -2)).addComponent(this.txtNoPoliza, -2, 47, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPDatosAdicionalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosAdicionalesLayout.createSequentialGroup().addComponent(this.jPanel3, -1, -1, 32767).addGap(3, 3, 3).addGroup(JPDatosAdicionalesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFCie10, -2, 50, -2).addComponent(this.txtNoAutorizacion, -2, 50, -2).addComponent(this.txtNoSiras, -2, 50, -2)).addGap(6, 6, 6)).addGroup(JPDatosAdicionalesLayout.createSequentialGroup().addComponent(this.jPanel1, -1, -1, 32767).addContainerGap()))));
        this.JTPAdicional.addTab("ADICIONAL 1", this.JPDatosAdicionales);
        this.JCBTipoAfiliado.setFont(new Font("Arial", 1, 12));
        this.JCBTipoAfiliado.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de Afiliacion", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JCB_TipoContratacion.setFont(new Font("Arial", 1, 12));
        this.JCB_TipoContratacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Contratación (Res014-FT025)", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCB_TipoCoberturaPlan.setFont(new Font("Arial", 1, 12));
        this.JCB_TipoCoberturaPlan.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de Plan de Cobertura", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBModalidadAtencion.setFont(new Font("Arial", 1, 12));
        this.JCBModalidadAtencion.setBorder(BorderFactory.createTitledBorder((Border) null, "Modalidad Atención", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JCBModalidadAtencion.setName("modalidadAtencion");
        this.JCBEntornoAtencion.setFont(new Font("Arial", 1, 12));
        this.JCBEntornoAtencion.setBorder(BorderFactory.createTitledBorder((Border) null, "Entorno Atención", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JCBEntornoAtencion.setName("entornoAtencion");
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.JCBTipoAfiliado, -2, 198, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCB_TipoContratacion, -2, 288, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCB_TipoCoberturaPlan, -2, 310, -2)).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.JCBModalidadAtencion, -2, 388, -2).addGap(18, 18, 18).addComponent(this.JCBEntornoAtencion, 0, -1, 32767))).addContainerGap()));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCB_TipoContratacion, -2, 50, -2).addComponent(this.JCB_TipoCoberturaPlan, -2, 50, -2)).addComponent(this.JCBTipoAfiliado)).addGap(18, 18, 18).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBModalidadAtencion, -2, 50, -2).addComponent(this.JCBEntornoAtencion, -2, 50, -2)).addContainerGap()));
        this.JTPAdicional.addTab("ADICIONAL 2", this.jPanel2);
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPDatosBasicos, -1, 852, 32767).addComponent(this.JTPAdicional)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPDatosBasicos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTPAdicional, -1, -1, -2).addContainerGap()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtHoraKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.txtHora.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBEmpresaFactItemStateChanged(ItemEvent evt) {
        llenarEmpresa();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBEmpresaFactActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnCModeradoraActionPerformed(ActionEvent evt) {
        this.xcopago = 0;
        mLlenarComboEstrado();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnCopagoActionPerformed(ActionEvent evt) {
        this.xcopago = 1;
        mLlenarComboEstrado();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTipoAtencionItemStateChanged(ItemEvent evt) {
        if (this.xlleno && this.JCBTipoAtencion.getSelectedIndex() != -1) {
            switch (this.JCBTipoAtencion.getSelectedIndex()) {
                case 1:
                    this.JCBOrigenIngreso.setSelectedIndex(0);
                    break;
                case 2:
                    this.JCBOrigenIngreso.setSelectedIndex(1);
                    break;
                case 3:
                    this.JCBOrigenIngreso.setSelectedIndex(3);
                    break;
                default:
                    this.JCBOrigenIngreso.setSelectedIndex(-1);
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBEspecialidadItemStateChanged(ItemEvent evt) {
        cargarCboProfesional();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCie10MouseClicked(MouseEvent evt) {
        mBuscarPatologiaN(this.JTFCie10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBCondVictItemStateChanged(ItemEvent evt) {
        if (this.xlleno2 && this.JCBCondVict.getSelectedIndex() != -1) {
            this.xCondiVict = Integer.parseInt(this.xidCondVict[this.JCBCondVict.getSelectedIndex()]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBCausaExternaItemStateChanged(ItemEvent evt) {
        if (this.cboLleno == 1) {
            if (this.xidCausaExt[this.JCBCausaExterna.getSelectedIndex()][1].equals("2")) {
                this.JCBCondVict.setEnabled(true);
                this.JCBCondVict.removeAllItems();
                this.xidCondVict = this.xconsulta.llenarCombo("SELECT `Id`  , `Nbre` FROM `a_condvictima` WHERE (`Estado` =0) order by Nbre", this.xidCondVict, this.JCBCondVict);
                this.JCBCondVict.setSelectedIndex(-1);
                this.xconsulta.cerrarConexionBd();
                this.xlleno2 = true;
                return;
            }
            this.JCBCondVict.setEnabled(false);
            this.xCondiVict = 0;
            this.JCBCondVict.removeAllItems();
            this.xlleno2 = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBFuripActionPerformed(ActionEvent evt) {
        if (!this.xliq.JLB_NIngreso.getText().isEmpty()) {
            mVerificaCausaExterna();
        } else {
            JOptionPane.showInternalMessageDialog(this.xliq, "Debe cargar un ingreso", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtNoAutorizacionActionPerformed(ActionEvent evt) {
        if (!this.txtNoAutorizacion.getText().isEmpty() && this.JCBEmpresaFact.getSelectedIndex() != -1) {
            mConsultarNAutorizacion();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtNoAutorizacionFocusLost(FocusEvent evt) {
        if (!this.txtNoAutorizacion.getText().isEmpty() && this.JCBEmpresaFact.getSelectedIndex() != -1) {
            mConsultarNAutorizacion();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtNoAutorizacionKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10 && !this.txtNoAutorizacion.getText().isEmpty() && this.JCBEmpresaFact.getSelectedIndex() != -1) {
            mConsultarNAutorizacion();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtNoSirasFocusLost(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtNoSirasActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtNoSirasKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBCausaExternaActionPerformed(ActionEvent evt) {
    }

    private void mVerificaCausaExterna() {
        if (this.xidCausaExt[this.JCBCausaExterna.getSelectedIndex()][1].equals("2")) {
            if (this.JCBCondVict.getSelectedIndex() != -1) {
                this.xJPEventoECat = new JPEventoECat(null, true, this.xliq.xjppersona.IdPersona, Long.valueOf(this.xidCausaExt[this.JCBCausaExterna.getSelectedIndex()][0]).longValue(), Long.valueOf(this.xidCondVict[this.JCBCondVict.getSelectedIndex()]).longValue(), this.xliq.JLB_NIngreso.getText());
                this.xJPEventoECat.setVisible(true);
                return;
            } else {
                JOptionPane.showInternalMessageDialog(this.xliq, "Debe seleccionar la condición de la víctima", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JCBCausaExterna.requestFocus();
                return;
            }
        }
        JOptionPane.showInternalMessageDialog(this.xliq, "Debe seleccionar como causa externa accidente de transito", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JCBCausaExterna.requestFocus();
    }

    private void llenarEmpresa() {
        System.out.println(" empresa " + this.JCBEmpresaFact.getSelectedIndex());
        System.out.println(" cboLleno  " + this.cboLleno);
        if (this.JCBEmpresaFact.getSelectedIndex() != -1 && this.cboLleno == 1) {
            mLlenarComboEstrado();
            mLlenaComboContrato();
            mLlenarComboTipoAfiliado();
            this.JCB_TipoContratacion.setSelectedItem(getTipoContratacion());
            this.JCB_TipoCoberturaPlan.setSelectedItem(getTipoCobertura());
            this.xliq.setXidempresa(Long.parseLong(this.xidEmpresaFact[this.JCBEmpresaFact.getSelectedIndex()][0]));
            this.xliq.xIdManual = this.xidEmpresaFact[this.JCBEmpresaFact.getSelectedIndex()][1];
            this.xliq.xEsCapitado = this.xidEmpresaFact[this.JCBEmpresaFact.getSelectedIndex()][2];
            this.xliq.xCValor = this.xidEmpresaFact[this.JCBEmpresaFact.getSelectedIndex()][3];
            this.xliq.xFiltroProc = this.xidEmpresaFact[this.JCBEmpresaFact.getSelectedIndex()][5];
            this.xliq.xIdTipoPlan = this.xidEmpresaFact[this.JCBEmpresaFact.getSelectedIndex()][4];
            this.xliq.setxGeneraMovContable(this.xidEmpresaFact[this.JCBEmpresaFact.getSelectedIndex()][12]);
        }
    }

    public void mNuevo() {
        this.cboLleno = 0;
        mCargarCombos();
        this.JDFecha.setDate(this.xmetodo.getFechaActualPC());
        this.txtHora.setValue(this.xmetodo.getFechaActualPC());
        this.JTFNombreAcomp.setText("");
        this.JTFCie10.setText("0000");
        this.JTFNombreResp.setText("");
        this.JTFTelAcomp.setText("");
        this.JTFTelResp.setText("");
        mCargarDatosIngreso();
        this.cboLleno = 1;
    }

    private void mConsultarNAutorizacion() {
        if (this.JCBEmpresaFact.getSelectedIndex() != -1) {
            this.txtNoAutorizacion.setText(this.txtNoAutorizacion.getText().trim());
            if (this.xidEmpresaFact[this.JCBEmpresaFact.getSelectedIndex()][13].equals("1")) {
                new ArrayList();
                Long idIngreso = new Long(0L);
                if (!this.xliq.JLB_NIngreso.getText().isEmpty()) {
                    idIngreso = Long.valueOf(this.xliq.JLB_NIngreso.getText());
                }
                List<IConsultarNumeroAutorizacionIngreso> autorizacionIngresos = this.ingresoService.consultarNumeroAutorizacionPorIngreso(Long.valueOf(this.xidEmpresaFact[this.JCBEmpresaFact.getSelectedIndex()][0]), this.txtNoAutorizacion.getText(), idIngreso);
                if (!autorizacionIngresos.isEmpty()) {
                    String xmensaje = "<html><P ALIGN=center> <font face='Arial' color='red' size=4>  <b>Nº de autorización ya asaignado al ingreso Nº : " + autorizacionIngresos.get(0).getIdIngreso() + ",  con fecha : " + autorizacionIngresos.get(0).getFechaIngreso() + ",  usuario : " + autorizacionIngresos.get(0).getNombreUsuario() + " ;</p><font face='Arial' color='red' size=4>Favor verificar.";
                    JOptionPane.showInternalMessageDialog(this, xmensaje, "CONTROL NÚMERO DE AUTORIZACIONES", 2, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Warning.png"))));
                    this.txtNoAutorizacion.setText("");
                }
            }
        }
    }

    private void mCargarCombos() {
        this.JCBEstrato.removeAllItems();
        this.JCBContrato.removeAllItems();
        this.JCBEmpresaFact.removeAllItems();
        this.xidEmpresaFact = this.xconsulta.llenarComboyLista("SELECT f_empresacontxconvenio.Id AS Id, f_empresacontxconvenio.Nbre AS Empresa_Contratante, f_empresacontxconvenio.Id_Manual, f_empresacontxconvenio.EsCapitado, f_empresacontxconvenio.CualValor, g_empresacont.Id_TipoPlan, f_empresacontxconvenio.FiltroProcxEmp, f_empresacontxconvenio.ValidacionUsuario, f_empresacontxconvenio.ValidarDatos, f_empresacontxconvenio.Descuento, f_empresacontxconvenio.Id_EmpresaConvenio, f_empresacontxconvenio.Id_Contrato, f_empresacontxconvenio.Id_GIps, f_empresacontxconvenio.GMovimientoContable, `f_empresacontxconvenio`.`validaCodigoAutorizacion`, g_tipo_contratacion.nombre idTipoContratacion, f_tipo_cobertura_plan.nombre idTipoCobertura FROM f_empresacontxconvenio INNER JOIN g_empresacont ON (f_empresacontxconvenio.Id_EmpresaCont = g_empresacont.Id_empresa)  INNER JOIN g_contratos  ON (g_contratos.Id_EmpresaContConvenio = f_empresacontxconvenio.Id) INNER JOIN g_tipo_contratacion ON (f_empresacontxconvenio.idTipoContratacion = g_tipo_contratacion.id)\nINNER JOIN f_tipo_cobertura_plan ON (f_empresacontxconvenio.idTipoCoberturaPlan = f_tipo_cobertura_plan.id)\nWHERE (f_empresacontxconvenio.Estado =0)  GROUP BY f_empresacontxconvenio.Id ORDER BY f_empresacontxconvenio.Nbre ASC  ", this.xidEmpresaFact, this.JCBEmpresaFact, 17);
        this.JCBEmpresaFact.setSelectedIndex(-1);
        this.JCBTipoAtencion.removeAllItems();
        this.xidTipoAtencion = this.xconsulta.llenarCombo("SELECT g_tipoatencion.Id, g_tipoatencion.Nbre as Tipo_Atencion, g_tipoambito.Nbre as Ambito, g_tipoatencion.GenHosp as T FROM g_tipoatencion INNER JOIN g_tipoambito ON (g_tipoatencion.Id_TipoAmbito = g_tipoambito.Id) order by Tipo_Atencion", this.xidTipoAtencion, this.JCBTipoAtencion);
        this.JCBTipoAtencion.setSelectedIndex(-1);
        this.JCBEspecialidad.removeAllItems();
        this.xidEspecialidad = this.xconsulta.llenarCombo("SELECT  g_especialidad.Id ,  g_especialidad.Nbre FROM g_profesionalespecial  INNER JOIN  g_especialidad ON ( g_profesionalespecial.Id_Especialidad = g_especialidad.Id) WHERE (g_especialidad.Estado =0 AND g_profesionalespecial.Estado =0) GROUP BY g_especialidad.Id ORDER BY g_especialidad.Nbre ASC", this.xidEspecialidad, this.JCBEspecialidad);
        this.JCBEspecialidad.setSelectedIndex(-1);
        this.JCBEscolaridad.removeAllItems();
        this.xidescolaridad = this.xconsulta.llenarCombo("SELECT Id , UCASE(Nbre) FROM g_nivelestudio WHERE (Estado =0) ORDER BY Nbre ASC", this.xidescolaridad, this.JCBEscolaridad);
        this.JCBEscolaridad.setSelectedIndex(-1);
        this.JCBOrigenIngreso.removeAllItems();
        this.xidOIngreso = this.xconsulta.llenarCombo("SELECT Id, Nbre as Origen_Ingreso FROM g_origenadmision ORDER BY Nbre ASC", this.xidOIngreso, this.JCBOrigenIngreso);
        this.JCBOrigenIngreso.setSelectedIndex(-1);
        this.JCBCausaExterna.removeAllItems();
        this.xidCausaExt = this.xconsulta.llenarComboyLista("SELECT Id, Nbre as Causa_Externa, Activar_Modulo FROM g_causaexterna WHERE Estado =0 ORDER BY Nbre ASC", this.xidCausaExt, this.JCBCausaExterna, 3);
        this.JCBCausaExterna.setSelectedIndex(-1);
        this.JCBOcupaciones.removeAllItems();
        this.xidocupaciones = this.xconsulta.llenarCombo("SELECT Id, Nbre FROM g_ocupacion WHERE Estado = 0  and Nivel=5 ORDER BY Nbre ASC", this.xidocupaciones, this.JCBOcupaciones);
        this.JCBOcupaciones.setSelectedIndex(-1);
        this.JCBParentezco.removeAllItems();
        this.xidParentezco = this.xconsulta.llenarCombo("SELECT Id, Nbre as Parentesco FROM g_parentesco WHERE Estado =0 ORDER BY Nbre ASC", this.xidParentezco, this.JCBParentezco);
        this.JCBParentezco.setSelectedIndex(-1);
        this.JCBTipoDocResp.removeAllItems();
        this.xconsulta.llenarCombo("SELECT `Id` , `Nbre` FROM `g_tipoidentificacion` ORDER BY Nbre ASC", this.xidtRespo, this.JCBTipoDocResp);
        this.JCBTipoDocResp.setSelectedIndex(-1);
        this.JTFNoDocuResp.setText("");
        this.JCBSede.removeAllItems();
        this.xIdSede = this.xconsulta.llenarCombo("SELECT  `Id` , `Nbre` FROM `g_sedes` WHERE (`Id_Ips` ='" + Principal.informacionIps.getId() + "') ORDER BY `Nbre` ASC", this.xIdSede, this.JCBSede);
        this.JCBSede.setSelectedItem(Principal.sedeUsuarioSeleccionadaDTO.getNombre());
        this.JCBTipoDocAco.removeAllItems();
        this.xconsulta.llenarCombo("SELECT `Id` , `Nbre` FROM `g_tipoidentificacion` ORDER BY Nbre ASC", this.xidtAcomp, this.JCBTipoDocAco);
        this.JCBTipoDocAco.setSelectedIndex(-1);
        this.JTFNoDocuAco.setText("");
        this.JCB_TipoContratacion.removeAllItems();
        this.xidTipoContratacion = this.xconsulta.llenarComboyLista("SELECT id, nombre, estado FROM g_tipo_contratacion where estado =1 ORDER BY  nombre ASC", this.xidTipoContratacion, this.JCB_TipoContratacion, 3);
        this.JCB_TipoContratacion.setSelectedIndex(-1);
        this.JCB_TipoCoberturaPlan.removeAllItems();
        this.xidTipoCobertura = this.xconsulta.llenarComboyLista("SELECT id, nombre, estado FROM f_tipo_cobertura_plan where estado =1 ORDER BY  nombre ASC", this.xidTipoCobertura, this.JCB_TipoCoberturaPlan, 3);
        this.JCB_TipoCoberturaPlan.setSelectedIndex(-1);
        this.xlleno = true;
        this.xconsulta.cerrarConexionBd();
        this.listGModalidadatencions = new ArrayList();
        LlenarCombosGenericos<GModalidadatencion> combosGenericos = new LlenarCombosGenericos<>();
        this.listGModalidadatencions = combosGenericos.getListComboLleno(this.JCBModalidadAtencion.getName());
        this.listGModalidadatencions.forEach(e -> {
            this.JCBModalidadAtencion.addItem(e.getNombre());
        });
        if (!this.listGModalidadatencions.isEmpty()) {
            this.JCBModalidadAtencion.setSelectedItem("Intramural");
        }
        this.listGEntornoAtencions = new ArrayList();
        LlenarCombosGenericos<GEntornoAtencion> combosGenericos1 = new LlenarCombosGenericos<>();
        this.listGEntornoAtencions = combosGenericos1.getListComboLleno(this.JCBEntornoAtencion.getName());
        this.listGEntornoAtencions.forEach(e2 -> {
            this.JCBEntornoAtencion.addItem(e2.getNombre());
        });
        if (!this.listGEntornoAtencions.isEmpty()) {
            this.JCBEntornoAtencion.setSelectedItem("Institucional");
        }
    }

    public void mLlenarComboEstrado() {
        if (this.JCBEmpresaFact.getSelectedIndex() > -1 && this.cboLleno == 1) {
            ConsultasMySQL xct = new ConsultasMySQL();
            this.JCBEstrato.removeAllItems();
            String sql = "SELECT f_estrato.Id, f_estrato.Nbre as Estrato, f_estratoxemprcontconv.PorcSubsidio as Subsidio,f_estratoxemprcontconv.ValorMaximo as Valor_Maximo FROM f_estratoxemprcontconv INNER JOIN f_estrato  ON (f_estratoxemprcontconv.Id_Estrato = f_estrato.Id) WHERE (f_estratoxemprcontconv.Estado =0 AND f_estratoxemprcontconv.Copago ='" + this.xcopago + "' AND f_estratoxemprcontconv.Id_EmpresaContConv ='" + getIdEmpresa() + "') ORDER BY Estrato ASC ";
            System.out.println("estrato : " + sql);
            this.xidestrato = xct.llenarComboyLista(sql, this.xidestrato, this.JCBEstrato, 4);
            xct.cerrarConexionBd();
            if (this.xidestrato.length > 1) {
                this.JCBEstrato.setSelectedIndex(-1);
            }
        }
    }

    public void mLlenaComboContrato() {
        if (this.JCBEmpresaFact.getSelectedIndex() > -1 && this.cboLleno == 1) {
            ConsultasMySQL xct = new ConsultasMySQL();
            this.JCBContrato.removeAllItems();
            String sql = "SELECT Id, Nbre_Contrato as Contrato, No_Contrato, FechaInicio, FechaFin, ValorActual, UsuariosAtendidos FROM g_contratos WHERE (Estado =0 AND Id_EmpresaContConvenio ='" + getIdEmpresa() + "') order by Nbre_Contrato";
            this.xidContrato = xct.llenarCombo(sql, this.xidContrato, this.JCBContrato);
            if (this.xidContrato.length > 1) {
                this.JCBContrato.setSelectedIndex(-1);
            }
            xct.cerrarConexionBd();
        }
    }

    public void mLlenarComboTipoAfiliado() {
        if (this.JCBEmpresaFact.getSelectedIndex() > -1 && this.cboLleno == 1) {
            this.JCBTipoAfiliado.removeAllItems();
            String sql = "SELECT\n    `f_empresacontxconvenio_tipoafiliado`.`idtipoAfiliado`\n    , `g_tipoafiliado`.`Nbre` AS `TipoAfiliado`\n    , `f_empresacontxconvenio_tipoafiliado`.`estado`\nFROM\n    `baseserver`.`f_empresacontxconvenio_tipoafiliado`\n    INNER JOIN `baseserver`.`g_tipoafiliado` \n        ON (`f_empresacontxconvenio_tipoafiliado`.`idtipoAfiliado` = `g_tipoafiliado`.`Id`)\nWHERE (`f_empresacontxconvenio_tipoafiliado`.`estado` =1\n    AND `f_empresacontxconvenio_tipoafiliado`.`idEmpresaConvenio` =" + getIdEmpresa() + ")\nORDER BY `TipoAfiliado` ASC;";
            this.xidTipoAfiliado = this.xconsulta.llenarComboyLista(sql, this.xidTipoAfiliado, this.JCBTipoAfiliado, 3);
            this.xconsulta.cerrarConexionBd();
            if (this.xidTipoAfiliado.length > 1) {
                this.JCBTipoAfiliado.setSelectedIndex(-1);
            }
            this.JCBTipoAfiliado.setSelectedItem(this.xliq.xjppersona.cboTipoAfiliado.getSelectedItem());
        }
    }

    private void cargarCboProfesional() {
        ConsultasMySQL xct = new ConsultasMySQL();
        if (this.JCBEspecialidad.getSelectedIndex() > -1 && this.xlleno) {
            String sql = "SELECT w_profesional.Id_Persona, w_profesional.NProfesional FROM g_profesional INNER JOIN baseserver.w_profesional   ON (g_profesional.Id_Persona = w_profesional.Id_Persona) WHERE (g_profesional.P_Ips =1 AND g_profesional.Estado =0 AND w_profesional.IdEspecialidad ='" + this.xidEspecialidad[this.JCBEspecialidad.getSelectedIndex()] + "') ORDER BY w_profesional.NProfesional ASC ";
            this.JCBProfesional.removeAllItems();
            this.xidProfesional = xct.llenarCombo(sql, this.xidProfesional, this.JCBProfesional);
            this.JCBProfesional.setSelectedIndex(-1);
            xct.cerrarConexionBd();
            return;
        }
        this.JCBProfesional.removeAllItems();
        this.xidProfesional = xct.llenarCombo("SELECT Id_Persona, NProfesional FROM profesional1 WHERE (Estado =0 AND IdEspecialidad =382) ORDER BY NProfesional ASC", this.xidProfesional, this.JCBProfesional);
        this.JCBProfesional.setSelectedIndex(-1);
        xct.cerrarConexionBd();
    }

    private void mBuscarPatologiaN(JTextField codigo) {
        JIFBuscarPatologia pac = new JIFBuscarPatologia((Frame) null, true, (Object) "", "LiqServicios");
        pac.setVisible(true);
        pac.setLocationRelativeTo(this);
    }

    public String getIdEmpresa() {
        return this.xidEmpresaFact[this.JCBEmpresaFact.getSelectedIndex()][0];
    }

    public String getTipoContratacion() {
        return this.xidEmpresaFact[this.JCBEmpresaFact.getSelectedIndex()][14];
    }

    public String getTipoCobertura() {
        return this.xidEmpresaFact[this.JCBEmpresaFact.getSelectedIndex()][15];
    }

    public void mGrabar(String xidUsuario, String xId_CitaCx) {
        String xId_ClaseC;
        if (this.JCBEmpresaFact.getSelectedIndex() != -1) {
            if (this.JCBTipoAtencion.getSelectedIndex() != -1) {
                if (this.JCBEscolaridad.getSelectedIndex() != -1) {
                    if (this.JCBEstrato.getSelectedIndex() != -1) {
                        if (this.JCBContrato.getSelectedIndex() != -1) {
                            if (this.JCBEspecialidad.getSelectedIndex() != -1) {
                                if (this.JCBProfesional.getSelectedIndex() != -1) {
                                    if (this.JCBOrigenIngreso.getSelectedIndex() != -1) {
                                        if (this.JCBCausaExterna.getSelectedIndex() != -1) {
                                            if (this.JCBOcupaciones.getSelectedIndex() != -1) {
                                                if (!this.JTFNombreAcomp.getText().isEmpty()) {
                                                    if (this.JCBParentezco.getSelectedIndex() != -1) {
                                                        if (!this.JTFTelAcomp.getText().isEmpty()) {
                                                            if (!this.JTFNombreResp.getText().isEmpty()) {
                                                                if (!this.JTFTelResp.getText().isEmpty()) {
                                                                    if (this.JCBSede.getSelectedIndex() != -1) {
                                                                        if (this.JCBTipoAfiliado.getSelectedIndex() != -1) {
                                                                            if (this.JCB_TipoContratacion.getSelectedIndex() != -1) {
                                                                                if (this.JCB_TipoCoberturaPlan.getSelectedIndex() != -1) {
                                                                                    if (!this.xliq.JLB_NIngreso.getText().isEmpty() && !this.xliq.JLB_NIngreso.getText().equals("0")) {
                                                                                        if (this.xliq.getxId_Liqidacion() == 0) {
                                                                                            int n = JOptionPane.showInternalConfirmDialog(this.xliq, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                                                                                            if (n == 0) {
                                                                                                String sql = "UPDATE `ingreso` SET `Id_EmpresaContxConv`='" + this.xidEmpresaFact[this.JCBEmpresaFact.getSelectedIndex()][0] + "', `esCapitado`='" + this.xidEmpresaFact[this.JCBEmpresaFact.getSelectedIndex()][2] + "', `SiCopago`='" + this.xcopago + "', `FechaIngreso`='" + this.xmetodo.formatoAMD.format(this.JDFecha.getDate()) + "', `HoraIngreso`='" + this.xmetodo.formatoH24.format(this.txtHora.getValue()) + "', `Id_Estrato`='" + this.xidestrato[this.JCBEstrato.getSelectedIndex()][0] + "', `Id_OrigenAdmision`='" + this.xidOIngreso[this.JCBOrigenIngreso.getSelectedIndex()] + "', `Id_CausaExterna`='" + this.xidCausaExt[this.JCBCausaExterna.getSelectedIndex()][0] + "', `Id_Especialidad`='" + this.xidEspecialidad[this.JCBEspecialidad.getSelectedIndex()] + "', `Id_Profesional`='" + this.xidProfesional[this.JCBProfesional.getSelectedIndex()] + "', `Id_TipoAtencion`='" + this.xidTipoAtencion[this.JCBTipoAtencion.getSelectedIndex()] + "', `Id_Contrato`='" + this.xidContrato[this.JCBContrato.getSelectedIndex()] + "',  NoPoliza='" + this.txtNoPoliza.getText() + "',  NoAutorizacion='" + this.txtNoAutorizacion.getText() + "',  `NAcompanante`='" + this.JTFNombreAcomp.getText() + "' , `TelefonoAcomp`='" + this.JTFTelAcomp.getText() + "' , `TipoDocA`='" + this.JCBTipoDocAco.getSelectedItem() + "' , `NoDocA`='" + this.JTFNoDocuAco.getText() + "' , `NPersonaResp`='" + this.JTFNombreResp.getText() + "' , `TelefonoPResp`='" + this.JTFTelResp.getText() + "' , `TipDoc`='" + this.JCBTipoDocResp.getSelectedItem() + "' , `Id_Sede`='" + this.xIdSede[this.JCBSede.getSelectedIndex()] + "' , `NoDocumento`='" + this.JTFNoDocuResp.getText() + "' , `Id_NivelEstudio`='" + this.xidescolaridad[this.JCBEscolaridad.getSelectedIndex()] + "' , `Id_Parentesco`='" + this.xidParentezco[this.JCBParentezco.getSelectedIndex()] + "' , `Id_Ocupacion`='" + this.xidocupaciones[this.JCBOcupaciones.getSelectedIndex()] + "' , `Id_CondVict`='" + this.xCondiVict + "' , `DxIngreso`='" + this.JTFCie10.getText().toUpperCase() + "' , `idTipoAfiliacion`='" + this.xidTipoAfiliado[this.JCBTipoAfiliado.getSelectedIndex()][0] + "' , idTipoContratacion='" + this.xidTipoContratacion[this.JCB_TipoContratacion.getSelectedIndex()][0] + "' , idTipoCoberturaPlan='" + this.xidTipoCobertura[this.JCB_TipoCoberturaPlan.getSelectedIndex()][0] + "' , siras='" + this.txtNoSiras.getText() + "' , idIdentidadG='" + this.xliq.xjppersona.listGSexoIdentidadGenero.get(this.xliq.xjppersona.JCBIdentidadGenero.getSelectedIndex()).getId() + "' , idTipoDiscapacidad='" + this.xliq.xjppersona.listGTipoDiscapacidad.get(this.xliq.xjppersona.JCBCategoriaDiscapacidad.getSelectedIndex()).getId() + "' , idModalidad='" + this.listGModalidadatencions.get(this.JCBModalidadAtencion.getSelectedIndex()).getId() + "' , idEntornoAtencion='" + this.listGEntornoAtencions.get(this.JCBEntornoAtencion.getSelectedIndex()).getId() + "' , `Fecha`='" + this.xmetodo.formatoAMDH24.format(this.xmetodo.getFechaActual()) + "', `UsuarioS`='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + this.xliq.JLB_NIngreso.getText() + "'";
                                                                                                this.xconsulta.ejecutarSQL(sql);
                                                                                                this.xconsulta.cerrarConexionBd();
                                                                                                if (this.JCBCondVict.getSelectedIndex() != -1) {
                                                                                                    String sql2 = "UPDATE `a_eventoecat_paciente` SET `Id_condvictima`='" + this.xidCondVict[this.JCBCondVict.getSelectedIndex()] + "' WHERE Id_Ingreso='" + this.xliq.JLB_NIngreso.getText() + "'";
                                                                                                    this.xconsulta.ejecutarSQL(sql2);
                                                                                                    this.xconsulta.cerrarConexionBd();
                                                                                                }
                                                                                                this.xliq.mInicar_Variables_Ingreso(this.xliq.JLB_NIngreso.getText());
                                                                                                JOptionPane.showInternalMessageDialog(this.xliq, "REGISTRO GUARDADO", "OK", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                                                                                return;
                                                                                            }
                                                                                            return;
                                                                                        }
                                                                                        JOptionPane.showInternalMessageDialog(this, "Ingreso con liquidación activa;\nsolo se van actualizar items que no interfieran con convenio y valores", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                                                                        String sql3 = "UPDATE `ingreso` SET  `FechaIngreso`='" + this.xmetodo.formatoAMD.format(this.JDFecha.getDate()) + "', `HoraIngreso`='" + this.xmetodo.formatoH24.format(this.txtHora.getValue()) + "', `Id_Estrato`='" + this.xidestrato[this.JCBEstrato.getSelectedIndex()][0] + "', `Id_OrigenAdmision`='" + this.xidOIngreso[this.JCBOrigenIngreso.getSelectedIndex()] + "', `Id_CausaExterna`='" + this.xidCausaExt[this.JCBCausaExterna.getSelectedIndex()][0] + "', `Id_Especialidad`='" + this.xidEspecialidad[this.JCBEspecialidad.getSelectedIndex()] + "', `Id_Profesional`='" + this.xidProfesional[this.JCBProfesional.getSelectedIndex()] + "', `Id_TipoAtencion`='" + this.xidTipoAtencion[this.JCBTipoAtencion.getSelectedIndex()] + "',  NoPoliza='" + this.txtNoPoliza.getText() + "',  NoAutorizacion='" + this.txtNoAutorizacion.getText() + "',  `NAcompanante`='" + this.JTFNombreAcomp.getText() + "' , `TelefonoAcomp`='" + this.JTFTelAcomp.getText() + "' , `TipoDocA`='" + this.JCBTipoDocAco.getSelectedItem() + "' , `NoDocA`='" + this.JTFNoDocuAco.getText() + "' , `NPersonaResp`='" + this.JTFNombreResp.getText() + "' , `TelefonoPResp`='" + this.JTFTelResp.getText() + "' , `TipDoc`='" + this.JCBTipoDocResp.getSelectedItem() + "' , `Id_Sede`='" + this.xIdSede[this.JCBSede.getSelectedIndex()] + "' , `NoDocumento`='" + this.JTFNoDocuResp.getText() + "' , `Id_NivelEstudio`='" + this.xidescolaridad[this.JCBEscolaridad.getSelectedIndex()] + "' , `Id_Parentesco`='" + this.xidParentezco[this.JCBParentezco.getSelectedIndex()] + "' , `Id_Ocupacion`='" + this.xidocupaciones[this.JCBOcupaciones.getSelectedIndex()] + "' , `Id_CondVict`='" + this.xCondiVict + "' , `DxIngreso`='" + this.JTFCie10.getText().toUpperCase() + "' , `idTipoAfiliacion`='" + this.xidTipoAfiliado[this.JCBTipoAfiliado.getSelectedIndex()][0] + "' , idTipoContratacion='" + this.xidTipoContratacion[this.JCB_TipoContratacion.getSelectedIndex()][0] + "' , idTipoCoberturaPlan='" + this.xidTipoCobertura[this.JCB_TipoCoberturaPlan.getSelectedIndex()][0] + "' , siras='" + this.txtNoSiras.getText() + "' , idIdentidadG='" + this.xliq.xjppersona.listGSexoIdentidadGenero.get(this.xliq.xjppersona.JCBIdentidadGenero.getSelectedIndex()).getId() + "' , idTipoDiscapacidad='" + this.xliq.xjppersona.listGTipoDiscapacidad.get(this.xliq.xjppersona.JCBCategoriaDiscapacidad.getSelectedIndex()).getId() + "' , idModalidad='" + this.listGModalidadatencions.get(this.JCBModalidadAtencion.getSelectedIndex()).getId() + "' , idEntornoAtencion='" + this.listGEntornoAtencions.get(this.JCBEntornoAtencion.getSelectedIndex()).getId() + "' , `Fecha`='" + this.xmetodo.formatoAMDH24.format(this.xmetodo.getFechaActual()) + "', `UsuarioS`='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + this.xliq.JLB_NIngreso.getText() + "'";
                                                                                        this.xconsulta.ejecutarSQL(sql3);
                                                                                        this.xconsulta.cerrarConexionBd();
                                                                                        if (this.JCBCondVict.getSelectedIndex() != -1) {
                                                                                            String sql22 = "UPDATE `a_eventoecat_paciente` SET `Id_condvictima`='" + this.xidCondVict[this.JCBCondVict.getSelectedIndex()] + "' WHERE Id_Ingreso='" + this.xliq.JLB_NIngreso.getText() + "'";
                                                                                            this.xconsulta.ejecutarSQL(sql22);
                                                                                            this.xconsulta.cerrarConexionBd();
                                                                                            return;
                                                                                        }
                                                                                        return;
                                                                                    }
                                                                                    int n2 = JOptionPane.showInternalConfirmDialog(this.xliq, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                                                                                    if (n2 == 0) {
                                                                                        if (xidUsuario.equals("0")) {
                                                                                            this.xliq.xjppersona.grabar();
                                                                                            xidUsuario = this.xliq.xjppersona.getIdPersona();
                                                                                        }
                                                                                        String sql4 = "INSERT INTO `ingreso` (`Id_Usuario` , `FechaIngreso` , `HoraIngreso` , `Id_EmpresaContxConv` , `esCapitado` , `Id_Sede`, siras  , `SiCopago` , `Id_Estrato` , `Id_OrigenAdmision` , `Id_CausaExterna` , `Id_Especialidad` , `Id_Profesional`  , `Id_TipoAtencion`  , `Id_Contrato` ,NoPoliza ,NoAutorizacion ,EsAtencion , `NAcompanante` , `TelefonoAcomp` , `NPersonaResp` , `TelefonoPResp`  , `Id_NivelEstudio` , `Id_Parentesco` , `Id_Ocupacion` , `SO_Cargo` , `SO_Supervisor` , `SO_SEG` , `SO_Jornada`  , `HorasTrabajadas` , `SO_Arl` , `SO_Grupo` , `SO_Lateralidad` , `NoHijos` , `ClaseSE` , `SO_FechaIngreso`  , `SO_UNegocio` , TipoDocA,NoDocA,TipDoc,NoDocumento, Id_CondVict ,DxIngreso, idTipoAfiliacion, idTipoContratacion, idTipoCoberturaPlan, `Fecha`, `UsuarioS`, idIdentidadG, idTipoDiscapacidad, idModalidad, idEntornoAtencion , idTipoDoc, numeroDocumento)  VALUES('" + xidUsuario + "','" + this.xmetodo.formatoAMD.format(this.JDFecha.getDate()) + "','" + this.xmetodo.formatoH24.format(this.txtHora.getValue()) + "','" + this.xidEmpresaFact[this.JCBEmpresaFact.getSelectedIndex()][0] + "','" + this.xidEmpresaFact[this.JCBEmpresaFact.getSelectedIndex()][2] + "','" + this.xIdSede[this.JCBSede.getSelectedIndex()] + "','" + this.txtNoSiras.getText() + "','" + this.xcopago + "','" + this.xidestrato[this.JCBEstrato.getSelectedIndex()][0] + "','" + this.xidOIngreso[this.JCBOrigenIngreso.getSelectedIndex()] + "','" + this.xidCausaExt[this.JCBCausaExterna.getSelectedIndex()][0] + "','" + this.xidEspecialidad[this.JCBEspecialidad.getSelectedIndex()] + "','" + this.xidProfesional[this.JCBProfesional.getSelectedIndex()] + "','" + this.xidTipoAtencion[this.JCBTipoAtencion.getSelectedIndex()] + "','" + this.xidContrato[this.JCBContrato.getSelectedIndex()] + "','" + this.txtNoPoliza.getText() + "','" + this.txtNoAutorizacion.getText() + "','1','" + this.JTFNombreAcomp.getText() + "','" + this.JTFTelAcomp.getText() + "','" + this.JTFNombreResp.getText() + "','" + this.JTFTelResp.getText() + "','" + this.xidescolaridad[this.JCBEscolaridad.getSelectedIndex()] + "','" + this.xidParentezco[this.JCBParentezco.getSelectedIndex()] + "','" + this.xidocupaciones[this.JCBOcupaciones.getSelectedIndex()] + "','" + this.xliq.xjppersona.JCBCargo.getSelectedItem() + "','" + this.xliq.xjppersona.JCBSupervisor.getSelectedItem() + "','" + this.xliq.xjppersona.JCBSegmento.getSelectedItem() + "','" + this.xliq.xjppersona.JCBJornada.getSelectedItem() + "','" + this.xliq.xjppersona.JSPNHorasTrabajadas.getValue() + "','" + this.xliq.xjppersona.JCBArl.getSelectedItem() + "','" + this.xliq.xjppersona.JCBGrupo.getSelectedItem() + "','" + this.xliq.xjppersona.JCBLateralidad.getSelectedItem() + "','" + this.xliq.xjppersona.JSPNHijos.getValue() + "','" + this.xliq.xjppersona.JSPNClaSE.getValue() + "','" + this.xmetodo.formatoAMD.format(this.xliq.xjppersona.JDFechaIngreso.getDate()) + "','" + this.xliq.xjppersona.JCBUnidadN.getSelectedItem() + "','" + this.JCBTipoDocAco.getSelectedItem() + "','" + this.JTFNoDocuAco.getText() + "','" + this.JCBTipoDocResp.getSelectedItem() + "','" + this.JTFNoDocuResp.getText() + "','" + this.xCondiVict + "','" + this.JTFCie10.getText().toUpperCase() + "','" + this.xidTipoAfiliado[this.JCBTipoAfiliado.getSelectedIndex()][0] + "','" + this.xidTipoContratacion[this.JCB_TipoContratacion.getSelectedIndex()][0] + "','" + this.xidTipoCobertura[this.JCB_TipoCoberturaPlan.getSelectedIndex()][0] + "','" + this.xmetodo.formatoAMDH24.format(this.xmetodo.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "','" + this.xliq.xjppersona.listGSexoIdentidadGenero.get(this.xliq.xjppersona.JCBIdentidadGenero.getSelectedIndex()).getId() + "','" + this.xliq.xjppersona.listGTipoDiscapacidad.get(this.xliq.xjppersona.JCBCategoriaDiscapacidad.getSelectedIndex()).getId() + "','" + this.listGModalidadatencions.get(this.JCBModalidadAtencion.getSelectedIndex()).getId() + "','" + this.listGEntornoAtencions.get(this.JCBEntornoAtencion.getSelectedIndex()).getId() + "','" + this.xliq.xjppersona.getIdTipoIdentifiacion() + "','" + this.xliq.xjppersona.txtIdentificacion.getText() + "')";
                                                                                        this.xliq.JLB_NIngreso.setText(this.xconsulta.ejecutarSQLId(sql4));
                                                                                        this.xconsulta.cerrarConexionBd();
                                                                                        this.xliq.mInicar_Variables_Ingreso(this.xliq.JLB_NIngreso.getText());
                                                                                        System.out.println(" id cirugia " + xId_CitaCx);
                                                                                        if (this.xliq.xjif_cx != null) {
                                                                                            try {
                                                                                                String sql5 = "update q_agendacx set Id_Ingreso='" + this.xliq.JLB_NIngreso.getText() + "' where Id='" + xId_CitaCx + "'";
                                                                                                this.xconsulta.ejecutarSQL(sql5);
                                                                                                this.xconsulta.cerrarConexionBd();
                                                                                                if (Principal.informacionIps.getIdentificacion().equals("812005644")) {
                                                                                                    xId_ClaseC = "42";
                                                                                                } else if (Principal.informacionIps.getNombreIps().equals("BIENESTAR ACTIVA IPS")) {
                                                                                                    xId_ClaseC = "204";
                                                                                                } else {
                                                                                                    xId_ClaseC = String.valueOf(this.xliq.idClaseCita);
                                                                                                }
                                                                                                String sql6 = "INSERT INTO h_atencion (Id_Ingreso, Id_ClaseCita, Fecha_Atencion, Hora_Atencion, Motivo_Atencion, Codigo_Dxp, Id_TipoDx, Codigo_DxR1, Codigo_DxR2, Codigo_DxR3, Conclusion, Id_Profesional, Id_Especialidad, Estado, Fecha, UsuarioS) VALUES ( '" + this.xliq.JLB_NIngreso.getText() + "','" + xId_ClaseC + "','" + this.xmetodo.formatoAMD.format(this.JDFecha.getDate()) + "','" + this.xmetodo.formatoH24.format(this.txtHora.getValue()) + "','','" + this.JTFCie10.getText() + "','1','','','','','" + this.xidProfesional[this.JCBProfesional.getSelectedIndex()] + "','" + this.xidEspecialidad[this.JCBEspecialidad.getSelectedIndex()] + "','0','" + this.xmetodo.formatoAMDH24.format(this.xmetodo.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                                                                                                String xId_Atencion = this.xconsulta.ejecutarSQLId(sql6);
                                                                                                this.xconsulta.cerrarConexionBd();
                                                                                                String sql7 = "update ingreso set Id_Atencion='" + xId_Atencion + "' where Id='" + this.xliq.JLB_NIngreso.getText() + "'";
                                                                                                this.xconsulta.ejecutarSQL(sql7);
                                                                                                this.xconsulta.cerrarConexionBd();
                                                                                                String sql8 = "INSERT INTO c_citasnp (Id_Profesional, Id_Especialidad, Id_Usuario, Id_EmpresaCont, Id_ClaseCita, Fecha_Cita, HoraInicial, Remitida, PrimerVez, Id_ingreso, So, Observacion,Urgente, Fecha, UsuarioS,Id_TratamientoO,NAutorizacion, Id_Sede, Id_UsuarioS) VALUES ('" + this.xidProfesional[this.JCBProfesional.getSelectedIndex()] + "','" + this.xidEspecialidad[this.JCBEspecialidad.getSelectedIndex()] + "','" + xidUsuario + "','" + this.xidEmpresaFact[this.JCBEmpresaFact.getSelectedIndex()][0] + "','" + xId_ClaseC + "','" + this.xmetodo.formatoAMD.format(this.JDFecha.getDate()) + "','" + this.xmetodo.formatoH24.format(this.txtHora.getValue()) + "','0','0','" + this.xliq.JLB_NIngreso.getText() + "','0','INGRESO POR CIRUGIA PROGRAMADA','0','" + this.xmetodo.formatoAMDH24.format(this.xmetodo.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "','0','" + this.txtNoAutorizacion.getText() + "','" + this.xIdSede[this.JCBSede.getSelectedIndex()] + "','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "')";
                                                                                                this.xconsulta.ejecutarSQL(sql8);
                                                                                                this.xconsulta.cerrarConexionBd();
                                                                                                String sql9 = "select  ht.Id \nfrom h_tiponota ht \ninner join h_tiponota_especialidad hte on (ht.Id=hte.Id_TipoNota)\nwhere hte.Id_Especialidad =" + this.xidEspecialidad[this.JCBEspecialidad.getSelectedIndex()] + " and ht.Id_Clasificacion =5 and hte.Estado =1";
                                                                                                ResultSet rs = this.xconsulta.getResultSet(sql9);
                                                                                                if (rs.next()) {
                                                                                                    System.out.println("entro a la interconslta");
                                                                                                    rs.first();
                                                                                                    String sql10 = "insert into  h_notasclinicas (Id_Atencion, Id_Tipo_Atencion, FechaNota, HoraNota, Id_TipoNota, Descripcion, Id_Profesional, Id_Especialidad, NCierre, Fecha, UsuarioS) values ('" + xId_Atencion + "','" + this.xidTipoAtencion[this.JCBTipoAtencion.getSelectedIndex()] + "','" + this.xmetodo.formatoAMD.format(this.JDFecha.getDate()) + "',IF('" + this.txtHora.getText() + "'='24:00:00','23:59:59','" + this.txtHora.getText() + "'),'" + rs.getInt("Id") + "','" + this.JCBEspecialidad.getSelectedItem() + "','" + this.xidProfesional[this.JCBProfesional.getSelectedIndex()] + "','" + this.xidEspecialidad[this.JCBEspecialidad.getSelectedIndex()] + "','0','" + this.xmetodo.formatoAMDH24.format(this.xmetodo.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                                                                                                    String idNota = this.xconsulta.ejecutarSQLId(sql10);
                                                                                                    System.out.println("" + sql10);
                                                                                                    this.xconsulta.cerrarConexionBd();
                                                                                                    String xsql = "insert into h_ordenes_interconsultas(`Id_Nota`, `Id_Especialidad`, `UsuarioS`) values('" + idNota + "','" + this.xidEspecialidad[this.JCBEspecialidad.getSelectedIndex()] + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                                                                                                    System.out.println("" + xsql);
                                                                                                    this.xconsulta.ejecutarSQL(xsql);
                                                                                                    this.xconsulta.cerrarConexionBd();
                                                                                                }
                                                                                            } catch (SQLException ex) {
                                                                                                Logger.getLogger(JPIngreso.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                                                                                            }
                                                                                        }
                                                                                        JOptionPane.showInternalMessageDialog(this.xliq, "REGISTRO GUARDADO", "OK", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                                                                        return;
                                                                                    }
                                                                                    return;
                                                                                }
                                                                                JOptionPane.showInternalMessageDialog(this.xliq, "Debe seleccionar el tipo de plan de cobertura", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                                                                this.JTPAdicional.setSelectedIndex(1);
                                                                                this.JCB_TipoCoberturaPlan.requestFocus();
                                                                                return;
                                                                            }
                                                                            JOptionPane.showInternalMessageDialog(this.xliq, "Debe seleccionar el tipo de contratacion", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                                                            this.JTPAdicional.setSelectedIndex(1);
                                                                            this.JCB_TipoContratacion.requestFocus();
                                                                            return;
                                                                        }
                                                                        JOptionPane.showInternalMessageDialog(this.xliq, "Debe seleccionar el tipo de afiliado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                                                        this.JTPAdicional.setSelectedIndex(1);
                                                                        this.JCBTipoAfiliado.requestFocus();
                                                                        return;
                                                                    }
                                                                    JOptionPane.showInternalMessageDialog(this.xliq, "Debe seleccionar la sede", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                                                    this.JCBSede.requestFocus();
                                                                    return;
                                                                }
                                                                JOptionPane.showInternalMessageDialog(this.xliq, "Debe digitar el teléfono del responsable", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                                                this.JTFTelResp.requestFocus();
                                                                return;
                                                            }
                                                            JOptionPane.showInternalMessageDialog(this.xliq, "Debe digitar el nombre del responsable", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                                            this.JTFNombreResp.requestFocus();
                                                            return;
                                                        }
                                                        JOptionPane.showInternalMessageDialog(this.xliq, "Debe digitar el teléfono del acompañante", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                                        this.JTFTelAcomp.requestFocus();
                                                        return;
                                                    }
                                                    JOptionPane.showInternalMessageDialog(this.xliq, "Debe seleccionar el parentesco del acompañante", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                                    this.JTFNombreAcomp.requestFocus();
                                                    return;
                                                }
                                                JOptionPane.showInternalMessageDialog(this.xliq, "Debe digitar el nombre del acompañante", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                                this.JTFNombreAcomp.requestFocus();
                                                return;
                                            }
                                            JOptionPane.showInternalMessageDialog(this.xliq, "Debe seleccionar una ocupación", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                            this.JCBOcupaciones.requestFocus();
                                            return;
                                        }
                                        JOptionPane.showInternalMessageDialog(this.xliq, "Debe seleccionar un origen de ingreso", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                        this.JCBCausaExterna.requestFocus();
                                        return;
                                    }
                                    JOptionPane.showInternalMessageDialog(this.xliq, "Debe seleccionar un origen de ingreso", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                    this.JCBOrigenIngreso.requestFocus();
                                    return;
                                }
                                JOptionPane.showInternalMessageDialog(this.xliq, "Debe seleccionar un profesional", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                this.JCBProfesional.requestFocus();
                                return;
                            }
                            JOptionPane.showInternalMessageDialog(this.xliq, "Debe seleccionar una especialidad", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                            this.JCBEspecialidad.requestFocus();
                            return;
                        }
                        JOptionPane.showInternalMessageDialog(this.xliq, "Debe seleccionar un contrato", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        this.JCBContrato.requestFocus();
                        return;
                    }
                    JOptionPane.showInternalMessageDialog(this.xliq, "Debe seleccionar un estrato", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    this.JCBEstrato.requestFocus();
                    return;
                }
                JOptionPane.showInternalMessageDialog(this.xliq, "Debe seleccionar una escolaridad", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JCBEscolaridad.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this.xliq, "Debe seleccionar un tipo de atención", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBEmpresaFact.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this.xliq, "Debe seleccionar una empresa", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JCBEmpresaFact.requestFocus();
    }

    /* JADX WARN: Finally extract failed */
    private void mCargarDatosIngreso() {
        String sql = "SELECT `ingreso`.`FechaIngreso` , `ingreso`.`HoraIngreso` , `f_empresacontxconvenio`.`Nbre` AS EmpresaConvenio , `g_tipoatencion`.`Nbre` AS Atencion  , `g_nivelestudio`.`Nbre` AS Escolaridad , `ingreso`.`SiCopago` , `f_estrato`.`Nbre` AS Estrato , `g_contratos`.`Nbre_Contrato` , `profesional1`.`Especialidad`  , `profesional1`.`NProfesional` , `g_origenadmision`.`Nbre` AS OAdmision , `g_causaexterna`.`Nbre` AS CausaExt , `ingreso`.`NoPoliza` , `g_ocupacion`.`Nbre` AS Ocupacion  , `ingreso`.`NAcompanante` , `g_parentesco`.`Nbre` AS Parentezco , `ingreso`.`TelefonoAcomp`  , `ingreso`.`NPersonaResp` , `ingreso`.`TelefonoPResp`  , `ingreso`.`NoAutorizacion` , `ingreso`.`DxIngreso`, IFNULL(ingreso.Id_CondVict,0) Id_CondVict , ingreso.TipoDocA,ingreso.NoDocA,ingreso.TipDoc,ingreso.NoDocumento, f_empresacontxconvenio.Id_GIps, IFNULL(a_condvictima.`Nbre`, '') CVictima, `g_sedes`.`Nbre` NSede, g_tipoafiliado.Nbre TipoAfiliado , g_tipo_contratacion.nombre idTipoContratacion, f_tipo_cobertura_plan.nombre idTipoCobertura, ingreso.`siras`  , gma.nombre  modalidadAtencion, gea.nombre entornoAtencion, gsig.nombre identidadGenero, gtd.nombre categoriaDiscapacidad  FROM `ingreso`  INNER JOIN `f_empresacontxconvenio`  ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)  INNER JOIN `f_estrato`   ON (`ingreso`.`Id_Estrato` = `f_estrato`.`Id`)  INNER JOIN `profesional1`  ON (`ingreso`.`Id_Especialidad` = `profesional1`.`IdEspecialidad`) AND (`ingreso`.`Id_Profesional` = `profesional1`.`Id_Persona`)  INNER JOIN `g_tipoatencion` ON (`ingreso`.`Id_TipoAtencion` = `g_tipoatencion`.`Id`)  INNER JOIN `g_nivelestudio` ON (`ingreso`.`Id_NivelEstudio` = `g_nivelestudio`.`Id`)  INNER JOIN `g_contratos`  ON (`ingreso`.`Id_Contrato` = `g_contratos`.`Id`)  INNER JOIN `g_origenadmision`  ON (`ingreso`.`Id_OrigenAdmision` = `g_origenadmision`.`Id`)  INNER JOIN `g_causaexterna`  ON (`ingreso`.`Id_CausaExterna` = `g_causaexterna`.`Id`)  INNER JOIN `g_ocupacion`  ON (`ingreso`.`Id_Ocupacion` = `g_ocupacion`.`Id`)  INNER JOIN `g_sedes`  ON (`ingreso`.`Id_Sede` = `g_sedes`.`Id`)  INNER JOIN `g_parentesco` ON (`ingreso`.`Id_Parentesco` = `g_parentesco`.`Id`) LEFT JOIN `a_eventoecat_paciente` ON (`ingreso`.`Id` = a_eventoecat_paciente.`Id_Ingreso`)  LEFT JOIN `a_condvictima` ON (`a_condvictima`.`Id` = ingreso.`Id_CondVict`)    INNER JOIN g_tipoafiliado ON (g_tipoafiliado.Id=ingreso.idTipoAfiliacion) INNER JOIN g_tipo_contratacion ON (ingreso.idTipoContratacion = g_tipo_contratacion.id) INNER JOIN f_tipo_cobertura_plan ON (ingreso.idTipoCoberturaPlan = f_tipo_cobertura_plan.id)inner join g_modalidad_atencion gma on (ingreso.idModalidad=gma.id)\ninner join g_entorno_atencion gea on (ingreso.idEntornoAtencion=gea.id)\ninner join g_sexo_identidad_genero gsig on (ingreso.idIdentidadG=gsig.id)\ninner join g_tipo_discapacidad gtd on (ingreso.idTipoDiscapacidad=gtd.id)\n WHERE (`ingreso`.Id='" + this.xliq.JLB_NIngreso.getText() + "')";
        System.out.println(sql);
        this.cboLleno = 1;
        try {
            ConsultasMySQL xct = new ConsultasMySQL();
            ResultSet xrs = xct.traerRs(sql);
            Throwable th = null;
            try {
                if (xrs.next()) {
                    xrs.first();
                    this.JDFecha.setDate(xrs.getDate("FechaIngreso"));
                    this.txtHora.setText(xrs.getString("HoraIngreso"));
                    this.JCBEmpresaFact.setSelectedItem(xrs.getString("EmpresaConvenio"));
                    llenarEmpresa();
                    this.JCBTipoAtencion.setSelectedItem(xrs.getString("Atencion"));
                    this.JCBEscolaridad.setSelectedItem(xrs.getString("Escolaridad").toUpperCase());
                    System.out.println("tipo " + xrs.getLong("SiCopago"));
                    if (!xrs.getBoolean("SiCopago")) {
                        this.xcopago = 0;
                        this.btnCModeradora.setSelected(true);
                        System.out.println("0 ");
                    } else {
                        this.xcopago = 1;
                        this.btnCopago.setSelected(true);
                        System.out.println("1 ");
                    }
                    this.JCBEstrato.setSelectedItem(xrs.getString("Estrato"));
                    this.JCBContrato.setSelectedItem(xrs.getString("Nbre_Contrato"));
                    this.JCBEspecialidad.setSelectedItem(xrs.getString("Especialidad"));
                    this.JCBProfesional.setSelectedItem(xrs.getString("NProfesional"));
                    this.JCBOrigenIngreso.setSelectedItem(xrs.getString("OAdmision"));
                    this.JCBCausaExterna.setSelectedItem(xrs.getString("CausaExt"));
                    this.txtNoPoliza.setText(xrs.getString("NoPoliza"));
                    this.JCBOcupaciones.setSelectedItem(xrs.getString("Ocupacion"));
                    this.JTFNombreAcomp.setText(xrs.getString("NAcompanante"));
                    this.JCBParentezco.setSelectedItem(xrs.getString("Parentezco"));
                    this.JTFTelAcomp.setText(xrs.getString("TelefonoAcomp"));
                    this.JTFNombreResp.setText(xrs.getString("NPersonaResp"));
                    this.JTFTelResp.setText(xrs.getString("TelefonoPResp"));
                    this.txtNoAutorizacion.setText(xrs.getString("NoAutorizacion"));
                    this.JTFCie10.setText(xrs.getString("DxIngreso"));
                    this.JCBCondVict.setSelectedItem(xrs.getString("Id_CondVict"));
                    this.JCBTipoDocAco.setSelectedItem(xrs.getString("TipoDocA"));
                    this.JTFNoDocuAco.setText(xrs.getString("NoDocA"));
                    this.JCBTipoDocResp.setSelectedItem(xrs.getString("TipDoc"));
                    this.JTFNoDocuResp.setText(xrs.getString("NoDocumento"));
                    this.JCBCondVict.setSelectedItem(xrs.getString("CVictima"));
                    this.JCBSede.setSelectedItem(xrs.getString("NSede"));
                    this.JCBTipoAfiliado.setSelectedItem(xrs.getString("TipoAfiliado"));
                    this.JCB_TipoContratacion.setSelectedItem(xrs.getString("idTipoContratacion"));
                    this.JCB_TipoCoberturaPlan.setSelectedItem(xrs.getString("idTipoCobertura"));
                    this.txtNoSiras.setText(xrs.getString("siras"));
                    this.JCBModalidadAtencion.setSelectedItem(xrs.getString("modalidadAtencion"));
                    this.JCBEntornoAtencion.setSelectedItem(xrs.getString("entornoAtencion"));
                    this.xliq.xjppersona.JCBIdentidadGenero.setSelectedItem(xrs.getString("identidadGenero"));
                    this.xliq.xjppersona.JCBCategoriaDiscapacidad.setSelectedItem(xrs.getString("categoriaDiscapacidad"));
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
                xct.cerrarConexionBd();
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
            Logger.getLogger(JPIngreso.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mActualizarAutorizacionItemProcedimeinto() {
        List<Object[]> listaOrdenes = this.liquidacionOrdenesServiciosDAO.listadoOrdenes(this.xliq.JLB_NIngreso.getText());
        if (listaOrdenes != null) {
            listaOrdenes.forEach(orden -> {
                Object elemento1 = orden[0];
                Object elemento2 = orden[1];
                System.out.println("Elemento 1: " + elemento1 + ", Elemento 2: " + elemento2);
                this.liquidacionOrdenesServiciosDAO.actualizarNumeroAutorizacion(this.txtNoAutorizacion.getText(), elemento1.toString());
            });
        } else {
            System.out.println("La lista de órdenes es nula.");
        }
    }
}
