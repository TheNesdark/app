package PyP;

import Utilidades.ConsultasMySQL;
import Utilidades.Graficas;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:PyP/P_ValoracionResultado.class */
public class P_ValoracionResultado extends JPanel {
    private String sql;
    private String IdAtencion;
    private String IdPaciente;
    private String idSexo;
    private ResultSet rs;
    public DefaultTableModel modeloGrid;
    private Object[] dato;
    private Graficas graficas;
    private JButton btnImc05;
    private JButton btnImc519;
    private JButton btnPeso05;
    private JButton btnPeso510;
    private JButton btnTalla05;
    private JButton btnTalla519;
    private JTable grid;
    private JLabel jLabel50;
    private JLabel jLabel51;
    private JScrollPane jScrollPane1;
    private JPanel panelGrafico;
    private JPanel panelGrafico2;
    private JTextField txtEdad;
    private String titulo = "G@noma Soft";
    private Metodos metodos = new Metodos();
    private ConsultasMySQL consultas = new ConsultasMySQL();
    private int filaGrid = 0;

    public P_ValoracionResultado(String IdAtencion, String IdPaciente, String idSexo) {
        initComponents();
        this.IdAtencion = IdAtencion;
        this.IdPaciente = IdPaciente;
        this.idSexo = idSexo;
        traerEdad();
        crearGrid();
        cargarDatos();
        if (Integer.parseInt(this.txtEdad.getText()) < 60) {
            this.btnTalla05.setEnabled(true);
            this.btnTalla519.setEnabled(false);
            this.btnPeso05.setEnabled(true);
            this.btnPeso510.setEnabled(false);
            this.btnImc05.setEnabled(true);
            this.btnImc519.setEnabled(false);
            return;
        }
        this.btnTalla05.setEnabled(false);
        this.btnTalla519.setEnabled(true);
        this.btnPeso05.setEnabled(false);
        this.btnPeso510.setEnabled(true);
        this.btnImc05.setEnabled(false);
        this.btnImc519.setEnabled(true);
    }

