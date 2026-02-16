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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

/* JADX INFO: loaded from: GenomaP.jar:Inventarios/BuscarSalida.class */
public class BuscarSalida extends JDialog {
    private Metodos metodos;
    private ConsultasMySQL consultas;
    private ResultSet rs;
    private Object[] dato;
    private int filaGrid;
    private int cboLleno;
    private String sql;
    private String[] listaTipoMovimiento;
    private String[] listaProveedor;
    private DefaultTableModel modelo;
    private claseInventario claseInv;
    private JButton btnAceptar;
    private JButton btnBuscar;
    private JButton btnLimpiar;
    private JButton btnSalir;
    private JComboBox cboProveedor;
    private JComboBox cboTipoMovimiento;
    private JTable grid;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JScrollPane jScrollPane1;
    private JDateChooser txtFechaFin;
    private JDateChooser txtFechaIni;
    private JTextField txtNumero;

    public BuscarSalida(Frame parent, boolean modal, claseInventario claseI) {
        super(parent, modal);
        this.metodos = new Metodos();
        this.consultas = new ConsultasMySQL();
        this.filaGrid = 0;
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        this.claseInv = claseI;
        setLocationRelativeTo(null);
        setTitle("BUSCAR SALIDA DE LA BODEGA : " + this.claseInv.getNbreBodega().toUpperCase());
        crearGrid();
        cargarCombos();
        this.grid.addMouseListener(new MouseAdapter() { // from class: Inventarios.BuscarSalida.1
            public void mouseClicked(MouseEvent e) {
                BuscarSalida.this.filaGrid = BuscarSalida.this.grid.rowAtPoint(e.getPoint());
            }
        });
        crearGrid();
        limpiar();
    }

    public void buscarSalida() {
        this.sql = "SELECT i_salidas.Id, i_salidas.FechaSalida, i_tiposmovimientos.Nbre, IF(i_salidas.`Destino`=1, i_bodegas.`Nbre`, IF(i_salidas.`Destino`=2, cc_terceros.`RazonSocialCompleta`, IF(i_salidas.`Destino`=3,f_centrocosto.`Nbre`, 'USUARIO'))) AS Nbre, i_salidas.Estado, i_salidas.Observaciones\nFROM i_salidas  INNER JOIN i_tiposmovimientos ON (i_salidas.IdTipoMovimiento = i_tiposmovimientos.Id) LEFT JOIN cc_terceros ON (i_salidas.IdDestino = cc_terceros.Id) \nLEFT JOIN f_centrocosto ON (i_salidas.IdDestino = f_centrocosto.Id)  LEFT JOIN i_bodegas ON (i_bodegas.Id = i_salidas.IdDestino) WHERE (i_salidas.IdBodega = '" + this.claseInv.getIdBodega();
        if (!this.txtNumero.getText().isEmpty()) {
            this.sql += "' AND i_salidas.Id = '" + this.txtNumero.getText();
        }
        if (this.txtFechaIni.getDate() != null) {
            this.sql += "' AND i_salidas.FechaSalida >= '" + this.metodos.formatoAMD.format(this.txtFechaIni.getDate());
        }
        if (this.txtFechaFin.getDate() != null) {
            this.sql += "' AND i_salidas.FechaSalida <= '" + this.metodos.formatoAMD.format(this.txtFechaFin.getDate());
        }
        if (this.cboTipoMovimiento.getSelectedIndex() > 0) {
            this.sql += "' AND i_salidas.IdTipoMovimiento = '" + this.listaTipoMovimiento[this.cboTipoMovimiento.getSelectedIndex()];
        }
        if (this.cboProveedor.getSelectedIndex() > 0) {
            this.sql += "' AND i_salidas.IdDestino = '" + this.listaProveedor[this.cboProveedor.getSelectedIndex()];
        }
        this.sql += "' ) ORDER BY i_salidas.FechaSalida DESC";
        crearGrid();
        this.rs = this.consultas.traerRs(this.sql);
        try {
            this.rs.last();
            int registros = this.rs.getRow();
            if (registros > 0) {
                this.filaGrid = 0;
                this.rs.beforeFirst();
                while (this.rs.next()) {
                    this.modelo.addRow(this.dato);
                    this.modelo.setValueAt(this.rs.getString(1), this.filaGrid, 0);
                    this.modelo.setValueAt(this.metodos.formatoDMA.format((Date) this.rs.getDate(2)), this.filaGrid, 1);
                    this.modelo.setValueAt(this.rs.getString(3), this.filaGrid, 2);
                    this.modelo.setValueAt(this.rs.getString(4), this.filaGrid, 3);
                    if (this.rs.getInt(5) == 0) {
                        this.modelo.setValueAt("ACTIVA", this.filaGrid, 4);
                    } else {
                        this.modelo.setValueAt("ANULADA", this.filaGrid, 4);
                    }
                    this.modelo.setValueAt(this.rs.getString(6), this.filaGrid, 5);
                    this.filaGrid++;
                }
            } else {
                this.metodos.mostrarMensaje("No se obtuvo registros en la Consulta");
            }
            this.rs.close();
            this.consultas.cerrarConexionBd();
        } catch (SQLException ex) {
            this.metodos.mostrarErrorE(ex);
        }
    }

