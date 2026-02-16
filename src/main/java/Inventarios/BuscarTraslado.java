package Inventarios;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

/* JADX INFO: loaded from: GenomaP.jar:Inventarios/BuscarTraslado.class */
public class BuscarTraslado extends JDialog {
    private Metodos metodos;
    private ConsultasMySQL consultas;
    private ResultSet rs;
    private Object[] dato;
    private int filaGrid;
    private int cboLleno;
    private String sql;
    private String[] listaTipoMovimiento;
    private String[] listaBodega;
    private DefaultTableModel modelo;
    private claseInventario claseInv;
    private JButton btnAceptar;
    private JButton btnBuscar;
    private JButton btnLimpiar;
    private JButton btnSalir;
    private JComboBox cboBodega;
    private JComboBox cboTipoMovimiento;
    private JTable grid;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JScrollPane jScrollPane1;
    private JDateChooser txtFechaFin;
    private JDateChooser txtFechaIni;
    private JTextField txtTraslado;

    public BuscarTraslado(Frame parent, boolean modal, claseInventario claseI) {
        super(parent, modal);
        this.metodos = new Metodos();
        this.consultas = new ConsultasMySQL();
        this.filaGrid = 0;
        this.cboLleno = 0;
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        this.claseInv = claseI;
        setLocationRelativeTo(null);
        setTitle("BUSCAR TRASLADOS DE LAS BODEGAS : " + this.claseInv.getNbreBodega().toUpperCase());
        crearGrid();
        cargarCombos();
        this.grid.addMouseListener(new MouseAdapter() { // from class: Inventarios.BuscarTraslado.1
            public void mouseClicked(MouseEvent e) {
                BuscarTraslado.this.filaGrid = BuscarTraslado.this.grid.rowAtPoint(e.getPoint());
            }
        });
    }

    public void buscarTraslado() {
        this.sql = "SELECT i_salidas.Id, i_salidas.FechaSalida, i_tiposmovimientos.Nbre,`i_bodegas_vista`.`Nbre`, i_bodegas.Nbre, i_salidas.Estado, i_salidas.Entrada FROM i_salidas INNER JOIN i_tiposmovimientos ON (i_salidas.IdTipoMovimiento = i_tiposmovimientos.Id) INNER JOIN `i_bodegas_vista` ON (`i_salidas`.`IdBodega` = `i_bodegas_vista`.`Id`)INNER JOIN i_bodegas  ON (i_salidas.IdDestino = i_bodegas.Id) WHERE ( ";
        if (!this.txtTraslado.getText().isEmpty()) {
            this.sql += " i_salidas.Id ='" + this.txtTraslado.getText() + "'";
        }
        if (this.txtFechaIni.getDate() != null) {
            this.sql += "  i_salidas.FechaSalida >='" + this.metodos.formatoAMD.format(this.txtFechaIni.getDate()) + "'";
        }
        if (this.txtFechaFin.getDate() != null) {
            this.sql += " AND i_salidas.FechaSalida <='" + this.metodos.formatoAMD.format(this.txtFechaFin.getDate()) + "'";
        }
        if (this.cboTipoMovimiento.getSelectedIndex() > -1) {
            this.sql += " AND i_salidas.IdTipoMovimiento ='" + this.listaTipoMovimiento[this.cboTipoMovimiento.getSelectedIndex()] + "'";
        }
        if (this.cboBodega.getSelectedIndex() > -1) {
            this.sql += "  AND i_salidas.IdDestino ='" + this.listaBodega[this.cboBodega.getSelectedIndex()] + "'";
        }
        this.sql += " AND (i_salidas.TipoD=0)) ORDER BY i_salidas.FechaSalida ASC";
        crearGrid();
        this.rs = this.consultas.traerRs(this.sql);
        try {
            this.filaGrid = 0;
            while (this.rs.next()) {
                this.modelo.addRow(this.dato);
                this.modelo.setValueAt(this.rs.getString(1), this.filaGrid, 0);
                this.modelo.setValueAt(this.metodos.formatoDMA.format((Date) this.rs.getDate(2)), this.filaGrid, 1);
                this.modelo.setValueAt(this.rs.getString(3), this.filaGrid, 2);
                this.modelo.setValueAt(this.rs.getString(4), this.filaGrid, 3);
                this.modelo.setValueAt(this.rs.getString(5), this.filaGrid, 4);
                if (this.rs.getInt(6) == 0) {
                    this.modelo.setValueAt("ACTIVA", this.filaGrid, 5);
                } else {
                    this.modelo.setValueAt("ANULADA", this.filaGrid, 5);
                }
                this.modelo.setValueAt(this.rs.getString(7), this.filaGrid, 6);
                this.filaGrid++;
            }
            this.filaGrid--;
            this.rs.close();
            this.consultas.cerrarConexionBd();
        } catch (SQLException ex) {
            this.consultas.mostrarErrorSQL(ex);
        }
    }

