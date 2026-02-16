package Presupuesto;

import Acceso.Principal;
import Contabilidad.JIFDocContable;
import Historia.JDPatologia;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
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
import java.beans.PropertyVetoException;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
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

/* JADX INFO: loaded from: GenomaP.jar:Presupuesto/JIFBuscarDocPresup.class */
public class JIFBuscarDocPresup extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private DefaultTableModel xmodelo1;
    private DefaultTableModel xmodelop;
    private String[] xidempresa;
    private String[] xIdRubros;
    private String[][] xidtipodocppto;
    private Object[] xdato;
    private JIFDocContable xjidocc;
    private JButton JBBuscaTercero;
    private ButtonGroup JBGFiltro;
    private ButtonGroup JBR_Estado;
    private JButton JBTExportar;
    private JComboBox JCBTipoC;
    private JComboBox JCB_NRubro;
    private JDateChooser JDFFechaF;
    private JDateChooser JDFFechaI;
    private JPanel JPFiltros;
    private JPanel JPIFitroBusqueda;
    private JPanel JPI_Estado;
    private JPanel JPI_FPeriodos;
    private JRadioButton JRBFechas;
    private JRadioButton JRBPeriodo;
    private JRadioButton JRBRubro;
    private JRadioButton JRBTDocumento;
    private JRadioButton JRBTercero;
    private JRadioButton JRBTodos;
    private JRadioButton JRB_EActivos;
    private JRadioButton JRB_EAnulados;
    private JRadioButton JRB_ETodos;
    private JScrollPane JSPDGasto;
    private JScrollPane JSPDIngreso;
    private JScrollPane JSP_FPeriodo;
    private JTable JTB_FPeriodo;
    private JTable JTDGasto;
    public JTable JTDIngreso;
    private JTextField JTFIdRubro;
    private JTextField JTFNDocumento;
    public JTextField JTFNit;
    private JTextField JTFRuta;
    public JTextField JTFTercero;
    private JTabbedPane JTP_DBusqueda;
    private JTabbedPane JTP_Datos;
    private Metodos xmt = new Metodos();
    private ConsultasMySQL xconsultas = new ConsultasMySQL();
    private String xEstado = "=1";
    private int xtipof = 0;
    private int xOrden = 0;
    private String xFiltro1 = "";
    private String xFiltro2 = "";
    private String xFiltro3 = "";
    private String xFiltro4 = "";
    private String xFiltro5 = "";
    private boolean xlleno = false;
    private String[] xCondicion = new String[5];

    public JIFBuscarDocPresup() {
        this.xjidocc = null;
        initComponents();
        this.xjidocc = this.xjidocc;
        mIniciarComponentes();
    }

    /* JADX WARN: Type inference failed for: r3v11, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v114, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGFiltro = new ButtonGroup();
        this.JBR_Estado = new ButtonGroup();
        this.JTP_Datos = new JTabbedPane();
        this.JSPDIngreso = new JScrollPane();
        this.JTDIngreso = new JTable();
        this.JSPDGasto = new JScrollPane();
        this.JTDGasto = new JTable();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        this.JTFNDocumento = new JTextField();
        this.JPI_Estado = new JPanel();
        this.JRB_ETodos = new JRadioButton();
        this.JRB_EActivos = new JRadioButton();
        this.JRB_EAnulados = new JRadioButton();
        this.JTP_DBusqueda = new JTabbedPane();
        this.JPIFitroBusqueda = new JPanel();
        this.JDFFechaF = new JDateChooser();
        this.JCBTipoC = new JComboBox();
        this.JTFTercero = new JTextField();
        this.JTFIdRubro = new JTextField();
        this.JTFNit = new JTextField();
        this.JDFFechaI = new JDateChooser();
        this.JBBuscaTercero = new JButton();
        this.JPFiltros = new JPanel();
        this.JRBTodos = new JRadioButton();
        this.JRBTDocumento = new JRadioButton();
        this.JRBFechas = new JRadioButton();
        this.JRBPeriodo = new JRadioButton();
        this.JRBTercero = new JRadioButton();
        this.JRBRubro = new JRadioButton();
        this.JCB_NRubro = new JComboBox();
        this.JPI_FPeriodos = new JPanel();
        this.JSP_FPeriodo = new JScrollPane();
        this.JTB_FPeriodo = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("BÚSQUEDA DE DOCUMENTOS PRESUPUESTALES");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xBuscarDocumPpto");
        this.JTP_Datos.setForeground(Color.red);
        this.JTP_Datos.setFont(new Font("Arial", 1, 14));
        this.JSPDIngreso.setBorder((Border) null);
        this.JTDIngreso.setBorder(BorderFactory.createBevelBorder(0));
        this.JTDIngreso.setFont(new Font("Arial", 1, 12));
        this.JTDIngreso.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDIngreso.setEditingColumn(2);
        this.JTDIngreso.setEditingRow(1);
        this.JTDIngreso.setRowHeight(20);
        this.JTDIngreso.setSelectionBackground(new Color(255, 255, 255));
        this.JTDIngreso.setSelectionForeground(Color.red);
        this.JTDIngreso.setSelectionMode(0);
        this.JTDIngreso.addMouseListener(new MouseAdapter() { // from class: Presupuesto.JIFBuscarDocPresup.1
            public void mouseClicked(MouseEvent evt) {
                JIFBuscarDocPresup.this.JTDIngresoMouseClicked(evt);
            }
        });
        this.JSPDIngreso.setViewportView(this.JTDIngreso);
        this.JTP_Datos.addTab("INGRESOS", this.JSPDIngreso);
        this.JTDGasto.setFont(new Font("Arial", 1, 12));
        this.JTDGasto.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDGasto.setSelectionBackground(new Color(255, 255, 255));
        this.JTDGasto.setSelectionForeground(Color.red);
        this.JTDGasto.addMouseListener(new MouseAdapter() { // from class: Presupuesto.JIFBuscarDocPresup.2
            public void mouseClicked(MouseEvent evt) {
                JIFBuscarDocPresup.this.JTDGastoMouseClicked(evt);
            }
        });
        this.JSPDGasto.setViewportView(this.JTDGasto);
        this.JTP_Datos.addTab("GASTOS", this.JSPDGasto);
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: Presupuesto.JIFBuscarDocPresup.3
            public void mouseClicked(MouseEvent evt) {
                JIFBuscarDocPresup.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setForeground(Color.red);
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: Presupuesto.JIFBuscarDocPresup.4
            public void actionPerformed(ActionEvent evt) {
                JIFBuscarDocPresup.this.JBTExportarActionPerformed(evt);
            }
        });
        this.JTFNDocumento.setFont(new Font("Arial", 1, 12));
        this.JTFNDocumento.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Documento", 2, 0, new Font("Arial", 1, 12), Color.red));
        this.JTFNDocumento.addKeyListener(new KeyAdapter() { // from class: Presupuesto.JIFBuscarDocPresup.5
            public void keyPressed(KeyEvent evt) {
                JIFBuscarDocPresup.this.JTFNDocumentoKeyPressed(evt);
            }
        });
        this.JPI_Estado.setBorder(BorderFactory.createTitledBorder((Border) null, "Estado", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBR_Estado.add(this.JRB_ETodos);
        this.JRB_ETodos.setFont(new Font("Arial", 1, 12));
        this.JRB_ETodos.setText("Todos");
        this.JRB_ETodos.addActionListener(new ActionListener() { // from class: Presupuesto.JIFBuscarDocPresup.6
            public void actionPerformed(ActionEvent evt) {
                JIFBuscarDocPresup.this.JRB_ETodosActionPerformed(evt);
            }
        });
        this.JBR_Estado.add(this.JRB_EActivos);
        this.JRB_EActivos.setFont(new Font("Arial", 1, 12));
        this.JRB_EActivos.setSelected(true);
        this.JRB_EActivos.setText("Activos");
        this.JRB_EActivos.addActionListener(new ActionListener() { // from class: Presupuesto.JIFBuscarDocPresup.7
            public void actionPerformed(ActionEvent evt) {
                JIFBuscarDocPresup.this.JRB_EActivosActionPerformed(evt);
            }
        });
        this.JBR_Estado.add(this.JRB_EAnulados);
        this.JRB_EAnulados.setFont(new Font("Arial", 1, 12));
        this.JRB_EAnulados.setText("Anulados");
        this.JRB_EAnulados.addActionListener(new ActionListener() { // from class: Presupuesto.JIFBuscarDocPresup.8
            public void actionPerformed(ActionEvent evt) {
                JIFBuscarDocPresup.this.JRB_EAnuladosActionPerformed(evt);
            }
        });
        GroupLayout JPI_EstadoLayout = new GroupLayout(this.JPI_Estado);
        this.JPI_Estado.setLayout(JPI_EstadoLayout);
        JPI_EstadoLayout.setHorizontalGroup(JPI_EstadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_EstadoLayout.createSequentialGroup().addContainerGap().addComponent(this.JRB_ETodos).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB_EActivos).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB_EAnulados).addContainerGap(-1, 32767)));
        JPI_EstadoLayout.setVerticalGroup(JPI_EstadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPI_EstadoLayout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(JPI_EstadoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRB_ETodos).addComponent(this.JRB_EActivos).addComponent(this.JRB_EAnulados)).addContainerGap()));
        this.JTP_DBusqueda.setForeground(new Color(0, 103, 0));
        this.JTP_DBusqueda.setFont(new Font("Arial", 1, 14));
        this.JDFFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Fin", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFFechaF.setFont(new Font("Arial", 0, 13));
        this.JCBTipoC.setFont(new Font("Arial", 1, 12));
        this.JCBTipoC.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipoC.addItemListener(new ItemListener() { // from class: Presupuesto.JIFBuscarDocPresup.9
            public void itemStateChanged(ItemEvent evt) {
                JIFBuscarDocPresup.this.JCBTipoCItemStateChanged(evt);
            }
        });
        this.JTFTercero.setFont(new Font("Arial", 1, 13));
        this.JTFTercero.setHorizontalAlignment(2);
        this.JTFTercero.setBorder(BorderFactory.createTitledBorder((Border) null, "Tercero", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFTercero.addKeyListener(new KeyAdapter() { // from class: Presupuesto.JIFBuscarDocPresup.10
            public void keyTyped(KeyEvent evt) {
                JIFBuscarDocPresup.this.JTFTerceroKeyTyped(evt);
            }
        });
        this.JTFIdRubro.setFont(new Font("Arial", 1, 13));
        this.JTFIdRubro.setHorizontalAlignment(2);
        this.JTFIdRubro.setBorder(BorderFactory.createTitledBorder((Border) null, "Cod. Rubro", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFIdRubro.addActionListener(new ActionListener() { // from class: Presupuesto.JIFBuscarDocPresup.11
            public void actionPerformed(ActionEvent evt) {
                JIFBuscarDocPresup.this.JTFIdRubroActionPerformed(evt);
            }
        });
        this.JTFIdRubro.addFocusListener(new FocusAdapter() { // from class: Presupuesto.JIFBuscarDocPresup.12
            public void focusLost(FocusEvent evt) {
                JIFBuscarDocPresup.this.JTFIdRubroFocusLost(evt);
            }
        });
        this.JTFIdRubro.addKeyListener(new KeyAdapter() { // from class: Presupuesto.JIFBuscarDocPresup.13
            public void keyPressed(KeyEvent evt) {
                JIFBuscarDocPresup.this.JTFIdRubroKeyPressed(evt);
            }

            public void keyTyped(KeyEvent evt) {
                JIFBuscarDocPresup.this.JTFIdRubroKeyTyped(evt);
            }
        });
        this.JTFNit.setFont(new Font("Arial", 1, 13));
        this.JTFNit.setHorizontalAlignment(2);
        this.JTFNit.setBorder(BorderFactory.createTitledBorder((Border) null, "Nit ó Identificación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNit.addActionListener(new ActionListener() { // from class: Presupuesto.JIFBuscarDocPresup.14
            public void actionPerformed(ActionEvent evt) {
                JIFBuscarDocPresup.this.JTFNitActionPerformed(evt);
            }
        });
        this.JTFNit.addFocusListener(new FocusAdapter() { // from class: Presupuesto.JIFBuscarDocPresup.15
            public void focusLost(FocusEvent evt) {
                JIFBuscarDocPresup.this.JTFNitFocusLost(evt);
            }
        });
        this.JTFNit.addKeyListener(new KeyAdapter() { // from class: Presupuesto.JIFBuscarDocPresup.16
            public void keyTyped(KeyEvent evt) {
                JIFBuscarDocPresup.this.JTFNitKeyTyped(evt);
            }
        });
        this.JDFFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFFechaI.setFont(new Font("Arial", 0, 13));
        this.JBBuscaTercero.setIcon(new ImageIcon(getClass().getResource("/Imagenes/lupa.png")));
        this.JBBuscaTercero.setToolTipText("Buscar Tercero");
        this.JBBuscaTercero.addActionListener(new ActionListener() { // from class: Presupuesto.JIFBuscarDocPresup.17
            public void actionPerformed(ActionEvent evt) {
                JIFBuscarDocPresup.this.JBBuscaTerceroActionPerformed(evt);
            }
        });
        this.JRBTodos.setFont(new Font("Arial", 1, 12));
        this.JRBTodos.setText("Todos");
        this.JRBTodos.setName("0");
        this.JRBTodos.addActionListener(new ActionListener() { // from class: Presupuesto.JIFBuscarDocPresup.18
            public void actionPerformed(ActionEvent evt) {
                JIFBuscarDocPresup.this.JRBTodosActionPerformed(evt);
            }
        });
        this.JRBTDocumento.setFont(new Font("Arial", 1, 12));
        this.JRBTDocumento.setText("Tipo Documento");
        this.JRBTDocumento.setName("2");
        this.JRBTDocumento.addActionListener(new ActionListener() { // from class: Presupuesto.JIFBuscarDocPresup.19
            public void actionPerformed(ActionEvent evt) {
                JIFBuscarDocPresup.this.JRBTDocumentoActionPerformed(evt);
            }
        });
        this.JRBFechas.setFont(new Font("Arial", 1, 12));
        this.JRBFechas.setText("Intervalo de Fechas");
        this.JRBFechas.setName("4");
        this.JRBFechas.addActionListener(new ActionListener() { // from class: Presupuesto.JIFBuscarDocPresup.20
            public void actionPerformed(ActionEvent evt) {
                JIFBuscarDocPresup.this.JRBFechasActionPerformed(evt);
            }
        });
        this.JRBPeriodo.setFont(new Font("Arial", 1, 12));
        this.JRBPeriodo.setText("Período");
        this.JRBPeriodo.setName("1");
        this.JRBPeriodo.addActionListener(new ActionListener() { // from class: Presupuesto.JIFBuscarDocPresup.21
            public void actionPerformed(ActionEvent evt) {
                JIFBuscarDocPresup.this.JRBPeriodoActionPerformed(evt);
            }
        });
        this.JRBTercero.setFont(new Font("Arial", 1, 12));
        this.JRBTercero.setText("Tercero");
        this.JRBTercero.setName("3");
        this.JRBTercero.addActionListener(new ActionListener() { // from class: Presupuesto.JIFBuscarDocPresup.22
            public void actionPerformed(ActionEvent evt) {
                JIFBuscarDocPresup.this.JRBTerceroActionPerformed(evt);
            }
        });
        this.JRBRubro.setFont(new Font("Arial", 1, 12));
        this.JRBRubro.setText("Rubro");
        this.JRBRubro.setName("5");
        this.JRBRubro.addActionListener(new ActionListener() { // from class: Presupuesto.JIFBuscarDocPresup.23
            public void actionPerformed(ActionEvent evt) {
                JIFBuscarDocPresup.this.JRBRubroActionPerformed(evt);
            }
        });
        GroupLayout JPFiltrosLayout = new GroupLayout(this.JPFiltros);
        this.JPFiltros.setLayout(JPFiltrosLayout);
        JPFiltrosLayout.setHorizontalGroup(JPFiltrosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPFiltrosLayout.createSequentialGroup().addGap(10, 10, 10).addGroup(JPFiltrosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JRBTodos).addComponent(this.JRBTDocumento).addComponent(this.JRBFechas)).addGap(10, 10, 10).addGroup(JPFiltrosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JRBPeriodo).addComponent(this.JRBTercero).addComponent(this.JRBRubro)).addGap(10, 10, 10)));
        JPFiltrosLayout.setVerticalGroup(JPFiltrosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPFiltrosLayout.createSequentialGroup().addGap(3, 3, 3).addGroup(JPFiltrosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPFiltrosLayout.createSequentialGroup().addComponent(this.JRBPeriodo).addGap(16, 16, 16).addComponent(this.JRBTercero).addGap(15, 15, 15).addComponent(this.JRBRubro)).addGroup(JPFiltrosLayout.createSequentialGroup().addComponent(this.JRBTodos).addGap(18, 18, 18).addComponent(this.JRBTDocumento).addGap(15, 15, 15).addComponent(this.JRBFechas))).addContainerGap(10, 32767)));
        this.JCB_NRubro.setFont(new Font("Arial", 1, 12));
        this.JCB_NRubro.setBorder(BorderFactory.createTitledBorder((Border) null, "Rubro", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCB_NRubro.addItemListener(new ItemListener() { // from class: Presupuesto.JIFBuscarDocPresup.24
            public void itemStateChanged(ItemEvent evt) {
                JIFBuscarDocPresup.this.JCB_NRubroItemStateChanged(evt);
            }
        });
        GroupLayout JPIFitroBusquedaLayout = new GroupLayout(this.JPIFitroBusqueda);
        this.JPIFitroBusqueda.setLayout(JPIFitroBusquedaLayout);
        JPIFitroBusquedaLayout.setHorizontalGroup(JPIFitroBusquedaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFitroBusquedaLayout.createSequentialGroup().addContainerGap().addComponent(this.JPFiltros, -2, -1, -2).addGap(18, 18, 18).addGroup(JPIFitroBusquedaLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPIFitroBusquedaLayout.createSequentialGroup().addComponent(this.JDFFechaI, -2, 121, -2).addGap(9, 9, 9).addComponent(this.JDFFechaF, -2, 121, -2).addGap(9, 9, 9).addComponent(this.JCBTipoC, -2, 320, -2)).addGroup(GroupLayout.Alignment.TRAILING, JPIFitroBusquedaLayout.createSequentialGroup().addGroup(JPIFitroBusquedaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFNit).addComponent(this.JTFIdRubro, -2, 127, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIFitroBusquedaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFitroBusquedaLayout.createSequentialGroup().addComponent(this.JBBuscaTercero, -2, 50, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFTercero, -2, 381, -2)).addComponent(this.JCB_NRubro, -2, 383, -2)))).addContainerGap()));
        JPIFitroBusquedaLayout.setVerticalGroup(JPIFitroBusquedaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFitroBusquedaLayout.createSequentialGroup().addGap(10, 10, 10).addGroup(JPIFitroBusquedaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPFiltros, -2, -1, -2).addGroup(JPIFitroBusquedaLayout.createSequentialGroup().addGroup(JPIFitroBusquedaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JDFFechaI, -2, -1, -2).addComponent(this.JDFFechaF, -2, -1, -2).addComponent(this.JCBTipoC, -2, -1, -2)).addGap(6, 6, 6).addGroup(JPIFitroBusquedaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFNit, -2, -1, -2).addComponent(this.JBBuscaTercero, -2, 40, -2).addComponent(this.JTFTercero, -2, -1, -2)).addGap(7, 7, 7).addGroup(JPIFitroBusquedaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFIdRubro, -2, -1, -2).addComponent(this.JCB_NRubro, -2, -1, -2)))).addContainerGap()));
        this.JTP_DBusqueda.addTab("FILTRO BÚSQUEDA", this.JPIFitroBusqueda);
        this.JTB_FPeriodo.setFont(new Font("Arial", 1, 12));
        this.JTB_FPeriodo.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JSP_FPeriodo.setViewportView(this.JTB_FPeriodo);
        GroupLayout JPI_FPeriodosLayout = new GroupLayout(this.JPI_FPeriodos);
        this.JPI_FPeriodos.setLayout(JPI_FPeriodosLayout);
        JPI_FPeriodosLayout.setHorizontalGroup(JPI_FPeriodosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_FPeriodosLayout.createSequentialGroup().addComponent(this.JSP_FPeriodo, -2, 465, -2).addGap(0, 400, 32767)));
        JPI_FPeriodosLayout.setVerticalGroup(JPI_FPeriodosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSP_FPeriodo, -1, 167, 32767));
        this.JTP_DBusqueda.addTab("PERÍODOS", this.JPI_FPeriodos);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(layout.createSequentialGroup().addComponent(this.JTFRuta, -2, 363, -2).addGap(18, 18, 18).addComponent(this.JBTExportar, -2, 128, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPI_Estado, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFNDocumento)).addComponent(this.JTP_Datos).addComponent(this.JTP_DBusqueda)).addContainerGap(-1, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTP_DBusqueda, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTP_Datos, -2, 311, -2).addGap(18, 18, 18).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JBTExportar, -1, -1, 32767).addComponent(this.JTFRuta).addComponent(this.JTFNDocumento).addComponent(this.JPI_Estado, -1, -1, 32767)).addContainerGap(-1, 32767)));
        pack();
    }

    private boolean mConstruyeCondicion() {
        boolean xTodoOk = false;
        mIniciaArray();
        int x = 0;
        while (true) {
            if (x >= this.JPFiltros.getComponentCount()) {
                break;
            }
            if (this.JPFiltros.getComponent(x).getClass().getName().equals("javax.swing.JRadioButton")) {
                JRadioButton xrb = this.JPFiltros.getComponent(x);
                System.out.println("xrb-->" + xrb.getName());
                int xposicion = mVerificaPosicionArray();
                if (xrb.getName().equals("0") && xrb.isSelected()) {
                    if (xposicion == 0) {
                        this.xCondicion[xposicion] = " m.Id_MotivoAnulacion " + this.xEstado + " ";
                    } else {
                        this.xCondicion[xposicion] = " AND m.Id_MotivoAnulacion " + this.xEstado + " ";
                    }
                    xTodoOk = true;
                }
                if (xrb.getName().equals("1") && xrb.isSelected()) {
                    String xcodigopro = "";
                    for (int j = 0; j < this.JTB_FPeriodo.getRowCount(); j++) {
                        if (Boolean.valueOf(this.xmodelop.getValueAt(j, 2).toString()).booleanValue()) {
                            xcodigopro = xcodigopro + "," + this.xmodelop.getValueAt(j, 0).toString();
                        }
                    }
                    if (!xcodigopro.equals("")) {
                        if (xposicion == 0) {
                            this.xCondicion[xposicion] = " m.Id_Periodo IN(" + xcodigopro.substring(1, xcodigopro.length()) + ") AND m.Id_MotivoAnulacion " + this.xEstado + "";
                        } else {
                            this.xCondicion[xposicion] = " AND m.Id_Periodo IN(" + xcodigopro.substring(1, xcodigopro.length()) + ") AND m.Id_MotivoAnulacion " + this.xEstado + "";
                        }
                        xTodoOk = true;
                    } else {
                        xTodoOk = false;
                        JOptionPane.showMessageDialog(this, "Debe seleccionar al menos un periodo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        this.JTP_DBusqueda.setSelectedIndex(1);
                        break;
                    }
                }
                if (xrb.getName().equals("2") && xrb.isSelected()) {
                    if (this.JCBTipoC.getSelectedIndex() > -1) {
                        if (xposicion == 0) {
                            this.xCondicion[xposicion] = "m.Id_MotivoAnulacion " + this.xEstado + " and td.Id ='" + this.xidtipodocppto[this.JCBTipoC.getSelectedIndex()][0] + "' ";
                        } else {
                            this.xCondicion[xposicion] = " AND m.Id_MotivoAnulacion " + this.xEstado + " and td.Id ='" + this.xidtipodocppto[this.JCBTipoC.getSelectedIndex()][0] + "' ";
                        }
                        xTodoOk = true;
                    } else {
                        xTodoOk = false;
                        JOptionPane.showMessageDialog(this, "Debe seleccionar un Tipo de documento", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        break;
                    }
                }
                if (xrb.getName().equals("3") && xrb.isSelected()) {
                    if (!this.JTFNit.getText().equals("")) {
                        if (xposicion == 0) {
                            this.xCondicion[xposicion] = " m.Id_MotivoAnulacion " + this.xEstado + " and (e.No_identificacion = '" + this.JTFNit.getText() + "' || concat(e.No_identificacion,'-',e.Dig_Verificacion) = '" + this.JTFNit.getText() + "' ) ";
                        } else {
                            this.xCondicion[xposicion] = " AND m.Id_MotivoAnulacion " + this.xEstado + " and (e.No_identificacion = '" + this.JTFNit.getText() + "' || concat(e.No_identificacion,'-',e.Dig_Verificacion) = '" + this.JTFNit.getText() + "' ) ";
                        }
                        xTodoOk = true;
                    } else {
                        xTodoOk = false;
                        JOptionPane.showMessageDialog(this, "Debe digitar el Documento del Tercero", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        break;
                    }
                }
                if (xrb.getName().equals("4") && xrb.isSelected()) {
                    if (xposicion == 0) {
                        this.xCondicion[xposicion] = " m.FechaD>='" + this.xmt.formatoAMD.format(this.JDFFechaI.getDate()) + "' and m.FechaD<='" + this.xmt.formatoAMD.format(this.JDFFechaF.getDate()) + "'";
                    } else {
                        this.xCondicion[xposicion] = " AND m.FechaD>='" + this.xmt.formatoAMD.format(this.JDFFechaI.getDate()) + "' and m.FechaD<='" + this.xmt.formatoAMD.format(this.JDFFechaF.getDate()) + "'";
                    }
                    xTodoOk = true;
                }
                if (xrb.getName().equals("5") && xrb.isSelected()) {
                    if (!this.JTFIdRubro.getText().equals("")) {
                        if (xposicion == 0) {
                            this.xCondicion[xposicion] = "  m.Id_MotivoAnulacion " + this.xEstado + " AND  dm.Id_Rubro = '" + this.JTFIdRubro.getText() + "'";
                        } else {
                            this.xCondicion[xposicion] = " AND  m.Id_MotivoAnulacion " + this.xEstado + " AND  dm.Id_Rubro = '" + this.JTFIdRubro.getText() + "'";
                        }
                        xTodoOk = true;
                    } else {
                        xTodoOk = false;
                        JOptionPane.showMessageDialog(this, "Debe digitar el Codigo del Rubro", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        break;
                    }
                }
            }
            x++;
        }
        return xTodoOk;
    }

    private int mVerificaPosicionArray() {
        int xPosicion = -1;
        int i = 0;
        while (true) {
            if (i >= this.xCondicion.length) {
                break;
            }
            if (!this.xCondicion[i].equals("")) {
                i++;
            } else {
                xPosicion = i;
                break;
            }
        }
        System.out.println("xPosicion-->" + xPosicion);
        return xPosicion;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBFechasActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBTDocumentoActionPerformed(ActionEvent evt) {
        if (!this.JRBTDocumento.isSelected()) {
            this.JCBTipoC.setSelectedIndex(-1);
        } else {
            this.JCBTipoC.setSelectedIndex(-1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBTerceroActionPerformed(ActionEvent evt) {
        if (!this.JRBTercero.isSelected()) {
            this.JTFNit.setText("");
            this.JTFTercero.setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBTodosActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFTerceroKeyTyped(KeyEvent evt) {
        if (!this.JTFTercero.getText().isEmpty()) {
            mCargarDatos("G", this.JTDGasto, "pp_tmp_reporteg");
            mCargarDatos("I", this.JTDIngreso, "pp_tmp_reporte");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDIngresoMouseClicked(MouseEvent evt) {
        if (this.xjidocc != null && this.JTDIngreso.getSelectedRow() != -1 && evt.getClickCount() == 2) {
            try {
                boolean xforma = false;
                int x = JOptionPane.showInternalConfirmDialog(this, "Desea trasladar detalle documento?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (x == 0) {
                    xforma = true;
                }
                this.xjidocc.mNuevo();
                this.xjidocc.mBuscarDatos(this.xmodelo.getValueAt(this.JTDIngreso.getSelectedRow(), 0).toString(), xforma);
                this.xjidocc.setSelected(true);
                dispose();
            } catch (PropertyVetoException e) {
                Logger.getLogger(JIFBuscarDocPresup.class.getName()).log(Level.SEVERE, (String) null, e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JFileChooser xfilec = new JFileChooser(this.JTFRuta.getText());
            xfilec.setFileSelectionMode(1);
            int xv = xfilec.showOpenDialog(this);
            if (xv == 0) {
                File xfile = xfilec.getSelectedFile();
                this.JTFRuta.setText(xfile.getAbsolutePath() + this.xmt.getBarra());
                this.JTFRuta.requestFocus();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTExportarActionPerformed(ActionEvent evt) {
        if (!this.JTFRuta.getText().isEmpty()) {
            if (this.JTP_Datos.getSelectedIndex() == 0) {
                if (this.JTDIngreso.getRowCount() > -1) {
                    int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    if (n == 0) {
                        this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTDIngreso, this.xmt.mTraerUrlBD(this.JTFRuta.getText()), "LIBRO DIARIO DE INGRESOS");
                        return;
                    }
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "No existe información para exportar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                return;
            }
            if (this.JTP_Datos.getSelectedIndex() == 1) {
                if (this.JTDGasto.getRowCount() > -1) {
                    int n2 = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    if (n2 == 0) {
                        this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTDGasto, this.xmt.mTraerUrlBD(this.JTFRuta.getText()), "LIBRO DIARIO DE GASTOS");
                        return;
                    }
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "No existe información para exportar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un ruta valida", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTFRuta.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNDocumentoKeyPressed(KeyEvent evt) {
        if (!this.JTFNDocumento.getText().isEmpty()) {
            mCargarDatos("G", this.JTDGasto, "pp_tmp_reporteg");
            mCargarDatos("I", this.JTDIngreso, "pp_tmp_reporte");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_ETodosActionPerformed(ActionEvent evt) {
        this.xEstado = ">0";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_EActivosActionPerformed(ActionEvent evt) {
        this.xEstado = "=1";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_EAnuladosActionPerformed(ActionEvent evt) {
        this.xEstado = ">1";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBPeriodoActionPerformed(ActionEvent evt) {
        this.xtipof = 1;
        if (this.JRBPeriodo.isSelected()) {
            if (this.xOrden == 0) {
                this.xFiltro1 = "";
                this.xOrden++;
                return;
            } else {
                this.xFiltro1 = " AND";
                this.xOrden--;
                return;
            }
        }
        this.xFiltro1 = "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBRubroActionPerformed(ActionEvent evt) {
        if (!this.JRBRubro.isSelected()) {
            this.JTFIdRubro.setText("");
            this.JCB_NRubro.setSelectedIndex(-1);
        }
    }

    public void mFiltroTercero() {
        if (this.xOrden == 0) {
            this.xFiltro3 = " m.Id_MotivoAnulacion " + this.xEstado + " and e.No_identificacion = '" + this.JTFNit.getText() + "'";
            this.xOrden++;
            System.out.println("xFiltro3-->" + this.xFiltro3);
        } else {
            this.xFiltro3 = " AND m.Id_MotivoAnulacion " + this.xEstado + " and e.No_identificacion = '" + this.JTFNit.getText() + "'";
            this.xOrden++;
            System.out.println("xFiltro3-->" + this.xFiltro3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFIdRubroKeyTyped(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNitKeyTyped(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFIdRubroFocusLost(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFIdRubroActionPerformed(ActionEvent evt) {
        if (!this.JTFIdRubro.getText().isEmpty()) {
            mBuscaNombreRubro();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBBuscaTerceroActionPerformed(ActionEvent evt) {
        if (this.JRBTercero.isSelected()) {
            JDPatologia x = new JDPatologia(null, true, this);
            x.setVisible(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTipoCItemStateChanged(ItemEvent evt) {
        if (this.xlleno && this.JCBTipoC.getSelectedIndex() != -1) {
            if (this.xOrden == 0) {
                this.xFiltro2 = " m.Id_MotivoAnulacion " + this.xEstado + " and td.Id ='" + this.xidtipodocppto[this.JCBTipoC.getSelectedIndex()][0] + "' ";
            } else {
                this.xFiltro2 = " AND m.Id_MotivoAnulacion " + this.xEstado + " and td.Id ='" + this.xidtipodocppto[this.JCBTipoC.getSelectedIndex()][0] + "' ";
            }
            System.out.println("xFiltro2-->" + this.xFiltro2);
            this.xOrden++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNitActionPerformed(ActionEvent evt) {
        if (!this.JTFNit.getText().isEmpty()) {
            mBuscaNombreTercero();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNitFocusLost(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCB_NRubroItemStateChanged(ItemEvent evt) {
        if (this.xlleno && this.JCB_NRubro.getSelectedIndex() != -1) {
            this.JTFIdRubro.setText(this.xIdRubros[this.JCB_NRubro.getSelectedIndex()]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFIdRubroKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDGastoMouseClicked(MouseEvent evt) {
        if (this.xjidocc != null && this.JTDGasto.getSelectedRow() != -1 && evt.getClickCount() == 2) {
            try {
                boolean xforma = false;
                int x = JOptionPane.showInternalConfirmDialog(this, "Desea trasladar detalle documento?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (x == 0) {
                    xforma = true;
                }
                this.xjidocc.mNuevo();
                this.xjidocc.mBuscarDatos(this.xmodelo.getValueAt(this.JTDGasto.getSelectedRow(), 0).toString(), xforma);
                this.xjidocc.setSelected(true);
                dispose();
            } catch (PropertyVetoException e) {
                Logger.getLogger(JIFBuscarDocPresup.class.getName()).log(Level.SEVERE, (String) null, e);
            }
        }
    }

    private void mBuscaNombreTercero() {
        String sql = "SELECT   `RazonSocialCompleta` AS Tercero, `Id`\nFROM `cc_terceros`     \nWHERE  (`No_identificacion`='" + this.JTFNit.getText() + "' || `TDCompleto2`='" + this.JTFNit.getText() + "' )";
        ResultSet xrs = this.xconsultas.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.first();
                this.JTFTercero.setText(xrs.getString("Tercero"));
            } else {
                this.JTFTercero.setText("");
                JOptionPane.showInternalMessageDialog(this, "No Existe Tercero", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            }
            xrs.close();
            this.xconsultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFBuscarDocPresup.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mBuscaNombreRubro() {
        String sql = "SELECT CONCAT(`pp_rubros`.`Nbre`, ' - ',pp_rubros.`Id`) Nbre FROM `pp_rubros` WHERE Id='" + this.JTFIdRubro.getText() + "' and idEncabezadoRubro='" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "'";
        ResultSet xrs = this.xconsultas.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.first();
                this.JCB_NRubro.setSelectedItem(xrs.getString("Nbre"));
            } else {
                this.JCB_NRubro.setSelectedIndex(-1);
                JOptionPane.showInternalMessageDialog(this, "No Existe Rubro", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            }
            xrs.close();
            this.xconsultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFBuscarDocPresup.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mIniciaArray() {
        this.xCondicion[0] = "";
        this.xCondicion[1] = "";
        this.xCondicion[2] = "";
        this.xCondicion[3] = "";
        this.xCondicion[4] = "";
    }

    private void mIniciarComponentes() {
        mIniciaArray();
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        this.JRBTodos.setSelected(true);
        this.JDFFechaI.setDate(this.xmt.getFechaActual());
        this.JDFFechaF.setDate(this.xmt.getFechaActual());
        this.JCBTipoC.removeAllItems();
        this.JTFNDocumento.setText("");
        this.xidtipodocppto = this.xconsultas.llenarComboyLista("SELECT Id, Nbre FROM pp_tipo_documentos WHERE (Estado =1) ORDER BY Nbre ASC", this.xidtipodocppto, this.JCBTipoC, 2);
        this.JCBTipoC.setSelectedIndex(-1);
        this.xconsultas.cerrarConexionBd();
        this.JTFTercero.setText("");
        this.JTFNit.setText("");
        this.JTFIdRubro.setText("");
        this.JCB_NRubro.removeAllItems();
        String sql = "SELECT pp_rubros.`Id` ,CONCAT(`pp_rubros`.`Nbre`, ' - ',pp_rubros.`Id`) AS Rubro \nFROM  `pp_rubros`\nWHERE idEncabezadoRubro='" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "' ORDER BY pp_rubros.Nbre ASC";
        System.out.println("Items COmbo-->" + sql);
        ConsultasMySQL xct1 = new ConsultasMySQL();
        this.xIdRubros = xct1.llenarCombo(sql, this.xIdRubros, this.JCB_NRubro);
        this.JCB_NRubro.setSelectedIndex(-1);
        xct1.cerrarConexionBd();
        mCargarDatos_Periodo();
        this.xlleno = true;
    }

    private void mCrearTablaDetalle(JTable xtabla) {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"Prefijo", "No_Consecutivo", "Id_Tipo_Documento", "Tipo Documento", "Id_Periodo", "Periodo", "Fecha Digitación", "Observación", "Id_Rubro", "Rubro", "TipoRubro", "Valor", "No Identificacion", "Tercero", "Estado", "Nº Acto", "FRegistro", "N° Solicitud", "N° Disponibilidad", "N° Compromiso", "N° Obligacion", "Clase Documento", "Nº Factura", "IdCoDocContable"}) { // from class: Presupuesto.JIFBuscarDocPresup.25
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Double.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        xtabla.setAutoResizeMode(0);
        xtabla.doLayout();
        xtabla.setModel(this.xmodelo);
        xtabla.getColumnModel().getColumn(0).setPreferredWidth(120);
        xtabla.getColumnModel().getColumn(1).setPreferredWidth(130);
        xtabla.getColumnModel().getColumn(2).setPreferredWidth(150);
        xtabla.getColumnModel().getColumn(3).setPreferredWidth(200);
        xtabla.getColumnModel().getColumn(4).setPreferredWidth(120);
        xtabla.getColumnModel().getColumn(5).setPreferredWidth(120);
        xtabla.getColumnModel().getColumn(6).setPreferredWidth(120);
        xtabla.getColumnModel().getColumn(7).setPreferredWidth(120);
        xtabla.getColumnModel().getColumn(8).setPreferredWidth(120);
        xtabla.getColumnModel().getColumn(9).setPreferredWidth(120);
        xtabla.getColumnModel().getColumn(10).setPreferredWidth(120);
        xtabla.getColumnModel().getColumn(11).setPreferredWidth(120);
        xtabla.getColumnModel().getColumn(12).setPreferredWidth(120);
        xtabla.getColumnModel().getColumn(13).setPreferredWidth(120);
        xtabla.getColumnModel().getColumn(14).setPreferredWidth(120);
        xtabla.getColumnModel().getColumn(15).setPreferredWidth(20);
        xtabla.getColumnModel().getColumn(16).setPreferredWidth(20);
        xtabla.getColumnModel().getColumn(17).setPreferredWidth(20);
        xtabla.getColumnModel().getColumn(18).setPreferredWidth(20);
        xtabla.getColumnModel().getColumn(19).setPreferredWidth(20);
        xtabla.getColumnModel().getColumn(20).setPreferredWidth(20);
        xtabla.getColumnModel().getColumn(21).setPreferredWidth(120);
        xtabla.getColumnModel().getColumn(22).setPreferredWidth(80);
        xtabla.getColumnModel().getColumn(23).setPreferredWidth(100);
    }

    private void mCrearTablaDetalle_P() {
        this.xmodelop = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Nombre", "Seleccionar"}) { // from class: Presupuesto.JIFBuscarDocPresup.26
            Class[] types = {Long.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTB_FPeriodo.setModel(this.xmodelop);
        this.JTB_FPeriodo.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTB_FPeriodo.getColumnModel().getColumn(1).setPreferredWidth(50);
        this.JTB_FPeriodo.getColumnModel().getColumn(2).setPreferredWidth(10);
    }

    private void mCargarDatos(String xTipoRubro, JTable xTablaDetalle, String xTablaBD) {
        String sql = "SELECT  IFNULL(td.Prefijo,'') Prefijo,\n\tm.NoConcecutivo AS No_Consecutivo,\n\ttd.Id AS Id_Tipo_Documento,\n\tIF(tdc.`Id`=7, IF( dm.`Tipo`=0, CONCAT(td.Nbre, ' DEBITO'), CONCAT(td.Nbre, ' CREDITO')), td.Nbre) AS Tipo_Documento,\n\tm.Id_Periodo AS Id_Periodo,\n\tp.Nbre AS Periodo,\n\tm.FechaD AS Fecha_Digitacion,\n\tIF(m.Observacion IS NULL,'',m.Observacion ) AS Observacion,\n\tdm.Id_Rubro,\n\tr.Nbre AS Rubro,\n\tr.TipoRubro,\n\tIF(tdc.`Id`=7,IF( dm.`Tipo`=0,(dm.Valor*-1),dm.Valor) ,dm.Valor) Valor,\n\te.No_identificacion,\n\te.RazonSocialCompleta AS Tercero,\n\tIF(m.Id_MotivoAnulacion>1,'ANULADO','ACTIVO') Estado, IFNULL(m.DatoResolucion,'') DatoResolucion, IF(m.EsGlobal=-1,'NO APLICA',IF(m.EsGlobal=1,'RGLOBAL','RDISTRIBUIDO')) EsGlobal  \n\t, m.`IdSolicitud`\n\t, IFNULL(dsp.`NoConcecutivo`,'') Disp\n\t, IFNULL(comp.`NoConcecutivo`,'') Compr\n\t, IFNULL(obli.`NoConcecutivo`,'') Oblig  \n     , tdc.Nbre AS ClaseDoc \n     , m.`NoFact`, m.IdDocContable FROM\n    pp_detalle_movimiento dm\n    INNER JOIN pp_movimiento m \n        ON (dm.Id_Movimiento = m.Id)\n    INNER JOIN pp_periodo p\n        ON (m.Id_Periodo = p.Id)\n    INNER JOIN pp_rubros r\n        ON (dm.Id_Rubro = r.Id) AND (r.`idEncabezadoRubro`=dm.`idEncabezado`) \n    INNER JOIN cc_terceros e\n        ON (dm.Id_Tercero = e.Id)\n    INNER JOIN pp_tipo_documentos td\n        ON (m.Id_TipoDoc = td.Id)\n    INNER JOIN pp_clase_documento tdc\n        ON (td.`Id_ClaseDoc` = tdc.Id)  LEFT JOIN `pp_movimiento` dsp\n        ON (m.`IdDisponibilidad` = dsp.Id)        \n    LEFT JOIN `pp_movimiento` comp\n        ON (m.`IdCompromiso`= comp.Id)            \n    LEFT JOIN `pp_movimiento` obli\n        ON (m.`IdObligacion`= obli.Id)   WHERE dm.idEncabezado='" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "'AND r.TipoRubro='" + xTipoRubro + "' AND dm.Estado=1 AND ";
        System.out.println("0-->" + this.xCondicion[0] + " 1-->" + this.xCondicion[1] + " 2-->" + this.xCondicion[2] + " 3-->" + this.xCondicion[3] + " 4-->" + this.xCondicion[4]);
        String sql2 = sql + this.xCondicion[0] + this.xCondicion[1] + this.xCondicion[2] + this.xCondicion[3] + this.xCondicion[4];
        System.out.println("Consulta-->" + sql2);
        String xsql = "DROP TABLE IF EXISTS " + xTablaBD;
        this.xconsultas.ejecutarSQL(xsql);
        this.xconsultas.cerrarConexionBd();
        String xsql2 = "CREATE TABLE " + xTablaBD + " " + sql2;
        this.xconsultas.ejecutarSQL(xsql2);
        this.xconsultas.cerrarConexionBd();
        mCrearTablaDetalle(xTablaDetalle);
        ResultSet rs = this.xconsultas.traerRs(sql2);
        try {
            if (rs.next()) {
                rs.beforeFirst();
                int x = 0;
                while (rs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(rs.getString(1), x, 0);
                    this.xmodelo.setValueAt(rs.getString(2), x, 1);
                    this.xmodelo.setValueAt(rs.getString(3), x, 2);
                    this.xmodelo.setValueAt(rs.getString(4), x, 3);
                    this.xmodelo.setValueAt(rs.getString(5), x, 4);
                    this.xmodelo.setValueAt(rs.getString(6), x, 5);
                    this.xmodelo.setValueAt(rs.getString(7), x, 6);
                    this.xmodelo.setValueAt(rs.getString(8), x, 7);
                    this.xmodelo.setValueAt(rs.getString(9), x, 8);
                    this.xmodelo.setValueAt(rs.getString(10), x, 9);
                    this.xmodelo.setValueAt(rs.getString(11), x, 10);
                    this.xmodelo.setValueAt(Double.valueOf(rs.getDouble(12)), x, 11);
                    this.xmodelo.setValueAt(rs.getString(13), x, 12);
                    this.xmodelo.setValueAt(rs.getString(14), x, 13);
                    this.xmodelo.setValueAt(rs.getString(15), x, 14);
                    this.xmodelo.setValueAt(rs.getString("DatoResolucion"), x, 15);
                    this.xmodelo.setValueAt(rs.getString("EsGlobal"), x, 16);
                    this.xmodelo.setValueAt(rs.getString("IdSolicitud"), x, 17);
                    this.xmodelo.setValueAt(rs.getString("Disp"), x, 18);
                    this.xmodelo.setValueAt(rs.getString("Compr"), x, 19);
                    this.xmodelo.setValueAt(rs.getString("Oblig"), x, 20);
                    this.xmodelo.setValueAt(rs.getString("ClaseDoc"), x, 21);
                    this.xmodelo.setValueAt(rs.getString("NoFact"), x, 22);
                    this.xmodelo.setValueAt(rs.getString("IdDocContable"), x, 23);
                    x++;
                }
            }
            rs.close();
            this.xconsultas.cerrarConexionBd();
        } catch (SQLException ex) {
            this.xconsultas.mostrarErrorSQL(ex);
        }
    }

    private void mCargarDatos_Periodo() {
        mCrearTablaDetalle_P();
        ResultSet rs = this.xconsultas.traerRs("SELECT Id, IF(Nbre IS NULL || Nbre='',DevuelveMes(FechaI),Nbre)  AS Mes   FROM pp_periodo  ORDER BY Id DESC");
        try {
            if (rs.next()) {
                rs.beforeFirst();
                int x = 0;
                while (rs.next()) {
                    this.xmodelop.addRow(this.xdato);
                    this.xmodelop.setValueAt(Long.valueOf(rs.getLong(1)), x, 0);
                    this.xmodelop.setValueAt(rs.getString(2), x, 1);
                    this.xmodelop.setValueAt(false, x, 2);
                    x++;
                }
            }
            rs.close();
            this.xconsultas.cerrarConexionBd();
        } catch (SQLException ex) {
            this.xconsultas.mostrarErrorSQL(ex);
        }
    }

    public void mBuscar() {
        if (this.JTP_Datos.getSelectedIndex() == 0 || this.JTP_Datos.getSelectedIndex() == 1) {
            System.out.println("le dio a buscar");
            if (mConstruyeCondicion()) {
                mCargarDatos("G", this.JTDGasto, "pp_tmp_reporteg");
                mCargarDatos("I", this.JTDIngreso, "pp_tmp_reporte");
            }
        }
    }

    public void mImprimir() {
        if (!Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO CAMU DEL PRADO")) {
            String[][] parametros = new String[2][0];
            parametros[0][0] = "SUBREPORT_DIR";
            parametros[0][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
            parametros[1][0] = "SUBREPORTFIRMA_DIR";
            parametros[1][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
            if (this.JTP_Datos.getSelectedIndex() == 0) {
                this.xmt.GenerarPDF(this.xmt.getRutaRep() + "pp_libro_ingreso", parametros);
            } else if (this.JTP_Datos.getSelectedIndex() == 1) {
                this.xmt.GenerarPDF(this.xmt.getRutaRep() + "pp_libro_gastos", parametros);
            }
        }
    }
}
