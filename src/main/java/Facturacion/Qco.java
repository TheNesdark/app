package Facturacion;

import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.jdnc.incubator.jxcombobox.IncompatibleLookAndFeelException;
import org.jdesktop.jdnc.incubator.jxcombobox.JTableComboBox;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

/* JADX INFO: loaded from: GenomaP.jar:Facturacion/Qco.class */
public class Qco extends JInternalFrame {
    private int filaGrid;
    private int cboLleno;
    private int filaVrDet;
    private String sql;
    private String tipoServicio;
    private String idEmpresa;
    private DefaultTableModel modelo;
    private Facturac frmFacturac;
    private int[] Valores;
    private long[][] vrDetallado;
    private JRadioButton btnBilateralNo;
    private JRadioButton btnBilateralSi;
    private JButton btnCargar;
    private JRadioButton btnDiferenteVia;
    private JRadioButton btnIgualVia;
    private JButton btnLiquidar;
    private ButtonGroup buttonGroup1;
    private ButtonGroup buttonGroup2;
    private JTableComboBox cboAnestesiologo;
    private JTableComboBox cboAyudante;
    private JTableComboBox cboCC;
    private JTableComboBox cboCirugia;
    private JTableComboBox cboCirujano;
    private JTableComboBox cboDxCompli;
    private JTableComboBox cboDxPrincipal;
    private JTableComboBox cboDxRel;
    private JTableComboBox cboEspecialidad;
    private JTableComboBox cboPerfusionista;
    private JTableComboBox cboTipoAnestesia;
    private JTableComboBox cboTipoSala;
    private JTableComboBox cboTipoServicio;
    private JCheckBox chAnestesiologo;
    private JCheckBox chAyudante;
    private JCheckBox chCirugia;
    private JCheckBox chMateriales;
    private JCheckBox chPerfusionista;
    private JCheckBox chSala;
    private JTable grid;
    private JLabel jLabel1;
    private JLabel jLabel10;
    private JLabel jLabel11;
    private JLabel jLabel12;
    private JLabel jLabel13;
    private JLabel jLabel14;
    private JLabel jLabel15;
    private JLabel jLabel16;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JLabel jLabel9;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JPanel jPanel5;
    private JPanel jPanel6;
    private JPanel jPanel7;
    private JPanel jPanel8;
    private JPanel jPanel9;
    private JScrollPane jScrollPane1;
    private JTabbedPane jTabbedPane1;
    private JPanel panelDatos;
    private JTextField txtCirugia;
    private JTextField txtDxCompli;
    private JTextField txtDxPpal;
    private JTextField txtDxRel;
    private JDateChooser txtFecha;
    private JFormattedTextField txtHoraFin;
    private JFormattedTextField txtHoraIni;
    private JFormattedTextField txtValorMateriales;
    private JFormattedTextField txtVrAnestesiologo;
    private JFormattedTextField txtVrAyudante;
    private JFormattedTextField txtVrHonorarios;
    private JFormattedTextField txtVrPerfusionista;
    private JFormattedTextField txtVrSala;
    private JFormattedTextField txtVrTotal;
    private Metodos metodos = new Metodos();
    private ConsultasMySQL consultas = new ConsultasMySQL();
    private Object[] dato = {"", "", "", "", "", "", "", "", "", "", new Long(0), new Long(0), new Long(0), new Long(0), new Long(0), new Long(0), new Long(0), new Integer(0), "", new Integer(0), new Long(0), new Long(0), new Long(0), new Long(0), new Long(0), new Long(0)};
    private int viaAcceso = 0;
    private int bilateral = 0;

    public Qco(Facturac frmF, String IdEmpresa) {
        this.frmFacturac = null;
        initComponents();
        this.frmFacturac = frmF;
        initComponents();
        this.txtFecha.setDate(this.metodos.getFechaActual());
        this.txtHoraIni.setValue(this.metodos.getFechaActual());
        this.idEmpresa = IdEmpresa;
        cargarCombos();
        cargarTipoCobro();
        this.grid.addMouseListener(new MouseAdapter() { // from class: Facturacion.Qco.1
            public void mouseClicked(MouseEvent e) {
                Qco.this.filaGrid = Qco.this.grid.rowAtPoint(e.getPoint());
                Qco.this.cargarDatosDelGrid();
            }
        });
        crearGrid();
    }

    public void anular() {
        this.metodos.mostrarMensaje("Opción pendiente");
    }

    private void bajarCirugiaAlGrid() {
        if (this.cboTipoSala.getSelectedIndex() < 0) {
            this.metodos.mostrarMensaje("Por Favor seleccione el Tipo de Sala");
            this.cboTipoSala.requestFocus();
            return;
        }
        if (this.cboEspecialidad.getSelectedIndex() < 0) {
            this.metodos.mostrarMensaje("Por Favor seleccione la Especialida del Cirujano");
            this.cboEspecialidad.requestFocus();
            return;
        }
        if (this.cboCirujano.getSelectedIndex() < 0) {
            this.metodos.mostrarMensaje("Por Favor seleccione el Cirujano que intervendrá en la Cirugía");
            this.cboCirujano.requestFocus();
            return;
        }
        if (this.cboCirugia.getSelectedIndex() < 0) {
            this.metodos.mostrarMensaje("Por Favor seleccione la Cirugía que se Practicó");
            this.cboCirugia.requestFocus();
            return;
        }
        if (this.cboDxPrincipal.getSelectedIndex() < 0) {
            this.metodos.mostrarMensaje("Por Favor seleccione el Diagnostico Principal de la Cirugía");
            this.cboDxPrincipal.requestFocus();
            return;
        }
        this.modelo.addRow(this.dato);
        this.modelo.setValueAt(this.txtCirugia.getText(), this.filaGrid, 0);
        this.modelo.setValueAt(this.cboCirugia.getSelectedItem(), this.filaGrid, 1);
        this.modelo.setValueAt(this.cboCirugia.getPopupTable().getValueAt(this.cboCirugia.getSelectedIndex(), 3), this.filaGrid, 2);
        this.modelo.setValueAt(this.cboEspecialidad.getPopupTable().getValueAt(this.cboEspecialidad.getSelectedIndex(), 1), this.filaGrid, 3);
        this.modelo.setValueAt(this.cboCirujano.getPopupTable().getValueAt(this.cboCirujano.getSelectedIndex(), 1), this.filaGrid, 4);
        if (this.viaAcceso == 0) {
            this.modelo.setValueAt("Igual", this.filaGrid, 5);
        } else {
            this.modelo.setValueAt("Diferente", this.filaGrid, 5);
        }
        if (this.bilateral == 0) {
            this.modelo.setValueAt("No", this.filaGrid, 6);
        } else {
            this.modelo.setValueAt("Si", this.filaGrid, 6);
        }
        this.modelo.setValueAt(this.txtDxPpal.getText(), this.filaGrid, 7);
        this.modelo.setValueAt(this.txtDxRel.getText(), this.filaGrid, 8);
        this.modelo.setValueAt(this.txtDxCompli.getText(), this.filaGrid, 9);
        this.modelo.setValueAt(this.cboCirugia.getPopupTable().getValueAt(this.cboCirugia.getSelectedIndex(), 6), this.filaGrid, 16);
        this.modelo.setValueAt(this.cboEspecialidad.getPopupTable().getValueAt(this.cboEspecialidad.getSelectedIndex(), 0), this.filaGrid, 17);
        cargarValores();
        ordenarGrid();
        liquidar();
        this.filaGrid++;
    }

    private String buscar(String tabla, String id) {
        this.sql = "SELECT Nbre FROM " + tabla + " WHERE Id ='" + id + "'";
        return this.consultas.traerDato(this.sql);
    }

    private void cargarValores() {
        this.sql = "SELECT MedEsp, Anestesia, Ayudante, Sala, Material, Perfusion FROM  q_grupouvr WHERE (Id ='" + this.cboCirugia.getPopupTable().getValueAt(this.cboCirugia.getSelectedIndex(), 5) + "')";
        ResultSet rs = this.consultas.traerRs(this.sql);
        while (rs.next()) {
            try {
                if (this.Valores[1] == 0) {
                    int col = 10;
                    for (int fila = 1; fila < 7; fila++) {
                        long valor = Long.parseLong(rs.getString(fila).toString()) * Long.parseLong(this.cboCirugia.getPopupTable().getValueAt(this.cboCirugia.getSelectedIndex(), 4).toString());
                        this.modelo.setValueAt(Long.valueOf(valor), this.filaGrid, col);
                        col++;
                    }
                } else {
                    if (!rs.getString(1).equals("0")) {
                        cargarHonorario(rs.getString(1), 10);
                    }
                    if (!rs.getString(2).equals("0")) {
                        cargarHonorario(rs.getString(2), 11);
                    }
                    if (!rs.getString(3).equals("0")) {
                        cargarHonorario(rs.getString(3), 12);
                    }
                    if (!rs.getString(4).equals("0")) {
                        cargarHonorario(rs.getString(4), 13);
                    }
                    if (!rs.getString(5).equals("0")) {
                        cargarHonorario(rs.getString(5), 14);
                    }
                    if (!rs.getString(6).equals("0")) {
                        cargarHonorario(rs.getString(6), 15);
                    }
                }
            } catch (SQLException ex) {
                this.consultas.mostrarErrorSQL(ex);
                return;
            }
        }
        rs.close();
        this.consultas.cerrarConexionBd();
    }

    private void cargarHonorario(String idProce, int col) {
        try {
            this.sql = "SELECT f_tarifaprocedimiento.VrMinimo, f_tarifaprocedimiento.VrMaximo, f_empresacontxconvenio.CualValor FROM baseserver.f_empresacontxconvenio INNER JOIN baseserver.f_tarifaprocedimiento ON (f_empresacontxconvenio.Id_Manual = f_tarifaprocedimiento.Id_Manual) WHERE (f_tarifaprocedimiento.Id_Procedimiento ='" + idProce + "' AND f_empresacontxconvenio.Id ='" + this.idEmpresa + "')";
            ResultSet rs1 = this.consultas.traerRs(this.sql);
            if (rs1.next()) {
                if (rs1.getString(3).equals("0")) {
                    if (rs1.getString(1) != null) {
                        this.modelo.setValueAt(rs1.getString(1), this.filaGrid, col);
                    } else {
                        this.modelo.setValueAt(Double.valueOf(0.0d), this.filaGrid, col);
                    }
                } else if (rs1.getString(2) != null) {
                    this.modelo.setValueAt(rs1.getString(2), this.filaGrid, col);
                } else {
                    this.modelo.setValueAt(Double.valueOf(0.0d), this.filaGrid, col);
                }
                this.modelo.setValueAt(this.cboCirujano.getPopupTable().getValueAt(this.cboCirujano.getSelectedIndex(), 0), this.filaGrid, 25);
            }
            rs1.close();
            this.consultas.cerrarConexionBd();
        } catch (SQLException ex) {
            this.consultas.mostrarErrorSQL(ex);
        }
    }

