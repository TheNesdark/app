package Triage;

import Acceso.Menus;
import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Triage/Agenda.class */
public class Agenda extends JInternalFrame {
    private ConsultasMySQL consultas = new ConsultasMySQL();
    public static DefaultTableModel modelo;
    public static int filaGrid = 0;
    private String sql;
    private ResultSet rs;
    private Object[] dato;
    private hiloAgenda hAgenda;
    private Thread hilo;
    private claseTriage clasetriage;
    private JTable grid;
    private JScrollPane jScrollPane1;
    private JLabel lblEspecialidad;

    public Agenda(claseTriage Clasetriage) {
        initComponents();
        this.clasetriage = Clasetriage;
        this.lblEspecialidad.setText(Principal.clasetriage.getNbreEspecial());
        crearGrid();
        this.hAgenda = new hiloAgenda();
        this.hilo = new Thread(this.hAgenda);
        this.hilo.start();
        this.grid.addMouseListener(new MouseAdapter() { // from class: Triage.Agenda.1
            public void mouseClicked(MouseEvent e) {
                Agenda.filaGrid = Agenda.this.grid.rowAtPoint(e.getPoint());
                if (e.getClickCount() > 1) {
                    Agenda.this.cargarPanelTriage();
                }
            }
        });
    }

    private void asignarEstado() {
        this.sql = "UPDATE u_triageagenda SET Estado = -1 WHERE Id='" + modelo.getValueAt(filaGrid, 6) + "'";
        this.consultas.ejecutarSQL(this.sql);
        this.consultas.cerrarConexionBd();
        modelo.setValueAt("En Atención", filaGrid, 8);
    }

