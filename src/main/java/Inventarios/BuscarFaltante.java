package Inventarios;

import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
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
import java.beans.PropertyVetoException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

/* JADX INFO: loaded from: GenomaP.jar:Inventarios/BuscarFaltante.class */
public class BuscarFaltante extends JDialog {
    private Metodos metodos;
    private ConsultasMySQL consultas;
    private ResultSet rs;
    private Object[] dato;
    private Object frm;
    private int filaGrid;
    private int cboLleno;
    private String sql;
    private DefaultTableModel modelo;
    private Faltantes frmFaltante;
    private JButton btnAceptar;
    private JButton btnBuscar;
    private JButton btnSalir;
    private JTable grid;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JScrollPane jScrollPane1;
    private JTextField txtApellido1;
    private JTextField txtApellido2;
    private JTextField txtHistoria;
    private JTextField txtNombre1;
    private JTextField txtNombre2;
    private JLabel txtTitulo;

    public BuscarFaltante(Frame parent, boolean modal, Faltantes frm) {
        super(parent, modal);
        this.metodos = new Metodos();
        this.consultas = new ConsultasMySQL();
        this.filaGrid = 0;
        this.cboLleno = 0;
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        this.frmFaltante = frm;
        setLocationRelativeTo(null);
        this.grid.addMouseListener(new MouseAdapter() { // from class: Inventarios.BuscarFaltante.1
            public void mouseClicked(MouseEvent e) {
                BuscarFaltante.this.filaGrid = BuscarFaltante.this.grid.rowAtPoint(e.getPoint());
            }
        });
        crearGrid();
    }

    public void buscar() {
        limpiarGrid();
        this.filaGrid = 0;
        this.sql = "SELECT i_faltantes.Id, i_faltantes.IdSalida, i_salidas.FechaSalida, g_persona.Apellido1, g_persona.Apellido2, g_persona.Nombre1, g_persona.Nombre2, w_profesional.NProfesional, i_faltantes.Observacion, i_faltantes.Estado FROM i_faltantes INNER JOIN i_salidas ON (i_faltantes.IdSalida = i_salidas.Id) INNER JOIN g_usuario ON (i_salidas.IdDestino = g_usuario.Id_persona) INNER JOIN w_profesional ON (i_salidas.IdProfesional = w_profesional.Id_Persona) INNER JOIN g_persona ON (g_usuario.Id_persona = g_persona.Id) WHERE (i_faltantes.Id >0";
        if (!this.txtHistoria.getText().isEmpty()) {
            this.sql += " AND g_usuario.NoHistoria ='" + this.txtHistoria.getText() + "'";
        }
        if (!this.txtApellido1.getText().isEmpty()) {
            this.sql += " AND g_persona.Apellido1 ='" + this.txtApellido1.getText() + "'";
        }
        if (!this.txtApellido2.getText().isEmpty()) {
            this.sql += " AND g_persona.Apellido2 ='" + this.txtApellido2.getText() + "'";
        }
        if (!this.txtNombre1.getText().isEmpty()) {
            this.sql += " AND g_persona.Nombre1 ='" + this.txtNombre1.getText() + "'";
        }
        if (!this.txtNombre2.getText().isEmpty()) {
            this.sql += " AND g_persona.Nombre2 ='" + this.txtNombre2.getText() + "'";
        }
        this.sql += ") ORDER BY i_salidas.FechaSalida ASC";
        this.rs = this.consultas.traerRs(this.sql);
        while (this.rs.next()) {
            try {
                this.modelo.addRow(this.dato);
                this.modelo.setValueAt(this.rs.getString(1), this.filaGrid, 0);
                this.modelo.setValueAt(this.rs.getString(2), this.filaGrid, 1);
                this.modelo.setValueAt(this.rs.getDate(3), this.filaGrid, 2);
                this.modelo.setValueAt(this.rs.getString(4) + " " + this.rs.getString(5) + " " + this.rs.getString(6) + " " + this.rs.getString(7), this.filaGrid, 3);
                this.modelo.setValueAt(this.rs.getString(8), this.filaGrid, 4);
                this.modelo.setValueAt(this.rs.getString(9), this.filaGrid, 5);
                if (this.rs.getInt(10) == 0) {
                    this.modelo.setValueAt("ACTIVO", this.filaGrid, 6);
                } else {
                    this.modelo.setValueAt("ANULADO", this.filaGrid, 6);
                }
                this.filaGrid++;
            } catch (SQLException ex) {
                this.consultas.mostrarErrorSQL(ex);
                return;
            }
        }
        this.rs.close();
        this.consultas.cerrarConexionBd();
    }

