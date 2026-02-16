package Facturacion;

import Acceso.Principal;
import Citas.CalendarioGral;
import Historia.clasesHistoriaCE;
import Laboratorio.JIFPlanillaTrabajo;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.genoma.plus.jpa.entities.GPersona;
import com.genoma.plus.jpa.entities.GSexo;
import com.genoma.plus.jpa.entities.LlamadasEntity;
import com.genoma.plus.jpa.entities.TipoIdentificacionDTO;
import com.genoma.plus.jpa.service.EstadoAtencionService;
import com.genoma.plus.jpa.service.IGPersonaService;
import com.genoma.plus.jpa.service.LlamadasService;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
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
import org.jdesktop.jdnc.incubator.jxcombobox.IncompatibleLookAndFeelException;
import org.jdesktop.jdnc.incubator.jxcombobox.JTableComboBox;

/* JADX INFO: loaded from: GenomaP.jar:Facturacion/JIFAgendaTaquilla.class */
public class JIFAgendaTaquilla extends JInternalFrame {
    private Object[] xdato;
    private String xsql;
    private String[][] xidconcepto;
    private boolean xlleno1;
    private boolean disponible;
    public DefaultTableModel xmodelo;
    public DefaultTableModel modcombos2;
    private clasesHistoriaCE xclaseHC;
    private CalendarioGral frmCalendario;
    private final IGPersonaService personaService;
    private ButtonGroup JBGFiltro;
    public JDateChooser JDCFecha;
    private JPanel JPIDatosB;
    private JPanel JPIFiltroP;
    private JScrollPane JSPDatosAgenta;
    private JTable JTBDatosAgenda;
    public JRadioButton btnAtendidas;
    public JRadioButton btnEnAtencion;
    public JRadioButton btnPorAtender;
    public JRadioButton btnTodas;
    public JTableComboBox combo2;
    private JTextField txtCantidad;
    private final Metodos xmt = new Metodos();
    private final LlamadasService llamadasService = (LlamadasService) Principal.contexto.getBean(LlamadasService.class);
    private ConsultasMySQL xct = new ConsultasMySQL();
    private String profesional = "";
    private String consultorio = "";
    private String logoConsltorio = "";
    private String[][] xidprocedimiento = (String[][]) null;
    private boolean xlleno = false;
    private int estado = 0;
    private int xAplicaFiltroP = 0;
    private int render = 0;
    private int estado2 = 0;
    private Integer num = 0;
    private Integer estado_ = 0;
    private final EstadoAtencionService estadoAtencion = (EstadoAtencionService) Principal.contexto.getBean(EstadoAtencionService.class);
    AtomicBoolean EstadoTarea = new AtomicBoolean(true);

    public JIFAgendaTaquilla() {
        initComponents();
        this.personaService = (IGPersonaService) Principal.contexto.getBean(IGPersonaService.class);
        nuevo();
        ejecutarTareaTimer();
    }

