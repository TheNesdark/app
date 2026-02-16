package Caja;

import Utilidades.ConsultasMySQL;
import Utilidades.JTextFieldValidator;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Caja/BusqCons.class */
public class BusqCons extends JDialog {
    private Metodos metodos;
    private ConsultasMySQL consultas;
    private int filaGrid;
    private String sql;
    private DefaultTableModel modelo;
    private DefaultTableModel modcombos;
    private claseCaja clasecaja;
    private Consolidado consolidado;
    private JButton btnBuscar;
    private JButton btnImprimir;
    private JButton btnLimpiar;
    private JButton btnSalir;
    private JTable grid;
    private JPanel jPanel3;
    private JScrollPane jScrollPane1;
    private JTextFieldValidator txtCons;
    private JDateChooser txtFechaFin;
    private JDateChooser txtFechaIni;

    public BusqCons(Frame parent, boolean modal, Consolidado jifrm, claseCaja Clasecaja) {
        super(parent, modal);
        this.metodos = new Metodos();
        this.consultas = new ConsultasMySQL();
        this.filaGrid = 0;
        initComponents();
        this.clasecaja = Clasecaja;
        this.consolidado = jifrm;
        setLocationRelativeTo(this);
        this.grid.addMouseListener(new MouseAdapter() { // from class: Caja.BusqCons.1
            public void mouseClicked(MouseEvent e) {
                BusqCons.this.filaGrid = BusqCons.this.grid.rowAtPoint(e.getPoint());
            }
        });
        limpiar();
    }

