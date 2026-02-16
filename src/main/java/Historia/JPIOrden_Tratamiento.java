package Historia;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.CustomPopupMenuListener;
import Utilidades.LlenarCombosGenericos;
import Utilidades.Metodos;
import com.genoma.plus.controller.historia.dto.OrdenamientoMedico;
import com.genoma.plus.controller.historia.dto.OrdenamientoMedicoDetalle;
import com.genoma.plus.controller.inventario.JD_CuestionarioFarmacovigilanciaDisparadores;
import com.genoma.plus.jpa.entities.GServicioGrupoEntity;
import com.genoma.plus.jpa.entities.GServicioRipsEntity;
import com.genoma.plus.jpa.entities.HOrdenesUnidosis;
import com.genoma.plus.jpa.entities.HOrdenesUnidosisDetalle;
import com.genoma.plus.jpa.entities.HOrdenesUnidosisDetalleRespuestacuestionario;
import com.genoma.plus.jpa.entities.ISuministro;
import com.genoma.plus.jpa.entities.ISuministroTipocuestionario;
import com.genoma.plus.jpa.entities.IViaadministracion;
import com.genoma.plus.jpa.entities.SoTipoCuestionario;
import com.genoma.plus.jpa.service.IHOrdenesUnidosisDetalleRespuestacuestionarioService;
import com.genoma.plus.jpa.service.IHOrdenesUnidosisDetalleService;
import com.genoma.plus.jpa.service.ISuministroService;
import com.genoma.plus.jpa.service.ISuministroTipocuestionarioService;
import com.genoma.plus.jpa.service.IViaAdministracionService;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyVetoException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DateFormatter;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

/* JADX INFO: loaded from: GenomaP.jar:Historia/JPIOrden_Tratamiento.class */
public class JPIOrden_Tratamiento extends JPanel {
    private DefaultTableModel xmodelo;
    private DefaultTableModel xmodeloH;
    public static DefaultTableModel xmodelodetallet;
    private Object[] xdato;
    private String xsql;
    private String xidatencion;
    private String xidingreso;
    private String xidusuario;
    private String modulo;
    private int xId_TipoAtencion;
    private long xRCargo;
    private ISuministro suministro;
    public static List<HOrdenesUnidosisDetalleRespuestacuestionario> hOrdenesUnidosisDetalleRespuestacuestionario;
    public static Vector vector = new Vector();
    private List<GServicioGrupoEntity> listGrupoEntitys;
    private List<GServicioRipsEntity> ListripsEntitys;
    private List<IViaadministracion> viaadministracion;
    private int xlleno;
    public JButton JBTAdicionar;
    private JButton JBTSolicitar_SF;
    public JComboBox JCBGrupoSevicio;
    public JComboBox JCBSevicioRips;
    private JComboBox JCBViaAdministracion;
    private JCheckBox JCHEsPrincipio;
    public JDateChooser JDFecha;
    private JLabel JLBNRegistro;
    private JPanel JPIDatosA;
    private JPanel JPIHistorico;
    private JPanel JPITDatosM;
    private JPanel JPITratamiento;
    private JPanel JPI_Adicional;
    private JPanel JPI_Adicional1;
    private JScrollPane JSPDatosDetMedicamentos;
    private JScrollPane JSPDatosMedicamentos;
    private JScrollPane JSPDetalleH;
    private JScrollPane JSPObservaciones;
    private JTextArea JTAObservaciones;
    public static JTable JTDatosDetMedicamentos;
    private JTable JTDatosMedicamentos;
    private JTable JTDetalleH;
    private JTextField JTFDosis;
    private JFormattedTextField JTFFCantidad;
    private JFormattedTextField JTFFDuracion;
    public JFormattedTextField JTFFHora;
    private JTextField JTFFrecuencia;
    private JTextField JTFNombre;
    private JTabbedPane JTPDatosT;
    private JTabbedPane JTP_DatosInternos;
    private JButton jButton1;
    private ConsultasMySQL xct = new ConsultasMySQL();
    private Metodos xmt = new Metodos();
    private int xfila = 0;
    private int xtipoim = -1;
    private boolean xtipom = false;
    private final ISuministroTipocuestionarioService iSuministroTipocuestionarioService = (ISuministroTipocuestionarioService) Principal.contexto.getBean(ISuministroTipocuestionarioService.class);
    private final ISuministroService iSuministroService = (ISuministroService) Principal.contexto.getBean(ISuministroService.class);
    private final IHOrdenesUnidosisDetalleRespuestacuestionarioService iHOrdenesUnidosisDetalleRespuestacuestionarioService = (IHOrdenesUnidosisDetalleRespuestacuestionarioService) Principal.contexto.getBean(IHOrdenesUnidosisDetalleRespuestacuestionarioService.class);
    private final IHOrdenesUnidosisDetalleService iHOrdenesUnidosisDetalleService = (IHOrdenesUnidosisDetalleService) Principal.contexto.getBean(IHOrdenesUnidosisDetalleService.class);
    private final IViaAdministracionService viaAdministracionService = (IViaAdministracionService) Principal.contexto.getBean(IViaAdministracionService.class);
    public Integer idPregunta = null;
    public String cuerpoMensaje = "";
    public String nombreUsuario = "";

