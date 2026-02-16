package General;

import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:General/BuscarPersona.class */
public class BuscarPersona extends JDialog {
    private ConsultasMySQL consultas;
    private Metodos metodos;
    private int filaGrid;
    private String sql;
    private ResultSet rs;
    private Object[] dato;
    public String[][] listaPersonas;
    public DefaultTableModel modelo;
    private Persona frmPersona;
    private JButton btnOk;
    private JButton btnSalir;
    private JTable grid;
    private JScrollPane jScrollPane1;

    public BuscarPersona(Frame parent, boolean modal, Persona frm) {
        super(parent, modal);
        this.consultas = new ConsultasMySQL();
        this.metodos = new Metodos();
        this.filaGrid = 0;
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        setLocationRelativeTo(null);
        this.frmPersona = frm;
        crearGrid();
        buscar();
    }

    private void cargarDatosEnPersonas() {
        if (this.grid.getSelectedRow() != -1) {
            this.frmPersona.setIdPersona(this.modelo.getValueAt(this.grid.getSelectedRow(), 0).toString());
            this.frmPersona.buscar(1);
            dispose();
        }
    }

    private void crearGrid() {
        this.modelo = new DefaultTableModel() { // from class: General.BuscarPersona.1
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.modelo.addColumn("");
        this.modelo.addColumn("Historia");
        this.modelo.addColumn("Tipo Identificación");
        this.modelo.addColumn("No. Identificación");
        this.modelo.addColumn("Primer Apellido");
        this.modelo.addColumn("Segundo Apellido");
        this.modelo.addColumn("Primer Nombre");
        this.modelo.addColumn("Segundo Nombre");
        this.grid.setModel(this.modelo);
        this.grid.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.grid.getColumnModel().getColumn(0).setMinWidth(0);
        this.grid.getColumnModel().getColumn(0).setMaxWidth(0);
    }

    public final void buscar() {
        buscarPersona();
    }

    public void buscarPersona() {
        this.sql = "SELECT g_persona.Id, g_usuario.NoHistoria, g_tipoidentificacion.Nbre, g_persona.NoDocumento, g_persona.Apellido1, g_persona.Apellido2, g_persona.Nombre1, g_persona.Nombre2 FROM g_persona INNER JOIN g_tipoidentificacion ON (g_persona.Id_TipoIdentificacion = g_tipoidentificacion.Id) INNER JOIN g_usuario ON (g_persona.Id = g_usuario.Id_persona) WHERE (g_persona.Id > 0 ";
        if (this.frmPersona.cboTipoIdentificacion.getSelectedIndex() > -1) {
            this.sql += " AND g_persona.Id_TipoIdentificacion = '" + this.frmPersona.listaTipoIdentificacion[this.frmPersona.cboTipoIdentificacion.getSelectedIndex()][0] + "' AND g_persona.NoDocumento ='" + this.frmPersona.txtIdentificacion.getText() + "'";
        }
        if (!this.frmPersona.txtIdentificacion.getText().isEmpty()) {
            this.sql += " AND g_persona.NoDocumento ='" + this.frmPersona.txtIdentificacion.getText() + "'";
        }
        if (!this.frmPersona.getApellido1().isEmpty()) {
            this.sql += " AND g_persona.Apellido1 like '" + this.frmPersona.getApellido1() + "%'";
        }
        if (!this.frmPersona.getApellido2().isEmpty()) {
            this.sql += " AND g_persona.Apellido2 like '" + this.frmPersona.getApellido2() + "%'";
        }
        if (!this.frmPersona.getNombre1().isEmpty()) {
            this.sql += " AND g_persona.Nombre1 like '" + this.frmPersona.getNombre1() + "%'";
        }
        if (!this.frmPersona.getNombre2().isEmpty()) {
            this.sql += " AND g_persona.Nombre2 like '" + this.frmPersona.getNombre2() + "%'";
        }
        this.sql += ") ORDER BY g_persona.Apellido1 ASC, g_persona.Apellido2 ASC, g_persona.Nombre1 ASC, g_persona.Nombre2 ASC";
        System.out.println(this.sql);
        this.rs = this.consultas.traerRs(this.sql);
        try {
            this.rs.next();
            if (this.rs.getRow() > 0) {
                this.filaGrid = 0;
                this.rs.beforeFirst();
                while (this.rs.next()) {
                    this.modelo.addRow(this.dato);
                    this.modelo.setValueAt(this.rs.getString(1), this.filaGrid, 0);
                    this.modelo.setValueAt(this.rs.getString(2), this.filaGrid, 1);
                    this.modelo.setValueAt(this.rs.getString(3), this.filaGrid, 2);
                    this.modelo.setValueAt(this.rs.getString(4), this.filaGrid, 3);
                    this.modelo.setValueAt(this.rs.getString(5), this.filaGrid, 4);
                    this.modelo.setValueAt(this.rs.getString(6), this.filaGrid, 5);
                    this.modelo.setValueAt(this.rs.getString(7), this.filaGrid, 6);
                    this.modelo.setValueAt(this.rs.getString(8), this.filaGrid, 7);
                    this.filaGrid++;
                }
            } else {
                this.metodos.mostrarMensaje("No se ha encontrado coincidencia");
            }
            this.rs.close();
            this.consultas.cerrarConexionBd();
        } catch (SQLException ex) {
            this.consultas.mostrarErrorSQL(ex);
        }
    }

    /* JADX WARN: Type inference failed for: r3v13, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.btnSalir = new JButton();
        this.btnOk = new JButton();
        this.jScrollPane1 = new JScrollPane();
        this.grid = new JTable();
        setDefaultCloseOperation(2);
        setTitle("BÚSQUEDA DE USUARIOS");
        setName("BuscarPersona");
        setResizable(false);
        this.btnSalir.setFont(new Font("Arial", 1, 12));
        this.btnSalir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.btnSalir.setText("Salir");
        this.btnSalir.addActionListener(new ActionListener() { // from class: General.BuscarPersona.2
            public void actionPerformed(ActionEvent evt) {
                BuscarPersona.this.btnSalirActionPerformed(evt);
            }
        });
        this.btnOk.setFont(new Font("Arial", 1, 12));
        this.btnOk.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.btnOk.setText("Ok");
        this.btnOk.addActionListener(new ActionListener() { // from class: General.BuscarPersona.3
            public void actionPerformed(ActionEvent evt) {
                BuscarPersona.this.btnOkActionPerformed(evt);
            }
        });
        this.jScrollPane1.setBorder(BorderFactory.createTitledBorder((Border) null, "RESULTADO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.grid.setFont(new Font("Arial", 1, 12));
        this.grid.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.grid.setColumnSelectionAllowed(true);
        this.grid.setRowHeight(25);
        this.grid.setSelectionBackground(Color.white);
        this.grid.setSelectionForeground(new Color(255, 0, 0));
        this.grid.setSelectionMode(0);
        this.grid.addMouseListener(new MouseAdapter() { // from class: General.BuscarPersona.4
            public void mouseClicked(MouseEvent evt) {
                BuscarPersona.this.gridMouseClicked(evt);
            }
        });
        this.jScrollPane1.setViewportView(this.grid);
        this.grid.getColumnModel().getSelectionModel().setSelectionMode(0);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(10, 10, 10).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.jScrollPane1).addGroup(layout.createSequentialGroup().addComponent(this.btnOk, -2, 467, -2).addGap(13, 13, 13).addComponent(this.btnSalir, -2, 454, -2))).addGap(16, 16, 16)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane1, -2, 426, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.btnOk, -2, 50, -2).addComponent(this.btnSalir, -2, 50, -2)).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnSalirActionPerformed(ActionEvent evt) {
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnOkActionPerformed(ActionEvent evt) {
        cargarDatosEnPersonas();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gridMouseClicked(MouseEvent evt) {
        cargarDatosEnPersonas();
    }
}
