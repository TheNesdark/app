package Laboratorio;

import Acceso.Principal;
import General.Anular;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Laboratorio/TipoResultado.class */
public class TipoResultado extends JInternalFrame {
    private ResultSet rs;
    private Object[] fila;
    private String sql;
    private String id;
    private DefaultTableModel modelo;
    private int filaGrid;
    private JCheckBox btnAlerta;
    private JCheckBox btnNumerico;
    private JTable grid;
    private JLabel jLabel1;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;
    private JTextField txtId;
    private JTextField txtNombre;
    private ConsultasMySQL consultas = new ConsultasMySQL();
    private Metodos metodos = new Metodos();
    private int numerico = 1;
    private int alerta = 1;
    private int grabar = 0;

    public TipoResultado() {
        initComponents();
        cargarGrid();
        this.grid.addMouseListener(new MouseAdapter() { // from class: Laboratorio.TipoResultado.1
            public void mouseClicked(MouseEvent e) {
                TipoResultado.this.filaGrid = TipoResultado.this.grid.rowAtPoint(e.getPoint());
                TipoResultado.this.grabar = 1;
                TipoResultado.this.cargarDatosDelGrid();
            }
        });
    }

    public void anular() {
        if (Principal.txtNo.getText().isEmpty()) {
            this.metodos.mostrarMensaje("Por Favor seleccione un Tipo de Resultado");
        } else if (Principal.txtEstado.getText().equals("ANULADA")) {
            this.metodos.mostrarMensaje("El Tipo de Resultado ya se encuentra Anulado");
        } else {
            Anular frm = new Anular(null, true, "TipoResultado", 24);
            frm.setVisible(true);
        }
    }

