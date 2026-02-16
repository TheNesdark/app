package Facturacion;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.jdnc.incubator.jxcombobox.IncompatibleLookAndFeelException;
import org.jdesktop.jdnc.incubator.jxcombobox.JTableComboBox;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

/* JADX INFO: loaded from: GenomaP.jar:Facturacion/Egreso.class */
public class Egreso extends JPanel {
    private String[] listaDx;
    private String[] listaDestino;
    private String[] listaEstado;
    private String sql;
    private ResultSet rs;
    private DefaultTableModel modelo;
    private Facturac frmFacturac;
    private JTableComboBox cboDestino;
    private JTableComboBox cboDxCompli;
    private JTableComboBox cboDxEgrePpal;
    private JTableComboBox cboDxEgreRel1;
    private JTableComboBox cboDxEgreRel2;
    private JTableComboBox cboDxEgreRel3;
    private JTableComboBox cboDxIngPpal;
    private JTableComboBox cboDxIngRel1;
    private JTableComboBox cboDxIngRel2;
    private JTableComboBox cboDxMuerte;
    private JComboBox cboEstado;
    private JLabel jLabel11;
    private JLabel jLabel12;
    private JLabel jLabel13;
    private JLabel jLabel14;
    private JLabel jLabel15;
    private JLabel jLabel16;
    private JLabel jLabel17;
    private JLabel jLabel18;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel8;
    private JLabel jLabel9;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JTextField txtDxCompli;
    private JTextField txtDxEgrePpal;
    private JTextField txtDxEgreRel1;
    private JTextField txtDxEgreRel2;
    private JTextField txtDxEgreRel3;
    private JTextField txtDxIngPpal;
    private JTextField txtDxIngRel1;
    private JTextField txtDxIngRel2;
    private JTextField txtDxMuerte;
    private JTextField txtEstado;
    public JDateChooser txtFechaEgreso;
    public JDateChooser txtHoraEgreso;
    private JTextField txtNoEgreso;
    private Metodos metodos = new Metodos();
    private ConsultasMySQL consultas = new ConsultasMySQL();
    private int cboLleno = 0;
    private int filaCbo = 0;

    public Egreso(Facturac frm) {
        initComponents();
        this.frmFacturac = frm;
        cargarCombos();
        this.txtFechaEgreso.setDate(this.metodos.getFechaActual());
        cargarIngreso();
    }

    public void anular() {
        this.metodos.mostrarMensaje("Este función esta pendiente por desarrollo");
    }

