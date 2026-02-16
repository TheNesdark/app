package Citas;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JCalendar;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.HierarchyEvent;
import java.awt.event.HierarchyListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;
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
import java.util.GregorianCalendar;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.JTree;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/* JADX INFO: loaded from: GenomaP.jar:Citas/Programar.class */
public class Programar extends JInternalFrame {
    private String[] listaConsultorio;
    private String[][] listaProfesional;
    private String[][] listaTurnos;
    private String sql;
    private String nbreProfesional;
    private String idProfesional;
    private String especialAnterior;
    private Object[] filaGrid;
    private ResultSet rs;
    private DefaultTableModel modeloGridLun;
    private DefaultTableModel modeloGridMar;
    private DefaultTableModel modeloGridMie;
    private DefaultTableModel modeloGridJue;
    private DefaultTableModel modeloGridVie;
    private DefaultTableModel modeloGridSab;
    private DefaultTableModel modeloGridDom;
    private clasesCita clasCita;
    private JTree Arbol;
    private JCheckBox JCHAdicional;
    private JCheckBox JCH_Filtro;
    private JRadioButton btnEspecial;
    private JRadioButton btnGeneral;
    private JCheckBox btnListaTurno;
    private JCheckBox btnNuevoTurno;
    private JRadioButton btnVacaciones;
    private ButtonGroup buttonGroup1;
    private ButtonGroup buttonGroup2;
    private JComboBox cboConsultorio;
    private JComboBox cboDiaSemana;
    private JComboBox cboTurno;
    private JTable gridDomingo;
    private JTable gridJueves;
    private JTable gridLunes;
    private JTable gridMartes;
    private JTable gridMiercoles;
    private JTable gridSabado;
    private JTable gridViernes;
    private JButton jButton1;
    private JLabel jLabel1;
    private JLabel jLabel10;
    private JLabel jLabel11;
    private JLabel jLabel5;
    private JLabel jLabel7;
    private JPanel jPanel10;
    private JPanel jPanel11;
    private JPanel jPanel12;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JPanel jPanel5;
    private JPanel jPanel6;
    private JPanel jPanel7;
    private JPanel jPanel8;
    private JPanel jPanel9;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JScrollPane jScrollPane3;
    private JScrollPane jScrollPane4;
    private JScrollPane jScrollPane5;
    private JScrollPane jScrollPane6;
    private JScrollPane jScrollPane7;
    private JScrollPane jScrollPane8;
    private JToolBar jToolBar1;
    public JTabbedPane panelSemana;
    private JSpinner txtAMPMFinal;
    private JSpinner txtAMPMInicio;
    private JSpinner txtCantidad;
    private JCalendar txtFecha;
    private JSpinner txtHoraFinal;
    private JSpinner txtHoraInicio;
    private JSpinner txtMinutoFinal;
    private JSpinner txtMinutoInicio;
    private Metodos metodos = new Metodos();
    private ConsultasMySQL consultas = new ConsultasMySQL();
    private String idEspecialidad = "";
    private int filaLun = 0;
    private int filaMar = 0;
    private int xesadicional = 0;
    private int filaMie = 0;
    private int filaJue = 0;
    private int filaVie = 0;
    private int filaSab = 0;
    private int filaDom = 0;
    private int tipoAgenda = 2;
    private int cboLleno = 0;
    private DefaultMutableTreeNode tallo = new DefaultMutableTreeNode("ESPECIALIDADES");
    private DefaultMutableTreeNode rama = new DefaultMutableTreeNode("PROFESIONALES");
    private DefaultMutableTreeNode hoja = new DefaultMutableTreeNode("MEDICOS");
    private DefaultTreeModel modeloArbol = new DefaultTreeModel(this.tallo);
    private DefaultMutableTreeNode nodo = new DefaultMutableTreeNode();
    private GregorianCalendar fechaCal = new GregorianCalendar();

    public Programar(clasesCita clase) {
        initComponents();
        this.clasCita = clase;
        llenarCombos();
        crearGrid();
        cargarArbol();
        this.cboDiaSemana.setSelectedIndex(this.fechaCal.get(7) - 2);
        this.gridLunes.addMouseListener(new MouseAdapter() { // from class: Citas.Programar.1
            public void mouseClicked(MouseEvent e) {
                Programar.this.filaLun = Programar.this.gridLunes.rowAtPoint(e.getPoint());
            }
        });
        this.gridMartes.addMouseListener(new MouseAdapter() { // from class: Citas.Programar.2
            public void mouseClicked(MouseEvent e) {
                Programar.this.filaMar = Programar.this.gridMartes.rowAtPoint(e.getPoint());
            }
        });
        this.gridMiercoles.addMouseListener(new MouseAdapter() { // from class: Citas.Programar.3
            public void mouseClicked(MouseEvent e) {
                Programar.this.filaMie = Programar.this.gridMiercoles.rowAtPoint(e.getPoint());
            }
        });
        this.gridJueves.addMouseListener(new MouseAdapter() { // from class: Citas.Programar.4
            public void mouseClicked(MouseEvent e) {
                Programar.this.filaJue = Programar.this.gridJueves.rowAtPoint(e.getPoint());
            }
        });
        this.gridViernes.addMouseListener(new MouseAdapter() { // from class: Citas.Programar.5
            public void mouseClicked(MouseEvent e) {
                Programar.this.filaVie = Programar.this.gridViernes.rowAtPoint(e.getPoint());
            }
        });
        this.gridSabado.addMouseListener(new MouseAdapter() { // from class: Citas.Programar.6
            public void mouseClicked(MouseEvent e) {
                Programar.this.filaSab = Programar.this.gridSabado.rowAtPoint(e.getPoint());
            }
        });
        this.gridDomingo.addMouseListener(new MouseAdapter() { // from class: Citas.Programar.7
            public void mouseClicked(MouseEvent e) {
                Programar.this.filaDom = Programar.this.gridDomingo.rowAtPoint(e.getPoint());
            }
        });
        this.btnGeneral.setEnabled(false);
    }

    private void agregarFilaGrid() {
        if (validarDatos() == 1) {
            if (this.cboDiaSemana.getSelectedIndex() == 0 && grabarFilaGrid(this.modeloGridLun, this.gridLunes, this.filaLun, 0) == 0) {
                this.filaLun++;
                return;
            }
            if (this.cboDiaSemana.getSelectedIndex() == 1 && grabarFilaGrid(this.modeloGridMar, this.gridMartes, this.filaMar, 1) == 0) {
                this.filaMar++;
                return;
            }
            if (this.cboDiaSemana.getSelectedIndex() == 2 && grabarFilaGrid(this.modeloGridMie, this.gridMiercoles, this.filaMie, 2) == 0) {
                this.filaMie++;
                return;
            }
            if (this.cboDiaSemana.getSelectedIndex() == 3 && grabarFilaGrid(this.modeloGridJue, this.gridJueves, this.filaJue, 3) == 0) {
                this.filaJue++;
                return;
            }
            if (this.cboDiaSemana.getSelectedIndex() == 4 && grabarFilaGrid(this.modeloGridVie, this.gridViernes, this.filaVie, 4) == 0) {
                this.filaVie++;
                return;
            }
            if (this.cboDiaSemana.getSelectedIndex() == 5 && grabarFilaGrid(this.modeloGridSab, this.gridSabado, this.filaSab, 5) == 0) {
                this.filaSab++;
            } else if (this.cboDiaSemana.getSelectedIndex() == 6 && grabarFilaGrid(this.modeloGridDom, this.gridDomingo, this.filaDom, 6) == 0) {
                this.filaDom++;
            }
        }
    }

    private void cargarArbol() {
        this.sql = "SELECT g_profesionalespecial.Id_Especialidad, g_especialidad.Nbre, g_persona.Apellido1, g_persona.Apellido2, g_persona.Nombre1, g_persona.Nombre2, g_persona.Id FROM baseserver.g_profesional INNER JOIN baseserver.g_profesionalespecial ON (g_profesional.Id_Persona = g_profesionalespecial.Id_Profesional) INNER JOIN baseserver.g_persona ON (g_profesional.Id_Persona = g_persona.Id) INNER JOIN baseserver.g_especialidad ON (g_profesionalespecial.Id_Especialidad = g_especialidad.Id) WHERE g_profesional.Activo_Cita = 0 ORDER BY g_especialidad.Nbre DESC, g_persona.Apellido1 DESC,  g_persona.Apellido2 DESC";
        try {
            this.rs = this.consultas.traerRs(this.sql);
            this.rs.last();
            this.listaProfesional = new String[this.rs.getRow() + 1][4];
            this.rs.beforeFirst();
            while (this.rs.next()) {
                this.nbreProfesional = this.rs.getString(3) + " " + this.rs.getString(4) + " " + this.rs.getString(5) + " " + this.rs.getString(6);
                this.hoja = new DefaultMutableTreeNode(this.nbreProfesional);
                this.listaProfesional[this.rs.getRow()][0] = this.rs.getString(7);
                this.listaProfesional[this.rs.getRow()][1] = this.nbreProfesional;
                this.listaProfesional[this.rs.getRow()][2] = this.rs.getString(1);
                this.listaProfesional[this.rs.getRow()][3] = this.rs.getString(2);
                if (!this.rs.getString(2).equals(this.especialAnterior)) {
                    this.rama = new DefaultMutableTreeNode(this.rs.getString(2));
                    this.modeloArbol.insertNodeInto(this.rama, this.tallo, 0);
                    this.especialAnterior = this.rs.getString(2);
                }
                this.modeloArbol.insertNodeInto(this.hoja, this.rama, 0);
            }
            this.rs.close();
            this.consultas.cerrarConexionBd();
            this.Arbol.setModel(this.modeloArbol);
            this.Arbol.getSelectionModel().setSelectionMode(1);
            this.Arbol.setScrollsOnExpand(true);
            this.Arbol.requestFocus();
        } catch (SQLException e) {
        }
    }

