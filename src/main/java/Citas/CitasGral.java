package Citas;

import Acceso.Principal;
import General.Anular;
import General.Persona;
import Odontologia.JDTratamientos;
import Utilidades.ConsultasMySQL;
import Utilidades.Email;
import Utilidades.Metodos;
import com.genoma.plus.controller.citas.JDConsultarIngreso;
import com.genoma.plus.controller.citas.JIFCarneCitas;
import com.genoma.plus.dao.citas.CitasDAO;
import com.genoma.plus.dao.impl.citas.CitasDAOImpl;
import com.genoma.plus.jpa.entities.GModuloCorreo;
import com.genoma.plus.jpa.service.IGModuloCorreoService;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyVetoException;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:Citas/CitasGral.class */
public class CitasGral extends JInternalFrame {
    private Metodos metodos;
    private ConsultasMySQL consultas;
    public int filaGrid;
    public int motivoDesistida;
    public String[] listaDiasFestivos;
    public String[] xidempresafac;
    public String[] xidsede;
    public String[][] listaProfesional;
    public String[][] listaClaseCita;
    public String[][] listaPacientesConCita;
    public int filaArbol;
    public int filaListaDiasConCita;
    public int comboLleno;
    public int combocc;
    public boolean xCambioFecha;
    public String sql;
    public String nbreProfesional;
    public String especialAnterior;
    public String idEspecialidad;
    public String nSede;
    public String idSede;
    private String idTratamientoOdontologico;
    private String idIngreso;
    public static String NoCitaIps;
    public DefaultMutableTreeNode root;
    public DefaultMutableTreeNode tallo;
    public DefaultMutableTreeNode rama;
    public DefaultMutableTreeNode hoja;
    public DefaultMutableTreeNode sede;
    public DefaultTreeModel modeloArbol;
    public DefaultMutableTreeNode nodo;
    private int citaTelefonica;
    private int citaPrimerVez;
    private int grabarCita;
    public int remitida;
    public Object[] dato;
    public DefaultTableModel modeloGrid;
    private int idReasignar;
    private int tipoCitaRepetida;
    private int xsaludocupacional;
    private String idCita;
    private String NoCitaAReasignar;
    public Persona frmPersona;
    private CalendarioGral frmCalendario;
    public clasesCita clasescita;
    private hiloCitas2 hiloCita;
    private Thread hilo;
    private String[] valor;
    private final ImageIcon sedeIcon;
    private final ImageIcon rootIcon;
    private final ImageIcon especialidadIcon;
    private ImageIcon medicoIcon;
    SimpleDateFormat ft24;
    SimpleDateFormat ftFecha;
    SimpleDateFormat ftFecha24;
    SimpleDateFormat ft12;
    private CitasDAO xCitasDAO;
    private Principal frmPrincipal;
    private String idConsultorio;
    private Boolean estadoVisualizacion;
    private String urlRes;
    private String resUrl;
    private String observacionRes;
    private String resObservacion;
    private int idModulo;
    private final IGModuloCorreoService correoService;
    private GModuloCorreo moduloCorreo;
    public JTree Arbol;
    private JComboBox JCBEmpresa;
    private JCheckBox JCBObservacion;
    private JComboBox JCBSede;
    private JCheckBox JCHSaludOcupacional;
    public JDateChooser JDFFechaSolictud;
    private JScrollPane JSP_UrlVideoLlamada;
    private JEditorPane JTA_UrlVideoLlamada;
    private JTabbedPane JTB_DatosC;
    public JTextField JTFNAutorizacion;
    public JTextField JTFTratamientoO;
    private JCheckBox btnCitaTelefonica;
    private JRadioButton btnInterconsulta;
    public JRadioButton btnNoRemitido;
    private JRadioButton btnRemitido;
    public JComboBox cboClaseCita;
    public JTable grid;
    private ButtonGroup grupoRemision;
    private JButton jButton1;
    private JButton jButton2;
    private JLabel jLabel4;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JPanel jPanel5;
    private JPanel jPanel6;
    private JScrollPane jScrollPane1;
    public JScrollPane jScrollPane3;
    private JSeparator jSeparator1;
    private JSeparator jSeparator2;
    private JMenuItem mnAsignar;
    private JMenuItem mnDesistir;
    private JMenuItem mnFacturacion;
    private JMenuItem mnLlamar;
    private JPopupMenu mnPopup;
    private JMenuItem mnReasignar;
    private JMenuItem mnRecordatorio;
    private JMenuItem mnSalir;
    private JPanel panelCalendario;
    private JPanel panelPersona;
    private JTextField txtAtendidas;
    public static JTextField txtConsultorio;
    private JTextField txtCupoAsignado;
    private JTextField txtDuracion;
    private JTextField txtRestantes;

    public CitasGral(clasesCita clase, Principal frmPrincipal) {
        this.metodos = new Metodos();
        this.consultas = new ConsultasMySQL();
        this.filaGrid = 0;
        this.motivoDesistida = 1;
        this.listaPacientesConCita = new String[0][0];
        this.filaListaDiasConCita = 0;
        this.comboLleno = 0;
        this.combocc = 0;
        this.xCambioFecha = false;
        this.idEspecialidad = "";
        this.idSede = "0";
        this.idTratamientoOdontologico = "0";
        this.idIngreso = "0";
        this.root = new DefaultMutableTreeNode("SEDE");
        this.tallo = new DefaultMutableTreeNode("Especialidades");
        this.modeloArbol = new DefaultTreeModel(this.root);
        this.nodo = new DefaultMutableTreeNode();
        this.citaTelefonica = 0;
        this.citaPrimerVez = 0;
        this.grabarCita = 0;
        this.remitida = -1;
        this.idReasignar = 0;
        this.tipoCitaRepetida = 0;
        this.xsaludocupacional = 0;
        this.NoCitaAReasignar = "0";
        this.sedeIcon = new ImageIcon(getClass().getResource("/Imagenes/Sede_16.png"));
        this.rootIcon = new ImageIcon(getClass().getResource("/Imagenes/AgendaMedica.png"));
        this.especialidadIcon = new ImageIcon(getClass().getResource("/Imagenes/Especialidad_16.png"));
        this.medicoIcon = new ImageIcon(getClass().getResource("/Imagenes/Profesiona_16x20.png"));
        this.ft24 = new SimpleDateFormat("HH:mm");
        this.ftFecha = new SimpleDateFormat("dd/MM/yyyy");
        this.ftFecha24 = new SimpleDateFormat("dd/MM/yyyy hh:mm a");
        this.ft12 = new SimpleDateFormat("hh:mm a");
        this.idConsultorio = "1";
        this.urlRes = "";
        this.resUrl = "";
        this.observacionRes = "";
        this.resObservacion = "";
        this.correoService = (IGModuloCorreoService) Principal.contexto.getBean(IGModuloCorreoService.class);
        initComponents();
        this.clasescita = clase;
        this.frmPrincipal = frmPrincipal;
        iniciar();
        springStart();
        this.Arbol.setCellRenderer(new MyTreeCellRenderer());
    }

    public CitasGral(int modulo, clasesCita clase, Principal frmPrincipal) {
        this.metodos = new Metodos();
        this.consultas = new ConsultasMySQL();
        this.filaGrid = 0;
        this.motivoDesistida = 1;
        this.listaPacientesConCita = new String[0][0];
        this.filaListaDiasConCita = 0;
        this.comboLleno = 0;
        this.combocc = 0;
        this.xCambioFecha = false;
        this.idEspecialidad = "";
        this.idSede = "0";
        this.idTratamientoOdontologico = "0";
        this.idIngreso = "0";
        this.root = new DefaultMutableTreeNode("SEDE");
        this.tallo = new DefaultMutableTreeNode("Especialidades");
        this.modeloArbol = new DefaultTreeModel(this.root);
        this.nodo = new DefaultMutableTreeNode();
        this.citaTelefonica = 0;
        this.citaPrimerVez = 0;
        this.grabarCita = 0;
        this.remitida = -1;
        this.idReasignar = 0;
        this.tipoCitaRepetida = 0;
        this.xsaludocupacional = 0;
        this.NoCitaAReasignar = "0";
        this.sedeIcon = new ImageIcon(getClass().getResource("/Imagenes/Sede_16.png"));
        this.rootIcon = new ImageIcon(getClass().getResource("/Imagenes/AgendaMedica.png"));
        this.especialidadIcon = new ImageIcon(getClass().getResource("/Imagenes/Especialidad_16.png"));
        this.medicoIcon = new ImageIcon(getClass().getResource("/Imagenes/Profesiona_16x20.png"));
        this.ft24 = new SimpleDateFormat("HH:mm");
        this.ftFecha = new SimpleDateFormat("dd/MM/yyyy");
        this.ftFecha24 = new SimpleDateFormat("dd/MM/yyyy hh:mm a");
        this.ft12 = new SimpleDateFormat("hh:mm a");
        this.idConsultorio = "1";
        this.urlRes = "";
        this.resUrl = "";
        this.observacionRes = "";
        this.resObservacion = "";
        this.correoService = (IGModuloCorreoService) Principal.contexto.getBean(IGModuloCorreoService.class);
        initComponents();
        this.clasescita = clase;
        this.frmPrincipal = frmPrincipal;
        this.idModulo = modulo;
        iniciar();
        springStart();
        this.Arbol.setCellRenderer(new MyTreeCellRenderer());
    }

