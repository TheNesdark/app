package Inventarios;

import Acceso.Menus;
import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

/* JADX INFO: loaded from: GenomaP.jar:Inventarios/ConsultarExistencias.class */
public class ConsultarExistencias extends JInternalFrame {
    private ResultSet rs;
    private Object[] dato;
    private int filaGridP;
    private String sql;
    private DefaultTableModel modeloB;
    private DefaultTableModel modeloP;
    private claseInventario claseInv;
    private ButtonGroup buttonGroup1;
    public JTable gridB;
    public JTable gridP;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JTextField txtCodigo;
    private JTextField txtProducto;
    private ConsultasMySQL consultas = new ConsultasMySQL();
    private int filaGridB = 0;

    public ConsultarExistencias(claseInventario claseI) {
        initComponents();
        this.claseInv = claseI;
        crearGridExistencias();
        crearGridProductos();
        this.gridP.addMouseListener(new MouseAdapter() { // from class: Inventarios.ConsultarExistencias.1
            public void mouseClicked(MouseEvent e) {
                ConsultarExistencias.this.filaGridP = ConsultarExistencias.this.gridP.rowAtPoint(e.getPoint());
                ConsultarExistencias.this.buscarInventario();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buscarInventario() {
        limpiarCantidades();
        this.filaGridB = 0;
        for (int i = 0; i < this.modeloB.getRowCount(); i++) {
            try {
                this.sql = "SELECT SUM(i_suministroxlotexbodega.Cantidad), ROUND(i_suministroxbodega.Costo) FROM i_suministroxlotexbodega INNER JOIN i_suministroxbodega ON (i_suministroxlotexbodega.Id = i_suministroxbodega.Id) WHERE (i_suministroxbodega.IdSuministro ='" + this.modeloP.getValueAt(this.filaGridP, 0) + "' AND i_suministroxbodega.IdBodega ='" + this.modeloB.getValueAt(i, 0) + "') GROUP BY i_suministroxbodega.IdSuministro";
                ResultSet rs1 = this.consultas.traerRs(this.sql);
                if (rs1.next()) {
                    this.modeloB.setValueAt(Integer.valueOf(rs1.getInt(1)), this.filaGridB, 2);
                    this.modeloB.setValueAt(Double.valueOf(rs1.getDouble(2)), this.filaGridB, 3);
                }
                this.filaGridB++;
                rs1.close();
                this.consultas.cerrarConexionBd();
            } catch (SQLException ex) {
                this.consultas.mostrarErrorSQL(ex);
            }
        }
    }

    private void cargarBodegas() {
        try {
            this.sql = "SELECT Id, Nbre FROM i_bodegas ORDER BY Nbre";
            this.rs = this.consultas.traerRs(this.sql);
            while (this.rs.next()) {
                this.modeloB.addRow(this.dato);
                this.modeloB.setValueAt(this.rs.getString(1), this.filaGridB, 0);
                this.modeloB.setValueAt(this.rs.getString(2), this.filaGridB, 1);
                this.filaGridB++;
            }
            this.rs.close();
            this.consultas.cerrarConexionBd();
        } catch (SQLException ex) {
            this.consultas.mostrarErrorSQL(ex);
        }
    }

    private void buscarProductos(int op) {
        crearGridProductos();
        this.sql = "SELECT i_suministro.Id, i_suministro.CodBarraUnidad, i_suministro.Nbre, i_presentacioncomercial.Nbre, i_laboratorio.Nbre FROM i_suministro INNER JOIN i_presentacioncomercial ON (i_suministro.IdPresentacionComercial = i_presentacioncomercial.Id) INNER JOIN i_laboratorio ON (i_suministro.IdLaboratorio = i_laboratorio.Id) WHERE (";
        if (op == 1) {
            this.sql += "i_suministro.CodBarraUnidad ='" + this.txtCodigo.getText() + "'";
        } else {
            this.sql += "i_suministro.Nbre like'" + this.txtProducto.getText() + "%'";
        }
        this.sql += ") GROUP BY i_suministro.Id ORDER BY i_suministro.Nbre ASC";
        this.rs = this.consultas.traerRs(this.sql);
        int fila = 0;
        while (this.rs.next()) {
            try {
                this.modeloP.addRow(this.dato);
                this.modeloP.setValueAt(this.rs.getString(1), fila, 0);
                this.modeloP.setValueAt(this.rs.getString(2), fila, 1);
                this.modeloP.setValueAt(this.rs.getString(3) + this.rs.getString(4) + this.rs.getString(5), fila, 2);
                fila++;
            } catch (SQLException ex) {
                this.consultas.mostrarErrorSQL(ex);
                return;
            }
        }
        this.rs.close();
        this.consultas.cerrarConexionBd();
    }

    private void crearGridExistencias() {
        this.modeloB = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Bodega o Stock", "Existencia", "Costo"}) { // from class: Inventarios.ConsultarExistencias.2
            Class[] types = {String.class, String.class, Integer.class, Double.class};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.gridB.setModel(this.modeloB);
        this.gridB.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.gridB.getColumnModel().getColumn(0).setMinWidth(0);
        this.gridB.getColumnModel().getColumn(0).setMaxWidth(0);
        this.gridB.getColumnModel().getColumn(1).setPreferredWidth(200);
        this.gridB.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.gridB.getColumnModel().getColumn(3).setPreferredWidth(100);
        cargarBodegas();
    }

    private void crearGridProductos() {
        this.modeloP = new DefaultTableModel() { // from class: Inventarios.ConsultarExistencias.3
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.modeloP.addColumn("");
        this.modeloP.addColumn("Codigo Barra");
        this.modeloP.addColumn("Nombre del Producto");
        this.gridP.setModel(this.modeloP);
        this.gridP.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.gridP.getColumnModel().getColumn(0).setMinWidth(0);
        this.gridP.getColumnModel().getColumn(0).setMaxWidth(0);
        this.gridP.getColumnModel().getColumn(1).setPreferredWidth(150);
        this.gridP.getColumnModel().getColumn(2).setPreferredWidth(800);
        this.gridP.getColumnModel().getColumn(1).setMinWidth(150);
        this.gridP.getColumnModel().getColumn(1).setMaxWidth(150);
        this.gridP.getColumnModel().getColumn(2).setMinWidth(800);
        this.gridP.getColumnModel().getColumn(2).setMaxWidth(800);
    }

    private void limpiarCantidades() {
        for (int f = 0; f < this.modeloB.getRowCount(); f++) {
            this.modeloB.setValueAt("0", f, 2);
        }
    }

    /* JADX WARN: Type inference failed for: r3v10, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v30, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.buttonGroup1 = new ButtonGroup();
        this.jScrollPane1 = new JScrollPane();
        this.gridB = new JTable();
        this.jPanel1 = new JPanel();
        this.txtCodigo = new JTextField();
        this.txtProducto = new JTextField();
        this.jScrollPane2 = new JScrollPane();
        this.gridP = new JTable();
        setBackground(new Color(204, 255, 204));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("CONSULTA DE EXISTENCIAS POR BODEGA");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMaximumSize(new Dimension(1021, 654));
        setMinimumSize(new Dimension(1021, 654));
        setName("ConsultarExistencia");
        setPreferredSize(new Dimension(1021, 654));
        addInternalFrameListener(new InternalFrameListener() { // from class: Inventarios.ConsultarExistencias.4
            public void internalFrameActivated(InternalFrameEvent evt) {
                ConsultarExistencias.this.formInternalFrameActivated(evt);
            }

            public void internalFrameDeactivated(InternalFrameEvent evt) {
            }

            public void internalFrameDeiconified(InternalFrameEvent evt) {
            }

            public void internalFrameIconified(InternalFrameEvent evt) {
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
            }

            public void internalFrameOpened(InternalFrameEvent evt) {
            }
        });
        getContentPane().setLayout(new AbsoluteLayout());
        this.gridB.setBorder(BorderFactory.createBevelBorder(0));
        this.gridB.setFont(new Font("Arial", 1, 12));
        this.gridB.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.gridB.setEditingColumn(1);
        this.gridB.setEditingRow(1);
        this.gridB.setGridColor(new Color(0, 51, 51));
        this.gridB.setRowHeight(25);
        this.gridB.setSelectionBackground(new Color(255, 255, 255));
        this.gridB.setSelectionForeground(new Color(255, 0, 0));
        this.gridB.setSelectionMode(0);
        this.gridB.addKeyListener(new KeyAdapter() { // from class: Inventarios.ConsultarExistencias.5
            public void keyPressed(KeyEvent evt) {
                ConsultarExistencias.this.gridBKeyPressed(evt);
            }
        });
        this.jScrollPane1.setViewportView(this.gridB);
        getContentPane().add(this.jScrollPane1, new AbsoluteConstraints(10, 340, 980, 270));
        this.jPanel1.setBackground(new Color(204, 255, 204));
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS DEL PRODUCTO", 0, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.jPanel1.setLayout(new AbsoluteLayout());
        this.txtCodigo.setFont(new Font("Arial", 1, 12));
        this.txtCodigo.setForeground(new Color(0, 0, 153));
        this.txtCodigo.setHorizontalAlignment(2);
        this.txtCodigo.setBorder(BorderFactory.createTitledBorder((Border) null, "Código de Barra", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtCodigo.addActionListener(new ActionListener() { // from class: Inventarios.ConsultarExistencias.6
            public void actionPerformed(ActionEvent evt) {
                ConsultarExistencias.this.txtCodigoActionPerformed(evt);
            }
        });
        this.jPanel1.add(this.txtCodigo, new AbsoluteConstraints(10, 40, 356, 40));
        this.txtProducto.setFont(new Font("Arial", 1, 12));
        this.txtProducto.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre del Producto", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtProducto.addKeyListener(new KeyAdapter() { // from class: Inventarios.ConsultarExistencias.7
            public void keyReleased(KeyEvent evt) {
                ConsultarExistencias.this.txtProductoKeyReleased(evt);
            }
        });
        this.jPanel1.add(this.txtProducto, new AbsoluteConstraints(380, 40, 575, 40));
        this.gridP.setBorder(BorderFactory.createBevelBorder(0));
        this.gridP.setFont(new Font("Arial", 1, 12));
        this.gridP.setForeground(new Color(0, 0, 204));
        this.gridP.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.gridP.setEditingColumn(1);
        this.gridP.setEditingRow(1);
        this.gridP.setGridColor(new Color(204, 255, 204));
        this.gridP.setRowHeight(25);
        this.gridP.setSelectionBackground(new Color(255, 255, 255));
        this.gridP.setSelectionForeground(new Color(255, 0, 0));
        this.gridP.setSelectionMode(0);
        this.gridP.addKeyListener(new KeyAdapter() { // from class: Inventarios.ConsultarExistencias.8
            public void keyPressed(KeyEvent evt) {
                ConsultarExistencias.this.gridPKeyPressed(evt);
            }
        });
        this.jScrollPane2.setViewportView(this.gridP);
        this.jPanel1.add(this.jScrollPane2, new AbsoluteConstraints(10, 90, 950, 220));
        getContentPane().add(this.jPanel1, new AbsoluteConstraints(10, 10, 980, 320));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gridBKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtCodigoActionPerformed(ActionEvent evt) {
        buscarProductos(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gridPKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtProductoKeyReleased(KeyEvent evt) {
        buscarProductos(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameActivated(InternalFrameEvent evt) {
        Principal principal = this.claseInv.frmPrincipal;
        Menus menus = this.claseInv.frmPrincipal.xMenus;
        principal.mActivarBarraMenu(Menus.barraMnuInventario, 4);
    }
}
