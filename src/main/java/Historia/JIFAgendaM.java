package Historia;

import Acceso.Principal;
import Citas.Calendario;
import Citas.clasesCita;
import General.Persona;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/* JADX INFO: loaded from: GenomaP.jar:Historia/JIFAgendaM.class */
public class JIFAgendaM extends JInternalFrame {
    public String[] listaDiasFestivos;
    public String[][] listaProfesional;
    public String[][] listaClaseCita;
    public int filaArbol;
    public String sql;
    public String nbreProfesional;
    public String especialAnterior;
    public static String NoCitaIps;
    public DefaultMutableTreeNode rama;
    public DefaultMutableTreeNode hoja;
    public static Object[] dato;
    public static DefaultTableModel modeloGrid;
    private String idCita;
    public Persona frmPersona;
    private Calendario frmCalendario;
    private clasesCita clasescita;
    private Thread hilo;
    public static JTable grid;
    private JButton jButton1;
    private JButton jButton2;
    private JPanel jPanel5;
    private JScrollPane jScrollPane3;
    public JLabel lblFecha;
    public static int filaGrid = 0;
    public static int motivoDesistida = 1;
    private static boolean estado = true;
    private Metodos metodos = new Metodos();
    private ConsultasMySQL consultas = new ConsultasMySQL();
    public String[][] listaPacientesConCita = new String[0][0];
    public int filaListaDiasConCita = 0;
    public int comboLleno = 0;
    public int combocc = 0;
    public String idEspecialidad = "";
    public DefaultMutableTreeNode tallo = new DefaultMutableTreeNode("Especialidades");
    public DefaultTreeModel modeloArbol = new DefaultTreeModel(this.tallo);
    public DefaultMutableTreeNode nodo = new DefaultMutableTreeNode();
    private int citaTelefonica = 0;
    private int citaPrimerVez = 0;
    private int grabarCita = 0;
    public int remitida = -1;
    private int idReasignar = 0;
    private int tipoCitaRepetida = 0;
    private String NoCitaAReasignar = "0";

    public JIFAgendaM() {
        initComponents();
        crearGrid();
        grid.addMouseListener(new MouseAdapter() { // from class: Historia.JIFAgendaM.1
            public void mouseClicked(MouseEvent e) {
                JIFAgendaM.filaGrid = JIFAgendaM.grid.rowAtPoint(e.getPoint());
                if (JIFAgendaM.grid.getValueAt(JIFAgendaM.filaGrid, 3) == null) {
                    JIFAgendaM.this.metodos.limpiarDatosPrincipal();
                    return;
                }
                JIFAgendaM.this.idCita = JIFAgendaM.grid.getValueAt(JIFAgendaM.filaGrid, 3).toString();
                Principal.txtNo.setText(JIFAgendaM.this.idCita);
                Principal.txtEstado.setText("ACTIVA");
                Principal.txtFecha.setText(JIFAgendaM.this.metodos.formatoDMA.format(JIFAgendaM.this.frmCalendario.getFecha().getTime()));
                if (e.getClickCount() > 1) {
                    JIFAgendaM.this.frmPersona.setIdPersona(JIFAgendaM.grid.getValueAt(JIFAgendaM.filaGrid, 4).toString());
                    JIFAgendaM.this.frmPersona.buscar(1);
                }
            }
        });
    }

    private void mIniciar() {
    }

    public void cEstadoFalso() {
        estado = false;
    }

    public void cEstadoVerdadero() {
        estado = true;
    }

    public void revisarCita() {
        try {
            this.sql = "SELECT Id, Nbre, ExigeNit FROM baseserver.g_tipoempresa";
            ResultSet rs = this.consultas.traerRs(this.sql);
            if (rs.next()) {
                rs.first();
                int x = 0;
                while (rs.next()) {
                    modeloGrid.addRow(dato);
                    modeloGrid.setValueAt(rs.getString(1), x, 0);
                    modeloGrid.setValueAt(rs.getString(2), x, 1);
                    modeloGrid.setValueAt(rs.getString(3), x, 2);
                    grid.setDefaultRenderer(Object.class, new MiRender5());
                    x++;
                }
            }
            this.consultas.cerrarConexionBd();
        } catch (SQLException ex) {
            this.consultas.mostrarErrorSQL(ex);
        }
    }