    private void cargarIngreso() {
        this.sql = "SELECT egreso.Id, egreso.FechaEgreso, egreso.HoraEgreso, egreso.DxPpalIngreso, egreso.DxRel1Ingreso, egreso.DxRel2Ingreso, egreso.DxPpalEgreso, egreso.DxRel1Egreso, egreso.DxRel2Egreso, egreso.DxRel3Egreso, egreso.DxComplicacion, f_tipodestinosalida.Nbre, egreso.EstadoSalida, egreso.DxMuerte FROM egreso INNER JOIN f_tipodestinosalida  ON (egreso.Id_TipoDestinoSalida = f_tipodestinosalida.Id) WHERE (egreso.Estado =0 AND egreso.Id_Ingreso ='" + Principal.txtNo.getText() + "')";
        this.rs = this.consultas.traerRs(this.sql);
        try {
            if (this.rs.next()) {
                this.cboDxIngPpal.setSelectedItem(Principal.clasefacturacion.getPatologia(this.rs.getString(4)));
                this.cboDxIngRel1.setSelectedItem(Principal.clasefacturacion.getPatologia(this.rs.getString(5)));
                this.cboDxIngRel2.setSelectedItem(Principal.clasefacturacion.getPatologia(this.rs.getString(6)));
                this.txtNoEgreso.setText(this.rs.getString(1));
                this.txtFechaEgreso.setDate(this.rs.getDate(2));
                this.txtHoraEgreso.setDate(this.rs.getTime(3));
                this.cboDestino.setSelectedItem(Principal.clasefacturacion.getPatologia(this.rs.getString(12)));
                if (this.rs.getInt(13) == 0) {
                    this.cboEstado.setSelectedItem("Vivo");
                } else {
                    this.cboEstado.setSelectedItem("Muerto");
                }
                this.txtEstado.setText("Activo");
                this.cboDxEgrePpal.setSelectedItem(Principal.clasefacturacion.getPatologia(this.rs.getString(7)));
                this.cboDxEgreRel1.setSelectedItem(Principal.clasefacturacion.getPatologia(this.rs.getString(8)));
                this.cboDxEgreRel2.setSelectedItem(Principal.clasefacturacion.getPatologia(this.rs.getString(9)));
                this.cboDxEgreRel3.setSelectedItem(Principal.clasefacturacion.getPatologia(this.rs.getString(10)));
                this.cboDxCompli.setSelectedItem(Principal.clasefacturacion.getPatologia(this.rs.getString(11)));
                this.cboDxMuerte.setSelectedItem(Principal.clasefacturacion.getPatologia(this.rs.getString(14)));
            } else {
                nuevo();
            }
            this.rs.close();
            this.consultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(Egreso.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void cargarCombos() {
        this.sql = "SELECT Id, Nbre FROM g_patologia where Estado=1 ORDER BY Nbre";
        this.consultas.llenarComboTabla(this.sql, this.cboDxIngPpal, this.modelo, 1);
        this.consultas.llenarComboTabla(this.sql, this.cboDxIngRel1, this.modelo, 1);
        this.consultas.llenarComboTabla(this.sql, this.cboDxIngRel2, this.modelo, 1);
        this.consultas.llenarComboTabla(this.sql, this.cboDxEgrePpal, this.modelo, 1);
        this.consultas.llenarComboTabla(this.sql, this.cboDxEgreRel1, this.modelo, 1);
        this.consultas.llenarComboTabla(this.sql, this.cboDxEgreRel2, this.modelo, 1);
        this.consultas.llenarComboTabla(this.sql, this.cboDxEgreRel3, this.modelo, 1);
        this.consultas.llenarComboTabla(this.sql, this.cboDxCompli, this.modelo, 1);
        this.consultas.llenarComboTabla(this.sql, this.cboDxMuerte, this.modelo, 1);
        this.sql = "SELECT Id, Nbre FROM f_tipodestinosalida WHERE (Estado =0) ORDER BY Nbre ASC";
        this.consultas.llenarComboTabla(this.sql, this.cboDestino, this.modelo, 1);
        this.cboLleno = 1;
        this.consultas.cerrarConexionBd();
    }

    private void getDx(int combo) {
        this.sql = "SELECT Nbre FROM g_patologia WHERE Id ='";
        if (combo == 1) {
            this.sql += this.txtDxIngPpal.getText().toUpperCase() + "'";
            this.cboDxIngPpal.setSelectedItem(this.consultas.traerDato(this.sql));
        }
        if (combo == 2) {
            this.sql += this.txtDxIngRel1.getText().toUpperCase() + "'";
            this.cboDxIngRel1.setSelectedItem(this.consultas.traerDato(this.sql));
        }
        if (combo == 3) {
            this.sql += this.txtDxIngRel1.getText().toUpperCase() + "'";
            this.cboDxIngRel2.setSelectedItem(this.consultas.traerDato(this.sql));
        }
        if (combo == 4) {
            this.sql += this.txtDxEgrePpal.getText().toUpperCase() + "'";
            this.cboDxEgrePpal.setSelectedItem(this.consultas.traerDato(this.sql));
        }
        if (combo == 5) {
            this.sql += this.txtDxEgreRel1.getText().toUpperCase() + "'";
            this.cboDxEgreRel1.setSelectedItem(this.consultas.traerDato(this.sql));
        }
        if (combo == 6) {
            this.sql += this.txtDxEgreRel2.getText().toUpperCase() + "'";
            this.cboDxEgreRel2.setSelectedItem(this.consultas.traerDato(this.sql));
        }
        if (combo == 7) {
            this.sql += this.txtDxEgreRel3.getText().toUpperCase() + "'";
            this.cboDxEgreRel3.setSelectedItem(this.consultas.traerDato(this.sql));
        }
        if (combo == 8) {
            this.sql += this.txtDxCompli.getText().toUpperCase() + "'";
            this.cboDxCompli.setSelectedItem(this.consultas.traerDato(this.sql));
        }
        if (combo == 9) {
            this.sql += this.txtDxMuerte.getText().toUpperCase() + "'";
            this.cboDxMuerte.setSelectedItem(this.consultas.traerDato(this.sql));
        }
    }

    public void grabar() {
        if (validarDatos() == 1) {
            grabarEgreso();
        }
    }

    private void grabarEgreso() {
        this.sql = "INSERT INTO egreso(Id_Ingreso, FechaEgreso, HoraEgreso, DxPpalIngreso, DxRel1Ingreso, DxRel2Ingreso, DxPpalEgreso, DxRel1Egreso, DxRel2Egreso, DxRel3Egreso, DxComplicacion, Id_TipoDestinoSalida, Estadosalida, DxMuerte, Fecha, UsuarioS) VALUE('" + Principal.txtNo.getText() + "','" + this.metodos.formatoAMDH24.format(this.txtFechaEgreso.getDate()) + "','" + this.metodos.formatoH24.format(this.txtHoraEgreso.getDate()) + "','" + this.cboDxIngPpal.getPopupTable().getValueAt(this.cboDxIngPpal.getSelectedIndex(), 1) + "','" + this.cboDxIngRel1.getPopupTable().getValueAt(this.cboDxIngRel1.getSelectedIndex(), 1) + "','" + this.cboDxIngRel2.getPopupTable().getValueAt(this.cboDxIngRel2.getSelectedIndex(), 1) + "','" + this.cboDxEgrePpal.getPopupTable().getValueAt(this.cboDxEgrePpal.getSelectedIndex(), 1) + "','" + this.cboDxEgreRel1.getPopupTable().getValueAt(this.cboDxEgreRel1.getSelectedIndex(), 1) + "','" + this.cboDxEgreRel2.getPopupTable().getValueAt(this.cboDxEgreRel2.getSelectedIndex(), 1) + "','" + this.cboDxEgreRel3.getPopupTable().getValueAt(this.cboDxEgreRel3.getSelectedIndex(), 1) + "','" + this.cboDxCompli.getPopupTable().getValueAt(this.cboDxCompli.getSelectedIndex(), 1) + "','" + this.listaDestino[this.cboDestino.getSelectedIndex()] + "','" + this.listaEstado[this.cboEstado.getSelectedIndex()] + "','" + this.cboDxMuerte.getPopupTable().getValueAt(this.cboDxMuerte.getSelectedIndex(), 1) + "','" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "')";
        this.txtNoEgreso.setText(this.consultas.ejecutarSQLId(this.sql));
        this.consultas.cerrarConexionBd();
        if (this.frmFacturac.frmIngreso.getAmbitoAtencion().equals("2")) {
            this.frmFacturac.clasefacturacion.actualizarItemOrden("Egreso");
            this.frmFacturac.clasefacturacion.setCamaDisponible(0);
        }
        this.metodos.mostrarMensaje("Salida Grabada");
    }

    public void nuevo() {
        this.txtDxIngPpal.setText("");
        this.txtDxIngRel1.setText("");
        this.txtDxIngRel2.setText("");
        this.txtNoEgreso.setText("");
        this.txtFechaEgreso.setDate(this.metodos.getFechaActual());
        this.txtHoraEgreso.setDate(this.metodos.getFechaActual());
        this.txtEstado.setText("Activo");
        this.txtDxEgrePpal.setText("");
        this.txtDxEgreRel1.setText("");
        this.txtDxEgreRel2.setText("");
        this.txtDxEgreRel3.setText("");
        this.txtDxCompli.setText("");
        this.txtDxMuerte.setText("");
        this.cboDxIngPpal.setSelectedIndex(-1);
        this.cboDxIngRel1.setSelectedIndex(-1);
        this.cboDxIngRel2.setSelectedIndex(-1);
        this.cboDxEgrePpal.setSelectedIndex(-1);
        this.cboDxEgreRel1.setSelectedIndex(-1);
        this.cboDxEgreRel2.setSelectedIndex(-1);
        this.cboDxCompli.setSelectedIndex(-1);
        this.cboDxMuerte.setSelectedIndex(-1);
        this.cboDestino.setSelectedIndex(-1);
        this.cboEstado.setSelectedIndex(0);
        this.txtDxIngPpal.requestFocus();
    }

    private int validarDatos() {
        int retorno = 0;
        if (Principal.txtNo.getText().isEmpty() || Principal.txtNo.getText() == null) {
            this.metodos.mostrarMensaje("Por favor seleccione un Ingreso para realizar la Salidad");
        } else if (this.txtFechaEgreso.getDate() == null) {
            this.metodos.mostrarMensaje("Por favor seleccione una Fecha de Egreso");
        } else if (this.cboDxIngPpal.getSelectedIndex() < 0) {
            this.metodos.mostrarMensaje("Por favor seleccione el Diagnostico Principal de Ingreso");
        } else if (this.cboDxEgrePpal.getSelectedIndex() < 0) {
            this.metodos.mostrarMensaje("Por favor seleccione el Diagnostico Principal de Egreso");
        } else if (this.cboDestino.getSelectedIndex() < 0) {
            this.metodos.mostrarMensaje("Por favor seleccione un Destino");
        } else if (this.cboEstado.getSelectedIndex() < 0) {
            this.metodos.mostrarMensaje("Por favor seleccione el Estado en que sale el Usuario");
        } else {
            retorno = 1;
        }
        return retorno;
    }

    private void initComponents() {
        this.jPanel2 = new JPanel();
        this.jLabel8 = new JLabel();
        this.jLabel9 = new JLabel();
        this.jLabel11 = new JLabel();
        this.txtDxIngRel2 = new JTextField();
        this.txtDxIngPpal = new JTextField();
        this.txtDxIngRel1 = new JTextField();
        try {
            this.cboDxIngRel2 = new JTableComboBox();
        } catch (IncompatibleLookAndFeelException e1) {
            e1.printStackTrace();
        }
        try {
            this.cboDxIngPpal = new JTableComboBox();
        } catch (IncompatibleLookAndFeelException e12) {
            e12.printStackTrace();
        }
        try {
            this.cboDxIngRel1 = new JTableComboBox();
        } catch (IncompatibleLookAndFeelException e13) {
            e13.printStackTrace();
        }
        this.jPanel1 = new JPanel();
        this.jLabel2 = new JLabel();
        this.jLabel3 = new JLabel();
        this.jLabel4 = new JLabel();
        this.jLabel5 = new JLabel();
        this.jLabel6 = new JLabel();
        this.txtNoEgreso = new JTextField();
        this.txtEstado = new JTextField();
        this.jLabel12 = new JLabel();
        this.jLabel13 = new JLabel();
        this.jLabel14 = new JLabel();
        this.jLabel15 = new JLabel();
        this.jLabel16 = new JLabel();
        this.cboEstado = new JComboBox();
        this.jLabel17 = new JLabel();
        this.jLabel18 = new JLabel();
        this.txtDxEgreRel1 = new JTextField();
        this.txtDxEgreRel2 = new JTextField();
        this.txtDxEgreRel3 = new JTextField();
        this.txtDxCompli = new JTextField();
        this.txtDxMuerte = new JTextField();
        try {
            this.cboDxMuerte = new JTableComboBox();
        } catch (IncompatibleLookAndFeelException e14) {
            e14.printStackTrace();
        }
        try {
            this.cboDxEgrePpal = new JTableComboBox();
        } catch (IncompatibleLookAndFeelException e15) {
            e15.printStackTrace();
        }
        try {
            this.cboDxEgreRel1 = new JTableComboBox();
        } catch (IncompatibleLookAndFeelException e16) {
            e16.printStackTrace();
        }
        try {
            this.cboDxEgreRel2 = new JTableComboBox();
        } catch (IncompatibleLookAndFeelException e17) {
            e17.printStackTrace();
        }
        try {
            this.cboDxEgreRel3 = new JTableComboBox();
        } catch (IncompatibleLookAndFeelException e18) {
            e18.printStackTrace();
        }
        try {
            this.cboDxCompli = new JTableComboBox();
        } catch (IncompatibleLookAndFeelException e19) {
            e19.printStackTrace();
        }
        this.txtDxEgrePpal = new JTextField();
        this.txtFechaEgreso = new JDateChooser();
        this.txtHoraEgreso = new JDateChooser();
        try {
            this.cboDestino = new JTableComboBox();
        } catch (IncompatibleLookAndFeelException e110) {
            e110.printStackTrace();
        }
        setName("Egreso");
        setLayout(new AbsoluteLayout());
        this.jPanel2.setBorder(BorderFactory.createTitledBorder((Border) null, "Datos del Ingreso", 0, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.jPanel2.setLayout(new AbsoluteLayout());
        this.jLabel8.setFont(new Font("Arial", 1, 12));
        this.jLabel8.setForeground(Color.blue);
        this.jLabel8.setText("Diagnóstico Principal");
        this.jPanel2.add(this.jLabel8, new AbsoluteConstraints(10, 30, 130, -1));
        this.jLabel9.setFont(new Font("Arial", 1, 12));
        this.jLabel9.setForeground(Color.blue);
        this.jLabel9.setText("Diagnóstico Relacional No. 1 ");
        this.jPanel2.add(this.jLabel9, new AbsoluteConstraints(10, 70, 180, -1));
        this.jLabel11.setFont(new Font("Arial", 1, 12));
        this.jLabel11.setForeground(Color.blue);
        this.jLabel11.setText("Diagnóstico Relacional No. 2");
        this.jPanel2.add(this.jLabel11, new AbsoluteConstraints(590, 70, 180, -1));
        this.txtDxIngRel2.setFont(new Font("Arial", 1, 12));
        this.txtDxIngRel2.addActionListener(new ActionListener() { // from class: Facturacion.Egreso.1
            public void actionPerformed(ActionEvent evt) {
                Egreso.this.txtDxIngRel2ActionPerformed(evt);
            }
        });
        this.txtDxIngRel2.addFocusListener(new FocusAdapter() { // from class: Facturacion.Egreso.2
            public void focusGained(FocusEvent evt) {
                Egreso.this.txtDxIngRel2FocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                Egreso.this.txtDxIngRel2FocusLost(evt);
            }
        });
        this.jPanel2.add(this.txtDxIngRel2, new AbsoluteConstraints(590, 90, 110, 30));
        this.txtDxIngPpal.setFont(new Font("Arial", 1, 12));
        this.txtDxIngPpal.addActionListener(new ActionListener() { // from class: Facturacion.Egreso.3
            public void actionPerformed(ActionEvent evt) {
                Egreso.this.txtDxIngPpalActionPerformed(evt);
            }
        });
        this.txtDxIngPpal.addFocusListener(new FocusAdapter() { // from class: Facturacion.Egreso.4
            public void focusGained(FocusEvent evt) {
                Egreso.this.txtDxIngPpalFocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                Egreso.this.txtDxIngPpalFocusLost(evt);
            }
        });
        this.jPanel2.add(this.txtDxIngPpal, new AbsoluteConstraints(140, 20, 110, 30));
        this.txtDxIngRel1.setFont(new Font("Arial", 1, 12));
        this.txtDxIngRel1.addActionListener(new ActionListener() { // from class: Facturacion.Egreso.5
            public void actionPerformed(ActionEvent evt) {
                Egreso.this.txtDxIngRel1ActionPerformed(evt);
            }
        });
        this.txtDxIngRel1.addFocusListener(new FocusAdapter() { // from class: Facturacion.Egreso.6
            public void focusGained(FocusEvent evt) {
                Egreso.this.txtDxIngRel1FocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                Egreso.this.txtDxIngRel1FocusLost(evt);
            }
        });
        this.jPanel2.add(this.txtDxIngRel1, new AbsoluteConstraints(10, 90, 110, 30));
        this.cboDxIngRel2.setFont(new Font("Arial", 1, 12));
        this.cboDxIngRel2.addItemListener(new ItemListener() { // from class: Facturacion.Egreso.7
            public void itemStateChanged(ItemEvent evt) {
                Egreso.this.cboDxIngRel2ItemStateChanged(evt);
            }
        });
        this.jPanel2.add(this.cboDxIngRel2, new AbsoluteConstraints(710, 90, 440, 30));
        this.cboDxIngPpal.setFont(new Font("Arial", 1, 12));
        this.cboDxIngPpal.addItemListener(new ItemListener() { // from class: Facturacion.Egreso.8
            public void itemStateChanged(ItemEvent evt) {
                Egreso.this.cboDxIngPpalItemStateChanged(evt);
            }
        });
        this.jPanel2.add(this.cboDxIngPpal, new AbsoluteConstraints(260, 20, 890, 30));
        this.cboDxIngRel1.setFont(new Font("Arial", 1, 12));
        this.cboDxIngRel1.addItemListener(new ItemListener() { // from class: Facturacion.Egreso.9
            public void itemStateChanged(ItemEvent evt) {
                Egreso.this.cboDxIngRel1ItemStateChanged(evt);
            }
        });
        this.jPanel2.add(this.cboDxIngRel1, new AbsoluteConstraints(130, 90, 450, 30));
        add(this.jPanel2, new AbsoluteConstraints(0, 0, 1170, 130));
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "Datos del Egreso", 0, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.jPanel1.setLayout(new AbsoluteLayout());
        this.jLabel2.setFont(new Font("Arial", 1, 14));
        this.jLabel2.setForeground(new Color(0, 0, 255));
        this.jLabel2.setText("No.");
        this.jPanel1.add(this.jLabel2, new AbsoluteConstraints(10, 20, 50, -1));
        this.jLabel3.setFont(new Font("Arial", 1, 12));
        this.jLabel3.setForeground(Color.blue);
        this.jLabel3.setText("Estado en que Sale");
        this.jPanel1.add(this.jLabel3, new AbsoluteConstraints(720, 20, 110, -1));
        this.jLabel4.setFont(new Font("Arial", 1, 12));
        this.jLabel4.setForeground(Color.blue);
        this.jLabel4.setText("Diagnóstico Relacional No. 1 ");
        this.jPanel1.add(this.jLabel4, new AbsoluteConstraints(590, 80, 180, -1));
        this.jLabel5.setFont(new Font("Arial", 1, 12));
        this.jLabel5.setForeground(Color.blue);
        this.jLabel5.setText("Hora");
        this.jPanel1.add(this.jLabel5, new AbsoluteConstraints(210, 20, 70, -1));
        this.jLabel6.setFont(new Font("Arial", 1, 12));
        this.jLabel6.setForeground(Color.blue);
        this.jLabel6.setText("Diagnóstico Relacional No. 2");
        this.jPanel1.add(this.jLabel6, new AbsoluteConstraints(10, 140, 190, -1));
        this.txtNoEgreso.setBackground(new Color(0, 0, 153));
        this.txtNoEgreso.setFont(new Font("Arial", 1, 12));
        this.txtNoEgreso.setHorizontalAlignment(4);
        this.txtNoEgreso.setDisabledTextColor(new Color(255, 255, 255));
        this.txtNoEgreso.setEnabled(false);
        this.jPanel1.add(this.txtNoEgreso, new AbsoluteConstraints(10, 40, 80, 30));
        this.txtEstado.setBackground(new Color(0, 0, 153));
        this.txtEstado.setFont(new Font("Arial", 1, 12));
        this.txtEstado.setHorizontalAlignment(0);
        this.txtEstado.setDisabledTextColor(new Color(255, 255, 255));
        this.txtEstado.setEnabled(false);
        this.jPanel1.add(this.txtEstado, new AbsoluteConstraints(860, 40, 120, 30));
        this.jLabel12.setFont(new Font("Arial", 1, 12));
        this.jLabel12.setForeground(Color.blue);
        this.jLabel12.setText("Diagnóstico Relacional No. 3");
        this.jPanel1.add(this.jLabel12, new AbsoluteConstraints(590, 140, 180, -1));
        this.jLabel13.setFont(new Font("Arial", 1, 12));
        this.jLabel13.setForeground(Color.blue);
        this.jLabel13.setText("Diagnóstico  de Muerte");
        this.jPanel1.add(this.jLabel13, new AbsoluteConstraints(590, 200, 190, -1));
        this.jLabel14.setFont(new Font("Arial", 1, 12));
        this.jLabel14.setForeground(Color.blue);
        this.jLabel14.setText("Diagnóstico  de Complicaciones");
        this.jPanel1.add(this.jLabel14, new AbsoluteConstraints(10, 200, 190, -1));
        this.jLabel15.setFont(new Font("Arial", 1, 12));
        this.jLabel15.setForeground(Color.blue);
        this.jLabel15.setText("Tipo de Destino");
        this.jPanel1.add(this.jLabel15, new AbsoluteConstraints(330, 20, 150, -1));
        this.jLabel16.setFont(new Font("Arial", 1, 12));
        this.jLabel16.setForeground(Color.blue);
        this.jLabel16.setText("Estado de la Orden");
        this.jPanel1.add(this.jLabel16, new AbsoluteConstraints(860, 20, 120, -1));
        this.cboEstado.setFont(new Font("Arial", 1, 12));
        this.cboEstado.setModel(new DefaultComboBoxModel(new String[]{"Vivo", "Muerto"}));
        this.jPanel1.add(this.cboEstado, new AbsoluteConstraints(720, 40, 120, 30));
        this.jLabel17.setFont(new Font("Arial", 1, 12));
        this.jLabel17.setForeground(Color.blue);
        this.jLabel17.setText("Diagnóstico Principal");
        this.jPanel1.add(this.jLabel17, new AbsoluteConstraints(10, 80, 170, 20));
        this.jLabel18.setFont(new Font("Arial", 1, 12));
        this.jLabel18.setForeground(Color.blue);
        this.jLabel18.setText("Fecha");
        this.jPanel1.add(this.jLabel18, new AbsoluteConstraints(100, 20, 50, -1));
        this.txtDxEgreRel1.setFont(new Font("Arial", 1, 12));
        this.txtDxEgreRel1.addActionListener(new ActionListener() { // from class: Facturacion.Egreso.10
            public void actionPerformed(ActionEvent evt) {
                Egreso.this.txtDxEgreRel1ActionPerformed(evt);
            }
        });
        this.txtDxEgreRel1.addFocusListener(new FocusAdapter() { // from class: Facturacion.Egreso.11
            public void focusGained(FocusEvent evt) {
                Egreso.this.txtDxEgreRel1FocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                Egreso.this.txtDxEgreRel1FocusLost(evt);
            }
        });
        this.jPanel1.add(this.txtDxEgreRel1, new AbsoluteConstraints(590, 100, 110, 30));
        this.txtDxEgreRel2.setFont(new Font("Arial", 1, 12));
        this.txtDxEgreRel2.addActionListener(new ActionListener() { // from class: Facturacion.Egreso.12
            public void actionPerformed(ActionEvent evt) {
                Egreso.this.txtDxEgreRel2ActionPerformed(evt);
            }
        });
        this.txtDxEgreRel2.addFocusListener(new FocusAdapter() { // from class: Facturacion.Egreso.13
            public void focusGained(FocusEvent evt) {
                Egreso.this.txtDxEgreRel2FocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                Egreso.this.txtDxEgreRel2FocusLost(evt);
            }
        });
        this.jPanel1.add(this.txtDxEgreRel2, new AbsoluteConstraints(10, 160, 110, 30));
        this.txtDxEgreRel3.setFont(new Font("Arial", 1, 12));
        this.txtDxEgreRel3.addActionListener(new ActionListener() { // from class: Facturacion.Egreso.14
            public void actionPerformed(ActionEvent evt) {
                Egreso.this.txtDxEgreRel3ActionPerformed(evt);
            }
        });
        this.txtDxEgreRel3.addFocusListener(new FocusAdapter() { // from class: Facturacion.Egreso.15
            public void focusGained(FocusEvent evt) {
                Egreso.this.txtDxEgreRel3FocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                Egreso.this.txtDxEgreRel3FocusLost(evt);
            }
        });
        this.jPanel1.add(this.txtDxEgreRel3, new AbsoluteConstraints(590, 160, 110, 30));
        this.txtDxCompli.setFont(new Font("Arial", 1, 12));
        this.txtDxCompli.addActionListener(new ActionListener() { // from class: Facturacion.Egreso.16
            public void actionPerformed(ActionEvent evt) {
                Egreso.this.txtDxCompliActionPerformed(evt);
            }
        });
        this.txtDxCompli.addFocusListener(new FocusAdapter() { // from class: Facturacion.Egreso.17
            public void focusGained(FocusEvent evt) {
                Egreso.this.txtDxCompliFocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                Egreso.this.txtDxCompliFocusLost(evt);
            }
        });
        this.jPanel1.add(this.txtDxCompli, new AbsoluteConstraints(10, 220, 110, 30));
        this.txtDxMuerte.setFont(new Font("Arial", 1, 12));
        this.txtDxMuerte.addActionListener(new ActionListener() { // from class: Facturacion.Egreso.18
            public void actionPerformed(ActionEvent evt) {
                Egreso.this.txtDxMuerteActionPerformed(evt);
            }
        });
        this.txtDxMuerte.addFocusListener(new FocusAdapter() { // from class: Facturacion.Egreso.19
            public void focusGained(FocusEvent evt) {
                Egreso.this.txtDxMuerteFocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                Egreso.this.txtDxMuerteFocusLost(evt);
            }
        });
        this.jPanel1.add(this.txtDxMuerte, new AbsoluteConstraints(590, 220, 110, 30));
        this.cboDxMuerte.setFont(new Font("Arial", 1, 12));
        this.cboDxMuerte.addItemListener(new ItemListener() { // from class: Facturacion.Egreso.20
            public void itemStateChanged(ItemEvent evt) {
                Egreso.this.cboDxMuerteItemStateChanged(evt);
            }
        });
        this.jPanel1.add(this.cboDxMuerte, new AbsoluteConstraints(710, 220, 440, 30));
        this.cboDxEgrePpal.setFont(new Font("Arial", 1, 12));
        this.cboDxEgrePpal.addItemListener(new ItemListener() { // from class: Facturacion.Egreso.21
            public void itemStateChanged(ItemEvent evt) {
                Egreso.this.cboDxEgrePpalItemStateChanged(evt);
            }
        });
        this.jPanel1.add(this.cboDxEgrePpal, new AbsoluteConstraints(130, 100, 450, 30));
        this.cboDxEgreRel1.setFont(new Font("Arial", 1, 12));
        this.cboDxEgreRel1.addItemListener(new ItemListener() { // from class: Facturacion.Egreso.22
            public void itemStateChanged(ItemEvent evt) {
                Egreso.this.cboDxEgreRel1ItemStateChanged(evt);
            }
        });
        this.jPanel1.add(this.cboDxEgreRel1, new AbsoluteConstraints(710, 100, 440, 30));
        this.cboDxEgreRel2.setFont(new Font("Arial", 1, 12));
        this.cboDxEgreRel2.addItemListener(new ItemListener() { // from class: Facturacion.Egreso.23
            public void itemStateChanged(ItemEvent evt) {
                Egreso.this.cboDxEgreRel2ItemStateChanged(evt);
            }
        });
        this.jPanel1.add(this.cboDxEgreRel2, new AbsoluteConstraints(130, 160, 440, 30));
        this.cboDxEgreRel3.setFont(new Font("Arial", 1, 12));
        this.cboDxEgreRel3.addItemListener(new ItemListener() { // from class: Facturacion.Egreso.24
            public void itemStateChanged(ItemEvent evt) {
                Egreso.this.cboDxEgreRel3ItemStateChanged(evt);
            }
        });
        this.jPanel1.add(this.cboDxEgreRel3, new AbsoluteConstraints(710, 160, 440, 30));
        this.cboDxCompli.setFont(new Font("Arial", 1, 12));
        this.cboDxCompli.addItemListener(new ItemListener() { // from class: Facturacion.Egreso.25
            public void itemStateChanged(ItemEvent evt) {
                Egreso.this.cboDxCompliItemStateChanged(evt);
            }
        });
        this.jPanel1.add(this.cboDxCompli, new AbsoluteConstraints(130, 220, 440, 30));
        this.txtDxEgrePpal.setFont(new Font("Arial", 1, 12));
        this.txtDxEgrePpal.addActionListener(new ActionListener() { // from class: Facturacion.Egreso.26
            public void actionPerformed(ActionEvent evt) {
                Egreso.this.txtDxEgrePpalActionPerformed(evt);
            }
        });
        this.txtDxEgrePpal.addFocusListener(new FocusAdapter() { // from class: Facturacion.Egreso.27
            public void focusGained(FocusEvent evt) {
                Egreso.this.txtDxEgrePpalFocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                Egreso.this.txtDxEgrePpalFocusLost(evt);
            }
        });
        this.jPanel1.add(this.txtDxEgrePpal, new AbsoluteConstraints(10, 100, 110, 30));
        this.txtFechaEgreso.setDateFormatString("dd/MM/yyyy");
        this.txtFechaEgreso.setFont(new Font("Arial", 1, 12));
        this.jPanel1.add(this.txtFechaEgreso, new AbsoluteConstraints(100, 40, 100, 30));
        this.txtHoraEgreso.setDateFormatString("hh:mm:ss a");
        this.txtHoraEgreso.setFont(new Font("Arial", 1, 12));
        this.jPanel1.add(this.txtHoraEgreso, new AbsoluteConstraints(210, 40, 110, 30));
        this.cboDestino.setFont(new Font("Arial", 1, 12));
        this.jPanel1.add(this.cboDestino, new AbsoluteConstraints(330, 40, 380, 30));
        add(this.jPanel1, new AbsoluteConstraints(0, 130, 1170, 270));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtDxIngRel2ActionPerformed(ActionEvent evt) {
        this.cboDxIngRel2.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtDxIngRel2FocusGained(FocusEvent evt) {
        this.txtDxIngRel2.selectAll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtDxIngRel2FocusLost(FocusEvent evt) {
        getDx(3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtDxIngPpalActionPerformed(ActionEvent evt) {
        this.cboDxIngPpal.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtDxIngPpalFocusGained(FocusEvent evt) {
        this.txtDxIngPpal.selectAll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtDxIngPpalFocusLost(FocusEvent evt) {
        getDx(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtDxIngRel1ActionPerformed(ActionEvent evt) {
        this.cboDxIngRel1.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtDxIngRel1FocusGained(FocusEvent evt) {
        this.txtDxIngRel1.selectAll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtDxIngRel1FocusLost(FocusEvent evt) {
        getDx(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboDxIngRel2ItemStateChanged(ItemEvent evt) {
        this.filaCbo = this.cboDxIngRel2.getPopupTable().getSelectedRow();
        this.txtDxIngRel2.setText(this.cboDxIngRel2.getPopupTable().getValueAt(this.filaCbo, 0).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboDxIngPpalItemStateChanged(ItemEvent evt) {
        this.filaCbo = this.cboDxIngPpal.getPopupTable().getSelectedRow();
        this.txtDxIngPpal.setText(this.cboDxIngPpal.getPopupTable().getValueAt(this.filaCbo, 0).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboDxIngRel1ItemStateChanged(ItemEvent evt) {
        this.filaCbo = this.cboDxIngRel1.getPopupTable().getSelectedRow();
        this.txtDxIngRel1.setText(this.cboDxIngRel1.getPopupTable().getValueAt(this.filaCbo, 0).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtDxEgreRel1ActionPerformed(ActionEvent evt) {
        this.cboDxEgreRel1.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtDxEgreRel1FocusGained(FocusEvent evt) {
        this.txtDxEgreRel1.selectAll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtDxEgreRel1FocusLost(FocusEvent evt) {
        getDx(5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtDxEgreRel2ActionPerformed(ActionEvent evt) {
        this.cboDxEgreRel2.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtDxEgreRel2FocusGained(FocusEvent evt) {
        this.txtDxEgreRel2.selectAll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtDxEgreRel2FocusLost(FocusEvent evt) {
        getDx(6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtDxEgreRel3ActionPerformed(ActionEvent evt) {
        this.cboDxEgreRel3.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtDxEgreRel3FocusGained(FocusEvent evt) {
        this.txtDxEgreRel3.selectAll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtDxEgreRel3FocusLost(FocusEvent evt) {
        getDx(7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtDxCompliActionPerformed(ActionEvent evt) {
        this.cboDxCompli.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtDxCompliFocusGained(FocusEvent evt) {
        this.txtDxCompli.selectAll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtDxCompliFocusLost(FocusEvent evt) {
        getDx(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtDxMuerteActionPerformed(ActionEvent evt) {
        this.cboDxMuerte.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtDxMuerteFocusGained(FocusEvent evt) {
        this.txtDxMuerte.selectAll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtDxMuerteFocusLost(FocusEvent evt) {
        getDx(9);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboDxMuerteItemStateChanged(ItemEvent evt) {
        this.filaCbo = this.cboDxMuerte.getPopupTable().getSelectedRow();
        this.txtDxMuerte.setText(this.cboDxMuerte.getPopupTable().getValueAt(this.filaCbo, 0).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboDxEgrePpalItemStateChanged(ItemEvent evt) {
        this.filaCbo = this.cboDxEgrePpal.getPopupTable().getSelectedRow();
        this.txtDxEgrePpal.setText(this.cboDxEgrePpal.getPopupTable().getValueAt(this.filaCbo, 0).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboDxEgreRel1ItemStateChanged(ItemEvent evt) {
        this.filaCbo = this.cboDxEgreRel1.getPopupTable().getSelectedRow();
        this.txtDxEgreRel1.setText(this.cboDxEgreRel1.getPopupTable().getValueAt(this.filaCbo, 0).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboDxEgreRel2ItemStateChanged(ItemEvent evt) {
        this.filaCbo = this.cboDxEgreRel2.getPopupTable().getSelectedRow();
        this.txtDxEgreRel2.setText(this.cboDxEgreRel2.getPopupTable().getValueAt(this.filaCbo, 0).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboDxEgreRel3ItemStateChanged(ItemEvent evt) {
        this.filaCbo = this.cboDxEgreRel3.getPopupTable().getSelectedRow();
        this.txtDxEgreRel3.setText(this.cboDxEgreRel3.getPopupTable().getValueAt(this.filaCbo, 0).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboDxCompliItemStateChanged(ItemEvent evt) {
        this.filaCbo = this.cboDxCompli.getPopupTable().getSelectedRow();
        this.txtDxCompli.setText(this.cboDxCompli.getPopupTable().getValueAt(this.filaCbo, 0).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtDxEgrePpalActionPerformed(ActionEvent evt) {
        this.cboDxEgrePpal.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtDxEgrePpalFocusGained(FocusEvent evt) {
        this.txtDxEgrePpal.selectAll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtDxEgrePpalFocusLost(FocusEvent evt) {
        getDx(4);
    }
}
