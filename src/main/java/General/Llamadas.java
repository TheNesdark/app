package General;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import Utilidades.TextAreaEditor;
import Utilidades.TextAreaRenderer;
import Utilidades.corrector.jortho.FileUserDictionary;
import Utilidades.corrector.jortho.SpellChecker;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
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
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/* JADX INFO: loaded from: GenomaP.jar:General/Llamadas.class */
public class Llamadas extends JInternalFrame {
    private DefaultTableModel modelo;
    private DefaultTableModel xmodelo;
    private DefaultTableModel xmodelo1;
    private String sql;
    private String[] listaServicios;
    private String[] xservicios;
    private String[] xId_Novedad;
    private Object[] dato;
    private Object[] xdatos;
    public Persona frmPersona;
    private ResultSet rs;
    private boolean xlleno;
    private JButton JBTCarguesA1;
    private JComboBox JCBProceso;
    private JCheckBox JCHEstado;
    private JDateChooser JDFechaF;
    private JDateChooser JDFechaI;
    private JPanel JPI_Historico;
    private JPanel JPI_Novedades;
    private JPanel JPI_RLlamadas;
    private JScrollPane JSPDetalle;
    private JScrollPane JSPDetalle1;
    private JScrollPane JSPTablallamadas;
    private JScrollPane JSPTablallamadas1;
    public JTable JTDetalleLlamadas;
    public JTable JTDetalleNovedad;
    private JTextField JTFRuta;
    private JCheckBox btnEmpacado;
    public JComboBox cboMotivos;
    public JComboBox cboServicio;
    public JTable grid;
    private JPanel jPanel2;
    private JScrollPane jScrollPane3;
    private JTabbedPane jTabbedPane1;
    private JPanel panelPersona;
    private JEditorPane txtDetalle;
    private JEditorPane txtDetalleN;
    public JDateChooser txtFecha;
    public JDateChooser txtFechaN;
    private JTextField txtNumero;
    private JTextField txtRecibeLlamada;
    private Metodos xmt = new Metodos();
    private ConsultasMySQL consultas = new ConsultasMySQL();
    private int cboLleno = 0;
    private int fila = 0;
    private int empacado = 0;
    private int xestado = 0;

    public Llamadas(String historia, String numero) {
        initComponents();
        mIniciarComponentes();
        setLocation(80, 10);
        this.frmPersona = new Persona(this);
        cargarPanelPersonas();
        crearGrid();
        cargarCombo();
        nuevo();
        this.txtNumero.setText(numero);
        this.frmPersona.txtHistoria.setText(historia);
        this.frmPersona.buscar(2);
        SpellChecker.setUserDictionaryProvider(new FileUserDictionary());
        SpellChecker.registerDictionaries(null, null);
        SpellChecker.register(this.txtDetalle);
        this.grid.addMouseListener(new MouseAdapter() { // from class: General.Llamadas.1
            public void mouseClicked(MouseEvent e) {
                Llamadas.this.fila = Llamadas.this.grid.rowAtPoint(e.getPoint());
                Llamadas.this.cargarDatoDelGrid();
            }
        });
    }

    public void agregarFilaAlGrid() {
        if (this.jTabbedPane1.getSelectedIndex() == 0) {
            if (this.txtFecha.getDate() == null) {
                this.xmt.mostrarMensaje("Por favor digite una Fecha");
                this.txtFecha.requestFocus();
            } else if (this.cboServicio.getSelectedIndex() < 0) {
                this.xmt.mostrarMensaje("Por favor seleccione el Servicio por el cual Llama");
                this.cboServicio.requestFocus();
            } else if (this.txtNumero.getText().isEmpty()) {
                this.xmt.mostrarMensaje("Por favor escriba el número de Cita o Faltante");
                this.txtNumero.requestFocus();
            } else if (this.txtRecibeLlamada.getText().isEmpty()) {
                this.xmt.mostrarMensaje("Por favor escriba el nombre de quien contesta la Llamada");
                this.txtRecibeLlamada.requestFocus();
            } else if (this.txtDetalle.getText().isEmpty()) {
                this.xmt.mostrarMensaje("Por favor escriba un Detalle de la Llamada");
                this.txtDetalle.requestFocus();
            } else if (!Principal.txtNo.getText().isEmpty()) {
                this.xmt.mostrarMensaje("Llamada graba");
            } else if (this.listaServicios[this.cboServicio.getSelectedIndex()].equals("7") && this.txtNumero.getText().equals("0")) {
                this.xmt.mostrarMensaje("Falta N° de Pendiente");
                this.txtNumero.requestFocus();
            } else {
                grabar();
            }
        }
        if (this.jTabbedPane1.getSelectedIndex() == 1) {
            mGrabarNovedad();
        }
    }