    public void cargarCombos() {
        this.listaTipoMovimiento = this.consultas.llenarCombo("SELECT Id, Nbre FROM i_tiposmovimientos WHERE TipoMovimiento = 1 AND Bodega = '" + this.claseInv.getIdBodega() + "' AND Traslado = 1 ORDER BY Nbre ", this.listaTipoMovimiento, this.cboTipoMovimiento);
        this.listaBodega = this.consultas.llenarCombo("SELECT Id, Nbre FROM i_bodegas WHERE Id <> '" + this.claseInv.getIdBodega() + "' AND Estado = 0 ORDER BY Nbre ", this.listaBodega, this.cboBodega);
        this.cboTipoMovimiento.setSelectedIndex(-1);
        this.cboBodega.setSelectedIndex(-1);
        this.cboLleno = 1;
        this.consultas.cerrarConexionBd();
    }

    public void cargarTraslado() {
        if (this.filaGrid > -1 && this.filaGrid < this.modelo.getRowCount()) {
            this.claseInv.frmTraslado.nuevo();
            Principal.txtNo.setText(this.modelo.getValueAt(this.filaGrid, 0).toString());
            Principal.txtFecha.setText(this.modelo.getValueAt(this.filaGrid, 1).toString());
            if (this.modelo.getValueAt(this.filaGrid, 5).toString().equals("ACTIVA")) {
                this.metodos.marcarEstado(0);
            } else {
                this.metodos.marcarEstado(1);
            }
            this.claseInv.frmTraslado.txtFecha.setDate(this.metodos.getPasarTextoAFecha(this.modelo.getValueAt(this.filaGrid, 1).toString()));
            this.claseInv.frmTraslado.cboTipoMovimiento.setSelectedItem(this.modelo.getValueAt(this.filaGrid, 2).toString());
            this.claseInv.frmTraslado.cboBodega.setSelectedItem(this.modelo.getValueAt(this.filaGrid, 4).toString());
            this.claseInv.frmTraslado.txtEntrada.setText(this.modelo.getValueAt(this.filaGrid, 6).toString());
            this.claseInv.frmTraslado.cargarTraslado();
            dispose();
            return;
        }
        this.metodos.mostrarMensaje("Por favor seleccione un Traslado");
    }

