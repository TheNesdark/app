package Cirugia;

import Acceso.Principal;
import Citas.CalendarioGral;
import Facturacion.BuscarProced;
import General.Anular;
import General.BuscarPersona;
import General.JIFBuscarPatologia;
import General.Persona;
import ParametrizacionN.JDProcedimientoxSum;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.genoma.plus.jpa.projection.GenericCombo;
import com.genoma.plus.jpa.service.IClaseCitaService;
import java.awt.Color;
import java.awt.Component;
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
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JTree;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

/* JADX INFO: loaded from: GenomaP.jar:Cirugia/JIF_Programacion_Cx.class */
public class JIF_Programacion_Cx extends JInternalFrame {
    public Persona xjp_Persona;
    private String xsql;
    private String xnombre;
    private String[][] xId_Procedimiento;
    public String[] xId_Empresa;
    private CalendarioGral frmCalendario;
    public Object[] nodos;
    public Object[] dato;
    private DefaultTableModel xmodelo;
    private List<GenericCombo> listaClaseCitas;
    private ButtonGroup JBG_Cancela;
    private ButtonGroup JBG_Filtro;
    private JButton JBT_AdicionarSP;
    private JButton JBT_Indicaciones;
    private JButton JBT_RIngreso;
    public JComboBox JCB_ClaseCita;
    public JComboBox JCB_Empresa;
    public JComboBox JCb_Procedimiento;
    private JPanel JPICalendario;
    private JPanel JPI_Cancela;
    private JPanel JPI_DEmpresa;
    private JPanel JPI_DProcedimientos;
    private JPanel JPI_EPSalas;
    private JPanel JPI_Otros;
    private JPanel JPI_Persona;
    private JRadioButton JRB_No;
    private JRadioButton JRB_Si;
    private JScrollPane JSPObservacion;
    private JScrollPane JSP_Arbol;
    private JScrollPane JSP_Detalle;
    private JTable JTB_Detalle;
    public JTree JTE_Arbol;
    public JTextField JTFFCodigoPat;
    public JTextField JTFFNombrePat;
    public JFormattedTextField JTFF_Duracion;
    public JTextField JTF_NAutorizacion;
    private JTabbedPane JTP_Datos;
    private JTextPane JTP_Observacion;
    private Metodos xmt = new Metodos();
    private ConsultasMySQL xct = new ConsultasMySQL();
    public boolean xlleno = false;
    public boolean xlleno1 = false;
    public String[][] listaPacientesConCita = new String[0][0];
    private int xNfila = -1;
    private int xCancela = 0;
    private ImageIcon rootIcon = new ImageIcon(getClass().getResource("/Imagenes/AgendaMedica.png"));
    private ImageIcon especialidadIcon = new ImageIcon(getClass().getResource("/Imagenes/Especialidad_16.png"));
    private ImageIcon medicoIcon = new ImageIcon(getClass().getResource("/Imagenes/Profesiona_16x20.png"));
    SimpleDateFormat ft24 = new SimpleDateFormat("HH:mm");
    SimpleDateFormat ft12 = new SimpleDateFormat("hh:mm a");
    private final IClaseCitaService claseCitaService = (IClaseCitaService) Principal.contexto.getBean(IClaseCitaService.class);

    public JIF_Programacion_Cx(String xnombre, String xnombref) {
        initComponents();
        setName(xnombref);
        this.xnombre = xnombre;
        this.JTE_Arbol.setCellRenderer(new MyTreeCellRenderer());
        mCargarPanelPersonas();
        mNuevo_Inicio();
    }

