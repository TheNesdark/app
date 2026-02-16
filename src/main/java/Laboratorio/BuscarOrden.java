package Laboratorio;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.GroupLayout;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Laboratorio/BuscarOrden.class */
public class BuscarOrden extends JDialog {
    private ConsultasMySQL consultas;
    private RecepcionAuto frmRecep;
    private String sql;
    private String IdPersona;
    private String pantalla;
    private ResultSet rs;
    private Object[] dato;
    private DefaultTableModel modelo;
    private RecepcionManual frmManual;
    private JTable grid;
    private JLabel jLabel2;
    private JScrollPane jScrollPane1;

    public BuscarOrden(Frame parent, boolean modal, String idpersona, Object frm, String nombre) {
        super(parent, modal);
        this.consultas = new ConsultasMySQL();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        initComponents();
        this.pantalla = nombre;
        casting(frm);
        setLocationRelativeTo(null);
        this.IdPersona = idpersona;
        crearGrid();
        cargarGrid();
    }

    private void casting(Object frm) {
        if (!this.pantalla.equals("Recepcion")) {
            if (this.pantalla.equals("TomaManual") || this.pantalla.equals("RecepcionM")) {
                this.frmManual = (RecepcionManual) frm;
                return;
            }
            return;
        }
        this.frmRecep = (RecepcionAuto) frm;
    }

    private void cargarGrid() {
        if (this.pantalla.equals("Recepcion") || this.pantalla.equals("TomaManual")) {
            this.sql = "SELECT f_ordenes.Id, f_ordenes.FechaOrden, profesional1.Especialidad , profesional1.NProfesional, ingreso.Id_Usuario FROM f_ordenes INNER JOIN profesional1 ON (f_ordenes.Id_Profesional = profesional1.Id_Persona) AND (f_ordenes.Id_Especialidad = profesional1.IdEspecialidad) INNER JOIN ingreso ON (f_ordenes.Id_Ingreso = ingreso.Id) WHERE (ingreso.Id_Usuario ='" + this.IdPersona + "') ORDER BY f_ordenes.FechaOrden DESC";
        } else if (this.pantalla.equals("RecepcionM")) {
            this.sql = "SELECT l_recepcion.Id, DATE_FORMAT(l_recepcion.FechaRecep, '%d-%m-%Y') AS Fecha, profesional1.Especialidad, profesional1.NProfesional FROM l_detallerecepcion INNER JOIN l_recepcion  ON (l_detallerecepcion.Id_Recepcion = l_recepcion.Id) INNER JOIN g_procedimiento  ON (l_detallerecepcion.Id_Procedim = g_procedimiento.Id) INNER JOIN profesional1  ON (profesional1.Id_Persona = l_recepcion.Id_Profesional) AND (profesional1.IdEspecialidad = l_recepcion.Id_Especialidad) WHERE (l_recepcion.Estado =0  AND l_recepcion.Id_Paciente ='" + this.IdPersona + "') GROUP BY l_recepcion.Id ORDER BY l_recepcion.Id DESC ";
        }
        this.rs = this.consultas.traerRs(this.sql);
        int fila = 0;
        while (this.rs.next()) {
            try {
                this.modelo.addRow(this.dato);
                this.modelo.setValueAt(this.rs.getString(1), fila, 0);
                this.modelo.setValueAt(this.rs.getString(2), fila, 1);
                this.modelo.setValueAt(this.rs.getString(3), fila, 2);
                this.modelo.setValueAt(this.rs.getString(4), fila, 3);
                fila++;
            } catch (SQLException ex) {
                this.consultas.mostrarErrorSQL(ex);
                return;
            }
        }
        this.rs.close();
        this.consultas.cerrarConexionBd();
    }

    private void cargarOrden() {
        if (this.pantalla.equals("Recepcion")) {
            this.frmRecep.txtNoOrden.setText(this.modelo.getValueAt(this.grid.getSelectedRow(), 0).toString());
            this.frmRecep.buscarOrden();
        } else if (this.pantalla.equals("TomaManual")) {
            this.frmManual.cargarOrden();
        } else if (this.pantalla.equals("RecepcionM")) {
            Principal.txtNo.setText(this.modelo.getValueAt(this.grid.getSelectedRow(), 0).toString());
            this.frmManual.mCargarOrdenRecep();
        }
        dispose();
    }

    private void crearGrid() {
        this.modelo = new DefaultTableModel((Object[][]) null, new String[]{"Orden", "Fecha", "Especialidad", "Profesional"}) { // from class: Laboratorio.BuscarOrden.1
            Class[] types = {String.class, String.class, String.class, String.class};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.grid.setModel(this.modelo);
        this.grid.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(2).setPreferredWidth(150);
        this.grid.getColumnModel().getColumn(3).setPreferredWidth(150);
    }

    /* JADX WARN: Type inference failed for: r3v4, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jLabel2 = new JLabel();
        this.jScrollPane1 = new JScrollPane();
        this.grid = new JTable();
        setDefaultCloseOperation(2);
        setTitle("Buscar Ordenes de Laboratorio");
        this.jLabel2.setBackground((Color) null);
        this.jLabel2.setFont(new Font("Arial", 1, 14));
        this.jLabel2.setForeground(new Color(0, 102, 0));
        this.jLabel2.setHorizontalAlignment(0);
        this.jLabel2.setText("BUSCAR ORDEN");
        this.jLabel2.setOpaque(true);
        this.grid.setFont(new Font("Arial", 1, 12));
        this.grid.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.grid.setColumnSelectionAllowed(true);
        this.grid.setRowHeight(25);
        this.grid.setSelectionBackground(new Color(255, 255, 255));
        this.grid.setSelectionForeground(new Color(255, 0, 0));
        this.grid.setSelectionMode(0);
        this.grid.addMouseListener(new MouseAdapter() { // from class: Laboratorio.BuscarOrden.2
            public void mouseClicked(MouseEvent evt) {
                BuscarOrden.this.gridMouseClicked(evt);
            }
        });
        this.jScrollPane1.setViewportView(this.grid);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 860, 32767).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel2, -1, 840, 32767).addComponent(this.jScrollPane1, -1, 840, 32767)).addContainerGap())));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 355, 32767).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jLabel2, -2, 31, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane1, -2, 282, -2).addContainerGap(25, 32767))));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gridMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() > 1) {
            cargarOrden();
        }
    }
}