    public void cargarFaltante() {
        if (this.filaGrid > -1 && this.filaGrid < this.modelo.getRowCount()) {
            try {
                this.frmFaltante.cboFaltantes.setSelectedItem(this.modelo.getValueAt(this.filaGrid, 0).toString());
                this.frmFaltante.setSelected(true);
            } catch (PropertyVetoException e) {
                this.metodos.mostrarErrorE(e);
            }
        }
        dispose();
    }

    private void crearGrid() {
        this.modelo = new DefaultTableModel() { // from class: Inventarios.BuscarFaltante.2
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.modelo.addColumn("No. Faltante");
        this.modelo.addColumn("No. Despacho");
        this.modelo.addColumn("Fecha");
        this.modelo.addColumn("Paciente");
        this.modelo.addColumn("Profesional");
        this.modelo.addColumn("Observación");
        this.modelo.addColumn("Estado");
        this.grid.setModel(this.modelo);
        this.grid.getColumnModel().getColumn(0).setPreferredWidth(70);
        this.grid.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(3).setPreferredWidth(250);
        this.grid.getColumnModel().getColumn(4).setPreferredWidth(250);
        this.grid.getColumnModel().getColumn(5).setPreferredWidth(150);
        this.grid.getColumnModel().getColumn(6).setPreferredWidth(10);
        this.grid.getColumnModel().getColumn(0).setMinWidth(80);
        this.grid.getColumnModel().getColumn(0).setMaxWidth(80);
        this.grid.getColumnModel().getColumn(1).setMinWidth(80);
        this.grid.getColumnModel().getColumn(1).setMaxWidth(100);
        this.grid.getColumnModel().getColumn(2).setMinWidth(100);
        this.grid.getColumnModel().getColumn(2).setMaxWidth(80);
        this.grid.getColumnModel().getColumn(3).setMinWidth(250);
        this.grid.getColumnModel().getColumn(3).setMaxWidth(250);
        this.grid.getColumnModel().getColumn(4).setMinWidth(250);
        this.grid.getColumnModel().getColumn(4).setMaxWidth(250);
        this.grid.getColumnModel().getColumn(5).setMinWidth(150);
        this.grid.getColumnModel().getColumn(5).setMaxWidth(150);
        this.grid.getColumnModel().getColumn(6).setMinWidth(80);
        this.grid.getColumnModel().getColumn(6).setMaxWidth(80);
    }

    private void limpiarGrid() {
        for (int i = 0; i < this.grid.getRowCount(); i++) {
            this.modelo.removeRow(i);
        }
        this.filaGrid = 0;
    }

    /* JADX WARN: Type inference failed for: r3v33, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.txtTitulo = new JLabel();
        this.jPanel1 = new JPanel();
        this.txtHistoria = new JTextField();
        this.txtNombre2 = new JTextField();
        this.txtApellido1 = new JTextField();
        this.txtApellido2 = new JTextField();
        this.txtNombre1 = new JTextField();
        this.btnBuscar = new JButton();
        this.jScrollPane1 = new JScrollPane();
        this.grid = new JTable();
        this.jPanel2 = new JPanel();
        this.btnAceptar = new JButton();
        this.btnSalir = new JButton();
        setDefaultCloseOperation(2);
        setName("BuscarFaltante");
        getContentPane().setLayout(new AbsoluteLayout());
        this.txtTitulo.setBackground((Color) null);
        this.txtTitulo.setFont(new Font("Arial", 1, 14));
        this.txtTitulo.setForeground(new Color(0, 102, 0));
        this.txtTitulo.setHorizontalAlignment(0);
        this.txtTitulo.setText("BUSQUEDA DE PENDIENTES / FALTANTES POR ENTREGAR");
        this.txtTitulo.setOpaque(true);
        getContentPane().add(this.txtTitulo, new AbsoluteConstraints(0, 0, 1080, 40));
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "NÚMERO DE HISTORIA", 0, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.jPanel1.setLayout((LayoutManager) null);
        this.txtHistoria.setFont(new Font("Arial", 1, 14));
        this.txtHistoria.setHorizontalAlignment(4);
        this.txtHistoria.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Historia", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtHistoria.addActionListener(new ActionListener() { // from class: Inventarios.BuscarFaltante.3
            public void actionPerformed(ActionEvent evt) {
                BuscarFaltante.this.txtHistoriaActionPerformed(evt);
            }
        });
        this.txtHistoria.addFocusListener(new FocusAdapter() { // from class: Inventarios.BuscarFaltante.4
            public void focusLost(FocusEvent evt) {
                BuscarFaltante.this.txtHistoriaFocusLost(evt);
            }
        });
        this.jPanel1.add(this.txtHistoria);
        this.txtHistoria.setBounds(10, 37, 150, 43);
        this.txtNombre2.setFont(new Font("Arial", 1, 12));
        this.txtNombre2.setBorder(BorderFactory.createTitledBorder((Border) null, "Segundo Nombre", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtNombre2.addActionListener(new ActionListener() { // from class: Inventarios.BuscarFaltante.5
            public void actionPerformed(ActionEvent evt) {
                BuscarFaltante.this.txtNombre2ActionPerformed(evt);
            }
        });
        this.jPanel1.add(this.txtNombre2);
        this.txtNombre2.setBounds(650, 40, 150, 40);
        this.txtApellido1.setFont(new Font("Arial", 1, 12));
        this.txtApellido1.setBorder(BorderFactory.createTitledBorder((Border) null, "Primer Apellido", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtApellido1.addActionListener(new ActionListener() { // from class: Inventarios.BuscarFaltante.6
            public void actionPerformed(ActionEvent evt) {
                BuscarFaltante.this.txtApellido1ActionPerformed(evt);
            }
        });
        this.jPanel1.add(this.txtApellido1);
        this.txtApellido1.setBounds(170, 39, 150, 41);
        this.txtApellido2.setFont(new Font("Arial", 1, 12));
        this.txtApellido2.setBorder(BorderFactory.createTitledBorder((Border) null, "Segundo Apellido", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtApellido2.addActionListener(new ActionListener() { // from class: Inventarios.BuscarFaltante.7
            public void actionPerformed(ActionEvent evt) {
                BuscarFaltante.this.txtApellido2ActionPerformed(evt);
            }
        });
        this.jPanel1.add(this.txtApellido2);
        this.txtApellido2.setBounds(330, 40, 150, 40);
        this.txtNombre1.setFont(new Font("Arial", 1, 12));
        this.txtNombre1.setBorder(BorderFactory.createTitledBorder((Border) null, "Primer Nombre", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtNombre1.addActionListener(new ActionListener() { // from class: Inventarios.BuscarFaltante.8
            public void actionPerformed(ActionEvent evt) {
                BuscarFaltante.this.txtNombre1ActionPerformed(evt);
            }
        });
        this.jPanel1.add(this.txtNombre1);
        this.txtNombre1.setBounds(490, 40, 150, 40);
        this.btnBuscar.setFont(new Font("Arial", 1, 12));
        this.btnBuscar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Buscar.png")));
        this.btnBuscar.setText("Buscar");
        this.btnBuscar.addActionListener(new ActionListener() { // from class: Inventarios.BuscarFaltante.9
            public void actionPerformed(ActionEvent evt) {
                BuscarFaltante.this.btnBuscarActionPerformed(evt);
            }
        });
        this.jPanel1.add(this.btnBuscar);
        this.btnBuscar.setBounds(820, 33, 220, 40);
        getContentPane().add(this.jPanel1, new AbsoluteConstraints(0, 40, 1070, 100));
        this.grid.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.jScrollPane1.setViewportView(this.grid);
        getContentPane().add(this.jScrollPane1, new AbsoluteConstraints(0, 150, 1070, 240));
        this.jPanel2.setBorder(BorderFactory.createEtchedBorder());
        this.jPanel2.setLayout((LayoutManager) null);
        this.btnAceptar.setFont(new Font("Arial", 1, 12));
        this.btnAceptar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.btnAceptar.setText("Cargar El Faltante");
        this.btnAceptar.addActionListener(new ActionListener() { // from class: Inventarios.BuscarFaltante.10
            public void actionPerformed(ActionEvent evt) {
                BuscarFaltante.this.btnAceptarActionPerformed(evt);
            }
        });
        this.jPanel2.add(this.btnAceptar);
        this.btnAceptar.setBounds(10, 20, 500, 50);
        this.btnSalir.setFont(new Font("Arial", 1, 12));
        this.btnSalir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.btnSalir.setText("Salir");
        this.btnSalir.addActionListener(new ActionListener() { // from class: Inventarios.BuscarFaltante.11
            public void actionPerformed(ActionEvent evt) {
                BuscarFaltante.this.btnSalirActionPerformed(evt);
            }
        });
        this.jPanel2.add(this.btnSalir);
        this.btnSalir.setBounds(530, 20, 500, 50);
        getContentPane().add(this.jPanel2, new AbsoluteConstraints(0, 400, 1070, 80));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtHistoriaActionPerformed(ActionEvent evt) {
        this.txtApellido1.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtHistoriaFocusLost(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtNombre2ActionPerformed(ActionEvent evt) {
        this.btnBuscar.requestFocus();
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
    public void btnBuscarActionPerformed(ActionEvent evt) {
        buscar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnAceptarActionPerformed(ActionEvent evt) {
        cargarFaltante();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnSalirActionPerformed(ActionEvent evt) {
        dispose();
    }
}