    private void springStart() {
        this.xCitasDAO = (CitasDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("citasDAO");
    }

    public Boolean getEstadoVisualizacion() {
        return this.estadoVisualizacion;
    }

    public void setEstadoVisualizacion(Boolean estadoVisualizacion) {
        this.estadoVisualizacion = estadoVisualizacion;
    }

    public void mAsignarCitas() {
        this.mnPopup.setVisible(false);
        if (this.frmPersona.validarDatos(0) == 1 && mValidadDatosCita()) {
            int citaPendiente = 0;
            if (this.tipoCitaRepetida == 0) {
                citaPendiente = buscarSiTieneCitaPendiente(">=", this.metodos.formatoAMD.format(this.metodos.getFechaActual()));
            } else if (this.tipoCitaRepetida == 2) {
                citaPendiente = buscarSiTieneCitaPendiente("=", this.metodos.formatoAMD.format(this.frmCalendario.getFecha().getTime()));
                mBuscarCitasAsignadas("=", this.metodos.formatoAMD.format(this.frmCalendario.getFecha().getTime()));
            }
            if (citaPendiente == 0) {
                int duracion = contarEspacioParaAsignarCita(Integer.parseInt(this.txtDuracion.getText()));
                if (duracion == 1 || (duracion == 1 && this.tipoCitaRepetida == 4)) {
                    if (this.idReasignar == 0) {
                        try {
                            Date horaI = this.ft12.parse(this.grid.getValueAt(this.filaGrid, 0).toString());
                            Date horaF = sumarRestarMinHoras(horaI, Integer.parseInt(this.txtDuracion.getText()));
                            if (verificarFechaHoraProfesionalEspecialidad(this.ft24.format(horaI), this.ft24.format(horaF)) == 0) {
                                String paciente = this.frmPersona.txtApellido1.getText() + " " + this.frmPersona.txtApellido2.getText() + " " + this.frmPersona.txtNombre1.getText() + " " + this.frmPersona.txtNombre2.getText();
                                this.modeloGrid.setValueAt(paciente, this.filaGrid, 2);
                                this.modeloGrid.setValueAt(this.frmPersona.getIdPersona(), this.filaGrid, 4);
                                this.modeloGrid.setValueAt(this.cboClaseCita.getSelectedItem(), this.filaGrid, 5);
                                this.modeloGrid.setValueAt(this.txtDuracion.getText(), this.filaGrid, 8);
                                this.grabarCita = 1;
                                mGrabar();
                            } else {
                                JOptionPane.showInternalMessageDialog(this, "Ya existe una cita a la misma fecha, hora y profesional;\nFavor cambiar hora de asignación", "CONFIRMAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                            }
                            return;
                        } catch (ParseException ex) {
                            Logger.getLogger(CitasGral.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                            return;
                        }
                    }
                    modificarCita();
                }
            }
        }
    }

    private boolean mValidadDatosCita() {
        boolean xestado = false;
        if (this.JCBSede.getSelectedIndex() != -1) {
            if (this.JCBEmpresa.getSelectedIndex() != -1) {
                if (this.cboClaseCita.getSelectedIndex() != -1) {
                    if ((this.idEspecialidad.equals("1024") || this.idEspecialidad.equals("1023") || this.idEspecialidad.equals("461") || this.idEspecialidad.equals("1032") || this.idEspecialidad.equals("250")) && this.listaClaseCita[this.cboClaseCita.getSelectedIndex()][3].equals("1") && this.JTFTratamientoO.getText().equals("0")) {
                        JOptionPane.showInternalMessageDialog(this, "Por favor seleccione el tratamiento.", "CONFIRMAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        this.JTFTratamientoO.requestFocus();
                        xestado = false;
                    } else {
                        xestado = true;
                    }
                } else {
                    JOptionPane.showInternalMessageDialog(this, "Debe seleccionar la clase de cita", "CONFIRMAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    this.cboClaseCita.requestFocus();
                }
            } else {
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar empresa a facturar", "CONFIRMAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JCBEmpresa.requestFocus();
            }
        } else {
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar sede", "CONFIRMAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBSede.requestFocus();
        }
        return xestado;
    }

    private int buscarSiTieneCitaPendiente(String signo, String fechaCita) {
        int r = 0;
        this.sql = "SELECT c_citas.Fecha_Cita FROM  c_citas INNER JOIN  g_especialidad ON (c_citas.Id_Especialidad = g_especialidad.Id) WHERE (c_citas.Id_Especialidad ='" + this.idEspecialidad + "' AND c_citas.Id_Usuario = '" + this.frmPersona.getIdPersona() + "' AND c_citas.Fecha_Cita " + signo + "'" + fechaCita + "' AND c_citas.Asistida =0 AND c_citas.Id_MotivoDesistida =1)";
        String fecha = this.consultas.traerDato(this.sql);
        if (!fecha.isEmpty() && this.idReasignar == 0) {
            r = 1;
            this.metodos.mostrarMensaje("No se puede asignar una Cita al Usuario.\nYa tiene una cita asignada con la especialidad " + this.listaProfesional[this.filaArbol][3] + "\npara el dia " + fecha);
        }
        this.consultas.cerrarConexionBd();
        return r;
    }

    private void mBuscarCitasAsignadas(String signo, String fechaCita) {
        this.sql = "SELECT c_citas.Fecha_Cita FROM  c_citas INNER JOIN  g_especialidad ON (c_citas.Id_Especialidad = g_especialidad.Id) WHERE (c_citas.Id_Especialidad ='" + this.idEspecialidad + "' AND c_citas.Id_Usuario = '" + this.frmPersona.getIdPersona() + "' AND c_citas.Fecha_Cita " + signo + "'" + fechaCita + "' AND c_citas.Asistida =0 AND c_citas.Id_MotivoDesistida =1)";
        String fecha = this.consultas.traerDato(this.sql);
        if (!fecha.isEmpty() && this.idReasignar == 0) {
            this.metodos.mostrarMensaje(" Usuario ya tiene una cita asignada con la especialidad " + this.listaProfesional[this.filaArbol][3] + "\npara el dia " + fecha);
        }
        this.consultas.cerrarConexionBd();
    }

    public void buscarUsuario() {
        this.frmPersona.buscar(2);
    }

    public void cargarPacienteConCita() {
        String id_profesional;
        if (this.filaArbol > this.listaProfesional.length - 1) {
            id_profesional = "0";
        } else {
            id_profesional = this.listaProfesional[this.filaArbol][0];
        }
        try {
            if (Principal.informacionIps.getEsFpz().intValue() == 0) {
                this.sql = "SELECT  `c_citas`.`HoraInicial`, `c_citas`.`HoraFinal`, `persona`.`NUsuario`, `c_clasecita`.`Duracion`, `c_citas`.`Id`,  `persona`.`Id_persona`,c_clasecita.Nbre, ifnull(`g_parentesco`.EsTrabajador,0) EsTrabajador , `persona`.`NoHistoria`, `f_empresacontxconvenio`.`Nbre`, `f_empresacontxconvenio`.`NPrioridad`, `c_citas`.`Id_ingreso`,`c_citas`.`Asistida`  FROM `c_citas` INNER JOIN  `c_clasecita` ON (`c_citas`.`Id_ClaseCita` = `c_clasecita`.`Id`)INNER JOIN  `persona` ON (`c_citas`.`Id_Usuario` = `persona`.`Id_persona`)left JOIN  `g_usuario_fpz`  ON (`g_usuario_fpz`.`Id_Persona` = `persona`.`Id_persona`)INNER JOIN  `f_empresacontxconvenio`  ON (`c_citas`.`Id_EmpresaCont` = `f_empresacontxconvenio`.`Id`) left JOIN  `g_parentesco`  ON (`g_usuario_fpz`.`Id_Parentesco` = `g_parentesco`.`Id`) WHERE (`c_citas`.`Fecha_Cita` ='" + this.frmCalendario.getAno() + "-" + (Integer.parseInt(this.frmCalendario.getMes()) + 1) + "-" + this.frmCalendario.getDia() + "' AND `c_citas`.`Id_Profesional` ='" + id_profesional + "' AND `c_citas`.`Id_Especialidad` ='" + this.idEspecialidad + "' AND `c_citas`.`Id_MotivoDesistida` =1) ORDER BY `c_citas`.`HoraInicial` ASC ";
            } else {
                this.sql = "SELECT  `c_citas`.`HoraInicial`, `c_citas`.`HoraFinal`, concat(gp.Apellido1,' ',gp.Apellido2,' ',gp.Nombre1,' ',gp.Nombre2) `NUsuario`,\n`c_clasecita`.`Duracion`, `c_citas`.`Id`, gp.Id  as `Id_persona`,c_clasecita.Nbre, 0 ,\ngu.NoHistoria `NoHistoria`, `f_empresacontxconvenio`.`Nbre`, `f_empresacontxconvenio`.`NPrioridad`, `c_citas`.`Id_ingreso`, `c_citas`.`Asistida` \nFROM  `c_citas` INNER JOIN  `c_clasecita`  ON (`c_citas`.`Id_ClaseCita` = `c_clasecita`.`Id`)\nINNER JOIN g_persona gp  ON (gp.Id = `c_citas`.`Id_Usuario`) \ninner join g_usuario gu on (gu.Id_persona=gp.Id)\nINNER JOIN  `f_empresacontxconvenio`  ON (`f_empresacontxconvenio`.`Id` = `c_citas`.`Id_EmpresaCont`) WHERE (`c_citas`.`Fecha_Cita` ='" + this.frmCalendario.getAno() + "-" + (Integer.parseInt(this.frmCalendario.getMes()) + 1) + "-" + this.frmCalendario.getDia() + "' AND `c_citas`.`Id_Profesional` ='" + id_profesional + "' AND `c_citas`.`Id_Especialidad` ='" + this.idEspecialidad + "' AND `c_citas`.`Id_MotivoDesistida` =1) ORDER BY `c_citas`.`HoraInicial` ASC ";
            }
            System.out.println(" Lista pac Citas " + this.sql);
            ResultSet rs = this.consultas.traerRs(this.sql);
            Throwable th = null;
            try {
                try {
                    rs.last();
                    this.listaPacientesConCita = new String[rs.getRow()][13];
                    int fila = 0;
                    rs.beforeFirst();
                    int xncitas = 0;
                    while (rs.next()) {
                        this.listaPacientesConCita[fila][0] = rs.getString(1);
                        this.listaPacientesConCita[fila][1] = rs.getString(2);
                        this.listaPacientesConCita[fila][2] = rs.getString(3);
                        this.listaPacientesConCita[fila][3] = rs.getString(4);
                        this.listaPacientesConCita[fila][4] = rs.getString(5);
                        this.listaPacientesConCita[fila][5] = rs.getString(6);
                        this.listaPacientesConCita[fila][6] = rs.getString(7);
                        if (rs.getString(8) != null) {
                            if (rs.getString(8).equals("1")) {
                                this.listaPacientesConCita[fila][7] = "1";
                            } else {
                                this.listaPacientesConCita[fila][7] = "0";
                            }
                        } else {
                            this.listaPacientesConCita[fila][7] = "0";
                        }
                        this.listaPacientesConCita[fila][8] = rs.getString(9);
                        this.listaPacientesConCita[fila][9] = rs.getString(10);
                        this.listaPacientesConCita[fila][10] = rs.getString(11);
                        this.listaPacientesConCita[fila][11] = rs.getString("Id_ingreso");
                        this.listaPacientesConCita[fila][12] = rs.getString(13);
                        fila++;
                        xncitas++;
                    }
                    this.txtCupoAsignado.setText("" + xncitas);
                    if (rs != null) {
                        if (0 != 0) {
                            try {
                                rs.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                        } else {
                            rs.close();
                        }
                    }
                    this.consultas.cerrarConexionBd();
                } finally {
                }
            } catch (Throwable th3) {
                th = th3;
                throw th3;
            }
        } catch (SQLException ex) {
            this.consultas.mostrarErrorE(ex);
        }
    }

    /* JADX WARN: Not initialized variable reg: 7, insn: 0x0251: MOVE (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r7 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('rs' java.sql.ResultSet)]) A[TRY_LEAVE], block:B:34:0x0251 */
    /* JADX WARN: Not initialized variable reg: 8, insn: 0x0255: MOVE (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r8 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:36:0x0255 */
    private void cargarArbol() {
        this.sql = "SELECT g_profesionalespecial.Id_Especialidad, g_especialidad.Nbre, g_persona.Apellido1, g_persona.Apellido2, g_persona.Nombre1, g_persona.Nombre2, g_persona.Id, g_especialidad.CitaRepetida  , g_sedes.`Nbre` NSede, g_sedes.Id IdSede, g_especialidad.tiempoAgenda FROM g_profesionalespecial  INNER JOIN g_especialidad ON (g_profesionalespecial.Id_Especialidad = g_especialidad.Id)  INNER JOIN g_profesional ON (g_profesionalespecial.Id_Profesional = g_profesional.Id_Persona)  INNER JOIN g_persona  ON (g_profesional.Id_Persona = g_persona.Id)  INNER JOIN c_confcitas ON (c_confcitas.Id_Profesional = g_profesional.Id_Persona) AND (c_confcitas.Id_Especialidad = g_profesionalespecial.Id_Especialidad)   INNER JOIN `g_sedes` ON (c_confcitas.`IdSede`=g_sedes.`Id`)   WHERE (g_profesional.Activo_Cita =0 AND g_profesional.Estado=0 AND g_especialidad.Estado=0 AND c_confcitas.Estado=0)  GROUP BY g_profesional.Id_Persona, g_especialidad.Id, g_sedes.`Id` ORDER BY g_sedes.`Nbre` desc, g_especialidad.Nbre DESC, g_persona.Apellido1 DESC, g_persona.Apellido2 DESC ";
        try {
            try {
                ResultSet rs = this.consultas.traerRs(this.sql);
                Throwable th = null;
                rs.last();
                if (rs.getRow() < 1) {
                    this.metodos.mostrarMensaje("No hay Especialidades y Profesionales Asociados");
                } else {
                    this.listaProfesional = new String[rs.getRow() + 1][8];
                    rs.beforeFirst();
                    while (rs.next()) {
                        if (!rs.getString("NSede").equals(this.nSede)) {
                            this.sede = new DefaultMutableTreeNode(rs.getString("NSede"));
                            this.modeloArbol.insertNodeInto(this.sede, this.root, 0);
                        }
                        this.nbreProfesional = rs.getString(3) + " " + rs.getString(4) + " " + rs.getString(5) + " " + rs.getString(6);
                        this.hoja = new DefaultMutableTreeNode(this.nbreProfesional);
                        this.listaProfesional[rs.getRow()][0] = rs.getString(7);
                        this.listaProfesional[rs.getRow()][1] = this.nbreProfesional;
                        this.listaProfesional[rs.getRow()][2] = rs.getString(1);
                        this.listaProfesional[rs.getRow()][3] = rs.getString(2);
                        this.listaProfesional[rs.getRow()][4] = rs.getString(8);
                        this.listaProfesional[rs.getRow()][5] = rs.getString("NSede");
                        this.listaProfesional[rs.getRow()][6] = rs.getString("IdSede");
                        this.listaProfesional[rs.getRow()][7] = rs.getString("tiempoAgenda");
                        if (!rs.getString(2).equals(this.especialAnterior) || (rs.getString(2).equals(this.especialAnterior) && !rs.getString("NSede").equals(this.nSede))) {
                            this.rama = new DefaultMutableTreeNode(rs.getString(2));
                            this.modeloArbol.insertNodeInto(this.rama, this.sede, 0);
                            this.especialAnterior = rs.getString(2);
                        }
                        this.nSede = rs.getString("NSede");
                        this.modeloArbol.insertNodeInto(this.hoja, this.rama, 0);
                    }
                    this.Arbol.setModel(this.modeloArbol);
                    this.Arbol.getSelectionModel().setSelectionMode(1);
                    this.Arbol.setScrollsOnExpand(true);
                    this.Arbol.requestFocus();
                }
                if (rs != null) {
                    if (0 != 0) {
                        try {
                            rs.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    } else {
                        rs.close();
                    }
                }
                this.consultas.cerrarConexionBd();
            } finally {
            }
        } catch (SQLException e) {
            this.consultas.mostrarErrorSQL(e);
        }
    }

    public void cargarCita(String Prof, String Especial, String fecha) {
        cargarProfesional(Prof, Especial);
        this.frmCalendario.txtAno.setValue(Integer.valueOf(Integer.parseInt(fecha.substring(0, 4))));
        this.frmCalendario.cboMes.setSelectedIndex(Integer.parseInt(fecha.substring(5, 7)) - 1);
        this.frmCalendario.setClickBoton(fecha.substring(8, 10));
    }

    private void cargarProfesional(String Prof, String Especial) {
        int fila = 1;
        while (fila < this.Arbol.getRowCount()) {
            this.Arbol.setSelectionRow(fila);
            this.nodo = (DefaultMutableTreeNode) this.Arbol.getLastSelectedPathComponent();
            if (this.nodo.getUserObject().equals(Especial)) {
                this.Arbol.expandRow(fila);
                fila++;
                int hijos = this.nodo.getChildCount();
                int h = 0;
                while (true) {
                    if (h < hijos) {
                        this.Arbol.setSelectionRow(fila);
                        this.nodo = (DefaultMutableTreeNode) this.Arbol.getLastSelectedPathComponent();
                        if (this.nodo.getUserObject().equals(Prof)) {
                            fila = this.Arbol.getRowCount();
                            break;
                        } else {
                            fila++;
                            h++;
                        }
                    }
                }
            }
            fila++;
        }
    }

    public void cargarClaseCita(int xfiltro, String xFecha, String xSexo) {
        this.txtDuracion.setText("");
        txtConsultorio.setText("");
        this.cboClaseCita.removeAllItems();
        if (xfiltro == 0) {
            this.sql = "SELECT c_clasecita.Id, concat(c_clasecita.`Nbre`, ' - (',c_clasecita.`Duracion`,' Minutos)') as Nbre, c_clasecita.Duracion, c_clasecita.EsSo, c_clasecita.EsControl FROM c_clasecita  inner join c_clasecita_tipoatencion on (c_clasecita_tipoatencion.idClaseCita=c_clasecita.Id)  WHERE (c_clasecita.Id_Especialidad ='" + this.listaProfesional[this.filaArbol][2] + "' AND c_clasecita.Estado =0 and c_clasecita_tipoatencion.idTipoAtencion=1) ORDER BY c_clasecita.Nbre ASC";
        } else {
            this.sql = "SELECT  c_clasecita.`Id`, concat(c_clasecita.`Nbre`, ' - (',c_clasecita.`Duracion`,' Minutos)') as Nbre, c_clasecita.`Duracion`, c_clasecita.`EsSO`, c_clasecita.`EsControl` \nFROM `c_clasecita` inner join c_clasecita_tipoatencion on (c_clasecita_tipoatencion.idClaseCita=c_clasecita.Id) \nWHERE (\n    c_clasecita.`Id_Especialidad` = '" + this.listaProfesional[this.filaArbol][2] + "' \n    AND c_clasecita.`Estado` = 0 \n    AND c_clasecita.`Sexo` IN ('A', '" + xSexo + "')  and c_clasecita_tipoatencion.idTipoAtencion=1 \n    AND ( DATEDIFF(NOW(),'" + xFecha + "') >= c_clasecita.EdadI  AND DATEDIFF(NOW(),'" + xFecha + "') <= c_clasecita.EdadM )\n  ) \nORDER BY c_clasecita.`Nbre` ASC";
        }
        System.out.println("" + this.sql);
        this.listaClaseCita = this.consultas.llenarComboyLista(this.sql, this.listaClaseCita, this.cboClaseCita, 5);
        this.consultas.cerrarConexionBd();
        if (this.cboClaseCita.getItemCount() > 0) {
            this.cboClaseCita.setSelectedIndex(-1);
            this.combocc = 1;
        }
        if (Principal.informacionIps.getNombreIps().equals("IPS TERAPIAS Y ESTETICA INTEGRAL SAS")) {
            List<Object[]> list = this.xCitasDAO.consultarIngreso(0, this.frmPersona.IdPersona, this.frmCalendario.getAno(), this.listaProfesional[this.filaArbol][2]);
            for (int x = 0; x < list.size(); x++) {
                this.JTFTratamientoO.setText(list.get(x)[0].toString());
                setIdIngreso(list.get(x)[0].toString());
            }
        }
    }

    private void cargarPanelCalendario() {
        this.frmCalendario = new CalendarioGral(this);
        this.panelCalendario.setVisible(false);
        this.frmCalendario.setBounds(2, 2, 312, 285);
        this.panelCalendario.add(this.frmCalendario);
        this.panelCalendario.setVisible(true);
        this.frmCalendario.setVisible(true);
    }

    private void cargarPanelPersonas() {
        if (Principal.informacionIps.getNombreIps().equals("OROSALUD CAUCASIA IPS S.A.S")) {
            this.frmPersona = new Persona(this, this.idModulo);
            this.frmPersona.setVisible(false);
            this.panelPersona.setVisible(false);
            this.frmPersona.setBounds(1, 1, 967, 160);
            this.panelPersona.add(this.frmPersona);
            this.panelPersona.setVisible(true);
            this.frmPersona.setVisible(true);
            return;
        }
        this.frmPersona = new Persona(this);
        this.frmPersona.setVisible(false);
        this.panelPersona.setVisible(false);
        this.frmPersona.setBounds(1, 1, 967, 160);
        this.panelPersona.add(this.frmPersona);
        this.panelPersona.setVisible(true);
        this.frmPersona.setVisible(true);
    }

    public Date sumarRestarMinHoras(Date Hora, int min) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(Hora);
        calendar.add(12, min);
        return calendar.getTime();
    }

    public void cargarHorarioGrid() {
        cargarPacienteConCita();
        int diaAnterior = 0;
        int fila = 0;
        int dosHoras = Integer.valueOf(this.listaProfesional[this.filaArbol][7]).intValue();
        String horaUltima = "";
        for (int i = 0; i < 1000 && this.frmCalendario.listaDiasConCita[i][0] != null; i++) {
            if (this.frmCalendario.listaDiasConCita[i][0].equals(this.frmCalendario.getDia()) && this.frmCalendario.listaDiasConCita[i][5].equals("1")) {
                try {
                    if (diaAnterior != Integer.parseInt(this.frmCalendario.listaDiasConCita[i][0])) {
                        crearGrid();
                        fila = 0;
                    }
                    diaAnterior = Integer.parseInt(this.frmCalendario.listaDiasConCita[i][0]);
                    Date hini = this.ft24.parse(this.frmCalendario.listaDiasConCita[i][2]);
                    Date hfin = this.ft24.parse(this.frmCalendario.listaDiasConCita[i][3]);
                    txtConsultorio.setText(this.frmCalendario.listaDiasConCita[i][7]);
                    this.idConsultorio = this.frmCalendario.listaDiasConCita[i][7];
                    do {
                        montarFilaVacia(this.ft12.format(hini), fila, Integer.valueOf(this.listaProfesional[this.filaArbol][7]).intValue());
                        if (hini.getTime() == hfin.getTime()) {
                            montarFilaDescanso(this.ft12.format(hini), fila);
                        }
                        int sw = 0;
                        int a = 0;
                        while (true) {
                            if (a >= this.listaPacientesConCita.length) {
                                break;
                            }
                            if (!this.ft24.format(this.ft24.parse(this.listaPacientesConCita[a][0])).equals(this.ft24.format(hini))) {
                                a++;
                            } else {
                                horaUltima = this.ft12.format(this.ft24.parse(this.listaPacientesConCita[a][1]));
                                this.modeloGrid.setValueAt(horaUltima, fila, 1);
                                this.modeloGrid.setValueAt(this.listaPacientesConCita[a][2], fila, 2);
                                this.modeloGrid.setValueAt(this.listaPacientesConCita[a][4], fila, 3);
                                this.modeloGrid.setValueAt(this.listaPacientesConCita[a][5], fila, 4);
                                this.modeloGrid.setValueAt(this.listaPacientesConCita[a][6], fila, 5);
                                this.modeloGrid.setValueAt(this.listaPacientesConCita[a][7], fila, 6);
                                this.modeloGrid.setValueAt(this.listaPacientesConCita[a][8], fila, 7);
                                this.modeloGrid.setValueAt(this.listaPacientesConCita[a][9], fila, 9);
                                this.modeloGrid.setValueAt(this.listaPacientesConCita[a][10], fila, 10);
                                this.modeloGrid.setValueAt(this.listaPacientesConCita[a][11], fila, 11);
                                this.modeloGrid.setValueAt(this.listaPacientesConCita[a][12], fila, 12);
                                this.modeloGrid.setValueAt(Integer.valueOf(dosHoras), fila, 8);
                                this.grid.setDefaultRenderer(Object.class, new MiRender());
                                dosHoras += Integer.parseInt(this.listaPacientesConCita[a][3].toString());
                                sw = 1;
                                break;
                            }
                        }
                        if (sw == 1) {
                            hini = this.ft12.parse(horaUltima);
                        } else {
                            hini = sumarRestarMinHoras(hini, Integer.parseInt(this.listaProfesional[this.filaArbol][7]));
                        }
                        fila++;
                    } while (hini.getTime() <= hfin.getTime());
                } catch (ParseException ex) {
                    Logger.getLogger(CitasGral.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                }
            }
        }
        int firtsw = 0;
        for (int i2 = 0; i2 < 1000 && this.frmCalendario.listaDiasConCita[i2][0] != null; i2++) {
            if (this.frmCalendario.listaDiasConCita[i2][0].equals(this.frmCalendario.getDia()) && this.frmCalendario.listaDiasConCita[i2][5].equals("2")) {
                try {
                    firtsw++;
                    if (diaAnterior != Integer.parseInt(this.frmCalendario.listaDiasConCita[i2][0]) || (this.modeloGrid.getRowCount() > 0 && firtsw == 1)) {
                        crearGrid();
                        fila = 0;
                    }
                    diaAnterior = Integer.parseInt(this.frmCalendario.listaDiasConCita[i2][0]);
                    Date hini2 = this.ft24.parse(this.frmCalendario.listaDiasConCita[i2][2]);
                    Date hfin2 = this.ft24.parse(this.frmCalendario.listaDiasConCita[i2][3]);
                    txtConsultorio.setText(this.frmCalendario.listaDiasConCita[i2][4]);
                    this.idConsultorio = this.frmCalendario.listaDiasConCita[i2][7];
                    do {
                        montarFilaVacia(this.ft12.format(hini2), fila, 5);
                        if (hini2.getTime() == hfin2.getTime()) {
                            montarFilaDescanso(this.ft12.format(hini2), fila);
                        }
                        int sw2 = 0;
                        int a2 = 0;
                        while (true) {
                            if (a2 >= this.listaPacientesConCita.length) {
                                break;
                            }
                            if (!this.ft24.format(this.ft24.parse(this.listaPacientesConCita[a2][0])).equals(this.ft24.format(hini2))) {
                                a2++;
                            } else {
                                horaUltima = this.ft12.format(this.ft24.parse(this.listaPacientesConCita[a2][1]));
                                this.modeloGrid.setValueAt(horaUltima, fila, 1);
                                this.modeloGrid.setValueAt(this.listaPacientesConCita[a2][2], fila, 2);
                                this.modeloGrid.setValueAt(this.listaPacientesConCita[a2][4], fila, 3);
                                this.modeloGrid.setValueAt(this.listaPacientesConCita[a2][5], fila, 4);
                                this.modeloGrid.setValueAt(this.listaPacientesConCita[a2][6], fila, 5);
                                this.modeloGrid.setValueAt(this.listaPacientesConCita[a2][7], fila, 6);
                                this.modeloGrid.setValueAt(this.listaPacientesConCita[a2][8], fila, 7);
                                this.modeloGrid.setValueAt(this.listaPacientesConCita[a2][9], fila, 9);
                                this.modeloGrid.setValueAt(this.listaPacientesConCita[a2][10], fila, 10);
                                this.modeloGrid.setValueAt(this.listaPacientesConCita[a2][11], fila, 11);
                                this.modeloGrid.setValueAt(this.listaPacientesConCita[a2][12], fila, 12);
                                this.modeloGrid.setValueAt(Integer.valueOf(dosHoras), fila, 8);
                                this.grid.setDefaultRenderer(Object.class, new MiRender());
                                dosHoras += Integer.parseInt(this.listaPacientesConCita[a2][3].toString());
                                sw2 = 1;
                                break;
                            }
                        }
                        if (sw2 == 1) {
                            hini2 = this.ft12.parse(horaUltima);
                        } else {
                            hini2 = sumarRestarMinHoras(hini2, Integer.parseInt(this.listaProfesional[this.filaArbol][7]));
                        }
                        fila++;
                    } while (hini2.getTime() <= hfin2.getTime());
                } catch (ParseException ex2) {
                    Logger.getLogger(CitasGral.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex2);
                }
            }
        }
        for (int i3 = 0; i3 < 1000 && this.frmCalendario.listaDiasConCita[i3][0] != null; i3++) {
            if (this.frmCalendario.listaDiasConCita[i3][0].equals(this.frmCalendario.getDia()) && this.frmCalendario.listaDiasConCita[i3][5].equals("3")) {
                try {
                    if (diaAnterior != Integer.parseInt(this.frmCalendario.listaDiasConCita[i3][0])) {
                        crearGrid();
                    }
                    diaAnterior = Integer.parseInt(this.frmCalendario.listaDiasConCita[i3][0]);
                    Date hini3 = this.ft24.parse(this.frmCalendario.listaDiasConCita[i3][2]);
                    Date hfin3 = this.ft24.parse(this.frmCalendario.listaDiasConCita[i3][3]);
                    txtConsultorio.setText(this.frmCalendario.listaDiasConCita[i3][4]);
                    this.idConsultorio = this.frmCalendario.listaDiasConCita[i3][7];
                    do {
                        montarFilaVacaciones(this.ft12.format(hini3));
                        hini3 = sumarRestarMinHoras(hini3, Integer.parseInt(this.listaProfesional[this.filaArbol][7]));
                    } while (hini3.getTime() < hfin3.getTime());
                } catch (ParseException ex3) {
                    Logger.getLogger(CitasGral.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex3);
                }
            }
        }
    }

    public void cargarAgenda() {
        this.frmCalendario.refrescar();
        this.frmCalendario.limpiarListaDiasConCita();
        if (this.filaArbol < this.listaProfesional.length) {
            this.frmCalendario.montarAgendaGeneral(this.listaProfesional[this.filaArbol][0], this.idEspecialidad, this.idSede);
            this.frmCalendario.montarAgendaEspecial(this.listaProfesional[this.filaArbol][0], this.idEspecialidad, this.idSede);
            this.frmCalendario.montarAgendaExcepcion(this.listaProfesional[this.filaArbol][0], this.idEspecialidad, this.idSede);
        }
    }

    private void cargarNoCitaIps() {
        this.sql = "SELECT DISTINCT NoCita FROM g_ips";
        NoCitaIps = this.consultas.traerDato(this.sql);
        this.consultas.cerrarConexionBd();
    }

    private int contarEspacioParaAsignarCita(int duracion) {
        int contador = 0;
        int fila = this.filaGrid;
        int resultado = 0;
        for (int espacio = this.filaGrid; espacio < this.grid.getRowCount() && (this.modeloGrid.getValueAt(fila, 2) == null || this.modeloGrid.getValueAt(fila, 2) == " "); espacio++) {
            contador++;
            fila++;
        }
        if (contador * Integer.parseInt(this.listaProfesional[this.filaArbol][7]) >= duracion) {
            resultado = 1;
        } else {
            this.metodos.mostrarMensaje("No se puede asignar la Cita en ese horario.\n El tiempo asignado a la Clase de Cita es de : " + duracion + "\nEl tiempo disponible de Cita es de : " + (contador * Integer.parseInt(this.listaProfesional[this.filaArbol][7])));
        }
        return resultado;
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    public final void crearGrid() {
        this.modeloGrid = new DefaultTableModel(new Object[0], new String[]{"DESDE", "HASTA", "USUARIO", "NO CITA", "IDPACIENTE", "CLASE DE CITA", "ESTRABAJADOR", "NOHC", "DURACION", "EMPRESA", "PRIORIDAD", "IDINGRESO", "ASISTIDA"}) { // from class: Citas.CitasGral.1
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Long.class, Long.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.grid;
        JTable jTable2 = this.grid;
        jTable.setAutoResizeMode(0);
        this.grid.doLayout();
        this.grid.setModel(this.modeloGrid);
        this.grid.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.grid.getColumnModel().getColumn(1).setPreferredWidth(80);
        this.grid.getColumnModel().getColumn(2).setPreferredWidth(300);
        this.grid.getColumnModel().getColumn(3).setPreferredWidth(0);
        this.grid.getColumnModel().getColumn(3).setMinWidth(0);
        this.grid.getColumnModel().getColumn(3).setMaxWidth(0);
        this.grid.getColumnModel().getColumn(4).setPreferredWidth(0);
        this.grid.getColumnModel().getColumn(4).setMinWidth(0);
        this.grid.getColumnModel().getColumn(4).setMaxWidth(0);
        this.grid.getColumnModel().getColumn(5).setPreferredWidth(200);
        this.grid.getColumnModel().getColumn(6).setPreferredWidth(0);
        this.grid.getColumnModel().getColumn(6).setMinWidth(0);
        this.grid.getColumnModel().getColumn(6).setMaxWidth(0);
        this.grid.getColumnModel().getColumn(7).setPreferredWidth(0);
        this.grid.getColumnModel().getColumn(7).setMinWidth(0);
        this.grid.getColumnModel().getColumn(7).setMaxWidth(0);
        this.grid.getColumnModel().getColumn(8).setPreferredWidth(0);
        this.grid.getColumnModel().getColumn(8).setMinWidth(0);
        this.grid.getColumnModel().getColumn(8).setMaxWidth(0);
        this.grid.getColumnModel().getColumn(9).setPreferredWidth(400);
        this.grid.getColumnModel().getColumn(10).setPreferredWidth(0);
        this.grid.getColumnModel().getColumn(10).setMinWidth(0);
        this.grid.getColumnModel().getColumn(10).setMaxWidth(0);
        this.grid.getColumnModel().getColumn(11).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(12).setPreferredWidth(0);
        this.grid.getColumnModel().getColumn(12).setMinWidth(0);
        this.grid.getColumnModel().getColumn(12).setMaxWidth(0);
        this.filaGrid = 0;
    }

    public void desistir() {
        if (Principal.txtNo.getText() == null || Principal.txtNo.getText().isEmpty() || Principal.txtNo.getText().equals("")) {
            this.metodos.mostrarMensaje("Por favor selecione una Cita para Anular");
            this.mnPopup.setVisible(false);
        } else if (Long.valueOf(this.modeloGrid.getValueAt(this.grid.getSelectedRow(), 11).toString()).longValue() == 0 || Long.valueOf(this.modeloGrid.getValueAt(this.grid.getSelectedRow(), 12).toString()).longValue() == 0) {
            this.mnPopup.setVisible(false);
            Anular frm = new Anular(null, true, "Citas", 7);
            frm.setVisible(true);
        } else {
            this.mnPopup.setVisible(false);
            this.metodos.mostrarMensaje("Esta cita ya posee un ingreso");
        }
    }

    private void evaluarNodo() {
        this.nodo = (DefaultMutableTreeNode) this.Arbol.getLastSelectedPathComponent();
        if (this.nodo != null) {
            String nbreEspecial = this.nodo.getParent().toString();
            String nSede = this.nodo.getParent().getParent().toString();
            if (this.Arbol.getLastSelectedPathComponent() != null) {
                this.filaArbol = 1;
                while (true) {
                    if (this.filaArbol >= this.listaProfesional.length) {
                        break;
                    }
                    if (this.nodo.getUserObject().equals(this.listaProfesional[this.filaArbol][1]) && this.listaProfesional[this.filaArbol][3].equals(nbreEspecial)) {
                        crearGrid();
                        this.idEspecialidad = this.listaProfesional[this.filaArbol][2];
                        this.tipoCitaRepetida = Integer.parseInt(this.listaProfesional[this.filaArbol][4]);
                        this.JCBSede.setSelectedItem(nSede);
                        this.idSede = this.xidsede[this.JCBSede.getSelectedIndex()];
                        cargarAgenda();
                        if (this.frmPersona.getIdPersona().equals("0")) {
                            cargarClaseCita(0, "", "");
                        } else {
                            cargarClaseCita(1, this.metodos.formatoAMD1.format(this.frmPersona.cboFechaNacimiento.getDate()), this.frmPersona.getIdSexo());
                        }
                    } else {
                        this.filaArbol++;
                    }
                }
                if (this.filaArbol > this.listaProfesional.length - 1) {
                    crearGrid();
                    cargarAgenda();
                }
            }
            if (this.idEspecialidad.equals("1024") || this.idEspecialidad.equals("1023") || this.idEspecialidad.equals("461") || this.idEspecialidad.equals("1032") || this.idEspecialidad.equals("250")) {
                this.JTFTratamientoO.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Tratamiento", 2, 0, new Font("Arial", 1, 12), Color.blue));
            } else {
                this.JTFTratamientoO.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Ingreso", 2, 0, new Font("Arial", 1, 12), Color.blue));
            }
            this.JCBSede.setSelectedItem(nSede);
            this.idSede = this.xidsede[this.JCBSede.getSelectedIndex()];
        }
    }

    public void mGrabar() {
        if (this.grabarCita == 1) {
            Object[] botones = {"Personal", "Telefónica", "Web", "Demanda Inducida"};
            int n = JOptionPane.showInternalOptionDialog(this, "La asignación de la cita fue?", "FORMA DE ASIGNACION DE CITAS", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones, "Personal");
            if (n == 0) {
                this.citaTelefonica = 0;
            } else if (n == 1) {
                this.citaTelefonica = 1;
            } else if (n == 2) {
                this.citaTelefonica = 2;
            } else if (n == 3) {
                this.citaTelefonica = 3;
            }
            this.frmPersona.grabar();
            grabarCita();
            this.grabarCita = 0;
            if (this.remitida > 0) {
                grabarRemision();
            }
            mVisualizacionImpresionRecordatorio();
            this.nodo.setUserObject(this.listaProfesional[this.filaArbol][1]);
        }
    }

    private void mVisualizacionImpresionRecordatorio() {
        Object[] botones1 = {"Visualizar", "Enviar a correo electronico", "Cerrar"};
        int x = JOptionPane.showInternalOptionDialog(this, "Que desea hacer?", "VISUALIZACION", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones1, "Cerrar");
        if (x == 0) {
            this.clasescita.imprimirCita(this.listaClaseCita[this.cboClaseCita.getSelectedIndex()][2], this.cboClaseCita.getSelectedItem().toString(), this);
        } else if (x == 1) {
            mEnviarEmailRecordatorio();
        }
    }

    public void grabarCita() {
        String observacion;
        String url;
        System.out.println("resObservacion ----> " + this.resObservacion);
        System.out.println("resUrl ----> " + this.resUrl);
        if (this.resObservacion.isEmpty() || this.resObservacion == null) {
            observacion = this.JTA_UrlVideoLlamada.getText();
        } else {
            observacion = this.resObservacion;
        }
        if (this.resUrl.isEmpty() || this.resUrl == null) {
            url = this.JTA_UrlVideoLlamada.getText();
        } else {
            url = this.resUrl;
        }
        System.out.println("observacion f -> " + observacion);
        System.out.println("url f -> " + url);
        try {
            Date horaI = this.ft12.parse(this.grid.getValueAt(this.filaGrid, 0).toString());
            Date horaF = sumarRestarMinHoras(horaI, Integer.parseInt(this.txtDuracion.getText()));
            if (verificarFechaHoraProfesionalEspecialidad(this.ft24.format(horaI), this.ft24.format(horaF)) == 1) {
                this.metodos.mostrarMensaje("Acaban de asignar una Cita en la misma fecha, a la misma hora con el mismo profesional.\nPor favor seleccione otra hora para realizar la asignación.");
            } else {
                this.citaPrimerVez = this.clasescita.getCita1erVez(this.idEspecialidad, this.frmPersona.getIdPersona());
                this.sql = "INSERT INTO c_citas (Id_Profesional, Id_Especialidad, Id_Consultorio, Id_Usuario, Id_EmpresaCont, Id_ClaseCita, Fecha_Cita,Fecha_SUsuario, HoraInicial, HoraFinal, Telefonica, Remitida, So, PrimerVez, Asistida, Id_Sede,Id_TratamientoO, Id_ingreso, NAutorizacion, Fecha, UsuarioS, Id_UsuarioS , Id_ingresoReal, Url_videollamada, Observacion) VALUES ('" + this.listaProfesional[this.filaArbol][0] + "','" + this.idEspecialidad + "','" + this.idConsultorio + "','" + this.frmPersona.getIdPersona() + "','" + this.xidempresafac[this.JCBEmpresa.getSelectedIndex()] + "','" + this.listaClaseCita[this.cboClaseCita.getSelectedIndex()][0] + "','" + this.metodos.formatoAMD1.format(this.frmCalendario.getFecha().getTime()) + "','" + this.metodos.formatoAMD1.format(this.JDFFechaSolictud.getDate()) + "','" + this.ft24.format(horaI) + "','" + this.ft24.format(horaF) + "','" + this.citaTelefonica + "','" + this.remitida + "','" + this.xsaludocupacional + "','" + this.citaPrimerVez + "','0','" + this.xidsede[this.JCBSede.getSelectedIndex()] + "','" + getIdTratamientoOdontologico() + "','" + getIdIngreso() + "','" + this.JTFNAutorizacion.getText() + "','" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "','" + getIdIngreso() + "','" + url + "','" + observacion + "')";
                System.out.println("insert a citas -> " + this.sql);
                this.idCita = this.consultas.ejecutarSQLId(this.sql);
                this.consultas.cerrarConexionBd();
                Principal.txtNo.setText(this.idCita);
                Principal.txtEstado.setText("ACTIVA");
                Principal.txtFecha.setText(this.metodos.formatoDMA.format(this.frmCalendario.getFecha().getTime()));
                this.grid.setValueAt(this.ft12.format(horaF), this.filaGrid, 1);
                this.grid.setValueAt(this.idCita, this.filaGrid, 3);
                this.clasescita.mActualizarFechaCita_Periodico(Principal.txtNo.getText(), this.metodos.formatoAMD.format(this.frmCalendario.getFecha().getTime()));
                this.sql = "UPDATE g_ips SET g_ips.NoCita = '" + this.idCita + "', IdProfesionalUltimaCita ='" + this.listaProfesional[this.filaArbol][0] + "'";
                this.consultas.ejecutarSQL(this.sql);
                this.consultas.cerrarConexionBd();
                cargarHorarioGrid();
                this.metodos.mostrarMensaje("Cita Grabada, Ok");
            }
        } catch (ParseException ex) {
            Logger.getLogger(CitasGral.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void grabarRemision() {
        this.sql = "UPDATE h_remisiones SET Id_Cita = '" + this.idCita + "' WHERE Id = '" + this.remitida + "'";
        this.consultas.ejecutarSQL(this.sql);
        this.consultas.cerrarConexionBd();
    }

    private void iniciar() {
        this.jScrollPane3.setBorder(BorderFactory.createTitledBorder((Border) null, this.metodos.formatoFecha.format(this.metodos.getFechaActual()).toUpperCase(), 2, 0, new Font("Arial", 1, 14), new Color(0, 0, 255)));
        this.hiloCita = new hiloCitas2(this);
        this.hilo = new Thread(this.hiloCita);
        mNuevo();
        crearGrid();
        cargarPanelPersonas();
        cargarArbol();
        cargarNoCitaIps();
        this.frmPersona.panelPersona.setEnabledAt(0, true);
        this.frmPersona.panelPersona.setSelectedIndex(0);
        this.frmPersona.txtHistoria.requestFocus();
        this.btnCitaTelefonica.setVisible(false);
        mllenarComboEmpresaFac();
        this.hilo.start();
        cargarPanelCalendario();
        if (!Principal.informacionIps.getNombreIps().equals("OROSALUD CAUCASIA IPS S.A.S")) {
            this.JCBObservacion.setVisible(false);
            this.JCBObservacion.setEnabled(false);
        } else {
            this.JCBObservacion.setSelected(true);
            this.JSP_UrlVideoLlamada.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), Color.red));
        }
    }

    private void interConsulta() {
        Remitidos frm1 = new Remitidos(this.frmPersona.txtHistoria.getText(), this, 1);
        frm1.setVisible(true);
    }

    public String getIdIngreso() {
        return this.idIngreso;
    }

    public void setIdIngreso(String idIngreso) {
        this.idIngreso = idIngreso;
    }

    public String getIdTratamientoOdontologico() {
        return this.idTratamientoOdontologico;
    }

    public void setIdTratamientoOdontologico(String idTratamientoOdontologico) {
        this.idTratamientoOdontologico = idTratamientoOdontologico;
    }

    private void llamarUsuario() {
        this.mnPopup.setVisible(false);
        Principal.clasegeneral.cargarPantalla("Llamadas");
        Principal.clasegeneral.frmLlamadas.frmPersona.txtHistoria.setText(this.modeloGrid.getValueAt(this.filaGrid, 7).toString());
        Principal.clasegeneral.frmLlamadas.frmPersona.buscar(2);
    }

    private boolean validarCitaFechaHora(Date FechaCita) {
        boolean sw = false;
        String FechaH = this.ftFecha.format(FechaCita) + " " + this.modeloGrid.getValueAt(this.filaGrid, 0).toString();
        try {
            Date FechaHora = this.ftFecha24.parse(FechaH);
            if (FechaHora.getTime() >= this.metodos.getFechaActual().getTime()) {
                sw = true;
            }
        } catch (ParseException ex) {
            Logger.getLogger(CitasGral.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return sw;
    }

    private void modificarCita() {
        if (validarCitaFechaHora(this.frmCalendario.getFecha().getTime())) {
            try {
                Date horaI = this.ft12.parse(this.modeloGrid.getValueAt(this.filaGrid, 0).toString());
                Date horaF = sumarRestarMinHoras(horaI, Integer.parseInt(this.txtDuracion.getText()));
                this.sql = "UPDATE c_citas SET Id_Profesional ='" + this.listaProfesional[this.filaArbol][0] + "', Id_Especialidad ='" + this.idEspecialidad + "', Id_Sede ='" + this.xidsede[this.JCBSede.getSelectedIndex()] + "', Id_ClaseCita ='" + this.listaClaseCita[this.cboClaseCita.getSelectedIndex()][0] + "', Fecha_Cita ='" + this.metodos.formatoAMD.format(this.frmCalendario.getFecha().getTime()) + "', HoraInicial ='" + this.ft24.format(horaI) + "', HoraFinal ='" + this.ft24.format(horaF) + "', Reprogramada ='1', Fecha ='" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "', UsuarioS ='" + Principal.usuarioSistemaDTO.getLogin() + "' WHERE Id = '" + this.NoCitaAReasignar + "'";
                this.consultas.ejecutarSQL(this.sql);
                this.consultas.cerrarConexionBd();
                this.clasescita.mActualizarFechaCita_Periodico(this.NoCitaAReasignar, this.metodos.formatoAMD.format(this.frmCalendario.getFecha().getTime()));
                this.idReasignar = 0;
                this.NoCitaAReasignar = "";
                cargarPacienteConCita();
                cargarHorarioGrid();
                this.metodos.mostrarMensaje("Cita Reasignada, Ok");
                return;
            } catch (ParseException ex) {
                Logger.getLogger(CitasGral.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                return;
            }
        }
        this.metodos.mostrarMensaje("No puede reasignar una Cita para Fecha y Hora anteriores a la actual");
    }

    private void montarFilaDescanso(String hora, int fila) {
        this.modeloGrid.setValueAt(hora, fila, 0);
        this.modeloGrid.setValueAt("- Fin Programación de Turno -  ", fila, 2);
        this.modeloGrid.setValueAt("", fila, 5);
        this.modeloGrid.setValueAt("0", fila, 6);
        this.modeloGrid.setValueAt("0", fila, 10);
        this.modeloGrid.setValueAt("0", fila, 11);
    }

    private void montarFilaVacia(String hora, int fila, int dosHoras) {
        this.modeloGrid.addRow(this.dato);
        this.modeloGrid.setValueAt(hora, fila, 0);
        this.modeloGrid.setValueAt(" ", fila, 2);
        this.modeloGrid.setValueAt("", fila, 5);
        this.modeloGrid.setValueAt("0", fila, 6);
        this.modeloGrid.setValueAt("0", fila, 10);
        this.modeloGrid.setValueAt("0", fila, 11);
        this.modeloGrid.setValueAt(Integer.valueOf(dosHoras), fila, 8);
    }

    private void montarFilaVacaciones(String hora) {
        for (int p = 0; p < this.modeloGrid.getRowCount(); p++) {
            if (this.modeloGrid.getValueAt(p, 0).toString().equals(hora) && this.modeloGrid.getValueAt(p, 2).equals(" ")) {
                this.modeloGrid.setValueAt("Libre / Permiso / Vacaciones", p, 2);
                this.modeloGrid.setValueAt("0", p, 10);
                return;
            }
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:Citas/CitasGral$MiRender.class */
    public static class MiRender extends DefaultTableCellRenderer {
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (Principal.informacionIps.getEsFpz().intValue() == 0) {
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
            } else if (table.getValueAt(row, 11).toString() != null) {
                if (table.getValueAt(row, 2).toString() == null || table.getValueAt(row, 2).toString().length() <= 1) {
                    cell.setBackground(Color.WHITE);
                    cell.setForeground(Color.BLACK);
                } else if (Long.valueOf(table.getValueAt(row, 11).toString()).longValue() != 0 && Long.valueOf(table.getValueAt(row, 12).toString()).longValue() != 0) {
                    if (Principal.informacionIps.getAplicaResaltarCitasFacturadas().booleanValue()) {
                        cell.setBackground(Color.PINK);
                        cell.setForeground(Color.BLACK);
                    }
                } else {
                    cell.setBackground(Color.CYAN);
                    cell.setForeground(Color.BLACK);
                }
            } else {
                cell.setBackground(Color.WHITE);
            }
            return cell;
        }
    }

    public void nuevo() {
        this.metodos.limpiarDatosPrincipal();
        this.frmPersona.nuevo();
        this.txtAtendidas.setText("");
        txtConsultorio.setText("");
        this.JTA_UrlVideoLlamada.setText("");
        this.txtCupoAsignado.setText("");
        this.txtDuracion.setText("");
        this.txtRestantes.setText("");
        this.btnCitaTelefonica.setSelected(false);
        this.JCHSaludOcupacional.setSelected(false);
        this.xsaludocupacional = 0;
        this.citaTelefonica = 0;
        this.btnNoRemitido.setSelected(true);
        mllenarComboEmpresaFac();
        this.remitida = -1;
        this.cboClaseCita.setSelectedIndex(-1);
        this.JTFTratamientoO.setText("0");
        this.idIngreso = "0";
        this.idTratamientoOdontologico = "0";
        this.JTFNAutorizacion.setText("");
    }

    public void mNuevo() {
        this.metodos.limpiarDatosPrincipal();
        this.txtAtendidas.setText("");
        txtConsultorio.setText("");
        this.txtCupoAsignado.setText("");
        this.txtDuracion.setText("");
        this.txtRestantes.setText("");
        this.JTFNAutorizacion.setText("");
        this.JDFFechaSolictud.setDate(this.metodos.getFechaActual());
        this.btnCitaTelefonica.setSelected(false);
        this.JCHSaludOcupacional.setSelected(false);
        this.xsaludocupacional = 0;
        this.citaTelefonica = 0;
        this.idIngreso = "0";
        this.idTratamientoOdontologico = "0";
        this.btnNoRemitido.setSelected(true);
        mllenarComboEmpresaFac();
        this.remitida = -1;
        this.cboClaseCita.setSelectedIndex(-1);
        this.JTFTratamientoO.setText("0");
        this.xCambioFecha = false;
        this.JTFNAutorizacion.setText("");
    }

    public void mNuevo2() {
        Principal.mLimpiarDatosP();
        this.frmPersona.nuevo();
    }

    private void reasignar() {
        this.mnPopup.setVisible(false);
        String nbre = this.frmPersona.txtApellido1.getText() + " " + this.frmPersona.txtApellido2.getText() + " " + this.frmPersona.txtNombre1.getText() + " " + this.frmPersona.txtNombre2.getText();
        if (nbre.equals(this.modeloGrid.getValueAt(this.filaGrid, 2).toString())) {
            this.idReasignar = 1;
            this.NoCitaAReasignar = this.idCita;
        } else {
            this.metodos.mostrarMensaje("Por favor haga doble Click sobre el usuario que desea Reasignar la Cita.\npara que se carguen los datos de éste, luego busque el día de destino\npresione el Click derecho del Mouse y seleccione Asignar haciendo Click\ncon el botón izquierdo del Mouse.");
        }
    }

    private void mVerficarSO() {
        this.valor = new String[2];
        try {
            String sql = "SELECT `c_citas`.`So`, `c_clasecita`.`Nbre` FROM `c_citas` INNER JOIN `c_clasecita` ON (`c_citas`.`Id_ClaseCita` = `c_clasecita`.`Id`) WHERE (`c_citas`.`Id` ='" + Principal.txtNo.getText() + "')";
            ResultSet xrs = this.consultas.traerRs(sql);
            if (xrs.next()) {
                xrs.first();
                this.valor[0] = xrs.getString(1);
                this.valor[1] = xrs.getString(2);
            }
            xrs.close();
            this.consultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(CitasGral.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mllenarComboEmpresaFac() {
        this.JCBEmpresa.removeAllItems();
        this.xidempresafac = this.consultas.llenarCombo("SELECT `f_empresacontxconvenio`.`Id`, UCASE(`f_empresacontxconvenio`.`Nbre`) AS NEmpresa \nFROM  `f_empresacontxconvenio` \n-- INNER JOIN  `g_empresacont`  ON (`f_empresacontxconvenio`.`Id_EmpresaCont` = `g_empresacont`.`Id_empresa`) \nINNER JOIN  `g_empresa`  ON (`f_empresacontxconvenio`.Id_EmpresaCont  = `g_empresa`.`Id`)  \nWHERE (`f_empresacontxconvenio`.`Estado` =0 AND `f_empresacontxconvenio`.`HabilitarParaAsignarCita` = 1 \nAND `g_empresa`.`Estado` =1) ORDER BY `f_empresacontxconvenio`.`Nbre` ASC ", this.xidempresafac, this.JCBEmpresa);
        this.JCBEmpresa.setSelectedIndex(-1);
        this.consultas.cerrarConexionBd();
        String xsql = "SELECT `g_sedes`.`Id` , `g_sedes`.`Nbre`\nFROM `g_usuario_sist_sede` INNER JOIN `g_sedes`  ON (`g_usuario_sist_sede`.`Id_Sede` = `g_sedes`.`Id`)\nWHERE (`g_usuario_sist_sede`.`Id_Persona` ='" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "' AND `g_usuario_sist_sede`.`Estado` =1)\nORDER BY `g_sedes`.`Nbre` ASC";
        this.JCBSede.removeAllItems();
        this.xidsede = this.consultas.llenarCombo(xsql, this.xidsede, this.JCBSede);
        this.JCBSede.setSelectedItem(Principal.sedeUsuarioSeleccionadaDTO.getNombre());
        this.consultas.cerrarConexionBd();
    }

    private void mEnviarEmailRecordatorio() {
        String cuerpo;
        String cuerpo2;
        String cuerpo3;
        this.moduloCorreo = this.correoService.getCorreoModuloPorIdModulo(Principal.informacionGeneralPrincipalDTO.getIdModulo());
        System.out.println("datos para envio de correo>>>>" + this.moduloCorreo);
        if (!this.frmPersona.getTxtCorreo().getText().isEmpty() && this.frmPersona.getTxtCorreo().getText().matches("^[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$")) {
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
            if (!this.frmPersona.txtCorreo.getText().isEmpty()) {
                if (Principal.informacionIps.getEsFpz().intValue() == 0) {
                    if (this.listaClaseCita[this.cboClaseCita.getSelectedIndex()][2].equals("0")) {
                        Email xenviar = new Email();
                        this.metodos.mEliminarArchivo(new File(this.metodos.getRutaRep() + Principal.txtNo.getText() + ".pdf"));
                        this.metodos.CrearPDF(this.metodos.getRutaRep() + "C_RecordatorioDeCita", parametros, this.metodos.getRutaRep() + Principal.txtNo.getText());
                        String remite = System.getProperty("user.name") + "@fundacionpanzenu.org.co";
                        List<String> correo = new ArrayList<>();
                        correo.add(this.frmPersona.txtCorreo.getText());
                        if (this.JTA_UrlVideoLlamada.getText().isEmpty()) {
                            cuerpo3 = "Ver adjunto";
                        } else {
                            cuerpo3 = "Señor usuario,\nusted tiene una cita programada por video llamada, por favor dar clic en el link anexo para unirse\n\n" + this.JTA_UrlVideoLlamada.getText();
                        }
                        xenviar.enviarAdjunto(correo, cuerpo3, remite, "RECORDATORIO DE CITA", Principal.txtNo.getText() + ".pdf", this.metodos.getRutaRep() + Principal.txtNo.getText() + ".pdf");
                        return;
                    }
                    String[] xdestino = null;
                    Email xenviar2 = new Email();
                    if (this.cboClaseCita.getSelectedItem().toString().equals("EXAMEN DE INGRESO")) {
                        xdestino = new String[]{this.frmPersona.txtCorreo.getText(), "cmsa_so@fundacionpanzenu.org.co"};
                    } else if (this.cboClaseCita.getSelectedItem().toString().equals("EXAMEN DE EGRESO")) {
                        xdestino = new String[]{this.frmPersona.txtCorreo.getText(), "cmsa_rh@fundacionpanzenu.org.co", "cmsa_so@fundacionpanzenu.org.co"};
                    } else if (this.cboClaseCita.getSelectedItem().toString().equals("EXAMEN PERIODICO")) {
                        xdestino = new String[]{this.frmPersona.txtCorreo.getText(), this.frmPersona.listasupervisor[this.frmPersona.JCBSupervisor.getSelectedIndex()][1], "cmsa_so@fundacionpanzenu.org.co"};
                    }
                    this.metodos.mEliminarArchivo(new File(this.metodos.getRutaRep() + Principal.txtNo.getText() + ".pdf"));
                    this.metodos.CrearPDF(this.metodos.getRutaRep() + "C_RecordatorioDeCita_So", parametros, this.metodos.getRutaRep() + Principal.txtNo.getText());
                    String remite2 = System.getProperty("user.name") + "@fundacionpanzenu.org.co";
                    if (this.JTA_UrlVideoLlamada.getText().isEmpty()) {
                        cuerpo2 = "Ver adjunto";
                    } else {
                        cuerpo2 = "Señor usuario,\nusted tiene una cita programada por video llamada, por favor dar clic en el link anexo para unirse\n\n" + this.JTA_UrlVideoLlamada.getText();
                    }
                    xenviar2.enviarAdjunto(xdestino, cuerpo2, remite2, "VALORACIÓN POR SALUD OCUPACIONAL - " + this.cboClaseCita.getSelectedItem().toString(), Principal.txtNo.getText() + ".pdf", this.metodos.getRutaRep() + Principal.txtNo.getText() + ".pdf");
                    return;
                }
                Email xenviar3 = new Email();
                List<String> xdestino2 = new ArrayList<>();
                xdestino2.add(this.frmPersona.txtCorreo.getText());
                this.metodos.mEliminarArchivo(new File(this.metodos.getRutaRep() + "C_RecordatorioDeCita1.pdf"));
                this.metodos.CrearPDF(this.metodos.getRutaRep() + "C_RecordatorioDeCita1", parametros, this.metodos.getRutaRep() + "C_RecordatorioDeCita1");
                if (this.JTA_UrlVideoLlamada.getText().isEmpty()) {
                    cuerpo = "Ver adjunto";
                } else {
                    cuerpo = "Señor usuario,\nusted tiene una cita programada por video llamada, por favor dar clic en el link anexo para unirse\n\n" + this.JTA_UrlVideoLlamada.getText();
                }
                xenviar3.enviarAdjuntoGenerico(xdestino2, cuerpo, "RECORDATORIO DE CITA", Principal.txtNo.getText() + ".pdf", this.metodos.getRutaRep() + "C_RecordatorioDeCita1.pdf", this.moduloCorreo);
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Correo electrónico no cumple con características\nFavor revisar", "VERIFICACIÓN", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
        this.frmPersona.panelPersona.setSelectedIndex(1);
        this.frmPersona.getTxtCorreo().requestFocus();
    }

    public void revisarCita() {
        try {
            if (this.idCita != null && this.idCita.equals("")) {
                this.sql = "SELECT DISTINCT NoCita, IdProfesionalUltimaCita FROM g_ips";
                ResultSet rs = this.consultas.traerRs(this.sql);
                rs.next();
                String noCita = rs.getString(1);
                String IdProfesional = rs.getString(2);
                rs.close();
                if (!this.idCita.equals(noCita) && this.listaProfesional[this.filaArbol][0].toString().equals(IdProfesional)) {
                    cargarHorarioGrid();
                }
                this.consultas.cerrarConexionBd();
            }
        } catch (SQLException ex) {
            this.consultas.mostrarErrorSQL(ex);
        }
    }

    private int verificarFechaHoraProfesionalEspecialidad(String horaI, String horaF) {
        int op = 0;
        this.sql = "SELECT Id FROM (\n\tSELECT Id, \n\t  CASE WHEN '" + horaI + "'>=HoraInicial AND '" + horaF + "'<=HoraFinal THEN\n\t\t'V'\n\t       WHEN  HoraInicial>='" + horaI + "' AND '" + horaF + "'<=HoraFinal AND  HoraInicial<'" + horaF + "' THEN\t\t\t\n\t\t'V'\n\t       WHEN  '" + horaI + "'>=HoraInicial AND HoraFinal<='" + horaF + "' AND  HoraFinal>'" + horaI + "' THEN\t\n\t\t'V'   \n\t   ELSE\n\t\t'F'\n\t  END DATO\t\n\t,HoraInicial,HoraFinal FROM c_citas WHERE Id_Profesional ='" + this.listaProfesional[this.filaArbol][0] + "' AND Id_Especialidad ='" + this.idEspecialidad + "' AND Fecha_Cita ='" + this.metodos.formatoAMD.format(this.frmCalendario.getFecha().getTime()) + "' \n\tAND Id_MotivoDesistida =1 ) CITAS\nWHERE DATO='V'\t";
        String campo = this.consultas.traerDato(this.sql);
        this.consultas.cerrarConexionBd();
        if (!campo.isEmpty()) {
            op = 1;
        }
        return op;
    }

    /* JADX INFO: loaded from: GenomaP.jar:Citas/CitasGral$MyTreeCellRenderer.class */
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
            DefaultMutableTreeNode xd = (DefaultMutableTreeNode) value;
            if (tree.getModel().getRoot().equals((DefaultMutableTreeNode) value)) {
                setIcon(CitasGral.this.rootIcon);
            } else if (xd.getLevel() == 1) {
                setIcon(CitasGral.this.sedeIcon);
            } else if (xd.getLevel() == 2) {
                setIcon(CitasGral.this.especialidadIcon);
            } else if (xd.getLevel() == 3) {
                setIcon(CitasGral.this.medicoIcon);
            }
            return this;
        }
    }

    /* JADX WARN: Type inference failed for: r3v27, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.mnPopup = new JPopupMenu();
        this.mnAsignar = new JMenuItem();
        this.mnReasignar = new JMenuItem();
        this.mnDesistir = new JMenuItem();
        this.jSeparator1 = new JSeparator();
        this.mnRecordatorio = new JMenuItem();
        this.mnLlamar = new JMenuItem();
        this.mnFacturacion = new JMenuItem();
        this.jSeparator2 = new JSeparator();
        this.mnSalir = new JMenuItem();
        this.grupoRemision = new ButtonGroup();
        this.jPanel5 = new JPanel();
        this.panelCalendario = new JPanel();
        this.jScrollPane1 = new JScrollPane();
        this.Arbol = new JTree();
        this.jScrollPane3 = new JScrollPane();
        this.grid = new JTable();
        this.jPanel2 = new JPanel();
        this.txtCupoAsignado = new JTextField();
        this.txtAtendidas = new JTextField();
        this.txtRestantes = new JTextField();
        this.panelPersona = new JPanel();
        this.jPanel6 = new JPanel();
        this.btnNoRemitido = new JRadioButton();
        this.btnRemitido = new JRadioButton();
        this.btnInterconsulta = new JRadioButton();
        this.jLabel4 = new JLabel();
        this.jButton1 = new JButton();
        this.jPanel3 = new JPanel();
        this.JCBEmpresa = new JComboBox();
        this.JCBSede = new JComboBox();
        this.JTB_DatosC = new JTabbedPane();
        this.jPanel1 = new JPanel();
        this.cboClaseCita = new JComboBox();
        this.txtDuracion = new JTextField();
        txtConsultorio = new JTextField();
        this.JCHSaludOcupacional = new JCheckBox();
        this.btnCitaTelefonica = new JCheckBox();
        this.JDFFechaSolictud = new JDateChooser();
        this.JTFTratamientoO = new JTextField();
        this.jButton2 = new JButton();
        this.jPanel4 = new JPanel();
        this.JTFNAutorizacion = new JTextField();
        this.JSP_UrlVideoLlamada = new JScrollPane();
        this.JTA_UrlVideoLlamada = new JEditorPane();
        this.JCBObservacion = new JCheckBox();
        this.mnPopup.setBorder(BorderFactory.createTitledBorder((Border) null, "Menú de Citas", 2, 0, new Font("Tahoma", 1, 11), new Color(0, 102, 102)));
        this.mnAsignar.setFont(new Font("Arial", 1, 12));
        this.mnAsignar.setText("Asignar Cita");
        this.mnAsignar.addMouseListener(new MouseAdapter() { // from class: Citas.CitasGral.2
            public void mouseClicked(MouseEvent evt) {
                CitasGral.this.mnAsignarMouseClicked(evt);
            }
        });
        this.mnAsignar.addActionListener(new ActionListener() { // from class: Citas.CitasGral.3
            public void actionPerformed(ActionEvent evt) {
                CitasGral.this.mnAsignarActionPerformed(evt);
            }
        });
        this.mnPopup.add(this.mnAsignar);
        this.mnReasignar.setFont(new Font("Arial", 1, 12));
        this.mnReasignar.setText("Reasignar Cita");
        this.mnReasignar.addActionListener(new ActionListener() { // from class: Citas.CitasGral.4
            public void actionPerformed(ActionEvent evt) {
                CitasGral.this.mnReasignarActionPerformed(evt);
            }
        });
        this.mnPopup.add(this.mnReasignar);
        this.mnDesistir.setFont(new Font("Arial", 1, 12));
        this.mnDesistir.setText("Desistir Cita");
        this.mnDesistir.addActionListener(new ActionListener() { // from class: Citas.CitasGral.5
            public void actionPerformed(ActionEvent evt) {
                CitasGral.this.mnDesistirActionPerformed(evt);
            }
        });
        this.mnPopup.add(this.mnDesistir);
        this.mnPopup.add(this.jSeparator1);
        this.mnRecordatorio.setFont(new Font("Arial", 1, 12));
        this.mnRecordatorio.setText("Imprimir Recordatorio de Cita");
        this.mnRecordatorio.addActionListener(new ActionListener() { // from class: Citas.CitasGral.6
            public void actionPerformed(ActionEvent evt) {
                CitasGral.this.mnRecordatorioActionPerformed(evt);
            }
        });
        this.mnPopup.add(this.mnRecordatorio);
        this.mnLlamar.setFont(new Font("Arial", 1, 12));
        this.mnLlamar.setText("Llamar al Usuario");
        this.mnLlamar.addActionListener(new ActionListener() { // from class: Citas.CitasGral.7
            public void actionPerformed(ActionEvent evt) {
                CitasGral.this.mnLlamarActionPerformed(evt);
            }
        });
        this.mnPopup.add(this.mnLlamar);
        this.mnFacturacion.setFont(new Font("Arial", 1, 12));
        this.mnFacturacion.setText("Facturación");
        this.mnFacturacion.addActionListener(new ActionListener() { // from class: Citas.CitasGral.8
            public void actionPerformed(ActionEvent evt) {
                CitasGral.this.mnFacturacionActionPerformed(evt);
            }
        });
        this.mnPopup.add(this.mnFacturacion);
        this.mnPopup.add(this.jSeparator2);
        this.mnSalir.setFont(new Font("Arial", 1, 12));
        this.mnSalir.setText("Salir");
        this.mnSalir.addActionListener(new ActionListener() { // from class: Citas.CitasGral.9
            public void actionPerformed(ActionEvent evt) {
                CitasGral.this.mnSalirActionPerformed(evt);
            }
        });
        this.mnPopup.add(this.mnSalir);
        setClosable(true);
        setIconifiable(true);
        setTitle("ASIGNACIÓN CITAS");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMaximumSize(new Dimension(1256, 854));
        setMinimumSize(new Dimension(1256, 854));
        setName("Citas");
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        addInternalFrameListener(new InternalFrameListener() { // from class: Citas.CitasGral.10
            public void internalFrameActivated(InternalFrameEvent evt) {
                CitasGral.this.formInternalFrameActivated(evt);
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                CitasGral.this.formInternalFrameClosing(evt);
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
        this.panelCalendario.setLayout((LayoutManager) null);
        this.Arbol.setFont(new Font("Arial", 1, 11));
        this.Arbol.setName("Arbol");
        this.Arbol.addTreeSelectionListener(new TreeSelectionListener() { // from class: Citas.CitasGral.11
            public void valueChanged(TreeSelectionEvent evt) {
                CitasGral.this.ArbolValueChanged(evt);
            }
        });
        this.jScrollPane1.setViewportView(this.Arbol);
        this.jScrollPane3.setBorder(BorderFactory.createTitledBorder((Border) null, "fecha", 2, 0, new Font("Arial", 1, 14), new Color(0, 0, 255)));
        this.grid.setFont(new Font("Arial", 1, 12));
        this.grid.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.grid.setAutoResizeMode(3);
        this.grid.setCellSelectionEnabled(true);
        this.grid.setName("grid");
        this.grid.setRowHeight(25);
        this.grid.setSelectionBackground(new Color(255, 255, 255));
        this.grid.setSelectionForeground(Color.red);
        this.grid.setSelectionMode(0);
        this.grid.addMouseMotionListener(new MouseMotionAdapter() { // from class: Citas.CitasGral.12
            public void mouseMoved(MouseEvent evt) {
                CitasGral.this.gridMouseMoved(evt);
            }
        });
        this.grid.addMouseListener(new MouseAdapter() { // from class: Citas.CitasGral.13
            public void mouseClicked(MouseEvent evt) {
                CitasGral.this.gridMouseClicked(evt);
            }

            public void mousePressed(MouseEvent evt) {
                CitasGral.this.gridMousePressed(evt);
            }
        });
        this.jScrollPane3.setViewportView(this.grid);
        this.grid.getColumnModel().getSelectionModel().setSelectionMode(1);
        this.jPanel2.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS DE LA EMPRESA DEL AFILIADO", 0, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.txtCupoAsignado.setEditable(false);
        this.txtCupoAsignado.setFont(new Font("Arial", 1, 12));
        this.txtCupoAsignado.setHorizontalAlignment(0);
        this.txtCupoAsignado.setToolTipText("No. de Cupo Asignado");
        this.txtCupoAsignado.setBorder(BorderFactory.createTitledBorder((Border) null, "C. Asignado", 2, 0, new Font("Arial", 1, 12), new Color(255, 255, 255)));
        this.txtCupoAsignado.setDisabledTextColor(new Color(0, 0, 0));
        this.txtCupoAsignado.setEnabled(false);
        this.txtCupoAsignado.setName("txtCupo");
        this.txtAtendidas.setEditable(false);
        this.txtAtendidas.setFont(new Font("Arial", 1, 12));
        this.txtAtendidas.setHorizontalAlignment(0);
        this.txtAtendidas.setBorder(BorderFactory.createTitledBorder((Border) null, "Atendidas", 2, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtAtendidas.setDisabledTextColor(new Color(0, 0, 0));
        this.txtAtendidas.setEnabled(false);
        this.txtAtendidas.setName("txtAtendidas");
        this.txtRestantes.setEditable(false);
        this.txtRestantes.setFont(new Font("Arial", 1, 12));
        this.txtRestantes.setHorizontalAlignment(0);
        this.txtRestantes.setBorder(BorderFactory.createTitledBorder((Border) null, "Restantes", 2, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtRestantes.setDisabledTextColor(new Color(0, 0, 0));
        this.txtRestantes.setEnabled(false);
        this.txtRestantes.setName("txtRestantes");
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGap(4, 4, 4).addComponent(this.txtCupoAsignado, -2, 90, -2).addGap(0, 0, 0).addComponent(this.txtAtendidas, -2, 90, -2).addGap(0, 0, 0).addComponent(this.txtRestantes, -2, 100, -2)));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGap(1, 1, 1).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.txtCupoAsignado, -2, 40, -2).addComponent(this.txtAtendidas, -2, 40, -2).addComponent(this.txtRestantes, -2, 40, -2))));
        this.panelPersona.setMaximumSize(new Dimension(1000, 160));
        this.panelPersona.setMinimumSize(new Dimension(1000, 160));
        this.panelPersona.setPreferredSize(new Dimension(1000, 160));
        GroupLayout panelPersonaLayout = new GroupLayout(this.panelPersona);
        this.panelPersona.setLayout(panelPersonaLayout);
        panelPersonaLayout.setHorizontalGroup(panelPersonaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 0, 32767));
        panelPersonaLayout.setVerticalGroup(panelPersonaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 170, 32767));
        this.jPanel6.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "VIENE REMITIDO", 0, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.jPanel6.setLayout((LayoutManager) null);
        this.grupoRemision.add(this.btnNoRemitido);
        this.btnNoRemitido.setFont(new Font("Arial", 1, 12));
        this.btnNoRemitido.setForeground(new Color(0, 0, 255));
        this.btnNoRemitido.setSelected(true);
        this.btnNoRemitido.setText("No Remitido");
        this.btnNoRemitido.addActionListener(new ActionListener() { // from class: Citas.CitasGral.14
            public void actionPerformed(ActionEvent evt) {
                CitasGral.this.btnNoRemitidoActionPerformed(evt);
            }
        });
        this.jPanel6.add(this.btnNoRemitido);
        this.btnNoRemitido.setBounds(10, 20, 100, 28);
        this.grupoRemision.add(this.btnRemitido);
        this.btnRemitido.setFont(new Font("Arial", 1, 12));
        this.btnRemitido.setForeground(new Color(0, 0, 255));
        this.btnRemitido.setText("Remitido");
        this.btnRemitido.addActionListener(new ActionListener() { // from class: Citas.CitasGral.15
            public void actionPerformed(ActionEvent evt) {
                CitasGral.this.btnRemitidoActionPerformed(evt);
            }
        });
        this.jPanel6.add(this.btnRemitido);
        this.btnRemitido.setBounds(110, 20, 80, 28);
        this.grupoRemision.add(this.btnInterconsulta);
        this.btnInterconsulta.setFont(new Font("Arial", 1, 12));
        this.btnInterconsulta.setForeground(new Color(0, 0, 255));
        this.btnInterconsulta.setText("Interconsulta");
        this.btnInterconsulta.addActionListener(new ActionListener() { // from class: Citas.CitasGral.16
            public void actionPerformed(ActionEvent evt) {
                CitasGral.this.btnInterconsultaActionPerformed(evt);
            }
        });
        this.jPanel6.add(this.btnInterconsulta);
        this.btnInterconsulta.setBounds(190, 20, 100, 28);
        this.jLabel4.setFont(new Font("Arial", 1, 14));
        this.jLabel4.setHorizontalAlignment(0);
        this.jLabel4.setIcon(new ImageIcon(getClass().getResource("/Imagenes/buscarCita.jpg")));
        this.jLabel4.setText("Carnet de Citas");
        this.jLabel4.setToolTipText("Busca citas asignadas del usuario actual");
        this.jLabel4.setBorder(BorderFactory.createBevelBorder(0));
        this.jLabel4.setCursor(new Cursor(0));
        this.jLabel4.setHorizontalTextPosition(0);
        this.jLabel4.setVerticalTextPosition(3);
        this.jLabel4.addMouseListener(new MouseAdapter() { // from class: Citas.CitasGral.17
            public void mouseClicked(MouseEvent evt) {
                CitasGral.this.jLabel4MouseClicked(evt);
            }
        });
        this.jButton1.setFont(new Font("Arial", 1, 12));
        this.jButton1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Bueno.png")));
        this.jButton1.setText("Consolidado");
        this.jButton1.addActionListener(new ActionListener() { // from class: Citas.CitasGral.18
            public void actionPerformed(ActionEvent evt) {
                CitasGral.this.jButton1ActionPerformed(evt);
            }
        });
        this.JCBEmpresa.setBorder(BorderFactory.createTitledBorder((Border) null, "Empresa para facturar", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JCBEmpresa.setName("cboClaseCita");
        this.JCBEmpresa.addActionListener(new ActionListener() { // from class: Citas.CitasGral.19
            public void actionPerformed(ActionEvent evt) {
                CitasGral.this.JCBEmpresaActionPerformed(evt);
            }
        });
        this.JCBSede.setFont(new Font("Arial", 1, 12));
        this.JCBSede.setBorder(BorderFactory.createTitledBorder((Border) null, "Sede de Atención", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JCBSede.setName("cboClaseCita");
        this.JCBSede.addActionListener(new ActionListener() { // from class: Citas.CitasGral.20
            public void actionPerformed(ActionEvent evt) {
                CitasGral.this.JCBSedeActionPerformed(evt);
            }
        });
        this.JTB_DatosC.setForeground(Color.red);
        this.JTB_DatosC.setFont(new Font("Arial", 1, 14));
        this.jPanel1.setFont(new Font("Arial", 1, 14));
        this.cboClaseCita.setAutoscrolls(true);
        this.cboClaseCita.setBorder(BorderFactory.createTitledBorder((Border) null, "Clase de cita", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.cboClaseCita.setName("cboClaseCita");
        this.cboClaseCita.addActionListener(new ActionListener() { // from class: Citas.CitasGral.21
            public void actionPerformed(ActionEvent evt) {
                CitasGral.this.cboClaseCitaActionPerformed(evt);
            }
        });
        this.txtDuracion.setEditable(false);
        this.txtDuracion.setFont(new Font("Arial", 1, 12));
        this.txtDuracion.setHorizontalAlignment(0);
        this.txtDuracion.setBorder(BorderFactory.createTitledBorder((Border) null, "DMinutos", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtDuracion.setDisabledTextColor(new Color(0, 0, 0));
        this.txtDuracion.setEnabled(false);
        this.txtDuracion.setName("txtDuracion");
        txtConsultorio.setFont(new Font("Arial", 1, 12));
        txtConsultorio.setBorder(BorderFactory.createTitledBorder((Border) null, "Consultorio", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        txtConsultorio.setDisabledTextColor(new Color(0, 0, 0));
        txtConsultorio.setEnabled(false);
        txtConsultorio.setName("txtConsultorio");
        this.JCHSaludOcupacional.setFont(new Font("Arial", 1, 12));
        this.JCHSaludOcupacional.setForeground(new Color(0, 0, 255));
        this.JCHSaludOcupacional.setText("Salud Ocupacional");
        this.JCHSaludOcupacional.addActionListener(new ActionListener() { // from class: Citas.CitasGral.22
            public void actionPerformed(ActionEvent evt) {
                CitasGral.this.JCHSaludOcupacionalActionPerformed(evt);
            }
        });
        this.btnCitaTelefonica.setFont(new Font("Arial", 1, 12));
        this.btnCitaTelefonica.setForeground(new Color(0, 0, 255));
        this.btnCitaTelefonica.setText("Cita Telefónica?");
        this.btnCitaTelefonica.addActionListener(new ActionListener() { // from class: Citas.CitasGral.23
            public void actionPerformed(ActionEvent evt) {
                CitasGral.this.btnCitaTelefonicaActionPerformed(evt);
            }
        });
        this.JDFFechaSolictud.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Solicitada", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JDFFechaSolictud.setToolTipText("Fecha de solictud por parte del usuario");
        this.JDFFechaSolictud.setDateFormatString("dd/MM/yyyy");
        this.JDFFechaSolictud.setFont(new Font("Arial", 1, 12));
        this.JDFFechaSolictud.addPropertyChangeListener(new PropertyChangeListener() { // from class: Citas.CitasGral.24
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                CitasGral.this.JDFFechaSolictudPropertyChange(evt);
            }
        });
        this.JTFTratamientoO.setEditable(false);
        this.JTFTratamientoO.setFont(new Font("Arial", 1, 18));
        this.JTFTratamientoO.setForeground(Color.red);
        this.JTFTratamientoO.setHorizontalAlignment(0);
        this.JTFTratamientoO.setText("0");
        this.JTFTratamientoO.setToolTipText("Tratamiento Odontología");
        this.JTFTratamientoO.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Tratamiento", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFTratamientoO.setDisabledTextColor(new Color(0, 0, 0));
        this.JTFTratamientoO.setName("txtCupo");
        this.JTFTratamientoO.addMouseListener(new MouseAdapter() { // from class: Citas.CitasGral.25
            public void mouseClicked(MouseEvent evt) {
                CitasGral.this.JTFTratamientoOMouseClicked(evt);
            }
        });
        this.JTFTratamientoO.addActionListener(new ActionListener() { // from class: Citas.CitasGral.26
            public void actionPerformed(ActionEvent evt) {
                CitasGral.this.JTFTratamientoOActionPerformed(evt);
            }
        });
        this.jButton2.setFont(new Font("Arial", 1, 12));
        this.jButton2.setIcon(new ImageIcon(getClass().getResource("/Imagenes/actualizar.png")));
        this.jButton2.setToolTipText("Actualizar datos (Sede, empresa a facturar y clase de cita)");
        this.jButton2.addActionListener(new ActionListener() { // from class: Citas.CitasGral.27
            public void actionPerformed(ActionEvent evt) {
                CitasGral.this.jButton2ActionPerformed(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addComponent(this.txtDuracion, -2, 83, -2).addGap(14, 14, 14).addComponent(txtConsultorio).addGap(6, 6, 6)).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JTFTratamientoO, -2, 120, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jButton2, -2, 58, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JDFFechaSolictud, -2, 123, -2)).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.btnCitaTelefonica, -2, 129, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JCHSaludOcupacional))).addContainerGap()).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.cboClaseCita, -2, 296, -2).addContainerGap(-1, 32767)))));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addGap(3, 3, 3).addComponent(this.cboClaseCita, -2, 50, -2).addGap(2, 2, 2).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(txtConsultorio, -2, -1, -2).addComponent(this.txtDuracion)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCHSaludOcupacional, -2, 20, -2).addComponent(this.btnCitaTelefonica, -2, 20, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JDFFechaSolictud, -2, -1, -2).addComponent(this.JTFTratamientoO, -2, 40, -2).addComponent(this.jButton2)).addGap(4, 4, 4)));
        this.JTB_DatosC.addTab("INFORMACIÓN DE LA CITA", this.jPanel1);
        this.JTFNAutorizacion.setFont(new Font("Arial", 1, 18));
        this.JTFNAutorizacion.setForeground(Color.red);
        this.JTFNAutorizacion.setHorizontalAlignment(0);
        this.JTFNAutorizacion.setToolTipText("Tratamiento Odontología");
        this.JTFNAutorizacion.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Autorizacion", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNAutorizacion.setDisabledTextColor(new Color(0, 0, 0));
        this.JTFNAutorizacion.setName("txtCupo");
        this.JSP_UrlVideoLlamada.setBorder(BorderFactory.createTitledBorder((Border) null, "Url Video Llamada", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JTA_UrlVideoLlamada.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 12)));
        this.JTA_UrlVideoLlamada.setFont(new Font("Arial", 1, 12));
        this.JTA_UrlVideoLlamada.addMouseListener(new MouseAdapter() { // from class: Citas.CitasGral.28
            public void mouseClicked(MouseEvent evt) {
                CitasGral.this.JTA_UrlVideoLlamadaMouseClicked(evt);
            }
        });
        this.JSP_UrlVideoLlamada.setViewportView(this.JTA_UrlVideoLlamada);
        this.JCBObservacion.setText("Observacion");
        this.JCBObservacion.addItemListener(new ItemListener() { // from class: Citas.CitasGral.29
            public void itemStateChanged(ItemEvent evt) {
                CitasGral.this.JCBObservacionItemStateChanged(evt);
            }
        });
        this.JCBObservacion.addActionListener(new ActionListener() { // from class: Citas.CitasGral.30
            public void actionPerformed(ActionEvent evt) {
                CitasGral.this.JCBObservacionActionPerformed(evt);
            }
        });
        GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
        this.jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addContainerGap().addComponent(this.JTFNAutorizacion, -2, 182, -2)).addGroup(jPanel4Layout.createSequentialGroup().addGap(16, 16, 16).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBObservacion).addComponent(this.JSP_UrlVideoLlamada, -2, 294, -2)))).addContainerGap(19, 32767)));
        jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addContainerGap().addComponent(this.JTFNAutorizacion, -2, 50, -2).addGap(18, 18, 18).addComponent(this.JSP_UrlVideoLlamada, -2, 103, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBObservacion).addContainerGap(16, 32767)));
        this.JTB_DatosC.addTab("ADICIONAL", this.jPanel4);
        GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
        this.jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTB_DatosC).addGroup(jPanel3Layout.createSequentialGroup().addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBSede, -2, 298, -2).addComponent(this.JCBEmpresa, -2, 298, -2)).addGap(0, 0, 32767))).addContainerGap()));
        jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup().addGap(5, 5, 5).addComponent(this.JCBEmpresa, -2, 50, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBSede, -2, 50, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTB_DatosC).addContainerGap()));
        GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
        this.jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addGap(8, 8, 8).addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addComponent(this.panelPersona, -2, 971, -2).addGap(75, 75, 75).addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel4, -2, 120, -2).addComponent(this.jButton1, -2, 120, -2))).addGroup(jPanel5Layout.createSequentialGroup().addComponent(this.jScrollPane1, -2, 252, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(jPanel5Layout.createSequentialGroup().addComponent(this.jPanel6, -2, 298, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel2, -2, -1, -2)).addComponent(this.jScrollPane3)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.panelCalendario, -1, -1, 32767).addComponent(this.jPanel3, -1, -1, -2)))).addContainerGap()));
        jPanel5Layout.setVerticalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.panelPersona, -2, 170, -2).addGroup(GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup().addContainerGap().addComponent(this.jLabel4, -2, 110, -2).addGap(10, 10, 10).addComponent(this.jButton1, -2, 30, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED))).addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(jPanel5Layout.createSequentialGroup().addComponent(this.panelCalendario, -2, 288, -2).addGap(3, 3, 3).addComponent(this.jPanel3, -2, -1, -2)).addGroup(jPanel5Layout.createSequentialGroup().addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane1, -2, 565, -2).addGroup(jPanel5Layout.createSequentialGroup().addComponent(this.jScrollPane3, -2, 498, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jPanel2, -1, -1, 32767).addComponent(this.jPanel6, -2, 67, -2)))).addGap(52, 52, 52)))));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel5, -2, -1, -2));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel5, -2, -1, -2).addContainerGap(-1, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ArbolValueChanged(TreeSelectionEvent evt) {
        evaluarNodo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mnAsignarActionPerformed(ActionEvent evt) {
        mAsignarCitas();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mnDesistirActionPerformed(ActionEvent evt) {
        desistir();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mnSalirActionPerformed(ActionEvent evt) {
        this.mnPopup.setVisible(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboClaseCitaActionPerformed(ActionEvent evt) {
        if (this.combocc == 1 && this.cboClaseCita.getSelectedIndex() > -1) {
            this.txtDuracion.setText(this.listaClaseCita[this.cboClaseCita.getSelectedIndex()][1]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnCitaTelefonicaActionPerformed(ActionEvent evt) {
        if (this.btnCitaTelefonica.isSelected()) {
            this.citaTelefonica = 1;
        } else {
            this.citaTelefonica = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mnRecordatorioActionPerformed(ActionEvent evt) {
        this.mnPopup.setVisible(false);
        mVisualizacionImpresionRecordatorio();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnNoRemitidoActionPerformed(ActionEvent evt) {
        this.remitida = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnRemitidoActionPerformed(ActionEvent evt) {
        this.remitida = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnInterconsultaActionPerformed(ActionEvent evt) {
        interConsulta();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gridMousePressed(MouseEvent evt) {
        if (evt.getButton() == 3) {
            this.mnPopup.setVisible(true);
            this.mnPopup.setLocation(evt.getLocationOnScreen().x, evt.getLocationOnScreen().y);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mnReasignarActionPerformed(ActionEvent evt) {
        reasignar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mnLlamarActionPerformed(ActionEvent evt) {
        llamarUsuario();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameActivated(InternalFrameEvent evt) {
        if (this.grid.getRowCount() > -1 && this.idCita != null) {
            Principal.txtNo.setText(this.idCita);
            Principal.txtEstado.setText("ACTIVA");
            Principal.txtFecha.setText(this.metodos.formatoDMA.format(this.frmCalendario.getFecha().getTime()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gridMouseMoved(MouseEvent evt) {
        this.grid.setToolTipText(this.modeloGrid.getValueAt(this.filaGrid, 5).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jLabel4MouseClicked(MouseEvent evt) {
        JIFCarneCitas frmB = new JIFCarneCitas(null, true, this.frmPersona.getIdPersona(), "Citas", this);
        frmB.setLocationRelativeTo(this);
        frmB.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHSaludOcupacionalActionPerformed(ActionEvent evt) {
        if (this.JCHSaludOcupacional.isSelected()) {
            this.xsaludocupacional = 1;
        } else {
            this.xsaludocupacional = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jButton1ActionPerformed(ActionEvent evt) {
        if (!this.idEspecialidad.equals("")) {
            JDConsolidadoCitas frmconsolidado = new JDConsolidadoCitas(this);
            frmconsolidado.setVisible(true);
        } else {
            JOptionPane.showInternalMessageDialog(this, "Debe escoger un especialista", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBEmpresaActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBSedeActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gridMouseClicked(MouseEvent evt) {
        if (this.grid.getSelectedRow() != -1) {
            this.filaGrid = this.grid.getSelectedRow();
            if (this.grid.getValueAt(this.filaGrid, 2) == null || this.grid.getValueAt(this.filaGrid, 2).toString().equals(" ") || this.grid.getValueAt(this.filaGrid, 2).toString().equals("- Fin Programación de Turno -  ") || this.grid.getValueAt(this.filaGrid, 2).toString().equals("Libre / Permiso / Vacaciones")) {
                this.metodos.limpiarDatosPrincipal();
                return;
            }
            try {
                if (!this.modeloGrid.getValueAt(this.grid.getSelectedRow(), 3).toString().equals("0")) {
                    if (!this.modeloGrid.getValueAt(this.grid.getSelectedRow(), 3).toString().equals("0")) {
                        this.frmPersona.setIdPersona(this.grid.getValueAt(this.filaGrid, 4).toString());
                        this.frmPersona.buscar(1);
                    }
                    this.idCita = this.grid.getValueAt(this.filaGrid, 3).toString();
                    this.sql = "SELECT concat(c_clasecita.`Nbre`, ' - (',c_clasecita.`Duracion`,' Minutos)') , `f_empresacontxconvenio`.`Nbre`, DATE_FORMAT(`c_citas`.`Fecha_Cita`,'%d-%m-%Y') AS fecha, `g_sedes`.`Nbre`, c_citas.Id_TratamientoO, `c_citas`.`Fecha_SUsuario` AS fechaU, c_citas.`Id_ingreso`, c_citas.`Url_videollamada`, c_citas.`NAutorizacion`, c_citas.Observacion  FROM  `c_citas` INNER JOIN  `c_clasecita`  ON (`c_citas`.`Id_ClaseCita` = `c_clasecita`.`Id`) INNER JOIN  `f_empresacontxconvenio`  ON (`c_citas`.`Id_EmpresaCont` = `f_empresacontxconvenio`.`Id`)  INNER JOIN  `g_sedes`  ON (`c_citas`.`Id_Sede` = `g_sedes`.`Id`) WHERE (`c_citas`.`Id` ='" + this.idCita + "') ";
                    System.out.println("Consulta clic---> " + this.sql);
                    ResultSet xrs = this.consultas.traerRs(this.sql);
                    Throwable th = null;
                    try {
                        try {
                            if (xrs.next()) {
                                xrs.first();
                                Principal.txtNo.setText(this.idCita);
                                Principal.txtEstado.setText("ACTIVA");
                                Principal.txtFecha.setText(xrs.getString(3));
                                this.JCBEmpresa.setSelectedItem(xrs.getString(2));
                                this.cboClaseCita.setSelectedItem(xrs.getString(1));
                                this.JCBSede.setSelectedItem(xrs.getString(4));
                                this.JDFFechaSolictud.setDate(xrs.getDate("fechaU"));
                                this.JTFTratamientoO.setText(xrs.getString("Id_TratamientoO"));
                                if (this.JCBObservacion.isSelected()) {
                                    this.JTA_UrlVideoLlamada.setText(xrs.getString("Observacion"));
                                } else {
                                    this.JTA_UrlVideoLlamada.setText(xrs.getString("Url_videollamada"));
                                }
                                if (this.idEspecialidad.equals("1024") || this.idEspecialidad.equals("1023") || this.idEspecialidad.equals("461") || this.idEspecialidad.equals("1032") || this.idEspecialidad.equals("250")) {
                                    this.JTFTratamientoO.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Tratamiento", 2, 0, new Font("Arial", 1, 12), Color.blue));
                                    this.JTFTratamientoO.setText(xrs.getString("Id_TratamientoO"));
                                } else {
                                    this.JTFTratamientoO.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Ingreso", 2, 0, new Font("Arial", 1, 12), Color.blue));
                                    this.JTFTratamientoO.setText(xrs.getString("Id_ingreso"));
                                }
                                this.JTFNAutorizacion.setText(xrs.getString("NAutorizacion"));
                                this.urlRes = xrs.getString("Url_videollamada");
                                this.observacionRes = xrs.getString("Observacion");
                            }
                            if (xrs != null) {
                                if (0 != 0) {
                                    try {
                                        xrs.close();
                                    } catch (Throwable th2) {
                                        th.addSuppressed(th2);
                                    }
                                } else {
                                    xrs.close();
                                }
                            }
                            this.consultas.cerrarConexionBd();
                        } finally {
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        throw th3;
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(CitasGral.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFTratamientoOMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            if (this.idEspecialidad.equals("1024") || this.idEspecialidad.equals("1023") || this.idEspecialidad.equals("461") || this.idEspecialidad.equals("1032") || this.idEspecialidad.equals("250")) {
                if (this.cboClaseCita.getSelectedIndex() != -1) {
                    JDTratamientos xtratmientoO = new JDTratamientos(Principal.clasescita.frmPrincipal, true, this);
                    xtratmientoO.setLocationRelativeTo(Principal.clasescita.frmPrincipal);
                    xtratmientoO.setVisible(true);
                    return;
                } else {
                    JOptionPane.showInternalMessageDialog(this, "Debe selecionar una clase de cita", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    this.cboClaseCita.requestFocus();
                    return;
                }
            }
            if (this.JTFTratamientoO.getText().isEmpty() || this.JTFTratamientoO.getText().equals("0")) {
                if (!this.frmPersona.getIdPersona().equals("0")) {
                    if (!this.idEspecialidad.equals("")) {
                        JDConsultarIngreso xJDConsultarIngreso = new JDConsultarIngreso(null, true, this.frmPersona.getIdPersona(), "CCitas", this.idEspecialidad);
                        xJDConsultarIngreso.setLocationRelativeTo(this);
                        xJDConsultarIngreso.setVisible(true);
                        return;
                    }
                    JOptionPane.showInternalMessageDialog(this, "Debe selecionar una especialidad", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Debe selecionar un usuario", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                return;
            }
            JDConsultarIngreso xJDConsultarIngreso2 = new JDConsultarIngreso(null, true, this.frmPersona.getIdPersona(), "CCitas", this.idEspecialidad);
            xJDConsultarIngreso2.setLocationRelativeTo(this);
            xJDConsultarIngreso2.setVisible(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        Principal.mLimpiarDatosP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mnAsignarMouseClicked(MouseEvent evt) {
        mAsignarCitas();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jButton2ActionPerformed(ActionEvent evt) {
        mActualizarDatos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFFechaSolictudPropertyChange(PropertyChangeEvent evt) {
        this.xCambioFecha = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFTratamientoOActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mnFacturacionActionPerformed(ActionEvent evt) {
        if (!Principal.txtNo.getText().isEmpty()) {
            this.mnPopup.setVisible(false);
            this.clasescita.mIniciarD();
            Principal.clasefacturacion.frmFacturac.frmPersona.txtHistoria.setText(this.frmPersona.txtHistoria.getText());
            Principal.clasefacturacion.frmFacturac.frmPersona.buscar(2);
            Principal.clasefacturacion.frmFacturac.frmOrdenes.JDC_FechaCitas.setDate(this.frmCalendario.getFecha().getTime());
            setVisible(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTA_UrlVideoLlamadaMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2 && !this.JTA_UrlVideoLlamada.getText().isEmpty()) {
            this.metodos.abrirEnlaceWeb(this.JTA_UrlVideoLlamada.getText());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBObservacionActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBObservacionItemStateChanged(ItemEvent evt) {
        if (this.JCBObservacion.isSelected()) {
            System.out.println("esta seleccionada");
            this.JSP_UrlVideoLlamada.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), Color.red));
            this.JCBObservacion.setText("Url Video Llamada");
            if (!this.JTA_UrlVideoLlamada.getText().isEmpty() || this.JTA_UrlVideoLlamada.getText() != null) {
                this.resUrl = this.JTA_UrlVideoLlamada.getText();
            }
            this.JTA_UrlVideoLlamada.setText("");
        } else {
            System.out.println("esta deseleccionada");
            this.JSP_UrlVideoLlamada.setBorder(BorderFactory.createTitledBorder((Border) null, "Url Video Llamada", 0, 0, new Font("Arial", 1, 12), Color.red));
            this.JCBObservacion.setText("Observación");
            if (!this.JTA_UrlVideoLlamada.getText().isEmpty() || this.JTA_UrlVideoLlamada.getText() != null) {
                this.resObservacion = this.JTA_UrlVideoLlamada.getText();
            }
            this.JTA_UrlVideoLlamada.setText("");
        }
        System.out.println("resO -> " + this.resObservacion);
        System.out.println("resU -> " + this.resUrl);
    }

    private void mActualizarDatos() {
        if (!Principal.txtNo.getText().isEmpty()) {
            try {
                this.sql = "SELECT  `Id_ingreso`\nFROM `c_citas`\nWHERE (`Id` ='" + Principal.txtNo.getText() + "')";
                ResultSet xrs = this.consultas.traerRs(this.sql);
                if (xrs.next()) {
                    xrs.first();
                    if (xrs.getString(1).equals("0")) {
                        ConsultasMySQL xct = new ConsultasMySQL();
                        this.sql = "update c_citas  set `Id_EmpresaCont`='" + this.xidempresafac[this.JCBEmpresa.getSelectedIndex()] + "', `Id_ClaseCita`='" + this.listaClaseCita[this.cboClaseCita.getSelectedIndex()][0] + "', `Id_TratamientoO`='" + this.JTFTratamientoO.getText() + "', `Id_Sede`='" + this.xidsede[this.JCBSede.getSelectedIndex()] + "', `Id_ingreso`='" + getIdIngreso() + "', `Url_videollamada`='" + this.JTA_UrlVideoLlamada.getText() + "' where Id='" + Principal.txtNo.getText() + "'";
                        xct.ejecutarSQL(this.sql);
                        xct.cerrarConexionBd();
                        this.sql = "update ingreso set Id_Sede='" + this.xidsede[this.JCBSede.getSelectedIndex()] + "' where Id='" + xrs.getString(1) + "'";
                        xct.ejecutarSQL(this.sql);
                        xct.cerrarConexionBd();
                        this.sql = "update h_atencion set Id_ClaseCita='" + this.listaClaseCita[this.cboClaseCita.getSelectedIndex()][0] + "' where Id_Ingreso='" + xrs.getString(1) + "'";
                        xct.ejecutarSQL(this.sql);
                        xct.cerrarConexionBd();
                        this.mnPopup.setVisible(false);
                    } else {
                        JOptionPane.showInternalMessageDialog(this, "Esta cita ya posee una factura activa, favor anularla para poder realizar esta accion", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    }
                }
                this.consultas.cerrarConexionBd();
                return;
            } catch (SQLException ex) {
                Logger.getLogger(CitasGral.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                return;
            }
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una cita", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.mnPopup.setVisible(false);
    }
}
