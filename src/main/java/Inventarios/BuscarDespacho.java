package Inventarios;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

/* JADX INFO: loaded from: GenomaP.jar:Inventarios/BuscarDespacho.class */
public class BuscarDespacho extends JDialog {
    private Metodos metodos;
    private ConsultasMySQL consultas;
    private Object[] dato;
    private int filaGrid;
    private int cboLleno;
    private String sql;
    private String codigo;
    private String[] listaTipoMovimiento;
    public DefaultTableModel modelo;
    private claseInventario claseInv;
    private JButton btnAceptar;
    private JButton btnBuscar;
    private JButton btnLimpiar;
    private JButton btnSalir;
    private JComboBox cboTipoMovimiento;
    private JTable grid;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JScrollPane jScrollPane1;
    private JTextField txtApellido1;
    private JTextField txtApellido2;
    private JTextField txtDespacho;
    private JDateChooser txtFechaFin;
    private JDateChooser txtFechaIni;
    private JTextField txtHistoria;
    private JTextField txtNombre1;
    private JTextField txtNombre2;
    private JLabel txtTitulo;

    public BuscarDespacho(Frame parent, boolean modal, String nn, claseInventario ClaseInv) {
        super(parent, modal);
        this.metodos = new Metodos();
        this.consultas = new ConsultasMySQL();
        this.filaGrid = 0;
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        setLocationRelativeTo(null);
        this.claseInv = ClaseInv;
        this.codigo = nn;
        limpiar();
        this.grid.addMouseListener(new MouseAdapter() { // from class: Inventarios.BuscarDespacho.1
            public void mouseClicked(MouseEvent e) {
                BuscarDespacho.this.filaGrid = BuscarDespacho.this.grid.rowAtPoint(e.getPoint());
            }
        });
    }