    private void cargarTipoCobro() {
        this.sql = "SELECT q_tipomanualqx.Id, q_tipomanualqx.Medico, q_tipomanualqx.Anestesia, q_tipomanualqx.Ayudante, q_tipomanualqx.Sala, q_tipomanualqx.Materia, q_tipomanualqx.Perfusion FROM  baseserver.f_manual INNER JOIN baseserver.q_tipomanualqx ON (f_manual.Id_TipoManQx = q_tipomanualqx.Id) INNER JOIN baseserver.f_empresacontxconvenio ON (f_empresacontxconvenio.Id_Manual = f_manual.Id) WHERE (f_empresacontxconvenio.Id ='" + this.idEmpresa + "')";
        ResultSet rs = this.consultas.traerRs(this.sql);
        try {
            if (rs.next()) {
                this.Valores = new int[7];
                this.Valores[0] = rs.getInt(1);
                this.Valores[1] = rs.getInt(2);
                this.Valores[2] = rs.getInt(3);
                this.Valores[3] = rs.getInt(4);
                this.Valores[4] = rs.getInt(5);
                this.Valores[5] = rs.getInt(6);
                this.Valores[6] = rs.getInt(7);
            }
            rs.close();
            this.consultas.cerrarConexionBd();
        } catch (SQLException ex) {
            this.consultas.mostrarErrorSQL(ex);
        }
    }

    private void cargarCombos() {
        this.sql = "SELECT Id, Nbre FROM f_tiposervicio WHERE (Estado =0 AND TipoServicio IN(4,5)) ORDER BY Nbre ASC";
        this.consultas.llenarComboTabla(this.sql, this.cboTipoServicio, this.modelo, 1);
        this.sql = "SELECT Id, Nbre FROM f_tiposala WHERE Estado = 0 ORDER BY Nbre ASC";
        this.consultas.llenarComboTabla(this.sql, this.cboTipoSala, this.modelo, 1);
        this.sql = "SELECT Id_Persona, NProfesional FROM w_profesional WHERE (Anestesiologia =1) ORDER BY NProfesional ASC";
        this.consultas.llenarComboTabla(this.sql, this.cboAnestesiologo, this.modelo, 1);
        this.sql = "SELECT Id, Nbre, GeneraCobro FROM q_tipoanestesia WHERE estado = 0 ORDER BY Nbre ASC";
        this.consultas.llenarComboTabla(this.sql, this.cboTipoAnestesia, this.modelo, 1);
        this.sql = "SELECT Id_Persona, NProfesional FROM w_profesional ORDER BY NProfesional ASC";
        this.consultas.llenarComboTabla(this.sql, this.cboAyudante, this.modelo, 1);
        this.consultas.llenarComboTabla(this.sql, this.cboPerfusionista, this.modelo, 1);
        this.sql = "SELECT Id, Nbre FROM  g_especialidad WHERE (EsQca =1 AND Estado =0) ORDER BY Nbre ASC";
        this.consultas.llenarComboTabla(this.sql, this.cboEspecialidad, this.modelo, 1);
        this.sql = "SELECT Id, Nbre FROM g_patologia where  Estado=1 ORDER BY Nbre ASC";
        this.consultas.llenarComboTabla(this.sql, this.cboDxPrincipal, this.modelo, 1);
        this.consultas.llenarComboTabla(this.sql, this.cboDxRel, this.modelo, 1);
        this.consultas.llenarComboTabla(this.sql, this.cboDxCompli, this.modelo, 1);
        limpiarCombos();
        this.cboLleno = 1;
        this.consultas.cerrarConexionBd();
    }

    private void cargarProcedim() {
        this.sql = "SELECT g_procedimiento.Id, q_procedtipomanqx.CodCups, g_procedimiento.Nbre, q_procedtipomanqx.Grupo_UVR, g_procedimiento.NivelComplejidad, q_grupouvr.Id AS IdGrupoUVR, q_grupouvr.Orden, f_tarifaprocedimiento.Id_TipoPlan FROM baseserver.q_procedtipomanqx INNER JOIN baseserver.g_procedimiento ON (q_procedtipomanqx.Id_Procedimiento = g_procedimiento.Id) INNER JOIN baseserver.f_tipoprocedimiento ON (g_procedimiento.Id_tipoprocedimiento = f_tipoprocedimiento.Id) INNER JOIN baseserver.q_grupouvr ON (q_procedtipomanqx.Id_GrupoUVRQx = q_grupouvr.Id) INNER JOIN baseserver.f_tiposervtipoproced ON (f_tiposervtipoproced.Idtipoprocedimiento = f_tipoprocedimiento.Id) INNER JOIN baseserver.f_manual ON (f_manual.Id_TipoManQx = q_procedtipomanqx.Id_TipoManualQx) INNER JOIN baseserver.f_empresacontxconvenio ON (f_empresacontxconvenio.Id_Manual = f_manual.Id) INNER JOIN baseserver.f_tarifaprocedimiento ON (f_tarifaprocedimiento.Id_Manual = f_manual.Id) AND (f_tarifaprocedimiento.Id_Procedimiento = g_procedimiento.Id) INNER JOIN baseserver.f_tiposervicio ON (f_tiposervtipoproced.Idtiposervicio = f_tiposervicio.Id) WHERE (f_tiposervicio.Id ='" + this.tipoServicio + "' AND f_empresacontxconvenio.Id ='" + this.idEmpresa + "')";
        this.sql = "SELECT g_procedimiento.Id, q_procedtipomanqx.CodCups, g_procedimiento.Nbre, q_procedtipomanqx.Grupo_UVR, g_procedimiento.NivelComplejidad, q_grupouvr.Id AS IdGrupoUVR, q_grupouvr.Orden FROM  q_procedtipomanqx INNER JOIN g_procedimiento ON (q_procedtipomanqx.Id_Procedimiento = g_procedimiento.Id) INNER JOIN q_grupouvr ON(q_procedtipomanqx.Id_GrupoUVRQx=q_grupouvr.Id) INNER JOIN f_tiposervtipoproced  ON (g_procedimiento.Id_tipoprocedimiento = f_tiposervtipoproced.Idtipoprocedimiento) INNER JOIN f_manual ON (q_procedtipomanqx.Id_TipoManualQx = f_manual.Id_TipoManQx) INNER JOIN f_empresacontxconvenio ON (f_empresacontxconvenio.Id_Manual = f_manual.Id) INNER JOIN f_tiposervicio ON (f_tiposervtipoproced.Idtiposervicio = f_tiposervicio.Id) WHERE (f_tiposervicio.Id ='" + this.tipoServicio + "' AND f_empresacontxconvenio.Id ='" + this.idEmpresa + "')";
        this.consultas.llenarComboTabla(this.sql, this.cboCirugia, this.modelo, 2);
        this.consultas.cerrarConexionBd();
    }

    private void cargarCirujano() {
        this.cboCirujano.removeAll();
        this.sql = "SELECT Id_Persona, NProfesional FROM w_profesional WHERE (EsQca =1) ORDER BY NProfesional ASC";
        this.consultas.llenarComboTabla(this.sql, this.cboCirujano, this.modelo, 1);
        this.consultas.cerrarConexionBd();
    }