    /* JADX WARN: Type inference failed for: r3v21, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBG_Filtro = new ButtonGroup();
        this.JBG_Cancela = new ButtonGroup();
        this.JPI_Persona = new JPanel();
        this.JPI_EPSalas = new JPanel();
        this.JSP_Arbol = new JScrollPane();
        this.JTE_Arbol = new JTree();
        this.JSP_Detalle = new JScrollPane();
        this.JTB_Detalle = new JTable();
        this.JTP_Datos = new JTabbedPane();
        this.JPI_DProcedimientos = new JPanel();
        this.JCb_Procedimiento = new JComboBox();
        this.JTFF_Duracion = new JFormattedTextField();
        this.JSPObservacion = new JScrollPane();
        this.JTP_Observacion = new JTextPane();
        this.JPI_DEmpresa = new JPanel();
        this.JCB_Empresa = new JComboBox();
        this.JTF_NAutorizacion = new JTextField();
        this.JPI_Cancela = new JPanel();
        this.JRB_Si = new JRadioButton();
        this.JRB_No = new JRadioButton();
        this.JCB_ClaseCita = new JComboBox();
        this.JPI_Otros = new JPanel();
        this.JTFFCodigoPat = new JTextField();
        this.JTFFNombrePat = new JTextField();
        this.JPICalendario = new JPanel();
        this.JBT_Indicaciones = new JButton();
        this.JBT_AdicionarSP = new JButton();
        this.JBT_RIngreso = new JButton();
        setClosable(true);
        setIconifiable(true);
        setTitle("PROGRAMACIÓN CIRUGÍAS");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("");
        this.JPI_Persona.setMaximumSize(new Dimension(1000, 160));
        this.JPI_Persona.setMinimumSize(new Dimension(1000, 160));
        GroupLayout JPI_PersonaLayout = new GroupLayout(this.JPI_Persona);
        this.JPI_Persona.setLayout(JPI_PersonaLayout);
        JPI_PersonaLayout.setHorizontalGroup(JPI_PersonaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 0, 32767));
        JPI_PersonaLayout.setVerticalGroup(JPI_PersonaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 178, 32767));
        this.JPI_EPSalas.setBorder(BorderFactory.createEtchedBorder());
        this.JPI_EPSalas.setMaximumSize(new Dimension(1000, 160));
        this.JPI_EPSalas.setMinimumSize(new Dimension(1000, 160));
        this.JTE_Arbol.setFont(new Font("Arial", 1, 11));
        this.JTE_Arbol.setName("JTE_Arbol");
        this.JTE_Arbol.addTreeSelectionListener(new TreeSelectionListener() { // from class: Cirugia.JIF_Programacion_Cx.1
            public void valueChanged(TreeSelectionEvent evt) {
                JIF_Programacion_Cx.this.JTE_ArbolValueChanged(evt);
            }
        });
        this.JSP_Arbol.setViewportView(this.JTE_Arbol);
        GroupLayout JPI_EPSalasLayout = new GroupLayout(this.JPI_EPSalas);
        this.JPI_EPSalas.setLayout(JPI_EPSalasLayout);
        JPI_EPSalasLayout.setHorizontalGroup(JPI_EPSalasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_EPSalasLayout.createSequentialGroup().addContainerGap().addComponent(this.JSP_Arbol, -2, 283, -2).addContainerGap(-1, 32767)));
        JPI_EPSalasLayout.setVerticalGroup(JPI_EPSalasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPI_EPSalasLayout.createSequentialGroup().addContainerGap().addComponent(this.JSP_Arbol, -1, 285, 32767).addContainerGap()));
        this.JTB_Detalle.setFont(new Font("Arial", 1, 12));
        this.JTB_Detalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTB_Detalle.setRowHeight(25);
        this.JTB_Detalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTB_Detalle.setSelectionForeground(Color.red);
        this.JTB_Detalle.addMouseListener(new MouseAdapter() { // from class: Cirugia.JIF_Programacion_Cx.2
            public void mouseClicked(MouseEvent evt) {
                JIF_Programacion_Cx.this.JTB_DetalleMouseClicked(evt);
            }
        });
        this.JSP_Detalle.setViewportView(this.JTB_Detalle);
        this.JTP_Datos.setForeground(new Color(0, 103, 0));
        this.JTP_Datos.setFont(new Font("Arial", 1, 14));
        this.JCb_Procedimiento.setFont(new Font("Arial", 1, 12));
        this.JCb_Procedimiento.setBorder(BorderFactory.createTitledBorder((Border) null, "Procedimiento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCb_Procedimiento.addItemListener(new ItemListener() { // from class: Cirugia.JIF_Programacion_Cx.3
            public void itemStateChanged(ItemEvent evt) {
                JIF_Programacion_Cx.this.JCb_ProcedimientoItemStateChanged(evt);
            }
        });
        this.JCb_Procedimiento.addMouseListener(new MouseAdapter() { // from class: Cirugia.JIF_Programacion_Cx.4
            public void mouseClicked(MouseEvent evt) {
                JIF_Programacion_Cx.this.JCb_ProcedimientoMouseClicked(evt);
            }
        });
        this.JTFF_Duracion.setBorder(BorderFactory.createTitledBorder((Border) null, "Duración(min)", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFF_Duracion.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.JTFF_Duracion.setHorizontalAlignment(0);
        this.JTFF_Duracion.setToolTipText("Duración en minutos");
        this.JTFF_Duracion.setFont(new Font("Arial", 1, 12));
        this.JSPObservacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTP_Observacion.setFont(new Font("Arial", 1, 12));
        this.JTP_Observacion.addKeyListener(new KeyAdapter() { // from class: Cirugia.JIF_Programacion_Cx.5
            public void keyPressed(KeyEvent evt) {
                JIF_Programacion_Cx.this.JTP_ObservacionKeyPressed(evt);
            }
        });
        this.JSPObservacion.setViewportView(this.JTP_Observacion);
        GroupLayout JPI_DProcedimientosLayout = new GroupLayout(this.JPI_DProcedimientos);
        this.JPI_DProcedimientos.setLayout(JPI_DProcedimientosLayout);
        JPI_DProcedimientosLayout.setHorizontalGroup(JPI_DProcedimientosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DProcedimientosLayout.createSequentialGroup().addContainerGap().addGroup(JPI_DProcedimientosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPObservacion).addGroup(JPI_DProcedimientosLayout.createSequentialGroup().addComponent(this.JCb_Procedimiento, 0, 628, 32767).addGap(18, 18, 18).addComponent(this.JTFF_Duracion, -2, 105, -2))).addContainerGap()));
        JPI_DProcedimientosLayout.setVerticalGroup(JPI_DProcedimientosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DProcedimientosLayout.createSequentialGroup().addContainerGap().addGroup(JPI_DProcedimientosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCb_Procedimiento, -2, 50, -2).addComponent(this.JTFF_Duracion, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JSPObservacion, -2, 59, -2).addContainerGap()));
        this.JTP_Datos.addTab("DATOS PROCEDIMIENTO", this.JPI_DProcedimientos);
        this.JCB_Empresa.setFont(new Font("Arial", 1, 12));
        this.JCB_Empresa.setBorder(BorderFactory.createTitledBorder((Border) null, "Empresa", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCB_Empresa.addItemListener(new ItemListener() { // from class: Cirugia.JIF_Programacion_Cx.6
            public void itemStateChanged(ItemEvent evt) {
                JIF_Programacion_Cx.this.JCB_EmpresaItemStateChanged(evt);
            }
        });
        this.JTF_NAutorizacion.setFont(new Font("Arial", 1, 12));
        this.JTF_NAutorizacion.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Autorización", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JPI_Cancela.setBorder(BorderFactory.createTitledBorder((Border) null, "DEBE CANCELAR?", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JBG_Cancela.add(this.JRB_Si);
        this.JRB_Si.setFont(new Font("Arial", 1, 12));
        this.JRB_Si.setText("Si");
        this.JRB_Si.addActionListener(new ActionListener() { // from class: Cirugia.JIF_Programacion_Cx.7
            public void actionPerformed(ActionEvent evt) {
                JIF_Programacion_Cx.this.JRB_SiActionPerformed(evt);
            }
        });
        this.JBG_Cancela.add(this.JRB_No);
        this.JRB_No.setFont(new Font("Arial", 1, 12));
        this.JRB_No.setSelected(true);
        this.JRB_No.setText("No");
        this.JRB_No.addActionListener(new ActionListener() { // from class: Cirugia.JIF_Programacion_Cx.8
            public void actionPerformed(ActionEvent evt) {
                JIF_Programacion_Cx.this.JRB_NoActionPerformed(evt);
            }
        });
        GroupLayout JPI_CancelaLayout = new GroupLayout(this.JPI_Cancela);
        this.JPI_Cancela.setLayout(JPI_CancelaLayout);
        JPI_CancelaLayout.setHorizontalGroup(JPI_CancelaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_CancelaLayout.createSequentialGroup().addContainerGap().addComponent(this.JRB_Si).addGap(18, 18, 18).addComponent(this.JRB_No).addContainerGap(32, 32767)));
        JPI_CancelaLayout.setVerticalGroup(JPI_CancelaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_CancelaLayout.createSequentialGroup().addGroup(JPI_CancelaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRB_Si).addComponent(this.JRB_No)).addGap(0, 0, 32767)));
        this.JCB_ClaseCita.setFont(new Font("Arial", 1, 12));
        this.JCB_ClaseCita.setBorder(BorderFactory.createTitledBorder((Border) null, "Clase Cita", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCB_ClaseCita.addItemListener(new ItemListener() { // from class: Cirugia.JIF_Programacion_Cx.9
            public void itemStateChanged(ItemEvent evt) {
                JIF_Programacion_Cx.this.JCB_ClaseCitaItemStateChanged(evt);
            }
        });
        GroupLayout JPI_DEmpresaLayout = new GroupLayout(this.JPI_DEmpresa);
        this.JPI_DEmpresa.setLayout(JPI_DEmpresaLayout);
        JPI_DEmpresaLayout.setHorizontalGroup(JPI_DEmpresaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DEmpresaLayout.createSequentialGroup().addContainerGap().addGroup(JPI_DEmpresaLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPI_DEmpresaLayout.createSequentialGroup().addComponent(this.JPI_Cancela, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCB_ClaseCita, 0, -1, 32767)).addGroup(JPI_DEmpresaLayout.createSequentialGroup().addComponent(this.JCB_Empresa, -2, 534, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTF_NAutorizacion, -2, 168, -2))).addContainerGap(49, 32767)));
        JPI_DEmpresaLayout.setVerticalGroup(JPI_DEmpresaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DEmpresaLayout.createSequentialGroup().addContainerGap().addGroup(JPI_DEmpresaLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JCB_Empresa, -1, 50, 32767).addComponent(this.JTF_NAutorizacion)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPI_DEmpresaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DEmpresaLayout.createSequentialGroup().addComponent(this.JPI_Cancela, -2, -1, -2).addGap(0, 16, 32767)).addComponent(this.JCB_ClaseCita, -1, 56, 32767)).addContainerGap()));
        this.JTP_Datos.addTab("EMPRESA A FACTURAR", this.JPI_DEmpresa);
        this.JTFFCodigoPat.setFont(new Font("Arial", 1, 12));
        this.JTFFCodigoPat.setBorder(BorderFactory.createTitledBorder((Border) null, "Código", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFCodigoPat.addFocusListener(new FocusAdapter() { // from class: Cirugia.JIF_Programacion_Cx.10
            public void focusLost(FocusEvent evt) {
                JIF_Programacion_Cx.this.JTFFCodigoPatFocusLost(evt);
            }
        });
        this.JTFFCodigoPat.addKeyListener(new KeyAdapter() { // from class: Cirugia.JIF_Programacion_Cx.11
            public void keyPressed(KeyEvent evt) {
                JIF_Programacion_Cx.this.JTFFCodigoPatKeyPressed(evt);
            }
        });
        this.JTFFNombrePat.setFont(new Font("Arial", 1, 12));
        this.JTFFNombrePat.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre Patología", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFNombrePat.addMouseListener(new MouseAdapter() { // from class: Cirugia.JIF_Programacion_Cx.12
            public void mouseClicked(MouseEvent evt) {
                JIF_Programacion_Cx.this.JTFFNombrePatMouseClicked(evt);
            }
        });
        this.JTFFNombrePat.addKeyListener(new KeyAdapter() { // from class: Cirugia.JIF_Programacion_Cx.13
            public void keyPressed(KeyEvent evt) {
                JIF_Programacion_Cx.this.JTFFNombrePatKeyPressed(evt);
            }
        });
        GroupLayout JPI_OtrosLayout = new GroupLayout(this.JPI_Otros);
        this.JPI_Otros.setLayout(JPI_OtrosLayout);
        JPI_OtrosLayout.setHorizontalGroup(JPI_OtrosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_OtrosLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFFCodigoPat, -2, 90, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFFNombrePat, -1, 643, 32767).addGap(18, 18, 18)));
        JPI_OtrosLayout.setVerticalGroup(JPI_OtrosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_OtrosLayout.createSequentialGroup().addContainerGap().addGroup(JPI_OtrosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFCodigoPat, -2, 50, -2).addComponent(this.JTFFNombrePat, -2, 50, -2)).addGap(74, 74, 74)));
        this.JTP_Datos.addTab("ADICIONAL", this.JPI_Otros);
        this.JPICalendario.setLayout((LayoutManager) null);
        this.JBT_Indicaciones.setFont(new Font("Arial", 1, 12));
        this.JBT_Indicaciones.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Configuracion29x27.png")));
        this.JBT_Indicaciones.setText("Visualizar Indicaciones");
        this.JBT_Indicaciones.addActionListener(new ActionListener() { // from class: Cirugia.JIF_Programacion_Cx.14
            public void actionPerformed(ActionEvent evt) {
                JIF_Programacion_Cx.this.JBT_IndicacionesActionPerformed(evt);
            }
        });
        this.JBT_AdicionarSP.setFont(new Font("Arial", 1, 12));
        this.JBT_AdicionarSP.setIcon(new ImageIcon(getClass().getResource("/Imagenes/servicio.png")));
        this.JBT_AdicionarSP.setText("Adicionar Suministro");
        this.JBT_AdicionarSP.addActionListener(new ActionListener() { // from class: Cirugia.JIF_Programacion_Cx.15
            public void actionPerformed(ActionEvent evt) {
                JIF_Programacion_Cx.this.JBT_AdicionarSPActionPerformed(evt);
            }
        });
        this.JBT_RIngreso.setFont(new Font("Arial", 1, 12));
        this.JBT_RIngreso.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Paciente.png")));
        this.JBT_RIngreso.setText("Ingreso");
        this.JBT_RIngreso.addActionListener(new ActionListener() { // from class: Cirugia.JIF_Programacion_Cx.16
            public void actionPerformed(ActionEvent evt) {
                JIF_Programacion_Cx.this.JBT_RIngresoActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPI_Persona, -1, -1, 32767).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JPI_EPSalas, -2, 305, -2).addComponent(this.JPICalendario, -1, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSP_Detalle).addComponent(this.JTP_Datos).addGroup(layout.createSequentialGroup().addComponent(this.JBT_Indicaciones).addGap(18, 18, 18).addComponent(this.JBT_AdicionarSP).addGap(18, 18, 18).addComponent(this.JBT_RIngreso, -2, 182, -2).addGap(0, 0, 32767))))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPI_Persona, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(layout.createSequentialGroup().addComponent(this.JTP_Datos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSP_Detalle, -2, 364, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JBT_Indicaciones, -1, -1, 32767).addComponent(this.JBT_AdicionarSP, -1, -1, 32767).addComponent(this.JBT_RIngreso, -1, -1, 32767)).addGap(6, 6, 6)).addGroup(layout.createSequentialGroup().addComponent(this.JPI_EPSalas, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPICalendario, -2, 295, -2))).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTE_ArbolValueChanged(TreeSelectionEvent evt) {
        if (this.xlleno) {
            TreePath rutaSeleccionada = evt.getPath();
            this.nodos = rutaSeleccionada.getPath();
            mLLenar_Combos_Procedimiento(this.nodos[2].toString());
            llenar_Combos_ClaseCita(this.nodos[2].toString());
            mCargarAgenda();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCb_ProcedimientoItemStateChanged(ItemEvent evt) {
        if (this.xlleno1 && this.JCb_Procedimiento.getSelectedIndex() != -1) {
            this.JTFF_Duracion.setValue(Long.valueOf(this.xId_Procedimiento[this.JCb_Procedimiento.getSelectedIndex()][1]));
            if (this.xId_Procedimiento[this.JCb_Procedimiento.getSelectedIndex()][2].equals("1")) {
                this.JBT_Indicaciones.setEnabled(true);
            } else {
                this.JBT_Indicaciones.setEnabled(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTP_ObservacionKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 9) {
            this.JTP_Observacion.transferFocus();
        } else if (evt.getKeyCode() == 222) {
            JOptionPane.showInternalMessageDialog(this, "Caracter(') no valido, \nFavor reemplazarlo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTP_Observacion.setText(this.JTP_Observacion.getText().substring(0, this.JTP_Observacion.getText().length() - 1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCB_EmpresaItemStateChanged(ItemEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTB_DetalleMouseClicked(MouseEvent evt) {
        if (this.JTB_Detalle.getSelectedRow() != -1) {
            if (this.xmodelo.getValueAt(this.JTB_Detalle.getSelectedRow(), 3).toString().equals(" ")) {
                this.xNfila = this.JTB_Detalle.getSelectedRow();
                Principal.txtNo.setText("");
                return;
            }
            Principal.txtNo.setText(this.xmodelo.getValueAt(this.JTB_Detalle.getSelectedRow(), 7).toString());
            this.xjp_Persona.setIdPersona(this.xmodelo.getValueAt(this.JTB_Detalle.getSelectedRow(), 8).toString());
            this.xjp_Persona.buscar(1);
            this.JCb_Procedimiento.setSelectedItem(this.xmodelo.getValueAt(this.JTB_Detalle.getSelectedRow(), 12).toString() + "-" + this.xmodelo.getValueAt(this.JTB_Detalle.getSelectedRow(), 4).toString());
            this.JCB_Empresa.setSelectedItem(this.xmodelo.getValueAt(this.JTB_Detalle.getSelectedRow(), 5).toString());
            this.JTP_Observacion.setText(this.xmodelo.getValueAt(this.JTB_Detalle.getSelectedRow(), 6).toString());
            this.JCB_ClaseCita.setSelectedItem(this.xmodelo.getValueAt(this.JTB_Detalle.getSelectedRow(), 13).toString());
            this.JTFFCodigoPat.setText(this.xmodelo.getValueAt(this.JTB_Detalle.getSelectedRow(), 14).toString());
            bpatologia();
            this.xNfila = -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_IndicacionesActionPerformed(ActionEvent evt) {
        if (!Principal.txtNo.getText().isEmpty()) {
            String[][] mparametros = new String[3][2];
            mparametros[0][0] = "Id";
            mparametros[0][1] = Principal.txtNo.getText();
            mparametros[1][0] = "SUBREPORT_DIR";
            mparametros[1][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
            mparametros[2][0] = "SUBREPORTFIRMA_DIR";
            mparametros[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "Qx_Recomendaciones", mparametros);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_AdicionarSPActionPerformed(ActionEvent evt) {
        if (!Principal.txtNo.getText().isEmpty()) {
            JDProcedimientoxSum xven = new JDProcedimientoxSum(null, true, "SUMINISTRO", this.xmodelo.getValueAt(this.JTB_Detalle.getSelectedRow(), 12).toString());
            xven.setLocationRelativeTo(this);
            xven.setVisible(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_RIngresoActionPerformed(ActionEvent evt) {
        if (!Principal.txtNo.getText().isEmpty() && this.JTB_Detalle.getSelectedRow() != -1) {
            if (this.xmodelo.getValueAt(this.JTB_Detalle.getSelectedRow(), 10).equals("0")) {
                Principal.clasefacturacion.cargarPantalla("Ingreso_Cx", this.xmodelo.getValueAt(this.JTB_Detalle.getSelectedRow(), 8).toString(), this.xmodelo.getValueAt(this.JTB_Detalle.getSelectedRow(), 7).toString(), this, this.xmodelo.getValueAt(this.JTB_Detalle.getSelectedRow(), 10).toString(), this.listaClaseCitas.get(this.JCB_ClaseCita.getSelectedIndex()).getId());
                Principal.mLimpiarDatosP();
            } else {
                Principal.clasefacturacion.cargarPantalla("Ingreso_Cx", this.xmodelo.getValueAt(this.JTB_Detalle.getSelectedRow(), 8).toString(), this.xmodelo.getValueAt(this.JTB_Detalle.getSelectedRow(), 7).toString(), this, this.xmodelo.getValueAt(this.JTB_Detalle.getSelectedRow(), 10).toString(), this.listaClaseCitas.get(this.JCB_ClaseCita.getSelectedIndex()).getId());
                Principal.txtNo.setText(this.xmodelo.getValueAt(this.JTB_Detalle.getSelectedRow(), 10).toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_SiActionPerformed(ActionEvent evt) {
        this.xCancela = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_NoActionPerformed(ActionEvent evt) {
        this.xCancela = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCb_ProcedimientoMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            buscarProcedimiento();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCB_ClaseCitaItemStateChanged(ItemEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFCodigoPatFocusLost(FocusEvent evt) {
        bpatologia();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFCodigoPatKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            bpatologia();
            this.JTFFCodigoPat.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFNombrePatMouseClicked(MouseEvent evt) {
        JIFBuscarPatologia pac = new JIFBuscarPatologia(null, true, this.JTFFCodigoPat, this.JTFFNombrePat, "patologiaCirugia", 0);
        pac.setVisible(true);
        pac.setLocationRelativeTo(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFNombrePatKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JTFFNombrePat.transferFocus();
        }
    }

    private void bpatologia() {
        if (this.JTFFCodigoPat.getText().length() != 0) {
            try {
                String sql = "SELECT Id, Nbre FROM  g_patologia where Id='" + this.JTFFCodigoPat.getText().toUpperCase() + "'";
                ResultSet res = this.xct.traerRs(sql);
                res.next();
                if (res.getRow() != 0) {
                    this.JTFFNombrePat.setText(res.getString(2));
                    this.JTFFCodigoPat.setText(this.JTFFCodigoPat.getText().toUpperCase());
                } else {
                    JOptionPane.showMessageDialog(this, "Codigo no existe", "BUSCAR PATOLOGIA", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    this.JTFFNombrePat.setText((String) null);
                    this.JTFFCodigoPat.setText((String) null);
                    this.JTFFCodigoPat.requestFocus();
                }
                res.close();
                this.xct.cerrarConexionBd();
            } catch (SQLException e) {
            }
        }
    }

    public void mGrabar() throws ParseException {
        if (this.xjp_Persona.validarDatos(0) == 1) {
            if (this.JCb_Procedimiento.getSelectedIndex() != -1) {
                if (this.JCB_ClaseCita.getSelectedIndex() != -1) {
                    if (this.JCB_Empresa.getSelectedIndex() != -1) {
                        if (!this.JTFF_Duracion.getText().equals("0")) {
                            if (!this.JTFFCodigoPat.getText().isEmpty() && !this.JTFFNombrePat.getText().isEmpty()) {
                                if (this.xNfila != -1) {
                                    int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                                    if (x == 0) {
                                        this.xjp_Persona.grabar();
                                        Date horaI = this.ft12.parse(this.JTB_Detalle.getValueAt(this.xNfila, 0).toString());
                                        Date horaF = sumarRestarMinHoras(horaI, Integer.valueOf(this.JTFF_Duracion.getText()).intValue());
                                        String xid_sala = this.xct.traerDato("SELECT  `Id`  FROM `q_salacirugias` WHERE (`Nbre` ='" + this.nodos[1] + "')");
                                        this.xct.cerrarConexionBd();
                                        String xid_especialidad = this.xct.traerDato("SELECT  `Id`  FROM `g_especialidad` WHERE (`Nbre` ='" + this.nodos[2] + "')");
                                        this.xct.cerrarConexionBd();
                                        String xid_Profesional = this.xct.traerDato("SELECT  `Id_Persona`  FROM `profesional` WHERE (`NProfesional` ='" + this.nodos[3] + "')");
                                        this.xct.cerrarConexionBd();
                                        this.xjp_Persona.grabar();
                                        this.xsql = "INSERT INTO q_agendacx (`Id_Usuario`, `Id_SalaCirugia`, `Id_EmpresaConv`, `FechaCx`, `HoraInicial`, `HoraFinal`, `Id_Especialidad`, `Id_Profesional`, `Id_Procedimiento`, `Observacion`, `Cancela`, `UsuarioS`, idClaseCita, idDxPrincipal, `Id_UsuarioS`) VALUES ('" + this.xjp_Persona.IdPersona + "','" + xid_sala + "','" + this.xId_Empresa[this.JCB_Empresa.getSelectedIndex()] + "','" + this.xmt.formatoAMD1.format(this.frmCalendario.getFecha().getTime()) + "','" + this.ft24.format(horaI) + "','" + this.ft24.format(horaF) + "','" + xid_especialidad + "','" + xid_Profesional + "','" + this.xId_Procedimiento[this.JCb_Procedimiento.getSelectedIndex()][0] + "','" + this.JTP_Observacion.getText() + "','" + this.xCancela + "','" + Principal.usuarioSistemaDTO.getLogin() + "','" + this.listaClaseCitas.get(this.JCB_ClaseCita.getSelectedIndex()).getId() + "','" + this.JTFFCodigoPat.getText() + "','" + Principal.usuarioSistemaDTO.getIdPersonaCargo() + "')";
                                        Principal.txtNo.setText(this.xct.ejecutarSQLId(this.xsql));
                                        this.xct.cerrarConexionBd();
                                        mCargarHorarioGrid();
                                        this.xmt.mostrarMensaje("Cita Grabada, Ok");
                                        return;
                                    }
                                    return;
                                }
                                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una fila dela tabla", "CONFIRMAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                return;
                            }
                            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar el diagnóstico principal para la cirugía.", "CONFIRMAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                            this.JTP_Datos.setSelectedIndex(2);
                            this.JTFFCodigoPat.requestFocus();
                            return;
                        }
                        JOptionPane.showInternalMessageDialog(this, "El tiempo debe ser mayor que cero", "CONFIRMAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        this.JTFF_Duracion.requestFocus();
                        return;
                    }
                    JOptionPane.showInternalMessageDialog(this, "Debe seleccionar la empresa", "CONFIRMAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    this.JTP_Datos.setSelectedIndex(1);
                    this.JCB_Empresa.requestFocus();
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar la clase de cita", "CONFIRMAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JTP_Datos.setSelectedIndex(1);
                this.JCB_ClaseCita.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar el procedimiento", "CONFIRMAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCb_Procedimiento.requestFocus();
        }
    }

    public void mNuevo_Inicio() {
        this.JBT_Indicaciones.setEnabled(false);
        this.JTFF_Duracion.setValue(new Long(0L));
        this.JTP_Observacion.setText("");
        this.JTF_NAutorizacion.setText("");
        this.JCB_Empresa.removeAllItems();
        this.xId_Empresa = this.xct.llenarCombo("SELECT `Id`, `Nbre` FROM `f_empresacontxconvenio` ORDER BY `Nbre` ASC", this.xId_Empresa, this.JCB_Empresa);
        this.JCB_Empresa.setSelectedIndex(-1);
        this.xct.cerrarConexionBd();
        this.xCancela = 0;
        this.JRB_No.setSelected(true);
        mCargarArbol();
        mCargarPanelCalendario();
        mCrearDetalle();
    }

    public void mNuevo() {
        Principal.mLimpiarDatosP();
        this.xjp_Persona.nuevo();
        this.JBT_Indicaciones.setEnabled(false);
        this.JTFF_Duracion.setValue(new Long(0L));
        this.JTP_Observacion.setText("");
        this.JTF_NAutorizacion.setText("");
        this.JCB_Empresa.removeAllItems();
        this.xId_Empresa = this.xct.llenarCombo("SELECT `Id`, `Nbre` FROM `f_empresacontxconvenio` ORDER BY `Nbre` ASC", this.xId_Empresa, this.JCB_Empresa);
        this.JCB_Empresa.setSelectedIndex(-1);
        this.xct.cerrarConexionBd();
    }

    public void mCargarAgenda() {
        mCrearDetalle();
        this.frmCalendario.refrescar();
        this.frmCalendario.limpiarListaDiasConCita();
        this.frmCalendario.montarAgendaGeneral(this.nodos[1].toString(), "0", "0");
        this.frmCalendario.montarAgendaEspecial(this.nodos[1].toString(), "0", "0");
        this.frmCalendario.montarAgendaExcepcion(this.nodos[1].toString(), "0", "0");
    }

    private void mLLenar_Combos_Procedimiento(String xnombre_especialidad) {
        if (this.xlleno) {
            this.xlleno1 = false;
            this.JCb_Procedimiento.removeAllItems();
            this.xsql = "SELECT `g_procedimiento`.`Id` ,CONCAT(`g_procedimiento`.`Id`,'-',`g_procedimiento`.`Nbre`) AS Nbre , `q_procedqxespec`.`Duracion` , IF(`q_procedqxespec`.`Indicaciones` IS NULL,0, 1) AS Indicaciones  FROM  `q_procedqxespec` INNER JOIN    `g_procedimiento`  ON (`q_procedqxespec`.`Id_Procedimiento` = `g_procedimiento`.`Id`) INNER JOIN    `g_especialidad`  ON (`q_procedqxespec`.`Id_Especialidad` = `g_especialidad`.`Id`) WHERE (`g_especialidad`.`Nbre` ='" + xnombre_especialidad + "' AND q_procedqxespec.`Estado`=1) ORDER BY `g_procedimiento`.`Nbre` ASC ";
            this.xId_Procedimiento = this.xct.llenarComboyLista(this.xsql, this.xId_Procedimiento, this.JCb_Procedimiento, 4);
            this.JCb_Procedimiento.setSelectedIndex(-1);
            this.xct.cerrarConexionBd();
            this.xlleno1 = true;
            this.JTFF_Duracion.setValue(new Long(0L));
        }
    }

    private void llenar_Combos_ClaseCita(String xnombre_especialidad) {
        if (this.xlleno) {
            this.xlleno1 = false;
            this.JCB_ClaseCita.removeAllItems();
            this.listaClaseCitas = this.claseCitaService.listaClaseCitaPorEspecialidadEsQuirurgico(xnombre_especialidad, true);
            this.listaClaseCitas.forEach(genericCombo -> {
                this.JCB_ClaseCita.addItem(genericCombo.getNombre());
            });
            this.xlleno1 = true;
        }
    }

    private void mCargarPanelPersonas() {
        this.xjp_Persona = new Persona(this);
        this.xjp_Persona.setVisible(false);
        this.JPI_Persona.setVisible(false);
        this.xjp_Persona.setBounds(1, 1, 967, 160);
        this.JPI_Persona.add(this.xjp_Persona);
        this.JPI_Persona.setVisible(true);
        this.xjp_Persona.setVisible(true);
    }

    /* JADX WARN: Finally extract failed */
    private void mCargarArbol() {
        try {
            this.xlleno = false;
            ConsultasMySQL xct1 = new ConsultasMySQL();
            this.xsql = "SELECT  `q_salacirugias`.`Id` , `q_salacirugias`.`Nbre` FROM  `q_profsalacirugia` INNER JOIN  `q_salacirugias`  ON (`q_profsalacirugia`.`Id_SalaCirugia` = `q_salacirugias`.`Id`) INNER JOIN  `q_confsalacirugias`  ON (`q_confsalacirugias`.`Id_SalaCirugia` = `q_salacirugias`.`Id`) INNER JOIN  `profesional1`  ON (`profesional1`.`Id_Persona` = `q_profsalacirugia`.`Id_Profesional`) AND (`profesional1`.`IdEspecialidad` = `q_profsalacirugia`.`Id_Especialidad`) WHERE (`q_confsalacirugias`.`Estado` =1)  GROUP BY `q_salacirugias`.`Id` ORDER BY `q_salacirugias`.`Nbre` desc ";
            System.out.println("" + this.xsql);
            ResultSet xrs = this.xct.traerRs(this.xsql);
            Throwable th = null;
            try {
                DefaultMutableTreeNode tallo = new DefaultMutableTreeNode("QUIROFANOS");
                DefaultTreeModel modeloArbol = new DefaultTreeModel(tallo);
                if (xrs.next()) {
                    xrs.beforeFirst();
                    while (xrs.next()) {
                        DefaultMutableTreeNode rama = new DefaultMutableTreeNode(xrs.getString(2));
                        modeloArbol.insertNodeInto(rama, tallo, 0);
                        this.xsql = "SELECT `profesional1`.`IdEspecialidad` , `profesional1`.`Especialidad`     FROM  `q_profsalacirugia` INNER JOIN   `q_salacirugias`  ON (`q_profsalacirugia`.`Id_SalaCirugia` = `q_salacirugias`.`Id`) INNER JOIN   `q_confsalacirugias`  ON (`q_confsalacirugias`.`Id_SalaCirugia` = `q_salacirugias`.`Id`) INNER JOIN   `profesional1`  ON (`profesional1`.`Id_Persona` = `q_profsalacirugia`.`Id_Profesional`) AND (`profesional1`.`IdEspecialidad` = `q_profsalacirugia`.`Id_Especialidad`) WHERE (`q_confsalacirugias`.`Estado` =1 AND `q_salacirugias`.`Id` ='" + xrs.getString(1) + "') GROUP BY `profesional1`.`IdEspecialidad` ORDER BY `q_salacirugias`.`Nbre` ASC, `profesional1`.`Especialidad` desc, `profesional1`.`NProfesional` desc ";
                        System.out.println(this.xsql);
                        ResultSet xrs1 = xct1.traerRs(this.xsql);
                        Throwable th2 = null;
                        try {
                            if (xrs1.next()) {
                                xrs1.beforeFirst();
                                while (xrs1.next()) {
                                    DefaultMutableTreeNode hoja = new DefaultMutableTreeNode(xrs1.getString(2));
                                    modeloArbol.insertNodeInto(hoja, rama, 0);
                                    ConsultasMySQL xct2 = new ConsultasMySQL();
                                    this.xsql = "SELECT `profesional1`.`Id_Persona` , `profesional1`.`NProfesional`     FROM  `q_profsalacirugia` INNER JOIN   `q_salacirugias`  ON (`q_profsalacirugia`.`Id_SalaCirugia` = `q_salacirugias`.`Id`) INNER JOIN   `q_confsalacirugias`  ON (`q_confsalacirugias`.`Id_SalaCirugia` = `q_salacirugias`.`Id`) INNER JOIN   `profesional1`  ON (`profesional1`.`Id_Persona` = `q_profsalacirugia`.`Id_Profesional`) AND (`profesional1`.`IdEspecialidad` = `q_profsalacirugia`.`Id_Especialidad`) WHERE (`q_confsalacirugias`.`Estado` =1 AND `q_salacirugias`.`Id` ='" + xrs.getString(1) + "' AND `profesional1`.`IdEspecialidad` ='" + xrs1.getString(1) + "') GROUP BY `profesional1`.`IdEspecialidad`, `profesional1`.`Id_Persona` order by `profesional1`.`NProfesional` desc ";
                                    System.out.println(this.xsql);
                                    ResultSet xrs2 = xct2.traerRs(this.xsql);
                                    Throwable th3 = null;
                                    try {
                                        try {
                                            if (xrs2.next()) {
                                                xrs2.beforeFirst();
                                                while (xrs2.next()) {
                                                    DefaultMutableTreeNode hoja1 = new DefaultMutableTreeNode(xrs2.getString(2));
                                                    modeloArbol.insertNodeInto(hoja1, hoja, 0);
                                                }
                                            }
                                            if (xrs2 != null) {
                                                if (0 != 0) {
                                                    try {
                                                        xrs2.close();
                                                    } catch (Throwable th4) {
                                                        th3.addSuppressed(th4);
                                                    }
                                                } else {
                                                    xrs2.close();
                                                }
                                            }
                                        } catch (Throwable th5) {
                                            if (xrs2 != null) {
                                                if (th3 != null) {
                                                    try {
                                                        xrs2.close();
                                                    } catch (Throwable th6) {
                                                        th3.addSuppressed(th6);
                                                    }
                                                } else {
                                                    xrs2.close();
                                                }
                                            }
                                            throw th5;
                                        }
                                    } catch (Throwable th7) {
                                        th3 = th7;
                                        throw th7;
                                    }
                                }
                            }
                            if (xrs1 != null) {
                                if (0 != 0) {
                                    try {
                                        xrs1.close();
                                    } catch (Throwable th8) {
                                        th2.addSuppressed(th8);
                                    }
                                } else {
                                    xrs1.close();
                                }
                            }
                        } catch (Throwable th9) {
                            if (xrs1 != null) {
                                if (0 != 0) {
                                    try {
                                        xrs1.close();
                                    } catch (Throwable th10) {
                                        th2.addSuppressed(th10);
                                    }
                                } else {
                                    xrs1.close();
                                }
                            }
                            throw th9;
                        }
                    }
                    this.xlleno = true;
                }
                if (xrs != null) {
                    if (0 != 0) {
                        try {
                            xrs.close();
                        } catch (Throwable th11) {
                            th.addSuppressed(th11);
                        }
                    } else {
                        xrs.close();
                    }
                }
                this.xct.cerrarConexionBd();
                this.JTE_Arbol.setModel(modeloArbol);
                this.JTE_Arbol.getSelectionModel().setSelectionMode(1);
                this.JTE_Arbol.setScrollsOnExpand(true);
                this.JTE_Arbol.requestFocus();
                this.xmt.expandAll(this.JTE_Arbol, true);
            } catch (Throwable th12) {
                if (xrs != null) {
                    if (0 != 0) {
                        try {
                            xrs.close();
                        } catch (Throwable th13) {
                            th.addSuppressed(th13);
                        }
                    } else {
                        xrs.close();
                    }
                }
                throw th12;
            }
        } catch (SQLException ex) {
            Logger.getLogger(JIF_Programacion_Cx.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mBuscar() {
        BuscarPersona frmBuscarP = new BuscarPersona(null, true, this.xjp_Persona);
        frmBuscarP.setVisible(true);
    }

    private void mCargarPanelCalendario() {
        this.frmCalendario = new CalendarioGral(this);
        this.JPICalendario.setVisible(false);
        this.frmCalendario.setBounds(1, 1, 305, 271);
        this.JPICalendario.add(this.frmCalendario);
        this.JPICalendario.setVisible(true);
        this.frmCalendario.setVisible(true);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    public void mCrearDetalle() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"HoraI", "HoraF", "N° Historía", "Usuario", "Procedimiento", "Empresa", "Observaciones", "Id_Cita", "Id_Persona", "Minutos", "Ingreso", "CERRADA", "IdProcedimiento", "clase cita", "Código Dx"}) { // from class: Cirugia.JIF_Programacion_Cx.17
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, Long.class, Long.class, Long.class, Long.class, Long.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTB_Detalle;
        JTable jTable2 = this.JTB_Detalle;
        jTable.setAutoResizeMode(0);
        this.JTB_Detalle.doLayout();
        this.JTB_Detalle.setModel(this.xmodelo);
        this.JTB_Detalle.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTB_Detalle.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTB_Detalle.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTB_Detalle.getColumnModel().getColumn(3).setPreferredWidth(200);
        this.JTB_Detalle.getColumnModel().getColumn(4).setPreferredWidth(200);
        this.JTB_Detalle.getColumnModel().getColumn(5).setPreferredWidth(200);
        this.JTB_Detalle.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTB_Detalle.getColumnModel().getColumn(7).setPreferredWidth(0);
        this.JTB_Detalle.getColumnModel().getColumn(7).setMinWidth(0);
        this.JTB_Detalle.getColumnModel().getColumn(7).setMaxWidth(0);
        this.JTB_Detalle.getColumnModel().getColumn(8).setPreferredWidth(0);
        this.JTB_Detalle.getColumnModel().getColumn(8).setMinWidth(0);
        this.JTB_Detalle.getColumnModel().getColumn(8).setMaxWidth(0);
        this.JTB_Detalle.getColumnModel().getColumn(9).setPreferredWidth(0);
        this.JTB_Detalle.getColumnModel().getColumn(9).setMinWidth(0);
        this.JTB_Detalle.getColumnModel().getColumn(9).setMaxWidth(0);
        this.JTB_Detalle.getColumnModel().getColumn(10).setPreferredWidth(0);
        this.JTB_Detalle.getColumnModel().getColumn(10).setMinWidth(0);
        this.JTB_Detalle.getColumnModel().getColumn(10).setMaxWidth(0);
        this.JTB_Detalle.getColumnModel().getColumn(11).setPreferredWidth(0);
        this.JTB_Detalle.getColumnModel().getColumn(11).setMinWidth(0);
        this.JTB_Detalle.getColumnModel().getColumn(11).setMaxWidth(0);
        this.JTB_Detalle.getColumnModel().getColumn(12).setPreferredWidth(0);
        this.JTB_Detalle.getColumnModel().getColumn(12).setMinWidth(0);
        this.JTB_Detalle.getColumnModel().getColumn(12).setMaxWidth(0);
        this.JTB_Detalle.getColumnModel().getColumn(13).setPreferredWidth(0);
        this.JTB_Detalle.getColumnModel().getColumn(13).setMinWidth(0);
        this.JTB_Detalle.getColumnModel().getColumn(13).setMaxWidth(0);
        this.JTB_Detalle.getColumnModel().getColumn(14).setPreferredWidth(100);
    }

    public void mCargarPacienteConCita() {
        try {
            this.xsql = "SELECT  `q_agendacx`.`HoraInicial` , `q_agendacx`.`HoraFinal` , `g_usuario`.`NoHistoria` , CONCAT(`g_persona`.`Apellido1`,' ', `g_persona`.`Apellido2`,' ',  `g_persona`.`Nombre1`,' ',  `g_persona`.`Nombre2`) AS `Nombre` , `g_procedimiento`.`Nbre` AS `NProcedimiento` , `f_empresacontxconvenio`.`Nbre` AS `NEmpresa` , `q_agendacx`.`Observacion` , `q_agendacx`.`Id` AS `Id_Cita` , `g_persona`.`Id` AS `Id_Persona`, TIMESTAMPDIFF(MINUTE, CONCAT(`q_agendacx`.`FechaCx`,' ',`q_agendacx`.`HoraInicial`), CONCAT(`q_agendacx`.`FechaCx`,' ', `q_agendacx`.`HoraFinal`) ), ifnull(ingreso.Id,0) as Id_Ingreso , IF((h_atencion.`Codigo_Dxp` IS NULL || h_atencion.`Codigo_Dxp` =''), 0,1) AS Cerrada, `g_procedimiento`.`Id` AS IdProcedimiento  , c_clasecita.Nbre as claseCita, q_agendacx.idDxPrincipal FROM  q_agendacx INNER JOIN  `g_persona`  ON (`q_agendacx`.`Id_Usuario` = `g_persona`.`Id`) INNER JOIN  `g_usuario`  ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`) INNER JOIN  `f_empresacontxconvenio`  ON (`q_agendacx`.`Id_EmpresaConv` = `f_empresacontxconvenio`.`Id`) INNER JOIN  `g_procedimiento`   ON (`q_agendacx`.`Id_Procedimiento` = `g_procedimiento`.`Id`) INNER JOIN  `q_salacirugias`  ON (`q_agendacx`.`Id_SalaCirugia` = `q_salacirugias`.`Id`)  inner join c_clasecita on (q_agendacx.idClaseCita=c_clasecita.Id)   LEFT JOIN `h_atencion` ON (h_atencion.`Id_Ingreso` =`q_agendacx`.Id_Ingreso )  LEFT JOIN `ingreso` ON (ingreso.`Id` =`q_agendacx`.Id_Ingreso ) and (ingreso.Estado=0)WHERE (`q_agendacx`.`FechaCx` ='" + this.frmCalendario.getAno() + "-" + (Integer.parseInt(this.frmCalendario.getMes()) + 1) + "-" + this.frmCalendario.getDia() + "' AND `q_salacirugias`.`Nbre` ='" + this.nodos[1] + "' AND `q_agendacx`.`Id_MotivoDesistida` =1) ORDER BY `q_agendacx`.`HoraInicial` ASC ";
            System.out.println(" pac Citas " + this.xsql);
            ResultSet rs = this.xct.traerRs(this.xsql);
            Throwable th = null;
            try {
                if (rs.next()) {
                    rs.last();
                    this.listaPacientesConCita = new String[rs.getRow()][15];
                    int fila = 0;
                    rs.beforeFirst();
                    int xncitas = 0;
                    while (rs.next()) {
                        this.listaPacientesConCita[fila][0] = rs.getString(1);
                        this.listaPacientesConCita[fila][1] = rs.getString(2);
                        this.listaPacientesConCita[fila][2] = rs.getString(3);
                        this.listaPacientesConCita[fila][3] = rs.getString(4);
                        this.listaPacientesConCita[fila][4] = rs.getString(5);
                        this.listaPacientesConCita[fila][5] = rs.getString(6);
                        this.listaPacientesConCita[fila][6] = rs.getString(7);
                        this.listaPacientesConCita[fila][7] = rs.getString(8);
                        this.listaPacientesConCita[fila][8] = rs.getString(9);
                        this.listaPacientesConCita[fila][9] = rs.getString(10);
                        this.listaPacientesConCita[fila][10] = rs.getString(11);
                        this.listaPacientesConCita[fila][11] = rs.getString(12);
                        this.listaPacientesConCita[fila][12] = rs.getString(13);
                        this.listaPacientesConCita[fila][13] = rs.getString("claseCita");
                        this.listaPacientesConCita[fila][14] = rs.getString("idDxPrincipal");
                        fila++;
                        xncitas++;
                    }
                } else {
                    this.listaPacientesConCita = new String[0][13];
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
        } catch (SQLException ex) {
            this.xct.mostrarErrorE(ex);
        }
    }

    public Date sumarRestarMinHoras(Date Hora, int min) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(Hora);
        calendar.add(12, min);
        return calendar.getTime();
    }

    public void mCargarHorarioGrid() {
        mCargarPacienteConCita();
        int diaAnterior = 0;
        int fila = 0;
        int dosHoras = 5;
        String horaUltima = "";
        for (int i = 0; i < 1000 && this.frmCalendario.listaDiasConCita[i][0] != null; i++) {
            if (this.frmCalendario.listaDiasConCita[i][0].equals(this.frmCalendario.getDia()) && this.frmCalendario.listaDiasConCita[i][5].equals("2")) {
                try {
                    if (diaAnterior != Integer.parseInt(this.frmCalendario.listaDiasConCita[i][0])) {
                        mCrearDetalle();
                        fila = 0;
                    }
                    diaAnterior = Integer.parseInt(this.frmCalendario.listaDiasConCita[i][0]);
                    Date hini = this.ft24.parse(this.frmCalendario.listaDiasConCita[i][2]);
                    Date hfin = this.ft24.parse(this.frmCalendario.listaDiasConCita[i][3]);
                    do {
                        montarFilaVacia(this.ft12.format(hini), fila, 5);
                        if (hini.getTime() == hfin.getTime()) {
                            montarFilaDescanso(this.ft12.format(hini), fila);
                        }
                        int sw = 0;
                        String[][] strArr = this.listaPacientesConCita;
                        int length = strArr.length;
                        int i2 = 0;
                        while (true) {
                            if (i2 >= length) {
                                break;
                            }
                            String[] listaPacientesConCita1 = strArr[i2];
                            if (!this.ft24.format(this.ft24.parse(listaPacientesConCita1[0])).equals(this.ft24.format(hini))) {
                                i2++;
                            } else {
                                horaUltima = this.ft12.format(this.ft24.parse(listaPacientesConCita1[1]));
                                this.xmodelo.setValueAt(horaUltima, fila, 1);
                                this.xmodelo.setValueAt(listaPacientesConCita1[2], fila, 2);
                                this.xmodelo.setValueAt(listaPacientesConCita1[3], fila, 3);
                                this.xmodelo.setValueAt(listaPacientesConCita1[4], fila, 4);
                                this.xmodelo.setValueAt(listaPacientesConCita1[5], fila, 5);
                                this.xmodelo.setValueAt(listaPacientesConCita1[6], fila, 6);
                                this.xmodelo.setValueAt(listaPacientesConCita1[7], fila, 7);
                                this.xmodelo.setValueAt(listaPacientesConCita1[8], fila, 8);
                                this.xmodelo.setValueAt(listaPacientesConCita1[9], fila, 9);
                                this.xmodelo.setValueAt(listaPacientesConCita1[10], fila, 10);
                                this.xmodelo.setValueAt(listaPacientesConCita1[11], fila, 11);
                                this.xmodelo.setValueAt(listaPacientesConCita1[12], fila, 12);
                                this.xmodelo.setValueAt(listaPacientesConCita1[13], fila, 13);
                                this.xmodelo.setValueAt(listaPacientesConCita1[14], fila, 14);
                                this.JTB_Detalle.setDefaultRenderer(Object.class, new MiRender2());
                                dosHoras += Integer.parseInt(listaPacientesConCita1[9].toString());
                                sw = 1;
                                break;
                            }
                        }
                        if (sw == 1) {
                            hini = this.ft12.parse(horaUltima);
                        } else {
                            hini = sumarRestarMinHoras(hini, 5);
                        }
                        fila++;
                    } while (hini.getTime() <= hfin.getTime());
                } catch (ParseException ex) {
                    Logger.getLogger(JIF_Programacion_Cx.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                }
            }
        }
        for (int i3 = 0; i3 < 1000 && this.frmCalendario.listaDiasConCita[i3][0] != null; i3++) {
            if (this.frmCalendario.listaDiasConCita[i3][0].equals(this.frmCalendario.getDia()) && this.frmCalendario.listaDiasConCita[i3][5].equals("3")) {
                try {
                    if (diaAnterior != Integer.parseInt(this.frmCalendario.listaDiasConCita[i3][0])) {
                        mCrearDetalle();
                    }
                    diaAnterior = Integer.parseInt(this.frmCalendario.listaDiasConCita[i3][0]);
                    Date hini2 = this.ft24.parse(this.frmCalendario.listaDiasConCita[i3][2]);
                    Date hfin2 = this.ft24.parse(this.frmCalendario.listaDiasConCita[i3][3]);
                    do {
                        montarFilaVacaciones(this.ft12.format(hini2));
                        hini2 = sumarRestarMinHoras(hini2, 5);
                    } while (hini2.getTime() < hfin2.getTime());
                } catch (ParseException ex2) {
                    Logger.getLogger(JIF_Programacion_Cx.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex2);
                }
            }
        }
    }

    public void mCargarHorarioGrid1() {
        mCargarPacienteConCita();
        int diaAnterior = 0;
        int fila = 0;
        int dosHoras = 10;
        for (int i = 0; i < 1000 && this.frmCalendario.listaDiasConCita[i][0] != null; i++) {
            if (this.frmCalendario.listaDiasConCita[i][0].equals(this.frmCalendario.getDia())) {
                if (diaAnterior != Integer.parseInt(this.frmCalendario.listaDiasConCita[i][0])) {
                    mCrearDetalle();
                    fila = 0;
                }
                diaAnterior = Integer.parseInt(this.frmCalendario.listaDiasConCita[i][0]);
                int horaInicio = Integer.parseInt(this.frmCalendario.listaDiasConCita[i][2].substring(0, 2));
                int minutoInicio = Integer.parseInt(this.frmCalendario.listaDiasConCita[i][2].substring(3, 5));
                int horaFinal = Integer.parseInt(this.frmCalendario.listaDiasConCita[i][3].substring(0, 2));
                int minutoFinal = Integer.parseInt(this.frmCalendario.listaDiasConCita[i][3].substring(3, 5));
                int horaf = 0;
                String hora = "";
                for (int horaIni = horaInicio; horaIni <= horaFinal; horaIni++) {
                    int i2 = minutoInicio;
                    while (true) {
                        int min = i2;
                        if (min >= 60 || ((horaIni == horaFinal && min > minutoFinal) || horaf > horaIni)) {
                            break;
                        }
                        hora = getHora(horaIni, min);
                        if (this.frmCalendario.listaDiasConCita[i][5].equals("3")) {
                            montarFilaVacaciones(hora);
                        } else {
                            int salir = 0;
                            montarFilaVacia(hora, fila, dosHoras);
                            String hora24 = this.xmt.pasarHora12a24(hora);
                            String[][] strArr = this.listaPacientesConCita;
                            int length = strArr.length;
                            int i3 = 0;
                            while (true) {
                                if (i3 >= length) {
                                    break;
                                }
                                String[] listaPacientesConCita1 = strArr[i3];
                                if (listaPacientesConCita1[0].toString().substring(0, 5).equals(hora24.substring(0, 5))) {
                                    String horaUltima = this.xmt.formatoHora24(listaPacientesConCita1[1]);
                                    this.xmodelo.setValueAt(horaUltima, fila, 1);
                                    this.xmodelo.setValueAt(listaPacientesConCita1[2], fila, 2);
                                    this.xmodelo.setValueAt(listaPacientesConCita1[3], fila, 3);
                                    this.xmodelo.setValueAt(listaPacientesConCita1[4], fila, 4);
                                    this.xmodelo.setValueAt(listaPacientesConCita1[5], fila, 5);
                                    this.xmodelo.setValueAt(listaPacientesConCita1[6], fila, 6);
                                    this.xmodelo.setValueAt(listaPacientesConCita1[7], fila, 7);
                                    this.xmodelo.setValueAt(listaPacientesConCita1[8], fila, 8);
                                    this.xmodelo.setValueAt(listaPacientesConCita1[9], fila, 9);
                                    this.xmodelo.setValueAt(listaPacientesConCita1[10], fila, 10);
                                    this.xmodelo.setValueAt(listaPacientesConCita1[11], fila, 11);
                                    this.xmodelo.setValueAt(listaPacientesConCita1[12], fila, 12);
                                    this.JTB_Detalle.setDefaultRenderer(Object.class, new MiRender2());
                                    dosHoras += Integer.parseInt(listaPacientesConCita1[9].toString());
                                    min = Integer.parseInt(horaUltima.substring(3, 5));
                                    horaf = Integer.parseInt(this.xmt.pasarHora12a24(horaUltima).substring(0, 2));
                                    if (horaf > horaIni || min > min || Integer.parseInt(listaPacientesConCita1[9].toString()) > 59) {
                                        salir = 1;
                                        minutoInicio = min;
                                    } else {
                                        min -= 10;
                                    }
                                } else {
                                    minutoInicio = 0;
                                    this.xmodelo.setValueAt("0", fila, 9);
                                    this.xmodelo.setValueAt("0", fila, 10);
                                    this.xmodelo.setValueAt("0", fila, 11);
                                    this.xmodelo.setValueAt("", fila, 3);
                                    i3++;
                                }
                            }
                            fila++;
                            dosHoras += 10;
                            if (salir == 1) {
                                break;
                            }
                        }
                        i2 = min + 10;
                    }
                }
                montarFilaDescanso(hora, fila);
            }
        }
    }

    private void montarFilaVacia(String hora, int fila, int dosHoras) {
        this.xmodelo.addRow(this.dato);
        this.xmodelo.setValueAt(hora, fila, 0);
        this.xmodelo.setValueAt(" ", fila, 3);
        this.xmodelo.setValueAt("", fila, 5);
        this.xmodelo.setValueAt(Integer.valueOf(dosHoras), fila, 9);
        this.xmodelo.setValueAt("0", fila, 10);
        this.xmodelo.setValueAt("0", fila, 11);
    }

    private void montarFilaVacaciones(String hora) {
        for (int p = 0; p < this.xmodelo.getRowCount(); p++) {
            if (this.xmodelo.getValueAt(p, 0).toString().equals(hora) && this.xmodelo.getValueAt(p, 3).equals(" ")) {
                this.xmodelo.setValueAt("Libre / Permiso / Vacaciones", p, 3);
                this.xmodelo.setValueAt("0", p, 9);
                this.xmodelo.setValueAt("0", p, 10);
                this.xmodelo.setValueAt("0", p, 11);
                return;
            }
        }
    }

    private void montarFilaDescanso(String hora, int fila) {
        this.xmodelo.setValueAt(hora, fila, 0);
        this.xmodelo.setValueAt("- Fin Programación de Turno -  ", fila, 3);
        this.xmodelo.setValueAt("", fila, 4);
        this.xmodelo.setValueAt("", fila, 5);
        this.xmodelo.setValueAt("", fila, 6);
        this.xmodelo.setValueAt("0", fila, 7);
        this.xmodelo.setValueAt("0", fila, 8);
        this.xmodelo.setValueAt("0", fila, 9);
        this.xmodelo.setValueAt("0", fila, 10);
        this.xmodelo.setValueAt("0", fila, 11);
    }

    public String getHora(int hInicial, int min) {
        String hora;
        if (hInicial < 10) {
            if (min < 10) {
                hora = this.xmt.formatoHora12("0" + String.valueOf(hInicial) + ":0" + String.valueOf(min));
            } else {
                hora = this.xmt.formatoHora12("0" + String.valueOf(hInicial) + ":" + String.valueOf(min));
            }
        } else if (min < 10) {
            hora = this.xmt.formatoHora12(String.valueOf(hInicial) + ":0" + String.valueOf(min));
        } else {
            hora = this.xmt.formatoHora12(String.valueOf(hInicial) + ":" + String.valueOf(min));
        }
        return hora;
    }

    /* JADX INFO: loaded from: GenomaP.jar:Cirugia/JIF_Programacion_Cx$MiRender2.class */
    public class MiRender2 extends DefaultTableCellRenderer {
        public MiRender2() {
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (JIF_Programacion_Cx.this.listaPacientesConCita.length > 0) {
                int cantidad = Integer.parseInt(table.getValueAt(row, 10).toString());
                int cerrada = Integer.parseInt(table.getValueAt(row, 11).toString());
                String nbre = table.getValueAt(row, 3).toString();
                if (cantidad == 0) {
                    if (nbre.equals(" ")) {
                        cell.setBackground(Color.WHITE);
                        cell.setForeground(Color.BLACK);
                    } else {
                        cell.setBackground(Color.CYAN);
                        cell.setForeground(Color.BLACK);
                    }
                } else if (cerrada == 1) {
                    cell.setBackground(Color.MAGENTA);
                    cell.setForeground(Color.BLACK);
                } else {
                    cell.setBackground(new Color(133, 218, 160));
                    cell.setForeground(Color.BLACK);
                }
            }
            return cell;
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:Cirugia/JIF_Programacion_Cx$MyTreeCellRenderer.class */
    public class MyTreeCellRenderer extends DefaultTreeCellRenderer {
        public MyTreeCellRenderer() {
        }

        public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded, boolean leaf, int row, boolean hasFocus) {
            super.getTreeCellRendererComponent(tree, value, selected, expanded, leaf, row, hasFocus);
            tree.setRowHeight(26);
            setOpaque(true);
            setForeground(Color.black);
            if (selected) {
                setForeground(Color.red);
            }
            if (tree.getModel().getRoot().equals((DefaultMutableTreeNode) value)) {
                setIcon(JIF_Programacion_Cx.this.rootIcon);
            } else if (leaf) {
                setIcon(JIF_Programacion_Cx.this.medicoIcon);
            } else if (expanded) {
                setIcon(JIF_Programacion_Cx.this.especialidadIcon);
            } else {
                setIcon(JIF_Programacion_Cx.this.especialidadIcon);
            }
            return this;
        }
    }

    public void mAnular() {
        if (!Principal.txtNo.getText().isEmpty() && this.JTB_Detalle.getSelectedRow() != -1) {
            if (this.xmodelo.getValueAt(this.JTB_Detalle.getSelectedRow(), 10).toString().equals("0")) {
                int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de anular?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (x == 0) {
                    Anular frm = new Anular(null, true, "CIRUGÍA", 35);
                    frm.setLocationRelativeTo(this);
                    frm.setVisible(true);
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Usuario con ingreso activo", "CONFIRMAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
    }

    public void mAnularC(String xid, String xmotivo) {
        this.xsql = "update q_agendacx set `Id_MotivoDesistida`='" + xid + "' , `FechaAnulacion`='" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "' , `MotivoAnulacion`='" + xmotivo + "' , `UsuarioAnulacion`='" + Principal.usuarioSistemaDTO.getNombreUsuario() + "' where Id='" + Principal.txtNo.getText() + "'";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        mCargarHorarioGrid();
    }

    private void buscarProcedimiento() {
        BuscarProced frmBuscarProced = new BuscarProced((Frame) null, true, (JInternalFrame) this, "cirugia", this.nodos[2].toString());
        frmBuscarProced.setVisible(true);
    }
}
