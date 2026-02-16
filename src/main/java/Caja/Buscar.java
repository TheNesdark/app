package Caja;

import Utilidades.ConsultasMySQL;
import Utilidades.JTextFieldValidator;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.LayoutManager;
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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.jdnc.incubator.jxcombobox.IncompatibleLookAndFeelException;
import org.jdesktop.jdnc.incubator.jxcombobox.JTableComboBox;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

/* JADX INFO: loaded from: GenomaP.jar:Caja/Buscar.class */
public class Buscar extends JDialog {
    private Metodos metodos;
    private ConsultasMySQL consultas;
    private int filaGrid;
    private String sql;
    private DefaultTableModel modelo;
    private DefaultTableModel modcombos;
    private claseCaja clasecaja;
    private Recibos recibos;
    private JButton btnAceptar;
    private JButton btnBuscar;
    private JButton btnImprimir;
    private JButton btnImprimirListado;
    private JButton btnLimpiar;
    private JButton btnSalir;
    private JTableComboBox cboCC;
    private JTableComboBox cboCaja;
    private JTableComboBox cboCajero;
    private JTableComboBox cboEps;
    private JTable grid;
    private JButton jButton1;
    private JPanel jPanel3;
    private JScrollPane jScrollPane1;
    private JTextFieldValidator txtDocumento;
    private JTextFieldValidator txtFactura;
    private JDateChooser txtFechaFin;
    private JDateChooser txtFechaIni;
    private JTextFieldValidator txtNbre;
    private JTextFieldValidator txtNoRecibo;

    public Buscar(Frame parent, boolean modal, Recibos jifrm, claseCaja Clasecaja) {
        super(parent, modal);
        this.metodos = new Metodos();
        this.consultas = new ConsultasMySQL();
        this.filaGrid = 0;
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        setLocationRelativeTo(null);
        this.clasecaja = Clasecaja;
        this.recibos = jifrm;
        limpiar();
        this.grid.addMouseListener(new MouseAdapter() { // from class: Caja.Buscar.1
            public void mouseClicked(MouseEvent e) {
                Buscar.this.filaGrid = Buscar.this.grid.rowAtPoint(e.getPoint());
            }
        });
    }