    private void cargarCombo() {
        this.sql = "SELECT Id, Nbre FROM f_tiposervicio WHERE (Estado =0) ORDER BY Nbre ASC";
        this.listaServicios = this.consultas.llenarCombo(this.sql, this.listaServicios, this.cboServicio);
        this.cboServicio.setSelectedIndex(-1);
        this.cboLleno = 1;
        this.consultas.cerrarConexionBd();
        this.xId_Novedad = this.consultas.llenarCombo("SELECT   `Id` , `Nbre` FROM `g_tiponovedad` WHERE (`Tipo` =1  AND `Estado` =1)", this.xId_Novedad, this.cboMotivos);
        this.cboMotivos.setSelectedIndex(-1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cargarDatoDelGrid() {
        this.txtRecibeLlamada.setText(this.modelo.getValueAt(this.fila, 1).toString());
        this.txtDetalle.setText(this.modelo.getValueAt(this.fila, 2).toString());
        if (this.modelo.getValueAt(this.fila, 3).equals("0")) {
            this.empacado = 0;
            this.btnEmpacado.setSelected(false);
        } else {
            this.empacado = 1;
            this.btnEmpacado.setSelected(true);
        }
        this.txtNumero.setText(this.modelo.getValueAt(this.fila, 5).toString());
        Principal.txtNo.setText(this.modelo.getValueAt(this.fila, 6).toString());
        Date fecha = this.xmt.getPasarTextoAFecha(this.grid.getValueAt(this.fila, 0).toString());
        this.txtFecha.setDate(fecha);
    }

    private void crearGrid() {
        this.modelo = new DefaultTableModel() { // from class: General.Llamadas.2
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.modelo.addColumn("Fecha y Hora");
        this.modelo.addColumn("Contesto La Llamada");
        this.modelo.addColumn("Detalle");
        this.modelo.addColumn("");
        this.modelo.addColumn("");
        this.modelo.addColumn("Número");
        this.modelo.addColumn("No. Llamada");
        this.modelo.addColumn("Usuario");
        this.grid.setModel(this.modelo);
        this.grid.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.grid.getColumnModel().getColumn(0).setMinWidth(80);
        this.grid.getColumnModel().getColumn(0).setMaxWidth(80);
        this.grid.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(2).setPreferredWidth(200);
        this.grid.getColumnModel().getColumn(3).setPreferredWidth(0);
        this.grid.getColumnModel().getColumn(3).setMinWidth(0);
        this.grid.getColumnModel().getColumn(3).setMaxWidth(0);
        this.grid.getColumnModel().getColumn(4).setPreferredWidth(0);
        this.grid.getColumnModel().getColumn(4).setMinWidth(0);
        this.grid.getColumnModel().getColumn(4).setMaxWidth(0);
        this.grid.getColumnModel().getColumn(5).setPreferredWidth(0);
        this.grid.getColumnModel().getColumn(5).setMinWidth(0);
        this.grid.getColumnModel().getColumn(5).setMaxWidth(0);
        this.grid.getColumnModel().getColumn(6).setPreferredWidth(0);
        this.grid.getColumnModel().getColumn(6).setMinWidth(0);
        this.grid.getColumnModel().getColumn(6).setMaxWidth(0);
        this.grid.getColumnModel().getColumn(7).setPreferredWidth(50);
        this.grid.getColumnModel().getColumn(7).setMinWidth(50);
        this.grid.getColumnModel().getColumn(7).setMaxWidth(50);
        this.fila = 0;
    }

    private void cargarLlamadas() {
        this.sql = "SELECT DATE_FORMAT(g_llamadas.FechaLlamada, '%d/%m/%Y %h:%i %p') As Fecha, g_llamadas.Id_Persona, f_tiposervicio.Nbre, g_llamadas.NbrePersonaContesta, g_llamadas.Detalle, g_llamadas.Numero, g_llamadas.Id, g_llamadas.UsuarioS FROM g_llamadas INNER JOIN f_tiposervicio ON (g_llamadas.Id_TipoServicio = f_tiposervicio.Id) WHERE (g_llamadas.Id_Persona ='" + this.frmPersona.getIdPersona() + "' AND g_llamadas.Id_TipoServicio ='" + this.listaServicios[this.cboServicio.getSelectedIndex()] + "') ORDER BY g_llamadas.FechaLlamada DESC";
        this.rs = this.consultas.traerRs(this.sql);
        try {
            crearGrid();
            while (this.rs.next()) {
                this.modelo.addRow(this.dato);
                this.modelo.setValueAt(this.rs.getString(1), this.fila, 0);
                this.modelo.setValueAt(this.rs.getString(4), this.fila, 1);
                this.modelo.setValueAt(this.rs.getString(5), this.fila, 2);
                this.modelo.setValueAt("1", this.fila, 3);
                this.modelo.setValueAt("1", this.fila, 4);
                this.modelo.setValueAt(this.rs.getString(6), this.fila, 5);
                this.modelo.setValueAt(this.rs.getString(7), this.fila, 6);
                this.modelo.setValueAt(this.rs.getString(8), this.fila, 7);
                this.fila++;
            }
            this.rs.close();
            this.consultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(Llamadas.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void cargarPanelPersonas() {
        this.frmPersona.setVisible(true);
        this.panelPersona.setVisible(false);
        this.frmPersona.setBounds(1, 1, 1199, 160);
        this.panelPersona.add(this.frmPersona);
        this.panelPersona.setVisible(true);
    }

    public void grabar() {
        if (this.jTabbedPane1.getSelectedIndex() == 0) {
            grabarRegistro();
            this.xmt.mostrarMensaje("Registro Grabado");
            cargarLlamadas();
        } else if (this.jTabbedPane1.getSelectedIndex() == 1) {
            mGrabarNovedad();
            this.xmt.mostrarMensaje("Registro Grabado");
        }
    }

    private void grabarRegistro() {
        this.frmPersona.grabar();
        this.sql = "INSERT INTO g_llamadas (FechaLlamada, Id_Persona, Id_TipoServicio, Numero, NbrePersonaContesta, Detalle, Fecha, Id_PersonaL, UsuarioS) VALUES('" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "','" + this.frmPersona.getIdPersona() + "','" + this.listaServicios[this.cboServicio.getSelectedIndex()] + "','" + this.txtNumero.getText() + "','" + this.txtRecibeLlamada.getText() + "','" + this.txtDetalle.getText() + "','" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
        Principal.txtNo.setText(this.consultas.ejecutarSQLId(this.sql));
        this.consultas.cerrarConexionBd();
        mActulizarFechaFaltante();
    }

    private void mGrabarNovedad() {
        this.frmPersona.grabar();
        this.sql = "INSERT INTO  `g_persona_novedades`(`Id_Persona`,`FechaR`,`Id_TipoNovedad`, `Observacion`, `Estado`, `Id_UsuarioS`)\nVALUES ('" + this.frmPersona.getIdPersona() + "','" + this.xmt.formatoAMD.format(this.txtFecha.getDate()) + "','" + this.xId_Novedad[this.cboMotivos.getSelectedIndex()] + "','" + this.txtDetalleN.getText() + "','" + this.xestado + "','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "')";
        Principal.txtNo.setText(this.consultas.ejecutarSQLId(this.sql));
        this.consultas.cerrarConexionBd();
        this.xmt.mostrarMensaje("Registro Grabado");
        mBuscarNovedad();
        nuevo();
    }

    public void nuevo() {
        Principal.mLimpiarDatosP();
        this.txtFecha.setDate(this.xmt.getFechaActual());
        this.cboServicio.setSelectedIndex(-1);
        this.cboMotivos.setSelectedIndex(-1);
        this.txtFechaN.setDate(this.xmt.getFechaActual());
        this.txtRecibeLlamada.setText("");
        this.btnEmpacado.setEnabled(false);
        this.txtNumero.setText("0");
        this.txtDetalle.setText("");
        this.txtDetalleN.setText("");
        this.xestado = 1;
        crearGrid();
    }

    /* JADX WARN: Type inference failed for: r3v116, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v19, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v61, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.panelPersona = new JPanel();
        this.jTabbedPane1 = new JTabbedPane();
        this.JPI_RLlamadas = new JPanel();
        this.txtFecha = new JDateChooser();
        this.txtRecibeLlamada = new JTextField();
        this.btnEmpacado = new JCheckBox();
        this.jScrollPane3 = new JScrollPane();
        this.grid = new JTable();
        this.cboServicio = new JComboBox();
        this.txtNumero = new JTextField();
        this.JSPDetalle = new JScrollPane();
        this.txtDetalle = new JEditorPane();
        this.JPI_Novedades = new JPanel();
        this.cboMotivos = new JComboBox();
        this.txtFechaN = new JDateChooser();
        this.JSPDetalle1 = new JScrollPane();
        this.txtDetalleN = new JEditorPane();
        this.JCHEstado = new JCheckBox();
        this.JSPTablallamadas1 = new JScrollPane();
        this.JTDetalleNovedad = new JTable();
        this.JPI_Historico = new JPanel();
        this.jPanel2 = new JPanel();
        this.JDFechaI = new JDateChooser();
        this.JDFechaF = new JDateChooser();
        this.JCBProceso = new JComboBox();
        this.JTFRuta = new JTextField();
        this.JBTCarguesA1 = new JButton();
        this.JSPTablallamadas = new JScrollPane();
        this.JTDetalleLlamadas = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("REGISTRO DE LLAMADAS Y NOVEDADES DE USUARIO");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMaximumSize(null);
        setName("Llamadas");
        setPreferredSize(new Dimension(1018, 613));
        getContentPane().setLayout((LayoutManager) null);
        GroupLayout panelPersonaLayout = new GroupLayout(this.panelPersona);
        this.panelPersona.setLayout(panelPersonaLayout);
        panelPersonaLayout.setHorizontalGroup(panelPersonaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 990, 32767));
        panelPersonaLayout.setVerticalGroup(panelPersonaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 170, 32767));
        getContentPane().add(this.panelPersona);
        this.panelPersona.setBounds(10, 10, 990, 170);
        this.jTabbedPane1.setForeground(new Color(0, 103, 0));
        this.jTabbedPane1.setFont(new Font("Arial", 1, 14));
        this.txtFecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha y Hora", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtFecha.setDateFormatString(" dd//MM//yyyy hh:mm a");
        this.txtFecha.setFont(new Font("Arial", 1, 12));
        this.txtRecibeLlamada.setFont(new Font("Arial", 1, 12));
        this.txtRecibeLlamada.setBorder(BorderFactory.createTitledBorder((Border) null, "Persona que recibió la llamada", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtRecibeLlamada.addFocusListener(new FocusAdapter() { // from class: General.Llamadas.3
            public void focusGained(FocusEvent evt) {
                Llamadas.this.txtRecibeLlamadaFocusGained(evt);
            }
        });
        this.btnEmpacado.setFont(new Font("Arial", 1, 12));
        this.btnEmpacado.setForeground(Color.blue);
        this.btnEmpacado.setText("Empacado");
        this.btnEmpacado.setEnabled(false);
        this.btnEmpacado.addChangeListener(new ChangeListener() { // from class: General.Llamadas.4
            public void stateChanged(ChangeEvent evt) {
                Llamadas.this.btnEmpacadoStateChanged(evt);
            }
        });
        this.jScrollPane3.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.grid.setBorder(BorderFactory.createBevelBorder(0));
        this.grid.setFont(new Font("Arial", 1, 12));
        this.grid.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.grid.setEditingColumn(1);
        this.grid.setEditingRow(1);
        this.grid.setRowHeight(25);
        this.grid.setSelectionBackground(new Color(255, 255, 255));
        this.grid.setSelectionForeground(new Color(255, 0, 0));
        this.grid.setSelectionMode(0);
        this.grid.addKeyListener(new KeyAdapter() { // from class: General.Llamadas.5
            public void keyReleased(KeyEvent evt) {
                Llamadas.this.gridKeyReleased(evt);
            }
        });
        this.jScrollPane3.setViewportView(this.grid);
        this.cboServicio.setFont(new Font("Arial", 1, 12));
        this.cboServicio.setBorder(BorderFactory.createTitledBorder((Border) null, "Servicio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.cboServicio.addItemListener(new ItemListener() { // from class: General.Llamadas.6
            public void itemStateChanged(ItemEvent evt) {
                Llamadas.this.cboServicioItemStateChanged(evt);
            }
        });
        this.cboServicio.addActionListener(new ActionListener() { // from class: General.Llamadas.7
            public void actionPerformed(ActionEvent evt) {
                Llamadas.this.cboServicioActionPerformed(evt);
            }
        });
        this.txtNumero.setFont(new Font("Arial", 1, 12));
        this.txtNumero.setHorizontalAlignment(4);
        this.txtNumero.setToolTipText("Número de Cita, Faltante, etc");
        this.txtNumero.setBorder(BorderFactory.createTitledBorder((Border) null, "Número", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtNumero.addFocusListener(new FocusAdapter() { // from class: General.Llamadas.8
            public void focusGained(FocusEvent evt) {
                Llamadas.this.txtNumeroFocusGained(evt);
            }
        });
        this.txtDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "Detalle", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtDetalle.setFont(new Font("Arial", 1, 12));
        this.JSPDetalle.setViewportView(this.txtDetalle);
        GroupLayout JPI_RLlamadasLayout = new GroupLayout(this.JPI_RLlamadas);
        this.JPI_RLlamadas.setLayout(JPI_RLlamadasLayout);
        JPI_RLlamadasLayout.setHorizontalGroup(JPI_RLlamadasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_RLlamadasLayout.createSequentialGroup().addGap(2, 2, 2).addGroup(JPI_RLlamadasLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSPDetalle, GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.LEADING, JPI_RLlamadasLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jScrollPane3, GroupLayout.Alignment.TRAILING).addGroup(JPI_RLlamadasLayout.createSequentialGroup().addComponent(this.txtFecha, -2, 160, -2).addGap(20, 20, 20).addComponent(this.cboServicio, -2, 300, -2).addGap(10, 10, 10).addComponent(this.txtNumero, -2, 100, -2).addGap(10, 10, 10).addComponent(this.txtRecibeLlamada, -2, 250, -2).addGap(20, 20, 20).addComponent(this.btnEmpacado, -2, 100, -2)))).addContainerGap(-1, 32767)));
        JPI_RLlamadasLayout.setVerticalGroup(JPI_RLlamadasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_RLlamadasLayout.createSequentialGroup().addGroup(JPI_RLlamadasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_RLlamadasLayout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.btnEmpacado, -2, 30, -2)).addGroup(JPI_RLlamadasLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addGroup(GroupLayout.Alignment.LEADING, JPI_RLlamadasLayout.createSequentialGroup().addGap(3, 3, 3).addComponent(this.txtFecha, -1, -1, 32767)).addGroup(GroupLayout.Alignment.LEADING, JPI_RLlamadasLayout.createSequentialGroup().addContainerGap().addGroup(JPI_RLlamadasLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.txtRecibeLlamada, GroupLayout.Alignment.LEADING).addComponent(this.txtNumero, GroupLayout.Alignment.LEADING).addComponent(this.cboServicio))))).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPDetalle, -2, 66, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane3, -1, 183, 32767).addContainerGap()));
        this.jTabbedPane1.addTab("LLAMADAS", this.JPI_RLlamadas);
        this.cboMotivos.setFont(new Font("Arial", 1, 12));
        this.cboMotivos.setBorder(BorderFactory.createTitledBorder((Border) null, "Motivo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.cboMotivos.addItemListener(new ItemListener() { // from class: General.Llamadas.9
            public void itemStateChanged(ItemEvent evt) {
                Llamadas.this.cboMotivosItemStateChanged(evt);
            }
        });
        this.cboMotivos.addActionListener(new ActionListener() { // from class: General.Llamadas.10
            public void actionPerformed(ActionEvent evt) {
                Llamadas.this.cboMotivosActionPerformed(evt);
            }
        });
        this.txtFechaN.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha y Hora", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtFechaN.setDateFormatString("dd/MM/yyyy");
        this.txtFechaN.setFont(new Font("Arial", 1, 12));
        this.txtDetalleN.setBorder(BorderFactory.createTitledBorder((Border) null, "Detalle", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtDetalleN.setFont(new Font("Arial", 1, 12));
        this.JSPDetalle1.setViewportView(this.txtDetalleN);
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: General.Llamadas.11
            public void actionPerformed(ActionEvent evt) {
                Llamadas.this.JCHEstadoActionPerformed(evt);
            }
        });
        this.JSPTablallamadas1.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalleNovedad.setBorder(BorderFactory.createBevelBorder(0));
        this.JTDetalleNovedad.setFont(new Font("Arial", 1, 12));
        this.JTDetalleNovedad.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalleNovedad.setEditingColumn(1);
        this.JTDetalleNovedad.setEditingRow(1);
        this.JTDetalleNovedad.setRowHeight(25);
        this.JTDetalleNovedad.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalleNovedad.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalleNovedad.addKeyListener(new KeyAdapter() { // from class: General.Llamadas.12
            public void keyReleased(KeyEvent evt) {
                Llamadas.this.JTDetalleNovedadKeyReleased(evt);
            }
        });
        this.JSPTablallamadas1.setViewportView(this.JTDetalleNovedad);
        GroupLayout JPI_NovedadesLayout = new GroupLayout(this.JPI_Novedades);
        this.JPI_Novedades.setLayout(JPI_NovedadesLayout);
        JPI_NovedadesLayout.setHorizontalGroup(JPI_NovedadesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_NovedadesLayout.createSequentialGroup().addContainerGap().addGroup(JPI_NovedadesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDetalle1, -1, 955, 32767).addGroup(JPI_NovedadesLayout.createSequentialGroup().addComponent(this.txtFechaN, -2, 160, -2).addGap(29, 29, 29).addComponent(this.cboMotivos, -2, 300, -2).addGap(26, 26, 26).addComponent(this.JCHEstado).addGap(0, 0, 32767)).addComponent(this.JSPTablallamadas1, -1, 955, 32767)).addContainerGap()));
        JPI_NovedadesLayout.setVerticalGroup(JPI_NovedadesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_NovedadesLayout.createSequentialGroup().addContainerGap().addGroup(JPI_NovedadesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_NovedadesLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JCHEstado).addComponent(this.txtFechaN, -1, 58, 32767)).addComponent(this.cboMotivos, GroupLayout.Alignment.TRAILING, -2, 51, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPDetalle1, -2, 73, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPTablallamadas1, -1, 161, 32767).addContainerGap()));
        this.jTabbedPane1.addTab("NOVEDADES", this.JPI_Novedades);
        this.jPanel2.setBorder(BorderFactory.createEtchedBorder());
        this.JDFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Fin", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFechaF.setFont(new Font("Arial", 1, 12));
        this.JCBProceso.setFont(new Font("Arial", 1, 12));
        this.JCBProceso.setBorder(BorderFactory.createTitledBorder((Border) null, "Servicios", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: General.Llamadas.13
            public void mouseClicked(MouseEvent evt) {
                Llamadas.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTCarguesA1.setFont(new Font("Arial", 1, 12));
        this.JBTCarguesA1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTCarguesA1.setText("Exportar");
        this.JBTCarguesA1.addActionListener(new ActionListener() { // from class: General.Llamadas.14
            public void actionPerformed(ActionEvent evt) {
                Llamadas.this.JBTCarguesA1ActionPerformed(evt);
            }
        });
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.JDFechaI, -2, 116, -2).addGap(40, 40, 40).addComponent(this.JDFechaF, -2, 116, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBProceso, -2, 283, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFRuta).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBTCarguesA1, -2, 131, -2).addContainerGap()));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.JTFRuta, -2, 50, -2)).addComponent(this.JBTCarguesA1, -1, -1, 32767).addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDFechaI, -2, 50, -2).addComponent(this.JDFechaF, -2, 50, -2)).addComponent(this.JCBProceso, -2, 51, -2)).addGap(0, 0, 32767))).addContainerGap()));
        this.JSPTablallamadas.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTDetalleLlamadas.setBorder(BorderFactory.createBevelBorder(0));
        this.JTDetalleLlamadas.setFont(new Font("Arial", 1, 12));
        this.JTDetalleLlamadas.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalleLlamadas.setEditingColumn(1);
        this.JTDetalleLlamadas.setEditingRow(1);
        this.JTDetalleLlamadas.setRowHeight(25);
        this.JTDetalleLlamadas.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalleLlamadas.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalleLlamadas.addKeyListener(new KeyAdapter() { // from class: General.Llamadas.15
            public void keyReleased(KeyEvent evt) {
                Llamadas.this.JTDetalleLlamadasKeyReleased(evt);
            }
        });
        this.JSPTablallamadas.setViewportView(this.JTDetalleLlamadas);
        GroupLayout JPI_HistoricoLayout = new GroupLayout(this.JPI_Historico);
        this.JPI_Historico.setLayout(JPI_HistoricoLayout);
        JPI_HistoricoLayout.setHorizontalGroup(JPI_HistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_HistoricoLayout.createSequentialGroup().addContainerGap().addGroup(JPI_HistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel2, -1, -1, 32767).addComponent(this.JSPTablallamadas, -1, 965, 32767)).addContainerGap()));
        JPI_HistoricoLayout.setVerticalGroup(JPI_HistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_HistoricoLayout.createSequentialGroup().addContainerGap().addComponent(this.jPanel2, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPTablallamadas, -1, 239, 32767).addContainerGap()));
        this.jTabbedPane1.addTab("CONSULTAR HISTÓRICO", this.JPI_Historico);
        getContentPane().add(this.jTabbedPane1);
        this.jTabbedPane1.setBounds(10, 190, 990, 380);
        pack();
    }

    private void mActulizarFechaFaltante() {
        if (this.cboServicio.getSelectedItem().toString().equals("FARMACIA")) {
            this.sql = "update i_faltantes set Fecha_Llamada='" + this.xmt.formatoAMD.format(this.txtFecha.getDate()) + "' where Id='" + this.txtNumero.getText() + "'";
            this.consultas.ejecutarSQL(this.sql);
            this.consultas.cerrarConexionBd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnEmpacadoStateChanged(ChangeEvent evt) {
        if (this.btnEmpacado.isSelected()) {
            this.empacado = 1;
        } else {
            this.empacado = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gridKeyReleased(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboServicioActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboServicioItemStateChanged(ItemEvent evt) {
        if (this.cboLleno == 1 && this.cboServicio.getSelectedIndex() > -1) {
            if (this.cboServicio.getSelectedItem().toString().equals("FARMACIA")) {
                this.btnEmpacado.setEnabled(true);
            } else {
                this.btnEmpacado.setEnabled(false);
            }
            cargarLlamadas();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtNumeroFocusGained(FocusEvent evt) {
        this.txtNumero.selectAll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtRecibeLlamadaFocusGained(FocusEvent evt) {
        this.txtRecibeLlamada.selectAll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleLlamadasKeyReleased(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboMotivosItemStateChanged(ItemEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboMotivosActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEstadoActionPerformed(ActionEvent evt) {
        if (this.JCHEstado.isSelected()) {
            this.xestado = 1;
        } else {
            this.xestado = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleNovedadKeyReleased(KeyEvent evt) {
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
    public void JBTCarguesA1ActionPerformed(ActionEvent evt) {
        if (this.JTDetalleLlamadas.getRowCount() != -1) {
            int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalleLlamadas, this.JTFRuta.getText(), getTitle());
            }
        }
    }

    private void mIniciarComponentes() {
        this.JCBProceso.removeAllItems();
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        this.xservicios = this.consultas.llenarCombo("SELECT `Id`, `Nbre` FROM `f_tiposervicio` WHERE (`Estado` =0) ORDER BY Nbre;", this.xservicios, this.JCBProceso);
        this.JCBProceso.setSelectedIndex(-1);
        this.xlleno = true;
        this.consultas.cerrarConexionBd();
        this.JDFechaI.setDate(this.xmt.getFechaActual());
        this.JDFechaF.setDate(this.xmt.getFechaActual());
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloLlamadas() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"No. Documento", "Persona", "Teléfono", "Fecha Llamada", "Persona Contesta", "Detalle", "Usuario que llama", "Municipio"}) { // from class: General.Llamadas.16
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTDetalleLlamadas;
        JTable jTable2 = this.JTDetalleLlamadas;
        jTable.setAutoResizeMode(0);
        this.JTDetalleLlamadas.doLayout();
        this.JTDetalleLlamadas.setModel(this.xmodelo);
        this.JTDetalleLlamadas.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTDetalleLlamadas.getColumnModel().getColumn(1).setPreferredWidth(250);
        this.JTDetalleLlamadas.getColumnModel().getColumn(2).setPreferredWidth(150);
        this.JTDetalleLlamadas.getColumnModel().getColumn(3).setPreferredWidth(150);
        this.JTDetalleLlamadas.getColumnModel().getColumn(4).setPreferredWidth(200);
        this.JTDetalleLlamadas.getColumnModel().getColumn(5).setPreferredWidth(300);
        this.JTDetalleLlamadas.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTDetalleLlamadas.getColumnModel().getColumn(7).setPreferredWidth(100);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloNovedades() {
        this.xmodelo1 = new DefaultTableModel(new Object[0], new String[]{"No.", "Fecha", "TipoNovedad", "Descripcion", "Estado"}) { // from class: General.Llamadas.17
            Class[] types = {String.class, String.class, String.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalleNovedad.setModel(this.xmodelo1);
        this.JTDetalleNovedad.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTDetalleNovedad.getColumnModel().getColumn(1).setPreferredWidth(150);
        this.JTDetalleNovedad.getColumnModel().getColumn(2).setPreferredWidth(10);
        this.JTDetalleNovedad.getColumnModel().getColumn(3).setPreferredWidth(10);
        this.JTDetalleNovedad.getColumnModel().getColumn(4).setPreferredWidth(10);
    }

    private void mBuscarDatos() {
        mCrearModeloLlamadas();
        String sql = "SELECT  `g_persona`.`NoDocumento`,CONCAT(`g_persona`.`Nombre1`,' ', `g_persona`.`Nombre2`,' ', `g_persona`.`Nombre2`,' ' , `g_persona`.`Apellido1`,' ', `g_persona`.`Apellido2`)AS persona , `g_persona`.`Telefono` , `g_llamadas`.`FechaLlamada`, `g_llamadas`.`NbrePersonaContesta`, `g_llamadas`.`Detalle`, `g_llamadas`.`UsuarioS`, g_municipio.`Nbre` NMunicipio FROM `g_llamadas` INNER JOIN  `g_persona` ON (`g_llamadas`.`Id_Persona` = `g_persona`.`Id`) INNER JOIN  `g_municipio` ON  (`g_persona`.`Id_Municipio`= `g_municipio`.`Id`)  INNER JOIN  `f_tiposervicio`  ON (`g_llamadas`.`Id_TipoServicio` = `f_tiposervicio`.`Id`) WHERE (`g_llamadas`.`Id_TipoServicio` ='" + this.xservicios[this.JCBProceso.getSelectedIndex()] + "' AND DATE_FORMAT(`g_llamadas`.`FechaLlamada`, '%Y-%m-%d')>='" + this.xmt.formatoAMD1.format(this.JDFechaI.getDate()) + "' AND DATE_FORMAT(`g_llamadas`.`FechaLlamada`, '%Y-%m-%d')<='" + this.xmt.formatoAMD1.format(this.JDFechaF.getDate()) + "');";
        try {
            ResultSet xrs = this.consultas.traerRs(sql);
            TableColumnModel cmodel = this.JTDetalleLlamadas.getColumnModel();
            TextAreaRenderer textAreaRenderer = new TextAreaRenderer();
            cmodel.getColumn(5).setCellRenderer(textAreaRenderer);
            TextAreaEditor textEditor = new TextAreaEditor();
            cmodel.getColumn(5).setCellEditor(textEditor);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(xrs.getString(1), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelo.setValueAt(xrs.getString(4), n, 3);
                    this.xmodelo.setValueAt(xrs.getString(5), n, 4);
                    this.xmodelo.setValueAt(xrs.getString(6), n, 5);
                    this.xmodelo.setValueAt(xrs.getString(7), n, 6);
                    this.xmodelo.setValueAt(xrs.getString("NMunicipio"), n, 7);
                    n++;
                }
            }
            xrs.close();
            this.consultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(Llamadas.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mBuscarNovedad() {
        mCrearModeloNovedades();
        String sql = "SELECT\n    `g_persona_novedades`.`Id`\n    , `g_persona_novedades`.`FechaR`\n    , `g_tiponovedad`.`Nbre` AS `TipoNovedad`\n    , `g_persona_novedades`.`Observacion`\n    , `g_persona_novedades`.`Estado`\nFROM\n     `g_persona_novedades`\n    INNER JOIN  `g_tiponovedad` \n        ON (`g_persona_novedades`.`Id_TipoNovedad` = `g_tiponovedad`.`Id`)\n    INNER JOIN  `g_persona` \n        ON (`g_persona_novedades`.`Id_Persona` = `g_persona`.`Id`)\nWHERE (`g_persona`.`Id` =" + this.frmPersona.getIdPersona() + ");";
        try {
            ResultSet xrs = this.consultas.traerRs(sql);
            TableColumnModel cmodel = this.JTDetalleNovedad.getColumnModel();
            TextAreaRenderer textAreaRenderer = new TextAreaRenderer();
            cmodel.getColumn(3).setCellRenderer(textAreaRenderer);
            TextAreaEditor textEditor = new TextAreaEditor();
            cmodel.getColumn(3).setCellEditor(textEditor);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo1.addRow(this.xdatos);
                    this.xmodelo1.setValueAt(xrs.getString(1), n, 0);
                    this.xmodelo1.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo1.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelo1.setValueAt(xrs.getString(4), n, 3);
                    this.xmodelo1.setValueAt(Boolean.valueOf(xrs.getBoolean(5)), n, 4);
                    n++;
                }
            }
            xrs.close();
            this.consultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(Llamadas.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mBuscar() {
        if (this.JCBProceso.getSelectedIndex() != -1) {
            mBuscarDatos();
        } else {
            JOptionPane.showInternalMessageDialog(this, "Debe escoger un servicio", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBProceso.requestFocus();
        }
    }
}
