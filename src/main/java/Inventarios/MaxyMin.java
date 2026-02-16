package Inventarios;

import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Inventarios/MaxyMin.class */
public class MaxyMin extends JPanel {
    private Metodos metodos = new Metodos();
    private ConsultasMySQL consultas = new ConsultasMySQL();
    private Object[] dato;
    private int filaGrid;
    private String sql;
    private DefaultTableModel modelo;
    private String[] listaBodegas;
    private ButtonGroup GrupoUnidadEmpaque;
    private JButton btnGenerar;
    private JButton btnGrabar;
    private JButton btnSalir;
    private JComboBox cboBodegas;
    private JTable grid;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JScrollPane jScrollPane1;
    private JSeparator jSeparator1;
    private JSpinner txtDias;
    private JDateChooser txtFechaFin;
    private JDateChooser txtFechaIni;
    private JLabel txtTitulo;

    public MaxyMin() {
        initComponents();
        crearGrid();
        cargarCombos();
    }

    private void cargarCombos() {
        this.listaBodegas = this.consultas.llenarCombo("SELECT Id, Nbre FROM i_bodegas WHERE Estado=0 ORDER BY Nbre ASC", this.listaBodegas, this.cboBodegas);
        this.consultas.cerrarConexionBd();
    }

    private void crearGrid() {
        this.modelo = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Código Barra", "Producto", "salidas", "Mínimo", "Máximo", "P. Reposición"}) { // from class: Inventarios.MaxyMin.1
            Class[] types = {String.class, String.class, String.class, Double.class, Double.class, Double.class, Double.class};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.grid.setModel(this.modelo);
        this.grid.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.grid.getColumnModel().getColumn(1).setPreferredWidth(0);
        this.grid.getColumnModel().getColumn(2).setPreferredWidth(450);
        this.grid.getColumnModel().getColumn(3).setPreferredWidth(80);
        this.grid.getColumnModel().getColumn(4).setPreferredWidth(80);
        this.grid.getColumnModel().getColumn(5).setPreferredWidth(80);
        this.grid.getColumnModel().getColumn(6).setPreferredWidth(80);
        this.grid.getColumnModel().getColumn(0).setMinWidth(0);
        this.grid.getColumnModel().getColumn(0).setMaxWidth(0);
        this.grid.getColumnModel().getColumn(1).setMinWidth(0);
        this.grid.getColumnModel().getColumn(1).setMaxWidth(0);
        this.grid.getColumnModel().getColumn(2).setMinWidth(450);
        this.grid.getColumnModel().getColumn(2).setMaxWidth(450);
        this.grid.getColumnModel().getColumn(3).setMinWidth(80);
        this.grid.getColumnModel().getColumn(3).setMaxWidth(80);
        this.grid.getColumnModel().getColumn(4).setMinWidth(80);
        this.grid.getColumnModel().getColumn(4).setMaxWidth(80);
        this.grid.getColumnModel().getColumn(5).setMinWidth(80);
        this.grid.getColumnModel().getColumn(5).setMaxWidth(80);
        this.grid.getColumnModel().getColumn(6).setMinWidth(80);
        this.grid.getColumnModel().getColumn(6).setMaxWidth(80);
    }

    private void evaluar() {
        if (this.txtFechaIni.getDate() == null) {
            this.metodos.mostrarMensaje("Por favor seleccione una fecha Inicial");
            this.txtFechaIni.requestFocus();
        } else if (this.txtFechaFin.getDate() == null) {
            this.metodos.mostrarMensaje("Por favor seleccione una fecha Final");
            this.txtFechaFin.requestFocus();
        } else if (this.cboBodegas.getSelectedIndex() < 0) {
            this.metodos.mostrarMensaje("Por favor seleccione una Bodega, Stock o Centro de Costo");
            this.cboBodegas.requestFocus();
        } else {
            generar();
        }
    }