    public void buscarDespacho() {
        this.sql = "SELECT i_salidas.Id,  0 as NFaltante, i_salidas.FechaSalida, i_tiposmovimientos.Nbre, i_salidas.OrdenH,\nw_persona.NoHistoria, w_persona.NUsuario, w_profesional.NProfesional, i_salidas.Estado, f_empresacontxconvenio.Nbre, DATE_FORMAT(`i_salidas`.`Fecha`,'%H:%m:%s') AS Hora, CONCAT(`g_persona`.`Apellido1`,' ',`g_persona`.`Apellido2`,' ',`g_persona`.`Nombre1`,' ',`g_persona`.`Nombre2`) AS Despachador\nFROM i_salidas INNER JOIN i_tiposmovimientos\nON (i_salidas.IdTipoMovimiento = i_tiposmovimientos.Id) INNER JOIN w_persona\nON (w_persona.Id_persona = i_salidas.IdDestino) INNER JOIN w_profesional\nON (i_salidas.IdProfesional = w_profesional.Id_Persona) INNER JOIN f_empresacontxconvenio\nON (i_salidas.Eps = f_empresacontxconvenio.Id)\nINNER JOIN g_usuario_sist ON (i_salidas.`UsuarioS`=`g_usuario_sist`.`Login`)\nINNER JOIN `g_persona` ON (g_persona.`Id`=`g_usuario_sist`.`Id_Persona`)\nWHERE (i_salidas.Destino =0 ";
        if (!this.txtDespacho.getText().isEmpty()) {
            this.sql += "AND i_salidas.Id = '" + this.txtDespacho.getText() + "' and i_salidas.IdBodega='" + this.claseInv.getIdBodega() + "' ";
        }
        if (this.txtFechaIni.getDate() != null) {
            this.sql += "AND i_salidas.FechaSalida >= '" + this.metodos.formatoAMD.format(this.txtFechaIni.getDate()) + "' ";
        }
        if (this.txtFechaFin.getDate() != null) {
            this.sql += " AND i_salidas.FechaSalida <= '" + this.metodos.formatoAMD.format(this.txtFechaFin.getDate()) + "' ";
        }
        if (this.cboTipoMovimiento.getSelectedIndex() > -1) {
            this.sql += "AND i_salidas.IdTipoMovimiento = '" + this.listaTipoMovimiento[this.cboTipoMovimiento.getSelectedIndex()] + "' ";
        }
        if (!this.txtHistoria.getText().isEmpty()) {
            this.sql += "AND w_persona.NoHistoria = '" + this.txtHistoria.getText() + "' ";
        }
        if (!this.txtApellido1.getText().isEmpty()) {
            this.sql += "AND g_persona.Apellido1 = '" + this.txtApellido1.getText() + "' ";
        }
        if (!this.txtApellido2.getText().isEmpty()) {
            this.sql += "AND g_persona.Apellido2 ='" + this.txtApellido2.getText() + "' ";
        }
        if (!this.txtNombre1.getText().isEmpty()) {
            this.sql += "AND g_persona.Nombre1 ='" + this.txtNombre1.getText() + "' ";
        }
        if (!this.txtNombre2.getText().isEmpty()) {
            this.sql += "AND g_persona.Nombre2 ='" + this.txtNombre2.getText() + "' ";
        }
        this.sql += ")  GROUP BY i_salidas.Id ORDER BY i_salidas.FechaSalida desc";
        ResultSet rs = this.consultas.traerRs(this.sql);
        crearGrid();
        try {
            if (rs.next()) {
                rs.beforeFirst();
                while (rs.next()) {
                    this.modelo.addRow(this.dato);
                    this.modelo.setValueAt(rs.getString(1), this.filaGrid, 0);
                    this.modelo.setValueAt(rs.getString(2), this.filaGrid, 1);
                    this.modelo.setValueAt(this.metodos.formatoDMA.format((Date) rs.getDate(3)), this.filaGrid, 2);
                    this.modelo.setValueAt(rs.getString(4), this.filaGrid, 3);
                    this.modelo.setValueAt(rs.getString(5), this.filaGrid, 4);
                    this.modelo.setValueAt(rs.getString(6), this.filaGrid, 5);
                    this.modelo.setValueAt(rs.getString(7), this.filaGrid, 6);
                    this.modelo.setValueAt(rs.getString(8), this.filaGrid, 7);
                    if (rs.getInt(9) == 0) {
                        this.modelo.setValueAt("ACTIVA", this.filaGrid, 8);
                    } else {
                        this.modelo.setValueAt("ANULADA", this.filaGrid, 8);
                    }
                    this.modelo.setValueAt(rs.getString(10), this.filaGrid, 9);
                    this.modelo.setValueAt(rs.getString(11), this.filaGrid, 10);
                    this.modelo.setValueAt(rs.getString(12), this.filaGrid, 11);
                    this.filaGrid++;
                }
            }
            this.filaGrid--;
            rs.close();
            this.consultas.cerrarConexionBd();
        } catch (SQLException ex) {
            this.metodos.mostrarErrorE(ex);
        }
    }

    public void cargarCombos() {
        this.listaTipoMovimiento = this.consultas.llenarCombo("SELECT Id, Nbre FROM i_tiposmovimientos WHERE TipoMovimiento = 1 AND Bodega = '" + this.claseInv.getIdBodega() + "' AND Despacho = 1 ORDER BY Nbre ", this.listaTipoMovimiento, this.cboTipoMovimiento);
        this.cboTipoMovimiento.setSelectedIndex(-1);
        this.cboLleno = 1;
        this.consultas.cerrarConexionBd();
    }

