package Citas;

import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Citas/Remitidos.class */
public class Remitidos extends JDialog {
    private DefaultTableModel modelo;
    private String historia;
    private String sql;
    private ResultSet rs;
    private Object[] dato;
    private int llamador;
    private CitasGral frm;
    private CitaNP frmNP;
    private JButton btnAceptar;
    private JButton btnCancelar;
    private JTable grid;
    private JScrollPane jScrollPane1;
    private Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
    private Metodos metodos = new Metodos();
    private ConsultasMySQL consultas = new ConsultasMySQL();
    private int filaGrid = -1;

    public Remitidos(String historia, Object frmC, int op) {
        this.llamador = 1;
        initComponents();
        this.historia = historia;
        Dimension ventana = getSize();
        setLocation((this.pantalla.width - ventana.width) / 2, (this.pantalla.height - ventana.height) / 2);
        if (op == 1) {
            this.frm = (CitasGral) frmC;
            this.llamador = 1;
        } else {
            this.frmNP = (CitaNP) frmC;
            this.llamador = 2;
        }
        crearGrid();
        cargarGrid();
        this.grid.addMouseListener(new MouseAdapter() { // from class: Citas.Remitidos.1
            public void mouseClicked(MouseEvent e) {
                Remitidos.this.filaGrid = Remitidos.this.grid.rowAtPoint(e.getPoint());
            }
        });
    }

    /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jScrollPane1 = new JScrollPane();
        this.grid = new JTable();
        this.btnCancelar = new JButton();
        this.btnAceptar = new JButton();
        setTitle("Interconsultas");
        setName("Remitidos");
        this.grid.setFont(new Font("Arial", 1, 12));
        this.grid.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.grid.setSelectionBackground(new Color(255, 255, 255));
        this.grid.setSelectionForeground(new Color(255, 0, 0));
        this.grid.setSelectionMode(0);
        this.jScrollPane1.setViewportView(this.grid);
        this.btnCancelar.setFont(new Font("Arial", 1, 12));
        this.btnCancelar.setForeground(new Color(0, 0, 153));
        this.btnCancelar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.btnCancelar.setText("Cancelar");
        this.btnCancelar.addActionListener(new ActionListener() { // from class: Citas.Remitidos.2
            public void actionPerformed(ActionEvent evt) {
                Remitidos.this.btnCancelarActionPerformed(evt);
            }
        });
        this.btnAceptar.setFont(new Font("Arial", 1, 12));
        this.btnAceptar.setForeground(new Color(0, 0, 153));
        this.btnAceptar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.btnAceptar.setText("Aceptar");
        this.btnAceptar.addActionListener(new ActionListener() { // from class: Citas.Remitidos.3
            public void actionPerformed(ActionEvent evt) {
                Remitidos.this.btnAceptarActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.btnCancelar, -2, 301, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.btnAceptar, -1, 300, 32767)).addComponent(this.jScrollPane1, -1, 607, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane1, -2, 275, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.btnAceptar, -1, -1, 32767).addComponent(this.btnCancelar, -1, -1, 32767)).addContainerGap(19, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnCancelarActionPerformed(ActionEvent evt) {
        cancelar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnAceptarActionPerformed(ActionEvent evt) {
        entregarDato();
    }

    private void cargarGrid() {
        this.sql = "SELECT h_atencion.Fecha_Atencion, g_especialidad.Nbre, h_remisiones.Id FROM baseserver.h_remisiones INNER JOIN baseserver.h_atencion ON (h_remisiones.Id_Atencion = h_atencion.Id) INNER JOIN baseserver.g_especialidad ON (h_remisiones.I_Especialidad = g_especialidad.Id) INNER JOIN baseserver.ingreso ON (h_atencion.Id_Ingreso = ingreso.Id) INNER JOIN baseserver.g_usuario ON (ingreso.Id_Usuario = g_usuario.Id_persona) WHERE (g_usuario.NoHistoria ='" + this.historia + "') ORDER BY h_atencion.Fecha_Atencion ASC";
        this.rs = this.consultas.traerRs(this.sql);
        try {
            this.rs.next();
            if (this.rs.getRow() > 0) {
                this.rs.beforeFirst();
                while (this.rs.next()) {
                    this.filaGrid++;
                    this.modelo.addRow(this.dato);
                    this.modelo.setValueAt(this.rs.getString(1), this.filaGrid, 0);
                    this.modelo.setValueAt(this.rs.getString(2), this.filaGrid, 1);
                    this.modelo.setValueAt(this.rs.getString(3), this.filaGrid, 2);
                }
            }
            this.rs.close();
            this.consultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(Remitidos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void crearGrid() {
        this.modelo = new DefaultTableModel() { // from class: Citas.Remitidos.4
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.modelo.addColumn("Fecha Atención");
        this.modelo.addColumn("Especialidad");
        this.modelo.addColumn("No. Remisión");
        this.grid.setModel(this.modelo);
        this.grid.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(1).setPreferredWidth(200);
        this.grid.getColumnModel().getColumn(2).setPreferredWidth(100);
    }

    private void entregarDato() {
        if (this.modelo.getRowCount() > 0) {
            this.frm.remitida = Integer.parseInt(this.modelo.getValueAt(this.filaGrid, 2).toString());
            dispose();
            return;
        }
        cancelar();
    }

    private void cancelar() {
        if (this.llamador == 1) {
            this.frm.remitida = 0;
            this.frm.btnNoRemitido.setSelected(true);
            this.frm.btnNoRemitido.requestFocus();
        } else {
            this.frmNP.remitida = 0;
            this.frmNP.btnNoRemitido.setSelected(true);
            this.frmNP.btnNoRemitido.requestFocus();
        }
        dispose();
    }
}