    private void cargarProgramacion() {
        if (this.JCH_Filtro.isSelected()) {
            this.sql = "SELECT  c_confcitas.Fecha_ConfCitas, c_confcitas.HoraInicial, c_confcitas.HoraFinal, c_confcitas.Id_Consultorio, c_consultorio.Nbre, c_confcitas.Cupo, c_confcitas.TipoAgenda, c_confcitas.DiaSemana FROM baseserver.c_confcitas INNER JOIN baseserver.c_consultorio ON (c_confcitas.Id_Consultorio = c_consultorio.Id) WHERE (c_confcitas.Id_Profesional ='" + this.idProfesional + "' AND c_confcitas.Id_Especialidad ='" + this.idEspecialidad + "' AND c_confcitas.Estado = 0) ORDER BY c_confcitas.Fecha_ConfCitas DESC";
        } else {
            this.sql = "SELECT  c_confcitas.Fecha_ConfCitas, c_confcitas.HoraInicial, c_confcitas.HoraFinal, c_confcitas.Id_Consultorio, c_consultorio.Nbre, c_confcitas.Cupo, c_confcitas.TipoAgenda, c_confcitas.DiaSemana FROM baseserver.c_confcitas INNER JOIN baseserver.c_consultorio ON (c_confcitas.Id_Consultorio = c_consultorio.Id) WHERE (c_confcitas.Id_Profesional ='" + this.idProfesional + "' AND c_confcitas.Id_Especialidad ='" + this.idEspecialidad + "' and date_format( c_confcitas.Fecha_ConfCitas, '%Y-%m')='" + this.metodos.formatoANO_MES.format(this.txtFecha.getDate()) + "' AND c_confcitas.Estado = 0) ORDER BY c_confcitas.Fecha_ConfCitas DESC";
        }
        this.rs = this.consultas.traerRs(this.sql);
        try {
            crearGrid();
            while (this.rs.next()) {
                switch (this.rs.getInt(8)) {
                    case 1:
                        this.modeloGridLun.addRow(this.filaGrid);
                        this.gridLunes.setValueAt(this.rs.getString(1), this.filaLun, 0);
                        this.gridLunes.setValueAt(this.metodos.formatoHora12(this.rs.getString(2)), this.filaLun, 1);
                        this.gridLunes.setValueAt(this.metodos.formatoHora12(this.rs.getString(3)), this.filaLun, 2);
                        this.gridLunes.setValueAt(this.rs.getString(4), this.filaLun, 3);
                        this.gridLunes.setValueAt(this.rs.getString(5), this.filaLun, 4);
                        this.gridLunes.setValueAt(this.rs.getString(6), this.filaLun, 5);
                        this.gridLunes.setValueAt(tipoAgenda(this.rs.getString(7)), this.filaLun, 6);
                        this.gridLunes.setValueAt("0", this.filaLun, 7);
                        this.filaLun++;
                        break;
                    case 2:
                        this.modeloGridMar.addRow(this.filaGrid);
                        this.gridMartes.setValueAt(this.rs.getString(1), this.filaMar, 0);
                        this.gridMartes.setValueAt(this.metodos.formatoHora12(this.rs.getString(2)), this.filaMar, 1);
                        this.gridMartes.setValueAt(this.metodos.formatoHora12(this.rs.getString(3)), this.filaMar, 2);
                        this.gridMartes.setValueAt(this.rs.getString(4), this.filaMar, 3);
                        this.gridMartes.setValueAt(this.rs.getString(5), this.filaMar, 4);
                        this.gridMartes.setValueAt(this.rs.getString(6), this.filaMar, 5);
                        this.gridMartes.setValueAt(tipoAgenda(this.rs.getString(7)), this.filaMar, 6);
                        this.gridMartes.setValueAt("0", this.filaMar, 7);
                        this.filaMar++;
                        break;
                    case 3:
                        this.modeloGridMie.addRow(this.filaGrid);
                        this.gridMiercoles.setValueAt(this.rs.getString(1), this.filaMie, 0);
                        this.gridMiercoles.setValueAt(this.metodos.formatoHora12(this.rs.getString(2)), this.filaMie, 1);
                        this.gridMiercoles.setValueAt(this.metodos.formatoHora12(this.rs.getString(3)), this.filaMie, 2);
                        this.gridMiercoles.setValueAt(this.rs.getString(4), this.filaMie, 3);
                        this.gridMiercoles.setValueAt(this.rs.getString(5), this.filaMie, 4);
                        this.gridMiercoles.setValueAt(this.rs.getString(6), this.filaMie, 5);
                        this.gridMiercoles.setValueAt(tipoAgenda(this.rs.getString(7)), this.filaMie, 6);
                        this.gridMiercoles.setValueAt("0", this.filaMie, 7);
                        this.filaMie++;
                        break;
                    case 4:
                        this.modeloGridJue.addRow(this.filaGrid);
                        this.gridJueves.setValueAt(this.rs.getString(1), this.filaJue, 0);
                        this.gridJueves.setValueAt(this.metodos.formatoHora12(this.rs.getString(2)), this.filaJue, 1);
                        this.gridJueves.setValueAt(this.metodos.formatoHora12(this.rs.getString(3)), this.filaJue, 2);
                        this.gridJueves.setValueAt(this.rs.getString(4), this.filaJue, 3);
                        this.gridJueves.setValueAt(this.rs.getString(5), this.filaJue, 4);
                        this.gridJueves.setValueAt(this.rs.getString(6), this.filaJue, 5);
                        this.gridJueves.setValueAt(tipoAgenda(this.rs.getString(7)), this.filaJue, 6);
                        this.gridJueves.setValueAt("0", this.filaJue, 7);
                        this.filaJue++;
                        break;
                    case 5:
                        this.modeloGridVie.addRow(this.filaGrid);
                        this.gridViernes.setValueAt(this.rs.getString(1), this.filaVie, 0);
                        this.gridViernes.setValueAt(this.metodos.formatoHora12(this.rs.getString(2)), this.filaVie, 1);
                        this.gridViernes.setValueAt(this.metodos.formatoHora12(this.rs.getString(3)), this.filaVie, 2);
                        this.gridViernes.setValueAt(this.rs.getString(4), this.filaVie, 3);
                        this.gridViernes.setValueAt(this.rs.getString(5), this.filaVie, 4);
                        this.gridViernes.setValueAt(this.rs.getString(6), this.filaVie, 5);
                        this.gridViernes.setValueAt(tipoAgenda(this.rs.getString(7)), this.filaVie, 6);
                        this.gridViernes.setValueAt("0", this.filaVie, 7);
                        this.filaVie++;
                        break;
                    case 6:
                        this.modeloGridSab.addRow(this.filaGrid);
                        this.gridSabado.setValueAt(this.rs.getString(1), this.filaSab, 0);
                        this.gridSabado.setValueAt(this.metodos.formatoHora12(this.rs.getString(2)), this.filaSab, 1);
                        this.gridSabado.setValueAt(this.metodos.formatoHora12(this.rs.getString(3)), this.filaSab, 2);
                        this.gridSabado.setValueAt(this.rs.getString(4), this.filaSab, 3);
                        this.gridSabado.setValueAt(this.rs.getString(5), this.filaSab, 4);
                        this.gridSabado.setValueAt(this.rs.getString(6), this.filaSab, 5);
                        this.gridSabado.setValueAt(tipoAgenda(this.rs.getString(7)), this.filaSab, 6);
                        this.gridSabado.setValueAt("0", this.filaSab, 7);
                        this.filaSab++;
                        break;
                    case 7:
                        this.modeloGridDom.addRow(this.filaGrid);
                        this.gridDomingo.setValueAt(this.rs.getString(1), this.filaDom, 0);
                        this.gridDomingo.setValueAt(this.metodos.formatoHora12(this.rs.getString(2)), this.filaDom, 1);
                        this.gridDomingo.setValueAt(this.metodos.formatoHora12(this.rs.getString(3)), this.filaDom, 2);
                        this.gridDomingo.setValueAt(this.rs.getString(4), this.filaDom, 3);
                        this.gridDomingo.setValueAt(this.rs.getString(5), this.filaDom, 4);
                        this.gridDomingo.setValueAt(this.rs.getString(6), this.filaDom, 5);
                        this.gridDomingo.setValueAt(tipoAgenda(this.rs.getString(7)), this.filaDom, 6);
                        this.gridDomingo.setValueAt("0", this.filaDom, 7);
                        this.filaDom++;
                        break;
                }
            }
            this.consultas.cerrarConexionBd();
        } catch (SQLException ex) {
            this.consultas.mostrarErrorSQL(ex);
        }
    }

