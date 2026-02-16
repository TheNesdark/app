package PyP;

import Acceso.Principal;
import General.BuscarPersona;
import General.Persona;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

/* JADX INFO: loaded from: GenomaP.jar:PyP/CACervixResultado.class */
public class CACervixResultado extends JInternalFrame {
    public DefaultTableModel mod1;
    public DefaultTableModel mod2;
    public DefaultTableModel mod3;
    public DefaultTableModel mod4;
    public DefaultTableModel mod5;
    public DefaultTableModel mod6;
    public DefaultTableModel modelo;
    private int filaGrid;
    private int fila1;
    private int fila2;
    private int fila3;
    private int fila4;
    private int fila5;
    private int fila6;
    private String[] lisEsquema;
    private String[] lisCalidad;
    private String[] lisCategorizacion;
    private String[] lisMetodo;
    private String[][] lisProfesional;
    private String sql;
    private String idNo;
    private String estado;
    private String fecha;
    private String idProfesional;
    private String idEsquema;
    private String idMetodo;
    private String ultimaMes;
    private String idCalidad;
    private String idCategorizacion;
    private Object[] dato;
    public Persona frmPersona;
    private clasePyP clasepyp;
    private JButton BtnAnormal;
    private JButton btnCuello;
    private JCheckBox btnEmbarazada;
    private JButton btnGlandular;
    private JButton btnMicro;
    private JButton btnNoNeo;
    private JButton btnOtras;
    private JButton btnOtros;
    private JCheckBox btnPrimerVez;
    private ButtonGroup buttonGroup1;
    private JComboBox cboCalidad;
    private JComboBox cboCategorizacion;
    private JComboBox cboEsquema;
    private JComboBox cboMetodo;
    private JComboBox cboProfesional;
    private JTable grid;
    private JTable grid1;
    private JTable grid2;
    private JTable grid3;
    private JTable grid4;
    private JTable grid5;
    private JTable grid6;
    private JLabel jLabel1;
    private JLabel jLabel10;
    private JLabel jLabel11;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JLabel jLabel9;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JPanel jPanel5;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JScrollPane jScrollPane3;
    private JScrollPane jScrollPane4;
    private JScrollPane jScrollPane5;
    private JScrollPane jScrollPane6;
    private JScrollPane jScrollPane7;
    private JScrollPane jScrollPane8;
    private JTabbedPane jTabbedPane1;
    private JPanel panelPersona;
    private JPanel panelResultado;
    private JTextArea txtDetalle;
    public JDateChooser txtFecha;
    public JDateChooser txtFechaPaciente;
    public JDateChooser txtFechaReporte;
    public JDateChooser txtFechaUltMest;
    private Metodos metodos = new Metodos();
    private ConsultasMySQL consultas = new ConsultasMySQL();
    private int cboLleno = 0;
    private int pVez = 1;
    private int embarazada = 1;
    private int grabar = 0;
    private String ultimaCit = "";
    private String resultado = "";

    public CACervixResultado(clasePyP clase) {
        initComponents();
        this.clasepyp = clase;
        cargarPanelPersona();
        cargarCombos();
        nuevo();
        crearGrid();
        Principal.txtNo.setText("0");
        this.grid.addMouseListener(new MouseAdapter() { // from class: PyP.CACervixResultado.1
            public void mouseClicked(MouseEvent e) {
                CACervixResultado.this.filaGrid = CACervixResultado.this.grid.rowAtPoint(e.getPoint());
                CACervixResultado.this.grabar = 1;
                CACervixResultado.this.cargarDatosDelGrid();
            }
        });
    }

    public void anular() {
        this.metodos.mostrarMensaje("Carga la pantalla de anular");
    }

    private void asignarCita() {
        if (!this.frmPersona.txtHistoria.getText().equals("")) {
            this.clasepyp.frmPrincipal.mActivarBarraMenu(this.clasepyp.frmPrincipal.xMenus.barraMnuCita, 5);
            Principal.clasescita.cargarPantalla(Principal.clasescita.frmPrincipal, "Citas");
            Principal.clasescita.frmCita.frmPersona.txtHistoria.setText(this.frmPersona.txtHistoria.getText());
            Principal.clasescita.frmCita.frmPersona.txtHistoria.transferFocus();
            Principal.clasescita.frmCita.frmPersona.buscar(1);
            return;
        }
        this.metodos.mostrarMensaje("Por favor seleccione un Usuario para asignar la Cita");
    }

    public void buscar() {
        if (this.frmPersona.getHistoria().equals("") && this.frmPersona.getApellido1().equals("") && this.frmPersona.getApellido2().endsWith("") && this.frmPersona.getNombre1().equals("") && this.frmPersona.getNombre2().equals("")) {
            this.metodos.mostrarMensaje("Por Favor seleccione un Usuario");
        } else {
            Buscar frmB = new Buscar(null, true, this);
            frmB.setVisible(true);
        }
    }

    private void buscarAnterior() {
        String[] strArr = new String[2];
        String[] result = this.clasepyp.getCitologiaAnterior(this.frmPersona.getIdPersona(), Principal.txtNo.getText());
        this.ultimaCit = result[1];
        this.resultado = result[2];
    }

    public void buscarPersona() {
        BuscarPersona frmP = new BuscarPersona(null, true, this.frmPersona);
        frmP.setVisible(true);
    }

    public void buscarCitologia() {
        crearGrid();
        crearGridCitologia();
        this.sql = "SELECT p_citologia.Id, p_citologia.No, w_profesional.NProfesional, p_citologia.FechaToma, p_citologia.FechaRespuesta, p_citologia.FechaAvisoPaciente, h_tipometplanifica.Nbre as Metodo, p_citologia.PrimerVez, p_citologia.Embarazada, p_citologiaesquema.Nbre, p_citologia.Detalle, p_citologia.Estado, p_citologia.FechaUltMest, p_citologia.Detalle FROM p_citologia  INNER JOIN h_tipometplanifica ON (p_citologia.MetodoPlanifica = h_tipometplanifica.Id) INNER JOIN w_profesional ON (w_profesional.Id_Persona = p_citologia.Id_Profesional) INNER JOIN p_citologiaesquema ON (p_citologia.Id_Esquema = p_citologiaesquema.Id) WHERE (p_citologia.Estado =0 AND p_citologia.Id_Persona ='" + this.frmPersona.getIdPersona() + "') ORDER BY p_citologia.No DESC";
        ResultSet rs = this.consultas.traerRs(this.sql);
        try {
            if (rs.next()) {
                rs.beforeFirst();
                while (rs.next()) {
                    this.modelo.addRow(this.dato);
                    this.modelo.setValueAt(rs.getString("Id"), this.filaGrid, 0);
                    this.modelo.setValueAt(rs.getString("No"), this.filaGrid, 1);
                    this.modelo.setValueAt(rs.getString("NProfesional"), this.filaGrid, 2);
                    if (rs.getDate("FechaToma") != null) {
                        this.modelo.setValueAt(this.metodos.formatoDMA.format((Date) rs.getDate("FechaToma")), this.filaGrid, 3);
                    }
                    if (rs.getDate("FechaRespuesta") != null) {
                        this.modelo.setValueAt(this.metodos.formatoDMA.format((Date) rs.getDate("FechaRespuesta")), this.filaGrid, 4);
                    }
                    if (rs.getDate("FechaAvisoPaciente") != null) {
                        this.modelo.setValueAt(this.metodos.formatoDMA.format((Date) rs.getDate("FechaAvisoPaciente")), this.filaGrid, 5);
                    }
                    this.modelo.setValueAt(rs.getString("Metodo"), this.filaGrid, 6);
                    if (rs.getInt("PrimerVez") == 0) {
                        this.pVez = 0;
                        this.btnPrimerVez.setSelected(true);
                        this.modelo.setValueAt(true, this.filaGrid, 7);
                    } else {
                        this.pVez = 1;
                        this.btnPrimerVez.setSelected(false);
                        this.modelo.setValueAt(false, this.filaGrid, 7);
                    }
                    if (rs.getInt("Embarazada") == 0) {
                        this.embarazada = 0;
                        this.btnEmbarazada.setSelected(true);
                        this.modelo.setValueAt(true, this.filaGrid, 8);
                    } else {
                        this.embarazada = 1;
                        this.btnEmbarazada.setSelected(false);
                        this.modelo.setValueAt(false, this.filaGrid, 8);
                    }
                    this.modelo.setValueAt(rs.getString("Nbre"), this.filaGrid, 9);
                    if (rs.getString("Estado").equals("0")) {
                        this.modelo.setValueAt("ACTIVA", this.filaGrid, 10);
                    } else {
                        this.modelo.setValueAt("ANULADA", this.filaGrid, 10);
                    }
                    this.modelo.setValueAt(this.metodos.formatoDMA.format((Date) rs.getDate("FechaUltMest")), this.filaGrid, 11);
                    this.modelo.setValueAt(rs.getString("Detalle"), this.filaGrid, 12);
                    this.filaGrid++;
                }
            } else {
                nuevo();
            }
            if (this.filaGrid == 0) {
                Principal.txtNo.setText("1");
            }
            rs.close();
            this.consultas.cerrarConexionBd();
        } catch (SQLException ex) {
            this.consultas.mostrarErrorSQL(ex);
        }
    }