    public void cargarCombos() {
        this.listaTipoMovimiento = this.consultas.llenarCombo("SELECT Id, Nbre FROM i_tiposmovimientos WHERE TipoMovimiento = 1 AND Bodega = '" + this.claseInv.getIdBodega() + "' ORDER BY Nbre ", this.listaTipoMovimiento, this.cboTipoMovimiento);
        this.listaProveedor = this.consultas.llenarCombo("SELECT Id_Empresa, cc_terceros.RazonSocialCompleta FROM i_proveedores INNER JOIN cc_terceros ON (i_proveedores.Id_Empresa = cc_terceros.Id) ORDER BY cc_terceros.RazonSocialCompleta ", this.listaProveedor, this.cboProveedor);
        this.cboLleno = 1;
        this.consultas.cerrarConexionBd();
    }

    public void cargarSalida() {
        this.claseInv.frmSalida.nuevo();
        this.claseInv.frmSalida.idSalida = this.modelo.getValueAt(this.filaGrid, 0).toString();
        Principal.txtNo.setText(this.claseInv.frmSalida.idSalida);
        this.claseInv.frmSalida.JLB_Registro.setText(this.claseInv.frmSalida.idSalida);
        this.claseInv.frmSalida.txtFecha.setDate(this.metodos.getPasarTextoAFecha(this.modelo.getValueAt(this.filaGrid, 1).toString().substring(0, 10)));
        this.claseInv.frmSalida.cboTipoMovimiento.setSelectedItem((String) this.modelo.getValueAt(this.filaGrid, 2));
        this.claseInv.frmSalida.cboDestino.setSelectedItem(this.modelo.getValueAt(this.filaGrid, 3));
        if (this.modelo.getValueAt(this.filaGrid, 4).toString().equals("ACTIVA")) {
            this.metodos.marcarEstado(0);
        } else {
            this.metodos.marcarEstado(1);
        }
        this.claseInv.frmSalida.txtObservaciones.setText(this.modelo.getValueAt(this.filaGrid, 5).toString());
        this.claseInv.frmSalida.cargarSalida();
        this.claseInv.frmSalida.grabada = 1;
        dispose();
    }

