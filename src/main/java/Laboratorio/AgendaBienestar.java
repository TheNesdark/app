package Laboratorio;

import Acceso.Principal;
import Facturacion.JIFAgendaTaquilla;
import Utilidades.ConsultasMySQL;
import Utilidades.ConsultasSqlServer;
import Utilidades.Metodos;
import com.genoma.plus.dao.impl.laboratorio.LaboratorioBienestarDAOImpl;
import com.genoma.plus.dto.laboratorio.AgendaDetalleDTO;
import com.genoma.plus.jpa.entities.LlamadasEntity;
import com.genoma.plus.jpa.service.LlamadasService;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
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
import javax.swing.table.TableCellRenderer;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:Laboratorio/AgendaBienestar.class */
public class AgendaBienestar extends JInternalFrame {
    private Principal frmPrincipal;
    private LaboratorioBienestarDAOImpl xImplLabotaorio;
    private Thread hilo;
    private Object[] dato;
    private String sql;
    private String sql1;
    public DefaultTableModel xmodelo;
    public DefaultTableModel xmodelo1;
    private claseLab xclaselab;
    private boolean disponible;
    private String idMedicoBS1;
    private String idConsultorioMedicoBS1;
    private ButtonGroup JBGFiltro;
    private ButtonGroup JBGFiltroNp;
    private ButtonGroup JBGFiltro_LP;
    private JButton JBTAtencionPrior;
    private JCheckBox JCH_FiltroCitologia;
    private JPanel JPIFiltro;
    private JPanel JPIFiltro_LP;
    public JRadioButton JRBConsultorio;
    public JRadioButton JRBLab_Externo;
    public JRadioButton JRBLaboratorio;
    private JScrollPane JSPDatosAgenta;
    private JScrollPane JSPDatosAgenta1;
    private JTable JTBDatosAgenda;
    private JTable JTBDatosAgenda1;
    private JTextField JTFNombre;
    private JTabbedPane JTPDatos;
    public JRadioButton btnAtendidas;
    public JRadioButton btnAtendidas1;
    public JRadioButton btnPorAtender;
    public JRadioButton btnTodas;
    private JTextField txtCantidad;
    public JDateChooser txtFecha;
    private Metodos metodos = new Metodos();
    private final LlamadasService llamadasService = (LlamadasService) Principal.contexto.getBean(LlamadasService.class);
    private int xlleno = 0;
    private int xlprocesamiento = 0;
    private int estado_ = 0;
    private int estado2 = 0;
    private String estado = "0";
    private String profesional = "";
    private String consultorio = "";
    private Integer num = 0;
    private long xN_Usuarios = 0;
    private ConsultasMySQL xconsultasbd = new ConsultasMySQL();
    private long xN_UsuariosA = 0;
    private boolean xllenoCE = false;
    private boolean xllenoUH = false;
    private String lugarAtencionPacienteBS1 = "Libre";
    AtomicBoolean EstadoTarea = new AtomicBoolean(true);

    public AgendaBienestar(claseLab xclaselab) {
        this.idMedicoBS1 = "";
        this.idConsultorioMedicoBS1 = "";
        initComponents();
        springStart();
        this.xclaselab = xclaselab;
        this.txtFecha.setDate(this.metodos.getFechaActual());
        this.JBTAtencionPrior.setVisible(false);
        mCrearTabla_Ambulatorio();
        if (this.xclaselab.getFitroCitologias() == 0) {
            this.JCH_FiltroCitologia.setVisible(false);
        } else if (this.xclaselab.getFitroCitologias() == 1) {
            this.JCH_FiltroCitologia.setVisible(false);
            this.JCH_FiltroCitologia.setSelected(true);
        }
        this.idMedicoBS1 = ValidarIdMedicoBS1(Principal.usuarioSistemaDTO.getIdUsuarioBs1());
        this.idConsultorioMedicoBS1 = RecuperarConsultorioMedicoLogueadoBS1(Principal.usuarioSistemaDTO.getIdUsuarioBs1());
        mCrear_Tabla_UH();
        ejecutarTareaTimer();
    }

    private void HacerLlamadoTvBS1(String iDTvGuid, String idConsultorioMedicoBS1, String idPersonaLlamarBS1) {
        String QueryActualizar = "update Televisor set Tel_Fecha = getdate() where zCMed_ID = '" + idConsultorioMedicoBS1 + "' and zPer_ID ='" + idPersonaLlamarBS1 + "'";
        String QueryInsertar = "insert Televisor (Tel_ID ,Tel_Fecha,zCMed_ID,zPer_ID) values('" + iDTvGuid + "',GETDATE(),'" + idConsultorioMedicoBS1 + "','" + idPersonaLlamarBS1 + "')";
        ConsultasSqlServer Cs = new ConsultasSqlServer();
        int Actualizado = Cs.ejecutaSQLUpdate(QueryActualizar);
        if (Actualizado == 0) {
            Cs.ejecutarSQL(QueryInsertar);
        }
        Cs.cerrarConexionBd();
    }