    private void cargarAntecedentes() {
        if (!this.frmPersona.txtHistoria.getText().equals("")) {
            Antecedentes frmA = new Antecedentes(null, true, this);
            frmA.setVisible(true);
        } else {
            this.metodos.mostrarMensaje("Por favor seleccione un Usuario");
        }
    }

    private void cargarCombos() {
        this.cboLleno = 0;
        this.sql = "SELECT Id, Nbre FROM p_citologiaesquema WHERE (Estado =0) ORDER BY Nbre ASC";
        this.lisEsquema = this.consultas.llenarCombo(this.sql, this.lisEsquema, this.cboEsquema);
        this.sql = "SELECT Id, Nbre FROM  p_citologia_conceptoestudio WHERE (Id_TipoEstudio =1 AND Estado =0)";
        this.lisCalidad = this.consultas.llenarCombo(this.sql, this.lisCalidad, this.cboCalidad);
        this.sql = "SELECT Id, Nbre FROM p_citologia_conceptoestudio WHERE (Id_TipoEstudio =2 AND Estado =0)";
        this.lisCategorizacion = this.consultas.llenarCombo(this.sql, this.lisCategorizacion, this.cboCategorizacion);
        this.sql = "SELECT w_profesional.Id_Persona, w_profesional.NProfesional, Especialidad FROM w_profesional INNER JOIN g_profesionalespecial ON (w_profesional.Id_Persona = g_profesionalespecial.Id_Profesional) WHERE (g_profesionalespecial.Estado =0 AND w_profesional.Especialidad='CITOLOGIAS') ORDER BY w_profesional.NProfesional ASC";
        this.lisProfesional = this.consultas.llenarComboyLista(this.sql, this.lisProfesional, this.cboProfesional, 3);
        this.lisMetodo = this.consultas.llenarCombo("SELECT Id, Nbre FROM h_tipometplanifica WHERE (Estado =0) ORDER BY Nbre ASC", this.lisMetodo, this.cboMetodo);
        this.cboLleno = 1;
        this.consultas.cerrarConexionBd();
    }

    private void cargarPanelPersona() {
        this.frmPersona = new Persona(this);
        this.frmPersona.setBounds(1, 1, 980, 160);
        this.panelPersona.add(this.frmPersona);
        this.frmPersona.setVisible(true);
    }

