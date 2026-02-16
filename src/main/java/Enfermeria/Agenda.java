package Enfermeria;

import Acceso.Principal;
import Historia.clasesHistoriaCE;
import Laboratorio.Render;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Toolkit;
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
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
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
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Enfermeria/Agenda.class */
public class Agenda extends JInternalFrame {
    private Metodos xmt;
    private ConsultasMySQL xct;
    private int estado;
    private int filaGrid;
    private int xlleno;
    private int estado1;
    private long xidatencionesp;
    private Object[] dato;
    private String sql;
    public Long xidingreso;
    public DefaultTableModel xmodelo;
    public DefaultTableModel xmodelo1;
    public DefaultTableModel xmodelo2;
    private claseEnfermeria claseEnf;
    private String[] xidespecialidad;
    private String[] xidprofesional;
    private String[] xidtipocita;
    private boolean xestado;
    private String modulo;
    public AtomicBoolean EstadoTarea;
    private ButtonGroup JBGFiltro;
    private ButtonGroup JBGFiltroNp;
    private JButton JBTReasignar;
    private JComboBox JCBEspecialidad;
    private JComboBox JCBProfesional;
    private JComboBox JCBTipoCita;
    public static JCheckBox JCHAgendaT;
    private JCheckBox JCHPAtender;
    private JPanel JPAtencionesEspeciales;
    private JPanel JPIFiltro;
    private JPanel JPIFiltro1;
    private JScrollPane JSPDatosAgenta;
    private JScrollPane JSPDatosAtenciones;
    private JScrollPane JSPDatosProcedimientos;
    private JTable JTBDatosAgenda;
    private JTable JTBDatosAtenciones;
    private JTable JTBDatosProcedimiento;
    private JTabbedPane JTPDatos;
    private JRadioButton btnPorAtender;
    private JRadioButton btnPorAtender1;
    private JRadioButton btnTodas;
    private JRadioButton btnTodas1;
    private JRadioButton tnAtendidas;
    private JRadioButton tnAtendidas1;
    private JTextField txtCantidad;
    public JDateChooser txtFecha;

    public Agenda(claseEnfermeria clase, String modulo) {
        this.xmt = new Metodos();
        this.xct = new ConsultasMySQL();
        this.estado = 0;
        this.filaGrid = 0;
        this.xlleno = 0;
        this.estado1 = 0;
        this.xidatencionesp = 0L;
        this.xestado = false;
        this.EstadoTarea = new AtomicBoolean(true);
        initComponents();
        this.claseEnf = clase;
        this.modulo = modulo;
        this.txtFecha.setDate(this.xmt.getFechaActual());
        this.xidespecialidad = this.xct.llenarCombo("SELECT Id, Nbre FROM g_especialidad WHERE (Estado =0) ORDER BY Nbre ASC", this.xidespecialidad, this.JCBEspecialidad);
        this.JCBEspecialidad.setSelectedIndex(-1);
        this.xct.cerrarConexionBd();
        this.xestado = true;
        crearGrid();
        mCrearTabla();
        mCrearTablaAE();
        ejecutarTareaTimer();
        this.xlleno = 1;
    }

    public Agenda() {
        this.xmt = new Metodos();
        this.xct = new ConsultasMySQL();
        this.estado = 0;
        this.filaGrid = 0;
        this.xlleno = 0;
        this.estado1 = 0;
        this.xidatencionesp = 0L;
        this.xestado = false;
        this.EstadoTarea = new AtomicBoolean(true);
        initComponents();
        this.txtFecha.setDate(this.xmt.getFechaActual());
        crearGrid();
        mCrearTabla();
        this.JTBDatosAgenda.addMouseListener(new MouseAdapter() { // from class: Enfermeria.Agenda.1
            public void mouseClicked(MouseEvent e) {
                Agenda.this.filaGrid = Agenda.this.JTBDatosAgenda.rowAtPoint(e.getPoint());
                if (e.getClickCount() > 1) {
                    if (Agenda.this.modulo.equals("triage")) {
                        Agenda.this.cargarFormularioTriage();
                    } else {
                        Agenda.this.cargarAtencion();
                    }
                }
            }
        });
        ejecutarTareaTimer();
        this.xlleno = 1;
    }