    public static void crearGrid() {
        modeloGrid = new DefaultTableModel() { // from class: Historia.JIFAgendaM.2
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        modeloGrid.addColumn("DESDE");
        modeloGrid.addColumn("HASTA");
        modeloGrid.addColumn("USUARIO");
        modeloGrid.addColumn("");
        modeloGrid.addColumn("");
        modeloGrid.addColumn("CLASE DE CITA");
        modeloGrid.addColumn("");
        modeloGrid.addColumn("");
        modeloGrid.addColumn("");
        grid.setModel(modeloGrid);
        grid.getColumnModel().getColumn(0).setPreferredWidth(90);
        grid.getColumnModel().getColumn(1).setPreferredWidth(90);
        grid.getColumnModel().getColumn(2).setPreferredWidth(400);
        grid.getColumnModel().getColumn(3).setPreferredWidth(0);
        grid.getColumnModel().getColumn(3).setMinWidth(0);
        grid.getColumnModel().getColumn(3).setMaxWidth(0);
        grid.getColumnModel().getColumn(4).setPreferredWidth(0);
        grid.getColumnModel().getColumn(4).setMinWidth(0);
        grid.getColumnModel().getColumn(4).setMaxWidth(0);
        grid.getColumnModel().getColumn(5).setPreferredWidth(200);
        grid.getColumnModel().getColumn(5).setMinWidth(200);
        grid.getColumnModel().getColumn(5).setMaxWidth(200);
        grid.getColumnModel().getColumn(6).setPreferredWidth(0);
        grid.getColumnModel().getColumn(6).setMinWidth(0);
        grid.getColumnModel().getColumn(6).setMaxWidth(0);
        grid.getColumnModel().getColumn(7).setPreferredWidth(0);
        grid.getColumnModel().getColumn(7).setMinWidth(0);
        grid.getColumnModel().getColumn(7).setMaxWidth(0);
        grid.getColumnModel().getColumn(8).setPreferredWidth(0);
        grid.getColumnModel().getColumn(8).setMinWidth(0);
        grid.getColumnModel().getColumn(8).setMaxWidth(0);
        filaGrid = 0;
    }

    /* JADX INFO: loaded from: GenomaP.jar:Historia/JIFAgendaM$MiRender5.class */
    public static class MiRender5 extends DefaultTableCellRenderer {
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            String trabajador = table.getValueAt(row, 2).toString();
            if (trabajador != null && trabajador.equals("1")) {
                cell.setBackground(new Color(255, 255, 204));
                cell.setForeground(Color.BLACK);
            } else {
                cell.setBackground(Color.WHITE);
            }
            return cell;
        }
    }

    /* JADX WARN: Type inference failed for: r3v9, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jPanel5 = new JPanel();
        this.jScrollPane3 = new JScrollPane();
        grid = new JTable();
        this.lblFecha = new JLabel();
        this.jButton1 = new JButton();
        this.jButton2 = new JButton();
        setClosable(true);
        setIconifiable(true);
        setTitle("ASIGNACIÓN Y CONTROL DE CITAS");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMaximumSize(new Dimension(1212, 835));
        setMinimumSize(new Dimension(1212, 835));
        setName("Citas");
        setPreferredSize(new Dimension(1212, 835));
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        getContentPane().setLayout((LayoutManager) null);
        this.jPanel5.setBorder(BorderFactory.createBevelBorder(0));
        this.jPanel5.setLayout((LayoutManager) null);
        grid.setFont(new Font("Arial", 1, 12));
        grid.setForeground(new Color(0, 0, 102));
        grid.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        grid.setAutoResizeMode(3);
        grid.setCellSelectionEnabled(true);
        grid.setName("grid");
        grid.setRowHeight(25);
        grid.setSelectionBackground(new Color(255, 255, 255));
        grid.setSelectionForeground(new Color(255, 0, 0));
        grid.setSelectionMode(0);
        this.jScrollPane3.setViewportView(grid);
        grid.getColumnModel().getSelectionModel().setSelectionMode(1);
        this.jPanel5.add(this.jScrollPane3);
        this.jScrollPane3.setBounds(330, 190, 540, 590);
        this.lblFecha.setBackground(new Color(0, 0, 153));
        this.lblFecha.setFont(new Font("Arial", 1, 12));
        this.lblFecha.setForeground(new Color(204, 255, 255));
        this.lblFecha.setHorizontalAlignment(0);
        this.lblFecha.setText("jLabel8");
        this.lblFecha.setOpaque(true);
        this.jPanel5.add(this.lblFecha);
        this.lblFecha.setBounds(330, 170, 540, 20);
        this.jButton1.setFont(new Font("Arial", 1, 12));
        this.jButton1.setText("Verdadero");
        this.jButton1.addActionListener(new ActionListener() { // from class: Historia.JIFAgendaM.3
            public void actionPerformed(ActionEvent evt) {
                JIFAgendaM.this.jButton1ActionPerformed(evt);
            }
        });
        this.jPanel5.add(this.jButton1);
        this.jButton1.setBounds(920, 430, 110, 23);
        this.jButton2.setFont(new Font("Arial", 1, 12));
        this.jButton2.setText("Falso");
        this.jButton2.addActionListener(new ActionListener() { // from class: Historia.JIFAgendaM.4
            public void actionPerformed(ActionEvent evt) {
                JIFAgendaM.this.jButton2ActionPerformed(evt);
            }
        });
        this.jPanel5.add(this.jButton2);
        this.jButton2.setBounds(920, 380, 70, 23);
        getContentPane().add(this.jPanel5);
        this.jPanel5.setBounds(0, 0, 1200, 790);
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jButton2ActionPerformed(ActionEvent evt) {
        cEstadoFalso();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jButton1ActionPerformed(ActionEvent evt) {
        cEstadoVerdadero();
    }
}