    private void buscarConsolidado() {
        if (validarCampos() == 1) {
            this.sql = "SELECT Id, FechaConsolidado, Valor FROM k_consolidado WHERE (";
            if (this.txtFechaIni.getDate() != null) {
                this.sql += "DATE_FORMAT(FechaConsolidado, '%Y-%m-%d')>='" + this.metodos.formatoAMDG.format(this.txtFechaIni.getDate()) + "'  AND ";
            }
            if (this.txtFechaFin.getDate() != null) {
                this.sql += "DATE_FORMAT(FechaConsolidado, '%Y-%m-%d')<='" + this.metodos.formatoAMDG.format(this.txtFechaFin.getDate()) + "'  AND ";
            }
            if (!this.txtCons.getText().equals("0")) {
                this.sql += "Id=" + this.txtCons.getText() + " AND ";
            }
            this.sql += "Id>0 ) ORDER BY FechaConsolidado ASC ";
            this.consultas.llenarTabla(this.sql, this.grid, this.modelo);
            crearGrid();
            if (this.grid.getRowCount() == 0) {
                this.metodos.mostrarMensaje("No se encontró el Consolidado solicitado");
            }
        }
        this.consultas.cerrarConexionBd();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    public void borrarFilas() {
        this.modelo = new DefaultTableModel(new Object[0], new String[]{"No Consolidado", "Fecha", "Valor"}) { // from class: Caja.BusqCons.2
            Class[] types = {String.class, String.class, Double.class};
            boolean[] canEdit = {false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.grid.setModel(this.modelo);
    }

    public void crearGrid() {
        this.grid.getColumnModel().getColumn(0).setPreferredWidth(30);
        this.grid.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(2).setPreferredWidth(100);
    }

    private void limpiar() {
        this.txtCons.setText("0");
        this.txtFechaIni.setDate((Date) null);
        this.txtFechaFin.setDate((Date) null);
        borrarFilas();
        crearGrid();
    }

    private int validarCampos() {
        int retorno = 0;
        if (this.txtFechaIni.getDate() == null && this.txtFechaFin.getDate() == null && this.txtCons.getText().equals("0")) {
            this.metodos.mostrarMensaje("Por favor seleccione un Criterio de Busqueda");
        } else {
            retorno = 1;
        }
        return retorno;
    }

    /* JADX WARN: Type inference failed for: r3v39, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jPanel3 = new JPanel();
        this.btnBuscar = new JButton();
        this.txtFechaIni = new JDateChooser();
        this.txtFechaFin = new JDateChooser();
        this.txtCons = new JTextFieldValidator();
        this.jScrollPane1 = new JScrollPane();
        this.grid = new JTable();
        this.btnLimpiar = new JButton();
        this.btnSalir = new JButton();
        this.btnImprimir = new JButton();
        setDefaultCloseOperation(2);
        setTitle("Busqueda de Recibos");
        this.jPanel3.setBorder(BorderFactory.createTitledBorder((Border) null, "CRITERIOS DE BÚSQUEDA", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.btnBuscar.setFont(new Font("Arial", 1, 12));
        this.btnBuscar.setForeground(new Color(0, 51, 51));
        this.btnBuscar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Buscar.png")));
        this.btnBuscar.setText("Buscar");
        this.btnBuscar.addActionListener(new ActionListener() { // from class: Caja.BusqCons.3
            public void actionPerformed(ActionEvent evt) {
                BusqCons.this.btnBuscarActionPerformed(evt);
            }
        });
        this.txtFechaIni.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicial", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtFechaIni.setFont(new Font("Arial", 1, 12));
        this.txtFechaIni.addPropertyChangeListener(new PropertyChangeListener() { // from class: Caja.BusqCons.4
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                BusqCons.this.txtFechaIniPropertyChange(evt);
            }
        });
        this.txtFechaIni.addAncestorListener(new AncestorListener() { // from class: Caja.BusqCons.5
            public void ancestorMoved(AncestorEvent evt) {
            }

            public void ancestorAdded(AncestorEvent evt) {
                BusqCons.this.txtFechaIniAncestorAdded(evt);
            }

            public void ancestorRemoved(AncestorEvent evt) {
            }
        });
        this.txtFechaIni.addVetoableChangeListener(new VetoableChangeListener() { // from class: Caja.BusqCons.6
            /* JADX INFO: Thrown type has an unknown type hierarchy: java.beans.PropertyVetoException */
            public void vetoableChange(PropertyChangeEvent evt) throws PropertyVetoException {
                BusqCons.this.txtFechaIniVetoableChange(evt);
            }
        });
        this.txtFechaFin.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Final", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtFechaFin.setFont(new Font("Arial", 1, 12));
        this.txtFechaFin.addPropertyChangeListener(new PropertyChangeListener() { // from class: Caja.BusqCons.7
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                BusqCons.this.txtFechaFinPropertyChange(evt);
            }
        });
        this.txtFechaFin.addAncestorListener(new AncestorListener() { // from class: Caja.BusqCons.8
            public void ancestorMoved(AncestorEvent evt) {
            }

            public void ancestorAdded(AncestorEvent evt) {
                BusqCons.this.txtFechaFinAncestorAdded(evt);
            }

            public void ancestorRemoved(AncestorEvent evt) {
            }
        });
        this.txtFechaFin.addVetoableChangeListener(new VetoableChangeListener() { // from class: Caja.BusqCons.9
            /* JADX INFO: Thrown type has an unknown type hierarchy: java.beans.PropertyVetoException */
            public void vetoableChange(PropertyChangeEvent evt) throws PropertyVetoException {
                BusqCons.this.txtFechaFinVetoableChange(evt);
            }
        });
        this.txtCons.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Consolidado", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtCons.setHorizontalAlignment(4);
        this.txtCons.setText("0");
        this.txtCons.setFont(new Font("Arial", 1, 12));
        GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
        this.jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup().addContainerGap().addComponent(this.txtCons, -2, 130, -2).addGap(18, 18, 18).addComponent(this.txtFechaIni, -2, 130, -2).addGap(18, 18, 18).addComponent(this.txtFechaFin, -2, 130, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.btnBuscar, -1, 328, 32767).addContainerGap()));
        jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.btnBuscar, -2, 50, -2).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.txtFechaIni, -2, 50, -2).addComponent(this.txtFechaFin, -2, 50, -2)).addComponent(this.txtCons, -2, -1, -2)).addContainerGap(14, 32767)));
        this.jScrollPane1.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.grid.setFont(new Font("Arial", 1, 12));
        this.grid.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.grid.setRowHeight(25);
        this.grid.setSelectionBackground(new Color(255, 255, 255));
        this.grid.setSelectionForeground(new Color(255, 0, 0));
        this.grid.setSelectionMode(0);
        this.jScrollPane1.setViewportView(this.grid);
        this.btnLimpiar.setFont(new Font("Arial", 1, 12));
        this.btnLimpiar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Limpiar.png")));
        this.btnLimpiar.setText("Limpiar");
        this.btnLimpiar.addActionListener(new ActionListener() { // from class: Caja.BusqCons.10
            public void actionPerformed(ActionEvent evt) {
                BusqCons.this.btnLimpiarActionPerformed(evt);
            }
        });
        this.btnSalir.setFont(new Font("Arial", 1, 12));
        this.btnSalir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.btnSalir.setText("Salir");
        this.btnSalir.addActionListener(new ActionListener() { // from class: Caja.BusqCons.11
            public void actionPerformed(ActionEvent evt) {
                BusqCons.this.btnSalirActionPerformed(evt);
            }
        });
        this.btnImprimir.setFont(new Font("Arial", 1, 12));
        this.btnImprimir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Imprimir.png")));
        this.btnImprimir.setText("Imprimir Consolidado");
        this.btnImprimir.addActionListener(new ActionListener() { // from class: Caja.BusqCons.12
            public void actionPerformed(ActionEvent evt) {
                BusqCons.this.btnImprimirActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(20, 20, 20).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel3, -2, -1, -2).addComponent(this.jScrollPane1, -2, 800, -2).addGroup(layout.createSequentialGroup().addComponent(this.btnLimpiar, -2, 255, -2).addGap(20, 20, 20).addComponent(this.btnImprimir, -2, 255, -2).addGap(10, 10, 10).addComponent(this.btnSalir, -2, 255, -2)))));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(20, 20, 20).addComponent(this.jPanel3, -2, -1, -2).addGap(10, 10, 10).addComponent(this.jScrollPane1, -2, 190, -2).addGap(10, 10, 10).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.btnLimpiar, -2, 50, -2).addComponent(this.btnImprimir, -2, 50, -2).addComponent(this.btnSalir, -2, 50, -2))));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtFechaIniPropertyChange(PropertyChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtFechaIniVetoableChange(PropertyChangeEvent evt) throws PropertyVetoException {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtFechaFinPropertyChange(PropertyChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtFechaFinVetoableChange(PropertyChangeEvent evt) throws PropertyVetoException {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnBuscarActionPerformed(ActionEvent evt) {
        buscarConsolidado();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnLimpiarActionPerformed(ActionEvent evt) {
        limpiar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnSalirActionPerformed(ActionEvent evt) {
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtFechaIniAncestorAdded(AncestorEvent evt) {
        this.txtFechaFin.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtFechaFinAncestorAdded(AncestorEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnImprimirActionPerformed(ActionEvent evt) {
        if (this.grid.getRowCount() > 0) {
            String idConsolidado = this.grid.getModel().getValueAt(this.filaGrid, 0).toString();
            this.clasecaja.imprimirConsolidado(idConsolidado);
        }
    }
}
