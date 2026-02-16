package Enfermeria;

import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

/* JADX INFO: loaded from: GenomaP.jar:Enfermeria/BuscarTriage.class */
public class BuscarTriage extends JDialog {
    private Metodos metodos;
    private ConsultasMySQL consultas;
    private Object[] dato;
    private int filaGrid;
    private String sql;
    private DefaultTableModel modelo;
    private Atencion frmAtencion;
    private JButton btnAceptar;
    private JButton btnBuscar;
    private JButton btnLimpiar;
    private JButton btnSalir;
    private ButtonGroup buttonGroup1;
    private JCheckBox chk1;
    private JCheckBox chk2;
    private JCheckBox chk3;
    private JCheckBox chk4;
    private JCheckBox chk5;
    private JTable grid;
    private JLabel jLabel3;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JScrollPane jScrollPane1;
    private JLabel lblNumero;
    private JLabel lblNumero1;
    private JLabel lblNumero2;
    private JDateChooser txtFechaFin;
    private JDateChooser txtFechaIni;
    private JTextField txtHistoria;
    private JLabel txtTitulo;
    private JTextField txtTriage;

    public BuscarTriage(Frame parent, boolean modal, Atencion frm) {
        super(parent, modal);
        this.metodos = new Metodos();
        this.consultas = new ConsultasMySQL();
        this.filaGrid = 0;
        initComponents();
        setLocationRelativeTo(null);
        this.frmAtencion = frm;
        this.grid.addMouseListener(new MouseAdapter() { // from class: Enfermeria.BuscarTriage.1
            public void mouseClicked(MouseEvent e) {
                BuscarTriage.this.filaGrid = BuscarTriage.this.grid.rowAtPoint(e.getPoint());
            }
        });
    }

    private void buscar() {
        crearGrid();
        this.sql = "SELECT h_triage.FechaTriage, h_triage.HoraTriage, h_triage.Id as Triage, h_triage.IdIngreso as Ingreso, h_atencion.Id as Atencion, c_citasnp.Id as Cita, w_persona.NUsuario, w_persona.NoHistoria, h_triage.Estado,  h_triage.Clasificacion FROM h_triage INNER JOIN baseserver.ingreso ON (h_triage.IdIngreso = ingreso.Id) INNER JOIN h_atencion ON (h_atencion.Id_Ingreso = ingreso.Id) INNER JOIN w_persona ON (ingreso.Id_Usuario = w_persona.Id_persona) INNER JOIN c_citasnp ON (c_citasnp.Id_ingreso = ingreso.Id) WHERE (h_triage.Id > '0";
        if (!this.txtTriage.getText().isEmpty()) {
            this.sql += "' AND h_triage.Id ='" + this.txtTriage.getText();
        }
        if (this.txtFechaIni.getDate() != null) {
            this.sql += "' AND h_triage.FechaTriage >='" + this.metodos.formatoAMD.format(this.txtFechaIni.getDate());
        }
        if (this.txtFechaFin.getDate() != null) {
            this.sql += "' AND h_triage.FechaTriage <='" + this.metodos.formatoAMD.format(this.txtFechaFin.getDate());
        }
        if (this.chk1.isSelected()) {
            this.sql += "' AND h_triage.Clasificacion ='1";
        }
        if (this.chk2.isSelected()) {
            this.sql += "' AND h_triage.Clasificacion ='2";
        }
        if (this.chk3.isSelected()) {
            this.sql += "' AND h_triage.Clasificacion ='3";
        }
        if (this.chk4.isSelected()) {
            this.sql += "' AND h_triage.Clasificacion ='4";
        }
        if (this.chk5.isSelected()) {
            this.sql += "' AND h_triage.Clasificacion ='5";
        }
        if (!this.txtHistoria.getText().isEmpty()) {
            this.sql += "' AND w_persona.NoHistoria ='" + this.txtHistoria.getText();
        }
        this.sql += "') ORDER BY h_triage.FechaTriage DESC, h_triage.HoraTriage DESC";
        ResultSet rs = this.consultas.traerRs(this.sql);
        while (rs.next()) {
            try {
                this.modelo.addRow(this.dato);
                this.modelo.setValueAt(this.metodos.formatoDMA.format((Date) rs.getDate("FechaTriage")), this.filaGrid, 0);
                this.modelo.setValueAt(this.metodos.formatoH12.format((Date) rs.getTime("HoraTriage")), this.filaGrid, 1);
                this.modelo.setValueAt(rs.getString("Triage"), this.filaGrid, 2);
                this.modelo.setValueAt(rs.getString("Ingreso"), this.filaGrid, 3);
                this.modelo.setValueAt(rs.getString("Atencion"), this.filaGrid, 4);
                this.modelo.setValueAt(rs.getString("Cita"), this.filaGrid, 5);
                this.modelo.setValueAt(rs.getString("Clasificacion"), this.filaGrid, 6);
                this.modelo.setValueAt(rs.getString("NoHistoria"), this.filaGrid, 7);
                this.modelo.setValueAt(rs.getString("NUsuario"), this.filaGrid, 8);
                if (rs.getString("Estado").equals("0")) {
                    this.modelo.setValueAt("Activo", this.filaGrid, 9);
                } else {
                    this.modelo.setValueAt("ANULADO", this.filaGrid, 9);
                }
                this.filaGrid++;
            } catch (SQLException ex) {
                this.consultas.mostrarErrorSQL(ex);
                return;
            }
        }
        rs.close();
        this.consultas.cerrarConexionBd();
    }