    /* JADX WARN: Type inference failed for: r3v13, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGFiltro = new ButtonGroup();
        this.txtCantidad = new JTextField();
        this.JSPDatosAgenta = new JScrollPane();
        this.JTBDatosAgenda = new JTable();
        this.JPIDatosB = new JPanel();
        this.JDCFecha = new JDateChooser();
        try {
            this.combo2 = new JTableComboBox();
        } catch (IncompatibleLookAndFeelException e1) {
            e1.printStackTrace();
        }
        this.JPIFiltroP = new JPanel();
        this.btnPorAtender = new JRadioButton();
        this.btnEnAtencion = new JRadioButton();
        this.btnAtendidas = new JRadioButton();
        this.btnTodas = new JRadioButton();
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("AGENDA");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMinimumSize(new Dimension(926, 583));
        setName("Agenda");
        addAncestorListener(new AncestorListener() { // from class: Facturacion.JIFAgendaTaquilla.1
            public void ancestorMoved(AncestorEvent evt) {
            }

            public void ancestorAdded(AncestorEvent evt) {
            }

            public void ancestorRemoved(AncestorEvent evt) {
                JIFAgendaTaquilla.this.formAncestorRemoved(evt);
            }
        });
        addInternalFrameListener(new InternalFrameListener() { // from class: Facturacion.JIFAgendaTaquilla.2
            public void internalFrameOpened(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIFAgendaTaquilla.this.formInternalFrameClosing(evt);
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameIconified(InternalFrameEvent evt) {
            }

            public void internalFrameDeiconified(InternalFrameEvent evt) {
            }

            public void internalFrameActivated(InternalFrameEvent evt) {
            }

            public void internalFrameDeactivated(InternalFrameEvent evt) {
            }
        });
        this.txtCantidad.setFont(new Font("Arial", 1, 14));
        this.txtCantidad.setForeground(new Color(255, 0, 0));
        this.txtCantidad.setHorizontalAlignment(0);
        this.txtCantidad.setText("0");
        this.txtCantidad.setToolTipText("Cantidad de usuarios");
        this.txtCantidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Cantidad", 0, 0, new Font("Arial", 1, 14), Color.blue));
        this.txtCantidad.setDisabledTextColor(new Color(255, 255, 255));
        this.JSPDatosAgenta.setBorder(BorderFactory.createTitledBorder((Border) null, "LISTADO DE USUARIOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTBDatosAgenda.setFont(new Font("Arial", 1, 12));
        this.JTBDatosAgenda.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTBDatosAgenda.setCursor(new Cursor(0));
        this.JTBDatosAgenda.setRowHeight(25);
        this.JTBDatosAgenda.setSelectionBackground(new Color(255, 255, 255));
        this.JTBDatosAgenda.setSelectionForeground(new Color(255, 0, 0));
        this.JTBDatosAgenda.setSelectionMode(0);
        this.JTBDatosAgenda.addMouseListener(new MouseAdapter() { // from class: Facturacion.JIFAgendaTaquilla.3
            public void mouseClicked(MouseEvent evt) {
                JIFAgendaTaquilla.this.JTBDatosAgendaMouseClicked(evt);
            }
        });
        this.JSPDatosAgenta.setViewportView(this.JTBDatosAgenda);
        this.JPIDatosB.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS PARA BÚSQUEDA", 0, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.JPIDatosB.addMouseListener(new MouseAdapter() { // from class: Facturacion.JIFAgendaTaquilla.4
            public void mouseClicked(MouseEvent evt) {
                JIFAgendaTaquilla.this.JPIDatosBMouseClicked(evt);
            }
        });
        this.JDCFecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFecha.setDateFormatString("dd/MM/yyyy");
        this.JDCFecha.setFont(new Font("Arial", 1, 12));
        this.JDCFecha.addPropertyChangeListener(new PropertyChangeListener() { // from class: Facturacion.JIFAgendaTaquilla.5
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFAgendaTaquilla.this.JDCFechaPropertyChange(evt);
            }
        });
        this.combo2.setBorder(BorderFactory.createTitledBorder((Border) null, "Ventanilla", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.combo2.setFont(new Font("Arial", 1, 12));
        this.combo2.setShowTableGrid(true);
        this.combo2.setShowTableHeaders(true);
        GroupLayout JPIDatosBLayout = new GroupLayout(this.JPIDatosB);
        this.JPIDatosB.setLayout(JPIDatosBLayout);
        JPIDatosBLayout.setHorizontalGroup(JPIDatosBLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosBLayout.createSequentialGroup().addContainerGap().addComponent(this.JDCFecha, -2, -1, -2).addGap(18, 18, 18).addComponent(this.combo2, -2, 416, -2).addContainerGap(-1, 32767)));
        JPIDatosBLayout.setVerticalGroup(JPIDatosBLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosBLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosBLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JDCFecha, -1, 50, 32767).addComponent(this.combo2, -2, -1, -2)).addContainerGap(18, 32767)));
        this.JPIFiltroP.setBorder(BorderFactory.createTitledBorder((Border) null, "FILTRAR POR :", 0, 0, new Font("Arial", 1, 12), new Color(0, 103, 0)));
        this.btnPorAtender.setBackground(new Color(0, 0, 102));
        this.JBGFiltro.add(this.btnPorAtender);
        this.btnPorAtender.setFont(new Font("Arial", 1, 12));
        this.btnPorAtender.setForeground(new Color(255, 255, 255));
        this.btnPorAtender.setSelected(true);
        this.btnPorAtender.setText("Por Atender");
        this.btnPorAtender.setOpaque(true);
        this.btnPorAtender.addActionListener(new ActionListener() { // from class: Facturacion.JIFAgendaTaquilla.6
            public void actionPerformed(ActionEvent evt) {
                JIFAgendaTaquilla.this.btnPorAtenderActionPerformed(evt);
            }
        });
        this.btnEnAtencion.setBackground(new Color(177, 251, 177));
        this.JBGFiltro.add(this.btnEnAtencion);
        this.btnEnAtencion.setFont(new Font("Arial", 1, 12));
        this.btnEnAtencion.setText("En atención");
        this.btnEnAtencion.setOpaque(true);
        this.btnEnAtencion.addActionListener(new ActionListener() { // from class: Facturacion.JIFAgendaTaquilla.7
            public void actionPerformed(ActionEvent evt) {
                JIFAgendaTaquilla.this.btnEnAtencionActionPerformed(evt);
            }
        });
        this.btnAtendidas.setBackground(new Color(103, 0, 103));
        this.JBGFiltro.add(this.btnAtendidas);
        this.btnAtendidas.setFont(new Font("Arial", 1, 12));
        this.btnAtendidas.setForeground(new Color(255, 255, 255));
        this.btnAtendidas.setText("Atendidas");
        this.btnAtendidas.setOpaque(true);
        this.btnAtendidas.addActionListener(new ActionListener() { // from class: Facturacion.JIFAgendaTaquilla.8
            public void actionPerformed(ActionEvent evt) {
                JIFAgendaTaquilla.this.btnAtendidasActionPerformed(evt);
            }
        });
        this.JBGFiltro.add(this.btnTodas);
        this.btnTodas.setFont(new Font("Arial", 1, 12));
        this.btnTodas.setForeground(Color.blue);
        this.btnTodas.setText("Todas");
        this.btnTodas.addActionListener(new ActionListener() { // from class: Facturacion.JIFAgendaTaquilla.9
            public void actionPerformed(ActionEvent evt) {
                JIFAgendaTaquilla.this.btnTodasActionPerformed(evt);
            }
        });
        GroupLayout JPIFiltroPLayout = new GroupLayout(this.JPIFiltroP);
        this.JPIFiltroP.setLayout(JPIFiltroPLayout);
        JPIFiltroPLayout.setHorizontalGroup(JPIFiltroPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFiltroPLayout.createSequentialGroup().addContainerGap().addComponent(this.btnPorAtender).addGap(12, 12, 12).addComponent(this.btnEnAtencion).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.btnAtendidas).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 46, 32767).addComponent(this.btnTodas).addGap(19, 19, 19)));
        JPIFiltroPLayout.setVerticalGroup(JPIFiltroPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFiltroPLayout.createSequentialGroup().addContainerGap().addGroup(JPIFiltroPLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.btnPorAtender).addComponent(this.btnTodas).addComponent(this.btnEnAtencion).addComponent(this.btnAtendidas, -2, 23, -2)).addContainerGap(10, 32767)));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(6, 6, 6).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIDatosB, -1, -1, 32767).addComponent(this.JSPDatosAgenta, -1, 1047, 32767)).addContainerGap()).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.txtCantidad, -2, 162, -2).addGap(43, 43, 43).addComponent(this.JPIFiltroP, -2, -1, -2).addContainerGap(-1, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatosB, -2, -1, -2).addGap(18, 18, 18).addComponent(this.JSPDatosAgenta, -1, 354, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.txtCantidad, -2, 61, -2).addComponent(this.JPIFiltroP, -2, -1, -2)).addContainerGap()));
        pack();
    }

    private void buscaarPacientes(String documento) {
        if (this.combo2.getSelectedIndex() != -1) {
            new ArrayList();
            this.num = 0;
            List<LlamadasEntity> list = this.llamadasService.ListarPacientes(documento, this.combo2.getSelectedItem().toString());
            System.out.println(list.toString());
            if (!list.isEmpty()) {
                this.num = Integer.valueOf(list.size());
            }
            System.out.println(this.num);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        this.EstadoTarea.set(false);
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formAncestorRemoved(AncestorEvent evt) {
        this.EstadoTarea.set(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDCFechaPropertyChange(PropertyChangeEvent evt) {
    }

    private void ejecutarTareaTimer() {
        final Timer timer = new Timer();
        timer.schedule(new TimerTask() { // from class: Facturacion.JIFAgendaTaquilla.10
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (JIFAgendaTaquilla.this.EstadoTarea.get()) {
                    JIFAgendaTaquilla.this.mCargarDatos();
                } else {
                    System.out.println("Finaliza ejecucion de Timer de Agenda de Laboratorio");
                    timer.cancel();
                }
            }
        }, 0L, 30000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBDatosAgendaMouseClicked(MouseEvent evt) {
        if (this.JTBDatosAgenda.getSelectedRow() != -1 && this.combo2.getSelectedIndex() != -1 && this.JTBDatosAgenda.getSelectedColumn() != 10) {
            int x = JOptionPane.showConfirmDialog(this, "¿Desea facturar a este paciente?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                this.xsql = "UPDATE ll_datos_basicos set Estado=2 WHERE Documento='" + this.JTBDatosAgenda.getValueAt(this.JTBDatosAgenda.getSelectedRow(), 0) + "'";
                System.out.println(this.xsql);
                this.xct.ejecutarSQL(this.xsql);
                this.xct.cerrarConexionBd();
                this.estado_ = 2;
                TipoIdentificacionDTO tipoIdentificacionDTO = new TipoIdentificacionDTO();
                tipoIdentificacionDTO.setId("CC");
                Optional<GPersona> personaDato = this.personaService.datosPersonaPorTipoDocumentoNumero(tipoIdentificacionDTO, this.JTBDatosAgenda.getValueAt(this.JTBDatosAgenda.getSelectedRow(), 0).toString());
                GPersona persona = new GPersona();
                if (personaDato.isPresent()) {
                    persona = personaDato.get();
                } else {
                    persona.setIdTipoIdentificacion(tipoIdentificacionDTO);
                    persona.setNoDocumento(this.JTBDatosAgenda.getValueAt(this.JTBDatosAgenda.getSelectedRow(), 0).toString());
                    persona.setApellido1(this.xmodelo.getValueAt(this.JTBDatosAgenda.getSelectedRow(), 3).toString());
                    persona.setApellido2(this.xmodelo.getValueAt(this.JTBDatosAgenda.getSelectedRow(), 4).toString());
                    persona.setNombre1(this.xmodelo.getValueAt(this.JTBDatosAgenda.getSelectedRow(), 1).toString());
                    persona.setNombre2(this.xmodelo.getValueAt(this.JTBDatosAgenda.getSelectedRow(), 2).toString());
                    persona.setFechaNac(Date.valueOf(this.xmodelo.getValueAt(this.JTBDatosAgenda.getSelectedRow(), 6).toString()));
                    GSexo sexo = new GSexo();
                    sexo.setId(this.xmodelo.getValueAt(this.JTBDatosAgenda.getSelectedRow(), 5).toString());
                    persona.setIdSexo(sexo);
                    if (Integer.parseInt(this.xmodelo.getValueAt(this.JTBDatosAgenda.getSelectedRow(), 8).toString()) == 0) {
                        persona.setRh(false);
                    } else {
                        persona.setRh(true);
                    }
                    persona.setGrupoSangre(this.xmodelo.getValueAt(this.JTBDatosAgenda.getSelectedRow(), 7).toString().replace("+", "").replace("-", ""));
                }
                Principal.clasefacturacion.setPersona(persona);
                if (Principal.informacionIps.getNombreIps().equals("LABORATORIO CLÍNICO LABVY S.A.S")) {
                    Principal.clasefacturacion.cargarPantalla("Facturac");
                    Principal.clasefacturacion.frmFacturac.frmPersona.txtHistoria.setText(this.xmodelo.getValueAt(this.JTBDatosAgenda.getSelectedRow(), 0).toString());
                    Principal.clasefacturacion.frmFacturac.frmPersona.txtNombre1.setText(this.xmodelo.getValueAt(this.JTBDatosAgenda.getSelectedRow(), 1).toString());
                    Principal.clasefacturacion.frmFacturac.frmPersona.txtNombre2.setText(this.xmodelo.getValueAt(this.JTBDatosAgenda.getSelectedRow(), 2).toString());
                    Principal.clasefacturacion.frmFacturac.frmPersona.txtApellido1.setText(this.xmodelo.getValueAt(this.JTBDatosAgenda.getSelectedRow(), 3).toString());
                    Principal.clasefacturacion.frmFacturac.frmPersona.txtApellido2.setText(this.xmodelo.getValueAt(this.JTBDatosAgenda.getSelectedRow(), 4).toString());
                    if (this.xmodelo.getValueAt(this.JTBDatosAgenda.getSelectedRow(), 5).toString().equals("F")) {
                        Principal.clasefacturacion.frmFacturac.frmPersona.cboSexo.setSelectedItem("FEMENINO");
                    } else if (this.xmodelo.getValueAt(this.JTBDatosAgenda.getSelectedRow(), 5).toString().equals("M")) {
                        Principal.clasefacturacion.frmFacturac.frmPersona.cboSexo.setSelectedItem("MASCULINO");
                    } else {
                        Principal.clasefacturacion.frmFacturac.frmPersona.cboSexo.setSelectedItem("OTRO");
                    }
                    Principal.clasefacturacion.frmFacturac.frmPersona.cboFechaNacimiento.setDate(Date.valueOf(this.xmodelo.getValueAt(this.JTBDatosAgenda.getSelectedRow(), 6).toString()));
                    Principal.clasefacturacion.frmFacturac.frmPersona.limpiarCampos = 1;
                    Principal.clasefacturacion.frmFacturac.frmPersona.buscar(2);
                } else {
                    Principal.clasefacturacion.cargarPantalla("FacturaA");
                }
                actualiza_estado(2);
                return;
            }
            return;
        }
        LlamadasEntity seguimientos = new LlamadasEntity();
        if (this.JTBDatosAgenda.getSelectedColumn() == 10) {
            int x2 = JOptionPane.showConfirmDialog(this, "Esta seguro de  llamar al paciente " + this.JTBDatosAgenda.getValueAt(this.JTBDatosAgenda.getSelectedRow(), 2) + " en el consultorio " + this.combo2.getSelectedItem().toString() + "?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x2 == 0) {
                llamar(this.xmodelo.getValueAt(this.JTBDatosAgenda.getSelectedRow(), 0).toString());
                if (this.disponible) {
                    logoConsultorio();
                    seguimientos.setDocumento(this.xmodelo.getValueAt(this.JTBDatosAgenda.getSelectedRow(), 0).toString());
                    seguimientos.setNombre("" + this.xmodelo.getValueAt(this.JTBDatosAgenda.getSelectedRow(), 1).toString() + " " + this.xmodelo.getValueAt(this.JTBDatosAgenda.getSelectedRow(), 3).toString());
                    seguimientos.setProfesional(Principal.usuarioSistemaDTO.getNombreUsuario());
                    seguimientos.setConsultorio(this.combo2.getSelectedItem().toString());
                    seguimientos.setEstado(1);
                    seguimientos.setLogoConsultorio(this.logoConsltorio);
                    seguimientos.setUbicacion(this.combo2.getPopupTable().getValueAt(this.combo2.getSelectedIndex(), 2).toString());
                    System.out.println(this.combo2.getPopupTable().getValueAt(this.combo2.getSelectedIndex(), 2).toString());
                    seguimientos.setFecha_R(this.xmt.formadFecha(this.xmt.formatoAMDH24_1.format(this.xmt.getFechaActual())));
                    if (this.num.intValue() < 3) {
                        new ArrayList();
                        List<LlamadasEntity> list = this.llamadasService.ListarPacientes((String) this.JTBDatosAgenda.getValueAt(this.JTBDatosAgenda.getSelectedRow(), 0), this.combo2.getSelectedItem().toString());
                        if (list.isEmpty()) {
                            seguimientos.setOriginal(1);
                        } else {
                            seguimientos.setOriginal((Integer) null);
                        }
                        this.xmt.primerPaciente2(this.xmodelo.getValueAt(this.JTBDatosAgenda.getSelectedRow(), 0).toString(), this.combo2.getSelectedItem().toString());
                        System.out.println("si actualizo");
                        this.llamadasService.Grabar(seguimientos);
                        this.estado_ = 1;
                        actualiza_estado(1);
                        System.out.println("si grabo");
                        this.num = Integer.valueOf(list.size());
                        return;
                    }
                    int x1 = JOptionPane.showConfirmDialog(this, "se excedio el numero de llamados, quieres volver a llamar a este paciente?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    if (x1 == 0) {
                        this.num = 0;
                        return;
                    }
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Este paciente ya lo llamaron en el consultorio " + this.consultorio + "", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            }
        }
    }

    public void logoConsultorio() {
        String sql = "SELECT UrlLogo  FROM c_consultorio cc WHERE Nbre ='" + this.combo2.getSelectedItem().toString() + "'";
        System.out.println(sql);
        try {
            ResultSet rs = this.xct.traerRs(sql);
            Throwable th = null;
            try {
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
            } catch (Throwable th3) {
                th = th3;
                throw th3;
            }
        } catch (SQLException ex) {
            Logger.getLogger(JIFAgendaTaquilla.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnPorAtenderActionPerformed(ActionEvent evt) {
        this.estado = 0;
        mCargarDatos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnEnAtencionActionPerformed(ActionEvent evt) {
        this.estado = 1;
        mCargarDatos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnAtendidasActionPerformed(ActionEvent evt) {
        this.estado = 2;
        mCargarDatos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnTodasActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JPIDatosBMouseClicked(MouseEvent evt) {
    }

    /* JADX WARN: Not initialized variable reg: 7, insn: 0x00ce: MOVE (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r7 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('rs' java.sql.ResultSet)]) A[TRY_LEAVE], block:B:28:0x00ce */
    /* JADX WARN: Not initialized variable reg: 8, insn: 0x00d2: MOVE (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r8 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:30:0x00d2 */
    private void llamar(String docuemtno) {
        this.disponible = true;
        this.xsql = "SELECT  Profesional , Estado, Consultorio  FROM ll_datos_basicos ldb2 WHERE Documento ='" + docuemtno + "' and Original =1";
        System.out.println(this.xsql);
        try {
            try {
                ResultSet rs = this.xct.traerRs(this.xsql);
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

    private void nuevo() {
        this.JDCFecha.setDate(this.xmt.getFechaActual());
        cargarConsultorio();
        this.combo2.setSelectedIndex(0);
    }

    public void actualiza_estado(Integer estado) {
        try {
            this.xsql = "UPDATE f_registro set Estado=" + estado + " WHERE NoDocumento='" + this.JTBDatosAgenda.getValueAt(this.JTBDatosAgenda.getSelectedRow(), 0) + "'";
            this.xct.ejecutarSQL(this.xsql);
        } catch (Exception ex) {
            Logger.getLogger(JIFPlanillaTrabajo.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloTabla() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"No.Documento", "Primer NOmbre", "Segundo Nombre", "Primer Apellido", "Segundo Apellido", "Sexo", "Fecha Nacimiento", "Grupo Sanguineo", "Rh", "Estado", "Accion Llamar"}) { // from class: Facturacion.JIFAgendaTaquilla.11
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, java.util.Date.class, String.class, Long.class, Integer.class, JButton.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBDatosAgenda.setModel(this.xmodelo);
        this.JTBDatosAgenda.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTBDatosAgenda.getColumnModel().getColumn(1).setPreferredWidth(150);
        this.JTBDatosAgenda.getColumnModel().getColumn(2).setPreferredWidth(150);
        this.JTBDatosAgenda.getColumnModel().getColumn(3).setPreferredWidth(150);
        this.JTBDatosAgenda.getColumnModel().getColumn(4).setPreferredWidth(150);
        this.JTBDatosAgenda.getColumnModel().getColumn(5).setPreferredWidth(50);
        this.JTBDatosAgenda.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTBDatosAgenda.getColumnModel().getColumn(7).setPreferredWidth(50);
        this.JTBDatosAgenda.getColumnModel().getColumn(8).setPreferredWidth(50);
        this.JTBDatosAgenda.getColumnModel().getColumn(9).setPreferredWidth(100);
        this.JTBDatosAgenda.getColumnModel().getColumn(10).setPreferredWidth(100);
    }

    /* JADX INFO: loaded from: GenomaP.jar:Facturacion/JIFAgendaTaquilla$ButtonRenderer.class */
    private class ButtonRenderer implements TableCellRenderer {
        private ButtonRenderer() {
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            JButton button = (JButton) value;
            return button;
        }
    }

    public void mCargarDatos() {
        mCrearModeloTabla();
        if (this.btnTodas.isSelected()) {
            this.xsql = "Select NoDocumento, ifnull(Nombre1,'') as Nombre1, ifnull(Nombre2,'') as Nombre2, ifnull(Apellido1,'') as Apellido1, ifnull(Apellido2,'') as Apellido2, Id_Sexo ,FechaNac ,GrupoSangre, Rh, Estado  FROM f_registro fr WHERE DATE_FORMAT(Fecha_R, '%Y-%m-%d')='" + this.xmt.formatoAMD1.format(this.JDCFecha.getDate()) + "'";
        } else {
            this.xsql = "Select NoDocumento, ifnull(Nombre1,'') as Nombre1, ifnull(Nombre2,'') as Nombre2, ifnull(Apellido1,'') as Apellido1, ifnull(Apellido2,'') as Apellido2, Id_Sexo ,FechaNac ,GrupoSangre, Rh, Estado  FROM f_registro fr WHERE Estado ='" + this.estado + "' and  DATE_FORMAT(Fecha_R, '%Y-%m-%d')='" + this.xmt.formatoAMD1.format(this.JDCFecha.getDate()) + "'";
        }
        System.out.println(this.xsql);
        try {
            ResultSet rs = this.xct.traerRs(this.xsql);
            Throwable th = null;
            try {
                if (rs.next()) {
                    rs.beforeFirst();
                    while (rs.next()) {
                        this.xmodelo.addRow(this.xdato);
                        this.xmodelo.setValueAt(rs.getString("NoDocumento"), this.JTBDatosAgenda.getRowCount() - 1, 0);
                        this.xmodelo.setValueAt(rs.getString("Nombre1"), this.JTBDatosAgenda.getRowCount() - 1, 1);
                        this.xmodelo.setValueAt(rs.getString("Nombre2"), this.JTBDatosAgenda.getRowCount() - 1, 2);
                        this.xmodelo.setValueAt(rs.getString("Apellido1"), this.JTBDatosAgenda.getRowCount() - 1, 3);
                        this.xmodelo.setValueAt(rs.getString("Apellido2"), this.JTBDatosAgenda.getRowCount() - 1, 4);
                        this.xmodelo.setValueAt(rs.getString("Id_Sexo"), this.JTBDatosAgenda.getRowCount() - 1, 5);
                        this.xmodelo.setValueAt(rs.getDate("FechaNac"), this.JTBDatosAgenda.getRowCount() - 1, 6);
                        this.xmodelo.setValueAt(rs.getString("GrupoSangre"), this.JTBDatosAgenda.getRowCount() - 1, 7);
                        this.xmodelo.setValueAt(Long.valueOf(rs.getLong("Rh")), this.JTBDatosAgenda.getRowCount() - 1, 8);
                        this.xmodelo.setValueAt(Integer.valueOf(rs.getInt("Estado")), this.JTBDatosAgenda.getRowCount() - 1, 9);
                        buscaarPacientes(rs.getString("NoDocumento"));
                        if (this.num.intValue() == 0) {
                            this.xmodelo.setValueAt(new JButton("Llamar "), this.JTBDatosAgenda.getRowCount() - 1, 10);
                        } else {
                            this.xmodelo.setValueAt(new JButton("Llamar " + this.num), this.JTBDatosAgenda.getRowCount() - 1, 10);
                        }
                        this.JTBDatosAgenda.setDefaultRenderer(Object.class, new MiRender());
                        this.JTBDatosAgenda.setDefaultRenderer(JButton.class, new ButtonRenderer());
                    }
                    this.txtCantidad.setText("" + this.JTBDatosAgenda.getRowCount());
                } else {
                    mCrearModeloTabla();
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

    /* JADX INFO: loaded from: GenomaP.jar:Facturacion/JIFAgendaTaquilla$MiRender.class */
    public class MiRender extends DefaultTableCellRenderer {
        public MiRender() {
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (table.getValueAt(row, 9) != null) {
                switch (Integer.valueOf(table.getValueAt(row, 9).toString()).intValue()) {
                    case 0:
                        cell.setBackground(new Color(0, 0, 102));
                        cell.setForeground(Color.WHITE);
                        break;
                    case 1:
                        cell.setBackground(new Color(177, 251, 177));
                        cell.setForeground(Color.BLACK);
                        break;
                    case 2:
                        cell.setBackground(new Color(103, 0, 103));
                        cell.setForeground(Color.WHITE);
                        break;
                    case 3:
                        cell.setBackground(new Color(177, 251, 177));
                        cell.setForeground(Color.BLACK);
                        break;
                    default:
                        cell.setBackground(Color.WHITE);
                        cell.setForeground(Color.BLACK);
                        break;
                }
            }
            return cell;
        }
    }

    private void cargarConsultorio() {
        this.xsql = "select cc.Id id , cc.Nbre nombre, cc.Ubicacion  ubicacion\nfrom c_consultorio cc \ninner join c_claseconsultorio cc2 on (cc.Id_ClaseCons=cc2.Id)\nwhere cc.Estado =0\norder by nombre asc";
        this.xct.llenarComboTabla(this.xsql, this.combo2, this.modcombos2, 1);
        this.xct.cerrarConexionBd();
    }
}