    private void cargarDespacho() {
        if (this.filaGrid < 0 || this.filaGrid > this.modelo.getRowCount()) {
            this.metodos.mostrarMensaje("Por favor seleccione un Despacho para mostrar");
            return;
        }
        Principal.txtNo.setText(this.modelo.getValueAt(this.filaGrid, 0).toString());
        Principal.txtFecha.setText(this.modelo.getValueAt(this.filaGrid, 2).toString());
        this.claseInv.frmDespacho.txtNoFaltante.setText(this.modelo.getValueAt(this.filaGrid, 1).toString());
        this.claseInv.frmDespacho.txtFecha.setDate(this.metodos.getPasarTextoAFecha(this.modelo.getValueAt(this.filaGrid, 2).toString()));
        this.claseInv.frmDespacho.cboTipoMovimiento.setSelectedItem(this.modelo.getValueAt(this.filaGrid, 3).toString());
        this.claseInv.frmDespacho.cboEps.setSelectedItem(this.modelo.getValueAt(this.filaGrid, 9).toString());
        this.claseInv.frmDespacho.txtOrden.setText(this.modelo.getValueAt(this.filaGrid, 4).toString());
        this.claseInv.frmDespacho.cboProfesional.setSelectedItem(this.modelo.getValueAt(this.filaGrid, 7).toString());
        if (this.modelo.getValueAt(this.filaGrid, 8).toString().equals("ACTIVA")) {
            this.metodos.marcarEstado(0);
        } else {
            this.metodos.marcarEstado(1);
        }
        this.claseInv.frmDespacho.frmPersona.txtHistoria.setText(this.modelo.getValueAt(this.filaGrid, 5).toString());
        this.claseInv.frmDespacho.frmPersona.buscar(2);
        this.claseInv.frmDespacho.cargarDespacho();
        dispose();
    }

