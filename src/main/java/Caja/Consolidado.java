package Caja;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Caja/Consolidado.class */
public class Consolidado extends JInternalFrame {
    private claseCaja clasecaja;
    private String sql;
    private ResultSet rs;
    private DefaultTableModel modelo;
    private JDateChooser JDCFechaFin;
    public JDateChooser JDCFechaInicio;
    private JScrollPane JSP_Detalle;
    private JTable grid;
    private JFormattedTextField txtNoConsol;
    private JFormattedTextField txtValorConsol;
    private ConsultasMySQL consultas = new ConsultasMySQL();
    private Metodos metodos = new Metodos();
    private Object[] datos = {"", "", "", "", new Double(0.0d), "", new Boolean(false)};
    private int filaGrid = 0;
    private long VrConsolidado = 0;

    public Consolidado(claseCaja xclasecaja) {
        initComponents();
        this.clasecaja = xclasecaja;
        nuevo();
    }

    public void cargarGrid() {
        try {
            crearGrid();
            this.sql = "SELECT k_cierre.Id , k_caja.Nbre AS Caja, DATE_FORMAT(k_cierre.FechaInicio, '%d/%m/%Y %h:%i:%s %p') AS FechaI , DATE_FORMAT(k_cierre.FechaFinal, '%d/%m/%Y %h:%i:%s %p') AS FechaF , k_cierre.Valor, w_persona.NUsuario AS Cajero FROM k_cierre INNER JOIN k_caja ON (k_cierre.Estado=1 and k_cierre.Id_Caja = k_caja.Id) INNER JOIN w_persona ON (k_cierre.Id_Usuario = w_persona.Id_persona) WHERE (k_cierre.IdConsolidado =0 and NOT(k_cierre.FechaFinal IS NULL) and  DATE_FORMAT(k_cierre.FechaInicio, '%Y-%m-%d')>='" + this.metodos.formatoAMD1.format(this.JDCFechaInicio.getDate()) + "' and  DATE_FORMAT(k_cierre.FechaFinal, '%Y-%m-%d')<='" + this.metodos.formatoAMD1.format(this.JDCFechaFin.getDate()) + "')";
            System.err.println(this.sql);
            this.rs = this.consultas.traerRs(this.sql);
            if (this.rs.next()) {
                this.rs.beforeFirst();
                while (this.rs.next()) {
                    this.modelo.addRow(this.datos);
                    this.modelo.setValueAt(this.rs.getString(1), this.filaGrid, 0);
                    this.modelo.setValueAt(this.rs.getString(2), this.filaGrid, 1);
                    this.modelo.setValueAt(this.rs.getString(3), this.filaGrid, 2);
                    this.modelo.setValueAt(this.rs.getString(4), this.filaGrid, 3);
                    this.modelo.setValueAt(Long.valueOf(this.rs.getLong(5)), this.filaGrid, 4);
                    this.modelo.setValueAt(this.rs.getString(6), this.filaGrid, 5);
                    this.modelo.setValueAt(new Boolean(true), this.filaGrid, 6);
                    this.filaGrid++;
                }
            }
            this.rs.close();
            this.consultas.cerrarConexionBd();
        } catch (SQLException ex) {
            this.consultas.mostrarErrorSQL(ex);
        }
    }

