package Configuracion;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
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
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.table.DefaultTableModel;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

/* JADX INFO: loaded from: GenomaP.jar:Configuracion/G_Plantilla.class */
public class G_Plantilla extends JInternalFrame {
    private ResultSet rs;
    private int filaGrid;
    private int numMaxCar;
    private int numMaxCod;
    private String sql;
    private String tabla;
    private Object[] dato;
    private DefaultTableModel modelo;
    private JTable grid;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JTextField txtCodigo;
    private JTextField txtEstado;
    private JTextField txtNombre;
    private JLabel txtTitulo;
    private int grabar = 0;
    private Metodos metodos = new Metodos();
    private ConsultasMySQL consultas = new ConsultasMySQL();
    private GregorianCalendar fechaActual = new GregorianCalendar();
    private SimpleDateFormat formatofecha = new SimpleDateFormat("yyyy/MM/dd kk:mm");

    public G_Plantilla(String xtabla, String xEtiqueta, int xNumMaxCod, int xNumMaxCar) {
        this.numMaxCar = 0;
        this.numMaxCod = 0;
        initComponents();
        setTitle(xEtiqueta);
        this.txtTitulo.setText(xEtiqueta);
        this.tabla = xtabla;
        this.numMaxCar = xNumMaxCar;
        this.numMaxCod = xNumMaxCod;
        if (this.tabla.equals("g_tipoidentificacion") || this.tabla.equals("g_sexo")) {
            this.txtCodigo.setEnabled(true);
        }
        this.grid.addMouseListener(new MouseAdapter() { // from class: Configuracion.G_Plantilla.1
            public void mouseClicked(MouseEvent e) {
                G_Plantilla.this.filaGrid = G_Plantilla.this.grid.rowAtPoint(e.getPoint());
                G_Plantilla.this.cargarDatosDelGrid();
            }
        });
        cargarDatos();
    }

