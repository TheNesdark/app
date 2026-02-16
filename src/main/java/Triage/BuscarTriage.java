package Triage;

import Acceso.Menus;
import Acceso.Principal;
import General.Persona;
import Utilidades.ConsultasMySQL;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Triage/BuscarTriage.class */
public class BuscarTriage extends JInternalFrame {
    private DefaultTableModel modelo;
    private String sql;
    private Object[] dato;
    private ResultSet rs;
    private Persona frmPersona;
    private claseTriage clasetriage;
    private JButton btnBuscar;
    public JTable grid;
    private JPanel jPanel1;
    private JScrollPane jScrollPane3;
    private JPanel panelPersona;
    private ConsultasMySQL consultas = new ConsultasMySQL();
    private int fila = 0;

    public BuscarTriage(claseTriage Clasetriage) {
        initComponents();
        this.clasetriage = Clasetriage;
        setLocation(80, 10);
        this.frmPersona = new Persona(this);
        cargarPanelPersona();
        crearGrid();
        nuevo();
        this.grid.addMouseListener(new MouseAdapter() { // from class: Triage.BuscarTriage.1
            public void mouseClicked(MouseEvent e) {
                BuscarTriage.this.fila = BuscarTriage.this.grid.rowAtPoint(e.getPoint());
                if (e.getClickCount() > 1) {
                    BuscarTriage.this.imprimirTriage();
                }
            }
        });
    }

    public void buscar() {
        this.frmPersona.buscar(3);
    }