    private String RecuperarConsultorioMedicoLogueadoBS1(String idPersonaMedicoBs1) {
        ResultSet rs;
        Throwable th;
        String idConsultorio = "";
        String Query = "--RECUPERAR ID CONSULTORIO DEL MEDICO\nselect PE.Per_ID, PE.Per_NombreFull, PD.Doc_Numero,TC.CMed_ID,TC.CMed_Consultorio from Televisor_ConsultiriosXMedico EP\nINNER JOIN Persona PE ON ( PE.Per_ID= EP.zPer_ID_Medico)\nINNER JOIN Persona_Documento PD ON(PD.Doc_ID = PE.zDoc_ID)\nINNER JOIN Televisor_ConsultiriosXMedico TC ON(TC.zPer_ID_Medico = PE.Per_ID)\nWHERE TC.zPer_ID_Medico= '" + idPersonaMedicoBs1 + "'";
        ConsultasSqlServer Cs = new ConsultasSqlServer();
        try {
            rs = Cs.traerRs(Query);
            th = null;
        } catch (SQLException ex) {
            Logger.getLogger(JIFAgendaTaquilla.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        try {
            try {
                if (rs.next()) {
                    idConsultorio = rs.getString("CMed_ID");
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
                Cs.cerrarConexionBd();
                return idConsultorio;
            } finally {
            }
        } finally {
        }
    }

    private String RecuperarIdPersonaPorAtenderBS1(String noDocumento) {
        ResultSet rs;
        Throwable th;
        String IdPersonaBS1 = "";
        String Query = "select PE.Per_ID, PE.Per_NombreFull, PD.Doc_Numero from Persona_Documento PD\nINNER JOIN Persona PE ON ( PE.zDoc_ID= PD.Doc_ID)\nWHERE PD.Doc_Numero = '" + noDocumento + "'";
        ConsultasSqlServer Cs = new ConsultasSqlServer();
        try {
            rs = Cs.traerRs(Query);
            th = null;
        } catch (SQLException ex) {
            Logger.getLogger(JIFAgendaTaquilla.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        try {
            try {
                if (rs.next()) {
                    IdPersonaBS1 = rs.getString("Per_ID");
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
                Cs.cerrarConexionBd();
                return IdPersonaBS1;
            } finally {
            }
        } finally {
        }
    }

    private String RecuperarIdLaboratorioBS1(String idIngreso) {
        ResultSet rs;
        Throwable th;
        String idLaboratorioBS1 = "";
        String Query = "SELECT `NoAutorizacion` FROM `ingreso` WHERE `id` = '" + idIngreso + "'";
        ConsultasMySQL Cm = new ConsultasMySQL();
        try {
            rs = Cm.traerRs(Query);
            th = null;
        } catch (SQLException ex) {
            Logger.getLogger(JIFAgendaTaquilla.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        try {
            try {
                if (rs.next()) {
                    idLaboratorioBS1 = rs.getString("NoAutorizacion");
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
                Cm.cerrarConexionBd();
                return idLaboratorioBS1;
            } finally {
            }
        } finally {
        }
    }

    /* JADX WARN: Finally extract failed */
    private Boolean ValidarDisponibilidadPacienteBS1(String idConsultar) {
        ResultSet rs;
        Throwable th;
        boolean disponible = false;
        String statusAudiometria = "";
        String statusOptometria = "";
        String statusHistoriaClinica = "";
        String statusPsicologia = "";
        String Query = "select Audiometria.EstadoAtencion as'AtencionAudiometria',Optometria.EstadoAtencion'AtencionOptometria'\n,Laboratorio.EstadoAtencion as 'AtencionLaboratorio', hc.EstadoAtencion as AtencionMedicaHc,hc.EstadoAtencionPsicologia as 'AtencionPsicologia'\n            ,Empresa_Empleado.Emp_ID, Opt_ID,Audiometria.Aud_ID, Persona.Per_NombreFull as 'Nombre', Persona_Documento.Doc_Numero as 'No Documento'\n            , Opt_Fecha as 'Fecha Registro' from Optometria\n            inner join Empresa_Empleado on (Empresa_Empleado.zOpt_ID = Optometria.Opt_ID) \n            LEFT join Audiometria on (  Audiometria.Aud_ID= Empresa_Empleado.zAud_ID)\n            left join Laboratorio on ( Laboratorio.Lab_ID = Empresa_Empleado.zLab_ID)\n            inner join Persona on(Empresa_Empleado.zPer_ID = Persona.Per_ID) \n            inner join Persona_Documento on (Persona_Documento.Doc_ID = Persona.zDoc_ID)\n            inner join HistoriaClinica hc on(hc.HCli_ID = Empresa_Empleado.zHCli_ID)\n            where  Lab_ID = '" + idConsultar + "' ";
        ConsultasSqlServer Cs = new ConsultasSqlServer();
        try {
            rs = Cs.traerRs(Query);
            th = null;
        } catch (SQLException ex) {
            Logger.getLogger(JIFAgendaTaquilla.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        try {
            if (rs.next()) {
                try {
                    statusAudiometria = String.valueOf(rs.getInt("AtencionAudiometria"));
                } catch (Exception e) {
                    statusAudiometria = "NULL";
                }
                try {
                    statusOptometria = String.valueOf(rs.getInt("AtencionOptometria"));
                } catch (Exception e2) {
                    statusOptometria = "NULL";
                }
                try {
                    String.valueOf(rs.getInt("AtencionLaboratorio"));
                } catch (Exception e3) {
                }
                try {
                    statusHistoriaClinica = String.valueOf(rs.getInt("AtencionMedicaHc"));
                } catch (Exception e4) {
                    statusHistoriaClinica = "NULL";
                }
                try {
                    statusPsicologia = String.valueOf(rs.getInt("AtencionPsicologia"));
                } catch (Exception e5) {
                    statusPsicologia = "NULL";
                }
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
            int i = 0;
            while (true) {
                if (i >= 1) {
                    break;
                }
                if (statusAudiometria.equals("1")) {
                    disponible = false;
                    this.lugarAtencionPacienteBS1 = "Audiometría";
                    break;
                }
                if (statusOptometria.equals("1")) {
                    disponible = false;
                    this.lugarAtencionPacienteBS1 = "Optometría";
                    break;
                }
                if (statusHistoriaClinica.equals("1")) {
                    disponible = false;
                    this.lugarAtencionPacienteBS1 = "Atención por Médico";
                } else if (statusPsicologia.equals("1")) {
                    disponible = false;
                    this.lugarAtencionPacienteBS1 = "Psicología";
                } else {
                    this.lugarAtencionPacienteBS1 = "Libre";
                    disponible = true;
                }
                i++;
            }
            Cs.cerrarConexionBd();
            return Boolean.valueOf(disponible);
        } catch (Throwable th3) {
            if (rs != null) {
                if (0 != 0) {
                    try {
                        rs.close();
                    } catch (Throwable th4) {
                        th.addSuppressed(th4);
                    }
                } else {
                    rs.close();
                }
            }
            throw th3;
        }
    }

    private Boolean TomarAtencionPaciente(String idLaboratorioBS1, String EmpIdMedicoBS1) {
        boolean Tomado = false;
        String Query = "update Laboratorio set EstadoAtencion= '1' , zEmp_ID_Medico = '" + EmpIdMedicoBS1 + "', F_InicioAtencion= GETDATE() where Lab_ID='" + idLaboratorioBS1 + "'";
        ConsultasSqlServer Cm = new ConsultasSqlServer();
        int Actualizado = Cm.ejecutaSQLUpdate(Query);
        if (Actualizado > 0) {
            Tomado = true;
        } else if (Actualizado == 0) {
            Tomado = false;
        }
        Cm.cerrarConexionBd();
        return Boolean.valueOf(Tomado);
    }

    private String ValidarIdMedicoBS1(String idPersonaBs1) {
        ResultSet rs;
        Throwable th;
        String idMedico = "";
        String Query = "select top 1 Empresa_Empleado.Emp_ID,\n                Persona.Per_NombreFull,\n                Persona.Per_ID,\n                General_Usuario.Usr_Activo,\n                Asignados\n                from Empresa_Empleado \n                INNER JOIN HistoriasClinicas_Asignadas ON(HistoriasClinicas_Asignadas.Emp_ID = Empresa_Empleado.Emp_ID)\n                inner join Persona ON (Empresa_Empleado.zPer_ID = Persona.Per_ID)\n                inner join General_Usuario on (General_Usuario.zDPer_ID=Persona.Per_ID )\n                where Persona.Per_ID ='" + idPersonaBs1 + "'";
        ConsultasSqlServer Cs = new ConsultasSqlServer();
        try {
            rs = Cs.traerRs(Query);
            th = null;
        } catch (SQLException ex) {
            Logger.getLogger(JIFAgendaTaquilla.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        try {
            try {
                if (rs.next()) {
                    idMedico = rs.getString("Emp_ID");
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
                Cs.cerrarConexionBd();
                return idMedico;
            } finally {
            }
        } finally {
        }
    }

    private Boolean ValidarCantidadAtenciones(String idMedioBS1) {
        ResultSet rs;
        Throwable th;
        boolean libreDeAtenciones = false;
        int cantidadTomados = 0;
        String Query = "select count(Lab_ID) as Tomados from Laboratorio where zEmp_ID_Medico='" + idMedioBS1 + "' and EstadoAtencion ='1'";
        ConsultasSqlServer Cs = new ConsultasSqlServer();
        try {
            rs = Cs.traerRs(Query);
            th = null;
        } catch (SQLException ex) {
            Logger.getLogger(JIFAgendaTaquilla.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        try {
            try {
                if (rs.next()) {
                    cantidadTomados = rs.getInt("Tomados");
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
                if (cantidadTomados == 0) {
                    libreDeAtenciones = true;
                } else if (cantidadTomados > 0) {
                    libreDeAtenciones = false;
                }
                Cs.cerrarConexionBd();
                return Boolean.valueOf(libreDeAtenciones);
            } finally {
            }
        } finally {
        }
    }

    private void springStart() {
        this.xImplLabotaorio = (LaboratorioBienestarDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("laboratorioBienestarDAOImpl");
    }

    private void ejecutarTareaTimer() {
        final Timer timer = new Timer();
        timer.schedule(new TimerTask() { // from class: Laboratorio.AgendaBienestar.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (AgendaBienestar.this.EstadoTarea.get()) {
                    AgendaBienestar.this.mAgendaAmbulatoria();
                    AgendaBienestar.this.mAgendaUrgencias_Hospitalizacion();
                } else {
                    System.out.println("Finaliza ejecucion de Timer de Agenda de Laboratorio");
                    timer.cancel();
                }
            }
        }, 0L, 30000L);
    }

    private void cargarAtencion(DefaultTableModel xmodelo_a) {
        if (xmodelo_a.getValueAt(this.xclaselab.getXposfila(), 6).toString().equals("0")) {
            try {
                this.xclaselab.cargarPantalla("RecepcionAutoBienestarSalud");
                this.xclaselab.frmRecepBienestarSalud.txtNoOrden.setText(this.xclaselab.getXidorden());
                this.xclaselab.frmRecepBienestarSalud.buscarOrden();
                Principal.txtNo.setText("");
                dispose();
                this.EstadoTarea.set(false);
                this.xclaselab.xjifagenda = null;
                finalize();
                return;
            } catch (Throwable ex) {
                Logger.getLogger(AgendaBienestar.class.getName()).log(Level.SEVERE, (String) null, ex);
                return;
            }
        }
        int n = JOptionPane.showInternalConfirmDialog(this, "Orden recepcionada, \nDesea cargarla", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        if (n == 0) {
            try {
                this.xclaselab.cargarPantalla("RecepcionAutoBienestarSalud");
                this.xclaselab.getXidorden();
                this.xclaselab.frmRecepBienestarSalud.txtNoOrden.setText(this.xclaselab.getXidorden());
                this.xclaselab.frmRecepBienestarSalud.buscarOrden();
                Principal.txtNo.setText(this.xclaselab.frmRecepBienestarSalud.xidnrecepcion);
                dispose();
                this.EstadoTarea.set(false);
                this.xclaselab.xjifagenda = null;
                finalize();
            } catch (Throwable ex2) {
                Logger.getLogger(AgendaBienestar.class.getName()).log(Level.SEVERE, (String) null, ex2);
            }
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTabla_Ambulatorio() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"No. Historia", "Usuario", "Edad", "Sexo", "Hora de Llegada", "Id", "Atendido", "Estado", "EsPrioritario", "Tipo Atención", "TipoE", "Id_Ingreso", "Tipo", "CEspecial", "NRcepcion", "Entidad", "Persona que Factura", "Sede", "Accion Llamar"}) { // from class: Laboratorio.AgendaBienestar.2
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Integer.class, Long.class, JLabel.class, Integer.class, Long.class, String.class, String.class, String.class, JButton.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBDatosAgenda.setDefaultRenderer(JButton.class, new TableCellRenderer() { // from class: Laboratorio.AgendaBienestar.3
            public Component getTableCellRendererComponent(JTable jtable, Object objeto, boolean estaSeleccionado, boolean tieneElFoco, int fila, int columna) {
                return (Component) objeto;
            }
        });
        this.JTBDatosAgenda.setModel(this.xmodelo);
        this.JTBDatosAgenda.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.JTBDatosAgenda.getColumnModel().getColumn(1).setPreferredWidth(250);
        this.JTBDatosAgenda.getColumnModel().getColumn(2).setPreferredWidth(50);
        this.JTBDatosAgenda.getColumnModel().getColumn(3).setPreferredWidth(50);
        this.JTBDatosAgenda.getColumnModel().getColumn(4).setPreferredWidth(80);
        this.JTBDatosAgenda.getColumnModel().getColumn(5).setPreferredWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(5).setMinWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(5).setMaxWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(6).setPreferredWidth(100);
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
        this.JTBDatosAgenda.getColumnModel().getColumn(12).setPreferredWidth(50);
        this.JTBDatosAgenda.getColumnModel().getColumn(13).setPreferredWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(13).setMinWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(13).setMaxWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(14).setPreferredWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(14).setMinWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(14).setMaxWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(15).setPreferredWidth(150);
        this.JTBDatosAgenda.getColumnModel().getColumn(16).setPreferredWidth(200);
        this.JTBDatosAgenda.getColumnModel().getColumn(17).setPreferredWidth(150);
        this.JTBDatosAgenda.getColumnModel().getColumn(18).setPreferredWidth(0);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrear_Tabla_UH() {
        this.xmodelo1 = new DefaultTableModel(new Object[0], new String[]{"No. Historia", "Usuario", "Edad", "Sexo", "Hora Solicitud", "Id", "Atendido", "Estado", "EsPrioritario", "Tipo Atención", "TipoE", "Id_Ingreso", "Ubicación", "IdRecepcion", "Profesional que Solicita", "Fecha Orden", "Profesional que Ordena"}) { // from class: Laboratorio.AgendaBienestar.4
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Integer.class, Long.class, String.class, Long.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTBDatosAgenda1;
        JTable jTable2 = this.JTBDatosAgenda1;
        jTable.setAutoResizeMode(0);
        this.JTBDatosAgenda1.doLayout();
        this.JTBDatosAgenda1.setModel(this.xmodelo1);
        this.JTBDatosAgenda1.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTBDatosAgenda1.getColumnModel().getColumn(1).setPreferredWidth(350);
        this.JTBDatosAgenda1.getColumnModel().getColumn(2).setPreferredWidth(80);
        this.JTBDatosAgenda1.getColumnModel().getColumn(3).setPreferredWidth(80);
        this.JTBDatosAgenda1.getColumnModel().getColumn(4).setPreferredWidth(80);
        this.JTBDatosAgenda1.getColumnModel().getColumn(5).setPreferredWidth(0);
        this.JTBDatosAgenda1.getColumnModel().getColumn(5).setMinWidth(0);
        this.JTBDatosAgenda1.getColumnModel().getColumn(5).setMaxWidth(0);
        this.JTBDatosAgenda1.getColumnModel().getColumn(6).setPreferredWidth(0);
        this.JTBDatosAgenda1.getColumnModel().getColumn(6).setMinWidth(0);
        this.JTBDatosAgenda1.getColumnModel().getColumn(6).setMaxWidth(0);
        this.JTBDatosAgenda1.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.JTBDatosAgenda1.getColumnModel().getColumn(8).setPreferredWidth(0);
        this.JTBDatosAgenda1.getColumnModel().getColumn(8).setMinWidth(0);
        this.JTBDatosAgenda1.getColumnModel().getColumn(8).setMaxWidth(0);
        this.JTBDatosAgenda1.getColumnModel().getColumn(9).setPreferredWidth(150);
        this.JTBDatosAgenda1.getColumnModel().getColumn(10).setPreferredWidth(0);
        this.JTBDatosAgenda1.getColumnModel().getColumn(10).setMinWidth(0);
        this.JTBDatosAgenda1.getColumnModel().getColumn(10).setMaxWidth(0);
        this.JTBDatosAgenda1.getColumnModel().getColumn(11).setPreferredWidth(0);
        this.JTBDatosAgenda1.getColumnModel().getColumn(11).setMinWidth(0);
        this.JTBDatosAgenda1.getColumnModel().getColumn(11).setMaxWidth(0);
        this.JTBDatosAgenda1.getColumnModel().getColumn(12).setPreferredWidth(100);
        this.JTBDatosAgenda1.getColumnModel().getColumn(13).setPreferredWidth(0);
        this.JTBDatosAgenda1.getColumnModel().getColumn(13).setMinWidth(0);
        this.JTBDatosAgenda1.getColumnModel().getColumn(13).setMaxWidth(0);
        this.JTBDatosAgenda1.getColumnModel().getColumn(14).setPreferredWidth(300);
        this.JTBDatosAgenda1.getColumnModel().getColumn(15).setPreferredWidth(100);
        this.JTBDatosAgenda1.getColumnModel().getColumn(16).setPreferredWidth(300);
    }

    public void mAgendaAmbulatoria() {
        List<AgendaDetalleDTO> list;
        if (this.txtFecha.getDate() != null && this.xmodelo != null && this.txtFecha != null) {
            this.xllenoCE = false;
            mCrearTabla_Ambulatorio();
            if (this.JTFNombre.getText().isEmpty()) {
                if (this.estado == "0" || this.estado == "1,2") {
                    if (this.JCH_FiltroCitologia.isSelected()) {
                        list = this.xImplLabotaorio.listAgendaIdProcedimiento(String.valueOf(this.estado), Integer.valueOf(Principal.sedeUsuarioSeleccionadaDTO.getId().toString()), Integer.valueOf(this.xlprocesamiento), this.metodos.formatoAMD.format(this.txtFecha.getDate()), 898001L, "=1", 892901L);
                    } else {
                        list = this.xImplLabotaorio.listAgenda(String.valueOf(this.estado), Integer.valueOf(Principal.sedeUsuarioSeleccionadaDTO.getId().toString()), Integer.valueOf(this.xlprocesamiento), this.metodos.formatoAMD.format(this.txtFecha.getDate()), "=1");
                    }
                } else if (this.JCH_FiltroCitologia.isSelected()) {
                    list = this.xImplLabotaorio.listAgendaIdProcedimiento("0,1,2", Integer.valueOf(Principal.sedeUsuarioSeleccionadaDTO.getId().toString()), Integer.valueOf(this.xlprocesamiento), this.metodos.formatoAMD.format(this.txtFecha.getDate()), 898001L, "=1", 892901L);
                } else {
                    list = this.xImplLabotaorio.listAgenda(String.valueOf(this.estado), Integer.valueOf(Principal.sedeUsuarioSeleccionadaDTO.getId().toString()), Integer.valueOf(this.xlprocesamiento), this.metodos.formatoAMD.format(this.txtFecha.getDate()), "=1");
                }
            } else {
                list = this.xImplLabotaorio.listAgendaDocNombre(this.JTFNombre.getText(), "=1", this.metodos.formatoAMD.format(this.txtFecha.getDate()));
            }
            this.JBTAtencionPrior.setVisible(false);
            this.xlleno = 1;
            this.xN_UsuariosA = 0L;
            if (list.size() > 0) {
                this.metodos.mEstablecerTextEditor(this.JTBDatosAgenda, 15);
                this.metodos.mEstablecerTextEditor(this.JTBDatosAgenda, 16);
                for (int x = 0; x < list.size(); x++) {
                    this.xmodelo.addRow(this.dato);
                    this.xmodelo.setValueAt(list.get(x).getNHistoria(), x, 0);
                    this.xmodelo.setValueAt(list.get(x).getNUsuario(), x, 1);
                    this.xmodelo.setValueAt(list.get(x).getEdad(), x, 2);
                    this.xmodelo.setValueAt(list.get(x).getSexo(), x, 3);
                    this.xmodelo.setValueAt(list.get(x).getHoraLlegada(), x, 4);
                    this.xmodelo.setValueAt(list.get(x).getIdOrden(), x, 5);
                    this.xmodelo.setValueAt(list.get(x).getIdEstadoRecepcion(), x, 6);
                    this.xmodelo.setValueAt(list.get(x).getEsCapitado(), x, 10);
                    this.xmodelo.setValueAt(list.get(x).getIdIngreso(), x, 11);
                    this.xmodelo.setValueAt(list.get(x).getCEspecial(), x, 13);
                    this.xmodelo.setValueAt(list.get(x).getIdRecepcion(), x, 14);
                    this.xmodelo.setValueAt(list.get(x).getNEmpresa(), x, 15);
                    this.xmodelo.setValueAt(list.get(x).getNombreFacturador(), x, 16);
                    this.xmodelo.setValueAt(list.get(x).getSede(), x, 17);
                    buscaarPacientes(list.get(x).getNHistoria());
                    if (this.num.intValue() == 0) {
                        this.xmodelo.setValueAt(new JButton("Tomar"), x, 18);
                    } else {
                        this.xmodelo.setValueAt(new JButton("Tomar " + this.num), x, 18);
                    }
                    this.xmodelo.setValueAt(new JLabel(new ImageIcon(getClass().getResource(list.get(x).getCUrlEspecial()))), x, 12);
                    this.JTBDatosAgenda.setDefaultRenderer(JLabel.class, new Render(list.get(x).getCEspecial().intValue(), 13));
                    this.xmodelo.setValueAt(list.get(x).getEstadoRecepcion(), x, 7);
                    this.xmodelo.setValueAt(list.get(x).getEsPrioritario(), x, 8);
                    this.xmodelo.setValueAt(list.get(x).getTipoAtencion(), x, 9);
                    this.JTBDatosAgenda.setDefaultRenderer(Object.class, new MiRender());
                    if (list.get(x).getIdEstadoRecepcion().intValue() != 2 && list.get(x).getEsPrioritario().intValue() == 1) {
                        this.JBTAtencionPrior.setVisible(true);
                    }
                    this.xN_UsuariosA++;
                }
                this.txtCantidad.setText("" + this.xN_UsuariosA);
            }
            this.xllenoCE = true;
        }
    }

    public void mAgendaUrgencias_Hospitalizacion() {
        List<AgendaDetalleDTO> list;
        if (this.txtFecha.getDate() != null && this.xmodelo != null) {
            this.xllenoUH = false;
            mCrear_Tabla_UH();
            if (this.JTFNombre.getText().isEmpty()) {
                if (this.estado == "0" || this.estado == "1,2") {
                    list = this.xImplLabotaorio.listAgenda(String.valueOf(this.estado), Integer.valueOf(Principal.sedeUsuarioSeleccionadaDTO.getId().toString()), Integer.valueOf(this.xlprocesamiento), this.metodos.formatoAMD.format(this.txtFecha.getDate()), ">1");
                } else {
                    list = this.xImplLabotaorio.listAgenda("0,1,2", Integer.valueOf(Principal.sedeUsuarioSeleccionadaDTO.getId().toString()), Integer.valueOf(this.xlprocesamiento), this.metodos.formatoAMD.format(this.txtFecha.getDate()), ">1");
                }
            } else {
                list = this.xImplLabotaorio.listAgendaDocNombre(this.JTFNombre.getText(), ">1", this.metodos.formatoAMD.format(this.txtFecha.getDate()));
            }
            if (list.size() > 0) {
                this.metodos.mEstablecerTextEditor(this.JTBDatosAgenda1, 15);
                for (int x = 0; x < list.size(); x++) {
                    this.xmodelo1.addRow(this.dato);
                    this.xmodelo1.setValueAt(list.get(x).getNHistoria(), x, 0);
                    this.xmodelo1.setValueAt(list.get(x).getNUsuario(), x, 1);
                    this.xmodelo1.setValueAt(list.get(x).getEdad(), x, 2);
                    this.xmodelo1.setValueAt(list.get(x).getSexo(), x, 3);
                    this.xmodelo1.setValueAt(list.get(x).getHora(), x, 4);
                    this.xmodelo1.setValueAt(list.get(x).getIdOrden(), x, 5);
                    this.xmodelo1.setValueAt(list.get(x).getIdEstadoRecepcion(), x, 6);
                    this.xmodelo1.setValueAt(list.get(x).getEsCapitado(), x, 10);
                    this.xmodelo1.setValueAt(list.get(x).getIdIngreso(), x, 11);
                    this.xmodelo1.setValueAt(list.get(x).getCama(), x, 12);
                    this.xmodelo1.setValueAt(list.get(x).getIdRecepcion(), x, 13);
                    this.xmodelo1.setValueAt(list.get(x).getNombreFacturador(), x, 14);
                    this.xmodelo1.setValueAt(list.get(x).getFechaHoraOrden(), x, 15);
                    this.xmodelo1.setValueAt(list.get(x).getNombreProfesionalOrdena(), x, 16);
                    this.xmodelo1.setValueAt(list.get(x).getEsPrioritario(), x, 8);
                    this.xmodelo1.setValueAt(list.get(x).getEstadoRecepcion(), x, 7);
                    this.JTBDatosAgenda1.setDefaultRenderer(Object.class, new MiRender());
                    this.xmodelo1.setValueAt(list.get(x).getTipoAtencion(), x, 9);
                }
                if (this.xN_Usuarios != list.size()) {
                    this.metodos.mReproducir_Sonido(2);
                    this.xN_Usuarios = list.size();
                    this.JTPDatos.setBackgroundAt(1, new Color(0, 255, 255));
                } else {
                    this.JTPDatos.setBackgroundAt(1, new Color(240, 240, 240));
                }
                this.xllenoUH = true;
            }
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:Laboratorio/AgendaBienestar$MiRender.class */
    public class MiRender extends DefaultTableCellRenderer {
        public MiRender() {
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (table.getValueAt(row, 6) != null && table.getValueAt(row, 8) != null) {
                int atendido = Integer.parseInt(table.getValueAt(row, 6).toString());
                int xprioritario = Integer.parseInt(table.getValueAt(row, 8).toString());
                String xpendiente = table.getValueAt(row, 7).toString();
                if (xprioritario == 0) {
                    if (xpendiente.equals("PENDIENTE")) {
                        cell.setBackground(new Color(177, 251, 177));
                        cell.setForeground(Color.BLACK);
                    } else if (atendido == 0) {
                        cell.setBackground(new Color(0, 0, 102));
                        cell.setForeground(Color.WHITE);
                    } else if (atendido == 1) {
                        cell.setBackground(new Color(103, 0, 103));
                        cell.setForeground(Color.WHITE);
                    } else if (atendido == 2) {
                        cell.setBackground(new Color(177, 251, 177));
                        cell.setForeground(Color.BLACK);
                    } else {
                        cell.setForeground(Color.WHITE);
                    }
                } else {
                    cell.setBackground(Color.ORANGE);
                    cell.setForeground(Color.BLACK);
                }
            }
            return cell;
        }
    }

    /* JADX WARN: Type inference failed for: r3v71, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v77, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGFiltro = new ButtonGroup();
        this.JBGFiltroNp = new ButtonGroup();
        this.JBGFiltro_LP = new ButtonGroup();
        this.JPIFiltro = new JPanel();
        this.btnTodas = new JRadioButton();
        this.btnPorAtender = new JRadioButton();
        this.btnAtendidas = new JRadioButton();
        this.btnAtendidas1 = new JRadioButton();
        this.txtFecha = new JDateChooser();
        this.txtCantidad = new JTextField();
        this.JPIFiltro_LP = new JPanel();
        this.JRBLab_Externo = new JRadioButton();
        this.JRBLaboratorio = new JRadioButton();
        this.JRBConsultorio = new JRadioButton();
        this.JBTAtencionPrior = new JButton();
        this.JTPDatos = new JTabbedPane();
        this.JSPDatosAgenta = new JScrollPane();
        this.JTBDatosAgenda = new JTable();
        this.JSPDatosAgenta1 = new JScrollPane();
        this.JTBDatosAgenda1 = new JTable();
        this.JCH_FiltroCitologia = new JCheckBox();
        this.JTFNombre = new JTextField();
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("AGENDA");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMaximumSize(null);
        setMinimumSize(null);
        setName("Agenda");
        addAncestorListener(new AncestorListener() { // from class: Laboratorio.AgendaBienestar.5
            public void ancestorAdded(AncestorEvent evt) {
            }

            public void ancestorMoved(AncestorEvent evt) {
            }

            public void ancestorRemoved(AncestorEvent evt) {
                AgendaBienestar.this.formAncestorRemoved(evt);
            }
        });
        addInternalFrameListener(new InternalFrameListener() { // from class: Laboratorio.AgendaBienestar.6
            public void internalFrameActivated(InternalFrameEvent evt) {
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                AgendaBienestar.this.formInternalFrameClosing(evt);
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
        this.JPIFiltro.setBorder(BorderFactory.createTitledBorder((Border) null, "FILTRAR POR :", 0, 0, new Font("Arial", 1, 12), new Color(0, 103, 0)));
        this.JBGFiltro.add(this.btnTodas);
        this.btnTodas.setFont(new Font("Arial", 1, 12));
        this.btnTodas.setForeground(Color.blue);
        this.btnTodas.setText("Todas");
        this.btnTodas.addActionListener(new ActionListener() { // from class: Laboratorio.AgendaBienestar.7
            public void actionPerformed(ActionEvent evt) {
                AgendaBienestar.this.btnTodasActionPerformed(evt);
            }
        });
        this.JBGFiltro.add(this.btnPorAtender);
        this.btnPorAtender.setFont(new Font("Arial", 1, 12));
        this.btnPorAtender.setForeground(Color.blue);
        this.btnPorAtender.setSelected(true);
        this.btnPorAtender.setText("Por Atender");
        this.btnPorAtender.addActionListener(new ActionListener() { // from class: Laboratorio.AgendaBienestar.8
            public void actionPerformed(ActionEvent evt) {
                AgendaBienestar.this.btnPorAtenderActionPerformed(evt);
            }
        });
        this.JBGFiltro.add(this.btnAtendidas);
        this.btnAtendidas.setFont(new Font("Arial", 1, 12));
        this.btnAtendidas.setForeground(Color.blue);
        this.btnAtendidas.setText("Atendidas");
        this.btnAtendidas.addActionListener(new ActionListener() { // from class: Laboratorio.AgendaBienestar.9
            public void actionPerformed(ActionEvent evt) {
                AgendaBienestar.this.btnAtendidasActionPerformed(evt);
            }
        });
        this.JBGFiltro.add(this.btnAtendidas1);
        this.btnAtendidas1.setFont(new Font("Arial", 1, 12));
        this.btnAtendidas1.setForeground(Color.blue);
        this.btnAtendidas1.setText("Recepcionada");
        this.btnAtendidas1.addActionListener(new ActionListener() { // from class: Laboratorio.AgendaBienestar.10
            public void actionPerformed(ActionEvent evt) {
                AgendaBienestar.this.btnAtendidas1ActionPerformed(evt);
            }
        });
        GroupLayout JPIFiltroLayout = new GroupLayout(this.JPIFiltro);
        this.JPIFiltro.setLayout(JPIFiltroLayout);
        JPIFiltroLayout.setHorizontalGroup(JPIFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFiltroLayout.createSequentialGroup().addContainerGap().addComponent(this.btnPorAtender).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.btnAtendidas1).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.btnAtendidas).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.btnTodas).addGap(14, 14, 14)));
        JPIFiltroLayout.setVerticalGroup(JPIFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFiltroLayout.createSequentialGroup().addGroup(JPIFiltroLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.btnPorAtender).addComponent(this.btnAtendidas).addComponent(this.btnTodas).addComponent(this.btnAtendidas1)).addContainerGap(16, 32767)));
        this.txtFecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Agenda", 1, 0, new Font("Arial", 1, 12), new Color(204, 0, 204)));
        this.txtFecha.setDateFormatString("dd/MM/yyyy");
        this.txtFecha.setFont(new Font("Arial", 1, 12));
        this.txtFecha.addPropertyChangeListener(new PropertyChangeListener() { // from class: Laboratorio.AgendaBienestar.11
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                AgendaBienestar.this.txtFechaPropertyChange(evt);
            }
        });
        this.txtCantidad.setBackground(new Color(0, 0, 102));
        this.txtCantidad.setFont(new Font("Arial", 1, 14));
        this.txtCantidad.setHorizontalAlignment(0);
        this.txtCantidad.setText("0");
        this.txtCantidad.setToolTipText("Cantidad de usuarios");
        this.txtCantidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Cantidad", 0, 0, new Font("Arial", 1, 14), new Color(255, 255, 255)));
        this.txtCantidad.setDisabledTextColor(new Color(255, 255, 255));
        this.txtCantidad.setEnabled(false);
        this.JPIFiltro_LP.setBorder(BorderFactory.createTitledBorder((Border) null, "LUGAR DE PROCESAMIENTO", 0, 0, new Font("Arial", 1, 12), new Color(0, 103, 0)));
        this.JBGFiltro_LP.add(this.JRBLab_Externo);
        this.JRBLab_Externo.setFont(new Font("Arial", 1, 12));
        this.JRBLab_Externo.setForeground(Color.blue);
        this.JRBLab_Externo.setText("Lab_Externo");
        this.JRBLab_Externo.addActionListener(new ActionListener() { // from class: Laboratorio.AgendaBienestar.12
            public void actionPerformed(ActionEvent evt) {
                AgendaBienestar.this.JRBLab_ExternoActionPerformed(evt);
            }
        });
        this.JBGFiltro_LP.add(this.JRBLaboratorio);
        this.JRBLaboratorio.setFont(new Font("Arial", 1, 12));
        this.JRBLaboratorio.setForeground(Color.blue);
        this.JRBLaboratorio.setSelected(true);
        this.JRBLaboratorio.setText("Laboratorio");
        this.JRBLaboratorio.addActionListener(new ActionListener() { // from class: Laboratorio.AgendaBienestar.13
            public void actionPerformed(ActionEvent evt) {
                AgendaBienestar.this.JRBLaboratorioActionPerformed(evt);
            }
        });
        this.JBGFiltro_LP.add(this.JRBConsultorio);
        this.JRBConsultorio.setFont(new Font("Arial", 1, 12));
        this.JRBConsultorio.setForeground(Color.blue);
        this.JRBConsultorio.setText("Consultorio");
        this.JRBConsultorio.addActionListener(new ActionListener() { // from class: Laboratorio.AgendaBienestar.14
            public void actionPerformed(ActionEvent evt) {
                AgendaBienestar.this.JRBConsultorioActionPerformed(evt);
            }
        });
        GroupLayout JPIFiltro_LPLayout = new GroupLayout(this.JPIFiltro_LP);
        this.JPIFiltro_LP.setLayout(JPIFiltro_LPLayout);
        JPIFiltro_LPLayout.setHorizontalGroup(JPIFiltro_LPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFiltro_LPLayout.createSequentialGroup().addContainerGap().addComponent(this.JRBLaboratorio).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBConsultorio).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBLab_Externo).addContainerGap(-1, 32767)));
        JPIFiltro_LPLayout.setVerticalGroup(JPIFiltro_LPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFiltro_LPLayout.createSequentialGroup().addGroup(JPIFiltro_LPLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBLaboratorio).addComponent(this.JRBConsultorio).addComponent(this.JRBLab_Externo)).addContainerGap(-1, 32767)));
        this.JBTAtencionPrior.setIcon(new ImageIcon(getClass().getResource("/Imagenes/prioridadA.gif")));
        this.JBTAtencionPrior.addActionListener(new ActionListener() { // from class: Laboratorio.AgendaBienestar.15
            public void actionPerformed(ActionEvent evt) {
                AgendaBienestar.this.JBTAtencionPriorActionPerformed(evt);
            }
        });
        this.JTPDatos.setForeground(new Color(0, 103, 0));
        this.JTPDatos.setFont(new Font("Arial", 1, 14));
        this.JTPDatos.addMouseListener(new MouseAdapter() { // from class: Laboratorio.AgendaBienestar.16
            public void mouseClicked(MouseEvent evt) {
                AgendaBienestar.this.JTPDatosMouseClicked(evt);
            }
        });
        this.JSPDatosAgenta.setBorder((Border) null);
        this.JTBDatosAgenda.setFont(new Font("Arial", 1, 12));
        this.JTBDatosAgenda.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTBDatosAgenda.setRowHeight(35);
        this.JTBDatosAgenda.setSelectionBackground(new Color(255, 255, 255));
        this.JTBDatosAgenda.setSelectionForeground(new Color(255, 0, 0));
        this.JTBDatosAgenda.setSelectionMode(0);
        this.JTBDatosAgenda.addMouseListener(new MouseAdapter() { // from class: Laboratorio.AgendaBienestar.17
            public void mouseClicked(MouseEvent evt) {
                AgendaBienestar.this.JTBDatosAgendaMouseClicked(evt);
            }
        });
        this.JSPDatosAgenta.setViewportView(this.JTBDatosAgenda);
        this.JTPDatos.addTab("CONSULTA EXTERNA", this.JSPDatosAgenta);
        this.JSPDatosAgenta1.setBorder((Border) null);
        this.JTBDatosAgenda1.setFont(new Font("Arial", 1, 12));
        this.JTBDatosAgenda1.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTBDatosAgenda1.setRowHeight(25);
        this.JTBDatosAgenda1.setSelectionBackground(new Color(255, 255, 255));
        this.JTBDatosAgenda1.setSelectionForeground(new Color(255, 0, 0));
        this.JTBDatosAgenda1.setSelectionMode(0);
        this.JTBDatosAgenda1.addMouseListener(new MouseAdapter() { // from class: Laboratorio.AgendaBienestar.18
            public void mouseClicked(MouseEvent evt) {
                AgendaBienestar.this.JTBDatosAgenda1MouseClicked(evt);
            }
        });
        this.JSPDatosAgenta1.setViewportView(this.JTBDatosAgenda1);
        this.JTPDatos.addTab("URGENCIAS - HOSPITALIZACIÓN", this.JSPDatosAgenta1);
        this.JCH_FiltroCitologia.setFont(new Font("Arial", 1, 12));
        this.JCH_FiltroCitologia.setForeground(Color.red);
        this.JCH_FiltroCitologia.setText("Filtro Citología");
        this.JCH_FiltroCitologia.addActionListener(new ActionListener() { // from class: Laboratorio.AgendaBienestar.19
            public void actionPerformed(ActionEvent evt) {
                AgendaBienestar.this.JCH_FiltroCitologiaActionPerformed(evt);
            }
        });
        this.JTFNombre.setFont(new Font("Arial", 1, 12));
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Filtro por nombre o número de documento", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JTFNombre.addKeyListener(new KeyAdapter() { // from class: Laboratorio.AgendaBienestar.20
            public void keyTyped(KeyEvent evt) {
                AgendaBienestar.this.JTFNombreKeyTyped(evt);
            }

            public void keyPressed(KeyEvent evt) {
                AgendaBienestar.this.JTFNombreKeyPressed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(10, 10, 10).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTPDatos).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFNombre, -2, 449, -2).addGroup(layout.createSequentialGroup().addComponent(this.txtFecha, -2, 123, -2).addGap(10, 10, 10).addComponent(this.JPIFiltro, -2, -1, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.txtCantidad, -2, 91, -2).addGap(18, 18, 18).addComponent(this.JPIFiltro_LP, -2, -1, -2)).addGroup(layout.createSequentialGroup().addComponent(this.JCH_FiltroCitologia).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JBTAtencionPrior, -2, 164, -2))).addGap(11, 11, 11))).addGap(10, 10, 10)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.JTPDatos, -2, 461, -2).addGap(10, 10, 10).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.txtFecha, -2, 59, -2).addComponent(this.JPIFiltro, -2, -1, -2).addComponent(this.txtCantidad, -2, 54, -2).addComponent(this.JPIFiltro_LP, -2, -1, -2)).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(10, 10, 10).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFNombre, -1, 54, 32767).addComponent(this.JCH_FiltroCitologia, -1, -1, 32767)).addGap(10, 10, 10)).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTAtencionPrior, -2, 51, -2).addContainerGap()))));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnTodasActionPerformed(ActionEvent evt) {
        this.estado = "0,1,2";
        mAgendaAmbulatoria();
        mAgendaUrgencias_Hospitalizacion();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnPorAtenderActionPerformed(ActionEvent evt) {
        this.estado = "0";
        mAgendaAmbulatoria();
        mAgendaUrgencias_Hospitalizacion();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnAtendidasActionPerformed(ActionEvent evt) {
        this.estado = "2";
        mAgendaAmbulatoria();
        mAgendaUrgencias_Hospitalizacion();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtFechaPropertyChange(PropertyChangeEvent evt) {
        if (this.xlleno == 1) {
            mAgendaAmbulatoria();
            mAgendaUrgencias_Hospitalizacion();
        }
    }

    private void buscaarPacientes(String documento) {
        new ArrayList();
        this.num = 0;
        List<LlamadasEntity> list = this.llamadasService.ListarPacientes(documento, Principal.consultorio);
        if (!list.isEmpty()) {
            this.num = Integer.valueOf(list.size());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        this.EstadoTarea.set(false);
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBLab_ExternoActionPerformed(ActionEvent evt) {
        this.xlprocesamiento = 2;
        mAgendaAmbulatoria();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBLaboratorioActionPerformed(ActionEvent evt) {
        this.xlprocesamiento = 0;
        mAgendaAmbulatoria();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBConsultorioActionPerformed(ActionEvent evt) {
        this.xlprocesamiento = 1;
        mAgendaAmbulatoria();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTAtencionPriorActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBDatosAgenda1MouseClicked(MouseEvent evt) {
        if (this.JTBDatosAgenda1.getSelectedRow() != -1) {
            this.xclaselab.setXidorden(this.xmodelo1.getValueAt(this.JTBDatosAgenda1.getSelectedRow(), 5).toString());
            this.xclaselab.setXtipo_empresa(Integer.valueOf(this.xmodelo1.getValueAt(this.JTBDatosAgenda1.getSelectedRow(), 10).toString()).intValue());
            this.xclaselab.setXid_ingreso(Long.valueOf(this.xmodelo1.getValueAt(this.JTBDatosAgenda1.getSelectedRow(), 11).toString()).longValue());
            this.xclaselab.setXposfila(this.JTBDatosAgenda1.getSelectedRow());
            cargarAtencion(this.xmodelo1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_FiltroCitologiaActionPerformed(ActionEvent evt) {
        mAgendaAmbulatoria();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNombreKeyTyped(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNombreKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            if (!this.JTFNombre.getText().isEmpty()) {
                if (this.JTPDatos.getSelectedIndex() == 0) {
                    mAgendaAmbulatoria();
                    return;
                } else {
                    mAgendaUrgencias_Hospitalizacion();
                    return;
                }
            }
            if (this.JTPDatos.getSelectedIndex() == 0) {
                mAgendaAmbulatoria();
            } else {
                mAgendaUrgencias_Hospitalizacion();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTPDatosMouseClicked(MouseEvent evt) {
        if (this.JTPDatos.getSelectedIndex() == 0) {
            this.txtCantidad.setText("" + this.xN_UsuariosA);
        } else {
            this.txtCantidad.setText("" + this.xN_Usuarios);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formAncestorRemoved(AncestorEvent evt) {
        this.EstadoTarea.set(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnAtendidas1ActionPerformed(ActionEvent evt) {
        this.estado = "1";
        mAgendaAmbulatoria();
        mAgendaUrgencias_Hospitalizacion();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBDatosAgendaMouseClicked(MouseEvent evt) {
        if (this.JTBDatosAgenda.getSelectedRow() == -1 || this.JTBDatosAgenda.getSelectedColumn() == 18 || !this.estado.equals("0")) {
            if ((this.JTBDatosAgenda.getSelectedRow() != -1 && this.JTBDatosAgenda.getSelectedColumn() != 18 && this.estado.equals("1")) || this.estado.equals("2")) {
                this.xmodelo.getValueAt(this.JTBDatosAgenda.getSelectedRow(), 5).toString();
                this.xclaselab.setXidorden(this.xmodelo.getValueAt(this.JTBDatosAgenda.getSelectedRow(), 5).toString());
                this.xclaselab.setXtipo_empresa(Integer.valueOf(this.xmodelo.getValueAt(this.JTBDatosAgenda.getSelectedRow(), 10).toString()).intValue());
                this.xclaselab.setXid_ingreso(Long.valueOf(this.xmodelo.getValueAt(this.JTBDatosAgenda.getSelectedRow(), 11).toString()).longValue());
                this.xclaselab.setXposfila(this.JTBDatosAgenda.getSelectedRow());
                cargarAtencion(this.xmodelo);
                return;
            }
            if (this.JTBDatosAgenda.getSelectedColumn() == 18) {
            }
            return;
        }
        int x = JOptionPane.showConfirmDialog(this, "Está seguro de  llamar al paciente?\nsi decide hacerlo se le asiganará esta atención\nen BS1 automaticamente.?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (x == 0) {
            String idLaboratorioBS1 = RecuperarIdLaboratorioBS1(String.valueOf(this.JTBDatosAgenda.getValueAt(this.JTBDatosAgenda.getSelectedRow(), 11)));
            ValidarDisponibilidadPacienteBS1(idLaboratorioBS1);
            this.xclaselab.setXidorden(this.xmodelo.getValueAt(this.JTBDatosAgenda.getSelectedRow(), 5).toString());
            this.xclaselab.setXtipo_empresa(Integer.valueOf(this.xmodelo.getValueAt(this.JTBDatosAgenda.getSelectedRow(), 10).toString()).intValue());
            this.xclaselab.setXid_ingreso(Long.valueOf(this.xmodelo.getValueAt(this.JTBDatosAgenda.getSelectedRow(), 11).toString()).longValue());
            this.xclaselab.setXposfila(this.JTBDatosAgenda.getSelectedRow());
            cargarAtencion(this.xmodelo);
            UUID uuid = UUID.randomUUID();
            System.out.println("UUID=" + uuid.toString());
            String idPersonaLLamarBS1 = RecuperarIdPersonaPorAtenderBS1(String.valueOf(this.JTBDatosAgenda.getValueAt(this.JTBDatosAgenda.getSelectedRow(), 0)));
            HacerLlamadoTvBS1(String.valueOf(uuid), this.idConsultorioMedicoBS1, idPersonaLLamarBS1);
        }
    }

    /* JADX WARN: Not initialized variable reg: 7, insn: 0x00cd: MOVE (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r7 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('rs' java.sql.ResultSet)]) A[TRY_LEAVE], block:B:28:0x00cd */
    /* JADX WARN: Not initialized variable reg: 8, insn: 0x00d1: MOVE (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r8 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:30:0x00d1 */
    public void llamar(String docuemtno) {
        this.disponible = true;
        this.sql = "SELECT  Profesional , Estado, Consultorio  FROM ll_datos_basicos ldb2 WHERE Documento ='" + docuemtno + "' and Original =1";
        System.out.println(this.sql);
        try {
            try {
                ResultSet rs = this.xconsultasbd.traerRs(this.sql);
                Throwable th = null;
                if (rs.next()) {
                    this.profesional = rs.getString("Profesional");
                    this.estado2 = rs.getInt("Estado");
                    this.consultorio = rs.getString("Consultorio");
                    if (this.estado2 == 2 || this.estado2 == 0 || this.estado2 == 1) {
                        if (!this.profesional.equals(Principal.usuarioSistemaDTO.getNombreUsuario())) {
                            this.disponible = false;
                        }
                    } else {
                        this.disponible = true;
                    }
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
            } finally {
            }
        } catch (SQLException ex) {
            Logger.getLogger(JIFAgendaTaquilla.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
