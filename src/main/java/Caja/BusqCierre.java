package Caja;

import Utilidades.ConsultasMySQL;
import Utilidades.JTextFieldValidator;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
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
import org.jdesktop.jdnc.incubator.jxcombobox.IncompatibleLookAndFeelException;
import org.jdesktop.jdnc.incubator.jxcombobox.JTableComboBox;

/* JADX INFO: loaded from: GenomaP.jar:Caja/BusqCierre.class */
public class BusqCierre extends JDialog {
    private Metodos metodos;
    private ConsultasMySQL consultas;
    private int filaGrid;
    private String sql;
    private DefaultTableModel modelo;
    private DefaultTableModel modcombos;
    private claseCaja clasecaja;
    private Cierre cierre;
    private JButton btnBuscar;
    private JButton btnImprimir;
    private JButton btnLimpiar;
    private JButton btnSalir;
    private JTableComboBox cboCaja;
    private JTableComboBox cboCajero;
    private JTable grid;
    private JPanel jPanel3;
    private JScrollPane jScrollPane1;
    private JTextFieldValidator txtCierre;
    private JDateChooser txtFechaFin;
    private JDateChooser txtFechaIni;

    public BusqCierre(Frame parent, boolean modal, Cierre jifrm, claseCaja Clasecaja) {
        super(parent, modal);
        this.metodos = new Metodos();
        this.consultas = new ConsultasMySQL();
        this.filaGrid = 0;
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        this.clasecaja = Clasecaja;
        this.cierre = jifrm;
        setLocationRelativeTo(this);
        cargarCombos();
        this.grid.addMouseListener(new MouseAdapter() { // from class: Caja.BusqCierre.1
            public void mouseClicked(MouseEvent e) {
                BusqCierre.this.filaGrid = BusqCierre.this.grid.rowAtPoint(e.getPoint());
            }
        });
        limpiar();
    }

    private void buscarCierre() {
        if (validarCampos() == 1) {
            this.sql = "SELECT k_cierre.Id AS No_Cierre, k_cierre.FechaInicio AS Fecha_Inicio, k_cierre.FechaFinal AS Fecha_Final, k_cierre.Valor AS Valor, k_caja.Nbre AS Caja, w_persona.NUsuario AS Cajero FROM k_cierre INNER JOIN k_caja ON (k_cierre.Id_Caja = k_caja.Id) INNER JOIN g_usuariosxcajac ON (k_cierre.Id_Usuario = g_usuariosxcajac.Id_Persona) AND (g_usuariosxcajac.Id_Caja = k_caja.Id) INNER JOIN g_usuario_sist ON (g_usuariosxcajac.Id_Persona = g_usuario_sist.Id_Persona) INNER JOIN w_persona ON (g_usuario_sist.Id_Persona = w_persona.Id_persona) WHERE (";
            if (this.cboCaja.getSelectedIndex() >= 0) {
                this.sql += "k_cierre.Id_Caja=" + this.cboCaja.getPopupTable().getValueAt(this.cboCaja.getSelectedIndex(), 0) + " AND ";
            }
            if (this.cboCajero.getSelectedIndex() >= 0) {
                this.sql += "k_cierre.UsuarioS='" + this.cboCajero.getPopupTable().getValueAt(this.cboCajero.getSelectedIndex(), 2) + "' AND ";
            }
            if (this.txtFechaIni.getDate() != null) {
                this.sql += "DATE_FORMAT(k_cierre.FechaInicio, '%Y-%m-%d')>='" + this.metodos.formatoAMDG.format(this.txtFechaIni.getDate()) + "'  AND ";
            }
            if (this.txtFechaFin.getDate() != null) {
                this.sql += "DATE_FORMAT(k_cierre.FechaInicio, '%Y-%m-%d')<='" + this.metodos.formatoAMDG.format(this.txtFechaFin.getDate()) + "'  AND ";
            }
            this.sql += "NOT(k_cierre.FechaFinal IS NULL)) ORDER BY Fecha_Inicio ASC,No_Cierre ASC ";
            this.consultas.llenarTabla(this.sql, this.grid, this.modelo);
            crearGrid();
            if (this.grid.getRowCount() == 0) {
                this.metodos.mostrarMensaje("No se encontró el Cierre solicitado");
            }
        }
        this.consultas.cerrarConexionBd();
    }

