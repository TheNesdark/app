package Citas;

import Acceso.Principal;
import Presupuesto.JIFFMovimiento;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JCalendar;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DateFormatter;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;

/* JADX INFO: loaded from: GenomaP.jar:Citas/Programar_Citas.class */
public class Programar_Citas extends JInternalFrame {
    private String[] listaConsultorio;
    private String[] xIdSede;
    private String[][] listaProfesional;
    private String[][] listaTurnos;
    private String sql;
    private String nbreProfesional;
    private String idProfesional;
    private String especialAnterior;
    private Object[] filaGrid;
    private ResultSet rs;
    private DefaultTableModel modeloGridProg;
    private clasesCita clasCita;
    private JTree Arbol;
    private JComboBox JCB_Sede;
    private JCheckBox JCHAdicional;
    private JCheckBox JCH_Filtro;
    private JRadioButton btnEspecial;
    private JCheckBox btnListaTurno;
    private JCheckBox btnNuevoTurno;
    private JRadioButton btnVaciones;
    private ButtonGroup buttonGroup1;
    private ButtonGroup buttonGroup2;
    private JComboBox cboConsultorio;
    private JComboBox cboTurno;
    private JTable gridProgramacion;
    private JButton jButton1;
    private JLabel jLabel1;
    private JPanel jPanel1;
    private JPanel jPanel12;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JRadioButton jRadioButton1;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    public JTabbedPane panelSemana;
    private JSpinner txtCantidad;
    private JCalendar txtFecha;
    private JFormattedTextField txtHoraFinal;
    private JFormattedTextField txtHoraInicio;
    private Metodos metodos = new Metodos();
    private ConsultasMySQL consultas = new ConsultasMySQL();
    private String idEspecialidad = "";
    private int filProg = 0;
    private int filaBorrado = 0;
    private int xesadicional = 0;
    private int tipoAgenda = 2;
    private int cboLleno = 0;
    private DefaultMutableTreeNode tallo = new DefaultMutableTreeNode("Especialidades");
    private DefaultMutableTreeNode rama = new DefaultMutableTreeNode("PROFESIONALES");
    private DefaultMutableTreeNode hoja = new DefaultMutableTreeNode("MEDICOS");
    private DefaultTreeModel modeloArbol = new DefaultTreeModel(this.tallo);
    private DefaultMutableTreeNode nodo = new DefaultMutableTreeNode();
    private GregorianCalendar fechaCal = new GregorianCalendar();
    private ImageIcon rootIcon = new ImageIcon(getClass().getResource("/Imagenes/AgendaMedica.png"));
    private ImageIcon especialidadIcon = new ImageIcon(getClass().getResource("/Imagenes/Especialidad_16.png"));
    private ImageIcon medicoIcon = new ImageIcon(getClass().getResource("/Imagenes/Profesiona_16x20.png"));
    SimpleDateFormat format = new SimpleDateFormat("HH:mm");

    public Programar_Citas(clasesCita clase) {
        initComponents();
        this.Arbol.setCellRenderer(new MyTreeCellRenderer());
        this.clasCita = clase;
        nuevo();
        this.gridProgramacion.addMouseListener(new MouseAdapter() { // from class: Citas.Programar_Citas.1
            public void mouseClicked(MouseEvent e) {
                Programar_Citas.this.filaBorrado = Programar_Citas.this.gridProgramacion.rowAtPoint(e.getPoint());
            }
        });
    }

