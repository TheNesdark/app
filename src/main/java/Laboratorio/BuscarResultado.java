package Laboratorio;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Laboratorio/BuscarResultado.class */
public class BuscarResultado extends JDialog {
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
    private JTable grid;
    private JScrollPane jScrollPane1;

    public BuscarResultado(Frame parent, boolean modal, String idpersona, String nombre, ResultadoManual frm) {
        super(parent, modal);
        this.consultas = new ConsultasMySQL();
        this.metodos = new Metodos();
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        this.pantalla = nombre;
        setLocationRelativeTo(null);
        this.frmRM = frm;
        this.IdPersona = idpersona;
        crearGrid();
        cargarGrid();
        this.grid.addMouseListener(new MouseAdapter() { // from class: Laboratorio.BuscarResultado.1
            public void mouseClicked(MouseEvent e) {
                BuscarResultado.this.fila = BuscarResultado.this.grid.rowAtPoint(e.getPoint());
                if (e.getClickCount() > 1) {
                    BuscarResultado.this.cargarResultado();
                }
            }
        });
    }

    private void cargarGrid() {
        this.sql = "SELECT l_recepcion.Id_OrdenFacturac, l_recepcion.Id, l_resultados.Id, l_resultados.FechaResult, l_recepcion.`Estado`  FROM  l_resultados INNER JOIN l_recepcion  ON (l_resultados.Id_Recepcion = l_recepcion.Id)  WHERE (l_recepcion.Id_Paciente ='" + this.IdPersona + "') GROUP BY l_recepcion.Id ORDER BY l_resultados.FechaResult DESC";
        this.rs = this.consultas.traerRs(this.sql);
        while (this.rs.next()) {
            try {
                this.modelo.addRow(this.dato);
                this.modelo.setValueAt(this.rs.getString(1), this.fila, 0);
                this.modelo.setValueAt(this.rs.getString(2), this.fila, 1);
                this.modelo.setValueAt(this.rs.getString(3), this.fila, 2);
                this.modelo.setValueAt(this.metodos.formatoDMA.format((Date) this.rs.getDate(4)), this.fila, 3);
                this.modelo.setValueAt(Boolean.valueOf(this.rs.getBoolean(5)), this.fila, 4);
                this.fila++;
            } catch (SQLException ex) {
                this.consultas.mostrarErrorSQL(ex);
                return;
            }
        }
        this.rs.close();
        this.consultas.cerrarConexionBd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cargarResultado() {
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
        this.modelo = new DefaultTableModel((Object[][]) null, new String[]{"No. Orden", "No. Recepción", "No. Resultado", "Fecha", "Estado"}) { // from class: Laboratorio.BuscarResultado.2
            Class[] types = {String.class, String.class, String.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.grid.setModel(this.modelo);
        this.grid.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(4).setPreferredWidth(10);
        this.fila = 0;
    }

    /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jScrollPane1 = new JScrollPane();
        this.grid = new JTable();
        setDefaultCloseOperation(2);
        setTitle("BUSCAR ORDENES");
        setName("BuscarResultado");
        this.jScrollPane1.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.grid.setFont(new Font("Arial", 1, 12));
        this.grid.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.grid.setColumnSelectionAllowed(true);
        this.grid.setRowHeight(25);
        this.grid.setSelectionBackground(new Color(255, 255, 255));
        this.grid.setSelectionForeground(new Color(255, 0, 0));
        this.grid.setSelectionMode(0);
        this.grid.addMouseListener(new MouseAdapter() { // from class: Laboratorio.BuscarResultado.3
            public void mouseClicked(MouseEvent evt) {
                BuscarResultado.this.gridMouseClicked(evt);
            }
        });
        this.jScrollPane1.setViewportView(this.grid);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 829, 32767).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane1, -1, 809, 32767).addContainerGap())));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 341, 32767).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane1, -2, 319, -2).addContainerGap(-1, 32767))));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gridMouseClicked(MouseEvent evt) {
    }
}