    private void generar() {
        crearGrid();
        long dias = ((this.txtFechaFin.getDate().getTime() - this.txtFechaIni.getDate().getTime()) / 86400000) + 1;
        this.sql = "SELECT i_suministro.Id, i_suministro.CodBarraUnidad, i_suministro.Nbre, i_presentacioncomercial.Nbre, i_laboratorio.Nbre, SUM(i_detallesalida.CantidadDespachada) FROM i_detallesalida INNER JOIN i_suministro ON (i_detallesalida.IdSuministro = i_suministro.Id) INNER JOIN i_presentacioncomercial ON (i_suministro.IdPresentacionComercial = i_presentacioncomercial.Id) INNER JOIN i_laboratorio ON (i_suministro.IdLaboratorio = i_laboratorio.Id) INNER JOIN i_salidas  ON (i_detallesalida.IdSalida = i_salidas.Id) WHERE (i_salidas.FechaSalida >'" + this.metodos.formatoAMDH24.format(this.txtFechaIni.getDate()) + "'  AND i_salidas.FechaSalida <'" + this.metodos.formatoAMDH24.format(this.txtFechaFin.getDate()) + "' AND i_salidas.Destino <>1 AND i_salidas.IdBodega ='" + this.listaBodegas[this.cboBodegas.getSelectedIndex()] + "') GROUP BY i_suministro.Id ORDER BY i_suministro.Nbre ASC";
        ResultSet rs = this.consultas.traerRs(this.sql);
        try {
            rs.last();
            if (rs.getRow() > 0) {
                this.filaGrid = 0;
                rs.beforeFirst();
                while (rs.next()) {
                    long minimo = (rs.getLong(6) / dias) * (dias + (Long.parseLong(this.txtDias.getValue().toString()) * 2));
                    if (minimo < 1) {
                        minimo = 1;
                    }
                    this.modelo.addRow(this.dato);
                    this.modelo.setValueAt(rs.getString(1), this.filaGrid, 0);
                    this.modelo.setValueAt(rs.getString(2), this.filaGrid, 1);
                    this.modelo.setValueAt(rs.getString(3) + " " + rs.getString(4) + " " + rs.getString(5), this.filaGrid, 2);
                    this.modelo.setValueAt(rs.getString(6), this.filaGrid, 3);
                    this.modelo.setValueAt(Long.valueOf(minimo), this.filaGrid, 4);
                    this.modelo.setValueAt(Long.valueOf(minimo * 2), this.filaGrid, 5);
                    this.modelo.setValueAt(Long.valueOf(minimo + (minimo / 2)), this.filaGrid, 6);
                    this.filaGrid++;
                }
            }
            rs.close();
            this.consultas.cerrarConexionBd();
        } catch (SQLException ex) {
            this.consultas.mostrarErrorSQL(ex);
        }
    }

    private void grabar() {
        if (this.metodos.getPregunta("Esta seguro de actualizar los Valores Mínimos y Máximos?") == 0) {
            int fila = 0;
            for (int i = 0; i < this.modelo.getRowCount(); i++) {
                this.sql = "UPDATE i_stock SET Minimo = '" + this.modelo.getValueAt(fila, 4) + "', Maximo ='" + this.modelo.getValueAt(fila, 5) + "', Reposicion ='" + this.modelo.getValueAt(fila, 6) + "' WHERE (Id_Bodega ='" + this.listaBodegas[this.cboBodegas.getSelectedIndex()] + "' AND Id_Suministro ='" + this.modelo.getValueAt(fila, 0) + "')";
                this.consultas.ejecutarSQL(this.sql);
                fila++;
            }
            this.metodos.mostrarMensaje("Valores Máximos y Mínimos actualizados para la Bodega " + this.cboBodegas.getSelectedItem());
            this.consultas.cerrarConexionBd();
        }
    }