    private void ejecutarTareaTimer() {
        final Timer timer = new Timer();
        timer.schedule(new TimerTask() { // from class: Enfermeria.Agenda.2
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (Agenda.this.EstadoTarea.get()) {
                    if (Agenda.JCHAgendaT.isSelected()) {
                        Agenda.this.mCargarDatosDTriage();
                        return;
                    }
                    Agenda.this.cargarDatos();
                    Agenda.this.mCargarDatos();
                    Agenda.this.mCargarDatosAE();
                    return;
                }
                System.out.println("Finaliza ejecucion de Timer de Agenda de Laboratorio");
                timer.cancel();
            }
        }, 0L, 30000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cargarFormularioTriage() {
        try {
            this.EstadoTarea.set(false);
            this.claseEnf.cargarPantalla("Atencion");
            this.claseEnf.frmAtencion.frmIngreso.JCH_AplicaFiltroConvenio.setSelected(false);
            this.claseEnf.frmAtencion.frmIngreso.llenarComboConvenio(6);
            this.claseEnf.frmAtencion.frmPersona.txtHistoria.setText(this.xmodelo.getValueAt(this.JTBDatosAgenda.getSelectedRow(), 0).toString());
            System.out.println("" + this.xmodelo.getValueAt(this.JTBDatosAgenda.getSelectedRow(), 0).toString());
            this.claseEnf.frmAtencion.frmPersona.buscar(2);
            if (Long.valueOf(this.xmodelo.getValueAt(this.JTBDatosAgenda.getSelectedRow(), 16).toString()).longValue() != 0) {
                this.claseEnf.frmAtencion.frmIngreso.cargarIngreso(this.xmodelo.getValueAt(this.JTBDatosAgenda.getSelectedRow(), 16).toString());
            } else {
                this.claseEnf.frmAtencion.txtHorallegada.setText(this.xmodelo.getValueAt(this.filaGrid, 4).toString());
                this.claseEnf.frmAtencion.setIdHoraLlegada(this.xmodelo.getValueAt(this.filaGrid, 5).toString());
                this.claseEnf.frmAtencion.frmIngreso.cboEmpresa.setSelectedItem(this.xmodelo.getValueAt(this.filaGrid, 8).toString());
                this.claseEnf.frmAtencion.frmIngreso.cboEstrato1.setSelectedItem(this.xmodelo.getValueAt(this.filaGrid, 9).toString());
                this.claseEnf.frmAtencion.frmIngreso.txtNombreA.setText(this.xmodelo.getValueAt(this.filaGrid, 10).toString());
                this.claseEnf.frmAtencion.frmIngreso.txtTelefonoA.setText(this.xmodelo.getValueAt(this.filaGrid, 11).toString());
                this.claseEnf.frmAtencion.frmIngreso.txtNombreR.setText(this.xmodelo.getValueAt(this.filaGrid, 12).toString());
                this.claseEnf.frmAtencion.frmIngreso.txtTelefonoR.setText(this.xmodelo.getValueAt(this.filaGrid, 13).toString());
                this.claseEnf.frmAtencion.frmIngreso.cboParentescoR.setSelectedItem(this.xmodelo.getValueAt(this.filaGrid, 14).toString());
                this.claseEnf.frmAtencion.frmIngreso.cboTipoAtencion.setSelectedItem(this.xmodelo.getValueAt(this.filaGrid, 18).toString());
                this.claseEnf.frmAtencion.frmIngreso.cboCausaExterna.setSelectedItem(this.xmodelo.getValueAt(this.filaGrid, 19).toString());
                this.claseEnf.frmAtencion.frmIngreso.JCBEscolaridad.setSelectedItem(this.xmodelo.getValueAt(this.filaGrid, 20).toString());
                this.claseEnf.frmAtencion.frmIngreso.JCBOcupaciones.setSelectedItem(this.xmodelo.getValueAt(this.filaGrid, 21).toString());
                this.claseEnf.frmAtencion.frmIngreso.JCBTipoAfiliado.setSelectedItem(this.xmodelo.getValueAt(this.filaGrid, 24).toString());
                this.claseEnf.frmAtencion.frmIngreso.JCB_TipoCoberturaPlan.setSelectedItem(this.xmodelo.getValueAt(this.filaGrid, 25).toString());
                this.claseEnf.frmAtencion.frmIngreso.JCB_TipoContratacion.setSelectedItem(this.xmodelo.getValueAt(this.filaGrid, 26).toString());
                this.claseEnf.frmAtencion.txtAtencion.setText(this.xmodelo.getValueAt(this.filaGrid, 16).toString());
            }
            mConsultarAtencionEspecial();
            dispose();
        } catch (Throwable ex) {
            Logger.getLogger(Agenda.class.getName()).log(Level.SEVERE, (String) null, ex);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cargarAtencion() {
        Throwable th;
        Object[] botones = {"Ingreso(Triage)", "Nota de Enfermeria", "Anular Registro", "Cerrar"};
        int n = JOptionPane.showInternalOptionDialog(this, "Que desea hacer?", "CONSULTAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones, "Cerrar");
        switch (n) {
            case 0:
                cargarFormularioTriage();
                return;
            case 1:
                if (JCHAgendaT.isSelected()) {
                    try {
                        this.sql = "SELECT Id, Id_Ingreso FROM h_atencion WHERE (Id_Ingreso ='" + this.xmodelo.getValueAt(this.filaGrid, 9) + "')";
                        ResultSet xrs = this.xct.traerRs(this.sql);
                        if (xrs.next()) {
                            xrs.first();
                            Principal.clasehistoriace = new clasesHistoriaCE();
                            clasesHistoriaCE.informacionAgendaMedicaDTO.setIdTipohc(6);
                            clasesHistoriaCE.informacionAgendaMedicaDTO.setNombreSexo(this.xmodelo.getValueAt(this.filaGrid, 4).toString());
                            clasesHistoriaCE.informacionAgendaMedicaDTO.setNumeroHistoria(this.xmodelo.getValueAt(this.filaGrid, 0).toString());
                            clasesHistoriaCE.informacionAgendaMedicaDTO.setIdUsuarioAtendido(Long.valueOf(this.xmodelo.getValueAt(this.filaGrid, 10).toString()));
                            clasesHistoriaCE.informacionAgendaMedicaDTO.setEdad(this.xmodelo.getValueAt(this.filaGrid, 2).toString() + "-" + this.xmodelo.getValueAt(this.filaGrid, 3).toString());
                            clasesHistoriaCE.informacionAgendaMedicaDTO.setIdAtencion(xrs.getString(1));
                            clasesHistoriaCE.informacionAgendaMedicaDTO.setIdIngreso(Long.valueOf(xrs.getLong(2)));
                            clasesHistoriaCE.informacionAgendaMedicaDTO.setNombreUsuario(this.xmodelo.getValueAt(this.filaGrid, 1).toString());
                            clasesHistoriaCE.informacionAgendaMedicaDTO.setIdPrograma(0);
                            clasesHistoriaCE.informacionAgendaMedicaDTO.setEsOdontologica(0);
                            clasesHistoriaCE.informacionAgendaMedicaDTO.setEsPeriodico(0);
                            clasesHistoriaCE.informacionAgendaMedicaDTO.setEsRemitada(0);
                            dispose();
                            this.EstadoTarea.set(false);
                            Principal.clasehistoriace.cargarPantalla("Historia", this.claseEnf.xjp, "Historia_Enf");
                        }
                        xrs.close();
                        this.xct.cerrarConexionBd();
                    } catch (NumberFormatException | SQLException ex) {
                        Logger.getLogger(Agenda.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                    }
                    break;
                } else {
                    if (!this.xmodelo.getValueAt(this.filaGrid, 16).toString().equals(0)) {
                        try {
                            this.sql = "SELECT Id, Id_Ingreso FROM h_atencion WHERE (Id_Ingreso ='" + this.xmodelo.getValueAt(this.filaGrid, 16) + "')";
                            ResultSet xrs2 = this.xct.traerRs(this.sql);
                            Throwable th2 = null;
                            try {
                                try {
                                    if (xrs2.next()) {
                                        xrs2.first();
                                        Principal.clasehistoriace = new clasesHistoriaCE();
                                        clasesHistoriaCE.informacionAgendaMedicaDTO.setIdTipohc(6);
                                        clasesHistoriaCE.informacionAgendaMedicaDTO.setNombreSexo(this.xmodelo.getValueAt(this.filaGrid, 15).toString());
                                        clasesHistoriaCE.informacionAgendaMedicaDTO.setNumeroHistoria(this.xmodelo.getValueAt(this.filaGrid, 0).toString());
                                        clasesHistoriaCE.informacionAgendaMedicaDTO.setIdUsuarioAtendido(Long.valueOf(this.xmodelo.getValueAt(this.filaGrid, 17).toString()));
                                        clasesHistoriaCE.informacionAgendaMedicaDTO.setEdad(this.xmodelo.getValueAt(this.filaGrid, 2).toString() + "-" + this.xmodelo.getValueAt(this.filaGrid, 3).toString());
                                        clasesHistoriaCE.informacionAgendaMedicaDTO.setIdAtencion(xrs2.getString(1));
                                        clasesHistoriaCE.informacionAgendaMedicaDTO.setIdIngreso(Long.valueOf(xrs2.getLong(2)));
                                        clasesHistoriaCE.informacionAgendaMedicaDTO.setNombreUsuario(this.xmodelo.getValueAt(this.filaGrid, 1).toString());
                                        clasesHistoriaCE.informacionAgendaMedicaDTO.setIdPrograma(0);
                                        clasesHistoriaCE.informacionAgendaMedicaDTO.setEsOdontologica(0);
                                        clasesHistoriaCE.informacionAgendaMedicaDTO.setEsPeriodico(0);
                                        clasesHistoriaCE.informacionAgendaMedicaDTO.setEsRemitada(0);
                                        dispose();
                                        this.EstadoTarea.set(false);
                                        Principal.clasehistoriace.cargarPantalla("Historia", this.claseEnf.xjp, "Historia_Enf");
                                    }
                                    if (xrs2 != null) {
                                        if (0 != 0) {
                                            try {
                                                xrs2.close();
                                            } catch (Throwable th3) {
                                                th2.addSuppressed(th3);
                                            }
                                        } else {
                                            xrs2.close();
                                        }
                                    }
                                    this.xct.cerrarConexionBd();
                                } finally {
                                    if (xrs2 != null) {
                                        if (th != null) {
                                            try {
                                                break;
                                            } catch (Throwable th4) {
                                            }
                                        }
                                    }
                                }
                            } catch (Throwable th5) {
                                th2 = th5;
                                throw th5;
                            }
                        } catch (NumberFormatException | SQLException ex2) {
                            Logger.getLogger(Agenda.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex2);
                        }
                    }
                    break;
                }
                setVisible(false);
                return;
            case 2:
                int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de anular el registro?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (x == 0) {
                    this.sql = " update h_horallegada set Estado=0 where Id='" + this.xmodelo.getValueAt(this.filaGrid, 5) + "'";
                    this.xct.ejecutarSQL(this.sql);
                    this.xct.cerrarConexionBd();
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void mConsultarAtencionEspecial() {
        try {
            String xsql = "SELECT  IF(DATE(NOW())>=ADDDATE(`h_atencion`.`Fecha_Atencion`, INTERVAL 30  DAY),0,1)  AS `Tipo`, `h_atencion`.`Fecha_Atencion`, `h_atencion`.`Hora_Atencion`, `c_clasecita`.`Nbre` AS TipoCIta, `profesional1`.`Especialidad`, `profesional1`.`NProfesional`, `h_atencion`.`Codigo_Dxp` , `g_patologia`.`Nbre`, `h_atencion`.`Id` FROM  `h_atencion` INNER JOIN  `ingreso`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN `g_usuario`  ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`) INNER JOIN `c_clasecita`  ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)  INNER JOIN `profesional1` ON (`profesional1`.`IdEspecialidad` = `h_atencion`.`Id_Especialidad`) AND (`profesional1`.`Id_Persona` = `h_atencion`.`Id_Profesional`) INNER JOIN `g_patologia`  ON (`g_patologia`.`Id` = `h_atencion`.`Codigo_Dxp`) WHERE (`h_atencion`.`Ip6` =1 AND `h_atencion`.`Id_Especialidad` =382 AND IF(DATE(NOW())>=ADDDATE(`h_atencion`.`Fecha_Atencion`, INTERVAL 30  DAY),0,1)  =1 AND `g_usuario`.`NoHistoria` ='" + this.xmodelo.getValueAt(this.JTBDatosAgenda.getSelectedRow(), 0).toString() + "') ";
            ConsultasMySQL xct1 = new ConsultasMySQL();
            ResultSet xrs = xct1.traerRs(xsql);
            if (xrs.next()) {
                xrs.first();
                String xmensaje = "<html><P ALIGN=center> <font face='Arial' color='black' size=4>  <b>Usuario clasificado como posible atención especial :<br><P ALIGN=left><font face='Arial' color='red' size=4>N° Atención : <font face='Arial' color='green' size=4>" + xrs.getString(9) + "<br><P ALIGN=left><font face='Arial' color='red' size=4>Fecha y Hora : <font face='Arial' color='green' size=4>" + xrs.getString(2) + " " + xrs.getString(3) + "<br><P ALIGN=left><font face='Arial' color='red' size=4>Tipo Cita : <font face='Arial' color='green' size=4>" + xrs.getString(4) + "<br><P ALIGN=left><font face='Arial' color='red' size=4>Profesional : <font face='Arial' color='green' size=4>" + xrs.getString(6) + "<br><P ALIGN=left><font face='Arial' color='red' size=4>Impresión Dx : <font face='Arial' color='green' size=4>" + xrs.getString(7) + "-" + xrs.getString(8);
                JOptionPane.showMessageDialog(this, xmensaje, " INFORMACIÓN ATENCIÓN ESPECIAL", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            }
            xrs.close();
            xct1.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(Agenda.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearGrid() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"No. Historia", "Usuario", "Edad", "Sexo", "Hora de Llegada", "Id", "Atendido", "Estado", "", "", "Nacompañanate", "TelefonoA", "NResponsable", "TelefonoR", "Parentesco", "IdSexo", "IDIngreso", "IdUsuario", "TipoAtencion", "CExterna", "Estudios", "Ocupacion", "Capacidad Especial", "Forma", "TipoAfiliacion", "TipoCoberturaPlan", "TipoContratacion"}) { // from class: Enfermeria.Agenda.3
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Integer.class, JLabel.class, String.class, String.class, String.class};
            boolean[] canEdit = {true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBDatosAgenda.setModel(this.xmodelo);
        this.JTBDatosAgenda.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTBDatosAgenda.getColumnModel().getColumn(1).setPreferredWidth(300);
        this.JTBDatosAgenda.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTBDatosAgenda.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTBDatosAgenda.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTBDatosAgenda.getColumnModel().getColumn(5).setPreferredWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(5).setMinWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(5).setMaxWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(6).setPreferredWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(6).setMinWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(6).setMaxWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.JTBDatosAgenda.getColumnModel().getColumn(8).setPreferredWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(8).setMinWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(8).setMaxWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(9).setPreferredWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(9).setMinWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(9).setMaxWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(10).setPreferredWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(10).setMinWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(10).setMaxWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(11).setPreferredWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(11).setMinWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(11).setMaxWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(12).setPreferredWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(12).setMinWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(12).setMaxWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(13).setPreferredWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(13).setMinWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(13).setMaxWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(14).setPreferredWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(14).setMinWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(14).setMaxWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(15).setPreferredWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(15).setMinWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(15).setMaxWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(16).setPreferredWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(16).setMinWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(16).setMaxWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(17).setPreferredWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(17).setMinWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(17).setMaxWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(18).setPreferredWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(18).setMinWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(18).setMaxWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(19).setPreferredWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(19).setMinWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(19).setMaxWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(20).setPreferredWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(20).setMinWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(20).setMaxWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(21).setPreferredWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(21).setMinWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(21).setMaxWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(22).setPreferredWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(22).setMinWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(22).setMaxWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(23).setPreferredWidth(50);
        this.JTBDatosAgenda.getColumnModel().getColumn(24).setPreferredWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(24).setMinWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(24).setMaxWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(25).setPreferredWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(25).setMinWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(25).setMaxWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(26).setPreferredWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(26).setMinWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(26).setMaxWidth(0);
        this.JTBDatosAgenda.setRowHeight(50);
        this.filaGrid = 0;
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTabla() {
        this.xmodelo1 = new DefaultTableModel(new Object[0], new String[]{"No. Historia", "Usuario", "Edad", "Sexo", "Procedimiento", "Hora de Llegada", "", "Estado", "", "Id_Ingreso"}) { // from class: Enfermeria.Agenda.4
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, Integer.class, String.class, Long.class, Integer.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBDatosProcedimiento.setModel(this.xmodelo1);
        this.JTBDatosProcedimiento.getColumnModel().getColumn(0).setPreferredWidth(50);
        this.JTBDatosProcedimiento.getColumnModel().getColumn(1).setPreferredWidth(200);
        this.JTBDatosProcedimiento.getColumnModel().getColumn(2).setPreferredWidth(50);
        this.JTBDatosProcedimiento.getColumnModel().getColumn(3).setPreferredWidth(50);
        this.JTBDatosProcedimiento.getColumnModel().getColumn(4).setPreferredWidth(350);
        this.JTBDatosProcedimiento.getColumnModel().getColumn(5).setPreferredWidth(50);
        this.JTBDatosProcedimiento.getColumnModel().getColumn(6).setPreferredWidth(0);
        this.JTBDatosProcedimiento.getColumnModel().getColumn(6).setMinWidth(0);
        this.JTBDatosProcedimiento.getColumnModel().getColumn(6).setMaxWidth(0);
        this.JTBDatosProcedimiento.getColumnModel().getColumn(7).setPreferredWidth(50);
        this.JTBDatosProcedimiento.getColumnModel().getColumn(8).setPreferredWidth(0);
        this.JTBDatosProcedimiento.getColumnModel().getColumn(8).setMinWidth(0);
        this.JTBDatosProcedimiento.getColumnModel().getColumn(8).setMaxWidth(0);
        this.JTBDatosProcedimiento.getColumnModel().getColumn(9).setPreferredWidth(0);
        this.JTBDatosProcedimiento.getColumnModel().getColumn(9).setMinWidth(0);
        this.JTBDatosProcedimiento.getColumnModel().getColumn(9).setMaxWidth(0);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTablaAE() {
        this.xmodelo2 = new DefaultTableModel(new Object[0], new String[]{"No. Historia", "Usuario", "Edad", "Sexo", "Tipo Consulta", "Hora Registro", "Especialidad", "Profesional", "Estado", "Id"}) { // from class: Enfermeria.Agenda.5
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Long.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBDatosAtenciones.setModel(this.xmodelo2);
        this.JTBDatosAtenciones.getColumnModel().getColumn(0).setPreferredWidth(50);
        this.JTBDatosAtenciones.getColumnModel().getColumn(1).setPreferredWidth(200);
        this.JTBDatosAtenciones.getColumnModel().getColumn(2).setPreferredWidth(30);
        this.JTBDatosAtenciones.getColumnModel().getColumn(3).setPreferredWidth(10);
        this.JTBDatosAtenciones.getColumnModel().getColumn(4).setPreferredWidth(50);
        this.JTBDatosAtenciones.getColumnModel().getColumn(5).setPreferredWidth(20);
        this.JTBDatosAtenciones.getColumnModel().getColumn(6).setPreferredWidth(30);
        this.JTBDatosAtenciones.getColumnModel().getColumn(7).setPreferredWidth(50);
        this.JTBDatosAtenciones.getColumnModel().getColumn(8).setPreferredWidth(30);
        this.JTBDatosAtenciones.getColumnModel().getColumn(9).setPreferredWidth(0);
        this.JTBDatosAtenciones.getColumnModel().getColumn(9).setMinWidth(0);
        this.JTBDatosAtenciones.getColumnModel().getColumn(9).setMaxWidth(0);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTablaDTiage() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"No. Historia", "Usuario", "Edad", "Sexo", "Hora de Llegada", "Estado", "Clasificacion", "Especialidad", "Profesional", "IdIngreso", "IdUsuario", "IdAtencion"}) { // from class: Enfermeria.Agenda.6
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, Long.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBDatosAgenda.setModel(this.xmodelo);
        this.JTBDatosAgenda.getColumnModel().getColumn(0).setPreferredWidth(50);
        this.JTBDatosAgenda.getColumnModel().getColumn(1).setPreferredWidth(400);
        this.JTBDatosAgenda.getColumnModel().getColumn(2).setPreferredWidth(50);
        this.JTBDatosAgenda.getColumnModel().getColumn(3).setPreferredWidth(50);
        this.JTBDatosAgenda.getColumnModel().getColumn(4).setPreferredWidth(50);
        this.JTBDatosAgenda.getColumnModel().getColumn(5).setPreferredWidth(50);
        this.JTBDatosAgenda.getColumnModel().getColumn(6).setPreferredWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(6).setMinWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(6).setMaxWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(7).setPreferredWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(7).setMinWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(7).setMaxWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(8).setPreferredWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(8).setMinWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(8).setMaxWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(9).setPreferredWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(9).setMinWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(9).setMaxWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(10).setPreferredWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(10).setMinWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(10).setMaxWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(11).setPreferredWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(11).setMinWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(11).setMaxWidth(0);
    }

    public void cargarDatos() {
        if (this.txtFecha.getDate() != null && this.xmodelo != null) {
            crearGrid();
            this.sql = "SELECT\n    `g_usuario`.`NoHistoria`\n    , CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2`,' ',`g_persona`.`Nombre1`,' ',`g_persona`.`Nombre2`) AS `NUsuario`\n    , g_persona.`Edad`\n    , `g_sexo`.`Nbre` AS `NSexo`\n    ,  TIME(h_horallegada.Fecha_Hora) AS `HoraLlegada`\n    , `h_horallegada`.`Id` as idHoraLlegada\n    , `h_horallegada`.`Atendido`\n    , `f_empresacontxconvenio`.`Nbre` as convenio\n    , `f_estrato`.`Nbre` as estrado\n    , `h_horallegada`.`NAcompananate`\n    , `h_horallegada`.`TelefonoAcomp`\n    , `h_horallegada`.`NPersonaResp`\n    , `h_horallegada`.`TelefonoPResp`\n    , `g_parentesco`.`Nbre` as parentesco\n    , `g_sexo`.`Id` as idSexo\n    , `h_horallegada`.`Id_Ingreso`\n    , `g_persona`.`Id` as idPersona\n    , `g_tipoatencion`.`Nbre` as TipoAtencion\n    , `h_horallegada`.`CausaExterna`\n    , h_horallegada.Escolaridad as nivelEstudio\n    , h_horallegada.Ocupacion as ocupacion \n    , IF(`h_horallegada`.`CEspecial` IS NULL, '0',`h_horallegada`.`CEspecial`) AS CEspecial\n    , h_horallegada.TipoAfiliacion \n    , h_horallegada.TipoCoberturaPlan \n    , h_horallegada.TipoContratacion  \nFROM\n     `g_usuario`\n    INNER JOIN  `h_horallegada` \n        ON (`g_usuario`.`Id_persona` = `h_horallegada`.`Id_Usuario`)\n    INNER JOIN  `g_persona` \n        ON (`g_persona`.`Id` = `g_usuario`.`Id_persona`)\n    INNER JOIN  `f_empresacontxconvenio` \n        ON (`f_empresacontxconvenio`.`Id` = `h_horallegada`.`Id_Empresa`)\n    INNER JOIN  `f_estrato` \n        ON (`f_estrato`.`Id` = `h_horallegada`.`Id_Estrato`)\n    INNER JOIN  `g_parentesco` \n        ON (`h_horallegada`.`Id_Parentesco` = `g_parentesco`.`Id`)\n    INNER JOIN  `g_sexo` \n        ON (`g_persona`.`Id_Sexo` = `g_sexo`.`Id`) \n    INNER JOIN `g_tipoatencion` \n        ON (`h_horallegada`.`Id_TipoAtencion` = `g_tipoatencion`.`Id`)\nWHERE (h_horallegada.Estado=1 AND h_horallegada.Id_Sede='" + Principal.sedeUsuarioSeleccionadaDTO.getId() + "' AND  DATE_FORMAT(h_horallegada.Fecha_Hora,'%Y/%m%/%d')='" + this.xmt.formatoAMD.format(this.txtFecha.getDate());
            switch (this.estado) {
                case 0:
                    this.sql += "' and h_horallegada.Atendido='0') ORDER BY h_horallegada.Fecha_Hora ASC";
                    break;
                case 1:
                    this.sql += "' and h_horallegada.Atendido='1') ORDER BY h_horallegada.Fecha_Hora ASC";
                    break;
                case 2:
                    this.sql += "') ORDER BY h_horallegada.Fecha_Hora ASC";
                    break;
            }
            System.out.println(this.sql);
            ResultSet rs = this.xct.traerRs(this.sql);
            while (rs.next()) {
                try {
                    this.xmodelo.addRow(this.dato);
                    this.xmodelo.setValueAt(rs.getString("NoHistoria"), this.filaGrid, 0);
                    this.xmodelo.setValueAt(rs.getString("NUsuario"), this.filaGrid, 1);
                    this.xmodelo.setValueAt(rs.getString("Edad"), this.filaGrid, 2);
                    this.xmodelo.setValueAt(rs.getString("NSexo"), this.filaGrid, 3);
                    this.xmodelo.setValueAt(this.xmt.formatoH12.format((Date) rs.getTime("HoraLlegada")), this.filaGrid, 4);
                    this.xmodelo.setValueAt(rs.getString("idHoraLlegada"), this.filaGrid, 5);
                    this.xmodelo.setValueAt(rs.getString("Atendido"), this.filaGrid, 6);
                    this.xmodelo.setValueAt(rs.getString("convenio"), this.filaGrid, 8);
                    this.xmodelo.setValueAt(rs.getString("estrado"), this.filaGrid, 9);
                    this.xmodelo.setValueAt(rs.getString("NAcompananate"), this.filaGrid, 10);
                    this.xmodelo.setValueAt(rs.getString("TelefonoAcomp"), this.filaGrid, 11);
                    this.xmodelo.setValueAt(rs.getString("NPersonaResp"), this.filaGrid, 12);
                    this.xmodelo.setValueAt(rs.getString("TelefonoPResp"), this.filaGrid, 13);
                    this.xmodelo.setValueAt(rs.getString("parentesco"), this.filaGrid, 14);
                    this.xmodelo.setValueAt(rs.getString("idSexo"), this.filaGrid, 15);
                    this.xmodelo.setValueAt(rs.getString("Id_Ingreso"), this.filaGrid, 16);
                    this.xmodelo.setValueAt(rs.getString("idPersona"), this.filaGrid, 17);
                    this.xmodelo.setValueAt(rs.getString("TipoAtencion"), this.filaGrid, 18);
                    this.xmodelo.setValueAt(rs.getString("CausaExterna"), this.filaGrid, 19);
                    this.xmodelo.setValueAt(rs.getString("nivelEstudio"), this.filaGrid, 20);
                    this.xmodelo.setValueAt(rs.getString("ocupacion"), this.filaGrid, 21);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong("CEspecial")), this.filaGrid, 22);
                    this.xmodelo.setValueAt(rs.getString("TipoAfiliacion"), this.filaGrid, 24);
                    this.xmodelo.setValueAt(rs.getString("TipoCoberturaPlan"), this.filaGrid, 25);
                    this.xmodelo.setValueAt(rs.getString("TipoContratacion"), this.filaGrid, 26);
                    if (rs.getInt("Atendido") == 0) {
                        this.xmodelo.setValueAt("SIN CLASIFICAR", this.filaGrid, 7);
                    } else if (rs.getInt("Atendido") == 1) {
                        this.xmodelo.setValueAt("CLASIFICADO", this.filaGrid, 7);
                    }
                    if (this.xmodelo.getValueAt(this.filaGrid, 6) != null) {
                        if (this.xmodelo.getValueAt(this.filaGrid, 6).toString().equals("0") || !this.xmodelo.getValueAt(this.filaGrid, 6).toString().equals("1")) {
                        }
                        this.JTBDatosAgenda.setDefaultRenderer(Object.class, new MiRender());
                    }
                    switch (rs.getInt("CEspecial")) {
                        case 0:
                            this.xmodelo.setValueAt(new JLabel(""), this.filaGrid, 23);
                            break;
                        case 1:
                            this.xmodelo.setValueAt(new JLabel(new ImageIcon(getClass().getResource("/Imagenes/Atencion Discapasitaods.png"))), this.filaGrid, 23);
                            break;
                        case 2:
                            this.xmodelo.setValueAt(new JLabel(new ImageIcon(getClass().getResource("/Imagenes/Atencion Embarazada.png"))), this.filaGrid, 23);
                            break;
                        case 3:
                            this.xmodelo.setValueAt(new JLabel(new ImageIcon(getClass().getResource("/Imagenes/Atencion Ancianos.png"))), this.filaGrid, 23);
                            break;
                        case 4:
                            this.xmodelo.setValueAt(new JLabel(new ImageIcon(getClass().getResource("/Imagenes/AtpNiños.png"))), this.filaGrid, 23);
                            break;
                        default:
                            this.xmodelo.setValueAt(new JLabel(""), this.filaGrid, 23);
                            break;
                    }
                    this.JTBDatosAgenda.setDefaultRenderer(JLabel.class, new Render(rs.getInt("CEspecial"), 22));
                    this.JTBDatosAgenda.setDefaultRenderer(Object.class, new MiRender());
                    this.filaGrid++;
                } catch (SQLException ex) {
                    this.xct.mostrarErrorSQL(ex);
                    return;
                }
            }
            this.txtCantidad.setText(String.valueOf(this.xmodelo.getRowCount()));
            rs.close();
            this.xct.cerrarConexionBd();
        }
    }

    public void mCargarDatos() {
        if (this.txtFecha.getDate() != null && this.xmodelo1 != null) {
            mCrearTabla();
            ConsultasMySQL xct2 = new ConsultasMySQL();
            this.sql = "  SELECT g_usuario.NoHistoria,CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2`,' ',`g_persona`.`Nombre1`,' ',`g_persona`.`Nombre2`) AS `NUsuario`\n    , `Devuelve_Edad_2F`(g_persona.`FechaNac`, ingreso.`FechaIngreso`) AS `Edad`\n    , `Devuelve_Tipo_Edad_2F`(g_persona.`FechaNac`, ingreso.`FechaIngreso`) AS `NTipoEdad`\n    , `g_sexo`.`Nbre` AS `NSexo`,\n   g_procedimiento.Nbre, f_ordenes.HoraOrden, IF(f_ordenes.EstadoRecep=0,'FACTURADA','ATENDIDO') AS EstadoO,\n   f_ordenes.EstadoRecep, f_ordenes.Id,  \n   ingreso.Id  \nFROM f_itemordenesproced \nINNER JOIN f_ordenes  ON (f_itemordenesproced.Id_Ordenes = f_ordenes.Id) \nINNER JOIN ingreso ON (f_ordenes.Id_Ingreso = ingreso.Id)  \nINNER JOIN g_procedimiento  ON (f_itemordenesproced.Id_Procedimiento = g_procedimiento.Id)\nINNER JOIN   `g_usuario` ON (`g_usuario`.`Id_persona` = `ingreso`.`Id_Usuario`)  \n  INNER JOIN  `g_persona` ON (`g_persona`.`Id` = `g_usuario`.`Id_persona`) \n  INNER JOIN  `f_empresacontxconvenio`  ON (`f_empresacontxconvenio`.`Id` = `ingreso`.`Id_EmpresaContxConv`) \n  INNER JOIN  `g_sexo`  ON (`g_persona`.`Id_Sexo` = `g_sexo`.`Id`) WHERE (ingreso.FechaIngreso ='" + this.xmt.formatoAMD.format(this.txtFecha.getDate()) + "' AND f_ordenes.Estado =0 AND ingreso.Id_Sede ='" + Principal.sedeUsuarioSeleccionadaDTO.getId() + "' AND g_procedimiento.AProcEnfer=1 ";
            switch (this.estado1) {
                case 0:
                    this.sql += " and f_ordenes.EstadoRecep='0')  GROUP BY f_ordenes.Id, f_itemordenesproced.Id_Procedimiento ORDER BY f_ordenes.HoraOrden ASC";
                    break;
                case 1:
                    this.sql += " and f_ordenes.EstadoRecep='1')  GROUP BY f_ordenes.Id, f_itemordenesproced.Id_Procedimiento ORDER BY f_ordenes.HoraOrden ASC";
                    break;
                case 2:
                    this.sql += ") GROUP BY f_ordenes.Id , f_itemordenesproced.Id_Procedimiento ORDER BY f_ordenes.HoraOrden ASC";
                    break;
            }
            ResultSet rs = xct2.traerRs(this.sql);
            try {
                int x = 0;
                if (rs.next()) {
                    rs.beforeFirst();
                    while (rs.next()) {
                        this.xmodelo1.addRow(this.dato);
                        this.xmodelo1.setValueAt(rs.getString(1), x, 0);
                        this.xmodelo1.setValueAt(rs.getString(2), x, 1);
                        this.xmodelo1.setValueAt(rs.getString(3) + " " + rs.getString(4), x, 2);
                        this.xmodelo1.setValueAt(rs.getString(5), x, 3);
                        this.xmodelo1.setValueAt(rs.getString(6), x, 4);
                        this.xmodelo1.setValueAt(rs.getString(7), x, 5);
                        this.xmodelo1.setValueAt(rs.getString(8), x, 7);
                        this.xmodelo1.setValueAt(Integer.valueOf(rs.getInt(9)), x, 6);
                        this.xmodelo1.setValueAt(Long.valueOf(rs.getLong(10)), x, 8);
                        this.xmodelo1.setValueAt(Integer.valueOf(rs.getInt(11)), x, 9);
                        this.JTBDatosProcedimiento.setDefaultRenderer(Object.class, new MiRender());
                        x++;
                    }
                }
                rs.close();
                xct2.cerrarConexionBd();
            } catch (SQLException ex) {
                xct2.mostrarErrorSQL(ex);
            }
        }
    }

    public void mCargarDatosAE() {
        mCrearTablaAE();
        ConsultasMySQL xct2 = new ConsultasMySQL();
        if (this.JCHPAtender.isSelected()) {
            this.sql = "SELECT `g_usuario`.`NoHistoria`\n    , CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2`,' ',`g_persona`.`Nombre1`,' ',`g_persona`.`Nombre2`) AS `NUsuario`\n    , `Devuelve_Edad_2F`(g_persona.`FechaNac`, ingreso.`FechaIngreso`) AS `Edad`\n    , `Devuelve_Tipo_Edad_2F`(g_persona.`FechaNac`,ingreso.`FechaIngreso`) AS `NTipoEdad`\n    , `g_sexo`.`Nbre` AS `NSexo` ,\n `c_clasecita`.`Nbre` , DATE_FORMAT(`h_atencionespeciales`.`Fecha_Atencion`, '%H:%m:%s %p') AS `HoraAtencion`  \n, g_especialidad.`Nbre` Especialidad , \nCONCAT(`profesional1`.`Apellido1` ,' ', `profesional1`.`Apellido2`,' ',`profesional1`.`Nombre1`,' ',`profesional1`.`Nombre2`) NProfesional ,\n IF(`h_atencionespeciales`.`EstadoA`, 'ATENDIDO', 'POR ATENDER') AS ESTADO , `h_atencionespeciales`.`Id`  \nFROM `h_atencionespeciales` \nINNER JOIN  `h_atencion`  ON (`h_atencionespeciales`.`Id_Atencion` = `h_atencion`.`Id`)  \nINNER JOIN  `c_clasecita`   ON (`h_atencionespeciales`.`Id_TipoConsulta` = `c_clasecita`.`Id`)  \nINNER JOIN  `ingreso`   ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) \n \n    INNER JOIN  `g_usuario`\n        ON (`g_usuario`.`Id_persona` = `ingreso`.`Id_Usuario`)\n    INNER JOIN  `g_persona` \n        ON (`g_persona`.`Id` = `g_usuario`.`Id_persona`)\n    INNER JOIN  `f_empresacontxconvenio` \n        ON (`f_empresacontxconvenio`.`Id` = `ingreso`.`Id_EmpresaContxConv`)\n    INNER JOIN  `g_sexo` \n        ON (`g_persona`.`Id_Sexo` = `g_sexo`.`Id`)\nINNER JOIN `g_persona` profesional1  ON (`profesional1`.`Id` = `h_atencionespeciales`.`Id_Profesional`) \nINNER JOIN`g_especialidad`  ON (`g_especialidad`.`Id`= `h_atencionespeciales`.`Id_Especialidad`)  WHERE (DATE_FORMAT(`h_atencionespeciales`.`Fecha_Atencion`,'%Y/%m/%d') ='" + this.xmt.formatoAMD.format(this.txtFecha.getDate()) + "' AND `h_atencionespeciales`.`Id_Sede` ='" + Principal.sedeUsuarioSeleccionadaDTO.getId() + "' AND `h_atencionespeciales`.`Estado`=1 AND `h_atencionespeciales`.`EstadoA`=0) ORDER BY `h_atencionespeciales`.`Fecha_Atencion` ASC ";
        } else {
            this.sql = "SELECT `g_usuario`.`NoHistoria`\n    , CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2`,' ',`g_persona`.`Nombre1`,' ',`g_persona`.`Nombre2`) AS `NUsuario`\n    , `Devuelve_Edad_2F`(g_persona.`FechaNac`, ingreso.`FechaIngreso`) AS `Edad`\n    , `Devuelve_Tipo_Edad_2F`(g_persona.`FechaNac`,ingreso.`FechaIngreso`) AS `NTipoEdad`\n    , `g_sexo`.`Nbre` AS `NSexo` ,\n `c_clasecita`.`Nbre` , DATE_FORMAT(`h_atencionespeciales`.`Fecha_Atencion`, '%H:%m:%s %p') AS `HoraAtencion`  \n, g_especialidad.`Nbre` Especialidad , \nCONCAT(`profesional1`.`Apellido1` ,' ', `profesional1`.`Apellido2`,' ',`profesional1`.`Nombre1`,' ',`profesional1`.`Nombre2`) NProfesional ,\n IF(`h_atencionespeciales`.`EstadoA`, 'ATENDIDO', 'POR ATENDER') AS ESTADO , `h_atencionespeciales`.`Id`  \nFROM `h_atencionespeciales` \nINNER JOIN  `h_atencion`  ON (`h_atencionespeciales`.`Id_Atencion` = `h_atencion`.`Id`)  \nINNER JOIN  `c_clasecita`   ON (`h_atencionespeciales`.`Id_TipoConsulta` = `c_clasecita`.`Id`)  \nINNER JOIN  `ingreso`   ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) \n \n    INNER JOIN  `g_usuario`\n        ON (`g_usuario`.`Id_persona` = `ingreso`.`Id_Usuario`)\n    INNER JOIN  `g_persona` \n        ON (`g_persona`.`Id` = `g_usuario`.`Id_persona`)\n    INNER JOIN  `f_empresacontxconvenio` \n        ON (`f_empresacontxconvenio`.`Id` = `ingreso`.`Id_EmpresaContxConv`)\n    INNER JOIN  `g_sexo` \n        ON (`g_persona`.`Id_Sexo` = `g_sexo`.`Id`)\nINNER JOIN `g_persona` profesional1  ON (`profesional1`.`Id` = `h_atencionespeciales`.`Id_Profesional`) \nINNER JOIN`g_especialidad`  ON (`g_especialidad`.`Id`= `h_atencionespeciales`.`Id_Especialidad`)  WHERE (DATE_FORMAT(`h_atencionespeciales`.`Fecha_Atencion`,'%Y/%m/%d') ='" + this.xmt.formatoAMD.format(this.txtFecha.getDate()) + "' AND `h_atencionespeciales`.`Id_Sede` ='" + Principal.sedeUsuarioSeleccionadaDTO.getId() + "' AND `h_atencionespeciales`.`Estado`=1 AND `h_atencionespeciales`.`EstadoA`=1) ORDER BY `h_atencionespeciales`.`Fecha_Atencion` ASC ";
        }
        ResultSet rs = xct2.traerRs(this.sql);
        try {
            int x = 0;
            if (rs.next()) {
                rs.beforeFirst();
                while (rs.next()) {
                    this.xmodelo2.addRow(this.dato);
                    this.xmodelo2.setValueAt(rs.getString(1), x, 0);
                    this.xmodelo2.setValueAt(rs.getString(2), x, 1);
                    this.xmodelo2.setValueAt(rs.getString(3) + " " + rs.getString(4), x, 2);
                    this.xmodelo2.setValueAt(rs.getString(5), x, 3);
                    this.xmodelo2.setValueAt(rs.getString(6), x, 4);
                    this.xmodelo2.setValueAt(rs.getString(7), x, 5);
                    this.xmodelo2.setValueAt(rs.getString(8), x, 6);
                    this.xmodelo2.setValueAt(rs.getString(9), x, 7);
                    this.xmodelo2.setValueAt(rs.getString(10), x, 8);
                    this.xmodelo2.setValueAt(Long.valueOf(rs.getLong(11)), x, 9);
                    this.JTBDatosAtenciones.setDefaultRenderer(Object.class, new MiRender2());
                    x++;
                }
            }
            rs.close();
            xct2.cerrarConexionBd();
        } catch (SQLException ex) {
            xct2.mostrarErrorSQL(ex);
        }
    }

    public void mCargarDatosDTriage() {
        if (this.txtFecha.getDate() != null && this.xmodelo != null) {
            ConsultasMySQL xct1 = new ConsultasMySQL();
            mCrearTablaDTiage();
            this.sql = "  SELECT `g_usuario`.`NoHistoria`\n    , CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2`,' ',`g_persona`.`Nombre1`,' ',`g_persona`.`Nombre2`) AS `NUsuario`\n    , `Devuelve_Edad_2F`(g_persona.`FechaNac`, ingreso.`FechaIngreso`) AS `Edad`\n    , `Devuelve_Tipo_Edad_2F`(g_persona.`FechaNac`,ingreso.`FechaIngreso`) AS `NTipoEdad`\n    , `g_sexo`.`Id` AS `NSexo` , h_triage.HoraTriage, \n  IF(h_atencion.TipoGuardado=0 && h_atencion.InicioAtencion=0, 'POR ATENDER',IF(h_atencion.TipoGuardado=0 && h_atencion.InicioAtencion=1,'EN ATENCIÓN','ATENDIDO') ) AS Ntipo, h_triage.Clasificacion, IF(h_atencion.TipoGuardado=0 && h_atencion.InicioAtencion=0, 0,IF(h_atencion.TipoGuardado=0 && h_atencion.InicioAtencion=1,1,2) ) AS tipo, \n    g_especialidad.`Nbre` Especialidad ,\n    CONCAT(DATE_FORMAT(h_atencion.Fecha_Atencion,'%d-%m-%Y'), ' - ', CONCAT(`profesional1`.`Apellido1` ,' ', `profesional1`.`Apellido2`,' ',`profesional1`.`Nombre1`,' ',`profesional1`.`Nombre2`)) AS PAtencion,\n     ingreso.Id, ingreso.Id_Usuario, h_atencion.Id  \nFROM h_triage \nINNER JOIN ingreso  ON (h_triage.IdIngreso = ingreso.Id)  \n    INNER JOIN  `g_usuario`\n        ON (`g_usuario`.`Id_persona` = `ingreso`.`Id_Usuario`)\n    INNER JOIN  `g_persona` \n        ON (`g_persona`.`Id` = `g_usuario`.`Id_persona`)\n    INNER JOIN  `f_empresacontxconvenio` \n        ON (`f_empresacontxconvenio`.`Id` = `ingreso`.`Id_EmpresaContxConv`)\n    INNER JOIN  `g_sexo` \n        ON (`g_persona`.`Id_Sexo` = `g_sexo`.`Id`) \nINNER JOIN h_atencion  ON (h_atencion.Id_Ingreso = ingreso.Id) \nINNER JOIN `g_persona` profesional1  ON (`profesional1`.`Id` = `h_atencion`.`Id_Profesional`) \nINNER JOIN`g_especialidad`  ON (`g_especialidad`.`Id`= `h_atencion`.`Id_Especialidad`) WHERE (h_triage.Estado =0 AND h_triage.FechaTriage ='" + this.xmt.formatoAMD.format(this.txtFecha.getDate()) + "' AND ingreso.Id_Sede ='" + Principal.sedeUsuarioSeleccionadaDTO.getId() + "') ORDER BY h_triage.HoraTriage DESC ";
            ResultSet rs = xct1.traerRs(this.sql);
            try {
                int x = 0;
                if (rs.next()) {
                    rs.beforeFirst();
                    while (rs.next()) {
                        this.xmodelo.addRow(this.dato);
                        this.xmodelo.setValueAt(rs.getString(1), x, 0);
                        this.xmodelo.setValueAt(rs.getString(2), x, 1);
                        this.xmodelo.setValueAt(rs.getString(3) + " " + rs.getString(4), x, 2);
                        this.xmodelo.setValueAt(rs.getString(5), x, 3);
                        this.xmodelo.setValueAt(rs.getString(6), x, 4);
                        this.xmodelo.setValueAt(rs.getString(7), x, 5);
                        this.xmodelo.setValueAt(Long.valueOf(rs.getLong(8)), x, 6);
                        this.JTBDatosAgenda.setDefaultRenderer(Object.class, new MiRender1());
                        this.xmodelo.setValueAt(rs.getString(10), x, 7);
                        this.xmodelo.setValueAt(rs.getString(11), x, 8);
                        this.xmodelo.setValueAt(rs.getString(12), x, 9);
                        this.xmodelo.setValueAt(rs.getString(13), x, 10);
                        this.xmodelo.setValueAt(rs.getString(14), x, 11);
                        x++;
                    }
                }
                rs.close();
                xct1.cerrarConexionBd();
            } catch (SQLException ex) {
                xct1.mostrarErrorSQL(ex);
            }
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:Enfermeria/Agenda$MiRender.class */
    public class MiRender extends DefaultTableCellRenderer {
        public MiRender() {
        }

        public Component getTableCellRendererComponent(JTable ytable, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(ytable, value, isSelected, hasFocus, row, column);
            if (ytable.getRowCount() > 0) {
                int atendido = Integer.parseInt(ytable.getValueAt(row, 6).toString());
                if (atendido == 0) {
                    cell.setBackground(new Color(0, 0, 102));
                } else if (atendido == 1) {
                    cell.setBackground(new Color(103, 0, 103));
                }
                cell.setForeground(Color.WHITE);
            }
            return cell;
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:Enfermeria/Agenda$MiRender2.class */
    public class MiRender2 extends DefaultTableCellRenderer {
        public MiRender2() {
        }

        public Component getTableCellRendererComponent(JTable xtable, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(xtable, value, isSelected, hasFocus, row, column);
            if (xtable.getRowCount() > 0) {
                if (xtable.getValueAt(row, 8).toString().equals("ATENDIDO")) {
                    cell.setBackground(new Color(103, 0, 103));
                    cell.setForeground(Color.WHITE);
                } else {
                    cell.setBackground(new Color(0, 0, 102));
                    cell.setForeground(Color.WHITE);
                }
            }
            return cell;
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:Enfermeria/Agenda$MiRender1.class */
    public static class MiRender1 extends DefaultTableCellRenderer {
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            int cantidad = Integer.parseInt(table.getValueAt(row, 6).toString());
            switch (cantidad) {
                case 1:
                    cell.setBackground(new Color(186, 22, 99));
                    cell.setForeground(Color.WHITE);
                    break;
                case 2:
                    cell.setBackground(Color.ORANGE);
                    cell.setForeground(Color.BLACK);
                    break;
                case 3:
                    cell.setBackground(Color.YELLOW);
                    cell.setForeground(Color.BLACK);
                    break;
                case 4:
                    cell.setBackground(new Color(57, 107, 52));
                    cell.setForeground(Color.WHITE);
                    break;
                default:
                    cell.setBackground(new Color(204, 204, 204));
                    cell.setForeground(Color.BLACK);
                    break;
            }
            return cell;
        }
    }

    /* JADX WARN: Type inference failed for: r3v38, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v71, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v77, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGFiltro = new ButtonGroup();
        this.JBGFiltroNp = new ButtonGroup();
        this.JPIFiltro = new JPanel();
        this.btnTodas = new JRadioButton();
        this.btnPorAtender = new JRadioButton();
        this.tnAtendidas = new JRadioButton();
        this.txtFecha = new JDateChooser();
        this.txtCantidad = new JTextField();
        this.JSPDatosAgenta = new JScrollPane();
        this.JTBDatosAgenda = new JTable();
        JCHAgendaT = new JCheckBox();
        this.JPIFiltro1 = new JPanel();
        this.btnTodas1 = new JRadioButton();
        this.btnPorAtender1 = new JRadioButton();
        this.tnAtendidas1 = new JRadioButton();
        this.JTPDatos = new JTabbedPane();
        this.JSPDatosProcedimientos = new JScrollPane();
        this.JTBDatosProcedimiento = new JTable();
        this.JPAtencionesEspeciales = new JPanel();
        this.JSPDatosAtenciones = new JScrollPane();
        this.JTBDatosAtenciones = new JTable();
        this.JCBEspecialidad = new JComboBox();
        this.JCBProfesional = new JComboBox();
        this.JCBTipoCita = new JComboBox();
        this.JBTReasignar = new JButton();
        this.JCHPAtender = new JCheckBox();
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("AGENDA");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMinimumSize(null);
        setName("Agenda");
        addAncestorListener(new AncestorListener() { // from class: Enfermeria.Agenda.7
            public void ancestorMoved(AncestorEvent evt) {
            }

            public void ancestorAdded(AncestorEvent evt) {
            }

            public void ancestorRemoved(AncestorEvent evt) {
                Agenda.this.formAncestorRemoved(evt);
            }
        });
        addInternalFrameListener(new InternalFrameListener() { // from class: Enfermeria.Agenda.8
            public void internalFrameActivated(InternalFrameEvent evt) {
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                Agenda.this.formInternalFrameClosing(evt);
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
        this.JPIFiltro.setBorder(BorderFactory.createTitledBorder((Border) null, "FILTRO PARA AGENDA : ", 0, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.JBGFiltro.add(this.btnTodas);
        this.btnTodas.setFont(new Font("Arial", 1, 12));
        this.btnTodas.setForeground(Color.blue);
        this.btnTodas.setText("Todas");
        this.btnTodas.addActionListener(new ActionListener() { // from class: Enfermeria.Agenda.9
            public void actionPerformed(ActionEvent evt) {
                Agenda.this.btnTodasActionPerformed(evt);
            }
        });
        this.JBGFiltro.add(this.btnPorAtender);
        this.btnPorAtender.setFont(new Font("Arial", 1, 12));
        this.btnPorAtender.setForeground(Color.blue);
        this.btnPorAtender.setSelected(true);
        this.btnPorAtender.setText("Por Atender");
        this.btnPorAtender.addActionListener(new ActionListener() { // from class: Enfermeria.Agenda.10
            public void actionPerformed(ActionEvent evt) {
                Agenda.this.btnPorAtenderActionPerformed(evt);
            }
        });
        this.JBGFiltro.add(this.tnAtendidas);
        this.tnAtendidas.setFont(new Font("Arial", 1, 12));
        this.tnAtendidas.setForeground(Color.blue);
        this.tnAtendidas.setText("Atendidas");
        this.tnAtendidas.addActionListener(new ActionListener() { // from class: Enfermeria.Agenda.11
            public void actionPerformed(ActionEvent evt) {
                Agenda.this.tnAtendidasActionPerformed(evt);
            }
        });
        GroupLayout JPIFiltroLayout = new GroupLayout(this.JPIFiltro);
        this.JPIFiltro.setLayout(JPIFiltroLayout);
        JPIFiltroLayout.setHorizontalGroup(JPIFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFiltroLayout.createSequentialGroup().addContainerGap().addComponent(this.btnPorAtender).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.tnAtendidas).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.btnTodas).addContainerGap(37, 32767)));
        JPIFiltroLayout.setVerticalGroup(JPIFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFiltroLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.btnPorAtender).addComponent(this.tnAtendidas).addComponent(this.btnTodas)));
        this.txtFecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Agenda", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtFecha.setDateFormatString("dd/MM/yyyy");
        this.txtFecha.setFont(new Font("Arial", 1, 12));
        this.txtFecha.addPropertyChangeListener(new PropertyChangeListener() { // from class: Enfermeria.Agenda.12
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                Agenda.this.txtFechaPropertyChange(evt);
            }
        });
        this.txtCantidad.setBackground(new Color(0, 0, 102));
        this.txtCantidad.setFont(new Font("Arial", 1, 14));
        this.txtCantidad.setHorizontalAlignment(0);
        this.txtCantidad.setText("0");
        this.txtCantidad.setToolTipText("Cantidad de usuarios");
        this.txtCantidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Cantidad", 0, 0, new Font("Tahoma", 1, 14), new Color(255, 255, 255)));
        this.txtCantidad.setDisabledTextColor(new Color(255, 255, 255));
        this.txtCantidad.setEnabled(false);
        this.JSPDatosAgenta.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTBDatosAgenda.setFont(new Font("Arial", 1, 12));
        this.JTBDatosAgenda.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTBDatosAgenda.setRowHeight(25);
        this.JTBDatosAgenda.setSelectionBackground(new Color(255, 255, 255));
        this.JTBDatosAgenda.setSelectionForeground(new Color(255, 0, 0));
        this.JTBDatosAgenda.setSelectionMode(0);
        this.JTBDatosAgenda.addMouseListener(new MouseAdapter() { // from class: Enfermeria.Agenda.13
            public void mouseClicked(MouseEvent evt) {
                Agenda.this.JTBDatosAgendaMouseClicked(evt);
            }
        });
        this.JSPDatosAgenta.setViewportView(this.JTBDatosAgenda);
        JCHAgendaT.setFont(new Font("Arial", 1, 12));
        JCHAgendaT.setForeground(Color.red);
        JCHAgendaT.setText("Agenda Triage");
        JCHAgendaT.addActionListener(new ActionListener() { // from class: Enfermeria.Agenda.14
            public void actionPerformed(ActionEvent evt) {
                Agenda.this.JCHAgendaTActionPerformed(evt);
            }
        });
        this.JPIFiltro1.setBorder(BorderFactory.createTitledBorder((Border) null, "FILTRO PARA PROCEDIMIENTOS:", 0, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.JBGFiltroNp.add(this.btnTodas1);
        this.btnTodas1.setFont(new Font("Arial", 1, 12));
        this.btnTodas1.setForeground(Color.blue);
        this.btnTodas1.setText("Todas");
        this.btnTodas1.addActionListener(new ActionListener() { // from class: Enfermeria.Agenda.15
            public void actionPerformed(ActionEvent evt) {
                Agenda.this.btnTodas1ActionPerformed(evt);
            }
        });
        this.JBGFiltroNp.add(this.btnPorAtender1);
        this.btnPorAtender1.setFont(new Font("Arial", 1, 12));
        this.btnPorAtender1.setForeground(Color.blue);
        this.btnPorAtender1.setSelected(true);
        this.btnPorAtender1.setText("Por Atender");
        this.btnPorAtender1.addActionListener(new ActionListener() { // from class: Enfermeria.Agenda.16
            public void actionPerformed(ActionEvent evt) {
                Agenda.this.btnPorAtender1ActionPerformed(evt);
            }
        });
        this.JBGFiltroNp.add(this.tnAtendidas1);
        this.tnAtendidas1.setFont(new Font("Arial", 1, 12));
        this.tnAtendidas1.setForeground(Color.blue);
        this.tnAtendidas1.setText("Atendidas");
        this.tnAtendidas1.addActionListener(new ActionListener() { // from class: Enfermeria.Agenda.17
            public void actionPerformed(ActionEvent evt) {
                Agenda.this.tnAtendidas1ActionPerformed(evt);
            }
        });
        GroupLayout JPIFiltro1Layout = new GroupLayout(this.JPIFiltro1);
        this.JPIFiltro1.setLayout(JPIFiltro1Layout);
        JPIFiltro1Layout.setHorizontalGroup(JPIFiltro1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFiltro1Layout.createSequentialGroup().addContainerGap().addComponent(this.btnPorAtender1).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.tnAtendidas1).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.btnTodas1).addContainerGap(37, 32767)));
        JPIFiltro1Layout.setVerticalGroup(JPIFiltro1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFiltro1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.btnPorAtender1).addComponent(this.tnAtendidas1).addComponent(this.btnTodas1)));
        this.JTPDatos.setForeground(new Color(0, 103, 0));
        this.JTPDatos.setFont(new Font("Arial", 1, 14));
        this.JTBDatosProcedimiento.setFont(new Font("Arial", 1, 12));
        this.JTBDatosProcedimiento.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTBDatosProcedimiento.setRowHeight(25);
        this.JTBDatosProcedimiento.setSelectionBackground(new Color(255, 255, 255));
        this.JTBDatosProcedimiento.setSelectionForeground(new Color(255, 0, 0));
        this.JTBDatosProcedimiento.setSelectionMode(0);
        this.JTBDatosProcedimiento.addMouseListener(new MouseAdapter() { // from class: Enfermeria.Agenda.18
            public void mouseClicked(MouseEvent evt) {
                Agenda.this.JTBDatosProcedimientoMouseClicked(evt);
            }
        });
        this.JSPDatosProcedimientos.setViewportView(this.JTBDatosProcedimiento);
        this.JTPDatos.addTab("PROCEDIMIENTOS", this.JSPDatosProcedimientos);
        this.JTBDatosAtenciones.setFont(new Font("Arial", 1, 12));
        this.JTBDatosAtenciones.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTBDatosAtenciones.setRowHeight(25);
        this.JTBDatosAtenciones.setSelectionBackground(new Color(255, 255, 255));
        this.JTBDatosAtenciones.setSelectionForeground(Color.red);
        this.JTBDatosAtenciones.setSelectionMode(0);
        this.JTBDatosAtenciones.addMouseListener(new MouseAdapter() { // from class: Enfermeria.Agenda.19
            public void mouseClicked(MouseEvent evt) {
                Agenda.this.JTBDatosAtencionesMouseClicked(evt);
            }
        });
        this.JSPDatosAtenciones.setViewportView(this.JTBDatosAtenciones);
        this.JCBEspecialidad.setFont(new Font("Arial", 1, 12));
        this.JCBEspecialidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Especialidad", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBEspecialidad.addItemListener(new ItemListener() { // from class: Enfermeria.Agenda.20
            public void itemStateChanged(ItemEvent evt) {
                Agenda.this.JCBEspecialidadItemStateChanged(evt);
            }
        });
        this.JCBProfesional.setFont(new Font("Arial", 1, 12));
        this.JCBProfesional.setBorder(BorderFactory.createTitledBorder((Border) null, "Profesional", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipoCita.setFont(new Font("Arial", 1, 12));
        this.JCBTipoCita.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Cita", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBTReasignar.setFont(new Font("Arial", 1, 12));
        this.JBTReasignar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTReasignar.setText("Reasignar");
        this.JBTReasignar.addActionListener(new ActionListener() { // from class: Enfermeria.Agenda.21
            public void actionPerformed(ActionEvent evt) {
                Agenda.this.JBTReasignarActionPerformed(evt);
            }
        });
        this.JCHPAtender.setFont(new Font("Arial", 1, 12));
        this.JCHPAtender.setSelected(true);
        this.JCHPAtender.setText("Por Atender?");
        this.JCHPAtender.addActionListener(new ActionListener() { // from class: Enfermeria.Agenda.22
            public void actionPerformed(ActionEvent evt) {
                Agenda.this.JCHPAtenderActionPerformed(evt);
            }
        });
        GroupLayout JPAtencionesEspecialesLayout = new GroupLayout(this.JPAtencionesEspeciales);
        this.JPAtencionesEspeciales.setLayout(JPAtencionesEspecialesLayout);
        JPAtencionesEspecialesLayout.setHorizontalGroup(JPAtencionesEspecialesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPAtencionesEspecialesLayout.createSequentialGroup().addContainerGap().addComponent(this.JCBEspecialidad, -2, 255, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBProfesional, -2, 338, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBTipoCita, 0, 255, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHPAtender).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBTReasignar).addContainerGap()).addGroup(JPAtencionesEspecialesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPAtencionesEspecialesLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPDatosAtenciones, -2, 1092, -2).addContainerGap(-1, 32767))));
        JPAtencionesEspecialesLayout.setVerticalGroup(JPAtencionesEspecialesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPAtencionesEspecialesLayout.createSequentialGroup().addGap(129, 129, 129).addGroup(JPAtencionesEspecialesLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JBTReasignar, GroupLayout.Alignment.LEADING, -1, 45, 32767).addGroup(GroupLayout.Alignment.LEADING, JPAtencionesEspecialesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBEspecialidad, -1, 45, 32767).addComponent(this.JCBProfesional, -1, 45, 32767).addComponent(this.JCBTipoCita, -1, 45, 32767).addComponent(this.JCHPAtender))).addContainerGap()).addGroup(JPAtencionesEspecialesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPAtencionesEspecialesLayout.createSequentialGroup().addContainerGap(20, 32767).addComponent(this.JSPDatosAtenciones, -2, 93, -2).addGap(72, 72, 72))));
        this.JTPDatos.addTab("ATENCIONES ESPECIALES", this.JPAtencionesEspeciales);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JTPDatos, GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup().addComponent(this.txtFecha, -2, 143, -2).addGap(18, 18, 18).addComponent(this.JPIFiltro, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txtCantidad, -2, 126, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(JCHAgendaT).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JPIFiltro1, -2, -1, -2)).addComponent(this.JSPDatosAgenta, GroupLayout.Alignment.LEADING)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JSPDatosAgenta, -1, 421, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(JCHAgendaT).addComponent(this.JPIFiltro, -2, -1, -2).addComponent(this.txtFecha, -2, -1, -2).addComponent(this.txtCantidad, -2, 52, -2).addComponent(this.JPIFiltro1, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTPDatos, -2, 216, -2).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnTodasActionPerformed(ActionEvent evt) {
        this.estado = 2;
        cargarDatos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnPorAtenderActionPerformed(ActionEvent evt) {
        this.estado = 0;
        cargarDatos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tnAtendidasActionPerformed(ActionEvent evt) {
        this.estado = 1;
        cargarDatos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtFechaPropertyChange(PropertyChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBDatosProcedimientoMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2 && this.JTBDatosProcedimiento.getSelectedRow() != -1) {
            Object[] botones = {"Cambiar Estado", "Nota", "Cerrar"};
            int n = JOptionPane.showInternalOptionDialog(this, "Que desea hacer?", "CONSULTAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones, "Cerrar");
            if (n == 0) {
                String xsql = "update f_ordenes set EstadoRecep=1, UsuarioA='" + Principal.usuarioSistemaDTO.getLogin() + "' where Id='" + this.xmodelo1.getValueAt(this.JTBDatosProcedimiento.getSelectedRow(), 8) + "'";
                this.xct.ejecutarSQL(xsql);
                this.xct.cerrarConexionBd();
            } else if (n == 1) {
                if (this.xmodelo1.getValueAt(this.JTBDatosProcedimiento.getSelectedRow(), 6).toString().equals("1")) {
                    this.xidingreso = Long.valueOf(this.xmodelo1.getValueAt(this.JTBDatosProcedimiento.getSelectedRow(), 9).toString());
                    this.claseEnf.cargarPantalla("Notas");
                    this.claseEnf.xjifvisitasdoc.xjppersona.txtHistoria.setText(this.xmodelo1.getValueAt(this.JTBDatosProcedimiento.getSelectedRow(), 0).toString());
                    this.claseEnf.xjifvisitasdoc.xjppersona.buscar(2);
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Debe cambiar el estado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHAgendaTActionPerformed(ActionEvent evt) {
        if (JCHAgendaT.isSelected()) {
            mCargarDatosDTriage();
            return;
        }
        cargarDatos();
        mCargarDatos();
        mCargarDatosAE();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBDatosAgendaMouseClicked(MouseEvent evt) {
        if (this.JTBDatosAgenda.getSelectedRow() != -1) {
            this.filaGrid = this.JTBDatosAgenda.getSelectedRow();
            if (this.modulo.equals("triage")) {
                cargarFormularioTriage();
            } else {
                cargarAtencion();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnTodas1ActionPerformed(ActionEvent evt) {
        this.estado1 = 2;
        mCargarDatos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnPorAtender1ActionPerformed(ActionEvent evt) {
        this.estado1 = 0;
        mCargarDatos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tnAtendidas1ActionPerformed(ActionEvent evt) {
        this.estado1 = 1;
        mCargarDatos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBDatosAtencionesMouseClicked(MouseEvent evt) {
        if (this.JTBDatosAtenciones.getSelectedRow() != -1) {
            this.xidatencionesp = Long.valueOf(this.xmodelo2.getValueAt(this.JTBDatosAtenciones.getSelectedRow(), 9).toString()).longValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBEspecialidadItemStateChanged(ItemEvent evt) {
        if (this.JCBEspecialidad.getSelectedIndex() != -1 && this.xestado) {
            this.JCBProfesional.removeAllItems();
            this.JCBTipoCita.removeAllItems();
            this.xidprofesional = this.xct.llenarCombo("SELECT Id_Persona, NProfesional FROM profesional1 WHERE (Estado =0 AND IdEspecialidad ='" + this.xidespecialidad[this.JCBEspecialidad.getSelectedIndex()] + "') ORDER BY NProfesional ASC", this.xidprofesional, this.JCBProfesional);
            this.JCBProfesional.setSelectedIndex(-1);
            this.xct.cerrarConexionBd();
            this.xidtipocita = this.xct.llenarCombo("SELECT Id, Nbre FROM c_clasecita WHERE (Id_Especialidad ='" + this.xidespecialidad[this.JCBEspecialidad.getSelectedIndex()] + "' AND Estado =0) ORDER BY Nbre ASC", this.xidtipocita, this.JCBTipoCita);
            this.JCBTipoCita.setSelectedIndex(-1);
            this.xct.cerrarConexionBd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHPAtenderActionPerformed(ActionEvent evt) {
        mCargarDatosAE();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTReasignarActionPerformed(ActionEvent evt) {
        if (this.JCHPAtender.isSelected() && this.xidatencionesp != 0) {
            if (this.JCBEspecialidad.getSelectedIndex() != -1) {
                if (this.JCBProfesional.getSelectedIndex() != -1) {
                    if (this.JCBTipoCita.getSelectedIndex() != -1) {
                        int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de reasignar la atención?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                        if (x == 0) {
                            this.sql = "update h_atencionespeciales set Id_TipoConsulta='" + this.xidtipocita[this.JCBTipoCita.getSelectedIndex()] + "',  Id_Profesional='" + this.xidprofesional[this.JCBProfesional.getSelectedIndex()] + "',  Id_Especialidad ='" + this.xidespecialidad[this.JCBEspecialidad.getSelectedIndex()] + "' where Id='" + this.xidatencionesp + "'";
                            this.xct.ejecutarSQL(this.sql);
                            this.xct.cerrarConexionBd();
                            mCargarDatosAE();
                            this.xidatencionesp = 0L;
                            return;
                        }
                        return;
                    }
                    JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un tipo de cita", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    this.JCBTipoCita.requestFocus();
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un profesional", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JCBProfesional.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una especialidad", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBEspecialidad.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una atención", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formAncestorRemoved(AncestorEvent evt) {
        this.EstadoTarea.set(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        this.EstadoTarea.set(false);
    }
}
