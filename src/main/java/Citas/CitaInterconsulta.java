package Citas;

import Acceso.Principal;
import General.Anular;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Citas/CitaInterconsulta.class */
public class CitaInterconsulta extends JInternalFrame {
    private Metodos metodos;
    private ConsultasMySQL consultas;
    private GregorianCalendar fecha;
    private int cboLleno;
    private int filaGrid;
    private int motivoDesistida;
    private String[] listaProfesional;
    private String[][] listaClaseCita;
    private String[][] listaDiasConCita;
    private String[][] listaPacientesConCita;
    private int filaListaDiasConCita;
    private ResultSet rs;
    private String sql;
    private String nbreProfesional;
    private String idEspecialD;
    private String idProfesional;
    private String NoCitaIps;
    private GregorianCalendar fechaActual;
    private int grabarCita;
    private Object[] dato;
    private DefaultTableModel modeloGrid;
    private String idPaciente;
    private String nbrePaciente;
    private String idEps;
    private String nbreEspecialD;
    private String IdRemision;
    private int idReasignar;
    private int tipoCitaRepetida;
    private String NoCitaAReasignar;
    private DecimalFormat formato2Digito;
    private ClaseHiloCita hiloCita;
    private Thread hilo;
    private String xAno;
    private String xMes;
    private String xDia;
    private String[] lisDiasFestivos;
    public GregorianCalendar fechaCalendario;
    public int ultimoDia;
    public JButton boton;
    private JButton btn1;
    private JButton btn10;
    private JButton btn11;
    private JButton btn12;
    private JButton btn13;
    private JButton btn14;
    private JButton btn15;
    private JButton btn16;
    private JButton btn17;
    private JButton btn18;
    private JButton btn19;
    private JButton btn2;
    private JButton btn20;
    private JButton btn21;
    private JButton btn22;
    private JButton btn23;
    private JButton btn24;
    private JButton btn25;
    private JButton btn26;
    private JButton btn27;
    private JButton btn28;
    private JButton btn29;
    private JButton btn3;
    private JButton btn30;
    private JButton btn31;
    private JButton btn32;
    private JButton btn33;
    private JButton btn34;
    private JButton btn35;
    private JButton btn36;
    private JButton btn37;
    private JButton btn38;
    private JButton btn39;
    private JButton btn4;
    private JButton btn40;
    private JButton btn41;
    private JButton btn42;
    private JButton btn5;
    private JButton btn6;
    private JButton btn7;
    private JButton btn8;
    private JButton btn9;
    private JButton btnSalir;
    private JComboBox cboClaseCita;
    public JComboBox cboMes;
    public JComboBox cboProfesional;
    public JTable grid;
    private JLabel jLabel10;
    private JLabel jLabel11;
    private JLabel jLabel12;
    private JLabel jLabel13;
    private JLabel jLabel14;
    private JLabel jLabel15;
    private JLabel jLabel16;
    private JLabel jLabel2;
    private JLabel jLabel26;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel6;
    private JLabel jLabel8;
    private JPanel jPanel1;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JPanel jPanel5;
    private JScrollPane jScrollPane3;
    private JSeparator jSeparator1;
    private JSeparator jSeparator2;
    private JLabel lblFecha;
    private JMenuItem mnAsignar;
    private JMenuItem mnDesistir;
    private JPopupMenu mnPopup;
    private JMenuItem mnReasignar;
    private JMenuItem mnRecordatorio;
    private JMenuItem mnSalir;
    private JPanel panelCalendario;
    public static JPanel panelDias;
    public JSpinner txtAno;
    public static JTextField txtConsultorio;
    private JTextField txtDuracion;
    private JLabel txtHoy;
    public JTextField txtNoCita;

    public CitaInterconsulta() {
        this.metodos = new Metodos();
        this.consultas = new ConsultasMySQL();
        this.fecha = new GregorianCalendar();
        this.cboLleno = 0;
        this.filaGrid = 0;
        this.motivoDesistida = 1;
        this.listaDiasConCita = new String[1000][7];
        this.listaPacientesConCita = new String[0][0];
        this.filaListaDiasConCita = 0;
        this.fechaActual = new GregorianCalendar();
        this.grabarCita = 0;
        this.idReasignar = 0;
        this.tipoCitaRepetida = 0;
        this.NoCitaAReasignar = "0";
        this.formato2Digito = new DecimalFormat("#0");
        this.fechaCalendario = new GregorianCalendar();
        initComponents();
    }

    public CitaInterconsulta(String idEspecialD, String nbreProfesional, String idPaciente, String nbrePaciente, String idIngreso, String nbreEspecialD, String idRemision) {
        this.metodos = new Metodos();
        this.consultas = new ConsultasMySQL();
        this.fecha = new GregorianCalendar();
        this.cboLleno = 0;
        this.filaGrid = 0;
        this.motivoDesistida = 1;
        this.listaDiasConCita = new String[1000][7];
        this.listaPacientesConCita = new String[0][0];
        this.filaListaDiasConCita = 0;
        this.fechaActual = new GregorianCalendar();
        this.grabarCita = 0;
        this.idReasignar = 0;
        this.tipoCitaRepetida = 0;
        this.NoCitaAReasignar = "0";
        this.formato2Digito = new DecimalFormat("#0");
        this.fechaCalendario = new GregorianCalendar();
        initComponents();
        setClosable(true);
        setLocation(150, 20);
        this.idEspecialD = idEspecialD;
        this.nbreProfesional = nbreProfesional;
        this.idPaciente = idPaciente;
        this.nbrePaciente = nbrePaciente;
        this.nbreEspecialD = nbreEspecialD;
        this.IdRemision = idRemision;
        this.txtHoy.setText("Hoy es :  " + this.metodos.formatoFecha.format(this.fechaCalendario.getTime()));
        consultarEps(idIngreso);
        crearGrid();
        cargarCombos();
        cargarCitaRepetida();
        cargarNoCitaIps();
        setFechaActual();
        cargarDiasFestivos();
        this.cboMes.setSelectedIndex(this.fechaActual.get(2));
        this.txtAno.setValue(Integer.valueOf(this.fechaActual.get(1)));
        cargarFecha();
        this.hiloCita = new ClaseHiloCita(this, this.txtNoCita.getText(), this.idProfesional);
        this.hilo = new Thread(this.hiloCita);
        this.hilo.start();
        this.cboProfesional.setSelectedItem(nbreProfesional);
        this.grid.addMouseListener(new MouseAdapter() { // from class: Citas.CitaInterconsulta.1
            public void mouseClicked(MouseEvent e) {
                CitaInterconsulta.this.filaGrid = CitaInterconsulta.this.grid.rowAtPoint(e.getPoint());
                if (CitaInterconsulta.this.grid.getValueAt(CitaInterconsulta.this.filaGrid, 3) != null) {
                    CitaInterconsulta.this.txtNoCita.setText(CitaInterconsulta.this.grid.getValueAt(CitaInterconsulta.this.filaGrid, 3).toString());
                    Principal.txtNo.setText(CitaInterconsulta.this.txtNoCita.getText());
                } else {
                    CitaInterconsulta.this.txtNoCita.setText("0");
                    Principal.txtNo.setText("0");
                }
            }
        });
    }

