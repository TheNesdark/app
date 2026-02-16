package Autorizaciones;

import Acceso.Principal;
import General.Buscar;
import General.Persona;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.LayoutManager;
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
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

/* JADX INFO: loaded from: GenomaP.jar:Autorizaciones/Autoriza.class */
public class Autoriza extends JInternalFrame {
    private String[] listaPrestador;
    private String[] listaServicios;
    private String[] listaProfesional;
    public Persona frmPersona;
    private DefaultTableModel modelo;
    private DefaultTableModel modelo1;
    private int filaProcedimiento;
    private int filaAutorizados;
    private String sql;
    private ResultSet rs;
    private Object[] dato;
    private JButton btnDx;
    private ButtonGroup buttonGroup1;
    private JComboBox cboIPS;
    private JComboBox cboPrestador;
    private JComboBox cboProfesional;
    private JComboBox cboServicios;
    private JTable gridAutorizados;
    private JTable gridProcedimientos;
    private JCheckBox jCheckBox1;
    private JCheckBox jCheckBox2;
    private JCheckBox jCheckBox3;
    private JCheckBox jCheckBox4;
    private JLabel jLabel1;
    private JLabel jLabel10;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JLabel jLabel9;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JScrollPane jScrollPane3;
    private JSpinner jSpinner1;
    private JTabbedPane jTabbedPane1;
    private JPanel panelPersona;
    private JPanel pservicio;
    private JSpinner txtCantidad;
    private JTextField txtCodDx;
    private JTextField txtCodigo;
    private JLabel txtEstado;
    private JDateChooser txtFecha;
    private JTextField txtNbreDx;
    private JLabel txtNoAutorizacion;
    private JTextArea txtObservacion;
    private JTextField txtProcedimiento;
    private JFormattedTextField txtTotal;
    private ConsultasMySQL consultas = new ConsultasMySQL();
    private Metodos metodos = new Metodos();
    private GregorianCalendar fechaActual = new GregorianCalendar();
    private SimpleDateFormat formatoAMD = new SimpleDateFormat("yyyy/MM/dd");
    private SimpleDateFormat formatoAMDH = new SimpleDateFormat("yyyy/MM/dd HH:mm");
    private int cboLleno = 0;
    private int encontrado = 0;
    private Buscar buscar = new Buscar(null, true, "g_patologia");

    public Autoriza() {
        initComponents();
        cargarCombos();
        cargarPanelPersonas();
        crearGridAutorizados();
        nuevo();
        this.gridProcedimientos.addMouseListener(new MouseAdapter() { // from class: Autorizaciones.Autoriza.1
            public void mouseClicked(MouseEvent e) {
                Autoriza.this.filaProcedimiento = Autoriza.this.gridProcedimientos.rowAtPoint(e.getPoint());
                if (e.getClickCount() > 1) {
                    Autoriza.this.cargarGridAutorizados();
                }
            }
        });
    }