    private void agregarFilaGrid() {
        if (validarDatos() == 1 && grabarFilaGrid(this.modeloGridProg, this.gridProgramacion, this.filProg, 0) == 0) {
            this.filProg++;
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
            this.sql = "SELECT  date_format(c_confcitas.Fecha_ConfCitas,'%Y/%m/%d'), date_format(c_confcitas.HoraInicial,'%H:%i'), date_format(c_confcitas.HoraFinal,'%H:%i'), c_confcitas.Id_Consultorio, c_consultorio.Nbre, c_confcitas.Cupo, c_confcitas.TipoAgenda, c_confcitas.DiaSemana,  IF(c_confcitas.TipoAgenda=1, 'General', IF(c_confcitas.TipoAgenda=2, 'Especial', 'Vacaciones')) Tipo, g_sedes.`Nbre` AS Sede, c_confcitas.Fecha fechaRegistro, c_confcitas.UsuarioS usuarioRegitro  FROM baseserver.c_confcitas INNER JOIN baseserver.c_consultorio ON (c_confcitas.Id_Consultorio = c_consultorio.Id) INNER JOIN`g_sedes` ON (`g_sedes`.`Id`=`c_confcitas`.`IdSede`) WHERE (c_confcitas.Id_Profesional ='" + this.idProfesional + "' AND c_confcitas.Id_Especialidad ='" + this.idEspecialidad + "' AND c_confcitas.Estado = 0) ORDER BY c_confcitas.Fecha_ConfCitas DESC,c_confcitas.HoraInicial";
        } else {
            this.sql = "SELECT  date_format(c_confcitas.Fecha_ConfCitas,'%Y/%m/%d'), date_format(c_confcitas.HoraInicial,'%H:%i'), date_format(c_confcitas.HoraFinal,'%H:%i'), c_confcitas.Id_Consultorio, c_consultorio.Nbre, c_confcitas.Cupo, c_confcitas.TipoAgenda, c_confcitas.DiaSemana, IF(c_confcitas.TipoAgenda=1, 'General', IF(c_confcitas.TipoAgenda=2, 'Especial', 'Vacaciones')) Tipo, g_sedes.`Nbre` AS Sede, c_confcitas.Fecha fechaRegistro, c_confcitas.UsuarioS usuarioRegitro FROM baseserver.c_confcitas INNER JOIN baseserver.c_consultorio ON (c_confcitas.Id_Consultorio = c_consultorio.Id) INNER JOIN`g_sedes` ON (`g_sedes`.`Id`=`c_confcitas`.`IdSede`) WHERE (c_confcitas.Id_Profesional ='" + this.idProfesional + "' AND c_confcitas.Id_Especialidad ='" + this.idEspecialidad + "' and date_format( c_confcitas.Fecha_ConfCitas, '%Y-%m')='" + this.metodos.formatoANO_MES.format(this.txtFecha.getDate()) + "' AND c_confcitas.Estado = 0) ORDER BY c_confcitas.Fecha_ConfCitas DESC,c_confcitas.HoraInicial";
        }
        System.out.println("" + this.sql);
        this.rs = this.consultas.traerRs(this.sql);
        try {
            crearGrid();
            while (this.rs.next()) {
                this.modeloGridProg.addRow(this.filaGrid);
                this.gridProgramacion.setValueAt(this.rs.getString(1), this.filProg, 0);
                this.gridProgramacion.setValueAt(this.rs.getString(2), this.filProg, 1);
                this.gridProgramacion.setValueAt(this.rs.getString(3), this.filProg, 2);
                this.gridProgramacion.setValueAt(this.rs.getString(4), this.filProg, 3);
                this.gridProgramacion.setValueAt(this.rs.getString(5), this.filProg, 4);
                this.gridProgramacion.setValueAt(this.rs.getString(6), this.filProg, 5);
                this.gridProgramacion.setValueAt(this.rs.getString("Tipo"), this.filProg, 6);
                this.gridProgramacion.setValueAt("0", this.filProg, 7);
                this.gridProgramacion.setValueAt(this.rs.getString("Sede"), this.filProg, 8);
                this.gridProgramacion.setValueAt(this.rs.getString("fechaRegistro"), this.filProg, 9);
                this.gridProgramacion.setValueAt(this.rs.getString("usuarioRegitro"), this.filProg, 10);
                this.filProg++;
            }
            this.consultas.cerrarConexionBd();
        } catch (SQLException ex) {
            this.consultas.mostrarErrorSQL(ex);
        }
    }