    private void buscarRecibo() {
        if (validarCampos() == 1) {
            this.sql = "SELECT `k_recibos`.`Id` , `k_recibos`.`NoRecibo` , DATE_FORMAT(k_recibos.Fecha_Recibo, '%d/%m/%Y') AS `Fecha` , DATE_FORMAT(k_recibos.Fecha_Recibo, '%h:%i %p') AS `Hora` ,   IF(`k_recibos`.`NoFactura` > 0, IFNULL(IF(`cc_resolucion_dian`.`trasmision` = 0,IF(f_factura_evento.Prefijo = '',`f_factura_evento`.`No_FacturaEvento`,CONCAT(f_factura_evento.Prefijo,`f_factura_evento`.`No_FacturaEvento`)),IF(f_factura_evento.Prefijo = '',`f_factura_evento`.`No_FacturaEvento_M`,CONCAT(f_factura_evento.Prefijo,`f_factura_evento`.`No_FacturaEvento_M`))), `k_recibos`.`NoFactura`), 0) AS NoFactura, `k_recibos`.`Id_TipoDocumento` AS `TipoDoc` , `k_recibos`.`Identificacion` AS `Documento` , `k_recibos`.`Nbre_Paciente` AS `Usuario` , SUM(k_itemrecibos.Cantidad*k_itemrecibos.VrUnitario) SubTotal, `k_recibos`.`Descuento`, (SUM(k_itemrecibos.Cantidad*k_itemrecibos.VrUnitario)-`k_recibos`.`Descuento`) AS `Total` , `k_caja`.`Nbre` AS `Caja` , IF(k_recibos.Estado=0,'ACTIVO','ANULADO')  AS `Estado`,   k_recibos.Observacion, `k_caja`.`Id` FROM `k_recibos`  INNER JOIN  `k_caja`   ON (`k_recibos`.`Id_Caja` = `k_caja`.`Id`)  INNER JOIN  `f_centrocosto`  ON (`k_recibos`.`Id_CentroCosto` = `f_centrocosto`.`Id`) INNER JOIN  `f_empresacontxconvenio`  ON (`f_empresacontxconvenio`.`Id` = `k_recibos`.`Id_EmpresaContxConv`) INNER JOIN  `k_itemrecibos`  ON (`k_itemrecibos`.`Id_Recibo` = `k_recibos`.`Id`)     LEFT JOIN f_factura_evento ON (f_factura_evento.No_FacturaEvento = k_recibos.NoFactura) LEFT JOIN cc_resolucion_dian ON (cc_resolucion_dian.Id = f_factura_evento.idResolucionDian) WHERE ( ";
            if (this.cboCaja.getSelectedIndex() >= 0) {
                this.sql += "k_recibos.Id_Caja=" + this.cboCaja.getPopupTable().getValueAt(this.cboCaja.getSelectedIndex(), 0) + " AND ";
            }
            if (this.cboCC.getSelectedIndex() >= 0) {
                this.sql += "k_recibos.Id_CentroCosto=" + this.cboCC.getPopupTable().getValueAt(this.cboCC.getSelectedIndex(), 0) + " AND ";
            }
            if (this.cboEps.getSelectedIndex() >= 0) {
                this.sql += "k_recibos.Id_EmpresaContxConv=" + this.cboEps.getPopupTable().getValueAt(this.cboEps.getSelectedIndex(), 0) + " AND ";
            }
            if (this.cboCajero.getSelectedIndex() >= 0) {
                this.sql += "k_recibos.UsuarioS='" + this.cboCajero.getPopupTable().getValueAt(this.cboCajero.getSelectedIndex(), 2) + "' AND ";
            }
            if (this.txtFechaIni.getDate() != null) {
                this.sql += "DATE_FORMAT(k_recibos.Fecha_Recibo, '%Y-%m-%d')>='" + this.metodos.formatoAMDG.format(this.txtFechaIni.getDate()) + "'  AND ";
            }
            if (this.txtFechaFin.getDate() != null) {
                this.sql += "DATE_FORMAT(k_recibos.Fecha_Recibo, '%Y-%m-%d')<='" + this.metodos.formatoAMDG.format(this.txtFechaFin.getDate()) + "'  AND ";
            }
            if (!this.txtDocumento.getText().isEmpty()) {
                this.sql += "k_recibos.Identificacion=" + this.txtDocumento.getText() + " AND ";
            }
            if (!this.txtNoRecibo.getText().equals("0")) {
                this.sql += "k_recibos.NoRecibo=" + this.txtNoRecibo.getText() + " AND ";
            }
            if (!this.txtFactura.getText().isEmpty()) {
                this.sql += "k_recibos.NoFactura='" + this.txtFactura.getText() + "' AND ";
            }
            if (!this.txtNbre.getText().isEmpty()) {
                this.sql += "k_recibos.Nbre_Paciente LIKE '%" + this.txtNbre.getText() + "%' AND ";
            }
            this.sql += "k_recibos.Estado>=0) GROUP BY `k_recibos`.`Id` ORDER BY Fecha ASC,k_recibos.NoRecibo DESC ";
            crearGrid();
            this.consultas.llenarTabla(this.sql, this.grid, this.modelo);
            ajustarGrid();
            if (this.grid.getRowCount() == 0) {
                this.metodos.mostrarMensaje("No se encontró el Recibo solicitado");
            }
        }
        this.consultas.cerrarConexionBd();
    }