    public void crearGrid() {
        this.modelo = new DefaultTableModel() { // from class: Inventarios.BuscarDespacho.2
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.modelo.addColumn("Despacho");
        this.modelo.addColumn("Faltante");
        this.modelo.addColumn("Fecha");
        this.modelo.addColumn("Tipo Mvto");
        this.modelo.addColumn("Orden");
        this.modelo.addColumn("Historia Clínica");
        this.modelo.addColumn("Paciente");
        this.modelo.addColumn("Profesional");
        this.modelo.addColumn("Estado");
        this.modelo.addColumn("Empresa / EPS");
        this.modelo.addColumn("Hora");
        this.modelo.addColumn("Despachador");
        JTable jTable = this.grid;
        JTable jTable2 = this.grid;
        jTable.setAutoResizeMode(0);
        this.grid.setModel(this.modelo);
        this.grid.setModel(this.modelo);
        this.grid.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.grid.getColumnModel().getColumn(1).setPreferredWidth(80);
        this.grid.getColumnModel().getColumn(2).setPreferredWidth(110);
        this.grid.getColumnModel().getColumn(3).setPreferredWidth(300);
        this.grid.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(5).setPreferredWidth(120);
        this.grid.getColumnModel().getColumn(6).setPreferredWidth(300);
        this.grid.getColumnModel().getColumn(7).setPreferredWidth(300);
        this.grid.getColumnModel().getColumn(8).setPreferredWidth(80);
        this.grid.getColumnModel().getColumn(9).setPreferredWidth(300);
        this.grid.getColumnModel().getColumn(10).setPreferredWidth(80);
        this.grid.getColumnModel().getColumn(11).setPreferredWidth(300);
        this.filaGrid = 0;
    }

    private void limpiar() {
        this.txtDespacho.setText("");
        this.txtFechaIni.setDate((Date) null);
        this.txtFechaFin.setDate((Date) null);
        this.cboTipoMovimiento.setSelectedIndex(-1);
        this.txtHistoria.setText(this.codigo);
        this.txtApellido1.setText("");
        this.txtApellido2.setText("");
        this.txtNombre1.setText("");
        this.txtNombre2.setText("");
        crearGrid();
        this.txtDespacho.requestFocus();
    }

    /* JADX WARN: Type inference failed for: r3v56, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.txtTitulo = new JLabel();
        this.jPanel2 = new JPanel();
        this.txtDespacho = new JTextField();
        this.txtFechaFin = new JDateChooser();
        this.cboTipoMovimiento = new JComboBox();
        this.btnBuscar = new JButton();
        this.txtNombre2 = new JTextField();
        this.txtHistoria = new JTextField();
        this.txtApellido1 = new JTextField();
        this.txtApellido2 = new JTextField();
        this.txtNombre1 = new JTextField();
        this.txtFechaIni = new JDateChooser();
        this.jScrollPane1 = new JScrollPane();
        this.grid = new JTable();
        this.jPanel3 = new JPanel();
        this.btnAceptar = new JButton();
        this.btnSalir = new JButton();
        this.btnLimpiar = new JButton();
        setDefaultCloseOperation(2);
        setName("BuscarDespacho");
        getContentPane().setLayout(new AbsoluteLayout());
        this.txtTitulo.setBackground(new Color(255, 255, 255));
        this.txtTitulo.setFont(new Font("Arial", 1, 14));
        this.txtTitulo.setForeground(new Color(0, 102, 0));
        this.txtTitulo.setHorizontalAlignment(0);
        this.txtTitulo.setText("BUSQUEDA DE DESPACHOS");
        this.txtTitulo.setOpaque(true);
        getContentPane().add(this.txtTitulo, new AbsoluteConstraints(0, 0, 920, 40));
        this.jPanel2.setBorder(BorderFactory.createTitledBorder((Border) null, "CRITERIO DE BUSQUEDA", 0, 0, new Font("Tahoma", 1, 14), new Color(255, 0, 0)));
        this.jPanel2.setLayout((LayoutManager) null);
        this.txtDespacho.setHorizontalAlignment(4);
        this.txtDespacho.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Despacho", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtDespacho.addActionListener(new ActionListener() { // from class: Inventarios.BuscarDespacho.3
            public void actionPerformed(ActionEvent evt) {
                BuscarDespacho.this.txtDespachoActionPerformed(evt);
            }
        });
        this.txtDespacho.addFocusListener(new FocusAdapter() { // from class: Inventarios.BuscarDespacho.4
            public void focusGained(FocusEvent evt) {
                BuscarDespacho.this.txtDespachoFocusGained(evt);
            }
        });
        this.jPanel2.add(this.txtDespacho);
        this.txtDespacho.setBounds(10, 30, 120, 40);
        this.txtFechaFin.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Final", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtFechaFin.setFont(new Font("Arial", 1, 12));
        this.txtFechaFin.addPropertyChangeListener(new PropertyChangeListener() { // from class: Inventarios.BuscarDespacho.5
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                BuscarDespacho.this.txtFechaFinPropertyChange(evt);
            }
        });
        this.txtFechaFin.addVetoableChangeListener(new VetoableChangeListener() { // from class: Inventarios.BuscarDespacho.6
            /* JADX INFO: Thrown type has an unknown type hierarchy: java.beans.PropertyVetoException */
            public void vetoableChange(PropertyChangeEvent evt) throws PropertyVetoException {
                BuscarDespacho.this.txtFechaFinVetoableChange(evt);
            }
        });
        this.jPanel2.add(this.txtFechaFin);
        this.txtFechaFin.setBounds(270, 20, 119, 50);
        this.cboTipoMovimiento.setFont(new Font("Arial", 1, 12));
        this.cboTipoMovimiento.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de Movimiento", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.cboTipoMovimiento.addActionListener(new ActionListener() { // from class: Inventarios.BuscarDespacho.7
            public void actionPerformed(ActionEvent evt) {
                BuscarDespacho.this.cboTipoMovimientoActionPerformed(evt);
            }
        });
        this.cboTipoMovimiento.addPropertyChangeListener(new PropertyChangeListener() { // from class: Inventarios.BuscarDespacho.8
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                BuscarDespacho.this.cboTipoMovimientoPropertyChange(evt);
            }
        });
        this.jPanel2.add(this.cboTipoMovimiento);
        this.cboTipoMovimiento.setBounds(400, 28, 290, 40);
        this.btnBuscar.setFont(new Font("Arial", 1, 12));
        this.btnBuscar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Buscar.png")));
        this.btnBuscar.setText("Buscar");
        this.btnBuscar.addActionListener(new ActionListener() { // from class: Inventarios.BuscarDespacho.9
            public void actionPerformed(ActionEvent evt) {
                BuscarDespacho.this.btnBuscarActionPerformed(evt);
            }
        });
        this.jPanel2.add(this.btnBuscar);
        this.btnBuscar.setBounds(700, 20, 180, 50);
        this.txtNombre2.setFont(new Font("Arial", 1, 12));
        this.txtNombre2.setBorder(BorderFactory.createTitledBorder((Border) null, "Segundo Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtNombre2.addActionListener(new ActionListener() { // from class: Inventarios.BuscarDespacho.10
            public void actionPerformed(ActionEvent evt) {
                BuscarDespacho.this.txtNombre2ActionPerformed(evt);
            }
        });
        this.txtNombre2.addFocusListener(new FocusAdapter() { // from class: Inventarios.BuscarDespacho.11
            public void focusGained(FocusEvent evt) {
                BuscarDespacho.this.txtNombre2FocusGained(evt);
            }
        });
        this.jPanel2.add(this.txtNombre2);
        this.txtNombre2.setBounds(710, 100, 180, 40);
        this.txtHistoria.setFont(new Font("Arial", 1, 12));
        this.txtHistoria.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Historia", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtHistoria.addActionListener(new ActionListener() { // from class: Inventarios.BuscarDespacho.12
            public void actionPerformed(ActionEvent evt) {
                BuscarDespacho.this.txtHistoriaActionPerformed(evt);
            }
        });
        this.txtHistoria.addFocusListener(new FocusAdapter() { // from class: Inventarios.BuscarDespacho.13
            public void focusGained(FocusEvent evt) {
                BuscarDespacho.this.txtHistoriaFocusGained(evt);
            }
        });
        this.jPanel2.add(this.txtHistoria);
        this.txtHistoria.setBounds(10, 100, 120, 40);
        this.txtApellido1.setFont(new Font("Arial", 1, 12));
        this.txtApellido1.setBorder(BorderFactory.createTitledBorder((Border) null, "Primer Apellido", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtApellido1.addActionListener(new ActionListener() { // from class: Inventarios.BuscarDespacho.14
            public void actionPerformed(ActionEvent evt) {
                BuscarDespacho.this.txtApellido1ActionPerformed(evt);
            }
        });
        this.txtApellido1.addFocusListener(new FocusAdapter() { // from class: Inventarios.BuscarDespacho.15
            public void focusGained(FocusEvent evt) {
                BuscarDespacho.this.txtApellido1FocusGained(evt);
            }
        });
        this.jPanel2.add(this.txtApellido1);
        this.txtApellido1.setBounds(140, 100, 180, 40);
        this.txtApellido2.setFont(new Font("Arial", 1, 12));
        this.txtApellido2.setBorder(BorderFactory.createTitledBorder((Border) null, "Segundo Apellido", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtApellido2.addActionListener(new ActionListener() { // from class: Inventarios.BuscarDespacho.16
            public void actionPerformed(ActionEvent evt) {
                BuscarDespacho.this.txtApellido2ActionPerformed(evt);
            }
        });
        this.txtApellido2.addFocusListener(new FocusAdapter() { // from class: Inventarios.BuscarDespacho.17
            public void focusGained(FocusEvent evt) {
                BuscarDespacho.this.txtApellido2FocusGained(evt);
            }
        });
        this.jPanel2.add(this.txtApellido2);
        this.txtApellido2.setBounds(330, 99, 180, 41);
        this.txtNombre1.setFont(new Font("Arial", 1, 12));
        this.txtNombre1.setBorder(BorderFactory.createTitledBorder((Border) null, "Primer Nombre", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtNombre1.addActionListener(new ActionListener() { // from class: Inventarios.BuscarDespacho.18
            public void actionPerformed(ActionEvent evt) {
                BuscarDespacho.this.txtNombre1ActionPerformed(evt);
            }
        });
        this.txtNombre1.addFocusListener(new FocusAdapter() { // from class: Inventarios.BuscarDespacho.19
            public void focusGained(FocusEvent evt) {
                BuscarDespacho.this.txtNombre1FocusGained(evt);
            }
        });
        this.jPanel2.add(this.txtNombre1);
        this.txtNombre1.setBounds(520, 99, 180, 41);
        this.txtFechaIni.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtFechaIni.setFont(new Font("Arial", 1, 12));
        this.jPanel2.add(this.txtFechaIni);
        this.txtFechaIni.setBounds(140, 20, 120, 50);
        getContentPane().add(this.jPanel2, new AbsoluteConstraints(0, 40, 910, 160));
        this.grid.setFont(new Font("Arial", 1, 12));
        this.grid.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.grid.setRowHeight(25);
        this.grid.setSelectionBackground(new Color(255, 255, 255));
        this.grid.setSelectionForeground(new Color(255, 0, 0));
        this.grid.setSelectionMode(0);
        this.jScrollPane1.setViewportView(this.grid);
        getContentPane().add(this.jScrollPane1, new AbsoluteConstraints(10, 210, 900, 260));
        this.jPanel3.setBorder(BorderFactory.createEtchedBorder());
        this.btnAceptar.setFont(new Font("Arial", 1, 12));
        this.btnAceptar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ok29x27.png")));
        this.btnAceptar.setText("Aceptar");
        this.btnAceptar.addActionListener(new ActionListener() { // from class: Inventarios.BuscarDespacho.20
            public void actionPerformed(ActionEvent evt) {
                BuscarDespacho.this.btnAceptarActionPerformed(evt);
            }
        });
        this.btnSalir.setFont(new Font("Arial", 1, 12));
        this.btnSalir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.btnSalir.setText("Salir");
        this.btnSalir.addActionListener(new ActionListener() { // from class: Inventarios.BuscarDespacho.21
            public void actionPerformed(ActionEvent evt) {
                BuscarDespacho.this.btnSalirActionPerformed(evt);
            }
        });
        this.btnLimpiar.setFont(new Font("Arial", 1, 12));
        this.btnLimpiar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Limpiar.png")));
        this.btnLimpiar.setText("Limpiar");
        this.btnLimpiar.addActionListener(new ActionListener() { // from class: Inventarios.BuscarDespacho.22
            public void actionPerformed(ActionEvent evt) {
                BuscarDespacho.this.btnLimpiarActionPerformed(evt);
            }
        });
        GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
        this.jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addComponent(this.btnLimpiar, -2, 251, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 47, 32767).addComponent(this.btnAceptar, -2, 272, -2).addGap(36, 36, 36).addComponent(this.btnSalir, -2, 270, -2).addContainerGap()));
        jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.btnLimpiar, -2, 0, 32767).addComponent(this.btnSalir, -2, 40, -2).addComponent(this.btnAceptar, -2, 40, -2)).addContainerGap()));
        getContentPane().add(this.jPanel3, new AbsoluteConstraints(10, 480, 900, -1));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtDespachoActionPerformed(ActionEvent evt) {
        this.btnBuscar.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtFechaFinPropertyChange(PropertyChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtFechaFinVetoableChange(PropertyChangeEvent evt) throws PropertyVetoException {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboTipoMovimientoActionPerformed(ActionEvent evt) {
        this.btnBuscar.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboTipoMovimientoPropertyChange(PropertyChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnBuscarActionPerformed(ActionEvent evt) {
        buscarDespacho();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtHistoriaActionPerformed(ActionEvent evt) {
        this.btnBuscar.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnAceptarActionPerformed(ActionEvent evt) {
        cargarDespacho();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnSalirActionPerformed(ActionEvent evt) {
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnLimpiarActionPerformed(ActionEvent evt) {
        limpiar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtDespachoFocusGained(FocusEvent evt) {
        this.txtDespacho.selectAll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtHistoriaFocusGained(FocusEvent evt) {
        this.txtHistoria.selectAll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtApellido1FocusGained(FocusEvent evt) {
        this.txtApellido1.selectAll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtApellido2FocusGained(FocusEvent evt) {
        this.txtApellido2.selectAll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtNombre1FocusGained(FocusEvent evt) {
        this.txtNombre1.selectAll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtNombre2FocusGained(FocusEvent evt) {
        this.txtNombre2.selectAll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtApellido1ActionPerformed(ActionEvent evt) {
        this.txtApellido2.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtApellido2ActionPerformed(ActionEvent evt) {
        this.txtNombre1.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtNombre1ActionPerformed(ActionEvent evt) {
        this.txtNombre2.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtNombre2ActionPerformed(ActionEvent evt) {
        this.btnBuscar.requestFocus();
    }
}