    private void buscar() {
        try {
            this.sql = "SELECT Id, Nbre, Estado FROM " + this.tabla + " WHERE (Id = '" + this.txtCodigo.getText().toUpperCase() + "')";
            this.rs = this.consultas.traerRs(this.sql);
            this.rs.next();
            if (this.rs.getRow() != 0) {
                this.txtNombre.setText(this.rs.getString(2));
                if (this.rs.getInt(3) == 0) {
                    this.txtEstado.setText("Activo");
                } else {
                    this.txtEstado.setText("InActivo");
                }
            }
            this.rs.close();
            this.consultas.cerrarConexionBd();
            this.grabar = 0;
        } catch (SQLException ex) {
            Logger.getLogger(G_Plantilla.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void cargarDatos() {
        crearGrid();
        this.filaGrid = 0;
        try {
            this.sql = "SELECT Id, Nbre, Estado FROM " + this.tabla + " ORDER BY Nbre";
            this.rs = this.consultas.traerRs(this.sql);
            this.rs.beforeFirst();
            while (this.rs.next()) {
                this.modelo.addRow(this.dato);
                this.modelo.setValueAt(this.rs.getString(1), this.filaGrid, 0);
                this.modelo.setValueAt(this.rs.getString(2), this.filaGrid, 1);
                if (this.rs.getInt(3) == 0) {
                    this.modelo.setValueAt("Activo", this.filaGrid, 2);
                } else {
                    this.modelo.setValueAt("InActivo", this.filaGrid, 2);
                }
                this.filaGrid++;
            }
            this.rs.close();
            this.consultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(G_Plantilla.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cargarDatosDelGrid() {
        this.txtCodigo.setText((String) this.modelo.getValueAt(this.filaGrid, 0));
        this.txtNombre.setText((String) this.modelo.getValueAt(this.filaGrid, 1));
        this.txtEstado.setText((String) this.modelo.getValueAt(this.filaGrid, 2));
        this.grabar = 1;
    }

    private void crearGrid() {
        this.modelo = new DefaultTableModel() { // from class: Configuracion.G_Plantilla.2
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.modelo.addColumn("CODIGO");
        this.modelo.addColumn("NOMBRE");
        this.modelo.addColumn("Estado");
        this.grid.setModel(this.modelo);
        this.grid.getColumnModel().getColumn(0).setPreferredWidth(50);
        this.grid.getColumnModel().getColumn(1).setPreferredWidth(400);
        this.grid.getColumnModel().getColumn(2).setPreferredWidth(100);
    }

    public void eliminar() {
        int pregunta = JOptionPane.showConfirmDialog(this, "Esta seguro de Eliminar", Principal.getTitulo(), 0, 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (pregunta == 0) {
            this.sql = "DELETE FROM " + this.tabla + " WHERE (Id = '" + this.modelo.getValueAt(this.filaGrid, 0) + "')";
            this.consultas.ejecutarSQL(this.sql);
            this.consultas.cerrarConexionBd();
            this.modelo.removeRow(this.filaGrid);
            this.metodos.mostrarMensaje("Registro Eliminado, Ok");
        }
    }

    public void modificar() {
        if (this.txtNombre.getText().isEmpty()) {
            this.metodos.mostrarMensaje("Por favor escriba un texto para el Nombre");
            return;
        }
        this.sql = "UPDATE " + this.tabla + " SET Nbre = '" + this.txtNombre.getText().toUpperCase() + "', Fecha = '" + this.formatofecha.format(this.fechaActual.getTime()) + "', UsuarioS = '" + Principal.usuarioSistemaDTO.getLogin() + "' WHERE (Id = '" + this.txtCodigo.getText().toUpperCase() + "')";
        this.consultas.ejecutarSQL(this.sql);
        cargarDatos();
        this.consultas.cerrarConexionBd();
        this.metodos.mostrarMensaje("Registro Actualizado.");
        this.grabar = 1;
    }

    public void grabar() {
        if (this.grabar == 0) {
            this.sql = "INSERT INTO " + this.tabla + " (";
            if (this.txtCodigo.isEnabled()) {
                this.sql += "Id,";
            }
            this.sql += "Nbre, Fecha, UsuarioS) values('";
            if (this.txtCodigo.isEnabled()) {
                this.sql += this.txtCodigo.getText().toUpperCase() + "','";
            }
            this.sql += this.txtNombre.getText().toUpperCase() + "','" + this.formatofecha.format(this.fechaActual.getTime()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
            this.consultas.ejecutarSQL(this.sql);
            cargarDatos();
            this.consultas.cerrarConexionBd();
            this.grabar = 1;
            this.metodos.mostrarMensaje("Registro Grabado");
            return;
        }
        modificar();
    }

    public void nuevo() {
        this.txtCodigo.setText("Nuevo");
        if (this.tabla.equals("g_sexo") || this.tabla.equals("g_tipoidentificacion")) {
            this.txtCodigo.setText("");
        }
        this.txtNombre.setText("");
        this.txtEstado.setText("Activo");
        if (this.txtCodigo.isEnabled()) {
            this.txtCodigo.requestFocus();
        } else {
            this.txtNombre.requestFocus();
        }
        this.grabar = 0;
    }

    /* JADX WARN: Type inference failed for: r3v7, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.txtTitulo = new JLabel();
        this.jScrollPane2 = new JScrollPane();
        this.jScrollPane1 = new JScrollPane();
        this.grid = new JTable();
        this.jPanel2 = new JPanel();
        this.jLabel1 = new JLabel();
        this.txtCodigo = new JTextField();
        this.jLabel2 = new JLabel();
        this.txtNombre = new JTextField();
        this.txtEstado = new JTextField();
        setClosable(true);
        setIconifiable(true);
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/icono.png")));
        setName("G_Plantilla");
        getContentPane().setLayout(new AbsoluteLayout());
        this.jPanel1.setBorder(BorderFactory.createEtchedBorder());
        this.jPanel1.setName("frmPanelATC");
        this.txtTitulo.setBackground(new Color(0, 0, 153));
        this.txtTitulo.setFont(new Font("Tahoma", 3, 18));
        this.txtTitulo.setForeground(new Color(204, 204, 255));
        this.txtTitulo.setHorizontalAlignment(0);
        this.txtTitulo.setText("titulo");
        this.txtTitulo.setBorder(BorderFactory.createEtchedBorder());
        this.txtTitulo.setOpaque(true);
        this.grid.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.grid.setRowHeight(22);
        this.grid.addKeyListener(new KeyAdapter() { // from class: Configuracion.G_Plantilla.3
            public void keyReleased(KeyEvent evt) {
                G_Plantilla.this.gridKeyReleased(evt);
            }
        });
        this.jScrollPane1.setViewportView(this.grid);
        this.jScrollPane2.setViewportView(this.jScrollPane1);
        this.jPanel2.setBorder(BorderFactory.createEtchedBorder());
        this.jLabel1.setFont(new Font("Tahoma", 1, 12));
        this.jLabel1.setForeground(new Color(0, 0, 153));
        this.jLabel1.setText("Código");
        this.txtCodigo.setFont(new Font("Tahoma", 0, 12));
        this.txtCodigo.setEnabled(false);
        this.txtCodigo.addActionListener(new ActionListener() { // from class: Configuracion.G_Plantilla.4
            public void actionPerformed(ActionEvent evt) {
                G_Plantilla.this.txtCodigoActionPerformed(evt);
            }
        });
        this.txtCodigo.addFocusListener(new FocusAdapter() { // from class: Configuracion.G_Plantilla.5
            public void focusLost(FocusEvent evt) {
                G_Plantilla.this.txtCodigoFocusLost(evt);
            }
        });
        this.txtCodigo.addKeyListener(new KeyAdapter() { // from class: Configuracion.G_Plantilla.6
            public void keyPressed(KeyEvent evt) {
                G_Plantilla.this.txtCodigoKeyPressed(evt);
            }

            public void keyTyped(KeyEvent evt) {
                G_Plantilla.this.txtCodigoKeyTyped(evt);
            }
        });
        this.jLabel2.setFont(new Font("Tahoma", 1, 12));
        this.jLabel2.setForeground(new Color(0, 0, 153));
        this.jLabel2.setText("Nombre");
        this.txtNombre.setFont(new Font("Tahoma", 0, 12));
        this.txtNombre.addKeyListener(new KeyAdapter() { // from class: Configuracion.G_Plantilla.7
            public void keyTyped(KeyEvent evt) {
                G_Plantilla.this.txtNombreKeyTyped(evt);
            }
        });
        this.txtEstado.setHorizontalAlignment(0);
        this.txtEstado.setText("Activo");
        this.txtEstado.setBorder(BorderFactory.createTitledBorder("Estado"));
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.jLabel1, -2, 50, -2).addGap(66, 66, 66).addComponent(this.jLabel2, -1, 189, 32767).addGap(603, 603, 603)).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.txtCodigo, -2, 110, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txtNombre, -2, 647, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.txtEstado, -2, 106, -2))).addContainerGap()));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGap(20, 20, 20).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel1).addComponent(this.jLabel2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.txtCodigo, -2, 25, -2).addComponent(this.txtNombre, -2, 25, -2).addComponent(this.txtEstado, -2, -1, -2)).addContainerGap(34, 32767)));
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.jScrollPane2, GroupLayout.Alignment.LEADING).addComponent(this.txtTitulo, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.jPanel2, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addContainerGap(-1, 32767)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.txtTitulo, -2, 32, -2).addGap(18, 18, 18).addComponent(this.jPanel2, -2, -1, -2).addGap(18, 18, 18).addComponent(this.jScrollPane2, -1, 289, 32767).addContainerGap()));
        getContentPane().add(this.jPanel1, new AbsoluteConstraints(0, 0, -1, 510));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtCodigoActionPerformed(ActionEvent evt) {
        this.txtNombre.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtCodigoFocusLost(FocusEvent evt) {
        if (this.txtCodigo.getText().length() > this.numMaxCod) {
            this.metodos.mostrarMensaje("El Número máximo de carácteres para este campo es de " + this.numMaxCod);
            this.txtCodigo.setText(this.txtCodigo.getText().substring(0, this.numMaxCod - 1));
        }
        buscar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtCodigoKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtCodigoKeyTyped(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtNombreKeyTyped(KeyEvent evt) {
        if (this.txtNombre.getText().length() > this.numMaxCar) {
            this.metodos.mostrarMensaje("El Número máximo de carácteres para este campo es de " + this.numMaxCar);
            this.txtNombre.setText(this.txtNombre.getText().substring(0, this.numMaxCar - 1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gridKeyReleased(KeyEvent evt) {
        this.filaGrid = this.grid.getSelectedRow();
        cargarDatosDelGrid();
    }
}
