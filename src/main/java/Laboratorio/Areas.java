package Laboratorio;

import Acceso.Principal;
import General.Anular;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Laboratorio/Areas.class */
public class Areas extends JInternalFrame {
    private Metodos metodos = new Metodos();
    private ConsultasMySQL consultas = new ConsultasMySQL();
    private DefaultTableModel modelo;
    private String sql;
    private int filaGrid;
    private Object[] fila;
    private JTable grid;
    private JLabel jLabel1;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;
    private JTextField txtCodigo;
    private JTextField txtNombre;

    public Areas() {
        initComponents();
        cargarGrid();
        this.grid.addMouseListener(new MouseAdapter() { // from class: Laboratorio.Areas.1
            public void mouseClicked(MouseEvent e) {
                Areas.this.filaGrid = Areas.this.grid.rowAtPoint(e.getPoint());
                Areas.this.txtCodigo.setText(Areas.this.modelo.getValueAt(Areas.this.filaGrid, 0).toString());
                Areas.this.txtNombre.setText(Areas.this.modelo.getValueAt(Areas.this.filaGrid, 1).toString());
                Principal.txtNo.setText(Areas.this.txtCodigo.getText());
            }
        });
    }

    public void anular() {
        if (Principal.txtNo.getText().isEmpty()) {
            this.metodos.mostrarMensaje("Por Favor seleccione un Area a Anular");
        } else if (Principal.txtEstado.getText().equals("ANULADA")) {
            this.metodos.mostrarMensaje("El Area ya se encuentra Anulada.");
        } else {
            Anular frm = new Anular(null, true, "Areas", 24);
            frm.setVisible(true);
        }
    }

    public void anularArea(String razon) {
        this.sql = "UPDATE l_areas SET Estado = 1 WHERE Id='" + this.txtCodigo.getText() + "'";
        this.consultas.ejecutarSQL(this.sql);
        this.consultas.cerrarConexionBd();
        this.metodos.mostrarMensaje("Area Anulada");
    }

    private void cargarGrid() {
        crearGrid();
        this.sql = "SELECT Id, Nbre, Estado FROM l_areas ORDER BY Nbre ASC";
        ResultSet rs = this.consultas.traerRs(this.sql);
        while (rs.next()) {
            try {
                this.modelo.addRow(this.fila);
                this.modelo.setValueAt(rs.getString(1), this.filaGrid, 0);
                this.modelo.setValueAt(rs.getString(2), this.filaGrid, 1);
                if (rs.getInt(3) == 0) {
                    this.modelo.setValueAt("Activo", this.filaGrid, 2);
                } else {
                    this.modelo.setValueAt("InActivo", this.filaGrid, 2);
                }
                this.filaGrid++;
            } catch (SQLException ex) {
                this.consultas.mostrarErrorSQL(ex);
                return;
            }
        }
        rs.close();
        this.consultas.cerrarConexionBd();
    }

    private void crearGrid() {
        this.modelo = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Nombre", "Estado"}) { // from class: Laboratorio.Areas.2
            Class[] types = {String.class, String.class, String.class};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.grid.setModel(this.modelo);
        this.grid.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.grid.getColumnModel().getColumn(1).setPreferredWidth(400);
        this.grid.getColumnModel().getColumn(2).setPreferredWidth(80);
        this.grid.getColumnModel().getColumn(0).setMinWidth(80);
        this.grid.getColumnModel().getColumn(0).setMaxWidth(80);
        this.grid.getColumnModel().getColumn(1).setMinWidth(400);
        this.grid.getColumnModel().getColumn(1).setMaxWidth(400);
        this.grid.getColumnModel().getColumn(2).setMinWidth(80);
        this.grid.getColumnModel().getColumn(2).setMaxWidth(80);
        this.filaGrid = 0;
    }

    public void grabar() {
        if (this.metodos.getPregunta("Esta seguro de Grabar?") == 0 && validarDatos() == 1) {
            this.sql = "INSERT INTO l_areas(Nbre, Estado, Fecha, UsuarioS) VALUES('" + this.txtNombre.getText() + "','0','" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "')";
            this.txtCodigo.setText(this.consultas.ejecutarSQLId(this.sql));
            Principal.txtNo.setText(this.txtCodigo.getText());
            this.consultas.cerrarConexionBd();
            cargarGrid();
            this.metodos.mostrarMensaje("Registro Grabado");
        }
    }

    public void nuevo() {
        this.txtCodigo.setText("");
        this.txtNombre.setText("");
        this.txtNombre.requestFocus();
    }

    private int validarDatos() {
        int retorno = 0;
        if (this.txtNombre.getText() == null || this.txtNombre.getText().isEmpty()) {
            this.metodos.mostrarMensaje("Por favor digite el nombre del Area");
        } else {
            retorno = 1;
        }
        return retorno;
    }

    /* JADX WARN: Type inference failed for: r3v23, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jLabel1 = new JLabel();
        this.jPanel1 = new JPanel();
        this.txtCodigo = new JTextField();
        this.txtNombre = new JTextField();
        this.jScrollPane1 = new JScrollPane();
        this.grid = new JTable();
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("AREAS");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("Areas");
        this.jLabel1.setBackground((Color) null);
        this.jLabel1.setFont(new Font("Arial", 1, 14));
        this.jLabel1.setForeground(new Color(0, 102, 0));
        this.jLabel1.setHorizontalAlignment(0);
        this.jLabel1.setText("AREAS");
        this.jLabel1.setOpaque(true);
        this.txtCodigo.setFont(new Font("Arial", 1, 14));
        this.txtCodigo.setBorder(BorderFactory.createTitledBorder((Border) null, "Código ", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtCodigo.setEnabled(false);
        this.txtNombre.setFont(new Font("Arial", 1, 12));
        this.txtNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.txtCodigo, -2, 125, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.txtNombre, -2, 509, -2).addContainerGap(24, 32767)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(31, 31, 31).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.txtCodigo, -2, -1, -2).addComponent(this.txtNombre, -2, 43, -2)).addContainerGap(-1, 32767)));
        this.grid.setFont(new Font("Arial", 1, 12));
        this.grid.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[]{null, null, null, null}, new Object[]{null, null, null, null}, new Object[]{null, null, null, null}, new Object[]{null, null, null, null}}, new String[]{"Title 1", "Title 2", "Title 3", "Title 4"}));
        this.grid.setRowHeight(25);
        this.grid.setSelectionBackground(new Color(255, 255, 255));
        this.grid.setSelectionForeground(new Color(255, 0, 0));
        this.grid.setSelectionMode(0);
        this.jScrollPane1.setViewportView(this.grid);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767).addComponent(this.jLabel1, -1, 678, 32767).addComponent(this.jScrollPane1, -1, 678, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jLabel1, -2, 33, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel1, -2, -1, -2).addGap(18, 18, 18).addComponent(this.jScrollPane1, -2, 340, -2).addContainerGap(-1, 32767)));
        pack();
    }
}
