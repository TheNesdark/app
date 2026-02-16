package PyP;

import Acceso.Principal;
import Historia.clasesHistoriaCE;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:PyP/Alimentacion.class */
public class Alimentacion extends JPanel {
    private Metodos metodos = new Metodos();
    private ConsultasMySQL consultas = new ConsultasMySQL();
    private int filaGrid = 0;
    private String sql;
    private String idAtencion;
    private String estado;
    private String fecha;
    private String idPaciente;
    private DefaultTableModel modelo;
    private clasePyP clasepyp;
    private Object[] dato;
    private ResultSet rs;
    private JTable grid;
    private ButtonGroup grupoAComplementaria;
    private ButtonGroup grupoLactancia;
    private ButtonGroup grupoOtrasLeches;
    private ButtonGroup grupoRemitido;
    private JLabel jLabel1;
    private JPanel jPanel2;
    private JScrollPane jScrollPane1;
    private JTabbedPane jTabbedPane1;

    public Alimentacion(clasePyP clase, String paciente, String atencion) {
        initComponents();
        this.clasepyp = clase;
        this.idPaciente = paciente;
        this.idAtencion = atencion;
        crearGrid();
        cargarGrid();
        this.grid.addMouseListener(new MouseAdapter() { // from class: PyP.Alimentacion.1
            public void mouseClicked(MouseEvent e) {
                Alimentacion.this.filaGrid = Alimentacion.this.grid.rowAtPoint(e.getPoint());
            }
        });
    }

    public void anular() {
        if (this.metodos.getPregunta("Se Anulará toda la Atención incluyendo las Motricidades, Lenguaje y Personal Social. Esta seguro de Anular?") == 0) {
            this.sql = "UPDATE p_atencioninfantilprescolar SET Estado = 1, Fecha ='" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "', UsuarioS ='" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "' WHERE IdAtencion ='" + this.idAtencion + "' AND IdPersona ='" + this.idPaciente + "'";
            this.consultas.ejecutarSQL(this.sql);
            this.consultas.cerrarConexionBd();
            crearGrid();
            cargarGrid();
            this.metodos.mostrarMensaje("Registro Anulado");
        }
    }

    private void cargarGrid() {
        this.sql = "SELECT FechaAtencion as Fecha, Lactancia, OtrasLeches as Otras, AComplementaria as Complemen FROM p_atencioninfantilprescolar WHERE (IdPersona ='" + this.idPaciente + "') ORDER BY FechaAtencion ASC";
        this.rs = this.consultas.traerRs(this.sql);
        try {
            if (this.rs.next()) {
                this.rs.beforeFirst();
                this.filaGrid = 0;
                while (this.rs.next()) {
                    this.modelo.addRow(this.dato);
                    this.modelo.setValueAt(this.rs.getString("Fecha"), this.filaGrid, 0);
                    if (this.rs.getInt("Lactancia") == 0) {
                        this.modelo.setValueAt(false, this.filaGrid, 1);
                    } else {
                        this.modelo.setValueAt(true, this.filaGrid, 1);
                    }
                    if (this.rs.getInt("Otras") == 0) {
                        this.modelo.setValueAt(false, this.filaGrid, 2);
                    } else {
                        this.modelo.setValueAt(true, this.filaGrid, 2);
                    }
                    if (this.rs.getInt("Complemen") == 0) {
                        this.modelo.setValueAt(false, this.filaGrid, 3);
                    } else {
                        this.modelo.setValueAt(true, this.filaGrid, 3);
                    }
                    this.modelo.setValueAt(true, this.filaGrid, 4);
                    this.filaGrid++;
                }
            }
            this.rs.close();
            this.consultas.cerrarConexionBd();
        } catch (SQLException ex) {
            this.consultas.mostrarErrorSQL(ex);
        }
    }

