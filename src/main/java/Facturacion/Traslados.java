package Facturacion;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.jdnc.incubator.jxcombobox.IncompatibleLookAndFeelException;
import org.jdesktop.jdnc.incubator.jxcombobox.JTableComboBox;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

/* JADX INFO: loaded from: GenomaP.jar:Facturacion/Traslados.class */
public class Traslados extends JPanel {
    private Metodos metodos = new Metodos();
    private ConsultasMySQL consultas = new ConsultasMySQL();
    private String sql;
    private int filaGrid;
    private Object[] dato;
    private DefaultTableModel modelo;
    private Facturac frmFacturac;
    private JTableComboBox cboCama;
    private JTableComboBox cboEspecialidad;
    private JTableComboBox cboPabellon;
    private JTableComboBox cboProfesional;
    private JTable grid;
    private JLabel jLabel2;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;
    public JDateChooser txtFecha;
    public JDateChooser txtHora;
    private JTextField txtNo;

    public Traslados(Facturac frm) {
        initComponents();
        this.frmFacturac = frm;
        this.txtFecha.setDate(this.metodos.getFechaActual());
        this.txtHora.setDate(this.metodos.getFechaActual());
        cargarCombos();
        crearGrid();
        traerTraslados();
    }

    public void anular() {
        this.metodos.mostrarMensaje("Este función esta pendiente por desarrollo");
    }

    private void cargarCombos() {
        this.sql = "SELECT Id, Nbre as Especialidad FROM g_especialidad WHERE estado=0 ORDER BY Nbre ASC";
        this.consultas.llenarComboTabla(this.sql, this.cboEspecialidad, this.modelo, 1);
        this.sql = "SELECT Id , Nbre as Pabellon FROM f_unidadcama WHERE (Estado =0) order by Pabellon ";
        this.consultas.llenarComboTabla(this.sql, this.cboPabellon, this.modelo, 1);
        this.consultas.cerrarConexionBd();
    }

    private void cargarCboCama() {
        if (this.cboPabellon.getSelectedIndex() > -1) {
            this.sql = "SELECT f_camas.Id , f_camas.Nbre AS Cama , IF(f_camas.TipoHab=1,'UniPersonal',IF(f_camas.TipoHab=2,'BiPersonal',IF(f_camas.TipoHab=3,'Tres Camas','Cuatro ó Mas Camas'))) AS Tipo_Hab, f_camas.Id_Procedimiento AS IdProc FROM f_camas INNER JOIN f_unidadcama ON (f_camas.Id_UnidadCamas = f_unidadcama.Id) WHERE (f_camas.Estado =0 AND f_camas.Disponible=0 AND f_camas.Id_UnidadCamas = " + this.cboPabellon.getPopupTable().getValueAt(this.cboPabellon.getSelectedIndex(), 0) + ") order by Cama";
            this.consultas.llenarComboTabla(this.sql, this.cboCama, this.metodos.modcombos, 1);
            this.consultas.cerrarConexionBd();
        }
    }

    private void cargarProfesional() {
        this.sql = "SELECT w_profesional.Id_Persona as Id, w_profesional.NProfesional as Nombre FROM  w_profesional INNER JOIN g_profesionalespecial ON (w_profesional.Id_Persona = g_profesionalespecial.Id_Profesional) WHERE (g_profesionalespecial.Estado =0 AND g_profesionalespecial.Id_Especialidad ='" + this.cboEspecialidad.getPopupTable().getValueAt(this.cboEspecialidad.getSelectedIndex(), 0) + "') ORDER BY w_profesional.NProfesional ASC";
        this.consultas.llenarComboTabla(this.sql, this.cboProfesional, this.modelo, 1);
        this.consultas.cerrarConexionBd();
    }

    private void crearGrid() {
        this.modelo = new DefaultTableModel((Object[][]) null, new String[]{"No", "Fecha Hora Ingreso", "Fecha Hora Egreso", "Especialidad", "Profesional", "Pabellón", "Cama", "Días"}) { // from class: Facturacion.Traslados.1
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, Integer.class};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.grid.setModel(this.modelo);
        this.grid.getColumnModel().getColumn(0).setPreferredWidth(50);
        this.grid.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(3).setPreferredWidth(150);
        this.grid.getColumnModel().getColumn(4).setPreferredWidth(150);
        this.grid.getColumnModel().getColumn(5).setPreferredWidth(150);
        this.grid.getColumnModel().getColumn(6).setPreferredWidth(150);
        this.grid.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.filaGrid = 0;
    }