    private void asignarCita() {
        this.mnPopup.setVisible(false);
        if (this.nbreProfesional.isEmpty()) {
            this.metodos.mostrarMensaje("Por Favor seleccione un Profesional.");
            this.cboProfesional.requestFocus();
            return;
        }
        if (this.cboClaseCita.getSelectedIndex() < 0) {
            this.metodos.mostrarMensaje("Por Favor seleccione una Clase de Cita");
            this.cboClaseCita.requestFocus();
            return;
        }
        if (this.fechaActual.getTime().getTime() > this.fechaCalendario.getTime().getTime()) {
            this.metodos.mostrarMensaje("No puede asignar una Cita en Fechas anteriores a la actual\nPor favor verifique las fechas");
            return;
        }
        int citaPendiente = 0;
        switch (this.tipoCitaRepetida) {
            case 0:
                citaPendiente = buscarSiTieneCitaPendiente(">=", this.metodos.formatoAMD.format(this.fechaActual.getTime()));
                break;
            case 2:
                citaPendiente = buscarSiTieneCitaPendiente("=", this.metodos.formatoAMD.format(this.fechaCalendario.getTime()));
                break;
        }
        if (citaPendiente == 0) {
            int duracion = contarEspacioParaAsignarCita(Integer.parseInt(this.txtDuracion.getText()));
            if (duracion == 1 || (duracion == 0 && this.tipoCitaRepetida == 4)) {
                if (this.idReasignar == 0) {
                    if (verificarFechaHoraProfesionalEspecialidad()) {
                        this.modeloGrid.setValueAt(this.nbrePaciente, this.filaGrid, 2);
                        this.modeloGrid.setValueAt(this.idPaciente, this.filaGrid, 4);
                        this.modeloGrid.setValueAt("Clase de cita", this.filaGrid, 5);
                        this.modeloGrid.setValueAt(this.txtDuracion.getText(), this.filaGrid, 8);
                        this.grabarCita = 1;
                        grabar();
                        return;
                    }
                    JOptionPane.showInternalMessageDialog(this, "Ya existe una cita a la misma fecha, hora y profesional;\nFavor cambiar hora de asignación", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    return;
                }
                modificarCita();
            }
        }
    }

    public void buscarCita(String diaBoton, JButton xBoton) {
        this.xDia = diaBoton;
        this.fechaCalendario.set(Integer.valueOf(this.xAno).intValue(), Integer.valueOf(this.xMes).intValue(), Integer.valueOf(this.xDia).intValue());
        this.lblFecha.setText("Fecha seleccionada : " + this.xDia + " de " + this.cboMes.getSelectedItem().toString() + " de " + this.xAno);
        if (xBoton.getIcon() == null) {
            this.metodos.mostrarMensaje("Lo siento, No hay Programación de Citas para esa fecha.\nDia : " + this.xDia + "\nMes : " + this.cboMes.getSelectedItem() + "\nAño : " + this.txtAno.getValue() + "\nProfesional : " + this.listaProfesional[this.cboProfesional.getSelectedIndex()]);
        } else if (Integer.parseInt(this.listaProfesional[this.cboProfesional.getSelectedIndex()]) < 0) {
            this.metodos.mostrarMensaje("Por favor seleccione un Profesional");
        } else {
            cargarHorarioGrid();
        }
    }

    private int buscarSiTieneCitaPendiente(String signo, String fechaCita) {
        int r = 0;
        this.sql = "SELECT c_citas.Fecha_Cita FROM baseserver.c_citas INNER JOIN baseserver.g_especialidad ON (c_citas.Id_Especialidad = g_especialidad.Id) WHERE (c_citas.Id_Especialidad ='" + this.idEspecialD + "' AND c_citas.Id_Usuario = '" + this.idPaciente + "' AND c_citas.Fecha_Cita " + signo + "'" + fechaCita + "' AND c_citas.Asistida =0 AND c_citas.Id_MotivoDesistida =1)";
        String fecha = this.consultas.traerDato(this.sql);
        if (!fecha.isEmpty() && this.idReasignar == 0) {
            r = 1;
            this.metodos.mostrarMensaje("No se puede asignar una Cita al Usuario.\nYa tiene una cita asignada con la especialidad " + this.nbreEspecialD + "\npara el dia " + fecha);
        }
        this.consultas.cerrarConexionBd();
        return r;
    }

    private void cargarCitaRepetida() {
        this.sql = "SELECT CitaRepetida FROM  baseserver.g_especialidad WHERE (Id ='" + this.idEspecialD + "')";
        this.tipoCitaRepetida = Integer.parseInt(this.consultas.traerDato(this.sql));
        this.consultas.cerrarConexionBd();
    }

    private void cargarCombos() {
        this.cboLleno = 0;
        this.listaProfesional = this.consultas.llenarCombo("SELECT w_profesional.Id_Persona, w_profesional.NProfesional FROM baseserver.w_profesional INNER JOIN baseserver.g_profesionalespecial ON (w_profesional.Id_Persona = g_profesionalespecial.Id_Profesional) WHERE (g_profesionalespecial.Id_Especialidad ='" + this.idEspecialD + "' AND g_profesionalespecial.Estado =0) ORDER BY w_profesional.NProfesional ASC", this.listaProfesional, this.cboProfesional);
        this.listaClaseCita = this.consultas.llenarComboyLista("SELECT Id, Nbre, Duracion FROM c_clasecita WHERE Id_Especialidad ='" + this.idEspecialD + "' AND Estado =0 ORDER BY Nbre ASC", this.listaClaseCita, this.cboClaseCita, 3);
        this.cboProfesional.setSelectedIndex(-1);
        this.cboClaseCita.setSelectedIndex(-1);
        this.consultas.cerrarConexionBd();
        this.cboLleno = 1;
    }

    private void consultarEps(String idIngreso) {
        this.sql = "SELECT Id_EmpresaContxConv FROM baseserver.ingreso WHERE (Id ='" + idIngreso + "')";
        this.idEps = this.consultas.traerDato(this.sql);
        this.consultas.cerrarConexionBd();
    }

    public void cargarPacienteConCita() {
        try {
            this.sql = "SELECT c_citas.HoraInicial, c_citas.HoraFinal, w_persona.NUsuario, c_clasecita.Duracion, c_citas.Id, w_persona.Id_persona, c_clasecita.Nbre, g_parentesco.EsTrabajador, w_persona.NoHistoria FROM baseserver.c_citas INNER JOIN baseserver.c_clasecita ON (c_citas.Id_ClaseCita = c_clasecita.Id) INNER JOIN baseserver.w_persona ON (c_citas.Id_Usuario = w_persona.Id_persona) INNER JOIN baseserver.g_usuario ON (w_persona.Id_persona = g_usuario.Id_persona) LEFT JOIN baseserver.g_usuario_fpz ON (g_usuario.Id_persona = g_usuario_fpz.Id_Persona) LEFT JOIN baseserver.g_parentesco ON (g_usuario_fpz.Id_Parentesco = g_parentesco.Id) WHERE (c_citas.Fecha_Cita ='" + Integer.valueOf(this.xAno) + "-" + (Integer.valueOf(this.xMes).intValue() + 1) + "-" + this.formato2Digito.format(Integer.valueOf(this.xDia)) + "' AND c_citas.Id_Profesional ='" + this.listaProfesional[this.cboProfesional.getSelectedIndex()] + "' AND c_citas.Id_MotivoDesistida =1 AND c_citas.Id_Especialidad ='" + this.idEspecialD + "') ORDER BY c_citas.HoraInicial ASC";
            this.rs = this.consultas.traerRs(this.sql);
            this.rs.last();
            this.listaPacientesConCita = new String[this.rs.getRow()][9];
            if (this.rs.getRow() > 0) {
                int fila = 0;
                this.rs.beforeFirst();
                while (this.rs.next()) {
                    this.listaPacientesConCita[fila][0] = this.rs.getString(1);
                    this.listaPacientesConCita[fila][1] = this.rs.getString(2);
                    this.listaPacientesConCita[fila][2] = this.rs.getString(3);
                    this.listaPacientesConCita[fila][3] = this.rs.getString(4);
                    this.listaPacientesConCita[fila][4] = this.rs.getString(5);
                    this.listaPacientesConCita[fila][5] = this.rs.getString(6);
                    this.listaPacientesConCita[fila][6] = this.rs.getString(7);
                    if (this.rs.getString(8) != null) {
                        if (this.rs.getString(8).equals("1")) {
                            this.listaPacientesConCita[fila][7] = "1";
                        } else {
                            this.listaPacientesConCita[fila][7] = "0";
                        }
                    } else {
                        this.listaPacientesConCita[fila][7] = "0";
                    }
                    this.listaPacientesConCita[fila][8] = this.rs.getString(9);
                    fila++;
                }
            }
            this.rs.close();
            this.consultas.cerrarConexionBd();
        } catch (SQLException ex) {
            this.consultas.mostrarErrorSQL(ex);
        }
    }

    public void cargarHorarioGrid() {
        cargarPacienteConCita();
        int diaAnterior = 0;
        int fila = 0;
        int dosHoras = 5;
        for (int i = 0; i < 1000 && this.listaDiasConCita[i][0] != null; i++) {
            if (Integer.parseInt(this.listaDiasConCita[i][0]) == Integer.valueOf(this.xDia).intValue()) {
                if (diaAnterior != Integer.parseInt(this.listaDiasConCita[i][0])) {
                    limpiarGrid();
                    fila = 0;
                }
                diaAnterior = Integer.parseInt(this.listaDiasConCita[i][0]);
                int horaInicio = Integer.parseInt(this.listaDiasConCita[i][2].substring(0, 2));
                int minutoInicio = Integer.parseInt(this.listaDiasConCita[i][2].substring(3, 5));
                int horaFinal = Integer.parseInt(this.listaDiasConCita[i][3].substring(0, 2));
                int minutoFinal = Integer.parseInt(this.listaDiasConCita[i][3].substring(3, 5));
                String hora = "";
                txtConsultorio.setText(this.listaDiasConCita[i][4]);
                for (int horaIni = horaInicio; horaIni <= horaFinal; horaIni++) {
                    int i2 = minutoInicio;
                    while (true) {
                        int min = i2;
                        if (min >= 60 || (horaIni == horaFinal && min > minutoFinal)) {
                            break;
                        }
                        hora = getHora(horaIni, min);
                        if (this.listaDiasConCita[i][5].equals("3")) {
                            int p = 0;
                            while (true) {
                                if (p >= this.modeloGrid.getRowCount()) {
                                    break;
                                }
                                if (!this.modeloGrid.getValueAt(p, 0).toString().equals(hora)) {
                                    p++;
                                } else {
                                    this.modeloGrid.setValueAt("Libre / Permiso / Vacaciones / Capacitación", p, 2);
                                    break;
                                }
                            }
                        } else {
                            int salir = 0;
                            this.modeloGrid.addRow(this.dato);
                            this.modeloGrid.setValueAt(hora, fila, 0);
                            this.modeloGrid.setValueAt(" ", fila, 2);
                            this.modeloGrid.setValueAt("", fila, 5);
                            this.modeloGrid.setValueAt("0", fila, 6);
                            this.modeloGrid.setValueAt(Integer.valueOf(dosHoras), fila, 8);
                            String hora24 = this.metodos.pasarHora12a24(hora);
                            int a = 0;
                            while (true) {
                                if (a >= this.listaPacientesConCita.length) {
                                    break;
                                }
                                if (this.listaPacientesConCita[a][0].toString().substring(0, 5).equals(hora24.substring(0, 5))) {
                                    String horaUltima = this.metodos.formatoHora12(this.listaPacientesConCita[a][1]);
                                    this.modeloGrid.setValueAt(horaUltima, fila, 1);
                                    this.modeloGrid.setValueAt(this.listaPacientesConCita[a][2], fila, 2);
                                    this.modeloGrid.setValueAt(this.listaPacientesConCita[a][4], fila, 3);
                                    this.modeloGrid.setValueAt(this.listaPacientesConCita[a][5], fila, 4);
                                    this.modeloGrid.setValueAt(this.listaPacientesConCita[a][6], fila, 5);
                                    this.modeloGrid.setValueAt(this.listaPacientesConCita[a][7], fila, 6);
                                    this.modeloGrid.setValueAt(this.listaPacientesConCita[a][8], fila, 7);
                                    this.modeloGrid.setValueAt(Integer.valueOf(dosHoras), fila, 8);
                                    this.grid.setDefaultRenderer(Object.class, new MiRender());
                                    dosHoras += Integer.parseInt(this.listaPacientesConCita[a][3].toString());
                                    min = Integer.parseInt(this.modeloGrid.getValueAt(fila, 1).toString().substring(3, 5));
                                    if (min > min || Integer.parseInt(this.listaPacientesConCita[a][3].toString()) > 59) {
                                        salir = 1;
                                        minutoInicio = min;
                                    } else {
                                        min -= 5;
                                    }
                                } else {
                                    minutoInicio = 0;
                                    a++;
                                }
                            }
                            fila++;
                            dosHoras += 5;
                            if (salir == 1) {
                                break;
                            }
                        }
                        i2 = min + 5;
                    }
                }
                this.modeloGrid.setValueAt(hora, fila - 1, 0);
                this.modeloGrid.setValueAt("                   - DESCANSO -                ", fila - 1, 2);
                this.modeloGrid.setValueAt("", fila - 1, 5);
                this.modeloGrid.setValueAt("0", fila - 1, 6);
            }
        }
    }

    public void cargarAgenda() {
        Refrescar();
        limpiarListaDiasConCita();
        montarAgendaGeneral();
        montarAgendaEspecial();
        montarAgendaExcepcion();
    }

    private void cargarNoCitaIps() {
        this.sql = "SELECT NoCita FROM g_ips";
        this.NoCitaIps = this.consultas.traerDato(this.sql);
        this.consultas.cerrarConexionBd();
    }

    private void cargarDiasFestivos() {
        try {
            this.sql = "SELECT FechaFestivo FROM g_diafestivo where Estado=1 ORDER BY FechaFestivo Asc";
            this.rs = this.consultas.traerRs(this.sql);
            this.rs.last();
            this.lisDiasFestivos = new String[this.rs.getRow()];
            int i = 0;
            this.rs.beforeFirst();
            while (this.rs.next()) {
                this.lisDiasFestivos[i] = this.rs.getString(1);
                i++;
            }
            this.rs.close();
            this.consultas.cerrarConexionBd();
        } catch (SQLException ex) {
            this.consultas.mostrarErrorSQL(ex);
        }
    }

    private int contarEspacioParaAsignarCita(int duracion) {
        int contador = 0;
        int fila = this.filaGrid;
        int resultado = 0;
        for (int espacio = this.filaGrid; espacio < this.grid.getRowCount() && (this.modeloGrid.getValueAt(fila, 2) == null || this.modeloGrid.getValueAt(fila, 2) == " "); espacio++) {
            contador++;
            fila++;
        }
        if (contador * 5 >= duracion) {
            resultado = 1;
        } else {
            this.metodos.mostrarMensaje("No se puede asignar la Cita en ese horario.\n El tiempo asignado a la Clase de Cita es de : " + duracion + "\nEl tiempo disponible de Cita es de : " + (contador * 5));
        }
        return resultado;
    }

    public void crearGrid() {
        this.modeloGrid = new DefaultTableModel() { // from class: Citas.CitaInterconsulta.2
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.modeloGrid.addColumn("DESDE");
        this.modeloGrid.addColumn("HASTA");
        this.modeloGrid.addColumn("USUARIO");
        this.modeloGrid.addColumn("");
        this.modeloGrid.addColumn("");
        this.modeloGrid.addColumn("");
        this.modeloGrid.addColumn("");
        this.modeloGrid.addColumn("");
        this.modeloGrid.addColumn("");
        this.grid.setModel(this.modeloGrid);
        this.grid.getColumnModel().getColumn(0).setPreferredWidth(90);
        this.grid.getColumnModel().getColumn(1).setPreferredWidth(90);
        this.grid.getColumnModel().getColumn(2).setPreferredWidth(500);
        this.grid.getColumnModel().getColumn(3).setPreferredWidth(0);
        this.grid.getColumnModel().getColumn(3).setMinWidth(0);
        this.grid.getColumnModel().getColumn(3).setMaxWidth(0);
        this.grid.getColumnModel().getColumn(4).setPreferredWidth(0);
        this.grid.getColumnModel().getColumn(4).setMinWidth(0);
        this.grid.getColumnModel().getColumn(4).setMaxWidth(0);
        this.grid.getColumnModel().getColumn(5).setPreferredWidth(0);
        this.grid.getColumnModel().getColumn(5).setMinWidth(0);
        this.grid.getColumnModel().getColumn(5).setMaxWidth(0);
        this.grid.getColumnModel().getColumn(6).setPreferredWidth(0);
        this.grid.getColumnModel().getColumn(6).setMinWidth(0);
        this.grid.getColumnModel().getColumn(6).setMaxWidth(0);
        this.grid.getColumnModel().getColumn(7).setPreferredWidth(0);
        this.grid.getColumnModel().getColumn(7).setMinWidth(0);
        this.grid.getColumnModel().getColumn(7).setMaxWidth(0);
        this.grid.getColumnModel().getColumn(8).setPreferredWidth(0);
        this.grid.getColumnModel().getColumn(8).setMinWidth(0);
        this.grid.getColumnModel().getColumn(8).setMaxWidth(0);
    }

    private void desistir() {
        if (this.txtNoCita.getText() == null || this.txtNoCita.getText().isEmpty() || this.txtNoCita.getText().equals("")) {
            this.metodos.mostrarMensaje("Por favor selecione una Cita para Anular");
            return;
        }
        this.mnPopup.setVisible(false);
        Anular frm = new Anular(null, true, "CitaInterconsulta", 7);
        frm.setVisible(true);
    }

    private void cargarProgCalendario() {
        limpiarGrid();
        setProfesional();
        cargarAgenda();
    }

    public String getHora(int hInicial, int min) {
        String hora;
        if (hInicial < 10) {
            if (min < 10) {
                hora = this.metodos.formatoHora12("0" + String.valueOf(hInicial) + ":0" + String.valueOf(min));
            } else {
                hora = this.metodos.formatoHora12("0" + String.valueOf(hInicial) + ":" + String.valueOf(min));
            }
        } else if (min < 10) {
            hora = this.metodos.formatoHora12(String.valueOf(hInicial) + ":0" + String.valueOf(min));
        } else {
            hora = this.metodos.formatoHora12(String.valueOf(hInicial) + ":" + String.valueOf(min));
        }
        return hora;
    }

    public void grabar() {
        if (validarCampos() == 1 && this.grabarCita == 1) {
            grabarCita();
            this.grabarCita = 0;
            if (this.metodos.getPregunta("Desea recordatorio de cita") == 0) {
                imprimirCita();
            }
        }
    }

    public void grabarCita() {
        String horaI = this.grid.getValueAt(this.filaGrid, 0).toString().substring(0, 5);
        if (this.grid.getValueAt(this.filaGrid, 0).toString().substring(6, 8).equals("PM")) {
            horaI = String.valueOf(12 + Integer.parseInt(this.grid.getValueAt(this.filaGrid, 0).toString().substring(0, 2))) + ":" + this.grid.getValueAt(this.filaGrid, 0).toString().substring(3, 5);
        }
        String horaF = this.metodos.sumarHoras24(horaI, this.txtDuracion.getText());
        int guardar = verificarFechaHoraProfesionalEspecialidad(horaI);
        if (guardar == 1) {
            this.metodos.mostrarMensaje("Acaban de asignar una Cita en la misma fecha, a la misma hora con el mismo profesional.\nPor favor seleccione otra hora para realizar la asignación.");
            return;
        }
        this.sql = "INSERT INTO c_citas (Id_Profesional, Id_Especialidad, Id_Usuario, Id_EmpresaCont, Id_ClaseCita, Fecha_Cita, HoraInicial, HoraFinal, Telefonica, Remitida, PrimerVez, Asistida, Fecha, UsuarioS) VALUES ('" + this.idProfesional + "','" + this.idEspecialD + "','" + this.idPaciente + "','" + this.idEps + "','" + this.listaClaseCita[this.cboClaseCita.getSelectedIndex()][0] + "','" + this.metodos.formatoAMD.format(this.fechaCalendario.getTime()) + "','" + horaI + "','" + horaF + "','0','" + this.IdRemision + "','0','0','" + this.metodos.formatoAMDH24.format(this.fechaActual.getTime()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
        this.txtNoCita.setText(this.consultas.ejecutarSQLId(this.sql));
        Principal.txtNo.setText(this.txtNoCita.getText());
        this.consultas.cerrarConexionBd();
        this.grid.setValueAt(horaF, this.filaGrid, 1);
        this.grid.setValueAt(this.txtNoCita.getText(), this.filaGrid, 3);
        this.sql = "UPDATE g_ips SET g_ips.NoCita = '" + this.txtNoCita.getText() + "', IdProfesionalUltimaCita ='" + this.listaProfesional[this.cboProfesional.getSelectedIndex()] + "'";
        this.consultas.ejecutarSQL(this.sql);
        this.consultas.cerrarConexionBd();
        grabarRemision();
        cargarHorarioGrid();
        this.consultas.cerrarConexionBd();
        this.metodos.mostrarMensaje("Cita Grabada, Ok");
    }

    public void grabarRemision() {
        this.sql = "UPDATE h_remisiones SET Id_Cita = '" + this.txtNoCita.getText() + "' WHERE Id = '" + this.IdRemision + "'";
        this.consultas.ejecutarSQL(this.sql);
        this.consultas.cerrarConexionBd();
    }

    public void imprimirCita() {
        String[][] parametros = new String[5][2];
        parametros[0][0] = "numero";
        parametros[0][1] = Principal.txtNo.getText();
        parametros[1][0] = "nbreUsuario";
        parametros[1][1] = Principal.usuarioSistemaDTO.getNombreUsuario();
        parametros[2][0] = "ruta";
        parametros[2][1] = this.metodos.getRutaRep();
        parametros[3][0] = "SUBREPORT_DIR";
        parametros[3][1] = this.metodos.getSO() + this.metodos.getBarra() + "Reportes" + this.metodos.getBarra();
        parametros[4][0] = "SUBREPORTFIRMA_DIR";
        parametros[4][1] = this.metodos.getSO() + this.metodos.getBarra() + "Firmas" + this.metodos.getBarra();
        if (Principal.informacionIps.getEsFpz().intValue() == 0) {
            this.metodos.GenerarPDF(this.metodos.getRutaRep() + "C_RecordatorioDeCita", parametros);
        } else if (Principal.informacionIps.getNombreIps().equals("CLINICA OFTALMOLOGICA DAJUD SAS") || Principal.informacionIps.getNombreIps().equals("COD-OPTICA UT") || Principal.informacionIps.getNombreIps().equals("JAIME CESAR DAJUD FERNANDEZ")) {
            this.metodos.GenerarPDF(this.metodos.getRutaRep() + "C_RecordatorioDeCita1_Dajud", parametros);
        } else {
            this.metodos.GenerarPDF(this.metodos.getRutaRep() + "C_RecordatorioDeCita1", parametros);
        }
    }

    public void limpiarGrid() {
        crearGrid();
    }

    private void limpiarListaDiasConCita() {
        for (int i = 0; i < 1000; i++) {
            this.listaDiasConCita[i][0] = null;
            this.listaDiasConCita[i][1] = null;
            this.listaDiasConCita[i][2] = null;
            this.listaDiasConCita[i][3] = null;
            this.listaDiasConCita[i][4] = null;
            this.listaDiasConCita[i][5] = null;
            this.listaDiasConCita[i][6] = null;
        }
    }

    private void modificarCita() {
        String horaI = this.metodos.pasarHora12a24(this.modeloGrid.getValueAt(this.filaGrid, 0).toString());
        String horaF = this.metodos.sumarHoras24(horaI, this.txtDuracion.getText());
        this.sql = "UPDATE c_citas SET Id_Profesional ='" + this.listaProfesional[this.cboProfesional.getSelectedIndex()] + "', Id_Especialidad ='" + this.idEspecialD + "', Id_ClaseCita ='" + this.listaClaseCita[this.cboClaseCita.getSelectedIndex()][0] + "', Fecha_Cita ='" + this.metodos.formatoAMD.format(this.fechaCalendario.getTime()) + "', HoraInicial ='" + horaI.substring(0, 5) + "', HoraFinal ='" + horaF + "', Fecha ='" + this.metodos.formatoAMDH24.format(this.fechaActual.getTime()) + "', UsuarioS ='" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "' WHERE Id = '" + this.NoCitaAReasignar + "'";
        this.consultas.ejecutarSQL(this.sql);
        this.consultas.cerrarConexionBd();
        this.idReasignar = 0;
        this.NoCitaAReasignar = "";
        cargarHorarioGrid();
        this.metodos.mostrarMensaje("Cita Reasignada, Ok");
    }

    private void montarAgendaGeneral() {
        this.sql = "SELECT c_confcitas.Fecha_ConfCitas, c_confcitas.DiaSemana, c_confcitas.Id_Consultorio, c_confcitas.HoraInicial, c_confcitas.HoraFinal, c_consultorio.Nbre, c_confcitas.Cupo FROM baseserver.c_confcitas INNER JOIN baseserver.c_consultorio ON (c_confcitas.Id_Consultorio = c_consultorio.Id) WHERE (c_confcitas.Id_Profesional ='" + this.idProfesional + "' AND c_confcitas.Id_Especialidad ='" + this.idEspecialD + "' AND TipoAgenda = 1 AND c_confcitas.TipoAgenda = 1 AND c_confcitas.Estado = 0 AND c_confcitas.AgendaGralUltConf = 1) ORDER BY c_confcitas.Fecha_ConfCitas ASC, c_confcitas.DiaSemana ASC, c_confcitas.HoraInicial ASC";
        this.rs = this.consultas.traerRs(this.sql);
        try {
            this.filaListaDiasConCita = 0;
            while (this.rs.next()) {
                if (Integer.valueOf(this.xAno).intValue() > Integer.parseInt(this.rs.getString(1).substring(0, 4))) {
                    for (int f = this.rs.getInt(2); f <= 42; f += 7) {
                        if (f >= Integer.parseInt(this.rs.getString(1).substring(8, 10))) {
                            if (this.filaListaDiasConCita > 1000) {
                                break;
                            }
                            this.boton = panelDias.getComponent(f);
                            if (this.boton.isEnabled()) {
                                int montarDia = 0;
                                this.fechaCalendario.set(Integer.valueOf(this.xAno).intValue(), Integer.valueOf(this.xMes).intValue(), Integer.parseInt(this.boton.getText()));
                                for (int df = 0; df < this.lisDiasFestivos.length; df++) {
                                    if (this.lisDiasFestivos[df].equals(this.metodos.formatoAMD1.format(this.fechaCalendario.getTime()).toString())) {
                                        montarDia = 1;
                                    }
                                }
                                if (montarDia == 0) {
                                    this.boton.setFont(new Font("Arial", 0, 12));
                                    this.boton.setForeground(new Color(0, 0, 102));
                                    this.boton.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Cita.png")));
                                    this.listaDiasConCita[this.filaListaDiasConCita][0] = this.boton.getText();
                                    this.listaDiasConCita[this.filaListaDiasConCita][1] = this.rs.getString(3);
                                    this.listaDiasConCita[this.filaListaDiasConCita][2] = this.rs.getString(4);
                                    this.listaDiasConCita[this.filaListaDiasConCita][3] = this.rs.getString(5);
                                    this.listaDiasConCita[this.filaListaDiasConCita][4] = this.rs.getString(6);
                                    this.listaDiasConCita[this.filaListaDiasConCita][5] = "1";
                                    this.listaDiasConCita[this.filaListaDiasConCita][6] = this.rs.getString(7);
                                    this.filaListaDiasConCita++;
                                } else {
                                    this.boton.setForeground(new Color(204, 0, 0));
                                    this.boton.setFont(new Font("Arial", 1, 12));
                                }
                            }
                        }
                    }
                } else if (Integer.valueOf(this.xAno).intValue() == Integer.parseInt(this.rs.getString(1).substring(0, 4)) && Integer.valueOf(this.xMes).intValue() + 1 >= Integer.parseInt(this.rs.getString(1).substring(5, 7))) {
                    for (int f2 = this.rs.getInt(2); f2 <= 42; f2 += 7) {
                        if (f2 >= Integer.parseInt(this.rs.getString(1).substring(8, 10))) {
                            if (this.filaListaDiasConCita > 1000) {
                                break;
                            }
                            this.boton = panelDias.getComponent(f2);
                            if (this.boton.isEnabled()) {
                                int montarDia2 = 0;
                                this.fechaCalendario.set(Integer.valueOf(this.xAno).intValue(), Integer.valueOf(this.xMes).intValue(), Integer.parseInt(this.boton.getText()));
                                for (int df2 = 0; df2 < this.lisDiasFestivos.length; df2++) {
                                    if (this.lisDiasFestivos[df2].equals(this.metodos.formatoAMD1.format(this.fechaCalendario.getTime()).toString())) {
                                        montarDia2 = 1;
                                    }
                                }
                                if (montarDia2 == 0) {
                                    this.boton.setFont(new Font("Arial", 0, 12));
                                    this.boton.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Cita.png")));
                                    this.listaDiasConCita[this.filaListaDiasConCita][0] = this.boton.getText();
                                    this.listaDiasConCita[this.filaListaDiasConCita][1] = this.rs.getString(3);
                                    this.listaDiasConCita[this.filaListaDiasConCita][2] = this.rs.getString(4);
                                    this.listaDiasConCita[this.filaListaDiasConCita][3] = this.rs.getString(5);
                                    this.listaDiasConCita[this.filaListaDiasConCita][4] = this.rs.getString(6);
                                    this.listaDiasConCita[this.filaListaDiasConCita][5] = "1";
                                    this.listaDiasConCita[this.filaListaDiasConCita][6] = this.rs.getString(7);
                                    this.filaListaDiasConCita++;
                                } else {
                                    this.boton.setForeground(new Color(204, 0, 0));
                                    this.boton.setFont(new Font("Arial", 1, 12));
                                }
                            }
                        }
                    }
                }
            }
            this.rs.close();
            this.consultas.cerrarConexionBd();
        } catch (SQLException ex) {
            this.consultas.mostrarErrorSQL(ex);
        }
    }

    private void montarAgendaEspecial() {
        this.sql = "SELECT c_confcitas.Fecha_ConfCitas, c_confcitas.Id_Consultorio, c_confcitas.HoraInicial, c_confcitas.HoraFinal, c_consultorio.Nbre, c_confcitas.Id_Profesional, c_confcitas.Cupo FROM baseserver.c_consultorio INNER JOIN baseserver.c_confcitas ON (c_consultorio.Id = c_confcitas.Id_Consultorio) WHERE (MONTH(c_confcitas.Fecha_ConfCitas) ='" + (Integer.valueOf(this.xMes).intValue() + 1) + "' AND YEAR(c_confcitas.Fecha_ConfCitas) ='" + Integer.valueOf(this.xAno) + "' AND c_confcitas.TipoAgenda =2 AND c_confcitas.Id_Profesional ='" + this.idProfesional + "' AND c_confcitas.Id_Especialidad ='" + this.idEspecialD + "' AND c_confcitas.Estado = 0) ORDER BY c_confcitas.Fecha_ConfCitas ASC, c_confcitas.HoraInicial ASC";
        this.rs = this.consultas.traerRs(this.sql);
        try {
            this.rs.next();
            if (this.rs.getRow() > 0) {
                this.rs.beforeFirst();
                while (this.rs.next()) {
                    int u = Integer.parseInt(this.rs.getString(1).substring(8, 10)) - 1;
                    while (true) {
                        if (u < 42) {
                            this.boton = panelDias.getComponent(u);
                            if (this.boton.getText() == null || Integer.parseInt(this.boton.getText()) != Integer.parseInt(this.rs.getString(1).substring(8, 10)) || !this.boton.isEnabled()) {
                                u++;
                            } else {
                                this.boton.setIcon(new ImageIcon(getClass().getResource("/Imagenes/CitaEspecial.png")));
                                this.listaDiasConCita[this.filaListaDiasConCita][0] = this.boton.getText();
                                this.listaDiasConCita[this.filaListaDiasConCita][1] = this.rs.getString(2);
                                this.listaDiasConCita[this.filaListaDiasConCita][2] = this.rs.getString(3);
                                this.listaDiasConCita[this.filaListaDiasConCita][3] = this.rs.getString(4);
                                this.listaDiasConCita[this.filaListaDiasConCita][4] = this.rs.getString(5);
                                this.listaDiasConCita[this.filaListaDiasConCita][5] = "2";
                                this.listaDiasConCita[this.filaListaDiasConCita][6] = this.rs.getString(7);
                                this.filaListaDiasConCita++;
                                break;
                            }
                        }
                    }
                }
            }
            this.rs.close();
            this.consultas.cerrarConexionBd();
        } catch (SQLException ex) {
            this.consultas.mostrarErrorSQL(ex);
        }
    }

    private void montarAgendaExcepcion() {
        this.sql = "SELECT c_confcitas.Fecha_ConfCitas, c_confcitas.Id_Consultorio, c_confcitas.HoraInicial, c_confcitas.HoraFinal, c_consultorio.Nbre, c_confcitas.Id_Profesional, c_confcitas.Cupo FROM baseserver.c_consultorio INNER JOIN baseserver.c_confcitas ON (c_consultorio.Id = c_confcitas.Id_Consultorio) WHERE (MONTH(c_confcitas.Fecha_ConfCitas) ='" + (Integer.valueOf(this.xMes).intValue() + 1) + "' AND YEAR(c_confcitas.Fecha_ConfCitas) ='" + Integer.valueOf(this.xAno) + "' AND c_confcitas.TipoAgenda =3 AND c_confcitas.Id_Profesional ='" + this.idProfesional + "' AND c_confcitas.Id_Especialidad ='" + this.idEspecialD + "' AND c_confcitas.Estado = 0) ORDER BY c_confcitas.Fecha_ConfCitas ASC, c_confcitas.HoraInicial ASC";
        this.rs = this.consultas.traerRs(this.sql);
        try {
            this.rs.last();
            if (this.rs.getRow() > 0) {
                this.rs.beforeFirst();
                while (this.rs.next()) {
                    int u = Integer.parseInt(this.rs.getString(1).substring(8, 10)) - 1;
                    while (true) {
                        if (u < 42) {
                            this.boton = panelDias.getComponent(u);
                            if (this.boton.getText() == null || Integer.parseInt(this.boton.getText()) != Integer.parseInt(this.rs.getString(1).substring(8, 10)) || !this.boton.isEnabled()) {
                                u++;
                            } else {
                                this.boton.setIcon(new ImageIcon(getClass().getResource("/Imagenes/CitaExcepcion.png")));
                                this.listaDiasConCita[this.filaListaDiasConCita][0] = this.boton.getText();
                                this.listaDiasConCita[this.filaListaDiasConCita][1] = this.rs.getString(2);
                                this.listaDiasConCita[this.filaListaDiasConCita][2] = this.rs.getString(3);
                                this.listaDiasConCita[this.filaListaDiasConCita][3] = this.rs.getString(4);
                                this.listaDiasConCita[this.filaListaDiasConCita][4] = this.rs.getString(5);
                                this.listaDiasConCita[this.filaListaDiasConCita][5] = "3";
                                this.listaDiasConCita[this.filaListaDiasConCita][6] = this.rs.getString(7);
                                this.filaListaDiasConCita++;
                                break;
                            }
                        }
                    }
                }
            }
            this.rs.close();
            this.consultas.cerrarConexionBd();
        } catch (SQLException ex) {
            this.consultas.mostrarErrorSQL(ex);
        }
    }

    private void reasignar() {
        this.mnPopup.setVisible(false);
        if (this.txtNoCita.getText().isEmpty() || this.txtNoCita.getText().equals("0")) {
            this.metodos.mostrarMensaje("Por favor seleccione el usuario a quien desea Reasignar la Cita.\nLuego busque el día de destino para Reasignar");
        } else {
            this.idReasignar = 1;
            this.NoCitaAReasignar = this.txtNoCita.getText();
        }
    }

    private void setFechaActual() {
        this.fechaCalendario = new GregorianCalendar();
        this.xAno = String.valueOf(this.fechaCalendario.get(1));
        this.xMes = String.valueOf(this.fechaCalendario.get(2) + 1);
        this.xDia = String.valueOf(this.fechaCalendario.get(5));
    }

    private void setProfesional() {
        this.idProfesional = this.listaProfesional[this.cboProfesional.getSelectedIndex()];
        this.nbreProfesional = this.cboProfesional.getSelectedItem().toString();
    }

    private int validarCampos() {
        int validar = 0;
        if (this.cboProfesional.getSelectedIndex() > -1 && this.grabarCita == 0) {
            this.metodos.mostrarMensaje("Por favor Asigne una Cita antes de grabar.");
            this.cboProfesional.requestFocus();
        } else if (this.cboClaseCita.getSelectedIndex() < 0 && this.grabarCita == 1) {
            this.metodos.mostrarMensaje("Por favor seleccione la Clase de Cita.");
            this.cboClaseCita.requestFocus();
        } else {
            validar = 1;
        }
        return validar;
    }

    private int verificarFechaHoraProfesionalEspecialidad(String horaI) {
        int op = 0;
        this.sql = "SELECT Id FROM c_citas WHERE (Id_Profesional ='" + this.idProfesional + "' AND Id_Especialidad ='" + this.idEspecialD + "' AND Fecha_Cita ='" + this.metodos.formatoAMD.format(this.fechaCalendario.getTime()) + "' AND HoraInicial ='" + horaI + "' AND Id_MotivoDesistida =1)";
        String campo = this.consultas.traerDato(this.sql);
        if (!campo.isEmpty()) {
            op = 1;
        }
        this.consultas.cerrarConexionBd();
        return op;
    }

    private boolean verificarFechaHoraProfesionalEspecialidad() {
        boolean op = true;
        String horaI = null;
        if (this.grid.getValueAt(this.filaGrid, 0).toString().substring(6, 8).equals("PM")) {
            horaI = String.valueOf(12 + Integer.parseInt(this.grid.getValueAt(this.filaGrid, 0).toString().substring(0, 2))) + ":" + this.grid.getValueAt(this.filaGrid, 0).toString().substring(3, 5);
        }
        this.sql = "SELECT Id FROM c_citas WHERE (Id_Profesional ='" + this.idProfesional + "' AND Id_Especialidad ='" + this.idEspecialD + "' AND Fecha_Cita ='" + this.metodos.formatoAMD.format(this.fechaCalendario.getTime()) + "' AND HoraInicial ='" + horaI + "' AND Id_MotivoDesistida =1)";
        ResultSet rs1 = this.consultas.traerRs(this.sql);
        try {
            if (rs1.next()) {
                op = false;
            }
            rs1.close();
            this.consultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(CitasGral.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return op;
    }

    /* JADX INFO: loaded from: GenomaP.jar:Citas/CitaInterconsulta$MiRender.class */
    public static class MiRender extends DefaultTableCellRenderer {
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            String trabajador = table.getValueAt(row, 6).toString();
            if (trabajador != null && trabajador.equals("1")) {
                cell.setBackground(new Color(255, 255, 204));
            } else {
                cell.setBackground(Color.WHITE);
            }
            String m = table.getValueAt(row, 8).toString();
            if (m != null && Integer.parseInt(m) < 125) {
                cell.setBackground(new Color(204, 255, 204));
            }
            return cell;
        }
    }

    /* JADX WARN: Type inference failed for: r3v272, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.mnPopup = new JPopupMenu();
        this.mnAsignar = new JMenuItem();
        this.mnReasignar = new JMenuItem();
        this.mnDesistir = new JMenuItem();
        this.jSeparator1 = new JSeparator();
        this.mnRecordatorio = new JMenuItem();
        this.jSeparator2 = new JSeparator();
        this.mnSalir = new JMenuItem();
        this.jPanel5 = new JPanel();
        this.panelCalendario = new JPanel();
        this.jLabel26 = new JLabel();
        this.cboMes = new JComboBox();
        this.txtAno = new JSpinner();
        this.jPanel4 = new JPanel();
        this.jLabel10 = new JLabel();
        this.jLabel11 = new JLabel();
        this.jLabel12 = new JLabel();
        this.jLabel13 = new JLabel();
        this.jLabel14 = new JLabel();
        this.jLabel15 = new JLabel();
        this.jLabel16 = new JLabel();
        panelDias = new JPanel();
        this.btn1 = new JButton();
        this.btn2 = new JButton();
        this.btn3 = new JButton();
        this.btn4 = new JButton();
        this.btn5 = new JButton();
        this.btn6 = new JButton();
        this.btn7 = new JButton();
        this.btn8 = new JButton();
        this.btn9 = new JButton();
        this.btn10 = new JButton();
        this.btn11 = new JButton();
        this.btn12 = new JButton();
        this.btn13 = new JButton();
        this.btn14 = new JButton();
        this.btn15 = new JButton();
        this.btn16 = new JButton();
        this.btn17 = new JButton();
        this.btn18 = new JButton();
        this.btn19 = new JButton();
        this.btn20 = new JButton();
        this.btn21 = new JButton();
        this.btn22 = new JButton();
        this.btn23 = new JButton();
        this.btn24 = new JButton();
        this.btn25 = new JButton();
        this.btn26 = new JButton();
        this.btn27 = new JButton();
        this.btn28 = new JButton();
        this.btn29 = new JButton();
        this.btn30 = new JButton();
        this.btn31 = new JButton();
        this.btn32 = new JButton();
        this.btn33 = new JButton();
        this.btn34 = new JButton();
        this.btn35 = new JButton();
        this.btn36 = new JButton();
        this.btn37 = new JButton();
        this.btn38 = new JButton();
        this.btn39 = new JButton();
        this.btn40 = new JButton();
        this.btn41 = new JButton();
        this.btn42 = new JButton();
        this.txtHoy = new JLabel();
        this.jPanel1 = new JPanel();
        this.cboClaseCita = new JComboBox();
        this.jLabel2 = new JLabel();
        this.txtDuracion = new JTextField();
        this.jLabel3 = new JLabel();
        txtConsultorio = new JTextField();
        this.cboProfesional = new JComboBox();
        this.jLabel6 = new JLabel();
        this.jPanel3 = new JPanel();
        this.jLabel4 = new JLabel();
        this.txtNoCita = new JTextField();
        this.jLabel8 = new JLabel();
        this.btnSalir = new JButton();
        this.jScrollPane3 = new JScrollPane();
        this.grid = new JTable();
        this.lblFecha = new JLabel();
        this.mnPopup.setForeground(new Color(0, 102, 102));
        this.mnPopup.setBorder(BorderFactory.createTitledBorder((Border) null, "Menú de Citas", 2, 0, new Font("Tahoma", 1, 11), new Color(0, 102, 102)));
        this.mnPopup.setLabel("menu");
        this.mnPopup.setName("mnPopup");
        this.mnAsignar.setText("Asignar Cita");
        this.mnAsignar.setBorder((Border) null);
        this.mnAsignar.addActionListener(new ActionListener() { // from class: Citas.CitaInterconsulta.3
            public void actionPerformed(ActionEvent evt) {
                CitaInterconsulta.this.mnAsignarActionPerformed(evt);
            }
        });
        this.mnPopup.add(this.mnAsignar);
        this.mnReasignar.setText("Reasignar Cita");
        this.mnReasignar.addActionListener(new ActionListener() { // from class: Citas.CitaInterconsulta.4
            public void actionPerformed(ActionEvent evt) {
                CitaInterconsulta.this.mnReasignarActionPerformed(evt);
            }
        });
        this.mnPopup.add(this.mnReasignar);
        this.mnDesistir.setText("Desistir Cita");
        this.mnDesistir.addActionListener(new ActionListener() { // from class: Citas.CitaInterconsulta.5
            public void actionPerformed(ActionEvent evt) {
                CitaInterconsulta.this.mnDesistirActionPerformed(evt);
            }
        });
        this.mnPopup.add(this.mnDesistir);
        this.mnPopup.add(this.jSeparator1);
        this.mnRecordatorio.setText("Imprimir Recordatorio de Cita");
        this.mnRecordatorio.addActionListener(new ActionListener() { // from class: Citas.CitaInterconsulta.6
            public void actionPerformed(ActionEvent evt) {
                CitaInterconsulta.this.mnRecordatorioActionPerformed(evt);
            }
        });
        this.mnPopup.add(this.mnRecordatorio);
        this.mnPopup.add(this.jSeparator2);
        this.mnSalir.setText("Salir");
        this.mnSalir.addActionListener(new ActionListener() { // from class: Citas.CitaInterconsulta.7
            public void actionPerformed(ActionEvent evt) {
                CitaInterconsulta.this.mnSalirActionPerformed(evt);
            }
        });
        this.mnPopup.add(this.mnSalir);
        this.mnPopup.getAccessibleContext().setAccessibleParent(this);
        setTitle("PROGRAMACIÓN DE CITAS");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("CitaInterconsulta");
        this.jPanel5.setBorder(BorderFactory.createBevelBorder(0));
        this.jPanel5.setLayout((LayoutManager) null);
        this.panelCalendario.setBorder(BorderFactory.createEtchedBorder(0));
        this.panelCalendario.setLayout((LayoutManager) null);
        this.jLabel26.setBackground(new Color(0, 0, 153));
        this.jLabel26.setFont(new Font("Arial", 1, 12));
        this.jLabel26.setForeground(new Color(204, 204, 255));
        this.jLabel26.setHorizontalAlignment(0);
        this.jLabel26.setText("CALENDARIO");
        this.jLabel26.setBorder(BorderFactory.createBevelBorder(0));
        this.jLabel26.setOpaque(true);
        this.panelCalendario.add(this.jLabel26);
        this.jLabel26.setBounds(10, 10, 290, 20);
        this.cboMes.setFont(new Font("Arial", 1, 12));
        this.cboMes.setModel(new DefaultComboBoxModel(new String[]{"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"}));
        JComboBox jComboBox = this.cboMes;
        Calendar.getInstance();
        jComboBox.setSelectedIndex(2);
        this.cboMes.addActionListener(new ActionListener() { // from class: Citas.CitaInterconsulta.8
            public void actionPerformed(ActionEvent evt) {
                CitaInterconsulta.this.cboMesActionPerformed(evt);
            }
        });
        this.panelCalendario.add(this.cboMes);
        this.cboMes.setBounds(10, 30, 169, 25);
        this.txtAno.setFont(new Font("Arial", 1, 12));
        this.txtAno.addChangeListener(new ChangeListener() { // from class: Citas.CitaInterconsulta.9
            public void stateChanged(ChangeEvent evt) {
                CitaInterconsulta.this.txtAnoStateChanged(evt);
            }
        });
        this.panelCalendario.add(this.txtAno);
        this.txtAno.setBounds(190, 30, 110, 25);
        this.jPanel4.setBackground(new Color(0, 0, 153));
        this.jPanel4.setBorder(BorderFactory.createBevelBorder(0, Color.white, Color.white, (Color) null, (Color) null));
        this.jPanel4.setLayout((LayoutManager) null);
        this.jLabel10.setFont(new Font("Arial", 1, 12));
        this.jLabel10.setForeground(new Color(255, 255, 255));
        this.jLabel10.setText("Lun");
        this.jPanel4.add(this.jLabel10);
        this.jLabel10.setBounds(60, 0, 21, 15);
        this.jLabel11.setFont(new Font("Arial", 1, 12));
        this.jLabel11.setForeground(new Color(255, 255, 255));
        this.jLabel11.setText("Mar");
        this.jPanel4.add(this.jLabel11);
        this.jLabel11.setBounds(100, 0, 30, 15);
        this.jLabel12.setFont(new Font("Arial", 1, 12));
        this.jLabel12.setForeground(new Color(255, 255, 255));
        this.jLabel12.setText("Mie");
        this.jPanel4.add(this.jLabel12);
        this.jLabel12.setBounds(140, 0, 30, 15);
        this.jLabel13.setFont(new Font("Arial", 1, 12));
        this.jLabel13.setForeground(new Color(255, 255, 255));
        this.jLabel13.setText("Vie");
        this.jPanel4.add(this.jLabel13);
        this.jLabel13.setBounds(220, 0, 30, 15);
        this.jLabel14.setFont(new Font("Arial", 1, 12));
        this.jLabel14.setForeground(new Color(255, 255, 255));
        this.jLabel14.setText("Jue");
        this.jPanel4.add(this.jLabel14);
        this.jLabel14.setBounds(180, 0, 30, 15);
        this.jLabel15.setFont(new Font("Arial", 1, 12));
        this.jLabel15.setForeground(new Color(204, 0, 102));
        this.jLabel15.setText("Dom");
        this.jPanel4.add(this.jLabel15);
        this.jLabel15.setBounds(10, 0, 30, 15);
        this.jLabel16.setFont(new Font("Arial", 1, 12));
        this.jLabel16.setForeground(new Color(255, 255, 255));
        this.jLabel16.setText("Sab");
        this.jPanel4.add(this.jLabel16);
        this.jLabel16.setBounds(250, 0, 30, 15);
        this.panelCalendario.add(this.jPanel4);
        this.jPanel4.setBounds(10, 60, 296, 20);
        panelDias.setBorder(BorderFactory.createBevelBorder(0));
        panelDias.setName("panelDias");
        panelDias.setPreferredSize(new Dimension(100, 100));
        panelDias.setLayout((LayoutManager) null);
        this.btn1.setFont(new Font("Arial", 1, 12));
        this.btn1.setForeground(new Color(204, 0, 0));
        this.btn1.setText("1");
        this.btn1.setBorder((Border) null);
        this.btn1.setHorizontalTextPosition(4);
        this.btn1.setIconTextGap(1);
        this.btn1.addActionListener(new ActionListener() { // from class: Citas.CitaInterconsulta.10
            public void actionPerformed(ActionEvent evt) {
                CitaInterconsulta.this.btn1ActionPerformed(evt);
            }
        });
        panelDias.add(this.btn1);
        this.btn1.setBounds(10, 10, 40, 25);
        this.btn2.setFont(new Font("Arial", 1, 12));
        this.btn2.setForeground(new Color(0, 0, 102));
        this.btn2.setText("2");
        this.btn2.setBorder((Border) null);
        this.btn2.setHorizontalTextPosition(4);
        this.btn2.setIconTextGap(1);
        this.btn2.addActionListener(new ActionListener() { // from class: Citas.CitaInterconsulta.11
            public void actionPerformed(ActionEvent evt) {
                CitaInterconsulta.this.btn2ActionPerformed(evt);
            }
        });
        panelDias.add(this.btn2);
        this.btn2.setBounds(50, 10, 40, 25);
        this.btn3.setFont(new Font("Arial", 1, 12));
        this.btn3.setForeground(new Color(0, 0, 102));
        this.btn3.setText("3");
        this.btn3.setBorder((Border) null);
        this.btn3.setHorizontalTextPosition(4);
        this.btn3.setIconTextGap(1);
        this.btn3.addActionListener(new ActionListener() { // from class: Citas.CitaInterconsulta.12
            public void actionPerformed(ActionEvent evt) {
                CitaInterconsulta.this.btn3ActionPerformed(evt);
            }
        });
        this.btn3.addFocusListener(new FocusAdapter() { // from class: Citas.CitaInterconsulta.13
            public void focusLost(FocusEvent evt) {
                CitaInterconsulta.this.btn3FocusLost(evt);
            }
        });
        panelDias.add(this.btn3);
        this.btn3.setBounds(90, 10, 40, 25);
        this.btn4.setFont(new Font("Arial", 1, 12));
        this.btn4.setForeground(new Color(0, 0, 102));
        this.btn4.setText("4");
        this.btn4.setBorder((Border) null);
        this.btn4.setHorizontalTextPosition(4);
        this.btn4.setIconTextGap(1);
        this.btn4.addActionListener(new ActionListener() { // from class: Citas.CitaInterconsulta.14
            public void actionPerformed(ActionEvent evt) {
                CitaInterconsulta.this.btn4ActionPerformed(evt);
            }
        });
        panelDias.add(this.btn4);
        this.btn4.setBounds(130, 10, 40, 25);
        this.btn5.setFont(new Font("Arial", 1, 12));
        this.btn5.setForeground(new Color(0, 0, 102));
        this.btn5.setText("5");
        this.btn5.setBorder((Border) null);
        this.btn5.setHorizontalTextPosition(4);
        this.btn5.setIconTextGap(1);
        this.btn5.addActionListener(new ActionListener() { // from class: Citas.CitaInterconsulta.15
            public void actionPerformed(ActionEvent evt) {
                CitaInterconsulta.this.btn5ActionPerformed(evt);
            }
        });
        panelDias.add(this.btn5);
        this.btn5.setBounds(170, 10, 40, 25);
        this.btn6.setFont(new Font("Arial", 1, 12));
        this.btn6.setForeground(new Color(0, 0, 102));
        this.btn6.setText("6");
        this.btn6.setBorder((Border) null);
        this.btn6.setHorizontalTextPosition(4);
        this.btn6.setIconTextGap(1);
        this.btn6.addActionListener(new ActionListener() { // from class: Citas.CitaInterconsulta.16
            public void actionPerformed(ActionEvent evt) {
                CitaInterconsulta.this.btn6ActionPerformed(evt);
            }
        });
        panelDias.add(this.btn6);
        this.btn6.setBounds(210, 10, 40, 25);
        this.btn7.setFont(new Font("Arial", 1, 12));
        this.btn7.setForeground(new Color(0, 0, 102));
        this.btn7.setText("7");
        this.btn7.setBorder((Border) null);
        this.btn7.setHorizontalTextPosition(4);
        this.btn7.setIconTextGap(1);
        this.btn7.addActionListener(new ActionListener() { // from class: Citas.CitaInterconsulta.17
            public void actionPerformed(ActionEvent evt) {
                CitaInterconsulta.this.btn7ActionPerformed(evt);
            }
        });
        panelDias.add(this.btn7);
        this.btn7.setBounds(250, 10, 35, 25);
        this.btn8.setFont(new Font("Arial", 1, 12));
        this.btn8.setForeground(new Color(204, 0, 0));
        this.btn8.setText("8");
        this.btn8.setBorder((Border) null);
        this.btn8.setHorizontalTextPosition(4);
        this.btn8.setIconTextGap(1);
        this.btn8.addActionListener(new ActionListener() { // from class: Citas.CitaInterconsulta.18
            public void actionPerformed(ActionEvent evt) {
                CitaInterconsulta.this.btn8ActionPerformed(evt);
            }
        });
        panelDias.add(this.btn8);
        this.btn8.setBounds(10, 40, 40, 25);
        this.btn9.setFont(new Font("Arial", 1, 12));
        this.btn9.setForeground(new Color(0, 0, 102));
        this.btn9.setText("9");
        this.btn9.setBorder((Border) null);
        this.btn9.setHorizontalTextPosition(4);
        this.btn9.setIconTextGap(1);
        this.btn9.addActionListener(new ActionListener() { // from class: Citas.CitaInterconsulta.19
            public void actionPerformed(ActionEvent evt) {
                CitaInterconsulta.this.btn9ActionPerformed(evt);
            }
        });
        panelDias.add(this.btn9);
        this.btn9.setBounds(50, 40, 40, 25);
        this.btn10.setFont(new Font("Arial", 1, 12));
        this.btn10.setForeground(new Color(0, 0, 102));
        this.btn10.setText("10");
        this.btn10.setBorder((Border) null);
        this.btn10.setHorizontalTextPosition(4);
        this.btn10.setIconTextGap(1);
        this.btn10.addActionListener(new ActionListener() { // from class: Citas.CitaInterconsulta.20
            public void actionPerformed(ActionEvent evt) {
                CitaInterconsulta.this.btn10ActionPerformed(evt);
            }
        });
        this.btn10.addFocusListener(new FocusAdapter() { // from class: Citas.CitaInterconsulta.21
            public void focusLost(FocusEvent evt) {
                CitaInterconsulta.this.btn10FocusLost(evt);
            }
        });
        panelDias.add(this.btn10);
        this.btn10.setBounds(90, 40, 40, 25);
        this.btn11.setFont(new Font("Arial", 1, 12));
        this.btn11.setForeground(new Color(0, 0, 102));
        this.btn11.setText("11");
        this.btn11.setBorder((Border) null);
        this.btn11.setHorizontalTextPosition(4);
        this.btn11.setIconTextGap(1);
        this.btn11.addActionListener(new ActionListener() { // from class: Citas.CitaInterconsulta.22
            public void actionPerformed(ActionEvent evt) {
                CitaInterconsulta.this.btn11ActionPerformed(evt);
            }
        });
        panelDias.add(this.btn11);
        this.btn11.setBounds(130, 40, 40, 25);
        this.btn12.setFont(new Font("Arial", 1, 12));
        this.btn12.setForeground(new Color(0, 0, 102));
        this.btn12.setText("12");
        this.btn12.setBorder((Border) null);
        this.btn12.setHorizontalTextPosition(4);
        this.btn12.setIconTextGap(1);
        this.btn12.addActionListener(new ActionListener() { // from class: Citas.CitaInterconsulta.23
            public void actionPerformed(ActionEvent evt) {
                CitaInterconsulta.this.btn12ActionPerformed(evt);
            }
        });
        panelDias.add(this.btn12);
        this.btn12.setBounds(170, 40, 40, 25);
        this.btn13.setFont(new Font("Arial", 1, 12));
        this.btn13.setForeground(new Color(0, 0, 102));
        this.btn13.setText("13");
        this.btn13.setBorder((Border) null);
        this.btn13.setHorizontalTextPosition(4);
        this.btn13.setIconTextGap(1);
        this.btn13.addActionListener(new ActionListener() { // from class: Citas.CitaInterconsulta.24
            public void actionPerformed(ActionEvent evt) {
                CitaInterconsulta.this.btn13ActionPerformed(evt);
            }
        });
        panelDias.add(this.btn13);
        this.btn13.setBounds(210, 40, 40, 25);
        this.btn14.setFont(new Font("Arial", 1, 12));
        this.btn14.setForeground(new Color(0, 0, 102));
        this.btn14.setText("14");
        this.btn14.setBorder((Border) null);
        this.btn14.setHorizontalTextPosition(4);
        this.btn14.setIconTextGap(1);
        this.btn14.addActionListener(new ActionListener() { // from class: Citas.CitaInterconsulta.25
            public void actionPerformed(ActionEvent evt) {
                CitaInterconsulta.this.btn14ActionPerformed(evt);
            }
        });
        panelDias.add(this.btn14);
        this.btn14.setBounds(250, 40, 35, 25);
        this.btn15.setFont(new Font("Arial", 1, 12));
        this.btn15.setForeground(new Color(204, 0, 0));
        this.btn15.setText("15");
        this.btn15.setBorder((Border) null);
        this.btn15.setHorizontalTextPosition(4);
        this.btn15.setIconTextGap(1);
        this.btn15.addActionListener(new ActionListener() { // from class: Citas.CitaInterconsulta.26
            public void actionPerformed(ActionEvent evt) {
                CitaInterconsulta.this.btn15ActionPerformed(evt);
            }
        });
        panelDias.add(this.btn15);
        this.btn15.setBounds(10, 70, 40, 25);
        this.btn16.setFont(new Font("Arial", 1, 12));
        this.btn16.setForeground(new Color(0, 0, 102));
        this.btn16.setText("16");
        this.btn16.setBorder((Border) null);
        this.btn16.setHorizontalTextPosition(4);
        this.btn16.setIconTextGap(1);
        this.btn16.addActionListener(new ActionListener() { // from class: Citas.CitaInterconsulta.27
            public void actionPerformed(ActionEvent evt) {
                CitaInterconsulta.this.btn16ActionPerformed(evt);
            }
        });
        panelDias.add(this.btn16);
        this.btn16.setBounds(50, 70, 40, 25);
        this.btn17.setFont(new Font("Arial", 1, 12));
        this.btn17.setForeground(new Color(0, 0, 102));
        this.btn17.setText("17");
        this.btn17.setBorder((Border) null);
        this.btn17.setHorizontalTextPosition(4);
        this.btn17.setIconTextGap(1);
        this.btn17.addActionListener(new ActionListener() { // from class: Citas.CitaInterconsulta.28
            public void actionPerformed(ActionEvent evt) {
                CitaInterconsulta.this.btn17ActionPerformed(evt);
            }
        });
        panelDias.add(this.btn17);
        this.btn17.setBounds(90, 70, 40, 25);
        this.btn18.setFont(new Font("Arial", 1, 12));
        this.btn18.setForeground(new Color(0, 0, 102));
        this.btn18.setText("18");
        this.btn18.setBorder((Border) null);
        this.btn18.setHorizontalTextPosition(4);
        this.btn18.setIconTextGap(1);
        this.btn18.addActionListener(new ActionListener() { // from class: Citas.CitaInterconsulta.29
            public void actionPerformed(ActionEvent evt) {
                CitaInterconsulta.this.btn18ActionPerformed(evt);
            }
        });
        panelDias.add(this.btn18);
        this.btn18.setBounds(130, 70, 40, 25);
        this.btn19.setFont(new Font("Arial", 1, 12));
        this.btn19.setForeground(new Color(0, 0, 102));
        this.btn19.setText("19");
        this.btn19.setBorder((Border) null);
        this.btn19.setHorizontalTextPosition(4);
        this.btn19.setIconTextGap(1);
        this.btn19.addActionListener(new ActionListener() { // from class: Citas.CitaInterconsulta.30
            public void actionPerformed(ActionEvent evt) {
                CitaInterconsulta.this.btn19ActionPerformed(evt);
            }
        });
        panelDias.add(this.btn19);
        this.btn19.setBounds(170, 70, 40, 25);
        this.btn20.setFont(new Font("Arial", 1, 12));
        this.btn20.setForeground(new Color(0, 0, 102));
        this.btn20.setText("20");
        this.btn20.setBorder((Border) null);
        this.btn20.setHorizontalTextPosition(4);
        this.btn20.setIconTextGap(1);
        this.btn20.addActionListener(new ActionListener() { // from class: Citas.CitaInterconsulta.31
            public void actionPerformed(ActionEvent evt) {
                CitaInterconsulta.this.btn20ActionPerformed(evt);
            }
        });
        panelDias.add(this.btn20);
        this.btn20.setBounds(210, 70, 40, 25);
        this.btn21.setFont(new Font("Arial", 1, 12));
        this.btn21.setForeground(new Color(0, 0, 102));
        this.btn21.setText("21");
        this.btn21.setBorder((Border) null);
        this.btn21.setHorizontalTextPosition(4);
        this.btn21.setIconTextGap(1);
        this.btn21.addActionListener(new ActionListener() { // from class: Citas.CitaInterconsulta.32
            public void actionPerformed(ActionEvent evt) {
                CitaInterconsulta.this.btn21ActionPerformed(evt);
            }
        });
        panelDias.add(this.btn21);
        this.btn21.setBounds(250, 70, 35, 25);
        this.btn22.setFont(new Font("Arial", 1, 12));
        this.btn22.setForeground(new Color(204, 0, 0));
        this.btn22.setText("22");
        this.btn22.setBorder((Border) null);
        this.btn22.setHorizontalTextPosition(4);
        this.btn22.setIconTextGap(1);
        this.btn22.addActionListener(new ActionListener() { // from class: Citas.CitaInterconsulta.33
            public void actionPerformed(ActionEvent evt) {
                CitaInterconsulta.this.btn22ActionPerformed(evt);
            }
        });
        panelDias.add(this.btn22);
        this.btn22.setBounds(10, 100, 40, 25);
        this.btn23.setFont(new Font("Arial", 1, 12));
        this.btn23.setForeground(new Color(0, 0, 102));
        this.btn23.setText("23");
        this.btn23.setBorder((Border) null);
        this.btn23.setHorizontalTextPosition(4);
        this.btn23.setIconTextGap(1);
        this.btn23.addActionListener(new ActionListener() { // from class: Citas.CitaInterconsulta.34
            public void actionPerformed(ActionEvent evt) {
                CitaInterconsulta.this.btn23ActionPerformed(evt);
            }
        });
        panelDias.add(this.btn23);
        this.btn23.setBounds(50, 100, 40, 25);
        this.btn24.setFont(new Font("Arial", 1, 12));
        this.btn24.setForeground(new Color(0, 0, 102));
        this.btn24.setText("24");
        this.btn24.setBorder((Border) null);
        this.btn24.setHorizontalTextPosition(4);
        this.btn24.setIconTextGap(1);
        this.btn24.addActionListener(new ActionListener() { // from class: Citas.CitaInterconsulta.35
            public void actionPerformed(ActionEvent evt) {
                CitaInterconsulta.this.btn24ActionPerformed(evt);
            }
        });
        panelDias.add(this.btn24);
        this.btn24.setBounds(90, 100, 40, 25);
        this.btn25.setFont(new Font("Arial", 1, 12));
        this.btn25.setForeground(new Color(0, 0, 102));
        this.btn25.setText("25");
        this.btn25.setBorder((Border) null);
        this.btn25.setHorizontalTextPosition(4);
        this.btn25.setIconTextGap(1);
        this.btn25.addActionListener(new ActionListener() { // from class: Citas.CitaInterconsulta.36
            public void actionPerformed(ActionEvent evt) {
                CitaInterconsulta.this.btn25ActionPerformed(evt);
            }
        });
        panelDias.add(this.btn25);
        this.btn25.setBounds(130, 100, 40, 25);
        this.btn26.setFont(new Font("Arial", 1, 12));
        this.btn26.setForeground(new Color(0, 0, 102));
        this.btn26.setText("26");
        this.btn26.setBorder((Border) null);
        this.btn26.setHorizontalTextPosition(4);
        this.btn26.setIconTextGap(1);
        this.btn26.addActionListener(new ActionListener() { // from class: Citas.CitaInterconsulta.37
            public void actionPerformed(ActionEvent evt) {
                CitaInterconsulta.this.btn26ActionPerformed(evt);
            }
        });
        panelDias.add(this.btn26);
        this.btn26.setBounds(170, 100, 40, 25);
        this.btn27.setFont(new Font("Arial", 1, 12));
        this.btn27.setForeground(new Color(0, 0, 102));
        this.btn27.setText("27");
        this.btn27.setBorder((Border) null);
        this.btn27.setHorizontalTextPosition(4);
        this.btn27.setIconTextGap(1);
        this.btn27.addActionListener(new ActionListener() { // from class: Citas.CitaInterconsulta.38
            public void actionPerformed(ActionEvent evt) {
                CitaInterconsulta.this.btn27ActionPerformed(evt);
            }
        });
        panelDias.add(this.btn27);
        this.btn27.setBounds(210, 100, 40, 25);
        this.btn28.setFont(new Font("Arial", 1, 12));
        this.btn28.setForeground(new Color(0, 0, 102));
        this.btn28.setText("28");
        this.btn28.setBorder((Border) null);
        this.btn28.setHorizontalTextPosition(4);
        this.btn28.setIconTextGap(1);
        this.btn28.addActionListener(new ActionListener() { // from class: Citas.CitaInterconsulta.39
            public void actionPerformed(ActionEvent evt) {
                CitaInterconsulta.this.btn28ActionPerformed(evt);
            }
        });
        panelDias.add(this.btn28);
        this.btn28.setBounds(250, 100, 35, 25);
        this.btn29.setFont(new Font("Arial", 1, 12));
        this.btn29.setForeground(new Color(204, 0, 0));
        this.btn29.setText("29");
        this.btn29.setBorder((Border) null);
        this.btn29.setHorizontalTextPosition(4);
        this.btn29.setIconTextGap(1);
        this.btn29.addActionListener(new ActionListener() { // from class: Citas.CitaInterconsulta.40
            public void actionPerformed(ActionEvent evt) {
                CitaInterconsulta.this.btn29ActionPerformed(evt);
            }
        });
        panelDias.add(this.btn29);
        this.btn29.setBounds(10, 130, 40, 25);
        this.btn30.setFont(new Font("Arial", 1, 12));
        this.btn30.setForeground(new Color(0, 0, 102));
        this.btn30.setText("30");
        this.btn30.setBorder((Border) null);
        this.btn30.setHorizontalTextPosition(4);
        this.btn30.setIconTextGap(1);
        this.btn30.addActionListener(new ActionListener() { // from class: Citas.CitaInterconsulta.41
            public void actionPerformed(ActionEvent evt) {
                CitaInterconsulta.this.btn30ActionPerformed(evt);
            }
        });
        panelDias.add(this.btn30);
        this.btn30.setBounds(50, 130, 40, 25);
        this.btn31.setFont(new Font("Arial", 1, 12));
        this.btn31.setForeground(new Color(0, 0, 102));
        this.btn31.setText("31");
        this.btn31.setBorder((Border) null);
        this.btn31.setHorizontalTextPosition(4);
        this.btn31.setIconTextGap(1);
        this.btn31.addActionListener(new ActionListener() { // from class: Citas.CitaInterconsulta.42
            public void actionPerformed(ActionEvent evt) {
                CitaInterconsulta.this.btn31ActionPerformed(evt);
            }
        });
        panelDias.add(this.btn31);
        this.btn31.setBounds(90, 130, 40, 25);
        this.btn32.setFont(new Font("Arial", 1, 12));
        this.btn32.setForeground(new Color(0, 0, 102));
        this.btn32.setText("32");
        this.btn32.setBorder((Border) null);
        this.btn32.setHorizontalTextPosition(4);
        this.btn32.setIconTextGap(1);
        this.btn32.addActionListener(new ActionListener() { // from class: Citas.CitaInterconsulta.43
            public void actionPerformed(ActionEvent evt) {
                CitaInterconsulta.this.btn32ActionPerformed(evt);
            }
        });
        panelDias.add(this.btn32);
        this.btn32.setBounds(130, 130, 40, 25);
        this.btn33.setFont(new Font("Arial", 1, 12));
        this.btn33.setForeground(new Color(0, 0, 102));
        this.btn33.setText("33");
        this.btn33.setBorder((Border) null);
        this.btn33.setHorizontalTextPosition(4);
        this.btn33.setIconTextGap(1);
        this.btn33.addActionListener(new ActionListener() { // from class: Citas.CitaInterconsulta.44
            public void actionPerformed(ActionEvent evt) {
                CitaInterconsulta.this.btn33ActionPerformed(evt);
            }
        });
        panelDias.add(this.btn33);
        this.btn33.setBounds(170, 130, 40, 25);
        this.btn34.setFont(new Font("Arial", 1, 12));
        this.btn34.setForeground(new Color(0, 0, 102));
        this.btn34.setText("34");
        this.btn34.setBorder((Border) null);
        this.btn34.setHorizontalTextPosition(4);
        this.btn34.setIconTextGap(1);
        this.btn34.addActionListener(new ActionListener() { // from class: Citas.CitaInterconsulta.45
            public void actionPerformed(ActionEvent evt) {
                CitaInterconsulta.this.btn34ActionPerformed(evt);
            }
        });
        panelDias.add(this.btn34);
        this.btn34.setBounds(210, 130, 40, 25);
        this.btn35.setFont(new Font("Arial", 1, 12));
        this.btn35.setForeground(new Color(0, 0, 102));
        this.btn35.setText("35");
        this.btn35.setBorder((Border) null);
        this.btn35.setHorizontalTextPosition(4);
        this.btn35.setIconTextGap(1);
        this.btn35.addActionListener(new ActionListener() { // from class: Citas.CitaInterconsulta.46
            public void actionPerformed(ActionEvent evt) {
                CitaInterconsulta.this.btn35ActionPerformed(evt);
            }
        });
        panelDias.add(this.btn35);
        this.btn35.setBounds(250, 130, 35, 25);
        this.btn36.setFont(new Font("Arial", 1, 12));
        this.btn36.setForeground(new Color(204, 0, 0));
        this.btn36.setText("36");
        this.btn36.setBorder((Border) null);
        this.btn36.setHorizontalTextPosition(4);
        this.btn36.setIconTextGap(1);
        this.btn36.addActionListener(new ActionListener() { // from class: Citas.CitaInterconsulta.47
            public void actionPerformed(ActionEvent evt) {
                CitaInterconsulta.this.btn36ActionPerformed(evt);
            }
        });
        panelDias.add(this.btn36);
        this.btn36.setBounds(10, 160, 40, 25);
        this.btn37.setFont(new Font("Arial", 1, 12));
        this.btn37.setForeground(new Color(0, 0, 102));
        this.btn37.setText("37");
        this.btn37.setBorder((Border) null);
        this.btn37.setHorizontalTextPosition(4);
        this.btn37.setIconTextGap(1);
        this.btn37.addActionListener(new ActionListener() { // from class: Citas.CitaInterconsulta.48
            public void actionPerformed(ActionEvent evt) {
                CitaInterconsulta.this.btn37ActionPerformed(evt);
            }
        });
        panelDias.add(this.btn37);
        this.btn37.setBounds(50, 160, 40, 25);
        this.btn38.setFont(new Font("Arial", 1, 12));
        this.btn38.setForeground(new Color(0, 0, 102));
        this.btn38.setText("38");
        this.btn38.setBorder((Border) null);
        this.btn38.setHorizontalTextPosition(4);
        this.btn38.setIconTextGap(1);
        this.btn38.addActionListener(new ActionListener() { // from class: Citas.CitaInterconsulta.49
            public void actionPerformed(ActionEvent evt) {
                CitaInterconsulta.this.btn38ActionPerformed(evt);
            }
        });
        panelDias.add(this.btn38);
        this.btn38.setBounds(90, 160, 40, 25);
        this.btn39.setFont(new Font("Arial", 1, 12));
        this.btn39.setForeground(new Color(0, 0, 102));
        this.btn39.setText("39");
        this.btn39.setBorder((Border) null);
        this.btn39.setHorizontalTextPosition(4);
        this.btn39.setIconTextGap(1);
        this.btn39.addActionListener(new ActionListener() { // from class: Citas.CitaInterconsulta.50
            public void actionPerformed(ActionEvent evt) {
                CitaInterconsulta.this.btn39ActionPerformed(evt);
            }
        });
        panelDias.add(this.btn39);
        this.btn39.setBounds(130, 160, 40, 25);
        this.btn40.setFont(new Font("Arial", 1, 12));
        this.btn40.setForeground(new Color(0, 0, 102));
        this.btn40.setText("40");
        this.btn40.setBorder((Border) null);
        this.btn40.setHorizontalTextPosition(4);
        this.btn40.setIconTextGap(1);
        this.btn40.addActionListener(new ActionListener() { // from class: Citas.CitaInterconsulta.51
            public void actionPerformed(ActionEvent evt) {
                CitaInterconsulta.this.btn40ActionPerformed(evt);
            }
        });
        panelDias.add(this.btn40);
        this.btn40.setBounds(170, 160, 40, 25);
        this.btn41.setFont(new Font("Arial", 1, 12));
        this.btn41.setForeground(new Color(0, 0, 102));
        this.btn41.setText("41");
        this.btn41.setBorder((Border) null);
        this.btn41.setHorizontalTextPosition(4);
        this.btn41.setIconTextGap(1);
        this.btn41.addActionListener(new ActionListener() { // from class: Citas.CitaInterconsulta.52
            public void actionPerformed(ActionEvent evt) {
                CitaInterconsulta.this.btn41ActionPerformed(evt);
            }
        });
        panelDias.add(this.btn41);
        this.btn41.setBounds(210, 160, 40, 25);
        this.btn42.setFont(new Font("Arial", 1, 12));
        this.btn42.setForeground(new Color(0, 0, 102));
        this.btn42.setText("42");
        this.btn42.setBorder((Border) null);
        this.btn42.setHorizontalTextPosition(4);
        this.btn42.setIconTextGap(1);
        this.btn42.addActionListener(new ActionListener() { // from class: Citas.CitaInterconsulta.53
            public void actionPerformed(ActionEvent evt) {
                CitaInterconsulta.this.btn42ActionPerformed(evt);
            }
        });
        panelDias.add(this.btn42);
        this.btn42.setBounds(250, 160, 35, 25);
        this.panelCalendario.add(panelDias);
        panelDias.setBounds(10, 80, 295, 190);
        this.txtHoy.setBackground(new Color(0, 0, 153));
        this.txtHoy.setFont(new Font("Tahoma", 1, 11));
        this.txtHoy.setForeground(new Color(204, 255, 255));
        this.txtHoy.setHorizontalAlignment(0);
        this.txtHoy.setText("jLabel4");
        this.txtHoy.setOpaque(true);
        this.panelCalendario.add(this.txtHoy);
        this.txtHoy.setBounds(10, 270, 296, 20);
        this.jPanel5.add(this.panelCalendario);
        this.panelCalendario.setBounds(520, 350, 310, 300);
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "Información de la Cita", 0, 0, new Font("Arial", 1, 14), new Color(0, 102, 102)));
        this.jPanel1.setLayout((LayoutManager) null);
        this.cboClaseCita.setBorder(BorderFactory.createTitledBorder((Border) null, "Clase de cita", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 102)));
        this.cboClaseCita.setName("cboClaseCita");
        this.cboClaseCita.addActionListener(new ActionListener() { // from class: Citas.CitaInterconsulta.54
            public void actionPerformed(ActionEvent evt) {
                CitaInterconsulta.this.cboClaseCitaActionPerformed(evt);
            }
        });
        this.jPanel1.add(this.cboClaseCita);
        this.cboClaseCita.setBounds(10, 90, 290, 50);
        this.jLabel2.setFont(new Font("Arial", 1, 12));
        this.jLabel2.setForeground(new Color(0, 0, 102));
        this.jLabel2.setText("Minutos");
        this.jPanel1.add(this.jLabel2);
        this.jLabel2.setBounds(140, 160, 60, 15);
        this.txtDuracion.setEditable(false);
        this.txtDuracion.setBackground(new Color(0, 0, 153));
        this.txtDuracion.setFont(new Font("Arial", 1, 12));
        this.txtDuracion.setForeground(new Color(255, 255, 255));
        this.txtDuracion.setHorizontalAlignment(0);
        this.txtDuracion.setDisabledTextColor(new Color(255, 255, 255));
        this.txtDuracion.setEnabled(false);
        this.txtDuracion.setName("txtDuracion");
        this.jPanel1.add(this.txtDuracion);
        this.txtDuracion.setBounds(80, 150, 50, 28);
        this.jLabel3.setFont(new Font("Arial", 1, 12));
        this.jLabel3.setForeground(new Color(0, 0, 102));
        this.jLabel3.setText("Consultorio");
        this.jPanel1.add(this.jLabel3);
        this.jLabel3.setBounds(10, 200, 80, 15);
        txtConsultorio.setBackground(new Color(0, 0, 153));
        txtConsultorio.setFont(new Font("Arial", 1, 12));
        txtConsultorio.setDisabledTextColor(new Color(255, 255, 255));
        txtConsultorio.setEnabled(false);
        txtConsultorio.setName("txtConsultorio");
        this.jPanel1.add(txtConsultorio);
        txtConsultorio.setBounds(80, 190, 200, 30);
        this.cboProfesional.setFont(new Font("Arial", 1, 12));
        this.cboProfesional.setBorder(BorderFactory.createTitledBorder((Border) null, "Profesional ", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 102)));
        this.cboProfesional.addActionListener(new ActionListener() { // from class: Citas.CitaInterconsulta.55
            public void actionPerformed(ActionEvent evt) {
                CitaInterconsulta.this.cboProfesionalActionPerformed(evt);
            }
        });
        this.cboProfesional.addPropertyChangeListener(new PropertyChangeListener() { // from class: Citas.CitaInterconsulta.56
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                CitaInterconsulta.this.cboProfesionalPropertyChange(evt);
            }
        });
        this.jPanel1.add(this.cboProfesional);
        this.cboProfesional.setBounds(10, 30, 290, 50);
        this.jLabel6.setFont(new Font("Arial", 1, 12));
        this.jLabel6.setForeground(new Color(0, 0, 102));
        this.jLabel6.setText("Duración");
        this.jPanel1.add(this.jLabel6);
        this.jLabel6.setBounds(10, 160, 70, 15);
        this.jPanel5.add(this.jPanel1);
        this.jPanel1.setBounds(520, 110, 310, 230);
        this.jPanel3.setBorder(BorderFactory.createEtchedBorder());
        this.jPanel3.setLayout((LayoutManager) null);
        this.jLabel4.setFont(new Font("Tahoma", 0, 24));
        this.jLabel4.setForeground(new Color(0, 0, 153));
        this.jLabel4.setText("No.");
        this.jPanel3.add(this.jLabel4);
        this.jLabel4.setBounds(10, 20, 50, 30);
        this.txtNoCita.setEditable(false);
        this.txtNoCita.setBackground(new Color(0, 0, 153));
        this.txtNoCita.setFont(new Font("Arial", 1, 24));
        this.txtNoCita.setForeground(new Color(255, 255, 255));
        this.txtNoCita.setHorizontalAlignment(4);
        this.txtNoCita.setDisabledTextColor(new Color(204, 204, 255));
        this.txtNoCita.setEnabled(false);
        this.jPanel3.add(this.txtNoCita);
        this.txtNoCita.setBounds(70, 20, 230, 60);
        this.jLabel8.setFont(new Font("Tahoma", 0, 24));
        this.jLabel8.setForeground(new Color(0, 0, 153));
        this.jLabel8.setText("Cita");
        this.jPanel3.add(this.jLabel8);
        this.jLabel8.setBounds(10, 50, 50, 30);
        this.jPanel5.add(this.jPanel3);
        this.jPanel3.setBounds(520, 10, 310, 90);
        this.btnSalir.setFont(new Font("Arial", 1, 12));
        this.btnSalir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.btnSalir.setText("Salir");
        this.btnSalir.addActionListener(new ActionListener() { // from class: Citas.CitaInterconsulta.57
            public void actionPerformed(ActionEvent evt) {
                CitaInterconsulta.this.btnSalirActionPerformed(evt);
            }
        });
        this.jPanel5.add(this.btnSalir);
        this.btnSalir.setBounds(520, 650, 310, 40);
        this.grid.setFont(new Font("Arial", 1, 12));
        this.grid.setForeground(new Color(0, 0, 102));
        this.grid.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.grid.setAutoResizeMode(3);
        this.grid.setCellSelectionEnabled(true);
        this.grid.setName("grid");
        this.grid.setRowHeight(25);
        this.grid.setSelectionBackground(new Color(255, 255, 255));
        this.grid.setSelectionForeground(Color.red);
        this.grid.setSelectionMode(0);
        this.grid.addMouseListener(new MouseAdapter() { // from class: Citas.CitaInterconsulta.58
            public void mousePressed(MouseEvent evt) {
                CitaInterconsulta.this.gridMousePressed(evt);
            }
        });
        this.grid.addMouseMotionListener(new MouseMotionAdapter() { // from class: Citas.CitaInterconsulta.59
            public void mouseMoved(MouseEvent evt) {
                CitaInterconsulta.this.gridMouseMoved(evt);
            }
        });
        this.jScrollPane3.setViewportView(this.grid);
        this.jPanel5.add(this.jScrollPane3);
        this.jScrollPane3.setBounds(10, 40, 500, 650);
        this.lblFecha.setBackground(new Color(0, 0, 153));
        this.lblFecha.setFont(new Font("Arial", 1, 14));
        this.lblFecha.setForeground(new Color(204, 255, 255));
        this.lblFecha.setHorizontalAlignment(0);
        this.lblFecha.setText("jLabel8");
        this.lblFecha.setOpaque(true);
        this.jPanel5.add(this.lblFecha);
        this.lblFecha.setBounds(10, 10, 499, 20);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.jPanel5, -2, 841, -2).addContainerGap(-1, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel5, -1, 781, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboMesActionPerformed(ActionEvent evt) {
        cargarFecha();
        cargarAgenda();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtAnoStateChanged(ChangeEvent evt) {
        cargarFecha();
        cargarAgenda();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btn1ActionPerformed(ActionEvent evt) {
        buscarCita(this.btn1.getText(), this.btn1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btn2ActionPerformed(ActionEvent evt) {
        buscarCita(this.btn2.getText(), this.btn2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btn3ActionPerformed(ActionEvent evt) {
        buscarCita(this.btn3.getText(), this.btn3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btn3FocusLost(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btn4ActionPerformed(ActionEvent evt) {
        buscarCita(this.btn4.getText(), this.btn4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btn5ActionPerformed(ActionEvent evt) {
        buscarCita(this.btn5.getText(), this.btn5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btn6ActionPerformed(ActionEvent evt) {
        buscarCita(this.btn6.getText(), this.btn6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btn7ActionPerformed(ActionEvent evt) {
        buscarCita(this.btn7.getText(), this.btn7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btn8ActionPerformed(ActionEvent evt) {
        buscarCita(this.btn8.getText(), this.btn8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btn9ActionPerformed(ActionEvent evt) {
        buscarCita(this.btn9.getText(), this.btn9);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btn10ActionPerformed(ActionEvent evt) {
        buscarCita(this.btn10.getText(), this.btn10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btn10FocusLost(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btn11ActionPerformed(ActionEvent evt) {
        buscarCita(this.btn11.getText(), this.btn11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btn12ActionPerformed(ActionEvent evt) {
        buscarCita(this.btn12.getText(), this.btn12);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btn13ActionPerformed(ActionEvent evt) {
        buscarCita(this.btn13.getText(), this.btn13);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btn14ActionPerformed(ActionEvent evt) {
        buscarCita(this.btn14.getText(), this.btn14);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btn15ActionPerformed(ActionEvent evt) {
        buscarCita(this.btn15.getText(), this.btn15);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btn16ActionPerformed(ActionEvent evt) {
        buscarCita(this.btn16.getText(), this.btn16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btn17ActionPerformed(ActionEvent evt) {
        buscarCita(this.btn17.getText(), this.btn17);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btn18ActionPerformed(ActionEvent evt) {
        buscarCita(this.btn18.getText(), this.btn18);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btn19ActionPerformed(ActionEvent evt) {
        buscarCita(this.btn19.getText(), this.btn19);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btn20ActionPerformed(ActionEvent evt) {
        buscarCita(this.btn20.getText(), this.btn20);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btn21ActionPerformed(ActionEvent evt) {
        buscarCita(this.btn21.getText(), this.btn21);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btn22ActionPerformed(ActionEvent evt) {
        buscarCita(this.btn22.getText(), this.btn22);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btn23ActionPerformed(ActionEvent evt) {
        buscarCita(this.btn23.getText(), this.btn23);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btn24ActionPerformed(ActionEvent evt) {
        buscarCita(this.btn24.getText(), this.btn24);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btn25ActionPerformed(ActionEvent evt) {
        buscarCita(this.btn25.getText(), this.btn25);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btn26ActionPerformed(ActionEvent evt) {
        buscarCita(this.btn26.getText(), this.btn26);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btn27ActionPerformed(ActionEvent evt) {
        buscarCita(this.btn27.getText(), this.btn27);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btn28ActionPerformed(ActionEvent evt) {
        buscarCita(this.btn28.getText(), this.btn28);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btn29ActionPerformed(ActionEvent evt) {
        buscarCita(this.btn29.getText(), this.btn29);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btn30ActionPerformed(ActionEvent evt) {
        buscarCita(this.btn30.getText(), this.btn30);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btn31ActionPerformed(ActionEvent evt) {
        buscarCita(this.btn31.getText(), this.btn31);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btn32ActionPerformed(ActionEvent evt) {
        buscarCita(this.btn32.getText(), this.btn32);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btn33ActionPerformed(ActionEvent evt) {
        buscarCita(this.btn33.getText(), this.btn33);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btn34ActionPerformed(ActionEvent evt) {
        buscarCita(this.btn34.getText(), this.btn34);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btn35ActionPerformed(ActionEvent evt) {
        buscarCita(this.btn35.getText(), this.btn35);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btn36ActionPerformed(ActionEvent evt) {
        buscarCita(this.btn36.getText(), this.btn36);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btn37ActionPerformed(ActionEvent evt) {
        buscarCita(this.btn37.getText(), this.btn37);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btn38ActionPerformed(ActionEvent evt) {
        buscarCita(this.btn38.getText(), this.btn38);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btn39ActionPerformed(ActionEvent evt) {
        buscarCita(this.btn39.getText(), this.btn39);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btn40ActionPerformed(ActionEvent evt) {
        buscarCita(this.btn40.getText(), this.btn40);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btn41ActionPerformed(ActionEvent evt) {
        buscarCita(this.btn41.getText(), this.btn41);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btn42ActionPerformed(ActionEvent evt) {
        buscarCita(this.btn42.getText(), this.btn42);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gridMousePressed(MouseEvent evt) {
        if (evt.getButton() == 3) {
            this.mnPopup.setVisible(true);
            this.mnPopup.setLocation(evt.getLocationOnScreen().x, evt.getLocationOnScreen().y);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboClaseCitaActionPerformed(ActionEvent evt) {
        if (this.cboLleno == 1 && this.cboClaseCita.getSelectedIndex() > -1) {
            this.txtDuracion.setText(this.listaClaseCita[this.cboClaseCita.getSelectedIndex()][1]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mnAsignarActionPerformed(ActionEvent evt) {
        asignarCita();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mnReasignarActionPerformed(ActionEvent evt) {
        reasignar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mnDesistirActionPerformed(ActionEvent evt) {
        desistir();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mnRecordatorioActionPerformed(ActionEvent evt) {
        this.mnPopup.setVisible(false);
        imprimirCita();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mnSalirActionPerformed(ActionEvent evt) {
        this.mnPopup.setVisible(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboProfesionalPropertyChange(PropertyChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnSalirActionPerformed(ActionEvent evt) {
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboProfesionalActionPerformed(ActionEvent evt) {
        if (this.cboLleno == 1 && this.cboProfesional.getSelectedIndex() > -1) {
            cargarProgCalendario();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gridMouseMoved(MouseEvent evt) {
        this.grid.setToolTipText(this.modeloGrid.getValueAt(this.filaGrid, 5).toString());
    }

    public void cargarFecha() {
        this.xAno = String.valueOf(this.txtAno.getValue());
        this.xMes = String.valueOf(this.cboMes.getSelectedIndex());
        traerUltimoDiaMes();
        Refrescar();
    }

    public void traerUltimoDiaMes() {
        double r = (Integer.valueOf(this.xAno).intValue() / 4) * 4;
        switch (Integer.valueOf(this.xMes).intValue()) {
            case 0:
                this.ultimoDia = 31;
                break;
            case 1:
                if (r == Integer.valueOf(this.xAno).intValue()) {
                    this.ultimoDia = 29;
                } else {
                    this.ultimoDia = 28;
                }
                break;
            case 2:
                this.ultimoDia = 31;
                break;
            case 3:
                this.ultimoDia = 30;
                break;
            case 4:
                this.ultimoDia = 31;
                break;
            case 5:
                this.ultimoDia = 30;
                break;
            case 6:
                this.ultimoDia = 31;
                break;
            case 7:
                this.ultimoDia = 31;
                break;
            case 8:
                this.ultimoDia = 30;
                break;
            case 9:
                this.ultimoDia = 31;
                break;
            case 10:
                this.ultimoDia = 30;
                break;
            case 11:
                this.ultimoDia = 31;
                break;
        }
    }

    public void colocarEtiquetaFecha() {
    }

    public void Refrescar() {
        String xdia = "01";
        setAno(this.txtAno.getValue().toString());
        setMes(String.valueOf(this.cboMes.getSelectedIndex()));
        setFecha(getAno(), getMes(), xdia);
        getUltimoDiaMes();
        int xColumna = this.fecha.get(7) - 1;
        for (int i = 0; i < panelDias.getComponentCount(); i++) {
            this.boton = panelDias.getComponent(i);
            this.boton.setText((String) null);
            this.boton.setIcon((Icon) null);
            this.boton.setEnabled(false);
            this.boton.setForeground(new Color(0, 0, 102));
            this.boton.setFont(new Font("Arial", 0, 12));
        }
        for (int i2 = xColumna; i2 < panelDias.getComponentCount(); i2++) {
            this.boton = panelDias.getComponent(i2);
            this.boton.setText(String.valueOf(xdia));
            this.boton.setEnabled(true);
            String xmes = String.valueOf(Integer.parseInt(getMes()) + 1);
            if (xmes.length() == 1) {
                xmes = "0" + xmes;
            }
            String fecBoton = getAno() + "-" + xmes + "-" + xdia;
            for (int df = 0; df < this.lisDiasFestivos.length; df++) {
                if (this.lisDiasFestivos[df].equals(fecBoton)) {
                    this.boton.setForeground(new Color(204, 0, 0));
                    this.boton.setFont(new Font("Arial", 1, 12));
                }
            }
            xdia = String.valueOf(Integer.parseInt(xdia) + 1);
            if (xdia.length() == 1) {
                xdia = "0" + xdia;
            }
            if (Integer.parseInt(xdia) > this.ultimoDia) {
                return;
            }
        }
    }

    public GregorianCalendar getFecha() {
        return this.fecha;
    }

    public String getDia() {
        if (this.xDia.length() == 1) {
            this.xDia = "0" + this.xDia;
        }
        return this.xDia;
    }

    public String getMes() {
        if (this.xMes.length() == 1) {
            this.xMes = "0" + this.xMes;
        }
        return this.xMes;
    }

    public String getAno() {
        return this.xAno;
    }

    public int getTieneCita(String xfecha) {
        int tiene = 0;
        for (int f = 0; f < this.listaDiasConCita.length && this.listaDiasConCita[f][0] != null; f++) {
            if (this.listaDiasConCita[f][0].equals(xfecha)) {
                tiene = 1;
            }
        }
        return tiene;
    }

    private String getUltimoDiaMes() {
        double r = (Integer.parseInt(getAno()) / 4) * 4;
        if (getMes().equals("00")) {
            this.ultimoDia = 31;
        } else if (getMes().equals("01")) {
            if (r == Integer.parseInt(getAno())) {
                this.ultimoDia = 29;
            } else {
                this.ultimoDia = 28;
            }
        } else if (getMes().equals("02")) {
            this.ultimoDia = 31;
        } else if (getMes().equals("03")) {
            this.ultimoDia = 30;
        } else if (getMes().equals("04")) {
            this.ultimoDia = 31;
        } else if (getMes().equals("05")) {
            this.ultimoDia = 30;
        } else if (getMes().equals("06") || getMes().equals("07")) {
            this.ultimoDia = 31;
        } else if (getMes().equals("08")) {
            this.ultimoDia = 30;
        } else if (getMes().equals("09")) {
            this.ultimoDia = 31;
        } else if (getMes().equals("10")) {
            this.ultimoDia = 30;
        } else if (getMes().equals("11")) {
            this.ultimoDia = 31;
        }
        return String.valueOf(this.ultimoDia);
    }

    public void setFecha(String ano, String mes, String dia) {
        this.fecha.set(Integer.parseInt(ano), Integer.parseInt(mes), Integer.parseInt(dia));
    }

    public void setDia(String dia) {
        if (dia.length() == 1) {
            this.xDia = "0" + dia;
        } else {
            this.xDia = dia;
        }
    }

    public void setMes(String mes) {
        if (mes.length() == 1) {
            this.xMes = "0" + mes;
        } else {
            this.xMes = mes;
        }
    }

    public void setAno(String ano) {
        this.xAno = ano;
    }
}