    private void crearGrid() {
        this.modelo = new DefaultTableModel((Object[][]) null, new String[]{"Fecha", "Lactancia", "Otras Leches", "A. Complementaria", "Grabada"}) { // from class: PyP.Alimentacion.2
            Class[] types = {String.class, Boolean.class, Boolean.class, Boolean.class, Boolean.class};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }
        };
        this.grid.setModel(this.modelo);
        this.grid.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.grid.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(0).setMinWidth(80);
        this.grid.getColumnModel().getColumn(0).setMaxWidth(80);
        this.grid.getColumnModel().getColumn(1).setMinWidth(120);
        this.grid.getColumnModel().getColumn(1).setMaxWidth(120);
        this.grid.getColumnModel().getColumn(2).setMinWidth(120);
        this.grid.getColumnModel().getColumn(2).setMaxWidth(120);
        this.grid.getColumnModel().getColumn(3).setMinWidth(120);
        this.grid.getColumnModel().getColumn(3).setMaxWidth(120);
        this.grid.getColumnModel().getColumn(4).setMinWidth(100);
        this.grid.getColumnModel().getColumn(4).setMaxWidth(100);
        this.filaGrid = 0;
    }

    private void eliminarFilaGrid() {
        if (this.metodos.getPregunta("Esta seguro de Eliminar la fila?") == 0) {
            this.modelo.removeRow(this.filaGrid);
        }
    }

    public void grabar() {
        for (int f = 0; f < this.modelo.getRowCount(); f++) {
            System.out.println(this.modelo.getValueAt(f, 4));
            if (this.modelo.getValueAt(f, 4) == null) {
                this.sql = "INSERT INTO p_atencioninfantilprescolar(IdAtencion, IdPersona, FechaAtencion, Lactancia, OtrasLeches, AComplementaria, Fecha, UsuarioS) VALUES('" + this.idAtencion + "','" + this.idPaciente + "','" + this.modelo.getValueAt(f, 0) + "','";
                if (this.modelo.getValueAt(f, 1) == null) {
                    this.sql += "0','";
                } else {
                    this.sql += "1','";
                }
                if (this.modelo.getValueAt(f, 2) == null) {
                    this.sql += "0','";
                } else {
                    this.sql += "1','";
                }
                if (this.modelo.getValueAt(f, 3) == null) {
                    this.sql += "0','";
                } else {
                    this.sql += "1','";
                }
                this.sql += this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                this.consultas.ejecutarSQL(this.sql);
                this.consultas.cerrarConexionBd();
                clasesHistoriaCE claseshistoriace = Principal.clasehistoriace;
                if (clasesHistoriaCE.informacionAgendaMedicaDTO.getFormaHistoria().intValue() == 1) {
                    Principal.clasehistoriace.historia_Clinica_v2.consultarEstadoItems(getName(), 1, true);
                }
            }
        }
        this.metodos.mostrarMensaje("Registro Grabado");
    }

    public void nuevo() {
        this.modelo.addRow(this.dato);
        this.modelo.setValueAt(this.metodos.formatoAMD.format(this.metodos.getFechaActual()), this.filaGrid, 0);
        this.filaGrid++;
    }

    /* JADX WARN: Type inference failed for: r3v5, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.grupoLactancia = new ButtonGroup();
        this.grupoOtrasLeches = new ButtonGroup();
        this.grupoAComplementaria = new ButtonGroup();
        this.grupoRemitido = new ButtonGroup();
        this.jTabbedPane1 = new JTabbedPane();
        this.jPanel2 = new JPanel();
        this.jScrollPane1 = new JScrollPane();
        this.grid = new JTable();
        this.jLabel1 = new JLabel();
        setName("Alimentacion");
        setLayout(null);
        this.jTabbedPane1.setForeground(new Color(0, 102, 102));
        this.jTabbedPane1.setFont(new Font("Arial", 1, 14));
        this.jPanel2.setLayout((LayoutManager) null);
        this.jScrollPane1.setFont(new Font("Arial", 1, 12));
        this.grid.setFont(new Font("Arial", 1, 12));
        this.grid.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.grid.setRowHeight(25);
        this.grid.setSelectionBackground(new Color(255, 255, 255));
        this.grid.setSelectionForeground(new Color(255, 0, 0));
        this.grid.setSelectionMode(0);
        this.grid.addKeyListener(new KeyAdapter() { // from class: PyP.Alimentacion.3
            public void keyPressed(KeyEvent evt) {
                Alimentacion.this.gridKeyPressed(evt);
            }
        });
        this.jScrollPane1.setViewportView(this.grid);
        this.jPanel2.add(this.jScrollPane1);
        this.jScrollPane1.setBounds(10, 10, 830, 340);
        this.jTabbedPane1.addTab("Alimentación", this.jPanel2);
        add(this.jTabbedPane1);
        this.jTabbedPane1.setBounds(10, 50, 850, 390);
        this.jLabel1.setBackground(new Color(0, 0, 153));
        this.jLabel1.setFont(new Font("Arial", 1, 14));
        this.jLabel1.setForeground(new Color(204, 255, 255));
        this.jLabel1.setHorizontalAlignment(0);
        this.jLabel1.setText("ATENCION INFANTIL Y PRESCOLAR");
        this.jLabel1.setOpaque(true);
        add(this.jLabel1);
        this.jLabel1.setBounds(0, 0, 860, 40);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gridKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 127) {
            eliminarFilaGrid();
        }
    }
}
