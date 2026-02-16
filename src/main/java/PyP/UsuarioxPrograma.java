package PyP;

import Acceso.Principal;
import General.Persona;
import Utilidades.Autocomplete;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultCellEditor;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.JTextComponent;
import javax.swing.text.NumberFormatter;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

/* JADX INFO: loaded from: GenomaP.jar:PyP/UsuarioxPrograma.class */
public class UsuarioxPrograma extends JInternalFrame {
    private String[][] listaPrograma;
    private String[][] listaHijos;
    private String[] listaTipoParto;
    private String[] listaMotivoEgreso;
    private Object[] dato;
    private String sql;
    private String idNo;
    private String estado;
    private String fecha;
    private int tipoAccion;
    private JComboBox cboTipoParto;
    private JComboBox cboSexo;
    private JComboBox cboEstado;
    private JComboBox cboSiNo;
    private JComboBox cboGrupo;
    private JComboBox cboRh;
    public DefaultTableModel modelo;
    public DefaultTableModel modeloHijos;
    private Persona frmPersona;
    private clasePyP clasepyp;
    private ButtonGroup JBGIngresoN;
    private JButton JBTExportar;
    private JLabel JLBObservaciones;
    private JLabel JLBObservaciones1;
    private JPanel JPI_Ingreso;
    private JScrollPane JSPObservaciones;
    private JScrollPane JSPObservaciones1;
    private JFormattedTextField JTFMetaHb;
    private JTabbedPane JTP_Datos;
    private JTextField JTRuta;
    private JButton btnAnterior;
    private JRadioButton btnIngresoNo;
    private JRadioButton btnIngresoSi;
    private JButton btnNuevo;
    private JButton btnPrimer;
    private JButton btnSiguiente;
    private JButton btnUltimo;
    private JComboBox cboMotivo;
    private JComboBox cboPrograma;
    private JTable grid;
    private JTable gridHijos;
    private JCheckBox jCBfiltro;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JScrollPane jScrollPane1;
    private JPanel panelEgreso;
    private JPanel panelMaternas;
    private JPanel panelPersona;
    private JScrollPane panelProgramas;
    private JTextPane txtComplicaciones;
    public JDateChooser txtFecha;
    private JTextField txtGestacion;
    private JSpinner txtNoHijos;
    private JTextPane txtObservaciones;
    public JDateChooser txtPartoProbable;
    private JFormattedTextField txtSemanasGestacion;
    public JDateChooser txtUltimaMestruacion;
    private Metodos metodos = new Metodos();
    private ConsultasMySQL consultas = new ConsultasMySQL();
    private int cboLleno = 0;
    private int filaGrid = 0;
    private int filaGridH = 0;
    private int esIngreso = 1;
    private Metodos xmt = new Metodos();

    public UsuarioxPrograma(int tipo, clasePyP clase) {
        this.tipoAccion = 1;
        initComponents();
        this.JTFMetaHb.setValue(Double.valueOf(0.0d));
        this.clasepyp = clase;
        cargarPanelPersona();
        this.tipoAccion = tipo;
        this.txtFecha.setDate(this.metodos.getFechaActual());
        cargarCombos();
        if (tipo == 1) {
            setTitle("INGRESO A PROGRAMAS DE PROMOCIÓN Y PREVENCIÓN");
        } else {
            setTitle("EGRESO A PROGRAMAS DE PROMOCIÓN Y PREVENCIÓN");
        }
        crearGrid(0);
        if (this.tipoAccion == 1) {
            ingreso();
            this.JTP_Datos.remove(1);
        } else {
            egreso();
        }
        this.grid.addMouseListener(new MouseAdapter() { // from class: PyP.UsuarioxPrograma.1
            public void mouseClicked(MouseEvent e) {
                UsuarioxPrograma.this.filaGrid = UsuarioxPrograma.this.grid.rowAtPoint(e.getPoint());
                UsuarioxPrograma.this.cargarDatosDelGrid();
            }
        });
    }

    private void adicionarFilaGrid() {
        if (Integer.parseInt(this.txtNoHijos.getValue().toString()) > this.modeloHijos.getRowCount()) {
            this.modeloHijos.addRow(this.dato);
        } else {
            this.modeloHijos.removeRow(this.modeloHijos.getRowCount() - 1);
        }
    }

    public void mBuscar() {
        this.frmPersona.buscarPersona();
    }

    private void buscarIngreso() {
        this.sql = "SELECT FechaIngreso, EsIngreso, Cardinal, UltimaMestruacion, PartoProbable, MetaHbA1C FROM g_usuarioxprograma WHERE (Id_Usuario ='" + this.frmPersona.getIdPersona() + "' AND Id_Programa ='" + this.listaPrograma[this.cboPrograma.getSelectedIndex()][0] + "')";
        ResultSet rs = this.consultas.traerRs(this.sql);
        try {
            if (rs.next()) {
                this.txtFecha.setDate(rs.getDate(1));
                if (rs.getInt(2) == 0) {
                    this.btnIngresoSi.setSelected(true);
                } else {
                    this.btnIngresoNo.setSelected(true);
                }
                this.idNo = rs.getString(3);
                this.estado = "ACTIVA";
                this.fecha = this.metodos.formatoDMA.format((Date) rs.getDate(1));
                Principal.txtNo.setText(this.idNo);
                Principal.txtEstado.setText(this.estado);
                Principal.txtFecha.setText(this.fecha);
                this.txtUltimaMestruacion.setDate(rs.getDate(4));
                this.txtPartoProbable.setDate(rs.getDate(5));
                this.JTFMetaHb.setValue(Double.valueOf(rs.getDouble(6)));
            } else {
                this.txtFecha.setDate((Date) null);
                this.idNo = "1";
                Principal.txtNo.setText("1");
                Principal.txtEstado.setText("ACTIVA");
                Principal.txtFecha.setText(this.metodos.formatoDMA.format(this.metodos.getFechaActual()));
                this.txtUltimaMestruacion.setDate((Date) null);
                this.txtPartoProbable.setDate((Date) null);
                this.JTFMetaHb.setValue(0);
            }
            rs.close();
            this.consultas.cerrarConexionBd();
            if (this.listaPrograma[this.cboPrograma.getSelectedIndex()][1].equals("1")) {
                cargarIngresoMaterna();
            }
        } catch (SQLException ex) {
            this.consultas.mostrarErrorSQL(ex);
        }
    }

    private void buscarPartosDeMaterna() {
        this.sql = "SELECT g_partos.Cardinal, g_partos.FechaParto, g_partos.Sexo, g_partos.NacioVivo, g_partos.Peso, g_partos.Talla, g_partos.Apgar, g_partos.Tsh, g_partos.CarnetVacunacion, g_partos.Complicaciones, g_partos.GrupoSanguineo, g_partos.Rh, g_tipoparto.Nbre, g_partos.Observaciones, SemanasGestacion FROM g_partos INNER JOIN g_tipoparto ON (g_partos.TipoParto = g_tipoparto.Id) WHERE (g_partos.Id_Persona ='" + this.frmPersona.getIdPersona() + "') ORDER BY g_partos.Cardinal ASC";
        ResultSet rs = this.consultas.traerRs(this.sql);
        try {
            rs.last();
            this.listaHijos = new String[rs.getRow()][15];
            if (rs.getRow() > 0) {
                rs.beforeFirst();
                int fila = 0;
                while (rs.next()) {
                    this.listaHijos[fila][0] = rs.getString(1);
                    this.listaHijos[fila][1] = rs.getString(2);
                    this.listaHijos[fila][2] = rs.getString(3);
                    this.listaHijos[fila][3] = rs.getString(4);
                    this.listaHijos[fila][4] = rs.getString(5);
                    this.listaHijos[fila][5] = rs.getString(6);
                    this.listaHijos[fila][6] = rs.getString(7);
                    this.listaHijos[fila][7] = rs.getString(8);
                    this.listaHijos[fila][8] = rs.getString(9);
                    this.listaHijos[fila][9] = rs.getString(10);
                    this.listaHijos[fila][10] = rs.getString(11);
                    this.listaHijos[fila][11] = rs.getString(12);
                    this.listaHijos[fila][12] = rs.getString(13);
                    this.listaHijos[fila][13] = rs.getString(14);
                    this.listaHijos[fila][14] = rs.getString(15);
                    this.txtSemanasGestacion.setValue(Integer.valueOf(rs.getInt(15)));
                    this.idNo = rs.getString(1);
                    this.estado = "ACTIVA";
                    this.fecha = rs.getString(2);
                    Principal.txtNo.setText(this.idNo);
                    Principal.txtEstado.setText(this.estado);
                    Principal.txtFecha.setText(this.fecha);
                    fila++;
                }
                this.btnUltimo.doClick();
            }
            rs.close();
            this.consultas.cerrarConexionBd();
        } catch (SQLException ex) {
            this.consultas.mostrarErrorSQL(ex);
        }
    }

