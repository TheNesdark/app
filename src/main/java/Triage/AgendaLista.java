package Triage;

import Acceso.Menus;
import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
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

/* JADX INFO: loaded from: GenomaP.jar:Triage/AgendaLista.class */
public class AgendaLista extends JInternalFrame {
    public DefaultTableModel modelo;
    private String sql;
    private ResultSet rs;
    private Object[] dato;
    private hiloA hAgenda;
    private Thread hilo;
    private claseTriage clasetriage;
    private JTable grid;
    private JScrollPane jScrollPane1;
    private JLabel lblEspecialidad;
    private Metodos metodos = new Metodos();
    private ConsultasMySQL consultas = new ConsultasMySQL();
    public int filaGrid = 0;

    public AgendaLista(claseTriage Clasetriage) {
        initComponents();
        this.clasetriage = Clasetriage;
        this.lblEspecialidad.setText(Principal.clasetriage.getNbreEspecial());
        crearGrid();
        this.hAgenda = new hiloA();
        this.hilo = new Thread(this.hAgenda);
        this.hilo.start();
        this.grid.addMouseListener(new MouseAdapter() { // from class: Triage.AgendaLista.1
            public void mouseClicked(MouseEvent e) {
                AgendaLista.this.filaGrid = AgendaLista.this.grid.rowAtPoint(e.getPoint());
                if (e.getClickCount() > 1) {
                    AgendaLista.this.cargarPanelTriage();
                }
            }
        });
    }

    private void atender() {
        this.sql = "UPDATE u_triage SET Atendido = 0 WHERE Id='" + this.modelo.getValueAt(this.filaGrid, 7) + "'";
        this.consultas.ejecutarSQL(this.sql);
        this.consultas.cerrarConexionBd();
        this.modelo.setValueAt("En Atención", this.filaGrid, 6);
    }

    private void crearGrid() {
        this.modelo = new DefaultTableModel() { // from class: Triage.AgendaLista.2
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.modelo.addColumn("Clasificacion");
        this.modelo.addColumn("Hora");
        this.modelo.addColumn("");
        this.modelo.addColumn("Historia");
        this.modelo.addColumn("Nombre del Usuarios");
        this.modelo.addColumn("Edad");
        this.modelo.addColumn("Causa Consulta");
        this.modelo.addColumn("");
        this.modelo.addColumn("Estado");
        this.grid.setModel(this.modelo);
        this.grid.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(2).setPreferredWidth(0);
        this.grid.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(4).setPreferredWidth(350);
        this.grid.getColumnModel().getColumn(5).setPreferredWidth(80);
        this.grid.getColumnModel().getColumn(6).setPreferredWidth(350);
        this.grid.getColumnModel().getColumn(7).setPreferredWidth(0);
        this.grid.getColumnModel().getColumn(8).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(1).setMinWidth(100);
        this.grid.getColumnModel().getColumn(1).setMaxWidth(100);
        this.grid.getColumnModel().getColumn(2).setMinWidth(0);
        this.grid.getColumnModel().getColumn(2).setMaxWidth(0);
        this.grid.getColumnModel().getColumn(3).setMinWidth(100);
        this.grid.getColumnModel().getColumn(3).setMaxWidth(100);
        this.grid.getColumnModel().getColumn(4).setMinWidth(300);
        this.grid.getColumnModel().getColumn(4).setMaxWidth(300);
        this.grid.getColumnModel().getColumn(5).setMinWidth(80);
        this.grid.getColumnModel().getColumn(5).setMaxWidth(80);
        this.grid.getColumnModel().getColumn(6).setMinWidth(300);
        this.grid.getColumnModel().getColumn(6).setMaxWidth(300);
        this.grid.getColumnModel().getColumn(7).setMinWidth(0);
        this.grid.getColumnModel().getColumn(7).setMaxWidth(0);
        this.grid.getColumnModel().getColumn(8).setMinWidth(100);
        this.grid.getColumnModel().getColumn(8).setMaxWidth(100);
        this.filaGrid = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cargarGrid() {
        crearGrid();
        this.sql = "SELECT u_triage.Clasificacion, u_triage.Hora, persona.Id_persona, persona.NoHistoria, persona.NUsuario, persona.Edad, u_triage.MotivoConsulta, u_triage.Id, u_triage.Atendido FROM u_triage INNER JOIN persona ON (u_triage.Id_Usuario = persona.Id_persona) WHERE (u_triage.Atendido <>0 AND u_triage.Estado =0 AND u_triage.Clasificacion >1 AND u_triage.Clasificacion <4) ORDER BY u_triage.Clasificacion ASC, u_triage.Hora ASC";
        this.rs = this.consultas.traerRs(this.sql);
        while (this.rs.next()) {
            try {
                this.modelo.addRow(this.dato);
                this.modelo.setValueAt(this.rs.getString(1), this.filaGrid, 0);
                this.modelo.setValueAt(this.rs.getString(2), this.filaGrid, 1);
                this.modelo.setValueAt(this.rs.getString(3), this.filaGrid, 2);
                this.modelo.setValueAt(this.rs.getString(4), this.filaGrid, 3);
                this.modelo.setValueAt(this.rs.getString(5), this.filaGrid, 4);
                this.modelo.setValueAt(this.rs.getString(6), this.filaGrid, 5);
                this.modelo.setValueAt(this.rs.getString(7), this.filaGrid, 6);
                this.modelo.setValueAt(this.rs.getString(8), this.filaGrid, 7);
                if (this.rs.getInt(9) == -1) {
                    this.modelo.setValueAt("En Atención", this.filaGrid, 8);
                } else if (this.rs.getInt(9) == 1) {
                    this.modelo.setValueAt("Sin Atender", this.filaGrid, 8);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void cargarPanelTriage() {
        atender();
        cargarGrid();
        this.metodos.mostrarMensaje("Se cambiara el estado del Usuario a Atendido");
    }

    /* JADX WARN: Type inference failed for: r3v7, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jScrollPane1 = new JScrollPane();
        this.grid = new JTable();
        this.lblEspecialidad = new JLabel();
        setClosable(true);
        setIconifiable(true);
        setTitle("TRIAGE  2 Y 3 REALIZADOS  PENDIENTES POR CONSULTA DE URGENCIAS");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("AgendaLista");
        addInternalFrameListener(new InternalFrameListener() { // from class: Triage.AgendaLista.3
            public void internalFrameActivated(InternalFrameEvent evt) {
                AgendaLista.this.formInternalFrameActivated(evt);
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

    /* JADX INFO: loaded from: GenomaP.jar:Triage/AgendaLista$hiloA.class */
    class hiloA extends Thread {
        public hiloA() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (true) {
                AgendaLista.this.cargarGrid();
                try {
                    sleep(8000L);
                } catch (InterruptedException ex) {
                    Logger.getLogger(AgendaLista.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                }
            }
        }
    }
}