    public void anular() {
        this.metodos.mostrarMensaje("Esta opción no esta permitida en esta Pantalla");
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearGrid() {
        this.modelo = new DefaultTableModel(new Object[0], new String[]{"No Cierre", "Caja", "Fecha Inicial", "Fecha Final", "Valor", "Cajero", "Agregar"}) { // from class: Caja.Consolidado.1
            Class[] types = {String.class, String.class, String.class, String.class, Double.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, false, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.grid.setModel(this.modelo);
        this.grid.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.grid.getColumnModel().getColumn(1).setPreferredWidth(150);
        this.grid.getColumnModel().getColumn(2).setPreferredWidth(70);
        this.grid.getColumnModel().getColumn(3).setPreferredWidth(70);
        this.grid.getColumnModel().getColumn(4).setPreferredWidth(50);
        this.grid.getColumnModel().getColumn(5).setPreferredWidth(150);
        this.grid.getColumnModel().getColumn(6).setPreferredWidth(10);
        this.filaGrid = 0;
    }

    public void buscar() {
        Object[] botones = {"Cierre", "Consolidado", "Cerrar"};
        int n = JOptionPane.showInternalOptionDialog(this, "Que información desea cargar?", "CARGAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones, "Cerrar");
        if (n == 0) {
            cargarGrid();
            sumar_Restar();
        } else if (n == 1) {
            BusqCons dialog = new BusqCons(new JFrame(), false, this, this.clasecaja);
            dialog.setVisible(true);
        }
    }

    public void grabar() {
        int retorno = 0;
        if (this.modelo.getRowCount() > 0) {
            for (int i = 0; i < this.modelo.getRowCount(); i++) {
                if (this.grid.getValueAt(i, 6).toString().equals("true")) {
                    retorno = 1;
                }
            }
            if (retorno == 1) {
                this.sql = "INSERT INTO k_consolidado (FechaConsolidado, Valor, Fecha, UsuarioS ) values('" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "'," + this.txtValorConsol.getValue() + ",'" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                this.txtNoConsol.setText(this.consultas.ejecutarSQLId(this.sql));
                this.consultas.cerrarConexionBd();
                for (int i2 = 0; i2 < this.modelo.getRowCount(); i2++) {
                    if (this.grid.getValueAt(i2, 6).toString().equals("true")) {
                        this.sql = "INSERT INTO k_itemconsolidado (Id_Consolidado,Id_Cierre) values (" + this.txtNoConsol.getText() + "," + this.grid.getValueAt(i2, 0).toString() + ")";
                        this.consultas.ejecutarSQL(this.sql);
                        this.consultas.cerrarConexionBd();
                        this.sql = "UPDATE k_cierre SET IdConsolidado=" + this.txtNoConsol.getText() + " where Id=" + this.grid.getValueAt(i2, 0).toString();
                        this.consultas.ejecutarSQL(this.sql);
                        this.consultas.cerrarConexionBd();
                    }
                }
                this.clasecaja.imprimirConsolidado(this.txtNoConsol.getText());
            }
        }
    }

    public void nuevo() {
        this.JDCFechaInicio.setDate(this.metodos.getFechaActual());
        this.JDCFechaFin.setDate(this.metodos.getFechaActual());
        this.txtNoConsol.setValue(0);
        this.txtNoConsol.setText("");
        this.txtValorConsol.setValue(0);
        crearGrid();
        cargarGrid();
        sumar_Restar();
    }

    private void sumar_Restar() {
        this.VrConsolidado = 0L;
        for (int i = 0; i < this.modelo.getRowCount(); i++) {
            if (this.grid.getValueAt(i, 6).toString().equals("true")) {
                this.VrConsolidado += Long.parseLong(this.grid.getValueAt(i, 4).toString());
            }
            this.txtValorConsol.setValue(Long.valueOf(this.VrConsolidado));
        }
    }

    /* JADX WARN: Type inference failed for: r4v6, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JSP_Detalle = new JScrollPane();
        this.grid = new JTable();
        this.txtNoConsol = new JFormattedTextField();
        this.txtValorConsol = new JFormattedTextField();
        this.JDCFechaInicio = new JDateChooser();
        this.JDCFechaFin = new JDateChooser();
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("CONSOLIDADO CIERRE DE CAJA");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMaximumSize(new Dimension(1126, 484));
        setMinimumSize(new Dimension(1126, 484));
        setName("Consolidado");
        this.JSP_Detalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.grid.setFont(new Font("Arial", 1, 12));
        this.grid.setModel(new DefaultTableModel(new Object[0], new String[]{"No Cierre", "Caja", "Fecha Inicial", "Fecha Final", "Valor", "Cajero", "Agregar"}) { // from class: Caja.Consolidado.2
            Class[] types = {String.class, String.class, String.class, String.class, Long.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, false, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        });
        this.grid.setRowHeight(25);
        this.grid.setSelectionBackground(new Color(255, 255, 255));
        this.grid.setSelectionForeground(new Color(255, 0, 0));
        this.grid.setSelectionMode(0);
        this.grid.getTableHeader().setReorderingAllowed(false);
        this.grid.addMouseListener(new MouseAdapter() { // from class: Caja.Consolidado.3
            public void mouseClicked(MouseEvent evt) {
                Consolidado.this.gridMouseClicked(evt);
            }
        });
        this.JSP_Detalle.setViewportView(this.grid);
        if (this.grid.getColumnModel().getColumnCount() > 0) {
            this.grid.getColumnModel().getColumn(0).setResizable(false);
        }
        this.txtNoConsol.setBackground(new Color(204, 255, 204));
        this.txtNoConsol.setBorder(BorderFactory.createTitledBorder((Border) null, "Nº Consolidado", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtNoConsol.setHorizontalAlignment(4);
        this.txtNoConsol.setDisabledTextColor(new Color(0, 0, 102));
        this.txtNoConsol.setEnabled(false);
        this.txtNoConsol.setFont(new Font("Arial", 1, 24));
        this.txtValorConsol.setBackground(new Color(204, 255, 204));
        this.txtValorConsol.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor Total", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtValorConsol.setHorizontalAlignment(4);
        this.txtValorConsol.setText("0");
        this.txtValorConsol.setDisabledTextColor(new Color(0, 0, 102));
        this.txtValorConsol.setEnabled(false);
        this.txtValorConsol.setFont(new Font("Arial", 1, 24));
        this.txtValorConsol.setValue(0);
        this.JDCFechaInicio.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicio", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaInicio.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaInicio.setFont(new Font("Arial", 1, 12));
        this.JDCFechaFin.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Fin", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaFin.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaFin.setFont(new Font("Arial", 1, 12));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addGroup(layout.createSequentialGroup().addGap(6, 6, 6).addComponent(this.JSP_Detalle, -2, 1072, -2)).addGroup(layout.createSequentialGroup().addGap(17, 17, 17).addComponent(this.JDCFechaInicio, -2, 150, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JDCFechaFin, -2, 150, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.txtNoConsol, -2, 158, -2).addGap(18, 18, 18).addComponent(this.txtValorConsol, -2, 176, -2))).addGap(14, 14, 14)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(20, 20, 20).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.txtValorConsol, -2, 60, -2).addComponent(this.txtNoConsol, -2, 60, -2)).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDCFechaInicio, -2, 50, -2).addComponent(this.JDCFechaFin, -2, 50, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 48, 32767).addComponent(this.JSP_Detalle, -2, 310, -2)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gridMouseClicked(MouseEvent evt) {
        sumar_Restar();
    }

    public void mImprimir() {
        if (this.grid.getRowCount() != -1) {
            this.clasecaja.imprimirConsolidadoG(this.metodos.formatoAMD1.format(this.JDCFechaInicio.getDate()), this.metodos.formatoAMD1.format(this.JDCFechaFin.getDate()));
        }
    }
}