    /* JADX WARN: Type inference failed for: r4v11, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r4v5, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r4v7, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r4v9, types: [java.lang.Object[], java.lang.Object[][]] */
    public void crearGrid() {
        this.mod1 = new DefaultTableModel((Object[][]) null, new String[]{"Id", "MicroOrganismos Encontrados"}) { // from class: PyP.CACervixResultado.2
            Class[] types = {String.class, String.class};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.grid1.setModel(this.mod1);
        this.grid1.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.grid1.getColumnModel().getColumn(0).setMinWidth(0);
        this.grid1.getColumnModel().getColumn(0).setMaxWidth(0);
        this.mod1.addRow(this.dato);
        this.fila1 = 0;
        this.mod2 = new DefaultTableModel(new Object[0], new String[]{"Id", "Hallazgos No Neoplásicos"}) { // from class: PyP.CACervixResultado.3
            Class[] types = {String.class, String.class};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.grid2.setModel(this.mod2);
        this.grid2.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.grid2.getColumnModel().getColumn(0).setMinWidth(0);
        this.grid2.getColumnModel().getColumn(0).setMaxWidth(0);
        this.mod2.addRow(this.dato);
        this.fila2 = 0;
        this.mod3 = new DefaultTableModel(new Object[0], new String[]{"Id", "Anormalidad en Células Escamosas"}) { // from class: PyP.CACervixResultado.4
            Class[] types = {String.class, String.class};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.grid3.setModel(this.mod3);
        this.grid3.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.grid3.getColumnModel().getColumn(0).setMinWidth(0);
        this.grid3.getColumnModel().getColumn(0).setMaxWidth(0);
        this.mod3.addRow(this.dato);
        this.fila3 = 0;
        this.mod4 = new DefaultTableModel(new Object[0], new String[]{"Id", "Anormalidad en Células Glandulares"}) { // from class: PyP.CACervixResultado.5
            Class[] types = {String.class, String.class};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.grid4.setModel(this.mod4);
        this.grid4.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.grid4.getColumnModel().getColumn(0).setMinWidth(0);
        this.grid4.getColumnModel().getColumn(0).setMaxWidth(0);
        this.mod4.addRow(this.dato);
        this.fila4 = 0;
        this.mod5 = new DefaultTableModel(new Object[0], new String[]{"Id", "Otras Neoplásias"}) { // from class: PyP.CACervixResultado.6
            Class[] types = {String.class, String.class};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.grid5.setModel(this.mod5);
        this.grid5.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.grid5.getColumnModel().getColumn(0).setMinWidth(0);
        this.grid5.getColumnModel().getColumn(0).setMaxWidth(0);
        this.mod5.addRow(this.dato);
        this.fila5 = 0;
        this.mod6 = new DefaultTableModel(new Object[0], new String[]{"Id", "Aspecto del Cuello"}) { // from class: PyP.CACervixResultado.7
            Class[] types = {String.class, String.class};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.grid6.setModel(this.mod6);
        this.grid6.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.grid6.getColumnModel().getColumn(0).setMinWidth(0);
        this.grid6.getColumnModel().getColumn(0).setMaxWidth(0);
        this.mod6.addRow(this.dato);
        this.fila6 = 0;
    }

    public void cargarGrid(int gridD, String id, String nbre) {
        if (gridD == 1) {
            this.mod1.setValueAt(id, this.mod1.getRowCount() - 1, 0);
            this.mod1.setValueAt(nbre, this.mod1.getRowCount() - 1, 1);
            this.mod1.addRow(this.dato);
            this.fila1 = this.mod1.getRowCount();
            return;
        }
        if (gridD == 2) {
            this.mod2.setValueAt(id, this.mod2.getRowCount() - 1, 0);
            this.mod2.setValueAt(nbre, this.mod2.getRowCount() - 1, 1);
            this.mod2.addRow(this.dato);
            this.fila2 = this.mod2.getRowCount();
            return;
        }
        if (gridD == 3) {
            this.mod3.setValueAt(id, this.mod3.getRowCount() - 1, 0);
            this.mod3.setValueAt(nbre, this.mod3.getRowCount() - 1, 1);
            this.mod3.addRow(this.dato);
            this.fila3 = this.mod3.getRowCount();
            return;
        }
        if (gridD == 4) {
            this.mod4.setValueAt(id, this.mod4.getRowCount() - 1, 0);
            this.mod4.setValueAt(nbre, this.mod4.getRowCount() - 1, 1);
            this.mod4.addRow(this.dato);
            this.fila4 = this.mod4.getRowCount();
            return;
        }
        if (gridD == 5) {
            this.mod5.setValueAt(id, this.mod5.getRowCount() - 1, 0);
            this.mod5.setValueAt(nbre, this.mod5.getRowCount() - 1, 1);
            this.mod5.addRow(this.dato);
            this.fila5 = this.mod5.getRowCount();
            return;
        }
        if (gridD == 6) {
            this.mod6.setValueAt(id, this.mod6.getRowCount() - 1, 0);
            this.mod6.setValueAt(nbre, this.mod6.getRowCount() - 1, 1);
            this.mod6.addRow(this.dato);
            this.fila6 = this.mod6.getRowCount();
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearGridCitologia() {
        this.modelo = new DefaultTableModel(new Object[0], new String[]{"Id", "No", "Profesional", "Fecha", "Reportado", "Informado", "Metodo", "P. Vez", "Embarazada", "Esquema", "Estado", "Ult. Mestrua", "Detalle"}) { // from class: PyP.CACervixResultado.8
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, Boolean.class, Boolean.class, String.class, String.class, String.class, String.class};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.grid.setModel(this.modelo);
        this.grid.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.grid.getColumnModel().getColumn(1).setPreferredWidth(80);
        this.grid.getColumnModel().getColumn(2).setPreferredWidth(200);
        this.grid.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(8).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(9).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(10).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(11).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(12).setPreferredWidth(100);
        this.filaGrid = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cargarDatosDelGrid() {
        this.idNo = this.modelo.getValueAt(this.filaGrid, 0).toString();
        this.fecha = this.modelo.getValueAt(this.filaGrid, 3).toString();
        Principal.txtNo.setText(this.idNo);
        Principal.txtFecha.setText(this.fecha);
        Principal.txtNo.setText(this.modelo.getValueAt(this.filaGrid, 1).toString());
        this.cboProfesional.setSelectedItem(this.modelo.getValueAt(this.filaGrid, 2));
        this.estado = this.modelo.getValueAt(this.filaGrid, 10).toString();
        Principal.txtEstado.setText(this.estado);
        this.txtFecha.setDate(this.metodos.getPasarTextoAFecha(this.modelo.getValueAt(this.filaGrid, 3).toString()));
        if (this.modelo.getValueAt(this.filaGrid, 4) != null) {
            this.txtFechaReporte.setDate(this.metodos.getPasarTextoAFecha(this.modelo.getValueAt(this.filaGrid, 4).toString()));
        }
        if (this.modelo.getValueAt(this.filaGrid, 5) != null) {
            this.txtFechaPaciente.setDate(this.metodos.getPasarTextoAFecha(this.modelo.getValueAt(this.filaGrid, 5).toString()));
        }
        this.cboMetodo.setSelectedItem(this.modelo.getValueAt(this.filaGrid, 6));
        if (this.modelo.getValueAt(this.filaGrid, 7).equals(true)) {
            this.btnPrimerVez.setSelected(true);
        } else {
            this.btnPrimerVez.setSelected(false);
        }
        if (this.modelo.getValueAt(this.filaGrid, 8).equals(true)) {
            this.btnEmbarazada.setSelected(true);
        } else {
            this.btnEmbarazada.setSelected(false);
        }
        this.cboEsquema.setSelectedItem(this.modelo.getValueAt(this.filaGrid, 9));
        this.txtFechaUltMest.setDate(this.metodos.getPasarTextoAFecha(this.modelo.getValueAt(this.filaGrid, 11).toString()));
        this.txtDetalle.setText(this.modelo.getValueAt(this.filaGrid, 12).toString());
        cargarDetalleCitologia();
    }

    private void cargarDetalleCitologia() {
        crearGrid();
        this.sql = "SELECT p_citologia_conceptoestudio.Nbre, p_citologia_conceptoestudio.Id_TipoEstudio as Id FROM p_citologia_resultados INNER JOIN p_citologia_conceptoestudio ON (p_citologia_resultados.Id_ConceptoEstudio = p_citologia_conceptoestudio.Id) WHERE (p_citologia_resultados.Id_Citologia ='" + this.idNo + "') ORDER BY p_citologia_conceptoestudio.Id ASC";
        ResultSet rs = this.consultas.traerRs(this.sql);
        int f1 = 0;
        int f2 = 0;
        int f3 = 0;
        int f4 = 0;
        int f5 = 0;
        int f6 = 0;
        while (rs.next()) {
            try {
                if (rs.getInt("Id") == 1) {
                    this.cboCalidad.setSelectedItem(rs.getString("Nbre"));
                    setCalidad(rs.getString("Id"));
                } else if (rs.getInt("Id") == 2) {
                    this.cboCategorizacion.setSelectedItem(rs.getString("Nbre"));
                    setCategorizacion(rs.getString("Id"));
                } else if (rs.getInt("Id") == 3) {
                    this.mod1.addRow(this.dato);
                    this.mod1.setValueAt(rs.getString("Id"), f1, 0);
                    this.mod1.setValueAt(rs.getString("Nbre"), f1, 1);
                    f1++;
                } else if (rs.getInt("Id") == 4) {
                    this.mod2.addRow(this.dato);
                    this.mod2.setValueAt(rs.getString("Id"), f2, 0);
                    this.mod2.setValueAt(rs.getString("Nbre"), f2, 1);
                    f2++;
                } else if (rs.getInt("Id") == 5) {
                    this.mod3.addRow(this.dato);
                    this.mod3.setValueAt(rs.getString("Id"), f3, 0);
                    this.mod3.setValueAt(rs.getString("Nbre"), f3, 1);
                    f3++;
                } else if (rs.getInt("Id") == 6) {
                    this.mod4.addRow(this.dato);
                    this.mod4.setValueAt(rs.getString("Id"), f4, 0);
                    this.mod4.setValueAt(rs.getString("Nbre"), f4, 1);
                    f4++;
                } else if (rs.getInt("Id") == 7) {
                    this.mod5.addRow(this.dato);
                    this.mod5.setValueAt(rs.getString("Id"), f5, 0);
                    this.mod5.setValueAt(rs.getString("Nbre"), f5, 1);
                    f5++;
                } else if (rs.getInt("Id") == 8) {
                    this.mod6.addRow(this.dato);
                    this.mod6.setValueAt(rs.getString("Id"), f6, 0);
                    this.mod6.setValueAt(rs.getString("Nbre"), f6, 1);
                    f6++;
                }
            } catch (SQLException ex) {
                this.consultas.mostrarErrorSQL(ex);
                return;
            }
        }
        rs.close();
        this.consultas.cerrarConexionBd();
    }

    private void eliminarFilaGrid(int fgrid) {
        if (this.metodos.getPregunta("Esta seguro de Eliminar la fila?") == 0) {
            if (fgrid == 1) {
                this.mod1.removeRow(this.grid1.getSelectedRow());
                return;
            }
            if (fgrid == 2) {
                this.mod2.removeRow(this.grid2.getSelectedRow());
                return;
            }
            if (fgrid == 3) {
                this.mod3.removeRow(this.grid3.getSelectedRow());
                return;
            }
            if (fgrid == 4) {
                this.mod4.removeRow(this.grid4.getSelectedRow());
            } else if (fgrid == 5) {
                this.mod5.removeRow(this.grid5.getSelectedRow());
            } else if (fgrid == 6) {
                this.mod6.removeRow(this.grid6.getSelectedRow());
            }
        }
    }

    public void grabar() {
        if (this.grabar == 0) {
            if (validarDatos() == 1) {
                grabarCitologia();
                grabarResultado(this.grid6);
                this.metodos.mostrarMensaje("Citología Grabada");
                return;
            }
            return;
        }
        if (validarDatos2() == 1) {
            modificarCitologia();
            grabarC2();
            grabarResultado(this.grid1);
            grabarResultado(this.grid2);
            grabarResultado(this.grid3);
            grabarResultado(this.grid4);
            grabarResultado(this.grid5);
            this.metodos.mostrarMensaje("Grabadas las Modificaciones de la Citología");
        }
    }

    private void grabarC2() {
        this.sql = "INSERT IGNORE INTO p_citologia_resultados(Id_Citologia, Id_ConceptoEstudio) VALUE('" + this.idNo + "','" + getCalidad() + "')";
        this.consultas.ejecutarSQL(this.sql);
        this.sql = "INSERT IGNORE INTO p_citologia_resultados(Id_Citologia, Id_ConceptoEstudio) VALUE('" + this.idNo + "','" + getCategorizacion() + "')";
        this.consultas.ejecutarSQL(this.sql);
        this.consultas.cerrarConexionBd();
    }

    public void grabarCitologia() {
        this.sql = "INSERT INTO p_citologia(Id_Persona, No, Id_Profesional, FechaToma, FechaUltMest, MetodoPlanifica, PrimerVez, Embarazada, Id_Esquema, Detalle, Fecha, UsuarioS) VALUE('" + this.frmPersona.getIdPersona() + "','" + Principal.txtNo.getText() + "','" + getProfesional() + "','" + this.metodos.formatoAMD.format(this.txtFecha.getDate()) + "','";
        this.sql += getUltimaMes() + "','" + getMetodo() + "','";
        if (this.btnPrimerVez.isSelected()) {
            this.sql += "0','";
        } else {
            this.sql += "1','";
        }
        if (this.btnEmbarazada.isSelected()) {
            this.sql += "0','";
        } else {
            this.sql += "1','";
        }
        this.sql += getEsquema() + "','" + this.txtDetalle.getText() + "','" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
        this.idNo = this.consultas.ejecutarSQLId(this.sql);
        this.estado = "ACTIVA";
        this.fecha = this.metodos.formatoDMA.format(this.txtFecha.getDate());
        Principal.txtNo.setText(this.idNo);
        Principal.txtFecha.setText(this.fecha);
        Principal.txtEstado.setText(this.estado);
        this.consultas.cerrarConexionBd();
    }

    public void grabarResultado(JTable gridG) {
        for (int i = 0; i < gridG.getRowCount() - 1; i++) {
            this.sql = "INSERT IGNORE INTO p_citologia_resultados(Id_Citologia, Id_ConceptoEstudio) VALUE('" + this.idNo + "','" + gridG.getValueAt(i, 0) + "')";
            this.consultas.ejecutarSQL(this.sql);
            this.consultas.cerrarConexionBd();
        }
    }

    public void imprimir() {
        buscarAnterior();
        String[][] parametros = new String[8][2];
        parametros[0][0] = "Id";
        parametros[0][1] = Principal.txtNo.getText();
        parametros[1][0] = "profesional";
        parametros[1][1] = this.cboProfesional.getSelectedItem().toString();
        parametros[2][0] = "cargo";
        parametros[2][1] = this.lisProfesional[this.cboProfesional.getSelectedIndex()][1];
        parametros[3][0] = "fechaUlt";
        parametros[3][1] = this.ultimaCit;
        parametros[4][0] = "resultado";
        parametros[4][1] = this.resultado;
        parametros[5][0] = "ruta";
        parametros[5][1] = this.metodos.getRutaRep();
        parametros[6][0] = "SUBREPORT_DIR";
        parametros[6][1] = this.metodos.getSO() + this.metodos.getBarra() + "Reportes" + this.metodos.getBarra();
        parametros[7][0] = "SUBREPORTFIRMA_DIR";
        parametros[7][1] = this.metodos.getSO() + this.metodos.getBarra() + "Firmas" + this.metodos.getBarra();
        this.metodos.GenerarPDF(this.metodos.getRutaRep() + "P_EnvioCitologia", parametros);
        this.consultas.cerrarConexionBd();
    }

    public void limpiarTodo() {
        nuevo();
        crearGridCitologia();
    }

    private void modificarCitologia() {
        this.sql = "UPDATE p_citologia SET FechaRespuesta ='" + getFechaReporte();
        if (this.txtFechaPaciente.getDate() != null) {
            this.sql += "', FechaAvisoPaciente ='" + getFechaUsuario();
        }
        this.sql += "', Detalle ='" + this.txtDetalle.getText() + "', Fecha ='" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "', UsuarioS ='" + Principal.usuarioSistemaDTO.getLogin() + "' WHERE (Id='" + this.idNo + "')";
        this.consultas.ejecutarSQL(this.sql);
        this.consultas.cerrarConexionBd();
    }

    public final void nuevo() {
        this.frmPersona.nuevo();
        this.grabar = 0;
        this.cboProfesional.setSelectedIndex(-1);
        this.txtFecha.setDate(this.metodos.getFechaActual());
        this.txtFechaReporte.setDate((Date) null);
        this.txtFechaPaciente.setDate((Date) null);
        this.cboEsquema.setSelectedIndex(-1);
        this.cboMetodo.setSelectedIndex(-1);
        this.cboCalidad.setSelectedIndex(-1);
        this.cboCategorizacion.setSelectedIndex(-1);
        this.btnPrimerVez.setSelected(false);
        this.btnEmbarazada.setSelected(false);
        this.embarazada = 1;
        this.pVez = 1;
        this.txtDetalle.setText("");
        if (this.modelo != null) {
            if (this.modelo.getRowCount() == 0) {
                Principal.txtNo.setText("1");
            } else {
                Principal.txtNo.setText(String.valueOf(Integer.parseInt(this.modelo.getValueAt(0, 1).toString()) + 1));
            }
        }
        this.estado = "ACTIVA";
        this.fecha = this.metodos.formatoDMA.format(this.metodos.getFechaActual());
        Principal.txtNo.setText(this.idNo);
        Principal.txtEstado.setText(this.estado);
        Principal.txtFecha.setText(this.fecha);
        crearGrid();
    }

    private int validarDatos() {
        int retorno = 0;
        if (this.txtFecha.getDate() == null) {
            this.metodos.mostrarMensaje("Por favor escriba una Fecha Válida");
            this.txtFecha.requestFocus();
        } else if (this.cboEsquema.getSelectedIndex() < 0) {
            this.metodos.mostrarMensaje("Por favor seleccione un Esquema");
            this.cboEsquema.requestFocus();
        } else if (this.frmPersona.cboSexo.getSelectedItem().equals("MASCULINO")) {
            this.metodos.mostrarMensaje("Por favor cambie el SEXO del usuario o verifique sus datos");
            this.frmPersona.cboSexo.requestFocus();
        } else if (this.cboMetodo.getSelectedIndex() < 0) {
            this.metodos.mostrarMensaje("Por favor seleccione un Método de Planificación");
            this.cboMetodo.requestFocus();
        } else if (this.txtFechaUltMest.getDate() == null) {
            this.metodos.mostrarMensaje("Por favor indique la Fecha de la Ultima Mestruación");
            this.cboMetodo.requestFocus();
        } else {
            retorno = 1;
        }
        return retorno;
    }

    private int validarDatos2() {
        int retorno = 0;
        if (this.txtFechaReporte.getDate() == null) {
            this.metodos.mostrarMensaje("Por favor digite la Fecha en que se recibe el Reporte");
            this.txtFechaReporte.requestFocus();
        } else if (this.cboCalidad.getSelectedIndex() < 0) {
            this.metodos.mostrarMensaje("Por favor seleccione el resultado de la Calidad de la Muestra");
            this.cboCalidad.requestFocus();
        } else if (this.cboCategorizacion.getSelectedIndex() < 0) {
            this.metodos.mostrarMensaje("Por favor seleccione la Categorización");
            this.cboCategorizacion.requestFocus();
        } else {
            retorno = 1;
        }
        return retorno;
    }

    public String getProfesional() {
        return this.idProfesional;
    }

    public String getEsquema() {
        return this.idEsquema;
    }

    public String getMetodo() {
        return this.idMetodo;
    }

    public String getUltimaMes() {
        if (this.txtFechaUltMest.getDate() != null) {
            setUltimaMes(this.metodos.formatoAMD.format(this.txtFechaUltMest.getDate()));
        }
        return this.ultimaMes;
    }

    public String getFechaReporte() {
        if (this.txtFechaReporte.getDate() != null) {
        }
        String fechaR = this.metodos.formatoAMD.format(this.txtFechaReporte.getDate());
        return fechaR;
    }

    public String getFechaUsuario() {
        return this.metodos.formatoAMD.format(this.txtFechaPaciente.getDate());
    }

    public String getCalidad() {
        return this.idCalidad;
    }

    public String getCategorizacion() {
        return this.idCategorizacion;
    }

    public void setProfesional(String id) {
        this.idProfesional = id;
    }

    public void setEsquema(String id) {
        this.idEsquema = id;
    }

    public void setMetodo(String id) {
        this.idMetodo = id;
    }

    public void setUltimaMes(String id) {
        this.ultimaMes = id;
    }

    public void setCalidad(String id) {
        this.idCalidad = id;
    }

    public void setCategorizacion(String id) {
        this.idCategorizacion = id;
    }

    /* JADX WARN: Type inference failed for: r3v106, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v137, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v148, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v180, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v57, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v84, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v94, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.buttonGroup1 = new ButtonGroup();
        this.panelPersona = new JPanel();
        this.jPanel2 = new JPanel();
        this.jLabel1 = new JLabel();
        this.jLabel2 = new JLabel();
        this.cboEsquema = new JComboBox();
        this.btnPrimerVez = new JCheckBox();
        this.btnEmbarazada = new JCheckBox();
        this.jLabel3 = new JLabel();
        this.cboMetodo = new JComboBox();
        this.txtFechaUltMest = new JDateChooser();
        this.jScrollPane7 = new JScrollPane();
        this.txtDetalle = new JTextArea();
        this.jLabel7 = new JLabel();
        this.txtFecha = new JDateChooser();
        this.jLabel6 = new JLabel();
        this.cboProfesional = new JComboBox();
        this.jScrollPane8 = new JScrollPane();
        this.grid6 = new JTable();
        this.btnCuello = new JButton();
        this.panelResultado = new JPanel();
        this.cboCategorizacion = new JComboBox();
        this.jLabel9 = new JLabel();
        this.jLabel10 = new JLabel();
        this.cboCalidad = new JComboBox();
        this.jScrollPane1 = new JScrollPane();
        this.grid = new JTable();
        this.jTabbedPane1 = new JTabbedPane();
        this.jPanel3 = new JPanel();
        this.jScrollPane2 = new JScrollPane();
        this.grid1 = new JTable();
        this.btnMicro = new JButton();
        this.jScrollPane3 = new JScrollPane();
        this.grid2 = new JTable();
        this.btnNoNeo = new JButton();
        this.jPanel4 = new JPanel();
        this.jScrollPane4 = new JScrollPane();
        this.grid3 = new JTable();
        this.BtnAnormal = new JButton();
        this.jScrollPane5 = new JScrollPane();
        this.grid4 = new JTable();
        this.btnGlandular = new JButton();
        this.jPanel5 = new JPanel();
        this.jScrollPane6 = new JScrollPane();
        this.grid5 = new JTable();
        this.btnOtras = new JButton();
        this.btnOtros = new JButton();
        this.jLabel4 = new JLabel();
        this.txtFechaReporte = new JDateChooser();
        this.jLabel5 = new JLabel();
        this.txtFechaPaciente = new JDateChooser();
        this.jLabel8 = new JLabel();
        this.jLabel11 = new JLabel();
        setClosable(true);
        setIconifiable(true);
        setTitle("PROMOCIÓN Y PREVENCIÓN - PROGRAMA DE CA DE CERVIX - RESULTADOS DE CITOLOGÍAS");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMaximumSize(new Dimension(1202, 835));
        setMinimumSize(new Dimension(1202, 835));
        setName("CACervixResultado");
        setPreferredSize(new Dimension(1202, 835));
        addInternalFrameListener(new InternalFrameListener() { // from class: PyP.CACervixResultado.9
            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
            }

            public void internalFrameOpened(InternalFrameEvent evt) {
            }

            public void internalFrameActivated(InternalFrameEvent evt) {
                CACervixResultado.this.formInternalFrameActivated(evt);
            }

            public void internalFrameDeactivated(InternalFrameEvent evt) {
            }

            public void internalFrameDeiconified(InternalFrameEvent evt) {
            }

            public void internalFrameIconified(InternalFrameEvent evt) {
            }
        });
        getContentPane().setLayout(new AbsoluteLayout());
        GroupLayout panelPersonaLayout = new GroupLayout(this.panelPersona);
        this.panelPersona.setLayout(panelPersonaLayout);
        panelPersonaLayout.setHorizontalGroup(panelPersonaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 940, 32767));
        panelPersonaLayout.setVerticalGroup(panelPersonaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 170, 32767));
        getContentPane().add(this.panelPersona, new AbsoluteConstraints(0, 10, 940, 170));
        this.jPanel2.setBackground(new Color(0, 204, 204));
        this.jPanel2.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS DE LA TOMA", 0, 0, new Font("Arial", 1, 12)));
        this.jPanel2.setLayout(new AbsoluteLayout());
        this.jLabel1.setFont(new Font("Arial", 1, 12));
        this.jLabel1.setForeground(new Color(0, 0, 153));
        this.jLabel1.setText("Ultima Mestruación");
        this.jPanel2.add(this.jLabel1, new AbsoluteConstraints(360, 20, 110, -1));
        this.jLabel2.setFont(new Font("Arial", 1, 12));
        this.jLabel2.setForeground(new Color(0, 0, 153));
        this.jLabel2.setText("Método de Planificación");
        this.jPanel2.add(this.jLabel2, new AbsoluteConstraints(170, 80, 170, -1));
        this.cboEsquema.setFont(new Font("Arial", 1, 12));
        this.cboEsquema.addItemListener(new ItemListener() { // from class: PyP.CACervixResultado.10
            public void itemStateChanged(ItemEvent evt) {
                CACervixResultado.this.cboEsquemaItemStateChanged(evt);
            }
        });
        this.jPanel2.add(this.cboEsquema, new AbsoluteConstraints(10, 100, 150, 30));
        this.btnPrimerVez.setBackground(new Color(0, 204, 204));
        this.btnPrimerVez.setFont(new Font("Arial", 1, 12));
        this.btnPrimerVez.setForeground(new Color(0, 0, 153));
        this.btnPrimerVez.setText("Primer Vez");
        this.btnPrimerVez.addActionListener(new ActionListener() { // from class: PyP.CACervixResultado.11
            public void actionPerformed(ActionEvent evt) {
                CACervixResultado.this.btnPrimerVezActionPerformed(evt);
            }
        });
        this.jPanel2.add(this.btnPrimerVez, new AbsoluteConstraints(370, 80, -1, -1));
        this.btnEmbarazada.setBackground(new Color(0, 204, 204));
        this.btnEmbarazada.setFont(new Font("Arial", 1, 12));
        this.btnEmbarazada.setForeground(new Color(0, 0, 153));
        this.btnEmbarazada.setText("Embarazada");
        this.btnEmbarazada.addActionListener(new ActionListener() { // from class: PyP.CACervixResultado.12
            public void actionPerformed(ActionEvent evt) {
                CACervixResultado.this.btnEmbarazadaActionPerformed(evt);
            }
        });
        this.jPanel2.add(this.btnEmbarazada, new AbsoluteConstraints(370, 110, -1, -1));
        this.jLabel3.setFont(new Font("Arial", 1, 12));
        this.jLabel3.setForeground(new Color(0, 0, 153));
        this.jLabel3.setText("Esquema");
        this.jPanel2.add(this.jLabel3, new AbsoluteConstraints(10, 80, 80, -1));
        this.cboMetodo.setFont(new Font("Arial", 1, 12));
        this.cboMetodo.addItemListener(new ItemListener() { // from class: PyP.CACervixResultado.13
            public void itemStateChanged(ItemEvent evt) {
                CACervixResultado.this.cboMetodoItemStateChanged(evt);
            }
        });
        this.jPanel2.add(this.cboMetodo, new AbsoluteConstraints(170, 100, 190, 30));
        this.txtFechaUltMest.setDateFormatString("dd/MM/yyyy");
        this.txtFechaUltMest.setFont(new Font("Arial", 1, 12));
        this.txtFechaUltMest.setName("txtFecha");
        this.jPanel2.add(this.txtFechaUltMest, new AbsoluteConstraints(370, 40, 110, 30));
        this.txtDetalle.setColumns(20);
        this.txtDetalle.setFont(new Font("Arial", 1, 12));
        this.txtDetalle.setRows(5);
        this.txtDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "Observaciones", 0, 0, new Font("Arial", 1, 12)));
        this.jScrollPane7.setViewportView(this.txtDetalle);
        this.jPanel2.add(this.jScrollPane7, new AbsoluteConstraints(730, 20, 440, 130));
        this.jLabel7.setFont(new Font("Arial", 1, 12));
        this.jLabel7.setForeground(new Color(0, 0, 153));
        this.jLabel7.setText("Fecha");
        this.jPanel2.add(this.jLabel7, new AbsoluteConstraints(10, 20, 70, -1));
        this.txtFecha.setDateFormatString("dd/MM/yyyy");
        this.txtFecha.setFont(new Font("Arial", 1, 12));
        this.txtFecha.setMaxSelectableDate(new Date(253370786463000L));
        this.txtFecha.setName("txtFecha");
        this.txtFecha.addPropertyChangeListener(new PropertyChangeListener() { // from class: PyP.CACervixResultado.14
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                CACervixResultado.this.txtFechaPropertyChange(evt);
            }
        });
        this.jPanel2.add(this.txtFecha, new AbsoluteConstraints(10, 40, 120, 30));
        this.jLabel6.setFont(new Font("Arial", 1, 12));
        this.jLabel6.setForeground(new Color(0, 0, 153));
        this.jLabel6.setText("Profesional");
        this.jPanel2.add(this.jLabel6, new AbsoluteConstraints(140, 20, 80, -1));
        this.cboProfesional.setFont(new Font("Arial", 1, 12));
        this.cboProfesional.addItemListener(new ItemListener() { // from class: PyP.CACervixResultado.15
            public void itemStateChanged(ItemEvent evt) {
                CACervixResultado.this.cboProfesionalItemStateChanged(evt);
            }
        });
        this.jPanel2.add(this.cboProfesional, new AbsoluteConstraints(140, 40, 220, 30));
        this.grid6.setFont(new Font("Arial", 1, 12));
        this.grid6.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.grid6.setToolTipText("Doble Click para cargar pantalla con valores");
        this.grid6.setRowHeight(19);
        this.grid6.addMouseListener(new MouseAdapter() { // from class: PyP.CACervixResultado.16
            public void mouseClicked(MouseEvent evt) {
                CACervixResultado.this.grid6MouseClicked(evt);
            }
        });
        this.grid6.addKeyListener(new KeyAdapter() { // from class: PyP.CACervixResultado.17
            public void keyPressed(KeyEvent evt) {
                CACervixResultado.this.grid6KeyPressed(evt);
            }
        });
        this.jScrollPane8.setViewportView(this.grid6);
        this.grid6.getColumnModel().getSelectionModel().setSelectionMode(0);
        this.jPanel2.add(this.jScrollPane8, new AbsoluteConstraints(500, 20, 220, 90));
        this.btnCuello.setFont(new Font("Arial", 1, 12));
        this.btnCuello.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Buscar.png")));
        this.btnCuello.setText("Buscar");
        this.btnCuello.addActionListener(new ActionListener() { // from class: PyP.CACervixResultado.18
            public void actionPerformed(ActionEvent evt) {
                CACervixResultado.this.btnCuelloActionPerformed(evt);
            }
        });
        this.jPanel2.add(this.btnCuello, new AbsoluteConstraints(610, 120, 110, 30));
        getContentPane().add(this.jPanel2, new AbsoluteConstraints(0, 180, 1190, 160));
        this.panelResultado.setBackground(new Color(0, 153, 153));
        this.panelResultado.setBorder(BorderFactory.createTitledBorder((Border) null, "RESULTADOS", 0, 0, new Font("Arial", 1, 12), new Color(204, 255, 255)));
        this.panelResultado.setLayout(new AbsoluteLayout());
        this.cboCategorizacion.setFont(new Font("Arial", 1, 12));
        this.cboCategorizacion.addItemListener(new ItemListener() { // from class: PyP.CACervixResultado.19
            public void itemStateChanged(ItemEvent evt) {
                CACervixResultado.this.cboCategorizacionItemStateChanged(evt);
            }
        });
        this.panelResultado.add(this.cboCategorizacion, new AbsoluteConstraints(710, 50, 440, 30));
        this.jLabel9.setFont(new Font("Arial", 1, 12));
        this.jLabel9.setForeground(new Color(0, 0, 102));
        this.jLabel9.setText("Calidad de la muestra");
        this.panelResultado.add(this.jLabel9, new AbsoluteConstraints(290, 30, 210, -1));
        this.jLabel10.setFont(new Font("Arial", 1, 12));
        this.jLabel10.setForeground(new Color(0, 0, 102));
        this.jLabel10.setText("Categorización");
        this.panelResultado.add(this.jLabel10, new AbsoluteConstraints(710, 30, 180, -1));
        this.cboCalidad.setFont(new Font("Arial", 1, 12));
        this.cboCalidad.setToolTipText("Zona de Transformación");
        this.cboCalidad.addItemListener(new ItemListener() { // from class: PyP.CACervixResultado.20
            public void itemStateChanged(ItemEvent evt) {
                CACervixResultado.this.cboCalidadItemStateChanged(evt);
            }
        });
        this.panelResultado.add(this.cboCalidad, new AbsoluteConstraints(290, 50, 380, 30));
        this.grid.setFont(new Font("Arial", 1, 12));
        this.grid.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.grid.setRowHeight(25);
        this.grid.setSelectionBackground(new Color(255, 255, 255));
        this.grid.setSelectionForeground(new Color(255, 0, 0));
        this.grid.setSelectionMode(0);
        this.jScrollPane1.setViewportView(this.grid);
        this.panelResultado.add(this.jScrollPane1, new AbsoluteConstraints(10, 310, 1150, 130));
        this.jTabbedPane1.setBackground(new Color(0, 153, 153));
        this.jTabbedPane1.setForeground(new Color(0, 0, 102));
        this.jTabbedPane1.setFont(new Font("Arial", 1, 12));
        this.jPanel3.setBackground(new Color(0, 153, 153));
        this.grid1.setFont(new Font("Arial", 1, 12));
        this.grid1.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0]}, new String[0]));
        this.grid1.setToolTipText("Doble Click para cargar pantalla con valores");
        this.grid1.setRowHeight(25);
        this.grid1.setSelectionBackground(new Color(255, 255, 255));
        this.grid1.setSelectionForeground(new Color(255, 0, 0));
        this.grid1.setSelectionMode(0);
        this.grid1.addMouseListener(new MouseAdapter() { // from class: PyP.CACervixResultado.21
            public void mouseClicked(MouseEvent evt) {
                CACervixResultado.this.grid1MouseClicked(evt);
            }
        });
        this.grid1.addKeyListener(new KeyAdapter() { // from class: PyP.CACervixResultado.22
            public void keyPressed(KeyEvent evt) {
                CACervixResultado.this.grid1KeyPressed(evt);
            }
        });
        this.jScrollPane2.setViewportView(this.grid1);
        this.btnMicro.setFont(new Font("Arial", 1, 12));
        this.btnMicro.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Buscar.png")));
        this.btnMicro.setText("Buscar");
        this.btnMicro.addActionListener(new ActionListener() { // from class: PyP.CACervixResultado.23
            public void actionPerformed(ActionEvent evt) {
                CACervixResultado.this.btnMicroActionPerformed(evt);
            }
        });
        this.grid2.setFont(new Font("Arial", 1, 12));
        this.grid2.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.grid2.setToolTipText("Doble Click para cargar pantalla con valores");
        this.grid2.setRowHeight(25);
        this.grid2.setSelectionBackground(new Color(255, 255, 255));
        this.grid2.setSelectionForeground(Color.red);
        this.grid2.setSelectionMode(0);
        this.grid2.addMouseListener(new MouseAdapter() { // from class: PyP.CACervixResultado.24
            public void mouseClicked(MouseEvent evt) {
                CACervixResultado.this.grid2MouseClicked(evt);
            }
        });
        this.grid2.addKeyListener(new KeyAdapter() { // from class: PyP.CACervixResultado.25
            public void keyPressed(KeyEvent evt) {
                CACervixResultado.this.grid2KeyPressed(evt);
            }
        });
        this.jScrollPane3.setViewportView(this.grid2);
        this.btnNoNeo.setFont(new Font("Arial", 1, 12));
        this.btnNoNeo.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Buscar.png")));
        this.btnNoNeo.setText("Buscar");
        this.btnNoNeo.addActionListener(new ActionListener() { // from class: PyP.CACervixResultado.26
            public void actionPerformed(ActionEvent evt) {
                CACervixResultado.this.btnNoNeoActionPerformed(evt);
            }
        });
        GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
        this.jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jScrollPane2, -2, 536, -2).addComponent(this.btnMicro, -2, 118, -2)).addGap(18, 18, 18).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jScrollPane3, -2, 571, -2).addComponent(this.btnNoNeo, -2, 111, -2)).addContainerGap()));
        jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jScrollPane3, 0, 0, 32767).addComponent(this.jScrollPane2, -1, 128, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.btnMicro, -2, 28, -2).addComponent(this.btnNoNeo, -2, 28, -2)).addContainerGap(-1, 32767)));
        this.jTabbedPane1.addTab("MicroOrganismos y Hallazgos", this.jPanel3);
        this.jPanel4.setBackground(new Color(0, 153, 153));
        this.grid3.setFont(new Font("Arial", 1, 12));
        this.grid3.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.grid3.setToolTipText("Doble Click para cargar pantalla con valores");
        this.grid3.setRowHeight(25);
        this.grid3.setSelectionBackground(new Color(255, 255, 255));
        this.grid3.setSelectionForeground(Color.red);
        this.grid3.setSelectionMode(0);
        this.grid3.addMouseListener(new MouseAdapter() { // from class: PyP.CACervixResultado.27
            public void mouseClicked(MouseEvent evt) {
                CACervixResultado.this.grid3MouseClicked(evt);
            }
        });
        this.grid3.addKeyListener(new KeyAdapter() { // from class: PyP.CACervixResultado.28
            public void keyPressed(KeyEvent evt) {
                CACervixResultado.this.grid3KeyPressed(evt);
            }
        });
        this.jScrollPane4.setViewportView(this.grid3);
        this.BtnAnormal.setFont(new Font("Arial", 1, 12));
        this.BtnAnormal.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Buscar.png")));
        this.BtnAnormal.setText("Buscar");
        this.BtnAnormal.addActionListener(new ActionListener() { // from class: PyP.CACervixResultado.29
            public void actionPerformed(ActionEvent evt) {
                CACervixResultado.this.BtnAnormalActionPerformed(evt);
            }
        });
        this.grid4.setFont(new Font("Arial", 1, 12));
        this.grid4.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.grid4.setToolTipText("Doble Click para cargar pantalla con valores");
        this.grid4.setRowHeight(25);
        this.grid4.setSelectionBackground(new Color(255, 255, 255));
        this.grid4.setSelectionForeground(new Color(255, 0, 0));
        this.grid4.setSelectionMode(0);
        this.grid4.addMouseListener(new MouseAdapter() { // from class: PyP.CACervixResultado.30
            public void mouseClicked(MouseEvent evt) {
                CACervixResultado.this.grid4MouseClicked(evt);
            }
        });
        this.grid4.addKeyListener(new KeyAdapter() { // from class: PyP.CACervixResultado.31
            public void keyPressed(KeyEvent evt) {
                CACervixResultado.this.grid4KeyPressed(evt);
            }
        });
        this.jScrollPane5.setViewportView(this.grid4);
        this.btnGlandular.setFont(new Font("Arial", 1, 12));
        this.btnGlandular.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Buscar.png")));
        this.btnGlandular.setText("Buscar");
        this.btnGlandular.addActionListener(new ActionListener() { // from class: PyP.CACervixResultado.32
            public void actionPerformed(ActionEvent evt) {
                CACervixResultado.this.btnGlandularActionPerformed(evt);
            }
        });
        GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
        this.jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addContainerGap().addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jScrollPane4, -2, 530, -2).addComponent(this.BtnAnormal, -2, 115, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jScrollPane5, -1, 585, 32767).addComponent(this.btnGlandular, -2, 114, -2)).addContainerGap()));
        jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addContainerGap().addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane5, 0, 0, 32767).addComponent(this.jScrollPane4, -2, 120, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.BtnAnormal, -2, 28, -2).addComponent(this.btnGlandular, -2, 28, -2)).addContainerGap(-1, 32767)));
        this.jTabbedPane1.addTab("Anormalidades", this.jPanel4);
        this.jPanel5.setBackground(new Color(0, 153, 153));
        this.grid5.setFont(new Font("Arial", 1, 12));
        this.grid5.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.grid5.setToolTipText("Doble Click para cargar pantalla con valores");
        this.grid5.setColumnSelectionAllowed(true);
        this.grid5.setRowHeight(25);
        this.grid5.setSelectionBackground(new Color(255, 255, 255));
        this.grid5.setSelectionForeground(Color.red);
        this.grid5.setSelectionMode(0);
        this.grid5.addMouseListener(new MouseAdapter() { // from class: PyP.CACervixResultado.33
            public void mouseClicked(MouseEvent evt) {
                CACervixResultado.this.grid5MouseClicked(evt);
            }
        });
        this.grid5.addKeyListener(new KeyAdapter() { // from class: PyP.CACervixResultado.34
            public void keyPressed(KeyEvent evt) {
                CACervixResultado.this.grid5KeyPressed(evt);
            }
        });
        this.jScrollPane6.setViewportView(this.grid5);
        this.grid5.getColumnModel().getSelectionModel().setSelectionMode(0);
        this.btnOtras.setText("...");
        this.btnOtras.addActionListener(new ActionListener() { // from class: PyP.CACervixResultado.35
            public void actionPerformed(ActionEvent evt) {
                CACervixResultado.this.btnOtrasActionPerformed(evt);
            }
        });
        this.btnOtros.setFont(new Font("Arial", 1, 12));
        this.btnOtros.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Buscar.png")));
        this.btnOtros.setText("Buscar");
        this.btnOtros.addActionListener(new ActionListener() { // from class: PyP.CACervixResultado.36
            public void actionPerformed(ActionEvent evt) {
                CACervixResultado.this.btnOtrosActionPerformed(evt);
            }
        });
        GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
        this.jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addContainerGap().addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.btnOtros, -2, 114, -2).addComponent(this.btnOtras, -2, 40, -2).addComponent(this.jScrollPane6, -2, 530, -2)).addContainerGap(605, 32767)));
        jPanel5Layout.setVerticalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane6, -2, 123, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.btnOtros, -2, 27, -2).addGap(122, 122, 122).addComponent(this.btnOtras)));
        this.jTabbedPane1.addTab("Otros", this.jPanel5);
        this.panelResultado.add(this.jTabbedPane1, new AbsoluteConstraints(10, 100, 1150, 200));
        this.jLabel4.setFont(new Font("Arial", 1, 12));
        this.jLabel4.setForeground(new Color(0, 0, 153));
        this.jLabel4.setText("Fecha de Reporte");
        this.panelResultado.add(this.jLabel4, new AbsoluteConstraints(20, 30, 100, -1));
        this.txtFechaReporte.setDateFormatString("dd/MM/yyyy");
        this.txtFechaReporte.setFont(new Font("Arial", 1, 12));
        this.txtFechaReporte.setName("txtFecha");
        this.txtFechaReporte.addPropertyChangeListener(new PropertyChangeListener() { // from class: PyP.CACervixResultado.37
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                CACervixResultado.this.txtFechaReportePropertyChange(evt);
            }
        });
        this.panelResultado.add(this.txtFechaReporte, new AbsoluteConstraints(20, 50, 110, 30));
        this.jLabel5.setFont(new Font("Arial", 1, 12));
        this.jLabel5.setForeground(new Color(0, 0, 153));
        this.jLabel5.setText("Fecha Informe a Usuario");
        this.panelResultado.add(this.jLabel5, new AbsoluteConstraints(140, 30, 140, -1));
        this.txtFechaPaciente.setDateFormatString("dd/MM/yyyy");
        this.txtFechaPaciente.setFont(new Font("Arial", 1, 12));
        this.txtFechaPaciente.setName("txtFecha");
        this.txtFechaPaciente.addPropertyChangeListener(new PropertyChangeListener() { // from class: PyP.CACervixResultado.38
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                CACervixResultado.this.txtFechaPacientePropertyChange(evt);
            }
        });
        this.panelResultado.add(this.txtFechaPaciente, new AbsoluteConstraints(150, 50, 120, 30));
        getContentPane().add(this.panelResultado, new AbsoluteConstraints(0, 350, 1190, 450));
        this.jLabel8.setFont(new Font("Arial", 1, 14));
        this.jLabel8.setForeground(new Color(0, 0, 204));
        this.jLabel8.setHorizontalAlignment(0);
        this.jLabel8.setIcon(new ImageIcon(getClass().getResource("/Imagenes/citologia.png")));
        this.jLabel8.setText("Antecedentes");
        this.jLabel8.setBorder(BorderFactory.createBevelBorder(1, new Color(153, 255, 255), new Color(102, 0, 102), (Color) null, (Color) null));
        this.jLabel8.setHorizontalTextPosition(0);
        this.jLabel8.setVerticalTextPosition(3);
        this.jLabel8.addMouseListener(new MouseAdapter() { // from class: PyP.CACervixResultado.39
            public void mouseClicked(MouseEvent evt) {
                CACervixResultado.this.jLabel8MouseClicked(evt);
            }
        });
        getContentPane().add(this.jLabel8, new AbsoluteConstraints(950, 20, 100, 140));
        this.jLabel11.setFont(new Font("Arial", 1, 14));
        this.jLabel11.setForeground(new Color(0, 0, 204));
        this.jLabel11.setHorizontalAlignment(0);
        this.jLabel11.setIcon(new ImageIcon(getClass().getResource("/Imagenes/callcenter.jpg")));
        this.jLabel11.setText("Asignar Cita");
        this.jLabel11.setBorder(BorderFactory.createBevelBorder(1, new Color(153, 255, 255), new Color(102, 0, 102), (Color) null, (Color) null));
        this.jLabel11.setHorizontalTextPosition(0);
        this.jLabel11.setVerticalTextPosition(3);
        this.jLabel11.addMouseListener(new MouseAdapter() { // from class: PyP.CACervixResultado.40
            public void mouseClicked(MouseEvent evt) {
                CACervixResultado.this.jLabel11MouseClicked(evt);
            }
        });
        getContentPane().add(this.jLabel11, new AbsoluteConstraints(1060, 20, 120, 140));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtFechaReportePropertyChange(PropertyChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtFechaPropertyChange(PropertyChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtFechaPacientePropertyChange(PropertyChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnEmbarazadaActionPerformed(ActionEvent evt) {
        if (this.btnEmbarazada.isSelected()) {
            this.embarazada = 0;
        } else {
            this.embarazada = 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnPrimerVezActionPerformed(ActionEvent evt) {
        if (this.btnPrimerVez.isSelected()) {
            this.pVez = 0;
        } else {
            this.pVez = 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameActivated(InternalFrameEvent evt) {
        this.clasepyp.frmPrincipal.mActivarBarraMenu(this.clasepyp.frmPrincipal.xMenus.barraMnuPyP, 15);
        Principal.txtNo.setText(this.idNo);
        Principal.txtEstado.setText(this.estado);
        Principal.txtFecha.setText(this.fecha);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void grid2MouseClicked(MouseEvent evt) {
        if (evt.getClickCount() > 1) {
            BuscarCACervix frmBCA = new BuscarCACervix(null, true, 2, this);
            frmBCA.setVisible(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void grid3MouseClicked(MouseEvent evt) {
        if (evt.getClickCount() > 1) {
            BuscarCACervix frmBCA = new BuscarCACervix(null, true, 3, this);
            frmBCA.setVisible(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void grid4MouseClicked(MouseEvent evt) {
        if (evt.getClickCount() > 1) {
            BuscarCACervix frmBCA = new BuscarCACervix(null, true, 4, this);
            frmBCA.setVisible(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void grid5MouseClicked(MouseEvent evt) {
        if (evt.getClickCount() > 1) {
            BuscarCACervix frmBCA = new BuscarCACervix(null, true, 5, this);
            frmBCA.setVisible(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnMicroActionPerformed(ActionEvent evt) {
        BuscarCACervix frmBCA = new BuscarCACervix(null, true, 1, this);
        frmBCA.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnNoNeoActionPerformed(ActionEvent evt) {
        BuscarCACervix frmBCA = new BuscarCACervix(null, true, 2, this);
        frmBCA.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BtnAnormalActionPerformed(ActionEvent evt) {
        BuscarCACervix frmBCA = new BuscarCACervix(null, true, 3, this);
        frmBCA.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnGlandularActionPerformed(ActionEvent evt) {
        BuscarCACervix frmBCA = new BuscarCACervix(null, true, 4, this);
        frmBCA.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnOtrasActionPerformed(ActionEvent evt) {
        BuscarCACervix frmBCA = new BuscarCACervix(null, true, 5, this);
        frmBCA.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboProfesionalItemStateChanged(ItemEvent evt) {
        if (this.cboProfesional.getSelectedIndex() > -1 && this.cboLleno == 1) {
            setProfesional(this.lisProfesional[this.cboProfesional.getSelectedIndex()][0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboEsquemaItemStateChanged(ItemEvent evt) {
        if (this.cboEsquema.getSelectedIndex() > -1 && this.cboLleno == 1) {
            setEsquema(this.lisEsquema[this.cboEsquema.getSelectedIndex()]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboMetodoItemStateChanged(ItemEvent evt) {
        if (this.cboMetodo.getSelectedIndex() > -1 && this.cboLleno == 1) {
            setMetodo(this.lisMetodo[this.cboMetodo.getSelectedIndex()]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboCalidadItemStateChanged(ItemEvent evt) {
        if (this.cboCalidad.getSelectedIndex() > -1 && this.cboLleno == 1) {
            setCalidad(this.lisCalidad[this.cboCalidad.getSelectedIndex()]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboCategorizacionItemStateChanged(ItemEvent evt) {
        if (this.cboCategorizacion.getSelectedIndex() > -1 && this.cboLleno == 1) {
            setCategorizacion(this.lisCategorizacion[this.cboCategorizacion.getSelectedIndex()]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void grid1KeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 127) {
            eliminarFilaGrid(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void grid2KeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 127) {
            eliminarFilaGrid(2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void grid3KeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 127) {
            eliminarFilaGrid(3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void grid4KeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 127) {
            eliminarFilaGrid(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void grid5KeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 127) {
            eliminarFilaGrid(5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void grid6MouseClicked(MouseEvent evt) {
        if (evt.getClickCount() > 1) {
            BuscarCACervix frmBCA = new BuscarCACervix(null, true, 6, this);
            frmBCA.setVisible(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void grid6KeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 127) {
            eliminarFilaGrid(6);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void grid1MouseClicked(MouseEvent evt) {
        if (evt.getClickCount() > 1) {
            BuscarCACervix frmBCA = new BuscarCACervix(null, true, 1, this);
            frmBCA.setVisible(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnOtrosActionPerformed(ActionEvent evt) {
        BuscarCACervix frmBCA = new BuscarCACervix(null, true, 5, this);
        frmBCA.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnCuelloActionPerformed(ActionEvent evt) {
        BuscarCACervix frmBCA = new BuscarCACervix(null, true, 6, this);
        frmBCA.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jLabel8MouseClicked(MouseEvent evt) {
        cargarAntecedentes();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jLabel11MouseClicked(MouseEvent evt) {
        asignarCita();
    }
}