    private void crearGrid() {
        this.modeloGridProg = new DefaultTableModel() { // from class: Citas.Programar_Citas.2
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.modeloGridProg.addColumn("Fecha");
        this.modeloGridProg.addColumn("Hora Inicial");
        this.modeloGridProg.addColumn("Hora Final");
        this.modeloGridProg.addColumn("");
        this.modeloGridProg.addColumn("Consultorio");
        this.modeloGridProg.addColumn("Cant. Citas");
        this.modeloGridProg.addColumn("Tipo Agenda");
        this.modeloGridProg.addColumn("");
        this.modeloGridProg.addColumn("Sede");
        this.modeloGridProg.addColumn("Fecha y hora de creación");
        this.modeloGridProg.addColumn("Usuario de creación");
        JTable jTable = this.gridProgramacion;
        JTable jTable2 = this.gridProgramacion;
        jTable.setAutoResizeMode(0);
        this.gridProgramacion.doLayout();
        this.gridProgramacion.setModel(this.modeloGridProg);
        this.gridProgramacion.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.gridProgramacion.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.gridProgramacion.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.gridProgramacion.getColumnModel().getColumn(3).setPreferredWidth(0);
        this.gridProgramacion.getColumnModel().getColumn(3).setMinWidth(0);
        this.gridProgramacion.getColumnModel().getColumn(3).setMaxWidth(0);
        this.gridProgramacion.getColumnModel().getColumn(4).setPreferredWidth(250);
        this.gridProgramacion.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.gridProgramacion.getColumnModel().getColumn(6).setPreferredWidth(150);
        this.gridProgramacion.getColumnModel().getColumn(7).setPreferredWidth(0);
        this.gridProgramacion.getColumnModel().getColumn(7).setMinWidth(0);
        this.gridProgramacion.getColumnModel().getColumn(7).setMaxWidth(0);
        this.gridProgramacion.getColumnModel().getColumn(8).setPreferredWidth(200);
        this.gridProgramacion.getColumnModel().getColumn(9).setPreferredWidth(300);
        this.gridProgramacion.getColumnModel().getColumn(10).setPreferredWidth(200);
        this.gridProgramacion.setDefaultRenderer(Object.class, new MiRender());
        this.filProg = 0;
    }

    public void desistir(int dia) {
        if (dia == 10) {
            this.metodos.mostrarMensaje("Por favor seleccione la Programación que Anulará\ny presione la Tecla 'Supr' del Teclado");
        } else if (this.metodos.getPregunta("Esta seguro de Desactivar la Programacion del Profesional") == 0 && dia == 1) {
            desactivarProgramacion(this.modeloGridProg, this.filaBorrado);
        }
    }

    private void desactivar(DefaultTableModel model, int fila, int agenda) {
        this.sql = "UPDATE c_confcitas SET Estado = 1 WHERE Id_Profesional ='" + this.idProfesional + "' AND Id_Especialidad ='" + this.idEspecialidad + "' AND Fecha_ConfCitas ='" + model.getValueAt(fila, 0).toString() + "' AND HoraInicial ='" + model.getValueAt(fila, 1).toString() + "' AND HoraFinal ='" + model.getValueAt(fila, 2).toString() + "' AND TipoAgenda ='" + agenda + "'";
        this.consultas.ejecutarSQL(this.sql);
        this.consultas.cerrarConexionBd();
        model.removeRow(fila);
        this.filProg--;
    }

    private void desactivarProgramacion(DefaultTableModel model, int fila) {
        int agenda;
        agenda = 2;
        switch (model.getValueAt(fila, 6).toString()) {
            case "General":
                agenda = 1;
                break;
            case "Especial":
                agenda = 2;
                break;
            case "Vacaciones":
                agenda = 3;
                break;
        }
        if (model.getValueAt(fila, 7).equals("0")) {
            if (model.getValueAt(fila, 6).equals("3")) {
                desactivar(model, fila, agenda);
                return;
            }
            this.sql = "SELECT Id FROM c_citas WHERE (Id_Profesional ='" + this.idProfesional + "' AND Id_Especialidad ='" + this.idEspecialidad + "' AND Fecha_Cita ='" + model.getValueAt(fila, 0) + "' AND HoraInicial >='" + model.getValueAt(fila, 1).toString() + "' AND HoraInicial <='" + model.getValueAt(fila, 2).toString() + "' AND Id_MotivoDesistida =1)";
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
        this.filProg--;
    }

    public void grabar() {
        if (!this.nbreProfesional.equals(this.nodo.getUserObject().toString())) {
            this.metodos.mostrarMensaje("Por favor seleccione un Profesional");
            this.Arbol.requestFocus();
        } else if (this.gridProgramacion.getRowCount() < 1) {
            this.metodos.mostrarMensaje("Por favor agregue por lo menos un día de programación");
        } else {
            grabarConfiguracion();
        }
    }

    private void grabarConfiguracion() {
        int grabo = 0;
        if (this.gridProgramacion.getRowCount() > 0) {
            grabo = grabarRegistro(this.gridProgramacion, 0);
        }
        if (grabo == 0) {
            this.metodos.mostrarMensaje("Por favor digite una Programación para Grabar");
        } else {
            cargarProgramacion();
            this.metodos.mostrarMensaje("Configuracion Grabada Ok.");
        }
    }

    private int grabarRegistro(JTable grid, int grabo) {
        int xgrabo = grabo;
        for (int fila = 0; fila < grid.getRowCount(); fila++) {
            if (grid.getValueAt(fila, 7).toString().equals("1")) {
                this.sql = "INSERT INTO c_confcitas (Id_Profesional, Id_Especialidad, IdSede, Id_Consultorio, TipoAgenda, DiaSemana, Fecha_ConfCitas, HoraInicial, HoraFinal, Cupo, AgendaGralUltConf, EsAdicional, Fecha, UsuarioS) VALUES ('" + this.idProfesional + "','" + this.idEspecialidad + "','" + this.xIdSede[this.JCB_Sede.getSelectedIndex()] + "','" + grid.getValueAt(fila, 3) + "','" + this.tipoAgenda + "','" + this.metodos.obtenerDiaSemana(grid.getValueAt(fila, 0).toString()) + "','" + grid.getValueAt(fila, 0).toString() + "','" + grid.getValueAt(fila, 1).toString() + "','" + grid.getValueAt(fila, 2).toString() + "','" + grid.getValueAt(fila, 5) + "','1','" + this.xesadicional + "','" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
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
        String ag;
        int encontrado = 0;
        if (this.btnListaTurno.isSelected()) {
            horaIni = this.listaTurnos[this.cboTurno.getSelectedIndex()][1];
            horaFin = this.listaTurnos[this.cboTurno.getSelectedIndex()][2];
        } else {
            horaIni = this.format.format(this.txtHoraInicio.getValue());
            horaFin = this.format.format(this.txtHoraFinal.getValue());
        }
        for (int f = 0; f < grid.getRowCount(); f++) {
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
            Date fechaIniGrid = sdf.parse(grid.getValueAt(f, 1).toString(), new ParsePosition(0));
            Date fechaFinGrid = sdf.parse(grid.getValueAt(f, 2).toString(), new ParsePosition(0));
            Date fechaIni = sdf.parse(horaIni, new ParsePosition(0));
            Date fechaFin = sdf.parse(horaFin, new ParsePosition(0));
            switch (this.tipoAgenda) {
                case 2:
                    ag = "Especial";
                    break;
                case 3:
                    ag = "Vacaciones";
                    break;
                default:
                    ag = "General";
                    break;
            }
            if (grid.getValueAt(f, 0).equals(this.metodos.formatoAMD.format(this.txtFecha.getDate())) && grid.getValueAt(f, 1).equals(horaIni) && grid.getValueAt(f, 6).equals(ag)) {
                this.metodos.mostrarMensaje("Ya existe una configuración para el Profesional en la Fecha, Horario y Tipo de Agenda");
                encontrado = 1;
            } else if (grid.getValueAt(f, 0).equals(this.metodos.formatoAMD.format(this.txtFecha.getDate())) && fechaIniGrid.before(fechaIni) && fechaIni.before(fechaFinGrid) && grid.getValueAt(f, 6).equals(ag)) {
                this.metodos.mostrarMensaje("Ya existe una configuración para el Profesional  en la Fecha y Tipo de Agenda que se cruza en los Horarios");
                encontrado = 1;
            } else if (grid.getValueAt(f, 0).equals(this.metodos.formatoAMD.format(this.txtFecha.getDate())) && fechaIni.before(fechaIniGrid) && fechaIniGrid.before(fechaFin) && grid.getValueAt(f, 6).equals(ag)) {
                this.metodos.mostrarMensaje("Ya existe una configuración para el Profesional  en la Fecha y Tipo de Agenda que se cruza en los Horarios");
                encontrado = 1;
            }
        }
        if (encontrado == 0) {
            modelo.addRow(this.filaGrid);
            grid.setValueAt(this.metodos.formatoAMD.format(this.txtFecha.getDate()), fila, 0);
            grid.setValueAt(horaIni, fila, 1);
            grid.setValueAt(horaFin, fila, 2);
            grid.setValueAt(this.listaConsultorio[this.cboConsultorio.getSelectedIndex()], fila, 3);
            grid.setValueAt(this.cboConsultorio.getSelectedItem(), fila, 4);
            grid.setValueAt(this.txtCantidad.getValue(), fila, 5);
            switch (this.tipoAgenda) {
                case 2:
                    grid.setValueAt("Especial", fila, 6);
                    break;
                case 3:
                    grid.setValueAt("Vacaciones", fila, 6);
                    break;
                default:
                    grid.setValueAt("General", fila, 6);
                    break;
            }
            grid.setValueAt("1", fila, 7);
            grid.setValueAt(this.JCB_Sede.getSelectedItem(), fila, 8);
            modelo.moveRow(fila, fila, 0);
            this.panelSemana.setSelectedIndex(i);
        }
        return encontrado;
    }

    private void llenarCombos() {
        this.cboLleno = 0;
        this.cboTurno.removeAllItems();
        this.listaTurnos = this.consultas.llenarComboyLista("SELECT Id, Nbre, date_format(HoraI,'%H:%i'), date_format(HoraF,'%H:%i') FROM c_turnos WHERE Estado = 0 ORDER BY Nbre ASC", this.listaTurnos, this.cboTurno, 4);
        this.cboTurno.setSelectedIndex(-1);
        this.JCB_Sede.removeAllItems();
        this.xIdSede = this.consultas.llenarCombo("SELECT `Id` , `Nbre` FROM `g_sedes` WHERE (`Estado` =1) ORDER BY `Nbre` ASC", this.xIdSede, this.JCB_Sede);
        this.JCB_Sede.setSelectedItem(Principal.sedeUsuarioSeleccionadaDTO.getNombre());
        this.JCB_Sede.setSelectedIndex(-1);
        this.consultas.cerrarConexionBd();
        this.cboLleno = 1;
    }

    public void nuevo() {
        this.txtHoraInicio.setValue(this.metodos.getFechaActual());
        this.txtHoraFinal.setValue(this.metodos.getFechaActual());
        llenarCombos();
        crearGrid();
        cargarArbol();
        this.cboConsultorio.setSelectedIndex(-1);
        this.cboTurno.setSelectedIndex(-1);
        this.txtCantidad.setValue(0);
        this.xesadicional = 0;
        this.JCHAdicional.setSelected(false);
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
        if (Integer.parseInt(op) == 2) {
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
        if (this.Arbol.isSelectionEmpty() || this.nodo.getLevel() < 2) {
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
            } else if (mValidarFecha(this.metodos.formatoAMD.format(this.txtFecha.getDate()))) {
                int j = JOptionPane.showInternalConfirmDialog(this, "Esta Seguro de Configurar Agenda en un día Festivo?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                retorno = (j == 0 && verificaDisponibilidadDelConsultorio(this.listaConsultorio[this.cboConsultorio.getSelectedIndex()], this.metodos.formatoAMD.format(this.txtFecha.getDate()), this.xIdSede[this.JCB_Sede.getSelectedIndex()])) ? 1 : 0;
            } else {
                retorno = verificaDisponibilidadDelConsultorio(this.listaConsultorio[this.cboConsultorio.getSelectedIndex()], this.metodos.formatoAMD.format(this.txtFecha.getDate()), this.xIdSede[this.JCB_Sede.getSelectedIndex()]) ? 1 : 0;
            }
        } else if (this.btnNuevoTurno.isSelected()) {
            if (this.txtHoraInicio.getValue().toString().equals("")) {
                this.metodos.mostrarMensaje("Por favor revise el Horario de Inicio no puede estar vacio");
                this.txtHoraInicio.requestFocus();
            } else if (this.txtHoraFinal.getValue().toString().equals("")) {
                this.metodos.mostrarMensaje("Por favor revise el Horario Final no puede estar vacio");
                this.txtHoraFinal.requestFocus();
            } else if (this.txtHoraInicio.getValue().toString().equals(this.txtHoraFinal.getValue().toString())) {
                this.metodos.mostrarMensaje("Por favor revise los Horarios que empiezan y terminan iguales");
                this.txtHoraFinal.requestFocus();
            } else if (this.format.format(this.txtHoraFinal.getValue()).compareTo(this.format.format(this.txtHoraInicio.getValue())) < 0) {
                this.metodos.mostrarMensaje("La Hora de Inicio no puede ser superior a la Final.");
                this.txtHoraInicio.requestFocus();
            } else if (Integer.parseInt(this.format.format(this.txtHoraInicio.getValue()).substring(3, 5)) % 5 != 0) {
                this.metodos.mostrarMensaje("Los minutos de la Hora de Inicio deben ser multiplos de 5");
                this.txtHoraInicio.requestFocus();
            } else if (Integer.parseInt(this.format.format(this.txtHoraFinal.getValue()).substring(3, 5)) % 5 != 0) {
                this.metodos.mostrarMensaje("Los minutos de la Hora de Final deben ser multiplos de 5");
                this.txtHoraInicio.requestFocus();
            } else if (mValidarFecha(this.metodos.formatoAMD.format(this.txtFecha.getDate()))) {
                int j2 = JOptionPane.showInternalConfirmDialog(this, "Esta Seguro de Configurar Agenda en un día Festivo?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                retorno = (j2 == 0 && verificaDisponibilidadDelConsultorio(this.listaConsultorio[this.cboConsultorio.getSelectedIndex()], this.metodos.formatoAMD.format(this.txtFecha.getDate()), this.xIdSede[this.JCB_Sede.getSelectedIndex()])) ? 1 : 0;
            } else {
                retorno = verificaDisponibilidadDelConsultorio(this.listaConsultorio[this.cboConsultorio.getSelectedIndex()], this.metodos.formatoAMD.format(this.txtFecha.getDate()), this.xIdSede[this.JCB_Sede.getSelectedIndex()]) ? 1 : 0;
            }
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

    /* JADX INFO: loaded from: GenomaP.jar:Citas/Programar_Citas$MiRender.class */
    public class MiRender extends DefaultTableCellRenderer {
        public MiRender() {
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            int cantidad = Integer.parseInt(table.getValueAt(row, 7).toString());
            if (cantidad == 0) {
                cell.setBackground(Color.CYAN);
                cell.setForeground(Color.BLACK);
            } else {
                cell.setBackground(Color.PINK);
                cell.setForeground(Color.BLACK);
            }
            return cell;
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:Citas/Programar_Citas$MyTreeCellRenderer.class */
    public class MyTreeCellRenderer extends DefaultTreeCellRenderer {
        public MyTreeCellRenderer() {
        }

        public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded, boolean leaf, int row, boolean hasFocus) {
            super.getTreeCellRendererComponent(tree, value, selected, expanded, leaf, row, hasFocus);
            tree.setRowHeight(26);
            setOpaque(true);
            setForeground(Color.black);
            if (selected) {
                setForeground(Color.red);
            }
            if (tree.getModel().getRoot().equals((DefaultMutableTreeNode) value)) {
                setIcon(Programar_Citas.this.rootIcon);
            } else if (leaf) {
                setIcon(Programar_Citas.this.medicoIcon);
            } else if (expanded) {
                setIcon(Programar_Citas.this.especialidadIcon);
            } else {
                setIcon(Programar_Citas.this.especialidadIcon);
            }
            return this;
        }
    }

    public boolean verificaDisponibilidadDelConsultorio(String idConsultorio, String fechaProgramacion, String idSede) {
        String horaIni;
        String horaFin;
        boolean estado = false;
        if (this.btnListaTurno.isSelected()) {
            horaIni = this.listaTurnos[this.cboTurno.getSelectedIndex()][1].toString();
            horaFin = this.listaTurnos[this.cboTurno.getSelectedIndex()][2].toString();
        } else {
            horaIni = this.format.format(this.txtHoraInicio.getValue());
            horaFin = this.format.format(this.txtHoraFinal.getValue());
        }
        String sql = "SELECT\n    `c_confcitas`.`Id_Consultorio`\n    , `profesional1`.`NProfesional`\n    , `profesional1`.`Especialidad`\n    , c_confcitas.`HoraInicial`\n    , c_confcitas.`HoraFinal`\nFROM\n    `profesional1`\n    INNER JOIN `c_confcitas` \n        ON (`profesional1`.`Id_Persona` = `c_confcitas`.`Id_Profesional`) AND (`profesional1`.`IdEspecialidad` = `c_confcitas`.`Id_Especialidad`)\nWHERE (`c_confcitas`.`Estado` =0\n    AND `c_confcitas`.`Fecha_ConfCitas` ='" + fechaProgramacion + "'\n    AND TIME_FORMAT(`c_confcitas`.`HoraInicial`,'%H:%i') BETWEEN '" + horaIni + "' AND '" + horaFin + "'\n    AND TIME_FORMAT(`c_confcitas`.`HoraFinal`,'%H:%i') BETWEEN '" + horaIni + "' AND '" + horaFin + "'\n    AND c_confcitas.`IdSede`=" + idSede + "\n    AND `c_confcitas`.`Id_Consultorio` ='" + idConsultorio + "')\nGROUP BY `c_confcitas`.`Id_Consultorio`;";
        ConsultasMySQL xct1 = new ConsultasMySQL();
        ResultSet xrs1 = xct1.traerRs(sql);
        try {
            if (xrs1.next()) {
                xrs1.first();
                String xmensaje = "<html><p><span style=\"color: #ff0000;\"><strong>El Consultorio que trata de seleccionar para la fecha " + fechaProgramacion + " se encuentra ocupado:</strong></span></p><p><span style=\"color: #ff0000;\"><strong>Hora Inicial: <span style=\"color: #000000;\">" + xrs1.getString("HoraInicial") + "</span></strong></span></p><p><span style=\"color: #ff0000;\"><strong>Hora Final: <span style=\"color: #000000;\">" + xrs1.getString("HoraFinal") + "</span></strong></span></p><p><span style=\"color: #ff0000;\"><strong>Medico: <span style=\"color: #000000;\">" + xrs1.getString("NProfesional") + "</span></strong></span></p><p><span style=\"color: #ff0000;\"><strong>Especialidad:&nbsp; <span style=\"color: #000000;\">" + xrs1.getString("Especialidad") + "</span></strong></span></p><p>&nbsp;</p></html>";
                JOptionPane.showInternalMessageDialog(this, xmensaje, "ALERTA", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            } else {
                estado = true;
            }
            xrs1.close();
            xct1.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFMovimiento.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return estado;
    }

    /* JADX WARN: Type inference failed for: r3v109, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.buttonGroup1 = new ButtonGroup();
        this.buttonGroup2 = new ButtonGroup();
        this.jPanel2 = new JPanel();
        this.txtFecha = new JCalendar();
        this.jLabel1 = new JLabel();
        this.jPanel12 = new JPanel();
        this.cboTurno = new JComboBox();
        this.txtCantidad = new JSpinner();
        this.JCHAdicional = new JCheckBox();
        this.txtHoraInicio = new JFormattedTextField();
        this.txtHoraFinal = new JFormattedTextField();
        this.JCB_Sede = new JComboBox();
        this.cboConsultorio = new JComboBox();
        this.jPanel3 = new JPanel();
        this.btnListaTurno = new JCheckBox();
        this.btnNuevoTurno = new JCheckBox();
        this.jPanel4 = new JPanel();
        this.btnEspecial = new JRadioButton();
        this.btnVaciones = new JRadioButton();
        this.jRadioButton1 = new JRadioButton();
        this.panelSemana = new JTabbedPane();
        this.jScrollPane2 = new JScrollPane();
        this.gridProgramacion = new JTable();
        this.jScrollPane1 = new JScrollPane();
        this.Arbol = new JTree();
        this.jPanel1 = new JPanel();
        this.JCH_Filtro = new JCheckBox();
        this.jButton1 = new JButton();
        setClosable(true);
        setIconifiable(true);
        setTitle("CONFIGURACION GENERAL DE CITAS");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMinimumSize(null);
        setName("Programar");
        addInternalFrameListener(new InternalFrameListener() { // from class: Citas.Programar_Citas.3
            public void internalFrameActivated(InternalFrameEvent evt) {
                Programar_Citas.this.formInternalFrameActivated(evt);
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
        this.txtFecha.setBackground(new Color(204, 255, 255));
        this.txtFecha.setBorder(BorderFactory.createEtchedBorder());
        this.txtFecha.setForeground(new Color(0, 0, 102));
        this.txtFecha.setDate(this.metodos.getFechaActual());
        this.txtFecha.setFont(new Font("Arial", 1, 12));
        this.txtFecha.setMaxSelectableDate(new Date(253370786486000L));
        this.txtFecha.setName("Calendario");
        this.txtFecha.setWeekOfYearVisible(false);
        this.txtFecha.addMouseListener(new MouseAdapter() { // from class: Citas.Programar_Citas.4
            public void mouseClicked(MouseEvent evt) {
                Programar_Citas.this.txtFechaMouseClicked(evt);
            }
        });
        this.txtFecha.addInputMethodListener(new InputMethodListener() { // from class: Citas.Programar_Citas.5
            public void caretPositionChanged(InputMethodEvent evt) {
                Programar_Citas.this.txtFechaCaretPositionChanged(evt);
            }

            public void inputMethodTextChanged(InputMethodEvent evt) {
            }
        });
        this.jLabel1.setBackground(new Color(0, 0, 153));
        this.jLabel1.setFont(new Font("Arial", 1, 14));
        this.jLabel1.setForeground(new Color(204, 255, 204));
        this.jLabel1.setHorizontalAlignment(0);
        this.jLabel1.setText("CALENDARIO");
        this.jLabel1.setMaximumSize(new Dimension(79, 15));
        this.jLabel1.setMinimumSize(new Dimension(79, 15));
        this.jLabel1.setOpaque(true);
        this.jLabel1.setPreferredSize(new Dimension(79, 15));
        this.jPanel12.setBorder(BorderFactory.createEtchedBorder());
        this.jPanel12.setLayout((LayoutManager) null);
        this.cboTurno.setFont(new Font("Arial", 1, 12));
        this.cboTurno.setBorder(BorderFactory.createTitledBorder((Border) null, "Turno", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.cboTurno.addItemListener(new ItemListener() { // from class: Citas.Programar_Citas.6
            public void itemStateChanged(ItemEvent evt) {
                Programar_Citas.this.cboTurnoItemStateChanged(evt);
            }
        });
        this.jPanel12.add(this.cboTurno);
        this.cboTurno.setBounds(10, 10, 270, 50);
        this.txtCantidad.setFont(new Font("Arial", 1, 12));
        this.txtCantidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Cupos", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jPanel12.add(this.txtCantidad);
        this.txtCantidad.setBounds(10, 190, 80, 50);
        this.JCHAdicional.setFont(new Font("Arial", 1, 12));
        this.JCHAdicional.setForeground(Color.red);
        this.JCHAdicional.setText("Es Adicional?");
        this.JCHAdicional.addActionListener(new ActionListener() { // from class: Citas.Programar_Citas.7
            public void actionPerformed(ActionEvent evt) {
                Programar_Citas.this.JCHAdicionalActionPerformed(evt);
            }
        });
        this.jPanel12.add(this.JCHAdicional);
        this.JCHAdicional.setBounds(120, 210, 120, 19);
        this.txtHoraInicio.setBorder(BorderFactory.createTitledBorder((Border) null, "Horario de Inicio", 0, 0, new Font("Arial", 1, 12), new Color(0, 2, 200)));
        this.txtHoraInicio.setFormatterFactory(new DefaultFormatterFactory(new DateFormatter(new SimpleDateFormat("HH:mm"))));
        this.txtHoraInicio.setText("12:00");
        this.txtHoraInicio.setEnabled(false);
        this.txtHoraInicio.setFont(new Font("Arial", 1, 36));
        this.jPanel12.add(this.txtHoraInicio);
        this.txtHoraInicio.setBounds(300, 10, 150, 70);
        this.txtHoraFinal.setBorder(BorderFactory.createTitledBorder((Border) null, "Horario Final", 0, 0, new Font("Arial", 1, 12), new Color(0, 2, 200)));
        this.txtHoraFinal.setFormatterFactory(new DefaultFormatterFactory(new DateFormatter(new SimpleDateFormat("HH:mm"))));
        this.txtHoraFinal.setText("12:00");
        this.txtHoraFinal.setEnabled(false);
        this.txtHoraFinal.setFont(new Font("Arial", 1, 36));
        this.txtHoraFinal.addActionListener(new ActionListener() { // from class: Citas.Programar_Citas.8
            public void actionPerformed(ActionEvent evt) {
                Programar_Citas.this.txtHoraFinalActionPerformed(evt);
            }
        });
        this.jPanel12.add(this.txtHoraFinal);
        this.txtHoraFinal.setBounds(300, 90, 150, 63);
        this.JCB_Sede.setFont(new Font("Arial", 1, 12));
        this.JCB_Sede.setBorder(BorderFactory.createTitledBorder((Border) null, "Sede", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCB_Sede.addItemListener(new ItemListener() { // from class: Citas.Programar_Citas.9
            public void itemStateChanged(ItemEvent evt) {
                Programar_Citas.this.JCB_SedeItemStateChanged(evt);
            }
        });
        this.jPanel12.add(this.JCB_Sede);
        this.JCB_Sede.setBounds(10, 70, 270, 50);
        this.cboConsultorio.setFont(new Font("Arial", 1, 12));
        this.cboConsultorio.setAutoscrolls(true);
        this.cboConsultorio.setBorder(BorderFactory.createTitledBorder((Border) null, "Consultorio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jPanel12.add(this.cboConsultorio);
        this.cboConsultorio.setBounds(10, 130, 270, 50);
        this.jPanel3.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de Turno", 0, 0, new Font("Arial", 1, 12), new Color(102, 0, 51)));
        this.buttonGroup1.add(this.btnListaTurno);
        this.btnListaTurno.setFont(new Font("Arial", 1, 12));
        this.btnListaTurno.setSelected(true);
        this.btnListaTurno.setText("Lista de Turnos");
        this.btnListaTurno.addActionListener(new ActionListener() { // from class: Citas.Programar_Citas.10
            public void actionPerformed(ActionEvent evt) {
                Programar_Citas.this.btnListaTurnoActionPerformed(evt);
            }
        });
        this.buttonGroup1.add(this.btnNuevoTurno);
        this.btnNuevoTurno.setFont(new Font("Arial", 1, 12));
        this.btnNuevoTurno.setText("Nuevo Turno");
        this.btnNuevoTurno.addActionListener(new ActionListener() { // from class: Citas.Programar_Citas.11
            public void actionPerformed(ActionEvent evt) {
                Programar_Citas.this.btnNuevoTurnoActionPerformed(evt);
            }
        });
        GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
        this.jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.btnNuevoTurno, -2, 110, -2).addComponent(this.btnListaTurno)).addContainerGap()));
        jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup().addComponent(this.btnNuevoTurno).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.btnListaTurno).addContainerGap(-1, 32767)));
        this.jPanel4.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de Configuración", 0, 0, new Font("Arial", 1, 12), new Color(153, 0, 0)));
        this.buttonGroup2.add(this.btnEspecial);
        this.btnEspecial.setFont(new Font("Arial", 1, 12));
        this.btnEspecial.setForeground(new Color(0, 0, 153));
        this.btnEspecial.setSelected(true);
        this.btnEspecial.setText("Especial");
        this.btnEspecial.addActionListener(new ActionListener() { // from class: Citas.Programar_Citas.12
            public void actionPerformed(ActionEvent evt) {
                Programar_Citas.this.btnEspecialActionPerformed(evt);
            }
        });
        this.buttonGroup2.add(this.btnVaciones);
        this.btnVaciones.setFont(new Font("Arial", 1, 12));
        this.btnVaciones.setForeground(new Color(0, 0, 153));
        this.btnVaciones.setText("Vacaciones");
        this.btnVaciones.setFocusable(false);
        this.btnVaciones.setHorizontalAlignment(11);
        this.btnVaciones.setVerticalTextPosition(3);
        this.btnVaciones.addActionListener(new ActionListener() { // from class: Citas.Programar_Citas.13
            public void actionPerformed(ActionEvent evt) {
                Programar_Citas.this.btnVacionesActionPerformed(evt);
            }
        });
        this.buttonGroup2.add(this.jRadioButton1);
        this.jRadioButton1.setFont(new Font("Arial", 1, 12));
        this.jRadioButton1.setForeground(new Color(0, 0, 153));
        this.jRadioButton1.setText("General");
        this.jRadioButton1.addActionListener(new ActionListener() { // from class: Citas.Programar_Citas.14
            public void actionPerformed(ActionEvent evt) {
                Programar_Citas.this.jRadioButton1ActionPerformed(evt);
            }
        });
        GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
        this.jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addContainerGap().addComponent(this.jRadioButton1).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.btnEspecial).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.btnVaciones).addContainerGap(36, 32767)));
        jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addContainerGap().addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.btnVaciones).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.btnEspecial).addComponent(this.jRadioButton1))).addContainerGap(24, 32767)));
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGap(8, 8, 8).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.jPanel4, -2, -1, -2).addGap(30, 30, 30).addComponent(this.jPanel3, -2, -1, -2)).addComponent(this.jPanel12, -2, 480, -2)).addGap(20, 20, 20).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel1, -2, 270, -2).addComponent(this.txtFecha, -2, 270, -2))));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGap(8, 8, 8).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel4, -2, -1, -2).addComponent(this.jPanel3, -2, 70, -2)).addGap(10, 10, 10).addComponent(this.jPanel12, -2, 250, -2)).addGroup(jPanel2Layout.createSequentialGroup().addGap(18, 18, 18).addComponent(this.jLabel1, -2, 40, -2).addGap(10, 10, 10).addComponent(this.txtFecha, -2, 270, -2)));
        this.panelSemana.setForeground(new Color(0, 102, 102));
        this.panelSemana.setAutoscrolls(true);
        this.panelSemana.setFont(new Font("Arial", 1, 14));
        this.gridProgramacion.setFont(new Font("Arial", 1, 12));
        this.gridProgramacion.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.gridProgramacion.setRowHeight(25);
        this.gridProgramacion.setSelectionBackground(new Color(255, 255, 255));
        this.gridProgramacion.setSelectionForeground(new Color(255, 0, 0));
        this.gridProgramacion.setSelectionMode(0);
        this.gridProgramacion.addKeyListener(new KeyAdapter() { // from class: Citas.Programar_Citas.15
            public void keyPressed(KeyEvent evt) {
                Programar_Citas.this.gridProgramacionKeyPressed(evt);
            }

            public void keyReleased(KeyEvent evt) {
                Programar_Citas.this.gridProgramacionKeyReleased(evt);
            }
        });
        this.jScrollPane2.setViewportView(this.gridProgramacion);
        this.panelSemana.addTab("Programación", this.jScrollPane2);
        this.Arbol.setFont(new Font("Arial", 1, 12));
        this.Arbol.addTreeSelectionListener(new TreeSelectionListener() { // from class: Citas.Programar_Citas.16
            public void valueChanged(TreeSelectionEvent evt) {
                Programar_Citas.this.ArbolValueChanged(evt);
            }
        });
        this.jScrollPane1.setViewportView(this.Arbol);
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "Filtros", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 153)));
        this.JCH_Filtro.setFont(new Font("Arial", 1, 12));
        this.JCH_Filtro.setForeground(Color.red);
        this.JCH_Filtro.setSelected(true);
        this.JCH_Filtro.setText("Mostrar Todo?");
        this.JCH_Filtro.addActionListener(new ActionListener() { // from class: Citas.Programar_Citas.17
            public void actionPerformed(ActionEvent evt) {
                Programar_Citas.this.JCH_FiltroActionPerformed(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.JCH_Filtro).addContainerGap(-1, 32767)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(25, 25, 25).addComponent(this.JCH_Filtro).addContainerGap(22, 32767)));
        this.jButton1.setFont(new Font("Arial", 1, 12));
        this.jButton1.setForeground(new Color(0, 102, 102));
        this.jButton1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.jButton1.setText("Cargar Programación");
        this.jButton1.addActionListener(new ActionListener() { // from class: Citas.Programar_Citas.18
            public void actionPerformed(ActionEvent evt) {
                Programar_Citas.this.jButton1ActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane1, -2, 370, -2).addComponent(this.jPanel1, -1, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel2, -1, -1, 32767).addComponent(this.panelSemana, -1, 806, 32767).addComponent(this.jButton1, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.jScrollPane1, -2, 585, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel1, -2, -1, -2).addGap(0, 7, 32767)).addGroup(layout.createSequentialGroup().addComponent(this.jPanel2, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jButton1, -2, 50, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.panelSemana, -2, 0, 32767))).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnEspecialActionPerformed(ActionEvent evt) {
        this.tipoAgenda = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jButton1ActionPerformed(ActionEvent evt) {
        agregarFilaGrid();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnListaTurnoActionPerformed(ActionEvent evt) {
        this.cboTurno.setEnabled(true);
        this.txtHoraInicio.setEnabled(false);
        this.txtHoraFinal.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnNuevoTurnoActionPerformed(ActionEvent evt) {
        this.cboTurno.setEnabled(false);
        this.txtHoraInicio.setEnabled(true);
        this.txtHoraFinal.setEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ArbolValueChanged(TreeSelectionEvent evt) {
        seleccionarArbol();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameActivated(InternalFrameEvent evt) {
        this.clasCita.frmPrincipal.mActivarBarraMenu(this.clasCita.frmPrincipal.xMenus.barraMnuCita, 5);
        this.metodos.limpiarDatosPrincipal();
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

    /* JADX INFO: Access modifiers changed from: private */
    public void btnVacionesActionPerformed(ActionEvent evt) {
        this.tipoAgenda = 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gridProgramacionKeyReleased(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gridProgramacionKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 127) {
            desistir(1);
        }
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
    public void txtFechaCaretPositionChanged(InputMethodEvent evt) {
        this.fechaCal.setGregorianChange(this.txtFecha.getDate());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtFechaMouseClicked(MouseEvent evt) {
        this.fechaCal.setGregorianChange(this.txtFecha.getDate());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtHoraFinalActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jRadioButton1ActionPerformed(ActionEvent evt) {
        this.tipoAgenda = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCB_SedeItemStateChanged(ItemEvent evt) {
        if (this.cboLleno == 1 && this.JCB_Sede.getSelectedIndex() != -1) {
            this.cboConsultorio.removeAllItems();
            this.listaConsultorio = this.consultas.llenarCombo("SELECT Id, Nbre FROM c_consultorio WHERE Estado = 0 and idSede = '" + this.xIdSede[this.JCB_Sede.getSelectedIndex()] + "'ORDER BY Nbre ASC", this.listaConsultorio, this.cboConsultorio);
            this.cboConsultorio.setSelectedIndex(-1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboTurnoItemStateChanged(ItemEvent evt) {
        if (this.cboLleno == 1) {
            this.txtHoraInicio.setText(this.listaTurnos[this.cboTurno.getSelectedIndex()][1]);
            this.txtHoraFinal.setText(this.listaTurnos[this.cboTurno.getSelectedIndex()][2]);
        }
    }
}