    /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.GrupoUnidadEmpaque = new ButtonGroup();
        this.jPanel1 = new JPanel();
        this.jScrollPane1 = new JScrollPane();
        this.grid = new JTable();
        this.txtTitulo = new JLabel();
        this.jSeparator1 = new JSeparator();
        this.cboBodegas = new JComboBox();
        this.txtFechaFin = new JDateChooser();
        this.txtFechaIni = new JDateChooser();
        this.txtDias = new JSpinner();
        this.jPanel2 = new JPanel();
        this.btnGenerar = new JButton();
        this.btnGrabar = new JButton();
        this.btnSalir = new JButton();
        setName("FIMaxyMin");
        this.jPanel1.setBorder(BorderFactory.createEtchedBorder());
        this.jPanel1.setName("frmPanelATC");
        this.jPanel1.setLayout((LayoutManager) null);
        this.grid.setFont(new Font("Arial", 1, 12));
        this.grid.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.grid.setRowHeight(25);
        this.grid.setSelectionBackground(new Color(255, 255, 255));
        this.grid.setSelectionForeground(new Color(255, 0, 0));
        this.grid.setSelectionMode(0);
        this.jScrollPane1.setViewportView(this.grid);
        this.jPanel1.add(this.jScrollPane1);
        this.jScrollPane1.setBounds(20, 160, 800, 370);
        this.txtTitulo.setBackground((Color) null);
        this.txtTitulo.setFont(new Font("Arial", 1, 18));
        this.txtTitulo.setForeground(new Color(0, 102, 0));
        this.txtTitulo.setHorizontalAlignment(0);
        this.txtTitulo.setText("STOCK MAXIMO Y MINIMO");
        this.txtTitulo.setOpaque(true);
        this.jPanel1.add(this.txtTitulo);
        this.txtTitulo.setBounds(19, 20, 800, 40);
        this.jPanel1.add(this.jSeparator1);
        this.jSeparator1.setBounds(0, 0, 0, 2);
        this.cboBodegas.setFont(new Font("Arial", 1, 12));
        this.cboBodegas.setForeground(new Color(0, 0, 153));
        this.cboBodegas.setBorder(BorderFactory.createTitledBorder((Border) null, "Bodega, stock o centro de costos", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.jPanel1.add(this.cboBodegas);
        this.cboBodegas.setBounds(280, 100, 320, 50);
        this.txtFechaFin.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Final", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtFechaFin.setDateFormatString("dd/MM/yyyy");
        this.txtFechaFin.setFont(new Font("Arial", 1, 12));
        this.jPanel1.add(this.txtFechaFin);
        this.txtFechaFin.setBounds(150, 90, 120, 60);
        this.txtFechaIni.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicial", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtFechaIni.setDateFormatString("dd/MM/yyyy");
        this.txtFechaIni.setFont(new Font("Arial", 1, 12));
        this.jPanel1.add(this.txtFechaIni);
        this.txtFechaIni.setBounds(20, 90, 130, 60);
        this.txtDias.setFont(new Font("Arial", 1, 12));
        this.txtDias.setModel(new SpinnerNumberModel(1, 1, (Comparable) null, 1));
        this.txtDias.setBorder(BorderFactory.createTitledBorder((Border) null, "Días de entrega del proveedor", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.jPanel1.add(this.txtDias);
        this.txtDias.setBounds(620, 100, 200, 50);
        this.jPanel2.setBorder(BorderFactory.createEtchedBorder());
        this.jPanel2.setLayout((LayoutManager) null);
        this.btnGenerar.setFont(new Font("Arial", 1, 12));
        this.btnGenerar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Generar.png")));
        this.btnGenerar.setText("Generar");
        this.btnGenerar.addActionListener(new ActionListener() { // from class: Inventarios.MaxyMin.2
            public void actionPerformed(ActionEvent evt) {
                MaxyMin.this.btnGenerarActionPerformed(evt);
            }
        });
        this.jPanel2.add(this.btnGenerar);
        this.btnGenerar.setBounds(10, 10, 270, 40);
        this.btnGrabar.setFont(new Font("Arial", 1, 12));
        this.btnGrabar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Grabar29x27.png")));
        this.btnGrabar.setText("Grabar");
        this.btnGrabar.addActionListener(new ActionListener() { // from class: Inventarios.MaxyMin.3
            public void actionPerformed(ActionEvent evt) {
                MaxyMin.this.btnGrabarActionPerformed(evt);
            }
        });
        this.jPanel2.add(this.btnGrabar);
        this.btnGrabar.setBounds(290, 10, 280, 40);
        this.btnSalir.setFont(new Font("Arial", 1, 12));
        this.btnSalir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.btnSalir.setText("Salir");
        this.btnSalir.addActionListener(new ActionListener() { // from class: Inventarios.MaxyMin.4
            public void actionPerformed(ActionEvent evt) {
                MaxyMin.this.btnSalirActionPerformed(evt);
            }
        });
        this.jPanel2.add(this.btnSalir);
        this.btnSalir.setBounds(580, 10, 240, 40);
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.jPanel2, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.jPanel1, GroupLayout.Alignment.LEADING, -1, 830, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, 543, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jPanel2, -2, 61, -2).addContainerGap(-1, 32767)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnGenerarActionPerformed(ActionEvent evt) {
        evaluar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnGrabarActionPerformed(ActionEvent evt) {
        grabar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnSalirActionPerformed(ActionEvent evt) {
        System.exit(0);
    }
}
