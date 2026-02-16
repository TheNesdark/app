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
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:PyP/ValoracionResultado.class */
public class ValoracionResultado extends JPanel {
    private String sql;
    private String IdAtencion;
    private String idPaciente;
    private String sexo;
    public DefaultTableModel modeloGrid;
    private int edad;
    private Object[] dato;
    private Graficas graficas;
    private clasePyP clasepyp;
    private JButton btnImc05;
    private JButton btnImc519;
    private JButton btnPeso05;
    private JButton btnPeso510;
    private JButton btnTalla05;
    private JButton btnTalla519;
    private JTable grid;
    private JScrollPane jScrollPane1;
    private JPanel panelGrafico;
    private JPanel panelGrafico2;
    private Metodos metodos = new Metodos();
    private ConsultasMySQL consultas = new ConsultasMySQL();
    private int filaGrid = 0;

    public ValoracionResultado(clasePyP clase, String paciente, String Edad, String Sexo) {
        initComponents();
        this.clasepyp = clase;
        this.idPaciente = paciente;
        this.edad = Integer.parseInt(Edad.substring(0, 2));
        this.sexo = Sexo;
        crearGrid();
        cargarDatos();
        if (getEdad() < 60) {
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

    private String calcularEstado(String Edad, int valor) {
        String resultado = "Sin Dato";
        try {
            this.sql = "SELECT TotalBajaIni, TotalBajaFin, TotalMediaIni, TotalMediaFin, TotalAltaIni, TotalAltaFin, TotalMayor FROM baseserver.p_param_crec_desarrollo WHERE (EdadIni <= '" + Edad + "' AND EdadFin >= '" + Edad + "')";
            ResultSet rs1 = this.consultas.traerRs(this.sql);
            if (rs1.next()) {
                if (valor >= rs1.getInt(1) && valor <= rs1.getInt(2)) {
                    resultado = "ALERTA";
                } else if (valor >= rs1.getInt(3) && valor <= rs1.getInt(4)) {
                    resultado = "MEDIO";
                } else if (valor >= rs1.getInt(5) && valor <= rs1.getInt(6)) {
                    resultado = "ALTO";
                } else {
                    resultado = "MUY ALTO";
                }
                rs1.close();
                this.consultas.cerrarConexionBd();
            }
        } catch (SQLException ex) {
            this.consultas.mostrarErrorSQL(ex);
        }
        return resultado;
    }

    private void cargarDatos() {
        this.sql = "SELECT FechaAtencion, Motora, Adaptativa, Lenguaje, PersonalSocial FROM baseserver.p_atencioninfantilprescolar WHERE IdPersona ='" + this.idPaciente + "'";
        ResultSet rs = this.consultas.traerRs(this.sql);
        try {
            if (rs.next()) {
                rs.beforeFirst();
                this.filaGrid = 0;
                while (rs.next()) {
                    this.modeloGrid.addRow(this.dato);
                    int valor = rs.getInt(2) + rs.getInt(3) + rs.getInt(4) + rs.getInt(5);
                    this.modeloGrid.setValueAt(rs.getString(1), this.filaGrid, 0);
                    this.modeloGrid.setValueAt(rs.getString(2), this.filaGrid, 1);
                    this.modeloGrid.setValueAt(rs.getString(3), this.filaGrid, 2);
                    this.modeloGrid.setValueAt(rs.getString(4), this.filaGrid, 3);
                    this.modeloGrid.setValueAt(rs.getString(5), this.filaGrid, 4);
                    this.modeloGrid.setValueAt(Integer.valueOf(valor), this.filaGrid, 5);
                    this.modeloGrid.setValueAt(calcularEstado(String.valueOf(getEdad()), valor), this.filaGrid, 6);
                    this.filaGrid++;
                }
                rs.close();
                this.consultas.cerrarConexionBd();
            }
        } catch (SQLException ex) {
            this.consultas.mostrarErrorSQL(ex);
        }
    }

    private void crearGrid() {
        this.modeloGrid = new DefaultTableModel() { // from class: PyP.ValoracionResultado.1
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

    private int getEdad() {
        return this.edad;
    }

    public String getSexo() {
        return this.sexo;
    }

    private void graficar(int boton) {
        if (!getSexo().equals("F") && boton == 1) {
            graficarTallaEdadNinos05();
        }
    }

    private void graficarTallaEdadNinos05() {
        this.graficas = new Graficas();
        this.graficas.edadTallaNinos0_5(this.idPaciente);
    }

    /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jScrollPane1 = new JScrollPane();
        this.grid = new JTable();
        this.panelGrafico = new JPanel();
        this.panelGrafico2 = new JPanel();
        this.btnTalla05 = new JButton();
        this.btnPeso05 = new JButton();
        this.btnPeso510 = new JButton();
        this.btnImc05 = new JButton();
        this.btnTalla519 = new JButton();
        this.btnImc519 = new JButton();
        setName("ValoracionResultado");
        setLayout(null);
        this.grid.setFont(new Font("Arial", 1, 12));
        this.grid.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[]{"Title 1", "Title 2", "Title 3", "Title 4"}));
        this.grid.setRowHeight(25);
        this.grid.setSelectionBackground(new Color(255, 255, 255));
        this.grid.setSelectionForeground(new Color(255, 0, 0));
        this.grid.setSelectionMode(0);
        this.jScrollPane1.setViewportView(this.grid);
        add(this.jScrollPane1);
        this.jScrollPane1.setBounds(10, 10, 820, 210);
        this.panelGrafico.setBorder(BorderFactory.createEtchedBorder(0));
        this.panelGrafico.setLayout((LayoutManager) null);
        add(this.panelGrafico);
        this.panelGrafico.setBounds(10, 230, 820, 370);
        this.panelGrafico2.setBorder(BorderFactory.createTitledBorder((Border) null, "Generar Curvas Gráficas", 0, 0, new Font("Arial", 1, 12)));
        this.panelGrafico2.setLayout((LayoutManager) null);
        this.btnTalla05.setFont(new Font("Arial", 1, 12));
        this.btnTalla05.setText("Talla/Edad 0-5");
        this.btnTalla05.addActionListener(new ActionListener() { // from class: PyP.ValoracionResultado.2
            public void actionPerformed(ActionEvent evt) {
                ValoracionResultado.this.btnTalla05ActionPerformed(evt);
            }
        });
        this.panelGrafico2.add(this.btnTalla05);
        this.btnTalla05.setBounds(10, 20, 120, 40);
        this.btnPeso05.setFont(new Font("Arial", 1, 12));
        this.btnPeso05.setText("Peso/Edad 0-5");
        this.btnPeso05.addActionListener(new ActionListener() { // from class: PyP.ValoracionResultado.3
            public void actionPerformed(ActionEvent evt) {
                ValoracionResultado.this.btnPeso05ActionPerformed(evt);
            }
        });
        this.panelGrafico2.add(this.btnPeso05);
        this.btnPeso05.setBounds(290, 20, 120, 40);
        this.btnPeso510.setFont(new Font("Arial", 1, 12));
        this.btnPeso510.setText("Peso/Edad 5-10");
        this.btnPeso510.addActionListener(new ActionListener() { // from class: PyP.ValoracionResultado.4
            public void actionPerformed(ActionEvent evt) {
                ValoracionResultado.this.btnPeso510ActionPerformed(evt);
            }
        });
        this.panelGrafico2.add(this.btnPeso510);
        this.btnPeso510.setBounds(430, 20, 120, 40);
        this.btnImc05.setFont(new Font("Arial", 1, 12));
        this.btnImc05.setText("IMC 0-5");
        this.btnImc05.addActionListener(new ActionListener() { // from class: PyP.ValoracionResultado.5
            public void actionPerformed(ActionEvent evt) {
                ValoracionResultado.this.btnImc05ActionPerformed(evt);
            }
        });
        this.panelGrafico2.add(this.btnImc05);
        this.btnImc05.setBounds(570, 20, 120, 40);
        this.btnTalla519.setFont(new Font("Arial", 1, 12));
        this.btnTalla519.setText("Talla/Edad 5-19");
        this.btnTalla519.addActionListener(new ActionListener() { // from class: PyP.ValoracionResultado.6
            public void actionPerformed(ActionEvent evt) {
                ValoracionResultado.this.btnTalla519ActionPerformed(evt);
            }
        });
        this.panelGrafico2.add(this.btnTalla519);
        this.btnTalla519.setBounds(150, 20, 120, 40);
        this.btnImc519.setFont(new Font("Arial", 1, 12));
        this.btnImc519.setText("IMC 5-19");
        this.btnImc519.addActionListener(new ActionListener() { // from class: PyP.ValoracionResultado.7
            public void actionPerformed(ActionEvent evt) {
                ValoracionResultado.this.btnImc519ActionPerformed(evt);
            }
        });
        this.panelGrafico2.add(this.btnImc519);
        this.btnImc519.setBounds(700, 20, 120, 40);
        add(this.panelGrafico2);
        this.panelGrafico2.setBounds(10, 600, 830, 70);
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
}