    private void buscarProcedimiento(int op) {
        crearGridProcedimientos();
        this.sql = "SELECT g_procedimiento.Id, g_procedimiento.Nbre, g_tarifaprocedimiento.Valor FROM  genoma.g_procedimiento INNER JOIN genoma.f_tipoprocedimiento ON (g_procedimiento.Id_tipoprocedimiento = f_tipoprocedimiento.Id) INNER JOIN genoma.f_tiposervtipoproced ON (f_tiposervtipoproced.Idtipoprocedimiento = f_tipoprocedimiento.Id) INNER JOIN genoma.g_tarifaprocedimiento ON (g_tarifaprocedimiento.Id_Procedimiento = g_procedimiento.Id) INNER JOIN genoma.g_prestador ON (g_tarifaprocedimiento.Id_Manual = g_prestador.Id_Manual) WHERE (g_prestador.Id ='" + this.listaPrestador[this.cboPrestador.getSelectedIndex()] + "' AND f_tiposervtipoproced.Idtiposervicio ='" + this.listaServicios[this.cboServicios.getSelectedIndex()] + "' AND g_procedimiento.Nbre like'" + this.txtProcedimiento.getText() + "%') ORDER BY g_procedimiento.Nbre ASC";
        this.rs = this.consultas.traerRs(this.sql);
        while (this.rs.next()) {
            try {
                this.modelo.addRow(this.dato);
                this.modelo.setValueAt(this.rs.getString(1), this.filaProcedimiento, 0);
                this.modelo.setValueAt(this.rs.getString(2), this.filaProcedimiento, 1);
                this.modelo.setValueAt(this.rs.getString(3), this.filaProcedimiento, 2);
                this.filaProcedimiento++;
            } catch (SQLException ex) {
                Logger.getLogger(Autoriza.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                return;
            }
        }
        this.rs.close();
        this.consultas.cerrarConexionBd();
    }

    private void cargarCombos() {
        this.cboLleno = 0;
        this.listaPrestador = this.consultas.llenarCombo("SELECT Id, Nbre FROM g_prestador WHERE Estado = 0 ORDER BY Nbre", this.listaPrestador, this.cboPrestador);
        this.listaPrestador = this.consultas.llenarCombo("SELECT Id, Nbre FROM g_prestador WHERE Estado = 0 ORDER BY Nbre", this.listaPrestador, this.cboIPS);
        this.listaProfesional = this.consultas.llenarCombo("SELECT Id, Nombre FROM genoma.v_profesionales", this.listaProfesional, this.cboProfesional);
        this.cboPrestador.setSelectedIndex(-1);
        this.cboIPS.setSelectedIndex(-1);
        this.cboProfesional.setSelectedIndex(-1);
        this.cboLleno = 1;
    }

    private void cargarCboServicios() {
        this.cboLleno = 0;
        this.cboServicios.removeAllItems();
        this.listaServicios = this.consultas.llenarCombo("SELECT f_tiposervicio.Id, f_tiposervicio.Nbre FROM genoma.f_servicioxprestador INNER JOIN genoma.f_tiposervicio ON (f_servicioxprestador.Id_TipoServicio = f_tiposervicio.Id) WHERE (f_tiposervicio.Estado =0 AND f_servicioxprestador.Id_Prestador ='" + this.listaPrestador[this.cboPrestador.getSelectedIndex()] + "' AND f_tiposervicio.EsAmbulatorio=0) ORDER BY f_tiposervicio.Nbre", this.listaServicios, this.cboServicios);
        this.cboLleno = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cargarGridAutorizados() {
        this.encontrado = 0;
        int f = 0;
        while (true) {
            if (f >= this.modelo1.getRowCount()) {
                break;
            }
            if (!this.modelo1.getValueAt(f, 0).equals(this.modelo.getValueAt(this.filaProcedimiento, 0))) {
                f++;
            } else {
                this.filaAutorizados = f;
                this.encontrado = 1;
                break;
            }
        }
        if (this.encontrado == 0) {
            this.modelo1.addRow(this.dato);
        }
        int v = Integer.parseInt(this.modelo.getValueAt(this.filaProcedimiento, 2).toString()) * Integer.parseInt(this.txtCantidad.getValue().toString());
        this.modelo1.setValueAt(this.modelo.getValueAt(this.filaProcedimiento, 0), this.filaAutorizados, 0);
        this.modelo1.setValueAt(this.modelo.getValueAt(this.filaProcedimiento, 1), this.filaAutorizados, 1);
        this.modelo1.setValueAt(this.txtCantidad.getValue(), this.filaAutorizados, 2);
        this.modelo1.setValueAt(this.modelo.getValueAt(this.filaProcedimiento, 2), this.filaAutorizados, 3);
        this.modelo1.setValueAt(Integer.valueOf(v), this.filaAutorizados, 4);
        this.txtTotal.setValue(Integer.valueOf(Integer.parseInt(this.modelo1.getValueAt(this.filaAutorizados, 3).toString())));
        this.filaAutorizados++;
    }

    private void cargarPanelPersonas() {
        this.frmPersona = new Persona(this);
        this.panelPersona.add(this.frmPersona);
        this.panelPersona.setVisible(true);
    }

    private void crearGridProcedimientos() {
        this.modelo = new DefaultTableModel() { // from class: Autorizaciones.Autoriza.2
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.modelo.addColumn("Codigo");
        this.modelo.addColumn("Nombre del Procedimiento");
        this.modelo.addColumn("Valor");
        this.gridProcedimientos.setModel(this.modelo);
        this.gridProcedimientos.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.gridProcedimientos.getColumnModel().getColumn(1).setPreferredWidth(600);
        this.gridProcedimientos.getColumnModel().getColumn(2).setPreferredWidth(150);
        this.gridProcedimientos.getColumnModel().getColumn(0).setMinWidth(80);
        this.gridProcedimientos.getColumnModel().getColumn(0).setMaxWidth(80);
        this.gridProcedimientos.getColumnModel().getColumn(1).setMinWidth(600);
        this.gridProcedimientos.getColumnModel().getColumn(1).setMaxWidth(600);
        this.gridProcedimientos.getColumnModel().getColumn(2).setMinWidth(150);
        this.gridProcedimientos.getColumnModel().getColumn(2).setMaxWidth(150);
        this.filaProcedimiento = 0;
    }

    private void crearGridAutorizados() {
        this.modelo1 = new DefaultTableModel() { // from class: Autorizaciones.Autoriza.3
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.modelo1.addColumn("Codigo");
        this.modelo1.addColumn("Nombre del Servicio");
        this.modelo1.addColumn("Cantidad");
        this.modelo1.addColumn("Valor");
        this.modelo1.addColumn("Total");
        this.gridAutorizados.setModel(this.modelo1);
        this.gridAutorizados.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.gridAutorizados.getColumnModel().getColumn(1).setPreferredWidth(600);
        this.gridAutorizados.getColumnModel().getColumn(2).setPreferredWidth(80);
        this.gridAutorizados.getColumnModel().getColumn(3).setPreferredWidth(120);
        this.gridAutorizados.getColumnModel().getColumn(4).setPreferredWidth(120);
        this.gridAutorizados.getColumnModel().getColumn(0).setMinWidth(80);
        this.gridAutorizados.getColumnModel().getColumn(0).setMaxWidth(80);
        this.gridAutorizados.getColumnModel().getColumn(1).setMinWidth(600);
        this.gridAutorizados.getColumnModel().getColumn(1).setMaxWidth(600);
        this.gridAutorizados.getColumnModel().getColumn(2).setMinWidth(80);
        this.gridAutorizados.getColumnModel().getColumn(2).setMaxWidth(80);
        this.gridAutorizados.getColumnModel().getColumn(3).setMinWidth(120);
        this.gridAutorizados.getColumnModel().getColumn(3).setMaxWidth(120);
        this.gridAutorizados.getColumnModel().getColumn(4).setMinWidth(120);
        this.gridAutorizados.getColumnModel().getColumn(4).setMaxWidth(120);
        this.filaAutorizados = 0;
    }

    private int getDatosCompletos() {
        int resp = 0;
        if (this.cboIPS.getSelectedIndex() < 0) {
            this.metodos.mostrarMensaje("Por favor seleccione la IPS o Profesional que solicita la Autorización");
            this.cboIPS.requestFocus();
        } else if (this.cboPrestador.getSelectedIndex() < 0) {
            this.metodos.mostrarMensaje("Por favor seleccione al Prestador de Servicio a quien se Autorizará");
            this.cboPrestador.requestFocus();
        } else if (this.cboProfesional.getSelectedIndex() < 0) {
            this.metodos.mostrarMensaje("Por favor seleccione el Profesional que Solicitó la Autorización");
            this.cboProfesional.requestFocus();
        } else if (this.txtCodDx.getText().isEmpty()) {
            this.metodos.mostrarMensaje("Por favor asigne un Diagnostico");
            this.txtCodDx.requestFocus();
        } else if (this.txtFecha.getDate() == null) {
            this.metodos.mostrarMensaje("Por favor escriba una Fecha de Atención");
            this.txtFecha.requestFocus();
        } else if (this.gridAutorizados.getRowCount() < 0) {
            this.metodos.mostrarMensaje("Por favor seleccione los Procedimientos que Autorizará");
        } else {
            resp = 1;
        }
        return resp;
    }

    public void grabar() {
    }

    private void grabarCabecera() {
        this.sql = "INSERT INTO a_autorizacion (Id_Persona, Id_Prestador, Id_Profesional, Id_Solicita, FechaAutoriz, Observacion, Fecha, UsuarioS) VALUES('" + this.frmPersona.getIdPersona() + "','" + this.listaPrestador[this.cboPrestador.getSelectedIndex()] + "','" + this.listaProfesional[this.cboProfesional.getSelectedIndex()] + "','" + this.listaPrestador[this.cboIPS.getSelectedIndex()] + "','" + this.formatoAMD.format(this.txtFecha.getDate()) + "','" + this.txtObservacion.getText() + "','" + this.formatoAMDH.format(this.fechaActual.getTime()) + "','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "')";
        this.txtNoAutorizacion.setText(this.consultas.ejecutarSQLId(this.sql));
    }

    private void grabarDetalle() {
        for (int f = 0; f < this.gridAutorizados.getRowCount(); f++) {
            this.sql = "INSERT INTO a_detalle_autorizacion (Id_Autorizacion, Id_Procedimiento, Cantidad, VrUnitario) VALUES('" + this.txtNoAutorizacion.getText() + "','" + this.modelo1.getValueAt(f, 0) + "','" + this.modelo1.getValueAt(f, 2) + "','" + this.modelo1.getValueAt(f, 3) + "')";
            this.consultas.ejecutarSQL(this.sql);
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0007. Please report as an issue. */
    public void navegar(int registro) {
        this.sql = "";
        switch (registro) {
        }
    }

    public void nuevo() {
        this.frmPersona.nuevo();
        this.txtFecha.setDate(this.fechaActual.getTime());
        this.txtEstado.setText("Activa");
        this.txtNoAutorizacion.setText("0");
        this.cboServicios.setSelectedIndex(-1);
        this.txtCodigo.setText("");
        this.txtProcedimiento.setText("");
        crearGridProcedimientos();
        crearGridAutorizados();
    }

    /* JADX WARN: Type inference failed for: r3v19, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.buttonGroup1 = new ButtonGroup();
        this.panelPersona = new JPanel();
        this.jTabbedPane1 = new JTabbedPane();
        this.pservicio = new JPanel();
        this.jScrollPane1 = new JScrollPane();
        this.gridAutorizados = new JTable();
        this.jPanel3 = new JPanel();
        this.txtCodigo = new JTextField();
        this.jLabel1 = new JLabel();
        this.txtProcedimiento = new JTextField();
        this.jScrollPane2 = new JScrollPane();
        this.gridProcedimientos = new JTable();
        this.cboServicios = new JComboBox();
        this.jLabel4 = new JLabel();
        this.jLabel5 = new JLabel();
        this.txtCantidad = new JSpinner();
        this.jScrollPane3 = new JScrollPane();
        this.txtObservacion = new JTextArea();
        this.jLabel6 = new JLabel();
        this.jLabel7 = new JLabel();
        this.cboIPS = new JComboBox();
        this.jLabel8 = new JLabel();
        this.cboProfesional = new JComboBox();
        this.jLabel3 = new JLabel();
        this.cboPrestador = new JComboBox();
        this.txtCodDx = new JTextField();
        this.txtNbreDx = new JTextField();
        this.jLabel9 = new JLabel();
        this.jLabel10 = new JLabel();
        this.btnDx = new JButton();
        this.jPanel1 = new JPanel();
        this.jSpinner1 = new JSpinner();
        this.jCheckBox1 = new JCheckBox();
        this.jCheckBox2 = new JCheckBox();
        this.jCheckBox3 = new JCheckBox();
        this.jCheckBox4 = new JCheckBox();
        this.jPanel2 = new JPanel();
        this.txtNoAutorizacion = new JLabel();
        this.txtFecha = new JDateChooser();
        this.txtEstado = new JLabel();
        this.txtTotal = new JFormattedTextField();
        setMaximumSize(new Dimension(1233, 616));
        setMinimumSize(new Dimension(1233, 616));
        setName("Autoriza");
        setPreferredSize(new Dimension(1233, 616));
        getContentPane().setLayout(new AbsoluteLayout());
        this.panelPersona.setBackground(new Color(204, 255, 204));
        getContentPane().add(this.panelPersona, new AbsoluteConstraints(0, 0, 1020, 150));
        this.pservicio.setLayout((LayoutManager) null);
        this.gridAutorizados.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.jScrollPane1.setViewportView(this.gridAutorizados);
        this.pservicio.add(this.jScrollPane1);
        this.jScrollPane1.setBounds(10, 10, 1000, 110);
        this.jTabbedPane1.addTab("Servicios Autorizados", this.pservicio);
        getContentPane().add(this.jTabbedPane1, new AbsoluteConstraints(0, 420, 1020, 160));
        this.jPanel3.setBackground(new Color(204, 255, 204));
        this.jPanel3.setBorder(BorderFactory.createTitledBorder("Datos de la Autorización"));
        this.jPanel3.setLayout((LayoutManager) null);
        this.txtCodigo.setBorder(BorderFactory.createEtchedBorder());
        this.txtCodigo.setFocusAccelerator('C');
        this.txtCodigo.addActionListener(new ActionListener() { // from class: Autorizaciones.Autoriza.4
            public void actionPerformed(ActionEvent evt) {
                Autoriza.this.txtCodigoActionPerformed(evt);
            }
        });
        this.txtCodigo.addFocusListener(new FocusAdapter() { // from class: Autorizaciones.Autoriza.5
            public void focusLost(FocusEvent evt) {
                Autoriza.this.txtCodigoFocusLost(evt);
            }
        });
        this.jPanel3.add(this.txtCodigo);
        this.txtCodigo.setBounds(10, 140, 80, 25);
        this.jLabel1.setDisplayedMnemonic('C');
        this.jLabel1.setForeground(new Color(0, 0, 153));
        this.jLabel1.setText("Nombre del Procedimiento");
        this.jPanel3.add(this.jLabel1);
        this.jLabel1.setBounds(100, 120, 150, 14);
        this.jLabel1.getAccessibleContext().setAccessibleParent(this.txtCodigo);
        this.txtProcedimiento.setBorder(BorderFactory.createEtchedBorder());
        this.txtProcedimiento.setFocusAccelerator('C');
        this.txtProcedimiento.addActionListener(new ActionListener() { // from class: Autorizaciones.Autoriza.6
            public void actionPerformed(ActionEvent evt) {
                Autoriza.this.txtProcedimientoActionPerformed(evt);
            }
        });
        this.txtProcedimiento.addKeyListener(new KeyAdapter() { // from class: Autorizaciones.Autoriza.7
            public void keyTyped(KeyEvent evt) {
                Autoriza.this.txtProcedimientoKeyTyped(evt);
            }
        });
        this.jPanel3.add(this.txtProcedimiento);
        this.txtProcedimiento.setBounds(100, 140, 710, 25);
        this.gridProcedimientos.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.jScrollPane2.setViewportView(this.gridProcedimientos);
        this.jPanel3.add(this.jScrollPane2);
        this.jScrollPane2.setBounds(10, 170, 870, 80);
        this.jPanel3.add(this.cboServicios);
        this.cboServicios.setBounds(630, 90, 250, 25);
        this.jLabel4.setDisplayedMnemonic('C');
        this.jLabel4.setText("Cantidad");
        this.jPanel3.add(this.jLabel4);
        this.jLabel4.setBounds(820, 120, 50, 14);
        this.jLabel5.setDisplayedMnemonic('C');
        this.jLabel5.setForeground(new Color(0, 0, 153));
        this.jLabel5.setText("Código");
        this.jPanel3.add(this.jLabel5);
        this.jLabel5.setBounds(10, 120, 50, 14);
        this.txtCantidad.setModel(new SpinnerNumberModel(1, 1, (Comparable) null, 1));
        this.txtCantidad.addFocusListener(new FocusAdapter() { // from class: Autorizaciones.Autoriza.8
            public void focusGained(FocusEvent evt) {
                Autoriza.this.txtCantidadFocusGained(evt);
            }
        });
        this.jPanel3.add(this.txtCantidad);
        this.txtCantidad.setBounds(820, 140, 60, 25);
        this.txtObservacion.setColumns(20);
        this.txtObservacion.setRows(5);
        this.txtObservacion.setBorder(BorderFactory.createTitledBorder("Observaciones"));
        this.jScrollPane3.setViewportView(this.txtObservacion);
        this.jPanel3.add(this.jScrollPane3);
        this.jScrollPane3.setBounds(900, 90, 310, 160);
        this.jLabel6.setDisplayedMnemonic('C');
        this.jLabel6.setForeground(new Color(0, 0, 153));
        this.jLabel6.setText("Servicio");
        this.jPanel3.add(this.jLabel6);
        this.jLabel6.setBounds(630, 70, 50, 14);
        this.jLabel7.setDisplayedMnemonic('C');
        this.jLabel7.setForeground(new Color(0, 51, 153));
        this.jLabel7.setText("IPS o Profesional que Solicita");
        this.jPanel3.add(this.jLabel7);
        this.jLabel7.setBounds(10, 70, 160, 14);
        this.cboIPS.addItemListener(new ItemListener() { // from class: Autorizaciones.Autoriza.9
            public void itemStateChanged(ItemEvent evt) {
                Autoriza.this.cboIPSItemStateChanged(evt);
            }
        });
        this.jPanel3.add(this.cboIPS);
        this.cboIPS.setBounds(10, 90, 180, 25);
        this.jLabel8.setDisplayedMnemonic('C');
        this.jLabel8.setForeground(new Color(0, 51, 153));
        this.jLabel8.setText("Profesional");
        this.jPanel3.add(this.jLabel8);
        this.jLabel8.setBounds(200, 70, 80, 14);
        this.cboProfesional.addItemListener(new ItemListener() { // from class: Autorizaciones.Autoriza.10
            public void itemStateChanged(ItemEvent evt) {
                Autoriza.this.cboProfesionalItemStateChanged(evt);
            }
        });
        this.jPanel3.add(this.cboProfesional);
        this.cboProfesional.setBounds(200, 90, 230, 25);
        this.jLabel3.setDisplayedMnemonic('C');
        this.jLabel3.setForeground(new Color(0, 51, 153));
        this.jLabel3.setText("Diagnostico Principal");
        this.jPanel3.add(this.jLabel3);
        this.jLabel3.setBounds(100, 20, 140, 14);
        this.cboPrestador.addItemListener(new ItemListener() { // from class: Autorizaciones.Autoriza.11
            public void itemStateChanged(ItemEvent evt) {
                Autoriza.this.cboPrestadorItemStateChanged(evt);
            }
        });
        this.jPanel3.add(this.cboPrestador);
        this.cboPrestador.setBounds(440, 90, 180, 25);
        this.jPanel3.add(this.txtCodDx);
        this.txtCodDx.setBounds(10, 40, 80, 25);
        this.jPanel3.add(this.txtNbreDx);
        this.txtNbreDx.setBounds(100, 40, 710, 25);
        this.jLabel9.setDisplayedMnemonic('C');
        this.jLabel9.setForeground(new Color(0, 51, 153));
        this.jLabel9.setText("Prestador");
        this.jPanel3.add(this.jLabel9);
        this.jLabel9.setBounds(440, 70, 80, 14);
        this.jLabel10.setDisplayedMnemonic('C');
        this.jLabel10.setForeground(new Color(0, 51, 153));
        this.jLabel10.setText("Código de Dx");
        this.jPanel3.add(this.jLabel10);
        this.jLabel10.setBounds(10, 20, 80, 14);
        this.btnDx.setText("...");
        this.btnDx.addActionListener(new ActionListener() { // from class: Autorizaciones.Autoriza.12
            public void actionPerformed(ActionEvent evt) {
                Autoriza.this.btnDxActionPerformed(evt);
            }
        });
        this.jPanel3.add(this.btnDx);
        this.btnDx.setBounds(820, 40, 60, 30);
        this.jPanel1.setBorder(BorderFactory.createTitledBorder("Tiempo de Evolución"));
        this.jSpinner1.setPreferredSize(new Dimension(60, 25));
        this.jPanel1.add(this.jSpinner1);
        this.buttonGroup1.add(this.jCheckBox1);
        this.jCheckBox1.setText("Horas");
        this.jPanel1.add(this.jCheckBox1);
        this.buttonGroup1.add(this.jCheckBox2);
        this.jCheckBox2.setText("Días");
        this.jPanel1.add(this.jCheckBox2);
        this.buttonGroup1.add(this.jCheckBox3);
        this.jCheckBox3.setText("Meses");
        this.jPanel1.add(this.jCheckBox3);
        this.buttonGroup1.add(this.jCheckBox4);
        this.jCheckBox4.setText("Años");
        this.jPanel1.add(this.jCheckBox4);
        this.jPanel3.add(this.jPanel1);
        this.jPanel1.setBounds(910, 10, 310, 60);
        getContentPane().add(this.jPanel3, new AbsoluteConstraints(0, 150, 1220, 260));
        this.jPanel2.setBackground(new Color(0, 51, 102));
        this.jPanel2.setLayout(new AbsoluteLayout());
        this.txtNoAutorizacion.setFont(new Font("Tahoma", 1, 14));
        this.txtNoAutorizacion.setHorizontalAlignment(4);
        this.txtNoAutorizacion.setText("0");
        this.txtNoAutorizacion.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Autorización", 0, 0, new Font("Tahoma", 0, 11), new Color(204, 255, 204)));
        this.jPanel2.add(this.txtNoAutorizacion, new AbsoluteConstraints(0, 10, 200, 80));
        this.txtFecha.setBackground(new Color(0, 51, 102));
        this.txtFecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Tahoma", 0, 11), new Color(204, 255, 204)));
        this.txtFecha.setDateFormatString("dd/MM/yyyy");
        this.jPanel2.add(this.txtFecha, new AbsoluteConstraints(0, 90, 120, 60));
        this.txtEstado.setBackground(new Color(0, 51, 102));
        this.txtEstado.setFont(new Font("Tahoma", 1, 11));
        this.txtEstado.setForeground(new Color(204, 255, 204));
        this.txtEstado.setHorizontalAlignment(0);
        this.txtEstado.setText("Activa");
        this.txtEstado.setBorder(BorderFactory.createTitledBorder((Border) null, "Estado", 0, 0, new Font("Tahoma", 0, 11), new Color(204, 255, 204)));
        this.jPanel2.add(this.txtEstado, new AbsoluteConstraints(120, 90, 80, 60));
        getContentPane().add(this.jPanel2, new AbsoluteConstraints(1020, 0, 200, 150));
        this.txtTotal.setBackground(new Color(0, 51, 102));
        this.txtTotal.setBorder(BorderFactory.createTitledBorder((Border) null, "Total", 0, 0, new Font("Tahoma", 0, 11), new Color(204, 255, 204)));
        this.txtTotal.setHorizontalAlignment(4);
        this.txtTotal.setText("0");
        this.txtTotal.setDisabledTextColor(new Color(255, 255, 255));
        this.txtTotal.setEnabled(false);
        this.txtTotal.setFont(new Font("Tahoma", 1, 18));
        getContentPane().add(this.txtTotal, new AbsoluteConstraints(1030, 440, 190, 130));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtCodigoActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtProcedimientoActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtCodigoFocusLost(FocusEvent evt) {
        buscarProcedimiento(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtProcedimientoKeyTyped(KeyEvent evt) {
        buscarProcedimiento(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboPrestadorItemStateChanged(ItemEvent evt) {
        if (this.cboLleno != 1 || this.cboPrestador.getSelectedIndex() <= -1) {
            return;
        }
        cargarCboServicios();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtCantidadFocusGained(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboProfesionalItemStateChanged(ItemEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboIPSItemStateChanged(ItemEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnDxActionPerformed(ActionEvent evt) {
        this.buscar.setVisible(true);
    }
}
