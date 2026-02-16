package ParametrizacionN;

import Acceso.Principal;
import General.JDConsultar_InformacionG;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:ParametrizacionN/JIFCClaseCita.class */
public class JIFCClaseCita extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private DefaultTableModel modeloTipoAtencion;
    private Object[] xdatos;
    private Object[] datosTipoAtencion;
    private String xnombre;
    private String xid;
    private String xsexo;
    private String clasificacionTipoTerapia;
    private String[] xidespecialidad;
    private String[] xidprocedimiento;
    private String[] xidtipocita;
    private String[] xidtipohistoria;
    private String[] xidprograma;
    private String[] xidFindalidad;
    private String[] xidtipomuestra;
    private String[] xidfiltro;
    private String[] xcuasaexterna;
    private String[] xidclasificacion;
    private String[] idTipoAtencion;
    private JButton JBAgregarTipoAtencion;
    private ButtonGroup JBGOpciones;
    private JComboBox JCBCausaExterna;
    private JComboBox JCBClasificacion;
    private JComboBox JCBEspecialidad;
    private JComboBox JCBFEspecialidad;
    private JComboBox JCBFindalidad;
    public JComboBox JCBProcedimiento;
    private JComboBox JCBPrograma;
    private JComboBox JCBSexo;
    private JComboBox<String> JCBTipoAtencion;
    private JComboBox JCBTipoCita;
    private JComboBox JCBTipoHistoria;
    private JComboBox JCBTipoTerapia;
    private JCheckBox JCH4505;
    private JCheckBox JCHEsControl;
    private JCheckBox JCHEsPeriodico;
    private JCheckBox JCHEsSO;
    private JCheckBox JCHEsUrgencia;
    private JCheckBox JCHEstado;
    private JCheckBox JCHFiltro;
    private JPanel JPIDatos;
    private JPanel JPIFiltroNombre1;
    private JPanel JPIHistorico;
    private JPanel JPTipoAtencion;
    private JScrollPane JSPDetalle;
    private JSpinner JSPDuracion;
    private JSpinner JSPEdadI;
    private JSpinner JSPEdadM;
    private JScrollPane JSPHistorico;
    private JSpinner JSPNR2175;
    private JSpinner JSPNR256;
    private JTable JTDetalle;
    private JTextField JTFNombre;
    private JTextField JTFNombreVariable;
    private JTable JTHistoricoTipoAtencion;
    private JTabbedPane JTPGeneral;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JCheckBox jchEstado;
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    private Metodos xmetodos = new Metodos();
    private int xestado = 0;
    private int xescontrol = 0;
    private int xtipobusqueda = 0;
    private int xso = 0;
    private int xesurgencia = 0;
    private int x4505 = 0;
    private int estadoTipoAtencion = 1;
    private int esPeriodico = 0;
    private boolean xestadog = false;
    private boolean xlleno = false;

    public JIFCClaseCita() {
        initComponents();
        mIniciarComponentes();
        mCargarDatosTabla();
    }

    public void habilitarTabAtencion() {
        if (!Principal.txtNo.getText().isEmpty()) {
            this.JCBTipoAtencion.setEnabled(true);
            this.jchEstado.setEnabled(true);
            this.JBAgregarTipoAtencion.setEnabled(true);
            this.JSPHistorico.setEnabled(true);
            this.JTHistoricoTipoAtencion.setEnabled(true);
            cargarDatosTipoAtencion();
            return;
        }
        this.JCBTipoAtencion.setEnabled(false);
        this.jchEstado.setEnabled(false);
        this.JBAgregarTipoAtencion.setEnabled(false);
        this.JSPHistorico.setEnabled(false);
        this.JTHistoricoTipoAtencion.setEnabled(false);
        cargarDatosTipoAtencion();
    }

    /* JADX WARN: Type inference failed for: r3v123, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v142, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGOpciones = new ButtonGroup();
        this.JTPGeneral = new JTabbedPane();
        this.JPIDatos = new JPanel();
        this.JTFNombre = new JTextField();
        this.JSPDuracion = new JSpinner();
        this.JCBEspecialidad = new JComboBox();
        this.JCBProcedimiento = new JComboBox();
        this.JCBTipoCita = new JComboBox();
        this.JCBTipoHistoria = new JComboBox();
        this.JCBPrograma = new JComboBox();
        this.JCHEstado = new JCheckBox();
        this.JCHEsControl = new JCheckBox();
        this.JTFNombreVariable = new JTextField();
        this.JCHEsSO = new JCheckBox();
        this.JCHEsUrgencia = new JCheckBox();
        this.JCBFindalidad = new JComboBox();
        this.JSPNR256 = new JSpinner();
        this.JCBCausaExterna = new JComboBox();
        this.jPanel1 = new JPanel();
        this.JSPEdadI = new JSpinner();
        this.JSPEdadM = new JSpinner();
        this.jPanel2 = new JPanel();
        this.JCBSexo = new JComboBox();
        this.JCBClasificacion = new JComboBox();
        this.JCH4505 = new JCheckBox();
        this.JCHEsPeriodico = new JCheckBox();
        this.JSPNR2175 = new JSpinner();
        this.JCBTipoTerapia = new JComboBox();
        this.JPTipoAtencion = new JPanel();
        this.JBAgregarTipoAtencion = new JButton();
        this.JCBTipoAtencion = new JComboBox<>();
        this.JSPHistorico = new JScrollPane();
        this.JTHistoricoTipoAtencion = new JTable();
        this.jchEstado = new JCheckBox();
        this.JPIHistorico = new JPanel();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JPIFiltroNombre1 = new JPanel();
        this.JCBFEspecialidad = new JComboBox();
        this.JCHFiltro = new JCheckBox();
        setClosable(true);
        setIconifiable(true);
        setTitle("CLASE CITA");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMaximumSize(new Dimension(1036, 423));
        setMinimumSize(new Dimension(1036, 423));
        setName("jifclasecita");
        setRequestFocusEnabled(false);
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        setVisible(true);
        this.JTPGeneral.setForeground(Color.red);
        this.JTPGeneral.setFont(new Font("Arial", 1, 14));
        this.JTPGeneral.setRequestFocusEnabled(false);
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JPIDatos.setRequestFocusEnabled(false);
        this.JTFNombre.setFont(new Font("Arial", 1, 12));
        this.JTFNombre.setToolTipText("Digite el nombre de la clase cita");
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNombre.setPreferredSize((Dimension) null);
        this.JSPDuracion.setFont(new Font("Arial", 1, 12));
        this.JSPDuracion.setModel(new SpinnerNumberModel(0, 0, (Comparable) null, 1));
        this.JSPDuracion.setBorder(BorderFactory.createTitledBorder((Border) null, "Duración", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPDuracion.setPreferredSize((Dimension) null);
        this.JSPDuracion.setRequestFocusEnabled(false);
        this.JCBEspecialidad.setFont(new Font("Arial", 1, 12));
        this.JCBEspecialidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Especialidad", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBEspecialidad.setPreferredSize((Dimension) null);
        this.JCBEspecialidad.setRequestFocusEnabled(false);
        this.JCBProcedimiento.setFont(new Font("Arial", 1, 12));
        this.JCBProcedimiento.setBorder(BorderFactory.createTitledBorder((Border) null, "Procedimiento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBProcedimiento.setPreferredSize((Dimension) null);
        this.JCBProcedimiento.setRequestFocusEnabled(false);
        this.JCBProcedimiento.setVerifyInputWhenFocusTarget(false);
        this.JCBProcedimiento.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFCClaseCita.1
            public void mouseClicked(MouseEvent evt) {
                JIFCClaseCita.this.JCBProcedimientoMouseClicked(evt);
            }
        });
        this.JCBTipoCita.setFont(new Font("Arial", 1, 12));
        this.JCBTipoCita.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Cita", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipoCita.setPreferredSize((Dimension) null);
        this.JCBTipoCita.setRequestFocusEnabled(false);
        this.JCBTipoCita.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFCClaseCita.2
            public void actionPerformed(ActionEvent evt) {
                JIFCClaseCita.this.JCBTipoCitaActionPerformed(evt);
            }
        });
        this.JCBTipoHistoria.setFont(new Font("Arial", 1, 12));
        this.JCBTipoHistoria.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Historia", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipoHistoria.setPreferredSize((Dimension) null);
        this.JCBTipoHistoria.setRequestFocusEnabled(false);
        this.JCBTipoHistoria.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFCClaseCita.3
            public void actionPerformed(ActionEvent evt) {
                JIFCClaseCita.this.JCBTipoHistoriaActionPerformed(evt);
            }
        });
        this.JCBPrograma.setFont(new Font("Arial", 1, 12));
        this.JCBPrograma.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de Programa", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBPrograma.setPreferredSize((Dimension) null);
        this.JCBPrograma.setRequestFocusEnabled(false);
        this.JCBPrograma.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFCClaseCita.4
            public void actionPerformed(ActionEvent evt) {
                JIFCClaseCita.this.JCBProgramaActionPerformed(evt);
            }
        });
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCHEstado.setPreferredSize((Dimension) null);
        this.JCHEstado.setRequestFocusEnabled(false);
        this.JCHEstado.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFCClaseCita.5
            public void actionPerformed(ActionEvent evt) {
                JIFCClaseCita.this.JCHEstadoActionPerformed(evt);
            }
        });
        this.JCHEsControl.setFont(new Font("Arial", 1, 12));
        this.JCHEsControl.setSelected(true);
        this.JCHEsControl.setText("Es Control?");
        this.JCHEsControl.setPreferredSize((Dimension) null);
        this.JCHEsControl.setRequestFocusEnabled(false);
        this.JCHEsControl.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFCClaseCita.6
            public void actionPerformed(ActionEvent evt) {
                JIFCClaseCita.this.JCHEsControlActionPerformed(evt);
            }
        });
        this.JTFNombreVariable.setFont(new Font("Arial", 1, 12));
        this.JTFNombreVariable.setToolTipText("");
        this.JTFNombreVariable.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre Variable", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNombreVariable.setPreferredSize((Dimension) null);
        this.JCHEsSO.setFont(new Font("Arial", 1, 12));
        this.JCHEsSO.setText("Salud Ocupacional?");
        this.JCHEsSO.setPreferredSize((Dimension) null);
        this.JCHEsSO.setRequestFocusEnabled(false);
        this.JCHEsSO.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFCClaseCita.7
            public void actionPerformed(ActionEvent evt) {
                JIFCClaseCita.this.JCHEsSOActionPerformed(evt);
            }
        });
        this.JCHEsUrgencia.setFont(new Font("Arial", 1, 12));
        this.JCHEsUrgencia.setText("Es Urgencia?");
        this.JCHEsUrgencia.setPreferredSize((Dimension) null);
        this.JCHEsUrgencia.setRequestFocusEnabled(false);
        this.JCHEsUrgencia.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFCClaseCita.8
            public void actionPerformed(ActionEvent evt) {
                JIFCClaseCita.this.JCHEsUrgenciaActionPerformed(evt);
            }
        });
        this.JCBFindalidad.setFont(new Font("Arial", 1, 12));
        this.JCBFindalidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Finalidad", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBFindalidad.setPreferredSize((Dimension) null);
        this.JCBFindalidad.setRequestFocusEnabled(false);
        this.JSPNR256.setFont(new Font("Arial", 1, 12));
        this.JSPNR256.setModel(new SpinnerNumberModel(0, 0, 9, 1));
        this.JSPNR256.setBorder(BorderFactory.createTitledBorder((Border) null, "NR256", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPNR256.setPreferredSize((Dimension) null);
        this.JSPNR256.setRequestFocusEnabled(false);
        this.JCBCausaExterna.setFont(new Font("Arial", 1, 12));
        this.JCBCausaExterna.setBorder(BorderFactory.createTitledBorder((Border) null, "Causa Externa", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBCausaExterna.setPreferredSize((Dimension) null);
        this.JCBCausaExterna.setRequestFocusEnabled(false);
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "Filtro Edad (DIas)", 0, 0, new Font("Arial", 1, 12), new Color(0, 103, 0)));
        this.jPanel1.setRequestFocusEnabled(false);
        this.JSPEdadI.setFont(new Font("Arial", 1, 12));
        this.JSPEdadI.setModel(new SpinnerNumberModel(0, 0, (Comparable) null, 1));
        this.JSPEdadI.setBorder(BorderFactory.createTitledBorder((Border) null, "Inicial", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPEdadI.setPreferredSize((Dimension) null);
        this.JSPEdadI.setRequestFocusEnabled(false);
        this.JSPEdadM.setFont(new Font("Arial", 1, 12));
        this.JSPEdadM.setModel(new SpinnerNumberModel(0, 0, (Comparable) null, 1));
        this.JSPEdadM.setBorder(BorderFactory.createTitledBorder((Border) null, "Final", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPEdadM.setPreferredSize((Dimension) null);
        this.JSPEdadM.setRequestFocusEnabled(false);
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.JSPEdadI, -2, 130, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 23, 32767).addComponent(this.JSPEdadM, -2, 130, -2).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JSPEdadI, -2, 50, -2).addComponent(this.JSPEdadM, -2, 50, -2)));
        this.jPanel2.setBorder(BorderFactory.createTitledBorder((Border) null, "Filtro Sexo", 0, 0, new Font("Arial", 1, 12), new Color(0, 103, 0)));
        this.jPanel2.setRequestFocusEnabled(false);
        this.JCBSexo.setFont(new Font("Arial", 1, 12));
        this.JCBSexo.setModel(new DefaultComboBoxModel(new String[]{"Ambos", "Femenino", "Masculino"}));
        this.JCBSexo.setBorder(BorderFactory.createTitledBorder((Border) null, "Sexo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBSexo.setPreferredSize((Dimension) null);
        this.JCBSexo.setRequestFocusEnabled(false);
        this.JCBSexo.addItemListener(new ItemListener() { // from class: ParametrizacionN.JIFCClaseCita.9
            public void itemStateChanged(ItemEvent evt) {
                JIFCClaseCita.this.JCBSexoItemStateChanged(evt);
            }
        });
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.JCBSexo, -2, 125, -2).addGap(2, 2, 2)));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBSexo, -2, 50, -2));
        this.JCBClasificacion.setFont(new Font("Arial", 1, 12));
        this.JCBClasificacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Clasificacion", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBClasificacion.setPreferredSize((Dimension) null);
        this.JCBClasificacion.setRequestFocusEnabled(false);
        this.JCH4505.setFont(new Font("Arial", 1, 12));
        this.JCH4505.setText("4505?");
        this.JCH4505.setRequestFocusEnabled(false);
        this.JCH4505.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFCClaseCita.10
            public void actionPerformed(ActionEvent evt) {
                JIFCClaseCita.this.JCH4505ActionPerformed(evt);
            }
        });
        this.JCHEsPeriodico.setFont(new Font("Arial", 1, 12));
        this.JCHEsPeriodico.setText("Es Periódico?");
        this.JCHEsPeriodico.setRequestFocusEnabled(false);
        this.JCHEsPeriodico.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFCClaseCita.11
            public void actionPerformed(ActionEvent evt) {
                JIFCClaseCita.this.JCHEsPeriodicoActionPerformed(evt);
            }
        });
        this.JSPNR2175.setFont(new Font("Arial", 1, 12));
        this.JSPNR2175.setModel(new SpinnerNumberModel(0, 0, 6, 1));
        this.JSPNR2175.setBorder(BorderFactory.createTitledBorder((Border) null, "NR2175", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPNR2175.setPreferredSize((Dimension) null);
        this.JSPNR2175.setRequestFocusEnabled(false);
        this.JCBTipoTerapia.setFont(new Font("Arial", 1, 12));
        this.JCBTipoTerapia.setModel(new DefaultComboBoxModel(new String[]{"0", "1", "2"}));
        this.JCBTipoTerapia.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Terapia", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipoTerapia.setRequestFocusEnabled(false);
        this.JCBTipoTerapia.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFCClaseCita.12
            public void actionPerformed(ActionEvent evt) {
                JIFCClaseCita.this.JCBTipoTerapiaActionPerformed(evt);
            }
        });
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addGap(10, 10, 10).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JCBCausaExterna, -2, 221, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFNombreVariable, -2, 129, -2)).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JCHEsControl, -2, 100, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHEsSO, -2, 148, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHEsUrgencia, -1, -1, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JCHEsPeriodico).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCH4505, -2, 80, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHEstado, -2, 76, -2)).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JSPNR256, -2, 89, -2).addGap(8, 8, 8).addComponent(this.JSPNR2175, -2, 89, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JCBTipoTerapia, -2, 92, -2))).addGap(18, 18, 18).addComponent(this.jPanel2, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jPanel1, -1, -1, 32767)).addGroup(JPIDatosLayout.createSequentialGroup().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JTFNombre, -2, 511, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPDuracion, -2, 93, -2)).addComponent(this.JCBProcedimiento, -2, 616, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JCBEspecialidad, -2, 493, -2).addComponent(this.JCBFindalidad, -2, 493, -2))).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JCBTipoCita, -2, 271, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBTipoHistoria, -2, 178, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBPrograma, -2, 154, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBClasificacion, -2, 493, -2))).addContainerGap()));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFNombre, -2, 50, -2).addComponent(this.JSPDuracion, -2, 50, -2).addComponent(this.JCBEspecialidad, -1, -1, -2)).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addGap(8, 8, 8).addComponent(this.JCBFindalidad, -2, 50, -2)).addGroup(JPIDatosLayout.createSequentialGroup().addGap(18, 18, 18).addComponent(this.JCBProcedimiento, -2, 50, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBTipoCita, -1, -1, -2).addComponent(this.JCBTipoHistoria, -2, 50, -2).addComponent(this.JCBPrograma, -2, 50, -2).addComponent(this.JCBClasificacion, -2, 50, -2)).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JSPNR256, -2, 50, -2).addComponent(this.JTFNombreVariable, -2, 50, -2).addComponent(this.JCBCausaExterna, -2, 50, -2).addComponent(this.JSPNR2175, -2, 50, -2).addComponent(this.JCBTipoTerapia, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCHEsControl, -1, -1, -2).addComponent(this.JCHEsSO, -1, -1, -2).addComponent(this.JCHEsUrgencia, -1, -1, -2).addComponent(this.JCH4505).addComponent(this.JCHEstado, -1, -1, -2).addComponent(this.JCHEsPeriodico))).addGroup(JPIDatosLayout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -1, -1, -2).addComponent(this.jPanel2, GroupLayout.Alignment.TRAILING, -2, -1, -2)))).addContainerGap(28, 32767)));
        this.JTPGeneral.addTab("DATOS", this.JPIDatos);
        this.JBAgregarTipoAtencion.setFont(new Font("Arial", 1, 12));
        this.JBAgregarTipoAtencion.setForeground(Color.blue);
        this.JBAgregarTipoAtencion.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBAgregarTipoAtencion.setEnabled(false);
        this.JBAgregarTipoAtencion.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFCClaseCita.13
            public void actionPerformed(ActionEvent evt) {
                JIFCClaseCita.this.JBAgregarTipoAtencionActionPerformed(evt);
            }
        });
        this.JCBTipoAtencion.setFont(new Font("Arial", 1, 12));
        this.JCBTipoAtencion.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de Atención y/o Servicio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipoAtencion.setEnabled(false);
        this.JSPHistorico.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JSPHistorico.setEnabled(false);
        this.JTHistoricoTipoAtencion.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTHistoricoTipoAtencion.setEnabled(false);
        this.JTHistoricoTipoAtencion.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFCClaseCita.14
            public void mouseClicked(MouseEvent evt) {
                JIFCClaseCita.this.JTHistoricoTipoAtencionMouseClicked(evt);
            }
        });
        this.JSPHistorico.setViewportView(this.JTHistoricoTipoAtencion);
        this.jchEstado.setFont(new Font("Arial", 1, 12));
        this.jchEstado.setSelected(true);
        this.jchEstado.setText("Estado");
        this.jchEstado.setEnabled(false);
        this.jchEstado.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFCClaseCita.15
            public void actionPerformed(ActionEvent evt) {
                JIFCClaseCita.this.jchEstadoActionPerformed(evt);
            }
        });
        GroupLayout JPTipoAtencionLayout = new GroupLayout(this.JPTipoAtencion);
        this.JPTipoAtencion.setLayout(JPTipoAtencionLayout);
        JPTipoAtencionLayout.setHorizontalGroup(JPTipoAtencionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPTipoAtencionLayout.createSequentialGroup().addContainerGap().addGroup(JPTipoAtencionLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JSPHistorico, -2, 737, -2).addGroup(JPTipoAtencionLayout.createSequentialGroup().addComponent(this.JCBTipoAtencion, -2, 477, -2).addGap(30, 30, 30).addComponent(this.jchEstado, -2, 83, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBAgregarTipoAtencion, -1, -1, 32767))).addGap(400, 400, 400)));
        JPTipoAtencionLayout.setVerticalGroup(JPTipoAtencionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPTipoAtencionLayout.createSequentialGroup().addContainerGap().addGroup(JPTipoAtencionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPTipoAtencionLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBTipoAtencion, -2, 62, -2).addComponent(this.jchEstado)).addComponent(this.JBAgregarTipoAtencion, -2, 62, -2)).addGap(18, 18, 18).addComponent(this.JSPHistorico, -1, 224, 32767).addContainerGap()));
        this.JTPGeneral.addTab("TIPO ATENCIÓN", this.JPTipoAtencion);
        this.JPIHistorico.setRequestFocusEnabled(false);
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JSPDetalle.setRequestFocusEnabled(false);
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setPreferredSize((Dimension) null);
        this.JTDetalle.setRequestFocusEnabled(false);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalle.setSelectionMode(0);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFCClaseCita.16
            public void mouseClicked(MouseEvent evt) {
                JIFCClaseCita.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JPIFiltroNombre1.setBorder(BorderFactory.createTitledBorder((Border) null, "BÚSQUEDA", 0, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JPIFiltroNombre1.setRequestFocusEnabled(false);
        this.JCBFEspecialidad.setFont(new Font("Arial", 1, 12));
        this.JCBFEspecialidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Especialidad", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBFEspecialidad.setPreferredSize((Dimension) null);
        this.JCBFEspecialidad.addItemListener(new ItemListener() { // from class: ParametrizacionN.JIFCClaseCita.17
            public void itemStateChanged(ItemEvent evt) {
                JIFCClaseCita.this.JCBFEspecialidadItemStateChanged(evt);
            }
        });
        this.JCHFiltro.setFont(new Font("Arial", 1, 12));
        this.JCHFiltro.setText("Filtrar?");
        this.JCHFiltro.setPreferredSize((Dimension) null);
        this.JCHFiltro.setRequestFocusEnabled(false);
        this.JCHFiltro.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFCClaseCita.18
            public void actionPerformed(ActionEvent evt) {
                JIFCClaseCita.this.JCHFiltroActionPerformed(evt);
            }
        });
        GroupLayout JPIFiltroNombre1Layout = new GroupLayout(this.JPIFiltroNombre1);
        this.JPIFiltroNombre1.setLayout(JPIFiltroNombre1Layout);
        JPIFiltroNombre1Layout.setHorizontalGroup(JPIFiltroNombre1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFiltroNombre1Layout.createSequentialGroup().addContainerGap().addComponent(this.JCBFEspecialidad, -2, 330, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHFiltro, -2, 100, -2).addGap(488, 488, 488)));
        JPIFiltroNombre1Layout.setVerticalGroup(JPIFiltroNombre1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFiltroNombre1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBFEspecialidad, -2, 50, -2).addComponent(this.JCHFiltro, -2, -1, -2)));
        GroupLayout JPIHistoricoLayout = new GroupLayout(this.JPIHistorico);
        this.JPIHistorico.setLayout(JPIHistoricoLayout);
        JPIHistoricoLayout.setHorizontalGroup(JPIHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIHistoricoLayout.createSequentialGroup().addContainerGap().addGroup(JPIHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDetalle).addComponent(this.JPIFiltroNombre1, -1, -1, 32767)).addContainerGap()));
        JPIHistoricoLayout.setVerticalGroup(JPIHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIHistoricoLayout.createSequentialGroup().addContainerGap().addComponent(this.JPIFiltroNombre1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalle, -2, 212, -2).addContainerGap()));
        this.JTPGeneral.addTab("HISTORICO", this.JPIHistorico);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.JTPGeneral, -2, -1, -2).addContainerGap(-1, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.JTPGeneral).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEstadoActionPerformed(ActionEvent evt) {
        if (this.JCHEstado.isSelected()) {
            this.xestado = 0;
        } else {
            this.xestado = 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            Principal.txtNo.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
            this.JCBEspecialidad.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
            this.JTFNombre.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString());
            this.JSPDuracion.setValue(Integer.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString()));
            this.JCBProcedimiento.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 4).toString());
            this.JCBTipoCita.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 5).toString());
            this.JCBPrograma.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 6).toString());
            this.JCBTipoHistoria.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 7).toString());
            this.JTFNombreVariable.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 8).toString());
            this.JCHEstado.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 9).toString()).booleanValue());
            if (this.JCHEstado.isSelected()) {
                this.xestado = 0;
            } else {
                this.xestado = 1;
            }
            this.JCHEsControl.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 10).toString()).booleanValue());
            if (this.JCHEsControl.isSelected()) {
                this.xescontrol = 1;
            } else {
                this.xescontrol = 0;
            }
            this.JCHEsSO.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 11).toString()).booleanValue());
            if (this.JCHEsSO.isSelected()) {
                this.xso = 1;
            } else {
                this.xso = 0;
            }
            this.JCHEsUrgencia.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 12).toString()).booleanValue());
            if (this.JCHEsUrgencia.isSelected()) {
                this.xesurgencia = 1;
            } else {
                this.xesurgencia = 0;
            }
            this.JCBFindalidad.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 13).toString());
            this.JSPNR256.setValue(Integer.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 14).toString()));
            this.JCBCausaExterna.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 15).toString());
            this.JSPEdadI.setValue(Integer.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 16).toString()));
            this.JSPEdadM.setValue(Integer.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 17).toString()));
            if ("A".equals(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 18).toString())) {
                this.JCBSexo.setSelectedIndex(0);
            } else if ("F".equals(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 18).toString())) {
                this.JCBSexo.setSelectedIndex(1);
            } else {
                this.JCBSexo.setSelectedIndex(2);
            }
            this.JCBClasificacion.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 19).toString());
            this.JTPGeneral.setSelectedIndex(0);
            this.JCH4505.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 20).toString()).booleanValue());
            this.JCHEsPeriodico.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 21).toString()).booleanValue());
            if (this.JCHEsPeriodico.isSelected()) {
                this.esPeriodico = 1;
            } else {
                this.esPeriodico = 0;
            }
            habilitarTabAtencion();
            this.JSPNR2175.setValue(Integer.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 22).toString()));
            this.JCBTipoTerapia.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 23).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEsControlActionPerformed(ActionEvent evt) {
        if (this.JCHEsControl.isSelected()) {
            this.xescontrol = 1;
        } else {
            this.xescontrol = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEsSOActionPerformed(ActionEvent evt) {
        if (this.JCHEsSO.isSelected()) {
            this.xso = 1;
        } else {
            this.xso = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEsUrgenciaActionPerformed(ActionEvent evt) {
        if (this.JCHEsUrgencia.isSelected()) {
            this.xesurgencia = 1;
        } else {
            this.xesurgencia = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHFiltroActionPerformed(ActionEvent evt) {
        if (this.JCHFiltro.isSelected()) {
            this.xtipobusqueda = 1;
            this.JCBFEspecialidad.setEnabled(true);
            if (this.JCBFEspecialidad.getSelectedIndex() != -1 && this.xlleno) {
                mCargarDatosTabla();
                return;
            }
            return;
        }
        this.xtipobusqueda = 0;
        this.JCBFEspecialidad.setEnabled(false);
        mCargarDatosTabla();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBFEspecialidadItemStateChanged(ItemEvent evt) {
        if (this.xtipobusqueda == 1 && this.JCBFEspecialidad.getSelectedIndex() != -1 && this.xlleno) {
            mCargarDatosTabla();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBProcedimientoMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JDConsultar_InformacionG xjif = new JDConsultar_InformacionG(null, true, this, "PROCEDIMIENTOS");
            xjif.setVisible(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBSexoItemStateChanged(ItemEvent evt) {
        if (this.JCBSexo.getSelectedIndex() == 0) {
            this.xsexo = "A";
        } else if (this.JCBSexo.getSelectedIndex() == 1) {
            this.xsexo = "F";
        } else {
            this.xsexo = "M";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH4505ActionPerformed(ActionEvent evt) {
        if (this.JCH4505.isSelected()) {
            this.x4505 = 1;
        } else {
            this.x4505 = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTipoHistoriaActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBAgregarTipoAtencionActionPerformed(ActionEvent evt) {
        grabarTipoAtencionPorClaseCita();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jchEstadoActionPerformed(ActionEvent evt) {
        if (this.jchEstado.isSelected()) {
            this.estadoTipoAtencion = 1;
        } else {
            this.estadoTipoAtencion = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTHistoricoTipoAtencionMouseClicked(MouseEvent evt) {
        if (this.JTHistoricoTipoAtencion.getSelectedRow() != -1) {
            this.JCBTipoAtencion.setSelectedItem(this.modeloTipoAtencion.getValueAt(this.JTHistoricoTipoAtencion.getSelectedRow(), 0).toString());
            this.jchEstado.setSelected(Boolean.valueOf(this.modeloTipoAtencion.getValueAt(this.JTHistoricoTipoAtencion.getSelectedRow(), 1).toString()).booleanValue());
            if (this.JCHEstado.isSelected()) {
                this.estadoTipoAtencion = 0;
            } else {
                this.estadoTipoAtencion = 1;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEsPeriodicoActionPerformed(ActionEvent evt) {
        if (this.JCHEsPeriodico.isSelected()) {
            this.esPeriodico = 1;
        } else {
            this.esPeriodico = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTipoTerapiaActionPerformed(ActionEvent evt) {
        switch (this.JCBTipoTerapia.getSelectedIndex()) {
            case 1:
                this.clasificacionTipoTerapia = "1";
                break;
            case 2:
                this.clasificacionTipoTerapia = "2";
                break;
            default:
                this.clasificacionTipoTerapia = "0";
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBProgramaActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTipoCitaActionPerformed(ActionEvent evt) {
    }

    public void grabarTipoAtencionPorClaseCita() {
        String sql;
        if (!Principal.txtNo.getText().isEmpty()) {
            if (this.JCBTipoAtencion.getSelectedIndex() != -1) {
                int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "Guardar Tipo de Atención Por Cita", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n == 0) {
                    if (!validarDatoEnTabla(this.JTHistoricoTipoAtencion, 0, this.JCBTipoAtencion.getSelectedItem().toString())) {
                        sql = "INSERT  INTO `c_clasecita_tipoatencion` (idClaseCita,idTipoAtencion,Estado) VALUES ('" + Principal.txtNo.getText() + "','" + this.idTipoAtencion[this.JCBTipoAtencion.getSelectedIndex()] + "'," + this.estadoTipoAtencion + ")";
                    } else {
                        sql = "UPDATE `c_clasecita_tipoatencion` SET Estado= " + this.estadoTipoAtencion + "  WHERE IdClaseCita='" + Principal.txtNo.getText() + "' AND IdTipoAtencion='" + this.idTipoAtencion[this.JCBTipoAtencion.getSelectedIndex()] + "'";
                    }
                    this.xconsulta.ejecutarSQL(sql);
                    this.xconsulta.cerrarConexionBd();
                }
            } else {
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar Tipo de Atención", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JCBTipoAtencion.requestFocus();
            }
            cargarDatosTipoAtencion();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "No hay una clase de cita seleccionada", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JCBTipoAtencion.requestFocus();
    }

    private boolean validarDatoEnTabla(JTable jtable, int indexColumna, String cadena) {
        boolean resultado = false;
        if (jtable.getRowCount() > 0) {
            for (int i = 0; i < jtable.getRowCount(); i++) {
                if (jtable.getValueAt(i, indexColumna).equals(cadena)) {
                    resultado = true;
                }
            }
        }
        return resultado;
    }

    private boolean validarDatosEnTablaUpdate(JTable jtable, int indexColumna, String cadena) {
        boolean resultado = false;
        int cont = 0;
        if (jtable.getRowCount() > 0) {
            for (int i = 0; i < jtable.getRowCount(); i++) {
                if (jtable.getValueAt(i, indexColumna).equals(cadena)) {
                    cont++;
                }
            }
        }
        if (cont >= 1) {
            resultado = true;
        }
        System.out.println("contadot " + cont);
        return resultado;
    }

    public void mNuevo() {
        Principal.txtNo.setText("");
        this.JTFNombre.setText("");
        this.JSPDuracion.setValue(new Integer(0));
        this.JSPNR256.setValue(new Integer(0));
        this.JSPNR2175.setValue(new Integer(0));
        this.JSPEdadI.setValue(new Integer(0));
        this.JSPEdadM.setValue(new Integer(0));
        this.JCHEstado.setSelected(true);
        this.xestado = 0;
        this.JCHFiltro.setSelected(false);
        this.JCBFEspecialidad.setEnabled(false);
        this.xtipobusqueda = 0;
        this.JTFNombreVariable.setText("");
        this.JTFNombre.requestFocus();
        this.JCHEsSO.setSelected(false);
        this.xso = 0;
        mCargarDatosTabla();
        mIniciarComponentes();
        this.JCHEsPeriodico.setSelected(false);
        this.esPeriodico = 0;
        this.JCHEsControl.setSelected(false);
        this.xescontrol = 0;
        this.JCH4505.setSelected(false);
        this.x4505 = 0;
        this.JCHEsUrgencia.setSelected(false);
        this.xesurgencia = 0;
    }

    public void mGrabar() {
        String sql;
        if (!this.JTFNombre.getText().isEmpty()) {
            if (this.JCBEspecialidad.getSelectedIndex() != -1) {
                if (this.JCBProcedimiento.getSelectedIndex() != -1) {
                    if (this.JCBTipoCita.getSelectedIndex() != -1) {
                        if (this.JCBTipoHistoria.getSelectedIndex() != -1) {
                            if (this.JCBPrograma.getSelectedIndex() != -1) {
                                if (this.JCBFindalidad.getSelectedIndex() != -1) {
                                    if (this.JCBSexo.getSelectedIndex() != -1) {
                                        if (this.JCBClasificacion.getSelectedIndex() != -1) {
                                            if (!this.JSPDuracion.getValue().equals(0)) {
                                                int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                                                if (n == 0) {
                                                    if (Principal.txtNo.getText().isEmpty()) {
                                                        sql = " Insert into c_clasecita(Nbre, Duracion, Id_Especialidad, Id_Procedimiento, Id_TipoCita, Id_Historia, Id_Programa, Estado,NVariable, EsControl,EsSO, EsUrgencias,EsP,Id_Finalidad, NR256, Id_CausaExterna, EdadI, EdadM, Sexo, Id_ClasificacionTC, Fecha,Aplica4505, id_Resolicion_2175 , clasificacionTipoTerapia,UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.JSPDuracion.getValue() + "','" + this.xidespecialidad[this.JCBEspecialidad.getSelectedIndex()] + "','" + this.xidprocedimiento[this.JCBProcedimiento.getSelectedIndex()] + "','" + this.xidtipocita[this.JCBTipoCita.getSelectedIndex()] + "','" + this.xidtipohistoria[this.JCBTipoHistoria.getSelectedIndex()] + "','" + this.xidprograma[this.JCBPrograma.getSelectedIndex()] + "','" + this.xestado + "','" + this.JTFNombreVariable.getText() + "','" + this.xescontrol + "','" + this.xso + "','" + this.xesurgencia + "','" + this.esPeriodico + "','" + this.xidFindalidad[this.JCBFindalidad.getSelectedIndex()] + "','" + this.JSPNR256.getValue() + "','" + this.xcuasaexterna[this.JCBCausaExterna.getSelectedIndex()] + "','" + this.JSPEdadI.getValue() + "','" + this.JSPEdadM.getValue() + "','" + this.xsexo + "','" + this.xidclasificacion[this.JCBClasificacion.getSelectedIndex()] + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + this.x4505 + "','" + this.JSPNR2175.getValue() + "','" + this.clasificacionTipoTerapia + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                                                    } else {
                                                        sql = " update c_clasecita set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',Duracion='" + this.JSPDuracion.getValue() + "',Id_Especialidad='" + this.xidespecialidad[this.JCBEspecialidad.getSelectedIndex()] + "', Id_Procedimiento='" + this.xidprocedimiento[this.JCBProcedimiento.getSelectedIndex()] + "',Id_TipoCita='" + this.xidtipocita[this.JCBTipoCita.getSelectedIndex()] + "', Id_Historia='" + this.xidtipohistoria[this.JCBTipoHistoria.getSelectedIndex()] + "',Id_Programa='" + this.xidprograma[this.JCBPrograma.getSelectedIndex()] + "',EsControl='" + this.xescontrol + "',NVariable='" + this.JTFNombreVariable.getText() + "',Estado='" + this.xestado + "',EsSO='" + this.xso + "',EsUrgencias='" + this.xesurgencia + "',EsP='" + this.esPeriodico + "',Id_Finalidad='" + this.xidFindalidad[this.JCBFindalidad.getSelectedIndex()] + "',NR256='" + this.JSPNR256.getValue() + "',id_Resolicion_2175='" + this.JSPNR2175.getValue() + "',Id_CausaExterna='" + this.xcuasaexterna[this.JCBCausaExterna.getSelectedIndex()] + "',EdadI='" + this.JSPEdadI.getValue() + "',EdadM='" + this.JSPEdadM.getValue() + "',Sexo='" + this.xsexo + "',Aplica4505='" + this.x4505 + "',Id_ClasificacionTC='" + this.xidclasificacion[this.JCBClasificacion.getSelectedIndex()] + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', clasificacionTipoTerapia='" + this.clasificacionTipoTerapia + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                                                    }
                                                    System.out.println(sql);
                                                    this.xconsulta.ejecutarSQL(sql);
                                                    this.xconsulta.cerrarConexionBd();
                                                    mNuevo();
                                                    return;
                                                }
                                                return;
                                            }
                                            JOptionPane.showInternalMessageDialog(this, "Tiempo en clase de citas debe ser mayor que cero", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                            this.JSPDuracion.requestFocus();
                                            return;
                                        }
                                        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una clasificacion", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                        this.JCBClasificacion.requestFocus();
                                        return;
                                    }
                                    JOptionPane.showInternalMessageDialog(this, "Debe seleccionar el sexo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                    this.JCBSexo.requestFocus();
                                    return;
                                }
                                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una Finalidad", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                this.JCBFindalidad.requestFocus();
                                return;
                            }
                            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un tipo de programa", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                            this.JCBPrograma.requestFocus();
                            return;
                        }
                        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un tipo historia", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        this.JCBTipoHistoria.requestFocus();
                        return;
                    }
                    JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un tipo de cita", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    this.JCBTipoCita.requestFocus();
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un procedimiento", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JCBProcedimiento.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una especialidad", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBEspecialidad.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "El campo nombre no puede ser nulo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTFNombre.requestFocus();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearModeloTipoAtencion() {
        this.modeloTipoAtencion = new DefaultTableModel(new Object[0], new String[]{"Tipo de Atención", "Estado"}) { // from class: ParametrizacionN.JIFCClaseCita.19
            Class[] types = {String.class, Boolean.class};
            boolean[] canEdit = {false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTHistoricoTipoAtencion.setModel(this.modeloTipoAtencion);
        this.JTHistoricoTipoAtencion.getColumnModel().getColumn(0).setPreferredWidth(200);
        this.JTHistoricoTipoAtencion.getColumnModel().getColumn(1).setPreferredWidth(50);
    }

    private void cargarDatosTipoAtencion() {
        if (!Principal.txtNo.getText().isEmpty()) {
            try {
                crearModeloTipoAtencion();
                String xsql = "SELECT `g_tipoatencion`.`Nbre` AS tipoAtencion, `c_clasecita_tipoatencion`.`Estado`\nFROM `c_clasecita_tipoatencion`\nINNER JOIN `g_tipoatencion` ON(`c_clasecita_tipoatencion`.`idTipoAtencion`=`g_tipoatencion`.`Id`)\nWHERE `c_clasecita_tipoatencion`.`idClaseCita`='" + Principal.txtNo.getText() + "'";
                ResultSet xrs = this.xconsulta.traerRs(xsql);
                if (xrs.next()) {
                    xrs.beforeFirst();
                    int n = 0;
                    while (xrs.next()) {
                        this.modeloTipoAtencion.addRow(this.datosTipoAtencion);
                        this.modeloTipoAtencion.setValueAt(xrs.getString(1), n, 0);
                        this.modeloTipoAtencion.setValueAt(Boolean.valueOf(xrs.getBoolean(2)), n, 1);
                        n++;
                    }
                }
                xrs.close();
                this.xconsulta.cerrarConexionBd();
                return;
            } catch (SQLException ex) {
                Logger.getLogger(JIFFSubGrupoFactur.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                return;
            }
        }
        crearModeloTipoAtencion();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Especialidad", "Clase de Cita", "Duración", "Procedimiento", "Tipo Cita", "Programa Pyp", "Tipo Historia", "NVariable", "Estado", "EsControl", "SO?", "EsUrgencias", "Finalidad", "NR256", "Causa Externa", "EdadI", "EdadM", "Sexo", "Clasificacion", "Aplica4505", "EsP", "NR256", "Clasificacion Tipo Tratamiento"}) { // from class: ParametrizacionN.JIFCClaseCita.20
            Class[] types = {Long.class, String.class, String.class, Integer.class, String.class, String.class, String.class, String.class, String.class, Boolean.class, Boolean.class, Boolean.class, Boolean.class, String.class, Integer.class, String.class, Integer.class, Integer.class, String.class, String.class, Boolean.class, Boolean.class, Integer.class, Integer.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setAutoResizeMode(0);
        this.JTDetalle.doLayout();
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(400);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(5).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(5).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(6).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(6).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(7).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(7).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(8).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(8).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(10).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(10).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(12).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(12).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(14).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(14).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(15).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(16).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(16).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(16).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(17).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(17).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(17).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(18).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(18).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(18).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(19).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(19).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(19).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(20).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(21).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(22).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(22).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(22).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(23).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(23).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(23).setMaxWidth(0);
    }

    private void mCargarDatosTabla() {
        String xsql;
        try {
            mCrearModeloDatos();
            if (this.xtipobusqueda == 0) {
                xsql = "SELECT c_clasecita.Id, g_especialidad.Nbre, c_clasecita.Nbre, c_clasecita.Duracion    , CONCAT(g_procedimiento.Id,'-',g_procedimiento.Nbre), c_tipocita.Nbre, g_tipoprograma.Nbre, h_tipohistoria.Nbre, c_clasecita.NVariable, c_clasecita.Estado, c_clasecita.EsControl,  c_clasecita.EsSO ,  c_clasecita.EsUrgencias, `f_tipofinprocedimiento`.`Nbre`, c_clasecita.NR256 , g_causaexterna.Nbre AS causaexterna, c_clasecita.EdadI, c_clasecita.EdadM, c_clasecita.Sexo, `c_clasificacion_tipocita`.`Nbre` , c_clasecita.Aplica4505,c_clasecita.EsP  \n ,id_Resolicion_2175, `c_clasecita`.`clasificacionTipoTerapia` FROM c_clasecita INNER JOIN g_especialidad  ON (c_clasecita.Id_Especialidad = g_especialidad.Id) INNER JOIN g_procedimiento ON (c_clasecita.Id_Procedimiento = g_procedimiento.Id) \nINNER JOIN c_tipocita  ON (c_clasecita.Id_TipoCita = c_tipocita.Id) INNER JOIN h_tipohistoria  ON (c_clasecita.Id_Historia = h_tipohistoria.Id) INNER JOIN `c_clasificacion_tipocita`  ON (`c_clasificacion_tipocita`.`Id` = `c_clasecita`.`Id_ClasificacionTC`)  \nINNER JOIN g_tipoprograma  ON (g_tipoprograma.Id_TipoPrograma = c_clasecita.Id_Programa) INNER JOIN  `f_tipofinprocedimiento` ON (`c_clasecita`.`Id_Finalidad` = `f_tipofinprocedimiento`.`Id`) INNER JOIN g_causaexterna   ON (c_clasecita.Id_CausaExterna = g_causaexterna.Id) \nORDER BY g_especialidad.Nbre ASC, c_clasecita.Nbre ASC ";
            } else {
                xsql = "SELECT c_clasecita.Id, g_especialidad.Nbre, c_clasecita.Nbre, c_clasecita.Duracion    , CONCAT(g_procedimiento.Id,'-',g_procedimiento.Nbre), c_tipocita.Nbre, g_tipoprograma.Nbre, h_tipohistoria.Nbre, c_clasecita.NVariable, c_clasecita.Estado, c_clasecita.EsControl,  c_clasecita.EsSO ,  c_clasecita.EsUrgencias, `f_tipofinprocedimiento`.`Nbre`, c_clasecita.NR256 , g_causaexterna.Nbre AS causaexterna, c_clasecita.EdadI, c_clasecita.EdadM, c_clasecita.Sexo, `c_clasificacion_tipocita`.`Nbre` , c_clasecita.`Aplica4505`,c_clasecita.EsP \n , id_Resolicion_2175, `c_clasecita`.`clasificacionTipoTerapia` FROM c_clasecita INNER JOIN g_especialidad  ON (c_clasecita.Id_Especialidad = g_especialidad.Id) INNER JOIN g_procedimiento ON (c_clasecita.Id_Procedimiento = g_procedimiento.Id)   \nINNER JOIN c_tipocita  ON (c_clasecita.Id_TipoCita = c_tipocita.Id) INNER JOIN h_tipohistoria  ON (c_clasecita.Id_Historia = h_tipohistoria.Id) INNER JOIN `c_clasificacion_tipocita`  ON (`c_clasificacion_tipocita`.`Id` = `c_clasecita`.`Id_ClasificacionTC`)  \nINNER JOIN g_tipoprograma  ON (g_tipoprograma.Id_TipoPrograma = c_clasecita.Id_Programa) INNER JOIN  `f_tipofinprocedimiento` ON (`c_clasecita`.`Id_Finalidad` = `f_tipofinprocedimiento`.`Id`) INNER JOIN g_causaexterna   ON (c_clasecita.Id_CausaExterna = g_causaexterna.Id)  \nWHERE (c_clasecita.Id_Especialidad ='" + this.xidfiltro[this.JCBFEspecialidad.getSelectedIndex()] + "') ORDER BY g_especialidad.Nbre ASC, c_clasecita.Nbre ASC ";
            }
            ResultSet xrs = this.xconsulta.traerRs(xsql);
            Throwable th = null;
            try {
                try {
                    System.out.println(xsql);
                    if (xrs.next()) {
                        xrs.beforeFirst();
                        this.xmetodos.mEstablecerTextEditor(this.JTDetalle, 2);
                        this.xmetodos.mEstablecerTextEditor(this.JTDetalle, 4);
                        int n = 0;
                        while (xrs.next()) {
                            this.xmodelo.addRow(this.xdatos);
                            this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(1)), n, 0);
                            this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                            this.xmodelo.setValueAt(xrs.getString(3), n, 2);
                            this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt(4)), n, 3);
                            this.xmodelo.setValueAt(xrs.getString(5), n, 4);
                            this.xmodelo.setValueAt(xrs.getString(6), n, 5);
                            this.xmodelo.setValueAt(xrs.getString(7), n, 6);
                            this.xmodelo.setValueAt(xrs.getString(8), n, 7);
                            this.xmodelo.setValueAt(xrs.getString(9), n, 8);
                            this.xmodelo.setValueAt(Boolean.valueOf(!xrs.getBoolean(10)), n, 9);
                            this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(11)), n, 10);
                            this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(12)), n, 11);
                            this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(13)), n, 12);
                            this.xmodelo.setValueAt(xrs.getString(14), n, 13);
                            this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt(15)), n, 14);
                            this.xmodelo.setValueAt(xrs.getString(16), n, 15);
                            this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt(17)), n, 16);
                            this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt(18)), n, 17);
                            this.xmodelo.setValueAt(xrs.getString(19), n, 18);
                            this.xmodelo.setValueAt(xrs.getString(20), n, 19);
                            this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(21)), n, 20);
                            this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(22)), n, 21);
                            this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt(23)), n, 22);
                            this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt(24)), n, 23);
                            n++;
                        }
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
                    this.xconsulta.cerrarConexionBd();
                } finally {
                }
            } catch (Throwable th3) {
                th = th3;
                throw th3;
            }
        } catch (SQLException ex) {
            Logger.getLogger(JIFFSubGrupoFactur.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mIniciarComponentes() {
        this.xlleno = false;
        this.JCBEspecialidad.removeAllItems();
        this.xidespecialidad = this.xconsulta.llenarCombo("SELECT Id, Nbre FROM g_especialidad WHERE (Estado =0) ORDER BY Nbre ASC", this.xidespecialidad, this.JCBEspecialidad);
        this.JCBEspecialidad.setSelectedIndex(-1);
        this.JCBFEspecialidad.removeAllItems();
        this.xidfiltro = this.xconsulta.llenarCombo("SELECT `c_clasecita`.`Id_Especialidad`, `g_especialidad`.`Nbre` FROM `c_clasecita` INNER JOIN `g_especialidad` ON (`c_clasecita`.`Id_Especialidad` = `g_especialidad`.`Id`) GROUP BY `c_clasecita`.`Id_Especialidad` ORDER BY `g_especialidad`.`Nbre` ASC;", this.xidfiltro, this.JCBFEspecialidad);
        this.JCBFEspecialidad.setSelectedIndex(-1);
        this.JCBProcedimiento.removeAllItems();
        this.xidprocedimiento = this.xconsulta.llenarCombo("SELECT Id , concat(Id,'-',Nbre) FROM g_procedimiento WHERE (EsCita =1) ORDER BY Nbre ASC", this.xidprocedimiento, this.JCBProcedimiento);
        this.JCBProcedimiento.setSelectedIndex(-1);
        this.JCBTipoCita.removeAllItems();
        this.xidtipocita = this.xconsulta.llenarCombo("SELECT Id, Nbre FROM c_tipocita WHERE (Estado =0) ORDER BY Nbre ASC", this.xidtipocita, this.JCBTipoCita);
        this.JCBTipoCita.setSelectedIndex(-1);
        this.JCBTipoHistoria.removeAllItems();
        this.xidtipohistoria = this.xconsulta.llenarCombo("SELECT Id, Nbre FROM h_tipohistoria WHERE (Estado =0) ORDER BY Nbre ASC", this.xidtipohistoria, this.JCBTipoHistoria);
        this.JCBTipoHistoria.setSelectedIndex(-1);
        this.JCBPrograma.removeAllItems();
        this.xidprograma = this.xconsulta.llenarCombo("SELECT Id_TipoPrograma, Nbre FROM g_tipoprograma WHERE (Estado =0) ORDER BY Nbre ASC", this.xidprograma, this.JCBPrograma);
        this.JCBPrograma.setSelectedIndex(-1);
        this.JCBFindalidad.removeAllItems();
        this.xidFindalidad = this.xconsulta.llenarCombo("SELECT Id, Nbre FROM `f_tipofinprocedimiento`", this.xidFindalidad, this.JCBFindalidad);
        this.JCBFindalidad.setSelectedIndex(-1);
        this.JCBCausaExterna.removeAllItems();
        this.xcuasaexterna = this.xconsulta.llenarCombo("SELECT Id , Nbre FROM g_causaexterna WHERE (Estado =0)", this.xcuasaexterna, this.JCBCausaExterna);
        this.JCBCausaExterna.setSelectedIndex(-1);
        this.JCBClasificacion.removeAllItems();
        this.xidclasificacion = this.xconsulta.llenarCombo("SELECT Id , Nbre FROM c_clasificacion_tipocita WHERE (Estado =1) ORDER BY Nbre ASC", this.xidclasificacion, this.JCBClasificacion);
        this.JCBClasificacion.setSelectedIndex(-1);
        this.JCBTipoAtencion.removeAllItems();
        this.idTipoAtencion = this.xconsulta.llenarCombo("SELECT Id, Nbre FROM `g_tipoatencion` WHERE Estado=0 ORDER BY Nbre ASC", this.idTipoAtencion, this.JCBTipoAtencion);
        this.JCBTipoAtencion.setSelectedIndex(-1);
        this.JCBSexo.setSelectedIndex(-1);
        this.xconsulta.cerrarConexionBd();
        this.xlleno = true;
        habilitarTabAtencion();
        this.esPeriodico = 0;
        if (!Principal.informacionIps.getNombreIps().equals("I.P.S CENTRO DE TERAPIAS INTEGRALES PATRICIA MEJIA CACERES S.A.S.")) {
            this.JCBTipoTerapia.setVisible(false);
        } else {
            this.JCBTipoTerapia.setVisible(true);
        }
        this.JCBTipoTerapia.setSelectedIndex(-1);
    }
}