    public void anularTipo(String razon) {
        this.sql = "UPDATE l_tiporesultado SET Estado = 1 WHERE Id='" + this.id + "'";
        this.consultas.ejecutarSQL(this.sql);
        this.consultas.cerrarConexionBd();
        this.metodos.marcarEstado(1);
        crearGrid();
        cargarGrid();
        this.metodos.mostrarMensaje("Tipo de Resultado Anulado");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cargarDatosDelGrid() {
        this.id = this.modelo.getValueAt(this.filaGrid, 0).toString();
        this.txtId.setText(this.id);
        Principal.txtNo.setText(this.id);
        this.txtNombre.setText(this.modelo.getValueAt(this.filaGrid, 1).toString());
        if (this.modelo.getValueAt(this.filaGrid, 2).toString().equals("Si")) {
            this.btnNumerico.setSelected(true);
        } else {
            this.btnNumerico.setSelected(false);
        }
        if (this.modelo.getValueAt(this.filaGrid, 3).toString().equals("Si")) {
            this.btnAlerta.setSelected(true);
        } else {
            this.btnAlerta.setSelected(false);
        }
        if (this.modelo.getValueAt(this.filaGrid, 4).toString().equals("Activo")) {
            this.metodos.marcarEstado(2);
        } else {
            this.metodos.marcarEstado(1);
        }
        this.grabar = 1;
    }

    private void cargarGrid() {
        crearGrid();
        this.filaGrid = 0;
        this.sql = "SELECT Id, Nbre, Vandera, GeneraAlerta, Estado FROM l_tiporesultado ORDER BY Nbre ASC";
        this.rs = this.consultas.traerRs(this.sql);
        while (this.rs.next()) {
            try {
                this.modelo.addRow(this.fila);
                this.modelo.setValueAt(this.rs.getString("Id"), this.filaGrid, 0);
                this.modelo.setValueAt(this.rs.getString("Nbre"), this.filaGrid, 1);
                if (this.rs.getInt("Vandera") == 0) {
                    this.modelo.setValueAt("Si", this.filaGrid, 2);
                } else {
                    this.modelo.setValueAt("No", this.filaGrid, 2);
                }
                if (this.rs.getInt("GeneraAlerta") == 0) {
                    this.modelo.setValueAt("Si", this.filaGrid, 3);
                } else {
                    this.modelo.setValueAt("No", this.filaGrid, 3);
                }
                if (this.rs.getInt("Estado") == 0) {
                    this.modelo.setValueAt("Activo", this.filaGrid, 4);
                } else {
                    this.modelo.setValueAt("INActivo", this.filaGrid, 4);
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

    private void crearGrid() {
        this.modelo = new DefaultTableModel() { // from class: Laboratorio.TipoResultado.2
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.modelo.addColumn("Id");
        this.modelo.addColumn("Nombre");
        this.modelo.addColumn("Numerico");
        this.modelo.addColumn("Alerta");
        this.modelo.addColumn("Estado");
        this.grid.setModel(this.modelo);
        this.grid.getColumnModel().getColumn(0).setMinWidth(80);
        this.grid.getColumnModel().getColumn(0).setMaxWidth(80);
        this.grid.getColumnModel().getColumn(1).setMinWidth(400);
        this.grid.getColumnModel().getColumn(1).setMaxWidth(400);
        this.grid.getColumnModel().getColumn(2).setMinWidth(80);
        this.grid.getColumnModel().getColumn(2).setMaxWidth(80);
        this.grid.getColumnModel().getColumn(3).setMinWidth(80);
        this.grid.getColumnModel().getColumn(3).setMaxWidth(80);
        this.grid.getColumnModel().getColumn(4).setMinWidth(80);
        this.grid.getColumnModel().getColumn(4).setMaxWidth(80);
    }

    public void grabar() {
        if (validar() == 1) {
            if (this.grabar == 0) {
                grabarRegistro();
            } else {
                modificar();
            }
            crearGrid();
            cargarGrid();
        }
    }

    private void grabarRegistro() {
        this.sql = "INSERT INTO l_tiporesultado(Nbre, Vandera, GeneraAlerta, Fecha, UsuarioS) VALUES('" + this.txtNombre.getText() + "','" + this.numerico + "','" + this.alerta + "','" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
        this.id = this.consultas.ejecutarSQLId(this.sql);
        this.consultas.cerrarConexionBd();
        Principal.txtNo.setText(this.id);
        this.metodos.mostrarMensaje("Tipo de Resultado Grabado");
    }

    private void modificar() {
        this.sql = "UPDATE l_tiporesultado SET Nbre ='" + this.txtNombre.getText() + "', Vandera ='" + this.numerico + "', GeneraAlerta ='" + this.alerta + "', Fecha ='" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "', UsuarioS ='" + Principal.usuarioSistemaDTO.getLogin() + "' WHERE Id='" + this.id + "'";
        this.consultas.ejecutarSQL(this.sql);
        this.consultas.cerrarConexionBd();
        this.metodos.mostrarMensaje("Protocolo Modificado");
    }

    public void nuevo() {
        this.txtId.setText("");
        this.txtNombre.setText("");
        this.btnNumerico.setSelected(false);
        this.btnAlerta.setSelected(false);
        this.alerta = 1;
        this.numerico = 1;
        this.id = "";
        this.metodos.limpiarDatosPrincipal();
        this.txtNombre.requestFocus();
        this.grabar = 0;
    }

    private int validar() {
        int retorno = 0;
        if (this.txtNombre.getText().isEmpty()) {
            this.metodos.mostrarMensaje("Por Favor digite el Nombre del Tipo de Resultado");
            this.txtNombre.requestFocus();
        } else {
            retorno = 1;
        }
        return retorno;
    }

    /* JADX WARN: Type inference failed for: r3v39, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.txtId = new JTextField();
        this.txtNombre = new JTextField();
        this.btnAlerta = new JCheckBox();
        this.btnNumerico = new JCheckBox();
        this.jLabel1 = new JLabel();
        this.jScrollPane1 = new JScrollPane();
        this.grid = new JTable();
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("TIPO DE RESULTADO");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("TipoResultado");
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.txtId.setFont(new Font("Arial", 1, 12));
        this.txtId.setBorder(BorderFactory.createTitledBorder((Border) null, "Id", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtId.setEnabled(false);
        this.txtNombre.setFont(new Font("Arial", 1, 12));
        this.txtNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.btnAlerta.setFont(new Font("Arial", 1, 12));
        this.btnAlerta.setText("Genera Alerta");
        this.btnAlerta.addActionListener(new ActionListener() { // from class: Laboratorio.TipoResultado.3
            public void actionPerformed(ActionEvent evt) {
                TipoResultado.this.btnAlertaActionPerformed(evt);
            }
        });
        this.btnNumerico.setFont(new Font("Arial", 1, 12));
        this.btnNumerico.setText("Numérico");
        this.btnNumerico.addActionListener(new ActionListener() { // from class: Laboratorio.TipoResultado.4
            public void actionPerformed(ActionEvent evt) {
                TipoResultado.this.btnNumericoActionPerformed(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.txtId, -2, 60, -2).addGap(5, 5, 5).addComponent(this.txtNombre, -2, 490, -2).addGap(7, 7, 7).addComponent(this.btnNumerico).addGap(1, 1, 1).addComponent(this.btnAlerta)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(11, 11, 11).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.txtNombre, -2, -1, -2).addComponent(this.txtId, -2, 60, -2))).addGroup(jPanel1Layout.createSequentialGroup().addGap(36, 36, 36).addComponent(this.btnNumerico)).addGroup(jPanel1Layout.createSequentialGroup().addGap(36, 36, 36).addComponent(this.btnAlerta)));
        this.jLabel1.setFont(new Font("Arial", 1, 14));
        this.jLabel1.setForeground(new Color(0, 102, 0));
        this.jLabel1.setHorizontalAlignment(0);
        this.jLabel1.setText("TIPOS DE RESULTADOS");
        this.jLabel1.setOpaque(true);
        this.jScrollPane1.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.grid.setFont(new Font("Arial", 1, 12));
        this.grid.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.grid.setRowHeight(25);
        this.grid.setSelectionBackground(new Color(255, 255, 255));
        this.grid.setSelectionForeground(new Color(0, 0, 255));
        this.grid.setSelectionMode(0);
        this.jScrollPane1.setViewportView(this.grid);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel1, -1, 814, 32767).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767).addComponent(this.jScrollPane1, -1, 794, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.jLabel1, -2, 30, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane1, -2, 280, -2).addContainerGap(35, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnNumericoActionPerformed(ActionEvent evt) {
        if (!this.btnNumerico.isSelected()) {
            this.numerico = 1;
        } else {
            this.numerico = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnAlertaActionPerformed(ActionEvent evt) {
        if (!this.btnAlerta.isSelected()) {
            this.alerta = 1;
        } else {
            this.alerta = 0;
        }
    }
}