    public void crearGrid() {
        this.modelo = new DefaultTableModel() { // from class: Enfermeria.BuscarTriage.2
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.modelo.addColumn("Fecha");
        this.modelo.addColumn("Hora");
        this.modelo.addColumn("No. Triage");
        this.modelo.addColumn("No. Ingreso");
        this.modelo.addColumn("No. Atención");
        this.modelo.addColumn("No. Cita");
        this.modelo.addColumn("Clasificación");
        this.modelo.addColumn("Historia");
        this.modelo.addColumn("Usuario");
        this.modelo.addColumn("Estado");
        this.grid.setModel(this.modelo);
        this.grid.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.grid.getColumnModel().getColumn(1).setPreferredWidth(80);
        this.grid.getColumnModel().getColumn(2).setPreferredWidth(80);
        this.grid.getColumnModel().getColumn(3).setPreferredWidth(80);
        this.grid.getColumnModel().getColumn(4).setPreferredWidth(80);
        this.grid.getColumnModel().getColumn(5).setPreferredWidth(80);
        this.grid.getColumnModel().getColumn(6).setPreferredWidth(80);
        this.grid.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(8).setPreferredWidth(200);
        this.grid.getColumnModel().getColumn(9).setPreferredWidth(80);
        this.filaGrid = 0;
    }

    private void entregarTriage() {
        if (this.filaGrid >= 0 && this.filaGrid <= this.modelo.getRowCount()) {
            this.frmAtencion.cargarTriage(Long.valueOf(this.modelo.getValueAt(this.filaGrid, 2).toString()));
            dispose();
        } else {
            this.metodos.mostrarMensaje("Por favor seleccione un Triage");
        }
    }

    private void limpiar() {
        crearGrid();
        this.txtTriage.setText("");
        this.txtFechaIni.setDate((Date) null);
        this.txtFechaFin.setDate((Date) null);
        this.chk1.setSelected(false);
        this.chk2.setSelected(false);
        this.chk3.setSelected(false);
        this.chk4.setSelected(false);
        this.chk5.setSelected(false);
        this.txtHistoria.setText("");
    }

    /* JADX WARN: Type inference failed for: r3v52, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.buttonGroup1 = new ButtonGroup();
        this.txtTitulo = new JLabel();
        this.jPanel2 = new JPanel();
        this.lblNumero = new JLabel();
        this.txtTriage = new JTextField();
        this.txtFechaFin = new JDateChooser();
        this.btnBuscar = new JButton();
        this.jLabel3 = new JLabel();
        this.txtHistoria = new JTextField();
        this.txtFechaIni = new JDateChooser();
        this.lblNumero1 = new JLabel();
        this.lblNumero2 = new JLabel();
        this.jPanel1 = new JPanel();
        this.chk5 = new JCheckBox();
        this.chk3 = new JCheckBox();
        this.chk4 = new JCheckBox();
        this.chk1 = new JCheckBox();
        this.chk2 = new JCheckBox();
        this.jScrollPane1 = new JScrollPane();
        this.grid = new JTable();
        this.jPanel3 = new JPanel();
        this.btnAceptar = new JButton();
        this.btnSalir = new JButton();
        this.btnLimpiar = new JButton();
        setDefaultCloseOperation(2);
        setName("BuscarDespacho");
        getContentPane().setLayout(new AbsoluteLayout());
        this.txtTitulo.setBackground(new Color(0, 0, 102));
        this.txtTitulo.setFont(new Font("Arial", 1, 18));
        this.txtTitulo.setForeground(new Color(255, 255, 255));
        this.txtTitulo.setHorizontalAlignment(0);
        this.txtTitulo.setText("BUSQUEDA DE TRIAGE DE ENFERMERIA");
        this.txtTitulo.setOpaque(true);
        getContentPane().add(this.txtTitulo, new AbsoluteConstraints(0, 0, 1000, 40));
        this.jPanel2.setBorder(BorderFactory.createTitledBorder((Border) null, "CRITERIO DE BUSQUEDA", 0, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.jPanel2.setLayout((LayoutManager) null);
        this.lblNumero.setFont(new Font("Tahoma", 1, 12));
        this.lblNumero.setForeground(Color.blue);
        this.lblNumero.setText("Fecha Final");
        this.jPanel2.add(this.lblNumero);
        this.lblNumero.setBounds(270, 20, 110, 20);
        this.txtTriage.setHorizontalAlignment(4);
        this.txtTriage.addActionListener(new ActionListener() { // from class: Enfermeria.BuscarTriage.3
            public void actionPerformed(ActionEvent evt) {
                BuscarTriage.this.txtTriageActionPerformed(evt);
            }
        });
        this.txtTriage.addFocusListener(new FocusAdapter() { // from class: Enfermeria.BuscarTriage.4
            public void focusGained(FocusEvent evt) {
                BuscarTriage.this.txtTriageFocusGained(evt);
            }
        });
        this.jPanel2.add(this.txtTriage);
        this.txtTriage.setBounds(10, 40, 120, 30);
        this.txtFechaFin.addPropertyChangeListener(new PropertyChangeListener() { // from class: Enfermeria.BuscarTriage.5
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                BuscarTriage.this.txtFechaFinPropertyChange(evt);
            }
        });
        this.txtFechaFin.addVetoableChangeListener(new VetoableChangeListener() { // from class: Enfermeria.BuscarTriage.6
            /* JADX INFO: Thrown type has an unknown type hierarchy: java.beans.PropertyVetoException */
            public void vetoableChange(PropertyChangeEvent evt) throws PropertyVetoException {
                BuscarTriage.this.txtFechaFinVetoableChange(evt);
            }
        });
        this.jPanel2.add(this.txtFechaFin);
        this.txtFechaFin.setBounds(270, 40, 119, 30);
        this.btnBuscar.setFont(new Font("Arial", 1, 12));
        this.btnBuscar.setForeground(new Color(0, 0, 153));
        this.btnBuscar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Buscar.png")));
        this.btnBuscar.setText("Buscar");
        this.btnBuscar.addActionListener(new ActionListener() { // from class: Enfermeria.BuscarTriage.7
            public void actionPerformed(ActionEvent evt) {
                BuscarTriage.this.btnBuscarActionPerformed(evt);
            }
        });
        this.jPanel2.add(this.btnBuscar);
        this.btnBuscar.setBounds(850, 20, 120, 50);
        this.jLabel3.setFont(new Font("Arial", 1, 12));
        this.jLabel3.setForeground(new Color(0, 0, 255));
        this.jLabel3.setText("No. Historia");
        this.jPanel2.add(this.jLabel3);
        this.jLabel3.setBounds(720, 20, 110, 15);
        this.txtHistoria.setFont(new Font("Arial", 1, 12));
        this.txtHistoria.addActionListener(new ActionListener() { // from class: Enfermeria.BuscarTriage.8
            public void actionPerformed(ActionEvent evt) {
                BuscarTriage.this.txtHistoriaActionPerformed(evt);
            }
        });
        this.txtHistoria.addFocusListener(new FocusAdapter() { // from class: Enfermeria.BuscarTriage.9
            public void focusGained(FocusEvent evt) {
                BuscarTriage.this.txtHistoriaFocusGained(evt);
            }
        });
        this.jPanel2.add(this.txtHistoria);
        this.txtHistoria.setBounds(720, 40, 120, 30);
        this.jPanel2.add(this.txtFechaIni);
        this.txtFechaIni.setBounds(140, 40, 120, 30);
        this.lblNumero1.setFont(new Font("Tahoma", 1, 12));
        this.lblNumero1.setForeground(Color.blue);
        this.lblNumero1.setText("No. Triage");
        this.jPanel2.add(this.lblNumero1);
        this.lblNumero1.setBounds(10, 20, 110, 20);
        this.lblNumero2.setFont(new Font("Tahoma", 1, 12));
        this.lblNumero2.setForeground(Color.blue);
        this.lblNumero2.setText("Fecha Inicio");
        this.jPanel2.add(this.lblNumero2);
        this.lblNumero2.setBounds(140, 20, 110, 20);
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "CLASIFICACIÓN", 0, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.jPanel1.setLayout(new AbsoluteLayout());
        this.buttonGroup1.add(this.chk5);
        this.chk5.setFont(new Font("Arial", 1, 18));
        this.chk5.setForeground(new Color(0, 0, 102));
        this.chk5.setText("5");
        this.jPanel1.add(this.chk5, new AbsoluteConstraints(226, 22, -1, -1));
        this.buttonGroup1.add(this.chk3);
        this.chk3.setFont(new Font("Arial", 1, 18));
        this.chk3.setForeground(new Color(0, 0, 102));
        this.chk3.setText("3");
        this.jPanel1.add(this.chk3, new AbsoluteConstraints(116, 22, -1, -1));
        this.buttonGroup1.add(this.chk4);
        this.chk4.setFont(new Font("Arial", 1, 18));
        this.chk4.setForeground(new Color(0, 0, 102));
        this.chk4.setText("4");
        this.jPanel1.add(this.chk4, new AbsoluteConstraints(171, 22, -1, -1));
        this.buttonGroup1.add(this.chk1);
        this.chk1.setFont(new Font("Arial", 1, 18));
        this.chk1.setForeground(new Color(0, 0, 102));
        this.chk1.setText("1");
        this.jPanel1.add(this.chk1, new AbsoluteConstraints(14, 22, -1, -1));
        this.buttonGroup1.add(this.chk2);
        this.chk2.setFont(new Font("Arial", 1, 18));
        this.chk2.setForeground(new Color(0, 0, 102));
        this.chk2.setText("2");
        this.jPanel1.add(this.chk2, new AbsoluteConstraints(61, 22, -1, -1));
        this.jPanel2.add(this.jPanel1);
        this.jPanel1.setBounds(400, 20, 320, 60);
        getContentPane().add(this.jPanel2, new AbsoluteConstraints(0, 40, 990, 100));
        this.grid.setFont(new Font("Arial", 1, 12));
        this.grid.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.grid.setRowHeight(25);
        this.grid.setSelectionBackground(new Color(255, 255, 255));
        this.grid.setSelectionForeground(new Color(255, 0, 0));
        this.grid.setSelectionMode(0);
        this.jScrollPane1.setViewportView(this.grid);
        getContentPane().add(this.jScrollPane1, new AbsoluteConstraints(10, 150, 980, 320));
        this.jPanel3.setBorder(BorderFactory.createEtchedBorder());
        this.btnAceptar.setFont(new Font("Arial", 1, 12));
        this.btnAceptar.setForeground(new Color(0, 0, 153));
        this.btnAceptar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ok29x27.png")));
        this.btnAceptar.setText("Aceptar");
        this.btnAceptar.addActionListener(new ActionListener() { // from class: Enfermeria.BuscarTriage.10
            public void actionPerformed(ActionEvent evt) {
                BuscarTriage.this.btnAceptarActionPerformed(evt);
            }
        });
        this.btnSalir.setFont(new Font("Arial", 1, 12));
        this.btnSalir.setForeground(new Color(0, 0, 153));
        this.btnSalir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.btnSalir.setText("Salir");
        this.btnSalir.addActionListener(new ActionListener() { // from class: Enfermeria.BuscarTriage.11
            public void actionPerformed(ActionEvent evt) {
                BuscarTriage.this.btnSalirActionPerformed(evt);
            }
        });
        this.btnLimpiar.setFont(new Font("Arial", 1, 12));
        this.btnLimpiar.setForeground(new Color(0, 0, 153));
        this.btnLimpiar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Limpiar.png")));
        this.btnLimpiar.setText("Limpiar");
        this.btnLimpiar.addActionListener(new ActionListener() { // from class: Enfermeria.BuscarTriage.12
            public void actionPerformed(ActionEvent evt) {
                BuscarTriage.this.btnLimpiarActionPerformed(evt);
            }
        });
        GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
        this.jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addComponent(this.btnLimpiar, -2, 251, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 102, 32767).addComponent(this.btnAceptar, -2, 272, -2).addGap(61, 61, 61).addComponent(this.btnSalir, -2, 270, -2).addContainerGap()));
        jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.btnLimpiar, -2, 0, 32767).addComponent(this.btnSalir, -2, 40, -2).addComponent(this.btnAceptar, -2, 40, -2)).addContainerGap()));
        getContentPane().add(this.jPanel3, new AbsoluteConstraints(10, 480, 980, -1));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtTriageActionPerformed(ActionEvent evt) {
        this.btnBuscar.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtFechaFinPropertyChange(PropertyChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtFechaFinVetoableChange(PropertyChangeEvent evt) throws PropertyVetoException {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnBuscarActionPerformed(ActionEvent evt) {
        buscar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtHistoriaActionPerformed(ActionEvent evt) {
        this.btnBuscar.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnAceptarActionPerformed(ActionEvent evt) {
        entregarTriage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnSalirActionPerformed(ActionEvent evt) {
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnLimpiarActionPerformed(ActionEvent evt) {
        limpiar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtTriageFocusGained(FocusEvent evt) {
        this.txtTriage.selectAll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtHistoriaFocusGained(FocusEvent evt) {
        this.txtHistoria.selectAll();
    }
}
