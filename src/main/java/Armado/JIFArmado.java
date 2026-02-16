package Armado;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import Utilidades.WorkerSQL;
import com.genoma.plus.jpa.projection.IInformacionArmadoCuenta;
import com.genoma.plus.jpa.service.ILiquidacionService;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

/* JADX INFO: loaded from: GenomaP.jar:Armado/JIFArmado.class */
public class JIFArmado extends JInternalFrame {
    private String[] xidsubgrupo;
    private String[][] xidempresa;
    private String[][] xidservicio;
    private Object[] xdato;
    private String xsql;
    private DefaultTableModel xmodelo;
    private DefaultTableModel xmodelo1;
    private File xfile;
    private WorkerSQL xWorkerSQL;
    private Double xvalors;
    private Double xvalorp;
    private Double xvalore;
    private Double xvalord;
    private Double xvalorcp;
    private Double xvalorcm;
    private ButtonGroup JBGSeleccion;
    private ButtonGroup JBGSeleccion1;
    private JButton JBTExportar;
    private JComboBox JCBEmpresa;
    private JComboBox JCBGrupo;
    private JComboBox JCBSubGrupo;
    private JCheckBox JCHExportar;
    private JCheckBox JCHFiltroGrupo;
    private JCheckBox JCHFiltroUsuarioSistema;
    private JCheckBox JCH_CConSeguimiento;
    private JCheckBox JCH_CConSeguimiento1;
    public JDateChooser JDCFechaFin;
    public JDateChooser JDCFechaInicio;
    private JPanel JPEstado;
    private JPanel JPIDatoP;
    private JPanel JPITipoSeleccion;
    private JRadioButton JRBArmada;
    private JRadioButton JRBDeseleccionarTodo;
    private JRadioButton JRBPresentada;
    private JRadioButton JRBSelecionarTodo;
    private JRadioButton JRBSinArmar;
    private JScrollPane JSPResultado;
    private JTable JTBResultado;
    private JFormattedTextField JTFFNItems;
    private JFormattedTextField JTFFTotalCModeradora;
    private JFormattedTextField JTFFTotalCopago;
    private JFormattedTextField JTFFTotalDescuento;
    private JFormattedTextField JTFFTotalEps;
    private JFormattedTextField JTFFTotalServicio;
    private JFormattedTextField JTFFTotalUsuario;
    private JTextField JTFRuta;
    private JPanel jPanel1;
    private int xllenoc = 0;
    private int xllenocg = 0;
    private int xidescapitado = 0;
    private int xnitems = 0;
    private int xarmada = 0;
    private Metodos xmt = new Metodos();
    private ConsultasMySQL xct = new ConsultasMySQL();
    private final ILiquidacionService iLiquidacionService = (ILiquidacionService) Principal.contexto.getBean(ILiquidacionService.class);