    private void crearGrid() {
        modelo = new DefaultTableModel() { // from class: Triage.Agenda.2
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        modelo.addColumn("Hora");
        modelo.addColumn("");
        modelo.addColumn("Historia");
        modelo.addColumn("Nombre del Usuarios");
        modelo.addColumn("Edad");
        modelo.addColumn("Causa Consulta");
        modelo.addColumn("");
        modelo.addColumn("Empresa");
        modelo.addColumn("Estado");
        this.grid.setModel(modelo);
        this.grid.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(1).setPreferredWidth(0);
        this.grid.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(3).setPreferredWidth(350);
        this.grid.getColumnModel().getColumn(4).setPreferredWidth(80);
        this.grid.getColumnModel().getColumn(5).setPreferredWidth(350);
        this.grid.getColumnModel().getColumn(6).setPreferredWidth(0);
        this.grid.getColumnModel().getColumn(7).setPreferredWidth(120);
        this.grid.getColumnModel().getColumn(8).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(1).setMinWidth(0);
        this.grid.getColumnModel().getColumn(1).setMaxWidth(0);
        this.grid.getColumnModel().getColumn(2).setMinWidth(100);
        this.grid.getColumnModel().getColumn(2).setMaxWidth(100);
        this.grid.getColumnModel().getColumn(3).setMinWidth(300);
        this.grid.getColumnModel().getColumn(3).setMaxWidth(300);
        this.grid.getColumnModel().getColumn(4).setMinWidth(80);
        this.grid.getColumnModel().getColumn(4).setMaxWidth(80);
        this.grid.getColumnModel().getColumn(5).setMinWidth(300);
        this.grid.getColumnModel().getColumn(5).setMaxWidth(300);
        this.grid.getColumnModel().getColumn(6).setMinWidth(0);
        this.grid.getColumnModel().getColumn(6).setMaxWidth(0);
        this.grid.getColumnModel().getColumn(7).setMinWidth(120);
        this.grid.getColumnModel().getColumn(7).setMaxWidth(120);
        this.grid.getColumnModel().getColumn(8).setMinWidth(100);
        this.grid.getColumnModel().getColumn(8).setMaxWidth(100);
        filaGrid = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cargarGrid() {
        crearGrid();
        this.sql = "SELECT DATE_FORMAT(u_triageagenda.Fecha_Agenda, '%h:%i %p') as Hora, w_persona.Id_persona, w_persona.NoHistoria, w_persona.NUsuario, w_persona.Edad, w_persona.NTipoEdad, u_triageagenda.Observacion, u_triageagenda.Id, f_empresacontxconvenio.Nbre,  u_triageagenda.Estado  FROM u_triageagenda INNER JOIN w_persona  ON (u_triageagenda.Id_Persona = w_persona.Id_persona) LEFT JOIN f_empresacontxconvenio ON (u_triageagenda.Id_EmpresaConv = f_empresacontxconvenio.Id) WHERE (u_triageagenda.Estado < 1)";
        this.rs = this.consultas.traerRs(this.sql);
        while (this.rs.next()) {
            try {
                modelo.addRow(this.dato);
                modelo.setValueAt(this.rs.getString(1), filaGrid, 0);
                modelo.setValueAt(this.rs.getString(2), filaGrid, 1);
                modelo.setValueAt(this.rs.getString(3), filaGrid, 2);
                modelo.setValueAt(this.rs.getString(4), filaGrid, 3);
                modelo.setValueAt(this.rs.getString(5) + " " + this.rs.getString(6), filaGrid, 4);
                modelo.setValueAt(this.rs.getString(7), filaGrid, 5);
                modelo.setValueAt(this.rs.getString(8), filaGrid, 6);
                modelo.setValueAt(this.rs.getString(9), filaGrid, 7);
                if (this.rs.getInt(8) == -1) {
                    modelo.setValueAt("En Atención", filaGrid, 8);
                } else {
                    modelo.setValueAt("Sin Atender", filaGrid, 8);
                }
                filaGrid++;
            } catch (SQLException ex) {
                this.consultas.mostrarErrorSQL(ex);
                return;
            }
        }
        this.rs.close();
        this.consultas.cerrarConexionBd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cargarPanelTriage() {
        asignarEstado();
        Principal.clasetriage.Triage(3, modelo.getValueAt(filaGrid, 2).toString(), modelo.getValueAt(filaGrid, 6).toString());
    }

    /* JADX WARN: Type inference failed for: r3v7, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jScrollPane1 = new JScrollPane();
        this.grid = new JTable();
        this.lblEspecialidad = new JLabel();
        setClosable(true);
        setIconifiable(true);
        setTitle("AGENDA TRIAGE");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("Agenda");
        addInternalFrameListener(new InternalFrameListener() { // from class: Triage.Agenda.3
            public void internalFrameActivated(InternalFrameEvent evt) {
                Agenda.this.formInternalFrameActivated(evt);
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
        this.jScrollPane1.setFont(new Font("Arial", 1, 12));
        this.grid.setFont(new Font("Arial", 1, 12));
        this.grid.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.grid.setRowHeight(25);
        this.grid.setSelectionBackground(new Color(255, 255, 255));
        this.grid.setSelectionForeground(new Color(255, 0, 0));
        this.grid.setSelectionMode(0);
        this.jScrollPane1.setViewportView(this.grid);
        this.lblEspecialidad.setBackground(new Color(0, 0, 153));
        this.lblEspecialidad.setFont(new Font("Arial", 1, 14));
        this.lblEspecialidad.setForeground(new Color(204, 255, 255));
        this.lblEspecialidad.setHorizontalAlignment(0);
        this.lblEspecialidad.setText("jLabel1");
        this.lblEspecialidad.setOpaque(true);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 1149, 32767).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.lblEspecialidad, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.jScrollPane1, GroupLayout.Alignment.LEADING, -1, 1119, 32767)).addContainerGap(20, 32767))));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 549, 32767).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(4, 4, 4).addComponent(this.lblEspecialidad, -2, 30, -2).addGap(10, 10, 10).addComponent(this.jScrollPane1, -2, 470, -2).addContainerGap(35, 32767))));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameActivated(InternalFrameEvent evt) {
        this.clasetriage.frmPrincipal.mQuitarBarraMenu();
        Principal principal = this.clasetriage.frmPrincipal;
        Menus menus = this.clasetriage.frmPrincipal.xMenus;
        principal.mActivarBarraMenu(Menus.barraMnuTriage, this.clasetriage.getModulo());
    }

    /* JADX INFO: loaded from: GenomaP.jar:Triage/Agenda$hiloAgenda.class */
    class hiloAgenda extends Thread {
        public hiloAgenda() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (true) {
                Agenda.this.cargarGrid();
                try {
                    sleep(8000L);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Agenda.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                }
            }
        }
    }
}
