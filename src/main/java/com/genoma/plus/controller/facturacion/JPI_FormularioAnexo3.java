package com.genoma.plus.controller.facturacion;

import Acceso.Principal;
import Facturacion.BuscarProced;
import Facturacion.ReporteAnexo3_Fac_SinOrden;
import Historia.clasesHistoriaCE;
import Utilidades.Metodos;
import com.genoma.plus.dao.facturacion.FacturacionDAO;
import com.genoma.plus.dao.facturacion.OrdenAnexo3DAO;
import com.genoma.plus.dao.general.InformacionProfesionalDAO;
import com.genoma.plus.dao.general.PatologiaCie10DAO;
import com.genoma.plus.dao.impl.facturacion.FacturacionDAOImp;
import com.genoma.plus.dao.impl.facturacion.OrdenAnexo3DAOImpl;
import com.genoma.plus.dao.impl.general.InformacionProfesionalDAOImpl;
import com.genoma.plus.dao.impl.general.PatologiaCie10DAOImpl;
import com.genoma.plus.dto.facturacion.GenericoDTO;
import com.genoma.plus.dto.facturacion.OrdenAnexo3DTO;
import com.genoma.plus.dto.facturacion.OrdenesAnexo3DetalleDTO;
import com.genoma.plus.dto.general.PatologiaCie10DTO;
import com.genoma.plus.jpa.projection.OrdenProcedimientoProjection;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
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
import java.sql.Date;
import java.text.ParseException;
import java.util.List;
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
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerNumberModel;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/facturacion/JPI_FormularioAnexo3.class */
public class JPI_FormularioAnexo3 extends JPanel {
    private InformacionProfesionalDAO informacionProfesionalDAO;
    private OrdenAnexo3DAO ordenAnexo3DAO;
    private FacturacionDAO facturacionDAO;
    private PatologiaCie10DAO patologiaCie10DAO;
    private String[] idEspecialidad;
    private String[] idProfesional;
    private DefaultTableModel modeloDetalleProcedimiento;
    private DefaultTableModel modeloHistorico;
    private Object[] dato;
    private clasesHistoriaCE historiaCE;
    private String idIngreso;
    public Long idProcedimiento;
    private ButtonGroup JBG_Prioridad;
    private ButtonGroup JBG_TipoArencion;
    private JButton JBT_Adicionar;
    public JComboBox JCBEspecialidad;
    public JComboBox JCBProfesional;
    private JCheckBox JCH_No_Prioritaria;
    private JCheckBox JCH_Prioritaria;
    private JCheckBox JCH_S_Prioritaria;
    private JCheckBox JCH_S_Urgencia;
    private JLabel JLB_NConsecutivo;
    private JLabel JLB_NRegistro;
    private JPanel JPI_DatosAnexo;
    private JPanel JPI_DatosProc;
    private JPanel JPI_Detalle;
    private JPanel JPI_Historico;
    private JPanel JPI_InformacionEncabezado;
    private JPanel JPI_Justificacion;
    private JScrollPane JSPDetalleDoc;
    private JScrollPane JSPHistorico;
    private JScrollPane JSPJustificacion;
    private JSpinner JSP_Cantidad;
    private JTable JTBDetalle;
    public JTextField JTFCDxP;
    private JTextField JTFCDxR1;
    private JTextField JTFCDxR2;
    private JFormattedTextField JTFF_Hora;
    public JTextField JTFNCodigoDxP;
    private JTextField JTFNDxR1;
    private JTextField JTFNDxR2;
    private JTextField JTFNumeroAutorizacion;
    public JTextField JTF_Codigo;
    public JTextField JTF_NProcedimiento;
    private JTable JTHistorico;
    public JTextPane JTJustificacion;
    private JTabbedPane JTPDatos;
    private JTabbedPane JTPFomurlario;
    private JDateChooser jDateChooser1;
    private JLabel jLabel1;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private Metodos metodos = new Metodos();
    private Boolean estadoLlenadoCombos = false;
    private int xnfila = -1;
    private int prioridad = 0;
    private int tipoAtencion = 1;

    public JPI_FormularioAnexo3(String idIngreso) {
        initComponents();
        springStart();
        this.idIngreso = idIngreso;
        if (Principal.clasehistoriace == null) {
            this.historiaCE = new clasesHistoriaCE();
        } else {
            this.historiaCE = Principal.clasehistoriace;
        }
        nuevo();
    }

