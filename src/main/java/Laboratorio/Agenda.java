package Laboratorio;

import Acceso.Principal;
import Facturacion.JIFAgendaTaquilla;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.genoma.plus.controller.laboratorio.dto.CustomPresenterTurner;
import com.genoma.plus.controller.laboratorio.dto.CustomRequesterTurner;
import com.genoma.plus.controller.laboratorio.dto.LLamadoTurnerDTO;
import com.genoma.plus.dao.impl.laboratorio.LaboratorioDAOImpl;
import com.genoma.plus.dao.impl.laboratorio.RecepcionStikerDAOImpl;
import com.genoma.plus.dao.laboratorio.RecepcionStikerDAO;
import com.genoma.plus.domains.models.domains.general.RecursosMicroserviciosDomain;
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
import javax.swing.table.TableCellRenderer;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:Laboratorio/Agenda.class */
public class Agenda extends JInternalFrame {
    private Principal frmPrincipal;
    private LaboratorioDAOImpl xImplLabotaorio;
    private Thread hilo;
    private Object[] dato;
    private String sql;
    private String sql1;
    public DefaultTableModel xmodelo;
    public DefaultTableModel xmodelo1;
    private claseLab xclaselab;
    private String[] xIdMunicipio;
    private RecepcionStikerDAO xRecepcionStikerDAO;
    private boolean disponible;
    private ButtonGroup JBGFiltro;
    private ButtonGroup JBGFiltroNp;
    private ButtonGroup JBGFiltro_LP;
    private JButton JBTAtencionPrior;
    private JComboBox JCBMunicipio;
    private JCheckBox JCHFiltro;
    private JCheckBox JCHFiltroRecepcion;
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
    private String logoConsltorio = "";
    private Integer num = 0;
    private Integer filtroMunicipio = 0;
    private long xN_Usuarios = 0;
    private ConsultasMySQL xconsultasbd = new ConsultasMySQL();
    private long xN_UsuariosA = 0;
    private boolean xllenoCE = false;
    private boolean xllenoUH = false;
    AtomicBoolean EstadoTarea = new AtomicBoolean(true);

    public Agenda(claseLab xclaselab) {
        initComponents();
        springStart();
        this.xclaselab = xclaselab;
        this.txtFecha.setDate(this.metodos.getFechaActual());
        if (Principal.informacionIps.getNombreIps().equals("LABORATORIO CLINICO VIVIAN RAMIREZ I.P.S. S.A.")) {
            this.JCHFiltro.setSelected(true);
            mCargarCombo();
            this.JCBMunicipio.setSelectedItem("CHINU");
        } else if (Principal.informacionIps.getNombreIps().equals("BIOMED VIDA IPS S.A.S")) {
            this.JCHFiltro.setSelected(true);
        }
        this.JBTAtencionPrior.setVisible(false);
        mCrearTabla_Ambulatorio();
        if (this.xclaselab.getFitroCitologias() == 0) {
            this.JCH_FiltroCitologia.setVisible(false);
        } else if (this.xclaselab.getFitroCitologias() == 1) {
            this.JCH_FiltroCitologia.setVisible(false);
            this.JCH_FiltroCitologia.setSelected(true);
        }
        mCrear_Tabla_UH();
        ejecutarTareaTimer();
    }

    private void springStart() {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"});
        this.xImplLabotaorio = (LaboratorioDAOImpl) classPathXmlApplicationContext.getBean("laboratorioDAOImpl");
        this.xRecepcionStikerDAO = (RecepcionStikerDAOImpl) classPathXmlApplicationContext.getBean("recepcionStikerDAO");
    }

