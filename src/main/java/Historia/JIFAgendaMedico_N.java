package Historia;

import Acceso.Principal;
import Laboratorio.JIFPlanillaTrabajo;
import Laboratorio.Render;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.genoma.plus.jpa.entities.LlamadasEntity;
import com.genoma.plus.jpa.service.LlamadasService;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
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
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/* JADX INFO: loaded from: GenomaP.jar:Historia/JIFAgendaMedico_N.class */
public class JIFAgendaMedico_N extends JInternalFrame {
    private String xsql;
    public DefaultTableModel xmodelo;
    public DefaultTableModel xmodelo1;
    public DefaultTableModel xmodelo_urgencias;
    public DefaultTableModel xmodelo_hospitalizacion;
    public DefaultTableModel xmodelo_cx;
    private Object[] xdato;
    public mRefrescarAgenda1 claseHilo;
    private Thread hilo;
    public int xtipo;
    private clasesHistoriaCE xclaseHC;
    public boolean xlleno1;
    public String xid_profesional;
    public String xid_especialidad;
    private ButtonGroup JBGFiltro;
    private ButtonGroup JBGFiltro1;
    private ButtonGroup JBGFiltro2;
    private JButton JBTActualizar;
    private JButton JBTActualizar1;
    private JButton JBTActualizar_H;
    private JButton JBTActualizar_H1;
    private JButton JBTCCirugiasP;
    private static JButton JBT_AtencionesPendientes;
    private static JButton JBT_AtencionesPendientes1;
    private static JButton JBT_AtencionesPendientes2;
    private JCheckBox JCHAdministrativos;
    private JCheckBox JCHEspecial;
    private JCheckBox JCHEspecial1;
    private JCheckBox JCHFiltro;
    private JCheckBox JCHFiltro1;
    private JCheckBox JCHFiltro_Cx;
    private JCheckBox JCHFiltro_H;
    private JCheckBox JCHFiltro_Profesional;
    private JCheckBox JCHFiltro_Profesional_U;
    private JCheckBox JCHFiltro_U;
    private JCheckBox JCHPExpuestos;
    public JCheckBox JCH_FSalaParto;
    public JDateChooser JDCFechaAgenda;
    public JDateChooser JDCFechaAgenda1;
    public JDateChooser JDCFechaAgenda2;
    public JDateChooser JDCFechaAgendaCX;
    private JLabel JLBNPRegistro;
    private JLabel JLBNREnAtencion;
    private JLabel JLBNRegistro;
    private JLabel JLBNRegistro_H;
    private JLabel JLBNRegistro_U;
    private JLabel JLB_CxNRegistro;
    private JPanel JPIEstado;
    private JPanel JPIEstadoH;
    private JPanel JPIFiltro;
    private JPanel JPIFiltroNombre;
    private JPanel JPIFiltroNombre1;
    private JPanel JPIFiltroNombre2;
    private JPanel JPIFiltroNombre_Cx;
    private JPanel JPI_AHospitalizacion;
    private JPanel JPI_AUrgencias;
    private JPanel JPI_CExterna;
    private JPanel JPI_Cirugia;
    private JRadioButton JRBAtendidas;
    private JRadioButton JRBDeAlta_H;
    private JRadioButton JRBDeAlta_U;
    private JRadioButton JRBEnAtencion_H;
    private JRadioButton JRBEnAtencion_U;
    private JRadioButton JRBPorAtender;
    private JRadioButton JRBSinFact;
    private JRadioButton JRBTodas;
    private JScrollPane JSPAgenda;
    private JScrollPane JSPAgendaNP;
    private JScrollPane JSPAgendaU;
    private JScrollPane JSPAgenda_H;
    private JScrollPane JSP_CxAgenda;
    public JTable JTA_Cxgenda;
    public JTable JTAgendaH;
    public JTable JTAgendaNP;
    public JTable JTAgendaP;
    public JTable JTAgendaU;
    private JTextField JTF;
    private JTextField JTFNombre_Cx;
    private JTextField JTFNombre_H;
    private JTextField JTFNombre_u;
    public JTabbedPane JTP_DatosAgenda;
    private Metodos xmt = new Metodos();
    private ConsultasMySQL xct = new ConsultasMySQL();
    private final LlamadasService llamadasService = (LlamadasService) Principal.contexto.getBean(LlamadasService.class);
    public int xestado = 0;
    public int xidt = -1;
    public int xpos = -1;
    public int xposnp = -1;
    public int xestadonp = 0;
    public int xestado_atencion = 0;
    public int xestado_atencion_h = 0;
    public int xestado_atencion_cx = 0;
    public int xTab_AUgencias = 1;
    public boolean xlleno = false;
    public boolean xACExterna = false;
    public boolean xAUrgencias = false;
    public boolean xASParto = false;
    public boolean xAHospit = false;
    public boolean xCRemovio = false;
    private int xN_NProgramados = 0;
    private int num = 0;
    private int estado_ = 0;

    public JIFAgendaMedico_N(clasesHistoriaCE xclaseHC, int xtipo) {
        this.xtipo = 0;
        this.xlleno1 = false;
        initComponents();
        this.xtipo = xtipo;
        this.xclaseHC = xclaseHC;
        this.xid_profesional = Principal.usuarioSistemaDTO.getIdUsuarioSistema().toString();
        this.xid_especialidad = String.valueOf(Principal.informacionGeneralPrincipalDTO.getIdEspecialidad());
        setTitle("AGENDA : " + Principal.informacionGeneralPrincipalDTO.getNombreEspecialidad());
        mNuevo();
        mValidar_CitasEspeciales();
        mValidar_CitasEspeciales_Urgencias();
        iniciarHilo();
        if (null != clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTipoAtencion()) {
            switch (clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTipoAtencion().intValue()) {
                case 1:
                    this.JTP_DatosAgenda.setSelectedIndex(0);
                    break;
                case 2:
                    this.JTP_DatosAgenda.setSelectedIndex(3);
                    break;
                case 3:
                    this.JTP_DatosAgenda.setSelectedIndex(1);
                    break;
            }
        }
        if (Principal.informacionIps.getNombreIps().equals("INSTITUTO COLOMBIANO DE NEUROCIENCIAS APLICADAS S.A.S.")) {
            this.JTP_DatosAgenda.remove(3);
            this.JTP_DatosAgenda.remove(2);
            this.JTP_DatosAgenda.remove(1);
            this.JTP_DatosAgenda.addTab("REHABILITACION", this.JPI_AHospitalizacion);
        } else if (Principal.informacionIps.getNombreIps().equals("IPS ESPERANZAS DE VIDA SAS")) {
            this.JTP_DatosAgenda.remove(3);
            this.JTP_DatosAgenda.remove(2);
            this.JTP_DatosAgenda.remove(1);
            this.JTP_DatosAgenda.addTab("TERAPIAS INTEGRALES", this.JPI_AHospitalizacion);
        }
        this.xlleno1 = true;
    }

    public JIFAgendaMedico_N(String xid_profesional, String xId_Especialdiad, int xTipo) {
        this.xtipo = 0;
        this.xlleno1 = false;
        initComponents();
        this.xtipo = xTipo;
        this.xid_profesional = xid_profesional;
        this.xid_especialidad = xId_Especialdiad;
        mNuevo();
        mValidar_CitasEspeciales();
        mValidar_CitasEspeciales_Urgencias();
        iniciarHilo();
        this.JTP_DatosAgenda.remove(0);
        this.JTP_DatosAgenda.remove(1);
        this.xlleno1 = true;
    }

    /* JADX WARN: Type inference failed for: r3v138, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v15, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v221, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v277, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v8, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGFiltro = new ButtonGroup();
        this.JBGFiltro1 = new ButtonGroup();
        this.JBGFiltro2 = new ButtonGroup();
        this.JTP_DatosAgenda = new JTabbedPane();
        this.JPI_CExterna = new JPanel();
        this.JSPAgenda = new JScrollPane();
        this.JTAgendaP = new JTable();
        this.JSPAgendaNP = new JScrollPane();
        this.JTAgendaNP = new JTable();
        this.JDCFechaAgenda = new JDateChooser();
        this.JPIFiltro = new JPanel();
        this.JRBTodas = new JRadioButton();
        this.JRBSinFact = new JRadioButton();
        this.JRBPorAtender = new JRadioButton();
        this.JRBAtendidas = new JRadioButton();
        this.JLBNRegistro = new JLabel();
        this.JLBNPRegistro = new JLabel();
        JBT_AtencionesPendientes = new JButton();
        this.JPIFiltroNombre = new JPanel();
        this.JTF = new JTextField();
        this.JCHFiltro = new JCheckBox();
        this.JBTActualizar = new JButton();
        this.JCHFiltro_Profesional = new JCheckBox();
        this.JCHFiltro1 = new JCheckBox();
        this.JBTCCirugiasP = new JButton();
        this.JPI_AUrgencias = new JPanel();
        this.JPIEstado = new JPanel();
        this.JRBEnAtencion_U = new JRadioButton();
        this.JRBDeAlta_U = new JRadioButton();
        this.JLBNRegistro_U = new JLabel();
        this.JSPAgendaU = new JScrollPane();
        this.JTAgendaU = new JTable();
        this.JPIFiltroNombre1 = new JPanel();
        this.JTFNombre_u = new JTextField();
        this.JCHFiltro_U = new JCheckBox();
        this.JBTActualizar1 = new JButton();
        this.JDCFechaAgenda1 = new JDateChooser();
        this.JCHFiltro_Profesional_U = new JCheckBox();
        this.JCHEspecial = new JCheckBox();
        this.JCHAdministrativos = new JCheckBox();
        this.JCHPExpuestos = new JCheckBox();
        this.JCHEspecial1 = new JCheckBox();
        JBT_AtencionesPendientes1 = new JButton();
        this.JLBNREnAtencion = new JLabel();
        this.JPI_Cirugia = new JPanel();
        this.JPIFiltroNombre_Cx = new JPanel();
        this.JTFNombre_Cx = new JTextField();
        this.JCHFiltro_Cx = new JCheckBox();
        this.JBTActualizar_H1 = new JButton();
        this.JLB_CxNRegistro = new JLabel();
        this.JSP_CxAgenda = new JScrollPane();
        this.JTA_Cxgenda = new JTable();
        this.JDCFechaAgendaCX = new JDateChooser();
        this.JPI_AHospitalizacion = new JPanel();
        this.JPIEstadoH = new JPanel();
        this.JRBEnAtencion_H = new JRadioButton();
        this.JRBDeAlta_H = new JRadioButton();
        this.JLBNRegistro_H = new JLabel();
        this.JSPAgenda_H = new JScrollPane();
        this.JTAgendaH = new JTable();
        this.JPIFiltroNombre2 = new JPanel();
        this.JTFNombre_H = new JTextField();
        this.JCHFiltro_H = new JCheckBox();
        this.JBTActualizar_H = new JButton();
        this.JDCFechaAgenda2 = new JDateChooser();
        this.JCH_FSalaParto = new JCheckBox();
        JBT_AtencionesPendientes2 = new JButton();
        setClosable(true);
        setIconifiable(true);
        setTitle("AGENDA");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jif_agendamedico");
        this.JTP_DatosAgenda.setForeground(Color.red);
        this.JTP_DatosAgenda.setFont(new Font("Arial", 1, 14));
        this.JSPAgenda.setBorder(BorderFactory.createTitledBorder((Border) null, "CONSULTA PROGRAMADA", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JSPAgenda.addMouseListener(new MouseAdapter() { // from class: Historia.JIFAgendaMedico_N.1
            public void mouseClicked(MouseEvent evt) {
                JIFAgendaMedico_N.this.JSPAgendaMouseClicked(evt);
            }
        });
        this.JTAgendaP.setFont(new Font("Arial", 1, 12));
        this.JTAgendaP.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTAgendaP.setRowHeight(39);
        this.JTAgendaP.setSelectionBackground(new Color(255, 255, 255));
        this.JTAgendaP.setSelectionForeground(new Color(255, 0, 0));
        this.JTAgendaP.setSelectionMode(0);
        this.JTAgendaP.addMouseListener(new MouseAdapter() { // from class: Historia.JIFAgendaMedico_N.2
            public void mouseClicked(MouseEvent evt) {
                JIFAgendaMedico_N.this.JTAgendaPMouseClicked(evt);
            }
        });
        this.JSPAgenda.setViewportView(this.JTAgendaP);
        this.JSPAgendaNP.setBorder(BorderFactory.createTitledBorder((Border) null, "CONSULTAS NO PRGRAMADAS O PRIORITARIAS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTAgendaNP.setFont(new Font("Arial", 1, 12));
        this.JTAgendaNP.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTAgendaNP.setRowHeight(39);
        this.JTAgendaNP.setSelectionBackground(new Color(255, 255, 255));
        this.JTAgendaNP.setSelectionForeground(new Color(255, 0, 0));
        this.JTAgendaNP.addMouseListener(new MouseAdapter() { // from class: Historia.JIFAgendaMedico_N.3
            public void mouseClicked(MouseEvent evt) {
                JIFAgendaMedico_N.this.JTAgendaNPMouseClicked(evt);
            }
        });
        this.JSPAgendaNP.setViewportView(this.JTAgendaNP);
        this.JDCFechaAgenda.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaAgenda.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaAgenda.setFont(new Font("Arial", 1, 12));
        this.JDCFechaAgenda.addPropertyChangeListener(new PropertyChangeListener() { // from class: Historia.JIFAgendaMedico_N.4
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFAgendaMedico_N.this.JDCFechaAgendaPropertyChange(evt);
            }
        });
        this.JPIFiltro.setBorder(BorderFactory.createTitledBorder((Border) null, "FILTRAR POR : ", 0, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JBGFiltro.add(this.JRBTodas);
        this.JRBTodas.setFont(new Font("Arial", 1, 12));
        this.JRBTodas.setForeground(new Color(0, 0, 255));
        this.JRBTodas.setText("Todas");
        this.JRBTodas.addActionListener(new ActionListener() { // from class: Historia.JIFAgendaMedico_N.5
            public void actionPerformed(ActionEvent evt) {
                JIFAgendaMedico_N.this.JRBTodasActionPerformed(evt);
            }
        });
        this.JBGFiltro.add(this.JRBSinFact);
        this.JRBSinFact.setFont(new Font("Arial", 1, 12));
        this.JRBSinFact.setForeground(new Color(0, 0, 255));
        this.JRBSinFact.setText("Sin Facturar");
        this.JRBSinFact.addActionListener(new ActionListener() { // from class: Historia.JIFAgendaMedico_N.6
            public void actionPerformed(ActionEvent evt) {
                JIFAgendaMedico_N.this.JRBSinFactActionPerformed(evt);
            }
        });
        this.JBGFiltro.add(this.JRBPorAtender);
        this.JRBPorAtender.setFont(new Font("Arial", 1, 12));
        this.JRBPorAtender.setForeground(new Color(0, 0, 255));
        this.JRBPorAtender.setSelected(true);
        this.JRBPorAtender.setText("Por Atender");
        this.JRBPorAtender.addActionListener(new ActionListener() { // from class: Historia.JIFAgendaMedico_N.7
            public void actionPerformed(ActionEvent evt) {
                JIFAgendaMedico_N.this.JRBPorAtenderActionPerformed(evt);
            }
        });
        this.JBGFiltro.add(this.JRBAtendidas);
        this.JRBAtendidas.setFont(new Font("Arial", 1, 12));
        this.JRBAtendidas.setForeground(new Color(0, 0, 255));
        this.JRBAtendidas.setText("Atendidas");
        this.JRBAtendidas.addActionListener(new ActionListener() { // from class: Historia.JIFAgendaMedico_N.8
            public void actionPerformed(ActionEvent evt) {
                JIFAgendaMedico_N.this.JRBAtendidasActionPerformed(evt);
            }
        });
        GroupLayout JPIFiltroLayout = new GroupLayout(this.JPIFiltro);
        this.JPIFiltro.setLayout(JPIFiltroLayout);
        JPIFiltroLayout.setHorizontalGroup(JPIFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFiltroLayout.createSequentialGroup().addComponent(this.JRBTodas).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBSinFact).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBPorAtender).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBAtendidas).addContainerGap(-1, 32767)));
        JPIFiltroLayout.setVerticalGroup(JPIFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFiltroLayout.createSequentialGroup().addGroup(JPIFiltroLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBTodas).addComponent(this.JRBSinFact).addComponent(this.JRBPorAtender).addComponent(this.JRBAtendidas)).addContainerGap(-1, 32767)));
        this.JLBNRegistro.setBackground(new Color(255, 255, 255));
        this.JLBNRegistro.setFont(new Font("Arial", 1, 18));
        this.JLBNRegistro.setHorizontalAlignment(0);
        this.JLBNRegistro.setBorder(BorderFactory.createTitledBorder((Border) null, "Nº Registro Programado", 2, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JLBNPRegistro.setBackground(new Color(255, 255, 255));
        this.JLBNPRegistro.setFont(new Font("Arial", 1, 18));
        this.JLBNPRegistro.setHorizontalAlignment(0);
        this.JLBNPRegistro.setBorder(BorderFactory.createTitledBorder((Border) null, "Nº Registro No Programado", 2, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        JBT_AtencionesPendientes.setFont(new Font("Tahoma", 1, 12));
        JBT_AtencionesPendientes.addActionListener(new ActionListener() { // from class: Historia.JIFAgendaMedico_N.9
            public void actionPerformed(ActionEvent evt) {
                JIFAgendaMedico_N.this.JBT_AtencionesPendientesActionPerformed(evt);
            }
        });
        this.JPIFiltroNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "BÚSQUEDA FILTRADA POR NOMBRE", 0, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.JTF.setFont(new Font("Arial", 1, 12));
        this.JTF.addKeyListener(new KeyAdapter() { // from class: Historia.JIFAgendaMedico_N.10
            public void keyPressed(KeyEvent evt) {
                JIFAgendaMedico_N.this.JTFKeyPressed(evt);
            }
        });
        this.JCHFiltro.setFont(new Font("Arial", 1, 12));
        this.JCHFiltro.setText("Filtro");
        this.JBTActualizar.setFont(new Font("Arial", 1, 12));
        this.JBTActualizar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/actualizar.png")));
        this.JBTActualizar.setText("Actualizar Agenda");
        this.JBTActualizar.addActionListener(new ActionListener() { // from class: Historia.JIFAgendaMedico_N.11
            public void actionPerformed(ActionEvent evt) {
                JIFAgendaMedico_N.this.JBTActualizarActionPerformed(evt);
            }
        });
        GroupLayout JPIFiltroNombreLayout = new GroupLayout(this.JPIFiltroNombre);
        this.JPIFiltroNombre.setLayout(JPIFiltroNombreLayout);
        JPIFiltroNombreLayout.setHorizontalGroup(JPIFiltroNombreLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFiltroNombreLayout.createSequentialGroup().addContainerGap().addComponent(this.JTF, -2, 483, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHFiltro).addGap(18, 18, 18).addComponent(this.JBTActualizar, -2, 180, -2).addContainerGap(-1, 32767)));
        JPIFiltroNombreLayout.setVerticalGroup(JPIFiltroNombreLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIFiltroNombreLayout.createSequentialGroup().addGroup(JPIFiltroNombreLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPIFiltroNombreLayout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.JCHFiltro)).addComponent(this.JTF).addGroup(JPIFiltroNombreLayout.createSequentialGroup().addComponent(this.JBTActualizar, -1, -1, 32767).addGap(1, 1, 1))).addContainerGap()));
        this.JCHFiltro_Profesional.setFont(new Font("Arial", 1, 12));
        this.JCHFiltro_Profesional.setText("Filtrar Profesional");
        this.JCHFiltro_Profesional.addActionListener(new ActionListener() { // from class: Historia.JIFAgendaMedico_N.12
            public void actionPerformed(ActionEvent evt) {
                JIFAgendaMedico_N.this.JCHFiltro_ProfesionalActionPerformed(evt);
            }
        });
        this.JCHFiltro1.setFont(new Font("Arial", 1, 12));
        this.JCHFiltro1.setSelected(true);
        this.JCHFiltro1.setText("Utilizar Triage?");
        this.JCHFiltro1.addActionListener(new ActionListener() { // from class: Historia.JIFAgendaMedico_N.13
            public void actionPerformed(ActionEvent evt) {
                JIFAgendaMedico_N.this.JCHFiltro1ActionPerformed(evt);
            }
        });
        this.JBTCCirugiasP.setFont(new Font("Arial", 1, 12));
        this.JBTCCirugiasP.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Cirugia.png")));
        this.JBTCCirugiasP.setText("<html><P ALIGN=center> Cirugías Programadas");
        this.JBTCCirugiasP.addActionListener(new ActionListener() { // from class: Historia.JIFAgendaMedico_N.14
            public void actionPerformed(ActionEvent evt) {
                JIFAgendaMedico_N.this.JBTCCirugiasPActionPerformed(evt);
            }
        });
        GroupLayout JPI_CExternaLayout = new GroupLayout(this.JPI_CExterna);
        this.JPI_CExterna.setLayout(JPI_CExternaLayout);
        JPI_CExternaLayout.setHorizontalGroup(JPI_CExternaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_CExternaLayout.createSequentialGroup().addContainerGap().addGroup(JPI_CExternaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_CExternaLayout.createSequentialGroup().addComponent(this.JPIFiltroNombre, -2, -1, -2).addGap(5, 5, 5).addGroup(JPI_CExternaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHFiltro1, -2, 124, -2).addGroup(JPI_CExternaLayout.createSequentialGroup().addComponent(this.JCHFiltro_Profesional, -1, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTCCirugiasP, -2, 201, -2).addContainerGap(-1, 32767)))).addGroup(JPI_CExternaLayout.createSequentialGroup().addGroup(JPI_CExternaLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPI_CExternaLayout.createSequentialGroup().addComponent(this.JDCFechaAgenda, -2, 143, -2).addGap(18, 18, 18).addComponent(this.JPIFiltro, -2, -1, -2).addGap(18, 18, 18).addComponent(this.JLBNRegistro, -2, 170, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JLBNPRegistro, -2, 183, -2).addGap(18, 18, 18).addComponent(JBT_AtencionesPendientes, -1, 159, 32767)).addComponent(this.JSPAgenda).addComponent(this.JSPAgendaNP)).addContainerGap(8, 32767)))));
        JPI_CExternaLayout.setVerticalGroup(JPI_CExternaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_CExternaLayout.createSequentialGroup().addContainerGap().addGroup(JPI_CExternaLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JLBNPRegistro, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JLBNRegistro, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JPIFiltro, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JDCFechaAgenda, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(JBT_AtencionesPendientes, -2, 56, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPAgenda, -2, 262, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPAgendaNP, -2, 204, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPI_CExternaLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JCHFiltro1).addComponent(this.JPIFiltroNombre, GroupLayout.Alignment.LEADING, -2, -1, -2).addGroup(GroupLayout.Alignment.LEADING, JPI_CExternaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBTCCirugiasP).addComponent(this.JCHFiltro_Profesional))).addContainerGap()));
        this.JTP_DatosAgenda.addTab("CONSULTA EXTERNA", this.JPI_CExterna);
        this.JPIEstado.setBorder(BorderFactory.createTitledBorder((Border) null, "Estado", 0, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.JBGFiltro1.add(this.JRBEnAtencion_U);
        this.JRBEnAtencion_U.setFont(new Font("Arial", 1, 12));
        this.JRBEnAtencion_U.setForeground(Color.blue);
        this.JRBEnAtencion_U.setSelected(true);
        this.JRBEnAtencion_U.setText("En Atención");
        this.JRBEnAtencion_U.addActionListener(new ActionListener() { // from class: Historia.JIFAgendaMedico_N.15
            public void actionPerformed(ActionEvent evt) {
                JIFAgendaMedico_N.this.JRBEnAtencion_UActionPerformed(evt);
            }
        });
        this.JBGFiltro1.add(this.JRBDeAlta_U);
        this.JRBDeAlta_U.setFont(new Font("Arial", 1, 12));
        this.JRBDeAlta_U.setForeground(Color.blue);
        this.JRBDeAlta_U.setText("De Alta");
        this.JRBDeAlta_U.addActionListener(new ActionListener() { // from class: Historia.JIFAgendaMedico_N.16
            public void actionPerformed(ActionEvent evt) {
                JIFAgendaMedico_N.this.JRBDeAlta_UActionPerformed(evt);
            }
        });
        GroupLayout JPIEstadoLayout = new GroupLayout(this.JPIEstado);
        this.JPIEstado.setLayout(JPIEstadoLayout);
        JPIEstadoLayout.setHorizontalGroup(JPIEstadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIEstadoLayout.createSequentialGroup().addContainerGap().addComponent(this.JRBEnAtencion_U).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBDeAlta_U).addContainerGap(-1, 32767)));
        JPIEstadoLayout.setVerticalGroup(JPIEstadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIEstadoLayout.createSequentialGroup().addGroup(JPIEstadoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBEnAtencion_U).addComponent(this.JRBDeAlta_U)).addContainerGap(-1, 32767)));
        this.JLBNRegistro_U.setBackground(new Color(255, 255, 255));
        this.JLBNRegistro_U.setFont(new Font("Arial", 1, 18));
        this.JLBNRegistro_U.setHorizontalAlignment(0);
        this.JLBNRegistro_U.setBorder(BorderFactory.createTitledBorder((Border) null, "Cant.", 2, 0, new Font("Arial", 1, 12), Color.cyan));
        this.JSPAgendaU.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTAgendaU.setFont(new Font("Arial", 1, 12));
        this.JTAgendaU.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTAgendaU.setRowHeight(39);
        this.JTAgendaU.setSelectionBackground(new Color(255, 255, 255));
        this.JTAgendaU.setSelectionForeground(new Color(255, 0, 0));
        this.JTAgendaU.addMouseListener(new MouseAdapter() { // from class: Historia.JIFAgendaMedico_N.17
            public void mouseClicked(MouseEvent evt) {
                JIFAgendaMedico_N.this.JTAgendaUMouseClicked(evt);
            }
        });
        this.JSPAgendaU.setViewportView(this.JTAgendaU);
        this.JPIFiltroNombre1.setBorder(BorderFactory.createTitledBorder((Border) null, "BÚSQUEDA FILTRADA POR NOMBRE", 0, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.JTFNombre_u.setFont(new Font("Arial", 1, 12));
        this.JCHFiltro_U.setFont(new Font("Arial", 1, 12));
        this.JCHFiltro_U.setText("Filtro");
        this.JBTActualizar1.setFont(new Font("Arial", 1, 12));
        this.JBTActualizar1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/actualizar.png")));
        this.JBTActualizar1.setText("<html><P ALIGN=center>Actualizar Agenda");
        this.JBTActualizar1.addActionListener(new ActionListener() { // from class: Historia.JIFAgendaMedico_N.18
            public void actionPerformed(ActionEvent evt) {
                JIFAgendaMedico_N.this.JBTActualizar1ActionPerformed(evt);
            }
        });
        GroupLayout JPIFiltroNombre1Layout = new GroupLayout(this.JPIFiltroNombre1);
        this.JPIFiltroNombre1.setLayout(JPIFiltroNombre1Layout);
        JPIFiltroNombre1Layout.setHorizontalGroup(JPIFiltroNombre1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFiltroNombre1Layout.createSequentialGroup().addContainerGap().addComponent(this.JTFNombre_u, -2, 317, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHFiltro_U).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBTActualizar1, -2, 133, -2).addContainerGap(-1, 32767)));
        JPIFiltroNombre1Layout.setVerticalGroup(JPIFiltroNombre1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIFiltroNombre1Layout.createSequentialGroup().addGroup(JPIFiltroNombre1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPIFiltroNombre1Layout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.JCHFiltro_U)).addComponent(this.JTFNombre_u).addComponent(this.JBTActualizar1)).addContainerGap()));
        this.JDCFechaAgenda1.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaAgenda1.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaAgenda1.setFont(new Font("Arial", 1, 12));
        this.JDCFechaAgenda1.addPropertyChangeListener(new PropertyChangeListener() { // from class: Historia.JIFAgendaMedico_N.19
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFAgendaMedico_N.this.JDCFechaAgenda1PropertyChange(evt);
            }
        });
        this.JCHFiltro_Profesional_U.setFont(new Font("Arial", 1, 12));
        this.JCHFiltro_Profesional_U.setText("Filtrar Profesional");
        this.JCHEspecial.setBackground(Color.cyan);
        this.JCHEspecial.setFont(new Font("Arial", 1, 12));
        this.JCHEspecial.setSelected(true);
        this.JCHEspecial.setText("Por Atención");
        this.JCHAdministrativos.setBackground(Color.magenta);
        this.JCHAdministrativos.setFont(new Font("Arial", 1, 12));
        this.JCHAdministrativos.setSelected(true);
        this.JCHAdministrativos.setText("Historía Inicial Cerrada");
        this.JCHPExpuestos.setBackground(new Color(133, 218, 160));
        this.JCHPExpuestos.setFont(new Font("Arial", 1, 12));
        this.JCHPExpuestos.setSelected(true);
        this.JCHPExpuestos.setText("En Atención Medica");
        this.JCHPExpuestos.addActionListener(new ActionListener() { // from class: Historia.JIFAgendaMedico_N.20
            public void actionPerformed(ActionEvent evt) {
                JIFAgendaMedico_N.this.JCHPExpuestosActionPerformed(evt);
            }
        });
        this.JCHEspecial1.setBackground(Color.red);
        this.JCHEspecial1.setFont(new Font("Arial", 1, 12));
        this.JCHEspecial1.setSelected(true);
        this.JCHEspecial1.setText("Por Atención (Urgente)");
        JBT_AtencionesPendientes1.setFont(new Font("Tahoma", 1, 12));
        JBT_AtencionesPendientes1.addActionListener(new ActionListener() { // from class: Historia.JIFAgendaMedico_N.21
            public void actionPerformed(ActionEvent evt) {
                JIFAgendaMedico_N.this.JBT_AtencionesPendientes1ActionPerformed(evt);
            }
        });
        this.JLBNREnAtencion.setBackground(new Color(255, 255, 255));
        this.JLBNREnAtencion.setFont(new Font("Arial", 1, 18));
        this.JLBNREnAtencion.setHorizontalAlignment(0);
        this.JLBNREnAtencion.setBorder(BorderFactory.createTitledBorder((Border) null, "Cant.", 2, 0, new Font("Arial", 1, 12), new Color(133, 218, 160)));
        GroupLayout JPI_AUrgenciasLayout = new GroupLayout(this.JPI_AUrgencias);
        this.JPI_AUrgencias.setLayout(JPI_AUrgenciasLayout);
        JPI_AUrgenciasLayout.setHorizontalGroup(JPI_AUrgenciasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_AUrgenciasLayout.createSequentialGroup().addContainerGap().addGroup(JPI_AUrgenciasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_AUrgenciasLayout.createSequentialGroup().addComponent(this.JCHEspecial, -2, 142, -2).addGap(18, 18, 18).addComponent(this.JCHEspecial1).addGap(26, 26, 26).addComponent(this.JCHPExpuestos, -2, 156, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHAdministrativos).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(JBT_AtencionesPendientes1, -2, 191, -2)).addComponent(this.JSPAgendaU).addGroup(JPI_AUrgenciasLayout.createSequentialGroup().addComponent(this.JDCFechaAgenda1, -2, 143, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JPIEstado, -2, -1, -2).addGap(26, 26, 26).addComponent(this.JPIFiltroNombre1, -2, -1, -2).addGroup(JPI_AUrgenciasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_AUrgenciasLayout.createSequentialGroup().addGap(46, 46, 46).addComponent(this.JCHFiltro_Profesional_U, -1, -1, 32767)).addGroup(JPI_AUrgenciasLayout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JLBNRegistro_U, -2, 80, -2).addGap(18, 18, 18).addComponent(this.JLBNREnAtencion, -2, 80, -2).addGap(0, 0, 32767))))).addContainerGap()));
        JPI_AUrgenciasLayout.setVerticalGroup(JPI_AUrgenciasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_AUrgenciasLayout.createSequentialGroup().addContainerGap().addGroup(JPI_AUrgenciasLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JPIFiltroNombre1, -1, -1, 32767).addGroup(JPI_AUrgenciasLayout.createSequentialGroup().addGap(0, 0, 32767).addGroup(JPI_AUrgenciasLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPI_AUrgenciasLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JDCFechaAgenda1, -1, -1, 32767).addComponent(this.JPIEstado, -1, -1, 32767)).addGroup(JPI_AUrgenciasLayout.createSequentialGroup().addComponent(this.JCHFiltro_Profesional_U).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPI_AUrgenciasLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JLBNRegistro_U, -2, 42, -2).addComponent(this.JLBNREnAtencion, -2, 42, -2)))))).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPAgendaU, -2, 476, -2).addGroup(JPI_AUrgenciasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_AUrgenciasLayout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(JPI_AUrgenciasLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCHEspecial).addComponent(this.JCHPExpuestos).addComponent(this.JCHAdministrativos).addComponent(this.JCHEspecial1)).addGap(18, 18, 18)).addGroup(JPI_AUrgenciasLayout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(JBT_AtencionesPendientes1, -2, 58, -2).addContainerGap()))));
        this.JTP_DatosAgenda.addTab("URGENCIAS", this.JPI_AUrgencias);
        this.JPIFiltroNombre_Cx.setBorder(BorderFactory.createTitledBorder((Border) null, "BÚSQUEDA FILTRADA POR NOMBRE", 0, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.JTFNombre_Cx.setFont(new Font("Arial", 1, 12));
        this.JCHFiltro_Cx.setFont(new Font("Arial", 1, 12));
        this.JCHFiltro_Cx.setText("Filtro");
        this.JBTActualizar_H1.setFont(new Font("Arial", 1, 12));
        this.JBTActualizar_H1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/actualizar.png")));
        this.JBTActualizar_H1.setText("Actualizar Agenda");
        this.JBTActualizar_H1.addActionListener(new ActionListener() { // from class: Historia.JIFAgendaMedico_N.22
            public void actionPerformed(ActionEvent evt) {
                JIFAgendaMedico_N.this.JBTActualizar_H1ActionPerformed(evt);
            }
        });
        GroupLayout JPIFiltroNombre_CxLayout = new GroupLayout(this.JPIFiltroNombre_Cx);
        this.JPIFiltroNombre_Cx.setLayout(JPIFiltroNombre_CxLayout);
        JPIFiltroNombre_CxLayout.setHorizontalGroup(JPIFiltroNombre_CxLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFiltroNombre_CxLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFNombre_Cx, -2, 370, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHFiltro_Cx).addGap(18, 18, 18).addComponent(this.JBTActualizar_H1, -2, 180, -2).addContainerGap(-1, 32767)));
        JPIFiltroNombre_CxLayout.setVerticalGroup(JPIFiltroNombre_CxLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIFiltroNombre_CxLayout.createSequentialGroup().addGroup(JPIFiltroNombre_CxLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPIFiltroNombre_CxLayout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.JCHFiltro_Cx)).addComponent(this.JTFNombre_Cx).addGroup(JPIFiltroNombre_CxLayout.createSequentialGroup().addComponent(this.JBTActualizar_H1, -1, -1, 32767).addGap(1, 1, 1))).addContainerGap()));
        this.JLB_CxNRegistro.setBackground(new Color(255, 255, 255));
        this.JLB_CxNRegistro.setFont(new Font("Arial", 1, 18));
        this.JLB_CxNRegistro.setHorizontalAlignment(0);
        this.JLB_CxNRegistro.setBorder(BorderFactory.createTitledBorder((Border) null, "Nº Registro", 2, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JSP_CxAgenda.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTA_Cxgenda.setFont(new Font("Arial", 1, 12));
        this.JTA_Cxgenda.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTA_Cxgenda.setRowHeight(25);
        this.JTA_Cxgenda.setSelectionBackground(new Color(255, 255, 255));
        this.JTA_Cxgenda.setSelectionForeground(new Color(255, 0, 0));
        this.JTA_Cxgenda.addMouseListener(new MouseAdapter() { // from class: Historia.JIFAgendaMedico_N.23
            public void mouseClicked(MouseEvent evt) {
                JIFAgendaMedico_N.this.JTA_CxgendaMouseClicked(evt);
            }
        });
        this.JSP_CxAgenda.setViewportView(this.JTA_Cxgenda);
        this.JDCFechaAgendaCX.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaAgendaCX.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaAgendaCX.setFont(new Font("Arial", 1, 12));
        this.JDCFechaAgendaCX.addPropertyChangeListener(new PropertyChangeListener() { // from class: Historia.JIFAgendaMedico_N.24
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFAgendaMedico_N.this.JDCFechaAgendaCXPropertyChange(evt);
            }
        });
        GroupLayout JPI_CirugiaLayout = new GroupLayout(this.JPI_Cirugia);
        this.JPI_Cirugia.setLayout(JPI_CirugiaLayout);
        JPI_CirugiaLayout.setHorizontalGroup(JPI_CirugiaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPI_CirugiaLayout.createSequentialGroup().addContainerGap().addComponent(this.JDCFechaAgendaCX, -2, 143, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 141, 32767).addComponent(this.JPIFiltroNombre_Cx, -2, -1, -2).addGap(194, 194, 194)).addGroup(JPI_CirugiaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_CirugiaLayout.createSequentialGroup().addContainerGap().addGroup(JPI_CirugiaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSP_CxAgenda).addGroup(JPI_CirugiaLayout.createSequentialGroup().addGap(202, 967, 32767).addComponent(this.JLB_CxNRegistro, -2, 170, -2))).addContainerGap())));
        JPI_CirugiaLayout.setVerticalGroup(JPI_CirugiaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_CirugiaLayout.createSequentialGroup().addGap(23, 23, 23).addGroup(JPI_CirugiaLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JDCFechaAgendaCX, -2, 63, -2).addComponent(this.JPIFiltroNombre_Cx, -2, -1, -2)).addContainerGap(549, 32767)).addGroup(JPI_CirugiaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_CirugiaLayout.createSequentialGroup().addGap(16, 16, 16).addComponent(this.JLB_CxNRegistro, -2, 78, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JSP_CxAgenda, -2, 522, -2).addGap(16, 16, 16))));
        this.JTP_DatosAgenda.addTab("CIRUGÍA", this.JPI_Cirugia);
        this.JPIEstadoH.setBorder(BorderFactory.createTitledBorder((Border) null, "Estado", 0, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.JBGFiltro2.add(this.JRBEnAtencion_H);
        this.JRBEnAtencion_H.setFont(new Font("Arial", 1, 12));
        this.JRBEnAtencion_H.setForeground(Color.blue);
        this.JRBEnAtencion_H.setSelected(true);
        this.JRBEnAtencion_H.setText("En Atención");
        this.JRBEnAtencion_H.addActionListener(new ActionListener() { // from class: Historia.JIFAgendaMedico_N.25
            public void actionPerformed(ActionEvent evt) {
                JIFAgendaMedico_N.this.JRBEnAtencion_HActionPerformed(evt);
            }
        });
        this.JBGFiltro2.add(this.JRBDeAlta_H);
        this.JRBDeAlta_H.setFont(new Font("Arial", 1, 12));
        this.JRBDeAlta_H.setForeground(Color.blue);
        this.JRBDeAlta_H.setText("De Alta");
        this.JRBDeAlta_H.addActionListener(new ActionListener() { // from class: Historia.JIFAgendaMedico_N.26
            public void actionPerformed(ActionEvent evt) {
                JIFAgendaMedico_N.this.JRBDeAlta_HActionPerformed(evt);
            }
        });
        GroupLayout JPIEstadoHLayout = new GroupLayout(this.JPIEstadoH);
        this.JPIEstadoH.setLayout(JPIEstadoHLayout);
        JPIEstadoHLayout.setHorizontalGroup(JPIEstadoHLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIEstadoHLayout.createSequentialGroup().addContainerGap().addGroup(JPIEstadoHLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JRBEnAtencion_H).addComponent(this.JRBDeAlta_H)).addContainerGap(14, 32767)));
        JPIEstadoHLayout.setVerticalGroup(JPIEstadoHLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIEstadoHLayout.createSequentialGroup().addComponent(this.JRBEnAtencion_H).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBDeAlta_H).addContainerGap(-1, 32767)));
        this.JLBNRegistro_H.setBackground(new Color(255, 255, 255));
        this.JLBNRegistro_H.setFont(new Font("Arial", 1, 18));
        this.JLBNRegistro_H.setHorizontalAlignment(0);
        this.JLBNRegistro_H.setBorder(BorderFactory.createTitledBorder((Border) null, "Nº Registro", 2, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JSPAgenda_H.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTAgendaH.setFont(new Font("Arial", 1, 12));
        this.JTAgendaH.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTAgendaH.setRowHeight(39);
        this.JTAgendaH.setSelectionBackground(new Color(255, 255, 255));
        this.JTAgendaH.setSelectionForeground(new Color(255, 0, 0));
        this.JTAgendaH.addMouseListener(new MouseAdapter() { // from class: Historia.JIFAgendaMedico_N.27
            public void mouseClicked(MouseEvent evt) {
                JIFAgendaMedico_N.this.JTAgendaHMouseClicked(evt);
            }
        });
        this.JSPAgenda_H.setViewportView(this.JTAgendaH);
        this.JPIFiltroNombre2.setBorder(BorderFactory.createTitledBorder((Border) null, "BÚSQUEDA FILTRADA POR NOMBRE", 0, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.JTFNombre_H.setFont(new Font("Arial", 1, 12));
        this.JCHFiltro_H.setFont(new Font("Arial", 1, 12));
        this.JCHFiltro_H.setText("Filtro");
        this.JBTActualizar_H.setFont(new Font("Arial", 1, 12));
        this.JBTActualizar_H.setIcon(new ImageIcon(getClass().getResource("/Imagenes/actualizar.png")));
        this.JBTActualizar_H.setText("Actualizar Agenda");
        this.JBTActualizar_H.addActionListener(new ActionListener() { // from class: Historia.JIFAgendaMedico_N.28
            public void actionPerformed(ActionEvent evt) {
                JIFAgendaMedico_N.this.JBTActualizar_HActionPerformed(evt);
            }
        });
        GroupLayout JPIFiltroNombre2Layout = new GroupLayout(this.JPIFiltroNombre2);
        this.JPIFiltroNombre2.setLayout(JPIFiltroNombre2Layout);
        JPIFiltroNombre2Layout.setHorizontalGroup(JPIFiltroNombre2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFiltroNombre2Layout.createSequentialGroup().addContainerGap().addComponent(this.JTFNombre_H, -2, 370, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHFiltro_H).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTActualizar_H, -1, 170, 32767).addContainerGap()));
        JPIFiltroNombre2Layout.setVerticalGroup(JPIFiltroNombre2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIFiltroNombre2Layout.createSequentialGroup().addGroup(JPIFiltroNombre2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPIFiltroNombre2Layout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.JCHFiltro_H)).addComponent(this.JTFNombre_H).addGroup(JPIFiltroNombre2Layout.createSequentialGroup().addComponent(this.JBTActualizar_H, -1, -1, 32767).addGap(1, 1, 1))).addContainerGap()));
        this.JDCFechaAgenda2.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaAgenda2.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaAgenda2.setFont(new Font("Arial", 1, 12));
        this.JDCFechaAgenda2.addPropertyChangeListener(new PropertyChangeListener() { // from class: Historia.JIFAgendaMedico_N.29
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFAgendaMedico_N.this.JDCFechaAgenda2PropertyChange(evt);
            }
        });
        this.JCH_FSalaParto.setFont(new Font("Arial", 1, 12));
        this.JCH_FSalaParto.setForeground(Color.red);
        this.JCH_FSalaParto.setText("Filtro S.Partos");
        this.JCH_FSalaParto.setToolTipText("Consultar usuarios en sala de partos");
        this.JCH_FSalaParto.addActionListener(new ActionListener() { // from class: Historia.JIFAgendaMedico_N.30
            public void actionPerformed(ActionEvent evt) {
                JIFAgendaMedico_N.this.JCH_FSalaPartoActionPerformed(evt);
            }
        });
        JBT_AtencionesPendientes2.setFont(new Font("Tahoma", 1, 12));
        JBT_AtencionesPendientes2.addActionListener(new ActionListener() { // from class: Historia.JIFAgendaMedico_N.31
            public void actionPerformed(ActionEvent evt) {
                JIFAgendaMedico_N.this.JBT_AtencionesPendientes2ActionPerformed(evt);
            }
        });
        GroupLayout JPI_AHospitalizacionLayout = new GroupLayout(this.JPI_AHospitalizacion);
        this.JPI_AHospitalizacion.setLayout(JPI_AHospitalizacionLayout);
        JPI_AHospitalizacionLayout.setHorizontalGroup(JPI_AHospitalizacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_AHospitalizacionLayout.createSequentialGroup().addGroup(JPI_AHospitalizacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_AHospitalizacionLayout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.JSPAgenda_H)).addGroup(JPI_AHospitalizacionLayout.createSequentialGroup().addGap(22, 22, 22).addGroup(JPI_AHospitalizacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JDCFechaAgenda2, -1, -1, 32767).addComponent(this.JCH_FSalaParto, -1, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JPIEstadoH, -2, -1, -2).addGap(18, 18, 18).addComponent(this.JPIFiltroNombre2, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JLBNRegistro_H, -2, 139, -2))).addGap(10, 10, 10)).addGroup(GroupLayout.Alignment.TRAILING, JPI_AHospitalizacionLayout.createSequentialGroup().addGap(0, 0, 32767).addComponent(JBT_AtencionesPendientes2, -2, 191, -2).addContainerGap()));
        JPI_AHospitalizacionLayout.setVerticalGroup(JPI_AHospitalizacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_AHospitalizacionLayout.createSequentialGroup().addGap(20, 20, 20).addGroup(JPI_AHospitalizacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIEstadoH, -2, -1, -2).addGroup(JPI_AHospitalizacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLBNRegistro_H, GroupLayout.Alignment.TRAILING, -2, 78, -2).addComponent(this.JPIFiltroNombre2, GroupLayout.Alignment.TRAILING, -2, -1, -2)).addGroup(JPI_AHospitalizacionLayout.createSequentialGroup().addComponent(this.JDCFechaAgenda2, -2, 50, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCH_FSalaParto))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPAgenda_H, -1, 448, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(JBT_AtencionesPendientes2, -2, 58, -2).addContainerGap()));
        this.JTP_DatosAgenda.addTab("HOSPITALIZACIÓN", this.JPI_AHospitalizacion);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTP_DatosAgenda, -2, 1170, -2).addContainerGap(-1, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTP_DatosAgenda, -2, 681, -2).addContainerGap(15, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBTodasActionPerformed(ActionEvent evt) {
        this.xidt = -1;
        this.xestado = -1;
        mCargarDatosA();
        mCargarDatosCNP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSinFactActionPerformed(ActionEvent evt) {
        this.xidt = 0;
        this.xestado = 0;
        this.xestadonp = 0;
        mCargarDatosA();
        mCargarDatosCNP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBPorAtenderActionPerformed(ActionEvent evt) {
        this.xidt = 0;
        this.xestado = 1;
        this.xestadonp = 2;
        mCargarDatosA();
        mCargarDatosCNP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBAtendidasActionPerformed(ActionEvent evt) {
        this.xidt = 0;
        this.xestado = 3;
        this.xestadonp = 3;
        mCargarDatosA();
        mCargarDatosCNP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTAgendaPMouseClicked(MouseEvent evt) {
        if (this.JTAgendaP.getSelectedRow() != -1 && this.JTAgendaP.getSelectedColumn() != 31) {
            if (this.JTAgendaP.getSelectedColumn() == 30) {
                if (!this.JTAgendaP.getValueAt(this.JTAgendaP.getSelectedRow(), 30).toString().isEmpty()) {
                    this.xmt.abrirEnlaceWeb(this.JTAgendaP.getValueAt(this.JTAgendaP.getSelectedRow(), 30).toString());
                    return;
                }
                return;
            }
            this.claseHilo.xvalor = false;
            this.hilo.stop();
            this.xpos = this.JTAgendaP.getSelectedRow();
            this.JTAgendaP.setCursor(new Cursor(3));
            ConsultasMySQL xmt1 = new ConsultasMySQL();
            if (this.xmodelo.getValueAt(this.xpos, 11).toString().equals("0")) {
                if (Principal.informacionGeneralPrincipalDTO.getIdEspecialidad().equals("1")) {
                    mCargarDatosClaseCitasProgramadas();
                } else {
                    JOptionPane.showInternalMessageDialog(this, "Usuario sin facturar ", "VERIFICAR ESTADO", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                }
            } else if (this.xmodelo.getValueAt(this.xpos, 11).toString().equals("1")) {
                if (this.xtipo == 0) {
                    if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO CAMU DEL PRADO")) {
                        if (Integer.valueOf(this.xmodelo.getValueAt(this.xpos, 26).toString()).intValue() != 0) {
                            mCargarDatosClaseCitasProgramadas();
                        } else {
                            JOptionPane.showInternalMessageDialog(this, "No se ha generado un numero de atencion", "VERIFICACION", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        }
                    } else if (Integer.valueOf(this.xmodelo.getValueAt(this.xpos, 26).toString()).intValue() != 0) {
                        mCargarDatosClaseCitasProgramadas();
                    } else {
                        String sql = "INSERT INTO h_atencion (Id_Ingreso, Id_ClaseCita, Fecha_Atencion, Hora_Atencion, Motivo_Atencion, Codigo_Dxp, Id_TipoDx, Codigo_DxR1, Codigo_DxR2, Codigo_DxR3, Conclusion, Id_Profesional, Id_Especialidad, Fecha, UsuarioS) VALUES ('" + Long.valueOf(this.xmodelo.getValueAt(this.xpos, 8).toString()) + "','" + Long.valueOf(this.xmodelo.getValueAt(this.xpos, 14).toString()) + "','" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "','" + this.xmt.formatoH24.format(this.xmt.getFechaActual()) + "','','','1','','','','','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "','" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "','" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                        String idAtencion = this.xct.ejecutarSQLId(sql);
                        this.xmodelo.setValueAt(idAtencion, this.xpos, 26);
                        String sql2 = "update ingreso set Id_Atencion='" + idAtencion + "' where id='" + Long.valueOf(this.xmodelo.getValueAt(this.xpos, 8).toString()) + "'";
                        this.xct.ejecutarSQL(sql2);
                        this.xct.cerrarConexionBd();
                        mCargarDatosClaseCitasProgramadas();
                    }
                }
            } else if (this.xtipo == 0) {
                if (this.xmodelo.getValueAt(this.xpos, 11).toString().equals("2")) {
                    int n = JOptionPane.showInternalConfirmDialog(this, "Usuario en estado de atención \n Desea modificar el estado?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    if (n == 0) {
                        String xsql = "update c_citas set Asistida=1 where Id='" + Integer.valueOf(this.xmodelo.getValueAt(this.xpos, 12).toString()) + "'";
                        xmt1.ejecutarSQL(xsql);
                        xmt1.cerrarConexionBd();
                        mCargarDatosClaseCitasProgramadas();
                    }
                } else {
                    Object[] botones = {"Cargar HC", "Cerrar"};
                    int n2 = JOptionPane.showInternalOptionDialog(this, "Usuario ya Atendido \n\t Desea cargar la HC", "VERIFICAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones, "Cerrar");
                    if (n2 == 0) {
                        this.xsql = "UPDATE ll_datos_basicos set Estado=2 WHERE Documento='" + this.JTAgendaP.getValueAt(this.JTAgendaP.getSelectedRow(), 0) + "' AND Consultorio ='" + Principal.consultorio + "'";
                        System.out.println(this.xsql);
                        if (this.estado_ == 1) {
                            this.xct.ejecutarSQL(this.xsql);
                            this.xct.cerrarConexionBd();
                            this.estado_ = 2;
                            System.out.println("el estado es de: " + this.estado_);
                        } else {
                            JOptionPane.showInternalMessageDialog(this, "Este paciente todavia no se ha atendido, llamalo antes de retirarlo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        }
                        mCargarDatosClaseCitasProgramadas();
                    }
                    this.xsql = "UPDATE ll_datos_basicos set Estado=2 WHERE Documento='" + this.JTAgendaNP.getValueAt(this.JTAgendaNP.getSelectedRow(), 0) + "' AND Consultorio ='" + Principal.consultorio + "'";
                    System.out.println(this.xsql);
                    if (this.estado_ == 1) {
                        this.xct.ejecutarSQL(this.xsql);
                        this.xct.cerrarConexionBd();
                        this.estado_ = 2;
                        System.out.println("el estado es de: " + this.estado_);
                    } else {
                        JOptionPane.showInternalMessageDialog(this, "Este paciente todavia no se ha atendido, llamalo antes de retirarlo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    }
                }
            }
            this.JTAgendaP.setCursor(new Cursor(0));
            return;
        }
        LlamadasEntity seguimientos = new LlamadasEntity();
        if (this.JTAgendaP.getSelectedColumn() == 31) {
            int x = JOptionPane.showConfirmDialog(this, "Esta seguro de  llamar al paciente " + this.JTAgendaP.getValueAt(this.JTAgendaP.getSelectedRow(), 1) + " en el consultorio " + Principal.consultorio + "?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                seguimientos.setDocumento(this.xmodelo.getValueAt(this.JTAgendaP.getSelectedRow(), 0).toString());
                seguimientos.setNombre(this.xmodelo.getValueAt(this.JTAgendaP.getSelectedRow(), 1).toString());
                seguimientos.setProfesional(Principal.usuarioSistemaDTO.getNombreUsuario());
                seguimientos.setConsultorio(Principal.consultorio);
                seguimientos.setEstado(1);
                seguimientos.setUbicacion(Principal.ubicacion);
                seguimientos.setFecha_R(this.xmt.formadFecha(this.xmt.formatoAMDH24_1.format(this.xmt.getFechaActual())));
                System.out.println(Principal.ubicacion);
                if (this.num < 3) {
                    new ArrayList();
                    List<LlamadasEntity> list = this.llamadasService.ListarPacientes((String) this.JTAgendaP.getValueAt(this.JTAgendaP.getSelectedRow(), 0), Principal.consultorio);
                    if (list.isEmpty()) {
                        seguimientos.setOriginal(1);
                    } else {
                        seguimientos.setOriginal((Integer) null);
                    }
                    primerPaciente();
                    System.out.println("si actualizo");
                    this.llamadasService.Grabar(seguimientos);
                    this.estado_ = 1;
                    System.out.println("el estado es de: " + this.estado_);
                    System.out.println("si grabo");
                    this.num = list.size();
                    return;
                }
                int x1 = JOptionPane.showConfirmDialog(this, "se excedio el numero de llamados, quieres volver a llamar a este paciente?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                if (x1 == 0) {
                    this.num = 0;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDCFechaAgendaPropertyChange(PropertyChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTAgendaNPMouseClicked(MouseEvent evt) {
        if (this.JTAgendaNP.getSelectedRow() != -1 && this.JTAgendaNP.getSelectedColumn() != 34) {
            if (this.JTAgendaNP.getSelectedColumn() == 33) {
                if (!this.JTAgendaNP.getValueAt(this.JTAgendaNP.getSelectedRow(), 33).toString().isEmpty()) {
                    this.xmt.abrirEnlaceWeb(this.JTAgendaNP.getValueAt(this.JTAgendaNP.getSelectedRow(), 33).toString());
                    return;
                }
                return;
            }
            this.JTAgendaNP.setCursor(new Cursor(3));
            this.claseHilo.xvalor = false;
            this.hilo.stop();
            this.xposnp = this.JTAgendaNP.rowAtPoint(evt.getPoint());
            new ConsultasMySQL();
            if (this.xmodelo1.getValueAt(this.xposnp, 10).toString().equals("0") || this.xmodelo1.getValueAt(this.xposnp, 10).toString().equals("1")) {
                mCargarDatosClaseCitasNoProgramadas();
                this.xclaseHC.mCambiarEstadoCitaNP();
                return;
            }
            if (this.xmodelo1.getValueAt(this.xposnp, 10).toString().equals("2")) {
                if (JOptionPane.showInternalConfirmDialog(this, "Usuario en estado de atención \n Desea modificar el estado?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png")))) == 0) {
                    mCargarDatosClaseCitasNoProgramadas();
                    return;
                }
                return;
            }
            Object[] botones = {"Cargar HC", "Triage", "Cerrar"};
            int n = JOptionPane.showInternalOptionDialog(this, "Usuario ya Atendido \n\t Desea cargar la HC", "VERIFICAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones, "Cerrar");
            if (n == 0) {
                this.xsql = "UPDATE ll_datos_basicos set Estado=2 WHERE Documento='" + this.JTAgendaNP.getValueAt(this.JTAgendaNP.getSelectedRow(), 0) + "' AND Consultorio ='" + Principal.consultorio + "'";
                System.out.println(this.xsql);
                if (this.estado_ == 1) {
                    this.xct.ejecutarSQL(this.xsql);
                    this.xct.cerrarConexionBd();
                    this.estado_ = 2;
                    System.out.println("el estado es de: " + this.estado_);
                } else {
                    JOptionPane.showInternalMessageDialog(this, "Este paciente todavia no se ha atendido", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                }
                mCargarDatosClaseCitasNoProgramadas();
                return;
            }
            if (n == 1) {
                this.xsql = "UPDATE ll_datos_basicos set Estado=2 WHERE Documento='" + this.JTAgendaNP.getValueAt(this.JTAgendaNP.getSelectedRow(), 0) + "' AND Consultorio ='" + Principal.consultorio + "'";
                System.out.println(this.xsql);
                if (this.estado_ == 1) {
                    this.xct.ejecutarSQL(this.xsql);
                    this.xct.cerrarConexionBd();
                    this.estado_ = 2;
                    System.out.println("el estado es de: " + this.estado_);
                } else {
                    JOptionPane.showInternalMessageDialog(this, "Este paciente todavia no se ha atendido", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                }
                String[][] parametros = new String[4][2];
                parametros[0][0] = "idt";
                parametros[0][1] = this.xmodelo1.getValueAt(this.xposnp, 19).toString();
                parametros[1][0] = "ruta";
                parametros[1][1] = this.xmt.getRutaRep();
                parametros[2][0] = "SUBREPORT_DIR";
                parametros[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
                parametros[3][0] = "SUBREPORTFIRMA_DIR";
                parametros[3][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
                this.xmt.GenerarPDF(this.xmt.getRutaRep() + "RTriage", parametros);
                return;
            }
            return;
        }
        LlamadasEntity seguimientos = new LlamadasEntity();
        if (this.JTAgendaNP.getSelectedColumn() == 34) {
            int x = JOptionPane.showConfirmDialog(this, "Esta seguro de  llamar al paciente " + this.JTAgendaNP.getValueAt(this.JTAgendaNP.getSelectedRow(), 1) + " en el consultorio " + Principal.consultorio + "?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                seguimientos.setDocumento(this.xmodelo1.getValueAt(this.JTAgendaNP.getSelectedRow(), 0).toString());
                seguimientos.setNombre(this.xmodelo1.getValueAt(this.JTAgendaNP.getSelectedRow(), 1).toString());
                seguimientos.setProfesional(this.xmodelo1.getValueAt(this.JTAgendaNP.getSelectedRow(), 24).toString());
                seguimientos.setConsultorio(Principal.consultorio);
                seguimientos.setEstado(1);
                seguimientos.setUbicacion(Principal.ubicacion);
                seguimientos.setFecha_R(this.xmt.formadFecha(this.xmt.formatoAMDH24_1.format(this.xmt.getFechaActual())));
                System.out.println(Principal.ubicacion);
                if (this.num < 3) {
                    new ArrayList();
                    List<LlamadasEntity> list = this.llamadasService.ListarPacientes((String) this.JTAgendaNP.getValueAt(this.JTAgendaNP.getSelectedRow(), 0), Principal.consultorio);
                    if (list.isEmpty()) {
                        seguimientos.setOriginal(1);
                    } else {
                        seguimientos.setOriginal((Integer) null);
                    }
                    primerPaciente2();
                    System.out.println("si actualizo");
                    this.llamadasService.Grabar(seguimientos);
                    this.estado_ = 1;
                    System.out.println("el estado es de: " + this.estado_);
                    System.out.println("si grabo");
                    this.num = list.size();
                    return;
                }
                int x1 = JOptionPane.showConfirmDialog(this, "se excedio el numero de llamados, quieres volver a llamar a este paciente?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                if (x1 == 0) {
                    this.num = 0;
                }
            }
        }
    }

    private void primerPaciente() {
        try {
            this.xsql = "UPDATE ll_datos_basicos set Estado=1 WHERE Documento='" + this.JTAgendaP.getValueAt(this.JTAgendaP.getSelectedRow(), 0) + "' AND Consultorio ='" + Principal.consultorio + "'";
            this.xct.ejecutarSQL(this.xsql);
        } catch (Exception ex) {
            Logger.getLogger(JIFPlanillaTrabajo.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void primerPaciente2() {
        try {
            this.xsql = "UPDATE ll_datos_basicos set Estado=1 WHERE Documento='" + this.JTAgendaNP.getValueAt(this.JTAgendaNP.getSelectedRow(), 0) + "' AND Consultorio ='" + Principal.consultorio + "'";
            this.xct.ejecutarSQL(this.xsql);
        } catch (Exception ex) {
            Logger.getLogger(JIFPlanillaTrabajo.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_AtencionesPendientesActionPerformed(ActionEvent evt) {
        this.xclaseHC.cargarPantalla("Consultar Atenciones Especiales", this.xclaseHC.frmPrincipal);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTActualizarActionPerformed(ActionEvent evt) {
        if (this.JCHFiltro.isSelected() && !this.JTF.getText().isEmpty()) {
            mCargarDatosCNP();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTCCirugiasPActionPerformed(ActionEvent evt) {
        this.xclaseHC.cargarPantalla("Consultar Cirugias Programadas", this.xclaseHC.frmPrincipal);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHFiltro1ActionPerformed(ActionEvent evt) {
        this.xidt = 0;
        this.xestado = 1;
        this.xestadonp = 2;
        mCargarDatosA();
        mCargarDatosCNP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHFiltro_ProfesionalActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTAgendaUMouseClicked(MouseEvent evt) {
        if (this.JTAgendaU.getSelectedRow() != -1 && this.xtipo != 1) {
            try {
                this.claseHilo.xvalor = false;
                this.hilo.stop();
                this.xpos = this.JTAgendaU.getSelectedRow();
                this.JTAgendaU.setCursor(new Cursor(3));
                clasesHistoriaCE.informacionAgendaMedicaDTO.setFechaIngreso(this.xmt.invertirFecha(this.xmodelo_urgencias.getValueAt(this.JTAgendaU.getSelectedRow(), 1).toString()).replace("/", "-"));
                clasesHistoriaCE.informacionAgendaMedicaDTO.setNumeroHistoria(this.xmodelo_urgencias.getValueAt(this.JTAgendaU.getSelectedRow(), 3).toString());
                clasesHistoriaCE.informacionAgendaMedicaDTO.setNombreUsuario(this.xmodelo_urgencias.getValueAt(this.JTAgendaU.getSelectedRow(), 4).toString());
                clasesHistoriaCE.informacionAgendaMedicaDTO.setEdad(this.xmodelo_urgencias.getValueAt(this.JTAgendaU.getSelectedRow(), 6).toString());
                clasesHistoriaCE.informacionAgendaMedicaDTO.setNombreSexo(this.xmodelo_urgencias.getValueAt(this.JTAgendaU.getSelectedRow(), 5).toString());
                clasesHistoriaCE.informacionAgendaMedicaDTO.setIdSexo(this.xmodelo_urgencias.getValueAt(this.JTAgendaU.getSelectedRow(), 5).toString());
                clasesHistoriaCE.informacionAgendaMedicaDTO.setNombreTipoConsulta("");
                clasesHistoriaCE.informacionAgendaMedicaDTO.setIdUsuarioAtendido(Long.valueOf(this.xmodelo_urgencias.getValueAt(this.JTAgendaU.getSelectedRow(), 12).toString()));
                clasesHistoriaCE.informacionAgendaMedicaDTO.setIdIngreso(Long.valueOf(this.xmodelo_urgencias.getValueAt(this.JTAgendaU.getSelectedRow(), 0).toString()));
                clasesHistoriaCE.informacionAgendaMedicaDTO.setIdClaseCita(0);
                clasesHistoriaCE.informacionAgendaMedicaDTO.setIdTipohc(Integer.valueOf(this.xmodelo_urgencias.getValueAt(this.JTAgendaU.getSelectedRow(), 13).toString()));
                clasesHistoriaCE.informacionAgendaMedicaDTO.setIdCita(Long.valueOf(this.xmodelo_urgencias.getValueAt(this.JTAgendaU.getSelectedRow(), 17).toString()));
                clasesHistoriaCE.informacionAgendaMedicaDTO.setEsTriage(Integer.valueOf(this.xmodelo_urgencias.getValueAt(this.JTAgendaU.getSelectedRow(), 22).toString()));
                clasesHistoriaCE.informacionAgendaMedicaDTO.setEsRemitada(0);
                clasesHistoriaCE.informacionAgendaMedicaDTO.setIdClaseCita(0);
                clasesHistoriaCE.informacionAgendaMedicaDTO.setIdTratamiento(0L);
                clasesHistoriaCE.informacionAgendaMedicaDTO.setEsSaludOcupacional(0);
                clasesHistoriaCE.informacionAgendaMedicaDTO.setIdTratamiento(0L);
                clasesHistoriaCE.informacionAgendaMedicaDTO.setIdCargo(0L);
                clasesHistoriaCE.informacionAgendaMedicaDTO.setIdManPower(0);
                clasesHistoriaCE.informacionAgendaMedicaDTO.setEsPeriodico(0);
                clasesHistoriaCE.informacionAgendaMedicaDTO.setEsOdontologica(0);
                clasesHistoriaCE.informacionAgendaMedicaDTO.setEsAtencionEspecial(0);
                clasesHistoriaCE.informacionAgendaMedicaDTO.setNombreEmpresaCovenio(this.xmodelo_urgencias.getValueAt(this.JTAgendaU.getSelectedRow(), 7).toString());
                clasesHistoriaCE.informacionAgendaMedicaDTO.setFecha_HoraAtencion(this.xmodelo_urgencias.getValueAt(this.JTAgendaU.getSelectedRow(), 1).toString() + " " + this.xmodelo_urgencias.getValueAt(this.JTAgendaU.getSelectedRow(), 2).toString());
                clasesHistoriaCE.informacionAgendaMedicaDTO.setTipoCita(1);
                clasesHistoriaCE.informacionAgendaMedicaDTO.setIdPrograma(Integer.valueOf(this.xmodelo_urgencias.getValueAt(this.JTAgendaU.getSelectedRow(), 23).toString()));
                clasesHistoriaCE.informacionAgendaMedicaDTO.setIdTipoAtencion(Integer.valueOf(this.xmodelo_urgencias.getValueAt(this.JTAgendaU.getSelectedRow(), 15).toString()));
                clasesHistoriaCE.informacionAgendaMedicaDTO.setFormaHistoria(0);
                clasesHistoriaCE.informacionAgendaMedicaDTO.setTipoGuardado(Integer.valueOf(this.xmodelo_urgencias.getValueAt(this.JTAgendaU.getSelectedRow(), 18).toString()));
                clasesHistoriaCE.informacionAgendaMedicaDTO.setIdModalidad(Integer.valueOf(this.xmodelo_urgencias.getValueAt(this.JTAgendaU.getSelectedRow(), 24).toString()));
                clasesHistoriaCE.informacionAgendaMedicaDTO.setIdEntornoAtencion(Integer.valueOf(this.xmodelo_urgencias.getValueAt(this.JTAgendaU.getSelectedRow(), 25).toString()));
                clasesHistoriaCE.informacionAgendaMedicaDTO.setIdTipoDiscapacidad(Integer.valueOf(this.xmodelo_urgencias.getValueAt(this.JTAgendaU.getSelectedRow(), 26).toString()));
                Principal.clasehistoriace.mBuscarAtencionIngreso();
                Principal.clasehistoriace.mCambiarEstadoCitaNP();
                if (!Principal.informacionIps.getIdentificacion().equals("812005644")) {
                    Principal.clasehistoriace.mCambiarEstadoHc(2);
                }
                Principal.clasehistoriace.mActualizarFechaHoraIniciaAtencion();
                dispose();
                this.claseHilo.xvalor = false;
                this.claseHilo = null;
                this.xclaseHC.xjifagendan = null;
                finalize();
                this.xclaseHC.cargarPantalla("Historia", this.xclaseHC.frmPrincipal, "Historia_Med");
            } catch (Throwable ex) {
                Logger.getLogger(JIFAgendaMedico_N.class.getName()).log(Level.SEVERE, (String) null, ex);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBEnAtencion_UActionPerformed(ActionEvent evt) {
        this.xestado_atencion = 0;
        mCargarDatos_Urgencias1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBDeAlta_UActionPerformed(ActionEvent evt) {
        this.xestado_atencion = 1;
        mCargarDatos_Urgencias1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTActualizar1ActionPerformed(ActionEvent evt) {
        if (this.JCHFiltro_U.isSelected() && !this.JTFNombre_u.getText().isEmpty()) {
            mCargarDatos_Urgencias1();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBEnAtencion_HActionPerformed(ActionEvent evt) {
        this.xestado_atencion_h = 0;
        if (clasesHistoriaCE.informacionAgendaMedicaDTO.getFiltradoAgenda().intValue() == 5) {
            mCargarDatos_Hospitalizacion();
        } else {
            mCargarDatos_HospitalizacionSP();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBDeAlta_HActionPerformed(ActionEvent evt) {
        this.xestado_atencion_h = 1;
        if (clasesHistoriaCE.informacionAgendaMedicaDTO.getFiltradoAgenda().intValue() == 5) {
            mCargarDatos_Hospitalizacion();
        } else {
            mCargarDatos_HospitalizacionSP();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTAgendaHMouseClicked(MouseEvent evt) {
        if (this.JTAgendaH.getSelectedRow() != -1) {
            try {
                this.claseHilo.xvalor = false;
                this.hilo.stop();
                this.xpos = this.JTAgendaH.getSelectedRow();
                this.JTAgendaH.setCursor(new Cursor(3));
                clasesHistoriaCE.informacionAgendaMedicaDTO.setFechaIngreso(this.xmt.invertirFecha(this.xmodelo_hospitalizacion.getValueAt(this.JTAgendaH.getSelectedRow(), 1).toString()).replace("/", "-"));
                clasesHistoriaCE.informacionAgendaMedicaDTO.setNumeroHistoria(this.xmodelo_hospitalizacion.getValueAt(this.JTAgendaH.getSelectedRow(), 3).toString());
                clasesHistoriaCE.informacionAgendaMedicaDTO.setNombreUsuario(this.xmodelo_hospitalizacion.getValueAt(this.JTAgendaH.getSelectedRow(), 4).toString());
                clasesHistoriaCE.informacionAgendaMedicaDTO.setEdad(this.xmodelo_hospitalizacion.getValueAt(this.JTAgendaH.getSelectedRow(), 6).toString());
                clasesHistoriaCE.informacionAgendaMedicaDTO.setNombreSexo(this.xmodelo_hospitalizacion.getValueAt(this.JTAgendaH.getSelectedRow(), 5).toString());
                clasesHistoriaCE.informacionAgendaMedicaDTO.setIdSexo(this.xmodelo_hospitalizacion.getValueAt(this.JTAgendaH.getSelectedRow(), 5).toString());
                clasesHistoriaCE.informacionAgendaMedicaDTO.setNombreTipoConsulta("");
                clasesHistoriaCE.informacionAgendaMedicaDTO.setIdUsuarioAtendido(Long.valueOf(this.xmodelo_hospitalizacion.getValueAt(this.JTAgendaH.getSelectedRow(), 12).toString()));
                clasesHistoriaCE.informacionAgendaMedicaDTO.setIdIngreso(Long.valueOf(this.xmodelo_hospitalizacion.getValueAt(this.JTAgendaH.getSelectedRow(), 0).toString()));
                clasesHistoriaCE.informacionAgendaMedicaDTO.setIdClaseCita(0);
                clasesHistoriaCE.informacionAgendaMedicaDTO.setIdTipohc(Integer.valueOf(this.xmodelo_hospitalizacion.getValueAt(this.JTAgendaH.getSelectedRow(), 13).toString()));
                clasesHistoriaCE.informacionAgendaMedicaDTO.setEsRemitada(0);
                clasesHistoriaCE.informacionAgendaMedicaDTO.setIdClaseCita(0);
                clasesHistoriaCE.informacionAgendaMedicaDTO.setIdTratamiento(0L);
                clasesHistoriaCE.informacionAgendaMedicaDTO.setEsSaludOcupacional(0);
                clasesHistoriaCE.informacionAgendaMedicaDTO.setIdTratamiento(0L);
                clasesHistoriaCE.informacionAgendaMedicaDTO.setIdCargo(0L);
                clasesHistoriaCE.informacionAgendaMedicaDTO.setIdManPower(0);
                clasesHistoriaCE.informacionAgendaMedicaDTO.setEsPeriodico(0);
                clasesHistoriaCE.informacionAgendaMedicaDTO.setEsOdontologica(0);
                clasesHistoriaCE.informacionAgendaMedicaDTO.setNombreEmpresaCovenio(this.xmodelo_hospitalizacion.getValueAt(this.JTAgendaH.getSelectedRow(), 7).toString());
                clasesHistoriaCE.informacionAgendaMedicaDTO.setTipoCita(1);
                clasesHistoriaCE.informacionAgendaMedicaDTO.setIdPrograma(Integer.valueOf(this.xmodelo_hospitalizacion.getValueAt(this.JTAgendaH.getSelectedRow(), 18).toString()));
                clasesHistoriaCE.informacionAgendaMedicaDTO.setTipoGuardado(Integer.valueOf(this.xmodelo_hospitalizacion.getValueAt(this.JTAgendaH.getSelectedRow(), 19).toString()));
                clasesHistoriaCE.informacionAgendaMedicaDTO.setIdModalidad(Integer.valueOf(this.xmodelo_hospitalizacion.getValueAt(this.JTAgendaH.getSelectedRow(), 20).toString()));
                clasesHistoriaCE.informacionAgendaMedicaDTO.setIdEntornoAtencion(Integer.valueOf(this.xmodelo_hospitalizacion.getValueAt(this.JTAgendaH.getSelectedRow(), 21).toString()));
                clasesHistoriaCE.informacionAgendaMedicaDTO.setIdTipoDiscapacidad(Integer.valueOf(this.xmodelo_hospitalizacion.getValueAt(this.JTAgendaH.getSelectedRow(), 22).toString()));
                clasesHistoriaCE.informacionAgendaMedicaDTO.setIdTipoAtencion(2);
                clasesHistoriaCE.informacionAgendaMedicaDTO.setFormaHistoria(0);
                Principal.clasehistoriace.mBuscarAtencionIngreso();
                Principal.clasehistoriace.mActualizarFechaHoraIniciaAtencion();
                clasesHistoriaCE.informacionAgendaMedicaDTO.setFecha_HoraAtencion(this.xmodelo_hospitalizacion.getValueAt(this.JTAgendaH.getSelectedRow(), 0).toString() + " " + this.xmodelo_hospitalizacion.getValueAt(this.JTAgendaH.getSelectedRow(), 1).toString());
                dispose();
                this.claseHilo.xvalor = false;
                this.claseHilo = null;
                this.xclaseHC.xjifagendan = null;
                finalize();
                this.xclaseHC.cargarPantalla("Historia", this.xclaseHC.frmPrincipal, "Historia_Med");
            } catch (Throwable ex) {
                Logger.getLogger(JIFAgendaMedico_N.class.getName()).log(Level.SEVERE, (String) null, ex);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTActualizar_HActionPerformed(ActionEvent evt) {
        if (this.JCHFiltro_H.isSelected() && !this.JTFNombre_H.getText().isEmpty()) {
            mCargarDatos_Hospitalizacion();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDCFechaAgenda1PropertyChange(PropertyChangeEvent evt) {
        if (this.xlleno && this.xAUrgencias) {
            mCargarDatos_Urgencias1();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTActualizar_H1ActionPerformed(ActionEvent evt) {
        if (this.JCHFiltro_Cx.isSelected() && !this.JTFNombre_Cx.getText().isEmpty()) {
            mCargarDatos_Cx();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTA_CxgendaMouseClicked(MouseEvent evt) {
        if (this.JTA_Cxgenda.getSelectedRow() != -1 && !this.xmodelo_cx.getValueAt(this.JTA_Cxgenda.getSelectedRow(), 0).toString().equals("0")) {
            try {
                this.claseHilo.xvalor = false;
                this.hilo.stop();
                this.xpos = this.JTA_Cxgenda.getSelectedRow();
                this.JTA_Cxgenda.setCursor(new Cursor(3));
                clasesHistoriaCE.informacionAgendaMedicaDTO.setFechaIngreso(this.xmodelo_cx.getValueAt(this.JTA_Cxgenda.getSelectedRow(), 1).toString());
                clasesHistoriaCE.informacionAgendaMedicaDTO.setNumeroHistoria(this.xmodelo_cx.getValueAt(this.JTA_Cxgenda.getSelectedRow(), 3).toString());
                clasesHistoriaCE.informacionAgendaMedicaDTO.setNombreUsuario(this.xmodelo_cx.getValueAt(this.JTA_Cxgenda.getSelectedRow(), 4).toString());
                clasesHistoriaCE.informacionAgendaMedicaDTO.setEdad(this.xmodelo_cx.getValueAt(this.JTA_Cxgenda.getSelectedRow(), 6).toString());
                clasesHistoriaCE.informacionAgendaMedicaDTO.setNombreSexo(this.xmodelo_cx.getValueAt(this.JTA_Cxgenda.getSelectedRow(), 5).toString());
                clasesHistoriaCE.informacionAgendaMedicaDTO.setIdSexo(this.xmodelo_cx.getValueAt(this.JTA_Cxgenda.getSelectedRow(), 5).toString());
                clasesHistoriaCE.informacionAgendaMedicaDTO.setNombreTipoConsulta("");
                clasesHistoriaCE.informacionAgendaMedicaDTO.setIdUsuarioAtendido(Long.valueOf(this.xmodelo_cx.getValueAt(this.JTA_Cxgenda.getSelectedRow(), 11).toString()));
                clasesHistoriaCE.informacionAgendaMedicaDTO.setIdIngreso(Long.valueOf(this.xmodelo_cx.getValueAt(this.JTA_Cxgenda.getSelectedRow(), 0).toString()));
                clasesHistoriaCE.informacionAgendaMedicaDTO.setIdTipoCita(0L);
                clasesHistoriaCE.informacionAgendaMedicaDTO.setIdTipohc(Integer.valueOf(this.xmodelo_cx.getValueAt(this.JTA_Cxgenda.getSelectedRow(), 12).toString()));
                clasesHistoriaCE.informacionAgendaMedicaDTO.setEsRemitada(0);
                clasesHistoriaCE.informacionAgendaMedicaDTO.setIdClaseCita(0);
                clasesHistoriaCE.informacionAgendaMedicaDTO.setIdTratamiento(0L);
                clasesHistoriaCE.informacionAgendaMedicaDTO.setEsSaludOcupacional(0);
                clasesHistoriaCE.informacionAgendaMedicaDTO.setIdTratamiento(0L);
                clasesHistoriaCE.informacionAgendaMedicaDTO.setIdManPower(0);
                clasesHistoriaCE.informacionAgendaMedicaDTO.setEsPeriodico(0);
                clasesHistoriaCE.informacionAgendaMedicaDTO.setIdCargo(0L);
                clasesHistoriaCE.informacionAgendaMedicaDTO.setEsOdontologica(0);
                clasesHistoriaCE.informacionAgendaMedicaDTO.setIdTipoAtencion(4);
                clasesHistoriaCE.informacionAgendaMedicaDTO.setNombreEmpresaCovenio(this.xmodelo_cx.getValueAt(this.JTA_Cxgenda.getSelectedRow(), 7).toString());
                clasesHistoriaCE.informacionAgendaMedicaDTO.setTipoCita(1);
                clasesHistoriaCE.informacionAgendaMedicaDTO.setIdPrograma(0);
                clasesHistoriaCE.informacionAgendaMedicaDTO.setFormaHistoria(0);
                clasesHistoriaCE.informacionAgendaMedicaDTO.setTipoAtencion(Integer.valueOf(this.xmodelo_cx.getValueAt(this.JTA_Cxgenda.getSelectedRow(), 13).toString()));
                clasesHistoriaCE.informacionAgendaMedicaDTO.setIdModalidad(Integer.valueOf(this.xmodelo_cx.getValueAt(this.JTA_Cxgenda.getSelectedRow(), 14).toString()));
                clasesHistoriaCE.informacionAgendaMedicaDTO.setIdEntornoAtencion(Integer.valueOf(this.xmodelo_cx.getValueAt(this.JTA_Cxgenda.getSelectedRow(), 15).toString()));
                clasesHistoriaCE.informacionAgendaMedicaDTO.setIdTipoDiscapacidad(Integer.valueOf(this.xmodelo_cx.getValueAt(this.JTA_Cxgenda.getSelectedRow(), 16).toString()));
                Principal.clasehistoriace.mBuscarAtencionIngreso();
                Principal.clasehistoriace.mActualizarFechaHoraIniciaAtencion();
                dispose();
                this.claseHilo.xvalor = false;
                this.claseHilo = null;
                this.xclaseHC.xjifagendan = null;
                finalize();
                this.xclaseHC.cargarPantalla("Historia", this.xclaseHC.frmPrincipal, "Historia_Med");
            } catch (Throwable ex) {
                Logger.getLogger(JIFAgendaMedico_N.class.getName()).log(Level.SEVERE, (String) null, ex);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDCFechaAgendaCXPropertyChange(PropertyChangeEvent evt) {
        if (this.xlleno && this.xASParto) {
            mCargarDatos_Cx();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDCFechaAgenda2PropertyChange(PropertyChangeEvent evt) {
        if (this.xlleno && this.xAHospit) {
            mCargarDatos_Hospitalizacion();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_AtencionesPendientes1ActionPerformed(ActionEvent evt) {
        this.xclaseHC.cargarPantalla("Consultar Atenciones Especiales", this.xclaseHC.frmPrincipal);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_FSalaPartoActionPerformed(ActionEvent evt) {
        if (clasesHistoriaCE.informacionAgendaMedicaDTO.getFiltradoAgenda().intValue() == 5) {
            mCargarDatos_Hospitalizacion();
        } else {
            mCargarDatos_HospitalizacionSP();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHPExpuestosActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_AtencionesPendientes2ActionPerformed(ActionEvent evt) {
        this.xclaseHC.cargarPantalla("Consultar Atenciones Especiales", this.xclaseHC.frmPrincipal);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JSPAgendaMouseClicked(MouseEvent evt) {
    }

    private boolean mValidarHoraCitas(String xHora) {
        boolean xestado = false;
        try {
            this.xsql = "SELECT IF(TIMEDIFF(TIME(NOW()),SUBTIME('" + xHora + "', '00:59:00')) >='00:00:00', 1, 0) Dif";
            ResultSet xrs = this.xct.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.first();
                xestado = xrs.getBoolean("Dif");
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFAgendaMedico_N.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return xestado;
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTablaAgenda() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"N° HC", "Usuario", "Edad", "Sexo", "Tipo Consulta", "Hora", "HoraF", "Id_Usuario", "Id_Ingreso", "Idclasecita", "Idhistoria", "asistida", "idcita", "Estado", "Idtipocita", "Id_Remitida", "Id_Programa", "EsSO", "EsCOntrol", "Es_Odontologia", "Id_TRatamiento", "Empresa", "N°", "EsP", "Tipo", "CEspecial", "IdAtencion", "idformaHistoria", "fechaNacimiento", "fechaAtencion", "Url_videollamada", "Accion Llamar", "idModalidad", "idEntornoAtencion", "idTipoDiscapacidad"}) { // from class: Historia.JIFAgendaMedico_N.32
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, Long.class, Long.class, Long.class, Long.class, Long.class, Long.class, String.class, Long.class, Long.class, Long.class, Integer.class, Integer.class, Integer.class, Long.class, String.class, Integer.class, Integer.class, Integer.class, JLabel.class, Long.class, Integer.class, String.class, String.class, String.class, JButton.class, Integer.class, Integer.class, Integer.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTAgendaP.setDefaultRenderer(JButton.class, new TableCellRenderer() { // from class: Historia.JIFAgendaMedico_N.33
            public Component getTableCellRendererComponent(JTable jtable, Object objeto, boolean estaSeleccionado, boolean tieneElFoco, int fila, int columna) {
                return (Component) objeto;
            }
        });
        this.JTAgendaP.setModel(this.xmodelo);
        this.JTAgendaP.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTAgendaP.getColumnModel().getColumn(1).setPreferredWidth(150);
        this.JTAgendaP.getColumnModel().getColumn(2).setPreferredWidth(10);
        this.JTAgendaP.getColumnModel().getColumn(3).setPreferredWidth(10);
        this.JTAgendaP.getColumnModel().getColumn(4).setPreferredWidth(80);
        this.JTAgendaP.getColumnModel().getColumn(5).setPreferredWidth(10);
        this.JTAgendaP.getColumnModel().getColumn(6).setPreferredWidth(0);
        this.JTAgendaP.getColumnModel().getColumn(6).setMinWidth(0);
        this.JTAgendaP.getColumnModel().getColumn(6).setMaxWidth(0);
        this.JTAgendaP.getColumnModel().getColumn(7).setPreferredWidth(0);
        this.JTAgendaP.getColumnModel().getColumn(7).setMinWidth(0);
        this.JTAgendaP.getColumnModel().getColumn(7).setMaxWidth(0);
        this.JTAgendaP.getColumnModel().getColumn(8).setPreferredWidth(0);
        this.JTAgendaP.getColumnModel().getColumn(8).setMinWidth(0);
        this.JTAgendaP.getColumnModel().getColumn(8).setMaxWidth(0);
        this.JTAgendaP.getColumnModel().getColumn(9).setPreferredWidth(0);
        this.JTAgendaP.getColumnModel().getColumn(9).setMinWidth(0);
        this.JTAgendaP.getColumnModel().getColumn(9).setMaxWidth(0);
        this.JTAgendaP.getColumnModel().getColumn(10).setPreferredWidth(0);
        this.JTAgendaP.getColumnModel().getColumn(10).setMinWidth(0);
        this.JTAgendaP.getColumnModel().getColumn(10).setMaxWidth(0);
        this.JTAgendaP.getColumnModel().getColumn(11).setPreferredWidth(0);
        this.JTAgendaP.getColumnModel().getColumn(11).setMinWidth(0);
        this.JTAgendaP.getColumnModel().getColumn(11).setMaxWidth(0);
        this.JTAgendaP.getColumnModel().getColumn(12).setPreferredWidth(0);
        this.JTAgendaP.getColumnModel().getColumn(12).setMinWidth(0);
        this.JTAgendaP.getColumnModel().getColumn(12).setMaxWidth(0);
        this.JTAgendaP.getColumnModel().getColumn(13).setPreferredWidth(15);
        this.JTAgendaP.getColumnModel().getColumn(14).setPreferredWidth(0);
        this.JTAgendaP.getColumnModel().getColumn(14).setMinWidth(0);
        this.JTAgendaP.getColumnModel().getColumn(14).setMaxWidth(0);
        this.JTAgendaP.getColumnModel().getColumn(15).setPreferredWidth(0);
        this.JTAgendaP.getColumnModel().getColumn(15).setMinWidth(0);
        this.JTAgendaP.getColumnModel().getColumn(15).setMaxWidth(0);
        this.JTAgendaP.getColumnModel().getColumn(16).setPreferredWidth(0);
        this.JTAgendaP.getColumnModel().getColumn(16).setMinWidth(0);
        this.JTAgendaP.getColumnModel().getColumn(16).setMaxWidth(0);
        this.JTAgendaP.getColumnModel().getColumn(17).setPreferredWidth(0);
        this.JTAgendaP.getColumnModel().getColumn(17).setMinWidth(0);
        this.JTAgendaP.getColumnModel().getColumn(17).setMaxWidth(0);
        this.JTAgendaP.getColumnModel().getColumn(18).setPreferredWidth(0);
        this.JTAgendaP.getColumnModel().getColumn(18).setMinWidth(0);
        this.JTAgendaP.getColumnModel().getColumn(18).setMaxWidth(0);
        this.JTAgendaP.getColumnModel().getColumn(19).setPreferredWidth(0);
        this.JTAgendaP.getColumnModel().getColumn(19).setMinWidth(0);
        this.JTAgendaP.getColumnModel().getColumn(19).setMaxWidth(0);
        this.JTAgendaP.getColumnModel().getColumn(20).setPreferredWidth(0);
        this.JTAgendaP.getColumnModel().getColumn(20).setMinWidth(0);
        this.JTAgendaP.getColumnModel().getColumn(20).setMaxWidth(0);
        this.JTAgendaP.getColumnModel().getColumn(21).setPreferredWidth(100);
        this.JTAgendaP.getColumnModel().getColumn(22).setPreferredWidth(0);
        this.JTAgendaP.getColumnModel().getColumn(22).setMinWidth(0);
        this.JTAgendaP.getColumnModel().getColumn(22).setMaxWidth(0);
        this.JTAgendaP.getColumnModel().getColumn(23).setPreferredWidth(0);
        this.JTAgendaP.getColumnModel().getColumn(23).setMinWidth(0);
        this.JTAgendaP.getColumnModel().getColumn(23).setMaxWidth(0);
        this.JTAgendaP.getColumnModel().getColumn(24).setPreferredWidth(0);
        this.JTAgendaP.getColumnModel().getColumn(24).setMinWidth(0);
        this.JTAgendaP.getColumnModel().getColumn(24).setMaxWidth(0);
        this.JTAgendaP.getColumnModel().getColumn(25).setPreferredWidth(30);
        this.JTAgendaP.getColumnModel().getColumn(26).setPreferredWidth(0);
        this.JTAgendaP.getColumnModel().getColumn(26).setMinWidth(0);
        this.JTAgendaP.getColumnModel().getColumn(26).setMaxWidth(0);
        this.JTAgendaP.getColumnModel().getColumn(27).setPreferredWidth(0);
        this.JTAgendaP.getColumnModel().getColumn(27).setMinWidth(0);
        this.JTAgendaP.getColumnModel().getColumn(27).setMaxWidth(0);
        this.JTAgendaP.getColumnModel().getColumn(28).setPreferredWidth(0);
        this.JTAgendaP.getColumnModel().getColumn(28).setMinWidth(0);
        this.JTAgendaP.getColumnModel().getColumn(28).setMaxWidth(0);
        this.JTAgendaP.getColumnModel().getColumn(29).setPreferredWidth(0);
        this.JTAgendaP.getColumnModel().getColumn(29).setMinWidth(0);
        this.JTAgendaP.getColumnModel().getColumn(29).setMaxWidth(0);
        this.JTAgendaP.getColumnModel().getColumn(30).setPreferredWidth(150);
        this.JTAgendaP.getColumnModel().getColumn(31).setPreferredWidth(150);
        this.JTAgendaP.getColumnModel().getColumn(32).setPreferredWidth(0);
        this.JTAgendaP.getColumnModel().getColumn(32).setMinWidth(0);
        this.JTAgendaP.getColumnModel().getColumn(32).setMaxWidth(0);
        this.JTAgendaP.getColumnModel().getColumn(33).setPreferredWidth(0);
        this.JTAgendaP.getColumnModel().getColumn(33).setMinWidth(0);
        this.JTAgendaP.getColumnModel().getColumn(33).setMaxWidth(0);
        this.JTAgendaP.getColumnModel().getColumn(34).setPreferredWidth(0);
        this.JTAgendaP.getColumnModel().getColumn(34).setMinWidth(0);
        this.JTAgendaP.getColumnModel().getColumn(34).setMaxWidth(0);
        this.xpos = -1;
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTablaAgendaNp() {
        this.xmodelo1 = new DefaultTableModel(new Object[0], new String[]{"N° HC", "Usuario", "Edad", "Sexo", "Tipo Consulta", "HoraI", "Id_Usuario", "Id_Ingreso", "Idclasecita", "Idhistoria", "asistida", "idcita", "Estado", "Idtipocita", "Clasificacion", "Motivo Consulta", "Observación", "Id_Programa", "EsSO", "Id_Triage", "EsCOntrol", "Id_TRatamiento", "Es_Odontologia", "Empresa", "Profesional", "N°", "EsP", "Id_TipoA", "Cpreferencial", "CEspecial", "idformaHistoria", "fechaNacimiento", "fechaAtencion", "Url_videollamada", "Accion Llamar", "idModalidad", "idEntornoAtencion", "idTipoDiscapacidad"}) { // from class: Historia.JIFAgendaMedico_N.34
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, Long.class, Long.class, Long.class, Long.class, String.class, Long.class, String.class, Long.class, Long.class, String.class, String.class, Integer.class, Integer.class, Long.class, String.class, Integer.class, Integer.class, Long.class, Long.class, String.class, Integer.class, Integer.class, Integer.class, JLabel.class, Integer.class, Integer.class, String.class, String.class, JButton.class, Integer.class, Integer.class, Integer.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTAgendaNP.setDefaultRenderer(JButton.class, new TableCellRenderer() { // from class: Historia.JIFAgendaMedico_N.35
            public Component getTableCellRendererComponent(JTable jtable, Object objeto, boolean estaSeleccionado, boolean tieneElFoco, int fila, int columna) {
                return (Component) objeto;
            }
        });
        this.JTAgendaNP.setModel(this.xmodelo1);
        this.JTAgendaNP.getColumnModel().getColumn(0).setPreferredWidth(30);
        this.JTAgendaNP.getColumnModel().getColumn(1).setPreferredWidth(150);
        this.JTAgendaNP.getColumnModel().getColumn(2).setPreferredWidth(10);
        this.JTAgendaNP.getColumnModel().getColumn(3).setPreferredWidth(5);
        this.JTAgendaNP.getColumnModel().getColumn(4).setPreferredWidth(80);
        this.JTAgendaNP.getColumnModel().getColumn(5).setPreferredWidth(40);
        this.JTAgendaNP.getColumnModel().getColumn(6).setPreferredWidth(0);
        this.JTAgendaNP.getColumnModel().getColumn(6).setMinWidth(0);
        this.JTAgendaNP.getColumnModel().getColumn(6).setMaxWidth(0);
        this.JTAgendaNP.getColumnModel().getColumn(7).setPreferredWidth(0);
        this.JTAgendaNP.getColumnModel().getColumn(7).setMinWidth(0);
        this.JTAgendaNP.getColumnModel().getColumn(7).setMaxWidth(0);
        this.JTAgendaNP.getColumnModel().getColumn(8).setPreferredWidth(0);
        this.JTAgendaNP.getColumnModel().getColumn(8).setMinWidth(0);
        this.JTAgendaNP.getColumnModel().getColumn(8).setMaxWidth(0);
        this.JTAgendaNP.getColumnModel().getColumn(9).setPreferredWidth(0);
        this.JTAgendaNP.getColumnModel().getColumn(9).setMinWidth(0);
        this.JTAgendaNP.getColumnModel().getColumn(9).setMaxWidth(0);
        this.JTAgendaNP.getColumnModel().getColumn(10).setPreferredWidth(30);
        this.JTAgendaNP.getColumnModel().getColumn(11).setPreferredWidth(0);
        this.JTAgendaNP.getColumnModel().getColumn(11).setMinWidth(0);
        this.JTAgendaNP.getColumnModel().getColumn(11).setMaxWidth(0);
        this.JTAgendaNP.getColumnModel().getColumn(12).setPreferredWidth(0);
        this.JTAgendaNP.getColumnModel().getColumn(12).setMinWidth(0);
        this.JTAgendaNP.getColumnModel().getColumn(12).setMaxWidth(0);
        this.JTAgendaNP.getColumnModel().getColumn(13).setPreferredWidth(0);
        this.JTAgendaNP.getColumnModel().getColumn(13).setMinWidth(0);
        this.JTAgendaNP.getColumnModel().getColumn(13).setMaxWidth(0);
        this.JTAgendaNP.getColumnModel().getColumn(14).setPreferredWidth(0);
        this.JTAgendaNP.getColumnModel().getColumn(14).setMinWidth(0);
        this.JTAgendaNP.getColumnModel().getColumn(14).setMaxWidth(0);
        this.JTAgendaNP.getColumnModel().getColumn(15).setPreferredWidth(70);
        this.JTAgendaNP.getColumnModel().getColumn(16).setPreferredWidth(70);
        this.JTAgendaNP.getColumnModel().getColumn(17).setPreferredWidth(0);
        this.JTAgendaNP.getColumnModel().getColumn(17).setMinWidth(0);
        this.JTAgendaNP.getColumnModel().getColumn(17).setMaxWidth(0);
        this.JTAgendaNP.getColumnModel().getColumn(18).setPreferredWidth(0);
        this.JTAgendaNP.getColumnModel().getColumn(18).setMinWidth(0);
        this.JTAgendaNP.getColumnModel().getColumn(18).setMaxWidth(0);
        this.JTAgendaNP.getColumnModel().getColumn(19).setPreferredWidth(0);
        this.JTAgendaNP.getColumnModel().getColumn(19).setMinWidth(0);
        this.JTAgendaNP.getColumnModel().getColumn(19).setMaxWidth(0);
        this.JTAgendaNP.getColumnModel().getColumn(20).setPreferredWidth(0);
        this.JTAgendaNP.getColumnModel().getColumn(20).setMinWidth(0);
        this.JTAgendaNP.getColumnModel().getColumn(20).setMaxWidth(0);
        this.JTAgendaNP.getColumnModel().getColumn(21).setPreferredWidth(0);
        this.JTAgendaNP.getColumnModel().getColumn(21).setMinWidth(0);
        this.JTAgendaNP.getColumnModel().getColumn(21).setMaxWidth(0);
        this.JTAgendaNP.getColumnModel().getColumn(22).setPreferredWidth(0);
        this.JTAgendaNP.getColumnModel().getColumn(22).setMinWidth(0);
        this.JTAgendaNP.getColumnModel().getColumn(22).setMaxWidth(0);
        this.JTAgendaNP.getColumnModel().getColumn(23).setPreferredWidth(50);
        this.JTAgendaNP.getColumnModel().getColumn(24).setPreferredWidth(50);
        this.JTAgendaNP.getColumnModel().getColumn(25).setPreferredWidth(0);
        this.JTAgendaNP.getColumnModel().getColumn(25).setMinWidth(0);
        this.JTAgendaNP.getColumnModel().getColumn(25).setMaxWidth(0);
        this.JTAgendaNP.getColumnModel().getColumn(26).setPreferredWidth(0);
        this.JTAgendaNP.getColumnModel().getColumn(26).setMinWidth(0);
        this.JTAgendaNP.getColumnModel().getColumn(26).setMaxWidth(0);
        this.JTAgendaNP.getColumnModel().getColumn(27).setPreferredWidth(0);
        this.JTAgendaNP.getColumnModel().getColumn(27).setMinWidth(0);
        this.JTAgendaNP.getColumnModel().getColumn(27).setMaxWidth(0);
        this.JTAgendaNP.getColumnModel().getColumn(28).setPreferredWidth(0);
        this.JTAgendaNP.getColumnModel().getColumn(28).setMinWidth(0);
        this.JTAgendaNP.getColumnModel().getColumn(28).setMaxWidth(0);
        this.JTAgendaNP.getColumnModel().getColumn(29).setPreferredWidth(50);
        this.JTAgendaNP.getColumnModel().getColumn(30).setPreferredWidth(0);
        this.JTAgendaNP.getColumnModel().getColumn(30).setMinWidth(0);
        this.JTAgendaNP.getColumnModel().getColumn(30).setMaxWidth(0);
        this.JTAgendaNP.getColumnModel().getColumn(31).setPreferredWidth(0);
        this.JTAgendaNP.getColumnModel().getColumn(31).setMinWidth(0);
        this.JTAgendaNP.getColumnModel().getColumn(31).setMaxWidth(0);
        this.JTAgendaNP.getColumnModel().getColumn(32).setPreferredWidth(0);
        this.JTAgendaNP.getColumnModel().getColumn(32).setMinWidth(0);
        this.JTAgendaNP.getColumnModel().getColumn(32).setMaxWidth(0);
        this.JTAgendaNP.getColumnModel().getColumn(33).setPreferredWidth(100);
        this.JTAgendaNP.getColumnModel().getColumn(34).setPreferredWidth(150);
        this.JTAgendaNP.getColumnModel().getColumn(35).setPreferredWidth(0);
        this.JTAgendaNP.getColumnModel().getColumn(35).setMinWidth(0);
        this.JTAgendaNP.getColumnModel().getColumn(35).setMaxWidth(0);
        this.JTAgendaNP.getColumnModel().getColumn(36).setPreferredWidth(0);
        this.JTAgendaNP.getColumnModel().getColumn(36).setMinWidth(0);
        this.JTAgendaNP.getColumnModel().getColumn(36).setMaxWidth(0);
        this.JTAgendaNP.getColumnModel().getColumn(37).setPreferredWidth(0);
        this.JTAgendaNP.getColumnModel().getColumn(37).setMinWidth(0);
        this.JTAgendaNP.getColumnModel().getColumn(37).setMaxWidth(0);
        this.xposnp = -1;
    }

    public void mCargarDatosA() {
        String sql;
        mCrearTablaAgenda();
        ConsultasMySQL xmt = new ConsultasMySQL();
        if (Principal.informacionGeneralPrincipalDTO.getAsignacionCitaAgenda().booleanValue()) {
            if (this.xidt == -1) {
                if (Principal.informacionIps.getVisualizaAgenda().intValue() == 0) {
                    sql = "SELECT `g_usuario`.`NoHistoria`, CONCAT(`g_persona`.`Apellido1`, ' ', `g_persona`.`Apellido2`,' ',`g_persona`.`Nombre1`,' ',`g_persona`.`Nombre2`) AS Nombre, CONCAT(`g_persona`.`Edad`,' ',IF(`g_persona`.`Id_TipoEdad`=1, 'Años',IF(`g_persona`.`Id_TipoEdad`=2,'Mes', 'Día')) ,'(s)') AS `Edad`, `g_persona`.`Id_Sexo`, `c_clasecita`.`Nbre`, `c_citas`.`HoraInicial`, `c_citas`.`HoraFinal`, `g_persona`.`Id`, `c_citas`.`Id_ingreso`, `c_clasecita`.`Id` , `c_clasecita`.`Id_Historia` , `c_citas`.`Asistida`, `c_citas`.`Id`, IF(`c_citas`.`Asistida`=0, 'POR FACTURAR', IF(`c_citas`.`Asistida`=1, 'FACTURADA',IF(`c_citas`.`Asistida`=2, 'EN ATENCION','ATENDIDA'))) AS `Estado`, `c_clasecita`.`Id_TipoCita`, `c_citas`.`Remitida`, `c_clasecita`.`Id_Programa`, `c_citas`.`So`, `c_clasecita`.`EsControl`, `g_especialidad`.`EsOdontologia`, `c_citas`.`Id_TratamientoO` , `f_empresacontxconvenio`.`Nbre`, `c_clasecita`.EsP   ,IF(`ingreso`.`CEspecial` IS NULL, '0',`ingreso`.`CEspecial`) AS CEspecial, ingreso.Id_Atencion,`h_tipohistoria`.`Forma`,g_persona.`FechaNac`,IFNULL(ingreso.`FechaIngreso`, '') FechaIngreso, c_citas.Url_videollamada  , ingreso.idModalidad , ingreso.idEntornoAtencion , ingreso.idTipoDiscapacidad  FROM c_citas  LEFT JOIN `ingreso` ON (`ingreso`.`Id` = `c_citas`.`Id_ingreso`)INNER JOIN `g_usuario`  ON (`c_citas`.`Id_Usuario` = `g_usuario`.`Id_persona`) INNER JOIN `g_persona`  ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`) INNER JOIN `g_especialidad`  ON (`g_especialidad`.`Id` = `c_citas`.`Id_Especialidad`) INNER JOIN `c_clasecita`  ON (`c_citas`.`Id_ClaseCita` = `c_clasecita`.`Id`) INNER JOIN `f_empresacontxconvenio`  ON (`c_citas`.`Id_EmpresaCont` = `f_empresacontxconvenio`.`Id`) INNER JOIN `h_tipohistoria`  ON (`c_clasecita`.`Id_Historia` = `h_tipohistoria`.`Id`) WHERE (`c_citas`.`Fecha_Cita` ='" + this.xmt.formatoAMD.format(this.JDCFechaAgenda.getDate()) + "' AND `c_citas`.`Id_Profesional`='" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "'  AND `c_citas`.`Id_Especialidad` ='" + this.xid_especialidad + "' AND `c_citas`.`Id_Sede` ='" + Principal.sedeUsuarioSeleccionadaDTO.getId() + "' AND `c_citas`.`Id_MotivoDesistida` =1) ORDER BY `c_citas`.`Fecha_Cita` ASC , `c_citas`.`HoraInicial` ASC ";
                } else {
                    sql = "SELECT `g_usuario`.`NoHistoria`, CONCAT(`g_persona`.`Apellido1`, ' ', `g_persona`.`Apellido2`,' ',`g_persona`.`Nombre1`,' ',`g_persona`.`Nombre2`) AS Nombre, CONCAT(`g_persona`.`Edad`,' ',IF(`g_persona`.`Id_TipoEdad`=1, 'Años',IF(`g_persona`.`Id_TipoEdad`=2,'Mes', 'Día')) ,'(s)') AS `Edad`, `g_persona`.`Id_Sexo`, `c_clasecita`.`Nbre`, `c_citas`.`HoraInicial`, `c_citas`.`HoraFinal`, `g_persona`.`Id`, `c_citas`.`Id_ingreso`, `c_clasecita`.`Id` , `c_clasecita`.`Id_Historia` , `c_citas`.`Asistida`, `c_citas`.`Id`, IF(`c_citas`.`Asistida`=0, 'POR FACTURAR', IF(`c_citas`.`Asistida`=1, 'FACTURADA',IF(`c_citas`.`Asistida`=2, 'EN ATENCION','ATENDIDA'))) AS `Estado`, `c_clasecita`.`Id_TipoCita`, `c_citas`.`Remitida`, `c_clasecita`.`Id_Programa`, `c_citas`.`So`, `c_clasecita`.`EsControl`, `g_especialidad`.`EsOdontologia`, `c_citas`.`Id_TratamientoO` , `f_empresacontxconvenio`.`Nbre`, `c_clasecita`.EsP   ,IF(`ingreso`.`CEspecial` IS NULL, '0',`ingreso`.`CEspecial`) AS CEspecial, ingreso.Id_Atencion,`h_tipohistoria`.`Forma`,g_persona.`FechaNac`,IFNULL(ingreso.`FechaIngreso`, '') FechaIngreso, c_citas.Url_videollamada   , ingreso.idModalidad , ingreso.idEntornoAtencion , ingreso.idTipoDiscapacidad  FROM c_citas LEFT JOIN `ingreso` ON (`ingreso`.`Id` = `c_citas`.`Id_ingreso`)   INNER JOIN `g_usuario`  ON (`c_citas`.`Id_Usuario` = `g_usuario`.`Id_persona`) INNER JOIN `g_persona`  ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`) INNER JOIN `g_especialidad`  ON (`g_especialidad`.`Id` = `c_citas`.`Id_Especialidad`) INNER JOIN `c_clasecita`  ON (`c_citas`.`Id_ClaseCita` = `c_clasecita`.`Id`) INNER JOIN `f_empresacontxconvenio`  ON (`c_citas`.`Id_EmpresaCont` = `f_empresacontxconvenio`.`Id`) INNER JOIN `h_tipohistoria`  ON (`c_clasecita`.`Id_Historia` = `h_tipohistoria`.`Id`) WHERE (`c_citas`.`Asistida`>0 AND `c_citas`.`Fecha_Cita` ='" + this.xmt.formatoAMD.format(this.JDCFechaAgenda.getDate()) + "' AND `c_citas`.`Id_Profesional`='" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "'  AND `c_citas`.`Id_Especialidad` ='" + this.xid_especialidad + "' AND `c_citas`.`Id_Sede` ='" + Principal.sedeUsuarioSeleccionadaDTO.getId() + "' AND `c_citas`.`Id_MotivoDesistida` =1) ORDER BY `c_citas`.`Fecha_Cita` ASC , `c_citas`.`Id_ingreso` ASC ";
                }
            } else if (Principal.informacionIps.getVisualizaAgenda().intValue() == 0) {
                sql = "SELECT `g_usuario`.`NoHistoria`, CONCAT(`g_persona`.`Apellido1`, ' ', `g_persona`.`Apellido2`,' ',`g_persona`.`Nombre1`,' ',`g_persona`.`Nombre2`) AS Nombre, CONCAT(`g_persona`.`Edad`,' ',IF(`g_persona`.`Id_TipoEdad`=1, 'Años',IF(`g_persona`.`Id_TipoEdad`=2,'Mes', 'Día')) ,'(s)') AS `Edad`, `g_persona`.`Id_Sexo`, `c_clasecita`.`Nbre`, `c_citas`.`HoraInicial`, `c_citas`.`HoraFinal`, `g_persona`.`Id`, `c_citas`.`Id_ingreso`, `c_clasecita`.`Id` , `c_clasecita`.`Id_Historia` , `c_citas`.`Asistida`, `c_citas`.`Id`, IF(`c_citas`.`Asistida`=0, 'POR FACTURAR', IF(`c_citas`.`Asistida`=1, 'FACTURADA',IF(`c_citas`.`Asistida`=2, 'EN ATENCION','ATENDIDA'))) AS `Estado`, `c_clasecita`.`Id_TipoCita`, `c_citas`.`Remitida`, `c_clasecita`.`Id_Programa`, `c_citas`.`So`, `c_clasecita`.`EsControl`, `g_especialidad`.`EsOdontologia`, `c_citas`.`Id_TratamientoO` , `f_empresacontxconvenio`.`Nbre`, `c_clasecita`.EsP   ,IF(`ingreso`.`CEspecial` IS NULL, '0',`ingreso`.`CEspecial`) AS CEspecial, ingreso.Id_Atencion,`h_tipohistoria`.`Forma`,g_persona.`FechaNac`,IFNULL(ingreso.`FechaIngreso`, '') FechaIngreso, c_citas.Url_videollamada   , ingreso.idModalidad , ingreso.idEntornoAtencion , ingreso.idTipoDiscapacidad  FROM c_citas  LEFT JOIN `ingreso` ON (`ingreso`.`Id` = `c_citas`.`Id_ingreso`)  INNER JOIN `g_usuario`  ON (`c_citas`.`Id_Usuario` = `g_usuario`.`Id_persona`) INNER JOIN `g_persona`  ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`) INNER JOIN `g_especialidad`  ON (`g_especialidad`.`Id` = `c_citas`.`Id_Especialidad`) INNER JOIN `c_clasecita`  ON (`c_citas`.`Id_ClaseCita` = `c_clasecita`.`Id`) INNER JOIN `f_empresacontxconvenio`  ON (`c_citas`.`Id_EmpresaCont` = `f_empresacontxconvenio`.`Id`) INNER JOIN `h_tipohistoria`  ON (`c_clasecita`.`Id_Historia` = `h_tipohistoria`.`Id`) WHERE (`c_citas`.`Fecha_Cita` ='" + this.xmt.formatoAMD.format(this.JDCFechaAgenda.getDate()) + "' AND `c_citas`.`Id_Profesional`='" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "'  AND `c_citas`.`Id_Especialidad` ='" + this.xid_especialidad + "' AND `c_citas`.`Id_Sede` ='" + Principal.sedeUsuarioSeleccionadaDTO.getId() + "' AND `c_citas`.`Id_MotivoDesistida` =1 and Asistida='" + this.xestado + "') ORDER BY `c_citas`.`Fecha_Cita` ASC , `c_citas`.`HoraInicial` ASC ";
            } else {
                sql = "SELECT `g_usuario`.`NoHistoria`, CONCAT(`g_persona`.`Apellido1`, ' ', `g_persona`.`Apellido2`,' ',`g_persona`.`Nombre1`,' ',`g_persona`.`Nombre2`) AS Nombre, CONCAT(`g_persona`.`Edad`,' ',IF(`g_persona`.`Id_TipoEdad`=1, 'Años',IF(`g_persona`.`Id_TipoEdad`=2,'Mes', 'Día')) ,'(s)') AS `Edad`, `g_persona`.`Id_Sexo`, `c_clasecita`.`Nbre`, `c_citas`.`HoraInicial`, `c_citas`.`HoraFinal`, `g_persona`.`Id`, `c_citas`.`Id_ingreso`, `c_clasecita`.`Id` , `c_clasecita`.`Id_Historia` , `c_citas`.`Asistida`, `c_citas`.`Id`, IF(`c_citas`.`Asistida`=0, 'POR FACTURAR', IF(`c_citas`.`Asistida`=1, 'FACTURADA',IF(`c_citas`.`Asistida`=2, 'EN ATENCION','ATENDIDA'))) AS `Estado`, `c_clasecita`.`Id_TipoCita`, `c_citas`.`Remitida`, `c_clasecita`.`Id_Programa`, `c_citas`.`So`, `c_clasecita`.`EsControl`, `g_especialidad`.`EsOdontologia`, `c_citas`.`Id_TratamientoO` , `f_empresacontxconvenio`.`Nbre`, `c_clasecita`.EsP   ,IF(`ingreso`.`CEspecial` IS NULL, '0',`ingreso`.`CEspecial`) AS CEspecial, ingreso.Id_Atencion,`h_tipohistoria`.`Forma`,g_persona.`FechaNac`,IFNULL(ingreso.`FechaIngreso`, '') FechaIngreso, c_citas.Url_videollamada   , ingreso.idModalidad , ingreso.idEntornoAtencion , ingreso.idTipoDiscapacidad  FROM  c_citas  LEFT JOIN `ingreso` ON (`ingreso`.`Id` = `c_citas`.`Id_ingreso`)  INNER JOIN `g_usuario`  ON (`c_citas`.`Id_Usuario` = `g_usuario`.`Id_persona`) INNER JOIN `g_persona`  ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`) INNER JOIN `g_especialidad`  ON (`g_especialidad`.`Id` = `c_citas`.`Id_Especialidad`) INNER JOIN `c_clasecita`  ON (`c_citas`.`Id_ClaseCita` = `c_clasecita`.`Id`) INNER JOIN `f_empresacontxconvenio`  ON (`c_citas`.`Id_EmpresaCont` = `f_empresacontxconvenio`.`Id`) INNER JOIN `h_tipohistoria`  ON (`c_clasecita`.`Id_Historia` = `h_tipohistoria`.`Id`) WHERE (`c_citas`.`Asistida`>0 AND `c_citas`.`Fecha_Cita` ='" + this.xmt.formatoAMD.format(this.JDCFechaAgenda.getDate()) + "' AND `c_citas`.`Id_Profesional`='" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "'  AND `c_citas`.`Id_Especialidad` ='" + this.xid_especialidad + "' AND `c_citas`.`Id_Sede` ='" + Principal.sedeUsuarioSeleccionadaDTO.getId() + "' AND `c_citas`.`Id_MotivoDesistida` =1 and Asistida='" + this.xestado + "') ORDER BY `c_citas`.`Fecha_Cita` ASC , `c_citas`.`Id_ingreso` ASC ";
            }
        } else if (Principal.informacionIps.getVisualizaAgenda().intValue() == 0) {
            sql = "SELECT `g_usuario`.`NoHistoria`, CONCAT(`g_persona`.`Apellido1`, ' ', `g_persona`.`Apellido2`,' ',`g_persona`.`Nombre1`,' ',`g_persona`.`Nombre2`) AS Nombre, CONCAT(`g_persona`.`Edad`,' ',IF(`g_persona`.`Id_TipoEdad`=1, 'Años',IF(`g_persona`.`Id_TipoEdad`=2,'Mes', 'Día')) ,'(s)') AS `Edad`, `g_persona`.`Id_Sexo`, `c_clasecita`.`Nbre`, `c_citas`.`HoraInicial`, `c_citas`.`HoraFinal`, `g_persona`.`Id`, `c_citas`.`Id_ingreso`, `c_clasecita`.`Id` , `c_clasecita`.`Id_Historia` , `c_citas`.`Asistida`, `c_citas`.`Id`, IF(`c_citas`.`Asistida`=0, 'POR FACTURAR', IF(`c_citas`.`Asistida`=1, 'FACTURADA',IF(`c_citas`.`Asistida`=2, 'EN ATENCION','ATENDIDA'))) AS `Estado`, `c_clasecita`.`Id_TipoCita`, `c_citas`.`Remitida`, `c_clasecita`.`Id_Programa`, `c_citas`.`So`, `c_clasecita`.`EsControl`, `g_especialidad`.`EsOdontologia`, `c_citas`.`Id_TratamientoO` , `f_empresacontxconvenio`.`Nbre`, `c_clasecita`.EsP   ,IF(`ingreso`.`CEspecial` IS NULL, '0',`ingreso`.`CEspecial`) AS CEspecial, ingreso.Id_Atencion,`h_tipohistoria`.`Forma`,g_persona.`FechaNac`,IFNULL(ingreso.`FechaIngreso`, '') FechaIngreso, c_citas.Url_videollamada   , ingreso.idModalidad , ingreso.idEntornoAtencion , ingreso.idTipoDiscapacidad  FROM  c_citas   LEFT JOIN `ingreso` ON (`ingreso`.`Id` = `c_citas`.`Id_ingreso`)  INNER JOIN `g_usuario`  ON (`c_citas`.`Id_Usuario` = `g_usuario`.`Id_persona`) INNER JOIN `g_persona`  ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`) INNER JOIN `g_especialidad`  ON (`g_especialidad`.`Id` = `c_citas`.`Id_Especialidad`) INNER JOIN `c_clasecita`  ON (`c_citas`.`Id_ClaseCita` = `c_clasecita`.`Id`) INNER JOIN `f_empresacontxconvenio`  ON (`c_citas`.`Id_EmpresaCont` = `f_empresacontxconvenio`.`Id`) INNER JOIN `h_tipohistoria`  ON (`c_clasecita`.`Id_Historia` = `h_tipohistoria`.`Id`) WHERE (`c_citas`.`Fecha_Cita` ='" + this.xmt.formatoAMD.format(this.JDCFechaAgenda.getDate()) + "' AND `c_citas`.`Id_Profesional`='" + this.xid_profesional + "'  AND `c_citas`.`Id_Especialidad` ='" + this.xid_especialidad + "' AND `c_citas`.`Id_Sede` ='" + Principal.sedeUsuarioSeleccionadaDTO.getId() + "' AND `c_citas`.`Id_MotivoDesistida` =1 and Asistida='" + this.xestado + "') ORDER BY `c_citas`.`Fecha_Cita` ASC , `c_citas`.`HoraInicial` ASC ";
        } else {
            sql = "SELECT `g_usuario`.`NoHistoria`, CONCAT(`g_persona`.`Apellido1`, ' ', `g_persona`.`Apellido2`,' ',`g_persona`.`Nombre1`,' ',`g_persona`.`Nombre2`) AS Nombre, CONCAT(`g_persona`.`Edad`,' ',IF(`g_persona`.`Id_TipoEdad`=1, 'Años',IF(`g_persona`.`Id_TipoEdad`=2,'Mes', 'Día')) ,'(s)') AS `Edad`, `g_persona`.`Id_Sexo`, `c_clasecita`.`Nbre`, `c_citas`.`HoraInicial`, `c_citas`.`HoraFinal`, `g_persona`.`Id`, `c_citas`.`Id_ingreso`, `c_clasecita`.`Id` , `c_clasecita`.`Id_Historia` , `c_citas`.`Asistida`, `c_citas`.`Id`, IF(`c_citas`.`Asistida`=0, 'POR FACTURAR', IF(`c_citas`.`Asistida`=1, 'FACTURADA',IF(`c_citas`.`Asistida`=2, 'EN ATENCION','ATENDIDA'))) AS `Estado`, `c_clasecita`.`Id_TipoCita`, `c_citas`.`Remitida`, `c_clasecita`.`Id_Programa`, `c_citas`.`So`, `c_clasecita`.`EsControl`, `g_especialidad`.`EsOdontologia`, `c_citas`.`Id_TratamientoO` , `f_empresacontxconvenio`.`Nbre`, `c_clasecita`.EsP   ,IF(`ingreso`.`CEspecial` IS NULL, '0',`ingreso`.`CEspecial`) AS CEspecial, ingreso.Id_Atencion,`h_tipohistoria`.`Forma`,g_persona.`FechaNac`,IFNULL(ingreso.`FechaIngreso`, '') FechaIngreso, c_citas.Url_videollamada   , ingreso.idModalidad , ingreso.idEntornoAtencion , ingreso.idTipoDiscapacidad  FROM c_citas  LEFT JOIN `ingreso` ON (`ingreso`.`Id` = `c_citas`.`Id_ingreso`)  INNER JOIN `g_usuario`  ON (`c_citas`.`Id_Usuario` = `g_usuario`.`Id_persona`) INNER JOIN `g_persona`  ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`) INNER JOIN `g_especialidad`  ON (`g_especialidad`.`Id` = `c_citas`.`Id_Especialidad`) INNER JOIN `c_clasecita`  ON (`c_citas`.`Id_ClaseCita` = `c_clasecita`.`Id`) INNER JOIN `f_empresacontxconvenio`  ON (`c_citas`.`Id_EmpresaCont` = `f_empresacontxconvenio`.`Id`) INNER JOIN `h_tipohistoria`  ON (`c_clasecita`.`Id_Historia` = `h_tipohistoria`.`Id`) WHERE (`c_citas`.`Asistida`>0 AND `c_citas`.`Fecha_Cita` ='" + this.xmt.formatoAMD.format(this.JDCFechaAgenda.getDate()) + "' AND `c_citas`.`Id_Profesional`='" + this.xid_especialidad + "'  AND `c_citas`.`Id_Especialidad` ='" + this.xid_especialidad + "' AND `c_citas`.`Id_Sede` ='" + Principal.sedeUsuarioSeleccionadaDTO.getId() + "' AND `c_citas`.`Id_MotivoDesistida` =1 and Asistida='" + this.xestado + "') ORDER BY `c_citas`.`Fecha_Cita` ASC , `c_citas`.`Id_ingreso` ASC";
        }
        System.out.println("Consulta carga agenda -> " + sql);
        ResultSet rs = xmt.traerRs(sql);
        try {
            if (rs.next()) {
                rs.beforeFirst();
                int i = 0;
                this.xmt.mEstablecerTextEditor(this.JTAgendaP, 30);
                while (rs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(rs.getString(1), i, 0);
                    this.xmodelo.setValueAt(rs.getString(2), i, 1);
                    this.xmodelo.setValueAt(rs.getString(3), i, 2);
                    this.xmodelo.setValueAt(rs.getString(4), i, 3);
                    this.xmodelo.setValueAt(rs.getString(5), i, 4);
                    this.xmodelo.setValueAt(rs.getString(6), i, 5);
                    this.xmodelo.setValueAt(rs.getString(7), i, 6);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong(8)), i, 7);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong(9)), i, 8);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong(10)), i, 9);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong(11)), i, 10);
                    this.xmodelo.setValueAt("0", i, 11);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong(12)), i, 11);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong(13)), i, 12);
                    this.xmodelo.setValueAt(rs.getString(14), i, 13);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong(15)), i, 14);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong(16)), i, 15);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong(17)), i, 16);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong(18)), i, 17);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong(19)), i, 18);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong(20)), i, 19);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong(21)), i, 20);
                    this.xmodelo.setValueAt(rs.getString(22), i, 21);
                    this.xmodelo.setValueAt(Integer.valueOf(i + 1), i, 22);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong(23)), i, 23);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong("CEspecial")), i, 24);
                    this.xmodelo.setValueAt(Integer.valueOf(rs.getInt("Forma")), i, 27);
                    this.xmodelo.setValueAt(rs.getString("FechaNac"), i, 28);
                    this.xmodelo.setValueAt(rs.getString("FechaIngreso"), i, 29);
                    this.xmodelo.setValueAt(rs.getString("Url_videollamada"), i, 30);
                    this.xmodelo.setValueAt(Integer.valueOf(rs.getInt("idModalidad")), i, 32);
                    this.xmodelo.setValueAt(Integer.valueOf(rs.getInt("idEntornoAtencion")), i, 33);
                    this.xmodelo.setValueAt(Integer.valueOf(rs.getInt("idTipoDiscapacidad")), i, 34);
                    buscaarPacientes(rs.getString(1));
                    if (this.num == 0) {
                        this.xmodelo.setValueAt(new JButton("Llamar"), i, 31);
                    } else {
                        this.xmodelo.setValueAt(new JButton("Llamar " + this.num), i, 31);
                    }
                    if (rs.getLong("CEspecial") == 1) {
                        this.xmodelo.setValueAt(new JLabel(new ImageIcon(getClass().getResource("/Imagenes/Atencion Discapasitaods.png"))), i, 25);
                    } else if (rs.getLong("CEspecial") == 2) {
                        this.xmodelo.setValueAt(new JLabel(new ImageIcon(getClass().getResource("/Imagenes/Atencion Embarazada.png"))), i, 25);
                    } else if (rs.getLong("CEspecial") == 3) {
                        this.xmodelo.setValueAt(new JLabel(new ImageIcon(getClass().getResource("/Imagenes/Atencion Ancianos.png"))), i, 25);
                    } else if (rs.getLong("CEspecial") == 4) {
                        this.xmodelo.setValueAt(new JLabel(new ImageIcon(getClass().getResource("/Imagenes/AtpNiños.png"))), i, 25);
                    } else {
                        this.xmodelo.setValueAt(new JLabel(""), i, 25);
                    }
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong("Id_Atencion")), i, 26);
                    this.JTAgendaP.setDefaultRenderer(JLabel.class, new Render(rs.getInt("CEspecial"), 24));
                    this.JTAgendaP.setDefaultRenderer(Object.class, new MiRender());
                    i++;
                }
                this.JLBNRegistro.setText("" + i);
            } else {
                this.JLBNRegistro.setText("0");
            }
            rs.close();
            xmt.cerrarConexionBd();
        } catch (SQLException e) {
        }
    }

    public void mCargarDatosCNP() {
        String sql;
        mCrearTablaAgendaNp();
        if (this.xid_especialidad.equals("382")) {
            if (Principal.informacionIps.getEsFpz().intValue() == 0) {
                if (JIFAgendaMedico.xidt == -1) {
                    if (this.JCHFiltro1.isSelected()) {
                        if (this.JCHFiltro.isSelected()) {
                            sql = "SELECT g_usuario.NoHistoria, CONCAT(g_persona.`Apellido1`,' ',g_persona.`Apellido2`,' ',g_persona.`Nombre1`,' ',g_persona.`Nombre2`) AS NPersona, CONCAT(`g_persona`.`Edad`,' ' ,g_tipoedad.`Nbre`,'(s)') AS Edad, g_persona.`Id_Sexo`, c_clasecita.Nbre,DATE_FORMAT(c_citasnp.HoraInicial,'%h:%i%:%s %p'), ingreso.Id_Usuario , ingreso.Id, c_citasnp.Id_ClaseCita,  c_clasecita.Id_Historia,   IF(c_citasnp.Asistida=0,'POR ATENCIÓN',IF(c_citasnp.Asistida=1,'FACTURADA',IF(c_citasnp.Asistida=2,'EN ATENCIÓN','ATENDIDA'))), c_citasnp.Id, c_citasnp.Id_MotivoDesistida, c_clasecita.Id_TipoCita, h_triage.Clasificacion , h_triage.MotivoConsulta, h_triage.Observacion,  c_clasecita.Id_Programa, c_citasnp.So,h_triage.Id , c_clasecita.EsControl,  c_citasnp.Id_TratamientoO, profesional1.EsOdontologia,  `f_empresacontxconvenio`.`Nbre`  , `profesional1`.`NProfesional`, `c_clasecita`.EsP, ingreso.Id_TipoAtencion  ,IF(`ingreso`.`CEspecial` IS NULL, '0',`ingreso`.`CEspecial`) AS CEspecial ,`h_tipohistoria`.`Forma`,g_persona.`FechaNac`,ingreso.`FechaIngreso`, c_citasnp.Url_videollamada    FROM  `g_persona` INNER JOIN `c_citasnp`  ON (`g_persona`.`Id` = `c_citasnp`.`Id_Usuario`) , ingreso.idModalidad , ingreso.idEntornoAtencion , ingreso.idTipoDiscapacidad  INNER JOIN `g_usuario` ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)  INNER JOIN `g_tipoedad`  ON (`g_persona`.`Id_TipoEdad` = `g_tipoedad`.`Id`)  INNER JOIN `ingreso`  ON (`ingreso`.`Id` = `c_citasnp`.`Id_ingreso`) INNER JOIN `f_empresacontxconvenio`  ON (`c_citasnp`.`Id_EmpresaCont` = `f_empresacontxconvenio`.`Id`) INNER JOIN `h_tipohistoria` ON (`c_clasecita`.`Id_Historia` = `h_tipohistoria`.`Id`) INNER JOIN `c_clasecita`  ON (`c_citasnp`.`Id_ClaseCita` = `c_clasecita`.`Id`) INNER JOIN `h_triage`  ON (`h_triage`.`IdIngreso` = `ingreso`.`Id`) INNER JOIN `h_atencion`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN `profesional1`  ON (`profesional1`.`Id_Persona` = `h_atencion`.`Id_Profesional`) AND (`profesional1`.`IdEspecialidad` = `h_atencion`.`Id_Especialidad`) WHERE (CONCAT(g_persona.`Apellido1`,' ',g_persona.`Apellido2`,' ',g_persona.`Nombre1`,' ',g_persona.`Nombre2`) like'%" + this.JTF.getText() + "%' and c_citasnp.Id_MotivoDesistida =0 AND profesional1.IdEspecialidad ='" + this.xid_especialidad + "' AND `c_citasnp`.`Fecha_Cita` ='" + this.xmt.formatoAMD.format(this.JDCFechaAgenda.getDate()) + "' AND c_citasnp.Id_Anulada=0  AND ingreso.Id_Sede='" + Principal.sedeUsuarioSeleccionadaDTO.getId() + "' AND h_triage.Es_Agendado='0' AND ingreso.Estado=0 )GROUP BY ingreso.Id  ORDER BY c_citasnp.HoraInicial ASC ";
                        } else {
                            sql = "SELECT g_usuario.NoHistoria, CONCAT(g_persona.`Apellido1`,' ',g_persona.`Apellido2`,' ',g_persona.`Nombre1`,' ',g_persona.`Nombre2`) AS NPersona, CONCAT(`g_persona`.`Edad`,' ' ,g_tipoedad.`Nbre`,'(s)') AS Edad, g_persona.`Id_Sexo`, c_clasecita.Nbre,DATE_FORMAT(c_citasnp.HoraInicial,'%h:%i%:%s %p'), ingreso.Id_Usuario , ingreso.Id, c_citasnp.Id_ClaseCita,  c_clasecita.Id_Historia,   IF(c_citasnp.Asistida=0,'POR ATENCIÓN',IF(c_citasnp.Asistida=1,'FACTURADA',IF(c_citasnp.Asistida=2,'EN ATENCIÓN','ATENDIDA'))), c_citasnp.Id, c_citasnp.Id_MotivoDesistida, c_clasecita.Id_TipoCita, h_triage.Clasificacion , h_triage.MotivoConsulta, h_triage.Observacion,  c_clasecita.Id_Programa, c_citasnp.So,h_triage.Id , c_clasecita.EsControl,  c_citasnp.Id_TratamientoO, profesional1.EsOdontologia,  `f_empresacontxconvenio`.`Nbre`  , `profesional1`.`NProfesional`, `c_clasecita`.EsP, ingreso.Id_TipoAtencion  ,IF(`ingreso`.`CEspecial` IS NULL, '0',`ingreso`.`CEspecial`) AS CEspecial,`h_tipohistoria`.`Forma`,g_persona.`FechaNac`,ingreso.`FechaIngreso`, c_citasnp.Url_videollamada   , ingreso.idModalidad , ingreso.idEntornoAtencion , ingreso.idTipoDiscapacidad   FROM  `g_persona` INNER JOIN `c_citasnp`  ON (`g_persona`.`Id` = `c_citasnp`.`Id_Usuario`) INNER JOIN `g_usuario` ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)  INNER JOIN `g_tipoedad`  ON (`g_persona`.`Id_TipoEdad` = `g_tipoedad`.`Id`)  INNER JOIN `ingreso`  ON (`ingreso`.`Id` = `c_citasnp`.`Id_ingreso`) INNER JOIN `f_empresacontxconvenio`  ON (`c_citasnp`.`Id_EmpresaCont` = `f_empresacontxconvenio`.`Id`) INNER JOIN `c_clasecita`  ON (`c_citasnp`.`Id_ClaseCita` = `c_clasecita`.`Id`) INNER JOIN `h_tipohistoria` ON (`c_clasecita`.`Id_Historia` = `h_tipohistoria`.`Id`)  INNER JOIN `h_triage`  ON (`h_triage`.`IdIngreso` = `ingreso`.`Id`) INNER JOIN `h_atencion`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN `profesional1`  ON (`profesional1`.`Id_Persona` = `h_atencion`.`Id_Profesional`) AND (`profesional1`.`IdEspecialidad` = `h_atencion`.`Id_Especialidad`) WHERE (c_citasnp.Id_MotivoDesistida =0 AND profesional1.IdEspecialidad ='" + this.xid_especialidad + "' AND `c_citasnp`.`Fecha_Cita` ='" + this.xmt.formatoAMD.format(this.JDCFechaAgenda.getDate()) + "' AND c_citasnp.Id_Anulada=0  AND ingreso.Id_Sede='" + Principal.sedeUsuarioSeleccionadaDTO.getId() + "' AND h_triage.Es_Agendado='0' AND ingreso.Estado=0 )GROUP BY ingreso.Id  ORDER BY c_citasnp.HoraInicial ASC ";
                        }
                    } else if (this.JCHFiltro.isSelected()) {
                        sql = "SELECT g_usuario.NoHistoria, CONCAT(g_persona.`Apellido1`,' ',g_persona.`Apellido2`,' ',g_persona.`Nombre1`,' ',g_persona.`Nombre2`) AS NPersona, CONCAT(`g_persona`.`Edad`,' ' ,g_tipoedad.`Nbre`,'(s)') AS Edad, g_persona.`Id_Sexo`, c_clasecita.Nbre, DATE_FORMAT(c_citasnp.HoraInicial,'%h:%i%:%s %p') AS hora, ingreso.Id_Usuario , ingreso.Id, c_citasnp.Id_ClaseCita, c_clasecita.Id_Historia,     IF(c_citasnp.Asistida=0,'POR ATENCIÓN',IF(c_citasnp.Asistida=1,'EN ATENCIÓN','ATENDIDA')) AS Estado,   c_citasnp.Id,  c_citasnp.Id_MotivoDesistida, c_clasecita.Id_TipoCita, 1  AS Triage, '' AS MC, '' AS Observacion, c_clasecita.Id_Programa ,  c_citasnp.So,0 AS IdTriage , c_clasecita.EsControl,  c_citasnp.Id_TratamientoO,  profesional1.EsOdontologia, `f_empresacontxconvenio`.`Nbre` , `profesional1`.`NProfesional`, `c_clasecita`.EsP, ingreso.Id_TipoAtencion  ,IF(`ingreso`.`CEspecial` IS NULL, '0',`ingreso`.`CEspecial`) AS CEspecial,`h_tipohistoria`.`Forma`,g_persona.`FechaNac`,ingreso.`FechaIngreso`, c_citasnp.Url_videollamada   , ingreso.idModalidad , ingreso.idEntornoAtencion , ingreso.idTipoDiscapacidad  FROM c_citasnp    INNER JOIN `profesional1`  ON (`profesional1`.`Id_Persona` = `c_citasnp`.`Id_Profesional`)  AND (`profesional1`.`IdEspecialidad` = `c_citasnp`.`Id_Especialidad`)   INNER JOIN g_persona  ON (`g_persona`.`Id` = c_citasnp.Id_Usuario)   INNER JOIN c_clasecita  ON (c_citasnp.Id_ClaseCita = c_clasecita.Id)   INNER JOIN ingreso  ON (ingreso.Id = c_citasnp.Id_ingreso)   INNER JOIN g_usuario  ON (g_usuario.Id_persona = g_persona.`Id`)   INNER JOIN `g_tipoedad`  ON (`g_persona`.`Id_TipoEdad` = `g_tipoedad`.`Id`)  INNER JOIN `f_empresacontxconvenio`  ON (`c_citasnp`.`Id_EmpresaCont` = `f_empresacontxconvenio`.`Id`) INNER JOIN `h_tipohistoria` ON (`c_clasecita`.`Id_Historia` = `h_tipohistoria`.`Id`) WHERE (CONCAT(g_persona.`Apellido1`,' ',g_persona.`Apellido2`,' ',g_persona.`Nombre1`,' ',g_persona.`Nombre2`) like'%" + this.JTF.getText() + "%' and c_citasnp.Id_MotivoDesistida =0 AND c_citasnp.Id_Especialidad ='" + this.xid_especialidad + "' AND  c_citasnp.Fecha_Cita='" + this.xmt.formatoAMD.format(this.JDCFechaAgenda.getDate()) + "' AND c_citasnp.Id_Anulada=0 AND c_citasnp.`Id_Sede`='" + Principal.sedeUsuarioSeleccionadaDTO.getId() + "') GROUP BY ingreso.Id ORDER BY c_citasnp.HoraInicial ASC ";
                    } else {
                        sql = "SELECT g_usuario.NoHistoria, CONCAT(g_persona.`Apellido1`,' ',g_persona.`Apellido2`,' ',g_persona.`Nombre1`,' ',g_persona.`Nombre2`) AS NPersona, CONCAT(`g_persona`.`Edad`,' ' ,g_tipoedad.`Nbre`,'(s)') AS Edad, g_persona.`Id_Sexo`, c_clasecita.Nbre, DATE_FORMAT(c_citasnp.HoraInicial,'%h:%i%:%s %p') AS hora, ingreso.Id_Usuario , ingreso.Id, c_citasnp.Id_ClaseCita, c_clasecita.Id_Historia,     IF(c_citasnp.Asistida=0,'POR ATENCIÓN',IF(c_citasnp.Asistida=1,'EN ATENCIÓN','ATENDIDA')) AS Estado,   c_citasnp.Id,  c_citasnp.Id_MotivoDesistida, c_clasecita.Id_TipoCita, 1  AS Triage, '' AS MC, '' AS Observacion, c_clasecita.Id_Programa ,  c_citasnp.So,0 AS IdTriage , c_clasecita.EsControl,  c_citasnp.Id_TratamientoO,  profesional1.EsOdontologia, `f_empresacontxconvenio`.`Nbre` , `profesional1`.`NProfesional`, `c_clasecita`.EsP, ingreso.Id_TipoAtencion  ,IF(`ingreso`.`CEspecial` IS NULL, '0',`ingreso`.`CEspecial`) AS CEspecial,`h_tipohistoria`.`Forma`,g_persona.`FechaNac`,ingreso.`FechaIngreso`, c_citasnp.Url_videollamada   , ingreso.idModalidad , ingreso.idEntornoAtencion , ingreso.idTipoDiscapacidad  FROM c_citasnp    INNER JOIN `profesional1`  ON (`profesional1`.`Id_Persona` = `c_citasnp`.`Id_Profesional`)  AND (`profesional1`.`IdEspecialidad` = `c_citasnp`.`Id_Especialidad`)   INNER JOIN g_persona  ON (`g_persona`.`Id` = c_citasnp.Id_Usuario)   INNER JOIN c_clasecita  ON (c_citasnp.Id_ClaseCita = c_clasecita.Id)   INNER JOIN ingreso  ON (ingreso.Id = c_citasnp.Id_ingreso)   INNER JOIN g_usuario  ON (g_usuario.Id_persona = g_persona.`Id`)   INNER JOIN `g_tipoedad`  ON (`g_persona`.`Id_TipoEdad` = `g_tipoedad`.`Id`)  INNER JOIN `f_empresacontxconvenio`  ON (`c_citasnp`.`Id_EmpresaCont` = `f_empresacontxconvenio`.`Id`) INNER JOIN `h_tipohistoria` ON (`c_clasecita`.`Id_Historia` = `h_tipohistoria`.`Id`) WHERE (c_citasnp.Id_MotivoDesistida =0 AND c_citasnp.Id_Especialidad ='" + this.xid_especialidad + "' AND  c_citasnp.Fecha_Cita='" + this.xmt.formatoAMD.format(this.JDCFechaAgenda.getDate()) + "' AND c_citasnp.Id_Anulada=0 AND c_citasnp.`Id_Sede`='" + Principal.sedeUsuarioSeleccionadaDTO.getId() + "') GROUP BY ingreso.Id ORDER BY c_citasnp.HoraInicial ASC ";
                    }
                } else if (this.JCHFiltro.isSelected()) {
                    sql = "SELECT g_usuario.NoHistoria, CONCAT(g_persona.`Apellido1`,' ',g_persona.`Apellido2`,' ',g_persona.`Nombre1`,' ',g_persona.`Nombre2`) AS NPersona, `g_persona`.`Edad`, g_tipoedad.`Nbre`, g_persona.`Id_Sexo`, c_clasecita.Nbre,DATE_FORMAT(c_citasnp.HoraInicial,'%h:%i%:%s %p'), ingreso.Id_Usuario , ingreso.Id, c_citasnp.Id_ClaseCita,  c_clasecita.Id_Historia,  IF(c_citasnp.Asistida=0,'POR ATENCIÓN',IF(c_citasnp.Asistida=1,'FACTURADA',IF(c_citasnp.Asistida=2,'EN ATENCIÓN','ATENDIDA'))), c_citasnp.Id, c_citasnp.Id_MotivoDesistida, c_clasecita.Id_TipoCita, h_triage.Clasificacion , h_triage.MotivoConsulta, h_triage.Observacion, c_clasecita.Id_Programa, c_citasnp.So,h_triage.Id , c_clasecita.EsControl,  c_citasnp.Id_TratamientoO, profesional1.EsOdontologia,  `f_empresacontxconvenio`.`Nbre`  , `profesional1`.`NProfesional`, `c_clasecita`.EsP, ingreso.Id_TipoAtencion  ,IF(`ingreso`.`CEspecial` IS NULL, '0',`ingreso`.`CEspecial`) AS CEspecial,`h_tipohistoria`.`Forma`,g_persona.`FechaNac`,ingreso.`FechaIngreso`, c_citasnp.Url_videollamada   , ingreso.idModalidad , ingreso.idEntornoAtencion , ingreso.idTipoDiscapacidad  FROM  `g_persona` INNER JOIN `c_citasnp`  ON (`g_persona`.`Id` = `c_citasnp`.`Id_Usuario`) INNER JOIN `g_usuario` ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)  INNER JOIN `g_tipoedad`  ON (`g_persona`.`Id_TipoEdad` = `g_tipoedad`.`Id`)  INNER JOIN `ingreso`  ON (`ingreso`.`Id` = `c_citasnp`.`Id_ingreso`) INNER JOIN `f_empresacontxconvenio`  ON (`c_citasnp`.`Id_EmpresaCont` = `f_empresacontxconvenio`.`Id`) INNER JOIN `h_tipohistoria` ON (`c_clasecita`.`Id_Historia` = `h_tipohistoria`.`Id`) INNER JOIN `c_clasecita`  ON (`c_citasnp`.`Id_ClaseCita` = `c_clasecita`.`Id`) INNER JOIN `h_triage`  ON (`h_triage`.`IdIngreso` = `ingreso`.`Id`) INNER JOIN `h_atencion`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN `profesional1`  ON (`profesional1`.`Id_Persona` = `h_atencion`.`Id_Profesional`) AND (`profesional1`.`IdEspecialidad` = `h_atencion`.`Id_Especialidad`) WHERE (CONCAT(g_persona.`Apellido1`,' ',g_persona.`Apellido2`,' ',g_persona.`Nombre1`,' ',g_persona.`Nombre2`) like'%" + this.JTF.getText() + "%' and c_citasnp.Id_MotivoDesistida =0 AND profesional1.IdEspecialidad ='" + this.xid_especialidad + "' AND `c_citasnp`.`Fecha_Cita` ='" + this.xmt.formatoAMD.format(this.JDCFechaAgenda.getDate()) + "' AND c_citasnp.Id_Anulada=0  AND ingreso.Id_Sede='" + Principal.sedeUsuarioSeleccionadaDTO.getId() + "' AND h_triage.Es_Agendado='0' AND ingreso.Estado=0 and Asistida='" + this.xestadonp + "' )GROUP BY ingreso.Id  ORDER BY c_citasnp.HoraInicial ASC ";
                } else {
                    sql = "SELECT g_usuario.NoHistoria, CONCAT(g_persona.`Apellido1`,' ',g_persona.`Apellido2`,' ',g_persona.`Nombre1`,' ',g_persona.`Nombre2`) AS NPersona, `g_persona`.`Edad`, g_tipoedad.`Nbre`, g_persona.`Id_Sexo`, c_clasecita.Nbre,DATE_FORMAT(c_citasnp.HoraInicial,'%h:%i%:%s %p'), ingreso.Id_Usuario , ingreso.Id, c_citasnp.Id_ClaseCita,  c_clasecita.Id_Historia,  IF(c_citasnp.Asistida=0,'POR ATENCIÓN',IF(c_citasnp.Asistida=1,'FACTURADA',IF(c_citasnp.Asistida=2,'EN ATENCIÓN','ATENDIDA'))), c_citasnp.Id, c_citasnp.Id_MotivoDesistida, c_clasecita.Id_TipoCita, h_triage.Clasificacion , h_triage.MotivoConsulta, h_triage.Observacion, c_clasecita.Id_Programa, c_citasnp.So,h_triage.Id , c_clasecita.EsControl,  c_citasnp.Id_TratamientoO, profesional1.EsOdontologia,  `f_empresacontxconvenio`.`Nbre`  , `profesional1`.`NProfesional`, `c_clasecita`.EsP, ingreso.Id_TipoAtencion  ,IF(`ingreso`.`CEspecial` IS NULL, '0',`ingreso`.`CEspecial`) AS CEspecial,`h_tipohistoria`.`Forma`,g_persona.`FechaNac`,ingreso.`FechaIngreso`, c_citasnp.Url_videollamada   , ingreso.idModalidad , ingreso.idEntornoAtencion , ingreso.idTipoDiscapacidad   FROM  `g_persona` INNER JOIN `c_citasnp`  ON (`g_persona`.`Id` = `c_citasnp`.`Id_Usuario`) INNER JOIN `g_usuario` ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)  INNER JOIN `g_tipoedad`  ON (`g_persona`.`Id_TipoEdad` = `g_tipoedad`.`Id`)  INNER JOIN `ingreso`  ON (`ingreso`.`Id` = `c_citasnp`.`Id_ingreso`) INNER JOIN `f_empresacontxconvenio`  ON (`c_citasnp`.`Id_EmpresaCont` = `f_empresacontxconvenio`.`Id`) INNER JOIN `h_tipohistoria` ON (`c_clasecita`.`Id_Historia` = `h_tipohistoria`.`Id`) INNER JOIN `c_clasecita`  ON (`c_citasnp`.`Id_ClaseCita` = `c_clasecita`.`Id`) INNER JOIN `h_triage`  ON (`h_triage`.`IdIngreso` = `ingreso`.`Id`) INNER JOIN `h_atencion`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN `profesional1`  ON (`profesional1`.`Id_Persona` = `h_atencion`.`Id_Profesional`) AND (`profesional1`.`IdEspecialidad` = `h_atencion`.`Id_Especialidad`) WHERE (c_citasnp.Id_MotivoDesistida =0 AND profesional1.IdEspecialidad ='" + this.xid_especialidad + "' AND `c_citasnp`.`Fecha_Cita` ='" + this.xmt.formatoAMD.format(this.JDCFechaAgenda.getDate()) + "' AND c_citasnp.Id_Anulada=0  AND ingreso.Id_Sede='" + Principal.sedeUsuarioSeleccionadaDTO.getId() + "' AND h_triage.Es_Agendado='0' AND ingreso.Estado=0 and Asistida='" + this.xestadonp + "' )GROUP BY ingreso.Id  ORDER BY c_citasnp.HoraInicial ASC ";
                }
            } else if (JIFAgendaMedico.xidt == -1) {
                if (this.JCHFiltro.isSelected()) {
                    if (this.JCHFiltro_Profesional.isSelected()) {
                        sql = "SELECT g_usuario.NoHistoria, CONCAT(g_persona.`Apellido1`,' ',g_persona.`Apellido2`,' ',g_persona.`Nombre1`,' ',g_persona.`Nombre2`) AS NPersona, CONCAT(`g_persona`.`Edad`,' ' ,g_tipoedad.`Nbre`,'(s)') AS Edad, g_persona.`Id_Sexo`, c_clasecita.Nbre, DATE_FORMAT(c_citasnp.HoraInicial,'%h:%i%:%s %p') AS hora, ingreso.Id_Usuario , ingreso.Id, c_citasnp.Id_ClaseCita, c_clasecita.Id_Historia,     IF(c_citasnp.Asistida=0,'POR ATENCIÓN',IF(c_citasnp.Asistida=1,'EN ATENCIÓN','ATENDIDA')) AS Estado,   c_citasnp.Id,  c_citasnp.Id_MotivoDesistida, c_clasecita.Id_TipoCita, 1  AS Triage, '' AS MC, '' AS Observacion, c_clasecita.Id_Programa ,  c_citasnp.So,0 AS IdTriage , c_clasecita.EsControl,  c_citasnp.Id_TratamientoO,  profesional1.EsOdontologia, `f_empresacontxconvenio`.`Nbre` , `profesional1`.`NProfesional`, `c_clasecita`.EsP, ingreso.Id_TipoAtencion  ,IF(`ingreso`.`CEspecial` IS NULL, '0',`ingreso`.`CEspecial`) AS CEspecial,`h_tipohistoria`.`Forma`,g_persona.`FechaNac`,ingreso.`FechaIngreso`, c_citasnp.Url_videollamada   , ingreso.idModalidad , ingreso.idEntornoAtencion , ingreso.idTipoDiscapacidad   FROM c_citasnp    INNER JOIN `profesional1`  ON (`profesional1`.`Id_Persona` = `c_citasnp`.`Id_Profesional`)  AND (`profesional1`.`IdEspecialidad` = `c_citasnp`.`Id_Especialidad`)   INNER JOIN g_persona  ON (`g_persona`.`Id` = c_citasnp.Id_Usuario)   INNER JOIN c_clasecita  ON (c_citasnp.Id_ClaseCita = c_clasecita.Id)   INNER JOIN ingreso  ON (ingreso.Id = c_citasnp.Id_ingreso)   INNER JOIN g_usuario  ON (g_usuario.Id_persona = g_persona.`Id`)   INNER JOIN `g_tipoedad`  ON (`g_persona`.`Id_TipoEdad` = `g_tipoedad`.`Id`)  INNER JOIN `f_empresacontxconvenio`  ON (`c_citasnp`.`Id_EmpresaCont` = `f_empresacontxconvenio`.`Id`) INNER JOIN `h_tipohistoria` ON (`c_clasecita`.`Id_Historia` = `h_tipohistoria`.`Id`) WHERE (`ingreso`.`Id_TipoAtencion` =1  AND CONCAT(g_persona.`Apellido1`,' ',g_persona.`Apellido2`,' ',g_persona.`Nombre1`,' ',g_persona.`Nombre2`) like'%" + this.JTF.getText() + "%' and c_citasnp.Id_MotivoDesistida =0 AND c_citasnp.Id_Especialidad ='" + this.xid_especialidad + "' and `profesional1`.`Id_Persona`='" + this.xid_profesional + "' AND  c_citasnp.Fecha_Cita='" + this.xmt.formatoAMD.format(this.JDCFechaAgenda.getDate()) + "' AND c_citasnp.Id_Anulada=0 AND c_citasnp.`Id_Sede`='" + Principal.sedeUsuarioSeleccionadaDTO.getId() + "') GROUP BY ingreso.Id ORDER BY c_citasnp.HoraInicial ASC ";
                    } else {
                        sql = "SELECT g_usuario.NoHistoria, CONCAT(g_persona.`Apellido1`,' ',g_persona.`Apellido2`,' ',g_persona.`Nombre1`,' ',g_persona.`Nombre2`) AS NPersona, CONCAT(`g_persona`.`Edad`,' ' ,g_tipoedad.`Nbre`,'(s)') AS Edad, g_persona.`Id_Sexo`, c_clasecita.Nbre, DATE_FORMAT(c_citasnp.HoraInicial,'%h:%i%:%s %p') AS hora, ingreso.Id_Usuario , ingreso.Id, c_citasnp.Id_ClaseCita, c_clasecita.Id_Historia,     IF(c_citasnp.Asistida=0,'POR ATENCIÓN',IF(c_citasnp.Asistida=1,'EN ATENCIÓN','ATENDIDA')) AS Estado,   c_citasnp.Id,  c_citasnp.Id_MotivoDesistida, c_clasecita.Id_TipoCita, 1  AS Triage, '' AS MC, '' AS Observacion, c_clasecita.Id_Programa ,  c_citasnp.So,0 AS IdTriage , c_clasecita.EsControl,  c_citasnp.Id_TratamientoO,  profesional1.EsOdontologia, `f_empresacontxconvenio`.`Nbre` , `profesional1`.`NProfesional`, `c_clasecita`.EsP, ingreso.Id_TipoAtencion  ,IF(`ingreso`.`CEspecial` IS NULL, '0',`ingreso`.`CEspecial`) AS CEspecial,`h_tipohistoria`.`Forma`,g_persona.`FechaNac`,ingreso.`FechaIngreso`, c_citasnp.Url_videollamada   , ingreso.idModalidad , ingreso.idEntornoAtencion , ingreso.idTipoDiscapacidad   FROM c_citasnp    INNER JOIN `profesional1`  ON (`profesional1`.`Id_Persona` = `c_citasnp`.`Id_Profesional`)  AND (`profesional1`.`IdEspecialidad` = `c_citasnp`.`Id_Especialidad`)   INNER JOIN g_persona  ON (`g_persona`.`Id` = c_citasnp.Id_Usuario)   INNER JOIN c_clasecita  ON (c_citasnp.Id_ClaseCita = c_clasecita.Id)   INNER JOIN ingreso  ON (ingreso.Id = c_citasnp.Id_ingreso)   INNER JOIN g_usuario  ON (g_usuario.Id_persona = g_persona.`Id`)   INNER JOIN `g_tipoedad`  ON (`g_persona`.`Id_TipoEdad` = `g_tipoedad`.`Id`)  INNER JOIN `f_empresacontxconvenio`  ON (`c_citasnp`.`Id_EmpresaCont` = `f_empresacontxconvenio`.`Id`)  INNER JOIN `h_tipohistoria` ON (`c_clasecita`.`Id_Historia` = `h_tipohistoria`.`Id`) WHERE (`ingreso`.`Id_TipoAtencion` =1  AND  CONCAT(g_persona.`Apellido1`,' ',g_persona.`Apellido2`,' ',g_persona.`Nombre1`,' ',g_persona.`Nombre2`) like'%" + this.JTF.getText() + "%' and c_citasnp.Id_MotivoDesistida =0 AND c_citasnp.Id_Especialidad ='" + this.xid_especialidad + "' AND  c_citasnp.Fecha_Cita='" + this.xmt.formatoAMD.format(this.JDCFechaAgenda.getDate()) + "' AND c_citasnp.Id_Anulada=0 AND c_citasnp.`Id_Sede`='" + Principal.sedeUsuarioSeleccionadaDTO.getId() + "') GROUP BY ingreso.Id ORDER BY c_citasnp.HoraInicial ASC ";
                    }
                } else if (this.JCHFiltro_Profesional.isSelected()) {
                    sql = "SELECT g_usuario.NoHistoria, CONCAT(g_persona.`Apellido1`,' ',g_persona.`Apellido2`,' ',g_persona.`Nombre1`,' ',g_persona.`Nombre2`) AS NPersona, CONCAT(`g_persona`.`Edad`,' ' ,g_tipoedad.`Nbre`,'(s)') AS Edad, g_persona.`Id_Sexo`, c_clasecita.Nbre, DATE_FORMAT(c_citasnp.HoraInicial,'%h:%i%:%s %p') AS hora, ingreso.Id_Usuario , ingreso.Id, c_citasnp.Id_ClaseCita, c_clasecita.Id_Historia,     IF(c_citasnp.Asistida=0,'POR ATENCIÓN',IF(c_citasnp.Asistida=1,'EN ATENCIÓN','ATENDIDA')) AS Estado,   c_citasnp.Id,  c_citasnp.Id_MotivoDesistida, c_clasecita.Id_TipoCita, 1  AS Triage, '' AS MC, '' AS Observacion, c_clasecita.Id_Programa ,  c_citasnp.So,0 AS IdTriage , c_clasecita.EsControl,  c_citasnp.Id_TratamientoO,  profesional1.EsOdontologia, `f_empresacontxconvenio`.`Nbre` , `profesional1`.`NProfesional`, `c_clasecita`.EsP, ingreso.Id_TipoAtencion  ,IF(`ingreso`.`CEspecial` IS NULL, '0',`ingreso`.`CEspecial`) AS CEspecial,`h_tipohistoria`.`Forma`,g_persona.`FechaNac`,ingreso.`FechaIngreso`, c_citasnp.Url_videollamada   , ingreso.idModalidad , ingreso.idEntornoAtencion , ingreso.idTipoDiscapacidad   FROM c_citasnp    INNER JOIN `profesional1`  ON (`profesional1`.`Id_Persona` = `c_citasnp`.`Id_Profesional`)  AND (`profesional1`.`IdEspecialidad` = `c_citasnp`.`Id_Especialidad`)   INNER JOIN g_persona  ON (`g_persona`.`Id` = c_citasnp.Id_Usuario)   INNER JOIN c_clasecita  ON (c_citasnp.Id_ClaseCita = c_clasecita.Id)   INNER JOIN ingreso  ON (ingreso.Id = c_citasnp.Id_ingreso)   INNER JOIN g_usuario  ON (g_usuario.Id_persona = g_persona.`Id`)   INNER JOIN `g_tipoedad`  ON (`g_persona`.`Id_TipoEdad` = `g_tipoedad`.`Id`)  INNER JOIN `f_empresacontxconvenio`  ON (`c_citasnp`.`Id_EmpresaCont` = `f_empresacontxconvenio`.`Id`) INNER JOIN `h_tipohistoria` ON (`c_clasecita`.`Id_Historia` = `h_tipohistoria`.`Id`) WHERE ( `ingreso`.`Id_TipoAtencion` =1  AND  c_citasnp.Id_MotivoDesistida =0 and `profesional1`.`Id_Persona`='" + this.xid_profesional + "' AND c_citasnp.Id_Especialidad ='" + this.xid_especialidad + "' AND  c_citasnp.Fecha_Cita='" + this.xmt.formatoAMD.format(this.JDCFechaAgenda.getDate()) + "' AND c_citasnp.Id_Anulada=0 AND c_citasnp.`Id_Sede`='" + Principal.sedeUsuarioSeleccionadaDTO.getId() + "') GROUP BY ingreso.Id ORDER BY c_citasnp.HoraInicial ASC ";
                } else {
                    sql = "SELECT g_usuario.NoHistoria, CONCAT(g_persona.`Apellido1`,' ',g_persona.`Apellido2`,' ',g_persona.`Nombre1`,' ',g_persona.`Nombre2`) AS NPersona, CONCAT(`g_persona`.`Edad`,' ' ,g_tipoedad.`Nbre`,'(s)') AS Edad, g_persona.`Id_Sexo`, c_clasecita.Nbre, DATE_FORMAT(c_citasnp.HoraInicial,'%h:%i%:%s %p') AS hora, ingreso.Id_Usuario , ingreso.Id, c_citasnp.Id_ClaseCita, c_clasecita.Id_Historia,     IF(c_citasnp.Asistida=0,'POR ATENCIÓN',IF(c_citasnp.Asistida=1,'EN ATENCIÓN','ATENDIDA')) AS Estado,   c_citasnp.Id,  c_citasnp.Id_MotivoDesistida, c_clasecita.Id_TipoCita, 1  AS Triage, '' AS MC, '' AS Observacion, c_clasecita.Id_Programa ,  c_citasnp.So,0 AS IdTriage , c_clasecita.EsControl,  c_citasnp.Id_TratamientoO,   profesional1.EsOdontologia, `f_empresacontxconvenio`.`Nbre` , `profesional1`.`NProfesional`, `c_clasecita`.EsP, ingreso.Id_TipoAtencion  ,IF(`ingreso`.`CEspecial` IS NULL, '0',`ingreso`.`CEspecial`) AS CEspecial,`h_tipohistoria`.`Forma`,g_persona.`FechaNac`,ingreso.`FechaIngreso`, c_citasnp.Url_videollamada   , ingreso.idModalidad , ingreso.idEntornoAtencion , ingreso.idTipoDiscapacidad   FROM c_citasnp    INNER JOIN `profesional1`  ON (`profesional1`.`Id_Persona` = `c_citasnp`.`Id_Profesional`)  AND (`profesional1`.`IdEspecialidad` = `c_citasnp`.`Id_Especialidad`)   INNER JOIN g_persona  ON (`g_persona`.`Id` = c_citasnp.Id_Usuario)   INNER JOIN c_clasecita  ON (c_citasnp.Id_ClaseCita = c_clasecita.Id)   INNER JOIN ingreso  ON (ingreso.Id = c_citasnp.Id_ingreso)   INNER JOIN g_usuario  ON (g_usuario.Id_persona = g_persona.`Id`)   INNER JOIN `g_tipoedad`  ON (`g_persona`.`Id_TipoEdad` = `g_tipoedad`.`Id`)  INNER JOIN `f_empresacontxconvenio`  ON (`c_citasnp`.`Id_EmpresaCont` = `f_empresacontxconvenio`.`Id`) INNER JOIN `h_tipohistoria` ON (`c_clasecita`.`Id_Historia` = `h_tipohistoria`.`Id`) WHERE (`ingreso`.`Id_TipoAtencion` =1  AND c_citasnp.Id_MotivoDesistida =0 AND c_citasnp.Id_Especialidad ='" + this.xid_especialidad + "' AND  c_citasnp.Fecha_Cita='" + this.xmt.formatoAMD.format(this.JDCFechaAgenda.getDate()) + "' AND c_citasnp.Id_Anulada=0 AND c_citasnp.`Id_Sede`='" + Principal.sedeUsuarioSeleccionadaDTO.getId() + "') GROUP BY ingreso.Id ORDER BY c_citasnp.HoraInicial ASC ";
                }
            } else if (this.JCHFiltro.isSelected()) {
                if (this.JCHFiltro_Profesional.isSelected()) {
                    sql = "SELECT g_usuario.NoHistoria, CONCAT(g_persona.`Apellido1`,' ',g_persona.`Apellido2`,' ',g_persona.`Nombre1`,' ',g_persona.`Nombre2`) AS NPersona, CONCAT(`g_persona`.`Edad`,' ' ,g_tipoedad.`Nbre`,'(s)') AS `Edad`,  g_persona.`Id_Sexo`, c_clasecita.Nbre, DATE_FORMAT(c_citasnp.HoraInicial,'%h:%i%:%s %p') AS hora, ingreso.Id_Usuario , ingreso.Id, c_citasnp.Id_ClaseCita, c_clasecita.Id_Historia,     IF(c_citasnp.Asistida=0,'POR ATENCIÓN',IF(c_citasnp.Asistida=1,'EN ATENCIÓN','ATENDIDA')) AS Estado,   c_citasnp.Id,  c_citasnp.Id_MotivoDesistida, c_clasecita.Id_TipoCita, 1  AS Triage, '' AS MC, '' AS Observacion, c_clasecita.Id_Programa ,  c_citasnp.So,0 AS IdTriage , c_clasecita.EsControl,  c_citasnp.Id_TratamientoO,  profesional1.EsOdontologia, `f_empresacontxconvenio`.`Nbre` , `profesional1`.`NProfesional`, `c_clasecita`.EsP, ingreso.Id_TipoAtencion  ,IF(`ingreso`.`CEspecial` IS NULL, '0',`ingreso`.`CEspecial`) AS CEspecial,`h_tipohistoria`.`Forma`,g_persona.`FechaNac`,ingreso.`FechaIngreso`, c_citasnp.Url_videollamada   , ingreso.idModalidad , ingreso.idEntornoAtencion , ingreso.idTipoDiscapacidad   FROM c_citasnp    INNER JOIN `profesional1`  ON (`profesional1`.`Id_Persona` = `c_citasnp`.`Id_Profesional`)  AND (`profesional1`.`IdEspecialidad` = `c_citasnp`.`Id_Especialidad`)   INNER JOIN g_persona  ON (`g_persona`.`Id` = c_citasnp.Id_Usuario)   INNER JOIN `g_tipoedad`  ON (`g_persona`.`Id_TipoEdad` = `g_tipoedad`.`Id`)  INNER JOIN c_clasecita  ON (c_citasnp.Id_ClaseCita = c_clasecita.Id)   INNER JOIN ingreso  ON (ingreso.Id = c_citasnp.Id_ingreso)   INNER JOIN g_usuario  ON (g_usuario.Id_persona = `g_persona`.`Id`)  INNER JOIN `f_empresacontxconvenio`  ON (`c_citasnp`.`Id_EmpresaCont` = `f_empresacontxconvenio`.`Id`) INNER JOIN `h_tipohistoria` ON (`c_clasecita`.`Id_Historia` = `h_tipohistoria`.`Id`)  WHERE (C`ingreso`.`Id_TipoAtencion` =1  AND ONCAT(g_persona.`Apellido1`,' ',g_persona.`Apellido2`,' ',g_persona.`Nombre1`,' ',g_persona.`Nombre2`) like'%" + this.JTF.getText() + "%' and `profesional1`.`Id_Persona`='" + this.xid_profesional + "' and c_citasnp.Id_MotivoDesistida =0 AND c_citasnp.Id_Especialidad ='" + this.xid_especialidad + "' AND  c_citasnp.Fecha_Cita='" + this.xmt.formatoAMD.format(this.JDCFechaAgenda.getDate()) + "' AND c_citasnp.Id_Anulada=0 AND c_citasnp.`Id_Sede`='" + Principal.sedeUsuarioSeleccionadaDTO.getId() + "' and c_citasnp.Asistida='" + this.xestadonp + "') GROUP BY ingreso.Id ORDER BY c_citasnp.HoraInicial ASC ";
                } else {
                    sql = "SELECT g_usuario.NoHistoria, CONCAT(g_persona.`Apellido1`,' ',g_persona.`Apellido2`,' ',g_persona.`Nombre1`,' ',g_persona.`Nombre2`) AS NPersona, CONCAT(`g_persona`.`Edad`,' ' ,g_tipoedad.`Nbre`,'(s)') AS `Edad`,  g_persona.`Id_Sexo`, c_clasecita.Nbre, DATE_FORMAT(c_citasnp.HoraInicial,'%h:%i%:%s %p') AS hora, ingreso.Id_Usuario , ingreso.Id, c_citasnp.Id_ClaseCita, c_clasecita.Id_Historia,     IF(c_citasnp.Asistida=0,'POR ATENCIÓN',IF(c_citasnp.Asistida=1,'EN ATENCIÓN','ATENDIDA')) AS Estado,   c_citasnp.Id,  c_citasnp.Id_MotivoDesistida, c_clasecita.Id_TipoCita, 1  AS Triage, '' AS MC, '' AS Observacion, c_clasecita.Id_Programa ,  c_citasnp.So,0 AS IdTriage , c_clasecita.EsControl,  c_citasnp.Id_TratamientoO,  profesional1.EsOdontologia, `f_empresacontxconvenio`.`Nbre` , `profesional1`.`NProfesional`, `c_clasecita`.EsP, ingreso.Id_TipoAtencion  ,IF(`ingreso`.`CEspecial` IS NULL, '0',`ingreso`.`CEspecial`) AS CEspecial,`h_tipohistoria`.`Forma`,g_persona.`FechaNac`,ingreso.`FechaIngreso`, c_citasnp.Url_videollamada   , ingreso.idModalidad , ingreso.idEntornoAtencion , ingreso.idTipoDiscapacidad   FROM c_citasnp    INNER JOIN `profesional1`  ON (`profesional1`.`Id_Persona` = `c_citasnp`.`Id_Profesional`)  AND (`profesional1`.`IdEspecialidad` = `c_citasnp`.`Id_Especialidad`)   INNER JOIN g_persona  ON (`g_persona`.`Id` = c_citasnp.Id_Usuario)   INNER JOIN `g_tipoedad`  ON (`g_persona`.`Id_TipoEdad` = `g_tipoedad`.`Id`)  INNER JOIN c_clasecita  ON (c_citasnp.Id_ClaseCita = c_clasecita.Id)   INNER JOIN ingreso  ON (ingreso.Id = c_citasnp.Id_ingreso)   INNER JOIN g_usuario  ON (g_usuario.Id_persona = `g_persona`.`Id`)  INNER JOIN `f_empresacontxconvenio`  ON (`c_citasnp`.`Id_EmpresaCont` = `f_empresacontxconvenio`.`Id`) INNER JOIN `h_tipohistoria` ON (`c_clasecita`.`Id_Historia` = `h_tipohistoria`.`Id`)  WHERE (`ingreso`.`Id_TipoAtencion` =1  AND CONCAT(g_persona.`Apellido1`,' ',g_persona.`Apellido2`,' ',g_persona.`Nombre1`,' ',g_persona.`Nombre2`) like'%" + this.JTF.getText() + "%' and c_citasnp.Id_MotivoDesistida =0 AND c_citasnp.Id_Especialidad ='" + this.xid_especialidad + "' AND  c_citasnp.Fecha_Cita='" + this.xmt.formatoAMD.format(this.JDCFechaAgenda.getDate()) + "' AND c_citasnp.Id_Anulada=0 AND c_citasnp.`Id_Sede`='" + Principal.sedeUsuarioSeleccionadaDTO.getId() + "' and c_citasnp.Asistida='" + this.xestadonp + "') GROUP BY ingreso.Id ORDER BY c_citasnp.HoraInicial ASC ";
                }
            } else if (this.JCHFiltro_Profesional.isSelected()) {
                sql = "SELECT g_usuario.NoHistoria, CONCAT(g_persona.`Apellido1`,' ',g_persona.`Apellido2`,' ',g_persona.`Nombre1`,' ',g_persona.`Nombre2`)AS NPersona, CONCAT(`g_persona`.`Edad`,' ' ,g_tipoedad.`Nbre`,'(s)') AS `Edad`,  g_persona.`Id_Sexo`, c_clasecita.Nbre, DATE_FORMAT(c_citasnp.HoraInicial,'%h:%i%:%s %p') AS hora, ingreso.Id_Usuario , ingreso.Id, c_citasnp.Id_ClaseCita, c_clasecita.Id_Historia,     IF(c_citasnp.Asistida=0,'POR ATENCIÓN',IF(c_citasnp.Asistida=1,'EN ATENCIÓN','ATENDIDA')) AS Estado,   c_citasnp.Id,  c_citasnp.Id_MotivoDesistida, c_clasecita.Id_TipoCita, 1  AS Triage, '' AS MC, '' AS Observacion, c_clasecita.Id_Programa ,  c_citasnp.So,0 AS IdTriage , c_clasecita.EsControl,  c_citasnp.Id_TratamientoO,  profesional1.EsOdontologia, `f_empresacontxconvenio`.`Nbre` , `profesional1`.`NProfesional`, `c_clasecita`.EsP, ingreso.Id_TipoAtencion  ,IF(`ingreso`.`CEspecial` IS NULL, '0',`ingreso`.`CEspecial`) AS CEspecial,`h_tipohistoria`.`Forma`,g_persona.`FechaNac`,ingreso.`FechaIngreso`, c_citasnp.Url_videollamada   , ingreso.idModalidad , ingreso.idEntornoAtencion , ingreso.idTipoDiscapacidad   FROM c_citasnp    INNER JOIN `profesional1`  ON (`profesional1`.`Id_Persona` = `c_citasnp`.`Id_Profesional`)  AND (`profesional1`.`IdEspecialidad` = `c_citasnp`.`Id_Especialidad`)   INNER JOIN g_persona  ON (`g_persona`.`Id` = c_citasnp.Id_Usuario)   INNER JOIN `g_tipoedad`  ON (`g_persona`.`Id_TipoEdad` = `g_tipoedad`.`Id`)  INNER JOIN c_clasecita  ON (c_citasnp.Id_ClaseCita = c_clasecita.Id)   INNER JOIN ingreso  ON (ingreso.Id = c_citasnp.Id_ingreso)   INNER JOIN g_usuario  ON (g_usuario.Id_persona = `g_persona`.`Id`)  INNER JOIN `f_empresacontxconvenio`  ON (`c_citasnp`.`Id_EmpresaCont` = `f_empresacontxconvenio`.`Id`) INNER JOIN `h_tipohistoria` ON (`c_clasecita`.`Id_Historia` = `h_tipohistoria`.`Id`)  WHERE (`ingreso`.`Id_TipoAtencion` =1  AND  `profesional1`.`Id_Persona`='" + this.xid_profesional + "' and c_citasnp.Id_MotivoDesistida =0 AND c_citasnp.Id_Especialidad ='" + this.xid_especialidad + "' AND  c_citasnp.Fecha_Cita='" + this.xmt.formatoAMD.format(this.JDCFechaAgenda.getDate()) + "' AND c_citasnp.Id_Anulada=0 AND c_citasnp.`Id_Sede`='" + Principal.sedeUsuarioSeleccionadaDTO.getId() + "' and c_citasnp.Asistida='" + this.xestadonp + "') GROUP BY ingreso.Id ORDER BY c_citasnp.HoraInicial ASC ";
            } else {
                sql = "SELECT g_usuario.NoHistoria, CONCAT(g_persona.`Apellido1`,' ',g_persona.`Apellido2`,' ',g_persona.`Nombre1`,' ',g_persona.`Nombre2`)AS NPersona, CONCAT(`g_persona`.`Edad`,' ' ,g_tipoedad.`Nbre`,'(s)') AS `Edad`,  g_persona.`Id_Sexo`, c_clasecita.Nbre, DATE_FORMAT(c_citasnp.HoraInicial,'%h:%i%:%s %p') AS hora, ingreso.Id_Usuario , ingreso.Id, c_citasnp.Id_ClaseCita, c_clasecita.Id_Historia,     IF(c_citasnp.Asistida=0,'POR ATENCIÓN',IF(c_citasnp.Asistida=1,'EN ATENCIÓN','ATENDIDA')) AS Estado,   c_citasnp.Id,  c_citasnp.Id_MotivoDesistida, c_clasecita.Id_TipoCita, 1  AS Triage, '' AS MC, '' AS Observacion, c_clasecita.Id_Programa ,  c_citasnp.So,0 AS IdTriage , c_clasecita.EsControl,  c_citasnp.Id_TratamientoO,  profesional1.EsOdontologia, `f_empresacontxconvenio`.`Nbre` , `profesional1`.`NProfesional`, `c_clasecita`.EsP, ingreso.Id_TipoAtencion  ,IF(`ingreso`.`CEspecial` IS NULL, '0',`ingreso`.`CEspecial`) AS CEspecial,`h_tipohistoria`.`Forma`,g_persona.`FechaNac`,ingreso.`FechaIngreso`, c_citasnp.Url_videollamada   , ingreso.idModalidad , ingreso.idEntornoAtencion , ingreso.idTipoDiscapacidad   FROM c_citasnp    INNER JOIN `profesional1`  ON (`profesional1`.`Id_Persona` = `c_citasnp`.`Id_Profesional`)  AND (`profesional1`.`IdEspecialidad` = `c_citasnp`.`Id_Especialidad`)   INNER JOIN g_persona  ON (`g_persona`.`Id` = c_citasnp.Id_Usuario)   INNER JOIN `g_tipoedad`  ON (`g_persona`.`Id_TipoEdad` = `g_tipoedad`.`Id`)  INNER JOIN c_clasecita  ON (c_citasnp.Id_ClaseCita = c_clasecita.Id)   INNER JOIN ingreso  ON (ingreso.Id = c_citasnp.Id_ingreso)   INNER JOIN g_usuario  ON (g_usuario.Id_persona = `g_persona`.`Id`)  INNER JOIN `f_empresacontxconvenio`  ON (`c_citasnp`.`Id_EmpresaCont` = `f_empresacontxconvenio`.`Id`) INNER JOIN `h_tipohistoria` ON (`c_clasecita`.`Id_Historia` = `h_tipohistoria`.`Id`)  WHERE (`ingreso`.`Id_TipoAtencion` =1  AND c_citasnp.Id_MotivoDesistida =0 AND c_citasnp.Id_Especialidad ='" + this.xid_especialidad + "' AND  c_citasnp.Fecha_Cita='" + this.xmt.formatoAMD.format(this.JDCFechaAgenda.getDate()) + "' AND c_citasnp.Id_Anulada=0 AND c_citasnp.`Id_Sede`='" + Principal.sedeUsuarioSeleccionadaDTO.getId() + "' and c_citasnp.Asistida='" + this.xestadonp + "') GROUP BY ingreso.Id ORDER BY c_citasnp.HoraInicial ASC ";
            }
        } else if (JIFAgendaMedico.xidt == -1) {
            if (this.JCHFiltro.isSelected()) {
                if (this.JCHFiltro_Profesional.isSelected()) {
                    sql = "SELECT g_usuario.NoHistoria, CONCAT(`g_persona`.`Apellido1`, ' ', `g_persona`.`Apellido2`,' ',`g_persona`.`Nombre1`,' ',`g_persona`.`Nombre2`) AS NUsuario,CONCAT(`g_persona`.`Edad`,' ',IF(`g_persona`.`Id_TipoEdad`=1, 'Años',IF(`g_persona`.`Id_TipoEdad`=2,'Mes', 'Día')) ,'(s)') AS `Edad`,  `g_persona`.`Id_Sexo`, c_clasecita.Nbre, DATE_FORMAT(c_citasnp.HoraInicial,'%h:%i%:%s %p') AS hora, ingreso.Id_Usuario , ingreso.Id, c_citasnp.Id_ClaseCita, c_clasecita.Id_Historia,     IF(c_citasnp.Asistida=0,'POR ATENCIÓN',IF(c_citasnp.Asistida=1,'EN ATENCIÓN','ATENDIDA')) AS Estado,   c_citasnp.Id, c_citasnp.Id_MotivoDesistida, c_clasecita.Id_TipoCita, 1  AS Triage, '' AS MC, '' AS Observacion,  c_clasecita.Id_Programa ,  c_citasnp.So,0 AS IdTriage , c_clasecita.EsControl,  c_citasnp.Id_TratamientoO, profesional1.EsOdontologia, `f_empresacontxconvenio`.`Nbre` , `profesional1`.`NProfesional`, `c_clasecita`.EsP, ingreso.Id_TipoAtencion    ,IF(`ingreso`.`CEspecial` IS NULL, '0',`ingreso`.`CEspecial`) AS CEspecial,`h_tipohistoria`.`Forma`,g_persona.`FechaNac`,ingreso.`FechaIngreso`, c_citasnp.Url_videollamada   , ingreso.idModalidad , ingreso.idEntornoAtencion , ingreso.idTipoDiscapacidad   FROM `profesional1`   INNER JOIN `c_citasnp`   ON (`profesional1`.`Id_Persona` = `c_citasnp`.`Id_Profesional`) AND (`profesional1`.`IdEspecialidad` = `c_citasnp`.`Id_Especialidad`) INNER JOIN `g_usuario`   ON (`c_citasnp`.`Id_Usuario` = `g_usuario`.`Id_persona`)  INNER JOIN `c_clasecita`   ON (`c_citasnp`.`Id_ClaseCita` = `c_clasecita`.`Id`) INNER JOIN `f_empresacontxconvenio`   ON (`c_citasnp`.`Id_EmpresaCont` = `f_empresacontxconvenio`.`Id`)  INNER JOIN `g_persona`  ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`) INNER JOIN `ingreso`  ON (`ingreso`.`Id` = `c_citasnp`.`Id_ingreso`) INNER JOIN `h_tipohistoria` ON (`c_clasecita`.`Id_Historia` = `h_tipohistoria`.`Id`) WHERE (`ingreso`.`Id_TipoAtencion` =1  AND CONCAT(g_persona.`Apellido1`,' ',g_persona.`Apellido2`,' ',g_persona.`Nombre1`,' ',g_persona.`Nombre2`) like'%" + this.JTF.getText() + "%'  AND `profesional1`.`Id_Persona`='" + this.xid_profesional + "' and c_citasnp.Id_MotivoDesistida =0 AND c_citasnp.Id_Especialidad ='" + this.xid_especialidad + "' AND  c_citasnp.Fecha_Cita='" + this.xmt.formatoAMD1.format(this.JDCFechaAgenda.getDate()) + "' AND c_citasnp.Id_Anulada=0 AND c_citasnp.`Id_Sede`='" + Principal.sedeUsuarioSeleccionadaDTO.getId() + "' ) GROUP BY ingreso.Id ORDER BY c_citasnp.HoraInicial ASC ";
                } else {
                    sql = "SELECT g_usuario.NoHistoria, CONCAT(`g_persona`.`Apellido1`, ' ', `g_persona`.`Apellido2`,' ',`g_persona`.`Nombre1`,' ',`g_persona`.`Nombre2`) AS NUsuario,CONCAT(`g_persona`.`Edad`,' ',IF(`g_persona`.`Id_TipoEdad`=1, 'Años',IF(`g_persona`.`Id_TipoEdad`=2,'Mes', 'Día')) ,'(s)') AS `Edad`,  `g_persona`.`Id_Sexo`, c_clasecita.Nbre, DATE_FORMAT(c_citasnp.HoraInicial,'%h:%i%:%s %p') AS hora, ingreso.Id_Usuario , ingreso.Id, c_citasnp.Id_ClaseCita, c_clasecita.Id_Historia,     IF(c_citasnp.Asistida=0,'POR ATENCIÓN',IF(c_citasnp.Asistida=1,'EN ATENCIÓN','ATENDIDA')) AS Estado,   c_citasnp.Id, c_citasnp.Id_MotivoDesistida, c_clasecita.Id_TipoCita, 1  AS Triage, '' AS MC, '' AS Observacion,  c_clasecita.Id_Programa ,  c_citasnp.So,0 AS IdTriage , c_clasecita.EsControl,  c_citasnp.Id_TratamientoO, profesional1.EsOdontologia, `f_empresacontxconvenio`.`Nbre` , `profesional1`.`NProfesional`, `c_clasecita`.EsP, ingreso.Id_TipoAtencion    ,IF(`ingreso`.`CEspecial` IS NULL, '0',`ingreso`.`CEspecial`) AS CEspecial,`h_tipohistoria`.`Forma`,g_persona.`FechaNac`,ingreso.`FechaIngreso`, c_citasnp.Url_videollamada    , ingreso.idModalidad , ingreso.idEntornoAtencion , ingreso.idTipoDiscapacidad   FROM `profesional1`   INNER JOIN `c_citasnp`   ON (`profesional1`.`Id_Persona` = `c_citasnp`.`Id_Profesional`) AND (`profesional1`.`IdEspecialidad` = `c_citasnp`.`Id_Especialidad`) INNER JOIN `g_usuario`   ON (`c_citasnp`.`Id_Usuario` = `g_usuario`.`Id_persona`)  INNER JOIN `c_clasecita`   ON (`c_citasnp`.`Id_ClaseCita` = `c_clasecita`.`Id`) INNER JOIN `f_empresacontxconvenio`   ON (`c_citasnp`.`Id_EmpresaCont` = `f_empresacontxconvenio`.`Id`)  INNER JOIN `g_persona`  ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`) INNER JOIN `ingreso`  ON (`ingreso`.`Id` = `c_citasnp`.`Id_ingreso`) INNER JOIN `h_tipohistoria` ON (`c_clasecita`.`Id_Historia` = `h_tipohistoria`.`Id`) WHERE (`ingreso`.`Id_TipoAtencion` =1 AND CONCAT(g_persona.`Apellido1`,' ',g_persona.`Apellido2`,' ',g_persona.`Nombre1`,' ',g_persona.`Nombre2`) like'%" + this.JTF.getText() + "%'   AND c_citasnp.Id_MotivoDesistida =0 AND c_citasnp.Id_Especialidad ='" + this.xid_especialidad + "' AND  c_citasnp.Fecha_Cita='" + this.xmt.formatoAMD1.format(this.JDCFechaAgenda.getDate()) + "' AND c_citasnp.Id_Anulada=0 AND c_citasnp.`Id_Sede`='" + Principal.sedeUsuarioSeleccionadaDTO.getId() + "' ) GROUP BY ingreso.Id ORDER BY c_citasnp.HoraInicial ASC ";
                }
            } else if (this.JCHFiltro_Profesional.isSelected()) {
                sql = "SELECT g_usuario.NoHistoria, CONCAT(`g_persona`.`Apellido1`, ' ', `g_persona`.`Apellido2`,' ',`g_persona`.`Nombre1`,' ',`g_persona`.`Nombre2`) AS NUsuario,CONCAT(`g_persona`.`Edad`,' ',IF(`g_persona`.`Id_TipoEdad`=1, 'Años',IF(`g_persona`.`Id_TipoEdad`=2,'Mes', 'Día')) ,'(s)') AS `Edad`,  `g_persona`.`Id_Sexo`, c_clasecita.Nbre, DATE_FORMAT(c_citasnp.HoraInicial,'%h:%i%:%s %p') AS hora, ingreso.Id_Usuario , ingreso.Id, c_citasnp.Id_ClaseCita, c_clasecita.Id_Historia,     IF(c_citasnp.Asistida=0,'POR ATENCIÓN',IF(c_citasnp.Asistida=1,'EN ATENCIÓN','ATENDIDA')) AS Estado,   c_citasnp.Id, c_citasnp.Id_MotivoDesistida, c_clasecita.Id_TipoCita, 1  AS Triage, '' AS MC, '' AS Observacion,  c_clasecita.Id_Programa ,  c_citasnp.So,0 AS IdTriage , c_clasecita.EsControl,  c_citasnp.Id_TratamientoO, profesional1.EsOdontologia, `f_empresacontxconvenio`.`Nbre` , `profesional1`.`NProfesional`, `c_clasecita`.EsP, ingreso.Id_TipoAtencion    ,IF(`ingreso`.`CEspecial` IS NULL, '0',`ingreso`.`CEspecial`) AS CEspecial,`h_tipohistoria`.`Forma`,g_persona.`FechaNac`,ingreso.`FechaIngreso`, c_citasnp.Url_videollamada    , ingreso.idModalidad , ingreso.idEntornoAtencion , ingreso.idTipoDiscapacidad   FROM `profesional1`   INNER JOIN `c_citasnp`   ON (`profesional1`.`Id_Persona` = `c_citasnp`.`Id_Profesional`) AND (`profesional1`.`IdEspecialidad` = `c_citasnp`.`Id_Especialidad`) INNER JOIN `g_usuario`   ON (`c_citasnp`.`Id_Usuario` = `g_usuario`.`Id_persona`)  INNER JOIN `c_clasecita`   ON (`c_citasnp`.`Id_ClaseCita` = `c_clasecita`.`Id`) INNER JOIN `f_empresacontxconvenio`   ON (`c_citasnp`.`Id_EmpresaCont` = `f_empresacontxconvenio`.`Id`)  INNER JOIN `g_persona`  ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`) INNER JOIN `ingreso`  ON (`ingreso`.`Id` = `c_citasnp`.`Id_ingreso`) INNER JOIN `h_tipohistoria` ON (`c_clasecita`.`Id_Historia` = `h_tipohistoria`.`Id`) WHERE (`ingreso`.`Id_TipoAtencion` =1  AND `profesional1`.`Id_Persona`='" + this.xid_profesional + "' and c_citasnp.Id_MotivoDesistida =0 AND c_citasnp.Id_Especialidad ='" + this.xid_especialidad + "' AND  c_citasnp.Fecha_Cita='" + this.xmt.formatoAMD1.format(this.JDCFechaAgenda.getDate()) + "' AND c_citasnp.Id_Anulada=0 AND c_citasnp.`Id_Sede`='" + Principal.sedeUsuarioSeleccionadaDTO.getId() + "' ) GROUP BY ingreso.Id ORDER BY c_citasnp.HoraInicial ASC ";
            } else {
                sql = "SELECT g_usuario.NoHistoria, CONCAT(`g_persona`.`Apellido1`, ' ', `g_persona`.`Apellido2`,' ',`g_persona`.`Nombre1`,' ',`g_persona`.`Nombre2`) AS NUsuario,CONCAT(`g_persona`.`Edad`,' ',IF(`g_persona`.`Id_TipoEdad`=1, 'Años',IF(`g_persona`.`Id_TipoEdad`=2,'Mes', 'Día')) ,'(s)') AS `Edad`,  `g_persona`.`Id_Sexo`, c_clasecita.Nbre, DATE_FORMAT(c_citasnp.HoraInicial,'%h:%i%:%s %p') AS hora, ingreso.Id_Usuario , ingreso.Id, c_citasnp.Id_ClaseCita, c_clasecita.Id_Historia,     IF(c_citasnp.Asistida=0,'POR ATENCIÓN',IF(c_citasnp.Asistida=1,'EN ATENCIÓN','ATENDIDA')) AS Estado,   c_citasnp.Id, c_citasnp.Id_MotivoDesistida, c_clasecita.Id_TipoCita, 1  AS Triage, '' AS MC, '' AS Observacion,  c_clasecita.Id_Programa ,  c_citasnp.So,0 AS IdTriage , c_clasecita.EsControl,  c_citasnp.Id_TratamientoO, profesional1.EsOdontologia, `f_empresacontxconvenio`.`Nbre` , `profesional1`.`NProfesional`, `c_clasecita`.EsP, ingreso.Id_TipoAtencion    ,IF(`ingreso`.`CEspecial` IS NULL, '0',`ingreso`.`CEspecial`) AS CEspecial,`h_tipohistoria`.`Forma`,g_persona.`FechaNac`,ingreso.`FechaIngreso` , c_citasnp.Url_videollamada   , ingreso.idModalidad , ingreso.idEntornoAtencion , ingreso.idTipoDiscapacidad  FROM `profesional1`   INNER JOIN `c_citasnp`   ON (`profesional1`.`Id_Persona` = `c_citasnp`.`Id_Profesional`) AND (`profesional1`.`IdEspecialidad` = `c_citasnp`.`Id_Especialidad`) INNER JOIN `g_usuario`   ON (`c_citasnp`.`Id_Usuario` = `g_usuario`.`Id_persona`)  INNER JOIN `c_clasecita`   ON (`c_citasnp`.`Id_ClaseCita` = `c_clasecita`.`Id`) INNER JOIN `f_empresacontxconvenio`   ON (`c_citasnp`.`Id_EmpresaCont` = `f_empresacontxconvenio`.`Id`)  INNER JOIN `g_persona`  ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`) INNER JOIN `ingreso`  ON (`ingreso`.`Id` = `c_citasnp`.`Id_ingreso`) INNER JOIN `h_tipohistoria` ON (`c_clasecita`.`Id_Historia` = `h_tipohistoria`.`Id`) WHERE (`ingreso`.`Id_TipoAtencion` =1  AND c_citasnp.Id_MotivoDesistida =0 AND c_citasnp.Id_Especialidad ='" + this.xid_especialidad + "' AND  c_citasnp.Fecha_Cita='" + this.xmt.formatoAMD1.format(this.JDCFechaAgenda.getDate()) + "' AND c_citasnp.Id_Anulada=0 AND c_citasnp.`Id_Sede`='" + Principal.sedeUsuarioSeleccionadaDTO.getId() + "' ) GROUP BY ingreso.Id ORDER BY c_citasnp.HoraInicial ASC ";
            }
        } else if (this.JCHFiltro.isSelected()) {
            if (this.JCHFiltro_Profesional.isSelected()) {
                sql = "SELECT g_usuario.NoHistoria, CONCAT(`g_persona`.`Apellido1`, ' ', `g_persona`.`Apellido2`,' ',`g_persona`.`Nombre1`,' ',`g_persona`.`Nombre2`) AS NUsuario,CONCAT(`g_persona`.`Edad`,' ',IF(`g_persona`.`Id_TipoEdad`=1, 'Años',IF(`g_persona`.`Id_TipoEdad`=2,'Mes', 'Día')) ,'(s)') AS `Edad`,  `g_persona`.`Id_Sexo`, c_clasecita.Nbre, DATE_FORMAT(c_citasnp.HoraInicial,'%h:%i%:%s %p') AS hora, ingreso.Id_Usuario , ingreso.Id, c_citasnp.Id_ClaseCita, c_clasecita.Id_Historia,     IF(c_citasnp.Asistida=0,'POR ATENCIÓN',IF(c_citasnp.Asistida=1,'EN ATENCIÓN','ATENDIDA')) AS Estado,   c_citasnp.Id, c_citasnp.Id_MotivoDesistida, c_clasecita.Id_TipoCita, 1  AS Triage, '' AS MC, '' AS Observacion,  c_clasecita.Id_Programa ,  c_citasnp.So,0 AS IdTriage , c_clasecita.EsControl,  c_citasnp.Id_TratamientoO, profesional1.EsOdontologia, `f_empresacontxconvenio`.`Nbre` , `profesional1`.`NProfesional`, `c_clasecita`.EsP, ingreso.Id_TipoAtencion    ,IF(`ingreso`.`CEspecial` IS NULL, '0',`ingreso`.`CEspecial`) AS CEspecial,`h_tipohistoria`.`Forma`,g_persona.`FechaNac`,ingreso.`FechaIngreso`, c_citasnp.Url_videollamada   , ingreso.idModalidad , ingreso.idEntornoAtencion , ingreso.idTipoDiscapacidad   FROM `profesional1`   INNER JOIN `c_citasnp`   ON (`profesional1`.`Id_Persona` = `c_citasnp`.`Id_Profesional`) AND (`profesional1`.`IdEspecialidad` = `c_citasnp`.`Id_Especialidad`) INNER JOIN `g_usuario`   ON (`c_citasnp`.`Id_Usuario` = `g_usuario`.`Id_persona`)  INNER JOIN `c_clasecita`   ON (`c_citasnp`.`Id_ClaseCita` = `c_clasecita`.`Id`) INNER JOIN ingreso  ON (ingreso.Id = c_citasnp.Id_ingreso)  INNER JOIN g_usuario  ON (g_usuario.Id_persona =g_persona.`Id`)  INNER JOIN `f_empresacontxconvenio`  ON (`c_citasnp`.`Id_EmpresaCont` = `f_empresacontxconvenio`.`Id`) INNER JOIN `h_tipohistoria` ON (`c_clasecita`.`Id_Historia` = `h_tipohistoria`.`Id`) WHERE (`ingreso`.`Id_TipoAtencion` =1  AND CONCAT(g_persona.`Apellido1`,' ',g_persona.`Apellido2`,' ',g_persona.`Nombre1`,' ',g_persona.`Nombre2`) like'%" + this.JTF.getText() + "%'  AND `profesional1`.`Id_Persona`='" + this.xid_profesional + "' and c_citasnp.Id_MotivoDesistida =0 AND c_citasnp.Id_Especialidad ='" + this.xid_especialidad + "' AND  c_citasnp.Fecha_Cita='" + this.xmt.formatoAMD1.format(this.JDCFechaAgenda.getDate()) + "' AND c_citasnp.Id_Anulada=0 AND c_citasnp.`Id_Sede`='" + Principal.sedeUsuarioSeleccionadaDTO.getId() + "' and c_citasnp.Asistida='" + this.xestadonp + "') GROUP BY ingreso.Id ORDER BY c_citasnp.HoraInicial ASC ";
            } else {
                sql = "SELECT g_usuario.NoHistoria, CONCAT(`g_persona`.`Apellido1`, ' ', `g_persona`.`Apellido2`,' ',`g_persona`.`Nombre1`,' ',`g_persona`.`Nombre2`) AS NUsuario,CONCAT(`g_persona`.`Edad`,' ',IF(`g_persona`.`Id_TipoEdad`=1, 'Años',IF(`g_persona`.`Id_TipoEdad`=2,'Mes', 'Día')) ,'(s)') AS `Edad`,  `g_persona`.`Id_Sexo`, c_clasecita.Nbre, DATE_FORMAT(c_citasnp.HoraInicial,'%h:%i%:%s %p') AS hora, ingreso.Id_Usuario , ingreso.Id, c_citasnp.Id_ClaseCita, c_clasecita.Id_Historia,     IF(c_citasnp.Asistida=0,'POR ATENCIÓN',IF(c_citasnp.Asistida=1,'EN ATENCIÓN','ATENDIDA')) AS Estado,   c_citasnp.Id, c_citasnp.Id_MotivoDesistida, c_clasecita.Id_TipoCita, 1  AS Triage, '' AS MC, '' AS Observacion,  c_clasecita.Id_Programa ,  c_citasnp.So,0 AS IdTriage , c_clasecita.EsControl,  c_citasnp.Id_TratamientoO, profesional1.EsOdontologia, `f_empresacontxconvenio`.`Nbre` , `profesional1`.`NProfesional`, `c_clasecita`.EsP, ingreso.Id_TipoAtencion    ,IF(`ingreso`.`CEspecial` IS NULL, '0',`ingreso`.`CEspecial`) AS CEspecial,`h_tipohistoria`.`Forma`,g_persona.`FechaNac`,ingreso.`FechaIngreso`, c_citasnp.Url_videollamada   , ingreso.idModalidad , ingreso.idEntornoAtencion , ingreso.idTipoDiscapacidad  FROM `profesional1`   INNER JOIN `c_citasnp`   ON (`profesional1`.`Id_Persona` = `c_citasnp`.`Id_Profesional`) AND (`profesional1`.`IdEspecialidad` = `c_citasnp`.`Id_Especialidad`) INNER JOIN `g_usuario`   ON (`c_citasnp`.`Id_Usuario` = `g_usuario`.`Id_persona`)  INNER JOIN `c_clasecita`   ON (`c_citasnp`.`Id_ClaseCita` = `c_clasecita`.`Id`) INNER JOIN ingreso  ON (ingreso.Id = c_citasnp.Id_ingreso)  INNER JOIN g_usuario  ON (g_usuario.Id_persona =g_persona.`Id`)  INNER JOIN `f_empresacontxconvenio`  ON (`c_citasnp`.`Id_EmpresaCont` = `f_empresacontxconvenio`.`Id`) INNER JOIN `h_tipohistoria` ON (`c_clasecita`.`Id_Historia` = `h_tipohistoria`.`Id`) WHERE (`ingreso`.`Id_TipoAtencion` =1  AND CONCAT(g_persona.`Apellido1`,' ',g_persona.`Apellido2`,' ',g_persona.`Nombre1`,' ',g_persona.`Nombre2`) like'%" + this.JTF.getText() + "%'  AND c_citasnp.Id_MotivoDesistida =0 AND c_citasnp.Id_Especialidad ='" + this.xid_especialidad + "' AND  c_citasnp.Fecha_Cita='" + this.xmt.formatoAMD1.format(this.JDCFechaAgenda.getDate()) + "' AND c_citasnp.Id_Anulada=0 AND c_citasnp.`Id_Sede`='" + Principal.sedeUsuarioSeleccionadaDTO.getId() + "' and c_citasnp.Asistida='" + this.xestadonp + "') GROUP BY ingreso.Id ORDER BY c_citasnp.HoraInicial ASC ";
            }
        } else if (this.JCHFiltro_Profesional.isSelected()) {
            sql = "SELECT g_usuario.NoHistoria, CONCAT(`g_persona`.`Apellido1`, ' ', `g_persona`.`Apellido2`,' ',`g_persona`.`Nombre1`,' ',`g_persona`.`Nombre2`) AS NUsuario,CONCAT(`g_persona`.`Edad`,' ',IF(`g_persona`.`Id_TipoEdad`=1, 'Años',IF(`g_persona`.`Id_TipoEdad`=2,'Mes', 'Día')) ,'(s)') AS `Edad`,  `g_persona`.`Id_Sexo`, c_clasecita.Nbre, DATE_FORMAT(c_citasnp.HoraInicial,'%h:%i%:%s %p') AS hora, ingreso.Id_Usuario , ingreso.Id, c_citasnp.Id_ClaseCita, c_clasecita.Id_Historia,     IF(c_citasnp.Asistida=0,'POR ATENCIÓN',IF(c_citasnp.Asistida=1,'EN ATENCIÓN','ATENDIDA')) AS Estado,   c_citasnp.Id, c_citasnp.Id_MotivoDesistida, c_clasecita.Id_TipoCita, 1  AS Triage, '' AS MC, '' AS Observacion,  c_clasecita.Id_Programa ,  c_citasnp.So,0 AS IdTriage , c_clasecita.EsControl,  c_citasnp.Id_TratamientoO, profesional1.EsOdontologia, `f_empresacontxconvenio`.`Nbre` , `profesional1`.`NProfesional`, `c_clasecita`.EsP, ingreso.Id_TipoAtencion    ,IF(`ingreso`.`CEspecial` IS NULL, '0',`ingreso`.`CEspecial`) AS CEspecial,`h_tipohistoria`.`Forma`,g_persona.`FechaNac`,ingreso.`FechaIngreso`, c_citasnp.Url_videollamada   , ingreso.idModalidad , ingreso.idEntornoAtencion , ingreso.idTipoDiscapacidad   FROM `profesional1`   INNER JOIN `c_citasnp`   ON (`profesional1`.`Id_Persona` = `c_citasnp`.`Id_Profesional`) AND (`profesional1`.`IdEspecialidad` = `c_citasnp`.`Id_Especialidad`) INNER JOIN `g_usuario`   ON (`c_citasnp`.`Id_Usuario` = `g_usuario`.`Id_persona`)  INNER JOIN `c_clasecita`   ON (`c_citasnp`.`Id_ClaseCita` = `c_clasecita`.`Id`) INNER JOIN ingreso  ON (ingreso.Id = c_citasnp.Id_ingreso)  INNER JOIN g_usuario  ON (g_usuario.Id_persona =g_persona.`Id`)  INNER JOIN `f_empresacontxconvenio`  ON (`c_citasnp`.`Id_EmpresaCont` = `f_empresacontxconvenio`.`Id`)  INNER JOIN `h_tipohistoria` ON (`c_clasecita`.`Id_Historia` = `h_tipohistoria`.`Id`) WHERE (`ingreso`.`Id_TipoAtencion` =1  AND `profesional1`.`Id_Persona`='" + this.xid_profesional + "' and c_citasnp.Id_MotivoDesistida =0 AND c_citasnp.Id_Especialidad ='" + this.xid_especialidad + "' AND  c_citasnp.Fecha_Cita='" + this.xmt.formatoAMD1.format(this.JDCFechaAgenda.getDate()) + "' AND c_citasnp.Id_Anulada=0 AND c_citasnp.`Id_Sede`='" + Principal.sedeUsuarioSeleccionadaDTO.getId() + "' and c_citasnp.Asistida='" + this.xestadonp + "') GROUP BY ingreso.Id ORDER BY c_citasnp.HoraInicial ASC ";
        } else {
            sql = "SELECT g_usuario.NoHistoria, CONCAT(`g_persona`.`Apellido1`, ' ', `g_persona`.`Apellido2`,' ',`g_persona`.`Nombre1`,' ',`g_persona`.`Nombre2`) AS NUsuario,CONCAT(`g_persona`.`Edad`,' ',IF(`g_persona`.`Id_TipoEdad`=1, 'Años',IF(`g_persona`.`Id_TipoEdad`=2,'Mes', 'Día')) ,'(s)') AS `Edad`,  `g_persona`.`Id_Sexo`, c_clasecita.Nbre, DATE_FORMAT(c_citasnp.HoraInicial,'%h:%i%:%s %p') AS hora, ingreso.Id_Usuario , ingreso.Id, c_citasnp.Id_ClaseCita, c_clasecita.Id_Historia,     IF(c_citasnp.Asistida=0,'POR ATENCIÓN',IF(c_citasnp.Asistida=1,'EN ATENCIÓN','ATENDIDA')) AS Estado,   c_citasnp.Id, c_citasnp.Id_MotivoDesistida, c_clasecita.Id_TipoCita, 1  AS Triage, '' AS MC, '' AS Observacion,  c_clasecita.Id_Programa ,  c_citasnp.So,0 AS IdTriage , c_clasecita.EsControl,  c_citasnp.Id_TratamientoO, profesional1.EsOdontologia, `f_empresacontxconvenio`.`Nbre` , `profesional1`.`NProfesional`, `c_clasecita`.EsP, ingreso.Id_TipoAtencion    ,IF(`ingreso`.`CEspecial` IS NULL, '0',`ingreso`.`CEspecial`) AS CEspecial,`h_tipohistoria`.`Forma`,g_persona.`FechaNac`,ingreso.`FechaIngreso`, c_citasnp.Url_videollamada   , ingreso.idModalidad , ingreso.idEntornoAtencion , ingreso.idTipoDiscapacidad   FROM `profesional1`   INNER JOIN `c_citasnp`   ON (`profesional1`.`Id_Persona` = `c_citasnp`.`Id_Profesional`) AND (`profesional1`.`IdEspecialidad` = `c_citasnp`.`Id_Especialidad`) INNER JOIN `g_usuario`   ON (`c_citasnp`.`Id_Usuario` = `g_usuario`.`Id_persona`)  INNER JOIN `c_clasecita`   ON (`c_citasnp`.`Id_ClaseCita` = `c_clasecita`.`Id`) INNER JOIN ingreso  ON (ingreso.Id = c_citasnp.Id_ingreso)  INNER JOIN g_usuario  ON (g_usuario.Id_persona =g_persona.`Id`)  INNER JOIN `f_empresacontxconvenio`  ON (`c_citasnp`.`Id_EmpresaCont` = `f_empresacontxconvenio`.`Id`) INNER JOIN `h_tipohistoria` ON (`c_clasecita`.`Id_Historia` = `h_tipohistoria`.`Id`) WHERE (`ingreso`.`Id_TipoAtencion` =1  AND c_citasnp.Id_MotivoDesistida =0 AND c_citasnp.Id_Especialidad ='" + this.xid_especialidad + "' AND  c_citasnp.Fecha_Cita='" + this.xmt.formatoAMD1.format(this.JDCFechaAgenda.getDate()) + "' AND c_citasnp.Id_Anulada=0 AND c_citasnp.`Id_Sede`='" + Principal.sedeUsuarioSeleccionadaDTO.getId() + "' and c_citasnp.Asistida='" + this.xestadonp + "') GROUP BY ingreso.Id ORDER BY c_citasnp.HoraInicial ASC ";
        }
        ConsultasMySQL xmt = new ConsultasMySQL();
        ResultSet rs = xmt.traerRs(sql);
        try {
            if (rs.next()) {
                rs.beforeFirst();
                int i = 0;
                this.xmt.mEstablecerTextEditor(this.JTAgendaNP, 4);
                this.xmt.mEstablecerTextEditor(this.JTAgendaNP, 15);
                this.xmt.mEstablecerTextEditor(this.JTAgendaNP, 23);
                this.xmt.mEstablecerTextEditor(this.JTAgendaNP, 24);
                this.xmt.mEstablecerTextEditor(this.JTAgendaNP, 33);
                while (rs.next()) {
                    this.xmodelo1.addRow(this.xdato);
                    this.xmodelo1.setValueAt(rs.getString(1), i, 0);
                    this.xmodelo1.setValueAt(rs.getString(2), i, 1);
                    this.xmodelo1.setValueAt(rs.getString(3), i, 2);
                    this.xmodelo1.setValueAt(rs.getString(4), i, 3);
                    this.xmodelo1.setValueAt(rs.getString(5), i, 4);
                    this.xmodelo1.setValueAt(rs.getString(6), i, 5);
                    this.xmodelo1.setValueAt(Long.valueOf(rs.getLong(7)), i, 6);
                    this.xmodelo1.setValueAt(Long.valueOf(rs.getLong(8)), i, 7);
                    this.xmodelo1.setValueAt(Long.valueOf(rs.getLong(9)), i, 8);
                    this.xmodelo1.setValueAt(Long.valueOf(rs.getLong(10)), i, 9);
                    this.xmodelo1.setValueAt(rs.getString(11), i, 10);
                    this.xmodelo1.setValueAt(Long.valueOf(rs.getLong(12)), i, 11);
                    this.xmodelo1.setValueAt(Integer.valueOf(rs.getInt(13)), i, 12);
                    this.xmodelo1.setValueAt(Integer.valueOf(rs.getInt(14)), i, 13);
                    this.xmodelo1.setValueAt(Integer.valueOf(rs.getInt(15)), i, 14);
                    this.xmodelo1.setValueAt(rs.getString(16), i, 15);
                    this.xmodelo1.setValueAt(rs.getString(17), i, 16);
                    this.xmodelo1.setValueAt(Long.valueOf(rs.getLong(18)), i, 17);
                    this.xmodelo1.setValueAt(Integer.valueOf(rs.getInt(19)), i, 18);
                    this.xmodelo1.setValueAt(Long.valueOf(rs.getLong(20)), i, 19);
                    this.xmodelo1.setValueAt(Integer.valueOf(rs.getInt(21)), i, 20);
                    this.xmodelo1.setValueAt(Integer.valueOf(rs.getInt(22)), i, 21);
                    this.xmodelo1.setValueAt(Integer.valueOf(rs.getInt(23)), i, 22);
                    this.xmodelo1.setValueAt(rs.getString(24), i, 23);
                    this.xmodelo1.setValueAt(rs.getString(25), i, 24);
                    this.xmodelo1.setValueAt(Integer.valueOf(i + 1), i, 25);
                    this.xmodelo1.setValueAt(Integer.valueOf(rs.getInt(26)), i, 26);
                    this.xmodelo1.setValueAt(Integer.valueOf(rs.getInt("Id_TipoAtencion")), i, 27);
                    this.xmodelo1.setValueAt(Long.valueOf(rs.getLong("CEspecial")), i, 28);
                    this.xmodelo1.setValueAt(Integer.valueOf(rs.getInt("Forma")), i, 30);
                    this.xmodelo1.setValueAt(rs.getString("FechaNac"), i, 31);
                    this.xmodelo1.setValueAt(rs.getString("FechaIngreso"), i, 32);
                    this.xmodelo1.setValueAt(rs.getString("Url_videollamada"), i, 33);
                    this.xmodelo1.setValueAt(Integer.valueOf(rs.getInt("idModalidad")), i, 35);
                    this.xmodelo1.setValueAt(Integer.valueOf(rs.getInt("idEntornoAtencion")), i, 36);
                    this.xmodelo1.setValueAt(Integer.valueOf(rs.getInt("idTipoDiscapacidad")), i, 37);
                    System.out.println(rs.getString(1));
                    buscaarPacientes(rs.getString(1));
                    if (this.num == 0) {
                        this.xmodelo1.setValueAt(new JButton("Llamar "), i, 34);
                    } else {
                        this.xmodelo1.setValueAt(new JButton("Llamado " + this.num), i, 34);
                    }
                    if (rs.getLong("CEspecial") == 1) {
                        this.xmodelo1.setValueAt(new JLabel(new ImageIcon(getClass().getResource("/Imagenes/Atencion Discapasitaods.png"))), i, 29);
                    } else if (rs.getLong("CEspecial") == 2) {
                        this.xmodelo1.setValueAt(new JLabel(new ImageIcon(getClass().getResource("/Imagenes/Atencion Embarazada.png"))), i, 29);
                    } else if (rs.getLong("CEspecial") == 3) {
                        this.xmodelo1.setValueAt(new JLabel(new ImageIcon(getClass().getResource("/Imagenes/Atencion Ancianos.png"))), i, 29);
                    } else if (rs.getLong("CEspecial") == 4) {
                        this.xmodelo1.setValueAt(new JLabel(new ImageIcon(getClass().getResource("/Imagenes/AtpNiños.png"))), i, 29);
                    } else {
                        this.xmodelo1.setValueAt(new JLabel(""), i, 29);
                    }
                    this.JTAgendaNP.setDefaultRenderer(JLabel.class, new Render(rs.getInt("CEspecial"), 28));
                    this.JTAgendaNP.setDefaultRenderer(Object.class, new MiRender1());
                    i++;
                }
                this.JLBNPRegistro.setText("" + i);
            } else {
                this.JLBNPRegistro.setText("0");
            }
            rs.close();
            xmt.cerrarConexionBd();
        } catch (SQLException e) {
        }
    }

    private void buscaarPacientes(String documento) {
        new ArrayList();
        this.num = 0;
        List<LlamadasEntity> list = this.llamadasService.ListarPacientes(documento, Principal.consultorio);
        System.out.println(list.toString());
        if (!list.isEmpty()) {
            this.num = list.size();
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTablaAgenda_Urgencias() {
        this.xmodelo_urgencias = new DefaultTableModel(new Object[0], new String[]{"Id_Ingreso", "Fecha", "Hora", "No. Historia", "Usuario", "Sexo", "Edad", "Empresa", "Cama", "FEgreso", "Egreso", "Estado", "Id_Persona", "Id_HC", "Asignación", "Tipo_Atencion", "Profesional", "Id_ClaseCitas", "Tipo_Grabado", "Urgente", "Tipo_A", "CEspecial", "CTriage", "Id_Programa", "idModalidad", "idEntornoAtencion", "idTipoDiscapacidad"}) { // from class: Historia.JIFAgendaMedico_N.36
            Class[] types = {Long.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Integer.class, String.class, Long.class, Long.class, Long.class, Integer.class, String.class, Long.class, Long.class, Integer.class, Integer.class, JLabel.class, Long.class, Long.class, Integer.class, Integer.class, Integer.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTAgendaU.setModel(this.xmodelo_urgencias);
        this.JTAgendaU.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTAgendaU.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTAgendaU.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTAgendaU.getColumnModel().getColumn(1).setPreferredWidth(20);
        this.JTAgendaU.getColumnModel().getColumn(2).setPreferredWidth(10);
        this.JTAgendaU.getColumnModel().getColumn(3).setPreferredWidth(30);
        this.JTAgendaU.getColumnModel().getColumn(4).setPreferredWidth(150);
        this.JTAgendaU.getColumnModel().getColumn(5).setPreferredWidth(5);
        this.JTAgendaU.getColumnModel().getColumn(6).setPreferredWidth(10);
        this.JTAgendaU.getColumnModel().getColumn(7).setPreferredWidth(150);
        this.JTAgendaU.getColumnModel().getColumn(8).setPreferredWidth(50);
        this.JTAgendaU.getColumnModel().getColumn(9).setPreferredWidth(20);
        this.JTAgendaU.getColumnModel().getColumn(10).setPreferredWidth(0);
        this.JTAgendaU.getColumnModel().getColumn(10).setMinWidth(0);
        this.JTAgendaU.getColumnModel().getColumn(10).setMaxWidth(0);
        this.JTAgendaU.getColumnModel().getColumn(11).setPreferredWidth(0);
        this.JTAgendaU.getColumnModel().getColumn(11).setMinWidth(0);
        this.JTAgendaU.getColumnModel().getColumn(11).setMaxWidth(0);
        this.JTAgendaU.getColumnModel().getColumn(12).setPreferredWidth(0);
        this.JTAgendaU.getColumnModel().getColumn(12).setMinWidth(0);
        this.JTAgendaU.getColumnModel().getColumn(12).setMaxWidth(0);
        this.JTAgendaU.getColumnModel().getColumn(13).setPreferredWidth(0);
        this.JTAgendaU.getColumnModel().getColumn(13).setMinWidth(0);
        this.JTAgendaU.getColumnModel().getColumn(13).setMaxWidth(0);
        this.JTAgendaU.getColumnModel().getColumn(14).setPreferredWidth(0);
        this.JTAgendaU.getColumnModel().getColumn(14).setMinWidth(0);
        this.JTAgendaU.getColumnModel().getColumn(14).setMaxWidth(0);
        this.JTAgendaU.getColumnModel().getColumn(15).setPreferredWidth(0);
        this.JTAgendaU.getColumnModel().getColumn(15).setMinWidth(0);
        this.JTAgendaU.getColumnModel().getColumn(15).setMaxWidth(0);
        this.JTAgendaU.getColumnModel().getColumn(16).setPreferredWidth(100);
        this.JTAgendaU.getColumnModel().getColumn(17).setPreferredWidth(0);
        this.JTAgendaU.getColumnModel().getColumn(17).setMinWidth(0);
        this.JTAgendaU.getColumnModel().getColumn(17).setMaxWidth(0);
        this.JTAgendaU.getColumnModel().getColumn(18).setPreferredWidth(0);
        this.JTAgendaU.getColumnModel().getColumn(18).setMinWidth(0);
        this.JTAgendaU.getColumnModel().getColumn(18).setMaxWidth(0);
        this.JTAgendaU.getColumnModel().getColumn(19).setPreferredWidth(0);
        this.JTAgendaU.getColumnModel().getColumn(19).setMinWidth(0);
        this.JTAgendaU.getColumnModel().getColumn(19).setMaxWidth(0);
        this.JTAgendaU.getColumnModel().getColumn(20).setPreferredWidth(0);
        this.JTAgendaU.getColumnModel().getColumn(20).setMinWidth(0);
        this.JTAgendaU.getColumnModel().getColumn(20).setMaxWidth(0);
        this.JTAgendaU.getColumnModel().getColumn(21).setPreferredWidth(50);
        this.JTAgendaU.getColumnModel().getColumn(22).setPreferredWidth(10);
        this.JTAgendaU.getColumnModel().getColumn(23).setPreferredWidth(0);
        this.JTAgendaU.getColumnModel().getColumn(23).setMinWidth(0);
        this.JTAgendaU.getColumnModel().getColumn(23).setMaxWidth(0);
        this.JTAgendaU.getColumnModel().getColumn(24).setPreferredWidth(0);
        this.JTAgendaU.getColumnModel().getColumn(24).setMinWidth(0);
        this.JTAgendaU.getColumnModel().getColumn(24).setMaxWidth(0);
        this.JTAgendaU.getColumnModel().getColumn(25).setPreferredWidth(0);
        this.JTAgendaU.getColumnModel().getColumn(25).setMinWidth(0);
        this.JTAgendaU.getColumnModel().getColumn(25).setMaxWidth(0);
        this.JTAgendaU.getColumnModel().getColumn(26).setPreferredWidth(0);
        this.JTAgendaU.getColumnModel().getColumn(26).setMinWidth(0);
        this.JTAgendaU.getColumnModel().getColumn(26).setMaxWidth(0);
    }

    public void mCargarDatos_Urgencias1() {
        if (this.xmodelo_urgencias != null) {
            try {
                mCrearTablaAgenda_Urgencias();
                if (this.xid_especialidad.equals("382")) {
                    if (this.JCHFiltro_Profesional_U.isSelected()) {
                        if (Principal.informacionIps.getNombreIps().equals("FUNDACIÓN PANZENÚ")) {
                            this.xsql = "SELECT\n `ingreso`.`Id` , \n DATE_FORMAT(`ingreso`.`FechaIngreso`,'%d-%m-%Y') AS FIngreso ,\n `ingreso`.`HoraIngreso` ,  \n `g_usuario`.`NoHistoria`, \n CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ', `g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2`) AS `NUsuario` , \n `g_persona`.`Id_Sexo` ,  \n `CalculaTiempo_AMD_2Fechas`(g_persona.`FechaNac`, h_atencion.`Fecha_Atencion`) AS `Edad` , \n `f_empresacontxconvenio`.`Nbre` AS `NEmpresa`, \n IF(f_camas.`Nbre`IS NULL, '', f_camas.`Nbre`) AS Cama ,\n IF(h_egreso_atencion.`Id` IS NULL, 0, 1) Egreso , \n IF(h_egreso_atencion.`Id`  IS NULL, '', DATE_FORMAT(`h_egreso_atencion`.`FechaSO`,'%d-%m-%Y')) AS FEgreso, \n `g_persona`.`Id`,  `c_clasecita`.`Id_Historia`,0, \n `ingreso`.`Id_TipoAtencion`, \n CONCAT(`profesional`.`Apellido1` ,' ', `profesional`.`Apellido2` ,' ', `profesional`.`Nombre1` ,' ', `profesional`.`Nombre2`) `NProfesional`,`h_atencion`.`Id_ClaseCita`, `h_atencion`.`TipoGuardado`,`h_atencion`.Urgente,  IFNULL(`h_triage`.`Clasificacion`,-1) CTriage       ,IF(`ingreso`.`CEspecial` IS NULL, '0',`ingreso`.`CEspecial`) AS CEspecial,  c_clasecita.`Id_Programa`  \n ,ingreso.idModalidad , ingreso.idEntornoAtencion , ingreso.idTipoDiscapacidad  \n   \nFROM\n     `h_atencion`\n    INNER JOIN  `ingreso` \n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN  `g_usuario` \n        ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)\n    INNER JOIN  `f_empresacontxconvenio` \n        ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)\n    INNER JOIN  `c_clasecita` \n        ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)\n    INNER JOIN  `g_especialidad` \n        ON (`h_atencion`.`Id_Especialidad` = `g_especialidad`.`Id`)\n    INNER JOIN  `g_persona` \n        ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\n    INNER JOIN  `h_tipohistoria` \n        ON (`c_clasecita`.`Id_Historia` = `h_tipohistoria`.`Id`)\n    INNER JOIN  `g_persona` AS `profesional` \n        ON (`profesional`.`Id` = `h_atencion`.`Id_Profesional`)\n    LEFT JOIN  `h_egreso_atencion` \n        ON (`h_egreso_atencion`.`Id_Ingreso` = `ingreso`.`Id`) AND (`h_egreso_atencion`.`Id_Tipo` = `ingreso`.`Id_TipoAtencion`) AND (`h_egreso_atencion`.`Estado` = 0)\n    LEFT JOIN `f_camas` ON (`f_camas`.`Id` = ingreso.`Cama`)   \n    LEFT JOIN  `h_triage` ON (`h_triage`.`IdIngreso` = `ingreso`.`Id`)    \nWHERE (`profesional`.`Id`='" + this.xid_profesional + "' AND ingreso.`Id_Sede` ='" + Principal.sedeUsuarioSeleccionadaDTO.getId() + "' AND CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ', `g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2`) like'%" + this.JTFNombre_u.getText() + "%' AND ingreso.`CS_Parto`=0   AND `ingreso`.`Id_TipoAtencion` =3  AND `ingreso`.`Estado`=0 AND ingreso.`Egreso` ='" + this.xestado_atencion + "'\nAND DATE_FORMAT(`ingreso`.`FechaIngreso`, '%Y-%m')='" + this.xmt.formatoANO_MES.format(this.JDCFechaAgenda1.getDate()) + "')\nORDER BY ingreso.`FechaIngreso` DESC, `ingreso`.`HoraIngreso` ASC;";
                        } else if (Principal.informacionIps.getIdentificacion().equals("812005644")) {
                            this.xsql = "SELECT\n `ingreso`.`Id` , \n DATE_FORMAT(`ingreso`.`FechaIngreso`,'%d-%m-%Y') AS FIngreso ,\n `ingreso`.`HoraIngreso` ,  \n `g_usuario`.`NoHistoria`, \n CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ', `g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2`) AS `NUsuario` , \n `g_persona`.`Id_Sexo` ,  \n `CalculaTiempo_AMD_2Fechas`(g_persona.`FechaNac`, h_atencion.`Fecha_Atencion`) AS `Edad` , \n `f_empresacontxconvenio`.`Nbre` AS `NEmpresa`, \n IF(f_camas.`Nbre`IS NULL, '', f_camas.`Nbre`) AS Cama ,\n IF(h_egreso_atencion.`Id` IS NULL, 0, 1) Egreso , \n IF(h_egreso_atencion.`Id`  IS NULL, '', DATE_FORMAT(`h_egreso_atencion`.`FechaSO`,'%d-%m-%Y')) AS FEgreso, \n `g_persona`.`Id`,  `c_clasecita`.`Id_Historia`,0, \n `ingreso`.`Id_TipoAtencion`, \n CONCAT(`profesional`.`Apellido1` ,' ', `profesional`.`Apellido2` ,' ', `profesional`.`Nombre1` ,' ', `profesional`.`Nombre2`) `NProfesional`,`h_atencion`.`Id_ClaseCita`, `h_atencion`.`TipoGuardado`,`h_atencion`.Urgente,  IFNULL(`h_triage`.`Clasificacion`,-1) CTriage       ,IF(`ingreso`.`CEspecial` IS NULL, '0',`ingreso`.`CEspecial`) AS CEspecial,  c_clasecita.`Id_Programa`  \n ,ingreso.idModalidad , ingreso.idEntornoAtencion , ingreso.idTipoDiscapacidad  \n   \nFROM\n     `h_atencion`\n    INNER JOIN  `ingreso` \n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN  `g_usuario` \n        ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)\n    INNER JOIN  `f_empresacontxconvenio` \n        ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)\n    INNER JOIN  `c_clasecita` \n        ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)\n    INNER JOIN  `g_especialidad` \n        ON (`h_atencion`.`Id_Especialidad` = `g_especialidad`.`Id`)\n    INNER JOIN  `g_persona` \n        ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\n    INNER JOIN  `h_tipohistoria` \n        ON (`c_clasecita`.`Id_Historia` = `h_tipohistoria`.`Id`)\n    INNER JOIN  `g_persona` AS `profesional` \n        ON (`profesional`.`Id` = `h_atencion`.`Id_Profesional`)\n    LEFT JOIN  `h_egreso_atencion` \n        ON (`h_egreso_atencion`.`Id_Ingreso` = `ingreso`.`Id`) AND (`h_egreso_atencion`.`Id_Tipo` = `ingreso`.`Id_TipoAtencion`) AND (`h_egreso_atencion`.`Estado` = 0)\n        LEFT JOIN `f_camas` ON (`f_camas`.`Id` = ingreso.`Cama`)   \n       LEFT JOIN  `h_triage` ON (`h_triage`.`IdIngreso` = `ingreso`.`Id`)    \nWHERE (`profesional`.`Id`='" + this.xid_profesional + "' AND ingreso.`Id_Sede` ='" + Principal.sedeUsuarioSeleccionadaDTO.getId() + "' AND CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ', `g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2`) like'%" + this.JTFNombre_u.getText() + "%' AND ingreso.`CS_Parto`=0   AND `ingreso`.`Id_TipoAtencion` =3  AND `ingreso`.`Estado`=0  AND (IF(h_egreso_atencion.`Id` IS NULL, 0, 1) =" + this.xestado_atencion + " AND ingreso.`Egreso`=" + this.xestado_atencion + ")\nAND `ingreso`.`FechaIngreso`='" + this.xmt.formatoAMD1.format(this.JDCFechaAgenda1.getDate()) + "')\nORDER BY ingreso.`FechaIngreso` DESC, `ingreso`.`HoraIngreso` ASC;";
                        } else {
                            this.xsql = "SELECT\n `ingreso`.`Id` , \n DATE_FORMAT(`ingreso`.`FechaIngreso`,'%d-%m-%Y') AS FIngreso ,\n `ingreso`.`HoraIngreso` ,  \n `g_usuario`.`NoHistoria`, \n CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ', `g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2`) AS `NUsuario` , \n `g_persona`.`Id_Sexo` ,  \n `CalculaTiempo_AMD_2Fechas`(g_persona.`FechaNac`, h_atencion.`Fecha_Atencion`) AS `Edad` , \n `f_empresacontxconvenio`.`Nbre` AS `NEmpresa`, \n IF(f_camas.`Nbre`IS NULL, '', f_camas.`Nbre`) AS Cama ,\n IF(h_egreso_atencion.`Id` IS NULL, 0, 1) Egreso , \n IF(h_egreso_atencion.`Id`  IS NULL, '', DATE_FORMAT(`h_egreso_atencion`.`FechaSO`,'%d-%m-%Y')) AS FEgreso, \n `g_persona`.`Id`,  `c_clasecita`.`Id_Historia`,0, \n `ingreso`.`Id_TipoAtencion`, \n CONCAT(`profesional`.`Apellido1` ,' ', `profesional`.`Apellido2` ,' ', `profesional`.`Nombre1` ,' ', `profesional`.`Nombre2`) `NProfesional`,`h_atencion`.`Id_ClaseCita`, `h_atencion`.`TipoGuardado`,`h_atencion`.Urgente,  IFNULL(`h_triage`.`Clasificacion`,-1) CTriage       ,IF(`ingreso`.`CEspecial` IS NULL, '0',`ingreso`.`CEspecial`) AS CEspecial,  c_clasecita.`Id_Programa`  \n ,ingreso.idModalidad , ingreso.idEntornoAtencion , ingreso.idTipoDiscapacidad  \n   \nFROM\n     `h_atencion`\n    INNER JOIN  `ingreso` \n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN  `g_usuario` \n        ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)\n    INNER JOIN  `f_empresacontxconvenio` \n        ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)\n    INNER JOIN  `c_clasecita` \n        ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)\n    INNER JOIN  `g_especialidad` \n        ON (`h_atencion`.`Id_Especialidad` = `g_especialidad`.`Id`)\n    INNER JOIN  `g_persona` \n        ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\n    INNER JOIN  `h_tipohistoria` \n        ON (`c_clasecita`.`Id_Historia` = `h_tipohistoria`.`Id`)\n    INNER JOIN  `g_persona` AS `profesional` \n        ON (`profesional`.`Id` = `h_atencion`.`Id_Profesional`)\n    LEFT JOIN  `h_egreso_atencion` \n        ON (`h_egreso_atencion`.`Id_Ingreso` = `ingreso`.`Id`) AND (`h_egreso_atencion`.`Id_Tipo` = `ingreso`.`Id_TipoAtencion`) AND (`h_egreso_atencion`.`Estado` = 0)\n        LEFT JOIN `f_camas` ON (`f_camas`.`Id` = ingreso.`Cama`)   \n       LEFT JOIN  `h_triage` ON (`h_triage`.`IdIngreso` = `ingreso`.`Id`)    \nWHERE (`profesional`.`Id`='" + this.xid_profesional + "' AND ingreso.`Id_Sede` ='" + Principal.sedeUsuarioSeleccionadaDTO.getId() + "' AND CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ', `g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2`) like'%" + this.JTFNombre_u.getText() + "%' AND ingreso.`CS_Parto`=0   AND `ingreso`.`Id_TipoAtencion` =3  AND `ingreso`.`Estado`=0  AND (IF(h_egreso_atencion.`Id` IS NULL, 0, 1) =" + this.xestado_atencion + " AND ingreso.`Egreso`=" + this.xestado_atencion + ")\nAND DATE_FORMAT(`ingreso`.`FechaIngreso`, '%Y-%m')='" + this.xmt.formatoANO_MES.format(this.JDCFechaAgenda1.getDate()) + "')\nORDER BY ingreso.`FechaIngreso` DESC, `ingreso`.`HoraIngreso` ASC;";
                        }
                    } else if (Principal.informacionIps.getNombreIps().equals("FUNDACIÓN PANZENÚ")) {
                        this.xsql = "SELECT\n `ingreso`.`Id` , \n DATE_FORMAT(`ingreso`.`FechaIngreso`,'%d-%m-%Y') AS FIngreso ,\n `ingreso`.`HoraIngreso` ,  \n `g_usuario`.`NoHistoria`, \n CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ', `g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2`) AS `NUsuario` , \n `g_persona`.`Id_Sexo` ,  \n `CalculaTiempo_AMD_2Fechas`(g_persona.`FechaNac`, h_atencion.`Fecha_Atencion`) AS `Edad` , \n `f_empresacontxconvenio`.`Nbre` AS `NEmpresa`, \n IF(f_camas.`Nbre`IS NULL, '', f_camas.`Nbre`) AS Cama ,\n IF(h_egreso_atencion.`Id` IS NULL, 0, 1) Egreso , \n IF(h_egreso_atencion.`Id`  IS NULL, '', DATE_FORMAT(`h_egreso_atencion`.`FechaSO`,'%d-%m-%Y')) AS FEgreso, \n `g_persona`.`Id`,  `c_clasecita`.`Id_Historia`,0, \n `ingreso`.`Id_TipoAtencion`, \n CONCAT(`profesional`.`Apellido1` ,' ', `profesional`.`Apellido2` ,' ', `profesional`.`Nombre1` ,' ', `profesional`.`Nombre2`) `NProfesional`,`h_atencion`.`Id_ClaseCita`, `h_atencion`.`TipoGuardado`,`h_atencion`.Urgente,  IFNULL(`h_triage`.`Clasificacion`,-1) CTriage       ,IF(`ingreso`.`CEspecial` IS NULL, '0',`ingreso`.`CEspecial`) AS CEspecial,  c_clasecita.`Id_Programa`  \n ,ingreso.idModalidad , ingreso.idEntornoAtencion , ingreso.idTipoDiscapacidad  \n   \nFROM\n     `h_atencion`\n    INNER JOIN  `ingreso` \n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN  `g_usuario` \n        ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)\n    INNER JOIN  `f_empresacontxconvenio` \n        ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)\n    INNER JOIN  `c_clasecita` \n        ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)\n    INNER JOIN  `g_especialidad` \n        ON (`h_atencion`.`Id_Especialidad` = `g_especialidad`.`Id`)\n    INNER JOIN  `g_persona` \n        ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\n    INNER JOIN  `h_tipohistoria` \n        ON (`c_clasecita`.`Id_Historia` = `h_tipohistoria`.`Id`)\n    INNER JOIN  `g_persona` AS `profesional` \n        ON (`profesional`.`Id` = `h_atencion`.`Id_Profesional`)\n    LEFT JOIN  `h_egreso_atencion` \n        ON (`h_egreso_atencion`.`Id_Ingreso` = `ingreso`.`Id`) AND (`h_egreso_atencion`.`Id_Tipo` = `ingreso`.`Id_TipoAtencion`) AND (`h_egreso_atencion`.`Estado` = 0)\n    LEFT JOIN `f_camas` \n        ON (`f_camas`.`Id` = ingreso.`Cama`)   \n    LEFT JOIN  `h_triage` ON (`h_triage`.`IdIngreso` = `ingreso`.`Id`)    \nWHERE (ingreso.`Id_Sede` ='" + Principal.sedeUsuarioSeleccionadaDTO.getId() + "' AND CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ', `g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2`) like'%" + this.JTFNombre_u.getText() + "%' AND ingreso.`CS_Parto`=0   AND `ingreso`.`Id_TipoAtencion` =3  AND `ingreso`.`Estado`=0 AND ingreso.`Egreso` ='" + this.xestado_atencion + "'\nAND DATE_FORMAT(`ingreso`.`FechaIngreso`, '%Y-%m')='" + this.xmt.formatoANO_MES.format(this.JDCFechaAgenda1.getDate()) + "')\nORDER BY ingreso.`FechaIngreso` DESC, `ingreso`.`HoraIngreso` ASC;";
                    } else if (Principal.informacionIps.getIdentificacion().equals("812005644")) {
                        this.xsql = "SELECT\n `ingreso`.`Id` , \n DATE_FORMAT(`ingreso`.`FechaIngreso`,'%d-%m-%Y') AS FIngreso ,\n `ingreso`.`HoraIngreso` ,  \n `g_usuario`.`NoHistoria`, \n CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ', `g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2`) AS `NUsuario` , \n `g_persona`.`Id_Sexo` ,  \n `CalculaTiempo_AMD_2Fechas`(g_persona.`FechaNac`, h_atencion.`Fecha_Atencion`) AS `Edad` , \n `f_empresacontxconvenio`.`Nbre` AS `NEmpresa`, \n IF(f_camas.`Nbre`IS NULL, '', f_camas.`Nbre`) AS Cama ,\n IF(h_egreso_atencion.`Id` IS NULL, 0, 1) Egreso , \n IF(h_egreso_atencion.`Id`  IS NULL, '', DATE_FORMAT(`h_egreso_atencion`.`FechaSO`,'%d-%m-%Y')) AS FEgreso, \n `g_persona`.`Id`,  `c_clasecita`.`Id_Historia`,0, \n `ingreso`.`Id_TipoAtencion`, \n CONCAT(`profesional`.`Apellido1` ,' ', `profesional`.`Apellido2` ,' ', `profesional`.`Nombre1` ,' ', `profesional`.`Nombre2`) `NProfesional`,`h_atencion`.`Id_ClaseCita`, `h_atencion`.`TipoGuardado`,`h_atencion`.Urgente,  IFNULL(`h_triage`.`Clasificacion`,-1) CTriage       ,IF(`ingreso`.`CEspecial` IS NULL, '0',`ingreso`.`CEspecial`) AS CEspecial,  c_clasecita.`Id_Programa`  \n ,ingreso.idModalidad , ingreso.idEntornoAtencion , ingreso.idTipoDiscapacidad  \n   \nFROM\n     `h_atencion`\n    INNER JOIN  `ingreso` \n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN  `g_usuario` \n        ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)\n    INNER JOIN  `f_empresacontxconvenio` \n        ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)\n    INNER JOIN  `c_clasecita` \n        ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)\n    INNER JOIN  `g_especialidad` \n        ON (`h_atencion`.`Id_Especialidad` = `g_especialidad`.`Id`)\n    INNER JOIN  `g_persona` \n        ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\n    INNER JOIN  `h_tipohistoria` \n        ON (`c_clasecita`.`Id_Historia` = `h_tipohistoria`.`Id`)\n    INNER JOIN  `g_persona` AS `profesional` \n        ON (`profesional`.`Id` = `h_atencion`.`Id_Profesional`)\n    LEFT JOIN  `h_egreso_atencion` \n        ON (`h_egreso_atencion`.`Id_Ingreso` = `ingreso`.`Id`) AND (`h_egreso_atencion`.`Id_Tipo` = `ingreso`.`Id_TipoAtencion`) AND (`h_egreso_atencion`.`Estado` = 0)\n        LEFT JOIN `f_camas` ON (`f_camas`.`Id` = ingreso.`Cama`)   \n       LEFT JOIN  `h_triage` ON (`h_triage`.`IdIngreso` = `ingreso`.`Id`)    \nWHERE (ingreso.`Id_Sede` ='" + Principal.sedeUsuarioSeleccionadaDTO.getId() + "' AND CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ', `g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2`) like'%" + this.JTFNombre_u.getText() + "%' AND ingreso.`CS_Parto`=0   AND `ingreso`.`Id_TipoAtencion` =3  AND `ingreso`.`Estado`=0  AND (IF(h_egreso_atencion.`Id` IS NULL, 0, 1) =" + this.xestado_atencion + " AND ingreso.`Egreso`=" + this.xestado_atencion + ")\nAND `ingreso`.`FechaIngreso`='" + this.xmt.formatoAMD1.format(this.JDCFechaAgenda1.getDate()) + "')\nORDER BY ingreso.`FechaIngreso` DESC, `ingreso`.`HoraIngreso` ASC;";
                    } else {
                        this.xsql = "SELECT\n `ingreso`.`Id` , \n DATE_FORMAT(`ingreso`.`FechaIngreso`,'%d-%m-%Y') AS FIngreso ,\n `ingreso`.`HoraIngreso` ,  \n `g_usuario`.`NoHistoria`, \n CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ', `g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2`) AS `NUsuario` , \n `g_persona`.`Id_Sexo` ,  \n `CalculaTiempo_AMD_2Fechas`(g_persona.`FechaNac`, h_atencion.`Fecha_Atencion`) AS `Edad` , \n `f_empresacontxconvenio`.`Nbre` AS `NEmpresa`, \n IF(f_camas.`Nbre`IS NULL, '', f_camas.`Nbre`) AS Cama ,\n IF(h_egreso_atencion.`Id` IS NULL, 0, 1) Egreso , \n IF(h_egreso_atencion.`Id`  IS NULL, '', DATE_FORMAT(`h_egreso_atencion`.`FechaSO`,'%d-%m-%Y')) AS FEgreso, \n `g_persona`.`Id`,  `c_clasecita`.`Id_Historia`,0, \n `ingreso`.`Id_TipoAtencion`, \n CONCAT(`profesional`.`Apellido1` ,' ', `profesional`.`Apellido2` ,' ', `profesional`.`Nombre1` ,' ', `profesional`.`Nombre2`) `NProfesional`,`h_atencion`.`Id_ClaseCita`, `h_atencion`.`TipoGuardado`,`h_atencion`.Urgente,  IFNULL(`h_triage`.`Clasificacion`,-1) CTriage       ,IF(`ingreso`.`CEspecial` IS NULL, '0',`ingreso`.`CEspecial`) AS CEspecial,  c_clasecita.`Id_Programa`  \n ,ingreso.idModalidad , ingreso.idEntornoAtencion , ingreso.idTipoDiscapacidad  \n   \nFROM\n     `h_atencion`\n    INNER JOIN  `ingreso` \n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN  `g_usuario` \n        ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)\n    INNER JOIN  `f_empresacontxconvenio` \n        ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)\n    INNER JOIN  `c_clasecita` \n        ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)\n    INNER JOIN  `g_especialidad` \n        ON (`h_atencion`.`Id_Especialidad` = `g_especialidad`.`Id`)\n    INNER JOIN  `g_persona` \n        ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\n    INNER JOIN  `h_tipohistoria` \n        ON (`c_clasecita`.`Id_Historia` = `h_tipohistoria`.`Id`)\n    INNER JOIN  `g_persona` AS `profesional` \n        ON (`profesional`.`Id` = `h_atencion`.`Id_Profesional`)\n    LEFT JOIN  `h_egreso_atencion` \n        ON (`h_egreso_atencion`.`Id_Ingreso` = `ingreso`.`Id`) AND (`h_egreso_atencion`.`Id_Tipo` = `ingreso`.`Id_TipoAtencion`) AND (`h_egreso_atencion`.`Estado` = 0) \n        LEFT JOIN `f_camas` ON (`f_camas`.`Id` = ingreso.`Cama`)   \n       LEFT JOIN  `h_triage` ON (`h_triage`.`IdIngreso` = `ingreso`.`Id`)    \nWHERE (ingreso.`Id_Sede` ='" + Principal.sedeUsuarioSeleccionadaDTO.getId() + "' AND CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ', `g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2`) like'%" + this.JTFNombre_u.getText() + "%' AND ingreso.`CS_Parto`=0   AND `ingreso`.`Id_TipoAtencion` =3  AND `ingreso`.`Estado`=0  AND (IF(h_egreso_atencion.`Id` IS NULL, 0, 1) =" + this.xestado_atencion + " AND ingreso.`Egreso`=" + this.xestado_atencion + ")\nAND DATE_FORMAT(`ingreso`.`FechaIngreso`, '%Y-%m')='" + this.xmt.formatoANO_MES.format(this.JDCFechaAgenda1.getDate()) + "')\nORDER BY ingreso.`FechaIngreso` DESC, `ingreso`.`HoraIngreso` ASC;";
                    }
                } else if (this.JCHFiltro_U.isSelected()) {
                    this.xsql = "SELECT `ingreso`.`Id` , DATE_FORMAT(`ingreso`.`FechaIngreso`,'%d-%m-%Y') AS FIngreso , `ingreso`.`HoraIngreso` ,  `g_usuario`.`NoHistoria`, CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ', `g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2`) AS `NUsuario` , `g_persona`.`Id_Sexo` ,  CONCAT(`g_persona`.`Edad` , ' ', `g_tipoedad`.`Nbre`, '(s)') AS `Edad` , `f_empresacontxconvenio`.`Nbre` AS `NEmpresa`, IF(`f_camas`.`Nbre` IS NULL, '',`f_camas`.`Nbre`) AS `Cama` , `ingreso`.`Egreso` , IF(`ingreso`.`FEgreso` IS NULL, '', DATE_FORMAT(`ingreso`.`FEgreso`,'%d-%m-%Y')) AS FEgreso, `g_persona`.`Id`,  h_tiponota_especialidad.`Id_Historia`,0, `ingreso`.`Id_TipoAtencion`, profesional1.`NProfesional`,0  as Id_ClaseCita, `h_atencion`.`TipoGuardado`,`h_atencion`.Urgente,  ifnull(`h_triage`.`Clasificacion`,-1) CTriage    ,IF(`ingreso`.`CEspecial` IS NULL, '0',`ingreso`.`CEspecial`) AS CEspecial,  c_clasecita.`Id_Programa`  ,ingreso.idModalidad , ingreso.idEntornoAtencion , ingreso.idTipoDiscapacidad  \n FROM `ingreso` INNER JOIN `g_usuario`    ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`) INNER JOIN `h_atencion`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN `c_clasecita`  ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`) INNER JOIN `h_notasclinicas`  ON (`h_notasclinicas`.`Id_Atencion` = `h_atencion`.`Id`) INNER JOIN `h_ordenes_interconsultas`  ON (`h_ordenes_interconsultas`.`Id_Nota` = `h_notasclinicas`.`Id`) INNER JOIN `f_empresacontxconvenio`   ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`) INNER JOIN `h_tiponota`  ON (`h_notasclinicas`.`Id_TipoNota` = `h_tiponota`.`Id`) INNER JOIN `h_tiponota_especialidad`  ON (`h_tiponota_especialidad`.`Id_TipoNota` = `h_tiponota`.`Id`) INNER JOIN `g_persona`  ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`) INNER JOIN `g_tipoedad`  ON (`g_persona`.`Id_TipoEdad` = `g_tipoedad`.`Id`)  INNER JOIN `profesional1` ON (`profesional1`.`Id_Persona` = `h_atencion`.`Id_Profesional`) AND  (`profesional1`.`IdEspecialidad` = `h_atencion`.`Id_Especialidad`) LEFT JOIN `f_camas` ON (`f_camas`.`Id` = ingreso.`Cama`)    LEFT JOIN  `h_triage` ON (`h_triage`.`IdIngreso` = `ingreso`.`Id`)   WHERE ( `ingreso`.`Egreso` ='" + this.xestado_atencion + "'  AND `ingreso`.`Id_TipoAtencion` =3  AND CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ', `g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2`) like'%" + this.JTFNombre_u.getText() + "%'  AND `ingreso`.`Estado`=0  AND `h_ordenes_interconsultas`.`Id_Especialidad`='" + this.xid_especialidad + "' and  h_tiponota_especialidad.`Id_Historia` <>0 )  GROUP BY `ingreso`.`Id` ORDER BY `ingreso`.`FechaIngreso` DESC , `ingreso`.`HoraIngreso` DESC ";
                } else {
                    this.xsql = "SELECT `ingreso`.`Id` , DATE_FORMAT(`ingreso`.`FechaIngreso`,'%d-%m-%Y') AS FIngreso , `ingreso`.`HoraIngreso` ,  `g_usuario`.`NoHistoria`, CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ', `g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2`) AS `NUsuario` , `g_persona`.`Id_Sexo` ,  CONCAT(`g_persona`.`Edad` , ' ', `g_tipoedad`.`Nbre`, '(s)') AS `Edad` , `f_empresacontxconvenio`.`Nbre` AS `NEmpresa`, IF(`f_camas`.`Nbre` IS NULL, '',`f_camas`.`Nbre`) AS `Cama` , `ingreso`.`Egreso` , IF(`ingreso`.`FEgreso` IS NULL, '', DATE_FORMAT(`ingreso`.`FEgreso`,'%d-%m-%Y')) AS FEgreso, `g_persona`.`Id`,  h_tiponota_especialidad.`Id_Historia`,0, `ingreso`.`Id_TipoAtencion`, profesional1.`NProfesional`,0 as Id_ClaseCita, `h_atencion`.`TipoGuardado`,`h_atencion`.Urgente,  ifnull(`h_triage`.`Clasificacion`,-1) CTriage     ,IF(`ingreso`.`CEspecial` IS NULL, '0',`ingreso`.`CEspecial`) AS CEspecial,  c_clasecita.`Id_Programa`  ,ingreso.idModalidad , ingreso.idEntornoAtencion , ingreso.idTipoDiscapacidad  \n FROM `ingreso` INNER JOIN `g_usuario`    ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`) INNER JOIN `h_atencion`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN `c_clasecita`  ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`) INNER JOIN `h_notasclinicas`  ON (`h_notasclinicas`.`Id_Atencion` = `h_atencion`.`Id`) INNER JOIN `h_ordenes_interconsultas`  ON (`h_ordenes_interconsultas`.`Id_Nota` = `h_notasclinicas`.`Id`) INNER JOIN `f_empresacontxconvenio`   ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`) INNER JOIN `h_tiponota`  ON (`h_notasclinicas`.`Id_TipoNota` = `h_tiponota`.`Id`) INNER JOIN `h_tiponota_especialidad`  ON (`h_tiponota_especialidad`.`Id_TipoNota` = `h_tiponota`.`Id`) INNER JOIN `g_persona`  ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`) INNER JOIN `g_tipoedad`  ON (`g_persona`.`Id_TipoEdad` = `g_tipoedad`.`Id`)  INNER JOIN `profesional1` ON (`profesional1`.`Id_Persona` = `h_atencion`.`Id_Profesional`) AND  (`profesional1`.`IdEspecialidad` = `h_atencion`.`Id_Especialidad`) LEFT JOIN `f_camas` ON (`f_camas`.`Id` = ingreso.`Cama`)    LEFT JOIN  `h_triage` ON (`h_triage`.`IdIngreso` = `ingreso`.`Id`)    WHERE ( CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ', `g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2`) like'%" + this.JTFNombre_u.getText() + "%' and `ingreso`.`Egreso` ='" + this.xestado_atencion + "'  AND `ingreso`.`Id_TipoAtencion` =3 AND `ingreso`.`Estado`=0  AND `h_ordenes_interconsultas`.`Id_Especialidad`='" + this.xid_especialidad + "' and  h_tiponota_especialidad.`Id_Historia` <>0 )  GROUP BY `ingreso`.`Id` ORDER BY `ingreso`.`FechaIngreso` DESC , `ingreso`.`HoraIngreso` DESC ";
                }
                ConsultasMySQL xct1 = new ConsultasMySQL();
                ResultSet xrs = xct1.traerRs(this.xsql);
                int xfila = 0;
                int nAtendidos = 0;
                int xPorAtender = 0;
                int nEnAtencion = 0;
                if (xrs.next()) {
                    xrs.beforeFirst();
                    this.xmt.mEstablecerTextEditor(this.JTAgendaU, 4);
                    this.xmt.mEstablecerTextEditor(this.JTAgendaU, 7);
                    this.xmt.mEstablecerTextEditor(this.JTAgendaU, 16);
                    while (xrs.next()) {
                        this.xmodelo_urgencias.addRow(this.xdato);
                        this.xmodelo_urgencias.setValueAt(Long.valueOf(xrs.getLong(1)), xfila, 0);
                        this.xmodelo_urgencias.setValueAt(xrs.getString(2), xfila, 1);
                        this.xmodelo_urgencias.setValueAt(xrs.getString(3), xfila, 2);
                        this.xmodelo_urgencias.setValueAt(xrs.getString(4), xfila, 3);
                        this.xmodelo_urgencias.setValueAt(xrs.getString(5), xfila, 4);
                        this.xmodelo_urgencias.setValueAt(xrs.getString(6), xfila, 5);
                        this.xmodelo_urgencias.setValueAt(xrs.getString(7), xfila, 6);
                        this.xmodelo_urgencias.setValueAt("NUEVA ORDEN", xfila, 11);
                        this.xmodelo_urgencias.setValueAt(xrs.getString(8), xfila, 7);
                        this.xmodelo_urgencias.setValueAt(xrs.getString(9), xfila, 8);
                        this.xmodelo_urgencias.setValueAt(xrs.getString(11), xfila, 9);
                        this.xmodelo_urgencias.setValueAt(Long.valueOf(xrs.getLong(10)), xfila, 10);
                        this.xmodelo_urgencias.setValueAt(Long.valueOf(xrs.getLong(12)), xfila, 12);
                        this.xmodelo_urgencias.setValueAt(Long.valueOf(xrs.getLong(13)), xfila, 13);
                        this.xmodelo_urgencias.setValueAt(Long.valueOf(xrs.getLong(14)), xfila, 14);
                        this.xmodelo_urgencias.setValueAt(Long.valueOf(xrs.getLong("Id_TipoAtencion")), xfila, 15);
                        this.xmodelo_urgencias.setValueAt(xrs.getString("NProfesional"), xfila, 16);
                        this.xmodelo_urgencias.setValueAt(xrs.getString("Id_ClaseCita"), xfila, 17);
                        this.xmodelo_urgencias.setValueAt(Long.valueOf(xrs.getLong("TipoGuardado")), xfila, 18);
                        switch (xrs.getInt("TipoGuardado")) {
                            case 0:
                                xPorAtender++;
                                break;
                            case 1:
                                nAtendidos++;
                                break;
                            default:
                                nEnAtencion++;
                                break;
                        }
                        this.xmodelo_urgencias.setValueAt(Long.valueOf(xrs.getLong("Urgente")), xfila, 19);
                        this.xmodelo_urgencias.setValueAt(Long.valueOf(xrs.getLong("CEspecial")), xfila, 20);
                        if (xrs.getInt("CEspecial") == 1) {
                            this.xmodelo_urgencias.setValueAt(new JLabel(new ImageIcon(getClass().getResource("/Imagenes/Atencion Discapasitaods.png"))), xfila, 21);
                        } else if (xrs.getLong("CEspecial") == 2) {
                            this.xmodelo_urgencias.setValueAt(new JLabel(new ImageIcon(getClass().getResource("/Imagenes/Atencion Embarazada.png"))), xfila, 21);
                        } else if (xrs.getLong("CEspecial") == 3) {
                            this.xmodelo_urgencias.setValueAt(new JLabel(new ImageIcon(getClass().getResource("/Imagenes/Atencion Ancianos.png"))), xfila, 21);
                        } else if (xrs.getLong("CEspecial") == 4) {
                            this.xmodelo_urgencias.setValueAt(new JLabel(new ImageIcon(getClass().getResource("/Imagenes/AtpNiños.png"))), xfila, 21);
                        } else {
                            this.xmodelo_urgencias.setValueAt(new JLabel(""), xfila, 21);
                        }
                        this.JTAgendaU.setDefaultRenderer(JLabel.class, new Render(xrs.getInt("CEspecial"), 20));
                        this.xmodelo_urgencias.setValueAt(Long.valueOf(xrs.getLong("CTriage")), xfila, 22);
                        this.xmodelo_urgencias.setValueAt(Long.valueOf(xrs.getLong("Id_Programa")), xfila, 23);
                        this.xmodelo_urgencias.setValueAt(Integer.valueOf(xrs.getInt("idModalidad")), xfila, 24);
                        this.xmodelo_urgencias.setValueAt(Integer.valueOf(xrs.getInt("idEntornoAtencion")), xfila, 25);
                        this.xmodelo_urgencias.setValueAt(Integer.valueOf(xrs.getInt("idTipoDiscapacidad")), xfila, 26);
                        this.JTAgendaU.setDefaultRenderer(Object.class, new MiRender2());
                        xfila++;
                    }
                }
                if (this.JRBEnAtencion_U.isSelected()) {
                    this.JLBNRegistro_U.setBorder(BorderFactory.createTitledBorder((Border) null, "Cant.", 2, 0, new Font("Arial", 1, 12), Color.cyan));
                    this.JLBNRegistro_U.setText("" + xPorAtender);
                    this.JLBNREnAtencion.setText("" + nEnAtencion);
                } else {
                    this.JLBNRegistro_U.setBorder(BorderFactory.createTitledBorder((Border) null, "Cant.", 2, 0, new Font("Arial", 1, 12), Color.red));
                    this.JLBNRegistro_U.setText("" + nAtendidos);
                    this.JLBNREnAtencion.setText("" + nEnAtencion);
                }
                if (this.xN_NProgramados != xfila) {
                    this.xN_NProgramados = xfila;
                    this.JTP_DatosAgenda.setBackgroundAt(this.xTab_AUgencias, new Color(0, 255, 255));
                } else {
                    this.JTP_DatosAgenda.setBackgroundAt(this.xTab_AUgencias, new Color(240, 240, 240));
                }
                xrs.close();
                xct1.cerrarConexionBd();
                return;
            } catch (SQLException ex) {
                Logger.getLogger(JIFAgendaMedico_N.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                return;
            }
        }
        mCrearTablaAgenda_Urgencias();
    }

    public void mCargarDatos_Urgencias() {
        if (this.xmodelo_urgencias != null) {
            try {
                mCrearTablaAgenda_Urgencias();
                if (this.xid_especialidad.equals("382")) {
                    if (this.JCHFiltro_U.isSelected()) {
                        if (this.JRBDeAlta_U.isSelected()) {
                            if (this.JCHFiltro_Profesional_U.isSelected()) {
                                if (this.xtipo == 0) {
                                    this.xsql = "SELECT `ingreso`.`Id` , DATE_FORMAT(`ingreso`.`FechaIngreso`,'%d-%m-%Y') AS FIngreso , `ingreso`.`HoraIngreso` ,  `g_usuario`.`NoHistoria`, CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ', `g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2`) AS `NUsuario` , `g_persona`.`Id_Sexo` ,  CONCAT(`g_persona`.`Edad` , ' ', `g_tipoedad`.`Nbre`, '(s)') AS `Edad` , `f_empresacontxconvenio`.`Nbre` AS `NEmpresa`, IF(f_camas.`Nbre`IS NULL, '', f_camas.`Nbre`) AS Cama , `ingreso`.`Egreso` ,  IF(`ingreso`.`FEgreso` IS NULL, '', DATE_FORMAT(`ingreso`.`FEgreso`,'%d-%m-%Y')) AS FEgreso, `g_persona`.`Id`,  `c_clasecita`.`Id_Historia`,0, `ingreso`.`Id_TipoAtencion`, profesional1.`NProfesional`,`h_atencion`.`Id_ClaseCita` , `h_atencion`.`TipoGuardado`,`h_atencion`.Urgente,  ifnull(`h_triage`.`Clasificacion`,-1) CTriage      ,IF(`ingreso`.`CEspecial` IS NULL, '0',`ingreso`.`CEspecial`) AS CEspecial,  c_clasecita.`Id_Programa`  ,ingreso.idModalidad , ingreso.idEntornoAtencion , ingreso.idTipoDiscapacidad  \n FROM `ingreso` INNER JOIN `g_usuario`    ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)  INNER JOIN `h_atencion`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)  INNER JOIN `c_clasecita`  ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)  INNER JOIN `h_tipohistoria`  ON (`h_tipohistoria`.`Id` = `c_clasecita`.`Id_Historia`)  INNER JOIN `f_empresacontxconvenio`   ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)  INNER JOIN `g_persona`  ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`) INNER JOIN `g_tipoedad`  ON (`g_persona`.`Id_TipoEdad` = `g_tipoedad`.`Id`) INNER JOIN `profesional1` ON (`profesional1`.`Id_Persona` = `h_atencion`.`Id_Profesional`) AND  (`profesional1`.`IdEspecialidad` = `h_atencion`.`Id_Especialidad`) LEFT JOIN `f_camas` ON (`f_camas`.`Id` = ingreso.`Cama`)    LEFT JOIN  `h_triage` ON (`h_triage`.`IdIngreso` = `ingreso`.`Id`)   WHERE (`profesional1`.`Id_Persona`='" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "' AND DATE_FORMAT(`ingreso`.`FechaIngreso`,'%Y-%m')='" + this.xmt.formatoANO_MES.format(this.JDCFechaAgenda1.getDate()) + "' AND `ingreso`.`Egreso` ='" + this.xestado_atencion + "' AND CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ', `g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2`) like'%" + this.JTFNombre_u.getText() + "%'  AND `ingreso`.`Id_TipoAtencion` =3 AND `ingreso`.`Estado`=0    )  GROUP BY `ingreso`.`Id` ORDER BY CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ', `g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2`) ASC ";
                                } else {
                                    this.xsql = "SELECT `ingreso`.`Id` , DATE_FORMAT(`ingreso`.`FechaIngreso`,'%d-%m-%Y') AS FIngreso , `ingreso`.`HoraIngreso` ,  `g_usuario`.`NoHistoria`, CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ', `g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2`) AS `NUsuario` , `g_persona`.`Id_Sexo` ,  CONCAT(`g_persona`.`Edad` , ' ', `g_tipoedad`.`Nbre`, '(s)') AS `Edad` , `f_empresacontxconvenio`.`Nbre` AS `NEmpresa`, IF(f_camas.`Nbre`IS NULL, '', f_camas.`Nbre`) AS Cama , `ingreso`.`Egreso` ,  IF(`ingreso`.`FEgreso` IS NULL, '', DATE_FORMAT(`ingreso`.`FEgreso`,'%d-%m-%Y')) AS FEgreso, `g_persona`.`Id`,  `c_clasecita`.`Id_Historia`,0, `ingreso`.`Id_TipoAtencion`, profesional1.`NProfesional`,`h_atencion`.`Id_ClaseCita` , `h_atencion`.`TipoGuardado`,`h_atencion`.Urgente,  ifnull(`h_triage`.`Clasificacion`,-1) CTriage      ,IF(`ingreso`.`CEspecial` IS NULL, '0',`ingreso`.`CEspecial`) AS CEspecial,  c_clasecita.`Id_Programa`  ,ingreso.idModalidad , ingreso.idEntornoAtencion , ingreso.idTipoDiscapacidad  \n FROM `ingreso` INNER JOIN `g_usuario`    ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)  INNER JOIN `h_atencion`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)  INNER JOIN `c_clasecita`  ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)  INNER JOIN `h_tipohistoria`  ON (`h_tipohistoria`.`Id` = `c_clasecita`.`Id_Historia`)  INNER JOIN `f_empresacontxconvenio`   ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)  INNER JOIN `g_persona`  ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`) INNER JOIN `g_tipoedad`  ON (`g_persona`.`Id_TipoEdad` = `g_tipoedad`.`Id`) INNER JOIN `profesional1` ON (`profesional1`.`Id_Persona` = `h_atencion`.`Id_Profesional`) AND  (`profesional1`.`IdEspecialidad` = `h_atencion`.`Id_Especialidad`) LEFT JOIN `f_camas` ON (`f_camas`.`Id` = ingreso.`Cama`)    LEFT JOIN  `h_triage` ON (`h_triage`.`IdIngreso` = `ingreso`.`Id`)   WHERE (`profesional1`.`Id_Persona`='" + this.xid_profesional + "' AND DATE_FORMAT(`ingreso`.`FechaIngreso`,'%Y-%m')='" + this.xmt.formatoANO_MES.format(this.JDCFechaAgenda1.getDate()) + "' AND `ingreso`.`Egreso` ='" + this.xestado_atencion + "' AND CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ', `g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2`) like'%" + this.JTFNombre_u.getText() + "%'  AND `ingreso`.`Id_TipoAtencion` =3 AND `ingreso`.`Estado`=0    )  GROUP BY `ingreso`.`Id` ORDER BY CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ', `g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2`) ASC ";
                                }
                            } else {
                                this.xsql = "SELECT `ingreso`.`Id` , DATE_FORMAT(`ingreso`.`FechaIngreso`,'%d-%m-%Y') AS FIngreso , `ingreso`.`HoraIngreso` ,  `g_usuario`.`NoHistoria`, CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ', `g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2`) AS `NUsuario` , `g_persona`.`Id_Sexo` ,  CONCAT(`g_persona`.`Edad` , ' ', `g_tipoedad`.`Nbre`, '(s)') AS `Edad` , `f_empresacontxconvenio`.`Nbre` AS `NEmpresa`, IF(f_camas.`Nbre`IS NULL, '', f_camas.`Nbre`) AS Cama , `ingreso`.`Egreso` ,  IF(`ingreso`.`FEgreso` IS NULL, '', DATE_FORMAT(`ingreso`.`FEgreso`,'%d-%m-%Y')) AS FEgreso, `g_persona`.`Id`,  `c_clasecita`.`Id_Historia`,0, `ingreso`.`Id_TipoAtencion`, profesional1.`NProfesional`,`h_atencion`.`Id_ClaseCita`, `h_atencion`.`TipoGuardado`,`h_atencion`.Urgente,  ifnull(`h_triage`.`Clasificacion`,-1) CTriage      ,IF(`ingreso`.`CEspecial` IS NULL, '0',`ingreso`.`CEspecial`) AS CEspecial,  c_clasecita.`Id_Programa`  ,ingreso.idModalidad , ingreso.idEntornoAtencion , ingreso.idTipoDiscapacidad  \n FROM `ingreso` INNER JOIN `g_usuario`    ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)  INNER JOIN `h_atencion`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)  INNER JOIN `c_clasecita`  ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)  INNER JOIN `h_tipohistoria`  ON (`h_tipohistoria`.`Id` = `c_clasecita`.`Id_Historia`)  INNER JOIN `f_empresacontxconvenio`   ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)  INNER JOIN `g_persona`  ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`) INNER JOIN `g_tipoedad`  ON (`g_persona`.`Id_TipoEdad` = `g_tipoedad`.`Id`) INNER JOIN `profesional1` ON (`profesional1`.`Id_Persona` = `h_atencion`.`Id_Profesional`) AND  (`profesional1`.`IdEspecialidad` = `h_atencion`.`Id_Especialidad`) LEFT JOIN `f_camas` ON (`f_camas`.`Id` = ingreso.`Cama`)    LEFT JOIN  `h_triage` ON (`h_triage`.`IdIngreso` = `ingreso`.`Id`)   WHERE (DATE_FORMAT(`ingreso`.`FechaIngreso`,'%Y-%m')='" + this.xmt.formatoANO_MES.format(this.JDCFechaAgenda1.getDate()) + "' AND `ingreso`.`Egreso` ='" + this.xestado_atencion + "' AND CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ', `g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2`) like'%" + this.JTFNombre_u.getText() + "%'  AND `ingreso`.`Id_TipoAtencion` =3 AND `ingreso`.`Estado`=0    )  GROUP BY `ingreso`.`Id` ORDER BY `ingreso`.`HoraIngreso` ASC ";
                            }
                        } else if (this.JCHFiltro_Profesional_U.isSelected()) {
                            if (this.xtipo == 0) {
                                this.xsql = "SELECT `ingreso`.`Id` , DATE_FORMAT(`ingreso`.`FechaIngreso`,'%d-%m-%Y') AS FIngreso , `ingreso`.`HoraIngreso` ,  `g_usuario`.`NoHistoria`, CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ', `g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2`) AS `NUsuario` , `g_persona`.`Id_Sexo` ,  CONCAT(`g_persona`.`Edad` , ' ', `g_tipoedad`.`Nbre`, '(s)') AS `Edad` , `f_empresacontxconvenio`.`Nbre` AS `NEmpresa`, IF(f_camas.`Nbre`IS NULL, '', f_camas.`Nbre`) AS Cama , `ingreso`.`Egreso` ,  IF(`ingreso`.`FEgreso` IS NULL, '', DATE_FORMAT(`ingreso`.`FEgreso`,'%d-%m-%Y')) AS FEgreso, `g_persona`.`Id`,  `c_clasecita`.`Id_Historia`,0, `ingreso`.`Id_TipoAtencion`, profesional1.`NProfesional`,`h_atencion`.`Id_ClaseCita`, `h_atencion`.`TipoGuardado`,`h_atencion`.Urgente,  ifnull(`h_triage`.`Clasificacion`,-1) CTriage      ,IF(`ingreso`.`CEspecial` IS NULL, '0',`ingreso`.`CEspecial`) AS CEspecial,  c_clasecita.`Id_Programa`  ,ingreso.idModalidad , ingreso.idEntornoAtencion , ingreso.idTipoDiscapacidad  \n FROM `ingreso` INNER JOIN `g_usuario`    ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)  INNER JOIN `h_atencion`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)  INNER JOIN `c_clasecita`  ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)  INNER JOIN `h_tipohistoria`  ON (`h_tipohistoria`.`Id` = `c_clasecita`.`Id_Historia`)  INNER JOIN `f_empresacontxconvenio`   ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)  INNER JOIN `g_persona`  ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`) INNER JOIN `g_tipoedad`  ON (`g_persona`.`Id_TipoEdad` = `g_tipoedad`.`Id`) INNER JOIN `profesional1` ON (`profesional1`.`Id_Persona` = `h_atencion`.`Id_Profesional`) AND  (`profesional1`.`IdEspecialidad` = `h_atencion`.`Id_Especialidad`) LEFT JOIN `f_camas` ON (`f_camas`.`Id` = ingreso.`Cama`)    LEFT JOIN  `h_triage` ON (`h_triage`.`IdIngreso` = `ingreso`.`Id`)   WHERE (`profesional1`.`Id_Persona`='" + this.xid_profesional + "' AND DATE_FORMAT(`ingreso`.`FechaIngreso`,'%Y-%m-%d')='" + this.xmt.formatoAMD1.format(this.JDCFechaAgenda1.getDate()) + "' AND `ingreso`.`Egreso` ='" + this.xestado_atencion + "' AND CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ', `g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2`) like'%" + this.JTFNombre_u.getText() + "%'  AND `ingreso`.`Id_TipoAtencion` =3 AND `ingreso`.`Estado`=0    )  GROUP BY `ingreso`.`Id` ORDER BY `ingreso`.`HoraIngreso` ASC ";
                            } else if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL LOCAL DE MONTELIBANO")) {
                                this.xsql = "SELECT\n `ingreso`.`Id` , \n DATE_FORMAT(`ingreso`.`FechaIngreso`,'%d-%m-%Y') AS FIngreso ,\n `ingreso`.`HoraIngreso` ,  \n `g_usuario`.`NoHistoria`, \n CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ', `g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2`) AS `NUsuario` , \n `g_persona`.`Id_Sexo` ,  \n `CalculaTiempo_AMD_2Fechas`(g_persona.`FechaNac`, h_atencion.`Fecha_Atencion`) AS `Edad` , \n `f_empresacontxconvenio`.`Nbre` AS `NEmpresa`, \n IF(f_camas.`Nbre`IS NULL, '', f_camas.`Nbre`) AS Cama ,\n IF(h_egreso_atencion.`Id` IS NULL, 0, 1) Egreso , \n IF(h_egreso_atencion.`Id`  IS NULL, '', DATE_FORMAT(`h_egreso_atencion`.`FechaSO`,'%d-%m-%Y')) AS FEgreso, \n `g_persona`.`Id`,  `c_clasecita`.`Id_Historia`,0, \n `ingreso`.`Id_TipoAtencion`, \n CONCAT(`profesional`.`Apellido1` ,' ', `profesional`.`Apellido2` ,' ', `profesional`.`Nombre1` ,' ', `profesional`.`Nombre2`) `NProfesional`,`h_atencion`.`Id_ClaseCita`, `h_atencion`.`TipoGuardado`,`h_atencion`.Urgente,  IFNULL(`h_triage`.`Clasificacion`,-1) CTriage       ,IF(`ingreso`.`CEspecial` IS NULL, '0',`ingreso`.`CEspecial`) AS CEspecial,  c_clasecita.`Id_Programa`  \n ,ingreso.idModalidad , ingreso.idEntornoAtencion , ingreso.idTipoDiscapacidad  \n   \nFROM\n     `h_atencion`\n    INNER JOIN  `ingreso` \n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN  `g_usuario` \n        ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)\n    INNER JOIN  `f_empresacontxconvenio` \n        ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)\n    INNER JOIN  `c_clasecita` \n        ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)\n    INNER JOIN  `g_especialidad` \n        ON (`h_atencion`.`Id_Especialidad` = `g_especialidad`.`Id`)\n    INNER JOIN  `g_persona` \n        ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\n    INNER JOIN  `h_tipohistoria` \n        ON (`c_clasecita`.`Id_Historia` = `h_tipohistoria`.`Id`)\n    INNER JOIN  `g_persona` AS `profesional` \n        ON (`profesional`.`Id` = `h_atencion`.`Id_Profesional`)\n    LEFT JOIN  `h_egreso_atencion` \n        ON (`h_egreso_atencion`.`Id_Ingreso` = `ingreso`.`Id`) AND (`h_egreso_atencion`.`Id_Tipo` = `ingreso`.`Id_TipoAtencion`)\n        LEFT JOIN `f_camas` ON (`f_camas`.`Id` = ingreso.`Cama`)   \n       LEFT JOIN  `h_triage` ON (`h_triage`.`IdIngreso` = `ingreso`.`Id`)    \nWHERE (ingreso.`Id_Sede` ='" + Principal.sedeUsuarioSeleccionadaDTO.getId() + "' AND ingreso.`CS_Parto`=0   AND `ingreso`.`Id_TipoAtencion` =3  AND `ingreso`.`Estado`=0  AND (IF(h_egreso_atencion.`Id` IS NULL, 0, 1) =" + this.xestado_atencion + " AND ingreso.`Egreso`=0)\nAND DATE_FORMAT(ingreso.`Fecha`, '%Y')='" + this.xmt.formatoANO.format(this.JDCFechaAgenda1.getDate()) + "')\nORDER BY ingreso.`FechaIngreso` DESC, `ingreso`.`HoraIngreso` ASC;";
                            } else {
                                this.xsql = "SELECT `ingreso`.`Id` , DATE_FORMAT(`ingreso`.`FechaIngreso`,'%d-%m-%Y') AS FIngreso , `ingreso`.`HoraIngreso` ,  `g_usuario`.`NoHistoria`, CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ', `g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2`) AS `NUsuario` , `g_persona`.`Id_Sexo` ,  CONCAT(`g_persona`.`Edad` , ' ', `g_tipoedad`.`Nbre`, '(s)') AS `Edad` , `f_empresacontxconvenio`.`Nbre` AS `NEmpresa`, IF(f_camas.`Nbre`IS NULL, '', f_camas.`Nbre`) AS Cama , `ingreso`.`Egreso` ,  IF(`ingreso`.`FEgreso` IS NULL, '', DATE_FORMAT(`ingreso`.`FEgreso`,'%d-%m-%Y')) AS FEgreso, `g_persona`.`Id`,  `c_clasecita`.`Id_Historia`,0, `ingreso`.`Id_TipoAtencion`, profesional1.`NProfesional`,`h_atencion`.`Id_ClaseCita`, `h_atencion`.`TipoGuardado` ,`h_atencion`.Urgente,  ifnull(`h_triage`.`Clasificacion`,-1) CTriage     ,IF(`ingreso`.`CEspecial` IS NULL, '0',`ingreso`.`CEspecial`) AS CEspecial,  c_clasecita.`Id_Programa`  ,ingreso.idModalidad , ingreso.idEntornoAtencion , ingreso.idTipoDiscapacidad  \n FROM `ingreso` INNER JOIN `g_usuario`    ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)  INNER JOIN `h_atencion`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)  INNER JOIN `c_clasecita`  ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)  INNER JOIN `h_tipohistoria`  ON (`h_tipohistoria`.`Id` = `c_clasecita`.`Id_Historia`)  INNER JOIN `f_empresacontxconvenio`   ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)  INNER JOIN `g_persona`  ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`) INNER JOIN `g_tipoedad`  ON (`g_persona`.`Id_TipoEdad` = `g_tipoedad`.`Id`) INNER JOIN `profesional1` ON (`profesional1`.`Id_Persona` = `h_atencion`.`Id_Profesional`) AND  (`profesional1`.`IdEspecialidad` = `h_atencion`.`Id_Especialidad`) LEFT JOIN `f_camas` ON (`f_camas`.`Id` = ingreso.`Cama`)    LEFT JOIN  `h_triage` ON (`h_triage`.`IdIngreso` = `ingreso`.`Id`)    WHERE (`profesional1`.`Id_Persona`='" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "' AND DATE_FORMAT(`ingreso`.`FechaIngreso`,'%Y-%m-%d')='" + this.xmt.formatoAMD1.format(this.JDCFechaAgenda1.getDate()) + "' AND `ingreso`.`Egreso` ='" + this.xestado_atencion + "' AND CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ', `g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2`) like'%" + this.JTFNombre_u.getText() + "%'  AND `ingreso`.`Id_TipoAtencion` =3 AND `ingreso`.`Estado`=0    )  GROUP BY `ingreso`.`Id` ORDER BY `ingreso`.`HoraIngreso` ASC ";
                            }
                        } else if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL LOCAL DE MONTELIBANO")) {
                            this.xsql = "SELECT\n `ingreso`.`Id` , \n DATE_FORMAT(`ingreso`.`FechaIngreso`,'%d-%m-%Y') AS FIngreso ,\n `ingreso`.`HoraIngreso` ,  \n `g_usuario`.`NoHistoria`, \n CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ', `g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2`) AS `NUsuario` , \n `g_persona`.`Id_Sexo` ,  \n `CalculaTiempo_AMD_2Fechas`(g_persona.`FechaNac`, h_atencion.`Fecha_Atencion`) AS `Edad` , \n `f_empresacontxconvenio`.`Nbre` AS `NEmpresa`, \n IF(f_camas.`Nbre`IS NULL, '', f_camas.`Nbre`) AS Cama ,\n IF(h_egreso_atencion.`Id` IS NULL, 0, 1) Egreso , \n IF(h_egreso_atencion.`Id`  IS NULL, '', DATE_FORMAT(`h_egreso_atencion`.`FechaSO`,'%d-%m-%Y')) AS FEgreso, \n `g_persona`.`Id`,  `c_clasecita`.`Id_Historia`,0, \n `ingreso`.`Id_TipoAtencion`, \n CONCAT(`profesional`.`Apellido1` ,' ', `profesional`.`Apellido2` ,' ', `profesional`.`Nombre1` ,' ', `profesional`.`Nombre2`) `NProfesional`,`h_atencion`.`Id_ClaseCita`, `h_atencion`.`TipoGuardado`,`h_atencion`.Urgente,  IFNULL(`h_triage`.`Clasificacion`,-1) CTriage       ,IF(`ingreso`.`CEspecial` IS NULL, '0',`ingreso`.`CEspecial`) AS CEspecial,  c_clasecita.`Id_Programa`  \n ,ingreso.idModalidad , ingreso.idEntornoAtencion , ingreso.idTipoDiscapacidad  \n   \nFROM\n     `h_atencion`\n    INNER JOIN  `ingreso` \n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN  `g_usuario` \n        ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)\n    INNER JOIN  `f_empresacontxconvenio` \n        ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)\n    INNER JOIN  `c_clasecita` \n        ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)\n    INNER JOIN  `g_especialidad` \n        ON (`h_atencion`.`Id_Especialidad` = `g_especialidad`.`Id`)\n    INNER JOIN  `g_persona` \n        ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\n    INNER JOIN  `h_tipohistoria` \n        ON (`c_clasecita`.`Id_Historia` = `h_tipohistoria`.`Id`)\n    INNER JOIN  `g_persona` AS `profesional` \n        ON (`profesional`.`Id` = `h_atencion`.`Id_Profesional`)\n    LEFT JOIN  `h_egreso_atencion` \n        ON (`h_egreso_atencion`.`Id_Ingreso` = `ingreso`.`Id`) AND (`h_egreso_atencion`.`Id_Tipo` = `ingreso`.`Id_TipoAtencion`)\n        LEFT JOIN `f_camas` ON (`f_camas`.`Id` = ingreso.`Cama`)   \n       LEFT JOIN  `h_triage` ON (`h_triage`.`IdIngreso` = `ingreso`.`Id`)    \nWHERE (ingreso.`Id_Sede` ='" + Principal.sedeUsuarioSeleccionadaDTO.getId() + "' AND ingreso.`CS_Parto`=0   AND `ingreso`.`Id_TipoAtencion` =3  AND `ingreso`.`Estado`=0  AND (IF(h_egreso_atencion.`Id` IS NULL, 0, 1) =" + this.xestado_atencion + " AND ingreso.`Egreso`=0)\nAND CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ', `g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2`) like'%" + this.JTFNombre_u.getText() + "%'  AND  DATE_FORMAT(ingreso.`Fecha`, '%Y')='" + this.xmt.formatoANO.format(this.JDCFechaAgenda1.getDate()) + "')\nORDER BY ingreso.`FechaIngreso` DESC, `ingreso`.`HoraIngreso` ASC;";
                        } else {
                            this.xsql = "SELECT `ingreso`.`Id` , DATE_FORMAT(`ingreso`.`FechaIngreso`,'%d-%m-%Y') AS FIngreso , `ingreso`.`HoraIngreso` ,  `g_usuario`.`NoHistoria`, CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ', `g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2`) AS `NUsuario` , `g_persona`.`Id_Sexo` ,  CONCAT(`g_persona`.`Edad` , ' ', `g_tipoedad`.`Nbre`, '(s)') AS `Edad` , `f_empresacontxconvenio`.`Nbre` AS `NEmpresa`, IF(f_camas.`Nbre`IS NULL, '', f_camas.`Nbre`) AS Cama , `ingreso`.`Egreso` ,  IF(`ingreso`.`FEgreso` IS NULL, '', DATE_FORMAT(`ingreso`.`FEgreso`,'%d-%m-%Y')) AS FEgreso, `g_persona`.`Id`,  `c_clasecita`.`Id_Historia`,0, `ingreso`.`Id_TipoAtencion`, profesional1.`NProfesional`, `h_atencion`.`Id_ClaseCita` , `h_atencion`.`TipoGuardado`,`h_atencion`.Urgente,  ifnull(`h_triage`.`Clasificacion`,-1) CTriage      ,IF(`ingreso`.`CEspecial` IS NULL, '0',`ingreso`.`CEspecial`) AS CEspecial,  c_clasecita.`Id_Programa`  ,ingreso.idModalidad , ingreso.idEntornoAtencion , ingreso.idTipoDiscapacidad  \n FROM `ingreso` INNER JOIN `g_usuario`    ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)  INNER JOIN `h_atencion`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)  INNER JOIN `c_clasecita`  ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)  INNER JOIN `h_tipohistoria`  ON (`h_tipohistoria`.`Id` = `c_clasecita`.`Id_Historia`)  INNER JOIN `f_empresacontxconvenio`   ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)  INNER JOIN `g_persona`  ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`) INNER JOIN `g_tipoedad`  ON (`g_persona`.`Id_TipoEdad` = `g_tipoedad`.`Id`) INNER JOIN `profesional1` ON (`profesional1`.`Id_Persona` = `h_atencion`.`Id_Profesional`) AND  (`profesional1`.`IdEspecialidad` = `h_atencion`.`Id_Especialidad`) LEFT JOIN `f_camas` ON (`f_camas`.`Id` = ingreso.`Cama`)    LEFT JOIN  `h_triage` ON (`h_triage`.`IdIngreso` = `ingreso`.`Id`)   WHERE ( DATE_FORMAT(`ingreso`.`FechaIngreso`,'%Y-%m-%d')='" + this.xmt.formatoAMD1.format(this.JDCFechaAgenda1.getDate()) + "' AND `ingreso`.`Egreso` ='" + this.xestado_atencion + "' AND CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ', `g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2`) like'%" + this.JTFNombre_u.getText() + "%'  AND `ingreso`.`Id_TipoAtencion` =3 AND `ingreso`.`Estado`=0    )  GROUP BY `ingreso`.`Id` ORDER BY `ingreso`.`HoraIngreso` ASC ";
                        }
                    } else if (this.JRBDeAlta_U.isSelected()) {
                        if (this.JCHFiltro_Profesional_U.isSelected()) {
                            if (this.xtipo == 0) {
                                this.xsql = "SELECT `ingreso`.`Id` , DATE_FORMAT(`ingreso`.`FechaIngreso`,'%d-%m-%Y') AS FIngreso , `ingreso`.`HoraIngreso` ,   `g_usuario`.`NoHistoria`, CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ', `g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2`) AS `NUsuario` , `g_persona`.`Id_Sexo` ,  CONCAT(`g_persona`.`Edad` , ' ', `g_tipoedad`.`Nbre`, '(s)') AS `Edad` , `f_empresacontxconvenio`.`Nbre` AS `NEmpresa`, IF(f_camas.`Nbre`IS NULL, '', f_camas.`Nbre`) AS Cama , `ingreso`.`Egreso` ,  IF(`ingreso`.`FEgreso` IS NULL, '', DATE_FORMAT(`ingreso`.`FEgreso`,'%d-%m-%Y')) AS FEgreso, `g_persona`.`Id`,  `c_clasecita`.`Id_Historia`,0, `ingreso`.`Id_TipoAtencion`, profesional1.`NProfesional`,`h_atencion`.`Id_ClaseCita`, `h_atencion`.`TipoGuardado`,`h_atencion`.Urgente,  ifnull(`h_triage`.`Clasificacion`,-1) CTriage       ,IF(`ingreso`.`CEspecial` IS NULL, '0',`ingreso`.`CEspecial`) AS CEspecial,  c_clasecita.`Id_Programa`  ,ingreso.idModalidad , ingreso.idEntornoAtencion , ingreso.idTipoDiscapacidad  \n FROM `ingreso` INNER JOIN `g_usuario`    ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)  INNER JOIN `h_atencion`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)  INNER JOIN `c_clasecita`  ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)  INNER JOIN `h_tipohistoria`  ON (`h_tipohistoria`.`Id` = `c_clasecita`.`Id_Historia`)  INNER JOIN `f_empresacontxconvenio`   ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`) INNER JOIN `g_persona`  ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`) INNER JOIN `g_tipoedad`  ON (`g_persona`.`Id_TipoEdad` = `g_tipoedad`.`Id`)  INNER JOIN `profesional1` ON (`profesional1`.`Id_Persona` = `h_atencion`.`Id_Profesional`) AND  (`profesional1`.`IdEspecialidad` = `h_atencion`.`Id_Especialidad`) LEFT JOIN `f_camas` ON (`f_camas`.`Id` = ingreso.`Cama`)    LEFT JOIN  `h_triage` ON (`h_triage`.`IdIngreso` = `ingreso`.`Id`)   WHERE (`profesional1`.`Id_Persona`='" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "' AND DATE_FORMAT(`ingreso`.`FechaIngreso`,'%Y-%m')='" + this.xmt.formatoANO_MES.format(this.JDCFechaAgenda1.getDate()) + "' AND `ingreso`.`Egreso` ='" + this.xestado_atencion + "'  AND `ingreso`.`Id_TipoAtencion` =3  AND `ingreso`.`Estado`=0  )  GROUP BY `ingreso`.`Id` ORDER BY `ingreso`.`HoraIngreso` ASC ";
                            } else {
                                this.xsql = "SELECT `ingreso`.`Id` , DATE_FORMAT(`ingreso`.`FechaIngreso`,'%d-%m-%Y') AS FIngreso , `ingreso`.`HoraIngreso` ,   `g_usuario`.`NoHistoria`, CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ', `g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2`) AS `NUsuario` , `g_persona`.`Id_Sexo` ,  CONCAT(`g_persona`.`Edad` , ' ', `g_tipoedad`.`Nbre`, '(s)') AS `Edad` , `f_empresacontxconvenio`.`Nbre` AS `NEmpresa`, IF(f_camas.`Nbre`IS NULL, '', f_camas.`Nbre`) AS Cama , `ingreso`.`Egreso` ,  IF(`ingreso`.`FEgreso` IS NULL, '', DATE_FORMAT(`ingreso`.`FEgreso`,'%d-%m-%Y')) AS FEgreso, `g_persona`.`Id`,  `c_clasecita`.`Id_Historia`,0, `ingreso`.`Id_TipoAtencion`, profesional1.`NProfesional`,`h_atencion`.`Id_ClaseCita`, `h_atencion`.`TipoGuardado`,`h_atencion`.Urgente,  ifnull(`h_triage`.`Clasificacion`,-1) CTriage       ,IF(`ingreso`.`CEspecial` IS NULL, '0',`ingreso`.`CEspecial`) AS CEspecial,  c_clasecita.`Id_Programa`  ,ingreso.idModalidad , ingreso.idEntornoAtencion , ingreso.idTipoDiscapacidad  \n FROM `ingreso` INNER JOIN `g_usuario`    ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)  INNER JOIN `h_atencion`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)  INNER JOIN `c_clasecita`  ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)  INNER JOIN `h_tipohistoria`  ON (`h_tipohistoria`.`Id` = `c_clasecita`.`Id_Historia`)  INNER JOIN `f_empresacontxconvenio`   ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`) INNER JOIN `g_persona`  ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`) INNER JOIN `g_tipoedad`  ON (`g_persona`.`Id_TipoEdad` = `g_tipoedad`.`Id`)  INNER JOIN `profesional1` ON (`profesional1`.`Id_Persona` = `h_atencion`.`Id_Profesional`) AND  (`profesional1`.`IdEspecialidad` = `h_atencion`.`Id_Especialidad`) LEFT JOIN `f_camas` ON (`f_camas`.`Id` = ingreso.`Cama`)    LEFT JOIN  `h_triage` ON (`h_triage`.`IdIngreso` = `ingreso`.`Id`)   WHERE (`profesional1`.`Id_Persona`='" + this.xid_profesional + "' AND DATE_FORMAT(`ingreso`.`FechaIngreso`,'%Y-%m')='" + this.xmt.formatoANO_MES.format(this.JDCFechaAgenda1.getDate()) + "' AND `ingreso`.`Egreso` ='" + this.xestado_atencion + "'  AND `ingreso`.`Id_TipoAtencion` =3  AND `ingreso`.`Estado`=0  )  GROUP BY `ingreso`.`Id` ORDER BY `ingreso`.`HoraIngreso` ASC ";
                            }
                        } else if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL LOCAL DE MONTELIBANO")) {
                            this.xsql = "SELECT\n `ingreso`.`Id` , \n DATE_FORMAT(`ingreso`.`FechaIngreso`,'%d-%m-%Y') AS FIngreso ,\n `ingreso`.`HoraIngreso` ,  \n `g_usuario`.`NoHistoria`, \n CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ', `g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2`) AS `NUsuario` , \n `g_persona`.`Id_Sexo` ,  \n `CalculaTiempo_AMD_2Fechas`(g_persona.`FechaNac`, h_atencion.`Fecha_Atencion`) AS `Edad` , \n `f_empresacontxconvenio`.`Nbre` AS `NEmpresa`, \n IF(f_camas.`Nbre`IS NULL, '', f_camas.`Nbre`) AS Cama ,\n IF(h_egreso_atencion.`Id` IS NULL, 0, 1) Egreso , \n IF(h_egreso_atencion.`Id`  IS NULL, '', DATE_FORMAT(`h_egreso_atencion`.`FechaSO`,'%d-%m-%Y')) AS FEgreso, \n `g_persona`.`Id`,  `c_clasecita`.`Id_Historia`,0, \n `ingreso`.`Id_TipoAtencion`, \n CONCAT(`profesional`.`Apellido1` ,' ', `profesional`.`Apellido2` ,' ', `profesional`.`Nombre1` ,' ', `profesional`.`Nombre2`) `NProfesional`,`h_atencion`.`Id_ClaseCita`, `h_atencion`.`TipoGuardado`,`h_atencion`.Urgente,  IFNULL(`h_triage`.`Clasificacion`,-1) CTriage       ,IF(`ingreso`.`CEspecial` IS NULL, '0',`ingreso`.`CEspecial`) AS CEspecial,  c_clasecita.`Id_Programa`  \n ,ingreso.idModalidad , ingreso.idEntornoAtencion , ingreso.idTipoDiscapacidad  \n   \nFROM\n     `h_atencion`\n    INNER JOIN  `ingreso` \n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN  `g_usuario` \n        ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)\n    INNER JOIN  `f_empresacontxconvenio` \n        ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)\n    INNER JOIN  `c_clasecita` \n        ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)\n    INNER JOIN  `g_especialidad` \n        ON (`h_atencion`.`Id_Especialidad` = `g_especialidad`.`Id`)\n    INNER JOIN  `g_persona` \n        ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\n    INNER JOIN  `h_tipohistoria` \n        ON (`c_clasecita`.`Id_Historia` = `h_tipohistoria`.`Id`)\n    INNER JOIN  `g_persona` AS `profesional` \n        ON (`profesional`.`Id` = `h_atencion`.`Id_Profesional`)\n    LEFT JOIN  `h_egreso_atencion` \n        ON (`h_egreso_atencion`.`Id_Ingreso` = `ingreso`.`Id`) AND (`h_egreso_atencion`.`Id_Tipo` = `ingreso`.`Id_TipoAtencion`)\n        LEFT JOIN `f_camas` ON (`f_camas`.`Id` = ingreso.`Cama`)   \n       LEFT JOIN  `h_triage` ON (`h_triage`.`IdIngreso` = `ingreso`.`Id`)    \nWHERE (ingreso.`Id_Sede` ='" + Principal.sedeUsuarioSeleccionadaDTO.getId() + "' AND ingreso.`CS_Parto`=0   AND `ingreso`.`Id_TipoAtencion` =3  AND `ingreso`.`Estado`=0  AND (IF(h_egreso_atencion.`Id` IS NULL, 0, 1) =" + this.xestado_atencion + " AND ingreso.`Egreso`=0)\nAND DATE_FORMAT(ingreso.`Fecha`, '%Y')='" + this.xmt.formatoANO.format(this.JDCFechaAgenda1.getDate()) + "')\nORDER BY ingreso.`FechaIngreso` DESC, `ingreso`.`HoraIngreso` ASC;";
                        } else {
                            this.xsql = "SELECT `ingreso`.`Id` , DATE_FORMAT(`ingreso`.`FechaIngreso`,'%d-%m-%Y') AS FIngreso , `ingreso`.`HoraIngreso` ,   `g_usuario`.`NoHistoria`, CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ', `g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2`) AS `NUsuario` , `g_persona`.`Id_Sexo` ,  CONCAT(`g_persona`.`Edad` , ' ', `g_tipoedad`.`Nbre`, '(s)') AS `Edad` , `f_empresacontxconvenio`.`Nbre` AS `NEmpresa`, IF(f_camas.`Nbre`IS NULL, '', f_camas.`Nbre`) AS Cama , `ingreso`.`Egreso` ,  IF(`ingreso`.`FEgreso` IS NULL, '', DATE_FORMAT(`ingreso`.`FEgreso`,'%d-%m-%Y')) AS FEgreso, `g_persona`.`Id`,  `c_clasecita`.`Id_Historia`,0, `ingreso`.`Id_TipoAtencion`, profesional1.`NProfesional`,`h_atencion`.`Id_ClaseCita`, `h_atencion`.`TipoGuardado`,`h_atencion`.Urgente,  ifnull(`h_triage`.`Clasificacion`,-1) CTriage       ,IF(`ingreso`.`CEspecial` IS NULL, '0',`ingreso`.`CEspecial`) AS CEspecial,  c_clasecita.`Id_Programa`  ,ingreso.idModalidad , ingreso.idEntornoAtencion , ingreso.idTipoDiscapacidad  \n FROM `ingreso` INNER JOIN `g_usuario`    ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)  INNER JOIN `h_atencion`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)  INNER JOIN `c_clasecita`  ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)  INNER JOIN `h_tipohistoria`  ON (`h_tipohistoria`.`Id` = `c_clasecita`.`Id_Historia`)  INNER JOIN `f_empresacontxconvenio`   ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`) INNER JOIN `g_persona`  ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`) INNER JOIN `g_tipoedad`  ON (`g_persona`.`Id_TipoEdad` = `g_tipoedad`.`Id`)  INNER JOIN `profesional1` ON (`profesional1`.`Id_Persona` = `h_atencion`.`Id_Profesional`) AND  (`profesional1`.`IdEspecialidad` = `h_atencion`.`Id_Especialidad`) LEFT JOIN `f_camas` ON (`f_camas`.`Id` = ingreso.`Cama`)    LEFT JOIN  `h_triage` ON (`h_triage`.`IdIngreso` = `ingreso`.`Id`)   WHERE (DATE_FORMAT(`ingreso`.`FechaIngreso`,'%Y-%m')='" + this.xmt.formatoANO_MES.format(this.JDCFechaAgenda1.getDate()) + "' AND `ingreso`.`Egreso` ='" + this.xestado_atencion + "'  AND `ingreso`.`Id_TipoAtencion` =3  AND `ingreso`.`Estado`=0  )  GROUP BY `ingreso`.`Id` ORDER BY `ingreso`.`HoraIngreso` ASC ";
                        }
                    } else if (this.JCHFiltro_Profesional_U.isSelected()) {
                        if (this.xtipo == 0) {
                            this.xsql = "SELECT `ingreso`.`Id` , DATE_FORMAT(`ingreso`.`FechaIngreso`,'%d-%m-%Y') AS FIngreso , `ingreso`.`HoraIngreso` ,   `g_usuario`.`NoHistoria`, CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ', `g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2`) AS `NUsuario` , `g_persona`.`Id_Sexo` ,  CONCAT(`g_persona`.`Edad` , ' ', `g_tipoedad`.`Nbre`, '(s)') AS `Edad` , `f_empresacontxconvenio`.`Nbre` AS `NEmpresa`, IF(f_camas.`Nbre`IS NULL, '', f_camas.`Nbre`) AS Cama , `ingreso`.`Egreso` ,  IF(`ingreso`.`FEgreso` IS NULL, '', DATE_FORMAT(`ingreso`.`FEgreso`,'%d-%m-%Y')) AS FEgreso, `g_persona`.`Id`,  `c_clasecita`.`Id_Historia`,0, `ingreso`.`Id_TipoAtencion`, profesional1.`NProfesional`,`h_atencion`.`Id_ClaseCita`, `h_atencion`.`TipoGuardado`,`h_atencion`.Urgente,  ifnull(`h_triage`.`Clasificacion`,-1) CTriage       ,IF(`ingreso`.`CEspecial` IS NULL, '0',`ingreso`.`CEspecial`) AS CEspecial,  c_clasecita.`Id_Programa`  ,ingreso.idModalidad , ingreso.idEntornoAtencion , ingreso.idTipoDiscapacidad  \n FROM `ingreso` INNER JOIN `g_usuario`    ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)  INNER JOIN `h_atencion`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)  INNER JOIN `c_clasecita`  ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)  INNER JOIN `h_tipohistoria`  ON (`h_tipohistoria`.`Id` = `c_clasecita`.`Id_Historia`)  INNER JOIN `f_empresacontxconvenio`   ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`) INNER JOIN `g_persona`  ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`) INNER JOIN `g_tipoedad`  ON (`g_persona`.`Id_TipoEdad` = `g_tipoedad`.`Id`) INNER JOIN `profesional1` ON (`profesional1`.`Id_Persona` = `h_atencion`.`Id_Profesional`) AND  (`profesional1`.`IdEspecialidad` = `h_atencion`.`Id_Especialidad`) LEFT JOIN `f_camas` ON (`f_camas`.`Id` = ingreso.`Cama`)    LEFT JOIN  `h_triage` ON (`h_triage`.`IdIngreso` = `ingreso`.`Id`)    WHERE (`profesional1`.`Id_Persona`='" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "' AND DATE_FORMAT(`ingreso`.`FechaIngreso`,'%Y-%m-%d')='" + this.xmt.formatoAMD1.format(this.JDCFechaAgenda1.getDate()) + "' AND `ingreso`.`Egreso` ='" + this.xestado_atencion + "'  AND `ingreso`.`Id_TipoAtencion` =3  AND `ingreso`.`Estado`=0  )  GROUP BY `ingreso`.`Id` ORDER BY `ingreso`.`HoraIngreso` ASC ";
                        } else {
                            this.xsql = "SELECT `ingreso`.`Id` , DATE_FORMAT(`ingreso`.`FechaIngreso`,'%d-%m-%Y') AS FIngreso , `ingreso`.`HoraIngreso` ,   `g_usuario`.`NoHistoria`, CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ', `g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2`) AS `NUsuario` , `g_persona`.`Id_Sexo` ,  CONCAT(`g_persona`.`Edad` , ' ', `g_tipoedad`.`Nbre`, '(s)') AS `Edad` , `f_empresacontxconvenio`.`Nbre` AS `NEmpresa`, IF(f_camas.`Nbre`IS NULL, '', f_camas.`Nbre`) AS Cama , `ingreso`.`Egreso` ,  IF(`ingreso`.`FEgreso` IS NULL, '', DATE_FORMAT(`ingreso`.`FEgreso`,'%d-%m-%Y')) AS FEgreso, `g_persona`.`Id`,  `c_clasecita`.`Id_Historia`,0, `ingreso`.`Id_TipoAtencion`, profesional1.`NProfesional`,`h_atencion`.`Id_ClaseCita`, `h_atencion`.`TipoGuardado` ,`h_atencion`.Urgente,  ifnull(`h_triage`.`Clasificacion`,-1) CTriage      ,IF(`ingreso`.`CEspecial` IS NULL, '0',`ingreso`.`CEspecial`) AS CEspecial,  c_clasecita.`Id_Programa`  ,ingreso.idModalidad , ingreso.idEntornoAtencion , ingreso.idTipoDiscapacidad  \n FROM `ingreso` INNER JOIN `g_usuario`    ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)  INNER JOIN `h_atencion`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)  INNER JOIN `c_clasecita`  ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)  INNER JOIN `h_tipohistoria`  ON (`h_tipohistoria`.`Id` = `c_clasecita`.`Id_Historia`)  INNER JOIN `f_empresacontxconvenio`   ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`) INNER JOIN `g_persona`  ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`) INNER JOIN `g_tipoedad`  ON (`g_persona`.`Id_TipoEdad` = `g_tipoedad`.`Id`) INNER JOIN `profesional1` ON (`profesional1`.`Id_Persona` = `h_atencion`.`Id_Profesional`) AND  (`profesional1`.`IdEspecialidad` = `h_atencion`.`Id_Especialidad`) LEFT JOIN `f_camas` ON (`f_camas`.`Id` = ingreso.`Cama`)    LEFT JOIN  `h_triage` ON (`h_triage`.`IdIngreso` = `ingreso`.`Id`)     WHERE (`profesional1`.`Id_Persona`='" + this.xid_profesional + "' AND DATE_FORMAT(`ingreso`.`FechaIngreso`,'%Y-%m-%d')='" + this.xmt.formatoAMD1.format(this.JDCFechaAgenda1.getDate()) + "' AND `ingreso`.`Egreso` ='" + this.xestado_atencion + "'  AND `ingreso`.`Id_TipoAtencion` =3  AND `ingreso`.`Estado`=0  )  GROUP BY `ingreso`.`Id` ORDER BY `ingreso`.`HoraIngreso` ASC ";
                        }
                    } else if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL LOCAL DE MONTELIBANO")) {
                        this.xsql = "SELECT\n `ingreso`.`Id` , \n DATE_FORMAT(`ingreso`.`FechaIngreso`,'%d-%m-%Y') AS FIngreso ,\n `ingreso`.`HoraIngreso` ,  \n `g_usuario`.`NoHistoria`, \n CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ', `g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2`) AS `NUsuario` , \n `g_persona`.`Id_Sexo` ,  \n `CalculaTiempo_AMD_2Fechas`(g_persona.`FechaNac`, h_atencion.`Fecha_Atencion`) AS `Edad` , \n `f_empresacontxconvenio`.`Nbre` AS `NEmpresa`, \n IF(f_camas.`Nbre`IS NULL, '', f_camas.`Nbre`) AS Cama ,\n IF(h_egreso_atencion.`Id` IS NULL, 0, 1) Egreso , \n IF(h_egreso_atencion.`Id`  IS NULL, '', DATE_FORMAT(`h_egreso_atencion`.`FechaSO`,'%d-%m-%Y')) AS FEgreso, \n `g_persona`.`Id`,  `c_clasecita`.`Id_Historia`,0, \n `ingreso`.`Id_TipoAtencion`, \n CONCAT(`profesional`.`Apellido1` ,' ', `profesional`.`Apellido2` ,' ', `profesional`.`Nombre1` ,' ', `profesional`.`Nombre2`) `NProfesional`,`h_atencion`.`Id_ClaseCita`, `h_atencion`.`TipoGuardado`,`h_atencion`.Urgente,  IFNULL(`h_triage`.`Clasificacion`,-1) CTriage       ,IF(`ingreso`.`CEspecial` IS NULL, '0',`ingreso`.`CEspecial`) AS CEspecial,  c_clasecita.`Id_Programa`  \n ,ingreso.idModalidad , ingreso.idEntornoAtencion , ingreso.idTipoDiscapacidad  \n   \nFROM\n     `h_atencion`\n    INNER JOIN  `ingreso` \n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN  `g_usuario` \n        ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)\n    INNER JOIN  `f_empresacontxconvenio` \n        ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)\n    INNER JOIN  `c_clasecita` \n        ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)\n    INNER JOIN  `g_especialidad` \n        ON (`h_atencion`.`Id_Especialidad` = `g_especialidad`.`Id`)\n    INNER JOIN  `g_persona` \n        ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\n    INNER JOIN  `h_tipohistoria` \n        ON (`c_clasecita`.`Id_Historia` = `h_tipohistoria`.`Id`)\n    INNER JOIN  `g_persona` AS `profesional` \n        ON (`profesional`.`Id` = `h_atencion`.`Id_Profesional`)\n    LEFT JOIN  `h_egreso_atencion` \n        ON (`h_egreso_atencion`.`Id_Ingreso` = `ingreso`.`Id`) AND (`h_egreso_atencion`.`Id_Tipo` = `ingreso`.`Id_TipoAtencion`)\n        LEFT JOIN `f_camas` ON (`f_camas`.`Id` = ingreso.`Cama`)   \n       LEFT JOIN  `h_triage` ON (`h_triage`.`IdIngreso` = `ingreso`.`Id`)    \nWHERE (ingreso.`Id_Sede` ='" + Principal.sedeUsuarioSeleccionadaDTO.getId() + "' AND ingreso.`CS_Parto`=0   AND `ingreso`.`Id_TipoAtencion` =3  AND `ingreso`.`Estado`=0  AND (IF(h_egreso_atencion.`Id` IS NULL, 0, 1) =" + this.xestado_atencion + " AND ingreso.`Egreso`=0)\nAND DATE_FORMAT(ingreso.`Fecha`, '%Y')='" + this.xmt.formatoANO.format(this.JDCFechaAgenda1.getDate()) + "')\nORDER BY ingreso.`FechaIngreso` DESC, `ingreso`.`HoraIngreso` ASC;";
                    } else {
                        this.xsql = "SELECT `ingreso`.`Id` , DATE_FORMAT(`ingreso`.`FechaIngreso`,'%d-%m-%Y') AS FIngreso , `ingreso`.`HoraIngreso` ,   `g_usuario`.`NoHistoria`, CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ', `g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2`) AS `NUsuario` , `g_persona`.`Id_Sexo` ,  CONCAT(`g_persona`.`Edad` , ' ', `g_tipoedad`.`Nbre`, '(s)') AS `Edad` , `f_empresacontxconvenio`.`Nbre` AS `NEmpresa`, IF(f_camas.`Nbre`IS NULL, '', f_camas.`Nbre`) AS Cama , `ingreso`.`Egreso` ,  IF(`ingreso`.`FEgreso` IS NULL, '', DATE_FORMAT(`ingreso`.`FEgreso`,'%d-%m-%Y')) AS FEgreso, `g_persona`.`Id`,  `c_clasecita`.`Id_Historia`,0, `ingreso`.`Id_TipoAtencion`, profesional1.`NProfesional`,`h_atencion`.`Id_ClaseCita`, `h_atencion`.`TipoGuardado`,`h_atencion`.Urgente,  ifnull(`h_triage`.`Clasificacion`,-1) CTriage       ,IF(`ingreso`.`CEspecial` IS NULL, '0',`ingreso`.`CEspecial`) AS CEspecial,  c_clasecita.`Id_Programa`  ,ingreso.idModalidad , ingreso.idEntornoAtencion , ingreso.idTipoDiscapacidad  \n FROM `ingreso` INNER JOIN `g_usuario`    ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)  INNER JOIN `h_atencion`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)  INNER JOIN `c_clasecita`  ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)  INNER JOIN `h_tipohistoria`  ON (`h_tipohistoria`.`Id` = `c_clasecita`.`Id_Historia`)  INNER JOIN `f_empresacontxconvenio`   ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`) INNER JOIN `g_persona`  ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`) INNER JOIN `g_tipoedad`  ON (`g_persona`.`Id_TipoEdad` = `g_tipoedad`.`Id`) INNER JOIN `profesional1` ON (`profesional1`.`Id_Persona` = `h_atencion`.`Id_Profesional`) AND  (`profesional1`.`IdEspecialidad` = `h_atencion`.`Id_Especialidad`) LEFT JOIN `f_camas` ON (`f_camas`.`Id` = ingreso.`Cama`)    LEFT JOIN  `h_triage` ON (`h_triage`.`IdIngreso` = `ingreso`.`Id`)   WHERE ( DATE_FORMAT(`ingreso`.`FechaIngreso`,'%Y-%m-%d')='" + this.xmt.formatoAMD1.format(this.JDCFechaAgenda1.getDate()) + "' AND `ingreso`.`Egreso` ='" + this.xestado_atencion + "'  AND `ingreso`.`Id_TipoAtencion` =3  AND `ingreso`.`Estado`=0  )  GROUP BY `ingreso`.`Id` ORDER BY `ingreso`.`HoraIngreso` ASC ";
                    }
                } else if (this.JCHFiltro_U.isSelected()) {
                    if (this.JRBDeAlta_U.isSelected()) {
                        this.xsql = "SELECT `ingreso`.`Id` , DATE_FORMAT(`ingreso`.`FechaIngreso`,'%d-%m-%Y') AS FIngreso , `ingreso`.`HoraIngreso` ,  `g_usuario`.`NoHistoria`, CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ', `g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2`) AS `NUsuario` , `g_persona`.`Id_Sexo` ,  CONCAT(`g_persona`.`Edad` , ' ', `g_tipoedad`.`Nbre`, '(s)') AS `Edad` , `f_empresacontxconvenio`.`Nbre` AS `NEmpresa`, IF(`f_camas`.`Nbre` IS NULL, '',`f_camas`.`Nbre`) AS `Cama` , `ingreso`.`Egreso` , IF(`ingreso`.`FEgreso` IS NULL, '', DATE_FORMAT(`ingreso`.`FEgreso`,'%d-%m-%Y')) AS FEgreso, `g_persona`.`Id`,  h_tiponota_especialidad.`Id_Historia`,0, `ingreso`.`Id_TipoAtencion`, profesional1.`NProfesional`,0  as Id_ClaseCita, `h_atencion`.`TipoGuardado`,`h_atencion`.Urgente,  ifnull(`h_triage`.`Clasificacion`,-1) CTriage    ,IF(`ingreso`.`CEspecial` IS NULL, '0',`ingreso`.`CEspecial`) AS CEspecial,  c_clasecita.`Id_Programa`  ,ingreso.idModalidad , ingreso.idEntornoAtencion , ingreso.idTipoDiscapacidad  \n FROM `ingreso` INNER JOIN `g_usuario`    ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`) INNER JOIN `h_atencion`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN `c_clasecita`  ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`) INNER JOIN `h_notasclinicas`  ON (`h_notasclinicas`.`Id_Atencion` = `h_atencion`.`Id`) INNER JOIN `h_ordenes_interconsultas`  ON (`h_ordenes_interconsultas`.`Id_Nota` = `h_notasclinicas`.`Id`) INNER JOIN `f_empresacontxconvenio`   ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`) INNER JOIN `h_tiponota`  ON (`h_notasclinicas`.`Id_TipoNota` = `h_tiponota`.`Id`) INNER JOIN `h_tiponota_especialidad`  ON (`h_tiponota_especialidad`.`Id_TipoNota` = `h_tiponota`.`Id`) INNER JOIN `g_persona`  ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`) INNER JOIN `g_tipoedad`  ON (`g_persona`.`Id_TipoEdad` = `g_tipoedad`.`Id`)  INNER JOIN `profesional1` ON (`profesional1`.`Id_Persona` = `h_atencion`.`Id_Profesional`) AND  (`profesional1`.`IdEspecialidad` = `h_atencion`.`Id_Especialidad`) LEFT JOIN `f_camas` ON (`f_camas`.`Id` = ingreso.`Cama`)    LEFT JOIN  `h_triage` ON (`h_triage`.`IdIngreso` = `ingreso`.`Id`)   WHERE (DATE_FORMAT(`ingreso`.`FechaIngreso`,'%Y-%m')='" + this.xmt.formatoANO_MES.format(this.JDCFechaAgenda1.getDate()) + "' AND CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ', `g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2`) like'%" + this.JTFNombre_u.getText() + "%' AND  `ingreso`.`Egreso` ='" + this.xestado_atencion + "'  AND `ingreso`.`Id_TipoAtencion` =3  AND `ingreso`.`Estado`=0  AND `h_ordenes_interconsultas`.`Id_Especialidad`='" + this.xid_especialidad + "' and  h_tiponota_especialidad.`Id_Historia` <>0 )  GROUP BY `ingreso`.`Id`  ORDER BY `ingreso`.`FechaIngreso` DESC , `ingreso`.`HoraIngreso` DESC ";
                    } else {
                        this.xsql = "SELECT `ingreso`.`Id` , DATE_FORMAT(`ingreso`.`FechaIngreso`,'%d-%m-%Y') AS FIngreso , `ingreso`.`HoraIngreso` ,  `g_usuario`.`NoHistoria`, CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ', `g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2`) AS `NUsuario` , `g_persona`.`Id_Sexo` ,  CONCAT(`g_persona`.`Edad` , ' ', `g_tipoedad`.`Nbre`, '(s)') AS `Edad` , `f_empresacontxconvenio`.`Nbre` AS `NEmpresa`, IF(`f_camas`.`Nbre` IS NULL, '',`f_camas`.`Nbre`) AS `Cama` , `ingreso`.`Egreso` , IF(`ingreso`.`FEgreso` IS NULL, '', DATE_FORMAT(`ingreso`.`FEgreso`,'%d-%m-%Y')) AS FEgreso, `g_persona`.`Id`,  h_tiponota_especialidad.`Id_Historia`,0, `ingreso`.`Id_TipoAtencion`, profesional1.`NProfesional`,0  as Id_ClaseCita, `h_atencion`.`TipoGuardado`,`h_atencion`.Urgente,  ifnull(`h_triage`.`Clasificacion`,-1) CTriage    ,IF(`ingreso`.`CEspecial` IS NULL, '0',`ingreso`.`CEspecial`) AS CEspecial,  c_clasecita.`Id_Programa`  ,ingreso.idModalidad , ingreso.idEntornoAtencion , ingreso.idTipoDiscapacidad  \n FROM `ingreso` INNER JOIN `g_usuario`    ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`) INNER JOIN `h_atencion`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN `c_clasecita`  ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`) INNER JOIN `h_notasclinicas`  ON (`h_notasclinicas`.`Id_Atencion` = `h_atencion`.`Id`) INNER JOIN `h_ordenes_interconsultas`  ON (`h_ordenes_interconsultas`.`Id_Nota` = `h_notasclinicas`.`Id`) INNER JOIN `f_empresacontxconvenio`   ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`) INNER JOIN `h_tiponota`  ON (`h_notasclinicas`.`Id_TipoNota` = `h_tiponota`.`Id`) INNER JOIN `h_tiponota_especialidad`  ON (`h_tiponota_especialidad`.`Id_TipoNota` = `h_tiponota`.`Id`) INNER JOIN `g_persona`  ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`) INNER JOIN `g_tipoedad`  ON (`g_persona`.`Id_TipoEdad` = `g_tipoedad`.`Id`)  INNER JOIN `profesional1` ON (`profesional1`.`Id_Persona` = `h_atencion`.`Id_Profesional`) AND  (`profesional1`.`IdEspecialidad` = `h_atencion`.`Id_Especialidad`) LEFT JOIN `f_camas` ON (`f_camas`.`Id` = ingreso.`Cama`)    LEFT JOIN  `h_triage` ON (`h_triage`.`IdIngreso` = `ingreso`.`Id`)   WHERE ( `ingreso`.`Egreso` ='" + this.xestado_atencion + "'  AND `ingreso`.`Id_TipoAtencion` =3  AND CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ', `g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2`) like'%" + this.JTFNombre_u.getText() + "%'  AND `ingreso`.`Estado`=0  AND `h_ordenes_interconsultas`.`Id_Especialidad`='" + this.xid_especialidad + "' and  h_tiponota_especialidad.`Id_Historia` <>0 )  GROUP BY `ingreso`.`Id` ORDER BY `ingreso`.`FechaIngreso` DESC , `ingreso`.`HoraIngreso` DESC ";
                    }
                } else if (this.JRBDeAlta_U.isSelected()) {
                    this.xsql = "SELECT `ingreso`.`Id` , DATE_FORMAT(`ingreso`.`FechaIngreso`,'%d-%m-%Y') AS FIngreso , `ingreso`.`HoraIngreso` ,  `g_usuario`.`NoHistoria`, CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ', `g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2`) AS `NUsuario` , `g_persona`.`Id_Sexo` ,  CONCAT(`g_persona`.`Edad` , ' ', `g_tipoedad`.`Nbre`, '(s)') AS `Edad` , `f_empresacontxconvenio`.`Nbre` AS `NEmpresa`, IF(`f_camas`.`Nbre` IS NULL, '',`f_camas`.`Nbre`) AS `Cama` , `ingreso`.`Egreso` , IF(`ingreso`.`FEgreso` IS NULL, '', DATE_FORMAT(`ingreso`.`FEgreso`,'%d-%m-%Y')) AS FEgreso, `g_persona`.`Id`,  h_tiponota_especialidad.`Id_Historia`,0, `ingreso`.`Id_TipoAtencion`, profesional1.`NProfesional`,0 as Id_ClaseCita, `h_atencion`.`TipoGuardado`,`h_atencion`.Urgente,  ifnull(`h_triage`.`Clasificacion`,-1) CTriage     ,IF(`ingreso`.`CEspecial` IS NULL, '0',`ingreso`.`CEspecial`) AS CEspecial,  c_clasecita.`Id_Programa`  ,ingreso.idModalidad , ingreso.idEntornoAtencion , ingreso.idTipoDiscapacidad  \n FROM `ingreso` INNER JOIN `g_usuario`    ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`) INNER JOIN `h_atencion`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN `c_clasecita`  ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`) INNER JOIN `h_notasclinicas`  ON (`h_notasclinicas`.`Id_Atencion` = `h_atencion`.`Id`) INNER JOIN `h_ordenes_interconsultas`  ON (`h_ordenes_interconsultas`.`Id_Nota` = `h_notasclinicas`.`Id`) INNER JOIN `f_empresacontxconvenio`   ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`) INNER JOIN `h_tiponota`  ON (`h_notasclinicas`.`Id_TipoNota` = `h_tiponota`.`Id`) INNER JOIN `h_tiponota_especialidad`  ON (`h_tiponota_especialidad`.`Id_TipoNota` = `h_tiponota`.`Id`) INNER JOIN `g_persona`  ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`) INNER JOIN `g_tipoedad`  ON (`g_persona`.`Id_TipoEdad` = `g_tipoedad`.`Id`)  INNER JOIN `profesional1` ON (`profesional1`.`Id_Persona` = `h_atencion`.`Id_Profesional`) AND  (`profesional1`.`IdEspecialidad` = `h_atencion`.`Id_Especialidad`) LEFT JOIN `f_camas` ON (`f_camas`.`Id` = ingreso.`Cama`)    LEFT JOIN  `h_triage` ON (`h_triage`.`IdIngreso` = `ingreso`.`Id`)   WHERE (DATE_FORMAT(`ingreso`.`FechaIngreso`,'%Y-%m')='" + this.xmt.formatoANO_MES.format(this.JDCFechaAgenda1.getDate()) + "' AND  CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ', `g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2`) like'%" + this.JTFNombre_u.getText() + "%' and `ingreso`.`Egreso` ='" + this.xestado_atencion + "'  AND `ingreso`.`Id_TipoAtencion` =3 AND `ingreso`.`Estado`=0  AND `h_ordenes_interconsultas`.`Id_Especialidad`='" + this.xid_especialidad + "' and  h_tiponota_especialidad.`Id_Historia` <>0 )  GROUP BY `ingreso`.`Id` ORDER BY `ingreso`.`FechaIngreso` DESC , `ingreso`.`HoraIngreso` DESC ";
                } else {
                    this.xsql = "SELECT `ingreso`.`Id` , DATE_FORMAT(`ingreso`.`FechaIngreso`,'%d-%m-%Y') AS FIngreso , `ingreso`.`HoraIngreso` ,  `g_usuario`.`NoHistoria`, CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ', `g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2`) AS `NUsuario` , `g_persona`.`Id_Sexo` ,  CONCAT(`g_persona`.`Edad` , ' ', `g_tipoedad`.`Nbre`, '(s)') AS `Edad` , `f_empresacontxconvenio`.`Nbre` AS `NEmpresa`, IF(`f_camas`.`Nbre` IS NULL, '',`f_camas`.`Nbre`) AS `Cama` , `ingreso`.`Egreso` , IF(`ingreso`.`FEgreso` IS NULL, '', DATE_FORMAT(`ingreso`.`FEgreso`,'%d-%m-%Y')) AS FEgreso, `g_persona`.`Id`,  h_tiponota_especialidad.`Id_Historia`,0, `ingreso`.`Id_TipoAtencion`, profesional1.`NProfesional`,0 as Id_ClaseCita, `h_atencion`.`TipoGuardado`,`h_atencion`.Urgente,  ifnull(`h_triage`.`Clasificacion`,-1) CTriage     ,IF(`ingreso`.`CEspecial` IS NULL, '0',`ingreso`.`CEspecial`) AS CEspecial,  c_clasecita.`Id_Programa`  ,ingreso.idModalidad , ingreso.idEntornoAtencion , ingreso.idTipoDiscapacidad  \n FROM `ingreso` INNER JOIN `g_usuario`    ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`) INNER JOIN `h_atencion`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN `c_clasecita`  ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`) INNER JOIN `h_notasclinicas`  ON (`h_notasclinicas`.`Id_Atencion` = `h_atencion`.`Id`) INNER JOIN `h_ordenes_interconsultas`  ON (`h_ordenes_interconsultas`.`Id_Nota` = `h_notasclinicas`.`Id`) INNER JOIN `f_empresacontxconvenio`   ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`) INNER JOIN `h_tiponota`  ON (`h_notasclinicas`.`Id_TipoNota` = `h_tiponota`.`Id`) INNER JOIN `h_tiponota_especialidad`  ON (`h_tiponota_especialidad`.`Id_TipoNota` = `h_tiponota`.`Id`) INNER JOIN `g_persona`  ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`) INNER JOIN `g_tipoedad`  ON (`g_persona`.`Id_TipoEdad` = `g_tipoedad`.`Id`)  INNER JOIN `profesional1` ON (`profesional1`.`Id_Persona` = `h_atencion`.`Id_Profesional`) AND  (`profesional1`.`IdEspecialidad` = `h_atencion`.`Id_Especialidad`) LEFT JOIN `f_camas` ON (`f_camas`.`Id` = ingreso.`Cama`)    LEFT JOIN  `h_triage` ON (`h_triage`.`IdIngreso` = `ingreso`.`Id`)    WHERE ( CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ', `g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2`) like'%" + this.JTFNombre_u.getText() + "%' and `ingreso`.`Egreso` ='" + this.xestado_atencion + "'  AND `ingreso`.`Id_TipoAtencion` =3 AND `ingreso`.`Estado`=0  AND `h_ordenes_interconsultas`.`Id_Especialidad`='" + this.xid_especialidad + "' and  h_tiponota_especialidad.`Id_Historia` <>0 )  GROUP BY `ingreso`.`Id` ORDER BY `ingreso`.`FechaIngreso` DESC , `ingreso`.`HoraIngreso` DESC ";
                }
                ConsultasMySQL xct1 = new ConsultasMySQL();
                ResultSet xrs = xct1.traerRs(this.xsql);
                int xfila = 0;
                int nAtendidos = 0;
                int xPorAtender = 0;
                int nEnAtencion = 0;
                if (xrs.next()) {
                    xrs.beforeFirst();
                    this.xmt.mEstablecerTextEditor(this.JTAgendaU, 4);
                    this.xmt.mEstablecerTextEditor(this.JTAgendaU, 7);
                    this.xmt.mEstablecerTextEditor(this.JTAgendaU, 16);
                    while (xrs.next()) {
                        this.xmodelo_urgencias.addRow(this.xdato);
                        this.xmodelo_urgencias.setValueAt(Long.valueOf(xrs.getLong(1)), xfila, 0);
                        this.xmodelo_urgencias.setValueAt(xrs.getString(2), xfila, 1);
                        this.xmodelo_urgencias.setValueAt(xrs.getString(3), xfila, 2);
                        this.xmodelo_urgencias.setValueAt(xrs.getString(4), xfila, 3);
                        this.xmodelo_urgencias.setValueAt(xrs.getString(5), xfila, 4);
                        this.xmodelo_urgencias.setValueAt(xrs.getString(6), xfila, 5);
                        this.xmodelo_urgencias.setValueAt(xrs.getString(7), xfila, 6);
                        this.xmodelo_urgencias.setValueAt("NUEVA ORDEN", xfila, 11);
                        this.xmodelo_urgencias.setValueAt(xrs.getString(8), xfila, 7);
                        this.xmodelo_urgencias.setValueAt(xrs.getString(9), xfila, 8);
                        this.xmodelo_urgencias.setValueAt(xrs.getString(11), xfila, 9);
                        this.xmodelo_urgencias.setValueAt(Long.valueOf(xrs.getLong(10)), xfila, 10);
                        this.xmodelo_urgencias.setValueAt(Long.valueOf(xrs.getLong(12)), xfila, 12);
                        this.xmodelo_urgencias.setValueAt(Long.valueOf(xrs.getLong(13)), xfila, 13);
                        this.xmodelo_urgencias.setValueAt(Long.valueOf(xrs.getLong(14)), xfila, 14);
                        this.xmodelo_urgencias.setValueAt(Long.valueOf(xrs.getLong("Id_TipoAtencion")), xfila, 15);
                        this.xmodelo_urgencias.setValueAt(xrs.getString("NProfesional"), xfila, 16);
                        this.xmodelo_urgencias.setValueAt(xrs.getString("Id_ClaseCita"), xfila, 17);
                        this.xmodelo_urgencias.setValueAt(Long.valueOf(xrs.getLong("TipoGuardado")), xfila, 18);
                        switch (xrs.getInt("TipoGuardado")) {
                            case 0:
                                xPorAtender++;
                                break;
                            case 1:
                                nAtendidos++;
                                break;
                            default:
                                nEnAtencion++;
                                break;
                        }
                        this.xmodelo_urgencias.setValueAt(Long.valueOf(xrs.getLong("Urgente")), xfila, 19);
                        this.xmodelo_urgencias.setValueAt(Long.valueOf(xrs.getLong("CEspecial")), xfila, 20);
                        switch (xrs.getInt("CEspecial")) {
                            case 1:
                                this.xmodelo_urgencias.setValueAt(new JLabel(new ImageIcon(getClass().getResource("/Imagenes/Atencion Discapasitaods.png"))), xfila, 21);
                                break;
                            case 2:
                                this.xmodelo_urgencias.setValueAt(new JLabel(new ImageIcon(getClass().getResource("/Imagenes/Atencion Embarazada.png"))), xfila, 21);
                                break;
                            case 3:
                                this.xmodelo_urgencias.setValueAt(new JLabel(new ImageIcon(getClass().getResource("/Imagenes/Atencion Ancianos.png"))), xfila, 21);
                                break;
                            case 4:
                                this.xmodelo_urgencias.setValueAt(new JLabel(new ImageIcon(getClass().getResource("/Imagenes/AtpNiños.png"))), xfila, 21);
                                break;
                            default:
                                this.xmodelo_urgencias.setValueAt(new JLabel(""), xfila, 21);
                                break;
                        }
                        this.JTAgendaU.setDefaultRenderer(JLabel.class, new Render(xrs.getInt("CEspecial"), 20));
                        this.xmodelo_urgencias.setValueAt(Long.valueOf(xrs.getLong("CTriage")), xfila, 22);
                        this.xmodelo_urgencias.setValueAt(Long.valueOf(xrs.getLong("Id_Programa")), xfila, 23);
                        this.xmodelo_urgencias.setValueAt(Integer.valueOf(xrs.getInt("idModalidad")), xfila, 24);
                        this.xmodelo_urgencias.setValueAt(Integer.valueOf(xrs.getInt("idEntornoAtencion")), xfila, 25);
                        this.xmodelo_urgencias.setValueAt(Integer.valueOf(xrs.getInt("idTipoDiscapacidad")), xfila, 26);
                        this.JTAgendaU.setDefaultRenderer(Object.class, new MiRender2());
                        xfila++;
                    }
                }
                if (this.JRBEnAtencion_U.isSelected()) {
                    this.JLBNRegistro_U.setBorder(BorderFactory.createTitledBorder((Border) null, "Cant.", 2, 0, new Font("Arial", 1, 12), Color.cyan));
                    this.JLBNRegistro_U.setText("" + xPorAtender);
                    this.JLBNREnAtencion.setText("" + nEnAtencion);
                } else {
                    this.JLBNRegistro_U.setBorder(BorderFactory.createTitledBorder((Border) null, "Cant.", 2, 0, new Font("Arial", 1, 12), Color.red));
                    this.JLBNRegistro_U.setText("" + nAtendidos);
                    this.JLBNREnAtencion.setText("" + nEnAtencion);
                }
                if (this.xN_NProgramados != xfila) {
                    this.xN_NProgramados = xfila;
                    this.JTP_DatosAgenda.setBackgroundAt(this.xTab_AUgencias, new Color(0, 255, 255));
                } else {
                    this.JTP_DatosAgenda.setBackgroundAt(this.xTab_AUgencias, new Color(240, 240, 240));
                }
                xrs.close();
                xct1.cerrarConexionBd();
                return;
            } catch (SQLException ex) {
                Logger.getLogger(JIFAgendaMedico_N.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                return;
            }
        }
        mCrearTablaAgenda_Urgencias();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTablaAgenda_Hospitalizacion() {
        this.xmodelo_hospitalizacion = new DefaultTableModel(new Object[0], new String[]{"Id_Ingreso", "Fecha", "Hora", "No. Historia", "Usuario", "Sexo", "Edad", "Empresa", "Cama", "FEgreso", "Egreso", "Estado", "Id_Persona", "Id_HC", "Asignación", "Tipo_Atencion", "Tipo_A", "CEspecial", "Id_Programa", "TipoGuardado", "idModalidad", "idEntornoAtencion", "idTipoDiscapacidad"}) { // from class: Historia.JIFAgendaMedico_N.37
            Class[] types = {Long.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Integer.class, String.class, Long.class, Long.class, Long.class, Integer.class, Integer.class, JLabel.class, Integer.class, Integer.class, Integer.class, Integer.class, Integer.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTAgendaH.setModel(this.xmodelo_hospitalizacion);
        this.JTAgendaH.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTAgendaH.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTAgendaH.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTAgendaH.getColumnModel().getColumn(1).setPreferredWidth(20);
        this.JTAgendaH.getColumnModel().getColumn(2).setPreferredWidth(10);
        this.JTAgendaH.getColumnModel().getColumn(3).setPreferredWidth(30);
        this.JTAgendaH.getColumnModel().getColumn(4).setPreferredWidth(200);
        this.JTAgendaH.getColumnModel().getColumn(5).setPreferredWidth(5);
        this.JTAgendaH.getColumnModel().getColumn(6).setPreferredWidth(10);
        this.JTAgendaH.getColumnModel().getColumn(7).setPreferredWidth(150);
        this.JTAgendaH.getColumnModel().getColumn(8).setPreferredWidth(50);
        this.JTAgendaH.getColumnModel().getColumn(9).setPreferredWidth(20);
        this.JTAgendaH.getColumnModel().getColumn(10).setPreferredWidth(0);
        this.JTAgendaH.getColumnModel().getColumn(10).setMinWidth(0);
        this.JTAgendaH.getColumnModel().getColumn(10).setMaxWidth(0);
        this.JTAgendaH.getColumnModel().getColumn(11).setPreferredWidth(0);
        this.JTAgendaH.getColumnModel().getColumn(11).setMinWidth(0);
        this.JTAgendaH.getColumnModel().getColumn(11).setMaxWidth(0);
        this.JTAgendaH.getColumnModel().getColumn(12).setPreferredWidth(0);
        this.JTAgendaH.getColumnModel().getColumn(12).setMinWidth(0);
        this.JTAgendaH.getColumnModel().getColumn(12).setMaxWidth(0);
        this.JTAgendaH.getColumnModel().getColumn(13).setPreferredWidth(0);
        this.JTAgendaH.getColumnModel().getColumn(13).setMinWidth(0);
        this.JTAgendaH.getColumnModel().getColumn(13).setMaxWidth(0);
        this.JTAgendaH.getColumnModel().getColumn(14).setPreferredWidth(0);
        this.JTAgendaH.getColumnModel().getColumn(14).setMinWidth(0);
        this.JTAgendaH.getColumnModel().getColumn(14).setMaxWidth(0);
        this.JTAgendaH.getColumnModel().getColumn(15).setPreferredWidth(0);
        this.JTAgendaH.getColumnModel().getColumn(15).setMinWidth(0);
        this.JTAgendaH.getColumnModel().getColumn(15).setMaxWidth(0);
        this.JTAgendaH.getColumnModel().getColumn(16).setPreferredWidth(0);
        this.JTAgendaH.getColumnModel().getColumn(16).setMinWidth(0);
        this.JTAgendaH.getColumnModel().getColumn(16).setMaxWidth(0);
        this.JTAgendaH.getColumnModel().getColumn(17).setPreferredWidth(50);
        this.JTAgendaH.getColumnModel().getColumn(18).setPreferredWidth(0);
        this.JTAgendaH.getColumnModel().getColumn(18).setMinWidth(0);
        this.JTAgendaH.getColumnModel().getColumn(18).setMaxWidth(0);
        this.JTAgendaH.getColumnModel().getColumn(19).setPreferredWidth(0);
        this.JTAgendaH.getColumnModel().getColumn(19).setMinWidth(0);
        this.JTAgendaH.getColumnModel().getColumn(19).setMaxWidth(0);
        this.JTAgendaH.getColumnModel().getColumn(20).setPreferredWidth(0);
        this.JTAgendaH.getColumnModel().getColumn(20).setMinWidth(0);
        this.JTAgendaH.getColumnModel().getColumn(20).setMaxWidth(0);
        this.JTAgendaH.getColumnModel().getColumn(21).setPreferredWidth(0);
        this.JTAgendaH.getColumnModel().getColumn(21).setMinWidth(0);
        this.JTAgendaH.getColumnModel().getColumn(21).setMaxWidth(0);
        this.JTAgendaH.getColumnModel().getColumn(22).setPreferredWidth(0);
        this.JTAgendaH.getColumnModel().getColumn(22).setMinWidth(0);
        this.JTAgendaH.getColumnModel().getColumn(22).setMaxWidth(0);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTablaAgenda_Cx() {
        this.xmodelo_cx = new DefaultTableModel(new Object[0], new String[]{"Id_Ingreso", "Fecha", "Hora", "No. Historia", "Usuario", "Sexo", "Edad", "Empresa", "Procedimiento", "Egreso", "Estado", "Id_Persona", "Id_HC", "Tipo_Atencion", "idModalidad", "idEntornoAtencion", "idTipoDiscapacidad"}) { // from class: Historia.JIFAgendaMedico_N.38
            Class[] types = {Long.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Integer.class, String.class, Long.class, Long.class, Integer.class, Integer.class, Integer.class, Integer.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTA_Cxgenda.setModel(this.xmodelo_cx);
        this.JTA_Cxgenda.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTA_Cxgenda.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTA_Cxgenda.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTA_Cxgenda.getColumnModel().getColumn(1).setPreferredWidth(20);
        this.JTA_Cxgenda.getColumnModel().getColumn(2).setPreferredWidth(10);
        this.JTA_Cxgenda.getColumnModel().getColumn(3).setPreferredWidth(30);
        this.JTA_Cxgenda.getColumnModel().getColumn(4).setPreferredWidth(200);
        this.JTA_Cxgenda.getColumnModel().getColumn(5).setPreferredWidth(5);
        this.JTA_Cxgenda.getColumnModel().getColumn(6).setPreferredWidth(10);
        this.JTA_Cxgenda.getColumnModel().getColumn(7).setPreferredWidth(150);
        this.JTA_Cxgenda.getColumnModel().getColumn(8).setPreferredWidth(100);
        this.JTA_Cxgenda.getColumnModel().getColumn(9).setPreferredWidth(0);
        this.JTA_Cxgenda.getColumnModel().getColumn(9).setMinWidth(0);
        this.JTA_Cxgenda.getColumnModel().getColumn(9).setMaxWidth(0);
        this.JTA_Cxgenda.getColumnModel().getColumn(10).setPreferredWidth(0);
        this.JTA_Cxgenda.getColumnModel().getColumn(10).setMinWidth(0);
        this.JTA_Cxgenda.getColumnModel().getColumn(10).setMaxWidth(0);
        this.JTA_Cxgenda.getColumnModel().getColumn(11).setPreferredWidth(0);
        this.JTA_Cxgenda.getColumnModel().getColumn(11).setMinWidth(0);
        this.JTA_Cxgenda.getColumnModel().getColumn(11).setMaxWidth(0);
        this.JTA_Cxgenda.getColumnModel().getColumn(12).setPreferredWidth(0);
        this.JTA_Cxgenda.getColumnModel().getColumn(12).setMinWidth(0);
        this.JTA_Cxgenda.getColumnModel().getColumn(12).setMaxWidth(0);
        this.JTA_Cxgenda.getColumnModel().getColumn(13).setPreferredWidth(0);
        this.JTA_Cxgenda.getColumnModel().getColumn(13).setMinWidth(0);
        this.JTA_Cxgenda.getColumnModel().getColumn(13).setMaxWidth(0);
        this.JTA_Cxgenda.getColumnModel().getColumn(14).setPreferredWidth(0);
        this.JTA_Cxgenda.getColumnModel().getColumn(14).setMinWidth(0);
        this.JTA_Cxgenda.getColumnModel().getColumn(14).setMaxWidth(0);
        this.JTA_Cxgenda.getColumnModel().getColumn(15).setPreferredWidth(0);
        this.JTA_Cxgenda.getColumnModel().getColumn(15).setMinWidth(0);
        this.JTA_Cxgenda.getColumnModel().getColumn(15).setMaxWidth(0);
        this.JTA_Cxgenda.getColumnModel().getColumn(16).setPreferredWidth(0);
        this.JTA_Cxgenda.getColumnModel().getColumn(16).setMinWidth(0);
        this.JTA_Cxgenda.getColumnModel().getColumn(16).setMaxWidth(0);
    }

    /* JADX WARN: Finally extract failed */
    public void mCargarDatos_Cx() {
        try {
            if (this.xmodelo_cx != null) {
                mCrearTablaAgenda_Cx();
                if (this.JCHFiltro_Cx.isSelected()) {
                    this.xsql = "SELECT  `q_agendacx`.`Id_Ingreso`  , `q_agendacx`.`FechaCx`  , `q_agendacx`.`HoraInicial`  , `g_usuario`.`NoHistoria`  , CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ', `g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2`) AS `NUsuario` , `g_persona`.`Id_Sexo` , CONCAT(`Devuelve_Edad_2F`(`g_persona`.`FechaNac`, `q_agendacx`.FechaCx) , ' ', `Devuelve_Tipo_Edad_2F`(`g_persona`.`FechaNac`, `q_agendacx`.`FechaCx`)) AS `Edad` , `f_empresacontxconvenio`.`Nbre` AS `NEmpresa` , `g_procedimiento`.`Nbre` AS `NProcedimiento` , IF(`ingreso`.`Egreso` IS NULL, 0, `ingreso`.`Egreso`) AS `Egreso` , IF(`q_agendacx`.`Id_Ingreso`=0,0, IF(`h_atencion`.`TipoGuardado`=1,1,2) ) AS `Estado` , `g_persona`.`Id` , IF( `c_clasecita`.`Id_Historia` IS NULL, 0,  `c_clasecita`.`Id_Historia`) AS `Id_historia` , IF(`ingreso`.`Id_TipoAtencion` IS NULL, 1, `ingreso`.`Id_TipoAtencion`) AS `Id_TipoAtencion`  ,ingreso.idModalidad , ingreso.idEntornoAtencion , ingreso.idTipoDiscapacidad  \nFROM  `q_agendacx`    INNER JOIN  `g_persona`  ON (`q_agendacx`.`Id_Usuario` = `g_persona`.`Id`) INNER JOIN  `f_empresacontxconvenio`    ON (`q_agendacx`.`Id_EmpresaConv` = `f_empresacontxconvenio`.`Id`) INNER JOIN  `profesional1`  ON (`profesional1`.`IdEspecialidad` = `q_agendacx`.`Id_Especialidad`) AND (`profesional1`.`Id_Persona` = `q_agendacx`.`Id_Profesional`) INNER JOIN  `g_procedimiento`   ON (`q_agendacx`.`Id_Procedimiento` = `g_procedimiento`.`Id`) LEFT JOIN  `ingreso`  ON (`q_agendacx`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN  `g_tipoedad`  ON (`g_persona`.`Id_TipoEdad` = `g_tipoedad`.`Id`) INNER JOIN  `g_usuario`  ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`) LEFT JOIN  `h_atencion`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) LEFT JOIN  `c_clasecita`  ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`) WHERE (CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ', `g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2`) like'%" + this.JTFNombre_Cx.getText() + "%' AND `q_agendacx`.`Id_MotivoDesistida` =1 ) ORDER BY `q_agendacx`.`FechaCx` ASC, `q_agendacx`.`HoraInicial` ASC ";
                } else if (this.xid_especialidad.equals("1025") || this.xid_especialidad.equals("1038") || this.xid_especialidad.equals("1030") || this.xid_especialidad.equals("382") || this.xid_especialidad.equals("3") || this.xid_especialidad.equals("1031")) {
                    this.xsql = "SELECT  `q_agendacx`.`Id_Ingreso`  , `q_agendacx`.`FechaCx`  , `q_agendacx`.`HoraInicial`  , `g_usuario`.`NoHistoria`  , CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ', `g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2`) AS `NUsuario` , `g_persona`.`Id_Sexo` , CONCAT(`Devuelve_Edad_2F`(`g_persona`.`FechaNac`, `q_agendacx`.FechaCx) , ' ', `Devuelve_Tipo_Edad_2F`(`g_persona`.`FechaNac`, `q_agendacx`.`FechaCx`)) AS `Edad` , `f_empresacontxconvenio`.`Nbre` AS `NEmpresa` , `g_procedimiento`.`Nbre` AS `NProcedimiento` , IF(`ingreso`.`Egreso` IS NULL, 0, `ingreso`.`Egreso`) AS `Egreso` ,  IF(`q_agendacx`.`Id_Ingreso`=0,0, IF(`h_atencion`.`TipoGuardado`=1,1,2) ) AS `Estado` , `g_persona`.`Id` , IF( `c_clasecita`.`Id_Historia` IS NULL, 0,  `c_clasecita`.`Id_Historia`) AS `Id_historia` , IF(`ingreso`.`Id_TipoAtencion` IS NULL, 1, `ingreso`.`Id_TipoAtencion`) AS `Id_TipoAtencion`  ,ingreso.idModalidad , ingreso.idEntornoAtencion , ingreso.idTipoDiscapacidad  \nFROM  `q_agendacx`    INNER JOIN  `g_persona`  ON (`q_agendacx`.`Id_Usuario` = `g_persona`.`Id`) INNER JOIN  `f_empresacontxconvenio`    ON (`q_agendacx`.`Id_EmpresaConv` = `f_empresacontxconvenio`.`Id`) INNER JOIN  `profesional1`  ON (`profesional1`.`IdEspecialidad` = `q_agendacx`.`Id_Especialidad`) AND (`profesional1`.`Id_Persona` = `q_agendacx`.`Id_Profesional`) INNER JOIN  `g_procedimiento`   ON (`q_agendacx`.`Id_Procedimiento` = `g_procedimiento`.`Id`) LEFT JOIN  `ingreso`  ON (`q_agendacx`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN  `g_tipoedad`  ON (`g_persona`.`Id_TipoEdad` = `g_tipoedad`.`Id`) INNER JOIN  `g_usuario`  ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`) LEFT JOIN  `h_atencion`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) LEFT JOIN  `c_clasecita`  ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`) WHERE (`q_agendacx`.`FechaCx` ='" + this.xmt.formatoAMD1.format(this.JDCFechaAgendaCX.getDate()) + "' AND `q_agendacx`.`Id_MotivoDesistida` =1 ) ORDER BY `q_agendacx`.`FechaCx` ASC, `q_agendacx`.`HoraInicial` ASC ";
                } else {
                    this.xsql = "SELECT  `q_agendacx`.`Id_Ingreso`  , `q_agendacx`.`FechaCx`  , `q_agendacx`.`HoraInicial`  , `g_usuario`.`NoHistoria`  , CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ', `g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2`) AS `NUsuario` , `g_persona`.`Id_Sexo` , CONCAT(`Devuelve_Edad_2F`(`g_persona`.`FechaNac`, `q_agendacx`.FechaCx) , ' ', `Devuelve_Tipo_Edad_2F`(`g_persona`.`FechaNac`, `q_agendacx`.`FechaCx`)) AS `Edad` , `f_empresacontxconvenio`.`Nbre` AS `NEmpresa` , `g_procedimiento`.`Nbre` AS `NProcedimiento` , IF(`ingreso`.`Egreso` IS NULL, 0, `ingreso`.`Egreso`) AS `Egreso` ,  IF(`q_agendacx`.`Id_Ingreso`=0,0, IF(`h_atencion`.`TipoGuardado`=1,1,2) ) AS `Estado` , `g_persona`.`Id` , IF( `c_clasecita`.`Id_Historia` IS NULL, 0,  `c_clasecita`.`Id_Historia`) AS `Id_historia` , IF(`ingreso`.`Id_TipoAtencion` IS NULL, 1, `ingreso`.`Id_TipoAtencion`) AS `Id_TipoAtencion`  ,ingreso.idModalidad , ingreso.idEntornoAtencion , ingreso.idTipoDiscapacidad  \nFROM  `q_agendacx`    INNER JOIN  `g_persona`  ON (`q_agendacx`.`Id_Usuario` = `g_persona`.`Id`) INNER JOIN  `f_empresacontxconvenio`    ON (`q_agendacx`.`Id_EmpresaConv` = `f_empresacontxconvenio`.`Id`) INNER JOIN  `profesional1`  ON (`profesional1`.`IdEspecialidad` = `q_agendacx`.`Id_Especialidad`) AND (`profesional1`.`Id_Persona` = `q_agendacx`.`Id_Profesional`) INNER JOIN  `g_procedimiento`   ON (`q_agendacx`.`Id_Procedimiento` = `g_procedimiento`.`Id`) LEFT JOIN  `ingreso`  ON (`q_agendacx`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN  `g_tipoedad`  ON (`g_persona`.`Id_TipoEdad` = `g_tipoedad`.`Id`) INNER JOIN  `g_usuario`  ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`) LEFT JOIN  `h_atencion`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) LEFT JOIN  `c_clasecita`  ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`) WHERE (`q_agendacx`.`FechaCx` ='" + this.xmt.formatoAMD1.format(this.JDCFechaAgendaCX.getDate()) + "' AND `q_agendacx`.`Id_MotivoDesistida` =1 AND `q_agendacx`.`Id_Especialidad` ='" + this.xid_especialidad + "' AND `q_agendacx`.`Id_Profesional`= '" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "') ORDER BY `q_agendacx`.`FechaCx` ASC, `q_agendacx`.`HoraInicial` ASC ";
                }
                ResultSet xrs = this.xct.traerRs(this.xsql);
                Throwable th = null;
                try {
                    int xfila = 0;
                    if (xrs.next()) {
                        xrs.beforeFirst();
                        this.xmt.mEstablecerTextEditor(this.JTA_Cxgenda, 4);
                        this.xmt.mEstablecerTextEditor(this.JTA_Cxgenda, 8);
                        while (xrs.next()) {
                            this.xmodelo_cx.addRow(this.xdato);
                            this.xmodelo_cx.setValueAt(Long.valueOf(xrs.getLong(1)), xfila, 0);
                            this.xmodelo_cx.setValueAt(xrs.getString(2), xfila, 1);
                            this.xmodelo_cx.setValueAt(xrs.getString(3), xfila, 2);
                            this.xmodelo_cx.setValueAt(xrs.getString(4), xfila, 3);
                            this.xmodelo_cx.setValueAt(xrs.getString(5), xfila, 4);
                            this.xmodelo_cx.setValueAt(xrs.getString(6), xfila, 5);
                            this.xmodelo_cx.setValueAt(xrs.getString(7), xfila, 6);
                            this.xmodelo_cx.setValueAt(xrs.getString(8), xfila, 7);
                            this.xmodelo_cx.setValueAt(xrs.getString(9), xfila, 8);
                            this.xmodelo_cx.setValueAt(Long.valueOf(xrs.getLong(10)), xfila, 9);
                            this.xmodelo_cx.setValueAt(Long.valueOf(xrs.getLong(11)), xfila, 10);
                            this.xmodelo_cx.setValueAt(Long.valueOf(xrs.getLong(12)), xfila, 11);
                            this.xmodelo_cx.setValueAt(Long.valueOf(xrs.getLong(13)), xfila, 12);
                            this.xmodelo_cx.setValueAt(Long.valueOf(xrs.getLong("Id_TipoAtencion")), xfila, 13);
                            this.xmodelo_cx.setValueAt(Integer.valueOf(xrs.getInt("idModalidad")), xfila, 14);
                            this.xmodelo_cx.setValueAt(Integer.valueOf(xrs.getInt("idEntornoAtencion")), xfila, 15);
                            this.xmodelo_cx.setValueAt(Integer.valueOf(xrs.getInt("idTipoDiscapacidad")), xfila, 16);
                            this.JTA_Cxgenda.setDefaultRenderer(Object.class, new MiRender3());
                            xfila++;
                        }
                        this.JLB_CxNRegistro.setText("" + xfila);
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
                    this.xct.cerrarConexionBd();
                } catch (Throwable th3) {
                    if (xrs != null) {
                        if (0 != 0) {
                            try {
                                xrs.close();
                            } catch (Throwable th4) {
                                th.addSuppressed(th4);
                            }
                        } else {
                            xrs.close();
                        }
                    }
                    throw th3;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(JIFAgendaMedico_N.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mCargarDatos_Hospitalizacion() {
        if (this.xmodelo_hospitalizacion != null) {
            try {
                mCrearTablaAgenda_Hospitalizacion();
                if (this.JCH_FSalaParto.isSelected()) {
                    if (this.JCHFiltro_H.isSelected()) {
                        if (this.JRBDeAlta_H.isSelected()) {
                            this.xsql = "SELECT `ingreso`.`Id` , DATE_FORMAT(`ingreso`.`FechaIngreso`,'%d-%m-%Y') AS FIngreso , `ingreso`.`HoraIngreso` ,  `g_usuario`.`NoHistoria`, CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ', `g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2`) AS `NUsuario` , `g_persona`.`Id_Sexo` ,  CONCAT(`g_persona`.`Edad` , ' ', `g_tipoedad`.`Nbre`, '(s)') AS `Edad` , `f_empresacontxconvenio`.`Nbre` AS `NEmpresa`, IF(f_camas.`Nbre`IS NULL, '', f_camas.`Nbre`) AS Cama , `ingreso`.`Egreso` ,  IF(`ingreso`.`FEgreso_H` IS NULL, '', DATE_FORMAT(`ingreso`.`FEgreso_H`,'%d-%m-%Y')) AS FEgreso_H, `g_persona`.`Id`,  `c_clasecita`.`Id_Historia`,0, `ingreso`.`Id_TipoAtencion`   ,IF(`ingreso`.`CEspecial` IS NULL, '0',`ingreso`.`CEspecial`) AS CEspecial, `c_clasecita`.`Id_Programa`, `h_atencion`.`TipoGuardado`  ,ingreso.idModalidad , ingreso.idEntornoAtencion , ingreso.idTipoDiscapacidad  \nFROM `ingreso` INNER JOIN `g_usuario`    ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)  INNER JOIN `h_atencion`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)  INNER JOIN `c_clasecita`  ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)  INNER JOIN `h_tipohistoria`  ON (`h_tipohistoria`.`Id` = `c_clasecita`.`Id_Historia`)  INNER JOIN `f_empresacontxconvenio`   ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)  INNER JOIN `g_persona`  ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`) INNER JOIN `g_tipoedad`  ON (`g_persona`.`Id_TipoEdad` = `g_tipoedad`.`Id`) LEFT JOIN `f_camas` ON (`f_camas`.`Id` = ingreso.`Cama`) WHERE (ingreso.`CS_Parto`=1 and DATE_FORMAT(`ingreso`.`FechaIngreso`,'%Y-%m')='" + this.xmt.formatoANO_MES.format(this.JDCFechaAgenda2.getDate()) + "' AND (`ingreso`.`Egreso_H` ='" + this.xestado_atencion_h + "' or `ingreso`.`Egreso` ='" + this.xestado_atencion_h + "')  AND CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ', `g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2`) like'" + this.JTFNombre_H.getText() + "%'  AND `ingreso`.`Id_TipoAtencion` in(2,3) AND `ingreso`.`Estado`=0    )  GROUP BY `ingreso`.`Id` ORDER BY CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ', `g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2`) ASC, `ingreso`.`FechaIngreso` DESC ";
                        } else {
                            this.xsql = "SELECT `ingreso`.`Id` , DATE_FORMAT(`ingreso`.`FechaIngreso`,'%d-%m-%Y') AS FIngreso , `ingreso`.`HoraIngreso` ,  `g_usuario`.`NoHistoria`, CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ', `g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2`) AS `NUsuario` , `g_persona`.`Id_Sexo` ,  CONCAT(`g_persona`.`Edad` , ' ', `g_tipoedad`.`Nbre`, '(s)') AS `Edad` , `f_empresacontxconvenio`.`Nbre` AS `NEmpresa`, IF(f_camas.`Nbre`IS NULL, '', f_camas.`Nbre`) AS Cama , `ingreso`.`Egreso` ,  IF(`ingreso`.`FEgreso_H` IS NULL, '', DATE_FORMAT(`ingreso`.`FEgreso_H`,'%d-%m-%Y')) AS FEgreso_H, `g_persona`.`Id`,  `c_clasecita`.`Id_Historia`,0, `ingreso`.`Id_TipoAtencion`   ,IF(`ingreso`.`CEspecial` IS NULL, '0',`ingreso`.`CEspecial`) AS CEspecial, `c_clasecita`.`Id_Programa`, `h_atencion`.`TipoGuardado`  ,ingreso.idModalidad , ingreso.idEntornoAtencion , ingreso.idTipoDiscapacidad  \nFROM `ingreso` INNER JOIN `g_usuario`    ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)  INNER JOIN `h_atencion`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)  INNER JOIN `c_clasecita`  ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)  INNER JOIN `h_tipohistoria`  ON (`h_tipohistoria`.`Id` = `c_clasecita`.`Id_Historia`)  INNER JOIN `f_empresacontxconvenio`   ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)  INNER JOIN `g_persona`  ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`) INNER JOIN `g_tipoedad`  ON (`g_persona`.`Id_TipoEdad` = `g_tipoedad`.`Id`) WHERE (ingreso.`CS_Parto`=1 and (`ingreso`.`Egreso_H` ='" + this.xestado_atencion_h + "' or `ingreso`.`Egreso` ='" + this.xestado_atencion_h + "')  AND CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ', `g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2`) like'%" + this.JTFNombre_H.getText() + "%'  AND `ingreso`.`Id_TipoAtencion` in(2,3) AND `ingreso`.`Estado`=0    )  GROUP BY `ingreso`.`Id` ORDER BY CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ', `g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2`) ASC ";
                        }
                    } else if (this.JRBDeAlta_H.isSelected()) {
                        this.xsql = "SELECT `ingreso`.`Id` , DATE_FORMAT(`ingreso`.`FechaIngreso`,'%d-%m-%Y') AS FIngreso , `ingreso`.`HoraIngreso` ,   `g_usuario`.`NoHistoria`, CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ', `g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2`) AS `NUsuario` , `g_persona`.`Id_Sexo` ,  CONCAT(`g_persona`.`Edad` , ' ', `g_tipoedad`.`Nbre`, '(s)') AS `Edad` , `f_empresacontxconvenio`.`Nbre` AS `NEmpresa`, IF(f_camas.`Nbre`IS NULL, '', f_camas.`Nbre`) AS Cama , `ingreso`.`Egreso` ,  IF(`ingreso`.`FEgreso_H` IS NULL, '', DATE_FORMAT(`ingreso`.`FEgreso_H`,'%d-%m-%Y')) AS FEgreso_H, `g_persona`.`Id`,  `c_clasecita`.`Id_Historia`,0, `ingreso`.`Id_TipoAtencion`   ,IF(`ingreso`.`CEspecial` IS NULL, '0',`ingreso`.`CEspecial`) AS CEspecial, `c_clasecita`.`Id_Programa`, `h_atencion`.`TipoGuardado`  ,ingreso.idModalidad , ingreso.idEntornoAtencion , ingreso.idTipoDiscapacidad  \nFROM `ingreso` INNER JOIN `g_usuario`    ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)  INNER JOIN `h_atencion`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)  INNER JOIN `c_clasecita`  ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)  INNER JOIN `h_tipohistoria`  ON (`h_tipohistoria`.`Id` = `c_clasecita`.`Id_Historia`)  INNER JOIN `f_empresacontxconvenio`   ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`) INNER JOIN `g_persona`  ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`) INNER JOIN `g_tipoedad`  ON (`g_persona`.`Id_TipoEdad` = `g_tipoedad`.`Id`) LEFT JOIN `f_camas` ON (`f_camas`.`Id` = ingreso.`Cama`)  WHERE (ingreso.`CS_Parto`=1 and DATE_FORMAT(`ingreso`.`FechaIngreso`,'%Y-%m')='" + this.xmt.formatoANO_MES.format(this.JDCFechaAgenda2.getDate()) + "' AND (`ingreso`.`Egreso_H` ='" + this.xestado_atencion_h + "' or `ingreso`.`Egreso` ='" + this.xestado_atencion_h + "')   AND `ingreso`.`Id_TipoAtencion` in(2,3)  AND `ingreso`.`Estado`=0  )  GROUP BY `ingreso`.`Id` ORDER BY CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ', `g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2`) ASC, `ingreso`.`FechaIngreso` DESC ";
                    } else {
                        this.xsql = "SELECT `ingreso`.`Id` , DATE_FORMAT(`ingreso`.`FechaIngreso`,'%d-%m-%Y') AS FIngreso , `ingreso`.`HoraIngreso` ,   `g_usuario`.`NoHistoria`, CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ', `g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2`) AS `NUsuario` , `g_persona`.`Id_Sexo` ,  CONCAT(`g_persona`.`Edad` , ' ', `g_tipoedad`.`Nbre`, '(s)') AS `Edad` , `f_empresacontxconvenio`.`Nbre` AS `NEmpresa`, IF(f_camas.`Nbre`IS NULL, '', f_camas.`Nbre`) AS Cama , `ingreso`.`Egreso` ,  IF(`ingreso`.`FEgreso_H` IS NULL, '', DATE_FORMAT(`ingreso`.`FEgreso_H`,'%d-%m-%Y')) AS FEgreso_H, `g_persona`.`Id`,  `c_clasecita`.`Id_Historia`,0, `ingreso`.`Id_TipoAtencion`   ,IF(`ingreso`.`CEspecial` IS NULL, '0',`ingreso`.`CEspecial`) AS CEspecial, `c_clasecita`.`Id_Programa`, `h_atencion`.`TipoGuardado`  ,ingreso.idModalidad , ingreso.idEntornoAtencion , ingreso.idTipoDiscapacidad  \nFROM `ingreso` INNER JOIN `g_usuario`    ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)  INNER JOIN `h_atencion`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)  INNER JOIN `c_clasecita`  ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)  INNER JOIN `h_tipohistoria`  ON (`h_tipohistoria`.`Id` = `c_clasecita`.`Id_Historia`)  INNER JOIN `f_empresacontxconvenio`   ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`) INNER JOIN `g_persona`  ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`) INNER JOIN `g_tipoedad`  ON (`g_persona`.`Id_TipoEdad` = `g_tipoedad`.`Id`) LEFT JOIN `f_camas` ON (`f_camas`.`Id` = ingreso.`Cama`)  WHERE (ingreso.`CS_Parto`=1 and (`ingreso`.`Egreso_H` ='" + this.xestado_atencion_h + "' or `ingreso`.`Egreso` ='" + this.xestado_atencion_h + "')  AND `ingreso`.`Id_TipoAtencion` in(2,3)  AND `ingreso`.`Estado`=0  )  GROUP BY `ingreso`.`Id` ORDER BY CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ', `g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2`) ASC ";
                    }
                } else if (Principal.informacionIps.getNombreIps().equals("CLINICA LAURELES PSIQUIATRAS ASOCIADOS I.P.S. S.A.S.") || Principal.informacionIps.getNombreIps().equals("CAMBIA TU VIDA IPS SAS") || Principal.informacionIps.getNombreIps().equals("INSTITUTO COLOMBIANO DE NEUROCIENCIAS APLICADAS S.A.S.") || Principal.informacionIps.getNombreIps().equals("IPS ESPERANZAS DE VIDA SAS") || Principal.informacionIps.getNombreIps().equals("UNION TEMPORAL CLINICA LAURELES")) {
                    if (this.JCHFiltro_H.isSelected()) {
                        if (this.JRBDeAlta_H.isSelected()) {
                            if (Principal.informacionIps.getNombreIps().equals("CAMBIA TU VIDA IPS SAS")) {
                                this.xsql = "SELECT `ingreso`.`Id` , DATE_FORMAT(`ingreso`.`FechaIngreso`,'%d-%m-%Y') AS FIngreso , `ingreso`.`HoraIngreso` ,  `g_usuario`.`NoHistoria`, CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ', `g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2`) AS `NUsuario` , `g_persona`.`Id_Sexo` ,  CONCAT(`g_persona`.`Edad` , ' ', `g_tipoedad`.`Nbre`, '(s)') AS `Edad` , `f_empresacontxconvenio`.`Nbre` AS `NEmpresa`, IF(f_camas.`Nbre`IS NULL, '', f_camas.`Nbre`) AS Cama , `ingreso`.`Egreso_H` ,  IF(`ingreso`.`FEgreso_H` IS NULL, '', DATE_FORMAT(`ingreso`.`FEgreso_H`,'%d-%m-%Y')) AS FEgreso_H, `g_persona`.`Id`, 68,0, `ingreso`.`Id_TipoAtencion`   ,IF(`ingreso`.`CEspecial` IS NULL, '0',`ingreso`.`CEspecial`) AS CEspecial, `c_clasecita`.`Id_Programa`, `h_atencion`.`TipoGuardado`  ,ingreso.idModalidad , ingreso.idEntornoAtencion , ingreso.idTipoDiscapacidad  \nFROM `ingreso` INNER JOIN `g_usuario`    ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)  INNER JOIN `h_atencion`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)  INNER JOIN `c_clasecita`  ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)  INNER JOIN `h_tipohistoria`  ON (`h_tipohistoria`.`Id` = `c_clasecita`.`Id_Historia`)  INNER JOIN `f_empresacontxconvenio`   ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)  INNER JOIN `g_persona`  ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`) INNER JOIN `g_tipoedad`  ON (`g_persona`.`Id_TipoEdad` = `g_tipoedad`.`Id`) LEFT JOIN `f_camas` ON (`f_camas`.`Id` = ingreso.`Cama`)  WHERE (DATE_FORMAT(`ingreso`.`FechaIngreso`,'%Y')='" + this.xmt.formatoANO.format(this.JDCFechaAgenda2.getDate()) + "' AND `ingreso`.`Egreso_H` ='" + this.xestado_atencion_h + "' AND CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ', `g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2`) like'%" + this.JTFNombre_H.getText() + "%'  AND (`ingreso`.`Id_TipoAtencion` =2 OR `ingreso`.`Id_TipoAtencion` >4) AND `ingreso`.`Estado`=0    )  GROUP BY `ingreso`.`Id` ORDER BY `ingreso`.`FechaIngreso` ASC ";
                            }
                            if (Principal.informacionIps.getNombreIps().equals("INSTITUTO COLOMBIANO DE NEUROCIENCIAS APLICADAS S.A.S.")) {
                                this.xsql = "SELECT `ingreso`.`Id` , DATE_FORMAT(`ingreso`.`FechaIngreso`,'%d-%m-%Y') AS FIngreso , `ingreso`.`HoraIngreso` ,  `g_usuario`.`NoHistoria`, CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ', `g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2`) AS `NUsuario` , `g_persona`.`Id_Sexo` ,  CONCAT(`g_persona`.`Edad` , ' ', `g_tipoedad`.`Nbre`, '(s)') AS `Edad` , `f_empresacontxconvenio`.`Nbre` AS `NEmpresa`, IF(f_camas.`Nbre`IS NULL, '', f_camas.`Nbre`) AS Cama , `ingreso`.`Egreso_H` ,  IF(`ingreso`.`FEgreso_H` IS NULL, '', DATE_FORMAT(`ingreso`.`FEgreso_H`,'%d-%m-%Y')) AS FEgreso_H, `g_persona`.`Id`, 5,0, `ingreso`.`Id_TipoAtencion`   ,IF(`ingreso`.`CEspecial` IS NULL, '0',`ingreso`.`CEspecial`) AS CEspecial, `c_clasecita`.`Id_Programa`, `h_atencion`.`TipoGuardado`  ,ingreso.idModalidad , ingreso.idEntornoAtencion , ingreso.idTipoDiscapacidad  \nFROM `ingreso` INNER JOIN `g_usuario`    ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)  INNER JOIN `h_atencion`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)  INNER JOIN `c_clasecita`  ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)  INNER JOIN `h_tipohistoria`  ON (`h_tipohistoria`.`Id` = `c_clasecita`.`Id_Historia`)  INNER JOIN `f_empresacontxconvenio`   ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)  INNER JOIN `g_persona`  ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`) INNER JOIN `g_tipoedad`  ON (`g_persona`.`Id_TipoEdad` = `g_tipoedad`.`Id`) LEFT JOIN `f_camas` ON (`f_camas`.`Id` = ingreso.`Cama`)  WHERE (DATE_FORMAT(`ingreso`.`FechaIngreso`,'%Y')='" + this.xmt.formatoANO.format(this.JDCFechaAgenda2.getDate()) + "' AND `ingreso`.`Egreso_H` ='" + this.xestado_atencion_h + "' AND CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ', `g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2`) like'%" + this.JTFNombre_H.getText() + "%'  AND (`ingreso`.`Id_TipoAtencion` =2 OR `ingreso`.`Id_TipoAtencion` >4) AND `ingreso`.`Estado`=0    )  GROUP BY `ingreso`.`Id` ORDER BY `ingreso`.`FechaIngreso` ASC ";
                            }
                            if (Principal.informacionIps.getNombreIps().equals("IPS ESPERANZAS DE VIDA SAS")) {
                                this.xsql = "SELECT `ingreso`.`Id` , DATE_FORMAT(`ingreso`.`FechaIngreso`,'%d-%m-%Y') AS FIngreso , `ingreso`.`HoraIngreso` ,  `g_usuario`.`NoHistoria`, CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ', `g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2`) AS `NUsuario` , `g_persona`.`Id_Sexo` ,  CONCAT(`g_persona`.`Edad` , ' ', `g_tipoedad`.`Nbre`, '(s)') AS `Edad` , `f_empresacontxconvenio`.`Nbre` AS `NEmpresa`, IF(f_camas.`Nbre`IS NULL, '', f_camas.`Nbre`) AS Cama , `ingreso`.`Egreso_H` ,  IF(`ingreso`.`FEgreso_H` IS NULL, '', DATE_FORMAT(`ingreso`.`FEgreso_H`,'%d-%m-%Y')) AS FEgreso_H, `g_persona`.`Id`, 5,0, `ingreso`.`Id_TipoAtencion`   ,IF(`ingreso`.`CEspecial` IS NULL, '0',`ingreso`.`CEspecial`) AS CEspecial, `c_clasecita`.`Id_Programa`, `h_atencion`.`TipoGuardado`  ,ingreso.idModalidad , ingreso.idEntornoAtencion , ingreso.idTipoDiscapacidad  \nFROM `ingreso` INNER JOIN `g_usuario`    ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)  INNER JOIN `h_atencion`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)  INNER JOIN `c_clasecita`  ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)  INNER JOIN `h_tipohistoria`  ON (`h_tipohistoria`.`Id` = `c_clasecita`.`Id_Historia`)  INNER JOIN `f_empresacontxconvenio`   ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)  INNER JOIN `g_persona`  ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`) INNER JOIN `g_tipoedad`  ON (`g_persona`.`Id_TipoEdad` = `g_tipoedad`.`Id`) LEFT JOIN `f_camas` ON (`f_camas`.`Id` = ingreso.`Cama`)  WHERE (DATE_FORMAT(`ingreso`.`FechaIngreso`,'%Y')='" + this.xmt.formatoANO.format(this.JDCFechaAgenda2.getDate()) + "' AND `ingreso`.`Egreso_H` ='" + this.xestado_atencion_h + "' AND CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ', `g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2`) like'%" + this.JTFNombre_H.getText() + "%'  AND (`ingreso`.`Id_TipoAtencion` =2 OR `ingreso`.`Id_TipoAtencion` >4) AND `ingreso`.`Estado`=0    )  GROUP BY `ingreso`.`Id` ORDER BY `ingreso`.`FechaIngreso` ASC ";
                            } else {
                                this.xsql = "SELECT `ingreso`.`Id` , DATE_FORMAT(`ingreso`.`FechaIngreso`,'%d-%m-%Y') AS FIngreso , `ingreso`.`HoraIngreso` ,  `g_usuario`.`NoHistoria`, CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ', `g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2`) AS `NUsuario` , `g_persona`.`Id_Sexo` ,  CONCAT(`g_persona`.`Edad` , ' ', `g_tipoedad`.`Nbre`, '(s)') AS `Edad` , `f_empresacontxconvenio`.`Nbre` AS `NEmpresa`, IF(f_camas.`Nbre`IS NULL, '', f_camas.`Nbre`) AS Cama , `ingreso`.`Egreso_H` ,  IF(`ingreso`.`FEgreso_H` IS NULL, '', DATE_FORMAT(`ingreso`.`FEgreso_H`,'%d-%m-%Y')) AS FEgreso_H, `g_persona`.`Id`, 4,0, `ingreso`.`Id_TipoAtencion`   ,IF(`ingreso`.`CEspecial` IS NULL, '0',`ingreso`.`CEspecial`) AS CEspecial, `c_clasecita`.`Id_Programa`, `h_atencion`.`TipoGuardado`  ,ingreso.idModalidad , ingreso.idEntornoAtencion , ingreso.idTipoDiscapacidad  \nFROM `ingreso` INNER JOIN `g_usuario`    ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)  INNER JOIN `h_atencion`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)  INNER JOIN `c_clasecita`  ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)  INNER JOIN `h_tipohistoria`  ON (`h_tipohistoria`.`Id` = `c_clasecita`.`Id_Historia`)  INNER JOIN `f_empresacontxconvenio`   ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)  INNER JOIN `g_persona`  ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`) INNER JOIN `g_tipoedad`  ON (`g_persona`.`Id_TipoEdad` = `g_tipoedad`.`Id`) LEFT JOIN `f_camas` ON (`f_camas`.`Id` = ingreso.`Cama`)  WHERE (DATE_FORMAT(`ingreso`.`FechaIngreso`,'%Y')='" + this.xmt.formatoANO.format(this.JDCFechaAgenda2.getDate()) + "' AND `ingreso`.`Egreso_H` ='" + this.xestado_atencion_h + "' AND CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ', `g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2`) like'%" + this.JTFNombre_H.getText() + "%'  AND (`ingreso`.`Id_TipoAtencion` =2 OR `ingreso`.`Id_TipoAtencion` >4) AND `ingreso`.`Estado`=0    )  GROUP BY `ingreso`.`Id` ORDER BY `ingreso`.`FechaIngreso` ASC ";
                            }
                        } else if (Principal.informacionIps.getNombreIps().equals("CAMBIA TU VIDA IPS SAS")) {
                            this.xsql = "SELECT `ingreso`.`Id` , DATE_FORMAT(`ingreso`.`FechaIngreso`,'%d-%m-%Y') AS FIngreso , `ingreso`.`HoraIngreso` ,  `g_usuario`.`NoHistoria`, CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ', `g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2`) AS `NUsuario` , `g_persona`.`Id_Sexo` ,  CONCAT(`g_persona`.`Edad` , ' ', `g_tipoedad`.`Nbre`, '(s)') AS `Edad` , `f_empresacontxconvenio`.`Nbre` AS `NEmpresa`, IF(f_camas.`Nbre`IS NULL, '', f_camas.`Nbre`) AS Cama , `ingreso`.`Egreso_H` ,  IF(`ingreso`.`FEgreso_H` IS NULL, '', DATE_FORMAT(`ingreso`.`FEgreso_H`,'%d-%m-%Y')) AS FEgreso_H, `g_persona`.`Id`, 68,0, `ingreso`.`Id_TipoAtencion`   ,IF(`ingreso`.`CEspecial` IS NULL, '0',`ingreso`.`CEspecial`) AS CEspecial, `c_clasecita`.`Id_Programa`, `h_atencion`.`TipoGuardado`  ,ingreso.idModalidad , ingreso.idEntornoAtencion , ingreso.idTipoDiscapacidad  \nFROM `ingreso` INNER JOIN `g_usuario`    ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)  INNER JOIN `h_atencion`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)  INNER JOIN `c_clasecita`  ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)  INNER JOIN `h_tipohistoria`  ON (`h_tipohistoria`.`Id` = `c_clasecita`.`Id_Historia`)  INNER JOIN `f_empresacontxconvenio`   ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)  INNER JOIN `g_persona`  ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`) INNER JOIN `g_tipoedad`  ON (`g_persona`.`Id_TipoEdad` = `g_tipoedad`.`Id`) LEFT JOIN `f_camas` ON (`f_camas`.`Id` = ingreso.`Cama`)  WHERE ( `ingreso`.`Egreso_H` ='" + this.xestado_atencion_h + "' AND CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ', `g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2`) like'%" + this.JTFNombre_H.getText() + "%'  AND (`ingreso`.`Id_TipoAtencion` =2 OR `ingreso`.`Id_TipoAtencion` >4) AND `ingreso`.`Estado`=0    )  GROUP BY `ingreso`.`Id` ORDER BY `ingreso`.`FechaIngreso` ASC ";
                        } else if (Principal.informacionIps.getNombreIps().equals("INSTITUTO COLOMBIANO DE NEUROCIENCIAS APLICADAS S.A.S.") || Principal.informacionIps.getNombreIps().equals("IPS ESPERANZAS DE VIDA SAS") || Principal.informacionIps.getNombreIps().equals("IPS ESPERANZAS DE VIDA SAS")) {
                            this.xsql = "SELECT `ingreso`.`Id` , DATE_FORMAT(`ingreso`.`FechaIngreso`,'%d-%m-%Y') AS FIngreso , `ingreso`.`HoraIngreso` ,  `g_usuario`.`NoHistoria`, CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ', `g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2`) AS `NUsuario` , `g_persona`.`Id_Sexo` ,  CONCAT(`g_persona`.`Edad` , ' ', `g_tipoedad`.`Nbre`, '(s)') AS `Edad` , `f_empresacontxconvenio`.`Nbre` AS `NEmpresa`, IF(f_camas.`Nbre`IS NULL, '', f_camas.`Nbre`) AS Cama , `ingreso`.`Egreso_H` ,  IF(`ingreso`.`FEgreso_H` IS NULL, '', DATE_FORMAT(`ingreso`.`FEgreso_H`,'%d-%m-%Y')) AS FEgreso_H, `g_persona`.`Id`, 5,0, `ingreso`.`Id_TipoAtencion`   ,IF(`ingreso`.`CEspecial` IS NULL, '0',`ingreso`.`CEspecial`) AS CEspecial, `c_clasecita`.`Id_Programa`, `h_atencion`.`TipoGuardado`  ,ingreso.idModalidad , ingreso.idEntornoAtencion , ingreso.idTipoDiscapacidad  \nFROM `ingreso` INNER JOIN `g_usuario`    ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)  INNER JOIN `h_atencion`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)  INNER JOIN `c_clasecita`  ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)  INNER JOIN `h_tipohistoria`  ON (`h_tipohistoria`.`Id` = `c_clasecita`.`Id_Historia`)  INNER JOIN `f_empresacontxconvenio`   ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)  INNER JOIN `g_persona`  ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`) INNER JOIN `g_tipoedad`  ON (`g_persona`.`Id_TipoEdad` = `g_tipoedad`.`Id`) LEFT JOIN `f_camas` ON (`f_camas`.`Id` = ingreso.`Cama`)  WHERE ( `ingreso`.`Egreso_H` ='" + this.xestado_atencion_h + "' AND CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ', `g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2`) like'%" + this.JTFNombre_H.getText() + "%'  AND (`ingreso`.`Id_TipoAtencion` =2 OR `ingreso`.`Id_TipoAtencion` >4) AND `ingreso`.`Estado`=0    )  GROUP BY `ingreso`.`Id` ORDER BY `ingreso`.`FechaIngreso` ASC ";
                        } else {
                            this.xsql = "SELECT `ingreso`.`Id` , DATE_FORMAT(`ingreso`.`FechaIngreso`,'%d-%m-%Y') AS FIngreso , `ingreso`.`HoraIngreso` ,  `g_usuario`.`NoHistoria`, CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ', `g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2`) AS `NUsuario` , `g_persona`.`Id_Sexo` ,  CONCAT(`g_persona`.`Edad` , ' ', `g_tipoedad`.`Nbre`, '(s)') AS `Edad` , `f_empresacontxconvenio`.`Nbre` AS `NEmpresa`, IF(f_camas.`Nbre`IS NULL, '', f_camas.`Nbre`) AS Cama , `ingreso`.`Egreso_H` ,  IF(`ingreso`.`FEgreso_H` IS NULL, '', DATE_FORMAT(`ingreso`.`FEgreso_H`,'%d-%m-%Y')) AS FEgreso_H, `g_persona`.`Id`,  4,0, `ingreso`.`Id_TipoAtencion`   ,IF(`ingreso`.`CEspecial` IS NULL, '0',`ingreso`.`CEspecial`) AS CEspecial, `c_clasecita`.`Id_Programa`, `h_atencion`.`TipoGuardado`  ,ingreso.idModalidad , ingreso.idEntornoAtencion , ingreso.idTipoDiscapacidad  \nFROM `ingreso` INNER JOIN `g_usuario`    ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)  INNER JOIN `h_atencion`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)  INNER JOIN `c_clasecita`  ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)  INNER JOIN `h_tipohistoria`  ON (`h_tipohistoria`.`Id` = `c_clasecita`.`Id_Historia`)  INNER JOIN `f_empresacontxconvenio`   ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)  INNER JOIN `g_persona`  ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`) INNER JOIN `g_tipoedad`  ON (`g_persona`.`Id_TipoEdad` = `g_tipoedad`.`Id`) LEFT JOIN `f_camas` ON (`f_camas`.`Id` = ingreso.`Cama`)  WHERE ( `ingreso`.`Egreso_H` ='" + this.xestado_atencion_h + "' AND CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ', `g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2`) like'%" + this.JTFNombre_H.getText() + "%'  AND (`ingreso`.`Id_TipoAtencion` =2 OR `ingreso`.`Id_TipoAtencion` >4) AND `ingreso`.`Estado`=0    )  GROUP BY `ingreso`.`Id` ORDER BY `ingreso`.`FechaIngreso` ASC ";
                        }
                    } else if (this.JRBDeAlta_H.isSelected()) {
                        this.xsql = "SELECT `ingreso`.`Id` , DATE_FORMAT(`ingreso`.`FechaIngreso`,'%d-%m-%Y') AS FIngreso , `ingreso`.`HoraIngreso` ,   `g_usuario`.`NoHistoria`, CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ', `g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2`) AS `NUsuario` , `g_persona`.`Id_Sexo` ,  CONCAT(`g_persona`.`Edad` , ' ', `g_tipoedad`.`Nbre`, '(s)') AS `Edad` , `f_empresacontxconvenio`.`Nbre` AS `NEmpresa`, IF(f_camas.`Nbre`IS NULL, '', f_camas.`Nbre`) AS Cama , `ingreso`.`Egreso_H` ,  IF(`ingreso`.`FEgreso_H` IS NULL, '', DATE_FORMAT(`ingreso`.`FEgreso_H`,'%d-%m-%Y')) AS FEgreso_H, `g_persona`.`Id`,  4,0, `ingreso`.`Id_TipoAtencion`   ,IF(`ingreso`.`CEspecial` IS NULL, '0',`ingreso`.`CEspecial`) AS CEspecial, `c_clasecita`.`Id_Programa`, `h_atencion`.`TipoGuardado`  ,ingreso.idModalidad , ingreso.idEntornoAtencion , ingreso.idTipoDiscapacidad  \nFROM `ingreso` INNER JOIN `g_usuario`    ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)  INNER JOIN `h_atencion`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)  INNER JOIN `c_clasecita`  ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)  INNER JOIN `h_tipohistoria`  ON (`h_tipohistoria`.`Id` = `c_clasecita`.`Id_Historia`)  INNER JOIN `f_empresacontxconvenio`   ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`) INNER JOIN `g_persona`  ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`) INNER JOIN `g_tipoedad`  ON (`g_persona`.`Id_TipoEdad` = `g_tipoedad`.`Id`) LEFT JOIN `f_camas` ON (`f_camas`.`Id` = ingreso.`Cama`)  WHERE (DATE_FORMAT(`ingreso`.`FechaIngreso`,'%Y')='" + this.xmt.formatoANO.format(this.JDCFechaAgenda2.getDate()) + "' AND `ingreso`.`Egreso_H` ='" + this.xestado_atencion_h + "'  AND (`ingreso`.`Id_TipoAtencion` =2 OR `ingreso`.`Id_TipoAtencion` >4)  AND `ingreso`.`Estado`=0  )  GROUP BY `ingreso`.`Id` ORDER BY `ingreso`.`FechaIngreso` ASC ";
                    } else {
                        if (Principal.informacionIps.getNombreIps().equals("CAMBIA TU VIDA IPS SAS")) {
                            this.xsql = "SELECT `ingreso`.`Id` , DATE_FORMAT(`ingreso`.`FechaIngreso`,'%d-%m-%Y') AS FIngreso , `ingreso`.`HoraIngreso` ,   `g_usuario`.`NoHistoria`, CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ', `g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2`) AS `NUsuario` , `g_persona`.`Id_Sexo` ,  CONCAT(`g_persona`.`Edad` , ' ', `g_tipoedad`.`Nbre`, '(s)') AS `Edad` , `f_empresacontxconvenio`.`Nbre` AS `NEmpresa`, IF(f_camas.`Nbre`IS NULL, '', f_camas.`Nbre`) AS Cama , `ingreso`.`Egreso_H` ,  IF(`ingreso`.`FEgreso_H` IS NULL, '', DATE_FORMAT(`ingreso`.`FEgreso_H`,'%d-%m-%Y')) AS FEgreso_H, `g_persona`.`Id`,  68,0, `ingreso`.`Id_TipoAtencion`   ,IF(`ingreso`.`CEspecial` IS NULL, '0',`ingreso`.`CEspecial`) AS CEspecial, `c_clasecita`.`Id_Programa`, `h_atencion`.`TipoGuardado`  ,ingreso.idModalidad , ingreso.idEntornoAtencion , ingreso.idTipoDiscapacidad  \nFROM `ingreso` INNER JOIN `g_usuario`    ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)  INNER JOIN `h_atencion`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)  INNER JOIN `c_clasecita`  ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)  INNER JOIN `h_tipohistoria`  ON (`h_tipohistoria`.`Id` = `c_clasecita`.`Id_Historia`)  INNER JOIN `f_empresacontxconvenio`   ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`) INNER JOIN `g_persona`  ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`) INNER JOIN `g_tipoedad`  ON (`g_persona`.`Id_TipoEdad` = `g_tipoedad`.`Id`) LEFT JOIN `f_camas` ON (`f_camas`.`Id` = ingreso.`Cama`)  WHERE ( `ingreso`.`Egreso_H` ='" + this.xestado_atencion_h + "'  AND (`ingreso`.`Id_TipoAtencion` =2 OR `ingreso`.`Id_TipoAtencion` >4)  AND `ingreso`.`Estado`=0  )  GROUP BY `ingreso`.`Id` ORDER BY `ingreso`.`FechaIngreso` ASC ";
                        }
                        if (Principal.informacionIps.getNombreIps().equals("INSTITUTO COLOMBIANO DE NEUROCIENCIAS APLICADAS S.A.S.")) {
                            this.xsql = "SELECT `ingreso`.`Id` , DATE_FORMAT(`ingreso`.`FechaIngreso`,'%d-%m-%Y') AS FIngreso , `ingreso`.`HoraIngreso` ,   `g_usuario`.`NoHistoria`, CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ', `g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2`) AS `NUsuario` , `g_persona`.`Id_Sexo` ,  CONCAT(`g_persona`.`Edad` , ' ', `g_tipoedad`.`Nbre`, '(s)') AS `Edad` , `f_empresacontxconvenio`.`Nbre` AS `NEmpresa`, IF(f_camas.`Nbre`IS NULL, '', f_camas.`Nbre`) AS Cama , `ingreso`.`Egreso_H` ,  IF(`ingreso`.`FEgreso_H` IS NULL, '', DATE_FORMAT(`ingreso`.`FEgreso_H`,'%d-%m-%Y')) AS FEgreso_H, `g_persona`.`Id`,  5,0, `ingreso`.`Id_TipoAtencion`   ,IF(`ingreso`.`CEspecial` IS NULL, '0',`ingreso`.`CEspecial`) AS CEspecial, `c_clasecita`.`Id_Programa`, `h_atencion`.`TipoGuardado`  ,ingreso.idModalidad , ingreso.idEntornoAtencion , ingreso.idTipoDiscapacidad  \nFROM `ingreso` INNER JOIN `g_usuario`    ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)  INNER JOIN `h_atencion`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)  INNER JOIN `c_clasecita`  ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)  INNER JOIN `h_tipohistoria`  ON (`h_tipohistoria`.`Id` = `c_clasecita`.`Id_Historia`)  INNER JOIN `f_empresacontxconvenio`   ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`) INNER JOIN `g_persona`  ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`) INNER JOIN `g_tipoedad`  ON (`g_persona`.`Id_TipoEdad` = `g_tipoedad`.`Id`) LEFT JOIN `f_camas` ON (`f_camas`.`Id` = ingreso.`Cama`)  WHERE ( `ingreso`.`Egreso_H` ='" + this.xestado_atencion_h + "'  AND (`ingreso`.`Id_TipoAtencion` =2 OR `ingreso`.`Id_TipoAtencion` >4)  AND `ingreso`.`Estado`=0  )  GROUP BY `ingreso`.`Id` ORDER BY `ingreso`.`FechaIngreso` ASC ";
                        }
                        if (Principal.informacionIps.getNombreIps().equals("IPS ESPERANZAS DE VIDA SAS")) {
                            this.xsql = "SELECT `ingreso`.`Id` , DATE_FORMAT(`ingreso`.`FechaIngreso`,'%d-%m-%Y') AS FIngreso , `ingreso`.`HoraIngreso` ,   `g_usuario`.`NoHistoria`, CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ', `g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2`) AS `NUsuario` , `g_persona`.`Id_Sexo` ,  CONCAT(`g_persona`.`Edad` , ' ', `g_tipoedad`.`Nbre`, '(s)') AS `Edad` , `f_empresacontxconvenio`.`Nbre` AS `NEmpresa`, IF(f_camas.`Nbre`IS NULL, '', f_camas.`Nbre`) AS Cama , `ingreso`.`Egreso_H` ,  IF(`ingreso`.`FEgreso_H` IS NULL, '', DATE_FORMAT(`ingreso`.`FEgreso_H`,'%d-%m-%Y')) AS FEgreso_H, `g_persona`.`Id`,  5,0, `ingreso`.`Id_TipoAtencion`   ,IF(`ingreso`.`CEspecial` IS NULL, '0',`ingreso`.`CEspecial`) AS CEspecial, `c_clasecita`.`Id_Programa`, `h_atencion`.`TipoGuardado`  ,ingreso.idModalidad , ingreso.idEntornoAtencion , ingreso.idTipoDiscapacidad  \nFROM `ingreso` INNER JOIN `g_usuario`    ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)  INNER JOIN `h_atencion`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)  INNER JOIN `c_clasecita`  ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)  INNER JOIN `h_tipohistoria`  ON (`h_tipohistoria`.`Id` = `c_clasecita`.`Id_Historia`)  INNER JOIN `f_empresacontxconvenio`   ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`) INNER JOIN `g_persona`  ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`) INNER JOIN `g_tipoedad`  ON (`g_persona`.`Id_TipoEdad` = `g_tipoedad`.`Id`) LEFT JOIN `f_camas` ON (`f_camas`.`Id` = ingreso.`Cama`)  WHERE ( `ingreso`.`Egreso_H` ='" + this.xestado_atencion_h + "'  AND (`ingreso`.`Id_TipoAtencion` =2 OR `ingreso`.`Id_TipoAtencion` >4)  AND `ingreso`.`Estado`=0  )  GROUP BY `ingreso`.`Id` ORDER BY `ingreso`.`FechaIngreso` ASC ";
                        } else {
                            this.xsql = "SELECT `ingreso`.`Id` , DATE_FORMAT(`ingreso`.`FechaIngreso`,'%d-%m-%Y') AS FIngreso , `ingreso`.`HoraIngreso` ,   `g_usuario`.`NoHistoria`, CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ', `g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2`) AS `NUsuario` , `g_persona`.`Id_Sexo` ,  CONCAT(`g_persona`.`Edad` , ' ', `g_tipoedad`.`Nbre`, '(s)') AS `Edad` , `f_empresacontxconvenio`.`Nbre` AS `NEmpresa`, IF(f_camas.`Nbre`IS NULL, '', f_camas.`Nbre`) AS Cama , `ingreso`.`Egreso_H` ,  IF(`ingreso`.`FEgreso_H` IS NULL, '', DATE_FORMAT(`ingreso`.`FEgreso_H`,'%d-%m-%Y')) AS FEgreso_H, `g_persona`.`Id`,  4,0, `ingreso`.`Id_TipoAtencion`   ,IF(`ingreso`.`CEspecial` IS NULL, '0',`ingreso`.`CEspecial`) AS CEspecial, `c_clasecita`.`Id_Programa`, `h_atencion`.`TipoGuardado`  ,ingreso.idModalidad , ingreso.idEntornoAtencion , ingreso.idTipoDiscapacidad  \nFROM `ingreso` INNER JOIN `g_usuario`    ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)  INNER JOIN `h_atencion`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)  INNER JOIN `c_clasecita`  ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)  INNER JOIN `h_tipohistoria`  ON (`h_tipohistoria`.`Id` = `c_clasecita`.`Id_Historia`)  INNER JOIN `f_empresacontxconvenio`   ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`) INNER JOIN `g_persona`  ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`) INNER JOIN `g_tipoedad`  ON (`g_persona`.`Id_TipoEdad` = `g_tipoedad`.`Id`) LEFT JOIN `f_camas` ON (`f_camas`.`Id` = ingreso.`Cama`)  WHERE ( `ingreso`.`Egreso_H` ='" + this.xestado_atencion_h + "'  AND (`ingreso`.`Id_TipoAtencion` =2 OR `ingreso`.`Id_TipoAtencion` >4)  AND `ingreso`.`Estado`=0  )  GROUP BY `ingreso`.`Id` ORDER BY `ingreso`.`FechaIngreso` ASC ";
                        }
                    }
                } else if (this.xid_especialidad.equals("382") || Principal.informacionIps.getNombreIps().equals("SALUD A SU HOGAR IPS S.A.S.")) {
                    if (this.JCHFiltro_H.isSelected()) {
                        if (this.JRBDeAlta_H.isSelected()) {
                            this.xsql = "SELECT `ingreso`.`Id` , DATE_FORMAT(`ingreso`.`FechaIngreso`,'%d-%m-%Y') AS FIngreso , `ingreso`.`HoraIngreso` ,  `g_usuario`.`NoHistoria`, CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ', `g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2`) AS `NUsuario` , `g_persona`.`Id_Sexo` ,  CONCAT(`g_persona`.`Edad` , ' ', `g_tipoedad`.`Nbre`, '(s)') AS `Edad` , `f_empresacontxconvenio`.`Nbre` AS `NEmpresa`, IF(f_camas.`Nbre`IS NULL, '', f_camas.`Nbre`) AS Cama , `ingreso`.`Egreso` ,  IF(`ingreso`.`FEgreso_H` IS NULL, '', DATE_FORMAT(`ingreso`.`FEgreso_H`,'%d-%m-%Y')) AS FEgreso_H, `g_persona`.`Id`,  `c_clasecita`.`Id_Historia`,0, `ingreso`.`Id_TipoAtencion`   ,IF(`ingreso`.`CEspecial` IS NULL, '0',`ingreso`.`CEspecial`) AS CEspecial, `c_clasecita`.`Id_Programa`, `h_atencion`.`TipoGuardado`  ,ingreso.idModalidad , ingreso.idEntornoAtencion , ingreso.idTipoDiscapacidad  \nFROM `ingreso` INNER JOIN `g_usuario`    ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)  INNER JOIN `h_atencion`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)  INNER JOIN `c_clasecita`  ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)  INNER JOIN `h_tipohistoria`  ON (`h_tipohistoria`.`Id` = `c_clasecita`.`Id_Historia`)  INNER JOIN `f_empresacontxconvenio`   ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)  INNER JOIN `g_persona`  ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`) INNER JOIN `g_tipoedad`  ON (`g_persona`.`Id_TipoEdad` = `g_tipoedad`.`Id`) LEFT JOIN `f_camas` ON (`f_camas`.`Id` = ingreso.`Cama`)  WHERE (DATE_FORMAT(`ingreso`.`FechaIngreso`,'%Y-%m')='" + this.xmt.formatoANO_MES.format(this.JDCFechaAgenda2.getDate()) + "' AND `ingreso`.`Egreso_H` ='" + this.xestado_atencion_h + "' AND CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ', `g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2`) like'%" + this.JTFNombre_H.getText() + "%'  AND (`ingreso`.`Id_TipoAtencion` =2 OR `ingreso`.`Id_TipoAtencion` >4) AND `ingreso`.`Estado`=0    )  GROUP BY `ingreso`.`Id` ORDER BY CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ', `g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2`) ASC, `ingreso`.`FechaIngreso` DESC ";
                        } else {
                            this.xsql = "SELECT `ingreso`.`Id` , DATE_FORMAT(`ingreso`.`FechaIngreso`,'%d-%m-%Y') AS FIngreso , `ingreso`.`HoraIngreso` ,  `g_usuario`.`NoHistoria`, CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ', `g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2`) AS `NUsuario` , `g_persona`.`Id_Sexo` ,  CONCAT(`g_persona`.`Edad` , ' ', `g_tipoedad`.`Nbre`, '(s)') AS `Edad` , `f_empresacontxconvenio`.`Nbre` AS `NEmpresa`, IF(f_camas.`Nbre`IS NULL, '', f_camas.`Nbre`) AS Cama , `ingreso`.`Egreso` ,  IF(`ingreso`.`FEgreso_H` IS NULL, '', DATE_FORMAT(`ingreso`.`FEgreso_H`,'%d-%m-%Y')) AS FEgreso_H, `g_persona`.`Id`,  `c_clasecita`.`Id_Historia`,0, `ingreso`.`Id_TipoAtencion`   ,IF(`ingreso`.`CEspecial` IS NULL, '0',`ingreso`.`CEspecial`) AS CEspecial, `c_clasecita`.`Id_Programa`, `h_atencion`.`TipoGuardado`  ,ingreso.idModalidad , ingreso.idEntornoAtencion , ingreso.idTipoDiscapacidad  \nFROM `ingreso` INNER JOIN `g_usuario`    ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)  INNER JOIN `h_atencion`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)  INNER JOIN `c_clasecita`  ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)  INNER JOIN `h_tipohistoria`  ON (`h_tipohistoria`.`Id` = `c_clasecita`.`Id_Historia`)  INNER JOIN `f_empresacontxconvenio`   ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)  INNER JOIN `g_persona`  ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`) INNER JOIN `g_tipoedad`  ON (`g_persona`.`Id_TipoEdad` = `g_tipoedad`.`Id`) LEFT JOIN `f_camas` ON (`f_camas`.`Id` = ingreso.`Cama`)  WHERE ( `ingreso`.`Egreso_H` ='" + this.xestado_atencion_h + "' AND CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ', `g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2`) like'%" + this.JTFNombre_H.getText() + "%'  AND (`ingreso`.`Id_TipoAtencion` =2 OR `ingreso`.`Id_TipoAtencion` >4) AND `ingreso`.`Estado`=0    )  GROUP BY `ingreso`.`Id` ORDER BY CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ', `g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2`) ASC ";
                        }
                    } else if (this.JRBDeAlta_H.isSelected()) {
                        this.xsql = "SELECT `ingreso`.`Id` , DATE_FORMAT(`ingreso`.`FechaIngreso`,'%d-%m-%Y') AS FIngreso , `ingreso`.`HoraIngreso` ,   `g_usuario`.`NoHistoria`, CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ', `g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2`) AS `NUsuario` , `g_persona`.`Id_Sexo` ,  CONCAT(`g_persona`.`Edad` , ' ', `g_tipoedad`.`Nbre`, '(s)') AS `Edad` , `f_empresacontxconvenio`.`Nbre` AS `NEmpresa`, IF(f_camas.`Nbre`IS NULL, '', f_camas.`Nbre`) AS Cama , `ingreso`.`Egreso` ,  IF(`ingreso`.`FEgreso_H` IS NULL, '', DATE_FORMAT(`ingreso`.`FEgreso_H`,'%d-%m-%Y')) AS FEgreso_H, `g_persona`.`Id`,  `c_clasecita`.`Id_Historia`,0, `ingreso`.`Id_TipoAtencion`   ,IF(`ingreso`.`CEspecial` IS NULL, '0',`ingreso`.`CEspecial`) AS CEspecial, `c_clasecita`.`Id_Programa`, `h_atencion`.`TipoGuardado`  ,ingreso.idModalidad , ingreso.idEntornoAtencion , ingreso.idTipoDiscapacidad  \nFROM `ingreso` INNER JOIN `g_usuario`    ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)  INNER JOIN `h_atencion`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)  INNER JOIN `c_clasecita`  ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)  INNER JOIN `h_tipohistoria`  ON (`h_tipohistoria`.`Id` = `c_clasecita`.`Id_Historia`)  INNER JOIN `f_empresacontxconvenio`   ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`) INNER JOIN `g_persona`  ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`) INNER JOIN `g_tipoedad`  ON (`g_persona`.`Id_TipoEdad` = `g_tipoedad`.`Id`) LEFT JOIN `f_camas` ON (`f_camas`.`Id` = ingreso.`Cama`)  WHERE (DATE_FORMAT(`ingreso`.`FechaIngreso`,'%Y-%m')='" + this.xmt.formatoANO_MES.format(this.JDCFechaAgenda2.getDate()) + "' AND `ingreso`.`Egreso_H` ='" + this.xestado_atencion_h + "'  AND (`ingreso`.`Id_TipoAtencion` =2 OR `ingreso`.`Id_TipoAtencion` >4)  AND `ingreso`.`Estado`=0  )  GROUP BY `ingreso`.`Id` ORDER BY CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ', `g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2`) ASC, `ingreso`.`FechaIngreso` DESC ";
                    } else {
                        this.xsql = "SELECT `ingreso`.`Id` , DATE_FORMAT(`ingreso`.`FechaIngreso`,'%d-%m-%Y') AS FIngreso , `ingreso`.`HoraIngreso` ,   `g_usuario`.`NoHistoria`, CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ', `g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2`) AS `NUsuario` , `g_persona`.`Id_Sexo` ,  CONCAT(`g_persona`.`Edad` , ' ', `g_tipoedad`.`Nbre`, '(s)') AS `Edad` , `f_empresacontxconvenio`.`Nbre` AS `NEmpresa`, IF(f_camas.`Nbre`IS NULL, '', f_camas.`Nbre`) AS Cama , `ingreso`.`Egreso` ,  IF(`ingreso`.`FEgreso_H` IS NULL, '', DATE_FORMAT(`ingreso`.`FEgreso_H`,'%d-%m-%Y')) AS FEgreso_H, `g_persona`.`Id`,  `c_clasecita`.`Id_Historia`,0, `ingreso`.`Id_TipoAtencion`   ,IF(`ingreso`.`CEspecial` IS NULL, '0',`ingreso`.`CEspecial`) AS CEspecial, `c_clasecita`.`Id_Programa`, `h_atencion`.`TipoGuardado`  ,ingreso.idModalidad , ingreso.idEntornoAtencion , ingreso.idTipoDiscapacidad  \nFROM `ingreso` INNER JOIN `g_usuario`    ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)  INNER JOIN `h_atencion`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)  INNER JOIN `c_clasecita`  ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)  INNER JOIN `h_tipohistoria`  ON (`h_tipohistoria`.`Id` = `c_clasecita`.`Id_Historia`)  INNER JOIN `f_empresacontxconvenio`   ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`) INNER JOIN `g_persona`  ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`) INNER JOIN `g_tipoedad`  ON (`g_persona`.`Id_TipoEdad` = `g_tipoedad`.`Id`) LEFT JOIN `f_camas` ON (`f_camas`.`Id` = ingreso.`Cama`)  WHERE ( `ingreso`.`Egreso_H` ='" + this.xestado_atencion_h + "'  AND (`ingreso`.`Id_TipoAtencion` =2 OR `ingreso`.`Id_TipoAtencion` >4)  AND `ingreso`.`Estado`=0  )  GROUP BY `ingreso`.`Id` ORDER BY CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ', `g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2`) ASC ";
                    }
                } else if (this.JCHFiltro_H.isSelected()) {
                    if (this.JRBDeAlta_H.isSelected()) {
                        if (Principal.informacionIps.getNombreIps().equals("CLINICA LAURELES PSIQUIATRAS ASOCIADOS I.P.S. S.A.S.") || Principal.informacionIps.getNombreIps().equals("CAMBIA TU VIDA IPS SAS") || Principal.informacionIps.getNombreIps().equals("INSTITUTO COLOMBIANO DE NEUROCIENCIAS APLICADAS S.A.S.") || Principal.informacionIps.getNombreIps().equals("UNION TEMPORAL CLINICA LAURELES")) {
                            this.xsql = "SELECT `ingreso`.`Id` , DATE_FORMAT(`ingreso`.`FechaIngreso`,'%d-%m-%Y') AS FIngreso , `ingreso`.`HoraIngreso` ,  `g_usuario`.`NoHistoria`, CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ', `g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2`) AS `NUsuario` , `g_persona`.`Id_Sexo` ,  CONCAT(`g_persona`.`Edad` , ' ', `g_tipoedad`.`Nbre`, '(s)') AS `Edad` , `f_empresacontxconvenio`.`Nbre` AS `NEmpresa`, IF(`f_camas`.`Nbre` IS NULL, '',`f_camas`.`Nbre`) AS `Cama` , `ingreso`.`Egreso` , IF(`ingreso`.`FEgreso_H` IS NULL, '', DATE_FORMAT(`ingreso`.`FEgreso_H`,'%d-%m-%Y')) AS FEgreso_H, `g_persona`.`Id`,  h_tiponota_especialidad.`Id_Historia`,0, `ingreso`.`Id_TipoAtencion`  ,IF(`ingreso`.`CEspecial` IS NULL, '0',`ingreso`.`CEspecial`) AS CEspecial, `c_clasecita`.`Id_Programa`, `h_atencion`.`TipoGuardado`  ,ingreso.idModalidad , ingreso.idEntornoAtencion , ingreso.idTipoDiscapacidad  \nFROM `ingreso` INNER JOIN `g_usuario`    ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`) INNER JOIN `h_atencion`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN `h_notasclinicas`  ON (`h_notasclinicas`.`Id_Atencion` = `h_atencion`.`Id`) INNER JOIN `h_ordenes_interconsultas`  ON (`h_ordenes_interconsultas`.`Id_Nota` = `h_notasclinicas`.`Id`) INNER JOIN `f_empresacontxconvenio`   ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`) INNER JOIN `h_tiponota`  ON (`h_notasclinicas`.`Id_TipoNota` = `h_tiponota`.`Id`) INNER JOIN `h_tiponota_especialidad`  ON (`h_tiponota_especialidad`.`Id_TipoNota` = `h_tiponota`.`Id`) INNER JOIN `g_persona`  ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`) INNER JOIN `g_tipoedad`  ON (`g_persona`.`Id_TipoEdad` = `g_tipoedad`.`Id`) INNER JOIN `c_clasecita`  ON (`c_clasecita`.`Id` = `h_atencion`.`Id_ClaseCita`) LEFT JOIN `f_camas` ON (`f_camas`.`Id` = ingreso.`Cama`) WHERE (DATE_FORMAT(`ingreso`.`FechaIngreso`,'%Y-%m')='" + this.xmt.formatoANO_MES.format(this.JDCFechaAgenda2.getDate()) + "' AND CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ', `g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2`) like'%" + this.JTFNombre_H.getText() + "%'   AND  `ingreso`.`Egreso_H` ='" + this.xestado_atencion_h + "'  AND (`ingreso`.`Id_TipoAtencion` =2 OR `ingreso`.`Id_TipoAtencion` >4)  AND `ingreso`.`Estado`=0  AND `h_ordenes_interconsultas`.`Id_Especialidad`='" + this.xid_especialidad + "' and  h_tiponota_especialidad.`Id_Historia` <>0 )  GROUP BY `ingreso`.`Id` ORDER BY `ingreso`.`FechaIngreso` ASC";
                        } else {
                            this.xsql = "SELECT `ingreso`.`Id` , DATE_FORMAT(`ingreso`.`FechaIngreso`,'%d-%m-%Y') AS FIngreso , `ingreso`.`HoraIngreso` ,  `g_usuario`.`NoHistoria`, CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ', `g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2`) AS `NUsuario` , `g_persona`.`Id_Sexo` ,  CONCAT(`g_persona`.`Edad` , ' ', `g_tipoedad`.`Nbre`, '(s)') AS `Edad` , `f_empresacontxconvenio`.`Nbre` AS `NEmpresa`, IF(`f_camas`.`Nbre` IS NULL, '',`f_camas`.`Nbre`) AS `Cama` , `ingreso`.`Egreso` , IF(`ingreso`.`FEgreso_H` IS NULL, '', DATE_FORMAT(`ingreso`.`FEgreso_H`,'%d-%m-%Y')) AS FEgreso_H, `g_persona`.`Id`,  h_tiponota_especialidad.`Id_Historia`,0, `ingreso`.`Id_TipoAtencion`  ,IF(`ingreso`.`CEspecial` IS NULL, '0',`ingreso`.`CEspecial`) AS CEspecial, `c_clasecita`.`Id_Programa`, `h_atencion`.`TipoGuardado`  ,ingreso.idModalidad , ingreso.idEntornoAtencion , ingreso.idTipoDiscapacidad  \nFROM `ingreso` INNER JOIN `g_usuario`    ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`) INNER JOIN `h_atencion`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN `h_notasclinicas`  ON (`h_notasclinicas`.`Id_Atencion` = `h_atencion`.`Id`) INNER JOIN `h_ordenes_interconsultas`  ON (`h_ordenes_interconsultas`.`Id_Nota` = `h_notasclinicas`.`Id`) INNER JOIN `f_empresacontxconvenio`   ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`) INNER JOIN `h_tiponota`  ON (`h_notasclinicas`.`Id_TipoNota` = `h_tiponota`.`Id`) INNER JOIN `h_tiponota_especialidad`  ON (`h_tiponota_especialidad`.`Id_TipoNota` = `h_tiponota`.`Id`) INNER JOIN `g_persona`  ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`) INNER JOIN `g_tipoedad`  ON (`g_persona`.`Id_TipoEdad` = `g_tipoedad`.`Id`) INNER JOIN `c_clasecita`  ON (`c_clasecita`.`Id` = `h_atencion`.`Id_ClaseCita`) LEFT JOIN `f_camas` ON (`f_camas`.`Id` = ingreso.`Cama`) WHERE (DATE_FORMAT(`ingreso`.`FechaIngreso`,'%Y-%m')='" + this.xmt.formatoANO_MES.format(this.JDCFechaAgenda2.getDate()) + "' AND CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ', `g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2`) like'%" + this.JTFNombre_H.getText() + "%'   AND  `ingreso`.`Egreso_H` ='" + this.xestado_atencion_h + "'  AND (`ingreso`.`Id_TipoAtencion` =2 OR `ingreso`.`Id_TipoAtencion` >4)  AND `ingreso`.`Estado`=0  AND `h_ordenes_interconsultas`.`Id_Especialidad`='" + this.xid_especialidad + "' and  h_tiponota_especialidad.`Id_Historia` <>0 )  GROUP BY `ingreso`.`Id` ORDER BY CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ', `g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2`) ASC ";
                        }
                    } else if (Principal.informacionIps.getNombreIps().equals("CLINICA LAURELES PSIQUIATRAS ASOCIADOS I.P.S. S.A.S.") || Principal.informacionIps.getNombreIps().equals("CAMBIA TU VIDA IPS SAS") || Principal.informacionIps.getNombreIps().equals("INSTITUTO COLOMBIANO DE NEUROCIENCIAS APLICADAS S.A.S.") || Principal.informacionIps.getNombreIps().equals("UNION TEMPORAL CLINICA LAURELES")) {
                        this.xsql = "SELECT `ingreso`.`Id` , DATE_FORMAT(`ingreso`.`FechaIngreso`,'%d-%m-%Y') AS FIngreso , `ingreso`.`HoraIngreso` ,  `g_usuario`.`NoHistoria`, CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ', `g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2`) AS `NUsuario` , `g_persona`.`Id_Sexo` ,  CONCAT(`g_persona`.`Edad` , ' ', `g_tipoedad`.`Nbre`, '(s)') AS `Edad` , `f_empresacontxconvenio`.`Nbre` AS `NEmpresa`, IF(`f_camas`.`Nbre` IS NULL, '',`f_camas`.`Nbre`) AS `Cama` , `ingreso`.`Egreso` , IF(`ingreso`.`FEgreso_H` IS NULL, '', DATE_FORMAT(`ingreso`.`FEgreso_H`,'%d-%m-%Y')) AS FEgreso_H, `g_persona`.`Id`,  h_tiponota_especialidad.`Id_Historia`,0, `ingreso`.`Id_TipoAtencion`  ,IF(`ingreso`.`CEspecial` IS NULL, '0',`ingreso`.`CEspecial`) AS CEspecial, `c_clasecita`.`Id_Programa`, `h_atencion`.`TipoGuardado`  ,ingreso.idModalidad , ingreso.idEntornoAtencion , ingreso.idTipoDiscapacidad  \nFROM `ingreso` INNER JOIN `g_usuario`    ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`) INNER JOIN `h_atencion`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN `h_notasclinicas`  ON (`h_notasclinicas`.`Id_Atencion` = `h_atencion`.`Id`) INNER JOIN `h_ordenes_interconsultas`  ON (`h_ordenes_interconsultas`.`Id_Nota` = `h_notasclinicas`.`Id`) INNER JOIN `f_empresacontxconvenio`   ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`) INNER JOIN `h_tiponota`  ON (`h_notasclinicas`.`Id_TipoNota` = `h_tiponota`.`Id`) INNER JOIN `h_tiponota_especialidad`  ON (`h_tiponota_especialidad`.`Id_TipoNota` = `h_tiponota`.`Id`) INNER JOIN `g_persona`  ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`) INNER JOIN `g_tipoedad`  ON (`g_persona`.`Id_TipoEdad` = `g_tipoedad`.`Id`) INNER JOIN `c_clasecita`  ON (`c_clasecita`.`Id` = `h_atencion`.`Id_ClaseCita`) LEFT JOIN `f_camas` ON (`f_camas`.`Id` = ingreso.`Cama`) WHERE ( `ingreso`.`Egreso_H` ='" + this.xestado_atencion_h + "'  AND (`ingreso`.`Id_TipoAtencion` =2 OR `ingreso`.`Id_TipoAtencion` >4)  AND CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ', `g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2`) like'%" + this.JTFNombre_H.getText() + "%'   AND `ingreso`.`Estado`=0  AND `h_ordenes_interconsultas`.`Id_Especialidad`='" + this.xid_especialidad + "' and  h_tiponota_especialidad.`Id_Historia` <>0 )  GROUP BY `ingreso`.`Id` ORDER BY `ingreso`.`FechaIngreso` ASC ";
                    } else {
                        this.xsql = "SELECT `ingreso`.`Id` , DATE_FORMAT(`ingreso`.`FechaIngreso`,'%d-%m-%Y') AS FIngreso , `ingreso`.`HoraIngreso` ,  `g_usuario`.`NoHistoria`, CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ', `g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2`) AS `NUsuario` , `g_persona`.`Id_Sexo` ,  CONCAT(`g_persona`.`Edad` , ' ', `g_tipoedad`.`Nbre`, '(s)') AS `Edad` , `f_empresacontxconvenio`.`Nbre` AS `NEmpresa`, IF(`f_camas`.`Nbre` IS NULL, '',`f_camas`.`Nbre`) AS `Cama` , `ingreso`.`Egreso` , IF(`ingreso`.`FEgreso_H` IS NULL, '', DATE_FORMAT(`ingreso`.`FEgreso_H`,'%d-%m-%Y')) AS FEgreso_H, `g_persona`.`Id`,  h_tiponota_especialidad.`Id_Historia`,0, `ingreso`.`Id_TipoAtencion`  ,IF(`ingreso`.`CEspecial` IS NULL, '0',`ingreso`.`CEspecial`) AS CEspecial, `c_clasecita`.`Id_Programa`, `h_atencion`.`TipoGuardado`  ,ingreso.idModalidad , ingreso.idEntornoAtencion , ingreso.idTipoDiscapacidad  \nFROM `ingreso` INNER JOIN `g_usuario`    ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`) INNER JOIN `h_atencion`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN `h_notasclinicas`  ON (`h_notasclinicas`.`Id_Atencion` = `h_atencion`.`Id`) INNER JOIN `h_ordenes_interconsultas`  ON (`h_ordenes_interconsultas`.`Id_Nota` = `h_notasclinicas`.`Id`) INNER JOIN `f_empresacontxconvenio`   ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`) INNER JOIN `h_tiponota`  ON (`h_notasclinicas`.`Id_TipoNota` = `h_tiponota`.`Id`) INNER JOIN `h_tiponota_especialidad`  ON (`h_tiponota_especialidad`.`Id_TipoNota` = `h_tiponota`.`Id`) INNER JOIN `g_persona`  ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`) INNER JOIN `g_tipoedad`  ON (`g_persona`.`Id_TipoEdad` = `g_tipoedad`.`Id`) INNER JOIN `c_clasecita`  ON (`c_clasecita`.`Id` = `h_atencion`.`Id_ClaseCita`) LEFT JOIN `f_camas` ON (`f_camas`.`Id` = ingreso.`Cama`) WHERE ( `ingreso`.`Egreso_H` ='" + this.xestado_atencion_h + "'  AND (`ingreso`.`Id_TipoAtencion` =2 OR `ingreso`.`Id_TipoAtencion` >4)  AND CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ', `g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2`) like'%" + this.JTFNombre_H.getText() + "%'   AND `ingreso`.`Estado`=0  AND `h_ordenes_interconsultas`.`Id_Especialidad`='" + this.xid_especialidad + "' and  h_tiponota_especialidad.`Id_Historia` <>0 )  GROUP BY `ingreso`.`Id` ORDER BY CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ', `g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2`) ASC ";
                    }
                } else if (this.JRBDeAlta_H.isSelected()) {
                    if (Principal.informacionIps.getNombreIps().equals("CLINICA LAURELES PSIQUIATRAS ASOCIADOS I.P.S. S.A.S.") || Principal.informacionIps.getNombreIps().equals("CAMBIA TU VIDA IPS SAS") || Principal.informacionIps.getNombreIps().equals("INSTITUTO COLOMBIANO DE NEUROCIENCIAS APLICADAS S.A.S.") || Principal.informacionIps.getNombreIps().equals("UNION TEMPORAL CLINICA LAURELES")) {
                        this.xsql = "SELECT `ingreso`.`Id` , DATE_FORMAT(`ingreso`.`FechaIngreso`,'%d-%m-%Y') AS FIngreso , `ingreso`.`HoraIngreso` ,  `g_usuario`.`NoHistoria`, CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ', `g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2`) AS `NUsuario` , `g_persona`.`Id_Sexo` ,  CONCAT(`g_persona`.`Edad` , ' ', `g_tipoedad`.`Nbre`, '(s)') AS `Edad` , `f_empresacontxconvenio`.`Nbre` AS `NEmpresa`, IF(`f_camas`.`Nbre` IS NULL, '',`f_camas`.`Nbre`) AS `Cama` , `ingreso`.`Egreso` , IF(`ingreso`.`FEgreso_H` IS NULL, '', DATE_FORMAT(`ingreso`.`FEgreso_H`,'%d-%m-%Y')) AS FEgreso_H, `g_persona`.`Id`,  h_tiponota_especialidad.`Id_Historia`,0, `ingreso`.`Id_TipoAtencion`  ,IF(`ingreso`.`CEspecial` IS NULL, '0',`ingreso`.`CEspecial`) AS CEspecial, `c_clasecita`.`Id_Programa`, `h_atencion`.`TipoGuardado`  ,ingreso.idModalidad , ingreso.idEntornoAtencion , ingreso.idTipoDiscapacidad  \nFROM `ingreso` INNER JOIN `g_usuario`    ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`) INNER JOIN `h_atencion`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN `h_notasclinicas`  ON (`h_notasclinicas`.`Id_Atencion` = `h_atencion`.`Id`) INNER JOIN `h_ordenes_interconsultas`  ON (`h_ordenes_interconsultas`.`Id_Nota` = `h_notasclinicas`.`Id`) INNER JOIN `f_empresacontxconvenio`   ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`) INNER JOIN `h_tiponota`  ON (`h_notasclinicas`.`Id_TipoNota` = `h_tiponota`.`Id`) INNER JOIN `h_tiponota_especialidad`  ON (`h_tiponota_especialidad`.`Id_TipoNota` = `h_tiponota`.`Id`) INNER JOIN `g_persona`  ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`) INNER JOIN `g_tipoedad`  ON (`g_persona`.`Id_TipoEdad` = `g_tipoedad`.`Id`) INNER JOIN `c_clasecita`  ON (`c_clasecita`.`Id` = `h_atencion`.`Id_ClaseCita`) LEFT JOIN `f_camas` ON (`f_camas`.`Id` = ingreso.`Cama`) WHERE (DATE_FORMAT(`ingreso`.`FechaIngreso`,'%Y-%m')='" + this.xmt.formatoANO_MES.format(this.JDCFechaAgenda2.getDate()) + "' AND  CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ', `g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2`) like'%" + this.JTFNombre_u.getText() + "%' and `ingreso`.`Egreso_H` ='" + this.xestado_atencion_h + "'  AND (`ingreso`.`Id_TipoAtencion` =2 OR `ingreso`.`Id_TipoAtencion` >4) AND `ingreso`.`Estado`=0  AND `h_ordenes_interconsultas`.`Id_Especialidad`='" + this.xid_especialidad + "' and  h_tiponota_especialidad.`Id_Historia` <>0 )  GROUP BY `ingreso`.`Id` ORDER BY `ingreso`.`FechaIngreso` ASC ";
                    } else {
                        this.xsql = "SELECT `ingreso`.`Id` , DATE_FORMAT(`ingreso`.`FechaIngreso`,'%d-%m-%Y') AS FIngreso , `ingreso`.`HoraIngreso` ,  `g_usuario`.`NoHistoria`, CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ', `g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2`) AS `NUsuario` , `g_persona`.`Id_Sexo` ,  CONCAT(`g_persona`.`Edad` , ' ', `g_tipoedad`.`Nbre`, '(s)') AS `Edad` , `f_empresacontxconvenio`.`Nbre` AS `NEmpresa`, IF(`f_camas`.`Nbre` IS NULL, '',`f_camas`.`Nbre`) AS `Cama` , `ingreso`.`Egreso` , IF(`ingreso`.`FEgreso_H` IS NULL, '', DATE_FORMAT(`ingreso`.`FEgreso_H`,'%d-%m-%Y')) AS FEgreso_H, `g_persona`.`Id`,  h_tiponota_especialidad.`Id_Historia`,0, `ingreso`.`Id_TipoAtencion`  ,IF(`ingreso`.`CEspecial` IS NULL, '0',`ingreso`.`CEspecial`) AS CEspecial, `c_clasecita`.`Id_Programa`, `h_atencion`.`TipoGuardado`  ,ingreso.idModalidad , ingreso.idEntornoAtencion , ingreso.idTipoDiscapacidad  \nFROM `ingreso` INNER JOIN `g_usuario`    ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`) INNER JOIN `h_atencion`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN `h_notasclinicas`  ON (`h_notasclinicas`.`Id_Atencion` = `h_atencion`.`Id`) INNER JOIN `h_ordenes_interconsultas`  ON (`h_ordenes_interconsultas`.`Id_Nota` = `h_notasclinicas`.`Id`) INNER JOIN `f_empresacontxconvenio`   ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`) INNER JOIN `h_tiponota`  ON (`h_notasclinicas`.`Id_TipoNota` = `h_tiponota`.`Id`) INNER JOIN `h_tiponota_especialidad`  ON (`h_tiponota_especialidad`.`Id_TipoNota` = `h_tiponota`.`Id`) INNER JOIN `g_persona`  ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`) INNER JOIN `g_tipoedad`  ON (`g_persona`.`Id_TipoEdad` = `g_tipoedad`.`Id`) INNER JOIN `c_clasecita`  ON (`c_clasecita`.`Id` = `h_atencion`.`Id_ClaseCita`) LEFT JOIN `f_camas` ON (`f_camas`.`Id` = ingreso.`Cama`) WHERE (DATE_FORMAT(`ingreso`.`FechaIngreso`,'%Y-%m')='" + this.xmt.formatoANO_MES.format(this.JDCFechaAgenda2.getDate()) + "' AND  CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ', `g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2`) like'%" + this.JTFNombre_u.getText() + "%' and `ingreso`.`Egreso_H` ='" + this.xestado_atencion_h + "'  AND (`ingreso`.`Id_TipoAtencion` =2 OR `ingreso`.`Id_TipoAtencion` >4) AND `ingreso`.`Estado`=0  AND `h_ordenes_interconsultas`.`Id_Especialidad`='" + this.xid_especialidad + "' and  h_tiponota_especialidad.`Id_Historia` <>0 )  GROUP BY `ingreso`.`Id` ORDER BY CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ', `g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2`) ASC ";
                    }
                } else if (Principal.informacionIps.getNombreIps().equals("CLINICA LAURELES PSIQUIATRAS ASOCIADOS I.P.S. S.A.S.") || Principal.informacionIps.getNombreIps().equals("CAMBIA TU VIDA IPS SAS") || Principal.informacionIps.getNombreIps().equals("INSTITUTO COLOMBIANO DE NEUROCIENCIAS APLICADAS S.A.S.") || Principal.informacionIps.getNombreIps().equals("UNION TEMPORAL CLINICA LAURELES")) {
                    this.xsql = "SELECT `ingreso`.`Id` , DATE_FORMAT(`ingreso`.`FechaIngreso`,'%d-%m-%Y') AS FIngreso , `ingreso`.`HoraIngreso` ,  `g_usuario`.`NoHistoria`, CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ', `g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2`) AS `NUsuario` , `g_persona`.`Id_Sexo` ,  CONCAT(`g_persona`.`Edad` , ' ', `g_tipoedad`.`Nbre`, '(s)') AS `Edad` , `f_empresacontxconvenio`.`Nbre` AS `NEmpresa`, IF(`f_camas`.`Nbre` IS NULL, '',`f_camas`.`Nbre`) AS `Cama` , `ingreso`.`Egreso` , IF(`ingreso`.`FEgreso_H` IS NULL, '', DATE_FORMAT(`ingreso`.`FEgreso_H`,'%d-%m-%Y')) AS FEgreso_H, `g_persona`.`Id`,  h_tiponota_especialidad.`Id_Historia`,0, `ingreso`.`Id_TipoAtencion`  ,IF(`ingreso`.`CEspecial` IS NULL, '0',`ingreso`.`CEspecial`) AS CEspecial, `c_clasecita`.`Id_Programa`, `h_atencion`.`TipoGuardado`  ,ingreso.idModalidad , ingreso.idEntornoAtencion , ingreso.idTipoDiscapacidad  \nFROM `ingreso` INNER JOIN `g_usuario`    ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`) INNER JOIN `h_atencion`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN `h_notasclinicas`  ON (`h_notasclinicas`.`Id_Atencion` = `h_atencion`.`Id`) INNER JOIN `h_ordenes_interconsultas`  ON (`h_ordenes_interconsultas`.`Id_Nota` = `h_notasclinicas`.`Id`) INNER JOIN `f_empresacontxconvenio`   ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`) INNER JOIN `h_tiponota`  ON (`h_notasclinicas`.`Id_TipoNota` = `h_tiponota`.`Id`) INNER JOIN `h_tiponota_especialidad`  ON (`h_tiponota_especialidad`.`Id_TipoNota` = `h_tiponota`.`Id`) INNER JOIN `g_persona`  ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`) INNER JOIN `g_tipoedad`  ON (`g_persona`.`Id_TipoEdad` = `g_tipoedad`.`Id`) INNER JOIN `c_clasecita`  ON (`c_clasecita`.`Id` = `h_atencion`.`Id_ClaseCita`) LEFT JOIN `f_camas` ON (`f_camas`.`Id` = ingreso.`Cama`) WHERE ( CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ', `g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2`) like'%" + this.JTFNombre_u.getText() + "%' and `ingreso`.`Egreso_H` ='" + this.xestado_atencion_h + "'  AND (`ingreso`.`Id_TipoAtencion` =2 OR `ingreso`.`Id_TipoAtencion` >4) AND `ingreso`.`Estado`=0  AND `h_ordenes_interconsultas`.`Id_Especialidad`='" + this.xid_especialidad + "' and  h_tiponota_especialidad.`Id_Historia` <>0 )  GROUP BY `ingreso`.`Id` ORDER BY `ingreso`.`FechaIngreso` ASC ";
                } else {
                    this.xsql = "SELECT `ingreso`.`Id` , DATE_FORMAT(`ingreso`.`FechaIngreso`,'%d-%m-%Y') AS FIngreso , `ingreso`.`HoraIngreso` ,  `g_usuario`.`NoHistoria`, CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ', `g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2`) AS `NUsuario` , `g_persona`.`Id_Sexo` ,  CONCAT(`g_persona`.`Edad` , ' ', `g_tipoedad`.`Nbre`, '(s)') AS `Edad` , `f_empresacontxconvenio`.`Nbre` AS `NEmpresa`, IF(`f_camas`.`Nbre` IS NULL, '',`f_camas`.`Nbre`) AS `Cama` , `ingreso`.`Egreso` , IF(`ingreso`.`FEgreso_H` IS NULL, '', DATE_FORMAT(`ingreso`.`FEgreso_H`,'%d-%m-%Y')) AS FEgreso_H, `g_persona`.`Id`,  h_tiponota_especialidad.`Id_Historia`,0, `ingreso`.`Id_TipoAtencion`  ,IF(`ingreso`.`CEspecial` IS NULL, '0',`ingreso`.`CEspecial`) AS CEspecial, `c_clasecita`.`Id_Programa`, `h_atencion`.`TipoGuardado`  ,ingreso.idModalidad , ingreso.idEntornoAtencion , ingreso.idTipoDiscapacidad  \nFROM `ingreso` INNER JOIN `g_usuario`    ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`) INNER JOIN `h_atencion`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN `h_notasclinicas`  ON (`h_notasclinicas`.`Id_Atencion` = `h_atencion`.`Id`) INNER JOIN `h_ordenes_interconsultas`  ON (`h_ordenes_interconsultas`.`Id_Nota` = `h_notasclinicas`.`Id`) INNER JOIN `f_empresacontxconvenio`   ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`) INNER JOIN `h_tiponota`  ON (`h_notasclinicas`.`Id_TipoNota` = `h_tiponota`.`Id`) INNER JOIN `h_tiponota_especialidad`  ON (`h_tiponota_especialidad`.`Id_TipoNota` = `h_tiponota`.`Id`) INNER JOIN `g_persona`  ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`) INNER JOIN `g_tipoedad`  ON (`g_persona`.`Id_TipoEdad` = `g_tipoedad`.`Id`)INNER JOIN `c_clasecita`  ON (`c_clasecita`.`Id` = `h_atencion`.`Id_ClaseCita`)  LEFT JOIN `f_camas` ON (`f_camas`.`Id` = ingreso.`Cama`) WHERE ( CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ', `g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2`) like'%" + this.JTFNombre_u.getText() + "%' and `ingreso`.`Egreso_H` ='" + this.xestado_atencion_h + "'  AND (`ingreso`.`Id_TipoAtencion` =2 OR `ingreso`.`Id_TipoAtencion` >4) AND `ingreso`.`Estado`=0  AND `h_ordenes_interconsultas`.`Id_Especialidad`='" + this.xid_especialidad + "' and  h_tiponota_especialidad.`Id_Historia` <>0 )  GROUP BY `ingreso`.`Id` ORDER BY CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ', `g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2`) ASC ";
                }
                ConsultasMySQL xct2 = new ConsultasMySQL();
                ResultSet xrs = xct2.traerRs(this.xsql);
                Throwable th = null;
                try {
                    try {
                        int xfila = 0;
                        if (xrs.next()) {
                            xrs.beforeFirst();
                            this.xmt.mEstablecerTextEditor(this.JTAgendaH, 4);
                            this.xmt.mEstablecerTextEditor(this.JTAgendaH, 7);
                            while (xrs.next()) {
                                this.xmodelo_hospitalizacion.addRow(this.xdato);
                                this.xmodelo_hospitalizacion.setValueAt(Long.valueOf(xrs.getLong(1)), xfila, 0);
                                this.xmodelo_hospitalizacion.setValueAt(xrs.getString(2), xfila, 1);
                                this.xmodelo_hospitalizacion.setValueAt(xrs.getString(3), xfila, 2);
                                this.xmodelo_hospitalizacion.setValueAt(xrs.getString(4), xfila, 3);
                                this.xmodelo_hospitalizacion.setValueAt(xrs.getString(5), xfila, 4);
                                this.xmodelo_hospitalizacion.setValueAt(xrs.getString(6), xfila, 5);
                                this.xmodelo_hospitalizacion.setValueAt(xrs.getString(7), xfila, 6);
                                this.xmodelo_hospitalizacion.setValueAt("NUEVA ORDEN", xfila, 11);
                                this.xmodelo_hospitalizacion.setValueAt(xrs.getString(8), xfila, 7);
                                this.xmodelo_hospitalizacion.setValueAt(xrs.getString(9), xfila, 8);
                                this.xmodelo_hospitalizacion.setValueAt(xrs.getString(11), xfila, 9);
                                this.xmodelo_hospitalizacion.setValueAt(Long.valueOf(xrs.getLong(10)), xfila, 10);
                                this.xmodelo_hospitalizacion.setValueAt(Long.valueOf(xrs.getLong(12)), xfila, 12);
                                this.xmodelo_hospitalizacion.setValueAt(Long.valueOf(xrs.getLong(13)), xfila, 13);
                                this.xmodelo_hospitalizacion.setValueAt(Long.valueOf(xrs.getLong(14)), xfila, 14);
                                this.xmodelo_hospitalizacion.setValueAt(Long.valueOf(xrs.getLong("Id_TipoAtencion")), xfila, 15);
                                this.xmodelo_hospitalizacion.setValueAt(Long.valueOf(xrs.getLong("CEspecial")), xfila, 16);
                                this.xmodelo_hospitalizacion.setValueAt(Long.valueOf(xrs.getLong("Id_Programa")), xfila, 18);
                                this.xmodelo_hospitalizacion.setValueAt(Integer.valueOf(xrs.getInt("TipoGuardado")), xfila, 19);
                                this.xmodelo_hospitalizacion.setValueAt(Integer.valueOf(xrs.getInt("idModalidad")), xfila, 20);
                                this.xmodelo_hospitalizacion.setValueAt(Integer.valueOf(xrs.getInt("idEntornoAtencion")), xfila, 21);
                                this.xmodelo_hospitalizacion.setValueAt(Integer.valueOf(xrs.getInt("idTipoDiscapacidad")), xfila, 22);
                                switch (xrs.getInt("CEspecial")) {
                                    case 1:
                                        this.xmodelo_hospitalizacion.setValueAt(new JLabel(new ImageIcon(getClass().getResource("/Imagenes/Atencion Discapasitaods.png"))), xfila, 17);
                                        break;
                                    case 2:
                                        this.xmodelo_hospitalizacion.setValueAt(new JLabel(new ImageIcon(getClass().getResource("/Imagenes/Atencion Embarazada.png"))), xfila, 17);
                                        break;
                                    case 3:
                                        this.xmodelo_hospitalizacion.setValueAt(new JLabel(new ImageIcon(getClass().getResource("/Imagenes/Atencion Ancianos.png"))), xfila, 17);
                                        break;
                                    case 4:
                                        this.xmodelo_hospitalizacion.setValueAt(new JLabel(new ImageIcon(getClass().getResource("/Imagenes/AtpNiños.png"))), xfila, 17);
                                        break;
                                    default:
                                        this.xmodelo_hospitalizacion.setValueAt(new JLabel(""), xfila, 17);
                                        break;
                                }
                                this.JTAgendaH.setDefaultRenderer(JLabel.class, new Render(xrs.getInt("CEspecial"), 16));
                                xfila++;
                            }
                            this.JLBNRegistro_H.setText("" + xfila);
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
                        xct2.cerrarConexionBd();
                    } finally {
                    }
                } catch (Throwable th3) {
                    th = th3;
                    throw th3;
                }
            } catch (SQLException ex) {
                Logger.getLogger(JIFAgendaMedico_N.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
    }

    public void mCargarDatos_HospitalizacionSP() {
        if (this.xmodelo_hospitalizacion != null) {
            try {
                mCrearTablaAgenda_Hospitalizacion();
                if (this.JCH_FSalaParto.isSelected()) {
                    if (this.JCHFiltro_H.isSelected()) {
                        if (this.JRBDeAlta_H.isSelected()) {
                            this.xsql = "SELECT `ingreso`.`Id` , DATE_FORMAT(`ingreso`.`FechaIngreso`,'%d-%m-%Y') AS FIngreso , `ingreso`.`HoraIngreso` ,  `g_usuario`.`NoHistoria`, CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ', `g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2`) AS `NUsuario` , `g_persona`.`Id_Sexo` ,  CONCAT(`g_persona`.`Edad` , ' ', `g_tipoedad`.`Nbre`, '(s)') AS `Edad` , `f_empresacontxconvenio`.`Nbre` AS `NEmpresa`, IF(f_camas.`Nbre`IS NULL, '', f_camas.`Nbre`) AS Cama , `ingreso`.`Egreso` ,  IF(`ingreso`.`FEgreso_H` IS NULL, '', DATE_FORMAT(`ingreso`.`FEgreso_H`,'%d-%m-%Y')) AS FEgreso_H, `g_persona`.`Id`,  `c_clasecita`.`Id_Historia`,0, `ingreso`.`Id_TipoAtencion`   ,IF(`ingreso`.`CEspecial` IS NULL, '0',`ingreso`.`CEspecial`) AS CEspecial, `c_clasecita`.`Id_Programa`, `h_atencion`.`TipoGuardado`  ,ingreso.idModalidad , ingreso.idEntornoAtencion , ingreso.idTipoDiscapacidad  \nFROM `ingreso` INNER JOIN `g_usuario`    ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)  INNER JOIN `h_atencion`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)  INNER JOIN `c_clasecita`  ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)  INNER JOIN `h_tipohistoria`  ON (`h_tipohistoria`.`Id` = `c_clasecita`.`Id_Historia`)  INNER JOIN `f_empresacontxconvenio`   ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)  INNER JOIN `g_persona`  ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`) INNER JOIN `g_tipoedad`  ON (`g_persona`.`Id_TipoEdad` = `g_tipoedad`.`Id`) LEFT JOIN `f_camas` ON (`f_camas`.`Id` = ingreso.`Cama`) WHERE (ingreso.`CS_Parto`=1 and DATE_FORMAT(`ingreso`.`FechaIngreso`,'%Y-%m')='" + this.xmt.formatoANO_MES.format(this.JDCFechaAgenda2.getDate()) + "' AND (`ingreso`.`Egreso_H` ='" + this.xestado_atencion_h + "' or `ingreso`.`Egreso` ='" + this.xestado_atencion_h + "')  AND CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ', `g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2`) like'%" + this.JTFNombre_H.getText() + "%'  AND `ingreso`.`Id_TipoAtencion` in(2,3) AND `ingreso`.`Estado`=0    )  GROUP BY `ingreso`.`Id` ORDER BY CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ', `g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2`) ASC, `ingreso`.`FechaIngreso` DESC ";
                        } else {
                            this.xsql = "SELECT `ingreso`.`Id` , DATE_FORMAT(`ingreso`.`FechaIngreso`,'%d-%m-%Y') AS FIngreso , `ingreso`.`HoraIngreso` ,  `g_usuario`.`NoHistoria`, CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ', `g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2`) AS `NUsuario` , `g_persona`.`Id_Sexo` ,  CONCAT(`g_persona`.`Edad` , ' ', `g_tipoedad`.`Nbre`, '(s)') AS `Edad` , `f_empresacontxconvenio`.`Nbre` AS `NEmpresa`, IF(f_camas.`Nbre`IS NULL, '', f_camas.`Nbre`) AS Cama , `ingreso`.`Egreso` ,  IF(`ingreso`.`FEgreso_H` IS NULL, '', DATE_FORMAT(`ingreso`.`FEgreso_H`,'%d-%m-%Y')) AS FEgreso_H, `g_persona`.`Id`,  `c_clasecita`.`Id_Historia`,0, `ingreso`.`Id_TipoAtencion`   ,IF(`ingreso`.`CEspecial` IS NULL, '0',`ingreso`.`CEspecial`) AS CEspecial, `c_clasecita`.`Id_Programa`  ,ingreso.idModalidad , ingreso.idEntornoAtencion , ingreso.idTipoDiscapacidad  \nFROM `ingreso` INNER JOIN `g_usuario`    ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)  INNER JOIN `h_atencion`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)  INNER JOIN `c_clasecita`  ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)  INNER JOIN `h_tipohistoria`  ON (`h_tipohistoria`.`Id` = `c_clasecita`.`Id_Historia`)  INNER JOIN `f_empresacontxconvenio`   ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)  INNER JOIN `g_persona`  ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`) INNER JOIN `g_tipoedad`  ON (`g_persona`.`Id_TipoEdad` = `g_tipoedad`.`Id`) WHERE (ingreso.`CS_Parto`=1 and (`ingreso`.`Egreso_H` ='" + this.xestado_atencion_h + "' or `ingreso`.`Egreso` ='" + this.xestado_atencion_h + "')  AND CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ', `g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2`) like'%" + this.JTFNombre_H.getText() + "%'  AND `ingreso`.`Id_TipoAtencion` in(2,3) AND `ingreso`.`Estado`=0    )  GROUP BY `ingreso`.`Id` ORDER BY CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ', `g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2`) ASC ";
                        }
                    } else if (this.JRBDeAlta_H.isSelected()) {
                        this.xsql = "SELECT `ingreso`.`Id` , DATE_FORMAT(`ingreso`.`FechaIngreso`,'%d-%m-%Y') AS FIngreso , `ingreso`.`HoraIngreso` ,   `g_usuario`.`NoHistoria`, CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ', `g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2`) AS `NUsuario` , `g_persona`.`Id_Sexo` ,  CONCAT(`g_persona`.`Edad` , ' ', `g_tipoedad`.`Nbre`, '(s)') AS `Edad` , `f_empresacontxconvenio`.`Nbre` AS `NEmpresa`, IF(f_camas.`Nbre`IS NULL, '', f_camas.`Nbre`) AS Cama , `ingreso`.`Egreso` ,  IF(`ingreso`.`FEgreso_H` IS NULL, '', DATE_FORMAT(`ingreso`.`FEgreso_H`,'%d-%m-%Y')) AS FEgreso_H, `g_persona`.`Id`,  `c_clasecita`.`Id_Historia`,0, `ingreso`.`Id_TipoAtencion`   ,IF(`ingreso`.`CEspecial` IS NULL, '0',`ingreso`.`CEspecial`) AS CEspecial, `c_clasecita`.`Id_Programa`, `h_atencion`.`TipoGuardado`  ,ingreso.idModalidad , ingreso.idEntornoAtencion , ingreso.idTipoDiscapacidad  \nFROM `ingreso` INNER JOIN `g_usuario`    ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)  INNER JOIN `h_atencion`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)  INNER JOIN `c_clasecita`  ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)  INNER JOIN `h_tipohistoria`  ON (`h_tipohistoria`.`Id` = `c_clasecita`.`Id_Historia`)  INNER JOIN `f_empresacontxconvenio`   ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`) INNER JOIN `g_persona`  ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`) INNER JOIN `g_tipoedad`  ON (`g_persona`.`Id_TipoEdad` = `g_tipoedad`.`Id`) LEFT JOIN `f_camas` ON (`f_camas`.`Id` = ingreso.`Cama`)  WHERE (ingreso.`CS_Parto`=1 and DATE_FORMAT(`ingreso`.`FechaIngreso`,'%Y-%m')='" + this.xmt.formatoANO_MES.format(this.JDCFechaAgenda2.getDate()) + "' AND (`ingreso`.`Egreso_H` ='" + this.xestado_atencion_h + "' or `ingreso`.`Egreso` ='" + this.xestado_atencion_h + "')   AND `ingreso`.`Id_TipoAtencion` in(2,3)  AND `ingreso`.`Estado`=0  )  GROUP BY `ingreso`.`Id` ORDER BY CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ', `g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2`) ASC, `ingreso`.`FechaIngreso` DESC ";
                    } else {
                        this.xsql = "SELECT `ingreso`.`Id` , DATE_FORMAT(`ingreso`.`FechaIngreso`,'%d-%m-%Y') AS FIngreso , `ingreso`.`HoraIngreso` ,   `g_usuario`.`NoHistoria`, CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ', `g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2`) AS `NUsuario` , `g_persona`.`Id_Sexo` ,  CONCAT(`g_persona`.`Edad` , ' ', `g_tipoedad`.`Nbre`, '(s)') AS `Edad` , `f_empresacontxconvenio`.`Nbre` AS `NEmpresa`, IF(f_camas.`Nbre`IS NULL, '', f_camas.`Nbre`) AS Cama , `ingreso`.`Egreso` ,  IF(`ingreso`.`FEgreso_H` IS NULL, '', DATE_FORMAT(`ingreso`.`FEgreso_H`,'%d-%m-%Y')) AS FEgreso_H, `g_persona`.`Id`,  `c_clasecita`.`Id_Historia`,0, `ingreso`.`Id_TipoAtencion`   ,IF(`ingreso`.`CEspecial` IS NULL, '0',`ingreso`.`CEspecial`) AS CEspecial, `c_clasecita`.`Id_Programa`, `h_atencion`.`TipoGuardado`  ,ingreso.idModalidad , ingreso.idEntornoAtencion , ingreso.idTipoDiscapacidad  \nFROM `ingreso` INNER JOIN `g_usuario`    ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)  INNER JOIN `h_atencion`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)  INNER JOIN `c_clasecita`  ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)  INNER JOIN `h_tipohistoria`  ON (`h_tipohistoria`.`Id` = `c_clasecita`.`Id_Historia`)  INNER JOIN `f_empresacontxconvenio`   ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`) INNER JOIN `g_persona`  ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`) INNER JOIN `g_tipoedad`  ON (`g_persona`.`Id_TipoEdad` = `g_tipoedad`.`Id`) LEFT JOIN `f_camas` ON (`f_camas`.`Id` = ingreso.`Cama`)  WHERE (ingreso.`CS_Parto`=1 and (`ingreso`.`Egreso_H` ='" + this.xestado_atencion_h + "' or `ingreso`.`Egreso` ='" + this.xestado_atencion_h + "')  AND `ingreso`.`Id_TipoAtencion` in(2,3)  AND `ingreso`.`Estado`=0  )  GROUP BY `ingreso`.`Id` ORDER BY CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ', `g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2`) ASC ";
                    }
                }
                ConsultasMySQL xct2 = new ConsultasMySQL();
                ResultSet xrs = xct2.traerRs(this.xsql);
                Throwable th = null;
                try {
                    try {
                        int xfila = 0;
                        if (xrs.next()) {
                            xrs.beforeFirst();
                            this.xmt.mEstablecerTextEditor(this.JTAgendaH, 4);
                            this.xmt.mEstablecerTextEditor(this.JTAgendaH, 7);
                            while (xrs.next()) {
                                this.xmodelo_hospitalizacion.addRow(this.xdato);
                                this.xmodelo_hospitalizacion.setValueAt(Long.valueOf(xrs.getLong(1)), xfila, 0);
                                this.xmodelo_hospitalizacion.setValueAt(xrs.getString(2), xfila, 1);
                                this.xmodelo_hospitalizacion.setValueAt(xrs.getString(3), xfila, 2);
                                this.xmodelo_hospitalizacion.setValueAt(xrs.getString(4), xfila, 3);
                                this.xmodelo_hospitalizacion.setValueAt(xrs.getString(5), xfila, 4);
                                this.xmodelo_hospitalizacion.setValueAt(xrs.getString(6), xfila, 5);
                                this.xmodelo_hospitalizacion.setValueAt(xrs.getString(7), xfila, 6);
                                this.xmodelo_hospitalizacion.setValueAt("NUEVA ORDEN", xfila, 11);
                                this.xmodelo_hospitalizacion.setValueAt(xrs.getString(8), xfila, 7);
                                this.xmodelo_hospitalizacion.setValueAt(xrs.getString(9), xfila, 8);
                                this.xmodelo_hospitalizacion.setValueAt(xrs.getString(11), xfila, 9);
                                this.xmodelo_hospitalizacion.setValueAt(Long.valueOf(xrs.getLong(10)), xfila, 10);
                                this.xmodelo_hospitalizacion.setValueAt(Long.valueOf(xrs.getLong(12)), xfila, 12);
                                this.xmodelo_hospitalizacion.setValueAt(Long.valueOf(xrs.getLong(13)), xfila, 13);
                                this.xmodelo_hospitalizacion.setValueAt(Long.valueOf(xrs.getLong(14)), xfila, 14);
                                this.xmodelo_hospitalizacion.setValueAt(Long.valueOf(xrs.getLong("Id_TipoAtencion")), xfila, 15);
                                this.xmodelo_hospitalizacion.setValueAt(Long.valueOf(xrs.getLong("CEspecial")), xfila, 16);
                                this.xmodelo_hospitalizacion.setValueAt(Long.valueOf(xrs.getLong("Id_Programa")), xfila, 18);
                                this.xmodelo_hospitalizacion.setValueAt(Integer.valueOf(xrs.getInt("TipoGuardado")), xfila, 19);
                                this.xmodelo_hospitalizacion.setValueAt(Integer.valueOf(xrs.getInt("idModalidad")), xfila, 20);
                                this.xmodelo_hospitalizacion.setValueAt(Integer.valueOf(xrs.getInt("idEntornoAtencion")), xfila, 21);
                                this.xmodelo_hospitalizacion.setValueAt(Integer.valueOf(xrs.getInt("idTipoDiscapacidad")), xfila, 22);
                                switch (xrs.getInt("CEspecial")) {
                                    case 1:
                                        this.xmodelo_hospitalizacion.setValueAt(new JLabel(new ImageIcon(getClass().getResource("/Imagenes/Atencion Discapasitaods.png"))), xfila, 17);
                                        break;
                                    case 2:
                                        this.xmodelo_hospitalizacion.setValueAt(new JLabel(new ImageIcon(getClass().getResource("/Imagenes/Atencion Embarazada.png"))), xfila, 17);
                                        break;
                                    case 3:
                                        this.xmodelo_hospitalizacion.setValueAt(new JLabel(new ImageIcon(getClass().getResource("/Imagenes/Atencion Ancianos.png"))), xfila, 17);
                                        break;
                                    case 4:
                                        this.xmodelo_hospitalizacion.setValueAt(new JLabel(new ImageIcon(getClass().getResource("/Imagenes/AtpNiños.png"))), xfila, 17);
                                        break;
                                    default:
                                        this.xmodelo_hospitalizacion.setValueAt(new JLabel(""), xfila, 17);
                                        break;
                                }
                                this.JTAgendaH.setDefaultRenderer(JLabel.class, new Render(xrs.getInt("CEspecial"), 16));
                                xfila++;
                            }
                            this.JLBNRegistro_H.setText("" + xfila);
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
                        xct2.cerrarConexionBd();
                    } finally {
                    }
                } catch (Throwable th3) {
                    th = th3;
                    throw th3;
                }
            } catch (SQLException ex) {
                Logger.getLogger(JIFAgendaMedico_N.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:Historia/JIFAgendaMedico_N$MiRender.class */
    public class MiRender extends DefaultTableCellRenderer {
        public MiRender() {
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (table.getValueAt(row, 11) != null) {
                int cantidad = Integer.valueOf(table.getValueAt(row, 11).toString()).intValue();
                if (cantidad == 0) {
                    cell.setBackground(Color.CYAN);
                    cell.setForeground(Color.BLACK);
                } else if (cantidad == 1) {
                    cell.setBackground(Color.PINK);
                    cell.setForeground(Color.BLACK);
                } else if (cantidad == 2) {
                    cell.setBackground(Color.YELLOW);
                    cell.setForeground(Color.BLACK);
                } else {
                    cell.setBackground(Color.MAGENTA);
                    cell.setForeground(Color.BLACK);
                }
            }
            return cell;
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:Historia/JIFAgendaMedico_N$MiRender1.class */
    public class MiRender1 extends DefaultTableCellRenderer {
        public MiRender1() {
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (table.getValueAt(row, 14) != null) {
                int cantidad = Integer.valueOf(table.getValueAt(row, 14).toString()).intValue();
                if (cantidad == 1) {
                    cell.setBackground(new Color(186, 22, 99));
                    cell.setForeground(Color.WHITE);
                } else if (cantidad == 2) {
                    cell.setBackground(Color.ORANGE);
                    cell.setForeground(Color.BLACK);
                } else if (cantidad == 3) {
                    cell.setBackground(Color.YELLOW);
                    cell.setForeground(Color.BLACK);
                } else if (cantidad == 4) {
                    cell.setBackground(new Color(57, 107, 52));
                    cell.setForeground(Color.WHITE);
                } else {
                    cell.setBackground(new Color(204, 204, 204));
                    cell.setForeground(Color.BLACK);
                }
            }
            return cell;
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:Historia/JIFAgendaMedico_N$MiRender2.class */
    public class MiRender2 extends DefaultTableCellRenderer {
        public MiRender2() {
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (table.getValueAt(row, 18) != null) {
                int xTipoGrabado = Integer.valueOf(table.getValueAt(row, 18).toString()).intValue();
                if (xTipoGrabado == 0) {
                    if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO CAMU DEL PRADO")) {
                        if (Integer.valueOf(table.getValueAt(row, 22).toString()).intValue() == -1) {
                            cell.setBackground(Color.WHITE);
                            cell.setForeground(Color.BLACK);
                        } else if (Integer.valueOf(table.getValueAt(row, 22).toString()).intValue() == 1) {
                            cell.setBackground(new Color(186, 22, 99));
                            cell.setForeground(Color.WHITE);
                        } else if (Integer.valueOf(table.getValueAt(row, 22).toString()).intValue() == 2) {
                            cell.setBackground(Color.ORANGE);
                            cell.setForeground(Color.BLACK);
                        } else if (Integer.valueOf(table.getValueAt(row, 22).toString()).intValue() == 3) {
                            cell.setBackground(Color.YELLOW);
                            cell.setForeground(Color.BLACK);
                        } else if (Integer.valueOf(table.getValueAt(row, 22).toString()).intValue() == 4) {
                            cell.setBackground(new Color(57, 107, 52));
                            cell.setForeground(Color.WHITE);
                        } else {
                            cell.setBackground(new Color(204, 204, 204));
                            cell.setForeground(Color.BLACK);
                        }
                    } else if (Integer.valueOf(table.getValueAt(row, 19).toString()).intValue() == 1) {
                        cell.setBackground(Color.RED);
                        cell.setForeground(Color.BLACK);
                    } else {
                        cell.setBackground(Color.CYAN);
                        cell.setForeground(Color.BLACK);
                    }
                } else if (xTipoGrabado == 1) {
                    cell.setBackground(Color.MAGENTA);
                    cell.setForeground(Color.BLACK);
                } else if (xTipoGrabado == 2) {
                    cell.setBackground(new Color(133, 218, 160));
                    cell.setForeground(Color.BLACK);
                }
            }
            return cell;
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:Historia/JIFAgendaMedico_N$MiRender3.class */
    public class MiRender3 extends DefaultTableCellRenderer {
        public MiRender3() {
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (table.getValueAt(row, 10) != null) {
                int cantidad = Integer.valueOf(table.getValueAt(row, 10).toString()).intValue();
                if (cantidad == 0) {
                    cell.setBackground(Color.CYAN);
                    cell.setForeground(Color.BLACK);
                } else if (cantidad == 1) {
                    cell.setBackground(Color.MAGENTA);
                    cell.setForeground(Color.BLACK);
                } else if (cantidad == 2) {
                    cell.setBackground(new Color(133, 218, 160));
                    cell.setForeground(Color.BLACK);
                }
            }
            return cell;
        }
    }

    private void mNuevo() {
        this.xlleno = false;
        this.JDCFechaAgenda.setDate(this.xmt.getFechaActual());
        this.JDCFechaAgenda1.setDate(this.xmt.getFechaActual());
        this.JDCFechaAgenda2.setDate(this.xmt.getFechaActual());
        this.JDCFechaAgendaCX.setDate(this.xmt.getFechaActual());
        this.xidt = 0;
        this.xestado = 1;
        if (Principal.informacionIps.getEsFpz().intValue() == 0) {
            this.JCHFiltro1.setSelected(true);
            this.JCH_FSalaParto.setVisible(false);
        } else if (Principal.informacionIps.getNombreIps().equals("CLINICA OFTALMOLOGICA DAJUD SAS") || Principal.informacionIps.getNombreIps().equals("CLINICA LAURELES PSIQUIATRAS ASOCIADOS I.P.S. S.A.S.") || Principal.informacionIps.getNombreIps().equals("UNION TEMPORAL CLINICA LAURELES")) {
            this.JCHFiltro_Profesional.setSelected(true);
            this.JCH_FSalaParto.setVisible(false);
        } else if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL LOCAL DE MONTELIBANO")) {
            this.JCH_FSalaParto.setVisible(true);
            this.JCHFiltro_Profesional.setSelected(true);
        } else {
            this.JCH_FSalaParto.setVisible(false);
        }
        if (!Principal.informacionIps.getIdentificacion().equals("812005644")) {
            this.JBTCCirugiasP.setVisible(false);
        } else {
            this.JBTCCirugiasP.setVisible(true);
        }
        mCrearTablaAgenda();
        mCrearTablaAgendaNp();
        mCrearTablaAgenda_Urgencias();
        mCrearTablaAgenda_Hospitalizacion();
        mCrearTablaAgenda_Cx();
        this.xlleno = true;
    }

    public void mImprimir() {
        String[][] mparametros = new String[6][2];
        mparametros[0][0] = "FechaI";
        mparametros[0][1] = this.xmt.formatoAMD1.format(this.JDCFechaAgenda.getDate());
        mparametros[1][0] = "FechaF";
        mparametros[1][1] = this.xmt.formatoAMD1.format(this.JDCFechaAgenda.getDate());
        mparametros[2][0] = "Id_Profesional";
        mparametros[2][1] = this.xid_profesional;
        mparametros[3][0] = "Id_Especialidad";
        mparametros[3][1] = this.xid_especialidad;
        mparametros[4][0] = "SUBREPORT_DIR";
        mparametros[4][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
        mparametros[5][0] = "SUBREPORTFIRMA_DIR";
        mparametros[5][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
        if (!Principal.informacionIps.getIdentificacion().equals("812005644")) {
            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "H_Consolidado_CitasAtendidas", mparametros);
        }
    }

    public void mValidar_CitasEspeciales() {
        try {
            this.xsql = "SELECT gu.NoHistoria, concat(gp.Apellido1, ' ', gp.Apellido2,' ', gp.Nombre1,' ', gp.Nombre2) NUsuario, \nCONCAT(Devuelve_Edad_2F(h_atencion.Fecha_Atencion, gp.FechaNac),' ',Devuelve_Tipo_Edad_2F(h_atencion.Fecha_Atencion, gp.FechaNac)),\ngs.Nbre  as NSexo, ingreso.Id_Usuario, h_atencion.Id_Ingreso, h_atencionespeciales.EstadoA, c_clasecita.Id_Historia,\nh_atencionespeciales.Id, c_clasecita.Id, ingreso.Id_TipoAtencion \nFROM h_atencionespeciales\nINNER JOIN h_atencion  ON (h_atencionespeciales.Id_Atencion = h_atencion.Id) \nINNER JOIN ingreso ON (h_atencion.Id_Ingreso = ingreso.Id) \nINNER JOIN g_persona gp  ON (ingreso.Id_Usuario = gp.Id)\ninner join g_sexo gs on (gs.Id=gp.Id_Sexo)\ninner join g_usuario gu on (gu.Id_persona=gp.Id)\nINNER JOIN c_clasecita ON (h_atencion.Id_ClaseCita= c_clasecita.Id) WHERE (h_atencionespeciales.Id_Profesional ='" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "' AND h_atencionespeciales.EstadoA =0 and DATE_FORMAT(h_atencionespeciales.Fecha_Atencion,'%d/%m/%Y')='" + this.xmt.formatoDMA.format(this.xmt.getFechaActual()) + "' ) ORDER BY h_atencionespeciales.Fecha_Atencion ASC ";
            ResultSet xrs = this.xct.traerRs(this.xsql);
            if (xrs.next()) {
                JBT_AtencionesPendientes.setIcon(new ImageIcon(getClass().getResource("/Imagenes/alerta1.gif")));
                JBT_AtencionesPendientes.setText("");
            } else {
                JBT_AtencionesPendientes.setIcon(new ImageIcon());
                JBT_AtencionesPendientes.setText("SIN ATENCIÓN");
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFAgendaMedico_N.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mValidar_CitasEspeciales_Urgencias() {
        try {
            if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL LOCAL DE MONTELIBANO")) {
                this.xsql = "SELECT gu.NoHistoria, concat(gp.Apellido1, ' ', gp.Apellido2,' ', gp.Nombre1,' ', gp.Nombre2) NUsuario, \nCONCAT(Devuelve_Edad_2F(h_atencion.Fecha_Atencion, gp.FechaNac),' ',Devuelve_Tipo_Edad_2F(h_atencion.Fecha_Atencion, gp.FechaNac)),\ngs.Nbre  as NSexo, ingreso.Id_Usuario, h_atencion.Id_Ingreso, h_atencionespeciales.EstadoA, c_clasecita.Id_Historia,\nh_atencionespeciales.Id, c_clasecita.Id, ingreso.Id_TipoAtencion \nFROM h_atencionespeciales \nINNER JOIN h_atencion  ON (h_atencionespeciales.Id_Atencion = h_atencion.Id) \nINNER JOIN ingreso ON (h_atencion.Id_Ingreso = ingreso.Id) \nINNER JOIN g_persona gp  ON (ingreso.Id_Usuario = gp.Id)\ninner join g_usuario gu on (gu.Id_persona=gp.Id)\ninner join g_sexo gs on (gs.Id=gp.Id_Sexo)\nINNER JOIN c_clasecita ON (h_atencion.Id_ClaseCita= c_clasecita.Id) WHERE ( ingreso.Id_TipoAtencion>1  and h_atencionespeciales.EstadoA =0 and DATE_FORMAT(h_atencionespeciales.Fecha_Atencion,'%d/%m/%Y')='" + this.xmt.formatoDMA.format(this.xmt.getFechaActual()) + "' ) ORDER BY h_atencionespeciales.Fecha_Atencion ASC ";
            } else {
                this.xsql = "SELECT gu.NoHistoria, concat(gp.Apellido1, ' ', gp.Apellido2,' ', gp.Nombre1,' ', gp.Nombre2) NUsuario, \nCONCAT(Devuelve_Edad_2F(h_atencion.Fecha_Atencion, gp.FechaNac),' ',Devuelve_Tipo_Edad_2F(h_atencion.Fecha_Atencion, gp.FechaNac)),\ngs.Nbre  as NSexo, ingreso.Id_Usuario, h_atencion.Id_Ingreso, h_atencionespeciales.EstadoA, c_clasecita.Id_Historia,\nh_atencionespeciales.Id, c_clasecita.Id, ingreso.Id_TipoAtencion \nFROM h_atencionespeciales \nINNER JOIN h_atencion  ON (h_atencionespeciales.Id_Atencion = h_atencion.Id) \nINNER JOIN ingreso ON (h_atencion.Id_Ingreso = ingreso.Id) \nINNER JOIN g_persona gp  ON (ingreso.Id_Usuario = gp.Id)\ninner join g_usuario gu on (gu.Id_persona=gp.Id)\ninner join g_sexo gs on (gs.Id=gp.Id_Sexo)\nINNER JOIN c_clasecita ON (h_atencion.Id_ClaseCita= c_clasecita.Id) WHERE (h_atencionespeciales.Id_Profesional ='" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "' AND h_atencionespeciales.EstadoA =0 and DATE_FORMAT(h_atencionespeciales.Fecha_Atencion,'%d/%m/%Y')='" + this.xmt.formatoDMA.format(this.xmt.getFechaActual()) + "' ) ORDER BY h_atencionespeciales.Fecha_Atencion ASC ";
            }
            ResultSet xrs = this.xct.traerRs(this.xsql);
            if (xrs.next()) {
                JBT_AtencionesPendientes1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/alerta1.gif")));
                JBT_AtencionesPendientes1.setText("");
                JBT_AtencionesPendientes2.setIcon(new ImageIcon(getClass().getResource("/Imagenes/alerta1.gif")));
                JBT_AtencionesPendientes2.setText("");
            } else {
                JBT_AtencionesPendientes1.setIcon(new ImageIcon());
                JBT_AtencionesPendientes1.setText("SIN ATENCIÓN");
                JBT_AtencionesPendientes2.setIcon(new ImageIcon());
                JBT_AtencionesPendientes2.setText("SIN ATENCIÓN");
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFAgendaMedico_N.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void iniciarHilo() {
        if (this.claseHilo == null) {
            this.claseHilo = new mRefrescarAgenda1(this);
        }
        if (this.hilo == null) {
            this.hilo = new Thread(this.claseHilo);
        }
        this.hilo.start();
    }

    private void mCargarDatosClaseCitasProgramadas() {
        try {
            this.JTAgendaP.setCursor(new Cursor(3));
            clasesHistoriaCE.informacionAgendaMedicaDTO.setNumeroHistoria(this.xmodelo.getValueAt(this.xpos, 0).toString());
            clasesHistoriaCE.informacionAgendaMedicaDTO.setNombreUsuario(this.xmodelo.getValueAt(this.xpos, 1).toString());
            clasesHistoriaCE.informacionAgendaMedicaDTO.setEdad(this.xmodelo.getValueAt(this.xpos, 2).toString());
            clasesHistoriaCE.informacionAgendaMedicaDTO.setNombreSexo(this.xmodelo.getValueAt(this.xpos, 3).toString());
            clasesHistoriaCE.informacionAgendaMedicaDTO.setIdSexo(this.xmodelo.getValueAt(this.xpos, 3).toString());
            clasesHistoriaCE.informacionAgendaMedicaDTO.setNombreTipoConsulta(this.xmodelo.getValueAt(this.xpos, 4).toString().toUpperCase());
            clasesHistoriaCE.informacionAgendaMedicaDTO.setIdUsuarioAtendido(Long.valueOf(this.xmodelo.getValueAt(this.xpos, 7).toString()));
            clasesHistoriaCE.informacionAgendaMedicaDTO.setIdIngreso(Long.valueOf(this.xmodelo.getValueAt(this.xpos, 8).toString()));
            clasesHistoriaCE.informacionAgendaMedicaDTO.setIdTipoCita(Long.valueOf(this.xmodelo.getValueAt(this.xpos, 14).toString()));
            clasesHistoriaCE.informacionAgendaMedicaDTO.setIdTipohc(Integer.valueOf(this.xmodelo.getValueAt(this.xpos, 10).toString()));
            clasesHistoriaCE.informacionAgendaMedicaDTO.setIdCita(Long.valueOf(this.xmodelo.getValueAt(this.xpos, 12).toString()));
            clasesHistoriaCE.informacionAgendaMedicaDTO.setEsRemitada(Integer.valueOf(this.xmodelo.getValueAt(this.xpos, 15).toString()));
            clasesHistoriaCE.informacionAgendaMedicaDTO.setIdClaseCita(Integer.valueOf(this.xmodelo.getValueAt(this.xpos, 9).toString()));
            clasesHistoriaCE.informacionAgendaMedicaDTO.setIdPrograma(Integer.valueOf(this.xmodelo.getValueAt(this.xpos, 16).toString()));
            clasesHistoriaCE.informacionAgendaMedicaDTO.setEsSaludOcupacional(Integer.valueOf(this.xmodelo.getValueAt(this.xpos, 17).toString()));
            clasesHistoriaCE.informacionAgendaMedicaDTO.setEsOdontologica(Integer.valueOf(this.xmodelo.getValueAt(this.xpos, 19).toString()));
            clasesHistoriaCE.informacionAgendaMedicaDTO.setIdTratamiento(Long.valueOf(this.xmodelo.getValueAt(this.xpos, 20).toString()));
            clasesHistoriaCE.informacionAgendaMedicaDTO.setTipoTratamiento(Long.valueOf(this.xmodelo.getValueAt(this.xpos, 18).toString()));
            clasesHistoriaCE.informacionAgendaMedicaDTO.setNombreEmpresaCovenio(this.xmodelo.getValueAt(this.xpos, 21).toString());
            clasesHistoriaCE.informacionAgendaMedicaDTO.setFechaNacimiento(this.xmodelo.getValueAt(this.xpos, 28).toString());
            clasesHistoriaCE.informacionAgendaMedicaDTO.setFechaIngreso(this.xmodelo.getValueAt(this.xpos, 29).toString());
            clasesHistoriaCE.informacionAgendaMedicaDTO.setEsPeriodico(Integer.valueOf(this.xmodelo.getValueAt(this.xpos, 23).toString()));
            clasesHistoriaCE.informacionAgendaMedicaDTO.setIdModalidad(Integer.valueOf(this.xmodelo.getValueAt(this.xpos, 32).toString()));
            clasesHistoriaCE.informacionAgendaMedicaDTO.setIdEntornoAtencion(Integer.valueOf(this.xmodelo.getValueAt(this.xpos, 33).toString()));
            clasesHistoriaCE.informacionAgendaMedicaDTO.setIdTipoDiscapacidad(Integer.valueOf(this.xmodelo.getValueAt(this.xpos, 34).toString()));
            clasesHistoriaCE.informacionAgendaMedicaDTO.setTipoCita(0);
            clasesHistoriaCE.informacionAgendaMedicaDTO.setTipoAtencion(1);
            clasesHistoriaCE.informacionAgendaMedicaDTO.setFormaHistoria(0);
            clasesHistoriaCE.informacionAgendaMedicaDTO.setIdOrden(0L);
            clasesHistoriaCE.informacionAgendaMedicaDTO.setIdProcedimiento(0L);
            this.xclaseHC.mBuscarAtencionIngreso();
            this.xclaseHC.mActualizarFechaHoraIniciaAtencion();
            clasesHistoriaCE.informacionAgendaMedicaDTO.setFecha_HoraAtencion(this.xmt.formatoDMA1.format(this.JDCFechaAgenda.getDate()) + " " + this.xmt.formatoH24.format(this.xmt.getFechaActual()));
            if (Long.parseLong(this.xmodelo.getValueAt(this.xpos, 15).toString()) > 0) {
                String[][] mparametros = new String[3][2];
                mparametros[0][0] = "idremision";
                mparametros[0][1] = this.xmodelo.getValueAt(this.xpos, 15).toString();
                mparametros[1][0] = "SUBREPORT_DIR";
                mparametros[1][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
                mparametros[2][0] = "SUBREPORTFIRMA_DIR";
                mparametros[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
                if (this.xclaseHC.mImprimirRemisiones(this.xmodelo.getValueAt(this.xpos, 15).toString())) {
                    this.xmt.GenerarPDF(this.xmt.getRutaRep() + "RRemision", mparametros);
                } else {
                    this.xmt.GenerarPDF(this.xmt.getRutaRep() + "RRemisionTO", mparametros);
                }
            }
            dispose();
            this.claseHilo.xvalor = false;
            this.claseHilo = null;
            this.xclaseHC.xjifagendan = null;
            finalize();
            this.xclaseHC.cargarPantalla("Historia", this.xclaseHC.frmPrincipal, "Historia_Med");
        } catch (Throwable ex) {
            Logger.getLogger(JIFAgendaMedico_N.class.getName()).log(Level.SEVERE, (String) null, ex);
        }
    }

    private void mCargarDatosClaseCitasNoProgramadas() {
        try {
            this.JTAgendaNP.setCursor(new Cursor(3));
            clasesHistoriaCE.informacionAgendaMedicaDTO.setNumeroHistoria(this.xmodelo1.getValueAt(this.xposnp, 0).toString());
            clasesHistoriaCE.informacionAgendaMedicaDTO.setNombreUsuario(this.xmodelo1.getValueAt(this.xposnp, 1).toString());
            clasesHistoriaCE.informacionAgendaMedicaDTO.setEdad(this.xmodelo1.getValueAt(this.xposnp, 2).toString());
            clasesHistoriaCE.informacionAgendaMedicaDTO.setNombreSexo(this.xmodelo1.getValueAt(this.xposnp, 3).toString());
            clasesHistoriaCE.informacionAgendaMedicaDTO.setIdSexo(this.xmodelo1.getValueAt(this.xposnp, 3).toString());
            clasesHistoriaCE.informacionAgendaMedicaDTO.setNombreTipoConsulta(this.xmodelo1.getValueAt(this.xposnp, 4).toString().toUpperCase());
            clasesHistoriaCE.informacionAgendaMedicaDTO.setIdUsuarioAtendido(Long.valueOf(this.xmodelo1.getValueAt(this.xposnp, 6).toString()));
            clasesHistoriaCE.informacionAgendaMedicaDTO.setIdIngreso(Long.valueOf(this.xmodelo1.getValueAt(this.xposnp, 7).toString()));
            clasesHistoriaCE.informacionAgendaMedicaDTO.setIdTipoCita(Long.valueOf(this.xmodelo1.getValueAt(this.xposnp, 13).toString()));
            clasesHistoriaCE.informacionAgendaMedicaDTO.setIdTipohc(Integer.valueOf(this.xmodelo1.getValueAt(this.xposnp, 9).toString()));
            clasesHistoriaCE.informacionAgendaMedicaDTO.setIdCita(Long.valueOf(this.xmodelo1.getValueAt(this.xposnp, 11).toString()));
            clasesHistoriaCE.informacionAgendaMedicaDTO.setEsRemitada(0);
            clasesHistoriaCE.informacionAgendaMedicaDTO.setIdClaseCita(Integer.valueOf(this.xmodelo1.getValueAt(this.xposnp, 8).toString()));
            clasesHistoriaCE.informacionAgendaMedicaDTO.setTipoTratamiento(Long.valueOf(this.xmodelo1.getValueAt(this.xposnp, 20).toString()));
            clasesHistoriaCE.informacionAgendaMedicaDTO.setEsSaludOcupacional(Integer.valueOf(this.xmodelo1.getValueAt(this.xposnp, 18).toString()));
            clasesHistoriaCE.informacionAgendaMedicaDTO.setIdTratamiento(Long.valueOf(this.xmodelo1.getValueAt(this.xposnp, 21).toString()));
            clasesHistoriaCE.informacionAgendaMedicaDTO.setEsOdontologica(Integer.valueOf(this.xmodelo1.getValueAt(this.xposnp, 22).toString()));
            clasesHistoriaCE.informacionAgendaMedicaDTO.setNombreEmpresaCovenio(this.xmodelo1.getValueAt(this.xposnp, 23).toString());
            clasesHistoriaCE.informacionAgendaMedicaDTO.setFechaNacimiento(this.xmodelo1.getValueAt(this.xposnp, 31).toString());
            clasesHistoriaCE.informacionAgendaMedicaDTO.setFechaIngreso(this.xmodelo1.getValueAt(this.xposnp, 32).toString());
            clasesHistoriaCE.informacionAgendaMedicaDTO.setEsPeriodico(Integer.valueOf(this.xmodelo1.getValueAt(this.xposnp, 26).toString()));
            clasesHistoriaCE.informacionAgendaMedicaDTO.setTipoAtencion(Integer.valueOf(this.xmodelo1.getValueAt(this.xposnp, 27).toString()));
            clasesHistoriaCE.informacionAgendaMedicaDTO.setFecha_HoraAtencion(this.xmt.formatoDMA1.format(this.JDCFechaAgenda.getDate()) + " " + this.xmodelo1.getValueAt(this.xposnp, 5).toString());
            clasesHistoriaCE.informacionAgendaMedicaDTO.setTipoCita(1);
            clasesHistoriaCE.informacionAgendaMedicaDTO.setFormaHistoria(0);
            clasesHistoriaCE.informacionAgendaMedicaDTO.setIdOrden(0L);
            clasesHistoriaCE.informacionAgendaMedicaDTO.setIdProcedimiento(0L);
            clasesHistoriaCE.informacionAgendaMedicaDTO.setIdModalidad(Integer.valueOf(this.xmodelo1.getValueAt(this.xposnp, 35).toString()));
            clasesHistoriaCE.informacionAgendaMedicaDTO.setIdEntornoAtencion(Integer.valueOf(this.xmodelo1.getValueAt(this.xposnp, 36).toString()));
            clasesHistoriaCE.informacionAgendaMedicaDTO.setIdTipoDiscapacidad(Integer.valueOf(this.xmodelo1.getValueAt(this.xposnp, 37).toString()));
            clasesHistoriaCE.informacionAgendaMedicaDTO.setIdPrograma(Integer.valueOf(this.xmodelo1.getValueAt(this.xposnp, 17).toString()));
            this.xclaseHC.mBuscarAtencionIngreso();
            this.xclaseHC.mActualizarFechaHoraIniciaAtencion();
            dispose();
            this.claseHilo.xvalor = false;
            this.claseHilo = null;
            this.xclaseHC.xjifagendan = null;
            finalize();
            if (Integer.valueOf(this.xmodelo1.getValueAt(this.xposnp, 30).toString()).intValue() == 0) {
                this.xclaseHC.cargarPantalla("Historia", this.xclaseHC.frmPrincipal, "Historia_Med");
            } else {
                this.xclaseHC.cargarPantalla("Historia_Nueva", this.xclaseHC.frmPrincipal, "Historia_Med");
            }
        } catch (Throwable ex) {
            Logger.getLogger(JIFAgendaMedico_N.class.getName()).log(Level.SEVERE, (String) null, ex);
        }
    }
}