    public JPIOrden_Tratamiento(String xidatencion, String xidingreso, String xidusuario, int xId_Atencion, long xRCargo, String modulo) {
        this.xId_TipoAtencion = 0;
        this.xRCargo = 0L;
        initComponents();
        this.modulo = modulo;
        this.xidatencion = xidatencion;
        this.xidingreso = xidingreso;
        this.xidusuario = xidusuario;
        this.xId_TipoAtencion = xId_Atencion;
        this.xRCargo = xRCargo;
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v11, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v141, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v32, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JTPDatosT = new JTabbedPane();
        this.JPITratamiento = new JPanel();
        this.JPITDatosM = new JPanel();
        this.JTFNombre = new JTextField();
        this.JCHEsPrincipio = new JCheckBox();
        this.JSPDatosMedicamentos = new JScrollPane();
        this.JTDatosMedicamentos = new JTable();
        this.JSPDatosDetMedicamentos = new JScrollPane();
        JTDatosDetMedicamentos = new JTable();
        this.JLBNRegistro = new JLabel();
        this.JBTSolicitar_SF = new JButton();
        this.JDFecha = new JDateChooser();
        this.JTFFHora = new JFormattedTextField();
        this.JTP_DatosInternos = new JTabbedPane();
        this.JPIDatosA = new JPanel();
        this.JTFDosis = new JTextField();
        this.JTFFrecuencia = new JTextField();
        this.JTFFCantidad = new JFormattedTextField();
        this.JBTAdicionar = new JButton();
        this.JTFFDuracion = new JFormattedTextField();
        this.JCBViaAdministracion = new JComboBox();
        this.JPI_Adicional1 = new JPanel();
        this.JSPObservaciones = new JScrollPane();
        this.JTAObservaciones = new JTextArea();
        this.JPI_Adicional = new JPanel();
        this.JCBGrupoSevicio = new JComboBox();
        this.JCBSevicioRips = new JComboBox();
        this.JPIHistorico = new JPanel();
        this.JSPDetalleH = new JScrollPane();
        this.JTDetalleH = new JTable();
        this.jButton1 = new JButton();
        setName("jptratamiento_ordenes");
        this.JTPDatosT.setForeground(new Color(0, 103, 0));
        this.JTPDatosT.setAutoscrolls(true);
        this.JTPDatosT.setFont(new Font("Arial", 1, 14));
        this.JPITratamiento.setAutoscrolls(true);
        this.JPITDatosM.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS DEL MEDICAMENTO O INSUMO", 2, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.JTFNombre.setFont(new Font("Arial", 1, 12));
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Medicamento", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNombre.addKeyListener(new KeyAdapter() { // from class: Historia.JPIOrden_Tratamiento.1
            public void keyTyped(KeyEvent evt) {
                JPIOrden_Tratamiento.this.JTFNombreKeyTyped(evt);
            }

            public void keyPressed(KeyEvent evt) {
                JPIOrden_Tratamiento.this.JTFNombreKeyPressed(evt);
            }
        });
        this.JCHEsPrincipio.setFont(new Font("Arial", 1, 12));
        this.JCHEsPrincipio.setForeground(Color.blue);
        this.JCHEsPrincipio.setText("PrincipioActivo");
        this.JCHEsPrincipio.addActionListener(new ActionListener() { // from class: Historia.JPIOrden_Tratamiento.2
            public void actionPerformed(ActionEvent evt) {
                JPIOrden_Tratamiento.this.JCHEsPrincipioActionPerformed(evt);
            }
        });
        this.JSPDatosMedicamentos.setBorder(BorderFactory.createTitledBorder((Border) null, "RESULTADO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTDatosMedicamentos.setFont(new Font("Arial", 1, 12));
        this.JTDatosMedicamentos.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDatosMedicamentos.setCursor(new Cursor(0));
        this.JTDatosMedicamentos.setSelectionBackground(new Color(255, 255, 255));
        this.JTDatosMedicamentos.setSelectionForeground(Color.red);
        this.JTDatosMedicamentos.setSelectionMode(0);
        this.JTDatosMedicamentos.addFocusListener(new FocusAdapter() { // from class: Historia.JPIOrden_Tratamiento.3
            public void focusLost(FocusEvent evt) {
                JPIOrden_Tratamiento.this.JTDatosMedicamentosFocusLost(evt);
            }
        });
        this.JTDatosMedicamentos.addMouseListener(new MouseAdapter() { // from class: Historia.JPIOrden_Tratamiento.4
            public void mouseClicked(MouseEvent evt) {
                JPIOrden_Tratamiento.this.JTDatosMedicamentosMouseClicked(evt);
            }
        });
        this.JTDatosMedicamentos.addKeyListener(new KeyAdapter() { // from class: Historia.JPIOrden_Tratamiento.5
            public void keyPressed(KeyEvent evt) {
                JPIOrden_Tratamiento.this.JTDatosMedicamentosKeyPressed(evt);
            }
        });
        this.JSPDatosMedicamentos.setViewportView(this.JTDatosMedicamentos);
        GroupLayout JPITDatosMLayout = new GroupLayout(this.JPITDatosM);
        this.JPITDatosM.setLayout(JPITDatosMLayout);
        JPITDatosMLayout.setHorizontalGroup(JPITDatosMLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPITDatosMLayout.createSequentialGroup().addContainerGap().addGroup(JPITDatosMLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPITDatosMLayout.createSequentialGroup().addComponent(this.JTFNombre, -2, 649, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JCHEsPrincipio)).addComponent(this.JSPDatosMedicamentos)).addContainerGap()));
        JPITDatosMLayout.setVerticalGroup(JPITDatosMLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPITDatosMLayout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(JPITDatosMLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JCHEsPrincipio).addComponent(this.JTFNombre, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDatosMedicamentos, -2, 192, -2).addContainerGap()));
        this.JSPDatosDetMedicamentos.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        JTDatosDetMedicamentos.setFont(new Font("Arial", 1, 12));
        JTDatosDetMedicamentos.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        JTDatosDetMedicamentos.setSelectionBackground(new Color(255, 255, 255));
        JTDatosDetMedicamentos.setSelectionForeground(new Color(255, 0, 0));
        JTDatosDetMedicamentos.setSelectionMode(0);
        JTDatosDetMedicamentos.addMouseListener(new MouseAdapter() { // from class: Historia.JPIOrden_Tratamiento.6
            public void mouseClicked(MouseEvent evt) {
                JPIOrden_Tratamiento.this.JTDatosDetMedicamentosMouseClicked(evt);
            }
        });
        JTDatosDetMedicamentos.addKeyListener(new KeyAdapter() { // from class: Historia.JPIOrden_Tratamiento.7
            public void keyPressed(KeyEvent evt) {
                JPIOrden_Tratamiento.this.JTDatosDetMedicamentosKeyPressed(evt);
            }
        });
        this.JSPDatosDetMedicamentos.setViewportView(JTDatosDetMedicamentos);
        this.JLBNRegistro.setBackground(new Color(255, 255, 255));
        this.JLBNRegistro.setFont(new Font("Arial", 1, 18));
        this.JLBNRegistro.setForeground(Color.red);
        this.JLBNRegistro.setHorizontalAlignment(0);
        this.JLBNRegistro.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Registro", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBTSolicitar_SF.setFont(new Font("Arial", 1, 12));
        this.JBTSolicitar_SF.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTSolicitar_SF.setText("Solicitar Servicio Farmacéutico");
        this.JBTSolicitar_SF.addActionListener(new ActionListener() { // from class: Historia.JPIOrden_Tratamiento.8
            public void actionPerformed(ActionEvent evt) {
                JPIOrden_Tratamiento.this.JBTSolicitar_SFActionPerformed(evt);
            }
        });
        this.JDFecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFecha.setDateFormatString("dd/MM/yyyy");
        this.JDFecha.setFont(new Font("Arial", 1, 12));
        this.JDFecha.addPropertyChangeListener(new PropertyChangeListener() { // from class: Historia.JPIOrden_Tratamiento.9
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JPIOrden_Tratamiento.this.JDFechaPropertyChange(evt);
            }
        });
        this.JTFFHora.setBorder(BorderFactory.createTitledBorder((Border) null, "Hora", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFHora.setFormatterFactory(new DefaultFormatterFactory(new DateFormatter(new SimpleDateFormat("HH:mm:ss"))));
        this.JTFFHora.setFont(new Font("Tahoma", 1, 12));
        this.JTP_DatosInternos.setForeground(Color.red);
        this.JTP_DatosInternos.setFont(new Font("Arial", 1, 14));
        this.JTFDosis.setFont(new Font("Arial", 1, 13));
        this.JTFDosis.setHorizontalAlignment(0);
        this.JTFDosis.setBorder(BorderFactory.createTitledBorder((Border) null, "Dosis", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFrecuencia.setFont(new Font("Arial", 1, 13));
        this.JTFFrecuencia.setHorizontalAlignment(0);
        this.JTFFrecuencia.setBorder(BorderFactory.createTitledBorder((Border) null, "Frecuencia", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFCantidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Cant.", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFCantidad.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.JTFFCantidad.setHorizontalAlignment(0);
        this.JTFFCantidad.setFont(new Font("Arial", 1, 13));
        this.JBTAdicionar.setFont(new Font("Arial", 1, 12));
        this.JBTAdicionar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTAdicionar.setText("Adicionar");
        this.JBTAdicionar.addActionListener(new ActionListener() { // from class: Historia.JPIOrden_Tratamiento.10
            public void actionPerformed(ActionEvent evt) {
                JPIOrden_Tratamiento.this.JBTAdicionarActionPerformed(evt);
            }
        });
        this.JBTAdicionar.addKeyListener(new KeyAdapter() { // from class: Historia.JPIOrden_Tratamiento.11
            public void keyPressed(KeyEvent evt) {
                JPIOrden_Tratamiento.this.JBTAdicionarKeyPressed(evt);
            }
        });
        this.JTFFDuracion.setBorder(BorderFactory.createTitledBorder((Border) null, "Duración", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFDuracion.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.JTFFDuracion.setHorizontalAlignment(0);
        this.JTFFDuracion.setFont(new Font("Arial", 1, 13));
        this.JCBViaAdministracion.setFont(new Font("Arial", 1, 12));
        this.JCBViaAdministracion.setBorder(BorderFactory.createTitledBorder((Border) null, "Vía Administración", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPIDatosALayout = new GroupLayout(this.JPIDatosA);
        this.JPIDatosA.setLayout(JPIDatosALayout);
        JPIDatosALayout.setHorizontalGroup(JPIDatosALayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosALayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosALayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JBTAdicionar, -1, -1, 32767).addGroup(JPIDatosALayout.createSequentialGroup().addComponent(this.JTFDosis, -2, 137, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFFrecuencia, -1, 200, 32767).addGap(18, 18, 18).addComponent(this.JCBViaAdministracion, -2, 165, -2).addGap(29, 29, 29).addComponent(this.JTFFDuracion, -2, 75, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFFCantidad, -2, 75, -2).addGap(75, 75, 75))).addContainerGap()));
        JPIDatosALayout.setVerticalGroup(JPIDatosALayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosALayout.createSequentialGroup().addGroup(JPIDatosALayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFDosis, -2, 50, -2).addComponent(this.JTFFrecuencia, -2, 50, -2).addComponent(this.JTFFCantidad, -2, 50, -2).addComponent(this.JTFFDuracion, -2, 50, -2).addComponent(this.JCBViaAdministracion, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTAdicionar).addContainerGap(-1, 32767)));
        this.JTP_DatosInternos.addTab("FORMA DE ADMINISTRACIÓN", this.JPIDatosA);
        this.JSPObservaciones.setBorder(BorderFactory.createTitledBorder((Border) null, "Observaciones/Justificacion", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTAObservaciones.setColumns(1);
        this.JTAObservaciones.setFont(new Font("Arial", 1, 12));
        this.JTAObservaciones.setRows(1);
        this.JTAObservaciones.addKeyListener(new KeyAdapter() { // from class: Historia.JPIOrden_Tratamiento.12
            public void keyPressed(KeyEvent evt) {
                JPIOrden_Tratamiento.this.JTAObservacionesKeyPressed(evt);
            }
        });
        this.JSPObservaciones.setViewportView(this.JTAObservaciones);
        GroupLayout JPI_Adicional1Layout = new GroupLayout(this.JPI_Adicional1);
        this.JPI_Adicional1.setLayout(JPI_Adicional1Layout);
        JPI_Adicional1Layout.setHorizontalGroup(JPI_Adicional1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 810, 32767).addGroup(JPI_Adicional1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_Adicional1Layout.createSequentialGroup().addContainerGap().addComponent(this.JSPObservaciones, -1, 798, 32767).addContainerGap())));
        JPI_Adicional1Layout.setVerticalGroup(JPI_Adicional1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 99, 32767).addGroup(JPI_Adicional1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_Adicional1Layout.createSequentialGroup().addContainerGap().addComponent(this.JSPObservaciones, -2, 68, -2).addContainerGap(-1, 32767))));
        this.JTP_DatosInternos.addTab("ADICIONAL", this.JPI_Adicional1);
        this.JCBGrupoSevicio.setFont(new Font("Arial", 1, 12));
        this.JCBGrupoSevicio.setBorder(BorderFactory.createTitledBorder((Border) null, "Grupo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBGrupoSevicio.setName("grupoServicio");
        this.JCBGrupoSevicio.addItemListener(new ItemListener() { // from class: Historia.JPIOrden_Tratamiento.13
            public void itemStateChanged(ItemEvent evt) {
                JPIOrden_Tratamiento.this.JCBGrupoSevicioItemStateChanged(evt);
            }
        });
        this.JCBSevicioRips.setFont(new Font("Arial", 1, 12));
        this.JCBSevicioRips.setBorder(BorderFactory.createTitledBorder((Border) null, "Servicio Rips", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBSevicioRips.setName("servicioRips");
        GroupLayout JPI_AdicionalLayout = new GroupLayout(this.JPI_Adicional);
        this.JPI_Adicional.setLayout(JPI_AdicionalLayout);
        JPI_AdicionalLayout.setHorizontalGroup(JPI_AdicionalLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_AdicionalLayout.createSequentialGroup().addContainerGap().addComponent(this.JCBGrupoSevicio, -2, 279, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBSevicioRips, 0, -1, 32767).addGap(30, 30, 30)));
        JPI_AdicionalLayout.setVerticalGroup(JPI_AdicionalLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_AdicionalLayout.createSequentialGroup().addContainerGap().addGroup(JPI_AdicionalLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBGrupoSevicio, -2, -1, -2).addComponent(this.JCBSevicioRips, -2, -1, -2)).addContainerGap(-1, 32767)));
        this.JTP_DatosInternos.addTab("ADICIONAL1", this.JPI_Adicional);
        GroupLayout JPITratamientoLayout = new GroupLayout(this.JPITratamiento);
        this.JPITratamiento.setLayout(JPITratamientoLayout);
        JPITratamientoLayout.setHorizontalGroup(JPITratamientoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPITratamientoLayout.createSequentialGroup().addGroup(JPITratamientoLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSPDatosDetMedicamentos).addGroup(JPITratamientoLayout.createSequentialGroup().addContainerGap().addGroup(JPITratamientoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPITDatosM, -1, -1, 32767).addGroup(JPITratamientoLayout.createSequentialGroup().addComponent(this.JDFecha, -2, 117, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFHora, -2, 90, -2).addGap(119, 119, 119).addComponent(this.JLBNRegistro, -2, 124, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTSolicitar_SF, -2, 348, -2).addGap(0, 0, 32767)).addComponent(this.JTP_DatosInternos, -2, 0, 32767)))).addContainerGap()));
        JPITratamientoLayout.setVerticalGroup(JPITratamientoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPITratamientoLayout.createSequentialGroup().addComponent(this.JPITDatosM, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTP_DatosInternos, -2, 130, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDatosDetMedicamentos, -2, 143, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPITratamientoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JLBNRegistro, -1, -1, 32767).addComponent(this.JBTSolicitar_SF, -1, -1, 32767).addComponent(this.JDFecha, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addComponent(this.JTFFHora)).addContainerGap(-1, 32767)));
        this.JTPDatosT.addTab("TRATAMIENTO", this.JPITratamiento);
        this.JSPDetalleH.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.JTDetalleH.setFont(new Font("Arial", 1, 12));
        this.JTDetalleH.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalleH.setCursor(new Cursor(0));
        this.JTDetalleH.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalleH.setSelectionForeground(Color.red);
        this.JTDetalleH.setSelectionMode(0);
        this.JTDetalleH.addFocusListener(new FocusAdapter() { // from class: Historia.JPIOrden_Tratamiento.14
            public void focusLost(FocusEvent evt) {
                JPIOrden_Tratamiento.this.JTDetalleHFocusLost(evt);
            }
        });
        this.JTDetalleH.addMouseListener(new MouseAdapter() { // from class: Historia.JPIOrden_Tratamiento.15
            public void mouseClicked(MouseEvent evt) {
                JPIOrden_Tratamiento.this.JTDetalleHMouseClicked(evt);
            }
        });
        this.JTDetalleH.addKeyListener(new KeyAdapter() { // from class: Historia.JPIOrden_Tratamiento.16
            public void keyPressed(KeyEvent evt) {
                JPIOrden_Tratamiento.this.JTDetalleHKeyPressed(evt);
            }
        });
        this.JSPDetalleH.setViewportView(this.JTDetalleH);
        this.jButton1.setFont(new Font("Arial", 1, 12));
        this.jButton1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Autorizacion.png")));
        this.jButton1.setText("Traslado Agrupado");
        this.jButton1.addActionListener(new ActionListener() { // from class: Historia.JPIOrden_Tratamiento.17
            public void actionPerformed(ActionEvent evt) {
                JPIOrden_Tratamiento.this.jButton1ActionPerformed(evt);
            }
        });
        GroupLayout JPIHistoricoLayout = new GroupLayout(this.JPIHistorico);
        this.JPIHistorico.setLayout(JPIHistoricoLayout);
        JPIHistoricoLayout.setHorizontalGroup(JPIHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIHistoricoLayout.createSequentialGroup().addContainerGap().addGroup(JPIHistoricoLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jButton1, -2, 804, -2).addComponent(this.JSPDetalleH, -2, 806, -2)).addContainerGap()));
        JPIHistoricoLayout.setVerticalGroup(JPIHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIHistoricoLayout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.JSPDetalleH, -2, 457, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jButton1, -2, 50, -2).addGap(20, 20, 20)));
        this.JTPDatosT.addTab("HISTÓRICO", (Icon) null, this.JPIHistorico, "");
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTPDatosT).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTPDatosT).addContainerGap()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNombreKeyPressed(KeyEvent evt) {
        if (!this.JTFNombre.getText().isEmpty()) {
            mLLenartabla();
        } else {
            mCrearTablaMedicamentos();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNombreKeyTyped(KeyEvent evt) {
        if (!this.JTFNombre.getText().isEmpty()) {
            mLLenartabla();
        } else {
            mCrearTablaMedicamentos();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEsPrincipioActionPerformed(ActionEvent evt) {
        if (this.JCHEsPrincipio.isSelected()) {
            if (!this.JTFNombre.getText().isEmpty()) {
                mCrearTablaMedicamentos();
                mLLenartabla();
                return;
            } else {
                mCrearTablaMedicamentos();
                return;
            }
        }
        if (!this.JTFNombre.getText().isEmpty()) {
            mCrearTablaMedicamentos();
            mLLenartabla();
        } else {
            mCrearTablaMedicamentos();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDatosMedicamentosFocusLost(FocusEvent evt) {
        if (this.JTDatosMedicamentos.getSelectedRow() != -1) {
            mValidarMedicamentos();
            mValidarInteracionMed();
            mVerificarFVencimientoInvima();
            mVerificarNovedadP();
            mVerificarMedicamentoControl();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDatosMedicamentosKeyPressed(KeyEvent evt) {
        if (this.JTDatosMedicamentos.getSelectedRow() != -1 && evt.getKeyCode() == 9) {
            this.JTDatosMedicamentos.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDatosDetMedicamentosKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 127 && JTDatosDetMedicamentos.getRowCount() != 0 && JTDatosDetMedicamentos.getSelectedRow() != -1 && this.JLBNRegistro.getText().isEmpty()) {
            xmodelodetallet.removeRow(JTDatosDetMedicamentos.getSelectedRow());
            this.xfila--;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTAObservacionesKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 9) {
            this.JTAObservaciones.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTAdicionarActionPerformed(ActionEvent evt) {
        if (this.xtipom) {
            if (this.xtipoim == -1) {
                mAdicionar();
                return;
            }
            if (this.xtipoim == 0 || this.xtipoim == 1 || this.xtipoim == 2) {
                if (!this.JTAObservaciones.getText().isEmpty()) {
                    mAdicionar();
                    consultarCuestionarioSuministro();
                    return;
                } else {
                    JOptionPane.showMessageDialog((Component) null, "Medicamento no se puede agregar;\nDebe agregar justificación;\nAlerta Activa", "ALERTA DE SEGURIDAD CLÍNICA", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                    this.JTAObservaciones.requestFocus();
                    return;
                }
            }
            return;
        }
        mAdicionar();
        consultarCuestionarioSuministro();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTAdicionarKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            mAdicionar();
            mLimpiar();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleHFocusLost(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleHKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleHMouseClicked(MouseEvent evt) {
        if (this.JTDetalleH.getSelectedRow() != -1 && evt.getClickCount() == 2) {
            Object[] botones = {"Imprimir", "Cargar", "Transladar Items", "Cerrar"};
            int n = JOptionPane.showInternalOptionDialog(this, "Que desea realizar", "VISUALIZAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones, "Cerrar");
            switch (n) {
                case 0:
                    this.JLBNRegistro.setText(this.xmodeloH.getValueAt(this.JTDetalleH.getSelectedRow(), 0).toString());
                    mImprimir();
                    break;
                case 1:
                    mBuscarSuministro(this.xmodeloH.getValueAt(this.JTDetalleH.getSelectedRow(), 0).toString(), true);
                    break;
                case 2:
                    mBuscarSuministro(this.xmodeloH.getValueAt(this.JTDetalleH.getSelectedRow(), 0).toString(), false);
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTSolicitar_SFActionPerformed(ActionEvent evt) {
        if (!this.JLBNRegistro.getText().isEmpty()) {
            int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de solicitar unidosis?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                this.xsql = "update h_ordenes_unidosis set Solicitado=1, Fecha_S='" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "' where Id='" + this.JLBNRegistro.getText() + "'";
                this.xct.ejecutarSQL(this.xsql);
                this.xct.cerrarConexionBd();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jButton1ActionPerformed(ActionEvent evt) {
        if (this.JTDetalleH.getRowCount() > 0) {
            String Ordenes = "";
            for (int i = 0; i < this.JTDetalleH.getRowCount(); i++) {
                if (Boolean.valueOf(this.xmodeloH.getValueAt(i, 7).toString()).booleanValue()) {
                    Ordenes = Ordenes + this.xmodeloH.getValueAt(i, 0).toString() + ",";
                }
            }
            if (!Ordenes.isEmpty()) {
                mBuscarSuministro(Ordenes.substring(0, Ordenes.length() - 1), false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaPropertyChange(PropertyChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDatosDetMedicamentosMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBGrupoSevicioItemStateChanged(ItemEvent evt) {
        if (this.xlleno == 1 && this.JCBGrupoSevicio.getSelectedIndex() != -1) {
            this.JCBSevicioRips.removeAllItems();
            this.ListripsEntitys = new ArrayList();
            LlenarCombosGenericos<GServicioRipsEntity> combosGenericos = new LlenarCombosGenericos<>();
            this.ListripsEntitys = combosGenericos.getListComboLlenoParametro(this.JCBSevicioRips.getName(), this.listGrupoEntitys.get(this.JCBGrupoSevicio.getSelectedIndex()));
            this.ListripsEntitys.forEach(e -> {
                this.JCBSevicioRips.addItem(e.getNombre());
            });
            this.JCBSevicioRips.addPopupMenuListener(new CustomPopupMenuListener(true, false));
            if (!this.listGrupoEntitys.isEmpty()) {
                this.JCBSevicioRips.setSelectedItem("SERVICIO FARMACEUTICO");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDatosMedicamentosMouseClicked(MouseEvent evt) {
        if (this.JTDatosMedicamentos.getSelectedRow() != -1) {
            this.JCBViaAdministracion.setSelectedItem(this.JTDatosMedicamentos.getValueAt(this.JTDatosMedicamentos.getSelectedRow(), 12).toString());
        }
    }

    public void mBuscarSuministro(String id, boolean xforma) {
        String sql;
        try {
            if (Principal.informacionIps.getNombreIps().equals("CLINICA PAJONAL S.A.S") || Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JUAN DE DIOS") || Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JORGE DE AYAPEL") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO CAMU CHIMA")) {
                sql = "SELECT\n    `i_suministro`.`Id` AS `idProducto`\n    , UPPER(CONCAT(IF(i_principioactivo.`Nbre`='NO APLICA',i_suministro.`Nbre`,i_principioactivo.`Nbre`),' ', IF(i_concentracion.`Nbre`='NO APLICA' OR i_concentracion.`Nbre`='-','',i_concentracion.`Nbre`) ,' ', IF(i_presentacionfarmaceutica.`Nbre`='NO APLICA','', i_presentacionfarmaceutica.`Nbre`))) AS `nombreSuministro`\n    , `h_ordenes_unidosis_detalle`.`Dosis`\n    , `h_ordenes_unidosis_detalle`.`Frecuencia`\n    , `h_ordenes_unidosis_detalle`.`Cantidad`\n    , `h_ordenes_unidosis_detalle`.`Observacion`, h_ordenes_unidosis.`Id`\n, ggs.id idGrupo, ggs.nombre nombreGrupo, gsr.id idServicioRips, gsr.nombre nombreServicioRips, h_ordenes_unidosis_detalle.DuracionD, iv.Id as idVia, iv.Nbre as viaAdministracion FROM\n     `h_ordenes_unidosis_detalle`\n    INNER JOIN  `h_ordenes_unidosis` \n        ON (`h_ordenes_unidosis_detalle`.`Id_Ordenes` = `h_ordenes_unidosis`.`Id`)\n    INNER JOIN  `i_suministro` \n        ON (`h_ordenes_unidosis_detalle`.`Id_Suministro` = `i_suministro`.`Id`)\n    INNER JOIN  `i_presentacionfarmaceutica` \n        ON (`i_suministro`.`IdPresentacionFarmaceutica` = `i_presentacionfarmaceutica`.`Id`)\n    INNER JOIN  `i_concentracion` \n        ON (`i_suministro`.`IdConcentracion` = `i_concentracion`.`Id`)\n    INNER JOIN `i_principioactivo`\n        ON (i_principioactivo.`Id`=`i_suministro`.`IdPrincipioActivo`)\ninner join g_servicios_rips gsr on (gsr.id=h_ordenes_unidosis_detalle.idServicioRips)\ninner join g_grupo_servicio ggs on (ggs.id=gsr.idGrupoServicio) inner join i_viaadministracion iv on (iv.Id=h_ordenes_unidosis_detalle.IdViaAdministracion) \nWHERE (`h_ordenes_unidosis`.`Id` IN (" + id + "))\nORDER BY `nombreSuministro` ASC";
            } else {
                sql = "SELECT\n    `i_suministro`.`Id` AS `idProducto`\n    , i_suministro.Nbre AS `nombreSuministro`\n    , `h_ordenes_unidosis_detalle`.`Dosis`\n    , `h_ordenes_unidosis_detalle`.`Frecuencia`\n    , `h_ordenes_unidosis_detalle`.`Cantidad`\n    , `h_ordenes_unidosis_detalle`.`Observacion`, h_ordenes_unidosis.`Id`\n, ggs.id idGrupo, ggs.nombre nombreGrupo, gsr.id idServicioRips, gsr.nombre nombreServicioRips, h_ordenes_unidosis_detalle.DuracionD, iv.Id as idVia, iv.Nbre as viaAdministracion FROM\n     `h_ordenes_unidosis_detalle`\n    INNER JOIN  `h_ordenes_unidosis` \n        ON (`h_ordenes_unidosis_detalle`.`Id_Ordenes` = `h_ordenes_unidosis`.`Id`)\n    INNER JOIN  `i_suministro` \n        ON (`h_ordenes_unidosis_detalle`.`Id_Suministro` = `i_suministro`.`Id`)\n    INNER JOIN  `i_presentacionfarmaceutica` \n        ON (`i_suministro`.`IdPresentacionFarmaceutica` = `i_presentacionfarmaceutica`.`Id`)\n    INNER JOIN  `i_concentracion` \n        ON (`i_suministro`.`IdConcentracion` = `i_concentracion`.`Id`)\n    INNER JOIN `i_principioactivo`\n        ON (i_principioactivo.`Id`=`i_suministro`.`IdPrincipioActivo`)\ninner join g_servicios_rips gsr on (gsr.id=h_ordenes_unidosis_detalle.idServicioRips) \ninner join g_grupo_servicio ggs on (ggs.id=gsr.idGrupoServicio) inner join i_viaadministracion iv on (iv.Id=h_ordenes_unidosis_detalle.IdViaAdministracion)\nWHERE (`h_ordenes_unidosis`.`Id` IN (" + id + "))\nORDER BY `nombreSuministro` ASC";
            }
            mNuevo();
            ResultSet rs = this.xct.traerRs(sql);
            Throwable th = null;
            try {
                try {
                    if (rs.next()) {
                        this.xfila = 0;
                        rs.first();
                        if (xforma) {
                            this.JLBNRegistro.setText(rs.getString("Id"));
                        } else {
                            this.JLBNRegistro.setText("");
                        }
                        rs.beforeFirst();
                        while (rs.next()) {
                            xmodelodetallet.addRow(this.xdato);
                            xmodelodetallet.setValueAt(Long.valueOf(rs.getLong("idProducto")), this.xfila, 0);
                            xmodelodetallet.setValueAt(rs.getString("nombreSuministro"), this.xfila, 1);
                            xmodelodetallet.setValueAt(rs.getString("Dosis"), this.xfila, 2);
                            xmodelodetallet.setValueAt(rs.getString("Frecuencia"), this.xfila, 3);
                            xmodelodetallet.setValueAt(Long.valueOf(rs.getLong("Cantidad")), this.xfila, 4);
                            xmodelodetallet.setValueAt(rs.getString("Observacion"), this.xfila, 5);
                            xmodelodetallet.setValueAt(rs.getString("idGrupo"), this.xfila, 7);
                            xmodelodetallet.setValueAt(rs.getString("nombreGrupo"), this.xfila, 8);
                            xmodelodetallet.setValueAt(rs.getString("idServicioRips"), this.xfila, 9);
                            xmodelodetallet.setValueAt(rs.getString("nombreServicioRips"), this.xfila, 10);
                            xmodelodetallet.setValueAt(Integer.valueOf(rs.getInt("DuracionD")), this.xfila, 11);
                            xmodelodetallet.setValueAt(rs.getString("idVia"), this.xfila, 12);
                            xmodelodetallet.setValueAt(rs.getString("viaAdministracion"), this.xfila, 13);
                            this.xfila++;
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
                    this.xct.cerrarConexionBd();
                    this.JTPDatosT.setSelectedIndex(0);
                } finally {
                }
            } catch (Throwable th3) {
                th = th3;
                throw th3;
            }
        } catch (SQLException e) {
        }
    }

    private void consultarCuestionarioSuministro() {
        if (this.JTDatosMedicamentos.getSelectedRow() != -1) {
            List<ISuministroTipocuestionario> suministroTipocuestionarios = this.iSuministroTipocuestionarioService.listaCuestionarioPorSuministroEstado(this.suministro, true);
            if (!suministroTipocuestionarios.isEmpty()) {
                SoTipoCuestionario cuestionario = suministroTipocuestionarios.get(0).getIdTipoCuestionario();
                JD_CuestionarioFarmacovigilanciaDisparadores disparadores = new JD_CuestionarioFarmacovigilanciaDisparadores(null, true, cuestionario, "pantallaTratamiento");
                disparadores.setLocationRelativeTo(this);
                disparadores.setVisible(true);
            }
        }
    }

    private void mValidarMedicamentos() {
        String sql;
        if (this.JTDatosMedicamentos.getSelectedRow() != -1) {
            try {
                ConsultasMySQL xmt = new ConsultasMySQL();
                if (Principal.informacionIps.getNombreIps().equals("CLINICA PAJONAL S.A.S") || Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JUAN DE DIOS") || Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JORGE DE AYAPEL") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO CAMU CHIMA")) {
                    sql = "SELECT DATE_FORMAT(h_ordenes.FechaOrden,'%d/%m/%Y'), UPPER(CONCAT(IF(i_principioactivo.`Nbre`='NO APLICA',i_suministro.`Nbre`,i_principioactivo.`Nbre`),' ', IF(i_concentracion.`Nbre`='NO APLICA' OR i_concentracion.`Nbre`='-','',i_concentracion.`Nbre`) ,' ', IF(i_presentacionfarmaceutica.`Nbre`='NO APLICA','', i_presentacionfarmaceutica.`Nbre`))) as NSuministro  , h_itemordenessum.PosologiaManual, h_itemordenessum.Duracion, h_itemordenessum.Cantidad, profesional.NProfesional, h_tipoformula.Nbre,DATEDIFF(h_ordenes.FechaOrden,NOW())+h_itemordenessum.Duracion AS DURACION FROM h_ordenes INNER JOIN h_atencion ON (h_ordenes.Id_Atencion = h_atencion.Id) INNER JOIN ingreso  ON (h_atencion.Id_Ingreso = ingreso.Id) INNER JOIN g_profesional  ON (h_atencion.Id_Profesional = g_profesional.Id_Persona) INNER JOIN h_tipoformula  ON (h_tipoformula.Id = h_ordenes.IdTipoFormula) INNER JOIN profesional  ON (profesional.Id_Persona = g_profesional.Id_Persona) INNER JOIN h_itemordenessum  ON (h_itemordenessum.Id_HOrdenes = h_ordenes.Id) INNER JOIN i_suministro  ON (h_itemordenessum.Id_Suministro = i_suministro.Id) INNER JOIN i_principioactivo  ON (i_suministro.IdPrincipioActivo = i_principioactivo.Id) INNER JOIN i_presentacionfarmaceutica  ON (i_suministro.IdPresentacionFarmaceutica = i_presentacionfarmaceutica.Id) INNER JOIN i_presentacioncomercial  ON (i_suministro.IdPresentacionComercial = i_presentacioncomercial.Id) INNER JOIN i_concentracion  ON (i_suministro.IdConcentracion = i_concentracion.Id) WHERE (h_ordenes.Estado =0 AND i_principioactivo.Id ='" + this.JTDatosMedicamentos.getValueAt(this.JTDatosMedicamentos.getSelectedRow(), 0) + "' AND ingreso.Id_Usuario ='" + this.xidusuario + "' AND (DATEDIFF(h_ordenes.FechaOrden,NOW())+h_itemordenessum.Duracion)>0) ORDER BY h_ordenes.FechaOrden DESC ";
                } else {
                    sql = "SELECT DATE_FORMAT(h_ordenes.FechaOrden,'%d/%m/%Y'), concat(i_suministro.Nbre,' ',i_presentacionfarmaceutica.Nbre,' ',i_concentracion.Nbre,' ',i_presentacioncomercial.Nbre)as NSuministro  , h_itemordenessum.PosologiaManual, h_itemordenessum.Duracion, h_itemordenessum.Cantidad, profesional.NProfesional, h_tipoformula.Nbre,DATEDIFF(h_ordenes.FechaOrden,NOW())+h_itemordenessum.Duracion AS DURACION FROM h_ordenes INNER JOIN h_atencion ON (h_ordenes.Id_Atencion = h_atencion.Id) INNER JOIN ingreso  ON (h_atencion.Id_Ingreso = ingreso.Id) INNER JOIN g_profesional  ON (h_atencion.Id_Profesional = g_profesional.Id_Persona) INNER JOIN h_tipoformula  ON (h_tipoformula.Id = h_ordenes.IdTipoFormula) INNER JOIN profesional  ON (profesional.Id_Persona = g_profesional.Id_Persona) INNER JOIN h_itemordenessum  ON (h_itemordenessum.Id_HOrdenes = h_ordenes.Id) INNER JOIN i_suministro  ON (h_itemordenessum.Id_Suministro = i_suministro.Id) INNER JOIN i_principioactivo  ON (i_suministro.IdPrincipioActivo = i_principioactivo.Id) INNER JOIN i_presentacionfarmaceutica  ON (i_suministro.IdPresentacionFarmaceutica = i_presentacionfarmaceutica.Id) INNER JOIN i_presentacioncomercial  ON (i_suministro.IdPresentacionComercial = i_presentacioncomercial.Id) INNER JOIN i_concentracion  ON (i_suministro.IdConcentracion = i_concentracion.Id) WHERE (h_ordenes.Estado =0 AND i_principioactivo.Id ='" + this.JTDatosMedicamentos.getValueAt(this.JTDatosMedicamentos.getSelectedRow(), 0) + "' AND ingreso.Id_Usuario ='" + this.xidusuario + "' AND (DATEDIFF(h_ordenes.FechaOrden,NOW())+h_itemordenessum.Duracion)>0) ORDER BY h_ordenes.FechaOrden DESC ";
                }
                ResultSet rs = xmt.traerRs(sql);
                if (rs.next()) {
                    try {
                        Component jIFConsultarMedicamentosActivos = new JIFConsultarMedicamentosActivos(sql, 0, "Historia");
                        Principal.PanelPpal.add(jIFConsultarMedicamentosActivos, JLayeredPane.DEFAULT_LAYER);
                        jIFConsultarMedicamentosActivos.setVisible(true);
                        jIFConsultarMedicamentosActivos.setSelected(true);
                    } catch (PropertyVetoException e) {
                    }
                }
                rs.close();
                xmt.cerrarConexionBd();
                String str = "SELECT g_novedadsuministro.Id, g_tiponovedad.Nbre, g_tiponovedad.tipo, g_novedadsuministro.Documento FROM g_novedadsuministro INNER JOIN g_tiponovedad  ON (g_novedadsuministro.Id_TipoNovedad = g_tiponovedad.Id) WHERE (g_novedadsuministro.Id_Suministro ='" + this.JTDatosMedicamentos.getValueAt(this.JTDatosMedicamentos.getSelectedRow(), 2) + "' AND g_novedadsuministro.Estado =0) ";
            } catch (SQLException e2) {
                e2.getMessage();
            }
        }
    }

    private void mVerificarFVencimientoInvima() {
        if (Integer.valueOf(this.xmodelo.getValueAt(this.JTDatosMedicamentos.getSelectedRow(), 8).toString()).intValue() == 0) {
            JOptionPane.showInternalMessageDialog(this, "Medicamento con fecha: " + this.xmodelo.getValueAt(this.JTDatosMedicamentos.getSelectedRow(), 9).toString() + " de invima vencido.\nFavor revisar", "VERIFICACIÓN DE VENCIMIENTO INVIMA", 2, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Warning.png"))));
        }
    }

    private void mVerificarNovedadP() {
        String sql = "SELECT g_tiponovedad.Nbre, i_novedad_suministro.Soporte, i_novedad_suministro.Documento  FROM i_novedad_suministro INNER JOIN g_tiponovedad  ON (i_novedad_suministro.Id_TipoNovedad = g_tiponovedad.Id) WHERE (i_novedad_suministro.Estado =1 AND i_novedad_suministro.Id_Suministro ='" + this.xmodelo.getValueAt(this.JTDatosMedicamentos.getSelectedRow(), 2) + "') ";
        ConsultasMySQL xct = new ConsultasMySQL();
        ResultSet xrs = xct.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.first();
                if (xrs.getBoolean(2)) {
                    int x = JOptionPane.showInternalConfirmDialog(this, "Producto con novedad registrada;\nTIPO : " + xrs.getString(1) + "\ndesea visualizarla?", "NOVEDADES", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    if (x == 0) {
                        this.xmt.mostrarPdf(xrs.getString(3));
                    }
                } else {
                    JOptionPane.showInternalMessageDialog(this, "Producto con novedad registrada;\nTIPO : " + xrs.getString(1), "NOVEDADES", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                }
            }
            xrs.close();
            xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPIOrden_Tratamiento.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mValidarInteracionMed() {
        try {
            String str = "SELECT h_interaciones_pactivo.Id_PrincipioA1, h_interaciones_pactivo.Id_PrincipioA2, i_principioactivo.Nbre, h_interaciones_pactivo.Mensaje FROM h_interaciones_pactivo INNER JOIN i_principioactivo  ON (h_interaciones_pactivo.Id_PrincipioA2 = i_principioactivo.Id) WHERE (h_interaciones_pactivo.Estado =1 AND h_interaciones_pactivo.Id_PrincipioA1 ='" + this.JTDatosMedicamentos.getValueAt(this.JTDatosMedicamentos.getSelectedRow(), 0) + "') ";
            for (int x = 0; x < JTDatosDetMedicamentos.getRowCount(); x++) {
                System.out.println("JPIOrden_Tratamiento.JTDatosDetMedicamentos.getValueAt(x, 9).toString()" + JTDatosDetMedicamentos.getValueAt(x, 6).toString());
                String sql = "SELECT h_interaciones_pactivo.Id_PrincipioA1, h_interaciones_pactivo.Id_PrincipioA2, i_principioactivo.Nbre, h_interaciones_pactivo.Mensaje, h_interaciones_pactivo.Tipo FROM h_interaciones_pactivo INNER JOIN i_principioactivo  ON (h_interaciones_pactivo.Id_PrincipioA2 = i_principioactivo.Id) WHERE (h_interaciones_pactivo.Estado =1 AND h_interaciones_pactivo.Id_PrincipioA1 ='" + this.JTDatosMedicamentos.getValueAt(this.JTDatosMedicamentos.getSelectedRow(), 0) + "'AND h_interaciones_pactivo.Id_PrincipioA2 ='" + JTDatosDetMedicamentos.getValueAt(x, 6).toString() + "') ";
                ResultSet xrs = this.xct.traerRs(sql);
                System.out.println(sql);
                if (xrs.next()) {
                    this.xtipom = true;
                    this.xtipoim = xrs.getInt(5);
                    JOptionPane.showMessageDialog((Component) null, xrs.getString(4) + "\nPrincipio Activo : " + xrs.getString(3), "ALERTA DE SEGURIDAD CLÍNICA", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                }
                xrs.close();
                this.xct.cerrarConexionBd();
                ResultSet xrs2 = this.xct.traerRs("SELECT h_interaciones_pactivo.Id_PrincipioA1, h_interaciones_pactivo.Id_PrincipioA2, i_principioactivo.Nbre, h_interaciones_pactivo.Mensaje, h_interaciones_pactivo.Tipo FROM h_interaciones_pactivo INNER JOIN i_principioactivo  ON (h_interaciones_pactivo.Id_PrincipioA2 = i_principioactivo.Id) WHERE (h_interaciones_pactivo.Estado =1 AND h_interaciones_pactivo.Id_PrincipioA2 ='" + this.JTDatosMedicamentos.getValueAt(this.JTDatosMedicamentos.getSelectedRow(), 0) + "'AND h_interaciones_pactivo.Id_PrincipioA1 ='" + JTDatosDetMedicamentos.getValueAt(x, 9).toString() + "') ");
                if (xrs2.next()) {
                    this.xtipoim = xrs2.getInt(5);
                    this.xtipom = true;
                    JOptionPane.showMessageDialog((Component) null, xrs2.getString(4) + "\nPrincipio Activo : " + xrs2.getString(3), "ALERTA DE SEGURIDAD CLÍNICA", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                }
                xrs2.close();
                this.xct.cerrarConexionBd();
            }
        } catch (SQLException ex) {
            Logger.getLogger(JPIOrden_Tratamiento.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mNuevo() {
        this.xlleno = 1;
        this.JCBSevicioRips.removeAllItems();
        this.JCBViaAdministracion.removeAllItems();
        hOrdenesUnidosisDetalleRespuestacuestionario = new ArrayList();
        this.JLBNRegistro.setText("");
        this.JDFecha.setDate(this.xmt.getFechaActual());
        this.JTFFHora.setText(this.xmt.formatoH24.format(this.xmt.getFechaActual()));
        mCrearTablaMedicamentos();
        mCrearTablaDetalleMedicamentos();
        mCargarDatosH();
        mLimpiar();
        this.JCBGrupoSevicio.removeAllItems();
        LlenarCombosGenericos<GServicioGrupoEntity> combosGenericos = new LlenarCombosGenericos<>();
        this.listGrupoEntitys = combosGenericos.getListComboLleno(this.JCBGrupoSevicio.getName());
        this.listGrupoEntitys.forEach(e -> {
            this.JCBGrupoSevicio.addItem(e.getNombre());
        });
        this.xlleno = 1;
        this.viaadministracion = this.viaAdministracionService.getListAllOrderByNbre(false);
        this.viaadministracion.forEach(e2 -> {
            this.JCBViaAdministracion.addItem(e2.getNbre());
        });
        if (!this.listGrupoEntitys.isEmpty()) {
            this.JCBGrupoSevicio.setSelectedItem("Apoyo diagnóstico y complementación  terapéutica");
            this.JCBGrupoSevicio.addPopupMenuListener(new CustomPopupMenuListener(true, false));
        }
        this.JTFNombre.requestFocus();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTablaMedicamentos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"IdPactivo", "Nombre Pricipio Activo", "IdProducto", "Producto", "Presentación", "Cantidad", "Valor", "", "Vencido", "FechaV", "CInventario", "Tipo", "Via"}) { // from class: Historia.JPIOrden_Tratamiento.18
            Class[] types = {Integer.class, String.class, Integer.class, String.class, String.class, Integer.class, Integer.class, String.class, Integer.class, String.class, Boolean.class, Integer.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDatosMedicamentos.setModel(this.xmodelo);
        this.JTDatosMedicamentos.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTDatosMedicamentos.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTDatosMedicamentos.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTDatosMedicamentos.getColumnModel().getColumn(1).setPreferredWidth(200);
        this.JTDatosMedicamentos.getColumnModel().getColumn(2).setPreferredWidth(0);
        this.JTDatosMedicamentos.getColumnModel().getColumn(2).setMinWidth(0);
        this.JTDatosMedicamentos.getColumnModel().getColumn(2).setMaxWidth(0);
        this.JTDatosMedicamentos.getColumnModel().getColumn(3).setPreferredWidth(200);
        this.JTDatosMedicamentos.getColumnModel().getColumn(4).setPreferredWidth(50);
        this.JTDatosMedicamentos.getColumnModel().getColumn(5).setPreferredWidth(20);
        this.JTDatosMedicamentos.getColumnModel().getColumn(6).setPreferredWidth(30);
        this.JTDatosMedicamentos.getColumnModel().getColumn(7).setPreferredWidth(0);
        this.JTDatosMedicamentos.getColumnModel().getColumn(7).setMinWidth(0);
        this.JTDatosMedicamentos.getColumnModel().getColumn(7).setMaxWidth(0);
        this.JTDatosMedicamentos.getColumnModel().getColumn(8).setPreferredWidth(0);
        this.JTDatosMedicamentos.getColumnModel().getColumn(8).setMinWidth(0);
        this.JTDatosMedicamentos.getColumnModel().getColumn(8).setMaxWidth(0);
        this.JTDatosMedicamentos.getColumnModel().getColumn(9).setPreferredWidth(0);
        this.JTDatosMedicamentos.getColumnModel().getColumn(9).setMinWidth(0);
        this.JTDatosMedicamentos.getColumnModel().getColumn(9).setMaxWidth(0);
        this.JTDatosMedicamentos.getColumnModel().getColumn(10).setPreferredWidth(0);
        this.JTDatosMedicamentos.getColumnModel().getColumn(10).setMinWidth(0);
        this.JTDatosMedicamentos.getColumnModel().getColumn(10).setMaxWidth(0);
        this.JTDatosMedicamentos.getColumnModel().getColumn(11).setPreferredWidth(0);
        this.JTDatosMedicamentos.getColumnModel().getColumn(11).setMinWidth(0);
        this.JTDatosMedicamentos.getColumnModel().getColumn(11).setMaxWidth(0);
        this.JTDatosMedicamentos.getColumnModel().getColumn(12).setPreferredWidth(0);
        this.JTDatosMedicamentos.getColumnModel().getColumn(12).setMinWidth(0);
        this.JTDatosMedicamentos.getColumnModel().getColumn(12).setMaxWidth(0);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTablaHistorico() {
        this.xmodeloH = new DefaultTableModel(new Object[0], new String[]{"Id", "Fecha y Hora", "Especialidad", "Profesional", "Tipo", "Estado", "Aplicado", "Seleccionar"}) { // from class: Historia.JPIOrden_Tratamiento.19
            Class[] types = {Long.class, String.class, String.class, String.class, String.class, Boolean.class, Boolean.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalleH.setModel(this.xmodeloH);
        this.JTDetalleH.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTDetalleH.getColumnModel().getColumn(1).setPreferredWidth(10);
        this.JTDetalleH.getColumnModel().getColumn(2).setPreferredWidth(50);
        this.JTDetalleH.getColumnModel().getColumn(3).setPreferredWidth(150);
        this.JTDetalleH.getColumnModel().getColumn(4).setPreferredWidth(50);
        this.JTDetalleH.getColumnModel().getColumn(5).setPreferredWidth(10);
        this.JTDetalleH.getColumnModel().getColumn(6).setPreferredWidth(0);
        this.JTDetalleH.getColumnModel().getColumn(6).setMinWidth(0);
        this.JTDetalleH.getColumnModel().getColumn(6).setMaxWidth(0);
        this.JTDetalleH.getColumnModel().getColumn(7).setPreferredWidth(10);
    }

    private void mLLenartabla() {
        try {
            mCrearTablaMedicamentos();
            if (Principal.informacionIps.getNombreIps().equals("CLINICA PAJONAL S.A.S") || Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JUAN DE DIOS") || Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JORGE DE AYAPEL") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO CAMU CHIMA")) {
                if (this.JCHEsPrincipio.isSelected()) {
                    this.xsql = "SELECT i_principioactivo.Id AS IdPrincipioActivo, i_principioactivo.Nbre AS NPrincipioActivo,i_suministro.Id AS IdSuministro, UPPER(CONCAT(IF(i_principioactivo.`Nbre`='NO APLICA',i_suministro.`Nbre`,i_principioactivo.`Nbre`),' ', IF(i_concentracion.`Nbre`='NO APLICA' OR i_concentracion.`Nbre`='-','',i_concentracion.`Nbre`) ,' ', IF(i_presentacionfarmaceutica.`Nbre`='NO APLICA','', i_presentacionfarmaceutica.`Nbre`))) AS NSuministro, i_concentracion.Nbre AS NConcentracion ,i_presentacionfarmaceutica.Nbre AS NPresentacionF, i_presentacioncomercial.Nbre AS NPresentacionC, IF((SUM(i_suministroxlotexbodega.Cantidad)- SUM(i_suministroxlotexbodega.CPendiente))>0, (SUM(i_suministroxlotexbodega.Cantidad)- SUM(i_suministroxlotexbodega.CPendiente)), 0)  AS Cantidad, ROUND(AVG(i_suministroxbodega.Costo)) AS Costo, i_presentacionfarmaceutica.EsAmpolla, IF((i_suministro.FechaVInvima<=NOW()),0,1) AS VFinvima, DATE_FORMAT(i_suministro.FechaVInvima,'%d-%m-%Y') AS FV, i_suministroxbodega.CInventario, i_suministro.`IdTipoProducto`, iv.Nbre as viaAdministracion  FROM  `i_suministro` INNER JOIN `i_principioactivo`  ON (`i_suministro`.`IdPrincipioActivo` = `i_principioactivo`.`Id`) INNER JOIN `i_presentacioncomercial`  ON (`i_suministro`.`IdPresentacionComercial` = `i_presentacioncomercial`.`Id`) INNER JOIN `i_presentacionfarmaceutica`  ON (`i_suministro`.`IdPresentacionFarmaceutica` = `i_presentacionfarmaceutica`.`Id`) INNER JOIN `i_laboratorio`   ON (`i_suministro`.`IdLaboratorio` = `i_laboratorio`.`Id`) INNER JOIN `i_concentracion`  ON (`i_suministro`.`IdConcentracion` = `i_concentracion`.`Id`) INNER JOIN `i_suministroxbodega`  ON (`i_suministroxbodega`.`IdSuministro` = `i_suministro`.`Id`) INNER JOIN `i_suministroxlotexbodega`  ON (`i_suministroxlotexbodega`.`Id` = `i_suministroxbodega`.`Id`) INNER JOIN `i_bodegas`  ON (`i_suministroxbodega`.`IdBodega` = `i_bodegas`.`Id`) inner join i_viaadministracion iv on (iv.Id=i_suministro.IdViaAdministracion)WHERE (i_bodegas.EsUrg=1  and `i_suministro`.ActivoHc=1  AND i_principioactivo.Nbre<>'-' AND UPPER(CONCAT(IF(i_principioactivo.`Nbre`='NO APLICA',i_suministro.`Nbre`,i_principioactivo.`Nbre`),' ', IF(i_concentracion.`Nbre`='NO APLICA' OR i_concentracion.`Nbre`='-','',i_concentracion.`Nbre`) ,' ', IF(i_presentacionfarmaceutica.`Nbre`='NO APLICA','', i_presentacionfarmaceutica.`Nbre`))) LIKE'%" + this.JTFNombre.getText().toUpperCase() + "%')  GROUP BY IdSuministro ";
                    if (Principal.informacionIps.getAplicaSoloInsumoExistentesUrgencias().booleanValue()) {
                        this.xsql += "HAVING Cantidad>0 ";
                    }
                    this.xsql += "ORDER BY i_principioactivo.Nbre, i_presentacionfarmaceutica.Nbre, i_suministroxbodega.Costo, IdSuministro, i_suministro.Nbre  ";
                } else {
                    this.xsql = "SELECT i_principioactivo.Id AS IdPrincipioActivo, i_principioactivo.Nbre AS NPrincipioActivo,i_suministro.Id AS IdSuministro, UPPER(CONCAT(IF(i_principioactivo.`Nbre`='NO APLICA',i_suministro.`Nbre`,i_principioactivo.`Nbre`),' ', IF(i_concentracion.`Nbre`='NO APLICA' OR i_concentracion.`Nbre`='-','',i_concentracion.`Nbre`) ,' ', IF(i_presentacionfarmaceutica.`Nbre`='NO APLICA','', i_presentacionfarmaceutica.`Nbre`))) AS NSuministro, i_concentracion.Nbre AS NConcentracion ,i_presentacionfarmaceutica.Nbre AS NPresentacionF, i_presentacioncomercial.Nbre AS NPresentacionC, IF((SUM(i_suministroxlotexbodega.Cantidad)- SUM(i_suministroxlotexbodega.CPendiente))>0, (SUM(i_suministroxlotexbodega.Cantidad)- SUM(i_suministroxlotexbodega.CPendiente)), 0)  AS Cantidad, ROUND(AVG(i_suministroxbodega.Costo)) AS Costo, i_presentacionfarmaceutica.EsAmpolla, IF((i_suministro.FechaVInvima<=NOW()),0,1) AS VFinvima, DATE_FORMAT(i_suministro.FechaVInvima,'%d-%m-%Y') AS FV, i_suministroxbodega.CInventario, i_suministro.`IdTipoProducto`, iv.Nbre as viaAdministracion  FROM  `i_suministro` INNER JOIN `i_principioactivo`  ON (`i_suministro`.`IdPrincipioActivo` = `i_principioactivo`.`Id`) INNER JOIN `i_presentacioncomercial`  ON (`i_suministro`.`IdPresentacionComercial` = `i_presentacioncomercial`.`Id`) INNER JOIN `i_presentacionfarmaceutica`  ON (`i_suministro`.`IdPresentacionFarmaceutica` = `i_presentacionfarmaceutica`.`Id`) INNER JOIN `i_laboratorio`   ON (`i_suministro`.`IdLaboratorio` = `i_laboratorio`.`Id`) INNER JOIN `i_concentracion`  ON (`i_suministro`.`IdConcentracion` = `i_concentracion`.`Id`) INNER JOIN `i_suministroxbodega`  ON (`i_suministroxbodega`.`IdSuministro` = `i_suministro`.`Id`) INNER JOIN `i_suministroxlotexbodega`  ON (`i_suministroxlotexbodega`.`Id` = `i_suministroxbodega`.`Id`) INNER JOIN `i_bodegas`  ON (`i_suministroxbodega`.`IdBodega` = `i_bodegas`.`Id`) inner join i_viaadministracion iv on (iv.Id=i_suministro.IdViaAdministracion)WHERE (i_bodegas.EsUrg=1    and `i_suministro`.ActivoHc=1  AND i_principioactivo.Nbre<>'-' AND UPPER(CONCAT(IF(i_principioactivo.`Nbre`='NO APLICA',i_suministro.`Nbre`,i_principioactivo.`Nbre`),' ', IF(i_concentracion.`Nbre`='NO APLICA' OR i_concentracion.`Nbre`='-','',i_concentracion.`Nbre`) ,' ', IF(i_presentacionfarmaceutica.`Nbre`='NO APLICA','', i_presentacionfarmaceutica.`Nbre`))) like '%" + this.JTFNombre.getText().toUpperCase() + "%')  GROUP BY IdSuministro ";
                    if (Principal.informacionIps.getAplicaSoloInsumoExistentesUrgencias().booleanValue()) {
                        this.xsql += "HAVING Cantidad>0 ";
                    }
                    this.xsql += "ORDER BY i_principioactivo.Nbre, i_presentacionfarmaceutica.Nbre, i_suministroxbodega.Costo, IdSuministro, i_suministro.Nbre  ";
                }
            } else if (Principal.informacionIps.getIdentificacion().equals("900520293")) {
                if (this.JCHEsPrincipio.isSelected()) {
                    this.xsql = "SELECT i_principioactivo.Id AS IdPrincipioActivo, i_principioactivo.Nbre AS NPrincipioActivo,i_suministro.Id AS IdSuministro, i_suministro.Nbre AS NSuministro, i_concentracion.Nbre AS NConcentracion ,i_presentacionfarmaceutica.Nbre AS NPresentacionF, i_presentacioncomercial.Nbre AS NPresentacionC, IF((SUM(i_suministroxlotexbodega.Cantidad)- SUM(i_suministroxlotexbodega.CPendiente))>0, (SUM(i_suministroxlotexbodega.Cantidad)- SUM(i_suministroxlotexbodega.CPendiente)), 0)  AS Cantidad, ROUND(AVG(i_suministroxbodega.Costo)) AS Costo, i_presentacionfarmaceutica.EsAmpolla, IF((i_suministro.FechaVInvima<=NOW()),0,1) AS VFinvima, DATE_FORMAT(i_suministro.FechaVInvima,'%d-%m-%Y') AS FV, i_suministroxbodega.CInventario, i_suministro.`IdTipoProducto`, iv.Nbre as viaAdministracion  FROM  `i_suministro` INNER JOIN `i_principioactivo`  ON (`i_suministro`.`IdPrincipioActivo` = `i_principioactivo`.`Id`) INNER JOIN `i_presentacioncomercial`  ON (`i_suministro`.`IdPresentacionComercial` = `i_presentacioncomercial`.`Id`) INNER JOIN `i_presentacionfarmaceutica`  ON (`i_suministro`.`IdPresentacionFarmaceutica` = `i_presentacionfarmaceutica`.`Id`) INNER JOIN `i_laboratorio`   ON (`i_suministro`.`IdLaboratorio` = `i_laboratorio`.`Id`) INNER JOIN `i_concentracion`  ON (`i_suministro`.`IdConcentracion` = `i_concentracion`.`Id`) INNER JOIN `i_suministroxbodega`  ON (`i_suministroxbodega`.`IdSuministro` = `i_suministro`.`Id`) INNER JOIN `i_suministroxlotexbodega`  ON (`i_suministroxlotexbodega`.`Id` = `i_suministroxbodega`.`Id`) INNER JOIN `i_bodegas`  ON (`i_suministroxbodega`.`IdBodega` = `i_bodegas`.`Id`) inner join i_viaadministracion iv on (iv.Id=i_suministro.IdViaAdministracion)WHERE (i_bodegas.EsUrg=1  and `i_suministro`.ActivoHc=1  AND i_principioactivo.Nbre<>'-' AND i_principioactivo.Nbre LIKE'%" + this.JTFNombre.getText().toUpperCase() + "%')  GROUP BY IdSuministro ";
                    if (Principal.informacionIps.getAplicaSoloInsumoExistentesUrgencias().booleanValue()) {
                        this.xsql += "HAVING Cantidad>0 ";
                    }
                    this.xsql += "ORDER BY i_principioactivo.Nbre, i_presentacionfarmaceutica.Nbre, i_suministroxbodega.Costo, IdSuministro, i_suministro.Nbre  ";
                } else {
                    this.xsql = "SELECT i_principioactivo.Id AS IdPrincipioActivo, i_principioactivo.Nbre AS NPrincipioActivo,i_suministro.Id AS IdSuministro, i_suministro.Nbre AS NSuministro, i_concentracion.Nbre AS NConcentracion ,i_presentacionfarmaceutica.Nbre AS NPresentacionF, i_presentacioncomercial.Nbre AS NPresentacionC, IF((SUM(i_suministroxlotexbodega.Cantidad)- SUM(i_suministroxlotexbodega.CPendiente))>0, (SUM(i_suministroxlotexbodega.Cantidad)- SUM(i_suministroxlotexbodega.CPendiente)), 0)  AS Cantidad, ROUND(AVG(i_suministroxbodega.Costo)) AS Costo, i_presentacionfarmaceutica.EsAmpolla, IF((i_suministro.FechaVInvima<=NOW()),0,1) AS VFinvima, DATE_FORMAT(i_suministro.FechaVInvima,'%d-%m-%Y') AS FV, i_suministroxbodega.CInventario, i_suministro.`IdTipoProducto`, iv.Nbre as viaAdministracion  FROM  `i_suministro` INNER JOIN `i_principioactivo`  ON (`i_suministro`.`IdPrincipioActivo` = `i_principioactivo`.`Id`) INNER JOIN `i_presentacioncomercial`  ON (`i_suministro`.`IdPresentacionComercial` = `i_presentacioncomercial`.`Id`) INNER JOIN `i_presentacionfarmaceutica`  ON (`i_suministro`.`IdPresentacionFarmaceutica` = `i_presentacionfarmaceutica`.`Id`) INNER JOIN `i_laboratorio`   ON (`i_suministro`.`IdLaboratorio` = `i_laboratorio`.`Id`) INNER JOIN `i_concentracion`  ON (`i_suministro`.`IdConcentracion` = `i_concentracion`.`Id`) INNER JOIN `i_suministroxbodega`  ON (`i_suministroxbodega`.`IdSuministro` = `i_suministro`.`Id`) INNER JOIN `i_suministroxlotexbodega`  ON (`i_suministroxlotexbodega`.`Id` = `i_suministroxbodega`.`Id`) INNER JOIN `i_bodegas`  ON (`i_suministroxbodega`.`IdBodega` = `i_bodegas`.`Id`) inner join i_viaadministracion iv on (iv.Id=i_suministro.IdViaAdministracion)WHERE (i_bodegas.EsUrg=1    and `i_suministro`.ActivoHc=1  AND i_principioactivo.Nbre<>'-' AND i_suministro.Nbre like '%" + this.JTFNombre.getText().toUpperCase() + "%')  GROUP BY IdSuministro ";
                    if (Principal.informacionIps.getAplicaSoloInsumoExistentesUrgencias().booleanValue()) {
                        this.xsql += "HAVING Cantidad>0 ";
                    }
                    this.xsql += "ORDER BY Cantidad desc, i_principioactivo.Nbre, i_presentacionfarmaceutica.Nbre, i_suministroxbodega.Costo, IdSuministro, i_suministro.Nbre  ";
                }
            } else if (this.JCHEsPrincipio.isSelected()) {
                this.xsql = "SELECT i_principioactivo.Id AS IdPrincipioActivo, i_principioactivo.Nbre AS NPrincipioActivo,i_suministro.Id AS IdSuministro, i_suministro.Nbre AS NSuministro, i_concentracion.Nbre AS NConcentracion ,i_presentacionfarmaceutica.Nbre AS NPresentacionF, i_presentacioncomercial.Nbre AS NPresentacionC, IF((SUM(i_suministroxlotexbodega.Cantidad)- SUM(i_suministroxlotexbodega.CPendiente))>0, (SUM(i_suministroxlotexbodega.Cantidad)- SUM(i_suministroxlotexbodega.CPendiente)), 0)  AS Cantidad, ROUND(AVG(i_suministroxbodega.Costo)) AS Costo, i_presentacionfarmaceutica.EsAmpolla, IF((i_suministro.FechaVInvima<=NOW()),0,1) AS VFinvima, DATE_FORMAT(i_suministro.FechaVInvima,'%d-%m-%Y') AS FV, i_suministroxbodega.CInventario, i_suministro.`IdTipoProducto`, iv.Nbre as viaAdministracion  FROM  `i_suministro` INNER JOIN `i_principioactivo`  ON (`i_suministro`.`IdPrincipioActivo` = `i_principioactivo`.`Id`) INNER JOIN `i_presentacioncomercial`  ON (`i_suministro`.`IdPresentacionComercial` = `i_presentacioncomercial`.`Id`) INNER JOIN `i_presentacionfarmaceutica`  ON (`i_suministro`.`IdPresentacionFarmaceutica` = `i_presentacionfarmaceutica`.`Id`) INNER JOIN `i_laboratorio`   ON (`i_suministro`.`IdLaboratorio` = `i_laboratorio`.`Id`) INNER JOIN `i_concentracion`  ON (`i_suministro`.`IdConcentracion` = `i_concentracion`.`Id`) INNER JOIN `i_suministroxbodega`  ON (`i_suministroxbodega`.`IdSuministro` = `i_suministro`.`Id`) INNER JOIN `i_suministroxlotexbodega`  ON (`i_suministroxlotexbodega`.`Id` = `i_suministroxbodega`.`Id`) INNER JOIN `i_bodegas`  ON (`i_suministroxbodega`.`IdBodega` = `i_bodegas`.`Id`) inner join i_viaadministracion iv on (iv.Id=i_suministro.IdViaAdministracion)WHERE (i_bodegas.EsUrg=1  and `i_suministro`.ActivoHc=1  AND i_principioactivo.Nbre<>'-' AND i_principioactivo.Nbre LIKE'%" + this.JTFNombre.getText().toUpperCase() + "%')  GROUP BY IdSuministro ";
                if (Principal.informacionIps.getAplicaSoloInsumoExistentesUrgencias().booleanValue()) {
                    this.xsql += "HAVING Cantidad>0 ";
                }
                this.xsql += "ORDER BY i_principioactivo.Nbre, i_presentacionfarmaceutica.Nbre, i_suministroxbodega.Costo, IdSuministro, i_suministro.Nbre  ";
            } else {
                this.xsql = "SELECT i_principioactivo.Id AS IdPrincipioActivo, i_principioactivo.Nbre AS NPrincipioActivo,i_suministro.Id AS IdSuministro, i_suministro.Nbre AS NSuministro, i_concentracion.Nbre AS NConcentracion ,i_presentacionfarmaceutica.Nbre AS NPresentacionF, i_presentacioncomercial.Nbre AS NPresentacionC, IF((SUM(i_suministroxlotexbodega.Cantidad)- SUM(i_suministroxlotexbodega.CPendiente))>0, (SUM(i_suministroxlotexbodega.Cantidad)- SUM(i_suministroxlotexbodega.CPendiente)), 0)  AS Cantidad, ROUND(AVG(i_suministroxbodega.Costo)) AS Costo, i_presentacionfarmaceutica.EsAmpolla, IF((i_suministro.FechaVInvima<=NOW()),0,1) AS VFinvima, DATE_FORMAT(i_suministro.FechaVInvima,'%d-%m-%Y') AS FV, i_suministroxbodega.CInventario, i_suministro.`IdTipoProducto`, iv.Nbre as viaAdministracion  FROM  `i_suministro` INNER JOIN `i_principioactivo`  ON (`i_suministro`.`IdPrincipioActivo` = `i_principioactivo`.`Id`) INNER JOIN `i_presentacioncomercial`  ON (`i_suministro`.`IdPresentacionComercial` = `i_presentacioncomercial`.`Id`) INNER JOIN `i_presentacionfarmaceutica`  ON (`i_suministro`.`IdPresentacionFarmaceutica` = `i_presentacionfarmaceutica`.`Id`) INNER JOIN `i_laboratorio`   ON (`i_suministro`.`IdLaboratorio` = `i_laboratorio`.`Id`) INNER JOIN `i_concentracion`  ON (`i_suministro`.`IdConcentracion` = `i_concentracion`.`Id`) INNER JOIN `i_suministroxbodega`  ON (`i_suministroxbodega`.`IdSuministro` = `i_suministro`.`Id`) INNER JOIN `i_suministroxlotexbodega`  ON (`i_suministroxlotexbodega`.`Id` = `i_suministroxbodega`.`Id`) INNER JOIN `i_bodegas`  ON (`i_suministroxbodega`.`IdBodega` = `i_bodegas`.`Id`) inner join i_viaadministracion iv on (iv.Id=i_suministro.IdViaAdministracion)WHERE (i_bodegas.EsUrg=1    and `i_suministro`.ActivoHc=1  AND i_principioactivo.Nbre<>'-' AND i_suministro.Nbre like '%" + this.JTFNombre.getText().toUpperCase() + "%')  GROUP BY IdSuministro ";
                if (Principal.informacionIps.getAplicaSoloInsumoExistentesUrgencias().booleanValue()) {
                    this.xsql += "HAVING Cantidad>0 ";
                }
                this.xsql += "ORDER BY i_principioactivo.Nbre, i_presentacionfarmaceutica.Nbre, i_suministroxbodega.Costo, IdSuministro, i_suministro.Nbre  ";
            }
            System.out.println(" Medicamentos   " + this.xsql);
            ResultSet rss = this.xct.traerRs(this.xsql);
            Throwable th = null;
            try {
                if (rss.next()) {
                    rss.beforeFirst();
                    int x = 0;
                    while (rss.next()) {
                        this.xmodelo.addRow(this.xdato);
                        this.xmodelo.setValueAt(rss.getString(1), x, 0);
                        this.xmodelo.setValueAt(rss.getString(2), x, 1);
                        this.xmodelo.setValueAt(rss.getString(3), x, 2);
                        this.xmodelo.setValueAt(rss.getString(4), x, 3);
                        this.xmodelo.setValueAt(rss.getString(7), x, 4);
                        this.xmodelo.setValueAt(Integer.valueOf(rss.getInt(8)), x, 5);
                        this.xmodelo.setValueAt(Long.valueOf(rss.getLong(9)), x, 6);
                        this.xmodelo.setValueAt(Long.valueOf(rss.getLong(11)), x, 8);
                        this.xmodelo.setValueAt(rss.getString(12), x, 9);
                        this.xmodelo.setValueAt(rss.getString(10), x, 7);
                        this.xmodelo.setValueAt(rss.getString(13), x, 10);
                        this.xmodelo.setValueAt(Long.valueOf(rss.getLong(14)), x, 11);
                        this.xmodelo.setValueAt(rss.getString("viaAdministracion"), x, 12);
                        this.JTDatosMedicamentos.setDefaultRenderer(Object.class, new MiRender());
                        x++;
                    }
                }
                if (rss != null) {
                    if (0 != 0) {
                        try {
                            rss.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    } else {
                        rss.close();
                    }
                }
                this.xct.cerrarConexionBd();
            } finally {
            }
        } catch (SQLException ex) {
            Logger.getLogger(JPIOrden_Tratamiento.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatosH() {
        try {
            mCrearTablaHistorico();
            this.xsql = "SELECT `h_ordenes_unidosis`.`Id` , `h_ordenes_unidosis`.`Fecha` , `profesional1`.`Especialidad`  , `profesional1`.`NProfesional` , IF(`h_ordenes_unidosis`.`Tipo`=3,'URGENCIAS','HOSPITALIZACION') AS TIPO , `h_ordenes_unidosis`.`Estado`, `h_ordenes_unidosis`.`Finalizado` FROM  `profesional1` INNER JOIN  `h_ordenes_unidosis`  ON (`profesional1`.`Id_Persona` = `h_ordenes_unidosis`.`Id_Profesional`) AND (`profesional1`.`IdEspecialidad` = `h_ordenes_unidosis`.`Id_Especialidad`) WHERE (`h_ordenes_unidosis`.`Id_Atencion` ='" + this.xidatencion + "' AND  `h_ordenes_unidosis`.Estado=1) ";
            ResultSet rss = this.xct.traerRs(this.xsql);
            if (rss.next()) {
                rss.beforeFirst();
                int x = 0;
                while (rss.next()) {
                    this.xmodeloH.addRow(this.xdato);
                    this.xmodeloH.setValueAt(Long.valueOf(rss.getLong("Id")), x, 0);
                    this.xmodeloH.setValueAt(rss.getString("Fecha"), x, 1);
                    this.xmodeloH.setValueAt(rss.getString("Especialidad"), x, 2);
                    this.xmodeloH.setValueAt(rss.getString("NProfesional"), x, 3);
                    this.xmodeloH.setValueAt(rss.getString("TIPO"), x, 4);
                    this.xmodeloH.setValueAt(Boolean.valueOf(rss.getBoolean("Estado")), x, 5);
                    this.xmodeloH.setValueAt(Boolean.valueOf(rss.getBoolean("Finalizado")), x, 6);
                    this.xmodeloH.setValueAt(false, x, 7);
                    this.JTDetalleH.setDefaultRenderer(Object.class, new MiRender1());
                    x++;
                }
            }
            rss.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPIOrden_Tratamiento.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:Historia/JPIOrden_Tratamiento$MiRender.class */
    public static class MiRender extends DefaultTableCellRenderer {
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            String trabajador = table.getValueAt(row, 7).toString();
            if (table.getValueAt(row, 11).toString().equals("7")) {
                cell.setBackground(new Color(153, 0, 153));
                cell.setForeground(Color.WHITE);
            } else {
                if ((trabajador.equals("1") && table.getValueAt(row, 10).toString().equals("0")) || (trabajador.equals("1") && table.getValueAt(row, 10).toString().equals("1"))) {
                    cell.setBackground(new Color(177, 251, 177));
                } else if (trabajador.equals("0") && table.getValueAt(row, 10).toString().equals("1")) {
                    cell.setBackground(Color.RED);
                } else if (trabajador.equals("0") && table.getValueAt(row, 10).toString().equals("0")) {
                    cell.setBackground(Color.WHITE);
                }
                cell.setForeground(Color.BLACK);
            }
            return cell;
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:Historia/JPIOrden_Tratamiento$MiRender1.class */
    public static class MiRender1 extends DefaultTableCellRenderer {
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (Boolean.valueOf(table.getValueAt(row, 5).toString()).booleanValue()) {
                cell.setBackground(new Color(177, 251, 177));
                cell.setForeground(Color.BLACK);
            } else {
                cell.setBackground(new Color(255, 255, 255));
                cell.setForeground(Color.BLACK);
            }
            return cell;
        }
    }

    private void mLimpiar() {
        this.JTFNombre.setText("");
        this.JTFDosis.setText("");
        if (Principal.informacionIps.getNombreIps().equals("CLINICA LAURELES PSIQUIATRAS ASOCIADOS I.P.S. S.A.S.") || Principal.informacionIps.getNombreIps().equals("UNION TEMPORAL CLINICA LAURELES")) {
            this.JTFFCantidad.setValue((Object) null);
        } else {
            this.JTFFCantidad.setValue(new Integer(1));
        }
        if (Principal.informacionIps.getIdentificacion().equals("812005644")) {
            this.JTFFrecuencia.setText("N/A");
            this.JTFDosis.setText("N/A");
            return;
        }
        if (Principal.informacionIps.getNombreIps().equals("CLINICA PAJONAL S.A.S") || Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JUAN DE DIOS") || Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JORGE DE AYAPEL") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO CAMU CHIMA")) {
            if (this.modulo.equals("xjifhistoriauh")) {
                this.JTFDosis.setText("1");
                this.JTFFrecuencia.setText("1");
                return;
            }
            return;
        }
        this.JTFFrecuencia.setText("");
        this.JTAObservaciones.setText("");
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTablaDetalleMedicamentos() {
        xmodelodetallet = new DefaultTableModel(new Object[0], new String[]{"IdProducto", "Producto", "Dosis", "Frecuencia", "Cantidad", "Observacion", "idIndex", "Código Grupo", "Nombre Grupo", "Código Servicio Rips", "Nombre Servicio Rips", "Duración", "codViaAdministración", "viaAdministración"}) { // from class: Historia.JPIOrden_Tratamiento.20
            Class[] types = {Integer.class, String.class, String.class, String.class, Integer.class, String.class, Integer.class, String.class, String.class, String.class, String.class, Integer.class, String.class, String.class};
            boolean[] canEdit = {false, false, true, true, true, true, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTDatosDetMedicamentos.setAutoResizeMode(0);
        JTDatosDetMedicamentos.doLayout();
        JTDatosDetMedicamentos.setModel(xmodelodetallet);
        JTDatosDetMedicamentos.getColumnModel().getColumn(0).setPreferredWidth(0);
        JTDatosDetMedicamentos.getColumnModel().getColumn(0).setMinWidth(0);
        JTDatosDetMedicamentos.getColumnModel().getColumn(0).setMaxWidth(0);
        JTDatosDetMedicamentos.getColumnModel().getColumn(1).setPreferredWidth(300);
        JTDatosDetMedicamentos.getColumnModel().getColumn(2).setPreferredWidth(80);
        JTDatosDetMedicamentos.getColumnModel().getColumn(3).setPreferredWidth(200);
        JTDatosDetMedicamentos.getColumnModel().getColumn(4).setPreferredWidth(80);
        JTDatosDetMedicamentos.getColumnModel().getColumn(5).setPreferredWidth(200);
        JTDatosDetMedicamentos.getColumnModel().getColumn(6).setPreferredWidth(100);
        JTDatosDetMedicamentos.getColumnModel().getColumn(7).setPreferredWidth(100);
        JTDatosDetMedicamentos.getColumnModel().getColumn(8).setPreferredWidth(150);
        JTDatosDetMedicamentos.getColumnModel().getColumn(9).setPreferredWidth(100);
        JTDatosDetMedicamentos.getColumnModel().getColumn(10).setPreferredWidth(200);
        JTDatosDetMedicamentos.getColumnModel().getColumn(11).setPreferredWidth(100);
        JTDatosDetMedicamentos.getColumnModel().getColumn(12).setPreferredWidth(100);
        JTDatosDetMedicamentos.getColumnModel().getColumn(13).setPreferredWidth(100);
    }

    private void mAdicionar() {
        if (this.JTDatosMedicamentos.getSelectedRow() != -1) {
            if (!this.JTFDosis.getText().isEmpty()) {
                if (!this.JTFFrecuencia.getText().isEmpty()) {
                    if (!this.JTFFCantidad.getText().isEmpty()) {
                        if (!this.JTFFDuracion.getText().isEmpty()) {
                            if (this.JLBNRegistro.getText().isEmpty()) {
                                xmodelodetallet.addRow(this.xdato);
                                this.suministro = null;
                                this.suministro = this.iSuministroService.suministroPorId(Long.valueOf(this.JTDatosMedicamentos.getValueAt(this.JTDatosMedicamentos.getSelectedRow(), 2).toString()));
                                xmodelodetallet.setValueAt(this.JTDatosMedicamentos.getValueAt(this.JTDatosMedicamentos.getSelectedRow(), 2), this.xfila, 0);
                                xmodelodetallet.setValueAt(this.JTDatosMedicamentos.getValueAt(this.JTDatosMedicamentos.getSelectedRow(), 3), this.xfila, 1);
                                xmodelodetallet.setValueAt(this.JTFDosis.getText(), this.xfila, 2);
                                xmodelodetallet.setValueAt(this.JTFFrecuencia.getText(), this.xfila, 3);
                                xmodelodetallet.setValueAt(this.JTFFCantidad.getValue(), this.xfila, 4);
                                xmodelodetallet.setValueAt(this.JTAObservaciones.getText(), this.xfila, 5);
                                xmodelodetallet.setValueAt(-1, this.xfila, 6);
                                xmodelodetallet.setValueAt(this.listGrupoEntitys.get(this.JCBGrupoSevicio.getSelectedIndex()).getId(), this.xfila, 7);
                                xmodelodetallet.setValueAt(this.listGrupoEntitys.get(this.JCBGrupoSevicio.getSelectedIndex()).getNombre(), this.xfila, 8);
                                xmodelodetallet.setValueAt(this.ListripsEntitys.get(this.JCBSevicioRips.getSelectedIndex()).getId(), this.xfila, 9);
                                xmodelodetallet.setValueAt(this.ListripsEntitys.get(this.JCBSevicioRips.getSelectedIndex()).getNombre(), this.xfila, 10);
                                xmodelodetallet.setValueAt(this.JTFFDuracion.getText(), this.xfila, 11);
                                xmodelodetallet.setValueAt(this.viaadministracion.get(this.JCBViaAdministracion.getSelectedIndex()).getId(), this.xfila, 12);
                                xmodelodetallet.setValueAt(this.viaadministracion.get(this.JCBViaAdministracion.getSelectedIndex()).getNbre(), this.xfila, 13);
                                this.xfila++;
                                mLimpiar();
                                this.xtipom = false;
                                return;
                            }
                            return;
                        }
                        JOptionPane.showInternalMessageDialog(this, "El campo duración   \n no puede estar en blanco", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        this.JTFFDuracion.requestFocus();
                        return;
                    }
                    JOptionPane.showInternalMessageDialog(this, "El campo cantidad   \n no puede estar en blanco", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    this.JTFFCantidad.requestFocus();
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "tEl campo frecuencia   \n no puede estar en blanco", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JTFFrecuencia.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "tEl campo dosis \n no puede estar en blanco", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFDosis.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un producto", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTDatosMedicamentos.requestFocus();
    }

    private void mVerificarMedicamentoControl() {
        if (Integer.parseInt(this.xmodelo.getValueAt(this.JTDatosMedicamentos.getSelectedRow(), 11).toString()) == 7) {
            JOptionPane.showInternalMessageDialog(this, "<html><P ALIGN=center> <font face='Arial' color='#9932CC' size=4>  <b>MEDICAMENTO DE USO CONTROLADO;</p><font face='Arial' color='#9932CC' size=4>FAVOR DILIGENCIAR FORMATO RESPECTIVO.", "CONTROL ESPECIAL DE MEDICAMENTO", 2, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Warning.png"))));
        }
    }

    public void mGrabar() {
        if (this.xRCargo == 0) {
            if (this.JLBNRegistro.getText().isEmpty()) {
                if (JTDatosDetMedicamentos.getRowCount() != -1) {
                    int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    if (x == 0) {
                        OrdenamientoMedico ordenamientoMedico = OrdenamientoMedico.builder().cerrada(false).descripcion("ORDEN DE TRATAMIENTO").especialidad(Principal.informacionGeneralPrincipalDTO.getNombreEspecialidad()).profesional(Principal.usuarioSistemaDTO.getNombreUsuario()).estado(true).fechaOrden(this.xmt.getFechaActualLocalTime()).idServicio(Integer.valueOf(this.xId_TipoAtencion)).idAtencion(Long.valueOf(this.xidatencion)).build();
                        List<OrdenamientoMedicoDetalle> listDetalles = new ArrayList<>();
                        this.xsql = "insert into `h_ordenes_unidosis`(`Id_Ingreso`, `Id_Atencion`,`Fecha`, `Id_Profesional`, `Id_Especialidad`, `Tipo`, `UsuarioS`) values('" + this.xidingreso + "','" + this.xidatencion + "','" + this.xmt.formatoAMD1.format(this.JDFecha.getDate()) + " " + this.JTFFHora.getText() + "','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "','" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "','" + this.xId_TipoAtencion + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                        this.JLBNRegistro.setText(this.xct.ejecutarSQLId(this.xsql));
                        this.xct.cerrarConexionBd();
                        ordenamientoMedico.setIdOrden(Long.valueOf(this.JLBNRegistro.getText()));
                        for (int y = 0; y < JTDatosDetMedicamentos.getRowCount(); y++) {
                            OrdenamientoMedicoDetalle detalle = OrdenamientoMedicoDetalle.builder().codigo(xmodelodetallet.getValueAt(y, 0).toString()).cantidad(xmodelodetallet.getValueAt(y, 4).toString()).ejecutado(false).nombre(xmodelodetallet.getValueAt(y, 1).toString()).observacion(xmodelodetallet.getValueAt(y, 2).toString().concat(" ").concat(xmodelodetallet.getValueAt(y, 3).toString()).concat(" ").concat(xmodelodetallet.getValueAt(y, 4).toString())).build();
                            this.xsql = "insert into `h_ordenes_unidosis_detalle`(`Id_Ordenes` , `Id_Suministro` , `Dosis` , `Frecuencia` , `Cantidad` ,DuracionD, idModalidadAtencion, idServicioRips,`Observacion`,idViaAdministracion )values('" + this.JLBNRegistro.getText() + "','" + xmodelodetallet.getValueAt(y, 0) + "','" + xmodelodetallet.getValueAt(y, 2) + "','" + xmodelodetallet.getValueAt(y, 3) + "','" + xmodelodetallet.getValueAt(y, 4) + "','" + xmodelodetallet.getValueAt(y, 11) + "','1','" + xmodelodetallet.getValueAt(y, 9) + "','" + xmodelodetallet.getValueAt(y, 5) + "','" + xmodelodetallet.getValueAt(y, 12) + "')";
                            this.xct.ejecutarSQL(this.xsql);
                            this.xct.cerrarConexionBd();
                            if (!vector.isEmpty() && Integer.parseInt(JTDatosDetMedicamentos.getValueAt(y, 6).toString()) != -1) {
                                HOrdenesUnidosis idOrden = new HOrdenesUnidosis();
                                ISuministro idSuministro = new ISuministro();
                                idOrden.setId(Long.valueOf(this.JLBNRegistro.getText()));
                                idSuministro.setId(Long.valueOf(xmodelodetallet.getValueAt(y, 0).toString()));
                                HOrdenesUnidosisDetalle itemordenessum = this.iHOrdenesUnidosisDetalleService.detalleItemOrdenUnidosis(idOrden, idSuministro);
                                new ArrayList();
                                System.out.println("Antes ");
                                List<HOrdenesUnidosisDetalleRespuestacuestionario> list = (List) vector.get(Integer.valueOf(JTDatosDetMedicamentos.getValueAt(y, 6).toString()).intValue());
                                list.forEach(value -> {
                                    value.setIdItemOrdenSuministroUnidosis(itemordenessum);
                                    System.out.println("" + value.getId());
                                });
                                new ArrayList();
                                new ArrayList();
                                List<HOrdenesUnidosisDetalleRespuestacuestionario> listNueva = this.iHOrdenesUnidosisDetalleRespuestacuestionarioService.grabar(list);
                                List<HOrdenesUnidosisDetalleRespuestacuestionario> listNueva1 = this.iHOrdenesUnidosisDetalleRespuestacuestionarioService.listaRespuestaCuestionarioIdOrdenUnidosisItemsSuminitro(listNueva.get(0).getIdItemOrdenSuministroUnidosis().getId());
                                if (!listNueva1.isEmpty()) {
                                    for (HOrdenesUnidosisDetalleRespuestacuestionario hItemordenessumRespuestacuestionario : listNueva1) {
                                        if (!Objects.equals(hItemordenessumRespuestacuestionario.getIdTipoRespuestaCuestionario().getSoTipoPreguntas().getId(), this.idPregunta)) {
                                            this.idPregunta = hItemordenessumRespuestacuestionario.getIdTipoRespuestaCuestionario().getSoTipoPreguntas().getId();
                                            switch (hItemordenessumRespuestacuestionario.getIdTipoRespuestaCuestionario().getSoTipoRespuesta().getTipo().intValue()) {
                                                case 1:
                                                    this.cuerpoMensaje += hItemordenessumRespuestacuestionario.getIdTipoRespuestaCuestionario().getSoTipoPreguntas().getNbre() + "\n\t-" + hItemordenessumRespuestacuestionario.getObservacion() + "\n\n";
                                                    break;
                                                default:
                                                    String observacion = "";
                                                    if (!hItemordenessumRespuestacuestionario.getObservacion().isEmpty()) {
                                                        observacion = "\nObservación : " + hItemordenessumRespuestacuestionario.getObservacion();
                                                    }
                                                    this.cuerpoMensaje += hItemordenessumRespuestacuestionario.getIdTipoRespuestaCuestionario().getSoTipoPreguntas().getNbre() + "\n\t-" + hItemordenessumRespuestacuestionario.getIdTipoRespuestaCuestionario().getSoTipoRespuesta().getNbre() + observacion + "\n\n";
                                                    break;
                                            }
                                        } else {
                                            switch (hItemordenessumRespuestacuestionario.getIdTipoRespuestaCuestionario().getSoTipoRespuesta().getTipo().intValue()) {
                                                case 1:
                                                    this.cuerpoMensaje += "\n\t-" + hItemordenessumRespuestacuestionario.getObservacion() + "\n\n";
                                                    break;
                                                default:
                                                    String observacion2 = "";
                                                    if (!hItemordenessumRespuestacuestionario.getObservacion().isEmpty()) {
                                                        observacion2 = "\nObservación : " + hItemordenessumRespuestacuestionario.getObservacion();
                                                    }
                                                    this.cuerpoMensaje += "\n\t-" + hItemordenessumRespuestacuestionario.getIdTipoRespuestaCuestionario().getSoTipoRespuesta().getNbre() + observacion2 + "\n\n";
                                                    break;
                                            }
                                        }
                                    }
                                }
                            }
                            listDetalles.add(detalle);
                        }
                        if (!Principal.informacionIps.getIdentificacion().equals("812005644") || !Principal.informacionIps.getIdentificacion().equals("812004304")) {
                            ordenamientoMedico.setDetalleOrden(listDetalles);
                            this.xmt.getGrabarOrdenamientoMedico(ordenamientoMedico);
                        }
                        mCargarDatosH();
                        return;
                    }
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Registro ya grabado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "<html><P ALIGN=center> <font face='Arial' color='red' size=4>  <b>Ingreso con liquidación de servicios cerrada, no se podrán registrar más cargos;</p><font face='Arial' color='red' size=4>Informar al departamento de facturación", "VERIFICACIÓN DE LIQUIDACIÓN", 2, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Warning.png"))));
    }

    public void mImprimir() {
        String[][] mparametros = new String[5][2];
        mparametros[0][0] = "id";
        mparametros[0][1] = this.JLBNRegistro.getText();
        mparametros[1][0] = "nusuarios";
        mparametros[1][1] = Principal.usuarioSistemaDTO.getLogin();
        mparametros[2][0] = "SUBREPORT_DIR";
        mparametros[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
        mparametros[3][0] = "SUBREPORTFIRMA_DIR";
        mparametros[3][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
        mparametros[4][0] = "nbreUsuario";
        mparametros[4][1] = Principal.usuarioSistemaDTO.getNombreUsuario();
        if (Principal.informacionIps.getNombreIps().equals("CLINICA PAJONAL S.A.S") || Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JUAN DE DIOS") || Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JORGE DE AYAPEL") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO CAMU CHIMA")) {
            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "Pajonal_H_ordene_unidosis", mparametros);
        } else {
            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "H_ordene_unidosis", mparametros);
        }
    }

    public void mAnular() {
        if (this.JTDetalleH.getSelectedRow() != -1) {
            if (!Boolean.valueOf(this.xmodeloH.getValueAt(this.JTDetalleH.getSelectedRow(), 6).toString()).booleanValue()) {
                int n = JOptionPane.showInternalOptionDialog(this, "Esta seguro de anular la orden", "ANULAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), (Object[]) null, 0);
                if (n == 0) {
                    String sql = "UPDATE h_ordenes_unidosis SET Estado = 0 WHERE Id = '" + this.xmodeloH.getValueAt(this.JTDetalleH.getSelectedRow(), 0) + "'";
                    this.xct.ejecutarSQL(sql);
                    this.xct.cerrarConexionBd();
                    mCargarDatosH();
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Orden ya aplicada.\nNo se puede anular", "ANULAR ORDEN", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
        }
    }
}