    private void ejecutarTareaTimer() {
        final Timer timer = new Timer();
        timer.schedule(new TimerTask() { // from class: Laboratorio.Agenda.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (Agenda.this.EstadoTarea.get()) {
                    Agenda.this.mAgendaAmbulatoria();
                    Agenda.this.mAgendaUrgencias_Hospitalizacion();
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
                this.xclaselab.cargarPantalla("Recepcion");
                this.xclaselab.frmRecep.txtNoOrden.setText(this.xclaselab.getXidorden());
                this.xclaselab.frmRecep.buscarOrden();
                this.xclaselab.frmRecep.activarNumeracionCitologia();
                Principal.txtNo.setText("");
                dispose();
                this.EstadoTarea.set(false);
                this.xclaselab.xjifagenda = null;
                finalize();
                return;
            } catch (Throwable ex) {
                Logger.getLogger(Agenda.class.getName()).log(Level.SEVERE, (String) null, ex);
                return;
            }
        }
        try {
            this.xclaselab.cargarPantalla("Recepcion");
            this.xclaselab.frmRecep.txtNoOrden.setText(this.xclaselab.getXidorden());
            this.xclaselab.frmRecep.buscarOrden();
            this.xclaselab.frmRecep.activarNumeracionCitologia();
            Principal.txtNo.setText(this.xclaselab.frmRecep.xidnrecepcion);
            dispose();
            this.EstadoTarea.set(false);
            this.xclaselab.xjifagenda = null;
            finalize();
        } catch (Throwable ex2) {
            Logger.getLogger(Agenda.class.getName()).log(Level.SEVERE, (String) null, ex2);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTabla_Ambulatorio() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"No. Historia", "Usuario", "Edad", "Sexo", "Hora de Llegada", "Id", "Atendido", "Estado", "EsPrioritario", "Tipo Atención", "TipoE", "Id_Ingreso", "Tipo", "CEspecial", "NRcepcion", "Entidad", "Persona que Factura", "Sede", "Accion Llamar"}) { // from class: Laboratorio.Agenda.2
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Integer.class, Long.class, JLabel.class, Integer.class, Long.class, String.class, String.class, String.class, JButton.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBDatosAgenda.setDefaultRenderer(JButton.class, new TableCellRenderer() { // from class: Laboratorio.Agenda.3
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
        this.JTBDatosAgenda.getColumnModel().getColumn(18).setPreferredWidth(150);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrear_Tabla_UH() {
        this.xmodelo1 = new DefaultTableModel(new Object[0], new String[]{"No. Historia", "Usuario", "Edad", "Sexo", "Hora Solicitud", "Id", "Atendido", "Estado", "EsPrioritario", "Tipo Atención", "TipoE", "Id_Ingreso", "Ubicación", "IdRecepcion", "Profesional que Solicita", "Fecha Orden", "Profesional que Ordena"}) { // from class: Laboratorio.Agenda.4
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
        if (this.txtFecha.getDate() != null && this.xmodelo != null && this.txtFecha != null) {
            this.xllenoCE = false;
            mCrearTabla_Ambulatorio();
            List<AgendaDetalleDTO> list = null;
            System.err.println("estado" + this.estado);
            if (this.JTFNombre.getText().isEmpty()) {
                if (this.estado == "0" || this.estado == "1,2") {
                    if (this.JCH_FiltroCitologia.isSelected()) {
                        if (this.filtroMunicipio.intValue() == 1) {
                            list = this.xImplLabotaorio.listAgendaIdProcedimiento(String.valueOf(this.estado), Integer.valueOf(Principal.sedeUsuarioSeleccionadaDTO.getId().toString()), Integer.valueOf(this.xlprocesamiento), this.metodos.formatoAMD.format(this.txtFecha.getDate()), "=1");
                        } else {
                            list = this.xImplLabotaorio.listAgendaIdProcedimiento(String.valueOf(this.estado), Integer.valueOf(Principal.sedeUsuarioSeleccionadaDTO.getId().toString()), Integer.valueOf(this.xlprocesamiento), this.metodos.formatoAMD.format(this.txtFecha.getDate()), "=1");
                        }
                    } else if (this.filtroMunicipio.intValue() == 1) {
                        list = this.xImplLabotaorio.listAgenda(String.valueOf(this.estado), Integer.valueOf(Principal.sedeUsuarioSeleccionadaDTO.getId().toString()), Integer.valueOf(this.xlprocesamiento), this.metodos.formatoAMD.format(this.txtFecha.getDate()), "=1", this.xIdMunicipio[this.JCBMunicipio.getSelectedIndex()]);
                        this.EstadoTarea.set(false);
                    } else {
                        list = this.xImplLabotaorio.listAgenda(String.valueOf(this.estado), Integer.valueOf(Principal.sedeUsuarioSeleccionadaDTO.getId().toString()), Integer.valueOf(this.xlprocesamiento), this.metodos.formatoAMD.format(this.txtFecha.getDate()), "=1", "");
                    }
                } else if (this.JCH_FiltroCitologia.isSelected()) {
                    if (this.filtroMunicipio.intValue() == 1) {
                        list = this.xImplLabotaorio.listAgendaIdProcedimiento("0,1,2", Integer.valueOf(Principal.sedeUsuarioSeleccionadaDTO.getId().toString()), Integer.valueOf(this.xlprocesamiento), this.metodos.formatoAMD.format(this.txtFecha.getDate()), "=1");
                        this.EstadoTarea.set(false);
                    } else {
                        list = this.xImplLabotaorio.listAgendaIdProcedimiento("0,1,2", Integer.valueOf(Principal.sedeUsuarioSeleccionadaDTO.getId().toString()), Integer.valueOf(this.xlprocesamiento), this.metodos.formatoAMD.format(this.txtFecha.getDate()), "=1");
                    }
                } else if (this.filtroMunicipio.intValue() == 1) {
                    list = this.xImplLabotaorio.listAgenda(String.valueOf(this.estado), Integer.valueOf(Principal.sedeUsuarioSeleccionadaDTO.getId().toString()), Integer.valueOf(this.xlprocesamiento), this.metodos.formatoAMD.format(this.txtFecha.getDate()), "=1", this.xIdMunicipio[this.JCBMunicipio.getSelectedIndex()]);
                    this.EstadoTarea.set(false);
                } else {
                    list = this.xImplLabotaorio.listAgenda(String.valueOf(this.estado), Integer.valueOf(Principal.sedeUsuarioSeleccionadaDTO.getId().toString()), Integer.valueOf(this.xlprocesamiento), this.metodos.formatoAMD.format(this.txtFecha.getDate()), "=1", "");
                }
            } else if (this.JCHFiltroRecepcion.isSelected()) {
                if (Principal.informacionIps.getNombreIps().equals("LABORATORIO CLINICO CENTRAL DE REFERENCIA S.A.S.") || Principal.informacionIps.getNombreIps().equals("E. S. E HOSPITAL SAN JUAN DE DIOS")) {
                    list = this.xImplLabotaorio.listAgendaNumeroRecepcion(this.JTFNombre.getText(), "=1");
                }
            } else if (this.filtroMunicipio.intValue() == 1) {
                list = this.xImplLabotaorio.listAgendaDocNombre(this.JTFNombre.getText(), "=1", this.metodos.formatoAMD.format(this.txtFecha.getDate()), this.xIdMunicipio[this.JCBMunicipio.getSelectedIndex()]);
                this.EstadoTarea.set(false);
            } else {
                list = this.xImplLabotaorio.listAgendaDocNombre(this.JTFNombre.getText(), "=1", this.metodos.formatoAMD.format(this.txtFecha.getDate()), "");
            }
            this.JBTAtencionPrior.setVisible(false);
            this.xlleno = 1;
            this.xN_UsuariosA = 0L;
            if (!list.isEmpty()) {
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
                        this.xmodelo.setValueAt(new JButton("Llamar"), x, 18);
                    } else {
                        this.xmodelo.setValueAt(new JButton("Llamar " + this.num), x, 18);
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
        if (this.txtFecha.getDate() != null && this.xmodelo != null) {
            this.xllenoUH = false;
            mCrear_Tabla_UH();
            List<AgendaDetalleDTO> list = null;
            if (this.JTFNombre.getText().isEmpty()) {
                if (this.estado == "0" || this.estado == "1,2") {
                    list = this.xImplLabotaorio.listAgenda(String.valueOf(this.estado), Integer.valueOf(Principal.sedeUsuarioSeleccionadaDTO.getId().toString()), Integer.valueOf(this.xlprocesamiento), this.metodos.formatoAMD.format(this.txtFecha.getDate()), ">1", "");
                } else {
                    list = this.xImplLabotaorio.listAgenda("0,1,2", Integer.valueOf(Principal.sedeUsuarioSeleccionadaDTO.getId().toString()), Integer.valueOf(this.xlprocesamiento), this.metodos.formatoAMD.format(this.txtFecha.getDate()), ">1", "");
                }
            } else if (this.JCHFiltroRecepcion.isSelected()) {
                if (Principal.informacionIps.getNombreIps().equals("LABORATORIO CLINICO CENTRAL DE REFERENCIA S.A.S.") || Principal.informacionIps.getNombreIps().equals("E. S. E HOSPITAL SAN JUAN DE DIOS")) {
                    list = this.xImplLabotaorio.listAgendaNumeroRecepcion(this.JTFNombre.getText(), "=1");
                }
            } else {
                list = this.xImplLabotaorio.listAgendaDocNombre(this.JTFNombre.getText(), ">1", this.metodos.formatoAMD.format(this.txtFecha.getDate()), "");
            }
            if (!list.isEmpty()) {
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

    /* JADX INFO: loaded from: GenomaP.jar:Laboratorio/Agenda$MiRender.class */
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
        this.JCHFiltro = new JCheckBox();
        this.JCBMunicipio = new JComboBox();
        this.JCHFiltroRecepcion = new JCheckBox();
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("AGENDA");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMaximumSize(null);
        setMinimumSize(null);
        setName("Agenda");
        addAncestorListener(new AncestorListener() { // from class: Laboratorio.Agenda.5
            public void ancestorAdded(AncestorEvent evt) {
            }

            public void ancestorMoved(AncestorEvent evt) {
            }

            public void ancestorRemoved(AncestorEvent evt) {
                Agenda.this.formAncestorRemoved(evt);
            }
        });
        addInternalFrameListener(new InternalFrameListener() { // from class: Laboratorio.Agenda.6
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
        this.JPIFiltro.setBorder(BorderFactory.createTitledBorder((Border) null, "FILTRAR POR :", 0, 0, new Font("Arial", 1, 12), new Color(0, 103, 0)));
        this.JBGFiltro.add(this.btnTodas);
        this.btnTodas.setFont(new Font("Arial", 1, 12));
        this.btnTodas.setForeground(Color.blue);
        this.btnTodas.setText("Todas");
        this.btnTodas.addActionListener(new ActionListener() { // from class: Laboratorio.Agenda.7
            public void actionPerformed(ActionEvent evt) {
                Agenda.this.btnTodasActionPerformed(evt);
            }
        });
        this.JBGFiltro.add(this.btnPorAtender);
        this.btnPorAtender.setFont(new Font("Arial", 1, 12));
        this.btnPorAtender.setForeground(Color.blue);
        this.btnPorAtender.setSelected(true);
        this.btnPorAtender.setText("Por Atender");
        this.btnPorAtender.addActionListener(new ActionListener() { // from class: Laboratorio.Agenda.8
            public void actionPerformed(ActionEvent evt) {
                Agenda.this.btnPorAtenderActionPerformed(evt);
            }
        });
        this.JBGFiltro.add(this.btnAtendidas);
        this.btnAtendidas.setFont(new Font("Arial", 1, 12));
        this.btnAtendidas.setForeground(Color.blue);
        this.btnAtendidas.setText("Atendidas");
        this.btnAtendidas.addActionListener(new ActionListener() { // from class: Laboratorio.Agenda.9
            public void actionPerformed(ActionEvent evt) {
                Agenda.this.btnAtendidasActionPerformed(evt);
            }
        });
        this.JBGFiltro.add(this.btnAtendidas1);
        this.btnAtendidas1.setFont(new Font("Arial", 1, 12));
        this.btnAtendidas1.setForeground(Color.blue);
        this.btnAtendidas1.setText("Recepcionada");
        this.btnAtendidas1.addActionListener(new ActionListener() { // from class: Laboratorio.Agenda.10
            public void actionPerformed(ActionEvent evt) {
                Agenda.this.btnAtendidas1ActionPerformed(evt);
            }
        });
        GroupLayout JPIFiltroLayout = new GroupLayout(this.JPIFiltro);
        this.JPIFiltro.setLayout(JPIFiltroLayout);
        JPIFiltroLayout.setHorizontalGroup(JPIFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFiltroLayout.createSequentialGroup().addContainerGap().addComponent(this.btnPorAtender).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.btnAtendidas1).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.btnAtendidas).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.btnTodas).addGap(14, 14, 14)));
        JPIFiltroLayout.setVerticalGroup(JPIFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFiltroLayout.createSequentialGroup().addGroup(JPIFiltroLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.btnPorAtender).addComponent(this.btnAtendidas).addComponent(this.btnTodas).addComponent(this.btnAtendidas1)).addContainerGap(16, 32767)));
        this.txtFecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Agenda", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtFecha.setDateFormatString("dd/MM/yyyy");
        this.txtFecha.setFont(new Font("Arial", 1, 12));
        this.txtFecha.addPropertyChangeListener(new PropertyChangeListener() { // from class: Laboratorio.Agenda.11
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
        this.txtCantidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Cantidad", 0, 0, new Font("Arial", 1, 14), new Color(255, 255, 255)));
        this.txtCantidad.setDisabledTextColor(new Color(255, 255, 255));
        this.txtCantidad.setEnabled(false);
        this.JPIFiltro_LP.setBorder(BorderFactory.createTitledBorder((Border) null, "LUGAR DE PROCESAMIENTO", 0, 0, new Font("Arial", 1, 12), new Color(0, 103, 0)));
        this.JBGFiltro_LP.add(this.JRBLab_Externo);
        this.JRBLab_Externo.setFont(new Font("Arial", 1, 12));
        this.JRBLab_Externo.setForeground(Color.blue);
        this.JRBLab_Externo.setText("Lab_Externo");
        this.JRBLab_Externo.addActionListener(new ActionListener() { // from class: Laboratorio.Agenda.12
            public void actionPerformed(ActionEvent evt) {
                Agenda.this.JRBLab_ExternoActionPerformed(evt);
            }
        });
        this.JBGFiltro_LP.add(this.JRBLaboratorio);
        this.JRBLaboratorio.setFont(new Font("Arial", 1, 12));
        this.JRBLaboratorio.setForeground(Color.blue);
        this.JRBLaboratorio.setSelected(true);
        this.JRBLaboratorio.setText("Laboratorio");
        this.JRBLaboratorio.addActionListener(new ActionListener() { // from class: Laboratorio.Agenda.13
            public void actionPerformed(ActionEvent evt) {
                Agenda.this.JRBLaboratorioActionPerformed(evt);
            }
        });
        this.JBGFiltro_LP.add(this.JRBConsultorio);
        this.JRBConsultorio.setFont(new Font("Arial", 1, 12));
        this.JRBConsultorio.setForeground(Color.blue);
        this.JRBConsultorio.setText("Consultorio");
        this.JRBConsultorio.addActionListener(new ActionListener() { // from class: Laboratorio.Agenda.14
            public void actionPerformed(ActionEvent evt) {
                Agenda.this.JRBConsultorioActionPerformed(evt);
            }
        });
        GroupLayout JPIFiltro_LPLayout = new GroupLayout(this.JPIFiltro_LP);
        this.JPIFiltro_LP.setLayout(JPIFiltro_LPLayout);
        JPIFiltro_LPLayout.setHorizontalGroup(JPIFiltro_LPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFiltro_LPLayout.createSequentialGroup().addContainerGap().addComponent(this.JRBLaboratorio).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBConsultorio).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBLab_Externo).addContainerGap(-1, 32767)));
        JPIFiltro_LPLayout.setVerticalGroup(JPIFiltro_LPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFiltro_LPLayout.createSequentialGroup().addGroup(JPIFiltro_LPLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBLaboratorio).addComponent(this.JRBConsultorio).addComponent(this.JRBLab_Externo)).addContainerGap(-1, 32767)));
        this.JBTAtencionPrior.setIcon(new ImageIcon(getClass().getResource("/Imagenes/prioridadA.gif")));
        this.JBTAtencionPrior.addActionListener(new ActionListener() { // from class: Laboratorio.Agenda.15
            public void actionPerformed(ActionEvent evt) {
                Agenda.this.JBTAtencionPriorActionPerformed(evt);
            }
        });
        this.JTPDatos.setForeground(new Color(0, 103, 0));
        this.JTPDatos.setFont(new Font("Arial", 1, 14));
        this.JTPDatos.addMouseListener(new MouseAdapter() { // from class: Laboratorio.Agenda.16
            public void mouseClicked(MouseEvent evt) {
                Agenda.this.JTPDatosMouseClicked(evt);
            }
        });
        this.JSPDatosAgenta.setBorder((Border) null);
        this.JTBDatosAgenda.setFont(new Font("Arial", 1, 12));
        this.JTBDatosAgenda.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTBDatosAgenda.setRowHeight(35);
        this.JTBDatosAgenda.setSelectionBackground(new Color(255, 255, 255));
        this.JTBDatosAgenda.setSelectionForeground(new Color(255, 0, 0));
        this.JTBDatosAgenda.setSelectionMode(0);
        this.JTBDatosAgenda.addMouseListener(new MouseAdapter() { // from class: Laboratorio.Agenda.17
            public void mouseClicked(MouseEvent evt) {
                Agenda.this.JTBDatosAgendaMouseClicked(evt);
            }
        });
        this.JSPDatosAgenta.setViewportView(this.JTBDatosAgenda);
        this.JTPDatos.addTab("CONSULTA EXTERNA", this.JSPDatosAgenta);
        this.JSPDatosAgenta1.setBorder((Border) null);
        this.JTBDatosAgenda1.setFont(new Font("Arial", 1, 12));
        this.JTBDatosAgenda1.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTBDatosAgenda1.setSelectionBackground(new Color(255, 255, 255));
        this.JTBDatosAgenda1.setSelectionForeground(new Color(255, 0, 0));
        this.JTBDatosAgenda1.setSelectionMode(0);
        this.JTBDatosAgenda1.addMouseListener(new MouseAdapter() { // from class: Laboratorio.Agenda.18
            public void mouseClicked(MouseEvent evt) {
                Agenda.this.JTBDatosAgenda1MouseClicked(evt);
            }
        });
        this.JSPDatosAgenta1.setViewportView(this.JTBDatosAgenda1);
        this.JTPDatos.addTab("SERVICIOS", this.JSPDatosAgenta1);
        this.JCH_FiltroCitologia.setFont(new Font("Arial", 1, 12));
        this.JCH_FiltroCitologia.setForeground(Color.red);
        this.JCH_FiltroCitologia.setText("Filtro Citología");
        this.JCH_FiltroCitologia.addActionListener(new ActionListener() { // from class: Laboratorio.Agenda.19
            public void actionPerformed(ActionEvent evt) {
                Agenda.this.JCH_FiltroCitologiaActionPerformed(evt);
            }
        });
        this.JTFNombre.setFont(new Font("Arial", 1, 12));
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Filtro por nombre o número de documento", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JTFNombre.addKeyListener(new KeyAdapter() { // from class: Laboratorio.Agenda.20
            public void keyPressed(KeyEvent evt) {
                Agenda.this.JTFNombreKeyPressed(evt);
            }

            public void keyTyped(KeyEvent evt) {
                Agenda.this.JTFNombreKeyTyped(evt);
            }
        });
        this.JCHFiltro.setFont(new Font("Arial", 1, 12));
        this.JCHFiltro.setText("Filtrar?");
        this.JCHFiltro.addActionListener(new ActionListener() { // from class: Laboratorio.Agenda.21
            public void actionPerformed(ActionEvent evt) {
                Agenda.this.JCHFiltroActionPerformed(evt);
            }
        });
        this.JCBMunicipio.setFont(new Font("Arial", 1, 12));
        this.JCBMunicipio.setBorder(BorderFactory.createTitledBorder((Border) null, "Municipio", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JCHFiltroRecepcion.setFont(new Font("Arial", 1, 12));
        this.JCHFiltroRecepcion.setText("Recepcion?");
        this.JCHFiltroRecepcion.addActionListener(new ActionListener() { // from class: Laboratorio.Agenda.22
            public void actionPerformed(ActionEvent evt) {
                Agenda.this.JCHFiltroRecepcionActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(10, 10, 10).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(layout.createSequentialGroup().addComponent(this.txtFecha, -2, 123, -2).addGap(10, 10, 10).addComponent(this.JPIFiltro, -2, -1, -2).addGap(22, 22, 22)).addGroup(layout.createSequentialGroup().addComponent(this.JTFNombre, -2, 449, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCH_FiltroCitologia).addComponent(this.JCHFiltroRecepcion)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED))).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(layout.createSequentialGroup().addComponent(this.txtCantidad, -2, 91, -2).addGap(18, 18, 18).addComponent(this.JPIFiltro_LP, -2, -1, -2)).addGroup(layout.createSequentialGroup().addComponent(this.JCBMunicipio, -2, 248, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHFiltro).addGap(10, 10, 10).addComponent(this.JBTAtencionPrior, -2, 164, -2)))).addComponent(this.JTPDatos)).addGap(5, 5, 5)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.JTPDatos, -2, 461, -2).addGap(5, 5, 5).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.txtFecha, -2, 59, -2).addComponent(this.JPIFiltro, -2, -1, -2).addComponent(this.txtCantidad, -2, 54, -2).addComponent(this.JPIFiltro_LP, -2, -1, -2)).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(5, 5, 5).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFNombre, -2, 54, -2).addComponent(this.JCHFiltro).addComponent(this.JCBMunicipio, -2, -1, -2)).addGap(10, 10, 10)).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addGroup(layout.createSequentialGroup().addComponent(this.JCHFiltroRecepcion).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JCH_FiltroCitologia)).addComponent(this.JBTAtencionPrior, -2, 51, -2)).addContainerGap()))));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnTodasActionPerformed(ActionEvent evt) {
        this.estado = "0,1,2";
        if (Principal.informacionIps.getNombreIps().equals("LABORATORIO CLINICO VIVIAN RAMIREZ I.P.S. S.A.") || Principal.informacionIps.getNombreIps().equals("BIOMED VIDA IPS S.A.S")) {
            mAgendaAmbulatoria();
        } else {
            mAgendaAmbulatoria();
            mAgendaUrgencias_Hospitalizacion();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnPorAtenderActionPerformed(ActionEvent evt) {
        this.estado = "0";
        if (Principal.informacionIps.getNombreIps().equals("LABORATORIO CLINICO CENTRAL DE REFERENCIA S.A.S.") || Principal.informacionIps.getNombreIps().equals("LABORATORIO CLINICO CENTRAL") || Principal.informacionIps.getNombreIps().equals("CENTRO MÉDICO SERVIFARMA IPS S.A.S.")) {
            mAgendaAmbulatoria();
        } else {
            mAgendaAmbulatoria();
            mAgendaUrgencias_Hospitalizacion();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnAtendidasActionPerformed(ActionEvent evt) {
        this.estado = "2";
        if (Principal.informacionIps.getNombreIps().equals("LABORATORIO CLINICO VIVIAN RAMIREZ I.P.S. S.A.") || Principal.informacionIps.getNombreIps().equals("BIOMED VIDA IPS S.A.S") || Principal.informacionIps.getNombreIps().equals("LABORATORIO CLINICO CENTRAL DE REFERENCIA S.A.S.") || Principal.informacionIps.getNombreIps().equals("LABORATORIO CLINICO CENTRAL") || Principal.informacionIps.getNombreIps().equals("CENTRO MÉDICO SERVIFARMA IPS S.A.S.")) {
            mAgendaAmbulatoria();
        } else {
            mAgendaAmbulatoria();
            mAgendaUrgencias_Hospitalizacion();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtFechaPropertyChange(PropertyChangeEvent evt) {
        if (this.xlleno == 1) {
            if (Principal.informacionIps.getNombreIps().equals("LABORATORIO CLINICO VIVIAN RAMIREZ I.P.S. S.A.") || Principal.informacionIps.getNombreIps().equals("BIOMED VIDA IPS S.A.S") || Principal.informacionIps.getNombreIps().equals("LABORATORIO CLINICO CENTRAL DE REFERENCIA S.A.S.") || Principal.informacionIps.getNombreIps().equals("LABORATORIO CLINICO CENTRAL") || Principal.informacionIps.getNombreIps().equals("CENTRO MÉDICO SERVIFARMA IPS S.A.S.")) {
                mAgendaAmbulatoria();
            } else {
                mAgendaAmbulatoria();
                mAgendaUrgencias_Hospitalizacion();
            }
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
        if (Principal.informacionIps.getNombreIps().equals("LABORATORIO CLINICO VIVIAN RAMIREZ I.P.S. S.A.") || Principal.informacionIps.getNombreIps().equals("BIOMED VIDA IPS S.A.S")) {
            mAgendaAmbulatoria();
        } else {
            mAgendaAmbulatoria();
            mAgendaUrgencias_Hospitalizacion();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBDatosAgendaMouseClicked(MouseEvent evt) {
        if (this.JTBDatosAgenda.getSelectedRow() != -1 && this.JTBDatosAgenda.getSelectedColumn() != 18) {
            this.sql = "UPDATE ll_datos_basicos set Estado=2 WHERE Documento='" + this.JTBDatosAgenda.getValueAt(this.JTBDatosAgenda.getSelectedRow(), 0) + "' AND DATE_FORMAT(Fecha_R,'%Y-%m-%d')='" + this.metodos.formatoAMD1.format(this.txtFecha.getDate()) + "'";
            this.xconsultasbd.ejecutarSQL(this.sql);
            this.xconsultasbd.cerrarConexionBd();
            this.estado_ = 2;
            this.xclaselab.setXidorden(this.xmodelo.getValueAt(this.JTBDatosAgenda.getSelectedRow(), 5).toString());
            this.xclaselab.setXtipo_empresa(Integer.parseInt(this.xmodelo.getValueAt(this.JTBDatosAgenda.getSelectedRow(), 10).toString()));
            this.xclaselab.setXid_ingreso(Long.parseLong(this.xmodelo.getValueAt(this.JTBDatosAgenda.getSelectedRow(), 11).toString()));
            this.xclaselab.setXposfila(this.JTBDatosAgenda.getSelectedRow());
            cargarAtencion(this.xmodelo);
            return;
        }
        if (this.JTBDatosAgenda.getSelectedColumn() == 18) {
            logoConsultorio();
            mLlamado(this.xmodelo.getValueAt(this.JTBDatosAgenda.getSelectedRow(), 1).toString(), Principal.consultorio);
        } else {
            this.sql = "UPDATE ll_datos_basicos set Estado=2 WHERE Documento='" + this.JTBDatosAgenda.getValueAt(this.JTBDatosAgenda.getSelectedRow(), 0) + "' AND Consultorio ='" + Principal.consultorio + "'";
            this.xconsultasbd.ejecutarSQL(this.sql);
            this.xconsultasbd.cerrarConexionBd();
            this.estado_ = 2;
        }
    }

    private void mLlamado(String Paciente, String Consultorio) {
        System.err.println("" + Paciente + " " + Consultorio);
        LLamadoTurnerDTO llamadoTurnerDTO = new LLamadoTurnerDTO();
        llamadoTurnerDTO.setPersona(Paciente);
        llamadoTurnerDTO.setLugarLlamado(Consultorio);
        try {
            RecursosMicroserviciosDomain microserviciosDomain = this.metodos.getParametrosEncriptados("24", "prueba");
            System.err.println("microserviciosDomain.getUrlRecurso()" + microserviciosDomain.getUrlRecurso());
            Response responsePos = this.metodos.getResteasyClient().target(microserviciosDomain.getUrlRecurso()).request().header("Authorization", "Bearer eyJraWQiOiIvcHJpdmF0ZWtleS5wZW0iLCJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ3YW5nKyIsInN1YiI6ImJpb21lZCIsImlhdCI6MTcxNTI2MjkxOSwiZXhwIjoxNzQ2Nzk4OTE5LCJncm91cHMiOlsiQURNSU4tV0FORysiXSwianRpIjoiM2E1ZjA1MjctNzBiNy00N2UzLWIwOTktMGRkMjFkOWFiZjNjIiwidXNlcklkIjoiMmFiOGFjNWQtODE4OS00NDY1LTgxZDktNzc2YTI3ODY1YWVhIiwic3Vic2NyaWJlcklkIjoiNDJjZjc5NzQtZWFjMS00ZjFmLTkxZmItZWZlODBhYzkzMTZmIn0.Q_Qgk03YTwwfURCPe8B5tlUHi36MH_U_1QlyZE_0ZRcf9_iIAkwDkhDl3yddy8aCyS6IzMXHxYwVx-51UTRS_shLVDuTw4MPLVtOz7Uv1BQeq703Ei3vqdeCJlyKCX0WSU3a8-lXlPbjjeZCzVaIgKueqfcwEYvikw6pNENPGulYkZocD1nebltfYf7ln7HRbwUegmJ3bPbhNaMeA7QDOCNzSVuH2STaUPLxcnyJLSXNCCarh0UEgRPQHM5zKGM2nUEMom_D6uS_0QuHPyE9SK5Dg6qkLsSkdtMaZ89nL12qodGEXxVStmhH7MDXFYmTtVqF5CxcEu7bBWV2ePzGyA").post(Entity.json(this.metodos.getMapper().writeValueAsString(llamadoTurnerDTO)));
            CustomPresenterTurner presenter = (CustomPresenterTurner) this.metodos.getMapper().readValue((String) responsePos.readEntity(String.class), CustomPresenterTurner.class);
            System.err.println("presenter" + this.metodos.getMapper().writeValueAsString(presenter));
            CustomRequesterTurner rerquester = (CustomRequesterTurner) this.metodos.getMapper().readValue(this.metodos.getMapper().writeValueAsString(presenter), CustomRequesterTurner.class);
            System.err.println("rerquester" + rerquester.getStatus());
            responsePos.close();
            this.metodos.getResteasyClient().close();
        } catch (JsonProcessingException e) {
            Logger.getLogger(Agenda.class.getName()).log(Level.SEVERE, (String) null, e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHFiltroActionPerformed(ActionEvent evt) {
        if (Principal.informacionIps.getNombreIps().equals("LABORATORIO CLINICO VIVIAN RAMIREZ I.P.S. S.A.") || Principal.informacionIps.getNombreIps().equals("BIOMED VIDA IPS S.A.S") || Principal.informacionIps.getNombreIps().equals("OROSALUD CAUCASIA IPS S.A.S")) {
            if (this.JCHFiltro.isSelected()) {
                this.filtroMunicipio = 1;
                mCargarCombo();
                return;
            } else {
                this.filtroMunicipio = 0;
                this.JCBMunicipio.setSelectedIndex(-1);
                return;
            }
        }
        JOptionPane.showInternalMessageDialog(this, "Función No Autorizada Comunicarse Con Genoma Empresarial ¡Gracias!", "CONFIRMACIÓN", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHFiltroRecepcionActionPerformed(ActionEvent evt) {
        if (Principal.informacionIps.getNombreIps().equals("LABORATORIO CLINICO CENTRAL DE REFERENCIA S.A.S.") || Principal.informacionIps.getNombreIps().equals("LABORATORIO CLINICO CENTRAL") || Principal.informacionIps.getNombreIps().equals("CENTRO MÉDICO SERVIFARMA IPS S.A.S.")) {
            this.JCHFiltroRecepcion.setSelected(true);
        } else {
            JOptionPane.showInternalMessageDialog(this, "Función No Autorizada Comunicarse Con Genoma Empresarial ¡Gracias!", "CONFIRMACIÓN", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
    }

    public void logoConsultorio() {
        this.sql = "SELECT UrlLogo  FROM c_consultorio cc WHERE Nbre ='" + Principal.consultorio + "'";
        try {
            ResultSet rs = this.xconsultasbd.traerRs(this.sql);
            Throwable th = null;
            try {
                if (rs.next()) {
                    this.logoConsltorio = rs.getString("UrlLogo");
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

    /* JADX WARN: Finally extract failed */
    public void llamar(String docuemtno) {
        this.disponible = true;
        this.sql = "SELECT  Profesional , Estado, Consultorio  FROM ll_datos_basicos ldb2 WHERE Documento ='" + docuemtno + "' and Original =1";
        try {
            ResultSet rs = this.xconsultasbd.traerRs(this.sql);
            Throwable th = null;
            try {
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
        } catch (SQLException ex) {
            Logger.getLogger(JIFAgendaTaquilla.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mCargarCombo() {
        this.JCBMunicipio.removeAllItems();
        List<Object[]> list = this.xRecepcionStikerDAO.ListMunicipiosRecepcionMunicipio(this.metodos.formatoAMD1.format(this.txtFecha.getDate()));
        this.xIdMunicipio = new String[list.size()];
        for (int x = 0; x < list.size(); x++) {
            this.xIdMunicipio[x] = list.get(x)[0].toString();
            this.JCBMunicipio.addItem(list.get(x)[1].toString());
        }
    }
}
