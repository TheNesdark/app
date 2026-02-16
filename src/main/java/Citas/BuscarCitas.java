package Citas;

import Historia.JIFSeguimientoOrdenesLab;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Citas/BuscarCitas.class */
public class BuscarCitas extends JDialog {
    private Metodos metodos;
    private ConsultasMySQL consultas;
    private String sql;
    private String IdPersona;
    private String frmLlamador;
    private ResultSet rs;
    private Object[] dato;
    private DefaultTableModel modelo;
    private DefaultTableModel modeloNP;
    private int fila;
    private int filaNP;
    private CitasGral frmCita;
    private JIFSeguimientoOrdenesLab xjifseg;
    private JButton btnNoProgramada;
    private JButton btnProgramada;
    private JButton btnSalir;
    private JTable grid;
    private JTable gridNP;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JPanel panelFondo;

    public BuscarCitas(Frame parent, boolean modal, String idpersona, String nbre, Object frm) {
        super(parent, modal);
        this.metodos = new Metodos();
        this.consultas = new ConsultasMySQL();
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        setLocationRelativeTo(null);
        this.IdPersona = idpersona;
        this.frmLlamador = nbre;
        iniciar(frm);
        this.grid.addMouseListener(new MouseAdapter() { // from class: Citas.BuscarCitas.1
            public void mouseClicked(MouseEvent e) {
                BuscarCitas.this.fila = BuscarCitas.this.grid.rowAtPoint(e.getPoint());
            }
        });
        this.gridNP.addMouseListener(new MouseAdapter() { // from class: Citas.BuscarCitas.2
            public void mouseClicked(MouseEvent e) {
                BuscarCitas.this.filaNP = BuscarCitas.this.gridNP.rowAtPoint(e.getPoint());
            }
        });
    }

    private void iniciar(Object frm) {
        if (this.frmLlamador.equals("Citas")) {
            this.frmCita = (CitasGral) frm;
            this.btnProgramada.setEnabled(true);
            this.btnNoProgramada.setEnabled(true);
        } else if (this.frmLlamador.equals("jifseguimientolab1")) {
            this.xjifseg = (JIFSeguimientoOrdenesLab) frm;
            this.btnProgramada.setEnabled(true);
            this.btnNoProgramada.setEnabled(true);
        }
        crearGrid();
        buscarProgramadas();
        buscarNoProgramadas();
    }