    private void crearGrid() {
        this.modelo = new DefaultTableModel() { // from class: Triage.BuscarTriage.2
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.modelo.addColumn("Número");
        this.modelo.addColumn("Fecha");
        this.modelo.addColumn("Hora");
        this.modelo.addColumn("Motivo consulta");
        this.modelo.addColumn("Hallazgo");
        this.modelo.addColumn("Profesional");
        this.grid.setModel(this.modelo);
        this.grid.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.grid.getColumnModel().getColumn(0).setMinWidth(80);
        this.grid.getColumnModel().getColumn(0).setMaxWidth(80);
        this.grid.getColumnModel().getColumn(1).setPreferredWidth(80);
        this.grid.getColumnModel().getColumn(2).setPreferredWidth(80);
        this.grid.getColumnModel().getColumn(3).setPreferredWidth(300);
        this.grid.getColumnModel().getColumn(4).setPreferredWidth(300);
        this.grid.getColumnModel().getColumn(5).setPreferredWidth(120);
        this.fila = 0;
    }

    public void cargarTriages() {
        this.sql = "SELECT u_triage.Id, u_triage.FechaTriage, DATE_FORMAT(u_triage.Hora, '%h:%i %p') as Hora, u_triage.MotivoConsulta, u_triage.HallazgoClinico, profesional.NProfesional FROM u_triage INNER JOIN profesional ON (u_triage.Id_Profesional = profesional.Id_Persona) WHERE (u_triage.Id_Usuario = '" + this.frmPersona.getIdPersona() + "')";
        this.rs = this.consultas.traerRs(this.sql);
        try {
            crearGrid();
            while (this.rs.next()) {
                this.modelo.addRow(this.dato);
                this.modelo.setValueAt(this.rs.getString(1), this.fila, 0);
                this.modelo.setValueAt(this.rs.getString(2), this.fila, 1);
                this.modelo.setValueAt(this.rs.getString(3), this.fila, 2);
                this.modelo.setValueAt(this.rs.getString(4), this.fila, 3);
                this.modelo.setValueAt(this.rs.getString(5), this.fila, 4);
                this.modelo.setValueAt(this.rs.getString(6), this.fila, 5);
                this.fila++;
            }
            this.rs.close();
            this.consultas.cerrarConexionBd();
        } catch (SQLException ex) {
            this.consultas.mostrarErrorSQL(ex);
        }
    }

    private void cargarPanelPersona() {
        this.frmPersona.setVisible(true);
        this.panelPersona.setVisible(false);
        this.frmPersona.setBounds(1, 1, 1199, 160);
        this.panelPersona.add(this.frmPersona);
        this.panelPersona.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void imprimirTriage() {
        Principal.clasetriage.imprimirtriage(this.modelo.getValueAt(this.fila, 0).toString());
    }

    public void nuevo() {
        this.frmPersona.nuevo();
        crearGrid();
    }

    /* JADX WARN: Type inference failed for: r3v12, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.panelPersona = new JPanel();
        this.jScrollPane3 = new JScrollPane();
        this.grid = new JTable();
        this.jPanel1 = new JPanel();
        this.btnBuscar = new JButton();
        setClosable(true);
        setIconifiable(true);
        setTitle("BUSCAR TRIAGE");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMinimumSize(new Dimension(1096, 500));
        setName("BuscarTriage");
        setPreferredSize(new Dimension(1096, 500));
        addInternalFrameListener(new InternalFrameListener() { // from class: Triage.BuscarTriage.3
            public void internalFrameActivated(InternalFrameEvent evt) {
                BuscarTriage.this.formInternalFrameActivated(evt);
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
        getContentPane().setLayout((LayoutManager) null);
        GroupLayout panelPersonaLayout = new GroupLayout(this.panelPersona);
        this.panelPersona.setLayout(panelPersonaLayout);
        panelPersonaLayout.setHorizontalGroup(panelPersonaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 930, 32767));
        panelPersonaLayout.setVerticalGroup(panelPersonaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 170, 32767));
        getContentPane().add(this.panelPersona);
        this.panelPersona.setBounds(10, 10, 930, 170);
        this.jScrollPane3.setFont(new Font("Arial", 1, 12));
        this.grid.setBorder(BorderFactory.createBevelBorder(0));
        this.grid.setFont(new Font("Arial", 1, 12));
        this.grid.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.grid.setEditingColumn(1);
        this.grid.setEditingRow(1);
        this.grid.setRowHeight(25);
        this.grid.setSelectionBackground(new Color(255, 255, 255));
        this.grid.setSelectionForeground(new Color(255, 0, 0));
        this.grid.setSelectionMode(0);
        this.grid.addMouseListener(new MouseAdapter() { // from class: Triage.BuscarTriage.4
            public void mousePressed(MouseEvent evt) {
                BuscarTriage.this.gridMousePressed(evt);
            }
        });
        this.grid.addKeyListener(new KeyAdapter() { // from class: Triage.BuscarTriage.5
            public void keyReleased(KeyEvent evt) {
                BuscarTriage.this.gridKeyReleased(evt);
            }
        });
        this.jScrollPane3.setViewportView(this.grid);
        getContentPane().add(this.jScrollPane3);
        this.jScrollPane3.setBounds(10, 200, 1060, 220);
        this.btnBuscar.setForeground(new Color(0, 0, 153));
        this.btnBuscar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/HojaLapiz29x27.png")));
        this.btnBuscar.setHideActionText(true);
        this.btnBuscar.setHorizontalTextPosition(0);
        this.btnBuscar.setIconTextGap(2);
        this.btnBuscar.setVerticalTextPosition(3);
        this.btnBuscar.addActionListener(new ActionListener() { // from class: Triage.BuscarTriage.6
            public void actionPerformed(ActionEvent evt) {
                BuscarTriage.this.btnBuscarActionPerformed(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.btnBuscar, -1, 120, 32767).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.btnBuscar, -1, 128, 32767).addContainerGap()));
        getContentPane().add(this.jPanel1);
        this.jPanel1.setBounds(940, 20, 140, 150);
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gridKeyReleased(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gridMousePressed(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameActivated(InternalFrameEvent evt) {
        this.clasetriage.frmPrincipal.mQuitarBarraMenu();
        Principal principal = this.clasetriage.frmPrincipal;
        Menus menus = this.clasetriage.frmPrincipal.xMenus;
        principal.mActivarBarraMenu(Menus.barraMnuTriage, this.clasetriage.getModulo());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnBuscarActionPerformed(ActionEvent evt) {
        cargarTriages();
    }
}