    public void borrarFilas() {
        this.modelo = new DefaultTableModel() { // from class: Caja.BusqCierre.2
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.modelo.addColumn("No Cierre");
        this.modelo.addColumn("Fecha Inicial");
        this.modelo.addColumn("Fecha Final");
        this.modelo.addColumn("Valor");
        this.modelo.addColumn("Caja");
        this.modelo.addColumn("Cajero");
        this.grid.setModel(this.modelo);
    }

    public void cargarCombos() {
        this.consultas.llenarComboTabla("SELECT Id , Nbre AS  Cajas FROM k_caja WHERE Estado=1 ORDER BY Nbre ASC", this.cboCaja, this.modcombos, 1);
        this.sql = "SELECT  g_usuariosxcajac.Id_Persona AS Id, w_persona.NUsuario AS Cajero ,g_usuario_sist.Login AS Usuario FROM g_usuariosxcajac INNER JOIN w_persona ON (g_usuariosxcajac.Id_Persona = w_persona.Id_persona) INNER JOIN g_usuario_sist ON (g_usuario_sist.Id_Persona=g_usuariosxcajac.Id_Persona) GROUP BY g_usuariosxcajac.Id_Persona, w_persona.NUsuario ORDER BY w_persona.NUsuario ASC";
        this.consultas.llenarComboTabla(this.sql, this.cboCajero, this.modcombos, 1);
        this.consultas.cerrarConexionBd();
    }

    public void crearGrid() {
        this.grid.getColumnModel().getColumn(0).setPreferredWidth(30);
        this.grid.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(3).setPreferredWidth(50);
        this.grid.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(5).setPreferredWidth(120);
    }

    private void limpiar() {
        this.txtCierre.setText("0");
        this.txtFechaIni.setDate((Date) null);
        this.txtFechaFin.setDate((Date) null);
        cargarCombos();
        borrarFilas();
        crearGrid();
    }

    private int validarCampos() {
        int retorno = 0;
        if (this.cboCaja.getSelectedIndex() < 0 && this.cboCajero.getSelectedIndex() < 0 && this.txtFechaIni.getDate() == null && this.txtFechaFin.getDate() == null) {
            this.metodos.mostrarMensaje("Por favor seleccione un Criterio de Busqueda");
        } else {
            retorno = 1;
        }
        return retorno;
    }

    /* JADX WARN: Type inference failed for: r3v38, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jPanel3 = new JPanel();
        this.btnBuscar = new JButton();
        try {
            this.cboCajero = new JTableComboBox();
        } catch (IncompatibleLookAndFeelException e1) {
            e1.printStackTrace();
        }
        try {
            this.cboCaja = new JTableComboBox();
        } catch (IncompatibleLookAndFeelException e12) {
            e12.printStackTrace();
        }
        this.txtFechaIni = new JDateChooser();
        this.txtFechaFin = new JDateChooser();
        this.txtCierre = new JTextFieldValidator();
        this.jScrollPane1 = new JScrollPane();
        this.grid = new JTable();
        this.btnLimpiar = new JButton();
        this.btnSalir = new JButton();
        this.btnImprimir = new JButton();
        setDefaultCloseOperation(2);
        setTitle("Busqueda de Recibos");
        this.jPanel3.setBorder(BorderFactory.createTitledBorder((Border) null, "CRITERIOS DE BÚSQUEDA", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.btnBuscar.setFont(new Font("Arial", 1, 12));
        this.btnBuscar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Buscar.png")));
        this.btnBuscar.setText("Buscar");
        this.btnBuscar.addActionListener(new ActionListener() { // from class: Caja.BusqCierre.3
            public void actionPerformed(ActionEvent evt) {
                BusqCierre.this.btnBuscarActionPerformed(evt);
            }
        });
        this.cboCajero.setBorder(BorderFactory.createTitledBorder((Border) null, "Cajero", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.cboCajero.setFont(new Font("Arial", 1, 12));
        this.cboCaja.setBorder(BorderFactory.createTitledBorder((Border) null, "Caja", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.cboCaja.setFont(new Font("Arial", 1, 12));
        this.cboCaja.addActionListener(new ActionListener() { // from class: Caja.BusqCierre.4
            public void actionPerformed(ActionEvent evt) {
                BusqCierre.this.cboCajaActionPerformed(evt);
            }
        });
        this.txtFechaIni.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicial", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtFechaIni.setFont(new Font("Arial", 1, 12));
        this.txtFechaIni.addPropertyChangeListener(new PropertyChangeListener() { // from class: Caja.BusqCierre.5
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                BusqCierre.this.txtFechaIniPropertyChange(evt);
            }
        });
        this.txtFechaIni.addAncestorListener(new AncestorListener() { // from class: Caja.BusqCierre.6
            public void ancestorMoved(AncestorEvent evt) {
            }

            public void ancestorAdded(AncestorEvent evt) {
                BusqCierre.this.txtFechaIniAncestorAdded(evt);
            }

            public void ancestorRemoved(AncestorEvent evt) {
            }
        });
        this.txtFechaIni.addVetoableChangeListener(new VetoableChangeListener() { // from class: Caja.BusqCierre.7
            /* JADX INFO: Thrown type has an unknown type hierarchy: java.beans.PropertyVetoException */
            public void vetoableChange(PropertyChangeEvent evt) throws PropertyVetoException {
                BusqCierre.this.txtFechaIniVetoableChange(evt);
            }
        });
        this.txtFechaFin.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Final", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtFechaFin.setFont(new Font("Arial", 1, 12));
        this.txtFechaFin.addPropertyChangeListener(new PropertyChangeListener() { // from class: Caja.BusqCierre.8
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                BusqCierre.this.txtFechaFinPropertyChange(evt);
            }
        });
        this.txtFechaFin.addAncestorListener(new AncestorListener() { // from class: Caja.BusqCierre.9
            public void ancestorMoved(AncestorEvent evt) {
            }

            public void ancestorAdded(AncestorEvent evt) {
                BusqCierre.this.txtFechaFinAncestorAdded(evt);
            }

            public void ancestorRemoved(AncestorEvent evt) {
            }
        });
        this.txtFechaFin.addVetoableChangeListener(new VetoableChangeListener() { // from class: Caja.BusqCierre.10
            /* JADX INFO: Thrown type has an unknown type hierarchy: java.beans.PropertyVetoException */
            public void vetoableChange(PropertyChangeEvent evt) throws PropertyVetoException {
                BusqCierre.this.txtFechaFinVetoableChange(evt);
            }
        });
        this.txtCierre.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Cierre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtCierre.setHorizontalAlignment(4);
        this.txtCierre.setText("0");
        this.txtCierre.setFont(new Font("Arial", 1, 12));
        GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
        this.jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup().addContainerGap(12, 32767).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addComponent(this.txtCierre, -2, 150, -2).addGap(18, 18, 18).addComponent(this.txtFechaIni, -2, 130, -2).addGap(28, 28, 28).addComponent(this.txtFechaFin, -2, 130, -2)).addGroup(jPanel3Layout.createSequentialGroup().addComponent(this.cboCaja, -2, 252, -2).addGap(18, 18, 18).addComponent(this.cboCajero, -2, 342, -2))).addGap(10, 10, 10).addComponent(this.btnBuscar, -2, 140, -2).addContainerGap()));
        jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.btnBuscar, -1, -1, 32767).addGroup(GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup().addGap(5, 5, 5).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.txtCierre, -2, 50, -2).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.txtFechaFin, -2, 50, -2).addComponent(this.txtFechaIni, -2, 50, -2))).addGap(20, 20, 20).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.cboCajero, -2, 50, -2).addComponent(this.cboCaja, -2, 50, -2)))).addContainerGap(-1, 32767)));
        this.txtFechaIni.getAccessibleContext().setAccessibleName("200");
        this.txtFechaFin.getAccessibleContext().setAccessibleName("200");
        this.jScrollPane1.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.grid.setFont(new Font("Arial", 1, 12));
        this.grid.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.grid.setRowHeight(25);
        this.grid.setSelectionBackground(new Color(255, 255, 255));
        this.grid.setSelectionForeground(Color.red);
        this.grid.setSelectionMode(0);
        this.jScrollPane1.setViewportView(this.grid);
        this.btnLimpiar.setFont(new Font("Arial", 1, 12));
        this.btnLimpiar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Limpiar.png")));
        this.btnLimpiar.setText("Limpiar");
        this.btnLimpiar.addActionListener(new ActionListener() { // from class: Caja.BusqCierre.11
            public void actionPerformed(ActionEvent evt) {
                BusqCierre.this.btnLimpiarActionPerformed(evt);
            }
        });
        this.btnSalir.setFont(new Font("Arial", 1, 12));
        this.btnSalir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.btnSalir.setText("Salir");
        this.btnSalir.addActionListener(new ActionListener() { // from class: Caja.BusqCierre.12
            public void actionPerformed(ActionEvent evt) {
                BusqCierre.this.btnSalirActionPerformed(evt);
            }
        });
        this.btnImprimir.setFont(new Font("Arial", 1, 12));
        this.btnImprimir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Imprimir.png")));
        this.btnImprimir.setText("Imprimir Cierre");
        this.btnImprimir.addActionListener(new ActionListener() { // from class: Caja.BusqCierre.13
            public void actionPerformed(ActionEvent evt) {
                BusqCierre.this.btnImprimirActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(20, 20, 20).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jScrollPane1, -2, 800, -2).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.btnLimpiar, -2, 260, -2).addGap(10, 10, 10).addComponent(this.btnImprimir, -2, 260, -2).addGap(10, 10, 10).addComponent(this.btnSalir, -2, 260, -2)).addComponent(this.jPanel3, -2, -1, -2))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel3, -2, 160, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane1, -2, 172, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.btnLimpiar, -2, 50, -2).addComponent(this.btnImprimir, -2, 50, -2).addComponent(this.btnSalir, -2, 50, -2)).addContainerGap()));
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
        buscarCierre();
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
    public void cboCajaActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnImprimirActionPerformed(ActionEvent evt) {
        if (this.grid.getSelectedRow() != -1) {
            String idCierre = this.grid.getValueAt(this.grid.getSelectedRow(), 0).toString();
            this.clasecaja.imprimirCierre(idCierre);
        }
    }
}