    public void grabar() {
        if (validarDatos() == 1) {
            this.frmFacturac.clasefacturacion.actualizarItemOrden("Traslado");
            this.frmFacturac.clasefacturacion.setCamaDisponible(0);
            this.frmFacturac.clasefacturacion.grabarOrdenCama(this.metodos.formatoAMD.format(this.txtFecha.getDate()), this.metodos.formatoH24.format(this.txtHora.getDate()), this.cboProfesional.getPopupTable().getValueAt(this.cboProfesional.getSelectedIndex(), 0).toString(), this.cboEspecialidad.getPopupTable().getValueAt(this.cboEspecialidad.getSelectedIndex(), 0).toString(), this.cboCama.getPopupTable().getValueAt(this.cboCama.getSelectedIndex(), 3).toString());
            this.sql = "UPDATE Cama FROM ingreso WHERE Id =" + Principal.txtNo.getText();
            this.consultas.ejecutarSQL(this.sql);
            this.consultas.cerrarConexionBd();
            this.frmFacturac.frmIngreso.cboUnidadCamas.setSelectedItem(this.cboPabellon.getSelectedItem());
            this.frmFacturac.frmIngreso.cboCamas.setSelectedItem(this.cboCama.getSelectedItem());
            this.frmFacturac.clasefacturacion.setCamaDisponible(1);
            crearGrid();
        }
    }

    public void nuevo() {
        this.txtNo.setText("");
        this.txtFecha.setDate(this.metodos.getFechaActual());
        this.txtHora.setDate(this.metodos.getFechaActual());
        this.cboEspecialidad.setSelectedIndex(-1);
        this.cboProfesional.setSelectedIndex(-1);
        this.cboPabellon.setSelectedIndex(-1);
        this.cboCama.setSelectedIndex(-1);
    }

    private void traerTraslados() {
        crearGrid();
        this.sql = "SELECT f_itemordenescamas.IdOrdenes, DATE_FORMAT(f_itemordenescamas.FechaIngCama,'%d/%m/%Y %h:%i %p'), DATE_FORMAT(f_itemordenescamas.FechaEgreCama,'%d/%m/%Y %h:%i %p'), w_profesional.Especialidad, w_profesional.NProfesional, f_unidadcama.Nbre, f_camas.Nbre, f_itemordenescamas.NoDias FROM baseserver.f_itemordenescamas INNER JOIN baseserver.f_ordenes ON (f_itemordenescamas.IdOrdenes = f_ordenes.Id) INNER JOIN baseserver.w_profesional ON (w_profesional.Id_Persona = f_ordenes.Id_Profesional) AND (w_profesional.IdEspecialidad = f_ordenes.Id_Especialidad) INNER JOIN baseserver.f_camas ON (f_itemordenescamas.IdCamas = f_camas.Id) INNER JOIN baseserver.f_unidadcama ON (f_camas.Id_UnidadCamas = f_unidadcama.Id) WHERE (f_ordenes.Id_Ingreso ='" + Principal.txtNo.getText() + "' AND f_ordenes.Estado = 0) ORDER BY f_itemordenescamas.FechaIngCama ASC";
        ResultSet rs = this.consultas.traerRs(this.sql);
        while (rs.next()) {
            try {
                this.modelo.addRow(this.dato);
                this.modelo.setValueAt(rs.getString(1), this.filaGrid, 0);
                this.modelo.setValueAt(rs.getString(2), this.filaGrid, 1);
                this.modelo.setValueAt(rs.getString(3), this.filaGrid, 2);
                this.modelo.setValueAt(rs.getString(4), this.filaGrid, 3);
                this.modelo.setValueAt(rs.getString(5), this.filaGrid, 4);
                this.modelo.setValueAt(rs.getString(6), this.filaGrid, 5);
                this.modelo.setValueAt(rs.getString(7), this.filaGrid, 6);
                this.modelo.setValueAt(Integer.valueOf(rs.getInt(8)), this.filaGrid, 7);
                this.filaGrid++;
            } catch (SQLException ex) {
                this.consultas.mostrarErrorSQL(ex);
                return;
            }
        }
        rs.close();
        this.consultas.cerrarConexionBd();
    }

    private int validarDatos() {
        String ultimaF = this.modelo.getValueAt(this.modelo.getRowCount(), 1).toString();
        int dias = this.consultas.getRestarFechas(ultimaF, this.txtFecha.getDate().toString());
        int retorno = 0;
        if (this.txtFecha.getDate() == null) {
            this.metodos.mostrarMensaje("Por favor seleccione la fecha del Traslado");
        } else if (dias < 0) {
            this.metodos.mostrarMensaje("La Fecha del Traslado no puede ser inferior a la de Ingreso o último Traslado");
        } else if (this.txtHora.getDate() == null) {
            this.metodos.mostrarMensaje("Por favor escriba la Hora del Traslado");
        } else if (this.cboEspecialidad.getSelectedIndex() < 0) {
            this.metodos.mostrarMensaje("Por favor seleccione una Especialidad");
        } else if (this.cboProfesional.getSelectedIndex() < 0) {
            this.metodos.mostrarMensaje("Por favor seleccione un Profesional");
        } else if (this.cboPabellon.getSelectedIndex() < 0) {
            this.metodos.mostrarMensaje("Por favor seleccione un Pabellón");
        } else if (this.cboCama.getSelectedIndex() < 0) {
            this.metodos.mostrarMensaje("Por favor seleccione una Cama");
        } else {
            retorno = 1;
        }
        return retorno;
    }