    private void crearGrid() {
        this.modeloGridLun = new DefaultTableModel() { // from class: Citas.Programar.8
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.modeloGridMar = new DefaultTableModel() { // from class: Citas.Programar.9
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.modeloGridMie = new DefaultTableModel() { // from class: Citas.Programar.10
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.modeloGridJue = new DefaultTableModel() { // from class: Citas.Programar.11
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.modeloGridVie = new DefaultTableModel() { // from class: Citas.Programar.12
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.modeloGridSab = new DefaultTableModel() { // from class: Citas.Programar.13
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.modeloGridDom = new DefaultTableModel() { // from class: Citas.Programar.14
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.modeloGridLun.addColumn("Fecha");
        this.modeloGridLun.addColumn("Hora Inicial");
        this.modeloGridLun.addColumn("Hora Final");
        this.modeloGridLun.addColumn("");
        this.modeloGridLun.addColumn("Consultorio");
        this.modeloGridLun.addColumn("Cant. Citas");
        this.modeloGridLun.addColumn("Tipo Agenda");
        this.modeloGridLun.addColumn("");
        this.modeloGridLun.addColumn("Usuario de creación");
        this.modeloGridLun.addColumn("Fecha y hora de creación");
        this.modeloGridMar.addColumn("Fecha");
        this.modeloGridMar.addColumn("Hora Inicial");
        this.modeloGridMar.addColumn("Hora Final");
        this.modeloGridMar.addColumn("");
        this.modeloGridMar.addColumn("Consultorio");
        this.modeloGridMar.addColumn("Cant. Citas");
        this.modeloGridMar.addColumn("Tipo Agenda");
        this.modeloGridMar.addColumn("");
        this.modeloGridMar.addColumn("Usuario de creación");
        this.modeloGridMar.addColumn("Fecha y hora de creación");
        this.modeloGridMie.addColumn("Fecha");
        this.modeloGridMie.addColumn("Hora Inicial");
        this.modeloGridMie.addColumn("Hora Final");
        this.modeloGridMie.addColumn("");
        this.modeloGridMie.addColumn("Consultorio");
        this.modeloGridMie.addColumn("Cant. Citas");
        this.modeloGridMie.addColumn("Tipo Agenda");
        this.modeloGridMie.addColumn("");
        this.modeloGridMie.addColumn("Usuario de creación");
        this.modeloGridMie.addColumn("Fecha y hora de creación");
        this.modeloGridJue.addColumn("Fecha");
        this.modeloGridJue.addColumn("Hora Inicial");
        this.modeloGridJue.addColumn("Hora Final");
        this.modeloGridJue.addColumn("");
        this.modeloGridJue.addColumn("Consultorio");
        this.modeloGridJue.addColumn("Cant. Citas");
        this.modeloGridJue.addColumn("Tipo Agenda");
        this.modeloGridJue.addColumn("");
        this.modeloGridJue.addColumn("Usuario de creación");
        this.modeloGridJue.addColumn("Fecha y hora de creación");
        this.modeloGridVie.addColumn("Fecha");
        this.modeloGridVie.addColumn("Hora Inicial");
        this.modeloGridVie.addColumn("Hora Final");
        this.modeloGridVie.addColumn("");
        this.modeloGridVie.addColumn("Consultorio");
        this.modeloGridVie.addColumn("Cant. Citas");
        this.modeloGridVie.addColumn("Tipo Agenda");
        this.modeloGridVie.addColumn("");
        this.modeloGridVie.addColumn("Usuario de creación");
        this.modeloGridVie.addColumn("Fecha y hora de creación");
        this.modeloGridSab.addColumn("Fecha");
        this.modeloGridSab.addColumn("Hora Inicial");
        this.modeloGridSab.addColumn("Hora Final");
        this.modeloGridSab.addColumn("");
        this.modeloGridSab.addColumn("Consultorio");
        this.modeloGridSab.addColumn("Cant. Citas");
        this.modeloGridSab.addColumn("Tipo Agenda");
        this.modeloGridSab.addColumn("");
        this.modeloGridSab.addColumn("Usuario de creación");
        this.modeloGridSab.addColumn("Fecha y hora de creación");
        this.modeloGridDom.addColumn("Fecha");
        this.modeloGridDom.addColumn("Hora Inicial");
        this.modeloGridDom.addColumn("Hora Final");
        this.modeloGridDom.addColumn("");
        this.modeloGridDom.addColumn("Consultorio");
        this.modeloGridDom.addColumn("Cant. Citas");
        this.modeloGridDom.addColumn("Tipo Agenda");
        this.modeloGridDom.addColumn("");
        this.modeloGridDom.addColumn("Usuario de creación");
        this.modeloGridDom.addColumn("Fecha y hora de creación");
        JTable jTable = this.gridLunes;
        JTable jTable2 = this.gridLunes;
        jTable.setAutoResizeMode(0);
        this.gridLunes.doLayout();
        this.gridLunes.setModel(this.modeloGridLun);
        JTable jTable3 = this.gridMartes;
        JTable jTable4 = this.gridMartes;
        jTable3.setAutoResizeMode(0);
        this.gridMartes.doLayout();
        this.gridMartes.setModel(this.modeloGridMar);
        JTable jTable5 = this.gridMiercoles;
        JTable jTable6 = this.gridMiercoles;
        jTable5.setAutoResizeMode(0);
        this.gridMiercoles.doLayout();
        this.gridMiercoles.setModel(this.modeloGridMie);
        JTable jTable7 = this.gridJueves;
        JTable jTable8 = this.gridJueves;
        jTable7.setAutoResizeMode(0);
        this.gridJueves.doLayout();
        this.gridJueves.setModel(this.modeloGridJue);
        JTable jTable9 = this.gridViernes;
        JTable jTable10 = this.gridViernes;
        jTable9.setAutoResizeMode(0);
        this.gridViernes.doLayout();
        this.gridViernes.setModel(this.modeloGridVie);
        JTable jTable11 = this.gridSabado;
        JTable jTable12 = this.gridSabado;
        jTable11.setAutoResizeMode(0);
        this.gridSabado.doLayout();
        this.gridSabado.setModel(this.modeloGridSab);
        JTable jTable13 = this.gridDomingo;
        JTable jTable14 = this.gridDomingo;
        jTable13.setAutoResizeMode(0);
        this.gridDomingo.doLayout();
        this.gridDomingo.setModel(this.modeloGridDom);
        this.gridLunes.getColumnModel().getColumn(3).setPreferredWidth(0);
        this.gridLunes.getColumnModel().getColumn(3).setMinWidth(0);
        this.gridLunes.getColumnModel().getColumn(3).setMaxWidth(0);
        this.gridMartes.getColumnModel().getColumn(3).setPreferredWidth(0);
        this.gridMartes.getColumnModel().getColumn(3).setMinWidth(0);
        this.gridMartes.getColumnModel().getColumn(3).setMaxWidth(0);
        this.gridMiercoles.getColumnModel().getColumn(3).setPreferredWidth(0);
        this.gridMiercoles.getColumnModel().getColumn(3).setMinWidth(0);
        this.gridMiercoles.getColumnModel().getColumn(3).setMaxWidth(0);
        this.gridJueves.getColumnModel().getColumn(3).setPreferredWidth(0);
        this.gridJueves.getColumnModel().getColumn(3).setMinWidth(0);
        this.gridJueves.getColumnModel().getColumn(3).setMaxWidth(0);
        this.gridViernes.getColumnModel().getColumn(3).setPreferredWidth(0);
        this.gridViernes.getColumnModel().getColumn(3).setMinWidth(0);
        this.gridViernes.getColumnModel().getColumn(3).setMaxWidth(0);
        this.gridSabado.getColumnModel().getColumn(3).setPreferredWidth(0);
        this.gridSabado.getColumnModel().getColumn(3).setMinWidth(0);
        this.gridSabado.getColumnModel().getColumn(3).setMaxWidth(0);
        this.gridDomingo.getColumnModel().getColumn(3).setPreferredWidth(0);
        this.gridDomingo.getColumnModel().getColumn(3).setMinWidth(0);
        this.gridDomingo.getColumnModel().getColumn(3).setMaxWidth(0);
        this.gridLunes.getColumnModel().getColumn(7).setPreferredWidth(0);
        this.gridLunes.getColumnModel().getColumn(7).setMinWidth(0);
        this.gridLunes.getColumnModel().getColumn(7).setMaxWidth(0);
        this.gridMartes.getColumnModel().getColumn(7).setPreferredWidth(0);
        this.gridMartes.getColumnModel().getColumn(7).setMinWidth(0);
        this.gridMartes.getColumnModel().getColumn(7).setMaxWidth(0);
        this.gridMiercoles.getColumnModel().getColumn(7).setPreferredWidth(0);
        this.gridMiercoles.getColumnModel().getColumn(7).setMinWidth(0);
        this.gridMiercoles.getColumnModel().getColumn(7).setMaxWidth(0);
        this.gridJueves.getColumnModel().getColumn(7).setPreferredWidth(0);
        this.gridJueves.getColumnModel().getColumn(7).setMinWidth(0);
        this.gridJueves.getColumnModel().getColumn(7).setMaxWidth(0);
        this.gridViernes.getColumnModel().getColumn(7).setPreferredWidth(0);
        this.gridViernes.getColumnModel().getColumn(7).setMinWidth(0);
        this.gridViernes.getColumnModel().getColumn(7).setMaxWidth(0);
        this.gridSabado.getColumnModel().getColumn(7).setPreferredWidth(0);
        this.gridSabado.getColumnModel().getColumn(7).setMinWidth(0);
        this.gridSabado.getColumnModel().getColumn(7).setMaxWidth(0);
        this.gridDomingo.getColumnModel().getColumn(7).setPreferredWidth(0);
        this.gridDomingo.getColumnModel().getColumn(7).setMinWidth(0);
        this.gridDomingo.getColumnModel().getColumn(7).setMaxWidth(0);
        this.filaLun = 0;
        this.filaMar = 0;
        this.filaMie = 0;
        this.filaJue = 0;
        this.filaVie = 0;
        this.filaSab = 0;
        this.filaDom = 0;
    }

    public void desistir(int dia) {
        if (dia == 10) {
            this.metodos.mostrarMensaje("Por favor seleccione la Programación que Anulará\ny presione la Tecla 'Supr' del Teclado");
            return;
        }
        if (this.metodos.getPregunta("Esta seguro de Desactivar la Programacion del Profesional") == 0) {
            if (dia == 1) {
                desactivarProgramacion(this.modeloGridLun, this.filaLun);
                return;
            }
            if (dia == 2) {
                desactivarProgramacion(this.modeloGridMar, this.filaMar);
                return;
            }
            if (dia == 3) {
                desactivarProgramacion(this.modeloGridMie, this.filaMie);
                return;
            }
            if (dia == 4) {
                desactivarProgramacion(this.modeloGridJue, this.filaJue);
                return;
            }
            if (dia == 5) {
                desactivarProgramacion(this.modeloGridVie, this.filaVie);
            } else if (dia == 6) {
                desactivarProgramacion(this.modeloGridSab, this.filaSab);
            } else if (dia == 7) {
                desactivarProgramacion(this.modeloGridDom, this.filaDom);
            }
        }
    }

    private void desactivar(DefaultTableModel model, int fila, int agenda) {
        this.sql = "UPDATE c_confcitas SET Estado = 1 WHERE Id_Profesional ='" + this.idProfesional + "' AND Id_Especialidad ='" + this.idEspecialidad + "' AND Fecha_ConfCitas ='" + model.getValueAt(fila, 0).toString() + "' AND HoraInicial ='" + this.metodos.pasarHora12a24(model.getValueAt(fila, 1).toString()).substring(0, 6) + "' AND HoraFinal ='" + this.metodos.pasarHora12a24(model.getValueAt(fila, 2).toString()).substring(0, 6) + "' AND TipoAgenda ='" + agenda + "'";
        this.consultas.ejecutarSQL(this.sql);
        this.consultas.cerrarConexionBd();
        model.removeRow(fila);
    }

    private void desactivarProgramacion(DefaultTableModel model, int fila) {
        int agenda;
        if (model.getValueAt(fila, 6).toString().equals("General")) {
            agenda = 1;
        } else if (model.getValueAt(fila, 6).toString().equals("Especial")) {
            agenda = 2;
        } else {
            agenda = 3;
        }
        if (model.getValueAt(fila, 7).equals("0")) {
            if (model.getValueAt(fila, 6).equals("3")) {
                desactivar(model, fila, agenda);
                return;
            }
            this.sql = "SELECT Id FROM c_citas WHERE (Id_Profesional ='" + this.idProfesional + "' AND Id_Especialidad ='" + this.idEspecialidad + "' AND Fecha_Cita ='" + model.getValueAt(fila, 0) + "' AND HoraInicial >='" + this.metodos.pasarHora12a24(model.getValueAt(fila, 1).toString()).substring(0, 6) + "' AND HoraInicial <='" + this.metodos.pasarHora12a24(model.getValueAt(fila, 2).toString()).substring(0, 6) + "' AND Id_MotivoDesistida =1)";
            String dato = this.consultas.traerDato(this.sql);
            this.consultas.cerrarConexionBd();
            if (dato.isEmpty()) {
                desactivar(model, fila, agenda);
                this.metodos.mostrarMensaje("Programación Desactivada. Ok");
                return;
            } else {
                this.metodos.mostrarMensaje("El Profesional ya Tiene Usuarios Agendados para esa Fecha y el Horario.\nPor consiguiente no se podrá Desactivar la Programación");
                return;
            }
        }
        model.removeRow(fila);
    }

    public void grabar() {
        if (!this.nbreProfesional.equals(this.nodo.getUserObject().toString())) {
            this.metodos.mostrarMensaje("Por favor seleccione un Profesional");
            this.Arbol.requestFocus();
        } else if (this.gridLunes.getRowCount() < 1 && this.gridMartes.getRowCount() < 1 && this.gridMiercoles.getRowCount() < 1 && this.gridJueves.getRowCount() < 1 && this.gridViernes.getRowCount() < 1 && this.gridSabado.getRowCount() < 1 && this.gridDomingo.getRowCount() < 1) {
            this.metodos.mostrarMensaje("Por favor agregue por lo menos un día de programación");
        } else {
            grabarConfiguracion();
        }
    }

    private void grabarConfiguracion() {
        int grabo = 0;
        if (this.gridLunes.getRowCount() > 0) {
            grabo = grabarRegistro(this.gridLunes, 1, 0);
        }
        if (this.gridMartes.getRowCount() > 0) {
            grabo = grabarRegistro(this.gridMartes, 2, grabo);
        }
        if (this.gridMiercoles.getRowCount() > 0) {
            grabo = grabarRegistro(this.gridMiercoles, 3, grabo);
        }
        if (this.gridJueves.getRowCount() > 0) {
            grabo = grabarRegistro(this.gridJueves, 4, grabo);
        }
        if (this.gridViernes.getRowCount() > 0) {
            grabo = grabarRegistro(this.gridViernes, 5, grabo);
        }
        if (this.gridSabado.getRowCount() > 0) {
            grabo = grabarRegistro(this.gridSabado, 6, grabo);
        }
        if (this.gridDomingo.getRowCount() > 0) {
            grabo = grabarRegistro(this.gridDomingo, 7, grabo);
        }
        if (grabo == 0) {
            this.metodos.mostrarMensaje("Por favor digite una Programación para Grabar");
        } else {
            this.metodos.mostrarMensaje("Configuracion Grabada Ok.");
        }
    }

    private int grabarRegistro(JTable grid, int diaSemana, int grabo) {
        int xagenda;
        int xgrabo = grabo;
        for (int fila = 0; fila < grid.getRowCount(); fila++) {
            if (grid.getValueAt(fila, 7).toString().equals("1")) {
                if (grid.getValueAt(fila, 6).toString().equals("General")) {
                    xagenda = 1;
                } else if (grid.getValueAt(fila, 6).toString().equals("Especial")) {
                    xagenda = 2;
                } else {
                    xagenda = 3;
                }
                this.sql = "INSERT INTO c_confcitas (Id_Profesional, Id_Especialidad, Id_Consultorio, TipoAgenda, DiaSemana, Fecha_ConfCitas, HoraInicial, HoraFinal, Cupo, AgendaGralUltConf, EsAdicional, Fecha, UsuarioS) VALUES ('" + this.idProfesional + "','" + this.idEspecialidad + "','" + grid.getValueAt(fila, 3) + "','" + xagenda + "','" + diaSemana + "','" + grid.getValueAt(fila, 0).toString() + "','" + this.metodos.pasarHora12a24(grid.getValueAt(fila, 1).toString()).substring(0, 6) + "','" + this.metodos.pasarHora12a24(grid.getValueAt(fila, 2).toString()).substring(0, 6) + "','" + grid.getValueAt(fila, 5) + "','1','" + this.xesadicional + "','" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                this.consultas.ejecutarSQL(this.sql);
                this.consultas.cerrarConexionBd();
                grid.setValueAt(0, fila, 7);
                xgrabo = 1;
            }
        }
        return xgrabo;
    }

    private int grabarFilaGrid(DefaultTableModel modelo, JTable grid, int fila, int i) {
        String horaIni;
        String horaFin;
        String horaIni2;
        String horaFin2;
        String ag;
        int encontrado = 0;
        if (this.btnListaTurno.isSelected()) {
            horaIni2 = this.metodos.formatoHora12(this.listaTurnos[this.cboTurno.getSelectedIndex()][1].toString());
            horaFin2 = this.metodos.formatoHora12(this.listaTurnos[this.cboTurno.getSelectedIndex()][2].toString());
        } else {
            if (Integer.parseInt(this.txtHoraInicio.getValue().toString()) < 10) {
                horaIni = "0" + this.txtHoraInicio.getValue().toString();
            } else {
                horaIni = this.txtHoraInicio.getValue().toString();
            }
            if (Integer.parseInt(this.txtHoraFinal.getValue().toString()) < 10) {
                horaFin = "0" + this.txtHoraFinal.getValue().toString();
            } else {
                horaFin = this.txtHoraFinal.getValue().toString();
            }
            if ((horaIni.equals("12") && this.txtAMPMInicio.getValue().equals("PM")) || (horaFin.equals("12") && this.txtAMPMFinal.getValue().equals("PM"))) {
                this.metodos.mostrarMensaje("No se permite asignar Programación de Citas a las 12 de la noche\nPor favor revise la configuración.");
                encontrado = 1;
            }
            if (Integer.parseInt(this.txtMinutoInicio.getValue().toString()) < 10) {
                horaIni2 = horaIni + ":0" + this.txtMinutoInicio.getValue().toString() + " " + this.txtAMPMInicio.getValue();
            } else {
                horaIni2 = horaIni + ":" + this.txtMinutoInicio.getValue().toString() + " " + this.txtAMPMInicio.getValue();
            }
            if (Integer.parseInt(this.txtMinutoFinal.getValue().toString()) < 10) {
                horaFin2 = horaFin + ":0" + this.txtMinutoFinal.getValue().toString() + " " + this.txtAMPMFinal.getValue();
            } else {
                horaFin2 = horaFin + ":" + this.txtMinutoFinal.getValue().toString() + " " + this.txtAMPMFinal.getValue();
            }
        }
        for (int f = 0; f < grid.getRowCount(); f++) {
            if (this.tipoAgenda == 1) {
                ag = "General";
            } else if (this.tipoAgenda == 2) {
                ag = "Especial";
            } else {
                ag = "Vacaciones";
            }
            if (grid.getValueAt(f, 0).equals(this.metodos.formatoAMD.format(this.txtFecha.getDate())) && grid.getValueAt(f, 1).equals(horaIni2) && grid.getValueAt(f, 6).equals(ag)) {
                this.metodos.mostrarMensaje("Ya existe una configuración para el Profesional en la Fecha, Horario y Tipo");
                encontrado = 1;
            }
        }
        if (encontrado == 0) {
            int aceptar = 0;
            if (this.tipoAgenda == 1) {
                aceptar = this.metodos.getPregunta("Esta seguro de crear un tipo de Agenda GENERAL?");
            }
            if (aceptar == 0) {
                modelo.addRow(this.filaGrid);
                grid.setValueAt(this.metodos.formatoAMD.format(this.txtFecha.getDate()), fila, 0);
                grid.setValueAt(horaIni2, fila, 1);
                grid.setValueAt(horaFin2, fila, 2);
                grid.setValueAt(this.listaConsultorio[this.cboConsultorio.getSelectedIndex()], fila, 3);
                grid.setValueAt(this.cboConsultorio.getSelectedItem(), fila, 4);
                grid.setValueAt(this.txtCantidad.getValue(), fila, 5);
                if (this.tipoAgenda == 1) {
                    grid.setValueAt("General", fila, 6);
                } else if (this.tipoAgenda == 2) {
                    grid.setValueAt("Especial", fila, 6);
                } else {
                    grid.setValueAt("Vacaciones", fila, 6);
                }
                grid.setValueAt("1", fila, 7);
                modelo.moveRow(fila, fila, 0);
            }
        }
        this.panelSemana.setSelectedIndex(i);
        return encontrado;
    }

    private void llenarCombos() {
        this.listaConsultorio = this.consultas.llenarCombo("SELECT Id, Nbre FROM c_consultorio WHERE Estado = 0 ORDER BY Nbre ASC", this.listaConsultorio, this.cboConsultorio);
        this.listaTurnos = this.consultas.llenarComboyLista("SELECT Id, Nbre, HoraI, HoraF FROM c_turnos WHERE Estado = 0 ORDER BY Nbre ASC", this.listaTurnos, this.cboTurno, 4);
        this.cboConsultorio.setSelectedIndex(-1);
        this.cboTurno.setSelectedIndex(-1);
        this.cboDiaSemana.setSelectedIndex(-1);
        this.consultas.cerrarConexionBd();
        this.cboLleno = 1;
    }

    public void nuevo() {
        this.cboDiaSemana.setSelectedIndex(-1);
        this.cboConsultorio.setSelectedIndex(-1);
        this.cboTurno.setSelectedIndex(-1);
        this.txtHoraInicio.setValue(0);
        this.txtMinutoInicio.setValue(0);
        this.txtHoraFinal.setValue(0);
        this.txtMinutoFinal.setValue(0);
        this.txtCantidad.setValue(0);
        this.xesadicional = 0;
        this.JCHAdicional.setSelected(false);
        crearGrid();
    }

    private void seleccionarArbol() {
        mSeleccion_Arbol();
    }

    private void mSeleccion_Arbol() {
        this.nodo = (DefaultMutableTreeNode) this.Arbol.getLastSelectedPathComponent();
        if (this.nodo.isLeaf()) {
            this.nbreProfesional = (String) this.nodo.getUserObject();
            String nbreEspecial = this.nodo.getParent().toString();
            if (this.Arbol.getLastSelectedPathComponent() != null) {
                for (int i = 1; i < this.listaProfesional.length; i++) {
                    if (this.listaProfesional[i][1].equals(this.nbreProfesional) && this.listaProfesional[i][3].equals(nbreEspecial)) {
                        this.idProfesional = this.listaProfesional[i][0];
                        this.idEspecialidad = this.listaProfesional[i][2];
                        cargarProgramacion();
                        return;
                    }
                }
            }
        }
    }

    private String tipoAgenda(String op) {
        String dato = "";
        if (Integer.parseInt(op) == 1) {
            dato = "General";
        } else if (Integer.parseInt(op) == 2) {
            dato = "Especial";
        } else if (Integer.parseInt(op) == 3) {
            dato = "Vacaciones";
        }
        return dato;
    }

    private int validarDatos() {
        int retorno = 0;
        if (this.tipoAgenda == 1 && this.cboDiaSemana.getSelectedIndex() < 0) {
            this.metodos.mostrarMensaje("Por favor seleccione un Dia de la Semana.");
            this.cboDiaSemana.requestFocus();
        } else if (this.Arbol.isSelectionEmpty() || this.nodo.getLevel() < 2) {
            this.metodos.mostrarMensaje("Por favor seleccione un Profesional");
            this.Arbol.requestFocus();
        } else if (this.cboConsultorio.getSelectedIndex() < 0) {
            this.metodos.mostrarMensaje("Por favor seleccione un Consultorio.");
            this.cboConsultorio.requestFocus();
        } else if (Integer.valueOf(this.txtCantidad.getValue().toString()).intValue() <= 0) {
            this.metodos.mostrarMensaje("Debe digiar el cupo de asignación  de citas para esta agenda");
            this.txtCantidad.requestFocus();
        } else if (this.btnListaTurno.isSelected()) {
            if (this.cboTurno.getSelectedIndex() < 0) {
                this.metodos.mostrarMensaje("Por favor seleccione el Horario en el cual Laborará");
                this.cboTurno.requestFocus();
            } else {
                retorno = 1;
            }
        } else if (this.btnNuevoTurno.isSelected()) {
            if (Integer.parseInt(this.txtHoraInicio.getValue().toString()) < 1) {
                this.metodos.mostrarMensaje("Por favor revise el Horario de Inicio que no empiece en 0 Horas");
                this.txtHoraInicio.requestFocus();
            } else if (Integer.parseInt(this.txtHoraFinal.getValue().toString()) < 1) {
                this.metodos.mostrarMensaje("Por favor revise el Horario Final que no empiece en 0 Horas");
                this.txtHoraFinal.requestFocus();
            } else if (Integer.parseInt(this.txtHoraInicio.getValue().toString()) == Integer.parseInt(this.txtHoraFinal.getValue().toString()) && Integer.parseInt(this.txtMinutoInicio.getValue().toString()) == Integer.parseInt(this.txtMinutoFinal.getValue().toString()) && this.txtAMPMInicio.getValue().toString().equals(this.txtAMPMFinal.getValue().toString())) {
                this.metodos.mostrarMensaje("Por favor revise los Horarios que Empiezan y terminan iguales");
                this.txtHoraFinal.requestFocus();
            } else if (this.txtAMPMInicio.getValue().toString().equals("AM") && this.txtAMPMFinal.getValue().toString().equals("AM")) {
                if (Integer.parseInt(this.txtHoraInicio.getValue().toString()) > Integer.parseInt(this.txtHoraFinal.getValue().toString())) {
                    this.metodos.mostrarMensaje("La Hora de Inicio no puede ser superior a la Final.");
                    this.txtHoraInicio.requestFocus();
                } else {
                    retorno = 1;
                }
            } else if (this.txtAMPMInicio.getValue().toString().equals("PM") && this.txtAMPMFinal.getValue().toString().equals("PM")) {
                if (Integer.parseInt(this.txtHoraInicio.getValue().toString()) > Integer.parseInt(this.txtHoraFinal.getValue().toString())) {
                    this.metodos.mostrarMensaje("La Hora de Inicio no puede ser superior a la Final.");
                    this.txtHoraInicio.requestFocus();
                } else {
                    retorno = 1;
                }
            } else if (Integer.parseInt(this.txtHoraInicio.getValue().toString()) < 1) {
                this.metodos.mostrarMensaje("Por favor revise el Horario de Inicio que no empiece en 0 Horas");
                this.txtHoraInicio.requestFocus();
            } else if (Integer.parseInt(this.txtHoraFinal.getValue().toString()) < 1) {
                this.metodos.mostrarMensaje("Por favor revise el Horario Final que no empiece en 0 Horas");
                this.txtHoraFinal.requestFocus();
            } else {
                retorno = 1;
            }
        } else if (mValidarFecha(this.metodos.formatoAMD.format(this.txtFecha.getDate()))) {
            int j = JOptionPane.showInternalConfirmDialog(this, "Esta Seguro de Configurar Agenda en un día Festivo?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            retorno = j == 0 ? 1 : 0;
        } else {
            retorno = 1;
        }
        return retorno;
    }

    private boolean mValidarFecha(String Fecha) {
        boolean sw;
        String sql = "SELECT FechaFestivo FROM g_diafestivo Where Estado=1 and FechaFestivo=('" + Fecha + "')";
        String dato = this.consultas.traerDato(sql);
        if (dato.equals("")) {
            sw = false;
        } else {
            sw = true;
        }
        return sw;
    }

    /* JADX WARN: Type inference failed for: r3v108, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v114, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v124, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v134, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v144, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v154, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v164, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.buttonGroup1 = new ButtonGroup();
        this.buttonGroup2 = new ButtonGroup();
        this.jPanel2 = new JPanel();
        this.jToolBar1 = new JToolBar();
        this.btnGeneral = new JRadioButton();
        this.btnEspecial = new JRadioButton();
        this.btnVacaciones = new JRadioButton();
        this.txtFecha = new JCalendar();
        this.jLabel1 = new JLabel();
        this.jPanel12 = new JPanel();
        this.cboConsultorio = new JComboBox();
        this.jPanel10 = new JPanel();
        this.jLabel5 = new JLabel();
        this.txtHoraInicio = new JSpinner();
        this.txtAMPMInicio = new JSpinner();
        this.jLabel10 = new JLabel();
        this.txtMinutoInicio = new JSpinner();
        this.jPanel11 = new JPanel();
        this.jLabel7 = new JLabel();
        this.jLabel11 = new JLabel();
        this.txtAMPMFinal = new JSpinner();
        this.txtMinutoFinal = new JSpinner();
        this.txtHoraFinal = new JSpinner();
        this.cboTurno = new JComboBox();
        this.cboDiaSemana = new JComboBox();
        this.txtCantidad = new JSpinner();
        this.JCHAdicional = new JCheckBox();
        this.jButton1 = new JButton();
        this.jPanel3 = new JPanel();
        this.btnListaTurno = new JCheckBox();
        this.btnNuevoTurno = new JCheckBox();
        this.panelSemana = new JTabbedPane();
        this.jScrollPane2 = new JScrollPane();
        this.gridLunes = new JTable();
        this.jPanel4 = new JPanel();
        this.jScrollPane3 = new JScrollPane();
        this.gridMartes = new JTable();
        this.jPanel5 = new JPanel();
        this.jScrollPane4 = new JScrollPane();
        this.gridMiercoles = new JTable();
        this.jPanel6 = new JPanel();
        this.jScrollPane5 = new JScrollPane();
        this.gridJueves = new JTable();
        this.jPanel7 = new JPanel();
        this.jScrollPane6 = new JScrollPane();
        this.gridViernes = new JTable();
        this.jPanel8 = new JPanel();
        this.jScrollPane7 = new JScrollPane();
        this.gridSabado = new JTable();
        this.jPanel9 = new JPanel();
        this.jScrollPane8 = new JScrollPane();
        this.gridDomingo = new JTable();
        this.jScrollPane1 = new JScrollPane();
        this.Arbol = new JTree();
        this.JCH_Filtro = new JCheckBox();
        setClosable(true);
        setIconifiable(true);
        setTitle("CONFIGURACION GENERAL DE CITAS");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMinimumSize(null);
        setName("Programar");
        addInternalFrameListener(new InternalFrameListener() { // from class: Citas.Programar.15
            public void internalFrameActivated(InternalFrameEvent evt) {
                Programar.this.formInternalFrameActivated(evt);
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
        this.jPanel2.setBorder(BorderFactory.createEtchedBorder());
        this.jPanel2.setLayout((LayoutManager) null);
        this.jToolBar1.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de Configuración", 0, 0, new Font("Arial", 1, 12), new Color(153, 0, 0)));
        this.jToolBar1.setRollover(true);
        this.buttonGroup2.add(this.btnGeneral);
        this.btnGeneral.setFont(new Font("Arial", 1, 12));
        this.btnGeneral.setForeground(new Color(0, 0, 153));
        this.btnGeneral.setText("General");
        this.btnGeneral.addActionListener(new ActionListener() { // from class: Citas.Programar.16
            public void actionPerformed(ActionEvent evt) {
                Programar.this.btnGeneralActionPerformed(evt);
            }
        });
        this.jToolBar1.add(this.btnGeneral);
        this.buttonGroup2.add(this.btnEspecial);
        this.btnEspecial.setFont(new Font("Arial", 1, 12));
        this.btnEspecial.setForeground(new Color(0, 0, 153));
        this.btnEspecial.setSelected(true);
        this.btnEspecial.setText("Especial");
        this.btnEspecial.addActionListener(new ActionListener() { // from class: Citas.Programar.17
            public void actionPerformed(ActionEvent evt) {
                Programar.this.btnEspecialActionPerformed(evt);
            }
        });
        this.jToolBar1.add(this.btnEspecial);
        this.buttonGroup2.add(this.btnVacaciones);
        this.btnVacaciones.setFont(new Font("Arial", 1, 12));
        this.btnVacaciones.setForeground(new Color(0, 0, 153));
        this.btnVacaciones.setText("Vacaciones");
        this.btnVacaciones.setMaximumSize(new Dimension(90, 23));
        this.btnVacaciones.setMinimumSize(new Dimension(83, 23));
        this.btnVacaciones.setPreferredSize(new Dimension(90, 23));
        this.btnVacaciones.addActionListener(new ActionListener() { // from class: Citas.Programar.18
            public void actionPerformed(ActionEvent evt) {
                Programar.this.btnVacacionesActionPerformed(evt);
            }
        });
        this.jToolBar1.add(this.btnVacaciones);
        this.jPanel2.add(this.jToolBar1);
        this.jToolBar1.setBounds(10, 10, 290, 69);
        this.txtFecha.setBackground(new Color(204, 255, 255));
        this.txtFecha.setBorder(BorderFactory.createEtchedBorder());
        this.txtFecha.setForeground(new Color(0, 0, 102));
        this.txtFecha.setDate(this.metodos.getFechaActual());
        this.txtFecha.setFont(new Font("Arial", 1, 12));
        this.txtFecha.setMaxSelectableDate(new Date(253370786486000L));
        this.txtFecha.setName("Calendario");
        this.txtFecha.setWeekOfYearVisible(false);
        this.txtFecha.addHierarchyListener(new HierarchyListener() { // from class: Citas.Programar.19
            public void hierarchyChanged(HierarchyEvent evt) {
                Programar.this.txtFechaHierarchyChanged(evt);
            }
        });
        this.txtFecha.addMouseListener(new MouseAdapter() { // from class: Citas.Programar.20
            public void mouseClicked(MouseEvent evt) {
                Programar.this.txtFechaMouseClicked(evt);
            }
        });
        this.txtFecha.addInputMethodListener(new InputMethodListener() { // from class: Citas.Programar.21
            public void caretPositionChanged(InputMethodEvent evt) {
                Programar.this.txtFechaCaretPositionChanged(evt);
            }

            public void inputMethodTextChanged(InputMethodEvent evt) {
            }
        });
        this.txtFecha.addPropertyChangeListener(new PropertyChangeListener() { // from class: Citas.Programar.22
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                Programar.this.txtFechaPropertyChange(evt);
            }
        });
        this.jPanel2.add(this.txtFecha);
        this.txtFecha.setBounds(500, 60, 370, 320);
        this.jLabel1.setBackground(new Color(0, 0, 153));
        this.jLabel1.setFont(new Font("Arial", 1, 14));
        this.jLabel1.setForeground(new Color(204, 255, 204));
        this.jLabel1.setHorizontalAlignment(0);
        this.jLabel1.setText("CALENDARIO");
        this.jLabel1.setMaximumSize(new Dimension(79, 15));
        this.jLabel1.setMinimumSize(new Dimension(79, 15));
        this.jLabel1.setOpaque(true);
        this.jLabel1.setPreferredSize(new Dimension(79, 15));
        this.jPanel2.add(this.jLabel1);
        this.jLabel1.setBounds(500, 20, 370, 40);
        this.jPanel12.setBorder(BorderFactory.createEtchedBorder());
        this.jPanel12.setLayout((LayoutManager) null);
        this.cboConsultorio.setFont(new Font("Arial", 1, 12));
        this.cboConsultorio.setBorder(BorderFactory.createTitledBorder((Border) null, "Consultorio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jPanel12.add(this.cboConsultorio);
        this.cboConsultorio.setBounds(10, 70, 270, 50);
        this.jPanel10.setBorder(BorderFactory.createTitledBorder((Border) null, "Horario de Inicio", 0, 0, new Font("Arial", 1, 12), new Color(153, 0, 51)));
        this.jPanel10.setLayout((LayoutManager) null);
        this.jLabel5.setFont(new Font("Arial", 1, 12));
        this.jLabel5.setForeground(new Color(0, 0, 153));
        this.jLabel5.setText("Hora");
        this.jPanel10.add(this.jLabel5);
        this.jLabel5.setBounds(10, 20, 30, 15);
        this.txtHoraInicio.setFont(new Font("Arial", 1, 12));
        this.txtHoraInicio.setModel(new SpinnerNumberModel(0, 0, 12, 1));
        this.txtHoraInicio.setEnabled(false);
        this.jPanel10.add(this.txtHoraInicio);
        this.txtHoraInicio.setBounds(10, 40, 50, 30);
        this.txtAMPMInicio.setFont(new Font("Arial", 1, 12));
        this.txtAMPMInicio.setModel(new SpinnerListModel(new String[]{"AM", "PM"}));
        this.txtAMPMInicio.setEnabled(false);
        this.jPanel10.add(this.txtAMPMInicio);
        this.txtAMPMInicio.setBounds(110, 40, 50, 30);
        this.jLabel10.setFont(new Font("Arial", 1, 12));
        this.jLabel10.setForeground(new Color(0, 0, 153));
        this.jLabel10.setText("Minutos");
        this.jPanel10.add(this.jLabel10);
        this.jLabel10.setBounds(60, 20, 60, 15);
        this.txtMinutoInicio.setFont(new Font("Arial", 1, 12));
        this.txtMinutoInicio.setModel(new SpinnerNumberModel(0, 0, 55, 5));
        this.txtMinutoInicio.setEnabled(false);
        this.jPanel10.add(this.txtMinutoInicio);
        this.txtMinutoInicio.setBounds(60, 40, 50, 30);
        this.jPanel12.add(this.jPanel10);
        this.jPanel10.setBounds(290, 30, 180, 90);
        this.jPanel11.setBorder(BorderFactory.createTitledBorder((Border) null, "Horario Final", 0, 0, new Font("Arial", 1, 12), new Color(153, 0, 0)));
        this.jPanel11.setLayout((LayoutManager) null);
        this.jLabel7.setFont(new Font("Arial", 1, 12));
        this.jLabel7.setForeground(new Color(0, 0, 153));
        this.jLabel7.setText("Hora");
        this.jPanel11.add(this.jLabel7);
        this.jLabel7.setBounds(10, 20, 30, 15);
        this.jLabel11.setFont(new Font("Arial", 1, 12));
        this.jLabel11.setForeground(new Color(0, 0, 153));
        this.jLabel11.setText("Minutos");
        this.jPanel11.add(this.jLabel11);
        this.jLabel11.setBounds(80, 20, 60, 15);
        this.txtAMPMFinal.setFont(new Font("Arial", 1, 12));
        this.txtAMPMFinal.setModel(new SpinnerListModel(new String[]{"AM", "PM"}));
        this.txtAMPMFinal.setEnabled(false);
        this.jPanel11.add(this.txtAMPMFinal);
        this.txtAMPMFinal.setBounds(110, 40, 50, 30);
        this.txtMinutoFinal.setFont(new Font("Arial", 1, 12));
        this.txtMinutoFinal.setModel(new SpinnerNumberModel(0, 0, 55, 5));
        this.txtMinutoFinal.setEnabled(false);
        this.jPanel11.add(this.txtMinutoFinal);
        this.txtMinutoFinal.setBounds(60, 40, 50, 30);
        this.txtHoraFinal.setFont(new Font("Arial", 1, 12));
        this.txtHoraFinal.setModel(new SpinnerNumberModel(0, 0, 12, 1));
        this.txtHoraFinal.setEnabled(false);
        this.jPanel11.add(this.txtHoraFinal);
        this.txtHoraFinal.setBounds(10, 40, 50, 30);
        this.jPanel12.add(this.jPanel11);
        this.jPanel11.setBounds(290, 140, 180, 90);
        this.cboTurno.setFont(new Font("Arial", 1, 12));
        this.cboTurno.setBorder(BorderFactory.createTitledBorder((Border) null, "Turno", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jPanel12.add(this.cboTurno);
        this.cboTurno.setBounds(10, 130, 270, 50);
        this.cboDiaSemana.setFont(new Font("Arial", 1, 12));
        this.cboDiaSemana.setModel(new DefaultComboBoxModel(new String[]{"Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sábado", "Domingo"}));
        this.cboDiaSemana.setBorder(BorderFactory.createTitledBorder((Border) null, "Dias de la Semana", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.cboDiaSemana.setName("cboDiaSemana");
        this.cboDiaSemana.addItemListener(new ItemListener() { // from class: Citas.Programar.23
            public void itemStateChanged(ItemEvent evt) {
                Programar.this.cboDiaSemanaItemStateChanged(evt);
            }
        });
        this.jPanel12.add(this.cboDiaSemana);
        this.cboDiaSemana.setBounds(10, 12, 270, 43);
        this.txtCantidad.setFont(new Font("Arial", 1, 12));
        this.txtCantidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Cupos", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jPanel12.add(this.txtCantidad);
        this.txtCantidad.setBounds(10, 190, 80, 40);
        this.JCHAdicional.setFont(new Font("Arial", 1, 12));
        this.JCHAdicional.setForeground(Color.red);
        this.JCHAdicional.setText("Es Adicional?");
        this.JCHAdicional.addActionListener(new ActionListener() { // from class: Citas.Programar.24
            public void actionPerformed(ActionEvent evt) {
                Programar.this.JCHAdicionalActionPerformed(evt);
            }
        });
        this.jPanel12.add(this.JCHAdicional);
        this.JCHAdicional.setBounds(100, 210, 120, 23);
        this.jPanel2.add(this.jPanel12);
        this.jPanel12.setBounds(10, 80, 480, 240);
        this.jButton1.setFont(new Font("Arial", 1, 12));
        this.jButton1.setForeground(new Color(0, 102, 102));
        this.jButton1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.jButton1.setText("Cargar Programación");
        this.jButton1.addActionListener(new ActionListener() { // from class: Citas.Programar.25
            public void actionPerformed(ActionEvent evt) {
                Programar.this.jButton1ActionPerformed(evt);
            }
        });
        this.jPanel2.add(this.jButton1);
        this.jButton1.setBounds(10, 330, 480, 50);
        this.jPanel3.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de Turno", 0, 0, new Font("Arial", 1, 12), new Color(102, 0, 51)));
        this.jPanel3.setLayout((LayoutManager) null);
        this.buttonGroup1.add(this.btnListaTurno);
        this.btnListaTurno.setFont(new Font("Arial", 1, 12));
        this.btnListaTurno.setSelected(true);
        this.btnListaTurno.setText("Lista de Turnos");
        this.btnListaTurno.addActionListener(new ActionListener() { // from class: Citas.Programar.26
            public void actionPerformed(ActionEvent evt) {
                Programar.this.btnListaTurnoActionPerformed(evt);
            }
        });
        this.jPanel3.add(this.btnListaTurno);
        this.btnListaTurno.setBounds(10, 20, 120, 23);
        this.buttonGroup1.add(this.btnNuevoTurno);
        this.btnNuevoTurno.setFont(new Font("Arial", 1, 12));
        this.btnNuevoTurno.setText("Nuevo Turno");
        this.btnNuevoTurno.addActionListener(new ActionListener() { // from class: Citas.Programar.27
            public void actionPerformed(ActionEvent evt) {
                Programar.this.btnNuevoTurnoActionPerformed(evt);
            }
        });
        this.jPanel3.add(this.btnNuevoTurno);
        this.btnNuevoTurno.setBounds(10, 40, 110, 23);
        this.jPanel2.add(this.jPanel3);
        this.jPanel3.setBounds(310, 10, 180, 70);
        this.panelSemana.setForeground(new Color(0, 102, 102));
        this.panelSemana.setAutoscrolls(true);
        this.panelSemana.setFont(new Font("Arial", 1, 14));
        this.gridLunes.setFont(new Font("Arial", 1, 12));
        this.gridLunes.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.gridLunes.setRowHeight(25);
        this.gridLunes.setSelectionBackground(new Color(255, 255, 255));
        this.gridLunes.setSelectionForeground(new Color(255, 0, 0));
        this.gridLunes.setSelectionMode(0);
        this.gridLunes.addKeyListener(new KeyAdapter() { // from class: Citas.Programar.28
            public void keyPressed(KeyEvent evt) {
                Programar.this.gridLunesKeyPressed(evt);
            }

            public void keyReleased(KeyEvent evt) {
                Programar.this.gridLunesKeyReleased(evt);
            }
        });
        this.jScrollPane2.setViewportView(this.gridLunes);
        this.panelSemana.addTab("Lunes", this.jScrollPane2);
        this.gridMartes.setFont(new Font("Arial", 1, 12));
        this.gridMartes.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.gridMartes.setRowHeight(25);
        this.gridMartes.setSelectionBackground(new Color(255, 255, 255));
        this.gridMartes.setSelectionForeground(Color.red);
        this.gridMartes.setSelectionMode(0);
        this.gridMartes.addKeyListener(new KeyAdapter() { // from class: Citas.Programar.29
            public void keyPressed(KeyEvent evt) {
                Programar.this.gridMartesKeyPressed(evt);
            }
        });
        this.jScrollPane3.setViewportView(this.gridMartes);
        GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
        this.jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addComponent(this.jScrollPane3, -1, 858, 32767).addContainerGap()));
        jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addComponent(this.jScrollPane3, -2, 235, -2).addContainerGap(-1, 32767)));
        this.panelSemana.addTab("Martes", this.jPanel4);
        this.gridMiercoles.setFont(new Font("Arial", 1, 12));
        this.gridMiercoles.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.gridMiercoles.setRowHeight(25);
        this.gridMiercoles.setSelectionBackground(new Color(255, 255, 255));
        this.gridMiercoles.setSelectionForeground(new Color(255, 0, 0));
        this.gridMiercoles.setSelectionMode(0);
        this.gridMiercoles.addKeyListener(new KeyAdapter() { // from class: Citas.Programar.30
            public void keyPressed(KeyEvent evt) {
                Programar.this.gridMiercolesKeyPressed(evt);
            }
        });
        this.jScrollPane4.setViewportView(this.gridMiercoles);
        GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
        this.jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane4, -1, 868, 32767));
        jPanel5Layout.setVerticalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addComponent(this.jScrollPane4, -2, 234, -2).addContainerGap(-1, 32767)));
        this.panelSemana.addTab("Miercoles", this.jPanel5);
        this.gridJueves.setFont(new Font("Arial", 1, 12));
        this.gridJueves.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.gridJueves.setRowHeight(25);
        this.gridJueves.setSelectionBackground(new Color(255, 255, 255));
        this.gridJueves.setSelectionForeground(new Color(255, 0, 0));
        this.gridJueves.setSelectionMode(0);
        this.gridJueves.addKeyListener(new KeyAdapter() { // from class: Citas.Programar.31
            public void keyPressed(KeyEvent evt) {
                Programar.this.gridJuevesKeyPressed(evt);
            }
        });
        this.jScrollPane5.setViewportView(this.gridJueves);
        GroupLayout jPanel6Layout = new GroupLayout(this.jPanel6);
        this.jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane5, -1, 868, 32767));
        jPanel6Layout.setVerticalGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel6Layout.createSequentialGroup().addComponent(this.jScrollPane5, -2, 239, -2).addContainerGap(-1, 32767)));
        this.panelSemana.addTab("Jueves", this.jPanel6);
        this.gridViernes.setFont(new Font("Arial", 1, 12));
        this.gridViernes.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.gridViernes.setRowHeight(25);
        this.gridViernes.setSelectionBackground(new Color(255, 255, 255));
        this.gridViernes.setSelectionForeground(new Color(255, 0, 0));
        this.gridViernes.setSelectionMode(0);
        this.gridViernes.addKeyListener(new KeyAdapter() { // from class: Citas.Programar.32
            public void keyPressed(KeyEvent evt) {
                Programar.this.gridViernesKeyPressed(evt);
            }
        });
        this.jScrollPane6.setViewportView(this.gridViernes);
        GroupLayout jPanel7Layout = new GroupLayout(this.jPanel7);
        this.jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane6, -1, 868, 32767));
        jPanel7Layout.setVerticalGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel7Layout.createSequentialGroup().addComponent(this.jScrollPane6, -2, 236, -2).addContainerGap(-1, 32767)));
        this.panelSemana.addTab("Viernes", this.jPanel7);
        this.gridSabado.setFont(new Font("Arial", 1, 12));
        this.gridSabado.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.gridSabado.setRowHeight(25);
        this.gridSabado.setSelectionBackground(new Color(255, 255, 255));
        this.gridSabado.setSelectionForeground(new Color(255, 0, 0));
        this.gridSabado.setSelectionMode(0);
        this.gridSabado.addKeyListener(new KeyAdapter() { // from class: Citas.Programar.33
            public void keyPressed(KeyEvent evt) {
                Programar.this.gridSabadoKeyPressed(evt);
            }
        });
        this.jScrollPane7.setViewportView(this.gridSabado);
        GroupLayout jPanel8Layout = new GroupLayout(this.jPanel8);
        this.jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane7, -1, 868, 32767));
        jPanel8Layout.setVerticalGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel8Layout.createSequentialGroup().addComponent(this.jScrollPane7, -2, 239, -2).addContainerGap(-1, 32767)));
        this.panelSemana.addTab("Sábado", this.jPanel8);
        this.gridDomingo.setFont(new Font("Arial", 1, 12));
        this.gridDomingo.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.gridDomingo.setRowHeight(25);
        this.gridDomingo.setSelectionBackground(new Color(255, 255, 255));
        this.gridDomingo.setSelectionForeground(new Color(255, 0, 0));
        this.gridDomingo.setSelectionMode(0);
        this.gridDomingo.addKeyListener(new KeyAdapter() { // from class: Citas.Programar.34
            public void keyPressed(KeyEvent evt) {
                Programar.this.gridDomingoKeyPressed(evt);
            }
        });
        this.jScrollPane8.setViewportView(this.gridDomingo);
        GroupLayout jPanel9Layout = new GroupLayout(this.jPanel9);
        this.jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane8, -1, 868, 32767));
        jPanel9Layout.setVerticalGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel9Layout.createSequentialGroup().addComponent(this.jScrollPane8, -2, 238, -2).addContainerGap(-1, 32767)));
        this.panelSemana.addTab("Domingo", this.jPanel9);
        this.Arbol.setFont(new Font("Arial", 1, 12));
        this.Arbol.addTreeSelectionListener(new TreeSelectionListener() { // from class: Citas.Programar.35
            public void valueChanged(TreeSelectionEvent evt) {
                Programar.this.ArbolValueChanged(evt);
            }
        });
        this.jScrollPane1.setViewportView(this.Arbol);
        this.JCH_Filtro.setFont(new Font("Arial", 1, 12));
        this.JCH_Filtro.setForeground(Color.red);
        this.JCH_Filtro.setSelected(true);
        this.JCH_Filtro.setText("Mostrar Todo?");
        this.JCH_Filtro.addActionListener(new ActionListener() { // from class: Citas.Programar.36
            public void actionPerformed(ActionEvent evt) {
                Programar.this.JCH_FiltroActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane1, -2, 286, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JCH_Filtro).addGap(0, 0, 32767)).addComponent(this.jPanel2, -1, -1, 32767).addComponent(this.panelSemana)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(layout.createSequentialGroup().addComponent(this.jPanel2, -2, 409, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.panelSemana, -2, 270, -2)).addComponent(this.jScrollPane1, -2, 690, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCH_Filtro).addContainerGap(-1, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnGeneralActionPerformed(ActionEvent evt) {
        this.tipoAgenda = 1;
        this.cboDiaSemana.setEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnEspecialActionPerformed(ActionEvent evt) {
        this.tipoAgenda = 2;
        this.cboDiaSemana.setEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnVacacionesActionPerformed(ActionEvent evt) {
        this.tipoAgenda = 3;
        this.cboDiaSemana.setEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtFechaPropertyChange(PropertyChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboDiaSemanaItemStateChanged(ItemEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jButton1ActionPerformed(ActionEvent evt) {
        agregarFilaGrid();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnListaTurnoActionPerformed(ActionEvent evt) {
        this.cboTurno.setEnabled(true);
        this.txtHoraInicio.setEnabled(false);
        this.txtMinutoInicio.setEnabled(false);
        this.txtAMPMInicio.setEnabled(false);
        this.txtHoraFinal.setEnabled(false);
        this.txtMinutoFinal.setEnabled(false);
        this.txtAMPMFinal.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnNuevoTurnoActionPerformed(ActionEvent evt) {
        this.cboTurno.setEnabled(false);
        this.txtHoraInicio.setEnabled(true);
        this.txtMinutoInicio.setEnabled(true);
        this.txtAMPMInicio.setEnabled(true);
        this.txtHoraFinal.setEnabled(true);
        this.txtMinutoFinal.setEnabled(true);
        this.txtAMPMFinal.setEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gridLunesKeyPressed(KeyEvent evt) {
        desistir(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gridLunesKeyReleased(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gridMartesKeyPressed(KeyEvent evt) {
        desistir(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gridMiercolesKeyPressed(KeyEvent evt) {
        desistir(3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gridJuevesKeyPressed(KeyEvent evt) {
        desistir(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gridViernesKeyPressed(KeyEvent evt) {
        desistir(5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gridSabadoKeyPressed(KeyEvent evt) {
        desistir(6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gridDomingoKeyPressed(KeyEvent evt) {
        desistir(7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ArbolValueChanged(TreeSelectionEvent evt) {
        seleccionarArbol();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtFechaMouseClicked(MouseEvent evt) {
        this.fechaCal.setGregorianChange(this.txtFecha.getDate());
        this.cboDiaSemana.setSelectedIndex(this.fechaCal.get(7) - 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtFechaHierarchyChanged(HierarchyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtFechaCaretPositionChanged(InputMethodEvent evt) {
        this.fechaCal.setGregorianChange(this.txtFecha.getDate());
        this.cboDiaSemana.setSelectedIndex(this.fechaCal.get(7) - 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameActivated(InternalFrameEvent evt) {
        this.clasCita.frmPrincipal.mActivarBarraMenu(this.clasCita.frmPrincipal.xMenus.barraMnuCita, 5);
        this.metodos.limpiarDatosPrincipal();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHAdicionalActionPerformed(ActionEvent evt) {
        if (this.JCHAdicional.isSelected()) {
            this.xesadicional = 1;
        } else {
            this.xesadicional = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_FiltroActionPerformed(ActionEvent evt) {
        if (this.JCH_Filtro.isSelected()) {
            this.JCH_Filtro.setText("Mostrar todo?");
            mSeleccion_Arbol();
        } else {
            this.JCH_Filtro.setText("Filtro por mes?");
            mSeleccion_Arbol();
        }
    }
}