    /* JADX WARN: Type inference failed for: r3v11, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jLabel51 = new JLabel();
        this.txtEdad = new JTextField();
        this.jLabel50 = new JLabel();
        this.jScrollPane1 = new JScrollPane();
        this.grid = new JTable();
        this.panelGrafico = new JPanel();
        this.panelGrafico2 = new JPanel();
        this.btnImc519 = new JButton();
        this.btnTalla05 = new JButton();
        this.btnTalla519 = new JButton();
        this.btnPeso05 = new JButton();
        this.btnPeso510 = new JButton();
        this.btnImc05 = new JButton();
        setName("P_ValoracionResultado");
        setLayout(null);
        this.jLabel51.setFont(new Font("Arial", 1, 12));
        this.jLabel51.setForeground(new Color(0, 0, 204));
        this.jLabel51.setText("Edad Actual");
        add(this.jLabel51);
        this.jLabel51.setBounds(20, 10, 100, 30);
        this.txtEdad.setEditable(false);
        this.txtEdad.setFont(new Font("Arial", 1, 12));
        this.txtEdad.setForeground(new Color(0, 0, 153));
        this.txtEdad.setHorizontalAlignment(0);
        add(this.txtEdad);
        this.txtEdad.setBounds(110, 10, 80, 30);
        this.jLabel50.setFont(new Font("Arial", 1, 12));
        this.jLabel50.setForeground(new Color(0, 0, 204));
        this.jLabel50.setText("Meses");
        add(this.jLabel50);
        this.jLabel50.setBounds(210, 10, 60, 30);
        this.grid.setFont(new Font("Arial", 1, 12));
        this.grid.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[]{"Title 1", "Title 2", "Title 3", "Title 4"}));
        this.grid.setRowHeight(25);
        this.grid.setSelectionBackground(new Color(255, 255, 255));
        this.grid.setSelectionForeground(new Color(255, 0, 0));
        this.grid.setSelectionMode(0);
        this.jScrollPane1.setViewportView(this.grid);
        add(this.jScrollPane1);
        this.jScrollPane1.setBounds(20, 50, 790, 220);
        this.panelGrafico.setBorder(BorderFactory.createEtchedBorder(0));
        this.panelGrafico.setLayout((LayoutManager) null);
        add(this.panelGrafico);
        this.panelGrafico.setBounds(20, 280, 790, 310);
        this.panelGrafico2.setBorder(BorderFactory.createTitledBorder((Border) null, "Generar Curvas Gráficas", 0, 0, new Font("Arial", 1, 12)));
        this.panelGrafico2.setLayout((LayoutManager) null);
        this.btnImc519.setFont(new Font("Arial", 1, 12));
        this.btnImc519.setText("IMC 5-19");
        this.btnImc519.addActionListener(new ActionListener() { // from class: PyP.P_ValoracionResultado.1
            public void actionPerformed(ActionEvent evt) {
                P_ValoracionResultado.this.btnImc519ActionPerformed(evt);
            }
        });
        this.panelGrafico2.add(this.btnImc519);
        this.btnImc519.setBounds(610, 20, 120, 40);
        this.btnTalla05.setFont(new Font("Arial", 1, 12));
        this.btnTalla05.setText("Talla/Edad 0-5");
        this.btnTalla05.addActionListener(new ActionListener() { // from class: PyP.P_ValoracionResultado.2
            public void actionPerformed(ActionEvent evt) {
                P_ValoracionResultado.this.btnTalla05ActionPerformed(evt);
            }
        });
        this.panelGrafico2.add(this.btnTalla05);
        this.btnTalla05.setBounds(10, 20, 120, 40);
        this.btnTalla519.setFont(new Font("Arial", 1, 12));
        this.btnTalla519.setText("Talla/Edad 5-19");
        this.btnTalla519.addActionListener(new ActionListener() { // from class: PyP.P_ValoracionResultado.3
            public void actionPerformed(ActionEvent evt) {
                P_ValoracionResultado.this.btnTalla519ActionPerformed(evt);
            }
        });
        this.panelGrafico2.add(this.btnTalla519);
        this.btnTalla519.setBounds(130, 20, 120, 40);
        this.btnPeso05.setFont(new Font("Arial", 1, 12));
        this.btnPeso05.setText("Peso/Edad 0-5");
        this.btnPeso05.addActionListener(new ActionListener() { // from class: PyP.P_ValoracionResultado.4
            public void actionPerformed(ActionEvent evt) {
                P_ValoracionResultado.this.btnPeso05ActionPerformed(evt);
            }
        });
        this.panelGrafico2.add(this.btnPeso05);
        this.btnPeso05.setBounds(250, 20, 120, 40);
        this.btnPeso510.setFont(new Font("Arial", 1, 12));
        this.btnPeso510.setText("Peso/Edad 5-10");
        this.btnPeso510.addActionListener(new ActionListener() { // from class: PyP.P_ValoracionResultado.5
            public void actionPerformed(ActionEvent evt) {
                P_ValoracionResultado.this.btnPeso510ActionPerformed(evt);
            }
        });
        this.panelGrafico2.add(this.btnPeso510);
        this.btnPeso510.setBounds(370, 20, 120, 40);
        this.btnImc05.setFont(new Font("Arial", 1, 12));
        this.btnImc05.setText("IMC 0-5");
        this.btnImc05.addActionListener(new ActionListener() { // from class: PyP.P_ValoracionResultado.6
            public void actionPerformed(ActionEvent evt) {
                P_ValoracionResultado.this.btnImc05ActionPerformed(evt);
            }
        });
        this.panelGrafico2.add(this.btnImc05);
        this.btnImc05.setBounds(490, 20, 120, 40);
        add(this.panelGrafico2);
        this.panelGrafico2.setBounds(20, 590, 790, 70);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnImc519ActionPerformed(ActionEvent evt) {
        graficar(6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnTalla05ActionPerformed(ActionEvent evt) {
        graficar(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnTalla519ActionPerformed(ActionEvent evt) {
        graficar(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnPeso05ActionPerformed(ActionEvent evt) {
        graficar(3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnPeso510ActionPerformed(ActionEvent evt) {
        graficar(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnImc05ActionPerformed(ActionEvent evt) {
        graficar(5);
    }

    private String calcularEstado(String Edad, int valor) {
        String resultado = "Sin Dato";
        try {
            this.sql = "SELECT TotalBajaIni, TotalBajaFin, TotalMediaIni, TotalMediaFin, TotalAltaIni, TotalAltaFin, TotalMayor FROM baseserver.p_param_crec_desarrollo WHERE (EdadIni <= '" + Edad + "' AND EdadFin >= '" + Edad + "')";
            this.rs = this.consultas.traerRs(this.sql);
            this.rs.last();
            if (this.rs.getRow() > 0) {
                if (valor >= this.rs.getInt(1) && valor <= this.rs.getInt(2)) {
                    resultado = "ALERTA";
                } else if (valor >= this.rs.getInt(3) && valor <= this.rs.getInt(4)) {
                    resultado = "MEDIO";
                } else if (valor >= this.rs.getInt(5) && valor <= this.rs.getInt(6)) {
                    resultado = "ALTO";
                } else {
                    resultado = "MUY ALTO";
                }
            }
            this.rs.close();
            this.consultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(P_ValoracionResultado.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return resultado;
    }

    private void cargarDatos() {
        this.sql = "SELECT FechaAtencion, Motora, Adaptativa, Lenguaje, PersonalSocial FROM baseserver.p_atencioninfantilprescolar WHERE IdPersona ='" + this.IdPaciente + "'";
        this.rs = this.consultas.traerRs(this.sql);
        try {
            this.rs.last();
            if (this.rs.getRow() > 0) {
                this.rs.beforeFirst();
                this.filaGrid = 0;
                while (this.rs.next()) {
                    this.modeloGrid.addRow(this.dato);
                    int valor = this.rs.getInt(2) + this.rs.getInt(3) + this.rs.getInt(4) + this.rs.getInt(5);
                    this.modeloGrid.setValueAt(this.rs.getString(1), this.filaGrid, 0);
                    this.modeloGrid.setValueAt(this.rs.getString(2), this.filaGrid, 1);
                    this.modeloGrid.setValueAt(this.rs.getString(3), this.filaGrid, 2);
                    this.modeloGrid.setValueAt(this.rs.getString(4), this.filaGrid, 3);
                    this.modeloGrid.setValueAt(this.rs.getString(5), this.filaGrid, 4);
                    this.modeloGrid.setValueAt(Integer.valueOf(valor), this.filaGrid, 5);
                    this.modeloGrid.setValueAt(calcularEstado(this.txtEdad.getText(), valor), this.filaGrid, 6);
                    this.filaGrid++;
                }
            }
            this.rs.close();
            this.consultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(P_ValoracionResultado.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void crearGrid() {
        this.modeloGrid = new DefaultTableModel() { // from class: PyP.P_ValoracionResultado.7
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.modeloGrid.addColumn("Fecha");
        this.modeloGrid.addColumn("M. Gruesa");
        this.modeloGrid.addColumn("M. Fina");
        this.modeloGrid.addColumn("A. Lenguaje");
        this.modeloGrid.addColumn("P. Social");
        this.modeloGrid.addColumn("Valor");
        this.modeloGrid.addColumn("Estado");
        this.grid.setModel(this.modeloGrid);
    }

    private void graficar(int boton) {
        if (!this.idSexo.equals("F")) {
            switch (boton) {
                case 1:
                    graficarTallaEdadNinos05();
                    break;
            }
        }
    }

    private void graficarTallaEdadNinos05() {
        this.graficas = new Graficas();
        this.graficas.edadTallaNinos0_5(this.IdPaciente);
    }

    private void traerEdad() {
        this.sql = "SELECT FechaNac FROM baseserver.g_persona WHERE (Id ='" + this.IdPaciente + "')";
        String fechaNacimiento = this.consultas.traerDato(this.sql);
        if (fechaNacimiento.isEmpty()) {
            this.txtEdad.setText("0");
        } else {
            this.txtEdad.setText(this.metodos.entregarEdadEnMeses(fechaNacimiento));
        }
        this.consultas.cerrarConexionBd();
    }
}