    /* JADX WARN: Type inference failed for: r3v30, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.jLabel2 = new JLabel();
        this.txtNo = new JTextField();
        this.txtFecha = new JDateChooser();
        this.txtHora = new JDateChooser();
        try {
            this.cboPabellon = new JTableComboBox();
        } catch (IncompatibleLookAndFeelException e1) {
            e1.printStackTrace();
        }
        try {
            this.cboCama = new JTableComboBox();
        } catch (IncompatibleLookAndFeelException e12) {
            e12.printStackTrace();
        }
        try {
            this.cboEspecialidad = new JTableComboBox();
        } catch (IncompatibleLookAndFeelException e13) {
            e13.printStackTrace();
        }
        try {
            this.cboProfesional = new JTableComboBox();
        } catch (IncompatibleLookAndFeelException e14) {
            e14.printStackTrace();
        }
        this.jScrollPane1 = new JScrollPane();
        this.grid = new JTable();
        setName("Traslados");
        setLayout(new AbsoluteLayout());
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "Datos del Traslado", 0, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.jPanel1.setLayout(new AbsoluteLayout());
        this.jLabel2.setFont(new Font("Tahoma", 1, 14));
        this.jLabel2.setForeground(new Color(0, 0, 204));
        this.jLabel2.setText("No.");
        this.jPanel1.add(this.jLabel2, new AbsoluteConstraints(10, 20, 50, -1));
        this.txtNo.setBackground(new Color(0, 0, 153));
        this.txtNo.setHorizontalAlignment(4);
        this.txtNo.setDisabledTextColor(new Color(255, 255, 255));
        this.txtNo.setEnabled(false);
        this.jPanel1.add(this.txtNo, new AbsoluteConstraints(10, 40, 80, 30));
        this.txtFecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtFecha.setDateFormatString("dd/MM/yyyy");
        this.txtFecha.setFont(new Font("Arial", 1, 12));
        this.jPanel1.add(this.txtFecha, new AbsoluteConstraints(100, 20, 100, 50));
        this.txtHora.setBorder(BorderFactory.createTitledBorder((Border) null, "Hora", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtHora.setDateFormatString("hh:mm:ss a");
        this.txtHora.setFont(new Font("Arial", 1, 12));
        this.jPanel1.add(this.txtHora, new AbsoluteConstraints(210, 20, 110, 50));
        this.cboPabellon.setBorder(BorderFactory.createTitledBorder((Border) null, "Pabellon", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.cboPabellon.setFont(new Font("Arial", 1, 12));
        this.cboPabellon.setShowTableGrid(true);
        this.cboPabellon.setShowTableHeaders(true);
        this.cboPabellon.addItemListener(new ItemListener() { // from class: Facturacion.Traslados.2
            public void itemStateChanged(ItemEvent evt) {
                Traslados.this.cboPabellonItemStateChanged(evt);
            }
        });
        this.jPanel1.add(this.cboPabellon, new AbsoluteConstraints(10, 100, 300, 40));
        this.cboCama.setBorder(BorderFactory.createTitledBorder((Border) null, "Cama", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.cboCama.setFont(new Font("Arial", 1, 12));
        this.cboCama.setShowTableGrid(true);
        this.cboCama.setShowTableHeaders(true);
        this.jPanel1.add(this.cboCama, new AbsoluteConstraints(330, 100, 320, 40));
        this.cboEspecialidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Especialidad", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.cboEspecialidad.setFont(new Font("Arial", 1, 12));
        this.cboEspecialidad.setShowTableGrid(true);
        this.cboEspecialidad.setShowTableHeaders(true);
        this.cboEspecialidad.addItemListener(new ItemListener() { // from class: Facturacion.Traslados.3
            public void itemStateChanged(ItemEvent evt) {
                Traslados.this.cboEspecialidadItemStateChanged(evt);
            }
        });
        this.jPanel1.add(this.cboEspecialidad, new AbsoluteConstraints(330, 30, 320, 40));
        this.cboProfesional.setBorder(BorderFactory.createTitledBorder((Border) null, "Profesional", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.cboProfesional.setFont(new Font("Arial", 1, 12));
        this.cboProfesional.setShowTableGrid(true);
        this.cboProfesional.setShowTableHeaders(true);
        this.jPanel1.add(this.cboProfesional, new AbsoluteConstraints(660, 30, 290, 40));
        add(this.jPanel1, new AbsoluteConstraints(0, 0, 1140, 150));
        this.grid.setFont(new Font("Arial", 1, 12));
        this.grid.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.grid.setColumnSelectionAllowed(true);
        this.grid.setRowHeight(25);
        this.grid.setSelectionBackground(new Color(255, 255, 255));
        this.grid.setSelectionForeground(new Color(255, 0, 0));
        this.grid.setSelectionMode(0);
        this.jScrollPane1.setViewportView(this.grid);
        this.grid.getColumnModel().getSelectionModel().setSelectionMode(0);
        add(this.jScrollPane1, new AbsoluteConstraints(0, 160, 1140, 220));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboEspecialidadItemStateChanged(ItemEvent evt) {
        cargarProfesional();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboPabellonItemStateChanged(ItemEvent evt) {
        cargarCboCama();
    }
}