    public JIFArmado() {
        initComponents();
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v69, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGSeleccion = new ButtonGroup();
        this.JBGSeleccion1 = new ButtonGroup();
        this.JPIDatoP = new JPanel();
        this.JDCFechaInicio = new JDateChooser();
        this.JDCFechaFin = new JDateChooser();
        this.JCBEmpresa = new JComboBox();
        this.JCBGrupo = new JComboBox();
        this.JCBSubGrupo = new JComboBox();
        this.JPEstado = new JPanel();
        this.JRBSinArmar = new JRadioButton();
        this.JRBArmada = new JRadioButton();
        this.JRBPresentada = new JRadioButton();
        this.JCHFiltroGrupo = new JCheckBox();
        this.JCHFiltroUsuarioSistema = new JCheckBox();
        this.JSPResultado = new JScrollPane();
        this.JTBResultado = new JTable();
        this.JTFFNItems = new JFormattedTextField();
        this.JTFFTotalServicio = new JFormattedTextField();
        this.JTFFTotalCModeradora = new JFormattedTextField();
        this.JTFFTotalCopago = new JFormattedTextField();
        this.JTFFTotalDescuento = new JFormattedTextField();
        this.JTFFTotalUsuario = new JFormattedTextField();
        this.JTFFTotalEps = new JFormattedTextField();
        this.JPITipoSeleccion = new JPanel();
        this.JRBSelecionarTodo = new JRadioButton();
        this.JRBDeseleccionarTodo = new JRadioButton();
        this.jPanel1 = new JPanel();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        this.JCHExportar = new JCheckBox();
        this.JCH_CConSeguimiento = new JCheckBox();
        this.JCH_CConSeguimiento1 = new JCheckBox();
        setClosable(true);
        setIconifiable(true);
        setTitle("AUDITORIA Y ARMADO DE FACTURAS DE PROCEDIMIENTOS");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjifarmado");
        this.JPIDatoP.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS PARA CONSULTA", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JDCFechaInicio.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicio", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaInicio.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaInicio.setFont(new Font("Arial", 1, 12));
        this.JDCFechaInicio.addPropertyChangeListener(new PropertyChangeListener() { // from class: Armado.JIFArmado.1
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFArmado.this.JDCFechaInicioPropertyChange(evt);
            }
        });
        this.JDCFechaFin.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Fin", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaFin.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaFin.setFont(new Font("Arial", 1, 12));
        this.JDCFechaFin.addPropertyChangeListener(new PropertyChangeListener() { // from class: Armado.JIFArmado.2
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFArmado.this.JDCFechaFinPropertyChange(evt);
            }
        });
        this.JCBEmpresa.setFont(new Font("Arial", 1, 12));
        this.JCBEmpresa.setBorder(BorderFactory.createTitledBorder((Border) null, "Empresa", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBEmpresa.addItemListener(new ItemListener() { // from class: Armado.JIFArmado.3
            public void itemStateChanged(ItemEvent evt) {
                JIFArmado.this.JCBEmpresaItemStateChanged(evt);
            }
        });
        this.JCBGrupo.setFont(new Font("Arial", 1, 12));
        this.JCBGrupo.setBorder(BorderFactory.createTitledBorder((Border) null, "Grupo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBGrupo.addItemListener(new ItemListener() { // from class: Armado.JIFArmado.4
            public void itemStateChanged(ItemEvent evt) {
                JIFArmado.this.JCBGrupoItemStateChanged(evt);
            }
        });
        this.JCBSubGrupo.setFont(new Font("Arial", 1, 12));
        this.JCBSubGrupo.setBorder(BorderFactory.createTitledBorder((Border) null, "SubGrupo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBSubGrupo.addItemListener(new ItemListener() { // from class: Armado.JIFArmado.5
            public void itemStateChanged(ItemEvent evt) {
                JIFArmado.this.JCBSubGrupoItemStateChanged(evt);
            }
        });
        this.JPEstado.setBorder(BorderFactory.createTitledBorder((Border) null, "Estado", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBGSeleccion.add(this.JRBSinArmar);
        this.JRBSinArmar.setFont(new Font("Arial", 1, 12));
        this.JRBSinArmar.setSelected(true);
        this.JRBSinArmar.setText("Sin Armar");
        this.JRBSinArmar.addActionListener(new ActionListener() { // from class: Armado.JIFArmado.6
            public void actionPerformed(ActionEvent evt) {
                JIFArmado.this.JRBSinArmarActionPerformed(evt);
            }
        });
        this.JBGSeleccion.add(this.JRBArmada);
        this.JRBArmada.setFont(new Font("Arial", 1, 12));
        this.JRBArmada.setText("Armada");
        this.JRBArmada.addActionListener(new ActionListener() { // from class: Armado.JIFArmado.7
            public void actionPerformed(ActionEvent evt) {
                JIFArmado.this.JRBArmadaActionPerformed(evt);
            }
        });
        this.JBGSeleccion.add(this.JRBPresentada);
        this.JRBPresentada.setFont(new Font("Arial", 1, 12));
        this.JRBPresentada.setText("Presentada");
        this.JRBPresentada.addActionListener(new ActionListener() { // from class: Armado.JIFArmado.8
            public void actionPerformed(ActionEvent evt) {
                JIFArmado.this.JRBPresentadaActionPerformed(evt);
            }
        });
        GroupLayout JPEstadoLayout = new GroupLayout(this.JPEstado);
        this.JPEstado.setLayout(JPEstadoLayout);
        JPEstadoLayout.setHorizontalGroup(JPEstadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPEstadoLayout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JRBSinArmar).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBArmada).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBPresentada)));
        JPEstadoLayout.setVerticalGroup(JPEstadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPEstadoLayout.createSequentialGroup().addContainerGap().addGroup(JPEstadoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBSinArmar).addComponent(this.JRBArmada).addComponent(this.JRBPresentada)).addContainerGap(-1, 32767)));
        this.JCHFiltroGrupo.setFont(new Font("Arial", 1, 12));
        this.JCHFiltroGrupo.setSelected(true);
        this.JCHFiltroGrupo.setText("Filtro?");
        this.JCHFiltroGrupo.addActionListener(new ActionListener() { // from class: Armado.JIFArmado.9
            public void actionPerformed(ActionEvent evt) {
                JIFArmado.this.JCHFiltroGrupoActionPerformed(evt);
            }
        });
        this.JCHFiltroUsuarioSistema.setBackground(new Color(51, 153, 255));
        this.JCHFiltroUsuarioSistema.setFont(new Font("Arial", 1, 12));
        this.JCHFiltroUsuarioSistema.setText("Filtro Por Usuario Sistema?");
        this.JCHFiltroUsuarioSistema.addActionListener(new ActionListener() { // from class: Armado.JIFArmado.10
            public void actionPerformed(ActionEvent evt) {
                JIFArmado.this.JCHFiltroUsuarioSistemaActionPerformed(evt);
            }
        });
        GroupLayout JPIDatoPLayout = new GroupLayout(this.JPIDatoP);
        this.JPIDatoP.setLayout(JPIDatoPLayout);
        JPIDatoPLayout.setHorizontalGroup(JPIDatoPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatoPLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatoPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHFiltroUsuarioSistema).addGroup(JPIDatoPLayout.createSequentialGroup().addComponent(this.JCBGrupo, -2, 368, -2).addGap(18, 18, 18).addComponent(this.JCBSubGrupo, -2, 463, -2).addGap(18, 18, 18).addComponent(this.JCHFiltroGrupo)).addGroup(JPIDatoPLayout.createSequentialGroup().addComponent(this.JDCFechaInicio, -2, 120, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JDCFechaFin, -2, 120, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBEmpresa, -2, 417, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPEstado, -2, -1, -2))).addContainerGap(-1, 32767)));
        JPIDatoPLayout.setVerticalGroup(JPIDatoPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatoPLayout.createSequentialGroup().addGroup(JPIDatoPLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JCBEmpresa, -2, 51, -2).addGroup(JPIDatoPLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDCFechaInicio, -2, 57, -2).addComponent(this.JDCFechaFin, -2, 57, -2)).addComponent(this.JPEstado, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JCHFiltroUsuarioSistema).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIDatoPLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBGrupo, -2, 51, -2).addComponent(this.JCBSubGrupo, -2, 51, -2).addComponent(this.JCHFiltroGrupo)).addContainerGap()));
        this.JSPResultado.setBorder(BorderFactory.createTitledBorder((Border) null, "ORDENES O FACTURAS", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTBResultado.setFont(new Font("Arial", 1, 12));
        this.JTBResultado.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTBResultado.setEditingColumn(1);
        this.JTBResultado.setEditingRow(1);
        this.JTBResultado.setRowHeight(25);
        this.JTBResultado.setSelectionBackground(new Color(255, 255, 255));
        this.JTBResultado.setSelectionForeground(Color.red);
        this.JTBResultado.addMouseListener(new MouseAdapter() { // from class: Armado.JIFArmado.11
            public void mouseClicked(MouseEvent evt) {
                JIFArmado.this.JTBResultadoMouseClicked(evt);
            }
        });
        this.JSPResultado.setViewportView(this.JTBResultado);
        this.JTFFNItems.setEditable(false);
        this.JTFFNItems.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Items", 1, 0, new Font("Arial", 1, 12), Color.red));
        this.JTFFNItems.setHorizontalAlignment(4);
        this.JTFFNItems.setText("0");
        this.JTFFNItems.setFont(new Font("Arial", 1, 14));
        this.JTFFTotalServicio.setEditable(false);
        this.JTFFTotalServicio.setBorder(BorderFactory.createTitledBorder((Border) null, "TOTAL SERVICIO", 1, 0, new Font("Arial", 1, 12), Color.red));
        this.JTFFTotalServicio.setHorizontalAlignment(4);
        this.JTFFTotalServicio.setText("0");
        this.JTFFTotalServicio.setFont(new Font("Arial", 1, 14));
        this.JTFFTotalCModeradora.setEditable(false);
        this.JTFFTotalCModeradora.setBorder(BorderFactory.createTitledBorder((Border) null, "C/MODERADORA", 1, 0, new Font("Arial", 1, 12), Color.red));
        this.JTFFTotalCModeradora.setHorizontalAlignment(4);
        this.JTFFTotalCModeradora.setText("0");
        this.JTFFTotalCModeradora.setFont(new Font("Arial", 1, 14));
        this.JTFFTotalCopago.setEditable(false);
        this.JTFFTotalCopago.setBorder(BorderFactory.createTitledBorder((Border) null, "COPAGO", 1, 0, new Font("Arial", 1, 12), Color.red));
        this.JTFFTotalCopago.setHorizontalAlignment(4);
        this.JTFFTotalCopago.setText("0");
        this.JTFFTotalCopago.setFont(new Font("Arial", 1, 14));
        this.JTFFTotalDescuento.setEditable(false);
        this.JTFFTotalDescuento.setBorder(BorderFactory.createTitledBorder((Border) null, "DESCUENTO", 1, 0, new Font("Arial", 1, 12), Color.red));
        this.JTFFTotalDescuento.setHorizontalAlignment(4);
        this.JTFFTotalDescuento.setText("0");
        this.JTFFTotalDescuento.setFont(new Font("Arial", 1, 14));
        this.JTFFTotalUsuario.setEditable(false);
        this.JTFFTotalUsuario.setBorder(BorderFactory.createTitledBorder((Border) null, "USUARIO", 1, 0, new Font("Arial", 1, 12), Color.red));
        this.JTFFTotalUsuario.setHorizontalAlignment(4);
        this.JTFFTotalUsuario.setText("0");
        this.JTFFTotalUsuario.setFont(new Font("Arial", 1, 14));
        this.JTFFTotalEps.setEditable(false);
        this.JTFFTotalEps.setBorder(BorderFactory.createTitledBorder((Border) null, "EPS", 1, 0, new Font("Arial", 1, 12), Color.red));
        this.JTFFTotalEps.setHorizontalAlignment(4);
        this.JTFFTotalEps.setText("0");
        this.JTFFTotalEps.setFont(new Font("Arial", 1, 14));
        this.JPITipoSeleccion.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de Selección", 0, 0, new Font("Arial", 1, 12)));
        this.JBGSeleccion1.add(this.JRBSelecionarTodo);
        this.JRBSelecionarTodo.setFont(new Font("Arial", 1, 12));
        this.JRBSelecionarTodo.setText("Todo");
        this.JRBSelecionarTodo.addActionListener(new ActionListener() { // from class: Armado.JIFArmado.12
            public void actionPerformed(ActionEvent evt) {
                JIFArmado.this.JRBSelecionarTodoActionPerformed(evt);
            }
        });
        this.JBGSeleccion1.add(this.JRBDeseleccionarTodo);
        this.JRBDeseleccionarTodo.setFont(new Font("Arial", 1, 12));
        this.JRBDeseleccionarTodo.setSelected(true);
        this.JRBDeseleccionarTodo.setText("Ninguno");
        this.JRBDeseleccionarTodo.addActionListener(new ActionListener() { // from class: Armado.JIFArmado.13
            public void actionPerformed(ActionEvent evt) {
                JIFArmado.this.JRBDeseleccionarTodoActionPerformed(evt);
            }
        });
        GroupLayout JPITipoSeleccionLayout = new GroupLayout(this.JPITipoSeleccion);
        this.JPITipoSeleccion.setLayout(JPITipoSeleccionLayout);
        JPITipoSeleccionLayout.setHorizontalGroup(JPITipoSeleccionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPITipoSeleccionLayout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JRBSelecionarTodo).addGap(77, 77, 77)).addGroup(JPITipoSeleccionLayout.createSequentialGroup().addContainerGap().addComponent(this.JRBDeseleccionarTodo).addContainerGap()));
        JPITipoSeleccionLayout.setVerticalGroup(JPITipoSeleccionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPITipoSeleccionLayout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JRBSelecionarTodo).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBDeseleccionarTodo)));
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "EXPORTAR", 0, 0, new Font("Arial", 1, 12), new Color(0, 103, 0)));
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ruta", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: Armado.JIFArmado.14
            public void mouseClicked(MouseEvent evt) {
                JIFArmado.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JTFRuta.addActionListener(new ActionListener() { // from class: Armado.JIFArmado.15
            public void actionPerformed(ActionEvent evt) {
                JIFArmado.this.JTFRutaActionPerformed(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 10));
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/actualizar.png")));
        this.JBTExportar.addActionListener(new ActionListener() { // from class: Armado.JIFArmado.16
            public void actionPerformed(ActionEvent evt) {
                JIFArmado.this.JBTExportarActionPerformed(evt);
            }
        });
        this.JCHExportar.setFont(new Font("Arial", 1, 12));
        this.JCHExportar.setText("Datos");
        this.JCHExportar.addActionListener(new ActionListener() { // from class: Armado.JIFArmado.17
            public void actionPerformed(ActionEvent evt) {
                JIFArmado.this.JCHExportarActionPerformed(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JCHExportar).addGap(305, 305, 305)).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addComponent(this.JBTExportar, -2, 91, -2).addContainerGap()))).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.JTFRuta, -2, 248, -2).addContainerGap(114, 32767))));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addComponent(this.JBTExportar, -2, 74, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JCHExportar)).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(12, 12, 12).addComponent(this.JTFRuta, -2, 57, -2).addContainerGap(27, 32767))));
        this.JCH_CConSeguimiento.setBackground(Color.green);
        this.JCH_CConSeguimiento.setFont(new Font("Arial", 1, 12));
        this.JCH_CConSeguimiento.setText("Con seguimiento pendiente por cerrar");
        this.JCH_CConSeguimiento1.setBackground(Color.pink);
        this.JCH_CConSeguimiento1.setFont(new Font("Arial", 1, 12));
        this.JCH_CConSeguimiento1.setText("Ingreso con diagnóstico(Solo para consultas)");
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JTFFNItems, -2, 72, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.JTFFTotalDescuento, -2, 116, -2)).addComponent(this.JTFFTotalServicio)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFFTotalUsuario, -1, 123, 32767).addComponent(this.JTFFTotalCModeradora)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JTFFTotalEps).addComponent(this.JTFFTotalCopago, -2, 111, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JPITipoSeleccion, -2, 124, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel1, -2, -1, -2)).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIDatoP, -1, -1, -2).addComponent(this.JSPResultado, -2, 996, -2).addGroup(layout.createSequentialGroup().addComponent(this.JCH_CConSeguimiento, -2, 261, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCH_CConSeguimiento1, -2, 325, -2))).addGap(0, 0, 32767))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatoP, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPResultado, -2, 416, -2).addGap(4, 4, 4).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCH_CConSeguimiento).addComponent(this.JCH_CConSeguimiento1)).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.jPanel1, -2, -1, -2)).addGroup(layout.createSequentialGroup().addGap(18, 18, 18).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JPITipoSeleccion, -2, -1, -2).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFNItems, -2, -1, -2).addComponent(this.JTFFTotalCModeradora, -2, -1, -2).addComponent(this.JTFFTotalCopago, -2, -1, -2).addComponent(this.JTFFTotalServicio, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFTotalUsuario, -2, -1, -2).addComponent(this.JTFFTotalEps, -2, -1, -2))).addComponent(this.JTFFTotalDescuento, -2, -1, -2)))).addContainerGap(-1, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBEmpresaItemStateChanged(ItemEvent evt) {
        if (this.xllenoc == 1 && this.JCBEmpresa.getSelectedIndex() != -1) {
            ConsultasMySQL xct1 = new ConsultasMySQL();
            this.JCBSubGrupo.removeAllItems();
            this.JCBGrupo.removeAllItems();
            mCrearTablaDetalle();
            this.xsql = "SELECT `f_gruposervicio`.`Id_GrupoServicio` , `f_gruposervicio`.`Nbre`, `f_gruposervicio`.`ConSubGrupo` \nFROM `ingreso` \nINNER JOIN  `f_liquidacion`  ON (`ingreso`.`Id` = `f_liquidacion`.`Id_Ingreso`) \nINNER JOIN `f_subgrupo_empresa`  ON (`f_liquidacion`.`Id_SubGrupoServicio` = `f_subgrupo_empresa`.`Id`) \nINNER JOIN  `f_empresacontxconvenio`  ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`) \nINNER JOIN  `f_subgruposervicio`  ON (`f_subgrupo_empresa`.`Id_SubGrupo` = `f_subgruposervicio`.`Id_SubgrupoServicio`)\nINNER JOIN  `f_gruposervicio`  ON (`f_subgruposervicio`.`Id_GrupoServicio` = `f_gruposervicio`.`Id_GrupoServicio`) \nleft join f_factura_capita ffc on (ffc.Id_Liquidacion=f_liquidacion.Id)\nleft join f_factura_evento ffe  on (ffe.Id_Liquidacion=f_liquidacion.Id)\nWHERE (`f_empresacontxconvenio`.`Id` ='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "' \nAND (ifnull(ffc.Fecha_FacturaCapita, ffe.Fecha_FacturaEvento) between '" + this.xmt.formatoAMD1.format(this.JDCFechaInicio.getDate()) + "' and  '" + this.xmt.formatoAMD1.format(this.JDCFechaFin.getDate()) + "'  )) \nGROUP BY `f_gruposervicio`.`Id_GrupoServicio` \nORDER BY `f_gruposervicio`.`Nbre` ASC ";
            this.xidservicio = xct1.llenarComboyLista(this.xsql, this.xidservicio, this.JCBGrupo, 3);
            this.JCBGrupo.setSelectedIndex(-1);
            this.xllenocg = 1;
            xct1.cerrarConexionBd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBGrupoItemStateChanged(ItemEvent evt) {
        if (this.xllenocg == 1 && this.JCBGrupo.getSelectedIndex() != -1) {
            this.JCBSubGrupo.removeAllItems();
            mCrearTablaDetalle();
            ConsultasMySQL xct1 = new ConsultasMySQL();
            this.xsql = "SELECT f_liquidacion.Id_SubGrupoServicio, f_subgruposervicio.Nbre \nFROM ingreso \nINNER JOIN f_liquidacion  ON (ingreso.Id = f_liquidacion.Id_Ingreso) \nINNER JOIN f_subgrupo_empresa  ON (f_liquidacion.Id_SubGrupoServicio = f_subgrupo_empresa.Id) AND (ingreso.Id_EmpresaContxConv = f_subgrupo_empresa.Id_Empresa) \nINNER JOIN f_subgruposervicio  ON (f_subgrupo_empresa.Id_SubGrupo = f_subgruposervicio.Id_SubgrupoServicio) \nINNER JOIN f_empresacontxconvenio  ON (ingreso.Id_EmpresaContxConv = f_empresacontxconvenio.Id) AND (f_subgrupo_empresa.Id_Empresa = f_empresacontxconvenio.Id) \nleft join f_factura_capita ffc on (ffc.Id_Liquidacion=f_liquidacion.Id)\nleft join f_factura_evento ffe  on (ffe.Id_Liquidacion=f_liquidacion.Id)\nWHERE (`f_empresacontxconvenio`.`Id` ='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "' \nAND (ifnull(ffc.Fecha_FacturaCapita, ffe.Fecha_FacturaEvento) between '" + this.xmt.formatoAMD1.format(this.JDCFechaInicio.getDate()) + "' and  '" + this.xmt.formatoAMD1.format(this.JDCFechaFin.getDate()) + "' ) \nAND `f_subgruposervicio`.`Id_GrupoServicio` ='" + this.xidservicio[this.JCBGrupo.getSelectedIndex()][0] + "') \nGROUP BY `f_liquidacion`.`Id_SubGrupoServicio` \nORDER BY `f_subgruposervicio`.`Nbre` ASC ";
            this.xidsubgrupo = xct1.llenarCombo(this.xsql, this.xidsubgrupo, this.JCBSubGrupo);
            xct1.cerrarConexionBd();
            this.xllenocg = 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBSubGrupoItemStateChanged(ItemEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSinArmarActionPerformed(ActionEvent evt) {
        this.xarmada = 0;
        mBuscar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBArmadaActionPerformed(ActionEvent evt) {
        this.xarmada = 1;
        mBuscar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBPresentadaActionPerformed(ActionEvent evt) {
        this.xarmada = 2;
        mBuscar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBResultadoMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            if (this.JTBResultado.getSelectedRow() == -1 || this.JTBResultado.getSelectedColumn() != 0) {
                if (this.JTBResultado.getSelectedRow() != -1 && this.JTBResultado.getSelectedColumn() == 3) {
                    cargarDatosFacturaNuevo(1);
                    return;
                } else if (this.JTBResultado.getSelectedRow() != -1 && this.JTBResultado.getSelectedColumn() == 5) {
                    cargarDatosFacturaNuevo(2);
                    return;
                } else {
                    if (this.JTBResultado.getSelectedRow() == -1 || this.JTBResultado.getSelectedColumn() == 4) {
                    }
                    return;
                }
            }
            Object[] botones1 = {"Ordenar Información", "Visualizar", "Cerrar"};
            int v = JOptionPane.showOptionDialog(this, "Que desea hacer?", "CONSULTAR", 0, 3, (Icon) null, botones1, "Ordenar Información");
            if (v == 0) {
                cargarDatosFacturaNuevo(3);
                return;
            }
            Object[] botones = {"Impresión Factura", "Historia Clinica", "Cerrar"};
            int n = JOptionPane.showOptionDialog(this, "Que desea hacer?", "Consultar", 0, 3, (Icon) null, botones, "Cerrar");
            if (n == 0) {
                Principal.xclasegc.imprimir_FacturayOrden(1, this.xmodelo.getValueAt(this.JTBResultado.getSelectedRow(), 0).toString(), this.xmodelo.getValueAt(this.JTBResultado.getSelectedRow(), 12).toString(), Principal.usuarioSistemaDTO.getLogin(), Integer.valueOf(this.xidempresa[this.JCBEmpresa.getSelectedIndex()][1]).intValue(), 1, this.xidempresa[this.JCBEmpresa.getSelectedIndex()][3], 0);
                return;
            } else {
                if (n == 1) {
                    Principal.xclasegc.cargarPantalla("Gestion Hc");
                    Principal.xclasegc.xjifconsutlarhc.xgestiodoc.xjppersona.txtHistoria.setText(this.xmodelo.getValueAt(this.JTBResultado.getSelectedRow(), 2).toString());
                    Principal.xclasegc.xjifconsutlarhc.xgestiodoc.xjppersona.buscar(2);
                    Principal.xclasegc.xjifconsutlarhc.xgestiodoc.mBuscar();
                    return;
                }
                return;
            }
        }
        if (this.JTBResultado.getSelectedRow() == -1 || this.JTBResultado.getSelectedColumn() != 4) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSelecionarTodoActionPerformed(ActionEvent evt) {
        mModificarEstadoenTabla(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBDeseleccionarTodoActionPerformed(ActionEvent evt) {
        mModificarEstadoenTabla(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            if (this.JCHExportar.isSelected()) {
                JFileChooser xfilec = new JFileChooser(this.JTFRuta.getText());
                xfilec.setFileSelectionMode(1);
                int xv = xfilec.showOpenDialog(this);
                if (xv == 0) {
                    this.xfile = xfilec.getSelectedFile();
                    this.JTFRuta.setText(this.xfile.getAbsolutePath());
                    return;
                }
                return;
            }
            JFileChooser xfilec2 = new JFileChooser(this.JTFRuta.getText());
            xfilec2.setFileSelectionMode(1);
            int xv2 = xfilec2.showOpenDialog(this);
            if (xv2 == 0) {
                this.xfile = xfilec2.getSelectedFile();
                this.JTFRuta.setText(this.xfile.getAbsolutePath() + this.xmt.getBarra());
                this.JTFRuta.requestFocus();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTExportarActionPerformed(ActionEvent evt) {
        if (!this.JTFRuta.getText().isEmpty()) {
            if (this.JTBResultado.getRowCount() >= 0) {
                if (this.JCHExportar.isSelected()) {
                    this.xWorkerSQL = new WorkerSQL("Generando PDF", this);
                    this.xWorkerSQL.execute();
                    return;
                } else {
                    int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    if (n == 0) {
                        this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTBResultado, this.xmt.mTraerUrlBD(this.JTFRuta.getText()), getTitle());
                        return;
                    }
                    return;
                }
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un ruta valida", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTFRuta.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDCFechaInicioPropertyChange(PropertyChangeEvent evt) {
        if (this.xllenoc == 1) {
            mLLenarCEmpresa();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDCFechaFinPropertyChange(PropertyChangeEvent evt) {
        if (this.xllenoc == 1) {
            mLLenarCEmpresa();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHExportarActionPerformed(ActionEvent evt) {
        if (this.JCHExportar.isSelected()) {
            this.JTFRuta.setText(this.xmt.getDirectorioExportacion());
            this.JCHExportar.setText("Soporte PDF");
        } else {
            this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
            this.JCHExportar.setText("Datos");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHFiltroGrupoActionPerformed(ActionEvent evt) {
        if (this.JCHFiltroGrupo.isSelected()) {
            this.JCBSubGrupo.setSelectedIndex(-1);
            this.JCBSubGrupo.setEnabled(true);
        } else {
            this.JCBSubGrupo.setSelectedIndex(-1);
            this.JCBSubGrupo.setEnabled(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHFiltroUsuarioSistemaActionPerformed(ActionEvent evt) {
    }

    public void mNuevo() {
        this.xllenoc = 0;
        this.xllenocg = 0;
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        this.JDCFechaInicio.setDate(this.xmt.getFechaActual());
        this.JDCFechaFin.setDate(this.xmt.getFechaActual());
        this.JCHFiltroGrupo.setSelected(true);
        this.JTFFTotalServicio.setValue(new Double(0.0d));
        this.JTFFTotalUsuario.setValue(new Double(0.0d));
        this.JTFFTotalCModeradora.setValue(new Double(0.0d));
        this.JTFFTotalCopago.setValue(new Double(0.0d));
        this.JTFFTotalDescuento.setValue(new Double(0.0d));
        this.JTFFTotalEps.setValue(new Double(0.0d));
        this.JCHExportar.setSelected(false);
        this.JCHExportar.setText("Datos");
        this.xllenoc = 1;
    }

    private void mLLenarCEmpresa() {
        this.xllenoc = 0;
        this.xllenocg = 0;
        this.JCBSubGrupo.removeAllItems();
        this.JCBGrupo.removeAllItems();
        this.JCBEmpresa.removeAllItems();
        if (Principal.informacionIps.getNombreIps().equals("FUNDACIÓN PANZENÚ")) {
            this.xsql = "SELECT  `f_empresacontxconvenio`.`Id` , `f_empresacontxconvenio`.`Nbre` , `f_empresacontxconvenio`.`EsCapitado`,\ng_empresacont.Id_TipoPlan, g_ips.`Nbre` \n-- ,ifnull(ffc.Fecha_FacturaCapita, ffe.Fecha_FacturaEvento) fecha \n-- , ifnull(ffc.EstaArmada , ffe.EstaArmada ) estaArmada\n-- , ifnull(ffc.Estado , ffe.Estado) Estado\nFROM `f_liquidacion`  \nINNER JOIN  `f_empresacontxconvenio`  ON (`f_liquidacion`.`IdEmpresaContxConv` = `f_empresacontxconvenio`.`Id`) INNER JOIN  `g_empresacont`  ON (`g_empresacont`.`Id_empresa` = `f_empresacontxconvenio`.`Id_EmpresaCont`) \nINNER JOIN g_ips  ON (f_empresacontxconvenio.`Id_GIps` = g_ips.`Id`)\nleft join f_factura_capita ffc on (ffc.Id_Liquidacion=f_liquidacion.Id)\nleft join f_factura_evento ffe  on (ffe.Id_Liquidacion=f_liquidacion.Id)\n\nWHERE (ifnull(ffc.Fecha_FacturaCapita, ffe.Fecha_FacturaEvento) between '" + this.xmt.formatoAMD1.format(this.JDCFechaInicio.getDate()) + "' and  '" + this.xmt.formatoAMD1.format(this.JDCFechaFin.getDate()) + "' and \n`f_liquidacion`.`Estado`=0  and ifnull(ffc.Estado , ffe.Estado)=0) \nGROUP BY `f_empresacontxconvenio`.`Id` ORDER BY `f_empresacontxconvenio`.`Nbre` ASC ";
        } else {
            this.xsql = "SELECT  `f_empresacontxconvenio`.`Id` , `f_empresacontxconvenio`.`Nbre` , `f_empresacontxconvenio`.`EsCapitado`,\ng_empresacont.Id_TipoPlan, g_ips.`Nbre` \nFROM `ingreso` \nINNER JOIN  `f_liquidacion`  ON (`ingreso`.`Id` = `f_liquidacion`.`Id_Ingreso`) \nINNER JOIN  `f_empresacontxconvenio`  ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)\nINNER JOIN  `g_empresacont`  ON (`g_empresacont`.`Id_empresa` = `f_empresacontxconvenio`.`Id_EmpresaCont`) \nINNER JOIN g_ips  ON (f_empresacontxconvenio.`Id_GIps` = g_ips.`Id`)\nleft join f_factura_capita ffc on (ffc.Id_Liquidacion=f_liquidacion.Id)\nleft join f_factura_evento ffe  on (ffe.Id_Liquidacion=f_liquidacion.Id)\n\nWHERE (ifnull(ffc.Fecha_FacturaCapita, ffe.Fecha_FacturaEvento) between '" + this.xmt.formatoAMD1.format(this.JDCFechaInicio.getDate()) + "' and  '" + this.xmt.formatoAMD1.format(this.JDCFechaFin.getDate()) + "' and `f_liquidacion`.`Estado`=0  and ifnull(ffc.Estado , ffe.Estado)=0) \nGROUP BY `f_empresacontxconvenio`.`Id` ORDER BY `f_empresacontxconvenio`.`Nbre` ASC ";
        }
        System.out.println("empresas " + this.xsql);
        this.xidempresa = this.xct.llenarComboyLista(this.xsql, this.xidempresa, this.JCBEmpresa, 5);
        this.xct.cerrarConexionBd();
        this.JCBEmpresa.setSelectedIndex(-1);
        mCrearTablaDetalle();
        this.xllenoc = 1;
        this.JCBEmpresa.requestFocus();
    }

    private void mCrearTablaDetalle() {
        this.xmodelo = new DefaultTableModel() { // from class: Armado.JIFArmado.18
            Class[] types = {String.class, String.class, String.class, String.class, Boolean.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Long.class, Long.class, String.class, String.class, String.class, String.class, String.class, Long.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Integer.class, String.class, Boolean.class, String.class, String.class, Long.class, Date.class};
            boolean[] canEdit = {false, false, false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return this.canEdit[colIndex];
            }
        };
        this.xmodelo.addColumn("N°Orden/Factura");
        this.xmodelo.addColumn("Fecha");
        this.xmodelo.addColumn("NHC");
        this.xmodelo.addColumn("Usuario");
        this.xmodelo.addColumn("Armar?");
        this.xmodelo.addColumn("V/Servicio");
        this.xmodelo.addColumn("V/Plan");
        this.xmodelo.addColumn("V/Eps");
        this.xmodelo.addColumn("V/Descuento");
        this.xmodelo.addColumn("V/Usuario");
        this.xmodelo.addColumn("V/Copago o CModerado");
        this.xmodelo.addColumn("IdUsuario");
        this.xmodelo.addColumn("IdIngreso");
        this.xmodelo.addColumn("Login");
        this.xmodelo.addColumn("N° Autorizacion");
        this.xmodelo.addColumn("Contrato");
        this.xmodelo.addColumn("Sexo");
        this.xmodelo.addColumn("FechaNac");
        this.xmodelo.addColumn("Edad");
        this.xmodelo.addColumn("Tipo");
        this.xmodelo.addColumn("Municipio");
        this.xmodelo.addColumn("Barrio");
        this.xmodelo.addColumn("Direccion");
        this.xmodelo.addColumn("Telefono");
        this.xmodelo.addColumn("NivelEstudio");
        this.xmodelo.addColumn("EstadoCivil");
        this.xmodelo.addColumn("Ocupacion");
        this.xmodelo.addColumn("TD");
        this.xmodelo.addColumn("Identificacion");
        this.xmodelo.addColumn("Cargo_So");
        this.xmodelo.addColumn("EPS");
        this.xmodelo.addColumn("IdTipoAtencion");
        this.xmodelo.addColumn("SubGrupo");
        this.xmodelo.addColumn("CSeguimiento");
        this.xmodelo.addColumn("DxP");
        this.xmodelo.addColumn("Diagnostico");
        this.xmodelo.addColumn("idFacturaEvento");
        this.xmodelo.addColumn("Fecha INgreso");
        JTable jTable = this.JTBResultado;
        JTable jTable2 = this.JTBResultado;
        jTable.setAutoResizeMode(0);
        this.JTBResultado.doLayout();
        this.JTBResultado.setModel(this.xmodelo);
        this.JTBResultado.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTBResultado.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTBResultado.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTBResultado.getColumnModel().getColumn(3).setPreferredWidth(300);
        this.JTBResultado.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTBResultado.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTBResultado.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTBResultado.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.JTBResultado.getColumnModel().getColumn(8).setPreferredWidth(100);
        this.JTBResultado.getColumnModel().getColumn(9).setPreferredWidth(100);
        if (Principal.informacionIps.getNombreIps().equals("CLINICA LAURELES PSIQUIATRAS ASOCIADOS I.P.S. S.A.S.") || Principal.informacionIps.getNombreIps().equals("UNION TEMPORAL CLINICA LAURELES")) {
            this.JTBResultado.getColumnModel().getColumn(10).setPreferredWidth(100);
        } else {
            this.JTBResultado.getColumnModel().getColumn(10).setPreferredWidth(0);
            this.JTBResultado.getColumnModel().getColumn(10).setMinWidth(0);
            this.JTBResultado.getColumnModel().getColumn(10).setMaxWidth(0);
        }
        this.JTBResultado.getColumnModel().getColumn(11).setPreferredWidth(100);
        this.JTBResultado.getColumnModel().getColumn(12).setPreferredWidth(0);
        this.JTBResultado.getColumnModel().getColumn(12).setMinWidth(0);
        this.JTBResultado.getColumnModel().getColumn(12).setMaxWidth(0);
        this.JTBResultado.getColumnModel().getColumn(13).setPreferredWidth(100);
        this.JTBResultado.getColumnModel().getColumn(14).setPreferredWidth(100);
        this.JTBResultado.getColumnModel().getColumn(15).setPreferredWidth(0);
        this.JTBResultado.getColumnModel().getColumn(15).setMinWidth(0);
        this.JTBResultado.getColumnModel().getColumn(15).setMaxWidth(0);
        this.JTBResultado.getColumnModel().getColumn(16).setPreferredWidth(0);
        this.JTBResultado.getColumnModel().getColumn(16).setMinWidth(0);
        this.JTBResultado.getColumnModel().getColumn(16).setMaxWidth(0);
        this.JTBResultado.getColumnModel().getColumn(17).setPreferredWidth(0);
        this.JTBResultado.getColumnModel().getColumn(17).setMinWidth(0);
        this.JTBResultado.getColumnModel().getColumn(17).setMaxWidth(0);
        this.JTBResultado.getColumnModel().getColumn(18).setPreferredWidth(0);
        this.JTBResultado.getColumnModel().getColumn(18).setMinWidth(0);
        this.JTBResultado.getColumnModel().getColumn(18).setMaxWidth(0);
        this.JTBResultado.getColumnModel().getColumn(19).setPreferredWidth(0);
        this.JTBResultado.getColumnModel().getColumn(19).setMinWidth(0);
        this.JTBResultado.getColumnModel().getColumn(19).setMaxWidth(0);
        this.JTBResultado.getColumnModel().getColumn(20).setPreferredWidth(0);
        this.JTBResultado.getColumnModel().getColumn(20).setMinWidth(0);
        this.JTBResultado.getColumnModel().getColumn(20).setMaxWidth(0);
        this.JTBResultado.getColumnModel().getColumn(21).setPreferredWidth(0);
        this.JTBResultado.getColumnModel().getColumn(21).setMinWidth(0);
        this.JTBResultado.getColumnModel().getColumn(21).setMaxWidth(0);
        this.JTBResultado.getColumnModel().getColumn(22).setPreferredWidth(0);
        this.JTBResultado.getColumnModel().getColumn(22).setMinWidth(0);
        this.JTBResultado.getColumnModel().getColumn(22).setMaxWidth(0);
        this.JTBResultado.getColumnModel().getColumn(23).setPreferredWidth(0);
        this.JTBResultado.getColumnModel().getColumn(23).setMinWidth(0);
        this.JTBResultado.getColumnModel().getColumn(23).setMaxWidth(0);
        this.JTBResultado.getColumnModel().getColumn(24).setPreferredWidth(0);
        this.JTBResultado.getColumnModel().getColumn(24).setMinWidth(0);
        this.JTBResultado.getColumnModel().getColumn(24).setMaxWidth(0);
        this.JTBResultado.getColumnModel().getColumn(25).setPreferredWidth(0);
        this.JTBResultado.getColumnModel().getColumn(25).setMinWidth(0);
        this.JTBResultado.getColumnModel().getColumn(25).setMaxWidth(0);
        this.JTBResultado.getColumnModel().getColumn(26).setPreferredWidth(0);
        this.JTBResultado.getColumnModel().getColumn(26).setMinWidth(0);
        this.JTBResultado.getColumnModel().getColumn(26).setMaxWidth(0);
        this.JTBResultado.getColumnModel().getColumn(27).setPreferredWidth(0);
        this.JTBResultado.getColumnModel().getColumn(27).setMinWidth(0);
        this.JTBResultado.getColumnModel().getColumn(27).setMaxWidth(0);
        this.JTBResultado.getColumnModel().getColumn(28).setPreferredWidth(0);
        this.JTBResultado.getColumnModel().getColumn(28).setMinWidth(0);
        this.JTBResultado.getColumnModel().getColumn(28).setMaxWidth(0);
        this.JTBResultado.getColumnModel().getColumn(29).setPreferredWidth(0);
        this.JTBResultado.getColumnModel().getColumn(29).setMinWidth(0);
        this.JTBResultado.getColumnModel().getColumn(29).setMaxWidth(0);
        this.JTBResultado.getColumnModel().getColumn(30).setPreferredWidth(0);
        this.JTBResultado.getColumnModel().getColumn(30).setMinWidth(0);
        this.JTBResultado.getColumnModel().getColumn(30).setMaxWidth(0);
        this.JTBResultado.getColumnModel().getColumn(31).setPreferredWidth(0);
        this.JTBResultado.getColumnModel().getColumn(31).setMinWidth(0);
        this.JTBResultado.getColumnModel().getColumn(31).setMaxWidth(0);
        this.JTBResultado.getColumnModel().getColumn(32).setPreferredWidth(100);
        this.JTBResultado.getColumnModel().getColumn(33).setPreferredWidth(50);
        this.JTBResultado.getColumnModel().getColumn(34).setPreferredWidth(80);
        this.JTBResultado.getColumnModel().getColumn(35).setPreferredWidth(200);
        this.JTBResultado.getColumnModel().getColumn(36).setPreferredWidth(0);
        this.JTBResultado.getColumnModel().getColumn(36).setMinWidth(0);
        this.JTBResultado.getColumnModel().getColumn(36).setMaxWidth(0);
        this.JTBResultado.getColumnModel().getColumn(37).setPreferredWidth(200);
    }

    private void mModificarEstadoenTabla(boolean st) {
        if (this.xarmada < 2 && this.JTBResultado.getRowCount() > 1) {
            for (int i = 0; i < this.JTBResultado.getRowCount(); i++) {
                this.JTBResultado.setValueAt(Boolean.valueOf(st), i, 4);
            }
        }
    }

    public void mBuscar() {
        if (this.JCBEmpresa.getSelectedIndex() != -1) {
            if (this.JCBGrupo.getSelectedIndex() != -1) {
                if (this.JCHFiltroGrupo.isSelected()) {
                    if (this.JCBSubGrupo.getSelectedIndex() != -1) {
                        cargarDatosFacturaNuevo(0);
                        return;
                    } else {
                        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un un subgrupo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        this.JCBSubGrupo.requestFocus();
                        return;
                    }
                }
                cargarDatosFacturaNuevo(0);
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un grupo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBGrupo.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una empresa", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JCBEmpresa.requestFocus();
    }

    public void mImprimir() {
        mCrearVistaPrefactura();
        String[][] mparametros = new String[3][2];
        mparametros[0][0] = "periodo";
        mparametros[0][1] = this.xmt.formatoDMA1.format(this.JDCFechaInicio.getDate()) + " al " + this.xmt.formatoDMA1.format(this.JDCFechaFin.getDate());
        mparametros[1][0] = "SUBREPORT_DIR";
        mparametros[1][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
        mparametros[2][0] = "SUBREPORTFIRMA_DIR";
        mparametros[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
        this.xmt.GenerarPDF(this.xmt.getRutaRep() + "F_RelacionFacturasCapitaProcedimientoPac_1_Prefactura", mparametros);
    }

    public void mCrearVistaPrefactura() {
        this.xsql = "DROP VIEW IF EXISTS v_f_facturas1";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        if (this.JCHFiltroGrupo.isSelected()) {
            this.xsql = "CREATE VIEW  `v_f_facturas1`  AS   SELECT `f_factura_capita`.`Fecha_FacturaCapita` AS  `fechaU`,`f_factura_capita`.`No_FacturaCapita`, `g_persona`.`NoDocumento`,\n CONCAT(g_persona.`Apellido1`, ' ',g_persona.`Apellido2`, ' ', g_persona.`Nombre1`, ' ', g_persona.`Nombre2`) NUsuario,`ingreso`.`NoAutorizacion`, `f_liquidacion`.`TotalServicio` AS `TotalServiciol`,`f_liquidacion`.`CuotaModeradora` AS `CuotaModeradoral`, \n `f_liquidacion`.`Copago` AS `Copagol`, `f_liquidacion`.`TotalDescuento` AS `TotalDescuentol`,`f_liquidacion`.`TotalEps` AS `TotalEpsl`,IF(`cc_resolucion_dian`.`trasmision`= 0 , IF(f_factura_evento.Prefijo<>'',CONCAT(f_factura_evento.Prefijo ,'',f_factura_evento.No_Facturaevento), f_factura_evento.No_Facturaevento), IF(f_factura_evento.Prefijo<>'',CONCAT(f_factura_evento.Prefijo ,'',f_factura_evento.`No_FacturaEvento_M`), f_factura_evento.`No_FacturaEvento_M`)) AS No_FacturaEvento, \n`f_factura_evento`.`No_CuentaCobro`, `f_gruposervicio`.`Nbre` AS `NbreServicio`,`f_cuentacobro`.`Periodo_Fact`, `f_cuentacobro`.`TotalServicio` AS `TotalServicioc`,`f_cuentacobro`.`TotalCuotaM` AS `TotalCuotaMc`, `f_cuentacobro`.`TotalCopago` AS`TotalCopagoc`, `f_cuentacobro`.`TotalDesc` AS `TotalDescc`, `f_cuentacobro`.`TotalNeto` AS`TotalNetoc`, `f_empresacontxconvenio`.`Nbre` AS `NbreEmpresaConve`, \nIF(`g_empresa`.`Id_TipoIdentificacion`='NI', 'NIT',`g_empresa`.`Id_TipoIdentificacion`)  AS `Id_TipoIdentificacionEC`,`g_empresa`.`No_identificacion` AS `No_identificacionEC`, `g_empresa`.`Dig_Verificacion` AS`Dig_VerificacionEC`,d_ips.`TipoIdEmpresa` AS Id_TipoIdentificacionIPS, d_ips.`NIEmpresa` AS IdentificacionIPS, d_ips.`DVempresa` AS DigitoVerificacionIPS, d_ips.`NEmpresa`AS NbreIPS, d_ips.Direccion AS DireccionU, d_ips.`NMunicipio`, d_ips.`Telefono` AS TelefonoU \n, `f_subgruposervicio`.`Nbre`AS `SubGrupo`, `g_procedimiento`.`Nbre` AS `NProcedimiento`, `f_itemordenesproced`.`Cantidad` AS `CantidadP`, `f_itemordenesproced`.`ValorUnitario` AS `ValorUP`, `f_tarifaprocedimiento`.`CodCUPS` \nFROM `d_ips`, `f_factura_capita` \nINNER JOIN  `f_liquidacion` ON (`f_factura_capita`.`Id_Liquidacion` = `f_liquidacion`.`Id`)\nINNER JOIN  `ingreso` ON (`ingreso`.`Id` = `f_liquidacion`.`Id_Ingreso`)\nINNER JOIN  `f_subgrupo_empresa` ON (`f_liquidacion`.`Id_SubGrupoServicio` = `f_subgrupo_empresa`.`Id`)\nINNER JOIN  `f_subgruposervicio` ON (`f_subgrupo_empresa`.`Id_SubGrupo` = `f_subgruposervicio`.`Id_SubgrupoServicio`)\nINNER JOIN  `f_gruposervicio`   ON (`f_subgruposervicio`.`Id_GrupoServicio` = `f_gruposervicio`.`Id_GrupoServicio`) \nINNER JOIN  `g_persona`   ON (`g_persona`.`Id` = `ingreso`.`Id_Usuario`) \n INNER JOIN  `f_empresacontxconvenio` ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)\nINNER JOIN  `g_empresacont` ON (`f_empresacontxconvenio`.`Id_EmpresaCont` = `g_empresacont`.`Id_empresa`)\nINNER JOIN  `f_tarifaprocedimiento` ON (`f_empresacontxconvenio`.`Id_Manual` = `f_tarifaprocedimiento`.`Id_Manual`) \nINNER JOIN  `g_empresa`  ON (`g_empresacont`.`Id_empresa` = `g_empresa`.`Id`) \nINNER JOIN  `f_ordenes`  ON (`f_ordenes`.`Id_Ingreso` = `ingreso`.`Id`)\nINNER JOIN  `f_itemordenesproced` ON (`f_itemordenesproced`.`Id_Ordenes` = `f_ordenes`.`Id`)\nINNER JOIN  `g_procedimiento` ON (`f_itemordenesproced`.`Id_Procedimiento` = `g_procedimiento`.`Id`) \nAND (`f_tarifaprocedimiento`.`Id_Procedimiento` = `g_procedimiento`.`Id`) \nLEFT JOIN  `f_factura_evento`  ON (`f_factura_evento`.`No_FacturaEvento` = `f_factura_capita`.`No_FacturaEvento`)\nLEFT JOIN  `f_liquidacion` AS `f_Liquidacion_FE`ON (`f_factura_evento`.`Id_Liquidacion` = `f_Liquidacion_FE`.`Id`)                   \nLEFT JOIN  `f_cuentacobro` ON (`f_cuentacobro`.`NoCuenta` = `f_factura_evento`.`No_CuentaCobro`)  LEFT JOIN cc_resolucion_dian\nON(cc_resolucion_dian.`Id` = f_factura_evento.`idResolucionDian`)\nWHERE (`f_liquidacion`.`Id_SubGrupoServicio` ='" + this.xidsubgrupo[this.JCBSubGrupo.getSelectedIndex()] + "' and ingreso.`FechaIngreso`>='" + this.xmt.formatoAMD1.format(this.JDCFechaInicio.getDate()) + "' AND ingreso.`FechaIngreso`<='" + this.xmt.formatoAMD1.format(this.JDCFechaFin.getDate()) + "' AND  `f_ordenes`.`Estado`=0  AND f_factura_capita.`Estado`=0\nAND ingreso.`Id_EmpresaContxConv`='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "')\n ORDER BY  `f_factura_capita`.`Fecha_FacturaCapita` ASC ,CONCAT(g_persona.`Apellido1`, ' ',g_persona.`Apellido2`, ' ', g_persona.`Nombre1`, ' ', g_persona.`Nombre2`) ASC,`f_factura_capita`.`No_FacturaCapita` ASC,`g_procedimiento`.`Nbre` ASC;";
        } else {
            this.xsql = "CREATE VIEW  `v_f_facturas1`  AS   SELECT `f_factura_capita`.`Fecha_FacturaCapita` AS  `fechaU`,`f_factura_capita`.`No_FacturaCapita`, `g_persona`.`NoDocumento`,\n CONCAT(g_persona.`Apellido1`, ' ',g_persona.`Apellido2`, ' ', g_persona.`Nombre1`, ' ', g_persona.`Nombre2`) NUsuario,`ingreso`.`NoAutorizacion`, `f_liquidacion`.`TotalServicio` AS `TotalServiciol`,`f_liquidacion`.`CuotaModeradora` AS `CuotaModeradoral`, \n `f_liquidacion`.`Copago` AS `Copagol`, `f_liquidacion`.`TotalDescuento` AS `TotalDescuentol`,`f_liquidacion`.`TotalEps` AS `TotalEpsl`,IF( `cc_resolucion_dian`.`trasmision`= 0,IF(f_factura_evento.Prefijo<>'',CONCAT(f_factura_evento.Prefijo ,'',f_factura_evento.No_Facturaevento), f_factura_evento.No_Facturaevento), IF(f_factura_evento.Prefijo<>'',CONCAT(f_factura_evento.Prefijo ,'',f_factura_evento.`No_FacturaEvento_M`), f_factura_evento.`No_FacturaEvento_M`)) AS No_FacturaEvento , \n`f_factura_evento`.`No_CuentaCobro`, `f_gruposervicio`.`Nbre` AS `NbreServicio`,`f_cuentacobro`.`Periodo_Fact`, `f_cuentacobro`.`TotalServicio` AS `TotalServicioc`,`f_cuentacobro`.`TotalCuotaM` AS `TotalCuotaMc`, `f_cuentacobro`.`TotalCopago` AS`TotalCopagoc`, `f_cuentacobro`.`TotalDesc` AS `TotalDescc`, `f_cuentacobro`.`TotalNeto` AS`TotalNetoc`, `f_empresacontxconvenio`.`Nbre` AS `NbreEmpresaConve`, \nIF(`g_empresa`.`Id_TipoIdentificacion`='NI', 'NIT',`g_empresa`.`Id_TipoIdentificacion`)  AS `Id_TipoIdentificacionEC`,`g_empresa`.`No_identificacion` AS `No_identificacionEC`, `g_empresa`.`Dig_Verificacion` AS`Dig_VerificacionEC`,d_ips.`TipoIdEmpresa` AS Id_TipoIdentificacionIPS, d_ips.`NIEmpresa` AS IdentificacionIPS, d_ips.`DVempresa` AS DigitoVerificacionIPS, d_ips.`NEmpresa`AS NbreIPS, d_ips.Direccion AS DireccionU, d_ips.`NMunicipio`, d_ips.`Telefono` AS TelefonoU \n, `f_subgruposervicio`.`Nbre`AS `SubGrupo`, `g_procedimiento`.`Nbre` AS `NProcedimiento`, `f_itemordenesproced`.`Cantidad` AS `CantidadP`, `f_itemordenesproced`.`ValorUnitario` AS `ValorUP`, `f_tarifaprocedimiento`.`CodCUPS` \nFROM `d_ips`, `f_factura_capita` \nINNER JOIN  `f_liquidacion` ON (`f_factura_capita`.`Id_Liquidacion` = `f_liquidacion`.`Id`)\nINNER JOIN  `ingreso` ON (`ingreso`.`Id` = `f_liquidacion`.`Id_Ingreso`)\nINNER JOIN  `f_subgrupo_empresa` ON (`f_liquidacion`.`Id_SubGrupoServicio` = `f_subgrupo_empresa`.`Id`)\nINNER JOIN  `f_subgruposervicio` ON (`f_subgrupo_empresa`.`Id_SubGrupo` = `f_subgruposervicio`.`Id_SubgrupoServicio`)\nINNER JOIN  `f_gruposervicio`   ON (`f_subgruposervicio`.`Id_GrupoServicio` = `f_gruposervicio`.`Id_GrupoServicio`) \nINNER JOIN  `g_persona`   ON (`g_persona`.`Id` = `ingreso`.`Id_Usuario`) \n INNER JOIN  `f_empresacontxconvenio` ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)\nINNER JOIN  `g_empresacont` ON (`f_empresacontxconvenio`.`Id_EmpresaCont` = `g_empresacont`.`Id_empresa`)\nINNER JOIN  `f_tarifaprocedimiento` ON (`f_empresacontxconvenio`.`Id_Manual` = `f_tarifaprocedimiento`.`Id_Manual`) \nINNER JOIN  `g_empresa`  ON (`g_empresacont`.`Id_empresa` = `g_empresa`.`Id`) \nINNER JOIN  `f_ordenes`  ON (`f_ordenes`.`Id_Ingreso` = `ingreso`.`Id`)\nINNER JOIN  `f_itemordenesproced` ON (`f_itemordenesproced`.`Id_Ordenes` = `f_ordenes`.`Id`)\nINNER JOIN  `g_procedimiento` ON (`f_itemordenesproced`.`Id_Procedimiento` = `g_procedimiento`.`Id`) \nAND (`f_tarifaprocedimiento`.`Id_Procedimiento` = `g_procedimiento`.`Id`) \nLEFT JOIN  `f_factura_evento`  ON (`f_factura_evento`.`No_FacturaEvento` = `f_factura_capita`.`No_FacturaEvento`)\nLEFT JOIN  `f_liquidacion` AS `f_Liquidacion_FE`ON (`f_factura_evento`.`Id_Liquidacion` = `f_Liquidacion_FE`.`Id`)                   \nLEFT JOIN  `f_cuentacobro` ON (`f_cuentacobro`.`NoCuenta` = `f_factura_evento`.`No_CuentaCobro`)\n LEFT JOIN cc_resolucion_dian\nON(cc_resolucion_dian.`Id` = f_factura_evento.`idResolucionDian`)\nWHERE ( `f_subgruposervicio`.`Id_GrupoServicio` ='" + this.xidservicio[this.JCBGrupo.getSelectedIndex()][0] + "' and  ingreso.`FechaIngreso`>='" + this.xmt.formatoAMD1.format(this.JDCFechaInicio.getDate()) + "' AND ingreso.`FechaIngreso`<='" + this.xmt.formatoAMD1.format(this.JDCFechaFin.getDate()) + "' AND  `f_ordenes`.`Estado`=0  AND f_factura_capita.`Estado`=0\nAND ingreso.`Id_EmpresaContxConv`='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "')\n ORDER BY  `f_factura_capita`.`Fecha_FacturaCapita` ASC ,CONCAT(g_persona.`Apellido1`, ' ',g_persona.`Apellido2`, ' ', g_persona.`Nombre1`, ' ', g_persona.`Nombre2`) ASC,`f_factura_capita`.`No_FacturaCapita` ASC,`g_procedimiento`.`Nbre` ASC;";
        }
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
    }

    private void cargarDatosFacturaNuevo(int xorden) {
        List<IInformacionArmadoCuenta> list = new ArrayList<>();
        List<Integer> listSubgrupo = new ArrayList<>();
        if (!this.JCHFiltroGrupo.isSelected()) {
            if (this.xidsubgrupo.length != 0) {
                for (int x = 0; x < this.xidsubgrupo.length; x++) {
                    listSubgrupo.add(Integer.valueOf(this.xidsubgrupo[x]));
                }
            }
        } else {
            listSubgrupo.add(Integer.valueOf(this.xidsubgrupo[this.JCBSubGrupo.getSelectedIndex()]));
        }
        System.err.println("usuaruio" + Principal.usuarioSistemaDTO.getLogin());
        System.out.println("Orden => " + xorden);
        System.out.println("Tipo Servicio => " + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][1]);
        System.out.println("listSubgrupo ---- " + listSubgrupo);
        System.out.println("this.xarmada ---" + this.xarmada);
        System.out.println("Integer.valueOf(this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0])----- " + Integer.valueOf(this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0]));
        System.out.println("this.JDCFechaInicio.getDate() ----- " + this.JDCFechaInicio.getDate());
        System.out.println("this.JDCFechaFin.getDate() ----- " + this.JDCFechaFin.getDate());
        Date fechaInicio = this.JDCFechaInicio.getDate();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fechaInicio);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        Date fechaInicioF = calendar.getTime();
        Date fechaFinal = this.JDCFechaFin.getDate();
        Calendar calendarF = Calendar.getInstance();
        calendarF.setTime(fechaFinal);
        calendarF.set(11, 23);
        calendarF.set(12, 59);
        calendarF.set(13, 59);
        Date fechaFinalF = calendarF.getTime();
        System.out.println("fechaInicioF ----- " + fechaInicioF);
        System.out.println("fechaFinalF ----- " + fechaFinalF);
        if (this.xidempresa[this.JCBEmpresa.getSelectedIndex()][1].equals("2")) {
            switch (xorden) {
                case 0:
                    list = this.JCHFiltroUsuarioSistema.isSelected() ? this.iLiquidacionService.listaArmadoFacturaEventoOrdenPorNombre(fechaInicioF, fechaFinalF, Integer.valueOf(this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0]), listSubgrupo, Integer.valueOf(this.xarmada), Principal.usuarioSistemaDTO.getLogin()) : this.iLiquidacionService.listaArmadoFacturaEventoOrdenPorNombre(fechaInicioF, fechaFinalF, Integer.valueOf(this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0]), listSubgrupo, Integer.valueOf(this.xarmada), "");
                    break;
                case 1:
                    list = this.JCHFiltroUsuarioSistema.isSelected() ? this.iLiquidacionService.listaArmadoFacturaEventoOrdenPorNombre(fechaInicioF, fechaFinalF, Integer.valueOf(this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0]), listSubgrupo, Integer.valueOf(this.xarmada), Principal.usuarioSistemaDTO.getLogin()) : this.iLiquidacionService.listaArmadoFacturaEventoOrdenPorNombre(fechaInicioF, fechaFinalF, Integer.valueOf(this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0]), listSubgrupo, Integer.valueOf(this.xarmada), "");
                    break;
                case 2:
                    list = this.JCHFiltroUsuarioSistema.isSelected() ? this.iLiquidacionService.listaArmadoFacturaEventoOrdenPorValor(fechaInicioF, fechaFinalF, Integer.valueOf(this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0]), listSubgrupo, Integer.valueOf(this.xarmada), Principal.usuarioSistemaDTO.getLogin()) : this.iLiquidacionService.listaArmadoFacturaEventoOrdenPorValor(fechaInicioF, fechaFinalF, Integer.valueOf(this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0]), listSubgrupo, Integer.valueOf(this.xarmada), "");
                    break;
                case 3:
                    list = this.JCHFiltroUsuarioSistema.isSelected() ? this.iLiquidacionService.listaArmadoFacturaEventoOrdenPorNumeroOrden(fechaInicioF, fechaFinalF, Integer.valueOf(this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0]), listSubgrupo, Integer.valueOf(this.xarmada), Principal.usuarioSistemaDTO.getLogin()) : this.iLiquidacionService.listaArmadoFacturaEventoOrdenPorNumeroOrden(fechaInicioF, fechaFinalF, Integer.valueOf(this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0]), listSubgrupo, Integer.valueOf(this.xarmada), "");
                    break;
            }
        } else {
            switch (xorden) {
                case 0:
                    list = this.JCHFiltroUsuarioSistema.isSelected() ? this.iLiquidacionService.listaArmadoFacturaCapitaOrdenPorNombre(fechaInicioF, fechaFinalF, Integer.valueOf(this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0]), listSubgrupo, Integer.valueOf(this.xarmada), Principal.usuarioSistemaDTO.getLogin()) : this.iLiquidacionService.listaArmadoFacturaCapitaOrdenPorNombre(fechaInicioF, fechaFinalF, Integer.valueOf(this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0]), listSubgrupo, Integer.valueOf(this.xarmada), "");
                    break;
                case 1:
                    list = this.JCHFiltroUsuarioSistema.isSelected() ? this.iLiquidacionService.listaArmadoFacturaCapitaOrdenPorNombre(fechaInicioF, fechaFinalF, Integer.valueOf(this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0]), listSubgrupo, Integer.valueOf(this.xarmada), Principal.usuarioSistemaDTO.getLogin()) : this.iLiquidacionService.listaArmadoFacturaCapitaOrdenPorNombre(fechaInicioF, fechaFinalF, Integer.valueOf(this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0]), listSubgrupo, Integer.valueOf(this.xarmada), "");
                    break;
                case 2:
                    list = this.JCHFiltroUsuarioSistema.isSelected() ? this.iLiquidacionService.listaArmadoFacturaCapitaOrdenPorValor(fechaInicioF, fechaFinalF, Integer.valueOf(this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0]), listSubgrupo, Integer.valueOf(this.xarmada), Principal.usuarioSistemaDTO.getLogin()) : this.iLiquidacionService.listaArmadoFacturaCapitaOrdenPorValor(fechaInicioF, fechaFinalF, Integer.valueOf(this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0]), listSubgrupo, Integer.valueOf(this.xarmada), "");
                    break;
                case 3:
                    list = this.JCHFiltroUsuarioSistema.isSelected() ? this.iLiquidacionService.listaArmadoFacturaCapitaOrdenPorNumeroOrden(fechaInicioF, fechaFinalF, Integer.valueOf(this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0]), listSubgrupo, Integer.valueOf(this.xarmada), Principal.usuarioSistemaDTO.getLogin()) : this.iLiquidacionService.listaArmadoFacturaCapitaOrdenPorNumeroOrden(fechaInicioF, fechaFinalF, Integer.valueOf(this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0]), listSubgrupo, Integer.valueOf(this.xarmada), "");
                    break;
            }
        }
        mCrearTablaDetalle();
        if (!list.isEmpty()) {
            this.xmt.mEstablecerTextEditor(this.JTBResultado, 3);
            this.xmt.mEstablecerTextEditor(this.JTBResultado, 32);
            this.xvalors = new Double(0.0d);
            this.xvalorp = new Double(0.0d);
            this.xvalore = new Double(0.0d);
            this.xvalord = new Double(0.0d);
            this.xvalorcp = new Double(0.0d);
            this.xvalorcm = new Double(0.0d);
            list.forEach(item -> {
                this.xmodelo.addRow(this.xdato);
                this.xmodelo.setValueAt(item.getNumeroOrden(), this.JTBResultado.getRowCount() - 1, 0);
                this.xmodelo.setValueAt(item.getFechaOrden(), this.JTBResultado.getRowCount() - 1, 1);
                this.xmodelo.setValueAt(item.getNumeroHistoria(), this.JTBResultado.getRowCount() - 1, 2);
                this.xmodelo.setValueAt(item.getNombreUsuario(), this.JTBResultado.getRowCount() - 1, 3);
                this.xmodelo.setValueAt(item.getEstadoArmada(), this.JTBResultado.getRowCount() - 1, 4);
                this.xmodelo.setValueAt(item.getTotalServicio(), this.JTBResultado.getRowCount() - 1, 5);
                this.xmodelo.setValueAt(item.getTotalPlan(), this.JTBResultado.getRowCount() - 1, 6);
                this.xmodelo.setValueAt(item.getTotalEps(), this.JTBResultado.getRowCount() - 1, 7);
                this.xmodelo.setValueAt(item.getTotalDescuento(), this.JTBResultado.getRowCount() - 1, 8);
                this.xmodelo.setValueAt(item.getTotalPaciente(), this.JTBResultado.getRowCount() - 1, 9);
                this.xmodelo.setValueAt(item.getValorCopagoCuota(), this.JTBResultado.getRowCount() - 1, 10);
                this.xmodelo.setValueAt(item.getIdPersona(), this.JTBResultado.getRowCount() - 1, 11);
                this.xmodelo.setValueAt(item.getIdIngreso(), this.JTBResultado.getRowCount() - 1, 12);
                this.xmodelo.setValueAt(item.getUsuarioSistemas(), this.JTBResultado.getRowCount() - 1, 13);
                this.xmodelo.setValueAt(item.getNumeroAutorizacion(), this.JTBResultado.getRowCount() - 1, 14);
                this.xmodelo.setValueAt(item.getNombreContrato(), this.JTBResultado.getRowCount() - 1, 15);
                this.xmodelo.setValueAt(item.getIdSexo(), this.JTBResultado.getRowCount() - 1, 16);
                this.xmodelo.setValueAt(item.getFechaNacimiento(), this.JTBResultado.getRowCount() - 1, 17);
                this.xmodelo.setValueAt(item.getEdad(), this.JTBResultado.getRowCount() - 1, 18);
                this.xmodelo.setValueAt(item.getTipoEdad(), this.JTBResultado.getRowCount() - 1, 19);
                this.xmodelo.setValueAt(item.getMunicipio(), this.JTBResultado.getRowCount() - 1, 20);
                this.xmodelo.setValueAt(item.getBarrio(), this.JTBResultado.getRowCount() - 1, 21);
                this.xmodelo.setValueAt(item.getDireccion(), this.JTBResultado.getRowCount() - 1, 22);
                this.xmodelo.setValueAt(item.getTelefono(), this.JTBResultado.getRowCount() - 1, 23);
                this.xmodelo.setValueAt(item.getNivelEstudio(), this.JTBResultado.getRowCount() - 1, 24);
                this.xmodelo.setValueAt(item.getEstadoCivil(), this.JTBResultado.getRowCount() - 1, 25);
                this.xmodelo.setValueAt(item.getOcupacion(), this.JTBResultado.getRowCount() - 1, 26);
                this.xmodelo.setValueAt(item.getIdTipoIdentificacion(), this.JTBResultado.getRowCount() - 1, 27);
                this.xmodelo.setValueAt(item.getNumeroDocumento(), this.JTBResultado.getRowCount() - 1, 28);
                this.xmodelo.setValueAt(item.getCargoSaludOcupacional(), this.JTBResultado.getRowCount() - 1, 29);
                this.xmodelo.setValueAt(item.getEpsUsuario(), this.JTBResultado.getRowCount() - 1, 30);
                this.xmodelo.setValueAt(item.getIdTipoAtencion(), this.JTBResultado.getRowCount() - 1, 31);
                this.xmodelo.setValueAt(item.getSubgrupo(), this.JTBResultado.getRowCount() - 1, 32);
                this.xmodelo.setValueAt(item.getControlSeguimiento(), this.JTBResultado.getRowCount() - 1, 33);
                this.xmodelo.setValueAt(item.getIdDxPrincipal(), this.JTBResultado.getRowCount() - 1, 34);
                this.xmodelo.setValueAt(item.getNombreDxPrincipal(), this.JTBResultado.getRowCount() - 1, 35);
                this.xmodelo.setValueAt(item.getIdFactura(), this.JTBResultado.getRowCount() - 1, 36);
                this.xmodelo.setValueAt(item.getFechaIngreso(), this.JTBResultado.getRowCount() - 1, 37);
                this.JTBResultado.setDefaultRenderer(Object.class, new MiRender());
                this.xvalors = Double.valueOf(this.xvalors.doubleValue() + item.getTotalServicio().doubleValue());
                this.xvalorp = Double.valueOf(this.xvalorp.doubleValue() + item.getTotalPlan().doubleValue());
                this.xvalore = Double.valueOf(this.xvalore.doubleValue() + item.getTotalEps().doubleValue());
                this.xvalord = Double.valueOf(this.xvalord.doubleValue() + item.getTotalDescuento().doubleValue());
                this.xvalorcp = Double.valueOf(this.xvalorcp.doubleValue() + item.getCopago().doubleValue());
                this.xvalorcm = Double.valueOf(this.xvalorcm.doubleValue() + item.getCuotaModeradora().doubleValue());
            });
            this.JTFFTotalServicio.setValue(this.xvalors);
            this.JTFFTotalUsuario.setValue(this.xvalorp);
            this.JTFFTotalCModeradora.setValue(this.xvalorcm);
            this.JTFFTotalCopago.setValue(this.xvalorcp);
            this.JTFFTotalDescuento.setValue(this.xvalord);
            this.JTFFTotalEps.setValue(this.xvalore);
            this.JTFFNItems.setValue(Integer.valueOf(list.size()));
            return;
        }
        this.JTFFTotalServicio.setValue(new Double(0.0d));
        this.JTFFTotalUsuario.setValue(new Double(0.0d));
        this.JTFFTotalCModeradora.setValue(new Double(0.0d));
        this.JTFFTotalCopago.setValue(new Double(0.0d));
        this.JTFFTotalDescuento.setValue(new Double(0.0d));
        this.JTFFTotalEps.setValue(new Double(0.0d));
    }

    private void mCargarDatosFactura(int xorden) {
        mCrearTablaDetalle();
        System.out.println("Orden => " + xorden);
        System.out.println("Tipo Servicio => " + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][1]);
        if (this.xidempresa[this.JCBEmpresa.getSelectedIndex()][1].equals("2")) {
            if (xorden == 0) {
                if (Principal.informacionIps.getNombreIps().equals("CLINICA OFTALMOLOGICA DAJUD SAS") || Principal.informacionIps.getNombreIps().equals("COD-OPTICA UT") || Principal.informacionIps.getNombreIps().equals("JAIME CESAR DAJUD FERNANDEZ")) {
                    this.xsql = "SELECT  IF( `cc_resolucion_dian`.`trasmision`= 0,IF(f_factura_evento.Prefijo<>'',CONCAT(f_factura_evento.Prefijo ,'',f_factura_evento.No_Facturaevento), f_factura_evento.No_Facturaevento), IF(f_factura_evento.Prefijo<>'',CONCAT(f_factura_evento.Prefijo ,'',f_factura_evento.`No_FacturaEvento_M`), f_factura_evento.`No_FacturaEvento_M`)) AS No_FacturaEvento, DATE_FORMAT(f_factura_evento.Fecha_FacturaEvento,'%d-%m-%Y') AS FechaF, g_usuario.`NoHistoria`, CONCAT(g_persona.`Apellido1`, ' ', g_persona.`Apellido2`, ' ', g_persona.`Nombre1`, ' ', g_persona.`Nombre2`) AS Nombre, f_liquidacion.TotalServicio, f_liquidacion.TotalPlan, f_liquidacion.TotalEps , f_liquidacion.TotalDescuento, f_liquidacion.TotalPaciente, (f_liquidacion.CuotaModeradora + f_liquidacion.Copago)  AS VCMD, g_persona.`Id`, ingreso.Id,  IF(f_factura_evento.EstaArmada=0,FALSE, TRUE) EstaArmada, f_liquidacion.Copago, f_liquidacion.CuotaModeradora, f_liquidacion.UsuarioS, ingreso.NoAutorizacion, g_contratos.`Nbre_Contrato`  ,  `g_persona`.`Id_Sexo`, g_persona.`FechaNac` , devuelve_Edad_2F(g_persona.`FechaNac`,f_factura_evento.Fecha_FacturaEvento) AS FNacimiento , devuelve_Tipo_Edad_2F(g_persona.`FechaNac`,f_factura_evento.Fecha_FacturaEvento) AS TipoEdad, g_municipio.`Nbre` AS NMunicipio , g_barrio.`Nbre` AS NBarrio, g_persona.`Direccion` , g_persona.`Telefono` , `g_nivelestudio`.`Nbre` ,  g_estadocivil.`Nbre` AS EstadoCivil, g_ocupacion.`Nbre`, g_persona.`Id_TipoIdentificacion`, g_persona.`NoDocumento`, ingreso.SO_Cargo, g_empresa.`Nbre` AS EPS  , ingreso.`Id_TipoAtencion`, `f_subgruposervicio`.`Nbre` AS `SubGrupo`   ,  IF(s.Cerrado IS NULL,0,1) CSeguimiento,IFNULL(f_itemripsconsulta.`Id_DxPrincipal`, '') Id_DxPrincipal ,IFNULL(`g_patologia`.`Nbre`,'') AS Diagnostico ,f_factura_evento.`No_FacturaEvento` as IdFactura  FROM f_factura_evento INNER JOIN f_liquidacion  ON (f_factura_evento.Id_Liquidacion = f_liquidacion.Id)  INNER JOIN ingreso  ON (ingreso.Id = f_liquidacion.Id_Ingreso)  INNER JOIN `g_contratos`  ON (ingreso.`Id_Contrato` = g_contratos.`Id`)   INNER JOIN f_ordenes  ON (ingreso.Id = f_ordenes.Id_Ingreso) LEFT JOIN `f_itemripsconsulta` ON (f_itemripsconsulta.`Id_Ordenes`=`f_ordenes`.`Id`) LEFT JOIN `g_patologia` ON (`g_patologia`.`Id`=`f_itemripsconsulta`.`Id_DxPrincipal`) INNER JOIN `g_persona`  ON (ingreso.Id_Usuario = g_persona.`Id`) INNER JOIN `g_usuario`  ON (g_usuario.`Id_persona` = g_persona.`Id`)   INNER JOIN `g_municipio`  ON (g_municipio.`Id` = g_persona.`Id_Municipio`) INNER JOIN `g_barrio`  ON (g_barrio.`Id` = g_persona.`Id_Barrio`) INNER JOIN `g_estadocivil`  ON (g_estadocivil.`Id` = g_persona.`Id_EstadoCivil`) INNER JOIN `g_empresa`  ON (g_empresa.`Id` = g_usuario.`Id_EmpresaCont`)  INNER JOIN  `g_nivelestudio` ON (`g_nivelestudio`.`Id` = `ingreso`.`Id_NivelEstudio`)   INNER JOIN  `g_ocupacion` ON (`g_ocupacion`.`Id` = `ingreso`.`Id_Ocupacion`)    INNER JOIN cc_resolucion_dian \n ON (cc_resolucion_dian.`Id` = f_factura_evento.`idResolucionDian`)\n  INNER JOIN `f_subgrupo_empresa`   ON (`f_liquidacion`.`Id_SubGrupoServicio` = `f_subgrupo_empresa`.`Id`) INNER JOIN  `f_subgruposervicio`   ON (`f_subgrupo_empresa`.`Id_SubGrupo` = `f_subgruposervicio`.`Id_SubgrupoServicio`)  LEFT JOIN (SELECT `Id_Ingreso` , `Cerrado`\nFROM\n    `ingreso_seguimiento`\nWHERE (`Cerrado` =0)\nGROUP BY `Id_Ingreso`)  s ON (s.Id_Ingreso=ingreso.`Id`)     WHERE (f_factura_evento.Fecha_FacturaEvento >='" + this.xmt.formatoAMD.format(this.JDCFechaInicio.getDate()) + "' AND f_factura_evento.Fecha_FacturaEvento <='" + this.xmt.formatoAMD.format(this.JDCFechaFin.getDate()) + "' AND f_liquidacion.Id_SubGrupoServicio ='" + this.xidsubgrupo[this.JCBSubGrupo.getSelectedIndex()] + "' AND ingreso.Id_EmpresaContxConv ='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "' AND f_liquidacion.Estado =0  and f_factura_evento.EstaArmada='" + this.xarmada + "' AND ingreso.Estado=0 AND f_ordenes.Estado=0) GROUP BY f_factura_evento.No_FacturaEvento ORDER BY FechaF ASC, CONCAT(g_persona.`Apellido1`, ' ', g_persona.`Apellido2`, ' ', g_persona.`Nombre1`, ' ', g_persona.`Nombre2`) ASC ";
                } else if (this.JCHFiltroGrupo.isSelected()) {
                    this.xsql = "SELECT  IF( `cc_resolucion_dian`.`trasmision`= 0,IF(f_factura_evento.Prefijo<>'',CONCAT(f_factura_evento.Prefijo ,'',f_factura_evento.No_Facturaevento), f_factura_evento.No_Facturaevento), IF(f_factura_evento.Prefijo<>'',CONCAT(f_factura_evento.Prefijo ,'',f_factura_evento.`No_FacturaEvento_M`), f_factura_evento.`No_FacturaEvento_M`)) AS No_FacturaEvento, DATE_FORMAT(f_factura_evento.Fecha_FacturaEvento,'%d-%m-%Y') AS FechaF, g_usuario.`NoHistoria`, CONCAT(g_persona.`Apellido1`, ' ', g_persona.`Apellido2`, ' ', g_persona.`Nombre1`, ' ', g_persona.`Nombre2`) AS Nombre, f_liquidacion.TotalServicio, f_liquidacion.TotalPlan, f_liquidacion.TotalEps , f_liquidacion.TotalDescuento, f_liquidacion.TotalPaciente, (f_liquidacion.CuotaModeradora + f_liquidacion.Copago)  AS VCMD, g_persona.`Id`, ingreso.Id,  IF(f_factura_evento.EstaArmada=0,FALSE, TRUE) EstaArmada, f_liquidacion.Copago, f_liquidacion.CuotaModeradora, f_liquidacion.UsuarioS, ingreso.NoAutorizacion, g_contratos.`Nbre_Contrato`  ,  `g_persona`.`Id_Sexo`, g_persona.`FechaNac` , devuelve_Edad_2F(g_persona.`FechaNac`,f_factura_evento.Fecha_FacturaEvento) AS FNacimiento , devuelve_Tipo_Edad_2F(g_persona.`FechaNac`,f_factura_evento.Fecha_FacturaEvento) AS TipoEdad, g_municipio.`Nbre` AS NMunicipio , g_barrio.`Nbre` AS NBarrio, g_persona.`Direccion` , g_persona.`Telefono` , `g_nivelestudio`.`Nbre` ,  g_estadocivil.`Nbre` AS EstadoCivil, g_ocupacion.`Nbre`, g_persona.`Id_TipoIdentificacion`, g_persona.`NoDocumento`, ingreso.SO_Cargo, g_empresa.`Nbre` AS EPS  , ingreso.`Id_TipoAtencion`, `f_subgruposervicio`.`Nbre` AS `SubGrupo`   ,  IF(s.Cerrado IS NULL,0,1) CSeguimiento,IFNULL(f_itemripsconsulta.`Id_DxPrincipal`, '') Id_DxPrincipal ,IFNULL(`g_patologia`.`Nbre`,'') AS Diagnostico ,f_factura_evento.`No_FacturaEvento` as IdFactura  FROM f_factura_evento INNER JOIN f_liquidacion  ON (f_factura_evento.Id_Liquidacion = f_liquidacion.Id)  INNER JOIN ingreso  ON (ingreso.Id = f_liquidacion.Id_Ingreso)  INNER JOIN `g_contratos`  ON (ingreso.`Id_Contrato` = g_contratos.`Id`)   INNER JOIN f_ordenes  ON (ingreso.Id = f_ordenes.Id_Ingreso) LEFT JOIN `f_itemripsconsulta` ON (f_itemripsconsulta.`Id_Ordenes`=`f_ordenes`.`Id`) LEFT JOIN `g_patologia` ON (`g_patologia`.`Id`=`f_itemripsconsulta`.`Id_DxPrincipal`) INNER JOIN `g_persona`  ON (ingreso.Id_Usuario = g_persona.`Id`) INNER JOIN `g_usuario`  ON (g_usuario.`Id_persona` = g_persona.`Id`)   INNER JOIN `g_municipio`  ON (g_municipio.`Id` = g_persona.`Id_Municipio`) INNER JOIN `g_barrio`  ON (g_barrio.`Id` = g_persona.`Id_Barrio`) INNER JOIN `g_estadocivil`  ON (g_estadocivil.`Id` = g_persona.`Id_EstadoCivil`) INNER JOIN `g_empresa`  ON (g_empresa.`Id` = g_usuario.`Id_EmpresaCont`)  INNER JOIN  `g_nivelestudio` ON (`g_nivelestudio`.`Id` = `ingreso`.`Id_NivelEstudio`)   INNER JOIN  `g_ocupacion` ON (`g_ocupacion`.`Id` = `ingreso`.`Id_Ocupacion`)   INNER JOIN cc_resolucion_dian\n ON (cc_resolucion_dian.`Id` = f_factura_evento.`idResolucionDian`)\n INNER JOIN `f_subgrupo_empresa`   ON (`f_liquidacion`.`Id_SubGrupoServicio` = `f_subgrupo_empresa`.`Id`) INNER JOIN  `f_subgruposervicio`   ON (`f_subgrupo_empresa`.`Id_SubGrupo` = `f_subgruposervicio`.`Id_SubgrupoServicio`)  LEFT JOIN (SELECT `Id_Ingreso` , `Cerrado`\nFROM\n    `ingreso_seguimiento`\nWHERE (`Cerrado` =0)\nGROUP BY `Id_Ingreso`)  s ON (s.Id_Ingreso=ingreso.`Id`)     WHERE (f_factura_evento.Fecha_FacturaEvento >='" + this.xmt.formatoAMD.format(this.JDCFechaInicio.getDate()) + "' AND f_factura_evento.Fecha_FacturaEvento <='" + this.xmt.formatoAMD.format(this.JDCFechaFin.getDate()) + "' AND f_liquidacion.Id_SubGrupoServicio ='" + this.xidsubgrupo[this.JCBSubGrupo.getSelectedIndex()] + "' AND ingreso.Id_EmpresaContxConv ='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "' AND f_liquidacion.Estado =0  and f_factura_evento.EstaArmada='" + this.xarmada + "' AND ingreso.Estado=0 AND f_ordenes.Estado=0) GROUP BY f_factura_evento.No_FacturaEvento ORDER BY FechaF ASC, CONCAT(g_persona.`Apellido1`, ' ', g_persona.`Apellido2`, ' ', g_persona.`Nombre1`, ' ', g_persona.`Nombre2`) ASC ";
                } else {
                    this.xsql = "SELECT  IF( `cc_resolucion_dian`.`trasmision`= 0,IF(f_factura_evento.Prefijo<>'',CONCAT(f_factura_evento.Prefijo ,'',f_factura_evento.No_Facturaevento), f_factura_evento.No_Facturaevento), IF(f_factura_evento.Prefijo<>'',CONCAT(f_factura_evento.Prefijo ,'',f_factura_evento.`No_FacturaEvento_M`), f_factura_evento.`No_FacturaEvento_M`)) AS No_FacturaEvento, DATE_FORMAT(f_factura_evento.Fecha_FacturaEvento,'%d-%m-%Y') AS FechaF, g_usuario.`NoHistoria`, CONCAT(g_persona.`Apellido1`, ' ', g_persona.`Apellido2`, ' ', g_persona.`Nombre1`, ' ', g_persona.`Nombre2`) AS Nombre, f_liquidacion.TotalServicio, f_liquidacion.TotalPlan, f_liquidacion.TotalEps , f_liquidacion.TotalDescuento, f_liquidacion.TotalPaciente, (f_liquidacion.CuotaModeradora + f_liquidacion.Copago)  AS VCMD, g_persona.`Id`, ingreso.Id,  IF(f_factura_evento.EstaArmada=0,FALSE, TRUE) EstaArmada, f_liquidacion.Copago, f_liquidacion.CuotaModeradora, f_liquidacion.UsuarioS, ingreso.NoAutorizacion, g_contratos.`Nbre_Contrato`  ,  `g_persona`.`Id_Sexo`, g_persona.`FechaNac` , devuelve_Edad_2F(g_persona.`FechaNac`,f_factura_evento.Fecha_FacturaEvento) AS FNacimiento , devuelve_Tipo_Edad_2F(g_persona.`FechaNac`,f_factura_evento.Fecha_FacturaEvento) AS TipoEdad, g_municipio.`Nbre` AS NMunicipio , g_barrio.`Nbre` AS NBarrio, g_persona.`Direccion` , g_persona.`Telefono` , `g_nivelestudio`.`Nbre` ,  g_estadocivil.`Nbre` AS EstadoCivil, g_ocupacion.`Nbre`, g_persona.`Id_TipoIdentificacion`, g_persona.`NoDocumento`, ingreso.SO_Cargo, g_empresa.`Nbre` AS EPS  , ingreso.`Id_TipoAtencion`, `f_subgruposervicio`.`Nbre` AS `SubGrupo`   ,  IF(s.Cerrado IS NULL,0,1) CSeguimiento,IFNULL(f_itemripsconsulta.`Id_DxPrincipal`, '') Id_DxPrincipal ,IFNULL(`g_patologia`.`Nbre`,'') AS Diagnostico , f_factura_evento.`No_FacturaEvento` as IdFactura  FROM f_factura_evento INNER JOIN f_liquidacion  ON (f_factura_evento.Id_Liquidacion = f_liquidacion.Id)  INNER JOIN ingreso  ON (ingreso.Id = f_liquidacion.Id_Ingreso)  INNER JOIN `g_contratos`  ON (ingreso.`Id_Contrato` = g_contratos.`Id`)   INNER JOIN f_ordenes  ON (ingreso.Id = f_ordenes.Id_Ingreso) LEFT JOIN `f_itemripsconsulta` ON (f_itemripsconsulta.`Id_Ordenes`=`f_ordenes`.`Id`) LEFT JOIN `g_patologia` ON (`g_patologia`.`Id`=`f_itemripsconsulta`.`Id_DxPrincipal`) INNER JOIN `g_persona`  ON (ingreso.Id_Usuario = g_persona.`Id`) INNER JOIN `g_usuario`  ON (g_usuario.`Id_persona` = g_persona.`Id`)   INNER JOIN `g_municipio`  ON (g_municipio.`Id` = g_persona.`Id_Municipio`) INNER JOIN `g_barrio`  ON (g_barrio.`Id` = g_persona.`Id_Barrio`) INNER JOIN `g_estadocivil`  ON (g_estadocivil.`Id` = g_persona.`Id_EstadoCivil`) INNER JOIN `g_empresa`  ON (g_empresa.`Id` = g_usuario.`Id_EmpresaCont`)  INNER JOIN  `g_nivelestudio` ON (`g_nivelestudio`.`Id` = `ingreso`.`Id_NivelEstudio`)   INNER JOIN  `g_ocupacion` ON (`g_ocupacion`.`Id` = `ingreso`.`Id_Ocupacion`)    INNER JOIN `f_subgrupo_empresa`   ON (`f_liquidacion`.`Id_SubGrupoServicio` = `f_subgrupo_empresa`.`Id`) INNER JOIN  `f_subgruposervicio`   ON (`f_subgrupo_empresa`.`Id_SubGrupo` = `f_subgruposervicio`.`Id_SubgrupoServicio`)  INNER JOIN cc_resolucion_dian\n ON (cc_resolucion_dian.`Id` = f_factura_evento.`idResolucionDian`)\n LEFT JOIN (SELECT `Id_Ingreso` , `Cerrado`\nFROM\n    `ingreso_seguimiento`\nWHERE (`Cerrado` =0)\nGROUP BY `Id_Ingreso`)  s ON (s.Id_Ingreso=ingreso.`Id`)     WHERE (f_factura_evento.Fecha_FacturaEvento >='" + this.xmt.formatoAMD.format(this.JDCFechaInicio.getDate()) + "' AND f_factura_evento.Fecha_FacturaEvento <='" + this.xmt.formatoAMD.format(this.JDCFechaFin.getDate()) + "' AND`f_subgruposervicio`.`Id_GrupoServicio` ='" + this.xidservicio[this.JCBGrupo.getSelectedIndex()][0] + "' AND ingreso.Id_EmpresaContxConv ='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "' AND f_liquidacion.Estado =0  and f_factura_evento.EstaArmada='" + this.xarmada + "' AND ingreso.Estado=0 AND f_ordenes.Estado=0) GROUP BY f_factura_evento.No_FacturaEvento ORDER BY FechaF ASC, CONCAT(g_persona.`Apellido1`, ' ', g_persona.`Apellido2`, ' ', g_persona.`Nombre1`, ' ', g_persona.`Nombre2`) ASC ";
                }
            } else if (xorden == 1) {
                if (Principal.informacionIps.getNombreIps().equals("CLINICA OFTALMOLOGICA DAJUD SAS") || Principal.informacionIps.getNombreIps().equals("COD-OPTICA UT") || Principal.informacionIps.getNombreIps().equals("JAIME CESAR DAJUD FERNANDEZ")) {
                    this.xsql = "SELECT  IF( `cc_resolucion_dian`.`trasmision`= 0,IF(f_factura_evento.Prefijo<>'',CONCAT(f_factura_evento.Prefijo ,'',f_factura_evento.No_Facturaevento), f_factura_evento.No_Facturaevento), IF(f_factura_evento.Prefijo<>'',CONCAT(f_factura_evento.Prefijo ,'',f_factura_evento.`No_FacturaEvento_M`), f_factura_evento.`No_FacturaEvento_M`)) AS No_FacturaEvento, DATE_FORMAT(f_factura_evento.Fecha_FacturaEvento,'%d-%m-%Y') AS FechaF, g_usuario.`NoHistoria`, CONCAT(g_persona.`Apellido1`, ' ', g_persona.`Apellido2`, ' ', g_persona.`Nombre1`, ' ', g_persona.`Nombre2`) AS Nombre, f_liquidacion.TotalServicio, f_liquidacion.TotalPlan, f_liquidacion.TotalEps , f_liquidacion.TotalDescuento, f_liquidacion.TotalPaciente, (f_liquidacion.CuotaModeradora + f_liquidacion.Copago)  AS VCMD, g_persona.`Id`, ingreso.Id,  IF(f_factura_evento.EstaArmada=0,FALSE, TRUE) EstaArmada, f_liquidacion.Copago, f_liquidacion.CuotaModeradora, f_liquidacion.UsuarioS, ingreso.NoAutorizacion, g_contratos.`Nbre_Contrato`  ,  `g_persona`.`Id_Sexo`, g_persona.`FechaNac` , devuelve_Edad_2F(g_persona.`FechaNac`,f_factura_evento.Fecha_FacturaEvento) AS FNacimiento , devuelve_Tipo_Edad_2F(g_persona.`FechaNac`,f_factura_evento.Fecha_FacturaEvento) AS TipoEdad, g_municipio.`Nbre` AS NMunicipio , g_barrio.`Nbre` AS NBarrio, g_persona.`Direccion` , g_persona.`Telefono` , `g_nivelestudio`.`Nbre` ,  g_estadocivil.`Nbre` AS EstadoCivil, g_ocupacion.`Nbre`, g_persona.`Id_TipoIdentificacion`, g_persona.`NoDocumento`, ingreso.SO_Cargo, g_empresa.`Nbre` AS EPS  , ingreso.`Id_TipoAtencion`, `f_subgruposervicio`.`Nbre` AS `SubGrupo`   ,  IF(s.Cerrado IS NULL,0,1) CSeguimiento,IFNULL(f_itemripsconsulta.`Id_DxPrincipal`, '') Id_DxPrincipal ,IFNULL(`g_patologia`.`Nbre`,'') AS Diagnostico , f_factura_evento.`No_FacturaEvento` as IdFactura  FROM f_factura_evento INNER JOIN f_liquidacion  ON (f_factura_evento.Id_Liquidacion = f_liquidacion.Id)  INNER JOIN ingreso  ON (ingreso.Id = f_liquidacion.Id_Ingreso)  INNER JOIN `g_contratos`  ON (ingreso.`Id_Contrato` = g_contratos.`Id`)   INNER JOIN f_ordenes  ON (ingreso.Id = f_ordenes.Id_Ingreso) LEFT JOIN `f_itemripsconsulta` ON (f_itemripsconsulta.`Id_Ordenes`=`f_ordenes`.`Id`) LEFT JOIN `g_patologia` ON (`g_patologia`.`Id`=`f_itemripsconsulta`.`Id_DxPrincipal`) INNER JOIN `g_persona`  ON (ingreso.Id_Usuario = g_persona.`Id`) INNER JOIN `g_usuario`  ON (g_usuario.`Id_persona` = g_persona.`Id`)   INNER JOIN `g_municipio`  ON (g_municipio.`Id` = g_persona.`Id_Municipio`) INNER JOIN `g_barrio`  ON (g_barrio.`Id` = g_persona.`Id_Barrio`) INNER JOIN `g_estadocivil`  ON (g_estadocivil.`Id` = g_persona.`Id_EstadoCivil`) INNER JOIN `g_empresa`  ON (g_empresa.`Id` = g_usuario.`Id_EmpresaCont`)  INNER JOIN  `g_nivelestudio` ON (`g_nivelestudio`.`Id` = `ingreso`.`Id_NivelEstudio`)   INNER JOIN  `g_ocupacion` ON (`g_ocupacion`.`Id` = `ingreso`.`Id_Ocupacion`)   INNER JOIN cc_resolucion_dian \n ON (cc_resolucion_dian.`Id` = f_factura_evento.`idResolucionDian`)\n  INNER JOIN `f_subgrupo_empresa`   ON (`f_liquidacion`.`Id_SubGrupoServicio` = `f_subgrupo_empresa`.`Id`) INNER JOIN  `f_subgruposervicio`   ON (`f_subgrupo_empresa`.`Id_SubGrupo` = `f_subgruposervicio`.`Id_SubgrupoServicio`)  LEFT JOIN (SELECT `Id_Ingreso` , `Cerrado`\nFROM\n    `ingreso_seguimiento`\nWHERE (`Cerrado` =0)\nGROUP BY `Id_Ingreso`)  s ON (s.Id_Ingreso=ingreso.`Id`)     WHERE (f_factura_evento.Fecha_FacturaEvento >='" + this.xmt.formatoAMD.format(this.JDCFechaInicio.getDate()) + "' AND f_factura_evento.Fecha_FacturaEvento <='" + this.xmt.formatoAMD.format(this.JDCFechaFin.getDate()) + "' AND f_liquidacion.Id_SubGrupoServicio ='" + this.xidsubgrupo[this.JCBSubGrupo.getSelectedIndex()] + "' AND ingreso.Id_EmpresaContxConv ='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "' AND f_liquidacion.Estado =0  and f_factura_evento.EstaArmada='" + this.xarmada + "' AND ingreso.Estado=0 AND f_ordenes.Estado=0) GROUP BY f_factura_evento.No_FacturaEvento ORDER BY  CONCAT(g_persona.`Apellido1`, ' ', g_persona.`Apellido2`, ' ', g_persona.`Nombre1`, ' ', g_persona.`Nombre2`) ASC ";
                } else if (this.JCHFiltroGrupo.isSelected()) {
                    this.xsql = "SELECT  IF( `cc_resolucion_dian`.`trasmision`= 0,IF(f_factura_evento.Prefijo<>'',CONCAT(f_factura_evento.Prefijo ,'',f_factura_evento.No_Facturaevento), f_factura_evento.No_Facturaevento), IF(f_factura_evento.Prefijo<>'',CONCAT(f_factura_evento.Prefijo ,'',f_factura_evento.`No_FacturaEvento_M`), f_factura_evento.`No_FacturaEvento_M`)) AS No_FacturaEvento, DATE_FORMAT(f_factura_evento.Fecha_FacturaEvento,'%d-%m-%Y') AS FechaF, g_usuario.`NoHistoria`, CONCAT(g_persona.`Apellido1`, ' ', g_persona.`Apellido2`, ' ', g_persona.`Nombre1`, ' ', g_persona.`Nombre2`) AS Nombre, f_liquidacion.TotalServicio, f_liquidacion.TotalPlan, f_liquidacion.TotalEps , f_liquidacion.TotalDescuento, f_liquidacion.TotalPaciente, (f_liquidacion.CuotaModeradora + f_liquidacion.Copago)  AS VCMD, g_persona.`Id`, ingreso.Id,  IF(f_factura_evento.EstaArmada=0,FALSE, TRUE) EstaArmada, f_liquidacion.Copago, f_liquidacion.CuotaModeradora, f_liquidacion.UsuarioS, ingreso.NoAutorizacion, g_contratos.`Nbre_Contrato`  ,  `g_persona`.`Id_Sexo`, g_persona.`FechaNac` , devuelve_Edad_2F(g_persona.`FechaNac`,f_factura_evento.Fecha_FacturaEvento) AS FNacimiento , devuelve_Tipo_Edad_2F(g_persona.`FechaNac`,f_factura_evento.Fecha_FacturaEvento) AS TipoEdad, g_municipio.`Nbre` AS NMunicipio , g_barrio.`Nbre` AS NBarrio, g_persona.`Direccion` , g_persona.`Telefono` , `g_nivelestudio`.`Nbre` ,  g_estadocivil.`Nbre` AS EstadoCivil, g_ocupacion.`Nbre`, g_persona.`Id_TipoIdentificacion`, g_persona.`NoDocumento`, ingreso.SO_Cargo, g_empresa.`Nbre` AS EPS  , ingreso.`Id_TipoAtencion`, `f_subgruposervicio`.`Nbre` AS `SubGrupo`   ,  IF(s.Cerrado IS NULL,0,1) CSeguimiento,IFNULL(f_itemripsconsulta.`Id_DxPrincipal`, '') Id_DxPrincipal ,IFNULL(`g_patologia`.`Nbre`,'') AS Diagnostico ,f_factura_evento.`No_FacturaEvento` as IdFactura  FROM f_factura_evento INNER JOIN f_liquidacion  ON (f_factura_evento.Id_Liquidacion = f_liquidacion.Id)  INNER JOIN ingreso  ON (ingreso.Id = f_liquidacion.Id_Ingreso)  INNER JOIN `g_contratos`  ON (ingreso.`Id_Contrato` = g_contratos.`Id`)   INNER JOIN f_ordenes  ON (ingreso.Id = f_ordenes.Id_Ingreso) LEFT JOIN `f_itemripsconsulta` ON (f_itemripsconsulta.`Id_Ordenes`=`f_ordenes`.`Id`) LEFT JOIN `g_patologia` ON (`g_patologia`.`Id`=`f_itemripsconsulta`.`Id_DxPrincipal`) INNER JOIN `g_persona`  ON (ingreso.Id_Usuario = g_persona.`Id`) INNER JOIN `g_usuario`  ON (g_usuario.`Id_persona` = g_persona.`Id`)   INNER JOIN `g_municipio`  ON (g_municipio.`Id` = g_persona.`Id_Municipio`) INNER JOIN `g_barrio`  ON (g_barrio.`Id` = g_persona.`Id_Barrio`) INNER JOIN `g_estadocivil`  ON (g_estadocivil.`Id` = g_persona.`Id_EstadoCivil`) INNER JOIN `g_empresa`  ON (g_empresa.`Id` = g_usuario.`Id_EmpresaCont`)  INNER JOIN  `g_nivelestudio` ON (`g_nivelestudio`.`Id` = `ingreso`.`Id_NivelEstudio`)   INNER JOIN  `g_ocupacion` ON (`g_ocupacion`.`Id` = `ingreso`.`Id_Ocupacion`)    INNER JOIN cc_resolucion_dian \n ON (cc_resolucion_dian.`Id` = f_factura_evento.`idResolucionDian`)\n  INNER JOIN `f_subgrupo_empresa`   ON (`f_liquidacion`.`Id_SubGrupoServicio` = `f_subgrupo_empresa`.`Id`) INNER JOIN  `f_subgruposervicio`   ON (`f_subgrupo_empresa`.`Id_SubGrupo` = `f_subgruposervicio`.`Id_SubgrupoServicio`)  LEFT JOIN (SELECT `Id_Ingreso` , `Cerrado`\nFROM\n    `ingreso_seguimiento`\nWHERE (`Cerrado` =0)\nGROUP BY `Id_Ingreso`)  s ON (s.Id_Ingreso=ingreso.`Id`)     WHERE (f_factura_evento.Fecha_FacturaEvento >='" + this.xmt.formatoAMD.format(this.JDCFechaInicio.getDate()) + "' AND f_factura_evento.Fecha_FacturaEvento <='" + this.xmt.formatoAMD.format(this.JDCFechaFin.getDate()) + "' AND f_liquidacion.Id_SubGrupoServicio ='" + this.xidsubgrupo[this.JCBSubGrupo.getSelectedIndex()] + "' AND ingreso.Id_EmpresaContxConv ='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "' AND f_liquidacion.Estado =0  and f_factura_evento.EstaArmada='" + this.xarmada + "' AND ingreso.Estado=0 AND f_ordenes.Estado=0) GROUP BY f_factura_evento.No_FacturaEvento ORDER BY  CONCAT(g_persona.`Apellido1`, ' ', g_persona.`Apellido2`, ' ', g_persona.`Nombre1`, ' ', g_persona.`Nombre2`) ASC ";
                } else {
                    this.xsql = "SELECT  IF( `cc_resolucion_dian`.`trasmision`= 0,IF(f_factura_evento.Prefijo<>'',CONCAT(f_factura_evento.Prefijo ,'',f_factura_evento.No_Facturaevento), f_factura_evento.No_Facturaevento), IF(f_factura_evento.Prefijo<>'',CONCAT(f_factura_evento.Prefijo ,'',f_factura_evento.`No_FacturaEvento_M`), f_factura_evento.`No_FacturaEvento_M`)) AS No_FacturaEvento, DATE_FORMAT(f_factura_evento.Fecha_FacturaEvento,'%d-%m-%Y') AS FechaF, g_usuario.`NoHistoria`, CONCAT(g_persona.`Apellido1`, ' ', g_persona.`Apellido2`, ' ', g_persona.`Nombre1`, ' ', g_persona.`Nombre2`) AS Nombre, f_liquidacion.TotalServicio, f_liquidacion.TotalPlan, f_liquidacion.TotalEps , f_liquidacion.TotalDescuento, f_liquidacion.TotalPaciente, (f_liquidacion.CuotaModeradora + f_liquidacion.Copago)  AS VCMD, g_persona.`Id`, ingreso.Id,  IF(f_factura_evento.EstaArmada=0,FALSE, TRUE) EstaArmada, f_liquidacion.Copago, f_liquidacion.CuotaModeradora, f_liquidacion.UsuarioS, ingreso.NoAutorizacion, g_contratos.`Nbre_Contrato`  ,  `g_persona`.`Id_Sexo`, g_persona.`FechaNac` , devuelve_Edad_2F(g_persona.`FechaNac`,f_factura_evento.Fecha_FacturaEvento) AS FNacimiento , devuelve_Tipo_Edad_2F(g_persona.`FechaNac`,f_factura_evento.Fecha_FacturaEvento) AS TipoEdad, g_municipio.`Nbre` AS NMunicipio , g_barrio.`Nbre` AS NBarrio, g_persona.`Direccion` , g_persona.`Telefono` , `g_nivelestudio`.`Nbre` ,  g_estadocivil.`Nbre` AS EstadoCivil, g_ocupacion.`Nbre`, g_persona.`Id_TipoIdentificacion`, g_persona.`NoDocumento`, ingreso.SO_Cargo, g_empresa.`Nbre` AS EPS  , ingreso.`Id_TipoAtencion`, `f_subgruposervicio`.`Nbre` AS `SubGrupo`   ,  IF(s.Cerrado IS NULL,0,1) CSeguimiento,IFNULL(f_itemripsconsulta.`Id_DxPrincipal`, '') Id_DxPrincipal ,IFNULL(`g_patologia`.`Nbre`,'') AS Diagnostico , f_factura_evento.`No_FacturaEvento` as IdFactura  FROM f_factura_evento INNER JOIN f_liquidacion  ON (f_factura_evento.Id_Liquidacion = f_liquidacion.Id)  INNER JOIN ingreso  ON (ingreso.Id = f_liquidacion.Id_Ingreso)  INNER JOIN `g_contratos`  ON (ingreso.`Id_Contrato` = g_contratos.`Id`)   INNER JOIN f_ordenes  ON (ingreso.Id = f_ordenes.Id_Ingreso) LEFT JOIN `f_itemripsconsulta` ON (f_itemripsconsulta.`Id_Ordenes`=`f_ordenes`.`Id`) LEFT JOIN `g_patologia` ON (`g_patologia`.`Id`=`f_itemripsconsulta`.`Id_DxPrincipal`) INNER JOIN `g_persona`  ON (ingreso.Id_Usuario = g_persona.`Id`) INNER JOIN `g_usuario`  ON (g_usuario.`Id_persona` = g_persona.`Id`)   INNER JOIN `g_municipio`  ON (g_municipio.`Id` = g_persona.`Id_Municipio`) INNER JOIN `g_barrio`  ON (g_barrio.`Id` = g_persona.`Id_Barrio`) INNER JOIN `g_estadocivil`  ON (g_estadocivil.`Id` = g_persona.`Id_EstadoCivil`) INNER JOIN `g_empresa`  ON (g_empresa.`Id` = g_usuario.`Id_EmpresaCont`)  INNER JOIN  `g_nivelestudio` ON (`g_nivelestudio`.`Id` = `ingreso`.`Id_NivelEstudio`)   INNER JOIN  `g_ocupacion` ON (`g_ocupacion`.`Id` = `ingreso`.`Id_Ocupacion`)    INNER JOIN cc_resolucion_dian \n ON (cc_resolucion_dian.`Id` = f_factura_evento.`idResolucionDian`)\n  INNER JOIN `f_subgrupo_empresa`   ON (`f_liquidacion`.`Id_SubGrupoServicio` = `f_subgrupo_empresa`.`Id`) INNER JOIN  `f_subgruposervicio`   ON (`f_subgrupo_empresa`.`Id_SubGrupo` = `f_subgruposervicio`.`Id_SubgrupoServicio`)  LEFT JOIN (SELECT `Id_Ingreso` , `Cerrado`\nFROM\n    `ingreso_seguimiento`\nWHERE (`Cerrado` =0)\nGROUP BY `Id_Ingreso`)  s ON (s.Id_Ingreso=ingreso.`Id`)     WHERE (f_factura_evento.Fecha_FacturaEvento >='" + this.xmt.formatoAMD.format(this.JDCFechaInicio.getDate()) + "' AND f_factura_evento.Fecha_FacturaEvento <='" + this.xmt.formatoAMD.format(this.JDCFechaFin.getDate()) + "' AND`f_subgruposervicio`.`Id_GrupoServicio` ='" + this.xidservicio[this.JCBGrupo.getSelectedIndex()][0] + "' AND ingreso.Id_EmpresaContxConv ='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "' AND f_liquidacion.Estado =0  and f_factura_evento.EstaArmada='" + this.xarmada + "' AND ingreso.Estado=0 AND f_ordenes.Estado=0) GROUP BY f_factura_evento.No_FacturaEvento ORDER BY  CONCAT(g_persona.`Apellido1`, ' ', g_persona.`Apellido2`, ' ', g_persona.`Nombre1`, ' ', g_persona.`Nombre2`) ASC ";
                }
            } else if (xorden == 2) {
                if (Principal.informacionIps.getNombreIps().equals("CLINICA OFTALMOLOGICA DAJUD SAS") || Principal.informacionIps.getNombreIps().equals("COD-OPTICA UT") || Principal.informacionIps.getNombreIps().equals("JAIME CESAR DAJUD FERNANDEZ")) {
                    this.xsql = "SELECT  IF( `cc_resolucion_dian`.`trasmision`= 0,IF(f_factura_evento.Prefijo<>'',CONCAT(f_factura_evento.Prefijo ,'',f_factura_evento.No_Facturaevento), f_factura_evento.No_Facturaevento), IF(f_factura_evento.Prefijo<>'',CONCAT(f_factura_evento.Prefijo ,'',f_factura_evento.`No_FacturaEvento_M`), f_factura_evento.`No_FacturaEvento_M`)) AS No_FacturaEvento, DATE_FORMAT(f_factura_evento.Fecha_FacturaEvento,'%d-%m-%Y') AS FechaF, g_usuario.`NoHistoria`, CONCAT(g_persona.`Apellido1`, ' ', g_persona.`Apellido2`, ' ', g_persona.`Nombre1`, ' ', g_persona.`Nombre2`) AS Nombre, f_liquidacion.TotalServicio, f_liquidacion.TotalPlan, f_liquidacion.TotalEps , f_liquidacion.TotalDescuento, f_liquidacion.TotalPaciente, (f_liquidacion.CuotaModeradora + f_liquidacion.Copago)  AS VCMD, g_persona.`Id`, ingreso.Id,  IF(f_factura_evento.EstaArmada=0,FALSE, TRUE) EstaArmada, f_liquidacion.Copago, f_liquidacion.CuotaModeradora, f_liquidacion.UsuarioS, ingreso.NoAutorizacion, g_contratos.`Nbre_Contrato`  ,  `g_persona`.`Id_Sexo`, g_persona.`FechaNac` , devuelve_Edad_2F(g_persona.`FechaNac`,f_factura_evento.Fecha_FacturaEvento) AS FNacimiento , devuelve_Tipo_Edad_2F(g_persona.`FechaNac`,f_factura_evento.Fecha_FacturaEvento) AS TipoEdad, g_municipio.`Nbre` AS NMunicipio , g_barrio.`Nbre` AS NBarrio, g_persona.`Direccion` , g_persona.`Telefono` , `g_nivelestudio`.`Nbre` ,  g_estadocivil.`Nbre` AS EstadoCivil, g_ocupacion.`Nbre`, g_persona.`Id_TipoIdentificacion`, g_persona.`NoDocumento`, ingreso.SO_Cargo, g_empresa.`Nbre` AS EPS  , ingreso.`Id_TipoAtencion`, `f_subgruposervicio`.`Nbre` AS `SubGrupo`   ,  IF(s.Cerrado IS NULL,0,1) CSeguimiento,IFNULL(f_itemripsconsulta.`Id_DxPrincipal`, '') Id_DxPrincipal ,IFNULL(`g_patologia`.`Nbre`,'') AS Diagnostico , f_factura_evento.`No_FacturaEvento` as IdFactura   FROM f_factura_evento INNER JOIN f_liquidacion  ON (f_factura_evento.Id_Liquidacion = f_liquidacion.Id)  INNER JOIN ingreso  ON (ingreso.Id = f_liquidacion.Id_Ingreso)  INNER JOIN `g_contratos`  ON (ingreso.`Id_Contrato` = g_contratos.`Id`)   INNER JOIN f_ordenes  ON (ingreso.Id = f_ordenes.Id_Ingreso) LEFT JOIN `f_itemripsconsulta` ON (f_itemripsconsulta.`Id_Ordenes`=`f_ordenes`.`Id`) LEFT JOIN `g_patologia` ON (`g_patologia`.`Id`=`f_itemripsconsulta`.`Id_DxPrincipal`) INNER JOIN `g_persona`  ON (ingreso.Id_Usuario = g_persona.`Id`) INNER JOIN `g_usuario`  ON (g_usuario.`Id_persona` = g_persona.`Id`)   INNER JOIN `g_municipio`  ON (g_municipio.`Id` = g_persona.`Id_Municipio`) INNER JOIN `g_barrio`  ON (g_barrio.`Id` = g_persona.`Id_Barrio`) INNER JOIN `g_estadocivil`  ON (g_estadocivil.`Id` = g_persona.`Id_EstadoCivil`) INNER JOIN `g_empresa`  ON (g_empresa.`Id` = g_usuario.`Id_EmpresaCont`)  INNER JOIN  `g_nivelestudio` ON (`g_nivelestudio`.`Id` = `ingreso`.`Id_NivelEstudio`)   INNER JOIN  `g_ocupacion` ON (`g_ocupacion`.`Id` = `ingreso`.`Id_Ocupacion`)    INNER JOIN cc_resolucion_dian \n ON (cc_resolucion_dian.`Id` = f_factura_evento.`idResolucionDian`)\n  INNER JOIN `f_subgrupo_empresa`   ON (`f_liquidacion`.`Id_SubGrupoServicio` = `f_subgrupo_empresa`.`Id`) INNER JOIN  `f_subgruposervicio`   ON (`f_subgrupo_empresa`.`Id_SubGrupo` = `f_subgruposervicio`.`Id_SubgrupoServicio`)  LEFT JOIN (SELECT `Id_Ingreso` , `Cerrado`\nFROM\n    `ingreso_seguimiento`\nWHERE (`Cerrado` =0)\nGROUP BY `Id_Ingreso`)  s ON (s.Id_Ingreso=ingreso.`Id`)     WHERE (f_factura_evento.Fecha_FacturaEvento >='" + this.xmt.formatoAMD.format(this.JDCFechaInicio.getDate()) + "' AND f_factura_evento.Fecha_FacturaEvento <='" + this.xmt.formatoAMD.format(this.JDCFechaFin.getDate()) + "' AND f_liquidacion.Id_SubGrupoServicio ='" + this.xidsubgrupo[this.JCBSubGrupo.getSelectedIndex()] + "' AND ingreso.Id_EmpresaContxConv ='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "' AND f_liquidacion.Estado =0  and f_factura_evento.EstaArmada='" + this.xarmada + "' AND ingreso.Estado=0 AND f_ordenes.Estado=0) GROUP BY f_factura_evento.No_FacturaEvento ORDER BY  f_liquidacion.TotalServicio ";
                } else if (this.JCHFiltroGrupo.isSelected()) {
                    this.xsql = "SELECT  IF( `cc_resolucion_dian`.`trasmision`= 0,IF(f_factura_evento.Prefijo<>'',CONCAT(f_factura_evento.Prefijo ,'',f_factura_evento.No_Facturaevento), f_factura_evento.No_Facturaevento), IF(f_factura_evento.Prefijo<>'',CONCAT(f_factura_evento.Prefijo ,'',f_factura_evento.`No_FacturaEvento_M`), f_factura_evento.`No_FacturaEvento_M`)) AS No_FacturaEvento, DATE_FORMAT(f_factura_evento.Fecha_FacturaEvento,'%d-%m-%Y') AS FechaF, g_usuario.`NoHistoria`, CONCAT(g_persona.`Apellido1`, ' ', g_persona.`Apellido2`, ' ', g_persona.`Nombre1`, ' ', g_persona.`Nombre2`) AS Nombre, f_liquidacion.TotalServicio, f_liquidacion.TotalPlan, f_liquidacion.TotalEps , f_liquidacion.TotalDescuento, f_liquidacion.TotalPaciente, (f_liquidacion.CuotaModeradora + f_liquidacion.Copago)  AS VCMD, g_persona.`Id`, ingreso.Id,  IF(f_factura_evento.EstaArmada=0,FALSE, TRUE) EstaArmada, f_liquidacion.Copago, f_liquidacion.CuotaModeradora, f_liquidacion.UsuarioS, ingreso.NoAutorizacion, g_contratos.`Nbre_Contrato`  ,  `g_persona`.`Id_Sexo`, g_persona.`FechaNac` , devuelve_Edad_2F(g_persona.`FechaNac`,f_factura_evento.Fecha_FacturaEvento) AS FNacimiento , devuelve_Tipo_Edad_2F(g_persona.`FechaNac`,f_factura_evento.Fecha_FacturaEvento) AS TipoEdad, g_municipio.`Nbre` AS NMunicipio , g_barrio.`Nbre` AS NBarrio, g_persona.`Direccion` , g_persona.`Telefono` , `g_nivelestudio`.`Nbre` ,  g_estadocivil.`Nbre` AS EstadoCivil, g_ocupacion.`Nbre`, g_persona.`Id_TipoIdentificacion`, g_persona.`NoDocumento`, ingreso.SO_Cargo, g_empresa.`Nbre` AS EPS  , ingreso.`Id_TipoAtencion`, `f_subgruposervicio`.`Nbre` AS `SubGrupo`   ,  IF(s.Cerrado IS NULL,0,1) CSeguimiento,IFNULL(f_itemripsconsulta.`Id_DxPrincipal`, '') Id_DxPrincipal ,IFNULL(`g_patologia`.`Nbre`,'') AS Diagnostico, f_factura_evento.`No_FacturaEvento` as IdFactura  FROM f_factura_evento INNER JOIN f_liquidacion  ON (f_factura_evento.Id_Liquidacion = f_liquidacion.Id)  INNER JOIN ingreso  ON (ingreso.Id = f_liquidacion.Id_Ingreso)  INNER JOIN `g_contratos`  ON (ingreso.`Id_Contrato` = g_contratos.`Id`)   INNER JOIN f_ordenes  ON (ingreso.Id = f_ordenes.Id_Ingreso) LEFT JOIN `f_itemripsconsulta` ON (f_itemripsconsulta.`Id_Ordenes`=`f_ordenes`.`Id`) LEFT JOIN `g_patologia` ON (`g_patologia`.`Id`=`f_itemripsconsulta`.`Id_DxPrincipal`) INNER JOIN `g_persona`  ON (ingreso.Id_Usuario = g_persona.`Id`) INNER JOIN `g_usuario`  ON (g_usuario.`Id_persona` = g_persona.`Id`)   INNER JOIN `g_municipio`  ON (g_municipio.`Id` = g_persona.`Id_Municipio`) INNER JOIN `g_barrio`  ON (g_barrio.`Id` = g_persona.`Id_Barrio`) INNER JOIN `g_estadocivil`  ON (g_estadocivil.`Id` = g_persona.`Id_EstadoCivil`) INNER JOIN `g_empresa`  ON (g_empresa.`Id` = g_usuario.`Id_EmpresaCont`)  INNER JOIN  `g_nivelestudio` ON (`g_nivelestudio`.`Id` = `ingreso`.`Id_NivelEstudio`)   INNER JOIN  `g_ocupacion` ON (`g_ocupacion`.`Id` = `ingreso`.`Id_Ocupacion`)    INNER JOIN `f_subgrupo_empresa`   ON (`f_liquidacion`.`Id_SubGrupoServicio` = `f_subgrupo_empresa`.`Id`) INNER JOIN  `f_subgruposervicio`   ON (`f_subgrupo_empresa`.`Id_SubGrupo` = `f_subgruposervicio`.`Id_SubgrupoServicio`)  INNER JOIN cc_resolucion_dian\n ON (cc_resolucion_dian.`Id` = f_factura_evento.`idResolucionDian`) \n LEFT JOIN (SELECT `Id_Ingreso` , `Cerrado`\nFROM\n    `ingreso_seguimiento`\nWHERE (`Cerrado` =0)\nGROUP BY `Id_Ingreso`)  s ON (s.Id_Ingreso=ingreso.`Id`)     WHERE (f_factura_evento.Fecha_FacturaEvento >='" + this.xmt.formatoAMD.format(this.JDCFechaInicio.getDate()) + "' AND f_factura_evento.Fecha_FacturaEvento <='" + this.xmt.formatoAMD.format(this.JDCFechaFin.getDate()) + "' AND f_liquidacion.Id_SubGrupoServicio ='" + this.xidsubgrupo[this.JCBSubGrupo.getSelectedIndex()] + "' AND ingreso.Id_EmpresaContxConv ='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "' AND f_liquidacion.Estado =0  and f_factura_evento.EstaArmada='" + this.xarmada + "' AND ingreso.Estado=0 AND f_ordenes.Estado=0) GROUP BY f_factura_evento.No_FacturaEvento ORDER BY  f_liquidacion.TotalServicio ";
                } else {
                    this.xsql = "SELECT  IF( `cc_resolucion_dian`.`trasmision`= 0,IF(f_factura_evento.Prefijo<>'',CONCAT(f_factura_evento.Prefijo ,'',f_factura_evento.No_Facturaevento), f_factura_evento.No_Facturaevento), IF(f_factura_evento.Prefijo<>'',CONCAT(f_factura_evento.Prefijo ,'',f_factura_evento.`No_FacturaEvento_M`), f_factura_evento.`No_FacturaEvento_M`)) AS No_FacturaEvento, DATE_FORMAT(f_factura_evento.Fecha_FacturaEvento,'%d-%m-%Y') AS FechaF, g_usuario.`NoHistoria`, CONCAT(g_persona.`Apellido1`, ' ', g_persona.`Apellido2`, ' ', g_persona.`Nombre1`, ' ', g_persona.`Nombre2`) AS Nombre, f_liquidacion.TotalServicio, f_liquidacion.TotalPlan, f_liquidacion.TotalEps , f_liquidacion.TotalDescuento, f_liquidacion.TotalPaciente, (f_liquidacion.CuotaModeradora + f_liquidacion.Copago)  AS VCMD, g_persona.`Id`, ingreso.Id,  IF(f_factura_evento.EstaArmada=0,FALSE, TRUE) EstaArmada, f_liquidacion.Copago, f_liquidacion.CuotaModeradora, f_liquidacion.UsuarioS, ingreso.NoAutorizacion, g_contratos.`Nbre_Contrato`  ,  `g_persona`.`Id_Sexo`, g_persona.`FechaNac` , devuelve_Edad_2F(g_persona.`FechaNac`,f_factura_evento.Fecha_FacturaEvento) AS FNacimiento , devuelve_Tipo_Edad_2F(g_persona.`FechaNac`,f_factura_evento.Fecha_FacturaEvento) AS TipoEdad, g_municipio.`Nbre` AS NMunicipio , g_barrio.`Nbre` AS NBarrio, g_persona.`Direccion` , g_persona.`Telefono` , `g_nivelestudio`.`Nbre` ,  g_estadocivil.`Nbre` AS EstadoCivil, g_ocupacion.`Nbre`, g_persona.`Id_TipoIdentificacion`, g_persona.`NoDocumento`, ingreso.SO_Cargo, g_empresa.`Nbre` AS EPS  , ingreso.`Id_TipoAtencion`, `f_subgruposervicio`.`Nbre` AS `SubGrupo`   ,  IF(s.Cerrado IS NULL,0,1) CSeguimiento,IFNULL(f_itemripsconsulta.`Id_DxPrincipal`, '') Id_DxPrincipal ,IFNULL(`g_patologia`.`Nbre`,'') AS Diagnostico ,f_factura_evento.`No_FacturaEvento` as IdFactura  FROM f_factura_evento INNER JOIN f_liquidacion  ON (f_factura_evento.Id_Liquidacion = f_liquidacion.Id)  INNER JOIN ingreso  ON (ingreso.Id = f_liquidacion.Id_Ingreso)  INNER JOIN `g_contratos`  ON (ingreso.`Id_Contrato` = g_contratos.`Id`)   INNER JOIN f_ordenes  ON (ingreso.Id = f_ordenes.Id_Ingreso) LEFT JOIN `f_itemripsconsulta` ON (f_itemripsconsulta.`Id_Ordenes`=`f_ordenes`.`Id`) LEFT JOIN `g_patologia` ON (`g_patologia`.`Id`=`f_itemripsconsulta`.`Id_DxPrincipal`) INNER JOIN `g_persona`  ON (ingreso.Id_Usuario = g_persona.`Id`) INNER JOIN `g_usuario`  ON (g_usuario.`Id_persona` = g_persona.`Id`)   INNER JOIN `g_municipio`  ON (g_municipio.`Id` = g_persona.`Id_Municipio`) INNER JOIN `g_barrio`  ON (g_barrio.`Id` = g_persona.`Id_Barrio`) INNER JOIN `g_estadocivil`  ON (g_estadocivil.`Id` = g_persona.`Id_EstadoCivil`) INNER JOIN `g_empresa`  ON (g_empresa.`Id` = g_usuario.`Id_EmpresaCont`)  INNER JOIN  `g_nivelestudio` ON (`g_nivelestudio`.`Id` = `ingreso`.`Id_NivelEstudio`)   INNER JOIN  `g_ocupacion` ON (`g_ocupacion`.`Id` = `ingreso`.`Id_Ocupacion`)    INNER JOIN `f_subgrupo_empresa`   ON (`f_liquidacion`.`Id_SubGrupoServicio` = `f_subgrupo_empresa`.`Id`) INNER JOIN  `f_subgruposervicio`   ON (`f_subgrupo_empresa`.`Id_SubGrupo` = `f_subgruposervicio`.`Id_SubgrupoServicio`)  INNER JOIN cc_resolucion_dian\n ON (cc_resolucion_dian.`Id` = f_factura_evento.`idResolucionDian`) \n LEFT JOIN (SELECT `Id_Ingreso` , `Cerrado`\nFROM\n    `ingreso_seguimiento`\nWHERE (`Cerrado` =0)\nGROUP BY `Id_Ingreso`)  s ON (s.Id_Ingreso=ingreso.`Id`)     WHERE (f_factura_evento.Fecha_FacturaEvento >='" + this.xmt.formatoAMD.format(this.JDCFechaInicio.getDate()) + "' AND f_factura_evento.Fecha_FacturaEvento <='" + this.xmt.formatoAMD.format(this.JDCFechaFin.getDate()) + "' AND`f_subgruposervicio`.`Id_GrupoServicio` ='" + this.xidservicio[this.JCBGrupo.getSelectedIndex()][0] + "' AND ingreso.Id_EmpresaContxConv ='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "' AND f_liquidacion.Estado =0  and f_factura_evento.EstaArmada='" + this.xarmada + "' AND ingreso.Estado=0 AND f_ordenes.Estado=0) GROUP BY f_factura_evento.No_FacturaEvento ORDER BY  f_liquidacion.TotalServicio ";
                }
            } else if (xorden == 3) {
                if (Principal.informacionIps.getNombreIps().equals("CLINICA OFTALMOLOGICA DAJUD SAS") || Principal.informacionIps.getNombreIps().equals("COD-OPTICA UT") || Principal.informacionIps.getNombreIps().equals("JAIME CESAR DAJUD FERNANDEZ")) {
                    this.xsql = "SELECT  IF( `cc_resolucion_dian`.`trasmision`= 0,IF(f_factura_evento.Prefijo<>'',CONCAT(f_factura_evento.Prefijo ,'',f_factura_evento.No_Facturaevento), f_factura_evento.No_Facturaevento), IF(f_factura_evento.Prefijo<>'',CONCAT(f_factura_evento.Prefijo ,'',f_factura_evento.`No_FacturaEvento_M`), f_factura_evento.`No_FacturaEvento_M`)) AS No_FacturaEvento, DATE_FORMAT(f_factura_evento.Fecha_FacturaEvento,'%d-%m-%Y') AS FechaF, g_usuario.`NoHistoria`, CONCAT(g_persona.`Apellido1`, ' ', g_persona.`Apellido2`, ' ', g_persona.`Nombre1`, ' ', g_persona.`Nombre2`) AS Nombre, f_liquidacion.TotalServicio, f_liquidacion.TotalPlan, f_liquidacion.TotalEps , f_liquidacion.TotalDescuento, f_liquidacion.TotalPaciente, (f_liquidacion.CuotaModeradora + f_liquidacion.Copago)  AS VCMD, g_persona.`Id`, ingreso.Id,  IF(f_factura_evento.EstaArmada=0,FALSE, TRUE) EstaArmada, f_liquidacion.Copago, f_liquidacion.CuotaModeradora, f_liquidacion.UsuarioS, ingreso.NoAutorizacion, g_contratos.`Nbre_Contrato`  ,  `g_persona`.`Id_Sexo`, g_persona.`FechaNac` , devuelve_Edad_2F(g_persona.`FechaNac`,f_factura_evento.Fecha_FacturaEvento) AS FNacimiento , devuelve_Tipo_Edad_2F(g_persona.`FechaNac`,f_factura_evento.Fecha_FacturaEvento) AS TipoEdad, g_municipio.`Nbre` AS NMunicipio , g_barrio.`Nbre` AS NBarrio, g_persona.`Direccion` , g_persona.`Telefono` , `g_nivelestudio`.`Nbre` ,  g_estadocivil.`Nbre` AS EstadoCivil, g_ocupacion.`Nbre`, g_persona.`Id_TipoIdentificacion`, g_persona.`NoDocumento`, ingreso.SO_Cargo, g_empresa.`Nbre` AS EPS  , ingreso.`Id_TipoAtencion`, `f_subgruposervicio`.`Nbre` AS `SubGrupo`   ,  IF(s.Cerrado IS NULL,0,1) CSeguimiento,IFNULL(f_itemripsconsulta.`Id_DxPrincipal`, '') Id_DxPrincipal ,IFNULL(`g_patologia`.`Nbre`,'') AS Diagnostico , f_factura_evento.`No_FacturaEvento` as IdFactura FROM f_factura_evento INNER JOIN f_liquidacion  ON (f_factura_evento.Id_Liquidacion = f_liquidacion.Id)  INNER JOIN ingreso  ON (ingreso.Id = f_liquidacion.Id_Ingreso)  INNER JOIN `g_contratos`  ON (ingreso.`Id_Contrato` = g_contratos.`Id`)   INNER JOIN f_ordenes  ON (ingreso.Id = f_ordenes.Id_Ingreso) LEFT JOIN `f_itemripsconsulta` ON (f_itemripsconsulta.`Id_Ordenes`=`f_ordenes`.`Id`) LEFT JOIN `g_patologia` ON (`g_patologia`.`Id`=`f_itemripsconsulta`.`Id_DxPrincipal`) INNER JOIN `g_persona`  ON (ingreso.Id_Usuario = g_persona.`Id`) INNER JOIN `g_usuario`  ON (g_usuario.`Id_persona` = g_persona.`Id`)   INNER JOIN `g_municipio`  ON (g_municipio.`Id` = g_persona.`Id_Municipio`) INNER JOIN `g_barrio`  ON (g_barrio.`Id` = g_persona.`Id_Barrio`) INNER JOIN `g_estadocivil`  ON (g_estadocivil.`Id` = g_persona.`Id_EstadoCivil`) INNER JOIN `g_empresa`  ON (g_empresa.`Id` = g_usuario.`Id_EmpresaCont`)  INNER JOIN  `g_nivelestudio` ON (`g_nivelestudio`.`Id` = `ingreso`.`Id_NivelEstudio`)   INNER JOIN  `g_ocupacion` ON (`g_ocupacion`.`Id` = `ingreso`.`Id_Ocupacion`)    INNER JOIN cc_resolucion_dian \n ON (cc_resolucion_dian.`Id` = f_factura_evento.`idResolucionDian`)\n  INNER JOIN `f_subgrupo_empresa`   ON (`f_liquidacion`.`Id_SubGrupoServicio` = `f_subgrupo_empresa`.`Id`) INNER JOIN  `f_subgruposervicio`   ON (`f_subgrupo_empresa`.`Id_SubGrupo` = `f_subgruposervicio`.`Id_SubgrupoServicio`)  LEFT JOIN (SELECT `Id_Ingreso` , `Cerrado`\nFROM\n    `ingreso_seguimiento`\nWHERE (`Cerrado` =0)\nGROUP BY `Id_Ingreso`)  s ON (s.Id_Ingreso=ingreso.`Id`)     WHERE (f_factura_evento.Fecha_FacturaEvento >='" + this.xmt.formatoAMD.format(this.JDCFechaInicio.getDate()) + "' AND f_factura_evento.Fecha_FacturaEvento <='" + this.xmt.formatoAMD.format(this.JDCFechaFin.getDate()) + "' AND f_liquidacion.Id_SubGrupoServicio ='" + this.xidsubgrupo[this.JCBSubGrupo.getSelectedIndex()] + "' AND ingreso.Id_EmpresaContxConv ='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "' AND f_liquidacion.Estado =0  and f_factura_evento.EstaArmada='" + this.xarmada + "' AND ingreso.Estado=0 AND f_ordenes.Estado=0) GROUP BY f_factura_evento.No_FacturaEvento ORDER BY  f_factura_evento.No_FacturaEvento asc ";
                } else if (this.JCHFiltroGrupo.isSelected()) {
                    this.xsql = "SELECT IF( `cc_resolucion_dian`.`trasmision`= 0,IF(f_factura_evento.Prefijo<>'',CONCAT(f_factura_evento.Prefijo ,'',f_factura_evento.No_Facturaevento), f_factura_evento.No_Facturaevento), IF(f_factura_evento.Prefijo<>'',CONCAT(f_factura_evento.Prefijo ,'',f_factura_evento.`No_FacturaEvento_M`), f_factura_evento.`No_FacturaEvento_M`)) AS No_FacturaEvento, DATE_FORMAT(f_factura_evento.Fecha_FacturaEvento,'%d-%m-%Y') AS FechaF, g_usuario.`NoHistoria`, CONCAT(g_persona.`Apellido1`, ' ', g_persona.`Apellido2`, ' ', g_persona.`Nombre1`, ' ', g_persona.`Nombre2`) AS Nombre, f_liquidacion.TotalServicio, f_liquidacion.TotalPlan, f_liquidacion.TotalEps , f_liquidacion.TotalDescuento, f_liquidacion.TotalPaciente, (f_liquidacion.CuotaModeradora + f_liquidacion.Copago)  AS VCMD, g_persona.`Id`, ingreso.Id,  IF(f_factura_evento.EstaArmada=0,FALSE, TRUE) EstaArmada, f_liquidacion.Copago, f_liquidacion.CuotaModeradora, f_liquidacion.UsuarioS, ingreso.NoAutorizacion, g_contratos.`Nbre_Contrato`  ,  `g_persona`.`Id_Sexo`, g_persona.`FechaNac` , devuelve_Edad_2F(g_persona.`FechaNac`,f_factura_evento.Fecha_FacturaEvento) AS FNacimiento , devuelve_Tipo_Edad_2F(g_persona.`FechaNac`,f_factura_evento.Fecha_FacturaEvento) AS TipoEdad, g_municipio.`Nbre` AS NMunicipio , g_barrio.`Nbre` AS NBarrio, g_persona.`Direccion` , g_persona.`Telefono` , `g_nivelestudio`.`Nbre` ,  g_estadocivil.`Nbre` AS EstadoCivil, g_ocupacion.`Nbre`, g_persona.`Id_TipoIdentificacion`, g_persona.`NoDocumento`, ingreso.SO_Cargo, g_empresa.`Nbre` AS EPS  , ingreso.`Id_TipoAtencion`, `f_subgruposervicio`.`Nbre` AS `SubGrupo`   ,  IF(s.Cerrado IS NULL,0,1) CSeguimiento,IFNULL(f_itemripsconsulta.`Id_DxPrincipal`, '') Id_DxPrincipal ,IFNULL(`g_patologia`.`Nbre`,'') AS Diagnostico ,f_factura_evento.`No_FacturaEvento` as IdFactura  FROM f_factura_evento INNER JOIN f_liquidacion  ON (f_factura_evento.Id_Liquidacion = f_liquidacion.Id)  INNER JOIN ingreso  ON (ingreso.Id = f_liquidacion.Id_Ingreso)  INNER JOIN `g_contratos`  ON (ingreso.`Id_Contrato` = g_contratos.`Id`)   INNER JOIN f_ordenes  ON (ingreso.Id = f_ordenes.Id_Ingreso) LEFT JOIN `f_itemripsconsulta` ON (f_itemripsconsulta.`Id_Ordenes`=`f_ordenes`.`Id`) LEFT JOIN `g_patologia` ON (`g_patologia`.`Id`=`f_itemripsconsulta`.`Id_DxPrincipal`) INNER JOIN `g_persona`  ON (ingreso.Id_Usuario = g_persona.`Id`) INNER JOIN `g_usuario`  ON (g_usuario.`Id_persona` = g_persona.`Id`)   INNER JOIN `g_municipio`  ON (g_municipio.`Id` = g_persona.`Id_Municipio`) INNER JOIN `g_barrio`  ON (g_barrio.`Id` = g_persona.`Id_Barrio`) INNER JOIN `g_estadocivil`  ON (g_estadocivil.`Id` = g_persona.`Id_EstadoCivil`) INNER JOIN `g_empresa`  ON (g_empresa.`Id` = g_usuario.`Id_EmpresaCont`)  INNER JOIN  `g_nivelestudio` ON (`g_nivelestudio`.`Id` = `ingreso`.`Id_NivelEstudio`)   INNER JOIN  `g_ocupacion` ON (`g_ocupacion`.`Id` = `ingreso`.`Id_Ocupacion`)    INNER JOIN `f_subgrupo_empresa`   ON (`f_liquidacion`.`Id_SubGrupoServicio` = `f_subgrupo_empresa`.`Id`) INNER JOIN  `f_subgruposervicio`   ON (`f_subgrupo_empresa`.`Id_SubGrupo` = `f_subgruposervicio`.`Id_SubgrupoServicio`)  INNER JOIN cc_resolucion_dian\n ON (cc_resolucion_dian.`Id` = f_factura_evento.`idResolucionDian`) \n LEFT JOIN (SELECT `Id_Ingreso` , `Cerrado`\nFROM\n    `ingreso_seguimiento`\nWHERE (`Cerrado` =0)\nGROUP BY `Id_Ingreso`)  s ON (s.Id_Ingreso=ingreso.`Id`)     WHERE (f_factura_evento.Fecha_FacturaEvento >='" + this.xmt.formatoAMD.format(this.JDCFechaInicio.getDate()) + "' AND f_factura_evento.Fecha_FacturaEvento <='" + this.xmt.formatoAMD.format(this.JDCFechaFin.getDate()) + "' AND f_liquidacion.Id_SubGrupoServicio ='" + this.xidsubgrupo[this.JCBSubGrupo.getSelectedIndex()] + "' AND ingreso.Id_EmpresaContxConv ='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "' AND f_liquidacion.Estado =0  and f_factura_evento.EstaArmada='" + this.xarmada + "' AND ingreso.Estado=0 AND f_ordenes.Estado=0) GROUP BY f_factura_evento.No_FacturaEvento ORDER BY  f_factura_evento.No_FacturaEvento asc ";
                } else {
                    this.xsql = "SELECT  IF( `cc_resolucion_dian`.`trasmision`= 0,IF(f_factura_evento.Prefijo<>'',CONCAT(f_factura_evento.Prefijo ,'',f_factura_evento.No_Facturaevento), f_factura_evento.No_Facturaevento), IF(f_factura_evento.Prefijo<>'',CONCAT(f_factura_evento.Prefijo ,'',f_factura_evento.`No_FacturaEvento_M`), f_factura_evento.`No_FacturaEvento_M`)) AS No_FacturaEvento, DATE_FORMAT(f_factura_evento.Fecha_FacturaEvento,'%d-%m-%Y') AS FechaF, g_usuario.`NoHistoria`, CONCAT(g_persona.`Apellido1`, ' ', g_persona.`Apellido2`, ' ', g_persona.`Nombre1`, ' ', g_persona.`Nombre2`) AS Nombre, f_liquidacion.TotalServicio, f_liquidacion.TotalPlan, f_liquidacion.TotalEps , f_liquidacion.TotalDescuento, f_liquidacion.TotalPaciente, (f_liquidacion.CuotaModeradora + f_liquidacion.Copago)  AS VCMD, g_persona.`Id`, ingreso.Id,  IF(f_factura_evento.EstaArmada=0,FALSE, TRUE) EstaArmada, f_liquidacion.Copago, f_liquidacion.CuotaModeradora, f_liquidacion.UsuarioS, ingreso.NoAutorizacion, g_contratos.`Nbre_Contrato`  ,  `g_persona`.`Id_Sexo`, g_persona.`FechaNac` , devuelve_Edad_2F(g_persona.`FechaNac`,f_factura_evento.Fecha_FacturaEvento) AS FNacimiento , devuelve_Tipo_Edad_2F(g_persona.`FechaNac`,f_factura_evento.Fecha_FacturaEvento) AS TipoEdad, g_municipio.`Nbre` AS NMunicipio , g_barrio.`Nbre` AS NBarrio, g_persona.`Direccion` , g_persona.`Telefono` , `g_nivelestudio`.`Nbre` ,  g_estadocivil.`Nbre` AS EstadoCivil, g_ocupacion.`Nbre`, g_persona.`Id_TipoIdentificacion`, g_persona.`NoDocumento`, ingreso.SO_Cargo, g_empresa.`Nbre` AS EPS  , ingreso.`Id_TipoAtencion`, `f_subgruposervicio`.`Nbre` AS `SubGrupo`   ,  IF(s.Cerrado IS NULL,0,1) CSeguimiento,IFNULL(f_itemripsconsulta.`Id_DxPrincipal`, '') Id_DxPrincipal ,IFNULL(`g_patologia`.`Nbre`,'') AS Diagnostico  , f_factura_evento.`No_FacturaEvento` as IdFactura FROM f_factura_evento INNER JOIN f_liquidacion  ON (f_factura_evento.Id_Liquidacion = f_liquidacion.Id)  INNER JOIN ingreso  ON (ingreso.Id = f_liquidacion.Id_Ingreso)  INNER JOIN `g_contratos`  ON (ingreso.`Id_Contrato` = g_contratos.`Id`)   INNER JOIN f_ordenes  ON (ingreso.Id = f_ordenes.Id_Ingreso) LEFT JOIN `f_itemripsconsulta` ON (f_itemripsconsulta.`Id_Ordenes`=`f_ordenes`.`Id`) LEFT JOIN `g_patologia` ON (`g_patologia`.`Id`=`f_itemripsconsulta`.`Id_DxPrincipal`) INNER JOIN `g_persona`  ON (ingreso.Id_Usuario = g_persona.`Id`) INNER JOIN `g_usuario`  ON (g_usuario.`Id_persona` = g_persona.`Id`)   INNER JOIN `g_municipio`  ON (g_municipio.`Id` = g_persona.`Id_Municipio`) INNER JOIN `g_barrio`  ON (g_barrio.`Id` = g_persona.`Id_Barrio`) INNER JOIN `g_estadocivil`  ON (g_estadocivil.`Id` = g_persona.`Id_EstadoCivil`) INNER JOIN `g_empresa`  ON (g_empresa.`Id` = g_usuario.`Id_EmpresaCont`)  INNER JOIN  `g_nivelestudio` ON (`g_nivelestudio`.`Id` = `ingreso`.`Id_NivelEstudio`)   INNER JOIN  `g_ocupacion` ON (`g_ocupacion`.`Id` = `ingreso`.`Id_Ocupacion`)    INNER JOIN `f_subgrupo_empresa`   ON (`f_liquidacion`.`Id_SubGrupoServicio` = `f_subgrupo_empresa`.`Id`) INNER JOIN  `f_subgruposervicio`   ON (`f_subgrupo_empresa`.`Id_SubGrupo` = `f_subgruposervicio`.`Id_SubgrupoServicio`)  INNER JOIN cc_resolucion_dian\n ON (cc_resolucion_dian.`Id` = f_factura_evento.`idResolucionDian`)\n LEFT JOIN (SELECT `Id_Ingreso` , `Cerrado`\nFROM\n    `ingreso_seguimiento`\nWHERE (`Cerrado` =0)\nGROUP BY `Id_Ingreso`)  s ON (s.Id_Ingreso=ingreso.`Id`)     WHERE (f_factura_evento.Fecha_FacturaEvento >='" + this.xmt.formatoAMD.format(this.JDCFechaInicio.getDate()) + "' AND f_factura_evento.Fecha_FacturaEvento <='" + this.xmt.formatoAMD.format(this.JDCFechaFin.getDate()) + "' AND`f_subgruposervicio`.`Id_GrupoServicio` ='" + this.xidservicio[this.JCBGrupo.getSelectedIndex()][0] + "' AND ingreso.Id_EmpresaContxConv ='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "' AND f_liquidacion.Estado =0  and f_factura_evento.EstaArmada='" + this.xarmada + "' AND ingreso.Estado=0 AND f_ordenes.Estado=0) GROUP BY f_factura_evento.No_FacturaEvento ORDER BY  f_factura_evento.No_FacturaEvento asc ";
                }
            }
        } else if (xorden == 0) {
            if (this.JCHFiltroGrupo.isSelected()) {
                this.xsql = "SELECT f_factura_capita.No_FacturaCapita, DATE_FORMAT(f_factura_capita.Fecha_FacturaCapita,'%d-%m-%Y') AS FechaF, g_usuario.`NoHistoria`, CONCAT(g_persona.`Apellido1`, ' ', g_persona.`Apellido2`, ' ', g_persona.`Nombre1`, ' ', g_persona.`Nombre2`) AS Nombre, f_liquidacion.TotalServicio, f_liquidacion.TotalPlan, f_liquidacion.TotalEps  , f_liquidacion.TotalDescuento, f_liquidacion.TotalPaciente, (f_liquidacion.CuotaModeradora + f_liquidacion.Copago)   AS VCMD,  g_persona.`Id`, ingreso.Id, IF(f_factura_capita.EstaArmada=0,FALSE, TRUE) EstaArmada, f_liquidacion.Copago, f_liquidacion.CuotaModeradora, f_liquidacion.UsuarioS, ingreso.NoAutorizacion, g_contratos.`Nbre_Contrato`  , `g_persona`.`Id_Sexo`, g_persona.`FechaNac` , devuelve_Edad_2F(g_persona.`FechaNac`,f_factura_capita.Fecha_FacturaCapita) AS FNacimiento , devuelve_Tipo_Edad_2F(g_persona.`FechaNac`,f_factura_capita.Fecha_FacturaCapita) AS TipoEdad, g_municipio.`Nbre` AS NMunicipio , g_barrio.`Nbre` AS NBarrio, g_persona.`Direccion` , g_persona.`Telefono` , `g_nivelestudio`.`Nbre` , g_estadocivil.`Nbre` AS EstadoCivil, g_ocupacion.`Nbre`, g_persona.`Id_TipoIdentificacion`, g_persona.`NoDocumento`, ingreso.SO_Cargo,g_empresa.`Nbre` AS EPS  , ingreso.`Id_TipoAtencion`, `f_subgruposervicio`.`Nbre` AS `SubGrupo`   ,  IF(s.Cerrado IS NULL,0,1) CSeguimiento,IFNULL(f_itemripsconsulta.`Id_DxPrincipal`, '') Id_DxPrincipal ,IFNULL(`g_patologia`.`Nbre`,'') AS Diagnostico,  f_factura_capita.No_FacturaCapita  as IdFactura  FROM f_factura_capita   INNER JOIN f_liquidacion  ON (f_factura_capita.Id_Liquidacion = f_liquidacion.Id)   INNER JOIN ingreso  ON (ingreso.Id = f_liquidacion.Id_Ingreso)  INNER JOIN `g_contratos`  ON (ingreso.`Id_Contrato` = g_contratos.`Id`)   INNER JOIN f_ordenes  ON (ingreso.Id = f_ordenes.Id_Ingreso) LEFT JOIN `f_itemripsconsulta` ON (f_itemripsconsulta.`Id_Ordenes`=`f_ordenes`.`Id`) LEFT JOIN `g_patologia` ON (`g_patologia`.`Id`=`f_itemripsconsulta`.`Id_DxPrincipal`) INNER JOIN `g_persona`  ON (ingreso.Id_Usuario = g_persona.`Id`) INNER JOIN `g_usuario`  ON (g_usuario.`Id_persona` = g_persona.`Id`)   INNER JOIN `g_municipio`  ON (g_municipio.`Id` = g_persona.`Id_Municipio`) INNER JOIN `g_barrio`  ON (g_barrio.`Id` = g_persona.`Id_Barrio`) INNER JOIN `g_estadocivil`  ON (g_estadocivil.`Id` = g_persona.`Id_EstadoCivil`) INNER JOIN `g_empresa`  ON (g_empresa.`Id` = g_usuario.`Id_EmpresaCont`) INNER JOIN  `g_nivelestudio` ON (`g_nivelestudio`.`Id` = `ingreso`.`Id_NivelEstudio`)  INNER JOIN  `g_ocupacion` ON (`g_ocupacion`.`Id` = `ingreso`.`Id_Ocupacion`)   INNER JOIN `f_subgrupo_empresa`   ON (`f_liquidacion`.`Id_SubGrupoServicio` = `f_subgrupo_empresa`.`Id`) INNER JOIN  `f_subgruposervicio`   ON (`f_subgrupo_empresa`.`Id_SubGrupo` = `f_subgruposervicio`.`Id_SubgrupoServicio`)  LEFT JOIN (SELECT `Id_Ingreso` , `Cerrado`\nFROM\n    `ingreso_seguimiento`\nWHERE (`Cerrado` =0)\nGROUP BY `Id_Ingreso`)  s ON (s.Id_Ingreso=ingreso.`Id`)    WHERE (f_factura_capita.Fecha_FacturaCapita >='" + this.xmt.formatoAMD.format(this.JDCFechaInicio.getDate()) + "' AND f_factura_capita.Fecha_FacturaCapita <='" + this.xmt.formatoAMD.format(this.JDCFechaFin.getDate()) + "' AND f_liquidacion.Id_SubGrupoServicio ='" + this.xidsubgrupo[this.JCBSubGrupo.getSelectedIndex()] + "' AND ingreso.Id_EmpresaContxConv ='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "' AND f_liquidacion.Estado =0  and f_factura_capita.EstaArmada='" + this.xarmada + "' AND ingreso.Estado=0 AND f_ordenes.Estado=0) GROUP BY f_factura_capita.No_FacturaCapita ORDER BY FechaF ASC, CONCAT(g_persona.`Apellido1`, ' ', g_persona.`Apellido2`, ' ', g_persona.`Nombre1`, ' ', g_persona.`Nombre2`) ASC ";
            } else {
                this.xsql = "SELECT f_factura_capita.No_FacturaCapita, DATE_FORMAT(f_factura_capita.Fecha_FacturaCapita,'%d-%m-%Y') AS FechaF, g_usuario.`NoHistoria`, CONCAT(g_persona.`Apellido1`, ' ', g_persona.`Apellido2`, ' ', g_persona.`Nombre1`, ' ', g_persona.`Nombre2`) AS Nombre, f_liquidacion.TotalServicio, f_liquidacion.TotalPlan, f_liquidacion.TotalEps  , f_liquidacion.TotalDescuento, f_liquidacion.TotalPaciente, (f_liquidacion.CuotaModeradora + f_liquidacion.Copago)   AS VCMD,  g_persona.`Id`, ingreso.Id, IF(f_factura_capita.EstaArmada=0,FALSE, TRUE) EstaArmada, f_liquidacion.Copago, f_liquidacion.CuotaModeradora, f_liquidacion.UsuarioS, ingreso.NoAutorizacion, g_contratos.`Nbre_Contrato`  , `g_persona`.`Id_Sexo`, g_persona.`FechaNac` , devuelve_Edad_2F(g_persona.`FechaNac`,f_factura_capita.Fecha_FacturaCapita) AS FNacimiento , devuelve_Tipo_Edad_2F(g_persona.`FechaNac`,f_factura_capita.Fecha_FacturaCapita) AS TipoEdad, g_municipio.`Nbre` AS NMunicipio , g_barrio.`Nbre` AS NBarrio, g_persona.`Direccion` , g_persona.`Telefono` , `g_nivelestudio`.`Nbre` , g_estadocivil.`Nbre` AS EstadoCivil, g_ocupacion.`Nbre`, g_persona.`Id_TipoIdentificacion`, g_persona.`NoDocumento`, ingreso.SO_Cargo,g_empresa.`Nbre` AS EPS  , ingreso.`Id_TipoAtencion`, `f_subgruposervicio`.`Nbre` AS `SubGrupo`   ,  IF(s.Cerrado IS NULL,0,1) CSeguimiento,IFNULL(f_itemripsconsulta.`Id_DxPrincipal`, '') Id_DxPrincipal ,IFNULL(`g_patologia`.`Nbre`,'') AS Diagnostico,  f_factura_capita.No_FacturaCapita  as IdFactura  FROM f_factura_capita   INNER JOIN f_liquidacion  ON (f_factura_capita.Id_Liquidacion = f_liquidacion.Id)   INNER JOIN ingreso  ON (ingreso.Id = f_liquidacion.Id_Ingreso)  INNER JOIN `g_contratos`  ON (ingreso.`Id_Contrato` = g_contratos.`Id`)   INNER JOIN f_ordenes  ON (ingreso.Id = f_ordenes.Id_Ingreso) LEFT JOIN `f_itemripsconsulta` ON (f_itemripsconsulta.`Id_Ordenes`=`f_ordenes`.`Id`) LEFT JOIN `g_patologia` ON (`g_patologia`.`Id`=`f_itemripsconsulta`.`Id_DxPrincipal`) INNER JOIN `g_persona`  ON (ingreso.Id_Usuario = g_persona.`Id`) INNER JOIN `g_usuario`  ON (g_usuario.`Id_persona` = g_persona.`Id`)   INNER JOIN `g_municipio`  ON (g_municipio.`Id` = g_persona.`Id_Municipio`) INNER JOIN `g_barrio`  ON (g_barrio.`Id` = g_persona.`Id_Barrio`) INNER JOIN `g_estadocivil`  ON (g_estadocivil.`Id` = g_persona.`Id_EstadoCivil`) INNER JOIN `g_empresa`  ON (g_empresa.`Id` = g_usuario.`Id_EmpresaCont`) INNER JOIN  `g_nivelestudio` ON (`g_nivelestudio`.`Id` = `ingreso`.`Id_NivelEstudio`)  INNER JOIN  `g_ocupacion` ON (`g_ocupacion`.`Id` = `ingreso`.`Id_Ocupacion`)   INNER JOIN `f_subgrupo_empresa`   ON (`f_liquidacion`.`Id_SubGrupoServicio` = `f_subgrupo_empresa`.`Id`) INNER JOIN  `f_subgruposervicio`   ON (`f_subgrupo_empresa`.`Id_SubGrupo` = `f_subgruposervicio`.`Id_SubgrupoServicio`)  LEFT JOIN (SELECT `Id_Ingreso` , `Cerrado`\nFROM\n    `ingreso_seguimiento`\nWHERE (`Cerrado` =0)\nGROUP BY `Id_Ingreso`)  s ON (s.Id_Ingreso=ingreso.`Id`)    WHERE (f_factura_capita.Fecha_FacturaCapita >='" + this.xmt.formatoAMD.format(this.JDCFechaInicio.getDate()) + "' AND f_factura_capita.Fecha_FacturaCapita <='" + this.xmt.formatoAMD.format(this.JDCFechaFin.getDate()) + "' AND`f_subgruposervicio`.`Id_GrupoServicio` ='" + this.xidservicio[this.JCBGrupo.getSelectedIndex()][0] + "' AND ingreso.Id_EmpresaContxConv ='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "' AND f_liquidacion.Estado =0  and f_factura_capita.EstaArmada='" + this.xarmada + "' AND ingreso.Estado=0 AND f_ordenes.Estado=0) GROUP BY f_factura_capita.No_FacturaCapita ORDER BY FechaF ASC, CONCAT(g_persona.`Apellido1`, ' ', g_persona.`Apellido2`, ' ', g_persona.`Nombre1`, ' ', g_persona.`Nombre2`) ASC ";
            }
        } else if (xorden == 1) {
            if (this.JCHFiltroGrupo.isSelected()) {
                this.xsql = "SELECT f_factura_capita.No_FacturaCapita, DATE_FORMAT(f_factura_capita.Fecha_FacturaCapita,'%d-%m-%Y') AS FechaF, g_usuario.`NoHistoria`, CONCAT(g_persona.`Apellido1`, ' ', g_persona.`Apellido2`, ' ', g_persona.`Nombre1`, ' ', g_persona.`Nombre2`) AS Nombre, f_liquidacion.TotalServicio, f_liquidacion.TotalPlan, f_liquidacion.TotalEps  , f_liquidacion.TotalDescuento, f_liquidacion.TotalPaciente, (f_liquidacion.CuotaModeradora + f_liquidacion.Copago)   AS VCMD,  g_persona.`Id`, ingreso.Id, IF(f_factura_capita.EstaArmada=0,FALSE, TRUE) EstaArmada, f_liquidacion.Copago, f_liquidacion.CuotaModeradora, f_liquidacion.UsuarioS, ingreso.NoAutorizacion, g_contratos.`Nbre_Contrato`  , `g_persona`.`Id_Sexo`, g_persona.`FechaNac` , devuelve_Edad_2F(g_persona.`FechaNac`,f_factura_capita.Fecha_FacturaCapita) AS FNacimiento , devuelve_Tipo_Edad_2F(g_persona.`FechaNac`,f_factura_capita.Fecha_FacturaCapita) AS TipoEdad, g_municipio.`Nbre` AS NMunicipio , g_barrio.`Nbre` AS NBarrio, g_persona.`Direccion` , g_persona.`Telefono` , `g_nivelestudio`.`Nbre` , g_estadocivil.`Nbre` AS EstadoCivil, g_ocupacion.`Nbre`, g_persona.`Id_TipoIdentificacion`, g_persona.`NoDocumento`, ingreso.SO_Cargo,g_empresa.`Nbre` AS EPS  , ingreso.`Id_TipoAtencion`, `f_subgruposervicio`.`Nbre` AS `SubGrupo`   ,  IF(s.Cerrado IS NULL,0,1) CSeguimiento,IFNULL(f_itemripsconsulta.`Id_DxPrincipal`, '') Id_DxPrincipal ,IFNULL(`g_patologia`.`Nbre`,'') AS Diagnostico ,  f_factura_capita.No_FacturaCapita  as IdFactura  FROM f_factura_capita   INNER JOIN f_liquidacion  ON (f_factura_capita.Id_Liquidacion = f_liquidacion.Id)   INNER JOIN ingreso  ON (ingreso.Id = f_liquidacion.Id_Ingreso)  INNER JOIN `g_contratos`  ON (ingreso.`Id_Contrato` = g_contratos.`Id`)   INNER JOIN f_ordenes  ON (ingreso.Id = f_ordenes.Id_Ingreso) LEFT JOIN `f_itemripsconsulta` ON (f_itemripsconsulta.`Id_Ordenes`=`f_ordenes`.`Id`) LEFT JOIN `g_patologia` ON (`g_patologia`.`Id`=`f_itemripsconsulta`.`Id_DxPrincipal`) INNER JOIN `g_persona`  ON (ingreso.Id_Usuario = g_persona.`Id`) INNER JOIN `g_usuario`  ON (g_usuario.`Id_persona` = g_persona.`Id`)   INNER JOIN `g_municipio`  ON (g_municipio.`Id` = g_persona.`Id_Municipio`) INNER JOIN `g_barrio`  ON (g_barrio.`Id` = g_persona.`Id_Barrio`) INNER JOIN `g_estadocivil`  ON (g_estadocivil.`Id` = g_persona.`Id_EstadoCivil`) INNER JOIN `g_empresa`  ON (g_empresa.`Id` = g_usuario.`Id_EmpresaCont`) INNER JOIN  `g_nivelestudio` ON (`g_nivelestudio`.`Id` = `ingreso`.`Id_NivelEstudio`)  INNER JOIN  `g_ocupacion` ON (`g_ocupacion`.`Id` = `ingreso`.`Id_Ocupacion`)   INNER JOIN `f_subgrupo_empresa`   ON (`f_liquidacion`.`Id_SubGrupoServicio` = `f_subgrupo_empresa`.`Id`) INNER JOIN  `f_subgruposervicio`   ON (`f_subgrupo_empresa`.`Id_SubGrupo` = `f_subgruposervicio`.`Id_SubgrupoServicio`)  LEFT JOIN (SELECT `Id_Ingreso` , `Cerrado`\nFROM\n    `ingreso_seguimiento`\nWHERE (`Cerrado` =0)\nGROUP BY `Id_Ingreso`)  s ON (s.Id_Ingreso=ingreso.`Id`)    WHERE (f_factura_capita.Fecha_FacturaCapita >='" + this.xmt.formatoAMD.format(this.JDCFechaInicio.getDate()) + "' AND f_factura_capita.Fecha_FacturaCapita <='" + this.xmt.formatoAMD.format(this.JDCFechaFin.getDate()) + "' AND f_liquidacion.Id_SubGrupoServicio ='" + this.xidsubgrupo[this.JCBSubGrupo.getSelectedIndex()] + "' AND ingreso.Id_EmpresaContxConv ='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "' AND f_liquidacion.Estado =0  and f_factura_capita.EstaArmada='" + this.xarmada + "' AND ingreso.Estado=0 AND f_ordenes.Estado=0) GROUP BY f_factura_capita.No_FacturaCapita ORDER BY CONCAT(g_persona.`Apellido1`, ' ', g_persona.`Apellido2`, ' ', g_persona.`Nombre1`, ' ', g_persona.`Nombre2`) ASC ";
            } else {
                this.xsql = "SELECT f_factura_capita.No_FacturaCapita, DATE_FORMAT(f_factura_capita.Fecha_FacturaCapita,'%d-%m-%Y') AS FechaF, g_usuario.`NoHistoria`, CONCAT(g_persona.`Apellido1`, ' ', g_persona.`Apellido2`, ' ', g_persona.`Nombre1`, ' ', g_persona.`Nombre2`) AS Nombre, f_liquidacion.TotalServicio, f_liquidacion.TotalPlan, f_liquidacion.TotalEps  , f_liquidacion.TotalDescuento, f_liquidacion.TotalPaciente, (f_liquidacion.CuotaModeradora + f_liquidacion.Copago)   AS VCMD,  g_persona.`Id`, ingreso.Id, IF(f_factura_capita.EstaArmada=0,FALSE, TRUE) EstaArmada, f_liquidacion.Copago, f_liquidacion.CuotaModeradora, f_liquidacion.UsuarioS, ingreso.NoAutorizacion, g_contratos.`Nbre_Contrato`  , `g_persona`.`Id_Sexo`, g_persona.`FechaNac` , devuelve_Edad_2F(g_persona.`FechaNac`,f_factura_capita.Fecha_FacturaCapita) AS FNacimiento , devuelve_Tipo_Edad_2F(g_persona.`FechaNac`,f_factura_capita.Fecha_FacturaCapita) AS TipoEdad, g_municipio.`Nbre` AS NMunicipio , g_barrio.`Nbre` AS NBarrio, g_persona.`Direccion` , g_persona.`Telefono` , `g_nivelestudio`.`Nbre` , g_estadocivil.`Nbre` AS EstadoCivil, g_ocupacion.`Nbre`, g_persona.`Id_TipoIdentificacion`, g_persona.`NoDocumento`, ingreso.SO_Cargo,g_empresa.`Nbre` AS EPS  , ingreso.`Id_TipoAtencion`, `f_subgruposervicio`.`Nbre` AS `SubGrupo`   ,  IF(s.Cerrado IS NULL,0,1) CSeguimiento,IFNULL(f_itemripsconsulta.`Id_DxPrincipal`, '') Id_DxPrincipal ,IFNULL(`g_patologia`.`Nbre`,'') AS Diagnostico ,  f_factura_capita.No_FacturaCapita  as IdFactura  FROM f_factura_capita   INNER JOIN f_liquidacion  ON (f_factura_capita.Id_Liquidacion = f_liquidacion.Id)   INNER JOIN ingreso  ON (ingreso.Id = f_liquidacion.Id_Ingreso)  INNER JOIN `g_contratos`  ON (ingreso.`Id_Contrato` = g_contratos.`Id`)   INNER JOIN f_ordenes  ON (ingreso.Id = f_ordenes.Id_Ingreso) LEFT JOIN `f_itemripsconsulta` ON (f_itemripsconsulta.`Id_Ordenes`=`f_ordenes`.`Id`) LEFT JOIN `g_patologia` ON (`g_patologia`.`Id`=`f_itemripsconsulta`.`Id_DxPrincipal`) INNER JOIN `g_persona`  ON (ingreso.Id_Usuario = g_persona.`Id`) INNER JOIN `g_usuario`  ON (g_usuario.`Id_persona` = g_persona.`Id`)   INNER JOIN `g_municipio`  ON (g_municipio.`Id` = g_persona.`Id_Municipio`) INNER JOIN `g_barrio`  ON (g_barrio.`Id` = g_persona.`Id_Barrio`) INNER JOIN `g_estadocivil`  ON (g_estadocivil.`Id` = g_persona.`Id_EstadoCivil`) INNER JOIN `g_empresa`  ON (g_empresa.`Id` = g_usuario.`Id_EmpresaCont`) INNER JOIN  `g_nivelestudio` ON (`g_nivelestudio`.`Id` = `ingreso`.`Id_NivelEstudio`)  INNER JOIN  `g_ocupacion` ON (`g_ocupacion`.`Id` = `ingreso`.`Id_Ocupacion`)   INNER JOIN `f_subgrupo_empresa`   ON (`f_liquidacion`.`Id_SubGrupoServicio` = `f_subgrupo_empresa`.`Id`) INNER JOIN  `f_subgruposervicio`   ON (`f_subgrupo_empresa`.`Id_SubGrupo` = `f_subgruposervicio`.`Id_SubgrupoServicio`)  LEFT JOIN (SELECT `Id_Ingreso` , `Cerrado`\nFROM\n    `ingreso_seguimiento`\nWHERE (`Cerrado` =0)\nGROUP BY `Id_Ingreso`)  s ON (s.Id_Ingreso=ingreso.`Id`)    WHERE (f_factura_capita.Fecha_FacturaCapita >='" + this.xmt.formatoAMD.format(this.JDCFechaInicio.getDate()) + "' AND f_factura_capita.Fecha_FacturaCapita <='" + this.xmt.formatoAMD.format(this.JDCFechaFin.getDate()) + "' AND`f_subgruposervicio`.`Id_GrupoServicio` ='" + this.xidservicio[this.JCBGrupo.getSelectedIndex()][0] + "' AND ingreso.Id_EmpresaContxConv ='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "' AND f_liquidacion.Estado =0  and f_factura_capita.EstaArmada='" + this.xarmada + "' AND ingreso.Estado=0 AND f_ordenes.Estado=0) GROUP BY f_factura_capita.No_FacturaCapita ORDER BY CONCAT(g_persona.`Apellido1`, ' ', g_persona.`Apellido2`, ' ', g_persona.`Nombre1`, ' ', g_persona.`Nombre2`) ASC ";
            }
        } else if (xorden == 2) {
            if (this.JCHFiltroGrupo.isSelected()) {
                this.xsql = "SELECT f_factura_capita.No_FacturaCapita, DATE_FORMAT(f_factura_capita.Fecha_FacturaCapita,'%d-%m-%Y') AS FechaF, g_usuario.`NoHistoria`, CONCAT(g_persona.`Apellido1`, ' ', g_persona.`Apellido2`, ' ', g_persona.`Nombre1`, ' ', g_persona.`Nombre2`) AS Nombre, f_liquidacion.TotalServicio, f_liquidacion.TotalPlan, f_liquidacion.TotalEps  , f_liquidacion.TotalDescuento, f_liquidacion.TotalPaciente, (f_liquidacion.CuotaModeradora + f_liquidacion.Copago)   AS VCMD,  g_persona.`Id`, ingreso.Id, IF(f_factura_capita.EstaArmada=0,FALSE, TRUE) EstaArmada, f_liquidacion.Copago, f_liquidacion.CuotaModeradora, f_liquidacion.UsuarioS, ingreso.NoAutorizacion, g_contratos.`Nbre_Contrato`  , `g_persona`.`Id_Sexo`, g_persona.`FechaNac` , devuelve_Edad_2F(g_persona.`FechaNac`,f_factura_capita.Fecha_FacturaCapita) AS FNacimiento , devuelve_Tipo_Edad_2F(g_persona.`FechaNac`,f_factura_capita.Fecha_FacturaCapita) AS TipoEdad, g_municipio.`Nbre` AS NMunicipio , g_barrio.`Nbre` AS NBarrio, g_persona.`Direccion` , g_persona.`Telefono` , `g_nivelestudio`.`Nbre` , g_estadocivil.`Nbre` AS EstadoCivil, g_ocupacion.`Nbre`, g_persona.`Id_TipoIdentificacion`, g_persona.`NoDocumento`, ingreso.SO_Cargo,g_empresa.`Nbre` AS EPS  , ingreso.`Id_TipoAtencion`, `f_subgruposervicio`.`Nbre` AS `SubGrupo`   ,  IF(s.Cerrado IS NULL,0,1) CSeguimiento,IFNULL(f_itemripsconsulta.`Id_DxPrincipal`, '') Id_DxPrincipal ,IFNULL(`g_patologia`.`Nbre`,'') AS Diagnostico ,  f_factura_capita.No_FacturaCapita as IdFactura  FROM f_factura_capita   INNER JOIN f_liquidacion  ON (f_factura_capita.Id_Liquidacion = f_liquidacion.Id)   INNER JOIN ingreso  ON (ingreso.Id = f_liquidacion.Id_Ingreso)  INNER JOIN `g_contratos`  ON (ingreso.`Id_Contrato` = g_contratos.`Id`)   INNER JOIN f_ordenes  ON (ingreso.Id = f_ordenes.Id_Ingreso) LEFT JOIN `f_itemripsconsulta` ON (f_itemripsconsulta.`Id_Ordenes`=`f_ordenes`.`Id`) LEFT JOIN `g_patologia` ON (`g_patologia`.`Id`=`f_itemripsconsulta`.`Id_DxPrincipal`) INNER JOIN `g_persona`  ON (ingreso.Id_Usuario = g_persona.`Id`) INNER JOIN `g_usuario`  ON (g_usuario.`Id_persona` = g_persona.`Id`)   INNER JOIN `g_municipio`  ON (g_municipio.`Id` = g_persona.`Id_Municipio`) INNER JOIN `g_barrio`  ON (g_barrio.`Id` = g_persona.`Id_Barrio`) INNER JOIN `g_estadocivil`  ON (g_estadocivil.`Id` = g_persona.`Id_EstadoCivil`) INNER JOIN `g_empresa`  ON (g_empresa.`Id` = g_usuario.`Id_EmpresaCont`) INNER JOIN  `g_nivelestudio` ON (`g_nivelestudio`.`Id` = `ingreso`.`Id_NivelEstudio`)  INNER JOIN  `g_ocupacion` ON (`g_ocupacion`.`Id` = `ingreso`.`Id_Ocupacion`)   INNER JOIN `f_subgrupo_empresa`   ON (`f_liquidacion`.`Id_SubGrupoServicio` = `f_subgrupo_empresa`.`Id`) INNER JOIN  `f_subgruposervicio`   ON (`f_subgrupo_empresa`.`Id_SubGrupo` = `f_subgruposervicio`.`Id_SubgrupoServicio`)  LEFT JOIN (SELECT `Id_Ingreso` , `Cerrado`\nFROM\n    `ingreso_seguimiento`\nWHERE (`Cerrado` =0)\nGROUP BY `Id_Ingreso`)  s ON (s.Id_Ingreso=ingreso.`Id`)    WHERE (f_factura_capita.Fecha_FacturaCapita >='" + this.xmt.formatoAMD.format(this.JDCFechaInicio.getDate()) + "' AND f_factura_capita.Fecha_FacturaCapita <='" + this.xmt.formatoAMD.format(this.JDCFechaFin.getDate()) + "' AND f_liquidacion.Id_SubGrupoServicio ='" + this.xidsubgrupo[this.JCBSubGrupo.getSelectedIndex()] + "' AND ingreso.Id_EmpresaContxConv ='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "' AND f_liquidacion.Estado =0  and f_factura_capita.EstaArmada='" + this.xarmada + "' AND ingreso.Estado=0 AND f_ordenes.Estado=0 ) GROUP BY f_factura_capita.No_FacturaCapita ORDER BY f_liquidacion.TotalPlan ASC ";
            } else {
                this.xsql = "SELECT f_factura_capita.No_FacturaCapita, DATE_FORMAT(f_factura_capita.Fecha_FacturaCapita,'%d-%m-%Y') AS FechaF, g_usuario.`NoHistoria`, CONCAT(g_persona.`Apellido1`, ' ', g_persona.`Apellido2`, ' ', g_persona.`Nombre1`, ' ', g_persona.`Nombre2`) AS Nombre, f_liquidacion.TotalServicio, f_liquidacion.TotalPlan, f_liquidacion.TotalEps  , f_liquidacion.TotalDescuento, f_liquidacion.TotalPaciente, (f_liquidacion.CuotaModeradora + f_liquidacion.Copago)   AS VCMD,  g_persona.`Id`, ingreso.Id, IF(f_factura_capita.EstaArmada=0,FALSE, TRUE) EstaArmada, f_liquidacion.Copago, f_liquidacion.CuotaModeradora, f_liquidacion.UsuarioS, ingreso.NoAutorizacion, g_contratos.`Nbre_Contrato`  , `g_persona`.`Id_Sexo`, g_persona.`FechaNac` , devuelve_Edad_2F(g_persona.`FechaNac`,f_factura_capita.Fecha_FacturaCapita) AS FNacimiento , devuelve_Tipo_Edad_2F(g_persona.`FechaNac`,f_factura_capita.Fecha_FacturaCapita) AS TipoEdad, g_municipio.`Nbre` AS NMunicipio , g_barrio.`Nbre` AS NBarrio, g_persona.`Direccion` , g_persona.`Telefono` , `g_nivelestudio`.`Nbre` , g_estadocivil.`Nbre` AS EstadoCivil, g_ocupacion.`Nbre`, g_persona.`Id_TipoIdentificacion`, g_persona.`NoDocumento`, ingreso.SO_Cargo,g_empresa.`Nbre` AS EPS  , ingreso.`Id_TipoAtencion`, `f_subgruposervicio`.`Nbre` AS `SubGrupo`   ,  IF(s.Cerrado IS NULL,0,1) CSeguimiento,IFNULL(f_itemripsconsulta.`Id_DxPrincipal`, '') Id_DxPrincipal ,IFNULL(`g_patologia`.`Nbre`,'') AS Diagnostico ,  f_factura_capita.No_FacturaCapita as IdFactura   FROM f_factura_capita   INNER JOIN f_liquidacion  ON (f_factura_capita.Id_Liquidacion = f_liquidacion.Id)   INNER JOIN ingreso  ON (ingreso.Id = f_liquidacion.Id_Ingreso)  INNER JOIN `g_contratos`  ON (ingreso.`Id_Contrato` = g_contratos.`Id`)   INNER JOIN f_ordenes  ON (ingreso.Id = f_ordenes.Id_Ingreso) LEFT JOIN `f_itemripsconsulta` ON (f_itemripsconsulta.`Id_Ordenes`=`f_ordenes`.`Id`) LEFT JOIN `g_patologia` ON (`g_patologia`.`Id`=`f_itemripsconsulta`.`Id_DxPrincipal`) INNER JOIN `g_persona`  ON (ingreso.Id_Usuario = g_persona.`Id`) INNER JOIN `g_usuario`  ON (g_usuario.`Id_persona` = g_persona.`Id`)   INNER JOIN `g_municipio`  ON (g_municipio.`Id` = g_persona.`Id_Municipio`) INNER JOIN `g_barrio`  ON (g_barrio.`Id` = g_persona.`Id_Barrio`) INNER JOIN `g_estadocivil`  ON (g_estadocivil.`Id` = g_persona.`Id_EstadoCivil`) INNER JOIN `g_empresa`  ON (g_empresa.`Id` = g_usuario.`Id_EmpresaCont`) INNER JOIN  `g_nivelestudio` ON (`g_nivelestudio`.`Id` = `ingreso`.`Id_NivelEstudio`)  INNER JOIN  `g_ocupacion` ON (`g_ocupacion`.`Id` = `ingreso`.`Id_Ocupacion`)   INNER JOIN `f_subgrupo_empresa`   ON (`f_liquidacion`.`Id_SubGrupoServicio` = `f_subgrupo_empresa`.`Id`) INNER JOIN  `f_subgruposervicio`   ON (`f_subgrupo_empresa`.`Id_SubGrupo` = `f_subgruposervicio`.`Id_SubgrupoServicio`)  LEFT JOIN (SELECT `Id_Ingreso` , `Cerrado`\nFROM\n    `ingreso_seguimiento`\nWHERE (`Cerrado` =0)\nGROUP BY `Id_Ingreso`)  s ON (s.Id_Ingreso=ingreso.`Id`)    WHERE (f_factura_capita.Fecha_FacturaCapita >='" + this.xmt.formatoAMD.format(this.JDCFechaInicio.getDate()) + "' AND f_factura_capita.Fecha_FacturaCapita <='" + this.xmt.formatoAMD.format(this.JDCFechaFin.getDate()) + "' AND`f_subgruposervicio`.`Id_GrupoServicio` ='" + this.xidservicio[this.JCBGrupo.getSelectedIndex()][0] + "' AND ingreso.Id_EmpresaContxConv ='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "' AND f_liquidacion.Estado =0  and f_factura_capita.EstaArmada='" + this.xarmada + "' AND ingreso.Estado=0 AND f_ordenes.Estado=0 ) GROUP BY f_factura_capita.No_FacturaCapita ORDER BY f_liquidacion.TotalPlan ASC ";
            }
        } else if (xorden == 3) {
            if (this.JCHFiltroGrupo.isSelected()) {
                this.xsql = "SELECT f_factura_capita.No_FacturaCapita, DATE_FORMAT(f_factura_capita.Fecha_FacturaCapita,'%d-%m-%Y') AS FechaF, g_usuario.`NoHistoria`, CONCAT(g_persona.`Apellido1`, ' ', g_persona.`Apellido2`, ' ', g_persona.`Nombre1`, ' ', g_persona.`Nombre2`) AS Nombre, f_liquidacion.TotalServicio, f_liquidacion.TotalPlan, f_liquidacion.TotalEps  , f_liquidacion.TotalDescuento, f_liquidacion.TotalPaciente, (f_liquidacion.CuotaModeradora + f_liquidacion.Copago)   AS VCMD,  g_persona.`Id`, ingreso.Id, IF(f_factura_capita.EstaArmada=0,FALSE, TRUE) EstaArmada, f_liquidacion.Copago, f_liquidacion.CuotaModeradora, f_liquidacion.UsuarioS, ingreso.NoAutorizacion, g_contratos.`Nbre_Contrato`  , `g_persona`.`Id_Sexo`, g_persona.`FechaNac` , devuelve_Edad_2F(g_persona.`FechaNac`,f_factura_capita.Fecha_FacturaCapita) AS FNacimiento , devuelve_Tipo_Edad_2F(g_persona.`FechaNac`,f_factura_capita.Fecha_FacturaCapita) AS TipoEdad, g_municipio.`Nbre` AS NMunicipio , g_barrio.`Nbre` AS NBarrio, g_persona.`Direccion` , g_persona.`Telefono` , `g_nivelestudio`.`Nbre` , g_estadocivil.`Nbre` AS EstadoCivil, g_ocupacion.`Nbre`, g_persona.`Id_TipoIdentificacion`, g_persona.`NoDocumento`, ingreso.SO_Cargo,g_empresa.`Nbre` AS EPS  , ingreso.`Id_TipoAtencion`, `f_subgruposervicio`.`Nbre` AS `SubGrupo`   ,  IF(s.Cerrado IS NULL,0,1) CSeguimiento,IFNULL(f_itemripsconsulta.`Id_DxPrincipal`, '') Id_DxPrincipal ,IFNULL(`g_patologia`.`Nbre`,'') AS Diagnostico ,  f_factura_capita.No_FacturaCapita as IdFactura  FROM f_factura_capita   INNER JOIN f_liquidacion  ON (f_factura_capita.Id_Liquidacion = f_liquidacion.Id)   INNER JOIN ingreso  ON (ingreso.Id = f_liquidacion.Id_Ingreso)  INNER JOIN `g_contratos`  ON (ingreso.`Id_Contrato` = g_contratos.`Id`)   INNER JOIN f_ordenes  ON (ingreso.Id = f_ordenes.Id_Ingreso) LEFT JOIN `f_itemripsconsulta` ON (f_itemripsconsulta.`Id_Ordenes`=`f_ordenes`.`Id`) LEFT JOIN `g_patologia` ON (`g_patologia`.`Id`=`f_itemripsconsulta`.`Id_DxPrincipal`) INNER JOIN `g_persona`  ON (ingreso.Id_Usuario = g_persona.`Id`) INNER JOIN `g_usuario`  ON (g_usuario.`Id_persona` = g_persona.`Id`)   INNER JOIN `g_municipio`  ON (g_municipio.`Id` = g_persona.`Id_Municipio`) INNER JOIN `g_barrio`  ON (g_barrio.`Id` = g_persona.`Id_Barrio`) INNER JOIN `g_estadocivil`  ON (g_estadocivil.`Id` = g_persona.`Id_EstadoCivil`) INNER JOIN `g_empresa`  ON (g_empresa.`Id` = g_usuario.`Id_EmpresaCont`) INNER JOIN  `g_nivelestudio` ON (`g_nivelestudio`.`Id` = `ingreso`.`Id_NivelEstudio`)  INNER JOIN  `g_ocupacion` ON (`g_ocupacion`.`Id` = `ingreso`.`Id_Ocupacion`)   INNER JOIN `f_subgrupo_empresa`   ON (`f_liquidacion`.`Id_SubGrupoServicio` = `f_subgrupo_empresa`.`Id`) INNER JOIN  `f_subgruposervicio`   ON (`f_subgrupo_empresa`.`Id_SubGrupo` = `f_subgruposervicio`.`Id_SubgrupoServicio`)  LEFT JOIN (SELECT `Id_Ingreso` , `Cerrado`\nFROM\n    `ingreso_seguimiento`\nWHERE (`Cerrado` =0)\nGROUP BY `Id_Ingreso`)  s ON (s.Id_Ingreso=ingreso.`Id`)    WHERE (f_factura_capita.Fecha_FacturaCapita >='" + this.xmt.formatoAMD.format(this.JDCFechaInicio.getDate()) + "' AND f_factura_capita.Fecha_FacturaCapita <='" + this.xmt.formatoAMD.format(this.JDCFechaFin.getDate()) + "' AND f_liquidacion.Id_SubGrupoServicio ='" + this.xidsubgrupo[this.JCBSubGrupo.getSelectedIndex()] + "' AND ingreso.Id_EmpresaContxConv ='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "' AND f_liquidacion.Estado =0  and f_factura_capita.EstaArmada='" + this.xarmada + "' AND ingreso.Estado=0 AND f_ordenes.Estado=0 ) GROUP BY f_factura_capita.No_FacturaCapita ORDER BY f_factura_capita.No_FacturaCapita ASC ";
            } else {
                this.xsql = "SELECT f_factura_capita.No_FacturaCapita, DATE_FORMAT(f_factura_capita.Fecha_FacturaCapita,'%d-%m-%Y') AS FechaF, g_usuario.`NoHistoria`, CONCAT(g_persona.`Apellido1`, ' ', g_persona.`Apellido2`, ' ', g_persona.`Nombre1`, ' ', g_persona.`Nombre2`) AS Nombre, f_liquidacion.TotalServicio, f_liquidacion.TotalPlan, f_liquidacion.TotalEps  , f_liquidacion.TotalDescuento, f_liquidacion.TotalPaciente, (f_liquidacion.CuotaModeradora + f_liquidacion.Copago)   AS VCMD,  g_persona.`Id`, ingreso.Id, IF(f_factura_capita.EstaArmada=0,FALSE, TRUE) EstaArmada, f_liquidacion.Copago, f_liquidacion.CuotaModeradora, f_liquidacion.UsuarioS, ingreso.NoAutorizacion, g_contratos.`Nbre_Contrato`  , `g_persona`.`Id_Sexo`, g_persona.`FechaNac` , devuelve_Edad_2F(g_persona.`FechaNac`,f_factura_capita.Fecha_FacturaCapita) AS FNacimiento , devuelve_Tipo_Edad_2F(g_persona.`FechaNac`,f_factura_capita.Fecha_FacturaCapita) AS TipoEdad, g_municipio.`Nbre` AS NMunicipio , g_barrio.`Nbre` AS NBarrio, g_persona.`Direccion` , g_persona.`Telefono` , `g_nivelestudio`.`Nbre` , g_estadocivil.`Nbre` AS EstadoCivil, g_ocupacion.`Nbre`, g_persona.`Id_TipoIdentificacion`, g_persona.`NoDocumento`, ingreso.SO_Cargo,g_empresa.`Nbre` AS EPS  , ingreso.`Id_TipoAtencion`, `f_subgruposervicio`.`Nbre` AS `SubGrupo`   ,  IF(s.Cerrado IS NULL,0,1) CSeguimiento,IFNULL(f_itemripsconsulta.`Id_DxPrincipal`, '') Id_DxPrincipal ,IFNULL(`g_patologia`.`Nbre`,'') AS Diagnostico , f_factura_capita.No_FacturaCapita  as IdFactura FROM f_factura_capita   INNER JOIN f_liquidacion  ON (f_factura_capita.Id_Liquidacion = f_liquidacion.Id)   INNER JOIN ingreso  ON (ingreso.Id = f_liquidacion.Id_Ingreso)  INNER JOIN `g_contratos`  ON (ingreso.`Id_Contrato` = g_contratos.`Id`)   INNER JOIN f_ordenes  ON (ingreso.Id = f_ordenes.Id_Ingreso) LEFT JOIN `f_itemripsconsulta` ON (f_itemripsconsulta.`Id_Ordenes`=`f_ordenes`.`Id`) LEFT JOIN `g_patologia` ON (`g_patologia`.`Id`=`f_itemripsconsulta`.`Id_DxPrincipal`) INNER JOIN `g_persona`  ON (ingreso.Id_Usuario = g_persona.`Id`) INNER JOIN `g_usuario`  ON (g_usuario.`Id_persona` = g_persona.`Id`)   INNER JOIN `g_municipio`  ON (g_municipio.`Id` = g_persona.`Id_Municipio`) INNER JOIN `g_barrio`  ON (g_barrio.`Id` = g_persona.`Id_Barrio`) INNER JOIN `g_estadocivil`  ON (g_estadocivil.`Id` = g_persona.`Id_EstadoCivil`) INNER JOIN `g_empresa`  ON (g_empresa.`Id` = g_usuario.`Id_EmpresaCont`) INNER JOIN  `g_nivelestudio` ON (`g_nivelestudio`.`Id` = `ingreso`.`Id_NivelEstudio`)  INNER JOIN  `g_ocupacion` ON (`g_ocupacion`.`Id` = `ingreso`.`Id_Ocupacion`)   INNER JOIN `f_subgrupo_empresa`   ON (`f_liquidacion`.`Id_SubGrupoServicio` = `f_subgrupo_empresa`.`Id`) INNER JOIN  `f_subgruposervicio`   ON (`f_subgrupo_empresa`.`Id_SubGrupo` = `f_subgruposervicio`.`Id_SubgrupoServicio`)  LEFT JOIN (SELECT `Id_Ingreso` , `Cerrado`\nFROM\n    `ingreso_seguimiento`\nWHERE (`Cerrado` =0)\nGROUP BY `Id_Ingreso`)  s ON (s.Id_Ingreso=ingreso.`Id`)    WHERE (f_factura_capita.Fecha_FacturaCapita >='" + this.xmt.formatoAMD.format(this.JDCFechaInicio.getDate()) + "' AND f_factura_capita.Fecha_FacturaCapita <='" + this.xmt.formatoAMD.format(this.JDCFechaFin.getDate()) + "' AND`f_subgruposervicio`.`Id_GrupoServicio` ='" + this.xidservicio[this.JCBGrupo.getSelectedIndex()][0] + "' AND ingreso.Id_EmpresaContxConv ='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "' AND f_liquidacion.Estado =0  and f_factura_capita.EstaArmada='" + this.xarmada + "' AND ingreso.Estado=0 AND f_ordenes.Estado=0 ) GROUP BY f_factura_capita.No_FacturaCapita ORDER BY f_factura_capita.No_FacturaCapita ASC ";
            }
        }
        System.out.println(this.xsql);
        ResultSet xrs = this.xct.traerRs(this.xsql);
        try {
            if (xrs.next()) {
                xrs.beforeFirst();
                int x = 0;
                double xvalors = 0.0d;
                double xvalorp = 0.0d;
                double xvalore = 0.0d;
                double xvalord = 0.0d;
                double xvalorcp = 0.0d;
                double xvalorcm = 0.0d;
                this.xmt.mEstablecerTextEditor(this.JTBResultado, 3);
                this.xmt.mEstablecerTextEditor(this.JTBResultado, 32);
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(xrs.getString(1), x, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), x, 1);
                    this.xmodelo.setValueAt(xrs.getString(3), x, 2);
                    this.xmodelo.setValueAt(xrs.getString(4), x, 3);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(13)), x, 4);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(5)), x, 5);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(6)), x, 6);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(7)), x, 7);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(8)), x, 8);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(9)), x, 9);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(10)), x, 10);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(11)), x, 11);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(12)), x, 12);
                    this.xmodelo.setValueAt(xrs.getString(16), x, 13);
                    this.xmodelo.setValueAt(xrs.getString(17), x, 14);
                    this.xmodelo.setValueAt(xrs.getString(18), x, 15);
                    this.xmodelo.setValueAt(xrs.getString(19), x, 16);
                    this.xmodelo.setValueAt(xrs.getString(20), x, 17);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(21)), x, 18);
                    this.xmodelo.setValueAt(xrs.getString(22), x, 19);
                    this.xmodelo.setValueAt(xrs.getString(23), x, 20);
                    this.xmodelo.setValueAt(xrs.getString(24), x, 21);
                    this.xmodelo.setValueAt(xrs.getString(25), x, 22);
                    this.xmodelo.setValueAt(xrs.getString(26), x, 23);
                    this.xmodelo.setValueAt(xrs.getString(27), x, 24);
                    this.xmodelo.setValueAt(xrs.getString(28), x, 25);
                    this.xmodelo.setValueAt(xrs.getString(29), x, 26);
                    this.xmodelo.setValueAt(xrs.getString(30), x, 27);
                    this.xmodelo.setValueAt(xrs.getString(31), x, 28);
                    this.xmodelo.setValueAt(xrs.getString(32), x, 29);
                    this.xmodelo.setValueAt(xrs.getString(33), x, 30);
                    this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt("Id_TipoAtencion")), x, 31);
                    this.xmodelo.setValueAt(xrs.getString("SubGrupo"), x, 32);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean("CSeguimiento")), x, 33);
                    this.xmodelo.setValueAt(xrs.getString("Id_DxPrincipal"), x, 34);
                    this.xmodelo.setValueAt(xrs.getString("Diagnostico"), x, 35);
                    this.xmodelo.setValueAt(xrs.getString("IdFactura"), x, 36);
                    this.JTBResultado.setDefaultRenderer(Object.class, new MiRender());
                    xvalors += xrs.getDouble(5);
                    xvalorp += xrs.getDouble(9);
                    xvalore += xrs.getDouble(7);
                    xvalord += xrs.getDouble(8);
                    xvalorcp += xrs.getDouble(14);
                    xvalorcm += xrs.getDouble(15);
                    x++;
                }
                this.JTFFTotalServicio.setValue(Double.valueOf(xvalors));
                this.JTFFTotalUsuario.setValue(Double.valueOf(xvalorp));
                this.JTFFTotalCModeradora.setValue(Double.valueOf(xvalorcm));
                this.JTFFTotalCopago.setValue(Double.valueOf(xvalorcp));
                this.JTFFTotalDescuento.setValue(Double.valueOf(xvalord));
                this.JTFFTotalEps.setValue(Double.valueOf(xvalore));
                this.JTFFNItems.setValue(Integer.valueOf(x));
            } else {
                this.JTFFTotalServicio.setValue(new Double(0.0d));
                this.JTFFTotalUsuario.setValue(new Double(0.0d));
                this.JTFFTotalCModeradora.setValue(new Double(0.0d));
                this.JTFFTotalCopago.setValue(new Double(0.0d));
                this.JTFFTotalDescuento.setValue(new Double(0.0d));
                this.JTFFTotalEps.setValue(new Double(0.0d));
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFArmado.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:Armado/JIFArmado$MiRender.class */
    public static class MiRender extends DefaultTableCellRenderer {
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            Boolean nvalidacion = Boolean.valueOf(table.getValueAt(row, 33).toString());
            if (nvalidacion.booleanValue()) {
                cell.setBackground(Color.GREEN);
                cell.setForeground(Color.BLACK);
            } else if (table.getValueAt(row, 34).toString().equals("")) {
                cell.setBackground(Color.white);
                cell.setForeground(Color.BLACK);
            } else {
                cell.setBackground(Color.PINK);
                cell.setForeground(Color.BLACK);
            }
            return cell;
        }
    }

    public void mGrabar() {
        String sqlConvenio;
        if (this.xarmada == 0) {
            if (this.JTBResultado.getRowCount() != -1) {
                if (this.xmt.mVerificarDatosTablaTrue(this.JTBResultado, 4)) {
                    for (int i = 0; i < this.JTBResultado.getRowCount(); i++) {
                        if (Boolean.valueOf(this.JTBResultado.getValueAt(i, 4).toString()).booleanValue()) {
                            System.out.println("FVE" + this.JTBResultado.getValueAt(i, 0));
                            String idConv = "";
                            ConsultasMySQL xct1 = new ConsultasMySQL();
                            if (Principal.informacionIps.getNombreIps().equals("BIEN ESTAR SALUD BS S.A.S.") && !this.JCBEmpresa.getSelectedItem().equals("Particular")) {
                                sqlConvenio = "SELECT\n    `f_empresacontxconvenio`.`Id`\nFROM\n    `baseserver`.`f_factura_capita`\n    INNER JOIN `baseserver`.`f_liquidacion` \n        ON (`f_factura_capita`.`Id_Liquidacion` = `f_liquidacion`.`Id`)\n    INNER JOIN`baseserver`.`ingreso`\n    ON(`f_liquidacion`.`Id_Ingreso`=`ingreso`.`Id`)\n    INNER JOIN `baseserver`.`f_empresacontxconvenio` \n        ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)\nWHERE (`f_factura_capita`.`No_FacturaCapita`='" + this.JTBResultado.getValueAt(i, 0) + "');";
                            } else {
                                sqlConvenio = "SELECT `f_empresacontxconvenio`.`Id` \nFROM `f_empresacontxconvenio` \nINNER JOIN `f_liquidacion` ON (`f_empresacontxconvenio`.`Id`=`f_liquidacion`.`IdEmpresaContxConv`)\nINNER JOIN `f_factura_evento` ON (`f_factura_evento`.`Id_Liquidacion`=`f_liquidacion`.`Id`)\nWHERE `f_factura_evento`.`No_FacturaEvento_M` = (SELECT REPLACE ('" + this.JTBResultado.getValueAt(i, 0) + "', 'FVE',''))";
                            }
                            System.out.println("sqlConvenio" + sqlConvenio);
                            ResultSet rs = xct1.traerRs(sqlConvenio);
                            try {
                                if (rs.next()) {
                                    rs.beforeFirst();
                                    while (rs.next()) {
                                        idConv = rs.getString("Id");
                                    }
                                }
                                rs.close();
                                this.xct.cerrarConexionBd();
                            } catch (SQLException e) {
                                System.out.println(">>>error<<<");
                            }
                            xct1.cerrarConexionBd();
                            System.out.println("convenio id -> " + idConv);
                            if (this.xidempresa[this.JCBEmpresa.getSelectedIndex()][1].equals("2")) {
                                if (idConv.equals("1") && Principal.informacionIps.getNombreIps().equals("BIEN ESTAR SALUD BS S.A.S.")) {
                                    this.xsql = "UPDATE f_factura_evento fe\nINNER JOIN cc_resolucion_dian rd  ON (rd.`Id`=fe.`idResolucionDian`)\nSET fe.EstaArmada=2\nWHERE (IF(rd.trasmision = 0,IF(rd.Prefijo = '',fe.No_FacturaEvento,CONCAT(rd.Prefijo,fe.No_FacturaEvento)),\nIF(rd.Prefijo = '',fe.No_FacturaEvento_M,CONCAT(rd.Prefijo,fe.No_FacturaEvento_M))))='" + this.JTBResultado.getValueAt(i, 0) + "'";
                                } else {
                                    this.xsql = "UPDATE f_factura_evento fe\nINNER JOIN cc_resolucion_dian rd  ON (rd.`Id`=fe.`idResolucionDian`)\nSET fe.EstaArmada=1\nWHERE (IF(rd.trasmision = 0,IF(rd.Prefijo = '',fe.No_FacturaEvento,CONCAT(rd.Prefijo,fe.No_FacturaEvento)),\nIF(rd.Prefijo = '',fe.No_FacturaEvento_M,CONCAT(rd.Prefijo,fe.No_FacturaEvento_M))))='" + this.JTBResultado.getValueAt(i, 0) + "'";
                                }
                            } else if (idConv.equals("1") && Principal.informacionIps.getNombreIps().equals("BIEN ESTAR SALUD BS S.A.S.")) {
                                this.xsql = "Update f_factura_capita set EstaArmada=2 where No_FacturaCapita='" + this.JTBResultado.getValueAt(i, 0) + "'";
                            } else {
                                this.xsql = "Update f_factura_capita set EstaArmada=1 where No_FacturaCapita='" + this.JTBResultado.getValueAt(i, 0) + "'";
                            }
                            System.out.println("update armado --> " + this.xsql);
                            this.xct.ejecutarSQL(this.xsql);
                            this.xct.cerrarConexionBd();
                        }
                    }
                    mCargarDatosFactura(0);
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "No existe registro seleccionado para grabar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "No existe registro para grabar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
    }

    public void mAnular() {
        if (this.xarmada == 1) {
            for (int i = 0; i < this.JTBResultado.getRowCount(); i++) {
                if (this.JTBResultado.getValueAt(i, 4).toString().equals("false")) {
                    if (this.xidempresa[this.JCBEmpresa.getSelectedIndex()][1].equals("2")) {
                        if (Principal.informacionIps.getNombreIps().equals("CLINICA OFTALMOLOGICA DAJUD SAS") || Principal.informacionIps.getNombreIps().equals("COD-OPTICA UT") || Principal.informacionIps.getNombreIps().equals("JAIME CESAR DAJUD FERNANDEZ")) {
                            this.xsql = "Update f_factura_evento set EstaArmada=0 where  f_factura_evento.No_Facturaevento ='" + this.JTBResultado.getValueAt(i, 36) + "'";
                        } else {
                            this.xsql = "Update f_factura_evento set EstaArmada=0 where f_factura_evento.No_Facturaevento  ='" + this.JTBResultado.getValueAt(i, 36) + "'";
                        }
                    } else {
                        this.xsql = "Update f_factura_capita set EstaArmada=0 where No_FacturaCapita='" + this.JTBResultado.getValueAt(i, 0) + "'";
                    }
                    this.xct.ejecutarSQL(this.xsql);
                    this.xct.cerrarConexionBd();
                }
            }
            mCargarDatosFactura(0);
        }
    }

    private void mExportar() {
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            try {
                WritableWorkbook workbook = Workbook.createWorkbook(new File(this.JTFRuta.getText()));
                WritableSheet sheet = workbook.createSheet("plantilla", 0);
                for (int x = 0; x < this.JTBResultado.getColumnCount(); x++) {
                    sheet.addCell(new Label(x, 0, this.JTBResultado.getColumnName(x)));
                }
                for (int y = 0; y < this.JTBResultado.getRowCount(); y++) {
                    sheet.addCell(new Number(0, y + 1, Long.valueOf(this.xmodelo.getValueAt(y, 0).toString()).longValue()));
                    sheet.addCell(new Label(1, y + 1, this.xmodelo.getValueAt(y, 1).toString()));
                    sheet.addCell(new Label(2, y + 1, this.xmodelo.getValueAt(y, 2).toString()));
                    sheet.addCell(new Label(3, y + 1, this.xmodelo.getValueAt(y, 3).toString()));
                    sheet.addCell(new Number(4, y + 1, Double.valueOf(this.xmodelo.getValueAt(y, 4).toString()).doubleValue()));
                    sheet.addCell(new Number(5, y + 1, Double.valueOf(this.xmodelo.getValueAt(y, 5).toString()).doubleValue()));
                    sheet.addCell(new Number(6, y + 1, Double.valueOf(this.xmodelo.getValueAt(y, 6).toString()).doubleValue()));
                    sheet.addCell(new Number(7, y + 1, Double.valueOf(this.xmodelo.getValueAt(y, 7).toString()).doubleValue()));
                    sheet.addCell(new Number(8, y + 1, Double.valueOf(this.xmodelo.getValueAt(y, 8).toString()).doubleValue()));
                    sheet.addCell(new Number(9, y + 1, Double.valueOf(this.xmodelo.getValueAt(y, 9).toString()).doubleValue()));
                    sheet.addCell(new Label(10, y + 1, this.xmodelo.getValueAt(y, 10).toString()));
                    sheet.addCell(new Label(11, y + 1, this.xmodelo.getValueAt(y, 11).toString()));
                    sheet.addCell(new Label(12, y + 1, this.xmodelo.getValueAt(y, 12).toString()));
                    sheet.addCell(new Label(13, y + 1, this.xmodelo.getValueAt(y, 13).toString()));
                    sheet.addCell(new Label(14, y + 1, this.xmodelo.getValueAt(y, 14).toString()));
                    sheet.addCell(new Label(15, y + 1, this.xmodelo.getValueAt(y, 15).toString()));
                    sheet.addCell(new Label(16, y + 1, this.xmodelo.getValueAt(y, 16).toString()));
                    sheet.addCell(new Label(17, y + 1, this.xmodelo.getValueAt(y, 17).toString()));
                    sheet.addCell(new Number(18, y + 1, Double.valueOf(this.xmodelo.getValueAt(y, 18).toString()).doubleValue()));
                    sheet.addCell(new Label(19, y + 1, this.xmodelo.getValueAt(y, 19).toString()));
                    sheet.addCell(new Label(20, y + 1, this.xmodelo.getValueAt(y, 20).toString()));
                    sheet.addCell(new Label(21, y + 1, this.xmodelo.getValueAt(y, 21).toString()));
                    sheet.addCell(new Label(22, y + 1, this.xmodelo.getValueAt(y, 22).toString()));
                    sheet.addCell(new Label(23, y + 1, this.xmodelo.getValueAt(y, 23).toString()));
                    sheet.addCell(new Label(24, y + 1, this.xmodelo.getValueAt(y, 24).toString()));
                    sheet.addCell(new Label(25, y + 1, this.xmodelo.getValueAt(y, 25).toString()));
                    sheet.addCell(new Label(26, y + 1, this.xmodelo.getValueAt(y, 26).toString()));
                    sheet.addCell(new Label(27, y + 1, this.xmodelo.getValueAt(y, 27).toString()));
                    sheet.addCell(new Label(28, y + 1, this.xmodelo.getValueAt(y, 28).toString()));
                    sheet.addCell(new Label(29, y + 1, this.xmodelo.getValueAt(y, 29).toString()));
                    sheet.addCell(new Label(30, y + 1, this.xmodelo.getValueAt(y, 30).toString()));
                }
                workbook.write();
                workbook.close();
            } catch (IOException ex) {
                Logger.getLogger(JIFArmado.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            } catch (WriteException e) {
                Logger.getLogger(JIFArmado.class.getName()).log(Level.SEVERE, (String) null, e);
            }
        }
    }

    public void mCrearArchivos() {
        String adjunto;
        File f1;
        String x = this.xmt.formatoDMA.format(this.JDCFechaInicio.getDate());
        File directorio = new File(this.JTFRuta.getText() + "/" + x.replaceAll("/", "-"));
        if (directorio.mkdir()) {
            for (int i = 0; i < this.JTBResultado.getRowCount(); i++) {
                if (this.JTBResultado.getValueAt(i, 4).toString().equals("true")) {
                    String narchivo = Principal.xclasegc.imprimir_FacturayOrden1(0, this.xmodelo.getValueAt(i, 0).toString(), this.xmodelo.getValueAt(i, 12).toString(), Principal.usuarioSistemaDTO.getLogin(), Integer.valueOf(this.xidempresa[this.JCBEmpresa.getSelectedIndex()][1]).intValue(), 2, this.xidempresa[this.JCBEmpresa.getSelectedIndex()][3], 1);
                    new File(narchivo + ".pdf");
                    if (Principal.informacionIps.getIdentificacion().equals("900549914")) {
                        adjunto = this.xmt.getRutaRep() + this.xmodelo.getValueAt(i, 0).toString() + "-" + this.xmt.formatoMoneda1.format(Double.valueOf(this.xmodelo.getValueAt(i, 7).toString())) + ".pdf";
                    } else {
                        adjunto = this.xmt.getRutaRep() + this.xmodelo.getValueAt(i, 0).toString() + "_" + this.xmodelo.getValueAt(i, 1).toString() + "_" + this.xmodelo.getValueAt(i, 2).toString() + "_" + this.xmodelo.getValueAt(i, 3).toString() + ".pdf";
                    }
                    System.out.println("Datos :" + adjunto);
                    if (narchivo.substring(narchivo.length() - 4, narchivo.length()).equals(".pdf")) {
                        f1 = new File(narchivo);
                    } else {
                        f1 = new File(narchivo + ".pdf");
                    }
                    if (!Principal.informacionIps.getUrlRecursosAnkara().isEmpty() && Principal.informacionIps.getUrlRecursosAnkara() != null) {
                        if (narchivo.contains(Principal.informacionIps.getUrlRecursosAnkara())) {
                            try {
                                Files.copy(Paths.get(f1.getAbsolutePath(), new String[0]), new File(directorio, adjunto.replace(this.xmt.getRutaRep(), "")).toPath(), StandardCopyOption.REPLACE_EXISTING);
                            } catch (IOException ex) {
                                Logger.getLogger(JIFArmado.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                            }
                        } else {
                            File f2 = new File(adjunto);
                            f1.renameTo(f2);
                            f2.renameTo(new File(directorio, f2.getName()));
                        }
                    } else {
                        File f22 = new File(adjunto);
                        f1.renameTo(f22);
                        f22.renameTo(new File(directorio, f22.getName()));
                    }
                }
            }
            return;
        }
        this.xWorkerSQL.cancel(true);
        JOptionPane.showInternalMessageDialog(this, "El directorio : " + directorio.getPath() + ";\nya se encuentra creado, favor eliminar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }
}