    /* JADX WARN: Type inference failed for: r3v174, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBG_Prioridad = new ButtonGroup();
        this.JBG_TipoArencion = new ButtonGroup();
        this.JTPFomurlario = new JTabbedPane();
        this.JPI_DatosAnexo = new JPanel();
        this.JPI_InformacionEncabezado = new JPanel();
        this.JCBEspecialidad = new JComboBox();
        this.JCBProfesional = new JComboBox();
        this.JTFCDxP = new JTextField();
        this.JTFNCodigoDxP = new JTextField();
        this.JTFCDxR1 = new JTextField();
        this.JTFNDxR1 = new JTextField();
        this.JTFCDxR2 = new JTextField();
        this.JTFNDxR2 = new JTextField();
        this.jLabel1 = new JLabel();
        this.JLB_NRegistro = new JLabel();
        this.JTFF_Hora = new JFormattedTextField();
        this.JLB_NConsecutivo = new JLabel();
        this.jDateChooser1 = new JDateChooser();
        this.JTFNumeroAutorizacion = new JTextField();
        this.JTPDatos = new JTabbedPane();
        this.JPI_Justificacion = new JPanel();
        this.JSPJustificacion = new JScrollPane();
        this.JTJustificacion = new JTextPane();
        this.jPanel1 = new JPanel();
        this.JCH_Prioritaria = new JCheckBox();
        this.JCH_No_Prioritaria = new JCheckBox();
        this.jPanel2 = new JPanel();
        this.JCH_S_Urgencia = new JCheckBox();
        this.JCH_S_Prioritaria = new JCheckBox();
        this.JPI_Detalle = new JPanel();
        this.JPI_DatosProc = new JPanel();
        this.JTF_Codigo = new JTextField();
        this.JTF_NProcedimiento = new JTextField();
        this.JSP_Cantidad = new JSpinner();
        this.JBT_Adicionar = new JButton();
        this.JSPDetalleDoc = new JScrollPane();
        this.JTBDetalle = new JTable();
        this.JPI_Historico = new JPanel();
        this.JSPHistorico = new JScrollPane();
        this.JTHistorico = new JTable();
        setName("xjpi_formulaanexo3");
        this.JTPFomurlario.setForeground(Color.red);
        this.JTPFomurlario.setFont(new Font("Arial", 1, 14));
        this.JPI_InformacionEncabezado.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN ENCABEZADO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JPI_InformacionEncabezado.setLayout(new AbsoluteLayout());
        this.JCBEspecialidad.setFont(new Font("Arial", 1, 12));
        this.JCBEspecialidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Especialidad", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JCBEspecialidad.addItemListener(new ItemListener() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo3.1
            public void itemStateChanged(ItemEvent evt) {
                JPI_FormularioAnexo3.this.JCBEspecialidadItemStateChanged(evt);
            }
        });
        this.JPI_InformacionEncabezado.add(this.JCBEspecialidad, new AbsoluteConstraints(11, 70, 301, -1));
        this.JCBProfesional.setFont(new Font("Arial", 1, 12));
        this.JCBProfesional.setBorder(BorderFactory.createTitledBorder((Border) null, "Profesional", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JPI_InformacionEncabezado.add(this.JCBProfesional, new AbsoluteConstraints(324, 70, 368, -1));
        this.JTFCDxP.setFont(new Font("Arial", 1, 12));
        this.JTFCDxP.setBorder(BorderFactory.createTitledBorder((Border) null, "Cie10", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFCDxP.addFocusListener(new FocusAdapter() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo3.2
            public void focusLost(FocusEvent evt) {
                JPI_FormularioAnexo3.this.JTFCDxPFocusLost(evt);
            }
        });
        this.JTFCDxP.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo3.3
            public void keyPressed(KeyEvent evt) {
                JPI_FormularioAnexo3.this.JTFCDxPKeyPressed(evt);
            }
        });
        this.JPI_InformacionEncabezado.add(this.JTFCDxP, new AbsoluteConstraints(11, 114, 90, -1));
        this.JTFNCodigoDxP.setFont(new Font("Arial", 1, 12));
        this.JTFNCodigoDxP.setBorder(BorderFactory.createTitledBorder((Border) null, "Dx Principal", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFNCodigoDxP.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo3.4
            public void mouseClicked(MouseEvent evt) {
                JPI_FormularioAnexo3.this.JTFNCodigoDxPMouseClicked(evt);
            }
        });
        this.JTFNCodigoDxP.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo3.5
            public void keyPressed(KeyEvent evt) {
                JPI_FormularioAnexo3.this.JTFNCodigoDxPKeyPressed(evt);
            }
        });
        this.JPI_InformacionEncabezado.add(this.JTFNCodigoDxP, new AbsoluteConstraints(113, 114, 579, -1));
        this.JTFCDxR1.setFont(new Font("Arial", 1, 12));
        this.JTFCDxR1.addFocusListener(new FocusAdapter() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo3.6
            public void focusLost(FocusEvent evt) {
                JPI_FormularioAnexo3.this.JTFCDxR1FocusLost(evt);
            }
        });
        this.JTFCDxR1.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo3.7
            public void keyPressed(KeyEvent evt) {
                JPI_FormularioAnexo3.this.JTFCDxR1KeyPressed(evt);
            }
        });
        this.JPI_InformacionEncabezado.add(this.JTFCDxR1, new AbsoluteConstraints(11, 175, 90, -1));
        this.JTFNDxR1.setFont(new Font("Arial", 1, 12));
        this.JTFNDxR1.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo3.8
            public void mouseClicked(MouseEvent evt) {
                JPI_FormularioAnexo3.this.JTFNDxR1MouseClicked(evt);
            }
        });
        this.JTFNDxR1.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo3.9
            public void keyPressed(KeyEvent evt) {
                JPI_FormularioAnexo3.this.JTFNDxR1KeyPressed(evt);
            }
        });
        this.JPI_InformacionEncabezado.add(this.JTFNDxR1, new AbsoluteConstraints(107, 175, 585, -1));
        this.JTFCDxR2.setFont(new Font("Arial", 1, 12));
        this.JTFCDxR2.addFocusListener(new FocusAdapter() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo3.10
            public void focusLost(FocusEvent evt) {
                JPI_FormularioAnexo3.this.JTFCDxR2FocusLost(evt);
            }
        });
        this.JTFCDxR2.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo3.11
            public void keyPressed(KeyEvent evt) {
                JPI_FormularioAnexo3.this.JTFCDxR2KeyPressed(evt);
            }
        });
        this.JPI_InformacionEncabezado.add(this.JTFCDxR2, new AbsoluteConstraints(11, 201, 90, -1));
        this.JTFNDxR2.setFont(new Font("Arial", 1, 12));
        this.JTFNDxR2.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo3.12
            public void mouseClicked(MouseEvent evt) {
                JPI_FormularioAnexo3.this.JTFNDxR2MouseClicked(evt);
            }
        });
        this.JTFNDxR2.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo3.13
            public void keyPressed(KeyEvent evt) {
                JPI_FormularioAnexo3.this.JTFNDxR2KeyPressed(evt);
            }
        });
        this.JPI_InformacionEncabezado.add(this.JTFNDxR2, new AbsoluteConstraints(107, 201, 585, -1));
        this.jLabel1.setFont(new Font("Arial", 1, 12));
        this.jLabel1.setForeground(Color.red);
        this.jLabel1.setHorizontalAlignment(0);
        this.jLabel1.setText("DIAGNÓSTICO RELACIONADO");
        this.JPI_InformacionEncabezado.add(this.jLabel1, new AbsoluteConstraints(11, 155, 681, -1));
        this.JLB_NRegistro.setFont(new Font("Arial", 1, 14));
        this.JLB_NRegistro.setHorizontalAlignment(0);
        this.JLB_NRegistro.setBorder(BorderFactory.createTitledBorder((Border) null, "No.", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JPI_InformacionEncabezado.add(this.JLB_NRegistro, new AbsoluteConstraints(453, 19, 94, 45));
        this.JTFF_Hora.setBorder(BorderFactory.createTitledBorder((Border) null, "Hora", 0, 0, new Font("Arial", 1, 12), Color.blue));
        try {
            this.JTFF_Hora.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("##:##:##")));
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        this.JTFF_Hora.setHorizontalAlignment(4);
        this.JTFF_Hora.setToolTipText("Formato hh:mm p");
        this.JTFF_Hora.setFont(new Font("Arial", 1, 12));
        this.JTFF_Hora.addFocusListener(new FocusAdapter() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo3.14
            public void focusGained(FocusEvent evt) {
                JPI_FormularioAnexo3.this.JTFF_HoraFocusGained(evt);
            }
        });
        this.JTFF_Hora.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo3.15
            public void actionPerformed(ActionEvent evt) {
                JPI_FormularioAnexo3.this.JTFF_HoraActionPerformed(evt);
            }
        });
        this.JPI_InformacionEncabezado.add(this.JTFF_Hora, new AbsoluteConstraints(139, 19, 90, 45));
        this.JLB_NConsecutivo.setFont(new Font("Arial", 1, 14));
        this.JLB_NConsecutivo.setHorizontalAlignment(0);
        this.JLB_NConsecutivo.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Consecutivo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JPI_InformacionEncabezado.add(this.JLB_NConsecutivo, new AbsoluteConstraints(553, 19, 139, 45));
        this.jDateChooser1.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jDateChooser1.setDateFormatString("dd/MM/yyyy");
        this.jDateChooser1.setFont(new Font("Arial", 1, 12));
        this.JPI_InformacionEncabezado.add(this.jDateChooser1, new AbsoluteConstraints(11, 19, -1, 45));
        this.JTFNumeroAutorizacion.setFont(new Font("Arial", 1, 14));
        this.JTFNumeroAutorizacion.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Autorización", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNumeroAutorizacion.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo3.16
            public void keyPressed(KeyEvent evt) {
                JPI_FormularioAnexo3.this.JTFNumeroAutorizacionKeyPressed(evt);
            }
        });
        this.JPI_InformacionEncabezado.add(this.JTFNumeroAutorizacion, new AbsoluteConstraints(324, 22, 123, -1));
        this.JTPDatos.setForeground(Color.red);
        this.JTPDatos.setFont(new Font("Arial", 1, 14));
        this.JSPJustificacion.setForeground(UIManager.getDefaults().getColor("textHighlight"));
        this.JTJustificacion.setFont(new Font("Arial", 1, 12));
        this.JTJustificacion.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo3.17
            public void keyPressed(KeyEvent evt) {
                JPI_FormularioAnexo3.this.JTJustificacionKeyPressed(evt);
            }
        });
        this.JSPJustificacion.setViewportView(this.JTJustificacion);
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "PRIORIDAD", 2, 0, new Font("Arial", 1, 12), Color.red));
        this.JBG_Prioridad.add(this.JCH_Prioritaria);
        this.JCH_Prioritaria.setFont(new Font("Arial", 1, 12));
        this.JCH_Prioritaria.setText("Prioritaria");
        this.JCH_Prioritaria.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo3.18
            public void actionPerformed(ActionEvent evt) {
                JPI_FormularioAnexo3.this.JCH_PrioritariaActionPerformed(evt);
            }
        });
        this.JBG_Prioridad.add(this.JCH_No_Prioritaria);
        this.JCH_No_Prioritaria.setFont(new Font("Arial", 1, 12));
        this.JCH_No_Prioritaria.setSelected(true);
        this.JCH_No_Prioritaria.setText("No prioritaria");
        this.JCH_No_Prioritaria.setToolTipText("");
        this.JCH_No_Prioritaria.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo3.19
            public void actionPerformed(ActionEvent evt) {
                JPI_FormularioAnexo3.this.JCH_No_PrioritariaActionPerformed(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(21, 21, 21).addComponent(this.JCH_Prioritaria, -2, 118, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCH_No_Prioritaria, -2, 127, -2).addContainerGap(-1, 32767)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCH_Prioritaria).addComponent(this.JCH_No_Prioritaria)).addGap(0, 6, 32767)));
        this.jPanel2.setBorder(BorderFactory.createTitledBorder((Border) null, "TIPO ATENCION SOLICITADA", 2, 0, new Font("Arial", 1, 12), Color.red));
        this.JBG_TipoArencion.add(this.JCH_S_Urgencia);
        this.JCH_S_Urgencia.setFont(new Font("Arial", 1, 12));
        this.JCH_S_Urgencia.setSelected(true);
        this.JCH_S_Urgencia.setText("Posterior a la atención inicial de urgencias");
        this.JCH_S_Urgencia.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo3.20
            public void actionPerformed(ActionEvent evt) {
                JPI_FormularioAnexo3.this.JCH_S_UrgenciaActionPerformed(evt);
            }
        });
        this.JBG_TipoArencion.add(this.JCH_S_Prioritaria);
        this.JCH_S_Prioritaria.setFont(new Font("Arial", 1, 12));
        this.JCH_S_Prioritaria.setText("Servicios electivos ");
        this.JCH_S_Prioritaria.setToolTipText("");
        this.JCH_S_Prioritaria.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo3.21
            public void actionPerformed(ActionEvent evt) {
                JPI_FormularioAnexo3.this.JCH_S_PrioritariaActionPerformed(evt);
            }
        });
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JCH_S_Urgencia, -2, 274, -2).addGap(18, 18, 18).addComponent(this.JCH_S_Prioritaria, -2, 143, -2)));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCH_S_Urgencia).addComponent(this.JCH_S_Prioritaria)).addContainerGap(-1, 32767)));
        GroupLayout JPI_JustificacionLayout = new GroupLayout(this.JPI_Justificacion);
        this.JPI_Justificacion.setLayout(JPI_JustificacionLayout);
        JPI_JustificacionLayout.setHorizontalGroup(JPI_JustificacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_JustificacionLayout.createSequentialGroup().addContainerGap().addGroup(JPI_JustificacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPJustificacion, -1, 741, 32767).addGroup(JPI_JustificacionLayout.createSequentialGroup().addComponent(this.jPanel1, -2, 266, -2).addGap(18, 18, 18).addComponent(this.jPanel2, -1, -1, 32767))).addContainerGap()));
        JPI_JustificacionLayout.setVerticalGroup(JPI_JustificacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_JustificacionLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPJustificacion, -2, 144, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPI_JustificacionLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jPanel1, -2, -1, -2).addComponent(this.jPanel2, -2, -1, -2)).addContainerGap(18, 32767)));
        this.JTPDatos.addTab("JUSTIFICACIÓN", this.JPI_Justificacion);
        this.JPI_DatosProc.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS SERVICIO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTF_Codigo.setFont(new Font("Arial", 1, 12));
        this.JTF_Codigo.setBorder(BorderFactory.createTitledBorder((Border) null, "Código", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTF_Codigo.addFocusListener(new FocusAdapter() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo3.22
            public void focusLost(FocusEvent evt) {
                JPI_FormularioAnexo3.this.JTF_CodigoFocusLost(evt);
            }
        });
        this.JTF_Codigo.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo3.23
            public void keyPressed(KeyEvent evt) {
                JPI_FormularioAnexo3.this.JTF_CodigoKeyPressed(evt);
            }
        });
        this.JTF_NProcedimiento.setFont(new Font("Arial", 1, 12));
        this.JTF_NProcedimiento.setBorder(BorderFactory.createTitledBorder((Border) null, "Procedimiento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTF_NProcedimiento.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo3.24
            public void mouseClicked(MouseEvent evt) {
                JPI_FormularioAnexo3.this.JTF_NProcedimientoMouseClicked(evt);
            }
        });
        this.JSP_Cantidad.setFont(new Font("Arial", 1, 12));
        this.JSP_Cantidad.setModel(new SpinnerNumberModel(1, 1, (Comparable) null, 1));
        this.JSP_Cantidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Cant.", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSP_Cantidad.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo3.25
            public void keyPressed(KeyEvent evt) {
                JPI_FormularioAnexo3.this.JSP_CantidadKeyPressed(evt);
            }
        });
        this.JBT_Adicionar.setFont(new Font("Arial", 1, 12));
        this.JBT_Adicionar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBT_Adicionar.setText("Adicionar");
        this.JBT_Adicionar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo3.26
            public void actionPerformed(ActionEvent evt) {
                JPI_FormularioAnexo3.this.JBT_AdicionarActionPerformed(evt);
            }
        });
        this.JBT_Adicionar.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo3.27
            public void keyPressed(KeyEvent evt) {
                JPI_FormularioAnexo3.this.JBT_AdicionarKeyPressed(evt);
            }
        });
        GroupLayout JPI_DatosProcLayout = new GroupLayout(this.JPI_DatosProc);
        this.JPI_DatosProc.setLayout(JPI_DatosProcLayout);
        JPI_DatosProcLayout.setHorizontalGroup(JPI_DatosProcLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DatosProcLayout.createSequentialGroup().addContainerGap().addComponent(this.JTF_Codigo, -2, 102, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTF_NProcedimiento, -2, 398, -2).addGap(18, 18, 18).addComponent(this.JSP_Cantidad, -2, 60, -2).addGap(18, 18, 18).addComponent(this.JBT_Adicionar, -1, -1, 32767).addContainerGap()));
        JPI_DatosProcLayout.setVerticalGroup(JPI_DatosProcLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DatosProcLayout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(JPI_DatosProcLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(GroupLayout.Alignment.TRAILING, JPI_DatosProcLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTF_NProcedimiento, -2, -1, -2).addComponent(this.JTF_Codigo, -2, -1, -2)).addComponent(this.JSP_Cantidad, -1, -1, -2).addComponent(this.JBT_Adicionar, -1, -1, 32767)).addContainerGap()));
        this.JSPDetalleDoc.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTBDetalle.setFont(new Font("Arial", 1, 12));
        this.JTBDetalle.setRowHeight(25);
        this.JTBDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTBDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTBDetalle.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo3.28
            public void keyPressed(KeyEvent evt) {
                JPI_FormularioAnexo3.this.JTBDetalleKeyPressed(evt);
            }
        });
        this.JSPDetalleDoc.setViewportView(this.JTBDetalle);
        GroupLayout JPI_DetalleLayout = new GroupLayout(this.JPI_Detalle);
        this.JPI_Detalle.setLayout(JPI_DetalleLayout);
        JPI_DetalleLayout.setHorizontalGroup(JPI_DetalleLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 0, 32767).addGroup(JPI_DetalleLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DetalleLayout.createSequentialGroup().addContainerGap().addGroup(JPI_DetalleLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JPI_DatosProc, -1, -1, -2).addComponent(this.JSPDetalleDoc)).addContainerGap(-1, 32767))));
        JPI_DetalleLayout.setVerticalGroup(JPI_DetalleLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 0, 32767).addGroup(JPI_DetalleLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DetalleLayout.createSequentialGroup().addContainerGap().addComponent(this.JPI_DatosProc, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPDetalleDoc, -2, 113, -2).addContainerGap(-1, 32767))));
        this.JTPDatos.addTab("PROCEDIMIENTO", this.JPI_Detalle);
        GroupLayout JPI_DatosAnexoLayout = new GroupLayout(this.JPI_DatosAnexo);
        this.JPI_DatosAnexo.setLayout(JPI_DatosAnexoLayout);
        JPI_DatosAnexoLayout.setHorizontalGroup(JPI_DatosAnexoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DatosAnexoLayout.createSequentialGroup().addContainerGap().addGroup(JPI_DatosAnexoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTPDatos, -2, 753, -2).addComponent(this.JPI_InformacionEncabezado, -2, 739, -2)).addContainerGap(36, 32767)));
        JPI_DatosAnexoLayout.setVerticalGroup(JPI_DatosAnexoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DatosAnexoLayout.createSequentialGroup().addContainerGap().addComponent(this.JPI_InformacionEncabezado, -2, 233, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTPDatos, -2, 251, -2).addContainerGap(25, 32767)));
        this.JTPFomurlario.addTab("DATOS ANEXO", this.JPI_DatosAnexo);
        this.JSPHistorico.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo3.29
            public void keyPressed(KeyEvent evt) {
                JPI_FormularioAnexo3.this.JSPHistoricoKeyPressed(evt);
            }
        });
        this.JTHistorico.setFont(new Font("Arial", 1, 12));
        this.JTHistorico.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTHistorico.setSelectionBackground(Color.white);
        this.JTHistorico.setSelectionForeground(Color.red);
        this.JTHistorico.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo3.30
            public void mouseClicked(MouseEvent evt) {
                JPI_FormularioAnexo3.this.JTHistoricoMouseClicked(evt);
            }
        });
        this.JSPHistorico.setViewportView(this.JTHistorico);
        GroupLayout JPI_HistoricoLayout = new GroupLayout(this.JPI_Historico);
        this.JPI_Historico.setLayout(JPI_HistoricoLayout);
        JPI_HistoricoLayout.setHorizontalGroup(JPI_HistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPHistorico, -2, 790, -2));
        JPI_HistoricoLayout.setVerticalGroup(JPI_HistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPHistorico, -2, 521, -2));
        this.JTPFomurlario.addTab("HISTÓRICO", this.JPI_Historico);
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTPFomurlario, -2, 795, -2).addContainerGap(21, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTPFomurlario, -1, -1, -2).addContainerGap()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBEspecialidadItemStateChanged(ItemEvent evt) {
        if (this.estadoLlenadoCombos.booleanValue() && this.JCBEspecialidad.getSelectedIndex() != -1) {
            llenarComboProfesional();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCDxPFocusLost(FocusEvent evt) {
        buscarPatologias(this.JTFCDxP, this.JTFNCodigoDxP);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCDxPKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JTFCDxP.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNCodigoDxPMouseClicked(MouseEvent evt) {
        this.historiaCE.buscarPatologiaNombre(this.JTFCDxP, this.JTFNCodigoDxP, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNCodigoDxPKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JTFNCodigoDxP.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCDxR1FocusLost(FocusEvent evt) {
        buscarPatologias(this.JTFCDxR1, this.JTFNDxR1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCDxR1KeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JTFCDxR1.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNDxR1MouseClicked(MouseEvent evt) {
        this.historiaCE.buscarPatologiaNombre(this.JTFCDxR1, this.JTFNDxR1, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNDxR1KeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JTFNDxR1.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCDxR2FocusLost(FocusEvent evt) {
        buscarPatologias(this.JTFCDxR2, this.JTFNDxR2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCDxR2KeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JTFCDxR2.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNDxR2MouseClicked(MouseEvent evt) {
        this.historiaCE.buscarPatologiaNombre(this.JTFCDxR2, this.JTFNDxR2, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNDxR2KeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JTFNDxR2.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTF_CodigoFocusLost(FocusEvent evt) {
        if (!this.JTF_Codigo.getText().isEmpty()) {
            buscarCodigoDelProcedimiento();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTF_CodigoKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10 && !this.JTF_Codigo.getText().isEmpty()) {
            this.JSP_Cantidad.requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTF_NProcedimientoMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            BuscarProced frmBuscarProced = new BuscarProced((Frame) null, true, (JPanel) this, "xjpi_formulaanexo3");
            frmBuscarProced.setVisible(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JSP_CantidadKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JBT_Adicionar.requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_AdicionarActionPerformed(ActionEvent evt) {
        if (this.JLB_NRegistro.getText().isEmpty()) {
            adicionar();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_AdicionarKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            adicionar();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBDetalleKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 127) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de eliminar este registro?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                this.modeloDetalleProcedimiento.removeRow(this.JTBDetalle.getSelectedRow());
                this.JTF_Codigo.requestFocus();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFF_HoraActionPerformed(ActionEvent evt) {
        this.jDateChooser1.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFF_HoraFocusGained(FocusEvent evt) {
        this.JTFF_Hora.selectAll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTHistoricoMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2 && this.JTHistorico.getSelectedRow() != -1) {
            this.JLB_NRegistro.setText(this.modeloHistorico.getValueAt(this.JTHistorico.getSelectedRow(), 0).toString());
            this.JLB_NConsecutivo.setText(this.modeloHistorico.getValueAt(this.JTHistorico.getSelectedRow(), 2).toString());
            this.jDateChooser1.setDate(Date.valueOf(this.modeloHistorico.getValueAt(this.JTHistorico.getSelectedRow(), 3).toString()));
            this.JTFF_Hora.setText(this.modeloHistorico.getValueAt(this.JTHistorico.getSelectedRow(), 4).toString());
            this.JTJustificacion.setText(this.modeloHistorico.getValueAt(this.JTHistorico.getSelectedRow(), 5).toString());
            this.JCBEspecialidad.setSelectedItem(this.modeloHistorico.getValueAt(this.JTHistorico.getSelectedRow(), 7).toString());
            this.JCBProfesional.setSelectedItem(this.modeloHistorico.getValueAt(this.JTHistorico.getSelectedRow(), 6).toString());
            this.JTFCDxP.setText(this.modeloHistorico.getValueAt(this.JTHistorico.getSelectedRow(), 8).toString());
            JTFCDxPFocusLost(null);
            this.JTFCDxR1.setText(this.modeloHistorico.getValueAt(this.JTHistorico.getSelectedRow(), 9).toString());
            JTFCDxR1FocusLost(null);
            this.JTFCDxR2.setText(this.modeloHistorico.getValueAt(this.JTHistorico.getSelectedRow(), 10).toString());
            JTFCDxR2FocusLost(null);
            llenaTablaDeDetalleProcedimientos();
            this.JTPFomurlario.setSelectedIndex(0);
            this.JTFNumeroAutorizacion.setText(this.modeloHistorico.getValueAt(this.JTHistorico.getSelectedRow(), 11).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTJustificacionKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 9) {
            this.JTJustificacion.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JSPHistoricoKeyPressed(KeyEvent evt) {
        System.out.println("esto actualiza con enter- scroll");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNumeroAutorizacionKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10 && !this.JLB_NRegistro.getText().trim().isEmpty() && JOptionPane.showConfirmDialog(this, "Está seguro de cambiar el numero de Autorización.  ", "Modificar", 1, 3, new ImageIcon(getClass().getResource("/Imagenes/Question.png"))) == 0) {
            OrdenesAnexo3DetalleDTO anexo = new OrdenesAnexo3DetalleDTO();
            anexo.setIdOrdenAnexo(Long.valueOf(Long.parseLong(this.JLB_NRegistro.getText())));
            anexo.setNumeroAutorizacion(this.JTFNumeroAutorizacion.getText());
            String validarUpdate = this.ordenAnexo3DAO.mUpdateAnexo3(anexo);
            if (validarUpdate.equals("0")) {
                JOptionPane.showInternalMessageDialog(this, "No se puego guardar", "ERROR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            }
            llenaTablaHistorico();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_PrioritariaActionPerformed(ActionEvent evt) {
        this.prioridad = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_No_PrioritariaActionPerformed(ActionEvent evt) {
        this.prioridad = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_S_UrgenciaActionPerformed(ActionEvent evt) {
        this.tipoAtencion = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_S_PrioritariaActionPerformed(ActionEvent evt) {
        this.tipoAtencion = 0;
    }

    private void springStart() {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"});
        this.informacionProfesionalDAO = (InformacionProfesionalDAOImpl) classPathXmlApplicationContext.getBean("informacionProfesionalDAOImpl");
        this.facturacionDAO = (FacturacionDAOImp) classPathXmlApplicationContext.getBean("facturacionDAOImp");
        this.ordenAnexo3DAO = (OrdenAnexo3DAOImpl) classPathXmlApplicationContext.getBean("ordenAnexo3DAO");
        this.patologiaCie10DAO = (PatologiaCie10DAOImpl) classPathXmlApplicationContext.getBean("patologiaCie10DAOImpl");
    }

    public void nuevo() {
        this.jDateChooser1.setDate(this.metodos.getFechaActual());
        this.JLB_NRegistro.setText("");
        this.JLB_NConsecutivo.setText("");
        this.estadoLlenadoCombos = false;
        this.JCBProfesional.removeAllItems();
        llenarComboEspecialidad();
        this.estadoLlenadoCombos = true;
        llenaDatosDeLaAtencion();
        crearModeloDatosDetalle();
        llenaTablaHistorico();
        this.JCH_No_Prioritaria.setSelected(true);
        this.prioridad = 1;
        this.JCH_S_Urgencia.setSelected(true);
        this.tipoAtencion = 1;
    }

    public void grabar() {
        if (this.JLB_NRegistro.getText().isEmpty()) {
            if (this.JCBEspecialidad.getSelectedIndex() != -1) {
                if (this.JCBProfesional.getSelectedIndex() != -1) {
                    if (!this.JTFCDxP.getText().isEmpty()) {
                        if (this.JTBDetalle.getRowCount() != 0) {
                            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                            if (n == 0) {
                                OrdenAnexo3DTO encabezado = new OrdenAnexo3DTO();
                                encabezado.setIdIngreso(Long.valueOf(this.idIngreso));
                                encabezado.setIdOrden(0L);
                                encabezado.setIdAteAnexo3(obtenerConsecutivoDelDia());
                                encabezado.setFechaR(this.metodos.formatoAMD1.format(this.jDateChooser1.getDate()));
                                encabezado.setHoraR(this.JTFF_Hora.getText());
                                encabezado.setJustificacion(this.JTJustificacion.getText());
                                encabezado.setDxP(this.JTFCDxP.getText());
                                encabezado.setDxR1(this.JTFCDxR1.getText());
                                encabezado.setDxR2(this.JTFCDxR2.getText());
                                encabezado.setTipoAtencion(this.tipoAtencion);
                                encabezado.setTipoPrioridad(this.prioridad);
                                encabezado.setIdProfesional(Long.valueOf(this.idProfesional[this.JCBProfesional.getSelectedIndex()]));
                                encabezado.setIdEspecialidad(Long.valueOf(this.idEspecialidad[this.JCBEspecialidad.getSelectedIndex()]));
                                String xidDoc = this.ordenAnexo3DAO.create_return_id_Anexo3(encabezado);
                                this.JLB_NRegistro.setText(xidDoc);
                                this.JLB_NConsecutivo.setText(encabezado.getIdAteAnexo3().toString());
                                for (int fila = 0; fila < this.JTBDetalle.getRowCount(); fila++) {
                                    OrdenesAnexo3DetalleDTO detalleAnexo = new OrdenesAnexo3DetalleDTO();
                                    detalleAnexo.setIdOrdenAnexo(Long.valueOf(xidDoc));
                                    detalleAnexo.setIdProcedimiento(Long.valueOf(this.modeloDetalleProcedimiento.getValueAt(fila, 3).toString()));
                                    detalleAnexo.setCantidad(Integer.valueOf(this.modeloDetalleProcedimiento.getValueAt(fila, 2).toString()).intValue());
                                    detalleAnexo.setNumeroAutorizacion(this.JTFNumeroAutorizacion.getText());
                                    this.ordenAnexo3DAO.mcreate(detalleAnexo);
                                }
                                llenaTablaHistorico();
                                return;
                            }
                            return;
                        }
                        JOptionPane.showInternalMessageDialog(this, "debe haber al menos un procedimiento adicionado", "VALIDAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        return;
                    }
                    JOptionPane.showInternalMessageDialog(this, "debe digitar al menos un Diagnostico Principal", "VALIDAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "debe seleccionar un profesional", "VALIDAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "debe seleccionar una especialidad", "VALIDAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Este registro ya se encuentra grabado", "VALIDAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    public void imprimir() {
        if (!this.JLB_NRegistro.getText().isEmpty()) {
            ReporteAnexo3_Fac_SinOrden x = new ReporteAnexo3_Fac_SinOrden(this.JLB_NRegistro.getText(), 0, this.JLB_NConsecutivo.getText());
            x.build();
            this.metodos.mostrarPdf(this.metodos.getRutaRep() + "H_Anexo3_Orden.pdf");
        }
    }

    private void llenarComboEspecialidad() {
        this.JCBEspecialidad.removeAllItems();
        List<Object[]> listadoEspecialidad = this.informacionProfesionalDAO.listadoEspecialidadConProfesional();
        if (!listadoEspecialidad.isEmpty()) {
            this.idEspecialidad = new String[listadoEspecialidad.size()];
            for (int i = 0; i < listadoEspecialidad.size(); i++) {
                this.idEspecialidad[i] = listadoEspecialidad.get(i)[0].toString();
                this.JCBEspecialidad.addItem(listadoEspecialidad.get(i)[1].toString());
            }
            this.JCBEspecialidad.setSelectedIndex(-1);
        }
    }

    private void llenarComboProfesional() {
        this.JCBProfesional.removeAllItems();
        List<Object[]> listadoProfesional = this.informacionProfesionalDAO.listadoProfesionalFiltradoPorEspecialidad(this.idEspecialidad[this.JCBEspecialidad.getSelectedIndex()]);
        if (!listadoProfesional.isEmpty()) {
            this.idProfesional = new String[listadoProfesional.size()];
            for (int i = 0; i < listadoProfesional.size(); i++) {
                this.idProfesional[i] = listadoProfesional.get(i)[0].toString();
                this.JCBProfesional.addItem(listadoProfesional.get(i)[1].toString());
            }
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearModeloDatosHistorico() {
        this.modeloHistorico = new DefaultTableModel(new Object[0], new String[]{"Id", "IdIngreso", "Consecutivo", "Fecha", "Hora", "Justificacion", "Profesional", "Especialidad", "DxP", "DxR1", "DxR2", "No. Autorizacion", "idOrdenDetalle"}) { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo3.31
            Class[] types = {Long.class, Long.class, Long.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTHistorico;
        JTable jTable2 = this.JTHistorico;
        jTable.setAutoResizeMode(0);
        this.JTHistorico.doLayout();
        this.JTHistorico.setModel(this.modeloHistorico);
        this.JTHistorico.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.JTHistorico.getColumnModel().getColumn(1).setPreferredWidth(80);
        this.JTHistorico.getColumnModel().getColumn(2).setPreferredWidth(50);
        this.JTHistorico.getColumnModel().getColumn(3).setPreferredWidth(80);
        this.JTHistorico.getColumnModel().getColumn(5).setPreferredWidth(0);
        this.JTHistorico.getColumnModel().getColumn(5).setMinWidth(0);
        this.JTHistorico.getColumnModel().getColumn(5).setMaxWidth(0);
        this.JTHistorico.getColumnModel().getColumn(6).setPreferredWidth(200);
        this.JTHistorico.getColumnModel().getColumn(7).setPreferredWidth(200);
        this.JTHistorico.getColumnModel().getColumn(8).setPreferredWidth(0);
        this.JTHistorico.getColumnModel().getColumn(8).setMinWidth(0);
        this.JTHistorico.getColumnModel().getColumn(8).setMaxWidth(0);
        this.JTHistorico.getColumnModel().getColumn(9).setPreferredWidth(0);
        this.JTHistorico.getColumnModel().getColumn(9).setMinWidth(0);
        this.JTHistorico.getColumnModel().getColumn(9).setMaxWidth(0);
        this.JTHistorico.getColumnModel().getColumn(10).setPreferredWidth(0);
        this.JTHistorico.getColumnModel().getColumn(10).setMinWidth(0);
        this.JTHistorico.getColumnModel().getColumn(10).setMaxWidth(0);
        this.JTHistorico.getColumnModel().getColumn(11).setPreferredWidth(80);
        this.JTHistorico.getColumnModel().getColumn(12).setPreferredWidth(0);
        this.JTHistorico.getColumnModel().getColumn(12).setMinWidth(0);
        this.JTHistorico.getColumnModel().getColumn(12).setMaxWidth(0);
    }

    private void llenaTablaHistorico() {
        crearModeloDatosHistorico();
        List<Object[]> listaHistoricoAnexo = this.ordenAnexo3DAO.listadoDeAnexos(this.idIngreso);
        if (!listaHistoricoAnexo.isEmpty()) {
            for (int fila = 0; fila < listaHistoricoAnexo.size(); fila++) {
                this.modeloHistorico.addRow(this.dato);
                this.modeloHistorico.setValueAt(listaHistoricoAnexo.get(fila)[0], fila, 0);
                this.modeloHistorico.setValueAt(listaHistoricoAnexo.get(fila)[1], fila, 1);
                this.modeloHistorico.setValueAt(listaHistoricoAnexo.get(fila)[2], fila, 2);
                this.modeloHistorico.setValueAt(listaHistoricoAnexo.get(fila)[3], fila, 3);
                this.modeloHistorico.setValueAt(listaHistoricoAnexo.get(fila)[4], fila, 4);
                this.modeloHistorico.setValueAt(listaHistoricoAnexo.get(fila)[5], fila, 5);
                this.modeloHistorico.setValueAt(listaHistoricoAnexo.get(fila)[6], fila, 6);
                this.modeloHistorico.setValueAt(listaHistoricoAnexo.get(fila)[7], fila, 7);
                this.modeloHistorico.setValueAt(listaHistoricoAnexo.get(fila)[8], fila, 8);
                this.modeloHistorico.setValueAt(listaHistoricoAnexo.get(fila)[9], fila, 9);
                this.modeloHistorico.setValueAt(listaHistoricoAnexo.get(fila)[10], fila, 10);
                this.modeloHistorico.setValueAt(listaHistoricoAnexo.get(fila)[11], fila, 11);
                this.modeloHistorico.setValueAt(listaHistoricoAnexo.get(fila)[12], fila, 12);
            }
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearModeloDatosDetalle() {
        this.modeloDetalleProcedimiento = new DefaultTableModel(new Object[0], new String[]{"Id", "Procedimiento", "Cantidad", "IdProcedimiento"}) { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo3.32
            Class[] types = {Long.class, String.class, Long.class, Long.class};
            boolean[] canEdit = {false, false, true, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTBDetalle;
        JTable jTable2 = this.JTBDetalle;
        jTable.setAutoResizeMode(0);
        this.JTBDetalle.doLayout();
        this.JTBDetalle.setModel(this.modeloDetalleProcedimiento);
        this.JTBDetalle.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTBDetalle.getColumnModel().getColumn(1).setPreferredWidth(550);
        this.JTBDetalle.getColumnModel().getColumn(2).setPreferredWidth(50);
        this.JTBDetalle.getColumnModel().getColumn(3).setPreferredWidth(50);
    }

    private void llenaTablaDeDetalleProcedimientos() {
        crearModeloDatosDetalle();
        List<Object[]> listaDetalleProcedimiento = this.ordenAnexo3DAO.listadoDeProcedimientosAnexo(this.JLB_NRegistro.getText());
        if (!listaDetalleProcedimiento.isEmpty()) {
            for (int fila = 0; fila < listaDetalleProcedimiento.size(); fila++) {
                this.modeloDetalleProcedimiento.addRow(this.dato);
                this.modeloDetalleProcedimiento.setValueAt(listaDetalleProcedimiento.get(fila)[0], fila, 0);
                this.modeloDetalleProcedimiento.setValueAt(listaDetalleProcedimiento.get(fila)[1], fila, 1);
                this.modeloDetalleProcedimiento.setValueAt(listaDetalleProcedimiento.get(fila)[2], fila, 2);
                this.modeloDetalleProcedimiento.setValueAt(listaDetalleProcedimiento.get(fila)[1], fila, 3);
            }
        }
    }

    private void llenaDatosDeLaAtencion() {
        List<Object[]> listaAtencion = this.ordenAnexo3DAO.listadoDeDatosDeLaAtencion(this.idIngreso);
        if (!listaAtencion.isEmpty()) {
            System.out.println("" + this.metodos.getPasarTextoAFecha(listaAtencion.get(0)[0].toString()));
            System.out.println("" + listaAtencion.get(0)[0].toString());
            this.jDateChooser1.setDate(this.metodos.getPasarTextoAFecha(listaAtencion.get(0)[0].toString()));
            this.JTFF_Hora.setValue(listaAtencion.get(0)[1].toString());
            this.JTJustificacion.setText(listaAtencion.get(0)[2].toString());
            this.JTFCDxP.setText(listaAtencion.get(0)[3].toString());
            this.JTFNCodigoDxP.setText(listaAtencion.get(0)[4].toString());
            this.JTFCDxR1.setText(listaAtencion.get(0)[5].toString());
            this.JTFNDxR1.setText(listaAtencion.get(0)[6].toString());
            this.JTFCDxR2.setText(listaAtencion.get(0)[7].toString());
            this.JTFNDxR2.setText(listaAtencion.get(0)[8].toString());
            this.JCBProfesional.setSelectedItem(listaAtencion.get(0)[9].toString());
            this.JCBEspecialidad.setSelectedItem(listaAtencion.get(0)[10].toString());
            return;
        }
        this.jDateChooser1.setDate(this.metodos.getFechaActual());
        this.JTFF_Hora.setValue(this.metodos.formatoH24.format(this.metodos.getFechaActual()));
        this.JTFCDxP.setText("");
        this.JTFCDxR1.setText("");
        this.JTFCDxR2.setText("");
        this.JTFNCodigoDxP.setText("");
        this.JTFNDxR1.setText("");
        this.JTFNDxR2.setText("");
        this.JTJustificacion.setText("");
    }

    public void cargarDatosGestionServicios(List<OrdenProcedimientoProjection> list) {
        if (!list.isEmpty() || list != null) {
            this.JCBEspecialidad.setSelectedItem(list.get(0).getEspecialidad());
            this.JCBProfesional.setSelectedItem(list.get(0).getProfesional());
            this.JTJustificacion.setText(list.get(0).getJustificacion());
            this.JTFCDxP.setText(list.get(0).getDiagnosticoP());
            this.JTFCDxP.requestFocus();
            this.JTFCDxP.transferFocus();
            this.JTFCDxR1.setText(list.get(0).getDiagnosticoR1());
            this.JTFCDxR1.requestFocus();
            this.JTFCDxR1.transferFocus();
            this.JTFCDxR2.setText(list.get(0).getDiagnosticoR2());
            this.JTFCDxR2.requestFocus();
            this.JTFCDxR2.transferFocus();
            list.forEach(e -> {
                this.JTF_Codigo.setText("" + e.getCups());
                this.JTF_Codigo.transferFocus();
                this.JTF_NProcedimiento.setText(e.getNombreCups());
                this.JSP_Cantidad.setValue(e.getCantidad());
                adicionar();
            });
        }
    }

    private void buscarCodigoDelProcedimiento() {
        List<GenericoDTO> list = this.facturacionDAO.listProcedimiento(this.JTF_Codigo.getText());
        this.idProcedimiento = 0L;
        if (!list.isEmpty()) {
            this.JTF_Codigo.setText(list.get(0).getCodigo());
            this.JTF_NProcedimiento.setText(list.get(0).getNombre());
            this.idProcedimiento = list.get(0).getId();
        } else {
            this.JTF_Codigo.setText("");
            this.JTF_NProcedimiento.setText("");
            this.JTF_Codigo.requestFocus();
        }
    }

    private Long obtenerConsecutivoDelDia() {
        long consecutivo = 1;
        List<OrdenAnexo3DTO> listaConsecutivo = this.ordenAnexo3DAO.obtieneElConsecutivoDelDia(this.metodos.formatoAMD1.format(this.jDateChooser1.getDate()));
        if (!listaConsecutivo.isEmpty()) {
            for (OrdenAnexo3DTO ordenAnexo3DTO : listaConsecutivo) {
                consecutivo = listaConsecutivo.get(0).getIdAteAnexo3().longValue();
            }
        }
        return Long.valueOf(consecutivo);
    }

    private void adicionar() {
        if (this.JLB_NRegistro.getText().isEmpty()) {
            if (!this.JTF_Codigo.getText().isEmpty()) {
                if (!this.JTF_NProcedimiento.getText().isEmpty()) {
                    if (!this.metodos.mVerificarDatosDoblesTabla(this.JTBDetalle, 0, this.JTF_Codigo.getText())) {
                        this.xnfila = this.JTBDetalle.getRowCount();
                        this.modeloDetalleProcedimiento.addRow(this.dato);
                        this.modeloDetalleProcedimiento.setValueAt(this.JTF_Codigo.getText(), this.xnfila, 0);
                        this.modeloDetalleProcedimiento.setValueAt(this.JTF_NProcedimiento.getText(), this.xnfila, 1);
                        this.modeloDetalleProcedimiento.setValueAt(this.JSP_Cantidad.getValue(), this.xnfila, 2);
                        this.modeloDetalleProcedimiento.setValueAt(this.idProcedimiento, this.xnfila, 3);
                        this.JTF_Codigo.setText("");
                        this.JTF_NProcedimiento.setText("");
                        this.JSP_Cantidad.setValue(1);
                        this.JTF_Codigo.requestFocus();
                        return;
                    }
                    JOptionPane.showInternalMessageDialog(this, "El codigo ya se encuentra en la tabla", "VALIDAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    this.JTF_Codigo.requestFocus();
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "El codigo no puede estar en blanco", "VALIDAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JTF_Codigo.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "El codigo no puede estar en blanco", "VALIDAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTF_Codigo.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "El registro ya se encuentra grabada", "VALIDAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    private void buscarPatologias(JTextField codigo, JTextField nombre) {
        PatologiaCie10DTO patologiaCie10DTO;
        if (!codigo.getText().isEmpty() && (patologiaCie10DTO = this.patologiaCie10DAO.patologiaFiltrada(codigo.getText(), -1)) != null) {
            codigo.setText(patologiaCie10DTO.getId());
            nombre.setText(patologiaCie10DTO.getNombre());
        }
    }
}