    public void cargarCombos() {
        this.consultas.llenarComboTabla("SELECT Id , Nbre AS  Cajas FROM k_caja WHERE Estado=0 ORDER BY Nbre ASC", this.cboCaja, this.modcombos, 1);
        this.consultas.llenarComboTabla("SELECT Id , Nbre as Centro_de_Costo FROM f_centrocosto WHERE Estado = 0 ORDER BY Nbre ASC", this.cboCC, this.modcombos, 1);
        this.consultas.llenarComboTabla("SELECT Id, Nbre as Empresa_Contratante FROM f_empresacontxconvenio WHERE Estado = 0 ORDER BY Nbre ASC", this.cboEps, this.modcombos, 1);
        this.sql = "SELECT  g_usuariosxcaja.Id_Persona AS Id, w_persona.NUsuario AS Cajero ,g_usuario_sist.Login AS Usuario FROM g_usuariosxcaja INNER JOIN w_persona ON (g_usuariosxcaja.Id_Persona = w_persona.Id_persona) INNER JOIN g_usuario_sist ON (g_usuario_sist.Id_Persona=g_usuariosxcaja.Id_Persona) GROUP BY g_usuariosxcaja.Id_Persona, w_persona.NUsuario ORDER BY w_persona.NUsuario ASC";
        this.consultas.llenarComboTabla(this.sql, this.cboCajero, this.modcombos, 1);
        this.consultas.cerrarConexionBd();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    public void crearGrid() {
        this.modelo = new DefaultTableModel(new Object[0], new String[]{"Id", "No Recibo", "Fecha", "Hora", "No Factura", "Tipo Doc.", "Documento", "Usuario", "Subtotal", "Descuento", "Total", "Caja", "Estado", "Observación", "Id_Caja"}) { // from class: Caja.Buscar.2
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Double.class, Double.class, Double.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.grid.setModel(this.modelo);
    }

    private void ajustarGrid() {
        this.grid.getColumnModel().getColumn(0).setPreferredWidth(50);
        this.grid.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(5).setPreferredWidth(50);
        this.grid.getColumnModel().getColumn(6).setPreferredWidth(120);
        this.grid.getColumnModel().getColumn(7).setPreferredWidth(300);
        this.grid.getColumnModel().getColumn(8).setPreferredWidth(150);
        this.grid.getColumnModel().getColumn(9).setPreferredWidth(150);
        this.grid.getColumnModel().getColumn(10).setPreferredWidth(150);
        this.grid.getColumnModel().getColumn(11).setPreferredWidth(150);
        this.grid.getColumnModel().getColumn(12).setPreferredWidth(150);
        this.grid.getColumnModel().getColumn(13).setPreferredWidth(50);
        this.grid.getColumnModel().getColumn(14).setPreferredWidth(0);
        this.grid.getColumnModel().getColumn(14).setMinWidth(0);
        this.grid.getColumnModel().getColumn(14).setMaxWidth(0);
    }

    private void imprimirListado() {
        if (this.txtFechaIni.getDate() == null) {
            this.metodos.mostrarMensaje("Por favor coloque una fecha de Inicio de la Consulta");
            this.txtFechaIni.requestFocus();
        } else if (this.txtFechaFin.getDate() == null) {
            this.metodos.mostrarMensaje("Por favor coloque una fecha de Finalización de la Consulta");
            this.txtFechaFin.requestFocus();
        } else if (this.cboEps.getSelectedIndex() < 0) {
            this.metodos.mostrarMensaje("Por favor seleccione una EPS");
            this.cboEps.requestFocus();
        } else {
            this.clasecaja.imprimirListado(String.valueOf(this.metodos.formatoAMD.format(this.txtFechaIni.getDate())), String.valueOf(this.metodos.formatoAMD.format(this.txtFechaFin.getDate())), this.cboEps.getPopupTable().getValueAt(this.cboEps.getSelectedIndex(), 0).toString(), this.cboEps.getSelectedItem().toString(), this.cboCC.getPopupTable().getValueAt(this.cboCC.getSelectedIndex(), 0).toString());
        }
    }

    private void limpiar() {
        this.txtNoRecibo.setText("0");
        this.txtFactura.setText("");
        this.txtFechaIni.setDate((Date) null);
        this.txtFechaFin.setDate((Date) null);
        this.txtNbre.setText("");
        this.txtDocumento.setText("");
        cargarCombos();
        crearGrid();
    }

    private int validarCampos() {
        int retorno = 0;
        if (this.cboCaja.getSelectedIndex() < 0 && this.cboCC.getSelectedIndex() < 0 && this.cboEps.getSelectedIndex() < 0 && this.cboCajero.getSelectedIndex() < 0 && this.txtFechaIni.getDate() == null && this.txtFechaFin.getDate() == null && this.txtDocumento.getText().isEmpty() && this.txtNoRecibo.getText().equals("0") && this.txtFactura.getText().isEmpty() && this.txtNbre.getText().isEmpty()) {
            this.metodos.mostrarMensaje("Por favor seleccione un Criterio de Busqueda");
        } else {
            retorno = 1;
        }
        return retorno;
    }

    /* JADX WARN: Type inference failed for: r3v53, types: [java.lang.Object[], java.lang.Object[][]] */
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
        try {
            this.cboEps = new JTableComboBox();
        } catch (IncompatibleLookAndFeelException e13) {
            e13.printStackTrace();
        }
        try {
            this.cboCC = new JTableComboBox();
        } catch (IncompatibleLookAndFeelException e14) {
            e14.printStackTrace();
        }
        this.txtFechaIni = new JDateChooser();
        this.txtFechaFin = new JDateChooser();
        this.txtNbre = new JTextFieldValidator();
        this.txtNoRecibo = new JTextFieldValidator();
        this.txtFactura = new JTextFieldValidator();
        this.txtDocumento = new JTextFieldValidator();
        this.jScrollPane1 = new JScrollPane();
        this.grid = new JTable();
        this.btnLimpiar = new JButton();
        this.btnAceptar = new JButton();
        this.btnSalir = new JButton();
        this.btnImprimir = new JButton();
        this.btnImprimirListado = new JButton();
        this.jButton1 = new JButton();
        setDefaultCloseOperation(2);
        setTitle("Busqueda de Recibos");
        setMinimumSize(new Dimension(1100, 562));
        getContentPane().setLayout(new AbsoluteLayout());
        this.jPanel3.setBorder(BorderFactory.createTitledBorder((Border) null, "CRITERIOS DE BÚSQUEDA", 0, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.jPanel3.setLayout((LayoutManager) null);
        this.btnBuscar.setFont(new Font("Arial", 1, 12));
        this.btnBuscar.setForeground(new Color(0, 0, 153));
        this.btnBuscar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Buscar.png")));
        this.btnBuscar.setText("Buscar");
        this.btnBuscar.addActionListener(new ActionListener() { // from class: Caja.Buscar.3
            public void actionPerformed(ActionEvent evt) {
                Buscar.this.btnBuscarActionPerformed(evt);
            }
        });
        this.jPanel3.add(this.btnBuscar);
        this.btnBuscar.setBounds(930, 30, 140, 150);
        this.cboCajero.setBorder(BorderFactory.createTitledBorder((Border) null, "Cajero", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.cboCajero.setFont(new Font("Arial", 1, 12));
        this.jPanel3.add(this.cboCajero);
        this.cboCajero.setBounds(500, 30, 420, 40);
        this.cboCaja.setBorder(BorderFactory.createTitledBorder((Border) null, "Caja", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.cboCaja.setFont(new Font("Arial", 1, 12));
        this.cboCaja.addActionListener(new ActionListener() { // from class: Caja.Buscar.4
            public void actionPerformed(ActionEvent evt) {
                Buscar.this.cboCajaActionPerformed(evt);
            }
        });
        this.jPanel3.add(this.cboCaja);
        this.cboCaja.setBounds(150, 30, 340, 40);
        this.cboEps.setBorder(BorderFactory.createTitledBorder((Border) null, "Empresa", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.cboEps.setFont(new Font("Arial", 1, 12));
        this.cboEps.addActionListener(new ActionListener() { // from class: Caja.Buscar.5
            public void actionPerformed(ActionEvent evt) {
                Buscar.this.cboEpsActionPerformed(evt);
            }
        });
        this.jPanel3.add(this.cboEps);
        this.cboEps.setBounds(150, 90, 340, 40);
        this.cboCC.setBorder(BorderFactory.createTitledBorder((Border) null, "Centro de Costo", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.cboCC.setFont(new Font("Arial", 1, 12));
        this.cboCC.addActionListener(new ActionListener() { // from class: Caja.Buscar.6
            public void actionPerformed(ActionEvent evt) {
                Buscar.this.cboCCActionPerformed(evt);
            }
        });
        this.jPanel3.add(this.cboCC);
        this.cboCC.setBounds(500, 90, 420, 40);
        this.txtFechaIni.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicial", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtFechaIni.setFont(new Font("Arial", 1, 12));
        this.txtFechaIni.addPropertyChangeListener(new PropertyChangeListener() { // from class: Caja.Buscar.7
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                Buscar.this.txtFechaIniPropertyChange(evt);
            }
        });
        this.txtFechaIni.addAncestorListener(new AncestorListener() { // from class: Caja.Buscar.8
            public void ancestorMoved(AncestorEvent evt) {
            }

            public void ancestorAdded(AncestorEvent evt) {
                Buscar.this.txtFechaIniAncestorAdded(evt);
            }

            public void ancestorRemoved(AncestorEvent evt) {
            }
        });
        this.txtFechaIni.addVetoableChangeListener(new VetoableChangeListener() { // from class: Caja.Buscar.9
            /* JADX INFO: Thrown type has an unknown type hierarchy: java.beans.PropertyVetoException */
            public void vetoableChange(PropertyChangeEvent evt) throws PropertyVetoException {
                Buscar.this.txtFechaIniVetoableChange(evt);
            }
        });
        this.jPanel3.add(this.txtFechaIni);
        this.txtFechaIni.setBounds(20, 140, 120, 50);
        this.txtFechaFin.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Final", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtFechaFin.setFont(new Font("Arial", 1, 12));
        this.txtFechaFin.addPropertyChangeListener(new PropertyChangeListener() { // from class: Caja.Buscar.10
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                Buscar.this.txtFechaFinPropertyChange(evt);
            }
        });
        this.txtFechaFin.addAncestorListener(new AncestorListener() { // from class: Caja.Buscar.11
            public void ancestorMoved(AncestorEvent evt) {
            }

            public void ancestorAdded(AncestorEvent evt) {
                Buscar.this.txtFechaFinAncestorAdded(evt);
            }

            public void ancestorRemoved(AncestorEvent evt) {
            }
        });
        this.txtFechaFin.addVetoableChangeListener(new VetoableChangeListener() { // from class: Caja.Buscar.12
            /* JADX INFO: Thrown type has an unknown type hierarchy: java.beans.PropertyVetoException */
            public void vetoableChange(PropertyChangeEvent evt) throws PropertyVetoException {
                Buscar.this.txtFechaFinVetoableChange(evt);
            }
        });
        this.jPanel3.add(this.txtFechaFin);
        this.txtFechaFin.setBounds(150, 140, 130, 50);
        this.txtNbre.setBorder(BorderFactory.createTitledBorder((Border) null, "Datos del Usuario", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtNbre.setFont(new Font("Arial", 1, 12));
        this.txtNbre.addActionListener(new ActionListener() { // from class: Caja.Buscar.13
            public void actionPerformed(ActionEvent evt) {
                Buscar.this.txtNbreActionPerformed(evt);
            }
        });
        this.jPanel3.add(this.txtNbre);
        this.txtNbre.setBounds(500, 150, 420, 40);
        this.txtNoRecibo.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Recibo", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtNoRecibo.setText("0");
        this.txtNoRecibo.setFont(new Font("Arial", 1, 12));
        this.jPanel3.add(this.txtNoRecibo);
        this.txtNoRecibo.setBounds(10, 30, 130, 40);
        this.txtFactura.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Factura", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtFactura.setText("0");
        this.txtFactura.setFont(new Font("Arial", 1, 12));
        this.jPanel3.add(this.txtFactura);
        this.txtFactura.setBounds(10, 90, 130, 40);
        this.txtDocumento.setBorder(BorderFactory.createTitledBorder((Border) null, "Doc. Identidad", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtDocumento.setFont(new Font("Arial", 1, 12));
        this.jPanel3.add(this.txtDocumento);
        this.txtDocumento.setBounds(320, 150, 170, 40);
        getContentPane().add(this.jPanel3, new AbsoluteConstraints(0, 0, 1090, 210));
        this.jScrollPane1.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.grid.setFont(new Font("Arial", 1, 12));
        this.grid.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.grid.setRowHeight(25);
        this.grid.setSelectionBackground(new Color(255, 255, 255));
        this.grid.setSelectionForeground(new Color(255, 0, 0));
        this.grid.setSelectionMode(0);
        this.jScrollPane1.setViewportView(this.grid);
        getContentPane().add(this.jScrollPane1, new AbsoluteConstraints(0, 220, 1090, 270));
        this.btnLimpiar.setFont(new Font("Arial", 1, 12));
        this.btnLimpiar.setForeground(new Color(0, 0, 153));
        this.btnLimpiar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Limpiar.png")));
        this.btnLimpiar.setText("Limpiar");
        this.btnLimpiar.addActionListener(new ActionListener() { // from class: Caja.Buscar.14
            public void actionPerformed(ActionEvent evt) {
                Buscar.this.btnLimpiarActionPerformed(evt);
            }
        });
        getContentPane().add(this.btnLimpiar, new AbsoluteConstraints(0, 500, 140, 50));
        this.btnAceptar.setFont(new Font("Arial", 1, 12));
        this.btnAceptar.setForeground(new Color(0, 0, 153));
        this.btnAceptar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.btnAceptar.setText("Cargar Recibo");
        this.btnAceptar.addActionListener(new ActionListener() { // from class: Caja.Buscar.15
            public void actionPerformed(ActionEvent evt) {
                Buscar.this.btnAceptarActionPerformed(evt);
            }
        });
        getContentPane().add(this.btnAceptar, new AbsoluteConstraints(150, 500, 160, 50));
        this.btnSalir.setFont(new Font("Arial", 1, 12));
        this.btnSalir.setForeground(new Color(0, 0, 153));
        this.btnSalir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.btnSalir.setText("Salir");
        this.btnSalir.addActionListener(new ActionListener() { // from class: Caja.Buscar.16
            public void actionPerformed(ActionEvent evt) {
                Buscar.this.btnSalirActionPerformed(evt);
            }
        });
        getContentPane().add(this.btnSalir, new AbsoluteConstraints(860, 500, 230, 50));
        this.btnImprimir.setFont(new Font("Arial", 1, 12));
        this.btnImprimir.setForeground(new Color(0, 0, 153));
        this.btnImprimir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Imprimir.png")));
        this.btnImprimir.setText("Imprimir Recibo");
        this.btnImprimir.addActionListener(new ActionListener() { // from class: Caja.Buscar.17
            public void actionPerformed(ActionEvent evt) {
                Buscar.this.btnImprimirActionPerformed(evt);
            }
        });
        getContentPane().add(this.btnImprimir, new AbsoluteConstraints(320, 500, 170, 50));
        this.btnImprimirListado.setFont(new Font("Arial", 1, 12));
        this.btnImprimirListado.setForeground(new Color(0, 0, 153));
        this.btnImprimirListado.setIcon(new ImageIcon(getClass().getResource("/Imagenes/HojaLapiz29x27.png")));
        this.btnImprimirListado.setText("Imprimir Listado");
        this.btnImprimirListado.addActionListener(new ActionListener() { // from class: Caja.Buscar.18
            public void actionPerformed(ActionEvent evt) {
                Buscar.this.btnImprimirListadoActionPerformed(evt);
            }
        });
        getContentPane().add(this.btnImprimirListado, new AbsoluteConstraints(500, 500, 150, 50));
        this.jButton1.setFont(new Font("Arial", 1, 12));
        this.jButton1.setForeground(new Color(0, 0, 102));
        this.jButton1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel.jpg")));
        this.jButton1.setText("Exportar a TXT");
        this.jButton1.addActionListener(new ActionListener() { // from class: Caja.Buscar.19
            public void actionPerformed(ActionEvent evt) {
                Buscar.this.jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(this.jButton1, new AbsoluteConstraints(660, 500, 170, 50));
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
        buscarRecibo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnLimpiarActionPerformed(ActionEvent evt) {
        limpiar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnAceptarActionPerformed(ActionEvent evt) {
        if (this.grid.getRowCount() > 0) {
            String idRecibo = this.grid.getModel().getValueAt(this.filaGrid, 0).toString();
            String fecha = this.grid.getModel().getValueAt(this.filaGrid, 2).toString();
            this.recibos.cargarRecibo(4, idRecibo, fecha);
            dispose();
        }
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
        this.cboCC.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboCajaActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboEpsActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboCCActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnImprimirActionPerformed(ActionEvent evt) {
        if (this.grid.getRowCount() > 0) {
            String idRecibo = this.grid.getModel().getValueAt(this.filaGrid, 0).toString();
            String vrLetras = this.grid.getModel().getValueAt(this.filaGrid, 10).toString();
            this.clasecaja.imprimirRecibo(idRecibo, vrLetras, this.grid.getModel().getValueAt(this.filaGrid, 14).toString(), this.recibos);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtNbreActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnImprimirListadoActionPerformed(ActionEvent evt) {
        imprimirListado();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jButton1ActionPerformed(ActionEvent evt) {
        int n = JOptionPane.showConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            this.metodos.mExportar_Datos_Tabla_Titulo_Formato(this.grid, "c:\\Genoma\\plantilla", getTitle());
        }
    }
}