    private void crearGrid() {
        this.modelo = new DefaultTableModel((Object[][]) null, new String[]{"Clase Cita", "Profesional", "Especialidad", "Fecha", "Hora Inicio", "Hora Final", "Asistida", "Estado", "IdProfesional", "IdEspecial", "IdCita", "Sede", "Motivo Desistida"}) { // from class: Citas.BuscarCitas.3
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, Boolean.class, String.class, String.class, String.class, String.class, String.class, String.class};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        JTable jTable = this.grid;
        JTable jTable2 = this.grid;
        jTable.setAutoResizeMode(0);
        this.grid.doLayout();
        this.grid.setModel(this.modelo);
        this.grid.getColumnModel().getColumn(0).setPreferredWidth(300);
        this.grid.getColumnModel().getColumn(1).setPreferredWidth(300);
        this.grid.getColumnModel().getColumn(2).setPreferredWidth(300);
        this.grid.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(6).setPreferredWidth(80);
        this.grid.getColumnModel().getColumn(7).setPreferredWidth(80);
        this.grid.getColumnModel().getColumn(8).setPreferredWidth(0);
        this.grid.getColumnModel().getColumn(8).setMinWidth(0);
        this.grid.getColumnModel().getColumn(8).setMaxWidth(0);
        this.grid.getColumnModel().getColumn(9).setPreferredWidth(0);
        this.grid.getColumnModel().getColumn(9).setMinWidth(0);
        this.grid.getColumnModel().getColumn(9).setMaxWidth(0);
        this.grid.getColumnModel().getColumn(10).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(11).setPreferredWidth(200);
        this.grid.getColumnModel().getColumn(12).setPreferredWidth(200);
        this.modeloNP = new DefaultTableModel((Object[][]) null, new String[]{"", "Profesional", "Especialidad", "Fecha", "Hora", "Asistida", "Estado", "IdProfesiona", "IdEspecialidad", "IdCita", "Sede", "Motivo Desistida"}) { // from class: Citas.BuscarCitas.4
            Class[] types = {String.class, String.class, String.class, String.class, String.class, Boolean.class, String.class, String.class, String.class, String.class, String.class, String.class};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        JTable jTable3 = this.gridNP;
        JTable jTable4 = this.gridNP;
        jTable3.setAutoResizeMode(0);
        this.gridNP.doLayout();
        this.gridNP.setModel(this.modeloNP);
        this.gridNP.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.gridNP.getColumnModel().getColumn(0).setMinWidth(0);
        this.gridNP.getColumnModel().getColumn(0).setMaxWidth(0);
        this.gridNP.getColumnModel().getColumn(1).setPreferredWidth(300);
        this.gridNP.getColumnModel().getColumn(2).setPreferredWidth(300);
        this.gridNP.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.gridNP.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.gridNP.getColumnModel().getColumn(5).setPreferredWidth(80);
        this.gridNP.getColumnModel().getColumn(6).setPreferredWidth(80);
        this.gridNP.getColumnModel().getColumn(7).setPreferredWidth(0);
        this.gridNP.getColumnModel().getColumn(7).setMinWidth(0);
        this.gridNP.getColumnModel().getColumn(7).setMaxWidth(0);
        this.gridNP.getColumnModel().getColumn(8).setPreferredWidth(0);
        this.gridNP.getColumnModel().getColumn(8).setMinWidth(0);
        this.gridNP.getColumnModel().getColumn(8).setMaxWidth(0);
        this.gridNP.getColumnModel().getColumn(9).setPreferredWidth(100);
        this.gridNP.getColumnModel().getColumn(10).setPreferredWidth(200);
        this.gridNP.getColumnModel().getColumn(11).setPreferredWidth(200);
        this.fila = 0;
        this.filaNP = 0;
    }

    public void buscarNoProgramadas() {
        try {
            this.sql = "SELECT w_profesional.Id_Persona, w_profesional.NProfesional AS Profesional, g_especialidad.Nbre AS Especialidad, \nc_citasnp.Fecha_Cita, c_citasnp.HoraInicial, c_citasnp.Asistida, c_citasnp.Id_MotivoDesistida, \nw_profesional.Id_Persona, w_profesional.IdEspecialidad, c_citasnp.Id, g_sedes.`Nbre` AS Sede, IFNULL(c_desistidas.`Detalle`,'') AS Detalle FROM \nc_clasecita INNER JOIN g_especialidad  ON (c_clasecita.Id_Especialidad = g_especialidad.Id) \nINNER JOIN c_citasnp ON (c_citasnp.Id_ClaseCita = c_clasecita.Id) \nINNER JOIN w_profesional  ON (`w_profesional`.`Id_Persona` = `c_citasnp`.`Id_Profesional`) AND (`w_profesional`.`IdEspecialidad` = `c_citasnp`.`Id_Especialidad`)\nINNER JOIN `g_sedes` ON (`c_citasnp`.`Id_Sede`= `g_sedes`.`Id`)\nLEFT JOIN  `c_desistidas` ON (`c_clasecita`.`Id`=`c_desistidas`.`Id`) AND (`tipo`=2)\nWHERE (c_citasnp.Id_Usuario ='" + this.IdPersona + "') \nORDER BY c_citasnp.Fecha_Cita ASC, c_citasnp.HoraInicial ASC";
            System.out.println(this.sql);
            this.rs = this.consultas.traerRs(this.sql);
            this.filaNP = 0;
            while (this.rs.next()) {
                this.modeloNP.addRow(this.dato);
                this.modeloNP.setValueAt(this.rs.getString(1), this.filaNP, 0);
                this.modeloNP.setValueAt(this.rs.getString(2), this.filaNP, 1);
                this.modeloNP.setValueAt(this.rs.getString(3), this.filaNP, 2);
                this.modeloNP.setValueAt(this.rs.getString(4), this.filaNP, 3);
                this.modeloNP.setValueAt(this.metodos.formatoHora12(this.rs.getString(5)), this.filaNP, 4);
                this.modeloNP.setValueAt(Boolean.valueOf(this.rs.getBoolean(5)), this.filaNP, 5);
                if (this.rs.getInt(7) == 0) {
                    this.modeloNP.setValueAt("Activa", this.filaNP, 6);
                } else {
                    this.modeloNP.setValueAt("DESISTIDA", this.filaNP, 6);
                }
                this.modeloNP.setValueAt(this.rs.getString(8), this.filaNP, 7);
                this.modeloNP.setValueAt(this.rs.getString(9), this.filaNP, 8);
                this.modeloNP.setValueAt(this.rs.getString(10), this.filaNP, 9);
                this.modeloNP.setValueAt(this.rs.getString("Sede"), this.filaNP, 10);
                this.modeloNP.setValueAt(this.rs.getString("Detalle"), this.filaNP, 11);
                this.filaNP++;
            }
            this.rs.close();
            this.consultas.cerrarConexionBd();
        } catch (SQLException ex) {
            this.consultas.mostrarErrorE(ex);
        }
    }

    public void buscarProgramadas() {
        try {
            this.sql = "SELECT c_clasecita.Nbre AS ClaseCita, w_profesional.NProfesional AS Profesional, g_especialidad.Nbre AS Especialidad,  \nc_citas.Fecha_Cita, c_citas.HoraInicial, c_citas.HoraFinal, c_citas.Asistida, c_citas.Id_MotivoDesistida,  \nc_citas.Id_Usuario, w_profesional.Id_Persona, w_profesional.IdEspecialidad, c_citas.Id, `g_sedes`.`Nbre` AS Sede, IFNULL(c_desistidas.`Detalle`,'') AS Detalle FROM c_clasecita  \nINNER JOIN g_especialidad ON (c_clasecita.Id_Especialidad = g_especialidad.Id)  \nINNER JOIN c_citas  ON (c_citas.Id_ClaseCita = c_clasecita.Id) \nINNER JOIN w_profesional ON (c_citas.Id_Profesional = w_profesional.Id_Persona) AND (c_citas.Id_Especialidad = w_profesional.IdEspecialidad)  \nINNER JOIN `g_sedes` ON (`c_citas`.`Id_Sede`= `g_sedes`.`Id`)\nLEFT JOIN  `c_desistidas` ON (`c_clasecita`.`Id`=`c_desistidas`.`Id`) AND (`tipo`=1) WHERE (c_citas.Id_Usuario ='" + this.IdPersona + "') \nORDER BY c_citas.Fecha_Cita DESC";
            System.out.println(this.sql);
            this.rs = this.consultas.traerRs(this.sql);
            if (this.rs.next()) {
                this.fila = 0;
                this.rs.beforeFirst();
                while (this.rs.next()) {
                    this.modelo.addRow(this.dato);
                    this.modelo.setValueAt(this.rs.getString("ClaseCita"), this.fila, 0);
                    this.modelo.setValueAt(this.rs.getString("Profesional"), this.fila, 1);
                    this.modelo.setValueAt(this.rs.getString("Especialidad"), this.fila, 2);
                    this.modelo.setValueAt(this.rs.getString("Fecha_Cita"), this.fila, 3);
                    this.modelo.setValueAt(this.metodos.formatoHora12(this.rs.getString("HoraInicial")), this.fila, 4);
                    this.modelo.setValueAt(this.metodos.formatoHora12(this.rs.getString("HoraFinal")), this.fila, 5);
                    this.modelo.setValueAt(Boolean.valueOf(this.rs.getBoolean("Asistida")), this.fila, 6);
                    if (this.rs.getInt("Id_MotivoDesistida") == 1) {
                        this.modelo.setValueAt("Activa", this.fila, 7);
                    } else {
                        this.modelo.setValueAt("DESISTIDA", this.fila, 7);
                    }
                    this.modelo.setValueAt(this.rs.getString("Id_Persona"), this.fila, 8);
                    this.modelo.setValueAt(this.rs.getString("IdEspecialidad"), this.fila, 9);
                    this.modelo.setValueAt(this.rs.getString("Id"), this.fila, 10);
                    this.modelo.setValueAt(this.rs.getString("Sede"), this.fila, 11);
                    this.modelo.setValueAt(this.rs.getString("Detalle"), this.fila, 12);
                    this.fila++;
                }
                this.rs.close();
                this.consultas.cerrarConexionBd();
            }
        } catch (SQLException ex) {
            this.consultas.mostrarErrorE(ex);
        }
    }

    private void impresionRecordatorioCitas(String idCita) {
        this.frmCita.clasescita.imprimirRecordatorioCita(idCita);
    }

    private void cargarCita(int boton) {
        if (boton == 1) {
            if (this.frmLlamador.equals("Citas")) {
                this.frmCita.cargarCita(this.modelo.getValueAt(this.fila, 1).toString(), this.modelo.getValueAt(this.fila, 2).toString(), this.modelo.getValueAt(this.fila, 3).toString());
            } else if (this.frmLlamador.equals("jifseguimientolab1")) {
                this.xjifseg.JTFFNCita.setValue(Long.valueOf(this.modelo.getValueAt(this.grid.getSelectedRow(), 10).toString()));
            }
        } else if (this.frmLlamador.equals("jifseguimientolab1")) {
            this.xjifseg.JTFFNCita.setValue(Long.valueOf(this.modeloNP.getValueAt(this.gridNP.getSelectedRow(), 9).toString()));
        }
        dispose();
    }

    /* JADX WARN: Type inference failed for: r3v16, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.panelFondo = new JPanel();
        this.jScrollPane1 = new JScrollPane();
        this.grid = new JTable();
        this.jLabel2 = new JLabel();
        this.jLabel3 = new JLabel();
        this.jScrollPane2 = new JScrollPane();
        this.gridNP = new JTable();
        this.btnSalir = new JButton();
        this.btnProgramada = new JButton();
        this.btnNoProgramada = new JButton();
        setDefaultCloseOperation(2);
        setTitle("LISTADO DE CITAS");
        setName("BuscarCita");
        this.panelFondo.setBorder(BorderFactory.createEtchedBorder());
        this.jScrollPane1.setFont(new Font("Arial", 1, 12));
        this.grid.setFont(new Font("Arial", 1, 12));
        this.grid.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.grid.setColumnSelectionAllowed(true);
        this.grid.setRowHeight(25);
        this.grid.setSelectionBackground(new Color(255, 255, 255));
        this.grid.setSelectionForeground(new Color(255, 0, 0));
        this.grid.setSelectionMode(0);
        this.grid.addMouseListener(new MouseAdapter() { // from class: Citas.BuscarCitas.5
            public void mouseClicked(MouseEvent evt) {
                BuscarCitas.this.gridMouseClicked(evt);
            }
        });
        this.jScrollPane1.setViewportView(this.grid);
        this.grid.getColumnModel().getSelectionModel().setSelectionMode(0);
        this.jLabel2.setBackground(new Color(0, 0, 102));
        this.jLabel2.setFont(new Font("Arial", 1, 14));
        this.jLabel2.setForeground(new Color(204, 255, 255));
        this.jLabel2.setHorizontalAlignment(0);
        this.jLabel2.setText("Citas Programadas");
        this.jLabel2.setOpaque(true);
        this.jLabel3.setBackground(new Color(0, 102, 102));
        this.jLabel3.setFont(new Font("Arial", 1, 14));
        this.jLabel3.setForeground(new Color(255, 255, 255));
        this.jLabel3.setHorizontalAlignment(0);
        this.jLabel3.setText("Citas NO Programadas");
        this.jLabel3.setOpaque(true);
        this.jScrollPane2.setFont(new Font("Arial", 1, 12));
        this.gridNP.setFont(new Font("Arial", 1, 12));
        this.gridNP.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.gridNP.setRowHeight(25);
        this.gridNP.setSelectionBackground(new Color(255, 255, 255));
        this.gridNP.setSelectionForeground(new Color(255, 0, 0));
        this.gridNP.setSelectionMode(0);
        this.gridNP.addMouseListener(new MouseAdapter() { // from class: Citas.BuscarCitas.6
            public void mouseClicked(MouseEvent evt) {
                BuscarCitas.this.gridNPMouseClicked(evt);
            }
        });
        this.jScrollPane2.setViewportView(this.gridNP);
        this.gridNP.getColumnModel().getSelectionModel().setSelectionMode(0);
        GroupLayout panelFondoLayout = new GroupLayout(this.panelFondo);
        this.panelFondo.setLayout(panelFondoLayout);
        panelFondoLayout.setHorizontalGroup(panelFondoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel2, -1, -1, 32767).addGroup(panelFondoLayout.createSequentialGroup().addContainerGap().addGroup(panelFondoLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jScrollPane2, GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane1, GroupLayout.Alignment.LEADING)).addContainerGap()).addComponent(this.jLabel3, GroupLayout.Alignment.TRAILING, -1, -1, 32767));
        panelFondoLayout.setVerticalGroup(panelFondoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(panelFondoLayout.createSequentialGroup().addComponent(this.jLabel2, -2, 31, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane1, -2, 282, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel3, -2, 32, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane2, -1, 203, 32767).addContainerGap()));
        this.btnSalir.setFont(new Font("Arial", 1, 12));
        this.btnSalir.setForeground(new Color(0, 0, 153));
        this.btnSalir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.btnSalir.setText("Salir");
        this.btnSalir.addActionListener(new ActionListener() { // from class: Citas.BuscarCitas.7
            public void actionPerformed(ActionEvent evt) {
                BuscarCitas.this.btnSalirActionPerformed(evt);
            }
        });
        this.btnProgramada.setFont(new Font("Arial", 1, 12));
        this.btnProgramada.setForeground(new Color(0, 0, 153));
        this.btnProgramada.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Cita.png")));
        this.btnProgramada.setText("Cargar Cita Programada");
        this.btnProgramada.setEnabled(false);
        this.btnProgramada.addActionListener(new ActionListener() { // from class: Citas.BuscarCitas.8
            public void actionPerformed(ActionEvent evt) {
                BuscarCitas.this.btnProgramadaActionPerformed(evt);
            }
        });
        this.btnNoProgramada.setFont(new Font("Arial", 1, 12));
        this.btnNoProgramada.setForeground(new Color(0, 0, 153));
        this.btnNoProgramada.setIcon(new ImageIcon(getClass().getResource("/Imagenes/CitaEspecial.png")));
        this.btnNoProgramada.setText("Cargar Cita No Programada");
        this.btnNoProgramada.setEnabled(false);
        this.btnNoProgramada.addActionListener(new ActionListener() { // from class: Citas.BuscarCitas.9
            public void actionPerformed(ActionEvent evt) {
                BuscarCitas.this.btnNoProgramadaActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(layout.createSequentialGroup().addComponent(this.btnProgramada, -2, 329, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.btnNoProgramada, -2, 329, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.btnSalir, -2, 296, -2)).addComponent(this.panelFondo, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(this.panelFondo, -1, -1, 32767).addGap(18, 18, 18).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.btnSalir, -2, 40, -2).addComponent(this.btnProgramada, -2, 40, -2).addComponent(this.btnNoProgramada, -2, 40, -2)).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gridMouseClicked(MouseEvent evt) {
        if (this.grid.getSelectedRow() != -1 && evt.getClickCount() == 2) {
            impresionRecordatorioCitas(this.grid.getValueAt(this.grid.getSelectedRow(), 10).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnSalirActionPerformed(ActionEvent evt) {
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gridNPMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnProgramadaActionPerformed(ActionEvent evt) {
        cargarCita(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnNoProgramadaActionPerformed(ActionEvent evt) {
        cargarCita(2);
    }
}