    private void cargarCombos() {
        this.listaPrograma = this.consultas.llenarComboyLista("SELECT\n    `g_tipoprograma`.`Id_TipoPrograma`\n    , UCASE(`g_tipoprograma`.`Nbre`)\n    , `g_tipoprograma`.`EsPrenatal`\nFROM\n    `g_usuarioxprograma`\n    INNER JOIN `g_tipoprograma` \n        ON (`g_usuarioxprograma`.`Id_Programa` = `g_tipoprograma`.`Id_TipoPrograma`)\nGROUP BY `g_tipoprograma`.`Id_TipoPrograma`\nORDER BY `g_tipoprograma`.`Nbre` ASC", this.listaPrograma, this.cboPrograma, 3);
        JTextComponent editor = this.cboPrograma.getEditor().getEditorComponent();
        editor.setDocument(new Autocomplete(this.cboPrograma));
        this.cboPrograma.setSelectedIndex(-1);
        this.cboLleno = 1;
        this.consultas.cerrarConexionBd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cargarDatosDelGrid() {
        this.frmPersona.setIdPersona(this.modelo.getValueAt(this.filaGrid, 0).toString());
        this.frmPersona.txtHistoria.setText(this.modelo.getValueAt(this.filaGrid, 1).toString());
        this.frmPersona.txtHistoria.requestFocus();
        this.frmPersona.txtHistoria.transferFocus();
        buscarIngreso();
        if (this.listaPrograma[this.cboPrograma.getSelectedIndex()][1].equals("1")) {
            buscarPartosDeMaterna();
        }
    }

    private void cargarPanelPersona() {
        this.frmPersona = new Persona(this);
        this.frmPersona.setBounds(15, 10, 980, 160);
        this.panelPersona.add(this.frmPersona);
        this.panelPersona.setVisible(true);
        this.frmPersona.setVisible(true);
    }

    private void cargarObjetosGridHijos() {
        TableColumn tipoPartoCol = this.gridHijos.getColumnModel().getColumn(1);
        TableColumn sexoCol = this.gridHijos.getColumnModel().getColumn(2);
        TableColumn estadoCol = this.gridHijos.getColumnModel().getColumn(3);
        TableColumn tshCol = this.gridHijos.getColumnModel().getColumn(7);
        TableColumn carnetCol = this.gridHijos.getColumnModel().getColumn(8);
        TableColumn grupoCol = this.gridHijos.getColumnModel().getColumn(9);
        TableColumn rhCol = this.gridHijos.getColumnModel().getColumn(10);
        this.cboTipoParto = new JComboBox();
        this.cboSexo = new JComboBox();
        this.cboEstado = new JComboBox();
        this.cboSiNo = new JComboBox();
        this.cboGrupo = new JComboBox();
        this.cboRh = new JComboBox();
        this.listaTipoParto = this.consultas.llenarCombo("SELECT Id, Nbre FROM g_tipoparto WHERE (Estado =0) ORDER BY Nbre ASC", this.listaTipoParto, this.cboTipoParto);
        tipoPartoCol.setCellEditor(new DefaultCellEditor(this.cboTipoParto));
        this.cboSexo.addItem("Femenino");
        this.cboSexo.addItem("Masculino");
        this.cboSexo.addItem("Indeterminado");
        sexoCol.setCellEditor(new DefaultCellEditor(this.cboSexo));
        this.cboEstado.addItem("Vivo");
        this.cboEstado.addItem("Muerto");
        estadoCol.setCellEditor(new DefaultCellEditor(this.cboEstado));
        this.cboSiNo.addItem("Si");
        this.cboSiNo.addItem("No");
        tshCol.setCellEditor(new DefaultCellEditor(this.cboSiNo));
        carnetCol.setCellEditor(new DefaultCellEditor(this.cboSiNo));
        this.cboGrupo.addItem("A");
        this.cboGrupo.addItem("B");
        this.cboGrupo.addItem("O");
        this.cboGrupo.addItem("AB");
        grupoCol.setCellEditor(new DefaultCellEditor(this.cboGrupo));
        this.cboRh.addItem("Positivo");
        this.cboRh.addItem("Negativo");
        rhCol.setCellEditor(new DefaultCellEditor(this.cboRh));
    }

    private void cargarUsuariosDelPrograma() {
        if (this.listaPrograma[this.cboPrograma.getSelectedIndex()][1].equals("1")) {
            this.JTP_Datos.setEnabledAt(1, true);
            this.txtSemanasGestacion.setEnabled(true);
            this.btnNuevo.setEnabled(true);
            this.btnAnterior.setEnabled(true);
            this.btnPrimer.setEnabled(true);
            this.btnSiguiente.setEnabled(true);
            this.btnUltimo.setEnabled(true);
            this.gridHijos.setEnabled(true);
            this.txtComplicaciones.setEnabled(true);
            this.txtObservaciones.setEnabled(true);
            crearGrid(1);
        } else {
            this.JTP_Datos.setEnabledAt(1, false);
            this.txtSemanasGestacion.setEnabled(false);
            this.btnNuevo.setEnabled(false);
            this.btnAnterior.setEnabled(false);
            this.btnPrimer.setEnabled(false);
            this.btnSiguiente.setEnabled(false);
            this.btnUltimo.setEnabled(false);
            this.gridHijos.setEnabled(false);
            this.txtComplicaciones.setEnabled(false);
            this.txtObservaciones.setEnabled(false);
            crearGrid(0);
        }
        if (this.jCBfiltro.isSelected()) {
            this.sql = "SELECT w_persona.Id_persona, w_persona.NoHistoria, w_persona.NUsuario, g_usuarioxprograma.Cardinal, g_usuarioxprograma.Estado, \n g_usuarioxprograma.EsIngreso, IFNULL(g_usuarioxprograma.FechaIngreso, '1845-01-01')  FechaIngreso \n  FROM w_persona INNER JOIN g_usuarioxprograma ON (w_persona.Id_persona = g_usuarioxprograma.Id_Usuario)  \n  WHERE (g_usuarioxprograma.Id_Programa ='" + this.listaPrograma[this.cboPrograma.getSelectedIndex()][0] + "' AND g_usuarioxprograma.Estado = 0 AND w_persona.Id_persona='" + this.frmPersona.getIdPersona() + "' ) ORDER BY w_persona.NUsuario ASC ;\n";
        } else {
            this.sql = "SELECT w_persona.Id_persona, w_persona.NoHistoria, w_persona.NUsuario, g_usuarioxprograma.Cardinal, g_usuarioxprograma.Estado,\n g_usuarioxprograma.EsIngreso, IFNULL(g_usuarioxprograma.FechaIngreso, '1845-01-01')  FechaIngreso\n FROM w_persona INNER JOIN g_usuarioxprograma ON (w_persona.Id_persona = g_usuarioxprograma.Id_Usuario) \nWHERE (g_usuarioxprograma.Id_Programa ='" + this.listaPrograma[this.cboPrograma.getSelectedIndex()][0] + "' AND g_usuarioxprograma.Estado = 0) ORDER BY w_persona.NUsuario ASC";
        }
        ResultSet rs = this.consultas.traerRs(this.sql);
        while (rs.next()) {
            try {
                this.modelo.addRow(this.dato);
                this.modelo.setValueAt(rs.getString(1), this.filaGrid, 0);
                this.modelo.setValueAt(rs.getString(2), this.filaGrid, 1);
                this.modelo.setValueAt(rs.getString(3), this.filaGrid, 2);
                this.modelo.setValueAt(rs.getString(4), this.filaGrid, 3);
                if (rs.getInt(5) == 0) {
                    this.modelo.setValueAt("Activo", this.filaGrid, 4);
                } else {
                    this.modelo.setValueAt("InActivo", this.filaGrid, 4);
                }
                if (rs.getInt(6) == 0) {
                    this.modelo.setValueAt("Si", this.filaGrid, 5);
                } else {
                    this.modelo.setValueAt("No", this.filaGrid, 5);
                }
                this.modelo.setValueAt(this.metodos.formatoAMD.format((Date) rs.getDate(7)), this.filaGrid, 6);
                this.filaGrid++;
            } catch (SQLException ex) {
                this.consultas.mostrarErrorSQL(ex);
                return;
            }
        }
        rs.close();
        this.consultas.cerrarConexionBd();
    }

    private void crearGrid(int op) {
        this.modelo = new DefaultTableModel() { // from class: PyP.UsuarioxPrograma.2
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.modelo.addColumn("");
        this.modelo.addColumn("Historia");
        this.modelo.addColumn("Usuario");
        this.modelo.addColumn("Cardinal");
        this.modelo.addColumn("Estado");
        this.modelo.addColumn("Es Ingreso");
        this.modelo.addColumn("Fecha Ingreso");
        if (op == 1) {
            this.modelo.addColumn("U. Mestruación");
            this.modelo.addColumn("Parto Probable");
        }
        this.grid.setModel(this.modelo);
        this.grid.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.grid.getColumnModel().getColumn(0).setMinWidth(0);
        this.grid.getColumnModel().getColumn(0).setMaxWidth(0);
        this.grid.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(1).setMinWidth(100);
        this.grid.getColumnModel().getColumn(1).setMaxWidth(100);
        this.grid.getColumnModel().getColumn(2).setPreferredWidth(300);
        this.grid.getColumnModel().getColumn(2).setMinWidth(300);
        this.grid.getColumnModel().getColumn(2).setMaxWidth(300);
        this.grid.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(3).setMinWidth(100);
        this.grid.getColumnModel().getColumn(3).setMaxWidth(100);
        this.grid.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(4).setMinWidth(100);
        this.grid.getColumnModel().getColumn(4).setMaxWidth(100);
        this.grid.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(5).setMinWidth(100);
        this.grid.getColumnModel().getColumn(5).setMaxWidth(100);
        this.grid.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(6).setMinWidth(100);
        this.grid.getColumnModel().getColumn(6).setMaxWidth(100);
        this.filaGrid = 0;
    }

    private void crearGridHijos() {
        this.modeloHijos = new DefaultTableModel();
        this.modeloHijos.addColumn("Fecha");
        this.modeloHijos.addColumn("Tipo Parto");
        this.modeloHijos.addColumn("Sexo");
        this.modeloHijos.addColumn("Estado");
        this.modeloHijos.addColumn("Peso");
        this.modeloHijos.addColumn("Talla");
        this.modeloHijos.addColumn("Apgar");
        this.modeloHijos.addColumn("TSH");
        this.modeloHijos.addColumn("Carnet V.");
        this.modeloHijos.addColumn("Grupo S.");
        this.modeloHijos.addColumn("RH");
        this.gridHijos.setModel(this.modeloHijos);
        this.gridHijos.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.gridHijos.getColumnModel().getColumn(0).setMinWidth(80);
        this.gridHijos.getColumnModel().getColumn(0).setMaxWidth(80);
        this.gridHijos.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.gridHijos.getColumnModel().getColumn(1).setMinWidth(100);
        this.gridHijos.getColumnModel().getColumn(1).setMaxWidth(100);
        this.gridHijos.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.gridHijos.getColumnModel().getColumn(2).setMinWidth(100);
        this.gridHijos.getColumnModel().getColumn(2).setMaxWidth(100);
        this.gridHijos.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.gridHijos.getColumnModel().getColumn(3).setMinWidth(100);
        this.gridHijos.getColumnModel().getColumn(3).setMaxWidth(100);
        this.gridHijos.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.gridHijos.getColumnModel().getColumn(4).setMinWidth(100);
        this.gridHijos.getColumnModel().getColumn(4).setMaxWidth(100);
        this.gridHijos.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.gridHijos.getColumnModel().getColumn(5).setMinWidth(100);
        this.gridHijos.getColumnModel().getColumn(5).setMaxWidth(100);
        this.gridHijos.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.gridHijos.getColumnModel().getColumn(6).setMinWidth(100);
        this.gridHijos.getColumnModel().getColumn(6).setMaxWidth(100);
        this.gridHijos.getColumnModel().getColumn(7).setPreferredWidth(50);
        this.gridHijos.getColumnModel().getColumn(7).setMinWidth(50);
        this.gridHijos.getColumnModel().getColumn(7).setMaxWidth(50);
        this.gridHijos.getColumnModel().getColumn(8).setPreferredWidth(100);
        this.gridHijos.getColumnModel().getColumn(8).setMinWidth(100);
        this.gridHijos.getColumnModel().getColumn(8).setMaxWidth(100);
        this.gridHijos.getColumnModel().getColumn(9).setPreferredWidth(100);
        this.gridHijos.getColumnModel().getColumn(9).setMinWidth(100);
        this.gridHijos.getColumnModel().getColumn(9).setMaxWidth(100);
        this.gridHijos.getColumnModel().getColumn(10).setPreferredWidth(50);
        this.gridHijos.getColumnModel().getColumn(10).setMinWidth(50);
        this.gridHijos.getColumnModel().getColumn(10).setMaxWidth(50);
        this.filaGridH = 0;
        cargarObjetosGridHijos();
    }

    private void desplazarRegistro(int puntero) {
        switch (puntero) {
            case 1:
                this.txtGestacion.setText("1");
                mostrarPartos();
                break;
            case 2:
                if (Integer.parseInt(this.txtGestacion.getText()) > 1) {
                    this.txtGestacion.setText(String.valueOf(Integer.parseInt(this.txtGestacion.getText()) - 1));
                    mostrarPartos();
                }
                break;
            case 3:
                if (Integer.parseInt(this.txtGestacion.getText()) < Integer.parseInt(this.listaHijos[this.listaHijos.length - 1][0].toString())) {
                    this.txtGestacion.setText(String.valueOf(Integer.parseInt(this.txtGestacion.getText()) + 1));
                    mostrarPartos();
                }
                break;
            case 4:
                this.txtGestacion.setText(String.valueOf(this.listaHijos[this.listaHijos.length - 1][0]));
                mostrarPartos();
                break;
        }
    }

    private String devolverValor(int tipo, String op) {
        String resultado = "";
        switch (tipo) {
            case 1:
                if (op.equals("Masculino")) {
                    resultado = "0";
                } else if (op.equals("Femenino")) {
                    resultado = "1";
                } else {
                    resultado = "2";
                }
                break;
            case 2:
                resultado = op.equals("Si") ? "0" : "1";
                break;
            case 3:
                String sql1 = "SELECT Id FROM g_tipoparto WHERE Nbre ='" + this.modeloHijos.getValueAt(this.filaGridH - 1, 1) + "' AND Estado =0";
                String dato1 = this.consultas.traerDato(sql1);
                if (dato1.isEmpty()) {
                    this.metodos.mostrarMensaje("Por favor seleccione un Tipo de Parto");
                } else {
                    resultado = dato1;
                }
                break;
            case 4:
                resultado = op.equals("Positivo") ? "0" : "1";
                break;
        }
        return resultado;
    }

    private void egreso() {
        this.txtFecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Egreso", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.btnIngresoSi.setEnabled(false);
        this.btnIngresoNo.setEnabled(false);
        this.listaMotivoEgreso = this.consultas.llenarCombo("SELECT Id, Nbre FROM p_motivoegreso WHERE (Estado =0) ORDER BY Nbre ASC", this.listaMotivoEgreso, this.cboMotivo);
        JTextComponent editor = this.cboMotivo.getEditor().getEditorComponent();
        editor.setDocument(new Autocomplete(this.cboMotivo));
        this.cboMotivo.setSelectedIndex(0);
        this.consultas.cerrarConexionBd();
    }

    public void grabar() {
        if (!this.frmPersona.getIdPersona().equals("0")) {
            if (this.cboPrograma.getSelectedIndex() > -1) {
                if (this.metodos.getPregunta("Esta seguro de Grabar? ") == 0) {
                    if (this.tipoAccion == 1) {
                        grabarIngreso();
                    } else {
                        grabarEgreso();
                    }
                    cargarUsuariosDelPrograma();
                    return;
                }
                return;
            }
            this.metodos.mostrarMensaje("Debe seleccionar un Programa");
            this.cboPrograma.requestFocus();
            return;
        }
        this.metodos.mostrarMensaje("Por favor seleccione un Usuario");
    }

    private void grabarEgreso() {
        this.sql = "UPDATE g_usuarioxprograma SET Estado = 1, FechaEgreso ='" + this.metodos.formatoAMD.format(this.txtFecha.getDate()) + "', MotivoEgreso ='" + this.listaMotivoEgreso[this.cboMotivo.getSelectedIndex()] + "', Fecha ='" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "', UsuarioS ='" + Principal.usuarioSistemaDTO.getLogin() + "' WHERE (Id_Usuario ='" + this.frmPersona.getIdPersona() + "' AND Id_Programa ='" + this.listaPrograma[this.cboPrograma.getSelectedIndex()][0] + "')";
        this.consultas.ejecutarSQL(this.sql);
        this.consultas.cerrarConexionBd();
        this.modelo.removeRow(this.filaGrid);
        if (this.listaPrograma[this.cboPrograma.getSelectedIndex()][1].equals("1")) {
            egresarMaterna();
        }
        this.metodos.mostrarMensaje("Usuario Egresado del Programa.");
    }

    private void egresarMaterna() {
        this.sql = "UPDATE g_partos SET FechaParto ='" + this.modeloHijos.getValueAt(0, 0) + "', Sexo ='" + devolverValor(1, this.modeloHijos.getValueAt(0, 2).toString()) + "', NacioVivo ='" + devolverValor(2, this.modeloHijos.getValueAt(0, 3).toString()) + "', Peso ='" + this.modeloHijos.getValueAt(0, 4) + "', Talla ='" + this.modeloHijos.getValueAt(0, 5) + "', Apgar ='" + this.modeloHijos.getValueAt(0, 6) + "', Tsh ='" + devolverValor(2, this.modeloHijos.getValueAt(0, 7).toString()) + "', CarnetVacunacion ='" + devolverValor(2, this.modeloHijos.getValueAt(0, 8).toString()) + "', Complicaciones ='" + this.txtComplicaciones.getText() + "', GrupoSamguineo ='" + this.modeloHijos.getValueAt(0, 9) + "', Rh ='" + devolverValor(4, this.modeloHijos.getValueAt(0, 10).toString()) + "', TipoParto ='" + devolverValor(3, this.modeloHijos.getValueAt(0, 1).toString()) + "', Observaciones ='" + this.txtObservaciones.getText() + "', Fecha ='" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "', UsuarioS ='" + Principal.usuarioSistemaDTO.getLogin() + "') WHERE (Id_Persona ='" + this.frmPersona.getIdPersona() + "' AND Cardinal ='" + this.txtGestacion.getText() + "')";
        this.consultas.ejecutarSQL(this.sql);
        this.consultas.cerrarConexionBd();
        for (int i = 1; i <= this.modeloHijos.getRowCount(); i++) {
            this.sql = "INSERT INTO g_partos (Id_Persona, Cardinal, FechaParto, Sexo, NacioVivo, Peso, Talla, Apgar, Tsh, CarnetVacunacion, Complicaciones, GrupoSanguineo, Rh, TipoParto, Observaciones, Fecha, UsuarioS) VALUES ('" + this.frmPersona.getIdPersona() + "','" + this.txtGestacion.getText() + "','" + this.modeloHijos.getValueAt(i, 0) + "','" + devolverValor(1, this.modeloHijos.getValueAt(i, 2).toString()) + "','" + devolverValor(2, this.modeloHijos.getValueAt(i, 3).toString()) + "','" + this.modeloHijos.getValueAt(i, 4) + "','" + this.modeloHijos.getValueAt(i, 5) + "','" + this.modeloHijos.getValueAt(i, 6) + "','" + devolverValor(2, this.modeloHijos.getValueAt(i, 7).toString()) + "','" + devolverValor(2, this.modeloHijos.getValueAt(i, 8).toString()) + "','" + this.txtComplicaciones.getText() + "','" + this.modeloHijos.getValueAt(i, 9) + "','" + devolverValor(4, this.modeloHijos.getValueAt(i, 10).toString()) + "','" + devolverValor(3, this.modeloHijos.getValueAt(i, 1).toString()) + "','" + this.txtObservaciones.getText() + "','" + this.txtSemanasGestacion.getValue() + "','" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
            this.consultas.ejecutarSQL(this.sql);
            this.consultas.cerrarConexionBd();
        }
    }

    private void grabarIngreso() {
        this.sql = "SELECT Cardinal, Estado FROM g_usuarioxprograma WHERE Id_Usuario ='" + this.frmPersona.getIdPersona() + "' AND Id_Programa ='" + this.listaPrograma[this.cboPrograma.getSelectedIndex()][0] + "' ORDER BY FechaIngreso DESC";
        ResultSet rs = this.consultas.traerRs(this.sql);
        try {
            if (rs.next()) {
                if (rs.getString("Estado").equals("0")) {
                    this.sql = "UPDATE g_usuarioxprograma SET FechaIngreso ='" + this.metodos.formatoAMD.format(this.txtFecha.getDate()) + "', Fecha ='" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "', UsuarioS ='" + Principal.usuarioSistemaDTO.getLogin() + "' WHERE (Id_Usuario ='" + this.frmPersona.getIdPersona() + "' AND Id_Programa ='" + this.listaPrograma[this.cboPrograma.getSelectedIndex()][0] + "')";
                    this.consultas.ejecutarSQL(this.sql);
                    this.metodos.mostrarMensaje("Ingreso Actualizado con los nuevos valores");
                } else if (rs.getString("Estado").equals("1")) {
                    this.sql = "INSERT INTO g_usuarioxprograma(Id_Usuario, Id_Programa, cardinal, EsIngreso, FechaIngreso,MetaHbA1C, Fecha, UsuarioS) VALUES('" + this.frmPersona.getIdPersona() + "','" + this.listaPrograma[this.cboPrograma.getSelectedIndex()][0] + "','" + (rs.getInt(1) + 1) + "','" + this.esIngreso + "','" + this.metodos.formatoAMD.format(this.txtFecha.getDate()) + "','" + Double.valueOf(this.JTFMetaHb.getValue().toString()) + "','" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                    this.consultas.ejecutarSQL(this.sql);
                    this.metodos.mostrarMensaje("Se creo un nuevo Ingreso");
                }
                this.consultas.cerrarConexionBd();
                cargarUsuariosDelPrograma();
                if (this.listaPrograma[this.cboPrograma.getSelectedIndex()][1].equals("1")) {
                    grabarIngresoMaterna();
                    cargarIngresoMaterna();
                }
            } else {
                this.sql = "INSERT INTO g_usuarioxprograma(Id_Usuario, Id_Programa, cardinal, EsIngreso, FechaIngreso,MetaHbA1C, Fecha, UsuarioS) VALUES('" + this.frmPersona.getIdPersona() + "','" + this.listaPrograma[this.cboPrograma.getSelectedIndex()][0] + "','1','" + this.esIngreso + "','" + this.metodos.formatoAMD.format(this.txtFecha.getDate()) + "','" + Double.valueOf(this.JTFMetaHb.getValue().toString()) + "','" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                this.consultas.ejecutarSQL(this.sql);
                this.metodos.mostrarMensaje("Ingreso Grabado");
            }
            rs.close();
        } catch (SQLException ex) {
            this.consultas.mostrarErrorSQL(ex);
        }
    }

    private void cargarIngresoMaterna() {
        this.sql = "SELECT SemanasGestacion, UltimaMestruacion, PartoProbable FROM g_partos WHERE Id_Persona ='" + this.frmPersona.getIdPersona() + "' AND Cardinal ='" + this.idNo + "' ORDER BY Cardinal";
        ResultSet rs = this.consultas.traerRs(this.sql);
        while (rs.next()) {
            try {
                this.txtSemanasGestacion.setText(rs.getString(1));
                if (rs.getDate(2) != null) {
                    this.txtUltimaMestruacion.setDate(rs.getDate(2));
                }
                if (rs.getDate(3) != null) {
                    this.txtPartoProbable.setDate(rs.getDate(3));
                }
            } catch (SQLException ex) {
                this.consultas.mostrarErrorSQL(ex);
            }
        }
        rs.close();
        this.consultas.cerrarConexionBd();
        this.consultas.cerrarConexionBd();
    }

    private void grabarIngresoMaterna() {
        this.sql = "INSERT IGNORE INTO g_partos (Id_Persona, Cardinal, SemanasGestacion, TipoParto, UltimaMestruacion, PartoProbable, Fecha, UsuarioS) VALUES ('" + this.frmPersona.getIdPersona() + "','" + this.txtGestacion.getText() + "','" + this.txtSemanasGestacion.getValue() + "','1','" + this.metodos.formatoAMD.format(this.txtUltimaMestruacion.getDate()) + "','" + this.metodos.formatoAMD.format(this.txtPartoProbable.getDate()) + "','" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
        this.consultas.ejecutarSQL(this.sql);
        this.consultas.cerrarConexionBd();
    }

    private void ingreso() {
        this.txtFecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha de ingreso", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.btnIngresoSi.setEnabled(true);
        this.btnIngresoNo.setEnabled(true);
        this.btnNuevo.setEnabled(false);
        this.btnPrimer.setEnabled(false);
        this.btnSiguiente.setEnabled(false);
        this.btnUltimo.setEnabled(false);
        this.gridHijos.setEnabled(false);
        this.txtComplicaciones.setEnabled(false);
        this.txtObservaciones.setEnabled(false);
        this.panelEgreso.setVisible(false);
        this.panelProgramas.setSize(1050, 420);
    }

    public void imprimir() {
        this.metodos.mostrarMensaje("Aqui se debe imprimir el listado de Usuarios del Programa");
    }

    private void mostrarPartos() {
        crearGridHijos();
        for (int i = 0; i < this.listaHijos.length; i++) {
            if (this.listaHijos[i][0].equals(this.txtGestacion.getText())) {
                this.modeloHijos.addRow(this.dato);
                if (this.listaHijos[i][1] != null) {
                    this.modeloHijos.setValueAt(this.listaHijos[i][1].substring(0, 10), this.filaGridH, 0);
                }
                this.modeloHijos.setValueAt(this.listaHijos[i][12], this.filaGridH, 1);
                if (this.listaHijos[i][2].equals("0")) {
                    this.modeloHijos.setValueAt("Masculino", this.filaGridH, 2);
                } else if (this.listaHijos[i][2].equals("1")) {
                    this.modeloHijos.setValueAt("Femenino", this.filaGridH, 2);
                } else {
                    this.modeloHijos.setValueAt("Indeterminado", this.filaGridH, 2);
                }
                if (this.listaHijos[i][3].equals("0")) {
                    this.modeloHijos.setValueAt("Vivo", this.filaGridH, 3);
                } else {
                    this.modeloHijos.setValueAt("Muerto", this.filaGridH, 3);
                }
                this.modeloHijos.setValueAt(this.listaHijos[i][4], this.filaGridH, 4);
                this.modeloHijos.setValueAt(this.listaHijos[i][5], this.filaGridH, 5);
                this.modeloHijos.setValueAt(this.listaHijos[i][6], this.filaGridH, 6);
                if (this.listaHijos[i][7].equals("0")) {
                    this.modeloHijos.setValueAt("Si", this.filaGridH, 7);
                } else {
                    this.modeloHijos.setValueAt("No", this.filaGridH, 7);
                }
                if (this.listaHijos[i][8].equals("0")) {
                    this.modeloHijos.setValueAt("Si", this.filaGridH, 8);
                } else {
                    this.modeloHijos.setValueAt("No", this.filaGridH, 8);
                }
                this.modeloHijos.setValueAt(this.listaHijos[i][10], this.filaGridH, 9);
                if (this.listaHijos[i][11].equals("0")) {
                    this.modeloHijos.setValueAt("Positivo", this.filaGridH, 10);
                } else {
                    this.modeloHijos.setValueAt("Negativo", this.filaGridH, 10);
                }
                this.txtComplicaciones.setText(this.listaHijos[i][9]);
                this.txtObservaciones.setText(this.listaHijos[i][13]);
                this.filaGridH++;
            }
        }
    }

    public void nuevo() {
        this.frmPersona.nuevo();
        crearGridHijos();
        this.idNo = "1";
        this.estado = "ACTIVA";
        this.fecha = this.metodos.formatoDMA.format(this.metodos.getFechaActual());
        Principal.txtNo.setText(this.idNo);
        Principal.txtEstado.setText(this.estado);
        Principal.txtFecha.setText(this.fecha);
        this.txtComplicaciones.setText("");
        this.txtObservaciones.setText("");
    }

    private void nuevoParto() {
        crearGridHijos();
        this.txtNoHijos.setValue(1);
        this.txtGestacion.setText(String.valueOf(Integer.parseInt(this.txtGestacion.getText()) + 1));
        this.modeloHijos.addRow(this.dato);
    }

    /* JADX WARN: Type inference failed for: r3v73, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGIngresoN = new ButtonGroup();
        this.panelPersona = new JPanel();
        this.cboPrograma = new JComboBox();
        this.jLabel2 = new JLabel();
        this.JTP_Datos = new JTabbedPane();
        this.JPI_Ingreso = new JPanel();
        this.txtFecha = new JDateChooser();
        this.jPanel1 = new JPanel();
        this.btnIngresoSi = new JRadioButton();
        this.btnIngresoNo = new JRadioButton();
        this.JTFMetaHb = new JFormattedTextField();
        this.jPanel2 = new JPanel();
        this.txtSemanasGestacion = new JFormattedTextField();
        this.txtUltimaMestruacion = new JDateChooser();
        this.txtPartoProbable = new JDateChooser();
        this.jPanel3 = new JPanel();
        this.panelEgreso = new JPanel();
        this.jLabel1 = new JLabel();
        this.cboMotivo = new JComboBox();
        this.panelMaternas = new JPanel();
        this.JSPObservaciones = new JScrollPane();
        this.txtComplicaciones = new JTextPane();
        this.JLBObservaciones = new JLabel();
        this.jScrollPane1 = new JScrollPane();
        this.gridHijos = new JTable();
        this.JLBObservaciones1 = new JLabel();
        this.JSPObservaciones1 = new JScrollPane();
        this.txtObservaciones = new JTextPane();
        this.btnNuevo = new JButton();
        this.btnPrimer = new JButton();
        this.btnAnterior = new JButton();
        this.txtGestacion = new JTextField();
        this.btnSiguiente = new JButton();
        this.btnUltimo = new JButton();
        this.txtNoHijos = new JSpinner();
        this.jLabel4 = new JLabel();
        this.jLabel5 = new JLabel();
        this.panelProgramas = new JScrollPane();
        this.grid = new JTable();
        this.jCBfiltro = new JCheckBox();
        this.JBTExportar = new JButton();
        this.JTRuta = new JTextField();
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMaximumSize(null);
        setMinimumSize(null);
        setName("UsuarioxPrograma");
        addInternalFrameListener(new InternalFrameListener() { // from class: PyP.UsuarioxPrograma.3
            public void internalFrameActivated(InternalFrameEvent evt) {
                UsuarioxPrograma.this.formInternalFrameActivated(evt);
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
            }

            public void internalFrameDeactivated(InternalFrameEvent evt) {
            }

            public void internalFrameDeiconified(InternalFrameEvent evt) {
            }

            public void internalFrameIconified(InternalFrameEvent evt) {
            }

            public void internalFrameOpened(InternalFrameEvent evt) {
            }
        });
        this.panelPersona.setLayout((LayoutManager) null);
        this.cboPrograma.setFont(new Font("Arial", 1, 12));
        this.cboPrograma.setBorder(BorderFactory.createTitledBorder((Border) null, "Programa", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.cboPrograma.addItemListener(new ItemListener() { // from class: PyP.UsuarioxPrograma.4
            public void itemStateChanged(ItemEvent evt) {
                UsuarioxPrograma.this.cboProgramaItemStateChanged(evt);
            }
        });
        this.jLabel2.setIcon(new ImageIcon(getClass().getResource("/Imagenes/buscarCita.jpg")));
        this.JTP_Datos.setForeground(Color.red);
        this.JTP_Datos.setFont(new Font("Arial", 1, 14));
        this.txtFecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha de ingreso", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtFecha.setDateFormatString("dd/MM/yyyy");
        this.txtFecha.setFont(new Font("Arial", 1, 12));
        this.jPanel1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createBevelBorder(0), "Diagnóstico Nuevo", 0, 0, new Font("Arial", 1, 12)));
        this.JBGIngresoN.add(this.btnIngresoSi);
        this.btnIngresoSi.setFont(new Font("Arial", 1, 12));
        this.btnIngresoSi.setForeground(new Color(0, 0, 153));
        this.btnIngresoSi.setText("Si");
        this.btnIngresoSi.addActionListener(new ActionListener() { // from class: PyP.UsuarioxPrograma.5
            public void actionPerformed(ActionEvent evt) {
                UsuarioxPrograma.this.btnIngresoSiActionPerformed(evt);
            }
        });
        this.JBGIngresoN.add(this.btnIngresoNo);
        this.btnIngresoNo.setFont(new Font("Arial", 1, 12));
        this.btnIngresoNo.setForeground(new Color(0, 0, 153));
        this.btnIngresoNo.setSelected(true);
        this.btnIngresoNo.setText("No");
        this.btnIngresoNo.addActionListener(new ActionListener() { // from class: PyP.UsuarioxPrograma.6
            public void actionPerformed(ActionEvent evt) {
                UsuarioxPrograma.this.btnIngresoNoActionPerformed(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.btnIngresoSi, -2, 40, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 25, 32767).addComponent(this.btnIngresoNo).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.btnIngresoNo).addComponent(this.btnIngresoSi)).addGap(0, 14, 32767)));
        this.JTFMetaHb.setBorder(BorderFactory.createTitledBorder((Border) null, "Meta Hb A1C", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFMetaHb.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.00"))));
        this.JTFMetaHb.setText("0");
        this.JTFMetaHb.setToolTipText("Hb Glicosilada");
        this.JTFMetaHb.setFont(new Font("Arial", 1, 12));
        this.jPanel2.setBorder(BorderFactory.createTitledBorder((Border) null, "Maternas", 0, 0, new Font("Arial", 1, 12)));
        this.jPanel2.setLayout(new AbsoluteLayout());
        this.txtSemanasGestacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Gestación (Semanas)", 0, 0, new Font("Arial", 1, 12)));
        this.txtSemanasGestacion.setForeground(new Color(0, 0, 153));
        this.txtSemanasGestacion.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.0"))));
        this.txtSemanasGestacion.setHorizontalAlignment(0);
        this.txtSemanasGestacion.setToolTipText("Semanas de gestación");
        this.txtSemanasGestacion.setFont(new Font("Arial", 1, 12));
        this.txtSemanasGestacion.addActionListener(new ActionListener() { // from class: PyP.UsuarioxPrograma.7
            public void actionPerformed(ActionEvent evt) {
                UsuarioxPrograma.this.txtSemanasGestacionActionPerformed(evt);
            }
        });
        this.jPanel2.add(this.txtSemanasGestacion, new AbsoluteConstraints(10, 20, 150, 50));
        this.txtUltimaMestruacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Ultima Mestruación", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 153)));
        this.txtUltimaMestruacion.setDateFormatString("dd/MM/yyyy");
        this.txtUltimaMestruacion.setFont(new Font("Arial", 1, 12));
        this.jPanel2.add(this.txtUltimaMestruacion, new AbsoluteConstraints(170, 20, 170, 50));
        this.txtPartoProbable.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Probable Parto", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 153)));
        this.txtPartoProbable.setDateFormatString("dd/MM/yyyy");
        this.txtPartoProbable.setFont(new Font("Arial", 1, 12));
        this.jPanel2.add(this.txtPartoProbable, new AbsoluteConstraints(350, 20, 140, 50));
        GroupLayout JPI_IngresoLayout = new GroupLayout(this.JPI_Ingreso);
        this.JPI_Ingreso.setLayout(JPI_IngresoLayout);
        JPI_IngresoLayout.setHorizontalGroup(JPI_IngresoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_IngresoLayout.createSequentialGroup().addContainerGap().addGroup(JPI_IngresoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_IngresoLayout.createSequentialGroup().addComponent(this.txtFecha, -2, 120, -2).addGap(10, 10, 10).addComponent(this.jPanel1, -2, -1, -2).addGap(10, 10, 10).addComponent(this.JTFMetaHb, -2, 100, -2)).addComponent(this.jPanel2, -2, 510, -2)).addContainerGap(605, 32767)));
        JPI_IngresoLayout.setVerticalGroup(JPI_IngresoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_IngresoLayout.createSequentialGroup().addContainerGap().addGroup(JPI_IngresoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -2, -1, -2).addGroup(JPI_IngresoLayout.createSequentialGroup().addGap(10, 10, 10).addGroup(JPI_IngresoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.txtFecha, -2, 50, -2).addComponent(this.JTFMetaHb, -2, 50, -2)))).addGap(18, 18, 18).addComponent(this.jPanel2, -2, 80, -2).addContainerGap(179, 32767)));
        this.JTP_Datos.addTab("DATOS DE INGRESO", this.JPI_Ingreso);
        this.panelEgreso.setBackground(new Color(102, 102, 255));
        this.panelEgreso.setBorder(BorderFactory.createTitledBorder((Border) null, "Información de Egreso", 0, 0, new Font("Arial", 1, 12), new Color(255, 255, 255)));
        this.jLabel1.setFont(new Font("Arial", 1, 12));
        this.jLabel1.setForeground(new Color(204, 255, 255));
        this.jLabel1.setText("Motivo");
        this.cboMotivo.setFont(new Font("Arial", 1, 12));
        this.panelMaternas.setBackground(new Color(204, 204, 255));
        this.panelMaternas.setBorder(BorderFactory.createTitledBorder((Border) null, "Programa Materno  -  Resultado del Embarazo", 0, 0, new Font("Arial", 1, 12)));
        this.txtComplicaciones.setFont(new Font("Arial", 1, 12));
        this.txtComplicaciones.setEnabled(false);
        this.JSPObservaciones.setViewportView(this.txtComplicaciones);
        this.JLBObservaciones.setFont(new Font("Arial", 1, 12));
        this.JLBObservaciones.setForeground(new Color(0, 0, 153));
        this.JLBObservaciones.setHorizontalAlignment(2);
        this.JLBObservaciones.setText("Complicaciones");
        this.gridHijos.setFont(new Font("Arial", 1, 12));
        this.gridHijos.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.gridHijos.setEnabled(false);
        this.jScrollPane1.setViewportView(this.gridHijos);
        this.JLBObservaciones1.setFont(new Font("Arial", 1, 12));
        this.JLBObservaciones1.setForeground(new Color(0, 0, 153));
        this.JLBObservaciones1.setHorizontalAlignment(0);
        this.JLBObservaciones1.setText("Observaciones");
        this.txtObservaciones.setFont(new Font("Arial", 1, 12));
        this.txtObservaciones.setEnabled(false);
        this.JSPObservaciones1.setViewportView(this.txtObservaciones);
        GroupLayout panelMaternasLayout = new GroupLayout(this.panelMaternas);
        this.panelMaternas.setLayout(panelMaternasLayout);
        panelMaternasLayout.setHorizontalGroup(panelMaternasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(panelMaternasLayout.createSequentialGroup().addGap(4, 4, 4).addGroup(panelMaternasLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(panelMaternasLayout.createSequentialGroup().addComponent(this.JLBObservaciones, -2, 150, -2).addGap(400, 400, 400).addComponent(this.JLBObservaciones1)).addGroup(panelMaternasLayout.createSequentialGroup().addComponent(this.JSPObservaciones, -2, 520, -2).addGap(30, 30, 30).addComponent(this.JSPObservaciones1)).addComponent(this.jScrollPane1, -2, 979, -2)).addContainerGap(-1, 32767)));
        panelMaternasLayout.setVerticalGroup(panelMaternasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(panelMaternasLayout.createSequentialGroup().addGap(3, 3, 3).addComponent(this.jScrollPane1, -2, 100, -2).addGap(10, 10, 10).addGroup(panelMaternasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLBObservaciones).addComponent(this.JLBObservaciones1)).addGap(5, 5, 5).addGroup(panelMaternasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPObservaciones, -2, 70, -2).addComponent(this.JSPObservaciones1, -2, 70, -2))));
        this.btnNuevo.setBackground(new Color(204, 204, 255));
        this.btnNuevo.setFont(new Font("Arial", 1, 12));
        this.btnNuevo.setText("Nuevo");
        this.btnNuevo.setEnabled(false);
        this.btnNuevo.setMaximumSize(new Dimension(63, 25));
        this.btnNuevo.setMinimumSize(new Dimension(63, 25));
        this.btnNuevo.setPreferredSize(new Dimension(63, 25));
        this.btnNuevo.addActionListener(new ActionListener() { // from class: PyP.UsuarioxPrograma.8
            public void actionPerformed(ActionEvent evt) {
                UsuarioxPrograma.this.btnNuevoActionPerformed(evt);
            }
        });
        this.btnPrimer.setBackground(new Color(204, 204, 255));
        this.btnPrimer.setIcon(new ImageIcon(getClass().getResource("/Imagenes/b_primer.png")));
        this.btnPrimer.setEnabled(false);
        this.btnPrimer.addActionListener(new ActionListener() { // from class: PyP.UsuarioxPrograma.9
            public void actionPerformed(ActionEvent evt) {
                UsuarioxPrograma.this.btnPrimerActionPerformed(evt);
            }
        });
        this.btnAnterior.setBackground(new Color(204, 204, 255));
        this.btnAnterior.setIcon(new ImageIcon(getClass().getResource("/Imagenes/b_anterior.png")));
        this.btnAnterior.setEnabled(false);
        this.btnAnterior.addActionListener(new ActionListener() { // from class: PyP.UsuarioxPrograma.10
            public void actionPerformed(ActionEvent evt) {
                UsuarioxPrograma.this.btnAnteriorActionPerformed(evt);
            }
        });
        this.txtGestacion.setBackground(new Color(0, 0, 102));
        this.txtGestacion.setFont(new Font("Arial", 1, 18));
        this.txtGestacion.setForeground(new Color(255, 255, 255));
        this.txtGestacion.setHorizontalAlignment(0);
        this.txtGestacion.setText("0");
        this.txtGestacion.setCaretColor(new Color(255, 255, 255));
        this.txtGestacion.setDisabledTextColor(new Color(255, 255, 255));
        this.txtGestacion.setEnabled(false);
        this.txtGestacion.setMinimumSize(new Dimension(51, 25));
        this.txtGestacion.setPreferredSize(new Dimension(51, 25));
        this.txtGestacion.setSelectionColor(new Color(255, 255, 255));
        this.btnSiguiente.setBackground(new Color(204, 204, 255));
        this.btnSiguiente.setIcon(new ImageIcon(getClass().getResource("/Imagenes/b_siguiente.png")));
        this.btnSiguiente.setEnabled(false);
        this.btnSiguiente.addActionListener(new ActionListener() { // from class: PyP.UsuarioxPrograma.11
            public void actionPerformed(ActionEvent evt) {
                UsuarioxPrograma.this.btnSiguienteActionPerformed(evt);
            }
        });
        this.btnUltimo.setBackground(new Color(204, 204, 255));
        this.btnUltimo.setIcon(new ImageIcon(getClass().getResource("/Imagenes/b_ultimo.png")));
        this.btnUltimo.setEnabled(false);
        this.btnUltimo.addActionListener(new ActionListener() { // from class: PyP.UsuarioxPrograma.12
            public void actionPerformed(ActionEvent evt) {
                UsuarioxPrograma.this.btnUltimoActionPerformed(evt);
            }
        });
        this.txtNoHijos.setFont(new Font("Arial", 1, 12));
        this.txtNoHijos.setModel(new SpinnerNumberModel(1, 1, (Comparable) null, 1));
        this.txtNoHijos.setEnabled(false);
        this.txtNoHijos.addChangeListener(new ChangeListener() { // from class: PyP.UsuarioxPrograma.13
            public void stateChanged(ChangeEvent evt) {
                UsuarioxPrograma.this.txtNoHijosStateChanged(evt);
            }
        });
        this.txtNoHijos.addPropertyChangeListener(new PropertyChangeListener() { // from class: PyP.UsuarioxPrograma.14
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                UsuarioxPrograma.this.txtNoHijosPropertyChange(evt);
            }
        });
        this.jLabel4.setFont(new Font("Arial", 1, 12));
        this.jLabel4.setForeground(new Color(204, 255, 255));
        this.jLabel4.setText("No. Hijos");
        this.jLabel5.setFont(new Font("Arial", 1, 12));
        this.jLabel5.setForeground(new Color(204, 255, 255));
        this.jLabel5.setText("No. Gestación");
        GroupLayout panelEgresoLayout = new GroupLayout(this.panelEgreso);
        this.panelEgreso.setLayout(panelEgresoLayout);
        panelEgresoLayout.setHorizontalGroup(panelEgresoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(panelEgresoLayout.createSequentialGroup().addGap(4, 4, 4).addGroup(panelEgresoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.panelMaternas, -2, -1, -2).addGroup(panelEgresoLayout.createSequentialGroup().addComponent(this.jLabel1, -2, 60, -2).addGap(0, 0, 0).addComponent(this.cboMotivo, -2, 390, -2).addGap(20, 20, 20).addComponent(this.btnNuevo, -2, 70, -2).addGap(0, 0, 0).addComponent(this.btnPrimer, -2, 40, -2).addGap(0, 0, 0).addComponent(this.btnAnterior, -2, 40, -2).addGap(0, 0, 0).addComponent(this.txtGestacion, -2, 60, -2).addGap(0, 0, 0).addComponent(this.btnSiguiente, -2, 40, -2).addGap(0, 0, 0).addComponent(this.btnUltimo, -2, 40, -2).addGap(20, 20, 20).addGroup(panelEgresoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(panelEgresoLayout.createSequentialGroup().addGap(20, 20, 20).addComponent(this.jLabel5, -2, 90, -2)).addGroup(panelEgresoLayout.createSequentialGroup().addComponent(this.jLabel4, -2, 60, -2).addGap(0, 0, 0).addComponent(this.txtNoHijos, -2, 70, -2))))).addContainerGap(-1, 32767)));
        panelEgresoLayout.setVerticalGroup(panelEgresoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(panelEgresoLayout.createSequentialGroup().addGroup(panelEgresoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(panelEgresoLayout.createSequentialGroup().addGap(20, 20, 20).addComponent(this.jLabel1, -2, 20, -2)).addGroup(panelEgresoLayout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.cboMotivo, -2, 40, -2)).addGroup(panelEgresoLayout.createSequentialGroup().addGap(20, 20, 20).addComponent(this.btnNuevo, -2, 30, -2)).addGroup(panelEgresoLayout.createSequentialGroup().addGap(20, 20, 20).addComponent(this.btnPrimer, -2, 30, -2)).addGroup(panelEgresoLayout.createSequentialGroup().addGap(20, 20, 20).addComponent(this.btnAnterior, -2, 30, -2)).addGroup(panelEgresoLayout.createSequentialGroup().addGap(20, 20, 20).addComponent(this.txtGestacion, -2, 30, -2)).addGroup(panelEgresoLayout.createSequentialGroup().addGap(20, 20, 20).addComponent(this.btnSiguiente, -2, 30, -2)).addGroup(panelEgresoLayout.createSequentialGroup().addGap(20, 20, 20).addComponent(this.btnUltimo, -2, 30, -2)).addGroup(panelEgresoLayout.createSequentialGroup().addComponent(this.jLabel5).addGap(5, 5, 5).addGroup(panelEgresoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(panelEgresoLayout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.jLabel4)).addComponent(this.txtNoHijos, -2, 30, -2)))).addGap(10, 10, 10).addComponent(this.panelMaternas, -2, -1, -2)));
        GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
        this.jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addComponent(this.panelEgreso, -2, -1, -2).addGap(0, 94, 32767)));
        jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addComponent(this.panelEgreso, -2, -1, -2).addContainerGap(-1, 32767)));
        this.JTP_Datos.addTab("EGRESO CONTROL PRENATAL", this.jPanel3);
        this.panelProgramas.setBorder((Border) null);
        this.panelProgramas.setViewportBorder(BorderFactory.createEtchedBorder());
        this.panelProgramas.setFont(new Font("Arial", 1, 12));
        this.grid.setFont(new Font("Arial", 1, 12));
        this.grid.setRowHeight(25);
        this.grid.setSelectionBackground(new Color(255, 255, 255));
        this.grid.setSelectionForeground(new Color(255, 0, 0));
        this.grid.setSelectionMode(0);
        this.grid.addMouseListener(new MouseAdapter() { // from class: PyP.UsuarioxPrograma.15
            public void mouseClicked(MouseEvent evt) {
                UsuarioxPrograma.this.gridMouseClicked(evt);
            }

            public void mouseReleased(MouseEvent evt) {
                UsuarioxPrograma.this.gridMouseReleased(evt);
            }
        });
        this.panelProgramas.setViewportView(this.grid);
        this.JTP_Datos.addTab("HISTÓRICO", this.panelProgramas);
        this.jCBfiltro.setFont(new Font("Arial", 1, 12));
        this.jCBfiltro.setText("Filtro por Persona ?");
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar a Excel");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: PyP.UsuarioxPrograma.16
            public void actionPerformed(ActionEvent evt) {
                UsuarioxPrograma.this.JBTExportarActionPerformed(evt);
            }
        });
        this.JTRuta.setFont(new Font("Arial", 1, 12));
        this.JTRuta.setText("C:\\Genoma");
        this.JTRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ruta", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTRuta.addActionListener(new ActionListener() { // from class: PyP.UsuarioxPrograma.17
            public void actionPerformed(ActionEvent evt) {
                UsuarioxPrograma.this.JTRutaActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(10, 10, 10).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.panelPersona, -2, 950, -2).addGap(18, 18, 18).addComponent(this.jLabel2)).addGroup(layout.createSequentialGroup().addComponent(this.cboPrograma, -2, 280, -2).addGap(18, 18, 18).addComponent(this.jCBfiltro).addGap(77, 77, 77).addComponent(this.JTRuta, -2, 274, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTExportar)).addComponent(this.JTP_Datos, -2, 1130, -2)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.panelPersona, -2, 180, -2).addComponent(this.jLabel2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED, -1, 32767).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.cboPrograma, -2, 50, -2).addComponent(this.jCBfiltro)).addComponent(this.JTRuta, GroupLayout.Alignment.TRAILING, -2, 38, -2).addComponent(this.JBTExportar, GroupLayout.Alignment.TRAILING)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTP_Datos, -2, 379, -2).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnIngresoSiActionPerformed(ActionEvent evt) {
        this.esIngreso = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnIngresoNoActionPerformed(ActionEvent evt) {
        this.esIngreso = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtNoHijosPropertyChange(PropertyChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtNoHijosStateChanged(ChangeEvent evt) {
        adicionarFilaGrid();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gridMouseReleased(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gridMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnNuevoActionPerformed(ActionEvent evt) {
        nuevoParto();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnPrimerActionPerformed(ActionEvent evt) {
        desplazarRegistro(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnAnteriorActionPerformed(ActionEvent evt) {
        desplazarRegistro(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnSiguienteActionPerformed(ActionEvent evt) {
        desplazarRegistro(3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnUltimoActionPerformed(ActionEvent evt) {
        desplazarRegistro(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtSemanasGestacionActionPerformed(ActionEvent evt) {
        this.txtUltimaMestruacion.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameActivated(InternalFrameEvent evt) {
        this.clasepyp.frmPrincipal.mActivarBarraMenu(this.clasepyp.frmPrincipal.xMenus.barraMnuPyP, 15);
        Principal.txtNo.setText(this.idNo);
        Principal.txtEstado.setText(this.estado);
        Principal.txtFecha.setText(this.fecha);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboProgramaItemStateChanged(ItemEvent evt) {
        if (this.cboLleno == 1 && this.cboPrograma.getSelectedIndex() > -1) {
            cargarUsuariosDelPrograma();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTRutaActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTExportarActionPerformed(ActionEvent evt) {
        if (this.grid.getRowCount() != -1) {
            this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.grid, this.JTRuta.getText(), getTitle());
        }
    }
}
