package Laboratorio;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
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
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Laboratorio/JDBuscarRemisiones.class */
public class JDBuscarRemisiones extends JDialog {
    private ConsultasMySQL consultas;
    private Metodos metodos;
    private String sql;
    private String IdPersona;
    private String pantalla;
    private ResultSet rs;
    private Object[] dato;
    private DefaultTableModel modelo;
    private int fila;
    private ResultadoManual frmRM;
    private JIFRemisionLab xjfrem;
    private JLabel JLB_Cantidad;
    private JTextField JTF_NRemision;
    private JTable grid;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;

    public JDBuscarRemisiones(Frame parent, boolean modal, JIFRemisionLab xjfrem) {
        super(parent, modal);
        this.consultas = new ConsultasMySQL();
        this.metodos = new Metodos();
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        this.xjfrem = xjfrem;
        cargarGrid();
    }

    private void cargarGrid() {
        crearGrid();
        this.sql = "SELECT l_remision.Id, date_format(l_remision.FechaRem, '%d-%m-%Y')as Fecha, cc_terceros.RazonSocialCompleta, l_remision.Estado  FROM l_remision INNER JOIN cc_terceros  ON (l_remision.Id_Empresa = cc_terceros.Id)  WHERE l_remision.Id like '" + this.JTF_NRemision.getText() + "%'ORDER BY l_remision.FechaRem DESC, l_remision.Fecha DESC";
        this.rs = this.consultas.traerRs(this.sql);
        int cantidad = 0;
        while (this.rs.next()) {
            try {
                this.modelo.addRow(this.dato);
                this.modelo.setValueAt(Long.valueOf(this.rs.getLong(1)), this.fila, 0);
                this.modelo.setValueAt(this.rs.getString(2), this.fila, 1);
                this.modelo.setValueAt(this.rs.getString(3), this.fila, 2);
                this.modelo.setValueAt(Boolean.valueOf(this.rs.getBoolean(4)), this.fila, 3);
                this.fila++;
                cantidad++;
            } catch (SQLException ex) {
                this.consultas.mostrarErrorSQL(ex);
                return;
            }
        }
        this.rs.close();
        this.consultas.cerrarConexionBd();
        this.JLB_Cantidad.setText("" + cantidad);
    }

    private void cargarResultado() {
        if (this.pantalla.equals("ResultadoManual")) {
            this.metodos.marcarEstado(2);
            Principal.txtNo.setText(this.modelo.getValueAt(this.fila, 2).toString());
            Principal.txtFecha.setText(this.modelo.getValueAt(this.fila, 3).toString());
            this.frmRM.txtNoOrden.setText(this.modelo.getValueAt(this.fila, 0).toString());
            this.frmRM.txtRecepcion.setText(this.modelo.getValueAt(this.fila, 1).toString());
            this.frmRM.buscarRecep();
        }
        dispose();
    }

    private void crearGrid() {
        this.modelo = new DefaultTableModel((Object[][]) null, new String[]{"No.", "Fecha", "Empresa", "Estado"}) { // from class: Laboratorio.JDBuscarRemisiones.1
            Class[] types = {Long.class, String.class, String.class, Boolean.class};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.grid.setModel(this.modelo);
        this.grid.getColumnModel().getColumn(0).setPreferredWidth(30);
        this.grid.getColumnModel().getColumn(1).setPreferredWidth(50);
        this.grid.getColumnModel().getColumn(2).setPreferredWidth(300);
        this.grid.getColumnModel().getColumn(3).setPreferredWidth(30);
        this.fila = 0;
    }

    /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jScrollPane1 = new JScrollPane();
        this.grid = new JTable();
        this.jPanel1 = new JPanel();
        this.JTF_NRemision = new JTextField();
        this.JLB_Cantidad = new JLabel();
        setDefaultCloseOperation(2);
        setTitle("REMISIONES");
        setName("BuscarResultado");
        this.jScrollPane1.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.grid.setFont(new Font("Arial", 1, 12));
        this.grid.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.grid.setColumnSelectionAllowed(true);
        this.grid.setRowHeight(25);
        this.grid.setSelectionBackground(new Color(255, 255, 255));
        this.grid.setSelectionForeground(new Color(255, 0, 0));
        this.grid.setSelectionMode(0);
        this.grid.addMouseListener(new MouseAdapter() { // from class: Laboratorio.JDBuscarRemisiones.2
            public void mouseClicked(MouseEvent evt) {
                JDBuscarRemisiones.this.gridMouseClicked(evt);
            }
        });
        this.jScrollPane1.setViewportView(this.grid);
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "FILTRO", 0, 0, new Font("Arial", 1, 14), Color.red));
        this.JTF_NRemision.setFont(new Font("Arial", 1, 14));
        this.JTF_NRemision.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Remisión", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTF_NRemision.addKeyListener(new KeyAdapter() { // from class: Laboratorio.JDBuscarRemisiones.3
            public void keyPressed(KeyEvent evt) {
                JDBuscarRemisiones.this.JTF_NRemisionKeyPressed(evt);
            }
        });
        this.JLB_Cantidad.setFont(new Font("Arial", 1, 12));
        this.JLB_Cantidad.setHorizontalAlignment(0);
        this.JLB_Cantidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Cantidad", 2, 0, new Font("Arial", 1, 12), Color.red));
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.JTF_NRemision, -2, 115, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JLB_Cantidad, -2, 133, -2).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTF_NRemision, -1, 50, 32767).addComponent(this.JLB_Cantidad, -1, 50, 32767)).addContainerGap(14, 32767)));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767).addComponent(this.jScrollPane1, GroupLayout.Alignment.TRAILING, -1, 817, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane1, -1, 305, 32767).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gridMouseClicked(MouseEvent evt) {
        if (this.grid.getSelectedRow() != -1) {
            this.xjfrem.mCargarDatosTabla(this.modelo.getValueAt(this.grid.getSelectedRow(), 0).toString(), "");
            dispose();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTF_NRemisionKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10 || evt.getKeyCode() == 9) {
            cargarGrid();
        }
    }
}