    public void crearGrid() {
        this.modelo = new DefaultTableModel() { // from class: Inventarios.BuscarTraslado.2
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.modelo.addColumn("Número");
        this.modelo.addColumn("Fecha");
        this.modelo.addColumn("Tipo Movimiento");
        this.modelo.addColumn("Bodega Origen");
        this.modelo.addColumn("Bodega Destino");
        this.modelo.addColumn("Estado");
        this.modelo.addColumn("");
        this.grid.setModel(this.modelo);
        this.grid.getColumnModel().getColumn(0).setPreferredWidth(60);
        this.grid.getColumnModel().getColumn(1).setPreferredWidth(80);
        this.grid.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(3).setPreferredWidth(80);
        this.grid.getColumnModel().getColumn(4).setPreferredWidth(80);
        this.grid.getColumnModel().getColumn(5).setPreferredWidth(80);
        this.grid.getColumnModel().getColumn(6).setPreferredWidth(80);
        this.grid.getColumnModel().getColumn(6).setMinWidth(0);
        this.grid.getColumnModel().getColumn(6).setMaxWidth(0);
    }

    private void limpiar() {
        this.txtTraslado.setText("");
        this.txtFechaIni.setDate((Date) null);
        this.txtFechaFin.setDate((Date) null);
        this.cboTipoMovimiento.setSelectedIndex(-1);
        this.cboBodega.setSelectedIndex(-1);
        crearGrid();
        this.txtTraslado.requestFocus();
    }

    /* JADX WARN: Type inference failed for: r3v54, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jPanel2 = new JPanel();
        this.txtTraslado = new JTextField();
        this.txtFechaIni = new JDateChooser();
        this.txtFechaFin = new JDateChooser();
        this.cboTipoMovimiento = new JComboBox();
        this.cboBodega = new JComboBox();
        this.btnBuscar = new JButton();
        this.jScrollPane1 = new JScrollPane();
        this.grid = new JTable();
        this.jPanel3 = new JPanel();
        this.btnAceptar = new JButton();
        this.btnSalir = new JButton();
        this.btnLimpiar = new JButton();
        setDefaultCloseOperation(2);
        setName("BuscarTraslado");
        getContentPane().setLayout(new AbsoluteLayout());
        this.jPanel2.setBorder(BorderFactory.createTitledBorder((Border) null, "CRITERIO DE BÚSQUEDA", 2, 0, new Font("Arial", 1, 14), new Color(51, 102, 0)));
        this.txtTraslado.setFont(new Font("Arial", 1, 12));
        this.txtTraslado.setHorizontalAlignment(4);
        this.txtTraslado.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Traslado", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtTraslado.addActionListener(new ActionListener() { // from class: Inventarios.BuscarTraslado.3
            public void actionPerformed(ActionEvent evt) {
                BuscarTraslado.this.txtTrasladoActionPerformed(evt);
            }
        });
        this.txtFechaIni.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtFechaIni.setFont(new Font("Arial", 1, 12));
        this.txtFechaIni.addPropertyChangeListener(new PropertyChangeListener() { // from class: Inventarios.BuscarTraslado.4
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                BuscarTraslado.this.txtFechaIniPropertyChange(evt);
            }
        });
        this.txtFechaIni.addVetoableChangeListener(new VetoableChangeListener() { // from class: Inventarios.BuscarTraslado.5
            /* JADX INFO: Thrown type has an unknown type hierarchy: java.beans.PropertyVetoException */
            public void vetoableChange(PropertyChangeEvent evt) throws PropertyVetoException {
                BuscarTraslado.this.txtFechaIniVetoableChange(evt);
            }
        });
        this.txtFechaFin.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Fin", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtFechaFin.setFont(new Font("Arial", 1, 12));
        this.txtFechaFin.addPropertyChangeListener(new PropertyChangeListener() { // from class: Inventarios.BuscarTraslado.6
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                BuscarTraslado.this.txtFechaFinPropertyChange(evt);
            }
        });
        this.txtFechaFin.addVetoableChangeListener(new VetoableChangeListener() { // from class: Inventarios.BuscarTraslado.7
            /* JADX INFO: Thrown type has an unknown type hierarchy: java.beans.PropertyVetoException */
            public void vetoableChange(PropertyChangeEvent evt) throws PropertyVetoException {
                BuscarTraslado.this.txtFechaFinVetoableChange(evt);
            }
        });
        this.cboTipoMovimiento.setFont(new Font("Arial", 1, 12));
        this.cboTipoMovimiento.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de Movimiento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.cboTipoMovimiento.addActionListener(new ActionListener() { // from class: Inventarios.BuscarTraslado.8
            public void actionPerformed(ActionEvent evt) {
                BuscarTraslado.this.cboTipoMovimientoActionPerformed(evt);
            }
        });
        this.cboTipoMovimiento.addPropertyChangeListener(new PropertyChangeListener() { // from class: Inventarios.BuscarTraslado.9
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                BuscarTraslado.this.cboTipoMovimientoPropertyChange(evt);
            }
        });
        this.cboBodega.setFont(new Font("Arial", 1, 12));
        this.cboBodega.setBorder(BorderFactory.createTitledBorder((Border) null, "Bodega de Destino", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.cboBodega.addFocusListener(new FocusAdapter() { // from class: Inventarios.BuscarTraslado.10
            public void focusLost(FocusEvent evt) {
                BuscarTraslado.this.cboBodegaFocusLost(evt);
            }
        });
        this.cboBodega.addPropertyChangeListener(new PropertyChangeListener() { // from class: Inventarios.BuscarTraslado.11
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                BuscarTraslado.this.cboBodegaPropertyChange(evt);
            }
        });
        this.btnBuscar.setFont(new Font("Arial", 1, 12));
        this.btnBuscar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Buscar.png")));
        this.btnBuscar.setText("Buscar");
        this.btnBuscar.addActionListener(new ActionListener() { // from class: Inventarios.BuscarTraslado.12
            public void actionPerformed(ActionEvent evt) {
                BuscarTraslado.this.btnBuscarActionPerformed(evt);
            }
        });
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGap(4, 4, 4).addComponent(this.txtTraslado, -2, 120, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txtFechaIni, -2, 119, -2).addGap(15, 15, 15).addComponent(this.txtFechaFin, -2, 119, -2).addGap(11, 11, 11).addComponent(this.cboTipoMovimiento, -2, 202, -2).addGap(18, 18, 18).addComponent(this.cboBodega, -2, 240, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 14, 32767).addComponent(this.btnBuscar, -2, 150, -2).addContainerGap()));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGap(11, 11, 11).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.txtFechaFin, -2, -1, -2).addComponent(this.txtFechaIni, -2, -1, -2))).addGroup(jPanel2Layout.createSequentialGroup().addGap(9, 9, 9).addComponent(this.cboTipoMovimiento, -2, -1, -2)).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.txtTraslado, -2, 40, -2)).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.btnBuscar, -2, 51, -2)).addGroup(GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup().addGap(9, 9, 9).addComponent(this.cboBodega, -2, -1, -2)))).addContainerGap(-1, 32767)));
        getContentPane().add(this.jPanel2, new AbsoluteConstraints(10, 10, 1040, 100));
        this.jScrollPane1.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(51, 102, 0)));
        this.grid.setFont(new Font("Arial", 1, 12));
        this.grid.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.grid.setRowHeight(25);
        this.grid.setSelectionBackground(new Color(255, 255, 255));
        this.grid.setSelectionForeground(new Color(255, 0, 0));
        this.grid.setSelectionMode(0);
        this.jScrollPane1.setViewportView(this.grid);
        getContentPane().add(this.jScrollPane1, new AbsoluteConstraints(10, 120, 1040, 240));
        this.jPanel3.setBorder(BorderFactory.createEtchedBorder());
        this.btnAceptar.setFont(new Font("Arial", 1, 12));
        this.btnAceptar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ok29x27.png")));
        this.btnAceptar.setText("Aceptar");
        this.btnAceptar.addActionListener(new ActionListener() { // from class: Inventarios.BuscarTraslado.13
            public void actionPerformed(ActionEvent evt) {
                BuscarTraslado.this.btnAceptarActionPerformed(evt);
            }
        });
        this.btnSalir.setFont(new Font("Arial", 1, 12));
        this.btnSalir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.btnSalir.setText("Salir");
        this.btnSalir.addActionListener(new ActionListener() { // from class: Inventarios.BuscarTraslado.14
            public void actionPerformed(ActionEvent evt) {
                BuscarTraslado.this.btnSalirActionPerformed(evt);
            }
        });
        this.btnLimpiar.setFont(new Font("Arial", 1, 12));
        this.btnLimpiar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Limpiar.png")));
        this.btnLimpiar.setText("Limpiar");
        this.btnLimpiar.addActionListener(new ActionListener() { // from class: Inventarios.BuscarTraslado.15
            public void actionPerformed(ActionEvent evt) {
                BuscarTraslado.this.btnLimpiarActionPerformed(evt);
            }
        });
        GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
        this.jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addComponent(this.btnLimpiar, -2, 279, -2).addGap(32, 32, 32).addComponent(this.btnAceptar, -2, 334, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 32, 32767).addComponent(this.btnSalir, -2, 326, -2).addGap(23, 23, 23)));
        jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.btnLimpiar, -2, 0, 32767).addComponent(this.btnSalir, -2, 40, -2).addComponent(this.btnAceptar, -2, 40, -2)).addContainerGap()));
        getContentPane().add(this.jPanel3, new AbsoluteConstraints(10, 360, 1040, -1));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtTrasladoActionPerformed(ActionEvent evt) {
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
    public void cboBodegaFocusLost(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboBodegaPropertyChange(PropertyChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnBuscarActionPerformed(ActionEvent evt) {
        buscarTraslado();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnAceptarActionPerformed(ActionEvent evt) {
        cargarTraslado();
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
