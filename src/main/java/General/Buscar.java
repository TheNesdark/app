package General;

import Utilidades.ConsultasMySQL;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:General/Buscar.class */
public class Buscar extends JDialog {
    private DefaultTableModel modelo;
    private int filaGrid;
    private String sql;
    private String tabla;
    private ResultSet rs;
    private ConsultasMySQL consultas;
    private Object[] dato;
    private JTable grid;
    private JScrollPane jScrollPane1;
    private JTextField txtNombre;

    public Buscar(Frame parent, boolean modal, String tabla) {
        super(parent, modal);
        this.filaGrid = 0;
        this.consultas = new ConsultasMySQL();
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        this.tabla = tabla;
        setLocationRelativeTo(null);
        crearGrid();
        this.grid.addMouseListener(new MouseAdapter() { // from class: General.Buscar.1
            public void mouseClicked(MouseEvent e) {
                Buscar.this.filaGrid = Buscar.this.grid.rowAtPoint(e.getPoint());
                if (e.getClickCount() > 1) {
                }
            }
        });
    }

    public String getNombre() {
        return this.modelo.getValueAt(this.filaGrid, 1).toString();
    }

    private void cargarGrid() {
        crearGrid();
        this.sql = "SELECT Id, Nbre FROM " + this.tabla + " WHERE (Estado = 0 AND Nbre like'" + this.txtNombre.getText() + "%') ORDER BY Nbre ASC";
        this.rs = this.consultas.traerRs(this.sql);
        while (this.rs.next()) {
            try {
                this.modelo.addRow(this.dato);
                this.modelo.setValueAt(this.rs.getString(1), this.filaGrid, 0);
                this.modelo.setValueAt(this.rs.getString(2), this.filaGrid, 1);
                this.filaGrid++;
            } catch (SQLException ex) {
                Logger.getLogger(Buscar.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                return;
            }
        }
        this.rs.close();
        this.consultas.cerrarConexionBd();
    }

    private void crearGrid() {
        this.modelo = new DefaultTableModel() { // from class: General.Buscar.2
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.modelo.addColumn("");
        this.modelo.addColumn("Nombre");
        this.grid.setModel(this.modelo);
        this.grid.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.grid.getColumnModel().getColumn(0).setMinWidth(0);
        this.grid.getColumnModel().getColumn(0).setMaxWidth(0);
        this.grid.getColumnModel().getColumn(1).setPreferredWidth(800);
        this.grid.getColumnModel().getColumn(1).setMinWidth(800);
        this.grid.getColumnModel().getColumn(1).setMaxWidth(800);
        this.filaGrid = 0;
    }

    /* JADX WARN: Type inference failed for: r3v4, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.txtNombre = new JTextField();
        this.jScrollPane1 = new JScrollPane();
        this.grid = new JTable();
        setDefaultCloseOperation(2);
        setTitle("Buscar");
        setName("Buscar");
        this.txtNombre.setFont(new Font("Arial", 1, 12));
        this.txtNombre.addKeyListener(new KeyAdapter() { // from class: General.Buscar.3
            public void keyPressed(KeyEvent evt) {
                Buscar.this.txtNombreKeyPressed(evt);
            }

            public void keyReleased(KeyEvent evt) {
                Buscar.this.txtNombreKeyReleased(evt);
            }

            public void keyTyped(KeyEvent evt) {
                Buscar.this.txtNombreKeyTyped(evt);
            }
        });
        this.grid.setFont(new Font("Arial", 1, 12));
        this.grid.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.grid.setRowHeight(25);
        this.grid.setSelectionBackground(new Color(255, 255, 255));
        this.grid.setSelectionForeground(new Color(255, 0, 0));
        this.grid.setSelectionMode(0);
        this.jScrollPane1.setViewportView(this.grid);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jScrollPane1, GroupLayout.Alignment.LEADING, -1, 949, 32767).addComponent(this.txtNombre, GroupLayout.Alignment.LEADING, -1, 949, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.txtNombre, -2, 31, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane1, -2, 309, -2).addContainerGap(-1, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtNombreKeyTyped(KeyEvent evt) {
        cargarGrid();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtNombreKeyReleased(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtNombreKeyPressed(KeyEvent evt) {
    }
}