    private void crearGrid() {
        this.modelo = new DefaultTableModel((Object[][]) null, new String[]{"Código", "Procedimiento Qco", "Grupo/UVR", "Especialidad", "Profesional", "Via Acceso", "Bilateral", "Dx1", "DxRel", "DxCom", "HMed", "HAne", "HAyu", "DSala", "Material", "Perfusion", "Orden", "IdEspecilidad", "Mayor", "Vr Med", "Vr Ane", "Vr Ayu", "Vr Sala", "Vr Material", "Vr Perfusion", "CodMed"}) { // from class: Facturacion.Qco.2
            Class[] types = {String.class, String.class, Integer.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Long.class, Long.class, Long.class, Long.class, Long.class, Long.class, Integer.class, String.class, Integer.class, Long.class, Long.class, Long.class, Long.class, Long.class, Long.class, String.class};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.grid.setModel(this.modelo);
        this.grid.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.grid.getColumnModel().getColumn(1).setPreferredWidth(150);
        this.grid.getColumnModel().getColumn(2).setPreferredWidth(50);
        this.grid.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(4).setPreferredWidth(80);
        this.grid.getColumnModel().getColumn(5).setPreferredWidth(80);
        this.grid.getColumnModel().getColumn(6).setPreferredWidth(80);
        this.grid.getColumnModel().getColumn(7).setPreferredWidth(0);
        this.grid.getColumnModel().getColumn(8).setPreferredWidth(0);
        this.grid.getColumnModel().getColumn(9).setPreferredWidth(0);
        this.grid.getColumnModel().getColumn(7).setMinWidth(0);
        this.grid.getColumnModel().getColumn(7).setMaxWidth(0);
        this.grid.getColumnModel().getColumn(8).setMinWidth(0);
        this.grid.getColumnModel().getColumn(8).setMaxWidth(0);
        this.grid.getColumnModel().getColumn(9).setMinWidth(0);
        this.grid.getColumnModel().getColumn(9).setMaxWidth(0);
        cargarGrid();
    }

    private void cargarGrid() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cargarDatosDelGrid() {
    }

    private void esquemaEspecialDiferente() {
        int bilat = 0;
        for (int f = 0; f < this.modelo.getRowCount(); f++) {
            if (this.modelo.getValueAt(f, 6).toString().equals("Si")) {
                bilat++;
            }
        }
        this.vrDetallado = new long[this.modelo.getRowCount() + bilat][6];
        this.filaVrDet = 0;
        this.sql = "SELECT q_excepc.Id, q_excepc.NoCir, q_excepc.Esp, q_excepc.Via, q_excepc.Bil, q_excepxmanualqx.Id_ManualQX, q_excepxmanualqx.Medico, q_excepxmanualqx.Anestesia, q_excepxmanualqx.Ayudante, q_excepxmanualqx.DerSala, q_excepxmanualqx.Material, q_excepxmanualqx.Perfusion FROM q_excepxmanualqx INNER JOIN .q_excepc ON (q_excepxmanualqx.Id_Excepc = q_excepc.Id) INNER JOIN q_tipomanualqx ON (q_excepxmanualqx.Id_ManualQX = q_tipomanualqx.Id) INNER JOIN f_manual ON (f_manual.Id_TipoManQx = q_tipomanualqx.Id) INNER JOIN f_empresacontxconvenio ON (f_empresacontxconvenio.Id_Manual = f_manual.Id) WHERE (q_excepc.Esp =1 AND f_empresacontxconvenio.Id =16)";
        ResultSet rs = this.consultas.traerRs(this.sql);
        try {
            rs.next();
            String viaMayor = this.modelo.getValueAt(0, 5).toString();
            String bila = this.modelo.getValueAt(0, 6).toString();
            String especial = this.modelo.getValueAt(0, 3).toString();
            liquidarValor(0, rs.getDouble("Medico"), rs.getDouble("Anestesia"), rs.getDouble("Ayudante"), rs.getDouble("DerSala"), rs.getDouble("Material"), rs.getDouble("Perfusion"));
            if (bila.equals("Si")) {
                rs.next();
                liquidarValor(0, rs.getDouble("Medico"), rs.getDouble("Anestesia"), rs.getDouble("Ayudante"), rs.getDouble("DerSala"), rs.getDouble("Material"), rs.getDouble("Perfusion"));
            }
            for (int f2 = 1; f2 < this.modelo.getRowCount(); f2++) {
                this.modelo.getValueAt(f2, 5).toString();
                if (this.modelo.getValueAt(f2, 3).equals(especial)) {
                    rs.beforeFirst();
                    while (true) {
                        if (!rs.next()) {
                            break;
                        }
                        String via = getViaGrid(f2).equals(viaMayor) ? "0" : "1";
                        if (rs.getString("Via").equals(via) && getNoCirugiaGrid(f2).equals(rs.getString("NoCir"))) {
                            liquidarValor(f2, rs.getDouble("Medico"), rs.getDouble("Anestesia"), rs.getDouble("Ayudante"), rs.getDouble("DerSala"), rs.getDouble("Material"), rs.getDouble("Perfusion"));
                            if (getBilateralGrid(f2).equals("Si")) {
                                rs.next();
                                liquidarBilat2(f2, rs.getDouble("Medico"), rs.getDouble("Anestesia"), rs.getDouble("Ayudante"), rs.getDouble("DerSala"), rs.getDouble("Material"), rs.getDouble("Perfusion"));
                            }
                        }
                    }
                } else {
                    rs.beforeFirst();
                    while (true) {
                        if (!rs.next()) {
                            break;
                        }
                        if (getNoCirugiaGrid(f2).equals(rs.getString("NoCir"))) {
                            liquidarValor(f2, rs.getDouble("Medico"), rs.getDouble("Anestesia"), rs.getDouble("Ayudante"), rs.getDouble("DerSala"), rs.getDouble("Material"), rs.getDouble("Perfusion"));
                            if (this.modelo.getValueAt(f2, 6).equals("Si")) {
                                rs.next();
                                liquidarBilat2(f2, rs.getDouble("Medico"), rs.getDouble("Anestesia"), rs.getDouble("Ayudante"), rs.getDouble("DerSala"), rs.getDouble("Material"), rs.getDouble("Perfusion"));
                            }
                            especial = this.modelo.getValueAt(f2, 3).toString();
                        }
                    }
                }
            }
            rs.close();
            this.consultas.cerrarConexionBd();
        } catch (SQLException ex) {
            this.consultas.mostrarErrorSQL(ex);
        }
    }

    private void esquemaEspecialUnica() {
        int bilat = 0;
        for (int f = 0; f < this.modelo.getRowCount(); f++) {
            if (this.modelo.getValueAt(f, 6).toString().equals("Si")) {
                bilat++;
            }
        }
        this.vrDetallado = new long[this.modelo.getRowCount() + bilat][6];
        this.filaVrDet = 0;
        this.sql = "SELECT q_excepc.Id, q_excepc.NoCir, q_excepc.Esp, q_excepc.Via, q_excepc.Bil, q_excepxmanualqx.Id_ManualQX, q_excepxmanualqx.Medico, q_excepxmanualqx.Anestesia, q_excepxmanualqx.Ayudante, q_excepxmanualqx.DerSala, q_excepxmanualqx.Material, q_excepxmanualqx.Perfusion FROM q_excepxmanualqx INNER JOIN .q_excepc ON (q_excepxmanualqx.Id_Excepc = q_excepc.Id) INNER JOIN q_tipomanualqx ON (q_excepxmanualqx.Id_ManualQX = q_tipomanualqx.Id) INNER JOIN f_manual ON (f_manual.Id_TipoManQx = q_tipomanualqx.Id) INNER JOIN f_empresacontxconvenio ON (f_empresacontxconvenio.Id_Manual = f_manual.Id) WHERE (q_excepc.Esp =0 AND f_empresacontxconvenio.Id =16)";
        ResultSet rs = this.consultas.traerRs(this.sql);
        try {
            rs.next();
            String viaMayor = this.modelo.getValueAt(0, 5).toString();
            String bila = this.modelo.getValueAt(0, 6).toString();
            liquidarValor(0, rs.getDouble("Medico"), rs.getDouble("Anestesia"), rs.getDouble("Ayudante"), rs.getDouble("DerSala"), rs.getDouble("Material"), rs.getDouble("Perfusion"));
            if (bila.equals("Si")) {
                rs.next();
                liquidarValor(0, rs.getDouble("Medico"), rs.getDouble("Anestesia"), rs.getDouble("Ayudante"), rs.getDouble("DerSala"), rs.getDouble("Material"), rs.getDouble("Perfusion"));
            }
            for (int f2 = 1; f2 < this.modelo.getRowCount(); f2++) {
                this.modelo.getValueAt(f2, 5).toString();
                rs.beforeFirst();
                while (true) {
                    if (!rs.next()) {
                        break;
                    }
                    String via = getViaGrid(f2).equals(viaMayor) ? "0" : "1";
                    if (rs.getString("Via").equals(via) && getNoCirugiaGrid(f2).equals(rs.getString("NoCir"))) {
                        liquidarValor(f2, rs.getDouble("Medico"), rs.getDouble("Anestesia"), rs.getDouble("Ayudante"), rs.getDouble("DerSala"), rs.getDouble("Material"), rs.getDouble("Perfusion"));
                        if (getBilateralGrid(f2).equals("Si")) {
                            rs.next();
                            liquidarBilat2(f2, rs.getDouble("Medico"), rs.getDouble("Anestesia"), rs.getDouble("Ayudante"), rs.getDouble("DerSala"), rs.getDouble("Material"), rs.getDouble("Perfusion"));
                        }
                    }
                }
            }
            rs.close();
            this.consultas.cerrarConexionBd();
        } catch (SQLException ex) {
            this.consultas.mostrarErrorSQL(ex);
        }
    }

    public void grabar() {
        if (validarDatos() == 1) {
            grabarOrden();
            grabarOrdenQca();
            this.metodos.mostrarMensaje("Cirugías Grabadas");
        }
    }

    private void grabarOrden() {
        this.sql = "INSERT INTO f_ordenesId(Id_Ingreso, Id_TipoServicios, FechaOrden, HoraOrden, Id_Profesional, Id_Especialidad, Id_CentroCostos, TotalOrdenes, TotalEPS, TotalDescuento, TotalPaciente, Fecha, UsuarioS) VALUES('" + this.frmFacturac.frmIngreso.getIdIngreso() + "','" + this.cboTipoServicio.getPopupTable().getValueAt(this.cboTipoServicio.getSelectedIndex(), 0) + "','" + this.metodos.formatoAMD.format(this.txtFecha.getDate()) + "','" + this.txtHoraIni.getText() + "','" + this.modelo.getValueAt(0, 25).toString() + "','" + this.modelo.getValueAt(0, 17).toString() + "','" + this.cboCC.getPopupTable().getValueAt(this.cboCC.getSelectedIndex(), 0) + "','" + this.txtVrTotal.getValue() + "','','0')";
        this.consultas.ejecutarSQL(this.sql);
        this.consultas.cerrarConexionBd();
    }

    private void grabarOrdenQca() {
        this.sql = "INSERT INTO q_ordenesqx(Id_TipoSala, Id_TipoAnestesia, Id_ProfAnestesia, Id_ProfAyudante, HoraIniciotime, HoraFinaltime, EsTrauma) VALUES('" + getTipoSala() + "','" + getTipoAnestesia() + "','" + getAnestesiologo() + "','" + getAyudante() + "','" + this.txtHoraIni.getValue() + "','" + this.txtHoraFin.getValue() + "','0')";
        this.consultas.ejecutarSQL(this.sql);
        this.consultas.cerrarConexionBd();
    }

    private void liquidar() {
        limpiarValor();
        String especial = this.modelo.getValueAt(0, 3).toString();
        int f = 1;
        while (true) {
            if (f >= this.modelo.getRowCount()) {
                break;
            }
            if (especial.equals(this.modelo.getValueAt(f, 3).toString())) {
                f++;
            } else {
                especial = "-1";
                break;
            }
        }
        if (especial.equals("-1")) {
            esquemaEspecialDiferente();
        } else {
            esquemaEspecialUnica();
        }
    }

    private void liquidarBilat2(int fila, double med, double ane, double ayu, double sala, double mat, double per) {
        if (this.chCirugia.isSelected()) {
            long valorH = (long) ((this.vrDetallado[this.filaVrDet - 1][0] * med) / 100.0d);
            this.modelo.setValueAt(Long.valueOf(Long.parseLong(this.modelo.getValueAt(fila, 19).toString()) + valorH), fila, 19);
            long valorH2 = Long.parseLong(this.modelo.getValueAt(fila, 19).toString());
            this.vrDetallado[this.filaVrDet][0] = redondear(valorH2);
        }
        if (this.chAnestesiologo.isSelected()) {
            long valorH3 = (long) ((this.vrDetallado[this.filaVrDet - 1][1] * ane) / 100.0d);
            this.modelo.setValueAt(Long.valueOf(Long.parseLong(this.modelo.getValueAt(fila, 20).toString()) + valorH3), fila, 20);
            long valorH4 = Long.parseLong(this.modelo.getValueAt(fila, 20).toString());
            this.vrDetallado[this.filaVrDet][1] = redondear(valorH4);
        }
        if (this.chAyudante.isSelected()) {
            long valorH5 = (long) ((this.vrDetallado[this.filaVrDet - 1][2] * ayu) / 100.0d);
            this.modelo.setValueAt(Long.valueOf(Long.parseLong(this.modelo.getValueAt(fila, 21).toString()) + valorH5), fila, 21);
            long valorH6 = Long.parseLong(this.modelo.getValueAt(fila, 21).toString());
            this.vrDetallado[this.filaVrDet][2] = redondear(valorH6);
        }
        if (this.chSala.isSelected()) {
            long valorH7 = (long) ((this.vrDetallado[this.filaVrDet - 1][3] * sala) / 100.0d);
            this.modelo.setValueAt(Long.valueOf(Long.parseLong(this.modelo.getValueAt(fila, 22).toString()) + valorH7), fila, 22);
            long valorH8 = Long.parseLong(this.modelo.getValueAt(fila, 22).toString());
            this.vrDetallado[this.filaVrDet][3] = redondear(valorH8);
        }
        if (this.chMateriales.isSelected()) {
            long valorH9 = (long) ((this.vrDetallado[this.filaVrDet - 1][4] * mat) / 100.0d);
            this.modelo.setValueAt(Long.valueOf(Long.parseLong(this.modelo.getValueAt(fila, 23).toString()) + valorH9), fila, 23);
            long valorH10 = Long.parseLong(this.modelo.getValueAt(fila, 23).toString());
            this.vrDetallado[this.filaVrDet][4] = redondear(valorH10);
        }
        if (this.chPerfusionista.isSelected()) {
            long valorH11 = (long) ((this.vrDetallado[this.filaVrDet - 1][5] * per) / 100.0d);
            this.modelo.setValueAt(Long.valueOf(Long.parseLong(this.modelo.getValueAt(fila, 24).toString()) + valorH11), fila, 24);
            long valorH12 = Long.parseLong(this.modelo.getValueAt(fila, 24).toString());
            this.vrDetallado[this.filaVrDet][5] = redondear(valorH12);
        }
        this.filaVrDet++;
        totalizar();
    }

    private void totalizar() {
        limpiarValor();
        for (int f = 0; f < this.modelo.getRowCount(); f++) {
            long valor = Long.parseLong(this.modelo.getValueAt(f, 19).toString());
            this.txtVrHonorarios.setValue(Long.valueOf(redondear((long) (getVrCirujano().doubleValue() + valor))));
            long valor2 = Long.parseLong(this.modelo.getValueAt(f, 20).toString());
            this.txtVrAnestesiologo.setValue(Long.valueOf(redondear((long) (getVrAnestesiologo().doubleValue() + valor2))));
            long valor3 = Long.parseLong(this.modelo.getValueAt(f, 21).toString());
            this.txtVrAyudante.setValue(Long.valueOf(redondear((long) (getVrAyudante().doubleValue() + valor3))));
            long valor4 = Long.parseLong(this.modelo.getValueAt(f, 22).toString());
            this.txtVrSala.setValue(Long.valueOf(redondear((long) (getVrSala().doubleValue() + valor4))));
            long valor5 = Long.parseLong(this.modelo.getValueAt(f, 23).toString());
            this.txtValorMateriales.setValue(Long.valueOf(redondear((long) (getVrMateriales().doubleValue() + valor5))));
            long valor6 = Long.parseLong(this.modelo.getValueAt(f, 24).toString());
            this.txtVrPerfusionista.setValue(Long.valueOf(redondear((long) (getVrPerfusionista().doubleValue() + valor6))));
            this.txtVrTotal.setValue(Double.valueOf(getVrCirujano().doubleValue() + getVrAnestesiologo().doubleValue() + getVrAyudante().doubleValue() + getVrPerfusionista().doubleValue() + getVrSala().doubleValue() + getVrMateriales().doubleValue()));
        }
    }

    private void liquidarValor(int fila, double med, double ane, double ayu, double sala, double mat, double per) {
        if (this.chCirugia.isSelected()) {
            long valorH = (long) ((getVrHonorario(fila, 10).doubleValue() * med) / 100.0d);
            this.modelo.setValueAt(Long.valueOf(Long.parseLong(this.modelo.getValueAt(fila, 19).toString()) + valorH), fila, 19);
            long valorH2 = Long.parseLong(this.modelo.getValueAt(fila, 19).toString());
            this.vrDetallado[this.filaVrDet][0] = redondear(valorH2);
        }
        if (this.chAnestesiologo.isSelected()) {
            long valorH3 = (long) ((getVrHonorario(fila, 11).doubleValue() * ane) / 100.0d);
            this.modelo.setValueAt(Long.valueOf(Long.parseLong(this.modelo.getValueAt(fila, 20).toString()) + valorH3), fila, 20);
            long valorH4 = Long.parseLong(this.modelo.getValueAt(fila, 20).toString());
            this.vrDetallado[this.filaVrDet][1] = redondear(valorH4);
        }
        if (this.chAyudante.isSelected()) {
            long valorH5 = (long) ((getVrHonorario(fila, 12).doubleValue() * ayu) / 100.0d);
            this.modelo.setValueAt(Long.valueOf(Long.parseLong(this.modelo.getValueAt(fila, 21).toString()) + valorH5), fila, 21);
            long valorH6 = Long.parseLong(this.modelo.getValueAt(fila, 21).toString());
            this.vrDetallado[this.filaVrDet][2] = redondear(valorH6);
        }
        if (this.chSala.isSelected()) {
            long valorH7 = (long) ((getVrHonorario(fila, 13).doubleValue() * sala) / 100.0d);
            this.modelo.setValueAt(Long.valueOf(Long.parseLong(this.modelo.getValueAt(fila, 22).toString()) + valorH7), fila, 22);
            long valorH8 = Long.parseLong(this.modelo.getValueAt(fila, 22).toString());
            this.vrDetallado[this.filaVrDet][3] = redondear(valorH8);
        }
        if (this.chMateriales.isSelected()) {
            long valorH9 = (long) ((getVrHonorario(fila, 14).doubleValue() * mat) / 100.0d);
            this.modelo.setValueAt(Long.valueOf(Long.parseLong(this.modelo.getValueAt(fila, 23).toString()) + valorH9), fila, 23);
            long valorH10 = Long.parseLong(this.modelo.getValueAt(fila, 23).toString());
            this.vrDetallado[this.filaVrDet][4] = redondear(valorH10);
        }
        if (this.chPerfusionista.isSelected()) {
            long valorH11 = (long) ((getVrHonorario(fila, 15).doubleValue() * per) / 100.0d);
            this.modelo.setValueAt(Long.valueOf(Long.parseLong(this.modelo.getValueAt(fila, 24).toString()) + valorH11), fila, 24);
            long valorH12 = Long.parseLong(this.modelo.getValueAt(fila, 24).toString());
            this.vrDetallado[this.filaVrDet][5] = redondear(valorH12);
        }
        this.filaVrDet++;
        totalizar();
    }

    private void limpiarCombos() {
        this.cboTipoServicio.setSelectedItem("");
        this.cboTipoSala.setSelectedIndex(-1);
        this.cboAnestesiologo.setSelectedIndex(-1);
        this.cboAyudante.setSelectedIndex(-1);
        this.cboPerfusionista.setSelectedIndex(-1);
        this.cboTipoAnestesia.setSelectedIndex(-1);
        this.cboCirujano.setSelectedIndex(-1);
        this.cboEspecialidad.setSelectedIndex(-1);
        this.cboCirugia.setSelectedIndex(-1);
        this.cboDxPrincipal.setSelectedIndex(-1);
        this.cboDxRel.setSelectedIndex(-1);
        this.cboDxCompli.setSelectedIndex(-1);
    }

    private void limpiarValor() {
        this.txtVrHonorarios.setValue(0);
        this.txtVrAnestesiologo.setValue(0);
        this.txtVrAyudante.setValue(0);
        this.txtVrSala.setValue(0);
        this.txtValorMateriales.setValue(0);
        this.txtVrPerfusionista.setValue(0);
        this.txtVrTotal.setValue(0);
    }

    public void nuevo() {
        limpiarCombos();
        this.txtFecha.setDate(this.metodos.getFechaActual());
        this.txtHoraIni.setText("");
        this.txtHoraFin.setText("");
        this.btnIgualVia.setSelected(true);
        this.btnBilateralNo.setSelected(true);
        this.txtDxPpal.setText("");
        this.txtDxRel.setText("");
        this.txtDxCompli.setText("");
        this.txtVrHonorarios.setValue(0);
        this.txtVrAnestesiologo.setValue(0);
        this.txtVrAyudante.setValue(0);
        this.txtVrPerfusionista.setValue(0);
        this.txtVrSala.setValue(0);
        this.txtValorMateriales.setValue(0);
        this.txtVrTotal.setValue(0);
        crearGrid();
    }

    private void ordenarGrid() {
        int salir = 0;
        while (salir == 0) {
            salir = 1;
            int ordenAnt = Integer.parseInt(this.modelo.getValueAt(0, 16).toString());
            int espAnt = Integer.parseInt(this.modelo.getValueAt(0, 17).toString());
            for (int fila = 1; fila < this.modelo.getRowCount(); fila++) {
                int OrdenAct = Integer.parseInt(this.modelo.getValueAt(fila, 16).toString());
                int espAct = Integer.parseInt(this.modelo.getValueAt(fila, 17).toString());
                if (espAct > espAnt) {
                    this.modelo.moveRow(fila - 1, fila - 1, fila);
                    salir = 0;
                } else if (espAnt == espAct && OrdenAct > ordenAnt) {
                    this.modelo.moveRow(fila - 1, fila - 1, fila);
                    salir = 0;
                }
                ordenAnt = Integer.parseInt(this.modelo.getValueAt(fila, 16).toString());
                espAnt = Integer.parseInt(this.modelo.getValueAt(fila, 17).toString());
            }
            this.modelo.setValueAt(1, 0, 18);
            limpiarValoresLiquidados(0);
            int espAnt2 = Integer.parseInt(this.modelo.getValueAt(0, 17).toString());
            for (int f = 1; f < this.modelo.getRowCount(); f++) {
                limpiarValoresLiquidados(f);
                if (Integer.parseInt(this.modelo.getValueAt(f, 17).toString()) == espAnt2) {
                    if (this.modelo.getValueAt(f - 1, 18).toString().equals("1")) {
                        this.modelo.setValueAt(2, f, 18);
                    } else {
                        this.modelo.setValueAt(3, f, 18);
                    }
                } else {
                    this.modelo.setValueAt(1, f, 18);
                }
                espAnt2 = Integer.parseInt(this.modelo.getValueAt(f, 17).toString());
            }
        }
    }

    private void limpiarValoresLiquidados(int f) {
        this.modelo.setValueAt(0, f, 19);
        this.modelo.setValueAt(0, f, 20);
        this.modelo.setValueAt(0, f, 21);
        this.modelo.setValueAt(0, f, 22);
        this.modelo.setValueAt(0, f, 23);
        this.modelo.setValueAt(Integer.valueOf(f), f, 24);
    }

    private long redondear(long valor) {
        long valor2;
        long residuo = valor % 100;
        if (residuo >= 50) {
            valor2 = valor + (100 - residuo);
        } else {
            valor2 = valor - residuo;
        }
        return valor2;
    }

    private int validarDatos() {
        int retorno = 0;
        if (this.txtFecha.getDate() == null) {
            this.metodos.mostrarMensaje("Por favor coloque la Fecha de la Cirugía");
            this.txtFecha.requestFocus();
        } else if (this.txtHoraIni.getText().isEmpty()) {
            this.metodos.mostrarMensaje("Por favor coloque la Hora de Inicio de la Cirugía");
            this.txtHoraIni.requestFocus();
        } else if (this.txtHoraFin.getText().isEmpty()) {
            this.metodos.mostrarMensaje("Por favor coloque la Hora de Finalización de la Cirugía");
            this.txtHoraFin.requestFocus();
        } else if (this.cboTipoServicio.getSelectedIndex() < 0) {
            this.metodos.mostrarMensaje("Por favor seleccione el Tipo de Servicio");
            this.cboTipoServicio.requestFocus();
        } else if (this.cboTipoSala.getSelectedIndex() < 0) {
            this.metodos.mostrarMensaje("Por favor seleccione el Tipo de Sala");
            this.cboTipoSala.requestFocus();
        } else if (this.cboAnestesiologo.getSelectedIndex() < 0) {
            this.metodos.mostrarMensaje("Por favor seleccione el Anestesiologo que interviene en la Cirugía");
            this.cboAnestesiologo.requestFocus();
        } else if (this.cboTipoAnestesia.getSelectedIndex() < 0) {
            this.metodos.mostrarMensaje("Por favor seleccione el Tipo de Anestesia");
            this.cboTipoAnestesia.requestFocus();
        } else if (this.cboAyudante.getSelectedIndex() < 0) {
            this.metodos.mostrarMensaje("Por favor seleccione el Ayudante");
            this.cboAyudante.requestFocus();
        } else if (this.grid.getRowCount() < 0) {
            this.metodos.mostrarMensaje("Por favor seleccione una Cirugía para liquidar");
            this.cboCirugia.requestFocus();
        } else {
            retorno = 1;
        }
        return retorno;
    }

    private String getAnestesiologo() {
        return this.cboAnestesiologo.getPopupTable().getValueAt(this.cboAnestesiologo.getSelectedIndex(), 1).toString();
    }

    private String getAyudante() {
        return this.cboAyudante.getPopupTable().getValueAt(this.cboAyudante.getSelectedIndex(), 1).toString();
    }

    private String getFecha() {
        return this.metodos.formatoAMD.format(this.txtFecha.getDate());
    }

    private String getEspecialGrid(int fila) {
        return this.modelo.getValueAt(fila, 18).toString();
    }

    private String getViaGrid(int fila) {
        return this.modelo.getValueAt(fila, 5).toString();
    }

    private String getNoCirugiaGrid(int fila) {
        return this.modelo.getValueAt(fila, 18).toString();
    }

    private String getBilateralGrid(int fila) {
        return this.modelo.getValueAt(fila, 6).toString();
    }

    private String getTipoSala() {
        return this.cboTipoSala.getPopupTable().getValueAt(this.cboTipoSala.getSelectedIndex(), 1).toString();
    }

    private String getTipoAnestesia() {
        return this.cboTipoAnestesia.getPopupTable().getValueAt(this.cboTipoAnestesia.getSelectedIndex(), 1).toString();
    }

    private Double getVrHonorario(int fila, int col) {
        double valor = 0.0d;
        if (this.modelo.getValueAt(fila, col).toString() != null && !this.modelo.getValueAt(fila, col).toString().equals("0") && !this.modelo.getValueAt(fila, col).equals("")) {
            valor = Double.parseDouble(this.modelo.getValueAt(fila, col).toString());
        }
        return Double.valueOf(valor);
    }

    private Double getVrCirujano() {
        return Double.valueOf(Double.parseDouble(this.txtVrHonorarios.getValue().toString()));
    }

    private Double getVrAnestesiologo() {
        return Double.valueOf(Double.parseDouble(this.txtVrAnestesiologo.getValue().toString()));
    }

    private Double getVrAyudante() {
        return Double.valueOf(Double.parseDouble(this.txtVrAyudante.getValue().toString()));
    }

    private Double getVrPerfusionista() {
        return Double.valueOf(Double.parseDouble(this.txtVrPerfusionista.getValue().toString()));
    }

    private Double getVrSala() {
        return Double.valueOf(Double.parseDouble(this.txtVrSala.getValue().toString()));
    }

    private Double getVrMateriales() {
        return Double.valueOf(Double.parseDouble(this.txtValorMateriales.getValue().toString()));
    }

    private void setFecha(String fecha) {
        this.txtFecha.setDate(this.metodos.getPasarTextoAFecha(fecha));
    }

    /* JADX WARN: Type inference failed for: r3v168, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.buttonGroup1 = new ButtonGroup();
        this.buttonGroup2 = new ButtonGroup();
        this.jPanel1 = new JPanel();
        this.jPanel2 = new JPanel();
        this.jLabel1 = new JLabel();
        this.jLabel2 = new JLabel();
        try {
            this.cboAyudante = new JTableComboBox();
        } catch (IncompatibleLookAndFeelException e1) {
            e1.printStackTrace();
        }
        try {
            this.cboPerfusionista = new JTableComboBox();
        } catch (IncompatibleLookAndFeelException e12) {
            e12.printStackTrace();
        }
        this.jPanel3 = new JPanel();
        this.jLabel3 = new JLabel();
        this.jLabel4 = new JLabel();
        try {
            this.cboAnestesiologo = new JTableComboBox();
        } catch (IncompatibleLookAndFeelException e13) {
            e13.printStackTrace();
        }
        try {
            this.cboTipoAnestesia = new JTableComboBox();
        } catch (IncompatibleLookAndFeelException e14) {
            e14.printStackTrace();
        }
        this.jPanel4 = new JPanel();
        this.txtFecha = new JDateChooser();
        this.txtHoraIni = new JFormattedTextField();
        this.txtHoraFin = new JFormattedTextField();
        this.jLabel7 = new JLabel();
        this.jLabel6 = new JLabel();
        this.jLabel15 = new JLabel();
        this.jPanel9 = new JPanel();
        this.jLabel13 = new JLabel();
        this.jLabel5 = new JLabel();
        try {
            this.cboTipoServicio = new JTableComboBox();
        } catch (IncompatibleLookAndFeelException e15) {
            e15.printStackTrace();
        }
        try {
            this.cboTipoSala = new JTableComboBox();
        } catch (IncompatibleLookAndFeelException e16) {
            e16.printStackTrace();
        }
        this.jLabel16 = new JLabel();
        try {
            this.cboCC = new JTableComboBox();
        } catch (IncompatibleLookAndFeelException e17) {
            e17.printStackTrace();
        }
        this.panelDatos = new JPanel();
        this.jLabel8 = new JLabel();
        this.jLabel9 = new JLabel();
        this.jLabel10 = new JLabel();
        this.jLabel11 = new JLabel();
        this.jPanel6 = new JPanel();
        this.btnBilateralNo = new JRadioButton();
        this.btnBilateralSi = new JRadioButton();
        this.jLabel14 = new JLabel();
        this.jLabel12 = new JLabel();
        this.jPanel7 = new JPanel();
        this.btnIgualVia = new JRadioButton();
        this.btnDiferenteVia = new JRadioButton();
        this.btnCargar = new JButton();
        this.txtDxCompli = new JTextField();
        this.txtCirugia = new JTextField();
        this.txtDxPpal = new JTextField();
        this.txtDxRel = new JTextField();
        try {
            this.cboEspecialidad = new JTableComboBox();
        } catch (IncompatibleLookAndFeelException e18) {
            e18.printStackTrace();
        }
        try {
            this.cboCirujano = new JTableComboBox();
        } catch (IncompatibleLookAndFeelException e19) {
            e19.printStackTrace();
        }
        try {
            this.cboCirugia = new JTableComboBox();
        } catch (IncompatibleLookAndFeelException e110) {
            e110.printStackTrace();
        }
        try {
            this.cboDxPrincipal = new JTableComboBox();
        } catch (IncompatibleLookAndFeelException e111) {
            e111.printStackTrace();
        }
        try {
            this.cboDxRel = new JTableComboBox();
        } catch (IncompatibleLookAndFeelException e112) {
            e112.printStackTrace();
        }
        try {
            this.cboDxCompli = new JTableComboBox();
        } catch (IncompatibleLookAndFeelException e113) {
            e113.printStackTrace();
        }
        this.jTabbedPane1 = new JTabbedPane();
        this.jScrollPane1 = new JScrollPane();
        this.grid = new JTable();
        this.jPanel5 = new JPanel();
        this.chMateriales = new JCheckBox();
        this.chCirugia = new JCheckBox();
        this.chAnestesiologo = new JCheckBox();
        this.chAyudante = new JCheckBox();
        this.chPerfusionista = new JCheckBox();
        this.chSala = new JCheckBox();
        this.txtVrAyudante = new JFormattedTextField();
        this.txtVrHonorarios = new JFormattedTextField();
        this.txtVrAnestesiologo = new JFormattedTextField();
        this.txtVrTotal = new JFormattedTextField();
        this.txtVrSala = new JFormattedTextField();
        this.txtValorMateriales = new JFormattedTextField();
        this.txtVrPerfusionista = new JFormattedTextField();
        this.btnLiquidar = new JButton();
        this.jPanel8 = new JPanel();
        setBackground(new Color(204, 255, 255));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("LIQUIDACIÓN DE PROCEDIMIENTOS QUIRÚRGICOS");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("Qco");
        this.jPanel1.setBackground(new Color(0, 204, 204));
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "Datos de los Procedimientos Quirurgicos", 0, 0, new Font("Arial", 1, 12), new Color(255, 255, 255)));
        this.jPanel1.setLayout((LayoutManager) null);
        this.jPanel2.setBackground(new Color(0, 204, 204));
        this.jPanel2.setBorder(BorderFactory.createTitledBorder((Border) null, "Profesionales que Intervienen", 0, 0, new Font("Arial", 1, 12)));
        this.jPanel2.setLayout((LayoutManager) null);
        this.jLabel1.setFont(new Font("Arial", 1, 12));
        this.jLabel1.setForeground(new Color(0, 0, 102));
        this.jLabel1.setText("Ayudante");
        this.jPanel2.add(this.jLabel1);
        this.jLabel1.setBounds(10, 20, 60, 15);
        this.jLabel2.setFont(new Font("Arial", 1, 12));
        this.jLabel2.setForeground(new Color(0, 0, 102));
        this.jLabel2.setText("Perfusionista");
        this.jPanel2.add(this.jLabel2);
        this.jLabel2.setBounds(10, 70, 110, 15);
        this.cboAyudante.setFont(new Font("Arial", 1, 12));
        this.cboAyudante.setShowTableGrid(true);
        this.cboAyudante.setShowTableHeaders(true);
        this.jPanel2.add(this.cboAyudante);
        this.cboAyudante.setBounds(10, 40, 270, 30);
        this.cboPerfusionista.setFont(new Font("Arial", 1, 12));
        this.cboPerfusionista.setShowTableGrid(true);
        this.cboPerfusionista.setShowTableHeaders(true);
        this.jPanel2.add(this.cboPerfusionista);
        this.cboPerfusionista.setBounds(10, 90, 270, 30);
        this.jPanel1.add(this.jPanel2);
        this.jPanel2.setBounds(830, 20, 290, 130);
        this.jPanel3.setBackground(new Color(0, 204, 204));
        this.jPanel3.setBorder(BorderFactory.createTitledBorder((Border) null, "Anestesiología", 0, 0, new Font("Arial", 1, 12)));
        this.jPanel3.setLayout((LayoutManager) null);
        this.jLabel3.setFont(new Font("Arial", 1, 12));
        this.jLabel3.setForeground(new Color(0, 0, 102));
        this.jLabel3.setText("Anestesiólogo");
        this.jPanel3.add(this.jLabel3);
        this.jLabel3.setBounds(10, 20, 90, 15);
        this.jLabel4.setFont(new Font("Arial", 1, 12));
        this.jLabel4.setForeground(new Color(0, 0, 102));
        this.jLabel4.setText("Tipo de Anestesia");
        this.jPanel3.add(this.jLabel4);
        this.jLabel4.setBounds(10, 70, 110, 15);
        this.cboAnestesiologo.setFont(new Font("Arial", 1, 12));
        this.cboAnestesiologo.setShowTableGrid(true);
        this.cboAnestesiologo.setShowTableHeaders(true);
        this.jPanel3.add(this.cboAnestesiologo);
        this.cboAnestesiologo.setBounds(10, 40, 260, 30);
        this.cboTipoAnestesia.setFont(new Font("Arial", 1, 12));
        this.cboTipoAnestesia.setShowTableGrid(true);
        this.cboTipoAnestesia.setShowTableHeaders(true);
        this.cboTipoAnestesia.addItemListener(new ItemListener() { // from class: Facturacion.Qco.3
            public void itemStateChanged(ItemEvent evt) {
                Qco.this.cboTipoAnestesiaItemStateChanged(evt);
            }
        });
        this.jPanel3.add(this.cboTipoAnestesia);
        this.cboTipoAnestesia.setBounds(10, 90, 260, 30);
        this.jPanel1.add(this.jPanel3);
        this.jPanel3.setBounds(530, 20, 290, 130);
        this.jPanel4.setBackground(new Color(0, 204, 204));
        this.jPanel4.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha y Hora", 0, 0, new Font("Arial", 1, 12)));
        this.jPanel4.setLayout(new AbsoluteLayout());
        this.txtFecha.setBackground(new Color(0, 204, 204));
        this.txtFecha.setFont(new Font("Arial", 1, 12));
        this.jPanel4.add(this.txtFecha, new AbsoluteConstraints(100, 10, 100, 28));
        this.txtHoraIni.setToolTipText("Formato hh:mm p");
        this.txtHoraIni.setFont(new Font("Arial", 1, 12));
        this.txtHoraIni.addActionListener(new ActionListener() { // from class: Facturacion.Qco.4
            public void actionPerformed(ActionEvent evt) {
                Qco.this.txtHoraIniActionPerformed(evt);
            }
        });
        this.txtHoraIni.addFocusListener(new FocusAdapter() { // from class: Facturacion.Qco.5
            public void focusGained(FocusEvent evt) {
                Qco.this.txtHoraIniFocusGained(evt);
            }
        });
        this.jPanel4.add(this.txtHoraIni, new AbsoluteConstraints(100, 48, 100, 28));
        this.txtHoraFin.setToolTipText("Formato hh:mm p");
        this.txtHoraFin.setFont(new Font("Arial", 1, 12));
        this.txtHoraFin.addFocusListener(new FocusAdapter() { // from class: Facturacion.Qco.6
            public void focusGained(FocusEvent evt) {
                Qco.this.txtHoraFinFocusGained(evt);
            }
        });
        this.jPanel4.add(this.txtHoraFin, new AbsoluteConstraints(100, 84, 100, 28));
        this.jLabel7.setFont(new Font("Arial", 1, 12));
        this.jLabel7.setForeground(new Color(0, 0, 102));
        this.jLabel7.setText("Fecha");
        this.jPanel4.add(this.jLabel7, new AbsoluteConstraints(10, 20, 80, -1));
        this.jLabel6.setFont(new Font("Arial", 1, 12));
        this.jLabel6.setForeground(new Color(0, 0, 102));
        this.jLabel6.setText("Hora Final");
        this.jPanel4.add(this.jLabel6, new AbsoluteConstraints(10, 90, 70, -1));
        this.jLabel15.setFont(new Font("Arial", 1, 12));
        this.jLabel15.setForeground(new Color(0, 0, 102));
        this.jLabel15.setText("Hora de Inicio");
        this.jPanel4.add(this.jLabel15, new AbsoluteConstraints(10, 60, 80, -1));
        this.jPanel1.add(this.jPanel4);
        this.jPanel4.setBounds(10, 20, 210, 130);
        this.jPanel9.setBackground(new Color(0, 204, 204));
        this.jPanel9.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipos", 0, 0, new Font("Arial", 1, 12)));
        this.jPanel9.setLayout(new AbsoluteLayout());
        this.jLabel13.setFont(new Font("Arial", 1, 12));
        this.jLabel13.setForeground(new Color(0, 0, 102));
        this.jLabel13.setText("Servicio");
        this.jPanel9.add(this.jLabel13, new AbsoluteConstraints(10, 15, 90, -1));
        this.jLabel5.setFont(new Font("Arial", 1, 12));
        this.jLabel5.setForeground(new Color(0, 0, 102));
        this.jLabel5.setText("Centro de Costo");
        this.jPanel9.add(this.jLabel5, new AbsoluteConstraints(150, 60, 100, -1));
        this.cboTipoServicio.setFont(new Font("Arial", 1, 12));
        this.cboTipoServicio.setShowTableGrid(true);
        this.cboTipoServicio.setShowTableHeaders(true);
        this.cboTipoServicio.addItemListener(new ItemListener() { // from class: Facturacion.Qco.7
            public void itemStateChanged(ItemEvent evt) {
                Qco.this.cboTipoServicioItemStateChanged(evt);
            }
        });
        this.jPanel9.add(this.cboTipoServicio, new AbsoluteConstraints(10, 30, 270, 30));
        this.cboTipoSala.setFont(new Font("Arial", 1, 12));
        this.cboTipoSala.setShowTableGrid(true);
        this.cboTipoSala.setShowTableHeaders(true);
        this.jPanel9.add(this.cboTipoSala, new AbsoluteConstraints(10, 80, 130, 30));
        this.jLabel16.setFont(new Font("Arial", 1, 12));
        this.jLabel16.setForeground(new Color(0, 0, 102));
        this.jLabel16.setText("Sala");
        this.jPanel9.add(this.jLabel16, new AbsoluteConstraints(10, 60, 90, -1));
        this.cboCC.setFont(new Font("Arial", 1, 12));
        this.cboCC.setShowTableGrid(true);
        this.cboCC.setShowTableHeaders(true);
        this.jPanel9.add(this.cboCC, new AbsoluteConstraints(150, 80, 130, 30));
        this.jPanel1.add(this.jPanel9);
        this.jPanel9.setBounds(230, 20, 290, 130);
        this.panelDatos.setBackground(new Color(0, 204, 204));
        this.panelDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "Datos de los Cirujanos que Intervienen y Procedimientos", 1, 0, new Font("Arial", 1, 12)));
        this.panelDatos.setLayout((LayoutManager) null);
        this.jLabel8.setFont(new Font("Arial", 1, 12));
        this.jLabel8.setForeground(new Color(51, 0, 102));
        this.jLabel8.setText("Diagnostico Principal");
        this.panelDatos.add(this.jLabel8);
        this.jLabel8.setBounds(340, 110, 170, 15);
        this.jLabel9.setFont(new Font("Arial", 1, 12));
        this.jLabel9.setForeground(new Color(51, 0, 102));
        this.jLabel9.setText("Cirujano");
        this.panelDatos.add(this.jLabel9);
        this.jLabel9.setBounds(550, 30, 60, 15);
        this.jLabel10.setFont(new Font("Arial", 1, 12));
        this.jLabel10.setForeground(new Color(51, 0, 102));
        this.jLabel10.setText("Especialidad");
        this.panelDatos.add(this.jLabel10);
        this.jLabel10.setBounds(20, 30, 110, 15);
        this.jLabel11.setFont(new Font("Arial", 1, 12));
        this.jLabel11.setForeground(new Color(51, 0, 102));
        this.jLabel11.setText("Procedimiento Quirúrgico o Gineco-Obtetrico");
        this.panelDatos.add(this.jLabel11);
        this.jLabel11.setBounds(20, 50, 280, 15);
        this.jPanel6.setBackground(new Color(0, 204, 204));
        this.jPanel6.setBorder(BorderFactory.createTitledBorder((Border) null, "Bilateral", 0, 0, new Font("Arial", 1, 12)));
        this.jPanel6.setLayout((LayoutManager) null);
        this.btnBilateralNo.setBackground(new Color(0, 204, 204));
        this.buttonGroup2.add(this.btnBilateralNo);
        this.btnBilateralNo.setFont(new Font("Arial", 1, 12));
        this.btnBilateralNo.setForeground(new Color(51, 0, 102));
        this.btnBilateralNo.setSelected(true);
        this.btnBilateralNo.setText("No");
        this.btnBilateralNo.addActionListener(new ActionListener() { // from class: Facturacion.Qco.8
            public void actionPerformed(ActionEvent evt) {
                Qco.this.btnBilateralNoActionPerformed(evt);
            }
        });
        this.jPanel6.add(this.btnBilateralNo);
        this.btnBilateralNo.setBounds(10, 20, 50, 23);
        this.btnBilateralSi.setBackground(new Color(0, 204, 204));
        this.buttonGroup2.add(this.btnBilateralSi);
        this.btnBilateralSi.setFont(new Font("Arial", 1, 12));
        this.btnBilateralSi.setForeground(new Color(51, 0, 102));
        this.btnBilateralSi.setText("Si");
        this.btnBilateralSi.addActionListener(new ActionListener() { // from class: Facturacion.Qco.9
            public void actionPerformed(ActionEvent evt) {
                Qco.this.btnBilateralSiActionPerformed(evt);
            }
        });
        this.jPanel6.add(this.btnBilateralSi);
        this.btnBilateralSi.setBounds(60, 20, 50, 23);
        this.panelDatos.add(this.jPanel6);
        this.jPanel6.setBounds(210, 110, 120, 50);
        this.jLabel14.setFont(new Font("Arial", 1, 12));
        this.jLabel14.setForeground(new Color(51, 0, 102));
        this.jLabel14.setText("Dx Relacional");
        this.panelDatos.add(this.jLabel14);
        this.jLabel14.setBounds(20, 180, 120, 15);
        this.jLabel12.setFont(new Font("Arial", 1, 12));
        this.jLabel12.setForeground(new Color(51, 0, 102));
        this.jLabel12.setText("Dx de Complicación");
        this.panelDatos.add(this.jLabel12);
        this.jLabel12.setBounds(20, 220, 120, 15);
        this.jPanel7.setBackground(new Color(0, 204, 204));
        this.jPanel7.setBorder(BorderFactory.createTitledBorder((Border) null, "Via de Acceso", 0, 0, new Font("Arial", 1, 12)));
        this.jPanel7.setLayout((LayoutManager) null);
        this.btnIgualVia.setBackground(new Color(0, 204, 204));
        this.buttonGroup1.add(this.btnIgualVia);
        this.btnIgualVia.setFont(new Font("Arial", 1, 12));
        this.btnIgualVia.setForeground(new Color(51, 0, 102));
        this.btnIgualVia.setSelected(true);
        this.btnIgualVia.setText("Igual");
        this.btnIgualVia.addActionListener(new ActionListener() { // from class: Facturacion.Qco.10
            public void actionPerformed(ActionEvent evt) {
                Qco.this.btnIgualViaActionPerformed(evt);
            }
        });
        this.jPanel7.add(this.btnIgualVia);
        this.btnIgualVia.setBounds(10, 20, 80, 23);
        this.btnDiferenteVia.setBackground(new Color(0, 204, 204));
        this.buttonGroup1.add(this.btnDiferenteVia);
        this.btnDiferenteVia.setFont(new Font("Arial", 1, 12));
        this.btnDiferenteVia.setForeground(new Color(51, 0, 102));
        this.btnDiferenteVia.setText("Diferente");
        this.btnDiferenteVia.addActionListener(new ActionListener() { // from class: Facturacion.Qco.11
            public void actionPerformed(ActionEvent evt) {
                Qco.this.btnDiferenteViaActionPerformed(evt);
            }
        });
        this.jPanel7.add(this.btnDiferenteVia);
        this.btnDiferenteVia.setBounds(90, 20, 90, 23);
        this.panelDatos.add(this.jPanel7);
        this.jPanel7.setBounds(20, 110, 190, 50);
        this.btnCargar.setFont(new Font("Arial", 1, 12));
        this.btnCargar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Paciente.png")));
        this.btnCargar.setText("Cargar");
        this.btnCargar.setHorizontalTextPosition(0);
        this.btnCargar.setVerticalTextPosition(3);
        this.btnCargar.addActionListener(new ActionListener() { // from class: Facturacion.Qco.12
            public void actionPerformed(ActionEvent evt) {
                Qco.this.btnCargarActionPerformed(evt);
            }
        });
        this.panelDatos.add(this.btnCargar);
        this.btnCargar.setBounds(1020, 170, 90, 70);
        this.txtDxCompli.setFont(new Font("Arial", 1, 12));
        this.txtDxCompli.addActionListener(new ActionListener() { // from class: Facturacion.Qco.13
            public void actionPerformed(ActionEvent evt) {
                Qco.this.txtDxCompliActionPerformed(evt);
            }
        });
        this.txtDxCompli.addFocusListener(new FocusAdapter() { // from class: Facturacion.Qco.14
            public void focusGained(FocusEvent evt) {
                Qco.this.txtDxCompliFocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                Qco.this.txtDxCompliFocusLost(evt);
            }
        });
        this.panelDatos.add(this.txtDxCompli);
        this.txtDxCompli.setBounds(220, 210, 110, 30);
        this.txtCirugia.setFont(new Font("Arial", 1, 12));
        this.txtCirugia.addActionListener(new ActionListener() { // from class: Facturacion.Qco.15
            public void actionPerformed(ActionEvent evt) {
                Qco.this.txtCirugiaActionPerformed(evt);
            }
        });
        this.txtCirugia.addFocusListener(new FocusAdapter() { // from class: Facturacion.Qco.16
            public void focusGained(FocusEvent evt) {
                Qco.this.txtCirugiaFocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                Qco.this.txtCirugiaFocusLost(evt);
            }
        });
        this.panelDatos.add(this.txtCirugia);
        this.txtCirugia.setBounds(20, 70, 130, 30);
        this.txtDxPpal.setFont(new Font("Arial", 1, 12));
        this.txtDxPpal.addActionListener(new ActionListener() { // from class: Facturacion.Qco.17
            public void actionPerformed(ActionEvent evt) {
                Qco.this.txtDxPpalActionPerformed(evt);
            }
        });
        this.txtDxPpal.addFocusListener(new FocusAdapter() { // from class: Facturacion.Qco.18
            public void focusGained(FocusEvent evt) {
                Qco.this.txtDxPpalFocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                Qco.this.txtDxPpalFocusLost(evt);
            }
        });
        this.panelDatos.add(this.txtDxPpal);
        this.txtDxPpal.setBounds(340, 130, 110, 30);
        this.txtDxRel.setFont(new Font("Arial", 1, 12));
        this.txtDxRel.addActionListener(new ActionListener() { // from class: Facturacion.Qco.19
            public void actionPerformed(ActionEvent evt) {
                Qco.this.txtDxRelActionPerformed(evt);
            }
        });
        this.txtDxRel.addFocusListener(new FocusAdapter() { // from class: Facturacion.Qco.20
            public void focusGained(FocusEvent evt) {
                Qco.this.txtDxRelFocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                Qco.this.txtDxRelFocusLost(evt);
            }
        });
        this.panelDatos.add(this.txtDxRel);
        this.txtDxRel.setBounds(220, 170, 110, 30);
        this.cboEspecialidad.setFont(new Font("Arial", 1, 12));
        this.cboEspecialidad.setShowTableGrid(true);
        this.cboEspecialidad.setShowTableHeaders(true);
        this.cboEspecialidad.addItemListener(new ItemListener() { // from class: Facturacion.Qco.21
            public void itemStateChanged(ItemEvent evt) {
                Qco.this.cboEspecialidadItemStateChanged(evt);
            }
        });
        this.panelDatos.add(this.cboEspecialidad);
        this.cboEspecialidad.setBounds(140, 20, 390, 30);
        this.cboCirujano.setFont(new Font("Arial", 1, 12));
        this.cboCirujano.setShowTableGrid(true);
        this.cboCirujano.setShowTableHeaders(true);
        this.panelDatos.add(this.cboCirujano);
        this.cboCirujano.setBounds(600, 20, 510, 30);
        this.cboCirugia.setFont(new Font("Arial", 1, 12));
        this.cboCirugia.setShowTableGrid(true);
        this.cboCirugia.setShowTableHeaders(true);
        this.cboCirugia.addItemListener(new ItemListener() { // from class: Facturacion.Qco.22
            public void itemStateChanged(ItemEvent evt) {
                Qco.this.cboCirugiaItemStateChanged(evt);
            }
        });
        this.panelDatos.add(this.cboCirugia);
        this.cboCirugia.setBounds(160, 70, 950, 30);
        this.cboDxPrincipal.setFont(new Font("Arial", 1, 12));
        this.cboDxPrincipal.setShowTableGrid(true);
        this.cboDxPrincipal.setShowTableHeaders(true);
        this.cboDxPrincipal.addItemListener(new ItemListener() { // from class: Facturacion.Qco.23
            public void itemStateChanged(ItemEvent evt) {
                Qco.this.cboDxPrincipalItemStateChanged(evt);
            }
        });
        this.cboDxPrincipal.addPropertyChangeListener(new PropertyChangeListener() { // from class: Facturacion.Qco.24
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                Qco.this.cboDxPrincipalPropertyChange(evt);
            }
        });
        this.panelDatos.add(this.cboDxPrincipal);
        this.cboDxPrincipal.setBounds(460, 130, 650, 30);
        this.cboDxRel.setFont(new Font("Arial", 1, 12));
        this.cboDxRel.setShowTableGrid(true);
        this.cboDxRel.setShowTableHeaders(true);
        this.cboDxRel.addItemListener(new ItemListener() { // from class: Facturacion.Qco.25
            public void itemStateChanged(ItemEvent evt) {
                Qco.this.cboDxRelItemStateChanged(evt);
            }
        });
        this.cboDxRel.addPropertyChangeListener(new PropertyChangeListener() { // from class: Facturacion.Qco.26
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                Qco.this.cboDxRelPropertyChange(evt);
            }
        });
        this.panelDatos.add(this.cboDxRel);
        this.cboDxRel.setBounds(340, 170, 650, 30);
        this.cboDxCompli.setFont(new Font("Arial", 1, 12));
        this.cboDxCompli.setShowTableGrid(true);
        this.cboDxCompli.setShowTableHeaders(true);
        this.cboDxCompli.addItemListener(new ItemListener() { // from class: Facturacion.Qco.27
            public void itemStateChanged(ItemEvent evt) {
                Qco.this.cboDxCompliItemStateChanged(evt);
            }
        });
        this.cboDxCompli.addPropertyChangeListener(new PropertyChangeListener() { // from class: Facturacion.Qco.28
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                Qco.this.cboDxCompliPropertyChange(evt);
            }
        });
        this.panelDatos.add(this.cboDxCompli);
        this.cboDxCompli.setBounds(340, 210, 650, 30);
        this.jTabbedPane1.setBackground(new Color(0, 204, 204));
        this.jTabbedPane1.setForeground(new Color(255, 0, 0));
        this.jTabbedPane1.setFont(new Font("Arial", 1, 14));
        this.grid.setBackground(new Color(204, 255, 255));
        this.grid.setFont(new Font("Arial", 1, 12));
        this.grid.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.grid.setAutoResizeMode(1);
        this.grid.setRowHeight(25);
        this.grid.setSelectionBackground(new Color(255, 255, 255));
        this.grid.setSelectionForeground(new Color(255, 0, 0));
        this.grid.setSelectionMode(0);
        this.grid.addKeyListener(new KeyAdapter() { // from class: Facturacion.Qco.29
            public void keyPressed(KeyEvent evt) {
                Qco.this.gridKeyPressed(evt);
            }
        });
        this.jScrollPane1.setViewportView(this.grid);
        this.jTabbedPane1.addTab("Cirugias", this.jScrollPane1);
        this.jPanel5.setBackground(new Color(255, 255, 255));
        this.jPanel5.setLayout(new AbsoluteLayout());
        this.chMateriales.setBackground(new Color(255, 255, 255));
        this.chMateriales.setFont(new Font("Arial", 1, 12));
        this.chMateriales.setSelected(true);
        this.chMateriales.setText("Materiales");
        this.chMateriales.addActionListener(new ActionListener() { // from class: Facturacion.Qco.30
            public void actionPerformed(ActionEvent evt) {
                Qco.this.chMaterialesActionPerformed(evt);
            }
        });
        this.jPanel5.add(this.chMateriales, new AbsoluteConstraints(300, 100, 110, -1));
        this.chCirugia.setBackground(new Color(255, 255, 255));
        this.chCirugia.setFont(new Font("Arial", 1, 12));
        this.chCirugia.setSelected(true);
        this.chCirugia.setText("Cirujano");
        this.chCirugia.addActionListener(new ActionListener() { // from class: Facturacion.Qco.31
            public void actionPerformed(ActionEvent evt) {
                Qco.this.chCirugiaActionPerformed(evt);
            }
        });
        this.jPanel5.add(this.chCirugia, new AbsoluteConstraints(20, 20, -1, -1));
        this.chAnestesiologo.setBackground(new Color(255, 255, 255));
        this.chAnestesiologo.setFont(new Font("Arial", 1, 12));
        this.chAnestesiologo.setSelected(true);
        this.chAnestesiologo.setText("Anestesiólogo");
        this.chAnestesiologo.addActionListener(new ActionListener() { // from class: Facturacion.Qco.32
            public void actionPerformed(ActionEvent evt) {
                Qco.this.chAnestesiologoActionPerformed(evt);
            }
        });
        this.jPanel5.add(this.chAnestesiologo, new AbsoluteConstraints(20, 60, -1, -1));
        this.chAyudante.setBackground(new Color(255, 255, 255));
        this.chAyudante.setFont(new Font("Arial", 1, 12));
        this.chAyudante.setSelected(true);
        this.chAyudante.setText("Ayudante");
        this.chAyudante.addActionListener(new ActionListener() { // from class: Facturacion.Qco.33
            public void actionPerformed(ActionEvent evt) {
                Qco.this.chAyudanteActionPerformed(evt);
            }
        });
        this.jPanel5.add(this.chAyudante, new AbsoluteConstraints(20, 100, -1, -1));
        this.chPerfusionista.setBackground(new Color(255, 255, 255));
        this.chPerfusionista.setFont(new Font("Arial", 1, 12));
        this.chPerfusionista.setText("Perfusionista");
        this.chPerfusionista.addActionListener(new ActionListener() { // from class: Facturacion.Qco.34
            public void actionPerformed(ActionEvent evt) {
                Qco.this.chPerfusionistaActionPerformed(evt);
            }
        });
        this.jPanel5.add(this.chPerfusionista, new AbsoluteConstraints(300, 20, 130, -1));
        this.chSala.setBackground(new Color(255, 255, 255));
        this.chSala.setFont(new Font("Arial", 1, 12));
        this.chSala.setSelected(true);
        this.chSala.setText("Sala de Cirugía");
        this.chSala.addActionListener(new ActionListener() { // from class: Facturacion.Qco.35
            public void actionPerformed(ActionEvent evt) {
                Qco.this.chSalaActionPerformed(evt);
            }
        });
        this.jPanel5.add(this.chSala, new AbsoluteConstraints(300, 60, 130, -1));
        this.txtVrAyudante.setBackground(new Color(0, 0, 102));
        this.txtVrAyudante.setHorizontalAlignment(0);
        this.txtVrAyudante.setDisabledTextColor(new Color(0, 0, 102));
        this.txtVrAyudante.setEnabled(false);
        this.txtVrAyudante.setFont(new Font("Arial", 1, 14));
        this.jPanel5.add(this.txtVrAyudante, new AbsoluteConstraints(140, 90, 120, 30));
        this.txtVrHonorarios.setBackground(new Color(0, 0, 102));
        this.txtVrHonorarios.setHorizontalAlignment(0);
        this.txtVrHonorarios.setDisabledTextColor(new Color(0, 0, 102));
        this.txtVrHonorarios.setEnabled(false);
        this.txtVrHonorarios.setFont(new Font("Arial", 1, 14));
        this.jPanel5.add(this.txtVrHonorarios, new AbsoluteConstraints(140, 10, 120, 30));
        this.txtVrAnestesiologo.setBackground(new Color(0, 0, 102));
        this.txtVrAnestesiologo.setHorizontalAlignment(0);
        this.txtVrAnestesiologo.setDisabledTextColor(new Color(0, 0, 102));
        this.txtVrAnestesiologo.setEnabled(false);
        this.txtVrAnestesiologo.setFont(new Font("Arial", 1, 14));
        this.jPanel5.add(this.txtVrAnestesiologo, new AbsoluteConstraints(140, 50, 120, 30));
        this.txtVrTotal.setBackground(new Color(0, 0, 102));
        this.txtVrTotal.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor total", 0, 0, new Font("Tahoma", 1, 14), new Color(0, 0, 51)));
        this.txtVrTotal.setHorizontalAlignment(0);
        this.txtVrTotal.setDisabledTextColor(new Color(0, 0, 102));
        this.txtVrTotal.setEnabled(false);
        this.txtVrTotal.setFont(new Font("Arial", 1, 36));
        this.jPanel5.add(this.txtVrTotal, new AbsoluteConstraints(650, 10, 310, 110));
        this.txtVrSala.setBackground(new Color(0, 0, 102));
        this.txtVrSala.setHorizontalAlignment(0);
        this.txtVrSala.setDisabledTextColor(new Color(0, 0, 102));
        this.txtVrSala.setEnabled(false);
        this.txtVrSala.setFont(new Font("Arial", 1, 14));
        this.jPanel5.add(this.txtVrSala, new AbsoluteConstraints(460, 50, 120, 30));
        this.txtValorMateriales.setBackground(new Color(0, 0, 102));
        this.txtValorMateriales.setHorizontalAlignment(0);
        this.txtValorMateriales.setDisabledTextColor(new Color(0, 0, 102));
        this.txtValorMateriales.setEnabled(false);
        this.txtValorMateriales.setFont(new Font("Arial", 1, 14));
        this.jPanel5.add(this.txtValorMateriales, new AbsoluteConstraints(460, 90, 120, 30));
        this.txtVrPerfusionista.setBackground(new Color(0, 0, 102));
        this.txtVrPerfusionista.setHorizontalAlignment(0);
        this.txtVrPerfusionista.setDisabledTextColor(new Color(0, 0, 102));
        this.txtVrPerfusionista.setEnabled(false);
        this.txtVrPerfusionista.setFont(new Font("Arial", 1, 14));
        this.jPanel5.add(this.txtVrPerfusionista, new AbsoluteConstraints(460, 10, 120, 30));
        this.btnLiquidar.setFont(new Font("Arial", 1, 12));
        this.btnLiquidar.setText("Liquidar Valores");
        this.btnLiquidar.addActionListener(new ActionListener() { // from class: Facturacion.Qco.36
            public void actionPerformed(ActionEvent evt) {
                Qco.this.btnLiquidarActionPerformed(evt);
            }
        });
        this.jPanel5.add(this.btnLiquidar, new AbsoluteConstraints(980, 40, 130, 50));
        this.jTabbedPane1.addTab("Liquidación de Honorarios", this.jPanel5);
        this.jPanel8.setBackground(new Color(255, 255, 204));
        GroupLayout jPanel8Layout = new GroupLayout(this.jPanel8);
        this.jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 1125, 32767));
        jPanel8Layout.setVerticalGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 155, 32767));
        this.jTabbedPane1.addTab("Datos del Recien Nacido", this.jPanel8);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.panelDatos, -2, 1130, -2).addContainerGap()).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jTabbedPane1, -2, 1130, -2).addComponent(this.jPanel1, -2, 1130, -2)).addContainerGap(-1, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, 160, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.panelDatos, -2, 250, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jTabbedPane1, -1, 186, 32767).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtHoraIniActionPerformed(ActionEvent evt) {
        this.txtHoraFin.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtHoraIniFocusGained(FocusEvent evt) {
        this.txtHoraIni.selectAll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtHoraFinFocusGained(FocusEvent evt) {
        this.txtHoraFin.selectAll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboTipoServicioItemStateChanged(ItemEvent evt) {
        this.tipoServicio = this.cboTipoServicio.getPopupTable().getValueAt(this.cboTipoServicio.getSelectedIndex(), 0).toString();
        cargarProcedim();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnBilateralNoActionPerformed(ActionEvent evt) {
        this.bilateral = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnBilateralSiActionPerformed(ActionEvent evt) {
        this.bilateral = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnIgualViaActionPerformed(ActionEvent evt) {
        this.viaAcceso = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnDiferenteViaActionPerformed(ActionEvent evt) {
        this.viaAcceso = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnCargarActionPerformed(ActionEvent evt) {
        bajarCirugiaAlGrid();
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
        this.cboDxCompli.setSelectedItem(buscar("g_patologia", this.txtDxCompli.getText()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtCirugiaActionPerformed(ActionEvent evt) {
        this.cboCirugia.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtCirugiaFocusGained(FocusEvent evt) {
        this.txtCirugia.selectAll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtCirugiaFocusLost(FocusEvent evt) {
        this.cboCirugia.setSelectedItem(buscar("g_procedimiento", this.txtCirugia.getText()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtDxPpalActionPerformed(ActionEvent evt) {
        this.cboDxPrincipal.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtDxPpalFocusGained(FocusEvent evt) {
        this.txtDxPpal.selectAll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtDxPpalFocusLost(FocusEvent evt) {
        this.cboDxPrincipal.setSelectedItem(buscar("g_patologia", this.txtDxPpal.getText()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtDxRelActionPerformed(ActionEvent evt) {
        this.cboDxRel.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtDxRelFocusGained(FocusEvent evt) {
        this.txtDxRel.selectAll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtDxRelFocusLost(FocusEvent evt) {
        this.cboDxRel.setSelectedItem(buscar("g_patologia", this.txtDxRel.getText()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboEspecialidadItemStateChanged(ItemEvent evt) {
        cargarCirujano();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboCirugiaItemStateChanged(ItemEvent evt) {
        if (this.cboCirugia.getSelectedIndex() > -1) {
            this.txtCirugia.setText(this.cboCirugia.getPopupTable().getValueAt(this.cboCirugia.getSelectedIndex(), 0).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboDxPrincipalItemStateChanged(ItemEvent evt) {
        if (this.cboDxPrincipal.getSelectedIndex() > -1) {
            this.txtDxPpal.setText(this.cboDxPrincipal.getPopupTable().getValueAt(this.cboDxPrincipal.getSelectedIndex(), 0).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboDxPrincipalPropertyChange(PropertyChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboDxRelItemStateChanged(ItemEvent evt) {
        if (this.cboDxRel.getSelectedIndex() > -1) {
            this.txtDxRel.setText(this.cboDxRel.getPopupTable().getValueAt(this.cboDxRel.getSelectedIndex(), 0).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboDxRelPropertyChange(PropertyChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboDxCompliItemStateChanged(ItemEvent evt) {
        if (this.cboDxCompli.getSelectedIndex() > -1) {
            this.txtDxCompli.setText(this.cboDxCompli.getPopupTable().getValueAt(this.cboDxCompli.getSelectedIndex(), 0).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboDxCompliPropertyChange(PropertyChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnLiquidarActionPerformed(ActionEvent evt) {
        liquidar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chCirugiaActionPerformed(ActionEvent evt) {
        liquidar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chAnestesiologoActionPerformed(ActionEvent evt) {
        liquidar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chAyudanteActionPerformed(ActionEvent evt) {
        liquidar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chPerfusionistaActionPerformed(ActionEvent evt) {
        liquidar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chSalaActionPerformed(ActionEvent evt) {
        liquidar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chMaterialesActionPerformed(ActionEvent evt) {
        liquidar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gridKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 127) {
            this.modelo.removeRow(this.filaGrid);
            liquidar();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboTipoAnestesiaItemStateChanged(ItemEvent evt) {
        if (this.cboTipoAnestesia.getPopupTable().getValueAt(this.cboTipoAnestesia.getSelectedIndex(), 2).toString().equals("1")) {
            this.chAnestesiologo.setEnabled(true);
            this.chAnestesiologo.setSelected(true);
        } else {
            this.chAnestesiologo.setEnabled(false);
            this.chAnestesiologo.setSelected(false);
        }
        this.txtVrAnestesiologo.setValue(0);
    }
}