    public void crearGrid() {
        this.modelo = new DefaultTableModel() { // from class: Inventarios.BuscarSalida.2
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.modelo.addColumn("Número");
        this.modelo.addColumn("Fecha");
        this.modelo.addColumn("Tipo Movimiento");
        this.modelo.addColumn("Proveedor");
        this.modelo.addColumn("Estado");
        this.modelo.addColumn("Observaciones");
        this.grid.setModel(this.modelo);
        this.grid.getColumnModel().getColumn(0).setPreferredWidth(60);
        this.grid.getColumnModel().getColumn(1).setPreferredWidth(80);
        this.grid.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(3).setPreferredWidth(150);
        this.grid.getColumnModel().getColumn(4).setPreferredWidth(80);
        this.grid.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.filaGrid = 0;
    }

    private void limpiar() {
        this.txtNumero.setText("");
        this.txtFechaIni.setDate((Date) null);
        this.txtFechaFin.setDate((Date) null);
        this.cboTipoMovimiento.setSelectedIndex(-1);
        this.cboProveedor.setSelectedIndex(-1);
        crearGrid();
    }

    /* JADX WARN: Type inference failed for: r3v35, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jPanel2 = new JPanel();
        this.txtNumero = new JTextField();
        this.txtFechaIni = new JDateChooser();
        this.txtFechaFin = new JDateChooser();
        this.cboTipoMovimiento = new JComboBox();
        this.btnBuscar = new JButton();
        this.cboProveedor = new JComboBox();
        this.jScrollPane1 = new JScrollPane();
        this.grid = new JTable();
        this.jPanel3 = new JPanel();
        this.btnAceptar = new JButton();
        this.btnSalir = new JButton();
        this.btnLimpiar = new JButton();
        setDefaultCloseOperation(2);
        setName("BuscarSalida");
        getContentPane().setLayout(new AbsoluteLayout());
        this.jPanel2.setBorder(BorderFactory.createTitledBorder((Border) null, "CRITERIO DE BÚSQUEDA", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 51)));
        this.jPanel2.setForeground(new Color(0, 102, 102));
        this.jPanel2.setLayout((LayoutManager) null);
        this.txtNumero.setFont(new Font("Arial", 1, 12));
        this.txtNumero.setHorizontalAlignment(4);
        this.txtNumero.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Salida", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtNumero.addActionListener(new ActionListener() { // from class: Inventarios.BuscarSalida.3
            public void actionPerformed(ActionEvent evt) {
                BuscarSalida.this.txtNumeroActionPerformed(evt);
            }
        });
        this.jPanel2.add(this.txtNumero);
        this.txtNumero.setBounds(10, 40, 120, 40);
        this.txtFechaIni.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtFechaIni.setFont(new Font("Arial", 1, 12));
        this.txtFechaIni.addPropertyChangeListener(new PropertyChangeListener() { // from class: Inventarios.BuscarSalida.4
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                BuscarSalida.this.txtFechaIniPropertyChange(evt);
            }
        });
        this.txtFechaIni.addVetoableChangeListener(new VetoableChangeListener() { // from class: Inventarios.BuscarSalida.5
            /* JADX INFO: Thrown type has an unknown type hierarchy: java.beans.PropertyVetoException */
            public void vetoableChange(PropertyChangeEvent evt) throws PropertyVetoException {
                BuscarSalida.this.txtFechaIniVetoableChange(evt);
            }
        });
        this.jPanel2.add(this.txtFechaIni);
        this.txtFechaIni.setBounds(140, 36, 119, 44);
        this.txtFechaFin.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Fin", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtFechaFin.setFont(new Font("Arial", 1, 12));
        this.txtFechaFin.addPropertyChangeListener(new PropertyChangeListener() { // from class: Inventarios.BuscarSalida.6
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                BuscarSalida.this.txtFechaFinPropertyChange(evt);
            }
        });
        this.txtFechaFin.addVetoableChangeListener(new VetoableChangeListener() { // from class: Inventarios.BuscarSalida.7
            /* JADX INFO: Thrown type has an unknown type hierarchy: java.beans.PropertyVetoException */
            public void vetoableChange(PropertyChangeEvent evt) throws PropertyVetoException {
                BuscarSalida.this.txtFechaFinVetoableChange(evt);
            }
        });
        this.jPanel2.add(this.txtFechaFin);
        this.txtFechaFin.setBounds(270, 36, 119, 44);
        this.cboTipoMovimiento.setFont(new Font("Arial", 1, 12));
        this.cboTipoMovimiento.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de Movimiento", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.cboTipoMovimiento.addActionListener(new ActionListener() { // from class: Inventarios.BuscarSalida.8
            public void actionPerformed(ActionEvent evt) {
                BuscarSalida.this.cboTipoMovimientoActionPerformed(evt);
            }
        });
        this.cboTipoMovimiento.addPropertyChangeListener(new PropertyChangeListener() { // from class: Inventarios.BuscarSalida.9
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                BuscarSalida.this.cboTipoMovimientoPropertyChange(evt);
            }
        });
        this.jPanel2.add(this.cboTipoMovimiento);
        this.cboTipoMovimiento.setBounds(400, 38, 220, 40);
        this.btnBuscar.setFont(new Font("Arial", 1, 12));
        this.btnBuscar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Buscar.png")));
        this.btnBuscar.setText("Buscar");
        this.btnBuscar.addActionListener(new ActionListener() { // from class: Inventarios.BuscarSalida.10
            public void actionPerformed(ActionEvent evt) {
                BuscarSalida.this.btnBuscarActionPerformed(evt);
            }
        });
        this.jPanel2.add(this.btnBuscar);
        this.btnBuscar.setBounds(910, 30, 150, 50);
        this.cboProveedor.setFont(new Font("Arial", 1, 12));
        this.cboProveedor.setBorder(BorderFactory.createTitledBorder((Border) null, "Proveedor", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.cboProveedor.addActionListener(new ActionListener() { // from class: Inventarios.BuscarSalida.11
            public void actionPerformed(ActionEvent evt) {
                BuscarSalida.this.cboProveedorActionPerformed(evt);
            }
        });
        this.jPanel2.add(this.cboProveedor);
        this.cboProveedor.setBounds(630, 38, 240, 40);
        getContentPane().add(this.jPanel2, new AbsoluteConstraints(0, 10, 1080, 100));
        this.jScrollPane1.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 51)));
        this.grid.setFont(new Font("Arial", 1, 12));
        this.grid.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.grid.setRowHeight(25);
        this.grid.setSelectionBackground(new Color(255, 255, 255));
        this.grid.setSelectionForeground(new Color(255, 0, 0));
        this.grid.setSelectionMode(0);
        this.jScrollPane1.setViewportView(this.grid);
        getContentPane().add(this.jScrollPane1, new AbsoluteConstraints(10, 110, 1070, 240));
        this.jPanel3.setBorder(BorderFactory.createEtchedBorder());
        this.btnAceptar.setFont(new Font("Arial", 1, 12));
        this.btnAceptar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ok29x27.png")));
        this.btnAceptar.setText("Aceptar");
        this.btnAceptar.addActionListener(new ActionListener() { // from class: Inventarios.BuscarSalida.12
            public void actionPerformed(ActionEvent evt) {
                BuscarSalida.this.btnAceptarActionPerformed(evt);
            }
        });
        this.btnSalir.setFont(new Font("Arial", 1, 12));
        this.btnSalir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.btnSalir.setText("Salir");
        this.btnSalir.addActionListener(new ActionListener() { // from class: Inventarios.BuscarSalida.13
            public void actionPerformed(ActionEvent evt) {
                BuscarSalida.this.btnSalirActionPerformed(evt);
            }
        });
        this.btnLimpiar.setFont(new Font("Arial", 1, 12));
        this.btnLimpiar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Limpiar.png")));
        this.btnLimpiar.setText("Limpiar");
        this.btnLimpiar.addActionListener(new ActionListener() { // from class: Inventarios.BuscarSalida.14
            public void actionPerformed(ActionEvent evt) {
                BuscarSalida.this.btnLimpiarActionPerformed(evt);
            }
        });
        GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
        this.jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup().addContainerGap().addComponent(this.btnLimpiar, -1, 312, 32767).addGap(18, 18, 18).addComponent(this.btnAceptar, -2, 326, -2).addGap(18, 18, 18).addComponent(this.btnSalir, -2, 375, -2).addContainerGap()));
        jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.btnLimpiar, -1, -1, 32767).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.btnSalir).addComponent(this.btnAceptar))).addContainerGap()));
        getContentPane().add(this.jPanel3, new AbsoluteConstraints(10, 360, -1, -1));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtNumeroActionPerformed(ActionEvent evt) {
        this.btnBuscar.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtFechaIniPropertyChange(PropertyChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtFechaIniVetoableChange(PropertyChangeEvent evt) throws PropertyVetoException {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtFechaFinPropertyChange(PropertyChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtFechaFinVetoableChange(PropertyChangeEvent evt) throws PropertyVetoException {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboTipoMovimientoActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboTipoMovimientoPropertyChange(PropertyChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnBuscarActionPerformed(ActionEvent evt) {
        buscarSalida();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboProveedorActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnAceptarActionPerformed(ActionEvent evt) {
        if (this.grid.getSelectedRow() != -1) {
            cargarSalida();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnSalirActionPerformed(ActionEvent evt) {
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnLimpiarActionPerformed(ActionEvent evt) {
        limpiar();
    }
}
